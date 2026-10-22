package com.bytedance.android.live.profit.lottery;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f88052a = null;

    static {
        f88052a = new c0();
    }

    public c0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        k r101 = ((v.a) r100).f88219b.getLotteryInfo();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("lottery is not finished".toString());
    L5:
        if (r101.getStatus() != 2) goto L7;
        r102 = true;
        goto L8
    }
}
