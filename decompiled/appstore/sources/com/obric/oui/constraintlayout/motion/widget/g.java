package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class g extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13691h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13692i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13696m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13697n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13698o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13699p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13700q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13701r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13702s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f13703a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f13703a = r10;
            r10.append(R$styleable.KeyPosition_motionTarget, 1);
            f13703a.append(R$styleable.KeyPosition_framePosition, 2);
            f13703a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f13703a.append(R$styleable.KeyPosition_curveFit, 4);
            f13703a.append(R$styleable.KeyPosition_drawPath, 5);
            f13703a.append(R$styleable.KeyPosition_percentX, 6);
            f13703a.append(R$styleable.KeyPosition_percentY, 7);
            f13703a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f13703a.append(R$styleable.KeyPosition_sizePercent, 8);
            f13703a.append(R$styleable.KeyPosition_percentWidth, 11);
            f13703a.append(R$styleable.KeyPosition_percentHeight, 12);
            f13703a.append(R$styleable.KeyPosition_pathMotionArc, 10);
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
            switch(f13703a.get(r14)) {
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
            Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(r14) + "   " + f13703a.get(r14));
        L31:
            r13 = r13 + 1;
            goto L4
        L8:
            r10.f13695l = r11.getFloat(r14, r10.f13695l);
            goto L31
        L9:
            r10.f13694k = r11.getFloat(r14, r10.f13694k);
            goto L31
        L10:
            r10.f13692i = r11.getInt(r14, r10.f13692i);
            goto L31
        L11:
            r10.f13700q = r11.getInt(r14, r10.f13700q);
            goto L31
        L12:
            float r15 = r11.getFloat(r14, r10.f13695l);
            r10.f13694k = r15;
            r10.f13695l = r15;
            goto L31
        L13:
            r10.f13697n = r11.getFloat(r14, r10.f13697n);
            goto L31
        L14:
            r10.f13696m = r11.getFloat(r14, r10.f13696m);
            goto L31
        L15:
            r10.f13693j = r11.getInt(r14, r10.f13693j);
            goto L31
        L16:
            r10.f13704g = r11.getInteger(r14, r10.f13704g);
            goto L31
        L21:
            r10.f13645a = r11.getInt(r14, r10.f13645a);
            goto L31
        L18:
            if (r11.peekValue(r14).type != 3) goto L20;
            r10.f13691h = r11.getString(r14);
            goto L31
        L20:
            r10.f13691h = vc.c.f25151c[r11.getInteger(r14, 0)];
            goto L31
        L23:
            if (MotionLayout.f13558d1 == false) goto L28;
            int r16 = r11.getResourceId(r14, r10.f13646b);
            r10.f13646b = r16;
            if (r16 != (-1)) goto L31;
            r10.f13647c = r11.getString(r14);
            goto L31
        L28:
            if (r11.peekValue(r14).type != 3) goto L30;
            r10.f13647c = r11.getString(r14);
            goto L31
        L30:
            r10.f13646b = r11.getResourceId(r14, r10.f13646b);
            goto L31
        L33:
            if (r10.f13645a != (-1)) goto L54;
            Log.e("KeyPosition", "no frame position");
            return;
        }
    }

    public g() {
        this.f13691h = null;
        this.f13692i = c.f13644f;
        this.f13693j = 0;
        this.f13694k = Float.NaN;
        this.f13695l = Float.NaN;
        this.f13696m = Float.NaN;
        this.f13697n = Float.NaN;
        this.f13698o = Float.NaN;
        this.f13699p = Float.NaN;
        this.f13700q = 0;
        this.f13701r = Float.NaN;
        this.f13702s = Float.NaN;
        this.f13648d = 2;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c b() {
        return new g().c(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        g r11 = (g) r10;
        this.f13691h = r11.f13691h;
        this.f13692i = r11.f13692i;
        this.f13693j = r11.f13693j;
        this.f13694k = r11.f13694k;
        this.f13695l = Float.NaN;
        this.f13696m = r11.f13696m;
        this.f13697n = r11.f13697n;
        this.f13698o = r11.f13698o;
        this.f13699p = r11.f13699p;
        this.f13701r = r11.f13701r;
        this.f13702s = r11.f13702s;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyPosition));
    }

    public void m(int r10) {
        this.f13700q = r10;
    }

    public void n(String r10, Object r11) {
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
        this.f13697n = k(r11);
        return;
    L36:
        this.f13696m = k(r11);
        return;
    L37:
        float r13 = k(r11);
        this.f13694k = r13;
        this.f13695l = r13;
        return;
    L38:
        this.f13693j = l(r11);
        return;
    L39:
        this.f13695l = k(r11);
        return;
    L40:
        this.f13694k = k(r11);
        return;
    L41:
        this.f13691h = r11.toString();
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
