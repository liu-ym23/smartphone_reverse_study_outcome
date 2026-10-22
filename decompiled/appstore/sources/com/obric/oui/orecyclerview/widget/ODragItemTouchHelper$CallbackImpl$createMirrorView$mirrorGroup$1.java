package com.obric.oui.orecyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1", "Landroid/view/ViewGroup;", "Landroid/graphics/Canvas;", "canvas", "", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "changed", "", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f15427a;

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        q.g(r10, "canvas");
        this.f15427a.draw(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }
}
