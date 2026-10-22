package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.livecommerce.paging.ECPagedListAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionItemDiffCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/RecyclerViewWithHeaderAndFooterAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/bytedance/android/livesdk/livecommerce/paging/ECPagedListAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RecyclerViewWithHeaderAndFooterAdapter<T, VH extends RecyclerView.ViewHolder> extends ECPagedListAdapter<T, VH> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f150886d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f150887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f150888c;

    public static final class a {
    }

    static {
    }

    public void A2(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public void onBindFooterViewHolder(VH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    public abstract VH onCreateBasicViewHolder(ViewGroup r100, int r101);

    public VH onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return null;
    }

    public VH onCreateHeaderViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return null;
    }

    public abstract void z2(VH r100, int r101, List<Object> r102);

    @Override // androidx.paging.PagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = super.getItemCount();
        if (this.f150888c == false) goto L6;
        r100 = r100 + 1;
    L6:
        if (this.f150887b == true) goto L8;
        return r100;
    L8:
        return r100 + 1;
    }

    public RecyclerViewWithHeaderAndFooterAdapter(LivePromotionItemDiffCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "diffCallback");
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f150888c == false) goto L7;
        if (r100 != 0) goto L7;
        return Integer.MIN_VALUE;
    L7:
        if (this.f150887b == true) goto L9;
    L11:
        return 0;
    L9:
        if (r100 < (getItemCount() - 1)) goto L11;
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
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
        if (r103 == true) goto L11;
        r100.getLayoutPosition();
    L12:
        ViewGroup.LayoutParams r104 = r100.itemView.getLayoutParams();
        if ((r104 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L15;
        r104 = null;
    L15:
        StaggeredGridLayoutManager.LayoutParams r105 = (StaggeredGridLayoutManager.LayoutParams) r104;
        if (r105 == null) goto L19;
        r105.setFullSpan(r102);
        return;
    L19:
        return;
    L11:
        r102 = true;
        goto L12
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
        A2(r100);
        return;
    L5:
        if (r102 == Integer.MAX_VALUE) goto L7;
        z2(r100, r101 - (this.f150888c ? 1 : 0), null);
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
        VH r102 = (VH) onCreateHeaderViewHolder(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        if (r101 != Integer.MAX_VALUE) goto L10;
        VH r103 = (VH) onCreateFooterViewHolder(r100);
        Intrinsics.checkNotNull(r103);
        return r103;
    L10:
        return (VH) onCreateBasicViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        int r103 = getItemViewType(r101);
        if (r103 != Integer.MIN_VALUE) goto L5;
        A2(r100);
        return;
    L5:
        if (r103 == Integer.MAX_VALUE) goto L7;
        z2(r100, r101 - (this.f150888c ? 1 : 0), r102);
        return;
    L7:
        View r104 = r100.itemView;
        if (super.getItemCount() <= 0) goto L10;
        int r105 = 0;
    L11:
        r104.setVisibility(r105);
        onBindFooterViewHolder(r100);
        return;
    L10:
        r105 = 8;
        goto L11
    }
}
