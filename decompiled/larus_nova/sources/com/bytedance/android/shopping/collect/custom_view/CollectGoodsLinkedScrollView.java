package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsLinkedScrollView;", "Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsTwoRevNestedScrollView;", "Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsGULView;", "getGul", "Landroidx/recyclerview/widget/RecyclerView;", "getRv", "Lcom/bytedance/android/shopping/collect/custom_view/LoadMoreFooterView;", "getLoadMoreFooterView", "Lkb3/b;", "collectCommonAbility", "", "setCommentAbility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectGoodsLinkedScrollView extends CollectGoodsTwoRevNestedScrollView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MaxHeightRecyclerView f172181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CollectGoodsGULView f172182n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LoadMoreFooterView f172183o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kb3.b f172184p;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CollectGoodsLinkedScrollView f172185a;

        public a(CollectGoodsLinkedScrollView r100) {
            this.f172185a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f172185a.f172181m.getMaxHeight() == this.f172185a.getHeight()) goto L7;
            CollectGoodsLinkedScrollView r100 = this.f172185a;
            r100.f172181m.setMaxHeight(r100.getHeight());
            return true;
        L7:
            return true;
        }
    }

    public static final class b {
    }

    static {
    }

    public CollectGoodsLinkedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CollectGoodsLinkedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
    }

    public final CollectGoodsGULView getGul() {
        return this.f172182n;
    }

    public final LoadMoreFooterView getLoadMoreFooterView() {
        return this.f172183o;
    }

    public final RecyclerView getRv() {
        return this.f172181m;
    }

    @Override // com.bytedance.android.shopping.collect.custom_view.CollectGoodsTwoRevNestedScrollView
    public final void g(int r100) {
        int[] r101 = new int[2];     // Catch: Throwable -> L12
        getLocationOnScreen(r101);     // Catch: Throwable -> L12
        int[] r102 = new int[2];     // Catch: Throwable -> L12
        boolean r103 = false;
        getChildAt(0).getLocationOnScreen(r102);     // Catch: Throwable -> L12
        MaxHeightRecyclerView r104 = this.f172181m;     // Catch: Throwable -> L12
        if (r101[1] != r102[1]) goto L6;
        r103 = true;
    L6:
        r104.setParentIsTop(r103);     // Catch: Throwable -> L12
        if (r100 <= 0) goto L15;
        kb3.b r105 = this.f172184p;     // Catch: Throwable -> L12
        if (r105 == null) goto L16;
        r105.a(this);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void setCommentAbility(kb3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "collectCommonAbility");
        this.f172184p = r100;
        getGul().setLifecycleOwner(r100.getLifecycleOwner());
        getGul().setCollectParams(r100.b());
        getGul().setYaTaInstance(r100.c());
    }

    public CollectGoodsLinkedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.collect_goods_nested_v2_container, this, true);
        setInnerLayout((ViewGroup) findViewById(R.id.container));
        MaxHeightRecyclerView r103 = (MaxHeightRecyclerView) findViewById(R.id.rev1);
        h(BitableResourceData.KEY_REV_1, r103);
        Unit r104 = Unit.INSTANCE;
        this.f172181m = r103;
        CollectGoodsGULView r105 = (CollectGoodsGULView) findViewById(R.id.nested_v2_gul);
        r105.setSetUpCallBack(new CollectGoodsLinkedScrollView$$special$$inlined$apply$lambda$1(this));
        this.f172182n = r105;
        this.f172183o = (LoadMoreFooterView) findViewById(R.id.load_more_footer_view);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
    }

    public /* synthetic */ CollectGoodsLinkedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
