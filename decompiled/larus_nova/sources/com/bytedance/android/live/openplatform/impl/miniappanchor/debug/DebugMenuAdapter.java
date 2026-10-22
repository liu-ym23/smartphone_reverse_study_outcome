package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/DebugMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/DebugMenuViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuAdapter extends RecyclerView.Adapter<DebugMenuViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f84342a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f84342a.size();
    }

    public DebugMenuAdapter(List<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f84342a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        DebugMenuViewHolder r102 = (DebugMenuViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        c r103 = (c) ListProtector.get(this.f84342a, r101);
        r102.f84347a.setText(r103.f84362a);
        View.OnClickListener r104 = r103.f84363b;
        if (r104 == null) goto L5;
        r102.itemView.setOnClickListener(r104);
    L5:
        r102.f84348b.setOnCheckedChangeListener(null);
        r102.f84348b.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new DebugMenuViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_open_game_debug_menu_item, r100, false));
    }
}
