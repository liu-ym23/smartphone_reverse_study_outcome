package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class p {
    public static final float[][] G = null;
    public static final float[][] H = null;
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f1998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f2002m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2003n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2004o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f2005p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f2006q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f2007r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f2008s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MotionLayout f2009t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f2010u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f2013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f2015z;

    public class a implements View.OnTouchListener {
        public a(p r10) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            return false;
        }
    }

    public class b implements NestedScrollView.OnScrollChangeListener {
        public b(p r10) {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView r10, int r11, int r12, int r13, int r14) {
        }
    }

    static {
        G = new float[][]{new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        H = new float[][]{new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    }

    public p(Context r10, MotionLayout r11, XmlPullParser r12) {
        this.f1990a = 0;
        this.f1991b = 0;
        this.f1992c = 0;
        this.f1993d = -1;
        this.f1994e = -1;
        this.f1995f = -1;
        this.f1996g = 0.5f;
        this.f1997h = 0.5f;
        this.f1998i = 0.5f;
        this.f1999j = 0.5f;
        this.f2000k = -1;
        this.f2001l = false;
        this.f2002m = 0.0f;
        this.f2003n = 1.0f;
        this.f2004o = false;
        this.f2005p = new float[2];
        this.f2006q = new int[2];
        this.f2010u = 4.0f;
        this.f2011v = 1.2f;
        this.f2012w = true;
        this.f2013x = 1.0f;
        this.f2014y = 0;
        this.f2015z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.f2009t = r11;
        c(r10, Xml.asAttributeSet(r12));
    }

    public void A() {
        int r10 = this.f1993d;
        if (r10 == (-1)) goto L7;
        View r11 = this.f2009t.findViewById(r10);
        if (r11 != null) goto L9;
        Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + androidx.constraintlayout.motion.widget.a.c(this.f2009t.getContext(), this.f1993d));
    L9:
        if ((r11 instanceof NestedScrollView) == false) goto L12;
        NestedScrollView r12 = (NestedScrollView) r11;
        r12.setOnTouchListener(new a(this));
        r12.setOnScrollChangeListener(new b(this));
        return;
    L12:
        return;
    L7:
        r11 = null;
        goto L9
    }

    public float a(float r10, float r11) {
        return (r10 * this.f2002m) + (r11 * this.f2003n);
    }

    public final void b(TypedArray r10) {
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L65;
        int r13 = r10.getIndex(r12);
        if (r13 != R$styleable.OnSwipe_touchAnchorId) goto L8;
        this.f1993d = r10.getResourceId(r13, this.f1993d);
    L64:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r13 != R$styleable.OnSwipe_touchAnchorSide) goto L11;
        int r14 = r10.getInt(r13, this.f1990a);
        this.f1990a = r14;
        float[] r15 = G[r14];
        this.f1997h = r15[0];
        this.f1996g = r15[1];
        goto L64
    L11:
        if (r13 != R$styleable.OnSwipe_dragDirection) goto L17;
        int r16 = r10.getInt(r13, this.f1991b);
        this.f1991b = r16;
        float[][] r17 = H;
        if (r16 >= r17.length) goto L15;
        float[] r18 = r17[r16];
        this.f2002m = r18[0];
        this.f2003n = r18[1];
        goto L64
    L15:
        this.f2003n = Float.NaN;
        this.f2002m = Float.NaN;
        this.f2001l = true;
        goto L64
    L17:
        if (r13 != R$styleable.OnSwipe_maxVelocity) goto L20;
        this.f2010u = r10.getFloat(r13, this.f2010u);
        goto L64
    L20:
        if (r13 != R$styleable.OnSwipe_maxAcceleration) goto L23;
        this.f2011v = r10.getFloat(r13, this.f2011v);
        goto L64
    L23:
        if (r13 != R$styleable.OnSwipe_moveWhenScrollAtTop) goto L26;
        this.f2012w = r10.getBoolean(r13, this.f2012w);
        goto L64
    L26:
        if (r13 != R$styleable.OnSwipe_dragScale) goto L29;
        this.f2013x = r10.getFloat(r13, this.f2013x);
        goto L64
    L29:
        if (r13 != R$styleable.OnSwipe_dragThreshold) goto L32;
        this.f2015z = r10.getFloat(r13, this.f2015z);
        goto L64
    L32:
        if (r13 != R$styleable.OnSwipe_touchRegionId) goto L35;
        this.f1994e = r10.getResourceId(r13, this.f1994e);
        goto L64
    L35:
        if (r13 != R$styleable.OnSwipe_onTouchUp) goto L38;
        this.f1992c = r10.getInt(r13, this.f1992c);
        goto L64
    L38:
        if (r13 != R$styleable.OnSwipe_nestedScrollFlags) goto L41;
        this.f2014y = r10.getInteger(r13, 0);
        goto L64
    L41:
        if (r13 != R$styleable.OnSwipe_limitBoundsTo) goto L44;
        this.f1995f = r10.getResourceId(r13, 0);
        goto L64
    L44:
        if (r13 != R$styleable.OnSwipe_rotationCenterId) goto L47;
        this.f2000k = r10.getResourceId(r13, this.f2000k);
        goto L64
    L47:
        if (r13 != R$styleable.OnSwipe_springDamping) goto L50;
        this.A = r10.getFloat(r13, this.A);
        goto L64
    L50:
        if (r13 != R$styleable.OnSwipe_springMass) goto L53;
        this.B = r10.getFloat(r13, this.B);
        goto L64
    L53:
        if (r13 != R$styleable.OnSwipe_springStiffness) goto L56;
        this.C = r10.getFloat(r13, this.C);
        goto L64
    L56:
        if (r13 != R$styleable.OnSwipe_springStopThreshold) goto L59;
        this.D = r10.getFloat(r13, this.D);
        goto L64
    L59:
        if (r13 != R$styleable.OnSwipe_springBoundary) goto L62;
        this.E = r10.getInt(r13, this.E);
        goto L64
    L62:
        if (r13 != R$styleable.OnSwipe_autoCompleteMode) goto L64;
        this.F = r10.getInt(r13, this.F);
        goto L64
    }

    public final void c(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OnSwipe);
        b(r12);
        r12.recycle();
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.f2014y;
    }

    public RectF f(ViewGroup r10, RectF r11) {
        int r12 = this.f1995f;
        if (r12 != (-1)) goto L5;
        return null;
    L5:
        View r13 = r10.findViewById(r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        r11.set(r13.getLeft(), r13.getTop(), r13.getRight(), r13.getBottom());
        return r11;
    }

    public float g() {
        return this.f2011v;
    }

    public float h() {
        return this.f2010u;
    }

    public boolean i() {
        return this.f2012w;
    }

    public float j(float r10, float r11) {
        float r12 = this.f2009t.getProgress();
        this.f2009t.Q(this.f1993d, r12, this.f1997h, this.f1996g, this.f2005p);
        float r13 = this.f2002m;
        if (r13 == 0.0f) goto L8;
        float[] r14 = this.f2005p;
        if (r14[0] != 0.0f) goto L13;
        r14[0] = 1.0E-7f;
    L13:
        return (r10 * r13) / r14[0];
    L8:
        float[] r15 = this.f2005p;
        if (r15[1] != 0.0f) goto L12;
        r15[1] = 1.0E-7f;
    L12:
        return (r11 * this.f2003n) / r15[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    public RectF p(ViewGroup r10, RectF r11) {
        int r12 = this.f1994e;
        if (r12 != (-1)) goto L5;
        return null;
    L5:
        View r13 = r10.findViewById(r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        r11.set(r13.getLeft(), r13.getTop(), r13.getRight(), r13.getBottom());
        return r11;
    }

    public int q() {
        return this.f1994e;
    }

    public boolean r() {
        return this.f2004o;
    }

    public void s(MotionEvent r21, MotionLayout.MotionTracker r22, int r23, o r24) {
        if (this.f2001l == false) goto L6;
        t(r21, r22, r23, r24);
        return;
    L6:
        r22.addMovement(r21);
        int r10 = r21.getAction();
        if (r10 != 0) goto L9;
        this.f2007r = r21.getRawX();
        this.f2008s = r21.getRawY();
        this.f2004o = false;
        return;
    L9:
        if (r10 != 1) goto L11;
        this.f2004o = false;
        r22.computeCurrentVelocity(1000);
        float r11 = r22.getXVelocity();
        float r12 = r22.getYVelocity();
        float r13 = this.f2009t.getProgress();
        int r14 = this.f1993d;
        if (r14 == (-1)) goto L58;
        this.f2009t.Q(r14, r13, this.f1997h, this.f1996g, this.f2005p);
    L59:
        float r15 = this.f2002m;
        float[] r16 = this.f2005p;
        float r17 = r16[0];
        float r18 = r16[1];
        if (r15 == 0.0f) goto L62;
        float r19 = r11 / r17;
    L64:
        if (Float.isNaN(r19) == true) goto L66;
        float r20 = (r19 / 3.0f) + r13;
    L68:
        if (r20 == 0.0f) goto L94;
        if (r20 == 1.0f) goto L94;
        int r25 = this.f1992c;
        if (r25 == 3) goto L94;
        if (r20 >= 0.5d) goto L76;
        float r26 = 0.0f;
    L77:
        if (r25 != 6) goto L83;
        if ((r13 + r19) >= 0.0f) goto L81;
        r19 = Math.abs(r19);
    L81:
        r26 = 1.0f;
    L83:
        if (this.f1992c == 7) goto L85;
    L88:
        this.f2009t.h0(this.f1992c, r26, r19);
        if (0.0f < r13) goto L91;
    L92:
        this.f2009t.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L91:
        if (1.0f <= r13) goto L92;
        return;
    L85:
        if ((r13 + r19) <= 1.0f) goto L87;
        r19 = -Math.abs(r19);
    L87:
        r26 = 0.0f;
        goto L88
    L76:
        r26 = 1.0f;
    L94:
        if (0.0f < r20) goto L96;
    L97:
        this.f2009t.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L96:
        if (1.0f <= r20) goto L97;
        return;
    L66:
        r20 = r13;
        goto L68
    L62:
        r19 = r12 / r18;
        goto L64
    L58:
        float r27 = Math.min(this.f2009t.getWidth(), this.f2009t.getHeight());
        float[] r28 = this.f2005p;
        r28[1] = this.f2003n * r27;
        r28[0] = r27 * this.f2002m;
        goto L59
    L11:
        if (r10 != 2) goto L106;
        float r29 = r21.getRawY() - this.f2008s;
        float r110 = r21.getRawX() - this.f2007r;
        if (Math.abs((this.f2002m * r110) + (this.f2003n * r29)) <= this.f2015z) goto L16;
    L17:
        float r111 = this.f2009t.getProgress();
        if (this.f2004o == true) goto L20;
        this.f2004o = true;
        this.f2009t.setProgress(r111);
    L20:
        int r112 = this.f1993d;
        if (r112 == (-1)) goto L23;
        this.f2009t.Q(r112, r111, this.f1997h, this.f1996g, this.f2005p);
    L24:
        float r30 = this.f2002m;
        float[] r31 = this.f2005p;
        if (Math.abs(((r30 * r31[0]) + (this.f2003n * r31[1])) * this.f2013x) >= 0.01d) goto L28;
        float[] r32 = this.f2005p;
        r32[0] = 0.01f;
        r32[1] = 0.01f;
    L28:
        if (this.f2002m == 0.0f) goto L30;
        float r113 = r110 / this.f2005p[0];
    L31:
        float r33 = Math.max(Math.min(r111 + r113, 1.0f), 0.0f);
        if (this.f1992c != 6) goto L35;
        r33 = Math.max(r33, 0.01f);
    L35:
        if (this.f1992c != 7) goto L37;
        r33 = Math.min(r33, 0.99f);
    L37:
        float r34 = this.f2009t.getProgress();
        if (r33 != r34) goto L40;
        this.f2009t.f1732d = 0.0f;
    L54:
        this.f2007r = r21.getRawX();
        this.f2008s = r21.getRawY();
        return;
    L40:
        if (r34 != 0.0f) goto L42;
    L43:
        MotionLayout r35 = this.f2009t;
        if (r34 != 0.0f) goto L46;
        boolean r36 = true;
    L47:
        r35.L(r36);
    L48:
        this.f2009t.setProgress(r33);
        r22.computeCurrentVelocity(1000);
        float r37 = r22.getXVelocity();
        float r38 = r22.getYVelocity();
        if (this.f2002m == 0.0f) goto L51;
        float r39 = r37 / this.f2005p[0];
    L52:
        this.f2009t.f1732d = r39;
        goto L54
    L51:
        r39 = r38 / this.f2005p[1];
        goto L52
    L46:
        r36 = false;
        goto L47
    L42:
        if (r34 != 1.0f) goto L48;
    L30:
        r113 = r29 / this.f2005p[1];
        goto L31
    L23:
        float r40 = Math.min(this.f2009t.getWidth(), this.f2009t.getHeight());
        float[] r41 = this.f2005p;
        r41[1] = this.f2003n * r40;
        r41[0] = r40 * this.f2002m;
        goto L24
    L16:
        if (this.f2004o == true) goto L17;
        return;
    }

    public void t(MotionEvent r24, MotionLayout.MotionTracker r25, int r26, o r27) {
        r25.addMovement(r24);
        int r10 = r24.getAction();
        boolean r11 = false;
        if (r10 != 0) goto L5;
        this.f2007r = r24.getRawX();
        this.f2008s = r24.getRawY();
        this.f2004o = false;
        return;
    L5:
        if (r10 != 1) goto L7;
        this.f2004o = false;
        r25.computeCurrentVelocity(16);
        float r12 = r25.getXVelocity();
        float r13 = r25.getYVelocity();
        float r14 = this.f2009t.getProgress();
        float r15 = this.f2009t.getWidth() / 2.0f;
        float r16 = this.f2009t.getHeight() / 2.0f;
        int r17 = this.f2000k;
        if (r17 == (-1)) goto L52;
        View r18 = this.f2009t.findViewById(r17);
        this.f2009t.getLocationOnScreen(this.f2006q);
        float r19 = this.f2006q[0] + ((r18.getLeft() + r18.getRight()) / 2.0f);
        float r110 = this.f2006q[1];
        int r111 = r18.getTop();
        int r20 = r18.getBottom();
    L51:
        r16 = r110 + ((r111 + r20) / 2.0f);
        r15 = r19;
    L55:
        float r21 = r24.getRawX() - r15;
        float r22 = r24.getRawY() - r16;
        double r23 = Math.toDegrees(Math.atan2(r22, r21));
        int r112 = this.f1993d;
        if (r112 == (-1)) goto L58;
        this.f2009t.Q(r112, r14, this.f1997h, this.f1996g, this.f2005p);
        float[] r28 = this.f2005p;
        r28[1] = (float) Math.toDegrees(r28[1]);
    L59:
        float r29 = ((float) (Math.toDegrees(Math.atan2(r13 + r22, r12 + r21)) - r23)) * 62.5f;
        if (Float.isNaN(r29) == true) goto L63;
        float r30 = (((r29 * 3.0f) * this.f2013x) / this.f2005p[1]) + r14;
    L65:
        if (r30 == 0.0f) goto L92;
        if (r30 == 1.0f) goto L92;
        int r31 = this.f1992c;
        if (r31 == 3) goto L92;
        float r32 = (r29 * this.f2013x) / this.f2005p[1];
        if (r30 >= 0.5d) goto L73;
        float r33 = 0.0f;
    L75:
        if (r31 != 6) goto L81;
        if ((r14 + r32) >= 0.0f) goto L79;
        r32 = Math.abs(r32);
    L79:
        r33 = 1.0f;
    L81:
        if (this.f1992c == 7) goto L83;
    L86:
        this.f2009t.h0(this.f1992c, r33, r32 * 3.0f);
        if (0.0f < r14) goto L89;
    L90:
        this.f2009t.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L89:
        if (1.0f <= r14) goto L90;
        return;
    L83:
        if ((r14 + r32) <= 1.0f) goto L85;
        r32 = -Math.abs(r32);
    L85:
        r33 = 0.0f;
        goto L86
    L73:
        r33 = 1.0f;
    L92:
        if (0.0f < r30) goto L94;
    L95:
        this.f2009t.setState(MotionLayout.TransitionState.FINISHED);
        return;
    L94:
        if (1.0f <= r30) goto L95;
        return;
    L63:
        r30 = r14;
        goto L65
    L58:
        this.f2005p[1] = 360.0f;
        goto L59
    L52:
        int r113 = this.f1993d;
        if (r113 == (-1)) goto L55;
        View r34 = this.f2009t.findViewById(this.f2009t.S(r113).h());
        this.f2009t.getLocationOnScreen(this.f2006q);
        r19 = this.f2006q[0] + ((r34.getLeft() + r34.getRight()) / 2.0f);
        r110 = this.f2006q[1];
        r111 = r34.getTop();
        r20 = r34.getBottom();
        goto L51
    L7:
        if (r10 != 2) goto L104;
        r24.getRawY();
        r24.getRawX();
        float r35 = this.f2009t.getWidth() / 2.0f;
        float r114 = this.f2009t.getHeight() / 2.0f;
        int r115 = this.f2000k;
        if (r115 == (-1)) goto L12;
        View r36 = this.f2009t.findViewById(r115);
        this.f2009t.getLocationOnScreen(this.f2006q);
        float r116 = this.f2006q[0] + ((r36.getLeft() + r36.getRight()) / 2.0f);
        r114 = ((r36.getTop() + r36.getBottom()) / 2.0f) + this.f2006q[1];
        r35 = r116;
    L18:
        float r37 = r24.getRawX() - r35;
        float r117 = r24.getRawY() - r114;
        double r38 = Math.atan2(r24.getRawY() - r114, r24.getRawX() - r35);
        float r39 = (float) (((r38 - Math.atan2(this.f2008s - r114, this.f2007r - r35)) * 180.0d) / 3.141592653589793d);
        if (r39 <= 330.0f) goto L22;
        r39 = r39 - 360.0f;
    L25:
        if (Math.abs(r39) <= 0.01d) goto L27;
    L28:
        float r40 = this.f2009t.getProgress();
        if (this.f2004o == true) goto L31;
        this.f2004o = true;
        this.f2009t.setProgress(r40);
    L31:
        int r118 = this.f1993d;
        if (r118 == (-1)) goto L34;
        this.f2009t.Q(r118, r40, this.f1997h, this.f1996g, this.f2005p);
        float[] r41 = this.f2005p;
        r41[1] = (float) Math.toDegrees(r41[1]);
    L35:
        float r42 = Math.max(Math.min(r40 + ((r39 * this.f2013x) / this.f2005p[1]), 1.0f), 0.0f);
        float r43 = this.f2009t.getProgress();
        if (r42 != r43) goto L38;
        this.f2009t.f1732d = 0.0f;
    L47:
        this.f2007r = r24.getRawX();
        this.f2008s = r24.getRawY();
        return;
    L38:
        if (r43 != 0.0f) goto L40;
    L41:
        MotionLayout r44 = this.f2009t;
        if (r43 != 0.0f) goto L44;
        r11 = true;
    L44:
        r44.L(r11);
    L45:
        this.f2009t.setProgress(r42);
        r25.computeCurrentVelocity(1000);
        float r45 = r25.getXVelocity();
        double r46 = r25.getYVelocity();
        double r47 = r45;
        float r48 = (float) ((Math.hypot(r46, r47) * Math.sin(Math.atan2(r46, r47) - r38)) / Math.hypot(r37, r117));
        this.f2009t.f1732d = (float) Math.toDegrees(r48);
        goto L47
    L40:
        if (r43 != 1.0f) goto L45;
    L34:
        this.f2005p[1] = 360.0f;
        goto L35
    L27:
        if (this.f2004o == true) goto L28;
        return;
    L22:
        if (r39 >= (-330.0f)) goto L25;
        r39 = r39 + 360.0f;
        goto L25
    L12:
        int r119 = this.f1993d;
        if (r119 == (-1)) goto L18;
        View r120 = this.f2009t.findViewById(this.f2009t.S(r119).h());
        if (r120 != null) goto L17;
        Log.e("TouchResponse", "could not find view to animate to");
        goto L18
    L17:
        this.f2009t.getLocationOnScreen(this.f2006q);
        r35 = this.f2006q[0] + ((r120.getLeft() + r120.getRight()) / 2.0f);
        r114 = this.f2006q[1] + ((r120.getTop() + r120.getBottom()) / 2.0f);
        goto L18
    }

    public String toString() {
        if (Float.isNaN(this.f2002m) == false) goto L6;
        return "rotation";
    L6:
        return this.f2002m + " , " + this.f2003n;
    }

    public void u(float r10, float r11) {
        float r12 = this.f2009t.getProgress();
        if (this.f2004o == true) goto L5;
        this.f2004o = true;
        this.f2009t.setProgress(r12);
    L5:
        this.f2009t.Q(this.f1993d, r12, this.f1997h, this.f1996g, this.f2005p);
        float r13 = this.f2002m;
        float[] r14 = this.f2005p;
        if (Math.abs((r13 * r14[0]) + (this.f2003n * r14[1])) >= 0.01d) goto L8;
        float[] r15 = this.f2005p;
        r15[0] = 0.01f;
        r15[1] = 0.01f;
    L8:
        float r16 = this.f2002m;
        if (r16 == 0.0f) goto L11;
        float r17 = (r10 * r16) / this.f2005p[0];
    L12:
        float r18 = Math.max(Math.min(r12 + r17, 1.0f), 0.0f);
        if (r18 == this.f2009t.getProgress()) goto L16;
        this.f2009t.setProgress(r18);
        return;
    L16:
        return;
    L11:
        r17 = (r11 * this.f2003n) / this.f2005p[1];
        goto L12
    }

    public void v(float r10, float r11) {
        boolean r12 = false;
        this.f2004o = false;
        float r13 = this.f2009t.getProgress();
        this.f2009t.Q(this.f1993d, r13, this.f1997h, this.f1996g, this.f2005p);
        float r14 = this.f2002m;
        float[] r15 = this.f2005p;
        float r16 = r15[0];
        float r17 = this.f2003n;
        float r18 = r15[1];
        float r19 = 0.0f;
        if (r14 == 0.0f) goto L5;
        float r110 = (r10 * r14) / r16;
    L7:
        if (Float.isNaN(r110) == true) goto L10;
        r13 = r13 + (r110 / 3.0f);
    L10:
        if (r13 != 0.0f) goto L12;
        return;
    L12:
        if (r13 == 1.0f) goto L14;
        boolean r20 = true;
    L15:
        int r21 = this.f1992c;
        if (r21 == 3) goto L19;
        r12 = true;
    L19:
        if ((r12 & r20) == false) goto L27;
        MotionLayout r22 = this.f2009t;
        if (r13 < 0.5d) goto L24;
        r19 = 1.0f;
    L24:
        r22.h0(r21, r19, r110);
        return;
    L27:
        return;
    L14:
        r20 = false;
        goto L15
    L5:
        r110 = (r11 * r17) / r18;
        goto L7
    }

    public void w(float r10, float r11) {
        this.f2007r = r10;
        this.f2008s = r11;
    }

    public void x(boolean r10) {
        if (r10 == false) goto L5;
        float[][] r11 = H;
        r11[4] = r11[3];
        r11[5] = r11[2];
        float[][] r12 = G;
        r12[5] = r12[2];
        r12[6] = r12[1];
    L6:
        float[] r13 = G[this.f1990a];
        this.f1997h = r13[0];
        this.f1996g = r13[1];
        int r14 = this.f1991b;
        float[][] r15 = H;
        if (r14 < r15.length) goto L9;
        return;
    L9:
        float[] r16 = r15[r14];
        this.f2002m = r16[0];
        this.f2003n = r16[1];
        return;
    L5:
        float[][] r17 = H;
        r17[4] = r17[2];
        r17[5] = r17[3];
        float[][] r18 = G;
        r18[5] = r18[1];
        r18[6] = r18[2];
        goto L6
    }

    public void y(int r10) {
        this.f1992c = r10;
    }

    public void z(float r10, float r11) {
        this.f2007r = r10;
        this.f2008s = r11;
        this.f2004o = false;
    }
}
