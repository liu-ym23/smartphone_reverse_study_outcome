package androidx.core.view;

/* JADX INFO: loaded from: classes3.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104);

    boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104, int r105);

    boolean hasNestedScrollingParent(int r100);

    boolean startNestedScroll(int r100, int r101);

    void stopNestedScroll(int r100);
}
