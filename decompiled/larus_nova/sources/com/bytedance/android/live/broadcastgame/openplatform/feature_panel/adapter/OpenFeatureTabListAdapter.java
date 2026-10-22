package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f20.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/OpenFeatureTabListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/AbsOpenFeatureTabListItemViewHolder;", "", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabListAdapter extends RecyclerView.Adapter<AbsOpenFeatureTabListItemViewHolder<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f61375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<f10.f> f61376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f61377c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f61376b.size();
    }

    public final void setData(List<f10.f> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f61376b = r100;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AbsOpenFeatureTabListItemViewHolder r102 = (AbsOpenFeatureTabListItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        f r103 = this.f61375a;
        Object r104 = ListProtector.get(this.f61376b, r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r104, "data");
        r103.a(r104).d(r102, r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        f r102 = this.f61375a;
        Object r103 = ListProtector.get(this.f61376b, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r103, "data");
        return (AbsOpenFeatureTabListItemViewHolder) r102.a(r103).a(LayoutInflater.from(r100.getContext()), r100);
    }

    public OpenFeatureTabListAdapter(List<f10.f> r100, List<? extends f20.a<?, ?>> r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, IconList.ELEM_NAME);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f61376b = r100;
        this.f61377c = r102;
        this.f61375a = new f(r101);
    }
}
