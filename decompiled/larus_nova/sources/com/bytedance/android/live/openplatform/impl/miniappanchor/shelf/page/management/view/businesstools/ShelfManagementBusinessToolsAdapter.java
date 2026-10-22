package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import bq0.a;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.CouponItemViewHolder;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.PrivateMsgItemViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/ShelfManagementBusinessToolsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementBusinessToolsAdapter extends RecyclerView.Adapter<BaseBusinessToolItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends a> f84697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseBusinessToolItemViewHolder.a f84698b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84697a.size();
    }

    public ShelfManagementBusinessToolsAdapter(BaseBusinessToolItemViewHolder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "businessToolItemListener");
        this.f84698b = r100;
        this.f84697a = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((a) ListProtector.get(this.f84697a, r100)).b().ordinal();
    }

    public final void y2(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        HashSet r101 = new HashSet();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (r101.add(((a) r104).b()) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        this.f84697a = r102;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseBusinessToolItemViewHolder r102 = (BaseBusinessToolItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        r102.T3((a) ListProtector.get(this.f84697a, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_mini_app_business_tool_item, r100, false);
        if (r101 != BusinessToolType.Coupon.ordinal()) goto L6;
        return new CouponItemViewHolder(r102, this.f84698b);
    L6:
        if (r101 != BusinessToolType.PrivateMsg.ordinal()) goto L9;
        return new PrivateMsgItemViewHolder(r102, this.f84698b);
    L9:
        return new BaseBusinessToolItemViewHolder(r102, this.f84698b);
    }
}
