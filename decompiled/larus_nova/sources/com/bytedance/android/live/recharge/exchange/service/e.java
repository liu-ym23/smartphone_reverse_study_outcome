package com.bytedance.android.live.recharge.exchange.service;

import android.content.DialogInterface;
import com.bytedance.android.live.recharge.order.Order;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.c f89911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Order.a f89912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f89913c;

    public e(b.c r100, com.bytedance.android.live.recharge.order.f.b.a r101, Ref.BooleanRef r102) {
        this.f89911a = r100;
        this.f89912b = r101;
        this.f89913c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        b.c.b(this.f89911a, this.f89912b.getOrder().f90097g, true, this.f89913c.element);
        r100.dismiss();
        this.f89912b.e(this.f89911a.f89906a.f89900a);
    }
}
