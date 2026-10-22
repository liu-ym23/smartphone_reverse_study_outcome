package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ug0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/PCLandscapeLinkSeatRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PCLandscapeLinkSeatRecyclerLayoutManager extends RecyclerView.LayoutManager implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f75833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f75834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f75835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f75836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f75837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f75838f;

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

    public final void p() {
        if (this.f75833a > 0.0f) goto L5;
    L6:
        this.f75836d = false;
        this.f75833a = getWidth();
        this.f75834b = this.f75838f.s(getWidth(), getHeight());
        int r100 = n.f75850a;
        this.f75835c = n.b(this.f75838f, getWidth(), getHeight());
        return;
    L5:
        if (this.f75836d == true) goto L6;
    }

    public PCLandscapeLinkSeatRecyclerLayoutManager(m r100) {
        Intrinsics.checkNotNullParameter(r100, "linkWindowLayoutConfig");
        this.f75838f = r100;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r100) {
        List<m.d> r101 = this.f75838f.h();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.size();
    L6:
        m.d r104 = null;
        Object r105 = null;
        m.e r106 = null;
        Object r107 = null;
        if (r100 < r103) goto L30;
        int r108 = r100 - r103;
        List<m.e> r109 = this.f75838f.k();
        if (r109 == null) goto L20;
        Iterator<T> r110 = r109.iterator();
    L12:
        if (r110.hasNext() == false) goto L19;
        Object r111 = r110.next();
        if (((m.e) r111).c() != r108) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == false) goto L12;
        r105 = r111;
        goto L19
    L16:
        r112 = false;
    L19:
        r106 = (m.e) r105;
    L20:
        if (r106 == null) goto L56;
        p();
        o r113 = this.f75835c;
        if (r113 == null) goto L25;
        int r114 = r113.f75853c;
    L26:
        if (r113 == null) goto L28;
        r102 = r113.f75854d;
    L28:
        int r115 = (int) (((double) r114) * r106.d());
        int r116 = (int) (((double) r102) * r106.b());
        return new Pair(Integer.valueOf(r115), Integer.valueOf(r116));
    L25:
        r114 = 0;
        goto L26
    L56:
        return new Pair(0, 0);
    L30:
        List<m.d> r117 = this.f75838f.h();
        if (r117 == null) goto L42;
        Iterator<T> r118 = r117.iterator();
    L34:
        if (r118.hasNext() == false) goto L41;
        Object r119 = r118.next();
        if (((m.d) r119).c() != r100) goto L38;
        boolean r120 = true;
    L39:
        if (r120 == false) goto L34;
        r107 = r119;
        goto L41
    L38:
        r120 = false;
    L41:
        r104 = (m.d) r107;
    L42:
        if (r104 == null) goto L57;
        p();
        double r121 = r104.d();
        m.c r122 = this.f75838f.d();
        Intrinsics.checkNotNull(r122);
        double r123 = r121 / ((double) r122.c());
        double r124 = r104.b();
        m.c r125 = this.f75838f.d();
        Intrinsics.checkNotNull(r125);
        double r126 = r124 / ((double) r125.b());
        int r127 = (int) (((double) this.f75833a) * r123);
        int r128 = (int) (((double) this.f75834b) * r126);
        return new Pair(Integer.valueOf(r127), Integer.valueOf(r128));
    L57:
        return new Pair(0, 0);
    L5:
        r103 = 0;
        goto L6
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r110) {
        List<m.d> r100 = this.f75838f.h();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L6:
        m.d r103 = null;
        Object r104 = null;
        m.e r105 = null;
        Object r106 = null;
        if (r110 < r102) goto L36;
        int r111 = r110 - r102;
        List<m.e> r107 = this.f75838f.k();
        if (r107 == null) goto L20;
        Iterator<T> r108 = r107.iterator();
    L12:
        if (r108.hasNext() == false) goto L19;
        Object r109 = r108.next();
        if (((m.e) r109).c() != r111) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == false) goto L12;
        r104 = r109;
        goto L19
    L16:
        r112 = false;
    L19:
        r105 = (m.e) r104;
    L20:
        if (r105 == null) goto L62;
        p();
        o r113 = this.f75835c;
        if (r113 == null) goto L25;
        int r114 = r113.f75853c;
    L26:
        if (r113 == null) goto L28;
        int r115 = r113.f75854d;
    L29:
        if (r113 == null) goto L31;
        int r116 = r113.f75851a;
    L32:
        if (r113 == null) goto L34;
        r101 = r113.f75852b;
    L34:
        int r117 = (int) ((((double) r114) * r105.e()) + ((double) r116));
        int r118 = (int) ((((double) r115) * r105.f()) + ((double) r101));
        return new Pair(Integer.valueOf(r117), Integer.valueOf(r118));
    L31:
        r116 = 0;
        goto L32
    L28:
        r115 = 0;
        goto L29
    L25:
        r114 = 0;
        goto L26
    L62:
        return new Pair(0, 0);
    L36:
        List<m.d> r119 = this.f75838f.h();
        if (r119 == null) goto L48;
        Iterator<T> r120 = r119.iterator();
    L40:
        if (r120.hasNext() == false) goto L47;
        Object r121 = r120.next();
        if (((m.d) r121).c() != r110) goto L44;
        boolean r122 = true;
    L45:
        if (r122 == false) goto L40;
        r106 = r121;
        goto L47
    L44:
        r122 = false;
    L47:
        r103 = (m.d) r106;
    L48:
        if (r103 == null) goto L63;
        p();
        double r123 = r103.e();
        m.c r124 = this.f75838f.d();
        Intrinsics.checkNotNull(r124);
        double r125 = r123 / ((double) r124.c());
        double r126 = r103.f();
        m.c r127 = this.f75838f.d();
        Intrinsics.checkNotNull(r127);
        double r128 = r126 / ((double) r127.b());
        int r129 = (int) (((double) this.f75833a) * r125);
        int r130 = (int) (((double) this.f75834b) * r128);
        return new Pair(Integer.valueOf(r129), Integer.valueOf(r130));
    L63:
        return new Pair(0, 0);
    L5:
        r102 = 0;
        goto L6
    }

    @Override // ug0.a
    public final void e(int r100) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r100);
        if (this.f75837e == r100) goto L6;
        this.f75837e = r100;
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
        r101.setVisibility(this.f75837e);
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
        this.f75838f = r100;
    }
}
