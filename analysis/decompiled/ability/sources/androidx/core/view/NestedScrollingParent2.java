package androidx.core.view;

import android.view.View;

/* loaded from: classes2.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(View view, int i, int i6, int[] iArr, int i10);

    void onNestedScroll(View view, int i, int i6, int i10, int i11, int i12);

    void onNestedScrollAccepted(View view, View view2, int i, int i6);

    boolean onStartNestedScroll(View view, View view2, int i, int i6);

    void onStopNestedScroll(View view, int i);
}
