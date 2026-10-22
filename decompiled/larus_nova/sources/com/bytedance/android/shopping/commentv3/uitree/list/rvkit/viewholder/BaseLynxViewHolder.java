package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.view.CommentLynxView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseLynxViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseLynxViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f172849c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentLynxView f172850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f172851b;

    public static final class a {
    }

    static {
    }

    public BaseLynxViewHolder(View r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f172851b = r101;
        this.f172850a = (CommentLynxView) r100.findViewById(R.id.lynx_card_view);
    }
}
