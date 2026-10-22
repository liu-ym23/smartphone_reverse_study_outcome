package com.bytedance.android.livesdk.widgetdescriptor.template.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends com.bytedance.android.livesdk.widgetdescriptor.template.container.base.b {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widgetdescriptor.template.container.a$a, reason: collision with other inner class name */
    public static final class C2483a {
    }

    static {
    }

    @Override // j70.b
    public final int y() {
        return R.id.ttlive_template_landscape_container_20_10;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final j70.c P() {
        Map<String, j70.c> r100 = d90.b.f467451a;
        return d90.b.f467475y;
    }

    public a() {
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_4;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final ElementConstraint O(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        ElementConstraint r101 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r102 = ElementConstraint.Side.RIGHT;
        r101.d(r102, r102, 0.0f);
        ElementConstraint.Side r103 = ElementConstraint.Side.BOTTOM;
        r101.d(r103, r103, 0.0f);
        return r101;
    }
}
