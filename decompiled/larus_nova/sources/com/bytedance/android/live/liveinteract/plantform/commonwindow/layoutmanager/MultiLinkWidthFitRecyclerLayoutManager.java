package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ug0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkWidthFitRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkWidthFitRecyclerLayoutManager extends RecyclerView.LayoutManager implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f75832b;

    @Override // ug0.a
    public final boolean isDynamicAnimating() {
        return false;
    }

    @Override // ug0.a
    public final void setDynamicAnimatorListener(Function0<Unit> r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -1);
    }

    public MultiLinkWidthFitRecyclerLayoutManager(m r100) {
        Intrinsics.checkNotNullParameter(r100, "linkWindowLayoutConfig");
        this.f75832b = r100;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r100) {
        List<m.d> r101 = this.f75832b.h();
        m.d r102 = null;
        Object r103 = null;
        if (r101 == null) goto L14;
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (((m.d) r105).c() != r100) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L6;
        r103 = r105;
        goto L13
    L10:
        r106 = false;
    L13:
        r102 = (m.d) r103;
    L14:
        if (r102 == null) goto L16;
        double r107 = r102.d();
        m.c r108 = this.f75832b.d();
        Intrinsics.checkNotNull(r108);
        double r109 = r107 / ((double) r108.c());
        double r110 = r102.b();
        m.c r111 = this.f75832b.d();
        Intrinsics.checkNotNull(r111);
        double r112 = r110 / ((double) r111.b());
        int r113 = n.f75850a;
        int r114 = n.a(this.f75832b.getUiLayout()) * 2;
        int r115 = ((int) (((double) getWidth()) * r109)) - r114;
        int r116 = ((int) (((double) getHeight()) * r112)) - r114;
        return new Pair(Integer.valueOf(r115), Integer.valueOf(r116));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r100) {
        List<m.d> r101 = this.f75832b.h();
        m.d r102 = null;
        Object r103 = null;
        if (r101 == null) goto L14;
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (((m.d) r105).c() != r100) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L6;
        r103 = r105;
        goto L13
    L10:
        r106 = false;
    L13:
        r102 = (m.d) r103;
    L14:
        if (r102 == null) goto L16;
        double r107 = r102.e();
        m.c r108 = this.f75832b.d();
        Intrinsics.checkNotNull(r108);
        double r109 = r107 / ((double) r108.c());
        double r110 = r102.f();
        m.c r111 = this.f75832b.d();
        Intrinsics.checkNotNull(r111);
        double r112 = r110 / ((double) r111.b());
        int r113 = n.f75850a;
        int r114 = n.a(this.f75832b.getUiLayout());
        int r115 = ((int) (((double) getWidth()) * r109)) + r114;
        int r116 = ((int) (((double) getHeight()) * r112)) + r114;
        return new Pair(Integer.valueOf(r115), Integer.valueOf(r116));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final void e(int r100) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r100);
        if (this.f75831a == r100) goto L6;
        this.f75831a = r100;
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r110, RecyclerView.State r111) {
        Intrinsics.checkNotNullParameter(r110, "recycler");
        Intrinsics.checkNotNullParameter(r111, "state");
        if (r111.getItemCount() != 0) goto L6;
        removeAndRecycleAllViews(r110);
        return;
    L6:
        detachAndScrapAttachedViews(r110);
        int r112 = r111.getItemCount();
        if (r112 != 0) goto L9;
        removeAndRecycleAllViews(r110);
        return;
    L9:
        int r100 = 0;
    L10:
        if (r100 >= r112) goto L20;
        View r101 = r110.getViewForPosition(r100);
        Pair<Integer, Integer> r102 = a(r100);
        int r103 = r102.component1().intValue();
        int r104 = r102.component2().intValue();
        r101.getLayoutParams().width = r103;
        r101.getLayoutParams().height = r104;
        addView(r101);
        measureChild(r101, 0, 0);
        Pair<Integer, Integer> r105 = c(r100);
        int r106 = r105.component1().intValue();
        int r107 = r105.component2().intValue();
        layoutDecorated(r101, r106, r107, r106 + getDecoratedMeasuredWidth(r101), r107 + getDecoratedMeasuredHeight(r101));
        if (r100 == 0) goto L14;
        r101.setVisibility(this.f75831a);
    L15:
        r100 = r100 + 1;
        goto L10
    L14:
        r101.setVisibility(0);
        goto L15
    }

    @Override // ug0.a
    public final void U3(m r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        this.f75832b = r100;
    }
}
