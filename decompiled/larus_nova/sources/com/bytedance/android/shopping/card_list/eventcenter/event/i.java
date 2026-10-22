package com.bytedance.android.shopping.card_list.eventcenter.event;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f171614a;

    public i(Function1 r100) {
        this.f171614a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Function1 r100 = this.f171614a;
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r100.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
