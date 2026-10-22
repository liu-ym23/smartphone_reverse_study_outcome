package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: AnimateLayoutChangeDetector.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f2953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayoutManager f2954b;

    static {
        ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(-1, -1);
        f2953a = r0;
        r0.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager r1) {
        this.f2954b = r1;
    }

    boolean a() {
        if (b() == false) goto L7;
        if (this.f2954b.x() <= 1) goto L7;
    L9:
        return false;
    L7:
        if (c() == false) goto L9;
        return true;
    }

    private boolean b() {
        int r0 = this.f2954b.x();
        if (r0 != 0) goto L6;
        return true;
    L6:
        if (this.f2954b.h() != 0) goto L8;
        boolean r2 = true;
    L9:
        int[][] r4 = (int[][]) Array.newInstance(int.class, new int[]{r0, 2});
        int r5 = 0;
    L10:
        if (r5 >= r0) goto L28;
        View r6 = this.f2954b.i(r5);
        if (r6 == null) goto L27;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L16;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L17:
        int[] r9 = r4[r5];
        if (r2 == false) goto L20;
        int r10 = r6.getLeft();
        int r11 = r8.leftMargin;
    L21:
        r9[0] = r10 - r11;
        int[] r12 = r4[r5];
        if (r2 == false) goto L24;
        int r13 = r6.getRight();
        int r14 = r8.rightMargin;
    L25:
        r12[1] = r13 + r14;
        r5 = r5 + 1;
        goto L10
    L24:
        r13 = r6.getBottom();
        r14 = r8.bottomMargin;
        goto L25
    L20:
        r10 = r6.getTop();
        r11 = r8.topMargin;
        goto L21
    L16:
        r8 = f2953a;
        goto L17
    L27:
        throw new IllegalStateException("null view contained in the view hierarchy");
    L28:
        Arrays.sort(r4, new AnonymousClass1(this));
        int r15 = 1;
    L29:
        if (r15 >= r0) goto L34;
        if (r4[r15 - 1][1] != r4[r15][0]) goto L32;
        r15 = r15 + 1;
        goto L29
    L32:
        return false;
    L34:
        int r16 = r4[0][1] - r4[0][0];
        if (r4[0][0] <= 0) goto L37;
    L40:
        return false;
    L37:
        if (r4[r0 - 1][1] < r16) goto L40;
        return true;
    L8:
        r2 = false;
        goto L9
    }

    private boolean c() {
        int r0 = this.f2954b.x();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (a(this.f2954b.i(r2)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean a(View r5) {
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L15;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        LayoutTransition r0 = r6.getLayoutTransition();
        if (r0 != null) goto L7;
    L9:
        int r1 = r6.getChildCount();
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L15;
        if (a(r6.getChildAt(r3)) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        return true;
    L7:
        if (r0.isChangingLayout() == false) goto L9;
        return true;
    L15:
        return false;
    }
}
