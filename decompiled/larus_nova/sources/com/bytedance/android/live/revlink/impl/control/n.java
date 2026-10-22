package com.bytedance.android.live.revlink.impl.control;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f92447a = null;

    static {
        f92447a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if (r101 == null) goto L6;
        com.bytedance.android.live.revlink.impl.utils.t.b("LinkRevControlPresenter", r101);
        return;
    }
}
