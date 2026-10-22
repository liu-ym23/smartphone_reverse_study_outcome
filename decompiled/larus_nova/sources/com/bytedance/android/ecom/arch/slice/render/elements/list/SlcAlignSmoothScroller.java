package com.bytedance.android.ecom.arch.slice.render.elements.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/list/SlcAlignSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcAlignSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f50449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f50452d;

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int getHorizontalSnapPreference() {
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int getVerticalSnapPreference() {
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onTargetFound(View r100, RecyclerView.State r101, RecyclerView.SmoothScroller.Action r102) {
        RecyclerView.LayoutManager r103 = getLayoutManager();
        if (r103 != null) goto L7;
        super.onTargetFound(r100, r101, r102);
        return;
    L7:
        if (this.f50449a == false) goto L9;
        int r104 = r100.getTop();
        int r105 = r100.getBottom() - r104;
        int r106 = r103.getHeight();
    L10:
        int r107 = c.V3;
        int r108 = r104 - c.a.a(r106, r105, this.f50451c, this.f50450b, this.f50452d);
        if (r108 != 0) goto L13;
        return;
    L13:
        int r109 = calculateTimeForDeceleration(Math.abs(r108));
        if (r109 <= 0) goto L20;
        int r110 = 0;
        if (this.f50449a == false) goto L18;
        r110 = r108;
        r108 = 0;
    L18:
        r102.update(r108, r110, r109, this.mDecelerateInterpolator);
        return;
    L20:
        return;
    L9:
        r104 = r100.getLeft();
        r105 = r100.getRight() - r104;
        r106 = r103.getWidth();
        goto L10
    }

    public SlcAlignSmoothScroller(Context r100, boolean r101, int r102, String r103, int r104) {
        super(r100);
        this.f50449a = r101;
        this.f50450b = r102;
        this.f50451c = r103;
        this.f50452d = r104;
    }
}
