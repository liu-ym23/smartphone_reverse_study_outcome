package com.bytedance.android.ec.core.monitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f45197a = null;

    static {
        f45197a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Throwable) r100).printStackTrace();
    }
}
