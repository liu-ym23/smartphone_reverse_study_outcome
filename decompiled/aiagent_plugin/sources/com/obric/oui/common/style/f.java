package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.shadow.ShadowTokenCore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OUILayoutHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements b {
    private float A;
    private Paint B;
    private PorterDuffXfermode C;
    private int D;
    private float[] E;
    private int F;
    private int G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f34522J;
    private boolean K;
    private RectF L;
    private int M;
    private int N;
    private int O;
    private WeakReference<View> P;
    private boolean Q;
    private Path R;
    private Path S;
    private boolean T;
    private int U;
    private float V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f34523a;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private AttributeSet ae;
    private int af;
    private int ag;
    private boolean ah;
    private boolean ai;
    private j aj;
    private j ak;
    private final j al;
    private final j am;
    private float an;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34527e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Paint z;

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r1) {
    }

    @Override // com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return false;
    }

    static /* synthetic */ int a(f r0) {
        return r0.g();
    }

    static /* synthetic */ boolean b(f r0) {
        return r0.f34522J;
    }

    static /* synthetic */ int c(f r0) {
        return r0.F;
    }

    static /* synthetic */ int d(f r0) {
        return r0.G;
    }

    static /* synthetic */ int e(f r0) {
        return r0.I;
    }

    static /* synthetic */ int f(f r0) {
        return r0.H;
    }

    static /* synthetic */ boolean g(f r0) {
        return r0.K;
    }

    static /* synthetic */ int h(f r0) {
        return r0.ab;
    }

    static /* synthetic */ int i(f r0) {
        return r0.ac;
    }

    static /* synthetic */ int j(f r0) {
        return r0.Z;
    }

    static /* synthetic */ int k(f r0) {
        return r0.aa;
    }

    static /* synthetic */ boolean l(f r0) {
        return r0.Q;
    }

    static /* synthetic */ float m(f r0) {
        return r0.V;
    }

    static /* synthetic */ int n(f r0) {
        return r0.U;
    }

    public f(Context r5, AttributeSet r6, int r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        this.f34524b = 0;
        this.f34525c = 0;
        this.f34526d = 0;
        this.f34527e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.j = 255;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.o = 255;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = 255;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.y = 255;
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
        this.aa = 0;
        this.ab = 0;
        this.ac = 0;
        this.ad = false;
        this.ah = false;
        this.ai = true;
        this.aj = j.f34540b.j();
        this.ak = j.f34540b.j();
        this.al = j.f34540b.j();
        this.am = j.f34540b.j();
        this.an = 0.0f;
        this.f34523a = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
        this.ae = r10;
        this.af = r7;
        this.ag = r8;
    }

    public void a(boolean r1) {
        this.ah = r1;
    }

    public void a(View r19) {
        float r2 = ZeusTransformUtils.getResources(r19, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        this.P = new WeakReference(r19);
        int r1 = androidx.core.content.a.c(this.f34523a, ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2"));
        this.i = r1;
        this.n = r1;
        int r3 = androidx.core.content.a.c(this.f34523a, ZeusTransformUtils.mapRes(R.color.oui_line_2, "color", "oui_line_2"));
        this.x = r3;
        this.s = r3;
        this.C = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r4 = new Paint();
        this.B = r4;
        r4.setAntiAlias(true);
        float r5 = g.a(this.f34523a, ZeusTransformUtils.mapRes(R.attr.oui_general_shadow_alpha, "attr", "oui_general_shadow_alpha"));
        if (r5 <= 0.0f) goto L5;
        this.V = r5;
    L5:
        this.L = new RectF();
        int r6 = 0;
        if (this.ah == false) goto L8;
    L15:
        TypedArray r7 = this.f34523a.obtainStyledAttributes(this.ae, R.styleable.OUILayout, this.af, this.ag);
        int r8 = r7.getIndexCount();
        int r9 = 0;
        int r10 = 0;
        boolean r11 = false;
        int r17 = 0;
    L17:
        if (r9 >= r8) goto L133;
        int r12 = r7.getIndex(r9);
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_android_maxWidth, "styleable", "OUILayout_android_maxWidth")) goto L22;
        this.f34524b = r7.getDimensionPixelSize(r12, this.f34524b);
    L124:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_bottomLeft_radius, "styleable", "OUILayout_oui_bottomLeft_radius")) goto L127;
        this.H = r7.getDimensionPixelSize(r12, 0);
    L127:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_bottomRight_radius, "styleable", "OUILayout_oui_bottomRight_radius")) goto L130;
        this.I = r7.getDimensionPixelSize(r12, 0);
    L130:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_topRight_radius, "styleable", "OUILayout_oui_topRight_radius")) goto L132;
        this.G = r7.getDimensionPixelSize(r12, 0);
    L132:
        r9 = r9 + 1;
        goto L17
    L22:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_android_maxHeight, "styleable", "OUILayout_android_maxHeight")) goto L25;
        this.f34525c = r7.getDimensionPixelSize(r12, this.f34525c);
        goto L124
    L25:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_android_minWidth, "styleable", "OUILayout_android_minWidth")) goto L28;
        this.f34526d = r7.getDimensionPixelSize(r12, this.f34526d);
        goto L124
    L28:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_android_minHeight, "styleable", "OUILayout_android_minHeight")) goto L31;
        this.f34527e = r7.getDimensionPixelSize(r12, this.f34527e);
        goto L124
    L31:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_topDividerColor, "styleable", "OUILayout_oui_topDividerColor")) goto L34;
        this.i = r7.getColor(r12, this.i);
        goto L124
    L34:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_topDividerHeight, "styleable", "OUILayout_oui_topDividerHeight")) goto L37;
        this.f = r7.getDimensionPixelSize(r12, this.f);
        goto L124
    L37:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_topDividerInsetLeft, "styleable", "OUILayout_oui_topDividerInsetLeft")) goto L40;
        this.g = r7.getDimensionPixelSize(r12, this.g);
        goto L124
    L40:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_topDividerInsetRight, "styleable", "OUILayout_oui_topDividerInsetRight")) goto L43;
        this.h = r7.getDimensionPixelSize(r12, this.h);
        goto L124
    L43:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_bottomDividerColor, "styleable", "OUILayout_oui_bottomDividerColor")) goto L46;
        this.n = r7.getColor(r12, this.n);
        goto L124
    L46:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_bottomDividerHeight, "styleable", "OUILayout_oui_bottomDividerHeight")) goto L49;
        this.k = r7.getDimensionPixelSize(r12, this.k);
        goto L124
    L49:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_bottomDividerInsetLeft, "styleable", "OUILayout_oui_bottomDividerInsetLeft")) goto L52;
        this.l = r7.getDimensionPixelSize(r12, this.l);
        goto L124
    L52:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_bottomDividerInsetRight, "styleable", "OUILayout_oui_bottomDividerInsetRight")) goto L55;
        this.m = r7.getDimensionPixelSize(r12, this.m);
        goto L124
    L55:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_leftDividerColor, "styleable", "OUILayout_oui_leftDividerColor")) goto L58;
        this.s = r7.getColor(r12, this.s);
        goto L124
    L58:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_leftDividerWidth, "styleable", "OUILayout_oui_leftDividerWidth")) goto L61;
        this.p = r7.getDimensionPixelSize(r12, this.p);
        goto L124
    L61:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_leftDividerInsetTop, "styleable", "OUILayout_oui_leftDividerInsetTop")) goto L64;
        this.q = r7.getDimensionPixelSize(r12, this.q);
        goto L124
    L64:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_leftDividerInsetBottom, "styleable", "OUILayout_oui_leftDividerInsetBottom")) goto L67;
        this.r = r7.getDimensionPixelSize(r12, this.r);
        goto L124
    L67:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_rightDividerColor, "styleable", "OUILayout_oui_rightDividerColor")) goto L70;
        this.x = r7.getColor(r12, this.x);
        goto L124
    L70:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_rightDividerWidth, "styleable", "OUILayout_oui_rightDividerWidth")) goto L73;
        this.u = r7.getDimensionPixelSize(r12, this.u);
        goto L124
    L73:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_rightDividerInsetTop, "styleable", "OUILayout_oui_rightDividerInsetTop")) goto L76;
        this.v = r7.getDimensionPixelSize(r12, this.v);
        goto L124
    L76:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_rightDividerInsetBottom, "styleable", "OUILayout_oui_rightDividerInsetBottom")) goto L79;
        this.w = r7.getDimensionPixelSize(r12, this.w);
        goto L124
    L79:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_layout_borderColor, "styleable", "OUILayout_oui_layout_borderColor")) goto L82;
        this.M = r7.getColor(r12, this.M);
        goto L124
    L82:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_layout_borderWidth, "styleable", "OUILayout_oui_layout_borderWidth")) goto L85;
        this.N = r7.getDimensionPixelSize(r12, this.N);
        goto L124
    L85:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_radius, "styleable", "OUILayout_oui_radius")) goto L88;
        r17 = r7.getDimensionPixelSize(r12, 0);
        goto L124
    L88:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_outerNormalColor, "styleable", "OUILayout_oui_outerNormalColor")) goto L91;
        this.O = r7.getColor(r12, this.O);
        goto L124
    L91:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_showBorderOnlyBeforeL, "styleable", "OUILayout_oui_showBorderOnlyBeforeL")) goto L94;
        this.T = r7.getBoolean(r12, this.T);
        goto L124
    L94:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_shadowElevation, "styleable", "OUILayout_oui_shadowElevation")) goto L97;
        r10 = r7.getDimensionPixelSize(r12, r10);
        goto L124
    L97:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_shadowAlpha, "styleable", "OUILayout_oui_shadowAlpha")) goto L100;
        this.V = r7.getFloat(r12, this.V);
        goto L124
    L100:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_useThemeGeneralShadowElevation, "styleable", "OUILayout_oui_useThemeGeneralShadowElevation")) goto L103;
        r11 = r7.getBoolean(r12, false);
        goto L124
    L103:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_outlineInsetLeft, "styleable", "OUILayout_oui_outlineInsetLeft")) goto L106;
        this.Z = r7.getDimensionPixelSize(r12, 0);
        goto L124
    L106:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_outlineInsetRight, "styleable", "OUILayout_oui_outlineInsetRight")) goto L109;
        this.aa = r7.getDimensionPixelSize(r12, 0);
        goto L124
    L109:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_outlineInsetTop, "styleable", "OUILayout_oui_outlineInsetTop")) goto L112;
        this.ab = r7.getDimensionPixelSize(r12, 0);
        goto L124
    L112:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_outlineInsetBottom, "styleable", "OUILayout_oui_outlineInsetBottom")) goto L115;
        this.ac = r7.getDimensionPixelSize(r12, 0);
        goto L124
    L115:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_outlineExcludePadding, "styleable", "OUILayout_oui_outlineExcludePadding")) goto L118;
        this.Q = r7.getBoolean(r12, false);
        goto L124
    L118:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_support_image_mirroring, "styleable", "OUILayout_oui_support_image_mirroring")) goto L121;
        this.ad = r7.getBoolean(r12, false);
        goto L124
    L121:
        if (r12 != ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_topLeft_radius, "styleable", "OUILayout_oui_topLeft_radius")) goto L124;
        this.F = r7.getDimensionPixelSize(r12, 0);
        goto L124
    L133:
        com.obric.oui.shadow.b[] r13 = ShadowTokenCore.parse(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_shadow, "styleable", "OUILayout_oui_shadow")));
        if (r13 == null) goto L139;
        this.aj.a(r13[0], r2);
        if (r13.length <= 1) goto L138;
        this.ak.a(r13[1], r2);
    L138:
        String r14 = "styleable";
    L143:
        this.al.update(this.aj);
        this.am.update(this.ak);
        this.an = r7.getDimension(ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_shadowCornerRadius, r14, "OUILayout_oui_shadowCornerRadius"), 0.0f);
        r7.recycle();
        r6 = r10;
        int r15 = r17;
    L144:
        if (r6 != 0) goto L147;
        if (r11 == false) goto L147;
        r6 = g.b(this.f34523a, ZeusTransformUtils.mapRes(R.attr.oui_general_shadow_elevation, "attr", "oui_general_shadow_elevation"));
    L147:
        setRadiusAndShadow(r15, r6, this.V);
        return;
    L139:
        int r16 = r7.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_shadow_style, "styleable", "OUILayout_oui_shadow_style"), 0);
        if (r16 == 0) goto L142;
        b(this.f34523a, r16);
        goto L138
    L142:
        r14 = "styleable";
        this.aj.a(com.obric.oui.shadow.a.a(r7, ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowColor, "styleable", "OUILayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowBlur, "styleable", "OUILayout_oui_firstShadowBlur"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstOffsetX, "styleable", "OUILayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstOffsetY, "styleable", "OUILayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowSpread, "styleable", "OUILayout_oui_firstShadowSpread")));
        this.ak.a(com.obric.oui.shadow.a.a(r7, ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowColor, r14, "OUILayout_oui_secondShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowBlur, r14, "OUILayout_oui_secondShadowBlur"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondOffsetX, r14, "OUILayout_oui_secondOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondOffsetY, r14, "OUILayout_oui_secondOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowSpread, r14, "OUILayout_oui_secondShadowSpread")));
        goto L143
    L8:
        if (this.ae != null) goto L15;
        if (this.af != 0) goto L15;
        if (this.ag != 0) goto L15;
        r15 = 0;
        r11 = false;
        goto L144
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowStyle(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        b(this.f34523a, r2);
        this.al.update(this.aj);
        this.am.update(this.ak);
        e();
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowInsets(int r1, int r2) {
        this.X = r1;
        this.Y = r2;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r1) {
        this.an = r1;
    }

    private void b(Context r9, int r10) {
        TypedArray r11 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r10, R.styleable.OUILayout);
        this.aj.a(com.obric.oui.shadow.a.a(r11, ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowColor, "styleable", "OUILayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowBlur, "styleable", "OUILayout_oui_firstShadowBlur"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstOffsetX, "styleable", "OUILayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstOffsetY, "styleable", "OUILayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowSpread, "styleable", "OUILayout_oui_firstShadowSpread")));
        this.ak.a(com.obric.oui.shadow.a.a(r11, ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowColor, "styleable", "OUILayout_oui_secondShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowBlur, "styleable", "OUILayout_oui_secondShadowBlur"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondOffsetX, "styleable", "OUILayout_oui_secondOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondOffsetY, "styleable", "OUILayout_oui_secondOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowSpread, "styleable", "OUILayout_oui_secondShadowSpread")));
        r11.recycle();
    }

    public static List<j> a(Context r2, TypedArray r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        List<j> r0 = a(r5, r3.getString(r4));
        if (r0 == null) goto L6;
        ArrayList r6 = new ArrayList(2);
        r6.addAll(r0);
        return r6;
    L6:
        int r7 = r3.getResourceId(r4, 0);
        if (r7 != 0) goto L10;
        return null;
    L10:
        List<j> r8 = a(r5, r7);
        ArrayList r9 = new ArrayList(2);
        r9.addAll(r8);
        return r9;
    }

    public static List<j> a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.shadow.b[] r8 = ShadowTokenCore.parse(r6);
        if (r8 != null) goto L6;
        return null;
    L6:
        float r9 = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        ArrayList r0 = new ArrayList();
        j r1 = j.b(r8[0], r9);
        j r2 = j.f34540b;
        if (r8.length <= 1) goto L9;
        r2 = j.b(r8[1], r9);
    L9:
        r0.add(r1);
        r0.add(r2);
        return r0;
    }

    public static List<j> a(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        TypedArray r11 = r10.obtainStyledAttributes(r9, R.styleable.OUILayout);
        j r12 = j.b(com.obric.oui.shadow.a.a(r11, ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowColor, "styleable", "OUILayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowBlur, "styleable", "OUILayout_oui_firstShadowBlur"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstOffsetX, "styleable", "OUILayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstOffsetY, "styleable", "OUILayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_firstShadowSpread, "styleable", "OUILayout_oui_firstShadowSpread")));
        j r1 = j.b(com.obric.oui.shadow.a.a(r11, ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowColor, "styleable", "OUILayout_oui_secondShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowBlur, "styleable", "OUILayout_oui_secondShadowBlur"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondOffsetX, "styleable", "OUILayout_oui_secondOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondOffsetY, "styleable", "OUILayout_oui_secondOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OUILayout_oui_secondShadowSpread, "styleable", "OUILayout_oui_secondShadowSpread")));
        r11.recycle();
        r0.add(r12);
        r0.add(r1);
        return r0;
    }

    @Override // com.obric.oui.common.style.b
    public void setUseThemeGeneralShadowElevation() {
        int r0 = g.b(this.f34523a, ZeusTransformUtils.mapRes(R.attr.oui_general_shadow_elevation, "attr", "oui_general_shadow_elevation"));
        this.U = r0;
        setRadiusAndShadow(this.D, r0, this.V);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineExcludePadding(boolean r4) {
        if (b() == false) goto L9;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        this.Q = r4;
        r0.invalidateOutline();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public boolean setWidthLimit(int r2) {
        if (this.f34524b == r2) goto L6;
        this.f34524b = r2;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public boolean setHeightLimit(int r2) {
        if (this.f34525c == r2) goto L6;
        this.f34525c = r2;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        this.f34526d = r1;
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftSeparatorColor(int r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        e();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomSeparatorColor(int r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        e();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopSeparatorColor(int r2) {
        if (this.i == r2) goto L6;
        this.i = r2;
        e();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightSeparatorColor(int r2) {
        if (this.x == r2) goto L6;
        this.x = r2;
        e();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void updateDividerColorStrength(float r2) {
        if (this.A == r2) goto L6;
        this.A = r2;
        e();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowElevation() {
        return this.U;
    }

    @Override // com.obric.oui.common.style.b
    public float getShadowAlpha() {
        return this.V;
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowColor() {
        return this.W;
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineInset(int r4, int r5, int r6, int r7) {
        if (b() == false) goto L9;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        this.Z = r4;
        this.aa = r6;
        this.ab = r5;
        this.ac = r7;
        r0.invalidateOutline();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.T = r1;
        e();
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowElevation(int r2) {
        if (this.U != r2) goto L5;
        return;
    L5:
        this.U = r2;
        d();
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowAlpha(float r2) {
        if (this.V != r2) goto L5;
        return;
    L5:
        this.V = r2;
        d();
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowColor(int r2) {
        if (this.W != r2) goto L5;
        return;
    L5:
        this.W = r2;
        d(r2);
    }

    private void d(int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return;
    L7:
        r2.setOutlineAmbientShadowColor(r3);
        r2.setOutlineSpotShadowColor(r3);
        return;
    }

    private void d() {
        if (b() == false) goto L13;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        int r3 = this.U;
        if (r3 != 0) goto L10;
        r0.setElevation(0.0f);
    L11:
        r0.invalidateOutline();
        return;
    L10:
        r0.setElevation(r3);
        goto L11
    }

    private void e() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        r2.invalidate();
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r3) {
        if (this.D == r3) goto L6;
        setRadiusAndShadow(r3, this.U, this.V);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.F = r1;
        this.G = r2;
        this.H = r3;
        this.I = r4;
        setRadiusAndShadow(this.D, this.U, this.V);
    }

    @Override // com.obric.oui.common.style.b
    public int getRadius() {
        return this.D;
    }

    @Override // com.obric.oui.common.style.b
    public void setEnableShadowWidthRadius(boolean r1) {
        this.K = r1;
        f();
        e();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isEnableShadowWidthRadius() {
        return this.K;
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r2, int r3, float r4) {
        setRadiusAndShadow(r2, r3, this.W, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r4, int r5, int r6, float r7) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        this.D = r4;
        if (this.an != 0.0f) goto L8;
        this.an = r4;
    L8:
        this.f34522J = a();
        this.U = r5;
        this.V = r7;
        this.W = r6;
        if (b() == false) goto L18;
        int r8 = this.U;
        if (r8 != 0) goto L13;
    L16:
        r0.setElevation(0.0f);
    L17:
        d(this.W);
        r0.setOutlineProvider(new OUILayoutHelper$1(this));
        f();
        goto L18
    L13:
        if (this.f34522J == true) goto L16;
        r0.setElevation(r8);
    L18:
        r0.invalidate();
    }

    private void f() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (this.K == false) goto L8;
        r0.setClipToOutline(false);
        return;
    L8:
        int r3 = this.D;
        if (r3 != (-2)) goto L11;
    L13:
        r2 = true;
    L14:
        r0.setClipToOutline(r2);
        return;
    L11:
        if (r3 == (-1)) goto L13;
        if (r3 <= 0) goto L14;
        goto L13
    }

    public boolean a() {
        if (this.H <= 0) goto L5;
    L12:
        return true;
    L5:
        if (this.G > 0) goto L12;
        if (this.F > 0) goto L12;
        if (this.I > 0) goto L12;
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.g = r1;
        this.h = r2;
        this.f = r3;
        this.i = r4;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.l = r1;
        this.m = r2;
        this.n = r4;
        this.k = r3;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.q = r1;
        this.r = r2;
        this.p = r3;
        this.s = r4;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.v = r1;
        this.w = r2;
        this.u = r3;
        this.x = r4;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        updateTopDivider(r1, r2, r3, r4);
        this.p = 0;
        this.u = 0;
        this.k = 0;
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        updateBottomDivider(r1, r2, r3, r4);
        this.p = 0;
        this.u = 0;
        this.f = 0;
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        updateLeftDivider(r1, r2, r3, r4);
        this.u = 0;
        this.f = 0;
        this.k = 0;
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        updateRightDivider(r1, r2, r3, r4);
        this.p = 0;
        this.f = 0;
        this.k = 0;
    }

    @Override // com.obric.oui.common.style.b
    public void setTopDividerAlpha(int r1) {
        this.j = r1;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void setBottomDividerAlpha(int r1) {
        this.o = r1;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void setLeftDividerAlpha(int r1) {
        this.t = r1;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void setRightDividerAlpha(int r1) {
        this.y = r1;
        c();
    }

    public int a(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.f34526d;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
    L8:
        return r3;
    }

    public int b(int r3, int r4) {
        if (View.MeasureSpec.getMode(r3) == 1073741824) goto L8;
        int r2 = this.f34527e;
        if (r4 >= r2) goto L8;
        return View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
    L8:
        return r3;
    }

    public int a(int r3) {
        if (this.f34524b > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.f34524b) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f34524b, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f34524b, 1073741824);
    }

    public int b(int r3) {
        if (this.f34525c > 0) goto L5;
        return r3;
    L5:
        if (View.MeasureSpec.getSize(r3) > this.f34525c) goto L7;
        return r3;
    L7:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f34525c, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f34525c, 1073741824);
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderColor(int r1) {
        this.M = r1;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderWidth(int r1) {
        this.N = r1;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public void setOuterNormalColor(int r1) {
        this.O = r1;
        c();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasTopSeparator() {
        if (this.f <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasRightSeparator() {
        if (this.u <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBottomSeparator() {
        if (this.k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasLeftSeparator() {
        if (this.p <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBorder() {
        if (this.N <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public void a(j r2, j r3) {
        setShadow(r2, r3, false);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadow(j r2, j r3, boolean r4) {
        if (r2 != null) goto L4;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.equals(this.ak) == true) goto L22;
    L8:
        if (r4 == true) goto L14;
        if (r2 != null) goto L11;
        r2 = j.f34540b.j();
    L11:
        if (r3 != null) goto L13;
        r3 = j.f34540b.j();
    L13:
        this.aj = r2;
        this.ak = r3;
        this.al.update(r2);
        this.am.update(r3);
    L19:
        e();
        return;
    L14:
        if (r2 != null) goto L16;
        r2 = j.f34540b.j();
    L16:
        if (r3 != null) goto L18;
        r3 = j.f34540b.j();
    L18:
        ArrayList r5 = new ArrayList(2);
        r5.add(r2);
        r5.add(r3);
        ArrayList r6 = new ArrayList(2);
        r6.add(this.al.j());
        r6.add(this.am.j());
        k.a(this, r6, r5);
        goto L19
    L22:
        return;
    L4:
        if (r2.equals(this.aj) == false) goto L8;
        goto L5
    }

    @Override // com.obric.oui.common.style.b
    public List<j> getCurrentShadows() {
        ArrayList r0 = new ArrayList(2);
        j r1 = this.al;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        j r2 = this.am;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    @Override // com.obric.oui.common.style.b
    public void updateShadows(List<j> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.isEmpty() == true) goto L11;
        this.al.update((j) ZeusTransformUtils.preCheckCast(r6.get(0), j.class, "com.obric.aiagent.plugin"));
        if (r6.size() <= 1) goto L10;
        this.am.update((j) ZeusTransformUtils.preCheckCast(r6.get(1), j.class, "com.obric.aiagent.plugin"));
        goto L11
    L10:
        this.am.i();
    L11:
        e();
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowVisible(boolean r2, boolean r3) {
        if (this.ai == r2) goto L16;
        this.ai = r2;
        if (r3 == false) goto L11;
        ArrayList r4 = new ArrayList(2);
        r4.add(this.al.j());
        r4.add(this.am.j());
        ArrayList r0 = new ArrayList(2);
        if (this.ai == false) goto L9;
        r0.add(this.aj);
        r0.add(this.ak);
    L10:
        k.b(this, r4, r0);
    L14:
        e();
        return;
    L9:
        r0.add(j.f34540b);
        r0.add(j.f34540b);
        goto L10
    L11:
        if (r2 == false) goto L13;
        this.al.update(this.aj);
        this.am.update(this.ak);
        goto L14
    L13:
        this.al.update(j.f34540b);
        this.am.update(j.f34540b);
        goto L14
    }

    @Override // com.obric.oui.common.style.b
    public boolean isShadowVisible() {
        return this.ai;
    }

    public void a(Canvas r12, int r13, int r14) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.z == null) goto L8;
    L16:
        r12.save();
        r12.translate(r0.getScrollX(), r0.getScrollY());
        int r1 = this.f;
        if (r1 <= 0) goto L22;
        this.z.setStrokeWidth(r1);
        this.z.setColor(com.obric.oui.d.h.a(this.i, this.A));
        int r2 = this.j;
        if (r2 >= 255) goto L21;
        this.z.setAlpha(r2);
    L21:
        float r7 = this.f / 2.0f;
        r12.drawLine(this.g, r7, r13 - this.h, r7, this.z);
    L22:
        int r3 = this.k;
        if (r3 <= 0) goto L28;
        this.z.setStrokeWidth(r3);
        this.z.setColor(com.obric.oui.d.h.a(this.n, this.A));
        int r4 = this.o;
        if (r4 >= 255) goto L27;
        this.z.setAlpha(r4);
    L27:
        float r9 = (float) Math.floor(r14 - (this.k / 2.0f));
        r12.drawLine(this.l, r9, r13 - this.m, r9, this.z);
    L28:
        int r5 = this.p;
        if (r5 <= 0) goto L34;
        this.z.setStrokeWidth(r5);
        this.z.setColor(com.obric.oui.d.h.a(this.s, this.A));
        int r6 = this.t;
        if (r6 >= 255) goto L33;
        this.z.setAlpha(r6);
    L33:
        float r8 = this.p / 2.0f;
        r12.drawLine(r8, this.q, r8, r14 - this.r, this.z);
    L34:
        int r10 = this.u;
        if (r10 <= 0) goto L40;
        this.z.setStrokeWidth(r10);
        this.z.setColor(com.obric.oui.d.h.a(this.x, this.A));
        int r11 = this.y;
        if (r11 >= 255) goto L39;
        this.z.setAlpha(r11);
    L39:
        float r15 = (float) Math.floor(r13 - (this.u / 2.0f));
        r12.drawLine(r15, this.v, r15, r14 - this.w, this.z);
    L40:
        r12.restore();
        return;
    L8:
        if (this.f <= 0) goto L10;
    L15:
        this.z = new Paint();
        goto L16
    L10:
        if (this.k > 0) goto L15;
        if (this.p > 0) goto L15;
        if (this.u <= 0) goto L16;
        goto L15
    }

    private int g() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        int r3 = this.D;
        if (r3 != (-1)) goto L10;
        return r0.getHeight() / 2;
    L10:
        if (r3 == (-2)) goto L12;
        return r3;
    L12:
        return r0.getWidth() / 2;
    L5:
        return this.D;
    }

    public void a(Canvas r5) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        c(r5);
        if (r0.isHardwareAccelerated() == false) goto L9;
        return;
    L9:
        if (this.f34522J == false) goto L11;
        return;
    L11:
        Drawable r6 = r0.getBackground();
        if (r6 != null) goto L14;
    L16:
        Drawable r7 = r0.getForeground();
        if (r7 != null) goto L19;
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r7, RoundCornerDrawable.class) == true) goto L23;
        RoundCornerDrawable r1 = new RoundCornerDrawable(r7, ZeusTransformUtils.getResources(this.f34523a, "com.obric.aiagent.plugin").getDisplayMetrics());
        r1.setRadius(this.D);
        r0.setForeground(r1);
        return;
    L23:
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r6, RoundCornerDrawable.class) == true) goto L16;
        RoundCornerDrawable r2 = new RoundCornerDrawable(r6, ZeusTransformUtils.getResources(this.f34523a, "com.obric.aiagent.plugin").getDisplayMetrics());
        r2.setRadius(this.D);
        r0.setBackground(r2);
        goto L16
    }

    public void b(Canvas r16) {
        View r1 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        int r9 = g();
        if (r9 > 0) goto L8;
    L12:
        boolean r4 = false;
    L14:
        if (this.N > 0) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r4 == true) goto L23;
        if (r10 == true) goto L23;
        return;
    L23:
        if (this.T == true) goto L25;
    L29:
        int r5 = r16.getWidth();
        int r6 = r16.getHeight();
        r16.save();
        r16.translate(r1.getScrollX(), r1.getScrollY());
        float r7 = this.N / 2.0f;
        if (this.Q == false) goto L32;
        this.L.set(r1.getPaddingLeft() + r7, r1.getPaddingTop() + r7, (r5 - r1.getPaddingRight()) - r7, (r6 - r1.getPaddingBottom()) - r7);
    L34:
        if (this.f34522J == true) goto L36;
    L39:
        if (r4 == false) goto L45;
        int r2 = r16.saveLayer(0.0f, 0.0f, r5, r6, null, 31);
        r16.drawColor(this.O);
        this.B.setColor(this.O);
        this.B.setStyle(Paint.Style.FILL);
        this.B.setXfermode(this.C);
        if (this.f34522J == true) goto L43;
        a(r16, this.L, r9, this.B);
    L44:
        this.B.setXfermode(null);
        r16.restoreToCount(r2);
        goto L45
    L43:
        a(r16, this.L, this.E, this.B);
    L45:
        if (r10 == false) goto L52;
        this.B.setColor(this.M);
        this.B.setStrokeWidth(this.N);
        this.B.setStyle(Paint.Style.STROKE);
        if (this.f34522J == false) goto L49;
        a(r16, this.L, this.E, this.B);
        goto L52
    L49:
        if (r9 > 0) goto L51;
        r16.drawRect(this.L, this.B);
        goto L52
    L51:
        a(r16, this.L, r9, this.B);
    L52:
        r16.restore();
        return;
    L36:
        if (this.E != null) goto L38;
        this.E = new float[8];
    L38:
        float[] r3 = this.E;
        int r8 = this.F;
        r3[0] = r8;
        r3[1] = r8;
        int r11 = this.G;
        r3[2] = r11;
        r3[3] = r11;
        int r12 = this.H;
        r3[4] = r12;
        r3[5] = r12;
        int r13 = this.I;
        r3[6] = r13;
        r3[7] = r13;
        goto L39
    L32:
        this.L.set(r7, r7, r5 - r7, r6 - r7);
        goto L34
    L25:
        if (b() == false) goto L29;
        if (this.U == 0) goto L29;
        return;
    L16:
        if (this.M == 0) goto L18;
        r10 = true;
        goto L19
    L8:
        if (b() == true) goto L12;
        if (this.O == 0) goto L12;
        r4 = true;
        goto L14
    }

    private void c(Canvas r5) {
        j r0 = this.al;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        j r3 = this.am;
        if (r3 != null) goto L11;
    L13:
        r1 = false;
    L14:
        if (r2 == true) goto L19;
        if (r1 == true) goto L19;
        this.S = null;
        return;
    L19:
        if (this.K == false) goto L21;
    L26:
        a(r5, this.al);
        a(r5, this.am);
        return;
    L21:
        if (this.D == 0) goto L23;
    L24:
        a("OUILayoutHelper", " 阴影和圆角同时存在阴影不生效");
        return;
    L23:
        if (this.f34522J == false) goto L26;
    L11:
        if (r3.h() == false) goto L13;
    L5:
        if (r0.h() == false) goto L7;
        r2 = true;
        goto L8
    }

    private void a(Canvas r6, j r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.g() <= 0.0f) goto L7;
        float r0 = r7.g();
    L8:
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (this.S != null) goto L11;
        this.S = new Path();
    L11:
        RectF r4 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        int r1 = this.X;
        if (r1 == 0) goto L14;
    L15:
        r4.inset(r1, this.Y);
    L16:
        this.S.reset();
        this.S.addRoundRect(r4, r0, r0, Path.Direction.CW);
        int r3 = r6.save();
        RectF r5 = new RectF(r4);
        r5.offset(r7.c(), r7.d());
        r5.inset(-r7.e(), -r7.e());
        r6.clipOutPath(this.S);
        r7.f().setColor(r7.a());
        r6.drawRoundRect(r5, r0, r0, r7.f());
        r6.restoreToCount(r3);
        return;
    L14:
        if (this.Y == 0) goto L16;
    L7:
        r0 = this.an;
        goto L8
    }

    private void a(Canvas r3, RectF r4, float[] r5, Paint r6) {
        this.R.reset();
        this.R.addRoundRect(r4, r5, Path.Direction.CW);
        r3.drawPath(this.R, r6);
    }

    private void a(Canvas r1, RectF r2, int r3, Paint r4) {
        float r0 = r3 * 1.0f;
        r1.drawRoundRect(r2, r0, r0, r4);
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    public void c() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.P.get(), View.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.invalidate();
        return;
    }

    public boolean c(int r1) {
        this.f34527e = r1;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
