package com.stepos.alphame.sleep;

import B0.g;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.app.state.StepState;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.manager.BroadcastManager;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Property;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import com.stepos.common.alphame.f;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public class SleepModeEngine extends EngineBase {
    private static final int COUNT_SLEEP_ON_INTERVAL = 10;
    private static final boolean DEBUG = false;
    private static final int DEEP_SLEEP_MINUTE = 60;
    public static final int DEEP_SLEEP_MODE = 2;
    public static final String DEEP_SLEEP_NAME = "deep_sleep";
    private static final int DEFAULT_SLEEP_START = 1380;
    private static final int DEFAULT_WAKE_START = 1740;
    public static final String INTENT_ACTION_SLEEP_ENTER = "com.stepos.alphame.engine.sleep.enter";
    public static final String INTENT_ACTION_SLEEP_OUT = "com.stepos.alphame.engine.sleep.out";
    private static final int INT_FLASE = 0;
    private static final int INT_NULL = -1;
    private static final int INT_TRUE = 1;
    private static final int MILLISENCONDS_SLEEP_ON_INTERVAL = 600000;
    private static final int MINUTES_DURATION = 1440;
    private static final int MINUTES_INVALID_SLEEP_END = 1260;
    private static final int MINUTES_INVALID_SLEEP_START = 720;
    private static final int MINUTES_WAKEUP_END = 2160;
    private static final int MINUTES_WAKEUP_START = 1800;
    private static final int MIN_ENTER_SLEEP = 30;
    private static final int MIN_SLEEP_CHECK = 120;
    private static final int MIN_SLEEP_DURATON = 180;
    private static final int MSG_CANCEL_SLEEP_SCREEN_ON = 2;
    private static final int MSG_HANDLE_SLEEP_SCREEN_ON = 1;
    public static final String NORMAL_NAME = "normal";
    public static final int SLEEP_MODE = 1;
    public static final String SLEEP_NAME = "sleep";
    private static final int STATE_WORKING = 1;
    private static final String TAG = "SleepModeEngine";
    public static final int WAKEUP_MODE = 0;
    private static SleepModeEngine mInstance;
    private int[] mDebugUserSleepInfo;
    private AlarmManager mAlarmManager = null;
    private PowerManager mPm = null;
    private PendingIntent mWakeupPendingIntent = null;
    private PendingIntent mSleepPendingIntent = null;
    private PendingIntent mDeepSleepPendingIntent = null;
    private SleepModeData mModeData = null;
    private SleepEvent mLongestSleep = new SleepEvent(this, 0);
    private SleepHandler mHandler = null;
    private long mLastScreenOn = SystemClock.elapsedRealtime();
    private long mLastScreenOff = SystemClock.elapsedRealtime();
    private int mSleepsStart = -1;
    private int mSleepsEnd = -1;
    private boolean isSleepMode = false;
    private boolean mAppWorking = false;
    private int mPlugged = -1;
    private boolean mIsPlugged = false;
    private int mSleepOnCount = 0;
    private boolean mIsScreenOn = true;
    private boolean mEnterDeepSleepModeWaiting = false;
    private b mScreenEventReceiver = new b("SCREEN_EVENT") { // from class: com.stepos.alphame.sleep.SleepModeEngine.1
        @Override // com.stepos.common.alphame.b
        public void onReceiver(String str, Object obj) {
            if (obj != null) {
                int iIntValue = ((Integer) obj).intValue();
                g.z("receive screen state: ", iIntValue, SleepModeEngine.TAG);
                if (iIntValue == 1) {
                    SleepModeEngine.this.handleScreenOn();
                } else {
                    SleepModeEngine.this.handleScreenOff();
                }
            }
        }
    };
    private b mAppStateReceiver = new b("APP_STATE_CHANGED") { // from class: com.stepos.alphame.sleep.SleepModeEngine.2
        @Override // com.stepos.common.alphame.b
        public void onReceiver(String str, Object obj) {
            if (obj != null) {
                if (((Integer) obj).intValue() == 1) {
                    SleepModeEngine.this.mAppWorking = true;
                } else {
                    SleepModeEngine.this.mAppWorking = false;
                }
                SleepModeEngine.this.handleStateChange();
            }
        }
    };
    BroadcastManager.OnSleepStateChangeListener listener = new BroadcastManager.OnSleepStateChangeListener() { // from class: com.stepos.alphame.sleep.SleepModeEngine.3
        @Override // com.stepos.alphame.manager.BroadcastManager.OnSleepStateChangeListener
        public void onStateChange(int i4, Intent intent) {
            if (i4 == 2) {
                SleepModeEngine.this.enterSleepMode();
                return;
            }
            if (i4 == 1) {
                SleepModeEngine.this.enterWakeupMode(false);
            } else if (i4 == 3) {
                if (SleepModeEngine.this.mIsScreenOn) {
                    SleepModeEngine.this.mEnterDeepSleepModeWaiting = true;
                } else {
                    SleepModeEngine.this.enterDeepSleepMode();
                }
            }
        }
    };
    private Context mContext = ApplicationImpl.getApplication();

    public class SleepEvent {
        int duration;
        int end;
        int start;

        public /* synthetic */ SleepEvent(SleepModeEngine sleepModeEngine, int i4) {
            this();
        }

        public String toString() {
            return " start:" + this.start + " end:" + this.end + " duration:" + this.duration;
        }

        public void update(int i4, int i5, int i6) {
            this.start = i4;
            this.end = i5;
            this.duration = i6;
        }

        private SleepEvent() {
            this.start = 0;
            this.end = 0;
            this.duration = 0;
        }
    }

    public static class SleepHandler extends Handler {
        private final WeakReference<SleepModeEngine> ref;

        public SleepHandler(SleepModeEngine sleepModeEngine) {
            this.ref = new WeakReference<>(sleepModeEngine);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SleepModeEngine sleepModeEngine = this.ref.get();
            if (sleepModeEngine == null) {
                return;
            }
            int i4 = message.what;
            if (i4 == 1) {
                sleepModeEngine.handleSleepScreenOn();
            } else {
                if (i4 != 2) {
                    return;
                }
                sleepModeEngine.cancelSleepScreenOn();
            }
        }
    }

    public class UserSleepInfo extends EngineFunc {
        public UserSleepInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = "getUserSleepInfo";
            this.argsType = new byte[]{0};
            this.returnType = (byte) 10;
            this.annotation = new String[]{"获取用户睡眠习惯", "@author lipan", "@return 用户睡觉时间点,int[]格式,长度为2,[开始睡觉时间,结束睡觉时间] 时间范围为:12 * 60 ~ (35 * 60 + 59)"};
        }
    }

    private PendingIntent cancelAlarm(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            return null;
        }
        Log.d(TAG, "cancel alarm: " + pendingIntent.toString());
        this.mAlarmManager.cancel(pendingIntent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelSleepScreenOn() {
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterDeepSleepMode() {
        Log.d(TAG, " start enter deep sleep mode");
        try {
            if (StepState.getInstance(this.mContext).isMoving(3600L)) {
                Log.d(TAG, " is moving can not enter deep sleep mode");
                return;
            }
            Log.d(TAG, " enter deep sleep mode");
            this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
            ActionManager.getInstance().broadcast("SLEEP_STATE_CHANGED", 2);
        } catch (Exception e4) {
            AbstractC0351g.B("set deep sleep mode exception: ", e4, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterSleepMode() {
        Log.d(TAG, "enter sleep mode");
        try {
            this.isSleepMode = true;
            setWakeAlarm(getSleepModeEnd() - 30);
            Property.setBoolean(Property.KEY_SLEEP_MODE, true);
            ActionManager.getInstance().broadcast("SLEEP_STATE_CHANGED", 1);
            sendStandardBroadcast(INTENT_ACTION_SLEEP_ENTER);
            setDeepSleepAlarm(60);
        } catch (Exception e4) {
            AbstractC0351g.B("set sleep mode exception: ", e4, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterWakeupMode(boolean z4) {
        Log.d(TAG, "enter wakeup mode");
        this.mEnterDeepSleepModeWaiting = false;
        try {
            Property.setBoolean(Property.KEY_SLEEP_MODE, false);
            ActionManager.getInstance().broadcast("SLEEP_STATE_CHANGED", 0);
            sendStandardBroadcast(INTENT_ACTION_SLEEP_OUT);
        } catch (Exception e4) {
            AbstractC0351g.B("set sleep mode exception: ", e4, TAG);
        }
        this.isSleepMode = false;
        restoreStatus();
    }

    private int getCurrentMinute() {
        Calendar calendar = Calendar.getInstance();
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        if (i4 < 12) {
            i4 += 24;
        }
        int i6 = (i4 * 60) + i5;
        g.z("current minutes: ", i6, TAG);
        return i6;
    }

    public static SleepModeEngine getInstance() {
        if (mInstance == null) {
            mInstance = new SleepModeEngine();
        }
        return mInstance;
    }

    private int getSleepModeEnd() {
        int i4 = Calendar.getInstance().get(7);
        List<Integer> sleepEndList = this.mModeData.getSleepEndList(i4);
        if (sleepEndList == null || sleepEndList.size() == 0) {
            Log.d(TAG, "no sleep end history data, using default: 1740");
            return DEFAULT_WAKE_START;
        }
        int size = 0;
        int iIntValue = sleepEndList.get(0).intValue();
        int iIntValue2 = sleepEndList.get(0).intValue();
        int iIntValue3 = 0;
        for (Integer num : sleepEndList) {
            if (num.intValue() > iIntValue) {
                iIntValue = num.intValue();
            }
            if (num.intValue() < iIntValue2) {
                iIntValue2 = num.intValue();
            }
            iIntValue3 += num.intValue();
        }
        if (sleepEndList.size() > 0 && sleepEndList.size() <= 3) {
            size = iIntValue3 / sleepEndList.size();
        } else if (sleepEndList.size() > 3) {
            size = ((iIntValue3 - iIntValue) - iIntValue2) / (sleepEndList.size() - 2);
        } else {
            Log.e(TAG, "get end history data error!");
        }
        StringBuilder sbU = g.u("day: ", i4, " end sum:", iIntValue3, " max:");
        sbU.append(iIntValue);
        sbU.append(" min:");
        sbU.append(iIntValue2);
        sbU.append(" average: ");
        sbU.append(size);
        Log.d(TAG, sbU.toString());
        this.mSleepsEnd = size;
        return size;
    }

    private int getSleepModeStart() {
        int i4 = Calendar.getInstance().get(7);
        List<Integer> sleepStartList = this.mModeData.getSleepStartList(i4);
        if (sleepStartList == null || sleepStartList.size() == 0) {
            Log.d(TAG, "no sleep start history data, using default: 1380");
            return DEFAULT_SLEEP_START;
        }
        int size = 0;
        int iIntValue = sleepStartList.get(0).intValue();
        int iIntValue2 = sleepStartList.get(0).intValue();
        int iIntValue3 = 0;
        for (Integer num : sleepStartList) {
            if (num.intValue() < iIntValue) {
                iIntValue = num.intValue();
            }
            if (num.intValue() > iIntValue2) {
                iIntValue2 = num.intValue();
            }
            iIntValue3 += num.intValue();
        }
        if (sleepStartList.size() > 0 && sleepStartList.size() <= 3) {
            size = iIntValue3 / sleepStartList.size();
        } else if (sleepStartList.size() > 3) {
            size = ((iIntValue3 - iIntValue2) - iIntValue) / (sleepStartList.size() - 2);
        } else {
            Log.e(TAG, "get start history data error!");
        }
        StringBuilder sbU = g.u("day: ", i4, " start sum:", iIntValue3, " max:");
        sbU.append(iIntValue2);
        sbU.append(" min:");
        sbU.append(iIntValue);
        sbU.append(" average: ");
        sbU.append(size);
        Log.d(TAG, sbU.toString());
        this.mSleepsStart = size;
        return size;
    }

    private void handleRestart() {
        AlphaMeLogger.debugLog("handle restart");
        if (!this.mPm.isInteractive() && !isSleepMode() && !this.mAppWorking) {
            int currentMinute = getCurrentMinute();
            this.mSleepPendingIntent = cancelAlarm(this.mSleepPendingIntent);
            this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
            this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
            int sleepModeStart = getSleepModeStart();
            int sleepModeEnd = getSleepModeEnd();
            if (!isSleepMode()) {
                prepareSleepMode(sleepModeStart, sleepModeEnd, currentMinute);
            }
        }
        if (!isSleepMode() || !this.mAppWorking) {
            AlphaMeLogger.debugLog("restart no state changed");
            return;
        }
        this.mSleepPendingIntent = cancelAlarm(this.mSleepPendingIntent);
        this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
        this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
        restoreStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScreenOff() {
        this.mIsScreenOn = false;
        if (this.mEnterDeepSleepModeWaiting) {
            enterDeepSleepMode();
        }
        if (hasMessage(1)) {
            sendMessage(2, -1, -1, 0, null);
        }
        if (isSleepMode()) {
            return;
        }
        int currentMinute = getCurrentMinute();
        this.mSleepPendingIntent = cancelAlarm(this.mSleepPendingIntent);
        this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
        this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
        prepareSleepMode(getSleepModeStart(), getSleepModeEnd(), currentMinute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScreenOn() {
        this.mIsScreenOn = true;
        int currentMinute = getCurrentMinute();
        if (isSleepMode()) {
            Log.d(TAG, "previous is sleep mode, judge sleep interval, interrupt count: " + this.mSleepOnCount);
            sendMessage(1, -1, -1, MILLISENCONDS_SLEEP_ON_INTERVAL, null);
            int i4 = this.mSleepOnCount + 1;
            this.mSleepOnCount = i4;
            if (i4 > 10 || currentMinute >= getSleepModeEnd() - 30) {
                this.mSleepOnCount = 0;
                cancelSleepScreenOn();
                enterWakeupMode(true);
                markScreenOnEvent(currentMinute);
                this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
            }
        } else {
            Log.d(TAG, "handle screen on, previous is not sleep mode, restore status");
            this.mSleepPendingIntent = cancelAlarm(this.mSleepPendingIntent);
            this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
            this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
            restoreStatus();
        }
        if (currentMinute < MINUTES_WAKEUP_START || currentMinute > MINUTES_WAKEUP_END || isSleepMode()) {
            return;
        }
        markScreenOnEvent(currentMinute);
        Log.d(TAG, "duration in morning time, setSleepEvent, duration" + this.mLongestSleep.toString());
        setSleepEvent(this.mLongestSleep);
        this.mLongestSleep.update(0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSleepScreenOn() {
        enterWakeupMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStateChange() {
        Log.d(TAG, "handle state change");
        if (!this.mPm.isInteractive() && !isSleepMode() && !this.mAppWorking) {
            int currentMinute = getCurrentMinute();
            this.mSleepPendingIntent = cancelAlarm(this.mSleepPendingIntent);
            this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
            this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
            prepareSleepMode(getSleepModeStart(), getSleepModeEnd(), currentMinute);
        }
        if (!isSleepMode() || !this.mAppWorking) {
            AlphaMeLogger.debugLog("no state changed");
            return;
        }
        this.mSleepPendingIntent = cancelAlarm(this.mSleepPendingIntent);
        this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
        this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
        restoreStatus();
    }

    private boolean hasMessage(int i4) {
        return this.mHandler.hasMessages(i4);
    }

    private void initFilter() {
        f fVar = c.f11224a;
        fVar.f(this.mScreenEventReceiver);
        fVar.f(this.mAppStateReceiver);
        this.mHandler = new SleepHandler(this);
    }

    private void initVariable() {
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService("alarm");
        this.mPm = (PowerManager) this.mContext.getSystemService("power");
        BroadcastManager.getInstance(this.mContext).addSleepStateChangeListener(this.listener);
        this.mModeData = SleepModeData.getInstance(this.mContext);
    }

    private boolean isSleepMode() {
        return this.isSleepMode;
    }

    private boolean isWorking() {
        Log.d(TAG, "is working: " + this.mAppWorking);
        return this.mAppWorking;
    }

    private void markScreenOffEvent(int i4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mLastScreenOff = jElapsedRealtime;
        Property.setLong(Property.KEY_SLEEP_START_TIME, jElapsedRealtime);
    }

    private void markScreenOnEvent(int i4) {
        this.mLastScreenOn = SystemClock.elapsedRealtime();
        long j4 = Property.getLong(Property.KEY_SLEEP_START_TIME, -1L);
        this.mLastScreenOff = j4;
        if (j4 <= 0) {
            Log.e(TAG, "screen off time didn't stored, ignore");
            return;
        }
        int iMs2Minute = ms2Minute(this.mLastScreenOn - j4);
        if (iMs2Minute <= 0 || (i4 > MINUTES_INVALID_SLEEP_START && i4 < MINUTES_INVALID_SLEEP_END)) {
            Log.d(TAG, "it's not appropriate time, reset duration and ignore");
            this.mLongestSleep.update(0, 0, 0);
            return;
        }
        if (iMs2Minute > 1620) {
            iMs2Minute %= MINUTES_DURATION;
            this.mLongestSleep.update(i4 - iMs2Minute, i4, iMs2Minute);
        }
        SleepEvent sleepEvent = this.mLongestSleep;
        if (iMs2Minute > sleepEvent.duration) {
            sleepEvent.update(i4 - iMs2Minute, i4, iMs2Minute);
            Log.d(TAG, "refresh new duration: " + this.mLongestSleep.toString());
        } else {
            Log.d(TAG, "old duration: " + this.mLongestSleep.toString());
        }
        Property.setLong(Property.KEY_SLEEP_START_TIME, -1L);
    }

    private int ms2Minute(long j4) {
        return ((int) j4) / CoreConstants.MILLIS_IN_ONE_MINUTE;
    }

    private void prepareSleepMode(int i4, int i5, int i6) {
        if (isWorking()) {
            Log.d(TAG, "is working, not prepareSleepMode");
            restoreStatus();
            return;
        }
        if (i5 - i6 <= 30) {
            Log.d(TAG, "out of sleep time, do nothing, end: " + i5 + " current: " + i6);
            restoreStatus();
            return;
        }
        if (i4 > i6 && i4 - i6 <= 120) {
            int i7 = i4 + 30;
            setSleepAlarm(i7);
            g.z("current time is earlier in 2 hours, set sleep alarm: ", i7, TAG);
        } else {
            if (i6 < i4 || i6 > i5) {
                StringBuilder sbU = g.u("current time is out of the sleep range, current: ", i6, " start: ", i4, " end: ");
                sbU.append(i5);
                Log.d(TAG, sbU.toString());
                restoreStatus();
                return;
            }
            setSleepAlarm(getCurrentMinute() + 30);
            Log.d(TAG, "current time is just in the sleep range, set sleep time: " + (getCurrentMinute() + 30));
        }
    }

    private void resetSleepTime() {
        Log.d(TAG, "set sleep time in cache");
        this.mSleepsStart = -1;
        this.mSleepsEnd = -1;
    }

    private void restoreStatus() {
        if (this.isSleepMode) {
            this.isSleepMode = false;
        }
        if (Property.getBoolean(Property.KEY_SLEEP_MODE)) {
            Property.setBoolean(Property.KEY_SLEEP_MODE, false);
            ActionManager.getInstance().broadcast("SLEEP_STATE_CHANGED", 0);
        }
    }

    private void sendMessage(int i4, int i5, int i6, int i7, Object obj) {
        if (hasMessage(i4)) {
            this.mHandler.removeMessages(i4);
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i4;
        if (i5 >= 0) {
            messageObtain.arg1 = i5;
        }
        if (i6 >= 0) {
            messageObtain.arg2 = i6;
        }
        if (obj != null) {
            messageObtain.obj = obj;
        }
        if (i7 >= 0) {
            this.mHandler.sendMessageDelayed(messageObtain, i7);
        } else {
            this.mHandler.sendMessage(messageObtain);
        }
    }

    private void sendStandardBroadcast(String str) {
        this.mContext.sendBroadcast(new Intent(str));
        Log.d(TAG, "sendStandardBroadcast:" + str);
    }

    private void setAlarm(PendingIntent pendingIntent, int i4, int i5, int i6) {
        if (pendingIntent == null) {
            Log.d(TAG, "setAlarm intent is null, return");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, i5);
        calendar.set(11, i6 / 60);
        calendar.set(12, i6 % 60);
        calendar.set(13, 0);
        calendar.set(14, 0);
        this.mAlarmManager.setExact(i4, calendar.getTimeInMillis(), pendingIntent);
        Log.d(TAG, "setAlarm type: " + i4 + " time: " + calendar.getTimeInMillis() + " intent: " + pendingIntent.toString());
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(34)
    private void setDeepSleepAlarm(int i4) {
        this.mDeepSleepPendingIntent = cancelAlarm(this.mDeepSleepPendingIntent);
        this.mDeepSleepPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(BroadcastManager.INTENT_ACTION_DEEP_SLEEP), 184549376);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Log.d(TAG, "setDeepSleepAlarm: minutes = " + i4 + " currentElapsedTime = " + jElapsedRealtime);
        this.mAlarmManager.setExact(3, jElapsedRealtime + ((long) (i4 * CoreConstants.MILLIS_IN_ONE_MINUTE)), this.mDeepSleepPendingIntent);
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(34)
    private void setSleepAlarm(int i4) {
        int i5;
        markScreenOffEvent(i4);
        cancelAlarm(this.mSleepPendingIntent);
        this.mSleepPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(BroadcastManager.INTENT_ACTION_SLEEP), 184549376);
        int i6 = i4 - 30;
        if (i6 <= 0) {
            g.z("It's out of sleep time : ", i4, TAG);
            return;
        }
        int currentMinute = getCurrentMinute();
        if (currentMinute >= MINUTES_DURATION || i6 < MINUTES_DURATION) {
            if (currentMinute < MINUTES_DURATION && i6 < MINUTES_DURATION) {
                g.z("current time can directly set alarm at today, time: ", i6, TAG);
                i6 = i4;
            } else if (currentMinute <= MINUTES_DURATION || i6 <= MINUTES_DURATION) {
                Log.d(TAG, "unknown time: " + i6 + " do nothing!");
            } else {
                Log.d(TAG, "current time can directly set alarm at tomorrow, time: " + i6);
                i6 = i4 + (-1440);
            }
            i5 = 0;
        } else {
            Log.d(TAG, "set sleep alarm at 2th day");
            i6 = i4 - 1440;
            i5 = 1;
        }
        setAlarm(this.mSleepPendingIntent, 0, i5, i6);
        g.z("set sleep alarm: ", i4, TAG);
    }

    private void setSleepEvent(SleepEvent sleepEvent) {
        if (sleepEvent.duration < 180) {
            Log.d(TAG, "duration " + sleepEvent.duration + " is small");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, 0);
        int i4 = calendar.get(7) - 1;
        this.mModeData.setSleepEvent(i4 == 0 ? 7 : i4, sleepEvent.start, sleepEvent.end, 0, 0);
        resetSleepTime();
        getSleepModeStart();
        getSleepModeEnd();
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(34)
    private void setWakeAlarm(int i4) {
        this.mWakeupPendingIntent = cancelAlarm(this.mWakeupPendingIntent);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 0, new Intent(BroadcastManager.INTENT_ACTION_WAKEUP), 184549376);
        this.mWakeupPendingIntent = broadcast;
        if (i4 <= 0) {
            Log.e(TAG, "invalid wakeup time: " + i4);
            restoreStatus();
            return;
        }
        if (i4 > MINUTES_DURATION) {
            i4 -= 1440;
            setAlarm(this.mWakeupPendingIntent, 0, (getCurrentMinute() < MINUTES_DURATION && getCurrentMinute() < MINUTES_DURATION) ? 1 : 0, i4);
        } else if (i4 < MINUTES_DURATION) {
            setAlarm(broadcast, 0, 0, i4);
        }
        g.z("set wake up time: ", i4, TAG);
    }

    @NotProguard
    public int[] getUserSleepInfo() {
        int[] iArr = this.mDebugUserSleepInfo;
        return iArr != null ? iArr : SleepModeData.getInstance(this.mContext).getSleepTime();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new UserSleepInfo(this));
        initVariable();
        initFilter();
        this.isSleepMode = Property.getBoolean(Property.KEY_SLEEP_MODE);
        handleRestart();
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        f fVar = c.f11224a;
        fVar.g(this.mScreenEventReceiver);
        fVar.g(this.mAppStateReceiver);
        BroadcastManager.getInstance(this.mContext).removeSleepStateChangeListener(this.listener);
    }

    public void setDebugUserSleepInfo(int[] iArr) {
        this.mDebugUserSleepInfo = iArr;
    }
}
