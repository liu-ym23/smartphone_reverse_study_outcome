package o4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class t2 {

    /* renamed from: m, reason: collision with root package name */
    public static final CopyOnWriteArrayList f7599m = new CopyOnWriteArrayList();

    /* renamed from: n, reason: collision with root package name */
    public static volatile v4.h f7600n;

    /* renamed from: o, reason: collision with root package name */
    public static volatile z2 f7601o;

    /* renamed from: a, reason: collision with root package name */
    public final u f7602a;

    /* renamed from: b, reason: collision with root package name */
    public final t1 f7603b;

    /* renamed from: c, reason: collision with root package name */
    public final ia.b0 f7604c;

    /* renamed from: d, reason: collision with root package name */
    public final k5.t f7605d;

    /* renamed from: e, reason: collision with root package name */
    public final ia.j1 f7606e;

    /* renamed from: f, reason: collision with root package name */
    public final z2 f7607f;

    /* renamed from: g, reason: collision with root package name */
    public final String f7608g;

    /* renamed from: h, reason: collision with root package name */
    public final p7.a f7609h;

    /* renamed from: i, reason: collision with root package name */
    public final p7.a f7610i;

    /* renamed from: j, reason: collision with root package name */
    public ia.w1 f7611j;

    /* renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap f7612k;

    /* renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap f7613l;

    public t2(u uVar, t1 t1Var, ia.b0 b0Var, k5.t tVar, ia.j1 j1Var, z2 z2Var, String str) {
        b0.d0 d0Var = new b0.d0(11);
        e0 e0Var = new e0(t1Var, 1);
        q7.k.e(uVar, "adapter");
        q7.k.e(t1Var, "client");
        q7.k.e(b0Var, "scope");
        q7.k.e(tVar, "logger");
        q7.k.e(str, "connectionId");
        this.f7602a = uVar;
        this.f7603b = t1Var;
        this.f7604c = b0Var;
        this.f7605d = tVar;
        this.f7606e = j1Var;
        this.f7607f = z2Var;
        this.f7608g = str;
        this.f7609h = d0Var;
        this.f7610i = e0Var;
        this.f7612k = new ConcurrentHashMap();
        this.f7613l = new ConcurrentHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(o4.t2 r20, java.lang.String r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.a(o4.t2, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01bf, code lost:
    
        if (r2.s(r4, r1) == r3) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af A[Catch: Exception -> 0x0199, TryCatch #0 {Exception -> 0x0199, blocks: (B:37:0x00af, B:40:0x00b9, B:43:0x00c9, B:73:0x019c, B:76:0x01a5, B:78:0x01ad, B:35:0x00a4), top: B:88:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f7 A[Catch: Exception -> 0x0101, TryCatch #4 {Exception -> 0x0101, blocks: (B:68:0x018a, B:47:0x00ea, B:49:0x00f7, B:53:0x0104, B:55:0x010c, B:58:0x0153, B:60:0x0159, B:62:0x015f, B:69:0x0193, B:70:0x0198), top: B:95:0x018a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0104 A[Catch: Exception -> 0x0101, TryCatch #4 {Exception -> 0x0101, blocks: (B:68:0x018a, B:47:0x00ea, B:49:0x00f7, B:53:0x0104, B:55:0x010c, B:58:0x0153, B:60:0x0159, B:62:0x015f, B:69:0x0193, B:70:0x0198), top: B:95:0x018a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019c A[Catch: Exception -> 0x0199, TRY_ENTER, TryCatch #0 {Exception -> 0x0199, blocks: (B:37:0x00af, B:40:0x00b9, B:43:0x00c9, B:73:0x019c, B:76:0x01a5, B:78:0x01ad, B:35:0x00a4), top: B:88:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [o4.t2] */
    /* JADX WARN: Type inference failed for: r3v0, types: [h7.a, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x017a -> B:66:0x0181). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0189 -> B:95:0x018a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(o4.t2 r24, o4.a2 r25, i7.c r26) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.b(o4.t2, o4.a2, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba A[Catch: Exception -> 0x0058, TRY_ENTER, TryCatch #0 {Exception -> 0x0058, blocks: (B:31:0x00a8, B:34:0x00ba, B:36:0x00cb, B:38:0x00d7, B:39:0x00db, B:41:0x00eb, B:43:0x00f1, B:44:0x013c, B:46:0x0144, B:47:0x017f, B:49:0x0187, B:50:0x01df, B:51:0x01e4, B:16:0x0054), top: B:69:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013c A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:31:0x00a8, B:34:0x00ba, B:36:0x00cb, B:38:0x00d7, B:39:0x00db, B:41:0x00eb, B:43:0x00f1, B:44:0x013c, B:46:0x0144, B:47:0x017f, B:49:0x0187, B:50:0x01df, B:51:0x01e4, B:16:0x0054), top: B:69:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x023b -> B:59:0x023e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0245 -> B:59:0x023e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(o4.t2 r23, o4.g r24, i7.c r25) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.c(o4.t2, o4.g, i7.c):java.lang.Object");
    }

    public static String i(String str) {
        return a1.a.w("history-fail:", str);
    }

    public static String m(String str) {
        return a1.a.w("pending:", str);
    }

    public final void d(int i2, String str) {
        String strW = a1.a.w("deferred:", str);
        ia.w1 w1VarS = ia.d0.s(this.f7604c, null, null, new h2(this, i2, 30, str, strW, null), 3);
        ConcurrentHashMap concurrentHashMap = this.f7612k;
        if (i2 != 0) {
            concurrentHashMap.put(strW, w1VarS);
        } else if (((ia.g1) concurrentHashMap.putIfAbsent(strW, w1VarS)) != null) {
            ia.f1.cancel$default((ia.g1) w1VarS, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f3, code lost:
    
        if (ia.d0.g(4000, r1) == r3) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f3 -> B:13:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r20, o4.a2 r21, i7.c r22) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.e(java.lang.String, o4.a2, i7.c):java.lang.Object");
    }

    public final void f(String str, String str2, String str3) {
        c5.b bVarF = this.f7602a.F(str, str2, str3);
        if (bVarF == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = b2.f7283a;
        b2.d(str);
        ia.g1 g1Var = (ia.g1) this.f7613l.remove(str);
        if (g1Var != null) {
            ia.f1.cancel$default(g1Var, (CancellationException) null, 1, (Object) null);
        }
        ia.g1 g1Var2 = (ia.g1) this.f7612k.remove(m(str));
        if (g1Var2 != null) {
            ia.f1.cancel$default(g1Var2, (CancellationException) null, 1, (Object) null);
        }
        this.f7606e.invoke(bVarF);
        k5.s.info$default(this.f7605d, "OpenClawStreamRecovery", "pending outbound history recovery completed frameId=" + ga.k.L0(16, str) + " recovered=" + str3.length(), null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r21, java.lang.String r22, i7.c r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.g(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r5, java.lang.String r6, i7.c r7) throws org.json.JSONException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof o4.k2
            if (r0 == 0) goto L13
            r0 = r7
            o4.k2 r0 = (o4.k2) r0
            int r1 = r0.f7432j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7432j = r1
            goto L18
        L13:
            o4.k2 r0 = new o4.k2
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f7430h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f7432j
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.String r5 = r0.f7429g
            o4.t2 r4 = r0.f7428f
            w7.e0.N(r7)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            w7.e0.N(r7)
            r0.f7428f = r4
            r0.f7429g = r5
            r0.f7432j = r3
            java.lang.Object r7 = r4.o(r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.lang.String r7 = (java.lang.String) r7
            o4.u r4 = r4.f7602a
            r4.getClass()
            java.lang.String r6 = "frameId"
            q7.k.e(r5, r6)
            java.lang.String r6 = "historyPayloadJson"
            q7.k.e(r7, r6)
            java.util.Map r4 = r4.f7627n
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L5f
            goto L98
        L5f:
            java.util.List r5 = o4.u.D(r7)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L6a
            goto L98
        L6a:
            int r6 = r5.size()
            java.util.ListIterator r6 = r5.listIterator(r6)
        L72:
            boolean r7 = r6.hasPrevious()
            if (r7 == 0) goto L95
            java.lang.Object r7 = r6.previous()
            o4.i r7 = (o4.i) r7
            java.lang.String r0 = r7.f7387a
            java.lang.String r1 = "user"
            boolean r0 = q7.k.a(r0, r1)
            if (r0 == 0) goto L72
            java.lang.String r7 = r7.f7388b
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L72
            int r4 = r6.nextIndex()
            goto L96
        L95:
            r4 = -1
        L96:
            if (r4 >= 0) goto L9b
        L98:
            o4.o r4 = o4.o.f7482a
            return r4
        L9b:
            int r4 = r4 + r3
            java.util.List r4 = d7.r.K0(r5, r4)
            int r5 = r4.size()
            java.util.ListIterator r4 = r4.listIterator(r5)
        La8:
            boolean r5 = r4.hasPrevious()
            if (r5 == 0) goto Lc0
            java.lang.Object r5 = r4.previous()
            r6 = r5
            o4.i r6 = (o4.i) r6
            java.lang.String r6 = r6.f7387a
            java.lang.String r7 = "assistant"
            boolean r6 = q7.k.a(r6, r7)
            if (r6 == 0) goto La8
            goto Lc1
        Lc0:
            r5 = 0
        Lc1:
            o4.i r5 = (o4.i) r5
            if (r5 == 0) goto Lcd
            o4.m r4 = new o4.m
            java.lang.String r5 = r5.f7388b
            r4.<init>(r5)
            return r4
        Lcd:
            o4.n r4 = o4.n.f7463a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.h(java.lang.String, java.lang.String, i7.c):java.lang.Object");
    }

    public final boolean j() {
        return !this.f7603b.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bb A[LOOP:1: B:76:0x01b5->B:78:0x01bb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(g7.d r22) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.k(g7.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object, o4.a2] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(c5.b r15, boolean r16) {
        /*
            r14 = this;
            r0 = r16
            java.lang.String r1 = "frame"
            r5 = r15
            q7.k.e(r15, r1)
            java.lang.String r1 = r15.b()
            if (r1 != 0) goto L10
            goto L93
        L10:
            r10 = 0
            r11 = 1
            java.lang.String r2 = "agent:main:main"
            java.lang.String r3 = "sessionId"
            r12 = 0
            if (r0 == 0) goto L62
            java.util.concurrent.ConcurrentHashMap r4 = o4.b2.f7283a
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = r15.b()
            if (r4 == 0) goto L5e
            int r6 = r4.length()
            if (r6 <= 0) goto L2c
            goto L2d
        L2c:
            r4 = r12
        L2d:
            if (r4 != 0) goto L30
            goto L5e
        L30:
            java.util.Map r6 = r15.g()
            if (r6 == 0) goto L3b
            java.lang.Object r3 = r6.get(r3)
            goto L3c
        L3b:
            r3 = r12
        L3c:
            boolean r6 = r3 instanceof java.lang.String
            if (r6 == 0) goto L43
            java.lang.String r3 = (java.lang.String) r3
            goto L44
        L43:
            r3 = r12
        L44:
            if (r3 != 0) goto L47
            goto L48
        L47:
            r2 = r3
        L48:
            o4.a2 r3 = new o4.a2
            r9 = 16
            java.lang.String r6 = r14.f7608g
            r13 = r4
            r4 = r2
            r2 = r3
            r3 = r13
            r2.<init>(r3, r4, r5, r6, r7, r9)
            java.util.concurrent.ConcurrentHashMap r4 = o4.b2.f7283a
            java.lang.Object r3 = r4.putIfAbsent(r3, r2)
            if (r3 != 0) goto L5e
            r12 = r2
        L5e:
            if (r12 == 0) goto L80
        L60:
            r10 = r11
            goto L80
        L62:
            java.util.Map r4 = r15.g()
            if (r4 == 0) goto L6d
            java.lang.Object r3 = r4.get(r3)
            goto L6e
        L6d:
            r3 = r12
        L6e:
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L75
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12
        L75:
            if (r12 != 0) goto L78
            goto L79
        L78:
            r2 = r12
        L79:
            o4.a2 r2 = o4.b2.c(r1, r2)
            if (r2 == 0) goto L80
            goto L60
        L80:
            o4.t1 r2 = r14.f7603b
            r2.h()
            if (r10 != 0) goto L94
            java.util.concurrent.ConcurrentHashMap r3 = r14.f7612k
            java.lang.String r4 = m(r1)
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L94
        L93:
            return
        L94:
            r3 = 16
            java.lang.String r3 = ga.k.L0(r3, r1)
            o4.f1 r2 = r2.f7596x
            la.u0 r2 = r2.f7345b
            java.lang.Object r2 = r2.getValue()
            java.lang.String r4 = " conn="
            java.lang.String r5 = " replayable="
            java.lang.String r6 = "pending outbound chat.send frameId="
            java.lang.String r7 = r14.f7608g
            java.lang.StringBuilder r3 = a1.a.p(r6, r3, r4, r7, r5)
            r3.append(r0)
            java.lang.String r0 = " operator="
            r3.append(r0)
            r3.append(r2)
            java.lang.String r6 = r3.toString()
            r8 = 4
            r9 = 0
            k5.t r4 = r14.f7605d
            java.lang.String r5 = "OpenClawStreamRecovery"
            r7 = 0
            k5.s.info$default(r4, r5, r6, r7, r8, r9)
            r14.r(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.l(c5.b, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e2 -> B:62:0x00e6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(i7.c r17) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.n(i7.c):java.lang.Object");
    }

    public final Object o(String str, i7.c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sessionKey", str);
        String string = jSONObject.toString();
        q7.k.d(string, "toString(...)");
        return this.f7603b.i("chat.history", string, 15000L, cVar);
    }

    public final void p() {
        g7.d dVar;
        ia.g1 g1Var;
        ArrayList arrayListY = this.f7602a.y();
        ArrayList arrayList = new ArrayList(d7.t.A0(arrayListY, 10));
        Iterator it = arrayListY.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) it.next()).f7369a);
        }
        Set setQ1 = d7.r.q1(arrayList);
        ConcurrentHashMap concurrentHashMap = this.f7612k;
        Set setKeySet = concurrentHashMap.keySet();
        q7.k.d(setKeySet, "<get-keys>(...)");
        Iterator it2 = d7.r.m1(setKeySet).iterator();
        while (true) {
            dVar = null;
            if (!it2.hasNext()) {
                break;
            }
            String str = (String) it2.next();
            q7.k.b(str);
            if (!ga.r.g0(str, "pending:", false) && !ga.r.g0(str, "deferred:", false) && !setQ1.contains(str) && (g1Var = (ia.g1) concurrentHashMap.remove(str)) != null) {
                ia.f1.cancel$default(g1Var, (CancellationException) null, 1, (Object) null);
            }
        }
        Iterator it3 = arrayListY.iterator();
        while (it3.hasNext()) {
            g gVar = (g) it3.next();
            ia.g1 g1Var2 = (ia.g1) concurrentHashMap.get(gVar.f7369a);
            if (g1Var2 != null) {
                ia.f1.cancel$default(g1Var2, (CancellationException) null, 1, (Object) null);
            }
            concurrentHashMap.put(gVar.f7369a, ia.d0.s(this.f7604c, null, null, new a5.b(this, gVar, dVar, 25), 3));
        }
    }

    public final void q(String str) {
        String strM = m(str);
        ConcurrentHashMap concurrentHashMap = this.f7612k;
        ia.g1 g1Var = (ia.g1) concurrentHashMap.get(strM);
        g7.d dVar = null;
        if (g1Var != null) {
            ia.f1.cancel$default(g1Var, (CancellationException) null, 1, (Object) null);
        }
        concurrentHashMap.put(strM, ia.d0.s(this.f7604c, null, null, new a5.b(this, str, dVar, 26), 3));
    }

    public final void r(String str) {
        q7.k.e(str, "frameId");
        String strM = m(str);
        ConcurrentHashMap concurrentHashMap = this.f7612k;
        if (concurrentHashMap.containsKey(strM)) {
            return;
        }
        concurrentHashMap.put(strM, ia.d0.s(this.f7604c, null, null, new p2(str, this, strM, (g7.d) null), 3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cb, code lost:
    
        if (r6.invoke(r0, r4) == r5) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(o4.a2 r20, i7.c r21) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t2.s(o4.a2, i7.c):java.lang.Object");
    }
}
