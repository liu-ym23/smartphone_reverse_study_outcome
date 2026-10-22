package com.bytedance.android.livesdk.interactivity.seek.v2;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements h80.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f140826a;

    public c(b r100) {
        this.f140826a = r100;
    }

    @Override // h80.d
    public final Object get() {
        b r100 = this.f140826a;
        if (r100.f140821v == false) goto L6;
        long r101 = 1000;
        long r102 = (com.bytedance.android.livesdk.interactivity.common.utils.f.b(r100.f140817r) / r101) * r101;
        return String.valueOf(r102) + "_" + (r102 + r101);
    L6:
        return r100.f140808i;
    }
}
