package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.d;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "ActualLoadMoreViewHolder", "EmptyLoadMoreViewHolder", "LoadMoreViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadLoadMoreAdapter extends RecyclerView.Adapter<LoadMoreViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f168787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScrollMoreText f168788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f168789c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$ActualLoadMoreViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActualLoadMoreViewHolder extends LoadMoreViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f168790a;

        public ActualLoadMoreViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "loadMoreView");
            super(r100);
            this.f168790a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$EmptyLoadMoreViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyLoadMoreViewHolder extends LoadMoreViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f168791a;

        public EmptyLoadMoreViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "headViewHolder");
            super(r100);
            this.f168791a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/more/AnchorV4HeadLoadMoreAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public LoadMoreViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        LoadMoreViewHolder r102 = (LoadMoreViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if ((r102 instanceof ActualLoadMoreViewHolder) == false) goto L36;
        Action r103 = this.f168788b.getAction();
        if (r103 == null) goto L7;
        String r104 = r103.getId();
    L9:
        if (r104 == null) goto L30;
        int r105 = r104.hashCode();
        if (r105 == (-1644511110)) goto L24;
        if (r105 != (-1449688354)) goto L30;
        if (r104.equals("action_head_view_open_store_page") == false) goto L30;
        d r106 = this.f168789c;
        if (r106 == null) goto L37;
        c63.d r107 = r106.t();
        if (r107 == null) goto L38;
        r107.C();
        return;
    L38:
        return;
    L37:
        return;
    L24:
        if (r104.equals("action_find_same_goods") == false) goto L30;
        d r108 = this.f168789c;
        if (r108 == null) goto L40;
        c63.d r109 = r108.t();
        if (r109 == null) goto L41;
        r109.G(2, null, this.f168788b.getFindSameType());
        return;
    L41:
        return;
    L40:
        return;
    L30:
        d r110 = this.f168789c;
        if (r110 == null) goto L43;
        c63.d r111 = r110.t();
        if (r111 == null) goto L44;
        r111.G(2, null, this.f168788b.getFindSameType());
        return;
    L44:
        return;
    L43:
        return;
    L7:
        r104 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ECUrlModel r102 = null;
        ViewParent r103 = null;
        if (r101 != 0) goto L14;
        View r104 = th.a.d(r100.getContext(), R.layout.ec_commerce_anchor_v4_empty_holder_layout, r100, 4);
        if (this.f168787a.getParent() == null) goto L13;
        ViewParent r105 = this.f168787a.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L10;
        r103 = r105;
    L10:
        ViewGroup r106 = (ViewGroup) r103;
        if (r106 == null) goto L13;
        r106.removeView(this.f168787a);
    L13:
        ((ViewGroup) r104.findViewById(R.id.holder)).addView(this.f168787a);
        Unit r107 = Unit.INSTANCE;
        return new EmptyLoadMoreViewHolder(r104);
    L14:
        View r108 = th.a.d(r100.getContext(), R.layout.ec_commerce_anchor_v4_head_load_more_layout, r100, 4);
        View r109 = (View) CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(r108));
        if (r109 == null) goto L50;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        int r111 = -2;
        if (r110 == null) goto L26;
        ImageModel r112 = this.f168788b.getIcon();
        if (r112 == null) goto L24;
        ECUrlModel r113 = r112.getRemote();
        if (r113 == null) goto L24;
        int r114 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r113.getWidth()));
    L25:
        r110.width = r114;
    L24:
        r114 = -2;
    L26:
        ViewGroup.LayoutParams r115 = r109.getLayoutParams();
        if (r115 == null) goto L35;
        ImageModel r116 = this.f168788b.getIcon();
        if (r116 == null) goto L33;
        ECUrlModel r117 = r116.getRemote();
        if (r117 == null) goto L33;
        int r118 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r117.getHeight()));
    L34:
        r115.height = r118;
    L33:
        r118 = -2;
    L35:
        ImageModel r119 = this.f168788b.getIcon();
        if (r119 == null) goto L38;
        r102 = r119.getRemote();
    L38:
        ImageModel r120 = this.f168788b.getIcon();
        if (r120 == null) goto L43;
        ECUrlModel r121 = r120.getRemote();
        if (r121 == null) goto L43;
        int r122 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r121.getWidth()));
    L44:
        ImageModel r123 = this.f168788b.getIcon();
        if (r123 == null) goto L49;
        ECUrlModel r124 = r123.getRemote();
        if (r124 == null) goto L49;
        r111 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r124.getHeight()));
    L49:
        y.l(r102, r122, r111, new b(r108, r109));
    L43:
        r122 = -2;
    L50:
        Unit r125 = Unit.INSTANCE;
        return new ActualLoadMoreViewHolder(r108);
    }

    public AnchorV4HeadLoadMoreAdapter(View r100, ScrollMoreText r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "headView");
        Intrinsics.checkNotNullParameter(r101, "scrollMoreText");
        this.f168787a = r100;
        this.f168788b = r101;
        this.f168789c = r102;
    }
}
