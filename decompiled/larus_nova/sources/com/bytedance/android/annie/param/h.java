package com.bytedance.android.annie.param;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f39702a = null;

    static {
        f39702a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k r101 = (k) r100;
        com.bytedance.android.annie.a.f(r101);
        if (i.f39704b != null) goto L7;
        i.f39704b = r101;
        return;
    }
}
