package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class g extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1861j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1862k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f1863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1865n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f1866o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1867p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1868q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f1869r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f1870s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f1871a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f1871a = r10;
            r10.append(R$styleable.KeyPosition_motionTarget, 1);
            f1871a.append(R$styleable.KeyPosition_framePosition, 2);
            f1871a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f1871a.append(R$styleable.KeyPosition_curveFit, 4);
            f1871a.append(R$styleable.KeyPosition_drawPath, 5);
            f1871a.append(R$styleable.KeyPosition_percentX, 6);
            f1871a.append(R$styleable.KeyPosition_percentY, 7);
            f1871a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f1871a.append(R$styleable.KeyPosition_sizePercent, 8);
            f1871a.append(R$styleable.KeyPosition_percentWidth, 11);
            f1871a.append(R$styleable.KeyPosition_percentHeight, 12);
            f1871a.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        public static /* synthetic */ void a(g r10, TypedArray r11) {
            b(r10, r11);
        }

        public static void b(g r10, TypedArray r11) {
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L4:
            if (r13 >= r12) goto L33;
            int r14 = r11.getIndex(r13);
            switch(f1871a.get(r14)) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                default: goto L7;
            };
        L7:
            Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(r14) + "   " + f1871a.get(r14));
        L31:
            r13 = r13 + 1;
            goto L4
        L8:
            r10.f1863l = r11.getFloat(r14, r10.f1863l);
            goto L31
        L9:
            r10.f1862k = r11.getFloat(r14, r10.f1862k);
            goto L31
        L10:
            r10.f1860i = r11.getInt(r14, r10.f1860i);
            goto L31
        L11:
            r10.f1868q = r11.getInt(r14, r10.f1868q);
            goto L31
        L12:
            float r15 = r11.getFloat(r14, r10.f1863l);
            r10.f1862k = r15;
            r10.f1863l = r15;
            goto L31
        L13:
            r10.f1865n = r11.getFloat(r14, r10.f1865n);
            goto L31
        L14:
            r10.f1864m = r11.getFloat(r14, r10.f1864m);
            goto L31
        L15:
            r10.f1861j = r11.getInt(r14, r10.f1861j);
            goto L31
        L16:
            r10.f1872g = r11.getInteger(r14, r10.f1872g);
            goto L31
        L21:
            r10.f1834a = r11.getInt(r14, r10.f1834a);
            goto L31
        L18:
            if (r11.peekValue(r14).type != 3) goto L20;
            r10.f1859h = r11.getString(r14);
            goto L31
        L20:
            r10.f1859h = p001j.c.f20781c[r11.getInteger(r14, 0)];
            goto L31
        L23:
            if (MotionLayout.E0 == false) goto L28;
            int r16 = r11.getResourceId(r14, r10.f1835b);
            r10.f1835b = r16;
            if (r16 != (-1)) goto L31;
            r10.f1836c = r11.getString(r14);
            goto L31
        L28:
            if (r11.peekValue(r14).type != 3) goto L30;
            r10.f1836c = r11.getString(r14);
            goto L31
        L30:
            r10.f1835b = r11.getResourceId(r14, r10.f1835b);
            goto L31
        L33:
            if (r10.f1834a != (-1)) goto L54;
            Log.e("KeyPosition", "no frame position");
            return;
        }
    }

    public g() {
        this.f1859h = null;
        this.f1860i = c.f1833f;
        this.f1861j = 0;
        this.f1862k = Float.NaN;
        this.f1863l = Float.NaN;
        this.f1864m = Float.NaN;
        this.f1865n = Float.NaN;
        this.f1866o = Float.NaN;
        this.f1867p = Float.NaN;
        this.f1868q = 0;
        this.f1869r = Float.NaN;
        this.f1870s = Float.NaN;
        this.f1837d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public c b() {
        return new g().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        g r11 = (g) r10;
        this.f1859h = r11.f1859h;
        this.f1860i = r11.f1860i;
        this.f1861j = r11.f1861j;
        this.f1862k = r11.f1862k;
        this.f1863l = Float.NaN;
        this.f1864m = r11.f1864m;
        this.f1865n = r11.f1865n;
        this.f1866o = r11.f1866o;
        this.f1867p = r11.f1867p;
        this.f1869r = r11.f1869r;
        this.f1870s = r11.f1870s;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.h
    public boolean m(int r10, int r11, RectF r12, RectF r13, float r14, float r15) {
        q(r10, r11, r12.centerX(), r12.centerY(), r13.centerX(), r13.centerY());
        if (Math.abs(r14 - this.f1869r) < 20.0f) goto L5;
        return false;
    L5:
        if (Math.abs(r15 - this.f1870s) >= 20.0f) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.h
    public void n(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16) {
        int r17 = this.f1868q;
        if (r17 != 1) goto L5;
        t(r11, r12, r13, r14, r15, r16);
        return;
    L5:
        if (r17 == 2) goto L8;
        s(r11, r12, r13, r14, r15, r16);
        return;
    L8:
        u(r10, r11, r12, r13, r14, r15, r16);
    }

    public final void o(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = 0.0f;
        if (Float.isNaN(this.f1864m) == false) goto L5;
        float r17 = 0.0f;
    L7:
        if (Float.isNaN(this.f1867p) == false) goto L9;
        float r18 = 0.0f;
    L11:
        if (Float.isNaN(this.f1865n) == false) goto L13;
        float r19 = 0.0f;
    L15:
        if (Float.isNaN(this.f1866o) == true) goto L18;
        r16 = this.f1866o;
    L18:
        this.f1869r = (int) ((r10 + (r17 * r14)) + (r16 * r15));
        this.f1870s = (int) ((r11 + (r14 * r18)) + (r15 * r19));
        return;
    L13:
        r19 = this.f1865n;
        goto L15
    L9:
        r18 = this.f1867p;
        goto L11
    L5:
        r17 = this.f1864m;
        goto L7
    }

    public final void p(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = this.f1864m;
        float r17 = r10 + (r14 * r16);
        float r18 = this.f1865n;
        this.f1869r = r17 + ((-r15) * r18);
        this.f1870s = (r11 + (r15 * r16)) + (r14 * r18);
    }

    public void q(int r10, int r11, float r12, float r13, float r14, float r15) {
        int r16 = this.f1868q;
        if (r16 != 1) goto L5;
        p(r12, r13, r14, r15);
        return;
    L5:
        if (r16 == 2) goto L8;
        o(r12, r13, r14, r15);
        return;
    L8:
        r(r10, r11);
    }

    public final void r(int r10, int r11) {
        float r12 = this.f1864m;
        float r13 = 0;
        this.f1869r = (r10 * r12) + r13;
        this.f1870s = (r11 * r12) + r13;
    }

    public void s(RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
        float r16 = r10.centerX();
        float r17 = r10.centerY();
        float r18 = r11.centerX();
        float r19 = r18 - r16;
        float r20 = r11.centerY() - r17;
        String r21 = r14[0];
        if (r21 != null) goto L5;
        r14[0] = "percentX";
        r15[0] = (r12 - r16) / r19;
        r14[1] = "percentY";
        r15[1] = (r13 - r17) / r20;
        return;
    L5:
        if ("percentX".equals(r21) == false) goto L7;
        r15[0] = (r12 - r16) / r19;
        r15[1] = (r13 - r17) / r20;
        return;
    L7:
        r15[1] = (r12 - r16) / r19;
        r15[0] = (r13 - r17) / r20;
    }

    public void t(RectF r10, RectF r11, float r12, float r13, String[] r14, float[] r15) {
        float r16 = r10.centerX();
        float r17 = r10.centerY();
        float r18 = r11.centerX() - r16;
        float r19 = r11.centerY() - r17;
        float r20 = (float) Math.hypot(r18, r19);
        if (r20 >= 1.0E-4d) goto L6;
        System.out.println("distance ~ 0");
        r15[0] = 0.0f;
        r15[1] = 0.0f;
        return;
    L6:
        float r21 = r18 / r20;
        float r22 = r19 / r20;
        float r110 = r13 - r17;
        float r23 = r12 - r16;
        float r24 = ((r21 * r110) - (r23 * r22)) / r20;
        float r25 = ((r21 * r23) + (r22 * r110)) / r20;
        String r26 = r14[0];
        if (r26 != null) goto L9;
        r14[0] = "percentX";
        r14[1] = "percentY";
        r15[0] = r25;
        r15[1] = r24;
        return;
    L9:
        if ("percentX".equals(r26) == false) goto L13;
        r15[0] = r25;
        r15[1] = r24;
        return;
    }

    public void u(View r10, RectF r11, RectF r12, float r13, float r14, String[] r15, float[] r16) {
        r11.centerX();
        r11.centerY();
        r12.centerX();
        r12.centerY();
        ViewGroup r17 = (ViewGroup) r10.getParent();
        int r18 = r17.getWidth();
        int r19 = r17.getHeight();
        String r20 = r15[0];
        if (r20 != null) goto L5;
        r15[0] = "percentX";
        r16[0] = r13 / r18;
        r15[1] = "percentY";
        r16[1] = r14 / r19;
        return;
    L5:
        if ("percentX".equals(r20) == false) goto L7;
        r16[0] = r13 / r18;
        r16[1] = r14 / r19;
        return;
    L7:
        r16[1] = r13 / r18;
        r16[0] = r14 / r19;
    }

    public void v(int r10) {
        this.f1868q = r10;
    }

    public void w(String r10, Object r11) {
        r10.hashCode();
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1812823328: goto L30;
            case -1127236479: goto L26;
            case -1017587252: goto L22;
            case -827014263: goto L18;
            case -200259324: goto L14;
            case 428090547: goto L10;
            case 428090548: goto L6;
            default: goto L33;
        };
    L33:
        switch(r12) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L49;
        };
    L35:
        this.f1865n = k(r11);
        return;
    L36:
        this.f1864m = k(r11);
        return;
    L37:
        float r13 = k(r11);
        this.f1862k = r13;
        this.f1863l = r13;
        return;
    L38:
        this.f1861j = l(r11);
        return;
    L39:
        this.f1863l = k(r11);
        return;
    L40:
        this.f1862k = k(r11);
        return;
    L41:
        this.f1859h = r11.toString();
        return;
    L49:
        return;
    L6:
        if (r10.equals("percentY") == false) goto L33;
        r12 = 6;
        goto L33
    L10:
        if (r10.equals("percentX") == false) goto L33;
        r12 = 5;
        goto L33
    L14:
        if (r10.equals("sizePercent") == false) goto L33;
        r12 = 4;
        goto L33
    L18:
        if (r10.equals("drawPath") == false) goto L33;
        r12 = 3;
        goto L33
    L22:
        if (r10.equals("percentHeight") == false) goto L33;
        r12 = 2;
        goto L33
    L26:
        if (r10.equals("percentWidth") == false) goto L33;
        r12 = 1;
        goto L33
    L30:
        if (r10.equals("transitionEasing") == false) goto L33;
        r12 = 0;
        goto L33
    }
}
