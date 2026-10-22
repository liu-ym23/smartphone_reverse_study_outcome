package w5;

import hc.o;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kc.w;
import od.b0;
import od.c0;
import od.g0;
import od.i0;
import od.z;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Closeable, Flushable {

    /* renamed from: u, reason: collision with root package name */
    public static final hc.g f15246u = new hc.g("[a-z0-9_-]{1,120}");

    /* renamed from: c, reason: collision with root package name */
    public z f15247c;

    /* renamed from: f, reason: collision with root package name */
    public long f15248f;

    /* renamed from: g, reason: collision with root package name */
    public z f15249g;

    /* renamed from: h, reason: collision with root package name */
    public z f15250h;
    public z i;

    /* renamed from: j, reason: collision with root package name */
    public LinkedHashMap f15251j;

    /* renamed from: k, reason: collision with root package name */
    public pc.c f15252k;

    /* renamed from: l, reason: collision with root package name */
    public long f15253l;

    /* renamed from: m, reason: collision with root package name */
    public int f15254m;

    /* renamed from: n, reason: collision with root package name */
    public b0 f15255n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15256o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15257p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f15258q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15259r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f15260s;

    /* renamed from: t, reason: collision with root package name */
    public d f15261t;

    public static void M(String str) {
        if (f15246u.c(str)) {
            return;
        }
        od.f.q(str, "keys must match regex [a-z0-9_-]{1,120}: \"");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0119 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0011, B:11:0x0018, B:13:0x0020, B:15:0x0030, B:23:0x003e, B:26:0x0058, B:30:0x0071, B:32:0x0081, B:34:0x0088, B:27:0x005c, B:29:0x006a, B:38:0x00a8, B:40:0x00af, B:43:0x00b4, B:45:0x00c5, B:48:0x00ca, B:53:0x0105, B:55:0x0110, B:59:0x0119, B:49:0x00e2, B:51:0x00f7, B:52:0x0102, B:37:0x0098, B:62:0x011e, B:63:0x0125), top: B:66:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(w5.e r9, ab.c r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.e.d(w5.e, ab.c, boolean):void");
    }

    public final void A() throws Throwable {
        i0 i0VarL = this.f15261t.l(this.f15249g);
        i0VarL.getClass();
        c0 c0Var = new c0(i0VarL);
        try {
            String strQ = c0Var.q(Long.MAX_VALUE);
            String strQ2 = c0Var.q(Long.MAX_VALUE);
            String strQ3 = c0Var.q(Long.MAX_VALUE);
            String strQ4 = c0Var.q(Long.MAX_VALUE);
            String strQ5 = c0Var.q(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(strQ) || !"1".equals(strQ2) || !k.a(String.valueOf(1), strQ3) || !k.a(String.valueOf(2), strQ4) || strQ5.length() > 0) {
                throw new IOException("unexpected journal header: [" + strQ + ", " + strQ2 + ", " + strQ3 + ", " + strQ4 + ", " + strQ5 + ']');
            }
            int i = 0;
            while (true) {
                try {
                    C(c0Var.q(Long.MAX_VALUE));
                    i++;
                } catch (EOFException unused) {
                    this.f15254m = i - this.f15251j.size();
                    if (c0Var.d()) {
                        this.f15255n = o();
                    } else {
                        N();
                    }
                    try {
                        c0Var.close();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (th != null) {
                        throw th;
                    }
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                c0Var.close();
            } catch (Throwable th3) {
                com.stepos.statsrpk.h.b(th, th3);
            }
        }
    }

    public final void C(String str) throws IOException {
        String strSubstring;
        LinkedHashMap linkedHashMap = this.f15251j;
        int iD0 = hc.h.d0(str, ' ', 0, 6);
        if (iD0 == -1) {
            od.f.l("unexpected journal line: ".concat(str));
            return;
        }
        int i = iD0 + 1;
        int iD02 = hc.h.d0(str, ' ', i, 4);
        if (iD02 == -1) {
            strSubstring = str.substring(i);
            if (iD0 == 6 && o.U(str, "REMOVE", false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iD02);
        }
        Object bVar = linkedHashMap.get(strSubstring);
        if (bVar == null) {
            bVar = new b(this, strSubstring);
            linkedHashMap.put(strSubstring, bVar);
        }
        b bVar2 = (b) bVar;
        if (iD02 == -1 || iD0 != 5 || !o.U(str, "CLEAN", false)) {
            if (iD02 == -1 && iD0 == 5 && o.U(str, "DIRTY", false)) {
                bVar2.f15240g = new ab.c(this, bVar2);
                return;
            } else {
                if (iD02 == -1 && iD0 == 4 && o.U(str, "READ", false)) {
                    return;
                }
                od.f.l("unexpected journal line: ".concat(str));
                return;
            }
        }
        List listP0 = hc.h.p0(str.substring(iD02 + 1), new char[]{' '});
        bVar2.f15238e = true;
        bVar2.f15240g = null;
        if (listP0.size() != 2) {
            od.f.k(listP0, "unexpected journal line: ");
            return;
        }
        try {
            int size = listP0.size();
            for (int i3 = 0; i3 < size; i3++) {
                bVar2.f15235b[i3] = Long.parseLong((String) listP0.get(i3));
            }
        } catch (NumberFormatException unused) {
            od.f.k(listP0, "unexpected journal line: ");
        }
    }

    public final void F(b bVar) {
        b0 b0Var;
        int i = bVar.f15241h;
        String str = bVar.f15234a;
        if (i > 0 && (b0Var = this.f15255n) != null) {
            b0Var.v("DIRTY");
            b0Var.writeByte(32);
            b0Var.v(str);
            b0Var.writeByte(10);
            b0Var.flush();
        }
        if (bVar.f15241h > 0 || bVar.f15240g != null) {
            bVar.f15239f = true;
            return;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            this.f15261t.e((z) bVar.f15236c.get(i3));
            long j10 = this.f15253l;
            long[] jArr = bVar.f15235b;
            this.f15253l = j10 - jArr[i3];
            jArr[i3] = 0;
        }
        this.f15254m++;
        b0 b0Var2 = this.f15255n;
        if (b0Var2 != null) {
            b0Var2.v("REMOVE");
            b0Var2.writeByte(32);
            b0Var2.v(str);
            b0Var2.writeByte(10);
        }
        this.f15251j.remove(str);
        if (this.f15254m >= 2000) {
            n();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        F(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H() {
        /*
            r4 = this;
        L0:
            long r0 = r4.f15253l
            long r2 = r4.f15248f
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L27
            java.util.LinkedHashMap r0 = r4.f15251j
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L26
            java.lang.Object r1 = r0.next()
            w5.b r1 = (w5.b) r1
            boolean r2 = r1.f15239f
            if (r2 != 0) goto L12
            r4.F(r1)
            goto L0
        L26:
            return
        L27:
            r0 = 0
            r4.f15259r = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.e.H():void");
    }

    public final synchronized void N() {
        Throwable th;
        try {
            b0 b0Var = this.f15255n;
            if (b0Var != null) {
                b0Var.close();
            }
            b0 b0VarJ = ac.a.j(this.f15261t.k(this.f15250h));
            try {
                b0VarJ.v("libcore.io.DiskLruCache");
                b0VarJ.writeByte(10);
                b0VarJ.v("1");
                b0VarJ.writeByte(10);
                b0VarJ.I(1);
                b0VarJ.writeByte(10);
                b0VarJ.I(2);
                b0VarJ.writeByte(10);
                b0VarJ.writeByte(10);
                for (b bVar : this.f15251j.values()) {
                    if (bVar.f15240g != null) {
                        b0VarJ.v("DIRTY");
                        b0VarJ.writeByte(32);
                        b0VarJ.v(bVar.f15234a);
                        b0VarJ.writeByte(10);
                    } else {
                        b0VarJ.v("CLEAN");
                        b0VarJ.writeByte(32);
                        b0VarJ.v(bVar.f15234a);
                        for (long j10 : bVar.f15235b) {
                            b0VarJ.writeByte(32);
                            b0VarJ.I(j10);
                        }
                        b0VarJ.writeByte(10);
                    }
                }
                try {
                    b0VarJ.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    b0VarJ.close();
                } catch (Throwable th4) {
                    com.stepos.statsrpk.h.b(th3, th4);
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            boolean zF = this.f15261t.f(this.f15249g);
            d dVar = this.f15261t;
            if (zF) {
                dVar.b(this.f15249g, this.i);
                this.f15261t.b(this.f15250h, this.f15249g);
                this.f15261t.e(this.i);
            } else {
                dVar.b(this.f15250h, this.f15249g);
            }
            this.f15255n = o();
            this.f15254m = 0;
            this.f15256o = false;
            this.f15260s = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f15257p && !this.f15258q) {
                for (b bVar : (b[]) this.f15251j.values().toArray(new b[0])) {
                    ab.c cVar = bVar.f15240g;
                    if (cVar != null) {
                        b bVar2 = (b) cVar.f383b;
                        if (k.a(bVar2.f15240g, cVar)) {
                            bVar2.f15239f = true;
                        }
                    }
                }
                H();
                w.d(this.f15252k, null);
                b0 b0Var = this.f15255n;
                b0Var.getClass();
                b0Var.close();
                this.f15255n = null;
                this.f15258q = true;
                return;
            }
            this.f15258q = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ab.c e(String str) {
        if (this.f15258q) {
            throw new IllegalStateException("cache is closed");
        }
        M(str);
        i();
        b bVar = (b) this.f15251j.get(str);
        if ((bVar != null ? bVar.f15240g : null) != null) {
            return null;
        }
        if (bVar != null && bVar.f15241h != 0) {
            return null;
        }
        if (!this.f15259r && !this.f15260s) {
            b0 b0Var = this.f15255n;
            b0Var.getClass();
            b0Var.v("DIRTY");
            b0Var.writeByte(32);
            b0Var.v(str);
            b0Var.writeByte(10);
            b0Var.flush();
            if (this.f15256o) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(this, str);
                this.f15251j.put(str, bVar);
            }
            ab.c cVar = new ab.c(this, bVar);
            bVar.f15240g = cVar;
            return cVar;
        }
        n();
        return null;
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.f15257p) {
            if (this.f15258q) {
                throw new IllegalStateException("cache is closed");
            }
            H();
            b0 b0Var = this.f15255n;
            b0Var.getClass();
            b0Var.flush();
        }
    }

    public final synchronized c g(String str) {
        c cVarA;
        if (this.f15258q) {
            throw new IllegalStateException("cache is closed");
        }
        M(str);
        i();
        b bVar = (b) this.f15251j.get(str);
        if (bVar != null && (cVarA = bVar.a()) != null) {
            boolean z10 = true;
            this.f15254m++;
            b0 b0Var = this.f15255n;
            b0Var.getClass();
            b0Var.v("READ");
            b0Var.writeByte(32);
            b0Var.v(str);
            b0Var.writeByte(10);
            if (this.f15254m < 2000) {
                z10 = false;
            }
            if (z10) {
                n();
            }
            return cVarA;
        }
        return null;
    }

    public final synchronized void i() {
        try {
            if (this.f15257p) {
                return;
            }
            this.f15261t.e(this.f15250h);
            if (this.f15261t.f(this.i)) {
                boolean zF = this.f15261t.f(this.f15249g);
                d dVar = this.f15261t;
                z zVar = this.i;
                if (zF) {
                    dVar.e(zVar);
                } else {
                    dVar.b(zVar, this.f15249g);
                }
            }
            if (this.f15261t.f(this.f15249g)) {
                try {
                    A();
                    r();
                    this.f15257p = true;
                    return;
                } catch (IOException unused) {
                    try {
                        close();
                        com.stepos.statsrpk.h.l(this.f15261t, this.f15247c);
                        this.f15258q = false;
                    } catch (Throwable th) {
                        this.f15258q = false;
                        throw th;
                    }
                }
            }
            N();
            this.f15257p = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void n() {
        w.u(this.f15252k, null, null, new k8.f(this, null, 3), 3);
    }

    public final b0 o() {
        d dVar = this.f15261t;
        z zVar = this.f15249g;
        dVar.getClass();
        zVar.getClass();
        g0 g0VarA = dVar.f15245b.a(zVar);
        a9.e eVar = new a9.e(18);
        eVar.f257f = this;
        VarHandle.storeStoreFence();
        g0VarA.getClass();
        f fVar = new f();
        fVar.f9479c = g0VarA;
        fVar.f15262f = eVar;
        VarHandle.storeStoreFence();
        return ac.a.j(fVar);
    }

    public final void r() {
        d dVar = this.f15261t;
        Iterator it = this.f15251j.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            int i = 0;
            if (bVar.f15240g == null) {
                while (i < 2) {
                    j10 += bVar.f15235b[i];
                    i++;
                }
            } else {
                bVar.f15240g = null;
                while (i < 2) {
                    dVar.e((z) bVar.f15236c.get(i));
                    dVar.e((z) bVar.f15237d.get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.f15253l = j10;
    }
}
