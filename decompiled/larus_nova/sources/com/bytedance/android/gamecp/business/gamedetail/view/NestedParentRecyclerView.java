package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wu.t0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010¨\u0006$"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/NestedParentRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "c", "I", "getTotalDy", "()I", "setTotalDy", "(I)V", "totalDy", "", "d", "Z", "isStartFling", "()Z", "setStartFling", "(Z)V", "Lcom/bytedance/android/gamecp/business/gamedetail/view/f;", ce.f26391f, "Lcom/bytedance/android/gamecp/business/gamedetail/view/f;", "getMChildNestedScrollViewProvider", "()Lcom/bytedance/android/gamecp/business/gamedetail/view/f;", "setMChildNestedScrollViewProvider", "(Lcom/bytedance/android/gamecp/business/gamedetail/view/f;)V", "mChildNestedScrollViewProvider", RXScreenCaptureService.KEY_INDEX, "getMIsNeedInterceptTouchEvent", "setMIsNeedInterceptTouchEvent", "mIsNeedInterceptTouchEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NestedParentRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f55694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f55695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f55696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f55698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f55699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f55700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f55701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f55702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<l> f55703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<m> f55704k;

    public NestedParentRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NestedParentRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean v() {
        return true ^ canScrollVertically(1);
    }

    public final void u() {
        final Context r100 = getContext();
        LinearLayoutManager r101 = new NestedParentRecyclerView$initLayoutManager$linearLayoutManager$1(this, r100);
        r101.setOrientation(1);
        setLayoutManager(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VelocityTracker r100 = this.f55699f;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f55699f = null;
    }

    public final void t() {
        if (v() == false) goto L20;
        int r100 = this.f55698e;
        if (r100 == 0) goto L20;
        this.f55694a.getClass();
        if (h.a(r100) <= this.f55696c) goto L20;
        int r101 = this.f55698e;
        Object r102 = getAdapter();
        NestedChildRecyclerView r103 = null;
        if ((r102 instanceof f) == true) goto L11;
        r102 = null;
    L11:
        f r104 = (f) r102;
        if (r104 == null) goto L14;
        NestedChildRecyclerView r105 = r104.ig();
    L18:
        if (r105 == null) goto L20;
        r105.fling(0, r101);
        goto L20
    L14:
        f r106 = this.f55700g;
        if (r106 == null) goto L17;
        r103 = r106.ig();
    L17:
        r105 = r103;
    L20:
        this.f55696c = 0;
        this.f55698e = 0;
    }

    public final f getMChildNestedScrollViewProvider() {
        return this.f55700g;
    }

    public final boolean getMIsNeedInterceptTouchEvent() {
        return this.f55702i;
    }

    public final int getTotalDy() {
        return this.f55696c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Iterator<m> r101 = this.f55704k.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r101.next().onTouchEvent(r100);
        goto L4
    L7:
        if (r100.getAction() != 0) goto L10;
        this.f55698e = 0;
        stopScroll();
    L10:
        if (r100.getAction() != 2) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L18;
        this.f55695b = 0.0f;
    L18:
        return super.dispatchTouchEvent(r100);
    L21:
        return false;
    L12:
        r102 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f55702i == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f55699f != null) goto L5;
        this.f55699f = VelocityTracker.obtain();
    L5:
        VelocityTracker r101 = this.f55699f;
        if (r101 == null) goto L9;
        r101.addMovement(r100);
    L9:
        if (r100.getAction() != 1) goto L21;
        if (this.f55697d == true) goto L21;
        VelocityTracker r102 = this.f55699f;
        if (r102 == null) goto L16;
        r102.computeCurrentVelocity(1000, ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity());
    L16:
        if (r102 == null) goto L18;
        int r103 = (int) r102.getYVelocity();
    L19:
        this.f55698e = -r103;
        t();
        goto L21
    L18:
        r103 = 0;
    L21:
        if (this.f55695b != 0.0f) goto L23;
        this.f55695b = r100.getY();
    L23:
        Object r104 = getAdapter();
        NestedChildRecyclerView r105 = null;
        if ((r104 instanceof f) == true) goto L26;
        r104 = null;
    L26:
        f r106 = (f) r104;
        if (r106 == null) goto L29;
        NestedChildRecyclerView r107 = r106.ig();
    L33:
        int r108 = (int) (this.f55695b - r100.getY());
        if (v() == true) goto L43;
        if (r108 >= 0) goto L40;
        if (r107 == null) goto L43;
        if (r107.r() != true) goto L43;
    L40:
        this.f55695b = r100.getY();
        return super.onTouchEvent(r100);
    L55:
        return false;
    L43:
        if (r107 == null) goto L48;
        if (r108 == 0) goto L48;
        r107.scrollBy(0, r108);
        if (r107.r() == false) goto L48;
        scrollBy(0, r108);
    L48:
        if (r107 != null) goto L50;
        scrollBy(0, r108);
    L50:
        this.f55695b = r100.getY();
        return true;
    L29:
        f r109 = this.f55700g;
        if (r109 == null) goto L32;
        r105 = r109.ig();
    L32:
        r107 = r105;
        goto L33
    }

    public final void r(l r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f55703j.contains(r100) == true) goto L6;
        this.f55703j.add(r100);
        return;
    }

    public final void setMChildNestedScrollViewProvider(f r100) {
        this.f55700g = r100;
    }

    public final void setMIsNeedInterceptTouchEvent(boolean r100) {
        this.f55702i = r100;
    }

    public final void setStartFling(boolean r100) {
        this.f55697d = r100;
    }

    public final void setTotalDy(int r100) {
        this.f55696c = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int r100, int r101) {
        boolean r102 = super.fling(r100, r101);
        if (r102 == false) goto L7;
        if (r101 <= 0) goto L7;
        this.f55697d = true;
        this.f55698e = r101;
    L8:
        return r102;
    L7:
        this.f55698e = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        Iterator<T> r102 = this.f55703j.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).a(r100, r101);
        goto L4
    L6:
        super.onMeasure(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void scrollBy(int r100, int r101) {
        super.scrollBy(r100, r101);
        this.f55697d = false;
    }

    public NestedParentRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f55694a = new h(r100);
        this.f55701h = t0.f561390a.getValue();
        setDescendantFocusability(393216);
        addOnScrollListener(new AnonymousClass1(this));
        this.f55703j = new ArrayList();
        this.f55704k = new ArrayList();
    }

    public /* synthetic */ NestedParentRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
