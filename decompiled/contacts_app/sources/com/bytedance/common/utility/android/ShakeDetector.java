package com.bytedance.common.utility.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;

/* JADX INFO: loaded from: classes2.dex */
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
    RingBuffer mBuffer;
    private long mLastShakeTime;
    private long mLastTime;
    private OnShakeListener mListener;
    Sensor mSensor;
    SensorManager mSensorMgr;

    public interface OnShakeListener {
        void onShake();
    }

    static class RingBuffer {
        final float[] mAccelRing;
        int mIndex;
        int mSize;
        final long[] mStampRing;

        RingBuffer(int r2) {
            this.mSize = r2;
            this.mAccelRing = new float[r2];
            this.mStampRing = new long[r2];
            this.mIndex = 0;
        }

        void clear() {
            int r0 = 0;
            this.mIndex = 0;
        L4:
            if (r0 >= this.mSize) goto L6;
            this.mStampRing[r0] = 0;
            r0 = r0 + 1;
            goto L4
        }

        void add(float r3, long r4) {
            float[] r0 = this.mAccelRing;
            int r1 = this.mIndex;
            r0[r1] = r3;
            this.mStampRing[r1] = r4;
            this.mIndex = (r1 + 1) % this.mSize;
        }

        boolean levelReached(long r20) {
            int r1 = this.mIndex;
            boolean r12 = true;
            int r6 = 0;
            int r11 = 0;
            long r7 = 0;
            long r9 = 0;
        L3:
            int r13 = this.mSize;
            if (r6 >= r13) goto L38;
            r1 = r1 - 1;
            if (r1 >= 0) goto L8;
            r1 = r13 - 1;
        L8:
            long r14 = this.mStampRing[r1];
            if (r14 <= 0) goto L10;
            if ((r20 - r14) > 1000) goto L13;
            if (r7 <= 0) goto L20;
            if ((r7 - r14) <= 800) goto L20;
            return false;
        L20:
            if (r9 > 0) goto L22;
        L24:
            float r15 = this.mAccelRing[r1];
            if (Math.abs(r15) < 2.0f) goto L37;
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

    public ShakeDetector(Context r1, OnShakeListener r2) {
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
        if ((r2 - this.mLastShakeTime) >= DimPointEffectTokens.PendingCycleMs) goto L11;
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
        Logger.d("Shaker", r4 + HanziToPinyin.Token.SEPARATOR + this.mAccel + HanziToPinyin.Token.SEPARATOR + r0 + HanziToPinyin.Token.SEPARATOR + r1 + HanziToPinyin.Token.SEPARATOR + r11);
        this.mBuffer.add(this.mAccel, r2);
        if (Math.abs(this.mAccel) > 2.0f) goto L16;
        return;
    L16:
        if (this.mBuffer.levelReached(r2) == false) goto L23;
        this.mBuffer.clear();
        this.mLastShakeTime = r2;
        OnShakeListener r9 = this.mListener;
        if (r9 == null) goto L24;
        r9.onShake();
        return;
    L24:
        return;
    L23:
        return;
    }
}
