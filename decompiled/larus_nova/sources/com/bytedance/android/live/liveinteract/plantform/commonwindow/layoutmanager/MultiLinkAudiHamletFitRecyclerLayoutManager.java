package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkAudiHamletFitRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAudiHamletFitRecyclerLayoutManager extends RecyclerView.LayoutManager implements ug0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f75826b;

    public static final class a {
    }

    static {
    }

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

    public MultiLinkAudiHamletFitRecyclerLayoutManager(m r100) {
        Intrinsics.checkNotNullParameter(r100, "linkWindowLayoutConfig");
        this.f75826b = r100;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r100) {
        List<m.d> r101 = this.f75826b.h();
        Object r102 = null;
        if (r101 == null) goto L14;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((m.d) r104).c() != r100) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102 = r104;
        goto L13
    L10:
        r105 = false;
    L13:
        r102 = (m.d) r102;
    L14:
        if (r102 == null) goto L16;
        int r106 = getHeight();
        int r107 = getWidth();
        if (r100 == 0) goto L20;
        int r108 = (int) (r106 * 0.093023255f);
        return new Pair(Integer.valueOf(r108), Integer.valueOf(r108));
    L20:
        return new Pair(Integer.valueOf(r107), Integer.valueOf(r106));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r100) {
        List<m.d> r101 = this.f75826b.h();
        if (r101 == null) goto L11;
        int r102 = r101.size();
        if (r100 == 0) goto L7;
        float r103 = getHeight();
        float r104 = 0.046511628f * r103;
        float r105 = ((r103 - (2 * r104)) - ((0.023255814f * r103) * (r102 - 2))) / (r102 - 1);
        float r106 = getWidth();
        float r107 = r100 - 1;
        return new Pair(Integer.valueOf((int) ((r106 - r105) - (0.064257026f * r106))), Integer.valueOf((int) ((r104 + (r105 * r107)) + ((r107 * 0.023255814f) * r103))));
    L7:
        return new Pair(0, 0);
    L11:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final void e(int r100) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r100);
        if (this.f75825a == r100) goto L6;
        this.f75825a = r100;
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
        r101.setVisibility(this.f75825a);
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
        this.f75826b = r100;
    }
}
