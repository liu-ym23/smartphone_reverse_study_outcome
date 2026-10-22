package u1;

import java.util.HashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public g0 f13741a;

    /* renamed from: b, reason: collision with root package name */
    public b1 f13742b;

    /* renamed from: c, reason: collision with root package name */
    public s f13743c;

    /* renamed from: d, reason: collision with root package name */
    public g1 f13744d;

    /* renamed from: e, reason: collision with root package name */
    public x1 f13745e;

    /* renamed from: f, reason: collision with root package name */
    public w0.l f13746f;

    /* renamed from: g, reason: collision with root package name */
    public m0.e f13747g;

    /* renamed from: h, reason: collision with root package name */
    public m0.e f13748h;
    public m0.e i;

    /* renamed from: j, reason: collision with root package name */
    public a1 f13749j;

    public static final void a(c1 c1Var, w0.l lVar, g1 g1Var) {
        for (w0.l lVar2 = lVar.i; lVar2 != null; lVar2 = lVar2.i) {
            if (lVar2 == c1Var.f13742b) {
                g0 g0VarT = c1Var.f13741a.t();
                g1Var.f13812u = g0VarT != null ? g0VarT.H.f13743c : null;
                c1Var.f13744d = g1Var;
                return;
            } else {
                if ((lVar2.f15116g & 2) != 0) {
                    return;
                }
                lVar2.A0(g1Var);
            }
        }
    }

    public static w0.l b(w0.k kVar, w0.l lVar) {
        w0.l lVarG;
        if (kVar instanceof y0) {
            lVarG = ((y0) kVar).g();
            lVarG.f15116g = h1.f(lVarG);
        } else {
            c cVar = new c();
            cVar.f15116g = h1.d(kVar);
            cVar.f13733s = kVar;
            cVar.f13735u = new HashSet();
            lVarG = cVar;
        }
        if (lVarG.f15126r) {
            r1.a.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        lVarG.f15121m = true;
        w0.l lVar2 = lVar.f15118j;
        if (lVar2 != null) {
            lVar2.i = lVarG;
            lVarG.f15118j = lVar2;
        }
        lVar.f15118j = lVarG;
        lVarG.i = lVar;
        return lVarG;
    }

    public static w0.l c(w0.l lVar) {
        boolean z10 = lVar.f15126r;
        if (z10) {
            p.z zVar = h1.f13831a;
            if (!z10) {
                r1.a.b("autoInvalidateRemovedNode called on unattached node");
            }
            h1.a(lVar, -1, 2);
            lVar.y0();
            lVar.s0();
        }
        w0.l lVar2 = lVar.f15118j;
        w0.l lVar3 = lVar.i;
        if (lVar2 != null) {
            lVar2.i = lVar3;
            lVar.f15118j = null;
        }
        if (lVar3 != null) {
            lVar3.f15118j = lVar2;
            lVar.i = null;
        }
        lVar3.getClass();
        return lVar3;
    }

    public static void h(w0.k kVar, w0.k kVar2, w0.l lVar) {
        if ((kVar instanceof y0) && (kVar2 instanceof y0)) {
            lVar.getClass();
            ((y0) kVar2).i(lVar);
            if (lVar.f15126r) {
                h1.c(lVar);
                return;
            } else {
                lVar.f15122n = true;
                return;
            }
        }
        if (!(lVar instanceof c)) {
            r1.a.b("Unknown Modifier.Node type");
            return;
        }
        c cVar = (c) lVar;
        if (cVar.f15126r) {
            cVar.C0();
        }
        cVar.f13733s = kVar2;
        cVar.f15116g = h1.d(kVar2);
        if (cVar.f15126r) {
            cVar.B0(false);
        }
        if (lVar.f15126r) {
            h1.c(lVar);
        } else {
            lVar.f15122n = true;
        }
    }

    public final boolean d(int i) {
        return (this.f13746f.f15117h & i) != 0;
    }

    public final void e() {
        for (w0.l lVar = this.f13746f; lVar != null; lVar = lVar.f15118j) {
            lVar.x0();
            if (lVar.f15121m) {
                p.z zVar = h1.f13831a;
                if (!lVar.f15126r) {
                    r1.a.b("autoInvalidateInsertedNode called on unattached node");
                }
                h1.a(lVar, -1, 1);
            }
            if (lVar.f15122n) {
                h1.c(lVar);
            }
            lVar.f15121m = false;
            lVar.f15122n = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0267, code lost:
    
        r13 = r28 + 2;
        r11 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x026d, code lost:
    
        r1 = r1 + 1;
        r12 = r20;
        r11 = r21;
        r13 = r26;
        r14 = r29;
        r35 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014d, code lost:
    
        r26 = r13;
        r29 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0153, code lost:
    
        if ((r19 & 1) != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0155, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0157, code lost:
    
        r11 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0159, code lost:
    
        r13 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015a, code lost:
    
        if (r13 > r1) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015c, code lost:
    
        if (r13 == r12) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015e, code lost:
    
        if (r13 == r1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0160, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016e, code lost:
    
        if (r20[(r13 + 1) + r17] >= r20[(r13 - 1) + r17]) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0171, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0173, code lost:
    
        r11 = r20[(r13 - 1) + r17];
        r14 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x017c, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017e, code lost:
    
        r11 = r20[(r13 + 1) + r17];
        r14 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0185, code lost:
    
        r22 = r10 - ((r5 - r14) - r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018b, code lost:
    
        if (r1 == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018d, code lost:
    
        r25 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0190, code lost:
    
        r25 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0192, code lost:
    
        if (r14 != r11) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0194, code lost:
    
        r27 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0197, code lost:
    
        r27 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
    
        r25 = r22 + (r25 & r27);
        r22 = r11;
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
    
        if (r14 <= r7) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a5, code lost:
    
        if (r11 <= r15) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a7, code lost:
    
        r27 = r11;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b3, code lost:
    
        if (r6.a(r14 - 1, r27 - 1) == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b5, code lost:
    
        r14 = r14 - 1;
        r11 = r27 - 1;
        r13 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01bc, code lost:
    
        r27 = r11;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c0, code lost:
    
        r20[r17 + r28] = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c4, code lost:
    
        if (r24 == 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c6, code lost:
    
        r11 = r19 - r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c8, code lost:
    
        if (r11 < r12) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ca, code lost:
    
        if (r11 > r1) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d0, code lost:
    
        if (r16[r17 + r11] < r14) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d2, code lost:
    
        r26[r33] = r14;
        r11 = 1;
        r26[1] = r27;
        r26[r32] = r22;
        r26[3] = r25;
        r26[4] = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r32, m0.e r33, m0.e r34, w0.l r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.c1.f(int, m0.e, m0.e, w0.l, boolean):void");
    }

    public final void g() {
        y yVar;
        g0 g0Var = this.f13741a;
        g1 g1Var = this.f13743c;
        for (w0.l lVar = this.f13745e.i; lVar != null; lVar = lVar.i) {
            w wVarF = f.f(lVar);
            if (wVarF != null) {
                g1 g1Var2 = lVar.f15120l;
                if (g1Var2 != null) {
                    y yVar2 = (y) g1Var2;
                    w wVar = yVar2.R;
                    yVar2.e1(wVarF);
                    yVar = yVar2;
                    if (wVar != lVar) {
                        m1 m1Var = yVar2.M;
                        yVar = yVar2;
                        if (m1Var != null) {
                            ((v1.h1) m1Var).c();
                            yVar = yVar2;
                        }
                    }
                } else {
                    y yVar3 = new y(g0Var, wVarF);
                    lVar.A0(yVar3);
                    yVar = yVar3;
                }
                g1Var.f13812u = yVar;
                yVar.f13811t = g1Var;
                g1Var = yVar;
            } else {
                lVar.A0(g1Var);
            }
        }
        g0 g0VarT = g0Var.t();
        g1Var.f13812u = g0VarT != null ? g0VarT.H.f13743c : null;
        this.f13744d = g1Var;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        w0.l lVar = this.f13746f;
        x1 x1Var = this.f13745e;
        if (lVar == x1Var) {
            sb2.append("]");
        } else {
            while (true) {
                if (lVar == null || lVar == x1Var) {
                    break;
                }
                sb2.append(String.valueOf(lVar));
                if (lVar.f15118j == x1Var) {
                    sb2.append("]");
                    break;
                }
                sb2.append(",");
                lVar = lVar.f15118j;
            }
        }
        return sb2.toString();
    }
}
