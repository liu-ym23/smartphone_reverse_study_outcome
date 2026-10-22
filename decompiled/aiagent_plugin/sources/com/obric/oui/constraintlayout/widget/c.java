package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.constraintlayout.a.c.j;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintSet.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "ConstraintSet";
    private static final int[] h = null;
    private static SparseIntArray j;
    private static SparseIntArray k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f34952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f34953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f34956e;
    private HashMap<String, com.obric.oui.constraintlayout.widget.a> f;
    private boolean g;
    private HashMap<Integer, a> i;

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f34957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f34958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f34959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C0946c f34960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f34961e;
        public final e f;
        public HashMap<String, com.obric.oui.constraintlayout.widget.a> g;
        C0945a h;

        /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConstraintSet.java */
        static class C0945a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int[] f34962a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int[] f34963b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f34964c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f34965d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            float[] f34966e;
            int f;
            int[] g;
            String[] h;
            int i;
            int[] j;
            boolean[] k;
            int l;

            C0945a() {
                this.f34962a = new int[10];
                this.f34963b = new int[10];
                this.f34964c = 0;
                this.f34965d = new int[10];
                this.f34966e = new float[10];
                this.f = 0;
                this.g = new int[5];
                this.h = new String[5];
                this.i = 0;
                this.j = new int[4];
                this.k = new boolean[4];
                this.l = 0;
            }

            void a(int r4, int r5) {
                int r0 = this.f34964c;
                int[] r1 = this.f34962a;
                if (r0 < r1.length) goto L5;
                this.f34962a = Arrays.copyOf(r1, r1.length * 2);
                int[] r2 = this.f34963b;
                this.f34963b = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.f34962a;
                int r6 = this.f34964c;
                r3[r6] = r4;
                int[] r7 = this.f34963b;
                this.f34964c = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, float r5) {
                int r0 = this.f;
                int[] r1 = this.f34965d;
                if (r0 < r1.length) goto L5;
                this.f34965d = Arrays.copyOf(r1, r1.length * 2);
                float[] r2 = this.f34966e;
                this.f34966e = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.f34965d;
                int r6 = this.f;
                r3[r6] = r4;
                float[] r7 = this.f34966e;
                this.f = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, String r5) {
                int r0 = this.i;
                int[] r1 = this.g;
                if (r0 < r1.length) goto L5;
                this.g = Arrays.copyOf(r1, r1.length * 2);
                String[] r2 = this.h;
                this.h = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), String[].class, "com.obric.aiagent.plugin");
            L5:
                int[] r3 = this.g;
                int r6 = this.i;
                r3[r6] = r4;
                String[] r7 = this.h;
                this.i = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, boolean r5) {
                int r0 = this.l;
                int[] r1 = this.j;
                if (r0 < r1.length) goto L5;
                this.j = Arrays.copyOf(r1, r1.length * 2);
                boolean[] r2 = this.k;
                this.k = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.j;
                int r6 = this.l;
                r3[r6] = r4;
                boolean[] r7 = this.k;
                this.l = r6 + 1;
                r7[r6] = r5;
            }

            void a(a r5) {
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.f34964c) goto L6;
                c.a(r5, this.f34962a[r1], this.f34963b[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                int r2 = 0;
            L8:
                if (r2 >= this.f) goto L10;
                c.a(r5, this.f34965d[r2], this.f34966e[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                int r3 = 0;
            L12:
                if (r3 >= this.i) goto L15;
                c.a(r5, this.g[r3], this.h[r3]);
                r3 = r3 + 1;
            L15:
                if (r0 >= this.l) goto L17;
                c.a(r5, this.j[r0], this.k[r0]);
                r0 = r0 + 1;
                goto L15
            }
        }

        public a() {
            this.f34959c = new d();
            this.f34960d = new C0946c();
            this.f34961e = new b();
            this.f = new e();
            this.g = new HashMap();
        }

        static /* synthetic */ void a(a r0, int r1, ConstraintLayout.LayoutParams r2) {
            r0.a(r1, r2);
        }

        static /* synthetic */ void a(a r0, int r1, Constraints.LayoutParams r2) {
            r0.a(r1, r2);
        }

        static /* synthetic */ void a(a r0, ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            r0.a(r1, r2, r3);
        }

        public /* synthetic */ Object clone() {
            return a();
        }

        public void a(a r1) {
            C0945a r0 = this.h;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        public a a() {
            a r0 = new a();
            r0.f34961e.a(this.f34961e);
            r0.f34960d.a(this.f34960d);
            r0.f34959c.a(this.f34959c);
            r0.f.a(this.f);
            r0.f34957a = this.f34957a;
            r0.h = this.h;
            return r0;
        }

        private void a(ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            a(r2, r3);
            if (ZeusTransformUtils.instanceOf(r1, Barrier.class) == false) goto L6;
            this.f34961e.aj = 1;
            Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r1, Barrier.class, "com.obric.aiagent.plugin");
            b r5 = this.f34961e;
            r5.ah = r4.getType();
            b r6 = this.f34961e;
            r6.ak = r4.getReferencedIds();
            b r0 = this.f34961e;
            r0.ai = r4.getMargin();
            return;
        }

        private void a(int r2, Constraints.LayoutParams r3) {
            a(r2, r3);
            d r4 = this.f34959c;
            r4.f34981d = r3.alpha;
            e r5 = this.f;
            r5.f34984b = r3.rotation;
            e r6 = this.f;
            r6.f34985c = r3.rotationX;
            e r7 = this.f;
            r7.f34986d = r3.rotationY;
            e r8 = this.f;
            r8.f34987e = r3.scaleX;
            e r9 = this.f;
            r9.f = r3.scaleY;
            e r10 = this.f;
            r10.g = r3.transformPivotX;
            e r11 = this.f;
            r11.h = r3.transformPivotY;
            e r12 = this.f;
            r12.j = r3.translationX;
            e r13 = this.f;
            r13.k = r3.translationY;
            e r14 = this.f;
            r14.l = r3.translationZ;
            e r15 = this.f;
            r15.n = r3.elevation;
            e r1 = this.f;
            r1.m = r3.applyElevation;
        }

        private void a(int r2, ConstraintLayout.LayoutParams r3) {
            this.f34957a = r2;
            b r4 = this.f34961e;
            r4.j = r3.leftToLeft;
            b r5 = this.f34961e;
            r5.k = r3.leftToRight;
            b r6 = this.f34961e;
            r6.l = r3.rightToLeft;
            b r7 = this.f34961e;
            r7.m = r3.rightToRight;
            b r8 = this.f34961e;
            r8.n = r3.topToTop;
            b r9 = this.f34961e;
            r9.o = r3.topToBottom;
            b r10 = this.f34961e;
            r10.p = r3.bottomToTop;
            b r11 = this.f34961e;
            r11.q = r3.bottomToBottom;
            b r12 = this.f34961e;
            r12.r = r3.baselineToBaseline;
            b r13 = this.f34961e;
            r13.s = r3.baselineToTop;
            b r14 = this.f34961e;
            r14.t = r3.baselineToBottom;
            b r15 = this.f34961e;
            r15.u = r3.startToEnd;
            b r16 = this.f34961e;
            r16.v = r3.startToStart;
            b r17 = this.f34961e;
            r17.w = r3.endToStart;
            b r18 = this.f34961e;
            r18.x = r3.endToEnd;
            b r19 = this.f34961e;
            r19.y = r3.horizontalBias;
            b r20 = this.f34961e;
            r20.z = r3.verticalBias;
            b r21 = this.f34961e;
            r21.A = r3.dimensionRatio;
            b r22 = this.f34961e;
            r22.B = r3.circleConstraint;
            b r23 = this.f34961e;
            r23.C = r3.circleRadius;
            b r24 = this.f34961e;
            r24.D = r3.circleAngle;
            b r25 = this.f34961e;
            r25.E = r3.editorAbsoluteX;
            b r26 = this.f34961e;
            r26.F = r3.editorAbsoluteY;
            b r27 = this.f34961e;
            r27.G = r3.orientation;
            b r28 = this.f34961e;
            r28.h = r3.guidePercent;
            b r29 = this.f34961e;
            r29.f = r3.guideBegin;
            b r30 = this.f34961e;
            r30.g = r3.guideEnd;
            b r31 = this.f34961e;
            r31.f34971d = r3.width;
            b r32 = this.f34961e;
            r32.f34972e = r3.height;
            b r33 = this.f34961e;
            r33.H = r3.leftMargin;
            b r34 = this.f34961e;
            r34.I = r3.rightMargin;
            b r35 = this.f34961e;
            r35.f34967J = r3.topMargin;
            b r36 = this.f34961e;
            r36.K = r3.bottomMargin;
            b r37 = this.f34961e;
            r37.N = r3.baselineMargin;
            b r38 = this.f34961e;
            r38.V = r3.verticalWeight;
            b r39 = this.f34961e;
            r39.W = r3.horizontalWeight;
            b r40 = this.f34961e;
            r40.Y = r3.verticalChainStyle;
            b r41 = this.f34961e;
            r41.X = r3.horizontalChainStyle;
            b r42 = this.f34961e;
            r42.an = r3.constrainedWidth;
            b r43 = this.f34961e;
            r43.ao = r3.constrainedHeight;
            b r44 = this.f34961e;
            r44.Z = r3.matchConstraintDefaultWidth;
            b r45 = this.f34961e;
            r45.aa = r3.matchConstraintDefaultHeight;
            b r46 = this.f34961e;
            r46.ab = r3.matchConstraintMaxWidth;
            b r47 = this.f34961e;
            r47.ac = r3.matchConstraintMaxHeight;
            b r48 = this.f34961e;
            r48.ad = r3.matchConstraintMinWidth;
            b r49 = this.f34961e;
            r49.ae = r3.matchConstraintMinHeight;
            b r50 = this.f34961e;
            r50.af = r3.matchConstraintPercentWidth;
            b r51 = this.f34961e;
            r51.ag = r3.matchConstraintPercentHeight;
            b r52 = this.f34961e;
            r52.am = r3.constraintTag;
            b r53 = this.f34961e;
            r53.P = r3.goneTopMargin;
            b r54 = this.f34961e;
            r54.R = r3.goneBottomMargin;
            b r55 = this.f34961e;
            r55.O = r3.goneLeftMargin;
            b r56 = this.f34961e;
            r56.Q = r3.goneRightMargin;
            b r57 = this.f34961e;
            r57.T = r3.goneStartMargin;
            b r58 = this.f34961e;
            r58.S = r3.goneEndMargin;
            b r59 = this.f34961e;
            r59.U = r3.goneBaselineMargin;
            b r60 = this.f34961e;
            r60.aq = r3.wrapBehaviorInParent;
            b r61 = this.f34961e;
            r61.L = r3.getMarginEnd();
            b r1 = this.f34961e;
            r1.M = r3.getMarginStart();
        }

        public void a(ConstraintLayout.LayoutParams r2) {
            r2.leftToLeft = this.f34961e.j;
            r2.leftToRight = this.f34961e.k;
            r2.rightToLeft = this.f34961e.l;
            r2.rightToRight = this.f34961e.m;
            r2.topToTop = this.f34961e.n;
            r2.topToBottom = this.f34961e.o;
            r2.bottomToTop = this.f34961e.p;
            r2.bottomToBottom = this.f34961e.q;
            r2.baselineToBaseline = this.f34961e.r;
            r2.baselineToTop = this.f34961e.s;
            r2.baselineToBottom = this.f34961e.t;
            r2.startToEnd = this.f34961e.u;
            r2.startToStart = this.f34961e.v;
            r2.endToStart = this.f34961e.w;
            r2.endToEnd = this.f34961e.x;
            r2.leftMargin = this.f34961e.H;
            r2.rightMargin = this.f34961e.I;
            r2.topMargin = this.f34961e.f34967J;
            r2.bottomMargin = this.f34961e.K;
            r2.goneStartMargin = this.f34961e.T;
            r2.goneEndMargin = this.f34961e.S;
            r2.goneTopMargin = this.f34961e.P;
            r2.goneBottomMargin = this.f34961e.R;
            r2.horizontalBias = this.f34961e.y;
            r2.verticalBias = this.f34961e.z;
            r2.circleConstraint = this.f34961e.B;
            r2.circleRadius = this.f34961e.C;
            r2.circleAngle = this.f34961e.D;
            r2.dimensionRatio = this.f34961e.A;
            r2.editorAbsoluteX = this.f34961e.E;
            r2.editorAbsoluteY = this.f34961e.F;
            r2.verticalWeight = this.f34961e.V;
            r2.horizontalWeight = this.f34961e.W;
            r2.verticalChainStyle = this.f34961e.Y;
            r2.horizontalChainStyle = this.f34961e.X;
            r2.constrainedWidth = this.f34961e.an;
            r2.constrainedHeight = this.f34961e.ao;
            r2.matchConstraintDefaultWidth = this.f34961e.Z;
            r2.matchConstraintDefaultHeight = this.f34961e.aa;
            r2.matchConstraintMaxWidth = this.f34961e.ab;
            r2.matchConstraintMaxHeight = this.f34961e.ac;
            r2.matchConstraintMinWidth = this.f34961e.ad;
            r2.matchConstraintMinHeight = this.f34961e.ae;
            r2.matchConstraintPercentWidth = this.f34961e.af;
            r2.matchConstraintPercentHeight = this.f34961e.ag;
            r2.orientation = this.f34961e.G;
            r2.guidePercent = this.f34961e.h;
            r2.guideBegin = this.f34961e.f;
            r2.guideEnd = this.f34961e.g;
            r2.width = this.f34961e.f34971d;
            r2.height = this.f34961e.f34972e;
            if (this.f34961e.am == null) goto L5;
            r2.constraintTag = this.f34961e.am;
        L5:
            r2.wrapBehaviorInParent = this.f34961e.aq;
            r2.setMarginStart(this.f34961e.M);
            r2.setMarginEnd(this.f34961e.L);
            r2.validate();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class b {
        private static SparseIntArray ar;
        public String A;
        public int B;
        public int C;
        public float D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f34967J;
        public int K;
        public int L;
        public int M;
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
        public boolean f34968a;
        public int aa;
        public int ab;
        public int ac;
        public int ad;
        public int ae;
        public float af;
        public float ag;
        public int ah;
        public int ai;
        public int aj;
        public int[] ak;
        public String al;
        public String am;
        public boolean an;
        public boolean ao;
        public boolean ap;
        public int aq;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f34969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f34971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f34972e;
        public int f;
        public int g;
        public float h;
        public boolean i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public float y;
        public float z;

        public b() {
            this.f34968a = false;
            this.f34969b = false;
            this.f34970c = false;
            this.f = -1;
            this.g = -1;
            this.h = -1.0f;
            this.i = true;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = 0.5f;
            this.z = 0.5f;
            this.A = null;
            this.B = -1;
            this.C = 0;
            this.D = 0.0f;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
            this.I = 0;
            this.f34967J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.Q = Integer.MIN_VALUE;
            this.R = Integer.MIN_VALUE;
            this.S = Integer.MIN_VALUE;
            this.T = Integer.MIN_VALUE;
            this.U = Integer.MIN_VALUE;
            this.V = -1.0f;
            this.W = -1.0f;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 1.0f;
            this.ag = 1.0f;
            this.ah = -1;
            this.ai = 0;
            this.aj = -1;
            this.an = false;
            this.ao = false;
            this.ap = true;
            this.aq = 0;
        }

        public void a(b r3) {
            this.f34968a = r3.f34968a;
            this.f34971d = r3.f34971d;
            this.f34969b = r3.f34969b;
            this.f34972e = r3.f34972e;
            this.f = r3.f;
            this.g = r3.g;
            this.h = r3.h;
            this.i = r3.i;
            this.j = r3.j;
            this.k = r3.k;
            this.l = r3.l;
            this.m = r3.m;
            this.n = r3.n;
            this.o = r3.o;
            this.p = r3.p;
            this.q = r3.q;
            this.r = r3.r;
            this.s = r3.s;
            this.t = r3.t;
            this.u = r3.u;
            this.v = r3.v;
            this.w = r3.w;
            this.x = r3.x;
            this.y = r3.y;
            this.z = r3.z;
            this.A = r3.A;
            this.B = r3.B;
            this.C = r3.C;
            this.D = r3.D;
            this.E = r3.E;
            this.F = r3.F;
            this.G = r3.G;
            this.H = r3.H;
            this.I = r3.I;
            this.f34967J = r3.f34967J;
            this.K = r3.K;
            this.L = r3.L;
            this.M = r3.M;
            this.N = r3.N;
            this.O = r3.O;
            this.P = r3.P;
            this.Q = r3.Q;
            this.R = r3.R;
            this.S = r3.S;
            this.T = r3.T;
            this.U = r3.U;
            this.V = r3.V;
            this.W = r3.W;
            this.X = r3.X;
            this.Y = r3.Y;
            this.Z = r3.Z;
            this.aa = r3.aa;
            this.ab = r3.ab;
            this.ac = r3.ac;
            this.ad = r3.ad;
            this.ae = r3.ae;
            this.af = r3.af;
            this.ag = r3.ag;
            this.ah = r3.ah;
            this.ai = r3.ai;
            this.aj = r3.aj;
            this.am = r3.am;
            int[] r0 = r3.ak;
            if (r0 != null) goto L5;
        L7:
            this.ak = null;
        L8:
            this.al = r3.al;
            this.an = r3.an;
            this.ao = r3.ao;
            this.ap = r3.ap;
            this.aq = r3.aq;
            return;
        L5:
            if (r3.al != null) goto L7;
            this.ak = Arrays.copyOf(r0, r0.length);
            goto L8
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            ar = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_toLeftOf, "styleable", "Layout_layout_constraintLeft_toLeftOf"), 24);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_toRightOf, "styleable", "Layout_layout_constraintLeft_toRightOf"), 25);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_toLeftOf, "styleable", "Layout_layout_constraintRight_toLeftOf"), 28);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_toRightOf, "styleable", "Layout_layout_constraintRight_toRightOf"), 29);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_toTopOf, "styleable", "Layout_layout_constraintTop_toTopOf"), 35);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_toBottomOf, "styleable", "Layout_layout_constraintTop_toBottomOf"), 34);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_toTopOf, "styleable", "Layout_layout_constraintBottom_toTopOf"), 4);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_toBottomOf, "styleable", "Layout_layout_constraintBottom_toBottomOf"), 3);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, "styleable", "Layout_layout_constraintBaseline_toBaselineOf"), 1);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_editor_absoluteX, "styleable", "Layout_layout_editor_absoluteX"), 6);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_editor_absoluteY, "styleable", "Layout_layout_editor_absoluteY"), 7);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_begin, "styleable", "Layout_layout_constraintGuide_begin"), 17);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_end, "styleable", "Layout_layout_constraintGuide_end"), 18);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_percent, "styleable", "Layout_layout_constraintGuide_percent"), 19);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_guidelineUseRtl, "styleable", "Layout_guidelineUseRtl"), 90);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_orientation, "styleable", "Layout_android_orientation"), 26);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintStart_toEndOf, "styleable", "Layout_layout_constraintStart_toEndOf"), 31);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintStart_toStartOf, "styleable", "Layout_layout_constraintStart_toStartOf"), 32);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintEnd_toStartOf, "styleable", "Layout_layout_constraintEnd_toStartOf"), 10);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintEnd_toEndOf, "styleable", "Layout_layout_constraintEnd_toEndOf"), 9);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginLeft, "styleable", "Layout_layout_goneMarginLeft"), 13);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginTop, "styleable", "Layout_layout_goneMarginTop"), 16);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginRight, "styleable", "Layout_layout_goneMarginRight"), 14);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginBottom, "styleable", "Layout_layout_goneMarginBottom"), 11);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginStart, "styleable", "Layout_layout_goneMarginStart"), 15);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginEnd, "styleable", "Layout_layout_goneMarginEnd"), 12);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_weight, "styleable", "Layout_layout_constraintVertical_weight"), 38);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_weight, "styleable", "Layout_layout_constraintHorizontal_weight"), 37);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_chainStyle, "styleable", "Layout_layout_constraintHorizontal_chainStyle"), 39);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_chainStyle, "styleable", "Layout_layout_constraintVertical_chainStyle"), 40);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_bias, "styleable", "Layout_layout_constraintHorizontal_bias"), 20);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_bias, "styleable", "Layout_layout_constraintVertical_bias"), 36);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintDimensionRatio, "styleable", "Layout_layout_constraintDimensionRatio"), 5);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_creator, "styleable", "Layout_layout_constraintLeft_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_creator, "styleable", "Layout_layout_constraintTop_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_creator, "styleable", "Layout_layout_constraintRight_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_creator, "styleable", "Layout_layout_constraintBottom_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBaseline_creator, "styleable", "Layout_layout_constraintBaseline_creator"), 91);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginLeft, "styleable", "Layout_android_layout_marginLeft"), 23);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginRight, "styleable", "Layout_android_layout_marginRight"), 27);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginStart, "styleable", "Layout_android_layout_marginStart"), 30);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginEnd, "styleable", "Layout_android_layout_marginEnd"), 8);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginTop, "styleable", "Layout_android_layout_marginTop"), 33);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginBottom, "styleable", "Layout_android_layout_marginBottom"), 2);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_width, "styleable", "Layout_android_layout_width"), 22);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_height, "styleable", "Layout_android_layout_height"), 21);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth, "styleable", "Layout_layout_constraintWidth"), 41);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight, "styleable", "Layout_layout_constraintHeight"), 42);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedWidth, "styleable", "Layout_layout_constrainedWidth"), 87);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedHeight, "styleable", "Layout_layout_constrainedHeight"), 88);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_wrapBehaviorInParent, "styleable", "Layout_layout_wrapBehaviorInParent"), 76);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircle, "styleable", "Layout_layout_constraintCircle"), 61);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircleRadius, "styleable", "Layout_layout_constraintCircleRadius"), 62);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircleAngle, "styleable", "Layout_layout_constraintCircleAngle"), 63);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_percent, "styleable", "Layout_layout_constraintWidth_percent"), 69);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight_percent, "styleable", "Layout_layout_constraintHeight_percent"), 70);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_chainUseRtl, "styleable", "Layout_chainUseRtl"), 71);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierDirection, "styleable", "Layout_barrierDirection"), 72);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierMargin, "styleable", "Layout_barrierMargin"), 73);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_constraint_referenced_ids, "styleable", "Layout_constraint_referenced_ids"), 74);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierAllowsGoneWidgets, "styleable", "Layout_barrierAllowsGoneWidgets"), 75);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_max, "styleable", "Layout_layout_constraintWidth_max"), 84);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_min, "styleable", "Layout_layout_constraintWidth_min"), 86);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_max, "styleable", "Layout_layout_constraintWidth_max"), 83);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight_min, "styleable", "Layout_layout_constraintHeight_min"), 85);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth, "styleable", "Layout_layout_constraintWidth"), 87);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight, "styleable", "Layout_layout_constraintHeight"), 88);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTag, "styleable", "ConstraintLayout_Layout_layout_constraintTag"), 89);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_guidelineUseRtl, "styleable", "Layout_guidelineUseRtl"), 90);
        }

        void a(Context r9, AttributeSet r10) {
            TypedArray r11 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Layout);
            this.f34969b = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L79;
            int r3 = r11.getIndex(r2);
            int r4 = ar.get(r3);
            switch(r4) {
                case 1: goto L77;
                case 2: goto L76;
                case 3: goto L75;
                case 4: goto L74;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L70;
                case 9: goto L69;
                case 10: goto L68;
                case 11: goto L67;
                case 12: goto L66;
                case 13: goto L65;
                case 14: goto L64;
                case 15: goto L63;
                case 16: goto L62;
                case 17: goto L61;
                case 18: goto L60;
                case 19: goto L59;
                case 20: goto L58;
                case 21: goto L57;
                case 22: goto L56;
                case 23: goto L55;
                case 24: goto L54;
                case 25: goto L53;
                case 26: goto L52;
                case 27: goto L51;
                case 28: goto L50;
                case 29: goto L49;
                case 30: goto L48;
                case 31: goto L47;
                case 32: goto L46;
                case 33: goto L45;
                case 34: goto L44;
                case 35: goto L43;
                case 36: goto L42;
                case 37: goto L41;
                case 38: goto L40;
                case 39: goto L39;
                case 40: goto L38;
                case 41: goto L37;
                case 42: goto L36;
                default: goto L6;
            };
        L6:
            switch(r4) {
                case 61: goto L35;
                case 62: goto L34;
                case 63: goto L33;
                default: goto L8;
            };
        L33:
            this.D = r11.getFloat(r3, this.D);
        L78:
            r2 = r2 + 1;
            goto L3
        L34:
            this.C = r11.getDimensionPixelSize(r3, this.C);
            goto L78
        L35:
            this.B = c.a(r11, r3, this.B);
            goto L78
        L8:
            switch(r4) {
                case 69: goto L32;
                case 70: goto L31;
                case 71: goto L30;
                case 72: goto L29;
                case 73: goto L28;
                case 74: goto L27;
                case 75: goto L26;
                case 76: goto L25;
                case 77: goto L24;
                case 78: goto L23;
                case 79: goto L22;
                case 80: goto L21;
                case 81: goto L20;
                case 82: goto L19;
                case 83: goto L18;
                case 84: goto L17;
                case 85: goto L16;
                case 86: goto L15;
                case 87: goto L14;
                case 88: goto L13;
                case 89: goto L12;
                case 90: goto L11;
                case 91: goto L10;
                default: goto L9;
            };
        L9:
            b(c.TAG, "Unknown attribute 0x" + Integer.toHexString(r3) + "   " + ar.get(r3));
            goto L78
        L10:
            b(c.TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + ar.get(r3));
            goto L78
        L11:
            this.i = r11.getBoolean(r3, this.i);
            goto L78
        L12:
            this.am = r11.getString(r3);
            goto L78
        L13:
            this.ao = r11.getBoolean(r3, this.ao);
            goto L78
        L14:
            this.an = r11.getBoolean(r3, this.an);
            goto L78
        L15:
            this.ad = r11.getDimensionPixelSize(r3, this.ad);
            goto L78
        L16:
            this.ae = r11.getDimensionPixelSize(r3, this.ae);
            goto L78
        L17:
            this.ab = r11.getDimensionPixelSize(r3, this.ab);
            goto L78
        L18:
            this.ac = r11.getDimensionPixelSize(r3, this.ac);
            goto L78
        L19:
            this.aa = r11.getInt(r3, this.aa);
            goto L78
        L20:
            this.Z = r11.getInt(r3, this.Z);
            goto L78
        L21:
            this.N = r11.getDimensionPixelSize(r3, this.N);
            goto L78
        L22:
            this.U = r11.getDimensionPixelSize(r3, this.U);
            goto L78
        L23:
            this.t = c.a(r11, r3, this.t);
            goto L78
        L24:
            this.s = c.a(r11, r3, this.s);
            goto L78
        L25:
            this.aq = r11.getInt(r3, this.aq);
            goto L78
        L26:
            this.ap = r11.getBoolean(r3, this.ap);
            goto L78
        L27:
            this.al = r11.getString(r3);
            goto L78
        L28:
            this.ai = r11.getDimensionPixelSize(r3, this.ai);
            goto L78
        L29:
            this.ah = r11.getInt(r3, this.ah);
            goto L78
        L30:
            a(c.TAG, "CURRENTLY UNSUPPORTED");
            goto L78
        L31:
            this.ag = r11.getFloat(r3, 1.0f);
            goto L78
        L32:
            this.af = r11.getFloat(r3, 1.0f);
            goto L78
        L36:
            c.a(this, r11, r3, 1);
            goto L78
        L37:
            c.a(this, r11, r3, 0);
            goto L78
        L38:
            this.Y = r11.getInt(r3, this.Y);
            goto L78
        L39:
            this.X = r11.getInt(r3, this.X);
            goto L78
        L40:
            this.V = r11.getFloat(r3, this.V);
            goto L78
        L41:
            this.W = r11.getFloat(r3, this.W);
            goto L78
        L42:
            this.z = r11.getFloat(r3, this.z);
            goto L78
        L43:
            this.n = c.a(r11, r3, this.n);
            goto L78
        L44:
            this.o = c.a(r11, r3, this.o);
            goto L78
        L45:
            this.f34967J = r11.getDimensionPixelSize(r3, this.f34967J);
            goto L78
        L46:
            this.v = c.a(r11, r3, this.v);
            goto L78
        L47:
            this.u = c.a(r11, r3, this.u);
            goto L78
        L48:
            this.M = r11.getDimensionPixelSize(r3, this.M);
            goto L78
        L49:
            this.m = c.a(r11, r3, this.m);
            goto L78
        L50:
            this.l = c.a(r11, r3, this.l);
            goto L78
        L51:
            this.I = r11.getDimensionPixelSize(r3, this.I);
            goto L78
        L52:
            this.G = r11.getInt(r3, this.G);
            goto L78
        L53:
            this.k = c.a(r11, r3, this.k);
            goto L78
        L54:
            this.j = c.a(r11, r3, this.j);
            goto L78
        L55:
            this.H = r11.getDimensionPixelSize(r3, this.H);
            goto L78
        L56:
            this.f34971d = r11.getLayoutDimension(r3, this.f34971d);
            goto L78
        L57:
            this.f34972e = r11.getLayoutDimension(r3, this.f34972e);
            goto L78
        L58:
            this.y = r11.getFloat(r3, this.y);
            goto L78
        L59:
            this.h = r11.getFloat(r3, this.h);
            goto L78
        L60:
            this.g = r11.getDimensionPixelOffset(r3, this.g);
            goto L78
        L61:
            this.f = r11.getDimensionPixelOffset(r3, this.f);
            goto L78
        L62:
            this.P = r11.getDimensionPixelSize(r3, this.P);
            goto L78
        L63:
            this.T = r11.getDimensionPixelSize(r3, this.T);
            goto L78
        L64:
            this.Q = r11.getDimensionPixelSize(r3, this.Q);
            goto L78
        L65:
            this.O = r11.getDimensionPixelSize(r3, this.O);
            goto L78
        L66:
            this.S = r11.getDimensionPixelSize(r3, this.S);
            goto L78
        L67:
            this.R = r11.getDimensionPixelSize(r3, this.R);
            goto L78
        L68:
            this.w = c.a(r11, r3, this.w);
            goto L78
        L69:
            this.x = c.a(r11, r3, this.x);
            goto L78
        L70:
            this.L = r11.getDimensionPixelSize(r3, this.L);
            goto L78
        L71:
            this.F = r11.getDimensionPixelOffset(r3, this.F);
            goto L78
        L72:
            this.E = r11.getDimensionPixelOffset(r3, this.E);
            goto L78
        L73:
            this.A = r11.getString(r3);
            goto L78
        L74:
            this.p = c.a(r11, r3, this.p);
            goto L78
        L75:
            this.q = c.a(r11, r3, this.q);
            goto L78
        L76:
            this.K = r11.getDimensionPixelSize(r3, this.K);
            goto L78
        L77:
            this.r = c.a(r11, r3, this.r);
            goto L78
        L79:
            r11.recycle();
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class C0946c {
        private static SparseIntArray o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f34973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f34974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f34975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f34976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f34977e;
        public int f;
        public float g;
        public int h;
        public float i;
        public float j;
        public int k;
        public String l;
        public int m;
        public int n;

        public C0946c() {
            this.f34973a = false;
            this.f34974b = -1;
            this.f34975c = 0;
            this.f34976d = null;
            this.f34977e = -1;
            this.f = 0;
            this.g = Float.NaN;
            this.h = -1;
            this.i = Float.NaN;
            this.j = Float.NaN;
            this.k = -1;
            this.l = null;
            this.m = -3;
            this.n = -1;
        }

        public void a(C0946c r2) {
            this.f34973a = r2.f34973a;
            this.f34974b = r2.f34974b;
            this.f34976d = r2.f34976d;
            this.f34977e = r2.f34977e;
            this.f = r2.f;
            this.i = r2.i;
            this.g = r2.g;
            this.h = r2.h;
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            o = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Motion_motionPathRotate, "styleable", "Motion_motionPathRotate"), 1);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_pathMotionArc, "styleable", "Motion_pathMotionArc"), 2);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_transitionEasing, "styleable", "Motion_transitionEasing"), 3);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_drawPath, "styleable", "Motion_drawPath"), 4);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_animateRelativeTo, "styleable", "Motion_animateRelativeTo"), 5);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_animateCircleAngleTo, "styleable", "Motion_animateCircleAngleTo"), 6);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_motionStagger, "styleable", "Motion_motionStagger"), 7);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionSteps, "styleable", "Motion_quantizeMotionSteps"), 8);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionPhase, "styleable", "Motion_quantizeMotionPhase"), 9);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionInterpolator, "styleable", "Motion_quantizeMotionInterpolator"), 10);
        }

        void a(Context r10, AttributeSet r11) {
            TypedArray r12 = ((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Motion);
            this.f34973a = true;
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L32;
            int r3 = r12.getIndex(r2);
            switch(o.get(r3)) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L7;
                default: goto L31;
            };
        L7:
            TypedValue r4 = r12.peekValue(r3);
            if (r4.type != 1) goto L13;
            int r5 = r12.getResourceId(r3, -1);
            this.n = r5;
            if (r5 == (-1)) goto L31;
            this.m = -2;
            goto L31
        L13:
            if (r4.type != 3) goto L18;
            String r6 = r12.getString(r3);
            this.l = r6;
            if (r6.indexOf("/") <= 0) goto L17;
            this.n = r12.getResourceId(r3, -1);
            this.m = -2;
            goto L31
        L17:
            this.m = -1;
            goto L31
        L18:
            this.m = r12.getInteger(r3, this.n);
            goto L31
        L19:
            this.j = r12.getFloat(r3, this.j);
            goto L31
        L20:
            this.k = r12.getInteger(r3, this.k);
            goto L31
        L21:
            this.g = r12.getFloat(r3, this.g);
            goto L31
        L22:
            this.f34975c = r12.getInteger(r3, this.f34975c);
            goto L31
        L23:
            this.f34974b = c.a(r12, r3, this.f34974b);
            goto L31
        L24:
            this.f = r12.getInt(r3, 0);
            goto L31
        L29:
            this.f34977e = r12.getInt(r3, this.f34977e);
            goto L31
        L30:
            this.i = r12.getFloat(r3, this.i);
            goto L31
        L26:
            if (r12.peekValue(r3).type != 3) goto L28;
            this.f34976d = r12.getString(r3);
            goto L31
        L28:
            this.f34976d = com.obric.oui.constraintlayout.a.a.a.c.f34592c[r12.getInteger(r3, 0)];
        L31:
            r2 = r2 + 1;
            goto L3
        L32:
            r12.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f34978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f34979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f34980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f34981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f34982e;

        public d() {
            this.f34978a = false;
            this.f34979b = 0;
            this.f34980c = 0;
            this.f34981d = 1.0f;
            this.f34982e = Float.NaN;
        }

        public void a(d r2) {
            this.f34978a = r2.f34978a;
            this.f34979b = r2.f34979b;
            this.f34981d = r2.f34981d;
            this.f34982e = r2.f34982e;
            this.f34980c = r2.f34980c;
        }

        void a(Context r6, AttributeSet r7) {
            TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.PropertySet);
            this.f34978a = true;
            int r9 = r8.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L17;
            int r1 = r8.getIndex(r0);
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_alpha, "styleable", "PropertySet_android_alpha")) goto L8;
            this.f34981d = r8.getFloat(r1, this.f34981d);
        L16:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_visibility, "styleable", "PropertySet_android_visibility")) goto L11;
            this.f34979b = r8.getInt(r1, this.f34979b);
            this.f34979b = c.c()[this.f34979b];
            goto L16
        L11:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_visibilityMode, "styleable", "PropertySet_visibilityMode")) goto L14;
            this.f34980c = r8.getInt(r1, this.f34980c);
            goto L16
        L14:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_motionProgress, "styleable", "PropertySet_motionProgress")) goto L16;
            this.f34982e = r8.getFloat(r1, this.f34982e);
            goto L16
        L17:
            r8.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class e {
        private static SparseIntArray o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f34983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f34984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f34985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f34986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f34987e;
        public float f;
        public float g;
        public float h;
        public int i;
        public float j;
        public float k;
        public float l;
        public boolean m;
        public float n;

        public e() {
            this.f34983a = false;
            this.f34984b = 0.0f;
            this.f34985c = 0.0f;
            this.f34986d = 0.0f;
            this.f34987e = 1.0f;
            this.f = 1.0f;
            this.g = Float.NaN;
            this.h = Float.NaN;
            this.i = -1;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = false;
            this.n = 0.0f;
        }

        public void a(e r2) {
            this.f34983a = r2.f34983a;
            this.f34984b = r2.f34984b;
            this.f34985c = r2.f34985c;
            this.f34986d = r2.f34986d;
            this.f34987e = r2.f34987e;
            this.f = r2.f;
            this.g = r2.g;
            this.h = r2.h;
            this.i = r2.i;
            this.j = r2.j;
            this.k = r2.k;
            this.l = r2.l;
            this.m = r2.m;
            this.n = r2.n;
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            o = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotation, "styleable", "Transform_android_rotation"), 1);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotationX, "styleable", "Transform_android_rotationX"), 2);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotationY, "styleable", "Transform_android_rotationY"), 3);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_scaleX, "styleable", "Transform_android_scaleX"), 4);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_scaleY, "styleable", "Transform_android_scaleY"), 5);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_transformPivotX, "styleable", "Transform_android_transformPivotX"), 6);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_transformPivotY, "styleable", "Transform_android_transformPivotY"), 7);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationX, "styleable", "Transform_android_translationX"), 8);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationY, "styleable", "Transform_android_translationY"), 9);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationZ, "styleable", "Transform_android_translationZ"), 10);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_elevation, "styleable", "Transform_android_elevation"), 11);
            o.append(ZeusTransformUtils.mapRes(R.styleable.Transform_transformPivotTarget, "styleable", "Transform_transformPivotTarget"), 12);
        }

        void a(Context r5, AttributeSet r6) {
            TypedArray r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Transform);
            this.f34983a = true;
            int r0 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L20;
            int r2 = r7.getIndex(r1);
            switch(o.get(r2)) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L19;
            };
        L7:
            this.i = c.a(r7, r2, this.i);
            goto L19
        L8:
            this.m = true;
            this.n = r7.getDimension(r2, this.n);
            goto L19
        L9:
            this.l = r7.getDimension(r2, this.l);
            goto L19
        L10:
            this.k = r7.getDimension(r2, this.k);
            goto L19
        L11:
            this.j = r7.getDimension(r2, this.j);
            goto L19
        L12:
            this.h = r7.getDimension(r2, this.h);
            goto L19
        L13:
            this.g = r7.getDimension(r2, this.g);
            goto L19
        L14:
            this.f = r7.getFloat(r2, this.f);
            goto L19
        L15:
            this.f34987e = r7.getFloat(r2, this.f34987e);
            goto L19
        L16:
            this.f34986d = r7.getFloat(r2, this.f34986d);
            goto L19
        L17:
            this.f34985c = r7.getFloat(r2, this.f34985c);
            goto L19
        L18:
            this.f34984b = r7.getFloat(r2, this.f34984b);
        L19:
            r1 = r1 + 1;
            goto L3
        L20:
            r7.recycle();
        }
    }

    public c() {
        this.f34953b = "";
        this.f34956e = new String[0];
        this.f34954c = 0;
        this.f = new HashMap();
        this.g = true;
        this.i = new HashMap();
    }

    static /* synthetic */ int a(TypedArray r0, int r1, int r2) {
        return b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, float r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, int r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, String r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ void a(a r0, int r1, boolean r2) {
        b(r0, r1, r2);
    }

    static /* synthetic */ int[] c() {
        return h;
    }

    static {
        h = new int[]{0, 4, 8};
        j = new SparseIntArray();
        k = new SparseIntArray();
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toLeftOf, "styleable", "Constraint_layout_constraintLeft_toLeftOf"), 25);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toRightOf, "styleable", "Constraint_layout_constraintLeft_toRightOf"), 26);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toLeftOf, "styleable", "Constraint_layout_constraintRight_toLeftOf"), 29);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toRightOf, "styleable", "Constraint_layout_constraintRight_toRightOf"), 30);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toTopOf, "styleable", "Constraint_layout_constraintTop_toTopOf"), 36);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toBottomOf, "styleable", "Constraint_layout_constraintTop_toBottomOf"), 35);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toTopOf, "styleable", "Constraint_layout_constraintBottom_toTopOf"), 4);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toBottomOf, "styleable", "Constraint_layout_constraintBottom_toBottomOf"), 3);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, "styleable", "Constraint_layout_constraintBaseline_toBaselineOf"), 1);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toTopOf, "styleable", "Constraint_layout_constraintBaseline_toTopOf"), 91);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, "styleable", "Constraint_layout_constraintBaseline_toBottomOf"), 92);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteX, "styleable", "Constraint_layout_editor_absoluteX"), 6);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteY, "styleable", "Constraint_layout_editor_absoluteY"), 7);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_begin, "styleable", "Constraint_layout_constraintGuide_begin"), 17);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_end, "styleable", "Constraint_layout_constraintGuide_end"), 18);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_percent, "styleable", "Constraint_layout_constraintGuide_percent"), 19);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_guidelineUseRtl, "styleable", "Constraint_guidelineUseRtl"), 99);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_orientation, "styleable", "Constraint_android_orientation"), 27);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toEndOf, "styleable", "Constraint_layout_constraintStart_toEndOf"), 32);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toStartOf, "styleable", "Constraint_layout_constraintStart_toStartOf"), 33);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toStartOf, "styleable", "Constraint_layout_constraintEnd_toStartOf"), 10);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toEndOf, "styleable", "Constraint_layout_constraintEnd_toEndOf"), 9);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginLeft, "styleable", "Constraint_layout_goneMarginLeft"), 13);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginTop, "styleable", "Constraint_layout_goneMarginTop"), 16);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginRight, "styleable", "Constraint_layout_goneMarginRight"), 14);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginBottom, "styleable", "Constraint_layout_goneMarginBottom"), 11);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginStart, "styleable", "Constraint_layout_goneMarginStart"), 15);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginEnd, "styleable", "Constraint_layout_goneMarginEnd"), 12);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_weight, "styleable", "Constraint_layout_constraintVertical_weight"), 40);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_weight, "styleable", "Constraint_layout_constraintHorizontal_weight"), 39);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, "styleable", "Constraint_layout_constraintHorizontal_chainStyle"), 41);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_chainStyle, "styleable", "Constraint_layout_constraintVertical_chainStyle"), 42);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_bias, "styleable", "Constraint_layout_constraintHorizontal_bias"), 20);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_bias, "styleable", "Constraint_layout_constraintVertical_bias"), 37);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintDimensionRatio, "styleable", "Constraint_layout_constraintDimensionRatio"), 5);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_creator, "styleable", "Constraint_layout_constraintLeft_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_creator, "styleable", "Constraint_layout_constraintTop_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_creator, "styleable", "Constraint_layout_constraintRight_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_creator, "styleable", "Constraint_layout_constraintBottom_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_creator, "styleable", "Constraint_layout_constraintBaseline_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginLeft, "styleable", "Constraint_android_layout_marginLeft"), 24);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginRight, "styleable", "Constraint_android_layout_marginRight"), 28);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart"), 31);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd"), 8);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginTop, "styleable", "Constraint_android_layout_marginTop"), 34);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginBottom, "styleable", "Constraint_android_layout_marginBottom"), 2);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_width, "styleable", "Constraint_android_layout_width"), 23);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_height, "styleable", "Constraint_android_layout_height"), 21);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth, "styleable", "Constraint_layout_constraintWidth"), 95);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight, "styleable", "Constraint_layout_constraintHeight"), 96);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_visibility, "styleable", "Constraint_android_visibility"), 22);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_alpha, "styleable", "Constraint_android_alpha"), 43);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_elevation, "styleable", "Constraint_android_elevation"), 44);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationX, "styleable", "Constraint_android_rotationX"), 45);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationY, "styleable", "Constraint_android_rotationY"), 46);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotation, "styleable", "Constraint_android_rotation"), 60);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleX, "styleable", "Constraint_android_scaleX"), 47);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleY, "styleable", "Constraint_android_scaleY"), 48);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotX, "styleable", "Constraint_android_transformPivotX"), 49);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotY, "styleable", "Constraint_android_transformPivotY"), 50);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationX, "styleable", "Constraint_android_translationX"), 51);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationY, "styleable", "Constraint_android_translationY"), 52);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationZ, "styleable", "Constraint_android_translationZ"), 53);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_default, "styleable", "Constraint_layout_constraintWidth_default"), 54);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_default, "styleable", "Constraint_layout_constraintHeight_default"), 55);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_max, "styleable", "Constraint_layout_constraintWidth_max"), 56);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_max, "styleable", "Constraint_layout_constraintHeight_max"), 57);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_min, "styleable", "Constraint_layout_constraintWidth_min"), 58);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_min, "styleable", "Constraint_layout_constraintHeight_min"), 59);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircle, "styleable", "Constraint_layout_constraintCircle"), 61);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleRadius, "styleable", "Constraint_layout_constraintCircleRadius"), 62);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleAngle, "styleable", "Constraint_layout_constraintCircleAngle"), 63);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_animateRelativeTo, "styleable", "Constraint_animateRelativeTo"), 64);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionEasing, "styleable", "Constraint_transitionEasing"), 65);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_drawPath, "styleable", "Constraint_drawPath"), 66);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionPathRotate, "styleable", "Constraint_transitionPathRotate"), 67);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionStagger, "styleable", "Constraint_motionStagger"), 79);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id"), 38);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionProgress, "styleable", "Constraint_motionProgress"), 68);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_percent, "styleable", "Constraint_layout_constraintWidth_percent"), 69);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_percent, "styleable", "Constraint_layout_constraintHeight_percent"), 70);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_wrapBehaviorInParent, "styleable", "Constraint_layout_wrapBehaviorInParent"), 97);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_chainUseRtl, "styleable", "Constraint_chainUseRtl"), 71);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierDirection, "styleable", "Constraint_barrierDirection"), 72);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierMargin, "styleable", "Constraint_barrierMargin"), 73);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_constraint_referenced_ids, "styleable", "Constraint_constraint_referenced_ids"), 74);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierAllowsGoneWidgets, "styleable", "Constraint_barrierAllowsGoneWidgets"), 75);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_pathMotionArc, "styleable", "Constraint_pathMotionArc"), 76);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTag, "styleable", "Constraint_layout_constraintTag"), 77);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_visibilityMode, "styleable", "Constraint_visibilityMode"), 78);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedWidth, "styleable", "Constraint_layout_constrainedWidth"), 80);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedHeight, "styleable", "Constraint_layout_constrainedHeight"), 81);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_polarRelativeTo, "styleable", "Constraint_polarRelativeTo"), 82);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transformPivotTarget, "styleable", "Constraint_transformPivotTarget"), 83);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionSteps, "styleable", "Constraint_quantizeMotionSteps"), 84);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionPhase, "styleable", "Constraint_quantizeMotionPhase"), 85);
        j.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionInterpolator, "styleable", "Constraint_quantizeMotionInterpolator"), 86);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 6);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 7);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_orientation, "styleable", "ConstraintOverride_android_orientation"), 27);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginLeft, "styleable", "ConstraintOverride_layout_goneMarginLeft"), 13);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginTop, "styleable", "ConstraintOverride_layout_goneMarginTop"), 16);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginRight, "styleable", "ConstraintOverride_layout_goneMarginRight"), 14);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginBottom, "styleable", "ConstraintOverride_layout_goneMarginBottom"), 11);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginStart, "styleable", "ConstraintOverride_layout_goneMarginStart"), 15);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginEnd, "styleable", "ConstraintOverride_layout_goneMarginEnd"), 12);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_weight, "styleable", "ConstraintOverride_layout_constraintVertical_weight"), 40);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, "styleable", "ConstraintOverride_layout_constraintHorizontal_weight"), 39);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintOverride_layout_constraintHorizontal_chainStyle"), 41);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, "styleable", "ConstraintOverride_layout_constraintVertical_chainStyle"), 42);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, "styleable", "ConstraintOverride_layout_constraintHorizontal_bias"), 20);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_bias, "styleable", "ConstraintOverride_layout_constraintVertical_bias"), 37);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, "styleable", "ConstraintOverride_layout_constraintDimensionRatio"), 5);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintLeft_creator, "styleable", "ConstraintOverride_layout_constraintLeft_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTop_creator, "styleable", "ConstraintOverride_layout_constraintTop_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintRight_creator, "styleable", "ConstraintOverride_layout_constraintRight_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBottom_creator, "styleable", "ConstraintOverride_layout_constraintBottom_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, "styleable", "ConstraintOverride_layout_constraintBaseline_creator"), 87);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginLeft, "styleable", "ConstraintOverride_android_layout_marginLeft"), 24);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginRight, "styleable", "ConstraintOverride_android_layout_marginRight"), 28);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginStart, "styleable", "ConstraintOverride_android_layout_marginStart"), 31);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginEnd, "styleable", "ConstraintOverride_android_layout_marginEnd"), 8);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginTop, "styleable", "ConstraintOverride_android_layout_marginTop"), 34);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginBottom, "styleable", "ConstraintOverride_android_layout_marginBottom"), 2);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_width, "styleable", "ConstraintOverride_android_layout_width"), 23);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_height, "styleable", "ConstraintOverride_android_layout_height"), 21);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth, "styleable", "ConstraintOverride_layout_constraintWidth"), 95);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight, "styleable", "ConstraintOverride_layout_constraintHeight"), 96);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_visibility, "styleable", "ConstraintOverride_android_visibility"), 22);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_alpha, "styleable", "ConstraintOverride_android_alpha"), 43);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_elevation, "styleable", "ConstraintOverride_android_elevation"), 44);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationX, "styleable", "ConstraintOverride_android_rotationX"), 45);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationY, "styleable", "ConstraintOverride_android_rotationY"), 46);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotation, "styleable", "ConstraintOverride_android_rotation"), 60);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleX, "styleable", "ConstraintOverride_android_scaleX"), 47);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleY, "styleable", "ConstraintOverride_android_scaleY"), 48);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotX, "styleable", "ConstraintOverride_android_transformPivotX"), 49);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotY, "styleable", "ConstraintOverride_android_transformPivotY"), 50);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationX, "styleable", "ConstraintOverride_android_translationX"), 51);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationY, "styleable", "ConstraintOverride_android_translationY"), 52);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationZ, "styleable", "ConstraintOverride_android_translationZ"), 53);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_default, "styleable", "ConstraintOverride_layout_constraintWidth_default"), 54);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_default, "styleable", "ConstraintOverride_layout_constraintHeight_default"), 55);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_max, "styleable", "ConstraintOverride_layout_constraintWidth_max"), 56);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_max, "styleable", "ConstraintOverride_layout_constraintHeight_max"), 57);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_min, "styleable", "ConstraintOverride_layout_constraintWidth_min"), 58);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_min, "styleable", "ConstraintOverride_layout_constraintHeight_min"), 59);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleRadius, "styleable", "ConstraintOverride_layout_constraintCircleRadius"), 62);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleAngle, "styleable", "ConstraintOverride_layout_constraintCircleAngle"), 63);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_animateRelativeTo, "styleable", "ConstraintOverride_animateRelativeTo"), 64);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionEasing, "styleable", "ConstraintOverride_transitionEasing"), 65);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_drawPath, "styleable", "ConstraintOverride_drawPath"), 66);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionPathRotate, "styleable", "ConstraintOverride_transitionPathRotate"), 67);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionStagger, "styleable", "ConstraintOverride_motionStagger"), 79);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_id, "styleable", "ConstraintOverride_android_id"), 38);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionTarget, "styleable", "ConstraintOverride_motionTarget"), 98);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionProgress, "styleable", "ConstraintOverride_motionProgress"), 68);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_percent, "styleable", "ConstraintOverride_layout_constraintWidth_percent"), 69);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_percent, "styleable", "ConstraintOverride_layout_constraintHeight_percent"), 70);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_chainUseRtl, "styleable", "ConstraintOverride_chainUseRtl"), 71);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierDirection, "styleable", "ConstraintOverride_barrierDirection"), 72);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierMargin, "styleable", "ConstraintOverride_barrierMargin"), 73);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_constraint_referenced_ids, "styleable", "ConstraintOverride_constraint_referenced_ids"), 74);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, "styleable", "ConstraintOverride_barrierAllowsGoneWidgets"), 75);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_pathMotionArc, "styleable", "ConstraintOverride_pathMotionArc"), 76);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTag, "styleable", "ConstraintOverride_layout_constraintTag"), 77);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_visibilityMode, "styleable", "ConstraintOverride_visibilityMode"), 78);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedWidth, "styleable", "ConstraintOverride_layout_constrainedWidth"), 80);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedHeight, "styleable", "ConstraintOverride_layout_constrainedHeight"), 81);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_polarRelativeTo, "styleable", "ConstraintOverride_polarRelativeTo"), 82);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transformPivotTarget, "styleable", "ConstraintOverride_transformPivotTarget"), 83);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionSteps, "styleable", "ConstraintOverride_quantizeMotionSteps"), 84);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionPhase, "styleable", "ConstraintOverride_quantizeMotionPhase"), 85);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionInterpolator, "styleable", "ConstraintOverride_quantizeMotionInterpolator"), 86);
        k.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, "styleable", "ConstraintOverride_layout_wrapBehaviorInParent"), 97);
    }

    public a a(int r1) {
        return g(r1);
    }

    public void a(c r10) {
        Iterator<Integer> r0 = r10.i.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.aiagent.plugin");
        int r2 = r1.intValue();
        a r3 = (a) ZeusTransformUtils.preCheckCast(r10.i.get(r1), a.class, "com.obric.aiagent.plugin");
        if (this.i.containsKey(Integer.valueOf(r2)) == true) goto L8;
        this.i.put(Integer.valueOf(r2), new a());
    L8:
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r2)), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        if (r4.f34961e.f34969b == true) goto L15;
        r4.f34961e.a(r3.f34961e);
    L15:
        if (r4.f34959c.f34978a == true) goto L18;
        r4.f34959c.a(r3.f34959c);
    L18:
        if (r4.f.f34983a == true) goto L21;
        r4.f.a(r3.f);
    L21:
        if (r4.f34960d.f34973a == true) goto L23;
        r4.f34960d.a(r3.f34960d);
    L23:
        Iterator<String> r5 = r3.g.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L4;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r4.g.containsKey(r6) == true) goto L25;
        r4.g.put(r6, (com.obric.oui.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r3.g.get(r6), com.obric.oui.constraintlayout.widget.a.class, "com.obric.aiagent.plugin"));
        goto L25
    }

    public void a(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L39;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getId();
        if (this.g == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.i.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L38;
        if (r6.f34961e.f34969b == true) goto L26;
        a.a(r6, r4, r3);
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L24;
        r6.f34961e.ak = ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.aiagent.plugin")).getReferencedIds();
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L24;
        Barrier r5 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.aiagent.plugin");
        r6.f34961e.ap = r5.getAllowsGoneWidget();
        r6.f34961e.ah = r5.getType();
        r6.f34961e.ai = r5.getMargin();
    L24:
        r6.f34961e.f34969b = true;
    L26:
        if (r6.f34959c.f34978a == true) goto L29;
        r6.f34959c.f34979b = r2.getVisibility();
        r6.f34959c.f34981d = r2.getAlpha();
        r6.f34959c.f34978a = true;
    L29:
        if (r6.f.f34983a == true) goto L38;
        r6.f.f34983a = true;
        r6.f.f34984b = r2.getRotation();
        r6.f.f34985c = r2.getRotationX();
        r6.f.f34986d = r2.getRotationY();
        r6.f.f34987e = r2.getScaleX();
        r6.f.f = r2.getScaleY();
        float r7 = r2.getPivotX();
        float r8 = r2.getPivotY();
        if (r7 == 0.0d) goto L33;
    L34:
        r6.f.g = r7;
        r6.f.h = r8;
    L35:
        r6.f.j = r2.getTranslationX();
        r6.f.k = r2.getTranslationY();
        r6.f.l = r2.getTranslationZ();
        if (r6.f.m == false) goto L38;
        r6.f.n = r2.getElevation();
        goto L38
    L33:
        if (r8 == 0.0d) goto L35;
    L38:
        r1 = r1 + 1;
        goto L3
    }

    public void b(c r7) {
        Iterator<a> r8 = r7.i.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L20;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.aiagent.plugin");
        if (r0.h == null) goto L4;
        if (r0.f34958b == null) goto L10;
        Iterator<Integer> r1 = this.i.keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L4;
        a r3 = f(((Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        if (r3.f34961e.am == null) goto L13;
        if (r0.f34958b.matches(r3.f34961e.am) == false) goto L13;
        r0.h.a(r3);
        HashMap r4 = (HashMap) ZeusTransformUtils.preCheckCast(r0.g.clone(), HashMap.class, "com.obric.aiagent.plugin");
        r3.g.putAll(r4);
        goto L13
    L10:
        a r2 = f(r0.f34957a);
        r0.h.a(r2);
        goto L4
    }

    static void a(Object r4, TypedArray r5, int r6, int r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r5.peekValue(r6).type;
        if (r0 == 3) goto L38;
        int r2 = -2;
        boolean r3 = false;
        if (r0 == 5) goto L18;
        int r8 = r5.getInt(r6, 0);
        if (r8 != (-4)) goto L11;
        r3 = true;
    L20:
        if (ZeusTransformUtils.instanceOf(r4, ConstraintLayout.LayoutParams.class) == false) goto L26;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r7 != 0) goto L24;
        r9.width = r2;
        r9.constrainedWidth = r3;
        return;
    L24:
        r9.height = r2;
        r9.constrainedHeight = r3;
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L32;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
        if (r7 != 0) goto L30;
        r10.f34971d = r2;
        r10.an = r3;
        return;
    L30:
        r10.f34972e = r2;
        r10.ao = r3;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r4, a.C0945a.class) == false) goto L44;
        a.C0945a r11 = (a.C0945a) ZeusTransformUtils.preCheckCast(r4, a.C0945a.class, "com.obric.aiagent.plugin");
        if (r7 != 0) goto L36;
        r11.a(23, r2);
        r11.a(80, r3);
        return;
    L36:
        r11.a(21, r2);
        r11.a(81, r3);
        return;
    L44:
        return;
    L11:
        if (r8 == (-3)) goto L15;
        if (r8 != (-2)) goto L14;
    L16:
        r2 = r8;
        goto L20
    L14:
        if (r8 == (-1)) goto L16;
    L15:
        r2 = 0;
        goto L20
    L18:
        r2 = r5.getDimensionPixelSize(r6, 0);
        goto L20
    L38:
        a(r4, r5.getString(r6), r7);
    }

    static void a(ConstraintLayout.LayoutParams r8, String r9) {
        float r0 = Float.NaN;
        int r1 = -1;
        if (r9 == null) goto L34;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L7;
    L15:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L18;
    L31:
        String r6 = r9.substring(r4);
        if (r6.length() <= 0) goto L34;
        r0 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r5 >= (r2 - 1)) goto L31;
        String r7 = r9.substring(r4, r5);
        String r10 = r9.substring(r5 + 1);
        if (r7.length() <= 0) goto L34;
        if (r10.length() <= 0) goto L34;
        float r11 = Float.parseFloat(r7);     // Catch: NumberFormatException -> L36
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L36
        if (r11 <= 0.0f) goto L37;
        if (r12 <= 0.0f) goto L37;
        if (r1 != 1) goto L29;
        r0 = Math.abs(r12 / r11);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r0 = Math.abs(r11 / r12);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r3 >= (r2 - 1)) goto L15;
        String r13 = r9.substring(0, r3);
        if (r13.equalsIgnoreCase("W") == false) goto L12;
        r1 = 0;
    L14:
        r4 = r3 + 1;
        goto L15
    L12:
        if (r13.equalsIgnoreCase("H") == false) goto L14;
        r1 = 1;
    L34:
        r8.dimensionRatio = r9;
        r8.mDimensionRatioValue = r0;
        r8.mDimensionRatioSide = r1;
    }

    static void a(Object r6, String r7, int r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.indexOf(61);
        int r1 = r7.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r0 >= (r1 - 1)) goto L73;
        String r2 = r7.substring(0, r0);
        String r9 = r7.substring(r0 + 1);
        if (r9.length() <= 0) goto L74;
        String r3 = r2.trim();
        String r10 = r9.trim();
        if ("ratio".equalsIgnoreCase(r3) == false) goto L70;
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L20;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r8 != 0) goto L17;
        r11.width = 0;
    L18:
        a(r11, r10);
        return;
    L17:
        r11.height = 0;
        goto L18
    L20:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L23;
        ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).A = r10;
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r6, a.C0945a.class) == false) goto L77;
        ((a.C0945a) ZeusTransformUtils.preCheckCast(r6, a.C0945a.class, "com.obric.aiagent.plugin")).a(5, r10);
        return;
    L77:
        return;
    L70:
        if ("weight".equalsIgnoreCase(r3) == false) goto L47;
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L68
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L34;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
        if (r8 != 0) goto L32;
        r13.width = 0;     // Catch: NumberFormatException -> L68
        r13.horizontalWeight = r12;     // Catch: NumberFormatException -> L68
    L69:
        return;
    L32:
        r13.height = 0;     // Catch: NumberFormatException -> L68
        r13.verticalWeight = r12;     // Catch: NumberFormatException -> L68
        goto L69
    L34:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L40;
        b r14 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
        if (r8 != 0) goto L38;
        r14.f34971d = 0;     // Catch: NumberFormatException -> L68
        r14.W = r12;     // Catch: NumberFormatException -> L68
        goto L69
    L38:
        r14.f34972e = 0;     // Catch: NumberFormatException -> L68
        r14.V = r12;     // Catch: NumberFormatException -> L68
        goto L69
    L40:
        if (ZeusTransformUtils.instanceOf(r6, a.C0945a.class) == false) goto L69;
        a.C0945a r15 = (a.C0945a) ZeusTransformUtils.preCheckCast(r6, a.C0945a.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
        if (r8 != 0) goto L44;
        r15.a(23, 0);     // Catch: NumberFormatException -> L68
        r15.a(39, r12);     // Catch: NumberFormatException -> L68
        goto L69
    L44:
        r15.a(21, 0);     // Catch: NumberFormatException -> L68
        r15.a(40, r12);     // Catch: NumberFormatException -> L68
        goto L69
    L47:
        if ("parent".equalsIgnoreCase(r3) == true) goto L49;
        return;
    L49:
        float r16 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r10)));     // Catch: NumberFormatException -> L68
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L56;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
        if (r8 != 0) goto L54;
        r17.width = 0;     // Catch: NumberFormatException -> L68
        r17.matchConstraintPercentWidth = r16;     // Catch: NumberFormatException -> L68
        r17.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L68
        goto L69
    L54:
        r17.height = 0;     // Catch: NumberFormatException -> L68
        r17.matchConstraintPercentHeight = r16;     // Catch: NumberFormatException -> L68
        r17.matchConstraintDefaultHeight = 2;     // Catch: NumberFormatException -> L68
        goto L69
    L56:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L62;
        b r18 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
        if (r8 != 0) goto L60;
        r18.f34971d = 0;     // Catch: NumberFormatException -> L68
        r18.af = r16;     // Catch: NumberFormatException -> L68
        r18.Z = 2;     // Catch: NumberFormatException -> L68
        goto L69
    L60:
        r18.f34972e = 0;     // Catch: NumberFormatException -> L68
        r18.ag = r16;     // Catch: NumberFormatException -> L68
        r18.aa = 2;     // Catch: NumberFormatException -> L68
        goto L69
    L62:
        if (ZeusTransformUtils.instanceOf(r6, a.C0945a.class) == false) goto L69;
        a.C0945a r19 = (a.C0945a) ZeusTransformUtils.preCheckCast(r6, a.C0945a.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
        if (r8 != 0) goto L66;
        r19.a(23, 0);     // Catch: NumberFormatException -> L68
        r19.a(54, 2);     // Catch: NumberFormatException -> L68
        goto L69
    L66:
        r19.a(21, 0);     // Catch: NumberFormatException -> L68
        r19.a(55, 2);     // Catch: NumberFormatException -> L68
    L80:
        return;
    L74:
        return;
    }

    public String[] a() {
        String[] r2 = this.f34956e;
        return (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), String[].class, "com.obric.aiagent.plugin");
    }

    public void a(String r3) {
        this.f34956e = r3.split(",");
        int r4 = 0;
    L3:
        String[] r0 = this.f34956e;
        if (r4 >= r0.length) goto L6;
        r0[r4] = r0[r4].trim();
        r4 = r4 + 1;
        goto L3
    }

    public boolean a(String... r10) {
        int r0 = r10.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L15;
        String r4 = r10[r2];
        String[] r5 = this.f34956e;
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L11;
        if (r5[r7].equals(r4) == true) goto L12;
        r7 = r7 + 1;
    L12:
        if (r3 == false) goto L13;
        r2 = r2 + 1;
        goto L3
    L13:
        return false;
    L11:
        r3 = false;
        goto L12
    L15:
        return true;
    }

    public void a(Context r3, int r4) {
        b((ConstraintLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")), r4, null, "com.obric.aiagent.plugin"), ConstraintLayout.class, "com.obric.aiagent.plugin"));
    }

    public void c(c r6) {
        this.i.clear();
        Iterator<Integer> r0 = r6.i.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.aiagent.plugin");
        a r2 = (a) ZeusTransformUtils.preCheckCast(r6.i.get(r1), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L4;
        this.i.put(r1, r2.a());
        goto L4
    }

    public void b(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        this.i.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L29;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getId();
        if (this.g == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.i.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L28;
        r6.g = com.obric.oui.constraintlayout.widget.a.a(this.f, r2);
        a.a(r6, r4, r3);
        r6.f34959c.f34979b = r2.getVisibility();
        r6.f34959c.f34981d = r2.getAlpha();
        r6.f.f34984b = r2.getRotation();
        r6.f.f34985c = r2.getRotationX();
        r6.f.f34986d = r2.getRotationY();
        r6.f.f34987e = r2.getScaleX();
        r6.f.f = r2.getScaleY();
        float r5 = r2.getPivotX();
        float r7 = r2.getPivotY();
        if (r5 == 0.0d) goto L20;
    L21:
        r6.f.g = r5;
        r6.f.h = r7;
    L22:
        r6.f.j = r2.getTranslationX();
        r6.f.k = r2.getTranslationY();
        r6.f.l = r2.getTranslationZ();
        if (r6.f.m == false) goto L26;
        r6.f.n = r2.getElevation();
    L26:
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L28;
        Barrier r8 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.aiagent.plugin");
        r6.f34961e.ap = r8.getAllowsGoneWidget();
        r6.f34961e.ak = r8.getReferencedIds();
        r6.f34961e.ah = r8.getType();
        r6.f34961e.ai = r8.getMargin();
        goto L28
    L20:
        if (r7 == 0.0d) goto L22;
    L28:
        r1 = r1 + 1;
        goto L3
    }

    public void a(Constraints r10) {
        int r0 = r10.getChildCount();
        this.i.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L22;
        View r2 = r10.getChildAt(r1);
        Constraints.LayoutParams r3 = (Constraints.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), Constraints.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getId();
        if (this.g == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.i.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L20;
        a.a(r6, (ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.aiagent.plugin"), r4, r3);
    L20:
        a.a(r6, r4, r3);
    L21:
        r1 = r1 + 1;
        goto L3
    }

    public void c(ConstraintLayout r2) {
        a(r2, true);
        r2.setConstraintSet(null);
        r2.requestLayout();
    }

    public void d(ConstraintLayout r7) {
        int r0 = r7.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        View r2 = r7.getChildAt(r1);
        int r3 = r2.getId();
        if (this.i.containsKey(Integer.valueOf(r3)) == true) goto L8;
        a(TAG, "id unknown " + com.obric.oui.constraintlayout.motion.widget.a.a(r2));
    L20:
        r1 = r1 + 1;
        goto L3
    L8:
        if (this.g == false) goto L15;
        if (r3 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.i.containsKey(Integer.valueOf(r3)) == false) goto L20;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L20;
        com.obric.oui.constraintlayout.widget.a.a(r2, r4.g);
        goto L20
    }

    public void a(ConstraintHelper r4, com.obric.oui.constraintlayout.a.c.e r5, ConstraintLayout.LayoutParams r6, SparseArray<com.obric.oui.constraintlayout.a.c.e> r7) {
        int r0 = r4.getId();
        if (this.i.containsKey(Integer.valueOf(r0)) == false) goto L10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r0)), a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L12;
        r4.loadParameters(r3, (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin"), r6, r7);
        return;
    L12:
        return;
    }

    public void a(int r3, ConstraintLayout.LayoutParams r4) {
        if (this.i.containsKey(Integer.valueOf(r3)) == false) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.a(r4);
        return;
    L9:
        return;
    }

    void a(ConstraintLayout r13, boolean r14) {
        int r0 = r13.getChildCount();
        HashSet r1 = new HashSet(this.i.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L55;
        View r6 = r13.getChildAt(r3);
        int r7 = r6.getId();
        if (this.i.containsKey(Integer.valueOf(r7)) == true) goto L9;
        a(TAG, "id unknown " + com.obric.oui.constraintlayout.motion.widget.a.a(r6));
    L54:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.g == false) goto L14;
        if (r7 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r7 == (-1)) goto L54;
        if (this.i.containsKey(Integer.valueOf(r7)) == false) goto L53;
        r1.remove(Integer.valueOf(r7));
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r7)), a.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L54;
        if (ZeusTransformUtils.instanceOf(r6, Barrier.class) == false) goto L29;
        r8.f34961e.aj = 1;
        Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r6, Barrier.class, "com.obric.aiagent.plugin");
        r4.setId(r7);
        r4.setType(r8.f34961e.ah);
        r4.setMargin(r8.f34961e.ai);
        r4.setAllowsGoneWidget(r8.f34961e.ap);
        if (r8.f34961e.ak == null) goto L27;
        r4.setReferencedIds(r8.f34961e.ak);
        goto L29
    L27:
        if (r8.f34961e.al == null) goto L29;
        r8.f34961e.ak = a(r4, r8.f34961e.al);
        r4.setReferencedIds(r8.f34961e.ak);
    L29:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.validate();
        r8.a(r5);
        if (r14 == false) goto L32;
        com.obric.oui.constraintlayout.widget.a.a(r6, r8.g);
    L32:
        r6.setLayoutParams(r5);
        if (r8.f34959c.f34980c != 0) goto L35;
        r6.setVisibility(r8.f34959c.f34979b);
    L35:
        r6.setAlpha(r8.f34959c.f34981d);
        r6.setRotation(r8.f.f34984b);
        r6.setRotationX(r8.f.f34985c);
        r6.setRotationY(r8.f.f34986d);
        r6.setScaleX(r8.f.f34987e);
        r6.setScaleY(r8.f.f);
        if (r8.f.i == (-1)) goto L45;
        View r9 = ((View) ZeusTransformUtils.preCheckCast(r6.getParent(), View.class, "com.obric.aiagent.plugin")).findViewById(r8.f.i);
        if (r9 == null) goto L50;
        float r10 = (r9.getTop() + r9.getBottom()) / 2.0f;
        float r11 = (r9.getLeft() + r9.getRight()) / 2.0f;
        if ((r6.getRight() - r6.getLeft()) <= 0) goto L50;
        if ((r6.getBottom() - r6.getTop()) <= 0) goto L50;
        float r12 = r11 - r6.getLeft();
        float r15 = r10 - r6.getTop();
        r6.setPivotX(r12);
        r6.setPivotY(r15);
    L50:
        r6.setTranslationX(r8.f.j);
        r6.setTranslationY(r8.f.k);
        r6.setTranslationZ(r8.f.l);
        if (r8.f.m == false) goto L54;
        r6.setElevation(r8.f.n);
        goto L54
    L45:
        if (Float.isNaN(r8.f.g) == true) goto L48;
        r6.setPivotX(r8.f.g);
    L48:
        if (Float.isNaN(r8.f.h) == true) goto L50;
        r6.setPivotY(r8.f.h);
        goto L50
    L53:
        b(TAG, "WARNING NO CONSTRAINTS for view " + r7);
        goto L54
    L55:
        Iterator r16 = r1.iterator();
    L57:
        if (r16.hasNext() == false) goto L73;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.next(), Integer.class, "com.obric.aiagent.plugin");
        a r18 = (a) ZeusTransformUtils.preCheckCast(this.i.get(r17), a.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L57;
        if (r18.f34961e.aj != 1) goto L71;
        Barrier r19 = new Barrier((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r19.setId(r17.intValue());
        if (r18.f34961e.ak == null) goto L67;
        r19.setReferencedIds(r18.f34961e.ak);
    L69:
        r19.setType(r18.f34961e.ah);
        r19.setMargin(r18.f34961e.ai);
        ConstraintLayout.LayoutParams r20 = r13.generateDefaultLayoutParams();
        r19.validateParams();
        r18.a(r20);
        r13.addView(r19, r20);
        goto L71
    L67:
        if (r18.f34961e.al == null) goto L69;
        r18.f34961e.ak = a(r19, r18.f34961e.al);
        r19.setReferencedIds(r18.f34961e.ak);
    L71:
        if (r18.f34961e.f34968a == false) goto L57;
        Guideline r21 = new Guideline((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r21.setId(r17.intValue());
        ConstraintLayout.LayoutParams r22 = r13.generateDefaultLayoutParams();
        r18.a(r22);
        r13.addView(r21, r22);
    L73:
        if (r2 >= r0) goto L78;
        View r110 = r13.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r110, ConstraintHelper.class) == false) goto L77;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r110, ConstraintHelper.class, "com.obric.aiagent.plugin")).applyLayoutFeaturesInConstraintSet(r13);
    L77:
        r2 = r2 + 1;
        goto L73
    }

    public void a(int r3, int r4) {
        if (this.i.containsKey(Integer.valueOf(r3)) == false) goto L20;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        r2.f34961e.D = -1.0f;
        r2.f34961e.C = -1;
        r2.f34961e.B = -1;
        return;
    L12:
        r2.f34961e.w = -1;
        r2.f34961e.x = -1;
        r2.f34961e.L = 0;
        r2.f34961e.S = Integer.MIN_VALUE;
        return;
    L13:
        r2.f34961e.u = -1;
        r2.f34961e.v = -1;
        r2.f34961e.M = 0;
        r2.f34961e.T = Integer.MIN_VALUE;
        return;
    L14:
        r2.f34961e.r = -1;
        r2.f34961e.s = -1;
        r2.f34961e.t = -1;
        r2.f34961e.N = 0;
        r2.f34961e.U = Integer.MIN_VALUE;
        return;
    L15:
        r2.f34961e.p = -1;
        r2.f34961e.q = -1;
        r2.f34961e.K = 0;
        r2.f34961e.R = Integer.MIN_VALUE;
        return;
    L16:
        r2.f34961e.o = -1;
        r2.f34961e.n = -1;
        r2.f34961e.f34967J = 0;
        r2.f34961e.P = Integer.MIN_VALUE;
        return;
    L17:
        r2.f34961e.m = -1;
        r2.f34961e.l = -1;
        r2.f34961e.I = -1;
        r2.f34961e.Q = Integer.MIN_VALUE;
        return;
    L18:
        r2.f34961e.k = -1;
        r2.f34961e.j = -1;
        r2.f34961e.H = -1;
        r2.f34961e.O = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public int b(int r1) {
        return g(r1).f34959c.f34980c;
    }

    public int c(int r1) {
        return g(r1).f34959c.f34979b;
    }

    public int d(int r1) {
        return g(r1).f34961e.f34972e;
    }

    public int e(int r1) {
        return g(r1).f34961e.f34971d;
    }

    public void b(int r2, int r3) {
        g(r2).f34961e.g = r3;
        g(r2).f34961e.f = -1;
        g(r2).f34961e.h = -1.0f;
    }

    private a g(int r4) {
        if (this.i.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.i.put(Integer.valueOf(r4), new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
    }

    public void b(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r2 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getXml(r9);
        int r3 = r2.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L5:
        if (r3 == 1) goto L27;
        if (r3 != 2) goto L13;
        String r4 = r2.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        a r5 = a(r10, Xml.asAttributeSet(r2), false);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r4.equalsIgnoreCase("Guideline") == false) goto L12;
        r5.f34961e.f34968a = true;     // Catch: IOException -> L15 XmlPullParserException -> L17
    L12:
        this.i.put(Integer.valueOf(r5.f34957a), r5);     // Catch: IOException -> L15 XmlPullParserException -> L17
    L13:
        r3 = r2.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L27:
        return;
    L15:
        e = move-exception;
        a(TAG, "Error parsing resource: " + r9, e);
        return;
    L17:
        e = move-exception;
        a(TAG, "Error parsing resource: " + r9, e);
    }

    public void a(Context r12, XmlPullParser r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.aiagent.plugin");
        int r2 = r15.getEventType();     // Catch: IOException -> L97 XmlPullParserException -> L99
        a r4 = null;
    L5:
        if (r2 == 1) goto L122;
        if (r2 == 0) goto L94;
        byte r6 = -1;
        if (r2 == 2) goto L33;
        if (r2 != 3) goto L95;
        String r3 = r15.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r3.hashCode()) {
            case -2075718416: goto L24;
            case -190376483: goto L21;
            case 426575017: goto L18;
            case 2146106725: goto L15;
            default: goto L26;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L26:
        if (r6 == 0) goto L32;
        if (r6 == 1) goto L31;
        if (r6 == 2) goto L31;
        if (r6 != 3) goto L95;
    L31:
        this.i.put(Integer.valueOf(r4.f34957a), r4);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r4 = null;
        goto L95
    L32:
        return;
    L15:
        if (r3.equals("constraintset") == false) goto L26;
        r6 = 0;
        goto L26
    L18:
        if (r3.equals("constraintoverride") == false) goto L26;
        r6 = 2;
        goto L26
    L21:
        if (r3.equals("constraint") == false) goto L26;
        r6 = 1;
        goto L26
    L24:
        if (r3.equals("guideline") == false) goto L26;
        r6 = 3;
    L95:
        r2 = r15.next();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L5
    L33:
        String r5 = r15.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r5.hashCode()) {
            case -2025855158: goto L64;
            case -1984451626: goto L61;
            case -1962203927: goto L58;
            case -1269513683: goto L55;
            case -1238332596: goto L52;
            case -71750448: goto L49;
            case 366511058: goto L46;
            case 1331510167: goto L43;
            case 1791837707: goto L40;
            case 1803088381: goto L37;
            default: goto L67;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L67:
        switch(r6) {
            case 0: goto L92;
            case 1: goto L91;
            case 2: goto L90;
            case 3: goto L89;
            case 4: goto L85;
            case 5: goto L81;
            case 6: goto L77;
            case 7: goto L73;
            case 8: goto L69;
            case 9: goto L69;
            default: goto L95;
        };
    L69:
        if (r4 == null) goto L72;
        com.obric.oui.constraintlayout.widget.a.a(r14, r15, r4.g);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L72:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L73:
        if (r4 == null) goto L76;
        r4.f34960d.a(r14, Xml.asAttributeSet(r15));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L76:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L77:
        if (r4 == null) goto L80;
        r4.f34961e.a(r14, Xml.asAttributeSet(r15));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L80:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L81:
        if (r4 == null) goto L84;
        r4.f.a(r14, Xml.asAttributeSet(r15));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L84:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L85:
        if (r4 == null) goto L88;
        r4.f34959c.a(r14, Xml.asAttributeSet(r15));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L88:
        throw new RuntimeException("XML parser error must be within a Constraint " + r15.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L89:
        a r7 = a(r14, Xml.asAttributeSet(r15), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r7.f34961e.aj = 1;     // Catch: IOException -> L97 XmlPullParserException -> L99
    L93:
        r4 = r7;
        goto L95
    L90:
        r7 = a(r14, Xml.asAttributeSet(r15), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r7.f34961e.f34968a = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        r7.f34961e.f34969b = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L91:
        r7 = a(r14, Xml.asAttributeSet(r15), true);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L92:
        r7 = a(r14, Xml.asAttributeSet(r15), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L37:
        if (r5.equals("Constraint") == false) goto L67;
        r6 = 0;
        goto L67
    L40:
        if (r5.equals("CustomAttribute") == false) goto L67;
        r6 = 8;
        goto L67
    L43:
        if (r5.equals("Barrier") == false) goto L67;
        r6 = 3;
        goto L67
    L46:
        if (r5.equals("CustomMethod") == false) goto L67;
        r6 = 9;
        goto L67
    L49:
        if (r5.equals("Guideline") == false) goto L67;
        r6 = 2;
        goto L67
    L52:
        if (r5.equals("Transform") == false) goto L67;
        r6 = 5;
        goto L67
    L55:
        if (r5.equals("PropertySet") == false) goto L67;
        r6 = 4;
        goto L67
    L58:
        if (r5.equals("ConstraintOverride") == false) goto L67;
        r6 = 1;
        goto L67
    L61:
        if (r5.equals("Motion") == false) goto L67;
        r6 = 7;
        goto L67
    L64:
        if (r5.equals("Layout") == false) goto L67;
        r6 = 6;
        goto L67
    L94:
        r15.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L122:
        return;
    L97:
        e = move-exception;
        a(TAG, "Error parsing XML resource", e);
        return;
    L99:
        e = move-exception;
        a(TAG, "Error parsing XML resource", e);
    }

    private static int b(TypedArray r1, int r2, int r3) {
        int r4 = r1.getResourceId(r2, r3);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        return r1.getInt(r2, -1);
    }

    private a a(Context r3, AttributeSet r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        a r0 = new a();
        if (r5 == false) goto L5;
        int[] r1 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r8 = r6.obtainStyledAttributes(r7, r1);
        a(r0, r8, r5);
        r8.recycle();
        return r0;
    L5:
        r1 = R.styleable.Constraint;
        goto L6
    }

    public static a b(Context r2, XmlPullParser r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"));
        a r0 = new a();
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.ConstraintOverride);
        a(r0, r6);
        r6.recycle();
        return r0;
    }

    private static void a(a r13, TypedArray r14) {
        int r0 = r14.getIndexCount();
        a.C0945a r1 = new a.C0945a();
        r13.h = r1;
        r13.f34960d.f34973a = false;
        r13.f34961e.f34969b = false;
        r13.f34959c.f34978a = false;
        r13.f.f34983a = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L110;
        int r4 = r14.getIndex(r2);
        switch(k.get(r4)) {
            case 2: goto L108;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L107;
            case 6: goto L106;
            case 7: goto L105;
            case 8: goto L104;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L103;
            case 12: goto L102;
            case 13: goto L101;
            case 14: goto L100;
            case 15: goto L99;
            case 16: goto L98;
            case 17: goto L97;
            case 18: goto L96;
            case 19: goto L95;
            case 20: goto L94;
            case 21: goto L93;
            case 22: goto L92;
            case 23: goto L91;
            case 24: goto L90;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L89;
            case 28: goto L88;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L87;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L86;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L85;
            case 38: goto L84;
            case 39: goto L83;
            case 40: goto L82;
            case 41: goto L81;
            case 42: goto L80;
            case 43: goto L79;
            case 44: goto L78;
            case 45: goto L77;
            case 46: goto L76;
            case 47: goto L75;
            case 48: goto L74;
            case 49: goto L73;
            case 50: goto L72;
            case 51: goto L71;
            case 52: goto L70;
            case 53: goto L69;
            case 54: goto L68;
            case 55: goto L67;
            case 56: goto L66;
            case 57: goto L65;
            case 58: goto L64;
            case 59: goto L63;
            case 60: goto L62;
            case 61: goto L6;
            case 62: goto L61;
            case 63: goto L60;
            case 64: goto L59;
            case 65: goto L56;
            case 66: goto L54;
            case 67: goto L53;
            case 68: goto L52;
            case 69: goto L51;
            case 70: goto L50;
            case 71: goto L49;
            case 72: goto L48;
            case 73: goto L47;
            case 74: goto L46;
            case 75: goto L45;
            case 76: goto L44;
            case 77: goto L43;
            case 78: goto L42;
            case 79: goto L41;
            case 80: goto L40;
            case 81: goto L39;
            case 82: goto L38;
            case 83: goto L37;
            case 84: goto L36;
            case 85: goto L35;
            case 86: goto L23;
            case 87: goto L22;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            case 98: goto L9;
            case 99: goto L7;
            default: goto L6;
        };
    L6:
        a(TAG, "Unknown attribute 0x" + Integer.toHexString(r4) + "   " + j.get(r4));
    L109:
        r2 = r2 + 1;
        goto L3
    L7:
        r1.a(99, r14.getBoolean(r4, r13.f34961e.i));
        goto L109
    L17:
        r1.a(97, r14.getInt(r4, r13.f34961e.aq));
        goto L109
    L18:
        a(r1, r14, r4, 1);
        goto L109
    L19:
        a(r1, r14, r4, 0);
        goto L109
    L20:
        r1.a(94, r14.getDimensionPixelSize(r4, r13.f34961e.U));
        goto L109
    L21:
        r1.a(93, r14.getDimensionPixelSize(r4, r13.f34961e.N));
        goto L109
    L22:
        a(TAG, "unused attribute 0x" + Integer.toHexString(r4) + "   " + j.get(r4));
        goto L109
    L23:
        TypedValue r5 = r14.peekValue(r4);
        if (r5.type != 1) goto L29;
        r13.f34960d.n = r14.getResourceId(r4, -1);
        r1.a(89, r13.f34960d.n);
        if (r13.f34960d.n == (-1)) goto L109;
        r13.f34960d.m = -2;
        r1.a(88, r13.f34960d.m);
        goto L109
    L29:
        if (r5.type != 3) goto L34;
        r13.f34960d.l = r14.getString(r4);
        r1.a(90, r13.f34960d.l);
        if (r13.f34960d.l.indexOf("/") <= 0) goto L33;
        r13.f34960d.n = r14.getResourceId(r4, -1);
        r1.a(89, r13.f34960d.n);
        r13.f34960d.m = -2;
        r1.a(88, r13.f34960d.m);
        goto L109
    L33:
        r13.f34960d.m = -1;
        r1.a(88, r13.f34960d.m);
        goto L109
    L34:
        r13.f34960d.m = r14.getInteger(r4, r13.f34960d.n);
        r1.a(88, r13.f34960d.m);
        goto L109
    L35:
        r1.a(85, r14.getFloat(r4, r13.f34960d.j));
        goto L109
    L36:
        r1.a(84, r14.getInteger(r4, r13.f34960d.k));
        goto L109
    L37:
        r1.a(83, b(r14, r4, r13.f.i));
        goto L109
    L38:
        r1.a(82, r14.getInteger(r4, r13.f34960d.f34975c));
        goto L109
    L39:
        r1.a(81, r14.getBoolean(r4, r13.f34961e.ao));
        goto L109
    L40:
        r1.a(80, r14.getBoolean(r4, r13.f34961e.an));
        goto L109
    L41:
        r1.a(79, r14.getFloat(r4, r13.f34960d.g));
        goto L109
    L42:
        r1.a(78, r14.getInt(r4, r13.f34959c.f34980c));
        goto L109
    L43:
        r1.a(77, r14.getString(r4));
        goto L109
    L44:
        r1.a(76, r14.getInt(r4, r13.f34960d.f34977e));
        goto L109
    L45:
        r1.a(75, r14.getBoolean(r4, r13.f34961e.ap));
        goto L109
    L46:
        r1.a(74, r14.getString(r4));
        goto L109
    L47:
        r1.a(73, r14.getDimensionPixelSize(r4, r13.f34961e.ai));
        goto L109
    L48:
        r1.a(72, r14.getInt(r4, r13.f34961e.ah));
        goto L109
    L49:
        c(TAG, "CURRENTLY UNSUPPORTED");
        goto L109
    L50:
        r1.a(70, r14.getFloat(r4, 1.0f));
        goto L109
    L51:
        r1.a(69, r14.getFloat(r4, 1.0f));
        goto L109
    L52:
        r1.a(68, r14.getFloat(r4, r13.f34959c.f34982e));
        goto L109
    L53:
        r1.a(67, r14.getFloat(r4, r13.f34960d.i));
        goto L109
    L54:
        r1.a(66, r14.getInt(r4, 0));
        goto L109
    L59:
        r1.a(64, b(r14, r4, r13.f34960d.f34974b));
        goto L109
    L60:
        r1.a(63, r14.getFloat(r4, r13.f34961e.D));
        goto L109
    L61:
        r1.a(62, r14.getDimensionPixelSize(r4, r13.f34961e.C));
        goto L109
    L62:
        r1.a(60, r14.getFloat(r4, r13.f.f34984b));
        goto L109
    L63:
        r1.a(59, r14.getDimensionPixelSize(r4, r13.f34961e.ae));
        goto L109
    L64:
        r1.a(58, r14.getDimensionPixelSize(r4, r13.f34961e.ad));
        goto L109
    L65:
        r1.a(57, r14.getDimensionPixelSize(r4, r13.f34961e.ac));
        goto L109
    L66:
        r1.a(56, r14.getDimensionPixelSize(r4, r13.f34961e.ab));
        goto L109
    L67:
        r1.a(55, r14.getInt(r4, r13.f34961e.aa));
        goto L109
    L68:
        r1.a(54, r14.getInt(r4, r13.f34961e.Z));
        goto L109
    L69:
        r1.a(53, r14.getDimension(r4, r13.f.l));
        goto L109
    L70:
        r1.a(52, r14.getDimension(r4, r13.f.k));
        goto L109
    L71:
        r1.a(51, r14.getDimension(r4, r13.f.j));
        goto L109
    L72:
        r1.a(50, r14.getDimension(r4, r13.f.h));
        goto L109
    L73:
        r1.a(49, r14.getDimension(r4, r13.f.g));
        goto L109
    L74:
        r1.a(48, r14.getFloat(r4, r13.f.f));
        goto L109
    L75:
        r1.a(47, r14.getFloat(r4, r13.f.f34987e));
        goto L109
    L76:
        r1.a(46, r14.getFloat(r4, r13.f.f34986d));
        goto L109
    L77:
        r1.a(45, r14.getFloat(r4, r13.f.f34985c));
        goto L109
    L78:
        r1.a(44, true);
        r1.a(44, r14.getDimension(r4, r13.f.n));
        goto L109
    L79:
        r1.a(43, r14.getFloat(r4, r13.f34959c.f34981d));
        goto L109
    L80:
        r1.a(42, r14.getInt(r4, r13.f34961e.Y));
        goto L109
    L81:
        r1.a(41, r14.getInt(r4, r13.f34961e.X));
        goto L109
    L82:
        r1.a(40, r14.getFloat(r4, r13.f34961e.V));
        goto L109
    L83:
        r1.a(39, r14.getFloat(r4, r13.f34961e.W));
        goto L109
    L84:
        r13.f34957a = r14.getResourceId(r4, r13.f34957a);
        r1.a(38, r13.f34957a);
        goto L109
    L85:
        r1.a(37, r14.getFloat(r4, r13.f34961e.z));
        goto L109
    L86:
        r1.a(34, r14.getDimensionPixelSize(r4, r13.f34961e.f34967J));
        goto L109
    L87:
        r1.a(31, r14.getDimensionPixelSize(r4, r13.f34961e.M));
        goto L109
    L88:
        r1.a(28, r14.getDimensionPixelSize(r4, r13.f34961e.I));
        goto L109
    L89:
        r1.a(27, r14.getInt(r4, r13.f34961e.G));
        goto L109
    L90:
        r1.a(24, r14.getDimensionPixelSize(r4, r13.f34961e.H));
        goto L109
    L91:
        r1.a(23, r14.getLayoutDimension(r4, r13.f34961e.f34971d));
        goto L109
    L92:
        r1.a(22, h[r14.getInt(r4, r13.f34959c.f34979b)]);
        goto L109
    L93:
        r1.a(21, r14.getLayoutDimension(r4, r13.f34961e.f34972e));
        goto L109
    L94:
        r1.a(20, r14.getFloat(r4, r13.f34961e.y));
        goto L109
    L95:
        r1.a(19, r14.getFloat(r4, r13.f34961e.h));
        goto L109
    L96:
        r1.a(18, r14.getDimensionPixelOffset(r4, r13.f34961e.g));
        goto L109
    L97:
        r1.a(17, r14.getDimensionPixelOffset(r4, r13.f34961e.f));
        goto L109
    L98:
        r1.a(16, r14.getDimensionPixelSize(r4, r13.f34961e.P));
        goto L109
    L99:
        r1.a(15, r14.getDimensionPixelSize(r4, r13.f34961e.T));
        goto L109
    L100:
        r1.a(14, r14.getDimensionPixelSize(r4, r13.f34961e.Q));
        goto L109
    L101:
        r1.a(13, r14.getDimensionPixelSize(r4, r13.f34961e.O));
        goto L109
    L102:
        r1.a(12, r14.getDimensionPixelSize(r4, r13.f34961e.S));
        goto L109
    L103:
        r1.a(11, r14.getDimensionPixelSize(r4, r13.f34961e.R));
        goto L109
    L104:
        r1.a(8, r14.getDimensionPixelSize(r4, r13.f34961e.L));
        goto L109
    L105:
        r1.a(7, r14.getDimensionPixelOffset(r4, r13.f34961e.F));
        goto L109
    L106:
        r1.a(6, r14.getDimensionPixelOffset(r4, r13.f34961e.E));
        goto L109
    L107:
        r1.a(5, r14.getString(r4));
        goto L109
    L108:
        r1.a(2, r14.getDimensionPixelSize(r4, r13.f34961e.K));
        goto L109
    L9:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L14;
        r13.f34957a = r14.getResourceId(r4, r13.f34957a);
        if (r13.f34957a != (-1)) goto L109;
        r13.f34958b = r14.getString(r4);
        goto L109
    L14:
        if (r14.peekValue(r4).type != 3) goto L16;
        r13.f34958b = r14.getString(r4);
        goto L109
    L16:
        r13.f34957a = r14.getResourceId(r4, r13.f34957a);
        goto L109
    L56:
        if (r14.peekValue(r4).type != 3) goto L58;
        r1.a(65, r14.getString(r4));
        goto L109
    L58:
        r1.a(65, com.obric.oui.constraintlayout.a.a.a.c.f34592c[r14.getInteger(r4, 0)]);
        goto L109
    }

    private static void b(a r1, int r2, float r3) {
        if (r2 != 19) goto L5;
        r1.f34961e.h = r3;
        return;
    L5:
        if (r2 != 20) goto L7;
        r1.f34961e.y = r3;
        return;
    L7:
        if (r2 != 37) goto L9;
        r1.f34961e.z = r3;
        return;
    L9:
        if (r2 != 60) goto L11;
        r1.f.f34984b = r3;
        return;
    L11:
        if (r2 != 63) goto L13;
        r1.f34961e.D = r3;
        return;
    L13:
        if (r2 != 79) goto L15;
        r1.f34960d.g = r3;
        return;
    L15:
        if (r2 != 85) goto L17;
        r1.f34960d.j = r3;
        return;
    L17:
        if (r2 != 87) goto L19;
        return;
    L19:
        if (r2 != 39) goto L21;
        r1.f34961e.W = r3;
        return;
    L21:
        if (r2 == 40) goto L40;
        switch(r2) {
            case 43: goto L39;
            case 44: goto L38;
            case 45: goto L37;
            case 46: goto L36;
            case 47: goto L35;
            case 48: goto L34;
            case 49: goto L33;
            case 50: goto L32;
            case 51: goto L31;
            case 52: goto L30;
            case 53: goto L29;
            default: goto L23;
        };
    L23:
        switch(r2) {
            case 67: goto L28;
            case 68: goto L27;
            case 69: goto L26;
            case 70: goto L25;
            default: goto L24;
        };
    L24:
        a(TAG, "Unknown attribute 0x");
        return;
    L25:
        r1.f34961e.ag = r3;
        return;
    L26:
        r1.f34961e.af = r3;
        return;
    L27:
        r1.f34959c.f34982e = r3;
        return;
    L28:
        r1.f34960d.i = r3;
        return;
    L29:
        r1.f.l = r3;
        return;
    L30:
        r1.f.k = r3;
        return;
    L31:
        r1.f.j = r3;
        return;
    L32:
        r1.f.h = r3;
        return;
    L33:
        r1.f.g = r3;
        return;
    L34:
        r1.f.f = r3;
        return;
    L35:
        r1.f.f34987e = r3;
        return;
    L36:
        r1.f.f34986d = r3;
        return;
    L37:
        r1.f.f34985c = r3;
        return;
    L38:
        r1.f.n = r3;
        r1.f.m = true;
        return;
    L39:
        r1.f34959c.f34981d = r3;
        return;
    L40:
        r1.f34961e.V = r3;
    }

    private static void b(a r1, int r2, int r3) {
        if (r2 != 6) goto L5;
        r1.f34961e.E = r3;
        return;
    L5:
        if (r2 != 7) goto L7;
        r1.f34961e.F = r3;
        return;
    L7:
        if (r2 != 8) goto L9;
        r1.f34961e.L = r3;
        return;
    L9:
        if (r2 != 27) goto L11;
        r1.f34961e.G = r3;
        return;
    L11:
        if (r2 != 28) goto L13;
        r1.f34961e.I = r3;
        return;
    L13:
        if (r2 != 41) goto L15;
        r1.f34961e.X = r3;
        return;
    L15:
        if (r2 != 42) goto L17;
        r1.f34961e.Y = r3;
        return;
    L17:
        if (r2 != 61) goto L19;
        r1.f34961e.B = r3;
        return;
    L19:
        if (r2 != 62) goto L21;
        r1.f34961e.C = r3;
        return;
    L21:
        if (r2 != 72) goto L23;
        r1.f34961e.ah = r3;
        return;
    L23:
        if (r2 == 73) goto L64;
        switch(r2) {
            case 2: goto L63;
            case 11: goto L62;
            case 12: goto L61;
            case 13: goto L60;
            case 14: goto L59;
            case 15: goto L58;
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            case 31: goto L54;
            case 34: goto L53;
            case 38: goto L52;
            case 64: goto L51;
            case 66: goto L50;
            case 76: goto L49;
            case 78: goto L48;
            case 93: goto L47;
            case 94: goto L46;
            case 97: goto L45;
            default: goto L25;
        };
    L25:
        switch(r2) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(r2) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(r2) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(r2) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        a(TAG, "Unknown attribute 0x");
        return;
    L30:
        r1.f34960d.n = r3;
        return;
    L31:
        r1.f34960d.m = r3;
        return;
    L76:
        return;
    L32:
        r1.f34960d.k = r3;
        return;
    L33:
        r1.f.i = r3;
        return;
    L34:
        r1.f34960d.f34975c = r3;
        return;
    L35:
        r1.f34961e.ae = r3;
        return;
    L36:
        r1.f34961e.ad = r3;
        return;
    L37:
        r1.f34961e.ac = r3;
        return;
    L38:
        r1.f34961e.ab = r3;
        return;
    L39:
        r1.f34961e.aa = r3;
        return;
    L40:
        r1.f34961e.Z = r3;
        return;
    L41:
        r1.f34961e.H = r3;
        return;
    L42:
        r1.f34961e.f34971d = r3;
        return;
    L43:
        r1.f34959c.f34979b = r3;
        return;
    L44:
        r1.f34961e.f34972e = r3;
        return;
    L45:
        r1.f34961e.aq = r3;
        return;
    L46:
        r1.f34961e.U = r3;
        return;
    L47:
        r1.f34961e.N = r3;
        return;
    L48:
        r1.f34959c.f34980c = r3;
        return;
    L49:
        r1.f34960d.f34977e = r3;
        return;
    L50:
        r1.f34960d.f = r3;
        return;
    L51:
        r1.f34960d.f34974b = r3;
        return;
    L52:
        r1.f34957a = r3;
        return;
    L53:
        r1.f34961e.f34967J = r3;
        return;
    L54:
        r1.f34961e.M = r3;
        return;
    L55:
        r1.f34961e.g = r3;
        return;
    L56:
        r1.f34961e.f = r3;
        return;
    L57:
        r1.f34961e.P = r3;
        return;
    L58:
        r1.f34961e.T = r3;
        return;
    L59:
        r1.f34961e.Q = r3;
        return;
    L60:
        r1.f34961e.O = r3;
        return;
    L61:
        r1.f34961e.S = r3;
        return;
    L62:
        r1.f34961e.R = r3;
        return;
    L63:
        r1.f34961e.K = r3;
        return;
    L64:
        r1.f34961e.ai = r3;
    }

    private static void b(a r1, int r2, String r3) {
        if (r2 != 5) goto L5;
        r1.f34961e.A = r3;
        return;
    L5:
        if (r2 != 65) goto L7;
        r1.f34960d.f34976d = r3;
        return;
    L7:
        if (r2 != 74) goto L9;
        r1.f34961e.al = r3;
        r1.f34961e.ak = null;
        return;
    L9:
        if (r2 != 77) goto L11;
        r1.f34961e.am = r3;
        return;
    L11:
        if (r2 != 87) goto L13;
        return;
    L13:
        if (r2 == 90) goto L15;
        a(TAG, "Unknown attribute 0x");
        return;
    L15:
        r1.f34960d.l = r3;
    }

    private static void b(a r1, int r2, boolean r3) {
        if (r2 != 44) goto L5;
        r1.f.m = r3;
        return;
    L5:
        if (r2 != 75) goto L7;
        r1.f34961e.ap = r3;
        return;
    L7:
        if (r2 != 87) goto L9;
        return;
    L9:
        if (r2 != 80) goto L11;
        r1.f34961e.an = r3;
        return;
    L11:
        if (r2 == 81) goto L13;
        a(TAG, "Unknown attribute 0x");
        return;
    L13:
        r1.f34961e.ao = r3;
    }

    private void a(a r9, TypedArray r10, boolean r11) {
        if (r11 == false) goto L5;
        a(r9, r10);
        return;
    L5:
        int r8 = r10.getIndexCount();
        int r0 = 0;
    L6:
        if (r0 >= r8) goto L127;
        int r1 = r10.getIndex(r0);
        if (r1 == ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id")) goto L15;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart") == r1) goto L15;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd") == r1) goto L15;
        r9.f34960d.f34973a = true;
        r9.f34961e.f34969b = true;
        r9.f34959c.f34978a = true;
        r9.f.f34983a = true;
    L15:
        switch(j.get(r1)) {
            case 1: goto L124;
            case 2: goto L123;
            case 3: goto L122;
            case 4: goto L121;
            case 5: goto L120;
            case 6: goto L119;
            case 7: goto L118;
            case 8: goto L117;
            case 9: goto L116;
            case 10: goto L115;
            case 11: goto L114;
            case 12: goto L113;
            case 13: goto L112;
            case 14: goto L111;
            case 15: goto L110;
            case 16: goto L109;
            case 17: goto L108;
            case 18: goto L107;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L104;
            case 22: goto L103;
            case 23: goto L102;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L98;
            case 28: goto L97;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L94;
            case 32: goto L93;
            case 33: goto L92;
            case 34: goto L91;
            case 35: goto L90;
            case 36: goto L89;
            case 37: goto L88;
            case 38: goto L87;
            case 39: goto L86;
            case 40: goto L85;
            case 41: goto L84;
            case 42: goto L83;
            case 43: goto L82;
            case 44: goto L81;
            case 45: goto L80;
            case 46: goto L79;
            case 47: goto L78;
            case 48: goto L77;
            case 49: goto L76;
            case 50: goto L75;
            case 51: goto L74;
            case 52: goto L73;
            case 53: goto L72;
            case 54: goto L71;
            case 55: goto L70;
            case 56: goto L69;
            case 57: goto L68;
            case 58: goto L67;
            case 59: goto L66;
            case 60: goto L65;
            case 61: goto L64;
            case 62: goto L63;
            case 63: goto L62;
            case 64: goto L61;
            case 65: goto L58;
            case 66: goto L56;
            case 67: goto L55;
            case 68: goto L54;
            case 69: goto L53;
            case 70: goto L52;
            case 71: goto L51;
            case 72: goto L50;
            case 73: goto L49;
            case 74: goto L48;
            case 75: goto L47;
            case 76: goto L46;
            case 77: goto L45;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L42;
            case 81: goto L41;
            case 82: goto L40;
            case 83: goto L39;
            case 84: goto L38;
            case 85: goto L37;
            case 86: goto L25;
            case 87: goto L24;
            case 88: goto L16;
            case 89: goto L16;
            case 90: goto L16;
            case 91: goto L23;
            case 92: goto L22;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            default: goto L16;
        };
    L16:
        a(TAG, "Unknown attribute 0x" + Integer.toHexString(r1) + "   " + j.get(r1));
    L125:
        r0 = r0 + 1;
        goto L6
    L17:
        r9.f34961e.aq = r10.getInt(r1, r9.f34961e.aq);
        goto L125
    L18:
        a(r9.f34961e, r10, r1, 1);
        goto L125
    L19:
        a(r9.f34961e, r10, r1, 0);
        goto L125
    L20:
        r9.f34961e.U = r10.getDimensionPixelSize(r1, r9.f34961e.U);
        goto L125
    L21:
        r9.f34961e.N = r10.getDimensionPixelSize(r1, r9.f34961e.N);
        goto L125
    L22:
        r9.f34961e.t = b(r10, r1, r9.f34961e.t);
        goto L125
    L23:
        r9.f34961e.s = b(r10, r1, r9.f34961e.s);
        goto L125
    L24:
        a(TAG, "unused attribute 0x" + Integer.toHexString(r1) + "   " + j.get(r1));
        goto L125
    L25:
        TypedValue r2 = r10.peekValue(r1);
        if (r2.type != 1) goto L31;
        r9.f34960d.n = r10.getResourceId(r1, -1);
        if (r9.f34960d.n == (-1)) goto L125;
        r9.f34960d.m = -2;
        goto L125
    L31:
        if (r2.type != 3) goto L36;
        r9.f34960d.l = r10.getString(r1);
        if (r9.f34960d.l.indexOf("/") <= 0) goto L35;
        r9.f34960d.n = r10.getResourceId(r1, -1);
        r9.f34960d.m = -2;
        goto L125
    L35:
        r9.f34960d.m = -1;
        goto L125
    L36:
        r9.f34960d.m = r10.getInteger(r1, r9.f34960d.n);
        goto L125
    L37:
        r9.f34960d.j = r10.getFloat(r1, r9.f34960d.j);
        goto L125
    L38:
        r9.f34960d.k = r10.getInteger(r1, r9.f34960d.k);
        goto L125
    L39:
        r9.f.i = b(r10, r1, r9.f.i);
        goto L125
    L40:
        r9.f34960d.f34975c = r10.getInteger(r1, r9.f34960d.f34975c);
        goto L125
    L41:
        r9.f34961e.ao = r10.getBoolean(r1, r9.f34961e.ao);
        goto L125
    L42:
        r9.f34961e.an = r10.getBoolean(r1, r9.f34961e.an);
        goto L125
    L43:
        r9.f34960d.g = r10.getFloat(r1, r9.f34960d.g);
        goto L125
    L44:
        r9.f34959c.f34980c = r10.getInt(r1, r9.f34959c.f34980c);
        goto L125
    L45:
        r9.f34961e.am = r10.getString(r1);
        goto L125
    L46:
        r9.f34960d.f34977e = r10.getInt(r1, r9.f34960d.f34977e);
        goto L125
    L47:
        r9.f34961e.ap = r10.getBoolean(r1, r9.f34961e.ap);
        goto L125
    L48:
        r9.f34961e.al = r10.getString(r1);
        goto L125
    L49:
        r9.f34961e.ai = r10.getDimensionPixelSize(r1, r9.f34961e.ai);
        goto L125
    L50:
        r9.f34961e.ah = r10.getInt(r1, r9.f34961e.ah);
        goto L125
    L51:
        c(TAG, "CURRENTLY UNSUPPORTED");
        goto L125
    L52:
        r9.f34961e.ag = r10.getFloat(r1, 1.0f);
        goto L125
    L53:
        r9.f34961e.af = r10.getFloat(r1, 1.0f);
        goto L125
    L54:
        r9.f34959c.f34982e = r10.getFloat(r1, r9.f34959c.f34982e);
        goto L125
    L55:
        r9.f34960d.i = r10.getFloat(r1, r9.f34960d.i);
        goto L125
    L56:
        r9.f34960d.f = r10.getInt(r1, 0);
        goto L125
    L61:
        r9.f34960d.f34974b = b(r10, r1, r9.f34960d.f34974b);
        goto L125
    L62:
        r9.f34961e.D = r10.getFloat(r1, r9.f34961e.D);
        goto L125
    L63:
        r9.f34961e.C = r10.getDimensionPixelSize(r1, r9.f34961e.C);
        goto L125
    L64:
        r9.f34961e.B = b(r10, r1, r9.f34961e.B);
        goto L125
    L65:
        r9.f.f34984b = r10.getFloat(r1, r9.f.f34984b);
        goto L125
    L66:
        r9.f34961e.ae = r10.getDimensionPixelSize(r1, r9.f34961e.ae);
        goto L125
    L67:
        r9.f34961e.ad = r10.getDimensionPixelSize(r1, r9.f34961e.ad);
        goto L125
    L68:
        r9.f34961e.ac = r10.getDimensionPixelSize(r1, r9.f34961e.ac);
        goto L125
    L69:
        r9.f34961e.ab = r10.getDimensionPixelSize(r1, r9.f34961e.ab);
        goto L125
    L70:
        r9.f34961e.aa = r10.getInt(r1, r9.f34961e.aa);
        goto L125
    L71:
        r9.f34961e.Z = r10.getInt(r1, r9.f34961e.Z);
        goto L125
    L72:
        r9.f.l = r10.getDimension(r1, r9.f.l);
        goto L125
    L73:
        r9.f.k = r10.getDimension(r1, r9.f.k);
        goto L125
    L74:
        r9.f.j = r10.getDimension(r1, r9.f.j);
        goto L125
    L75:
        r9.f.h = r10.getDimension(r1, r9.f.h);
        goto L125
    L76:
        r9.f.g = r10.getDimension(r1, r9.f.g);
        goto L125
    L77:
        r9.f.f = r10.getFloat(r1, r9.f.f);
        goto L125
    L78:
        r9.f.f34987e = r10.getFloat(r1, r9.f.f34987e);
        goto L125
    L79:
        r9.f.f34986d = r10.getFloat(r1, r9.f.f34986d);
        goto L125
    L80:
        r9.f.f34985c = r10.getFloat(r1, r9.f.f34985c);
        goto L125
    L81:
        r9.f.m = true;
        r9.f.n = r10.getDimension(r1, r9.f.n);
        goto L125
    L82:
        r9.f34959c.f34981d = r10.getFloat(r1, r9.f34959c.f34981d);
        goto L125
    L83:
        r9.f34961e.Y = r10.getInt(r1, r9.f34961e.Y);
        goto L125
    L84:
        r9.f34961e.X = r10.getInt(r1, r9.f34961e.X);
        goto L125
    L85:
        r9.f34961e.V = r10.getFloat(r1, r9.f34961e.V);
        goto L125
    L86:
        r9.f34961e.W = r10.getFloat(r1, r9.f34961e.W);
        goto L125
    L87:
        r9.f34957a = r10.getResourceId(r1, r9.f34957a);
        goto L125
    L88:
        r9.f34961e.z = r10.getFloat(r1, r9.f34961e.z);
        goto L125
    L89:
        r9.f34961e.n = b(r10, r1, r9.f34961e.n);
        goto L125
    L90:
        r9.f34961e.o = b(r10, r1, r9.f34961e.o);
        goto L125
    L91:
        r9.f34961e.f34967J = r10.getDimensionPixelSize(r1, r9.f34961e.f34967J);
        goto L125
    L92:
        r9.f34961e.v = b(r10, r1, r9.f34961e.v);
        goto L125
    L93:
        r9.f34961e.u = b(r10, r1, r9.f34961e.u);
        goto L125
    L94:
        r9.f34961e.M = r10.getDimensionPixelSize(r1, r9.f34961e.M);
        goto L125
    L95:
        r9.f34961e.m = b(r10, r1, r9.f34961e.m);
        goto L125
    L96:
        r9.f34961e.l = b(r10, r1, r9.f34961e.l);
        goto L125
    L97:
        r9.f34961e.I = r10.getDimensionPixelSize(r1, r9.f34961e.I);
        goto L125
    L98:
        r9.f34961e.G = r10.getInt(r1, r9.f34961e.G);
        goto L125
    L99:
        r9.f34961e.k = b(r10, r1, r9.f34961e.k);
        goto L125
    L100:
        r9.f34961e.j = b(r10, r1, r9.f34961e.j);
        goto L125
    L101:
        r9.f34961e.H = r10.getDimensionPixelSize(r1, r9.f34961e.H);
        goto L125
    L102:
        r9.f34961e.f34971d = r10.getLayoutDimension(r1, r9.f34961e.f34971d);
        goto L125
    L103:
        r9.f34959c.f34979b = r10.getInt(r1, r9.f34959c.f34979b);
        r9.f34959c.f34979b = h[r9.f34959c.f34979b];
        goto L125
    L104:
        r9.f34961e.f34972e = r10.getLayoutDimension(r1, r9.f34961e.f34972e);
        goto L125
    L105:
        r9.f34961e.y = r10.getFloat(r1, r9.f34961e.y);
        goto L125
    L106:
        r9.f34961e.h = r10.getFloat(r1, r9.f34961e.h);
        goto L125
    L107:
        r9.f34961e.g = r10.getDimensionPixelOffset(r1, r9.f34961e.g);
        goto L125
    L108:
        r9.f34961e.f = r10.getDimensionPixelOffset(r1, r9.f34961e.f);
        goto L125
    L109:
        r9.f34961e.P = r10.getDimensionPixelSize(r1, r9.f34961e.P);
        goto L125
    L110:
        r9.f34961e.T = r10.getDimensionPixelSize(r1, r9.f34961e.T);
        goto L125
    L111:
        r9.f34961e.Q = r10.getDimensionPixelSize(r1, r9.f34961e.Q);
        goto L125
    L112:
        r9.f34961e.O = r10.getDimensionPixelSize(r1, r9.f34961e.O);
        goto L125
    L113:
        r9.f34961e.S = r10.getDimensionPixelSize(r1, r9.f34961e.S);
        goto L125
    L114:
        r9.f34961e.R = r10.getDimensionPixelSize(r1, r9.f34961e.R);
        goto L125
    L115:
        r9.f34961e.w = b(r10, r1, r9.f34961e.w);
        goto L125
    L116:
        r9.f34961e.x = b(r10, r1, r9.f34961e.x);
        goto L125
    L117:
        r9.f34961e.L = r10.getDimensionPixelSize(r1, r9.f34961e.L);
        goto L125
    L118:
        r9.f34961e.F = r10.getDimensionPixelOffset(r1, r9.f34961e.F);
        goto L125
    L119:
        r9.f34961e.E = r10.getDimensionPixelOffset(r1, r9.f34961e.E);
        goto L125
    L120:
        r9.f34961e.A = r10.getString(r1);
        goto L125
    L121:
        r9.f34961e.p = b(r10, r1, r9.f34961e.p);
        goto L125
    L122:
        r9.f34961e.q = b(r10, r1, r9.f34961e.q);
        goto L125
    L123:
        r9.f34961e.K = r10.getDimensionPixelSize(r1, r9.f34961e.K);
        goto L125
    L124:
        r9.f34961e.r = b(r10, r1, r9.f34961e.r);
        goto L125
    L58:
        if (r10.peekValue(r1).type != 3) goto L60;
        r9.f34960d.f34976d = r10.getString(r1);
        goto L125
    L60:
        r9.f34960d.f34976d = com.obric.oui.constraintlayout.a.a.a.c.f34592c[r10.getInteger(r1, 0)];
        goto L125
    L127:
        if (r9.f34961e.al == null) goto L231;
        r9.f34961e.ak = null;
        return;
    }

    private int[] a(View r10, String r11) {
        String[] r9 = r11.split(",");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int[] r1 = new int[r9.length];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r9.length) goto L23;
        String r5 = r9[r3].trim();
        int r6 = R.id.class.getField(r5).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r6 != 0) goto L11;
        r6 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"), r5, DbHelper.COL_ID, r12.getPackageName(), "com.obric.aiagent.plugin");
    L11:
        if (r6 != 0) goto L21;
        if (r10.isInEditMode() == false) goto L21;
        if (ZeusTransformUtils.instanceOf(r10.getParent(), ConstraintLayout.class) == false) goto L21;
        Object r7 = ((ConstraintLayout) ZeusTransformUtils.preCheckCast(r10.getParent(), ConstraintLayout.class, "com.obric.aiagent.plugin")).getDesignInformation(0, r5);
        if (r7 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L21;
        r6 = ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L21:
        r1[r4] = r6;
        r3 = r3 + 1;
        r4 = r4 + 1;
    L8:
        r6 = 0;
        goto L9
    L23:
        if (r4 != r9.length) goto L25;
        return r1;
    L25:
        return Arrays.copyOf(r1, r4);
    }

    public a f(int r3) {
        if (this.i.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return null;
    L5:
        return (a) ZeusTransformUtils.preCheckCast(this.i.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
    }

    public int[] b() {
        int r0 = 0;
        Integer[] r4 = (Integer[]) ZeusTransformUtils.preCheckCast(this.i.keySet().toArray(new Integer[0]), Integer[].class, "com.obric.aiagent.plugin");
        int r1 = r4.length;
        int[] r2 = new int[r1];
    L3:
        if (r0 >= r1) goto L5;
        r2[r0] = r4[r0].intValue();
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }

    public void a(boolean r1) {
        this.g = r1;
    }

    public void b(boolean r1) {
        this.f34955d = r1;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
