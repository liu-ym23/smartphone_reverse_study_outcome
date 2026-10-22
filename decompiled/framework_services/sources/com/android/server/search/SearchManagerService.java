package com.android.server.search;

import android.app.ISearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SearchManagerService extends ISearchManager.Stub {
    private static final String TAG = "SearchManagerService";
    private final Context mContext;
    final Handler mHandler;
    private final MyPackageMonitor mMyPackageMonitor;
    private final SparseArray<Searchables> mSearchables;
    private final UserManagerInternal mUserManagerInternal;

    class GlobalSearchProviderObserver extends ContentObserver {
        private final ContentResolver mResolver;
        final /* synthetic */ SearchManagerService this$0;

        public GlobalSearchProviderObserver(SearchManagerService this$0, ContentResolver resolver) {
            this.this$0 = this$0;
            super(null);
            this.mResolver = resolver;
            this.mResolver.registerContentObserver(Settings.Secure.getUriFor("search_global_search_activity"), false, this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            SparseArray r0 = SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L16:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (i >= SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0).size()) goto L11;
            ((Searchables) SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0).valueAt(i)).invalidateSearchableList();     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L16
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
            Intent intent = new Intent("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED");
            intent.addFlags(536870912);
            SearchManagerService.m8009$$Nest$fgetmContext(this.this$0).sendBroadcastAsUser(intent, UserHandle.ALL);
        }
    }

    public static class Lifecycle extends SystemService {
        private SearchManagerService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new SearchManagerService(getContext());
            publishBinderService("search", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            SearchManagerService.m8011$$Nest$monCleanupUser(this.mService, user.getUserIdentifier());
        }
    }

    class MyPackageMonitor extends PackageMonitor {
        private final ArrayList<String> mChangedPackages;
        private boolean mSearchablePackageAppeared;
        final /* synthetic */ SearchManagerService this$0;

        MyPackageMonitor(SearchManagerService this$0) {
            this.this$0 = this$0;
            this.mChangedPackages = new ArrayList();
            this.mSearchablePackageAppeared = false;
        }

        public void onBeginPackageChanges() {
            clearPackageChangeState();
        }

        public void onPackageAppeared(String packageName, int reason) {
            if (this.mSearchablePackageAppeared == true) goto L5;
            this.mSearchablePackageAppeared = hasSearchableForPackage(packageName, getChangingUserId());
        L5:
            this.mChangedPackages.add(packageName);
        }

        public void onPackageDisappeared(String packageName, int reason) {
            this.mChangedPackages.add(packageName);
        }

        public void onPackageModified(String packageName) {
            this.mChangedPackages.add(packageName);
        }

        public void onFinishPackageChanges() {
            onFinishPackageChangesInternal();
            clearPackageChangeState();
        }

        private void clearPackageChangeState() {
            this.mChangedPackages.clear();
            this.mSearchablePackageAppeared = false;
        }

        private boolean hasSearchableForPackage(String packageName, int userId) {
            List<ResolveInfo> searchList = SearchManagerService.querySearchableActivities(SearchManagerService.m8009$$Nest$fgetmContext(this.this$0), new Intent("android.intent.action.SEARCH").setPackage(packageName), userId);
            if (searchList.isEmpty() == true) goto L5;
            return true;
        L5:
            List<ResolveInfo> webSearchList = SearchManagerService.querySearchableActivities(SearchManagerService.m8009$$Nest$fgetmContext(this.this$0), new Intent("android.intent.action.WEB_SEARCH").setPackage(packageName), userId);
            if (webSearchList.isEmpty() == true) goto L8;
            return true;
        L8:
            List<ResolveInfo> globalSearchList = SearchManagerService.querySearchableActivities(SearchManagerService.m8009$$Nest$fgetmContext(this.this$0), new Intent("android.search.action.GLOBAL_SEARCH").setPackage(packageName), userId);
            return true ^ globalSearchList.isEmpty();
        }

        private boolean shouldRebuildSearchableList(int changingUserId) {
            if (this.mSearchablePackageAppeared == false) goto L5;
            return true;
        L5:
            ArraySet<String> knownSearchablePackageNames = new ArraySet();
            SparseArray r2 = SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0);
            monitor-enter(r2);
            Searchables searchables = (Searchables) SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0).get(changingUserId);     // Catch: Throwable -> L10
            if (searchables == null) goto L12;
            knownSearchablePackageNames = searchables.getKnownSearchablePackageNames();     // Catch: Throwable -> L10
        L12:
            monitor-exit(r2);     // Catch: Throwable -> L10
            int numOfPackages = this.mChangedPackages.size();
            int i = 0;
        L14:
            if (i >= numOfPackages) goto L19;
            String packageName = this.mChangedPackages.get(i);
            if (knownSearchablePackageNames.contains(packageName) == true) goto L17;
            i = i + 1;
            goto L14
        L17:
            return true;
        L19:
            return false;
        L10:
            th = move-exception;
            throw th;
        }

        private void onFinishPackageChangesInternal() {
            int changingUserId = getChangingUserId();
            if (shouldRebuildSearchableList(changingUserId) == true) goto L5;
            return;
        L5:
            SparseArray r1 = SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0);
            monitor-enter(r1);
            Searchables searchables = (Searchables) SearchManagerService.m8010$$Nest$fgetmSearchables(this.this$0).get(changingUserId);     // Catch: Throwable -> L10
            if (searchables == null) goto L12;
            searchables.invalidateSearchableList();     // Catch: Throwable -> L10
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L10
            Intent intent = new Intent("android.search.action.SEARCHABLES_CHANGED");
            intent.addFlags(603979776);
            SearchManagerService.m8009$$Nest$fgetmContext(this.this$0).sendBroadcastAsUser(intent, new UserHandle(changingUserId));
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8009$$Nest$fgetmContext(SearchManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSearchables, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8010$$Nest$fgetmSearchables(SearchManagerService r0) {
        return r0.mSearchables;
    }

    /* JADX INFO: renamed from: -$$Nest$monCleanupUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8011$$Nest$monCleanupUser(SearchManagerService r0, int r1) {
        r0.onCleanupUser(r1);
    }

    public SearchManagerService(Context context) {
        this.mSearchables = new SparseArray();
        this.mContext = context;
        this.mMyPackageMonitor = new MyPackageMonitor(this);
        this.mMyPackageMonitor.register(context, null, UserHandle.ALL, true);
        new GlobalSearchProviderObserver(this, context.getContentResolver());
        this.mHandler = BackgroundThread.getHandler();
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    private Searchables getSearchables(int userId) {
        long token = Binder.clearCallingIdentity();
        UserManager um = (UserManager) this.mContext.getSystemService(UserManager.class);     // Catch: Throwable -> L21
        if (um.getUserInfo(userId) == null) goto L24;
        if (um.isUserUnlockingOrUnlocked(userId) == false) goto L20;
        Binder.restoreCallingIdentity(token);
        SparseArray<Searchables> r3 = this.mSearchables;
        monitor-enter(r3);
        Searchables searchables = this.mSearchables.get(userId);     // Catch: Throwable -> L12
        if (searchables != null) goto L14;
        searchables = new Searchables(this.mContext, userId);     // Catch: Throwable -> L12
        this.mSearchables.put(userId, searchables);     // Catch: Throwable -> L12
    L14:
        searchables.updateSearchableListIfNeeded();     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        return searchables;
    L12:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalStateException("User " + userId + " isn't unlocked");     // Catch: Throwable -> L21
    L24:
        throw new IllegalStateException("User " + userId + " doesn't exist");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void onCleanupUser(int userId) {
        SparseArray<Searchables> r0 = this.mSearchables;
        monitor-enter(r0);
        this.mSearchables.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static List<ResolveInfo> querySearchableActivities(Context context, Intent searchIntent, int userId) {
        List<ResolveInfo> activities = context.getPackageManager().queryIntentActivitiesAsUser(searchIntent, 276824192, userId);
        return activities;
    }

    public SearchableInfo getSearchableInfo(ComponentName launchActivity) {
        if (launchActivity != null) goto L6;
        Log.e(TAG, "getSearchableInfo(), activity == null");
        return null;
    L6:
        return getSearchables(UserHandle.getCallingUserId()).getSearchableInfo(launchActivity);
    }

    public List<SearchableInfo> getSearchablesInGlobalSearch() {
        return getSearchables(UserHandle.getCallingUserId()).getSearchablesInGlobalSearchList();
    }

    public List<ResolveInfo> getGlobalSearchActivities() {
        return getSearchables(UserHandle.getCallingUserId()).getGlobalSearchActivities();
    }

    public ComponentName getGlobalSearchActivity() {
        return getSearchables(UserHandle.getCallingUserId()).getGlobalSearchActivity();
    }

    public ComponentName getWebSearchActivity() {
        return getSearchables(UserHandle.getCallingUserId()).getWebSearchActivity();
    }

    public void launchAssist(int userHandle, Bundle args) {
        int callingUserId = UserHandle.getCallingUserId();
        if (this.mUserManagerInternal.isVisibleBackgroundFullUser(callingUserId) == true) goto L9;
        StatusBarManagerInternal statusBarManager = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        if (statusBarManager == null) goto L10;
        statusBarManager.startAssist(args);
        return;
    L10:
        return;
    L9:
        throw new SecurityException("Visible background user(u" + callingUserId + ") is not permitted to launch assist.");
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        PrintWriter r0 = new IndentingPrintWriter(pw, "  ");
        SparseArray<Searchables> r1 = this.mSearchables;
        monitor-enter(r1);
        int i = 0;
    L18:
    L11:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mSearchables.size()) goto L14;
        r0.print("\nUser: ");     // Catch: Throwable -> L11
        r0.println(this.mSearchables.keyAt(i));     // Catch: Throwable -> L11
        r0.increaseIndent();     // Catch: Throwable -> L11
        this.mSearchables.valueAt(i).dump(fd, r0, args);     // Catch: Throwable -> L11
        r0.decreaseIndent();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L11
    }
}
