package m4;

import android.view.View;
import android.view.autofill.AutofillManager;
import fi.iki.elonen.NanoHTTPD;
import i1.a1;
import i1.u1;
import ia.f1;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import n0.l;
import s0.q;

/* loaded from: classes.dex */
public final class u0 implements s0.h {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6341a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6342b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6343c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6344d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f6345e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6346f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f6347g;

    /* renamed from: h, reason: collision with root package name */
    public Object f6348h;

    public u0(File file) {
        this.f6341a = file;
        file.mkdirs();
        File fileO = n7.l.O(file, "root/.openclaw/openclaw.json");
        this.f6342b = fileO;
        this.f6343c = b(fileO);
        File fileO2 = n7.l.O(file, "root/.openclaw/agents/main/agent/auth-profiles.json");
        this.f6344d = fileO2;
        this.f6345e = b(fileO2);
        b(n7.l.O(file, "root/.openclaw/agents/main/agent/models.json"));
        this.f6346f = h("root/.openclaw/workspace");
        this.f6347g = n7.l.O(file, "root/.openclaw/cron/jobs.json");
        this.f6348h = h("root/.openclaw/cron/runs");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, m4.u0] */
    /* JADX WARN: Type inference failed for: r5v1, types: [m4.u0] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r5v7, types: [c7.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [d5.e] */
    /* JADX WARN: Type inference failed for: r6v1, types: [d5.e] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(m4.u0 r5, d5.e r6, i7.c r7) {
        /*
            r5.getClass()
            boolean r0 = r7 instanceof o5.b
            if (r0 == 0) goto L16
            r0 = r7
            o5.b r0 = (o5.b) r0
            int r1 = r0.f7735j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f7735j = r1
            goto L1b
        L16:
            o5.b r0 = new o5.b
            r0.<init>(r5, r7)
        L1b:
            java.lang.Object r7 = r0.f7733h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f7735j
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            d5.e r6 = r0.f7732g
            m4.u0 r5 = r0.f7731f
            w7.e0.N(r7)     // Catch: java.lang.Throwable -> L2e
            goto L52
        L2e:
            r7 = move-exception
            goto L60
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            w7.e0.N(r7)
            la.j r7 = r6.a()     // Catch: java.lang.Throwable -> L2e
            a6.q r2 = new a6.q     // Catch: java.lang.Throwable -> L2e
            r4 = 6
            r2.<init>(r4, r5)     // Catch: java.lang.Throwable -> L2e
            r0.f7731f = r5     // Catch: java.lang.Throwable -> L2e
            r0.f7732g = r6     // Catch: java.lang.Throwable -> L2e
            r0.f7735j = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r7.x(r2, r0)     // Catch: java.lang.Throwable -> L2e
            if (r7 != r1) goto L52
            return r1
        L52:
            java.lang.Object r5 = r5.f6345e
            java.util.concurrent.ConcurrentHashMap r5 = (java.util.concurrent.ConcurrentHashMap) r5
            java.lang.String r6 = r6.getId()
            r5.remove(r6)
            c7.r r5 = c7.r.f1986a
            return r5
        L60:
            java.lang.Object r5 = r5.f6345e
            java.util.concurrent.ConcurrentHashMap r5 = (java.util.concurrent.ConcurrentHashMap) r5
            java.lang.String r6 = r6.getId()
            r5.remove(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.u0.a(m4.u0, d5.e, i7.c):java.lang.Object");
    }

    public static File b(File file) {
        return new File(a1.a.i(file.getAbsolutePath(), ".backup"));
    }

    public File c(String str) {
        q7.k.e(str, "channelId");
        return n7.l.O(n7.l.O((File) this.f6341a, "root/.openclaw/extensions"), ga.r.d0(ga.r.d0(ga.r.d0(str, ':', '_'), '/', '_'), '\\', '_'));
    }

    public boolean d(boolean z4) {
        a1 a1Var;
        s0.q qVar = (s0.q) this.f6348h;
        if (qVar != null) {
            m(null);
            qVar.l0(s0.p.f9193f, s0.p.f9196i);
            if (!qVar.f6797f.f6810s) {
                f1.a.b("visitAncestors called on an unattached node");
            }
            n0.l lVar = qVar.f6797f.f6801j;
            i1.f0 f0VarU = i1.l.u(qVar);
            while (f0VarU != null) {
                if ((((n0.l) f0VarU.H.f4404j).f6800i & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                    while (lVar != null) {
                        if ((lVar.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                            n0.l lVarE = lVar;
                            d0.e eVar = null;
                            while (lVarE != null) {
                                if (lVarE instanceof s0.q) {
                                    ((s0.q) lVarE).l0(s0.p.f9194g, s0.p.f9196i);
                                } else if ((lVarE.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 && (lVarE instanceof i1.k)) {
                                    int i2 = 0;
                                    for (n0.l lVar2 = ((i1.k) lVarE).f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
                                        if ((lVar2.f6799h & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                lVarE = lVar2;
                                            } else {
                                                if (eVar == null) {
                                                    eVar = new d0.e(new n0.l[16]);
                                                }
                                                if (lVarE != null) {
                                                    eVar.b(lVarE);
                                                    lVarE = null;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                lVarE = i1.l.e(eVar);
                            }
                        }
                        lVar = lVar.f6801j;
                    }
                }
                f0VarU = f0VarU.n();
                lVar = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (u1) a1Var.f4403i;
            }
        }
        return true;
    }

    public boolean e(int i2, boolean z4, boolean z10) {
        int iOrdinal;
        boolean z11 = true;
        if (z4 || (iOrdinal = s0.e.s((s0.q) this.f6343c).ordinal()) == 0) {
            d(z4);
        } else {
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                throw new a4.u();
            }
            z11 = false;
        }
        if (z11 && z10) {
            f();
        }
        return z11;
    }

    public void f() {
        j1.y yVar = (j1.y) this.f6341a;
        if (yVar.isFocused() || yVar.hasFocus()) {
            yVar.clearFocus();
        } else if (yVar.hasFocus()) {
            View viewFindFocus = yVar.findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            yVar.clearFocus();
        }
    }

    public File g(a6.c cVar) {
        File file = (File) this.f6346f;
        q7.k.e(cVar, "type");
        switch (t0.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                return n7.l.O(file, "SOUL.md");
            case 2:
                return n7.l.O(file, "AGENTS.md");
            case 3:
                return n7.l.O(file, "USER.md");
            case 4:
                return n7.l.O(file, "MEMORY.md");
            case 5:
                return n7.l.O(file, "TOOLS.md");
            case 6:
                return n7.l.O(file, "IDENTITY.md");
            default:
                throw new a4.u();
        }
    }

    public File h(String str) {
        File fileO = n7.l.O((File) this.f6341a, str);
        fileO.mkdirs();
        return fileO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e7 A[Catch: all -> 0x02ee, TryCatch #0 {all -> 0x02ee, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0033, B:17:0x0039, B:18:0x003e, B:20:0x0046, B:22:0x004b, B:24:0x0051, B:28:0x0057, B:126:0x0173, B:128:0x0179, B:129:0x017c, B:131:0x0187, B:134:0x0195, B:138:0x019f, B:141:0x01a5, B:142:0x01aa, B:162:0x01e4, B:143:0x01ae, B:145:0x01b4, B:147:0x01b8, B:149:0x01c0, B:151:0x01c6, B:155:0x01ce, B:157:0x01d7, B:158:0x01db, B:159:0x01de, B:163:0x01e9, B:164:0x01ec, B:166:0x01f2, B:168:0x01f6, B:171:0x01ff, B:173:0x0207, B:180:0x021e, B:182:0x0223, B:184:0x0227, B:207:0x0269, B:188:0x0233, B:190:0x0239, B:192:0x023d, B:194:0x0245, B:196:0x024b, B:200:0x0253, B:202:0x025c, B:203:0x0260, B:204:0x0263, B:208:0x026e, B:212:0x027e, B:214:0x0283, B:216:0x0287, B:239:0x02c9, B:220:0x0293, B:222:0x0299, B:224:0x029d, B:226:0x02a5, B:228:0x02ab, B:232:0x02b3, B:234:0x02bc, B:235:0x02c0, B:236:0x02c3, B:241:0x02d0, B:243:0x02d7, B:32:0x005f, B:34:0x0065, B:35:0x0068, B:37:0x0070, B:40:0x007e, B:44:0x0088, B:75:0x00dd, B:77:0x00e1, B:47:0x008d, B:49:0x0093, B:51:0x0097, B:53:0x009f, B:55:0x00a5, B:59:0x00ad, B:61:0x00b6, B:62:0x00ba, B:63:0x00bd, B:66:0x00c3, B:67:0x00c8, B:68:0x00cb, B:70:0x00d1, B:72:0x00d5, B:78:0x00e7, B:80:0x00ed, B:81:0x00f0, B:83:0x00fa, B:86:0x0108, B:90:0x0112, B:121:0x0167, B:123:0x016b, B:93:0x0117, B:95:0x011d, B:97:0x0121, B:99:0x0129, B:101:0x012f, B:105:0x0137, B:107:0x0140, B:108:0x0144, B:109:0x0147, B:112:0x014d, B:113:0x0152, B:114:0x0155, B:116:0x015b, B:118:0x015f), top: B:253:0x0009 }] */
    /* JADX WARN: Type inference failed for: r0v21, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r12v24, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r12v25, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r12v29, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r12v30, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r12v34, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v43, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v65 */
    /* JADX WARN: Type inference failed for: r12v66 */
    /* JADX WARN: Type inference failed for: r12v67 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean i(android.view.KeyEvent r13, p7.a r14) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.u0.i(android.view.KeyEvent, p7.a):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:241:0x011d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean j(int r19, t0.c r20, p7.k r21) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.u0.j(int, t0.c, p7.k):java.lang.Boolean");
    }

    public File k(String str) {
        q7.k.e(str, "id");
        return n7.l.O((File) this.f6341a, "root/.openclaw/skills/".concat(str));
    }

    public File l(String str) {
        q7.k.e(str, "relativePath");
        if (ga.r.g0(str, "/", false) || ga.k.k0(str, "..", false)) {
            throw new IllegalArgumentException("illegal relative path: ".concat(str).toString());
        }
        return n7.l.O((File) this.f6341a, str);
    }

    public void m(s0.q qVar) {
        i1.f0 f0VarU;
        p1.i iVarQ;
        i1.f0 f0VarU2;
        p1.i iVarQ2;
        s0.q qVar2 = (s0.q) this.f6348h;
        this.f6348h = qVar;
        k.z zVar = (k.z) this.f6347g;
        Object[] objArr = zVar.f5556a;
        int i2 = zVar.f5557b;
        for (int i10 = 0; i10 < i2; i10++) {
            o0.b bVar = (o0.b) objArr[i10];
            bVar.getClass();
            if (qVar2 != null && (f0VarU2 = i1.l.u(qVar2)) != null && (iVarQ2 = f0VarU2.q()) != null && iVarQ2.f8304f.b(p1.h.f8283f)) {
                ((AutofillManager) bVar.f7172a.f411g).notifyViewExited(bVar.f7174c, f0VarU2.f4453g);
            }
            if (qVar != null && (f0VarU = i1.l.u(qVar)) != null && (iVarQ = f0VarU.q()) != null && iVarQ.f8304f.b(p1.h.f8283f)) {
                int i11 = f0VarU.f4453g;
                bVar.f7175d.f8625a.k(i11, new o0.a(bVar, i11));
            }
        }
    }

    public File n(String str, s0 s0Var) {
        q7.k.e(str, "id");
        q7.k.e(s0Var, "source");
        int i2 = t0.$EnumSwitchMapping$1[s0Var.ordinal()];
        if (i2 == 1) {
            return n7.l.O(k(str), "SKILL.md");
        }
        if (i2 != 2) {
            throw new a4.u();
        }
        return n7.l.O(n7.l.O((File) this.f6341a, "usr/local/lib/node_modules/openclaw/skills/".concat(str)), "SKILL.md");
    }

    public File o(String str) {
        q7.k.e(str, "id");
        return n7.l.O(n7.l.O(n7.l.O((File) this.f6341a, "usr/local/lib/node_modules/openclaw/tools"), str), ".tool-meta.json");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009f, code lost:
    
        r33 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a9, code lost:
    
        if (((r8 & ((~r8) << 6)) & (-9187201950435737472L)) == r33) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ab, code lost:
    
        r0 = r4.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b1, code lost:
    
        if (r4.f5549e != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c2, code lost:
    
        if (((r4.f5545a[r0 >> 3] >> ((r0 & 7) << 3)) & 255) != 254) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c4, code lost:
    
        r37 = true;
        r40 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ca, code lost:
    
        r0 = r4.f5547c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00cc, code lost:
    
        if (r0 <= 8) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00dd, code lost:
    
        if (java.lang.Long.compareUnsigned(r4.f5548d * 32, r0 * 25) > 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00df, code lost:
    
        r0 = r4.f5545a;
        r6 = r4.f5547c;
        r12 = r4.f5546b;
        r13 = (r6 + 7) >> 3;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00eb, code lost:
    
        if (r14 >= r13) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ed, code lost:
    
        r8 = r0[r14] & (-9187201950435737472L);
        r0[r14] = ((~r8) + (r8 >>> 7)) & (-72340172838076674L);
        r14 = r14 + 1;
        r5 = r5;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0108, code lost:
    
        r15 = r5;
        r16 = r6;
        r40 = 128;
        r5 = d7.n.i0(r0);
        r6 = r5 - 1;
        r13 = 72057594037927935L;
        r0[r6] = (r0[r6] & 72057594037927935L) | (-72057594037927936L);
        r0[r5] = r0[0];
        r5 = r16;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0129, code lost:
    
        if (r6 == r5) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x012b, code lost:
    
        r8 = r6 >> 3;
        r9 = (r6 & 7) << 3;
        r16 = (r0[r8] >> r9) & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0139, code lost:
    
        if (r16 != 128) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013b, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0140, code lost:
    
        if (r16 == 254) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0143, code lost:
    
        r16 = java.lang.Long.hashCode(r12[r6]) * r28;
        r17 = r13;
        r13 = (r16 ^ (r16 << 16)) >>> 7;
        r14 = r4.b(r13);
        r13 = r13 & r5;
        r29 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0167, code lost:
    
        if ((((r14 - r13) & r5) / 8) != (((r6 - r13) & r5) / 8)) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0169, code lost:
    
        r37 = r7;
        r0[r8] = ((~(255 << r9)) & r0[r8]) | ((r16 & 127) << r9);
        r0[r0.length - 1] = (r0[0] & r17) | Long.MIN_VALUE;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0187, code lost:
    
        r13 = r17;
        r15 = r29;
        r7 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x018e, code lost:
    
        r37 = r7;
        r7 = r14 >> 3;
        r26 = r0[r7];
        r8 = (r14 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a0, code lost:
    
        if (((r26 >> r8) & 255) != 128) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a2, code lost:
    
        r15 = r5;
        r35 = r6;
        r0[r7] = (r26 & (~(255 << r8))) | ((r16 & 127) << r8);
        r0[r8] = (r0[r8] & (~(255 << r9))) | (128 << r9);
        r12[r14] = r12[r35];
        r12[r35] = r33;
        r6 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01c9, code lost:
    
        r15 = r5;
        r35 = r6;
        r0[r7] = (r26 & (~(255 << r8))) | ((r16 & 127) << r8);
        r5 = r12[r14];
        r12[r14] = r12[r35];
        r12[r35] = r5;
        r6 = r35 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01e5, code lost:
    
        r0[r0.length - 1] = (r0[0] & r17) | Long.MIN_VALUE;
        r6 = r6 + 1;
        r5 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01f4, code lost:
    
        r37 = r7;
        r4.f5549e = k.g0.a(r4.f5547c) - r4.f5548d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0203, code lost:
    
        r37 = true;
        r40 = 128;
        r0 = k.g0.b(r4.f5547c);
        r5 = r4.f5545a;
        r6 = r4.f5546b;
        r7 = r4.f5547c;
        r4.c(r0);
        r0 = r4.f5545a;
        r8 = r4.f5546b;
        r9 = r4.f5547c;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x021e, code lost:
    
        if (r12 >= r7) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x022d, code lost:
    
        if (((r5[r12 >> 3] >> ((r12 & 7) << 3)) & 255) >= 128) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x022f, code lost:
    
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
    /* JADX WARN: Code restructure failed: missing block: B:52:0x026d, code lost:
    
        r16 = r0;
        r17 = r5;
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0273, code lost:
    
        r12 = r12 + 1;
        r0 = r16;
        r5 = r17;
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x027c, code lost:
    
        r0 = r4.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0280, code lost:
    
        r14 = r0;
        r4.f5548d++;
        r0 = r4.f5549e;
        r3 = r4.f5545a;
        r5 = r14 >> 3;
        r6 = r3[r5];
        r8 = (r14 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0299, code lost:
    
        if (((r6 >> r8) & 255) != r40) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x029b, code lost:
    
        r21 = r37 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x029d, code lost:
    
        r4.f5549e = r0 - r21;
        r0 = r4.f5547c;
        r6 = (r6 & (~(255 << r8))) | (r10 << r8);
        r3[r5] = r6;
        r3[(((r14 - 7) & r0) + (r0 & 7)) >> 3] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0348, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x034a, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean p(android.view.KeyEvent r41) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.u0.p(android.view.KeyEvent):boolean");
    }

    public u0(d5.l lVar, k5.a aVar, k5.g gVar) {
        q7.k.e(lVar, "pool");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        this.f6341a = lVar;
        this.f6342b = gVar;
        this.f6343c = ia.d0.b(f1.plus(ia.d0.c(), aVar.f5616a));
        this.f6345e = new ConcurrentHashMap();
        this.f6346f = new ConcurrentHashMap();
        this.f6347g = new AtomicLong(0L);
        this.f6348h = new AtomicLong(0L);
    }

    public u0(j1.y yVar, j1.y yVar2) {
        this.f6341a = yVar;
        this.f6342b = yVar2;
        this.f6343c = new s0.q(null, 6);
        this.f6344d = new s0.f(this, yVar2);
        this.f6345e = new i1.w0() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
            @Override // i1.w0
            public final l d() {
                return (q) this.f756a.f6343c;
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            @Override // i1.w0
            public final /* bridge */ /* synthetic */ void f(l lVar) {
            }

            public final int hashCode() {
                return ((q) this.f756a.f6343c).hashCode();
            }
        };
        this.f6347g = new k.z(1);
    }
}
