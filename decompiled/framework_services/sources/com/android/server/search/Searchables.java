package com.android.server.search;

import android.app.AppGlobals;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import com.android.server.LocalServices;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Searchables {
    public static String ENHANCED_GOOGLE_SEARCH_COMPONENT_NAME = null;
    private static final Comparator<ResolveInfo> GLOBAL_SEARCH_RANKER = null;
    public static String GOOGLE_SEARCH_COMPONENT_NAME = null;
    private static final String LOG_TAG = "Searchables";
    private static final String MD_LABEL_DEFAULT_SEARCHABLE = "android.app.default_searchable";
    private static final String MD_SEARCHABLE_SYSTEM_SEARCH = "*";
    private Context mContext;
    private ComponentName mCurrentGlobalSearchActivity;
    private List<ResolveInfo> mGlobalSearchActivities;
    private ArraySet<String> mKnownSearchablePackageNames;
    private final IPackageManager mPm;
    private boolean mRebuildSearchables;
    private ArrayList<SearchableInfo> mSearchablesInGlobalSearchList;
    private ArrayList<SearchableInfo> mSearchablesList;
    private HashMap<ComponentName, SearchableInfo> mSearchablesMap;
    private int mUserId;
    private ComponentName mWebSearchActivity;

    /* JADX INFO: renamed from: -$$Nest$smisSystemApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8012$$Nest$smisSystemApp(ResolveInfo r0) {
        return isSystemApp(r0);
    }

    static {
        GOOGLE_SEARCH_COMPONENT_NAME = "com.android.googlesearch/.GoogleSearch";
        ENHANCED_GOOGLE_SEARCH_COMPONENT_NAME = "com.google.android.providers.enhancedgooglesearch/.Launcher";
        GLOBAL_SEARCH_RANKER = new AnonymousClass1();
    }

    public Searchables(Context context, int userId) {
        this.mSearchablesMap = null;
        this.mSearchablesList = null;
        this.mSearchablesInGlobalSearchList = null;
        this.mCurrentGlobalSearchActivity = null;
        this.mWebSearchActivity = null;
        this.mRebuildSearchables = true;
        this.mKnownSearchablePackageNames = new ArraySet();
        this.mContext = context;
        this.mUserId = userId;
        this.mPm = AppGlobals.getPackageManager();
    }

    public SearchableInfo getSearchableInfo(ComponentName activity) {
        monitor-enter(this);
        SearchableInfo result = this.mSearchablesMap.get(activity);     // Catch: Throwable -> L9
        if (result == null) goto L13;
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L9
        if (pm.canAccessComponent(Binder.getCallingUid(), result.getSearchActivity(), UserHandle.getCallingUserId()) == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return result;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return null;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L9
        ActivityInfo ai = this.mPm.getActivityInfo(activity, 128, this.mUserId);     // Catch: RemoteException -> L48
        if (ai != null) goto L18;
        return null;
    L18:
        String refActivityName = null;
        Bundle md = ai.metaData;
        if (md == null) goto L21;
        refActivityName = md.getString(MD_LABEL_DEFAULT_SEARCHABLE);
    L21:
        if (refActivityName != null) goto L25;
        Bundle md2 = ai.applicationInfo.metaData;
        if (md2 == null) goto L25;
        refActivityName = md2.getString(MD_LABEL_DEFAULT_SEARCHABLE);
    L25:
        if (refActivityName != null) goto L27;
    L47:
        return null;
    L27:
        if (refActivityName.equals("*") == false) goto L29;
        return null;
    L29:
        String pkg = activity.getPackageName();
        if (refActivityName.charAt(0) != '.') goto L32;
        ComponentName referredActivity = new ComponentName(pkg, pkg + refActivityName);
    L33:
        monitor-enter(this);
        SearchableInfo result2 = this.mSearchablesMap.get(referredActivity);     // Catch: Throwable -> L37
        if (result2 == null) goto L39;
        this.mSearchablesMap.put(activity, result2);     // Catch: Throwable -> L37
    L39:
        monitor-exit(this);     // Catch: Throwable -> L37
        if (result2 == null) goto L47;
        PackageManagerInternal pm2 = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (pm2.canAccessComponent(Binder.getCallingUid(), result2.getSearchActivity(), UserHandle.getCallingUserId()) == false) goto L44;
        return result2;
    L44:
        return null;
    L37:
        th = move-exception;
        throw th;
    L32:
        referredActivity = new ComponentName(pkg, refActivityName);
    L48:
        re = move-exception;
        Log.e(LOG_TAG, "Error getting activity info " + re);
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public void updateSearchableListIfNeeded() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRebuildSearchables == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        HashMap<ComponentName, SearchableInfo> newSearchablesMap = new HashMap();
        ArrayList<SearchableInfo> newSearchablesList = new ArrayList();
        ArrayList<SearchableInfo> newSearchablesInGlobalSearchList = new ArrayList();
        ArraySet<String> newKnownSearchablePackageNames = new ArraySet();
        Intent intent = new Intent("android.intent.action.SEARCH");
        long ident = Binder.clearCallingIdentity();
        List<ResolveInfo> searchList = queryIntentActivities(intent, 268435584);     // Catch: Throwable -> L47
        Intent webSearchIntent = new Intent("android.intent.action.WEB_SEARCH");     // Catch: Throwable -> L47
        List<ResolveInfo> webSearchInfoList = queryIntentActivities(webSearchIntent, 268435584);     // Catch: Throwable -> L47
        if (searchList != null) goto L17;
        if (webSearchInfoList != null) goto L17;
        long ident2 = ident;
    L50:
        List<ResolveInfo> newGlobalSearchActivities = findGlobalSearchActivities();     // Catch: Throwable -> L42
        ComponentName newGlobalSearchActivity = findGlobalSearchActivity(newGlobalSearchActivities);     // Catch: Throwable -> L42
        ComponentName newWebSearchActivity = findWebSearchActivity(newGlobalSearchActivity);     // Catch: Throwable -> L42
        monitor-enter(this);     // Catch: Throwable -> L42
        this.mSearchablesMap = newSearchablesMap;     // Catch: Throwable -> L56
        this.mSearchablesList = newSearchablesList;     // Catch: Throwable -> L56
        this.mKnownSearchablePackageNames = newKnownSearchablePackageNames;     // Catch: Throwable -> L56
        this.mSearchablesInGlobalSearchList = newSearchablesInGlobalSearchList;     // Catch: Throwable -> L56
        this.mGlobalSearchActivities = newGlobalSearchActivities;     // Catch: Throwable -> L56
        this.mCurrentGlobalSearchActivity = newGlobalSearchActivity;     // Catch: Throwable -> L56
        this.mWebSearchActivity = newWebSearchActivity;     // Catch: Throwable -> L56
        Iterator<ResolveInfo> r0 = this.mGlobalSearchActivities.iterator();     // Catch: Throwable -> L56
    L54:
        if (r0.hasNext() == false) goto L59;
        ResolveInfo globalSearchActivity = r0.next();     // Catch: Throwable -> L56
        this.mKnownSearchablePackageNames.add(globalSearchActivity.getComponentInfo().packageName);     // Catch: Throwable -> L56
        goto L54
    L59:
        if (this.mCurrentGlobalSearchActivity == null) goto L62;
        this.mKnownSearchablePackageNames.add(this.mCurrentGlobalSearchActivity.getPackageName());     // Catch: Throwable -> L56
    L62:
        if (this.mWebSearchActivity == null) goto L64;
        this.mKnownSearchablePackageNames.add(this.mWebSearchActivity.getPackageName());     // Catch: Throwable -> L56
    L64:
        this.mRebuildSearchables = false;     // Catch: Throwable -> L56
        monitor-exit(this);     // Catch: Throwable -> L56
        Binder.restoreCallingIdentity(ident2);
        return;
    L56:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = th;
    L70:
        Binder.restoreCallingIdentity(ident2);
        throw th;
    L17:
        if (searchList != null) goto L19;
        int search_count = 0;
    L20:
        if (webSearchInfoList != null) goto L22;
        int web_search_count = 0;
    L23:
        int count = search_count + web_search_count;
        int ii = 0;
    L24:
        if (ii >= count) goto L49;
        if (ii >= search_count) goto L31;
        ResolveInfo info = searchList.get(ii);     // Catch: Throwable -> L28
    L32:
        Intent intent2 = intent;
        ActivityInfo ai = info.activityInfo;     // Catch: Throwable -> L45
        ident2 = ident;
        if (newSearchablesMap.get(new ComponentName(ai.packageName, ai.name)) != null) goto L44;
        SearchableInfo searchable = SearchableInfo.getActivityMetaData(this.mContext, ai, this.mUserId);     // Catch: Throwable -> L42
        if (searchable == null) goto L44;
        newSearchablesList.add(searchable);     // Catch: Throwable -> L42
        newKnownSearchablePackageNames.add(ai.packageName);     // Catch: Throwable -> L42
        newSearchablesMap.put(searchable.getSearchActivity(), searchable);     // Catch: Throwable -> L42
        if (searchable.shouldIncludeInGlobalSearch() == false) goto L44;
        newSearchablesInGlobalSearchList.add(searchable);     // Catch: Throwable -> L42
    L44:
        ii = ii + 1;     // Catch: Throwable -> L42
        intent = intent2;
        ident = ident2;
    L45:
        th = th;
        ident2 = ident;
    L28:
        th = th;
        ident2 = ident;
        goto L70
    L31:
        info = webSearchInfoList.get(ii - search_count);     // Catch: Throwable -> L47
        goto L32
    L49:
        ident2 = ident;
        goto L50
    L22:
        web_search_count = webSearchInfoList.size();     // Catch: Throwable -> L47
        goto L23
    L19:
        search_count = searchList.size();     // Catch: Throwable -> L47
    L47:
        th = th;
        ident2 = ident;
        goto L70
    }

    synchronized ArraySet<String> getKnownSearchablePackageNames() {
        monitor-enter(this);
        ArraySet<String> r0 = this.mKnownSearchablePackageNames;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void invalidateSearchableList() {
        monitor-enter(this);
        this.mRebuildSearchables = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private List<ResolveInfo> findGlobalSearchActivities() {
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        List<ResolveInfo> activities = queryIntentActivities(intent, 268500992);
        if (activities != null) goto L5;
    L7:
        return activities;
    L5:
        if (activities.isEmpty() == true) goto L7;
        Collections.sort(activities, GLOBAL_SEARCH_RANKER);
        goto L7
    }

    private ComponentName findGlobalSearchActivity(List<ResolveInfo> installed) {
        String searchProviderSetting = getGlobalSearchProviderSetting();
        if (TextUtils.isEmpty(searchProviderSetting) == true) goto L10;
        ComponentName globalSearchComponent = ComponentName.unflattenFromString(searchProviderSetting);
        if (globalSearchComponent == null) goto L10;
        if (isInstalled(globalSearchComponent) == false) goto L10;
        return globalSearchComponent;
    L10:
        return getDefaultGlobalSearchProvider(installed);
    }

    private boolean isInstalled(ComponentName globalSearch) {
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        intent.setComponent(globalSearch);
        List<ResolveInfo> activities = queryIntentActivities(intent, 65536);
        if (activities != null) goto L5;
        return false;
    L5:
        if (activities.isEmpty() == true) goto L10;
        return true;
    L10:
        return false;
    }

    private static final boolean isSystemApp(ResolveInfo res) {
        if ((res.activityInfo.applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private ComponentName getDefaultGlobalSearchProvider(List<ResolveInfo> providerList) {
        if (providerList != null) goto L4;
    L7:
        Log.w(LOG_TAG, "No global search activity found");
        return null;
    L4:
        if (providerList.isEmpty() == true) goto L7;
        ActivityInfo ai = providerList.get(0).activityInfo;
        return new ComponentName(ai.packageName, ai.name);
    }

    private String getGlobalSearchProviderSetting() {
        ContentResolver cr = this.mContext.getContentResolver();
        return Settings.Secure.getStringForUser(cr, "search_global_search_activity", cr.getUserId());
    }

    private ComponentName findWebSearchActivity(ComponentName globalSearchActivity) {
        if (globalSearchActivity != null) goto L5;
        return null;
    L5:
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        intent.setPackage(globalSearchActivity.getPackageName());
        List<ResolveInfo> activities = queryIntentActivities(intent, 65536);
        if (activities != null) goto L8;
    L11:
        Log.w(LOG_TAG, "No web search activity found");
        return null;
    L8:
        if (activities.isEmpty() == true) goto L11;
        ActivityInfo ai = activities.get(0).activityInfo;
        return new ComponentName(ai.packageName, ai.name);
    }

    private List<ResolveInfo> queryIntentActivities(Intent intent, int flags) {
        List<ResolveInfo> activities = this.mPm.queryIntentActivities(intent, intent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 8388608 | flags, this.mUserId).getList();     // Catch: RemoteException -> L7
        return activities;
    L17:
        return null;
    L11:
        return null;
    }

    public synchronized ArrayList<SearchableInfo> getSearchablesList() {
        monitor-enter(this);
        ArrayList<SearchableInfo> r0 = createFilterdSearchableInfoList(this.mSearchablesList);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<SearchableInfo> getSearchablesInGlobalSearchList() {
        monitor-enter(this);
        ArrayList<SearchableInfo> r0 = createFilterdSearchableInfoList(this.mSearchablesInGlobalSearchList);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<ResolveInfo> getGlobalSearchActivities() {
        monitor-enter(this);
        ArrayList<ResolveInfo> r0 = createFilterdResolveInfoList(this.mGlobalSearchActivities);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private ArrayList<SearchableInfo> createFilterdSearchableInfoList(List<SearchableInfo> list) {
        if (list != null) goto L5;
        return null;
    L5:
        ArrayList<SearchableInfo> resultList = new ArrayList(list.size());
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getCallingUserId();
        Iterator<SearchableInfo> r4 = list.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        SearchableInfo info = r4.next();
        if (pm.canAccessComponent(callingUid, info.getSearchActivity(), callingUserId) == false) goto L7;
        resultList.add(info);
        goto L7
    L12:
        return resultList;
    }

    private ArrayList<ResolveInfo> createFilterdResolveInfoList(List<ResolveInfo> list) {
        if (list != null) goto L5;
        return null;
    L5:
        ArrayList<ResolveInfo> resultList = new ArrayList(list.size());
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getCallingUserId();
        Iterator<ResolveInfo> r4 = list.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        ResolveInfo info = r4.next();
        if (pm.canAccessComponent(callingUid, info.activityInfo.getComponentName(), callingUserId) == false) goto L7;
        resultList.add(info);
        goto L7
    L12:
        return resultList;
    }

    public synchronized ComponentName getGlobalSearchActivity() {
        monitor-enter(this);
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L10
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L10
        int callingUserId = UserHandle.getCallingUserId();     // Catch: Throwable -> L10
        if (this.mCurrentGlobalSearchActivity != null) goto L6;
    L12:
        monitor-exit(this);
        return null;
    L6:
        if (pm.canAccessComponent(callingUid, this.mCurrentGlobalSearchActivity, callingUserId) == false) goto L12;
        ComponentName r3 = this.mCurrentGlobalSearchActivity;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized ComponentName getWebSearchActivity() {
        monitor-enter(this);
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L10
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L10
        int callingUserId = UserHandle.getCallingUserId();     // Catch: Throwable -> L10
        if (this.mWebSearchActivity != null) goto L6;
    L12:
        monitor-exit(this);
        return null;
    L6:
        if (pm.canAccessComponent(callingUid, this.mWebSearchActivity, callingUserId) == false) goto L12;
        ComponentName r3 = this.mWebSearchActivity;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.println("Searchable authorities:");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSearchablesList == null) goto L12;
        Iterator<SearchableInfo> r0 = this.mSearchablesList.iterator();     // Catch: Throwable -> L10
    L8:
        if (r0.hasNext() == false) goto L12;
        SearchableInfo info = r0.next();     // Catch: Throwable -> L10
        pw.print("  ");     // Catch: Throwable -> L10
        pw.println(info.getSuggestAuthority());     // Catch: Throwable -> L10
    L12:
        pw.println("mRebuildSearchables = " + this.mRebuildSearchables);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }
}
