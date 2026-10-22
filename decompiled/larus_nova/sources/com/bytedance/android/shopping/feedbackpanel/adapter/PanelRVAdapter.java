package com.bytedance.android.shopping.feedbackpanel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feedbackpanel.viewholder.PanelRVVH;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import de3.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/adapter/PanelRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f176095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ce3.c f176096b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f176095a).size();
    }

    public PanelRVAdapter() {
        this.f176095a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r101 >= ((ArrayList) this.f176095a).size()) goto L10;
        if (r101 >= 0) goto L7;
        return;
    L7:
        if ((r100 instanceof PanelRVVH) == false) goto L11;
        ((PanelRVVH) r100).T3((c) ListProtector.get(this.f176095a, r101), this.f176096b);
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PanelRVVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_commerce_feedback_panel_item, r100, false));
    }
}
