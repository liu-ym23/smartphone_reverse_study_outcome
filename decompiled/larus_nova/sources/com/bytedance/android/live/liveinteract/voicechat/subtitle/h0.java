package com.bytedance.android.live.liveinteract.voicechat.subtitle;

/* JADX INFO: loaded from: classes46.dex */
public final class h0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f80707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f80708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f80709c;

    public h0(int r100) {
        this.f80709c = r100;
    }

    public final T a(T r100) {
        if (this.f80708b != 0) goto L7;
        return this.f80707a;
    L7:
        if (this.f80709c > 0) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L16;
        return r100;
    L16:
        return this.f80707a;
    L10:
        if ((System.currentTimeMillis() - this.f80708b) <= this.f80709c) goto L12;
        r101 = true;
        goto L13
    }

    public final void b(T r100) {
        this.f80707a = r100;
        this.f80708b = System.currentTimeMillis();
    }
}
