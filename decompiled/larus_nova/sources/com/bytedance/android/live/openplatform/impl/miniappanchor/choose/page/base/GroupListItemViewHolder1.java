package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/GroupListItemViewHolder1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupListItemViewHolder1 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f84144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f84145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f84146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f84147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f84148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f84149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<MiniAppEntranceCell, Integer, Unit> f84150g;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupListItemViewHolder1(View r100, Function2<? super MiniAppEntranceCell, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "clickCallback");
        super(r100);
        this.f84150g = r101;
        this.f84144a = (HSImageView) r100.findViewById(R.id.icon);
        this.f84145b = (TextView) r100.findViewById(R.id.name);
        this.f84146c = r100.findViewById(R.id.doing_area);
        this.f84147d = r100.findViewById(R.id.bind_self_mount_area);
        this.f84148e = r100.findViewById(R.id.red_dot);
        this.f84149f = r100.findViewById(R.id.action_area);
    }
}
