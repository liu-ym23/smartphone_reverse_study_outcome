package com.stepos.common.widget;

/* renamed from: com.stepos.common.widget.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC1102g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f3803a;

    public RunnableC1102g(CircularProgressButton circularProgressButton) {
        this.f3803a = circularProgressButton;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3803a.invalidate();
    }
}
