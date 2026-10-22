package com.bytedance.android.live.browser.webview.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/browser/webview/fragment/HybridDebugConsoleDialog$HybridDebugConsoleAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/browser/webview/fragment/HybridDebugConsoleDialog$HybridDebugConsoleViewHolder;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridDebugConsoleDialog$HybridDebugConsoleAdapter extends RecyclerView.Adapter<HybridDebugConsoleDialog$HybridDebugConsoleViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f64338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f64339b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f64339b).size();
    }

    public HybridDebugConsoleDialog$HybridDebugConsoleAdapter() {
        this.f64338a = -1;
        this.f64339b = new ArrayList();
        System.getProperty("line.separator");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        HybridDebugConsoleDialog$HybridDebugConsoleViewHolder r102 = (HybridDebugConsoleDialog$HybridDebugConsoleViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "p0");
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r102.f64341b.setText("UnKnown");
        TextView r103 = r102.f64341b;
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r102.f64341b.setVisibility(8);
        r103.setText("");
        TextView r104 = r102.f64341b;
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r104.setText(null);
        TextView r105 = r102.f64340a;
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r105.setText(null);
        TextView r106 = r102.f64342c;
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r106.setText(null);
        TextView r107 = r102.f64343d;
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r102.f64343d.setVisibility(8);
        r107.setText("");
        TextView r108 = r102.f64344e;
        ((j) ListProtector.get(this.f64339b, r101)).getClass();
        r102.f64344e.setVisibility(8);
        r108.setText("");
        if (r101 != this.f64338a) goto L5;
        r102.f64346g.setVisibility(0);
        return;
    L5:
        r102.f64346g.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        HybridDebugConsoleDialog$HybridDebugConsoleViewHolder r102 = new HybridDebugConsoleDialog$HybridDebugConsoleViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_hybrid_debug_console, r100, false));
        r102.f64345f.setOnClickListener(new k(this, r102));
        return r102;
    }
}
