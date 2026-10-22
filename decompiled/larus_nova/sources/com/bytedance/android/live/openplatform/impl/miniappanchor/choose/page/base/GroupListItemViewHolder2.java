package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.larus.nova.R;
import fp0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/GroupListItemViewHolder2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupListItemViewHolder2 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f84151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f84152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f84153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f84154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f84155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f84156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f84157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<MiniAppEntranceCell, Integer, Unit> f84158h;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupListItemViewHolder2(View r100, Function2<? super MiniAppEntranceCell, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "clickCallback");
        super(r100);
        this.f84158h = r101;
        this.f84151a = (HSImageView) r100.findViewById(R.id.icon);
        this.f84152b = (TextView) r100.findViewById(R.id.name);
        this.f84153c = (TextView) r100.findViewById(R.id.desc);
        this.f84154d = r100.findViewById(R.id.doing_area);
        this.f84155e = r100.findViewById(R.id.bind_self_mount_area);
        this.f84156f = r100.findViewById(R.id.red_dot);
        this.f84157g = r100.findViewById(R.id.action_area);
    }

    public final void T3(MiniAppEntranceCell r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        TextView r100 = this.f84153c;
        if (r100 == null) goto L5;
        r100.setText(r110.desc);
    L5:
        b.a(this.f84152b, this.f84151a, this.f84156f, this.f84154d, this.f84155e, this.f84157g, this.f84158h, r110, r111);
    }
}
