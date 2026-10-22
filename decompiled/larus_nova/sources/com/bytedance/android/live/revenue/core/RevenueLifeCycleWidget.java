package com.bytedance.android.live.revenue.core;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.revenue.platform.container.impl.core.NativeHostServiceImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/core/RevenueLifeCycleWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueLifeCycleWidget extends LiveRecyclableWidget {
    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onClear() {
        super.onClear();
        ((NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class)).I();
    }

    public RevenueLifeCycleWidget() {
    }
}
