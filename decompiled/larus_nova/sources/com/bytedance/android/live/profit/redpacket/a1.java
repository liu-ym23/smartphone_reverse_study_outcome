package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y0 f88579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f88580b;

    public a1(y0 r100, e r101) {
        this.f88579a = r100;
        this.f88580b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        RedPacketState r101 = (RedPacketState) r100;
        if ((r101 instanceof RedPacketState.Waiting) == false) goto L6;
        this.f88579a.f88776c.a(new y0.a.e(this.f88580b));
        return;
    L6:
        if ((r101 instanceof RedPacketState.Available) == false) goto L8;
    L13:
        this.f88579a.f88776c.a(new y0.a.C1363a(this.f88580b));
        return;
    L8:
        if ((r101 instanceof RedPacketState.Rushing) == true) goto L13;
        if ((r101 instanceof RedPacketState.Empty) == false) goto L16;
        Function0<Unit> r102 = new RedPacketViewModel$updateState$2$observer$1(this);
        this.f88579a.f88776c.a(new y0.a.b(this.f88580b, r102));
        return;
    }
}
