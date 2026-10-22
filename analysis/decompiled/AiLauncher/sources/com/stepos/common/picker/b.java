package com.stepos.common.picker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import java.util.List;

/* loaded from: classes3.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mData;

    public static class a extends RecyclerView.ViewHolder {
        private final TextView textView;

        public a(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R$id.item_text);
        }
    }

    public b(List<String> list) {
        this.mData = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mc_wheel_picker_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.mData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        List<String> list = this.mData;
        if (list == null || i10 >= list.size() || !(viewHolder instanceof a)) {
            return;
        }
        ((a) viewHolder).textView.setText(this.mData.get(i10));
    }
}
