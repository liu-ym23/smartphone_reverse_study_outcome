package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f2680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f2681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f2682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f2684e;

    public NestedScrollingChildHelper(View r10) {
        this.f2682c = r10;
    }

    public boolean a(float r10, float r11, boolean r12) {
        if (m() == false) goto L8;
        ViewParent r13 = i(0);
        if (r13 == null) goto L8;
        return p.a(r13, this.f2682c, r10, r11, r12);
    L8:
        return false;
    }

    public boolean b(float r10, float r11) {
        if (m() == false) goto L8;
        ViewParent r12 = i(0);
        if (r12 == null) goto L8;
        return p.b(r12, this.f2682c, r10, r11);
    L8:
        return false;
    }

    public boolean c(int r10, int r11, int[] r12, int[] r13) {
        return d(r10, r11, r12, r13, 0);
    }

    public boolean d(int r11, int r12, int[] r13, int[] r14, int r15) {
        if (m() == false) goto L27;
        ViewParent r10 = i(r15);
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r11 != 0) goto L13;
        if (r12 != 0) goto L13;
        if (r14 == null) goto L28;
        r14[0] = 0;
        r14[1] = 0;
        return false;
    L28:
        return false;
    L13:
        if (r14 == null) goto L15;
        this.f2682c.getLocationInWindow(r14);
        int r16 = r14[0];
        int r17 = r14[1];
    L16:
        if (r13 != null) goto L18;
        r13 = j();
    L18:
        r13[0] = 0;
        r13[1] = 0;
        p.c(r10, this.f2682c, r11, r12, r13, r15);
        if (r14 == null) goto L22;
        this.f2682c.getLocationInWindow(r14);
        r14[0] = r14[0] - r16;
        r14[1] = r14[1] - r17;
    L22:
        if (r13[0] != 0) goto L26;
        if (r13[1] != 0) goto L26;
        return false;
    L26:
        return true;
    L15:
        r16 = 0;
        r17 = 0;
        goto L16
    L27:
        return false;
    }

    public void e(int r10, int r11, int r12, int r13, int[] r14, int r15, int[] r16) {
        h(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean f(int r10, int r11, int r12, int r13, int[] r14) {
        return h(r10, r11, r12, r13, r14, 0, null);
    }

    public boolean g(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return h(r10, r11, r12, r13, r14, r15, null);
    }

    public final boolean h(int r16, int r17, int r18, int r19, int[] r20, int r21, int[] r22) {
        if (m() == false) goto L25;
        ViewParent r10 = i(r21);
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r16 != 0) goto L15;
        if (r17 != 0) goto L15;
        if (r18 != 0) goto L15;
        if (r19 != 0) goto L15;
        if (r20 == null) goto L25;
        r20[0] = 0;
        r20[1] = 0;
    L15:
        if (r20 == null) goto L17;
        this.f2682c.getLocationInWindow(r20);
        int r13 = r20[0];
        int r14 = r20[1];
    L18:
        if (r22 != null) goto L20;
        int[] r11 = j();
        r11[0] = 0;
        r11[1] = 0;
        int[] r12 = r11;
    L21:
        p.d(r10, this.f2682c, r16, r17, r18, r19, r21, r12);
        if (r20 == null) goto L24;
        this.f2682c.getLocationInWindow(r20);
        r20[0] = r20[0] - r13;
        r20[1] = r20[1] - r14;
    L24:
        return true;
    L20:
        r12 = r22;
        goto L21
    L17:
        r13 = 0;
        r14 = 0;
    L25:
        return false;
    }

    public final ViewParent i(int r10) {
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return null;
    L8:
        return this.f2681b;
    L10:
        return this.f2680a;
    }

    public final int[] j() {
        if (this.f2684e != null) goto L6;
        this.f2684e = new int[2];
    L6:
        return this.f2684e;
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int r10) {
        if (i(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m() {
        return this.f2683d;
    }

    public void n(boolean r10) {
        if (this.f2683d == false) goto L5;
        ViewCompat.M0(this.f2682c);
    L5:
        this.f2683d = r10;
    }

    public final void o(int r10, ViewParent r11) {
        if (r10 != 0) goto L4;
        this.f2680a = r11;
        return;
    L4:
        if (r10 != 1) goto L10;
        this.f2681b = r11;
        return;
    }

    public boolean p(int r10) {
        return q(r10, 0);
    }

    public boolean q(int r10, int r11) {
        if (l(r11) == false) goto L6;
        return true;
    L6:
        if (m() == false) goto L17;
        ViewParent r12 = this.f2682c.getParent();
        View r13 = this.f2682c;
    L8:
        if (r12 == null) goto L23;
        if (p.f(r12, r13, this.f2682c, r10, r11) == true) goto L11;
        if ((r12 instanceof View) == false) goto L16;
        r13 = (View) r12;
    L16:
        r12 = r12.getParent();
        goto L8
    L11:
        o(r11, r12);
        p.e(r12, r13, this.f2682c, r10, r11);
        return true;
    L23:
        return false;
    L17:
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int r10) {
        ViewParent r11 = i(r10);
        if (r11 == null) goto L6;
        p.g(r11, this.f2682c, r10);
        o(r10, null);
        return;
    }
}
