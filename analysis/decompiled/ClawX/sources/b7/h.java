package b7;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import n6.a0;
import n6.b0;
import n6.r;
import n6.s;
import n6.u;
import r6.o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements a0, j {

    /* renamed from: x, reason: collision with root package name */
    public static final List f947x = a.a.S(r.d);

    /* renamed from: a, reason: collision with root package name */
    public final b0 f948a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f949b;

    /* renamed from: c, reason: collision with root package name */
    public final long f950c;
    public i d;

    /* renamed from: e, reason: collision with root package name */
    public final long f951e;

    /* renamed from: f, reason: collision with root package name */
    public final long f952f;

    /* renamed from: g, reason: collision with root package name */
    public final String f953g;

    /* renamed from: h, reason: collision with root package name */
    public o f954h;

    /* renamed from: i, reason: collision with root package name */
    public g f955i;

    /* renamed from: j, reason: collision with root package name */
    public k f956j;

    /* renamed from: k, reason: collision with root package name */
    public l f957k;

    /* renamed from: l, reason: collision with root package name */
    public final q6.c f958l;

    /* renamed from: m, reason: collision with root package name */
    public String f959m;

    /* renamed from: n, reason: collision with root package name */
    public a4.d f960n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayDeque f961o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayDeque f962p;

    /* renamed from: q, reason: collision with root package name */
    public long f963q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f964r;

    /* renamed from: s, reason: collision with root package name */
    public int f965s;

    /* renamed from: t, reason: collision with root package name */
    public String f966t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f967u;

    /* renamed from: v, reason: collision with root package name */
    public int f968v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f969w;

    public h(q6.d taskRunner, s sVar, b0 b0Var, Random random, long j4, long j8, long j9) {
        p.e(taskRunner, "taskRunner");
        this.f948a = b0Var;
        this.f949b = random;
        this.f950c = j4;
        this.d = null;
        this.f951e = j8;
        this.f952f = j9;
        this.f958l = taskRunner.d();
        this.f961o = new ArrayDeque();
        this.f962p = new ArrayDeque();
        this.f965s = -1;
        String str = sVar.f4129b;
        if (!"GET".equals(str)) {
            throw new IllegalArgumentException(m0.f.c("Request must be GET: ", str).toString());
        }
        c7.i iVar = c7.i.d;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f953g = t1.f.j(bArr).a();
    }

    public static void c(h hVar, Exception exc, u uVar, int i8) {
        l lVar;
        if ((i8 & 2) != 0) {
            uVar = null;
        }
        boolean z = (i8 & 4) == 0;
        hVar.getClass();
        y yVar = new y();
        synchronized (hVar) {
            try {
                if (hVar.f967u) {
                    return;
                }
                hVar.f967u = true;
                a4.d dVar = hVar.f960n;
                l lVar2 = hVar.f957k;
                yVar.f3686a = lVar2;
                hVar.f957k = null;
                if (!z && lVar2 != null) {
                    q6.c.b(hVar.f958l, hVar.f959m + " writer close", 0L, new c(1, yVar), 2);
                }
                hVar.f958l.e();
                try {
                    hVar.f948a.onFailure(hVar, exc, uVar);
                    if (dVar != null) {
                        dVar.cancel();
                    }
                    if (!z || (lVar = (l) yVar.f3686a) == null) {
                        return;
                    }
                    o6.d.a(lVar);
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final c7.u a(u uVar) {
        n6.k kVar = uVar.f4150f;
        int i8 = uVar.d;
        if (i8 != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + i8 + ' ' + uVar.f4148c + '\'');
        }
        String strF = kVar.f("Connection");
        if (strF == null) {
            strF = null;
        }
        if (!"Upgrade".equalsIgnoreCase(strF)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strF + '\'');
        }
        String strF2 = kVar.f("Upgrade");
        if (strF2 == null) {
            strF2 = null;
        }
        if (!"websocket".equalsIgnoreCase(strF2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strF2 + '\'');
        }
        String strF3 = kVar.f("Sec-WebSocket-Accept");
        String str = strF3 != null ? strF3 : null;
        c7.i iVar = c7.i.d;
        String strA = t1.f.f(this.f953g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").b("SHA-1").a();
        if (p.a(strA, str)) {
            c7.u uVar2 = uVar.f4152h;
            if (uVar2 != null) {
                return uVar2;
            }
            throw new ProtocolException("Web Socket socket missing: bad interceptor?");
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + str + '\'');
    }

    public final boolean b(int i8, String str) {
        String str2;
        long j4 = this.f952f;
        synchronized (this) {
            c7.i iVarF = null;
            try {
                if (i8 < 1000 || i8 >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i8;
                } else if ((1004 > i8 || i8 >= 1007) && (1015 > i8 || i8 >= 3000)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i8 + " is reserved and may not be used.";
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    c7.i iVar = c7.i.d;
                    iVarF = t1.f.f(str);
                    if (iVarF.f1165a.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                }
                if (!this.f967u && !this.f964r) {
                    this.f964r = true;
                    this.f962p.add(new e(i8, iVarF, j4));
                    e();
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r11 = this;
            monitor-enter(r11)
            int r0 = r11.f965s     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r11.f966t     // Catch: java.lang.Throwable -> L3e
            b7.k r2 = r11.f956j     // Catch: java.lang.Throwable -> L3e
            r3 = 0
            r11.f956j = r3     // Catch: java.lang.Throwable -> L3e
            boolean r4 = r11.f964r     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L45
            java.util.ArrayDeque r4 = r11.f962p     // Catch: java.lang.Throwable -> L3e
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L45
            b7.l r4 = r11.f957k     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L40
            r11.f957k = r3     // Catch: java.lang.Throwable -> L3e
            q6.c r5 = r11.f958l     // Catch: java.lang.Throwable -> L3e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r3.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = r11.f959m     // Catch: java.lang.Throwable -> L3e
            r3.append(r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = " writer close"
            r3.append(r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L3e
            b7.c r9 = new b7.c     // Catch: java.lang.Throwable -> L3e
            r3 = 0
            r9.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3e
            r10 = 2
            r7 = 0
            q6.c.b(r5, r6, r7, r9, r10)     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r0 = move-exception
            goto L66
        L40:
            q6.c r3 = r11.f958l     // Catch: java.lang.Throwable -> L3e
            r3.e()     // Catch: java.lang.Throwable -> L3e
        L45:
            boolean r3 = r11.f967u     // Catch: java.lang.Throwable -> L3e
            if (r3 != 0) goto L54
            b7.l r3 = r11.f957k     // Catch: java.lang.Throwable -> L3e
            if (r3 != 0) goto L54
            int r3 = r11.f965s     // Catch: java.lang.Throwable -> L3e
            r4 = -1
            if (r3 == r4) goto L54
            r3 = 1
            goto L55
        L54:
            r3 = 0
        L55:
            monitor-exit(r11)
            if (r3 == 0) goto L60
            n6.b0 r3 = r11.f948a
            kotlin.jvm.internal.p.b(r1)
            r3.onClosed(r11, r0, r1)
        L60:
            if (r2 == 0) goto L65
            o6.d.a(r2)
        L65:
            return
        L66:
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.h.d():void");
    }

    public final void e() {
        TimeZone timeZone = o6.f.f4330a;
        g gVar = this.f955i;
        if (gVar != null) {
            this.f958l.c(gVar, 0L);
        }
    }

    public final boolean f(String text) {
        p.e(text, "text");
        c7.i iVar = c7.i.d;
        c7.i iVarF = t1.f.f(text);
        synchronized (this) {
            if (!this.f967u && !this.f964r) {
                long j4 = this.f963q;
                byte[] bArr = iVarF.f1165a;
                if (bArr.length + j4 > 16777216) {
                    b(1001, null);
                    return false;
                }
                this.f963q = j4 + bArr.length;
                this.f962p.add(new f(iVarF));
                e();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean g() throws IOException {
        l lVar;
        f fVar;
        String str;
        synchronized (this) {
            try {
                boolean z = false;
                if (this.f967u) {
                    return false;
                }
                l lVar2 = this.f957k;
                Object objPoll = this.f961o.poll();
                String str2 = null;
                int i8 = -1;
                if (objPoll == null) {
                    Object objPoll2 = this.f962p.poll();
                    if (objPoll2 instanceof e) {
                        int i9 = this.f965s;
                        str = this.f966t;
                        if (i9 != -1) {
                            l lVar3 = this.f957k;
                            this.f957k = null;
                            if (lVar3 != null && this.f956j == null) {
                                z = true;
                            }
                            this.f958l.e();
                            lVar = lVar3;
                            i8 = i9;
                            fVar = objPoll2;
                        } else {
                            long j4 = ((e) objPoll2).f943c;
                            q6.c.b(this.f958l, this.f959m + " cancel", TimeUnit.MILLISECONDS.toNanos(j4), new c(2, this), 4);
                            i8 = i9;
                            fVar = objPoll2;
                            lVar = null;
                        }
                    } else {
                        if (objPoll2 == null) {
                            return false;
                        }
                        str = null;
                        fVar = objPoll2;
                        lVar = null;
                    }
                } else {
                    lVar = null;
                    fVar = 0;
                    str = null;
                }
                try {
                    if (objPoll != null) {
                        p.b(lVar2);
                        lVar2.a(10, (c7.i) objPoll);
                    } else if (fVar instanceof f) {
                        p.b(lVar2);
                        lVar2.b(fVar.f944a);
                        synchronized (this) {
                            this.f963q -= fVar.f944a.f1165a.length;
                        }
                    } else {
                        if (!(fVar instanceof e)) {
                            throw new AssertionError();
                        }
                        p.b(lVar2);
                        int i10 = fVar.f941a;
                        c7.i iVar = ((e) fVar).f942b;
                        c7.i iVar2 = c7.i.d;
                        if (i10 < 1000 || i10 >= 5000) {
                            str2 = "Code must be in range [1000,5000): " + i10;
                        } else if ((1004 <= i10 && i10 < 1007) || (1015 <= i10 && i10 < 3000)) {
                            str2 = "Code " + i10 + " is reserved and may not be used.";
                        }
                        if (str2 != null) {
                            throw new IllegalArgumentException(str2.toString());
                        }
                        c7.f fVar2 = new c7.f();
                        fVar2.G(i10);
                        if (iVar != null) {
                            fVar2.u(iVar);
                        }
                        try {
                            lVar2.a(8, fVar2.i(fVar2.f1164b));
                            if (z) {
                                b0 b0Var = this.f948a;
                                p.b(str);
                                b0Var.onClosed(this, i8, str);
                            }
                        } finally {
                            lVar2.f994h = true;
                        }
                    }
                    return true;
                } finally {
                    if (lVar != null) {
                        o6.d.a(lVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
