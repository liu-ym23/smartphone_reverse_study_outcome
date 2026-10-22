package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/NestedChildRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NestedChildRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f55687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NestedParentRecyclerView f55689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f55691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f55692f;

    public NestedChildRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NestedChildRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void t() {
        this.f55692f = true;
        super.scrollToPosition(0);
    }

    public final boolean r() {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        View r101 = null;
        if ((r100 instanceof LinearLayoutManager) == true) goto L5;
        r100 = null;
    L5:
        LinearLayoutManager r102 = (LinearLayoutManager) r100;
        if (r102 == null) goto L8;
        Integer r103 = Integer.valueOf(r102.findFirstVisibleItemPosition());
    L9:
        RecyclerView.LayoutManager r104 = getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == true) goto L12;
        r104 = null;
    L12:
        LinearLayoutManager r105 = (LinearLayoutManager) r104;
        if (r105 == null) goto L16;
        r101 = r105.findViewByPosition(0);
    L16:
        if (r103 == null) goto L27;
        if (r103.intValue() != 1) goto L27;
        if (r101 == null) goto L27;
        if (r101.getTop() != 0) goto L27;
        if (r101.getHeight() != 0) goto L27;
        return true;
    L27:
        return !canScrollVertically(-1);
    L8:
        r103 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L5;
        this.f55688b = 0;
    L5:
        r100.getAction();
        if (this.f55691e == false) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        return super.dispatchTouchEvent(r100);
    L13:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int r100, int r101) {
        if (isAttachedToWindow() == true) goto L5;
        return false;
    L5:
        boolean r102 = super.fling(r100, r101);
        if (r102 == false) goto L8;
        this.f55690d = true;
        this.f55688b = r101;
    L9:
        return r102;
    L8:
        this.f55688b = 0;
        this.f55690d = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void scrollBy(int r100, int r101) {
        super.scrollBy(r100, r101);
        this.f55690d = false;
    }

    public NestedChildRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f55687a = new h(r100);
        setOverScrollMode(2);
        addOnScrollListener(new NestedChildRecyclerView$initScrollListener$1(this));
        setNestedScrollingEnabled(false);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.requestDisallowInterceptTouchEvent});
        this.f55691e = r103.getBoolean(0, false);
        r103.recycle();
    }

    public /* synthetic */ NestedChildRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
