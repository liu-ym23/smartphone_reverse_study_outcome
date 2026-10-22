package com.bytedance.android.window.shop.home.presenter.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import uq3.e;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/bubble/WindowHeadBubbleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/home/presenter/bubble/WindowBubbleHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeadBubbleAdapter extends RecyclerView.Adapter<WindowBubbleHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f188501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f188502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super String, ? super String, Unit> f188503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function4<? super View, ? super e, ? super Integer, ? super Function0<Unit>, Unit> f188504d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f188501a).size();
    }

    public WindowHeadBubbleAdapter() {
        this.f188501a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        WindowBubbleHolder r102 = (WindowBubbleHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (((ArrayList) this.f188501a).size() == 0) goto L13;
        e r103 = (e) ListProtector.get(this.f188501a, r101);
        Function1<? super String, Unit> r104 = this.f188502b;
        Function2<? super String, ? super String, Unit> r105 = this.f188503c;
        Function4<? super View, ? super e, ? super Integer, ? super Function0<Unit>, Unit> r106 = this.f188504d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "vo");
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        int r107 = 3;
    L11:
        r102.f188500a.R5(r103, r104, r105, r106, r107);
        return;
    L9:
        r107 = 2;
        goto L11
    L10:
        r107 = 1;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_window_head_bubble_base, r100, false);
        if (r102 == null) goto L7;
        return new WindowBubbleHolder((WindowHeadBubbleBaseCard) r102);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowHeadBubbleBaseCard");
    }
}
