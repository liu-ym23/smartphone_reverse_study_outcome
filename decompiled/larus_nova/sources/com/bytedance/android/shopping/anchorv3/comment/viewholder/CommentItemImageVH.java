package com.bytedance.android.shopping.anchorv3.comment.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.ui.base.widget.round.RoundFrameLayout;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zb3.e;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/viewholder/CommentItemImageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentItemImageVH extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteRoundImageView f164555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f164556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f164557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f164558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoundFrameLayout f164559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f164560f;

    public CommentItemImageVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f164555a = (RemoteRoundImageView) this.itemView.findViewById(R.id.comment_sv_image);
        this.f164557c = -1;
        this.f164559e = (RoundFrameLayout) this.itemView.findViewById(R.id.comment_image_tag_container);
        this.f164560f = (TextView) this.itemView.findViewById(R.id.comment_image_tag);
    }
}
