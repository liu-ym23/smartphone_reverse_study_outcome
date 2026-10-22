package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS = null;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup.MarginLayoutParams r100 = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = r100;
        r100.setMargins(0, 0, 0, 0);
    }

    private boolean arePagesLaidOutContiguously() {
        int r100 = this.mLayoutManager.getChildCount();
        if (r100 != 0) goto L6;
        return true;
    L6:
        if (this.mLayoutManager.getOrientation() != 0) goto L8;
        boolean r101 = true;
    L9:
        int[][] r102 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, 2});
        int r103 = 0;
    L10:
        if (r103 >= r100) goto L28;
        View r104 = this.mLayoutManager.getChildAt(r103);
        if (r104 == null) goto L27;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L17:
        int[] r107 = r102[r103];
        if (r101 == false) goto L20;
        int r108 = r104.getLeft();
        int r110 = r106.leftMargin;
    L21:
        r107[0] = r108 - r110;
        int[] r109 = r102[r103];
        if (r101 == false) goto L24;
        int r111 = r104.getRight();
        int r112 = r106.rightMargin;
    L25:
        r109[1] = r111 + r112;
        r103 = r103 + 1;
        goto L10
    L24:
        r111 = r104.getBottom();
        r112 = r106.bottomMargin;
        goto L25
    L20:
        r108 = r104.getTop();
        r110 = r106.topMargin;
        goto L21
    L16:
        r106 = ZERO_MARGIN_LAYOUT_PARAMS;
        goto L17
    L27:
        throw new IllegalStateException("null view contained in the view hierarchy");
    L28:
        Arrays.sort(r102, new AnonymousClass1(this));
        int r113 = 1;
    L29:
        if (r113 >= r100) goto L34;
        if (r102[r113 - 1][1] != r102[r113][0]) goto L32;
        r113 = r113 + 1;
        goto L29
    L32:
        return false;
    L34:
        int[] r114 = r102[0];
        int r115 = r114[1];
        int r116 = r114[0];
        int r117 = r115 - r116;
        if (r116 <= 0) goto L37;
    L40:
        return false;
    L37:
        if (r102[r100 - 1][1] < r117) goto L40;
        return true;
    L8:
        r101 = false;
        goto L9
    }

    private boolean hasRunningChangingLayoutTransition() {
        int r100 = this.mLayoutManager.getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(r101)) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean mayHaveInterferingAnimations() {
        if (arePagesLaidOutContiguously() == false) goto L7;
        if (this.mLayoutManager.getChildCount() <= 1) goto L7;
    L9:
        return false;
    L7:
        if (hasRunningChangingLayoutTransition() == false) goto L9;
        return true;
    }

    public AnimateLayoutChangeDetector(LinearLayoutManager r100) {
        this.mLayoutManager = r100;
    }

    private static boolean hasRunningChangingLayoutTransition(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L15;
        ViewGroup r101 = (ViewGroup) r100;
        LayoutTransition r102 = r101.getLayoutTransition();
        if (r102 != null) goto L7;
    L9:
        int r103 = r101.getChildCount();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L15;
        if (hasRunningChangingLayoutTransition(r101.getChildAt(r104)) == true) goto L13;
        r104 = r104 + 1;
        goto L10
    L13:
        return true;
    L7:
        if (r102.isChangingLayout() == false) goto L9;
        return true;
    L15:
        return false;
    }
}
