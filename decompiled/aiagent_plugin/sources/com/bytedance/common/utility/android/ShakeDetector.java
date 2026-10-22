package com.bytedance.common.utility.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ShakeDetector implements SensorEventListener {
    private static final float ACCEL_THRESHOLD = 2.0f;
    private static final int BUFFER_SIZE = 10;
    public static final boolean ENABLE_SHAKER = false;
    private static final int FORCE_TIMEOUT = 500;
    private static final int MIN_SHAKE_COUNT = 3;
    private static final int MIN_SHAKE_INTERVAL = 1500;
    private static final int SHAKE_DURATION = 1000;
    private static final int SHAKE_TIMEOUT = 800;
    private static final int TIME_THRESHOLD = 100;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;
    b mBuffer;
    private long mLastShakeTime;
    private long mLastTime;
    private a mListener;
    Sensor mSensor;
    SensorManager mSensorMgr;

    public interface a {
        void a();
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f6708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long[] f6709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f6710d;

        void a() {
            int r0 = 0;
            this.f6707a = 0;
        L4:
            if (r0 >= this.f6710d) goto L6;
            this.f6709c[r0] = 0;
            r0 = r0 + 1;
            goto L4
        }

        void a(float r3, long r4) {
            float[] r0 = this.f6708b;
            int r1 = this.f6707a;
            r0[r1] = r3;
            this.f6709c[r1] = r4;
            this.f6707a = (r1 + 1) % this.f6710d;
        }

        boolean a(long r20) {
            int r1 = this.f6707a;
            long r7 = 0;
            long r9 = 0;
            boolean r12 = true;
            int r6 = 0;
            int r11 = 0;
        L3:
            int r13 = this.f6710d;
            if (r6 >= r13) goto L38;
            r1 = r1 - 1;
            if (r1 >= 0) goto L8;
            r1 = r13 - 1;
        L8:
            long r14 = this.f6709c[r1];
            if (r14 <= 0) goto L10;
            if ((r20 - r14) > 1000) goto L13;
            if (r7 <= 0) goto L20;
            if ((r7 - r14) <= 800) goto L20;
            return false;
        L20:
            if (r9 > 0) goto L22;
        L24:
            float r15 = this.f6708b[r1];
            if (Math.abs(r15) < ShakeDetector.ACCEL_THRESHOLD) goto L37;
            if (r15 <= 0.0f) goto L29;
            boolean r10 = true;
        L30:
            if (r11 == 0) goto L32;
            if (r10 != r12) goto L32;
        L34:
            if (r11 >= 3) goto L35;
            r9 = r14;
            goto L37
        L35:
            return true;
        L32:
            r11 = r11 + 1;
            r12 = r10;
            r7 = r14;
            goto L34
        L29:
            r10 = false;
        L37:
            r6 = r6 + 1;
            goto L3
        L22:
            if ((r9 - r14) <= 500) goto L24;
            return false;
        L13:
            return false;
        L10:
            return false;
        L38:
            return false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r1, int r2) {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public ShakeDetector(Context r3, a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r10) {
        if (r10.sensor != null) goto L6;
        return;
    L6:
        if (r10.sensor.getType() == 1) goto L8;
        return;
    L8:
        long r2 = System.currentTimeMillis();
        if ((r2 - this.mLastShakeTime) >= 1500) goto L11;
        return;
    L11:
        long r4 = r2 - this.mLastTime;
        if (r4 <= 100) goto L21;
        this.mLastTime = r2;
        float r0 = r10.values[0];
        float r1 = r10.values[1];
        float r11 = r10.values[2];
        this.mAccelLast = this.mAccelCurrent;
        float r6 = (float) Math.sqrt(((r0 * r0) + (r1 * r1)) + (r11 * r11));
        this.mAccelCurrent = r6;
        this.mAccel = (this.mAccel * 0.9f) + (r6 - this.mAccelLast);
        Logger.d("Shaker", r4 + " " + this.mAccel + " " + r0 + " " + r1 + " " + r11);
        this.mBuffer.a(this.mAccel, r2);
        if (Math.abs(this.mAccel) > ACCEL_THRESHOLD) goto L16;
        return;
    L16:
        if (this.mBuffer.a(r2) == false) goto L23;
        this.mBuffer.a();
        this.mLastShakeTime = r2;
        a r9 = this.mListener;
        if (r9 == null) goto L24;
        r9.a();
        return;
    L24:
        return;
    L23:
        return;
    }
}
