package com.bytedance.android.window.shop.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowRecyclerViewWithHeaderAndFooterAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowRecyclerViewWithHeaderAndFooterAdapterV2<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f189941b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f189942a;

    public static final class a {
    }

    static {
    }

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r100) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(VH r100, int r101);

    public void onBindFooterViewHolder(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public abstract VH onCreateBasicViewHolder(ViewGroup r100, int r101);

    public VH onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return null;
    }

    public boolean y2(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = getBasicItemCount();
        if (this.f189942a == true) goto L5;
        return r100;
    L5:
        return r100 + 1;
    }

    public WindowRecyclerViewWithHeaderAndFooterAdapterV2() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f189942a == false) goto L8;
        if (r100 < (getItemCount() - 1)) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return getBasicItemViewType(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        final RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        ((GridLayoutManager) r101).setSpanSizeLookup(new AnonymousClass1(this, r101));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        int r101 = getItemViewType(r100.getLayoutPosition());
        boolean r102 = false;
        if (r101 != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r100.getLayoutPosition();
        if (y2(r100) == true) goto L12;
    L13:
        ViewGroup.LayoutParams r104 = r100.itemView.getLayoutParams();
        if ((r104 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L16;
        r104 = null;
    L16:
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
        if (r105 == null) goto L20;
        r105.setFullSpan(r102);
        return;
    L20:
        return;
    L12:
        r102 = true;
        goto L13
    L5:
        if (r101 == Integer.MAX_VALUE) goto L8;
        r103 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = getItemViewType(r101);
        if (r102 != Integer.MIN_VALUE) goto L5;
        Intrinsics.checkNotNullParameter(r100, "holder");
        return;
    L5:
        if (r102 == Integer.MAX_VALUE) goto L7;
        onBindBasicViewHolder(r100, r101);
        return;
    L7:
        View r103 = r100.itemView;
        if (getBasicItemCount() <= 0) goto L10;
        int r104 = 0;
    L11:
        r103.setVisibility(r104);
        onBindFooterViewHolder(r100);
        return;
    L10:
        r104 = 8;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final VH onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != Integer.MIN_VALUE) goto L5;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNull(null);
        return null;
    L5:
        if (r101 != Integer.MAX_VALUE) goto L10;
        VH r102 = (VH) onCreateFooterViewHolder(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    L10:
        return (VH) onCreateBasicViewHolder(r100, r101);
    }
}
