package b1;

import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.compose.ui.focus.FocusOwnerImpl$modifier$1;
import p.a0;
import p.y;
import u1.c1;
import u1.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    public v1.t f1818a;

    /* renamed from: b, reason: collision with root package name */
    public v1.t f1819b;

    /* renamed from: c, reason: collision with root package name */
    public q f1820c;

    /* renamed from: d, reason: collision with root package name */
    public f f1821d;

    /* renamed from: e, reason: collision with root package name */
    public FocusOwnerImpl$modifier$1 f1822e;

    /* renamed from: f, reason: collision with root package name */
    public y f1823f;

    /* renamed from: g, reason: collision with root package name */
    public a0 f1824g;

    /* renamed from: h, reason: collision with root package name */
    public q f1825h;

    public final boolean a(boolean z10) {
        c1 c1Var;
        q qVar = this.f1825h;
        if (qVar != null) {
            f(null);
            qVar.B0(p.f1844c, p.f1847h);
            if (!qVar.f15114c.f15126r) {
                r1.a.b("visitAncestors called on an unattached node");
            }
            w0.l lVar = qVar.f15114c.i;
            g0 g0VarU = u1.f.u(qVar);
            while (g0VarU != null) {
                if ((g0VarU.H.f13746f.f15117h & 1024) != 0) {
                    while (lVar != null) {
                        if ((lVar.f15116g & 1024) != 0) {
                            w0.l lVarE = lVar;
                            m0.e eVar = null;
                            while (lVarE != null) {
                                if (lVarE instanceof q) {
                                    ((q) lVarE).B0(p.f1845f, p.f1847h);
                                } else if ((lVarE.f15116g & 1024) != 0 && (lVarE instanceof u1.m)) {
                                    int i = 0;
                                    for (w0.l lVar2 = ((u1.m) lVarE).f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
                                        if ((lVar2.f15116g & 1024) != 0) {
                                            i++;
                                            if (i == 1) {
                                                lVarE = lVar2;
                                            } else {
                                                if (eVar == null) {
                                                    eVar = new m0.e(new w0.l[16]);
                                                }
                                                if (lVarE != null) {
                                                    eVar.b(lVarE);
                                                    lVarE = null;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                lVarE = u1.f.e(eVar);
                            }
                        }
                        lVar = lVar.i;
                    }
                }
                g0VarU = g0VarU.t();
                lVar = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
            }
        }
        return true;
    }

    public final boolean b(int i, boolean z10, boolean z11) {
        int iOrdinal;
        boolean z12 = true;
        if (z10 || (iOrdinal = e.s(this.f1820c, i).ordinal()) == 0) {
            a(z10);
        } else {
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                g5.f.a();
                return false;
            }
            z12 = false;
        }
        if (z12 && z11) {
            c();
        }
        return z12;
    }

    public final void c() {
        v1.t tVar = this.f1818a;
        if (tVar.isFocused() || tVar.hasFocus()) {
            tVar.clearFocus();
        } else if (tVar.hasFocus()) {
            View viewFindFocus = tVar.findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            tVar.clearFocus();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Type inference failed for: r0v20, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v23, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r12v24, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r12v28, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r12v29, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r12v33, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v42, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v62 */
    /* JADX WARN: Type inference failed for: r12v63 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v65 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.view.KeyEvent r13, xb.a r14) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.i.d(android.view.KeyEvent, xb.a):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:245:0x011f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean e(int r19, c1.c r20, xb.l r21) {
        /*
            Method dump skipped, instructions count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.i.e(int, c1.c, xb.l):java.lang.Boolean");
    }

    public final void f(q qVar) {
        g0 g0VarU;
        a2.k kVarV;
        g0 g0VarU2;
        a2.k kVarV2;
        q qVar2 = this.f1825h;
        this.f1825h = qVar;
        a0 a0Var = this.f1824g;
        Object[] objArr = a0Var.f9516a;
        int i = a0Var.f9517b;
        for (int i3 = 0; i3 < i; i3++) {
            x0.b bVar = (x0.b) objArr[i3];
            bVar.getClass();
            if (qVar2 != null && (g0VarU2 = u1.f.u(qVar2)) != null && (kVarV2 = g0VarU2.v()) != null && kVarV2.f75c.b(a2.j.f56g)) {
                ((AutofillManager) bVar.f15505a.f12315f).notifyViewExited(bVar.f15507c, g0VarU2.f13790f);
            }
            if (qVar != null && (g0VarU = u1.f.u(qVar)) != null && (kVarV = g0VarU.v()) != null && kVarV.f75c.b(a2.j.f56g)) {
                int i10 = g0VarU.f13790f;
                bVar.f15508d.f1863a.k(i10, new x0.a(bVar, i10));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009d, code lost:
    
        r33 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
    
        if (((r8 & ((~r8) << 6)) & (-9187201950435737472L)) == r33) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        r0 = r4.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00af, code lost:
    
        if (r4.f9649e != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c0, code lost:
    
        if (((r4.f9645a[r0 >> 3] >> ((r0 & 7) << 3)) & 255) != 254) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c2, code lost:
    
        r37 = true;
        r40 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c8, code lost:
    
        r0 = r4.f9647c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ca, code lost:
    
        if (r0 <= 8) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00db, code lost:
    
        if (java.lang.Long.compareUnsigned(r4.f9648d * 32, r0 * 25) > 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00dd, code lost:
    
        r0 = r4.f9645a;
        r6 = r4.f9647c;
        r12 = r4.f9646b;
        r13 = (r6 + 7) >> 3;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e9, code lost:
    
        if (r14 >= r13) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00eb, code lost:
    
        r8 = r0[r14] & (-9187201950435737472L);
        r0[r14] = ((~r8) + (r8 >>> 7)) & (-72340172838076674L);
        r14 = r14 + 1;
        r5 = r5;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0106, code lost:
    
        r15 = r5;
        r16 = r6;
        r40 = 128;
        r5 = kb.k.q0(r0);
        r6 = r5 - 1;
        r13 = 72057594037927935L;
        r0[r6] = (r0[r6] & 72057594037927935L) | (-72057594037927936L);
        r0[r5] = r0[0];
        r5 = r16;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0127, code lost:
    
        if (r6 == r5) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0129, code lost:
    
        r8 = r6 >> 3;
        r9 = (r6 & 7) << 3;
        r16 = (r0[r8] >> r9) & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0137, code lost:
    
        if (r16 != 128) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0139, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x013e, code lost:
    
        if (r16 == 254) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0141, code lost:
    
        r16 = java.lang.Long.hashCode(r12[r6]) * r28;
        r17 = r13;
        r13 = (r16 ^ (r16 << 16)) >>> 7;
        r14 = r4.b(r13);
        r13 = r13 & r5;
        r29 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0165, code lost:
    
        if ((((r14 - r13) & r5) / 8) != (((r6 - r13) & r5) / 8)) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0167, code lost:
    
        r37 = r7;
        r0[r8] = ((~(255 << r9)) & r0[r8]) | ((r16 & 127) << r9);
        r0[r0.length - 1] = (r0[0] & r17) | Long.MIN_VALUE;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0185, code lost:
    
        r13 = r17;
        r15 = r29;
        r7 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x018c, code lost:
    
        r37 = r7;
        r7 = r14 >> 3;
        r26 = r0[r7];
        r8 = (r14 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x019e, code lost:
    
        if (((r26 >> r8) & 255) != 128) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a0, code lost:
    
        r15 = r5;
        r35 = r6;
        r0[r7] = (r26 & (~(255 << r8))) | ((r16 & 127) << r8);
        r0[r8] = (r0[r8] & (~(255 << r9))) | (128 << r9);
        r12[r14] = r12[r35];
        r12[r35] = r33;
        r6 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01c7, code lost:
    
        r15 = r5;
        r35 = r6;
        r0[r7] = (r26 & (~(255 << r8))) | ((r16 & 127) << r8);
        r5 = r12[r14];
        r12[r14] = r12[r35];
        r12[r35] = r5;
        r6 = r35 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01e3, code lost:
    
        r0[r0.length - 1] = (r0[0] & r17) | Long.MIN_VALUE;
        r6 = r6 + 1;
        r5 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01f2, code lost:
    
        r37 = r7;
        r4.f9649e = p.n0.a(r4.f9647c) - r4.f9648d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0201, code lost:
    
        r37 = true;
        r40 = 128;
        r0 = p.n0.b(r4.f9647c);
        r5 = r4.f9645a;
        r6 = r4.f9646b;
        r7 = r4.f9647c;
        r4.c(r0);
        r0 = r4.f9645a;
        r8 = r4.f9646b;
        r9 = r4.f9647c;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x021c, code lost:
    
        if (r12 >= r7) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x022b, code lost:
    
        if (((r5[r12 >> 3] >> ((r12 & 7) << 3)) & 255) >= 128) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x022d, code lost:
    
        r13 = r6[r12];
        r15 = java.lang.Long.hashCode(r13) * r28;
        r15 = r15 ^ (r15 << 16);
        r16 = r0;
        r0 = r4.b(r15 >>> 7);
        r17 = r5;
        r18 = r6;
        r5 = r15 & 127;
        r15 = r0 >> 3;
        r19 = (r0 & 7) << 3;
        r5 = (r16[r15] & (~(255 << r19))) | (r5 << r19);
        r16[r15] = r5;
        r16[(((r0 - 7) & r9) + (r9 & 7)) >> 3] = r5;
        r8[r0] = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x026b, code lost:
    
        r16 = r0;
        r17 = r5;
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0271, code lost:
    
        r12 = r12 + 1;
        r0 = r16;
        r5 = r17;
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x027a, code lost:
    
        r0 = r4.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x027e, code lost:
    
        r14 = r0;
        r4.f9648d++;
        r0 = r4.f9649e;
        r3 = r4.f9645a;
        r5 = r14 >> 3;
        r6 = r3[r5];
        r8 = (r14 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0297, code lost:
    
        if (((r6 >> r8) & 255) != r40) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0299, code lost:
    
        r21 = r37 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x029b, code lost:
    
        r4.f9649e = r0 - r21;
        r0 = r4.f9647c;
        r6 = (r6 & (~(255 << r8))) | (r10 << r8);
        r3[r5] = r6;
        r3[(((r14 - 7) & r0) + (r0 & 7)) >> 3] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0342, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0344, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.KeyEvent r41) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.i.g(android.view.KeyEvent):boolean");
    }
}
