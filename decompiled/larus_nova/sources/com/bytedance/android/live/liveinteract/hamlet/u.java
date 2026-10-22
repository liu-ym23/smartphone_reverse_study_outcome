package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.GsonHelper;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f73526a = null;

    static {
        f73526a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        ff0.d r102 = ff0.d.f476647a;     // Catch: Exception -> L5
        com.bytedance.android.live.liveinteract.utils.j.a(1, "genOrderSingStreamInfo success", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("logId", String.valueOf(r101.logId)), TuplesKt.to("res", String.valueOf(GsonHelper.get().toJson(r101.data)))}), 12);     // Catch: Exception -> L5
        return;
    }
}
