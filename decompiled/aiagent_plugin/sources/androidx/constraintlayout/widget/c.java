package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.a.c.j;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
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
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String TAG = "ConstraintSet";
    private static final int[] g = null;
    private static SparseIntArray i;
    private static SparseIntArray j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.a> f972e;
    private boolean f;
    private HashMap<Integer, a> h;

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C0020c f976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f977e;
        public final e f;
        public HashMap<String, androidx.constraintlayout.widget.a> g;
        C0019a h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ConstraintSet.java */
        static class C0019a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int[] f978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int[] f979b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f980c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f981d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            float[] f982e;
            int f;
            int[] g;
            String[] h;
            int i;
            int[] j;
            boolean[] k;
            int l;

            C0019a() {
                this.f978a = new int[10];
                this.f979b = new int[10];
                this.f980c = 0;
                this.f981d = new int[10];
                this.f982e = new float[10];
                this.f = 0;
                this.g = new int[5];
                this.h = new String[5];
                this.i = 0;
                this.j = new int[4];
                this.k = new boolean[4];
                this.l = 0;
            }

            void a(int r4, int r5) {
                int r0 = this.f980c;
                int[] r1 = this.f978a;
                if (r0 < r1.length) goto L5;
                this.f978a = Arrays.copyOf(r1, r1.length * 2);
                int[] r2 = this.f979b;
                this.f979b = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.f978a;
                int r6 = this.f980c;
                r3[r6] = r4;
                int[] r7 = this.f979b;
                this.f980c = r6 + 1;
                r7[r6] = r5;
            }

            void a(int r4, float r5) {
                int r0 = this.f;
                int[] r1 = this.f981d;
                if (r0 < r1.length) goto L5;
                this.f981d = Arrays.copyOf(r1, r1.length * 2);
                float[] r2 = this.f982e;
                this.f982e = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.f981d;
                int r6 = this.f;
                r3[r6] = r4;
                float[] r7 = this.f982e;
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
                if (r1 >= this.f980c) goto L6;
                c.a(r5, this.f978a[r1], this.f979b[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                int r2 = 0;
            L8:
                if (r2 >= this.f) goto L10;
                c.a(r5, this.f981d[r2], this.f982e[r2]);
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
            this.f975c = new d();
            this.f976d = new C0020c();
            this.f977e = new b();
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
            C0019a r0 = this.h;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        public a a() {
            a r0 = new a();
            r0.f977e.a(this.f977e);
            r0.f976d.a(this.f976d);
            r0.f975c.a(this.f975c);
            r0.f.a(this.f);
            r0.f973a = this.f973a;
            r0.h = this.h;
            return r0;
        }

        private void a(ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            a(r2, r3);
            if (ZeusTransformUtils.instanceOf(r1, Barrier.class) == false) goto L6;
            this.f977e.aj = 1;
            Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r1, Barrier.class, "com.obric.aiagent.plugin");
            b r5 = this.f977e;
            r5.ah = r4.getType();
            b r6 = this.f977e;
            r6.ak = r4.getReferencedIds();
            b r0 = this.f977e;
            r0.ai = r4.getMargin();
            return;
        }

        private void a(int r2, Constraints.LayoutParams r3) {
            a(r2, r3);
            d r4 = this.f975c;
            r4.f997d = r3.alpha;
            e r5 = this.f;
            r5.f1000b = r3.rotation;
            e r6 = this.f;
            r6.f1001c = r3.rotationX;
            e r7 = this.f;
            r7.f1002d = r3.rotationY;
            e r8 = this.f;
            r8.f1003e = r3.scaleX;
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
            this.f973a = r2;
            b r4 = this.f977e;
            r4.j = r3.leftToLeft;
            b r5 = this.f977e;
            r5.k = r3.leftToRight;
            b r6 = this.f977e;
            r6.l = r3.rightToLeft;
            b r7 = this.f977e;
            r7.m = r3.rightToRight;
            b r8 = this.f977e;
            r8.n = r3.topToTop;
            b r9 = this.f977e;
            r9.o = r3.topToBottom;
            b r10 = this.f977e;
            r10.p = r3.bottomToTop;
            b r11 = this.f977e;
            r11.q = r3.bottomToBottom;
            b r12 = this.f977e;
            r12.r = r3.baselineToBaseline;
            b r13 = this.f977e;
            r13.s = r3.baselineToTop;
            b r14 = this.f977e;
            r14.t = r3.baselineToBottom;
            b r15 = this.f977e;
            r15.u = r3.startToEnd;
            b r16 = this.f977e;
            r16.v = r3.startToStart;
            b r17 = this.f977e;
            r17.w = r3.endToStart;
            b r18 = this.f977e;
            r18.x = r3.endToEnd;
            b r19 = this.f977e;
            r19.y = r3.horizontalBias;
            b r20 = this.f977e;
            r20.z = r3.verticalBias;
            b r21 = this.f977e;
            r21.A = r3.dimensionRatio;
            b r22 = this.f977e;
            r22.B = r3.circleConstraint;
            b r23 = this.f977e;
            r23.C = r3.circleRadius;
            b r24 = this.f977e;
            r24.D = r3.circleAngle;
            b r25 = this.f977e;
            r25.E = r3.editorAbsoluteX;
            b r26 = this.f977e;
            r26.F = r3.editorAbsoluteY;
            b r27 = this.f977e;
            r27.G = r3.orientation;
            b r28 = this.f977e;
            r28.h = r3.guidePercent;
            b r29 = this.f977e;
            r29.f = r3.guideBegin;
            b r30 = this.f977e;
            r30.g = r3.guideEnd;
            b r31 = this.f977e;
            r31.f987d = r3.width;
            b r32 = this.f977e;
            r32.f988e = r3.height;
            b r33 = this.f977e;
            r33.H = r3.leftMargin;
            b r34 = this.f977e;
            r34.I = r3.rightMargin;
            b r35 = this.f977e;
            r35.f983J = r3.topMargin;
            b r36 = this.f977e;
            r36.K = r3.bottomMargin;
            b r37 = this.f977e;
            r37.N = r3.baselineMargin;
            b r38 = this.f977e;
            r38.V = r3.verticalWeight;
            b r39 = this.f977e;
            r39.W = r3.horizontalWeight;
            b r40 = this.f977e;
            r40.Y = r3.verticalChainStyle;
            b r41 = this.f977e;
            r41.X = r3.horizontalChainStyle;
            b r42 = this.f977e;
            r42.an = r3.constrainedWidth;
            b r43 = this.f977e;
            r43.ao = r3.constrainedHeight;
            b r44 = this.f977e;
            r44.Z = r3.matchConstraintDefaultWidth;
            b r45 = this.f977e;
            r45.aa = r3.matchConstraintDefaultHeight;
            b r46 = this.f977e;
            r46.ab = r3.matchConstraintMaxWidth;
            b r47 = this.f977e;
            r47.ac = r3.matchConstraintMaxHeight;
            b r48 = this.f977e;
            r48.ad = r3.matchConstraintMinWidth;
            b r49 = this.f977e;
            r49.ae = r3.matchConstraintMinHeight;
            b r50 = this.f977e;
            r50.af = r3.matchConstraintPercentWidth;
            b r51 = this.f977e;
            r51.ag = r3.matchConstraintPercentHeight;
            b r52 = this.f977e;
            r52.am = r3.constraintTag;
            b r53 = this.f977e;
            r53.P = r3.goneTopMargin;
            b r54 = this.f977e;
            r54.R = r3.goneBottomMargin;
            b r55 = this.f977e;
            r55.O = r3.goneLeftMargin;
            b r56 = this.f977e;
            r56.Q = r3.goneRightMargin;
            b r57 = this.f977e;
            r57.T = r3.goneStartMargin;
            b r58 = this.f977e;
            r58.S = r3.goneEndMargin;
            b r59 = this.f977e;
            r59.U = r3.goneBaselineMargin;
            b r60 = this.f977e;
            r60.aq = r3.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT < 17) goto L6;
            b r61 = this.f977e;
            r61.L = r3.getMarginEnd();
            b r1 = this.f977e;
            r1.M = r3.getMarginStart();
            return;
        }

        public void a(ConstraintLayout.LayoutParams r3) {
            r3.leftToLeft = this.f977e.j;
            r3.leftToRight = this.f977e.k;
            r3.rightToLeft = this.f977e.l;
            r3.rightToRight = this.f977e.m;
            r3.topToTop = this.f977e.n;
            r3.topToBottom = this.f977e.o;
            r3.bottomToTop = this.f977e.p;
            r3.bottomToBottom = this.f977e.q;
            r3.baselineToBaseline = this.f977e.r;
            r3.baselineToTop = this.f977e.s;
            r3.baselineToBottom = this.f977e.t;
            r3.startToEnd = this.f977e.u;
            r3.startToStart = this.f977e.v;
            r3.endToStart = this.f977e.w;
            r3.endToEnd = this.f977e.x;
            r3.leftMargin = this.f977e.H;
            r3.rightMargin = this.f977e.I;
            r3.topMargin = this.f977e.f983J;
            r3.bottomMargin = this.f977e.K;
            r3.goneStartMargin = this.f977e.T;
            r3.goneEndMargin = this.f977e.S;
            r3.goneTopMargin = this.f977e.P;
            r3.goneBottomMargin = this.f977e.R;
            r3.horizontalBias = this.f977e.y;
            r3.verticalBias = this.f977e.z;
            r3.circleConstraint = this.f977e.B;
            r3.circleRadius = this.f977e.C;
            r3.circleAngle = this.f977e.D;
            r3.dimensionRatio = this.f977e.A;
            r3.editorAbsoluteX = this.f977e.E;
            r3.editorAbsoluteY = this.f977e.F;
            r3.verticalWeight = this.f977e.V;
            r3.horizontalWeight = this.f977e.W;
            r3.verticalChainStyle = this.f977e.Y;
            r3.horizontalChainStyle = this.f977e.X;
            r3.constrainedWidth = this.f977e.an;
            r3.constrainedHeight = this.f977e.ao;
            r3.matchConstraintDefaultWidth = this.f977e.Z;
            r3.matchConstraintDefaultHeight = this.f977e.aa;
            r3.matchConstraintMaxWidth = this.f977e.ab;
            r3.matchConstraintMaxHeight = this.f977e.ac;
            r3.matchConstraintMinWidth = this.f977e.ad;
            r3.matchConstraintMinHeight = this.f977e.ae;
            r3.matchConstraintPercentWidth = this.f977e.af;
            r3.matchConstraintPercentHeight = this.f977e.ag;
            r3.orientation = this.f977e.G;
            r3.guidePercent = this.f977e.h;
            r3.guideBegin = this.f977e.f;
            r3.guideEnd = this.f977e.g;
            r3.width = this.f977e.f987d;
            r3.height = this.f977e.f988e;
            if (this.f977e.am == null) goto L5;
            r3.constraintTag = this.f977e.am;
        L5:
            r3.wrapBehaviorInParent = this.f977e.aq;
            if (Build.VERSION.SDK_INT < 17) goto L8;
            r3.setMarginStart(this.f977e.M);
            r3.setMarginEnd(this.f977e.L);
        L8:
            r3.validate();
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
        public int f983J;
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
        public boolean f984a;
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
        public boolean f985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f987d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f988e;
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
            this.f984a = false;
            this.f985b = false;
            this.f986c = false;
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
            this.f983J = 0;
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
            this.f984a = r3.f984a;
            this.f987d = r3.f987d;
            this.f985b = r3.f985b;
            this.f988e = r3.f988e;
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
            this.f983J = r3.f983J;
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
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedWidth, "styleable", "Layout_layout_constrainedWidth"), 41);
            ar.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedHeight, "styleable", "Layout_layout_constrainedHeight"), 42);
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
        }

        void a(Context r9, AttributeSet r10) {
            TypedArray r11 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Layout);
            this.f985b = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L83;
            int r3 = r11.getIndex(r2);
            int r4 = ar.get(r3);
            switch(r4) {
                case 1: goto L81;
                case 2: goto L80;
                case 3: goto L79;
                case 4: goto L78;
                case 5: goto L77;
                case 6: goto L76;
                case 7: goto L75;
                case 8: goto L73;
                case 9: goto L71;
                case 10: goto L70;
                case 11: goto L69;
                case 12: goto L68;
                case 13: goto L67;
                case 14: goto L66;
                case 15: goto L65;
                case 16: goto L64;
                case 17: goto L63;
                case 18: goto L62;
                case 19: goto L61;
                case 20: goto L60;
                case 21: goto L59;
                case 22: goto L58;
                case 23: goto L57;
                case 24: goto L56;
                case 25: goto L55;
                case 26: goto L54;
                case 27: goto L53;
                case 28: goto L52;
                case 29: goto L51;
                case 30: goto L49;
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
        L82:
            r2 = r2 + 1;
            goto L3
        L34:
            this.C = r11.getDimensionPixelSize(r3, this.C);
            goto L82
        L35:
            this.B = c.a(r11, r3, this.B);
            goto L82
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
            goto L82
        L10:
            b(c.TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + ar.get(r3));
            goto L82
        L11:
            this.i = r11.getBoolean(r3, this.i);
            goto L82
        L12:
            this.am = r11.getString(r3);
            goto L82
        L13:
            this.ao = r11.getBoolean(r3, this.ao);
            goto L82
        L14:
            this.an = r11.getBoolean(r3, this.an);
            goto L82
        L15:
            this.ad = r11.getDimensionPixelSize(r3, this.ad);
            goto L82
        L16:
            this.ae = r11.getDimensionPixelSize(r3, this.ae);
            goto L82
        L17:
            this.ab = r11.getDimensionPixelSize(r3, this.ab);
            goto L82
        L18:
            this.ac = r11.getDimensionPixelSize(r3, this.ac);
            goto L82
        L19:
            this.aa = r11.getInt(r3, this.aa);
            goto L82
        L20:
            this.Z = r11.getInt(r3, this.Z);
            goto L82
        L21:
            this.N = r11.getDimensionPixelSize(r3, this.N);
            goto L82
        L22:
            this.U = r11.getDimensionPixelSize(r3, this.U);
            goto L82
        L23:
            this.t = c.a(r11, r3, this.t);
            goto L82
        L24:
            this.s = c.a(r11, r3, this.s);
            goto L82
        L25:
            this.aq = r11.getInt(r3, this.aq);
            goto L82
        L26:
            this.ap = r11.getBoolean(r3, this.ap);
            goto L82
        L27:
            this.al = r11.getString(r3);
            goto L82
        L28:
            this.ai = r11.getDimensionPixelSize(r3, this.ai);
            goto L82
        L29:
            this.ah = r11.getInt(r3, this.ah);
            goto L82
        L30:
            a(c.TAG, "CURRENTLY UNSUPPORTED");
            goto L82
        L31:
            this.ag = r11.getFloat(r3, 1.0f);
            goto L82
        L32:
            this.af = r11.getFloat(r3, 1.0f);
            goto L82
        L36:
            c.a(this, r11, r3, 1);
            goto L82
        L37:
            c.a(this, r11, r3, 0);
            goto L82
        L38:
            this.Y = r11.getInt(r3, this.Y);
            goto L82
        L39:
            this.X = r11.getInt(r3, this.X);
            goto L82
        L40:
            this.V = r11.getFloat(r3, this.V);
            goto L82
        L41:
            this.W = r11.getFloat(r3, this.W);
            goto L82
        L42:
            this.z = r11.getFloat(r3, this.z);
            goto L82
        L43:
            this.n = c.a(r11, r3, this.n);
            goto L82
        L44:
            this.o = c.a(r11, r3, this.o);
            goto L82
        L45:
            this.f983J = r11.getDimensionPixelSize(r3, this.f983J);
            goto L82
        L46:
            this.v = c.a(r11, r3, this.v);
            goto L82
        L47:
            this.u = c.a(r11, r3, this.u);
            goto L82
        L51:
            this.m = c.a(r11, r3, this.m);
            goto L82
        L52:
            this.l = c.a(r11, r3, this.l);
            goto L82
        L53:
            this.I = r11.getDimensionPixelSize(r3, this.I);
            goto L82
        L54:
            this.G = r11.getInt(r3, this.G);
            goto L82
        L55:
            this.k = c.a(r11, r3, this.k);
            goto L82
        L56:
            this.j = c.a(r11, r3, this.j);
            goto L82
        L57:
            this.H = r11.getDimensionPixelSize(r3, this.H);
            goto L82
        L58:
            this.f987d = r11.getLayoutDimension(r3, this.f987d);
            goto L82
        L59:
            this.f988e = r11.getLayoutDimension(r3, this.f988e);
            goto L82
        L60:
            this.y = r11.getFloat(r3, this.y);
            goto L82
        L61:
            this.h = r11.getFloat(r3, this.h);
            goto L82
        L62:
            this.g = r11.getDimensionPixelOffset(r3, this.g);
            goto L82
        L63:
            this.f = r11.getDimensionPixelOffset(r3, this.f);
            goto L82
        L64:
            this.P = r11.getDimensionPixelSize(r3, this.P);
            goto L82
        L65:
            this.T = r11.getDimensionPixelSize(r3, this.T);
            goto L82
        L66:
            this.Q = r11.getDimensionPixelSize(r3, this.Q);
            goto L82
        L67:
            this.O = r11.getDimensionPixelSize(r3, this.O);
            goto L82
        L68:
            this.S = r11.getDimensionPixelSize(r3, this.S);
            goto L82
        L69:
            this.R = r11.getDimensionPixelSize(r3, this.R);
            goto L82
        L70:
            this.w = c.a(r11, r3, this.w);
            goto L82
        L71:
            this.x = c.a(r11, r3, this.x);
            goto L82
        L75:
            this.F = r11.getDimensionPixelOffset(r3, this.F);
            goto L82
        L76:
            this.E = r11.getDimensionPixelOffset(r3, this.E);
            goto L82
        L77:
            this.A = r11.getString(r3);
            goto L82
        L78:
            this.p = c.a(r11, r3, this.p);
            goto L82
        L79:
            this.q = c.a(r11, r3, this.q);
            goto L82
        L80:
            this.K = r11.getDimensionPixelSize(r3, this.K);
            goto L82
        L81:
            this.r = c.a(r11, r3, this.r);
            goto L82
        L49:
            if (Build.VERSION.SDK_INT < 17) goto L82;
            this.M = r11.getDimensionPixelSize(r3, this.M);
            goto L82
        L73:
            if (Build.VERSION.SDK_INT < 17) goto L82;
            this.L = r11.getDimensionPixelSize(r3, this.L);
            goto L82
        L83:
            r11.recycle();
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class C0020c {
        private static SparseIntArray o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f991c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f993e;
        public int f;
        public float g;
        public int h;
        public float i;
        public float j;
        public int k;
        public String l;
        public int m;
        public int n;

        public C0020c() {
            this.f989a = false;
            this.f990b = -1;
            this.f991c = 0;
            this.f992d = null;
            this.f993e = -1;
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

        public void a(C0020c r2) {
            this.f989a = r2.f989a;
            this.f990b = r2.f990b;
            this.f992d = r2.f992d;
            this.f993e = r2.f993e;
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
            this.f989a = true;
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
            this.f991c = r12.getInteger(r3, this.f991c);
            goto L31
        L23:
            this.f990b = c.a(r12, r3, this.f990b);
            goto L31
        L24:
            this.f = r12.getInt(r3, 0);
            goto L31
        L29:
            this.f993e = r12.getInt(r3, this.f993e);
            goto L31
        L30:
            this.i = r12.getFloat(r3, this.i);
            goto L31
        L26:
            if (r12.peekValue(r3).type != 3) goto L28;
            this.f992d = r12.getString(r3);
            goto L31
        L28:
            this.f992d = androidx.constraintlayout.a.a.a.c.f615c[r12.getInteger(r3, 0)];
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
        public boolean f994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f998e;

        public d() {
            this.f994a = false;
            this.f995b = 0;
            this.f996c = 0;
            this.f997d = 1.0f;
            this.f998e = Float.NaN;
        }

        public void a(d r2) {
            this.f994a = r2.f994a;
            this.f995b = r2.f995b;
            this.f997d = r2.f997d;
            this.f998e = r2.f998e;
            this.f996c = r2.f996c;
        }

        void a(Context r6, AttributeSet r7) {
            TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.PropertySet);
            this.f994a = true;
            int r9 = r8.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L17;
            int r1 = r8.getIndex(r0);
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_alpha, "styleable", "PropertySet_android_alpha")) goto L8;
            this.f997d = r8.getFloat(r1, this.f997d);
        L16:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_visibility, "styleable", "PropertySet_android_visibility")) goto L11;
            this.f995b = r8.getInt(r1, this.f995b);
            this.f995b = c.b()[this.f995b];
            goto L16
        L11:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_visibilityMode, "styleable", "PropertySet_visibilityMode")) goto L14;
            this.f996c = r8.getInt(r1, this.f996c);
            goto L16
        L14:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_motionProgress, "styleable", "PropertySet_motionProgress")) goto L16;
            this.f998e = r8.getFloat(r1, this.f998e);
            goto L16
        L17:
            r8.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintSet.java */
    public static class e {
        private static SparseIntArray o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f1003e;
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
            this.f999a = false;
            this.f1000b = 0.0f;
            this.f1001c = 0.0f;
            this.f1002d = 0.0f;
            this.f1003e = 1.0f;
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
            this.f999a = r2.f999a;
            this.f1000b = r2.f1000b;
            this.f1001c = r2.f1001c;
            this.f1002d = r2.f1002d;
            this.f1003e = r2.f1003e;
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

        void a(Context r6, AttributeSet r7) {
            TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.Transform);
            this.f999a = true;
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L24;
            int r2 = r8.getIndex(r1);
            switch(o.get(r2)) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L12;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L23;
            };
        L7:
            this.i = c.a(r8, r2, this.i);
            goto L23
        L14:
            this.k = r8.getDimension(r2, this.k);
            goto L23
        L15:
            this.j = r8.getDimension(r2, this.j);
            goto L23
        L16:
            this.h = r8.getDimension(r2, this.h);
            goto L23
        L17:
            this.g = r8.getDimension(r2, this.g);
            goto L23
        L18:
            this.f = r8.getFloat(r2, this.f);
            goto L23
        L19:
            this.f1003e = r8.getFloat(r2, this.f1003e);
            goto L23
        L20:
            this.f1002d = r8.getFloat(r2, this.f1002d);
            goto L23
        L21:
            this.f1001c = r8.getFloat(r2, this.f1001c);
            goto L23
        L22:
            this.f1000b = r8.getFloat(r2, this.f1000b);
            goto L23
        L9:
            if (Build.VERSION.SDK_INT < 21) goto L23;
            this.m = true;
            this.n = r8.getDimension(r2, this.n);
            goto L23
        L12:
            if (Build.VERSION.SDK_INT < 21) goto L23;
            this.l = r8.getDimension(r2, this.l);
        L23:
            r1 = r1 + 1;
            goto L3
        L24:
            r8.recycle();
        }
    }

    private String h(int r1) {
        switch(r1) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return "end";
    L7:
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    public c() {
        this.f969b = "";
        this.f970c = 0;
        this.f972e = new HashMap();
        this.f = true;
        this.h = new HashMap();
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

    static /* synthetic */ int[] b() {
        return g;
    }

    static {
        g = new int[]{0, 4, 8};
        i = new SparseIntArray();
        j = new SparseIntArray();
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toLeftOf, "styleable", "Constraint_layout_constraintLeft_toLeftOf"), 25);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toRightOf, "styleable", "Constraint_layout_constraintLeft_toRightOf"), 26);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toLeftOf, "styleable", "Constraint_layout_constraintRight_toLeftOf"), 29);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toRightOf, "styleable", "Constraint_layout_constraintRight_toRightOf"), 30);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toTopOf, "styleable", "Constraint_layout_constraintTop_toTopOf"), 36);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toBottomOf, "styleable", "Constraint_layout_constraintTop_toBottomOf"), 35);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toTopOf, "styleable", "Constraint_layout_constraintBottom_toTopOf"), 4);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toBottomOf, "styleable", "Constraint_layout_constraintBottom_toBottomOf"), 3);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, "styleable", "Constraint_layout_constraintBaseline_toBaselineOf"), 1);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toTopOf, "styleable", "Constraint_layout_constraintBaseline_toTopOf"), 91);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, "styleable", "Constraint_layout_constraintBaseline_toBottomOf"), 92);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteX, "styleable", "Constraint_layout_editor_absoluteX"), 6);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteY, "styleable", "Constraint_layout_editor_absoluteY"), 7);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_begin, "styleable", "Constraint_layout_constraintGuide_begin"), 17);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_end, "styleable", "Constraint_layout_constraintGuide_end"), 18);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_percent, "styleable", "Constraint_layout_constraintGuide_percent"), 19);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_guidelineUseRtl, "styleable", "Constraint_guidelineUseRtl"), 99);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_orientation, "styleable", "Constraint_android_orientation"), 27);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toEndOf, "styleable", "Constraint_layout_constraintStart_toEndOf"), 32);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toStartOf, "styleable", "Constraint_layout_constraintStart_toStartOf"), 33);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toStartOf, "styleable", "Constraint_layout_constraintEnd_toStartOf"), 10);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toEndOf, "styleable", "Constraint_layout_constraintEnd_toEndOf"), 9);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginLeft, "styleable", "Constraint_layout_goneMarginLeft"), 13);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginTop, "styleable", "Constraint_layout_goneMarginTop"), 16);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginRight, "styleable", "Constraint_layout_goneMarginRight"), 14);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginBottom, "styleable", "Constraint_layout_goneMarginBottom"), 11);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginStart, "styleable", "Constraint_layout_goneMarginStart"), 15);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginEnd, "styleable", "Constraint_layout_goneMarginEnd"), 12);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_weight, "styleable", "Constraint_layout_constraintVertical_weight"), 40);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_weight, "styleable", "Constraint_layout_constraintHorizontal_weight"), 39);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, "styleable", "Constraint_layout_constraintHorizontal_chainStyle"), 41);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_chainStyle, "styleable", "Constraint_layout_constraintVertical_chainStyle"), 42);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_bias, "styleable", "Constraint_layout_constraintHorizontal_bias"), 20);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_bias, "styleable", "Constraint_layout_constraintVertical_bias"), 37);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintDimensionRatio, "styleable", "Constraint_layout_constraintDimensionRatio"), 5);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_creator, "styleable", "Constraint_layout_constraintLeft_creator"), 87);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_creator, "styleable", "Constraint_layout_constraintTop_creator"), 87);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_creator, "styleable", "Constraint_layout_constraintRight_creator"), 87);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_creator, "styleable", "Constraint_layout_constraintBottom_creator"), 87);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_creator, "styleable", "Constraint_layout_constraintBaseline_creator"), 87);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginLeft, "styleable", "Constraint_android_layout_marginLeft"), 24);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginRight, "styleable", "Constraint_android_layout_marginRight"), 28);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart"), 31);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd"), 8);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginTop, "styleable", "Constraint_android_layout_marginTop"), 34);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginBottom, "styleable", "Constraint_android_layout_marginBottom"), 2);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_width, "styleable", "Constraint_android_layout_width"), 23);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_height, "styleable", "Constraint_android_layout_height"), 21);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth, "styleable", "Constraint_layout_constraintWidth"), 95);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight, "styleable", "Constraint_layout_constraintHeight"), 96);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_visibility, "styleable", "Constraint_android_visibility"), 22);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_alpha, "styleable", "Constraint_android_alpha"), 43);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_elevation, "styleable", "Constraint_android_elevation"), 44);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationX, "styleable", "Constraint_android_rotationX"), 45);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationY, "styleable", "Constraint_android_rotationY"), 46);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotation, "styleable", "Constraint_android_rotation"), 60);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleX, "styleable", "Constraint_android_scaleX"), 47);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleY, "styleable", "Constraint_android_scaleY"), 48);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotX, "styleable", "Constraint_android_transformPivotX"), 49);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotY, "styleable", "Constraint_android_transformPivotY"), 50);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationX, "styleable", "Constraint_android_translationX"), 51);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationY, "styleable", "Constraint_android_translationY"), 52);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationZ, "styleable", "Constraint_android_translationZ"), 53);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_default, "styleable", "Constraint_layout_constraintWidth_default"), 54);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_default, "styleable", "Constraint_layout_constraintHeight_default"), 55);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_max, "styleable", "Constraint_layout_constraintWidth_max"), 56);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_max, "styleable", "Constraint_layout_constraintHeight_max"), 57);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_min, "styleable", "Constraint_layout_constraintWidth_min"), 58);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_min, "styleable", "Constraint_layout_constraintHeight_min"), 59);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircle, "styleable", "Constraint_layout_constraintCircle"), 61);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleRadius, "styleable", "Constraint_layout_constraintCircleRadius"), 62);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleAngle, "styleable", "Constraint_layout_constraintCircleAngle"), 63);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_animateRelativeTo, "styleable", "Constraint_animateRelativeTo"), 64);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionEasing, "styleable", "Constraint_transitionEasing"), 65);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_drawPath, "styleable", "Constraint_drawPath"), 66);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionPathRotate, "styleable", "Constraint_transitionPathRotate"), 67);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionStagger, "styleable", "Constraint_motionStagger"), 79);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id"), 38);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionProgress, "styleable", "Constraint_motionProgress"), 68);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_percent, "styleable", "Constraint_layout_constraintWidth_percent"), 69);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_percent, "styleable", "Constraint_layout_constraintHeight_percent"), 70);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_wrapBehaviorInParent, "styleable", "Constraint_layout_wrapBehaviorInParent"), 97);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_chainUseRtl, "styleable", "Constraint_chainUseRtl"), 71);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierDirection, "styleable", "Constraint_barrierDirection"), 72);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierMargin, "styleable", "Constraint_barrierMargin"), 73);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_constraint_referenced_ids, "styleable", "Constraint_constraint_referenced_ids"), 74);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierAllowsGoneWidgets, "styleable", "Constraint_barrierAllowsGoneWidgets"), 75);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_pathMotionArc, "styleable", "Constraint_pathMotionArc"), 76);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTag, "styleable", "Constraint_layout_constraintTag"), 77);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_visibilityMode, "styleable", "Constraint_visibilityMode"), 78);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedWidth, "styleable", "Constraint_layout_constrainedWidth"), 80);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedHeight, "styleable", "Constraint_layout_constrainedHeight"), 81);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_polarRelativeTo, "styleable", "Constraint_polarRelativeTo"), 82);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transformPivotTarget, "styleable", "Constraint_transformPivotTarget"), 83);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionSteps, "styleable", "Constraint_quantizeMotionSteps"), 84);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionPhase, "styleable", "Constraint_quantizeMotionPhase"), 85);
        i.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionInterpolator, "styleable", "Constraint_quantizeMotionInterpolator"), 86);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 6);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 7);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_orientation, "styleable", "ConstraintOverride_android_orientation"), 27);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginLeft, "styleable", "ConstraintOverride_layout_goneMarginLeft"), 13);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginTop, "styleable", "ConstraintOverride_layout_goneMarginTop"), 16);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginRight, "styleable", "ConstraintOverride_layout_goneMarginRight"), 14);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginBottom, "styleable", "ConstraintOverride_layout_goneMarginBottom"), 11);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginStart, "styleable", "ConstraintOverride_layout_goneMarginStart"), 15);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginEnd, "styleable", "ConstraintOverride_layout_goneMarginEnd"), 12);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_weight, "styleable", "ConstraintOverride_layout_constraintVertical_weight"), 40);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, "styleable", "ConstraintOverride_layout_constraintHorizontal_weight"), 39);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintOverride_layout_constraintHorizontal_chainStyle"), 41);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, "styleable", "ConstraintOverride_layout_constraintVertical_chainStyle"), 42);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, "styleable", "ConstraintOverride_layout_constraintHorizontal_bias"), 20);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_bias, "styleable", "ConstraintOverride_layout_constraintVertical_bias"), 37);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, "styleable", "ConstraintOverride_layout_constraintDimensionRatio"), 5);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintLeft_creator, "styleable", "ConstraintOverride_layout_constraintLeft_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTop_creator, "styleable", "ConstraintOverride_layout_constraintTop_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintRight_creator, "styleable", "ConstraintOverride_layout_constraintRight_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBottom_creator, "styleable", "ConstraintOverride_layout_constraintBottom_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, "styleable", "ConstraintOverride_layout_constraintBaseline_creator"), 87);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginLeft, "styleable", "ConstraintOverride_android_layout_marginLeft"), 24);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginRight, "styleable", "ConstraintOverride_android_layout_marginRight"), 28);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginStart, "styleable", "ConstraintOverride_android_layout_marginStart"), 31);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginEnd, "styleable", "ConstraintOverride_android_layout_marginEnd"), 8);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginTop, "styleable", "ConstraintOverride_android_layout_marginTop"), 34);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginBottom, "styleable", "ConstraintOverride_android_layout_marginBottom"), 2);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_width, "styleable", "ConstraintOverride_android_layout_width"), 23);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_height, "styleable", "ConstraintOverride_android_layout_height"), 21);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth, "styleable", "ConstraintOverride_layout_constraintWidth"), 95);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight, "styleable", "ConstraintOverride_layout_constraintHeight"), 96);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_visibility, "styleable", "ConstraintOverride_android_visibility"), 22);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_alpha, "styleable", "ConstraintOverride_android_alpha"), 43);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_elevation, "styleable", "ConstraintOverride_android_elevation"), 44);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationX, "styleable", "ConstraintOverride_android_rotationX"), 45);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationY, "styleable", "ConstraintOverride_android_rotationY"), 46);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotation, "styleable", "ConstraintOverride_android_rotation"), 60);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleX, "styleable", "ConstraintOverride_android_scaleX"), 47);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleY, "styleable", "ConstraintOverride_android_scaleY"), 48);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotX, "styleable", "ConstraintOverride_android_transformPivotX"), 49);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotY, "styleable", "ConstraintOverride_android_transformPivotY"), 50);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationX, "styleable", "ConstraintOverride_android_translationX"), 51);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationY, "styleable", "ConstraintOverride_android_translationY"), 52);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationZ, "styleable", "ConstraintOverride_android_translationZ"), 53);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_default, "styleable", "ConstraintOverride_layout_constraintWidth_default"), 54);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_default, "styleable", "ConstraintOverride_layout_constraintHeight_default"), 55);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_max, "styleable", "ConstraintOverride_layout_constraintWidth_max"), 56);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_max, "styleable", "ConstraintOverride_layout_constraintHeight_max"), 57);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_min, "styleable", "ConstraintOverride_layout_constraintWidth_min"), 58);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_min, "styleable", "ConstraintOverride_layout_constraintHeight_min"), 59);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleRadius, "styleable", "ConstraintOverride_layout_constraintCircleRadius"), 62);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleAngle, "styleable", "ConstraintOverride_layout_constraintCircleAngle"), 63);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_animateRelativeTo, "styleable", "ConstraintOverride_animateRelativeTo"), 64);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionEasing, "styleable", "ConstraintOverride_transitionEasing"), 65);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_drawPath, "styleable", "ConstraintOverride_drawPath"), 66);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionPathRotate, "styleable", "ConstraintOverride_transitionPathRotate"), 67);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionStagger, "styleable", "ConstraintOverride_motionStagger"), 79);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_id, "styleable", "ConstraintOverride_android_id"), 38);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionTarget, "styleable", "ConstraintOverride_motionTarget"), 98);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionProgress, "styleable", "ConstraintOverride_motionProgress"), 68);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_percent, "styleable", "ConstraintOverride_layout_constraintWidth_percent"), 69);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_percent, "styleable", "ConstraintOverride_layout_constraintHeight_percent"), 70);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_chainUseRtl, "styleable", "ConstraintOverride_chainUseRtl"), 71);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierDirection, "styleable", "ConstraintOverride_barrierDirection"), 72);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierMargin, "styleable", "ConstraintOverride_barrierMargin"), 73);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_constraint_referenced_ids, "styleable", "ConstraintOverride_constraint_referenced_ids"), 74);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, "styleable", "ConstraintOverride_barrierAllowsGoneWidgets"), 75);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_pathMotionArc, "styleable", "ConstraintOverride_pathMotionArc"), 76);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTag, "styleable", "ConstraintOverride_layout_constraintTag"), 77);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_visibilityMode, "styleable", "ConstraintOverride_visibilityMode"), 78);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedWidth, "styleable", "ConstraintOverride_layout_constrainedWidth"), 80);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedHeight, "styleable", "ConstraintOverride_layout_constrainedHeight"), 81);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_polarRelativeTo, "styleable", "ConstraintOverride_polarRelativeTo"), 82);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transformPivotTarget, "styleable", "ConstraintOverride_transformPivotTarget"), 83);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionSteps, "styleable", "ConstraintOverride_quantizeMotionSteps"), 84);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionPhase, "styleable", "ConstraintOverride_quantizeMotionPhase"), 85);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionInterpolator, "styleable", "ConstraintOverride_quantizeMotionInterpolator"), 86);
        j.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, "styleable", "ConstraintOverride_layout_wrapBehaviorInParent"), 97);
    }

    public a a(int r1) {
        return g(r1);
    }

    public void a(c r10) {
        Iterator<Integer> r0 = r10.h.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.aiagent.plugin");
        int r2 = r1.intValue();
        a r3 = (a) ZeusTransformUtils.preCheckCast(r10.h.get(r1), a.class, "com.obric.aiagent.plugin");
        if (this.h.containsKey(Integer.valueOf(r2)) == true) goto L8;
        this.h.put(Integer.valueOf(r2), new a());
    L8:
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r2)), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L4;
        if (r4.f977e.f985b == true) goto L15;
        r4.f977e.a(r3.f977e);
    L15:
        if (r4.f975c.f994a == true) goto L18;
        r4.f975c.a(r3.f975c);
    L18:
        if (r4.f.f999a == true) goto L21;
        r4.f.a(r3.f);
    L21:
        if (r4.f976d.f989a == true) goto L23;
        r4.f976d.a(r3.f976d);
    L23:
        Iterator<String> r5 = r3.g.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L4;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r4.g.containsKey(r6) == true) goto L25;
        r4.g.put(r6, (androidx.constraintlayout.widget.a) ZeusTransformUtils.preCheckCast(r3.g.get(r6), androidx.constraintlayout.widget.a.class, "com.obric.aiagent.plugin"));
        goto L25
    }

    public void a(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L43;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getId();
        if (this.f == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.h.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.h.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L42;
        if (r6.f977e.f985b == true) goto L26;
        a.a(r6, r4, r3);
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L24;
        r6.f977e.ak = ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.aiagent.plugin")).getReferencedIds();
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L24;
        Barrier r5 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.aiagent.plugin");
        r6.f977e.ap = r5.getAllowsGoneWidget();
        r6.f977e.ah = r5.getType();
        r6.f977e.ai = r5.getMargin();
    L24:
        r6.f977e.f985b = true;
    L26:
        if (r6.f975c.f994a == true) goto L29;
        r6.f975c.f995b = r2.getVisibility();
        r6.f975c.f997d = r2.getAlpha();
        r6.f975c.f994a = true;
    L29:
        if (Build.VERSION.SDK_INT < 17) goto L42;
        if (r6.f.f999a == true) goto L42;
        r6.f.f999a = true;
        r6.f.f1000b = r2.getRotation();
        r6.f.f1001c = r2.getRotationX();
        r6.f.f1002d = r2.getRotationY();
        r6.f.f1003e = r2.getScaleX();
        r6.f.f = r2.getScaleY();
        float r7 = r2.getPivotX();
        float r8 = r2.getPivotY();
        if (r7 == 0.0d) goto L35;
    L36:
        r6.f.g = r7;
        r6.f.h = r8;
    L37:
        r6.f.j = r2.getTranslationX();
        r6.f.k = r2.getTranslationY();
        if (Build.VERSION.SDK_INT < 21) goto L42;
        r6.f.l = r2.getTranslationZ();
        if (r6.f.m == false) goto L42;
        r6.f.n = r2.getElevation();
        goto L42
    L35:
        if (r8 == 0.0d) goto L37;
    L42:
        r1 = r1 + 1;
        goto L3
    }

    public void b(c r7) {
        Iterator<a> r8 = r7.h.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.aiagent.plugin");
        if (r0.h == null) goto L4;
        if (r0.f974b != null) goto L9;
        a r1 = f(r0.f973a);
        r0.h.a(r1);
        goto L4
    L9:
        Iterator<Integer> r2 = this.h.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L4;
        a r3 = f(((Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        if (r3.f977e.am == null) goto L11;
        if (r0.f974b.matches(r3.f977e.am) == false) goto L11;
        r0.h.a(r3);
        r3.g.putAll((HashMap) ZeusTransformUtils.preCheckCast(r0.g.clone(), HashMap.class, "com.obric.aiagent.plugin"));
        goto L11
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
        r10.f987d = r2;
        r10.an = r3;
        return;
    L30:
        r10.f988e = r2;
        r10.ao = r3;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r4, a.C0019a.class) == false) goto L44;
        a.C0019a r11 = (a.C0019a) ZeusTransformUtils.preCheckCast(r4, a.C0019a.class, "com.obric.aiagent.plugin");
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
        r8.dimensionRatioValue = r0;
        r8.dimensionRatioSide = r1;
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
        if (ZeusTransformUtils.instanceOf(r6, a.C0019a.class) == false) goto L77;
        ((a.C0019a) ZeusTransformUtils.preCheckCast(r6, a.C0019a.class, "com.obric.aiagent.plugin")).a(5, r10);
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
        r14.f987d = 0;     // Catch: NumberFormatException -> L68
        r14.W = r12;     // Catch: NumberFormatException -> L68
        goto L69
    L38:
        r14.f988e = 0;     // Catch: NumberFormatException -> L68
        r14.V = r12;     // Catch: NumberFormatException -> L68
        goto L69
    L40:
        if (ZeusTransformUtils.instanceOf(r6, a.C0019a.class) == false) goto L69;
        a.C0019a r15 = (a.C0019a) ZeusTransformUtils.preCheckCast(r6, a.C0019a.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
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
        r18.f987d = 0;     // Catch: NumberFormatException -> L68
        r18.af = r16;     // Catch: NumberFormatException -> L68
        r18.Z = 2;     // Catch: NumberFormatException -> L68
        goto L69
    L60:
        r18.f988e = 0;     // Catch: NumberFormatException -> L68
        r18.ag = r16;     // Catch: NumberFormatException -> L68
        r18.aa = 2;     // Catch: NumberFormatException -> L68
        goto L69
    L62:
        if (ZeusTransformUtils.instanceOf(r6, a.C0019a.class) == false) goto L69;
        a.C0019a r19 = (a.C0019a) ZeusTransformUtils.preCheckCast(r6, a.C0019a.class, "com.obric.aiagent.plugin");     // Catch: NumberFormatException -> L68
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

    public void a(Context r3, int r4) {
        b((ConstraintLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")), r4, null, "com.obric.aiagent.plugin"), ConstraintLayout.class, "com.obric.aiagent.plugin"));
    }

    public void c(c r6) {
        this.h.clear();
        Iterator<Integer> r0 = r6.h.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.aiagent.plugin");
        a r2 = (a) ZeusTransformUtils.preCheckCast(r6.h.get(r1), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L4;
        this.h.put(r1, r2.a());
        goto L4
    }

    public void b(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        this.h.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L33;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getId();
        if (this.f == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.h.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.h.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L32;
        r6.g = androidx.constraintlayout.widget.a.a(this.f972e, r2);
        a.a(r6, r4, r3);
        r6.f975c.f995b = r2.getVisibility();
        if (Build.VERSION.SDK_INT < 17) goto L30;
        r6.f975c.f997d = r2.getAlpha();
        r6.f.f1000b = r2.getRotation();
        r6.f.f1001c = r2.getRotationX();
        r6.f.f1002d = r2.getRotationY();
        r6.f.f1003e = r2.getScaleX();
        r6.f.f = r2.getScaleY();
        float r5 = r2.getPivotX();
        float r7 = r2.getPivotY();
        if (r5 == 0.0d) goto L22;
    L23:
        r6.f.g = r5;
        r6.f.h = r7;
    L24:
        r6.f.j = r2.getTranslationX();
        r6.f.k = r2.getTranslationY();
        if (Build.VERSION.SDK_INT < 21) goto L30;
        r6.f.l = r2.getTranslationZ();
        if (r6.f.m == false) goto L30;
        r6.f.n = r2.getElevation();
        goto L30
    L22:
        if (r7 == 0.0d) goto L24;
    L30:
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L32;
        Barrier r8 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.aiagent.plugin");
        r6.f977e.ap = r8.getAllowsGoneWidget();
        r6.f977e.ak = r8.getReferencedIds();
        r6.f977e.ah = r8.getType();
        r6.f977e.ai = r8.getMargin();
    L32:
        r1 = r1 + 1;
        goto L3
    }

    public void a(Constraints r10) {
        int r0 = r10.getChildCount();
        this.h.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L22;
        View r2 = r10.getChildAt(r1);
        Constraints.LayoutParams r3 = (Constraints.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), Constraints.LayoutParams.class, "com.obric.aiagent.plugin");
        int r4 = r2.getId();
        if (this.f == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.h.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.h.put(Integer.valueOf(r4), new a());
    L14:
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
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
        if (this.h.containsKey(Integer.valueOf(r3)) == true) goto L8;
        a(TAG, "id unknown " + androidx.constraintlayout.motion.widget.a.a(r2));
    L20:
        r1 = r1 + 1;
        goto L3
    L8:
        if (this.f == false) goto L15;
        if (r3 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.h.containsKey(Integer.valueOf(r3)) == false) goto L20;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L20;
        androidx.constraintlayout.widget.a.a(r2, r4.g);
        goto L20
    }

    public void a(ConstraintHelper r4, androidx.constraintlayout.a.c.e r5, ConstraintLayout.LayoutParams r6, SparseArray<androidx.constraintlayout.a.c.e> r7) {
        int r0 = r4.getId();
        if (this.h.containsKey(Integer.valueOf(r0)) == false) goto L10;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r0)), a.class, "com.obric.aiagent.plugin");
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
        if (this.h.containsKey(Integer.valueOf(r3)) == false) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r2.a(r4);
        return;
    L9:
        return;
    }

    void a(ConstraintLayout r13, boolean r14) {
        int r0 = r13.getChildCount();
        HashSet r1 = new HashSet(this.h.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L59;
        View r6 = r13.getChildAt(r3);
        int r7 = r6.getId();
        if (this.h.containsKey(Integer.valueOf(r7)) == true) goto L9;
        a(TAG, "id unknown " + androidx.constraintlayout.motion.widget.a.a(r6));
    L58:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.f == false) goto L14;
        if (r7 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r7 == (-1)) goto L58;
        if (this.h.containsKey(Integer.valueOf(r7)) == false) goto L57;
        r1.remove(Integer.valueOf(r7));
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r7)), a.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L58;
        if (ZeusTransformUtils.instanceOf(r6, Barrier.class) == false) goto L29;
        r8.f977e.aj = 1;
        Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r6, Barrier.class, "com.obric.aiagent.plugin");
        r4.setId(r7);
        r4.setType(r8.f977e.ah);
        r4.setMargin(r8.f977e.ai);
        r4.setAllowsGoneWidget(r8.f977e.ap);
        if (r8.f977e.ak == null) goto L27;
        r4.setReferencedIds(r8.f977e.ak);
        goto L29
    L27:
        if (r8.f977e.al == null) goto L29;
        r8.f977e.ak = a(r4, r8.f977e.al);
        r4.setReferencedIds(r8.f977e.ak);
    L29:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5.validate();
        r8.a(r5);
        if (r14 == false) goto L32;
        androidx.constraintlayout.widget.a.a(r6, r8.g);
    L32:
        r6.setLayoutParams(r5);
        if (r8.f975c.f996c != 0) goto L36;
        r6.setVisibility(r8.f975c.f995b);
    L36:
        if (Build.VERSION.SDK_INT < 17) goto L58;
        r6.setAlpha(r8.f975c.f997d);
        r6.setRotation(r8.f.f1000b);
        r6.setRotationX(r8.f.f1001c);
        r6.setRotationY(r8.f.f1002d);
        r6.setScaleX(r8.f.f1003e);
        r6.setScaleY(r8.f.f);
        if (r8.f.i == (-1)) goto L47;
        View r9 = ((View) ZeusTransformUtils.preCheckCast(r6.getParent(), View.class, "com.obric.aiagent.plugin")).findViewById(r8.f.i);
        if (r9 == null) goto L52;
        float r10 = (r9.getTop() + r9.getBottom()) / 2.0f;
        float r11 = (r9.getLeft() + r9.getRight()) / 2.0f;
        if ((r6.getRight() - r6.getLeft()) <= 0) goto L52;
        if ((r6.getBottom() - r6.getTop()) <= 0) goto L52;
        float r12 = r11 - r6.getLeft();
        float r15 = r10 - r6.getTop();
        r6.setPivotX(r12);
        r6.setPivotY(r15);
    L52:
        r6.setTranslationX(r8.f.j);
        r6.setTranslationY(r8.f.k);
        if (Build.VERSION.SDK_INT < 21) goto L58;
        r6.setTranslationZ(r8.f.l);
        if (r8.f.m == false) goto L58;
        r6.setElevation(r8.f.n);
        goto L58
    L47:
        if (Float.isNaN(r8.f.g) == true) goto L50;
        r6.setPivotX(r8.f.g);
    L50:
        if (Float.isNaN(r8.f.h) == true) goto L52;
        r6.setPivotY(r8.f.h);
        goto L52
    L57:
        b(TAG, "WARNING NO CONSTRAINTS for view " + r7);
        goto L58
    L59:
        Iterator r16 = r1.iterator();
    L61:
        if (r16.hasNext() == false) goto L77;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.next(), Integer.class, "com.obric.aiagent.plugin");
        a r18 = (a) ZeusTransformUtils.preCheckCast(this.h.get(r17), a.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L61;
        if (r18.f977e.aj != 1) goto L75;
        Barrier r19 = new Barrier((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r19.setId(r17.intValue());
        if (r18.f977e.ak == null) goto L71;
        r19.setReferencedIds(r18.f977e.ak);
    L73:
        r19.setType(r18.f977e.ah);
        r19.setMargin(r18.f977e.ai);
        ConstraintLayout.LayoutParams r20 = r13.generateDefaultLayoutParams();
        r19.validateParams();
        r18.a(r20);
        r13.addView(r19, r20);
        goto L75
    L71:
        if (r18.f977e.al == null) goto L73;
        r18.f977e.ak = a(r19, r18.f977e.al);
        r19.setReferencedIds(r18.f977e.ak);
    L75:
        if (r18.f977e.f984a == false) goto L61;
        Guideline r21 = new Guideline((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r21.setId(r17.intValue());
        ConstraintLayout.LayoutParams r22 = r13.generateDefaultLayoutParams();
        r18.a(r22);
        r13.addView(r21, r22);
    L77:
        if (r2 >= r0) goto L82;
        View r110 = r13.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r110, ConstraintHelper.class) == false) goto L81;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r110, ConstraintHelper.class, "com.obric.aiagent.plugin")).applyLayoutFeaturesInConstraintSet(r13);
    L81:
        r2 = r2 + 1;
        goto L77
    }

    public void a(int r10, int r11, int r12, int r13) {
        if (this.h.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.h.put(Integer.valueOf(r10), new a());
    L5:
        a r14 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r10)), a.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L51;
            case 2: goto L45;
            case 3: goto L39;
            case 4: goto L33;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        r14.f977e.x = r12;
        r14.f977e.w = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        r14.f977e.w = r12;
        r14.f977e.x = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + h(r13) + " undefined");
    L18:
        if (r13 != 6) goto L20;
        r14.f977e.v = r12;
        r14.f977e.u = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        r14.f977e.u = r12;
        r14.f977e.v = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + h(r13) + " undefined");
    L33:
        if (r13 != 4) goto L35;
        r14.f977e.q = r12;
        r14.f977e.p = -1;
        r14.f977e.r = -1;
        r14.f977e.s = -1;
        r14.f977e.t = -1;
        return;
    L35:
        if (r13 != 3) goto L38;
        r14.f977e.p = r12;
        r14.f977e.q = -1;
        r14.f977e.r = -1;
        r14.f977e.s = -1;
        r14.f977e.t = -1;
        return;
    L38:
        throw new IllegalArgumentException("right to " + h(r13) + " undefined");
    L39:
        if (r13 != 3) goto L41;
        r14.f977e.n = r12;
        r14.f977e.o = -1;
        r14.f977e.r = -1;
        r14.f977e.s = -1;
        r14.f977e.t = -1;
        return;
    L41:
        if (r13 != 4) goto L44;
        r14.f977e.o = r12;
        r14.f977e.n = -1;
        r14.f977e.r = -1;
        r14.f977e.s = -1;
        r14.f977e.t = -1;
        return;
    L44:
        throw new IllegalArgumentException("right to " + h(r13) + " undefined");
    L45:
        if (r13 != 1) goto L47;
        r14.f977e.l = r12;
        r14.f977e.m = -1;
        return;
    L47:
        if (r13 != 2) goto L50;
        r14.f977e.m = r12;
        r14.f977e.l = -1;
        return;
    L50:
        throw new IllegalArgumentException("right to " + h(r13) + " undefined");
    L51:
        if (r13 != 1) goto L53;
        r14.f977e.j = r12;
        r14.f977e.k = -1;
        return;
    L53:
        if (r13 != 2) goto L57;
        r14.f977e.k = r12;
        r14.f977e.j = -1;
        return;
    L57:
        throw new IllegalArgumentException("left to " + h(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(h(r11) + " to " + h(r13) + " unknown");
    L25:
        if (r13 != 5) goto L27;
        r14.f977e.r = r12;
        r14.f977e.q = -1;
        r14.f977e.p = -1;
        r14.f977e.n = -1;
        r14.f977e.o = -1;
        return;
    L27:
        if (r13 != 3) goto L29;
        r14.f977e.s = r12;
        r14.f977e.q = -1;
        r14.f977e.p = -1;
        r14.f977e.n = -1;
        r14.f977e.o = -1;
        return;
    L29:
        if (r13 != 4) goto L32;
        r14.f977e.t = r12;
        r14.f977e.q = -1;
        r14.f977e.p = -1;
        r14.f977e.n = -1;
        r14.f977e.o = -1;
        return;
    L32:
        throw new IllegalArgumentException("right to " + h(r13) + " undefined");
    }

    public void a(int r3, int r4) {
        if (this.h.containsKey(Integer.valueOf(r3)) == false) goto L20;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
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
        r2.f977e.D = -1.0f;
        r2.f977e.C = -1;
        r2.f977e.B = -1;
        return;
    L12:
        r2.f977e.w = -1;
        r2.f977e.x = -1;
        r2.f977e.L = 0;
        r2.f977e.S = Integer.MIN_VALUE;
        return;
    L13:
        r2.f977e.u = -1;
        r2.f977e.v = -1;
        r2.f977e.M = 0;
        r2.f977e.T = Integer.MIN_VALUE;
        return;
    L14:
        r2.f977e.r = -1;
        r2.f977e.s = -1;
        r2.f977e.t = -1;
        r2.f977e.N = 0;
        r2.f977e.U = Integer.MIN_VALUE;
        return;
    L15:
        r2.f977e.p = -1;
        r2.f977e.q = -1;
        r2.f977e.K = 0;
        r2.f977e.R = Integer.MIN_VALUE;
        return;
    L16:
        r2.f977e.o = -1;
        r2.f977e.n = -1;
        r2.f977e.f983J = 0;
        r2.f977e.P = Integer.MIN_VALUE;
        return;
    L17:
        r2.f977e.m = -1;
        r2.f977e.l = -1;
        r2.f977e.I = -1;
        r2.f977e.Q = Integer.MIN_VALUE;
        return;
    L18:
        r2.f977e.k = -1;
        r2.f977e.j = -1;
        r2.f977e.H = -1;
        r2.f977e.O = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void a(int r1, int r2, int r3) {
        a r0 = g(r1);
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r0.f977e.L = r3;
        return;
    L7:
        r0.f977e.M = r3;
        return;
    L8:
        r0.f977e.N = r3;
        return;
    L9:
        r0.f977e.K = r3;
        return;
    L10:
        r0.f977e.f983J = r3;
        return;
    L11:
        r0.f977e.I = r3;
        return;
    L12:
        r0.f977e.H = r3;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void a(int r1, float r2) {
        g(r1).f977e.y = r2;
    }

    public int b(int r1) {
        return g(r1).f975c.f996c;
    }

    public int c(int r1) {
        return g(r1).f975c.f995b;
    }

    public int d(int r1) {
        return g(r1).f977e.f988e;
    }

    public int e(int r1) {
        return g(r1).f977e.f987d;
    }

    public void b(int r1, int r2) {
        g(r1).f977e.f988e = r2;
    }

    public void c(int r1, int r2) {
        g(r1).f977e.f987d = r2;
    }

    public void a(int r1, int r2, int r3, float r4) {
        a r0 = g(r1);
        r0.f977e.B = r2;
        r0.f977e.C = r3;
        r0.f977e.D = r4;
    }

    public void a(int r1, boolean r2) {
        g(r1).f977e.an = r2;
    }

    public void d(int r1, int r2) {
        g(r1).f977e.X = r2;
    }

    public void e(int r2, int r3) {
        g(r2).f977e.g = r3;
        g(r2).f977e.f = -1;
        g(r2).f977e.h = -1.0f;
    }

    private a g(int r4) {
        if (this.h.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.h.put(Integer.valueOf(r4), new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r4)), a.class, "com.obric.aiagent.plugin");
    }

    public void b(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        XmlResourceParser r8 = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getXml(r6);
        int r0 = r8.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L5:
        if (r0 == 1) goto L30;
        if (r0 != 0) goto L8;
        r8.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L15:
        r0 = r8.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L8:
        if (r0 != 2) goto L15;
        String r1 = r8.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        a r2 = a(r7, Xml.asAttributeSet(r8), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (r1.equalsIgnoreCase("Guideline") == false) goto L13;
        r2.f977e.f984a = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
    L13:
        this.h.put(Integer.valueOf(r2.f973a), r2);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L15
    L30:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        int r0 = r13.getEventType();     // Catch: IOException -> L97 XmlPullParserException -> L99
        a r2 = null;
    L5:
        if (r0 == 1) goto L122;
        if (r0 == 0) goto L94;
        byte r4 = -1;
        if (r0 == 2) goto L33;
        if (r0 != 3) goto L95;
        String r1 = r13.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r1.hashCode()) {
            case -2075718416: goto L24;
            case -190376483: goto L21;
            case 426575017: goto L18;
            case 2146106725: goto L15;
            default: goto L26;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L26:
        if (r4 == 0) goto L32;
        if (r4 == 1) goto L31;
        if (r4 == 2) goto L31;
        if (r4 != 3) goto L95;
    L31:
        this.h.put(Integer.valueOf(r2.f973a), r2);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r2 = null;
        goto L95
    L32:
        return;
    L15:
        if (r1.equals("constraintset") == false) goto L26;
        r4 = 0;
        goto L26
    L18:
        if (r1.equals("constraintoverride") == false) goto L26;
        r4 = 2;
        goto L26
    L21:
        if (r1.equals("constraint") == false) goto L26;
        r4 = 1;
        goto L26
    L24:
        if (r1.equals("guideline") == false) goto L26;
        r4 = 3;
    L95:
        r0 = r13.next();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L5
    L33:
        String r3 = r13.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r3.hashCode()) {
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
        switch(r4) {
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
        if (r2 == null) goto L72;
        androidx.constraintlayout.widget.a.a(r12, r13, r2.g);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L72:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L73:
        if (r2 == null) goto L76;
        r2.f976d.a(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L76:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L77:
        if (r2 == null) goto L80;
        r2.f977e.a(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L80:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L81:
        if (r2 == null) goto L84;
        r2.f.a(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L84:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L85:
        if (r2 == null) goto L88;
        r2.f975c.a(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L88:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L89:
        a r5 = a(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r5.f977e.aj = 1;     // Catch: IOException -> L97 XmlPullParserException -> L99
    L93:
        r2 = r5;
        goto L95
    L90:
        r5 = a(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r5.f977e.f984a = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        r5.f977e.f985b = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L91:
        r5 = a(r12, Xml.asAttributeSet(r13), true);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L92:
        r5 = a(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L37:
        if (r3.equals("Constraint") == false) goto L67;
        r4 = 0;
        goto L67
    L40:
        if (r3.equals("CustomAttribute") == false) goto L67;
        r4 = 8;
        goto L67
    L43:
        if (r3.equals("Barrier") == false) goto L67;
        r4 = 3;
        goto L67
    L46:
        if (r3.equals("CustomMethod") == false) goto L67;
        r4 = 9;
        goto L67
    L49:
        if (r3.equals("Guideline") == false) goto L67;
        r4 = 2;
        goto L67
    L52:
        if (r3.equals("Transform") == false) goto L67;
        r4 = 5;
        goto L67
    L55:
        if (r3.equals("PropertySet") == false) goto L67;
        r4 = 4;
        goto L67
    L58:
        if (r3.equals("ConstraintOverride") == false) goto L67;
        r4 = 1;
        goto L67
    L61:
        if (r3.equals("Motion") == false) goto L67;
        r4 = 7;
        goto L67
    L64:
        if (r3.equals("Layout") == false) goto L67;
        r4 = 6;
        goto L67
    L94:
        r13.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L122:
        return;
    L97:
        e = move-exception;
        e.printStackTrace();
        return;
    L99:
        e = move-exception;
        e.printStackTrace();
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
        a(r6, r0, r8, r5);
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
        a(r4, r0, r6);
        r6.recycle();
        return r0;
    }

    private static void a(Context r13, a r14, TypedArray r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        int r17 = r15.getIndexCount();
        a.C0019a r0 = new a.C0019a();
        r14.h = r0;
        r14.f976d.f989a = false;
        r14.f977e.f985b = false;
        r14.f975c.f994a = false;
        r14.f.f999a = false;
        int r1 = 0;
    L3:
        if (r1 >= r17) goto L118;
        int r3 = r15.getIndex(r1);
        switch(j.get(r3)) {
            case 2: goto L116;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L115;
            case 6: goto L114;
            case 7: goto L113;
            case 8: goto L111;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L109;
            case 12: goto L108;
            case 13: goto L107;
            case 14: goto L106;
            case 15: goto L105;
            case 16: goto L104;
            case 17: goto L103;
            case 18: goto L102;
            case 19: goto L101;
            case 20: goto L100;
            case 21: goto L99;
            case 22: goto L98;
            case 23: goto L97;
            case 24: goto L96;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L95;
            case 28: goto L94;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L92;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L90;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L89;
            case 38: goto L88;
            case 39: goto L87;
            case 40: goto L86;
            case 41: goto L85;
            case 42: goto L84;
            case 43: goto L83;
            case 44: goto L81;
            case 45: goto L79;
            case 46: goto L78;
            case 47: goto L77;
            case 48: goto L76;
            case 49: goto L75;
            case 50: goto L74;
            case 51: goto L73;
            case 52: goto L72;
            case 53: goto L70;
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
        a(TAG, "Unknown attribute 0x" + Integer.toHexString(r3) + "   " + i.get(r3));
    L117:
        r1 = r1 + 1;
        goto L3
    L7:
        r0.a(99, r15.getBoolean(r3, r14.f977e.i));
        goto L117
    L17:
        r0.a(97, r15.getInt(r3, r14.f977e.aq));
        goto L117
    L18:
        a(r0, r15, r3, 1);
        goto L117
    L19:
        a(r0, r15, r3, 0);
        goto L117
    L20:
        r0.a(94, r15.getDimensionPixelSize(r3, r14.f977e.U));
        goto L117
    L21:
        r0.a(93, r15.getDimensionPixelSize(r3, r14.f977e.N));
        goto L117
    L22:
        a(TAG, "unused attribute 0x" + Integer.toHexString(r3) + "   " + i.get(r3));
        goto L117
    L23:
        TypedValue r4 = r15.peekValue(r3);
        if (r4.type != 1) goto L29;
        r14.f976d.n = r15.getResourceId(r3, -1);
        r0.a(89, r14.f976d.n);
        if (r14.f976d.n == (-1)) goto L117;
        r14.f976d.m = -2;
        r0.a(88, r14.f976d.m);
        goto L117
    L29:
        if (r4.type != 3) goto L34;
        r14.f976d.l = r15.getString(r3);
        r0.a(90, r14.f976d.l);
        if (r14.f976d.l.indexOf("/") <= 0) goto L33;
        r14.f976d.n = r15.getResourceId(r3, -1);
        r0.a(89, r14.f976d.n);
        r14.f976d.m = -2;
        r0.a(88, r14.f976d.m);
        goto L117
    L33:
        r14.f976d.m = -1;
        r0.a(88, r14.f976d.m);
        goto L117
    L34:
        r14.f976d.m = r15.getInteger(r3, r14.f976d.n);
        r0.a(88, r14.f976d.m);
        goto L117
    L35:
        r0.a(85, r15.getFloat(r3, r14.f976d.j));
        goto L117
    L36:
        r0.a(84, r15.getInteger(r3, r14.f976d.k));
        goto L117
    L37:
        r0.a(83, b(r15, r3, r14.f.i));
        goto L117
    L38:
        r0.a(82, r15.getInteger(r3, r14.f976d.f991c));
        goto L117
    L39:
        r0.a(81, r15.getBoolean(r3, r14.f977e.ao));
        goto L117
    L40:
        r0.a(80, r15.getBoolean(r3, r14.f977e.an));
        goto L117
    L41:
        r0.a(79, r15.getFloat(r3, r14.f976d.g));
        goto L117
    L42:
        r0.a(78, r15.getInt(r3, r14.f975c.f996c));
        goto L117
    L43:
        r0.a(77, r15.getString(r3));
        goto L117
    L44:
        r0.a(76, r15.getInt(r3, r14.f976d.f993e));
        goto L117
    L45:
        r0.a(75, r15.getBoolean(r3, r14.f977e.ap));
        goto L117
    L46:
        r0.a(74, r15.getString(r3));
        goto L117
    L47:
        r0.a(73, r15.getDimensionPixelSize(r3, r14.f977e.ai));
        goto L117
    L48:
        r0.a(72, r15.getInt(r3, r14.f977e.ah));
        goto L117
    L49:
        c(TAG, "CURRENTLY UNSUPPORTED");
        goto L117
    L50:
        r0.a(70, r15.getFloat(r3, 1.0f));
        goto L117
    L51:
        r0.a(69, r15.getFloat(r3, 1.0f));
        goto L117
    L52:
        r0.a(68, r15.getFloat(r3, r14.f975c.f998e));
        goto L117
    L53:
        r0.a(67, r15.getFloat(r3, r14.f976d.i));
        goto L117
    L54:
        r0.a(66, r15.getInt(r3, 0));
        goto L117
    L59:
        r0.a(64, b(r15, r3, r14.f976d.f990b));
        goto L117
    L60:
        r0.a(63, r15.getFloat(r3, r14.f977e.D));
        goto L117
    L61:
        r0.a(62, r15.getDimensionPixelSize(r3, r14.f977e.C));
        goto L117
    L62:
        r0.a(60, r15.getFloat(r3, r14.f.f1000b));
        goto L117
    L63:
        r0.a(59, r15.getDimensionPixelSize(r3, r14.f977e.ae));
        goto L117
    L64:
        r0.a(58, r15.getDimensionPixelSize(r3, r14.f977e.ad));
        goto L117
    L65:
        r0.a(57, r15.getDimensionPixelSize(r3, r14.f977e.ac));
        goto L117
    L66:
        r0.a(56, r15.getDimensionPixelSize(r3, r14.f977e.ab));
        goto L117
    L67:
        r0.a(55, r15.getInt(r3, r14.f977e.aa));
        goto L117
    L68:
        r0.a(54, r15.getInt(r3, r14.f977e.Z));
        goto L117
    L72:
        r0.a(52, r15.getDimension(r3, r14.f.k));
        goto L117
    L73:
        r0.a(51, r15.getDimension(r3, r14.f.j));
        goto L117
    L74:
        r0.a(50, r15.getDimension(r3, r14.f.h));
        goto L117
    L75:
        r0.a(49, r15.getDimension(r3, r14.f.g));
        goto L117
    L76:
        r0.a(48, r15.getFloat(r3, r14.f.f));
        goto L117
    L77:
        r0.a(47, r15.getFloat(r3, r14.f.f1003e));
        goto L117
    L78:
        r0.a(46, r15.getFloat(r3, r14.f.f1002d));
        goto L117
    L79:
        r0.a(45, r15.getFloat(r3, r14.f.f1001c));
        goto L117
    L83:
        r0.a(43, r15.getFloat(r3, r14.f975c.f997d));
        goto L117
    L84:
        r0.a(42, r15.getInt(r3, r14.f977e.Y));
        goto L117
    L85:
        r0.a(41, r15.getInt(r3, r14.f977e.X));
        goto L117
    L86:
        r0.a(40, r15.getFloat(r3, r14.f977e.V));
        goto L117
    L87:
        r0.a(39, r15.getFloat(r3, r14.f977e.W));
        goto L117
    L88:
        r14.f973a = r15.getResourceId(r3, r14.f973a);
        r0.a(38, r14.f973a);
        goto L117
    L89:
        r0.a(37, r15.getFloat(r3, r14.f977e.z));
        goto L117
    L90:
        r0.a(34, r15.getDimensionPixelSize(r3, r14.f977e.f983J));
        goto L117
    L94:
        r0.a(28, r15.getDimensionPixelSize(r3, r14.f977e.I));
        goto L117
    L95:
        r0.a(27, r15.getInt(r3, r14.f977e.G));
        goto L117
    L96:
        r0.a(24, r15.getDimensionPixelSize(r3, r14.f977e.H));
        goto L117
    L97:
        r0.a(23, r15.getLayoutDimension(r3, r14.f977e.f987d));
        goto L117
    L98:
        r0.a(22, g[r15.getInt(r3, r14.f975c.f995b)]);
        goto L117
    L99:
        r0.a(21, r15.getLayoutDimension(r3, r14.f977e.f988e));
        goto L117
    L100:
        r0.a(20, r15.getFloat(r3, r14.f977e.y));
        goto L117
    L101:
        r0.a(19, r15.getFloat(r3, r14.f977e.h));
        goto L117
    L102:
        r0.a(18, r15.getDimensionPixelOffset(r3, r14.f977e.g));
        goto L117
    L103:
        r0.a(17, r15.getDimensionPixelOffset(r3, r14.f977e.f));
        goto L117
    L104:
        r0.a(16, r15.getDimensionPixelSize(r3, r14.f977e.P));
        goto L117
    L105:
        r0.a(15, r15.getDimensionPixelSize(r3, r14.f977e.T));
        goto L117
    L106:
        r0.a(14, r15.getDimensionPixelSize(r3, r14.f977e.Q));
        goto L117
    L107:
        r0.a(13, r15.getDimensionPixelSize(r3, r14.f977e.O));
        goto L117
    L108:
        r0.a(12, r15.getDimensionPixelSize(r3, r14.f977e.S));
        goto L117
    L109:
        r0.a(11, r15.getDimensionPixelSize(r3, r14.f977e.R));
        goto L117
    L113:
        r0.a(7, r15.getDimensionPixelOffset(r3, r14.f977e.F));
        goto L117
    L114:
        r0.a(6, r15.getDimensionPixelOffset(r3, r14.f977e.E));
        goto L117
    L115:
        r0.a(5, r15.getString(r3));
        goto L117
    L116:
        r0.a(2, r15.getDimensionPixelSize(r3, r14.f977e.K));
        goto L117
    L9:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L14;
        r14.f973a = r15.getResourceId(r3, r14.f973a);
        if (r14.f973a != (-1)) goto L117;
        r14.f974b = r15.getString(r3);
        goto L117
    L14:
        if (r15.peekValue(r3).type != 3) goto L16;
        r14.f974b = r15.getString(r3);
        goto L117
    L16:
        r14.f973a = r15.getResourceId(r3, r14.f973a);
        goto L117
    L56:
        if (r15.peekValue(r3).type != 3) goto L58;
        r0.a(65, r15.getString(r3));
        goto L117
    L58:
        r0.a(65, androidx.constraintlayout.a.a.a.c.f615c[r15.getInteger(r3, 0)]);
        goto L117
    L70:
        if (Build.VERSION.SDK_INT < 21) goto L117;
        r0.a(53, r15.getDimension(r3, r14.f.l));
        goto L117
    L81:
        if (Build.VERSION.SDK_INT < 21) goto L117;
        r0.a(44, true);
        r0.a(44, r15.getDimension(r3, r14.f.n));
        goto L117
    L92:
        if (Build.VERSION.SDK_INT < 17) goto L117;
        r0.a(31, r15.getDimensionPixelSize(r3, r14.f977e.M));
        goto L117
    L111:
        if (Build.VERSION.SDK_INT < 17) goto L117;
        r0.a(8, r15.getDimensionPixelSize(r3, r14.f977e.L));
        goto L117
    }

    private static void b(a r1, int r2, float r3) {
        if (r2 != 19) goto L5;
        r1.f977e.h = r3;
        return;
    L5:
        if (r2 != 20) goto L7;
        r1.f977e.y = r3;
        return;
    L7:
        if (r2 != 37) goto L9;
        r1.f977e.z = r3;
        return;
    L9:
        if (r2 != 60) goto L11;
        r1.f.f1000b = r3;
        return;
    L11:
        if (r2 != 63) goto L13;
        r1.f977e.D = r3;
        return;
    L13:
        if (r2 != 79) goto L15;
        r1.f976d.g = r3;
        return;
    L15:
        if (r2 != 85) goto L17;
        r1.f976d.j = r3;
        return;
    L17:
        if (r2 != 87) goto L19;
        return;
    L19:
        if (r2 != 39) goto L21;
        r1.f977e.W = r3;
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
        r1.f977e.ag = r3;
        return;
    L26:
        r1.f977e.af = r3;
        return;
    L27:
        r1.f975c.f998e = r3;
        return;
    L28:
        r1.f976d.i = r3;
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
        r1.f.f1003e = r3;
        return;
    L36:
        r1.f.f1002d = r3;
        return;
    L37:
        r1.f.f1001c = r3;
        return;
    L38:
        r1.f.n = r3;
        r1.f.m = true;
        return;
    L39:
        r1.f975c.f997d = r3;
        return;
    L40:
        r1.f977e.V = r3;
    }

    private static void b(a r1, int r2, int r3) {
        if (r2 != 6) goto L5;
        r1.f977e.E = r3;
        return;
    L5:
        if (r2 != 7) goto L7;
        r1.f977e.F = r3;
        return;
    L7:
        if (r2 != 8) goto L9;
        r1.f977e.L = r3;
        return;
    L9:
        if (r2 != 27) goto L11;
        r1.f977e.G = r3;
        return;
    L11:
        if (r2 != 28) goto L13;
        r1.f977e.I = r3;
        return;
    L13:
        if (r2 != 41) goto L15;
        r1.f977e.X = r3;
        return;
    L15:
        if (r2 != 42) goto L17;
        r1.f977e.Y = r3;
        return;
    L17:
        if (r2 != 61) goto L19;
        r1.f977e.B = r3;
        return;
    L19:
        if (r2 != 62) goto L21;
        r1.f977e.C = r3;
        return;
    L21:
        if (r2 != 72) goto L23;
        r1.f977e.ah = r3;
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
        r1.f976d.n = r3;
        return;
    L31:
        r1.f976d.m = r3;
        return;
    L76:
        return;
    L32:
        r1.f976d.k = r3;
        return;
    L33:
        r1.f.i = r3;
        return;
    L34:
        r1.f976d.f991c = r3;
        return;
    L35:
        r1.f977e.ae = r3;
        return;
    L36:
        r1.f977e.ad = r3;
        return;
    L37:
        r1.f977e.ac = r3;
        return;
    L38:
        r1.f977e.ab = r3;
        return;
    L39:
        r1.f977e.aa = r3;
        return;
    L40:
        r1.f977e.Z = r3;
        return;
    L41:
        r1.f977e.H = r3;
        return;
    L42:
        r1.f977e.f987d = r3;
        return;
    L43:
        r1.f975c.f995b = r3;
        return;
    L44:
        r1.f977e.f988e = r3;
        return;
    L45:
        r1.f977e.aq = r3;
        return;
    L46:
        r1.f977e.U = r3;
        return;
    L47:
        r1.f977e.N = r3;
        return;
    L48:
        r1.f975c.f996c = r3;
        return;
    L49:
        r1.f976d.f993e = r3;
        return;
    L50:
        r1.f976d.f = r3;
        return;
    L51:
        r1.f976d.f990b = r3;
        return;
    L52:
        r1.f973a = r3;
        return;
    L53:
        r1.f977e.f983J = r3;
        return;
    L54:
        r1.f977e.M = r3;
        return;
    L55:
        r1.f977e.g = r3;
        return;
    L56:
        r1.f977e.f = r3;
        return;
    L57:
        r1.f977e.P = r3;
        return;
    L58:
        r1.f977e.T = r3;
        return;
    L59:
        r1.f977e.Q = r3;
        return;
    L60:
        r1.f977e.O = r3;
        return;
    L61:
        r1.f977e.S = r3;
        return;
    L62:
        r1.f977e.R = r3;
        return;
    L63:
        r1.f977e.K = r3;
        return;
    L64:
        r1.f977e.ai = r3;
    }

    private static void b(a r1, int r2, String r3) {
        if (r2 != 5) goto L5;
        r1.f977e.A = r3;
        return;
    L5:
        if (r2 != 65) goto L7;
        r1.f976d.f992d = r3;
        return;
    L7:
        if (r2 != 74) goto L9;
        r1.f977e.al = r3;
        r1.f977e.ak = null;
        return;
    L9:
        if (r2 != 77) goto L11;
        r1.f977e.am = r3;
        return;
    L11:
        if (r2 != 87) goto L13;
        return;
    L13:
        if (r2 == 90) goto L15;
        a(TAG, "Unknown attribute 0x");
        return;
    L15:
        r1.f976d.l = r3;
    }

    private static void b(a r1, int r2, boolean r3) {
        if (r2 != 44) goto L5;
        r1.f.m = r3;
        return;
    L5:
        if (r2 != 75) goto L7;
        r1.f977e.ap = r3;
        return;
    L7:
        if (r2 != 87) goto L9;
        return;
    L9:
        if (r2 != 80) goto L11;
        r1.f977e.an = r3;
        return;
    L11:
        if (r2 == 81) goto L13;
        a(TAG, "Unknown attribute 0x");
        return;
    L13:
        r1.f977e.ao = r3;
    }

    private void a(Context r10, a r11, TypedArray r12, boolean r13) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (r13 == false) goto L6;
        a(r9, r11, r12);
        return;
    L6:
        int r14 = r12.getIndexCount();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L136;
        int r0 = r12.getIndex(r15);
        if (r0 == ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id")) goto L16;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart") == r0) goto L16;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd") == r0) goto L16;
        r11.f976d.f989a = true;
        r11.f977e.f985b = true;
        r11.f975c.f994a = true;
        r11.f.f999a = true;
    L16:
        switch(i.get(r0)) {
            case 1: goto L133;
            case 2: goto L132;
            case 3: goto L131;
            case 4: goto L130;
            case 5: goto L129;
            case 6: goto L128;
            case 7: goto L127;
            case 8: goto L125;
            case 9: goto L123;
            case 10: goto L122;
            case 11: goto L121;
            case 12: goto L120;
            case 13: goto L119;
            case 14: goto L118;
            case 15: goto L117;
            case 16: goto L116;
            case 17: goto L115;
            case 18: goto L114;
            case 19: goto L113;
            case 20: goto L112;
            case 21: goto L111;
            case 22: goto L110;
            case 23: goto L109;
            case 24: goto L108;
            case 25: goto L107;
            case 26: goto L106;
            case 27: goto L105;
            case 28: goto L104;
            case 29: goto L103;
            case 30: goto L102;
            case 31: goto L100;
            case 32: goto L98;
            case 33: goto L97;
            case 34: goto L96;
            case 35: goto L95;
            case 36: goto L94;
            case 37: goto L93;
            case 38: goto L92;
            case 39: goto L91;
            case 40: goto L90;
            case 41: goto L89;
            case 42: goto L88;
            case 43: goto L87;
            case 44: goto L85;
            case 45: goto L83;
            case 46: goto L82;
            case 47: goto L81;
            case 48: goto L80;
            case 49: goto L79;
            case 50: goto L78;
            case 51: goto L77;
            case 52: goto L76;
            case 53: goto L74;
            case 54: goto L72;
            case 55: goto L71;
            case 56: goto L70;
            case 57: goto L69;
            case 58: goto L68;
            case 59: goto L67;
            case 60: goto L66;
            case 61: goto L65;
            case 62: goto L64;
            case 63: goto L63;
            case 64: goto L62;
            case 65: goto L59;
            case 66: goto L57;
            case 67: goto L56;
            case 68: goto L55;
            case 69: goto L54;
            case 70: goto L53;
            case 71: goto L52;
            case 72: goto L51;
            case 73: goto L50;
            case 74: goto L49;
            case 75: goto L48;
            case 76: goto L47;
            case 77: goto L46;
            case 78: goto L45;
            case 79: goto L44;
            case 80: goto L43;
            case 81: goto L42;
            case 82: goto L41;
            case 83: goto L40;
            case 84: goto L39;
            case 85: goto L38;
            case 86: goto L26;
            case 87: goto L25;
            case 88: goto L17;
            case 89: goto L17;
            case 90: goto L17;
            case 91: goto L24;
            case 92: goto L23;
            case 93: goto L22;
            case 94: goto L21;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            default: goto L17;
        };
    L17:
        a(TAG, "Unknown attribute 0x" + Integer.toHexString(r0) + "   " + i.get(r0));
    L134:
        r15 = r15 + 1;
        goto L7
    L18:
        r11.f977e.aq = r12.getInt(r0, r11.f977e.aq);
        goto L134
    L19:
        a(r11.f977e, r12, r0, 1);
        goto L134
    L20:
        a(r11.f977e, r12, r0, 0);
        goto L134
    L21:
        r11.f977e.U = r12.getDimensionPixelSize(r0, r11.f977e.U);
        goto L134
    L22:
        r11.f977e.N = r12.getDimensionPixelSize(r0, r11.f977e.N);
        goto L134
    L23:
        r11.f977e.t = b(r12, r0, r11.f977e.t);
        goto L134
    L24:
        r11.f977e.s = b(r12, r0, r11.f977e.s);
        goto L134
    L25:
        a(TAG, "unused attribute 0x" + Integer.toHexString(r0) + "   " + i.get(r0));
        goto L134
    L26:
        TypedValue r1 = r12.peekValue(r0);
        if (r1.type != 1) goto L32;
        r11.f976d.n = r12.getResourceId(r0, -1);
        if (r11.f976d.n == (-1)) goto L134;
        r11.f976d.m = -2;
        goto L134
    L32:
        if (r1.type != 3) goto L37;
        r11.f976d.l = r12.getString(r0);
        if (r11.f976d.l.indexOf("/") <= 0) goto L36;
        r11.f976d.n = r12.getResourceId(r0, -1);
        r11.f976d.m = -2;
        goto L134
    L36:
        r11.f976d.m = -1;
        goto L134
    L37:
        r11.f976d.m = r12.getInteger(r0, r11.f976d.n);
        goto L134
    L38:
        r11.f976d.j = r12.getFloat(r0, r11.f976d.j);
        goto L134
    L39:
        r11.f976d.k = r12.getInteger(r0, r11.f976d.k);
        goto L134
    L40:
        r11.f.i = b(r12, r0, r11.f.i);
        goto L134
    L41:
        r11.f976d.f991c = r12.getInteger(r0, r11.f976d.f991c);
        goto L134
    L42:
        r11.f977e.ao = r12.getBoolean(r0, r11.f977e.ao);
        goto L134
    L43:
        r11.f977e.an = r12.getBoolean(r0, r11.f977e.an);
        goto L134
    L44:
        r11.f976d.g = r12.getFloat(r0, r11.f976d.g);
        goto L134
    L45:
        r11.f975c.f996c = r12.getInt(r0, r11.f975c.f996c);
        goto L134
    L46:
        r11.f977e.am = r12.getString(r0);
        goto L134
    L47:
        r11.f976d.f993e = r12.getInt(r0, r11.f976d.f993e);
        goto L134
    L48:
        r11.f977e.ap = r12.getBoolean(r0, r11.f977e.ap);
        goto L134
    L49:
        r11.f977e.al = r12.getString(r0);
        goto L134
    L50:
        r11.f977e.ai = r12.getDimensionPixelSize(r0, r11.f977e.ai);
        goto L134
    L51:
        r11.f977e.ah = r12.getInt(r0, r11.f977e.ah);
        goto L134
    L52:
        c(TAG, "CURRENTLY UNSUPPORTED");
        goto L134
    L53:
        r11.f977e.ag = r12.getFloat(r0, 1.0f);
        goto L134
    L54:
        r11.f977e.af = r12.getFloat(r0, 1.0f);
        goto L134
    L55:
        r11.f975c.f998e = r12.getFloat(r0, r11.f975c.f998e);
        goto L134
    L56:
        r11.f976d.i = r12.getFloat(r0, r11.f976d.i);
        goto L134
    L57:
        r11.f976d.f = r12.getInt(r0, 0);
        goto L134
    L62:
        r11.f976d.f990b = b(r12, r0, r11.f976d.f990b);
        goto L134
    L63:
        r11.f977e.D = r12.getFloat(r0, r11.f977e.D);
        goto L134
    L64:
        r11.f977e.C = r12.getDimensionPixelSize(r0, r11.f977e.C);
        goto L134
    L65:
        r11.f977e.B = b(r12, r0, r11.f977e.B);
        goto L134
    L66:
        r11.f.f1000b = r12.getFloat(r0, r11.f.f1000b);
        goto L134
    L67:
        r11.f977e.ae = r12.getDimensionPixelSize(r0, r11.f977e.ae);
        goto L134
    L68:
        r11.f977e.ad = r12.getDimensionPixelSize(r0, r11.f977e.ad);
        goto L134
    L69:
        r11.f977e.ac = r12.getDimensionPixelSize(r0, r11.f977e.ac);
        goto L134
    L70:
        r11.f977e.ab = r12.getDimensionPixelSize(r0, r11.f977e.ab);
        goto L134
    L71:
        r11.f977e.aa = r12.getInt(r0, r11.f977e.aa);
        goto L134
    L72:
        r11.f977e.Z = r12.getInt(r0, r11.f977e.Z);
        goto L134
    L76:
        r11.f.k = r12.getDimension(r0, r11.f.k);
        goto L134
    L77:
        r11.f.j = r12.getDimension(r0, r11.f.j);
        goto L134
    L78:
        r11.f.h = r12.getDimension(r0, r11.f.h);
        goto L134
    L79:
        r11.f.g = r12.getDimension(r0, r11.f.g);
        goto L134
    L80:
        r11.f.f = r12.getFloat(r0, r11.f.f);
        goto L134
    L81:
        r11.f.f1003e = r12.getFloat(r0, r11.f.f1003e);
        goto L134
    L82:
        r11.f.f1002d = r12.getFloat(r0, r11.f.f1002d);
        goto L134
    L83:
        r11.f.f1001c = r12.getFloat(r0, r11.f.f1001c);
        goto L134
    L87:
        r11.f975c.f997d = r12.getFloat(r0, r11.f975c.f997d);
        goto L134
    L88:
        r11.f977e.Y = r12.getInt(r0, r11.f977e.Y);
        goto L134
    L89:
        r11.f977e.X = r12.getInt(r0, r11.f977e.X);
        goto L134
    L90:
        r11.f977e.V = r12.getFloat(r0, r11.f977e.V);
        goto L134
    L91:
        r11.f977e.W = r12.getFloat(r0, r11.f977e.W);
        goto L134
    L92:
        r11.f973a = r12.getResourceId(r0, r11.f973a);
        goto L134
    L93:
        r11.f977e.z = r12.getFloat(r0, r11.f977e.z);
        goto L134
    L94:
        r11.f977e.n = b(r12, r0, r11.f977e.n);
        goto L134
    L95:
        r11.f977e.o = b(r12, r0, r11.f977e.o);
        goto L134
    L96:
        r11.f977e.f983J = r12.getDimensionPixelSize(r0, r11.f977e.f983J);
        goto L134
    L97:
        r11.f977e.v = b(r12, r0, r11.f977e.v);
        goto L134
    L98:
        r11.f977e.u = b(r12, r0, r11.f977e.u);
        goto L134
    L102:
        r11.f977e.m = b(r12, r0, r11.f977e.m);
        goto L134
    L103:
        r11.f977e.l = b(r12, r0, r11.f977e.l);
        goto L134
    L104:
        r11.f977e.I = r12.getDimensionPixelSize(r0, r11.f977e.I);
        goto L134
    L105:
        r11.f977e.G = r12.getInt(r0, r11.f977e.G);
        goto L134
    L106:
        r11.f977e.k = b(r12, r0, r11.f977e.k);
        goto L134
    L107:
        r11.f977e.j = b(r12, r0, r11.f977e.j);
        goto L134
    L108:
        r11.f977e.H = r12.getDimensionPixelSize(r0, r11.f977e.H);
        goto L134
    L109:
        r11.f977e.f987d = r12.getLayoutDimension(r0, r11.f977e.f987d);
        goto L134
    L110:
        r11.f975c.f995b = r12.getInt(r0, r11.f975c.f995b);
        r11.f975c.f995b = g[r11.f975c.f995b];
        goto L134
    L111:
        r11.f977e.f988e = r12.getLayoutDimension(r0, r11.f977e.f988e);
        goto L134
    L112:
        r11.f977e.y = r12.getFloat(r0, r11.f977e.y);
        goto L134
    L113:
        r11.f977e.h = r12.getFloat(r0, r11.f977e.h);
        goto L134
    L114:
        r11.f977e.g = r12.getDimensionPixelOffset(r0, r11.f977e.g);
        goto L134
    L115:
        r11.f977e.f = r12.getDimensionPixelOffset(r0, r11.f977e.f);
        goto L134
    L116:
        r11.f977e.P = r12.getDimensionPixelSize(r0, r11.f977e.P);
        goto L134
    L117:
        r11.f977e.T = r12.getDimensionPixelSize(r0, r11.f977e.T);
        goto L134
    L118:
        r11.f977e.Q = r12.getDimensionPixelSize(r0, r11.f977e.Q);
        goto L134
    L119:
        r11.f977e.O = r12.getDimensionPixelSize(r0, r11.f977e.O);
        goto L134
    L120:
        r11.f977e.S = r12.getDimensionPixelSize(r0, r11.f977e.S);
        goto L134
    L121:
        r11.f977e.R = r12.getDimensionPixelSize(r0, r11.f977e.R);
        goto L134
    L122:
        r11.f977e.w = b(r12, r0, r11.f977e.w);
        goto L134
    L123:
        r11.f977e.x = b(r12, r0, r11.f977e.x);
        goto L134
    L127:
        r11.f977e.F = r12.getDimensionPixelOffset(r0, r11.f977e.F);
        goto L134
    L128:
        r11.f977e.E = r12.getDimensionPixelOffset(r0, r11.f977e.E);
        goto L134
    L129:
        r11.f977e.A = r12.getString(r0);
        goto L134
    L130:
        r11.f977e.p = b(r12, r0, r11.f977e.p);
        goto L134
    L131:
        r11.f977e.q = b(r12, r0, r11.f977e.q);
        goto L134
    L132:
        r11.f977e.K = r12.getDimensionPixelSize(r0, r11.f977e.K);
        goto L134
    L133:
        r11.f977e.r = b(r12, r0, r11.f977e.r);
        goto L134
    L59:
        if (r12.peekValue(r0).type != 3) goto L61;
        r11.f976d.f992d = r12.getString(r0);
        goto L134
    L61:
        r11.f976d.f992d = androidx.constraintlayout.a.a.a.c.f615c[r12.getInteger(r0, 0)];
        goto L134
    L74:
        if (Build.VERSION.SDK_INT < 21) goto L134;
        r11.f.l = r12.getDimension(r0, r11.f.l);
        goto L134
    L85:
        if (Build.VERSION.SDK_INT < 21) goto L134;
        r11.f.m = true;
        r11.f.n = r12.getDimension(r0, r11.f.n);
        goto L134
    L100:
        if (Build.VERSION.SDK_INT < 17) goto L134;
        r11.f977e.M = r12.getDimensionPixelSize(r0, r11.f977e.M);
        goto L134
    L125:
        if (Build.VERSION.SDK_INT < 17) goto L134;
        r11.f977e.L = r12.getDimensionPixelSize(r0, r11.f977e.L);
        goto L134
    L136:
        if (r11.f977e.al == null) goto L244;
        r11.f977e.ak = null;
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
        if (this.h.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return null;
    L5:
        return (a) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r3)), a.class, "com.obric.aiagent.plugin");
    }

    public int[] a() {
        int r0 = 0;
        Integer[] r4 = (Integer[]) ZeusTransformUtils.preCheckCast(this.h.keySet().toArray(new Integer[0]), Integer[].class, "com.obric.aiagent.plugin");
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
        this.f = r1;
    }

    public void b(boolean r1) {
        this.f971d = r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
