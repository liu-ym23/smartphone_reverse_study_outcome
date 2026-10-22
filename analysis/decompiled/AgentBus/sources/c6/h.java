package c6;

import android.net.LocalServerSocket;
import ia.d0;
import ia.f1;
import ia.s;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.t;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f1939a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1940b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.a f1941c;

    /* renamed from: d, reason: collision with root package name */
    public final t f1942d;

    /* renamed from: e, reason: collision with root package name */
    public final na.d f1943e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f1944f;

    /* renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList f1945g;

    /* renamed from: h, reason: collision with root package name */
    public LocalServerSocket f1946h;

    /* renamed from: i, reason: collision with root package name */
    public final s f1947i;

    public h(String str, int i2, k5.a aVar, t tVar) {
        q7.k.e(str, "socketName");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f1939a = str;
        this.f1940b = i2;
        this.f1941c = aVar;
        this.f1942d = tVar;
        m mVar = m.LS;
        this.f1943e = d0.b(f1.plus(d0.c(), aVar.f5616a));
        this.f1944f = new AtomicBoolean(false);
        this.f1945g = new CopyOnWriteArrayList();
        this.f1947i = d0.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x009d -> B:22:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(c6.h r14, i7.c r15) {
        /*
            boolean r0 = r15 instanceof c6.f
            if (r0 == 0) goto L13
            r0 = r15
            c6.f r0 = (c6.f) r0
            int r1 = r0.f1933l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1933l = r1
            goto L18
        L13:
            c6.f r0 = new c6.f
            r0.<init>(r14, r15)
        L18:
            java.lang.Object r15 = r0.f1931j
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f1933l
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r14 = r0.f1930i
            int r2 = r0.f1929h
            q7.u r4 = r0.f1928g
            c6.h r5 = r0.f1927f
            w7.e0.N(r15)
            r15 = r5
            r5 = r4
            r4 = r2
            r2 = r0
            goto La0
        L34:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3c:
            w7.e0.N(r15)
            q7.u r15 = new q7.u
            r15.<init>()
            r4 = 200(0xc8, double:9.9E-322)
            r15.f8819f = r4
            r2 = 5
            r4 = 0
            r5 = r15
            r15 = r14
            r14 = r4
            r4 = r2
            r2 = r0
        L4f:
            if (r14 >= r4) goto Lb0
            android.net.LocalServerSocket r0 = new android.net.LocalServerSocket     // Catch: java.io.IOException -> L5a
            java.lang.String r6 = r15.f1939a     // Catch: java.io.IOException -> L5a
            r0.<init>(r6)     // Catch: java.io.IOException -> L5a
            r1 = r0
            goto Lb1
        L5a:
            r0 = move-exception
            k5.t r6 = r15.f1942d
            java.lang.String r7 = r15.f1939a
            int r8 = r14 + 1
            java.lang.String r0 = r0.getMessage()
            long r9 = r5.f8819f
            java.lang.String r11 = "' attempt "
            java.lang.String r12 = "/5 failed: "
            java.lang.String r13 = "bind '"
            java.lang.StringBuilder r7 = a1.a.o(r13, r7, r11, r8, r12)
            r7.append(r0)
            java.lang.String r0 = "; retrying in "
            r7.append(r0)
            r7.append(r9)
            java.lang.String r0 = "ms"
            r7.append(r0)
            java.lang.String r8 = r7.toString()
            r10 = 4
            r11 = 0
            java.lang.String r7 = "LSServer"
            r9 = 0
            k5.s.warn$default(r6, r7, r8, r9, r10, r11)
            long r6 = r5.f8819f
            r2.f1927f = r15
            r2.f1928g = r5
            r2.f1929h = r4
            r2.f1930i = r14
            r2.f1933l = r3
            java.lang.Object r0 = ia.d0.g(r6, r2)
            if (r0 != r1) goto La0
            goto Lb1
        La0:
            long r6 = r5.f8819f
            r0 = 2
            long r8 = (long) r0
            long r6 = r6 * r8
            r8 = 800(0x320, double:3.953E-321)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto Lac
            r6 = r8
        Lac:
            r5.f8819f = r6
            int r14 = r14 + r3
            goto L4f
        Lb0:
            r1 = 0
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.h.a(c6.h, i7.c):java.lang.Object");
    }
}
