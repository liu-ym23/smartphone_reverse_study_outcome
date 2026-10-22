package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/UrlFormAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/annie/debug/ui/UrlFormViewHolder;", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class UrlFormAdapter extends RecyclerView.Adapter<UrlFormViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f39446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f39447b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f39446a.size();
    }

    public UrlFormAdapter(List<g> r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "paraList");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f39446a = r100;
        this.f39447b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        UrlFormViewHolder r102 = (UrlFormViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        g r103 = (g) ListProtector.get(this.f39446a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        TextView r104 = (TextView) r102.f39455b.getValue();
        if (r104 == null) goto L6;
        r104.setVisibility(0);
    L6:
        TextView r105 = (TextView) r102.f39455b.getValue();
        if (r105 == null) goto L10;
        r105.setText(r103.f39472c);
    L10:
        TextView r106 = (TextView) r102.f39456c.getValue();
        if (r106 == null) goto L14;
        r106.setVisibility(0);
    L14:
        TextView r107 = (TextView) r102.f39456c.getValue();
        if (r107 == null) goto L19;
        r107.setText(r103.f39473d);
    L19:
        if (r103.getType() != 1) goto L28;
        TextView r108 = (TextView) r102.f39457d.getValue();
        if (r108 == null) goto L24;
        r108.setVisibility(0);
    L24:
        TextView r109 = (TextView) r102.f39457d.getValue();
        if (r109 == null) goto L34;
        r109.setText("子字段(" + r103.f39472c + ")解析");
        return;
    L34:
        return;
    L28:
        TextView r110 = (TextView) r102.f39457d.getValue();
        if (r110 == null) goto L35;
        r110.setVisibility(8);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        UrlFormViewHolder r102 = new UrlFormViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.annie_debug_url_dialog_map_item, r100, false));
        r102.f39454a.setOnClickListener(new e(this, r102));
        TextView r103 = (TextView) r102.f39457d.getValue();
        if (r103 == null) goto L5;
        r103.setOnClickListener(new f(this, r102));
    L5:
        return r102;
    }
}
