package com.mdisdk.capability.input.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.input.EventCallback;
import com.mdisdk.capability.input.IEventInjector;
import com.mdisdk.capability.input.adapter.InputManagerAdapter;
import com.mdisdk.capability.input.impl.gesture.FlingGestureExecutor;
import com.mdisdk.capability.input.impl.gesture.PinchGestureExecutor;
import com.mdisdk.capability.input.impl.gesture.SwipeGestureExecutor;
import q3.RunnableC1799a;

/* loaded from: classes3.dex */
public class AndroidEventInjector implements IEventInjector {
    private static final long DEFAULT_FLING_DURATION = 200;
    private static final long DEFAULT_LONG_PRESS_DURATION = 600;
    private static final long DEFAULT_PINCH_DURATION = 300;
    private static final int DEFAULT_PINCH_STEPS = 10;
    private static final long DEFAULT_SWIPE_DURATION = 300;
    private static final int DEFAULT_SWIPE_STEPS = 10;
    private static final String TAG = "AndroidEventInjector";
    private final InputManagerAdapter adapter;
    private final InputEventFactory eventFactory;
    private volatile boolean initialized;
    private final Handler mainHandler;

    public AndroidEventInjector() {
        this.initialized = false;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.adapter = new InputManagerAdapter();
        this.eventFactory = new InputEventFactory();
    }

    private void ensureInitialized() {
        if (!this.initialized) {
            initialize();
        }
        if (!isAvailable()) {
            throw new IllegalStateException("EventInjector not available");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$longPress$0(long j5, float f, float f7, int i, EventCallback eventCallback) {
        MotionEvent motionEventCreateTouchEvent = this.eventFactory.createTouchEvent(j5, SystemClock.uptimeMillis(), 1, f, f7);
        boolean zInjectInputEvent = this.adapter.injectInputEvent(motionEventCreateTouchEvent, i);
        motionEventCreateTouchEvent.recycle();
        if (eventCallback != null) {
            if (zInjectInputEvent) {
                eventCallback.onSuccess();
            } else {
                eventCallback.onFailure("Failed to inject UP event");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$longPress$1(float f, float f7, int i, EventCallback eventCallback, long j5) {
        ensureInitialized();
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventCreateTouchEvent = this.eventFactory.createTouchEvent(jUptimeMillis, jUptimeMillis, 0, f, f7);
        boolean zInjectInputEvent = this.adapter.injectInputEvent(motionEventCreateTouchEvent, i);
        motionEventCreateTouchEvent.recycle();
        if (zInjectInputEvent) {
            this.mainHandler.postDelayed(new RunnableC1799a(this, jUptimeMillis, f, f7, i, eventCallback), j5);
        } else if (eventCallback != null) {
            eventCallback.onFailure("Failed to inject DOWN event");
        }
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean click(float f, float f7, int i) {
        ensureInitialized();
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventCreateTouchEvent = this.eventFactory.createTouchEvent(jUptimeMillis, jUptimeMillis, 0, f, f7);
        boolean zInjectInputEvent = this.adapter.injectInputEvent(motionEventCreateTouchEvent, i);
        motionEventCreateTouchEvent.recycle();
        if (!zInjectInputEvent) {
            return false;
        }
        MotionEvent motionEventCreateTouchEvent2 = this.eventFactory.createTouchEvent(jUptimeMillis, SystemClock.uptimeMillis(), 1, f, f7);
        boolean zInjectInputEvent2 = this.adapter.injectInputEvent(motionEventCreateTouchEvent2, i);
        motionEventCreateTouchEvent2.recycle();
        return zInjectInputEvent2;
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void fling(float f, float f7, float f9, float f10, long j5, int i, EventCallback eventCallback) {
        ensureInitialized();
        new FlingGestureExecutor(this.adapter, this.eventFactory, f, f7, f9, f10, j5, 15).execute(i, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean initialize() {
        if (!this.initialized) {
            this.initialized = this.adapter.initialize();
            if (this.initialized) {
                ALog.d(TAG, "AndroidEventInjector initialized successfully", null);
            } else {
                ALog.e(TAG, "Failed to initialize AndroidEventInjector", null);
            }
        }
        return this.initialized;
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean injectKey(int i, int i6) {
        ensureInitialized();
        if (injectKeyAction(i, true, i6)) {
            return injectKeyAction(i, false, i6);
        }
        return false;
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean injectKeyAction(int i, boolean z10, int i6) {
        ensureInitialized();
        return this.adapter.injectInputEvent(this.eventFactory.createKeyEvent(i, z10), i6);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean isAvailable() {
        return this.initialized && this.adapter.isAvailable();
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void longPress(float f, float f7, long j5, int i, EventCallback eventCallback) {
        this.mainHandler.post(new RunnableC1799a(this, f, f7, i, eventCallback, j5));
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void pinch(float f, float f7, float f9, float f10, int i, long j5, int i6, EventCallback eventCallback) {
        ensureInitialized();
        if (i < 1) {
            throw new IllegalArgumentException("steps must be >= 1");
        }
        new PinchGestureExecutor(this.adapter, this.eventFactory, f, f7, f9, f10, i, j5).execute(i6, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void release() {
        this.adapter.release();
        this.initialized = false;
        ALog.d(TAG, "AndroidEventInjector released", null);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void swipe(float f, float f7, float f9, float f10, long j5, int i, int i6, EventCallback eventCallback) {
        ensureInitialized();
        if (i < 1) {
            throw new IllegalArgumentException("steps must be >= 1");
        }
        new SwipeGestureExecutor(this.adapter, this.eventFactory, f, f7, f9, f10, j5, i).execute(i6, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void longPress(float f, float f7, EventCallback eventCallback) {
        longPress(f, f7, DEFAULT_LONG_PRESS_DURATION, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void longPress(float f, float f7, long j5, EventCallback eventCallback) {
        longPress(f, f7, j5, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void fling(float f, float f7, float f9, float f10, EventCallback eventCallback) {
        fling(f, f7, f9, f10, DEFAULT_FLING_DURATION, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean injectKey(int i) {
        return injectKey(i, 0);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean injectKeyAction(int i, boolean z10) {
        return injectKeyAction(i, z10, 0);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void fling(float f, float f7, float f9, float f10, long j5, EventCallback eventCallback) {
        fling(f, f7, f9, f10, j5, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void pinch(float f, float f7, float f9, float f10, EventCallback eventCallback) {
        pinch(f, f7, f9, f10, 10, 300L, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void swipe(float f, float f7, float f9, float f10, EventCallback eventCallback) {
        swipe(f, f7, f9, f10, 300L, 10, 0, eventCallback);
    }

    public AndroidEventInjector(InputManagerAdapter inputManagerAdapter, InputEventFactory inputEventFactory) {
        this.initialized = false;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.adapter = inputManagerAdapter;
        this.eventFactory = inputEventFactory;
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void pinch(float f, float f7, float f9, float f10, int i, long j5, EventCallback eventCallback) {
        pinch(f, f7, f9, f10, i, j5, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public void swipe(float f, float f7, float f9, float f10, long j5, int i, EventCallback eventCallback) {
        swipe(f, f7, f9, f10, j5, i, 0, eventCallback);
    }

    @Override // com.mdisdk.capability.input.IEventInjector
    public boolean click(float f, float f7) {
        return click(f, f7, 0);
    }
}
