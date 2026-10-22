package com.mdisdk.capability.input;

/* loaded from: classes3.dex */
public interface IEventInjector {
    boolean click(float f, float f7);

    boolean click(float f, float f7, int i);

    void fling(float f, float f7, float f9, float f10, long j5, int i, EventCallback eventCallback);

    void fling(float f, float f7, float f9, float f10, long j5, EventCallback eventCallback);

    void fling(float f, float f7, float f9, float f10, EventCallback eventCallback);

    boolean initialize();

    boolean injectKey(int i);

    boolean injectKey(int i, int i6);

    boolean injectKeyAction(int i, boolean z10);

    boolean injectKeyAction(int i, boolean z10, int i6);

    boolean isAvailable();

    void longPress(float f, float f7, long j5, int i, EventCallback eventCallback);

    void longPress(float f, float f7, long j5, EventCallback eventCallback);

    void longPress(float f, float f7, EventCallback eventCallback);

    void pinch(float f, float f7, float f9, float f10, int i, long j5, int i6, EventCallback eventCallback);

    void pinch(float f, float f7, float f9, float f10, int i, long j5, EventCallback eventCallback);

    void pinch(float f, float f7, float f9, float f10, EventCallback eventCallback);

    void release();

    void swipe(float f, float f7, float f9, float f10, long j5, int i, int i6, EventCallback eventCallback);

    void swipe(float f, float f7, float f9, float f10, long j5, int i, EventCallback eventCallback);

    void swipe(float f, float f7, float f9, float f10, EventCallback eventCallback);
}
