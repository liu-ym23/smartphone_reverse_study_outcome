package com.bytedance.android.livesdk.rank.widget;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zy0.b f157043a;

    public d(zy0.b r100) {
        this.f157043a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        boolean r102 = ((Boolean) r101.component1()).booleanValue();
        boolean r103 = ((Boolean) r101.component2()).booleanValue();
        xy0.a<?> r104 = this.f157043a.g();
        if (r104 == null) goto L6;
        r104.sendJsEvent("hourRankStateChanged", UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("showVerticalRank", Boolean.valueOf(r103)), TuplesKt.to("showGlobalRank", Boolean.valueOf(r102))}));
        return;
    }
}
