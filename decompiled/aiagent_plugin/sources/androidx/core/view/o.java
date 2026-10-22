package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NestedScrollingChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewParent f1516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewParent f1517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f1518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f1520e;

    public o(View r1) {
        this.f1518c = r1;
    }

    public void a(boolean r2) {
        if (this.f1519d == false) goto L5;
        ViewCompat.E(this.f1518c);
    L5:
        this.f1519d = r2;
    }

    public boolean a() {
        return this.f1519d;
    }

    public boolean b() {
        return a(0);
    }

    public boolean a(int r1) {
        if (d(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b(int r2) {
        return a(r2, 0);
    }

    public boolean a(int r5, int r6) {
        if (a(r6) == false) goto L6;
        return true;
    L6:
        if (a() == false) goto L17;
        ViewParent r0 = this.f1518c.getParent();
        View r2 = this.f1518c;
    L8:
        if (r0 == null) goto L23;
        if (ad.a(r0, r2, this.f1518c, r5, r6) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L16;
        r2 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L16:
        r0 = r0.getParent();
        goto L8
    L11:
        a(r6, r0);
        ad.b(r0, r2, this.f1518c, r5, r6);
        return true;
    L23:
        return false;
    L17:
        return false;
    }

    public void c() {
        c(0);
    }

    public void c(int r3) {
        ViewParent r0 = d(r3);
        if (r0 == null) goto L6;
        ad.a(r0, this.f1518c, r3);
        a(r3, null);
        return;
    }

    public boolean a(int r9, int r10, int r11, int r12, int[] r13) {
        return b(r9, r10, r11, r12, r13, 0, null);
    }

    public boolean a(int r9, int r10, int r11, int r12, int[] r13, int r14) {
        return b(r9, r10, r11, r12, r13, r14, null);
    }

    public void a(int r1, int r2, int r3, int r4, int[] r5, int r6, int[] r7) {
        b(r1, r2, r3, r4, r5, r6, r7);
    }

    private boolean b(int r16, int r17, int r18, int r19, int[] r20, int r21, int[] r22) {
        if (a() == false) goto L25;
        ViewParent r4 = d(r21);
        if (r4 != null) goto L8;
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
        this.f1518c.getLocationInWindow(r20);
        int r13 = r20[0];
        int r14 = r20[1];
    L18:
        if (r22 != null) goto L20;
        int[] r5 = d();
        r5[0] = 0;
        r5[1] = 0;
        int[] r11 = r5;
    L21:
        ad.a(r4, this.f1518c, r16, r17, r18, r19, r21, r11);
        if (r20 == null) goto L24;
        this.f1518c.getLocationInWindow(r20);
        r20[0] = r20[0] - r13;
        r20[1] = r20[1] - r14;
    L24:
        return true;
    L20:
        r11 = r22;
        goto L21
    L17:
        r13 = 0;
        r14 = 0;
    L25:
        return false;
    }

    public boolean a(int r7, int r8, int[] r9, int[] r10) {
        return a(r7, r8, r9, r10, 0);
    }

    public boolean a(int r11, int r12, int[] r13, int[] r14, int r15) {
        if (a() == false) goto L27;
        ViewParent r2 = d(r15);
        if (r2 != null) goto L8;
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
        this.f1518c.getLocationInWindow(r14);
        int r8 = r14[0];
        int r9 = r14[1];
    L16:
        if (r13 != null) goto L18;
        r13 = d();
    L18:
        r13[0] = 0;
        r13[1] = 0;
        ad.a(r2, this.f1518c, r11, r12, r13, r15);
        if (r14 == null) goto L22;
        this.f1518c.getLocationInWindow(r14);
        r14[0] = r14[0] - r8;
        r14[1] = r14[1] - r9;
    L22:
        if (r13[0] != 0) goto L26;
        if (r13[1] != 0) goto L26;
        return false;
    L26:
        return true;
    L15:
        r8 = 0;
        r9 = 0;
        goto L16
    L27:
        return false;
    }

    public boolean a(float r3, float r4, boolean r5) {
        if (a() == false) goto L8;
        ViewParent r0 = d(0);
        if (r0 == null) goto L8;
        return ad.a(r0, this.f1518c, r3, r4, r5);
    L8:
        return false;
    }

    public boolean a(float r3, float r4) {
        if (a() == false) goto L8;
        ViewParent r0 = d(0);
        if (r0 == null) goto L8;
        return ad.a(r0, this.f1518c, r3, r4);
    L8:
        return false;
    }

    private ViewParent d(int r2) {
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L8;
        return null;
    L8:
        return this.f1517b;
    L10:
        return this.f1516a;
    }

    private void a(int r3, ViewParent r4) {
        ViewParent r5 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r4, ViewParent.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L5;
        this.f1516a = r5;
        return;
    L5:
        if (r3 != 1) goto L11;
        this.f1517b = r5;
        return;
    }

    private int[] d() {
        if (this.f1520e != null) goto L6;
        this.f1520e = new int[2];
    L6:
        return this.f1520e;
    }
}
