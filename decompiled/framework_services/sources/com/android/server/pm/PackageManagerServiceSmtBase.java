package com.android.server.pm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoSysEx;
import android.content.pm.PackageInstaller;
import android.os.BatteryManagerInternal;
import android.os.Binder;
import android.os.CommonWorkerThread;
import android.os.Message;
import android.os.Parcel;
import android.os.SystemProperties;
import android.resourcemanager.IEventsOwner;
import android.resourcemanager.IRm;
import android.resourcemanager.PkgLifeCycleData;
import android.resourcemanager.Rm;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.util.Xml;
import bytedanceos.os.PeroptWhiteListParser;
import bytedanceos.util.FeatLog;
import com.android.internal.os.BackgroundThread;
import com.android.internal.pm.parsing.pkg.PackageImpl;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.server.ISmartAnaly;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.pm.dex.DexoptOptions;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.utils.WatchedArrayMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerServiceSmtBase {
    protected static final String ACTION_PENDING_INTENT_PREINSTALL = "preinstall_app";
    protected static final String ACTION_PREINSTALL_APP_DONE = "smt.action.preinstall_done";
    protected static final boolean DEBUGGABLE = false;
    protected static final boolean DEBUG_ADB_INSTALL = true;
    protected static final boolean DEBUG_PACKAGE_LOCK = false;
    private static final String SAMRTISAN_PREINSTALL_CHECKED_PROPERTY = "persist.service.bytedance.preinstallchecked";
    static final String TAG = "PackageManager";
    protected static final String VENDOR_PREINSTALL_APP = "/oem/thirdapp";
    public static PackageManagerServiceSmtBase mInstance;
    public static ArraySet<String> mOverrideClazzIgnoreProcs;
    protected DexOptHelper mDexOptHelper;
    protected PeroptWhiteListParser mPeroptWhiteListParser;
    private PkgLifeCycleEventOwner mPkgLifeCycleEventOwner;
    protected PackageManagerService mPmService;
    protected PackageManagerServiceMonitorEx mPmServiceMonitorEx;

    private static class InstallReceiver extends BroadcastReceiver {
        int installCount;

        InstallReceiver(int count) {
            this.installCount = count;
            Slog.d("PackageManager", "preinstallchecked property: " + this.installCount);
            SystemProperties.set(PackageManagerServiceSmtBase.SAMRTISAN_PREINSTALL_CHECKED_PROPERTY, Integer.toString(this.installCount));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.installCount--;
            SystemProperties.set(PackageManagerServiceSmtBase.SAMRTISAN_PREINSTALL_CHECKED_PROPERTY, Integer.toString(this.installCount));
            Slog.d("PackageManager", "preinstallchecked property: " + this.installCount);
            if (this.installCount != 0) goto L6;
            Intent broadcast = new Intent();
            broadcast.setAction(PackageManagerServiceSmtBase.ACTION_PREINSTALL_APP_DONE);
            context.sendBroadcast(broadcast);
            context.unregisterReceiver(this);
            Slog.d("PackageManager", "sending preinstall done broadcast");
            return;
        }
    }

    class PkgLifeCycleEventOwner implements IEventsOwner {
        private IRm mRm;

        PkgLifeCycleEventOwner(PackageManagerServiceSmtBase this$0) {
            this.mRm = null;
            initRm();
        }

        public int obtainEventData(Parcel p, Parcel r) {
            Slog.e("AppStartEventOwner", "obtainEventData. do nothing now!");
            return 0;
        }

        public String getName() {
            return "PkgLifeCycleEventOwner";
        }

        public void notifyEvent(int uid, int type, String pkgName) {
            PkgLifeCycleData data = new PkgLifeCycleData(uid, type, pkgName);
            if (this.mRm != null) goto L5;
            initRm();
        L5:
            Parcel out = Parcel.obtain();
            data.writeToParcel(out, 0);     // Catch: Throwable -> L9
            this.mRm.notifyResEventData(FrameworkStatsLog.DISK_STATS, out);     // Catch: Throwable -> L9
            out.recycle();
            return;
        L9:
            th = move-exception;
            out.recycle();
            throw th;
        }

        private void initRm() {
            this.mRm = Rm.getInstance();
            this.mRm.connect();
            int[] events = {FrameworkStatsLog.DISK_STATS};
            this.mRm.registerResEvents(events, this);
        }
    }

    public static /* synthetic */ void $r8$lambda$EogiPPqHdTb8zij_KAyukntkQu0(PackageManagerServiceSmtBase r0) {
        r0.doCheckOtaUpgradeApp();
    }

    public static /* synthetic */ void $r8$lambda$LU2FkuKkEJAdqebgTNhNju17D7w(PackageManagerServiceSmtBase r0) {
        r0.doCheckPreinstallApp();
    }

    public static /* synthetic */ boolean $r8$lambda$NldwIBaQ7bLCioHcxCqVSw33Jj4(File r0, String r1) {
        return lambda$checkPreinstallApp$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$nesI2PG4VFA2LMwtHrol72qtt4M() {
        lambda$notifyPkgChangeEventToResManager$1();
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
    L6:
        r1 = true;
    L7:
        DEBUGGABLE = r1;
        mOverrideClazzIgnoreProcs = null;
        return;
    L5:
        if ("US".equals(SystemProperties.get("ro.build.region", "CN")) == false) goto L7;
        goto L6
    }

    protected PackageManagerServiceSmtBase(PackageManagerService pmService, PackageManagerServiceMonitorEx pmServiceMonitorEx, DexOptHelper dexOptHelper) {
        mInstance = this;
        this.mPmService = pmService;
        this.mPmServiceMonitorEx = pmServiceMonitorEx;
        this.mDexOptHelper = dexOptHelper;
        SysOptBridge.getFactory().getServiceHolder().initPms(this.mPmService);
    }

    public static PackageManagerServiceSmtBase getInstance() {
        return mInstance;
    }

    protected void BytedanceOSInit() {
        this.mPeroptWhiteListParser = PeroptWhiteListParser.getInstance();
    }

    public void onPackageScanned(ScanResult scanResult) {
        ParsedPackage r0 = scanResult.mPkgSetting.getPkg();
        if ((r0 instanceof ParsedPackage) == false) goto L15;
        String pkgName = scanResult.mPkgSetting.getPackageName();
        ApplicationInfoSysEx infoSmtBase = r0.getApplicationInfoSysEx();
        if (scanResult.mPkgSetting.isSystem() == false) goto L7;
    L12:
        boolean isPlatformApp = true;
    L13:
        PeroptWhiteListParser.updateMemFlags(pkgName, infoSmtBase, isPlatformApp);
        return;
    L7:
        if (scanResult.mPkgSetting.isSystemExt() == true) goto L12;
        if (scanResult.mPkgSetting.isPrivileged() == true) goto L12;
        isPlatformApp = false;
        goto L13
    }

    protected void updateBytedanceFlagValue(String pkgName, ApplicationInfoSysEx infoSmtEx, String verName) {
        if (this.mPeroptWhiteListParser == null) goto L5;
        this.mPeroptWhiteListParser.updateBytedanceFlagValue(pkgName, infoSmtEx, verName);
        return;
    L5:
        Slog.e("PackageManager", "mPeroptWhiteListParser is null");
    }

    protected void updateBytedanceFlagValue(ApplicationInfo info, String verName) {
        if (this.mPeroptWhiteListParser == null) goto L5;
        this.mPeroptWhiteListParser.updateBytedanceFlagValue(info, verName);
        return;
    L5:
        Slog.e("PackageManager", "mPeroptWhiteListParser is null");
    }

    public AndroidPackage getPackageInfo(String packageName) {
        PackageManagerTracedLock r1 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        AndroidPackage p = this.mPmService.mPackages.get(packageName);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return p;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    protected void updateBytedanceFlagValue(ApplicationInfoSysEx infoSmtEx, String packageName) {
        if (this.mPeroptWhiteListParser == null) goto L5;
        this.mPeroptWhiteListParser.updateBytedanceFlagValue(infoSmtEx, packageName);
        return;
    L5:
        Slog.e("PackageManager", "mPeroptWhiteListParser is null");
    }

    public void updatePackagesKilledTime(String packageName, int type, long time) {
        PackageManagerTracedLock r0 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public WatchedArrayMap<String, AndroidPackage> getPackageMap() {
        return this.mPmService.mPackages;
    }

    public void updateAppTypeInfo(String packageName, int flag) {
        int callingUid = Binder.getCallingUid();
        if (callingUid <= 1000) goto L5;
        return;
    L5:
        PackageManagerTracedLock r1 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        ApplicationInfo info = this.mPmService.snapshotComputer().getApplicationInfo(packageName, 1, 0);     // Catch: Throwable -> L14
        if (info == null) goto L18;
        int oldFlag = info.getSysEx().appTypeFlag;     // Catch: Throwable -> L14
        if (flag == 1) goto L12;
    L16:
        if (oldFlag == flag) goto L18;
        info.getSysEx().appTypeFlag = flag;     // Catch: Throwable -> L14
        goto L18
    L12:
        if ((1 & info.flags) == 0) goto L16;
        info.getSysEx().appTypeFlag = 2;     // Catch: Throwable -> L14
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void checkPreinstallApp() {
        if (this.mPmService.isDeviceUpgrading() == false) goto L6;
        CommonWorkerThread.getHandler().post(new PackageManagerServiceSmtBase$$ExternalSyntheticLambda0(this));
        return;
    L6:
        String propValue = SystemProperties.get(SAMRTISAN_PREINSTALL_CHECKED_PROPERTY, "not_set");
        Slog.d("PackageManager", "preinstallchecked property: " + propValue);
        int r4 = 0;
        if ("y".equals(propValue) == false) goto L11;
        SystemProperties.set(SAMRTISAN_PREINSTALL_CHECKED_PROPERTY, Integer.toString(0));
        Slog.d("PackageManager", "reset preinstallchecked property to 0, compatible with old logic");
        return;
    L11:
        if ("0".equals(propValue) == false) goto L14;
        Slog.d("PackageManager", "preinstallchecked return directly");
        return;
    L14:
        FilenameFilter filter = new PackageManagerServiceSmtBase$$ExternalSyntheticLambda1();
        File scanDir = new File("/data/app/");
        File[] r5 = scanDir.listFiles(filter);
        int r6 = r5.length;
    L16:
        if (r4 >= r6) goto L18;
        File file = r5[r4];
        Slog.d("PackageManager", "preinstallchecked delete " + file.toString());
        deleteDirectory(file);
        r4 = r4 + 1;
        goto L16
    L18:
        CommonWorkerThread.getHandler().post(new PackageManagerServiceSmtBase$$ExternalSyntheticLambda2(this));
    }

    private static /* synthetic */ boolean lambda$checkPreinstallApp$0(File dir, String name) {
        if (name.startsWith("vmdl") == true) goto L5;
    L7:
        return false;
    L5:
        if (name.endsWith(".tmp") == false) goto L7;
        return true;
    }

    public void parseAppRefreshRate(String jsonStr) {
        SysOptBridge.getFactory().getSmartService().parseAppRefreshRate(jsonStr);
    }

    private void doCheckPreinstallApp() {
    }

    private void doCheckOtaUpgradeApp() {
    }

    private void doInstall(List<File> apksToInstall) throws IOException {
        BroadcastReceiver receiver = new InstallReceiver(apksToInstall.size());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_PENDING_INTENT_PREINSTALL);
        this.mPmService.mContext.registerReceiver(receiver, intentFilter);
        PackageInstaller installer = this.mPmService.mContext.getPackageManager().getPackageInstaller();
        byte[] buffer = new byte[1048576];
        Iterator<File> r6 = apksToInstall.iterator();
    L4:
        if (r6.hasNext() == false) goto L22;
        File apk = r6.next();
        Slog.d("PackageManager", "doCheckPreinstallApp preinstalling " + apk.getAbsolutePath());
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
        sessionParams.installFlags = sessionParams.installFlags | 64;
        int sessionId = installer.createSession(sessionParams);
        PackageInstaller.Session session = installer.openSession(sessionId);
        InputStream in = new FileInputStream(apk);
        long sizeBytes = apk.length();
        BroadcastReceiver receiver2 = receiver;
        InputStream in2 = in;
        OutputStream out = session.openWrite(ACTION_PENDING_INTENT_PREINSTALL, 0, sizeBytes);
    L25:
        int c = in2.read(buffer);     // Catch: Throwable -> L18
        in2 = in2;
        if (c == (-1)) goto L16;
        out.write(buffer, 0, c);     // Catch: Throwable -> L13
        if (sizeBytes <= 0) goto L25;
        float fraction = c / sizeBytes;     // Catch: Throwable -> L13
        session.addProgress(fraction);     // Catch: Throwable -> L13
    L13:
        th = th;
    L20:
        closeQuietly(in2);
        closeQuietly(out);
        throw th;
    L16:
        session.fsync(out);     // Catch: Throwable -> L13
        closeQuietly(in2);
        closeQuietly(out);
        Intent broadcastIntent = new Intent(ACTION_PENDING_INTENT_PREINSTALL);
        broadcastIntent.setPackage(this.mPmService.mContext.getPackageName());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mPmService.mContext, sessionId, broadcastIntent, 134217728);
        session.commit(pendingIntent.getIntentSender());
        receiver = receiver2;
    L18:
        th = th;
        in2 = in2;
        goto L20
    }

    private static void closeQuietly(AutoCloseable closeable) {
        if (closeable != null) goto L10;
        return;
    L10:
        closeable.close();     // Catch: Exception -> L5 RuntimeException -> L7
        goto L13
    L12:
        return;
    L7:
        rethrown = move-exception;
        throw rethrown;
    }

    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) goto L12;
        int r1 = files.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        File file = files[r2];
        if (file.isDirectory() == true) goto L10;
        file.delete();
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        deleteDirectory(file);
    L12:
        directory.delete();
    }

    public void handleMessageSmt(Message msg) {
        handleMessageSmt(msg, this.mDexOptHelper);
    }

    public void handleMessageSmt(Message msg, DexOptHelper dexOptHelper) {
        switch(msg.what) {
            case 200: goto L5;
            default: goto L49;
        };
    L5:
        Map<String, DexoptOptions> r0 = PackageManagerServiceMonitorEx.pendingDexoptMap;
        monitor-enter(r0);
        Iterator<Map.Entry<String, DexoptOptions>> it = PackageManagerServiceMonitorEx.pendingDexoptMap.entrySet().iterator();     // Catch: Throwable -> L15 Exception -> L22
    L10:
        if (it.hasNext() == false) goto L32;
        if (PackageManagerServiceMonitorEx.sDexoptResumed == false) goto L13;
        BatteryManagerInternal mBatteryManagerInternal = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);     // Catch: Throwable -> L15 Exception -> L22
        int batteryLevel = mBatteryManagerInternal.getBatteryLevel();     // Catch: Throwable -> L15 Exception -> L22
        if (batteryLevel < 20) goto L19;
        Map.Entry<String, DexoptOptions> item = it.next();     // Catch: Throwable -> L15 Exception -> L22
        ISmartAnaly analysis = SysOptBridge.getFactory().getSmtAnalysis();     // Catch: Throwable -> L15 Exception -> L22
        if (analysis.checkFileLock(item.getKey()) == true) goto L26;
        boolean success = dexOptHelper.performDexOpt(item.getValue());     // Catch: Throwable -> L15 Exception -> L22
        if (success == false) goto L30;
        FeatLog.d("PackageManager", "FEAT_DELAY_DEX2OAT", 10, "idle dexopt success pkg:" + item.getKey());     // Catch: Throwable -> L15 Exception -> L22
    L31:
        it.remove();     // Catch: Throwable -> L15 Exception -> L22
        goto L10
    L30:
        FeatLog.e("PackageManager", "FEAT_DELAY_DEX2OAT", 10, "idle dexopt failure pkg:" + item.getKey());     // Catch: Throwable -> L15 Exception -> L22
        goto L31
    L26:
        analysis.AnalysisFlock(item.getKey());     // Catch: Throwable -> L15 Exception -> L22
        FeatLog.w("PackageManager", "FEAT_DELAY_DEX2OAT", 0, "file lock warning give up:" + item.getKey());     // Catch: Throwable -> L15 Exception -> L22
        goto L10
    L19:
        FeatLog.w("PackageManager", "FEAT_DELAY_DEX2OAT", 0, "battery level low, dexopt delayed batterylevel:" + batteryLevel);     // Catch: Throwable -> L15 Exception -> L22
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L32:
        PackageManagerServiceMonitorEx.stopIdleDex2oat();     // Catch: Throwable -> L15 Exception -> L22
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L22:
        e = move-exception;
        PackageManagerServiceMonitorEx.stopIdleDex2oat();     // Catch: Throwable -> L15
        FeatLog.e("PackageManager", "FEAT_DELAY_DEX2OAT", 0, "Exception for dexopt " + e.getMessage());     // Catch: Throwable -> L15
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean performDexOptModeSmt(String r4, boolean r5, String r6, boolean r7, boolean r8, String r9, boolean r10) {
        if (r7 == false) goto L5;
        char r1 = 2;
    L6:
        boolean r2 = r1 | (r5 ? 1 : 0);
        if (r8 == false) goto L9;
        char r3 = 4;
    L10:
        boolean r11 = (r2 ? 1 : 0) | r3;
        return false;
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public void updatePackagesInWhiteList(int type) {
        PackageManagerTracedLock r0 = this.mPmService.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void clearOverrideFlag(String packageName) {
        WatchedArrayMap<String, AndroidPackage> r0 = this.mPmService.mPackages;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean refuseOverrideSdkClazz(String proc) {
        File file = new File("/data/system/overrideSdk.xml");     // Catch: Exception -> L22
        if (mOverrideClazzIgnoreProcs != null) goto L37;
        if (file.exists() == false) goto L37;
        mOverrideClazzIgnoreProcs = new ArraySet(4);     // Catch: Exception -> L22
        FileInputStream str = new FileInputStream("/data/system/overrideSdk.xml");     // Catch: Exception -> L22
        XmlPullParser parser = Xml.newPullParser();     // Catch: Exception -> L22
        parser.setInput(str, StandardCharsets.UTF_8.name());     // Catch: Exception -> L22
    L8:
        int type = parser.next();     // Catch: Exception -> L22
        if (type == 2) goto L12;
        if (type != 1) goto L8;
    L12:
        if (type == 2) goto L14;
        return false;
    L14:
        int outerDepth = parser.getDepth();     // Catch: Exception -> L22
    L15:
        int type2 = parser.next();     // Catch: Exception -> L22
        if (type2 == 1) goto L33;
        if (type2 == 3) goto L20;
    L25:
        if (type2 == 3) goto L15;
        if (type2 == 4) goto L15;
        String tagName = parser.getName();     // Catch: Exception -> L22
        if (tagName.equals(Settings.ATTR_PACKAGE) == false) goto L31;
        String name = parser.getAttributeValue(null, "closeOverrideProc");     // Catch: Exception -> L22
        mOverrideClazzIgnoreProcs.add(name);     // Catch: Exception -> L22
        goto L15
    L31:
        XmlUtils.skipCurrentTag(parser);     // Catch: Exception -> L22
        goto L15
    L20:
        if (parser.getDepth() > outerDepth) goto L25;
    L33:
        str.close();     // Catch: Exception -> L22
    L37:
        if (mOverrideClazzIgnoreProcs != null) goto L39;
    L41:
        return false;
    L39:
        if (mOverrideClazzIgnoreProcs.contains(proc) == false) goto L41;
        return true;
    L35:
        Slog.e("PackageManager", "refuseOverrideSdkClazz failed");
        goto L37
    }

    public void updateOverrideSdkClazzClose() {
        WatchedArrayMap<String, AndroidPackage> r0 = this.mPmService.mPackages;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void updateAppInfo(String packageName, String appInfoJsonConfig, long appLastTime, boolean removeUnityChoreographerVsync, boolean permissionFlag, boolean isDexApp) {
        WatchedArrayMap<String, AndroidPackage> r0 = this.mPmService.mPackages;
        monitor-enter(r0);
        Slog.e("PackageManager", "package updateAppInfo  appInfoJsonConfig " + appInfoJsonConfig);     // Catch: Throwable -> L7
        PackageImpl pkgHidden = (AndroidPackage) this.mPmService.mPackages.get(packageName);     // Catch: Throwable -> L7
        if (pkgHidden == null) goto L9;
        pkgHidden.appInfoJsonConfig = appInfoJsonConfig;     // Catch: Throwable -> L7
        pkgHidden.appLastTime = appLastTime;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyPkgChangeEventToResManager(int uid, int type, String packageName) {
        if (this.mPkgLifeCycleEventOwner != null) goto L6;
        this.mPkgLifeCycleEventOwner = new PkgLifeCycleEventOwner(this);
    L6:
        if (this.mPkgLifeCycleEventOwner != null) goto L9;
        Log.i("PackageManager", "notifyPkgLifeCycleEvent. mPkgLifeCycleEventOwner == null.");
        return;
    L9:
        Log.i("PackageManager", "notifyPkgLifeCycleEvent uid=" + uid + ", pkg=" + packageName + ".");
        this.mPkgLifeCycleEventOwner.notifyEvent(uid, type, packageName);
        BackgroundThread.getHandler().postDelayed(new PackageManagerServiceSmtBase$$ExternalSyntheticLambda3(), 0);
    }

    private static /* synthetic */ void lambda$notifyPkgChangeEventToResManager$1() {
    }
}
