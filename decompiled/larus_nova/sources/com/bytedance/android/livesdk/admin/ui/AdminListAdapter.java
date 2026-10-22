package com.bytedance.android.livesdk.admin.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.common.AbsViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import td1.d;

/* JADX INFO: loaded from: classes7.dex */
public class AdminListAdapter extends RecyclerView.Adapter<AbsViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f103093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f103094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f103095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f103096d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f103094b).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ((AbsViewHolder) r100).T3((d) ListProtector.get(this.f103094b, r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
        View r101 = LayoutInflater.from(this.f103093a).inflate(R.layout.ttlive_item_banned_list, r100, false);
        return new AdminListViewHolder(this.f103093a, r101, this.f103095c, this.f103096d);
    }

    public AdminListAdapter(Context r100, String r101, long r102) {
        this.f103094b = new ArrayList();
        this.f103093a = r100;
        this.f103095c = r101;
        this.f103096d = r102;
    }
}
