package com.bytedance.android.live.draggablecomponent;

import com.bytedance.android.livesdk.config.yo;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends j70.i<d90.a> {
    public c() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return DraggableComponentServiceWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        int r101 = d.f66660a;
        return Intrinsics.areEqual(yo.f121704a.getValue().a(), Boolean.TRUE);
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.X1;
    }
}
