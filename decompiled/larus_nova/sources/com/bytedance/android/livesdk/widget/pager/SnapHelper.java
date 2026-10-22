package com.bytedance.android.livesdk.widget.pager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes11.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f161929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f161930b;

    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f161931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SnapHelper f161932b;

        public a(SnapHelper r100) {
            this.f161932b = r100;
            this.f161931a = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            super.onScrollStateChanged(r100, r101);
            if (r101 == 0) goto L5;
            return;
        L5:
            if (this.f161931a == false) goto L9;
            this.f161931a = false;
            this.f161932b.snapToTargetExistingView();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView r100, int r101, int r102) {
            if (r101 != 0) goto L4;
            if (r102 != 0) goto L4;
            return;
        L4:
            this.f161931a = true;
        }
    }

    public class b extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SnapHelper f161933a;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics r100) {
            return 100.0f / r100.densityDpi;
        }

        public b(SnapHelper r100, Context r101) {
            this.f161933a = r100;
            super(r101);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
            SnapHelper r103 = this.f161933a;
            int[] r104 = r103.calculateDistanceToFinalSnap(r103.f161929a.getLayoutManager(), r100);
            int r105 = r104[0];
            int r106 = r104[1];
            int r107 = calculateTimeForDeceleration(Math.max(Math.abs(r105), Math.abs(r106)));
            if (r107 <= 0) goto L6;
            r102.update(r105, r106, r107, this.mDecelerateInterpolator);
            return;
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101);

    public abstract View findSnapView(RecyclerView.LayoutManager r100);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102);

    public final void snapToTargetExistingView() {
        RecyclerView r100 = this.f161929a;
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = findSnapView(r101);
        if (r102 != null) goto L11;
        return;
    L11:
        int[] r103 = calculateDistanceToFinalSnap(r101, r102);
        int r104 = r103[0];
        if (r104 == 0) goto L14;
    L15:
        this.f161929a.smoothScrollBy(r104, r103[1]);
        return;
    L14:
        if (r103[1] != 0) goto L15;
    }

    public SnapHelper() {
        this.f161930b = new a(this);
    }

    public final void attachToRecyclerView(RecyclerView r100) throws IllegalStateException {
        RecyclerView r101 = this.f161929a;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        r101.removeOnScrollListener(this.f161930b);
        this.f161929a.setOnFlingListener(null);
    L7:
        this.f161929a = r100;
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.getOnFlingListener() != null) goto L13;
        this.f161929a.addOnScrollListener(this.f161930b);
        this.f161929a.setOnFlingListener(this);
        new Scroller(this.f161929a.getContext(), new DecelerateInterpolator());
        snapToTargetExistingView();
        return;
    L13:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r100) {
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L7;
        return null;
    L7:
        return new b(this, this.f161929a.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public final boolean onFling(int r100, int r101) {
        RecyclerView.LayoutManager r102 = this.f161929a.getLayoutManager();
        if (r102 != null) goto L6;
        return false;
    L6:
        if (this.f161929a.getAdapter() != null) goto L8;
        return false;
    L8:
        int r103 = this.f161929a.getMinFlingVelocity();
        if (Math.abs(r101) > r103) goto L13;
        if (Math.abs(r100) > r103) goto L13;
        return false;
    L13:
        if ((r102 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L15;
    L14:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L26;
        return true;
    L26:
        return false;
    L15:
        LinearSmoothScroller r105 = createSnapScroller(r102);
        if (r105 == null) goto L14;
        int r106 = findTargetSnapPosition(r102, r100, r101);
        if (r106 == (-1)) goto L14;
        r105.setTargetPosition(r106);
        r102.startSmoothScroll(r105);
        r104 = true;
        goto L22
    }
}
