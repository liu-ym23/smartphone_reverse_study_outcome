package androidx.core.view;

/* JADX INFO: loaded from: classes3.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float r100, float r101, boolean r102);

    boolean dispatchNestedPreFling(float r100, float r101);

    boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103);

    boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean r100);

    boolean startNestedScroll(int r100);

    void stopNestedScroll();
}
