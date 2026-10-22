package v;

import com.stepos.alphame.utils.Property;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import t0.J;
import w.C0956b;
import w.C0957c;
import w.C0959e;
import w.C0968n;
import w.p;

/* renamed from: v.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0945e extends l {

    /* renamed from: A0, reason: collision with root package name */
    public int f15591A0;

    /* renamed from: B0, reason: collision with root package name */
    public C0942b[] f15592B0;

    /* renamed from: C0, reason: collision with root package name */
    public C0942b[] f15593C0;

    /* renamed from: D0, reason: collision with root package name */
    public int f15594D0;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f15595E0;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f15596F0;

    /* renamed from: G0, reason: collision with root package name */
    public WeakReference f15597G0;

    /* renamed from: H0, reason: collision with root package name */
    public WeakReference f15598H0;

    /* renamed from: I0, reason: collision with root package name */
    public WeakReference f15599I0;

    /* renamed from: J0, reason: collision with root package name */
    public WeakReference f15600J0;

    /* renamed from: K0, reason: collision with root package name */
    public final HashSet f15601K0;

    /* renamed from: L0, reason: collision with root package name */
    public final C0956b f15602L0;

    /* renamed from: r0, reason: collision with root package name */
    public final android.support.v4.media.session.c f15603r0;

    /* renamed from: s0, reason: collision with root package name */
    public final C0959e f15604s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f15605t0;

    /* renamed from: u0, reason: collision with root package name */
    public C0968n f15606u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f15607v0;

    /* renamed from: w0, reason: collision with root package name */
    public final t.e f15608w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f15609x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f15610y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f15611z0;

    public C0945e() {
        this.f15674q0 = new ArrayList();
        this.f15603r0 = new android.support.v4.media.session.c(this);
        C0959e c0959e = new C0959e();
        c0959e.f15745b = true;
        c0959e.f15746c = true;
        c0959e.f15748e = new ArrayList();
        new ArrayList();
        c0959e.f15749f = null;
        c0959e.f15750g = new C0956b();
        c0959e.f15751h = new ArrayList();
        c0959e.f15744a = this;
        c0959e.f15747d = this;
        this.f15604s0 = c0959e;
        this.f15606u0 = null;
        this.f15607v0 = false;
        this.f15608w0 = new t.e();
        this.f15611z0 = 0;
        this.f15591A0 = 0;
        this.f15592B0 = new C0942b[4];
        this.f15593C0 = new C0942b[4];
        this.f15594D0 = 257;
        this.f15595E0 = false;
        this.f15596F0 = false;
        this.f15597G0 = null;
        this.f15598H0 = null;
        this.f15599I0 = null;
        this.f15600J0 = null;
        this.f15601K0 = new HashSet();
        this.f15602L0 = new C0956b();
    }

    public static void W(C0944d c0944d, C0968n c0968n, C0956b c0956b) {
        int i4;
        int i5;
        if (c0968n == null) {
            return;
        }
        if (c0944d.f15562g0 == 8 || (c0944d instanceof C0948h) || (c0944d instanceof C0941a)) {
            c0956b.f15736e = 0;
            c0956b.f15737f = 0;
            return;
        }
        int[] iArr = c0944d.f15580p0;
        c0956b.f15732a = iArr[0];
        c0956b.f15733b = iArr[1];
        c0956b.f15734c = c0944d.r();
        c0956b.f15735d = c0944d.l();
        c0956b.f15740i = false;
        c0956b.f15741j = 0;
        boolean z4 = c0956b.f15732a == 3;
        boolean z5 = c0956b.f15733b == 3;
        boolean z6 = z4 && c0944d.f15545W > Property.DEFAULT_FLOAT_VALUE;
        boolean z7 = z5 && c0944d.f15545W > Property.DEFAULT_FLOAT_VALUE;
        if (z4 && c0944d.u(0) && c0944d.f15582r == 0 && !z6) {
            c0956b.f15732a = 2;
            if (z5 && c0944d.f15583s == 0) {
                c0956b.f15732a = 1;
            }
            z4 = false;
        }
        if (z5 && c0944d.u(1) && c0944d.f15583s == 0 && !z7) {
            c0956b.f15733b = 2;
            if (z4 && c0944d.f15582r == 0) {
                c0956b.f15733b = 1;
            }
            z5 = false;
        }
        if (c0944d.B()) {
            c0956b.f15732a = 1;
            z4 = false;
        }
        if (c0944d.C()) {
            c0956b.f15733b = 1;
            z5 = false;
        }
        int[] iArr2 = c0944d.f15584t;
        if (z6) {
            if (iArr2[0] == 4) {
                c0956b.f15732a = 1;
            } else if (!z5) {
                if (c0956b.f15733b == 1) {
                    i5 = c0956b.f15735d;
                } else {
                    c0956b.f15732a = 2;
                    c0968n.b(c0944d, c0956b);
                    i5 = c0956b.f15737f;
                }
                c0956b.f15732a = 1;
                c0956b.f15734c = (int) (c0944d.f15545W * i5);
            }
        }
        if (z7) {
            if (iArr2[1] == 4) {
                c0956b.f15733b = 1;
            } else if (!z4) {
                if (c0956b.f15732a == 1) {
                    i4 = c0956b.f15734c;
                } else {
                    c0956b.f15733b = 2;
                    c0968n.b(c0944d, c0956b);
                    i4 = c0956b.f15736e;
                }
                c0956b.f15733b = 1;
                if (c0944d.f15546X == -1) {
                    c0956b.f15735d = (int) (i4 / c0944d.f15545W);
                } else {
                    c0956b.f15735d = (int) (c0944d.f15545W * i4);
                }
            }
        }
        c0968n.b(c0944d, c0956b);
        c0944d.P(c0956b.f15736e);
        c0944d.M(c0956b.f15737f);
        c0944d.f15528E = c0956b.f15739h;
        c0944d.J(c0956b.f15738g);
        c0956b.f15741j = 0;
    }

    @Override // v.l, v.C0944d
    public final void D() {
        this.f15608w0.t();
        this.f15609x0 = 0;
        this.f15610y0 = 0;
        super.D();
    }

    @Override // v.C0944d
    public final void Q(boolean z4, boolean z5) {
        super.Q(z4, z5);
        int size = this.f15674q0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((C0944d) this.f15674q0.get(i4)).Q(z4, z5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0678 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x07a3 A[PHI: r21 r22 r24
      0x07a3: PHI (r21v4 boolean) = (r21v10 boolean), (r21v19 boolean) binds: [B:477:0x07c0, B:472:0x07a0] A[DONT_GENERATE, DONT_INLINE]
      0x07a3: PHI (r22v3 v.c) = (r22v5 v.c), (r22v10 v.c) binds: [B:477:0x07c0, B:472:0x07a0] A[DONT_GENERATE, DONT_INLINE]
      0x07a3: PHI (r24v3 v.c) = (r24v5 v.c), (r24v12 v.c) binds: [B:477:0x07c0, B:472:0x07a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0816 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:509:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0899  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x08eb  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0127  */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v17 */
    @Override // v.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S() {
        /*
            Method dump skipped, instructions count: 2316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.C0945e.S():void");
    }

    public final void T(int i4, C0944d c0944d) {
        if (i4 == 0) {
            int i5 = this.f15611z0 + 1;
            C0942b[] c0942bArr = this.f15593C0;
            if (i5 >= c0942bArr.length) {
                this.f15593C0 = (C0942b[]) Arrays.copyOf(c0942bArr, c0942bArr.length * 2);
            }
            C0942b[] c0942bArr2 = this.f15593C0;
            int i6 = this.f15611z0;
            c0942bArr2[i6] = new C0942b(c0944d, 0, this.f15607v0);
            this.f15611z0 = i6 + 1;
            return;
        }
        if (i4 == 1) {
            int i7 = this.f15591A0 + 1;
            C0942b[] c0942bArr3 = this.f15592B0;
            if (i7 >= c0942bArr3.length) {
                this.f15592B0 = (C0942b[]) Arrays.copyOf(c0942bArr3, c0942bArr3.length * 2);
            }
            C0942b[] c0942bArr4 = this.f15592B0;
            int i8 = this.f15591A0;
            c0942bArr4[i8] = new C0942b(c0944d, 1, this.f15607v0);
            this.f15591A0 = i8 + 1;
        }
    }

    public final void U(t.e eVar) {
        boolean zX = X(64);
        c(eVar, zX);
        int size = this.f15674q0.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            C0944d c0944d = (C0944d) this.f15674q0.get(i4);
            boolean[] zArr = c0944d.f15542S;
            zArr[0] = false;
            zArr[1] = false;
            if (c0944d instanceof C0941a) {
                z4 = true;
            }
        }
        if (z4) {
            for (int i5 = 0; i5 < size; i5++) {
                C0944d c0944d2 = (C0944d) this.f15674q0.get(i5);
                if (c0944d2 instanceof C0941a) {
                    C0941a c0941a = (C0941a) c0944d2;
                    for (int i6 = 0; i6 < c0941a.f15672r0; i6++) {
                        C0944d c0944d3 = c0941a.f15671q0[i6];
                        if (c0941a.f15495t0 || c0944d3.d()) {
                            int i7 = c0941a.f15494s0;
                            if (i7 == 0 || i7 == 1) {
                                c0944d3.f15542S[0] = true;
                            } else if (i7 == 2 || i7 == 3) {
                                c0944d3.f15542S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.f15601K0;
        hashSet.clear();
        for (int i8 = 0; i8 < size; i8++) {
            C0944d c0944d4 = (C0944d) this.f15674q0.get(i8);
            c0944d4.getClass();
            boolean z5 = c0944d4 instanceof C0947g;
            if (z5 || (c0944d4 instanceof C0948h)) {
                if (z5) {
                    hashSet.add(c0944d4);
                } else {
                    c0944d4.c(eVar, zX);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0947g c0947g = (C0947g) ((C0944d) it.next());
                for (int i9 = 0; i9 < c0947g.f15672r0; i9++) {
                    if (hashSet.contains(c0947g.f15671q0[i9])) {
                        c0947g.c(eVar, zX);
                        hashSet.remove(c0947g);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((C0944d) it2.next()).c(eVar, zX);
                }
                hashSet.clear();
            }
        }
        if (t.e.f15277p) {
            HashSet hashSet2 = new HashSet();
            for (int i10 = 0; i10 < size; i10++) {
                C0944d c0944d5 = (C0944d) this.f15674q0.get(i10);
                c0944d5.getClass();
                if (!(c0944d5 instanceof C0947g) && !(c0944d5 instanceof C0948h)) {
                    hashSet2.add(c0944d5);
                }
            }
            b(this, eVar, hashSet2, this.f15580p0[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                C0944d c0944d6 = (C0944d) it3.next();
                AbstractC0951k.a(this, eVar, c0944d6);
                c0944d6.c(eVar, zX);
            }
        } else {
            for (int i11 = 0; i11 < size; i11++) {
                C0944d c0944d7 = (C0944d) this.f15674q0.get(i11);
                if (c0944d7 instanceof C0945e) {
                    int[] iArr = c0944d7.f15580p0;
                    int i12 = iArr[0];
                    int i13 = iArr[1];
                    if (i12 == 2) {
                        c0944d7.N(1);
                    }
                    if (i13 == 2) {
                        c0944d7.O(1);
                    }
                    c0944d7.c(eVar, zX);
                    if (i12 == 2) {
                        c0944d7.N(i12);
                    }
                    if (i13 == 2) {
                        c0944d7.O(i13);
                    }
                } else {
                    AbstractC0951k.a(this, eVar, c0944d7);
                    if (!(c0944d7 instanceof C0947g) && !(c0944d7 instanceof C0948h)) {
                        c0944d7.c(eVar, zX);
                    }
                }
            }
        }
        if (this.f15611z0 > 0) {
            J.c(this, eVar, null, 0);
        }
        if (this.f15591A0 > 0) {
            J.c(this, eVar, null, 1);
        }
    }

    public final boolean V(int i4, boolean z4) {
        boolean z5;
        boolean z6 = true;
        boolean z7 = z4 & true;
        C0959e c0959e = this.f15604s0;
        C0945e c0945e = c0959e.f15744a;
        int iK = c0945e.k(0);
        int iK2 = c0945e.k(1);
        int iS = c0945e.s();
        int iT = c0945e.t();
        ArrayList arrayList = c0959e.f15748e;
        if (z7 && (iK == 2 || iK2 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = (p) it.next();
                if (pVar.f15790f == i4 && !pVar.k()) {
                    z7 = false;
                    break;
                }
            }
            if (i4 == 0) {
                if (z7 && iK == 2) {
                    c0945e.N(1);
                    c0945e.P(c0959e.d(c0945e, 0));
                    c0945e.f15555d.f15789e.d(c0945e.r());
                }
            } else if (z7 && iK2 == 2) {
                c0945e.O(1);
                c0945e.M(c0959e.d(c0945e, 1));
                c0945e.f15557e.f15789e.d(c0945e.l());
            }
        }
        int[] iArr = c0945e.f15580p0;
        if (i4 == 0) {
            int i5 = iArr[0];
            if (i5 == 1 || i5 == 4) {
                int iR = c0945e.r() + iS;
                c0945e.f15555d.f15793i.d(iR);
                c0945e.f15555d.f15789e.d(iR - iS);
                z5 = true;
            }
            z5 = false;
        } else {
            int i6 = iArr[1];
            if (i6 == 1 || i6 == 4) {
                int iL = c0945e.l() + iT;
                c0945e.f15557e.f15793i.d(iL);
                c0945e.f15557e.f15789e.d(iL - iT);
                z5 = true;
            }
            z5 = false;
        }
        c0959e.g();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            p pVar2 = (p) it2.next();
            if (pVar2.f15790f == i4 && (pVar2.f15786b != c0945e || pVar2.f15791g)) {
                pVar2.e();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p pVar3 = (p) it3.next();
            if (pVar3.f15790f == i4 && (z5 || pVar3.f15786b != c0945e)) {
                if (!pVar3.f15792h.f15761j || !pVar3.f15793i.f15761j || (!(pVar3 instanceof C0957c) && !pVar3.f15789e.f15761j)) {
                    z6 = false;
                    break;
                }
            }
        }
        c0945e.N(iK);
        c0945e.O(iK2);
        return z6;
    }

    public final boolean X(int i4) {
        return (this.f15594D0 & i4) == i4;
    }

    @Override // v.C0944d
    public final void o(StringBuilder sb) {
        sb.append(this.f15567j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.f15543U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.f15544V);
        sb.append("\n");
        Iterator it = this.f15674q0.iterator();
        while (it.hasNext()) {
            ((C0944d) it.next()).o(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
