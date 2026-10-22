package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.interactivity.api.IDiggService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class n extends j70.n<e0> {
    @Override // j70.o
    public final boolean h() {
        return true;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ((IDiggService) jc1.k.n(IDiggService.class)).getDiggWidgetClass();
    }

    public n() {
    }

    @Override // j70.h
    public final f70.b L() {
        return mg2.e.f513712e;
    }

    @Override // j70.d
    public /* bridge */ /* synthetic */ boolean B(h70.b r100) {
        return N((e0) r100);
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.V0;
    }

    @Override // j70.d
    public /* bridge */ /* synthetic */ LayerIndex E(h70.b r100) {
        return O((e0) r100);
    }

    @Override // j70.h
    public final double H(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return 1.1d;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        ElementConstraint r102 = ElementConstraint.f65822n;
        ElementConstraint r103 = ElementConstraint.b.a();
        if (ev1.p.c(r101.f467480h) == false) goto L5;
        ElementConstraint.Side r104 = ElementConstraint.Side.BOTTOM;
        r103.d(r104, r104, 16.0f);
    L5:
        return r103;
    }

    public boolean N(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return d90.c.i(r100);
    }

    public LayerIndex O(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return LayerIndex.INDEX_3;
    }
}
