package com.bytedance.android.ec.window.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.window.shop.search.recyclerview.WindowSearchResultAdapter$Companion$diffCallback$1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/window/base/adapter/WindowRecyclerViewWithHeaderAndFooterAdapterV1;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/PagedListAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowRecyclerViewWithHeaderAndFooterAdapterV1<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<T, VH> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f49102b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f49103a;

    public static final class a {
    }

    static {
    }

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

    public boolean y2(int r100) {
        return false;
    }

    @Override // androidx.paging.PagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = super.getItemCount();
        if (this.f49103a == true) goto L5;
        return r100;
    L5:
        return r100 + 1;
    }

    public WindowRecyclerViewWithHeaderAndFooterAdapterV1(WindowSearchResultAdapter$Companion$diffCallback$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "diffCallback");
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f49103a == false) goto L8;
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
    public void onViewAttachedToWindow(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        int r101 = getItemViewType(r100.getLayoutPosition());
        boolean r102 = false;
        if (r101 != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L12:
        r102 = true;
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
    L11:
        if (y2(r100.getLayoutPosition()) == false) goto L13;
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
        if (super.getItemCount() <= 0) goto L10;
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
