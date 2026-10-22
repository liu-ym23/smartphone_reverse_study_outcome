package com.bytedance.android.live.recharge.exchange.service;

import android.content.DialogInterface;
import com.bytedance.android.live.recharge.order.Order;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.c f89908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Order.a f89909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f89910c;

    public d(b.c r100, com.bytedance.android.live.recharge.order.f.b.a r101, Ref.BooleanRef r102) {
        this.f89908a = r100;
        this.f89909b = r101;
        this.f89910c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        b.c.b(this.f89908a, this.f89909b.getOrder().f90097g, false, this.f89910c.element);
        r100.dismiss();
        this.f89909b.cancel(null);
    }
}
