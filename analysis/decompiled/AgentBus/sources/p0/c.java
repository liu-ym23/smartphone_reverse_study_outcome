package p0;

import a4.u;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.lifecycle.a0;
import androidx.lifecycle.f;
import androidx.lifecycle.v;
import d7.r;
import j1.s;
import j1.t1;
import j1.y;
import java.util.ArrayList;
import java.util.List;
import k.j;
import k.k;
import k.t;
import ka.g;
import m.x;
import p1.n;
import p1.o;
import p1.q;

/* loaded from: classes.dex */
public final class c implements f, View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final y f8244f;

    /* renamed from: g, reason: collision with root package name */
    public final s f8245g;

    /* renamed from: h, reason: collision with root package name */
    public q6.b f8246h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f8247i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final long f8248j = 100;

    /* renamed from: k, reason: collision with root package name */
    public a f8249k = a.f8237f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8250l = true;

    /* renamed from: m, reason: collision with root package name */
    public final g f8251m = a.a.b(1, 6, null);

    /* renamed from: n, reason: collision with root package name */
    public final Handler f8252n = new Handler(Looper.getMainLooper());

    /* renamed from: o, reason: collision with root package name */
    public t f8253o;

    /* renamed from: p, reason: collision with root package name */
    public long f8254p;

    /* renamed from: q, reason: collision with root package name */
    public final t f8255q;

    /* renamed from: r, reason: collision with root package name */
    public t1 f8256r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8257s;

    /* renamed from: t, reason: collision with root package name */
    public final a0 f8258t;

    public c(y yVar, s sVar) {
        this.f8244f = yVar;
        this.f8245g = sVar;
        t tVar = k.f5504a;
        q7.k.c(tVar, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        this.f8253o = tVar;
        this.f8255q = new t();
        n nVarA = yVar.getSemanticsOwner().a();
        q7.k.c(tVar, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        this.f8256r = new t1(nVarA, tVar);
        this.f8258t = new a0(6, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007d -> B:17:0x0047). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(i7.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof p0.b
            if (r0 == 0) goto L13
            r0 = r8
            p0.b r0 = (p0.b) r0
            int r1 = r0.f8243i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8243i = r1
            goto L18
        L13:
            p0.b r0 = new p0.b
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f8241g
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f8243i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ka.b r2 = r0.f8240f
            w7.e0.N(r8)
            goto L47
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            ka.b r2 = r0.f8240f
            w7.e0.N(r8)
            goto L52
        L3a:
            w7.e0.N(r8)
            ka.g r8 = r7.f8251m
            r8.getClass()
            ka.b r2 = new ka.b
            r2.<init>(r8)
        L47:
            r0.f8240f = r2
            r0.f8243i = r4
            java.lang.Object r8 = r2.a(r0)
            if (r8 != r1) goto L52
            goto L7f
        L52:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L80
            r2.c()
            boolean r8 = r7.h()
            if (r8 == 0) goto L66
            r7.i()
        L66:
            boolean r8 = r7.f8257s
            if (r8 != 0) goto L73
            r7.f8257s = r4
            android.os.Handler r8 = r7.f8252n
            androidx.lifecycle.a0 r5 = r7.f8258t
            r8.post(r5)
        L73:
            r0.f8240f = r2
            r0.f8243i = r3
            long r5 = r7.f8248j
            java.lang.Object r8 = ia.d0.g(r5, r0)
            if (r8 != r1) goto L47
        L7f:
            return r1
        L80:
            c7.r r7 = c7.r.f1986a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.c.c(i7.c):java.lang.Object");
    }

    @Override // androidx.lifecycle.f
    public final void d(v vVar) {
        this.f8246h = (q6.b) this.f8245g.c();
        k(-1, this.f8244f.getSemanticsOwner().a());
        i();
    }

    @Override // androidx.lifecycle.f
    public final void e(v vVar) {
        l(this.f8244f.getSemanticsOwner().a());
        i();
        this.f8246h = null;
    }

    public final void f(j jVar) {
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j2;
        char c10;
        long j4;
        int i2;
        int i10;
        long[] jArr3;
        t1 t1Var;
        int i11;
        long[] jArr4;
        t1 t1Var2;
        String str;
        long j10;
        String str2;
        int i12;
        j jVar2 = jVar;
        int[] iArr3 = jVar2.f5499b;
        long[] jArr5 = jVar2.f5498a;
        int length = jArr5.length - 2;
        if (length < 0) {
            return;
        }
        int i13 = 0;
        while (true) {
            long j11 = jArr5[i13];
            char c11 = 7;
            long j12 = -9187201950435737472L;
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8;
                int i15 = 8 - ((~(i13 - length)) >>> 31);
                int i16 = 0;
                while (i16 < i15) {
                    if ((j11 & 255) < 128) {
                        int i17 = iArr3[(i13 << 3) + i16];
                        c10 = c11;
                        t1 t1Var3 = (t1) this.f8255q.b(i17);
                        o oVar = (o) jVar2.b(i17);
                        n nVar = oVar != null ? oVar.f8319a : null;
                        if (nVar == null) {
                            throw x.i("no value for specified key");
                        }
                        j4 = j12;
                        int i18 = nVar.f8318g;
                        k.a0 a0Var = nVar.f8315d.f8304f;
                        String str3 = "Invalid content capture ID";
                        if (t1Var3 == null) {
                            Object[] objArr = a0Var.f5447b;
                            long[] jArr6 = a0Var.f5446a;
                            int i19 = i14;
                            int length2 = jArr6.length - 2;
                            iArr2 = iArr3;
                            jArr2 = jArr5;
                            if (length2 >= 0) {
                                int i20 = 0;
                                while (true) {
                                    long j13 = jArr6[i20];
                                    j2 = j11;
                                    if ((((~j13) << c10) & j13 & j4) != j4) {
                                        int i21 = 8 - ((~(i20 - length2)) >>> 31);
                                        int i22 = 0;
                                        while (i22 < i21) {
                                            if ((j13 & 255) < 128) {
                                                j10 = j13;
                                                p1.v vVar = (p1.v) objArr[(i20 << 3) + i22];
                                                p1.v vVar2 = p1.s.f8368y;
                                                if (q7.k.a(vVar, vVar2)) {
                                                    Object objG = a0Var.g(vVar2);
                                                    if (objG == null) {
                                                        objG = null;
                                                    }
                                                    List list = (List) objG;
                                                    String strValueOf = String.valueOf(list != null ? (s1.e) r.P0(list) : null);
                                                    q6.b bVar = this.f8246h;
                                                    if (bVar != null) {
                                                        str2 = str3;
                                                        i12 = i16;
                                                        AutofillId autofillIdH0 = bVar.H0(i18);
                                                        if (autofillIdH0 == null) {
                                                            throw x.i(str2);
                                                        }
                                                        ((ContentCaptureSession) bVar.f8788h).notifyViewTextChanged(autofillIdH0, strValueOf);
                                                    }
                                                }
                                                j13 = j10 >> i19;
                                                i22++;
                                                i16 = i12;
                                                str3 = str2;
                                            } else {
                                                j10 = j13;
                                            }
                                            str2 = str3;
                                            i12 = i16;
                                            j13 = j10 >> i19;
                                            i22++;
                                            i16 = i12;
                                            str3 = str2;
                                        }
                                        str = str3;
                                        i2 = i16;
                                        if (i21 != i19) {
                                            break;
                                        }
                                    } else {
                                        str = str3;
                                        i2 = i16;
                                    }
                                    if (i20 == length2) {
                                        break;
                                    }
                                    i20++;
                                    j11 = j2;
                                    i16 = i2;
                                    str3 = str;
                                    i19 = 8;
                                }
                            } else {
                                j2 = j11;
                                i2 = i16;
                            }
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr5;
                            j2 = j11;
                            i2 = i16;
                            Object[] objArr2 = a0Var.f5447b;
                            long[] jArr7 = a0Var.f5446a;
                            int length3 = jArr7.length - 2;
                            if (length3 >= 0) {
                                int i23 = 0;
                                while (true) {
                                    long j14 = jArr7[i23];
                                    Object[] objArr3 = objArr2;
                                    long[] jArr8 = jArr7;
                                    if ((((~j14) << c10) & j14 & j4) != j4) {
                                        int i24 = 8 - ((~(i23 - length3)) >>> 31);
                                        int i25 = 0;
                                        while (i25 < i24) {
                                            if ((j14 & 255) < 128) {
                                                p1.v vVar3 = (p1.v) objArr3[(i23 << 3) + i25];
                                                i11 = i25;
                                                p1.v vVar4 = p1.s.f8368y;
                                                if (q7.k.a(vVar3, vVar4)) {
                                                    Object objG2 = t1Var3.f5334a.f8304f.g(vVar4);
                                                    if (objG2 == null) {
                                                        objG2 = null;
                                                    }
                                                    List list2 = (List) objG2;
                                                    s1.e eVar = list2 != null ? (s1.e) r.P0(list2) : null;
                                                    Object objG3 = a0Var.g(vVar4);
                                                    if (objG3 == null) {
                                                        objG3 = null;
                                                    }
                                                    List list3 = (List) objG3;
                                                    s1.e eVar2 = list3 != null ? (s1.e) r.P0(list3) : null;
                                                    if (!q7.k.a(eVar, eVar2)) {
                                                        String strValueOf2 = String.valueOf(eVar2);
                                                        q6.b bVar2 = this.f8246h;
                                                        if (bVar2 != null) {
                                                            jArr4 = jArr8;
                                                            t1Var2 = t1Var3;
                                                            AutofillId autofillIdH02 = bVar2.H0(i18);
                                                            if (autofillIdH02 == null) {
                                                                throw x.i("Invalid content capture ID");
                                                            }
                                                            ((ContentCaptureSession) bVar2.f8788h).notifyViewTextChanged(autofillIdH02, strValueOf2);
                                                        }
                                                    }
                                                }
                                                j14 >>= 8;
                                                i25 = i11 + 1;
                                                t1Var3 = t1Var2;
                                                jArr8 = jArr4;
                                            } else {
                                                i11 = i25;
                                            }
                                            jArr4 = jArr8;
                                            t1Var2 = t1Var3;
                                            j14 >>= 8;
                                            i25 = i11 + 1;
                                            t1Var3 = t1Var2;
                                            jArr8 = jArr4;
                                        }
                                        jArr3 = jArr8;
                                        t1Var = t1Var3;
                                        if (i24 != 8) {
                                            break;
                                        }
                                    } else {
                                        jArr3 = jArr8;
                                        t1Var = t1Var3;
                                    }
                                    if (i23 == length3) {
                                        break;
                                    }
                                    i23++;
                                    objArr2 = objArr3;
                                    t1Var3 = t1Var;
                                    jArr7 = jArr3;
                                }
                            }
                        }
                        i10 = 8;
                    } else {
                        iArr2 = iArr3;
                        jArr2 = jArr5;
                        j2 = j11;
                        c10 = c11;
                        j4 = j12;
                        i2 = i16;
                        i10 = i14;
                    }
                    j11 = j2 >> i10;
                    i16 = i2 + 1;
                    jVar2 = jVar;
                    i14 = i10;
                    c11 = c10;
                    j12 = j4;
                    iArr3 = iArr2;
                    jArr5 = jArr2;
                }
                iArr = iArr3;
                jArr = jArr5;
                if (i15 != i14) {
                    return;
                }
            } else {
                iArr = iArr3;
                jArr = jArr5;
            }
            if (i13 == length) {
                return;
            }
            i13++;
            jVar2 = jVar;
            iArr3 = iArr;
            jArr5 = jArr;
        }
    }

    public final j g() {
        if (this.f8250l) {
            this.f8250l = false;
            this.f8253o = q.b(this.f8244f.getSemanticsOwner());
            this.f8254p = System.currentTimeMillis();
        }
        return this.f8253o;
    }

    public final boolean h() {
        return this.f8246h != null;
    }

    public final void i() {
        q6.b bVar = this.f8246h;
        if (bVar == null) {
            return;
        }
        ContentCaptureSession contentCaptureSession = (ContentCaptureSession) bVar.f8788h;
        ArrayList arrayList = this.f8247i;
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = (d) arrayList.get(i2);
            int iOrdinal = dVar.f8261c.ordinal();
            if (iOrdinal == 0) {
                a7.d dVar2 = dVar.f8262d;
                if (dVar2 != null) {
                    contentCaptureSession.notifyViewAppeared((ViewStructure) dVar2.f411g);
                }
            } else {
                if (iOrdinal != 1) {
                    throw new u();
                }
                AutofillId autofillIdH0 = bVar.H0(dVar.f8259a);
                if (autofillIdH0 != null) {
                    contentCaptureSession.notifyViewDisappeared(autofillIdH0);
                }
            }
        }
        contentCaptureSession.notifyViewsDisappeared(((View) bVar.f8787g).getAutofillId(), new long[]{Long.MIN_VALUE});
        arrayList.clear();
    }

    public final void j(n nVar, t1 t1Var) {
        h9.b bVar = new h9.b(5, t1Var, this);
        nVar.getClass();
        List listI = nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0);
        int size = listI.size();
        int i2 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = listI.get(i10);
            if (g().a(((n) obj).f8318g)) {
                bVar.invoke(Integer.valueOf(i2), obj);
                i2++;
            }
        }
        List listI2 = nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0);
        int size2 = listI2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            n nVar2 = (n) listI2.get(i11);
            j jVarG = g();
            int i12 = nVar2.f8318g;
            if (jVarG.a(i12)) {
                t tVar = this.f8255q;
                if (tVar.a(i12)) {
                    Object objB = tVar.b(i12);
                    if (objB == null) {
                        throw x.i("node not present in pruned tree before this change");
                    }
                    j(nVar2, (t1) objB);
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r19, p1.n r20) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.c.k(int, p1.n):void");
    }

    public final void l(n nVar) {
        if (h()) {
            this.f8247i.add(new d(nVar.f8318g, this.f8254p, e.f8264g, null));
            List listI = nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0);
            int size = listI.size();
            for (int i2 = 0; i2 < size; i2++) {
                l((n) listI.get(i2));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r17 = this;
            r0 = r17
            k.t r1 = r0.f8255q
            r1.c()
            k.j r2 = r0.g()
            int[] r3 = r2.f5499b
            java.lang.Object[] r4 = r2.f5500c
            long[] r2 = r2.f5498a
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L5e
            r7 = 0
        L17:
            r8 = r2[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L59
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L31:
            if (r12 >= r10) goto L57
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L53
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            p1.o r13 = (p1.o) r13
            j1.t1 r15 = new j1.t1
            p1.n r13 = r13.f8319a
            k.j r6 = r0.g()
            r15.<init>(r13, r6)
            r1.g(r14, r15)
        L53:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L31
        L57:
            if (r10 != r11) goto L5e
        L59:
            if (r7 == r5) goto L5e
            int r7 = r7 + 1
            goto L17
        L5e:
            j1.t1 r1 = new j1.t1
            j1.y r2 = r0.f8244f
            p1.p r2 = r2.getSemanticsOwner()
            p1.n r2 = r2.a()
            k.j r3 = r0.g()
            r1.<init>(r2, r3)
            r0.f8256r = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.c.m():void");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f8252n.removeCallbacks(this.f8258t);
        this.f8246h = null;
    }
}
