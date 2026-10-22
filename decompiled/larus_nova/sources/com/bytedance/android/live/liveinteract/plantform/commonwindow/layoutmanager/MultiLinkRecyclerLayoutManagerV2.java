package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;
import ug0.a;
import ug0.b;
import yg0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkRecyclerLayoutManagerV2;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkRecyclerLayoutManagerV2 extends RecyclerView.LayoutManager implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f75830b;

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

    public Pair<Integer, Integer> a(int r100) {
        Iterator<T> r101 = this.f75830b.f529924d.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((f.c) r102).f529933a != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        f.c r104 = (f.c) r102;
        if (r104 != null) goto L17;
        return new Pair(0, 0);
    L17:
        return new Pair(Integer.valueOf(r104.f529937e), Integer.valueOf(r104.f529938f));
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r100) {
        Iterator<T> r101 = this.f75830b.f529924d.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((f.c) r102).f529933a != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        f.c r104 = (f.c) r102;
        if (r104 != null) goto L17;
        return new Pair(0, 0);
    L17:
        return new Pair(Integer.valueOf(r104.f529935c), Integer.valueOf(r104.f529936d));
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }

    @Override // ug0.a
    public final void e(int r100) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r100);
        if (this.f75829a == r100) goto L6;
        this.f75829a = r100;
        requestLayout();
        return;
    }

    public MultiLinkRecyclerLayoutManagerV2(m r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "linkWindowLayoutConfig");
        Intrinsics.checkNotNullParameter(r101, "layoutConfigResult");
        this.f75830b = r101;
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
        r101.setVisibility(this.f75829a);
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
        f r103 = r100.f75842d;
        if (r103 == null) goto L5;
        Intrinsics.checkNotNull(r103);
        this.f75830b = r103;
        return;
    L5:
        int r104 = b.f549981a;
        Pair r105 = b.b(r100.m(), r100.getUiLayout(), r101, r102);
        Pair r106 = b.a();
        ln0.a r107 = h.f567472a;
        f r108 = h.a(r100, new Triple(r105.getFirst(), r105.getSecond(), "MultiLinkRecyclerLayoutManagerV2#updateLinkWindowLayoutConfig#backup"), r106);
        r100.f75842d = r108;
        this.f75830b = r108;
    }
}
