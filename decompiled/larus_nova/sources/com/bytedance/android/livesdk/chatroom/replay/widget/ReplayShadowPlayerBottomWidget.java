package com.bytedance.android.livesdk.chatroom.replay.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.widget.k0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/widget/ReplayShadowPlayerBottomWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayShadowPlayerBottomWidget extends LiveRecyclableWidget {

    public static final class a implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayShadowPlayerBottomWidget f110349a;

        @Override // com.bytedance.android.livesdk.chatroom.widget.k0
        public final WidgetInfo a() {
            return this.f110349a.getWidgetInfo(ReplayShadowPlayerBottomWidget.class);
        }

        public a(ReplayShadowPlayerBottomWidget r100) {
            this.f110349a = r100;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_shadow_play_bottom_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public ReplayShadowPlayerBottomWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ReplayDataContext.a r101 = ReplayDataContext.Companion;
        DataCenter r102 = this.dataCenter;
        r101.getClass();
        ReplayDataContext r103 = ReplayDataContext.a.b(r102);
        if (r103 == null) goto L8;
        com.bytedance.live.datacontext.j<k0> r104 = r103.getReplayUISizeGetter();
        if (r104 == null) goto L9;
        r104.d(new a(this));
        return;
    L9:
        return;
    }
}
