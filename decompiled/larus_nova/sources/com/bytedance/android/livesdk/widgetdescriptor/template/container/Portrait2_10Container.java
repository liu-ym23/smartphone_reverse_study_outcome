package com.bytedance.android.livesdk.widgetdescriptor.template.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Portrait2_10Container extends com.bytedance.android.livesdk.widgetdescriptor.template.container.base.c {
    @Override // j70.b
    public final int y() {
        return R.id.ttlive_template_portrait_container_2_10;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final j70.c P() {
        Map<String, j70.c> r100 = d90.b.f467451a;
        return d90.b.f467457g;
    }

    public Portrait2_10Container() {
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_2;
    }

    @Override // j70.h
    public final double H(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return 1.1d;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final ElementConstraint O(final e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return I(new Portrait2_10Container$generateContainerConstraint$1(r100));
    }
}
