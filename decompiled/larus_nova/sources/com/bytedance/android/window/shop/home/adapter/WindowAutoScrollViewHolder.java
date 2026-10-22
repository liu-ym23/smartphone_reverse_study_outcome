package com.bytedance.android.window.shop.home.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/home/adapter/WindowAutoScrollViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAutoScrollViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f188179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f188180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f188181c;

    public WindowAutoScrollViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f188181c = r100;
        this.f188179a = (TextView) r100.findViewById(R.id.ec_window_impression_text);
        this.f188180b = (TextView) r100.findViewById(R.id.ec_window_impression_amount);
    }
}
