package com.bytedance.android.ec.core.jedi;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/jedi/RecyclerViewWithFooterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f45104a;

    public static final class a {
    }

    static {
    }

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r100) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f45104a == false) goto L6;
        return getBasicItemCount() + 1;
    L6:
        return getBasicItemCount();
    }

    public RecyclerViewWithFooterAdapter() {
        this.f45104a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f45104a == false) goto L8;
        if (r100 != getBasicItemCount()) goto L8;
        return Integer.MIN_VALUE;
    L8:
        return getBasicItemViewType(r100);
    }

    public final void setShowFooter(boolean r100) {
        if (this.f45104a == r100) goto L9;
        this.f45104a = r100;
        if (r100 == false) goto L7;
        notifyItemInserted(getItemCount() - 1);
        return;
    L7:
        notifyItemRemoved(getItemCount());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (getItemViewType(r101) != Integer.MIN_VALUE) goto L5;
        onBindFooterViewHolder(r100);
        return;
    L5:
        onBindBasicViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (Integer.MIN_VALUE != r101) goto L6;
        return onCreateFooterViewHolder(r100);
    L6:
        return onCreateBasicViewHolder(r100, r101);
    }
}
