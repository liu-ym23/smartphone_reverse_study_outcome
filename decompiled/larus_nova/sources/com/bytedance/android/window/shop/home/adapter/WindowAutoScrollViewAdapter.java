package com.bytedance.android.window.shop.home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pp3.a;
import uq3.p;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/adapter/WindowAutoScrollViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/home/adapter/WindowAutoScrollViewHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAutoScrollViewAdapter extends RecyclerView.Adapter<WindowAutoScrollViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p> f188177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f188178b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f188177a).size();
    }

    public WindowAutoScrollViewAdapter() {
        this.f188177a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        WindowAutoScrollViewHolder r102 = (WindowAutoScrollViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (((ArrayList) this.f188177a).size() == 0) goto L10;
        p r103 = (p) ListProtector.get(this.f188177a, r101);
        Function1<? super String, Unit> r104 = this.f188178b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "vo");
        String r105 = r103.f551274a;
        if (r105 == null) goto L11;
        r102.f188179a.setText(r105);
        r102.f188180b.setText(r103.f551275b);
        int r106 = r102.f188181c.getResources().getColor(R.color.shopping_color_80FFFFFF);
        int r107 = r102.f188181c.getResources().getColor(R.color.shopping_color_26FFFFFF);
        r102.f188179a.setTextColor(r106);
        r102.f188180b.setTextColor(r106);
        ((TextView) r102.f188181c.findViewById(R.id.ec_window_impression_left)).setTextColor(r107);
        ((TextView) r102.f188181c.findViewById(R.id.ec_window_impression_right)).setTextColor(r107);
        r102.f188181c.setOnClickListener(new a(r104, r103));
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new WindowAutoScrollViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_window_info_impression_view, null));
    }
}
