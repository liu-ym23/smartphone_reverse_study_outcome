package com.android.server.pm.resolution;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.AuxiliaryResolveInfo;
import android.content.pm.InstantAppResolveInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ComponentMutateUtils;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedComponent;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedProviderImpl;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.internal.util.ArrayUtils;
import com.android.server.IntentResolver;
import com.android.server.am.HostingRecord;
import com.android.server.pm.Computer;
import com.android.server.pm.PackageManagerException;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.PackageManagerTracedLock;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.UserNeedsBadgingCache;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUtils;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ComponentResolver extends ComponentResolverLocked implements Snappable<ComponentResolverApi> {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_FILTERS = false;
    private static final boolean DEBUG_SHOW_INFO = false;
    private static final Set<String> PROTECTED_ACTIONS = null;
    public static final Comparator<ResolveInfo> RESOLVE_PRIORITY_SORTER = null;
    private static final String TAG = "PackageManager";
    boolean mDeferProtectedFilters;
    List<Pair<ParsedMainComponent, ParsedIntentInfo>> mProtectedFilters;
    private final ComponentResolverSmtEx mSmtEx;
    final SnapshotCache<ComponentResolverApi> mSnapshot;

    public static class ActivityIntentResolver extends MimeGroupsAwareIntentResolver<Pair<ParsedActivity, ParsedIntentInfo>, ResolveInfo> {
        protected final ArrayMap<ComponentName, ParsedActivity> mActivities;
        private final ComponentResolverSmtEx.ActivityIntentResolverSmtEx mSmtEx;
        private final UserNeedsBadgingCache mUserNeedsBadging;

        @Override // com.android.server.pm.resolution.ComponentResolver.MimeGroupsAwareIntentResolver
        public /* bridge */ /* synthetic */ void addFilter(PackageDataSnapshot r1, Pair r2) {
            super.addFilter(r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean allowFilterResult(Object r1, List r2) {
            return allowFilterResult((Pair) r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ void dumpFilter(PrintWriter r1, String r2, Object r3) {
            dumpFilter(r1, r2, (Pair) r3);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object filterToLabel(Object r1) {
            return filterToLabel((Pair) r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(Object r1) {
            return getIntentFilter((Pair) r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, Object r2) {
            return isPackageForFilter(r1, (Pair) r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object newResult(Computer r8, Object r9, int r10, int r11, long r12) {
            return newResult(r8, (Pair) r9, r10, r11, r12);
        }

        @Override // com.android.server.pm.resolution.ComponentResolver.MimeGroupsAwareIntentResolver
        public /* bridge */ /* synthetic */ boolean updateMimeGroup(Computer r1, String r2, String r3) {
            return super.updateMimeGroup(r1, r2, r3);
        }

        ActivityIntentResolver(UserManagerService userManager, UserNeedsBadgingCache userNeedsBadgingCache) {
            super(userManager);
            this.mActivities = new ArrayMap();
            this.mSmtEx = new ComponentResolverSmtEx.ActivityIntentResolverSmtEx();
            this.mUserNeedsBadging = userNeedsBadgingCache;
        }

        ActivityIntentResolver(ActivityIntentResolver orig, UserManagerService userManager, UserNeedsBadgingCache userNeedsBadgingCache) {
            super(orig, userManager);
            this.mActivities = new ArrayMap();
            this.mSmtEx = new ComponentResolverSmtEx.ActivityIntentResolverSmtEx();
            this.mActivities.putAll(orig.mActivities);
            this.mUserNeedsBadging = userNeedsBadgingCache;
        }

        @Override // com.android.server.IntentResolver
        public List<ResolveInfo> queryIntent(PackageDataSnapshot snapshot, Intent intent, String resolvedType, boolean defaultOnly, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return null;
        L6:
            if (defaultOnly == false) goto L8;
            int r0 = 65536;
        L9:
            long flags = r0;
            return super.queryIntent(snapshot, intent, resolvedType, defaultOnly, userId, flags);
        L8:
            r0 = 0;
            goto L9
        }

        List<ResolveInfo> queryIntent(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L7;
            return null;
        L7:
            if ((65536 & flags) == 0) goto L10;
            boolean r0 = true;
        L12:
            return super.queryIntent(computer, intent, resolvedType, r0, userId, flags);
        L10:
            r0 = false;
            goto L12
        }

        List<ResolveInfo> queryIntentForPackage(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedActivity> packageActivities, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return null;
        L6:
            if (packageActivities != null) goto L10;
            return Collections.emptyList();
        L10:
            if ((flags & 65536) == 0) goto L13;
            boolean r1 = true;
        L12:
            boolean defaultOnly = r1;
            int activitiesSize = packageActivities.size();
            ArrayList<Pair<ParsedActivity, ParsedIntentInfo>[]> listCut = new ArrayList(activitiesSize);
            int i = 0;
        L15:
            if (i >= activitiesSize) goto L25;
            ParsedActivity activity = packageActivities.get(i);
            List<ParsedIntentInfo> intentFilters = activity.getIntents();
            if (intentFilters.isEmpty() == true) goto L23;
            Pair<ParsedActivity, ParsedIntentInfo>[] array = newArray(intentFilters.size());
            int arrayIndex = 0;
        L20:
            if (arrayIndex >= intentFilters.size()) goto L22;
            array[arrayIndex] = Pair.create(activity, intentFilters.get(arrayIndex));
            arrayIndex = arrayIndex + 1;
            goto L20
        L22:
            listCut.add(array);
        L23:
            i = i + 1;
            goto L15
        L25:
            return super.queryIntentFromList(computer, intent, resolvedType, defaultOnly, listCut, userId, flags);
        L13:
            r1 = false;
            goto L12
        }

        protected void addActivity(Computer computer, ParsedActivity a, String type, List<Pair<ParsedActivity, ParsedIntentInfo>> newIntents) {
            this.mActivities.put(a.getComponentName(), a);
            int intentsSize = a.getIntents().size();
            int j = 0;
        L3:
            if (j >= intentsSize) goto L14;
            ParsedIntentInfo intent = (ParsedIntentInfo) a.getIntents().get(j);
            IntentFilter intentFilter = intent.getIntentFilter();
            if (newIntents == null) goto L10;
            if (HostingRecord.HOSTING_TYPE_ACTIVITY.equals(type) == false) goto L10;
            newIntents.add(Pair.create(a, intent));
        L10:
            if (intentFilter.debugCheck() == true) goto L12;
            Log.w("PackageManager", "==> For Activity " + a.getName());
        L12:
            addFilter(computer, Pair.create(a, intent));
            j = j + 1;
            goto L3
        }

        protected void removeActivity(ParsedActivity a, String type) {
            this.mActivities.remove(a.getComponentName());
            int intentsSize = a.getIntents().size();
            int j = 0;
        L3:
            if (j >= intentsSize) goto L6;
            ParsedIntentInfo intent = (ParsedIntentInfo) a.getIntents().get(j);
            intent.getIntentFilter();
            removeFilter(Pair.create(a, intent));
            j = j + 1;
            goto L3
        }

        protected boolean allowFilterResult(Pair<ParsedActivity, ParsedIntentInfo> filter, List<ResolveInfo> dest) {
            int i = dest.size() - 1;
        L3:
            if (i < 0) goto L12;
            ActivityInfo destAi = dest.get(i).activityInfo;
            if (Objects.equals(destAi.name, ((ParsedActivity) filter.first).getName()) == false) goto L10;
            if (Objects.equals(destAi.packageName, ((ParsedActivity) filter.first).getPackageName()) == false) goto L10;
            return false;
        L10:
            i = i - 1;
            goto L3
        L12:
            return true;
        }

        @Override // com.android.server.IntentResolver
        protected Pair<ParsedActivity, ParsedIntentInfo>[] newArray(int size) {
            return new Pair[size];
        }

        protected boolean isPackageForFilter(String packageName, Pair<ParsedActivity, ParsedIntentInfo> info) {
            return packageName.equals(((ParsedActivity) info.first).getPackageName());
        }

        private void log(String reason, ParsedIntentInfo info, int match, int userId) {
            Slog.w("PackageManager", reason + "; match: " + DebugUtils.flagsToString(IntentFilter.class, "MATCH_", match) + "; userId: " + userId + "; intent info: " + info);
        }

        protected ResolveInfo newResult(Computer computer, Pair<ParsedActivity, ParsedIntentInfo> pair, int match, int userId, long customFlags) {
            ParsedActivity activity = (ParsedActivity) pair.first;
            ParsedIntentInfo info = (ParsedIntentInfo) pair.second;
            IntentFilter intentFilter = info.getIntentFilter();
            if (this.mUserManager.exists(userId) == true) goto L5;
            return null;
        L5:
            PackageStateInternal packageState = computer.getPackageStateInternal(activity.getPackageName());
            if (packageState == null) goto L58;
            if (packageState.getPkg() == null) goto L58;
            if (PackageStateUtils.isEnabledAndMatches(packageState, activity, customFlags, userId) == false) goto L58;
            PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
            ActivityInfo ai = PackageInfoUtils.generateActivityInfo(packageState.getPkg(), activity, customFlags, userState, userId, packageState);
            if (ai != null) goto L15;
            return null;
        L15:
            boolean matchInstantApp = false;
            if ((customFlags & 33554432) == 0) goto L18;
            boolean matchExplicitlyVisibleOnly = true;
        L20:
            if ((customFlags & 16777216) == 0) goto L22;
            boolean matchVisibleToInstantApp = true;
        L23:
            if (matchVisibleToInstantApp == true) goto L25;
        L30:
            boolean componentVisible = false;
        L32:
            if ((customFlags & 8388608) == 0) goto L34;
            matchInstantApp = true;
        L34:
            if (matchVisibleToInstantApp == false) goto L39;
            if (componentVisible == true) goto L39;
            if (userState.isInstantApp() == true) goto L39;
            return null;
        L39:
            if (matchInstantApp == true) goto L44;
            if (userState.isInstantApp() == false) goto L44;
            return null;
        L44:
            if (userState.isInstantApp() == true) goto L46;
        L48:
            ResolveInfo res = new ResolveInfo(intentFilter.hasCategory("android.intent.category.BROWSABLE"));
            res.activityInfo = ai;
            if ((customFlags & 64) == 0) goto L51;
            res.filter = intentFilter;
        L51:
            res.handleAllWebDataURI = intentFilter.handleAllWebDataURI();
            res.priority = intentFilter.getPriority();
            res.match = match;
            res.isDefault = info.isHasDefault();
            res.labelRes = info.getLabelRes();
            res.nonLocalizedLabel = info.getNonLocalizedLabel();
            if (this.mUserNeedsBadging.get(userId) == false) goto L54;
            res.noResourceId = true;
        L55:
            res.iconResourceId = info.getIcon();
            res.system = res.activityInfo.applicationInfo.isSystemApp();
            res.isInstantAppAvailable = userState.isInstantApp();
            res.userHandle = UserHandle.of(userId);
            ComponentResolverSmtEx.setChosenPriority(userId, activity, res, getSmtEx().mSettings);
            return res;
        L54:
            res.icon = info.getIcon();
            goto L55
        L46:
            if (packageState.isUpdateAvailable() == false) goto L48;
            return null;
        L25:
            if (intentFilter.isVisibleToInstantApp() == false) goto L30;
            if (matchExplicitlyVisibleOnly == true) goto L28;
        L29:
            componentVisible = true;
            goto L32
        L28:
            if (intentFilter.isExplicitlyVisibleToInstantApp() == false) goto L30;
        L22:
            matchVisibleToInstantApp = false;
            goto L23
        L18:
            matchExplicitlyVisibleOnly = false;
        L58:
            return null;
        }

        @Override // com.android.server.IntentResolver
        protected void sortResults(List<ResolveInfo> results) {
            results.sort(ComponentResolver.RESOLVE_PRIORITY_SORTER);
        }

        protected void dumpFilter(PrintWriter out, String prefix, Pair<ParsedActivity, ParsedIntentInfo> pair) {
            ParsedActivity activity = (ParsedActivity) pair.first;
            ParsedIntentInfo filter = (ParsedIntentInfo) pair.second;
            out.print(prefix);
            out.print(Integer.toHexString(System.identityHashCode(activity)));
            out.print(' ');
            ComponentName.printShortString(out, activity.getPackageName(), activity.getClassName());
            out.print(" filter ");
            out.println(Integer.toHexString(System.identityHashCode(filter)));
        }

        protected Object filterToLabel(Pair<ParsedActivity, ParsedIntentInfo> filter) {
            return filter;
        }

        @Override // com.android.server.IntentResolver
        protected void dumpFilterLabel(PrintWriter out, String prefix, Object label, int count) {
            Pair<ParsedActivity, ParsedIntentInfo> pair = (Pair) label;
            out.print(prefix);
            out.print(Integer.toHexString(System.identityHashCode(pair.first)));
            out.print(' ');
            ComponentName.printShortString(out, ((ParsedActivity) pair.first).getPackageName(), ((ParsedActivity) pair.first).getClassName());
            if (count <= 1) goto L5;
            out.print(" (");
            out.print(count);
            out.print(" filters)");
        L5:
            out.println();
        }

        protected IntentFilter getIntentFilter(Pair<ParsedActivity, ParsedIntentInfo> input) {
            return ((ParsedIntentInfo) input.second).getIntentFilter();
        }

        protected List<ParsedActivity> getResolveList(AndroidPackage pkg) {
            return pkg.getActivities();
        }

        public ComponentResolverSmtEx.ActivityIntentResolverSmtEx getSmtEx() {
            return this.mSmtEx;
        }
    }

    public static final class InstantAppIntentResolver extends IntentResolver<AuxiliaryResolveInfo.AuxiliaryFilter, AuxiliaryResolveInfo.AuxiliaryFilter> {
        final ArrayMap<String, Pair<Integer, InstantAppResolveInfo>> mOrderResult;
        private final UserManagerService mUserManager;

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(AuxiliaryResolveInfo.AuxiliaryFilter r1) {
            return getIntentFilter2(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, AuxiliaryResolveInfo.AuxiliaryFilter r2) {
            return isPackageForFilter2(r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ AuxiliaryResolveInfo.AuxiliaryFilter[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ AuxiliaryResolveInfo.AuxiliaryFilter newResult(Computer r8, AuxiliaryResolveInfo.AuxiliaryFilter r9, int r10, int r11, long r12) {
            return newResult2(r8, r9, r10, r11, r12);
        }

        public InstantAppIntentResolver(UserManagerService userManager) {
            this.mOrderResult = new ArrayMap();
            this.mUserManager = userManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.server.IntentResolver
        protected AuxiliaryResolveInfo.AuxiliaryFilter[] newArray(int size) {
            return new AuxiliaryResolveInfo.AuxiliaryFilter[size];
        }

        /* JADX INFO: renamed from: isPackageForFilter, reason: avoid collision after fix types in other method */
        protected boolean isPackageForFilter2(String packageName, AuxiliaryResolveInfo.AuxiliaryFilter responseObj) {
            return true;
        }

        /* JADX INFO: renamed from: newResult, reason: avoid collision after fix types in other method */
        protected AuxiliaryResolveInfo.AuxiliaryFilter newResult2(Computer computer, AuxiliaryResolveInfo.AuxiliaryFilter responseObj, int match, int userId, long customFlags) {
            if (this.mUserManager.exists(userId) == true) goto L5;
            return null;
        L5:
            String packageName = responseObj.resolveInfo.getPackageName();
            Integer order = Integer.valueOf(responseObj.getOrder());
            Pair<Integer, InstantAppResolveInfo> lastOrderResult = this.mOrderResult.get(packageName);
            if (lastOrderResult != null) goto L8;
        L10:
            InstantAppResolveInfo res = responseObj.resolveInfo;
            if (order.intValue() <= 0) goto L13;
            this.mOrderResult.put(packageName, new Pair(order, res));
        L13:
            return responseObj;
        L8:
            if (((Integer) lastOrderResult.first).intValue() < order.intValue()) goto L10;
            return null;
        }

        @Override // com.android.server.IntentResolver
        protected void filterResults(List<AuxiliaryResolveInfo.AuxiliaryFilter> results) {
            if (this.mOrderResult.size() != 0) goto L5;
            return;
        L5:
            int resultSize = results.size();
            int i = 0;
        L6:
            if (i >= resultSize) goto L17;
            InstantAppResolveInfo info = results.get(i).resolveInfo;
            String packageName = info.getPackageName();
            Pair<Integer, InstantAppResolveInfo> savedInfo = this.mOrderResult.get(packageName);
            if (savedInfo == null) goto L16;
            if (savedInfo.second != info) goto L15;
            this.mOrderResult.remove(packageName);
            if (this.mOrderResult.size() != 0) goto L16;
            return;
        L15:
            results.remove(i);
            resultSize = resultSize - 1;
            i = i - 1;
        L16:
            i = i + 1;
            goto L6
        }

        /* JADX INFO: renamed from: getIntentFilter, reason: avoid collision after fix types in other method */
        protected IntentFilter getIntentFilter2(AuxiliaryResolveInfo.AuxiliaryFilter input) {
            return input;
        }
    }

    private static abstract class MimeGroupsAwareIntentResolver<F extends Pair<? extends ParsedComponent, ParsedIntentInfo>, R> extends IntentResolver<F, R> {
        private boolean mIsUpdatingMimeGroup;
        private final ArrayMap<String, F[]> mMimeGroupToFilter;
        protected final UserManagerService mUserManager;

        @Override // com.android.server.IntentResolver
        public /* bridge */ /* synthetic */ void addFilter(PackageDataSnapshot r1, Object r2) {
            addFilter(r1, (Pair) r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean isFilterStopped(Computer r1, Object r2, int r3) {
            return isFilterStopped(r1, (Pair) r2, r3);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ void removeFilterInternal(Object r1) {
            removeFilterInternal((Pair) r1);
        }

        MimeGroupsAwareIntentResolver(UserManagerService userManager) {
            this.mMimeGroupToFilter = new ArrayMap();
            this.mIsUpdatingMimeGroup = false;
            this.mUserManager = userManager;
        }

        MimeGroupsAwareIntentResolver(MimeGroupsAwareIntentResolver<F, R> orig, UserManagerService userManager) {
            this.mMimeGroupToFilter = new ArrayMap();
            this.mIsUpdatingMimeGroup = false;
            this.mUserManager = userManager;
            copyFrom(orig);
            copyInto(this.mMimeGroupToFilter, orig.mMimeGroupToFilter);
            this.mIsUpdatingMimeGroup = orig.mIsUpdatingMimeGroup;
        }

        public void addFilter(PackageDataSnapshot snapshot, F f) {
            IntentFilter r0 = getIntentFilter(f);
            applyMimeGroups((Computer) snapshot, f);
            super.addFilter(snapshot, f);
            if (this.mIsUpdatingMimeGroup == true) goto L6;
            register_intent_filter(f, r0.mimeGroupsIterator(), this.mMimeGroupToFilter, "      MimeGroup: ");
            return;
        }

        protected void removeFilterInternal(F f) {
            IntentFilter r0 = getIntentFilter(f);
            if (this.mIsUpdatingMimeGroup == true) goto L5;
            unregister_intent_filter(f, r0.mimeGroupsIterator(), this.mMimeGroupToFilter, "      MimeGroup: ");
        L5:
            super.removeFilterInternal(f);
            r0.clearDynamicDataTypes();
        }

        public boolean updateMimeGroup(Computer computer, String packageName, String mimeGroup) {
            F[] filters = this.mMimeGroupToFilter.get(mimeGroup);
            if (filters == null) goto L5;
            int n = filters.length;
        L6:
            this.mIsUpdatingMimeGroup = true;
            boolean hasChanges = false;
            int i = 0;
        L8:
            if (i >= n) goto L15;
            F filter = filters[i];
            if (filter == null) goto L15;
            if (isPackageForFilter(packageName, filter) == false) goto L14;
            hasChanges = hasChanges | updateFilter(computer, filter);
        L14:
            i = i + 1;
        L15:
            this.mIsUpdatingMimeGroup = false;
            return hasChanges;
        L5:
            n = 0;
            goto L6
        }

        private boolean updateFilter(Computer computer, F f) {
            IntentFilter r0 = getIntentFilter(f);
            List oldTypes = r0.dataTypes();
            removeFilter(f);
            addFilter(computer, f);
            List newTypes = r0.dataTypes();
            return !equalLists(oldTypes, newTypes);
        }

        private boolean equalLists(List<String> first, List<String> second) {
            if (first != null) goto L7;
            if (second != null) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (second != null) goto L10;
            return false;
        L10:
            if (first.size() == second.size()) goto L12;
            return false;
        L12:
            Collections.sort(first);
            Collections.sort(second);
            return first.equals(second);
        }

        private void applyMimeGroups(Computer computer, F f) {
            IntentFilter filter = getIntentFilter(f);
            int i = filter.countMimeGroups() - 1;
        L3:
            if (i < 0) goto L18;
            PackageStateInternal packageState = computer.getPackageStateInternal(((ParsedComponent) ((Pair) f).first).getPackageName());
            if (packageState != null) goto L7;
            Collection<String> mimeTypes = Collections.emptyList();
        L8:
            Iterator<String> r4 = mimeTypes.iterator();
        L10:
            if (r4.hasNext() == false) goto L16;
            String mimeType = r4.next();
            filter.addDynamicDataType(mimeType);     // Catch: IntentFilter.MalformedMimeTypeException -> L14
            goto L10
        L16:
            i = i - 1;
            goto L3
        L7:
            mimeTypes = packageState.getMimeGroups().get(filter.getMimeGroup(i));
            goto L8
        }

        protected boolean isFilterStopped(Computer computer, F filter, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return true;
        L6:
            PackageStateInternal packageState = computer.getPackageStateInternal(((ParsedComponent) ((Pair) filter).first).getPackageName());
            if (packageState != null) goto L9;
        L16:
            return false;
        L9:
            if (packageState.getPkg() == null) goto L16;
            if (packageState.isSystem() == false) goto L15;
            return false;
        L15:
            return packageState.getUserStateOrDefault(userId).isStopped();
        }
    }

    public static final class ProviderIntentResolver extends MimeGroupsAwareIntentResolver<Pair<ParsedProvider, ParsedIntentInfo>, ResolveInfo> {
        final ArrayMap<ComponentName, ParsedProvider> mProviders;

        @Override // com.android.server.pm.resolution.ComponentResolver.MimeGroupsAwareIntentResolver
        public /* bridge */ /* synthetic */ void addFilter(PackageDataSnapshot r1, Pair r2) {
            super.addFilter(r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean allowFilterResult(Object r1, List r2) {
            return allowFilterResult((Pair) r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ void dumpFilter(PrintWriter r1, String r2, Object r3) {
            dumpFilter(r1, r2, (Pair) r3);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object filterToLabel(Object r1) {
            return filterToLabel((Pair) r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(Object r1) {
            return getIntentFilter((Pair) r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, Object r2) {
            return isPackageForFilter(r1, (Pair) r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object newResult(Computer r8, Object r9, int r10, int r11, long r12) {
            return newResult(r8, (Pair) r9, r10, r11, r12);
        }

        @Override // com.android.server.pm.resolution.ComponentResolver.MimeGroupsAwareIntentResolver
        public /* bridge */ /* synthetic */ boolean updateMimeGroup(Computer r1, String r2, String r3) {
            return super.updateMimeGroup(r1, r2, r3);
        }

        ProviderIntentResolver(UserManagerService userManager) {
            super(userManager);
            this.mProviders = new ArrayMap();
        }

        ProviderIntentResolver(ProviderIntentResolver orig, UserManagerService userManager) {
            super(orig, userManager);
            this.mProviders = new ArrayMap();
            this.mProviders.putAll(orig.mProviders);
        }

        @Override // com.android.server.IntentResolver
        public List<ResolveInfo> queryIntent(PackageDataSnapshot snapshot, Intent intent, String resolvedType, boolean defaultOnly, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return null;
        L6:
            if (defaultOnly == false) goto L8;
            long r0 = 65536;
        L9:
            long flags = r0;
            return super.queryIntent(snapshot, intent, resolvedType, defaultOnly, userId, flags);
        L8:
            r0 = 0;
            goto L9
        }

        List<ResolveInfo> queryIntent(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L7;
            return null;
        L7:
            if ((65536 & flags) == 0) goto L10;
            boolean r0 = true;
        L12:
            return super.queryIntent(computer, intent, resolvedType, r0, userId, flags);
        L10:
            r0 = false;
            goto L12
        }

        List<ResolveInfo> queryIntentForPackage(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedProvider> packageProviders, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return null;
        L6:
            if (packageProviders != null) goto L10;
            return Collections.emptyList();
        L10:
            if ((flags & 65536) == 0) goto L13;
            boolean r1 = true;
        L12:
            boolean defaultOnly = r1;
            int providersSize = packageProviders.size();
            ArrayList<Pair<ParsedProvider, ParsedIntentInfo>[]> listCut = new ArrayList(providersSize);
            int i = 0;
        L15:
            if (i >= providersSize) goto L25;
            ParsedProvider provider = packageProviders.get(i);
            List<ParsedIntentInfo> intentFilters = provider.getIntents();
            if (intentFilters.isEmpty() == true) goto L23;
            Pair<ParsedProvider, ParsedIntentInfo>[] array = newArray(intentFilters.size());
            int arrayIndex = 0;
        L20:
            if (arrayIndex >= intentFilters.size()) goto L22;
            array[arrayIndex] = Pair.create(provider, intentFilters.get(arrayIndex));
            arrayIndex = arrayIndex + 1;
            goto L20
        L22:
            listCut.add(array);
        L23:
            i = i + 1;
            goto L15
        L25:
            return super.queryIntentFromList(computer, intent, resolvedType, defaultOnly, listCut, userId, flags);
        L13:
            r1 = false;
            goto L12
        }

        void addProvider(Computer computer, ParsedProvider p) {
            if (this.mProviders.containsKey(p.getComponentName()) == false) goto L6;
            Slog.w("PackageManager", "Provider " + p.getComponentName() + " already defined; ignoring");
            return;
        L6:
            this.mProviders.put(p.getComponentName(), p);
            int intentsSize = p.getIntents().size();
            int j = 0;
        L7:
            if (j >= intentsSize) goto L12;
            ParsedIntentInfo intent = (ParsedIntentInfo) p.getIntents().get(j);
            IntentFilter intentFilter = intent.getIntentFilter();
            if (intentFilter.debugCheck() == true) goto L11;
            Log.w("PackageManager", "==> For Provider " + p.getName());
        L11:
            addFilter(computer, Pair.create(p, intent));
            j = j + 1;
            goto L7
        }

        void removeProvider(ParsedProvider p) {
            this.mProviders.remove(p.getComponentName());
            int intentsSize = p.getIntents().size();
            int j = 0;
        L3:
            if (j >= intentsSize) goto L5;
            ParsedIntentInfo intent = (ParsedIntentInfo) p.getIntents().get(j);
            intent.getIntentFilter();
            removeFilter(Pair.create(p, intent));
            j = j + 1;
            goto L3
        }

        protected boolean allowFilterResult(Pair<ParsedProvider, ParsedIntentInfo> filter, List<ResolveInfo> dest) {
            int i = dest.size() - 1;
        L3:
            if (i < 0) goto L12;
            ProviderInfo destPi = dest.get(i).providerInfo;
            if (Objects.equals(destPi.name, ((ParsedProvider) filter.first).getClassName()) == false) goto L10;
            if (Objects.equals(destPi.packageName, ((ParsedProvider) filter.first).getPackageName()) == false) goto L10;
            return false;
        L10:
            i = i - 1;
            goto L3
        L12:
            return true;
        }

        @Override // com.android.server.IntentResolver
        protected Pair<ParsedProvider, ParsedIntentInfo>[] newArray(int size) {
            return new Pair[size];
        }

        protected boolean isPackageForFilter(String packageName, Pair<ParsedProvider, ParsedIntentInfo> info) {
            return packageName.equals(((ParsedProvider) info.first).getPackageName());
        }

        protected ResolveInfo newResult(Computer computer, Pair<ParsedProvider, ParsedIntentInfo> pair, int match, int userId, long customFlags) {
            if (this.mUserManager.exists(userId) == true) goto L5;
            return null;
        L5:
            ParsedProvider provider = (ParsedProvider) pair.first;
            ParsedIntentInfo intentInfo = (ParsedIntentInfo) pair.second;
            IntentFilter filter = intentInfo.getIntentFilter();
            PackageStateInternal packageState = computer.getPackageStateInternal(provider.getPackageName());
            if (packageState == null) goto L47;
            if (packageState.getPkg() == null) goto L47;
            if (PackageStateUtils.isEnabledAndMatches(packageState, provider, customFlags, userId) == false) goto L47;
            PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
            boolean r8 = false;
            if ((16777216 & customFlags) == 0) goto L15;
            boolean r1 = true;
        L16:
            boolean matchVisibleToInstantApp = r1;
            if ((customFlags & 8388608) == 0) goto L19;
            r8 = true;
        L19:
            boolean isInstantApp = r8;
            if (matchVisibleToInstantApp == true) goto L22;
        L26:
            if (isInstantApp == true) goto L31;
            if (userState.isInstantApp() == false) goto L31;
            return null;
        L31:
            if (userState.isInstantApp() == true) goto L33;
        L35:
            ApplicationInfo appInfo = PackageInfoUtils.generateApplicationInfo(packageState.getPkg(), customFlags, userState, userId, packageState);
            if (appInfo != null) goto L38;
            return null;
        L38:
            ProviderInfo pi = PackageInfoUtils.generateProviderInfo(packageState.getPkg(), provider, customFlags, userState, appInfo, userId, packageState);
            if (pi != null) goto L41;
            return null;
        L41:
            ResolveInfo res = new ResolveInfo();
            res.providerInfo = pi;
            if ((customFlags & 64) == 0) goto L44;
            res.filter = filter;
        L44:
            res.priority = filter.getPriority();
            res.match = match;
            res.isDefault = intentInfo.isHasDefault();
            res.labelRes = intentInfo.getLabelRes();
            res.nonLocalizedLabel = intentInfo.getNonLocalizedLabel();
            res.icon = intentInfo.getIcon();
            res.system = res.providerInfo.applicationInfo.isSystemApp();
            return res;
        L33:
            if (packageState.isUpdateAvailable() == false) goto L35;
            return null;
        L22:
            if (filter.isVisibleToInstantApp() == true) goto L26;
            if (userState.isInstantApp() == true) goto L26;
            return null;
        L15:
            r1 = false;
        L47:
            return null;
        }

        @Override // com.android.server.IntentResolver
        protected void sortResults(List<ResolveInfo> results) {
            results.sort(ComponentResolver.RESOLVE_PRIORITY_SORTER);
        }

        protected void dumpFilter(PrintWriter out, String prefix, Pair<ParsedProvider, ParsedIntentInfo> pair) {
            ParsedProvider provider = (ParsedProvider) pair.first;
            ParsedIntentInfo filter = (ParsedIntentInfo) pair.second;
            out.print(prefix);
            out.print(Integer.toHexString(System.identityHashCode(provider)));
            out.print(' ');
            ComponentName.printShortString(out, provider.getPackageName(), provider.getClassName());
            out.print(" filter ");
            out.println(Integer.toHexString(System.identityHashCode(filter)));
        }

        protected Object filterToLabel(Pair<ParsedProvider, ParsedIntentInfo> filter) {
            return filter;
        }

        @Override // com.android.server.IntentResolver
        protected void dumpFilterLabel(PrintWriter out, String prefix, Object label, int count) {
            Pair<ParsedProvider, ParsedIntentInfo> pair = (Pair) label;
            out.print(prefix);
            out.print(Integer.toHexString(System.identityHashCode(pair.first)));
            out.print(' ');
            ComponentName.printShortString(out, ((ParsedProvider) pair.first).getPackageName(), ((ParsedProvider) pair.first).getClassName());
            if (count <= 1) goto L5;
            out.print(" (");
            out.print(count);
            out.print(" filters)");
        L5:
            out.println();
        }

        protected IntentFilter getIntentFilter(Pair<ParsedProvider, ParsedIntentInfo> input) {
            return ((ParsedIntentInfo) input.second).getIntentFilter();
        }
    }

    public static final class ReceiverIntentResolver extends ActivityIntentResolver {
        ReceiverIntentResolver(UserManagerService userManager, UserNeedsBadgingCache userNeedsBadgingCache) {
            super(userManager, userNeedsBadgingCache);
        }

        ReceiverIntentResolver(ReceiverIntentResolver orig, UserManagerService userManager, UserNeedsBadgingCache userNeedsBadgingCache) {
            super(orig, userManager, userNeedsBadgingCache);
        }

        @Override // com.android.server.pm.resolution.ComponentResolver.ActivityIntentResolver
        protected List<ParsedActivity> getResolveList(AndroidPackage pkg) {
            return pkg.getReceivers();
        }
    }

    public static final class ServiceIntentResolver extends MimeGroupsAwareIntentResolver<Pair<ParsedService, ParsedIntentInfo>, ResolveInfo> {
        final ArrayMap<ComponentName, ParsedService> mServices;

        @Override // com.android.server.pm.resolution.ComponentResolver.MimeGroupsAwareIntentResolver
        public /* bridge */ /* synthetic */ void addFilter(PackageDataSnapshot r1, Pair r2) {
            super.addFilter(r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean allowFilterResult(Object r1, List r2) {
            return allowFilterResult((Pair) r1, r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ void dumpFilter(PrintWriter r1, String r2, Object r3) {
            dumpFilter(r1, r2, (Pair) r3);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object filterToLabel(Object r1) {
            return filterToLabel((Pair) r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ IntentFilter getIntentFilter(Object r1) {
            return getIntentFilter((Pair) r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ boolean isPackageForFilter(String r1, Object r2) {
            return isPackageForFilter(r1, (Pair) r2);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object[] newArray(int r1) {
            return newArray(r1);
        }

        @Override // com.android.server.IntentResolver
        protected /* bridge */ /* synthetic */ Object newResult(Computer r8, Object r9, int r10, int r11, long r12) {
            return newResult(r8, (Pair) r9, r10, r11, r12);
        }

        @Override // com.android.server.pm.resolution.ComponentResolver.MimeGroupsAwareIntentResolver
        public /* bridge */ /* synthetic */ boolean updateMimeGroup(Computer r1, String r2, String r3) {
            return super.updateMimeGroup(r1, r2, r3);
        }

        ServiceIntentResolver(UserManagerService userManager) {
            super(userManager);
            this.mServices = new ArrayMap();
        }

        ServiceIntentResolver(ServiceIntentResolver orig, UserManagerService userManager) {
            super(orig, userManager);
            this.mServices = new ArrayMap();
            this.mServices.putAll(orig.mServices);
        }

        @Override // com.android.server.IntentResolver
        public List<ResolveInfo> queryIntent(PackageDataSnapshot snapshot, Intent intent, String resolvedType, boolean defaultOnly, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return null;
        L6:
            if (defaultOnly == false) goto L8;
            long r0 = 65536;
        L9:
            long flags = r0;
            return super.queryIntent(snapshot, intent, resolvedType, defaultOnly, userId, flags);
        L8:
            r0 = 0;
            goto L9
        }

        List<ResolveInfo> queryIntent(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L7;
            return null;
        L7:
            if ((65536 & flags) == 0) goto L10;
            boolean r0 = true;
        L12:
            return super.queryIntent(computer, intent, resolvedType, r0, userId, flags);
        L10:
            r0 = false;
            goto L12
        }

        List<ResolveInfo> queryIntentForPackage(Computer computer, Intent intent, String resolvedType, long flags, List<ParsedService> packageServices, int userId) {
            if (this.mUserManager.exists(userId) == true) goto L6;
            return null;
        L6:
            if (packageServices != null) goto L10;
            return Collections.emptyList();
        L10:
            if ((flags & 65536) == 0) goto L13;
            boolean r1 = true;
        L12:
            boolean defaultOnly = r1;
            int servicesSize = packageServices.size();
            ArrayList<Pair<ParsedService, ParsedIntentInfo>[]> listCut = new ArrayList(servicesSize);
            int i = 0;
        L15:
            if (i >= servicesSize) goto L25;
            ParsedService service = packageServices.get(i);
            List<ParsedIntentInfo> intentFilters = service.getIntents();
            if (intentFilters.size() <= 0) goto L23;
            Pair<ParsedService, ParsedIntentInfo>[] array = newArray(intentFilters.size());
            int arrayIndex = 0;
        L20:
            if (arrayIndex >= intentFilters.size()) goto L22;
            array[arrayIndex] = Pair.create(service, intentFilters.get(arrayIndex));
            arrayIndex = arrayIndex + 1;
            goto L20
        L22:
            listCut.add(array);
        L23:
            i = i + 1;
            goto L15
        L25:
            return super.queryIntentFromList(computer, intent, resolvedType, defaultOnly, listCut, userId, flags);
        L13:
            r1 = false;
            goto L12
        }

        void addService(Computer computer, ParsedService s) {
            this.mServices.put(s.getComponentName(), s);
            int intentsSize = s.getIntents().size();
            int j = 0;
        L3:
            if (j >= intentsSize) goto L8;
            ParsedIntentInfo intent = (ParsedIntentInfo) s.getIntents().get(j);
            IntentFilter intentFilter = intent.getIntentFilter();
            if (intentFilter.debugCheck() == true) goto L7;
            Log.w("PackageManager", "==> For Service " + s.getName());
        L7:
            addFilter(computer, Pair.create(s, intent));
            j = j + 1;
            goto L3
        }

        void removeService(ParsedService s) {
            this.mServices.remove(s.getComponentName());
            int intentsSize = s.getIntents().size();
            int j = 0;
        L3:
            if (j >= intentsSize) goto L5;
            ParsedIntentInfo intent = (ParsedIntentInfo) s.getIntents().get(j);
            intent.getIntentFilter();
            removeFilter(Pair.create(s, intent));
            j = j + 1;
            goto L3
        }

        protected boolean allowFilterResult(Pair<ParsedService, ParsedIntentInfo> filter, List<ResolveInfo> dest) {
            int i = dest.size() - 1;
        L3:
            if (i < 0) goto L12;
            ServiceInfo destAi = dest.get(i).serviceInfo;
            if (Objects.equals(destAi.name, ((ParsedService) filter.first).getClassName()) == false) goto L10;
            if (Objects.equals(destAi.packageName, ((ParsedService) filter.first).getPackageName()) == false) goto L10;
            return false;
        L10:
            i = i - 1;
            goto L3
        L12:
            return true;
        }

        @Override // com.android.server.IntentResolver
        protected Pair<ParsedService, ParsedIntentInfo>[] newArray(int size) {
            return new Pair[size];
        }

        protected boolean isPackageForFilter(String packageName, Pair<ParsedService, ParsedIntentInfo> info) {
            return packageName.equals(((ParsedService) info.first).getPackageName());
        }

        protected ResolveInfo newResult(Computer computer, Pair<ParsedService, ParsedIntentInfo> pair, int match, int userId, long customFlags) {
            if (this.mUserManager.exists(userId) == true) goto L5;
            return null;
        L5:
            ParsedService service = (ParsedService) pair.first;
            ParsedIntentInfo intentInfo = (ParsedIntentInfo) pair.second;
            IntentFilter filter = intentInfo.getIntentFilter();
            PackageStateInternal packageState = computer.getPackageStateInternal(service.getPackageName());
            if (packageState == null) goto L43;
            if (packageState.getPkg() == null) goto L43;
            if (PackageStateUtils.isEnabledAndMatches(packageState, service, customFlags, userId) == false) goto L43;
            PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
            ServiceInfo si = PackageInfoUtils.generateServiceInfo(packageState.getPkg(), service, customFlags, userState, userId, packageState);
            if (si != null) goto L15;
            return null;
        L15:
            boolean isInstantApp = false;
            if ((customFlags & 16777216) == 0) goto L18;
            boolean matchVisibleToInstantApp = true;
        L20:
            if ((customFlags & 8388608) == 0) goto L22;
            isInstantApp = true;
        L22:
            if (matchVisibleToInstantApp == true) goto L24;
        L28:
            if (isInstantApp == true) goto L33;
            if (userState.isInstantApp() == false) goto L33;
            return null;
        L33:
            if (userState.isInstantApp() == true) goto L35;
        L37:
            ResolveInfo res = new ResolveInfo();
            res.serviceInfo = si;
            if ((customFlags & 64) == 0) goto L40;
            res.filter = filter;
        L40:
            res.priority = filter.getPriority();
            res.match = match;
            res.isDefault = intentInfo.isHasDefault();
            res.labelRes = intentInfo.getLabelRes();
            res.nonLocalizedLabel = intentInfo.getNonLocalizedLabel();
            res.icon = intentInfo.getIcon();
            res.system = res.serviceInfo.applicationInfo.isSystemApp();
            return res;
        L35:
            if (packageState.isUpdateAvailable() == false) goto L37;
            return null;
        L24:
            if (filter.isVisibleToInstantApp() == true) goto L28;
            if (userState.isInstantApp() == true) goto L28;
            return null;
        L18:
            matchVisibleToInstantApp = false;
        L43:
            return null;
        }

        @Override // com.android.server.IntentResolver
        protected void sortResults(List<ResolveInfo> results) {
            results.sort(ComponentResolver.RESOLVE_PRIORITY_SORTER);
        }

        protected void dumpFilter(PrintWriter out, String prefix, Pair<ParsedService, ParsedIntentInfo> pair) {
            ParsedService service = (ParsedService) pair.first;
            ParsedIntentInfo filter = (ParsedIntentInfo) pair.second;
            out.print(prefix);
            out.print(Integer.toHexString(System.identityHashCode(service)));
            out.print(' ');
            ComponentName.printShortString(out, service.getPackageName(), service.getClassName());
            out.print(" filter ");
            out.print(Integer.toHexString(System.identityHashCode(filter)));
            if (service.getPermission() == null) goto L5;
            out.print(" permission ");
            out.println(service.getPermission());
            return;
        L5:
            out.println();
        }

        protected Object filterToLabel(Pair<ParsedService, ParsedIntentInfo> filter) {
            return filter;
        }

        @Override // com.android.server.IntentResolver
        protected void dumpFilterLabel(PrintWriter out, String prefix, Object label, int count) {
            Pair<ParsedService, ParsedIntentInfo> pair = (Pair) label;
            out.print(prefix);
            out.print(Integer.toHexString(System.identityHashCode(pair.first)));
            out.print(' ');
            ComponentName.printShortString(out, ((ParsedService) pair.first).getPackageName(), ((ParsedService) pair.first).getClassName());
            if (count <= 1) goto L5;
            out.print(" (");
            out.print(count);
            out.print(" filters)");
        L5:
            out.println();
        }

        protected IntentFilter getIntentFilter(Pair<ParsedService, ParsedIntentInfo> input) {
            return ((ParsedIntentInfo) input.second).getIntentFilter();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$UVMyfxjaimXrgxK-y9k5NRVVfkI, reason: not valid java name */
    public static /* synthetic */ int m7116$r8$lambda$UVMyfxjaimXrgxKy9k5NRVVfkI(ResolveInfo r0, ResolveInfo r1) {
        return lambda$static$0(r0, r1);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ ComponentResolverApi snapshot() {
        return snapshot();
    }

    private void onChanged() {
        dispatchChange(this);
    }

    static {
        PROTECTED_ACTIONS = new ArraySet();
        PROTECTED_ACTIONS.add("android.intent.action.SEND");
        PROTECTED_ACTIONS.add("android.intent.action.SENDTO");
        PROTECTED_ACTIONS.add("android.intent.action.SEND_MULTIPLE");
        PROTECTED_ACTIONS.add("android.intent.action.VIEW");
        RESOLVE_PRIORITY_SORTER = new ComponentResolver$$ExternalSyntheticLambda4();
    }

    private static /* synthetic */ int lambda$static$0(ResolveInfo r1, ResolveInfo r2) {
        int v1 = r1.priority;
        int v2 = r2.priority;
        if (v1 == v2) goto L7;
        if (v1 > v2) goto L6;
        return 1;
    L6:
        return -1;
    L7:
        int v3 = r1.preferredOrder;
        int v4 = r2.preferredOrder;
        if (v3 == v4) goto L13;
        if (v3 > v4) goto L11;
        return 1;
    L11:
        return -1;
    L13:
        if (r1.isDefault != r2.isDefault) goto L15;
        int v5 = r1.match;
        int v6 = r2.match;
        if (v5 == v6) goto L24;
        if (v5 > v6) goto L22;
        return 1;
    L22:
        return -1;
    L24:
        if (r1.system == r2.system) goto L30;
        if (r1.system == true) goto L28;
        return 1;
    L28:
        return -1;
    L30:
        if (r1.activityInfo == null) goto L34;
        return r1.activityInfo.packageName.compareTo(r2.activityInfo.packageName);
    L34:
        if (r1.serviceInfo == null) goto L38;
        return r1.serviceInfo.packageName.compareTo(r2.serviceInfo.packageName);
    L38:
        if (r1.providerInfo != null) goto L40;
        return 0;
    L40:
        return r1.providerInfo.packageName.compareTo(r2.providerInfo.packageName);
    L15:
        if (r1.isDefault == true) goto L17;
        return 1;
    L17:
        return -1;
    }

    public ComponentResolver(UserManagerService userManager, final UserNeedsBadgingCache userNeedsBadgingCache) {
        super(userManager);
        this.mDeferProtectedFilters = true;
        this.mSmtEx = new ComponentResolverSmtEx(this);
        this.mActivities = new ActivityIntentResolver(userManager, userNeedsBadgingCache);
        this.mProviders = new ProviderIntentResolver(userManager);
        this.mReceivers = new ReceiverIntentResolver(userManager, userNeedsBadgingCache);
        this.mServices = new ServiceIntentResolver(userManager);
        this.mProvidersByAuthority = new ArrayMap();
        this.mDeferProtectedFilters = true;
        this.mSnapshot = new AnonymousClass1(this, this, this, userNeedsBadgingCache);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.utils.Snappable
    public ComponentResolverApi snapshot() {
        return this.mSnapshot.snapshot();
    }

    public void addAllComponents(AndroidPackage pkg, boolean chatty, String setupWizardPackage, Computer computer) {
        ArrayList<Pair<ParsedActivity, ParsedIntentInfo>> newIntents = new ArrayList();
        PackageManagerTracedLock r3 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        addActivitiesLocked(computer, pkg, newIntents, chatty);     // Catch: Throwable -> L18
        addReceiversLocked(computer, pkg, chatty);     // Catch: Throwable -> L18
        addProvidersLocked(computer, pkg, chatty);     // Catch: Throwable -> L18
        addServicesLocked(computer, pkg, chatty);     // Catch: Throwable -> L18
        onChanged();     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L18
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int i = newIntents.size() - 1;
    L7:
        if (i < 0) goto L17;
        Pair<ParsedActivity, ParsedIntentInfo> pair = newIntents.get(i);
        PackageStateInternal disabledPkgSetting = computer.getDisabledSystemPackage(((ParsedActivity) pair.first).getPackageName());
        List<ParsedActivity> systemActivities = null;
        if (disabledPkgSetting != null) goto L11;
        AndroidPackageInternal r4 = null;
    L12:
        AndroidPackageInternal r10 = r4;
        if (r10 == null) goto L15;
        systemActivities = r10.getActivities();
    L15:
        adjustPriority(computer, systemActivities, (ParsedActivity) pair.first, (ParsedIntentInfo) pair.second, setupWizardPackage);
        onChanged();
        i = i - 1;
        goto L7
    L11:
        r4 = disabledPkgSetting.getPkg();
        goto L12
    L17:
        return;
    L18:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void removeAllComponents(AndroidPackage pkg, boolean chatty) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        removeAllComponentsLocked(pkg, chatty);     // Catch: Throwable -> L8
        onChanged();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void fixProtectedFilterPriorities(String setupWizardPackage) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        if (this.mDeferProtectedFilters == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L12:
        this.mDeferProtectedFilters = false;     // Catch: Throwable -> L9
        if (this.mProtectedFilters == null) goto L28;
        if (this.mProtectedFilters.size() == 0) goto L28;
        List<Pair<ParsedMainComponent, ParsedIntentInfo>> protectedFilters = this.mProtectedFilters;     // Catch: Throwable -> L9
        this.mProtectedFilters = null;     // Catch: Throwable -> L9
        int i = protectedFilters.size() - 1;     // Catch: Throwable -> L9
    L18:
        if (i < 0) goto L24;
        Pair<ParsedMainComponent, ParsedIntentInfo> pair = protectedFilters.get(i);     // Catch: Throwable -> L9
        ParsedMainComponent component = (ParsedMainComponent) pair.first;     // Catch: Throwable -> L9
        ParsedIntentInfo intentInfo = (ParsedIntentInfo) pair.second;     // Catch: Throwable -> L9
        IntentFilter filter = intentInfo.getIntentFilter();     // Catch: Throwable -> L9
        String packageName = component.getPackageName();     // Catch: Throwable -> L9
        component.getClassName();     // Catch: Throwable -> L9
        if (packageName.equals(setupWizardPackage) == true) goto L23;
        filter.setPriority(0);     // Catch: Throwable -> L9
    L23:
        i = i - 1;     // Catch: Throwable -> L9
        goto L18
    L24:
        onChanged();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    }

    private void addActivitiesLocked(Computer computer, AndroidPackage pkg, List<Pair<ParsedActivity, ParsedIntentInfo>> newIntents, boolean chatty) {
        int activitiesSize = ArrayUtils.size(pkg.getActivities());
        int i = 0;
    L3:
        if (i >= activitiesSize) goto L6;
        ParsedActivity a = (ParsedActivity) pkg.getActivities().get(i);
        this.mActivities.addActivity(computer, a, HostingRecord.HOSTING_TYPE_ACTIVITY, newIntents);
        i = i + 1;
        goto L3
    }

    private void addProvidersLocked(Computer computer, AndroidPackage pkg, boolean chatty) {
        int providersSize = ArrayUtils.size(pkg.getProviders());
        int i = 0;
    L3:
        if (i >= providersSize) goto L34;
        ParsedProvider p = (ParsedProvider) pkg.getProviders().get(i);
        this.mProviders.addProvider(computer, p);
        if (p.getAuthority() == null) goto L32;
        String[] names = p.getAuthority().split(";");
        ComponentMutateUtils.setAuthority(p, null);
        int j = 0;
    L8:
        if (j >= names.length) goto L32;
        if (j != 1) goto L15;
        if (p.isSyncable() == false) goto L15;
        ParsedProvider p2 = new ParsedProviderImpl(p);
        ComponentMutateUtils.setSyncable(p2, false);
        p = p2;
    L15:
        if (this.mProvidersByAuthority.containsKey(names[j]) == true) goto L20;
        this.mProvidersByAuthority.put(names[j], p);
        if (p.getAuthority() != null) goto L19;
        ComponentMutateUtils.setAuthority(p, names[j]);
    L31:
        j = j + 1;
        goto L8
    L19:
        ComponentMutateUtils.setAuthority(p, p.getAuthority() + ";" + names[j]);
        goto L31
    L20:
        ParsedProvider other = this.mProvidersByAuthority.get(names[j]);
        if (other != null) goto L23;
    L25:
        ComponentName component = null;
    L27:
        if (component == null) goto L29;
        String packageName = component.getPackageName();
    L30:
        Slog.w("PackageManager", "Skipping provider name " + names[j] + " (in package " + pkg.getPackageName() + "): name already used by " + packageName);
        goto L31
    L29:
        packageName = "?";
        goto L30
    L23:
        if (other.getComponentName() == null) goto L25;
        component = other.getComponentName();
    L32:
        i = i + 1;
        goto L3
    }

    private void addReceiversLocked(Computer computer, AndroidPackage pkg, boolean chatty) {
        int receiversSize = ArrayUtils.size(pkg.getReceivers());
        int i = 0;
    L3:
        if (i >= receiversSize) goto L6;
        ParsedActivity a = (ParsedActivity) pkg.getReceivers().get(i);
        this.mReceivers.addActivity(computer, a, "receiver", null);
        i = i + 1;
        goto L3
    }

    private void addServicesLocked(Computer computer, AndroidPackage pkg, boolean chatty) {
        int servicesSize = ArrayUtils.size(pkg.getServices());
        int i = 0;
    L3:
        if (i >= servicesSize) goto L6;
        ParsedService s = (ParsedService) pkg.getServices().get(i);
        this.mServices.addService(computer, s);
        i = i + 1;
        goto L3
    }

    private static <T> void getIntentListSubset(List<ParsedIntentInfo> intentList, Function<IntentFilter, Iterator<T>> generator, Iterator<T> searchIterator) {
    L3:
        if (searchIterator.hasNext() == false) goto L24;
        if (intentList.size() == 0) goto L39;
        T searchAction = searchIterator.next();
        Iterator<ParsedIntentInfo> intentIter = intentList.iterator();
    L9:
        if (intentIter.hasNext() == false) goto L3;
        ParsedIntentInfo intentInfo = intentIter.next();
        boolean selectionFound = false;
        Iterator<T> intentSelectionIter = generator.apply(intentInfo.getIntentFilter());
    L11:
        if (intentSelectionIter == null) goto L20;
        if (intentSelectionIter.hasNext() == false) goto L20;
        T intentSelection = intentSelectionIter.next();
        if (intentSelection == null) goto L11;
        if (intentSelection.equals(searchAction) == false) goto L11;
        selectionFound = true;
    L20:
        if (selectionFound == true) goto L9;
        intentIter.remove();
        goto L9
    L39:
        return;
    }

    private static boolean isProtectedAction(IntentFilter filter) {
        Iterator<String> actionsIter = filter.actionsIterator();
    L3:
        if (actionsIter == null) goto L11;
        if (actionsIter.hasNext() == false) goto L17;
        String filterAction = actionsIter.next();
        if (PROTECTED_ACTIONS.contains(filterAction) == false) goto L3;
        return true;
    L17:
        return false;
    L11:
        return false;
    }

    private static ParsedActivity findMatchingActivity(List<ParsedActivity> activityList, ParsedActivity activityInfo) {
        Iterator<ParsedActivity> r0 = activityList.iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        ParsedActivity sysActivity = r0.next();
        if (sysActivity.getName().equals(activityInfo.getName()) == true) goto L7;
        if (sysActivity.getName().equals(activityInfo.getTargetActivity()) == true) goto L10;
        if (sysActivity.getTargetActivity() == null) goto L4;
        if (sysActivity.getTargetActivity().equals(activityInfo.getName()) == true) goto L15;
        if (sysActivity.getTargetActivity().equals(activityInfo.getTargetActivity()) == false) goto L4;
        return sysActivity;
    L15:
        return sysActivity;
    L10:
        return sysActivity;
    L7:
        return sysActivity;
    L20:
        return null;
    }

    private void adjustPriority(Computer computer, List<ParsedActivity> systemActivities, ParsedActivity activity, ParsedIntentInfo intentInfo, String setupWizardPackage) {
        IntentFilter intentFilter = intentInfo.getIntentFilter();
        if (intentFilter.getPriority() > 0) goto L5;
        return;
    L5:
        String packageName = activity.getPackageName();
        PackageStateInternal packageState = computer.getPackageStateInternal(packageName);
        boolean privilegedApp = packageState.isPrivileged();
        activity.getClassName();
        if (privilegedApp == true) goto L10;
        intentFilter.setPriority(0);
        return;
    L10:
        if (isProtectedAction(intentFilter) == false) goto L29;
        if (this.mDeferProtectedFilters == false) goto L21;
        if (this.mProtectedFilters != null) goto L17;
        this.mProtectedFilters = new ArrayList();
    L17:
        if ("com.android.packageinstaller".equals(packageName) == true) goto L69;
        this.mProtectedFilters.add(Pair.create(activity, intentInfo));
        return;
    L69:
        return;
    L21:
        if (packageName.equals(setupWizardPackage) == false) goto L23;
        return;
    L23:
        if (packageName.equals("com.android.packageinstaller") == true) goto L70;
        intentFilter.setPriority(0);
        return;
    L70:
        return;
    L29:
        if (systemActivities != null) goto L31;
        return;
    L31:
        ParsedActivity foundActivity = findMatchingActivity(systemActivities, activity);
        if (foundActivity != null) goto L35;
        intentFilter.setPriority(0);
        return;
    L35:
        List<ParsedIntentInfo> intentListCopy = new ArrayList(foundActivity.getIntents());
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        if (actionsIterator == null) goto L41;
        getIntentListSubset(intentListCopy, new ComponentResolver$$ExternalSyntheticLambda0(), actionsIterator);
        if (intentListCopy.size() != 0) goto L41;
        intentFilter.setPriority(0);
        return;
    L41:
        Iterator<String> categoriesIterator = intentFilter.categoriesIterator();
        if (categoriesIterator == null) goto L47;
        getIntentListSubset(intentListCopy, new ComponentResolver$$ExternalSyntheticLambda1(), categoriesIterator);
        if (intentListCopy.size() != 0) goto L47;
        intentFilter.setPriority(0);
        return;
    L47:
        Iterator<String> schemesIterator = intentFilter.schemesIterator();
        if (schemesIterator == null) goto L53;
        getIntentListSubset(intentListCopy, new ComponentResolver$$ExternalSyntheticLambda2(), schemesIterator);
        if (intentListCopy.size() != 0) goto L53;
        intentFilter.setPriority(0);
        return;
    L53:
        Iterator<IntentFilter.AuthorityEntry> authoritiesIterator = intentFilter.authoritiesIterator();
        if (authoritiesIterator == null) goto L59;
        getIntentListSubset(intentListCopy, new ComponentResolver$$ExternalSyntheticLambda3(), authoritiesIterator);
        if (intentListCopy.size() != 0) goto L59;
        intentFilter.setPriority(0);
        return;
    L59:
        int cappedPriority = 0;
        int i = intentListCopy.size() - 1;
    L60:
        if (i < 0) goto L63;
        cappedPriority = Math.max(cappedPriority, intentListCopy.get(i).getIntentFilter().getPriority());
        i = i - 1;
        goto L60
    L63:
        if (intentFilter.getPriority() <= cappedPriority) goto L66;
        intentFilter.setPriority(cappedPriority);
        return;
    }

    private void removeAllComponentsLocked(AndroidPackage pkg, boolean chatty) {
        int componentSize = ArrayUtils.size(pkg.getActivities());
        StringBuilder r = null;
        int i = 0;
    L4:
        if (i >= componentSize) goto L12;
        ParsedActivity a = (ParsedActivity) pkg.getActivities().get(i);
        this.mActivities.removeActivity(a, HostingRecord.HOSTING_TYPE_ACTIVITY);
        if (chatty == false) goto L11;
        if (r != null) goto L9;
        r = new StringBuilder(256);
    L10:
        r.append(a.getName());
        goto L11
    L9:
        r.append(' ');
    L11:
        i = i + 1;
        goto L4
    L12:
        Object r5 = "<NONE>";
        if (chatty == false) goto L19;
        StringBuilder r7 = new StringBuilder();
        r7.append("  Activities: ");
        if (r != null) goto L17;
        Object r8 = "<NONE>";
    L18:
        r7.append(r8);
        Log.d("PackageManager", r7.toString());
        goto L19
    L17:
        r8 = r;
    L19:
        int componentSize2 = ArrayUtils.size(pkg.getProviders());
        StringBuilder r2 = null;
        int i2 = 0;
    L20:
        if (i2 >= componentSize2) goto L40;
        ParsedProvider p = (ParsedProvider) pkg.getProviders().get(i2);
        this.mProviders.removeProvider(p);
        if (p.getAuthority() == null) goto L39;
        String[] names = p.getAuthority().split(";");
        int j = 0;
    L26:
        if (j >= names.length) goto L34;
        if (this.mProvidersByAuthority.get(names[j]) != p) goto L32;
        this.mProvidersByAuthority.remove(names[j]);
        if (chatty == false) goto L32;
        Log.d("PackageManager", "Unregistered content provider: " + names[j] + ", className = " + p.getName() + ", isSyncable = " + p.isSyncable());
    L32:
        j = j + 1;
        goto L26
    L34:
        if (chatty == false) goto L39;
        if (r2 != null) goto L37;
        r2 = new StringBuilder(256);
    L38:
        r2.append(p.getName());
        goto L39
    L37:
        r2.append(' ');
    L39:
        i2 = i2 + 1;
        goto L20
    L40:
        if (chatty == false) goto L46;
        StringBuilder r9 = new StringBuilder();
        r9.append("  Providers: ");
        if (r2 != null) goto L44;
        Object r10 = "<NONE>";
    L45:
        r9.append(r10);
        Log.d("PackageManager", r9.toString());
        goto L46
    L44:
        r10 = r2;
    L46:
        int componentSize3 = ArrayUtils.size(pkg.getReceivers());
        StringBuilder r3 = null;
        int i3 = 0;
    L47:
        if (i3 >= componentSize3) goto L55;
        ParsedActivity a2 = (ParsedActivity) pkg.getReceivers().get(i3);
        this.mReceivers.removeActivity(a2, "receiver");
        if (chatty == false) goto L54;
        if (r3 != null) goto L52;
        r3 = new StringBuilder(256);
    L53:
        r3.append(a2.getName());
        goto L54
    L52:
        r3.append(' ');
    L54:
        i3 = i3 + 1;
        goto L47
    L55:
        if (chatty == false) goto L61;
        StringBuilder r11 = new StringBuilder();
        r11.append("  Receivers: ");
        if (r3 != null) goto L59;
        Object r12 = "<NONE>";
    L60:
        r11.append(r12);
        Log.d("PackageManager", r11.toString());
        goto L61
    L59:
        r12 = r3;
    L61:
        int componentSize4 = ArrayUtils.size(pkg.getServices());
        StringBuilder r4 = null;
        int i4 = 0;
    L62:
        if (i4 >= componentSize4) goto L70;
        ParsedService s = (ParsedService) pkg.getServices().get(i4);
        this.mServices.removeService(s);
        if (chatty == false) goto L69;
        if (r4 != null) goto L67;
        r4 = new StringBuilder(256);
    L68:
        r4.append(s.getName());
        goto L69
    L67:
        r4.append(' ');
    L69:
        i4 = i4 + 1;
        goto L62
    L70:
        if (chatty == false) goto L94;
        StringBuilder r6 = new StringBuilder();
        r6.append("  Services: ");
        if (r4 == null) goto L75;
        r5 = r4;
    L75:
        r6.append(r5);
        Log.d("PackageManager", r6.toString());
        return;
    }

    public void assertProvidersNotDefined(AndroidPackage pkg) throws PackageManagerException {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int providersSize = ArrayUtils.size(pkg.getProviders());     // Catch: Throwable -> L18
        int i = 0;
    L5:
        if (i >= providersSize) goto L29;
        ParsedProvider p = (ParsedProvider) pkg.getProviders().get(i);     // Catch: Throwable -> L18
        if (p.getAuthority() == null) goto L27;
        String[] names = p.getAuthority().split(";");     // Catch: Throwable -> L18
        int j = 0;
    L10:
        if (j >= names.length) goto L27;
        if (this.mProvidersByAuthority.containsKey(names[j]) == false) goto L26;
        ParsedProvider other = this.mProvidersByAuthority.get(names[j]);     // Catch: Throwable -> L18
        if (other != null) goto L16;
    L20:
        String otherPackageName = "?";
    L22:
        if (otherPackageName.equals(pkg.getPackageName()) == true) goto L26;
        throw new PackageManagerException(-13, "Can't install because provider name " + names[j] + " (in package " + pkg.getPackageName() + ") is already used by " + otherPackageName);     // Catch: Throwable -> L18
    L16:
        if (other.getComponentName() == null) goto L20;
        otherPackageName = other.getComponentName().getPackageName();     // Catch: Throwable -> L18
    L26:
        j = j + 1;     // Catch: Throwable -> L18
    L27:
        i = i + 1;     // Catch: Throwable -> L18
        goto L5
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L18
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L18:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public boolean updateMimeGroup(Computer computer, String packageName, String group) {
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        boolean hasChanges = false | this.mActivities.updateMimeGroup(computer, packageName, group);     // Catch: Throwable -> L7
        boolean hasChanges2 = ((hasChanges | this.mProviders.updateMimeGroup(computer, packageName, group)) | this.mReceivers.updateMimeGroup(computer, packageName, group)) | this.mServices.updateMimeGroup(computer, packageName, group);     // Catch: Throwable -> L7
        if (hasChanges2 == false) goto L9;
        onChanged();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return hasChanges2;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public ComponentResolverSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}
