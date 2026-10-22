package com.stepos.alphame.app;

import B0.g;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.usage.SteposAppStatusListener;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.alibaba.fastjson.asm.Opcodes;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.app.state.DownloadState;
import com.stepos.alphame.app.state.LocationState;
import com.stepos.alphame.app.state.MultiMediaState;
import com.stepos.alphame.app.state.RecordState;
import com.stepos.alphame.app.state.ScreenRecordState;
import com.stepos.alphame.app.state.StateBase;
import com.stepos.alphame.app.state.StepState;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.reflect.UsageStatsManagerStepos;
import com.stepos.alphame.systemstate.SystemStateMachine;
import com.stepos.alphame.utils.AppUtils;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.Args;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class AppStateEngine extends EngineBase {
    private static final int CHECK_DURATION_MIDDLE = 60000;
    private static final int CHECK_DURATION_QUICK = 5000;
    private static final int CHECK_DURATION_SLOW = 120000;
    private static final int CHECK_DURATION_STOP = -1;
    public static final int DATA_EFFECTIVE_TIME = 120000;
    private static final boolean DEBUG = false;
    private static final int MAX_CHECK_COUNT = 20;
    private static final int MINI_CHECK_COUNT = 5;
    private static final int MSG_SCREEN_OFF = 2;
    public static final int QUICK_CHECK_TIME = 25000;
    private static final int SYSTEM_NON_WORKING = 2;
    private static final int SYSTEM_WORKING = 1;
    private static final int S_DEFAULT_DURATION = 0;
    public static final String S_KEY_STATE_DOWNLOAD = "download";
    public static final String S_KEY_STATE_MOVE = "move";
    public static final String S_KEY_STATE_NAVIGATION = "navigation";
    public static final String S_KEY_STATE_PHONE = "phone";
    public static final String S_KEY_STATE_PLAYBACK = "playback";
    public static final String S_KEY_STATE_RECORD = "record";
    public static final String S_KEY_STATE_SCREEN_RECORD = "screen_record";
    private static final String TAG = "AppStateEngine";
    private static boolean mThreadStoped = false;

    @SuppressLint({"StaticFieldLeak"})
    private static AppStateEngine sInstance;
    private PackageManager mPackageManager;
    private PowerManager mPowerManager;
    private Map<String, StateBase> mSystemState;
    private Object mLock = null;
    private boolean mRuning = false;
    private ActivityManager mActivityManager = null;
    private ArrayList<String> mRunningPacageName = new ArrayList<>();
    private final HashSet<String> mLastWorkingSet = new HashSet<>();
    private final HashSet<String> mCurrentWorkingSet = new HashSet<>();
    private final Set<String> mWorkingDetailSet = new HashSet();
    private boolean isPowerStateThreadRunning = false;
    private long mStartCheckTime = 0;
    private long mCheckEndTime = 0;
    private int APP_EVENT_BACKGROUND = 2;
    private SteposAppStatusListener mSteposAppStatusListener = new SteposAppStatusListener() { // from class: com.stepos.alphame.app.AppStateEngine.1
        @Override // android.app.usage.SteposAppStatusListener
        public void onAppStatusChange(String str, int i4) {
            if (Utils.DEBUG.get()) {
                Log.d(AppStateEngine.TAG, "mAppSwitchReceiver eventType:" + i4 + AwarenessDataItem.PERMISSION_SPLITTER + str);
            }
            if (i4 == AppStateEngine.this.APP_EVENT_BACKGROUND) {
                AppStateEngine.this.startWorkingCheck(60);
            }
        }
    };
    private SystemStateMachine.IStateChangeListener mStateReceiver = new SystemStateMachine.IStateChangeListener() { // from class: com.stepos.alphame.app.AppStateEngine.2
        @Override // com.stepos.alphame.systemstate.SystemStateMachine.IStateChangeListener
        public void onStateChange(int i4) {
            if (Utils.DEBUG.get()) {
                g.z("SystemStateEngine onStateChange: ", i4, AppStateEngine.TAG);
            }
            if (i4 == 2) {
                AppStateEngine.this.startWorkingCheck(Opcodes.GETFIELD);
            }
        }
    };
    private Context mContext = ApplicationImpl.getApplication();

    public class PowerStateThread extends Thread {
        public PowerStateThread() {
            setName("PowerStateThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            int sleepDuration = AppStateEngine.this.getSleepDuration();
            while (true) {
                try {
                } catch (Exception e4) {
                    AbstractC0351g.B("Error with runing check: ", e4, AppStateEngine.TAG);
                }
                if (AppStateEngine.mThreadStoped) {
                    Log.d(AppStateEngine.TAG, "State engine unregistered, gracefully stop the check thread");
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (Utils.DEBUG.get()) {
                    Log.d(AppStateEngine.TAG, "Thread running:" + AppStateEngine.this.mRuning + "-" + sleepDuration + " currentTime = " + jElapsedRealtime + " mCheckEndTime = " + AppStateEngine.this.mCheckEndTime);
                }
                if (jElapsedRealtime <= AppStateEngine.this.mCheckEndTime || AppStateEngine.this.isSystemWorking()) {
                    AppStateEngine.this.isPowerStateThreadRunning = true;
                    AppStateEngine.this.manualWait(1, sleepDuration);
                } else {
                    AppStateEngine.this.isPowerStateThreadRunning = false;
                    AppStateEngine.this.runStates(false, null);
                    AppStateEngine.this.manualWait(2, sleepDuration);
                }
                AppStateEngine.this.checkAppState();
            }
        }
    }

    public class getWorkingDetail extends EngineFunc {
        public getWorkingDetail(EngineBase engineBase) {
            super(engineBase);
            this.name = "getWorkingAppDetail";
            this.isPublic = true;
            this.argsType = new byte[]{0};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"根据类型获取名单列表详情", "@author zhouyueguo", "@return 对应类型的名单列表的详情，返回的String数组， 由string#int 构成， string代表包名，int代表类型"};
        }
    }

    public class getWrokingApp extends EngineFunc {
        public getWrokingApp(EngineBase engineBase) {
            super(engineBase);
            this.name = "getWorkingAppList";
            this.isPublic = true;
            this.argsType = new byte[]{0};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"根据类型获取名单列表", "@author zhouyueguo", "@return 对应类型的名单列表"};
        }
    }

    public class isAppWorking extends EngineFunc {
        public isAppWorking(EngineBase engineBase) {
            super(engineBase);
            this.name = "isWorkingAppExit";
            this.isPublic = true;
            this.argsType = new byte[]{0};
            this.returnType = (byte) 4;
            this.annotation = new String[]{"获取当前是否有应用处在工作状态", "@author zhouyueguo", "@return 是否处于工作状态 ", "        0-无工作状态", "        1-工作状态"};
        }
    }

    public class isSystemMoving extends EngineFunc {
        public isSystemMoving(EngineBase engineBase) {
            super(engineBase);
            this.name = "isSystemMoving";
            this.isPublic = true;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"duration"};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"判断某个应用是否处于工作状态", "@author zhouyueguo", "@param duration 从duration到现在这段时间内", "@return 是否处于工作状态 ", "        true-正在移动 ", "        false-静止"};
        }
    }

    private AppStateEngine() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAppState() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mStartCheckTime = jElapsedRealtime;
        ArrayList<String> runningComponent = AppUtils.getRunningComponent(this.mActivityManager);
        this.mRunningPacageName = runningComponent;
        if (!this.mRuning) {
            runStates(true, runningComponent);
        }
        notifyStates(this.mRunningPacageName);
        synchronized (this.mLastWorkingSet) {
            try {
                if (isWorkingSetChanged()) {
                    this.mLastWorkingSet.clear();
                    this.mLastWorkingSet.addAll(this.mCurrentWorkingSet);
                    ActionManager.getInstance().broadcast("APP_LIST_CHANGED", new Args(0, getWorkingAppListInner()));
                    Log.d(TAG, "Working set is changed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        if (Utils.DEBUG.get()) {
            Log.d(TAG, "checkAppState: cost time = " + (jElapsedRealtime2 - jElapsedRealtime) + " mStartCheckTime = " + this.mStartCheckTime);
        }
    }

    private void exit() {
        mThreadStoped = true;
        runStates(false, new ArrayList());
        this.mSystemState.clear();
    }

    public static synchronized AppStateEngine getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new AppStateEngine();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSleepDuration() {
        return 5000;
    }

    private ArrayList<String> getWorkingAppListInner() {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (this.mLastWorkingSet) {
            arrayList.addAll(this.mLastWorkingSet);
        }
        return arrayList;
    }

    private void initVariable() {
        this.mLock = new Object();
        this.mSystemState = new HashMap();
        this.mStartCheckTime = SystemClock.elapsedRealtime();
        synchronized (this) {
            this.mSystemState.put(S_KEY_STATE_PLAYBACK, MultiMediaState.getInstance(this.mContext));
            this.mSystemState.put(S_KEY_STATE_DOWNLOAD, DownloadState.getInstance(this.mContext));
            this.mSystemState.put(S_KEY_STATE_NAVIGATION, LocationState.getInstance(this.mContext));
            this.mSystemState.put(S_KEY_STATE_RECORD, RecordState.getInstance(this.mContext));
            this.mSystemState.put(S_KEY_STATE_MOVE, StepState.getInstance(this.mContext));
            this.mSystemState.put(S_KEY_STATE_SCREEN_RECORD, ScreenRecordState.getInstance(this.mContext));
        }
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mPackageManager = this.mContext.getPackageManager();
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService(PerfBinderHelper.EVENT_KIND_ACTIVITY);
        UsageStatsManagerStepos.addAppStatusListener(this.mContext, this.mSteposAppStatusListener);
        SystemStateMachine.getInstance().registerStateLister(this.mStateReceiver);
        new PowerStateThread().start();
    }

    private boolean isNeedCheck() {
        return SystemClock.elapsedRealtime() - this.mStartCheckTime >= ((long) getSleepDuration());
    }

    private int isNoWorkStateAppLocked() {
        for (String str : this.mSystemState.keySet()) {
            if (S_KEY_STATE_DOWNLOAD.equals(str) || S_KEY_STATE_PLAYBACK.equals(str) || S_KEY_STATE_NAVIGATION.equals(str) || S_KEY_STATE_RECORD.equals(str) || S_KEY_STATE_SCREEN_RECORD.equals(str)) {
                if (this.mSystemState.get(str) != null && this.mSystemState.get(str).isWorking(0L) != 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSystemWorking() {
        return isNoWorkStateAppLocked() != 0;
    }

    private boolean isWorkingSetChanged() {
        this.mCurrentWorkingSet.clear();
        for (String str : this.mSystemState.keySet()) {
            if (S_KEY_STATE_DOWNLOAD.equals(str) || S_KEY_STATE_PLAYBACK.equals(str) || S_KEY_STATE_NAVIGATION.equals(str) || S_KEY_STATE_RECORD.equals(str) || S_KEY_STATE_SCREEN_RECORD.equals(str)) {
                if (this.mSystemState.get(str).isWorking(0L) != 0) {
                    this.mCurrentWorkingSet.addAll(this.mSystemState.get(str).getWorkList());
                }
            }
        }
        return (this.mCurrentWorkingSet.size() == this.mLastWorkingSet.size() && this.mLastWorkingSet.containsAll(this.mCurrentWorkingSet)) ? false : true;
    }

    private void manualRun() {
        synchronized (this.mLock) {
            this.mLock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manualWait(int i4, int i5) {
        synchronized (this.mLock) {
            if (Utils.DEBUG.get()) {
                Log.d(TAG, "Called manualWait with duration:" + i5 + " type = " + i4);
            }
            try {
            } catch (Exception e4) {
                Log.e(TAG, "manualWait exception: " + e4);
            }
            if (i4 == 2) {
                this.mLock.wait();
            } else if (i4 == 1) {
                this.mLock.wait(getSleepDuration());
            }
        }
    }

    private void notifyStates(List<String> list) {
        for (String str : this.mSystemState.keySet()) {
            if (this.mSystemState.get(str) != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                this.mSystemState.get(str).startCheck(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runStates(boolean z4, List<String> list) {
        for (String str : this.mSystemState.keySet()) {
            if (this.mSystemState.get(str) != null) {
                if (z4) {
                    this.mSystemState.get(str).run();
                } else {
                    this.mSystemState.get(str).pause();
                }
            }
        }
        this.mRuning = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWorkingCheck(int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = (i4 * 1000) + jElapsedRealtime;
        if (this.mCheckEndTime < j4) {
            this.mCheckEndTime = j4;
        }
        if (Utils.DEBUG.get()) {
            StringBuilder sbT = g.t("startWorkingCheck: time = ", i4, " mCheckEndTime = ");
            sbT.append(this.mCheckEndTime);
            sbT.append(" currentTime = ");
            sbT.append(jElapsedRealtime);
            Log.d(TAG, sbT.toString());
        }
        if (this.isPowerStateThreadRunning || !isNeedCheck()) {
            return;
        }
        checkAppState();
        manualRun();
    }

    @NotProguard
    public List<String> getWorkingAppDetail() {
        if (!this.isPowerStateThreadRunning && isNeedCheck()) {
            checkAppState();
            manualRun();
        }
        this.mWorkingDetailSet.clear();
        ArrayList arrayList = new ArrayList();
        for (String str : this.mSystemState.keySet()) {
            if (S_KEY_STATE_DOWNLOAD.equals(str) || S_KEY_STATE_PLAYBACK.equals(str) || S_KEY_STATE_NAVIGATION.equals(str) || S_KEY_STATE_RECORD.equals(str) || S_KEY_STATE_SCREEN_RECORD.equals(str)) {
                if (this.mSystemState.get(str).isWorking(0L) != 0) {
                    this.mWorkingDetailSet.addAll(this.mSystemState.get(str).getWorkDetail());
                }
            }
        }
        synchronized (this.mWorkingDetailSet) {
            arrayList.addAll(this.mWorkingDetailSet);
        }
        return arrayList;
    }

    @NotProguard
    public ArrayList<String> getWorkingAppList() {
        if (!this.isPowerStateThreadRunning && isNeedCheck()) {
            checkAppState();
            manualRun();
        }
        return getWorkingAppListInner();
    }

    @NotProguard
    public boolean isSystemMoving(int i4) {
        if (!this.isPowerStateThreadRunning && isNeedCheck()) {
            checkAppState();
            manualRun();
        }
        return this.mSystemState.get(S_KEY_STATE_MOVE).isWorking(0L) == 16;
    }

    @NotProguard
    public int isWorkingAppExit() {
        if (!this.isPowerStateThreadRunning && isNeedCheck()) {
            checkAppState();
            manualRun();
        }
        return isNoWorkStateAppLocked();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        initVariable();
        EngineBase.addFunc(new isAppWorking(this));
        EngineBase.addFunc(new getWrokingApp(this));
        EngineBase.addFunc(new getWorkingDetail(this));
        EngineBase.addFunc(new isSystemMoving(this));
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        exit();
    }

    public void startRun() {
        manualRun();
    }
}
