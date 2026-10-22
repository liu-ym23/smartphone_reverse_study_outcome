package com.bytedance.android.live.profit.format.voicechat.view;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;
import nu0.j;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OperationTipView f87786a;

    public d(OperationTipView r100) {
        this.f87786a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        j.d(this.f87786a, "thinking 超时展示 ui", null);
        OperationTipView r102 = this.f87786a;
        r102.e(r102.f87726g, OperationTipView.a(r102), CollectionsKt.listOf(OperationTipView.b(this.f87786a)));
    }
}
