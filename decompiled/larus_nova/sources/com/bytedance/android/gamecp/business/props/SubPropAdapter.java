package com.bytedance.android.gamecp.business.props;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/props/SubPropAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/gamecp/business/props/SubPropAdapter$VH;", "VH", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubPropAdapter extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<wt.l> f56339b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/props/SubPropAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VH extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HSImageView f56340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f56341b;

        public VH(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f56340a = (HSImageView) this.itemView.findViewById(R.id.iv_icon);
            this.f56341b = (TextView) this.itemView.findViewById(R.id.tv_name);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f56339b.size();
    }

    public SubPropAdapter(Context r100, List<wt.l> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mList");
        this.f56338a = r100;
        this.f56339b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        VH r102 = (VH) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        String r103 = ((wt.l) ListProtector.get(this.f56339b, r101)).icon;
        if (r103 != null) goto L5;
    L10:
        fu.j.a(r102.f56340a, R.drawable.gamecp_transparent);
    L11:
        r102.f56341b.setText(((wt.l) ListProtector.get(this.f56339b, r101)).name);
        return;
    L5:
        if (r103.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 != true) goto L10;
        fu.j.e(r102.f56340a, r103);
        goto L11
    L7:
        r104 = false;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new VH(LayoutInflater.from(this.f56338a).inflate(R.layout.gamecp_game_promote_prop_detail_sub_prop_item_v2, r100, false));
    }
}
