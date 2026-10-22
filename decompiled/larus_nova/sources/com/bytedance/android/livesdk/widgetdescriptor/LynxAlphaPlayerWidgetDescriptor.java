package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LynxAlphaPlayerWidgetDescriptor extends j70.n<e0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f162280c;

    @Override // j70.o
    public final boolean h() {
        return true;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        Class<? extends Widget> r100 = (Class) this.f162280c.getValue();
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public LynxAlphaPlayerWidgetDescriptor() {
        this.f162280c = LazyKt.lazy(LynxAlphaPlayerWidgetDescriptor$widgetCls$2.INSTANCE);
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        if (((Class) this.f162280c.getValue()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.E3;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_4;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        ElementConstraint r101 = ElementConstraint.f65822n;
        return ElementConstraint.b.a();
    }
}
