package com.bytedance.android.live.profit.vip;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f89187a = null;

    static {
        f89187a = new r();
    }

    public r() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = w51.a.f558315a;
        StringBuilder r103 = new StringBuilder("reportVipRechargeStrategy failed: ");
        if (r101 == null) goto L5;
        String r104 = r101.getMessage();
    L6:
        r103.append(r104);
        w51.a.C8068a.a(r103.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }
}
