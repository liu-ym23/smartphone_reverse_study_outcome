package com.android.server.pm;

import android.accounts.IAccountManager;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.role.RoleManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.FeatureInfo;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageInstaller;
import android.content.pm.IPackageManager;
import android.content.pm.InstrumentationInfo;
import android.content.pm.ModuleInfo;
import android.content.pm.ObricPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.SuspendDialogInfo;
import android.content.pm.UserInfo;
import android.content.pm.VersionedPackage;
import android.content.pm.dex.DexMetadataHelper;
import android.content.pm.dex.ISnapshotRuntimeProfileCallback;
import android.content.pm.parsing.ApkLite;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.PackageLite;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.rollback.PackageRollbackInfo;
import android.content.rollback.RollbackInfo;
import android.content.rollback.RollbackManager;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IUserManager;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.incremental.V4Signature;
import android.os.storage.StorageManager;
import android.permission.PermissionManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Pair;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.UiModeManagerService;
import com.android.server.am.ProcessList;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.art.ArtManagerLocal;
import com.android.server.art.model.DexoptParams;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import com.android.server.pm.permission.PermissionAllowlist;
import com.android.server.pm.verify.domain.DomainVerificationShell;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.voiceinteraction.DatabaseHelper;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;
import libcore.io.Streams;
import libcore.util.HexEncoding;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: loaded from: classes2.dex */
class PackageManagerShellCommand extends ShellCommand {
    private static final String ART_PROFILE_SNAPSHOT_DEBUG_LOCATION = "/data/misc/profman/";
    private static final Set<String> ART_SERVICE_COMMANDS = null;
    private static final int DEFAULT_STAGED_READY_TIMEOUT_MS = 60000;
    private static final SecureRandom RANDOM = null;
    private static final String STDIN_PATH = "-";
    private static final Map<String, Integer> SUPPORTED_PERMISSION_FLAGS = null;
    private static final List<String> SUPPORTED_PERMISSION_FLAGS_LIST = null;
    private static final String TAG = "PackageManagerShellCommand";
    private static final Set<String> UNSUPPORTED_INSTALL_CMD_OPTS = null;
    private static final Set<String> UNSUPPORTED_SESSION_CREATE_OPTS = null;
    boolean mBrief;
    boolean mComponents;
    final Context mContext;
    final DomainVerificationShell mDomainVerificationShell;
    final IPackageManager mInterface;
    final LegacyPermissionManagerInternal mLegacyPermissionManager;
    final PermissionManager mPermissionManager;
    private final PackageManagerInternal mPm;
    int mQueryFlags;
    private final WeakHashMap<String, Resources> mResourceCache;
    int mTargetUser;

    static class ClearDataObserver extends IPackageDataObserver.Stub {
        boolean finished;
        boolean result;

        ClearDataObserver() {
        }

        public void onRemoveCompleted(String packageName, boolean succeeded) throws RemoteException {
            monitor-enter(this);
            this.finished = true;     // Catch: Throwable -> L7
            this.result = succeeded;     // Catch: Throwable -> L7
            notifyAll();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class InstallParams {
        String installerPackageName;
        PackageInstaller.SessionParams sessionParams;
        long stagedReadyTimeoutMs;
        int userId;

        /* synthetic */ InstallParams(PackageManagerShellCommandIA r1) {
            this();
        }

        private InstallParams() {
            this.userId = -1;
            this.stagedReadyTimeoutMs = 60000;
        }
    }

    private static class LocalIntentReceiver {
        private final IIntentSender.Stub mLocalSender;
        private final LinkedBlockingQueue<Intent> mResult;

        /* JADX INFO: renamed from: -$$Nest$fgetmResult, reason: not valid java name */
        static /* bridge */ /* synthetic */ LinkedBlockingQueue m6873$$Nest$fgetmResult(LocalIntentReceiver r0) {
            return r0.mResult;
        }

        /* synthetic */ LocalIntentReceiver(PackageManagerShellCommandIA r1) {
            this();
        }

        private LocalIntentReceiver() {
            this.mResult = new LinkedBlockingQueue();
            this.mLocalSender = new AnonymousClass1(this);
        }

        public IntentSender getIntentSender() {
            return new IntentSender(this.mLocalSender);
        }

        public Intent getResult() {
            return this.mResult.take();
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    private static class SessionDump {
        boolean onlyParent;
        boolean onlyReady;
        boolean onlySessionId;

        /* synthetic */ SessionDump(PackageManagerShellCommandIA r1) {
            this();
        }

        private SessionDump() {
        }
    }

    private static class SnapshotRuntimeProfileCallback extends ISnapshotRuntimeProfileCallback.Stub {
        private final CountDownLatch mDoneSignal;
        private int mErrCode;
        private ParcelFileDescriptor mProfileReadFd;
        private boolean mSuccess;

        private SnapshotRuntimeProfileCallback() {
            this.mSuccess = false;
            this.mErrCode = -1;
            this.mProfileReadFd = null;
            this.mDoneSignal = new CountDownLatch(1);
        }

        public void onSuccess(ParcelFileDescriptor profileReadFd) {
            this.mSuccess = true;
            this.mProfileReadFd = profileReadFd.dup();     // Catch: IOException -> L5
        L7:
            this.mDoneSignal.countDown();
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public void onError(int errCode) {
            this.mSuccess = false;
            this.mErrCode = errCode;
            this.mDoneSignal.countDown();
        }

        boolean waitTillDone() {
            boolean done = false;
            done = this.mDoneSignal.await(10000000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
        L6:
            if (done == true) goto L8;
        L10:
            return false;
        L8:
            if (this.mSuccess == false) goto L10;
            return true;
        }
    }

    public static /* synthetic */ int $r8$lambda$6GmvwdX_KHenVoE_uMte4iSWXkM(String r0, String r1) {
        return lambda$runListLibraries$0(r0, r1);
    }

    public static /* synthetic */ List $r8$lambda$SBUnEmlcik68djMk5muLDWebS_E(String r0) {
        return lambda$runListPackages$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$eJkjGwOTAYnwKNp38QVB6HeNmD0(PackageManagerShellCommand r0, String r1, Boolean r2) {
        r0.lambda$runGetOemPermissions$2(r1, r2);
    }

    static {
        UNSUPPORTED_INSTALL_CMD_OPTS = Set.of("--multi-package");
        UNSUPPORTED_SESSION_CREATE_OPTS = Collections.emptySet();
        SUPPORTED_PERMISSION_FLAGS = new ArrayMap();
        SUPPORTED_PERMISSION_FLAGS_LIST = List.of("review-required", "revoked-compat", "revoke-when-requested", "user-fixed", "user-set");
        SUPPORTED_PERMISSION_FLAGS.put("user-set", 1);
        SUPPORTED_PERMISSION_FLAGS.put("user-fixed", 2);
        SUPPORTED_PERMISSION_FLAGS.put("revoked-compat", 8);
        SUPPORTED_PERMISSION_FLAGS.put("review-required", 64);
        SUPPORTED_PERMISSION_FLAGS.put("revoke-when-requested", 128);
        ART_SERVICE_COMMANDS = Set.of("compile", "reconcile-secondary-dex-files", "force-dex-opt", "bg-dexopt-job", "cancel-bg-dexopt-job", "delete-dexopt", "dump-profiles", "snapshot-profile", "art");
        RANDOM = new SecureRandom();
    }

    PackageManagerShellCommand(IPackageManager packageManager, Context context, DomainVerificationShell domainVerificationShell) {
        this.mResourceCache = new WeakHashMap();
        this.mInterface = packageManager;
        this.mPm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mLegacyPermissionManager = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        this.mPermissionManager = (PermissionManager) context.getSystemService(PermissionManager.class);
        this.mContext = context;
        this.mDomainVerificationShell = domainVerificationShell;
    }

    public int onCommand(String r9) {
        if (r9 == null) goto L4;
        PrintWriter r0 = getOutPrintWriter();
    L12:
        e = move-exception;
        r0.println("Remote exception: " + e);
        return -1;
    L7:
        switch(r9.hashCode()) {
            case -2102802879: goto L282;
            case -1987936121: goto L279;
            case -1967190973: goto L276;
            case -1938648150: goto L273;
            case -1937348290: goto L270;
            case -1867202415: goto L267;
            case -1852006340: goto L264;
            case -1846646502: goto L261;
            case -1838891168: goto L258;
            case -1741208611: goto L255;
            case -1534455582: goto L252;
            case -1445787154: goto L249;
            case -1347307837: goto L246;
            case -1298848381: goto L243;
            case -1267782244: goto L240;
            case -1231004208: goto L237;
            case -1102348235: goto L234;
            case -1091400553: goto L231;
            case -1070704814: goto L228;
            case -1063121379: goto L225;
            case -1032029296: goto L222;
            case -999678881: goto L219;
            case -944325712: goto L216;
            case -934343034: goto L213;
            case -905841467: goto L210;
            case -840566949: goto L207;
            case -840228325: goto L204;
            case -770794335: goto L201;
            case -761393825: goto L198;
            case -755307873: goto L195;
            case -748101438: goto L192;
            case -740352344: goto L189;
            case -703497631: goto L186;
            case -625596190: goto L183;
            case -539710980: goto L180;
            case -458695741: goto L177;
            case -440994401: goto L174;
            case -416698598: goto L171;
            case -339687564: goto L168;
            case -220055275: goto L165;
            case -174281478: goto L162;
            case -140205181: goto L159;
            case -132384343: goto L156;
            case -129863314: goto L153;
            case -115000827: goto L150;
            case -87258188: goto L147;
            case -34095911: goto L144;
            case -18738613: goto L141;
            case 3292: goto L138;
            case 3095028: goto L135;
            case 3198785: goto L132;
            case 3202370: goto L129;
            case 3322014: goto L126;
            case 3433509: goto L123;
            case 18936394: goto L120;
            case 26877293: goto L117;
            case 86600360: goto L114;
            case 88069748: goto L111;
            case 93657776: goto L108;
            case 94746189: goto L105;
            case 98615580: goto L102;
            case 107262333: goto L99;
            case 139892533: goto L96;
            case 237392952: goto L93;
            case 287820022: goto L90;
            case 359572742: goto L87;
            case 377019320: goto L84;
            case 401207972: goto L81;
            case 513651668: goto L78;
            case 690561440: goto L75;
            case 798023112: goto L72;
            case 826473335: goto L69;
            case 925176533: goto L66;
            case 1053409810: goto L63;
            case 1177857340: goto L60;
            case 1396442249: goto L57;
            case 1429366290: goto L54;
            case 1536099937: goto L51;
            case 1538306349: goto L48;
            case 1585252978: goto L45;
            case 1595958325: goto L42;
            case 1661039911: goto L39;
            case 1671308008: goto L36;
            case 1697997009: goto L33;
            case 1738820372: goto L30;
            case 1746695602: goto L27;
            case 1757370437: goto L24;
            case 1824799035: goto L21;
            case 1858863089: goto L18;
            case 1957569947: goto L15;
            case 2007457359: goto L10;
            default: goto L284;
        };     // Catch: RemoteException -> L12
    L284:
        byte r2 = -1;
    L285:
        switch(r2) {
            case 0: goto L491;
            case 1: goto L488;
            case 2: goto L487;
            case 3: goto L485;
            case 4: goto L483;
            case 5: goto L481;
            case 6: goto L479;
            case 7: goto L477;
            case 8: goto L475;
            case 9: goto L473;
            case 10: goto L471;
            case 11: goto L469;
            case 12: goto L467;
            case 13: goto L465;
            case 14: goto L463;
            case 15: goto L461;
            case 16: goto L459;
            case 17: goto L459;
            case 18: goto L457;
            case 19: goto L455;
            case 20: goto L453;
            case 21: goto L451;
            case 22: goto L449;
            case 23: goto L447;
            case 24: goto L445;
            case 25: goto L443;
            case 26: goto L441;
            case 27: goto L439;
            case 28: goto L437;
            case 29: goto L435;
            case 30: goto L433;
            case 31: goto L431;
            case 32: goto L429;
            case 33: goto L427;
            case 34: goto L425;
            case 35: goto L423;
            case 36: goto L421;
            case 37: goto L419;
            case 38: goto L417;
            case 39: goto L415;
            case 40: goto L413;
            case 41: goto L411;
            case 42: goto L409;
            case 43: goto L407;
            case 44: goto L405;
            case 45: goto L403;
            case 46: goto L401;
            case 47: goto L399;
            case 48: goto L397;
            case 49: goto L395;
            case 50: goto L393;
            case 51: goto L391;
            case 52: goto L389;
            case 53: goto L387;
            case 54: goto L385;
            case 55: goto L383;
            case 56: goto L381;
            case 57: goto L379;
            case 58: goto L377;
            case 59: goto L375;
            case 60: goto L373;
            case 61: goto L371;
            case 62: goto L369;
            case 63: goto L367;
            case 64: goto L365;
            case 65: goto L363;
            case 66: goto L361;
            case 67: goto L359;
            case 68: goto L357;
            case 69: goto L355;
            case 70: goto L353;
            case 71: goto L351;
            case 72: goto L349;
            case 73: goto L347;
            case 74: goto L345;
            case 75: goto L343;
            case 76: goto L341;
            case 77: goto L339;
            case 78: goto L337;
            case 79: goto L335;
            case 80: goto L333;
            case 81: goto L331;
            case 82: goto L329;
            case 83: goto L327;
            case 84: goto L325;
            case 85: goto L323;
            case 86: goto L321;
            case 87: goto L319;
            case 88: goto L317;
            case 89: goto L315;
            case 90: goto L313;
            default: goto L287;
        };     // Catch: RemoteException -> L12
    L488:
        onHelp();     // Catch: RemoteException -> L12
        return 0;
    L287:
        if (ART_SERVICE_COMMANDS.contains(r9) == true) goto L289;
        Boolean r3 = this.mDomainVerificationShell.runCommand(this, r9);     // Catch: RemoteException -> L12
        if (r3 != null) goto L293;
        String r4 = getNextArg();     // Catch: RemoteException -> L12
        if (r4 != null) goto L305;
        if (r9.equalsIgnoreCase("-l") == false) goto L301;
        return runListPackages(false);
    L301:
        if (r9.equalsIgnoreCase("-lf") == false) goto L311;
        return runListPackages(true);
    L311:
        return handleDefaultCommands(r9);
    L305:
        if (getNextArg() != null) goto L311;
        if (r9.equalsIgnoreCase("-p") == false) goto L311;
        return displayPackageFilePath(r4, 0);
    L293:
        return !r3.booleanValue() ? 1 : 0;
    L289:
        return runArtServiceCommand();
    L313:
        return runGetDomainVerificationAgent();
    L315:
        return runUnarchive();
    L317:
        return runArchive();
    L319:
        return runWaitForHandler(true);
    L321:
        return runWaitForHandler(false);
    L323:
        return runClearPackagePreferredActivities();
    L325:
        return runGetAppMetadata();
    L327:
        return runSetSilentUpdatesPolicy();
    L329:
        return runDisableVerificationForUid();
    L331:
        return runBypassAllowedApexUpdateCheck();
    L333:
        return runBypassStagedInstallerCheck();
    L335:
        return runLogVisibility();
    L337:
        return runGetModuleInfo();
    L339:
        return runRollbackApp();
    L341:
        return uninstallSystemUpdates(getNextArg());
    L343:
        return runListStagedSessions();
    L345:
        return runGetHarmfulAppWarning();
    L347:
        return runSetHarmfulAppWarning();
    L349:
        return runHasFeature();
    L351:
        return runGetInstantAppResolver();
    L353:
        return runSetInstaller();
    L355:
        return runSetHomeActivity();
    L357:
        return runGetMaxRunningUsers();
    L359:
        return runGetMaxUsers();
    L361:
        return runSupportsMultipleUsers();
    L363:
        return runGetUserRestriction();
    L365:
        return runSetUserRestriction();
    L367:
        return runRenameUser();
    L369:
        return runMarkGuestForDeletion();
    L371:
        return runRemoveUser();
    L373:
        return runCreateUser();
    L375:
        return runTrimCaches();
    L377:
        return runGetSharedUidAllowlist();
    L379:
        return runGetSignaturePermissionAllowlist();
    L381:
        return runGetOemPermissions();
    L383:
        return runGetPrivappDenyPermissions();
    L385:
        return runGetPrivappPermissions();
    L387:
        return runSetPermissionEnforced();
    L389:
        return setOrClearPermissionFlags(false);
    L391:
        return setOrClearPermissionFlags(true);
    L393:
        return runResetPermissions();
    L395:
        return runGrantRevokePermission(false);
    L397:
        return runGrantRevokePermission(true);
    L399:
        return runGetDistractingRestriction();
    L401:
        return runSetDistractingRestriction();
    L403:
        return runSuspend(false, 0);
    L405:
        return runSuspend(true, 1);
    L407:
        return runSuspend(true, 0);
    L409:
        return runSetStoppedState(false);
    L411:
        return runSetHiddenSetting(false);
    L413:
        return runSetHiddenSetting(true);
    L415:
        return runSetEnabledSetting(0);
    L417:
        return runSetEnabledSetting(4);
    L419:
        return runSetEnabledSetting(3);
    L421:
        return runSetEnabledSetting(2);
    L423:
        return runSetEnabledSetting(1);
    L425:
        return runArchivedInstall();
    L427:
        return runGetPackageStorageStats();
    L429:
        return runGetArchivedPackageMetadata();
    L431:
        return runClear();
    L433:
        return runUninstall();
    L435:
        return runMovePrimaryStorage();
    L437:
        return runMovePackage();
    L439:
        return runInstallGetPreVerifiedDomains();
    L441:
        return runInstallSetPreVerifiedDomains();
    L443:
        return runInstallAddSession();
    L445:
        return runGetInstallLocation();
    L447:
        return runSetInstallLocation();
    L449:
        return runInstallExisting();
    L451:
        return runInstallWrite();
    L453:
        return runInstallRemove();
    L455:
        return runInstallCreate();
    L457:
        return runInstallCommit();
    L459:
        return runInstallAbandon();
    L461:
        return runIncrementalInstall();
    L463:
        return runStreamingInstall();
    L465:
        return runInstall();
    L467:
        return runQueryIntentReceivers();
    L469:
        return runQueryIntentServices();
    L471:
        return runQueryIntentActivities();
    L473:
        return runResolveActivity();
    L475:
        return runGc();
    L477:
        return runList();
    L479:
        return runCompileMonitorDumpStore();
    L481:
        return runCompileMonitorStatus();
    L483:
        return runDumpPackage();
    L485:
        return runDump();
    L487:
        return runPath();
    L491:
        return runDo6939Service();
    L10:
        if (r9.equals("get-package-storage-stats") == false) goto L284;
        r2 = 33;
        goto L285
    L15:
        if (r9.equals("install") == false) goto L284;
        r2 = 13;
        goto L285
    L18:
        if (r9.equals("get-moduleinfo") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_FLESH;
        goto L285
    L21:
        if (r9.equals("log-visibility") == false) goto L284;
        r2 = ParameterName.BALANCE;
        goto L285
    L24:
        if (r9.equals("bypass-allowed-apex-update-check") == false) goto L284;
        r2 = ParameterName.TREBLE;
        goto L285
    L27:
        if (r9.equals("set-install-location") == false) goto L284;
        r2 = ParameterName.COLOR_TEMPERATURE;
        goto L285
    L30:
        if (r9.equals("set-permission-flags") == false) goto L284;
        r2 = 51;
        goto L285
    L33:
        if (r9.equals("disable-until-used") == false) goto L284;
        r2 = ParameterName.COLOR_TEMPERATURE_GREEN_GAIN;
        goto L285
    L36:
        if (r9.equals("disable") == false) goto L284;
        r2 = 36;
        goto L285
    L39:
        if (r9.equals("mark-guest-for-deletion") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_MAGENTA;
        goto L285
    L42:
        if (r9.equals("get-signature-permission-allowlist") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SWITCH;
        goto L285
    L45:
        if (r9.equals("get-app-metadata") == false) goto L284;
        r2 = ParameterName.SPEAKERS_ENABLED;
        goto L285
    L48:
        if (r9.equals("install-write") == false) goto L284;
        r2 = ParameterName.BLUE_STRETCH;
        goto L285
    L51:
        if (r9.equals("get-user-restriction") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_RED;
        goto L285
    L54:
        if (r9.equals("set-home-activity") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_MAGENTA;
        goto L285
    L57:
        if (r9.equals("clear-permission-flags") == false) goto L284;
        r2 = 52;
        goto L285
    L60:
        if (r9.equals("trim-caches") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_GREEN;
        goto L285
    L63:
        if (r9.equals("query-activities") == false) goto L284;
        r2 = 10;
        goto L285
    L66:
        if (r9.equals("set-user-restriction") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_FLESH;
        goto L285
    L69:
        if (r9.equals("uninstall-system-updates") == false) goto L284;
        r2 = 76;
        goto L285
    L72:
        if (r9.equals("install-destroy") == false) goto L284;
        r2 = ParameterName.DE_CONTOUR;
        goto L285
    L75:
        if (r9.equals("compile-monitor-dumpstore") == false) goto L284;
        r2 = 6;
        goto L285
    L78:
        if (r9.equals("install-archived") == false) goto L284;
        r2 = 34;
        goto L285
    L81:
        if (r9.equals("get-distracting-restriction") == false) goto L284;
        r2 = ParameterName.LD_MODE;
        goto L285
    L84:
        if (r9.equals("rollback-app") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_YELLOW;
        goto L285
    L87:
        if (r9.equals("reset-permissions") == false) goto L284;
        r2 = 50;
        goto L285
    L90:
        if (r9.equals("install-remove") == false) goto L284;
        r2 = ParameterName.BLACK_STRETCH;
        goto L285
    L93:
        if (r9.equals("install-add-session") == false) goto L284;
        r2 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L285
    L96:
        if (r9.equals("get-harmful-app-warning") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_BLUE;
        goto L285
    L99:
        if (r9.equals("install-existing") == false) goto L284;
        r2 = ParameterName.COLOR_TUNE;
        goto L285
    L102:
        if (r9.equals("grant") == false) goto L284;
        r2 = 48;
        goto L285
    L105:
        if (r9.equals("clear") == false) goto L284;
        r2 = ParameterName.VRR;
        goto L285
    L108:
        if (r9.equals("install-streaming") == false) goto L284;
        r2 = 14;
        goto L285
    L111:
        if (r9.equals("supports-multiple-users") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_GREEN;
        goto L285
    L114:
        if (r9.equals("get-max-users") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_BLUE;
        goto L285
    L117:
        if (r9.equals("dump-package") == false) goto L284;
        r2 = 4;
        goto L285
    L120:
        if (r9.equals("move-package") == false) goto L284;
        r2 = ParameterName.GAMUT_MAPPING;
        goto L285
    L123:
        if (r9.equals("path") == false) goto L284;
        r2 = 2;
        goto L285
    L126:
        if (r9.equals("list") == false) goto L284;
        r2 = 7;
        goto L285
    L129:
        if (r9.equals("hide") == false) goto L284;
        r2 = ParameterName.COLOR_TEMPERATURE_RED_OFFSET;
        goto L285
    L132:
        if (r9.equals("help") == false) goto L284;
        r2 = 1;
        goto L285
    L135:
        if (r9.equals(ArchiveStreamFactory.DUMP) == false) goto L284;
        r2 = 3;
        goto L285
    L138:
        if (r9.equals("gc") == false) goto L284;
        r2 = 8;
        goto L285
    L141:
        if (r9.equals("request-unarchive") == false) goto L284;
        r2 = ParameterName.DTS_DRC;
        goto L285
    L144:
        if (r9.equals("get-shared-uid-allowlist") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_RED;
        goto L285
    L147:
        if (r9.equals("move-primary-storage") == false) goto L284;
        r2 = ParameterName.PC_MODE;
        goto L285
    L150:
        if (r9.equals("default-state") == false) goto L284;
        r2 = ParameterName.COLOR_TEMPERATURE_BLUE_GAIN;
        goto L285
    L153:
        if (r9.equals("install-create") == false) goto L284;
        r2 = ParameterName.FILM_MODE;
        goto L285
    L156:
        if (r9.equals("install-commit") == false) goto L284;
        r2 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L285
    L159:
        if (r9.equals("unsuspend") == false) goto L284;
        r2 = ParameterName.ELEVEN_POINT_BLUE;
        goto L285
    L162:
        if (r9.equals("rename-user") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_YELLOW;
        goto L285
    L165:
        if (r9.equals("set-permission-enforced") == false) goto L284;
        r2 = 53;
        goto L285
    L168:
        if (r9.equals("remove-user") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_CYAN;
        goto L285
    L171:
        if (r9.equals("get-stagedsessions") == false) goto L284;
        r2 = 75;
        goto L285
    L174:
        if (r9.equals("query-receivers") == false) goto L284;
        r2 = 12;
        goto L285
    L177:
        if (r9.equals("query-services") == false) goto L284;
        r2 = 11;
        goto L285
    L180:
        if (r9.equals("create-user") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_HUE_BLUE;
        goto L285
    L183:
        if (r9.equals("uninstall") == false) goto L284;
        r2 = ParameterName.LOW_LATENCY;
        goto L285
    L186:
        if (r9.equals("bypass-staged-installer-check") == false) goto L284;
        r2 = ParameterName.BASS;
        goto L285
    L189:
        if (r9.equals("install-incremental") == false) goto L284;
        r2 = 15;
        goto L285
    L192:
        if (r9.equals("archive") == false) goto L284;
        r2 = 88;
        goto L285
    L195:
        if (r9.equals("compile-monitor-status") == false) goto L284;
        r2 = 5;
        goto L285
    L198:
        if (r9.equals("disable-verification-for-uid") == false) goto L284;
        r2 = ParameterName.SURROUND_SOUND_ENABLED;
        goto L285
    L201:
        if (r9.equals("do6939Service") == false) goto L284;
        r2 = 0;
        goto L285
    L204:
        if (r9.equals("unstop") == false) goto L284;
        r2 = 42;
        goto L285
    L207:
        if (r9.equals("unhide") == false) goto L284;
        r2 = 41;
        goto L285
    L210:
        if (r9.equals("get-domain-verification-agent") == false) goto L284;
        r2 = ParameterName.DOLBY_AUDIO_PROCESSING;
        goto L285
    L213:
        if (r9.equals("revoke") == false) goto L284;
        r2 = 49;
        goto L285
    L216:
        if (r9.equals("set-distracting-restriction") == false) goto L284;
        r2 = ParameterName.LOW_BLUE_LIGHT;
        goto L285
    L219:
        if (r9.equals("suspend-quarantine") == false) goto L284;
        r2 = ParameterName.ELEVEN_POINT_GREEN;
        goto L285
    L222:
        if (r9.equals("disable-user") == false) goto L284;
        r2 = 37;
        goto L285
    L225:
        if (r9.equals("install-get-pre-verified-domains") == false) goto L284;
        r2 = ParameterName.LEVEL_RANGE;
        goto L285
    L228:
        if (r9.equals("get-privapp-permissions") == false) goto L284;
        r2 = 54;
        goto L285
    L231:
        if (r9.equals("get-oem-permissions") == false) goto L284;
        r2 = ParameterName.OSD_CONTRAST;
        goto L285
    L234:
        if (r9.equals("get-privapp-deny-permissions") == false) goto L284;
        r2 = 55;
        goto L285
    L237:
        if (r9.equals("resolve-activity") == false) goto L284;
        r2 = 9;
        goto L285
    L240:
        if (r9.equals("get-instantapp-resolver") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_FLESH;
        goto L285
    L243:
        if (r9.equals("enable") == false) goto L284;
        r2 = 35;
        goto L285
    L246:
        if (r9.equals("has-feature") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_RED;
        goto L285
    L249:
        if (r9.equals("wait-for-handler") == false) goto L284;
        r2 = ParameterName.ENHANCED_AUDIO_RETURN_CHANNEL_ENABLED;
        goto L285
    L252:
        if (r9.equals("set-silent-updates-policy") == false) goto L284;
        r2 = 83;
        goto L285
    L255:
        if (r9.equals("set-installer") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_YELLOW;
        goto L285
    L258:
        if (r9.equals("clear-package-preferred-activities") == false) goto L284;
        r2 = ParameterName.SPEAKERS_DELAY_MS;
        goto L285
    L261:
        if (r9.equals("get-max-running-users") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_SATURATION_CYAN;
        goto L285
    L264:
        if (r9.equals("suspend") == false) goto L284;
        r2 = ParameterName.ELEVEN_POINT_RED;
        goto L285
    L267:
        if (r9.equals("install-set-pre-verified-domains") == false) goto L284;
        r2 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L285
    L270:
        if (r9.equals("get-install-location") == false) goto L284;
        r2 = ParameterName.GLOBE_DIMMING;
        goto L285
    L273:
        if (r9.equals("get-archived-package-metadata") == false) goto L284;
        r2 = ParameterName.CVRR;
        goto L285
    L276:
        if (r9.equals("install-abandon") == false) goto L284;
        r2 = 16;
        goto L285
    L279:
        if (r9.equals("wait-for-background-handler") == false) goto L284;
        r2 = ParameterName.AUTO_VOLUME_CONTROL;
        goto L285
    L282:
        if (r9.equals("set-harmful-app-warning") == false) goto L284;
        r2 = ParameterName.COLOR_TUNER_LUMINANCE_GREEN;
        goto L285
    L4:
        return handleDefaultCommands(r9);
    }

    private int runCompileMonitorStatus() {
        if (SysMonitorSvcBridge.getFactory().getCompileMonitorService().dumpState(getOutPrintWriter()) == true) goto L6;
        getErrPrintWriter().println("Error: compile monitor service unavailable");
        return 1;
    L6:
        return 0;
    }

    private int runCompileMonitorDumpStore() {
        int limit = 20;
        String opt = getNextOption();
        if (opt == null) goto L6;
        opt.hashCode();
        getErrPrintWriter().println("Error: unknown option: " + opt);
        return 1;
    L6:
        String arg = getNextArg();
        if (arg != null) goto L28;
    L18:
        String extraArg = getNextArg();
        if (extraArg == null) goto L23;
        getErrPrintWriter().println("Error: unexpected argument: " + extraArg);
        return 1;
    L23:
        if (SysMonitorSvcBridge.getFactory().getCompileMonitorService().dumpStore(getOutPrintWriter(), limit) == true) goto L26;
        getErrPrintWriter().println("Error: compile monitor service unavailable");
        return 1;
    L26:
        return 0;
    L28:
        limit = Integer.parseInt(arg);     // Catch: NumberFormatException -> L15
        if (limit >= 1) goto L12;
    L13:
        getErrPrintWriter().println("Error: limit must be in [1, 200]: " + limit);
        return 1;
    L12:
        if (limit <= 200) goto L18;
    L16:
        getErrPrintWriter().println("Error: invalid limit: " + arg);
        return 1;
    }

    private int runGetModuleInfo() {
        PrintWriter pw = getOutPrintWriter();
        int flags = 0;
    L3:
        String opt = getNextOption();
        byte r4 = 1;
        if (opt == null) goto L21;
        switch(opt.hashCode()) {
            case 42995713: goto L12;
            case 517440986: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L19;
            case 1: goto L3;
            default: goto L16;
        };
    L16:
        pw.println("Error: Unknown option: " + opt);
        return -1;
    L19:
        flags = flags | 131072;
        goto L3
    L9:
        if (opt.equals("--installed") == true) goto L15;
        r4 = -1;
        goto L15
    L12:
        if (opt.equals("--all") == false) goto L44;
        r4 = 0;
        goto L15
    L44:
        r4 = -1;
        goto L15
    L21:
        String moduleName = getNextArg();
        if (moduleName == null) goto L26;
        ModuleInfo m = this.mInterface.getModuleInfo(moduleName, flags);     // Catch: RemoteException -> L24
        pw.println(m.toString() + " packageName: " + m.getPackageName());     // Catch: RemoteException -> L24
    L32:
        return 1;
    L26:
        List<ModuleInfo> modules = this.mInterface.getInstalledModules(flags);     // Catch: RemoteException -> L24
        Iterator<ModuleInfo> r8 = modules.iterator();     // Catch: RemoteException -> L24
    L28:
        if (r8.hasNext() == false) goto L32;
        ModuleInfo m2 = r8.next();     // Catch: RemoteException -> L24
        pw.println(m2.toString() + " packageName: " + m2.getPackageName());     // Catch: RemoteException -> L24
    L24:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    }

    private int runLogVisibility() {
        PrintWriter pw = getOutPrintWriter();
        boolean enable = true;
    L3:
        String opt = getNextOption();
        byte r4 = 1;
        if (opt == null) goto L21;
        switch(opt.hashCode()) {
            case -1237677752: goto L12;
            case 1101165347: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        pw.println("Error: Unknown option: " + opt);
        return -1;
    L19:
        enable = false;
        goto L3
    L18:
        enable = true;
        goto L3
    L9:
        if (opt.equals("--enable") == true) goto L15;
        r4 = -1;
        goto L15
    L12:
        if (opt.equals("--disable") == false) goto L35;
        r4 = 0;
        goto L15
    L35:
        r4 = -1;
        goto L15
    L21:
        String packageName = getNextArg();
        if (packageName == null) goto L25;
        ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).setVisibilityLogging(packageName, enable);
        return 1;
    L25:
        getErrPrintWriter().println("Error: no package specified");
        return -1;
    }

    private int runBypassStagedInstallerCheck() {
        PrintWriter pw = getOutPrintWriter();
        this.mInterface.getPackageInstaller().bypassNextStagedInstallerCheck(Boolean.parseBoolean(getNextArg()));     // Catch: RemoteException -> L6
        return 0;
    L6:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    }

    private int runBypassAllowedApexUpdateCheck() {
        PrintWriter pw = getOutPrintWriter();
        this.mInterface.getPackageInstaller().bypassNextAllowedApexUpdateCheck(Boolean.parseBoolean(getNextArg()));     // Catch: RemoteException -> L6
        return 0;
    L6:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    }

    private int runDisableVerificationForUid() {
        PrintWriter pw = getOutPrintWriter();
        int uid = Integer.parseInt(getNextArgRequired());     // Catch: RemoteException -> L10
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: RemoteException -> L10
        if (amInternal.getInstrumentationSourceUid(uid) == (-1)) goto L6;
        boolean isInstrumented = true;
    L7:
        if (isInstrumented == false) goto L12;
        this.mInterface.getPackageInstaller().disableVerificationForUid(uid);     // Catch: RemoteException -> L10
        return 0;
    L12:
        pw.println("Error: must specify an instrumented uid");     // Catch: RemoteException -> L10
        return -1;
    L6:
        isInstrumented = false;
    L10:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    }

    private int uninstallSystemUpdates(String packageName) {
        PrintWriter pw = getOutPrintWriter();
        boolean failedUninstalls = false;
        IPackageInstaller installer = this.mInterface.getPackageInstaller();     // Catch: RemoteException -> L6
        if (packageName != null) goto L8;
        ParceledListSlice<ApplicationInfo> packages = this.mInterface.getInstalledApplications(1056768, 0);     // Catch: RemoteException -> L6
        List<ApplicationInfo> list = packages.getList();     // Catch: RemoteException -> L6
    L9:
        Iterator<ApplicationInfo> r11 = list.iterator();     // Catch: RemoteException -> L6
    L10:
        if (r11.hasNext() == false) goto L19;
        ApplicationInfo info = r11.next();     // Catch: RemoteException -> L6
        if (info.isUpdatedSystemApp() == false) goto L10;
        pw.println("Uninstalling updates to " + info.packageName + "...");     // Catch: RemoteException -> L6
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);     // Catch: RemoteException -> L6
        installer.uninstall(new VersionedPackage(info.packageName, info.versionCode), null, 0, receiver.getIntentSender(), 0);     // Catch: RemoteException -> L6
        Intent result = receiver.getResult();     // Catch: RemoteException -> L6
        int status = result.getIntExtra("android.content.pm.extra.STATUS", 1);     // Catch: RemoteException -> L6
        if (status == 0) goto L10;
        failedUninstalls = true;
        pw.println("Couldn't uninstall package: " + info.packageName);     // Catch: RemoteException -> L6
        goto L10
    L19:
        if (failedUninstalls == false) goto L21;
        return 0;
    L21:
        pw.println("Success");
        return 1;
    L8:
        List<ApplicationInfo> list2 = new ArrayList(1);     // Catch: RemoteException -> L6
        list2.add(this.mInterface.getApplicationInfo(packageName, 1056768, 0));     // Catch: RemoteException -> L6
        list = list2;
    L6:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return 0;
    }

    private int runRollbackApp() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        long stagedReadyTimeoutMs = 60000;
    L3:
        String opt = getNextOption();
        int r6 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case -158482320: goto L9;
            default: goto L11;
        };
    L11:
        r6 = -1;
    L12:
        switch(r6) {
            case 0: goto L15;
            default: goto L14;
        };
    L15:
        stagedReadyTimeoutMs = Long.parseLong(getNextArgRequired());
        goto L3
    L14:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L9:
        if (opt.equals("--staged-ready-timeout") == false) goto L11;
    L16:
        String packageName = getNextArgRequired();
        if (packageName != null) goto L52;
        pw.println("Error: package name not specified");
        return 1;
    L52:
        Context shellPackageContext = this.mContext.createPackageContextAsUser("com.android.shell", 0, Binder.getCallingUserHandle());     // Catch: PackageManager.NameNotFoundException -> L49
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);
        RollbackManager rm = (RollbackManager) shellPackageContext.getSystemService(RollbackManager.class);
        RollbackInfo rollback = null;
        Iterator r12 = rm.getAvailableRollbacks().iterator();
    L23:
        if (r12.hasNext() == false) goto L33;
        RollbackInfo r = (RollbackInfo) r12.next();
        Iterator r14 = r.getPackages().iterator();
    L26:
        if (r14.hasNext() == false) goto L31;
        PackageRollbackInfo info = (PackageRollbackInfo) r14.next();
        int r16 = r6;
        if (packageName.equals(info.getPackageName()) == true) goto L29;
        r6 = r16;
        goto L26
    L29:
        rollback = r;
    L32:
        r6 = r16;
        goto L23
    L31:
        r16 = r6;
        goto L32
    L33:
        int r17 = r6;
        if (rollback != null) goto L37;
        pw.println("No available rollbacks for: " + packageName);
        return 1;
    L37:
        rm.commitRollback(rollback.getRollbackId(), Collections.emptyList(), receiver.getIntentSender());
        Intent result = receiver.getResult();
        int status = result.getIntExtra("android.content.rollback.extra.STATUS", 1);
        if (status == 0) goto L42;
        pw.println("Failure [" + result.getStringExtra("android.content.rollback.extra.STATUS_MESSAGE") + "]");
        return 1;
    L42:
        if (rollback.isStaged() == true) goto L44;
    L47:
        pw.println("Success");
        return r17;
    L44:
        if (stagedReadyTimeoutMs <= 0) goto L47;
        int committedSessionId = rollback.getCommittedSessionId();
        return doWaitForStagedSessionReady(committedSessionId, stagedReadyTimeoutMs, pw);
    L49:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void setParamsSize(InstallParams params, List<String> inPaths) {
        if (params.sessionParams.sizeBytes != (-1)) goto L38;
        if (STDIN_PATH.equals(inPaths.get(0)) == true) goto L52;
        long sessionSize = 0;
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        Iterator<String> r8 = inPaths.iterator();
    L9:
        if (r8.hasNext() == false) goto L35;
        String inPath = r8.next();
        ParcelFileDescriptor fd = openFileForSystem(inPath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);
        if (fd == null) goto L33;
        ParseResult<ApkLite> apkLiteResult = ApkLiteParseUtils.parseApkLite(input.reset(), fd.getFileDescriptor(), inPath, 0);     // Catch: Throwable -> L20 IOException -> L22
        if (apkLiteResult.isError() == true) goto L25;
        ApkLite apkLite = (ApkLite) apkLiteResult.getResult();     // Catch: Throwable -> L20 IOException -> L22
        PackageLite pkgLite = new PackageLite(null, apkLite.getPath(), apkLite, null, null, null, null, null, null, apkLite.getTargetSdkVersion(), null, null);     // Catch: Throwable -> L20 IOException -> L22
        sessionSize = sessionSize + InstallLocationUtils.calculateInstalledSize(pkgLite, params.sessionParams.abiOverride, fd.getFileDescriptor());
        fd.close();     // Catch: IOException -> L18
        goto L9
    L25:
        throw new IllegalArgumentException("Error: Failed to parse APK file: " + inPath + ": " + apkLiteResult.getErrorMessage(), apkLiteResult.getException());     // Catch: Throwable -> L20 IOException -> L22
    L20:
        th = move-exception;
        fd.close();     // Catch: IOException -> L31
        throw th;
    L32:
        throw th;
    L22:
        e = move-exception;
        getErrPrintWriter().println("Error: Failed to parse APK file: " + inPath);     // Catch: Throwable -> L20
        throw new IllegalArgumentException("Error: Failed to parse APK file: " + inPath, e);     // Catch: Throwable -> L20
    L33:
        getErrPrintWriter().println("Error: Can't open file: " + inPath);
        throw new IllegalArgumentException("Error: Can't open file: " + inPath);
    L35:
        params.sessionParams.setSize(sessionSize);
        return;
    L52:
        return;
    }

    private int displayPackageFilePath(String pckg, int userId) throws RemoteException {
        PackageInfo info = this.mInterface.getPackageInfo(pckg, 1073741824, userId);
        if (info != null) goto L5;
        return 1;
    L5:
        if (info.applicationInfo == null) goto L16;
        PrintWriter pw = getOutPrintWriter();
        pw.print("package:");
        pw.println(info.applicationInfo.sourceDir);
        if (ArrayUtils.isEmpty(info.applicationInfo.splitSourceDirs) == true) goto L12;
        String[] r3 = info.applicationInfo.splitSourceDirs;
        int r5 = r3.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L12;
        String splitSourceDir = r3[r6];
        pw.print("package:");
        pw.println(splitSourceDir);
        r6 = r6 + 1;
    L12:
        return 0;
    L16:
        return 1;
    }

    private int runDo6939Service() {
        int callingUid = Binder.getCallingUid();     // Catch: Exception -> L7
        if (this.mInterface.checkUidIs6939Authorized(callingUid) == true) goto L9;
        getErrPrintWriter().println("Error: calling package is not have 6939 permission");     // Catch: Exception -> L7
        return -1;
    L9:
        String firstSubCommand = getNextArg();     // Catch: Exception -> L7
        if (firstSubCommand != null) goto L13;
        getErrPrintWriter().println("Error: input arg is error");     // Catch: Exception -> L7
        return -1;
    L13:
        List<String> shellArgList = new ArrayList();     // Catch: Exception -> L7
        shellArgList.add(firstSubCommand);     // Catch: Exception -> L7
        String fullCmds = " " + firstSubCommand;     // Catch: Exception -> L7
        String c_arg = getNextArg();     // Catch: Exception -> L7
    L14:
        if (c_arg == null) goto L16;
        shellArgList.add(c_arg);     // Catch: Exception -> L7
        fullCmds = fullCmds + " " + c_arg;     // Catch: Exception -> L7
        c_arg = getNextArg();     // Catch: Exception -> L7
        goto L14
    L16:
        int rc = this.mInterface.do6939Service((String[]) shellArgList.toArray(new String[shellArgList.size()]));     // Catch: Exception -> L7
        if (rc != 0) goto L19;
        getOutPrintWriter().println("Success: zbackup  do cmd:" + fullCmds);     // Catch: Exception -> L7
    L20:
        return rc;
    L19:
        getErrPrintWriter().println("Error: zbackup do cmd: " + fullCmds + ", rc=" + rc);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        getErrPrintWriter().println("zbackup do Command Exception=" + e.toString());
        return -1;
    }

    private int runPath() throws RemoteException {
        int userId = 0;
        String option = getNextOption();
        if (option != null) goto L5;
    L7:
        String pkg = getNextArgRequired();
        if (pkg != null) goto L11;
        getErrPrintWriter().println("Error: no package specified");
        return 1;
    L11:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runPath");
        return displayPackageFilePath(pkg, translatedUserId);
    L5:
        if (option.equals("--user") == false) goto L7;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L7
    }

    private int runList() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String type = getNextArg();
        if (type != null) goto L7;
        pw.println("Error: didn't specify type of data to list");
        return -1;
    L7:
        switch(type.hashCode()) {
            case -1126096540: goto L40;
            case -997447790: goto L37;
            case -807062458: goto L34;
            case -290659267: goto L31;
            case 3525497: goto L28;
            case 111578632: goto L25;
            case 544550766: goto L22;
            case 750867693: goto L19;
            case 812757657: goto L16;
            case 1133704324: goto L13;
            case 1786251458: goto L10;
            default: goto L42;
        };
    L42:
        byte r3 = -1;
    L43:
        switch(r3) {
            case 0: goto L65;
            case 1: goto L63;
            case 2: goto L61;
            case 3: goto L59;
            case 4: goto L59;
            case 5: goto L57;
            case 6: goto L55;
            case 7: goto L53;
            case 8: goto L51;
            case 9: goto L48;
            case 10: goto L47;
            default: goto L44;
        };
    L44:
        pw.println("Error: unknown list type '" + type + "'");
        return -1;
    L48:
        ServiceManager.getService("user").shellCommand(getInFileDescriptor(), getOutFileDescriptor(), getErrFileDescriptor(), new String[]{"list"}, getShellCallback(), adoptResultReceiver());
        return 0;
    L47:
        return runListInitialNonStoppedSystemPackages();
    L51:
        return runListSdks();
    L53:
        return runListStagedSessions();
    L55:
        return runListPermissions();
    L57:
        return runListPermissionGroups();
    L59:
        return runListPackages(false);
    L61:
        return runListLibraries();
    L63:
        return runListInstrumentation();
    L65:
        return runListFeatures();
    L10:
        if (type.equals("initial-non-stopped-system-packages") == false) goto L66;
        r3 = 10;
        goto L43
    L66:
        r3 = -1;
        goto L43
    L13:
        if (type.equals("permissions") == false) goto L67;
        r3 = 6;
        goto L43
    L67:
        r3 = -1;
        goto L43
    L16:
        if (type.equals("libraries") == false) goto L68;
        r3 = 2;
        goto L43
    L68:
        r3 = -1;
        goto L43
    L19:
        if (type.equals("packages") == false) goto L69;
        r3 = 4;
        goto L43
    L69:
        r3 = -1;
        goto L43
    L22:
        if (type.equals("instrumentation") == false) goto L70;
        r3 = 1;
        goto L43
    L70:
        r3 = -1;
        goto L43
    L25:
        if (type.equals(DatabaseHelper.SoundModelContract.KEY_USERS) == false) goto L71;
        r3 = 9;
        goto L43
    L71:
        r3 = -1;
        goto L43
    L28:
        if (type.equals("sdks") == false) goto L72;
        r3 = 8;
        goto L43
    L72:
        r3 = -1;
        goto L43
    L31:
        if (type.equals("features") == false) goto L73;
        r3 = 0;
        goto L43
    L73:
        r3 = -1;
        goto L43
    L34:
        if (type.equals(Settings.ATTR_PACKAGE) == false) goto L74;
        r3 = 3;
        goto L43
    L74:
        r3 = -1;
        goto L43
    L37:
        if (type.equals("permission-groups") == false) goto L75;
        r3 = 5;
        goto L43
    L75:
        r3 = -1;
        goto L43
    L40:
        if (type.equals("staged-sessions") == false) goto L76;
        r3 = 7;
        goto L43
    L76:
        r3 = -1;
        goto L43
    }

    private int runGc() throws RemoteException {
        Runtime.getRuntime().gc();
        PrintWriter pw = getOutPrintWriter();
        pw.println("Ok");
        return 0;
    }

    private int runListInitialNonStoppedSystemPackages() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        List<String> list = this.mInterface.getInitialNonStoppedSystemPackages();
        Collections.sort(list);
        Iterator<String> r2 = list.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String pkgName = r2.next();
        pw.print("package:");
        pw.print(pkgName);
        pw.println();
        goto L4
    L6:
        return 0;
    }

    private int runListFeatures() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        List<FeatureInfo> list = this.mInterface.getSystemAvailableFeatures().getList();
        Collections.sort(list, new AnonymousClass1(this));
        if (list == null) goto L5;
        int count = list.size();
    L6:
        int p = 0;
    L7:
        if (p >= count) goto L17;
        FeatureInfo fi = list.get(p);
        pw.print("feature:");
        if (fi.name == null) goto L14;
        pw.print(fi.name);
        if (fi.version <= 0) goto L13;
        pw.print("=");
        pw.print(fi.version);
    L13:
        pw.println();
    L15:
        p = p + 1;
        goto L7
    L14:
        pw.println("reqGlEsVersion=0x" + Integer.toHexString(fi.reqGlEsVersion));
        goto L15
    L17:
        return 0;
    L5:
        count = 0;
        goto L6
    }

    private int runListInstrumentation() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        boolean showSourceDir = false;
        String targetPackage = null;
    L37:
        String opt = getNextArg();     // Catch: RuntimeException -> L19
        if (opt == null) goto L23;
        switch(opt.hashCode()) {
            case 1497: goto L10;
            default: goto L12;
        };     // Catch: RuntimeException -> L19
    L12:
        byte r4 = -1;
    L13:
        switch(r4) {
            case 0: goto L21;
            default: goto L15;
        };     // Catch: RuntimeException -> L19
    L21:
        showSourceDir = true;
        goto L37
    L15:
        if (opt.charAt(0) == '-') goto L17;
        targetPackage = opt;
        goto L37
    L17:
        pw.println("Error: Unknown option: " + opt);     // Catch: RuntimeException -> L19
        return -1;
    L10:
        if (opt.equals("-f") == false) goto L12;
        r4 = 0;
        goto L13
    L23:
        List<InstrumentationInfo> list = this.mInterface.queryInstrumentationAsUser(targetPackage, 4202496, 0).getList();
        Collections.sort(list, new AnonymousClass2(this));
        if (list == null) goto L26;
        int count = list.size();
    L27:
        int p = 0;
    L28:
        if (p >= count) goto L34;
        InstrumentationInfo ii = list.get(p);
        pw.print("instrumentation:");
        if (showSourceDir == false) goto L32;
        pw.print(ii.sourceDir);
        pw.print("=");
    L32:
        ComponentName cn = new ComponentName(ii.packageName, ii.name);
        pw.print(cn.flattenToShortString());
        pw.print(" (target=");
        pw.print(ii.targetPackage);
        pw.println(")");
        p = p + 1;
        goto L28
    L34:
        return 0;
    L26:
        count = 0;
    L19:
        ex = move-exception;
        pw.println("Error: " + ex.toString());
        return -1;
    }

    private int runListLibraries() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        boolean verbose = false;
    L3:
        String opt = getNextArg();
        byte r4 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1513: goto L9;
            default: goto L11;
        };
    L11:
        r4 = -1;
    L12:
        switch(r4) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        verbose = true;
        goto L3
    L13:
        pw.println("Error: Unknown option: " + opt);
        return -1;
    L9:
        if (opt.equals("-v") == false) goto L11;
    L16:
        Map<String, String> namesAndPaths = this.mInterface.getSystemSharedLibraryNamesAndPaths();
        if (namesAndPaths.isEmpty() == false) goto L19;
        return 0;
    L19:
        List<String> libs = new ArrayList(namesAndPaths.keySet());
        Collections.sort(libs, new PackageManagerShellCommand$$ExternalSyntheticLambda2());
        int i = 0;
    L21:
        if (i >= libs.size()) goto L27;
        String lib = libs.get(i);
        pw.print("library:");
        pw.print(lib);
        if (verbose == false) goto L25;
        pw.print(" path:");
        pw.print(namesAndPaths.get(lib));
    L25:
        pw.println();
        i = i + 1;
        goto L21
    L27:
        return 0;
    }

    private static /* synthetic */ int lambda$runListLibraries$0(String o1, String o2) {
        if (o1 != o2) goto L5;
        return 0;
    L5:
        if (o1 != null) goto L8;
        return -1;
    L8:
        if (o2 != null) goto L12;
        return 1;
    L12:
        return o1.compareTo(o2);
    }

    private int runListPackages(boolean showSourceDir) throws RemoteException {
        return runListPackages(showSourceDir, false);
    }

    private int runListSdks() throws RemoteException {
        return runListPackages(false, true);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private int runListPackages(boolean showSourceDir, boolean showSdks) throws RemoteException {
        if (showSdks == false) goto L5;
        String r0 = "sdk:";
    L6:
        String prefix = r0;
        PrintWriter pw = getOutPrintWriter();
        boolean showSourceDir2 = false;
        int uid = -1;
        int uid2 = 0;
        boolean listApexOnly = false;
        boolean showVersionCode = false;
        boolean listInstaller = false;
        int defaultUserId = -1;
        boolean showStopped = false;
        boolean showStopped2 = false;
        boolean listQuarantinedOnly = false;
        boolean showUid = false;
        boolean listThirdParty = false;
        int getFlags = 0;
    L7:
        boolean listDisabled = showSourceDir2;
        String opt = getNextOption();     // Catch: RuntimeException -> L213
        if (opt == null) goto L103;
    L81:
        ex = e;
    L215:
        pw.println("Error: " + ex.toString());
        return -1;
    L12:
        switch(opt.hashCode()) {
            case -493830763: goto L69;
            case 1446: goto L66;
            case 1480: goto L63;
            case 1492: goto L60;
            case 1495: goto L57;
            case 1496: goto L54;
            case 1497: goto L51;
            case 1500: goto L48;
            case 1503: goto L45;
            case 1508: goto L42;
            case 1510: goto L39;
            case 1512: goto L36;
            case 43014832: goto L33;
            case 774814767: goto L30;
            case 1017551005: goto L27;
            case 1333469547: goto L24;
            case 1464517361: goto L21;
            case 1809263575: goto L217;
            default: goto L13;
        };
    L13:
        String opt2 = opt;
    L73:
        byte r7 = -1;
    L74:
        switch(r7) {
            case 0: goto L101;
            case 1: goto L100;
            case 2: goto L99;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L93;
            case 9: goto L92;
            case 10: goto L91;
            case 11: goto L90;
            case 12: goto L89;
            case 13: goto L88;
            case 14: goto L86;
            case 15: goto L85;
            case 16: goto L223;
            case 17: goto L83;
            default: goto L75;
        };     // Catch: RuntimeException -> L81
    L83:
        showStopped = true;
        boolean showStopped3 = showSourceDir;
    L102:
        showSourceDir = showStopped3;
        showSourceDir2 = listDisabled;
        goto L7
    L85:
        boolean listEnabled = listThirdParty;
        listQuarantinedOnly = true;
        int uid3 = Integer.parseInt(getNextArgRequired());     // Catch: RuntimeException -> L79
        uid = uid3;
        listThirdParty = listEnabled;
        showStopped3 = showSourceDir;
        goto L102
    L86:
        boolean listEnabled2 = listThirdParty;
        int defaultUserId2 = UserHandle.parseUserArg(getNextArgRequired());     // Catch: RuntimeException -> L79
        defaultUserId = defaultUserId2;
        listThirdParty = listEnabled2;
        showStopped3 = showSourceDir;
        goto L102
    L88:
        getFlags = getFlags | 2097152;
        showStopped3 = showSourceDir;
        goto L102
    L89:
        getFlags = getFlags | 1073741824;
        uid2 = 1;
        showStopped3 = showSourceDir;
        goto L102
    L90:
        listApexOnly = true;
        showStopped3 = showSourceDir;
        goto L102
    L91:
        showUid = true;
        showStopped3 = showSourceDir;
        goto L102
    L92:
        getFlags = getFlags | 8192;
        showStopped3 = showSourceDir;
        goto L102
    L93:
        listQuarantinedOnly = true;
        showStopped3 = showSourceDir;
        goto L102
    L94:
        showStopped2 = true;
        showStopped3 = showSourceDir;
        goto L102
    L95:
        listInstaller = true;
        showStopped3 = showSourceDir;
        goto L102
    L96:
        showStopped3 = showSourceDir;
        goto L102
    L97:
        showVersionCode = true;
        showStopped3 = showSourceDir;
        goto L102
    L98:
        showStopped3 = true;
        goto L102
    L99:
        getFlags = (getFlags | 4202496) | 536870912;
        showStopped3 = showSourceDir;
        goto L102
    L100:
        listThirdParty = true;
        showStopped3 = showSourceDir;
        goto L102
    L101:
        listDisabled = true;
        showStopped3 = showSourceDir;
        goto L102
    L223:
        getFlags = getFlags | 67108864;     // Catch: RuntimeException -> L79
        showStopped3 = showSourceDir;
    L79:
        ex = e;
        goto L215
    L75:
        StringBuilder r8 = new StringBuilder();     // Catch: RuntimeException -> L81
        r8.append("Error: Unknown option: ");     // Catch: RuntimeException -> L79
        r8.append(opt2);     // Catch: RuntimeException -> L79
        pw.println(r8.toString());     // Catch: RuntimeException -> L79
        return -1;
    L21:
        String opt3 = opt;
        if (opt3.equals("--match-libraries") == true) goto L23;
    L18:
        opt2 = opt3;
        goto L73
    L23:
        char r1 = 16;
    L17:
        String r46 = opt3;
        r7 = r1;
        opt2 = r46;
        goto L74
    L24:
        opt3 = opt;
        if (opt3.equals("--user") == false) goto L18;
        r1 = 14;
        goto L17
    L27:
        opt3 = opt;
        if (opt3.equals("--show-stopped") == false) goto L18;
        r1 = 17;
        goto L17
    L30:
        opt3 = opt;
        if (opt3.equals("--factory-only") == false) goto L18;
        r1 = '\r';
        goto L17
    L33:
        opt3 = opt;
        if (opt3.equals("--uid") == false) goto L18;
        r1 = 15;
        goto L17
    L36:
        opt3 = opt;
        if (opt3.equals("-u") == false) goto L18;
        r1 = '\t';
        goto L17
    L39:
        opt3 = opt;
        if (opt3.equals("-s") == false) goto L18;
        r1 = 6;
        goto L17
    L42:
        opt3 = opt;
        if (opt3.equals("-q") == false) goto L18;
        r1 = 7;
        goto L17
    L45:
        opt3 = opt;
        if (opt3.equals("-l") == false) goto L18;
        r1 = 5;
        goto L17
    L48:
        opt3 = opt;
        if (opt3.equals("-i") == false) goto L18;
        r1 = 4;
        goto L17
    L51:
        opt3 = opt;
        if (opt3.equals("-f") == false) goto L18;
        opt2 = opt3;
        r7 = 3;
        goto L74
    L54:
        opt3 = opt;
        if (opt3.equals("-e") == false) goto L18;
        opt2 = opt3;
        r7 = 1;
        goto L74
    L57:
        opt2 = opt;
        if (opt2.equals("-d") == false) goto L73;
        r7 = 0;
        goto L74
    L60:
        opt2 = opt;
        if (opt2.equals("-a") == false) goto L73;
        r7 = 2;
        goto L74
    L63:
        opt2 = opt;
        if (opt2.equals("-U") == false) goto L73;
        r7 = 8;
        goto L74
    L66:
        opt2 = opt;
        if (opt2.equals("-3") == false) goto L73;
        r7 = 10;
        goto L74
    L69:
        opt2 = opt;
        if (opt2.equals("--show-versioncode") == false) goto L73;
        r7 = 11;
        goto L74
    L217:
        opt3 = opt;
        if (opt3.equals("--apex-only") == false) goto L18;
        r1 = '\f';
    L19:
        ex = e;
        goto L215
    L103:
        boolean listEnabled3 = listThirdParty;
        String filter = getNextArg();
        int[] userIds = {defaultUserId};
        int defaultUserId3 = defaultUserId;
        int defaultUserId4 = getFlags;
        if (defaultUserId3 != (-1)) goto L106;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        int[] userIds2 = umi.getUserIds();
        int[] userIds3 = userIds2;
    L107:
        if (showSdks == false) goto L109;
        int defaultUserId5 = defaultUserId4 | 67108864;
    L110:
        Map<String, List<String>> out = new HashMap();
        boolean listSystem = listInstaller;
        int r9 = userIds3.length;
        int[] userIds4 = userIds3;
        int r6 = 0;
    L111:
        if (r6 >= r9) goto L204;
        int r27 = r6;
        int userId = userIds4[r27];
        int r28 = r9;
        int translatedUserId = translateUserId(userId, 0, "runListPackages");     // Catch: RuntimeException -> L198
        boolean listThirdParty2 = showUid;
        boolean listInstaller2 = showVersionCode;
        ParceledListSlice<PackageInfo> slice = this.mInterface.getInstalledPackages(defaultUserId5, translatedUserId);
        List<PackageInfo> packages = slice.getList();
        int count = packages.size();
        int p = 0;
    L117:
        if (p >= count) goto L197;
        int p2 = p;
        PackageInfo info = packages.get(p);
        StringBuilder stringBuilder = new StringBuilder();
        if (filter == null) goto L123;
        List<PackageInfo> packages2 = packages;
        if (info.packageName.contains(filter) == true) goto L124;
        int translatedUserId2 = translatedUserId;
        int uid4 = uid;
        userId = userId;
        String filter2 = filter;
        int count2 = count;
        Map<String, List<String>> out2 = out;
    L196:
        p = p2 + 1;
        out = out2;
        packages = packages2;
        filter = filter2;
        uid = uid4;
        translatedUserId = translatedUserId2;
        count = count2;
        userId = userId;
    L124:
        boolean isApex = info.isApex;
        filter2 = filter;
        if (uid == (-1)) goto L130;
        if (isApex == true) goto L130;
        if (info.applicationInfo.uid == uid) goto L130;
        translatedUserId2 = translatedUserId;
        uid4 = uid;
        userId = userId;
        count2 = count;
        out2 = out;
    L130:
        if (isApex == false) goto L132;
    L134:
        boolean isSystem = false;
    L135:
        if (isApex == true) goto L139;
        uid4 = uid;
        if (info.applicationInfo.enabled == false) goto L140;
        int uid5 = 1;
    L141:
        if (listDisabled == false) goto L145;
        if (uid5 == 0) goto L145;
    L144:
        translatedUserId2 = translatedUserId;
        userId = userId;
        count2 = count;
        out2 = out;
    L145:
        if (listEnabled3 == false) goto L147;
        if (uid5 == 0) goto L144;
    L147:
        if (listSystem == false) goto L149;
        if (isSystem == false) goto L144;
    L149:
        if (listThirdParty2 == false) goto L151;
        if (isSystem == true) goto L144;
    L151:
        if (uid2 == 0) goto L154;
        if (isApex == true) goto L154;
        translatedUserId2 = translatedUserId;
        userId = userId;
        count2 = count;
        out2 = out;
    L154:
        if (showStopped2 == false) goto L159;
        if (this.mInterface.isPackageQuarantinedForUser(info.packageName, translatedUserId) == true) goto L159;
        translatedUserId2 = translatedUserId;
        userId = userId;
        count2 = count;
        out2 = out;
    L159:
        String name = null;
        if (showSdks == false) goto L174;
        translatedUserId2 = translatedUserId;
        count2 = count;
        ParceledListSlice<SharedLibraryInfo> libsSlice = this.mInterface.getDeclaredSharedLibraries(info.packageName, defaultUserId5, userId);
        if (libsSlice != null) goto L164;
        userId = userId;
        out2 = out;
        goto L196
    L164:
        List<SharedLibraryInfo> libs = libsSlice.getList();
        int l = 0;
        int lsize = libs.size();
    L165:
        if (l >= lsize) goto L171;
        SharedLibraryInfo lib = libs.get(l);
        ParceledListSlice<SharedLibraryInfo> libsSlice2 = libsSlice;
        String name2 = name;
        if (lib.getType() == 3) goto L168;
        l = l + 1;
        libsSlice = libsSlice2;
        name = name2;
        goto L165
    L168:
        name = lib.getName() + ":" + lib.getLongVersion();
    L171:
        if (name != null) goto L175;
        out2 = out;
    L175:
        stringBuilder.append(prefix);
        if (showSourceDir == false) goto L178;
        stringBuilder.append(info.applicationInfo.sourceDir);
        stringBuilder.append("=");
    L178:
        stringBuilder.append(name);
        if (listApexOnly == false) goto L184;
        stringBuilder.append(" versionCode:");
        if (info.applicationInfo == null) goto L183;
        stringBuilder.append(info.applicationInfo.longVersionCode);
        goto L184
    L183:
        stringBuilder.append(info.getLongVersionCode());
    L184:
        if (showStopped == false) goto L190;
        stringBuilder.append(" stopped=");
        if ((info.applicationInfo.flags & 2097152) == 0) goto L188;
        String r10 = "true";
    L189:
        stringBuilder.append(r10);
        goto L190
    L188:
        r10 = "false";
    L190:
        if (listInstaller2 == false) goto L192;
        stringBuilder.append("  installer=");
        stringBuilder.append(this.mInterface.getInstallerPackageName(info.packageName));
    L192:
        out2 = out;
        List<String> uids = out2.computeIfAbsent(stringBuilder.toString(), new PackageManagerShellCommand$$ExternalSyntheticLambda1());
        if (listQuarantinedOnly == false) goto L196;
        if (isApex == true) goto L196;
        uids.add(String.valueOf(info.applicationInfo.uid));
        goto L196
    L174:
        translatedUserId2 = translatedUserId;
        userId = userId;
        count2 = count;
        name = info.packageName;
    L140:
        uid5 = 0;
        goto L141
    L139:
        uid4 = uid;
        goto L140
    L132:
        if ((info.applicationInfo.flags & 1) == 0) goto L134;
        isSystem = true;
        goto L135
    L123:
        packages2 = packages;
        goto L124
    L197:
        int uid6 = uid;
        String filter3 = filter;
        Map<String, List<String>> out3 = out;
    L203:
        r6 = r27 + 1;
        out = out3;
        r9 = r28;
        showUid = listThirdParty2;
        showVersionCode = listInstaller2;
        filter = filter3;
        uid = uid6;
    L198:
        ex = move-exception;
        uid6 = uid;
        filter3 = filter;
        listThirdParty2 = showUid;
        listInstaller2 = showVersionCode;
        out3 = out;
        getErrPrintWriter().println("Error: " + ex.toString());
        goto L203
    L204:
        Iterator<Map.Entry<String, List<String>>> r2 = out.entrySet().iterator();
    L206:
        if (r2.hasNext() == false) goto L211;
        Map.Entry<String, List<String>> entry = r2.next();
        pw.print(entry.getKey());
        List<String> uids2 = entry.getValue();
        if (uids2.isEmpty() == true) goto L210;
        pw.print(" uid:");
        pw.print(String.join(",", uids2));
    L210:
        pw.println();
        goto L206
    L211:
        return 0;
    L109:
        defaultUserId5 = defaultUserId4;
        goto L110
    L106:
        userIds3 = userIds;
    L213:
        ex = e;
        goto L215
    L5:
        r0 = "package:";
        goto L6
    }

    private static /* synthetic */ List lambda$runListPackages$1(String k) {
        return new ArrayList();
    }

    private int runListPermissionGroups() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        List<PermissionGroupInfo> pgs = this.mPermissionManager.getAllPermissionGroups(0);
        int count = pgs.size();
        int p = 0;
    L3:
        if (p >= count) goto L6;
        PermissionGroupInfo pgi = pgs.get(p);
        pw.print("permission group:");
        pw.println(pgi.name);
        p = p + 1;
        goto L3
    L6:
        return 0;
    }

    private int runListPermissions() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        boolean userOnly = false;
        boolean dangerousOnly = false;
        boolean labels = false;
        boolean groups = false;
        boolean summary = false;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L33;
        switch(opt.hashCode()) {
            case 1495: goto L21;
            case 1497: goto L18;
            case 1498: goto L15;
            case 1510: goto L12;
            case 1512: goto L9;
            default: goto L23;
        };
    L23:
        r4 = -1;
    L24:
        switch(r4) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L25;
        };
    L25:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L28:
        groups = true;
        labels = true;
        summary = true;
        goto L3
    L29:
        groups = true;
        goto L3
    L30:
        labels = true;
        goto L3
    L31:
        dangerousOnly = true;
        goto L3
    L27:
        userOnly = true;
        goto L3
    L9:
        if (opt.equals("-u") == false) goto L23;
        r4 = 4;
        goto L24
    L12:
        if (opt.equals("-s") == false) goto L23;
        r4 = 3;
        goto L24
    L15:
        if (opt.equals("-g") == false) goto L23;
        r4 = 2;
        goto L24
    L18:
        if (opt.equals("-f") == false) goto L23;
        r4 = 1;
        goto L24
    L21:
        if (opt.equals("-d") == false) goto L23;
    L33:
        ArrayList<String> groupList = new ArrayList();
        if (groups == false) goto L39;
        List<PermissionGroupInfo> infos = this.mPermissionManager.getAllPermissionGroups(0);
        int count = infos.size();
        int i = 0;
    L36:
        if (i >= count) goto L38;
        groupList.add(infos.get(i).name);
        i = i + 1;
        goto L36
    L38:
        groupList.add(null);
    L41:
        if (dangerousOnly == false) goto L45;
        pw.println("Dangerous Permissions:");
        pw.println("");
        doListPermissions(groupList, groups, labels, summary, 1, 1);
        if (userOnly == false) goto L48;
        pw.println("Normal Permissions:");
        pw.println("");
        doListPermissions(groupList, groups, labels, summary, 0, 0);
    L48:
        return 0;
    L45:
        if (userOnly == false) goto L47;
        pw.println("Dangerous and Normal Permissions:");
        pw.println("");
        doListPermissions(groupList, groups, labels, summary, 0, 1);
        goto L48
    L47:
        pw.println("All Permissions:");
        pw.println("");
        doListPermissions(groupList, groups, labels, summary, ProcessList.INVALID_ADJ, 10000);
        goto L48
    L39:
        String grp = getNextArg();
        groupList.add(grp);
        goto L41
    }

    private boolean setSessionFlag(String flag, SessionDump sessionDump) {
        switch(flag.hashCode()) {
            case -2056597429: goto L12;
            case -1847964944: goto L9;
            case 1321081314: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            default: goto L16;
        };
    L16:
        return false;
    L17:
        sessionDump.onlySessionId = true;
    L20:
        return true;
    L18:
        sessionDump.onlyReady = true;
        goto L20
    L19:
        sessionDump.onlyParent = true;
        goto L20
    L6:
        if (flag.equals("--only-ready") == false) goto L14;
        r0 = 1;
        goto L15
    L9:
        if (flag.equals("--only-sessionid") == false) goto L14;
        r0 = 2;
        goto L15
    L12:
        if (flag.equals("--only-parent") == false) goto L14;
        r0 = 0;
        goto L15
    }

    private int runListStagedSessions() {
        IndentingPrintWriter pw = new IndentingPrintWriter(getOutPrintWriter(), "  ", 120);
        SessionDump sessionDump = new SessionDump(null);     // Catch: Throwable -> L11
    L4:
        String opt = getNextOption();     // Catch: Throwable -> L11
        if (opt != null) goto L7;
        List<PackageInstaller.SessionInfo> stagedSessions = this.mInterface.getPackageInstaller().getStagedSessions().getList();     // Catch: Throwable -> L11 RemoteException -> L16
        printSessionList(pw, stagedSessions, sessionDump);     // Catch: Throwable -> L11 RemoteException -> L16
        pw.close();
        return 1;
    L16:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");     // Catch: Throwable -> L11
        pw.close();
        return -1;
    L7:
        if (setSessionFlag(opt, sessionDump) == true) goto L4;
        pw.println("Error: Unknown option: " + opt);     // Catch: Throwable -> L11
        pw.close();
        return -1;
    L11:
        th = move-exception;
        pw.close();     // Catch: Throwable -> L22
    L24:
        throw th;
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    private void printSessionList(IndentingPrintWriter pw, List<PackageInstaller.SessionInfo> stagedSessions, SessionDump sessionDump) {
        SparseArray<PackageInstaller.SessionInfo> sessionById = new SparseArray(stagedSessions.size());
        Iterator<PackageInstaller.SessionInfo> r1 = stagedSessions.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PackageInstaller.SessionInfo session = r1.next();
        sessionById.put(session.getSessionId(), session);
        goto L4
    L6:
        Iterator<PackageInstaller.SessionInfo> r2 = stagedSessions.iterator();
    L8:
        if (r2.hasNext() == false) goto L34;
        PackageInstaller.SessionInfo session2 = r2.next();
        if (sessionDump.onlyReady == false) goto L15;
        if (session2.isStagedSessionReady() == false) goto L8;
    L15:
        if (session2.getParentSessionId() != (-1)) goto L8;
        printSession(pw, session2, sessionDump);
        if (session2.isMultiPackage() == false) goto L8;
        if (sessionDump.onlyParent == true) goto L8;
        pw.increaseIndent();
        int[] childIds = session2.getChildSessionIds();
        int i = 0;
    L23:
        if (i >= childIds.length) goto L32;
        PackageInstaller.SessionInfo childSession = sessionById.get(childIds[i]);
        if (childSession == null) goto L27;
        printSession(pw, childSession, sessionDump);
    L31:
        i = i + 1;
        goto L23
    L27:
        if (sessionDump.onlySessionId == false) goto L29;
        pw.println(childIds[i]);
        goto L31
    L29:
        pw.println("sessionId = " + childIds[i] + "; not found");
        goto L31
    L32:
        pw.decreaseIndent();
        goto L8
    }

    private static void printSession(PrintWriter pw, PackageInstaller.SessionInfo session, SessionDump sessionDump) {
        if (sessionDump.onlySessionId == false) goto L6;
        pw.println(session.getSessionId());
        return;
    L6:
        pw.println("sessionId = " + session.getSessionId() + "; appPackageName = " + session.getAppPackageName() + "; isStaged = " + session.isStaged() + "; isReady = " + session.isStagedSessionReady() + "; isApplied = " + session.isStagedSessionApplied() + "; isFailed = " + session.isStagedSessionFailed() + "; errorMsg = " + session.getStagedSessionErrorMessage() + ";");
    }

    private Intent parseIntentAndUser() throws URISyntaxException {
        this.mTargetUser = -2;
        this.mBrief = false;
        this.mComponents = false;
        Intent intent = Intent.parseCommandArgs(this, new AnonymousClass3(this));
        this.mTargetUser = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), this.mTargetUser, false, false, null, null);
        return intent;
    }

    private void printResolveInfo(PrintWriterPrinter pr, String prefix, ResolveInfo ri, boolean brief, boolean components) {
        if (brief == true) goto L5;
        if (components == true) goto L5;
    L19:
        ri.dump(pr, prefix);
        return;
    L5:
        if (ri.activityInfo == null) goto L8;
        ComponentName comp = new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name);
    L14:
        if (comp == null) goto L19;
        if (components == true) goto L17;
        pr.println(prefix + "priority=" + ri.priority + " preferredOrder=" + ri.preferredOrder + " match=0x" + Integer.toHexString(ri.match) + " specificIndex=" + ri.specificIndex + " isDefault=" + ri.isDefault);
    L17:
        pr.println(prefix + comp.flattenToShortString());
        return;
    L8:
        if (ri.serviceInfo == null) goto L11;
        comp = new ComponentName(ri.serviceInfo.packageName, ri.serviceInfo.name);
        goto L14
    L11:
        if (ri.providerInfo == null) goto L13;
        comp = new ComponentName(ri.providerInfo.packageName, ri.providerInfo.name);
        goto L14
    L13:
        comp = null;
        goto L14
    }

    private int runResolveActivity() {
        Intent intent = parseIntentAndUser();     // Catch: URISyntaxException -> L14
        ResolveInfo ri = this.mInterface.resolveIntent(intent, intent.getType(), this.mQueryFlags, this.mTargetUser);     // Catch: RemoteException -> L7
        PrintWriter pw = getOutPrintWriter();     // Catch: RemoteException -> L7
        if (ri != null) goto L9;
        pw.println("No activity found");     // Catch: RemoteException -> L7
        return 0;
    L9:
        PrintWriterPrinter pr = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L7
        printResolveInfo(pr, "", ri, this.mBrief, this.mComponents);     // Catch: RemoteException -> L7
        return 0;
    L7:
        e = move-exception;
        throw new RuntimeException("Failed calling service", e);
    L14:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    private int runQueryIntentActivities() {
        Intent intent = parseIntentAndUser();     // Catch: URISyntaxException -> L31
        List<ResolveInfo> result = this.mInterface.queryIntentActivities(intent, intent.getType(), this.mQueryFlags, this.mTargetUser).getList();     // Catch: RemoteException -> L17
        PrintWriter pw = getOutPrintWriter();     // Catch: RemoteException -> L17
        if (result == null) goto L24;
        if (result.size() <= 0) goto L24;
        if (this.mComponents == true) goto L20;
        pw.print(result.size());     // Catch: RemoteException -> L17
        pw.println(" activities found:");     // Catch: RemoteException -> L17
        PrintWriterPrinter pr = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L17
        int i = 0;
    L15:
        if (i >= result.size()) goto L41;
        pw.print("  Activity #");     // Catch: RemoteException -> L17
        pw.print(i);     // Catch: RemoteException -> L17
        pw.println(":");     // Catch: RemoteException -> L17
        printResolveInfo(pr, "    ", result.get(i), this.mBrief, this.mComponents);     // Catch: RemoteException -> L17
        i = i + 1;     // Catch: RemoteException -> L17
        goto L15
    L41:
        return 0;
    L20:
        PrintWriterPrinter pr2 = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L17
        int i2 = 0;
    L22:
        if (i2 >= result.size()) goto L42;
        printResolveInfo(pr2, "", result.get(i2), this.mBrief, this.mComponents);     // Catch: RemoteException -> L17
        i2 = i2 + 1;     // Catch: RemoteException -> L17
        goto L22
    L42:
        return 0;
    L24:
        pw.println("No activities found");     // Catch: RemoteException -> L17
        return 0;
    L17:
        e = e;
    L30:
        throw new RuntimeException("Failed calling service", e);
    L27:
        e = e;
    L31:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    private int runQueryIntentServices() {
        Intent intent = parseIntentAndUser();     // Catch: URISyntaxException -> L31
        List<ResolveInfo> result = this.mInterface.queryIntentServices(intent, intent.getType(), this.mQueryFlags, this.mTargetUser).getList();     // Catch: RemoteException -> L17
        PrintWriter pw = getOutPrintWriter();     // Catch: RemoteException -> L17
        if (result == null) goto L24;
        if (result.size() <= 0) goto L24;
        if (this.mComponents == true) goto L20;
        pw.print(result.size());     // Catch: RemoteException -> L17
        pw.println(" services found:");     // Catch: RemoteException -> L17
        PrintWriterPrinter pr = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L17
        int i = 0;
    L15:
        if (i >= result.size()) goto L41;
        pw.print("  Service #");     // Catch: RemoteException -> L17
        pw.print(i);     // Catch: RemoteException -> L17
        pw.println(":");     // Catch: RemoteException -> L17
        printResolveInfo(pr, "    ", result.get(i), this.mBrief, this.mComponents);     // Catch: RemoteException -> L17
        i = i + 1;     // Catch: RemoteException -> L17
        goto L15
    L41:
        return 0;
    L20:
        PrintWriterPrinter pr2 = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L17
        int i2 = 0;
    L22:
        if (i2 >= result.size()) goto L42;
        printResolveInfo(pr2, "", result.get(i2), this.mBrief, this.mComponents);     // Catch: RemoteException -> L17
        i2 = i2 + 1;     // Catch: RemoteException -> L17
        goto L22
    L42:
        return 0;
    L24:
        pw.println("No services found");     // Catch: RemoteException -> L17
        return 0;
    L17:
        e = e;
    L30:
        throw new RuntimeException("Failed calling service", e);
    L27:
        e = e;
    L31:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    private int runQueryIntentReceivers() {
        Intent intent = parseIntentAndUser();     // Catch: URISyntaxException -> L31
        List<ResolveInfo> result = this.mInterface.queryIntentReceivers(intent, intent.getType(), this.mQueryFlags, this.mTargetUser).getList();     // Catch: RemoteException -> L17
        PrintWriter pw = getOutPrintWriter();     // Catch: RemoteException -> L17
        if (result == null) goto L24;
        if (result.size() <= 0) goto L24;
        if (this.mComponents == true) goto L20;
        pw.print(result.size());     // Catch: RemoteException -> L17
        pw.println(" receivers found:");     // Catch: RemoteException -> L17
        PrintWriterPrinter pr = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L17
        int i = 0;
    L15:
        if (i >= result.size()) goto L41;
        pw.print("  Receiver #");     // Catch: RemoteException -> L17
        pw.print(i);     // Catch: RemoteException -> L17
        pw.println(":");     // Catch: RemoteException -> L17
        printResolveInfo(pr, "    ", result.get(i), this.mBrief, this.mComponents);     // Catch: RemoteException -> L17
        i = i + 1;     // Catch: RemoteException -> L17
        goto L15
    L41:
        return 0;
    L20:
        PrintWriterPrinter pr2 = new PrintWriterPrinter(pw);     // Catch: RemoteException -> L17
        int i2 = 0;
    L22:
        if (i2 >= result.size()) goto L42;
        printResolveInfo(pr2, "", result.get(i2), this.mBrief, this.mComponents);     // Catch: RemoteException -> L17
        i2 = i2 + 1;     // Catch: RemoteException -> L17
        goto L22
    L42:
        return 0;
    L24:
        pw.println("No receivers found");     // Catch: RemoteException -> L17
        return 0;
    L17:
        e = e;
    L30:
        throw new RuntimeException("Failed calling service", e);
    L27:
        e = e;
    L31:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    private int runStreamingInstall() throws RemoteException {
        InstallParams params = makeInstallParams(UNSUPPORTED_INSTALL_CMD_OPTS);
        if (params.sessionParams.dataLoaderParams != null) goto L6;
        params.sessionParams.setDataLoaderParams(PackageManagerShellCommandDataLoader.getStreamingDataLoaderParams(this));
    L6:
        return doRunInstall(params);
    }

    private int runArchivedInstall() throws RemoteException {
        InstallParams params = makeInstallParams(UNSUPPORTED_INSTALL_CMD_OPTS);
        params.sessionParams.installFlags |= 134217728;
        if (params.sessionParams.dataLoaderParams != null) goto L6;
        params.sessionParams.setDataLoaderParams(PackageManagerShellCommandDataLoader.getStreamingDataLoaderParams(this));
    L6:
        return doRunInstall(params);
    }

    private int runIncrementalInstall() throws RemoteException {
        InstallParams params = makeInstallParams(UNSUPPORTED_INSTALL_CMD_OPTS);
        if (params.sessionParams.dataLoaderParams != null) goto L6;
        params.sessionParams.setDataLoaderParams(PackageManagerShellCommandDataLoader.getIncrementalDataLoaderParams(this));
    L6:
        return doRunInstall(params);
    }

    private int runInstall() throws RemoteException {
        return doRunInstall(makeInstallParams(UNSUPPORTED_INSTALL_CMD_OPTS));
    }

    private int doRunInstall(InstallParams params) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        if (SystemProperties.getBoolean("sys.boot_completed", false) == true) goto L6;
        pw.println("Error: device is still booting.");
        return 1;
    L6:
        int requestUserId = params.userId;
        if (requestUserId == (-1)) goto L15;
        if (requestUserId == (-2)) goto L15;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umi.getUserInfo(requestUserId);
        if (userInfo != null) goto L15;
        pw.println("Failure [user " + requestUserId + " doesn't exist]");
        return 1;
    L15:
        if (params.sessionParams.dataLoaderParams == null) goto L17;
        boolean r0 = true;
    L18:
        boolean isStreaming = r0;
        if ((params.sessionParams.installFlags & 131072) == 0) goto L21;
        boolean isApex = true;
    L23:
        if ((params.sessionParams.installFlags & 134217728) == 0) goto L25;
        boolean installArchived = true;
    L26:
        ArrayList<String> args = getRemainingArgs();
        if (args.isEmpty() == false) goto L29;
    L32:
        boolean r1 = true;
    L33:
        boolean fromStdIn = r1;
        if (args.size() <= 1) goto L36;
        boolean r2 = true;
    L37:
        boolean hasSplits = r2;
        if (fromStdIn == true) goto L40;
    L43:
        if (isApex == false) goto L47;
        if (hasSplits == false) goto L47;
        pw.println("Error: can't specify SPLIT(s) for APEX");
        return 1;
    L47:
        if (installArchived == false) goto L51;
        if (hasSplits == false) goto L51;
        pw.println("Error: can't have SPLIT(s) for Archival install");
        return 1;
    L51:
        if (isStreaming == true) goto L60;
        if (fromStdIn == false) goto L57;
        if (hasSplits == false) goto L57;
        pw.println("Error: can't specify SPLIT(s) along with STDIN");
        return 1;
    L57:
        if (args.isEmpty() == false) goto L59;
        args.add(STDIN_PATH);
        goto L60
    L59:
        setParamsSize(params, args);
    L60:
        int sessionId = doCreateSession(params.sessionParams, params.installerPackageName, params.userId);
        if (isStreaming == false) goto L72;
        if (doAddFiles(sessionId, args, params.sessionParams.sizeBytes, isApex, installArchived) == 0) goto L79;
        if (1 != 0) goto L109;
    L68:
        return 1;
    L109:
        doAbandonSession(sessionId, false);     // Catch: Exception -> L67
    L79:
        if (doCommitSession(sessionId, false) == 0) goto L87;
        if (1 != 0) goto L116;
    L84:
        return 1;
    L116:
        doAbandonSession(sessionId, false);     // Catch: Exception -> L83
        goto L84
    L87:
        if (params.sessionParams.isStaged == true) goto L89;
    L96:
        pw.println("Success");     // Catch: Throwable -> L69
        if (0 != 0) goto L107;
    L101:
        return 0;
    L107:
        doAbandonSession(sessionId, false);     // Catch: Exception -> L100
        goto L101
    L89:
        if (params.stagedReadyTimeoutMs <= 0) goto L96;
        int r4 = doWaitForStagedSessionReady(sessionId, params.stagedReadyTimeoutMs, pw);     // Catch: Throwable -> L69
        if (0 != 0) goto L118;
    L95:
        return r4;
    L118:
        doAbandonSession(sessionId, false);     // Catch: Exception -> L94
        goto L95
    L72:
        if (doWriteSplits(sessionId, args, params.sessionParams.sizeBytes, isApex) == 0) goto L79;
        if (1 != 0) goto L114;
    L77:
        return 1;
    L114:
        doAbandonSession(sessionId, false);     // Catch: Exception -> L76
    L69:
        th = move-exception;
        if (1 == 0) goto L120;
        doAbandonSession(sessionId, false);     // Catch: Exception -> L105
        throw th;
    L106:
        throw th;
    L120:
        throw th;
    L40:
        if (params.sessionParams.sizeBytes != (-1)) goto L43;
        pw.println("Error: must either specify a package size or an APK file");
        return 1;
    L36:
        r2 = false;
        goto L37
    L29:
        if (STDIN_PATH.equals(args.get(0)) == true) goto L32;
        r1 = false;
        goto L33
    L25:
        installArchived = false;
        goto L26
    L21:
        isApex = false;
        goto L23
    L17:
        r0 = false;
        goto L18
    }

    private int doWaitForStagedSessionReady(int sessionId, long timeoutMs, PrintWriter pw) throws RemoteException {
        boolean r7 = true;
        if (timeoutMs <= 0) goto L5;
        boolean r5 = true;
    L6:
        Preconditions.checkArgument(r5);
        PackageInstaller.SessionInfo si = this.mInterface.getPackageInstaller().getSessionInfo(sessionId);
        if (si != null) goto L11;
        pw.println("Failure [Unknown session " + sessionId + "]");
        return 1;
    L11:
        if (si.isStaged() == true) goto L14;
        pw.println("Failure [Session " + sessionId + " is not a staged session]");
        return 1;
    L14:
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + timeoutMs;
    L15:
        if (si == null) goto L25;
        if (currentTime >= endTime) goto L25;
        if (si.isStagedSessionReady() == true) goto L24;
        if (si.isStagedSessionFailed() == true) goto L22;
        SystemClock.sleep(Math.min(endTime - currentTime, 100));
        currentTime = System.currentTimeMillis();
        si = this.mInterface.getPackageInstaller().getSessionInfo(sessionId);
        r7 = r7;
        goto L15
    L22:
        int r16 = 0;
    L26:
        if (si != null) goto L30;
        pw.println("Failure [failed to retrieve SessionInfo]");
        return r7;
    L30:
        if (si.isStagedSessionReady() == true) goto L36;
        if (si.isStagedSessionFailed() == true) goto L36;
        pw.println("Failure [timed out after " + timeoutMs + " ms]");
        return r7;
    L36:
        if (si.isStagedSessionReady() == true) goto L39;
        pw.println("Error [" + si.getStagedSessionErrorCode() + "] [" + si.getStagedSessionErrorMessage() + "]");
        return r7;
    L39:
        pw.println("Success. Reboot device to apply staged session");
        return r16;
    L24:
        r16 = 0;
    L25:
        r16 = 0;
        goto L26
    L5:
        r5 = false;
        goto L6
    }

    private int runInstallAbandon() throws RemoteException {
        int sessionId = Integer.parseInt(getNextArg());
        return doAbandonSession(sessionId, true);
    }

    private int runInstallCommit() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        long stagedReadyTimeoutMs = 60000;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case -158482320: goto L9;
            default: goto L11;
        };
    L11:
        r5 = -1;
    L12:
        switch(r5) {
            case 0: goto L15;
            default: goto L14;
        };
    L15:
        stagedReadyTimeoutMs = Long.parseLong(getNextArgRequired());
        goto L3
    L14:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L9:
        if (opt.equals("--staged-ready-timeout") == false) goto L11;
    L16:
        int sessionId = Integer.parseInt(getNextArg());
        if (doCommitSession(sessionId, false) == 0) goto L20;
        return 1;
    L20:
        PackageInstaller.SessionInfo si = this.mInterface.getPackageInstaller().getSessionInfo(sessionId);
        if (si != null) goto L23;
    L28:
        pw.println("Success");
        return 0;
    L23:
        if (si.isStaged() == false) goto L28;
        if (stagedReadyTimeoutMs <= 0) goto L28;
        return doWaitForStagedSessionReady(sessionId, stagedReadyTimeoutMs, pw);
    }

    private int runInstallCreate() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        InstallParams installParams = makeInstallParams(UNSUPPORTED_SESSION_CREATE_OPTS);
        int sessionId = doCreateSession(installParams.sessionParams, installParams.installerPackageName, installParams.userId);
        pw.println("Success: created install session [" + sessionId + "]");
        return 0;
    }

    private int runInstallWrite() throws RemoteException {
        long sizeBytes = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("-S") == false) goto L9;
        sizeBytes = Long.parseLong(getNextArg());
        goto L3
    L9:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L10:
        int sessionId = Integer.parseInt(getNextArg());
        String splitName = getNextArg();
        String path = getNextArg();
        return doWriteSplit(sessionId, path, sizeBytes, splitName, true);
    }

    private int runInstallAddSession() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int parentSessionId = Integer.parseInt(getNextArg());
        IntArray otherSessionIds = new IntArray();
    L3:
        String opt = getNextArg();
        if (opt == null) goto L7;
        otherSessionIds.add(Integer.parseInt(opt));
        goto L3
    L7:
        if (otherSessionIds.size() != 0) goto L11;
        pw.println("Error: At least two sessions are required.");
        return 1;
    L11:
        return doInstallAddSession(parentSessionId, otherSessionIds.toArray(), true);
    }

    private int runInstallSetPreVerifiedDomains() throws RemoteException {
        getOutPrintWriter();
        int sessionId = Integer.parseInt(getNextArg());
        String preVerifiedDomainsStr = getNextArg();
        String[] preVerifiedDomains = preVerifiedDomainsStr.split(",");
        PackageInstaller.Session session = null;
        session = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L6
        session.setPreVerifiedDomains(new ArraySet(preVerifiedDomains));     // Catch: Throwable -> L6
        IoUtils.closeQuietly(session);
        return 0;
    L6:
        th = move-exception;
        IoUtils.closeQuietly(session);
        throw th;
    }

    private int runInstallGetPreVerifiedDomains() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int sessionId = Integer.parseInt(getNextArg());
        PackageInstaller.Session session = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L6
        Set<String> preVerifiedDomains = session.getPreVerifiedDomains();     // Catch: Throwable -> L6
        if (preVerifiedDomains.isEmpty() == false) goto L8;
        pw.println("The session doesn't have any pre-verified domains specified.");     // Catch: Throwable -> L6
    L9:
        IoUtils.closeQuietly(session);
        return 0;
    L8:
        pw.println(String.join(",", preVerifiedDomains));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        IoUtils.closeQuietly(null);
        throw th;
    }

    private int runInstallRemove() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int sessionId = Integer.parseInt(getNextArg());
        ArrayList<String> splitNames = getRemainingArgs();
        if (splitNames.isEmpty() == false) goto L7;
        pw.println("Error: split name not specified");
        return 1;
    L7:
        return doRemoveSplits(sessionId, splitNames, true);
    }

    private int runGetArchivedPackageMetadata() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        r5 = -1;
    L12:
        switch(r5) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L13:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L9:
        if (opt.equals("--user") == false) goto L11;
    L16:
        String packageName = getNextArg();
        if (packageName != null) goto L20;
        pw.println("Error: package name not specified");
        return 1;
    L20:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runGetArchivedPackageMetadata");
        Parcelable r7 = this.mInterface.getArchivedPackage(packageName, translatedUserId);     // Catch: Exception -> L25
        if (r7 != null) goto L27;
        pw.write("Package not found " + packageName);     // Catch: Exception -> L25
        return -1;
    L27:
        Parcel parcel = Parcel.obtain();     // Catch: Exception -> L25
        parcel.writeParcelable(r7, 0);     // Catch: Throwable -> L31
        byte[] bytes = parcel.marshall();     // Catch: Throwable -> L31
        parcel.recycle();     // Catch: Exception -> L25
        String encoded = HexEncoding.encodeToString(bytes);     // Catch: Exception -> L25
        pw.write(encoded);     // Catch: Exception -> L25
        return 0;
    L31:
        th = move-exception;
        parcel.recycle();     // Catch: Exception -> L25
        throw th;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        getErrPrintWriter().println("Failed to get archived package, reason: " + e);
        pw.println("Failure [failed to get archived package], reason: " + e);
        return -1;
    }

    protected static String getFormattedBytes(long size) {
        double k = size / 1024.0d;
        double m = size / 1048576.0d;
        double g = size / 1.073741824E9d;
        DecimalFormat dec = new DecimalFormat("0.00");
        if (g <= 1.0d) goto L7;
        return dec.format(g).concat(" Gb");
    L7:
        if (m <= 1.0d) goto L11;
        return dec.format(m).concat(" Mb");
    L11:
        if (k > 1.0d) goto L13;
        return "";
    L13:
        return dec.format(k).concat(" Kb");
    }

    private String getDataSizeDisplay(long size) {
        String formattedOutput = getFormattedBytes(size);
        if (formattedOutput.isEmpty() == true) goto L6;
        formattedOutput = " (" + formattedOutput + ")";
    L6:
        return Long.toString(size) + " bytes" + formattedOutput;
    }

    private int runGetPackageStorageStats() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r4 = -1;
        if (opt == null) goto L15;
        switch(opt.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        switch(r4) {
            case 0: goto L14;
            default: goto L12;
        };
    L14:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L12:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L9:
        if (opt.equals("--user") == false) goto L11;
        r4 = 0;
        goto L11
    L15:
        String packageName = getNextArg();
        if (packageName != null) goto L24;
        pw.println("Error: package name not specified");
        return 1;
    L24:
        StorageStatsManager storageStatsManager = (StorageStatsManager) this.mContext.getSystemService(StorageStatsManager.class);     // Catch: Exception -> L21
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runGetPackageStorageStats");     // Catch: Exception -> L21
        StorageStats stats = storageStatsManager.queryStatsForPackage(StorageManager.UUID_DEFAULT, packageName, UserHandle.of(translatedUserId));     // Catch: Exception -> L21
        pw.println("code: " + getDataSizeDisplay(stats.getAppBytes()));     // Catch: Exception -> L21
        pw.println("data: " + getDataSizeDisplay(stats.getDataBytes()));     // Catch: Exception -> L21
        pw.println("cache: " + getDataSizeDisplay(stats.getCacheBytes()));     // Catch: Exception -> L21
        pw.println("apk: " + getDataSizeDisplay(stats.getAppBytesByDataType(3)));     // Catch: Exception -> L21
        pw.println("lib: " + getDataSizeDisplay(stats.getAppBytesByDataType(5)));     // Catch: Exception -> L21
        pw.println("dm: " + getDataSizeDisplay(stats.getAppBytesByDataType(4)));     // Catch: Exception -> L21
        pw.println("dexopt artifacts: " + getDataSizeDisplay(stats.getAppBytesByDataType(0)));     // Catch: Exception -> L21
        pw.println("current profile : " + getDataSizeDisplay(stats.getAppBytesByDataType(2)));     // Catch: Exception -> L21
        pw.println("reference profile: " + getDataSizeDisplay(stats.getAppBytesByDataType(1)));     // Catch: Exception -> L21
        pw.println("external cache: " + getDataSizeDisplay(stats.getExternalCacheBytes()));     // Catch: Exception -> L21
        return 0;
    L21:
        e = move-exception;
        getErrPrintWriter().println("Failed to get storage stats, reason: " + e);
        pw.println("Failure [failed to get storage stats], reason: " + e);
        return -1;
    }

    private int runInstallExisting() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int installFlags = 4194304;
        boolean waitTillComplete = false;
        int installFlags2 = -2;
    L3:
        String opt = getNextOption();
        byte r12 = 0;
        if (opt == null) goto L36;
        switch(opt.hashCode()) {
            case -951415743: goto L24;
            case 1051781117: goto L21;
            case 1333024815: goto L18;
            case 1333469547: goto L15;
            case 1333511957: goto L12;
            case 1494514835: goto L9;
            default: goto L26;
        };
    L26:
        r12 = -1;
    L27:
        switch(r12) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            default: goto L28;
        };
    L28:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L31:
        waitTillComplete = true;
        goto L3
    L32:
        installFlags = (installFlags & (-2049)) | 16384;
        goto L3
    L33:
        installFlags = (installFlags | 2048) & (-16385);
        goto L3
    L34:
        int userId = UserHandle.parseUserArg(getNextArgRequired());
        installFlags2 = userId;
        goto L3
    L30:
        installFlags = (-4194305) & installFlags;
        goto L3
    L9:
        if (opt.equals("--restrict-permissions") == false) goto L26;
        r12 = 5;
        goto L27
    L12:
        if (opt.equals("--wait") == false) goto L26;
        r12 = 4;
        goto L27
    L15:
        if (opt.equals("--user") == false) goto L26;
    L18:
        if (opt.equals("--full") == false) goto L26;
        r12 = 3;
        goto L27
    L21:
        if (opt.equals("--ephemeral") == false) goto L26;
        r12 = 1;
        goto L27
    L24:
        if (opt.equals("--instant") == false) goto L26;
        r12 = 2;
        goto L27
    L36:
        String packageName = getNextArg();
        if (packageName != null) goto L40;
        pw.println("Error: package name not specified");
        return 1;
    L40:
        int translatedUserId = translateUserId(installFlags2, ProcessList.INVALID_ADJ, "runInstallExisting");
        if (waitTillComplete == false) goto L50;
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);     // Catch: Throwable -> L47
        IPackageInstaller installer = this.mInterface.getPackageInstaller();     // Catch: Throwable -> L47
        pw.println("Installing package " + packageName + " for user: " + translatedUserId);     // Catch: Throwable -> L47
        installer.installExistingPackage(packageName, installFlags, 0, receiver.getIntentSender(), translatedUserId, null);     // Catch: Throwable -> L47
        Intent result = receiver.getResult();     // Catch: Throwable -> L47
        int status = result.getIntExtra("android.content.pm.extra.STATUS", 1);     // Catch: Throwable -> L47
        pw.println("Received intent for package install");     // Catch: Throwable -> L47
        if (status != 0) goto L46;
        return 0;
    L46:
        return 1;
    L50:
        int installReason = installFlags;
        int res = this.mInterface.installExistingPackageAsUser(packageName, translatedUserId, installReason, 0, null);     // Catch: Throwable -> L58
        if (res == (-3)) goto L57;
        pw.println("Package " + packageName + " installed for user: " + translatedUserId);     // Catch: Throwable -> L47 Throwable -> L47
        return 0;
    L57:
        throw new PackageManager.NameNotFoundException("Package " + packageName + " doesn't exist");     // Catch: Throwable -> L47 Throwable -> L47
    L58:
        e = e;
    L60:
        pw.println(e.toString());
        return 1;
    L47:
        e = e;
        goto L60
    }

    private int runSetInstallLocation() throws RemoteException {
        String arg = getNextArg();
        if (arg != null) goto L16;
        getErrPrintWriter().println("Error: no install location specified.");
        return 1;
    L16:
        int loc = Integer.parseInt(arg);     // Catch: NumberFormatException -> L13
        if (this.mInterface.setInstallLocation(loc) == true) goto L11;
        getErrPrintWriter().println("Error: install location has to be a number.");
        return 1;
    L11:
        return 0;
    L14:
        getErrPrintWriter().println("Error: install location has to be a number.");
        return 1;
    }

    private int runGetInstallLocation() throws RemoteException {
        int loc = this.mInterface.getInstallLocation();
        String locStr = "invalid";
        if (loc != 0) goto L6;
        locStr = UiModeManagerService.Shell.NIGHT_MODE_STR_AUTO;
    L11:
        getOutPrintWriter().println(loc + "[" + locStr + "]");
        return 0;
    L6:
        if (loc != 1) goto L9;
        locStr = "internal";
        goto L11
    L9:
        if (loc != 2) goto L11;
        locStr = "external";
        goto L11
    }

    public int runMovePackage() throws RemoteException {
        String packageName = getNextArg();
        if (packageName != null) goto L6;
        getErrPrintWriter().println("Error: package name not specified");
        return 1;
    L6:
        String volumeUuid = getNextArg();
        if ("internal".equals(volumeUuid) == false) goto L9;
        volumeUuid = null;
    L9:
        int moveId = this.mInterface.movePackage(packageName, volumeUuid);
        int status = this.mInterface.getMoveStatus(moveId);
    L11:
        if (PackageManager.isMoveStatusFinished(status) == true) goto L14;
        SystemClock.sleep(1000);
        status = this.mInterface.getMoveStatus(moveId);
        goto L11
    L14:
        if (status != (-100)) goto L17;
        getOutPrintWriter().println("Success");
        return 0;
    L17:
        getErrPrintWriter().println("Failure [" + status + "]");
        return 1;
    }

    public int runMovePrimaryStorage() throws RemoteException {
        String volumeUuid = getNextArg();
        if ("internal".equals(volumeUuid) == false) goto L5;
        volumeUuid = null;
    L5:
        int moveId = this.mInterface.movePrimaryStorage(volumeUuid);
        int status = this.mInterface.getMoveStatus(moveId);
    L7:
        if (PackageManager.isMoveStatusFinished(status) == true) goto L10;
        SystemClock.sleep(1000);
        status = this.mInterface.getMoveStatus(moveId);
        goto L7
    L10:
        if (status != (-100)) goto L13;
        getOutPrintWriter().println("Success");
        return 0;
    L13:
        getErrPrintWriter().println("Failure [" + status + "]");
        return 1;
    }

    private ArrayList<String> getRemainingArgs() {
        ArrayList<String> args = new ArrayList();
    L3:
        String arg = getNextArg();
        if (arg == null) goto L6;
        args.add(arg);
        goto L3
    L6:
        return args;
    }

    private int runUninstall() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        if (SystemProperties.getBoolean("sys.boot_completed", false) == true) goto L6;
        pw.println("Error: device is still booting.");
        return 1;
    L6:
        int flags = 0;
        int userId = -1;
        long versionCode = -1;
    L7:
        String opt = getNextOption();
        if (opt == null) goto L37;
        switch(opt.hashCode()) {
            case 1502: goto L19;
            case 1333469547: goto L16;
            case 1884113221: goto L13;
            default: goto L21;
        };
    L21:
        byte r6 = -1;
    L22:
        switch(r6) {
            case 0: goto L35;
            case 1: goto L26;
            case 2: goto L25;
            default: goto L23;
        };
    L23:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L26:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId == (-1)) goto L7;
        if (userId == (-2)) goto L7;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umi.getUserInfo(userId);
        if (userInfo != null) goto L7;
        pw.println("Failure [user " + userId + " doesn't exist]");
        return 1;
    L35:
        flags = flags | 1;
        goto L7
    L25:
        long versionCode2 = Long.parseLong(getNextArgRequired());
        versionCode = versionCode2;
        goto L7
    L13:
        if (opt.equals("--versionCode") == false) goto L91;
        r6 = 2;
        goto L22
    L91:
        r6 = -1;
        goto L22
    L16:
        if (opt.equals("--user") == false) goto L92;
        r6 = 1;
        goto L22
    L92:
        r6 = -1;
        goto L22
    L19:
        if (opt.equals("-k") == false) goto L93;
        r6 = 0;
        goto L22
    L93:
        r6 = -1;
        goto L22
    L37:
        String packageName = getNextArg();
        if (packageName != null) goto L42;
        pw.println("Error: package name not specified");
        return 1;
    L42:
        if (RemovableSystemAppHelper.isRemovableSysApp(packageName) == false) goto L46;
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (amInternal == null) goto L46;
        userId = amInternal.getCurrentUserId();
    L46:
        int userId2 = ObricPackageManager.adjustUserId(packageName, userId);
        ArrayList<String> splitNames = getRemainingArgs();
        if (splitNames.isEmpty() == false) goto L49;
        if (userId2 != (-1)) goto L52;
        int flags2 = flags | 2;
    L53:
        int translatedUserId = translateUserId(userId2, 0, "runUninstall");
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);
        PackageManagerInternal internal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (internal.isApexPackage(packageName) == false) goto L57;
        internal.uninstallApex(packageName, versionCode, translatedUserId, receiver.getIntentSender(), flags2);
        int r22 = 0;
        int r21 = 1;
        String r3 = "]";
    L71:
        Intent result = receiver.getResult();
        int status = result.getIntExtra("android.content.pm.extra.STATUS", r21);
        if (status != 0) goto L75;
        pw.println("Success");
        return r22;
    L75:
        pw.println("Failure [" + result.getStringExtra("android.content.pm.extra.STATUS_MESSAGE") + r3);
        return 1;
    L57:
        if ((flags2 & 2) != 0) goto L68;
        r22 = 0;
        r21 = 1;
        PackageInfo info = this.mInterface.getPackageInfo(packageName, 67108864, translatedUserId);
        if (info != null) goto L63;
        pw.println("Failure [not installed for " + translatedUserId + "]");
        return 1;
    L63:
        if ((info.applicationInfo.flags & 1) == 0) goto L65;
        boolean isSystem = true;
    L66:
        if (isSystem == false) goto L69;
        int flags3 = flags2 | 4;
    L70:
        r3 = "]";
        this.mInterface.getPackageInstaller().uninstall(new VersionedPackage(packageName, versionCode), null, flags3, receiver.getIntentSender(), translatedUserId);
    L69:
        flags3 = flags2;
        goto L70
    L65:
        isSystem = false;
        goto L66
    L68:
        r22 = 0;
        r21 = 1;
        goto L69
    L52:
        flags2 = flags;
        goto L53
    L49:
        return runRemoveSplits(packageName, splitNames);
    }

    private int runRemoveSplits(String packageName, Collection<String> splitNames) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(2);
        sessionParams.installFlags = 2 | sessionParams.installFlags;
        sessionParams.appPackageName = packageName;
        int sessionId = doCreateSession(sessionParams, null, -1);
        boolean abandonSession = true;
    L25:
        th = move-exception;
        if (abandonSession == true) goto L39;
    L30:
        throw th;
    L39:
        doAbandonSession(sessionId, false);     // Catch: RuntimeException -> L29
        goto L30
    L5:
        if (doRemoveSplits(sessionId, splitNames, false) == 0) goto L12;
        if (1 != 0) goto L33;
    L10:
        return 1;
    L33:
        doAbandonSession(sessionId, false);     // Catch: RuntimeException -> L9
        goto L10
    L12:
        if (doCommitSession(sessionId, false) == 0) goto L18;
        if (1 != 0) goto L35;
    L17:
        return 1;
    L35:
        doAbandonSession(sessionId, false);     // Catch: RuntimeException -> L16
        goto L17
    L18:
        abandonSession = false;
        pw.println("Success");     // Catch: Throwable -> L25
        if (0 != 0) goto L31;
    L24:
        return 0;
    L31:
        doAbandonSession(sessionId, false);     // Catch: RuntimeException -> L23
        goto L24
    }

    private int runClear() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = 0;
        boolean cacheOnly = false;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L21;
        switch(opt.hashCode()) {
            case -2056884041: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r5 = -1;
    L15:
        switch(r5) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L19:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L18:
        cacheOnly = true;
        goto L3
    L9:
        if (opt.equals("--user") == false) goto L14;
    L12:
        if (opt.equals("--cache-only") == false) goto L14;
        r5 = 1;
        goto L15
    L21:
        String pkg = getNextArg();
        if (pkg != null) goto L25;
        getErrPrintWriter().println("Error: no package specified");
        return 1;
    L25:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runClear");
        ClearDataObserver obs = new ClearDataObserver();
        if (cacheOnly == true) goto L28;
        ActivityManager.getService().clearApplicationUserData(pkg, false, obs, translatedUserId);
    L29:
        monitor-enter(obs);
    L47:
    L34:
        th = move-exception;
        throw th;
    L31:
        if (obs.finished == true) goto L38;
        obs.wait();     // Catch: Throwable -> L34 InterruptedException -> L36
        goto L47
    L38:
        monitor-exit(obs);     // Catch: Throwable -> L34
        if (obs.result == false) goto L43;
        getOutPrintWriter().println("Success");
        return 0;
    L43:
        getErrPrintWriter().println("Failed");
        return 1;
    L28:
        this.mInterface.deleteApplicationCacheFilesAsUser(pkg, translatedUserId, obs);
        goto L29
    }

    private static String enabledSettingToString(int state) {
        switch(state) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "disabled-until-used";
    L7:
        return "disabled-user";
    L9:
        return ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L11:
        return ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L13:
        return "default";
    }

    private int runSetEnabledSetting(int state) throws RemoteException {
        int userId = 0;
        String option = getNextOption();
        if (option != null) goto L5;
    L7:
        String pkg = getNextArg();
        if (pkg != null) goto L11;
        getErrPrintWriter().println("Error: no package or component specified");
        return 1;
    L11:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSetEnabledSetting");
        ComponentName cn = ComponentName.unflattenFromString(pkg);
        if (cn != null) goto L15;
        this.mInterface.setApplicationEnabledSetting(pkg, state, 0, translatedUserId, "shell:" + Process.myUid());
        getOutPrintWriter().println("Package " + pkg + " new state: " + enabledSettingToString(this.mInterface.getApplicationEnabledSetting(pkg, translatedUserId)));
        return 0;
    L15:
        this.mInterface.setComponentEnabledSetting(cn, state, 0, translatedUserId, DisassociationProcessor.REASON_SHELL);
        getOutPrintWriter().println("Component " + cn.toShortString() + " new state: " + enabledSettingToString(this.mInterface.getComponentEnabledSetting(cn, translatedUserId)));
        return 0;
    L5:
        if (option.equals("--user") == false) goto L7;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L7
    }

    private int runSetHiddenSetting(boolean state) throws RemoteException {
        int userId = 0;
        String option = getNextOption();
        if (option != null) goto L5;
    L7:
        String pkg = getNextArg();
        if (pkg != null) goto L11;
        getErrPrintWriter().println("Error: no package or component specified");
        return 1;
    L11:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSetHiddenSetting");
        this.mInterface.setApplicationHiddenSettingAsUser(pkg, state, translatedUserId);
        getOutPrintWriter().println("Package " + pkg + " new hidden state: " + this.mInterface.getApplicationHiddenSettingAsUser(pkg, translatedUserId));
        return 0;
    L5:
        if (option.equals("--user") == false) goto L7;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L7
    }

    private int runSetStoppedState(boolean state) throws RemoteException {
        int userId = 0;
        String option = getNextOption();
        if (option != null) goto L5;
    L7:
        String pkg = getNextArg();
        if (pkg != null) goto L11;
        getErrPrintWriter().println("Error: no package specified");
        return 1;
    L11:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSetStoppedState");
        this.mInterface.setPackageStoppedState(pkg, state, translatedUserId);
        getOutPrintWriter().println("Package " + pkg + " new stopped state: " + this.mInterface.isPackageStoppedForUser(pkg, translatedUserId));
        return 0;
    L5:
        if (option.equals("--user") == false) goto L7;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L7
    }

    private int runSetDistractingRestriction() {
        PrintWriter pw = getOutPrintWriter();
        int userId = 0;
        int flags = 0;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L36;
        switch(opt.hashCode()) {
            case 1333015820: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        byte r3 = -1;
    L15:
        switch(r3) {
            case 0: goto L34;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L34:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L18:
        String flag = getNextArgRequired();
        switch(flag.hashCode()) {
            case -2125559907: goto L25;
            case -1852537225: goto L22;
            default: goto L27;
        };
    L27:
        r5 = -1;
    L28:
        switch(r5) {
            case 0: goto L32;
            case 1: goto L31;
            default: goto L29;
        };
    L29:
        pw.println("Unrecognized flag: " + flag);
        return 1;
    L32:
        flags = flags | 2;
        goto L3
    L31:
        flags = flags | 1;
        goto L3
    L22:
        if (flag.equals("hide-from-suggestions") == false) goto L62;
        r5 = 1;
        goto L28
    L62:
        r5 = -1;
        goto L28
    L25:
        if (flag.equals("hide-notifications") == true) goto L28;
        r5 = -1;
        goto L28
    L9:
        if (opt.equals("--user") == false) goto L64;
        r3 = 0;
        goto L15
    L64:
        r3 = -1;
        goto L15
    L12:
        if (opt.equals("--flag") == false) goto L65;
        r3 = 1;
        goto L15
    L65:
        r3 = -1;
        goto L15
    L36:
        List<String> packageNames = getRemainingArgs();
        if (packageNames.isEmpty() == false) goto L49;
        pw.println("Error: package name not specified");
        return 1;
    L49:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "set-distracting");     // Catch: Throwable -> L44
        String[] errored = this.mInterface.setDistractingPackageRestrictionsAsUser((String[]) packageNames.toArray(new String[0]), flags, translatedUserId);     // Catch: Throwable -> L44
        if (errored.length <= 0) goto L46;
        pw.println("Could not set restriction for: " + Arrays.toString(errored));     // Catch: Throwable -> L44
        return 1;
    L46:
        return 0;
    L44:
        e = move-exception;
        pw.println(e.toString());
        return 1;
    }

    private int runGetDistractingRestriction() {
        PrintWriter pw = getOutPrintWriter();
        int userId = 0;
    L3:
        String opt = getNextOption();
        byte r4 = -1;
        if (opt == null) goto L15;
        switch(opt.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        switch(r4) {
            case 0: goto L14;
            default: goto L12;
        };
    L14:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L12:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L9:
        if (opt.equals("--user") == false) goto L11;
        r4 = 0;
        goto L11
    L15:
        List<String> packageNames = getRemainingArgs();
        if (packageNames.isEmpty() == false) goto L19;
        pw.println("Error: package name not specified");
        return 1;
    L19:
        pw.println("Distracting restrictions state for user " + userId);
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "get-distracting");
        String[] packages = (String[]) packageNames.toArray(new String[0]);
        int[] res = this.mPm.getDistractingPackageRestrictionsAsUser(packages, translatedUserId);
        int i = 0;
    L21:
        if (i >= res.length) goto L28;
        int state = res[i];
        if (state != (-1)) goto L25;
        pw.println(packages[i] + " not found ...");
    L26:
        i = i + 1;
        goto L21
    L25:
        pw.println(packages[i] + "  state: " + stateToString(state));
        goto L26
    L28:
        return 0;
    }

    private static String stateToString(int flag) {
        switch(flag) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "HIDE_NOTIFICATIONS";
    L7:
        return "HIDE_FROM_SUGGESTIONS";
    L9:
        return "NONE";
    }

    private int runSuspend(boolean suspendedState, int flags) {
        PrintWriter pw = getOutPrintWriter();
        PersistableBundle appExtras = new PersistableBundle();
        PersistableBundle launcherExtras = new PersistableBundle();
        String dialogMessage = null;
        int userId = 0;
    L3:
        String opt = getNextOption();
        byte r8 = 0;
        if (opt == null) goto L53;
        switch(opt.hashCode()) {
            case -39471105: goto L30;
            case 42995488: goto L27;
            case 42995496: goto L24;
            case 42995503: goto L21;
            case 43006059: goto L18;
            case 43006067: goto L15;
            case 43006074: goto L12;
            case 1333469547: goto L9;
            default: goto L32;
        };
    L32:
        r8 = -1;
    L33:
        switch(r8) {
            case 0: goto L51;
            case 1: goto L50;
            case 2: goto L36;
            case 3: goto L36;
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L36;
            default: goto L34;
        };
    L34:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L50:
        String dialogMessage2 = getNextArgRequired();
        dialogMessage = dialogMessage2;
        goto L3
    L51:
        String dialogMessage3 = getNextArgRequired();
        int userId2 = UserHandle.parseUserArg(dialogMessage3);
        userId = userId2;
        goto L3
    L36:
        String key = getNextArgRequired();
        String val = getNextArgRequired();
        if (suspendedState == false) goto L3;
        if (opt.startsWith("--a") == false) goto L42;
        PersistableBundle bundleToInsert = appExtras;
    L44:
        switch(opt.charAt(4)) {
            case 100: goto L48;
            case 108: goto L47;
            case 115: goto L46;
            default: goto L3;
        };
    L46:
        bundleToInsert.putString(key, val);
        goto L3
    L47:
        bundleToInsert.putLong(key, Long.valueOf(val).longValue());
        goto L3
    L48:
        bundleToInsert.putDouble(key, Double.valueOf(val).doubleValue());
        goto L3
    L42:
        bundleToInsert = launcherExtras;
        goto L44
    L9:
        if (opt.equals("--user") == false) goto L32;
    L12:
        if (opt.equals("--les") == false) goto L32;
        r8 = 6;
        goto L33
    L15:
        if (opt.equals("--lel") == false) goto L32;
        r8 = 5;
        goto L33
    L18:
        if (opt.equals("--led") == false) goto L32;
        r8 = 7;
        goto L33
    L21:
        if (opt.equals("--aes") == false) goto L32;
        r8 = 3;
        goto L33
    L24:
        if (opt.equals("--ael") == false) goto L32;
        r8 = 2;
        goto L33
    L27:
        if (opt.equals("--aed") == false) goto L32;
        r8 = 4;
        goto L33
    L30:
        if (opt.equals("--dialogMessage") == false) goto L32;
        r8 = 1;
        goto L33
    L53:
        List<String> packageNames = getRemainingArgs();
        if (packageNames.isEmpty() == false) goto L58;
        pw.println("Error: package name not specified");
        return 1;
    L58:
        if (Binder.getCallingUid() != 0) goto L60;
        String r0 = "root";
    L61:
        String callingPackage = r0;
        if (TextUtils.isEmpty(dialogMessage) == true) goto L64;
        SuspendDialogInfo info = new SuspendDialogInfo.Builder().setMessage(dialogMessage).build();
    L84:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSuspend");     // Catch: Throwable -> L78
        IPackageManager r11 = this.mInterface;     // Catch: Throwable -> L78
        String[] r12 = (String[]) packageNames.toArray(new String[0]);     // Catch: Throwable -> L78
        if (appExtras.size() <= 0) goto L68;
        PersistableBundle r14 = appExtras;
    L70:
        if (launcherExtras.size() <= 0) goto L72;
        PersistableBundle r15 = launcherExtras;
    L73:
        r11.setPackagesSuspendedAsUser(r12, suspendedState, r14, r15, info, flags, callingPackage, 0, translatedUserId);     // Catch: Throwable -> L78
        int i = 0;
    L75:
        if (i >= packageNames.size()) goto L81;
        String packageName = packageNames.get(i);     // Catch: Throwable -> L78
        pw.println("Package " + packageName + " new suspended state: " + this.mInterface.isPackageSuspendedForUser(packageName, translatedUserId));     // Catch: Throwable -> L78
        i = i + 1;
        goto L75
    L81:
        return 0;
    L72:
        r15 = null;
        goto L73
    L68:
        r14 = null;
    L78:
        e = move-exception;
        pw.println(e.toString());
        return 1;
    L64:
        info = null;
        goto L84
    L60:
        r0 = "com.android.shell";
        goto L61
    }

    private int runGrantRevokePermission(boolean grant) throws RemoteException {
        PackageManagerShellCommand r1 = this;
        boolean allPermissions = false;
        int userId = 0;
    L3:
        String opt = r1.getNextOption();
        if (opt == null) goto L11;
        if (opt.equals("--user") == false) goto L9;
        userId = UserHandle.parseUserArg(r1.getNextArgRequired());
    L9:
        if (opt.equals("--all-permissions") == false) goto L3;
        allPermissions = true;
        goto L3
    L11:
        String pkg = r1.getNextArg();
        if (allPermissions == true) goto L16;
        if (pkg != null) goto L16;
        r1.getErrPrintWriter().println("Error: no package specified");
        return 1;
    L16:
        String perm = r1.getNextArg();
        if (allPermissions == true) goto L21;
        if (perm != null) goto L21;
        r1.getErrPrintWriter().println("Error: no permission specified");
        return 1;
    L21:
        if (allPermissions == false) goto L25;
        if (perm == null) goto L25;
        r1.getErrPrintWriter().println("Error: permission specified but not expected");
        return 1;
    L25:
        UserHandle translatedUser = UserHandle.of(r1.translateUserId(userId, ProcessList.INVALID_ADJ, "runGrantRevokePermission"));
        int r9 = 0;
        PackageManager pm = r1.mContext.createContextAsUser(translatedUser, 0).getPackageManager();
        if (pkg != null) goto L73;
        List<PackageInfo> packageInfos = pm.getInstalledPackages(4096);
    L30:
        Iterator<PackageInfo> r11 = packageInfos.iterator();
    L32:
        if (r11.hasNext() == false) goto L63;
        PackageInfo packageInfo = r11.next();
        List<String> permissions = Collections.singletonList(perm);
        if (allPermissions == false) goto L36;
        List<String> permissions2 = r1.getRequestedRuntimePermissions(packageInfo);
        List<String> permissions3 = permissions2;
    L37:
        Iterator<String> r14 = permissions3.iterator();
    L39:
        if (r14.hasNext() == false) goto L61;
        String permission = r14.next();
        int r16 = r9;
        int userId2 = userId;
        if (grant == true) goto L69;
        boolean allPermissions2 = allPermissions;
        r1.mPermissionManager.revokeRuntimePermission(packageInfo.packageName, permission, translatedUser, null);     // Catch: Exception -> L56
    L59:
        r1 = this;
        r9 = r16;
        userId = userId2;
        allPermissions = allPermissions2;
    L56:
        e = move-exception;
        if (allPermissions2 == false) goto L60;
        Slog.w(TAG, "Could not grant permission " + permission, e);
        goto L59
    L60:
        throw e;
    L69:
        allPermissions2 = allPermissions;
        r1.mPermissionManager.grantRuntimePermission(packageInfo.packageName, permission, translatedUser);     // Catch: Exception -> L46
    L46:
        e = e;
    L50:
        if (allPermissions2 == false) goto L52;
        Slog.w(TAG, "Could not grant permission " + permission, e);
        goto L59
    L52:
        throw e;
    L48:
        e = e;
        allPermissions2 = allPermissions;
        goto L50
    L61:
        r1 = this;
        goto L32
    L36:
        permissions3 = permissions;
        goto L37
    L63:
        return r9;
    L73:
        List<PackageInfo> packageInfos2 = Collections.singletonList(pm.getPackageInfo(pkg, 4096));     // Catch: PackageManager.NameNotFoundException -> L64
        packageInfos = packageInfos2;
    L65:
        getErrPrintWriter().println("Error: package not found");
        getOutPrintWriter().println("Failure [package not found]");
        return 1;
    }

    private List<String> getRequestedRuntimePermissions(PackageInfo info) {
        if (info.requestedPermissions == null) goto L5;
        List<String> result = new ArrayList();
        PackageManager pm = this.mContext.getPackageManager();
        String[] r2 = info.requestedPermissions;
        int r3 = r2.length;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L19;
        String permission = r2[r5];
        PermissionInfo pi = null;
        pi = pm.getPermissionInfo(permission, 0);     // Catch: PackageManager.NameNotFoundException -> L11
    L12:
        if (pi == null) goto L18;
        if (pi.getProtection() != 1) goto L18;
        result.add(permission);
    L18:
        r5 = r5 + 1;
        goto L7
    L19:
        return result;
    L5:
        return new ArrayList();
    }

    private int runResetPermissions() throws RemoteException {
        this.mLegacyPermissionManager.resetRuntimePermissions();
        return 0;
    }

    private int setOrClearPermissionFlags(boolean setFlags) {
        int userId = 0;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L8;
        if (opt.equals("--user") == false) goto L3;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        String pkg = getNextArg();
        if (pkg != null) goto L12;
        getErrPrintWriter().println("Error: no package specified");
        return 1;
    L12:
        String perm = getNextArg();
        if (perm != null) goto L16;
        getErrPrintWriter().println("Error: no permission specified");
        return 1;
    L16:
        String flagName = getNextArg();
        if (flagName != null) goto L20;
        getErrPrintWriter().println("Error: no permission flags specified");
        return 1;
    L20:
        String flagName2 = flagName;
        int flagMask = 0;
    L21:
        if (flagName2 == null) goto L27;
        if (SUPPORTED_PERMISSION_FLAGS.containsKey(flagName2) == false) goto L24;
        flagMask = flagMask | SUPPORTED_PERMISSION_FLAGS.get(flagName2).intValue();
        flagName2 = getNextArg();
        goto L21
    L24:
        getErrPrintWriter().println("Error: specified flag " + flagName2 + " is not one of " + SUPPORTED_PERMISSION_FLAGS_LIST);
        return 1;
    L27:
        UserHandle translatedUser = UserHandle.of(translateUserId(userId, ProcessList.INVALID_ADJ, "runGrantRevokePermission"));
        if (setFlags == false) goto L30;
        int flagSet = flagMask;
    L31:
        this.mPermissionManager.updatePermissionFlags(pkg, perm, flagMask, flagSet, translatedUser);
        return 0;
    L30:
        flagSet = 0;
        goto L31
    }

    private int runSetPermissionEnforced() throws RemoteException {
        String permission = getNextArg();
        if (permission != null) goto L6;
        getErrPrintWriter().println("Error: no permission specified");
        return 1;
    L6:
        String enforcedRaw = getNextArg();
        if (enforcedRaw != null) goto L10;
        getErrPrintWriter().println("Error: no enforcement specified");
        return 1;
    L10:
        return 0;
    }

    private boolean isVendorApp(String pkg) {
        PackageInfo info = this.mInterface.getPackageInfo(pkg, 4194304, 0);     // Catch: RemoteException -> L8
        if (info == null) goto L10;
        if (info.applicationInfo.isVendor() == false) goto L15;
        return true;
    L15:
        return false;
    L10:
        return false;
    L12:
        return false;
    }

    private boolean isProductApp(String pkg) {
        PackageInfo info = this.mInterface.getPackageInfo(pkg, 4194304, 0);     // Catch: RemoteException -> L8
        if (info == null) goto L10;
        if (info.applicationInfo.isProduct() == false) goto L15;
        return true;
    L15:
        return false;
    L10:
        return false;
    L12:
        return false;
    }

    private boolean isSystemExtApp(String pkg) {
        PackageInfo info = this.mInterface.getPackageInfo(pkg, 4194304, 0);     // Catch: RemoteException -> L8
        if (info == null) goto L10;
        if (info.applicationInfo.isSystemExt() == false) goto L15;
        return true;
    L15:
        return false;
    L10:
        return false;
    L12:
        return false;
    }

    private String getApexPackageNameContainingPackage(String pkg) {
        ApexManager apexManager = ApexManager.getInstance();
        return apexManager.getActiveApexPackageNameContainingPackage(pkg);
    }

    private boolean isApexApp(String pkg) {
        if (getApexPackageNameContainingPackage(pkg) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private int runGetPrivappPermissions() {
        String pkg = getNextArg();
        if (pkg != null) goto L6;
        getErrPrintWriter().println("Error: no package specified.");
        return 1;
    L6:
        getOutPrintWriter().println(getPrivAppPermissionsString(pkg, true));
        return 0;
    }

    private int runGetPrivappDenyPermissions() {
        String pkg = getNextArg();
        if (pkg != null) goto L6;
        getErrPrintWriter().println("Error: no package specified.");
        return 1;
    L6:
        getOutPrintWriter().println(getPrivAppPermissionsString(pkg, false));
        return 0;
    }

    private String getPrivAppPermissionsString(String packageName, boolean allowed) {
        PermissionAllowlist permissionAllowlist = SystemConfig.getInstance().getPermissionAllowlist();
        if (isVendorApp(packageName) == false) goto L6;
        ArrayMap<String, ArrayMap<String, Boolean>> privAppPermissions = permissionAllowlist.getVendorPrivilegedAppAllowlist();
    L15:
        if (privAppPermissions == null) goto L17;
        ArrayMap<String, Boolean> permissions = privAppPermissions.get(packageName);
    L18:
        if (permissions != null) goto L21;
        return "{}";
    L21:
        StringBuilder result = new StringBuilder("{");
        boolean isFirstPermission = true;
        int permissionsSize = permissions.size();
        int i = 0;
    L22:
        if (i >= permissionsSize) goto L31;
        boolean permissionAllowed = permissions.valueAt(i).booleanValue();
        if (permissionAllowed != allowed) goto L30;
        if (isFirstPermission == false) goto L28;
        isFirstPermission = false;
    L29:
        String permissionName = permissions.keyAt(i);
        result.append(permissionName);
        goto L30
    L28:
        result.append(", ");
    L30:
        i = i + 1;
        goto L22
    L31:
        result.append("}");
        return result.toString();
    L17:
        permissions = null;
        goto L18
    L6:
        if (isProductApp(packageName) == false) goto L9;
        privAppPermissions = permissionAllowlist.getProductPrivilegedAppAllowlist();
        goto L15
    L9:
        if (isSystemExtApp(packageName) == false) goto L12;
        privAppPermissions = permissionAllowlist.getSystemExtPrivilegedAppAllowlist();
        goto L15
    L12:
        if (isApexApp(packageName) == false) goto L14;
        String moduleName = ApexManager.getInstance().getApexModuleNameForPackageName(getApexPackageNameContainingPackage(packageName));
        privAppPermissions = permissionAllowlist.getApexPrivilegedAppAllowlists().get(moduleName);
        goto L15
    L14:
        privAppPermissions = permissionAllowlist.getPrivilegedAppAllowlist();
        goto L15
    }

    private int runGetOemPermissions() {
        String pkg = getNextArg();
        if (pkg != null) goto L6;
        getErrPrintWriter().println("Error: no package specified.");
        return 1;
    L6:
        Map<String, Boolean> oemPermissions = SystemConfig.getInstance().getPermissionAllowlist().getOemAppAllowlist().get(pkg);
        if (oemPermissions != null) goto L9;
    L12:
        getOutPrintWriter().println("{}");
        return 0;
    L9:
        if (oemPermissions.isEmpty() == true) goto L12;
        oemPermissions.forEach(new PackageManagerShellCommand$$ExternalSyntheticLambda0(this));
        return 0;
    }

    private /* synthetic */ void lambda$runGetOemPermissions$2(String permission, Boolean granted) {
        getOutPrintWriter().println(permission + " granted:" + granted);
    }

    private int runGetSignaturePermissionAllowlist() {
        String partition = getNextArg();
        if (partition != null) goto L6;
        getErrPrintWriter().println("Error: no partition specified.");
        return 1;
    L6:
        PermissionAllowlist permissionAllowlist = SystemConfig.getInstance().getPermissionAllowlist();
        switch(partition.hashCode()) {
            case -887328209: goto L22;
            case -820075192: goto L19;
            case -309474065: goto L16;
            case 3000610: goto L13;
            case 641712515: goto L10;
            default: goto L24;
        };
    L24:
        byte r3 = -1;
    L25:
        switch(r3) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        getErrPrintWriter().println("Error: unknown partition: " + partition);
        return 1;
    L28:
        ArrayMap<String, ArrayMap<String, Boolean>> allowlist = permissionAllowlist.getApexSignatureAppAllowlist();
    L33:
        IndentingPrintWriter ipw = new IndentingPrintWriter(getOutPrintWriter(), "  ");
        int allowlistSize = allowlist.size();
        int allowlistIndex = 0;
    L34:
        if (allowlistIndex >= allowlistSize) goto L43;
        String packageName = allowlist.keyAt(allowlistIndex);
        ArrayMap<String, Boolean> permissions = allowlist.valueAt(allowlistIndex);
        ipw.print("Package: ");
        ipw.println(packageName);
        ipw.increaseIndent();
        int permissionsSize = permissions.size();
        int permissionsIndex = 0;
    L36:
        if (permissionsIndex >= permissionsSize) goto L41;
        String permissionName = permissions.keyAt(permissionsIndex);
        Boolean granted = permissions.valueAt(permissionsIndex);
        if (granted.booleanValue() == false) goto L40;
        ipw.print("Permission: ");
        ipw.println(permissionName);
    L40:
        permissionsIndex = permissionsIndex + 1;
        goto L36
    L41:
        ipw.decreaseIndent();
        allowlistIndex = allowlistIndex + 1;
        goto L34
    L43:
        return 0;
    L29:
        allowlist = permissionAllowlist.getSystemExtSignatureAppAllowlist();
        goto L33
    L30:
        allowlist = permissionAllowlist.getProductSignatureAppAllowlist();
        goto L33
    L31:
        allowlist = permissionAllowlist.getVendorSignatureAppAllowlist();
        goto L33
    L32:
        allowlist = permissionAllowlist.getSignatureAppAllowlist();
        goto L33
    L10:
        if (partition.equals("system-ext") == false) goto L24;
        r3 = 3;
        goto L25
    L13:
        if (partition.equals("apex") == false) goto L24;
        r3 = 4;
        goto L25
    L16:
        if (partition.equals("product") == false) goto L24;
        r3 = 2;
        goto L25
    L19:
        if (partition.equals("vendor") == false) goto L24;
        r3 = 1;
        goto L25
    L22:
        if (partition.equals("system") == false) goto L24;
        r3 = 0;
        goto L25
    }

    private int runGetSharedUidAllowlist() {
        ArrayMap<String, String> allowlist = SystemConfig.getInstance().getPackageToSharedUidAllowList();
        PrintWriter pw = getOutPrintWriter();
        int allowlistSize = allowlist.size();
        int allowlistIndex = 0;
    L3:
        if (allowlistIndex >= allowlistSize) goto L5;
        String packageName = allowlist.keyAt(allowlistIndex);
        String sharedUserName = allowlist.valueAt(allowlistIndex);
        pw.print(packageName);
        pw.print(" ");
        pw.println(sharedUserName);
        allowlistIndex = allowlistIndex + 1;
        goto L3
    L5:
        return 0;
    }

    private int runTrimCaches() throws RemoteException {
        String size = getNextArg();
        if (size != null) goto L6;
        getErrPrintWriter().println("Error: no size specified");
        return 1;
    L6:
        int len = size.length();
        char c = size.charAt(len - 1);
        if (c < '0') goto L13;
        if (c > '9') goto L13;
        long multiplier = 1;
        String size2 = size;
    L55:
        long sizeVal = Long.parseLong(size2) * multiplier;
        String volumeUuid = getNextArg();
        if ("internal".equals(volumeUuid) == false) goto L37;
        String volumeUuid2 = null;
    L38:
        ClearDataObserver obs = new ClearDataObserver();
        this.mInterface.freeStorageAndNotify(volumeUuid2, sizeVal, 2, obs);
        monitor-enter(obs);
    L59:
    L44:
        th = move-exception;
        throw th;
    L41:
        if (obs.finished == true) goto L48;
        obs.wait();     // Catch: Throwable -> L44 InterruptedException -> L46
        goto L59
    L48:
        monitor-exit(obs);     // Catch: Throwable -> L44
        return 0;
    L37:
        volumeUuid2 = volumeUuid;
    L53:
        getErrPrintWriter().println("Error: expected number at: " + size2);
        return 1;
    L13:
        if (c != 'K') goto L15;
    L31:
        long multiplier2 = DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
    L32:
        multiplier = multiplier2;
        size2 = size.substring(0, len - 1);
        goto L55
    L15:
        if (c == 'k') goto L31;
        if (c != 'M') goto L20;
    L30:
        multiplier2 = DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES;
        goto L32
    L20:
        if (c == 'm') goto L30;
        if (c != 'G') goto L25;
    L29:
        multiplier2 = 1073741824;
        goto L32
    L25:
        if (c == 'g') goto L29;
        getErrPrintWriter().println("Invalid suffix: " + c);
        return 1;
    }

    private static boolean isNumber(String s) {
        Integer.parseInt(s);     // Catch: NumberFormatException -> L5
        return true;
    L6:
        return false;
    }

    public int runCreateUser() throws RemoteException {
        String userType = null;
        boolean preCreateOnly = false;
        int userId = -1;
        int flags = 0;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L42;
        String newUserType = null;
        if ("--profileOf".equals(opt) == false) goto L8;
        PackageManagerShellCommand r11 = this;
        userId = r11.translateUserId(UserHandle.parseUserArg(getNextArgRequired()), -1, "runCreateUser");
    L32:
        if (newUserType == null) goto L3;
        if (userType != null) goto L35;
    L38:
        userType = newUserType;
        goto L3
    L35:
        if (userType.equals(newUserType) == true) goto L38;
        r11.getErrPrintWriter().println("Error: more than one user type was specified (" + userType + " and " + newUserType + ")");
        return 1;
    L8:
        r11 = this;
        if ("--managed".equals(opt) == false) goto L12;
        newUserType = "android.os.usertype.profile.MANAGED";
        goto L32
    L12:
        if ("--restricted".equals(opt) == false) goto L15;
        newUserType = "android.os.usertype.full.RESTRICTED";
        goto L32
    L15:
        if ("--guest".equals(opt) == false) goto L18;
        newUserType = "android.os.usertype.full.GUEST";
        goto L32
    L18:
        if ("--demo".equals(opt) == false) goto L21;
        newUserType = "android.os.usertype.full.DEMO";
        goto L32
    L21:
        if ("--ephemeral".equals(opt) == false) goto L24;
        flags = flags | 256;
        goto L32
    L24:
        if ("--for-testing".equals(opt) == false) goto L27;
        flags = 32768 | flags;
        goto L32
    L27:
        if ("--pre-create-only".equals(opt) == false) goto L30;
        preCreateOnly = true;
        goto L32
    L30:
        if ("--user-type".equals(opt) == false) goto L40;
        newUserType = r11.getNextArgRequired();
        goto L32
    L40:
        r11.getErrPrintWriter().println("Error: unknown option " + opt);
        return 1;
    L42:
        String arg = getNextArg();
        if (arg != null) goto L47;
        if (preCreateOnly == true) goto L47;
        getErrPrintWriter().println("Error: no user name specified.");
        return 1;
    L47:
        if (arg == null) goto L50;
        if (preCreateOnly == false) goto L50;
        getErrPrintWriter().println("Warning: name is ignored for pre-created users");
    L50:
        UserInfo info = null;
        IUserManager um = IUserManager.Stub.asInterface(ServiceManager.getService("user"));
        IAccountManager accm = IAccountManager.Stub.asInterface(ServiceManager.getService("account"));
        if (userType != null) goto L53;
        String userType2 = UserInfo.getDefaultUserType(flags);
        String userType3 = userType2;
    L54:
        Trace.traceBegin(262144, "shell_runCreateUser");
    L65:
        e = move-exception;
        PrintWriter r9 = getErrPrintWriter();     // Catch: Throwable -> L63
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L63
        long r17 = 262144;
        r2.append("Error: ");     // Catch: Throwable -> L87
        r2.append(e);     // Catch: Throwable -> L87
        r9.println(r2.toString());     // Catch: Throwable -> L87
        Trace.traceEnd(262144);
    L82:
        if (info == null) goto L85;
        getOutPrintWriter().println("Success: created user id " + info.id);
        return 0;
    L85:
        getErrPrintWriter().println("Error: couldn't create User.");
        return 1;
    L87:
        th = th;
    L88:
        Trace.traceEnd(r17);
        throw th;
    L56:
        if (UserManager.isUserTypeRestricted(userType3) == false) goto L69;
        if (userId < 0) goto L59;
        int parentUserId = userId;
    L60:
        info = um.createRestrictedProfileWithThrow(arg, parentUserId);     // Catch: Throwable -> L63 ServiceSpecificException -> L65
        if (Process.myUid() != 0) goto L67;
        String r10 = "root";
    L68:
        accm.addSharedAccountsFromParentUser(parentUserId, userId, r10);     // Catch: Throwable -> L63 ServiceSpecificException -> L65
    L76:
        Trace.traceEnd(262144);
        goto L82
    L67:
        r10 = "com.android.shell";
        goto L68
    L59:
        parentUserId = 0;
        goto L60
    L69:
        if (userId >= 0) goto L75;
        if (preCreateOnly == false) goto L72;
        UserInfo r0 = um.preCreateUserWithThrow(userType3);     // Catch: Throwable -> L63 ServiceSpecificException -> L65
    L73:
        info = r0;
        goto L76
    L72:
        r0 = um.createUserWithThrow(arg, userType3, flags);     // Catch: Throwable -> L63 ServiceSpecificException -> L65
        goto L73
    L75:
        info = um.createProfileForUserWithThrow(arg, userType3, flags, userId, null);     // Catch: Throwable -> L63 ServiceSpecificException -> L65
    L63:
        th = th;
        r17 = 262144;
        goto L88
    L53:
        userType3 = userType;
        goto L54
    }

    public int runRemoveUser() throws RemoteException {
        boolean setEphemeralIfInUse = false;
        boolean wait = false;
    L3:
        String arg = getNextOption();
        byte r4 = 0;
        if (arg == null) goto L24;
        switch(arg.hashCode()) {
            case -1095309356: goto L15;
            case 1514: goto L12;
            case 1333511957: goto L9;
            default: goto L17;
        };
    L17:
        r4 = -1;
    L18:
        switch(r4) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        getErrPrintWriter().println("Error: unknown option: " + arg);
        return -1;
    L22:
        setEphemeralIfInUse = true;
        goto L3
    L21:
        wait = true;
        goto L3
    L9:
        if (arg.equals("--wait") == false) goto L46;
        r4 = 1;
        goto L18
    L46:
        r4 = -1;
        goto L18
    L12:
        if (arg.equals("-w") == false) goto L47;
        r4 = 2;
        goto L18
    L47:
        r4 = -1;
        goto L18
    L15:
        if (arg.equals("--set-ephemeral-if-in-use") == true) goto L18;
        r4 = -1;
        goto L18
    L24:
        String arg2 = getNextArg();
        if (arg2 != null) goto L28;
        getErrPrintWriter().println("Error: no user id specified.");
        return 1;
    L28:
        int userId = UserHandle.parseUserArg(arg2);
        IUserManager um = IUserManager.Stub.asInterface(ServiceManager.getService("user"));
        if (setEphemeralIfInUse == true) goto L31;
        if (wait == false) goto L34;
        boolean success = removeUserAndWait(um, userId);
    L35:
        if (success == false) goto L38;
        getOutPrintWriter().println("Success: removed user");
        return 0;
    L38:
        return 1;
    L34:
        success = removeUser(um, userId);
        goto L35
    L31:
        return removeUserWhenPossible(um, userId);
    }

    private boolean removeUser(IUserManager um, int userId) throws RemoteException {
        Slog.i(TAG, "Removing user " + userId);
        if (um.removeUser(userId) == false) goto L6;
        return true;
    L6:
        getErrPrintWriter().println("Error: couldn't remove user id " + userId);
        return false;
    }

    private boolean removeUserAndWait(IUserManager um, final int userId) throws RemoteException {
        Slog.i(TAG, "Removing (and waiting for completion) user " + userId);
        final CountDownLatch waitLatch = new CountDownLatch(1);
        UserManagerInternal.UserLifecycleListener listener = new AnonymousClass4(this, userId, waitLatch);
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        umi.addUserLifecycleListener(listener);
    L12:
        e = move-exception;
        getErrPrintWriter().printf("Error: Remove user %d wait interrupted: %s\n", new Object[]{Integer.valueOf(userId), e});     // Catch: Throwable -> L10
        Thread.currentThread().interrupt();     // Catch: Throwable -> L10
        umi.removeUserLifecycleListener(listener);
        return false;
    L4:
        if (um.removeUser(userId) == false) goto L16;
        boolean awaitSuccess = waitLatch.await(10, TimeUnit.MINUTES);     // Catch: Throwable -> L10 InterruptedException -> L12
        if (awaitSuccess == true) goto L14;
        getErrPrintWriter().printf("Error: Remove user %d timed out\n", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L10 InterruptedException -> L12
        umi.removeUserLifecycleListener(listener);
        return false;
    L14:
        umi.removeUserLifecycleListener(listener);
        return true;
    L16:
        getErrPrintWriter().println("Error: couldn't remove user id " + userId);     // Catch: Throwable -> L10 InterruptedException -> L12
        umi.removeUserLifecycleListener(listener);
        return false;
    L10:
        th = move-exception;
        umi.removeUserLifecycleListener(listener);
        throw th;
    }

    private int removeUserWhenPossible(IUserManager um, int userId) throws RemoteException {
        Slog.i(TAG, "Removing " + userId + " or set as ephemeral if in use.");
        int result = um.removeUserWhenPossible(userId, false);
        switch(result) {
            case -5: goto L12;
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        getErrPrintWriter().printf("Error: couldn't remove or mark ephemeral user id %d\n", new Object[]{Integer.valueOf(userId)});
        return 1;
    L6:
        getOutPrintWriter().printf("Success: user %d is already being removed\n", new Object[]{Integer.valueOf(userId)});
        return 0;
    L8:
        getOutPrintWriter().printf("Success: user %d set as ephemeral\n", new Object[]{Integer.valueOf(userId)});
        return 0;
    L10:
        getOutPrintWriter().printf("Success: user %d removed\n", new Object[]{Integer.valueOf(userId)});
        return 0;
    L12:
        getErrPrintWriter().printf("Error: user %d is a permanent admin main user\n", new Object[]{Integer.valueOf(userId)});
        return 1;
    }

    private int runMarkGuestForDeletion() throws RemoteException {
        String arg = getNextArg();
        if (arg != null) goto L6;
        getErrPrintWriter().println("Error: no user id specified.");
        return 1;
    L6:
        int userId = resolveUserId(UserHandle.parseUserArg(arg));
        IUserManager um = IUserManager.Stub.asInterface(ServiceManager.getService("user"));
        if (um.markGuestForDeletion(userId) == true) goto L10;
        getErrPrintWriter().println("Error: could not mark guest for deletion");
        return 1;
    L10:
        return 0;
    }

    private int runRenameUser() throws RemoteException {
        String arg = getNextArg();
        if (arg != null) goto L6;
        getErrPrintWriter().println("Error: no user id specified.");
        return 1;
    L6:
        int userId = resolveUserId(UserHandle.parseUserArg(arg));
        String name = getNextArg();
        if (name != null) goto L9;
        Slog.i(TAG, "Resetting name of user " + userId);
    L10:
        IUserManager um = IUserManager.Stub.asInterface(ServiceManager.getService("user"));
        um.setUserName(userId, name);
        return 0;
    L9:
        Slog.i(TAG, "Renaming user " + userId + " to '" + name + "'");
        goto L10
    }

    public int runSetUserRestriction() throws RemoteException {
        int userId = 0;
        String opt = getNextOption();
        if (opt != null) goto L5;
    L7:
        String restriction = getNextArg();
        String arg = getNextArg();
        if ("1".equals(arg) == false) goto L11;
        boolean value = true;
    L13:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSetUserRestriction");
        IUserManager um = IUserManager.Stub.asInterface(ServiceManager.getService("user"));
        um.setUserRestriction(restriction, value, translatedUserId);
        return 0;
    L11:
        if ("0".equals(arg) == false) goto L15;
        value = false;
        goto L13
    L15:
        getErrPrintWriter().println("Error: valid value not specified");
        return 1;
    L5:
        if ("--user".equals(opt) == false) goto L7;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L7
    }

    private int runGetUserRestriction() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = 0;
        boolean getAllRestrictions = false;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L25;
        switch(opt.hashCode()) {
            case 42995713: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r5 = -1;
    L15:
        switch(r5) {
            case 0: goto L23;
            case 1: goto L18;
            default: goto L17;
        };
    L17:
        throw new IllegalArgumentException("Unknown option " + opt);
    L23:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L18:
        getAllRestrictions = true;
        if (getNextArg() == null) goto L3;
        throw new IllegalArgumentException("Argument unexpected after \"--all\"");
    L9:
        if (opt.equals("--user") == false) goto L14;
    L12:
        if (opt.equals("--all") == false) goto L14;
        r5 = 1;
        goto L15
    L25:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runGetUserRestriction");
        IUserManager um = IUserManager.Stub.asInterface(ServiceManager.getService("user"));
        if (getAllRestrictions == false) goto L28;
        Bundle restrictions = um.getUserRestrictions(translatedUserId);
        pw.println("All restrictions:");
        pw.println(restrictions.toString());
    L33:
        return 0;
    L28:
        String restriction = getNextArg();
        if (restriction == null) goto L37;
        String unexpectedArgument = getNextArg();
        if (unexpectedArgument != null) goto L35;
        pw.println(um.hasUserRestriction(restriction, translatedUserId));
        goto L33
    L35:
        throw new IllegalArgumentException("Argument unexpected after restriction key");
    L37:
        throw new IllegalArgumentException("No restriction key specified");
    }

    public int runSupportsMultipleUsers() {
        getOutPrintWriter().println("Is multiuser supported: " + UserManager.supportsMultipleUsers());
        return 0;
    }

    public int runGetMaxUsers() {
        getOutPrintWriter().println("Maximum supported users: " + UserManager.getMaxSupportedUsers());
        return 0;
    }

    public int runGetMaxRunningUsers() {
        ActivityManagerInternal activityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        getOutPrintWriter().println("Maximum supported running users: " + activityManagerInternal.getMaxRunningUsers());
        return 0;
    }

    private InstallParams makeInstallParams(Set<String> unsupportedOptions) {
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
        InstallParams params = new InstallParams(null);
        params.sessionParams = sessionParams;
        sessionParams.installFlags |= 4194304;
        sessionParams.setPackageSource(1);
        Boolean staged = null;
        boolean replaceExisting = true;
        boolean forceNonStaged = false;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L223;
        if (unsupportedOptions.contains(opt) == true) goto L221;
        switch(opt.hashCode()) {
            case -2119202362: goto L134;
            case -2091380650: goto L131;
            case -2041347087: goto L128;
            case -1950997763: goto L125;
            case -1816313368: goto L122;
            case -1777984902: goto L119;
            case -1313152697: goto L116;
            case -1137116608: goto L113;
            case -951415743: goto L110;
            case -706813505: goto L107;
            case -653924786: goto L104;
            case -365988597: goto L101;
            case -311388442: goto L98;
            case -170474990: goto L95;
            case -158482320: goto L92;
            case 1477: goto L89;
            case 1478: goto L86;
            case 1495: goto L83;
            case 1497: goto L80;
            case 1498: goto L77;
            case 1500: goto L74;
            case 1507: goto L71;
            case 1509: goto L68;
            case 1511: goto L65;
            case 42995400: goto L62;
            case 43010092: goto L59;
            case 50011004: goto L56;
            case 77141024: goto L53;
            case 148207464: goto L50;
            case 458776531: goto L47;
            case 577311010: goto L44;
            case 849070388: goto L41;
            case 1051781117: goto L38;
            case 1067504745: goto L35;
            case 1289149813: goto L32;
            case 1332870850: goto L29;
            case 1333024815: goto L26;
            case 1333469547: goto L23;
            case 1494514835: goto L20;
            case 1507519174: goto L17;
            case 2015272120: goto L14;
            case 2037590537: goto L11;
            default: goto L136;
        };
    L136:
        byte r7 = -1;
    L138:
        switch(r7) {
            case 0: goto L3;
            case 1: goto L217;
            case 2: goto L212;
            case 3: goto L211;
            case 4: goto L210;
            case 5: goto L209;
            case 6: goto L208;
            case 7: goto L207;
            case 8: goto L206;
            case 9: goto L205;
            case 10: goto L204;
            case 11: goto L199;
            case 12: goto L194;
            case 13: goto L189;
            case 14: goto L188;
            case 15: goto L187;
            case 16: goto L187;
            case 17: goto L187;
            case 18: goto L186;
            case 19: goto L185;
            case 20: goto L184;
            case 21: goto L183;
            case 22: goto L182;
            case 23: goto L179;
            case 24: goto L175;
            case 25: goto L3;
            case 26: goto L173;
            case 27: goto L172;
            case 28: goto L171;
            case 29: goto L170;
            case 30: goto L169;
            case 31: goto L168;
            case 32: goto L156;
            case 33: goto L148;
            case 34: goto L152;
            case 35: goto L147;
            case 36: goto L146;
            case 37: goto L145;
            case 38: goto L144;
            case 39: goto L143;
            case 40: goto L142;
            case 41: goto L141;
            default: goto L140;
        };
    L140:
        throw new IllegalArgumentException("Unknown option " + opt);
    L141:
        sessionParams.setAutoInstallDependenciesEnabled(false);
        goto L3
    L142:
        sessionParams.dexoptCompilerFilter = getNextArgRequired();
        new DexoptParams.Builder("install").setCompilerFilter(sessionParams.dexoptCompilerFilter).build();
        goto L3
    L143:
        sessionParams.setPackageSource(Integer.parseInt(getNextArg()));
        goto L3
    L144:
        sessionParams.installFlags |= 268435456;
        goto L3
    L145:
        sessionParams.installFlags |= 16777216;
        goto L3
    L146:
        sessionParams.setApplicationEnabledSettingPersistent();
        goto L3
    L147:
        sessionParams.installFlags |= 524288;
        goto L3
    L148:
        int rollbackImpactLevel = Integer.parseInt(peekNextArg());
        if (rollbackImpactLevel < 0) goto L154;
        if (rollbackImpactLevel > 2) goto L154;
        sessionParams.setRollbackImpactLevel(rollbackImpactLevel);
    L154:
        throw new IllegalArgumentException(rollbackImpactLevel + " is not a valid rollback impact level.");
    L152:
        params.stagedReadyTimeoutMs = Long.parseLong(getNextArgRequired());
        goto L3
    L156:
        if (params.installerPackageName != null) goto L158;
        params.installerPackageName = "com.android.shell";
    L158:
        int rollbackStrategy = 0;
        rollbackStrategy = Integer.parseInt(peekNextArg());     // Catch: NumberFormatException -> L163
        if (rollbackStrategy < 0) goto L166;
        if (rollbackStrategy > 2) goto L166;
        getNextArg();     // Catch: NumberFormatException -> L163
    L166:
        throw new IllegalArgumentException(rollbackStrategy + " is not a valid rollback data policy.");     // Catch: NumberFormatException -> L163
    L167:
        sessionParams.setEnableRollback(true, rollbackStrategy);
        goto L3
    L168:
        sessionParams.setForceQueryable();
        goto L3
    L169:
        staged = false;
        goto L3
    L170:
        staged = true;
        goto L3
    L171:
        sessionParams.setMultiPackage();
        goto L3
    L172:
        forceNonStaged = true;
        goto L3
    L173:
        sessionParams.setInstallAsApex();
        goto L3
    L175:
        sessionParams.installFlags |= 512;
        sessionParams.volumeUuid = getNextArg();
        if ("internal".equals(sessionParams.volumeUuid) == false) goto L3;
        sessionParams.volumeUuid = null;
        goto L3
    L179:
        if (params.installerPackageName != null) goto L181;
        params.installerPackageName = "com.android.shell";
    L181:
        sessionParams.installFlags |= 33554432;
        goto L3
    L182:
        sessionParams.installReason = Integer.parseInt(getNextArg());
        goto L3
    L183:
        sessionParams.installLocation = Integer.parseInt(getNextArg());
        goto L3
    L184:
        params.userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L185:
        sessionParams.setInstallAsVirtualPreload();
        goto L3
    L186:
        sessionParams.setInstallAsInstantApp(false);
        goto L3
    L187:
        sessionParams.setInstallAsInstantApp(true);
        goto L3
    L188:
        sessionParams.abiOverride = checkAbiArgument(getNextArg());
        goto L3
    L189:
        long sizeBytes = Long.parseLong(getNextArg());
        if (sizeBytes <= 0) goto L193;
        sessionParams.setSize(sizeBytes);
        goto L3
    L193:
        throw new IllegalArgumentException("Size must be positive");
    L194:
        sessionParams.appPackageName = getNextArg();
        if (sessionParams.appPackageName != null) goto L3;
        throw new IllegalArgumentException("Missing package name");
    L199:
        sessionParams.mode = 2;
        sessionParams.appPackageName = getNextArg();
        if (sessionParams.appPackageName != null) goto L3;
        throw new IllegalArgumentException("Missing inherit package name");
    L204:
        sessionParams.referrerUri = Uri.parse(getNextArg());
        goto L3
    L205:
        sessionParams.originatingUri = Uri.parse(getNextArg());
        goto L3
    L206:
        sessionParams.installFlags |= 4096;
        goto L3
    L207:
        sessionParams.installFlags &= -4194305;
        goto L3
    L208:
        sessionParams.installFlags |= 256;
        goto L3
    L209:
        sessionParams.installFlags |= 128;
        goto L3
    L210:
        sessionParams.installFlags |= 16;
        goto L3
    L211:
        sessionParams.installFlags |= 4;
        goto L3
    L212:
        params.installerPackageName = getNextArg();
        if (params.installerPackageName != null) goto L3;
        throw new IllegalArgumentException("Missing installer package");
    L217:
        replaceExisting = false;
        goto L3
    L11:
        if (opt.equals("--skip-verification") == false) goto L136;
        r7 = 35;
        goto L138
    L14:
        if (opt.equals("--force-sdk") == false) goto L136;
        r7 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L138
    L17:
        if (opt.equals("--staged") == false) goto L136;
        r7 = ParameterName.PC_MODE;
        goto L138
    L20:
        if (opt.equals("--restrict-permissions") == false) goto L136;
        r7 = 7;
        goto L138
    L23:
        if (opt.equals("--user") == false) goto L136;
        r7 = ParameterName.BLACK_STRETCH;
        goto L138
    L26:
        if (opt.equals("--full") == false) goto L136;
        r7 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L138
    L29:
        if (opt.equals("--apex") == false) goto L136;
        r7 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L138
    L32:
        if (opt.equals("--dexopt-compiler-filter") == false) goto L136;
        r7 = ParameterName.COLOR_TEMPERATURE_RED_OFFSET;
        goto L138
    L35:
        if (opt.equals("--preload") == false) goto L136;
        r7 = ParameterName.FILM_MODE;
        goto L138
    L38:
        if (opt.equals("--ephemeral") == false) goto L136;
        r7 = 15;
        goto L138
    L41:
        if (opt.equals("--disable-auto-install-dependencies") == false) goto L136;
        r7 = 41;
        goto L138
    L44:
        if (opt.equals("--package-source") == false) goto L136;
        r7 = ParameterName.COLOR_TEMPERATURE_BLUE_GAIN;
        goto L138
    L47:
        if (opt.equals("--ignore-dexopt-profile") == false) goto L136;
        r7 = ParameterName.COLOR_TEMPERATURE_GREEN_GAIN;
        goto L138
    L50:
        if (opt.equals("--originating-uri") == false) goto L136;
        r7 = 9;
        goto L138
    L53:
        if (opt.equals("--force-queryable") == false) goto L136;
        r7 = ParameterName.VRR;
        goto L138
    L56:
        if (opt.equals("--bypass-low-target-sdk-block") == false) goto L136;
        r7 = 37;
        goto L138
    L59:
        if (opt.equals("--pkg") == false) goto L136;
        r7 = 12;
        goto L138
    L62:
        if (opt.equals("--abi") == false) goto L136;
        r7 = 14;
        goto L138
    L65:
        if (opt.equals("-t") == false) goto L136;
        r7 = 3;
        goto L138
    L68:
        if (opt.equals("-r") == false) goto L136;
        r7 = 0;
        goto L138
    L71:
        if (opt.equals("-p") == false) goto L136;
        r7 = 11;
        goto L138
    L74:
        if (opt.equals("-i") == false) goto L136;
        r7 = 2;
        goto L138
    L77:
        if (opt.equals("-g") == false) goto L136;
        r7 = 6;
        goto L138
    L80:
        if (opt.equals("-f") == false) goto L136;
        r7 = 4;
        goto L138
    L83:
        if (opt.equals("-d") == false) goto L136;
        r7 = 5;
        goto L138
    L86:
        if (opt.equals("-S") == false) goto L136;
        r7 = 13;
        goto L138
    L89:
        if (opt.equals("-R") == false) goto L136;
        r7 = 1;
        goto L138
    L92:
        if (opt.equals("--staged-ready-timeout") == false) goto L136;
        r7 = 34;
        goto L138
    L95:
        if (opt.equals("--multi-package") == false) goto L136;
        r7 = ParameterName.GAMUT_MAPPING;
        goto L138
    L98:
        if (opt.equals("--rollback-impact-level") == false) goto L136;
        r7 = 33;
        goto L138
    L101:
        if (opt.equals("--update-ownership") == false) goto L136;
        r7 = ParameterName.COLOR_TEMPERATURE;
        goto L138
    L104:
        if (opt.equals("--enable-rollback") == false) goto L136;
        r7 = ParameterName.CVRR;
        goto L138
    L107:
        if (opt.equals("--referrer") == false) goto L136;
        r7 = 10;
        goto L138
    L110:
        if (opt.equals("--instant") == false) goto L136;
        r7 = 16;
        goto L138
    L113:
        if (opt.equals("--instantapp") == false) goto L136;
        r7 = ParameterName.DE_CONTOUR;
        goto L138
    L116:
        if (opt.equals("--install-location") == false) goto L136;
        r7 = ParameterName.BLUE_STRETCH;
        goto L138
    L119:
        if (opt.equals("--dont-kill") == false) goto L136;
        r7 = 8;
        goto L138
    L122:
        if (opt.equals("--force-non-staged") == false) goto L136;
        r7 = ParameterName.LEVEL_RANGE;
        goto L138
    L125:
        if (opt.equals("--force-uuid") == false) goto L136;
        r7 = ParameterName.GLOBE_DIMMING;
        goto L138
    L128:
        if (opt.equals("--skip-enable") == false) goto L136;
        r7 = 36;
        goto L138
    L131:
        if (opt.equals("--install-reason") == false) goto L136;
        r7 = ParameterName.COLOR_TUNE;
        goto L138
    L134:
        if (opt.equals("--non-staged") == false) goto L136;
        r7 = ParameterName.LOW_LATENCY;
        goto L138
    L221:
        throw new IllegalArgumentException("Unsupported option " + opt);
    L223:
        if (staged == null) goto L225;
    L229:
        if (replaceExisting == false) goto L231;
        sessionParams.installFlags |= 2;
    L231:
        if (forceNonStaged == false) goto L234;
        sessionParams.isStaged = false;
        sessionParams.developmentInstallFlags |= 1;
    L237:
        if ((131072 & sessionParams.installFlags) != 0) goto L239;
    L245:
        return params;
    L239:
        if ((sessionParams.installFlags & 262144) == 0) goto L245;
        if (sessionParams.rollbackDataPolicy != 1) goto L245;
        throw new IllegalArgumentException("Data policy 'wipe' is not supported for apex.");
    L234:
        if (staged.booleanValue() == false) goto L237;
        sessionParams.setStaged();
        goto L237
    L225:
        if ((sessionParams.installFlags & 131072) == 0) goto L227;
        boolean r8 = true;
    L228:
        staged = Boolean.valueOf(r8);
        goto L229
    L227:
        r8 = false;
        goto L228
    }

    private int runSetHomeActivity() {
        PrintWriter pw = getOutPrintWriter();
        int userId = 0;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        r5 = -1;
    L12:
        switch(r5) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L13:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L9:
        if (opt.equals("--user") == false) goto L11;
    L16:
        String component = getNextArg();
        if (component.indexOf(47) >= 0) goto L19;
        String pkgName = component;
    L24:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSetHomeActivity");
        final CompletableFuture<Boolean> future = new CompletableFuture();
        RoleManager roleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);     // Catch: Exception -> L35
        roleManager.addRoleHolderAsUser("android.app.role.HOME", pkgName, 0, UserHandle.of(translatedUserId), FgThread.getExecutor(), new PackageManagerShellCommand$$ExternalSyntheticLambda3(future));     // Catch: Exception -> L31
        boolean success = future.get().booleanValue();     // Catch: Exception -> L31
        if (success == false) goto L33;
        pw.println("Success");     // Catch: Exception -> L31
        return 0;
    L33:
        pw.println("Error: Failed to set default home.");     // Catch: Exception -> L31
        return 1;
    L31:
        e = e;
    L37:
        pw.println(e.toString());
        return 1;
    L35:
        e = e;
        goto L37
    L19:
        ComponentName componentName = ComponentName.unflattenFromString(component);
        if (componentName != null) goto L23;
        pw.println("Error: invalid component name");
        return 1;
    L23:
        pkgName = componentName.getPackageName();
        goto L24
    }

    private int runSetInstaller() throws RemoteException {
        String targetPackage = getNextArg();
        String installerPackageName = getNextArg();
        if (targetPackage == null) goto L8;
        if (installerPackageName == null) goto L8;
        this.mInterface.setInstallerPackageName(targetPackage, installerPackageName);
        getOutPrintWriter().println("Success");
        return 0;
    L8:
        getErrPrintWriter().println("Must provide both target and installer package names");
        return 1;
    }

    private int runGetInstantAppResolver() {
        PrintWriter pw = getOutPrintWriter();
        ComponentName instantAppsResolver = this.mInterface.getInstantAppResolverComponent();     // Catch: Exception -> L9
        if (instantAppsResolver != null) goto L6;
        return 1;
    L6:
        pw.println(instantAppsResolver.flattenToString());     // Catch: Exception -> L9
        return 0;
    L9:
        e = move-exception;
        pw.println(e.toString());
        return 1;
    }

    private int runHasFeature() {
        PrintWriter err = getErrPrintWriter();
        String featureName = getNextArg();
        if (featureName != null) goto L6;
        err.println("Error: expected FEATURE name");
        return 1;
    L6:
        String versionString = getNextArg();
        if (versionString != null) goto L22;
        int version = 0;
    L10:
        boolean hasFeature = this.mInterface.hasSystemFeature(featureName, version);     // Catch: RemoteException -> L14 NumberFormatException -> L16
        getOutPrintWriter().println(hasFeature);     // Catch: RemoteException -> L14 NumberFormatException -> L16
        if (hasFeature == true) goto L13;
        return 1;
    L13:
        return 0;
    L14:
        e = move-exception;
        err.println(e.toString());
        return 1;
    L20:
        err.println("Error: illegal version number " + versionString);
        return 1;
    L22:
        version = Integer.parseInt(versionString);     // Catch: RemoteException -> L14 NumberFormatException -> L16
        goto L10
    }

    private int runDump() {
        String pkg = getNextArg();
        if (pkg != null) goto L6;
        getErrPrintWriter().println("Error: no package specified");
        return 1;
    L6:
        ActivityManager.dumpPackageStateStatic(getOutFileDescriptor(), pkg);
        return 0;
    }

    private int runDumpPackage() {
        String pkg = getNextArg();
        if (pkg != null) goto L12;
        getErrPrintWriter().println("Error: no package specified");
        return 1;
    L12:
        this.mInterface.dump(getOutFileDescriptor(), new String[]{pkg});     // Catch: Throwable -> L8
        return 0;
    L8:
        e = move-exception;
        PrintWriter pw = getErrPrintWriter();
        pw.println("Failure dumping service:");
        e.printStackTrace(pw);
        pw.flush();
        return 0;
    }

    private int runSetHarmfulAppWarning() throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runSetHarmfulAppWarning");
        String packageName = getNextArgRequired();
        String warning = getNextArg();
        this.mInterface.setHarmfulAppWarning(packageName, warning, translatedUserId);
        return 0;
    }

    private int runGetHarmfulAppWarning() throws RemoteException {
        int userId = -2;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L10;
        if (opt.equals("--user") == false) goto L8;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L8:
        getErrPrintWriter().println("Error: Unknown option: " + opt);
        return -1;
    L10:
        int translatedUserId = translateUserId(userId, ProcessList.INVALID_ADJ, "runGetHarmfulAppWarning");
        String packageName = getNextArgRequired();
        CharSequence warning = this.mInterface.getHarmfulAppWarning(packageName, translatedUserId);
        if (TextUtils.isEmpty(warning) == true) goto L14;
        getOutPrintWriter().println(warning);
        return 0;
    L14:
        return 1;
    }

    private int runSetSilentUpdatesPolicy() {
        PrintWriter pw = getOutPrintWriter();
        String installerPackageName = null;
        Long throttleTimeInSeconds = null;
        boolean reset = false;
    L3:
        String opt = getNextOption();
        byte r6 = 1;
        if (opt == null) goto L25;
        switch(opt.hashCode()) {
            case -1615291473: goto L15;
            case 771584496: goto L12;
            case 1002172770: goto L9;
            default: goto L17;
        };
    L17:
        r6 = -1;
    L18:
        switch(r6) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L19;
        };
    L19:
        pw.println("Error: Unknown option: " + opt);
        return -1;
    L22:
        throttleTimeInSeconds = Long.valueOf(Long.parseLong(getNextArgRequired()));
        goto L3
    L23:
        installerPackageName = getNextArgRequired();
        goto L3
    L21:
        reset = true;
        goto L3
    L9:
        if (opt.equals("--allow-unlimited-silent-updates") == false) goto L53;
        r6 = 0;
        goto L18
    L53:
        r6 = -1;
        goto L18
    L12:
        if (opt.equals("--throttle-time") == true) goto L18;
        r6 = -1;
        goto L18
    L15:
        if (opt.equals("--reset") == false) goto L55;
        r6 = 2;
        goto L18
    L55:
        r6 = -1;
        goto L18
    L25:
        if (throttleTimeInSeconds != null) goto L27;
    L43:
        IPackageInstaller installer = this.mInterface.getPackageInstaller();     // Catch: RemoteException -> L33
        if (reset == false) goto L35;
        installer.setAllowUnlimitedSilentUpdates(null);     // Catch: RemoteException -> L33
        installer.setSilentUpdatesThrottleTime(-1);     // Catch: RemoteException -> L33
    L40:
        return 1;
    L35:
        if (installerPackageName == null) goto L37;
        installer.setAllowUnlimitedSilentUpdates(installerPackageName);     // Catch: RemoteException -> L33
    L37:
        if (throttleTimeInSeconds == null) goto L40;
        installer.setSilentUpdatesThrottleTime(throttleTimeInSeconds.longValue());     // Catch: RemoteException -> L33
    L33:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    L27:
        if (throttleTimeInSeconds.longValue() >= 0) goto L43;
        pw.println("Error: Invalid value for \"--throttle-time\":" + throttleTimeInSeconds);
        return -1;
    }

    private int runGetAppMetadata() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.GET_APP_METADATA", "getAppMetadataFd");
        PrintWriter pw = getOutPrintWriter();
        String pkgName = getNextArgRequired();
        ParcelFileDescriptor pfd = this.mInterface.getAppMetadataFd(pkgName, this.mContext.getUserId());     // Catch: RemoteException -> L25
        if (pfd != null) goto L34;
        return 1;
    L34:
        BufferedReader br = new BufferedReader(new InputStreamReader(new ParcelFileDescriptor.AutoCloseInputStream(pfd)));     // Catch: IOException -> L14
    L32:
    L10:
        th = move-exception;
        br.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: IOException -> L14
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
        goto L20
    L7:
        if (br.ready() == false) goto L12;
        pw.println(br.readLine());     // Catch: Throwable -> L10
    L12:
        br.close();     // Catch: IOException -> L14
        return 1;
    L14:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    L25:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    }

    private int runWaitForHandler(boolean forBackgroundHandler) {
        PrintWriter pw = getOutPrintWriter();
        long timeoutMillis = 60000;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L17;
        switch(opt.hashCode()) {
            case 72070081: goto L9;
            default: goto L11;
        };
    L11:
        r5 = -1;
    L12:
        switch(r5) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        timeoutMillis = Long.parseLong(getNextArgRequired());
        goto L3
    L13:
        pw.println("Error: Unknown option: " + opt);
        return -1;
    L9:
        if (opt.equals("--timeout") == false) goto L11;
    L17:
        if (timeoutMillis > 0) goto L29;
        pw.println("Error: --timeout value must be positive: " + timeoutMillis);
        return -1;
    L29:
        boolean success = this.mInterface.waitForHandler(timeoutMillis, forBackgroundHandler);     // Catch: RemoteException -> L26
        if (success == false) goto L24;
        pw.println("Success");
        return 0;
    L24:
        pw.println("Timeout. PackageManager handlers are still busy.");
        return -1;
    L26:
        e = move-exception;
        pw.println("Failure [" + e.getClass().getName() + " - " + e.getMessage() + "]");
        return -1;
    }

    private int runArtServiceCommand() {
        ParcelFileDescriptor in = ParcelFileDescriptor.dup(getInFileDescriptor());     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L20 IOException -> L22
        ParcelFileDescriptor out = ParcelFileDescriptor.dup(getOutFileDescriptor());     // Catch: Throwable -> L15
        ParcelFileDescriptor err = ParcelFileDescriptor.dup(getErrFileDescriptor());     // Catch: Throwable -> L10
        int r0 = ((ArtManagerLocal) LocalManagerRegistry.getManagerOrThrow(ArtManagerLocal.class)).handleShellCommand(getTarget(), in, out, err, getAllArgs());     // Catch: Throwable -> L25
        if (err == null) goto L12;
        err.close();     // Catch: Throwable -> L10
    L12:
        if (out == null) goto L17;
        out.close();     // Catch: Throwable -> L15
    L17:
        if (in == null) goto L24;
        in.close();     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L20 IOException -> L22
    L24:
        return r0;
    L25:
        th = move-exception;
        if (err == null) goto L61;
        err.close();     // Catch: Throwable -> L30
    L62:
        throw th;     // Catch: Throwable -> L10
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L61:
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (out == null) goto L63;
        out.close();     // Catch: Throwable -> L36
    L64:
        throw th;     // Catch: Throwable -> L15
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L63:
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (in == null) goto L65;
        in.close();     // Catch: Throwable -> L42
        throw th;     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L20 IOException -> L22
    L42:
        th = move-exception;
        th.addSuppressed(th);     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L20 IOException -> L22
        throw th;     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L20 IOException -> L22
    L65:
        throw th;     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L20 IOException -> L22
    L22:
        e = move-exception;
        throw new IllegalStateException(e);
    L46:
        PrintWriter epw = getErrPrintWriter();
        epw.println("ART Service is not ready. Please try again later");
        return -1;
    }

    private static String checkAbiArgument(String abi) {
        if (TextUtils.isEmpty(abi) == true) goto L16;
        if (STDIN_PATH.equals(abi) == false) goto L7;
        return abi;
    L7:
        String[] supportedAbis = Build.SUPPORTED_ABIS;
        int r1 = supportedAbis.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        String supportedAbi = supportedAbis[r2];
        if (supportedAbi.equals(abi) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return abi;
    L14:
        throw new IllegalArgumentException("ABI " + abi + " not supported on this device");
    L16:
        throw new IllegalArgumentException("Missing ABI argument");
    }

    private int translateUserId(int userId, int allUserId, String logContext) {
        if (allUserId == (-10000)) goto L5;
        boolean r0 = true;
    L6:
        boolean allowAll = r0;
        int translatedUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, allowAll, true, logContext, "pm command");
        if (translatedUserId != (-1)) goto L10;
        return allUserId;
    L10:
        return translatedUserId;
    L5:
        r0 = false;
        goto L6
    }

    private int doCreateSession(PackageInstaller.SessionParams params, String installerPackageName, int userId) throws RemoteException {
        if (userId != (-1)) goto L5;
        params.installFlags |= 64;
    L5:
        int translatedUserId = translateUserId(userId, 0, "doCreateSession");
        int sessionId = this.mInterface.getPackageInstaller().createSession(params, installerPackageName, null, translatedUserId);
        return sessionId;
    }

    private int doAddFiles(int sessionId, ArrayList<String> args, long sessionSizeBytes, boolean isApex, boolean installArchived) throws RemoteException {
        PackageInstaller.Session session = null;
    L69:
        PackageInstaller.Session session2 = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L51 Throwable -> L53
    L73:
    L9:
        if (args.isEmpty() == true) goto L36;
    L23:
        e = th;
    L24:
        session = session2;
    L64:
        IoUtils.closeQuietly(session);
        throw e;
    L25:
        e = e;
    L26:
        session = session2;
    L67:
        getErrPrintWriter().println("Failed to add file(s), reason: " + e);     // Catch: Throwable -> L63
        getOutPrintWriter().println("Failure [failed to add file(s)]");     // Catch: Throwable -> L63
        IoUtils.closeQuietly(session);
        return 1;
    L63:
        e = th;
        goto L64
    L12:
        if (STDIN_PATH.equals(args.get(0)) == true) goto L36;
        Iterator<String> r0 = args.iterator();     // Catch: Throwable -> L23 Throwable -> L25
    L16:
        if (r0.hasNext() == false) goto L33;
        String arg = r0.next();     // Catch: Throwable -> L23 Throwable -> L25
        int delimLocation = arg.indexOf(58);     // Catch: Throwable -> L23 Throwable -> L25
        if (delimLocation != (-1)) goto L19;
        processArgForLocalFile(arg, session2, installArchived);     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        goto L16
    L19:
        if (installArchived == true) goto L20;
        if (processArgForStdin(arg, session2) == 0) goto L16;
        IoUtils.closeQuietly(session2);
        return 1;
    L20:
        getOutPrintWriter().println("Error: can't install with size from STDIN for Archival install");     // Catch: Throwable -> L23 Throwable -> L25
        IoUtils.closeQuietly(session2);
        return 1;
    L33:
        IoUtils.closeQuietly(session2);
        return 0;
    L36:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        r1.append("base");     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        r1.append(RANDOM.nextInt());     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        r1.append(".");     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        if (isApex == false) goto L39;
        String r7 = "apex";
    L40:
        r1.append(r7);     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        String name = r1.toString();     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        if (installArchived == true) goto L43;
        PackageManagerShellCommandDataLoader.Metadata metadata = PackageManagerShellCommandDataLoader.Metadata.forStdIn(name);     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        long size = sessionSizeBytes;
    L44:
        session2.addFile(0, name, size, metadata.toByteArray(), null);     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        IoUtils.closeQuietly(session2);
        return 0;
    L43:
        metadata = PackageManagerShellCommandDataLoader.Metadata.forArchived(getArchivedPackage(STDIN_PATH, sessionSizeBytes));     // Catch: Throwable -> L23 Throwable -> L25 Throwable -> L25
        size = -1;
        goto L44
    L39:
        r7 = "apk";
    L49:
        e = e;
    L47:
        e = th;
    L53:
        e = e;
    L51:
        e = th;
    L57:
        e = e;
    L55:
        e = th;
        goto L64
    }

    private int processArgForStdin(String arg, PackageInstaller.Session session) {
        String[] fileDesc = arg.split(":");
        int streamingVersion = 0;
    L7:
        e = e;
    L51:
        getErrPrintWriter().println("Unable to parse file parameters: " + arg + ", reason: " + e);
        return 1;
    L4:
        if (fileDesc.length >= 2) goto L9;
        getErrPrintWriter().println("Must specify file name and size");     // Catch: IllegalArgumentException -> L7
        return 1;
    L9:
        String name = fileDesc[0];     // Catch: IllegalArgumentException -> L7
        long sizeBytes = Long.parseUnsignedLong(fileDesc[1]);     // Catch: IllegalArgumentException -> L7
        String fileId = name;
        if (fileDesc.length <= 2) goto L15;
        if (TextUtils.isEmpty(fileDesc[2]) == true) goto L15;
        fileId = fileDesc[2];     // Catch: IllegalArgumentException -> L7
    L15:
        if (fileDesc.length <= 3) goto L18;
        byte[] signature = Base64.getDecoder().decode(fileDesc[3]);     // Catch: IllegalArgumentException -> L7
        byte[] signature2 = signature;
    L53:
    L26:
        e = e;
        goto L51
    L20:
        if (fileDesc.length <= 4) goto L29;
        streamingVersion = Integer.parseUnsignedInt(fileDesc[4]);     // Catch: IllegalArgumentException -> L26
        if (streamingVersion < 0) goto L24;
        if (streamingVersion <= 1) goto L29;
    L24:
        getErrPrintWriter().println("Unsupported streaming version: " + streamingVersion);     // Catch: IllegalArgumentException -> L26
        return 1;
    L29:
        if (TextUtils.isEmpty(name) == false) goto L32;
        getErrPrintWriter().println("Empty file name in: " + arg);
        return 1;
    L32:
        if (signature2 == null) goto L48;
        if (streamingVersion != 0) goto L35;
        PackageManagerShellCommandDataLoader.Metadata metadata = PackageManagerShellCommandDataLoader.Metadata.forDataOnlyStreaming(fileId);
    L55:
    L43:
        e = move-exception;
        getErrPrintWriter().println("V4 signature is invalid: " + e + " in " + arg);
        return 1;
    L38:
        if (signature2.length > 0) goto L40;
    L49:
        session.addFile(0, name, sizeBytes, metadata.toByteArray(), signature2);
        return 0;
    L40:
        if (V4Signature.readFrom(signature2) != null) goto L49;
        getErrPrintWriter().println("V4 signature is invalid in: " + arg);     // Catch: Exception -> L43
        return 1;
    L35:
        metadata = PackageManagerShellCommandDataLoader.Metadata.forStreaming(fileId);
        goto L55
    L48:
        metadata = PackageManagerShellCommandDataLoader.Metadata.forStdIn(fileId);
        goto L49
    L18:
        signature2 = null;
        goto L53
    }

    private long getFileStatSize(File file) {
        ParcelFileDescriptor pfd = openFileForSystem(file.getPath(), ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);
        if (pfd == null) goto L11;
        long r1 = pfd.getStatSize();     // Catch: Throwable -> L7
        IoUtils.closeQuietly(pfd);
        return r1;
    L7:
        th = move-exception;
        IoUtils.closeQuietly(pfd);
        throw th;
    L11:
        throw new IllegalArgumentException("Error: Can't open file: " + file.getPath());
    }

    private ArchivedPackageParcel getArchivedPackage(String inPath, long sizeBytes) throws RemoteException, IOException {
        Pair<ParcelFileDescriptor, Long> fdWithSize = openInFile(inPath, sizeBytes);
        if (fdWithSize.first == null) goto L24;
        ParcelFileDescriptor fd = (ParcelFileDescriptor) fdWithSize.first;
        int size = (int) ((Long) fdWithSize.second).longValue();
        InputStream inStream = new ParcelFileDescriptor.AutoCloseInputStream(fd);     // Catch: IOException -> L13
        byte[] bytes = new byte[size];     // Catch: Throwable -> L15
        Streams.readFully(inStream, bytes);     // Catch: Throwable -> L15
        String encoded = new String(bytes);     // Catch: Throwable -> L15
        inStream.close();     // Catch: IOException -> L13
        ArchivedPackageParcel result = PackageManagerShellCommandDataLoader.Metadata.readArchivedPackageParcel(HexEncoding.decode(encoded));
        if (result == null) goto L12;
        return result;
    L12:
        throw new IllegalArgumentException("Error: Can't parse archived package from: " + inPath);
    L15:
        th = move-exception;
        inStream.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: IOException -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Error: Can't load archived package from: " + inPath, e);
    L24:
        throw new IllegalArgumentException("Error: Can't open file: " + inPath);
    }

    private void processArgForLocalFile(String arg, PackageInstaller.Session session, boolean installArchived) throws IOException, RemoteException {
        File file = new File(arg);
        String name = file.getName();
        if (installArchived == false) goto L5;
        PackageManagerShellCommandDataLoader.Metadata metadata = PackageManagerShellCommandDataLoader.Metadata.forArchived(getArchivedPackage(arg, -1));
        PackageManagerShellCommandDataLoader.Metadata metadata2 = metadata;
        long size = 0;
    L7:
        if (installArchived == true) goto L19;
        String v4SignaturePath = arg + ".idsig";
        ParcelFileDescriptor pfd = openFileForSystem(v4SignaturePath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);
        if (pfd == null) goto L19;
        V4Signature v4signature = V4Signature.readFrom(pfd);     // Catch: Throwable -> L12 IOException -> L14
        byte[] v4signatureBytes = v4signature.toByteArray();     // Catch: Throwable -> L12 IOException -> L14
        IoUtils.closeQuietly(pfd);
    L20:
        session.addFile(0, name, size, metadata2.toByteArray(), v4signatureBytes);
        return;
    L14:
        ex = move-exception;
        Slog.e(TAG, "V4 signature file exists but failed to be parsed.", ex);     // Catch: Throwable -> L12
        IoUtils.closeQuietly(pfd);
    L12:
        th = move-exception;
        IoUtils.closeQuietly(pfd);
        throw th;
    L19:
        v4signatureBytes = null;
        goto L20
    L5:
        PackageManagerShellCommandDataLoader.Metadata metadata3 = PackageManagerShellCommandDataLoader.Metadata.forLocalFile(arg);
        metadata2 = metadata3;
        size = getFileStatSize(file);
        goto L7
    }

    private int doWriteSplits(int sessionId, ArrayList<String> splitPaths, long sessionSizeBytes, boolean isApex) throws RemoteException {
        if (splitPaths.size() <= 1) goto L5;
        boolean multipleSplits = true;
    L6:
        Iterator<String> r3 = splitPaths.iterator();
    L8:
        if (r3.hasNext() == false) goto L21;
        String splitPath = r3.next();
        if (multipleSplits == false) goto L12;
        String splitName = new File(splitPath).getName();
    L18:
        if (doWriteSplit(sessionId, splitPath, sessionSizeBytes, splitName, false) == 0) goto L8;
        return 1;
    L12:
        StringBuilder r4 = new StringBuilder();
        r4.append("base.");
        if (isApex == false) goto L15;
        String r5 = "apex";
    L16:
        r4.append(r5);
        splitName = r4.toString();
        goto L18
    L15:
        r5 = "apk";
        goto L16
    L21:
        return 0;
    L5:
        multipleSplits = false;
        goto L6
    }

    private Pair<ParcelFileDescriptor, Long> openInFile(String inPath, long sizeBytes) throws IOException {
        if (STDIN_PATH.equals(inPath) == false) goto L5;
        ParcelFileDescriptor fd = ParcelFileDescriptor.dup(getInFileDescriptor());
    L16:
        if (sizeBytes > 0) goto L20;
        getErrPrintWriter().println("Error: must specify an APK size");
        return Pair.create(null, 1L);
    L20:
        return Pair.create(fd, Long.valueOf(sizeBytes));
    L5:
        if (inPath == null) goto L14;
        fd = openFileForSystem(inPath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);
        if (fd == null) goto L9;
        sizeBytes = fd.getStatSize();
        if (sizeBytes >= 0) goto L16;
        fd.close();
        getErrPrintWriter().println("Unable to get size of: " + inPath);
        return Pair.create(null, -1L);
    L9:
        return Pair.create(null, -1L);
    L14:
        fd = ParcelFileDescriptor.dup(getInFileDescriptor());
        goto L16
    }

    private int doWriteSplit(int sessionId, String inPath, long sizeBytes, String splitName, boolean logSuccess) throws RemoteException {
        PackageInstaller.Session session = null;
        PackageInstaller.Session session2 = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L26 IOException -> L28
        PrintWriter pw = getOutPrintWriter();     // Catch: Throwable -> L10 IOException -> L12
        Pair<ParcelFileDescriptor, Long> fdWithSize = openInFile(inPath, sizeBytes);     // Catch: Throwable -> L10 IOException -> L12
        if (fdWithSize.first != null) goto L14;
        long resultCode = ((Long) fdWithSize.second).longValue();     // Catch: Throwable -> L10 IOException -> L12
        int r2 = (int) resultCode;
        IoUtils.closeQuietly(session2);
        return r2;
    L14:
        ParcelFileDescriptor fd = (ParcelFileDescriptor) fdWithSize.first;     // Catch: Throwable -> L10 IOException -> L12
        long sizeBytes2 = ((Long) fdWithSize.second).longValue();     // Catch: Throwable -> L10 IOException -> L12
        session2.write(splitName, 0, sizeBytes2, fd);     // Catch: Throwable -> L20 IOException -> L22
        if (logSuccess == false) goto L24;
        pw.println("Success: streamed " + sizeBytes2 + " bytes");     // Catch: Throwable -> L20 IOException -> L22
    L24:
        IoUtils.closeQuietly(session2);
        return 0;
    L22:
        e = e;
        session = session2;
    L30:
        getErrPrintWriter().println("Error: failed to write; " + e.getMessage());     // Catch: Throwable -> L26
        IoUtils.closeQuietly(session);
        return 1;
    L20:
        e = th;
        session = session2;
    L33:
        IoUtils.closeQuietly(session);
        throw e;
    L12:
        e = e;
        session = session2;
    L10:
        e = th;
        session = session2;
    L28:
        e = e;
    L26:
        e = th;
        goto L33
    }

    private int doInstallAddSession(int parentId, int[] sessionIds, boolean logSuccess) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        PackageInstaller.Session session = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(parentId));     // Catch: Throwable -> L8
        if (session.isMultiPackage() == true) goto L10;
        getErrPrintWriter().println("Error: parent session ID is not a multi-package session");     // Catch: Throwable -> L8
        IoUtils.closeQuietly(session);
        return 1;
    L10:
        int i = 0;
    L12:
        if (i >= sessionIds.length) goto L15;
        session.addChildSessionId(sessionIds[i]);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L15:
        if (logSuccess == false) goto L17;
        pw.println("Success");     // Catch: Throwable -> L8
    L17:
        IoUtils.closeQuietly(session);
        return 0;
    L8:
        th = move-exception;
        IoUtils.closeQuietly(null);
        throw th;
    }

    private int doRemoveSplits(int sessionId, Collection<String> splitNames, boolean logSuccess) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        PackageInstaller.Session session = null;
        session = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L7 IOException -> L9
        Iterator<String> r2 = splitNames.iterator();     // Catch: Throwable -> L7 IOException -> L9
    L5:
        if (r2.hasNext() == false) goto L11;
        String splitName = r2.next();     // Catch: Throwable -> L7 IOException -> L9
        session.removeSplit(splitName);     // Catch: Throwable -> L7 IOException -> L9
        goto L5
    L11:
        if (logSuccess == false) goto L13;
        pw.println("Success");     // Catch: Throwable -> L7 IOException -> L9
    L13:
        IoUtils.closeQuietly(session);
        return 0;
    L7:
        th = move-exception;
        IoUtils.closeQuietly(session);
        throw th;
    L9:
        e = move-exception;
        pw.println("Error: failed to remove split; " + e.getMessage());     // Catch: Throwable -> L7
        IoUtils.closeQuietly(session);
        return 1;
    }

    private int doCommitSession(int sessionId, boolean logSuccess) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        PackageInstaller.Session session = null;
        session = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L10
        if (session.isMultiPackage() == false) goto L7;
    L14:
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);     // Catch: Throwable -> L10
        session.commit(receiver.getIntentSender());     // Catch: Throwable -> L10
        if (session.isStaged() == true) goto L31;
        Intent result = receiver.getResult();     // Catch: Throwable -> L10
        int status = result.getIntExtra("android.content.pm.extra.STATUS", 1);     // Catch: Throwable -> L10
        List<String> warnings = result.getStringArrayListExtra("android.content.pm.extra.WARNINGS");     // Catch: Throwable -> L10
        if (status == 0) goto L20;
        pw.println("Failure [" + result.getStringExtra("android.content.pm.extra.STATUS_MESSAGE") + "]");     // Catch: Throwable -> L10
    L29:
        IoUtils.closeQuietly(session);
        return status;
    L20:
        if (ArrayUtils.isEmpty(warnings) == true) goto L26;
        Iterator<String> r3 = warnings.iterator();     // Catch: Throwable -> L10
    L23:
        if (r3.hasNext() == false) goto L25;
        String warning = r3.next();     // Catch: Throwable -> L10
        pw.println("Warning: " + warning);     // Catch: Throwable -> L10
        goto L23
    L25:
        status = 1;
        pw.println("Completed with warning(s)");     // Catch: Throwable -> L10
        goto L29
    L26:
        if (logSuccess == false) goto L29;
        pw.println("Success");     // Catch: Throwable -> L10
        goto L29
    L31:
        if (logSuccess == false) goto L33;
        pw.println("Success");     // Catch: Throwable -> L10
    L33:
        IoUtils.closeQuietly(session);
        return 0;
    L7:
        if (session.isStaged() == true) goto L14;
        DexMetadataHelper.validateDexPaths(session.getNames());     // Catch: Throwable -> L10 Throwable -> L12
    L12:
        e = move-exception;
        pw.println("Warning [Could not validate the dex paths: " + e.getMessage() + "]");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        IoUtils.closeQuietly(session);
        throw th;
    }

    private int doAbandonSession(int sessionId, boolean logSuccess) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        PackageInstaller.Session session = null;
        session = new PackageInstaller.Session(this.mInterface.getPackageInstaller().openSession(sessionId));     // Catch: Throwable -> L7
        session.abandon();     // Catch: Throwable -> L7
        if (logSuccess == false) goto L9;
        pw.println("Success");     // Catch: Throwable -> L7
    L9:
        IoUtils.closeQuietly(session);
        return 0;
    L7:
        th = move-exception;
        IoUtils.closeQuietly(session);
        throw th;
    }

    private void doListPermissions(ArrayList<String> groupList, boolean groups, boolean labels, boolean summary, int startProtectionLevel, int endProtectionLevel) throws RemoteException {
        ArrayList<String> r1 = groupList;
        PrintWriter pw = getOutPrintWriter();
        int groupCount = r1.size();
        int i = 0;
    L3:
        if (i >= groupCount) goto L79;
        String groupName = r1.get(i);
        String prefix = "";
        if (groups == false) goto L33;
        if (i <= 0) goto L8;
        pw.println("");
    L8:
        if (groupName == null) goto L26;
        PermissionGroupInfo pgi = this.mInterface.getPermissionGroupInfo(groupName, 0);
        if (summary == false) goto L16;
        Resources res = getResources(pgi);
        if (res == null) goto L14;
        StringBuilder r11 = new StringBuilder();
        int groupCount2 = groupCount;
        int groupCount3 = pgi.labelRes;
        String groupName2 = groupName;
        r11.append(loadText(pgi, groupCount3, pgi.nonLocalizedLabel));
        r11.append(": ");
        pw.print(r11.toString());
    L32:
        prefix = "  ";
    L34:
        int count = 0;
        List<PermissionInfo> ps = this.mPermissionManager.queryPermissionsByGroup(r1.get(i), 0);
        if (ps == null) goto L38;
        count = ps.size();
    L38:
        boolean first = true;
        int p = 0;
    L39:
        if (p >= count) goto L74;
        PermissionInfo pi = ps.get(p);
        if (groups == false) goto L46;
        if (groupName2 != null) goto L46;
        if (pi.group == null) goto L46;
        ps = ps;
        i = i;
    L73:
        p = p + 1;
        ps = ps;
        i = i;
    L46:
        int base = pi.protectionLevel & 15;
        if (base >= startProtectionLevel) goto L49;
        ps = ps;
        i = i;
        goto L73
    L49:
        if (base <= endProtectionLevel) goto L51;
        ps = ps;
        i = i;
        goto L73
    L51:
        if (summary == false) goto L60;
        if (first == false) goto L54;
        first = false;
    L55:
        Resources res2 = getResources(pi);
        if (res2 == null) goto L58;
        pw.print(loadText(pi, pi.labelRes, pi.nonLocalizedLabel));
    L59:
        i = i;
        goto L73
    L58:
        pw.print(pi.name);
        goto L59
    L54:
        pw.print(", ");
        goto L55
    L60:
        ps = ps;
        StringBuilder r2 = new StringBuilder();
        r2.append(prefix);
        if (labels == false) goto L63;
        String r3 = "+ ";
    L64:
        r2.append(r3);
        r2.append("permission:");
        r2.append(pi.name);
        pw.println(r2.toString());
        if (labels == false) goto L71;
        pw.println(prefix + "  package:" + pi.packageName);
        Resources res3 = getResources(pi);
        if (res3 == null) goto L70;
        pw.println(prefix + "  label:" + loadText(pi, pi.labelRes, pi.nonLocalizedLabel));
        pw.println(prefix + "  description:" + loadText(pi, pi.descriptionRes, pi.nonLocalizedDescription));
    L70:
        pw.println(prefix + "  protectionLevel:" + PermissionInfo.protectionToString(pi.protectionLevel));
        goto L73
    L71:
        i = i;
        goto L73
    L63:
        r3 = "";
        goto L64
    L74:
        int i2 = i;
        if (summary == false) goto L77;
        pw.println("");
    L77:
        i = i2 + 1;
        r1 = groupList;
        groupCount = groupCount2;
        goto L3
    L14:
        groupCount2 = groupCount;
        groupName2 = groupName;
        pw.print(pgi.name + ": ");
        goto L32
    L16:
        groupCount2 = groupCount;
        groupName2 = groupName;
        StringBuilder r4 = new StringBuilder();
        if (labels == false) goto L19;
        String r5 = "+ ";
    L20:
        r4.append(r5);
        r4.append("group:");
        r4.append(pgi.name);
        pw.println(r4.toString());
        if (labels == false) goto L32;
        pw.println("  package:" + pgi.packageName);
        Resources res4 = getResources(pgi);
        if (res4 == null) goto L32;
        pw.println("  label:" + loadText(pgi, pgi.labelRes, pgi.nonLocalizedLabel));
        pw.println("  description:" + loadText(pgi, pgi.descriptionRes, pgi.nonLocalizedDescription));
        goto L32
    L19:
        r5 = "";
        goto L20
    L26:
        groupCount2 = groupCount;
        groupName2 = groupName;
        StringBuilder r6 = new StringBuilder();
        if (labels == false) goto L30;
        if (summary == true) goto L30;
        String r7 = "+ ";
    L31:
        r6.append(r7);
        r6.append("ungrouped:");
        pw.println(r6.toString());
    L30:
        r7 = "";
        goto L31
    L33:
        groupCount2 = groupCount;
        groupName2 = groupName;
        goto L34
    }

    private String loadText(PackageItemInfo pii, int res, CharSequence nonLocalized) throws RemoteException {
        if (nonLocalized != null) goto L4;
        if (res == 0) goto L15;
        Resources r = getResources(pii);
        if (r == null) goto L16;
        return r.getString(res);
    L11:
        return null;
    L16:
        return null;
    L15:
        return null;
    L4:
        return nonLocalized.toString();
    }

    private Resources getResources(PackageItemInfo pii) throws RemoteException {
        Resources res = this.mResourceCache.get(pii.packageName);
        if (res == null) goto L5;
        return res;
    L5:
        ApplicationInfo ai = this.mInterface.getApplicationInfo(pii.packageName, 536904192, 0);
        if (ai != null) goto L9;
        Slog.e(TAG, "Failed to get ApplicationInfo for package name(" + pii.packageName + ").");
        return null;
    L9:
        AssetManager am = new AssetManager();
        am.addAssetPath(ai.publicSourceDir);
        Resources res2 = new Resources(am, null, null);
        this.mResourceCache.put(pii.packageName, res2);
        return res2;
    }

    private int resolveUserId(int userId) {
        if (userId != (-2)) goto L6;
        return ActivityManager.getCurrentUser();
    L6:
        return userId;
    }

    private int runClearPackagePreferredActivities() {
        PrintWriter pw = getErrPrintWriter();
        String packageName = getNextArg();
        if (packageName != null) goto L12;
        pw.println("Error: package name not specified");
        return 1;
    L12:
        this.mContext.getPackageManager().clearPackagePreferredActivities(packageName);     // Catch: Exception -> L9
        return 0;
    L9:
        e = move-exception;
        pw.println(e.toString());
        return 1;
    }

    private int runArchive() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L18;
        if (opt.equals("--user") == false) goto L16;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId == (-1)) goto L3;
        if (userId == (-2)) goto L3;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umi.getUserInfo(userId);
        if (userInfo != null) goto L3;
        pw.println("Failure [user " + userId + " doesn't exist]");
        return 1;
    L16:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L18:
        String packageName = getNextArg();
        if (packageName != null) goto L22;
        pw.println("Error: package name not specified");
        return 1;
    L22:
        if (userId != (-1)) goto L24;
        int flags = 0 | 2;
        int flags2 = flags;
    L25:
        int translatedUserId = translateUserId(userId, 0, "runArchive");
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);
        this.mInterface.getPackageInstaller().requestArchive(packageName, "", flags2, receiver.getIntentSender(), new UserHandle(translatedUserId));     // Catch: Exception -> L33
        Intent result = receiver.getResult();
        int status = result.getIntExtra("android.content.pm.extra.STATUS", 1);
        if (status != 0) goto L31;
        pw.println("Success");
        return 0;
    L31:
        pw.println("Failure [" + result.getStringExtra("android.content.pm.extra.STATUS_MESSAGE") + "]");
        return 1;
    L33:
        e = move-exception;
        pw.println("Failure [" + e.getMessage() + "]");
        return 1;
    L24:
        flags2 = 0;
        goto L25
    }

    private int runUnarchive() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L18;
        if (opt.equals("--user") == false) goto L16;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId == (-1)) goto L3;
        if (userId == (-2)) goto L3;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umi.getUserInfo(userId);
        if (userInfo != null) goto L3;
        pw.println("Failure [user " + userId + " doesn't exist]");
        return 1;
    L16:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L18:
        String packageName = getNextArg();
        if (packageName != null) goto L22;
        pw.println("Error: package name not specified");
        return 1;
    L22:
        int translatedUserId = translateUserId(userId, 0, "runArchive");
        LocalIntentReceiver receiver = new LocalIntentReceiver(null);
        this.mInterface.getPackageInstaller().requestUnarchive(packageName, this.mContext.getPackageName(), receiver.getIntentSender(), new UserHandle(translatedUserId));     // Catch: Exception -> L26
        pw.println("Success");
        return 0;
    L26:
        e = move-exception;
        pw.println("Failure [" + e.getMessage() + "]");
        return 1;
    }

    private int runGetDomainVerificationAgent() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int userId = -1;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L18;
        if (opt.equals("--user") == false) goto L16;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        if (userId == (-1)) goto L3;
        if (userId == (-2)) goto L3;
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umi.getUserInfo(userId);
        if (userInfo != null) goto L3;
        pw.println("Failure [user " + userId + " doesn't exist]");
        return 1;
    L16:
        pw.println("Error: Unknown option: " + opt);
        return 1;
    L18:
        int translatedUserId = translateUserId(userId, 0, "runGetDomainVerificationAgent");
        ComponentName domainVerificationAgent = this.mInterface.getDomainVerificationAgent(translatedUserId);     // Catch: Exception -> L22
        if (domainVerificationAgent != null) goto L24;
        String r7 = "No Domain Verifier available!";
    L25:
        pw.println(r7);     // Catch: Exception -> L22
        return 0;
    L24:
        r7 = domainVerificationAgent.flattenToString();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        pw.println("Failure [" + e.getMessage() + "]");
        return 1;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Package manager (package) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  path [--user USER_ID] PACKAGE");
        pw.println("    Print the path to the .apk of the given PACKAGE.");
        pw.println("");
        pw.println("  dump PACKAGE");
        pw.println("    Print various system state associated with the given PACKAGE.");
        pw.println("");
        pw.println("  dump-package PACKAGE");
        pw.println("    Print package manager state associated with the given PACKAGE.");
        pw.println("");
        pw.println("  compile-monitor-status");
        pw.println("    Print current compile-monitor service state.");
        pw.println("");
        pw.println("  compile-monitor-dumpstore [limit]");
        pw.println("    Print recent compile-monitor stored points.");
        pw.println("");
        pw.println("  has-feature FEATURE_NAME [version]");
        pw.println("    Prints true and returns exit status 0 when system has a FEATURE_NAME,");
        pw.println("    otherwise prints false and returns exit status 1");
        pw.println("");
        pw.println("  list features");
        pw.println("    Prints all features of the system.");
        pw.println("");
        pw.println("  list instrumentation [-f] [TARGET-PACKAGE]");
        pw.println("    Prints all test packages; optionally only those targeting TARGET-PACKAGE");
        pw.println("    Options:");
        pw.println("      -f: dump the name of the .apk file containing the test package");
        pw.println("");
        pw.println("  list libraries [-v]");
        pw.println("    Prints all system libraries.");
        pw.println("    Options:");
        pw.println("      -v: shows the location of the library in the device's filesystem");
        pw.println("");
        pw.println("  list packages [-f] [-d] [-e] [-s] [-q] [-3] [-i] [-l] [-u] [-U] ");
        pw.println("      [--show-versioncode] [--apex-only] [--factory-only]");
        pw.println("      [--uid UID] [--user USER_ID] [FILTER]");
        pw.println("    Prints all packages; optionally only those whose name contains");
        pw.println("    the text in FILTER.  Options are:");
        pw.println("      -f: see their associated file");
        pw.println("      -a: all known packages (but excluding APEXes)");
        pw.println("      -d: filter to only show disabled packages");
        pw.println("      -e: filter to only show enabled packages");
        pw.println("      -s: filter to only show system packages");
        pw.println("      -3: filter to only show third party packages");
        pw.println("      -i: see the installer for the packages");
        pw.println("      -l: ignored (used for compatibility with older releases)");
        pw.println("      -U: also show the package UID");
        pw.println("      -u: also include uninstalled packages");
        pw.println("      --show-versioncode: also show the version code");
        pw.println("      --apex-only: only show APEX packages");
        pw.println("      --factory-only: only show system packages excluding updates");
        pw.println("      --uid UID: filter to only show packages with the given UID");
        pw.println("      --user USER_ID: only list packages belonging to the given user");
        pw.println("      --match-libraries: include packages that declare static shared and SDK libraries");
        pw.println("");
        pw.println("  list permission-groups");
        pw.println("    Prints all known permission groups.");
        pw.println("");
        pw.println("  list permissions [-g] [-f] [-d] [-u] [GROUP]");
        pw.println("    Prints all known permissions; optionally only those in GROUP.  Options are:");
        pw.println("      -g: organize by group");
        pw.println("      -f: print all information");
        pw.println("      -s: short summary");
        pw.println("      -d: only list dangerous permissions");
        pw.println("      -u: list only the permissions users will see");
        pw.println("");
        pw.println("  list staged-sessions [--only-ready] [--only-sessionid] [--only-parent]");
        pw.println("    Prints all staged sessions.");
        pw.println("      --only-ready: show only staged sessions that are ready");
        pw.println("      --only-sessionid: show only sessionId of each session");
        pw.println("      --only-parent: hide all children sessions");
        pw.println("");
        pw.println("  list users");
        pw.println("    Prints all users.");
        pw.println("");
        pw.println("  resolve-activity [--brief] [--components] [--query-flags FLAGS]");
        pw.println("       [--user USER_ID] INTENT");
        pw.println("    Prints the activity that resolves to the given INTENT.");
        pw.println("");
        pw.println("  query-activities [--brief] [--components] [--query-flags FLAGS]");
        pw.println("       [--user USER_ID] INTENT");
        pw.println("    Prints all activities that can handle the given INTENT.");
        pw.println("");
        pw.println("  query-services [--brief] [--components] [--query-flags FLAGS]");
        pw.println("       [--user USER_ID] INTENT");
        pw.println("    Prints all services that can handle the given INTENT.");
        pw.println("");
        pw.println("  query-receivers [--brief] [--components] [--query-flags FLAGS]");
        pw.println("       [--user USER_ID] INTENT");
        pw.println("    Prints all broadcast receivers that can handle the given INTENT.");
        pw.println("");
        pw.println("  install [-rtfdg] [-i PACKAGE] [--user USER_ID|all|current]");
        pw.println("       [-p INHERIT_PACKAGE] [--install-location 0/1/2]");
        pw.println("       [--install-reason 0/1/2/3/4] [--originating-uri URI]");
        pw.println("       [--referrer URI] [--abi ABI_NAME] [--force-sdk]");
        pw.println("       [--preload] [--instant] [--full] [--dont-kill]");
        pw.println("       [--enable-rollback [0/1/2]]");
        pw.println("       [--force-uuid internal|UUID] [--pkg PACKAGE] [-S BYTES]");
        pw.println("       [--apex] [--non-staged] [--force-non-staged]");
        pw.println("       [--staged-ready-timeout TIMEOUT] [--ignore-dexopt-profile]");
        pw.println("       [--dexopt-compiler-filter FILTER]");
        pw.println("       [PATH [SPLIT...]|-]");
        pw.println("    Install an application.  Must provide the apk data to install, either as");
        pw.println("    file path(s) or '-' to read from stdin.  Options are:");
        pw.println("      -R: disallow replacement of existing application");
        pw.println("      -t: allow test packages");
        pw.println("      -i: specify package name of installer owning the app");
        pw.println("      -f: install application on internal flash");
        pw.println("      -d: allow version code downgrade (debuggable packages only)");
        pw.println("      -p: partial application install (new split on top of existing pkg)");
        pw.println("      -g: grant all runtime permissions");
        pw.println("      -S: size in bytes of package, required for stdin");
        pw.println("      --user: install under the given user.");
        pw.println("      --dont-kill: installing a new feature split, don't kill running app");
        pw.println("      --restrict-permissions: don't whitelist restricted permissions at install");
        pw.println("      --originating-uri: set URI where app was downloaded from");
        pw.println("      --referrer: set URI that instigated the install of the app");
        pw.println("      --pkg: specify expected package name of app being installed");
        pw.println("      --abi: override the default ABI of the platform");
        pw.println("      --instant: cause the app to be installed as an ephemeral install app");
        pw.println("      --full: cause the app to be installed as a non-ephemeral full app");
        pw.println("      --enable-rollback: enable rollbacks for the upgrade.");
        pw.println("          0=restore (default), 1=wipe, 2=retain");
        pw.println("      --rollback-impact-level: set device impact required for rollback.");
        pw.println("          0=low (default), 1=high, 2=manual only");
        pw.println("      --install-location: force the install location:");
        pw.println("          0=auto, 1=internal only, 2=prefer external");
        pw.println("      --install-reason: indicates why the app is being installed:");
        pw.println("          0=unknown, 1=admin policy, 2=device restore,");
        pw.println("          3=device setup, 4=user request");
        pw.println("      --update-ownership: request the update ownership enforcement");
        pw.println("      --force-uuid: force install on to disk volume with given UUID");
        pw.println("      --apex: install an .apex file, not an .apk");
        pw.println("      --non-staged: explicitly set this installation to be non-staged.");
        pw.println("          This flag is only useful for APEX installs that are implicitly");
        pw.println("          assumed to be staged.");
        pw.println("      --force-non-staged: force the installation to run under a non-staged");
        pw.println("          session, which may complete without requiring a reboot. This will");
        pw.println("          force a rebootless update even for APEXes that don't support it");
        pw.println("      --staged-ready-timeout: By default, staged sessions wait 60000");
        pw.println("          milliseconds for pre-reboot verification to complete when");
        pw.println("          performing staged install. This flag is used to alter the waiting");
        pw.println("          time. You can skip the waiting time by specifying a TIMEOUT of '0'");
        pw.println("      --ignore-dexopt-profile: if set, all profiles are ignored by dexopt");
        pw.println("          during the installation, including the profile in the DM file and");
        pw.println("          the profile embedded in the APK file. If an invalid profile is");
        pw.println("          provided during installation, no warning will be reported by `adb");
        pw.println("          install`.");
        pw.println("          This option does not affect later dexopt operations (e.g.,");
        pw.println("          background dexopt and manual `pm compile` invocations).");
        pw.println("      --dexopt-compiler-filter: the target compiler filter for dexopt during");
        pw.println("          the installation. The filter actually used may be different.");
        pw.println("          Valid values: one of the values documented in");
        pw.println("          https://source.android.com/docs/core/runtime/configure#compiler_filters");
        pw.println("          or 'skip'");
        pw.println("      --disable-auto-install-dependencies: if set, any missing shared");
        pw.println("          library dependencies will not be auto-installed");
        pw.println("");
        pw.println("  install-existing [--user USER_ID|all|current]");
        pw.println("       [--instant] [--full] [--wait] [--restrict-permissions] PACKAGE");
        pw.println("    Installs an existing application for a new user.  Options are:");
        pw.println("      --user: install for the given user.");
        pw.println("      --instant: install as an instant app");
        pw.println("      --full: install as a full app");
        pw.println("      --wait: wait until the package is installed");
        pw.println("      --restrict-permissions: don't whitelist restricted permissions");
        pw.println("");
        pw.println("  install-create [-lrtsfdg] [-i PACKAGE] [--user USER_ID|all|current]");
        pw.println("       [-p INHERIT_PACKAGE] [--install-location 0/1/2]");
        pw.println("       [--install-reason 0/1/2/3/4] [--originating-uri URI]");
        pw.println("       [--referrer URI] [--abi ABI_NAME] [--force-sdk]");
        pw.println("       [--preload] [--instant] [--full] [--dont-kill]");
        pw.println("       [--force-uuid internal|UUID] [--pkg PACKAGE] [--apex] [-S BYTES]");
        pw.println("       [--multi-package] [--staged] [--update-ownership]");
        pw.println("    Like \"install\", but starts an install session.  Use \"install-write\"");
        pw.println("    to push data into the session, and \"install-commit\" to finish.");
        pw.println("");
        pw.println("  install-write [-S BYTES] SESSION_ID SPLIT_NAME [PATH|-]");
        pw.println("    Write an apk into the given install session.  If the path is '-', data");
        pw.println("    will be read from stdin.  Options are:");
        pw.println("      -S: size in bytes of package, required for stdin");
        pw.println("");
        pw.println("  install-remove SESSION_ID SPLIT...");
        pw.println("    Mark SPLIT(s) as removed in the given install session.");
        pw.println("");
        pw.println("  install-add-session MULTI_PACKAGE_SESSION_ID CHILD_SESSION_IDs");
        pw.println("    Add one or more session IDs to a multi-package session.");
        pw.println("");
        pw.println("  install-set-pre-verified-domains SESSION_ID PRE_VERIFIED_DOMAIN... ");
        pw.println("    Specify a comma separated list of pre-verified domains for a session.");
        pw.println("");
        pw.println("  install-get-pre-verified-domains SESSION_ID");
        pw.println("    List all the pre-verified domains that are specified in a session.");
        pw.println("    The result list is comma separated.");
        pw.println("");
        pw.println("  install-commit SESSION_ID");
        pw.println("    Commit the given active install session, installing the app.");
        pw.println("");
        pw.println("  install-abandon SESSION_ID");
        pw.println("    Delete the given active install session.");
        pw.println("");
        pw.println("  set-install-location LOCATION");
        pw.println("    Changes the default install location.  NOTE this is only intended for debugging;");
        pw.println("    using this can cause applications to break and other undersireable behavior.");
        pw.println("    LOCATION is one of:");
        pw.println("    0 [auto]: Let system decide the best location");
        pw.println("    1 [internal]: Install on internal device storage");
        pw.println("    2 [external]: Install on external media");
        pw.println("");
        pw.println("  get-install-location");
        pw.println("    Returns the current install location: 0, 1 or 2 as per set-install-location.");
        pw.println("");
        pw.println("  move-package PACKAGE [internal|UUID]");
        pw.println("");
        pw.println("  move-primary-storage [internal|UUID]");
        pw.println("");
        pw.println("  uninstall [-k] [--user USER_ID] [--versionCode VERSION_CODE]");
        pw.println("       PACKAGE [SPLIT...]");
        pw.println("    Remove the given package name from the system.  May remove an entire app");
        pw.println("    if no SPLIT names specified, otherwise will remove only the splits of the");
        pw.println("    given app.  Options are:");
        pw.println("      -k: keep the data and cache directories around after package removal.");
        pw.println("      --user: remove the app from the given user.");
        pw.println("      --versionCode: only uninstall if the app has the given version code.");
        pw.println("");
        pw.println("  clear [--user USER_ID] [--cache-only] PACKAGE");
        pw.println("    Deletes data associated with a package. Options are:");
        pw.println("    --user: specifies the user for which we need to clear data");
        pw.println("    --cache-only: a flag which tells if we only need to clear cache data");
        pw.println("");
        pw.println("  enable [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("  disable [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("  disable-user [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("  disable-until-used [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("  default-state [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("    These commands change the enabled state of a given package or");
        pw.println("    component (written as \"package/class\").");
        pw.println("");
        pw.println("  hide [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("  unhide [--user USER_ID] PACKAGE_OR_COMPONENT");
        pw.println("");
        pw.println("  unstop [--user USER_ID] PACKAGE");
        pw.println("");
        pw.println("  suspend [--user USER_ID] PACKAGE [PACKAGE...]");
        pw.println("    Suspends the specified package(s) (as user).");
        pw.println("");
        pw.println("  unsuspend [--user USER_ID] PACKAGE [PACKAGE...]");
        pw.println("    Unsuspends the specified package(s) (as user).");
        pw.println("");
        pw.println("  set-distracting-restriction [--user USER_ID] [--flag FLAG ...]");
        pw.println("      PACKAGE [PACKAGE...]");
        pw.println("    Sets the specified restriction flags to given package(s) (for user).");
        pw.println("    Flags are:");
        pw.println("      hide-notifications: Hides notifications from this package");
        pw.println("      hide-from-suggestions: Hides this package from suggestions");
        pw.println("        (by the launcher, etc.)");
        pw.println("    Any existing flags are overwritten, which also means that if no flags are");
        pw.println("    specified then all existing flags will be cleared.");
        pw.println("");
        pw.println("  get-distracting-restriction [--user USER_ID] PACKAGE [PACKAGE...]");
        pw.println("    Gets the specified restriction flags of given package(s) (of the user).");
        pw.println("");
        pw.println("  grant [--user USER_ID] [--all-permissions] PACKAGE PERMISSION");
        pw.println("  revoke [--user USER_ID] [--all-permissions] PACKAGE PERMISSION");
        pw.println("    These commands either grant or revoke permissions to apps.  The permissions");
        pw.println("    must be declared as used in the app's manifest, be runtime permissions");
        pw.println("    (protection level dangerous), and the app targeting SDK greater than Lollipop MR1.");
        pw.println("    Flags are:");
        pw.println("    --user: Specifies the user for which the operation needs to be performed");
        pw.println("    --all-permissions: If specified all the missing runtime permissions will");
        pw.println("       be granted to the PACKAGE or to all the packages if none is specified.");
        pw.println("");
        pw.println("  set-permission-flags [--user USER_ID] PACKAGE PERMISSION [FLAGS..]");
        pw.println("  clear-permission-flags [--user USER_ID] PACKAGE PERMISSION [FLAGS..]");
        pw.println("    These commands either set or clear permission flags on apps.  The permissions");
        pw.println("    must be declared as used in the app's manifest, be runtime permissions");
        pw.println("    (protection level dangerous), and the app targeting SDK greater than Lollipop MR1.");
        pw.println("    The flags must be one or more of " + SUPPORTED_PERMISSION_FLAGS_LIST);
        pw.println("");
        pw.println("  reset-permissions");
        pw.println("    Revert all runtime permissions to their default state.");
        pw.println("");
        pw.println("  set-permission-enforced PERMISSION [true|false]");
        pw.println("");
        pw.println("  get-privapp-permissions TARGET-PACKAGE");
        pw.println("    Prints all privileged permissions for a package.");
        pw.println("");
        pw.println("  get-privapp-deny-permissions TARGET-PACKAGE");
        pw.println("    Prints all privileged permissions that are denied for a package.");
        pw.println("");
        pw.println("  get-oem-permissions TARGET-PACKAGE");
        pw.println("    Prints all OEM permissions for a package.");
        pw.println("");
        pw.println("  get-signature-permission-allowlist PARTITION");
        pw.println("    Prints the signature permission allowlist for a partition.");
        pw.println("    PARTITION is one of system, vendor, product, system-ext and apex");
        pw.println("");
        pw.println("  get-shared-uid-allowlist");
        pw.println("    Prints the shared UID allowlist.");
        pw.println("");
        pw.println("  trim-caches DESIRED_FREE_SPACE [internal|UUID]");
        pw.println("    Trim cache files to reach the given free space.");
        pw.println("");
        pw.println("  list users");
        pw.println("    Lists the current users.");
        pw.println("");
        pw.println("  create-user [--profileOf USER_ID] [--managed] [--restricted] [--guest]");
        pw.println("       [--user-type USER_TYPE] [--ephemeral] [--for-testing] [--pre-create-only]   USER_NAME");
        pw.println("    Create a new user with the given USER_NAME, printing the new user identifier");
        pw.println("    of the user.");
        pw.println("    USER_TYPE is the name of a user type, e.g. android.os.usertype.profile.MANAGED.");
        pw.println("      If not specified, the default user type is android.os.usertype.full.SECONDARY.");
        pw.println("      --managed is shorthand for '--user-type android.os.usertype.profile.MANAGED'.");
        pw.println("      --restricted is shorthand for '--user-type android.os.usertype.full.RESTRICTED'.");
        pw.println("      --guest is shorthand for '--user-type android.os.usertype.full.GUEST'.");
        pw.println("");
        pw.println("  remove-user [--set-ephemeral-if-in-use | --wait] USER_ID");
        pw.println("    Remove the user with the given USER_IDENTIFIER, deleting all data");
        pw.println("    associated with that user.");
        pw.println("      --set-ephemeral-if-in-use: If the user is currently running and");
        pw.println("        therefore cannot be removed immediately, mark the user as ephemeral");
        pw.println("        so that it will be automatically removed when possible (after user");
        pw.println("        switch or reboot)");
        pw.println("      --wait: Wait until user is removed. Ignored if set-ephemeral-if-in-use");
        pw.println("");
        pw.println("  mark-guest-for-deletion USER_ID");
        pw.println("    Mark the guest user for deletion. After this, it is possible to create a");
        pw.println("    new guest user and switch to it. This allows resetting the guest user");
        pw.println("    without switching to another user.");
        pw.println("");
        pw.println("  rename-user USER_ID [USER_NAME]");
        pw.println("    Rename USER_ID with USER_NAME (or null when [USER_NAME] is not set)");
        pw.println("");
        pw.println("  set-user-restriction [--user USER_ID] RESTRICTION VALUE");
        pw.println("");
        pw.println("  get-user-restriction [--user USER_ID] [--all] RESTRICTION_KEY");
        pw.println("    Display the value of restriction for the given restriction key if the");
        pw.println("    given user is valid.");
        pw.println("      --all: display all restrictions for the given user");
        pw.println("          This option is used without restriction key");
        pw.println("");
        pw.println("  get-max-users");
        pw.println("");
        pw.println("  get-max-running-users");
        pw.println("");
        pw.println("  set-home-activity [--user USER_ID] TARGET-COMPONENT");
        pw.println("    Set the default home activity (aka launcher).");
        pw.println("    TARGET-COMPONENT can be a package name (com.package.my) or a full");
        pw.println("    component (com.package.my/component.name). However, only the package name");
        pw.println("    matters: the actual component used will be determined automatically from");
        pw.println("    the package.");
        pw.println("");
        pw.println("  set-installer PACKAGE INSTALLER");
        pw.println("    Set installer package name");
        pw.println("");
        pw.println("  get-instantapp-resolver");
        pw.println("    Return the name of the component that is the current instant app installer.");
        pw.println("");
        pw.println("  set-harmful-app-warning [--user <USER_ID>] <PACKAGE> [<WARNING>]");
        pw.println("    Mark the app as harmful with the given warning message.");
        pw.println("");
        pw.println("  get-harmful-app-warning [--user <USER_ID>] <PACKAGE>");
        pw.println("    Return the harmful app warning message for the given app, if present");
        pw.println();
        pw.println("  uninstall-system-updates [<PACKAGE>]");
        pw.println("    Removes updates to the given system application and falls back to its");
        pw.println("    /system version. Does nothing if the given package is not a system app.");
        pw.println("    If no package is specified, removes updates to all system applications.");
        pw.println("");
        pw.println("  get-moduleinfo [--all | --installed] [module-name]");
        pw.println("    Displays module info. If module-name is specified only that info is shown");
        pw.println("    By default, without any argument only installed modules are shown.");
        pw.println("      --all: show all module info");
        pw.println("      --installed: show only installed modules");
        pw.println("");
        pw.println("  log-visibility [--enable|--disable] <PACKAGE>");
        pw.println("    Turns on debug logging when visibility is blocked for the given package.");
        pw.println("      --enable: turn on debug logging (default)");
        pw.println("      --disable: turn off debug logging");
        pw.println("");
        pw.println("  set-silent-updates-policy [--allow-unlimited-silent-updates <INSTALLER>]");
        pw.println("                            [--throttle-time <SECONDS>] [--reset]");
        pw.println("    Sets the policies of the silent updates.");
        pw.println("      --allow-unlimited-silent-updates: allows unlimited silent updated");
        pw.println("        installation requests from the installer without the throttle time.");
        pw.println("      --throttle-time: update the silent updates throttle time in seconds.");
        pw.println("      --reset: restore the installer and throttle time to the default, and");
        pw.println("        clear tracks of silent updates in the system.");
        pw.println("");
        pw.println("  clear-package-preferred-activities <PACKAGE>");
        pw.println("    Remove the preferred activity mappings for the given package.");
        pw.println("  wait-for-handler --timeout <MILLIS>");
        pw.println("    Wait for a given amount of time till the package manager handler finishes");
        pw.println("    handling all pending messages.");
        pw.println("      --timeout: wait for a given number of milliseconds. If the handler(s)");
        pw.println("        fail to finish before the timeout, the command returns error.");
        pw.println("");
        pw.println("  wait-for-background-handler --timeout <MILLIS>");
        pw.println("    Wait for a given amount of time till the package manager's background");
        pw.println("    handler finishes handling all pending messages.");
        pw.println("      --timeout: wait for a given number of milliseconds. If the handler(s)");
        pw.println("        fail to finish before the timeout, the command returns error.");
        pw.println("");
        pw.println("  archive [--user USER_ID] PACKAGE ");
        pw.println("    During the archival process, the apps APKs and cache are removed from the");
        pw.println("    device while the user data is kept. Options are:");
        pw.println("      --user: archive the app from the given user.");
        pw.println("");
        pw.println("  request-unarchive [--user USER_ID] PACKAGE ");
        pw.println("    Requests to unarchive a currently archived package by sending a request");
        pw.println("    to unarchive an app to the responsible installer. Options are:");
        pw.println("      --user: request unarchival of the app from the given user.");
        pw.println("");
        pw.println("  get-domain-verification-agent [--user USER_ID]");
        pw.println("    Displays the component name of the domain verification agent on device.");
        pw.println("    If the component isn't enabled, an error message will be displayed.");
        pw.println("      --user: return the agent of the given user (SYSTEM_USER if unspecified)");
        pw.println("  get-package-storage-stats [--user <USER_ID>] <PACKAGE>");
        pw.println("    Return the storage stats for the given app, if present");
        pw.println("");
        printArtServiceHelp();
        pw.println("");
        this.mDomainVerificationShell.printHelp(pw);
        pw.println("");
        Intent.printIntentArgsHelp(pw, "");
    }

    private void printArtServiceHelp() {
        IndentingPrintWriter ipw = new IndentingPrintWriter(getOutPrintWriter(), "  ");
        ipw.increaseIndent();
        ((ArtManagerLocal) LocalManagerRegistry.getManagerOrThrow(ArtManagerLocal.class)).printShellCommandHelp(ipw);     // Catch: LocalManagerRegistry.ManagerNotFoundException -> L5
    L7:
        ipw.decreaseIndent();
        return;
    L6:
        ipw.println("ART Service is not ready. Please try again later");
        goto L7
    }
}
