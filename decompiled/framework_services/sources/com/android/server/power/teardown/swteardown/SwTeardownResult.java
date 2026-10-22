package com.android.server.power.teardown.swteardown;

import bytedanceos.util.FeatLog;
import com.android.server.power.teardown.ComponentResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SwTeardownResult {
    public static final String COMPONENT_AIMODEL = "AiModel";
    public static final String COMPONENT_ALARM = "Alarm";
    public static final String COMPONENT_AUDIO = "Audio";
    public static final String COMPONENT_BLE = "Ble";
    public static final String COMPONENT_CAMERA = "Camera";
    public static final String COMPONENT_CPU = "Cpu";
    public static final String COMPONENT_EVENT = "Event";
    public static final String COMPONENT_GPS = "Gps";
    public static final String COMPONENT_GPU = "Gpu";
    public static final String COMPONENT_MODEM = "Modem";
    public static final String COMPONENT_VIBRATOR = "Vibrator";
    public static final String COMPONENT_VIDEO = "Video";
    public static final String COMPONENT_WAKELOCK = "Wakelock";
    public static final String COMPONENT_WIFI = "Wifi";
    private static final String FEAT_TAG = "FEAT_POWER_TEARDOWN";
    private static final String TAG = "SwTeardownResult";
    public int mBatteryPower;
    public HashMap<String, ComponentResult> mComponentResults;
    public int mCurrent;
    public int mEndBatteryLevel;
    public long mEndCurTime;
    public long mEndTime;
    public int mEndTrainNumId;
    public HashMap<String, Long> mFrontAppDurations;
    public HashMap<String, Long> mNoFocusFrontDurations;
    public long mScreenOffDuration;
    public long mScreenOnDuration;
    public int mStartBatteryLevel;
    public long mStartCurTime;
    public long mStartTime;
    public int mStartTrainNumId;
    public int mUsbPower;

    public SwTeardownResult(long startTime, long endTime, long startCurTime, long endCurTime, int startTrainNumId, int endTrainNumId, int startBatteryLevel, int endBatteryLevel, long screenOnDuration, long screenOffDuration, HashMap<String, Long> frontAppDurations, HashMap<String, Long> noFocusFrontDurations, HashMap<String, ComponentResult> componentResults, int current, int batteryPower, int usbPower) {
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        this.mStartCurTime = startCurTime;
        this.mEndCurTime = endCurTime;
        this.mStartTrainNumId = startTrainNumId;
        this.mEndTrainNumId = endTrainNumId;
        this.mStartBatteryLevel = startBatteryLevel;
        this.mEndBatteryLevel = endBatteryLevel;
        this.mBatteryPower = batteryPower;
        this.mUsbPower = usbPower;
        this.mScreenOnDuration = screenOnDuration;
        this.mScreenOffDuration = screenOffDuration;
        this.mFrontAppDurations = frontAppDurations;
        this.mNoFocusFrontDurations = noFocusFrontDurations;
        this.mComponentResults = componentResults;
        this.mCurrent = current;
    }

    public String toString() {
        long duration = this.mEndTime - this.mStartTime;
        int currentTeardown = 0;
        Iterator<Map.Entry<String, ComponentResult>> r4 = this.mComponentResults.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        Map.Entry<String, ComponentResult> entry = r4.next();
        if (entry.getValue() == null) goto L7;
        if (entry.getKey().equals(COMPONENT_ALARM) == true) goto L10;
        currentTeardown = currentTeardown + entry.getValue().mCurrent;
        goto L4
    L10:
        currentTeardown = currentTeardown + (entry.getValue().mCurrent / 1000);
        goto L4
    L7:
        FeatLog.e(TAG, FEAT_TAG, 0, "ComponentResult is null for key " + entry.getKey());
        goto L4
    L13:
        StringBuilder sb = new StringBuilder();
        sb.append("teardownTime: [");
        sb.append(getData(this.mStartCurTime));
        sb.append(", ");
        sb.append(getData(this.mEndCurTime));
        sb.append(", ");
        sb.append(duration / 1000);
        sb.append("s], current = ");
        sb.append(this.mCurrent);
        sb.append("mA, unSwTeardownCurrent = ");
        sb.append(this.mCurrent - currentTeardown);
        sb.append("mA, startBatteryLevel=");
        sb.append(this.mStartBatteryLevel);
        sb.append(", endBatteryLevel=");
        sb.append(this.mEndBatteryLevel);
        sb.append(", batteryPower=");
        sb.append(this.mBatteryPower);
        sb.append("mW");
        sb.append(", usbPower=");
        sb.append(this.mUsbPower);
        sb.append("mW");
        sb.append(", screenOn=");
        sb.append(this.mScreenOnDuration / 1000);
        sb.append("s , screenOff=");
        sb.append(this.mScreenOffDuration / 1000);
        sb.append("s\n");
        sb.append("teardown all(");
        long duration2 = 3600;
        sb.append(((((long) currentTeardown) * duration) / 1000) / 3600);
        sb.append("mAh, ");
        sb.append(currentTeardown);
        sb.append("mA), ");
        boolean isFirst = true;
        Iterator<Map.Entry<String, ComponentResult>> r11 = this.mComponentResults.entrySet().iterator();
    L15:
        if (r11.hasNext() == false) goto L32;
        Map.Entry<String, ComponentResult> entry2 = r11.next();
        if (entry2.getValue() == null) goto L18;
        long r19 = duration2;
        if (isFirst == false) goto L22;
        isFirst = false;
    L23:
        sb.append(entry2.getKey());
        sb.append("(");
        if (entry2.getKey().equals(COMPONENT_ALARM) == false) goto L26;
        long duration3 = duration;
        sb.append((((((long) entry2.getValue().mCurrent) * duration3) / 1000) / r19) / 1000);
    L27:
        sb.append("mAh, ");
        sb.append(entry2.getValue().mCurrent);
        if (entry2.getKey().equals(COMPONENT_ALARM) == false) goto L30;
        sb.append("μA)");
    L31:
        duration = duration3;
        duration2 = r19;
        goto L15
    L30:
        sb.append("mA)");
        goto L31
    L26:
        duration3 = duration;
        sb.append(((((long) entry2.getValue().mCurrent) * duration3) / 1000) / r19);
        goto L27
    L22:
        sb.append(", ");
        goto L23
    L18:
        FeatLog.e(TAG, FEAT_TAG, 0, "ComponentResult is null for key " + entry2.getKey());
        duration2 = duration2;
        goto L15
    L32:
        sb.append("\n");
        boolean isFirst2 = true;
        sb.append("Focus Front App Usages: ");
        Iterator<Map.Entry<String, Long>> r6 = this.mFrontAppDurations.entrySet().iterator();
    L33:
        long r13 = 0;
        if (r6.hasNext() == false) goto L41;
        Map.Entry<String, Long> entry3 = r6.next();
        if ((entry3.getValue().longValue() / 1000) <= 0) goto L33;
        if (isFirst2 == true) goto L40;
        sb.append(", ");
    L40:
        isFirst2 = false;
        sb.append("[");
        sb.append(entry3.getKey());
        sb.append(", ");
        sb.append(entry3.getValue().longValue() / 1000);
        sb.append("s]");
        goto L33
    L41:
        sb.append("\n");
        boolean isFirst3 = true;
        sb.append("No Focus Front App Usages: ");
        Iterator<Map.Entry<String, Long>> r7 = this.mNoFocusFrontDurations.entrySet().iterator();
    L43:
        if (r7.hasNext() == false) goto L50;
        Map.Entry<String, Long> entry4 = r7.next();
        if ((entry4.getValue().longValue() / 1000) <= r13) goto L43;
        if (isFirst3 == true) goto L49;
        sb.append(", ");
    L49:
        isFirst3 = false;
        sb.append("[");
        sb.append(entry4.getKey());
        sb.append(", ");
        sb.append(entry4.getValue().longValue() / 1000);
        sb.append("s]");
        r13 = 0;
        goto L43
    L50:
        sb.append("\n");
        Iterator<Map.Entry<String, ComponentResult>> r1 = this.mComponentResults.entrySet().iterator();
    L52:
        if (r1.hasNext() == false) goto L58;
        Map.Entry<String, ComponentResult> entry5 = r1.next();
        if (entry5.getValue() == null) goto L55;
        sb.append(entry5.getValue().toString());
        goto L52
    L55:
        FeatLog.e(TAG, FEAT_TAG, 0, "ComponentResult is null for key " + entry5.getKey());
        goto L52
    L58:
        return sb.toString();
    }

    private String getData(long currentTime) {
        Date date = new Date(currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
