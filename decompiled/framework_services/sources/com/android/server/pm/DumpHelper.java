package com.android.server.pm;

import android.content.ComponentName;
import android.content.pm.FeatureInfo;
import android.os.Binder;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.incremental.PerUidReadTimeouts;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.am.HostingRecord;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import com.android.server.pm.verify.domain.proxy.DomainVerificationProxy;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.ActivityTaskManagerService;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class DumpHelper {
    private final ArrayMap<String, FeatureInfo> mAvailableFeatures;
    private final ChangedPackagesTracker mChangedPackagesTracker;
    private final DomainVerificationManagerInternal mDomainVerificationManager;
    private final PackageInstallerService mInstallerService;
    private final KnownPackages mKnownPackages;
    private final PerUidReadTimeouts[] mPerUidReadTimeouts;
    private final PermissionManagerServiceInternal mPermissionManager;
    private final ArraySet<String> mProtectedBroadcasts;
    private final String[] mRequiredVerifierPackages;
    private final SnapshotStatistics mSnapshotStatistics;
    private final StorageEventHelper mStorageEventHelper;

    public static /* synthetic */ void $r8$lambda$m4jNxRY74ZLb_Qhn1z5qrJf1Fyw(PrintWriter r0, Integer r1, SparseArray r2) {
        lambda$doDump$0(r0, r1, r2);
    }

    DumpHelper(PermissionManagerServiceInternal permissionManager, StorageEventHelper storageEventHelper, DomainVerificationManagerInternal domainVerificationManager, PackageInstallerService installerService, String[] requiredVerifierPackages, KnownPackages knownPackages, ChangedPackagesTracker changedPackagesTracker, ArrayMap<String, FeatureInfo> availableFeatures, ArraySet<String> protectedBroadcasts, PerUidReadTimeouts[] perUidReadTimeouts, SnapshotStatistics snapshotStatistics) {
        this.mPermissionManager = permissionManager;
        this.mStorageEventHelper = storageEventHelper;
        this.mDomainVerificationManager = domainVerificationManager;
        this.mInstallerService = installerService;
        this.mRequiredVerifierPackages = requiredVerifierPackages;
        this.mKnownPackages = knownPackages;
        this.mChangedPackagesTracker = changedPackagesTracker;
        this.mAvailableFeatures = availableFeatures;
        this.mProtectedBroadcasts = protectedBroadcasts;
        this.mPerUidReadTimeouts = perUidReadTimeouts;
        this.mSnapshotStatistics = snapshotStatistics;
    }

    @NeverCompile
    public void doDump(Computer snapshot, FileDescriptor fd, final PrintWriter pw, String[] args) {
        DumpState dumpState = new DumpState();
        int opti = 0;
    L4:
        if (opti >= args.length) goto L38;
        String opt = args[opti];
        if (opt == null) goto L38;
        if (opt.length() <= 0) goto L38;
        if (opt.charAt(0) != '-') goto L38;
        opti = opti + 1;
        if ("-a".equals(opt) == true) goto L4;
        if ("-h".equals(opt) == true) goto L17;
        if ("--checkin".equals(opt) == true) goto L21;
        if ("--all-components".equals(opt) == true) goto L24;
        if ("-f".equals(opt) == true) goto L27;
        if ("--include-apex".equals(opt) == true) goto L30;
        if ("--proto".equals(opt) == true) goto L33;
        pw.println("Unknown argument: " + opt + "; use -h for help");
        goto L4
    L33:
        dumpProto(snapshot, fd);
        return;
    L30:
        dumpState.setOptionEnabled(8);
        goto L4
    L27:
        dumpState.setOptionEnabled(1);
        goto L4
    L24:
        dumpState.setOptionEnabled(2);
        goto L4
    L21:
        dumpState.setCheckIn(true);
        goto L4
    L17:
        printHelp(pw);
        return;
    L38:
        if (opti >= args.length) goto L257;
        String cmd = args[opti];
        opti = opti + 1;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(cmd) == false) goto L42;
    L255:
        dumpState.setTargetPackageName(cmd);
        dumpState.setOptionEnabled(1);
    L256:
        ArraySet<String> permissionNames = null;
    L258:
        String packageName = dumpState.getTargetPackageName();
        boolean checkin = dumpState.isCheckIn();
        if (packageName != null) goto L261;
    L266:
        if (checkin == false) goto L269;
        pw.println("vers,1");
    L269:
        if (checkin == true) goto L275;
        if (dumpState.isDumping(32768) == false) goto L275;
        if (packageName != null) goto L275;
        snapshot.dump(32768, fd, pw, dumpState);
    L275:
        if (checkin == true) goto L297;
        if (dumpState.isDumping(134217728) == false) goto L297;
        if (packageName != null) goto L297;
        if (dumpState.onTitlePrinted() == false) goto L282;
        pw.println();
    L282:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ", 120);
        ipw.println("Known Packages:");
        ipw.increaseIndent();
        int i = 0;
    L284:
        if (i > 19) goto L293;
        String knownPackage = KnownPackages.knownPackageToString(i);
        ipw.print(knownPackage);
        ipw.println(":");
        String[] pkgNames = this.mKnownPackages.getKnownPackageNames(snapshot, i, 0);
        ipw.increaseIndent();
        if (ArrayUtils.isEmpty(pkgNames) == false) goto L288;
        ipw.println("none");
    L292:
        ipw.decreaseIndent();
        i = i + 1;
        opti = opti;
        goto L284
    L288:
        int r12 = pkgNames.length;
        int opti2 = 0;
    L290:
        if (opti2 >= r12) goto L292;
        int r19 = opti2;
        ipw.println(pkgNames[r19]);
        opti2 = r19 + 1;
        goto L290
    L293:
        ipw.decreaseIndent();
    L297:
        if (dumpState.isDumping(2048) == false) goto L314;
        if (packageName != null) goto L314;
        if (checkin == false) goto L301;
    L306:
        String[] r0 = this.mRequiredVerifierPackages;
        int r15 = r0.length;
        int r13 = 0;
    L307:
        if (r13 >= r15) goto L313;
        String requiredVerifierPackage = r0[r13];
        if (checkin == true) goto L311;
        pw.print("  Required: ");
        pw.print(requiredVerifierPackage);
        pw.print(" (uid=");
        pw.print(snapshot.getPackageUid(requiredVerifierPackage, 268435456, 0));
        pw.println(")");
    L312:
        r13 = r13 + 1;
        r0 = r0;
        permissionNames = permissionNames;
        packageName = packageName;
        goto L307
    L311:
        pw.print("vrfy,");
        pw.print(requiredVerifierPackage);
        pw.print(",");
        pw.println(snapshot.getPackageUid(requiredVerifierPackage, 268435456, 0));
        goto L312
    L313:
        String packageName2 = packageName;
        ArraySet<String> permissionNames2 = permissionNames;
    L316:
        if (dumpState.isDumping(131072) == false) goto L331;
        if (packageName2 != null) goto L331;
        DomainVerificationProxy proxy = this.mDomainVerificationManager.getProxy();
        ComponentName verifierComponent = proxy.getComponentName();
        if (verifierComponent == null) goto L330;
        String verifierPackageName = verifierComponent.getPackageName();
        if (checkin == false) goto L323;
        if (verifierPackageName == null) goto L328;
        pw.print("dv,");
        pw.print(verifierPackageName);
        pw.print(",");
        int r9 = 0;
        pw.println(snapshot.getPackageUid(verifierPackageName, 268435456, 0));
    L333:
        if (dumpState.isDumping(1) == false) goto L337;
        if (packageName2 != null) goto L337;
        snapshot.dump(1, fd, pw, dumpState);
    L337:
        if (dumpState.isDumping(2) == false) goto L355;
        if (packageName2 != null) goto L355;
        if (dumpState.onTitlePrinted() == false) goto L342;
        pw.println();
    L342:
        if (checkin == true) goto L344;
        pw.println("Features:");
    L344:
        Iterator<FeatureInfo> r1 = this.mAvailableFeatures.values().iterator();
    L346:
        if (r1.hasNext() == false) goto L355;
        FeatureInfo feat = r1.next();
        if (checkin == false) goto L349;
        pw.print("feat,");
        pw.print(feat.name);
        pw.print(",");
        pw.println(feat.version);
        goto L346
    L349:
        pw.print("  ");
        pw.print(feat.name);
        if (feat.version <= 0) goto L352;
        pw.print(" version=");
        pw.print(feat.version);
    L352:
        pw.println();
    L355:
        ComponentResolverApi componentResolver = snapshot.getComponentResolver();
        if (checkin == false) goto L358;
        String packageName3 = packageName2;
    L363:
        if (checkin == false) goto L365;
    L368:
        if (checkin == false) goto L370;
    L373:
        if (checkin == false) goto L375;
    L378:
        if (checkin == false) goto L380;
    L383:
        if (checkin == false) goto L385;
    L389:
        if (checkin == false) goto L391;
    L393:
        if (checkin == false) goto L395;
        ArraySet<String> permissionNames3 = permissionNames2;
    L400:
        if (checkin == false) goto L402;
    L405:
        if (checkin == true) goto L410;
        if (dumpState.isDumping(16384) == false) goto L410;
        snapshot.dumpKeySet(pw, packageName3, dumpState);
    L410:
        if (dumpState.isDumping(128) == false) goto L412;
        boolean checkin2 = checkin;
        int r14 = 512;
        snapshot.dumpPackages(pw, packageName3, permissionNames3, dumpState, checkin2);
    L414:
        if (checkin2 == true) goto L419;
        if (dumpState.isDumping(67108864) == false) goto L419;
        snapshot.dump(67108864, fd, pw, dumpState);
    L419:
        if (dumpState.isDumping(256) == false) goto L422;
        snapshot.dumpSharedUsers(pw, packageName3, permissionNames3, dumpState, checkin2);
    L422:
        if (checkin2 == false) goto L424;
    L431:
        if (checkin2 == false) goto L433;
    L437:
        if (checkin2 == false) goto L439;
    L443:
        if (checkin2 == false) goto L445;
    L449:
        if (checkin2 == false) goto L451;
    L454:
        if (checkin2 == true) goto L459;
        if (dumpState.isDumping(2097152) == false) goto L459;
        snapshot.dump(2097152, fd, pw, dumpState);
    L459:
        if (dumpState.isDumping(r14) == false) goto L468;
        if (packageName3 != null) goto L468;
        if (checkin2 == false) goto L463;
        PackageManagerServiceUtils.dumpCriticalInfo(pw, "msg,");
        goto L468
    L463:
        if (dumpState.onTitlePrinted() == false) goto L465;
        pw.println();
    L465:
        snapshot.dump(r14, fd, pw, dumpState);
        pw.println();
        pw.println("Package warning messages:");
        PackageManagerServiceUtils.dumpCriticalInfo(pw, null);
    L468:
        if (checkin2 == false) goto L470;
    L476:
        if (checkin2 == false) goto L478;
    L480:
        if (checkin2 == false) goto L482;
        String packageName4 = packageName3;
    L493:
        if (checkin2 == true) goto L504;
        if (dumpState.isDumping(536870912) == false) goto L504;
        if (packageName4 != null) goto L504;
        if (dumpState.onTitlePrinted() == false) goto L500;
        pw.println();
    L500:
        pw.println("Snapshot statistics:");
        this.mSnapshotStatistics.dump(pw, "   ", SystemClock.currentTimeMicro(), snapshot.getUsed(), dumpState.isBrief());
    L504:
        if (checkin2 == false) goto L506;
        return;
    L506:
        if (dumpState.isDumping(1073741824) == false) goto L561;
        if (packageName4 == null) goto L509;
        return;
    L509:
        if (dumpState.onTitlePrinted() == false) goto L511;
        pw.println();
    L511:
        pw.println("Protected broadcast actions:");
        int i2 = 0;
    L513:
        if (i2 >= this.mProtectedBroadcasts.size()) goto L563;
        pw.print("  ");
        pw.println(this.mProtectedBroadcasts.valueAt(i2));
        i2 = i2 + 1;
        goto L513
    L563:
        return;
    L561:
        return;
    L482:
        if (dumpState.isDumping(268435456) == false) goto L491;
        if (packageName3 != null) goto L491;
        if (dumpState.onTitlePrinted() == false) goto L487;
        pw.println();
    L487:
        pw.println("Per UID read timeouts:");
        pw.println("    Default timeouts flag: " + PackageManagerService.getDefaultTimeouts());
        pw.println("    Known digesters list flag: " + PackageManagerService.getKnownDigestersList());
        pw.println("    Timeouts (" + this.mPerUidReadTimeouts.length + "):");
        PerUidReadTimeouts[] r11 = this.mPerUidReadTimeouts;
        int r16 = r11.length;
    L488:
        if (r9 >= r16) goto L490;
        PerUidReadTimeouts item = r11[r9];
        pw.print("        (");
        StringBuilder r17 = new StringBuilder();
        ComponentResolverApi componentResolver2 = componentResolver;
        r17.append("uid=");
        r17.append(item.uid);
        r17.append(", ");
        pw.print(r17.toString());
        StringBuilder r18 = new StringBuilder();
        r18.append("minTimeUs=");
        r18.append(item.minTimeUs);
        r18.append(", ");
        pw.print(r18.toString());
        pw.print("minPendingTimeUs=" + item.minPendingTimeUs + ", ");
        StringBuilder r2 = new StringBuilder();
        r2.append("maxPendingTimeUs=");
        r2.append(item.maxPendingTimeUs);
        pw.print(r2.toString());
        pw.println(")");
        r9 = r9 + 1;
        componentResolver = componentResolver2;
        permissionNames3 = permissionNames3;
        packageName3 = packageName3;
        goto L488
    L490:
        packageName4 = packageName3;
    L491:
        packageName4 = packageName3;
        goto L493
    L478:
        if (dumpState.isDumping(33554432) == false) goto L480;
        snapshot.dump(33554432, fd, pw, dumpState);
        goto L480
    L470:
        if (dumpState.isDumping(65536) == false) goto L476;
        if (packageName3 != null) goto L476;
        if (dumpState.onTitlePrinted() == false) goto L475;
        pw.println();
    L475:
        this.mInstallerService.dump(new IndentingPrintWriter(pw, "  ", 120));
        goto L476
    L451:
        if (dumpState.isDumping(1048576) == false) goto L454;
        snapshot.dump(1048576, fd, pw, dumpState);
        goto L454
    L445:
        if (dumpState.isDumping(16777216) == false) goto L449;
        if (packageName3 != null) goto L449;
        componentResolver.dumpServicePermissions(pw, dumpState);
        goto L449
    L439:
        if (dumpState.isDumping(8388608) == false) goto L443;
        if (packageName3 != null) goto L443;
        this.mStorageEventHelper.dumpLoadedVolumes(pw, dumpState);
        goto L443
    L433:
        if (dumpState.isDumping(524288) == false) goto L437;
        if (packageName3 != null) goto L437;
        snapshot.dump(524288, fd, pw, dumpState);
        goto L437
    L424:
        if (dumpState.isDumping(4194304) == false) goto L431;
        if (packageName3 != null) goto L431;
        if (dumpState.onTitlePrinted() == false) goto L429;
        pw.println();
    L429:
        pw.println("Package Changes:");
        this.mChangedPackagesTracker.iterateAll(new DumpHelper$$ExternalSyntheticLambda0(pw));
        goto L431
    L412:
        checkin2 = checkin;
        r14 = 512;
        goto L414
    L402:
        if (dumpState.isDumping(1024) == false) goto L405;
        componentResolver.dumpContentProviders(snapshot, pw, dumpState, packageName3);
        goto L405
    L395:
        if (dumpState.isDumping(64) == false) goto L397;
        permissionNames3 = permissionNames2;
        snapshot.dumpPermissions(pw, packageName3, permissionNames3, dumpState);
        goto L400
    L397:
        permissionNames3 = permissionNames2;
        goto L400
    L391:
        if (dumpState.isDumping(262144) == false) goto L393;
        snapshot.dump(262144, fd, pw, dumpState);
        goto L393
    L385:
        if (dumpState.isDumping(8192) == false) goto L389;
        if (packageName3 != null) goto L389;
        snapshot.dump(8192, fd, pw, dumpState);
        goto L389
    L380:
        if (dumpState.isDumping(4096) == false) goto L383;
        snapshot.dump(4096, fd, pw, dumpState);
        goto L383
    L375:
        if (dumpState.isDumping(32) == false) goto L378;
        componentResolver.dumpProviderResolvers(pw, dumpState, packageName3);
        goto L378
    L370:
        if (dumpState.isDumping(8) == false) goto L373;
        componentResolver.dumpServiceResolvers(pw, dumpState, packageName3);
        goto L373
    L365:
        if (dumpState.isDumping(16) == false) goto L368;
        componentResolver.dumpReceiverResolvers(pw, dumpState, packageName3);
        goto L368
    L358:
        if (dumpState.isDumping(4) == false) goto L360;
        packageName3 = packageName2;
        componentResolver.dumpActivityResolvers(pw, dumpState, packageName3);
        goto L363
    L360:
        packageName3 = packageName2;
        goto L363
    L328:
        r9 = 0;
        goto L333
    L323:
        if (dumpState.onTitlePrinted() == false) goto L325;
        pw.println();
    L325:
        pw.println("Domain Verifier:");
        pw.print("  Using: ");
        pw.print(verifierPackageName);
        pw.print(" (uid=");
        pw.print(snapshot.getPackageUid(verifierPackageName, 268435456, 0));
        pw.println(")");
        r9 = 0;
        goto L333
    L330:
        r9 = 0;
        pw.println();
        pw.println("No Domain Verifier available!");
    L331:
        r9 = 0;
        goto L333
    L301:
        if (this.mRequiredVerifierPackages.length <= 0) goto L306;
        if (dumpState.onTitlePrinted() == false) goto L305;
        pw.println();
    L305:
        pw.println("Verifiers:");
    L314:
        packageName2 = packageName;
        permissionNames2 = permissionNames;
        goto L316
    L261:
        if (snapshot.getPackageStateInternal(packageName) != null) goto L266;
        if (snapshot.isApexPackage(packageName) == true) goto L266;
        pw.println("Unable to find package: " + packageName);
        return;
    L42:
        if (cmd.contains(".") == true) goto L255;
        if ("check-permission".equals(cmd) == false) goto L64;
        if (opti < args.length) goto L50;
        pw.println("Error: check-permission missing permission argument");
        return;
    L50:
        String perm = args[opti];
        int opti3 = opti + 1;
        if (opti3 < args.length) goto L54;
        pw.println("Error: check-permission missing package argument");
        return;
    L54:
        String pkg = args[opti3];
        int opti4 = opti3 + 1;
        int opti5 = Binder.getCallingUid();
        int user = UserHandle.getUserId(opti5);
        if (opti4 < args.length) goto L516;
    L61:
        pw.println(this.mPermissionManager.checkPermission(snapshot.resolveInternalPackageName(pkg, -1), perm, "default:0", user));
        return;
    L516:
        user = Integer.parseInt(args[opti4]);     // Catch: NumberFormatException -> L58
    L59:
        pw.println("Error: check-permission user argument is not a number: " + args[opti4]);
        return;
    L64:
        if ("l".equals(cmd) == false) goto L66;
    L254:
        dumpState.setDump(1);
        goto L256
    L66:
        if ("libraries".equals(cmd) == true) goto L254;
        if ("f".equals(cmd) == false) goto L71;
    L253:
        dumpState.setDump(2);
        goto L256
    L71:
        if ("features".equals(cmd) == true) goto L253;
        if (ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD.equals(cmd) == true) goto L221;
        if ("resolvers".equals(cmd) == true) goto L221;
        if ("perm".equals(cmd) == true) goto L218;
        if ("permissions".equals(cmd) == true) goto L218;
        if ("permission".equals(cmd) == false) goto L95;
        if (opti < args.length) goto L89;
        pw.println("Error: permission requires permission name");
        return;
    L89:
        ArraySet<String> permissionNames4 = new ArraySet();
    L91:
        if (opti >= args.length) goto L93;
        permissionNames4.add(args[opti]);
        opti = opti + 1;
        goto L91
    L93:
        dumpState.setDump(448);
        permissionNames = permissionNames4;
        goto L258
    L95:
        if ("pref".equals(cmd) == true) goto L216;
        if ("preferred".equals(cmd) == true) goto L216;
        if ("preferred-xml".equals(cmd) == false) goto L107;
        dumpState.setDump(8192);
        if (opti >= args.length) goto L256;
        if ("--full".equals(args[opti]) == false) goto L256;
        dumpState.setFullPreferred(true);
        opti = opti + 1;
        permissionNames = null;
        goto L258
    L107:
        if ("d".equals(cmd) == true) goto L214;
        if ("domain-preferred-apps".equals(cmd) == true) goto L214;
        if ("p".equals(cmd) == true) goto L212;
        if ("packages".equals(cmd) == true) goto L212;
        if ("q".equals(cmd) == true) goto L210;
        if ("queries".equals(cmd) == true) goto L210;
        if ("s".equals(cmd) == true) goto L204;
        if ("shared-users".equals(cmd) == true) goto L204;
        if ("prov".equals(cmd) == true) goto L202;
        if ("providers".equals(cmd) == true) goto L202;
        if ("m".equals(cmd) == false) goto L134;
    L200:
        dumpState.setDump(512);
        goto L256
    L134:
        if ("messages".equals(cmd) == true) goto L200;
        if ("v".equals(cmd) == false) goto L139;
    L199:
        dumpState.setDump(2048);
        goto L256
    L139:
        if ("verifiers".equals(cmd) == true) goto L199;
        if ("dv".equals(cmd) == false) goto L144;
    L198:
        dumpState.setDump(131072);
        goto L256
    L144:
        if ("domain-verifier".equals(cmd) == true) goto L198;
        if ("version".equals(cmd) == false) goto L150;
        dumpState.setDump(32768);
        goto L256
    L150:
        if ("k".equals(cmd) == false) goto L152;
    L197:
        dumpState.setDump(16384);
        goto L256
    L152:
        if ("keysets".equals(cmd) == true) goto L197;
        if ("installs".equals(cmd) == false) goto L158;
        dumpState.setDump(65536);
        goto L256
    L158:
        if ("frozen".equals(cmd) == false) goto L161;
        dumpState.setDump(524288);
        goto L256
    L161:
        if ("volumes".equals(cmd) == false) goto L164;
        dumpState.setDump(8388608);
        goto L256
    L164:
        if ("dexopt".equals(cmd) == false) goto L167;
        dumpState.setDump(1048576);
        goto L256
    L167:
        if ("compiler-stats".equals(cmd) == false) goto L170;
        dumpState.setDump(2097152);
        goto L256
    L170:
        if ("changes".equals(cmd) == false) goto L173;
        dumpState.setDump(4194304);
        goto L256
    L173:
        if ("service-permissions".equals(cmd) == false) goto L176;
        dumpState.setDump(16777216);
        goto L256
    L176:
        if ("known-packages".equals(cmd) == false) goto L179;
        dumpState.setDump(134217728);
        goto L256
    L179:
        if ("t".equals(cmd) == false) goto L181;
    L196:
        dumpState.setDump(268435456);
        goto L256
    L181:
        if ("timeouts".equals(cmd) == true) goto L196;
        if ("snapshot".equals(cmd) == false) goto L194;
        dumpState.setDump(536870912);
        if (opti >= args.length) goto L256;
        if ("--full".equals(args[opti]) == false) goto L191;
        dumpState.setBrief(false);
        opti = opti + 1;
        permissionNames = null;
        goto L258
    L191:
        if ("--brief".equals(args[opti]) == false) goto L256;
        dumpState.setBrief(true);
        opti = opti + 1;
        permissionNames = null;
        goto L258
    L194:
        if ("protected-broadcasts".equals(cmd) == false) goto L256;
        dumpState.setDump(1073741824);
    L202:
        dumpState.setDump(1024);
    L204:
        dumpState.setDump(256);
        if (opti >= args.length) goto L256;
        if ("noperm".equals(args[opti]) == false) goto L256;
        dumpState.setOptionEnabled(4);
    L210:
        dumpState.setDump(67108864);
    L212:
        dumpState.setDump(128);
    L214:
        dumpState.setDump(262144);
    L216:
        dumpState.setDump(4096);
    L218:
        dumpState.setDump(64);
    L221:
        if (opti < args.length) goto L224;
        dumpState.setDump(60);
    L224:
        if (opti >= args.length) goto L252;
        String name = args[opti];
        if (ActivityTaskManagerService.DUMP_ACTIVITIES_SHORT_CMD.equals(name) == false) goto L228;
    L250:
        dumpState.setDump(4);
    L251:
        opti = opti + 1;
        goto L224
    L228:
        if (HostingRecord.HOSTING_TYPE_ACTIVITY.equals(name) == true) goto L250;
        if ("s".equals(name) == false) goto L233;
    L249:
        dumpState.setDump(8);
        goto L251
    L233:
        if (HostingRecord.HOSTING_TYPE_SERVICE.equals(name) == true) goto L249;
        if (ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD.equals(name) == false) goto L238;
    L248:
        dumpState.setDump(16);
        goto L251
    L238:
        if ("receiver".equals(name) == true) goto L248;
        if ("c".equals(name) == false) goto L243;
    L247:
        dumpState.setDump(32);
        goto L251
    L243:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(name) == true) goto L247;
        pw.println("Error: unknown resolver table type: " + name);
        return;
    L252:
        permissionNames = null;
        goto L258
    L257:
        permissionNames = null;
        goto L258
    }

    private static /* synthetic */ void lambda$doDump$0(PrintWriter pw, Integer sequenceNumber, SparseArray values) {
        pw.print("  Sequence number=");
        pw.println(sequenceNumber);
        int numChangedPackages = values.size();
        int i = 0;
    L3:
        if (i >= numChangedPackages) goto L12;
        SparseArray<String> changes = (SparseArray) values.valueAt(i);
        pw.print("  User ");
        pw.print(values.keyAt(i));
        pw.println(":");
        int numChanges = changes.size();
        if (numChanges != 0) goto L7;
        pw.print("    ");
        pw.println("No packages changed");
    L10:
        i = i + 1;
        goto L3
    L7:
        int j = 0;
    L8:
        if (j >= numChanges) goto L10;
        String pkgName = changes.valueAt(j);
        int userSequenceNumber = changes.keyAt(j);
        pw.print("    ");
        pw.print("seq=");
        pw.print(userSequenceNumber);
        pw.print(", package=");
        pw.println(pkgName);
        j = j + 1;
        goto L8
    }

    private void printHelp(PrintWriter pw) {
        pw.println("Package manager dump options:");
        pw.println("  [-h] [-f] [--checkin] [--all-components] [cmd] ...");
        pw.println("    --checkin: dump for a checkin");
        pw.println("    -f: print details of intent filters");
        pw.println("    -h: print this help");
        pw.println("    --proto: dump data to proto");
        pw.println("    --all-components: include all component names in package dump");
        pw.println("    --include-apex: includes the apex packages in package dump");
        pw.println("  cmd may be one of:");
        pw.println("    apex: list active APEXes and APEX session state");
        pw.println("    l[ibraries]: list known shared libraries");
        pw.println("    f[eatures]: list device features");
        pw.println("    k[eysets]: print known keysets");
        pw.println("    r[esolvers] [activity|service|receiver|content]: dump intent resolvers");
        pw.println("    perm[issions]: dump permissions");
        pw.println("    permission [name ...]: dump declaration and use of given permission");
        pw.println("    pref[erred]: print preferred package settings");
        pw.println("    preferred-xml [--full]: print preferred package settings as xml");
        pw.println("    prov[iders]: dump content providers");
        pw.println("    p[ackages]: dump installed packages");
        pw.println("    q[ueries]: dump app queryability calculations");
        pw.println("    s[hared-users] [noperm]: dump shared user IDs");
        pw.println("    m[essages]: print collected runtime messages");
        pw.println("    v[erifiers]: print package verifier info");
        pw.println("    d[omain-preferred-apps]: print domains preferred apps");
        pw.println("    i[ntent-filter-verifiers]|ifv: print intent filter verifier info");
        pw.println("    t[imeouts]: print read timeouts for known digesters");
        pw.println("    version: print database version info");
        pw.println("    write: write current settings now");
        pw.println("    installs: details about install sessions");
        pw.println("    check-permission <permission> <package> [<user>]: does pkg hold perm?");
        pw.println("    dexopt: dump dexopt state");
        pw.println("    compiler-stats: dump compiler statistics");
        pw.println("    service-permissions: dump permissions required by services");
        pw.println("    snapshot [--full|--brief]: dump snapshot statistics");
        pw.println("    protected-broadcasts: print list of protected broadcast actions");
        pw.println("    known-packages: dump known packages");
        pw.println("    changes: dump the packages that have been changed");
        pw.println("    frozen: dump the frozen packages");
        pw.println("    volumes: dump the loaded volumes");
        pw.println("    <package.name>: info about given package");
    }

    private void dumpProto(Computer snapshot, FileDescriptor fd) {
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        String[] r3 = this.mRequiredVerifierPackages;
        int r4 = r3.length;
        int r6 = 0;
    L4:
        if (r6 >= r4) goto L6;
        String requiredVerifierPackage = r3[r6];
        long requiredVerifierPackageToken = proto.start(1146756268033L);
        proto.write(1138166333441L, requiredVerifierPackage);
        proto.write(1120986464258L, snapshot.getPackageUid(requiredVerifierPackage, 268435456, 0));
        proto.end(requiredVerifierPackageToken);
        r6 = r6 + 1;
        goto L4
    L6:
        DomainVerificationProxy proxy = this.mDomainVerificationManager.getProxy();
        ComponentName verifierComponent = proxy.getComponentName();
        if (verifierComponent == null) goto L9;
        String verifierPackageName = verifierComponent.getPackageName();
        long verifierPackageToken = proto.start(1146756268034L);
        proto.write(1138166333441L, verifierPackageName);
        proto.write(1120986464258L, snapshot.getPackageUid(verifierPackageName, 268435456, 0));
        proto.end(verifierPackageToken);
    L9:
        snapshot.dumpSharedLibrariesProto(proto);
        dumpAvailableFeaturesProto(proto);
        snapshot.dumpPackagesProto(proto);
        snapshot.dumpSharedUsersProto(proto);
        PackageManagerServiceUtils.dumpCriticalInfo(proto);
        proto.flush();
    }

    private void dumpAvailableFeaturesProto(ProtoOutputStream proto) {
        int count = this.mAvailableFeatures.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        this.mAvailableFeatures.valueAt(i).dumpDebug(proto, 2246267895812L);
        i = i + 1;
        goto L3
    }
}
