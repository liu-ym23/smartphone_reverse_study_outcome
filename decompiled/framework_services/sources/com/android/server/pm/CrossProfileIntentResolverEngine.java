package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.config.appcloning.AppCloningDeviceConfigHelper;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import com.android.server.pm.verify.domain.DomainVerificationUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class CrossProfileIntentResolverEngine {
    private AppCloningDeviceConfigHelper mAppCloningDeviceConfigHelper;
    private final Context mContext;
    private final DefaultAppProvider mDefaultAppProvider;
    private final DomainVerificationManagerInternal mDomainVerificationManager;
    private final UserManagerService mUserManager;
    private final UserManagerInternal mUserManagerInternal;

    public CrossProfileIntentResolverEngine(UserManagerService userManager, DomainVerificationManagerInternal domainVerificationManager, DefaultAppProvider defaultAppProvider, Context context) {
        this.mUserManager = userManager;
        this.mDomainVerificationManager = domainVerificationManager;
        this.mDefaultAppProvider = defaultAppProvider;
        this.mContext = context;
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    public List<CrossProfileDomainInfo> resolveIntent(Computer computer, Intent intent, String resolvedType, int userId, long flags, String pkgName, boolean hasNonNegativePriorityResult, boolean resolveForStart, Function<String, PackageStateInternal> pkgSettingFunction) {
        return resolveIntentInternal(computer, intent, resolvedType, userId, userId, flags, pkgName, hasNonNegativePriorityResult, resolveForStart, pkgSettingFunction, null);
    }

    private List<CrossProfileDomainInfo> resolveIntentInternal(Computer computer, Intent intent, String resolvedType, int sourceUserId, int userId, long flags, String pkgName, boolean hasNonNegativePriorityResult, boolean resolveForStart, Function<String, PackageStateInternal> pkgSettingFunction, Set<Integer> visitedUserIds) {
        Computer r1 = computer;
        int r4 = userId;
        if (visitedUserIds == null) goto L5;
        visitedUserIds.add(Integer.valueOf(r4));
    L5:
        List<CrossProfileDomainInfo> crossProfileDomainInfos = new ArrayList();
        Intent r8 = intent;
        String r9 = resolvedType;
        List<CrossProfileIntentFilter> matchingFilters = r1.getMatchingCrossProfileIntentFilters(r8, r9, r4);
        if (matchingFilters == null) goto L46;
        if (matchingFilters.isEmpty() == true) goto L46;
        SparseArray<List<CrossProfileIntentFilter>> crossProfileIntentFiltersByUser = new SparseArray();
        int index = 0;
    L12:
        if (index >= matchingFilters.size()) goto L18;
        CrossProfileIntentFilter crossProfileIntentFilter = matchingFilters.get(index);
        if (crossProfileIntentFiltersByUser.contains(crossProfileIntentFilter.mTargetUserId) == true) goto L16;
        crossProfileIntentFiltersByUser.put(crossProfileIntentFilter.mTargetUserId, new ArrayList());
    L16:
        crossProfileIntentFiltersByUser.get(crossProfileIntentFilter.mTargetUserId).add(crossProfileIntentFilter);
        index = index + 1;
        goto L12
    L18:
        if (visitedUserIds != null) goto L20;
        Set<Integer> visitedUserIds2 = new HashSet();
        visitedUserIds2.add(Integer.valueOf(r4));
        Set<Integer> visitedUserIds3 = visitedUserIds2;
    L21:
        int index2 = 0;
    L23:
        if (index2 >= crossProfileIntentFiltersByUser.size()) goto L43;
        int targetUserId = crossProfileIntentFiltersByUser.keyAt(index2);
        if (visitedUserIds3.contains(Integer.valueOf(targetUserId)) == false) goto L27;
        int index3 = index2;
        List<CrossProfileIntentFilter> matchingFilters2 = matchingFilters;
        int index4 = r4;
    L41:
        index2 = index3 + 1;
        r8 = intent;
        r9 = resolvedType;
        r4 = index4;
        matchingFilters = matchingFilters2;
        goto L23
    L27:
        CrossProfileResolver crossProfileResolver = chooseCrossProfileResolver(r1, r4, targetUserId, resolveForStart, flags);
        if (crossProfileResolver == null) goto L40;
        matchingFilters2 = matchingFilters;
        int index5 = index2;
        List<CrossProfileDomainInfo> crossProfileInfos = crossProfileResolver.resolveIntent(computer, r8, r9, userId, targetUserId, flags, pkgName, crossProfileIntentFiltersByUser.valueAt(index2), hasNonNegativePriorityResult, pkgSettingFunction);
        crossProfileDomainInfos.addAll(crossProfileInfos);
        visitedUserIds3.add(Integer.valueOf(targetUserId));
        int filterIndex = 0;
    L31:
        if (filterIndex >= crossProfileIntentFiltersByUser.valueAt(index5).size()) goto L36;
        if ((crossProfileIntentFiltersByUser.valueAt(index5).get(filterIndex).mFlags & 16) != 0) goto L34;
        filterIndex = filterIndex + 1;
        goto L31
    L34:
        boolean allowChainedResolution = true;
    L37:
        if (allowChainedResolution == false) goto L39;
        index3 = index5;
        r1 = computer;
        index4 = userId;
        crossProfileDomainInfos.addAll(resolveIntentInternal(r1, intent, resolvedType, sourceUserId, targetUserId, flags, pkgName, hasNonNegativePriority(crossProfileInfos), resolveForStart, pkgSettingFunction, visitedUserIds3));
        goto L41
    L39:
        r1 = computer;
        index3 = index5;
        index4 = userId;
        goto L41
    L36:
        allowChainedResolution = false;
        goto L37
    L40:
        r1 = computer;
        index3 = index2;
        matchingFilters2 = matchingFilters;
        index4 = userId;
        goto L41
    L43:
        return crossProfileDomainInfos;
    L20:
        visitedUserIds3 = visitedUserIds;
    L46:
        if (sourceUserId == r4) goto L48;
    L54:
        return crossProfileDomainInfos;
    L48:
        if (intent.hasWebURI() == false) goto L54;
        UserInfo parent = r1.getProfileParent(r4);
        if (parent == null) goto L54;
        CrossProfileDomainInfo generalizedCrossProfileDomainInfo = r1.getCrossProfileDomainPreferredLpr(intent, resolvedType, flags, r4, parent.id);
        if (generalizedCrossProfileDomainInfo == null) goto L54;
        crossProfileDomainInfos.add(generalizedCrossProfileDomainInfo);
        goto L54
    }

    private CrossProfileResolver chooseCrossProfileResolver(Computer computer, int sourceUserId, int targetUserId, boolean resolveForStart, long flags) {
        if (shouldUseNoFilteringResolver(sourceUserId, targetUserId) == false) goto L14;
        if (this.mAppCloningDeviceConfigHelper != null) goto L8;
        this.mAppCloningDeviceConfigHelper = AppCloningDeviceConfigHelper.getInstance(this.mContext);
    L8:
        if (NoFilteringResolver.isIntentRedirectionAllowed(this.mContext, this.mAppCloningDeviceConfigHelper, resolveForStart, flags) == true) goto L10;
        return null;
    L10:
        return new NoFilteringResolver(computer.getComponentResolver(), this.mUserManager);
    L14:
        return new DefaultCrossProfileResolver(computer.getComponentResolver(), this.mUserManager, this.mDomainVerificationManager);
    }

    public boolean canReachTo(Computer computer, Intent intent, String resolvedType, int sourceUserId, int targetUserId) {
        Set<Integer> visitedUserIds = new HashSet();
        return canReachToInternal(computer, intent, resolvedType, sourceUserId, targetUserId, visitedUserIds);
    }

    private boolean canReachToInternal(Computer computer, Intent intent, String resolvedType, int sourceUserId, int targetUserId, Set<Integer> visitedUserIds) {
        int r5 = targetUserId;
        Set<Integer> r6 = visitedUserIds;
        if (sourceUserId != r5) goto L5;
        return true;
    L5:
        r6.add(Integer.valueOf(sourceUserId));
        List<CrossProfileIntentFilter> matches = computer.getMatchingCrossProfileIntentFilters(intent, resolvedType, sourceUserId);
        if (matches == null) goto L22;
        int index = 0;
    L9:
        if (index >= matches.size()) goto L30;
        CrossProfileIntentFilter crossProfileIntentFilter = matches.get(index);
        if (crossProfileIntentFilter.mTargetUserId == r5) goto L12;
        if (r6.contains(Integer.valueOf(crossProfileIntentFilter.mTargetUserId)) == true) goto L21;
        if ((crossProfileIntentFilter.mFlags & 16) == 0) goto L21;
        r6.add(Integer.valueOf(crossProfileIntentFilter.mTargetUserId));
        if (canReachToInternal(computer, intent, resolvedType, crossProfileIntentFilter.mTargetUserId, r5, r6) == false) goto L21;
        return true;
    L21:
        index = index + 1;
        r5 = targetUserId;
        r6 = visitedUserIds;
        goto L9
    L12:
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    public boolean shouldSkipCurrentProfile(Computer computer, Intent intent, String resolvedType, int sourceUserId) {
        List<CrossProfileIntentFilter> matches = computer.getMatchingCrossProfileIntentFilters(intent, resolvedType, sourceUserId);
        if (matches == null) goto L12;
        int matchIndex = 0;
    L6:
        if (matchIndex >= matches.size()) goto L16;
        CrossProfileIntentFilter crossProfileIntentFilter = matches.get(matchIndex);
        if ((crossProfileIntentFilter.getFlags() & 2) != 0) goto L9;
        matchIndex = matchIndex + 1;
        goto L6
    L9:
        return true;
    L16:
        return false;
    L12:
        return false;
    }

    public QueryIntentActivitiesResult combineFilterAndCreateQueryActivitiesResponse(Computer computer, Intent intent, String resolvedType, String instantAppPkgName, String pkgName, boolean allowDynamicSplits, long matchFlags, int userId, int filterCallingUid, boolean resolveForStart, List<ResolveInfo> candidates, List<CrossProfileDomainInfo> crossProfileCandidates, boolean areWebInstantAppsDisabled, boolean addInstant, boolean sortResult, Function<String, PackageStateInternal> pkgSettingFunction) {
        List<ResolveInfo> candidates2 = candidates;
        if (shouldSkipCurrentProfile(computer, intent, resolvedType, userId) == false) goto L7;
        return new QueryIntentActivitiesResult(computer.applyPostResolutionFilter(resolveInfoFromCrossProfileDomainInfo(crossProfileCandidates), instantAppPkgName, allowDynamicSplits, filterCallingUid, resolveForStart, userId, intent));
    L7:
        if (pkgName == null) goto L9;
    L22:
        Intent r7 = intent;
        int r6 = userId;
        candidates2.addAll(resolveInfoFromCrossProfileDomainInfo(crossProfileCandidates));
    L24:
        if (candidates2.size() != 1) goto L31;
        if (UserHandle.of(r6).equals(candidates2.get(0).userHandle) == true) goto L31;
        if (isNoFilteringPropertyConfiguredForUser(r6) == false) goto L31;
        r7.prepareToLeaveUser(r6);
    L31:
        return new QueryIntentActivitiesResult(sortResult, addInstant, candidates2);
    L9:
        if (intent.hasWebURI() == false) goto L22;
        if (addInstant == false) goto L12;
    L21:
        r6 = userId;
        r7 = intent;
        candidates2 = filterCandidatesWithDomainPreferredActivitiesLPr(computer, intent, matchFlags, candidates, crossProfileCandidates, userId, areWebInstantAppsDisabled, resolveForStart, pkgSettingFunction);
        goto L24
    L12:
        if (candidates2.size() > 1) goto L16;
        if (crossProfileCandidates.isEmpty() == false) goto L16;
    L19:
        candidates2.addAll(resolveInfoFromCrossProfileDomainInfo(crossProfileCandidates));
        return new QueryIntentActivitiesResult(computer.applyPostResolutionFilter(candidates2, instantAppPkgName, allowDynamicSplits, filterCallingUid, resolveForStart, userId, intent));
    L16:
        if (candidates2.isEmpty() == false) goto L21;
        if (crossProfileCandidates.isEmpty() == true) goto L21;
        goto L19
    }

    private List<ResolveInfo> filterCandidatesWithDomainPreferredActivitiesLPr(Computer computer, Intent intent, long matchFlags, List<ResolveInfo> candidates, List<CrossProfileDomainInfo> crossProfileCandidates, int userId, boolean areWebInstantAppsDisabled, boolean resolveForStart, Function<String, PackageStateInternal> pkgSettingFunction) {
        if ((intent.getFlags() & 8) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean debug = r0;
        List<ResolveInfo> result = filterCandidatesWithDomainPreferredActivitiesLPrBody(computer, intent, matchFlags, candidates, crossProfileCandidates, userId, areWebInstantAppsDisabled, debug, resolveForStart, pkgSettingFunction);
        return result;
    L5:
        r0 = false;
        goto L6
    }

    private List<ResolveInfo> filterCandidatesWithDomainPreferredActivitiesLPrBody(Computer computer, Intent intent, long matchFlags, List<ResolveInfo> candidates, List<CrossProfileDomainInfo> crossProfileCandidates, int userId, boolean areWebInstantAppsDisabled, boolean debug, boolean resolveForStart, Function<String, PackageStateInternal> pkgSettingFunction) {
        int r6 = userId;
        ArrayList<ResolveInfo> result = new ArrayList();
        ArrayList<ResolveInfo> matchAllList = new ArrayList();
        ArrayList<ResolveInfo> undefinedList = new ArrayList();
        if (intent.isWebIntent() == false) goto L6;
        if (areWebInstantAppsDisabled == false) goto L6;
        boolean r0 = true;
    L7:
        boolean blockInstant = r0;
        int count = candidates.size();
        int n = 0;
    L8:
        if (n >= count) goto L23;
        ResolveInfo info = candidates.get(n);
        if (blockInstant == false) goto L19;
        if (info.isInstantAppAvailable == true) goto L22;
        if (computer.isInstantAppInternal(info.activityInfo.packageName, r6, 1000) == false) goto L19;
    L22:
        n = n + 1;
    L19:
        if (info.handleAllWebDataURI == false) goto L21;
        matchAllList.add(info);
        goto L22
    L21:
        undefinedList.add(info);
        goto L22
    L23:
        boolean includeBrowser = false;
        SparseArray<List<CrossProfileDomainInfo>> categorizeResolveInfoByTargetUser = new SparseArray();
        if (crossProfileCandidates == null) goto L35;
        if (crossProfileCandidates.isEmpty() == true) goto L35;
        int index = 0;
    L29:
        if (index >= crossProfileCandidates.size()) goto L35;
        CrossProfileDomainInfo crossProfileDomainInfo = crossProfileCandidates.get(index);
        if (categorizeResolveInfoByTargetUser.contains(crossProfileDomainInfo.mTargetUserId) == true) goto L33;
        categorizeResolveInfoByTargetUser.put(crossProfileDomainInfo.mTargetUserId, new ArrayList());
    L33:
        categorizeResolveInfoByTargetUser.get(crossProfileDomainInfo.mTargetUserId).add(crossProfileDomainInfo);
        index = index + 1;
    L35:
        if (DomainVerificationUtils.isDomainVerificationIntent(intent, matchFlags) == true) goto L37;
        result.addAll(undefinedList);
        CrossProfileIntentResolverEngine r1 = this;
        result.addAll(r1.filterCrossProfileCandidatesWithDomainPreferredActivities(computer, intent, matchFlags, categorizeResolveInfoByTargetUser, r6, 0, resolveForStart));
        includeBrowser = true;
    L41:
        if (includeBrowser == true) goto L43;
    L76:
        return result;
    L43:
        if ((matchFlags & 131072) == 0) goto L45;
        result.addAll(matchAllList);
    L74:
        if (result.size() != 0) goto L76;
        result.addAll(candidates);
        goto L76
    L45:
        String defaultBrowserPackageName = r1.mDefaultAppProvider.getDefaultBrowser(r6);
        int maxMatchPrio = 0;
        ResolveInfo defaultBrowserMatch = null;
        int numCandidates = matchAllList.size();
        int n2 = 0;
    L47:
        if (n2 >= numCandidates) goto L63;
        ResolveInfo info2 = matchAllList.get(n2);
        if (info2.priority <= maxMatchPrio) goto L52;
        maxMatchPrio = info2.priority;
    L52:
        if (info2.activityInfo.packageName.equals(defaultBrowserPackageName) == false) goto L61;
        if (defaultBrowserMatch == null) goto L57;
        String defaultBrowserPackageName2 = defaultBrowserPackageName;
        if (defaultBrowserMatch.priority >= info2.priority) goto L62;
    L58:
        if (debug == false) goto L60;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Considering default browser match " + info2);
    L60:
        defaultBrowserMatch = info2;
    L62:
        n2 = n2 + 1;
        defaultBrowserPackageName = defaultBrowserPackageName2;
        goto L47
    L57:
        defaultBrowserPackageName2 = defaultBrowserPackageName;
        goto L58
    L61:
        defaultBrowserPackageName2 = defaultBrowserPackageName;
        goto L62
    L63:
        String defaultBrowserPackageName3 = defaultBrowserPackageName;
        if (defaultBrowserMatch != null) goto L66;
    L72:
        result.addAll(matchAllList);
        goto L74
    L66:
        if (defaultBrowserMatch.priority < maxMatchPrio) goto L72;
        if (TextUtils.isEmpty(defaultBrowserPackageName3) == true) goto L72;
        if (debug == false) goto L71;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Default browser match " + defaultBrowserMatch);
    L71:
        result.add(defaultBrowserMatch);
        goto L74
    L37:
        Pair<List<ResolveInfo>, Integer> infosAndLevel = this.mDomainVerificationManager.filterToApprovedApp(intent, undefinedList, r6, pkgSettingFunction);
        List<ResolveInfo> approvedInfos = (List) infosAndLevel.first;
        Integer highestApproval = (Integer) infosAndLevel.second;
        if (approvedInfos.isEmpty() == false) goto L40;
        includeBrowser = true;
        result.addAll(filterCrossProfileCandidatesWithDomainPreferredActivities(computer, intent, matchFlags, categorizeResolveInfoByTargetUser, r6, 0, resolveForStart));
        r1 = this;
        r6 = userId;
        goto L41
    L40:
        result.addAll(approvedInfos);
        r1 = this;
        r6 = userId;
        result.addAll(r1.filterCrossProfileCandidatesWithDomainPreferredActivities(computer, intent, matchFlags, categorizeResolveInfoByTargetUser, r6, highestApproval.intValue(), resolveForStart));
    L6:
        r0 = false;
        goto L7
    }

    private List<ResolveInfo> filterCrossProfileCandidatesWithDomainPreferredActivities(Computer computer, Intent intent, long flags, SparseArray<List<CrossProfileDomainInfo>> categorizeResolveInfoByTargetUser, int sourceUserId, int highestApprovalLevel, boolean resolveForStart) {
        List<CrossProfileDomainInfo> crossProfileDomainInfos = new ArrayList();
        int index = 0;
    L4:
        if (index >= categorizeResolveInfoByTargetUser.size()) goto L14;
        if (categorizeResolveInfoByTargetUser.keyAt(index) != (-2)) goto L8;
        crossProfileDomainInfos.addAll(categorizeResolveInfoByTargetUser.valueAt(index));
    L12:
        index = index + 1;
        goto L4
    L8:
        CrossProfileResolver crossProfileIntentResolver = chooseCrossProfileResolver(computer, sourceUserId, categorizeResolveInfoByTargetUser.keyAt(index), resolveForStart, flags);
        if (crossProfileIntentResolver == null) goto L11;
        crossProfileDomainInfos.addAll(crossProfileIntentResolver.filterResolveInfoWithDomainPreferredActivity(intent, categorizeResolveInfoByTargetUser.valueAt(index), flags, sourceUserId, categorizeResolveInfoByTargetUser.keyAt(index), highestApprovalLevel));
        goto L12
    L11:
        crossProfileDomainInfos.addAll(categorizeResolveInfoByTargetUser.valueAt(index));
        goto L12
    L14:
        return resolveInfoFromCrossProfileDomainInfo(crossProfileDomainInfos);
    }

    private List<ResolveInfo> resolveInfoFromCrossProfileDomainInfo(List<CrossProfileDomainInfo> crossProfileDomainInfos) {
        List<ResolveInfo> resolveInfoList = new ArrayList();
        int infoIndex = 0;
    L4:
        if (infoIndex >= crossProfileDomainInfos.size()) goto L7;
        resolveInfoList.add(crossProfileDomainInfos.get(infoIndex).mResolveInfo);
        infoIndex = infoIndex + 1;
        goto L4
    L7:
        return resolveInfoList;
    }

    private boolean hasNonNegativePriority(List<CrossProfileDomainInfo> crossProfileDomainInfos) {
        if (crossProfileDomainInfos.size() > 0) goto L5;
        return false;
    L5:
        if (crossProfileDomainInfos.get(0).mResolveInfo != null) goto L7;
        return false;
    L7:
        if (crossProfileDomainInfos.get(0).mResolveInfo.priority < 0) goto L13;
        return true;
    L13:
        return false;
    }

    private boolean shouldUseNoFilteringResolver(int sourceUserId, int targetUserId) {
        if (isNoFilteringPropertyConfiguredForUser(sourceUserId) == false) goto L5;
    L8:
        return true;
    L5:
        if (isNoFilteringPropertyConfiguredForUser(targetUserId) == true) goto L8;
        return false;
    }

    private boolean isNoFilteringPropertyConfiguredForUser(int userId) {
        if (this.mUserManager.isProfile(userId) == true) goto L5;
        return false;
    L5:
        UserProperties userProperties = this.mUserManagerInternal.getUserProperties(userId);
        if (userProperties != null) goto L9;
        return false;
    L9:
        if (userProperties.getCrossProfileIntentResolutionStrategy() == 1) goto L11;
        return false;
    L11:
        return true;
    }
}
