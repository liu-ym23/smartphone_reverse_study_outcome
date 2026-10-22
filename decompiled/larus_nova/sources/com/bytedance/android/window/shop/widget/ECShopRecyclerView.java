package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECShopRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "lm", "", "setLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "getLayoutManager", "Lcom/bytedance/android/window/shop/widget/WindowTypeSeparatedAdapter;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f189836d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f189837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f189838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f189839c;

    @Override // androidx.recyclerview.widget.RecyclerView
    public WindowTypeSeparatedAdapter getAdapter() {
        RecyclerView.Adapter r100 = super.getAdapter();
        if ((r100 instanceof WindowTypeSeparatedAdapter) == true) goto L6;
        r100 = null;
    L6:
        return (WindowTypeSeparatedAdapter) r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public StaggeredGridLayoutManager getLayoutManager() {
        RecyclerView.LayoutManager r100 = super.getLayoutManager();
        if ((r100 instanceof StaggeredGridLayoutManager) == true) goto L6;
        r100 = null;
    L6:
        return (StaggeredGridLayoutManager) r100;
    }

    public final int r() {
        StaggeredGridLayoutManager r100 = getLayoutManager();
        if (r100 == null) goto L8;
        int[] r101 = r100.findFirstCompletelyVisibleItemPositions(this.f189837a);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101[0];
    L8:
        return 0;
    }

    public final int t() {
        StaggeredGridLayoutManager r100 = getLayoutManager();
        if (r100 == null) goto L8;
        int[] r101 = r100.findLastVisibleItemPositions(this.f189839c);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101[0];
    L8:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public /* bridge */ /* synthetic */ RecyclerView.Adapter getAdapter() {
        return getAdapter();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public /* bridge */ /* synthetic */ RecyclerView.LayoutManager getLayoutManager() {
        return getLayoutManager();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof WindowTypeSeparatedAdapter) == false) goto L9;
        super.setAdapter(r100);
        return;
    L9:
        throw new IllegalArgumentException("adapter is " + r100.getClass() + ", but " + WindowTypeSeparatedAdapter.class + " is required");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager r100) {
        if ((r100 instanceof StaggeredGridLayoutManager) == false) goto L7;
        super.setLayoutManager(r100);
        return;
    L7:
        throw new IllegalArgumentException("ls " + r100 + " is not allowed, you must use a " + StaggeredGridLayoutManager.class);
    }

    public ECShopRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f189837a = new int[2];
        this.f189838b = new int[2];
        this.f189839c = new int[2];
    }
}
