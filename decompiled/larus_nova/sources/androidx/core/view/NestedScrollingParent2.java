package androidx.core.view;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104);

    void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105);

    void onNestedScrollAccepted(View r100, View r101, int r102, int r103);

    boolean onStartNestedScroll(View r100, View r101, int r102, int r103);

    void onStopNestedScroll(View r100, int r101);
}
