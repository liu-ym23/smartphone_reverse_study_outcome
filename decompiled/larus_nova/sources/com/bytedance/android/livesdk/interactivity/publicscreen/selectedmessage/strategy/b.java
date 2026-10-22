package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import io.reactivex.functions.Consumer;
import ju1.n;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f139454a;

    public b(a r100) {
        this.f139454a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a r101 = this.f139454a;
        int r102 = q.f133648a;
        e r103 = q.h(r101.f139452g, ((n) r100).b(r101.f139448c), this.f139454a.f139449d);
        r101.f139451f = r103;
        int r104 = ga2.d.f480547a;
        ga2.d.c(r103.f133484a, r103.f133485b, r103.f133487d);
        a.InterfaceC2205a r105 = r101.f139453h;
        e r106 = r101.f139451f;
        r105.update(r106.f133487d, r106.f133484a);
    }
}
