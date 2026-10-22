package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f73527a = null;

    static {
        f73527a = new v();
    }

    public v() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ff0.d r101 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "genOrderSingStreamInfo fail", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("logId", String.valueOf(ff0.c.a((Throwable) r100)))}), 12);
    }
}
