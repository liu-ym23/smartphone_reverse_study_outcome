package com.bytedance.android.live.profit.livepet.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends j70.n<d90.d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f87844c = null;

    @Override // j70.o
    public final boolean h() {
        return true;
    }

    static {
        f87844c = new d();
    }

    public d() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return LivePetContainerWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        d90.d r101 = (d90.d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        return d90.f.a(r101);
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        d90.d r101 = (d90.d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467596w2;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((d90.d) r100, "layerContext");
        return LayerIndex.INDEX_3;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        Intrinsics.checkNotNullParameter((d90.d) r100, "layerContext");
        ElementConstraint r101 = ElementConstraint.f65822n;
        return ElementConstraint.b.a();
    }
}
