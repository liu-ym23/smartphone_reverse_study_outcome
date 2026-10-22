package tc;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l {
    public static /* synthetic */ void a(View r10, int r11, int r12, boolean r13, ViewGroup r14) {
        f(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(View[] r10, View r11, i r12, int r13, int r14) {
        h(r10, r11, r12, r13, r14);
    }

    public static final void c(View r10, int r11) {
        q.g(r10, "<this>");
        e(r10, r11, r11, false, 4, null);
    }

    public static final void d(final View r10, final int r11, final int r12, final boolean r13) {
        q.g(r10, "<this>");
        if (r10.getParent() == null) goto L9;
        ViewParent r14 = r10.getParent();
        if (r14 == null) goto L8;
        ViewGroup r15 = (ViewGroup) r14;
    L10:
        if (r15 != null) goto L12;
        return;
    L12:
        final ViewGroup r16 = r15;
        r15.post(new k(r10, r11, r12, r13, r16));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r15 = null;
        goto L10
    }

    public static /* synthetic */ void e(View r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = false;
    L5:
        d(r10, r11, r12, r13);
    }

    public static final void f(View r10, int r11, int r12, boolean r13, ViewGroup r14) {
        q.g(r10, "$this_expandTouchArea");
        q.g(r14, "$parentView");
        Rect r15 = new Rect();
        r10.getHitRect(r15);
        int r16 = (r11 - r15.width()) / 2;
        int r17 = (r12 - r15.height()) / 2;
        if (r16 >= 0) goto L6;
        if (r13 == true) goto L6;
        r16 = 0;
    L6:
        if (r17 >= 0) goto L9;
        if (r13 == true) goto L9;
        r17 = 0;
    L9:
        r15.left -= r16;
        r15.top -= r17;
        r15.right += r16;
        r15.bottom += r17;
        r14.setTouchDelegate(new TouchDelegate(r15, r10));
    }

    public static final void g(final View r10, final int r11, final int r12, final View... r13) {
        q.g(r10, "<this>");
        q.g(r13, "views");
        final i r14 = new i(r10, null, 2, null);
        r10.post(new j(r13, r10, r14, r11, r12));
    }

    public static final void h(View[] r10, View r11, i r12, int r13, int r14) {
        q.g(r10, "$views");
        q.g(r11, "$this_increaseHitAreaForViews");
        q.g(r12, "$touchDelegateComposite");
        int r15 = r10.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L10;
        View r17 = r10[r16];
        Rect r18 = new Rect();
        r17.getHitRect(r18);
        int r19 = (r13 - r18.width()) / 2;
        int r20 = (r14 - r18.height()) / 2;
        if (r19 >= 0) goto L7;
        r19 = 0;
    L7:
        if (r20 >= 0) goto L9;
        r20 = 0;
    L9:
        r18.left -= r19;
        r18.top -= r20;
        r18.right += r19;
        r18.bottom += r20;
        r12.a(new TouchDelegate(r18, r17));
        r16 = r16 + 1;
        goto L3
    L10:
        r11.setTouchDelegate(r12);
    }

    public static final boolean i(View r10) {
        q.g(r10, "<this>");
        if (r10.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean j(View r10) {
        q.g(r10, "<this>");
        if (r10.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void k(View r10) {
        q.g(r10, "<this>");
        r10.setVisibility(8);
    }

    public static final void l(View r10) {
        q.g(r10, "<this>");
        r10.setVisibility(4);
    }

    public static final void m(View r10) {
        q.g(r10, "<this>");
        r10.setVisibility(0);
    }

    public static final void n(View r10) {
        q.g(r10, "<this>");
        if (r10.getParent() != null) goto L5;
        return;
    L5:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L10;
        ((ViewGroup) r11).removeView(r10);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void o(ViewGroup r10, View r11) {
        q.g(r10, "<this>");
        if (r11 != null) goto L5;
        ViewParent r12 = null;
    L6:
        if (r12 != null) goto L8;
    L10:
        r10.addView(r11);
        return;
    L8:
        if ((r11.getParent() instanceof ViewGroup) == false) goto L10;
        n(r11);
        goto L10
    L5:
        r12 = r11.getParent();
        goto L6
    }

    public static final void p(View r10, boolean r11) {
        q.g(r10, "<this>");
        if (r11 == false) goto L5;
        m(r10);
        return;
    L5:
        k(r10);
    }
}
