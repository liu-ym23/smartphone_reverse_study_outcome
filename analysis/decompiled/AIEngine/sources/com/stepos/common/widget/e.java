package com.stepos.common.widget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CircularProgressButton f7150a;

    public e(CircularProgressButton circularProgressButton) {
        this.f7150a = circularProgressButton;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7150a.invalidate();
    }
}
