package com.bytedance.android.livesdk.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import td1.f;

/* JADX INFO: loaded from: classes7.dex */
public class MenuAdapter extends RecyclerView.Adapter<a> {

    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f103071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f103072b;

        public a(View r100) {
            super(r100);
            TextView r101 = (TextView) r100.findViewById(R.id.menu_tx);
            this.f103071a = r101;
            r101.setOnClickListener(new com.bytedance.android.livesdk.admin.a(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((f) ListProtector.get(null, r100)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
        f r103 = (f) ListProtector.get(null, r101);
        r102.f103072b = r103;
        TextView r104 = r102.f103071a;
        r103.getClass();
        r104.setText(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        View r102 = LayoutInflater.from(null).inflate(R.layout.ttlive_item_menu, r100, false);
        if (r101 != 0) goto L5;
        r102.setBackgroundResource(R.drawable.ttlive_bg_menu_normal);
    L16:
        return new a(r102);
    L5:
        if (r101 != 1) goto L7;
        r102.setBackgroundResource(R.drawable.ttlive_bg_menu_normal_top);
        goto L16
    L7:
        if (r101 != 2) goto L9;
        r102.setBackgroundResource(R.drawable.ttlive_bg_menu_normal_bottom);
        goto L16
    L9:
        if (r101 == 3) goto L11;
        r102.setBackgroundResource(R.drawable.ttlive_bg_menu_normal);
        goto L16
    L11:
        r102.setBackgroundResource(R.drawable.ttlive_bg_menu_cancel);
        goto L16
    }
}
