package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class XrCameraTeardownResult extends ComponentResult {
    int[] mCameraCurrent;
    long[] mCameraDuration;
    long mTotalDuration;

    public XrCameraTeardownResult(int[] cameraCurrent, long[] cameraDuration, long duration) {
        this.mCameraCurrent = cameraCurrent;
        int i = 0;
    L4:
        if (i >= cameraCurrent.length) goto L6;
        this.mCurrent += cameraCurrent[i];
        i = i + 1;
        goto L4
    L6:
        this.mCameraDuration = cameraDuration;
        this.mTotalDuration = duration;
    }

    public String toString() {
        return "[XrCamera] current: " + this.mCurrent + "mA, camera current: " + Arrays.toString(this.mCameraCurrent) + "mA, camera duration: " + Arrays.toString(this.mCameraDuration) + "\n";
    }
}
