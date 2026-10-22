package com.android.server.pm;

import android.content.Context;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.util.ArraySet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class CrossProfileIntentFilterHelper {
    private final Context mContext;
    private final PackageManagerTracedLock mLock;
    private final Settings mSettings;
    private final UserManagerInternal mUserManagerInternal;
    private final UserManagerService mUserManagerService;

    public CrossProfileIntentFilterHelper(Settings settings, UserManagerService userManagerService, PackageManagerTracedLock lock, UserManagerInternal userManagerInternal, Context context) {
        this.mSettings = settings;
        this.mUserManagerService = userManagerService;
        this.mLock = lock;
        this.mContext = context;
        this.mUserManagerInternal = userManagerInternal;
    }

    public void updateDefaultCrossProfileIntentFilter() {
        Iterator<UserInfo> r0 = this.mUserManagerInternal.getUsers(false).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        UserInfo userInfo = r0.next();
        UserProperties currentUserProperties = this.mUserManagerInternal.getUserProperties(userInfo.id);
        if (currentUserProperties == null) goto L4;
        if (currentUserProperties.getUpdateCrossProfileIntentFiltersOnOTA() == false) goto L4;
        int parentUserId = this.mUserManagerInternal.getProfileParentId(userInfo.id);
        if (parentUserId == userInfo.id) goto L4;
        clearCrossProfileIntentFilters(userInfo.id, this.mContext.getOpPackageName(), Integer.valueOf(parentUserId));
        clearCrossProfileIntentFilters(parentUserId, this.mContext.getOpPackageName(), Integer.valueOf(userInfo.id));
        this.mUserManagerInternal.setDefaultCrossProfileIntentFilters(parentUserId, userInfo.id);
        goto L4
    }

    public void clearCrossProfileIntentFilters(int sourceUserId, String ownerPackage, Integer targetUserId) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        CrossProfileIntentResolver resolver = this.mSettings.editCrossProfileIntentResolverLPw(sourceUserId);     // Catch: Throwable -> L13
        ArraySet<CrossProfileIntentFilter> set = new ArraySet(resolver.filterSet());     // Catch: Throwable -> L13
        Iterator<CrossProfileIntentFilter> r3 = set.iterator();     // Catch: Throwable -> L13
    L6:
        if (r3.hasNext() == false) goto L19;
        CrossProfileIntentFilter filter = r3.next();     // Catch: Throwable -> L13
        if (filter.getOwnerPackage().equals(ownerPackage) == false) goto L6;
        if (targetUserId == null) goto L16;
        if (filter.mTargetUserId != targetUserId.intValue()) goto L6;
    L16:
        if (this.mUserManagerService.isCrossProfileIntentFilterAccessible(sourceUserId, filter.mTargetUserId, false) == false) goto L6;
        resolver.removeFilter(filter);     // Catch: Throwable -> L13
        goto L6
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }
}
