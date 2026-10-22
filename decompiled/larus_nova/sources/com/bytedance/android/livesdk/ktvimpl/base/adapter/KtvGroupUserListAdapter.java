package com.bytedance.android.livesdk.ktvimpl.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.r;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.ktvimpl.base.viewholder.KtvGroupUserViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/adapter/KtvGroupUserListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewholder/KtvGroupUserViewHolder;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupUserListAdapter extends RecyclerView.Adapter<KtvGroupUserViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<r> f142397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f142398b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f142397a.size();
    }

    public KtvGroupUserListAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f142397a = new ArrayList();
        this.f142398b = LayoutInflater.from(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        KtvGroupUserViewHolder r102 = (KtvGroupUserViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "vh");
        r102.T3((r) ListProtector.get(this.f142397a, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return new KtvGroupUserViewHolder(this.f142398b.inflate(R.layout.ttlive_ktv_group_list_dialog_item, r100, false));
    }
}
