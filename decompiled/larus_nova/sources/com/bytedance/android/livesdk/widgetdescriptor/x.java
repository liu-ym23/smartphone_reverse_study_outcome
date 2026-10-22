package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class x extends n {
    public x() {
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.n, j70.d
    public final /* bridge */ /* synthetic */ boolean B(h70.b r100) {
        return N((e0) r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.n, j70.d
    public final /* bridge */ /* synthetic */ LayerIndex E(h70.b r100) {
        return O((e0) r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.n
    public final boolean N(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return d90.c.f(r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.n
    public final LayerIndex O(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        return LayerIndex.INDEX_1;
    }
}
