package i1;

import android.os.Trace;
import b0.c2;
import b0.k2;
import b0.l2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4395a = 1;

    /* renamed from: b, reason: collision with root package name */
    public d0.e f4396b;

    /* renamed from: c, reason: collision with root package name */
    public d0.e f4397c;

    /* renamed from: d, reason: collision with root package name */
    public final d0.e f4398d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4399e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4400f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4401g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4402h;

    /* renamed from: i, reason: collision with root package name */
    public Object f4403i;

    /* renamed from: j, reason: collision with root package name */
    public Object f4404j;

    /* renamed from: k, reason: collision with root package name */
    public Object f4405k;

    public a1(f0 f0Var) {
        this.f4399e = f0Var;
        z0 z0Var = new z0();
        z0Var.f6800i = -1;
        this.f4400f = z0Var;
        r rVar = new r(f0Var);
        this.f4401g = rVar;
        this.f4402h = rVar;
        u1 u1Var = rVar.S;
        this.f4403i = u1Var;
        this.f4404j = u1Var;
        this.f4398d = new d0.e(new n0.m[16]);
    }

    public static final void a(a1 a1Var, n0.l lVar, d1 d1Var) {
        for (n0.l lVar2 = lVar.f6801j; lVar2 != null; lVar2 = lVar2.f6801j) {
            if (lVar2 == ((z0) a1Var.f4400f)) {
                f0 f0VarN = ((f0) a1Var.f4399e).n();
                d1Var.f4439v = f0VarN != null ? (r) f0VarN.H.f4401g : null;
                a1Var.f4402h = d1Var;
                return;
            } else {
                if ((lVar2.f6799h & 2) != 0) {
                    return;
                }
                lVar2.k0(d1Var);
            }
        }
    }

    public static n0.l c(n0.k kVar, n0.l lVar) {
        n0.l lVarD;
        if (kVar instanceof w0) {
            lVarD = ((w0) kVar).d();
            lVarD.f6799h = e1.f(lVarD);
        } else {
            c cVar = new c();
            cVar.f6799h = e1.d(kVar);
            cVar.f4415t = kVar;
            cVar.f4417v = new HashSet();
            lVarD = cVar;
        }
        if (lVarD.f6810s) {
            f1.a.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        lVarD.f6805n = true;
        n0.l lVar2 = lVar.f6802k;
        if (lVar2 != null) {
            lVar2.f6801j = lVarD;
            lVarD.f6802k = lVar2;
        }
        lVar.f6802k = lVarD;
        lVarD.f6801j = lVar;
        return lVarD;
    }

    public static n0.l d(n0.l lVar) {
        boolean z4 = lVar.f6810s;
        if (z4) {
            k.y yVar = e1.f4446a;
            if (!z4) {
                f1.a.b("autoInvalidateRemovedNode called on unattached node");
            }
            e1.a(lVar, -1, 2);
            lVar.i0();
            lVar.c0();
        }
        n0.l lVar2 = lVar.f6802k;
        n0.l lVar3 = lVar.f6801j;
        if (lVar2 != null) {
            lVar2.f6801j = lVar3;
            lVar.f6802k = null;
        }
        if (lVar3 != null) {
            lVar3.f6802k = lVar2;
            lVar.f6801j = null;
        }
        q7.k.b(lVar3);
        return lVar3;
    }

    public static void m(n0.k kVar, n0.k kVar2, n0.l lVar) {
        if ((kVar instanceof w0) && (kVar2 instanceof w0)) {
            q7.k.c(lVar, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
            ((w0) kVar2).f(lVar);
            if (lVar.f6810s) {
                e1.c(lVar);
                return;
            } else {
                lVar.f6806o = true;
                return;
            }
        }
        if (!(lVar instanceof c)) {
            f1.a.b("Unknown Modifier.Node type");
            return;
        }
        c cVar = (c) lVar;
        if (cVar.f6810s) {
            cVar.m0();
        }
        cVar.f4415t = kVar2;
        cVar.f6799h = e1.d(kVar2);
        if (cVar.f6810s) {
            cVar.l0(false);
        }
        if (lVar.f6810s) {
            e1.c(lVar);
        } else {
            lVar.f6806o = true;
        }
    }

    public void b() {
        this.f4399e = null;
        this.f4400f = null;
        d0.e eVar = this.f4396b;
        eVar.g();
        ((k.b0) this.f4401g).b();
        this.f4397c = eVar;
        this.f4398d.g();
        ((d0.e) this.f4402h).g();
        this.f4403i = null;
        this.f4404j = null;
        this.f4405k = null;
    }

    public void e() {
        Set set = (Set) this.f4399e;
        if (set == null || set.isEmpty()) {
            return;
        }
        Trace.beginSection("Compose:abandons");
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                k2 k2Var = (k2) it.next();
                it.remove();
                k2Var.f();
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Finally extract failed */
    public void f() {
        d0.e eVar = this.f4396b;
        Set set = (Set) this.f4399e;
        if (set == null) {
            return;
        }
        d0.e eVar2 = this.f4398d;
        if (eVar2.f2751h != 0) {
            Trace.beginSection("Compose:onForgotten");
            try {
                k.b0 b0Var = (k.b0) this.f4403i;
                int i2 = eVar2.f2751h;
                while (true) {
                    i2--;
                    if (-1 >= i2) {
                        break;
                    }
                    Object obj = eVar2.f2749f[i2];
                    try {
                        if (obj instanceof l2) {
                            k2 k2Var = ((l2) obj).f1236a;
                            set.remove(k2Var);
                            k2Var.h();
                        }
                        if (obj instanceof f0) {
                            if (b0Var == null || !b0Var.c(obj)) {
                                ((f0) obj).G();
                            } else {
                                a1 a1Var = ((f0) obj).H;
                                d1 d1Var = ((r) a1Var.f4401g).f4438u;
                                for (d1 d1Var2 = (d1) a1Var.f4402h; !q7.k.a(d1Var2, d1Var) && d1Var2 != null; d1Var2 = d1Var2.f4438u) {
                                    d1Var2.N0();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        m0.c cVar = (m0.c) this.f4400f;
                        if (cVar != null) {
                            s7.a.m0(th, new c2(2, cVar, obj));
                        }
                        throw th;
                    }
                }
            } finally {
                Trace.endSection();
            }
        }
        if (eVar.f2751h != 0) {
            Trace.beginSection("Compose:onRemembered");
            try {
                Set set2 = (Set) this.f4399e;
                if (set2 != null) {
                    Object[] objArr = eVar.f2749f;
                    int i10 = eVar.f2751h;
                    for (int i11 = 0; i11 < i10; i11++) {
                        l2 l2Var = (l2) objArr[i11];
                        k2 k2Var2 = l2Var.f1236a;
                        set2.remove(k2Var2);
                        try {
                            k2Var2.c();
                        } catch (Throwable th2) {
                            m0.c cVar2 = (m0.c) this.f4400f;
                            if (cVar2 != null) {
                                s7.a.m0(th2, new c2(2, cVar2, l2Var));
                            }
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void g(l2 l2Var) {
        d0.e eVar = this.f4396b;
        k.b0 b0Var = (k.b0) this.f4401g;
        if (b0Var.c(l2Var)) {
            b0Var.k(l2Var);
            if (!this.f4397c.i(l2Var) && !eVar.i(l2Var)) {
                Object[] objArr = eVar.f2749f;
                int i2 = eVar.f2751h;
                for (int i10 = 0; i10 < i2; i10++) {
                    if (((l2) objArr[i10]).f1236a instanceof j0.f) {
                        throw null;
                    }
                }
            }
            Set set = (Set) this.f4399e;
            if (set == null) {
                return;
            } else {
                set.add(l2Var.f1236a);
            }
        }
        this.f4398d.b(l2Var);
    }

    public boolean h(int i2) {
        return (((n0.l) this.f4404j).f6800i & i2) != 0;
    }

    public void i(Set set, m0.c cVar) {
        b();
        this.f4399e = set;
        this.f4400f = cVar;
    }

    public void j() {
        for (n0.l lVar = (n0.l) this.f4404j; lVar != null; lVar = lVar.f6802k) {
            lVar.h0();
            if (lVar.f6805n) {
                k.y yVar = e1.f4446a;
                if (!lVar.f6810s) {
                    f1.a.b("autoInvalidateInsertedNode called on unattached node");
                }
                e1.a(lVar, -1, 1);
            }
            if (lVar.f6806o) {
                e1.c(lVar);
            }
            lVar.f6805n = false;
            lVar.f6806o = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0264, code lost:
    
        r13 = r28 + 2;
        r11 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x026a, code lost:
    
        r3 = r3 + 1;
        r12 = r20;
        r11 = r21;
        r13 = r26;
        r14 = r29;
        r35 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014a, code lost:
    
        r26 = r13;
        r29 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0150, code lost:
    
        if ((r19 & 1) != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0152, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0154, code lost:
    
        r11 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0156, code lost:
    
        r13 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0157, code lost:
    
        if (r13 > r3) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0159, code lost:
    
        if (r13 == r12) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
    
        if (r13 == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015d, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016b, code lost:
    
        if (r20[(r13 + 1) + r17] >= r20[(r13 - 1) + r17]) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016e, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0170, code lost:
    
        r11 = r20[(r13 - 1) + r17];
        r14 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0179, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017b, code lost:
    
        r11 = r20[(r13 + 1) + r17];
        r14 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0182, code lost:
    
        r22 = r10 - ((r6 - r14) - r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0188, code lost:
    
        if (r3 == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018a, code lost:
    
        r25 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018d, code lost:
    
        r25 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018f, code lost:
    
        if (r14 != r11) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0191, code lost:
    
        r27 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0194, code lost:
    
        r27 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0196, code lost:
    
        r25 = r22 + (r25 & r27);
        r22 = r11;
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a0, code lost:
    
        if (r14 <= r7) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a2, code lost:
    
        if (r11 <= r15) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        r27 = r11;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b0, code lost:
    
        if (r0.a(r14 - 1, r27 - 1) == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b2, code lost:
    
        r14 = r14 - 1;
        r11 = r27 - 1;
        r13 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b9, code lost:
    
        r27 = r11;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bd, code lost:
    
        r20[r17 + r28] = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c1, code lost:
    
        if (r24 == 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c3, code lost:
    
        r11 = r19 - r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c5, code lost:
    
        if (r11 < r12) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c7, code lost:
    
        if (r11 > r3) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cd, code lost:
    
        if (r16[r17 + r11] < r14) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cf, code lost:
    
        r26[r33] = r14;
        r11 = 1;
        r26[1] = r27;
        r26[r32] = r22;
        r26[3] = r25;
        r26[4] = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(int r32, d0.e r33, d0.e r34, n0.l r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.a1.k(int, d0.e, d0.e, n0.l, boolean):void");
    }

    public void l() {
        x xVar;
        f0 f0Var = (f0) this.f4399e;
        d1 d1Var = (r) this.f4401g;
        for (n0.l lVar = ((u1) this.f4403i).f6801j; lVar != null; lVar = lVar.f6801j) {
            v vVarF = l.f(lVar);
            if (vVarF != null) {
                d1 d1Var2 = lVar.f6804m;
                if (d1Var2 != null) {
                    x xVar2 = (x) d1Var2;
                    v vVar = xVar2.S;
                    xVar2.Z0(vVarF);
                    xVar = xVar2;
                    if (vVar != lVar) {
                        j1 j1Var = xVar2.N;
                        xVar = xVar2;
                        if (j1Var != null) {
                            ((j1.n1) j1Var).invalidate();
                            xVar = xVar2;
                        }
                    }
                } else {
                    x xVar3 = new x(f0Var, vVarF);
                    lVar.k0(xVar3);
                    xVar = xVar3;
                }
                d1Var.f4439v = xVar;
                xVar.f4438u = d1Var;
                d1Var = xVar;
            } else {
                lVar.k0(d1Var);
            }
        }
        f0 f0VarN = f0Var.n();
        d1Var.f4439v = f0VarN != null ? (r) f0VarN.H.f4401g : null;
        this.f4402h = d1Var;
    }

    public String toString() {
        switch (this.f4395a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("[");
                n0.l lVar = (n0.l) this.f4404j;
                u1 u1Var = (u1) this.f4403i;
                if (lVar == u1Var) {
                    sb2.append("]");
                } else {
                    while (true) {
                        if (lVar != null && lVar != u1Var) {
                            sb2.append(String.valueOf(lVar));
                            if (lVar.f6802k == u1Var) {
                                sb2.append("]");
                            } else {
                                sb2.append(",");
                                lVar = lVar.f6802k;
                            }
                        }
                    }
                }
                String string = sb2.toString();
                q7.k.d(string, "toString(...)");
                return string;
            default:
                return super.toString();
        }
    }

    public a1() {
        d0.e eVar = new d0.e(new l2[16]);
        this.f4396b = eVar;
        int i2 = k.h0.f5493a;
        this.f4401g = new k.b0();
        this.f4397c = eVar;
        this.f4398d = new d0.e(new Object[16]);
        this.f4402h = new d0.e(new p7.a[16]);
    }
}
