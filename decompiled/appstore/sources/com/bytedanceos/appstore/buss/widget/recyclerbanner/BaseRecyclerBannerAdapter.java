package com.bytedanceos.appstore.buss.widget.recyclerbanner;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRecyclerBannerAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9304a;

    public BaseRecyclerBannerAdapter() {
        this(0);
    }

    public int a() {
        List<T> r10 = getData();
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.size();
    }

    public boolean b() {
        return this.f9304a;
    }

    public abstract void c(BaseViewHolder r10, int r11);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder r10, Object r11) {
    }

    public abstract BaseViewHolder d(ViewGroup r10, int r11);

    public void e(boolean r10) {
        this.f9304a = r10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int getDefItemCount() {
        if (this.f9304a == false) goto L6;
        return Channel.UNLIMITED;
    L6:
        return a();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((BaseViewHolder) r10, r11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    public BaseRecyclerBannerAdapter(int r10) {
        super(r10);
        this.f9304a = true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void onBindViewHolder(BaseViewHolder r10, int r11) {
        super.onBindViewHolder(r10, r11);
        List<T> r12 = getData();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.f9304a == false) goto L9;
        r11 = r11 % r12.size();
    L9:
        c(r10, r11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return d(r10, r11);
    }
}
