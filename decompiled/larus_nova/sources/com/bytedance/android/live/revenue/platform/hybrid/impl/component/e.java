package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends d<LynxView> {
    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final HybridType o() {
        return HybridType.LYNX;
    }

    public e(BaseHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "originalComponent");
        super(r100);
    }
}
