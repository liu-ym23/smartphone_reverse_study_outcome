package com.android.server.pm;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import com.android.internal.config.appcloning.AppCloningDeviceConfigHelper;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.resolution.ComponentResolverApi;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.tukaani.xz.common.Util;

/* JADX INFO: loaded from: classes2.dex */
public class NoFilteringResolver extends CrossProfileResolver {
    private static final String FLAG_ALLOW_INTENT_REDIRECTION_FOR_CLONE_PROFILE = "allow_intent_redirection_for_clone_profile";

    public static boolean isIntentRedirectionAllowed(Context context, AppCloningDeviceConfigHelper appCloningDeviceConfigHelper, boolean resolveForStart, long flags) {
        if ((536870912 & flags) == 0) goto L5;
    L8:
        boolean canMatchCloneProfile = true;
    L10:
        if (isAppCloningBuildingBlocksEnabled(context, appCloningDeviceConfigHelper) == false) goto L17;
        if (resolveForStart == true) goto L18;
        if (canMatchCloneProfile == false) goto L17;
        if (hasPermission(context, "android.permission.QUERY_CLONED_APPS") == false) goto L17;
        return true;
    L18:
        return true;
    L17:
        return false;
    L5:
        if ((Util.BACKWARD_SIZE_MAX & flags) != 0) goto L8;
        canMatchCloneProfile = false;
        goto L10
    }

    public NoFilteringResolver(ComponentResolverApi componentResolver, UserManagerService userManagerService) {
        super(componentResolver, userManagerService);
    }

    @Override // com.android.server.pm.CrossProfileResolver
    public List<CrossProfileDomainInfo> resolveIntent(Computer computer, Intent intent, String resolvedType, int userId, int targetUserId, long flags, String pkgName, List<CrossProfileIntentFilter> matchingFilters, boolean hasNonNegativePriorityResult, Function<String, PackageStateInternal> pkgSettingFunction) {
        List<ResolveInfo> resolveInfos = this.mComponentResolver.queryActivities(computer, intent, resolvedType, flags, targetUserId);
        List<CrossProfileDomainInfo> crossProfileDomainInfos = new ArrayList();
        if (resolveInfos == null) goto L9;
        int index = 0;
    L6:
        if (index >= resolveInfos.size()) goto L9;
        crossProfileDomainInfos.add(new CrossProfileDomainInfo(resolveInfos.get(index), 0, targetUserId));
        index = index + 1;
    L9:
        return filterIfNotSystemUser(crossProfileDomainInfos, userId);
    }

    @Override // com.android.server.pm.CrossProfileResolver
    public List<CrossProfileDomainInfo> filterResolveInfoWithDomainPreferredActivity(Intent intent, List<CrossProfileDomainInfo> crossProfileDomainInfos, long flags, int sourceUserId, int targetUserId, int highestApprovalLevel) {
        return crossProfileDomainInfos;
    }

    private static boolean hasPermission(Context context, String permission) {
        if (context.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isAppCloningBuildingBlocksEnabled(Context context, AppCloningDeviceConfigHelper appCloningDeviceConfigHelper) {
        long token = Binder.clearCallingIdentity();
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        if (context.getResources().getBoolean(R.bool.config_enableBurnInProtection) == false) goto L10;
        if (appCloningDeviceConfigHelper.getEnableAppCloningBuildingBlocks() == false) goto L10;
        boolean r2 = true;
    L11:
        Binder.restoreCallingIdentity(token);
        return r2;
    L10:
        r2 = false;
        goto L11
    }
}
