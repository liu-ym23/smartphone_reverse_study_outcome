package com.stepos.common.picker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public List f11375a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List list = this.f11375a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        List list = this.f11375a;
        if (list == null || i4 >= list.size() || !(viewHolder instanceof g)) {
            return;
        }
        ((g) viewHolder).f11374a.setText((CharSequence) list.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return new g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mc_wheel_picker_item, viewGroup, false));
    }
}
