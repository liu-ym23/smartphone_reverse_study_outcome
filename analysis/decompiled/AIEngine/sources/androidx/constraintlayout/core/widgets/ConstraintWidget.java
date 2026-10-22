package androidx.constraintlayout.core.widgets;

import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ConstraintWidget {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public final ConstraintAnchor J;
    public final ConstraintAnchor K;
    public final ConstraintAnchor L;
    public final ConstraintAnchor M;
    public final ConstraintAnchor N;
    public final ConstraintAnchor O;
    public final ConstraintAnchor P;
    public final ConstraintAnchor Q;
    public final ConstraintAnchor[] R;
    public final ArrayList<ConstraintAnchor> S;
    public final boolean[] T;
    public final DimensionBehaviour[] U;
    public ConstraintWidget V;
    public int W;
    public int X;
    public float Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f1100a0;

    /* renamed from: b, reason: collision with root package name */
    public h0.c f1101b;
    public int b0;

    /* renamed from: c, reason: collision with root package name */
    public h0.c f1102c;
    public int c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1104d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f1106e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f1108f0;

    /* renamed from: g0, reason: collision with root package name */
    public float f1110g0;

    /* renamed from: h0, reason: collision with root package name */
    public View f1111h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f1113i0;

    /* renamed from: j, reason: collision with root package name */
    public String f1114j;

    /* renamed from: j0, reason: collision with root package name */
    public String f1115j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1116k;

    /* renamed from: k0, reason: collision with root package name */
    public int f1117k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1118l;

    /* renamed from: l0, reason: collision with root package name */
    public int f1119l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1120m;

    /* renamed from: m0, reason: collision with root package name */
    public final float[] f1121m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1122n;

    /* renamed from: n0, reason: collision with root package name */
    public final ConstraintWidget[] f1123n0;

    /* renamed from: o, reason: collision with root package name */
    public int f1124o;

    /* renamed from: o0, reason: collision with root package name */
    public final ConstraintWidget[] f1125o0;

    /* renamed from: p, reason: collision with root package name */
    public int f1126p;

    /* renamed from: p0, reason: collision with root package name */
    public int f1127p0;

    /* renamed from: q, reason: collision with root package name */
    public int f1128q;
    public int q0;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f1129s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f1130t;

    /* renamed from: u, reason: collision with root package name */
    public int f1131u;

    /* renamed from: v, reason: collision with root package name */
    public int f1132v;

    /* renamed from: w, reason: collision with root package name */
    public float f1133w;

    /* renamed from: x, reason: collision with root package name */
    public int f1134x;

    /* renamed from: y, reason: collision with root package name */
    public int f1135y;
    public float z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1099a = false;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f1103d = null;

    /* renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.d f1105e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f1107f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    public boolean f1109g = true;
    public int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1112i = -1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DimensionBehaviour {

        /* renamed from: a, reason: collision with root package name */
        public static final DimensionBehaviour f1136a;

        /* renamed from: b, reason: collision with root package name */
        public static final DimensionBehaviour f1137b;

        /* renamed from: c, reason: collision with root package name */
        public static final DimensionBehaviour f1138c;

        /* renamed from: d, reason: collision with root package name */
        public static final DimensionBehaviour f1139d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ DimensionBehaviour[] f1140e;

        static {
            DimensionBehaviour dimensionBehaviour = new DimensionBehaviour("FIXED", 0);
            f1136a = dimensionBehaviour;
            DimensionBehaviour dimensionBehaviour2 = new DimensionBehaviour("WRAP_CONTENT", 1);
            f1137b = dimensionBehaviour2;
            DimensionBehaviour dimensionBehaviour3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            f1138c = dimensionBehaviour3;
            DimensionBehaviour dimensionBehaviour4 = new DimensionBehaviour("MATCH_PARENT", 3);
            f1139d = dimensionBehaviour4;
            f1140e = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour2, dimensionBehaviour3, dimensionBehaviour4};
        }

        public DimensionBehaviour() {
            throw null;
        }

        public static DimensionBehaviour valueOf(String str) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, str);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) f1140e.clone();
        }
    }

    public ConstraintWidget() {
        new HashMap();
        this.f1116k = false;
        this.f1118l = false;
        this.f1120m = false;
        this.f1122n = false;
        this.f1124o = -1;
        this.f1126p = -1;
        this.f1128q = 0;
        this.r = 0;
        this.f1129s = 0;
        this.f1130t = new int[2];
        this.f1131u = 0;
        this.f1132v = 0;
        this.f1133w = 1.0f;
        this.f1134x = 0;
        this.f1135y = 0;
        this.z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.D = Float.NaN;
        this.E = false;
        this.G = false;
        this.H = 0;
        this.I = 0;
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.f1091a);
        this.J = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1092b);
        this.K = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1093c);
        this.L = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1094d);
        this.M = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1095e);
        this.N = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1096j);
        this.O = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1097k);
        this.P = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, ConstraintAnchor.Type.h);
        this.Q = constraintAnchor8;
        this.R = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList<ConstraintAnchor> arrayList = new ArrayList<>();
        this.S = arrayList;
        this.T = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.f1136a;
        this.U = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.V = null;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.f1100a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.f1108f0 = 0.5f;
        this.f1110g0 = 0.5f;
        this.f1113i0 = 0;
        this.f1115j0 = null;
        this.f1117k0 = 0;
        this.f1119l0 = 0;
        this.f1121m0 = new float[]{-1.0f, -1.0f};
        this.f1123n0 = new ConstraintWidget[]{null, null};
        this.f1125o0 = new ConstraintWidget[]{null, null};
        this.f1127p0 = -1;
        this.q0 = -1;
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    public static void G(int i10, int i11, String str, StringBuilder sb2) {
        if (i10 == i11) {
            return;
        }
        com.stepos.core.ota.d.o(i10, str, " :   ", ",\n", sb2);
    }

    public static void H(StringBuilder sb2, String str, float f8, float f9) {
        if (f8 == f9) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f8);
        sb2.append(",\n");
    }

    public static void o(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, float f8, DimensionBehaviour dimensionBehaviour) {
        sb2.append(str);
        sb2.append(" :  {\n");
        String string = dimensionBehaviour.toString();
        if (!"FIXED".equals(string)) {
            ai.onnxruntime.a.z(sb2, "      behavior", " :   ", string, ",\n");
        }
        G(i10, 0, "      size", sb2);
        G(i11, 0, "      min", sb2);
        G(i12, Integer.MAX_VALUE, "      max", sb2);
        G(i13, 0, "      matchMin", sb2);
        G(i14, 0, "      matchDef", sb2);
        H(sb2, "      matchPercent", f8, 1.0f);
        sb2.append("    },\n");
    }

    public static void p(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f1088f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f1088f);
        sb2.append("'");
        if (constraintAnchor.h != Integer.MIN_VALUE || constraintAnchor.f1089g != 0) {
            sb2.append(",");
            sb2.append(constraintAnchor.f1089g);
            if (constraintAnchor.h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(constraintAnchor.h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    public boolean A() {
        if (this.f1116k) {
            return true;
        }
        return this.J.f1085c && this.L.f1085c;
    }

    public boolean B() {
        if (this.f1118l) {
            return true;
        }
        return this.K.f1085c && this.M.f1085c;
    }

    public void C() {
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.V = null;
        this.D = Float.NaN;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.f1100a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.f1104d0 = 0;
        this.f1106e0 = 0;
        this.f1108f0 = 0.5f;
        this.f1110g0 = 0.5f;
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.f1136a;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f1111h0 = null;
        this.f1113i0 = 0;
        this.f1117k0 = 0;
        this.f1119l0 = 0;
        float[] fArr = this.f1121m0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1124o = -1;
        this.f1126p = -1;
        int[] iArr = this.C;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.r = 0;
        this.f1129s = 0;
        this.f1133w = 1.0f;
        this.z = 1.0f;
        this.f1132v = Integer.MAX_VALUE;
        this.f1135y = Integer.MAX_VALUE;
        this.f1131u = 0;
        this.f1134x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f1107f;
        zArr[0] = true;
        zArr[1] = true;
        this.G = false;
        boolean[] zArr2 = this.T;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1109g = true;
        int[] iArr2 = this.f1130t;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.h = -1;
        this.f1112i = -1;
    }

    public final void D() {
        ConstraintWidget constraintWidget = this.V;
        if (constraintWidget != null && (constraintWidget instanceof d)) {
            ((d) constraintWidget).getClass();
        }
        ArrayList<ConstraintAnchor> arrayList = this.S;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).j();
        }
    }

    public final void E() {
        this.f1116k = false;
        this.f1118l = false;
        this.f1120m = false;
        this.f1122n = false;
        ArrayList<ConstraintAnchor> arrayList = this.S;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintAnchor constraintAnchor = arrayList.get(i10);
            constraintAnchor.f1085c = false;
            constraintAnchor.f1084b = 0;
        }
    }

    public void F(e0.a aVar) {
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.Q.k();
        this.O.k();
        this.P.k();
    }

    public final void I(int i10) {
        this.c0 = i10;
        this.E = i10 > 0;
    }

    public final void J(int i10, int i11) {
        if (this.f1116k) {
            return;
        }
        this.J.l(i10);
        this.L.l(i11);
        this.f1100a0 = i10;
        this.W = i11 - i10;
        this.f1116k = true;
    }

    public final void K(int i10, int i11) {
        if (this.f1118l) {
            return;
        }
        this.K.l(i10);
        this.M.l(i11);
        this.b0 = i10;
        this.X = i11 - i10;
        if (this.E) {
            this.N.l(i10 + this.c0);
        }
        this.f1118l = true;
    }

    public final void L(int i10) {
        this.X = i10;
        int i11 = this.f1106e0;
        if (i10 < i11) {
            this.X = i11;
        }
    }

    public final void M(DimensionBehaviour dimensionBehaviour) {
        this.U[0] = dimensionBehaviour;
    }

    public final void N(DimensionBehaviour dimensionBehaviour) {
        this.U[1] = dimensionBehaviour;
    }

    public final void O(int i10) {
        this.W = i10;
        int i11 = this.f1104d0;
        if (i10 < i11) {
            this.W = i11;
        }
    }

    public void P(boolean z, boolean z3) {
        int i10;
        int i11;
        androidx.constraintlayout.core.widgets.analyzer.c cVar = this.f1103d;
        boolean z10 = z & cVar.f1170g;
        androidx.constraintlayout.core.widgets.analyzer.d dVar = this.f1105e;
        boolean z11 = z3 & dVar.f1170g;
        int i12 = cVar.h.f1151g;
        int i13 = dVar.h.f1151g;
        int i14 = cVar.f1171i.f1151g;
        int i15 = dVar.f1171i.f1151g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i15 = 0;
            i12 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (z10) {
            this.f1100a0 = i12;
        }
        if (z11) {
            this.b0 = i13;
        }
        if (this.f1113i0 == 8) {
            this.W = 0;
            this.X = 0;
            return;
        }
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.f1136a;
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        if (z10) {
            if (dimensionBehaviourArr[0] == dimensionBehaviour && i17 < (i11 = this.W)) {
                i17 = i11;
            }
            this.W = i17;
            int i19 = this.f1104d0;
            if (i17 < i19) {
                this.W = i19;
            }
        }
        if (z11) {
            if (dimensionBehaviourArr[1] == dimensionBehaviour && i18 < (i10 = this.X)) {
                i18 = i10;
            }
            this.X = i18;
            int i20 = this.f1106e0;
            if (i18 < i20) {
                this.X = i20;
            }
        }
    }

    public void Q(androidx.constraintlayout.core.c cVar, boolean z) {
        int i10;
        int i11;
        androidx.constraintlayout.core.widgets.analyzer.d dVar;
        androidx.constraintlayout.core.widgets.analyzer.c cVar2;
        cVar.getClass();
        int iN = androidx.constraintlayout.core.c.n(this.J);
        int iN2 = androidx.constraintlayout.core.c.n(this.K);
        int iN3 = androidx.constraintlayout.core.c.n(this.L);
        int iN4 = androidx.constraintlayout.core.c.n(this.M);
        if (z && (cVar2 = this.f1103d) != null) {
            DependencyNode dependencyNode = cVar2.h;
            if (dependencyNode.f1153j) {
                DependencyNode dependencyNode2 = cVar2.f1171i;
                if (dependencyNode2.f1153j) {
                    iN = dependencyNode.f1151g;
                    iN3 = dependencyNode2.f1151g;
                }
            }
        }
        if (z && (dVar = this.f1105e) != null) {
            DependencyNode dependencyNode3 = dVar.h;
            if (dependencyNode3.f1153j) {
                DependencyNode dependencyNode4 = dVar.f1171i;
                if (dependencyNode4.f1153j) {
                    iN2 = dependencyNode3.f1151g;
                    iN4 = dependencyNode4.f1151g;
                }
            }
        }
        int i12 = iN4 - iN2;
        if (iN3 - iN < 0 || i12 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i13 = iN3 - iN;
        int i14 = iN4 - iN2;
        this.f1100a0 = iN;
        this.b0 = iN2;
        if (this.f1113i0 == 8) {
            this.W = 0;
            this.X = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.f1136a;
        if (dimensionBehaviour == dimensionBehaviour2 && i13 < (i11 = this.W)) {
            i13 = i11;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i14 < (i10 = this.X)) {
            i14 = i10;
        }
        this.W = i13;
        this.X = i14;
        int i15 = this.f1106e0;
        if (i14 < i15) {
            this.X = i15;
        }
        int i16 = this.f1104d0;
        if (i13 < i16) {
            this.W = i16;
        }
        int i17 = this.f1132v;
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.f1138c;
        if (i17 > 0 && dimensionBehaviour == dimensionBehaviour3) {
            this.W = Math.min(this.W, i17);
        }
        int i18 = this.f1135y;
        if (i18 > 0 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
            this.X = Math.min(this.X, i18);
        }
        int i19 = this.W;
        if (i13 != i19) {
            this.h = i19;
        }
        int i20 = this.X;
        if (i14 != i20) {
            this.f1112i = i20;
        }
    }

    public final void a(d dVar, androidx.constraintlayout.core.c cVar, HashSet<ConstraintWidget> hashSet, int i10, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, cVar, this);
            hashSet.remove(this);
            b(cVar, dVar.W(64));
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> hashSet2 = this.J.f1083a;
            if (hashSet2 != null) {
                Iterator<ConstraintAnchor> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().f1086d.a(dVar, cVar, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet3 = this.L.f1083a;
            if (hashSet3 != null) {
                Iterator<ConstraintAnchor> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f1086d.a(dVar, cVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSet4 = this.K.f1083a;
        if (hashSet4 != null) {
            Iterator<ConstraintAnchor> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f1086d.a(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet5 = this.M.f1083a;
        if (hashSet5 != null) {
            Iterator<ConstraintAnchor> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f1086d.a(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet6 = this.N.f1083a;
        if (hashSet6 != null) {
            Iterator<ConstraintAnchor> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f1086d.a(dVar, cVar, hashSet, i10, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105  */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36, types: [int] */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r13v49, types: [androidx.constraintlayout.core.widgets.d] */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v15 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r61v0, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v12, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(androidx.constraintlayout.core.c r62, boolean r63) {
        /*
            Method dump skipped, instructions count: 1948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.b(androidx.constraintlayout.core.c, boolean):void");
    }

    public boolean c() {
        return this.f1113i0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x048e A[PHI: r0
      0x048e: PHI (r0v16 int) = (r0v15 int), (r0v20 int), (r0v20 int), (r0v20 int) binds: [B:280:0x047e, B:282:0x0484, B:283:0x0486, B:285:0x048a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(androidx.constraintlayout.core.c r30, boolean r31, boolean r32, boolean r33, boolean r34, androidx.constraintlayout.core.SolverVariable r35, androidx.constraintlayout.core.SolverVariable r36, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r37, boolean r38, androidx.constraintlayout.core.widgets.ConstraintAnchor r39, androidx.constraintlayout.core.widgets.ConstraintAnchor r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.d(androidx.constraintlayout.core.c, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        boolean z;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.f1097k;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.f1096j;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.f1091a;
        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.f1092b;
        ConstraintAnchor.Type type7 = ConstraintAnchor.Type.f1093c;
        ConstraintAnchor.Type type8 = ConstraintAnchor.Type.f1094d;
        ConstraintAnchor.Type type9 = ConstraintAnchor.Type.h;
        if (type == type9) {
            if (type2 != type9) {
                if (type2 == type5 || type2 == type7) {
                    e(type5, constraintWidget, type2, 0);
                    e(type7, constraintWidget, type2, 0);
                    i(type9).a(constraintWidget.i(type2), 0);
                    return;
                } else {
                    if (type2 == type6 || type2 == type8) {
                        e(type6, constraintWidget, type2, 0);
                        e(type8, constraintWidget, type2, 0);
                        i(type9).a(constraintWidget.i(type2), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor constraintAnchorI = i(type5);
            ConstraintAnchor constraintAnchorI2 = i(type7);
            ConstraintAnchor constraintAnchorI3 = i(type6);
            ConstraintAnchor constraintAnchorI4 = i(type8);
            boolean z3 = true;
            if ((constraintAnchorI == null || !constraintAnchorI.h()) && (constraintAnchorI2 == null || !constraintAnchorI2.h())) {
                e(type5, constraintWidget, type5, 0);
                e(type7, constraintWidget, type7, 0);
                z = true;
            } else {
                z = false;
            }
            if ((constraintAnchorI3 == null || !constraintAnchorI3.h()) && (constraintAnchorI4 == null || !constraintAnchorI4.h())) {
                e(type6, constraintWidget, type6, 0);
                e(type8, constraintWidget, type8, 0);
            } else {
                z3 = false;
            }
            if (z && z3) {
                i(type9).a(constraintWidget.i(type9), 0);
                return;
            } else if (z) {
                i(type4).a(constraintWidget.i(type4), 0);
                return;
            } else {
                if (z3) {
                    i(type3).a(constraintWidget.i(type3), 0);
                    return;
                }
                return;
            }
        }
        if (type == type4 && (type2 == type5 || type2 == type7)) {
            ConstraintAnchor constraintAnchorI5 = i(type5);
            ConstraintAnchor constraintAnchorI6 = constraintWidget.i(type2);
            ConstraintAnchor constraintAnchorI7 = i(type7);
            constraintAnchorI5.a(constraintAnchorI6, 0);
            constraintAnchorI7.a(constraintAnchorI6, 0);
            i(type4).a(constraintAnchorI6, 0);
            return;
        }
        if (type == type3 && (type2 == type6 || type2 == type8)) {
            ConstraintAnchor constraintAnchorI8 = constraintWidget.i(type2);
            i(type6).a(constraintAnchorI8, 0);
            i(type8).a(constraintAnchorI8, 0);
            i(type3).a(constraintAnchorI8, 0);
            return;
        }
        if (type == type4 && type2 == type4) {
            i(type5).a(constraintWidget.i(type5), 0);
            i(type7).a(constraintWidget.i(type7), 0);
            i(type4).a(constraintWidget.i(type2), 0);
            return;
        }
        if (type == type3 && type2 == type3) {
            i(type6).a(constraintWidget.i(type6), 0);
            i(type8).a(constraintWidget.i(type8), 0);
            i(type3).a(constraintWidget.i(type2), 0);
            return;
        }
        ConstraintAnchor constraintAnchorI9 = i(type);
        ConstraintAnchor constraintAnchorI10 = constraintWidget.i(type2);
        if (constraintAnchorI9.i(constraintAnchorI10)) {
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.f1095e;
            if (type == type10) {
                ConstraintAnchor constraintAnchorI11 = i(type6);
                ConstraintAnchor constraintAnchorI12 = i(type8);
                if (constraintAnchorI11 != null) {
                    constraintAnchorI11.j();
                }
                if (constraintAnchorI12 != null) {
                    constraintAnchorI12.j();
                }
            } else if (type == type6 || type == type8) {
                ConstraintAnchor constraintAnchorI13 = i(type10);
                if (constraintAnchorI13 != null) {
                    constraintAnchorI13.j();
                }
                ConstraintAnchor constraintAnchorI14 = i(type9);
                if (constraintAnchorI14.f1088f != constraintAnchorI10) {
                    constraintAnchorI14.j();
                }
                ConstraintAnchor constraintAnchorF = i(type).f();
                ConstraintAnchor constraintAnchorI15 = i(type3);
                if (constraintAnchorI15.h()) {
                    constraintAnchorF.j();
                    constraintAnchorI15.j();
                }
            } else if (type == type5 || type == type7) {
                ConstraintAnchor constraintAnchorI16 = i(type9);
                if (constraintAnchorI16.f1088f != constraintAnchorI10) {
                    constraintAnchorI16.j();
                }
                ConstraintAnchor constraintAnchorF2 = i(type).f();
                ConstraintAnchor constraintAnchorI17 = i(type4);
                if (constraintAnchorI17.h()) {
                    constraintAnchorF2.j();
                    constraintAnchorI17.j();
                }
            }
            constraintAnchorI9.a(constraintAnchorI10, i10);
        }
    }

    public final void f(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.f1086d == this) {
            e(constraintAnchor.f1087e, constraintAnchor2.f1086d, constraintAnchor2.f1087e, i10);
        }
    }

    public final void g(androidx.constraintlayout.core.c cVar) {
        cVar.k(this.J);
        cVar.k(this.K);
        cVar.k(this.L);
        cVar.k(this.M);
        if (this.c0 > 0) {
            cVar.k(this.N);
        }
    }

    public final void h() {
        if (this.f1103d == null) {
            this.f1103d = new androidx.constraintlayout.core.widgets.analyzer.c(this);
        }
        if (this.f1105e == null) {
            this.f1105e = new androidx.constraintlayout.core.widgets.analyzer.d(this);
        }
    }

    public ConstraintAnchor i(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.J;
            case 2:
                return this.K;
            case 3:
                return this.L;
            case 4:
                return this.M;
            case 5:
                return this.N;
            case 6:
                return this.Q;
            case 7:
                return this.O;
            case 8:
                return this.P;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final DimensionBehaviour j(int i10) {
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        if (i10 == 0) {
            return dimensionBehaviourArr[0];
        }
        if (i10 == 1) {
            return dimensionBehaviourArr[1];
        }
        return null;
    }

    public final int k() {
        if (this.f1113i0 == 8) {
            return 0;
        }
        return this.X;
    }

    public final ConstraintWidget l(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.M).f1088f) != null && constraintAnchor2.f1088f == constraintAnchor) {
                return constraintAnchor2.f1086d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.L;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1088f;
        if (constraintAnchor4 == null || constraintAnchor4.f1088f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f1086d;
    }

    public final ConstraintWidget m(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.K).f1088f) != null && constraintAnchor2.f1088f == constraintAnchor) {
                return constraintAnchor2.f1086d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.J;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1088f;
        if (constraintAnchor4 == null || constraintAnchor4.f1088f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f1086d;
    }

    public void n(StringBuilder sb2) {
        sb2.append("  " + this.f1114j + ":{\n");
        StringBuilder sb3 = new StringBuilder("    actualWidth:");
        sb3.append(this.W);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.X);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f1100a0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.b0);
        sb2.append("\n");
        p(sb2, "left", this.J);
        p(sb2, "top", this.K);
        p(sb2, "right", this.L);
        p(sb2, "bottom", this.M);
        p(sb2, "baseline", this.N);
        p(sb2, "centerX", this.O);
        p(sb2, "centerY", this.P);
        int i10 = this.W;
        int i11 = this.f1104d0;
        int[] iArr = this.C;
        int i12 = iArr[0];
        int i13 = this.f1131u;
        int i14 = this.r;
        float f8 = this.f1133w;
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        float[] fArr = this.f1121m0;
        float f9 = fArr[0];
        o(sb2, "    width", i10, i11, i12, i13, i14, f8, dimensionBehaviour);
        int i15 = this.X;
        int i16 = this.f1106e0;
        int i17 = iArr[1];
        int i18 = this.f1134x;
        int i19 = this.f1129s;
        float f10 = this.z;
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        float f11 = fArr[1];
        o(sb2, "    height", i15, i16, i17, i18, i19, f10, dimensionBehaviour2);
        float f12 = this.Y;
        int i20 = this.Z;
        if (f12 != 0.0f) {
            sb2.append("    dimensionRatio");
            sb2.append(" :  [");
            sb2.append(f12);
            sb2.append(",");
            sb2.append(i20);
            sb2.append("");
            sb2.append("],\n");
        }
        H(sb2, "    horizontalBias", this.f1108f0, 0.5f);
        H(sb2, "    verticalBias", this.f1110g0, 0.5f);
        G(this.f1117k0, 0, "    horizontalChainStyle", sb2);
        G(this.f1119l0, 0, "    verticalChainStyle", sb2);
        sb2.append("  }");
    }

    public final int q() {
        if (this.f1113i0 == 8) {
            return 0;
        }
        return this.W;
    }

    public final int r() {
        ConstraintWidget constraintWidget = this.V;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f1100a0 : ((d) constraintWidget).f1202y0 + this.f1100a0;
    }

    public final int s() {
        ConstraintWidget constraintWidget = this.V;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.b0 : ((d) constraintWidget).z0 + this.b0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.J
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1088f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.L
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1088f
            if (r4 == 0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = r1
        L17:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.K
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1088f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r4.M
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1088f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.N
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1088f
            if (r4 == 0) goto L36
            r4 = r2
            goto L37
        L36:
            r4 = r1
        L37:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.t(int):boolean");
    }

    public String toString() {
        StringBuilder sbB = v1.d.b("");
        sbB.append(this.f1115j0 != null ? ai.onnxruntime.a.o(new StringBuilder("id: "), this.f1115j0, " ") : "");
        sbB.append("(");
        sbB.append(this.f1100a0);
        sbB.append(", ");
        sbB.append(this.b0);
        sbB.append(") - (");
        sbB.append(this.W);
        sbB.append(" x ");
        return ai.onnxruntime.a.j(")", this.X, sbB);
    }

    public final boolean u(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor5 = this.J;
            ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1088f;
            if (constraintAnchor6 == null || !constraintAnchor6.f1085c || (constraintAnchor4 = (constraintAnchor3 = this.L).f1088f) == null || !constraintAnchor4.f1085c) {
                return false;
            }
            return (constraintAnchor4.d() - constraintAnchor3.e()) - (constraintAnchor5.e() + constraintAnchor5.f1088f.d()) >= i11;
        }
        ConstraintAnchor constraintAnchor7 = this.K;
        ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1088f;
        if (constraintAnchor8 == null || !constraintAnchor8.f1085c || (constraintAnchor2 = (constraintAnchor = this.M).f1088f) == null || !constraintAnchor2.f1085c) {
            return false;
        }
        return (constraintAnchor2.d() - constraintAnchor.e()) - (constraintAnchor7.e() + constraintAnchor7.f1088f.d()) >= i11;
    }

    public final void v(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        i(type).b(constraintWidget.i(type2), i10, i11, true);
    }

    public final boolean w(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.R;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i11];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1088f;
        return (constraintAnchor4 == null || constraintAnchor4.f1088f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i11 + 1]).f1088f) == null || constraintAnchor2.f1088f != constraintAnchor) ? false : true;
    }

    public final boolean x() {
        ConstraintAnchor constraintAnchor = this.J;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1088f;
        if (constraintAnchor2 != null && constraintAnchor2.f1088f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.L;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1088f;
        return constraintAnchor4 != null && constraintAnchor4.f1088f == constraintAnchor3;
    }

    public final boolean y() {
        ConstraintAnchor constraintAnchor = this.K;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1088f;
        if (constraintAnchor2 != null && constraintAnchor2.f1088f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.M;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1088f;
        return constraintAnchor4 != null && constraintAnchor4.f1088f == constraintAnchor3;
    }

    public final boolean z() {
        return this.f1109g && this.f1113i0 != 8;
    }
}
