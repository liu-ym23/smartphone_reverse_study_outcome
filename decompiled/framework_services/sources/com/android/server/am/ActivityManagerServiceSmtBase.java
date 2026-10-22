package com.android.server.am;

import android.app.ActivityManagerInternalSmtEx;
import android.app.ApplicationErrorReport;
import android.app.IActivityManagerSmtEx;
import android.app.ISysClient;
import android.app.SysMonitorFwBridge;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.resourcemanager.AppRecordData;
import android.resourcemanager.IEventsCallBack;
import android.resourcemanager.IEventsOwner;
import android.resourcemanager.IRm;
import android.resourcemanager.Rm;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.BoostFramework;
import android.util.EventsUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import bytedanceos.api.ApplicationInfoSmt;
import bytedanceos.os.BinderCallCacheAgentOpt;
import bytedanceos.util.FeatLog;
import com.android.internal.app.IBatteryStats;
import com.android.internal.app.ProcessMap;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.FastXmlSerializer;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.MemInfoReader;
import com.android.server.IActivityManagerOptEx;
import com.android.server.IGameBalanceService;
import com.android.server.ISmtResourceControl;
import com.android.server.ISysPerfMonitorService;
import com.android.server.ITransferController;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SysDataSyncServiceManager;
import com.android.server.SysOptBridge;
import com.android.server.SystemServiceManager;
import com.android.server.TransferInternal;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.resmng.IResMngConfig;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.wm.ActivityRecord;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowProcessController;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.json.JSONObject;
import org.tukaani.xz.LZMA2Options;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ActivityManagerServiceSmtBase {
    static final int BLOCK_LOGO_STAGE_HOME_CRASH = 8;
    static final int CHECK_HOME_APP_CRASH_MIN_COUNT = 6;
    static final long CHECK_HOME_APP_CRASH_TIME_MS = 60000;
    private static final long CHECK_TASK_DEFAULT_TIME = 1000000;
    static final String CUSTOM_ERROR_TYPE_FROZEN_OBJECT = "process_frozen";
    public static final String DEX_FILE_OPT = "persist.sys.dexfile.opt";
    static final String FROZEN_OBJECT_TAG = "FrozenObject";
    static final int HARD_CLEAN_TIMEOUT = 1002;
    public static final boolean IS_USER_BUILD = false;
    static final int KILL_APP_SET_MSG = 2004;
    private static final String LAUNCHER_PKGNAME = "com.bytedanceos.launcher";
    static final int PREFETCH_PREDICTED_APP_NUM = 1;
    static final float PREFETCH_PROBABILITY_THRESHOULD = 0.5f;
    private static final String SETTING_DATA_APP_LAUNCH_PREDICT = "maybe_launch_pkg_from_predict_result";
    private static final String SETTING_DATA_PREDICT_NEXT_APP = "NEXT_LAUNCH_APP_PREDICT_RESULT";
    private static final String SETTING_DATA_PREDICT_SCENE_APP = "pre_warm_app_list";
    private static final long SHOULD_BE_REBOOT_UP_TIME = 300000;
    public static final int SYSTEM_MASK = 129;
    protected static final String TAG = "ActivityManagerService";
    static final String TAG_FREEZE = "ActivityManagerService";
    private static final String TRIM_TAG = "xbTrimMemory";
    static final int UPDATE_HAS_ONGOING_NOTI = 303;
    static final int UPDATE_OOM_MSG = 2001;
    static final int UPDATE_OOM_TIME = 50;
    private static boolean debug3rd = false;
    public static int isDexFileOptOn = 0;
    private static ArraySet<String> mOverrideClazzCrashProcs = null;
    private static ArraySet<String> mOverrideClazzsFiles = null;
    private static String mPackageCache = null;
    protected static IActivityManagerOptEx mSmtOptEx = null;
    private static long sAvaBase = 0;
    private static ActivityManagerServiceSysMoEx.CpuStateProvider sCpuStateProvider = null;
    private static long sFreeBase = 0;
    private static HashMap<String, Long> sPackageRequireAvaMap = null;
    private static HashMap<String, Long> sPackageRequireFreeMap = null;
    private static HashMap<String, Integer> sPackageStartTimeMap = null;
    private static int sReleaseAvaCoefficient = 0;
    private static int sReleaseFreeCoefficient = 0;
    private static int sRequireAvaCoefficient = 0;
    private static int sRequireFreeCoefficient = 0;
    static final int sSystemMask = 129;
    private static HashSet<String> sTargetPackage;
    private static boolean sTrimDebugEnable;
    protected static UidCpuUsageProvider sUidCpuUsageProvider;
    final String DES_EMPTY;
    private final int NOTIFY_DONE;
    private final int NOTIFY_INVALID;
    private final int NOTIFY_PARCEL_DATA;
    private final int NOTIFY_STAT_BUFF;
    private FindSvpThreadHandle findSvpThread;
    private IKillingStats killStats;
    protected ActivityManagerService mActivityManagerService;
    private App3rdPerceptibleStateOwner mApp3rdPerceptibleStateOwner;
    private final ContentObserver mAppLaunchPredict;
    private AppStartEventOwner mAppStartEventOwner;
    boolean mBDReceiverStatsEnabled;
    IBinderStat mBinderStat;
    public WindowProcessController mBytedanceHomeProcess;
    long mCachedPss;
    protected final AtomicFile mChainBootBlackListFile;
    private Runnable mCheckForceCpusetProcTask;
    protected boolean mCleaningProcesses;
    ProcessRecord mFocusedApp;
    private HashMap<Integer, ForceCpusetProc> mForceCpusetProcs;
    public boolean mHardClean;
    private int mHomeAppCrashCount;
    private long mHomeAppCrashedTime;
    private boolean mIsReporting;
    private KillingPriorityComparator mKPC;
    private String mLaunchingPackageName;
    private String mLaunchingProcessName;
    public IMemoryProcessController mMemProcessController;
    private final ContentObserver mNextAppPredict;
    protected long mNextUpdateOomTime;
    private boolean mPostedCheckCpusetTask;
    private final ContentObserver mPredictSceneApp;
    protected ActivityManagerServiceSysMoEx.CpuStateObserver mPrefetchCpuObServer;
    ActivityManagerService.PidMap mPrefetchPidsSelf;
    IProcessIntercept mProcessIntercept;
    private IProcessStatusChecker mProcessStatusChecker;
    int mSetupWizardState;
    public int mStrictModeFlags;
    long mTotalEGL;
    long mTotalPss;
    ITransferController mTransferService;
    Object mUserIsMonkeyLock;
    volatile boolean mUserIsMonkeySmt;

    /* JADX INFO: renamed from: com.android.server.am.ActivityManagerServiceSmtBase$3, reason: invalid class name */
    class AnonymousClass3 extends ContentObserver {
        final /* synthetic */ ActivityManagerServiceSmtBase this$0;

        public static /* synthetic */ int $r8$lambda$xPYYKXDQU7by6DKxQdnMSOusqik(Pair r0, Pair r1) {
            return lambda$onChange$0(r0, r1);
        }

        AnonymousClass3(ActivityManagerServiceSmtBase this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            ActivityManagerService r2 = this.this$0.mActivityManagerService;
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
            String predictedData = Settings.Global.getString(this.this$0.mActivityManagerService.mContext.getContentResolver(), ActivityManagerServiceSmtBase.SETTING_DATA_APP_LAUNCH_PREDICT);     // Catch: Throwable -> L9
            if (predictedData.isEmpty() == false) goto L11;
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            List<ApplicationInfo> allApk = new ArrayList();     // Catch: Throwable -> L9
            PackageManager pm = this.this$0.mActivityManagerService.mContext.getPackageManager();     // Catch: Throwable -> L9
            if (pm == null) goto L14;
            List<ApplicationInfo> allApk2 = pm.getInstalledApplications(9344);     // Catch: Throwable -> L9
        L15:
            if (allApk2 == null) goto L86;
            if (allApk2.isEmpty() == true) goto L86;
            ArrayList<Pair<String, Float>> possiblePkgs = new ArrayList();     // Catch: Throwable -> L9
            JSONObject json = new JSONObject(predictedData.substring(predictedData.indexOf("{"), predictedData.lastIndexOf("}") + 1));     // Catch: Throwable -> L9 Exception -> L37
            int timeBits = json.getInt("time");     // Catch: Throwable -> L9 Exception -> L37
            int hour = -1;
            int i = 0;
        L23:
            if (i >= 24) goto L28;
            if (((timeBits >> i) & 1) == 1) goto L26;
            i = i + 1;     // Catch: Throwable -> L9 Exception -> L37
            goto L23
        L26:
            hour = i;
        L28:
            JSONObject appJson = json.getJSONObject("app");     // Catch: Throwable -> L9 Exception -> L37
            if (appJson.length() == 0) goto L78;
            if (hour == (-1)) goto L78;
            String tmpStr = new String();     // Catch: Throwable -> L9 Exception -> L37
            Iterator<ApplicationInfo> r12 = allApk2.iterator();     // Catch: Throwable -> L9 Exception -> L37
        L35:
            if (r12.hasNext() == false) goto L39;
            ApplicationInfo info = r12.next();     // Catch: Throwable -> L9 Exception -> L37
            tmpStr = (tmpStr + info.packageName) + ", ";     // Catch: Throwable -> L9 Exception -> L37
            goto L35
        L39:
            Iterator<ApplicationInfo> r13 = allApk2.iterator();     // Catch: Throwable -> L9 Exception -> L37
        L40:
            if (r13.hasNext() == false) goto L50;
            ApplicationInfo info2 = r13.next();     // Catch: Throwable -> L9 Exception -> L37
            String pkg = info2.packageName;     // Catch: Throwable -> L9 Exception -> L37
            if (appJson.has(pkg) == false) goto L47;
            possiblePkgs.add(new Pair(pkg, Float.valueOf((float) appJson.getDouble(pkg))));     // Catch: Throwable -> L9 Exception -> L37
        L47:
            tmpStr = tmpStr;
            goto L40
        L50:
            if (possiblePkgs.isEmpty() == false) goto L55;
            Slog.w("ActivityManagerService", "updatePrefetchApps: json is not empty but pkgs don't exist");     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L55:
            possiblePkgs.sort(new ActivityManagerServiceSmtBase$3$$ExternalSyntheticLambda0());     // Catch: Throwable -> L9
            SysOptBridge.getFactory().getSysPrefetchService().uploadPredictHoursDataAsync(possiblePkgs, hour);     // Catch: Throwable -> L9
            List<String> targetApps = new ArrayList();     // Catch: Throwable -> L9
            int n = 2;
            Iterator<Pair<String, Float>> r9 = possiblePkgs.iterator();     // Catch: Throwable -> L9
        L57:
            if (r9.hasNext() == false) goto L66;
            Pair<String, Float> pairs = r9.next();     // Catch: Throwable -> L9
            n = n - 1;     // Catch: Throwable -> L9
            if (n <= 0) goto L66;
            if (((Float) pairs.second).floatValue() < ActivityManagerServiceSmtBase.PREFETCH_PROBABILITY_THRESHOULD) goto L66;
            targetApps.add((String) pairs.first);     // Catch: Throwable -> L9
        L66:
            Slog.d("ActivityManagerService", "updatePrefetchApps: recv sortedApps:" + targetApps + " hour:" + hour);     // Catch: Throwable -> L9
        L73:
            e = move-exception;
            Slog.e("ActivityManagerService", "updatePrefetchApps: call ISmtEx error!", e);     // Catch: Throwable -> L9
        L75:
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L68:
            if (SystemClock.uptimeMillis() > 300000) goto L70;
            int flag = 0;
        L71:
            this.this$0.updatePrefetchApps(targetApps, hour, flag);     // Catch: Throwable -> L9 Exception -> L73
        L70:
            flag = 1;
            goto L71
        L78:
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L37:
            e = move-exception;
            Slog.e("ActivityManagerService", "updatePrefetchApps: parse json error!", e);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L86:
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L14:
            allApk2 = allApk;
        L9:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private static /* synthetic */ int lambda$onChange$0(Pair pair1, Pair pair2) {
            return ((Float) pair2.second).compareTo((Float) pair1.second);
        }
    }

    class App3rdPerceptibleState {
        boolean isSounding;
        boolean isTop;
        long perceptibleTime;
        String pkg;
        int uid;

        App3rdPerceptibleState(ActivityManagerServiceSmtBase this$0) {
            this.uid = -1;
            this.pkg = "";
            this.perceptibleTime = 0;
            this.isTop = false;
            this.isSounding = false;
        }
    }

    class App3rdPerceptibleStateOwner {
        private ConcurrentHashMap<String, App3rdPerceptibleState> mApp3rdPerceptibleStateMap;
        private Map<Integer, EventHandler> mEventHandlers;
        private Handler mHandler;
        private IEventsCallBack mTestCallBack;
        final /* synthetic */ ActivityManagerServiceSmtBase this$0;

        /* JADX INFO: renamed from: com.android.server.am.ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$1, reason: invalid class name */
        class AnonymousClass1 implements IEventsCallBack {
            final /* synthetic */ App3rdPerceptibleStateOwner this$1;

            public static /* synthetic */ void $r8$lambda$3wvnyvjPEPmDdDhsUhu509GPSUA(AnonymousClass1 r0, Parcel r1, int r2) {
                r0.lambda$onEventHandle$0(r1, r2);
            }

            AnonymousClass1(App3rdPerceptibleStateOwner this$1) {
                this.this$1 = this$1;
            }

            public String getName() {
                return "App3rdPerceptibleStateOwner";
            }

            public void onEventHandle(final int event, final Parcel messageData) {
                App3rdPerceptibleStateOwner.m1237$$Nest$fgetmHandler(this.this$1).post(new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$1$$ExternalSyntheticLambda0(this, messageData, event));
            }

            private /* synthetic */ void lambda$onEventHandle$0(Parcel messageData, int event) {
                messageData.setDataPosition(0);
                AppRecordData data = new AppRecordData(messageData);
                EventHandler handler = (EventHandler) App3rdPerceptibleStateOwner.m1236$$Nest$fgetmEventHandlers(this.this$1).get(Integer.valueOf(event));
                if (handler == null) goto L6;
                handler.handle(data);
                return;
            }
        }

        public static /* synthetic */ void $r8$lambda$17avwTtL1LKKjHjEiwJkFwikqnM(App3rdPerceptibleStateOwner r0, AppRecordData r1) {
            r0.handleUidTopEvent(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$3CipQY7i2Wi3H-AtLyXd8bPbfyc, reason: not valid java name */
        public static /* synthetic */ App3rdPerceptibleState m1234$r8$lambda$3CipQY7i2Wi3HAtLyXd8bPbfyc(App3rdPerceptibleStateOwner r0, int r1, Consumer r2, String r3, App3rdPerceptibleState r4) {
            return r0.lambda$updateState$3(r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$XeAP6ZRwicGK1Z9WLHIRxsOBado(App3rdPerceptibleStateOwner r0, AppRecordData r1) {
            r0.handleAppStateEvent(r1);
        }

        public static /* synthetic */ void $r8$lambda$ZP9n9l0kVhoeaNC8f5Hxt3mG6TY(App3rdPerceptibleStateOwner r0, AppRecordData.UidTopInfo r1, App3rdPerceptibleState r2) {
            r0.lambda$handleUidTopEvent$0(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$kZq9E8PoSuNdIyxoVwsTKUUU7Xk(App3rdPerceptibleStateOwner r0, AppRecordData r1) {
            r0.handleAudioEvent(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$lxhdx8hTKs3u0JBlFVUML-2ZT9A, reason: not valid java name */
        public static /* synthetic */ App3rdPerceptibleState m1235$r8$lambda$lxhdx8hTKs3u0JBlFVUML2ZT9A(App3rdPerceptibleStateOwner r0, String r1, App3rdPerceptibleState r2) {
            return r0.lambda$handleAppStateEvent$2(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$zXkhVbgd7IjUZBYHK6IyyVzujg8(App3rdPerceptibleStateOwner r0, AppRecordData.AudioSceneInfo r1, App3rdPerceptibleState r2) {
            r0.lambda$handleAudioEvent$1(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEventHandlers, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m1236$$Nest$fgetmEventHandlers(App3rdPerceptibleStateOwner r0) {
            return r0.mEventHandlers;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ Handler m1237$$Nest$fgetmHandler(App3rdPerceptibleStateOwner r0) {
            return r0.mHandler;
        }

        private void handleUidTopEvent(AppRecordData data) {
            final AppRecordData.UidTopInfo uidTopInfo = data.getUidTopInfo();
            if (uidTopInfo != null) goto L5;
            return;
        L5:
            updateState(uidTopInfo.pkgName, uidTopInfo.uid, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda0(this, uidTopInfo));
        }

        private /* synthetic */ void lambda$handleUidTopEvent$0(AppRecordData.UidTopInfo uidTopInfo, App3rdPerceptibleState state) {
            logStateInfo(state, "handleUidTopEvent");
            if (uidTopInfo.isTop == false) goto L5;
            state.perceptibleTime = 0;
            state.isTop = true;
            return;
        L5:
            state.isTop = false;
            if (state.isSounding == true) goto L10;
            state.perceptibleTime = SystemClock.elapsedRealtime();
            return;
        }

        private void handleAudioEvent(AppRecordData data) {
            final AppRecordData.AudioSceneInfo audioSceneInfo = data.getAudioSceneInfo();
            if (audioSceneInfo != null) goto L5;
            return;
        L5:
            updateState(audioSceneInfo.pkgName, audioSceneInfo.uid, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda5(this, audioSceneInfo));
        }

        private /* synthetic */ void lambda$handleAudioEvent$1(AppRecordData.AudioSceneInfo audioSceneInfo, App3rdPerceptibleState state) {
            logStateInfo(state, "handleAudioEvent");
            if (audioSceneInfo.hold == false) goto L5;
            state.perceptibleTime = 0;
            state.isSounding = true;
            return;
        L5:
            state.isSounding = false;
            if (state.isTop == true) goto L10;
            state.perceptibleTime = SystemClock.elapsedRealtime();
            return;
        }

        private void handleAppStateEvent(AppRecordData data) {
            AppRecordData.AppStateInfo appStateInfo = data.getAppStateInfo();
            if (appStateInfo != null) goto L5;
            return;
        L5:
            this.mApp3rdPerceptibleStateMap.computeIfPresent(appStateInfo.pkgName, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda6(this));
        }

        private /* synthetic */ App3rdPerceptibleState lambda$handleAppStateEvent$2(String pkgName, App3rdPerceptibleState existingState) {
            logStateInfo(existingState, "handleAppStateEvent");
            return null;
        }

        private void updateState(String pkgName, final int uid, final Consumer<App3rdPerceptibleState> stateUpdater) {
            this.mApp3rdPerceptibleStateMap.compute(pkgName, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda4(this, uid, stateUpdater));
        }

        private /* synthetic */ App3rdPerceptibleState lambda$updateState$3(int uid, Consumer stateUpdater, String pkg, App3rdPerceptibleState existingState) {
            if (existingState == null) goto L4;
            App3rdPerceptibleState state = existingState;
        L5:
            stateUpdater.accept(state);
            return state;
        L4:
            state = createNewState(pkg, uid);
            goto L5
        }

        private App3rdPerceptibleState createNewState(String pkgName, int uid) {
            App3rdPerceptibleState newState = new App3rdPerceptibleState(this.this$0);
            newState.uid = uid;
            newState.pkg = pkgName;
            return newState;
        }

        private void logStateInfo(App3rdPerceptibleState state, String source) {
            if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L7;
            if (state == null) goto L8;
            Slog.i("ActivityManagerService", "source: " + source + " uid:" + state.uid + " getInfoSys:" + state + " time:" + state.perceptibleTime + " isTop:" + state.isTop + " isSounding:" + state.isSounding);
            return;
        L8:
            return;
        }

        App3rdPerceptibleStateOwner(ActivityManagerServiceSmtBase this$0) {
            this.this$0 = this$0;
            this.mApp3rdPerceptibleStateMap = new ConcurrentHashMap();
            this.mHandler = new MyHandler(this.this$0, BackgroundThread.getHandler().getLooper());
            this.mEventHandlers = new HashMap();
            this.mTestCallBack = new AnonymousClass1(this);
            initEventHandler();
            initRm();
        }

        private void initEventHandler() {
            this.mEventHandlers.put(10014, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda1(this));
            this.mEventHandlers.put(12001, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda2(this));
            this.mEventHandlers.put(10004, new ActivityManagerServiceSmtBase$App3rdPerceptibleStateOwner$$ExternalSyntheticLambda3(this));
        }

        private void initRm() {
            IRm rm = Rm.getInstance();
            rm.connect();
            int[] type = {10014, 12001, 10004};
            rm.setEventCallback(type, this.mTestCallBack);
        }

        public boolean goodToOperateProc(String pkg) {
            ConcurrentHashMap<String, App3rdPerceptibleState> r0 = this.mApp3rdPerceptibleStateMap;
            monitor-enter(r0);
            App3rdPerceptibleState state = this.mApp3rdPerceptibleStateMap.get(pkg);     // Catch: Throwable -> L14
            if (state == null) goto L25;
            if ("".equals(state.pkg) == true) goto L25;
            if (state.perceptibleTime == 0) goto L17;
            if ((state.perceptibleTime + 5000) < SystemClock.elapsedRealtime()) goto L17;
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return false;
        L17:
            if (state.isTop == true) goto L22;
            if (state.isSounding == true) goto L22;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return true;
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return true;
        L14:
            th = move-exception;
            throw th;
        }
    }

    class AppStartEventOwner implements IEventsOwner {
        private IRm mRm;

        AppStartEventOwner(ActivityManagerServiceSmtBase this$0) {
            this.mRm = null;
            initRm();
        }

        public int obtainEventData(Parcel p, Parcel r) {
            Slog.e("AppStartEventOwner", "obtainEventData. do nothing now!");
            return 0;
        }

        public String getName() {
            return "AppStartEventOwner";
        }

        public void notifyEvent(int event, Parcel data) {
            if (this.mRm != null) goto L5;
            initRm();
        L5:
            this.mRm.notifyResEventData(event, data);
        }

        private void initRm() {
            this.mRm = Rm.getInstance();
            this.mRm.connect();
            int[] events = {FrameworkStatsLog.APP_SIZE};
            this.mRm.registerResEvents(events, this);
        }
    }

    interface EventHandler {
        void handle(AppRecordData r1);
    }

    class FindSvpThreadHandle {
        private final int CLEAR_SVP_THREADS;
        private final int FIND_SVP_THREADS;
        private final int FIND_SVP_THREAD_DELAYED_INTERVAL;
        private final int SVP_APP_DIED;
        private Handler mFindSvpThreadHandler;
        private String mFindSvpThreadPackagename;
        private int mFindSvpThreadPid;
        private final Runnable mFindSvpThreadRunnable;
        private int mState;
        private List<TaskInfo> svpThreadsList;
        final /* synthetic */ ActivityManagerServiceSmtBase this$0;

        public class TaskInfo {
            public final String comm;
            public final int tid;

            public TaskInfo(FindSvpThreadHandle this$1, int tid, String comm) {
                this.tid = tid;
                this.comm = comm;
            }

            public String toString() {
                return "TaskInfo{pid=" + this.tid + ", comm='" + this.comm + "'}";
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFindSvpThreadPackagename, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1238$$Nest$fgetmFindSvpThreadPackagename(FindSvpThreadHandle r0) {
            return r0.mFindSvpThreadPackagename;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFindSvpThreadPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1239$$Nest$fgetmFindSvpThreadPid(FindSvpThreadHandle r0) {
            return r0.mFindSvpThreadPid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1240$$Nest$fgetmState(FindSvpThreadHandle r0) {
            return r0.mState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsvpThreadsList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m1241$$Nest$fgetsvpThreadsList(FindSvpThreadHandle r0) {
            return r0.svpThreadsList;
        }

        /* JADX INFO: renamed from: -$$Nest$mclearSvpThreads, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1242$$Nest$mclearSvpThreads(FindSvpThreadHandle r0) {
            r0.clearSvpThreads();
        }

        /* JADX INFO: renamed from: -$$Nest$mloopProcessThreads, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1243$$Nest$mloopProcessThreads(FindSvpThreadHandle r0, int r1) {
            r0.loopProcessThreads(r1);
        }

        protected FindSvpThreadHandle(ActivityManagerServiceSmtBase this$0) {
            this.this$0 = this$0;
            this.mFindSvpThreadPid = 0;
            this.mFindSvpThreadPackagename = null;
            this.FIND_SVP_THREAD_DELAYED_INTERVAL = 10000;
            this.mState = 0;
            this.FIND_SVP_THREADS = 1;
            this.CLEAR_SVP_THREADS = 2;
            this.SVP_APP_DIED = 3;
            this.svpThreadsList = new ArrayList();
            this.mFindSvpThreadRunnable = new AnonymousClass1(this);
            HandlerThread findSvpHandlerThread = new HandlerThread("FindSvpHandlerThread", 0);
            findSvpHandlerThread.start();
            this.mFindSvpThreadHandler = new Handler(findSvpHandlerThread.getLooper());
        }

        private double parseSumExecRuntime(File schedFile) {
            BufferedReader reader = new BufferedReader(new FileReader(schedFile));     // Catch: IOException -> L14
        L34:
            String line = reader.readLine();     // Catch: Throwable -> L16
            if (line == null) goto L22;
            if (line.contains("se.sum_exec_runtime") == false) goto L34;
            String[] parts = line.split(":");     // Catch: Throwable -> L16
            if (parts.length <= 1) goto L34;
            double r4 = Double.parseDouble(parts[1].trim());     // Catch: Throwable -> L16 NumberFormatException -> L18
        L12:
            reader.close();     // Catch: IOException -> L14
            return r4;
        L18:
            e = move-exception;
            Slog.e("ActivityManagerService", "find svp thread: Failed to parse sum_exec_runtime value: " + parts[1].trim(), e);     // Catch: Throwable -> L16
            goto L34
        L22:
            reader.close();     // Catch: IOException -> L14
            return -1.0d;
        L16:
            th = move-exception;
            reader.close();     // Catch: Throwable -> L26
        L28:
            throw th;     // Catch: IOException -> L14
        L26:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L14
        L14:
            e = move-exception;
            Slog.e("ActivityManagerService", "find svp thread: Failed to read sched file: " + schedFile.getAbsolutePath(), e);
            return -1.0d;
        }

        private void loopProcessThreads(int pid) {
            if (this.mState != 2) goto L6;
            clearSvpThreads();
            return;
        L6:
            File tasksDir = new File("/proc/" + pid + "/task");
            if (tasksDir.exists() == false) goto L90;
            if (tasksDir.isDirectory() == false) goto L90;
            File[] tasks = tasksDir.listFiles();
            if (tasks != null) goto L15;
            Slog.e("ActivityManagerService", "find svp thread: Failed to list tasks for pid: " + pid);
            return;
        L15:
            int r12 = tasks.length;
            int r14 = 0;
            int maxUnityGfxTid = 0;
            double maxUnityGfxSumExecuteTime = 0.0d;
            double maxUnityMainSumExecuteTime = 0.0d;
            int maxUnityMainTid = 0;
        L17:
            if (r14 >= r12) goto L81;
            File taskDir = tasks[r14];
            File tasksDir2 = tasksDir;
            File[] tasks2 = tasks;
            if (this.mState == 2) goto L20;
            if (taskDir.isDirectory() == true) goto L99;
            double maxUnityMainSumExecuteTime2 = maxUnityMainSumExecuteTime;
        L78:
            maxUnityMainSumExecuteTime = maxUnityMainSumExecuteTime2;
            maxUnityGfxSumExecuteTime = maxUnityGfxSumExecuteTime;
        L79:
            r14 = r14 + 1;
            tasksDir = tasksDir2;
            tasks = tasks2;
            goto L17
        L99:
            int tid = Integer.parseInt(taskDir.getName());     // Catch: NumberFormatException -> L76
            maxUnityMainSumExecuteTime2 = maxUnityMainSumExecuteTime;
            File commFile = new File(taskDir, "comm");
            if (commFile.exists() == false) goto L78;
            BufferedReader reader = new BufferedReader(new FileReader(commFile));     // Catch: IOException -> L73
            String taskName = reader.readLine().trim();     // Catch: Throwable -> L64
            BufferedReader reader2 = reader;
            double maxUnityGfxSumExecuteTime2 = maxUnityGfxSumExecuteTime;
            if ("UnityMain".equals(taskName) == false) goto L43;
            File schedFile = new File(taskDir, "sched");     // Catch: Throwable -> L38
            if (schedFile.exists() == false) goto L40;
            double sumexecruntime = parseSumExecRuntime(schedFile);     // Catch: Throwable -> L38
            Slog.i("ActivityManagerService", "find svp thread: Sched info for UnityMain task (pid: " + pid + ", tid: " + tid + ") sum execute runtime: " + sumexecruntime);     // Catch: Throwable -> L38
            if (sumexecruntime <= maxUnityMainSumExecuteTime2) goto L41;
            maxUnityMainSumExecuteTime2 = sumexecruntime;
            maxUnityMainTid = tid;
        L41:
            maxUnityMainSumExecuteTime = maxUnityMainSumExecuteTime2;
            maxUnityGfxSumExecuteTime = maxUnityGfxSumExecuteTime2;
        L97:
            reader2.close();     // Catch: IOException -> L62
        L62:
            e = e;
        L75:
            Slog.e("ActivityManagerService", "find svp thread: Failed to read task comm file for tid: " + tid, e);
            goto L79
        L40:
            Slog.e("ActivityManagerService", "find svp thread: Sched file does not exist for tid: " + tid);     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            Throwable r6 = th;
        L92:
            reader2.close();     // Catch: Throwable -> L68
        L70:
            throw r6;     // Catch: IOException -> L71
        L68:
            th = move-exception;
            r6.addSuppressed(th);     // Catch: IOException -> L71
        L71:
            e = e;
            maxUnityMainSumExecuteTime = maxUnityMainSumExecuteTime2;
            maxUnityGfxSumExecuteTime = maxUnityGfxSumExecuteTime2;
            goto L75
        L43:
            if ("UnityGfxDeviceW".equals(taskName) == false) goto L54;
            File schedFile2 = new File(taskDir, "sched");     // Catch: Throwable -> L38
            if (schedFile2.exists() == false) goto L51;
            double sumexecruntime2 = parseSumExecRuntime(schedFile2);     // Catch: Throwable -> L38
            StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L38
            r7.append("find svp thread: Sched info for UnityGfxDeviceW task (pid: ");     // Catch: Throwable -> L38
            r7.append(pid);     // Catch: Throwable -> L38
            r7.append(", tid: ");     // Catch: Throwable -> L38
            r7.append(tid);     // Catch: Throwable -> L38
            r7.append(") sum execute runtime: ");     // Catch: Throwable -> L38
            maxUnityGfxSumExecuteTime = sumexecruntime2;
            r7.append(maxUnityGfxSumExecuteTime);     // Catch: Throwable -> L38
            Slog.i("ActivityManagerService", r7.toString());     // Catch: Throwable -> L38
            if (maxUnityGfxSumExecuteTime <= maxUnityGfxSumExecuteTime2) goto L49;
            maxUnityGfxTid = tid;
        L52:
            maxUnityMainSumExecuteTime = maxUnityMainSumExecuteTime2;
            goto L97
        L49:
            maxUnityGfxSumExecuteTime = maxUnityGfxSumExecuteTime2;
            goto L52
        L51:
            Slog.e("ActivityManagerService", "find svp thread: Sched file does not exist for tid: " + tid);     // Catch: Throwable -> L38
            maxUnityGfxSumExecuteTime = maxUnityGfxSumExecuteTime2;
            goto L52
        L54:
            if ("Worker Thread".equals(taskName) == false) goto L57;
            this.svpThreadsList.add(new TaskInfo(this, tid, taskName));     // Catch: Throwable -> L38
        L59:
            maxUnityMainSumExecuteTime = maxUnityMainSumExecuteTime2;
            maxUnityGfxSumExecuteTime = maxUnityGfxSumExecuteTime2;
            goto L97
        L57:
            if ("UnityMultiRende".equals(taskName) == false) goto L59;
            this.svpThreadsList.add(new TaskInfo(this, tid, taskName));     // Catch: Throwable -> L38
        L64:
            th = move-exception;
            reader2 = reader;
            maxUnityGfxSumExecuteTime2 = maxUnityGfxSumExecuteTime;
            r6 = th;
        L73:
            e = e;
            maxUnityMainSumExecuteTime = maxUnityMainSumExecuteTime2;
        L77:
            maxUnityMainSumExecuteTime2 = maxUnityMainSumExecuteTime;
            Slog.e("ActivityManagerService", "find svp thread: Invalid task id: " + taskDir.getName());
            goto L78
        L20:
            return;
        L81:
            if (this.mState != 1) goto L88;
            if (maxUnityMainTid <= 0) goto L112;
            if (maxUnityGfxTid <= 0) goto L113;
            this.svpThreadsList.add(new TaskInfo(this, maxUnityMainTid, "UnityMain"));
            this.svpThreadsList.add(new TaskInfo(this, maxUnityGfxTid, "UnityGfxDeviceW"));
            Iterator<TaskInfo> r0 = this.svpThreadsList.iterator();
        L86:
            if (r0.hasNext() == false) goto L114;
            TaskInfo task = r0.next();
            Slog.i("ActivityManagerService", "find svp thread: setUIFirstSched: " + task);
            Process.setUIFirstSched(task.tid, 4);
            goto L86
        L114:
            return;
        L113:
            return;
        L112:
            return;
        L88:
            return;
        L90:
            Slog.e("ActivityManagerService", "find svp thread: Task directory does not exist for pid: " + pid);
        }

        private void clearSvpThreads() {
            if (this.svpThreadsList.isEmpty() == false) goto L6;
            Slog.i("ActivityManagerService", "find svp thread: clearSvpThreads, No threads found.");
            return;
        L6:
            Iterator<TaskInfo> r0 = this.svpThreadsList.iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            TaskInfo task = r0.next();
            Slog.i("ActivityManagerService", "find svp thread: clearSvpThread: " + task);
            Process.setUIFirstSched(task.tid, -1);
            goto L8
        L10:
            this.svpThreadsList.clear();
        }

        public void scheduleFindSvpThread(ProcessRecord app) {
            if ((app.info.getSysEx().peroptFlag & 16777216) != 0) goto L5;
            return;
        L5:
            if (this.mFindSvpThreadPid != app.getPid()) goto L7;
            return;
        L7:
            this.mFindSvpThreadPid = app.getPid();
            this.mFindSvpThreadPackagename = app.info.packageName;
            this.mState = 1;
            Slog.i("ActivityManagerService", "find svp thread: schedule loop under process " + this.mFindSvpThreadPid + " " + app.info.packageName);
            this.mFindSvpThreadHandler.postDelayed(this.mFindSvpThreadRunnable, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        }

        public void clearAppSvpThreads(ProcessRecord app) {
            if ((app.info.getSysEx().peroptFlag & 16777216) != 0) goto L5;
            return;
        L5:
            if (this.mFindSvpThreadPid == app.getPid()) goto L7;
            return;
        L7:
            Slog.i("ActivityManagerService", "find svp thread: clearAppSvpThreads " + app.getPid() + " " + app.info.packageName);
            this.mFindSvpThreadPid = 0;
            this.mFindSvpThreadPackagename = null;
            this.mState = 2;
            this.mFindSvpThreadHandler.removeCallbacks(this.mFindSvpThreadRunnable);
            this.mFindSvpThreadHandler.post(this.mFindSvpThreadRunnable);
        }

        public void findingSvpThreadAppDied(ProcessRecord app) {
            if ((app.info.getSysEx().peroptFlag & 16777216) != 0) goto L5;
            return;
        L5:
            if (app.info.packageName.equals(this.mFindSvpThreadPackagename) == true) goto L7;
            return;
        L7:
            if (this.mFindSvpThreadPid == app.getPid()) goto L9;
            return;
        L9:
            Slog.i("ActivityManagerService", "find svp thread: find svp thread process died " + app.getPid() + " " + app.info.packageName);
            this.mFindSvpThreadPid = 0;
            this.mFindSvpThreadPackagename = null;
            this.mState = 3;
            this.mFindSvpThreadHandler.removeCallbacks(this.mFindSvpThreadRunnable);
            this.mFindSvpThreadHandler.post(this.mFindSvpThreadRunnable);
        }
    }

    public class ForceCpusetProc {
        int curProcessGroup;
        int pid;
        long settingTime;
        long timeOut;

        public ForceCpusetProc(ActivityManagerServiceSmtBase this$0, int pid, int processGroup, long timeOut) {
            this.pid = pid;
            this.curProcessGroup = processGroup;
            this.timeOut = timeOut;
        }

        public void forceSetCpuset() {
            this.settingTime = SystemClock.uptimeMillis();
            Process.setProcessGroup(this.pid, this.curProcessGroup);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Slog.w("ActivityManagerService", "Failed setting process group of " + this.pid + " to " + this.curProcessGroup, e);
        }

        public boolean resetForceCpusetProcIfTimeOut(long currentTime) {
            if (this.timeOut > 0) goto L5;
            return false;
        L5:
            if ((currentTime - this.settingTime) <= this.timeOut) goto L9;
            this.curProcessGroup = -1;
            forceSetCpuset();
            return true;
        L9:
            return false;
        }
    }

    protected abstract class IActivityManagerSmtExBase extends IActivityManagerSmtEx.Stub {
        final /* synthetic */ ActivityManagerServiceSmtBase this$0;

        protected IActivityManagerSmtExBase(ActivityManagerServiceSmtBase this$0) {
            this.this$0 = this$0;
        }

        public void setAppSlowMainOperations(List<String> slowOperations, int index) {
            this.this$0.setAppSlowMainOperations(slowOperations, index);
        }

        public long getRomFreeMemoryKb() {
            return ActivityManagerServiceSmtBase.getRomFreeMemoryKb();
        }

        public String getSmtExtraInfo(int pid) {
            return this.this$0.getSmtExtraInfo(pid);
        }

        public void setSmtExtraInfo(int pid, String info) {
            this.this$0.setSmtExtraInfo(pid, info);
        }

        public void forceStopPackageSmart(String packageName, int userId, int taskId, int cleanLevel) {
            this.this$0.forceStopPackageSmart(packageName, userId, taskId, cleanLevel);
        }

        public void forceStopPackage(String packageName, int userId, String reason) {
            this.this$0.forceStopPackage(packageName, userId, reason);
        }

        public void killMemoryLeakProcess(String processName, int pid) {
            SysOptBridge.getFactory().getHandleMemoryLeak().killMemoryLeakProcess(processName, pid);
        }

        public void backtraceDoneInform(String processName, int pid) {
            SysMonitorSvcBridge.getFactory().getMemoryStrategy().backtraceDoneInform(processName, pid);
        }

        public void clearAllKeepAliveProc() {
            SysOptBridge.getFactory().getMemoryProcessController().clearKeepAliveProcesses();
        }

        public boolean isScreenOn() {
            return this.this$0.isScreenOn();
        }
    }

    public class KillingPriority {
        int coldStart;
        String packageName;
        int uid;

        public KillingPriority(ActivityManagerServiceSmtBase this$0, int uid, String packageName, int coldStart) {
            this.uid = uid;
            this.packageName = packageName;
            this.coldStart = coldStart;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public int getColdStart() {
            return this.coldStart;
        }

        public void setColdStart(int coldStart) {
            this.coldStart = coldStart;
        }
    }

    class KillingPriorityComparator implements Comparator<KillingPriority> {
        KillingPriorityComparator(ActivityManagerServiceSmtBase this$0) {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(KillingPriority r1, KillingPriority r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(KillingPriority p1, KillingPriority p2) {
            return Integer.compare(p1.getColdStart(), p2.getColdStart());
        }
    }

    public abstract class LocalServiceSmtExBase extends ActivityManagerInternalSmtEx {
        final /* synthetic */ ActivityManagerServiceSmtBase this$0;

        public LocalServiceSmtExBase(ActivityManagerServiceSmtBase this$0) {
            this.this$0 = this$0;
        }

        public IBatteryStats getBatteryStatsService() {
            return this.this$0.mActivityManagerService.mBatteryStatsService;
        }
    }

    class MyHandler extends Handler {
        public MyHandler(ActivityManagerServiceSmtBase this$0, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
        }
    }

    public static class UidCpuInfo implements Comparable {
        public static final int KILL_TYPE_FREEZE = 2;
        public static final int KILL_TYPE_FREEZE_WINDOW = 3;
        public static final int KILL_TYPE_KILL = 1;
        public final long beginTime;
        public final int cpuRatio;
        public int killType;
        public boolean killingVisible;
        public int possibleKillCount;
        public final int uid;
        public final int uidRecentOrder;
        public final int unifiedRatio;

        UidCpuInfo(int uid, int uR, int cR, int uO, long b) {
            this.killType = 1;
            this.possibleKillCount = 0;
            this.uid = uid;
            this.unifiedRatio = uR;
            this.cpuRatio = cR;
            this.uidRecentOrder = uO;
            this.beginTime = b;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object o) {
            return ((UidCpuInfo) o).cpuRatio - this.cpuRatio;
        }

        public static UidCpuInfo getInfoFromList(int uid, ArrayList<UidCpuInfo> list) {
            int N = list.size();
            int i = 0;
        L3:
            if (i >= N) goto L8;
            UidCpuInfo info = list.get(i);
            if (info.uid == uid) goto L6;
            i = i + 1;
            goto L3
        L6:
            return info;
        L8:
            return null;
        }

        public String toString() {
            return "UidCpuInfo{ uid=" + this.uid + ", unifiedRatio=" + this.unifiedRatio + ", cpuRatio=" + this.cpuRatio + ", uidRecentOrder=" + this.uidRecentOrder + " beginTime=" + this.beginTime;
        }
    }

    public static class UidCpuInfos {
        public long checkTime;
        ArrayList<UidCpuInfo> infos;

        public UidCpuInfos() {
        }
    }

    public interface UidCpuUsageObserver {
        void onForeUidCpuInfo(int r1, int r2, long r3);

        void onUidCpuInfo(ArrayList<UidCpuInfo> r1, long r2, long r4);
    }

    public interface UidCpuUsageProvider {
        default void registerUidCpuUsageObserver(UidCpuUsageObserver observer) {
        }

        default void unregisterUidCpuUsageObserver(UidCpuUsageObserver observer) {
        }
    }

    private final class WarmStartSvpInfo {
        final int consistantSvp;
        final String packageName;
        final int pid;
        final int renderThreadTid;
        final int svpType;

        WarmStartSvpInfo(ActivityManagerServiceSmtBase r1, int pid, int renderThreadTid, int consistantSvp, String packageName) {
            this.pid = pid;
            this.renderThreadTid = renderThreadTid;
            this.consistantSvp = consistantSvp;
            this.svpType = ActivityManagerServiceSmtBase.m1232$$Nest$mgetWarmStartSvpType(r1, consistantSvp);
            this.packageName = packageName;
        }
    }

    static final enum reportEventCode extends Enum<reportEventCode> {
        private static final /* synthetic */ reportEventCode[] $VALUES = null;
        public static final reportEventCode BLACKSCREEN = null;
        public static final reportEventCode LOADING = null;
        public static final reportEventCode TEARSCREEN_COST_ABNORMAL = null;
        public static final reportEventCode TEARSCREEN_PARAM = null;
        public static final reportEventCode TEARSCREEN_VSYNC = null;
        public static final reportEventCode UNKNOWN = null;
        private int value;

        private static /* synthetic */ reportEventCode[] $values() {
            return new reportEventCode[]{UNKNOWN, LOADING, BLACKSCREEN, TEARSCREEN_VSYNC, TEARSCREEN_COST_ABNORMAL, TEARSCREEN_PARAM};
        }

        public static reportEventCode valueOf(String name) {
            return (reportEventCode) Enum.valueOf(reportEventCode.class, name);
        }

        public static reportEventCode[] values() {
            return (reportEventCode[]) $VALUES.clone();
        }

        static {
            UNKNOWN = new reportEventCode("UNKNOWN", 0, 0);
            LOADING = new reportEventCode("LOADING", 1, 5000);
            BLACKSCREEN = new reportEventCode("BLACKSCREEN", 2, 5001);
            TEARSCREEN_VSYNC = new reportEventCode("TEARSCREEN_VSYNC", 3, 5010);
            TEARSCREEN_COST_ABNORMAL = new reportEventCode("TEARSCREEN_COST_ABNORMAL", 4, 5010);
            TEARSCREEN_PARAM = new reportEventCode("TEARSCREEN_PARAM", 5, 5010);
            $VALUES = $values();
        }

        public int getValue() {
            return this.value;
        }

        private reportEventCode(String r1, int r2, int code) {
            super(r1, r2);
            this.value = code;
        }
    }

    public static /* synthetic */ String $r8$lambda$4dWO8QFzfTv8w6UdclDKxY6FRv0(ProcessRecord r0) {
        return lambda$systemReady$2(r0);
    }

    public static /* synthetic */ String $r8$lambda$S5jPoDtBVZx2Hc9jpFCpZah2LiQ(ProcessRecord r0) {
        return lambda$systemReady$1(r0);
    }

    public static /* synthetic */ ProcessRecord $r8$lambda$gcSjfkV0iq57Ky9bbAsxjMIibzc(int r0, ProcessRecord r1) {
        return lambda$onTransactSmtEx$0(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$zELoblol5APVZvqB7wv2faHKo60(ProcessRecord r0) {
        return lambda$systemReady$3(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForceCpusetProcs, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m1230$$Nest$fgetmForceCpusetProcs(ActivityManagerServiceSmtBase r0) {
        return r0.mForceCpusetProcs;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPostedCheckCpusetTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1231$$Nest$fputmPostedCheckCpusetTask(ActivityManagerServiceSmtBase r0, boolean r1) {
        r0.mPostedCheckCpusetTask = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetWarmStartSvpType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1232$$Nest$mgetWarmStartSvpType(ActivityManagerServiceSmtBase r0, int r1) {
        return r0.getWarmStartSvpType(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendCheckForceCpusetProcTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1233$$Nest$msendCheckForceCpusetProcTask(ActivityManagerServiceSmtBase r0, long r1) {
        r0.sendCheckForceCpusetProcTask(r1);
    }

    static {
        IS_USER_BUILD = "user".equals(Build.TYPE);
        isDexFileOptOn = SystemProperties.getInt(DEX_FILE_OPT, 0);
        debug3rd = SystemProperties.getBoolean("persist.sys.3rd.debug", false);
        sTrimDebugEnable = SystemProperties.getBoolean("persist.sys.tm.debug", false);
        sRequireAvaCoefficient = SystemProperties.getInt("persist.sys.tm.ava_rquire_coef", 120);
        sReleaseAvaCoefficient = SystemProperties.getInt("persist.sys.tm.ava_release_coef", 80);
        sRequireFreeCoefficient = SystemProperties.getInt("persist.sys.tm.free_rquire_coef", 100);
        sReleaseFreeCoefficient = SystemProperties.getInt("persist.sys.tm.free_release_coef", 100);
        sAvaBase = SystemProperties.getLong("persist.sys.tm.avabase", 1500000);
        sFreeBase = SystemProperties.getInt("persist.sys.tm.freebase", BZip2Constants.BASEBLOCKSIZE);
        initTargetSet();
        initPackageStartTimeMap();
        initPackageRequireFreeMap();
        initPackageRequireAvaMap();
        mOverrideClazzCrashProcs = new ArraySet(4);
        mOverrideClazzsFiles = new ArraySet(4);
        mPackageCache = null;
        mOverrideClazzsFiles.add("ControllerClient.java");
        mOverrideClazzsFiles.add("CvOTACb.java");
        mOverrideClazzsFiles.add("CvStateCb.java");
        mOverrideClazzsFiles.add("CvStateCb.java");
    }

    void collectCachedPss(ProcessRecord app) {
        if (app.getSmtEx().memoryInfo == null) goto L5;
        long r0 = app.getSmtEx().memoryInfo.getOtherPss(14);
        long r2 = app.getSmtEx().memoryInfo.getTotalPss();
        return;
    L5:
        long r1 = app.getSmtEx().mEGL;
        long r3 = app.getSmtEx().mPss;
    }

    void collectCachedPss(long pss, long egl, int oomAdj, boolean javaProcess) {
        if (javaProcess == true) goto L4;
    L6:
        this.mTotalPss += pss;
        this.mTotalEGL += egl;
        return;
    L4:
        if (oomAdj < 900) goto L6;
        this.mCachedPss += pss;
        goto L6
    }

    void resetProcStatsCollectData() {
        this.mTotalPss = 0;
        this.mCachedPss = 0;
        this.mTotalEGL = 0;
    }

    public ApplicationInfo getTopApplication() {
        return this.mActivityManagerService.mActivityTaskManager.getSmtEx().getTopApplication();
    }

    public IProcessIntercept getProcessInterceptInstance() {
        return this.mProcessIntercept;
    }

    public IProcessStatusChecker getProcessStatusChecker() {
        return this.mProcessStatusChecker;
    }

    public boolean consumePgNoRestartSigKillLocked(ProcessRecord app, int pid) {
        if (mSmtOptEx != null) goto L5;
    L7:
        return false;
    L5:
        if (mSmtOptEx.consumePgNoRestartSigKillLocked(app, pid) == false) goto L7;
        return true;
    }

    public ApplicationInfo getTopApp() {
        ActivityManagerService r0 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityTaskManagerInternal atm = this.mActivityManagerService.mAtmInternal;     // Catch: Throwable -> L7
        ApplicationInfo r2 = null;
        if (atm == null) goto L9;
        WindowProcessController wpc = atm.getTopApp();     // Catch: Throwable -> L7
    L10:
        if (wpc == null) goto L12;
        r2 = wpc.mInfo;     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterLockedSection();
        return r2;
    L9:
        wpc = null;
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    protected void readChainBootBlackList() {
        File file = this.mChainBootBlackListFile.getBaseFile();
        if (file.exists() == false) goto L94;
        FileInputStream fis = this.mChainBootBlackListFile.openRead();     // Catch: FileNotFoundException -> L82
    L12:
        th = move-exception;
        fis.close();     // Catch: IOException -> L80
    L81:
        throw th;
    L14:
        e = move-exception;
        Slog.w("ActivityManagerService", "Failed parsing " + e);     // Catch: Throwable -> L12
        fis.close();     // Catch: IOException -> L71
    L92:
        return;
    L10:
        if (ActivityManagerDebugConfigSmtEx.DEBUG_WIFI_UPLOAD == false) goto L16;
        Slog.i("ActivityManagerService", "readWarnedWifiPackages: start parse");     // Catch: Throwable -> L12 Exception -> L14
    L16:
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L12 Exception -> L14
        parser.setInput(fis, null);     // Catch: Throwable -> L12 Exception -> L14
    L17:
        int type = parser.next();     // Catch: Throwable -> L12 Exception -> L14
        if (type == 2) goto L21;
        if (type != 1) goto L17;
    L21:
        if (type == 2) goto L27;
        Slog.w("ActivityManagerService", "no start tag found for warning");     // Catch: Throwable -> L12 Exception -> L14
        fis.close();     // Catch: IOException -> L25
        return;
    L26:
        return;
    L27:
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L12 Exception -> L14
    L28:
        int type2 = parser.next();     // Catch: Throwable -> L12 Exception -> L14
        if (type2 == 1) goto L69;
        if (type2 == 3) goto L33;
    L35:
        if (type2 == 3) goto L28;
        if (type2 == 4) goto L28;
        String name = parser.getName();     // Catch: Throwable -> L12 Exception -> L14
        if (ActivityManagerDebugConfigSmtEx.DEBUG_CHAINBOOT_BLACKLIST == false) goto L42;
        Slog.i("ActivityManagerService", "readChainBootBlackList: parse name=" + name);     // Catch: Throwable -> L12 Exception -> L14
    L42:
        ActivityManagerService r8 = this.mActivityManagerService;     // Catch: Throwable -> L12 Exception -> L14
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L12 Exception -> L14
        monitor-enter(r8);     // Catch: Throwable -> L12 Exception -> L14
        if ("class".equals(name) == false) goto L56;
        String componentName = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L51
        if (componentName == null) goto L63;
        if (ActivityManagerDebugConfigSmtEx.DEBUG_CHAINBOOT_BLACKLIST == false) goto L53;
        Slog.i("ActivityManagerService", "readChainBootBlackList: parse package=" + componentName);     // Catch: Throwable -> L51
    L53:
        this.mProcessIntercept.getPushServiceNames().add(componentName);     // Catch: Throwable -> L51
    L63:
        monitor-exit(r8);     // Catch: Throwable -> L51
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12 Exception -> L14
        goto L28
    L56:
        if (DomainVerificationPersistence.ATTR_ACTION.equals(name) == false) goto L63;
        String actionName = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L51
        if (actionName == null) goto L63;
        if (ActivityManagerDebugConfigSmtEx.DEBUG_CHAINBOOT_BLACKLIST == false) goto L62;
        Slog.i("ActivityManagerService", "readChainBootBlackList: parse action=" + actionName);     // Catch: Throwable -> L51
    L62:
        this.mProcessIntercept.getPushServiceActions().add(actionName);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L12 Exception -> L14
        throw th;     // Catch: Throwable -> L12 Exception -> L14
    L33:
        if (parser.getDepth() > outerDepth) goto L35;
    L69:
        fis.close();     // Catch: IOException -> L71
    L84:
        if (ActivityManagerDebugConfigSmtEx.DEBUG_WIFI_UPLOAD == false) goto L114;
        Slog.i("ActivityManagerService", "readWarnedWifiPackages file not found");
        return;
    L114:
        return;
    L113:
        return;
    L94:
        file.createNewFile();     // Catch: IOException -> L6
        return;
    }

    protected ActivityManagerServiceSmtBase(ActivityManagerService ams) {
        this.mIsReporting = false;
        this.mCachedPss = 0;
        this.mTotalPss = 0;
        this.mTotalEGL = 0;
        this.mUserIsMonkeyLock = new Object();
        this.mSetupWizardState = -1;
        this.mStrictModeFlags = 0;
        final Handler r2 = null;
        this.mBinderStat = null;
        this.NOTIFY_INVALID = -1;
        this.NOTIFY_STAT_BUFF = 1;
        this.NOTIFY_PARCEL_DATA = 2;
        this.NOTIFY_DONE = 3;
        this.mLaunchingProcessName = null;
        this.mLaunchingPackageName = null;
        this.mKPC = new KillingPriorityComparator(this);
        this.killStats = SysOptBridge.getFactory().getKillingStats();
        this.mNextUpdateOomTime = Long.MAX_VALUE;
        this.mHardClean = false;
        this.mPrefetchCpuObServer = new AnonymousClass1(this);
        this.mForceCpusetProcs = new HashMap();
        this.mPostedCheckCpusetTask = false;
        this.mCheckForceCpusetProcTask = new AnonymousClass2(this);
        this.mAppLaunchPredict = new AnonymousClass3(this, null);
        this.mNextAppPredict = new AnonymousClass4(this, r2);
        this.mPredictSceneApp = new AnonymousClass5(this, r2);
        this.DES_EMPTY = "";
        this.mActivityManagerService = ams;
        this.mPrefetchPidsSelf = new ActivityManagerService.PidMap();
        File systemDir = SystemServiceManager.ensureSystemDir();
        this.mChainBootBlackListFile = new AtomicFile(new File(systemDir, "chainboot.xml"));
        this.mProcessIntercept = SysOptBridge.getFactory().getProcessIntercept();
        mSmtOptEx = SysOptBridge.getFactory().getActivityManager(ams);
        this.mMemProcessController = SysOptBridge.getFactory().getMemoryProcessController();
        this.mTransferService = SysMonitorSvcBridge.getFactory().getTransferController();
        this.mBinderStat = SysOptBridge.getFactory().getBinderStat();
        this.mStrictModeFlags = SystemProperties.getInt("persist.sys.strictmode.flags", 0);
        this.mProcessStatusChecker = SysOptBridge.getFactory().getProcessStatusChecker();
        this.mProcessStatusChecker.init(ams);
        readCustomFileConfig();
    }

    protected ActivityManagerServiceSmtBase(ActivityManagerService ams, ActivityManagerService.Injector injector, ServiceThread handlerThread) {
        this.mIsReporting = false;
        this.mCachedPss = 0;
        this.mTotalPss = 0;
        this.mTotalEGL = 0;
        this.mUserIsMonkeyLock = new Object();
        this.mSetupWizardState = -1;
        this.mStrictModeFlags = 0;
        final Handler r2 = null;
        this.mBinderStat = null;
        this.NOTIFY_INVALID = -1;
        this.NOTIFY_STAT_BUFF = 1;
        this.NOTIFY_PARCEL_DATA = 2;
        this.NOTIFY_DONE = 3;
        this.mLaunchingProcessName = null;
        this.mLaunchingPackageName = null;
        this.mKPC = new KillingPriorityComparator(this);
        this.killStats = SysOptBridge.getFactory().getKillingStats();
        this.mNextUpdateOomTime = Long.MAX_VALUE;
        this.mHardClean = false;
        this.mPrefetchCpuObServer = new AnonymousClass1(this);
        this.mForceCpusetProcs = new HashMap();
        this.mPostedCheckCpusetTask = false;
        this.mCheckForceCpusetProcTask = new AnonymousClass2(this);
        this.mAppLaunchPredict = new AnonymousClass3(this, null);
        this.mNextAppPredict = new AnonymousClass4(this, r2);
        this.mPredictSceneApp = new AnonymousClass5(this, r2);
        this.DES_EMPTY = "";
        this.mActivityManagerService = ams;
        this.mChainBootBlackListFile = null;
        this.mMemProcessController = SysOptBridge.getFactory().getMemoryProcessController();
        mSmtOptEx = SysOptBridge.getFactory().getActivityManager(ams);
        readCustomFileConfig();
    }

    private boolean isWarmStartSvpEnabled() {
        return SysOptBridge.getFactory().getResMngConfig().isModuleEnable(IResMngConfig.FEAT_CPU_OPTIMIZE, IResMngConfig.MOD_SVP_SCENARIO_LIMIT_EXEMPT);
    }

    private int getWarmStartSvpType(int consistantSvp) {
        if (consistantSvp != 1) goto L5;
        return 8;
    L5:
        return 2;
    }

    private boolean setWarmStartSvpFromCache(String processName, int uid, int type, int unfreezedPid) {
        IWarmStartPidCache.Entry entry = SysOptBridge.getFactory().getWarmStartPidCache().findCachedEntry(uid, processName);
        if (entry != null) goto L6;
        return false;
    L6:
        Slog.i("ActivityManagerService", "WarmStartPidCache hot/warm start: set svp pid " + entry.pid + " processName " + processName + " type " + type + " unfreezedPid " + unfreezedPid);
        if (unfreezedPid != 0) goto L10;
        setWarmStartSvp(entry.pid, entry.renderThreadTid, entry.svpType, entry.packageName, type, false);
        return true;
    L10:
        if (unfreezedPid != entry.pid) goto L12;
        setWarmStartSvp(entry.pid, entry.renderThreadTid, entry.svpType, entry.packageName, type, true);
        return true;
    L12:
        Slog.e("ActivityManagerService", "setWarmStartSvpFromCache: hot warm start app not match with unfreezed pid, unfreezedPid " + unfreezedPid + " entry.pid " + entry.pid);
        Process.setUIFirstSchedEventTrack(unfreezedPid, unfreezedPid, 0, null, false, 0);
        setWarmStartSvp(entry.pid, entry.renderThreadTid, entry.svpType, entry.packageName, type, false);
        return true;
    }

    private ProcessRecord getProcessRecordLOSP(String processName, int uid) {
        if (uid != 1000) goto L19;
        SparseArray<ProcessRecord> procs = (SparseArray) this.mActivityManagerService.getProcessNamesLOSP().getMap().get(processName);
        if (procs != null) goto L8;
        return null;
    L8:
        int procCount = procs.size();
        int i = 0;
    L9:
        if (i >= procCount) goto L19;
        int procUid = procs.keyAt(i);
        if (UserHandle.isCore(procUid) == false) goto L17;
        if (UserHandle.isSameUser(procUid, uid) == false) goto L17;
        return procs.valueAt(i);
    L17:
        i = i + 1;
    L19:
        return (ProcessRecord) this.mActivityManagerService.getProcessNamesLOSP().get(processName, uid);
    }

    private WarmStartSvpInfo getWarmStartSvpInfo(String processName, int uid) {
        ProcessRecord pr = SysOptBridge.getFactory().getApplicationFreezer().get(processName, uid);
        ActivityManagerGlobalLock r2 = this.mActivityManagerService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r2);
        int pid = 0;
        if (pr != null) goto L30;
    L9:
        if (pid != 0) goto L14;
        pr = getProcessRecordLOSP(processName, uid);     // Catch: Throwable -> L7
        if (pr == null) goto L13;
        int pid2 = pr.getPid();     // Catch: Throwable -> L7
        int pid3 = pid2;
    L15:
        if (pr == null) goto L24;
        if (pid3 == 0) goto L24;
        if (pr.info == null) goto L24;
        WarmStartSvpInfo r3 = new WarmStartSvpInfo(this, pid3, pr.getRenderThreadTid(), pr.info.getSysEx().consistantsvp, pr.info.packageName);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r3;
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return null;
    L13:
        pid3 = pid;
        goto L15
    L14:
        pid3 = pid;
        goto L15
    L30:
        pid = pr.getSmtEx().getPid();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void setWarmStartSvp(int pid, int renderThreadTid, int svpType, String packageName, int type, boolean hitFreeze) {
        if (hitFreeze == true) goto L4;
        Process.setUIFirstSchedEventTrack(pid, pid, svpType, packageName, true, type);
    L4:
        if (renderThreadTid == 0) goto L6;
        Process.setUIFirstSchedEventTrack(pid, renderThreadTid, svpType, packageName, false, 0);
    L6:
        SysOptBridge.getFactory().getSvpSenarioHandler().svpWarmStarting(pid, true);
    }

    public boolean hotWarmStartSvpSettingIfCached(String processName, int uid, int type, int unfreezedPid) {
        if (isWarmStartSvpEnabled() == true) goto L7;
        return false;
    L7:
        return setWarmStartSvpFromCache(processName, uid, type, unfreezedPid);
    }

    public void hotWarmStartSvpSetting(String processName, int uid, int type, int unfreezedPid) {
        if (isWarmStartSvpEnabled() == true) goto L5;
        return;
    L5:
        WarmStartSvpInfo info = getWarmStartSvpInfo(processName, uid);
        if (info != null) goto L8;
        return;
    L8:
        Slog.i("ActivityManagerService", "freezed hot/warm start: set svp pid " + info.pid + " processName " + processName + " type " + type);
        SysOptBridge.getFactory().getWarmStartPidCache().update(uid, processName, info.packageName, info.pid, info.consistantSvp, info.renderThreadTid);
        if (unfreezedPid != 0) goto L12;
        setWarmStartSvp(info.pid, info.renderThreadTid, info.svpType, info.packageName, type, false);
        return;
    L12:
        if (unfreezedPid != info.pid) goto L14;
        setWarmStartSvp(info.pid, info.renderThreadTid, info.svpType, info.packageName, type, true);
        return;
    L14:
        Slog.e("ActivityManagerService", "hotWarmStartSvpSetting: hot warm start app not match with unfreezed pid, unfreezedPid " + unfreezedPid + " info.pid " + info.pid);
        Process.setUIFirstSchedEventTrack(unfreezedPid, unfreezedPid, 0, null, false, 0);
        setWarmStartSvp(info.pid, info.renderThreadTid, info.svpType, info.packageName, type, false);
    }

    public boolean onTransactSmtEx(int code, Parcel data, Parcel reply, int flags) {
        int r10 = 2;
        boolean addTimeout = false;
        switch(code) {
            case 1021: goto L432;
            case 1030: goto L338;
            case 1031: goto L333;
            case 1032: goto L268;
            case 1033: goto L262;
            case 1034: goto L260;
            case 1035: goto L250;
            case 1040: goto L248;
            case 1041: goto L246;
            case 2020: goto L240;
            case 2021: goto L236;
            case 2022: goto L234;
            case 3000: goto L232;
            case 3001: goto L230;
            case 3002: goto L228;
            case 3003: goto L226;
            case 7668: goto L219;
            case 7669: goto L210;
            case 7700: goto L208;
            case 7701: goto L195;
            case 7702: goto L193;
            case 7703: goto L182;
            case 7704: goto L178;
            case 7705: goto L176;
            case 7706: goto L170;
            case 7707: goto L153;
            case 7708: goto L151;
            case 7709: goto L149;
            case 7710: goto L147;
            case 7711: goto L140;
            case 7712: goto L138;
            case 7713: goto L132;
            case 7714: goto L130;
            case 7715: goto L128;
            case 7716: goto L126;
            case 7717: goto L117;
            case 7718: goto L115;
            case 7719: goto L113;
            case 7720: goto L111;
            case 7888: goto L454;
            case 8010: goto L446;
            case 8011: goto L482;
            case 8888: goto L460;
            case 25000: goto L81;
            case 26000: goto L38;
            case 26001: goto L32;
            case 27000: goto L26;
            case 27001: goto L20;
            case 27002: goto L499;
            case 27003: goto L464;
            case 27100: goto L6;
            default: goto L5;
        };
    L6:
        Slog.i("CustomLeakCanary", "report leak canary custom error");
        String summary = data.readString();
        String logPath = data.readString();
        String pkgName = data.readString();
        SysDataSyncServiceManager.sendCustomError("LEAKCANARY", summary, logPath, 0, pkgName, 0);
        return true;
    L20:
        data.enforceInterface("android.app.IActivityManager");
        Slog.i("ActivityManagerService", "send fakeIntent");
        Slog.i("ActivityManagerService", "send fakeIntent flag = " + data.readInt());
        Intent fakeIntent = new Intent();     // Catch: Exception -> L23
        fakeIntent.setAction("com.android.providers.downloads.ACTION_APPINFO_WHITE_LIST_UPDATE");     // Catch: Exception -> L23
        fakeIntent.putExtra("is_enable", -1);     // Catch: Exception -> L23
        fakeIntent.putExtra("path", "/data/syslog/slardar/OptAppInfoWhiteList.xml");     // Catch: Exception -> L23
        fakeIntent.putExtra("feature", "update_appinfo");     // Catch: Exception -> L23
        Slog.i("ActivityManagerService", "fakeIntent");     // Catch: Exception -> L23
        this.mActivityManagerService.mContext.sendBroadcastAsUser(fakeIntent, UserHandle.ALL);     // Catch: Exception -> L23
    L25:
        return true;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L26:
        int autoDumpTimeout = data.readInt();
        Slog.i("ActivityManagerService", "dumping for PerfettoForce autoDumpTimeout=" + autoDumpTimeout);
        SystemProperties.set("debug.sys.monitor.autodumptimeout", String.valueOf(autoDumpTimeout));     // Catch: Exception -> L29
        SysMonitorSvcBridge.getFactory().getTransferController().startPerfettoForce(1);     // Catch: Exception -> L29
    L31:
        return true;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L32:
        String errorPrefix = data.readString();
        int errCode = data.readInt();
        int actionMode = data.readInt();
        String services = data.readString();
        int spatialPid = data.readInt();
        int containerId = data.readInt();
        String focusPackageName = data.readString();
        SysMonitorSvcBridge.getFactory().getDumpUtils().doDumpForSpatial(this.mActivityManagerService.mContext, errorPrefix, errCode, actionMode, services, spatialPid, containerId, focusPackageName);     // Catch: Exception -> L35
    L37:
        return true;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L38:
        String errorPrefix2 = data.readString();
        int reasonCode = data.readInt();
        int actionMode2 = data.readInt();
        String services2 = data.readString();
        String pids = data.readString();
        String clientPackageName = data.readString();
        int eventCode = reportEventCode.valueOf(errorPrefix2).getValue();
        if (actionMode2 != 1) goto L52;
    L47:
        e = e;
    L79:
        e.printStackTrace();
    L80:
        return true;
    L41:
        if (this.mIsReporting == true) goto L52;
        Slog.i("ActivityManagerService", "start perfetto, reportEvent: " + errorPrefix2);     // Catch: Exception -> L47
        SysMonitorSvcBridge.getFactory().getDumpUtils().reportEvent(eventCode, 2, 1.0f, reasonCode, errorPrefix2, 1, new long[]{0});     // Catch: Exception -> L49
        this.mIsReporting = true;     // Catch: Exception -> L47
        String errorPrefix3 = errorPrefix2;
    L480:
        SysMonitorSvcBridge.getFactory().getDumpUtils().doDump(this.mActivityManagerService.mContext, errorPrefix3, reasonCode, actionMode2, services2, pids, clientPackageName);     // Catch: Exception -> L75
    L75:
        e = e;
    L77:
        e = e;
    L49:
        e = e;
    L52:
        if (actionMode2 == 2) goto L472;
    L70:
        errorPrefix3 = errorPrefix2;
        goto L480
    L472:
    L68:
        e = e;
        goto L79
    L54:
        if (this.mIsReporting == false) goto L70;
        Slog.i("ActivityManagerService", "finish perfetto, reportEvent: " + errorPrefix2);     // Catch: Exception -> L68
        errorPrefix3 = errorPrefix2;
        SysMonitorSvcBridge.getFactory().getDumpUtils().reportEvent(eventCode, 2, 1.0f, reasonCode, errorPrefix3, 1, new long[]{0});     // Catch: Exception -> L64
        this.mIsReporting = false;     // Catch: Exception -> L62
    L62:
        e = e;
    L64:
        e = e;
    L66:
        e = e;
        goto L79
    L81:
        data.enforceInterface("android.app.IActivityManager");
        int pid = data.readInt();
        String info = data.readString();
        setSmtExtraInfo(pid, info);
        return true;
    L111:
        data.enforceInterface("android.app.IActivityManager");
        int runtime_flag = data.readInt();
        int mtp_flag = data.readInt();
        SystemProperties.set("persist.pxr.frame_track.enable", String.valueOf(runtime_flag));
        SystemProperties.set("persist.sys.monitor.mtp", String.valueOf(mtp_flag));
        return true;
    L113:
        data.enforceInterface("android.app.IActivityManager");
        String processName = data.readString();
        SysMonitorSvcBridge.getFactory().getHandleMemoryLeak().killMemoryLeakProcess(processName, data.readInt());
        return true;
    L115:
        data.enforceInterface("android.app.IActivityManager");
        this.mActivityManagerService.mActivityTaskManager.getSmtEx().uiFirstSwitch = data.readBoolean();
        return true;
    L117:
        int flag = data.readInt();
        if ((flag & 1) == 0) goto L120;
        boolean doJankLog = true;
    L122:
        if ((flag & 2) != 0) goto L124;
    L124:
        SysMonitorSvcBridge.getFactory().getTransferController().setDoJankLog(doJankLog);
        return true;
    L120:
        doJankLog = false;
        goto L122
    L126:
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().uploadSystemMonitorData();
        SysMonitorSvcBridge.getFactory().getProcessStatsServiceOptEx().saveDataDaily();
        return true;
    L128:
        data.enforceInterface("android.app.IActivityManager");
        int intervalTime = data.readInt();
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setWriteMonitorFileInterval(intervalTime);
        return true;
    L130:
        data.enforceInterface("android.app.IActivityManager");
        int scenesType = data.readInt();
        int scenesStatus = data.readInt();
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setSysEventScenesStatus(scenesType, scenesStatus);
        return true;
    L132:
        data.enforceInterface("android.app.IActivityManager");
        int pid2 = data.readInt();
        int cpusetLevel = data.readInt();
        long timeout = data.readLong();
        if (data.readInt() == 0) goto L135;
        boolean force = true;
    L136:
        setProcessRunningCpuset(pid2, cpusetLevel, timeout, force);
        return true;
    L135:
        force = false;
        goto L136
    L138:
        data.enforceInterface("android.app.IActivityManager");
        FeatLog.config(data.readBoolean());
        return true;
    L140:
        data.enforceInterface("android.app.IActivityManager");
        String fileName = data.readString();
        Parcel data0 = Parcel.obtain();
        data0.writeString(fileName);     // Catch: Throwable -> L144
        Slog.w("ActivityManagerService", "request perfettp of path:" + fileName);     // Catch: Throwable -> L144
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(107, data0, null, 1);     // Catch: Throwable -> L144
        data0.recycle();
        return true;
    L144:
        th = move-exception;
        data0.recycle();
        throw th;
    L147:
        data.enforceInterface("android.app.IActivityManager");
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(106, new int[0]);
        return true;
    L149:
        data.enforceInterface("android.app.IActivityManager");
        int loopDump = data.readInt();
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(105, new int[0]);
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(108, new int[]{loopDump});
        return true;
    L151:
        data.enforceInterface("android.app.IActivityManager");
        String packageName = data.readString();
        int hour = data.readInt();
        int flag2 = data.readInt();
        List<String> prefetchApps = new ArrayList();
        prefetchApps.add(packageName);
        SysOptBridge.getFactory().getSysPrefetchService().updatePrefetchApps(prefetchApps, hour, flag2);
        return true;
    L153:
        data.enforceInterface("android.app.IActivityManager");
        String packageName2 = data.readString();
        int enable = data.readInt();
        int dumpType = data.readInt();
        if (enable != 0) goto L156;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceType(0);
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceWindow("");
    L157:
        if (packageName2 == null) goto L159;
        this.mActivityManagerService.mContext.getPackageManager().getLaunchIntentForPackage(packageName2);
    L159:
        if (dumpType != (-1)) goto L161;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceType(4);
    L169:
        return true;
    L161:
        if (dumpType != 1) goto L163;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceType(8);
        goto L169
    L163:
        if (dumpType != 2) goto L165;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceType(16);
        goto L169
    L165:
        if (dumpType != 3) goto L167;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceType(34);
        goto L169
    L167:
        if (dumpType != 4) goto L169;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceType(2);
        goto L169
    L156:
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setUserDumpAtraceWindow(packageName2);
        goto L157
    L170:
        data.enforceInterface("android.app.IActivityManager");
        int enable2 = data.readInt();
        if (SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().allowUserAtrace() == false) goto L175;
        if (enable2 != 0) goto L174;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(102, new int[0]);
        goto L175
    L174:
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(101, new int[0]);
    L175:
        return true;
    L176:
        data.enforceInterface("android.app.IActivityManager");
        BytedanceAm.BytedanceAmUtils.getInstance().openAppMainThreadLooperTrace(data.readString());
        return true;
    L178:
        data.enforceInterface("android.app.IActivityManager");
        int flag3 = data.readInt();
        SystemProperties.set(ISysPerfMonitorService.DEBUG_PROPERTY_NAME, String.valueOf(flag3));
        if (SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().getMonitorDebugOpt() == flag3) goto L181;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setMonitorControlOpt(flag3);
    L181:
        return true;
    L182:
        data.enforceInterface("android.app.IActivityManager");
        String fileName2 = data.readString();
        Parcel data1 = Parcel.obtain();
        data1.writeString(fileName2);     // Catch: Throwable -> L187
        Slog.w("ActivityManagerService", "request systrace of Jank path:" + fileName2);     // Catch: Throwable -> L187
        if (SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().allowUserAtrace() == false) goto L189;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(103, data1, null, 1);     // Catch: Throwable -> L187
    L189:
        data1.recycle();
        return true;
    L187:
        th = move-exception;
        data1.recycle();
        throw th;
    L193:
        data.enforceInterface("android.app.IActivityManager");
        int type = data.readInt();
        SysOptBridge.getFactory().getSmartService().controlThermal(type);
        return true;
    L195:
        data.enforceInterface("android.app.IActivityManager");
        int flag4 = data.readInt();
        if (flag4 == 0) goto L198;
        boolean r3 = true;
    L199:
        SystemProperties.set("persist.sys.gamebalance", String.valueOf(r3));
        IGameBalanceService r2 = SysOptBridge.getFactory().getGameBalanceService();
        if (flag4 == 0) goto L202;
        boolean r4 = true;
    L203:
        r2.setGameBalanceOpen(r4);
        IGameBalanceService r5 = SysOptBridge.getFactory().getGameBalanceService();
        if ((flag4 & 2) == 0) goto L206;
        addTimeout = true;
    L206:
        r5.setDebugGameBalance(addTimeout);
        return true;
    L202:
        r4 = false;
        goto L203
    L198:
        r3 = false;
        goto L199
    L208:
        SysOptBridge.getFactory().getSmartService().preDex2oat();
        return true;
    L210:
        data.enforceInterface("android.app.IActivityManager");
        int flag5 = data.readInt();
        int prefetchMaxNum = data.readInt();
        if (flag5 == 0) goto L213;
        boolean r6 = true;
    L214:
        SystemProperties.set("persist.sys.smartprefetch", String.valueOf(r6));
        ISysPrefetchService r7 = SysOptBridge.getFactory().getSysPrefetchService();
        if (flag5 == 0) goto L217;
        addTimeout = true;
    L217:
        r7.setDoPrefetch(addTimeout);
        SysOptBridge.getFactory().getSysPrefetchService().setPrefetchProcessMaxSize(prefetchMaxNum);
        return true;
    L213:
        r6 = false;
        goto L214
    L219:
        data.enforceInterface("android.app.IActivityManager");
        int flag6 = data.readInt();
        SystemProperties.set(ISysPerfMonitorService.PROPERTY_NAME, String.valueOf(flag6));
        if (SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().getMonitorControlOpt() == flag6) goto L225;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().setMonitorControlOpt(flag6);
        ((TransferInternal) LocalServices.getService(TransferInternal.class)).notifyPropChanged(flag6, -1);
        if ((16 & SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().getMonitorControlOpt()) == 0) goto L224;
        SysOptBridge.getFactory().getGameBalanceService().setGameBalanceOpen(true);
        goto L225
    L224:
        SysOptBridge.getFactory().getGameBalanceService().setGameBalanceOpen(false);
    L225:
        return true;
    L226:
        SysOptBridge.getFactory().getProcessIntercept().switchBroadcastInterceptLog();
        return true;
    L228:
        SysOptBridge.getFactory().getProcessIntercept().switchServicesInterceptLog();
        return true;
    L230:
        SysOptBridge.getFactory().getProcessIntercept().switchProviderInterceptLog();
        return true;
    L232:
        SysOptBridge.getFactory().getProcessIntercept().switchInterceptLog();
        return true;
    L234:
        boolean enable3 = this.mMemProcessController.getEnable();
        this.mMemProcessController.setEnable(!enable3);
        StringBuilder r8 = new StringBuilder();
        r8.append("enabel = ");
        r8.append(!enable3);
        Slog.d("memory process controller", r8.toString());
        return true;
    L236:
        BroadcastQueue queue = this.mActivityManagerService.getBroadcastQueue();
        if (queue == null) goto L239;
        queue.getSmtEx().outputBDReceiverStatistics();
    L239:
        return true;
    L240:
        this.mBDReceiverStatsEnabled = !this.mBDReceiverStatsEnabled;
        Slog.d("Broadcast Receiver Statistics ", "mBDReceiverStatsEnabled = " + this.mBDReceiverStatsEnabled);
        BroadcastQueueSmtBase.setBDReceiverStatsEnabled(this.mBDReceiverStatsEnabled);
        if (this.mBDReceiverStatsEnabled == true) goto L245;
        BroadcastQueue queue2 = this.mActivityManagerService.getBroadcastQueue();
        if (queue2 == null) goto L245;
        queue2.getSmtEx().outputBDReceiverStatistics();
        queue2.getSmtEx().clearStats();
    L245:
        return true;
    L246:
        SysOptBridge.getFactory().getMemoryUtils().catProcStatus(data.readInt());
        return true;
    L248:
        long time = System.currentTimeMillis();
        EventsUtils.writePbEvent(time, 1000, "shutdown".getBytes());
        return true;
    L250:
        Trace.traceBegin(32, "debugPrefetch");
        String packageName3 = data.readString();
        int stopProc = data.readInt();
        if (stopProc != 1) goto L258;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("am force-stop " + packageName3);     // Catch: Exception -> L255
        Thread.sleep(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);     // Catch: Exception -> L255
    L255:
        e = move-exception;
        Slog.i("ActivityManagerService", "exception e=" + e);
    L258:
        SysOptBridge.getFactory().getSysPrefetchService().asyncStartPrefetchDelayed(packageName3, 0, false, 5);
        Trace.traceEnd(32);
        return true;
    L260:
        SysOptBridge.getFactory().getSysPrefetchService().asyncStartPrefetchDelayed(data.readString(), 0, false, 5);
        return true;
    L262:
        String packageName4 = data.readString();
        ArrayList<String> apps = new ArrayList();
        apps.add(packageName4);
        int level = data.readInt();
        Bundle bundle = new Bundle();
        if (level != 1) goto L266;
        r10 = 1;
    L266:
        bundle.putInt("prefetch_level", r10);
        bundle.putInt(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, 5);
        SysOptBridge.getFactory().getSysPrefetchService().asyncStartPrefetch(apps, bundle);
        return true;
    L268:
        int magic = data.readInt();
        switch(magic) {
            case 1: goto L294;
            case 2: goto L293;
            case 3: goto L292;
            case 4: goto L286;
            case 5: goto L271;
            default: goto L501;
        };
    L271:
        int uid5 = data.readInt();
        Slog.i("AMS.freeze", " fast freeze uid=" + uid5 + " freeze it");
        ActivityManagerService r9 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r9);
        Set<ProcessRecord> apps2 = getProcsByUidLocked(this.mActivityManagerService, uid5);     // Catch: Throwable -> L278
        if (apps2 != null) goto L276;
    L280:
        int size5 = apps2.size();     // Catch: Throwable -> L278
        monitor-exit(r9);     // Catch: Throwable -> L278
        ActivityManagerService.resetPriorityAfterLockedSection();
        reply.writeString("size=" + size5);
        return true;
    L276:
        if (apps2.isEmpty() == true) goto L280;
        SysOptBridge.getFactory().getApplicationFreezer().freezeProcessLocked(apps2.iterator().next(), true, IApplicationFreezer.FreezeReason.LIGHTNING, IApplicationFreezer.Mode.LIGHTNING, new IApplicationFreezer.FreezeInfo().setLightningTimeout(data.readInt()));     // Catch: Throwable -> L278
    L278:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L286:
        int pid3 = data.readInt();
        int tarUid = data.readInt();
        if (data.readInt() == 0) goto L289;
        addTimeout = true;
    L289:
        if (addTimeout == false) goto L291;
        SysOptBridge.getFactory().getApplicationFreezer().sendUnFreezeTimeoutMsg(pid3, tarUid);
        return true;
    L291:
        SysOptBridge.getFactory().getApplicationFreezer().removeUnfreezeTimeoutMsg(pid3, tarUid);
        return true;
    L292:
        SysOptBridge.getFactory().getSmartService().unFreezeAppsByStartProcess();
        return true;
    L293:
        int uid2 = data.readInt();
        Slog.i("AMS.freeze", " fast freeze uid=" + uid2 + " freeze except it");
        SysOptBridge.getFactory().getSmartService().freezeAppsIfNeeded(uid2, data.readInt());
        return true;
    L294:
        String pkgName2 = data.readString();
        int userId = data.readInt();
        if (data.readInt() != 0) goto L458;
        addTimeout = true;
    L458:
        int uid = this.mActivityManagerService.mContext.getPackageManager().getPackageUidAsUser(pkgName2, userId);     // Catch: PackageManager.NameNotFoundException -> L330
        if (uid != 0) goto L303;
        reply.writeString("uid not found");
        return true;
    L303:
        ActivityManagerService r14 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r14);
        Set<ProcessRecord> apps3 = getProcsByUidLocked(this.mActivityManagerService, uid);     // Catch: Throwable -> L319
        if (apps3 == null) goto L322;
        if (apps3.isEmpty() == true) goto L322;
        if (addTimeout == true) goto L466;
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeProcessLocked(apps3.iterator().next(), true, IApplicationFreezer.UnfreezeReason.NEED_NO_CONDITION, null);     // Catch: Throwable -> L317
        goto L322
    L466:
        SysOptBridge.getFactory().getApplicationFreezer().freezeProcessLocked(apps3.iterator().next(), true, IApplicationFreezer.FreezeReason.NO_CONDITION, IApplicationFreezer.Mode.DEFAULT, null);     // Catch: Throwable -> L312
    L312:
        th = th;
    L327:
        monitor-exit(r14);     // Catch: Throwable -> L317
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L322:
        int size = apps3.size();     // Catch: Throwable -> L317
        monitor-exit(r14);     // Catch: Throwable -> L317
        ActivityManagerService.resetPriorityAfterLockedSection();
        reply.writeString("size=" + size);
        return true;
    L317:
        th = th;
    L319:
        th = th;
    L330:
        e = move-exception;
        e.printStackTrace();
        reply.writeString("NameNotFoundException");
        return true;
    L501:
        return true;
    L333:
        String packageName5 = data.readString();
        if (SysOptBridge.getFactory().getPrefetchManager().isAllowStartPretch(packageName5) == false) goto L507;
        SysOptBridge.getFactory().getPrefetchManager().startPrefetchApp(packageName5);
        return true;
    L507:
        return true;
    L338:
        final int pid4 = data.readInt();
        int arg2 = data.readInt();
        if (3 != arg2) goto L341;
        boolean r0 = true;
    L342:
        boolean isEnableHook = r0;
        if (4 != arg2) goto L345;
        boolean r1 = true;
    L346:
        boolean isNetFilter = r1;
        if (5 != arg2) goto L349;
        boolean r11 = true;
    L350:
        boolean isCheckPidBinderSt = r11;
        if (arg2 != 0) goto L353;
        addTimeout = true;
    L353:
        int mode = data.readInt();
        int fastFreeze = data.readInt();
        if (fastFreeze != 1) goto L358;
        int uid3 = data.readInt();
        Slog.i("AMS.freeze", " fast freeze uid=" + uid3);
        SysOptBridge.getFactory().getSmartService().freezeAppsByStartProcess(uid3);
        return true;
    L358:
        if (isEnableHook == false) goto L361;
        SysOptBridge.getFactory().getApplicationFreezer().enableHook(pid4);
        return true;
    L361:
        if (isNetFilter == false) goto L364;
        SysOptBridge.getFactory().getApplicationFreezer().setNetFilter(pid4, mode);
        return true;
    L364:
        if (isCheckPidBinderSt == false) goto L366;
        SysOptBridge.getFactory().getApplicationFreezer().checkPidBinderSt(pid4);
    L366:
        ActivityManagerService r12 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r12);
        if (addTimeout == true) goto L440;
        ProcessRecord app = SysOptBridge.getFactory().getApplicationFreezer().traverse(new ActivityManagerServiceSmtBase$$ExternalSyntheticLambda3(pid4));     // Catch: Throwable -> L423
    L380:
        if (app == null) goto L426;
        if (ApplicationInfoSmt.isIMApp(app.info) == false) goto L385;
        app.getSmtEx().killType = 3;     // Catch: Throwable -> L377
    L386:
        Slog.d("ActivityManagerService", "freeze=" + addTimeout + ", app=" + app + ", killType=" + app.getSmtEx().killType);     // Catch: Throwable -> L423
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L423
        if (addTimeout == false) goto L493;
        if (mode == IApplicationFreezer.Mode.LIGHTNING.ordinal()) goto L450;
        ProcessRecord app2 = app;
    L406:
        th = th;
    L421:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L415
        throw th;     // Catch: Throwable -> L415
    L401:
        if (mode != IApplicationFreezer.Mode.LITE.ordinal()) goto L404;
        SysOptBridge.getFactory().getApplicationFreezer().freezeProcessLocked(app2, true, IApplicationFreezer.FreezeReason.NO_CONDITION, IApplicationFreezer.Mode.LITE, null);     // Catch: Throwable -> L395
    L443:
    L414:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L415
        goto L426
    L404:
        SysOptBridge.getFactory().getApplicationFreezer().freezeProcessLocked(app2, true, IApplicationFreezer.FreezeReason.NO_CONDITION, IApplicationFreezer.Mode.DEFAULT, null);     // Catch: Throwable -> L406
        goto L414
    L450:
        app2 = app;
        SysOptBridge.getFactory().getApplicationFreezer().freezeProcessLocked(app2, true, IApplicationFreezer.FreezeReason.NO_CONDITION, IApplicationFreezer.Mode.LIGHTNING, null);     // Catch: Throwable -> L395
    L397:
        th = th;
    L395:
        th = th;
    L408:
        th = th;
        goto L421
    L493:
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeProcessLocked(app, true, IApplicationFreezer.UnfreezeReason.NEED_NO_CONDITION, null);     // Catch: Throwable -> L417
    L417:
        th = th;
    L419:
        th = th;
        goto L421
    L385:
        app.getSmtEx().killType = 2;     // Catch: Throwable -> L423
    L426:
        monitor-exit(r12);     // Catch: Throwable -> L415
        ActivityManagerService.resetPriorityAfterLockedSection();
        return true;
    L423:
        th = th;
    L429:
        monitor-exit(r12);     // Catch: Throwable -> L415
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L440:
        ActivityManagerService.PidMap r13 = this.mActivityManagerService.mPidsSelfLocked;     // Catch: Throwable -> L377
        monitor-enter(r13);     // Catch: Throwable -> L377
        ProcessRecord app3 = this.mActivityManagerService.mPidsSelfLocked.get(pid4);     // Catch: Throwable -> L374
        monitor-exit(r13);     // Catch: Throwable -> L374
        app = app3;
        goto L380
    L374:
        th = move-exception;
        throw th;     // Catch: Throwable -> L377
    L377:
        th = th;
    L415:
        th = th;
        goto L429
    L349:
        r11 = false;
        goto L350
    L345:
        r1 = false;
        goto L346
    L341:
        r0 = false;
        goto L342
    L432:
        data.enforceInterface("android.app.IActivityManager");
        String subDir = data.readString();
        SysOptBridge.getFactory().getSmartService().deleteMonitorDailyFiles(subDir, true);
        return true;
    L5:
        return mSmtOptEx.onTransact(code, data, reply, flags);
    L464:
        Slog.i("ActivityManagerService", "send fakeJANK");     // Catch: Exception -> L11
        int type2 = data.readInt();     // Catch: Exception -> L11
        String layerName = data.readString();     // Catch: Exception -> L11
        long dur = data.readLong();     // Catch: Exception -> L11
        int currentFpsMode = data.readInt();     // Catch: Exception -> L11
        Slog.i("ActivityManagerService", "send fakeJANK type = " + type2 + "layerName = " + layerName + " dur " + dur + " currentFpsMode " + currentFpsMode);     // Catch: Exception -> L11
        SysMonitorSvcBridge.getFactory().getTransferController().checkJankPerfettoForTest(type2, layerName, dur, currentFpsMode);     // Catch: Exception -> L11
    L13:
        return true;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L499:
        int perf_code = data.readInt();     // Catch: Exception -> L17
        int time2 = data.readInt();     // Catch: Exception -> L17
        int type3 = data.readInt();     // Catch: Exception -> L17
        BoostFramework mPerfBoost = new BoostFramework();     // Catch: Exception -> L17
        mPerfBoost.perfHint(perf_code, "testForBoostFramework", time2, type3);     // Catch: Exception -> L17
    L19:
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L460:
        data.setDataPosition(0);     // Catch: Exception -> L86
        data.enforceInterface("android.app.IActivityManager");     // Catch: Exception -> L86
        int type4 = data.readInt();     // Catch: Exception -> L86
        int callerPid = data.readInt();     // Catch: Exception -> L86
        int targetUid = data.readInt();     // Catch: Exception -> L86
        int targetPid = data.readInt();     // Catch: Exception -> L86
        String rpcName = data.readString();     // Catch: Exception -> L86
        int rpcCode = data.readInt();     // Catch: Exception -> L86
        int intParam = data.readInt();     // Catch: Exception -> L86
        SysOptBridge.getFactory().getApplicationFreezer().triggerForKernel(type4, callerPid, targetUid, targetPid, rpcName, rpcCode, intParam);     // Catch: Exception -> L86
    L88:
        return true;
    L86:
        e = move-exception;
        Slog.e("ActivityManagerService", "triggerForKernel e:", e);
        goto L88
    L482:
        int res = data.readInt();     // Catch: Exception -> L94
        if (res != 2) goto L98;
        ParcelFileDescriptor fd = data.readFileDescriptor();     // Catch: Exception -> L94
        this.mBinderStat.binderTransactStat(fd);     // Catch: Exception -> L94
    L98:
        return true;
    L94:
        e = move-exception;
        Slog.e("ActivityManagerService", "bindet stat save data", e);
        goto L98
    L446:
        int ownerPid = data.readInt();     // Catch: Exception -> L102
        int callerPid2 = data.readInt();     // Catch: Exception -> L102
        int type5 = data.readInt();     // Catch: Exception -> L102
        String path = this.mBinderStat.binderTransactStat(type5, ownerPid, callerPid2);     // Catch: Exception -> L102
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(new File(path), LZMA2Options.DICT_SIZE_MAX);     // Catch: Exception -> L102
        reply.writeFileDescriptor(pfd.getFileDescriptor());     // Catch: Exception -> L102
        pfd.close();     // Catch: Exception -> L102
    L104:
        return true;
    L102:
        e = move-exception;
        Slog.e("ActivityManagerService", "binder stat create FileDescriptor", e);
        goto L104
    L454:
        data.setDataPosition(0);     // Catch: Exception -> L108
        data.enforceInterface("android.app.IActivityManager");     // Catch: Exception -> L108
        int uid4 = data.readInt();     // Catch: Exception -> L108
        int action = data.readInt();     // Catch: Exception -> L108
        String pkg = data.readString();     // Catch: Exception -> L108
        String proc = data.readString();     // Catch: Exception -> L108
        String reason = data.readString();     // Catch: Exception -> L108
        SysOptBridge.getFactory().getProcessGuard().keepAliveBackground(uid4, pkg, proc, action, reason);     // Catch: Exception -> L108
    L110:
        return true;
    L108:
        e = move-exception;
        Slog.e("ActivityManagerService", "keepAliveBackground e:", e);
        goto L110
    }

    private static /* synthetic */ ProcessRecord lambda$onTransactSmtEx$0(int pid, ProcessRecord fapp) {
        if (fapp.getSmtEx().pid != pid) goto L5;
        return fapp;
    L5:
        return null;
    }

    protected ProcessRecord getProcessRecordLock(int pid) {
        Iterator<ProcessRecord> r0 = this.mActivityManagerService.mProcessList.mLruProcesses.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        ProcessRecord r = r0.next();
        if (pid == r.getPid()) goto L11;
        if (pid != r.getSmtEx().pid) goto L4;
    L11:
        return r;
    L12:
        return null;
    }

    private static void initPackageRequireAvaMap() {
        sPackageRequireAvaMap = new HashMap();
    }

    private static void initPackageRequireFreeMap() {
        sPackageRequireFreeMap = new HashMap();
    }

    private static void initTargetSet() {
        sTargetPackage = new HashSet();
    }

    private static void initPackageStartTimeMap() {
        sPackageStartTimeMap = new HashMap();
    }

    public void trimSystemMemoryIfNeeded(String processName, ApplicationInfo info) {
        if (SysOptBridge.getFactory().getXBTest().isInTrimMemTestMode() == true) goto L5;
        return;
    L5:
        if (info == null) goto L79;
        if (info.packageName == null) goto L79;
        if (processName.equals(info.packageName) == false) goto L79;
        if (sTargetPackage.contains(info.packageName) == false) goto L75;
        if (LAUNCHER_PKGNAME.equals(info.packageName) == true) goto L75;
        String pkgName = info.packageName;
        if (pkgName != this.mLaunchingPackageName) goto L19;
        return;
    L19:
        this.mLaunchingPackageName = pkgName;
        if (LAUNCHER_PKGNAME.equals(info.packageName) == false) goto L22;
        return;
    L22:
        MemInfoReader memInfo = new MemInfoReader();
        memInfo.readMemInfo();
        SysOptBridge.getFactory().getSysPrefetchService().temporaryStop(40000);
        ArrayList<KillingPriority> records = new ArrayList();
        HashSet<Integer> addedUids = new HashSet();
        ActivityManagerService.PidMap r8 = this.mActivityManagerService.mPidsSelfLocked;
        monitor-enter(r8);
        int size = this.mActivityManagerService.mPidsSelfLocked.size();     // Catch: Throwable -> L44
        int i = 0;
    L25:
        if (i >= size) goto L61;
        ProcessRecord proc = this.mActivityManagerService.mPidsSelfLocked.valueAt(i);     // Catch: Throwable -> L44
        if (proc != null) goto L29;
    L58:
        int size2 = size;
    L59:
        i = i + 1;     // Catch: Throwable -> L44
        size = size2;
        goto L25
    L29:
        if (proc.info == null) goto L58;
        if (proc.info.packageName == null) goto L58;
        if (sTargetPackage.contains(proc.info.packageName) == true) goto L35;
        size2 = size;
        goto L59
    L35:
        if (proc.info.packageName.equals(pkgName) == false) goto L37;
        size2 = size;
        goto L59
    L37:
        int adj = proc.mState.getSetAdj();     // Catch: Throwable -> L44
        if (adj >= 900) goto L40;
    L46:
        size2 = size;
        if (adj >= 900) goto L59;
        if (addedUids.contains(Integer.valueOf(proc.uid)) == false) goto L59;
        ArrayList<KillingPriority> temp = new ArrayList();     // Catch: Throwable -> L44
        temp.addAll(records);     // Catch: Throwable -> L44
        Iterator<KillingPriority> r12 = temp.iterator();     // Catch: Throwable -> L44
    L52:
        if (r12.hasNext() == false) goto L59;
        KillingPriority pr = r12.next();     // Catch: Throwable -> L44
        if (pr.uid != proc.uid) goto L52;
        records.remove(pr);     // Catch: Throwable -> L44
        goto L52
    L40:
        if (proc.isKilledByAm() == true) goto L46;
        if (addedUids.contains(Integer.valueOf(proc.uid)) == true) goto L46;
        size2 = size;
        KillingPriority kp = new KillingPriority(this, proc.uid, proc.info.packageName, sPackageStartTimeMap.get(proc.info.packageName).intValue());     // Catch: Throwable -> L44
        records.add(kp);     // Catch: Throwable -> L44
        addedUids.add(Integer.valueOf(proc.uid));     // Catch: Throwable -> L44
        goto L59
    L61:
        monitor-exit(r8);     // Catch: Throwable -> L44
        if (records.isEmpty() == true) goto L65;
    L67:
        records.sort(this.mKPC);
        Iterator<KillingPriority> r0 = records.iterator();
    L69:
        if (r0.hasNext() == false) goto L71;
        KillingPriority r9 = r0.next();
        goto L69
    L71:
        return;
    L65:
        if (sTrimDebugEnable == false) goto L67;
        Slog.e(TRIM_TAG, "can not find proc to reclaim, trim return for:" + processName);
    L44:
        th = move-exception;
        throw th;
    L75:
        if (sTrimDebugEnable == false) goto L95;
        Slog.e(TRIM_TAG, "not target app, trim fail for:" + processName);
        return;
    L95:
        return;
    L79:
        if (sTrimDebugEnable == false) goto L96;
        Slog.e(TRIM_TAG, "info is null, trim fail for:" + processName);
        return;
    }

    protected boolean isPcModeDisplayId(ProcessRecord r) {
        return false;
    }

    public void addPendingLaunchRecord(ActivityRecord r) {
        List<ActivityRecord> r0 = this.mActivityManagerService.m1221getMonitorEx().mPendingLaunchRecords;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivityManagerService.m1221getMonitorEx().mPendingLaunchRecords.size() <= 10) goto L9;
        Slog.i("ActivityManagerService", "clear all has not complete start activity when pending size > 10");     // Catch: Throwable -> L7
        this.mActivityManagerService.m1221getMonitorEx().mPendingLaunchRecords.clear();     // Catch: Throwable -> L7
    L9:
        this.mActivityManagerService.m1221getMonitorEx().mPendingLaunchRecords.add(r);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void systemReady(Context context, Handler handler) {
        ActivityManagerService r1 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        readChainBootBlackList();     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        BinderCallCacheAgentOpt.isCalledFromSystemServer = true;
        this.mActivityManagerService.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SETTING_DATA_APP_LAUNCH_PREDICT), false, this.mAppLaunchPredict, -1);
        this.mActivityManagerService.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SETTING_DATA_PREDICT_NEXT_APP), false, this.mNextAppPredict, -1);
        this.mActivityManagerService.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SETTING_DATA_PREDICT_SCENE_APP), false, this.mPredictSceneApp, -1);
        this.mAppStartEventOwner = new AppStartEventOwner(this);
        SysOptBridge.getFactory().getDecisionMaker().systemReady(this.mActivityManagerService, this.mActivityManagerService.mContext, new ActivityManagerServiceSmtBase$$ExternalSyntheticLambda0(), new ActivityManagerServiceSmtBase$$ExternalSyntheticLambda1(), new ActivityManagerServiceSmtBase$$ExternalSyntheticLambda2());
        this.mApp3rdPerceptibleStateOwner = new App3rdPerceptibleStateOwner(this);
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ String lambda$systemReady$1(ProcessRecord r) {
        if (r != null) goto L4;
    L7:
        return null;
    L4:
        if (r.info == null) goto L7;
        return r.info.packageName;
    }

    private static /* synthetic */ String lambda$systemReady$2(ProcessRecord r) {
        if (r != null) goto L5;
        return null;
    L5:
        return r.processName;
    }

    private static /* synthetic */ int lambda$systemReady$3(ProcessRecord r) {
        if (r != null) goto L4;
    L7:
        return 0;
    L4:
        if (r.info == null) goto L7;
        return r.info.uid;
    }

    public void notifyActivityEventToResManager(int event, Parcel data) {
        if (this.mAppStartEventOwner != null) goto L5;
        this.mAppStartEventOwner = new AppStartEventOwner(this);
    L5:
        this.mAppStartEventOwner.notifyEvent(event, data);
    }

    public void amsSystemReadyEarlyPhase() {
        SysOptBridge.getFactory().getProcessIntercept().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getAppRecordManagerService().startService(this.mActivityManagerService);
        SysOptBridge.getFactory().getProcessGuardService().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getAppStartStatistics().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getXBTest().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getDefragManager().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getSchedExtService().startService();
        SysOptBridge.getFactory().getKernelTrigger().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getCollaborationManagerService().init(this.mActivityManagerService);
        SysOptBridge.getFactory().getOAutoHelper().init(this.mActivityManagerService);
    }

    protected void start() {
    }

    public void reportKillingEvent(String killEvent) {
        this.killStats.reportKillingEvent(killEvent);
    }

    private void valueToLittleEndian(int value, byte[] data, int index) {
        data[index] = (byte) (value & 255);
        data[index + 1] = (byte) ((value >> 8) & 255);
        data[index + 2] = (byte) ((value >> 16) & 255);
        data[index + 3] = (byte) ((value >> 24) & 255);
    }

    private void notifyStabdBlockLogoStatus(int blockStage, int timeOut) {
        FileOutputStream fileOutputStream = null;
        File file = new File("/dev/stabd");
        byte[] data = new byte[8];
        valueToLittleEndian(blockStage, data, 0);
        valueToLittleEndian(timeOut, data, 4);
        if (file.exists() == false) goto L30;
        fileOutputStream = new FileOutputStream(file);     // Catch: Throwable -> L9 Exception -> L11
        fileOutputStream.write(data);     // Catch: Throwable -> L9 Exception -> L11
        fileOutputStream.close();     // Catch: IOException -> L7
    L23:
        return;
    L9:
        th = move-exception;
        if (fileOutputStream != null) goto L26;
    L17:
        throw th;
    L26:
        fileOutputStream.close();     // Catch: IOException -> L16
    L19:
        if (fileOutputStream == null) goto L31;
        fileOutputStream.close();     // Catch: IOException -> L7
        goto L23
    L31:
        return;
    L30:
        return;
    }

    public void monitorAppDiedLocked(ProcessRecord app) {
        Intent homeIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
        ResolveInfo homeInfo = this.mActivityManagerService.mContext.getPackageManager().resolveActivity(homeIntent, 0);
        if (app.processName == null) goto L19;
        if (homeInfo != null) goto L6;
        return;
    L6:
        if (homeInfo.activityInfo != null) goto L8;
        return;
    L8:
        if (app.processName.equals(homeInfo.activityInfo.packageName) == true) goto L10;
        return;
    L10:
        if (this.mHomeAppCrashedTime != 0) goto L12;
        this.mHomeAppCrashCount = 1;
        this.mHomeAppCrashedTime = SystemClock.uptimeMillis();
        return;
    L12:
        this.mHomeAppCrashCount++;
        if (this.mHomeAppCrashCount < 6) goto L24;
        this.mHomeAppCrashCount = 0;
        if ((SystemClock.uptimeMillis() - this.mHomeAppCrashedTime) > 60000) goto L17;
        Slog.i("ActivityManagerService", app.processName + " has crashed too many times, notify stabd!!!");
        notifyStabdBlockLogoStatus(8, 0);
    L17:
        this.mHomeAppCrashedTime = 0;
        return;
    L24:
        return;
    }

    public static void setCpuStateProvider(ActivityManagerServiceSysMoEx.CpuStateProvider p) {
        sCpuStateProvider = p;
    }

    public static void registerCpuStateObserver(ActivityManagerServiceSysMoEx.CpuStateObserver observer) {
        if (sCpuStateProvider == null) goto L6;
        sCpuStateProvider.registerCpuStateObserver(observer);
        return;
    }

    public static void unregisterCpuStateObserver(ActivityManagerServiceSysMoEx.CpuStateObserver observer) {
        if (sCpuStateProvider == null) goto L6;
        sCpuStateProvider.unregisterCpuStateObserver(observer);
        return;
    }

    public static void setUidCpuUsageProvider(UidCpuUsageProvider p) {
        sUidCpuUsageProvider = p;
    }

    public static void registerUidCpuInfoObserver(UidCpuUsageObserver observer) {
        if (sUidCpuUsageProvider == null) goto L6;
        sUidCpuUsageProvider.registerUidCpuUsageObserver(observer);
        return;
    }

    public static void unregisterUidCpuInfoObserver(UidCpuUsageObserver observer) {
        if (sUidCpuUsageProvider == null) goto L6;
        sUidCpuUsageProvider.unregisterUidCpuUsageObserver(observer);
        return;
    }

    public static ArrayList<ProcessRecord> getLruProcesses(ActivityManagerService ams) {
        return ams.mProcessList.mLruProcesses;
    }

    public static ProcessMap<ProcessRecord> getProcessNames(ActivityManagerService ams) {
        return ams.mProcessList.getProcessNamesLOSP();
    }

    public static UidRecord activeUidsGetLocked(ActivityManagerService ams, int uid) {
        int smtUid = -1;
        if (uid >= 0) goto L5;
        smtUid = uid;
        uid = 1000;
    L5:
        UidRecord uidRecord = ams.mProcessList.mActiveUids.get(uid);
        if (smtUid != (-1)) goto L8;
        return uidRecord;
    L8:
        return uidRecord.getSmtEx().getSystemSmtUidRecord(smtUid, ams);
    }

    public static Set<ProcessRecord> getProcsByUidLocked(ActivityManagerService ams, int uid) {
        if (uid == 1000) goto L10;
        UidRecord uidRecord = activeUidsGetLocked(ams, uid);
        if (uidRecord == null) goto L10;
        if (uidRecord.procRecords.isEmpty() == true) goto L10;
        return uidRecord.procRecords;
    L10:
        Set<ProcessRecord> procs = new ArraySet();
        Iterator<ProcessRecord> r1 = getLruProcesses(ams).iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        ProcessRecord proc = r1.next();
        if (proc.info.uid == uid) goto L18;
        if (proc.info.getSmtUid() != uid) goto L12;
    L18:
        procs.add(proc);
        goto L12
    L19:
        return procs;
    }

    public static void pidsSelfPutLocked(ActivityManagerService ams, ProcessRecord app) {
        ams.addPidLocked(app);
    }

    public static void pidsSelfRemoveLocked(ActivityManagerService ams, ProcessRecord app) {
        ams.removePidLocked(app.getPid(), app);
    }

    public static ProcessRecord pidsSelfGet(ActivityManagerService ams, int pid) {
        ActivityManagerService.PidMap r0 = ams.mPidsSelfLocked;
        monitor-enter(r0);
        ProcessRecord r1 = ams.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    final void scheduleUpdateOomAdj(boolean immediately) {
        scheduleUpdateOomAdj(immediately, 0);
    }

    final void scheduleUpdateOomAdj(boolean immediately, long delay) {
        if (immediately == false) goto L14;
        ActivityManagerService r3 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mActivityManagerService.mHandler.removeMessages(UPDATE_OOM_MSG);     // Catch: Throwable -> L10
        this.mActivityManagerService.updateOomAdjLocked(0);     // Catch: Throwable -> L10
        this.mNextUpdateOomTime = Long.MAX_VALUE;     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L14:
        long now = SystemClock.uptimeMillis();
        long min_delay = Math.max(delay, 50);
        long requestTime = now + min_delay;
        if (requestTime <= this.mNextUpdateOomTime) goto L18;
        return;
    L18:
        if (this.mNextUpdateOomTime >= Long.MAX_VALUE) goto L20;
        this.mActivityManagerService.mHandler.removeMessages(UPDATE_OOM_MSG);
    L20:
        this.mNextUpdateOomTime = requestTime;
        this.mActivityManagerService.mHandler.sendMessageDelayed(this.mActivityManagerService.mHandler.obtainMessage(UPDATE_OOM_MSG), min_delay);
    }

    public void setSystemProcess() {
        this.mTransferService.publish(this.mActivityManagerService.mContext, false);
    }

    public void resumeDelayFreezingAppActivity(int pid) {
        ProcessRecord app = null;
        if (pid == ActivityManagerService.MY_PID) goto L13;
        if (pid < 0) goto L13;
        ActivityManagerService.PidMap r1 = this.mActivityManagerService.mPidsSelfLocked;
        monitor-enter(r1);
        app = this.mActivityManagerService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        if (app != null) goto L15;
        return;
    L15:
        if (app.getSmtEx().delayFreezing == false) goto L21;
        this.mActivityManagerService.mAtmInternal.resumeTopActivities(false);
        return;
    }

    private void sendCheckForceCpusetProcTask(long delayTime) {
        HashMap<Integer, ForceCpusetProc> r0 = this.mForceCpusetProcs;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPostedCheckCpusetTask == true) goto L9;
        BackgroundThread.getHandler().postDelayed(this.mCheckForceCpusetProcTask, delayTime);     // Catch: Throwable -> L7
        this.mPostedCheckCpusetTask = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void addNewForceCpusetProc(int pid, int processGroup, long timeOut) {
        HashMap<Integer, ForceCpusetProc> r1 = this.mForceCpusetProcs;
        monitor-enter(r1);
        ForceCpusetProc proc = new ForceCpusetProc(this, pid, processGroup, timeOut);     // Catch: Throwable -> L20
        if (timeOut > 0) goto L10;
        long timeOut2 = timeOut;
    L17:
        proc.forceSetCpuset();     // Catch: Throwable -> L14
        this.mForceCpusetProcs.put(Integer.valueOf(pid), proc);     // Catch: Throwable -> L14
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 30, "add new force cpuset proc :" + pid + "  processGroup : " + processGroup + "  timeout" + timeOut2);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L10:
        if (timeOut <= CHECK_TASK_DEFAULT_TIME) goto L12;
        timeOut2 = CHECK_TASK_DEFAULT_TIME;
    L13:
        sendCheckForceCpusetProcTask(timeOut2);     // Catch: Throwable -> L14
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 30, "send check task for add new cpuset proc.");     // Catch: Throwable -> L14
        goto L17
    L12:
        timeOut2 = timeOut;
    L20:
        th = move-exception;
        Throwable r9 = th;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw r9;
    L22:
        th = move-exception;
        r9 = th;
    L14:
        th = move-exception;
        r9 = th;
        goto L24
    }

    private void removeForceCpusetProc(int pid) {
        HashMap<Integer, ForceCpusetProc> r0 = this.mForceCpusetProcs;
        monitor-enter(r0);
        ForceCpusetProc proc = this.mForceCpusetProcs.remove(Integer.valueOf(pid));     // Catch: Throwable -> L7
        if (proc == null) goto L9;
        proc.curProcessGroup = -1;     // Catch: Throwable -> L7
        proc.forceSetCpuset();     // Catch: Throwable -> L7
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 40, "remove force cpuset proc :" + pid);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateProcessFinalCpusetLevel(int pid, int cpusetLevel, int scenes, long timeOut, boolean force) {
        if (cpusetLevel >= 0) goto L5;
    L8:
        int cpusetLevel2 = 0;
    L9:
        ActivityManagerService r7 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r7);
        ProcessRecord app = null;
        ProcessStateRecord state = null;
        int i = this.mActivityManagerService.mProcessList.mLruProcesses.size() - 1;     // Catch: Throwable -> L18
    L14:
        if (i < 0) goto L21;
        ProcessRecord proc = this.mActivityManagerService.mProcessList.mLruProcesses.get(i);     // Catch: Throwable -> L18
        if (proc.getPid() == pid) goto L17;
        i = i - 1;     // Catch: Throwable -> L18
        goto L14
    L17:
        app = proc;
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 20, "find process :" + proc);     // Catch: Throwable -> L18
    L21:
        if (app == null) goto L23;
        state = app.mState;     // Catch: Throwable -> L18
        app.getSmtEx().updateFinalCpusetLevel(cpusetLevel2, scenes, timeOut);     // Catch: Throwable -> L18
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 20, "update lru process  :" + app + "  final cpuset level: " + cpusetLevel2 + "  timeout" + timeOut + "   scenes : " + scenes);     // Catch: Throwable -> L18
    L23:
        if (force == false) goto L38;
        int processGroup = -1;
        if (cpusetLevel2 != 1) goto L28;
        processGroup = 5;
    L30:
        if (cpusetLevel2 != 0) goto L32;
        state.setSetSchedGroup(2);     // Catch: Throwable -> L18
        removeForceCpusetProc(pid);     // Catch: Throwable -> L18
        goto L38
    L32:
        int schedGroup = 2;
        switch(processGroup) {
            case 5: goto L36;
            case 14: goto L35;
            default: goto L37;
        };     // Catch: Throwable -> L18
    L35:
        schedGroup = 12;
        goto L37
    L36:
        schedGroup = 3;
    L37:
        state.setSetSchedGroup(schedGroup);     // Catch: Throwable -> L18
        addNewForceCpusetProc(pid, processGroup, timeOut);     // Catch: Throwable -> L18
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 20, "update force process  :" + app + "  final cpuset level: " + cpusetLevel2 + "  timeout" + timeOut + "   scenes : " + scenes);     // Catch: Throwable -> L18
        goto L38
    L28:
        if (cpusetLevel2 != 5) goto L30;
        processGroup = 14;
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L18
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L18:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (cpusetLevel >= 6) goto L8;
        cpusetLevel2 = cpusetLevel;
        goto L9
    }

    public void setProcessRunningCpuset(int pid, int cpusetLevel, long timeOut, boolean force) {
        SysOptBridge.getFactory().getSmtResourceControl().setProcessRunningCpuset(pid, cpusetLevel, timeOut, force);
    }

    public void forceStopPackage(String packageName, int userId, String reason) {
        this.mActivityManagerService.forceStopPackage(packageName, userId, reason);
    }

    boolean checkApplicationPrefetchStatus(boolean fromPrefetch, ActivityInfo aInfo, String app_str, int prefetchLevel, int reason) {
        if (SysOptBridge.getFactory().getSysPrefetchService().isDoPrefetch() == true) goto L6;
        return false;
    L6:
        if (fromPrefetch == true) goto L8;
    L37:
        return true;
    L8:
        if (aInfo.applicationInfo == null) goto L37;
        if (aInfo.applicationInfo.getSysEx().goodToStartInBG(SystemClock.elapsedRealtime()) == true) goto L12;
        return false;
    L12:
        SysOptBridge.getFactory().getSysPrefetchService().addSystemAppNoPrefetch(app_str);
        if (SysOptBridge.getFactory().getSysPrefetchService().checkSystemAppNoPrefetch(app_str) == false) goto L15;
        return false;
    L15:
        ProcessRecord prefetchProcess = (ProcessRecord) this.mActivityManagerService.mProcessList.getSmtEx().mPrefetchProcess.get(app_str, aInfo.applicationInfo.uid);
        if (prefetchProcess != null) goto L20;
        prefetchProcess = (ProcessRecord) this.mActivityManagerService.mProcessList.getProcessNamesLOSP().get(app_str, aInfo.applicationInfo.uid);
        if (prefetchProcess != null) goto L20;
        prefetchProcess = SysOptBridge.getFactory().getApplicationFreezer().get(app_str, aInfo.applicationInfo.uid);
    L20:
        if (prefetchProcess == null) goto L23;
        return false;
    L23:
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L31;
        StringBuilder r3 = new StringBuilder();
        r3.append("attachApplicationCheckPrefetch app=null. doPrefetch=");
        r3.append(aInfo.applicationInfo.getSysEx().doPrefetch);
        r3.append(" prefetchState=");
        r3.append(aInfo.applicationInfo.getSysEx().prefetchState);
        r3.append(" set to ");
        if (mSmtOptEx.isFreezeEnable() == false) goto L28;
        if (prefetchLevel != 2) goto L28;
        int r6 = 4;
    L29:
        r3.append(r6);
        Slog.i("SmartPrefetch", r3.toString());
    L28:
        r6 = 1;
    L31:
        if (mSmtOptEx.isFreezeEnable() == false) goto L34;
        if (prefetchLevel != 2) goto L34;
        aInfo.applicationInfo.getSysEx().doPrefetch = 4;
    L36:
        aInfo.applicationInfo.getSysEx().prefetchState |= 1;
        aInfo.applicationInfo.getSysEx().prefetchReason = reason;
        FeatLog.d("ActivityManagerService", "FEAT_PERF_PREFETCH", 0, "system_server: start prefetch process = " + app_str + ", doPrefetch = " + aInfo.applicationInfo.getSysEx().doPrefetch + ", reason = " + reason);
    L34:
        if (prefetchLevel != 1) goto L36;
        aInfo.applicationInfo.getSysEx().doPrefetch = 1;
        goto L36
    }

    boolean attachApplicationCheckPrefetch(ProcessRecord app) {
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L6;
        Slog.i("SmartPrefetch", "attachApplicationCheckPrefetch app=" + app + ". doPrefetch=" + app.info.getSysEx().doPrefetch + " prefetchState=" + app.info.getSysEx().prefetchState);
    L6:
        if (app.info.getSysEx().doPrefetch != 2) goto L8;
    L9:
        app.mState.setSetAdj(900);
        app.mState.setCurAdj(900);
        app.mState.setVerifiedAdj(900);
        ProcessList.setOomAdj(app.getPid(), app.uid, app.mState.getCurAdj());
        SysOptBridge.getFactory().getSysPrefetchService().notifyPrefetched(app.info.packageName, app.uid, app.getPid());
        FeatLog.d("ActivityManagerService", "FEAT_PERF_PREFETCH", 20, "system_server: process = " + app.processName + "    prefetch attach application done!");
    L11:
        if (app.info.getSysEx().doPrefetch != 2) goto L14;
        return true;
    L14:
        return false;
    L8:
        if (SysMonitorFwBridge.getFactory().getPrefetchState().inPrefetchState(app.info.getSysEx().prefetchState) == false) goto L11;
        goto L9
    }

    void needUpdateLruForPrefetchApp(ProcessRecord app) {
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().updateUidVersion(app.uid, app.info.longVersionCode);
        if (app.info.getSysEx().doPrefetch != 3) goto L6;
        FeatLog.d("ActivityManagerService", "FEAT_PERF_PREFETCH", 40, "system_server: update LRU for prefetch process = " + app.processName);
        this.mActivityManagerService.updateLruProcessLocked(app, false, null);
        app.mProfile.setLastRequestedGc(SystemClock.uptimeMillis());
        app.mProfile.setLastLowMemory(SystemClock.uptimeMillis());
        return;
    }

    void attachApplicationEnd(ProcessRecord app) {
        app.getSmtEx().attachCompleted = true;
        if (app.info.getSysEx().doPrefetch != 4) goto L5;
        app.info.getSysEx().doPrefetch = 0;
    L12:
        app.getSmtEx().isStartDuringPrefetch = false;
        return;
    L5:
        if (app.info.getSysEx().doPrefetch != 3) goto L8;
        SysOptBridge.getFactory().getSysPrefetchService().notifyPrefetchSuccess(app.info.packageName, app.uid);
        FeatLog.d("ActivityManagerService", "FEAT_PERF_PREFETCH", 50, "system_server: complete attach application for process = " + app.processName);
    L8:
        if (ActivityManagerDebugConfig.DEBUG_PREFETCH == false) goto L10;
        Slog.i("SmartPrefetch", "attachApplicationEnd doPrefetch=" + app.info.getSysEx().doPrefetch + " prefetchState=" + app.info.getSysEx().prefetchState + " set to NONE");
    L10:
        app.info.getSysEx().doPrefetch = 0;
        goto L12
    }

    public void updatePrefetchApps(List<String> needPrefetchApps, int hour, int flag) {
        SysOptBridge.getFactory().getSysPrefetchService().updatePrefetchApps(needPrefetchApps, hour, flag);
    }

    public void updatePrefetchNextApp(List<String> nextAppList) {
        SysOptBridge.getFactory().getSysPrefetchService().updatePrefetchNextApp(nextAppList);
    }

    public boolean isScreenOn() {
        if (this.mActivityManagerService.mWakefulness.get() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setSoundProcessMemoryStrategy(boolean flag) {
        SysMonitorSvcBridge.getFactory().getMemoryStrategy().setSoundProcessMemoryStrategy(flag);
    }

    public boolean getUidFrozen(int uid) {
        return SysOptBridge.getFactory().getApplicationFreezer().isUidFrozen(uid);
    }

    boolean shouldPutBackground(ProcessRecord app, long nowElapsed) {
        if (debug3rd == false) goto L6;
        Slog.d("ActivityManagerService", "THREAD_GROUP_BG_3RD_APP shouldPutBackground app:" + app + " unlimited:" + app.info.getSysEx().isLimited);
    L6:
        if (goodToOperateProc(app.info.packageName) == true) goto L12;
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L10;
        Slog.d("ActivityManagerService", "goodToOperateProc, app: " + app + " uid: " + app.uid + " not feet new perceptible condition");
    L10:
        return false;
    L12:
        if (app.info.getSysEx().goodToOperateProc(nowElapsed, 4) == true) goto L18;
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L16;
        Slog.d("ActivityManagerService", "app: " + app + " was perceptible at: " + app.info.getSysEx().perceptibleTime + ", nowElapsed is: " + nowElapsed);
    L16:
        return false;
    L18:
        if (SysOptBridge.getFactory().getActivityManager(this.mActivityManagerService).getmEnablePeropt() == true) goto L21;
        return false;
    L21:
        if (app.info.getSysEx().isLimited != 0) goto L29;
        if (SysOptBridge.getFactory().getActivityManager(this.mActivityManagerService).getmUidCpuRunner().getCpuBusyCount() >= 5) goto L29;
        if (ActivityManagerDebugConfigSmtEx.DEBUG_3RD_BG_APP == false) goto L27;
        Slog.d("ActivityManagerService", "app: " + app + " unlimited: " + app.info.getSysEx().isLimited);
    L27:
        return false;
    L29:
        if (SysOptBridge.getFactory().getActivityManager(this.mActivityManagerService).getmUidCpuRunner().getCpuBusyCount() != 0) goto L38;
        if (SysOptBridge.getFactory().getActivityManager(this.mActivityManagerService).getmPackStats().getOrder(app.uid, 100) >= 3) goto L38;
        if (SysOptBridge.getFactory().getActivityManager(this.mActivityManagerService).getmPackStats().isRecent(nowElapsed, HeartbeatStats.MAX_NAT_TIME_MS, app.uid) == false) goto L38;
        return false;
    L38:
        if ((app.info.getSysEx().bytedanceFlag & 2) == 0) goto L40;
        return false;
    L40:
        return true;
    }

    public void setAppSlowMainOperations(List<String> slowOperations, int index) {
        this.mTransferService.setAppSlowMainOperation(slowOperations, index);
    }

    public void setSmtExtraInfo(int pid, String info) {
        ActivityManagerService.PidMap r0 = this.mActivityManagerService.mPidsSelfLocked;
        monitor-enter(r0);
        ProcessRecord proc = this.mActivityManagerService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L7
        if (proc == null) goto L9;
        proc.getSmtEx().setSmtExtraInfo(info);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void forceStopPackageSmart(String packageName, int userId, int taskId, int cleanLevel) {
        long callingId = Binder.clearCallingIdentity();
        Slog.d("ActivityManagerService", "Smart forceStopPackage: packageName=" + packageName + ", userId=" + userId + " taskId=" + taskId + " cleanLevel=" + cleanLevel + "needForceStop=false");     // Catch: Throwable -> L7
        if (0 == 0) goto L9;
        SysOptBridge.getFactory().getTaskDeepClean().addTdcEvent(1, cleanLevel, packageName, 0);     // Catch: Throwable -> L7
        this.mActivityManagerService.forceStopPackage(packageName, userId, "task deep clean");     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(callingId);
        return;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public final void registerSysClient(ISysClient client) {
        int callingPid = Binder.getCallingPid();
        SysMonitorSvcBridge.getFactory().getAnrMonitor().addClient(callingPid, client);
    }

    public String getSmtExtraInfo(int pid) {
        ActivityManagerService.PidMap r0 = this.mActivityManagerService.mPidsSelfLocked;
        monitor-enter(r0);
        ProcessRecord proc = this.mActivityManagerService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L9
        if (proc == null) goto L12;
        long bootTime = System.currentTimeMillis() - SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        String r4 = proc.getSmtEx().getSmtExtraInfo() + "\nstart_time : " + proc.getStartTime() + bootTime;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public void asyncSetProcessGroup(final int pid, final int processGroup) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass6(this, pid, processGroup));
    }

    public static long getRomFreeMemoryKb() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long availableBytes = stat.getAvailableBytes();
        return availableBytes / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
    }

    public final boolean platformAllowKillProcess(ProcessRecord app) {
        return true;
    }

    public boolean isTNTPadMode() {
        return false;
    }

    public boolean checkApplication(ProcessRecord app) {
        UidRecord uidRecord = this.mActivityManagerService.mProcessList.getUidRecordLOSP(app.uid);
        if (uidRecord != null) goto L5;
        return false;
    L5:
        if (uidRecord.getProcRecords().indexOf(app) < 0) goto L10;
        return true;
    L10:
        return false;
    }

    public void checkCrashMessage(ApplicationErrorReport.CrashInfo crashInfo, ProcessRecord r) {
        if (r == null) goto L15;
    L9:
        e = move-exception;
        Slog.e("ActivityManagerService", "checkCrashMessage failed", e);
        return;
    L4:
        if (r.info.getSysEx().mOverrideClassSDK == 1) goto L6;
        return;
    L6:
        if (mOverrideClazzsFiles.indexOf(crashInfo.throwFileName) < 0) goto L17;
        mOverrideClazzCrashProcs.add(r.processName);     // Catch: Exception -> L9
        this.mActivityManagerService.getPackageManager().getISmtEx().clearOverrideFlag(r.processName);     // Catch: Exception -> L9
        return;
    L17:
        return;
    }

    public static void writeConfigFile() {
        FileOutputStream fstr = new FileOutputStream("/data/system/overrideSdk.xml");     // Catch: Exception -> L9
        BufferedOutputStream str = new BufferedOutputStream(fstr);     // Catch: Exception -> L9
        FastXmlSerializer r4 = new FastXmlSerializer();     // Catch: Exception -> L9
        r4.setOutput(str, StandardCharsets.UTF_8.name());     // Catch: Exception -> L9
        r4.startDocument(null, true);     // Catch: Exception -> L9
        r4.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Exception -> L9
        r4.startTag(null, "packages");     // Catch: Exception -> L9
        Iterator<String> r5 = mOverrideClazzCrashProcs.iterator();     // Catch: Exception -> L9
    L5:
        if (r5.hasNext() == false) goto L7;
        String proc = r5.next();     // Catch: Exception -> L9
        r4.startTag(null, com.android.server.pm.Settings.ATTR_PACKAGE);     // Catch: Exception -> L9
        r4.attribute(null, "closeOverrideProc", proc);     // Catch: Exception -> L9
        r4.endTag(null, com.android.server.pm.Settings.ATTR_PACKAGE);     // Catch: Exception -> L9
        goto L5
    L7:
        r4.endTag(null, "packages");     // Catch: Exception -> L9
        r4.endDocument();     // Catch: Exception -> L9
        str.flush();     // Catch: Exception -> L9
        FileUtils.sync(fstr);     // Catch: Exception -> L9
        str.close();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        if (mOverrideClazzCrashProcs.size() <= 0) goto L13;
        SystemProperties.set("persist.sys.classoverrider.close", "1");
    L13:
        Slog.e("ActivityManagerService", "writeConfigFile failed", e);
    }

    public void updateAppInfo(ApplicationInfo appInfo) {
        if (appInfo == null) goto L5;
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().updateAppInfo(appInfo.packageName);
        return;
    }

    public Pair<Integer, String> getUidAndNameByPid(int targetPid) {
        int tUid = -1;
        String name = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + targetPid + "/status")));     // Catch: Exception -> L25
    L39:
        String line = reader.readLine();     // Catch: Throwable -> L12
        if (line == null) goto L23;
        if (line.startsWith("Name") == true) goto L9;
        if (line.startsWith("Uid") == false) goto L39;
        String[] fields = line.trim().split("\t");     // Catch: Throwable -> L12
        if (fields.length < 2) goto L39;
        tUid = Integer.parseInt(fields[1]);     // Catch: Throwable -> L12
        goto L39
    L9:
        String[] fields2 = line.trim().split("\t");     // Catch: Throwable -> L12
        if (fields2.length < 2) goto L39;
        name = fields2[1];     // Catch: Throwable -> L12
        goto L39
    L23:
        reader.close();     // Catch: Exception -> L25
    L33:
        if (name == null) goto L51;
        Pair<Integer, String> ret = new Pair(Integer.valueOf(tUid), name);
        return ret;
    L51:
        return null;
    L12:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Exception -> L25
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Slog.w("ActivityManagerService", "getNativeNameByPid", e);
        goto L33
    }

    public void addPrefetchPkgAndDisplay(String packageName, int displayId) {
        this.mActivityManagerService.mWindowManager.getSmtEx().addPrefetchPkgAndDisplay(packageName, displayId);
    }

    public boolean moveAllTaskToDisplay(String packageName, boolean flag) {
        return this.mActivityManagerService.mWindowManager.getSmtEx().moveAllTaskToDisplay(packageName, flag);
    }

    public void notifyAppStartPreload(String packageName, int uid, String activity) {
        ActivityManagerService r1 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        ProcessRecord app = this.mActivityManagerService.getProcessRecordLocked(packageName, uid);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (app != null) goto L10;
        Slog.i("ActivityManagerService", "notifyAppStartPreload. app=null for pkg=" + packageName + " uid=" + uid);
        return;
    L10:
        return;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    protected void systemReadyForIconManager() {
    }

    public boolean goodToOperateProc(String pkg) {
        if (this.mApp3rdPerceptibleStateOwner != null) goto L7;
        return true;
    L7:
        return this.mApp3rdPerceptibleStateOwner.goodToOperateProc(pkg);
    }

    public FindSvpThreadHandle getFindSvpThreadHandle() {
        return this.findSvpThread;
    }

    public void setUserIsMonkeyLocked(boolean userIsMonkey) {
        Object r0 = this.mUserIsMonkeyLock;
        monitor-enter(r0);
        this.mUserIsMonkeySmt = userIsMonkey;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isUserIsMonkey() {
        Object r0 = this.mUserIsMonkeyLock;
        monitor-enter(r0);
        boolean r1 = this.mUserIsMonkeySmt;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isUserAMonkey() {
        if (isUserIsMonkey() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mActivityManagerService.mActivityTaskManager.getSmtEx().isControllerAMonkeySmt() == true) goto L8;
        return false;
    }

    public void handleUpload(Context context, String packageName, String errorType) {
        SysMonitorSvcBridge.getFactory().getUploadUtils().handleUpload(context, packageName, errorType);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void readCustomFileConfig() {
        SysMonitorSvcBridge.getFactory().getUploadUtils().readCustomFileConfig();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
