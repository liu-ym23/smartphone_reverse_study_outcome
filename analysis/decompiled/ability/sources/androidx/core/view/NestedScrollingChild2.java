package androidx.core.view;

/* loaded from: classes2.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i, int i6, int[] iArr, int[] iArr2, int i10);

    boolean dispatchNestedScroll(int i, int i6, int i10, int i11, int[] iArr, int i12);

    boolean hasNestedScrollingParent(int i);

    boolean startNestedScroll(int i, int i6);

    void stopNestedScroll(int i);
}
