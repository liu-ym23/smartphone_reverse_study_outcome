package com.stepos.common.picker;

import H1.h;
import H1.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f13670a;

    static class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f13671a;

        public a(View view) {
            super(view);
            this.f13671a = (TextView) view.findViewById(h.f2283x);
        }
    }

    public b(List<String> list) {
        this.f13670a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f13670a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(i.f2319j, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        List<String> list = this.f13670a;
        if (list == null || i5 >= list.size() || !(viewHolder instanceof a)) {
            return;
        }
        ((a) viewHolder).f13671a.setText(this.f13670a.get(i5));
    }
}
