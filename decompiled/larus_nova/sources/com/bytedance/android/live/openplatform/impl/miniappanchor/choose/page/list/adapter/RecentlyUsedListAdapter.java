package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.GroupListItemViewHolder1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import fp0.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/adapter/RecentlyUsedListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/GroupListItemViewHolder1;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecentlyUsedListAdapter extends RecyclerView.Adapter<GroupListItemViewHolder1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MiniAppEntranceCell> f84191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<MiniAppEntranceCell, Integer, Unit> f84192b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84191a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecentlyUsedListAdapter(List<MiniAppEntranceCell> r100, Function2<? super MiniAppEntranceCell, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "recentlyUsedList");
        Intrinsics.checkNotNullParameter(r101, "clickCallback");
        this.f84191a = r100;
        this.f84192b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        GroupListItemViewHolder1 r112 = (GroupListItemViewHolder1) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        MiniAppEntranceCell r100 = (MiniAppEntranceCell) ListProtector.get(this.f84191a, r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        b.a(r112.f84145b, r112.f84144a, r112.f84148e, r112.f84146c, r112.f84147d, r112.f84149f, r112.f84150g, r100, r111);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new GroupListItemViewHolder1(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_mini_app_choose_list_group_list_item1, r100, false), this.f84192b);
    }
}
