package com.bytedance.android.shopping.anchorv3.detail.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/GULFeedbackItemVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GULFeedbackItemVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f164814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f164816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f164817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f164818e;

    public GULFeedbackItemVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f164814a = (SimpleDraweeView) r100.findViewById(R.id.feedback_item_icon);
        this.f164815b = (TextView) r100.findViewById(R.id.feedback_item_text);
        this.f164816c = (TextView) r100.findViewById(R.id.feedback_item_more_text);
        this.f164817d = (TextView) r100.findViewById(R.id.feedback_item_sub_text);
        this.f164818e = (ImageView) r100.findViewById(R.id.feedback_item_more_arrow);
    }
}
