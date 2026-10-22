package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    @Override // j70.o
    public final Class<? extends Widget> c() {
        IBarrageService r100 = (IBarrageService) jc1.k.f(IBarrageService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.provideCarnivalManagerWidget();
    }

    public i() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r101 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467582t3;
    }
}
