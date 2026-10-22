package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch;
    }

    public NestedScrollingParentHelper(ViewGroup r100) {
    }

    public void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    public void onStopNestedScroll(View r100, int r101) {
        if (r101 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = 0;
        return;
    L5:
        this.mNestedScrollAxesTouch = 0;
    }

    public void onNestedScrollAccepted(View r100, View r101, int r102) {
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    public void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        if (r103 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = r102;
        return;
    L5:
        this.mNestedScrollAxesTouch = r102;
    }
}
