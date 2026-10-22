package com.bytedance.android.livesdk.chatroom.vs_base.widget;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import h70.b;
import j70.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ReplayWidgetDescriptor<T extends b> extends n<T> {
    public abstract boolean N(T r100, Function1<? super Integer, Boolean> r101);

    public abstract ElementConstraint O(T r100, Function1<? super Integer, Boolean> r101);

    public abstract LayerIndex P(T r100, Function1<? super Integer, Boolean> r101);

    public ReplayWidgetDescriptor() {
    }

    @Override // j70.d
    public final boolean B(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return N(r100, new ReplayWidgetDescriptor$canLoad$1(this));
    }

    @Override // j70.d
    public final LayerIndex E(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return P(r100, new ReplayWidgetDescriptor$layerIndex$1(this));
    }

    @Override // j70.h
    public final ElementConstraint J(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return O(r100, new ReplayWidgetDescriptor$generateConstraint$1(this));
    }
}
