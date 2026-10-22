package com.bytedance.android.livesdk.castscreen.views;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/AbsCastScreenWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsCastScreenWidget extends LiveRecyclableWidget {
    public final boolean wq() {
        return qf1.a.a(this.dataCenter);
    }

    public final boolean xq() {
        return qf1.a.b(this.dataCenter);
    }

    public AbsCastScreenWidget() {
    }

    public final void yq(boolean r100) {
        qf1.a.c(this.dataCenter, r100);
    }
}
