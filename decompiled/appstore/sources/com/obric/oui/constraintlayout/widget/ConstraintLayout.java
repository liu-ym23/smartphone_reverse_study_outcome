package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.constraintlayout.core.c;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.oui.constraintlayout.core.widgets.d;
import com.obric.oui.constraintlayout.core.widgets.f;
import com.obric.oui.constraintlayout.core.widgets.g;
import com.obric.oui.constraintlayout.core.widgets.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static SharedValues f14060y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f14061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f14062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f14063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.constraintlayout.widget.a f14070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zc.a f14071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f14073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14078r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f14079s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SparseArray f14080t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f14081u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14082v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList f14084x;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E;
        public boolean F;
        public float G;
        public float H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public float f14085J;
        public int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14086a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f14087a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14088b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f14089b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f14090c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f14091c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f14092d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f14093d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14094e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f14095e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14096f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f14097f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14098g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f14099g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14100h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f14101h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14102i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f14103i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f14104j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f14105j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f14106k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public boolean f14107k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f14108l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f14109l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f14110m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public int f14111m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f14112n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f14113n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f14114o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f14115o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f14116p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f14117p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f14118q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f14119q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f14120r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f14121r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f14122s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public int f14123s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f14124t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f14125t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f14126u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f14127u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f14128v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public ConstraintWidget f14129v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f14130w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f14131w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f14132x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f14133y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f14134z;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f14135a = null;

            static {
                SparseIntArray r10 = new SparseIntArray();
                f14135a = r10;
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                r10.append(R$styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                r10.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                r10.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f14086a = -1;
            this.f14088b = -1;
            this.f14090c = -1.0f;
            this.f14092d = true;
            this.f14094e = -1;
            this.f14096f = -1;
            this.f14098g = -1;
            this.f14100h = -1;
            this.f14102i = -1;
            this.f14104j = -1;
            this.f14106k = -1;
            this.f14108l = -1;
            this.f14110m = -1;
            this.f14112n = -1;
            this.f14114o = -1;
            this.f14116p = -1;
            this.f14118q = 0;
            this.f14120r = 0.0f;
            this.f14122s = -1;
            this.f14124t = -1;
            this.f14126u = -1;
            this.f14128v = -1;
            this.f14130w = Integer.MIN_VALUE;
            this.f14132x = Integer.MIN_VALUE;
            this.f14133y = Integer.MIN_VALUE;
            this.f14134z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f14085J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f14087a0 = false;
            this.f14089b0 = false;
            this.f14091c0 = null;
            this.f14093d0 = 0;
            this.f14095e0 = true;
            this.f14097f0 = true;
            this.f14099g0 = false;
            this.f14101h0 = false;
            this.f14103i0 = false;
            this.f14105j0 = false;
            this.f14107k0 = false;
            this.f14109l0 = -1;
            this.f14111m0 = -1;
            this.f14113n0 = -1;
            this.f14115o0 = -1;
            this.f14117p0 = Integer.MIN_VALUE;
            this.f14119q0 = Integer.MIN_VALUE;
            this.f14121r0 = 0.5f;
            this.f14129v0 = new ConstraintWidget();
            this.f14131w0 = false;
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r11.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r11.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r11.topMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r11.bottomMargin;
            setMarginStart(r11.getMarginStart());
            setMarginEnd(r11.getMarginEnd());
        L6:
            if ((r10 instanceof LayoutParams) == true) goto L8;
            return;
        L8:
            LayoutParams r12 = (LayoutParams) r10;
            this.f14086a = r12.f14086a;
            this.f14088b = r12.f14088b;
            this.f14090c = r12.f14090c;
            this.f14092d = r12.f14092d;
            this.f14094e = r12.f14094e;
            this.f14096f = r12.f14096f;
            this.f14098g = r12.f14098g;
            this.f14100h = r12.f14100h;
            this.f14102i = r12.f14102i;
            this.f14104j = r12.f14104j;
            this.f14106k = r12.f14106k;
            this.f14108l = r12.f14108l;
            this.f14110m = r12.f14110m;
            this.f14112n = r12.f14112n;
            this.f14114o = r12.f14114o;
            this.f14116p = r12.f14116p;
            this.f14118q = r12.f14118q;
            this.f14120r = r12.f14120r;
            this.f14122s = r12.f14122s;
            this.f14124t = r12.f14124t;
            this.f14126u = r12.f14126u;
            this.f14128v = r12.f14128v;
            this.f14130w = r12.f14130w;
            this.f14132x = r12.f14132x;
            this.f14133y = r12.f14133y;
            this.f14134z = r12.f14134z;
            this.A = r12.A;
            this.B = r12.B;
            this.C = r12.C;
            this.D = r12.D;
            this.G = r12.G;
            this.H = r12.H;
            this.I = r12.I;
            this.f14085J = r12.f14085J;
            this.K = r12.K;
            this.L = r12.L;
            this.M = r12.M;
            this.N = r12.N;
            this.O = r12.O;
            this.f14087a0 = r12.f14087a0;
            this.f14089b0 = r12.f14089b0;
            this.P = r12.P;
            this.Q = r12.Q;
            this.R = r12.R;
            this.T = r12.T;
            this.S = r12.S;
            this.U = r12.U;
            this.V = r12.V;
            this.W = r12.W;
            this.X = r12.X;
            this.Y = r12.Y;
            this.Z = r12.Z;
            this.f14095e0 = r12.f14095e0;
            this.f14097f0 = r12.f14097f0;
            this.f14099g0 = r12.f14099g0;
            this.f14101h0 = r12.f14101h0;
            this.f14109l0 = r12.f14109l0;
            this.f14111m0 = r12.f14111m0;
            this.f14113n0 = r12.f14113n0;
            this.f14115o0 = r12.f14115o0;
            this.f14117p0 = r12.f14117p0;
            this.f14119q0 = r12.f14119q0;
            this.f14121r0 = r12.f14121r0;
            this.f14091c0 = r12.f14091c0;
            this.f14093d0 = r12.f14093d0;
            this.f14129v0 = r12.f14129v0;
            this.E = r12.E;
            this.F = r12.F;
        }

        public String a() {
            return this.f14091c0;
        }

        public ConstraintWidget b() {
            return this.f14129v0;
        }

        public void c() {
            this.f14101h0 = false;
            this.f14095e0 = true;
            this.f14097f0 = true;
            int r10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r10 == (-2)) goto L5;
        L9:
            int r11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r11 != (-2)) goto L17;
            if (this.f14089b0 == false) goto L17;
            this.f14097f0 = false;
            if (this.Q != 0) goto L17;
            this.Q = 1;
        L17:
            if (r10 == 0) goto L19;
            if (r10 == (-1)) goto L19;
        L24:
            if (r11 == 0) goto L26;
            if (r11 == (-1)) goto L26;
        L32:
            if (this.f14090c == (-1.0f)) goto L34;
        L37:
            this.f14101h0 = true;
            this.f14095e0 = true;
            this.f14097f0 = true;
            if ((this.f14129v0 instanceof f) == true) goto L40;
            this.f14129v0 = new f();
        L40:
            ((f) this.f14129v0).C1(this.Z);
            return;
        L34:
            if (this.f14086a != (-1)) goto L37;
            if (this.f14088b != (-1)) goto L37;
            return;
        L26:
            this.f14097f0 = false;
            if (r11 != 0) goto L32;
            if (this.Q != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.f14089b0 = true;
        L19:
            this.f14095e0 = false;
            if (r10 != 0) goto L24;
            if (this.P != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.f14087a0 = true;
            goto L24
        L5:
            if (this.f14087a0 == false) goto L9;
            this.f14095e0 = false;
            if (this.P != 0) goto L9;
            this.P = 1;
            goto L9
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r11) {
            int r10 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r12 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(r11);
            boolean r13 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r14 = true;
        L6:
            this.f14113n0 = -1;
            this.f14115o0 = -1;
            this.f14109l0 = -1;
            this.f14111m0 = -1;
            this.f14117p0 = this.f14130w;
            this.f14119q0 = this.f14133y;
            float r15 = this.G;
            this.f14121r0 = r15;
            int r16 = this.f14086a;
            this.f14123s0 = r16;
            int r17 = this.f14088b;
            this.f14125t0 = r17;
            float r18 = this.f14090c;
            this.f14127u0 = r18;
            if (r14 == false) goto L43;
            int r19 = this.f14122s;
            if (r19 == (-1)) goto L12;
            this.f14113n0 = r19;
        L11:
            r13 = true;
        L15:
            int r110 = this.f14126u;
            if (r110 == (-1)) goto L18;
            this.f14111m0 = r110;
            r13 = true;
        L18:
            int r111 = this.f14128v;
            if (r111 == (-1)) goto L21;
            this.f14109l0 = r111;
            r13 = true;
        L21:
            int r112 = this.A;
            if (r112 == Integer.MIN_VALUE) goto L24;
            this.f14119q0 = r112;
        L24:
            int r113 = this.B;
            if (r113 == Integer.MIN_VALUE) goto L28;
            this.f14117p0 = r113;
        L28:
            if (r13 == false) goto L31;
            this.f14121r0 = 1.0f - r15;
        L31:
            if (this.f14101h0 == false) goto L62;
            if (this.Z != 1) goto L62;
            if (this.f14092d == false) goto L62;
            if (r18 == (-1.0f)) goto L39;
            this.f14127u0 = 1.0f - r18;
            this.f14123s0 = -1;
            this.f14125t0 = -1;
            goto L62
        L39:
            if (r16 == (-1)) goto L41;
            this.f14125t0 = r16;
            this.f14123s0 = -1;
            this.f14127u0 = -1.0f;
            goto L62
        L41:
            if (r17 == (-1)) goto L62;
            this.f14123s0 = r17;
            this.f14125t0 = -1;
            this.f14127u0 = -1.0f;
        L62:
            if (this.f14126u == (-1)) goto L64;
            return;
        L64:
            if (this.f14128v == (-1)) goto L66;
            return;
        L66:
            if (this.f14124t == (-1)) goto L68;
            return;
        L68:
            if (this.f14122s != (-1)) goto L97;
            int r114 = this.f14098g;
            if (r114 == (-1)) goto L75;
            this.f14113n0 = r114;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r12 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r12;
        L81:
            int r115 = this.f14094e;
            if (r115 == (-1)) goto L87;
            this.f14109l0 = r115;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L98;
            if (r10 <= 0) goto L99;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r116 = this.f14096f;
            if (r116 == (-1)) goto L101;
            this.f14111m0 = r116;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L102;
            if (r10 <= 0) goto L103;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10;
            return;
        L103:
            return;
        L102:
            return;
        L101:
            return;
        L75:
            int r117 = this.f14100h;
            if (r117 == (-1)) goto L81;
            this.f14115o0 = r117;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r12 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r12;
            goto L81
        L97:
            return;
        L12:
            int r118 = this.f14124t;
            if (r118 == (-1)) goto L15;
            this.f14115o0 = r118;
            goto L11
        L43:
            int r119 = this.f14122s;
            if (r119 == (-1)) goto L46;
            this.f14111m0 = r119;
        L46:
            int r120 = this.f14124t;
            if (r120 == (-1)) goto L49;
            this.f14109l0 = r120;
        L49:
            int r121 = this.f14126u;
            if (r121 == (-1)) goto L52;
            this.f14113n0 = r121;
        L52:
            int r122 = this.f14128v;
            if (r122 == (-1)) goto L55;
            this.f14115o0 = r122;
        L55:
            int r123 = this.A;
            if (r123 == Integer.MIN_VALUE) goto L58;
            this.f14117p0 = r123;
        L58:
            int r124 = this.B;
            if (r124 == Integer.MIN_VALUE) goto L62;
            this.f14119q0 = r124;
            goto L62
        L5:
            r14 = false;
            goto L6
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            super(r11, r12);
            this.f14086a = -1;
            this.f14088b = -1;
            this.f14090c = -1.0f;
            this.f14092d = true;
            this.f14094e = -1;
            this.f14096f = -1;
            this.f14098g = -1;
            this.f14100h = -1;
            this.f14102i = -1;
            this.f14104j = -1;
            this.f14106k = -1;
            this.f14108l = -1;
            this.f14110m = -1;
            this.f14112n = -1;
            this.f14114o = -1;
            this.f14116p = -1;
            this.f14118q = 0;
            this.f14120r = 0.0f;
            this.f14122s = -1;
            this.f14124t = -1;
            this.f14126u = -1;
            this.f14128v = -1;
            this.f14130w = Integer.MIN_VALUE;
            this.f14132x = Integer.MIN_VALUE;
            this.f14133y = Integer.MIN_VALUE;
            this.f14134z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f14085J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f14087a0 = false;
            this.f14089b0 = false;
            this.f14091c0 = null;
            this.f14093d0 = 0;
            this.f14095e0 = true;
            this.f14097f0 = true;
            this.f14099g0 = false;
            this.f14101h0 = false;
            this.f14103i0 = false;
            this.f14105j0 = false;
            this.f14107k0 = false;
            this.f14109l0 = -1;
            this.f14111m0 = -1;
            this.f14113n0 = -1;
            this.f14115o0 = -1;
            this.f14117p0 = Integer.MIN_VALUE;
            this.f14119q0 = Integer.MIN_VALUE;
            this.f14121r0 = 0.5f;
            this.f14129v0 = new ConstraintWidget();
            this.f14131w0 = false;
            TypedArray r13 = r11.obtainStyledAttributes(r12, R$styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r10 = 0;
        L3:
            if (r10 >= r14) goto L118;
            int r15 = r13.getIndex(r10);
            int r16 = a.f14135a.get(r15);
            switch(r16) {
                case 1: goto L116;
                case 2: goto L113;
                case 3: goto L112;
                case 4: goto L109;
                case 5: goto L108;
                case 6: goto L107;
                case 7: goto L106;
                case 8: goto L103;
                case 9: goto L100;
                case 10: goto L97;
                case 11: goto L94;
                case 12: goto L91;
                case 13: goto L88;
                case 14: goto L85;
                case 15: goto L82;
                case 16: goto L79;
                case 17: goto L76;
                case 18: goto L73;
                case 19: goto L70;
                case 20: goto L67;
                case 21: goto L66;
                case 22: goto L65;
                case 23: goto L64;
                case 24: goto L63;
                case 25: goto L62;
                case 26: goto L61;
                case 27: goto L60;
                case 28: goto L59;
                case 29: goto L58;
                case 30: goto L57;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L122;
                case 34: goto L126;
                case 35: goto L40;
                case 36: goto L120;
                case 37: goto L124;
                case 38: goto L29;
                default: goto L6;
            };
        L6:
            switch(r16) {
                case 44: goto L28;
                case 45: goto L27;
                case 46: goto L26;
                case 47: goto L25;
                case 48: goto L24;
                case 49: goto L23;
                case 50: goto L22;
                case 51: goto L21;
                case 52: goto L18;
                case 53: goto L15;
                case 54: goto L14;
                case 55: goto L13;
                default: goto L7;
            };
        L7:
            switch(r16) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L117;
            };
        L9:
            this.f14092d = r13.getBoolean(r15, this.f14092d);
            goto L117
        L10:
            this.f14093d0 = r13.getInt(r15, this.f14093d0);
            goto L117
        L11:
            com.obric.oui.constraintlayout.widget.a.E(this, r13, r15, 1);
            this.F = true;
            goto L117
        L12:
            com.obric.oui.constraintlayout.widget.a.E(this, r13, r15, 0);
            this.E = true;
        L117:
            r10 = r10 + 1;
            goto L3
        L13:
            this.C = r13.getDimensionPixelSize(r15, this.C);
            goto L117
        L14:
            this.D = r13.getDimensionPixelSize(r15, this.D);
            goto L117
        L15:
            int r17 = r13.getResourceId(r15, this.f14114o);
            this.f14114o = r17;
            if (r17 != (-1)) goto L117;
            this.f14114o = r13.getInt(r15, -1);
            goto L117
        L18:
            int r18 = r13.getResourceId(r15, this.f14112n);
            this.f14112n = r18;
            if (r18 != (-1)) goto L117;
            this.f14112n = r13.getInt(r15, -1);
            goto L117
        L21:
            this.f14091c0 = r13.getString(r15);
            goto L117
        L22:
            this.Y = r13.getDimensionPixelOffset(r15, this.Y);
            goto L117
        L23:
            this.X = r13.getDimensionPixelOffset(r15, this.X);
            goto L117
        L24:
            this.O = r13.getInt(r15, 0);
            goto L117
        L25:
            this.N = r13.getInt(r15, 0);
            goto L117
        L26:
            this.M = r13.getFloat(r15, this.M);
            goto L117
        L27:
            this.L = r13.getFloat(r15, this.L);
            goto L117
        L28:
            com.obric.oui.constraintlayout.widget.a.G(this, r13.getString(r15));
            goto L117
        L29:
            this.W = Math.max(0.0f, r13.getFloat(r15, this.W));
            this.Q = 2;
            goto L117
        L40:
            this.V = Math.max(0.0f, r13.getFloat(r15, this.V));
            this.P = 2;
            goto L117
        L51:
            int r19 = r13.getInt(r15, 0);
            this.Q = r19;
            if (r19 != 1) goto L117;
            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r20 = r13.getInt(r15, 0);
            this.P = r20;
            if (r20 != 1) goto L117;
            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L117
        L57:
            this.H = r13.getFloat(r15, this.H);
            goto L117
        L58:
            this.G = r13.getFloat(r15, this.G);
            goto L117
        L59:
            this.f14089b0 = r13.getBoolean(r15, this.f14089b0);
            goto L117
        L60:
            this.f14087a0 = r13.getBoolean(r15, this.f14087a0);
            goto L117
        L61:
            this.B = r13.getDimensionPixelSize(r15, this.B);
            goto L117
        L62:
            this.A = r13.getDimensionPixelSize(r15, this.A);
            goto L117
        L63:
            this.f14134z = r13.getDimensionPixelSize(r15, this.f14134z);
            goto L117
        L64:
            this.f14133y = r13.getDimensionPixelSize(r15, this.f14133y);
            goto L117
        L65:
            this.f14132x = r13.getDimensionPixelSize(r15, this.f14132x);
            goto L117
        L66:
            this.f14130w = r13.getDimensionPixelSize(r15, this.f14130w);
            goto L117
        L67:
            int r21 = r13.getResourceId(r15, this.f14128v);
            this.f14128v = r21;
            if (r21 != (-1)) goto L117;
            this.f14128v = r13.getInt(r15, -1);
            goto L117
        L70:
            int r22 = r13.getResourceId(r15, this.f14126u);
            this.f14126u = r22;
            if (r22 != (-1)) goto L117;
            this.f14126u = r13.getInt(r15, -1);
            goto L117
        L73:
            int r23 = r13.getResourceId(r15, this.f14124t);
            this.f14124t = r23;
            if (r23 != (-1)) goto L117;
            this.f14124t = r13.getInt(r15, -1);
            goto L117
        L76:
            int r24 = r13.getResourceId(r15, this.f14122s);
            this.f14122s = r24;
            if (r24 != (-1)) goto L117;
            this.f14122s = r13.getInt(r15, -1);
            goto L117
        L79:
            int r25 = r13.getResourceId(r15, this.f14110m);
            this.f14110m = r25;
            if (r25 != (-1)) goto L117;
            this.f14110m = r13.getInt(r15, -1);
            goto L117
        L82:
            int r26 = r13.getResourceId(r15, this.f14108l);
            this.f14108l = r26;
            if (r26 != (-1)) goto L117;
            this.f14108l = r13.getInt(r15, -1);
            goto L117
        L85:
            int r27 = r13.getResourceId(r15, this.f14106k);
            this.f14106k = r27;
            if (r27 != (-1)) goto L117;
            this.f14106k = r13.getInt(r15, -1);
            goto L117
        L88:
            int r28 = r13.getResourceId(r15, this.f14104j);
            this.f14104j = r28;
            if (r28 != (-1)) goto L117;
            this.f14104j = r13.getInt(r15, -1);
            goto L117
        L91:
            int r29 = r13.getResourceId(r15, this.f14102i);
            this.f14102i = r29;
            if (r29 != (-1)) goto L117;
            this.f14102i = r13.getInt(r15, -1);
            goto L117
        L94:
            int r30 = r13.getResourceId(r15, this.f14100h);
            this.f14100h = r30;
            if (r30 != (-1)) goto L117;
            this.f14100h = r13.getInt(r15, -1);
            goto L117
        L97:
            int r31 = r13.getResourceId(r15, this.f14098g);
            this.f14098g = r31;
            if (r31 != (-1)) goto L117;
            this.f14098g = r13.getInt(r15, -1);
            goto L117
        L100:
            int r32 = r13.getResourceId(r15, this.f14096f);
            this.f14096f = r32;
            if (r32 != (-1)) goto L117;
            this.f14096f = r13.getInt(r15, -1);
            goto L117
        L103:
            int r33 = r13.getResourceId(r15, this.f14094e);
            this.f14094e = r33;
            if (r33 != (-1)) goto L117;
            this.f14094e = r13.getInt(r15, -1);
            goto L117
        L106:
            this.f14090c = r13.getFloat(r15, this.f14090c);
            goto L117
        L107:
            this.f14088b = r13.getDimensionPixelOffset(r15, this.f14088b);
            goto L117
        L108:
            this.f14086a = r13.getDimensionPixelOffset(r15, this.f14086a);
            goto L117
        L109:
            float r34 = r13.getFloat(r15, this.f14120r) % 360.0f;
            this.f14120r = r34;
            if (r34 >= 0.0f) goto L117;
            this.f14120r = (360.0f - r34) % 360.0f;
            goto L117
        L112:
            this.f14118q = r13.getDimensionPixelSize(r15, this.f14118q);
            goto L117
        L113:
            int r35 = r13.getResourceId(r15, this.f14116p);
            this.f14116p = r35;
            if (r35 != (-1)) goto L117;
            this.f14116p = r13.getInt(r15, -1);
            goto L117
        L116:
            this.Z = r13.getInt(r15, this.Z);
            goto L117
        L120:
            this.S = r13.getDimensionPixelSize(r15, this.S);     // Catch: Exception -> L37
        L38:
            if (r13.getInt(r15, this.S) != (-2)) goto L117;
            this.S = -2;
            goto L117
        L122:
            this.R = r13.getDimensionPixelSize(r15, this.R);     // Catch: Exception -> L48
        L49:
            if (r13.getInt(r15, this.R) != (-2)) goto L117;
            this.R = -2;
            goto L117
        L124:
            this.U = r13.getDimensionPixelSize(r15, this.U);     // Catch: Exception -> L32
        L33:
            if (r13.getInt(r15, this.U) != (-2)) goto L117;
            this.U = -2;
            goto L117
        L126:
            this.T = r13.getDimensionPixelSize(r15, this.T);     // Catch: Exception -> L43
        L44:
            if (r13.getInt(r15, this.T) != (-2)) goto L117;
            this.T = -2;
            goto L117
        L118:
            r13.recycle();
            c();
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f14086a = -1;
            this.f14088b = -1;
            this.f14090c = -1.0f;
            this.f14092d = true;
            this.f14094e = -1;
            this.f14096f = -1;
            this.f14098g = -1;
            this.f14100h = -1;
            this.f14102i = -1;
            this.f14104j = -1;
            this.f14106k = -1;
            this.f14108l = -1;
            this.f14110m = -1;
            this.f14112n = -1;
            this.f14114o = -1;
            this.f14116p = -1;
            this.f14118q = 0;
            this.f14120r = 0.0f;
            this.f14122s = -1;
            this.f14124t = -1;
            this.f14126u = -1;
            this.f14128v = -1;
            this.f14130w = Integer.MIN_VALUE;
            this.f14132x = Integer.MIN_VALUE;
            this.f14133y = Integer.MIN_VALUE;
            this.f14134z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f14085J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f14087a0 = false;
            this.f14089b0 = false;
            this.f14091c0 = null;
            this.f14093d0 = 0;
            this.f14095e0 = true;
            this.f14097f0 = true;
            this.f14099g0 = false;
            this.f14101h0 = false;
            this.f14103i0 = false;
            this.f14105j0 = false;
            this.f14107k0 = false;
            this.f14109l0 = -1;
            this.f14111m0 = -1;
            this.f14113n0 = -1;
            this.f14115o0 = -1;
            this.f14117p0 = Integer.MIN_VALUE;
            this.f14119q0 = Integer.MIN_VALUE;
            this.f14121r0 = 0.5f;
            this.f14129v0 = new ConstraintWidget();
            this.f14131w0 = false;
        }
    }

    public interface ValueModifier {
        boolean update(int r10, int r11, int r12, View r13, LayoutParams r14);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14136a = null;

        static {
            int[] r10 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f14136a = r10;
            r10[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f14136a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f14136a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f14136a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b implements BasicMeasure.Measurer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f14137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14140d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14141e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14142f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14143g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f14144h;

        public b(ConstraintLayout r10, ConstraintLayout r11) {
            this.f14144h = r10;
            this.f14137a = r11;
        }

        public void a(int r10, int r11, int r12, int r13, int r14, int r15) {
            this.f14138b = r12;
            this.f14139c = r13;
            this.f14140d = r14;
            this.f14141e = r15;
            this.f14142f = r10;
            this.f14143g = r11;
        }

        public final boolean b(int r10, int r11, int r12) {
            if (r10 != r11) goto L5;
            return true;
        L5:
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = View.MeasureSpec.getMode(r11);
            int r15 = View.MeasureSpec.getSize(r11);
            if (r14 == 1073741824) goto L8;
        L12:
            return false;
        L8:
            if (r13 == Integer.MIN_VALUE) goto L10;
            if (r13 != 0) goto L12;
        L10:
            if (r12 != r15) goto L12;
            return true;
        }

        @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r10 = this.f14137a.getChildCount();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L8;
            View r13 = this.f14137a.getChildAt(r12);
            if ((r13 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r13).b(this.f14137a);
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            int r14 = ConstraintLayout.c(this.f14137a).size();
            if (r14 <= 0) goto L12;
        L10:
            if (r11 >= r14) goto L17;
            ((ConstraintHelper) ConstraintLayout.c(this.f14137a).get(r11)).o(this.f14137a);
            r11 = r11 + 1;
            goto L10
        L17:
            return;
        }

        @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void measure(ConstraintWidget r19, BasicMeasure.a r20) {
            if (r19 != null) goto L6;
            return;
        L6:
            if (r19.U() != 8) goto L12;
            if (r19.i0() == true) goto L12;
            r20.f13316e = 0;
            r20.f13317f = 0;
            r20.f13318g = 0;
            return;
        L12:
            if (r19.J() != null) goto L14;
            return;
        L14:
            ConstraintLayout.a(this.f14144h);
            ConstraintWidget.DimensionBehaviour r10 = r20.f13312a;
            ConstraintWidget.DimensionBehaviour r11 = r20.f13313b;
            int r12 = r20.f13314c;
            int r13 = r20.f13315d;
            int r14 = this.f14138b + this.f14139c;
            int r15 = this.f14140d;
            View r16 = (View) r19.r();
            int[] r17 = a.f14136a;
            int r18 = r17[r10.ordinal()];
            if (r18 == 1) goto L44;
            if (r18 == 2) goto L43;
            if (r18 == 3) goto L42;
            if (r18 == 4) goto L20;
            int r21 = 0;
        L45:
            int r22 = r17[r11.ordinal()];
            if (r22 == 1) goto L77;
            if (r22 != 2) goto L49;
            int r23 = ViewGroup.getChildMeasureSpec(this.f14143g, r14, -2);
        L78:
            d r24 = (d) r19.J();
            if (r24 != null) goto L81;
        L100:
            ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r10 != r25) goto L103;
            boolean r26 = true;
        L104:
            if (r11 != r25) goto L106;
            boolean r27 = true;
        L107:
            ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r11 != r110) goto L110;
        L113:
            boolean r28 = true;
        L114:
            if (r10 != r110) goto L116;
        L119:
            boolean r29 = true;
        L121:
            if (r26 == true) goto L123;
        L125:
            boolean r111 = false;
        L126:
            if (r27 == true) goto L128;
        L130:
            boolean r112 = false;
        L131:
            if (r16 != null) goto L133;
            return;
        L133:
            LayoutParams r113 = (LayoutParams) r16.getLayoutParams();
            int r114 = r20.f13321j;
            if (r114 == BasicMeasure.a.f13310l) goto L146;
            if (r114 == BasicMeasure.a.f13311m) goto L146;
            if (r26 == false) goto L146;
            if (r19.f13295w != 0) goto L146;
            if (r27 == false) goto L146;
            if (r19.f13297x != 0) goto L146;
            int r30 = -1;
            int r31 = 0;
            int r115 = 0;
            int r116 = 0;
        L186:
            if (r115 == r30) goto L188;
            boolean r32 = true;
        L190:
            if (r116 == r20.f13314c) goto L192;
        L195:
            boolean r33 = true;
        L196:
            r20.f13320i = r33;
            if (r113.f14099g0 == false) goto L199;
            r32 = true;
        L199:
            if (r32 == true) goto L201;
        L205:
            r20.f13316e = r116;
            r20.f13317f = r31;
            r20.f13319h = r32;
            r20.f13318g = r115;
            ConstraintLayout.a(this.f14144h);
            return;
        L201:
            if (r115 == (-1)) goto L205;
            if (r19.o() == r115) goto L205;
            r20.f13320i = true;
            goto L205
        L192:
            if (r31 != r20.f13315d) goto L195;
            r33 = false;
            goto L196
        L188:
            r32 = false;
        L146:
            if ((r16 instanceof VirtualLayout) == true) goto L148;
        L150:
            r16.measure(r21, r23);
        L151:
            r19.X0(r21, r23);
            int r34 = r16.getMeasuredWidth();
            int r35 = r16.getMeasuredHeight();
            r115 = r16.getBaseline();
            int r117 = r19.f13301z;
            if (r117 <= 0) goto L154;
            r116 = Math.max(r117, r34);
        L155:
            int r36 = r19.A;
            if (r36 <= 0) goto L158;
            r116 = Math.min(r36, r116);
        L158:
            int r37 = r19.C;
            if (r37 <= 0) goto L161;
            r31 = Math.max(r37, r35);
        L162:
            int r38 = r19.D;
            if (r38 <= 0) goto L165;
            r31 = Math.min(r38, r31);
        L165:
            int r118 = r23;
            if (g.b(ConstraintLayout.b(this.f14144h), 1) == false) goto L168;
        L174:
            if (r34 != r116) goto L179;
            if (r35 != r31) goto L179;
        L177:
            r30 = -1;
        L179:
            if (r34 == r116) goto L181;
            int r39 = View.MeasureSpec.makeMeasureSpec(r116, Ints.MAX_POWER_OF_TWO);
        L182:
            if (r35 == r31) goto L184;
            int r40 = View.MeasureSpec.makeMeasureSpec(r31, Ints.MAX_POWER_OF_TWO);
        L185:
            r16.measure(r39, r40);
            r19.X0(r39, r40);
            r116 = r16.getMeasuredWidth();
            r31 = r16.getMeasuredHeight();
            r115 = r16.getBaseline();
            goto L177
        L184:
            r40 = r118;
            goto L185
        L181:
            r39 = r21;
            goto L182
        L168:
            if (r111 == false) goto L171;
            if (r28 == false) goto L171;
            r116 = (int) ((r31 * r19.f13262f0) + 0.5f);
        L171:
            if (r112 == false) goto L174;
            if (r29 == false) goto L174;
            r31 = (int) ((r116 / r19.f13262f0) + 0.5f);
            goto L174
        L161:
            r31 = r35;
            goto L162
        L154:
            r116 = r34;
            goto L155
        L148:
            if ((r19 instanceof i) == false) goto L150;
            ((VirtualLayout) r16).t((i) r19, r21, r23);
            goto L151
        L128:
            if (r19.f13262f0 <= 0.0f) goto L130;
            r112 = true;
            goto L131
        L123:
            if (r19.f13262f0 <= 0.0f) goto L125;
            r111 = true;
            goto L126
        L116:
            if (r10 == ConstraintWidget.DimensionBehaviour.FIXED) goto L119;
            r29 = false;
            goto L121
        L110:
            if (r11 == ConstraintWidget.DimensionBehaviour.FIXED) goto L113;
            r28 = false;
            goto L114
        L106:
            r27 = false;
            goto L107
        L103:
            r26 = false;
            goto L104
        L81:
            if (g.b(ConstraintLayout.b(this.f14144h), 256) == false) goto L100;
            if (r16.getMeasuredWidth() != r19.V()) goto L100;
            if (r16.getMeasuredWidth() >= r24.V()) goto L100;
            if (r16.getMeasuredHeight() != r19.w()) goto L100;
            if (r16.getMeasuredHeight() >= r24.w()) goto L100;
            if (r16.getBaseline() != r19.o()) goto L100;
            if (r19.l0() == true) goto L100;
            if (b(r19.B(), r21, r19.V()) == false) goto L100;
            if (b(r19.C(), r23, r19.w()) == false) goto L100;
            r20.f13316e = r19.V();
            r20.f13317f = r19.w();
            r20.f13318g = r19.o();
            return;
        L49:
            if (r22 != 3) goto L51;
            r23 = ViewGroup.getChildMeasureSpec(this.f14143g, r14 + r19.T(), -1);
            goto L78
        L51:
            if (r22 == 4) goto L53;
            r23 = 0;
            goto L78
        L53:
            r23 = ViewGroup.getChildMeasureSpec(this.f14143g, r14, -2);
            if (r19.f13297x != 1) goto L56;
            boolean r41 = true;
        L57:
            int r42 = r20.f13321j;
            if (r42 == BasicMeasure.a.f13310l) goto L62;
            if (r42 != BasicMeasure.a.f13311m) goto L78;
        L62:
            if (r16.getMeasuredWidth() != r19.V()) goto L64;
            boolean r43 = true;
        L66:
            if (r20.f13321j == BasicMeasure.a.f13311m) goto L74;
            if (r41 == false) goto L74;
            if (r41 == false) goto L71;
            if (r43 == true) goto L74;
        L71:
            if ((r16 instanceof Placeholder) == true) goto L74;
            if (r19.n0() == false) goto L78;
        L74:
            r23 = View.MeasureSpec.makeMeasureSpec(r19.w(), Ints.MAX_POWER_OF_TWO);
            goto L78
        L64:
            r43 = false;
            goto L66
        L56:
            r41 = false;
            goto L57
        L77:
            r23 = View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO);
            goto L78
        L20:
            r21 = ViewGroup.getChildMeasureSpec(this.f14142f, r15, -2);
            if (r19.f13295w != 1) goto L23;
            boolean r44 = true;
        L24:
            int r119 = r20.f13321j;
            if (r119 == BasicMeasure.a.f13310l) goto L29;
            if (r119 != BasicMeasure.a.f13311m) goto L45;
        L29:
            if (r16.getMeasuredHeight() != r19.w()) goto L31;
            boolean r120 = true;
        L33:
            if (r20.f13321j == BasicMeasure.a.f13311m) goto L41;
            if (r44 == false) goto L41;
            if (r44 == false) goto L38;
            if (r120 == true) goto L41;
        L38:
            if ((r16 instanceof Placeholder) == true) goto L41;
            if (r19.m0() == false) goto L45;
        L41:
            r21 = View.MeasureSpec.makeMeasureSpec(r19.V(), Ints.MAX_POWER_OF_TWO);
            goto L45
        L31:
            r120 = false;
            goto L33
        L23:
            r44 = false;
            goto L24
        L42:
            r21 = ViewGroup.getChildMeasureSpec(this.f14142f, r15 + r19.A(), -1);
            goto L45
        L43:
            r21 = ViewGroup.getChildMeasureSpec(this.f14142f, r15, -2);
            goto L45
        L44:
            r21 = View.MeasureSpec.makeMeasureSpec(r12, Ints.MAX_POWER_OF_TWO);
            goto L45
        }
    }

    static {
    }

    public ConstraintLayout(Context r10) {
        super(r10);
        this.f14061a = new SparseArray();
        this.f14062b = new ArrayList(4);
        this.f14063c = new d();
        this.f14064d = 0;
        this.f14065e = 0;
        this.f14066f = Channel.UNLIMITED;
        this.f14067g = Channel.UNLIMITED;
        this.f14068h = true;
        this.f14069i = 257;
        this.f14070j = null;
        this.f14071k = null;
        this.f14072l = -1;
        this.f14073m = new HashMap();
        this.f14074n = -1;
        this.f14075o = -1;
        this.f14076p = -1;
        this.f14077q = -1;
        this.f14078r = 0;
        this.f14079s = 0;
        this.f14080t = new SparseArray();
        this.f14081u = new b(this, this);
        this.f14082v = 0;
        this.f14083w = 0;
        l(null, 0, 0);
    }

    public static /* synthetic */ c a(ConstraintLayout r10) {
        r10.getClass();
        return null;
    }

    public static /* synthetic */ int b(ConstraintLayout r10) {
        return r10.f14069i;
    }

    public static /* synthetic */ ArrayList c(ConstraintLayout r10) {
        return r10.f14062b;
    }

    private int getPaddingWidth() {
        int r10 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int r11 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (r11 > 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static SharedValues getSharedValues() {
        if (f14060y != null) goto L6;
        f14060y = new SharedValues();
    L6:
        return f14060y;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    public void d(boolean r17, View r18, ConstraintWidget r19, LayoutParams r20, SparseArray r21) {
        r20.c();
        r20.f14131w0 = false;
        r19.l1(r18.getVisibility());
        if (r20.f14105j0 == false) goto L5;
        r19.V0(true);
        r19.l1(8);
    L5:
        r19.D0(r18);
        if ((r18 instanceof ConstraintHelper) == false) goto L10;
        ((ConstraintHelper) r18).m(r19, this.f14063c.S1());
    L10:
        if (r20.f14101h0 == false) goto L18;
        f r10 = (f) r19;
        int r11 = r20.f14123s0;
        int r12 = r20.f14125t0;
        float r13 = r20.f14127u0;
        if (r13 == (-1.0f)) goto L14;
        r10.B1(r13);
        return;
    L14:
        if (r11 == (-1)) goto L16;
        r10.z1(r11);
        return;
    L16:
        if (r12 == (-1)) goto L110;
        r10.A1(r12);
        return;
    L110:
        return;
    L18:
        int r14 = r20.f14109l0;
        int r15 = r20.f14111m0;
        int r16 = r20.f14113n0;
        int r110 = r20.f14115o0;
        int r22 = r20.f14117p0;
        int r111 = r20.f14119q0;
        float r112 = r20.f14121r0;
        int r23 = r20.f14116p;
        if (r23 == (-1)) goto L23;
        ConstraintWidget r24 = (ConstraintWidget) r21.get(r23);
        if (r24 == null) goto L74;
        r19.j(r24, r20.f14120r, r20.f14118q);
    L74:
        if (r17 == false) goto L81;
        int r25 = r20.X;
        if (r25 == (-1)) goto L78;
    L79:
        r19.d1(r25, r20.Y);
        goto L81
    L78:
        if (r20.Y != (-1)) goto L79;
    L81:
        if (r20.f14095e0 == false) goto L83;
        r19.R0(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.m1(((ViewGroup.MarginLayoutParams) r20).width);
        if (((ViewGroup.MarginLayoutParams) r20).width != (-2)) goto L94;
        r19.R0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L94:
        if (r20.f14097f0 == false) goto L96;
        r19.i1(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.N0(((ViewGroup.MarginLayoutParams) r20).height);
        if (((ViewGroup.MarginLayoutParams) r20).height != (-2)) goto L106;
        r19.i1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L106:
        r19.F0(r20.I);
        r19.T0(r20.L);
        r19.k1(r20.M);
        r19.P0(r20.N);
        r19.g1(r20.O);
        r19.n1(r20.f14093d0);
        r19.S0(r20.P, r20.R, r20.T, r20.V);
        r19.j1(r20.Q, r20.S, r20.U, r20.W);
        return;
    L96:
        if (((ViewGroup.MarginLayoutParams) r20).height == (-1)) goto L98;
        r19.i1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.N0(0);
        goto L106
    L98:
        if (r20.f14089b0 == false) goto L100;
        r19.i1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L101:
        ConstraintAnchor r26 = r19.n(ConstraintAnchor.Type.TOP);
        r26.f13246g = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        ConstraintAnchor r27 = r19.n(ConstraintAnchor.Type.BOTTOM);
        r27.f13246g = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        goto L106
    L100:
        r19.i1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L101
    L83:
        if (((ViewGroup.MarginLayoutParams) r20).width == (-1)) goto L85;
        r19.R0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.m1(0);
        goto L94
    L85:
        if (r20.f14087a0 == false) goto L87;
        r19.R0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L88:
        ConstraintAnchor r28 = r19.n(ConstraintAnchor.Type.LEFT);
        r28.f13246g = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
        ConstraintAnchor r29 = r19.n(ConstraintAnchor.Type.RIGHT);
        r29.f13246g = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
        goto L94
    L87:
        r19.R0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L88
    L23:
        if (r14 == (-1)) goto L27;
        ConstraintWidget r30 = (ConstraintWidget) r21.get(r14);
        if (r30 == null) goto L31;
        ConstraintAnchor.Type r31 = ConstraintAnchor.Type.LEFT;
        r19.d0(r31, r30, r31, ((ViewGroup.MarginLayoutParams) r20).leftMargin, r22);
    L31:
        if (r16 == (-1)) goto L35;
        ConstraintWidget r32 = (ConstraintWidget) r21.get(r16);
        if (r32 == null) goto L39;
        r19.d0(ConstraintAnchor.Type.RIGHT, r32, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) r20).rightMargin, r111);
    L39:
        int r33 = r20.f14102i;
        if (r33 == (-1)) goto L44;
        ConstraintWidget r34 = (ConstraintWidget) r21.get(r33);
        if (r34 == null) goto L49;
        ConstraintAnchor.Type r35 = ConstraintAnchor.Type.TOP;
        r19.d0(r35, r34, r35, ((ViewGroup.MarginLayoutParams) r20).topMargin, r20.f14132x);
    L49:
        int r36 = r20.f14106k;
        if (r36 == (-1)) goto L54;
        ConstraintWidget r37 = (ConstraintWidget) r21.get(r36);
        if (r37 == null) goto L59;
        r19.d0(ConstraintAnchor.Type.BOTTOM, r37, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) r20).bottomMargin, r20.f14134z);
    L59:
        int r38 = r20.f14110m;
        if (r38 == (-1)) goto L62;
        u(r19, r20, r21, r38, ConstraintAnchor.Type.BASELINE);
    L69:
        if (r112 < 0.0f) goto L71;
        r19.O0(r112);
    L71:
        float r39 = r20.H;
        if (r39 < 0.0f) goto L74;
        r19.f1(r39);
        goto L74
    L62:
        int r40 = r20.f14112n;
        if (r40 == (-1)) goto L65;
        u(r19, r20, r21, r40, ConstraintAnchor.Type.TOP);
        goto L69
    L65:
        int r41 = r20.f14114o;
        if (r41 == (-1)) goto L69;
        u(r19, r20, r21, r41, ConstraintAnchor.Type.BOTTOM);
        goto L69
    L54:
        int r42 = r20.f14108l;
        if (r42 == (-1)) goto L59;
        ConstraintWidget r43 = (ConstraintWidget) r21.get(r42);
        if (r43 == null) goto L59;
        ConstraintAnchor.Type r44 = ConstraintAnchor.Type.BOTTOM;
        r19.d0(r44, r43, r44, ((ViewGroup.MarginLayoutParams) r20).bottomMargin, r20.f14134z);
        goto L59
    L44:
        int r45 = r20.f14104j;
        if (r45 == (-1)) goto L49;
        ConstraintWidget r46 = (ConstraintWidget) r21.get(r45);
        if (r46 == null) goto L49;
        r19.d0(ConstraintAnchor.Type.TOP, r46, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) r20).topMargin, r20.f14132x);
        goto L49
    L35:
        if (r110 == (-1)) goto L39;
        ConstraintWidget r47 = (ConstraintWidget) r21.get(r110);
        if (r47 == null) goto L39;
        ConstraintAnchor.Type r48 = ConstraintAnchor.Type.RIGHT;
        r19.d0(r48, r47, r48, ((ViewGroup.MarginLayoutParams) r20).rightMargin, r111);
        goto L39
    L27:
        if (r15 == (-1)) goto L31;
        ConstraintWidget r49 = (ConstraintWidget) r21.get(r15);
        if (r49 == null) goto L31;
        r19.d0(ConstraintAnchor.Type.LEFT, r49, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) r20).leftMargin, r22);
        goto L31
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r19) {
        ArrayList r10 = this.f14062b;
        if (r10 == null) goto L9;
        int r11 = r10.size();
        if (r11 <= 0) goto L9;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        ((ConstraintHelper) this.f14062b.get(r12)).p(this);
        r12 = r12 + 1;
    L9:
        super.dispatchDraw(r19);
        if (isInEditMode() == false) goto L24;
        float r13 = getWidth();
        float r14 = getHeight();
        int r15 = getChildCount();
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L32;
        View r17 = getChildAt(r16);
        if (r17.getVisibility() == 8) goto L23;
        Object r18 = r17.getTag();
        if (r18 == null) goto L23;
        if ((r18 instanceof String) == false) goto L23;
        String[] r20 = ((String) r18).split(",");
        if (r20.length != 4) goto L23;
        int r21 = Integer.parseInt(r20[0]);
        int r22 = Integer.parseInt(r20[1]);
        int r23 = Integer.parseInt(r20[2]);
        int r24 = (int) ((r21 / 1080.0f) * r13);
        int r25 = (int) ((r22 / 1920.0f) * r14);
        int r26 = (int) ((Integer.parseInt(r20[3]) / 1920.0f) * r14);
        Paint r110 = new Paint();
        r110.setColor(-65536);
        float r111 = r24;
        float r112 = r25;
        float r27 = r24 + ((int) ((r23 / 1080.0f) * r13));
        r19.drawLine(r111, r112, r27, r112, r110);
        float r28 = r25 + r26;
        r19.drawLine(r27, r112, r27, r28, r110);
        r19.drawLine(r27, r28, r111, r28, r110);
        r19.drawLine(r111, r28, r111, r112, r110);
        r110.setColor(-16711936);
        r19.drawLine(r111, r112, r27, r28, r110);
        r19.drawLine(r111, r28, r27, r112, r110);
    L23:
        r16 = r16 + 1;
        goto L12
    L32:
        return;
    }

    public boolean e(int r11, int r12) {
        boolean r10 = false;
        if (this.f14084x != null) goto L5;
        return false;
    L5:
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = View.MeasureSpec.getSize(r12);
        Iterator r15 = this.f14084x.iterator();
    L7:
        if (r15.hasNext() == false) goto L12;
        ValueModifier r16 = (ValueModifier) r15.next();
        Iterator r17 = this.f14063c.t1().iterator();
    L10:
        if (r17.hasNext() == false) goto L7;
        View r18 = (View) ((ConstraintWidget) r17.next()).r();
        r10 = r10 | r16.update(r13, r14, r18.getId(), r18, (LayoutParams) r18.getLayoutParams());
        goto L10
    L12:
        return r10;
    }

    public LayoutParams f() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.View
    public void forceLayout() {
        n();
        super.forceLayout();
    }

    public LayoutParams g(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return f();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return g(r10);
    }

    public int getMaxHeight() {
        return this.f14067g;
    }

    public int getMaxWidth() {
        return this.f14066f;
    }

    public int getMinHeight() {
        return this.f14065e;
    }

    public int getMinWidth() {
        return this.f14064d;
    }

    public int getOptimizationLevel() {
        return this.f14063c.M1();
    }

    public String getSceneString() {
        StringBuilder r10 = new StringBuilder();
        if (this.f14063c.f13279o != null) goto L9;
        int r11 = getId();
        if (r11 == (-1)) goto L7;
        this.f14063c.f13279o = getContext().getResources().getResourceEntryName(r11);
        goto L9
    L7:
        this.f14063c.f13279o = "parent";
    L9:
        if (this.f14063c.s() != null) goto L11;
        d r12 = this.f14063c;
        r12.E0(r12.f13279o);
        Log.v("ConstraintLayout", " setDebugName " + this.f14063c.s());
    L11:
        Iterator r13 = this.f14063c.t1().iterator();
    L13:
        if (r13.hasNext() == false) goto L24;
        ConstraintWidget r14 = (ConstraintWidget) r13.next();
        View r15 = (View) r14.r();
        if (r15 == null) goto L13;
        if (r14.f13279o != null) goto L22;
        int r16 = r15.getId();
        if (r16 == (-1)) goto L22;
        r14.f13279o = getContext().getResources().getResourceEntryName(r16);
    L22:
        if (r14.s() != null) goto L13;
        r14.E0(r14.f13279o);
        Log.v("ConstraintLayout", " setDebugName " + r14.s());
        goto L13
    L24:
        this.f14063c.N(r10);
        return r10.toString();
    }

    public Object h(int r10, Object r11) {
        if (r10 == 0) goto L4;
        return null;
    L4:
        if ((r11 instanceof String) == false) goto L13;
        String r12 = (String) r11;
        HashMap r13 = this.f14073m;
        if (r13 != null) goto L8;
        return null;
    L8:
        if (r13.containsKey(r12) == true) goto L10;
        return null;
    L10:
        return this.f14073m.get(r12);
    L13:
        return null;
    }

    public final ConstraintWidget i(int r10) {
        if (r10 == 0) goto L4;
        View r11 = (View) this.f14061a.get(r10);
        if (r11 != null) goto L13;
        r11 = findViewById(r10);
        if (r11 == null) goto L13;
        if (r11 == this) goto L13;
        if (r11.getParent() != this) goto L13;
        onViewAdded(r11);
    L13:
        if (r11 == this) goto L15;
        if (r11 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) r11.getLayoutParams()).f14129v0;
    L15:
        return this.f14063c;
    L4:
        return this.f14063c;
    }

    public View j(int r10) {
        return (View) this.f14061a.get(r10);
    }

    public final ConstraintWidget k(View r10) {
        if (r10 == this) goto L4;
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r10.setLayoutParams(generateLayoutParams(r10.getLayoutParams()));
        if ((r10.getLayoutParams() instanceof LayoutParams) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) r10.getLayoutParams()).f14129v0;
    L9:
        return ((LayoutParams) r10.getLayoutParams()).f14129v0;
    L4:
        return this.f14063c;
    }

    public final void l(AttributeSet r10, int r11, int r12) {
        this.f14063c.D0(this);
        this.f14063c.Y1(this.f14081u);
        this.f14061a.put(getId(), this);
        this.f14070j = null;
        if (r10 == null) goto L37;
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout, r11, r12);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L36;
        int r16 = r13.getIndex(r15);
        if (r16 != R$styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.f14064d = r13.getDimensionPixelOffset(r16, this.f14064d);
    L35:
        r15 = r15 + 1;
        goto L5
    L10:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.f14065e = r13.getDimensionPixelOffset(r16, this.f14065e);
        goto L35
    L13:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.f14066f = r13.getDimensionPixelOffset(r16, this.f14066f);
        goto L35
    L16:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.f14067g = r13.getDimensionPixelOffset(r16, this.f14067g);
        goto L35
    L19:
        if (r16 != R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.f14069i = r13.getInt(r16, this.f14069i);
        goto L35
    L22:
        if (r16 != R$styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r17 = r13.getResourceId(r16, 0);
        if (r17 == 0) goto L35;
        o(r17);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.f14071k = null;
        goto L35
    L29:
        if (r16 != R$styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r18 = r13.getResourceId(r16, 0);
        com.obric.oui.constraintlayout.widget.a r19 = new com.obric.oui.constraintlayout.widget.a();     // Catch: Resources.NotFoundException -> L33
        this.f14070j = r19;     // Catch: Resources.NotFoundException -> L33
        r19.B(getContext(), r18);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.f14072l = r18;
    L33:
        this.f14070j = null;
        goto L34
    L36:
        r13.recycle();
    L37:
        this.f14063c.Z1(this.f14069i);
    }

    public boolean m() {
        if ((getContext().getApplicationInfo().flags & UiType.FLAG_NO_FEEDBACK) != 0) goto L5;
    L7:
        return false;
    L5:
        if (1 != getLayoutDirection()) goto L7;
        return true;
    }

    public final void n() {
        this.f14068h = true;
        this.f14074n = -1;
        this.f14075o = -1;
        this.f14076p = -1;
        this.f14077q = -1;
        this.f14078r = 0;
        this.f14079s = 0;
    }

    public void o(int r10) {
        this.f14071k = new zc.a(getContext(), this, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        boolean r16 = isInEditMode();
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r18 >= r15) goto L23;
        View r19 = getChildAt(r18);
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        ConstraintWidget r21 = r20.f14129v0;
        if (r19.getVisibility() != 8) goto L15;
        if (r20.f14101h0 == true) goto L15;
        if (r20.f14103i0 == true) goto L15;
        if (r20.f14107k0 == true) goto L15;
        if (r16 == true) goto L15;
    L22:
        r18 = r18 + 1;
    L15:
        if (r20.f14105j0 == true) goto L22;
        int r22 = r21.W();
        int r23 = r21.X();
        int r24 = r21.V() + r22;
        int r25 = r21.w() + r23;
        r19.layout(r22, r23, r24, r25);
        if ((r19 instanceof Placeholder) == false) goto L22;
        View r110 = ((Placeholder) r19).getContent();
        if (r110 == null) goto L22;
        r110.setVisibility(0);
        r110.layout(r22, r23, r24, r25);
        goto L22
    L23:
        int r26 = this.f14062b.size();
        if (r26 <= 0) goto L27;
    L25:
        if (r17 >= r26) goto L35;
        ((ConstraintHelper) this.f14062b.get(r17)).n(this);
        r17 = r17 + 1;
        goto L25
    L35:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r12 = this.f14068h | e(r10, r11);
        this.f14068h = r12;
        if (r12 == true) goto L10;
        int r13 = getChildCount();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L10;
        if (getChildAt(r14).isLayoutRequested() == true) goto L8;
        r14 = r14 + 1;
        goto L5
    L8:
        this.f14068h = true;
    L10:
        this.f14082v = r10;
        this.f14083w = r11;
        this.f14063c.b2(m());
        if (this.f14068h == false) goto L15;
        this.f14068h = false;
        if (v() == false) goto L15;
        this.f14063c.d2();
    L15:
        this.f14063c.K1(null);
        q(this.f14063c, this.f14069i, r10, r11);
        p(r10, r11, this.f14063c.V(), this.f14063c.w(), this.f14063c.T1(), this.f14063c.R1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        super.onViewAdded(r10);
        ConstraintWidget r11 = k(r10);
        if ((r10 instanceof Guideline) == false) goto L8;
        if ((r11 instanceof f) == true) goto L8;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        f r13 = new f();
        r12.f14129v0 = r13;
        r12.f14101h0 = true;
        r13.C1(r12.Z);
    L8:
        if ((r10 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r14 = (ConstraintHelper) r10;
        r14.s();
        ((LayoutParams) r10.getLayoutParams()).f14103i0 = true;
        if (this.f14062b.contains(r14) == true) goto L12;
        this.f14062b.add(r14);
    L12:
        this.f14061a.put(r10.getId(), r10);
        this.f14068h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        this.f14061a.remove(r10.getId());
        ConstraintWidget r11 = k(r10);
        this.f14063c.v1(r11);
        this.f14062b.remove(r10);
        this.f14068h = true;
    }

    public void p(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
        b r16 = this.f14081u;
        int r17 = r16.f14141e;
        int r18 = ViewGroup.resolveSizeAndState(r12 + r16.f14140d, r10, 0);
        int r19 = ViewGroup.resolveSizeAndState(r13 + r17, r11, 0) & 16777215;
        int r20 = this.f14066f;
        int r21 = Math.min(r20, r18 & 16777215);
        int r22 = Math.min(this.f14067g, r19);
        if (r14 == false) goto L5;
        r21 = r21 | 16777216;
    L5:
        if (r15 == false) goto L7;
        r22 = r22 | 16777216;
    L7:
        setMeasuredDimension(r21, r22);
        this.f14074n = r21;
        this.f14075o = r22;
    }

    public void q(d r18, int r19, int r20, int r21) {
        int r10 = View.MeasureSpec.getMode(r20);
        int r11 = View.MeasureSpec.getSize(r20);
        int r12 = View.MeasureSpec.getMode(r21);
        int r13 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r14 = Math.max(0, getPaddingBottom());
        int r15 = r16 + r14;
        int r17 = getPaddingWidth();
        this.f14081u.a(r20, r21, r16, r14, r17, r15);
        int r22 = Math.max(0, getPaddingStart());
        int r23 = Math.max(0, getPaddingEnd());
        if (r22 > 0) goto L8;
        if (r23 > 0) goto L8;
        r23 = Math.max(0, getPaddingLeft());
    L11:
        int r110 = r11 - r17;
        int r111 = r13 - r15;
        t(r18, r10, r110, r12, r111);
        r18.U1(r19, r10, r110, r12, r111, this.f14074n, this.f14075o, r23, r16);
        return;
    L8:
        if (m() == true) goto L11;
        r23 = r22;
        goto L11
    }

    public final void r() {
        boolean r10 = isInEditMode();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = k(getChildAt(r12));
        if (r13 == null) goto L8;
        r13.s0();
    L8:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r10 == false) goto L20;
        int r14 = 0;
    L12:
        if (r14 >= r11) goto L20;
        View r15 = getChildAt(r14);
        String r16 = getResources().getResourceName(r15.getId());     // Catch: Resources.NotFoundException -> L54
        s(0, r16, Integer.valueOf(r15.getId()));     // Catch: Resources.NotFoundException -> L54
        int r17 = r16.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r17 == (-1)) goto L17;
        r16 = r16.substring(r17 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        i(r15.getId()).E0(r16);     // Catch: Resources.NotFoundException -> L54
    L18:
        r14 = r14 + 1;
    L20:
        if (this.f14072l == (-1)) goto L29;
        int r18 = 0;
    L22:
        if (r18 >= r11) goto L29;
        View r19 = getChildAt(r18);
        if (r19.getId() != this.f14072l) goto L28;
        if ((r19 instanceof Constraints) == false) goto L28;
        this.f14070j = ((Constraints) r19).getConstraintSet();
    L28:
        r18 = r18 + 1;
    L29:
        com.obric.oui.constraintlayout.widget.a r20 = this.f14070j;
        if (r20 == null) goto L32;
        r20.k(this, true);
    L32:
        this.f14063c.w1();
        int r21 = this.f14062b.size();
        if (r21 <= 0) goto L37;
        int r22 = 0;
    L35:
        if (r22 >= r21) goto L37;
        ((ConstraintHelper) this.f14062b.get(r22)).r(this);
        r22 = r22 + 1;
    L37:
        int r23 = 0;
    L38:
        if (r23 >= r11) goto L43;
        View r24 = getChildAt(r23);
        if ((r24 instanceof Placeholder) == false) goto L42;
        ((Placeholder) r24).c(this);
    L42:
        r23 = r23 + 1;
        goto L38
    L43:
        this.f14080t.clear();
        this.f14080t.put(0, this.f14063c);
        this.f14080t.put(getId(), this.f14063c);
        int r25 = 0;
    L44:
        if (r25 >= r11) goto L46;
        View r26 = getChildAt(r25);
        this.f14080t.put(r26.getId(), k(r26));
        r25 = r25 + 1;
        goto L44
    L46:
        int r27 = 0;
    L47:
        if (r27 >= r11) goto L53;
        View r28 = getChildAt(r27);
        ConstraintWidget r29 = k(r28);
        if (r29 == null) goto L52;
        LayoutParams r30 = (LayoutParams) r28.getLayoutParams();
        this.f14063c.add(r29);
        d(r10, r28, r29, r30, this.f14080t);
    L52:
        r27 = r27 + 1;
        goto L47
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        n();
        super.requestLayout();
    }

    public void s(int r10, Object r11, Object r12) {
        if (r10 == 0) goto L4;
        return;
    L4:
        if ((r11 instanceof String) == true) goto L6;
        return;
    L6:
        if ((r12 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.f14073m != null) goto L10;
        this.f14073m = new HashMap();
    L10:
        String r13 = (String) r11;
        int r14 = r13.indexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r14 == (-1)) goto L13;
        r13 = r13.substring(r14 + 1);
    L13:
        Integer r15 = (Integer) r12;
        r15.intValue();
        this.f14073m.put(r13, r15);
    }

    public void setConstraintSet(com.obric.oui.constraintlayout.widget.a r10) {
        this.f14070j = r10;
    }

    @Override // android.view.View
    public void setId(int r10) {
        this.f14061a.remove(getId());
        super.setId(r10);
        this.f14061a.put(getId(), this);
    }

    public void setMaxHeight(int r10) {
        if (r10 != this.f14067g) goto L5;
        return;
    L5:
        this.f14067g = r10;
        requestLayout();
    }

    public void setMaxWidth(int r10) {
        if (r10 != this.f14066f) goto L5;
        return;
    L5:
        this.f14066f = r10;
        requestLayout();
    }

    public void setMinHeight(int r10) {
        if (r10 != this.f14065e) goto L5;
        return;
    L5:
        this.f14065e = r10;
        requestLayout();
    }

    public void setMinWidth(int r10) {
        if (r10 != this.f14064d) goto L5;
        return;
    L5:
        this.f14064d = r10;
        requestLayout();
    }

    public void setOnConstraintsChanged(zc.b r10) {
        zc.a r11 = this.f14071k;
        if (r11 == null) goto L6;
        r11.c(r10);
        return;
    }

    public void setOptimizationLevel(int r10) {
        this.f14069i = r10;
        this.f14063c.Z1(r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(d r10, int r11, int r12, int r13, int r14) {
        b r15 = this.f14081u;
        int r16 = r15.f14141e;
        int r17 = r15.f14140d;
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r19 = getChildCount();
        if (r11 == Integer.MIN_VALUE) goto L12;
        if (r11 == 0) goto L9;
        if (r11 == 1073741824) goto L8;
        ConstraintWidget.DimensionBehaviour r20 = r18;
    L7:
        r12 = 0;
    L15:
        if (r13 == Integer.MIN_VALUE) goto L23;
        if (r13 == 0) goto L20;
        if (r13 == 1073741824) goto L19;
    L18:
        r14 = 0;
    L27:
        if (r12 == r10.V()) goto L29;
    L30:
        r10.Q1();
    L31:
        r10.o1(0);
        r10.p1(0);
        r10.Z0(this.f14066f - r17);
        r10.Y0(this.f14067g - r16);
        r10.c1(0);
        r10.b1(0);
        r10.R0(r20);
        r10.m1(r12);
        r10.i1(r18);
        r10.N0(r14);
        r10.c1(this.f14064d - r17);
        r10.b1(this.f14065e - r16);
        return;
    L29:
        if (r14 == r10.w()) goto L31;
    L19:
        r14 = Math.min(this.f14067g - r16, r14);
        goto L27
    L20:
        r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L18;
        r14 = Math.max(0, this.f14065e);
        goto L27
    L23:
        r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L27;
        r14 = Math.max(0, this.f14065e);
        goto L27
    L8:
        r12 = Math.min(this.f14066f - r17, r12);
        r20 = r18;
        goto L15
    L9:
        r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L7;
        r12 = Math.max(0, this.f14064d);
        goto L15
    L12:
        r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L15;
        r12 = Math.max(0, this.f14064d);
        goto L15
    }

    public final void u(ConstraintWidget r10, LayoutParams r11, SparseArray r12, int r13, ConstraintAnchor.Type r14) {
        View r15 = (View) this.f14061a.get(r13);
        ConstraintWidget r16 = (ConstraintWidget) r12.get(r13);
        if (r16 == null) goto L12;
        if (r15 != null) goto L6;
        return;
    L6:
        if ((r15.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r11.f14099g0 = true;
        ConstraintAnchor.Type r17 = ConstraintAnchor.Type.BASELINE;
        if (r14 != r17) goto L10;
        LayoutParams r18 = (LayoutParams) r15.getLayoutParams();
        r18.f14099g0 = true;
        r18.f14129v0.M0(true);
    L10:
        r10.n(r17).b(r16.n(r14), r11.D, r11.C, true);
        r10.M0(true);
        r10.n(ConstraintAnchor.Type.TOP).q();
        r10.n(ConstraintAnchor.Type.BOTTOM).q();
        return;
    L14:
        return;
    }

    public final boolean v() {
        int r10 = getChildCount();
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        if (getChildAt(r12).isLayoutRequested() == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        r11 = true;
    L8:
        if (r11 == false) goto L10;
        r();
    L10:
        return r11;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    public ConstraintLayout(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f14061a = new SparseArray();
        this.f14062b = new ArrayList(4);
        this.f14063c = new d();
        this.f14064d = 0;
        this.f14065e = 0;
        this.f14066f = Channel.UNLIMITED;
        this.f14067g = Channel.UNLIMITED;
        this.f14068h = true;
        this.f14069i = 257;
        this.f14070j = null;
        this.f14071k = null;
        this.f14072l = -1;
        this.f14073m = new HashMap();
        this.f14074n = -1;
        this.f14075o = -1;
        this.f14076p = -1;
        this.f14077q = -1;
        this.f14078r = 0;
        this.f14079s = 0;
        this.f14080t = new SparseArray();
        this.f14081u = new b(this, this);
        this.f14082v = 0;
        this.f14083w = 0;
        l(r11, 0, 0);
    }

    public ConstraintLayout(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f14061a = new SparseArray();
        this.f14062b = new ArrayList(4);
        this.f14063c = new d();
        this.f14064d = 0;
        this.f14065e = 0;
        this.f14066f = Channel.UNLIMITED;
        this.f14067g = Channel.UNLIMITED;
        this.f14068h = true;
        this.f14069i = 257;
        this.f14070j = null;
        this.f14071k = null;
        this.f14072l = -1;
        this.f14073m = new HashMap();
        this.f14074n = -1;
        this.f14075o = -1;
        this.f14076p = -1;
        this.f14077q = -1;
        this.f14078r = 0;
        this.f14079s = 0;
        this.f14080t = new SparseArray();
        this.f14081u = new b(this, this);
        this.f14082v = 0;
        this.f14083w = 0;
        l(r11, r12, 0);
    }
}
