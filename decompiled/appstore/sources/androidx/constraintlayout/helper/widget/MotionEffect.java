package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.motion.widget.d;
import androidx.constraintlayout.motion.widget.g;
import androidx.constraintlayout.motion.widget.l;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionEffect extends MotionHelper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1714p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1715q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1716r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1717s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1718t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1719u;

    public MotionEffect(Context r10) {
        super(r10);
        this.f1712n = 0.1f;
        this.f1713o = 49;
        this.f1714p = 50;
        this.f1715q = 0;
        this.f1716r = 0;
        this.f1717s = true;
        this.f1718t = -1;
        this.f1719u = -1;
    }

    private void u(Context r10, AttributeSet r11) {
        if (r11 == null) goto L47;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.MotionEffect);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L30;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MotionEffect_motionEffect_start) goto L9;
        int r16 = r12.getInt(r15, this.f1713o);
        this.f1713o = r16;
        this.f1713o = Math.max(Math.min(r16, 99), 0);
    L29:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.MotionEffect_motionEffect_end) goto L12;
        int r17 = r12.getInt(r15, this.f1714p);
        this.f1714p = r17;
        this.f1714p = Math.max(Math.min(r17, 99), 0);
        goto L29
    L12:
        if (r15 != R$styleable.MotionEffect_motionEffect_translationX) goto L15;
        this.f1715q = r12.getDimensionPixelOffset(r15, this.f1715q);
        goto L29
    L15:
        if (r15 != R$styleable.MotionEffect_motionEffect_translationY) goto L18;
        this.f1716r = r12.getDimensionPixelOffset(r15, this.f1716r);
        goto L29
    L18:
        if (r15 != R$styleable.MotionEffect_motionEffect_alpha) goto L21;
        this.f1712n = r12.getFloat(r15, this.f1712n);
        goto L29
    L21:
        if (r15 != R$styleable.MotionEffect_motionEffect_move) goto L24;
        this.f1719u = r12.getInt(r15, this.f1719u);
        goto L29
    L24:
        if (r15 != R$styleable.MotionEffect_motionEffect_strict) goto L27;
        this.f1717s = r12.getBoolean(r15, this.f1717s);
        goto L29
    L27:
        if (r15 != R$styleable.MotionEffect_motionEffect_viewTransition) goto L29;
        this.f1718t = r12.getResourceId(r15, this.f1718t);
        goto L29
    L30:
        int r18 = this.f1713o;
        int r19 = this.f1714p;
        if (r18 != r19) goto L35;
        if (r18 <= 0) goto L34;
        this.f1713o = r18 - 1;
        goto L35
    L34:
        this.f1714p = r19 + 1;
    L35:
        r12.recycle();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isDecorator() {
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreSetup(MotionLayout r23, HashMap r24) {
        HashMap r10 = r24;
        View[] r11 = j((ConstraintLayout) getParent());
        if (r11 != null) goto L6;
        Log.v("FadeMove", a.a() + " views = null");
        return;
    L6:
        d r12 = new d();
        d r13 = new d();
        r12.R("alpha", Float.valueOf(this.f1712n));
        r13.R("alpha", Float.valueOf(this.f1712n));
        r12.g(this.f1713o);
        r13.g(this.f1714p);
        g r14 = new g();
        r14.g(this.f1713o);
        r14.v(0);
        r14.w("percentX", 0);
        r14.w("percentY", 0);
        g r15 = new g();
        r15.g(this.f1714p);
        r15.v(0);
        int r16 = 1;
        r15.w("percentX", 1);
        r15.w("percentY", 1);
        d r17 = null;
        if (this.f1715q <= 0) goto L9;
        d r18 = new d();
        d r19 = new d();
        r18.R("translationX", Integer.valueOf(this.f1715q));
        r18.g(this.f1714p);
        r19.R("translationX", 0);
        r19.g(this.f1714p - 1);
    L11:
        if (this.f1716r <= 0) goto L13;
        r17 = new d();
        d r110 = new d();
        r17.R("translationY", Integer.valueOf(this.f1716r));
        r17.g(this.f1714p);
        r110.R("translationY", 0);
        r110.g(this.f1714p - 1);
    L14:
        int r111 = this.f1719u;
        if (r111 != (-1)) goto L42;
        int[] r112 = new int[4];
        int r113 = 0;
    L18:
        if (r113 >= r11.length) goto L35;
        l r114 = (l) r10.get(r11[r113]);
        if (r114 == null) goto L34;
        float r20 = r114.o() - r114.w();
        float r21 = r114.p() - r114.x();
        if (r21 >= 0.0f) goto L26;
        r112[1] = r112[1] + 1;
    L26:
        if (r21 <= 0.0f) goto L29;
        r112[0] = r112[0] + 1;
    L29:
        if (r20 <= 0.0f) goto L32;
        r112[3] = r112[3] + 1;
    L32:
        if (r20 >= 0.0f) goto L34;
        r112[2] = r112[2] + 1;
    L34:
        r113 = r113 + 1;
        goto L18
    L35:
        int r115 = r112[0];
        r111 = 0;
    L37:
        if (r16 >= 4) goto L42;
        int r22 = r112[r16];
        if (r115 >= r22) goto L41;
        r115 = r22;
        r111 = r16;
    L41:
        r16 = r16 + 1;
    L42:
        int r25 = 0;
    L44:
        if (r25 >= r11.length) goto L97;
        l r116 = (l) r10.get(r11[r25]);
        if (r116 == null) goto L96;
        float r117 = r116.o() - r116.w();
        float r118 = r116.p() - r116.x();
        if (r111 != 0) goto L60;
        if (r118 <= 0.0f) goto L86;
        if (this.f1717s == false) goto L96;
        if (r117 == 0.0f) goto L96;
    L86:
        int r119 = this.f1718t;
        if (r119 != (-1)) goto L95;
        r116.a(r12);
        r116.a(r13);
        r116.a(r14);
        r116.a(r15);
        if (this.f1715q <= 0) goto L92;
        r116.a(r18);
        r116.a(r19);
    L92:
        if (this.f1716r <= 0) goto L96;
        r116.a(r17);
        r116.a(r110);
        goto L96
    L95:
        r23.E(r119, r116);
        goto L96
    L60:
        if (r111 != 1) goto L69;
        if (r118 >= 0.0f) goto L86;
        if (this.f1717s == false) goto L96;
        if (r117 != 0.0f) goto L86;
    L69:
        if (r111 != 2) goto L78;
        if (r117 >= 0.0f) goto L86;
        if (this.f1717s == false) goto L96;
        if (r118 != 0.0f) goto L86;
    L78:
        if (r111 != 3) goto L86;
        if (r117 <= 0.0f) goto L86;
        if (this.f1717s == false) goto L96;
        if (r118 != 0.0f) goto L86;
    L96:
        r25 = r25 + 1;
        r10 = r24;
        goto L44
    L97:
        return;
    L13:
        r110 = null;
        goto L14
    L9:
        r18 = null;
        r19 = null;
        goto L11
    }

    public MotionEffect(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f1712n = 0.1f;
        this.f1713o = 49;
        this.f1714p = 50;
        this.f1715q = 0;
        this.f1716r = 0;
        this.f1717s = true;
        this.f1718t = -1;
        this.f1719u = -1;
        u(r10, r11);
    }

    public MotionEffect(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f1712n = 0.1f;
        this.f1713o = 49;
        this.f1714p = 50;
        this.f1715q = 0;
        this.f1716r = 0;
        this.f1717s = true;
        this.f1718t = -1;
        this.f1719u = -1;
        u(r10, r11);
    }
}
