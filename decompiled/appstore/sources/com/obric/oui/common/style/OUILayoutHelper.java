package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.content.ContextCompat;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.material.OMaterialHelper;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OUILayoutHelper implements IOUILayout {
    public float A;
    public Paint B;
    public PorterDuffXfermode C;
    public int D;
    public float[] E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f13013J;
    public boolean K;
    public RectF L;
    public int M;
    public int N;
    public int O;
    public WeakReference P;
    public boolean Q;
    public Path R;
    public Path S;
    public boolean T;
    public int U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13014a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f13015a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13016b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f13017b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13018c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f13019c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13020d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f13021d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13022e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public AttributeSet f13023e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13024f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f13025f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13026g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f13027g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13028h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f13029h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13030i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f13031i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13032j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Shadow f13033j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13034k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Shadow f13035k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13036l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final Shadow f13037l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13038m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final Shadow f13039m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13040n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f13041n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13044q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13049v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13050w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13051x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13052y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Paint f13053z;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OUILayoutHelper f13054a;

        public a(OUILayoutHelper r10) {
            this.f13054a = r10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r14, Outline r15) {
            int r10 = r14.getWidth();
            int r11 = r14.getHeight();
            if (r10 == 0) goto L32;
            if (r11 == 0) goto L35;
            float r12 = OUILayoutHelper.a(this.f13054a);
            float r13 = r12 * 2.0f;
            float r16 = Math.min(r10, r11);
            if (r13 <= r16) goto L9;
            r12 = r16 / 2.0f;
        L9:
            float r17 = r12;
            if (OUILayoutHelper.b(this.f13054a) == false) goto L13;
            Path r18 = new Path();
            r18.addRoundRect(new RectF(0.0f, 0.0f, r10, r11), new float[]{OUILayoutHelper.g(this.f13054a), OUILayoutHelper.g(this.f13054a), OUILayoutHelper.h(this.f13054a), OUILayoutHelper.h(this.f13054a), OUILayoutHelper.i(this.f13054a), OUILayoutHelper.i(this.f13054a), OUILayoutHelper.j(this.f13054a), OUILayoutHelper.j(this.f13054a)}, Path.Direction.CW);
            r15.setConvexPath(r18);
            r14.setClipToOutline(!OUILayoutHelper.k(this.f13054a));
            return;
        L13:
            int r19 = OUILayoutHelper.l(this.f13054a);
            int r20 = Math.max(r19 + 1, r11 - OUILayoutHelper.m(this.f13054a));
            int r21 = OUILayoutHelper.n(this.f13054a);
            int r22 = r10 - OUILayoutHelper.c(this.f13054a);
            if (OUILayoutHelper.d(this.f13054a) == false) goto L17;
            r21 = r21 + r14.getPaddingLeft();
            r19 = r19 + r14.getPaddingTop();
            int r23 = Math.max(r21 + 1, r22 - r14.getPaddingRight());
            int r24 = Math.max(1 + r19, r20 - r14.getPaddingBottom());
            int r25 = r23;
        L16:
            int r26 = r19;
            float r110 = OUILayoutHelper.e(this.f13054a);
            if (OUILayoutHelper.f(this.f13054a) != 0) goto L21;
            r110 = 1.0f;
        L21:
            r15.setAlpha(r110);
            if (r17 > 0.0f) goto L25;
            r15.setRect(r21, r26, r25, r24);
            return;
        L25:
            if (l.f13092f == true) goto L27;
        L30:
            r15.setRoundRect(r21, r26, r25, r24, r17);
            return;
        L27:
            if (OMaterialHelper.v() == true) goto L30;
            r15.setPath(l.f13087a.c(r21, r26, r25, r24, r17));
            return;
        L17:
            r25 = r22;
            r24 = r20;
            goto L16
        L35:
            return;
        }
    }

    public OUILayoutHelper(Context r10, AttributeSet r11, int r12, int r13) {
        this.f13016b = 0;
        this.f13018c = 0;
        this.f13020d = 0;
        this.f13022e = 0;
        this.f13024f = 0;
        this.f13026g = 0;
        this.f13028h = 0;
        this.f13032j = PrivateKeyType.INVALID;
        this.f13034k = 0;
        this.f13036l = 0;
        this.f13038m = 0;
        this.f13042o = PrivateKeyType.INVALID;
        this.f13043p = 0;
        this.f13044q = 0;
        this.f13045r = 0;
        this.f13047t = PrivateKeyType.INVALID;
        this.f13048u = 0;
        this.f13049v = 0;
        this.f13050w = 0;
        this.f13052y = PrivateKeyType.INVALID;
        this.A = 1.0f;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.K = false;
        this.M = 0;
        this.N = 1;
        this.O = 0;
        this.Q = false;
        this.R = new Path();
        this.S = null;
        this.T = true;
        this.U = 0;
        this.W = -16777216;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f13015a0 = 0;
        this.f13017b0 = 0;
        this.f13019c0 = 0;
        this.f13021d0 = false;
        this.f13029h0 = false;
        this.f13031i0 = true;
        Shadow r14 = Shadow.f13061i;
        this.f13033j0 = r14.a();
        this.f13035k0 = r14.a();
        this.f13037l0 = r14.a();
        this.f13039m0 = r14.a();
        this.f13041n0 = 0.0f;
        this.f13014a = r10;
        this.f13023e0 = r11;
        this.f13025f0 = r12;
        this.f13027g0 = r13;
    }

    private void F() {
        View r10 = (View) this.P.get();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.invalidate();
    }

    private void G() {
        if (N() == false) goto L13;
        View r10 = (View) this.P.get();
        if (r10 != null) goto L7;
        return;
    L7:
        int r11 = this.U;
        if (r11 != 0) goto L10;
        r10.setElevation(0.0f);
    L11:
        r10.invalidateOutline();
        return;
    L10:
        r10.setElevation(r11);
        goto L11
    }

    public static boolean N() {
        return true;
    }

    public static /* synthetic */ int a(OUILayoutHelper r10) {
        return r10.B();
    }

    public static /* synthetic */ boolean b(OUILayoutHelper r10) {
        return r10.f13013J;
    }

    public static /* synthetic */ int c(OUILayoutHelper r10) {
        return r10.f13015a0;
    }

    public static /* synthetic */ boolean d(OUILayoutHelper r10) {
        return r10.Q;
    }

    public static /* synthetic */ float e(OUILayoutHelper r10) {
        return r10.V;
    }

    public static /* synthetic */ int f(OUILayoutHelper r10) {
        return r10.U;
    }

    public static /* synthetic */ int g(OUILayoutHelper r10) {
        return r10.F;
    }

    public static /* synthetic */ int h(OUILayoutHelper r10) {
        return r10.G;
    }

    public static /* synthetic */ int i(OUILayoutHelper r10) {
        return r10.I;
    }

    public static /* synthetic */ int j(OUILayoutHelper r10) {
        return r10.H;
    }

    public static /* synthetic */ boolean k(OUILayoutHelper r10) {
        return r10.K;
    }

    public static /* synthetic */ int l(OUILayoutHelper r10) {
        return r10.f13017b0;
    }

    public static /* synthetic */ int m(OUILayoutHelper r10) {
        return r10.f13019c0;
    }

    public static /* synthetic */ int n(OUILayoutHelper r10) {
        return r10.Z;
    }

    public static List p(Context r10, TypedArray r11, int r12) {
        List r13 = y(r10, r11.getString(r12));
        if (r13 == null) goto L6;
        ArrayList r14 = new ArrayList(2);
        r14.addAll(r13);
        return r14;
    L6:
        int r15 = r11.getResourceId(r12, 0);
        if (r15 != 0) goto L10;
        return null;
    L10:
        List r16 = x(r10, r15);
        ArrayList r17 = new ArrayList(2);
        r17.addAll(r16);
        return r17;
    }

    public static List x(Context r10, int r11) {
        ArrayList r12 = new ArrayList();
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OUILayout);
        Shadow r14 = Shadow.b(com.obric.oui.shadow.a.a(r13, R$styleable.OUILayout_oui_firstShadowColor, R$styleable.OUILayout_oui_firstShadowBlur, R$styleable.OUILayout_oui_firstOffsetX, R$styleable.OUILayout_oui_firstOffsetY, R$styleable.OUILayout_oui_firstShadowSpread));
        Shadow r15 = Shadow.b(com.obric.oui.shadow.a.a(r13, R$styleable.OUILayout_oui_secondShadowColor, R$styleable.OUILayout_oui_secondShadowBlur, R$styleable.OUILayout_oui_secondOffsetX, R$styleable.OUILayout_oui_secondOffsetY, R$styleable.OUILayout_oui_secondShadowSpread));
        r13.recycle();
        r12.add(r14);
        r12.add(r15);
        return r12;
    }

    public static List y(Context r10, String r11) {
        com.obric.oui.shadow.b[] r12 = com.obric.oui.shadow.d.a(r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        float r13 = r10.getResources().getDisplayMetrics().density;
        ArrayList r14 = new ArrayList();
        Shadow r15 = Shadow.c(r12[0], r13);
        Shadow r16 = Shadow.f13061i;
        if (r12.length <= 1) goto L9;
        r16 = Shadow.c(r12[1], r13);
    L9:
        r14.add(r15);
        r14.add(r16);
        return r14;
    }

    public int A(int r10) {
        if (this.f13016b > 0) goto L5;
        return r10;
    L5:
        if (View.MeasureSpec.getSize(r10) > this.f13016b) goto L7;
        return r10;
    L7:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f13016b, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f13016b, Ints.MAX_POWER_OF_TWO);
    }

    public final int B() {
        View r10 = (View) this.P.get();
        if (r10 == null) goto L5;
        int r11 = this.D;
        if (r11 != (-1)) goto L10;
        return r10.getHeight() / 2;
    L10:
        if (r11 == (-2)) goto L12;
        return r11;
    L12:
        return r10.getWidth() / 2;
    L5:
        return this.D;
    }

    public int C(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L8;
        int r12 = this.f13022e;
        if (r11 >= r12) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r12, Ints.MAX_POWER_OF_TWO);
    L8:
        return r10;
    }

    public int D(int r10, int r11) {
        if (View.MeasureSpec.getMode(r10) == 1073741824) goto L8;
        int r12 = this.f13020d;
        if (r11 >= r12) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r12, Ints.MAX_POWER_OF_TWO);
    L8:
        return r10;
    }

    public void E(View r18) {
        float r10 = r18.getResources().getDisplayMetrics().density;
        this.P = new WeakReference(r18);
        Context r11 = this.f13014a;
        int r12 = R$color.oui_line_2;
        int r13 = ContextCompat.b(r11, r12);
        this.f13030i = r13;
        this.f13040n = r13;
        int r14 = ContextCompat.b(this.f13014a, r12);
        this.f13051x = r14;
        this.f13046s = r14;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r15 = new Paint();
        this.B = r15;
        r15.setAntiAlias(true);
        float r16 = i.b(this.f13014a, R$attr.oui_general_shadow_alpha);
        if (r16 <= 0.0f) goto L5;
        this.V = r16;
    L5:
        this.L = new RectF();
        int r17 = 0;
        if (this.f13029h0 == false) goto L8;
    L15:
        TypedArray r19 = this.f13014a.obtainStyledAttributes(this.f13023e0, R$styleable.OUILayout, this.f13025f0, this.f13027g0);
        int r20 = r19.getIndexCount();
        int r21 = 0;
        int r22 = 0;
        boolean r23 = false;
        int r110 = 0;
    L16:
        if (r21 >= r20) goto L132;
        int r111 = r19.getIndex(r21);
        if (r111 != R$styleable.OUILayout_android_maxWidth) goto L21;
        this.f13016b = r19.getDimensionPixelSize(r111, this.f13016b);
    L123:
        if (r111 != R$styleable.OUILayout_oui_bottomLeft_radius) goto L126;
        this.H = r19.getDimensionPixelSize(r111, 0);
    L126:
        if (r111 != R$styleable.OUILayout_oui_bottomRight_radius) goto L129;
        this.I = r19.getDimensionPixelSize(r111, 0);
    L129:
        if (r111 != R$styleable.OUILayout_oui_topRight_radius) goto L131;
        this.G = r19.getDimensionPixelSize(r111, 0);
    L131:
        r21 = r21 + 1;
        goto L16
    L21:
        if (r111 != R$styleable.OUILayout_android_maxHeight) goto L24;
        this.f13018c = r19.getDimensionPixelSize(r111, this.f13018c);
        goto L123
    L24:
        if (r111 != R$styleable.OUILayout_android_minWidth) goto L27;
        this.f13020d = r19.getDimensionPixelSize(r111, this.f13020d);
        goto L123
    L27:
        if (r111 != R$styleable.OUILayout_android_minHeight) goto L30;
        this.f13022e = r19.getDimensionPixelSize(r111, this.f13022e);
        goto L123
    L30:
        if (r111 != R$styleable.OUILayout_oui_topDividerColor) goto L33;
        this.f13030i = r19.getColor(r111, this.f13030i);
        goto L123
    L33:
        if (r111 != R$styleable.OUILayout_oui_topDividerHeight) goto L36;
        this.f13024f = r19.getDimensionPixelSize(r111, this.f13024f);
        goto L123
    L36:
        if (r111 != R$styleable.OUILayout_oui_topDividerInsetLeft) goto L39;
        this.f13026g = r19.getDimensionPixelSize(r111, this.f13026g);
        goto L123
    L39:
        if (r111 != R$styleable.OUILayout_oui_topDividerInsetRight) goto L42;
        this.f13028h = r19.getDimensionPixelSize(r111, this.f13028h);
        goto L123
    L42:
        if (r111 != R$styleable.OUILayout_oui_bottomDividerColor) goto L45;
        this.f13040n = r19.getColor(r111, this.f13040n);
        goto L123
    L45:
        if (r111 != R$styleable.OUILayout_oui_bottomDividerHeight) goto L48;
        this.f13034k = r19.getDimensionPixelSize(r111, this.f13034k);
        goto L123
    L48:
        if (r111 != R$styleable.OUILayout_oui_bottomDividerInsetLeft) goto L51;
        this.f13036l = r19.getDimensionPixelSize(r111, this.f13036l);
        goto L123
    L51:
        if (r111 != R$styleable.OUILayout_oui_bottomDividerInsetRight) goto L54;
        this.f13038m = r19.getDimensionPixelSize(r111, this.f13038m);
        goto L123
    L54:
        if (r111 != R$styleable.OUILayout_oui_leftDividerColor) goto L57;
        this.f13046s = r19.getColor(r111, this.f13046s);
        goto L123
    L57:
        if (r111 != R$styleable.OUILayout_oui_leftDividerWidth) goto L60;
        this.f13043p = r19.getDimensionPixelSize(r111, this.f13043p);
        goto L123
    L60:
        if (r111 != R$styleable.OUILayout_oui_leftDividerInsetTop) goto L63;
        this.f13044q = r19.getDimensionPixelSize(r111, this.f13044q);
        goto L123
    L63:
        if (r111 != R$styleable.OUILayout_oui_leftDividerInsetBottom) goto L66;
        this.f13045r = r19.getDimensionPixelSize(r111, this.f13045r);
        goto L123
    L66:
        if (r111 != R$styleable.OUILayout_oui_rightDividerColor) goto L69;
        this.f13051x = r19.getColor(r111, this.f13051x);
        goto L123
    L69:
        if (r111 != R$styleable.OUILayout_oui_rightDividerWidth) goto L72;
        this.f13048u = r19.getDimensionPixelSize(r111, this.f13048u);
        goto L123
    L72:
        if (r111 != R$styleable.OUILayout_oui_rightDividerInsetTop) goto L75;
        this.f13049v = r19.getDimensionPixelSize(r111, this.f13049v);
        goto L123
    L75:
        if (r111 != R$styleable.OUILayout_oui_rightDividerInsetBottom) goto L78;
        this.f13050w = r19.getDimensionPixelSize(r111, this.f13050w);
        goto L123
    L78:
        if (r111 != R$styleable.OUILayout_oui_layout_borderColor) goto L81;
        this.M = r19.getColor(r111, this.M);
        goto L123
    L81:
        if (r111 != R$styleable.OUILayout_oui_layout_borderWidth) goto L84;
        this.N = r19.getDimensionPixelSize(r111, this.N);
        goto L123
    L84:
        if (r111 != R$styleable.OUILayout_oui_radius) goto L87;
        r110 = r19.getDimensionPixelSize(r111, 0);
        goto L123
    L87:
        if (r111 != R$styleable.OUILayout_oui_outerNormalColor) goto L90;
        this.O = r19.getColor(r111, this.O);
        goto L123
    L90:
        if (r111 != R$styleable.OUILayout_oui_showBorderOnlyBeforeL) goto L93;
        this.T = r19.getBoolean(r111, this.T);
        goto L123
    L93:
        if (r111 != R$styleable.OUILayout_oui_shadowElevation) goto L96;
        r22 = r19.getDimensionPixelSize(r111, r22);
        goto L123
    L96:
        if (r111 != R$styleable.OUILayout_oui_shadowAlpha) goto L99;
        this.V = r19.getFloat(r111, this.V);
        goto L123
    L99:
        if (r111 != R$styleable.OUILayout_oui_useThemeGeneralShadowElevation) goto L102;
        r23 = r19.getBoolean(r111, false);
        goto L123
    L102:
        if (r111 != R$styleable.OUILayout_oui_outlineInsetLeft) goto L105;
        this.Z = r19.getDimensionPixelSize(r111, 0);
        goto L123
    L105:
        if (r111 != R$styleable.OUILayout_oui_outlineInsetRight) goto L108;
        this.f13015a0 = r19.getDimensionPixelSize(r111, 0);
        goto L123
    L108:
        if (r111 != R$styleable.OUILayout_oui_outlineInsetTop) goto L111;
        this.f13017b0 = r19.getDimensionPixelSize(r111, 0);
        goto L123
    L111:
        if (r111 != R$styleable.OUILayout_oui_outlineInsetBottom) goto L114;
        this.f13019c0 = r19.getDimensionPixelSize(r111, 0);
        goto L123
    L114:
        if (r111 != R$styleable.OUILayout_oui_outlineExcludePadding) goto L117;
        this.Q = r19.getBoolean(r111, false);
        goto L123
    L117:
        if (r111 != R$styleable.OUILayout_oui_support_image_mirroring) goto L120;
        this.f13021d0 = r19.getBoolean(r111, false);
        goto L123
    L120:
        if (r111 != R$styleable.OUILayout_oui_topLeft_radius) goto L123;
        this.F = r19.getDimensionPixelSize(r111, 0);
        goto L123
    L132:
        com.obric.oui.shadow.b[] r24 = com.obric.oui.shadow.d.a(r19.getString(R$styleable.OUILayout_oui_shadow));
        if (r24 == null) goto L137;
        this.f13033j0.t(r24[0], r10);
        if (r24.length <= 1) goto L141;
        this.f13035k0.t(r24[1], r10);
    L141:
        this.f13037l0.q(this.f13033j0);
        this.f13039m0.q(this.f13035k0);
        this.f13041n0 = r19.getDimension(R$styleable.OUILayout_oui_shadowCornerRadius, 0.0f);
        r19.recycle();
        r17 = r22;
        int r25 = r110;
    L142:
        if (r17 != 0) goto L145;
        if (r23 == false) goto L145;
        r17 = i.a(this.f13014a, R$attr.oui_general_shadow_elevation);
    L145:
        setRadiusAndShadow(r25, r17, this.V);
        return;
    L137:
        int r26 = r19.getResourceId(R$styleable.OUILayout_oui_shadow_style, 0);
        if (r26 == 0) goto L140;
        o(this.f13014a, r26);
        goto L141
    L140:
        this.f13033j0.r(com.obric.oui.shadow.a.a(r19, R$styleable.OUILayout_oui_firstShadowColor, R$styleable.OUILayout_oui_firstShadowBlur, R$styleable.OUILayout_oui_firstOffsetX, R$styleable.OUILayout_oui_firstOffsetY, R$styleable.OUILayout_oui_firstShadowSpread));
        this.f13035k0.r(com.obric.oui.shadow.a.a(r19, R$styleable.OUILayout_oui_secondShadowColor, R$styleable.OUILayout_oui_secondShadowBlur, R$styleable.OUILayout_oui_secondOffsetX, R$styleable.OUILayout_oui_secondOffsetY, R$styleable.OUILayout_oui_secondShadowSpread));
        goto L141
    L8:
        if (this.f13023e0 != null) goto L15;
        if (this.f13025f0 != 0) goto L15;
        if (this.f13027g0 != 0) goto L15;
        r25 = 0;
        r23 = false;
        goto L142
    }

    public boolean H() {
        if (this.H <= 0) goto L5;
    L12:
        return true;
    L5:
        if (this.G > 0) goto L12;
        if (this.F > 0) goto L12;
        if (this.I > 0) goto L12;
        return false;
    }

    public void I() {
        View r10 = (View) this.P.get();
        if (r10 == null) goto L6;
        r10.invalidate();
        return;
    }

    public void J(boolean r10) {
        this.f13029h0 = r10;
    }

    public boolean K(int r10) {
        this.f13022e = r10;
        return true;
    }

    public final void L(int r10) {
        View r11 = (View) this.P.get();
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setOutlineAmbientShadowColor(r10);
        r11.setOutlineSpotShadowColor(r10);
    }

    public final void M() {
        View r10 = (View) this.P.get();
        if (r10 != null) goto L5;
        return;
    L5:
        boolean r11 = false;
        if (this.K == false) goto L8;
        r10.setClipToOutline(false);
        return;
    L8:
        int r12 = this.D;
        if (r12 != (-2)) goto L11;
    L13:
        r11 = true;
    L14:
        r10.setClipToOutline(r11);
        return;
    L11:
        if (r12 == (-1)) goto L13;
        if (r12 <= 0) goto L14;
        goto L13
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List getCurrentShadows() {
        ArrayList r10 = new ArrayList(2);
        Shadow r11 = this.f13037l0;
        if (r11 == null) goto L5;
        r10.add(r11);
    L5:
        Shadow r12 = this.f13039m0;
        if (r12 == null) goto L8;
        r10.add(r12);
    L8:
        return r10;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.D;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.V;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.W;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.U;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        if (this.N <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        if (this.f13034k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        if (this.f13043p <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        if (this.f13048u <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        if (this.f13024f <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.K;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.f13031i0;
    }

    public final void o(Context r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OUILayout);
        this.f13033j0.r(com.obric.oui.shadow.a.a(r12, R$styleable.OUILayout_oui_firstShadowColor, R$styleable.OUILayout_oui_firstShadowBlur, R$styleable.OUILayout_oui_firstOffsetX, R$styleable.OUILayout_oui_firstOffsetY, R$styleable.OUILayout_oui_firstShadowSpread));
        this.f13035k0.r(com.obric.oui.shadow.a.a(r12, R$styleable.OUILayout_oui_secondShadowColor, R$styleable.OUILayout_oui_secondShadowBlur, R$styleable.OUILayout_oui_secondOffsetX, R$styleable.OUILayout_oui_secondOffsetY, R$styleable.OUILayout_oui_secondShadowSpread));
        r12.recycle();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r10) {
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r10, int r11, int r12, int r13) {
        updateBottomDivider(r10, r11, r12, r13);
        this.f13043p = 0;
        this.f13048u = 0;
        this.f13024f = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r10, int r11, int r12, int r13) {
        updateLeftDivider(r10, r11, r12, r13);
        this.f13048u = 0;
        this.f13024f = 0;
        this.f13034k = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r10, int r11, int r12, int r13) {
        updateRightDivider(r10, r11, r12, r13);
        this.f13043p = 0;
        this.f13024f = 0;
        this.f13034k = 0;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r10, int r11, int r12, int r13) {
        updateTopDivider(r10, r11, r12, r13);
        this.f13043p = 0;
        this.f13048u = 0;
        this.f13034k = 0;
    }

    public void q(Canvas r16) {
        View r10 = (View) this.P.get();
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = B();
        if (r11 > 0) goto L8;
    L12:
        boolean r12 = false;
    L14:
        if (this.N > 0) goto L16;
    L18:
        boolean r13 = false;
    L19:
        if (r12 == true) goto L23;
        if (r13 == true) goto L23;
        return;
    L23:
        if (this.T == true) goto L25;
    L29:
        int r14 = r16.getWidth();
        int r15 = r16.getHeight();
        r16.save();
        r16.translate(r10.getScrollX(), r10.getScrollY());
        float r17 = this.N / 2.0f;
        if (this.Q == false) goto L32;
        this.L.set(r10.getPaddingLeft() + r17, r10.getPaddingTop() + r17, (r14 - r10.getPaddingRight()) - r17, (r15 - r10.getPaddingBottom()) - r17);
    L34:
        if (this.f13013J == true) goto L36;
    L39:
        if (r12 == false) goto L45;
        int r18 = r16.saveLayer(0.0f, 0.0f, r14, r15, null, 31);
        r16.drawColor(this.O);
        this.B.setColor(this.O);
        this.B.setStyle(Paint.Style.FILL);
        this.B.setXfermode(this.C);
        if (this.f13013J == true) goto L43;
        t(r16, this.L, r11, this.B);
    L44:
        this.B.setXfermode(null);
        r16.restoreToCount(r18);
        goto L45
    L43:
        u(r16, this.L, this.E, this.B);
    L45:
        if (r13 == false) goto L52;
        this.B.setColor(this.M);
        this.B.setStrokeWidth(this.N);
        this.B.setStyle(Paint.Style.STROKE);
        if (this.f13013J == false) goto L49;
        u(r16, this.L, this.E, this.B);
        goto L52
    L49:
        if (r11 > 0) goto L51;
        r16.drawRect(this.L, this.B);
        goto L52
    L51:
        t(r16, this.L, r11, this.B);
    L52:
        r16.restore();
        return;
    L36:
        if (this.E != null) goto L38;
        this.E = new float[8];
    L38:
        float[] r19 = this.E;
        int r20 = this.F;
        r19[0] = r20;
        r19[1] = r20;
        int r21 = this.G;
        r19[2] = r21;
        r19[3] = r21;
        int r22 = this.H;
        r19[4] = r22;
        r19[5] = r22;
        int r23 = this.I;
        r19[6] = r23;
        r19[7] = r23;
        goto L39
    L32:
        this.L.set(r17, r17, r14 - r17, r15 - r17);
        goto L34
    L25:
        if (N() == false) goto L29;
        if (this.U == 0) goto L29;
        return;
    L16:
        if (this.M == 0) goto L18;
        r13 = true;
        goto L19
    L8:
        if (N() == true) goto L12;
        if (this.O == 0) goto L12;
        r12 = true;
        goto L14
    }

    public void r(Canvas r10) {
        View r11 = (View) this.P.get();
        if (r11 != null) goto L5;
        return;
    L5:
        v(r10);
        if (r11.isHardwareAccelerated() == false) goto L9;
        return;
    L9:
        if (this.f13013J == false) goto L11;
        return;
    L11:
        Drawable r12 = r11.getBackground();
        if (r12 != null) goto L14;
    L16:
        Drawable r13 = r11.getForeground();
        if (r13 != null) goto L19;
        return;
    L19:
        if ((r13 instanceof k) == true) goto L23;
        k r14 = new k(r13, this.f13014a.getResources().getDisplayMetrics());
        r14.a(this.D);
        r11.setForeground(r14);
        return;
    L23:
        return;
    L14:
        if ((r12 instanceof k) == true) goto L16;
        k r15 = new k(r12, this.f13014a.getResources().getDisplayMetrics());
        r15.a(this.D);
        r11.setBackground(r15);
        goto L16
    }

    public void s(Canvas r12, int r13, int r14) {
        View r10 = (View) this.P.get();
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f13053z == null) goto L8;
    L16:
        r12.save();
        r12.translate(r10.getScrollX(), r10.getScrollY());
        int r11 = this.f13024f;
        if (r11 <= 0) goto L22;
        this.f13053z.setStrokeWidth(r11);
        this.f13053z.setColor(td.h.a(this.f13030i, this.A));
        int r15 = this.f13032j;
        if (r15 >= 255) goto L21;
        this.f13053z.setAlpha(r15);
    L21:
        float r16 = this.f13024f / 2.0f;
        r12.drawLine(this.f13026g, r16, r13 - this.f13028h, r16, this.f13053z);
    L22:
        int r17 = this.f13034k;
        if (r17 <= 0) goto L28;
        this.f13053z.setStrokeWidth(r17);
        this.f13053z.setColor(td.h.a(this.f13040n, this.A));
        int r18 = this.f13042o;
        if (r18 >= 255) goto L27;
        this.f13053z.setAlpha(r18);
    L27:
        float r19 = (float) Math.floor(r14 - (this.f13034k / 2.0f));
        r12.drawLine(this.f13036l, r19, r13 - this.f13038m, r19, this.f13053z);
    L28:
        int r20 = this.f13043p;
        if (r20 <= 0) goto L34;
        this.f13053z.setStrokeWidth(r20);
        this.f13053z.setColor(td.h.a(this.f13046s, this.A));
        int r21 = this.f13047t;
        if (r21 >= 255) goto L33;
        this.f13053z.setAlpha(r21);
    L33:
        float r22 = this.f13043p / 2.0f;
        r12.drawLine(r22, this.f13044q, r22, r14 - this.f13045r, this.f13053z);
    L34:
        int r23 = this.f13048u;
        if (r23 <= 0) goto L40;
        this.f13053z.setStrokeWidth(r23);
        this.f13053z.setColor(td.h.a(this.f13051x, this.A));
        int r24 = this.f13052y;
        if (r24 >= 255) goto L39;
        this.f13053z.setAlpha(r24);
    L39:
        float r25 = (float) Math.floor(r13 - (this.f13048u / 2.0f));
        r12.drawLine(r25, this.f13049v, r25, r14 - this.f13050w, this.f13053z);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f13024f <= 0) goto L10;
    L15:
        this.f13053z = new Paint();
        goto L16
    L10:
        if (this.f13034k > 0) goto L15;
        if (this.f13043p > 0) goto L15;
        if (this.f13048u <= 0) goto L16;
        goto L15
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(int r10) {
        this.M = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r10) {
        this.N = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r10) {
        this.f13042o = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r10) {
        this.K = r10;
        M();
        F();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r10) {
        if (this.f13018c == r10) goto L6;
        this.f13018c = r10;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r10) {
        this.f13047t = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r10) {
        this.O = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r10) {
        if (N() == false) goto L9;
        View r11 = (View) this.P.get();
        if (r11 != null) goto L7;
        return;
    L7:
        this.Q = r10;
        r11.invalidateOutline();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r10, int r11, int r12, int r13) {
        if (N() == false) goto L9;
        View r14 = (View) this.P.get();
        if (r14 != null) goto L7;
        return;
    L7:
        this.Z = r10;
        this.f13015a0 = r12;
        this.f13017b0 = r11;
        this.f13019c0 = r13;
        r14.invalidateOutline();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10) {
        if (this.D == r10) goto L6;
        setRadiusAndShadow(r10, this.U, this.V);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, float r12) {
        setRadiusAndShadow(r10, r11, this.W, r12);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r10) {
        this.f13052y = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r10, Shadow r11) {
        setShadow(r10, r11, false);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r10) {
        if (this.V != r10) goto L5;
        return;
    L5:
        this.V = r10;
        G();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r10) {
        if (this.W != r10) goto L5;
        return;
    L5:
        this.W = r10;
        L(r10);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r10) {
        this.f13041n0 = r10;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r10) {
        if (this.U != r10) goto L5;
        return;
    L5:
        this.U = r10;
        G();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r10, int r11) {
        this.X = r10;
        this.Y = r11;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        o(this.f13014a, r10);
        this.f13037l0.q(this.f13033j0);
        this.f13039m0.q(this.f13035k0);
        F();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r10, boolean r11) {
        if (this.f13031i0 == r10) goto L16;
        this.f13031i0 = r10;
        if (r11 == false) goto L11;
        ArrayList r12 = new ArrayList(2);
        r12.add(this.f13037l0.a());
        r12.add(this.f13039m0.a());
        ArrayList r13 = new ArrayList(2);
        if (this.f13031i0 == false) goto L9;
        r13.add(this.f13033j0);
        r13.add(this.f13035k0);
    L10:
        ShadowAnimator.b(this, r12, r13);
    L14:
        F();
        return;
    L9:
        Shadow r14 = Shadow.f13061i;
        r13.add(r14);
        r13.add(r14);
        goto L10
    L11:
        if (r10 == false) goto L13;
        this.f13037l0.q(this.f13033j0);
        this.f13039m0.q(this.f13035k0);
        goto L14
    L13:
        Shadow r15 = this.f13037l0;
        Shadow r16 = Shadow.f13061i;
        r15.q(r16);
        this.f13039m0.q(r16);
        goto L14
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r10) {
        this.T = r10;
        F();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r10) {
        this.f13032j = r10;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        int r10 = i.a(this.f13014a, R$attr.oui_general_shadow_elevation);
        this.U = r10;
        setRadiusAndShadow(this.D, r10, this.V);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r10) {
        if (this.f13016b == r10) goto L6;
        this.f13016b = r10;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r10) {
        this.f13020d = r10;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return false;
    }

    public final void t(Canvas r10, RectF r11, int r12, Paint r13) {
        float r14 = r12 * 1.0f;
        r10.drawRoundRect(r11, r14, r14, r13);
    }

    public final void u(Canvas r10, RectF r11, float[] r12, Paint r13) {
        this.R.reset();
        this.R.addRoundRect(r11, r12, Path.Direction.CW);
        r10.drawPath(this.R, r13);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r10, int r11, int r12, int r13) {
        this.f13036l = r10;
        this.f13038m = r11;
        this.f13040n = r13;
        this.f13034k = r12;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r10) {
        if (this.f13040n == r10) goto L6;
        this.f13040n = r10;
        F();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r10) {
        if (this.A == r10) goto L6;
        this.A = r10;
        F();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r10, int r11, int r12, int r13) {
        this.f13044q = r10;
        this.f13045r = r11;
        this.f13043p = r12;
        this.f13046s = r13;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r10) {
        if (this.f13046s == r10) goto L6;
        this.f13046s = r10;
        F();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r10, int r11, int r12, int r13) {
        this.f13049v = r10;
        this.f13050w = r11;
        this.f13048u = r12;
        this.f13051x = r13;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r10) {
        if (this.f13051x == r10) goto L6;
        this.f13051x = r10;
        F();
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        this.f13037l0.q((Shadow) r10.get(0));
        if (r10.size() <= 1) goto L9;
        this.f13039m0.q((Shadow) r10.get(1));
        goto L10
    L9:
        this.f13039m0.k();
    L10:
        F();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r10, int r11, int r12, int r13) {
        this.f13026g = r10;
        this.f13028h = r11;
        this.f13024f = r12;
        this.f13030i = r13;
        I();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r10) {
        if (this.f13030i == r10) goto L6;
        this.f13030i = r10;
        F();
        return;
    }

    public final void v(Canvas r10) {
        Shadow r11 = this.f13037l0;
        boolean r12 = false;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        Shadow r14 = this.f13039m0;
        if (r14 != null) goto L11;
    L13:
        if (r13 == true) goto L18;
        if (r12 == true) goto L18;
        this.S = null;
        return;
    L18:
        if (this.K == false) goto L20;
    L25:
        w(r10, this.f13037l0);
        w(r10, this.f13039m0);
        return;
    L20:
        if (this.D == 0) goto L22;
    L23:
        Log.e("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        return;
    L22:
        if (this.f13013J == false) goto L25;
    L11:
        if (r14.u() == false) goto L13;
        r12 = true;
        goto L13
    L5:
        if (r11.u() == false) goto L7;
        r13 = true;
        goto L8
    }

    public final void w(Canvas r10, Shadow r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.e() <= 0.0f) goto L7;
        float r12 = r11.e();
    L8:
        View r13 = (View) this.P.get();
        if (this.S != null) goto L11;
        this.S = new Path();
    L11:
        RectF r14 = new RectF(0.0f, 0.0f, r13.getWidth(), r13.getHeight());
        int r15 = this.X;
        if (r15 == 0) goto L14;
    L15:
        r14.inset(r15, this.Y);
    L16:
        this.S.reset();
        this.S.addRoundRect(r14, r12, r12, Path.Direction.CW);
        int r16 = r10.save();
        RectF r17 = new RectF(r14);
        r17.offset(r11.f(), r11.g());
        r17.inset(-r11.j(), -r11.j());
        r10.clipOutPath(this.S);
        r11.h().setColor(r11.d());
        r10.drawRoundRect(r17, r12, r12, r11.h());
        r10.restoreToCount(r16);
        return;
    L14:
        if (this.Y == 0) goto L16;
    L7:
        r12 = this.f13041n0;
        goto L8
    }

    public int z(int r10) {
        if (this.f13018c > 0) goto L5;
        return r10;
    L5:
        if (View.MeasureSpec.getSize(r10) > this.f13018c) goto L7;
        return r10;
    L7:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f13018c, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f13018c, Ints.MAX_POWER_OF_TWO);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r10, int r11, int r12, float r13) {
        View r14 = (View) this.P.get();
        if (r14 != null) goto L5;
        return;
    L5:
        this.D = r10;
        if (this.f13041n0 != 0.0f) goto L8;
        this.f13041n0 = r10;
    L8:
        this.f13013J = H();
        this.U = r11;
        this.V = r13;
        this.W = r12;
        if (N() == false) goto L18;
        int r15 = this.U;
        if (r15 != 0) goto L13;
    L16:
        r14.setElevation(0.0f);
    L17:
        L(this.W);
        r14.setOutlineProvider(new a(this));
        M();
        goto L18
    L13:
        if (this.f13013J == true) goto L16;
        r14.setElevation(r15);
    L18:
        r14.invalidate();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r10, Shadow r11, boolean r12) {
        if (r10 != null) goto L4;
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.equals(this.f13035k0) == true) goto L22;
    L8:
        if (r12 == true) goto L14;
        if (r10 != null) goto L11;
        r10 = Shadow.f13061i.a();
    L11:
        if (r11 != null) goto L13;
        r11 = Shadow.f13061i.a();
    L13:
        this.f13033j0 = r10;
        this.f13035k0 = r11;
        this.f13037l0.q(r10);
        this.f13039m0.q(r11);
    L19:
        F();
        return;
    L14:
        if (r10 != null) goto L16;
        r10 = Shadow.f13061i.a();
    L16:
        if (r11 != null) goto L18;
        r11 = Shadow.f13061i.a();
    L18:
        ArrayList r13 = new ArrayList(2);
        r13.add(r10);
        r13.add(r11);
        ArrayList r14 = new ArrayList(2);
        r14.add(this.f13037l0.a());
        r14.add(this.f13039m0.a());
        ShadowAnimator.a(this, r14, r13);
        goto L19
    L22:
        return;
    L4:
        if (r10.equals(this.f13033j0) == false) goto L8;
        goto L5
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r10, int r11, int r12, int r13) {
        this.F = r10;
        this.G = r11;
        this.H = r12;
        this.I = r13;
        setRadiusAndShadow(this.D, this.U, this.V);
    }
}
