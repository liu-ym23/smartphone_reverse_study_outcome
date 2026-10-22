package com.stepos.common.picker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ability.R;
import java.util.List;

/* loaded from: classes3.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public List f3591a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List list = this.f3591a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        List list = this.f3591a;
        if (list == null || i >= list.size() || !(viewHolder instanceof g)) {
            return;
        }
        ((g) viewHolder).f3590a.setText((CharSequence) list.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mc_wheel_picker_item, viewGroup, false));
    }
}
