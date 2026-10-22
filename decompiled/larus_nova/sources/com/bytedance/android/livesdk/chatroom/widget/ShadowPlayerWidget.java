package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.view.LightView;
import com.bytedance.android.livesdk.config.qj1;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/ShadowPlayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShadowPlayerWidget extends LiveWidget {
    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_shadow_play_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        View r100 = this.contentView;
        if ((r100 instanceof LightView) == true) goto L5;
        r100 = null;
    L5:
        LightView r101 = (LightView) r100;
        if (r101 == null) goto L9;
        r101.setNeedDraw(qj1.f121062a.getValue().booleanValue());
        return;
    }

    public ShadowPlayerWidget() {
    }
}
