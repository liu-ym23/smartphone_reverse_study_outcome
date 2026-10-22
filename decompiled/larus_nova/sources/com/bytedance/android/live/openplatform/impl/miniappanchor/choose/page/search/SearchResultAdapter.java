package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.GroupListItemViewHolder2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/SearchResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/GroupListItemViewHolder2;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchResultAdapter extends RecyclerView.Adapter<GroupListItemViewHolder2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MiniAppEntranceCell> f84272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<MiniAppEntranceCell, Integer, Unit> f84273b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84272a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchResultAdapter(List<MiniAppEntranceCell> r100, Function2<? super MiniAppEntranceCell, ? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "resultList");
        Intrinsics.checkNotNullParameter(r101, "clickCallback");
        this.f84272a = r100;
        this.f84273b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        GroupListItemViewHolder2 r102 = (GroupListItemViewHolder2) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.T3((MiniAppEntranceCell) ListProtector.get(this.f84272a, r101), r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new GroupListItemViewHolder2(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_mini_app_choose_list_group_list_item2, r100, false), this.f84273b);
    }
}
