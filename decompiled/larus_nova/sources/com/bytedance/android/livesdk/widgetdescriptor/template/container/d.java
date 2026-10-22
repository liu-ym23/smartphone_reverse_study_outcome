package com.bytedance.android.livesdk.widgetdescriptor.template.container;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdk.widgetdescriptor.f0;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends com.bytedance.android.livesdk.widgetdescriptor.template.container.base.c implements ru2.a<e0> {
    @Override // j70.b
    public final int y() {
        return R.id.ttlive_template_portrait_container_20_1;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final j70.c P() {
        Map<String, j70.c> r100 = d90.b.f467451a;
        return d90.b.f467465o;
    }

    public d() {
    }

    @Override // j70.h
    public final f70.b L() {
        return mg2.e.f513710c;
    }

    @Override // s70.b
    public final boolean A(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        return f0.a(r101);
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_2;
    }

    @Override // j70.h
    public final double F(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return 0.1d;
    }

    @Override // j70.h
    public final double H(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return 0.2d;
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.template.container.base.a
    public final ElementConstraint O(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        ElementConstraint r101 = ElementConstraint.f65822n;
        return ElementConstraint.b.a();
    }

    @Override // ru2.a
    public final MultiTabType x(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return MultiTabType.PUBLIC_INTERACT_TAB;
    }
}
