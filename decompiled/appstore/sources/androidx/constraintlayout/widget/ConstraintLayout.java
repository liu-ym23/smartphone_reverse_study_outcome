package androidx.constraintlayout.widget;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.h;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

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
        public float f2186J;
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
        public int f2187a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f2188a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2189b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f2190b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2191c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f2192c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2193d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f2194d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2195e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f2196e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2197f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f2198f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2199g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f2200g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2201h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f2202h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2203i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f2204i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2205j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f2206j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2207k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public boolean f2208k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2209l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f2210l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2211m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public int f2212m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2213n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f2214n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2215o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f2216o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f2217p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f2218p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f2219q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f2220q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f2221r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f2222r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f2223s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public int f2224s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f2225t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f2226t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f2227u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f2228u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f2229v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public ConstraintWidget f2230v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f2231w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f2232w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f2233x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f2234y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f2235z;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f2236a = null;

            static {
                SparseIntArray r10 = new SparseIntArray();
                f2236a = r10;
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

        public LayoutParams(Context r11, AttributeSet r12) {
            super(r11, r12);
            this.f2187a = -1;
            this.f2189b = -1;
            this.f2191c = -1.0f;
            this.f2193d = true;
            this.f2195e = -1;
            this.f2197f = -1;
            this.f2199g = -1;
            this.f2201h = -1;
            this.f2203i = -1;
            this.f2205j = -1;
            this.f2207k = -1;
            this.f2209l = -1;
            this.f2211m = -1;
            this.f2213n = -1;
            this.f2215o = -1;
            this.f2217p = -1;
            this.f2219q = 0;
            this.f2221r = 0.0f;
            this.f2223s = -1;
            this.f2225t = -1;
            this.f2227u = -1;
            this.f2229v = -1;
            this.f2231w = Integer.MIN_VALUE;
            this.f2233x = Integer.MIN_VALUE;
            this.f2234y = Integer.MIN_VALUE;
            this.f2235z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f2186J = 0.0f;
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
            this.f2188a0 = false;
            this.f2190b0 = false;
            this.f2192c0 = null;
            this.f2194d0 = 0;
            this.f2196e0 = true;
            this.f2198f0 = true;
            this.f2200g0 = false;
            this.f2202h0 = false;
            this.f2204i0 = false;
            this.f2206j0 = false;
            this.f2208k0 = false;
            this.f2210l0 = -1;
            this.f2212m0 = -1;
            this.f2214n0 = -1;
            this.f2216o0 = -1;
            this.f2218p0 = Integer.MIN_VALUE;
            this.f2220q0 = Integer.MIN_VALUE;
            this.f2222r0 = 0.5f;
            this.f2230v0 = new ConstraintWidget();
            this.f2232w0 = false;
            TypedArray r13 = r11.obtainStyledAttributes(r12, R$styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r10 = 0;
        L3:
            if (r10 >= r14) goto L118;
            int r15 = r13.getIndex(r10);
            int r16 = a.f2236a.get(r15);
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
            this.f2193d = r13.getBoolean(r15, this.f2193d);
            goto L117
        L10:
            this.f2194d0 = r13.getInt(r15, this.f2194d0);
            goto L117
        L11:
            ConstraintSet.L(this, r13, r15, 1);
            this.F = true;
            goto L117
        L12:
            ConstraintSet.L(this, r13, r15, 0);
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
            int r17 = r13.getResourceId(r15, this.f2215o);
            this.f2215o = r17;
            if (r17 != (-1)) goto L117;
            this.f2215o = r13.getInt(r15, -1);
            goto L117
        L18:
            int r18 = r13.getResourceId(r15, this.f2213n);
            this.f2213n = r18;
            if (r18 != (-1)) goto L117;
            this.f2213n = r13.getInt(r15, -1);
            goto L117
        L21:
            this.f2192c0 = r13.getString(r15);
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
            ConstraintSet.N(this, r13.getString(r15));
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
            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L117
        L54:
            int r20 = r13.getInt(r15, 0);
            this.P = r20;
            if (r20 != 1) goto L117;
            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L117
        L57:
            this.H = r13.getFloat(r15, this.H);
            goto L117
        L58:
            this.G = r13.getFloat(r15, this.G);
            goto L117
        L59:
            this.f2190b0 = r13.getBoolean(r15, this.f2190b0);
            goto L117
        L60:
            this.f2188a0 = r13.getBoolean(r15, this.f2188a0);
            goto L117
        L61:
            this.B = r13.getDimensionPixelSize(r15, this.B);
            goto L117
        L62:
            this.A = r13.getDimensionPixelSize(r15, this.A);
            goto L117
        L63:
            this.f2235z = r13.getDimensionPixelSize(r15, this.f2235z);
            goto L117
        L64:
            this.f2234y = r13.getDimensionPixelSize(r15, this.f2234y);
            goto L117
        L65:
            this.f2233x = r13.getDimensionPixelSize(r15, this.f2233x);
            goto L117
        L66:
            this.f2231w = r13.getDimensionPixelSize(r15, this.f2231w);
            goto L117
        L67:
            int r21 = r13.getResourceId(r15, this.f2229v);
            this.f2229v = r21;
            if (r21 != (-1)) goto L117;
            this.f2229v = r13.getInt(r15, -1);
            goto L117
        L70:
            int r22 = r13.getResourceId(r15, this.f2227u);
            this.f2227u = r22;
            if (r22 != (-1)) goto L117;
            this.f2227u = r13.getInt(r15, -1);
            goto L117
        L73:
            int r23 = r13.getResourceId(r15, this.f2225t);
            this.f2225t = r23;
            if (r23 != (-1)) goto L117;
            this.f2225t = r13.getInt(r15, -1);
            goto L117
        L76:
            int r24 = r13.getResourceId(r15, this.f2223s);
            this.f2223s = r24;
            if (r24 != (-1)) goto L117;
            this.f2223s = r13.getInt(r15, -1);
            goto L117
        L79:
            int r25 = r13.getResourceId(r15, this.f2211m);
            this.f2211m = r25;
            if (r25 != (-1)) goto L117;
            this.f2211m = r13.getInt(r15, -1);
            goto L117
        L82:
            int r26 = r13.getResourceId(r15, this.f2209l);
            this.f2209l = r26;
            if (r26 != (-1)) goto L117;
            this.f2209l = r13.getInt(r15, -1);
            goto L117
        L85:
            int r27 = r13.getResourceId(r15, this.f2207k);
            this.f2207k = r27;
            if (r27 != (-1)) goto L117;
            this.f2207k = r13.getInt(r15, -1);
            goto L117
        L88:
            int r28 = r13.getResourceId(r15, this.f2205j);
            this.f2205j = r28;
            if (r28 != (-1)) goto L117;
            this.f2205j = r13.getInt(r15, -1);
            goto L117
        L91:
            int r29 = r13.getResourceId(r15, this.f2203i);
            this.f2203i = r29;
            if (r29 != (-1)) goto L117;
            this.f2203i = r13.getInt(r15, -1);
            goto L117
        L94:
            int r30 = r13.getResourceId(r15, this.f2201h);
            this.f2201h = r30;
            if (r30 != (-1)) goto L117;
            this.f2201h = r13.getInt(r15, -1);
            goto L117
        L97:
            int r31 = r13.getResourceId(r15, this.f2199g);
            this.f2199g = r31;
            if (r31 != (-1)) goto L117;
            this.f2199g = r13.getInt(r15, -1);
            goto L117
        L100:
            int r32 = r13.getResourceId(r15, this.f2197f);
            this.f2197f = r32;
            if (r32 != (-1)) goto L117;
            this.f2197f = r13.getInt(r15, -1);
            goto L117
        L103:
            int r33 = r13.getResourceId(r15, this.f2195e);
            this.f2195e = r33;
            if (r33 != (-1)) goto L117;
            this.f2195e = r13.getInt(r15, -1);
            goto L117
        L106:
            this.f2191c = r13.getFloat(r15, this.f2191c);
            goto L117
        L107:
            this.f2189b = r13.getDimensionPixelOffset(r15, this.f2189b);
            goto L117
        L108:
            this.f2187a = r13.getDimensionPixelOffset(r15, this.f2187a);
            goto L117
        L109:
            float r34 = r13.getFloat(r15, this.f2221r) % 360.0f;
            this.f2221r = r34;
            if (r34 >= 0.0f) goto L117;
            this.f2221r = (360.0f - r34) % 360.0f;
            goto L117
        L112:
            this.f2219q = r13.getDimensionPixelSize(r15, this.f2219q);
            goto L117
        L113:
            int r35 = r13.getResourceId(r15, this.f2217p);
            this.f2217p = r35;
            if (r35 != (-1)) goto L117;
            this.f2217p = r13.getInt(r15, -1);
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

        public String a() {
            return this.f2192c0;
        }

        public ConstraintWidget b() {
            return this.f2230v0;
        }

        public void c() {
            this.f2202h0 = false;
            this.f2196e0 = true;
            this.f2198f0 = true;
            int r10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r10 == (-2)) goto L5;
        L9:
            int r11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r11 != (-2)) goto L17;
            if (this.f2190b0 == false) goto L17;
            this.f2198f0 = false;
            if (this.Q != 0) goto L17;
            this.Q = 1;
        L17:
            if (r10 == 0) goto L19;
            if (r10 == (-1)) goto L19;
        L24:
            if (r11 == 0) goto L26;
            if (r11 == (-1)) goto L26;
        L32:
            if (this.f2191c == (-1.0f)) goto L34;
        L37:
            this.f2202h0 = true;
            this.f2196e0 = true;
            this.f2198f0 = true;
            if ((this.f2230v0 instanceof e) == true) goto L40;
            this.f2230v0 = new e();
        L40:
            ((e) this.f2230v0).B1(this.Z);
            return;
        L34:
            if (this.f2187a != (-1)) goto L37;
            if (this.f2189b != (-1)) goto L37;
            return;
        L26:
            this.f2198f0 = false;
            if (r11 != 0) goto L32;
            if (this.Q != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.f2190b0 = true;
        L19:
            this.f2196e0 = false;
            if (r10 != 0) goto L24;
            if (this.P != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.f2188a0 = true;
            goto L24
        L5:
            if (this.f2188a0 == false) goto L9;
            this.f2196e0 = false;
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
            this.f2214n0 = -1;
            this.f2216o0 = -1;
            this.f2210l0 = -1;
            this.f2212m0 = -1;
            this.f2218p0 = this.f2231w;
            this.f2220q0 = this.f2234y;
            float r15 = this.G;
            this.f2222r0 = r15;
            int r16 = this.f2187a;
            this.f2224s0 = r16;
            int r17 = this.f2189b;
            this.f2226t0 = r17;
            float r18 = this.f2191c;
            this.f2228u0 = r18;
            if (r14 == false) goto L43;
            int r19 = this.f2223s;
            if (r19 == (-1)) goto L12;
            this.f2214n0 = r19;
        L11:
            r13 = true;
        L15:
            int r110 = this.f2227u;
            if (r110 == (-1)) goto L18;
            this.f2212m0 = r110;
            r13 = true;
        L18:
            int r111 = this.f2229v;
            if (r111 == (-1)) goto L21;
            this.f2210l0 = r111;
            r13 = true;
        L21:
            int r112 = this.A;
            if (r112 == Integer.MIN_VALUE) goto L24;
            this.f2220q0 = r112;
        L24:
            int r113 = this.B;
            if (r113 == Integer.MIN_VALUE) goto L28;
            this.f2218p0 = r113;
        L28:
            if (r13 == false) goto L31;
            this.f2222r0 = 1.0f - r15;
        L31:
            if (this.f2202h0 == false) goto L62;
            if (this.Z != 1) goto L62;
            if (this.f2193d == false) goto L62;
            if (r18 == (-1.0f)) goto L39;
            this.f2228u0 = 1.0f - r18;
            this.f2224s0 = -1;
            this.f2226t0 = -1;
            goto L62
        L39:
            if (r16 == (-1)) goto L41;
            this.f2226t0 = r16;
            this.f2224s0 = -1;
            this.f2228u0 = -1.0f;
            goto L62
        L41:
            if (r17 == (-1)) goto L62;
            this.f2224s0 = r17;
            this.f2226t0 = -1;
            this.f2228u0 = -1.0f;
        L62:
            if (this.f2227u == (-1)) goto L64;
            return;
        L64:
            if (this.f2229v == (-1)) goto L66;
            return;
        L66:
            if (this.f2225t == (-1)) goto L68;
            return;
        L68:
            if (this.f2223s != (-1)) goto L97;
            int r114 = this.f2199g;
            if (r114 == (-1)) goto L75;
            this.f2214n0 = r114;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r12 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r12;
        L81:
            int r115 = this.f2195e;
            if (r115 == (-1)) goto L87;
            this.f2210l0 = r115;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L98;
            if (r10 <= 0) goto L99;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10;
            return;
        L99:
            return;
        L98:
            return;
        L87:
            int r116 = this.f2197f;
            if (r116 == (-1)) goto L101;
            this.f2212m0 = r116;
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
            int r117 = this.f2201h;
            if (r117 == (-1)) goto L81;
            this.f2216o0 = r117;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L81;
            if (r12 <= 0) goto L81;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r12;
            goto L81
        L97:
            return;
        L12:
            int r118 = this.f2225t;
            if (r118 == (-1)) goto L15;
            this.f2216o0 = r118;
            goto L11
        L43:
            int r119 = this.f2223s;
            if (r119 == (-1)) goto L46;
            this.f2212m0 = r119;
        L46:
            int r120 = this.f2225t;
            if (r120 == (-1)) goto L49;
            this.f2210l0 = r120;
        L49:
            int r121 = this.f2227u;
            if (r121 == (-1)) goto L52;
            this.f2214n0 = r121;
        L52:
            int r122 = this.f2229v;
            if (r122 == (-1)) goto L55;
            this.f2216o0 = r122;
        L55:
            int r123 = this.A;
            if (r123 == Integer.MIN_VALUE) goto L58;
            this.f2218p0 = r123;
        L58:
            int r124 = this.B;
            if (r124 == Integer.MIN_VALUE) goto L62;
            this.f2220q0 = r124;
            goto L62
        L5:
            r14 = false;
            goto L6
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f2187a = -1;
            this.f2189b = -1;
            this.f2191c = -1.0f;
            this.f2193d = true;
            this.f2195e = -1;
            this.f2197f = -1;
            this.f2199g = -1;
            this.f2201h = -1;
            this.f2203i = -1;
            this.f2205j = -1;
            this.f2207k = -1;
            this.f2209l = -1;
            this.f2211m = -1;
            this.f2213n = -1;
            this.f2215o = -1;
            this.f2217p = -1;
            this.f2219q = 0;
            this.f2221r = 0.0f;
            this.f2223s = -1;
            this.f2225t = -1;
            this.f2227u = -1;
            this.f2229v = -1;
            this.f2231w = Integer.MIN_VALUE;
            this.f2233x = Integer.MIN_VALUE;
            this.f2234y = Integer.MIN_VALUE;
            this.f2235z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f2186J = 0.0f;
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
            this.f2188a0 = false;
            this.f2190b0 = false;
            this.f2192c0 = null;
            this.f2194d0 = 0;
            this.f2196e0 = true;
            this.f2198f0 = true;
            this.f2200g0 = false;
            this.f2202h0 = false;
            this.f2204i0 = false;
            this.f2206j0 = false;
            this.f2208k0 = false;
            this.f2210l0 = -1;
            this.f2212m0 = -1;
            this.f2214n0 = -1;
            this.f2216o0 = -1;
            this.f2218p0 = Integer.MIN_VALUE;
            this.f2220q0 = Integer.MIN_VALUE;
            this.f2222r0 = 0.5f;
            this.f2230v0 = new ConstraintWidget();
            this.f2232w0 = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f2187a = -1;
            this.f2189b = -1;
            this.f2191c = -1.0f;
            this.f2193d = true;
            this.f2195e = -1;
            this.f2197f = -1;
            this.f2199g = -1;
            this.f2201h = -1;
            this.f2203i = -1;
            this.f2205j = -1;
            this.f2207k = -1;
            this.f2209l = -1;
            this.f2211m = -1;
            this.f2213n = -1;
            this.f2215o = -1;
            this.f2217p = -1;
            this.f2219q = 0;
            this.f2221r = 0.0f;
            this.f2223s = -1;
            this.f2225t = -1;
            this.f2227u = -1;
            this.f2229v = -1;
            this.f2231w = Integer.MIN_VALUE;
            this.f2233x = Integer.MIN_VALUE;
            this.f2234y = Integer.MIN_VALUE;
            this.f2235z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.f2186J = 0.0f;
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
            this.f2188a0 = false;
            this.f2190b0 = false;
            this.f2192c0 = null;
            this.f2194d0 = 0;
            this.f2196e0 = true;
            this.f2198f0 = true;
            this.f2200g0 = false;
            this.f2202h0 = false;
            this.f2204i0 = false;
            this.f2206j0 = false;
            this.f2208k0 = false;
            this.f2210l0 = -1;
            this.f2212m0 = -1;
            this.f2214n0 = -1;
            this.f2216o0 = -1;
            this.f2218p0 = Integer.MIN_VALUE;
            this.f2220q0 = Integer.MIN_VALUE;
            this.f2222r0 = 0.5f;
            this.f2230v0 = new ConstraintWidget();
            this.f2232w0 = false;
        }
    }

    public class Measurer implements BasicMeasure.Measurer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f2237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2242f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2243g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f2244h;

        public Measurer(ConstraintLayout r10, ConstraintLayout r11) {
            this.f2244h = r10;
            this.f2237a = r11;
        }

        public void a(int r10, int r11, int r12, int r13, int r14, int r15) {
            this.f2238b = r12;
            this.f2239c = r13;
            this.f2240d = r14;
            this.f2241e = r15;
            this.f2242f = r10;
            this.f2243g = r11;
        }

        public final boolean b(int r10, int r11, int r12) {
            if (r10 != r11) goto L5;
            return true;
        L5:
            int r13 = View.MeasureSpec.getMode(r10);
            View.MeasureSpec.getSize(r10);
            int r14 = View.MeasureSpec.getMode(r11);
            int r15 = View.MeasureSpec.getSize(r11);
            if (r14 == 1073741824) goto L8;
            return false;
        L8:
            if (r13 == Integer.MIN_VALUE) goto L10;
            if (r13 == 0) goto L10;
            return false;
        L10:
            if (r12 != r15) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r10 = this.f2237a.getChildCount();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L8;
            View r13 = this.f2237a.getChildAt(r12);
            if ((r13 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r13).b(this.f2237a);
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            int r14 = ConstraintLayout.access$100(this.f2237a).size();
            if (r14 <= 0) goto L12;
        L10:
            if (r11 >= r14) goto L17;
            ((ConstraintHelper) ConstraintLayout.access$100(this.f2237a).get(r11)).o(this.f2237a);
            r11 = r11 + 1;
            goto L10
        L17:
            return;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void measure(ConstraintWidget r18, BasicMeasure.a r19) {
            if (r18 != null) goto L6;
            return;
        L6:
            if (r18.U() != 8) goto L12;
            if (r18.i0() == true) goto L12;
            r19.f1523e = 0;
            r19.f1524f = 0;
            r19.f1525g = 0;
            return;
        L12:
            if (r18.J() != null) goto L14;
            return;
        L14:
            ConstraintWidget.DimensionBehaviour r10 = r19.f1519a;
            ConstraintWidget.DimensionBehaviour r11 = r19.f1520b;
            int r12 = r19.f1521c;
            int r13 = r19.f1522d;
            int r14 = this.f2238b + this.f2239c;
            int r15 = this.f2240d;
            View r16 = (View) r18.r();
            int[] r17 = a.f2245a;
            int r110 = r17[r10.ordinal()];
            if (r110 == 1) goto L44;
            if (r110 == 2) goto L43;
            if (r110 == 3) goto L42;
            if (r110 == 4) goto L20;
            int r20 = 0;
        L45:
            int r21 = r17[r11.ordinal()];
            if (r21 == 1) goto L77;
            if (r21 != 2) goto L49;
            int r22 = ViewGroup.getChildMeasureSpec(this.f2243g, r14, -2);
        L78:
            ConstraintWidgetContainer r23 = (ConstraintWidgetContainer) r18.J();
            if (r23 != null) goto L81;
        L100:
            ConstraintWidget.DimensionBehaviour r24 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r10 != r24) goto L103;
            boolean r25 = true;
        L104:
            if (r11 != r24) goto L106;
            boolean r26 = true;
        L107:
            ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r11 != r111) goto L110;
        L113:
            boolean r27 = true;
        L114:
            if (r10 != r111) goto L116;
        L119:
            boolean r28 = true;
        L121:
            if (r25 == true) goto L123;
        L125:
            boolean r112 = false;
        L126:
            if (r26 == true) goto L128;
        L130:
            boolean r113 = false;
        L131:
            if (r16 != null) goto L133;
            return;
        L133:
            LayoutParams r114 = (LayoutParams) r16.getLayoutParams();
            int r115 = r19.f1528j;
            if (r115 == BasicMeasure.a.f1517l) goto L146;
            if (r115 == BasicMeasure.a.f1518m) goto L146;
            if (r25 == false) goto L146;
            if (r18.f1476w != 0) goto L146;
            if (r26 == false) goto L146;
            if (r18.f1478x != 0) goto L146;
            int r29 = -1;
            int r30 = 0;
            int r116 = 0;
            int r117 = 0;
        L185:
            if (r116 == r29) goto L187;
            boolean r31 = true;
        L189:
            if (r117 == r19.f1521c) goto L191;
        L194:
            boolean r32 = true;
        L195:
            r19.f1527i = r32;
            if (r114.f2200g0 == false) goto L198;
            r31 = true;
        L198:
            if (r31 == true) goto L200;
        L204:
            r19.f1523e = r117;
            r19.f1524f = r30;
            r19.f1526h = r31;
            r19.f1525g = r116;
            return;
        L200:
            if (r116 == (-1)) goto L204;
            if (r18.o() == r116) goto L204;
            r19.f1527i = true;
            goto L204
        L191:
            if (r30 != r19.f1522d) goto L194;
            r32 = false;
            goto L195
        L187:
            r31 = false;
        L146:
            if ((r16 instanceof VirtualLayout) == true) goto L148;
        L150:
            r16.measure(r20, r22);
        L151:
            r18.W0(r20, r22);
            int r33 = r16.getMeasuredWidth();
            int r34 = r16.getMeasuredHeight();
            r116 = r16.getBaseline();
            int r118 = r18.f1482z;
            if (r118 <= 0) goto L154;
            r117 = Math.max(r118, r33);
        L155:
            int r35 = r18.A;
            if (r35 <= 0) goto L158;
            r117 = Math.min(r35, r117);
        L158:
            int r36 = r18.C;
            if (r36 <= 0) goto L161;
            r30 = Math.max(r36, r34);
        L162:
            int r37 = r18.D;
            if (r37 <= 0) goto L166;
            r30 = Math.min(r37, r30);
        L166:
            if (f.b(ConstraintLayout.access$000(this.f2244h), 1) == false) goto L168;
        L174:
            if (r33 != r117) goto L179;
            if (r34 != r30) goto L179;
        L177:
            r29 = -1;
        L179:
            if (r33 == r117) goto L181;
            int r38 = View.MeasureSpec.makeMeasureSpec(r117, Ints.MAX_POWER_OF_TWO);
        L182:
            if (r34 == r30) goto L184;
            r22 = View.MeasureSpec.makeMeasureSpec(r30, Ints.MAX_POWER_OF_TWO);
        L184:
            r16.measure(r38, r22);
            r18.W0(r38, r22);
            r117 = r16.getMeasuredWidth();
            r30 = r16.getMeasuredHeight();
            r116 = r16.getBaseline();
            goto L177
        L181:
            r38 = r20;
            goto L182
        L168:
            if (r112 == false) goto L171;
            if (r27 == false) goto L171;
            r117 = (int) ((r30 * r18.f1443f0) + 0.5f);
        L171:
            if (r113 == false) goto L174;
            if (r28 == false) goto L174;
            r30 = (int) ((r117 / r18.f1443f0) + 0.5f);
            goto L174
        L161:
            r30 = r34;
            goto L162
        L154:
            r117 = r33;
            goto L155
        L148:
            if ((r18 instanceof h) == false) goto L150;
            ((VirtualLayout) r16).t((h) r18, r20, r22);
            goto L151
        L128:
            if (r18.f1443f0 <= 0.0f) goto L130;
            r113 = true;
            goto L131
        L123:
            if (r18.f1443f0 <= 0.0f) goto L125;
            r112 = true;
            goto L126
        L116:
            if (r10 == ConstraintWidget.DimensionBehaviour.FIXED) goto L119;
            r28 = false;
            goto L121
        L110:
            if (r11 == ConstraintWidget.DimensionBehaviour.FIXED) goto L113;
            r27 = false;
            goto L114
        L106:
            r26 = false;
            goto L107
        L103:
            r25 = false;
            goto L104
        L81:
            if (f.b(ConstraintLayout.access$000(this.f2244h), 256) == false) goto L100;
            if (r16.getMeasuredWidth() != r18.V()) goto L100;
            if (r16.getMeasuredWidth() >= r23.V()) goto L100;
            if (r16.getMeasuredHeight() != r18.w()) goto L100;
            if (r16.getMeasuredHeight() >= r23.w()) goto L100;
            if (r16.getBaseline() != r18.o()) goto L100;
            if (r18.l0() == true) goto L100;
            if (b(r18.B(), r20, r18.V()) == false) goto L100;
            if (b(r18.C(), r22, r18.w()) == false) goto L100;
            r19.f1523e = r18.V();
            r19.f1524f = r18.w();
            r19.f1525g = r18.o();
            return;
        L49:
            if (r21 != 3) goto L51;
            r22 = ViewGroup.getChildMeasureSpec(this.f2243g, r14 + r18.T(), -1);
            goto L78
        L51:
            if (r21 == 4) goto L53;
            r22 = 0;
            goto L78
        L53:
            r22 = ViewGroup.getChildMeasureSpec(this.f2243g, r14, -2);
            if (r18.f1478x != 1) goto L56;
            boolean r39 = true;
        L57:
            int r40 = r19.f1528j;
            if (r40 == BasicMeasure.a.f1517l) goto L62;
            if (r40 != BasicMeasure.a.f1518m) goto L78;
        L62:
            if (r16.getMeasuredWidth() != r18.V()) goto L64;
            boolean r41 = true;
        L66:
            if (r19.f1528j == BasicMeasure.a.f1518m) goto L74;
            if (r39 == false) goto L74;
            if (r39 == false) goto L71;
            if (r41 == true) goto L74;
        L71:
            if ((r16 instanceof Placeholder) == true) goto L74;
            if (r18.n0() == false) goto L78;
        L74:
            r22 = View.MeasureSpec.makeMeasureSpec(r18.w(), Ints.MAX_POWER_OF_TWO);
            goto L78
        L64:
            r41 = false;
            goto L66
        L56:
            r39 = false;
            goto L57
        L77:
            r22 = View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO);
            goto L78
        L20:
            r20 = ViewGroup.getChildMeasureSpec(this.f2242f, r15, -2);
            if (r18.f1476w != 1) goto L23;
            boolean r42 = true;
        L24:
            int r119 = r19.f1528j;
            if (r119 == BasicMeasure.a.f1517l) goto L29;
            if (r119 != BasicMeasure.a.f1518m) goto L45;
        L29:
            if (r16.getMeasuredHeight() != r18.w()) goto L31;
            boolean r120 = true;
        L33:
            if (r19.f1528j == BasicMeasure.a.f1518m) goto L41;
            if (r42 == false) goto L41;
            if (r42 == false) goto L38;
            if (r120 == true) goto L41;
        L38:
            if ((r16 instanceof Placeholder) == true) goto L41;
            if (r18.m0() == false) goto L45;
        L41:
            r20 = View.MeasureSpec.makeMeasureSpec(r18.V(), Ints.MAX_POWER_OF_TWO);
            goto L45
        L31:
            r120 = false;
            goto L33
        L23:
            r42 = false;
            goto L24
        L42:
            r20 = ViewGroup.getChildMeasureSpec(this.f2242f, r15 + r18.A(), -1);
            goto L45
        L43:
            r20 = ViewGroup.getChildMeasureSpec(this.f2242f, r15, -2);
            goto L45
        L44:
            r20 = View.MeasureSpec.makeMeasureSpec(r12, Ints.MAX_POWER_OF_TWO);
            goto L45
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2245a = null;

        static {
            int[] r10 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f2245a = r10;
            r10[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f2245a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f2245a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f2245a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
    }

    public ConstraintLayout(@NonNull Context r10) {
        super(r10);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Channel.UNLIMITED;
        this.mMaxHeight = Channel.UNLIMITED;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(null, 0, 0);
    }

    public static /* synthetic */ int access$000(ConstraintLayout r10) {
        return r10.mOptimizationLevel;
    }

    public static /* synthetic */ ArrayList access$100(ConstraintLayout r10) {
        return r10.mConstraintHelpers;
    }

    private void b(AttributeSet r10, int r11, int r12) {
        this.mLayoutWidget.C0(this);
        this.mLayoutWidget.X1(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r10 == null) goto L37;
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout, r11, r12);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L36;
        int r16 = r13.getIndex(r15);
        if (r16 != R$styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.mMinWidth = r13.getDimensionPixelOffset(r16, this.mMinWidth);
    L35:
        r15 = r15 + 1;
        goto L5
    L10:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.mMinHeight = r13.getDimensionPixelOffset(r16, this.mMinHeight);
        goto L35
    L13:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.mMaxWidth = r13.getDimensionPixelOffset(r16, this.mMaxWidth);
        goto L35
    L16:
        if (r16 != R$styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.mMaxHeight = r13.getDimensionPixelOffset(r16, this.mMaxHeight);
        goto L35
    L19:
        if (r16 != R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.mOptimizationLevel = r13.getInt(r16, this.mOptimizationLevel);
        goto L35
    L22:
        if (r16 != R$styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r17 = r13.getResourceId(r16, 0);
        if (r17 == 0) goto L35;
        parseLayoutDescription(r17);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r16 != R$styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r18 = r13.getResourceId(r16, 0);
        ConstraintSet r19 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r19;     // Catch: Resources.NotFoundException -> L33
        r19.I(getContext(), r18);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r18;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r13.recycle();
    L37:
        this.mLayoutWidget.Y1(this.mOptimizationLevel);
    }

    private void c() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void d() {
        boolean r10 = isInEditMode();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = getViewWidget(getChildAt(r12));
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
        setDesignInformation(0, r16, Integer.valueOf(r15.getId()));     // Catch: Resources.NotFoundException -> L54
        int r17 = r16.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r17 == (-1)) goto L17;
        r16 = r16.substring(r17 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        a(r15.getId()).D0(r16);     // Catch: Resources.NotFoundException -> L54
    L18:
        r14 = r14 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r18 = 0;
    L22:
        if (r18 >= r11) goto L29;
        View r19 = getChildAt(r18);
        if (r19.getId() != this.mConstraintSetId) goto L28;
        if ((r19 instanceof Constraints) == false) goto L28;
        this.mConstraintSet = ((Constraints) r19).getConstraintSet();
    L28:
        r18 = r18 + 1;
    L29:
        ConstraintSet r20 = this.mConstraintSet;
        if (r20 == null) goto L32;
        r20.k(this, true);
    L32:
        this.mLayoutWidget.v1();
        int r21 = this.mConstraintHelpers.size();
        if (r21 <= 0) goto L37;
        int r22 = 0;
    L35:
        if (r22 >= r21) goto L37;
        this.mConstraintHelpers.get(r22).r(this);
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
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r25 = 0;
    L44:
        if (r25 >= r11) goto L46;
        View r26 = getChildAt(r25);
        this.mTempMapIdToWidget.put(r26.getId(), getViewWidget(r26));
        r25 = r25 + 1;
        goto L44
    L46:
        int r27 = 0;
    L47:
        if (r27 >= r11) goto L53;
        View r28 = getChildAt(r27);
        ConstraintWidget r29 = getViewWidget(r28);
        if (r29 == null) goto L52;
        LayoutParams r30 = (LayoutParams) r28.getLayoutParams();
        this.mLayoutWidget.add(r29);
        applyConstraintsFromLayoutParams(r10, r28, r29, r30, this.mTempMapIdToWidget);
    L52:
        r27 = r27 + 1;
        goto L47
    }

    private boolean f() {
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
        d();
    L10:
        return r11;
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
        if (sSharedValues != null) goto L6;
        sSharedValues = new SharedValues();
    L6:
        return sSharedValues;
    }

    public final ConstraintWidget a(int r10) {
        if (r10 == 0) goto L4;
        View r11 = this.mChildrenByIds.get(r10);
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
        return ((LayoutParams) r11.getLayoutParams()).f2230v0;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    public void applyConstraintsFromLayoutParams(boolean r17, View r18, ConstraintWidget r19, LayoutParams r20, SparseArray<ConstraintWidget> r21) {
        r20.c();
        r20.f2232w0 = false;
        r19.k1(r18.getVisibility());
        if (r20.f2206j0 == false) goto L5;
        r19.U0(true);
        r19.k1(8);
    L5:
        r19.C0(r18);
        if ((r18 instanceof ConstraintHelper) == false) goto L10;
        ((ConstraintHelper) r18).m(r19, this.mLayoutWidget.R1());
    L10:
        if (r20.f2202h0 == false) goto L18;
        e r10 = (e) r19;
        int r11 = r20.f2224s0;
        int r12 = r20.f2226t0;
        float r13 = r20.f2228u0;
        if (r13 == (-1.0f)) goto L14;
        r10.A1(r13);
        return;
    L14:
        if (r11 == (-1)) goto L16;
        r10.y1(r11);
        return;
    L16:
        if (r12 == (-1)) goto L110;
        r10.z1(r12);
        return;
    L110:
        return;
    L18:
        int r14 = r20.f2210l0;
        int r15 = r20.f2212m0;
        int r16 = r20.f2214n0;
        int r110 = r20.f2216o0;
        int r22 = r20.f2218p0;
        int r111 = r20.f2220q0;
        float r112 = r20.f2222r0;
        int r23 = r20.f2217p;
        if (r23 == (-1)) goto L23;
        ConstraintWidget r24 = r21.get(r23);
        if (r24 == null) goto L74;
        r19.j(r24, r20.f2221r, r20.f2219q);
    L74:
        if (r17 == false) goto L81;
        int r25 = r20.X;
        if (r25 == (-1)) goto L78;
    L79:
        r19.c1(r25, r20.Y);
        goto L81
    L78:
        if (r20.Y != (-1)) goto L79;
    L81:
        if (r20.f2196e0 == false) goto L83;
        r19.Q0(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.l1(((ViewGroup.MarginLayoutParams) r20).width);
        if (((ViewGroup.MarginLayoutParams) r20).width != (-2)) goto L94;
        r19.Q0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L94:
        if (r20.f2198f0 == false) goto L96;
        r19.h1(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.M0(((ViewGroup.MarginLayoutParams) r20).height);
        if (((ViewGroup.MarginLayoutParams) r20).height != (-2)) goto L106;
        r19.h1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L106:
        r19.E0(r20.I);
        r19.S0(r20.L);
        r19.j1(r20.M);
        r19.O0(r20.N);
        r19.f1(r20.O);
        r19.m1(r20.f2194d0);
        r19.R0(r20.P, r20.R, r20.T, r20.V);
        r19.i1(r20.Q, r20.S, r20.U, r20.W);
        return;
    L96:
        if (((ViewGroup.MarginLayoutParams) r20).height == (-1)) goto L98;
        r19.h1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.M0(0);
        goto L106
    L98:
        if (r20.f2190b0 == false) goto L100;
        r19.h1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L101:
        ConstraintAnchor r26 = r19.n(ConstraintAnchor.Type.TOP);
        r26.f1427g = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        ConstraintAnchor r27 = r19.n(ConstraintAnchor.Type.BOTTOM);
        r27.f1427g = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        goto L106
    L100:
        r19.h1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L101
    L83:
        if (((ViewGroup.MarginLayoutParams) r20).width == (-1)) goto L85;
        r19.Q0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.l1(0);
        goto L94
    L85:
        if (r20.f2188a0 == false) goto L87;
        r19.Q0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L88:
        ConstraintAnchor r28 = r19.n(ConstraintAnchor.Type.LEFT);
        r28.f1427g = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
        ConstraintAnchor r29 = r19.n(ConstraintAnchor.Type.RIGHT);
        r29.f1427g = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
        goto L94
    L87:
        r19.Q0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L88
    L23:
        if (r14 == (-1)) goto L27;
        ConstraintWidget r30 = r21.get(r14);
        if (r30 == null) goto L31;
        ConstraintAnchor.Type r31 = ConstraintAnchor.Type.LEFT;
        r19.d0(r31, r30, r31, ((ViewGroup.MarginLayoutParams) r20).leftMargin, r22);
    L31:
        if (r16 == (-1)) goto L35;
        ConstraintWidget r32 = r21.get(r16);
        if (r32 == null) goto L39;
        r19.d0(ConstraintAnchor.Type.RIGHT, r32, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) r20).rightMargin, r111);
    L39:
        int r33 = r20.f2203i;
        if (r33 == (-1)) goto L44;
        ConstraintWidget r34 = r21.get(r33);
        if (r34 == null) goto L49;
        ConstraintAnchor.Type r35 = ConstraintAnchor.Type.TOP;
        r19.d0(r35, r34, r35, ((ViewGroup.MarginLayoutParams) r20).topMargin, r20.f2233x);
    L49:
        int r36 = r20.f2207k;
        if (r36 == (-1)) goto L54;
        ConstraintWidget r37 = r21.get(r36);
        if (r37 == null) goto L59;
        r19.d0(ConstraintAnchor.Type.BOTTOM, r37, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) r20).bottomMargin, r20.f2235z);
    L59:
        int r38 = r20.f2211m;
        if (r38 == (-1)) goto L62;
        e(r19, r20, r21, r38, ConstraintAnchor.Type.BASELINE);
    L69:
        if (r112 < 0.0f) goto L71;
        r19.N0(r112);
    L71:
        float r39 = r20.H;
        if (r39 < 0.0f) goto L74;
        r19.e1(r39);
        goto L74
    L62:
        int r40 = r20.f2213n;
        if (r40 == (-1)) goto L65;
        e(r19, r20, r21, r40, ConstraintAnchor.Type.TOP);
        goto L69
    L65:
        int r41 = r20.f2215o;
        if (r41 == (-1)) goto L69;
        e(r19, r20, r21, r41, ConstraintAnchor.Type.BOTTOM);
        goto L69
    L54:
        int r42 = r20.f2209l;
        if (r42 == (-1)) goto L59;
        ConstraintWidget r43 = r21.get(r42);
        if (r43 == null) goto L59;
        ConstraintAnchor.Type r44 = ConstraintAnchor.Type.BOTTOM;
        r19.d0(r44, r43, r44, ((ViewGroup.MarginLayoutParams) r20).bottomMargin, r20.f2235z);
        goto L59
    L44:
        int r45 = r20.f2205j;
        if (r45 == (-1)) goto L49;
        ConstraintWidget r46 = r21.get(r45);
        if (r46 == null) goto L49;
        r19.d0(ConstraintAnchor.Type.TOP, r46, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) r20).topMargin, r20.f2233x);
        goto L49
    L35:
        if (r110 == (-1)) goto L39;
        ConstraintWidget r47 = r21.get(r110);
        if (r47 == null) goto L39;
        ConstraintAnchor.Type r48 = ConstraintAnchor.Type.RIGHT;
        r19.d0(r48, r47, r48, ((ViewGroup.MarginLayoutParams) r20).rightMargin, r111);
        goto L39
    L27:
        if (r15 == (-1)) goto L31;
        ConstraintWidget r49 = r21.get(r15);
        if (r49 == null) goto L31;
        r19.d0(ConstraintAnchor.Type.LEFT, r49, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) r20).leftMargin, r22);
        goto L31
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r19) {
        ArrayList<ConstraintHelper> r10 = this.mConstraintHelpers;
        if (r10 == null) goto L9;
        int r11 = r10.size();
        if (r11 <= 0) goto L9;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        this.mConstraintHelpers.get(r12).p(this);
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

    public final void e(ConstraintWidget r10, LayoutParams r11, SparseArray r12, int r13, ConstraintAnchor.Type r14) {
        View r15 = this.mChildrenByIds.get(r13);
        ConstraintWidget r16 = (ConstraintWidget) r12.get(r13);
        if (r16 == null) goto L12;
        if (r15 != null) goto L6;
        return;
    L6:
        if ((r15.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r11.f2200g0 = true;
        ConstraintAnchor.Type r17 = ConstraintAnchor.Type.BASELINE;
        if (r14 != r17) goto L10;
        LayoutParams r18 = (LayoutParams) r15.getLayoutParams();
        r18.f2200g0 = true;
        r18.f2230v0.L0(true);
    L10:
        r10.n(r17).b(r16.n(r14), r11.D, r11.C, true);
        r10.L0(true);
        r10.n(ConstraintAnchor.Type.TOP).q();
        r10.n(ConstraintAnchor.Type.BOTTOM).q();
        return;
    L14:
        return;
    }

    public void fillMetrics(Metrics r10) {
        this.mMetrics = r10;
        this.mLayoutWidget.J1(r10);
    }

    @Override // android.view.View
    public void forceLayout() {
        c();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    public Object getDesignInformation(int r10, Object r11) {
        if (r10 == 0) goto L4;
        return null;
    L4:
        if ((r11 instanceof String) == false) goto L13;
        String r12 = (String) r11;
        HashMap<String, Integer> r13 = this.mDesignIds;
        if (r13 != null) goto L8;
        return null;
    L8:
        if (r13.containsKey(r12) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r12);
    L13:
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.L1();
    }

    public String getSceneString() {
        StringBuilder r10 = new StringBuilder();
        if (this.mLayoutWidget.f1460o != null) goto L9;
        int r11 = getId();
        if (r11 == (-1)) goto L7;
        this.mLayoutWidget.f1460o = getContext().getResources().getResourceEntryName(r11);
        goto L9
    L7:
        this.mLayoutWidget.f1460o = "parent";
    L9:
        if (this.mLayoutWidget.s() != null) goto L11;
        ConstraintWidgetContainer r12 = this.mLayoutWidget;
        r12.D0(r12.f1460o);
        Log.v(TAG, " setDebugName " + this.mLayoutWidget.s());
    L11:
        Iterator r13 = this.mLayoutWidget.s1().iterator();
    L13:
        if (r13.hasNext() == false) goto L24;
        ConstraintWidget r14 = (ConstraintWidget) r13.next();
        View r15 = (View) r14.r();
        if (r15 == null) goto L13;
        if (r14.f1460o != null) goto L22;
        int r16 = r15.getId();
        if (r16 == (-1)) goto L22;
        r14.f1460o = getContext().getResources().getResourceEntryName(r16);
    L22:
        if (r14.s() != null) goto L13;
        r14.D0(r14.f1460o);
        Log.v(TAG, " setDebugName " + r14.s());
        goto L13
    L24:
        this.mLayoutWidget.N(r10);
        return r10.toString();
    }

    public View getViewById(int r10) {
        return this.mChildrenByIds.get(r10);
    }

    public final ConstraintWidget getViewWidget(View r10) {
        if (r10 == this) goto L4;
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r10.setLayoutParams(generateLayoutParams(r10.getLayoutParams()));
        if ((r10.getLayoutParams() instanceof LayoutParams) == true) goto L13;
        return null;
    L13:
        return ((LayoutParams) r10.getLayoutParams()).f2230v0;
    L9:
        return ((LayoutParams) r10.getLayoutParams()).f2230v0;
    L4:
        return this.mLayoutWidget;
    }

    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & UiType.FLAG_NO_FEEDBACK) != 0) goto L5;
    L7:
        return false;
    L5:
        if (1 != getLayoutDirection()) goto L7;
        return true;
    }

    public void loadLayoutDescription(int r10) {
        if (r10 != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r10);     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        this.mConstraintLayoutSpec = null;
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
        ConstraintWidget r21 = r20.f2230v0;
        if (r19.getVisibility() != 8) goto L15;
        if (r20.f2202h0 == true) goto L15;
        if (r20.f2204i0 == true) goto L15;
        if (r20.f2208k0 == true) goto L15;
        if (r16 == true) goto L15;
    L22:
        r18 = r18 + 1;
    L15:
        if (r20.f2206j0 == true) goto L22;
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
        int r26 = this.mConstraintHelpers.size();
        if (r26 <= 0) goto L27;
    L25:
        if (r17 >= r26) goto L35;
        this.mConstraintHelpers.get(r17).n(this);
        r17 = r17 + 1;
        goto L25
    L35:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mOnMeasureWidthMeasureSpec != r10) goto L6;
        int r12 = this.mOnMeasureHeightMeasureSpec;
    L6:
        if (this.mDirtyHierarchy == true) goto L13;
        int r13 = getChildCount();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        if (getChildAt(r14).isLayoutRequested() == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        this.mDirtyHierarchy = true;
    L13:
        this.mOnMeasureWidthMeasureSpec = r10;
        this.mOnMeasureHeightMeasureSpec = r11;
        this.mLayoutWidget.a2(isRtl());
        if (this.mDirtyHierarchy == false) goto L18;
        this.mDirtyHierarchy = false;
        if (f() == false) goto L18;
        this.mLayoutWidget.c2();
    L18:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r10, r11);
        resolveMeasuredDimension(r10, r11, this.mLayoutWidget.V(), this.mLayoutWidget.w(), this.mLayoutWidget.S1(), this.mLayoutWidget.Q1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        super.onViewAdded(r10);
        ConstraintWidget r11 = getViewWidget(r10);
        if ((r10 instanceof Guideline) == false) goto L8;
        if ((r11 instanceof e) == true) goto L8;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        e r13 = new e();
        r12.f2230v0 = r13;
        r12.f2202h0 = true;
        r13.B1(r12.Z);
    L8:
        if ((r10 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r14 = (ConstraintHelper) r10;
        r14.s();
        ((LayoutParams) r10.getLayoutParams()).f2204i0 = true;
        if (this.mConstraintHelpers.contains(r14) == true) goto L12;
        this.mConstraintHelpers.add(r14);
    L12:
        this.mChildrenByIds.put(r10.getId(), r10);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        this.mChildrenByIds.remove(r10.getId());
        ConstraintWidget r11 = getViewWidget(r10);
        this.mLayoutWidget.u1(r11);
        this.mConstraintHelpers.remove(r10);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int r10) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        c();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
        Measurer r16 = this.mMeasurer;
        int r17 = r16.f2241e;
        int r18 = ViewGroup.resolveSizeAndState(r12 + r16.f2240d, r10, 0);
        int r19 = ViewGroup.resolveSizeAndState(r13 + r17, r11, 0) & 16777215;
        int r20 = this.mMaxWidth;
        int r21 = Math.min(r20, r18 & 16777215);
        int r22 = Math.min(this.mMaxHeight, r19);
        if (r14 == false) goto L5;
        r21 = r21 | 16777216;
    L5:
        if (r15 == false) goto L7;
        r22 = r22 | 16777216;
    L7:
        setMeasuredDimension(r21, r22);
        this.mLastMeasureWidth = r21;
        this.mLastMeasureHeight = r22;
    }

    public void resolveSystem(ConstraintWidgetContainer r18, int r19, int r20, int r21) {
        int r10 = View.MeasureSpec.getMode(r20);
        int r11 = View.MeasureSpec.getSize(r20);
        int r12 = View.MeasureSpec.getMode(r21);
        int r13 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r14 = Math.max(0, getPaddingBottom());
        int r15 = r16 + r14;
        int r17 = getPaddingWidth();
        this.mMeasurer.a(r20, r21, r16, r14, r17, r15);
        int r22 = Math.max(0, getPaddingStart());
        int r23 = Math.max(0, getPaddingEnd());
        if (r22 > 0) goto L8;
        if (r23 > 0) goto L8;
        r23 = Math.max(0, getPaddingLeft());
    L11:
        int r110 = r11 - r17;
        int r111 = r13 - r15;
        setSelfDimensionBehaviour(r18, r10, r110, r12, r111);
        r18.T1(r19, r10, r110, r12, r111, this.mLastMeasureWidth, this.mLastMeasureHeight, r23, r16);
        return;
    L8:
        if (isRtl() == true) goto L11;
        r23 = r22;
        goto L11
    }

    public void setConstraintSet(ConstraintSet r10) {
        this.mConstraintSet = r10;
    }

    public void setDesignInformation(int r10, Object r11, Object r12) {
        if (r10 == 0) goto L4;
        return;
    L4:
        if ((r11 instanceof String) == true) goto L6;
        return;
    L6:
        if ((r12 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r13 = (String) r11;
        int r14 = r13.indexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r14 == (-1)) goto L13;
        r13 = r13.substring(r14 + 1);
    L13:
        Integer r15 = (Integer) r12;
        r15.intValue();
        this.mDesignIds.put(r13, r15);
    }

    @Override // android.view.View
    public void setId(int r10) {
        this.mChildrenByIds.remove(getId());
        super.setId(r10);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r10) {
        if (r10 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r10;
        requestLayout();
    }

    public void setMaxWidth(int r10) {
        if (r10 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r10;
        requestLayout();
    }

    public void setMinHeight(int r10) {
        if (r10 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r10;
        requestLayout();
    }

    public void setMinWidth(int r10) {
        if (r10 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r10;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r10) {
        this.mConstraintsChangedListener = r10;
        ConstraintLayoutStates r11 = this.mConstraintLayoutSpec;
        if (r11 == null) goto L6;
        r11.c(r10);
        return;
    }

    public void setOptimizationLevel(int r10) {
        this.mOptimizationLevel = r10;
        this.mLayoutWidget.Y1(r10);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer r10, int r11, int r12, int r13, int r14) {
        Measurer r15 = this.mMeasurer;
        int r16 = r15.f2241e;
        int r17 = r15.f2240d;
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
        r10.P1();
    L31:
        r10.n1(0);
        r10.o1(0);
        r10.Y0(this.mMaxWidth - r17);
        r10.X0(this.mMaxHeight - r16);
        r10.b1(0);
        r10.a1(0);
        r10.Q0(r20);
        r10.l1(r12);
        r10.h1(r18);
        r10.M0(r14);
        r10.b1(this.mMinWidth - r17);
        r10.a1(this.mMinHeight - r16);
        return;
    L29:
        if (r14 == r10.w()) goto L31;
    L19:
        r14 = Math.min(this.mMaxHeight - r16, r14);
        goto L27
    L20:
        r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L18;
        r14 = Math.max(0, this.mMinHeight);
        goto L27
    L23:
        r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L27;
        r14 = Math.max(0, this.mMinHeight);
        goto L27
    L8:
        r12 = Math.min(this.mMaxWidth - r17, r12);
        r20 = r18;
        goto L15
    L9:
        r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L7;
        r12 = Math.max(0, this.mMinWidth);
        goto L15
    L12:
        r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L15;
        r12 = Math.max(0, this.mMinWidth);
        goto L15
    }

    public void setState(int r10, int r11, int r12) {
        ConstraintLayoutStates r13 = this.mConstraintLayoutSpec;
        if (r13 == null) goto L6;
        r13.d(r10, r11, r12);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    public ConstraintLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Channel.UNLIMITED;
        this.mMaxHeight = Channel.UNLIMITED;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(r11, 0, 0);
    }

    public ConstraintLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Channel.UNLIMITED;
        this.mMaxHeight = Channel.UNLIMITED;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(r11, r12, 0);
    }
}
