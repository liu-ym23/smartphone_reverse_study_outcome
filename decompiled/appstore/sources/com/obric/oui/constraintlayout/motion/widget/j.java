package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class j extends c {
    public boolean A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f13728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f13729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f13730m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13732o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13733p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f13734q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f13735r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13736s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13737t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f13738u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13739v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13740w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13741x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13742y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f13743z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SparseIntArray f13744a;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f13744a = r10;
            r10.append(R$styleable.KeyTrigger_framePosition, 8);
            f13744a.append(R$styleable.KeyTrigger_onCross, 4);
            f13744a.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            f13744a.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            f13744a.append(R$styleable.KeyTrigger_motionTarget, 7);
            f13744a.append(R$styleable.KeyTrigger_triggerId, 6);
            f13744a.append(R$styleable.KeyTrigger_triggerSlack, 5);
            f13744a.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f13744a.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f13744a.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            f13744a.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            f13744a.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f13744a.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(j r10, TypedArray r11, Context r12) {
            int r13 = r11.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L29;
            int r15 = r11.getIndex(r14);
            switch(f13744a.get(r15)) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L6;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L6:
            Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(r15) + "   " + f13744a.get(r15));
        L28:
            r14 = r14 + 1;
            goto L3
        L7:
            r10.f13726i = r11.getResourceId(r15, r10.f13726i);
            goto L28
        L8:
            r10.f13725h = r11.getResourceId(r15, r10.f13725h);
            goto L28
        L9:
            r10.f13727j = r11.getResourceId(r15, r10.f13727j);
            goto L28
        L10:
            j.x(r10, r11.getResourceId(r15, j.w(r10)));
            goto L28
        L11:
            j.v(r10, r11.getBoolean(r15, j.u(r10)));
            goto L28
        L12:
            j.t(r10, r11.getResourceId(r15, j.s(r10)));
            goto L28
        L13:
            int r16 = r11.getInteger(r15, r10.f13645a);
            r10.f13645a = r16;
            j.m(r10, (r16 + 0.5f) / 100.0f);
            goto L28
        L23:
            j.r(r10, r11.getResourceId(r15, j.q(r10)));
            goto L28
        L24:
            r10.f13724g = r11.getFloat(r15, r10.f13724g);
            goto L28
        L25:
            j.p(r10, r11.getString(r15));
            goto L28
        L26:
            j.o(r10, r11.getString(r15));
            goto L28
        L27:
            j.n(r10, r11.getString(r15));
            goto L28
        L15:
            if (MotionLayout.f13558d1 == false) goto L20;
            int r17 = r11.getResourceId(r15, r10.f13646b);
            r10.f13646b = r17;
            if (r17 != (-1)) goto L28;
            r10.f13647c = r11.getString(r15);
            goto L28
        L20:
            if (r11.peekValue(r15).type != 3) goto L22;
            r10.f13647c = r11.getString(r15);
            goto L28
        L22:
            r10.f13646b = r11.getResourceId(r15, r10.f13646b);
            goto L28
        }
    }

    public j() {
        this.f13724g = 0.1f;
        int r10 = c.f13644f;
        this.f13725h = r10;
        this.f13726i = r10;
        this.f13727j = r10;
        this.f13728k = new RectF();
        this.f13729l = new RectF();
        this.f13730m = new HashMap();
        this.f13731n = -1;
        this.f13732o = null;
        int r11 = c.f13644f;
        this.f13733p = r11;
        this.f13734q = null;
        this.f13735r = null;
        this.f13736s = r11;
        this.f13737t = r11;
        this.f13738u = null;
        this.f13739v = true;
        this.f13740w = true;
        this.f13741x = true;
        this.f13742y = Float.NaN;
        this.A = false;
        this.f13648d = 5;
        this.f13649e = new HashMap();
    }

    public static /* synthetic */ float m(j r10, float r11) {
        r10.f13742y = r11;
        return r11;
    }

    public static /* synthetic */ String n(j r10, String r11) {
        r10.f13734q = r11;
        return r11;
    }

    public static /* synthetic */ String o(j r10, String r11) {
        r10.f13735r = r11;
        return r11;
    }

    public static /* synthetic */ String p(j r10, String r11) {
        r10.f13732o = r11;
        return r11;
    }

    public static /* synthetic */ int q(j r10) {
        return r10.f13736s;
    }

    public static /* synthetic */ int r(j r10, int r11) {
        r10.f13736s = r11;
        return r11;
    }

    public static /* synthetic */ int s(j r10) {
        return r10.f13737t;
    }

    public static /* synthetic */ int t(j r10, int r11) {
        r10.f13737t = r11;
        return r11;
    }

    public static /* synthetic */ boolean u(j r10) {
        return r10.A;
    }

    public static /* synthetic */ boolean v(j r10, boolean r11) {
        r10.A = r11;
        return r11;
    }

    public static /* synthetic */ int w(j r10) {
        return r10.f13733p;
    }

    public static /* synthetic */ int x(j r10, int r11) {
        r10.f13733p = r11;
        return r11;
    }

    public final void A(String r10, View r11) {
        if (r10.length() != 1) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        r10 = r10.substring(1).toLowerCase(Locale.ROOT);
    L8:
        Iterator r13 = this.f13649e.keySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        String r15 = r14.toLowerCase(Locale.ROOT);
        if (r12 == true) goto L15;
        if (r15.matches(r10) == false) goto L10;
    L15:
        ConstraintAttribute r16 = (ConstraintAttribute) this.f13649e.get(r14);
        if (r16 == null) goto L10;
        r16.a(r11);
        goto L10
    L18:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void B(RectF r10, View r11, boolean r12) {
        r10.top = r11.getTop();
        r10.bottom = r11.getBottom();
        r10.left = r11.getLeft();
        r10.right = r11.getRight();
        if (r12 == false) goto L6;
        r11.getMatrix().mapRect(r10);
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void a(HashMap r10) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c b() {
        return new j().c(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public c c(c r10) {
        super.c(r10);
        j r11 = (j) r10;
        this.f13731n = r11.f13731n;
        this.f13732o = r11.f13732o;
        this.f13733p = r11.f13733p;
        this.f13734q = r11.f13734q;
        this.f13735r = r11.f13735r;
        this.f13736s = r11.f13736s;
        this.f13737t = r11.f13737t;
        this.f13738u = r11.f13738u;
        this.f13724g = r11.f13724g;
        this.f13739v = r11.f13739v;
        this.f13740w = r11.f13740w;
        this.f13741x = r11.f13741x;
        this.f13742y = r11.f13742y;
        this.f13743z = r11.f13743z;
        this.A = r11.A;
        this.f13728k = r11.f13728k;
        this.f13729l = r11.f13729l;
        this.f13730m = r11.f13730m;
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void d(HashSet r10) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public void e(Context r10, AttributeSet r11) {
        a.a(this, r10.obtainStyledAttributes(r11, R$styleable.KeyTrigger), r10);
    }

    public void y(float r10, View r11) {
        boolean r12 = true;
        boolean r13 = false;
        if (this.f13737t == c.f13644f) goto L28;
        if (this.f13738u != null) goto L7;
        this.f13738u = ((ViewGroup) r11.getParent()).findViewById(this.f13737t);
    L7:
        B(this.f13728k, this.f13738u, this.A);
        B(this.f13729l, r11, this.A);
        if (this.f13728k.intersect(this.f13729l) == false) goto L19;
        if (this.f13739v == false) goto L12;
        this.f13739v = false;
        boolean r14 = true;
    L14:
        if (this.f13741x == false) goto L16;
        this.f13741x = false;
        boolean r15 = true;
    L17:
        this.f13740w = true;
    L61:
        this.f13743z = r10;
        if (r13 == true) goto L65;
        if (r14 == true) goto L65;
        if (r15 == true) goto L65;
    L67:
        if (this.f13733p != c.f13644f) goto L69;
        View r16 = r11;
    L70:
        if (r13 == false) goto L77;
        String r17 = this.f13734q;
        if (r17 == null) goto L75;
        z(r17, r16);
    L75:
        if (this.f13725h == c.f13644f) goto L77;
        ((MotionLayout) r11.getParent()).K0(this.f13725h, new View[]{r16});
    L77:
        if (r15 == false) goto L84;
        String r18 = this.f13735r;
        if (r18 == null) goto L82;
        z(r18, r16);
    L82:
        if (this.f13726i == c.f13644f) goto L84;
        ((MotionLayout) r11.getParent()).K0(this.f13726i, new View[]{r16});
    L84:
        if (r14 == false) goto L92;
        String r19 = this.f13732o;
        if (r19 == null) goto L89;
        z(r19, r16);
    L89:
        if (this.f13727j == c.f13644f) goto L93;
        ((MotionLayout) r11.getParent()).K0(this.f13727j, new View[]{r16});
        return;
    L93:
        return;
    L92:
        return;
    L69:
        r16 = ((MotionLayout) r11.getParent()).findViewById(this.f13733p);
    L65:
        ((MotionLayout) r11.getParent()).h0(this.f13736s, r15, r10);
        goto L67
    L16:
        r15 = false;
        goto L17
    L12:
        r14 = false;
        goto L14
    L19:
        if (this.f13739v == true) goto L21;
        this.f13739v = true;
        r14 = true;
    L23:
        if (this.f13740w == false) goto L25;
        this.f13740w = false;
        boolean r20 = true;
    L26:
        this.f13741x = true;
        r13 = r20;
        r15 = false;
        goto L61
    L25:
        r20 = false;
        goto L26
    L21:
        r14 = false;
        goto L23
    L28:
        if (this.f13739v == false) goto L33;
        float r21 = this.f13742y;
        if (((r10 - r21) * (this.f13743z - r21)) >= 0.0f) goto L35;
        this.f13739v = false;
        r14 = true;
    L37:
        if (this.f13740w == false) goto L44;
        float r22 = this.f13742y;
        float r23 = r10 - r22;
        if (((this.f13743z - r22) * r23) < 0.0f) goto L41;
    L46:
        boolean r24 = false;
    L48:
        if (this.f13741x == false) goto L58;
        float r25 = this.f13742y;
        float r26 = r10 - r25;
        if (((this.f13743z - r25) * r26) < 0.0f) goto L52;
    L54:
        r12 = false;
    L55:
        r15 = r12;
    L56:
        r13 = r24;
        goto L61
    L52:
        if (r26 <= 0.0f) goto L54;
        this.f13741x = false;
        goto L55
    L58:
        if (Math.abs(r10 - this.f13742y) <= this.f13724g) goto L60;
        this.f13741x = true;
    L60:
        r15 = false;
        goto L56
    L41:
        if (r23 >= 0.0f) goto L46;
        this.f13740w = false;
        r24 = true;
        goto L48
    L44:
        if (Math.abs(r10 - this.f13742y) <= this.f13724g) goto L46;
        this.f13740w = true;
    L35:
        r14 = false;
        goto L37
    L33:
        if (Math.abs(r10 - this.f13742y) <= this.f13724g) goto L35;
        this.f13739v = true;
        goto L35
    }

    public final void z(String r10, View r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.startsWith(LibrarianImpl.Constants.DOT) == false) goto L9;
        A(r10, r11);
        return;
    L9:
        if (this.f13730m.containsKey(r10) == false) goto L13;
        Method r12 = (Method) this.f13730m.get(r10);
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12 == null) goto L26;
    L24:
        r12.invoke(r11, null);     // Catch: Exception -> L22
        return;
    L22:
        Log.e("KeyTrigger", "Exception in call \"" + this.f13732o + "\"on class " + r11.getClass().getSimpleName() + " " + com.obric.oui.constraintlayout.motion.widget.a.d(r11));
        return;
    L26:
        r12 = r11.getClass().getMethod(r10, null);     // Catch: NoSuchMethodException -> L18
        this.f13730m.put(r10, r12);     // Catch: NoSuchMethodException -> L18
    L18:
        this.f13730m.put(r10, null);
        Log.e("KeyTrigger", "Could not find method \"" + r10 + "\"on class " + r11.getClass().getSimpleName() + " " + com.obric.oui.constraintlayout.motion.widget.a.d(r11));
        return;
    L13:
        r12 = null;
        goto L15
    }
}
