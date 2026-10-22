package com.obric.autogui.net.ttnet.b;

/* JADX INFO: compiled from: CustomHttpException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.bytedance.common.utility.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f29229b;

    public b(int r1, int r2, String r3, Throwable r4) {
        super(r1, r3);
        this.f29228a = r2;
        this.f29229b = r4;
    }

    public final int b() {
        return this.f29228a;
    }

    public final Throwable c() {
        return this.f29229b;
    }
}
