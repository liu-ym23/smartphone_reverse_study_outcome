package com.bytedance.android.livesdk.chatroom.replay.toolbar.descriptor;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends i<uq1.b> {
    @Override // j70.o
    public final Class<? extends Widget> c() {
        return r.B().getWidgetClass(7);
    }

    public h() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        if (r.B().getWidgetClass(7) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        uq1.b r101 = (uq1.b) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f551200d.getClass();
        return uq1.a.N;
    }
}
