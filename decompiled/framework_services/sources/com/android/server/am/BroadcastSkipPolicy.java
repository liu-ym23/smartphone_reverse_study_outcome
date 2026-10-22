package com.android.server.am;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.os.UserHandle;
import android.permission.IPermissionManager;
import android.permission.PermissionManager;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemConfig;
import com.android.server.pm.PackageManagerService;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastSkipPolicy {
    private PermissionManager mPermissionManager;
    private ArrayMap<String, Set<String>> mQtiBackgroundLaunchBroadcasts;
    private final ActivityManagerService mService;

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1442$$Nest$fgetmService(BroadcastSkipPolicy r0) {
        return r0.mService;
    }

    public BroadcastSkipPolicy(ActivityManagerService service) {
        service.getClass();
        this.mService = service;
    }

    private ArrayMap<String, Set<String>> getQtiBackgroundLaunchBroadcasts() {
        if (this.mQtiBackgroundLaunchBroadcasts != null) goto L6;
        this.mQtiBackgroundLaunchBroadcasts = SystemConfig.getInstance().getQtiAllowImplicitBroadcasts();
    L6:
        return this.mQtiBackgroundLaunchBroadcasts;
    }

    public String shouldSkipMessage(BroadcastRecord r, Object target) {
        return shouldSkipMessage(r, target, false);
    }

    public String shouldSkipAtEnqueueMessage(BroadcastRecord r, Object target) {
        return shouldSkipMessage(r, target, true);
    }

    private String shouldSkipMessage(BroadcastRecord r, Object target, boolean preflight) {
        if ((target instanceof BroadcastFilter) == false) goto L7;
        return shouldSkipMessage(r, (BroadcastFilter) target, preflight);
    L7:
        return shouldSkipMessage(r, (ResolveInfo) target, preflight);
    }

    private String shouldSkipMessage(BroadcastRecord r, ResolveInfo info, boolean preflight) {
        BroadcastOptions brOptions = r.options;
        ComponentName component = new ComponentName(info.activityInfo.applicationInfo.packageName, info.activityInfo.name);
        if (brOptions != null) goto L5;
    L11:
        if (brOptions == null) goto L17;
        if (brOptions.testRequireCompatChange(info.activityInfo.applicationInfo.uid) == true) goto L17;
        return "Compat change filtered: broadcasting " + broadcastDescription(r, component) + " to uid " + info.activityInfo.applicationInfo.uid + " due to compat change " + r.options.getRequireCompatChangeId();
    L17:
        if (this.mService.validateAssociationAllowedLocked(r.callerPackage, r.callingUid, component.getPackageName(), info.activityInfo.applicationInfo.uid) == true) goto L21;
        return "Association not allowed: broadcasting " + broadcastDescription(r, component);
    L21:
        if (this.mService.mIntentFirewall.checkBroadcast(r.intent, r.callingUid, r.callingPid, r.resolvedType, info.activityInfo.applicationInfo.uid) == false) goto L23;
        int perm = ActivityManagerService.checkComponentPermission(info.activityInfo.permission, r.callingPid, r.callingUid, info.activityInfo.applicationInfo.uid, info.activityInfo.exported);
        String r3 = " requires ";
        if (perm == 0) goto L33;
        if (info.activityInfo.exported == true) goto L31;
        return "Permission Denial: broadcasting " + broadcastDescription(r, component) + " is not exported from uid " + info.activityInfo.applicationInfo.uid;
    L31:
        return "Permission Denial: broadcasting " + broadcastDescription(r, component) + " requires " + info.activityInfo.permission;
    L33:
        if (info.activityInfo.permission == null) goto L43;
        String op = AppOpsManager.permissionToOp(info.activityInfo.permission);
        if (op == null) goto L43;
        if (preflight == false) goto L38;
        int mode = this.mService.getAppOpsManager().checkOpNoThrow(op, r.callingUid, r.callerPackage, r.callerFeatureId);
    L39:
        if (mode == 0) goto L43;
        return "Appop Denial: broadcasting " + broadcastDescription(r, component) + " requires appop " + AppOpsManager.permissionToOp(info.activityInfo.permission);
    L38:
        mode = this.mService.getAppOpsManager().noteOpNoThrow(op, r.callingUid, r.callerPackage, r.callerFeatureId, "Broadcast delivered to " + info.activityInfo.name);
    L43:
        if ((info.activityInfo.flags & 1073741824) == 0) goto L49;
        if (ActivityManager.checkUidPermission("android.permission.INTERACT_ACROSS_USERS", info.activityInfo.applicationInfo.uid) == 0) goto L49;
        return "Permission Denial: Receiver " + component.flattenToShortString() + " requests FLAG_SINGLE_USER, but app does not hold android.permission.INTERACT_ACROSS_USERS";
    L49:
        if (this.mService.isPowerSaveMode == false) goto L57;
        if (this.mService.canRunningOnPowerSaveMode(info.activityInfo.applicationInfo) == true) goto L57;
        if (r.queue.getSmtEx().isSmtClockBr(r) == false) goto L57;
        Slog.w(BroadcastQueue.TAG, "not allow on power save mode,skipped");
        return "Permission Denial: Receiver " + component.flattenToShortString() + " not allow on power save mode";
    L57:
        if (info.activityInfo.applicationInfo.isInstantApp() == false) goto L63;
        if (r.callingUid == info.activityInfo.applicationInfo.uid) goto L63;
        return "Instant App Denial: receiving " + r.intent + " to " + component.flattenToShortString() + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ") Instant Apps do not support manifest receivers";
    L63:
        if (r.callerInstantApp == false) goto L72;
        if ((info.activityInfo.flags & 1048576) != 0) goto L72;
        if (r.callingUid == info.activityInfo.applicationInfo.uid) goto L72;
        return "Instant App Denial: receiving " + r.intent + " to " + component.flattenToShortString() + " requires receiver have visibleToInstantApps set due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L72:
        if (r.curApp == null) goto L197;
        if (r.curApp.mErrorState.isCrashing() == false) goto L197;
        return "Skipping deliver ordered [" + r.queue.toString() + "] " + r + " to " + r.curApp + ": process crashing";
    L197:
        boolean isAvailable = AppGlobals.getPackageManager().isPackageAvailable(info.activityInfo.packageName, UserHandle.getUserId(info.activityInfo.applicationInfo.uid));     // Catch: Exception -> L191
        if (isAvailable == true) goto L86;
        return "Skipping delivery to " + info.activityInfo.packageName + " / " + info.activityInfo.applicationInfo.uid + " : package no longer available";
    L86:
        if (requestStartTargetPermissionsReviewIfNeededLocked(r, info.activityInfo.packageName, UserHandle.getUserId(info.activityInfo.applicationInfo.uid)) == false) goto L88;
        int allowed = this.mService.getAppStartModeLOSP(info.activityInfo.applicationInfo.uid, info.activityInfo.packageName, info.activityInfo.applicationInfo.targetSdkVersion, -1, true, false, false);
        if (allowed != 0) goto L92;
        r3 = " requires ";
        String r19 = null;
    L119:
        if ("android.intent.action.ACTION_SHUTDOWN".equals(r.intent.getAction()) == true) goto L125;
        if (this.mService.mUserController.isUserRunning(UserHandle.getUserId(info.activityInfo.applicationInfo.uid), 0) == true) goto L125;
        return "Skipping delivery to " + info.activityInfo.packageName + " / " + info.activityInfo.applicationInfo.uid + " : user is not running";
    L125:
        if (r.excludedPermissions == null) goto L152;
        if (r.excludedPermissions.length <= 0) goto L152;
        int i = 0;
    L130:
        if (i >= r.excludedPermissions.length) goto L152;
        String excludedPermission = r.excludedPermissions[i];
        int perm2 = AppGlobals.getPackageManager().checkPermission(excludedPermission, info.activityInfo.applicationInfo.packageName, UserHandle.getUserId(info.activityInfo.applicationInfo.uid));     // Catch: RemoteException -> L134
        int perm3 = perm2;
    L136:
        String appOp = AppOpsManager.permissionToOp(excludedPermission);
        if (appOp == null) goto L145;
        if (perm3 != 0) goto L148;
        if (this.mService.getAppOpsManager().checkOpNoThrow(appOp, info.activityInfo.applicationInfo.uid, info.activityInfo.packageName) != 0) goto L148;
        return "Skipping delivery to " + info.activityInfo.packageName + " due to excluded permission " + excludedPermission;
    L148:
        i = i + 1;
        allowed = allowed;
        goto L130
    L145:
        if (perm3 != 0) goto L148;
        return "Skipping delivery to " + info.activityInfo.packageName + " due to excluded permission " + excludedPermission;
    L135:
        perm3 = -1;
    L152:
        if (r.excludedPackages == null) goto L160;
        if (r.excludedPackages.length <= 0) goto L160;
        if (ArrayUtils.contains(r.excludedPackages, component.getPackageName()) == false) goto L160;
        return "Skipping delivery of excluded package " + r.intent + " to " + component.flattenToShortString() + " excludes package " + component.getPackageName() + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L160:
        if (info.activityInfo.applicationInfo.uid == 1000) goto L178;
        if (r.requiredPermissions == null) goto L178;
        if (r.requiredPermissions.length <= 0) goto L178;
        AttributionSource[] attributionSources = createAttributionSourcesForResolveInfo(info);
        int i2 = 0;
    L167:
        if (i2 >= r.requiredPermissions.length) goto L178;
        String requiredPermission = r.requiredPermissions[i2];
        if (hasPermission(requiredPermission, "Broadcast delivered to " + info.activityInfo.name, preflight, attributionSources) == false) goto L171;
        int r10 = 0;
    L172:
        int perm4 = r10;
        if (perm4 != 0) goto L175;
        i2 = i2 + 1;
        goto L167
    L175:
        return "Permission Denial: receiving " + r.intent + " to " + component.flattenToShortString() + r3 + requiredPermission + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L171:
        r10 = -1;
    L178:
        if (r.appOp == (-1)) goto L190;
        if (AppOpsManager.isValidOp(r.appOp) == false) goto L190;
        String op2 = AppOpsManager.opToPublicName(r.appOp);
        if (preflight == false) goto L184;
        String r8 = "Skipping delivery to ";
        boolean appOpAllowed = checkOpForManifestReceiver(r.appOp, op2, r, info, component);
        ResolveInfo r5 = info;
    L186:
        if (appOpAllowed == true) goto L190;
        return r8 + r5.activityInfo.packageName + " due to required appop " + AppOpsManager.opToName(r.appOp);
    L184:
        r8 = "Skipping delivery to ";
        r5 = info;
        appOpAllowed = noteOpForManifestReceiver(r.appOp, op2, r, r5, component);
    L190:
        return r19;
    L92:
        if (getQtiBackgroundLaunchBroadcasts() == null) goto L108;
        r19 = null;
        if (getQtiBackgroundLaunchBroadcasts().containsKey(r.intent.getAction()) == false) goto L107;
        Set<String> nonSkipPackages = getQtiBackgroundLaunchBroadcasts().get(r.intent.getAction());
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L100;
        Slog.i(BroadcastQueue.TAG, "Restricted Intent : " + r.intent.getAction() + " Package Name : " + info.activityInfo.packageName);
    L100:
        if (nonSkipPackages == null) goto L110;
        if (nonSkipPackages.contains(info.activityInfo.packageName) == false) goto L110;
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L106;
        Slog.i(BroadcastQueue.TAG, "QtiBackground execution allowed: receiving " + r.intent + " to " + info.activityInfo.packageName);
    L106:
        return null;
    L110:
        if (allowed != 3) goto L114;
        return "Background execution disabled: receiving " + r.intent + " to " + component.flattenToShortString();
    L114:
        if (disallowBackgroundStart(r) == false) goto L119;
        this.mService.addBackgroundCheckViolationLocked(r.intent.getAction(), component.getPackageName());
        return "Background execution not allowed: receiving " + r.intent + " to " + component.flattenToShortString();
    L107:
        r3 = " requires ";
        goto L110
    L108:
        r3 = " requires ";
        r19 = null;
        goto L110
    L88:
        return "Skipping delivery: permission review required for " + broadcastDescription(r, component);
    L196:
        return "Exception getting recipient info for " + info.activityInfo.packageName;
    L23:
        return "Firewall blocked: broadcasting " + broadcastDescription(r, component);
    L5:
        if (info.activityInfo.applicationInfo.targetSdkVersion < brOptions.getMinManifestReceiverApiLevel()) goto L9;
        if (info.activityInfo.applicationInfo.targetSdkVersion <= brOptions.getMaxManifestReceiverApiLevel()) goto L11;
    L9:
        return "Target SDK mismatch: receiver " + info.activityInfo + " targets " + info.activityInfo.applicationInfo.targetSdkVersion + " but delivery restricted to [" + brOptions.getMinManifestReceiverApiLevel() + ", " + brOptions.getMaxManifestReceiverApiLevel() + "] broadcasting " + broadcastDescription(r, component);
    }

    public boolean disallowBackgroundStart(BroadcastRecord r) {
        if ((r.intent.getFlags() & 8388608) == 0) goto L5;
    L14:
        return true;
    L5:
        if (r.intent.getComponent() == null) goto L7;
    L13:
        return false;
    L7:
        if (r.intent.getPackage() != null) goto L13;
        if ((r.intent.getFlags() & 16777216) != 0) goto L13;
        if (isSignaturePerm(r.requiredPermissions) == true) goto L13;
        goto L13
    }

    private String shouldSkipMessage(BroadcastRecord r, BroadcastFilter filter, boolean preflight) {
        if (r.options == null) goto L9;
        if (r.options.testRequireCompatChange(filter.owningUid) == true) goto L9;
        return "Compat change filtered: broadcasting " + r.intent.toString() + " to uid " + filter.owningUid + " due to compat change " + r.options.getRequireCompatChangeId();
    L9:
        if (this.mService.validateAssociationAllowedLocked(r.callerPackage, r.callingUid, filter.packageName, filter.owningUid) == true) goto L13;
        return "Association not allowed: broadcasting " + r.intent.toString() + " from " + r.callerPackage + " (pid=" + r.callingPid + ", uid=" + r.callingUid + ") to " + filter.packageName + " through " + filter;
    L13:
        if (this.mService.mIntentFirewall.checkBroadcast(r.intent, r.callingUid, r.callingPid, r.resolvedType, filter.receiverList.uid) == false) goto L15;
        String r5 = ") requires appop ";
        if (filter.requiredPermission == null) goto L31;
        if (ActivityManagerService.checkComponentPermission(filter.requiredPermission, r.callingPid, r.callingUid, -1, true) != 0) goto L21;
        String op = AppOpsManager.permissionToOp(filter.requiredPermission);
        if (op == null) goto L31;
        if (preflight == false) goto L26;
        int mode = this.mService.getAppOpsManager().checkOpNoThrow(op, r.callingUid, r.callerPackage, r.callerFeatureId);
    L27:
        if (mode == 0) goto L31;
        return "Appop Denial: broadcasting " + r.intent + " from " + r.callerPackage + " (pid=" + r.callingPid + ", uid=" + r.callingUid + ") requires appop " + op + " due to registered receiver " + filter;
    L26:
        mode = this.mService.getAppOpsManager().noteOpNoThrow(op, r.callingUid, r.callerPackage, r.callerFeatureId, "Broadcast sent to protected receiver");
        goto L27
    L21:
        return "Permission Denial: broadcasting " + r.intent.toString() + " from " + r.callerPackage + " (pid=" + r.callingPid + ", uid=" + r.callingUid + ") requires " + filter.requiredPermission + " due to registered receiver " + filter;
    L31:
        if (filter.receiverList.app == null) goto L144;
        if (filter.receiverList.app.isKilled() == true) goto L144;
        if (filter.receiverList.app.mErrorState.isCrashing() == true) goto L144;
        if ((r.intent.getFlags() & 2097152) == 0) goto L40;
        boolean visibleToInstantApps = true;
    L41:
        String r12 = ") due to sender ";
        if (visibleToInstantApps == false) goto L44;
    L49:
        int r16 = 0;
    L51:
        if (filter.visibleToInstantApp == true) goto L59;
        if (r.callerInstantApp == false) goto L59;
        if (filter.receiverList.uid == r.callingUid) goto L59;
        return "Instant App Denial: receiving " + r.intent.toString() + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + ") requires receiver be visible to instant apps due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L59:
        String r13 = "Broadcast delivered to registered receiver ";
        if (r.requiredPermissions == null) goto L78;
        String r18 = " from ";
        if (r.requiredPermissions.length <= 0) goto L77;
        r5 = ") requires appop ";
        AttributionSource attributionSource = new AttributionSource.Builder(filter.receiverList.uid).setPid(filter.receiverList.pid).setPackageName(filter.packageName).setAttributionTag(filter.featureId).build();
        int perm = 0;
    L64:
        AttributionSource attributionSource2 = attributionSource;
        if (perm >= r.requiredPermissions.length) goto L75;
        String requiredPermission = r.requiredPermissions[perm];
        int i = perm;
        StringBuilder r7 = new StringBuilder();
        r7.append(r13);
        String r23 = r13;
        r7.append(filter.receiverId);
        String r8 = r7.toString();
        String r24 = r12;
        AttributionSource[] r14 = new AttributionSource[1];
        r14[r16] = attributionSource2;
        if (hasPermission(requiredPermission, r8, preflight, r14) == false) goto L69;
        int perm2 = r16;
    L71:
        if (perm2 != 0) goto L73;
        perm = i + 1;
        attributionSource = attributionSource2;
        r13 = r23;
        r12 = r24;
        goto L64
    L73:
        return "Permission Denial: receiving " + r.intent.toString() + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + ") requires " + requiredPermission + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L69:
        perm2 = -1;
        goto L71
    L75:
        String r25 = r12;
        String r26 = r13;
    L80:
        if (r.requiredPermissions == null) goto L84;
        if (r.requiredPermissions.length == 0) goto L84;
    L88:
        if (r.excludedPermissions == null) goto L109;
        if (r.excludedPermissions.length <= 0) goto L109;
        int i2 = 0;
    L93:
        if (i2 >= r.excludedPermissions.length) goto L109;
        String excludedPermission = r.excludedPermissions[i2];
        int i3 = i2;
        int perm3 = ActivityManagerService.checkComponentPermission(excludedPermission, filter.receiverList.pid, filter.receiverList.uid, -1, true);
        String appOp = AppOpsManager.permissionToOp(excludedPermission);
        if (appOp == null) goto L103;
        if (perm3 != 0) goto L106;
        if (this.mService.getAppOpsManager().checkOpNoThrow(appOp, filter.receiverList.uid, filter.packageName) != 0) goto L106;
        return "Appop Denial: receiving " + r.intent + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + ") excludes appop " + appOp + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L106:
        i2 = i3 + 1;
        goto L93
    L103:
        if (perm3 != 0) goto L106;
        return "Permission Denial: receiving " + r.intent + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + ") excludes " + excludedPermission + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L109:
        if (r.excludedPackages == null) goto L117;
        if (r.excludedPackages.length <= 0) goto L117;
        if (ArrayUtils.contains(r.excludedPackages, filter.packageName) == false) goto L117;
        return "Skipping delivery of excluded package " + r.intent.toString() + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + ") excludes package " + filter.packageName + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L117:
        if (r.appOp == (-1)) goto L128;
        if (AppOpsManager.isValidOp(r.appOp) == false) goto L128;
        String op2 = AppOpsManager.opToPublicName(r.appOp);
        if (preflight == false) goto L123;
        int mode2 = this.mService.getAppOpsManager().checkOpNoThrow(op2, filter.receiverList.uid, filter.packageName, filter.featureId);
    L124:
        if (mode2 == 0) goto L128;
        return "Appop Denial: receiving " + r.intent + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + r5 + AppOpsManager.opToName(r.appOp) + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")";
    L123:
        mode2 = this.mService.getAppOpsManager().noteOpNoThrow(op2, filter.receiverList.uid, filter.packageName, filter.featureId, r26 + filter.receiverId);
    L128:
        if (r.sticky == false) goto L130;
        int originalCallingUid = r.originalStickyCallingUid;
    L132:
        if (filter.exported == true) goto L138;
        if (ActivityManagerService.checkComponentPermission(null, r.callingPid, originalCallingUid, filter.receiverList.uid, filter.exported) == 0) goto L138;
        return "Exported Denial: sending " + r.intent.toString() + ", action: " + r.intent.getAction() + r18 + r.callerPackage + " (uid=" + originalCallingUid + ") due to receiver " + filter.receiverList.app + " (uid " + filter.receiverList.uid + ") not specifying RECEIVER_EXPORTED";
    L138:
        if (requestStartTargetPermissionsReviewIfNeededLocked(r, filter.packageName, filter.owningUserId) == false) goto L140;
        return null;
    L140:
        return "Skipping delivery to " + filter.packageName + " due to permissions review";
    L130:
        originalCallingUid = r.callingUid;
    L84:
        if (ActivityManagerService.checkComponentPermission(null, filter.receiverList.pid, filter.receiverList.uid, -1, true) == 0) goto L88;
        return "Permission Denial: security check failed when receiving " + r.intent.toString() + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + r25 + r.callerPackage + " (uid " + r.callingUid + ")";
    L77:
        r25 = ") due to sender ";
        r26 = "Broadcast delivered to registered receiver ";
        goto L80
    L78:
        r18 = " from ";
        goto L77
    L44:
        if (filter.instantApp == false) goto L49;
        r16 = 0;
        if (filter.receiverList.uid == r.callingUid) goto L51;
        return "Instant App Denial: receiving " + r.intent.toString() + " to " + filter.receiverList.app + " (pid=" + filter.receiverList.pid + ", uid=" + filter.receiverList.uid + ") due to sender " + r.callerPackage + " (uid " + r.callingUid + ") not specifying FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS";
    L40:
        visibleToInstantApps = false;
    L144:
        return "Skipping deliver [" + r.queue.toString() + "] " + r + " to " + filter.receiverList + ": process gone or crashing";
    L15:
        return "Firewall blocked: broadcasting " + r.intent.toString() + " from " + r.callerPackage + " (pid=" + r.callingPid + ", uid=" + r.callingUid + ") to " + filter.packageName + " through " + filter;
    }

    private static String broadcastDescription(BroadcastRecord r, ComponentName component) {
        return r.intent.toString() + " from " + r.callerPackage + " (pid=" + r.callingPid + ", uid=" + r.callingUid + ") to " + component.flattenToShortString();
    }

    private boolean noteOpForManifestReceiver(int opCode, String appOp, BroadcastRecord r, ResolveInfo info, ComponentName component) {
        if (ArrayUtils.isEmpty(info.activityInfo.attributionTags) == true) goto L5;
        String[] r9 = info.activityInfo.attributionTags;
        int r10 = r9.length;
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L12;
        String tag = r9[r12];
        if (noteOpForManifestReceiverInner(opCode, appOp, r, info, component, tag) == false) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    L5:
        return noteOpForManifestReceiverInner(opCode, appOp, r, info, component, null);
    }

    private boolean noteOpForManifestReceiverInner(int opCode, String appOp, BroadcastRecord r, ResolveInfo info, ComponentName component, String tag) {
        if (this.mService.getAppOpsManager().noteOpNoThrow(appOp, info.activityInfo.applicationInfo.uid, info.activityInfo.packageName, tag, "Broadcast delivered to " + info.activityInfo.name) == 0) goto L6;
        Slog.w(BroadcastQueue.TAG, "Appop Denial: receiving " + r.intent + " to " + component.flattenToShortString() + " requires appop " + AppOpsManager.opToName(opCode) + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")");
        return false;
    L6:
        return true;
    }

    private boolean checkOpForManifestReceiver(int opCode, String appOp, BroadcastRecord r, ResolveInfo info, ComponentName component) {
        if (ArrayUtils.isEmpty(info.activityInfo.attributionTags) == true) goto L5;
        String[] r9 = info.activityInfo.attributionTags;
        int r10 = r9.length;
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L12;
        String tag = r9[r12];
        if (checkOpForManifestReceiverInner(opCode, appOp, r, info, component, tag) == false) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    L5:
        return checkOpForManifestReceiverInner(opCode, appOp, r, info, component, null);
    }

    private boolean checkOpForManifestReceiverInner(int opCode, String appOp, BroadcastRecord r, ResolveInfo info, ComponentName component, String tag) {
        if (this.mService.getAppOpsManager().checkOpNoThrow(appOp, info.activityInfo.applicationInfo.uid, info.activityInfo.packageName, tag) == 0) goto L6;
        Slog.w(BroadcastQueue.TAG, "Appop Denial: receiving " + r.intent + " to " + component.flattenToShortString() + " requires appop " + AppOpsManager.opToName(opCode) + " due to sender " + r.callerPackage + " (uid " + r.callingUid + ")");
        return false;
    L6:
        return true;
    }

    private static boolean isSignaturePerm(String[] perms) {
        if (perms != null) goto L5;
        return false;
    L5:
        IPermissionManager pm = AppGlobals.getPermissionManager();
        int i = perms.length - 1;
    L6:
        if (i < 0) goto L18;
        PermissionInfo pi = pm.getPermissionInfo(perms[i], PackageManagerService.PLATFORM_PACKAGE_NAME, 0);     // Catch: RemoteException -> L15
        if (pi == null) goto L9;
        if ((pi.protectionLevel & 31) != 2) goto L13;
        i = i - 1;
        goto L6
    L13:
        return false;
    L9:
        return false;
    L16:
        return false;
    L18:
        return true;
    }

    private boolean requestStartTargetPermissionsReviewIfNeededLocked(BroadcastRecord receiverRecord, String receivingPackageName, final int receivingUserId) {
        if (this.mService.getPackageManagerInternal().isPermissionsReviewRequired(receivingPackageName, receivingUserId) == true) goto L6;
        return true;
    L6:
        if (receiverRecord.callerApp != null) goto L8;
        boolean callerForeground = true;
    L13:
        if (callerForeground == true) goto L15;
    L20:
        Slog.w(BroadcastQueue.TAG, "u" + receivingUserId + " Receiving a broadcast in package" + receivingPackageName + " requires a permissions review");
    L21:
        return false;
    L15:
        if (receiverRecord.intent.getComponent() == null) goto L20;
        PendingIntentRecord r5 = this.mService.mPendingIntentController.getIntentSender(1, receiverRecord.callerPackage, receiverRecord.callerFeatureId, receiverRecord.callingUid, receiverRecord.userId, null, null, 0, new Intent[]{receiverRecord.intent}, new String[]{receiverRecord.intent.resolveType(this.mService.mContext.getContentResolver())}, 1409286144, null);
        final Intent intent = new Intent("android.intent.action.REVIEW_PERMISSIONS");
        intent.addFlags(411041792);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", receivingPackageName);
        intent.putExtra("android.intent.extra.INTENT", new IntentSender(r5));
        if (ActivityManagerDebugConfig.DEBUG_PERMISSIONS_REVIEW == false) goto L19;
        Slog.i(BroadcastQueue.TAG, "u" + receivingUserId + " Launching permission review for package " + receivingPackageName);
    L19:
        this.mService.mHandler.post(new AnonymousClass1(this, intent, receivingUserId));
        goto L21
    L8:
        if (receiverRecord.callerApp.mState.getSetSchedGroup() == 0) goto L10;
        callerForeground = true;
        goto L13
    L10:
        callerForeground = false;
        goto L13
    }

    private PermissionManager getPermissionManager() {
        if (this.mPermissionManager != null) goto L6;
        this.mPermissionManager = (PermissionManager) this.mService.mContext.getSystemService(PermissionManager.class);
    L6:
        return this.mPermissionManager;
    }

    private boolean hasPermission(String permission, String message, boolean preflight, AttributionSource... attributionSources) {
        PermissionManager permissionManager = getPermissionManager();
        if (permissionManager != null) goto L5;
        return false;
    L5:
        int r2 = attributionSources.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        AttributionSource attributionSource = attributionSources[r3];
        if (preflight == false) goto L10;
        int permissionCheckResult = permissionManager.checkPermissionForPreflight(permission, attributionSource);
    L11:
        if (permissionCheckResult != 0) goto L12;
        r3 = r3 + 1;
        goto L6
    L12:
        return false;
    L10:
        permissionCheckResult = permissionManager.checkPermissionForDataDelivery(permission, attributionSource, message);
        goto L11
    L14:
        return true;
    }

    private AttributionSource[] createAttributionSourcesForResolveInfo(ResolveInfo info) {
        String[] attributionTags = info.activityInfo.attributionTags;
        if (ArrayUtils.isEmpty(attributionTags) == true) goto L5;
        AttributionSource[] attributionSources = new AttributionSource[attributionTags.length];
        int i = 0;
    L8:
        if (i >= attributionTags.length) goto L11;
        attributionSources[i] = new AttributionSource.Builder(info.activityInfo.applicationInfo.uid).setPackageName(info.activityInfo.packageName).setAttributionTag(attributionTags[i]).build();
        i = i + 1;
        goto L8
    L11:
        return attributionSources;
    L5:
        return new AttributionSource[]{new AttributionSource.Builder(info.activityInfo.applicationInfo.uid).setPackageName(info.activityInfo.packageName).build()};
    }
}
