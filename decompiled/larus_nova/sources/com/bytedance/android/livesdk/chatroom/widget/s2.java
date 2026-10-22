package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s2 extends j70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public s2() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return VisibilityRangeServiceWidget.class;
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
        return d90.d.a.f467569r0;
    }
}
