package com.android.server.policy;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.os.Handler;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WakeGestureListener {
    private static final String TAG = "WakeGestureListener";
    private final Handler mHandler;
    private final TriggerEventListener mListener;
    private final Object mLock;
    private Sensor mSensor;
    private final SensorManager mSensorManager;
    private boolean mTriggerRequested;
    private final Runnable mWakeUpRunnable;

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7280$$Nest$fgetmHandler(WakeGestureListener r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7281$$Nest$fgetmLock(WakeGestureListener r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakeUpRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m7282$$Nest$fgetmWakeUpRunnable(WakeGestureListener r0) {
        return r0.mWakeUpRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTriggerRequested, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7283$$Nest$fputmTriggerRequested(WakeGestureListener r0, boolean r1) {
        r0.mTriggerRequested = r1;
    }

    public abstract void onWakeUp();

    public WakeGestureListener(Context context, Handler handler) {
        this.mLock = new Object();
        this.mListener = new AnonymousClass1(this);
        this.mWakeUpRunnable = new AnonymousClass2(this);
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.mHandler = handler;
        this.mSensor = this.mSensorManager.getDefaultSensor(23);
    }

    public boolean isSupported() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSensor == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void requestWakeUpTrigger() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSensor != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mTriggerRequested == true) goto L11;
        this.mTriggerRequested = true;     // Catch: Throwable -> L9
        this.mSensorManager.requestTriggerSensor(this.mListener, this.mSensor);     // Catch: Throwable -> L9
        goto L11
    }

    public void cancelWakeUpTrigger() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSensor != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mTriggerRequested == false) goto L11;
        this.mTriggerRequested = false;     // Catch: Throwable -> L9
        this.mSensorManager.cancelTriggerSensor(this.mListener, this.mSensor);     // Catch: Throwable -> L9
        goto L11
    }

    public void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println(prefix + TAG);     // Catch: Throwable -> L7
        String prefix2 = prefix + "  ";     // Catch: Throwable -> L7
        pw.println(prefix2 + "mTriggerRequested=" + this.mTriggerRequested);     // Catch: Throwable -> L7
        pw.println(prefix2 + "mSensor=" + this.mSensor);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
