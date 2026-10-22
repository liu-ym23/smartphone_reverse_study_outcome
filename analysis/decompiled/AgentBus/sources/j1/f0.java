package j1;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.stepos.agentbus.R;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends o2.b {
    public static final k.s Q;
    public boolean A;
    public c0 B;
    public k.t C;
    public final k.u D;
    public final k.r E;
    public final k.r F;
    public final String G;
    public final String H;
    public final u5.h I;
    public final k.t J;
    public t1 K;
    public boolean L;
    public final k.r M;
    public final androidx.lifecycle.a0 N;
    public final ArrayList O;
    public final e0 P;

    /* renamed from: d, reason: collision with root package name */
    public final y f5138d;

    /* renamed from: e, reason: collision with root package name */
    public int f5139e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f5140f;

    /* renamed from: g, reason: collision with root package name */
    public final AccessibilityManager f5141g;

    /* renamed from: h, reason: collision with root package name */
    public long f5142h;

    /* renamed from: i, reason: collision with root package name */
    public final z f5143i;

    /* renamed from: j, reason: collision with root package name */
    public final a0 f5144j;

    /* renamed from: k, reason: collision with root package name */
    public List f5145k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f5146l;

    /* renamed from: m, reason: collision with root package name */
    public final q6.b f5147m;

    /* renamed from: n, reason: collision with root package name */
    public int f5148n;

    /* renamed from: o, reason: collision with root package name */
    public int f5149o;

    /* renamed from: p, reason: collision with root package name */
    public p2.h f5150p;

    /* renamed from: q, reason: collision with root package name */
    public p2.h f5151q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5152r;

    /* renamed from: s, reason: collision with root package name */
    public final k.t f5153s;

    /* renamed from: t, reason: collision with root package name */
    public final k.t f5154t;

    /* renamed from: u, reason: collision with root package name */
    public final k.i0 f5155u;

    /* renamed from: v, reason: collision with root package name */
    public final k.i0 f5156v;

    /* renamed from: w, reason: collision with root package name */
    public int f5157w;

    /* renamed from: x, reason: collision with root package name */
    public Integer f5158x;

    /* renamed from: y, reason: collision with root package name */
    public final k.f f5159y;

    /* renamed from: z, reason: collision with root package name */
    public final ka.g f5160z;

    static {
        int[] iArr = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        int i2 = k.i.f5494a;
        k.s sVar = new k.s(32);
        int i10 = sVar.f5530b;
        if (i10 < 0) {
            l.a.d("");
            throw null;
        }
        int i11 = i10 + 32;
        sVar.b(i11);
        int[] iArr2 = sVar.f5529a;
        int i12 = sVar.f5530b;
        if (i10 != i12) {
            d7.n.W(iArr2, iArr2, i11, i10, i12);
        }
        d7.n.Z(iArr, iArr2, i10, 0, 12);
        sVar.f5530b += 32;
        Q = sVar;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [j1.z] */
    /* JADX WARN: Type inference failed for: r3v4, types: [j1.a0] */
    public f0(y yVar) {
        this.f5138d = yVar;
        int i2 = 0;
        this.f5140f = new e0(this, i2);
        Object systemService = yVar.getContext().getSystemService("accessibility");
        q7.k.c(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.f5141g = accessibilityManager;
        this.f5142h = 100L;
        this.f5143i = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: j1.z
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z4) {
                f0 f0Var = this.f5396a;
                f0Var.f5145k = z4 ? f0Var.f5141g.getEnabledAccessibilityServiceList(-1) : d7.z.f2978f;
            }
        };
        this.f5144j = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: j1.a0
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z4) {
                f0 f0Var = this.f5092a;
                f0Var.f5145k = f0Var.f5141g.getEnabledAccessibilityServiceList(-1);
            }
        };
        this.f5145k = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.f5146l = new Handler(Looper.getMainLooper());
        this.f5147m = new q6.b(this);
        this.f5148n = Integer.MIN_VALUE;
        this.f5149o = Integer.MIN_VALUE;
        this.f5153s = new k.t();
        this.f5154t = new k.t();
        this.f5155u = new k.i0();
        this.f5156v = new k.i0();
        this.f5157w = -1;
        this.f5159y = new k.f(0);
        this.f5160z = a.a.b(1, 6, null);
        this.A = true;
        k.t tVar = k.k.f5504a;
        q7.k.c(tVar, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        this.C = tVar;
        this.D = new k.u();
        this.E = new k.r();
        this.F = new k.r();
        this.G = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.H = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.I = new u5.h(8);
        this.J = new k.t();
        p1.n nVarA = yVar.getSemanticsOwner().a();
        q7.k.c(tVar, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        this.K = new t1(nVarA, tVar);
        int i10 = k.h.f5492a;
        this.M = new k.r();
        yVar.addOnAttachStateChangeListener(new b0(i2, this));
        this.N = new androidx.lifecycle.a0(5, this);
        this.O = new ArrayList();
        this.P = new e0(this, 1);
    }

    public static Rect D(u0.w wVar) {
        if (!(wVar instanceof u0.u) && !(wVar instanceof u0.v)) {
            return null;
        }
        t0.c cVarA = wVar.a();
        return new Rect((int) cVarA.f9656a, (int) cVarA.f9657b, (int) cVarA.f9658c, (int) cVarA.f9659d);
    }

    public static float[] E(u0.w wVar) {
        if (!(wVar instanceof u0.v)) {
            return null;
        }
        t0.d dVar = ((u0.v) wVar).f9926a;
        long j2 = dVar.f9667h;
        long j4 = dVar.f9666g;
        long j10 = dVar.f9665f;
        long j11 = dVar.f9664e;
        return new float[]{Float.intBitsToFloat((int) (j11 >> 32)), Float.intBitsToFloat((int) (j11 & 4294967295L)), Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L)), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L))};
    }

    public static Region F(u0.w wVar) {
        if (!(wVar instanceof u0.t)) {
            return null;
        }
        u0.t tVar = (u0.t) wVar;
        t0.c cVarA = tVar.a();
        Region region = new Region(new Rect((int) cVarA.f9656a, (int) cVarA.f9657b, (int) cVarA.f9658c, (int) cVarA.f9659d));
        Region region2 = new Region();
        u0.f fVar = tVar.f9924a;
        if (!(fVar instanceof u0.f)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        region2.setPath(fVar.f9903a, region);
        return region2;
    }

    public static CharSequence G(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            int i2 = 100000;
            if (charSequence.length() > 100000) {
                if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
                    i2 = 99999;
                }
                CharSequence charSequenceSubSequence = charSequence.subSequence(0, i2);
                q7.k.c(charSequenceSubSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
                return charSequenceSubSequence;
            }
        }
        return charSequence;
    }

    public static String m(p1.n nVar) {
        s1.e eVar;
        if (nVar != null) {
            p1.i iVar = nVar.f8315d;
            k.a0 a0Var = iVar.f8304f;
            p1.v vVar = p1.s.f8344a;
            if (a0Var.c(vVar)) {
                return f2.a.a((List) iVar.f(vVar), ",", null, 62);
            }
            p1.v vVar2 = p1.s.C;
            if (a0Var.c(vVar2)) {
                Object objG = a0Var.g(vVar2);
                if (objG == null) {
                    objG = null;
                }
                s1.e eVar2 = (s1.e) objG;
                if (eVar2 != null) {
                    return eVar2.f9246g;
                }
            } else {
                Object objG2 = a0Var.g(p1.s.f8368y);
                if (objG2 == null) {
                    objG2 = null;
                }
                List list = (List) objG2;
                if (list != null && (eVar = (s1.e) d7.r.P0(list)) != null) {
                    return eVar.f9246g;
                }
            }
        }
        return null;
    }

    public static final boolean p(p1.g gVar, float f10) {
        o.u0 u0Var = gVar.f8276a;
        if (f10 >= 0.0f || ((Number) u0Var.c()).floatValue() <= 0.0f) {
            return f10 > 0.0f && ((Number) u0Var.c()).floatValue() < ((Number) gVar.f8277b.c()).floatValue();
        }
        return true;
    }

    public static final boolean q(p1.g gVar) {
        o.u0 u0Var = gVar.f8276a;
        if (((Number) u0Var.c()).floatValue() > 0.0f) {
            return true;
        }
        ((Number) u0Var.c()).floatValue();
        ((Number) gVar.f8277b.c()).floatValue();
        return false;
    }

    public static final boolean r(p1.g gVar) {
        o.u0 u0Var = gVar.f8276a;
        if (((Number) u0Var.c()).floatValue() < ((Number) gVar.f8277b.c()).floatValue()) {
            return true;
        }
        ((Number) u0Var.c()).floatValue();
        return false;
    }

    public static /* synthetic */ void w(f0 f0Var, int i2, int i10, Integer num, int i11) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        f0Var.v(i2, i10, num, null);
    }

    public final void A(i1.f0 f0Var, k.u uVar) {
        p1.i iVarQ;
        if (f0Var.B() && !this.f5138d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(f0Var)) {
            i1.f0 f0Var2 = null;
            if (!f0Var.H.h(8)) {
                f0Var = f0Var.n();
                while (true) {
                    if (f0Var == null) {
                        f0Var = null;
                        break;
                    } else if (f0Var.H.h(8)) {
                        break;
                    } else {
                        f0Var = f0Var.n();
                    }
                }
            }
            if (f0Var == null || (iVarQ = f0Var.q()) == null) {
                return;
            }
            if (!iVarQ.f8306h) {
                i1.f0 f0VarN = f0Var.n();
                while (true) {
                    if (f0VarN != null) {
                        p1.i iVarQ2 = f0VarN.q();
                        if (iVarQ2 != null && iVarQ2.f8306h) {
                            f0Var2 = f0VarN;
                            break;
                        }
                        f0VarN = f0VarN.n();
                    } else {
                        break;
                    }
                }
                if (f0Var2 != null) {
                    f0Var = f0Var2;
                }
            }
            int i2 = f0Var.f4453g;
            if (uVar.a(i2)) {
                w(this, s(i2), 2048, 1, 8);
            }
        }
    }

    public final void B(i1.f0 f0Var) {
        if (f0Var.B() && !this.f5138d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(f0Var)) {
            int i2 = f0Var.f4453g;
            p1.g gVar = (p1.g) this.f5153s.b(i2);
            p1.g gVar2 = (p1.g) this.f5154t.b(i2);
            if (gVar == null && gVar2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventG = g(i2, 4096);
            if (gVar != null) {
                accessibilityEventG.setScrollX((int) ((Number) gVar.f8276a.c()).floatValue());
                accessibilityEventG.setMaxScrollX((int) ((Number) gVar.f8277b.c()).floatValue());
            }
            if (gVar2 != null) {
                accessibilityEventG.setScrollY((int) ((Number) gVar2.f8276a.c()).floatValue());
                accessibilityEventG.setMaxScrollY((int) ((Number) gVar2.f8277b.c()).floatValue());
            }
            u(accessibilityEventG);
        }
    }

    public final boolean C(p1.n nVar, int i2, int i10, boolean z4) {
        String strM;
        p1.i iVar = nVar.f8315d;
        int i11 = nVar.f8318g;
        p1.v vVar = p1.h.f8285h;
        if (iVar.f8304f.c(vVar) && k0.d(nVar)) {
            p7.o oVar = (p7.o) ((p1.a) nVar.f8315d.f(vVar)).f8267b;
            if (oVar != null) {
                return ((Boolean) oVar.j(Integer.valueOf(i2), Integer.valueOf(i10), Boolean.valueOf(z4))).booleanValue();
            }
        } else if ((i2 != i10 || i10 != this.f5157w) && (strM = m(nVar)) != null) {
            if (i2 < 0 || i2 != i10 || i10 > strM.length()) {
                i2 = -1;
            }
            this.f5157w = i2;
            boolean z10 = strM.length() > 0;
            u(i(s(i11), z10 ? Integer.valueOf(this.f5157w) : null, z10 ? Integer.valueOf(this.f5157w) : null, z10 ? Integer.valueOf(strM.length()) : null, strM));
            y(i11);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x013f, code lost:
    
        r28 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0149, code lost:
    
        if (((r7 & ((~r7) << 6)) & r20) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014b, code lost:
    
        r25 = -1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H() {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.f0.H():void");
    }

    @Override // o2.b
    public final q6.b a(View view) {
        return this.f5147m;
    }

    public final void b(int i2, p2.h hVar, String str, Bundle bundle) {
        p1.n nVar;
        Region regionF;
        float[] fArrE;
        Rect rectD;
        int i10;
        float fH;
        float fH2;
        float fG;
        float fG2;
        AccessibilityNodeInfo accessibilityNodeInfo;
        int i11;
        RectF rectF;
        AccessibilityNodeInfo accessibilityNodeInfo2 = hVar.f8393a;
        p1.o oVar = (p1.o) l().b(i2);
        if (oVar == null || (nVar = oVar.f8319a) == null) {
            return;
        }
        p1.i iVar = nVar.f8315d;
        k.a0 a0Var = iVar.f8304f;
        String strM = m(nVar);
        if (q7.k.a(str, this.G)) {
            int iD = this.E.d(i2);
            if (iD != -1) {
                accessibilityNodeInfo2.getExtras().putInt(str, iD);
                return;
            }
            return;
        }
        if (q7.k.a(str, this.H)) {
            int iD2 = this.F.d(i2);
            if (iD2 != -1) {
                accessibilityNodeInfo2.getExtras().putInt(str, iD2);
                return;
            }
            return;
        }
        boolean z4 = false;
        if (!a0Var.c(p1.h.f8278a) || bundle == null || !q7.k.a(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            p1.v vVar = p1.s.f8366w;
            if (a0Var.c(vVar) && bundle != null && q7.k.a(str, "androidx.compose.ui.semantics.testTag")) {
                Object objG = a0Var.g(vVar);
                String str2 = (String) (objG == null ? null : objG);
                if (str2 != null) {
                    accessibilityNodeInfo2.getExtras().putCharSequence(str, str2);
                    return;
                }
                return;
            }
            if (q7.k.a(str, "androidx.compose.ui.semantics.id")) {
                accessibilityNodeInfo2.getExtras().putInt(str, nVar.f8318g);
                return;
            }
            if (q7.k.a(str, "androidx.compose.ui.semantics.shapeType")) {
                Object objG2 = a0Var.g(p1.s.K);
                u0.c0 c0Var = (u0.c0) (objG2 == null ? null : objG2);
                if (c0Var != null) {
                    u0.w wVarH = h(c0Var, nVar);
                    if (wVarH instanceof u0.u) {
                        accessibilityNodeInfo2.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 0);
                        accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", D(wVarH));
                        return;
                    } else if (wVarH instanceof u0.v) {
                        accessibilityNodeInfo2.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 1);
                        accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", D(wVarH));
                        accessibilityNodeInfo2.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", E(wVarH));
                        return;
                    } else {
                        if (!(wVarH instanceof u0.t)) {
                            throw new a4.u();
                        }
                        accessibilityNodeInfo2.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 2);
                        accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", F(wVarH));
                        return;
                    }
                }
                return;
            }
            if (q7.k.a(str, "androidx.compose.ui.semantics.shapeRect")) {
                Object objG3 = a0Var.g(p1.s.K);
                u0.c0 c0Var2 = (u0.c0) (objG3 == null ? null : objG3);
                if (c0Var2 == null || (rectD = D(h(c0Var2, nVar))) == null) {
                    return;
                }
                accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", rectD);
                return;
            }
            if (q7.k.a(str, "androidx.compose.ui.semantics.shapeCorners")) {
                Object objG4 = a0Var.g(p1.s.K);
                u0.c0 c0Var3 = (u0.c0) (objG4 == null ? null : objG4);
                if (c0Var3 == null || (fArrE = E(h(c0Var3, nVar))) == null) {
                    return;
                }
                accessibilityNodeInfo2.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", fArrE);
                return;
            }
            if (q7.k.a(str, "androidx.compose.ui.semantics.shapeRegion")) {
                Object objG5 = a0Var.g(p1.s.K);
                u0.c0 c0Var4 = (u0.c0) (objG5 == null ? null : objG5);
                if (c0Var4 == null || (regionF = F(h(c0Var4, nVar))) == null) {
                    return;
                }
                accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", regionF);
                return;
            }
            return;
        }
        int i12 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i13 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i13 > 0 && i12 >= 0) {
            if (i12 < (strM != null ? strM.length() : Integer.MAX_VALUE)) {
                s1.e0 e0VarN = k0.n(iVar);
                if (e0VarN == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i14 = 0;
                while (i14 < i13) {
                    int i15 = i12 + i14;
                    if (i15 >= e0VarN.f9249a.f9235a.f9246g.length()) {
                        arrayList.add(z4);
                        i10 = i12;
                        accessibilityNodeInfo = accessibilityNodeInfo2;
                        i11 = i13;
                    } else {
                        l0.i iVar2 = e0VarN.f9250b;
                        s1.e eVar = (s1.e) ((a3.b) iVar2.f5755c).f162f;
                        if (i15 < 0 || i15 >= eVar.f9246g.length()) {
                            StringBuilder sbN = a1.a.n(i15, "offset(", ") is out of bounds [0, ");
                            sbN.append(eVar.f9246g.length());
                            sbN.append(')');
                            x1.a.a(sbN.toString());
                        }
                        ArrayList arrayList2 = (ArrayList) iVar2.f5757e;
                        s1.m mVar = (s1.m) arrayList2.get(s1.z.c(i15, arrayList2));
                        s1.a aVar = mVar.f9283a;
                        int iA = mVar.a(i15);
                        CharSequence charSequence = aVar.f9208e;
                        if (iA < 0 || iA >= charSequence.length()) {
                            StringBuilder sbN2 = a1.a.n(iA, "offset(", ") is out of bounds [0,");
                            sbN2.append(charSequence.length());
                            sbN2.append(')');
                            x1.a.a(sbN2.toString());
                        }
                        t1.h hVar2 = aVar.f9207d;
                        Layout layout = hVar2.f9691e;
                        int lineForOffset = layout.getLineForOffset(iA);
                        float f10 = hVar2.f(lineForOffset);
                        float fD = hVar2.d(lineForOffset);
                        i10 = i12;
                        boolean z10 = layout.getParagraphDirection(lineForOffset) == 1;
                        boolean zIsRtlCharAt = layout.isRtlCharAt(iA);
                        if (!z10 || zIsRtlCharAt) {
                            if (z10 && zIsRtlCharAt) {
                                fG = hVar2.h(iA, false);
                                fG2 = hVar2.h(iA + 1, true);
                            } else if (zIsRtlCharAt) {
                                fG = hVar2.g(iA, false);
                                fG2 = hVar2.g(iA + 1, true);
                            } else {
                                fH = hVar2.h(iA, false);
                                fH2 = hVar2.h(iA + 1, true);
                            }
                            float f11 = fG;
                            fH = fG2;
                            fH2 = f11;
                        } else {
                            fH = hVar2.g(iA, false);
                            fH2 = hVar2.g(iA + 1, true);
                        }
                        RectF rectF2 = new RectF(fH, f10, fH2, fD);
                        accessibilityNodeInfo = accessibilityNodeInfo2;
                        i11 = i13;
                        long jFloatToRawIntBits = (Float.floatToRawIntBits(mVar.f9288f) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32);
                        int i16 = (int) (jFloatToRawIntBits >> 32);
                        int i17 = (int) (jFloatToRawIntBits & 4294967295L);
                        t0.c cVar = new t0.c(Float.intBitsToFloat(i16) + rectF2.left, Float.intBitsToFloat(i17) + rectF2.top, Float.intBitsToFloat(i16) + rectF2.right, Float.intBitsToFloat(i17) + rectF2.bottom);
                        i1.d1 d1VarD = nVar.d();
                        long jJ0 = 0;
                        if (d1VarD != null) {
                            if (!d1VarD.z0().f6810s) {
                                d1VarD = null;
                            }
                            if (d1VarD != null) {
                                jJ0 = d1VarD.J0(0L);
                            }
                        }
                        t0.c cVarE = cVar.e(jJ0);
                        t0.c cVarG = nVar.g();
                        if ((((((cVarE.f9656a > cVarG.f9658c ? 1 : (cVarE.f9656a == cVarG.f9658c ? 0 : -1)) < 0) & ((cVarG.f9656a > cVarE.f9658c ? 1 : (cVarG.f9656a == cVarE.f9658c ? 0 : -1)) < 0)) & ((cVarE.f9657b > cVarG.f9659d ? 1 : (cVarE.f9657b == cVarG.f9659d ? 0 : -1)) < 0)) & ((cVarG.f9657b > cVarE.f9659d ? 1 : (cVarG.f9657b == cVarE.f9659d ? 0 : -1)) < 0) ? cVarE.c(cVarG) : null) != null) {
                            y yVar = this.f5138d;
                            long jP = yVar.p((Float.floatToRawIntBits(r1.f9657b) & 4294967295L) | (Float.floatToRawIntBits(r1.f9656a) << 32));
                            long jP2 = yVar.p((Float.floatToRawIntBits(r1.f9658c) << 32) | (Float.floatToRawIntBits(r1.f9659d) & 4294967295L));
                            int i18 = (int) (jP >> 32);
                            int i19 = (int) (jP2 >> 32);
                            int i20 = (int) (jP & 4294967295L);
                            int i21 = (int) (jP2 & 4294967295L);
                            rectF = new RectF(Math.min(Float.intBitsToFloat(i18), Float.intBitsToFloat(i19)), Math.min(Float.intBitsToFloat(i20), Float.intBitsToFloat(i21)), Math.max(Float.intBitsToFloat(i18), Float.intBitsToFloat(i19)), Math.max(Float.intBitsToFloat(i20), Float.intBitsToFloat(i21)));
                        } else {
                            rectF = null;
                        }
                        arrayList.add(rectF);
                    }
                    i14++;
                    i13 = i11;
                    accessibilityNodeInfo2 = accessibilityNodeInfo;
                    i12 = i10;
                    z4 = false;
                }
                accessibilityNodeInfo2.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                return;
            }
        }
        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
    }

    public final Rect c(p1.o oVar) {
        d2.j jVar = oVar.f8320b;
        float f10 = jVar.f2788a;
        float f11 = jVar.f2789b;
        long jFloatToRawIntBits = Float.floatToRawIntBits(f10);
        y yVar = this.f5138d;
        long jP = yVar.p((Float.floatToRawIntBits(f11) & 4294967295L) | (jFloatToRawIntBits << 32));
        float f12 = jVar.f2790c;
        float f13 = jVar.f2791d;
        long jP2 = yVar.p((Float.floatToRawIntBits(f12) << 32) | (Float.floatToRawIntBits(f13) & 4294967295L));
        int i2 = (int) (jP >> 32);
        int i10 = (int) (jP2 >> 32);
        int i11 = (int) (jP & 4294967295L);
        int i12 = (int) (jP2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i2), Float.intBitsToFloat(i10))), (int) Math.floor(Math.min(Float.intBitsToFloat(i11), Float.intBitsToFloat(i12))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i2), Float.intBitsToFloat(i10))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i11), Float.intBitsToFloat(i12))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ed, code lost:
    
        if (ia.d0.g(r5, r2) == r3) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x005d, B:28:0x006f, B:30:0x0077, B:32:0x0080, B:34:0x0086, B:35:0x0095, B:37:0x009d, B:20:0x0047, B:23:0x004e), top: B:57:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ed -> B:50:0x00f0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(i7.c r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.f0.d(i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(boolean r22, int r23, long r24) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.f0.e(boolean, int, long):boolean");
    }

    public final void f() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (n()) {
                t(this.f5138d.getSemanticsOwner().a(), this.K);
            }
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                z(l());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    H();
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public final AccessibilityEvent g(int i2, int i10) {
        p1.o oVar;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        y yVar = this.f5138d;
        accessibilityEventObtain.setPackageName(yVar.getContext().getPackageName());
        accessibilityEventObtain.setSource(yVar, i2);
        if (n() && (oVar = (p1.o) l().b(i2)) != null) {
            p1.n nVar = oVar.f8319a;
            accessibilityEventObtain.setPassword(nVar.f8315d.f8304f.c(p1.s.G));
            Object objG = nVar.f8315d.f8304f.g(p1.s.f8357n);
            if (objG == null) {
                objG = null;
            }
            boolean zA = q7.k.a(objG, Boolean.TRUE);
            if (Build.VERSION.SDK_INT >= 34) {
                p2.b.f(accessibilityEventObtain, zA);
            }
        }
        return accessibilityEventObtain;
    }

    public final u0.w h(u0.c0 c0Var, p1.n nVar) {
        i1.d1 d1VarD = nVar.d();
        return c0Var.a(ib.k.W(d1VarD != null ? d1VarD.f3758h : 0L), nVar.f8314c.B, this.f5138d.getDensity());
    }

    public final AccessibilityEvent i(int i2, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventG = g(i2, NanoHTTPD.HTTPSession.BUFSIZE);
        if (num != null) {
            accessibilityEventG.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventG.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventG.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventG.getText().add(charSequence);
        }
        return accessibilityEventG;
    }

    public final int j(p1.n nVar) {
        p1.i iVar = nVar.f8315d;
        p1.i iVar2 = nVar.f8315d;
        p1.v vVar = p1.s.f8344a;
        if (!iVar.f8304f.c(p1.s.f8344a)) {
            p1.v vVar2 = p1.s.D;
            if (iVar2.f8304f.c(vVar2)) {
                return (int) (((s1.g0) iVar2.f(vVar2)).f9270a & 4294967295L);
            }
        }
        return this.f5157w;
    }

    public final int k(p1.n nVar) {
        p1.i iVar = nVar.f8315d;
        p1.i iVar2 = nVar.f8315d;
        p1.v vVar = p1.s.f8344a;
        if (!iVar.f8304f.c(p1.s.f8344a)) {
            p1.v vVar2 = p1.s.D;
            if (iVar2.f8304f.c(vVar2)) {
                return (int) (((s1.g0) iVar2.f(vVar2)).f9270a >> 32);
            }
        }
        return this.f5157w;
    }

    public final k.j l() {
        if (this.A) {
            this.A = false;
            y yVar = this.f5138d;
            this.C = p1.q.b(yVar.getSemanticsOwner());
            if (n()) {
                k.t tVar = this.C;
                Resources resources = yVar.getContext().getResources();
                k.r rVar = this.E;
                rVar.a();
                k.r rVar2 = this.F;
                rVar2.a();
                p1.o oVar = (p1.o) tVar.b(-1);
                p1.n nVar = oVar != null ? oVar.f8319a : null;
                q7.k.b(nVar);
                ArrayList arrayListB = p1.x.b(nVar, new c1.w(7, tVar), new c1.w(8, resources), a.a.S(nVar));
                int iT0 = d7.s.t0(arrayListB);
                int i2 = 1;
                if (1 <= iT0) {
                    while (true) {
                        int i10 = ((p1.n) arrayListB.get(i2 - 1)).f8318g;
                        int i11 = ((p1.n) arrayListB.get(i2)).f8318g;
                        rVar.f(i10, i11);
                        rVar2.f(i11, i10);
                        if (i2 == iT0) {
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return this.C;
    }

    public final boolean n() {
        return this.f5141g.isEnabled() && !this.f5145k.isEmpty();
    }

    public final void o(i1.f0 f0Var) {
        if (this.f5159y.add(f0Var)) {
            this.f5160z.u(c7.r.f1986a);
        }
    }

    public final int s(int i2) {
        if (i2 == this.f5138d.getSemanticsOwner().a().f8318g) {
            return -1;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(p1.n r20, j1.t1 r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            int[] r3 = k.l.f5505a
            k.u r3 = new k.u
            r3.<init>()
            r4 = 4
            java.util.List r5 = p1.n.j(r4, r1)
            i1.f0 r6 = r1.f8314c
            int r7 = r5.size()
            r8 = 0
            r9 = r8
        L1a:
            if (r9 >= r7) goto L40
            java.lang.Object r10 = r5.get(r9)
            p1.n r10 = (p1.n) r10
            k.j r11 = r0.l()
            int r10 = r10.f8318g
            boolean r11 = r11.a(r10)
            if (r11 == 0) goto L3d
            k.u r11 = r2.f5335b
            boolean r11 = r11.b(r10)
            if (r11 != 0) goto L3a
            r0.o(r6)
            return
        L3a:
            r3.a(r10)
        L3d:
            int r9 = r9 + 1
            goto L1a
        L40:
            k.u r2 = r2.f5335b
            int[] r5 = r2.f5533b
            long[] r2 = r2.f5532a
            int r7 = r2.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L8b
            r9 = r8
        L4c:
            r10 = r2[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L86
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r8
        L66:
            if (r14 >= r12) goto L84
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L80
            int r15 = r9 << 3
            int r15 = r15 + r14
            r15 = r5[r15]
            boolean r15 = r3.b(r15)
            if (r15 != 0) goto L80
            r0.o(r6)
            return
        L80:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L66
        L84:
            if (r12 != r13) goto L8b
        L86:
            if (r9 == r7) goto L8b
            int r9 = r9 + 1
            goto L4c
        L8b:
            java.util.List r1 = p1.n.j(r4, r1)
            int r2 = r1.size()
        L93:
            if (r8 >= r2) goto Lb9
            java.lang.Object r3 = r1.get(r8)
            p1.n r3 = (p1.n) r3
            k.t r4 = r0.J
            int r5 = r3.f8318g
            java.lang.Object r4 = r4.b(r5)
            j1.t1 r4 = (j1.t1) r4
            if (r4 == 0) goto Lb6
            k.j r5 = r0.l()
            int r6 = r3.f8318g
            boolean r5 = r5.a(r6)
            if (r5 == 0) goto Lb6
            r0.t(r3, r4)
        Lb6:
            int r8 = r8 + 1
            goto L93
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.f0.t(p1.n, j1.t1):void");
    }

    public final boolean u(AccessibilityEvent accessibilityEvent) {
        if (!n()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.f5152r = true;
        }
        try {
            return ((Boolean) this.f5140f.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.f5152r = false;
        }
    }

    public final boolean v(int i2, int i10, Integer num, List list) {
        if (i2 == Integer.MIN_VALUE || !n()) {
            return false;
        }
        AccessibilityEvent accessibilityEventG = g(i2, i10);
        if (num != null) {
            accessibilityEventG.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventG.setContentDescription(f2.a.a(list, ",", null, 62));
        }
        return u(accessibilityEventG);
    }

    public final void x(String str, int i2, int i10) {
        AccessibilityEvent accessibilityEventG = g(s(i2), 32);
        accessibilityEventG.setContentChangeTypes(i10);
        if (str != null) {
            accessibilityEventG.getText().add(str);
        }
        u(accessibilityEventG);
    }

    public final void y(int i2) {
        c0 c0Var = this.B;
        if (c0Var != null) {
            p1.n nVar = c0Var.f5108a;
            if (i2 != nVar.f8318g) {
                return;
            }
            if (SystemClock.uptimeMillis() - c0Var.f5113f <= 1000) {
                AccessibilityEvent accessibilityEventG = g(s(nVar.f8318g), 131072);
                accessibilityEventG.setFromIndex(c0Var.f5111d);
                accessibilityEventG.setToIndex(c0Var.f5112e);
                accessibilityEventG.setAction(c0Var.f5109b);
                accessibilityEventG.setMovementGranularity(c0Var.f5110c);
                accessibilityEventG.getText().add(m(nVar));
                u(accessibilityEventG);
            }
        }
        this.B = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(k.j r58) {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.f0.z(k.j):void");
    }
}
