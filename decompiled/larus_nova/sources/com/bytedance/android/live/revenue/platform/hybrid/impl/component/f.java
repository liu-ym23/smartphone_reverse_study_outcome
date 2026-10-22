package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import android.webkit.WebView;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends d<WebView> {
    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final HybridType o() {
        return HybridType.H5;
    }

    public f(BaseHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "originalComponent");
        super(r100);
    }
}
