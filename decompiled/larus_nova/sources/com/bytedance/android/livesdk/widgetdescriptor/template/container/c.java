package com.bytedance.android.livesdk.widgetdescriptor.template.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.widgetdescriptor.f0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends com.bytedance.android.livesdk.widgetdescriptor.template.container.base.c {
    @Override // j70.b
    public final int y() {
        return R.id.ttlive_template_portrait_container_20_10;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final j70.c P() {
        Map<String, j70.c> r100 = d90.b.f467451a;
        return d90.b.f467466p;
    }

    public c() {
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (f0.a(r101) == false) goto L6;
        return LayerIndex.INDEX_12;
    L6:
        return LayerIndex.INDEX_2;
    }

    @Override // j70.h
    public final double H(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return 2.1d;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final ElementConstraint O(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        ElementConstraint r101 = new ElementConstraint(-2.0f, -1.0f);
        ElementConstraint.Side r102 = ElementConstraint.Side.TOP;
        r101.d(r102, r102, 0.0f);
        ElementConstraint.Side r103 = ElementConstraint.Side.RIGHT;
        r101.d(r103, r103, 0.0f);
        return r101;
    }
}
