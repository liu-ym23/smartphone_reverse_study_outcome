package com.bytedance.android.live.lynx.ui.replay;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoViewForLynx f82797a;

    public a(ReplayVideoViewForLynx r100) {
        this.f82797a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f82797a.e("paidStatusUpdate", MapsKt.mapOf(new Pair[]{TuplesKt.to("paid_status", (Integer) r100), TuplesKt.to("episode_id", String.valueOf(this.f82797a.f82782o))}));
    }
}
