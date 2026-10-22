package com.stepos.alphame.movingstate;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.predict.PredictManager;
import com.stepos.alphame.systemstate.SystemStateMachine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import com.stepos.common.alphame.f;

/* loaded from: classes.dex */
public class MovingStateEngine extends EngineBase {
    private static final int DURATION = 60000;
    private static final String KEY_MOVING_ENGINE_ENABLE = "KEY_MOVING_ENGINE_ENABLE";
    private static final long LAUNCHER_IDLE_SENSOR_PAUSE_MS = 180000;
    private static final String MOVING_ACTION = "GET_STEP_COUNT";
    private static final int NO_STEP_EVENT_PERIOD = 700;
    private static final int NO_STEP_EVENT_REPEAT_COUNT = 13;
    private static final int NO_STEP_EVENT_START_DELAY = 3000;
    private static final String TAG = "MovingState";

    @SuppressLint({"StaticFieldLeak"})
    private static MovingStateEngine sInstance;
    private b mAppEventReceiver;
    private Context mContext;
    private Runnable mLauncherIdlePauseRunnable;
    private MovingEngineReceiver mMovingEngineReceiver;
    private CountDownTimer mNoStepEventTimer;
    private PowerManager mPowerManager;
    private b mScreenEventReceiver;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private b mSystemStateReceiver;
    private MovingStateTracker mStepStateTracker = new MovingStateTracker();
    private MovingState mMovingState = MovingState.staticStatic();
    private int mCurrStepCount = 0;
    private final Handler mHandler = new Handler(ApplicationImpl.getAlphaMeLooper());
    private String mForegroundPkg = null;
    private boolean mLauncherIdleSensorPaused = false;
    private boolean mSensorRegistered = false;
    private final SensorEventListener mStepCounterSensorListener = new SensorEventListener() { // from class: com.stepos.alphame.movingstate.MovingStateEngine.6
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i4) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            MovingStateEngine.this.mCurrStepCount = (int) sensorEvent.values[0];
            MovingStateEngine.this.mStepStateTracker.addEvent(MovingStateEngine.this.mCurrStepCount);
            MovingStateEngine.this.postNoStepEvent();
            MovingStateEngine.this.computeStepState(true);
        }
    };

    public class MovingEngineReceiver extends BroadcastReceiver {
        public /* synthetic */ MovingEngineReceiver(MovingStateEngine movingStateEngine, int i4) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            AlphaMeLogger.debugLog("action " + action);
            if (PersonalPreferenceConfigs.ACTION_AUTO_LEARNING_STATUS_CHANGED.equals(action)) {
                boolean booleanExtra = intent.getBooleanExtra(PersonalPreferenceConfigs.KEY_AUTO_LEARNING_STATUS, true);
                AlphaMeLogger.debugLog("auto learning status " + booleanExtra);
                MovingStateEngine.this.setMovingEngineEnable(booleanExtra);
            }
        }

        private MovingEngineReceiver() {
        }
    }

    public static class getStepStateFun extends EngineFunc {
        public getStepStateFun(EngineBase engineBase) {
            super(engineBase);
            this.name = "getStepState";
            this.argsType = new byte[]{0};
            this.returnType = (byte) 10;
            this.annotation = new String[]{"获取当前系统运动状态", "@author huangzuoyong", "@return 类型为int[] 其中", "        [0] 走路状态  0-未知状态 1-手机处于静止, 2-手机处于慢走, 3-手机处于走路, 4-手机处于跑步", "        [1] 速度．单位：步／分钟", "        [2] 采样时间长度, 单位：毫秒", "        [3] 准确度, 0-不太准确, 1-基本准确, 2-很准"};
        }
    }

    public MovingStateEngine(Context context) {
        this.mContext = context;
        EngineBase.addFunc(new getStepStateFun(this));
    }

    private boolean canUseStepSensor() {
        if (!PersonalPreferenceConfigs.INSTANCE.getAutoLearningState()) {
            return false;
        }
        if (this.mPowerManager == null) {
            this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        }
        PowerManager powerManager = this.mPowerManager;
        return (powerManager == null || powerManager.isInteractive()) && SystemStateMachine.getInstance().getTrackedSystemState() < 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelLauncherIdlePause() {
        Runnable runnable = this.mLauncherIdlePauseRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mLauncherIdlePauseRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void computeStepState(boolean z4) {
        SystemClock.elapsedRealtime();
        MovingState movingStateCompute = this.mStepStateTracker.compute(z4);
        SystemClock.elapsedRealtime();
        int i4 = movingStateCompute.state;
        if (i4 == 0 || i4 == this.mMovingState.state) {
            return;
        }
        Log.d(TAG, "state changed to " + movingStateCompute.state);
        this.mMovingState = movingStateCompute;
        ActionManager.getInstance().broadcast("ACTION_STEP_STATE_CHANGED", Integer.valueOf(this.mMovingState.state));
        onStepStateChanged(movingStateCompute.state);
    }

    public static MovingStateEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MovingStateEngine(context);
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHomeForeground() {
        return this.mForegroundPkg != null && PredictManager.getInstance(this.mContext).isHome(this.mForegroundPkg);
    }

    private void onStepStateChanged(int i4) {
        if (i4 != 1) {
            cancelLauncherIdlePause();
            this.mLauncherIdleSensorPaused = false;
            startSensorListenerIfNeeded();
        } else if (isHomeForeground()) {
            scheduleLauncherIdlePause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postNoStepEvent() {
        CountDownTimer countDownTimer = this.mNoStepEventTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(12100L, 700L) { // from class: com.stepos.alphame.movingstate.MovingStateEngine.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                if (j4 <= 9100) {
                    MovingStateEngine.this.mStepStateTracker.addStaticEvent();
                    MovingStateEngine.this.computeStepState(true);
                }
            }
        };
        this.mNoStepEventTimer = countDownTimer2;
        countDownTimer2.start();
    }

    private void registerPowerStateReceivers() {
        b bVar = new b("APP_EVENT") { // from class: com.stepos.alphame.movingstate.MovingStateEngine.3
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str, Object obj) {
                if (obj == null) {
                    return;
                }
                String[] strArr = (String[]) obj;
                String str2 = strArr[0];
                if ("resume".equals(strArr[1])) {
                    MovingStateEngine.this.mForegroundPkg = str2;
                    if (PredictManager.getInstance(MovingStateEngine.this.mContext).isHome(str2)) {
                        MovingStateEngine.this.scheduleLauncherIdlePause();
                        return;
                    }
                    MovingStateEngine.this.cancelLauncherIdlePause();
                    MovingStateEngine.this.mLauncherIdleSensorPaused = false;
                    MovingStateEngine.this.startSensorListenerIfNeeded();
                }
            }
        };
        this.mAppEventReceiver = bVar;
        f fVar = c.f11224a;
        fVar.f(bVar);
        this.mScreenEventReceiver = new b("SCREEN_EVENT") { // from class: com.stepos.alphame.movingstate.MovingStateEngine.4
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str, Object obj) {
                if (obj == null) {
                    return;
                }
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue == 0) {
                    MovingStateEngine.this.cancelLauncherIdlePause();
                    MovingStateEngine.this.mLauncherIdleSensorPaused = false;
                    MovingStateEngine.this.unRegisterSensorListener();
                } else if (iIntValue == 1) {
                    MovingStateEngine.this.mLauncherIdleSensorPaused = false;
                    MovingStateEngine.this.startSensorListenerIfNeeded();
                }
            }
        };
        this.mSystemStateReceiver = new b("SYSTEM_STATE_CHANGED") { // from class: com.stepos.alphame.movingstate.MovingStateEngine.5
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str, Object obj) {
                if (obj == null) {
                    return;
                }
                if (((Integer) obj).intValue() >= 4) {
                    MovingStateEngine.this.unRegisterSensorListener();
                } else {
                    MovingStateEngine.this.startSensorListenerIfNeeded();
                }
            }
        };
        fVar.f(this.mScreenEventReceiver);
        fVar.f(this.mSystemStateReceiver);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PersonalPreferenceConfigs.ACTION_AUTO_LEARNING_STATUS_CHANGED);
        if (this.mMovingEngineReceiver != null) {
            ApplicationImpl.getApplication().registerReceiver(this.mMovingEngineReceiver, intentFilter, 2);
        }
        AlphaMeLogger.debugLog(TAG, "register MovingEngineReceiver finish");
    }

    private void removeNoStepEvent() {
        CountDownTimer countDownTimer = this.mNoStepEventTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleLauncherIdlePause() {
        cancelLauncherIdlePause();
        if (isHomeForeground() && this.mMovingState.state == 1) {
            Runnable runnable = new Runnable() { // from class: com.stepos.alphame.movingstate.MovingStateEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MovingStateEngine.this.isHomeForeground() && MovingStateEngine.this.mMovingState.state == 1 && MovingStateEngine.this.mSensorRegistered) {
                        AlphaMeLogger.debugLog(MovingStateEngine.TAG, "launcher idle pause step sensor");
                        MovingStateEngine.this.mLauncherIdleSensorPaused = true;
                        MovingStateEngine.this.unRegisterSensorListener();
                    }
                }
            };
            this.mLauncherIdlePauseRunnable = runnable;
            this.mHandler.postDelayed(runnable, LAUNCHER_IDLE_SENSOR_PAUSE_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSensorListenerIfNeeded() {
        if (this.mLauncherIdleSensorPaused || this.mSensorRegistered || !canUseStepSensor()) {
            return;
        }
        AlphaMeLogger.debugLog(TAG, "registerSensorListener");
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(19);
        this.mStepCounterSensor = defaultSensor;
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this.mStepCounterSensorListener, defaultSensor, 3);
            AlphaMeLogger.debugLog(TAG, "register Listener for step counter");
            this.mSensorRegistered = true;
        }
        postNoStepEvent();
        if (isHomeForeground() && this.mMovingState.state == 1) {
            scheduleLauncherIdlePause();
        }
    }

    private void unRegisterReceiver() {
        try {
            if (this.mMovingEngineReceiver != null) {
                ApplicationImpl.getApplication().unregisterReceiver(this.mMovingEngineReceiver);
            }
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("movingEngine", e4);
        }
        AlphaMeLogger.debugLog(TAG, "unRegister MovingEngineReceiver finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterSensorListener() {
        SensorManager sensorManager;
        if (this.mSensorRegistered) {
            AlphaMeLogger.debugLog(TAG, "unRegisterSensorListener");
            Sensor sensor = this.mStepCounterSensor;
            if (sensor != null && (sensorManager = this.mSensorManager) != null) {
                sensorManager.unregisterListener(this.mStepCounterSensorListener, sensor);
                AlphaMeLogger.debugLog(TAG, "un register Listener for step counter");
            }
            this.mSensorRegistered = false;
            removeNoStepEvent();
        }
    }

    private void unregisterPowerStateReceivers() {
        cancelLauncherIdlePause();
        b bVar = this.mAppEventReceiver;
        if (bVar != null) {
            c.f11224a.g(bVar);
            this.mAppEventReceiver = null;
        }
        b bVar2 = this.mScreenEventReceiver;
        if (bVar2 != null) {
            c.f11224a.g(bVar2);
            this.mScreenEventReceiver = null;
        }
        b bVar3 = this.mSystemStateReceiver;
        if (bVar3 != null) {
            c.f11224a.g(bVar3);
            this.mSystemStateReceiver = null;
        }
    }

    public int getCurrStepCount() {
        return this.mCurrStepCount;
    }

    @NotProguard
    public int[] getStepState() {
        return this.mMovingState.toIntArray();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        this.mMovingEngineReceiver = new MovingEngineReceiver(this, 0);
        registerReceiver();
        registerPowerStateReceivers();
        startSensorListenerIfNeeded();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        AlphaMeLogger.debugLog(TAG, "movingEngine stop");
        unregisterPowerStateReceivers();
        unRegisterSensorListener();
        unRegisterReceiver();
    }

    @NotProguard
    public void setMovingEngineEnable(boolean z4) {
        AlphaMeLogger.dLog("set movingEngine enable " + z4);
        if (z4) {
            startSensorListenerIfNeeded();
        } else {
            unRegisterSensorListener();
        }
    }
}
