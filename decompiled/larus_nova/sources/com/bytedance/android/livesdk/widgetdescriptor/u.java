package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.viewmodule.IllegalLoadingWidget;
import com.bytedance.android.livesdk.g4;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u extends j70.n<e0> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    public u() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return IllegalLoadingWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return !g4.f125381a.getValue().d();
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.C0;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_6;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return new ElementConstraint(-1.0f, -1.0f);
    }
}
