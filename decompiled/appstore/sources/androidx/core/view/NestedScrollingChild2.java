package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int r10, int r11, @Nullable int[] r12, @Nullable int[] r13, int r14);

    boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, @Nullable int[] r14, int r15);

    boolean hasNestedScrollingParent(int r10);

    boolean startNestedScroll(int r10, int r11);

    void stopNestedScroll(int r10);
}
