package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LandscapeVideoQualityViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeVideoQualityViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SwitchResolutionDialogConfig f112256a;

    public LandscapeVideoQualityViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f112256a = com.bytedance.android.livesdk.f3.f123401a.getValue();
    }

    public final void T3(l5 r100) {
        if (r100 == null) goto L8;
        c8 r101 = r100.f113663i;
        if (r101 == null) goto L8;
        boolean r102 = true;
        if (r101.f112664a != true) goto L8;
    L9:
        if (r102 == false) goto L11;
        int r103 = R.color.ttlive_color_FFCC8F;
    L12:
        int r104 = com.bytedance.android.live.core.utils.s1.h(r103);
        ((TextView) this.itemView.findViewById(R.id.quality_text)).setTextColor(r104);
        ((TextView) this.itemView.findViewById(R.id.p_text)).setTextColor(r104);
        ((TextView) this.itemView.findViewById(R.id.secondary_hint)).setTextColor(r104);
        View r105 = this.itemView;
        StringBuilder r106 = new StringBuilder("已选中 ");
        View r107 = this.itemView;
        View r108 = null;
        if (r107 == null) goto L15;
        View r109 = r107.findViewById(R.id.quality_text);
    L16:
        TextView r110 = (TextView) r109;
        CharSequence r111 = "";
        if (r110 == null) goto L20;
        CharSequence r112 = r110.getText();
        if (r112 == null) goto L20;
    L21:
        r106.append(r112);
        View r113 = this.itemView;
        if (r113 == null) goto L24;
        View r114 = r113.findViewById(R.id.p_text);
    L25:
        TextView r115 = (TextView) r114;
        if (r115 == null) goto L29;
        CharSequence r116 = r115.getText();
        if (r116 == null) goto L29;
    L30:
        r106.append(r116);
        View r117 = this.itemView;
        if (r117 == null) goto L33;
        r108 = r117.findViewById(R.id.secondary_hint);
    L33:
        TextView r118 = (TextView) r108;
        if (r118 == null) goto L39;
        CharSequence r119 = r118.getText();
        if (r119 == null) goto L39;
        r111 = r119;
    L39:
        r106.append(r111);
        r106.append("按钮");
        r105.setContentDescription(r106.toString());
        if (r102 == false) goto L42;
        int r120 = R.drawable.ttlive_bg_resolution_select_item_bg_select_paid;
    L43:
        this.itemView.setBackgroundResource(r120);
        return;
    L42:
        r120 = R.drawable.ttlive_bg_resolution_select_item_bg_select;
    L29:
        r116 = "";
        goto L30
    L24:
        r114 = null;
    L20:
        r112 = "";
        goto L21
    L15:
        r109 = null;
        goto L16
    L11:
        r103 = R.color.ttlive_white;
    L8:
        r102 = false;
        goto L9
    }
}
