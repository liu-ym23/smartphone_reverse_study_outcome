package com.android.server.pm;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.Binder;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.resolution.ComponentResolverApi;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CrossProfileResolver {
    protected final ComponentResolverApi mComponentResolver;
    protected final UserManagerService mUserManager;

    public abstract List<CrossProfileDomainInfo> filterResolveInfoWithDomainPreferredActivity(Intent r1, List<CrossProfileDomainInfo> r2, long r3, int r5, int r6, int r7);

    public abstract List<CrossProfileDomainInfo> resolveIntent(Computer r1, Intent r2, String r3, int r4, int r5, long r6, String r8, List<CrossProfileIntentFilter> r9, boolean r10, Function<String, PackageStateInternal> r11);

    public CrossProfileResolver(ComponentResolverApi componentResolver, UserManagerService userManager) {
        this.mComponentResolver = componentResolver;
        this.mUserManager = userManager;
    }

    protected final boolean isUserEnabled(int userId) {
        long callingId = Binder.clearCallingIdentity();
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L8
        if (userInfo == null) goto L10;
        if (userInfo.isEnabled() == false) goto L10;
        boolean r3 = true;
    L11:
        Binder.restoreCallingIdentity(callingId);
        return r3;
    L10:
        r3 = false;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    protected final List<CrossProfileDomainInfo> filterIfNotSystemUser(List<CrossProfileDomainInfo> crossProfileDomainInfos, int userId) {
        if (userId != 0) goto L4;
        return crossProfileDomainInfos;
    L4:
        int i = CollectionUtils.size(crossProfileDomainInfos) - 1;
    L5:
        if (i < 0) goto L11;
        ResolveInfo info = crossProfileDomainInfos.get(i).mResolveInfo;
        if ((info.activityInfo.flags & 536870912) == 0) goto L9;
        crossProfileDomainInfos.remove(i);
    L9:
        i = i - 1;
        goto L5
    L11:
        return crossProfileDomainInfos;
    }

    protected final UserInfo getProfileParent(int userId) {
        long identity = Binder.clearCallingIdentity();
        UserInfo r2 = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }
}
