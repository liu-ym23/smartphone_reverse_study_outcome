package v1;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends n3.b {
    public static final p.t N;
    public p.v A;
    public p.s B;
    public p.s C;
    public String D;
    public String E;
    public p5.m F;
    public p.u G;
    public o1 H;
    public boolean I;
    public p.s J;
    public a4.t K;
    public ArrayList L;
    public z M;

    /* renamed from: a, reason: collision with root package name */
    public t f14331a;

    /* renamed from: b, reason: collision with root package name */
    public int f14332b;

    /* renamed from: c, reason: collision with root package name */
    public z f14333c;

    /* renamed from: d, reason: collision with root package name */
    public AccessibilityManager f14334d;

    /* renamed from: e, reason: collision with root package name */
    public long f14335e;

    /* renamed from: f, reason: collision with root package name */
    public u f14336f;

    /* renamed from: g, reason: collision with root package name */
    public v f14337g;

    /* renamed from: h, reason: collision with root package name */
    public List f14338h;
    public Handler i;

    /* renamed from: j, reason: collision with root package name */
    public w f14339j;

    /* renamed from: k, reason: collision with root package name */
    public int f14340k;

    /* renamed from: l, reason: collision with root package name */
    public int f14341l;

    /* renamed from: m, reason: collision with root package name */
    public o3.e f14342m;

    /* renamed from: n, reason: collision with root package name */
    public o3.e f14343n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14344o;

    /* renamed from: p, reason: collision with root package name */
    public p.u f14345p;

    /* renamed from: q, reason: collision with root package name */
    public p.u f14346q;

    /* renamed from: r, reason: collision with root package name */
    public p.q0 f14347r;

    /* renamed from: s, reason: collision with root package name */
    public p.q0 f14348s;

    /* renamed from: t, reason: collision with root package name */
    public int f14349t;

    /* renamed from: u, reason: collision with root package name */
    public Integer f14350u;

    /* renamed from: v, reason: collision with root package name */
    public p.f f14351v;

    /* renamed from: w, reason: collision with root package name */
    public mc.e f14352w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14353x;

    /* renamed from: y, reason: collision with root package name */
    public x f14354y;

    /* renamed from: z, reason: collision with root package name */
    public p.u f14355z;

    static {
        int[] iArr = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        int i = p.i.f9577a;
        p.t tVar = new p.t(32);
        int i3 = tVar.f9630b;
        if (i3 < 0) {
            g5.f.q("");
            return;
        }
        int i10 = i3 + 32;
        tVar.b(i10);
        int[] iArr2 = tVar.f9629a;
        int i11 = tVar.f9630b;
        if (i3 != i11) {
            kb.k.f0(i10, i3, iArr2, iArr2, i11);
        }
        kb.k.j0(i3, 0, iArr, iArr2, 12);
        tVar.f9630b += 32;
        N = tVar;
    }

    public static Rect C(d1.c0 c0Var) {
        if (!(c0Var instanceof d1.a0) && !(c0Var instanceof d1.b0)) {
            return null;
        }
        c1.c cVarA = c0Var.a();
        return new Rect((int) cVarA.f2167a, (int) cVarA.f2168b, (int) cVarA.f2169c, (int) cVarA.f2170d);
    }

    public static float[] D(d1.c0 c0Var) {
        if (!(c0Var instanceof d1.b0)) {
            return null;
        }
        c1.d dVar = ((d1.b0) c0Var).f2959a;
        long j10 = dVar.f2178h;
        long j11 = dVar.f2177g;
        long j12 = dVar.f2176f;
        long j13 = dVar.f2175e;
        return new float[]{Float.intBitsToFloat((int) (j13 >> 32)), Float.intBitsToFloat((int) (j13 & 4294967295L)), Float.intBitsToFloat((int) (j12 >> 32)), Float.intBitsToFloat((int) (j12 & 4294967295L)), Float.intBitsToFloat((int) (j11 >> 32)), Float.intBitsToFloat((int) (j11 & 4294967295L)), Float.intBitsToFloat((int) (j10 >> 32)), Float.intBitsToFloat((int) (j10 & 4294967295L))};
    }

    public static Region E(d1.c0 c0Var) {
        if (!(c0Var instanceof d1.z)) {
            return null;
        }
        d1.z zVar = (d1.z) c0Var;
        c1.c cVarA = zVar.a();
        Region region = new Region(new Rect((int) cVarA.f2167a, (int) cVarA.f2168b, (int) cVarA.f2169c, (int) cVarA.f2170d));
        Region region2 = new Region();
        d1.h hVar = zVar.f3035a;
        if (hVar instanceof d1.h) {
            region2.setPath(hVar.f2990a, region);
            return region2;
        }
        g5.f.o("Unable to obtain android.graphics.Path");
        return null;
    }

    public static CharSequence F(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            int i = 100000;
            if (charSequence.length() > 100000) {
                if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
                    i = 99999;
                }
                CharSequence charSequenceSubSequence = charSequence.subSequence(0, i);
                charSequenceSubSequence.getClass();
                return charSequenceSubSequence;
            }
        }
        return charSequence;
    }

    public static String l(a2.p pVar) {
        d2.g gVar;
        if (pVar != null) {
            a2.k kVar = pVar.f88d;
            p.f0 f0Var = kVar.f75c;
            a2.x xVar = a2.u.f117a;
            if (f0Var.c(xVar)) {
                return q2.a.a((List) kVar.b(xVar), ",", null, 62);
            }
            a2.x xVar2 = a2.u.D;
            if (f0Var.c(xVar2)) {
                Object objG = f0Var.g(xVar2);
                if (objG == null) {
                    objG = null;
                }
                d2.g gVar2 = (d2.g) objG;
                if (gVar2 != null) {
                    return gVar2.f3101f;
                }
            } else {
                Object objG2 = f0Var.g(a2.u.f141z);
                if (objG2 == null) {
                    objG2 = null;
                }
                List list = (List) objG2;
                if (list != null && (gVar = (d2.g) kb.l.x0(list)) != null) {
                    return gVar.f3101f;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r3v2, types: [xb.a, yb.l] */
    public static final boolean o(a2.h hVar, float f5) {
        ?? r02 = hVar.f46a;
        if (f5 >= 0.0f || ((Number) r02.invoke()).floatValue() <= 0.0f) {
            return f5 > 0.0f && ((Number) r02.invoke()).floatValue() < ((Number) hVar.f47b.invoke()).floatValue();
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r3v1, types: [xb.a, yb.l] */
    public static final boolean p(a2.h hVar) {
        ?? r02 = hVar.f46a;
        if (((Number) r02.invoke()).floatValue() > 0.0f) {
            return true;
        }
        ((Number) r02.invoke()).floatValue();
        ((Number) hVar.f47b.invoke()).floatValue();
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r2v1, types: [xb.a, yb.l] */
    public static final boolean q(a2.h hVar) {
        ?? r02 = hVar.f46a;
        if (((Number) r02.invoke()).floatValue() < ((Number) hVar.f47b.invoke()).floatValue()) {
            return true;
        }
        ((Number) r02.invoke()).floatValue();
        return false;
    }

    public static /* synthetic */ void v(a0 a0Var, int i, int i3, Integer num, int i10) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        a0Var.u(i, i3, num, null);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r0v18, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r0v8, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r2v1, types: [xb.a, yb.l] */
    public final void A(u1.g0 g0Var) {
        if (g0Var.G() && !this.f14331a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(g0Var)) {
            int i = g0Var.f13790f;
            a2.h hVar = (a2.h) this.f14345p.b(i);
            a2.h hVar2 = (a2.h) this.f14346q.b(i);
            if (hVar == null && hVar2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventF = f(i, 4096);
            if (hVar != null) {
                accessibilityEventF.setScrollX((int) ((Number) hVar.f46a.invoke()).floatValue());
                accessibilityEventF.setMaxScrollX((int) ((Number) hVar.f47b.invoke()).floatValue());
            }
            if (hVar2 != null) {
                accessibilityEventF.setScrollY((int) ((Number) hVar2.f46a.invoke()).floatValue());
                accessibilityEventF.setMaxScrollY((int) ((Number) hVar2.f47b.invoke()).floatValue());
            }
            t(accessibilityEventF);
        }
    }

    public final boolean B(a2.p pVar, int i, int i3, boolean z10) {
        String strL;
        a2.k kVar = pVar.f88d;
        int i10 = pVar.f91g;
        a2.x xVar = a2.j.i;
        if (kVar.f75c.c(xVar) && g0.g(pVar)) {
            xb.q qVar = (xb.q) ((a2.a) pVar.f88d.b(xVar)).f30b;
            if (qVar != null) {
                return ((Boolean) qVar.invoke(Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z10))).booleanValue();
            }
        } else if ((i != i3 || i3 != this.f14349t) && (strL = l(pVar)) != null) {
            if (i < 0 || i != i3 || i3 > strL.length()) {
                i = -1;
            }
            this.f14349t = i;
            boolean z11 = strL.length() > 0;
            t(h(r(i10), z11 ? Integer.valueOf(this.f14349t) : null, z11 ? Integer.valueOf(this.f14349t) : null, z11 ? Integer.valueOf(strL.length()) : null, strL));
            x(i10);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x013f, code lost:
    
        r28 = r2;
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
    public final void G() {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a0.G():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int i, o3.e eVar, String str, Bundle bundle) {
        a2.p pVar;
        Region regionE;
        float[] fArrD;
        Rect rectC;
        AccessibilityNodeInfo accessibilityNodeInfo;
        int i3;
        RectF rectF;
        AccessibilityNodeInfo accessibilityNodeInfo2 = eVar.f9149a;
        a2.q qVar = (a2.q) k().b(i);
        if (qVar == null || (pVar = qVar.f92a) == null) {
            return;
        }
        a2.k kVar = pVar.f88d;
        p.f0 f0Var = kVar.f75c;
        String strL = l(pVar);
        if (yb.k.a(str, this.D)) {
            int iD = this.B.d(i);
            if (iD != -1) {
                accessibilityNodeInfo2.getExtras().putInt(str, iD);
                return;
            }
            return;
        }
        if (yb.k.a(str, this.E)) {
            int iD2 = this.C.d(i);
            if (iD2 != -1) {
                accessibilityNodeInfo2.getExtras().putInt(str, iD2);
                return;
            }
            return;
        }
        u1.g1 g1Var = null;
        if (f0Var.c(a2.j.f50a) && bundle != null && yb.k.a(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int i10 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int i11 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (i11 > 0 && i10 >= 0) {
                if (i10 < (strL != null ? strL.length() : Reader.READ_DONE)) {
                    d2.i0 i0VarR = g0.r(kVar);
                    if (i0VarR == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i12 = 0;
                    while (i12 < i11) {
                        int i13 = i10 + i12;
                        if (i13 >= i0VarR.f3122a.f3106a.f3101f.length()) {
                            arrayList.add(g1Var);
                            accessibilityNodeInfo = accessibilityNodeInfo2;
                            i3 = i11;
                        } else {
                            c1.c cVarA = i0VarR.a(i13);
                            t tVar = this.f14331a;
                            u1.g1 g1VarD = pVar.d();
                            long jD = 0;
                            if (g1VarD != null) {
                                if (!g1VarD.H0().f15126r) {
                                    g1VarD = g1Var;
                                }
                                if (g1VarD != null) {
                                    jD = g1VarD.D(0L);
                                }
                            }
                            c1.c cVarE = cVarA.e(jD);
                            c1.c cVarG = pVar.g();
                            if ((((((cVarE.f2167a > cVarG.f2169c ? 1 : (cVarE.f2167a == cVarG.f2169c ? 0 : -1)) < 0) & ((cVarG.f2167a > cVarE.f2169c ? 1 : (cVarG.f2167a == cVarE.f2169c ? 0 : -1)) < 0)) & ((cVarE.f2168b > cVarG.f2170d ? 1 : (cVarE.f2168b == cVarG.f2170d ? 0 : -1)) < 0)) & ((cVarG.f2168b > cVarE.f2170d ? 1 : (cVarG.f2168b == cVarE.f2170d ? 0 : -1)) < 0) ? cVarE.c(cVarG) : g1Var) != 0) {
                                long jS = tVar.s((Float.floatToRawIntBits(r10.f2168b) & 4294967295L) | (Float.floatToRawIntBits(r10.f2167a) << 32));
                                long jS2 = tVar.s((Float.floatToRawIntBits(r10.f2170d) & 4294967295L) | (Float.floatToRawIntBits(r10.f2169c) << 32));
                                int i14 = (int) (jS >> 32);
                                accessibilityNodeInfo = accessibilityNodeInfo2;
                                i3 = i11;
                                int i15 = (int) (jS2 >> 32);
                                int i16 = (int) (jS & 4294967295L);
                                int i17 = (int) (jS2 & 4294967295L);
                                rectF = new RectF(Math.min(Float.intBitsToFloat(i14), Float.intBitsToFloat(i15)), Math.min(Float.intBitsToFloat(i16), Float.intBitsToFloat(i17)), Math.max(Float.intBitsToFloat(i14), Float.intBitsToFloat(i15)), Math.max(Float.intBitsToFloat(i16), Float.intBitsToFloat(i17)));
                            } else {
                                accessibilityNodeInfo = accessibilityNodeInfo2;
                                i3 = i11;
                                rectF = null;
                            }
                            arrayList.add(rectF);
                        }
                        i12++;
                        i11 = i3;
                        accessibilityNodeInfo2 = accessibilityNodeInfo;
                        g1Var = null;
                    }
                    accessibilityNodeInfo2.getExtras().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
            return;
        }
        a2.x xVar = a2.u.f139x;
        if (f0Var.c(xVar) && bundle != null && yb.k.a(str, "androidx.compose.ui.semantics.testTag")) {
            Object objG = f0Var.g(xVar);
            String str2 = (String) (objG == null ? null : objG);
            if (str2 != null) {
                accessibilityNodeInfo2.getExtras().putCharSequence(str, str2);
                return;
            }
            return;
        }
        if (yb.k.a(str, "androidx.compose.ui.semantics.id")) {
            accessibilityNodeInfo2.getExtras().putInt(str, pVar.f91g);
            return;
        }
        if (yb.k.a(str, "androidx.compose.ui.semantics.shapeType")) {
            Object objG2 = f0Var.g(a2.u.M);
            d1.j0 j0Var = (d1.j0) (objG2 == null ? null : objG2);
            if (j0Var != null) {
                d1.c0 c0VarG = g(j0Var, pVar);
                if (c0VarG instanceof d1.a0) {
                    accessibilityNodeInfo2.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 0);
                    accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", C(c0VarG));
                    return;
                } else if (c0VarG instanceof d1.b0) {
                    accessibilityNodeInfo2.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 1);
                    accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", C(c0VarG));
                    accessibilityNodeInfo2.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", D(c0VarG));
                    return;
                } else if (!(c0VarG instanceof d1.z)) {
                    g5.f.a();
                    return;
                } else {
                    accessibilityNodeInfo2.getExtras().putInt("androidx.compose.ui.semantics.shapeType", 2);
                    accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", E(c0VarG));
                    return;
                }
            }
            return;
        }
        if (yb.k.a(str, "androidx.compose.ui.semantics.shapeRect")) {
            Object objG3 = f0Var.g(a2.u.M);
            d1.j0 j0Var2 = (d1.j0) (objG3 == null ? null : objG3);
            if (j0Var2 == null || (rectC = C(g(j0Var2, pVar))) == null) {
                return;
            }
            accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRect", rectC);
            return;
        }
        if (yb.k.a(str, "androidx.compose.ui.semantics.shapeCorners")) {
            Object objG4 = f0Var.g(a2.u.M);
            d1.j0 j0Var3 = (d1.j0) (objG4 == null ? null : objG4);
            if (j0Var3 == null || (fArrD = D(g(j0Var3, pVar))) == null) {
                return;
            }
            accessibilityNodeInfo2.getExtras().putFloatArray("androidx.compose.ui.semantics.shapeCorners", fArrD);
            return;
        }
        if (yb.k.a(str, "androidx.compose.ui.semantics.shapeRegion")) {
            Object objG5 = f0Var.g(a2.u.M);
            d1.j0 j0Var4 = (d1.j0) (objG5 == null ? null : objG5);
            if (j0Var4 == null || (regionE = E(g(j0Var4, pVar))) == null) {
                return;
            }
            accessibilityNodeInfo2.getExtras().putParcelable("androidx.compose.ui.semantics.shapeRegion", regionE);
        }
    }

    public final Rect b(a2.q qVar) {
        o2.j jVar = qVar.f93b;
        t tVar = this.f14331a;
        float f5 = jVar.f9118a;
        float f10 = jVar.f9119b;
        long jS = tVar.s((Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
        float f11 = jVar.f9120c;
        float f12 = jVar.f9121d;
        long jS2 = tVar.s((Float.floatToRawIntBits(f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L));
        int i = (int) (jS >> 32);
        int i3 = (int) (jS2 >> 32);
        int i10 = (int) (jS & 4294967295L);
        int i11 = (int) (jS2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i3))), (int) Math.floor(Math.min(Float.intBitsToFloat(i10), Float.intBitsToFloat(i11))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i3))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i10), Float.intBitsToFloat(i11))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e9, code lost:
    
        if (kc.w.g(r6, r3) == r4) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:13:0x0030, B:24:0x0057, B:28:0x0068, B:30:0x0070, B:32:0x0079, B:34:0x007f, B:35:0x008e, B:37:0x0096, B:38:0x00b2, B:40:0x00c1, B:43:0x00cf, B:20:0x0045, B:23:0x004c), top: B:51:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00e9 -> B:46:0x00ec). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(pb.c r17) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a0.c(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Type inference failed for: r1v22, types: [xb.a, yb.l] */
    /* JADX WARN: Type inference failed for: r2v7, types: [xb.a, yb.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(int r22, boolean r23, long r24) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a0.d(int, boolean, long):boolean");
    }

    public final void e() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (m()) {
                s(this.f14331a.getSemanticsOwner().a(), this.H);
            }
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                y(k());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    G();
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public final AccessibilityEvent f(int i, int i3) {
        a2.q qVar;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        t tVar = this.f14331a;
        accessibilityEventObtain.setPackageName(tVar.getContext().getPackageName());
        accessibilityEventObtain.setSource(tVar, i);
        if (m() && (qVar = (a2.q) k().b(i)) != null) {
            a2.p pVar = qVar.f92a;
            accessibilityEventObtain.setPassword(pVar.f88d.f75c.c(a2.u.H));
            Object objG = pVar.f88d.f75c.g(a2.u.f129n);
            if (objG == null) {
                objG = null;
            }
            boolean zA = yb.k.a(objG, Boolean.TRUE);
            if (Build.VERSION.SDK_INT >= 34) {
                n3.y.i(accessibilityEventObtain, zA);
            }
        }
        return accessibilityEventObtain;
    }

    public final d1.c0 g(d1.j0 j0Var, a2.p pVar) {
        u1.g1 g1VarD = pVar.d();
        return j0Var.a(ac.a.i0(g1VarD != null ? g1VarD.f11279g : 0L), pVar.f87c.B, this.f14331a.getDensity());
    }

    @Override // n3.b
    public final o3.g getAccessibilityNodeProvider(View view) {
        return this.f14339j;
    }

    public final AccessibilityEvent h(int i, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventF = f(i, 8192);
        if (num != null) {
            accessibilityEventF.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventF.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventF.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventF.getText().add(charSequence);
        }
        return accessibilityEventF;
    }

    public final int i(a2.p pVar) {
        a2.k kVar = pVar.f88d;
        if (!kVar.f75c.c(a2.u.f117a)) {
            a2.x xVar = a2.u.E;
            if (kVar.f75c.c(xVar)) {
                return (int) (((d2.k0) kVar.b(xVar)).f3136a & 4294967295L);
            }
        }
        return this.f14349t;
    }

    public final int j(a2.p pVar) {
        a2.k kVar = pVar.f88d;
        if (!kVar.f75c.c(a2.u.f117a)) {
            a2.x xVar = a2.u.E;
            if (kVar.f75c.c(xVar)) {
                return (int) (((d2.k0) kVar.b(xVar)).f3136a >> 32);
            }
        }
        return this.f14349t;
    }

    public final p.j k() {
        t tVar = this.f14331a;
        if (this.f14353x) {
            this.f14353x = false;
            this.f14355z = a2.s.b(tVar.getSemanticsOwner());
            if (m()) {
                p.u uVar = this.f14355z;
                p.s sVar = this.B;
                p.s sVar2 = this.C;
                Resources resources = tVar.getContext().getResources();
                sVar.a();
                sVar2.a();
                a2.q qVar = (a2.q) uVar.b(-1);
                a2.p pVar = qVar != null ? qVar.f92a : null;
                pVar.getClass();
                ArrayList arrayListB = a2.b0.b(pVar, new a2.m(uVar, 22), new a2.m(resources, 23), ac.a.E(pVar));
                int i = 1;
                int size = arrayListB.size() - 1;
                if (1 <= size) {
                    while (true) {
                        int i3 = ((a2.p) arrayListB.get(i - 1)).f91g;
                        int i10 = ((a2.p) arrayListB.get(i)).f91g;
                        sVar.f(i3, i10);
                        sVar2.f(i10, i3);
                        if (i == size) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return this.f14355z;
    }

    public final boolean m() {
        return this.f14334d.isEnabled() && !this.f14338h.isEmpty();
    }

    public final void n(u1.g0 g0Var) {
        if (this.f14351v.add(g0Var)) {
            this.f14352w.h(jb.v.f6774a);
        }
    }

    public final int r(int i) {
        if (i == this.f14331a.getSemanticsOwner().a().f91g) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(a2.p r20, v1.o1 r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            int[] r3 = p.l.f9589a
            p.v r3 = new p.v
            r3.<init>()
            r4 = 4
            java.util.List r5 = a2.p.j(r4, r1)
            u1.g0 r6 = r1.f87c
            int r7 = r5.size()
            r8 = 0
            r9 = r8
        L1a:
            if (r9 >= r7) goto L40
            java.lang.Object r10 = r5.get(r9)
            a2.p r10 = (a2.p) r10
            p.j r11 = r0.k()
            int r10 = r10.f91g
            boolean r11 = r11.a(r10)
            if (r11 == 0) goto L3d
            p.v r11 = r2.f14520b
            boolean r11 = r11.b(r10)
            if (r11 != 0) goto L3a
            r0.n(r6)
            return
        L3a:
            r3.a(r10)
        L3d:
            int r9 = r9 + 1
            goto L1a
        L40:
            p.v r2 = r2.f14520b
            int[] r5 = r2.f9633b
            long[] r2 = r2.f9632a
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
            r0.n(r6)
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
            java.util.List r1 = a2.p.j(r4, r1)
            int r2 = r1.size()
        L93:
            if (r8 >= r2) goto Lb9
            java.lang.Object r3 = r1.get(r8)
            a2.p r3 = (a2.p) r3
            p.u r4 = r0.G
            int r5 = r3.f91g
            java.lang.Object r4 = r4.b(r5)
            v1.o1 r4 = (v1.o1) r4
            if (r4 == 0) goto Lb6
            p.j r5 = r0.k()
            int r6 = r3.f91g
            boolean r5 = r5.a(r6)
            if (r5 == 0) goto Lb6
            r0.s(r3, r4)
        Lb6:
            int r8 = r8 + 1
            goto L93
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a0.s(a2.p, v1.o1):void");
    }

    public final boolean t(AccessibilityEvent accessibilityEvent) {
        if (!m()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.f14344o = true;
        }
        try {
            return ((Boolean) this.f14333c.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.f14344o = false;
        }
    }

    public final boolean u(int i, int i3, Integer num, List list) {
        if (i == Integer.MIN_VALUE || !m()) {
            return false;
        }
        AccessibilityEvent accessibilityEventF = f(i, i3);
        if (num != null) {
            accessibilityEventF.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventF.setContentDescription(q2.a.a(list, ",", null, 62));
        }
        return t(accessibilityEventF);
    }

    public final void w(int i, int i3, String str) {
        AccessibilityEvent accessibilityEventF = f(r(i), 32);
        accessibilityEventF.setContentChangeTypes(i3);
        if (str != null) {
            accessibilityEventF.getText().add(str);
        }
        t(accessibilityEventF);
    }

    public final void x(int i) {
        x xVar = this.f14354y;
        if (xVar != null) {
            a2.p pVar = xVar.f14585a;
            if (i != pVar.f91g) {
                return;
            }
            if (SystemClock.uptimeMillis() - xVar.f14590f <= 1000) {
                AccessibilityEvent accessibilityEventF = f(r(pVar.f91g), 131072);
                accessibilityEventF.setFromIndex(xVar.f14588d);
                accessibilityEventF.setToIndex(xVar.f14589e);
                accessibilityEventF.setAction(xVar.f14586b);
                accessibilityEventF.setMovementGranularity(xVar.f14587c);
                accessibilityEventF.getText().add(l(pVar));
                t(accessibilityEventF);
            }
        }
        this.f14354y = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:221:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(p.j r57) {
        /*
            Method dump skipped, instructions count: 1656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.a0.y(p.j):void");
    }

    public final void z(u1.g0 g0Var, p.v vVar) {
        a2.k kVarV;
        if (g0Var.G() && !this.f14331a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(g0Var)) {
            u1.g0 g0Var2 = null;
            if (!g0Var.H.d(8)) {
                g0Var = g0Var.t();
                while (true) {
                    if (g0Var == null) {
                        g0Var = null;
                        break;
                    } else if (g0Var.H.d(8)) {
                        break;
                    } else {
                        g0Var = g0Var.t();
                    }
                }
            }
            if (g0Var == null || (kVarV = g0Var.v()) == null) {
                return;
            }
            if (!kVarV.f77g) {
                u1.g0 g0VarT = g0Var.t();
                while (true) {
                    if (g0VarT != null) {
                        a2.k kVarV2 = g0VarT.v();
                        if (kVarV2 != null && kVarV2.f77g) {
                            g0Var2 = g0VarT;
                            break;
                        }
                        g0VarT = g0VarT.t();
                    } else {
                        break;
                    }
                }
                if (g0Var2 != null) {
                    g0Var = g0Var2;
                }
            }
            int i = g0Var.f13790f;
            if (vVar.a(i)) {
                v(this, r(i), RecyclerView.ItemAnimator.FLAG_MOVED, 1, 8);
            }
        }
    }
}
