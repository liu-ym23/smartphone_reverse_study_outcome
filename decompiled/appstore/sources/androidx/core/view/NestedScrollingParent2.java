package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View r10, int r11, int r12, @NonNull int[] r13, int r14);

    void onNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, int r15);

    void onNestedScrollAccepted(@NonNull View r10, @NonNull View r11, int r12, int r13);

    boolean onStartNestedScroll(@NonNull View r10, @NonNull View r11, int r12, int r13);

    void onStopNestedScroll(@NonNull View r10, int r11);
}
