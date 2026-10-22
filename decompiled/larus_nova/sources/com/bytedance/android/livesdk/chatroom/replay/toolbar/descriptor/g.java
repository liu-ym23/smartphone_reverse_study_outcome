package com.bytedance.android.livesdk.chatroom.replay.toolbar.descriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mq1.l;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends ReplayWidgetDescriptor<uq1.b> {
    @Override // j70.o
    public final boolean h() {
        return false;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        l r100 = (l) pm1.h.f529822d.c(l.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    public g() {
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        return uq1.a.f551194u;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final boolean N(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        if (((Boolean) r101.invoke(1)).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r101.invoke(8)).booleanValue() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final ElementConstraint O(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        ElementConstraint r102 = new ElementConstraint(0.0f, 3);
        ElementConstraint.Side r103 = ElementConstraint.Side.TOP;
        r102.b(r103, uq1.a.f551193t, r103, 44.0f);
        ElementConstraint.Side r104 = ElementConstraint.Side.LEFT;
        r102.d(r104, r104, 0);
        return r102;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final LayerIndex P(h70.b r100, Function1 r101) {
        Intrinsics.checkNotNullParameter((uq1.b) r100, "layerContext");
        Intrinsics.checkNotNullParameter(r101, "isState");
        return LayerIndex.INDEX_5;
    }
}
