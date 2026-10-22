package com.android.server.power.teardown.hwteardown;

import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public final class DisplayTeardownResult extends ComponentResult {
    public int mAodCurrent;
    public long mAodDuration;
    public int mBacklightCurrent;
    public long[] mBrightnessDuration;
    public int[] mDisplayHeights;
    public int[] mDisplayWidths;
    public int mPanelCurrent;
    public long[][] mRefreshRateDuration;
    public int[] mRefreshRates;
    public long mScreenOnDuration;

    public DisplayTeardownResult(int displayCurrent, int panelCurrent, int backlightCurrent, int aodCurrent, long[][] refreshRateDuration, int[] displayWidths, int[] displayHeights, int[] refreshRates, long screenOnDuration, long[] brightnessDuration, long aodDuration) {
        this.mCurrent = displayCurrent;
        this.mPanelCurrent = panelCurrent;
        this.mBacklightCurrent = backlightCurrent;
        this.mAodCurrent = aodCurrent;
        this.mRefreshRateDuration = refreshRateDuration;
        this.mDisplayWidths = displayWidths;
        this.mDisplayHeights = displayHeights;
        this.mRefreshRates = refreshRates;
        this.mScreenOnDuration = screenOnDuration;
        this.mBrightnessDuration = brightnessDuration;
        this.mAodDuration = aodDuration;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Display] display current=");
        sb.append(this.mCurrent);
        sb.append("mA, panelCurrent=");
        sb.append(this.mPanelCurrent);
        sb.append("mA, backlightCurrent=");
        sb.append(this.mBacklightCurrent);
        sb.append("mA, aodCurrent=");
        sb.append(this.mAodCurrent);
        sb.append("mA, refreshRate={");
        int i = 0;
    L4:
        if (i >= this.mRefreshRateDuration.length) goto L31;
        if (i == 0) goto L8;
        sb.append(", ");
    L8:
        if (i < this.mDisplayWidths.length) goto L10;
    L12:
        String resolution = String.valueOf(i);
    L13:
        sb.append(resolution);
        sb.append(":{");
        boolean firstRefreshRate = true;
        int j = 0;
    L15:
        if (j >= this.mRefreshRateDuration[i].length) goto L28;
        if (this.mRefreshRateDuration[i][j] <= 0) goto L26;
        if (firstRefreshRate == true) goto L21;
        sb.append(", ");
    L21:
        firstRefreshRate = false;
        if (j >= this.mRefreshRates.length) goto L24;
        String refreshRate = this.mRefreshRates[j] + "Hz";
    L25:
        sb.append(refreshRate);
        sb.append("=");
        sb.append(this.mRefreshRateDuration[i][j] / 1000);
        sb.append("s");
        goto L26
    L24:
        refreshRate = String.valueOf(j);
    L26:
        j = j + 1;
        goto L15
    L28:
        if (firstRefreshRate == false) goto L30;
        sb.append("empty");
    L30:
        sb.append("}");
        i = i + 1;
        goto L4
    L10:
        if (i >= this.mDisplayHeights.length) goto L12;
        resolution = this.mDisplayWidths[i] + "x" + this.mDisplayHeights[i];
        goto L13
    L31:
        sb.append("}, screenOnDuration=");
        sb.append(this.mScreenOnDuration / 1000);
        sb.append("s, aodDuration=");
        sb.append(this.mAodDuration / 1000);
        sb.append("s, brightnessTime=[");
        boolean isFirst = true;
        int i2 = 0;
    L33:
        if (i2 >= this.mBrightnessDuration.length) goto L40;
        if (this.mBrightnessDuration[i2] <= BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS) goto L39;
        if (isFirst == true) goto L38;
        sb.append(", ");
    L38:
        isFirst = false;
        sb.append("(");
        sb.append(i2);
        sb.append(", ");
        sb.append(this.mBrightnessDuration[i2] / 1000);
        sb.append("s");
        sb.append(")");
    L39:
        i2 = i2 + 1;
        goto L33
    L40:
        sb.append("]\n");
        return sb.toString();
    }
}
