package com.bytedance.android.shopping.anchorv3.comment.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.anchorv3.comment.widget.CommentItemVideoViewNew;
import com.bytedance.android.shopping.anchorv3.comment.widget.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/viewholder/CommentItemVideoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemVideoVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f164561a;

    public CommentItemVideoVH(CommentItemVideoViewNew r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        super(r100.getView());
        this.f164561a = r100;
    }
}
