package com.bytedance.android.livesdk.vscore_impl.paidlive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {
    public e() {
    }

    public final j70.h<? extends h70.b> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        switch(r100.hashCode()) {
            case -1399378345: goto L21;
            case -562225349: goto L18;
            case 48908846: goto L15;
            case 297620072: goto L12;
            case 1035599969: goto L9;
            case 2143172954: goto L6;
            default: goto L23;
        };
    L23:
        return null;
    L6:
        if (r100.equals("PaidPlayerTipServiceWidgetDescriptor") == false) goto L23;
        return new com.bytedance.android.livesdk.vscore_impl.paidlive.desc.d();
    L9:
        if (r100.equals("PaidConversionCardDescriptor") == false) goto L23;
        return new com.bytedance.android.livesdk.vscore_impl.paidlive.desc.a();
    L12:
        if (r100.equals("PaidScopeCheckServiceWidgetDescriptor") == false) goto L23;
        return new com.bytedance.android.livesdk.vscore_impl.paidlive.desc.e();
    L15:
        if (r100.equals("PaidLiveTicketSaleCardWidgetDescriptor") == false) goto L23;
        return new com.bytedance.android.livesdk.vscore_impl.paidlive.desc.c();
    L18:
        if (r100.equals("PaidLiveShareTicketTetrisDescriptor") == false) goto L23;
        return new com.bytedance.android.livesdk.vscore_impl.paidlive.desc.b();
    L21:
        if (r100.equals("PaidTetrisGestureWidgetDescriptor") == false) goto L23;
        return new com.bytedance.android.livesdk.vscore_impl.paidlive.desc.f();
    }
}
