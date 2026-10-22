package com.bytedance.android.livesdk.chatroom.replay.hdr;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/hdr/LandscapeVideoQualityViewHolder;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetItemViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeVideoQualityViewHolder extends ReplayActionSheet.ActionSheetItemViewHolder {
    public LandscapeVideoQualityViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public final void T3(d r100) {
        if (r100 == null) goto L6;
        boolean r101 = true;
        if (r100.f108745g != true) goto L6;
    L7:
        if (r101 == false) goto L9;
        int r102 = R.color.ttlive_replay_color_FFCC8F;
    L10:
        int r103 = s1.h(r102);
        ((TextView) this.itemView.findViewById(R.id.quality_text)).setTextColor(r103);
        ((TextView) this.itemView.findViewById(R.id.p_text)).setTextColor(r103);
        ((TextView) this.itemView.findViewById(R.id.secondary_hint)).setTextColor(r103);
        View r104 = this.itemView;
        StringBuilder r105 = new StringBuilder("已选中 ");
        View r106 = this.itemView;
        View r107 = null;
        if (r106 == null) goto L13;
        View r108 = r106.findViewById(R.id.quality_text);
    L14:
        TextView r109 = (TextView) r108;
        CharSequence r110 = "";
        if (r109 == null) goto L18;
        CharSequence r111 = r109.getText();
        if (r111 == null) goto L18;
    L19:
        r105.append(r111);
        View r112 = this.itemView;
        if (r112 == null) goto L22;
        r107 = r112.findViewById(R.id.p_text);
    L22:
        TextView r113 = (TextView) r107;
        if (r113 == null) goto L28;
        CharSequence r114 = r113.getText();
        if (r114 == null) goto L28;
        r110 = r114;
    L28:
        r105.append(r110);
        r105.append("按钮");
        r104.setContentDescription(r105.toString());
        if (r101 == false) goto L31;
        int r115 = R.drawable.ttlive_replay_bg_resolution_select_item_bg_select_paid;
    L32:
        this.itemView.setBackgroundResource(r115);
        return;
    L31:
        r115 = R.drawable.ttlive_replay_bg_resolution_select_item_bg_select;
    L18:
        r111 = "";
        goto L19
    L13:
        r108 = null;
        goto L14
    L9:
        r102 = R.color.ttlive_white;
    L6:
        r101 = false;
        goto L7
    }
}
