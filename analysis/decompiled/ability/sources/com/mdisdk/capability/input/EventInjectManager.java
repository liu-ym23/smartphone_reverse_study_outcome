package com.mdisdk.capability.input;

import android.view.MotionEvent;
import com.mdisdk.capability.input.adapter.InputManagerAdapter;
import com.mdisdk.capability.input.impl.AndroidEventInjector;

/* loaded from: classes3.dex */
public class EventInjectManager {
    private static final Object LOCK = new Object();
    private static volatile IEventInjector sInjector;
    private static volatile InputManagerAdapter sRawInputAdapter;

    private EventInjectManager() {
        throw new AssertionError("Cannot instantiate EventInjectManager");
    }

    public static boolean click(float f, float f7, int i) {
        return getInjector().click(f, f7, i);
    }

    private static IEventInjector createDefaultInjector() {
        AndroidEventInjector androidEventInjector = new AndroidEventInjector();
        androidEventInjector.initialize();
        return androidEventInjector;
    }

    public static void fling(float f, float f7, float f9, float f10, long j5, int i, EventCallback eventCallback) {
        getInjector().fling(f, f7, f9, f10, j5, i, eventCallback);
    }

    private static IEventInjector getInjector() {
        if (sInjector == null) {
            synchronized (LOCK) {
                try {
                    if (sInjector == null) {
                        sInjector = createDefaultInjector();
                    }
                } finally {
                }
            }
        }
        return sInjector;
    }

    public static boolean injectKey(int i, int i6) {
        return getInjector().injectKey(i, i6);
    }

    public static boolean injectKeyAction(int i, boolean z10, int i6) {
        return getInjector().injectKeyAction(i, z10, i6);
    }

    public static boolean injectRawMotionEvent(MotionEvent motionEvent, int i) {
        if (sRawInputAdapter == null) {
            synchronized (LOCK) {
                try {
                    if (sRawInputAdapter == null) {
                        InputManagerAdapter inputManagerAdapter = new InputManagerAdapter();
                        inputManagerAdapter.initialize();
                        sRawInputAdapter = inputManagerAdapter;
                    }
                } finally {
                }
            }
        }
        return sRawInputAdapter.injectInputEvent(motionEvent, i);
    }

    public static boolean isAvailable() {
        return getInjector().isAvailable();
    }

    public static void longPress(float f, float f7, long j5, int i, EventCallback eventCallback) {
        getInjector().longPress(f, f7, j5, i, eventCallback);
    }

    public static void pinch(float f, float f7, float f9, float f10, int i, long j5, int i6, EventCallback eventCallback) {
        getInjector().pinch(f, f7, f9, f10, i, j5, i6, eventCallback);
    }

    public static void reset() {
        synchronized (LOCK) {
            try {
                if (sInjector != null) {
                    sInjector.release();
                    sInjector = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setInjector(IEventInjector iEventInjector) {
        synchronized (LOCK) {
            try {
                if (sInjector != null) {
                    sInjector.release();
                }
                sInjector = iEventInjector;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void swipe(float f, float f7, float f9, float f10, long j5, int i, int i6, EventCallback eventCallback) {
        getInjector().swipe(f, f7, f9, f10, j5, i, i6, eventCallback);
    }

    public static boolean click(float f, float f7) {
        return getInjector().click(f, f7);
    }

    public static void fling(float f, float f7, float f9, float f10, EventCallback eventCallback) {
        getInjector().fling(f, f7, f9, f10, eventCallback);
    }

    public static boolean injectKey(int i) {
        return getInjector().injectKey(i);
    }

    public static boolean injectKeyAction(int i, boolean z10) {
        return getInjector().injectKeyAction(i, z10);
    }

    public static void longPress(float f, float f7, EventCallback eventCallback) {
        getInjector().longPress(f, f7, eventCallback);
    }

    public static void pinch(float f, float f7, float f9, float f10, EventCallback eventCallback) {
        getInjector().pinch(f, f7, f9, f10, eventCallback);
    }

    public static void swipe(float f, float f7, float f9, float f10, EventCallback eventCallback) {
        getInjector().swipe(f, f7, f9, f10, eventCallback);
    }

    public static void fling(float f, float f7, float f9, float f10, long j5, EventCallback eventCallback) {
        getInjector().fling(f, f7, f9, f10, j5, eventCallback);
    }

    public static void longPress(float f, float f7, long j5, EventCallback eventCallback) {
        getInjector().longPress(f, f7, j5, eventCallback);
    }

    public static void pinch(float f, float f7, float f9, float f10, int i, long j5, EventCallback eventCallback) {
        getInjector().pinch(f, f7, f9, f10, i, j5, eventCallback);
    }

    public static void swipe(float f, float f7, float f9, float f10, long j5, int i, EventCallback eventCallback) {
        getInjector().swipe(f, f7, f9, f10, j5, i, eventCallback);
    }
}
