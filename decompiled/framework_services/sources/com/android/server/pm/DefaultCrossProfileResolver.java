package com.android.server.pm;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.util.SparseBooleanArray;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultCrossProfileResolver extends CrossProfileResolver {
    private final DomainVerificationManagerInternal mDomainVerificationManager;

    public DefaultCrossProfileResolver(ComponentResolverApi componentResolver, UserManagerService userManager, DomainVerificationManagerInternal domainVerificationManager) {
        super(componentResolver, userManager);
        this.mDomainVerificationManager = domainVerificationManager;
    }

    @Override // com.android.server.pm.CrossProfileResolver
    public List<CrossProfileDomainInfo> resolveIntent(Computer computer, Intent intent, String resolvedType, int userId, int targetUserId, long flags, String pkgName, List<CrossProfileIntentFilter> matchingFilters, boolean hasNonNegativePriorityResult, Function<String, PackageStateInternal> pkgSettingFunction) {
        List<CrossProfileDomainInfo> xpResult = new ArrayList();
        if (pkgName == null) goto L5;
        return xpResult;
    L5:
        CrossProfileDomainInfo skipProfileInfo = querySkipCurrentProfileIntents(computer, matchingFilters, intent, resolvedType, flags, userId, pkgSettingFunction);
        if (skipProfileInfo == null) goto L9;
        xpResult.add(skipProfileInfo);
        return filterIfNotSystemUser(xpResult, userId);
    L9:
        CrossProfileDomainInfo specificXpInfo = queryCrossProfileIntents(computer, matchingFilters, intent, resolvedType, flags, userId, hasNonNegativePriorityResult, pkgSettingFunction);
        if (intent.hasWebURI() == false) goto L20;
        CrossProfileDomainInfo generalXpInfo = null;
        UserInfo parent = getProfileParent(userId);
        if (parent == null) goto L14;
        generalXpInfo = computer.getCrossProfileDomainPreferredLpr(intent, resolvedType, flags, userId, parent.id);
    L14:
        if (generalXpInfo == null) goto L16;
        CrossProfileDomainInfo prioritizedXpInfo = generalXpInfo;
    L17:
        if (prioritizedXpInfo == null) goto L22;
        xpResult.add(prioritizedXpInfo);
    L22:
        return xpResult;
    L16:
        prioritizedXpInfo = specificXpInfo;
        goto L17
    L20:
        if (specificXpInfo == null) goto L22;
        xpResult.add(specificXpInfo);
        goto L22
    }

    @Override // com.android.server.pm.CrossProfileResolver
    public List<CrossProfileDomainInfo> filterResolveInfoWithDomainPreferredActivity(Intent intent, List<CrossProfileDomainInfo> crossProfileDomainInfos, long flags, int sourceUserId, int targetUserId, int highestApprovalLevel) {
        List<CrossProfileDomainInfo> filteredCrossProfileDomainInfos = new ArrayList();
        if (crossProfileDomainInfos != null) goto L5;
    L13:
        return filteredCrossProfileDomainInfos;
    L5:
        if (crossProfileDomainInfos.isEmpty() == true) goto L13;
        int index = 0;
    L8:
        if (index >= crossProfileDomainInfos.size()) goto L13;
        CrossProfileDomainInfo crossProfileDomainInfo = crossProfileDomainInfos.get(index);
        if (crossProfileDomainInfo.mHighestApprovalLevel <= highestApprovalLevel) goto L12;
        filteredCrossProfileDomainInfos.add(crossProfileDomainInfo);
    L12:
        index = index + 1;
        goto L8
    }

    private CrossProfileDomainInfo querySkipCurrentProfileIntents(Computer computer, List<CrossProfileIntentFilter> matchingFilters, Intent intent, String resolvedType, long flags, int sourceUserId, Function<String, PackageStateInternal> pkgSettingFunction) {
        if (matchingFilters == null) goto L11;
        int size = matchingFilters.size();
        int i = 0;
    L4:
        if (i >= size) goto L17;
        CrossProfileIntentFilter filter = matchingFilters.get(i);
        if ((filter.getFlags() & 2) == 0) goto L10;
        CrossProfileDomainInfo info = createForwardingResolveInfo(computer, filter, intent, resolvedType, flags, sourceUserId, pkgSettingFunction);
        if (info == null) goto L10;
        return info;
    L10:
        i = i + 1;
        goto L4
    L17:
        return null;
    L11:
        return null;
    }

    private CrossProfileDomainInfo queryCrossProfileIntents(Computer computer, List<CrossProfileIntentFilter> matchingFilters, Intent intent, String resolvedType, long flags, int sourceUserId, boolean matchInCurrentProfile, Function<String, PackageStateInternal> pkgSettingFunction) {
        CrossProfileDomainInfo r10 = null;
        if (matchingFilters != null) goto L5;
        return null;
    L5:
        SparseBooleanArray alreadyTriedUserIds = new SparseBooleanArray();
        CrossProfileDomainInfo resultInfo = null;
        int size = matchingFilters.size();
        int i = 0;
    L6:
        if (i >= size) goto L28;
        CrossProfileIntentFilter filter = matchingFilters.get(i);
        int targetUserId = filter.getTargetUserId();
        boolean r1 = false;
        if ((filter.getFlags() & 2) == 0) goto L10;
        boolean r0 = true;
    L11:
        boolean skipCurrentProfile = r0;
        if ((filter.getFlags() & 4) == 0) goto L14;
        r1 = true;
    L14:
        boolean skipCurrentProfileIfNoMatchFound = r1;
        if (skipCurrentProfile == false) goto L17;
    L26:
        CrossProfileDomainInfo r18 = r10;
    L27:
        i = i + 1;
        r10 = r18;
        goto L6
    L17:
        if (alreadyTriedUserIds.get(targetUserId) == true) goto L26;
        if (skipCurrentProfileIfNoMatchFound == false) goto L22;
        if (matchInCurrentProfile == false) goto L22;
        r18 = r10;
    L22:
        DefaultCrossProfileResolver r2 = this;
        r18 = r10;
        CrossProfileDomainInfo info = r2.createForwardingResolveInfo(computer, filter, intent, resolvedType, flags, sourceUserId, pkgSettingFunction);
        if (info != null) goto L24;
        alreadyTriedUserIds.put(targetUserId, true);
        goto L27
    L24:
        resultInfo = info;
    L29:
        if (resultInfo != null) goto L31;
        return r18;
    L31:
        ResolveInfo forwardingResolveInfo = resultInfo.mResolveInfo;
        if (r2.isUserEnabled(forwardingResolveInfo.targetUserId) == true) goto L34;
        return r18;
    L34:
        List<CrossProfileDomainInfo> filteredResult = r2.filterIfNotSystemUser(Collections.singletonList(resultInfo), sourceUserId);
        if (filteredResult.isEmpty() == false) goto L37;
        return r18;
    L37:
        return resultInfo;
    L10:
        r0 = false;
        goto L11
    L28:
        r2 = this;
        r18 = r10;
        goto L29
    }

    protected CrossProfileDomainInfo createForwardingResolveInfo(Computer computer, CrossProfileIntentFilter filter, Intent intent, String resolvedType, long flags, int sourceUserId, Function<String, PackageStateInternal> pkgSettingFunction) {
        int targetUserId = filter.getTargetUserId();
        if (isUserEnabled(targetUserId) == true) goto L5;
        return null;
    L5:
        List<ResolveInfo> resultTargetUser = this.mComponentResolver.queryActivities(computer, intent, resolvedType, flags, targetUserId);
        if (CollectionUtils.isEmpty(resultTargetUser) == false) goto L8;
        return null;
    L8:
        int i = resultTargetUser.size() - 1;
    L9:
        if (i < 0) goto L14;
        ResolveInfo targetUserResolveInfo = resultTargetUser.get(i);
        if ((targetUserResolveInfo.activityInfo.applicationInfo.flags & 1073741824) == 0) goto L12;
        i = i - 1;
        goto L9
    L12:
        ResolveInfo forwardingInfo = computer.createForwardingResolveInfoUnchecked(filter, sourceUserId, targetUserId);
        ResolveInfo forwardingInfo2 = forwardingInfo;
    L15:
        if (forwardingInfo2 != null) goto L17;
        return null;
    L17:
        int size = resultTargetUser.size();
        int highestApprovalLevel = 0;
        int i2 = 0;
    L18:
        if (i2 >= size) goto L28;
        ResolveInfo riTargetUser = resultTargetUser.get(i2);
        if (riTargetUser.handleAllWebDataURI == true) goto L24;
        String packageName = riTargetUser.activityInfo.packageName;
        PackageStateInternal ps = pkgSettingFunction.apply(packageName);
        if (ps == null) goto L24;
        int targetUserId2 = targetUserId;
        highestApprovalLevel = Math.max(highestApprovalLevel, this.mDomainVerificationManager.approvalLevelForDomain(ps, intent, flags, targetUserId2));
    L26:
        i2 = i2 + 1;
        targetUserId = targetUserId2;
    L24:
        targetUserId2 = targetUserId;
        goto L26
    L28:
        return new CrossProfileDomainInfo(forwardingInfo2, highestApprovalLevel, targetUserId);
    L14:
        forwardingInfo2 = null;
        goto L15
    }
}
