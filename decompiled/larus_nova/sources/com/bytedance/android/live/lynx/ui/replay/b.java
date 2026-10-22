package com.bytedance.android.live.lynx.ui.replay;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoViewForLynx f82798a;

    public b(ReplayVideoViewForLynx r100) {
        this.f82798a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f82798a.e("paidTrialCountDown", MapsKt.mapOf(new Pair[]{TuplesKt.to("remain_second", Long.valueOf(((Long) r100).longValue() / 1000)), TuplesKt.to("episode_id", String.valueOf(this.f82798a.f82782o))}));
    }
}
