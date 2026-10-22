package com.bytedance.android.livesdk.authorize;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f104223a = null;

    static {
        f104223a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L6;
        r101.printStackTrace();
        return;
    }
}
