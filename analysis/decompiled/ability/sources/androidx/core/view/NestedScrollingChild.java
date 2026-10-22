package androidx.core.view;

/* loaded from: classes2.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f, float f7, boolean z10);

    boolean dispatchNestedPreFling(float f, float f7);

    boolean dispatchNestedPreScroll(int i, int i6, int[] iArr, int[] iArr2);

    boolean dispatchNestedScroll(int i, int i6, int i10, int i11, int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z10);

    boolean startNestedScroll(int i);

    void stopNestedScroll();
}
