package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f88606a = null;

    static {
        f88606a = new g0();
    }

    public g0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        n0 r101 = (n0) r100;
        if (r101 == null) goto L6;
        String r102 = o.b(r101.f88681q, r101.getType());
        o.d(CollectionsKt.listOf(r101.f88668d).toString(), CollectionsKt.listOf(r102).toString(), "1", CollectionsKt.listOf(o.f(r101.f88683s, r101.f88676l)).toString());
        return;
    }
}
