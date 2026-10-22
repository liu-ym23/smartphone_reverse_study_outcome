package com.stepos.alphame.awareness;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.RuleUpdater;
import com.stepos.alphame.common.utils.BaseApplication;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.movingstate.MovingStateEngine;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.StringUtil;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AwarenessDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {4, 4, 4, 6, 6, 5};
    private static final List<String> PAYMENT_ACTIVITIES;
    public static final String PREFIX_PAYMENT_ACTIVITIES = "payment_";
    protected static final String TAG = "Awareness";
    private static final String WME_TAG = "WME_AppEvent";
    private static AwarenessDataSource sInstance;
    private String mCurrApp;
    private boolean mEnableDump;
    private b mEventReceiver;
    private final Handler mHandler;
    private Pair<Integer, String> mLastWifi;
    private final BroadcastReceiver mPowerReceiver;
    private final TimetableTracker mTimetableTracker;

    static {
        ArrayList arrayList = new ArrayList();
        PAYMENT_ACTIVITIES = arrayList;
        arrayList.add("com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        arrayList.add("com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI");
        arrayList.add("com.alipay.mobile.scan.as.main.MainCaptureActivity");
    }

    private AwarenessDataSource(String str) {
        super(str);
        this.mCurrApp = null;
        this.mLastWifi = null;
        this.mEnableDump = false;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.awareness.AwarenessDataSource.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final String action = intent != null ? intent.getAction() : null;
                if (action == null) {
                    return;
                }
                AwarenessDataSource.this.mHandler.post(new Runnable() { // from class: com.stepos.alphame.awareness.AwarenessDataSource.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2 = action;
                        str2.getClass();
                        if (str2.equals("android.intent.action.BATTERY_LOW")) {
                            AwarenessDataSource.this.onLowBattery();
                        } else if (str2.equals("android.intent.action.ACTION_SHUTDOWN")) {
                            AwarenessDataSource.this.onShutdown();
                        }
                    }
                });
            }
        };
        this.mPowerReceiver = broadcastReceiver;
        this.mEventReceiver = new b() { // from class: com.stepos.alphame.awareness.AwarenessDataSource.2
            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str2, Object obj) throws NumberFormatException {
                str2.getClass();
                switch (str2) {
                    case "ACTION_STEP_STATE_CHANGED":
                        AwarenessDataSource.this.mTimetableTracker.track(AwarenessDataSource.this.newRecord(0, ((Integer) obj).intValue(), String.valueOf(MovingStateEngine.getInstance(ApplicationImpl.getApplication()).getCurrStepCount()), null, System.currentTimeMillis()), true);
                        break;
                    case "ACTION_WIFI_STATE_CHANGED":
                        AwarenessDataSource.this.handleWifiStateChanged(obj);
                        break;
                    case "ACTION_CHARGING_CHANGED":
                        int[] iArr = (int[]) obj;
                        AwarenessDataSource.this.mTimetableTracker.track(AwarenessDataSource.this.newRecord(6, iArr[0], String.valueOf(iArr[1]), String.valueOf(iArr[2]), System.currentTimeMillis()), true);
                        break;
                    case "ACTIVITY_DETECT":
                        AwarenessDataSource.this.onDetectAppEvent((String[]) obj);
                        break;
                    case "ACTION_BLUETOOTH_CHANGED":
                        String[] strArr = (String[]) obj;
                        AwarenessDataSource.this.mTimetableTracker.track(AwarenessDataSource.this.newRecord(4, Integer.valueOf(strArr[0]).intValue(), strArr[1], strArr[2], System.currentTimeMillis()), true);
                        break;
                    case "SCREEN_OFF_BY_PAUSE":
                        AwarenessDataSource.this.onScreenOff();
                        break;
                    case "ACTION_LOCATION_CHANGED":
                        String[] strArr2 = (String[]) obj;
                        AlphaMeLogger.debugLog("Awareness", "ACTION_LOCATION_CHANGED, " + strArr2);
                        AwarenessDataSource.this.mTimetableTracker.track(AwarenessDataSource.this.newRecord(2, Integer.parseInt(strArr2[0]), strArr2[1], strArr2[2], System.currentTimeMillis()), true);
                        break;
                    case "SCREEN_EVENT":
                        if (((Integer) obj).intValue() != 0) {
                            AwarenessDataSource.this.mTimetableTracker.track(AwarenessDataSource.this.newScreenOnRecord(System.currentTimeMillis()), true);
                            break;
                        } else {
                            AwarenessDataSource.this.onScreenOff();
                            break;
                        }
                    case "ACTION_HEADSET_CHANGED":
                        AwarenessDataSource.this.mTimetableTracker.track(AwarenessDataSource.this.newRecord(7, ((Integer) obj).intValue(), null, null, System.currentTimeMillis()), true);
                        break;
                }
            }
        };
        AlphaMeLogger.dLog("AwarenessDataSource new");
        this.mHandler = new Handler(ApplicationImpl.getAlphaMeLooper());
        this.mTimetableTracker = TimetableTracker.getInstance();
        QuickAppHelper.getInstance();
        b bVar = this.mEventReceiver;
        bVar.addAction("ACTION_STEP_STATE_CHANGED");
        bVar.addAction("SCREEN_EVENT");
        bVar.addAction(LocalConsts.ACTION_WIFI_STATE_CHANGED);
        bVar.addAction(LocalConsts.ACTION_LOCATION_CHANGED);
        bVar.addAction(LocalConsts.ACTION_BLUETOOTH_CHANGED);
        bVar.addAction(LocalConsts.ACTION_CHARGING_CHANGED);
        bVar.addAction(LocalConsts.ACTION_HEADSET_CHANGED);
        bVar.addAction(LocalConsts.ACTION_ACTIVITY_DETECT);
        bVar.addAction(LocalConsts.ACTION_SCREEN_OFF_BY_PAUSE);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.setPriority(1000);
        BaseApplication.appContext.registerReceiver(broadcastReceiver, intentFilter);
    }

    public static AwarenessDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new AwarenessDataSource("Awareness");
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWifiStateChanged(Object obj) throws NumberFormatException {
        if (obj == null) {
            return;
        }
        AwarenessDataItem awarenessDataItem = (AwarenessDataItem) itemCache().pop();
        String[] strArr = (String[]) obj;
        Integer numValueOf = Integer.valueOf(strArr[0]);
        int iIntValue = numValueOf.intValue();
        String str = strArr[1];
        String str2 = strArr[2];
        if (iIntValue != 2) {
            Pair<Integer, String> pair = this.mLastWifi;
            if (pair != null && ((Integer) pair.first).intValue() == iIntValue && isEqual((String) this.mLastWifi.second, str)) {
                AlphaMeLogger.debugLog("Awareness", "duplicate wifi changed");
                return;
            }
            this.mLastWifi = new Pair<>(numValueOf, str);
        }
        StringBuilder sbX = g.x("ACTION_WIFI_STATE_CHANGED, ssid = ", str, ", bssid = ", str2, ", state = ");
        sbX.append(iIntValue);
        AlphaMeLogger.debugLog("Awareness", sbX.toString());
        awarenessDataItem.fill(1, iIntValue, str, str2, System.currentTimeMillis());
        process(awarenessDataItem);
        this.mTimetableTracker.track(awarenessDataItem, true);
    }

    private boolean isEqual(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private AwarenessDataItem newAppRecord(String str, int i4, long j4) {
        String[] appInfo = SceneDetectorEngine.getInstance().getAppInfo(str);
        return newRecord(3, i4, str, appInfo[0] + AwarenessDataItem.PERMISSION_SPLITTER + appInfo[1], j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AwarenessDataItem newRecord(int i4, int i5, String str, String str2, long j4) {
        AwarenessDataItem awarenessDataItem = (AwarenessDataItem) itemCache().pop();
        awarenessDataItem.fill(i4, i5, str, str2, j4);
        process(awarenessDataItem);
        return awarenessDataItem;
    }

    private AwarenessDataItem newScreenOffRecord(long j4) {
        return newRecord(3, 0, "screen_off", String.valueOf(0), j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AwarenessDataItem newScreenOnRecord(long j4) {
        AlphaMeLogger.iLog("onScreenOn mCurrApp = " + this.mCurrApp + AwarenessDataItem.PERMISSION_SPLITTER + StringUtil.formatDateFull(j4));
        return newRecord(3, 0, SceneDetectorEngine.SCREEN_LOCKED, String.valueOf(1), j4);
    }

    private AwarenessDataItem newShutdownRecord(long j4) {
        return newScreenOffRecord(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDetectAppEvent(String[] strArr) {
        String strM = strArr[0];
        String str = strArr[1];
        String str2 = strArr[2];
        String str3 = strArr[3];
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sbX = g.x("onDetectAppEvent pkg=", strM, ", activity=", str, ", userId=");
        sbX.append(str2);
        sbX.append(", quickPkg=");
        sbX.append(str3);
        Log.i(WME_TAG, sbX.toString());
        StringBuilder sbX2 = g.x("onDetectAppEvent pkg=", strM, ", activity=", str, ", userId=");
        AbstractC0351g.C(sbX2, str2, ", quickPkg=", str3, ", now=");
        sbX2.append(jCurrentTimeMillis);
        AlphaMeLogger.dLog(sbX2.toString());
        if (PAYMENT_ACTIVITIES.contains(str)) {
            strM = g.m("payment_", str);
        } else if (!TextUtils.isEmpty(str3)) {
            strM = str3;
        }
        if (Objects.equals(strM, this.mCurrApp)) {
            return;
        }
        this.mCurrApp = strM;
        this.mTimetableTracker.track(newAppRecord(this.mCurrApp, parseUserIdSafety(str2), jCurrentTimeMillis), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLowBattery() {
        AlphaMeLogger.wLog("onLowBattery");
        long jUptimeMillis = SystemClock.uptimeMillis();
        store(true);
        AlphaMeLogger.wLog("onLowBattery complete. cost time=" + (SystemClock.uptimeMillis() - jUptimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenOff() {
        AlphaMeLogger.iLog("onScreenOff mCurrApp = " + this.mCurrApp);
        this.mTimetableTracker.track(newScreenOffRecord(System.currentTimeMillis()), true);
        this.mCurrApp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShutdown() {
        AlphaMeLogger.wLog("onShutdown receive shutdown");
        RuleUpdater.getInstance().setShuttingDown(true);
        long jUptimeMillis = SystemClock.uptimeMillis();
        AwarenessDataItem awarenessDataItemNewShutdownRecord = newShutdownRecord(System.currentTimeMillis());
        store(true);
        this.mTimetableTracker.track(awarenessDataItemNewShutdownRecord, true);
        RuleUpdater.getInstance().setShuttingDown(false);
        AlphaMeLogger.wLog("onShutdown complete. cost time=" + (SystemClock.uptimeMillis() - jUptimeMillis));
    }

    private int parseUserIdSafety(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("userId empty", e4);
            return 0;
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return new AwarenessStorable();
    }

    /* JADX WARN: Removed duplicated region for block: B:195:0x02eb  */
    @Override // com.stepos.alphame.data.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dump(java.io.FileDescriptor r19, java.io.PrintWriter r20, java.lang.String[] r21) {
        /*
            Method dump skipped, instructions count: 3466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.awareness.AwarenessDataSource.dump(java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    public void enableDump() {
        this.mEnableDump = true;
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return AwarenessDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    public void newBootRecord() {
        newRecord(5, 0, null, null, System.currentTimeMillis());
        if (((PowerManager) BaseApplication.appContext.getSystemService("power")).isScreenOn()) {
            this.mTimetableTracker.track(newScreenOnRecord(System.currentTimeMillis()), true);
        }
    }

    public void newDailyRecord(int i4, String str, String str2) {
        newRecord(5, 2, str, i4 + "," + str2, System.currentTimeMillis());
    }

    public void newNotiRecord(String str, String str2) {
        newRecord(8, 0, str, str2, System.currentTimeMillis());
    }

    public void newPermissionRecord(String str, int i4, String str2) {
        newRecord(9, i4, str, str2, System.currentTimeMillis());
    }

    public void newStepRecord(int i4) {
        newRecord(5, 3, String.valueOf(i4), null, System.currentTimeMillis());
    }

    public void newWifiRecord(String str, String str2) {
        newRecord(5, 4, str, str2, System.currentTimeMillis());
    }

    @Override // com.stepos.alphame.data.DataSource
    public void onStart() {
        super.onStart();
        c.f11224a.f(this.mEventReceiver);
    }

    @Override // com.stepos.alphame.data.DataSource
    public void onStop() {
        super.onStop();
        c.f11224a.g(this.mEventReceiver);
    }
}
