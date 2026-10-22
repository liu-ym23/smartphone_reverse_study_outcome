package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvControlAreaWidget f145777a;

    public b0(KtvMvControlAreaWidget r100) {
        this.f145777a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        KtvMvControlAreaWidget r101 = this.f145777a;
        boolean r102 = Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
        int r103 = KtvMvControlAreaWidget.f145608s;
        r101.Cq(r102);
    }
}
