package com.bytedance.android.shopping.feedbackpanel.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feedbackpanel.enums.WhereType;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import de3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/viewholder/PanelRVVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelRVVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f176100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f176101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f176102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f176103d;

    public PanelRVVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f176100a = (LinearLayout) r100.findViewById(R.id.feedback_item_container);
        this.f176101b = r100.findViewById(R.id.feedback_panel_item_line);
        this.f176102c = (ECDraweeView) r100.findViewById(R.id.feedback_panel_item_icon);
        this.f176103d = (TextView) r100.findViewById(R.id.feedback_panel_item_desc);
    }

    public final void T3(final c r110, final ce3.c r111) {
        Intrinsics.checkNotNullParameter(r110, "itemData");
        WhereType r100 = r110.f468061d;
        if (r100 == null) goto L18;
        int r101 = a.f176104a[r100.ordinal()];
        if (r101 != 1) goto L8;
        this.f176100a.setBackgroundResource(R.drawable.ec_commerce_bg_feedback_panel_item_top);
        this.f176101b.setVisibility(0);
        goto L18
    L8:
        if (r101 != 2) goto L10;
        this.f176100a.setBackgroundResource(R.drawable.ec_commerce_bg_feedback_panel_item_mid);
        this.f176101b.setVisibility(0);
        goto L18
    L10:
        if (r101 != 3) goto L12;
        this.f176100a.setBackgroundResource(R.drawable.ec_commerce_bg_feedback_panel_item_bottom);
        this.f176101b.setVisibility(8);
        goto L18
    L12:
        if (r101 != 4) goto L18;
        this.f176100a.setBackgroundResource(R.drawable.ec_commerce_bg_feedback_panel_item_only_one);
        this.f176101b.setVisibility(8);
    L18:
        ECDraweeView r102 = this.f176102c;
        ECUrlModel r103 = r110.f468059b;
        if (r103 == null) goto L21;
        String r104 = r103.getFirstUrl();
    L22:
        h0.e(r102, r104, new r("ec_goods_feed", "ec_goods_feed_default"), null, null, 120);
        this.f176103d.setText(r110.f468060c);
        f.c(this.itemView, null, null, new PanelRVVH$bind$1(r111, r110), 3);
        return;
    L21:
        r104 = null;
        goto L22
    }
}
