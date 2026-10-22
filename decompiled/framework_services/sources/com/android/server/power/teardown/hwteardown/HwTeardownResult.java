package com.android.server.power.teardown.hwteardown;

import bytedanceos.util.FeatLog;
import com.android.server.power.teardown.ComponentResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class HwTeardownResult {
    public static final String COMPONENT_BLUETOOTH = "Bluetooth";
    public static final String COMPONENT_CAMERA = "Camera";
    public static final String COMPONENT_CPU = "Cpu";
    public static final String COMPONENT_DISPLAY = "Display";
    public static final String COMPONENT_DSP = "Dsp";
    public static final String COMPONENT_FAN = "Fan";
    public static final String COMPONENT_FLASHLIGHT = "Flashlight";
    public static final String COMPONENT_GPS = "Gps";
    public static final String COMPONENT_GPU = "Gpu";
    public static final String COMPONENT_MODEM = "Modem";
    public static final String COMPONENT_NFC = "Nfc";
    public static final String COMPONENT_PHONE = "Phone";
    public static final String COMPONENT_SETTING = "Setting";
    public static final String COMPONENT_VIBRATOR = "Vibrator";
    public static final String COMPONENT_WIFI = "Wifi";
    public static final String COMPONENT_XRCAMERA = "XrCamera";
    private static final String FEAT_TAG = "FEAT_POWER_TEARDOWN";
    private static final String TAG = "HwTeardownResult";
    public int mBaseCurrent;
    public int mCableCurrent;
    public HashMap<String, ComponentResult> mComponentResults;
    public int mCurrent;
    public int mEndBatteryLevel;
    public long mEndCurTime;
    public long mEndTime;
    public int mEndTrainNumId;
    public int mFpgaCurrent;
    public int mOthersCurrent;
    public int mPcieCurrent;
    public long mScreenOnDuration;
    public int mStartBatteryLevel;
    public long mStartCurTime;
    public long mStartTime;
    public int mStartTrainNumId;
    public int mTwoOneCurrent;
    public int mVivianCurrent;

    public HwTeardownResult(long startTime, long endTime, long startCurTime, long endCurTime, int startTrainNumId, int endTrainNumId, int startBatteryLevel, int endBatteryLevel, int baseCurrent, int vivianCurrent, int fpgaCurrent, int cableCurrent, int twoOneCurrent, int pcieCurrent, int othersCurrent, int current, HashMap<String, ComponentResult> componentResults) {
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        this.mStartCurTime = startCurTime;
        this.mEndCurTime = endCurTime;
        this.mStartTrainNumId = startTrainNumId;
        this.mEndTrainNumId = endTrainNumId;
        this.mStartBatteryLevel = startBatteryLevel;
        this.mEndBatteryLevel = endBatteryLevel;
        this.mBaseCurrent = baseCurrent;
        this.mVivianCurrent = vivianCurrent;
        this.mFpgaCurrent = fpgaCurrent;
        this.mCableCurrent = cableCurrent;
        this.mTwoOneCurrent = twoOneCurrent;
        this.mPcieCurrent = pcieCurrent;
        this.mOthersCurrent = othersCurrent;
        this.mCurrent = current;
        this.mComponentResults = componentResults;
        DisplayTeardownResult displayResult = (DisplayTeardownResult) this.mComponentResults.get(COMPONENT_DISPLAY);
        this.mScreenOnDuration = displayResult.mScreenOnDuration;
    }

    public String toString() {
        DisplayTeardownResult displayResult = (DisplayTeardownResult) this.mComponentResults.get(COMPONENT_DISPLAY);
        long duration = this.mEndTime - this.mStartTime;
        int currentTeardown = 0;
        Iterator<Map.Entry<String, ComponentResult>> r5 = this.mComponentResults.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, ComponentResult> entry = r5.next();
        if (entry.getValue() == null) goto L7;
        if (entry.getKey().equals(COMPONENT_NFC) == true) goto L10;
        currentTeardown = currentTeardown + entry.getValue().mCurrent;
        goto L4
    L10:
        currentTeardown = currentTeardown + (entry.getValue().mCurrent / 1000);
        goto L4
    L7:
        FeatLog.e(TAG, FEAT_TAG, 0, "ComponentResult is null for key " + entry.getKey());
        goto L4
    L13:
        int currentTeardown2 = currentTeardown + (((((this.mVivianCurrent + this.mFpgaCurrent) + this.mCableCurrent) + this.mTwoOneCurrent) + this.mPcieCurrent) + this.mOthersCurrent);
        StringBuilder sb = new StringBuilder();
        sb.append("teardownTime: [");
        sb.append(getData(this.mStartCurTime));
        sb.append(", ");
        sb.append(getData(this.mEndCurTime));
        sb.append(", ");
        sb.append(duration / 1000);
        sb.append("s], current = ");
        sb.append(this.mCurrent);
        sb.append("mA, unHwTeardownCurrent = ");
        sb.append(this.mCurrent - currentTeardown2);
        sb.append("mA screenOnDuration = ");
        sb.append(displayResult.mScreenOnDuration / 1000);
        sb.append("s, startBatteryLevel=");
        sb.append(this.mStartBatteryLevel);
        sb.append(", endBatteryLevel=");
        sb.append(this.mEndBatteryLevel);
        sb.append(", baseCurrent=");
        sb.append(this.mBaseCurrent);
        sb.append("mA");
        sb.append(", vivianCurrent=");
        sb.append(this.mVivianCurrent);
        sb.append("mA");
        sb.append(", fpgaCurrent=");
        sb.append(this.mFpgaCurrent);
        sb.append("mA");
        sb.append(", cableCurrent=");
        sb.append(this.mCableCurrent);
        sb.append("mA");
        sb.append(", twoOneCurrent=");
        sb.append(this.mTwoOneCurrent);
        sb.append("mA");
        sb.append(", pcieCurrent=");
        sb.append(this.mPcieCurrent);
        sb.append("mA");
        sb.append(", othersCurrent=");
        sb.append(this.mOthersCurrent);
        sb.append("mA\n");
        sb.append("teardown all(");
        sb.append(((((long) currentTeardown2) * duration) / 1000) / 3600);
        sb.append("mAh, ");
        sb.append(currentTeardown2);
        sb.append("mA), ");
        boolean isFirst = true;
        Iterator<Map.Entry<String, ComponentResult>> r12 = this.mComponentResults.entrySet().iterator();
    L15:
        if (r12.hasNext() == false) goto L28;
        Map.Entry<String, ComponentResult> entry2 = r12.next();
        if (entry2.getValue() == null) goto L18;
        DisplayTeardownResult displayResult2 = displayResult;
        if (isFirst == false) goto L22;
        isFirst = false;
    L23:
        sb.append(entry2.getKey());
        sb.append("(");
        long duration2 = duration;
        sb.append(((((long) entry2.getValue().mCurrent) * duration2) / 1000) / 3600);
        sb.append("mAh, ");
        sb.append(entry2.getValue().mCurrent);
        if (entry2.getKey().equals(COMPONENT_NFC) == false) goto L26;
        sb.append("uA)");
    L27:
        displayResult = displayResult2;
        duration = duration2;
        goto L15
    L26:
        sb.append("mA)");
        goto L27
    L22:
        sb.append(", ");
        goto L23
    L18:
        StringBuilder r9 = new StringBuilder();
        r9.append("ComponentResult is null for key ");
        r9.append(entry2.getKey());
        FeatLog.e(TAG, FEAT_TAG, 0, r9.toString());
        displayResult = displayResult;
        goto L15
    L28:
        sb.append("\n");
        Iterator<Map.Entry<String, ComponentResult>> r1 = this.mComponentResults.entrySet().iterator();
    L30:
        if (r1.hasNext() == false) goto L36;
        Map.Entry<String, ComponentResult> entry3 = r1.next();
        if (entry3.getValue() == null) goto L33;
        sb.append(entry3.getValue().toString());
        goto L30
    L33:
        FeatLog.e(TAG, FEAT_TAG, 0, "ComponentResult is null for key " + entry3.getKey());
        goto L30
    L36:
        return sb.toString();
    }

    private String getData(long currentTime) {
        Date date = new Date(currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
