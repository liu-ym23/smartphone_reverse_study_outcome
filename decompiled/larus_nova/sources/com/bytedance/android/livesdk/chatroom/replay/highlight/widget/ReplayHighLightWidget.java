package com.bytedance.android.livesdk.chatroom.replay.highlight.widget;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundDraweeImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/highlight/widget/ReplayHighLightWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayHighLightWidget extends LiveRecyclableWidget implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f108764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f108765b;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_widget_seek_bar_highlight_pop;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        View r100 = this.contentView;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.i(r100);
        return;
    }

    public ReplayHighLightWidget() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View r101 = this.contentView;
        if (r101 == null) goto L5;
        r101.setOnClickListener(null);
    L5:
        View r102 = this.contentView;
        if (r102 == null) goto L9;
        UtilityKotlinExtentionsKt.i(r102);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f108764a = this.contentView.findViewById(R.id.high_light_background);
        this.f108765b = this.contentView.findViewById(R.id.high_light_arrow);
        LiveRoundDraweeImageView r101 = (LiveRoundDraweeImageView) this.contentView.findViewById(R.id.high_light_image);
        TextView r102 = (TextView) this.contentView.findViewById(R.id.high_light_text);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        View r101 = this.contentView;
        if (r101 == null) goto L6;
        UtilityKotlinExtentionsKt.i(r101);
        return;
    }
}
