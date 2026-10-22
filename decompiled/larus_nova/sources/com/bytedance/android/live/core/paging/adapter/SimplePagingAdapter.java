package com.bytedance.android.live.core.paging.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public abstract class SimplePagingAdapter<T> extends PagingAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, b90.a> f65073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f65074b;

    public SimplePagingAdapter(DiffUtil.ItemCallback<T> r100, Map<Integer, b90.a> r101) {
        super(r100);
        this.f65073a = r101;
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public int getNormalViewType(int r100, T r101) {
        return invalidateType();
    }

    @Override // com.bytedance.android.live.core.paging.adapter.PagingAdapter
    public final RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup r100, int r101) {
        b90.a r102 = this.f65073a.get(Integer.valueOf(r101));
        if (r102 != null) goto L7;
        return new InvalidItemViewHolder(r100);
    L7:
        return r102.a(r100, this.f65074b);
    }
}
