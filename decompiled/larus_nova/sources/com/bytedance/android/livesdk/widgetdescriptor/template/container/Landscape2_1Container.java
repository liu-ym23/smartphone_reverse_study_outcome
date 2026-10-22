package com.bytedance.android.livesdk.widgetdescriptor.template.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Landscape2_1Container extends com.bytedance.android.livesdk.widgetdescriptor.template.container.base.b {
    @Override // j70.b
    public final int y() {
        return R.id.ttlive_template_landscape_container_2_1;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final j70.c P() {
        Map<String, j70.c> r100 = d90.b.f467451a;
        return d90.b.f467469s;
    }

    public Landscape2_1Container() {
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_2;
    }

    @Override // j70.h
    public final double G(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (d90.c.p(r101) != 101) goto L5;
        return 0.1d;
    L5:
        super.G(r101);
        return 3.9d;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final ElementConstraint O(final e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return I(new Landscape2_1Container$generateContainerConstraint$1(r100));
    }
}
