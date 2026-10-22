package androidx.core.view;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(View r100, float r101, float r102, boolean r103);

    boolean onNestedPreFling(View r100, float r101, float r102);

    void onNestedPreScroll(View r100, int r101, int r102, int[] r103);

    void onNestedScroll(View r100, int r101, int r102, int r103, int r104);

    void onNestedScrollAccepted(View r100, View r101, int r102);

    boolean onStartNestedScroll(View r100, View r101, int r102);

    void onStopNestedScroll(View r100);
}
