package com.bytedance.android.livesdk.castscreen.descriptor;

import com.bytedance.android.livesdk.castscreen.views.CastDanmakuServiceWidget;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends i<e0> {
    public a() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return CastDanmakuServiceWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.d.c();
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467560p1;
    }
}
