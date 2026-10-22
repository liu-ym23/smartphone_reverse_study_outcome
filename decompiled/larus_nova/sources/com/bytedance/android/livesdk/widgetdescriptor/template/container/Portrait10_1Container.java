package com.bytedance.android.livesdk.widgetdescriptor.template.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Portrait10_1Container extends com.bytedance.android.livesdk.widgetdescriptor.template.container.base.c {
    @Override // j70.b
    public final int y() {
        return R.id.ttlive_template_portrait_container_10_1;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final j70.c P() {
        Map<String, j70.c> r100 = d90.b.f467451a;
        return d90.b.f467463m;
    }

    public Portrait10_1Container() {
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_10;
    }

    @Override // j70.h
    public final double H(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (jr1.b.c(r101) == false) goto L5;
        return 0.1d;
    L5:
        super.H(r101);
        return 3.9d;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final ElementConstraint O(final e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return I(new Portrait10_1Container$generateContainerConstraint$1(r100));
    }
}
