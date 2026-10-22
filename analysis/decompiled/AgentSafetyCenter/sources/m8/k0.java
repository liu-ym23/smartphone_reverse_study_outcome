package m8;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import androidx.lifecycle.s0;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.k1;
import s8.a3;
import s8.d1;
import s8.f2;
import s8.g1;
import s8.j3;
import s8.m1;
import s8.p3;
import s8.q1;
import s8.t3;
import s8.x0;
import s8.y2;
import s8.z2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends androidx.lifecycle.a {

    /* renamed from: c, reason: collision with root package name */
    public final k1 f8419c;

    /* renamed from: d, reason: collision with root package name */
    public final ZoneId f8420d;

    /* renamed from: e, reason: collision with root package name */
    public final jb.k f8421e;

    /* renamed from: f, reason: collision with root package name */
    public final jb.k f8422f;

    /* renamed from: g, reason: collision with root package name */
    public final jb.k f8423g;

    /* renamed from: h, reason: collision with root package name */
    public final jb.k f8424h;
    public final AtomicBoolean i;

    /* renamed from: j, reason: collision with root package name */
    public volatile long f8425j;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f8426k;

    /* renamed from: l, reason: collision with root package name */
    public volatile long f8427l;

    /* renamed from: m, reason: collision with root package name */
    public volatile long f8428m;

    /* renamed from: n, reason: collision with root package name */
    public Integer f8429n;

    /* renamed from: o, reason: collision with root package name */
    public volatile s8.t f8430o;

    /* renamed from: p, reason: collision with root package name */
    public l0 f8431p;

    /* renamed from: q, reason: collision with root package name */
    public final sc.c f8432q;

    /* renamed from: r, reason: collision with root package name */
    public volatile long f8433r;

    public k0(Application application) {
        application.getClass();
        this.f1355b = application;
        DateTimeFormatter dateTimeFormatter = x0.f12068a;
        ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
        LocalDate localDateNow = LocalDate.now(zoneIdSystemDefault);
        localDateNow.getClass();
        zoneIdSystemDefault.getClass();
        s8.t tVarS = g1.s(q1.a(localDateNow, zoneIdSystemDefault, kb.s.f7404c, "", "", false, 0, null, null, null));
        l0 l0Var = l0.f8440c;
        d1 d1Var = d1.f11539c;
        nb.c cVar = null;
        kb.u uVar = kb.u.f7406c;
        kb.s sVar = kb.s.f7404c;
        this.f8419c = k0.z.v(new a(false, "", null, tVarS, 0, uVar, uVar, false, l0Var, d1Var, -1, null, null, null, sVar, sVar, 0, null, false, null, false, null, null, false, 0, null, sVar, sVar));
        ZoneId zoneIdSystemDefault2 = ZoneId.systemDefault();
        zoneIdSystemDefault2.getClass();
        this.f8420d = zoneIdSystemDefault2;
        e9.j jVar = new e9.j(9);
        jVar.f3666f = application;
        jVar.f3667g = this;
        VarHandle.storeStoreFence();
        this.f8421e = new jb.k(jVar);
        int i = 0;
        b bVar = new b(i);
        bVar.f8303f = application;
        VarHandle.storeStoreFence();
        this.f8422f = new jb.k(bVar);
        b bVar2 = new b(1);
        bVar2.f8303f = application;
        VarHandle.storeStoreFence();
        this.f8423g = new jb.k(bVar2);
        int i3 = 2;
        b bVar3 = new b(i3);
        bVar3.f8303f = application;
        VarHandle.storeStoreFence();
        this.f8424h = new jb.k(bVar3);
        new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        kc.w.u(s0.h(this), null, null, new d(i, this, cVar), 3);
        kc.w.u(s0.h(this), null, null, new d(i3, this, cVar), 3);
        kc.w.u(s0.h(this), null, null, new e(this, null), 3);
        this.f8432q = new sc.c();
    }

    public static void A(String str, int i, t3 t3Var) {
        p3 p3Var = t3Var.f11984a;
        String str2 = p3Var.f11886m;
        String str3 = t3Var.f11985b;
        String str4 = p3Var.f11875a;
        String str5 = p3Var.f11877c;
        z8.g gVar = p3Var.f11882h;
        Boolean bool = p3Var.i;
        List listC = x0.c(p3Var);
        String str6 = p3Var.f11887n;
        String str7 = p3Var.f11888o;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("[");
        sb2.append(i);
        sb2.append("] stepId=");
        sb2.append(str2);
        androidx.activity.b.u(sb2, " task=", str3, " what=", str4);
        sb2.append(" time=");
        sb2.append(str5);
        sb2.append(" undoState=");
        sb2.append(gVar);
        sb2.append(" undoable=");
        sb2.append(bool);
        sb2.append(" paths=");
        sb2.append(listC);
        sb2.append(" sessionId=");
        sb2.append(str6);
        sb2.append(" taskId=");
        sb2.append(str7);
        Log.i("BehaviorAnalysis", sb2.toString());
    }

    public static final s8.t H(Set set, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, Resources resources, k0 k0Var, s8.t tVar) {
        c cVar = new c(0);
        cVar.f8318f = resources;
        cVar.f8319g = k0Var;
        VarHandle.storeStoreFence();
        return g1.g(tVar, set, linkedHashMap, linkedHashMap2, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x035d, code lost:
    
        if (r3 == r9) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[PHI: r0 r1 r2 r3 r4 r6 r7 r10 r12 r14 r15 r18 r19 r20
      0x006e: PHI (r0v25 android.content.res.Resources) = (r0v22 android.content.res.Resources), (r0v37 android.content.res.Resources) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r1v4 m8.k0) = (r1v3 m8.k0), (r1v0 m8.k0) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r2v17 java.util.List) = (r2v15 java.util.List), (r2v34 java.util.List) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r3v14 java.lang.Object) = (r3v13 java.lang.Object), (r3v1 java.lang.Object) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r4v13 long) = (r4v11 long), (r4v14 long) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r6v14 s8.t) = (r6v11 s8.t), (r6v17 s8.t) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r7v10 boolean) = (r7v8 boolean), (r7v11 boolean) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r10v12 long) = (r10v10 long), (r10v13 long) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r12v4 xb.l) = (r12v2 xb.l), (r12v6 xb.l) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r14v9 s8.t) = (r14v7 s8.t), (r14v12 s8.t) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r15v12 java.time.LocalDate) = (r15v9 java.time.LocalDate), (r15v15 java.time.LocalDate) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r18v4 java.lang.String) = (r18v2 java.lang.String), (r18v5 java.lang.String) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r19v5 java.lang.String) = (r19v3 java.lang.String), (r19v6 java.lang.String) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r20v6 jb.v) = (r20v4 jb.v), (r20v7 jb.v) binds: [B:49:0x02ba, B:15:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(m8.k0 r53, java.lang.String r54, android.content.res.Resources r55, xb.l r56, boolean r57, pb.c r58) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.e(m8.k0, java.lang.String, android.content.res.Resources, xb.l, boolean, pb.c):java.lang.Object");
    }

    public static final Object f(k0 k0Var, pb.i iVar) throws Throwable {
        Application application = k0Var.f1355b;
        application.getClass();
        Resources resources = application.getResources();
        LocalDate localDateNow = LocalDate.now(k0Var.f8420d);
        localDateNow.getClass();
        ZoneId zoneId = k0Var.f8420d;
        kb.s sVar = kb.s.f7404c;
        String string = resources.getString(R.string.chart_day_today);
        string.getClass();
        String string2 = resources.getString(R.string.chart_day_yesterday);
        string2.getClass();
        kb.t tVar = kb.t.f7405c;
        List listA = q1.a(localDateNow, zoneId, sVar, string, string2, false, 0, tVar, tVar, tVar);
        k0Var.f8430o = null;
        k0Var.U(a.a(k0Var.v(), false, null, null, g1.s(listA), 0, kb.u.f7406c, null, false, l0.f8440c, null, 0, null, null, null, sVar, sVar, 0, null, false, null, false, null, null, false, 0, null, sVar, sVar, 268305986));
        k0Var.f8428m = 0L;
        k0Var.f8433r = 0L;
        Object objO = k0Var.O(iVar);
        return objO == ob.a.f9351c ? objO : jb.v.f6774a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v11, types: [android.content.res.Resources, java.lang.Object, java.time.LocalDate, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(m8.k0 r54, int r55, pb.c r56) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 705
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.g(m8.k0, int, pb.c):java.lang.Object");
    }

    public static final void h(k0 k0Var, x8.a aVar) {
        if (k0Var.v().f8291x == aVar.f15590a && k0Var.v().f8292y == aVar.f15591b) {
            return;
        }
        k0Var.U(a.a(k0Var.v(), false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, aVar.f15590a, aVar.f15591b, null, null, null, 973078527));
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0255, code lost:
    
        if (r59.O(r5) != r6) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c0 A[PHI: r1 r2 r4 r7 r9 r11 r14
      0x01c0: PHI (r1v22 java.lang.Object) = (r1v16 java.lang.Object), (r1v1 java.lang.Object) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r2v13 long) = (r2v11 long), (r2v17 long) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r4v8 s8.t) = (r4v5 s8.t), (r4v13 s8.t) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r7v9 java.util.List) = (r7v6 java.util.List), (r7v16 java.util.List) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r9v5 long) = (r9v3 long), (r9v6 long) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r11v12 q8.i) = (r11v10 q8.i), (r11v14 q8.i) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]
      0x01c0: PHI (r14v8 long) = (r14v6 long), (r14v12 long) binds: [B:57:0x01bc, B:19:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Type inference failed for: r13v11, types: [android.content.res.Resources, java.lang.Object, java.time.LocalDate] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(m8.k0 r59, pb.c r60) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.i(m8.k0, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(m8.k0 r17, java.util.Set r18, pb.c r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.j(m8.k0, java.util.Set, pb.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0294  */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r21v0, types: [androidx.lifecycle.a, java.lang.Object, m8.k0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0182 -> B:58:0x01b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0245 -> B:70:0x024e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0265 -> B:74:0x0261). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(m8.k0 r21, java.util.List r22, pb.c r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.k(m8.k0, java.util.List, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(m8.k0 r10, pb.c r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof m8.i0
            if (r0 == 0) goto L13
            r0 = r11
            m8.i0 r0 = (m8.i0) r0
            int r1 = r0.f8400g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8400g = r1
            goto L18
        L13:
            m8.i0 r0 = new m8.i0
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f8398c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8400g
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L28
            id.c.I(r11)
            r5 = r10
            goto L58
        L28:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L2f:
            id.c.I(r11)
            q8.t r11 = r10.u()
            java.time.ZoneId r2 = r10.f8420d
            java.time.LocalDate r2 = java.time.LocalDate.now(r2)
            r2.getClass()
            long r6 = r11.j(r2)
            rc.e r11 = kc.e0.f7430a
            rc.d r11 = rc.d.f10552f
            m8.j0 r4 = new m8.j0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.<init>(r5, r6, r8, r9)
            r0.f8400g = r3
            java.lang.Object r11 = kc.w.E(r11, r4, r0)
            if (r11 != r1) goto L58
            return r1
        L58:
            java.lang.Long r11 = (java.lang.Long) r11
            r0 = 0
            if (r11 == 0) goto L63
            long r10 = r11.longValue()
            goto L64
        L63:
            r10 = r0
        L64:
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 <= 0) goto L6a
            r5.f8425j = r10
        L6a:
            jb.v r10 = jb.v.f6774a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.l(m8.k0, pb.c):java.lang.Object");
    }

    public final void B() {
        s8.t tVarB = v().b();
        DateTimeFormatter dateTimeFormatter = x0.f12068a;
        List list = tVarB.f11966d;
        ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((f2) it.next()).f11599a);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (!hc.h.g0((String) obj)) {
                arrayList2.add(obj);
            }
        }
        List list2 = tVarB.f11967e;
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            kb.q.p0(x0.g((j3) it2.next(), tVarB), arrayList3);
        }
        D(kb.l.L0(kb.l.N0(kb.l.F0(arrayList2, arrayList3))));
    }

    public final void C(List list) {
        k8.a aVar;
        List listO;
        list.getClass();
        a aVarV = v();
        s8.t tVar = aVarV.f8280m;
        List list2 = kb.s.f7404c;
        if (tVar == null || (aVar = aVarV.f8281n) == null) {
            listO = list2;
        } else {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            List list3 = tVar.f11967e;
            zoneIdSystemDefault.getClass();
            listO = g1.o(list3, aVar, zoneIdSystemDefault);
        }
        if (!listO.isEmpty()) {
            list2 = listO;
        } else if (!list.isEmpty()) {
            list2 = list;
        }
        ArrayList arrayList = new ArrayList(kb.m.m0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(g1.P((t3) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listL0 = kb.l.L0(kb.l.N0(arrayList2));
        if (!listL0.isEmpty()) {
            U(a.a(v(), false, null, null, null, 0, null, kb.b0.R(v().f8275g, listL0), false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073741759));
            kc.w.u(s0.h(this), null, null, new u(this, listL0, null, 1), 3);
        } else {
            Log.w("BehaviorAnalysis", "markHomeUndoableRowsSeen skipped: no keys clicked=" + list.size());
        }
    }

    public final void D(Collection collection) {
        collection.getClass();
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(kb.m.m0(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            k0.a.A((String) it.next(), arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listL0 = kb.l.L0(kb.l.N0(arrayList2));
        if (listL0.isEmpty()) {
            return;
        }
        kc.w.u(s0.h(this), null, null, new w(listL0, this, null), 3);
    }

    public final void E(String str, List list) {
        int i;
        list.getClass();
        Application application = this.f1355b;
        application.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            i = 0;
            boolean z10 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            p3 p3Var = (p3) next;
            if (x0.t(p3Var)) {
                int iOrdinal = p3Var.f11899z.ordinal();
                z10 = iOrdinal != 0 ? (iOrdinal == 1 || iOrdinal == 2) ? true : g1.z(application, p3Var) : g1.z(application, p3Var);
            }
            if (z10) {
                arrayList.add(next);
            }
        }
        Log.i("BehaviorAnalysis", "[revoke] open batch: incoming=" + list.size() + " eligible=" + arrayList.size());
        if (arrayList.isEmpty()) {
            Log.w("BehaviorAnalysis", "[revoke] open batch aborted: no eligible lines (showsUndoAffordance=false)");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            kb.q.p0(x0.c((p3) obj), arrayList2);
        }
        jb.g gVar = new jb.g("data_type", p5.f.G(arrayList2));
        int size2 = arrayList2.size();
        if (size2 < 0) {
            size2 = 0;
        }
        td.h.P("click_revoke_option", str, kb.w.N(gVar, new jb.g("data_count", String.valueOf(size2))));
        Resources resources = application.getResources();
        ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList, 10));
        int size3 = arrayList.size();
        int i10 = 0;
        while (i10 < size3) {
            Object obj2 = arrayList.get(i10);
            i10++;
            p3 p3Var2 = (p3) obj2;
            resources.getClass();
            arrayList3.add(g1.S(p3Var2, g1.N(p3Var2, resources)));
        }
        int size4 = arrayList3.size();
        while (i < size4) {
            Object obj3 = arrayList3.get(i);
            i++;
            y2 y2Var = (y2) obj3;
            String str2 = y2Var.f12124a;
            String str3 = y2Var.f12125b;
            String str4 = y2Var.f12128e;
            String str5 = y2Var.i;
            String str6 = y2Var.f12133k;
            String str7 = y2Var.f12132j;
            StringBuilder sbP = androidx.activity.b.p("[revoke] batch item: key=", str2, " what=", str3, " recoverPath=");
            androidx.activity.b.u(sbP, str4, " sessionId=", str5, " toolCallId=");
            sbP.append(str6);
            sbP.append(" taskId=");
            sbP.append(str7);
            Log.i("BehaviorAnalysis", sbP.toString());
        }
        a aVarV = v();
        z2 z2Var = arrayList.size() == 1 ? z2.f12165c : z2.f12166f;
        a3 a3Var = new a3();
        a3Var.f11451a = z2Var;
        a3Var.f11452b = arrayList3;
        VarHandle.storeStoreFence();
        U(a.a(aVarV, false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, a3Var, false, null, null, false, 0, null, null, null, 1071120383));
    }

    public final void F(p3 p3Var, String str) {
        p3Var.getClass();
        List listC = x0.c(p3Var);
        jb.g gVar = new jb.g("data_type", p5.f.G(listC));
        int size = listC.size();
        if (size < 0) {
            size = 0;
        }
        td.h.P("click_revoke_option", str, kb.w.N(gVar, new jb.g("data_count", String.valueOf(size))));
        Application application = this.f1355b;
        application.getClass();
        Resources resources = application.getResources();
        resources.getClass();
        y2 y2VarS = g1.S(p3Var, g1.N(p3Var, resources));
        String str2 = y2VarS.f12124a;
        String str3 = y2VarS.f12125b;
        z8.g gVar2 = p3Var.f11882h;
        Boolean bool = p3Var.i;
        String str4 = y2VarS.f12128e;
        String str5 = y2VarS.i;
        String str6 = y2VarS.f12133k;
        String str7 = y2VarS.f12132j;
        StringBuilder sbP = androidx.activity.b.p("[revoke] open single: key=", str2, " what=", str3, " undoState=");
        sbP.append(gVar2);
        sbP.append(" undoable=");
        sbP.append(bool);
        sbP.append(" recoverPath=");
        androidx.activity.b.u(sbP, str4, " sessionId=", str5, " toolCallId=");
        sbP.append(str6);
        sbP.append(" taskId=");
        sbP.append(str7);
        Log.i("BehaviorAnalysis", sbP.toString());
        a aVarV = v();
        z2 z2Var = z2.f12165c;
        List listE = ac.a.E(y2VarS);
        a3 a3Var = new a3();
        a3Var.f11451a = z2Var;
        a3Var.f11452b = listE;
        VarHandle.storeStoreFence();
        U(a.a(aVarV, false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, a3Var, false, null, null, false, 0, null, null, null, 1071120383));
    }

    public final Object G(String str, Resources resources, pb.c cVar) {
        rc.e eVar = kc.e0.f7430a;
        return kc.w.E(rc.d.f10552f, new androidx.lifecycle.i0(this, str, resources, null, 3), cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00de, code lost:
    
        if (kc.w.E(r10, r0, r7) != r8) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.content.res.Resources, java.lang.String, nb.c] */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.content.res.Resources, java.lang.String, s8.t] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(java.time.LocalDate r17, java.lang.String r18, android.content.res.Resources r19, pb.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.I(java.time.LocalDate, java.lang.String, android.content.res.Resources, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(boolean r54, pb.c r55) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.J(boolean, pb.c):java.lang.Object");
    }

    public final void K(k8.a aVar) {
        aVar.getClass();
        kc.w.u(s0.h(this), null, null, new androidx.lifecycle.h0(this, aVar, (nb.c) null, 16), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(k8.a r40, pb.c r41) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.L(k8.a, pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if ((r1 - r36.f8425j) >= 30000) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(java.lang.String r37, boolean r38) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.M(java.lang.String, boolean):void");
    }

    public final void N() {
        d1 d1Var = v().f8277j;
        if (d1Var != d1.f11539c) {
            kc.w.u(s0.h(this), null, null, new androidx.lifecycle.i0(this, d1Var, null, 4), 3);
        } else if (v().f8279l != null) {
            U(a.a(v(), false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073674239));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(pb.c r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.O(pb.c):java.lang.Object");
    }

    public final void P() {
        kc.w.u(s0.h(this), null, null, new androidx.lifecycle.l0(this, (nb.c) null, 14), 3);
    }

    public final void Q(String str, boolean z10) {
        Application application = this.f1355b;
        application.getClass();
        if (hc.h.g0(hc.h.x0(hc.h.w0(t1.e.p(application)).toString(), JsonPointer.SEPARATOR))) {
            return;
        }
        q8.t tVarU = u();
        LocalDate localDateNow = LocalDate.now(this.f8420d);
        localDateNow.getClass();
        long j10 = tVarU.j(localDateNow);
        if (this.f8428m == 0 || this.f8428m == j10) {
            kc.w.u(s0.h(this), null, null, new g0(this, z10, str, (nb.c) null), 3);
        }
    }

    public final j3 R(j3 j3Var) {
        j3Var.getClass();
        ArrayList arrayListP0 = kb.k.p0(new s8.t[]{v().f8285r, v().f8280m, v().f8279l, v().f8272d});
        int size = arrayListP0.size();
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            Object obj = arrayListP0.get(i3);
            i3++;
            j3 j3VarD = x0.d(((s8.t) obj).f11967e, j3Var);
            if (j3VarD != null) {
                List list = j3VarD.f11702e;
                List<p3> list2 = j3Var.f11702e;
                ArrayList arrayList = new ArrayList(kb.m.m0(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(x0.k((p3) it.next()));
                }
                ArrayList arrayList2 = new ArrayList(kb.m.m0(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(x0.k((p3) it2.next()));
                }
                Set setO0 = kb.l.O0(arrayList2);
                if (kb.l.O0(arrayList).equals(setO0)) {
                    return j3VarD;
                }
                if (!arrayList.isEmpty()) {
                    if (!arrayList.isEmpty()) {
                        int size2 = arrayList.size();
                        while (i < size2) {
                            Object obj2 = arrayList.get(i);
                            i++;
                            if (!setO0.contains((String) obj2)) {
                            }
                        }
                    }
                    int iL = kb.x.L(kb.m.m0(list, 10));
                    if (iL < 16) {
                        iL = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
                    for (Object obj3 : list) {
                        linkedHashMap.put(x0.k((p3) obj3), obj3);
                    }
                    ArrayList arrayList3 = new ArrayList(kb.m.m0(list2, 10));
                    for (p3 p3Var : list2) {
                        p3 p3Var2 = (p3) linkedHashMap.get(x0.k(p3Var));
                        if (p3Var2 != null) {
                            p3Var = p3Var2;
                        }
                        arrayList3.add(p3Var);
                    }
                    List<p3> list3 = j3Var.f11699b;
                    ArrayList arrayList4 = new ArrayList(kb.m.m0(list3, 10));
                    for (p3 p3Var3 : list3) {
                        p3 p3Var4 = (p3) linkedHashMap.get(x0.k(p3Var3));
                        if (p3Var4 != null) {
                            p3Var3 = p3Var4;
                        }
                        arrayList4.add(p3Var3);
                    }
                    return j3.a(j3Var, arrayList4, 0, 0, arrayList3, null, 1005);
                }
            }
        }
        return j3Var;
    }

    public final jb.l S() {
        r2.i iVar = t8.c.f13223h;
        Application application = this.f1355b;
        application.getClass();
        t8.c cVarL = iVar.l(application);
        return new jb.l(kb.b0.R(cVarL.g().keySet(), cVarL.h()), cVarL.g(), cVarL.f());
    }

    public final void T() {
        kc.w.u(s0.h(this), null, null, new androidx.lifecycle.h0(this, (nb.c) null, 19), 3);
    }

    public final void U(a aVar) {
        this.f8419c.setValue(aVar);
    }

    public final List V(Set set) {
        s8.t tVar = this.f8430o;
        if (tVar == null) {
            return kb.s.f7404c;
        }
        q8.t tVarU = u();
        LocalDate localDateNow = LocalDate.now(this.f8420d);
        localDateNow.getClass();
        long j10 = tVarU.j(localDateNow);
        set.getClass();
        return g1.U(tVar, set, j10, false);
    }

    public final List W(Set set) {
        s8.t tVar = this.f8430o;
        if (tVar == null) {
            return kb.s.f7404c;
        }
        q8.t tVarU = u();
        LocalDate localDateNow = LocalDate.now(this.f8420d);
        localDateNow.getClass();
        long j10 = tVarU.j(localDateNow);
        set.getClass();
        return g1.U(tVar, set, j10, true);
    }

    public final void X(m1 m1Var) {
        Map mapSingletonMap = Collections.singletonMap("selected_date", Instant.ofEpochMilli(m1Var.f11795d).atZone(this.f8420d).toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        mapSingletonMap.getClass();
        Map mapN = kb.w.N(new jb.g("action_count", String.valueOf(m1Var.f11796e)), new jb.g("intercepted_count", String.valueOf(m1Var.f11797f)), new jb.g("revocable_count", String.valueOf(m1Var.f11798g)));
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapSingletonMap);
        linkedHashMap.putAll(mapN);
        td.h.P("click_switch_date", "security_center", linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(nb.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof m8.j
            if (r0 == 0) goto L13
            r0 = r6
            m8.j r0 = (m8.j) r0
            int r1 = r0.f8405j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8405j = r1
            goto L18
        L13:
            m8.j r0 = new m8.j
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f8404h
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8405j
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            java.time.LocalDate r5 = r0.f8403g
            java.time.ZoneId r1 = r0.f8402f
            s8.d1 r0 = r0.f8401c
            id.c.I(r6)
            goto L55
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L34:
            id.c.I(r6)
            java.time.ZoneId r6 = r5.f8420d
            java.time.LocalDate r2 = java.time.LocalDate.now(r6)
            s8.d1 r4 = s8.d1.f11542h
            r2.getClass()
            r0.f8401c = r4
            r0.f8402f = r6
            r0.f8403g = r2
            r0.f8405j = r3
            java.lang.Object r5 = r5.s(r0)
            if (r5 != r1) goto L51
            return r1
        L51:
            r1 = r6
            r0 = r4
            r6 = r5
            r5 = r2
        L55:
            java.time.LocalDate r6 = (java.time.LocalDate) r6
            k8.a r5 = s8.g1.h(r0, r1, r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.m(nb.c):java.lang.Object");
    }

    public final Object n(List list, Resources resources, pb.c cVar) {
        rc.e eVar = kc.e0.f7430a;
        return kc.w.E(rc.d.f10552f, new k(list, this, resources, null), cVar);
    }

    public final void o() {
        U(a.a(v(), false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073348607));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(long r15, long r17, q8.i r19, android.content.res.Resources r20, pb.c r21) {
        /*
            r14 = this;
            r0 = r15
            r2 = r19
            r3 = r21
            kb.s r4 = kb.s.f7404c
            boolean r5 = r3 instanceof m8.n
            if (r5 == 0) goto L1a
            r5 = r3
            m8.n r5 = (m8.n) r5
            int r6 = r5.f8466h
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L1a
            int r6 = r6 - r7
            r5.f8466h = r6
            goto L1f
        L1a:
            m8.n r5 = new m8.n
            r5.<init>(r14, r3)
        L1f:
            java.lang.Object r3 = r5.f8464f
            ob.a r6 = ob.a.f9351c
            int r7 = r5.f8466h
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L38
            if (r7 != r8) goto L31
            long r0 = r5.f8463c
            id.c.I(r3)
            goto L94
        L31:
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r14)
            r14 = 0
            return r14
        L38:
            id.c.I(r3)
            long r10 = r14.f8428m
            r12 = 0
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 == 0) goto L4c
            long r10 = r14.f8428m
            int r3 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r3 != 0) goto L4a
            goto L4c
        L4a:
            r3 = 0
            goto L4d
        L4c:
            r3 = r8
        L4d:
            int r7 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r7 != 0) goto L6c
            if (r3 == 0) goto L6c
            m8.a r3 = r14.v()
            s8.t r3 = r3.f8272d
            java.util.List r3 = r3.f11967e
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L6c
            m8.a r14 = r14.v()
            s8.t r14 = r14.f8272d
            s8.t r14 = s8.g1.u(r14, r0, r4)
            return r14
        L6c:
            if (r2 == 0) goto L83
            java.lang.String r2 = r2.f10122b
            if (r2 == 0) goto L83
            boolean r3 = hc.h.g0(r2)
            if (r3 != 0) goto L80
            java.lang.String r3 = "{}"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L81
        L80:
            r2 = r9
        L81:
            if (r2 != 0) goto L84
        L83:
            r2 = r9
        L84:
            if (r2 != 0) goto L87
            goto L98
        L87:
            r5.f8463c = r0
            r5.f8466h = r8
            r3 = r20
            java.lang.Object r3 = r14.G(r2, r3, r5)
            if (r3 != r6) goto L94
            return r6
        L94:
            s8.t r3 = (s8.t) r3
            if (r3 != 0) goto L99
        L98:
            return r9
        L99:
            s8.t r14 = s8.g1.u(r3, r0, r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.p(long, long, q8.i, android.content.res.Resources, pb.c):java.lang.Object");
    }

    public final void q() {
        if (v().f8288u) {
            return;
        }
        U(a.a(v(), false, null, null, null, 0, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1071120383));
    }

    public final void r() {
        Integer num = this.f8429n;
        if (num == null) {
            return;
        }
        this.f8429n = null;
        m1 m1Var = (m1) kb.l.y0(num.intValue(), v().f8272d.f11965c);
        if (m1Var == null) {
            return;
        }
        X(m1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(pb.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof m8.o
            if (r0 == 0) goto L13
            r0 = r5
            m8.o r0 = (m8.o) r0
            int r1 = r0.f8469g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8469g = r1
            goto L18
        L13:
            m8.o r0 = new m8.o
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8467c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8469g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r5)
            goto L3e
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r5)
            q8.t r5 = r4.u()
            r0.f8469g = r3
            java.lang.Object r5 = r5.g(r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            java.lang.Long r5 = (java.lang.Long) r5
            if (r5 == 0) goto L55
            long r0 = r5.longValue()
            java.time.Instant r5 = java.time.Instant.ofEpochMilli(r0)
            java.time.ZoneId r4 = r4.f8420d
            java.time.ZonedDateTime r4 = r5.atZone(r4)
            java.time.LocalDate r4 = r4.toLocalDate()
            return r4
        L55:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.s(pb.c):java.lang.Object");
    }

    public final Object t(long j10, long j11, pb.c cVar) {
        rc.e eVar = kc.e0.f7430a;
        return kc.w.E(rc.d.f10552f, new p(this, j10, j11, null), cVar);
    }

    public final q8.t u() {
        return (q8.t) this.f8421e.getValue();
    }

    public final a v() {
        return (a) this.f8419c.getValue();
    }

    public final Object w(s8.t tVar, pb.c cVar) {
        rc.e eVar = kc.e0.f7430a;
        return kc.w.E(rc.d.f10552f, new androidx.lifecycle.h0(this, tVar, (nb.c) null, 15), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(nb.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof m8.q
            if (r0 == 0) goto L13
            r0 = r5
            m8.q r0 = (m8.q) r0
            int r1 = r0.f8476g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8476g = r1
            goto L18
        L13:
            m8.q r0 = new m8.q
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8474c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8476g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r5)
            goto L3b
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r5)
            r0.f8476g = r3
            r5 = 0
            java.lang.Object r5 = r4.J(r5, r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            m8.a r4 = r4.v()
            java.util.List r4 = r4.f8282o
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.x(nb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x012e, code lost:
    
        if (r1 == r8) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r19v0, types: [androidx.lifecycle.a, m8.k0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x012e -> B:38:0x0131). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(k8.a r20, pb.c r21) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.y(k8.a, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(nb.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof m8.t
            if (r0 == 0) goto L13
            r0 = r5
            m8.t r0 = (m8.t) r0
            int r1 = r0.f8500g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8500g = r1
            goto L18
        L13:
            m8.t r0 = new m8.t
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f8498c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8500g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r5)
            goto L3b
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r4)
            r4 = 0
            return r4
        L2e:
            id.c.I(r5)
            r0.f8500g = r3
            r5 = 0
            java.lang.Object r5 = r4.J(r5, r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            m8.a r4 = r4.v()
            java.util.List r4 = r4.f8283p
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k0.z(nb.c):java.lang.Object");
    }
}
