package com.android.server.pm;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.AuxiliaryResolveInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.app.ResolverActivity;
import com.android.internal.util.ArrayUtils;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
final class ResolveIntentHelper {
    private final Context mContext;
    private final DomainVerificationManagerInternal mDomainVerificationManager;
    private final Supplier<ActivityInfo> mInstantAppInstallerActivitySupplier;
    private final PlatformCompat mPlatformCompat;
    private final PreferredActivityHelper mPreferredActivityHelper;
    private final Supplier<ResolveInfo> mResolveInfoSupplier;
    private final UserManagerService mUserManager;
    private final UserNeedsBadgingCache mUserNeedsBadging;

    ResolveIntentHelper(Context context, PreferredActivityHelper preferredActivityHelper, PlatformCompat platformCompat, UserManagerService userManager, DomainVerificationManagerInternal domainVerificationManager, UserNeedsBadgingCache userNeedsBadgingCache, Supplier<ResolveInfo> resolveInfoSupplier, Supplier<ActivityInfo> instantAppInstallerActivitySupplier) {
        this.mContext = context;
        this.mPreferredActivityHelper = preferredActivityHelper;
        this.mPlatformCompat = platformCompat;
        this.mUserManager = userManager;
        this.mDomainVerificationManager = domainVerificationManager;
        this.mUserNeedsBadging = userNeedsBadgingCache;
        this.mResolveInfoSupplier = resolveInfoSupplier;
        this.mInstantAppInstallerActivitySupplier = instantAppInstallerActivitySupplier;
    }

    public ResolveInfo resolveIntentInternal(Computer computer, Intent intent, String resolvedType, long flags, long privateResolveFlags, int userId, boolean resolveForStart, int filterCallingUid, int callingPid) {
        Trace.traceBegin(262144, "resolveIntent");     // Catch: Throwable -> L42
        if (this.mUserManager.exists(userId) == true) goto L8;
        Trace.traceEnd(262144);
        return null;
    L8:
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L42
        long flags2 = computer.updateFlagsForResolve(flags, userId, filterCallingUid, resolveForStart, computer.isImplicitImageCaptureIntentAndNotSetByDpc(intent, userId, resolvedType, flags));     // Catch: Throwable -> L42
        computer.enforceCrossUserPermission(callingUid, userId, false, false, "resolve intent");     // Catch: Throwable -> L18
        Trace.traceBegin(262144, "queryIntentActivities");     // Catch: Throwable -> L18
        List<ResolveInfo> query = computer.queryIntentActivitiesInternal(intent, resolvedType, flags2, privateResolveFlags, filterCallingUid, callingPid, userId, resolveForStart, true);     // Catch: Throwable -> L20
        if (userId == 10) goto L14;
    L22:
        List<ResolveInfo> query2 = query;
    L23:
        Trace.traceEnd(262144);     // Catch: Throwable -> L20
        if (resolveForStart == false) goto L26;
        SaferIntentUtils.IntentArgs args = new SaferIntentUtils.IntentArgs(intent, resolvedType, false, true, filterCallingUid, callingPid);     // Catch: Throwable -> L20
        args.platformCompat = this.mPlatformCompat;     // Catch: Throwable -> L20
        SaferIntentUtils.filterNonExportedComponents(args, query2);     // Catch: Throwable -> L20
    L26:
        boolean nonBrowserOnly = false;
        if (UserHandle.getAppId(filterCallingUid) < 10000) goto L30;
        if (resolveForStart == true) goto L30;
        boolean queryMayBeFiltered = true;
    L31:
        ResolveInfo bestChoice = chooseBestActivity(computer, intent, resolvedType, flags2, privateResolveFlags, query2, userId, queryMayBeFiltered);     // Catch: Throwable -> L20
        if ((privateResolveFlags & 1) == 0) goto L34;
        nonBrowserOnly = true;
    L34:
        if (nonBrowserOnly == false) goto L40;
        if (bestChoice == null) goto L40;
        if (bestChoice.handleAllWebDataURI == false) goto L40;
        Trace.traceEnd(262144);
        return null;
    L40:
        Trace.traceEnd(262144);
        return bestChoice;
    L30:
        queryMayBeFiltered = false;
        goto L31
    L14:
        if (query.isEmpty() == false) goto L22;
        flags2 = flags2;
        query2 = computer.queryIntentActivitiesInternal(intent, resolvedType, flags2, privateResolveFlags, filterCallingUid, callingPid, 0, resolveForStart, true);     // Catch: Throwable -> L18
    L20:
        th = th;
    L44:
        Trace.traceEnd(262144);
        throw th;
    L18:
        th = th;
    L42:
        th = th;
        goto L44
    }

    private ResolveInfo chooseBestActivity(Computer computer, Intent intent, String resolvedType, long flags, long privateResolveFlags, List<ResolveInfo> query, int userId, boolean queryMayBeFiltered) {
        if (query == null) goto L80;
        int n = query.size();
        if (n == 1) goto L7;
        if (n > 1) goto L17;
        return null;
    L17:
        if ((intent.getFlags() & 8) == 0) goto L19;
        boolean debug = true;
    L20:
        ResolveInfo r0 = query.get(0);
        ResolveInfo r1 = query.get(1);
        if (debug == false) goto L24;
        Slog.v(PackageManagerServiceMonitorEx.TAG, r0.activityInfo.name + "=" + r0.priority + " vs " + r1.activityInfo.name + "=" + r1.priority);
    L24:
        if (r0.priority != r1.priority) goto L78;
        if (r0.preferredOrder != r1.preferredOrder) goto L78;
        if (r0.isDefault != r1.isDefault) goto L78;
        ResolveInfo ri = this.mPreferredActivityHelper.findPreferredActivityNotLocked(computer, intent, resolvedType, flags, query, true, false, debug, userId, queryMayBeFiltered);
        if (ri == null) goto L33;
        return ri;
    L33:
        int browserCount = 0;
        int i = 0;
    L34:
        if (i >= n) goto L50;
        ResolveInfo ri2 = query.get(i);
        if (ri2.handleAllWebDataURI == false) goto L38;
        int browserCount2 = browserCount + 1;
    L40:
        if (ri2.activityInfo.applicationInfo.isInstantApp() == false) goto L48;
        String packageName = ri2.activityInfo.packageName;
        PackageStateInternal ps = computer.getPackageStateInternal(packageName);
        if (ps == null) goto L48;
        if (PackageManagerServiceUtils.hasAnyDomainApproval(this.mDomainVerificationManager, ps, intent, flags, userId) == false) goto L48;
        return ri2;
    L48:
        i = i + 1;
        browserCount = browserCount2;
        goto L34
    L38:
        browserCount2 = browserCount;
        goto L40
    L50:
        if ((privateResolveFlags & 2) == 0) goto L52;
        return null;
    L52:
        ResolveInfo ri3 = new ResolveInfo(this.mResolveInfoSupplier.get());
        if (browserCount != n) goto L55;
        boolean r2 = true;
    L56:
        ri3.handleAllWebDataURI = r2;
        ri3.activityInfo = new ActivityInfo(ri3.activityInfo);
        ri3.activityInfo.labelRes = ResolverActivity.getLabelRes(intent.getAction());
        if (ri3.userHandle != null) goto L59;
        ri3.userHandle = UserHandle.of(userId);
    L59:
        String intentPackage = intent.getPackage();
        if (TextUtils.isEmpty(intentPackage) == false) goto L62;
    L68:
        ri3.activityInfo.applicationInfo = new ApplicationInfo(ri3.activityInfo.applicationInfo);
        if (userId == 0) goto L72;
        ri3.activityInfo.applicationInfo.uid = UserHandle.getUid(userId, UserHandle.getAppId(ri3.activityInfo.applicationInfo.uid));
    L72:
        if (ri3.activityInfo.metaData != null) goto L74;
        ri3.activityInfo.metaData = new Bundle();
    L74:
        ri3.activityInfo.metaData.putBoolean("android.dock_home", true);
        return ri3;
    L62:
        if (allHavePackage(query, intentPackage) == false) goto L68;
        ApplicationInfo appi = query.get(0).activityInfo.applicationInfo;
        ri3.resolvePackageName = intentPackage;
        if (this.mUserNeedsBadging.get(userId) == false) goto L66;
        ri3.noResourceId = true;
    L67:
        ri3.iconResourceId = appi.icon;
        ri3.labelRes = appi.labelRes;
        goto L68
    L66:
        ri3.icon = appi.icon;
        goto L67
    L55:
        r2 = false;
    L78:
        return query.get(0);
    L19:
        debug = false;
        goto L20
    L7:
        if (query.get(0).getSmtEx().isSearchPackagesInfo == false) goto L14;
        ResolveInfo ri4 = PackageManagerServiceSmtEx.getChooseBestResolveInfo(userId, this.mResolveInfoSupplier.get());
        if (ri4 == null) goto L12;
        return ri4;
    L12:
        return this.mResolveInfoSupplier.get();
    L14:
        return query.get(0);
    L80:
        return null;
    }

    private boolean allHavePackage(List<ResolveInfo> list, String packageName) {
        if (ArrayUtils.isEmpty(list) == false) goto L5;
        return false;
    L5:
        int i = 0;
        int n = list.size();
    L6:
        if (i >= n) goto L17;
        ResolveInfo ri = list.get(i);
        if (ri == null) goto L10;
        ActivityInfo ai = ri.activityInfo;
    L11:
        if (ai == null) goto L16;
        if (packageName.equals(ai.packageName) == false) goto L16;
        i = i + 1;
    L16:
        return false;
    L10:
        ai = null;
        goto L11
    L17:
        return true;
    }

    public IntentSender getLaunchIntentSenderForPackage(Computer computer, String packageName, String callingPackage, String featureId, int userId) throws RemoteException {
        packageName.getClass();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        computer.enforceCrossUserPermission(callingUid, userId, false, false, "get launch intent sender for package");
        int packageUid = computer.getPackageUid(callingPackage, 0, userId);
        if (UserHandle.isSameApp(callingUid, packageUid) == false) goto L22;
        Intent intentToResolve = new Intent("android.intent.action.MAIN");
        intentToResolve.addCategory("android.intent.category.INFO");
        intentToResolve.setPackage(packageName);
        ContentResolver contentResolver = this.mContext.getContentResolver();
        String resolvedType = intentToResolve.resolveTypeIfNeeded(contentResolver);
        List<ResolveInfo> ris = computer.queryIntentActivitiesInternal(intentToResolve, resolvedType, 0, 0, callingUid, callingPid, userId, true, false);
        if (ris != null) goto L7;
    L10:
        intentToResolve.removeCategory("android.intent.category.INFO");
        intentToResolve.addCategory("android.intent.category.LAUNCHER");
        intentToResolve.setPackage(packageName);
        String resolvedType2 = intentToResolve.resolveTypeIfNeeded(contentResolver);
        List<ResolveInfo> ris2 = computer.queryIntentActivitiesInternal(intentToResolve, resolvedType2, 0, 0, callingUid, callingPid, userId, true, false);
        String resolvedType3 = resolvedType2;
    L11:
        Intent intent = new Intent(intentToResolve);
        intent.setFlags(268435456);
        String[] r5 = null;
        if (ris2 != null) goto L14;
    L16:
        IActivityManager r1 = ActivityManager.getService();
        Intent[] r8 = {intent};
        if (resolvedType3 == null) goto L19;
        r5 = new String[]{resolvedType3};
    L19:
        IIntentSender target = r1.getIntentSenderWithFeature(2, callingPackage, featureId, null, null, 1, r8, r5, 67108864, null, userId);
        return new IntentSender(target);
    L14:
        if (ris2.isEmpty() == true) goto L16;
        intent.setPackage(null);
        intent.setClassName(ris2.get(0).activityInfo.packageName, ris2.get(0).activityInfo.name);
        goto L16
    L7:
        if (ris.size() <= 0) goto L10;
        ris2 = ris;
        resolvedType3 = resolvedType;
        goto L11
    L22:
        throw new SecurityException("getLaunchIntentSenderForPackage() from calling uid: " + callingUid + " does not own package: " + callingPackage);
    }

    public List<ResolveInfo> queryIntentReceiversInternal(Computer computer, Intent intent, String resolvedType, long flags, int userId, int queryingUid) {
        return queryIntentReceiversInternal(computer, intent, resolvedType, flags, userId, queryingUid, -1, false);
    }

    public List<ResolveInfo> queryIntentReceiversInternal(Computer computer, Intent intent, String resolvedType, long flags, int userId, int filterCallingUid, int callingPid, boolean forSend) {
        if (this.mUserManager.exists(userId) == false) goto L5;
        if (forSend == false) goto L8;
        int queryingUid = 1000;
    L9:
        int queryingUid2 = queryingUid;
        computer.enforceCrossUserPermission(queryingUid2, userId, false, false, "query intent receivers");
        String instantAppPkgName = computer.getInstantAppPackageName(queryingUid2);
        long flags2 = computer.updateFlagsForResolve(flags, userId, queryingUid2, false, computer.isImplicitImageCaptureIntentAndNotSetByDpc(intent, userId, resolvedType, flags));
        Intent originalIntent = null;
        ComponentName comp = intent.getComponent();
        if (comp == null) goto L12;
    L14:
        Intent intent2 = intent;
    L15:
        ComponentResolverApi componentResolver = computer.getComponentResolver();
        List<ResolveInfo> list = Collections.emptyList();
        SaferIntentUtils.IntentArgs args = new SaferIntentUtils.IntentArgs(intent2, resolvedType, true, forSend, filterCallingUid, callingPid);
        args.platformCompat = this.mPlatformCompat;
        args.snapshot = computer;
        if (comp == null) goto L68;
        ActivityInfo ai = computer.getReceiverInfo(comp, flags2, userId);
        if (ai == null) goto L67;
        if ((8388608 & flags2) == 0) goto L22;
        boolean matchInstantApp = true;
    L24:
        if ((flags2 & 16777216) == 0) goto L26;
        boolean matchVisibleToInstantAppOnly = true;
    L28:
        if ((flags2 & 33554432) == 0) goto L30;
        boolean matchExplicitlyVisibleOnly = true;
    L31:
        if (instantAppPkgName == null) goto L33;
        boolean isCallerInstantApp = true;
    L34:
        boolean isTargetSameInstantApp = comp.getPackageName().equals(instantAppPkgName);
        if ((ai.applicationInfo.privateFlags & 128) == 0) goto L37;
        boolean isTargetInstantApp = true;
    L38:
        boolean isTargetInstantApp2 = isTargetInstantApp;
        if ((ai.flags & 1048576) == 0) goto L41;
        boolean isTargetVisibleToInstantApp = true;
    L42:
        if (isTargetVisibleToInstantApp == false) goto L46;
        boolean isTargetVisibleToInstantApp2 = isTargetVisibleToInstantApp;
        if ((ai.flags & 2097152) != 0) goto L47;
        boolean isTargetExplicitlyVisibleToInstantApp = true;
    L48:
        if (isTargetVisibleToInstantApp2 == false) goto L53;
        if (matchExplicitlyVisibleOnly == false) goto L52;
        if (isTargetExplicitlyVisibleToInstantApp == false) goto L53;
    L52:
        boolean isTargetHiddenFromInstantApp = false;
    L54:
        if (isTargetSameInstantApp == true) goto L62;
        if (matchInstantApp == true) goto L58;
        if (isCallerInstantApp == true) goto L58;
        if (isTargetInstantApp2 == false) goto L58;
    L61:
        boolean blockResolution = true;
    L63:
        if (blockResolution == true) goto L67;
        ResolveInfo ri = new ResolveInfo();
        ri.activityInfo = ai;
        List<ResolveInfo> list2 = new ArrayList(1);
        list2.add(ri);
        SaferIntentUtils.enforceIntentFilterMatching(args, list2);
        list = list2;
    L58:
        if (matchVisibleToInstantAppOnly == false) goto L62;
        if (isCallerInstantApp == false) goto L62;
        if (isTargetHiddenFromInstantApp == true) goto L61;
    L62:
        blockResolution = false;
    L53:
        isTargetHiddenFromInstantApp = true;
    L47:
        isTargetExplicitlyVisibleToInstantApp = false;
        goto L48
    L46:
        isTargetVisibleToInstantApp2 = isTargetVisibleToInstantApp;
        goto L47
    L41:
        isTargetVisibleToInstantApp = false;
        goto L42
    L37:
        isTargetInstantApp = false;
        goto L38
    L33:
        isCallerInstantApp = false;
        goto L34
    L30:
        matchExplicitlyVisibleOnly = false;
        goto L31
    L26:
        matchVisibleToInstantAppOnly = false;
        goto L28
    L22:
        matchInstantApp = false;
    L67:
        Intent originalIntent2 = originalIntent;
        Intent intent3 = intent2;
        List<ResolveInfo> list3 = list;
    L82:
        if (originalIntent2 == null) goto L85;
        args.intent = originalIntent2;
        SaferIntentUtils.enforceIntentFilterMatching(args, list3);
    L85:
        return computer.applyPostResolutionFilter(list3, instantAppPkgName, false, queryingUid2, false, userId, intent3);
    L68:
        String pkgName = intent2.getPackage();
        if (pkgName != null) goto L73;
        originalIntent2 = originalIntent;
        intent3 = intent2;
        long flags3 = flags2;
        List<ResolveInfo> result = componentResolver.queryReceivers(computer, intent3, resolvedType, flags3, userId);
        ComponentResolverApi componentResolver2 = componentResolver;
        Computer r1 = computer;
        if (result == null) goto L74;
        list = result;
    L74:
        AndroidPackage pkg = r1.getPackage(pkgName);
        if (pkg == null) goto L80;
        List<ResolveInfo> result2 = componentResolver2.queryReceivers(r1, intent3, resolvedType, flags3, pkg.getReceivers(), userId);
        if (result2 == null) goto L80;
        List<ResolveInfo> list4 = result2;
    L81:
        SaferIntentUtils.blockNullAction(args, list4);
        list3 = list4;
    L80:
        list4 = list;
        goto L81
    L73:
        r1 = computer;
        originalIntent2 = originalIntent;
        componentResolver2 = componentResolver;
        intent3 = intent2;
        flags3 = flags2;
        goto L74
    L12:
        if (intent.getSelector() == null) goto L14;
        originalIntent = intent;
        Intent intent4 = intent.getSelector();
        comp = intent4.getComponent();
        intent2 = intent4;
        goto L15
    L8:
        queryingUid = filterCallingUid;
        goto L9
    L5:
        return Collections.emptyList();
    }

    public ResolveInfo resolveServiceInternal(Computer computer, Intent intent, String resolvedType, long flags, int userId, int callingUid, int callingPid, boolean resolveForStart) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return null;
    L5:
        List<ResolveInfo> query = computer.queryIntentServicesInternal(intent, resolvedType, computer.updateFlagsForResolve(flags, userId, callingUid, false, false), userId, callingUid, callingPid, false, resolveForStart);
        if (query != null) goto L8;
    L11:
        return null;
    L8:
        if (query.size() < 1) goto L11;
        return query.get(0);
    }

    public List<ResolveInfo> queryIntentContentProvidersInternal(Computer computer, Intent intent, String resolvedType, long flags, int userId) {
        if (this.mUserManager.exists(userId) == false) goto L5;
        int callingUid = Binder.getCallingUid();
        String instantAppPkgName = computer.getInstantAppPackageName(callingUid);
        long flags2 = computer.updateFlagsForResolve(flags, userId, callingUid, false, false);
        ComponentName comp = intent.getComponent();
        if (comp == null) goto L9;
    L11:
        Intent intent2 = intent;
        ComponentName comp2 = comp;
    L12:
        if (comp2 == null) goto L56;
        List<ResolveInfo> list = new ArrayList(1);
        ProviderInfo pi = computer.getProviderInfo(comp2, flags2, userId);
        if (pi == null) goto L55;
        if ((8388608 & flags2) == 0) goto L18;
        boolean matchInstantApp = true;
    L20:
        if ((flags2 & 16777216) == 0) goto L22;
        boolean matchVisibleToInstantAppOnly = true;
    L23:
        if (instantAppPkgName == null) goto L25;
        boolean isCallerInstantApp = true;
    L26:
        boolean isTargetSameInstantApp = comp2.getPackageName().equals(instantAppPkgName);
        if ((pi.applicationInfo.privateFlags & 128) == 0) goto L29;
        boolean isTargetInstantApp = true;
    L31:
        if ((pi.flags & 1048576) != 0) goto L33;
        boolean isTargetHiddenFromInstantApp = true;
    L34:
        if (isTargetSameInstantApp == true) goto L42;
        if (matchInstantApp == true) goto L38;
        if (isCallerInstantApp == true) goto L38;
        if (isTargetInstantApp == false) goto L38;
    L41:
        boolean blockResolution = true;
    L43:
        if (isTargetInstantApp == true) goto L48;
        if (isCallerInstantApp == true) goto L48;
        boolean blockResolution2 = blockResolution;
        if (computer.shouldFilterApplication(computer.getPackageStateInternal(pi.applicationInfo.packageName, 1000), callingUid, userId) == false) goto L49;
        boolean blockNormalResolution = true;
    L51:
        if (blockResolution2 == true) goto L55;
        if (blockNormalResolution == true) goto L55;
        ResolveInfo ri = new ResolveInfo();
        ri.providerInfo = pi;
        list.add(ri);
    L49:
        blockNormalResolution = false;
    L48:
        blockResolution2 = blockResolution;
    L38:
        if (matchVisibleToInstantAppOnly == false) goto L42;
        if (isCallerInstantApp == false) goto L42;
        if (isTargetHiddenFromInstantApp == true) goto L41;
    L42:
        blockResolution = false;
        goto L43
    L33:
        isTargetHiddenFromInstantApp = false;
        goto L34
    L29:
        isTargetInstantApp = false;
        goto L31
    L25:
        isCallerInstantApp = false;
        goto L26
    L22:
        matchVisibleToInstantAppOnly = false;
        goto L23
    L18:
        matchInstantApp = false;
    L55:
        return list;
    L56:
        ComponentResolverApi componentResolver = computer.getComponentResolver();
        String pkgName = intent2.getPackage();
        if (pkgName != null) goto L64;
        List<ResolveInfo> resolveInfos = componentResolver.queryProviders(computer, intent2, resolvedType, flags2, userId);
        if (resolveInfos != null) goto L63;
        return Collections.emptyList();
    L63:
        return applyPostContentProviderResolutionFilter(computer, resolveInfos, instantAppPkgName, userId, callingUid);
    L64:
        Intent intent3 = intent2;
        AndroidPackage pkg = computer.getPackage(pkgName);
        if (pkg == null) goto L73;
        List<ResolveInfo> resolveInfos2 = componentResolver.queryProviders(computer, intent3, resolvedType, flags2, pkg.getProviders(), userId);
        if (resolveInfos2 != null) goto L71;
        return Collections.emptyList();
    L71:
        return applyPostContentProviderResolutionFilter(computer, resolveInfos2, instantAppPkgName, userId, callingUid);
    L73:
        return Collections.emptyList();
    L9:
        if (intent.getSelector() == null) goto L11;
        intent2 = intent.getSelector();
        comp2 = intent2.getComponent();
        goto L12
    L5:
        return Collections.emptyList();
    }

    private List<ResolveInfo> applyPostContentProviderResolutionFilter(Computer computer, List<ResolveInfo> resolveInfos, String instantAppPkgName, int userId, int callingUid) {
        int i = resolveInfos.size() - 1;
    L3:
        if (i < 0) goto L34;
        ResolveInfo info = resolveInfos.get(i);
        if (instantAppPkgName != null) goto L9;
        PackageStateInternal resolvedSetting = computer.getPackageStateInternal(info.providerInfo.packageName, 0);
        if (computer.shouldFilterApplication(resolvedSetting, callingUid, userId) == true) goto L9;
    L32:
        i = i - 1;
    L9:
        boolean isEphemeralApp = info.providerInfo.applicationInfo.isInstantApp();
        if (isEphemeralApp == true) goto L12;
    L27:
        if (isEphemeralApp == false) goto L29;
    L31:
        resolveInfos.remove(i);
        goto L32
    L29:
        if ((info.providerInfo.flags & 1048576) == 0) goto L31;
    L12:
        if (instantAppPkgName.equals(info.providerInfo.packageName) == false) goto L27;
        if (info.providerInfo.splitName == null) goto L32;
        if (ArrayUtils.contains(info.providerInfo.applicationInfo.splitNames, info.providerInfo.splitName) == true) goto L32;
        if (this.mInstantAppInstallerActivitySupplier.get() != null) goto L24;
        if (PackageManagerService.DEBUG_INSTANT == false) goto L22;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "No installer - not adding it to the ResolveInfo list");
    L22:
        resolveInfos.remove(i);
        goto L32
    L24:
        if (PackageManagerService.DEBUG_INSTANT == false) goto L26;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "Adding ephemeral installer to the ResolveInfo list");
    L26:
        ResolveInfo installerInfo = new ResolveInfo(computer.getInstantAppInstallerInfo());
        installerInfo.auxiliaryInfo = new AuxiliaryResolveInfo(null, info.providerInfo.packageName, info.providerInfo.applicationInfo.longVersionCode, info.providerInfo.splitName);
        installerInfo.filter = new IntentFilter();
        installerInfo.resolvePackageName = info.getComponentInfo().packageName;
        resolveInfos.set(i, installerInfo);
        goto L32
    L34:
        return resolveInfos;
    }

    public List<ResolveInfo> queryIntentActivityOptionsInternal(Computer computer, ComponentName caller, Intent[] specifics, String[] specificTypes, Intent intent, String resolvedType, long flags, int userId) {
        ResolveIntentHelper r0 = this;
        Intent[] r12 = specifics;
        if (r0.mUserManager.exists(userId) == false) goto L5;
        int callingUid = Binder.getCallingUid();
        long flags2 = computer.updateFlagsForResolve(flags, userId, callingUid, false, computer.isImplicitImageCaptureIntentAndNotSetByDpc(intent, userId, resolvedType, flags));
        computer.enforceCrossUserPermission(callingUid, userId, false, false, "query intent activity options");
        int callingUid2 = callingUid;
        String resultsAction = intent.getAction();
        long r15 = 64;
        List<ResolveInfo> results = computer.queryIntentActivitiesInternal(intent, resolvedType, flags2 | 64, userId);
        int specificsPos = 0;
        String r2 = null;
        if (r12 == null) goto L54;
        int i = 0;
    L10:
        if (i >= r12.length) goto L53;
        String r5 = r2;
        Intent sintent = r12[i];
        if (sintent != null) goto L14;
        int specificsPos2 = specificsPos;
        int i2 = i;
        int callingUid3 = callingUid2;
        long r32 = r15;
        List<ResolveInfo> results2 = results;
        long flags3 = flags2;
    L30:
        List<ResolveInfo> results3 = results2;
        specificsPos = specificsPos2;
    L52:
        int r1 = i2 + 1;
        r12 = specifics;
        r15 = r32;
        i = r1;
        flags2 = flags3;
        results = results3;
        callingUid2 = callingUid3;
        r2 = null;
        r0 = this;
        goto L10
    L14:
        String action = sintent.getAction();
        if (resultsAction != null) goto L17;
    L19:
        ResolveInfo ri = null;
        ComponentName comp = sintent.getComponent();
        if (comp != null) goto L28;
        if (specificTypes == null) goto L23;
        String r10 = specificTypes[i];
    L24:
        int i3 = i;
        String r3 = r10;
        int r11 = Binder.getCallingUid();
        int i4 = Binder.getCallingPid();
        List<ResolveInfo> results4 = results;
        flags3 = flags2;
        callingUid3 = callingUid2;
        String action2 = action;
        r32 = r15;
        i2 = i3;
        specificsPos2 = specificsPos;
        results2 = results4;
        ResolveInfo ri2 = r0.resolveIntentInternal(computer, sintent, r3, flags3, 0, userId, false, r11, i4);
        if (ri2 == null) goto L30;
        r0.mResolveInfoSupplier.get();
        ActivityInfo ai = ri2.activityInfo;
        ComponentName comp2 = new ComponentName(ai.applicationInfo.packageName, ai.name);
        ri = ri2;
    L32:
        int N = results2.size();
        int j = specificsPos2;
    L33:
        if (j >= N) goto L47;
        List<ResolveInfo> results5 = results2;
        ResolveInfo sri = results5.get(j);
        if (sri.activityInfo.name.equals(comp2.getClassName()) == true) goto L37;
    L39:
        if (action2 == null) goto L46;
        if (sri.filter.matchAction(action2) == false) goto L46;
    L42:
        results5.remove(j);
        if (ri != null) goto L45;
        ri = sri;
    L45:
        j = j - 1;
        N = N - 1;
    L46:
        j = j + 1;
        results2 = results5;
        goto L33
    L37:
        if (sri.activityInfo.applicationInfo.packageName.equals(comp2.getPackageName()) == true) goto L42;
    L47:
        results3 = results2;
        if (ri != null) goto L50;
        ResolveInfo ri3 = new ResolveInfo();
        ri3.activityInfo = ai;
    L51:
        int specificsPos3 = specificsPos2;
        results3.add(specificsPos3, ri3);
        ri3.specificIndex = i2;
        specificsPos = specificsPos3 + 1;
        goto L52
    L50:
        ri3 = ri;
        goto L51
    L23:
        r10 = r5;
        goto L24
    L28:
        specificsPos2 = specificsPos;
        i2 = i;
        callingUid3 = callingUid2;
        r32 = r15;
        results2 = results;
        action2 = action;
        flags3 = flags2;
        ai = computer.getActivityInfo(comp, flags3, userId);
        if (ai == null) goto L30;
        comp2 = comp;
        goto L32
    L17:
        if (resultsAction.equals(action) == false) goto L19;
        action = null;
        goto L19
    L53:
        List<ResolveInfo> results6 = results;
        long flags4 = flags2;
        long r33 = r15;
    L55:
        int N2 = results6.size();
        int i5 = specificsPos;
    L57:
        if (i5 >= (N2 - 1)) goto L85;
        ResolveInfo rii = results6.get(i5);
        if (rii.filter == null) goto L83;
        Iterator<String> it = rii.filter.actionsIterator();
        if (it == null) goto L83;
    L65:
        if (it.hasNext() == false) goto L81;
        String action3 = it.next();
        if (resultsAction == null) goto L71;
        if (resultsAction.equals(action3) == true) goto L65;
    L71:
        int j2 = i5 + 1;
    L72:
        if (j2 >= N2) goto L65;
        ResolveInfo rij = results6.get(j2);
        if (rij.filter == null) goto L78;
        if (rij.filter.hasAction(action3) == false) goto L78;
        results6.remove(j2);
        j2 = j2 - 1;
        N2 = N2 - 1;
    L78:
        j2 = j2 + 1;
        goto L72
    L81:
        if ((flags4 & r33) != 0) goto L83;
        rii.filter = null;
    L83:
        i5 = i5 + 1;
        goto L57
    L85:
        if (caller == null) goto L95;
        int N3 = results6.size();
        int i6 = 0;
    L87:
        if (i6 >= N3) goto L95;
        ActivityInfo ainfo = results6.get(i6).activityInfo;
        if (caller.getPackageName().equals(ainfo.applicationInfo.packageName) == false) goto L93;
        if (caller.getClassName().equals(ainfo.name) == false) goto L93;
        results6.remove(i6);
    L93:
        i6 = i6 + 1;
    L95:
        if ((flags4 & r33) != 0) goto L99;
        int N4 = results6.size();
        int i7 = 0;
    L97:
        if (i7 >= N4) goto L99;
        results6.get(i7).filter = null;
        i7 = i7 + 1;
    L99:
        return results6;
    L54:
        results6 = results;
        flags4 = flags2;
        r33 = 64;
        goto L55
    L5:
        return Collections.emptyList();
    }
}
