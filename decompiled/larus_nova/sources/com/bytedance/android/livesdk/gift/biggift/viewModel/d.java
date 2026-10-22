package com.bytedance.android.livesdk.gift.biggift.viewModel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f126001a = null;

    static {
        f126001a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        r101.getMessage();
        if (r101.getStackTrace() == null) goto L7;
        StackTraceElement[] r102 = r101.getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        r102[r104].toString();
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }
}
