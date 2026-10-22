package com.bytedance.android.livesdk.chatroom.replay.toolbar.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.ReplayPortraitBottomToolbarPresenter;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.t;
import mq1.v;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/widget/ReplayPortraitBottomToolbarWidget;", "Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/widget/ReplayABSToolbarWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayPortraitBottomToolbarWidget extends ReplayABSToolbarWidget {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f110183b;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        return R.layout.ttlive_replay_view_live_toolbar_protrait;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.widget.ReplayABSToolbarWidget
    public com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a wq() {
        View r100 = this.contentView;
        Context r101 = this.context;
        if (r101 == null) goto L7;
        return new ReplayPortraitBottomToolbarPresenter(r100, (FragmentActivity) r101, this, this.dataCenter);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public ReplayPortraitBottomToolbarWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.widget.ReplayABSToolbarWidget, com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r110) {
        super.onLoad(r110);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r111 = ReplayRoomFragmentScopeUtil.f117917a;
        ir1.a r112 = (ir1.a) ReplayRoomFragmentScopeUtil.a(ir1.a.class);
        ViewGroup r100 = this.containerView;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        v r113 = null;
        if (r112.l() == false) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r114 = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(PlayerViewControl.KEY.PortraitBottomToolBar, null, r100, PlayerViewControl.Type.ALPHA, PlayerViewControl.Style.HIDE, 0.0f, false, false, false);
    L6:
        if (r114 == null) goto L14;
        t r101 = s.e();
        if (r101 == null) goto L10;
        r113 = r101.provideVSPlayerViewControlService(this.dataCenter);
    L10:
        this.f110183b = r113;
        if (r113 == null) goto L15;
        r113.e(r114);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r114 = null;
        goto L6
    }
}
