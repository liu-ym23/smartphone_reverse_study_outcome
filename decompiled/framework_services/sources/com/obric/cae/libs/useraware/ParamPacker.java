package com.obric.cae.libs.useraware;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ParamPacker {
    public static final int TOTAL_LENGTH = 54;

    public ParamPacker() {
    }

    public static byte[] pack(HarMonitorParams r7) {
        if (r7 != null) goto L5;
    L18:
        return null;
    L5:
        if (ParamsValidator.validate(r7) == false) goto L18;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(54);
        DataOutputStream r2 = new DataOutputStream(r1);
        r2.writeInt(r7.stateVoteWindowSize);     // Catch: IOException -> L14
        r2.writeInt(r7.walkingContinuousThreshold);     // Catch: IOException -> L14
        r2.writeInt(r7.runningContinuousThreshold);     // Catch: IOException -> L14
        r2.writeInt(r7.accelOccurrenceThreshold);     // Catch: IOException -> L14
        r2.writeInt(r7.stationaryOccurrenceThreshold);     // Catch: IOException -> L14
        r2.writeInt(r7.accStateDurationThreshold);     // Catch: IOException -> L14
        r2.writeInt(r7.accStateMonitorWindow);     // Catch: IOException -> L14
        r2.writeInt(r7.accStateDurationThreshold2);     // Catch: IOException -> L14
        r2.writeInt(r7.runningStateDurationThreshold);     // Catch: IOException -> L14
        r2.writeInt(r7.runningStateMonitorWindow);     // Catch: IOException -> L14
        r2.writeInt(r7.runningStateDurationThreshold2);     // Catch: IOException -> L14
        byte[] r8 = r1.toByteArray();     // Catch: IOException -> L14
        if (r8.length == 52) goto L11;
        return null;
    L11:
        int r3 = Math.min(r8.length, 52);     // Catch: IOException -> L14
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r4 >= r3) goto L16;
        r5 = r5 + (r8[r4] & CecDeviceType.INACTIVE);     // Catch: IOException -> L14
        r4 = r4 + 1;     // Catch: IOException -> L14
        goto L12
    L16:
        r2.writeShort((short) (65535 & r5));     // Catch: IOException -> L14
        return r1.toByteArray();
    }
}
