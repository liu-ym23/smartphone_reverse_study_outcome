package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBetaDownloadWidget f54066a;

    public w(NewBetaDownloadWidget r100) {
        this.f54066a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.p r101 = (com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.p) r100;
        NewBetaDownloadWidget r102 = this.f54066a;
        int r103 = j.f54012h;
        Pair<com.bytedance.ies.sve_core.o<S>, Function1<com.bytedance.ies.sve_core.s, Unit>> r104 = r102.Mq(j.a.a(), null);
        com.bytedance.ies.sve_core.o r105 = (com.bytedance.ies.sve_core.o) r104.component1();
        Function1<com.bytedance.ies.sve_core.s, Unit> r106 = r104.component2();
        j r107 = (j) r105.b();
        if (r107 == null) goto L7;
        r106.invoke(j.c(r107, r101.f54880d, 123));
        return;
    }
}
