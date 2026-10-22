package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$id;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f13897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.obric.oui.constraintlayout.widget.a.C0195a f13898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f13902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13904m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Context f13906o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13907p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13908q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13909r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13910s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13913v;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vc.c f13914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f13915b;

        public a(r r10, vc.c r11) {
            this.f13915b = r10;
            this.f13914a = r11;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            return (float) this.f13914a.a(r10);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f13918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l f13919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13920e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13921f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public vc.d f13922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public s f13923h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Interpolator f13924i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f13925j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f13926k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f13927l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f13928m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Rect f13929n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f13930o;

        public b(s r10, l r11, int r12, int r13, int r14, Interpolator r15, int r16, int r17) {
            this.f13922g = new vc.d();
            this.f13925j = false;
            this.f13929n = new Rect();
            this.f13930o = false;
            this.f13923h = r10;
            this.f13919d = r11;
            this.f13920e = r12;
            this.f13921f = r13;
            long r18 = System.nanoTime();
            this.f13918c = r18;
            this.f13928m = r18;
            this.f13923h.c(this);
            this.f13924i = r15;
            this.f13916a = r16;
            this.f13917b = r17;
            if (r14 != 3) goto L5;
            this.f13930o = true;
        L5:
            if (r12 != 0) goto L7;
            float r19 = Float.MAX_VALUE;
        L8:
            this.f13927l = r19;
            a();
            return;
        L7:
            r19 = 1.0f / r12;
            goto L8
        }

        public void a() {
            if (this.f13925j == false) goto L5;
            c();
            return;
        L5:
            b();
        }

        public void b() {
            long r10 = System.nanoTime();
            long r11 = r10 - this.f13928m;
            this.f13928m = r10;
            float r12 = this.f13926k + (((float) (r11 * 1.0E-6d)) * this.f13927l);
            this.f13926k = r12;
            if (r12 < 1.0f) goto L5;
            this.f13926k = 1.0f;
        L5:
            Interpolator r13 = this.f13924i;
            if (r13 != null) goto L9;
            float r14 = this.f13926k;
        L8:
            float r15 = r14;
            l r16 = this.f13919d;
            boolean r17 = r16.x(r16.f13773b, r15, r10, this.f13922g);
            if (this.f13926k < 1.0f) goto L22;
            if (this.f13916a == (-1)) goto L16;
            this.f13919d.v().setTag(this.f13916a, Long.valueOf(System.nanoTime()));
        L16:
            if (this.f13917b == (-1)) goto L19;
            this.f13919d.v().setTag(this.f13917b, null);
        L19:
            if (this.f13930o == true) goto L22;
            this.f13923h.h(this);
        L22:
            if (this.f13926k < 1.0f) goto L24;
            if (r17 == true) goto L24;
            return;
        L24:
            this.f13923h.f();
            return;
        L9:
            r14 = r13.getInterpolation(this.f13926k);
            goto L8
        }

        public void c() {
            long r10 = System.nanoTime();
            long r11 = r10 - this.f13928m;
            this.f13928m = r10;
            float r12 = this.f13926k - (((float) (r11 * 1.0E-6d)) * this.f13927l);
            this.f13926k = r12;
            if (r12 >= 0.0f) goto L5;
            this.f13926k = 0.0f;
        L5:
            Interpolator r13 = this.f13924i;
            if (r13 != null) goto L9;
            float r14 = this.f13926k;
        L8:
            float r15 = r14;
            l r16 = this.f13919d;
            boolean r17 = r16.x(r16.f13773b, r15, r10, this.f13922g);
            if (this.f13926k > 0.0f) goto L20;
            if (this.f13916a == (-1)) goto L16;
            this.f13919d.v().setTag(this.f13916a, Long.valueOf(System.nanoTime()));
        L16:
            if (this.f13917b == (-1)) goto L18;
            this.f13919d.v().setTag(this.f13917b, null);
        L18:
            this.f13923h.h(this);
        L20:
            if (this.f13926k > 0.0f) goto L22;
            if (r17 == true) goto L22;
            return;
        L22:
            this.f13923h.f();
            return;
        L9:
            r14 = r13.getInterpolation(this.f13926k);
            goto L8
        }

        public void d(int r10, float r11, float r12) {
            if (r10 == 1) goto L14;
            if (r10 != 2) goto L19;
            this.f13919d.v().getHitRect(this.f13929n);
            if (this.f13929n.contains((int) r11, (int) r12) == false) goto L10;
            return;
        L10:
            if (this.f13925j == true) goto L18;
            e(true);
            return;
        L18:
            return;
        L19:
            return;
        L14:
            if (this.f13925j == true) goto L20;
            e(true);
            return;
        }

        public void e(boolean r10) {
            this.f13925j = r10;
            if (r10 == false) goto L10;
            int r11 = this.f13921f;
            if (r11 == (-1)) goto L10;
            if (r11 != 0) goto L8;
            float r12 = Float.MAX_VALUE;
        L9:
            this.f13927l = r12;
            goto L10
        L8:
            r12 = 1.0f / r11;
        L10:
            this.f13923h.f();
            this.f13928m = System.nanoTime();
        }
    }

    public r(Context r11, XmlPullParser r12) {
        this.f13893b = -1;
        this.f13894c = false;
        this.f13895d = 0;
        this.f13899h = -1;
        this.f13900i = -1;
        this.f13903l = 0;
        this.f13904m = null;
        this.f13905n = -1;
        this.f13907p = -1;
        this.f13908q = -1;
        this.f13909r = -1;
        this.f13910s = -1;
        this.f13911t = -1;
        this.f13912u = -1;
        this.f13913v = -1;
        this.f13906o = r11;
        int r10 = r12.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L5:
        if (r10 == 1) goto L64;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L11;
    L46:
        r10 = r12.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L11:
        if ("ViewTransition".equals(r12.getName()) == false) goto L46;
        return;
    L17:
        String r13 = r12.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        switch(r13.hashCode()) {
            case -1962203927: goto L33;
            case -1239391468: goto L30;
            case 61998586: goto L27;
            case 366511058: goto L24;
            case 1791837707: goto L21;
            default: goto L35;
        };     // Catch: IOException -> L13 XmlPullParserException -> L15
    L35:
        byte r14 = -1;
    L36:
        if (r14 == 0) goto L45;
        if (r14 == 1) goto L44;
        if (r14 == 2) goto L43;
        if (r14 == 3) goto L42;
        if (r14 == 4) goto L42;
        Log.e("ViewTransition", com.obric.oui.constraintlayout.motion.widget.a.a() + " unknown tag " + r13);     // Catch: IOException -> L13 XmlPullParserException -> L15
        StringBuilder r15 = new StringBuilder();     // Catch: IOException -> L13 XmlPullParserException -> L15
        r15.append(".xml:");     // Catch: IOException -> L13 XmlPullParserException -> L15
        r15.append(r12.getLineNumber());     // Catch: IOException -> L13 XmlPullParserException -> L15
        Log.e("ViewTransition", r15.toString());     // Catch: IOException -> L13 XmlPullParserException -> L15
    L42:
        ConstraintAttribute.i(r11, r12, this.f13898g.f14178g);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L43:
        this.f13898g = com.obric.oui.constraintlayout.widget.a.m(r11, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L44:
        this.f13897f = new f(r11, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L45:
        m(r11, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L46
    L21:
        if (r13.equals("CustomAttribute") == false) goto L35;
        r14 = 3;
        goto L36
    L24:
        if (r13.equals("CustomMethod") == false) goto L35;
        r14 = 4;
        goto L36
    L27:
        if (r13.equals("ViewTransition") == false) goto L35;
        r14 = 0;
        goto L36
    L30:
        if (r13.equals("KeyFrameSet") == false) goto L35;
        r14 = 1;
        goto L36
    L33:
        if (r13.equals("ConstraintOverride") == false) goto L35;
        r14 = 2;
        goto L36
    L64:
        return;
    L13:
        e = move-exception;
        Log.e("ViewTransition", "Error parsing XML resource", e);
        return;
    L15:
        e = move-exception;
        Log.e("ViewTransition", "Error parsing XML resource", e);
    }

    public static /* synthetic */ void a(r r10, View[] r11) {
        r10.k(r11);
    }

    public void b(s r10, MotionLayout r11, View r12) {
        l r13 = new l(r12);
        r13.B(r12);
        this.f13897f.a(r13);
        r13.I(r11.getWidth(), r11.getHeight(), this.f13899h, System.nanoTime());
        new b(r10, r13, this.f13899h, this.f13900i, this.f13893b, f(r11.getContext()), this.f13907p, this.f13908q);
    }

    public void c(s r10, MotionLayout r11, int r12, com.obric.oui.constraintlayout.widget.a r13, final View... r14) {
        if (this.f13894c == false) goto L5;
        return;
    L5:
        int r15 = this.f13896e;
        int r16 = 0;
        if (r15 != 2) goto L10;
        b(r10, r11, r14[0]);
        return;
    L10:
        if (r15 != 1) goto L24;
        int[] r17 = r11.getConstraintSetIds();
        int r18 = 0;
    L13:
        if (r18 >= r17.length) goto L24;
        int r19 = r17[r18];
        if (r19 == r12) goto L23;
        com.obric.oui.constraintlayout.widget.a r20 = r11.j0(r19);
        int r21 = r14.length;
        int r22 = 0;
    L18:
        if (r22 >= r21) goto L23;
        com.obric.oui.constraintlayout.widget.a.C0195a r23 = r20.u(r14[r22].getId());
        com.obric.oui.constraintlayout.widget.a.C0195a r24 = this.f13898g;
        if (r24 == null) goto L22;
        r24.d(r23);
        r23.f14178g.putAll(this.f13898g.f14178g);
    L22:
        r22 = r22 + 1;
    L23:
        r18 = r18 + 1;
    L24:
        com.obric.oui.constraintlayout.widget.a r25 = new com.obric.oui.constraintlayout.widget.a();
        r25.p(r13);
        int r26 = r14.length;
        int r27 = 0;
    L25:
        if (r27 >= r26) goto L30;
        com.obric.oui.constraintlayout.widget.a.C0195a r28 = r25.u(r14[r27].getId());
        com.obric.oui.constraintlayout.widget.a.C0195a r29 = this.f13898g;
        if (r29 == null) goto L29;
        r29.d(r28);
        r28.f14178g.putAll(this.f13898g.f14178g);
    L29:
        r27 = r27 + 1;
        goto L25
    L30:
        r11.I0(r12, r25);
        int r30 = R$id.view_transition;
        r11.I0(r30, r13);
        r11.v0(r30, -1, -1);
        o.b r31 = new o.b(-1, r11.f13588z, r30, r12);
        int r32 = r14.length;
    L31:
        if (r16 >= r32) goto L33;
        p(r31, r14[r16]);
        r16 = r16 + 1;
        goto L31
    L33:
        r11.setTransition(r31);
        r11.B0(new q(this, r14));
    }

    public boolean d(View r10) {
        int r11 = this.f13909r;
        if (r11 != (-1)) goto L6;
    L4:
        boolean r12 = true;
    L9:
        int r13 = this.f13910s;
        if (r13 != (-1)) goto L13;
    L11:
        boolean r14 = true;
    L16:
        if (r12 == false) goto L20;
        if (r14 == true) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L13:
        if (r10.getTag(r13) == null) goto L11;
        r14 = false;
        goto L16
    L6:
        if (r10.getTag(r11) != null) goto L4;
        r12 = false;
        goto L9
    }

    public int e() {
        return this.f13892a;
    }

    public Interpolator f(Context r10) {
        int r11 = this.f13903l;
        if (r11 == (-2)) goto L34;
        if (r11 == (-1)) goto L32;
        if (r11 == 0) goto L30;
        if (r11 == 1) goto L28;
        if (r11 == 2) goto L26;
        if (r11 == 4) goto L24;
        if (r11 == 5) goto L22;
        if (r11 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L32:
        return new a(this, vc.c.c(this.f13904m));
    L34:
        return AnimationUtils.loadInterpolator(r10, this.f13905n);
    }

    public int g() {
        return this.f13911t;
    }

    public int h() {
        return this.f13913v;
    }

    public int i() {
        return this.f13912u;
    }

    public int j() {
        return this.f13893b;
    }

    public final /* synthetic */ void k(View[] r10) {
        int r11 = 0;
        if (this.f13907p == (-1)) goto L8;
        int r12 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L8;
        r10[r13].setTag(this.f13907p, Long.valueOf(System.nanoTime()));
        r13 = r13 + 1;
    L8:
        if (this.f13908q == (-1)) goto L12;
        int r14 = r10.length;
    L10:
        if (r11 >= r14) goto L15;
        r10[r11].setTag(this.f13908q, null);
        r11 = r11 + 1;
        goto L10
    L15:
        return;
    }

    public boolean l(View r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this.f13901j != (-1)) goto L11;
        if (this.f13902k != null) goto L11;
        return false;
    L11:
        if (d(r10) == true) goto L14;
        return false;
    L14:
        if (r10.getId() != this.f13901j) goto L17;
        return true;
    L17:
        if (this.f13902k != null) goto L20;
        return false;
    L20:
        if ((r10.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        String r11 = ((ConstraintLayout.LayoutParams) r10.getLayoutParams()).f14091c0;
        if (r11 == null) goto L26;
        if (r11.matches(this.f13902k) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public final void m(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.ViewTransition);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L70;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.ViewTransition_android_id) goto L8;
        this.f13892a = r12.getResourceId(r15, this.f13892a);
    L69:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r15 != R$styleable.ViewTransition_motionTarget) goto L19;
        if (MotionLayout.f13558d1 == false) goto L15;
        int r16 = r12.getResourceId(r15, this.f13901j);
        this.f13901j = r16;
        if (r16 != (-1)) goto L69;
        this.f13902k = r12.getString(r15);
        goto L69
    L15:
        if (r12.peekValue(r15).type != 3) goto L17;
        this.f13902k = r12.getString(r15);
        goto L69
    L17:
        this.f13901j = r12.getResourceId(r15, this.f13901j);
        goto L69
    L19:
        if (r15 != R$styleable.ViewTransition_onStateTransition) goto L22;
        this.f13893b = r12.getInt(r15, this.f13893b);
        goto L69
    L22:
        if (r15 != R$styleable.ViewTransition_transitionDisable) goto L25;
        this.f13894c = r12.getBoolean(r15, this.f13894c);
        goto L69
    L25:
        if (r15 != R$styleable.ViewTransition_pathMotionArc) goto L28;
        this.f13895d = r12.getInt(r15, this.f13895d);
        goto L69
    L28:
        if (r15 != R$styleable.ViewTransition_duration) goto L31;
        this.f13899h = r12.getInt(r15, this.f13899h);
        goto L69
    L31:
        if (r15 != R$styleable.ViewTransition_upDuration) goto L34;
        this.f13900i = r12.getInt(r15, this.f13900i);
        goto L69
    L34:
        if (r15 != R$styleable.ViewTransition_viewTransitionMode) goto L37;
        this.f13896e = r12.getInt(r15, this.f13896e);
        goto L69
    L37:
        if (r15 != R$styleable.ViewTransition_motionInterpolator) goto L52;
        int r17 = r12.peekValue(r15).type;
        if (r17 != 1) goto L43;
        int r18 = r12.getResourceId(r15, -1);
        this.f13905n = r18;
        if (r18 == (-1)) goto L69;
        this.f13903l = -2;
        goto L69
    L43:
        if (r17 != 3) goto L50;
        String r19 = r12.getString(r15);
        this.f13904m = r19;
        if (r19 != null) goto L47;
    L49:
        this.f13903l = -1;
        goto L69
    L47:
        if (r19.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L49;
        this.f13905n = r12.getResourceId(r15, -1);
        this.f13903l = -2;
        goto L69
    L50:
        this.f13903l = r12.getInteger(r15, this.f13903l);
        goto L69
    L52:
        if (r15 != R$styleable.ViewTransition_setsTag) goto L55;
        this.f13907p = r12.getResourceId(r15, this.f13907p);
        goto L69
    L55:
        if (r15 != R$styleable.ViewTransition_clearsTag) goto L58;
        this.f13908q = r12.getResourceId(r15, this.f13908q);
        goto L69
    L58:
        if (r15 != R$styleable.ViewTransition_ifTagSet) goto L61;
        this.f13909r = r12.getResourceId(r15, this.f13909r);
        goto L69
    L61:
        if (r15 != R$styleable.ViewTransition_ifTagNotSet) goto L64;
        this.f13910s = r12.getResourceId(r15, this.f13910s);
        goto L69
    L64:
        if (r15 != R$styleable.ViewTransition_SharedValueId) goto L67;
        this.f13912u = r12.getResourceId(r15, this.f13912u);
        goto L69
    L67:
        if (r15 != R$styleable.ViewTransition_SharedValue) goto L69;
        this.f13911t = r12.getInteger(r15, this.f13911t);
        goto L69
    L70:
        r12.recycle();
    }

    public void n(int r10) {
        this.f13913v = r10;
    }

    public boolean o(int r10) {
        int r11 = this.f13893b;
        if (r11 != 1) goto L8;
        if (r10 == 0) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r11 != 2) goto L13;
        if (r10 == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (r11 != 3) goto L19;
        if (r10 == 0) goto L16;
        return false;
    L16:
        return true;
    L19:
        return false;
    }

    public final void p(o.b r10, View r11) {
        int r12 = this.f13899h;
        if (r12 == (-1)) goto L5;
        r10.E(r12);
    L5:
        r10.I(this.f13895d);
        r10.G(this.f13903l, this.f13904m, this.f13905n);
        int r13 = r11.getId();
        f r14 = this.f13897f;
        if (r14 == null) goto L14;
        ArrayList r15 = r14.d(-1);
        f r16 = new f();
        Iterator r17 = r15.iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.c(((c) r17.next()).b().i(r13));
        goto L9
    L11:
        r10.t(r16);
        return;
    }

    public String toString() {
        return "ViewTransition(" + com.obric.oui.constraintlayout.motion.widget.a.c(this.f13906o, this.f13892a) + ")";
    }
}
