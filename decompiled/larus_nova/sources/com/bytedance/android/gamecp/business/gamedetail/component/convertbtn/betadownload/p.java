package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBetaDownloadPCWidget f54036a;

    public p(NewBetaDownloadPCWidget r100) {
        this.f54036a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.p r101 = (com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.p) r100;
        NewBetaDownloadPCWidget r102 = this.f54036a;
        int r103 = i.f54007e;
        Pair<com.bytedance.ies.sve_core.o<S>, Function1<com.bytedance.ies.sve_core.s, Unit>> r104 = r102.Mq(i.a.a(), null);
        com.bytedance.ies.sve_core.o r105 = (com.bytedance.ies.sve_core.o) r104.component1();
        Function1<com.bytedance.ies.sve_core.s, Unit> r106 = r104.component2();
        i r107 = (i) r105.b();
        if (r107 == null) goto L7;
        r106.invoke(i.c(r107, null, r101.f54880d, false, 11));
        return;
    }
}
