package com.bytedance.android.livesdk.vscore_impl.paidlive.desc;

import com.bytedance.android.livesdk.vscore_impl.paidlive.widget.PaidPlayerTipServiceWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends i<d90.a> {
    public d() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return PaidPlayerTipServiceWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.I;
    }
}
