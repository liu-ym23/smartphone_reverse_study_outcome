package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import com.bytedance.android.gamecp.business.gamedetail.component.orderbutton.p;
import com.bytedance.ies.sve_core.o;
import com.bytedance.ies.sve_core.s;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBetaSignUpWidget f54129a;

    public i(NewBetaSignUpWidget r100) {
        this.f54129a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        p r101 = (p) r100;
        NewBetaSignUpWidget r102 = this.f54129a;
        int r103 = com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.j.f54012h;
        Pair<o<S>, Function1<s, Unit>> r104 = r102.Mq(com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.j.a.a(), null);
        o r105 = (o) r104.component1();
        Function1<s, Unit> r106 = r104.component2();
        com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.j r107 = (com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.j) r105.b();
        if (r107 == null) goto L7;
        r106.invoke(com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.j.c(r107, r101.f54880d, 123));
        return;
    }
}
