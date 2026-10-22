package o4;

import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f9184a;

    /* renamed from: b, reason: collision with root package name */
    public final xb.a f9185b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f9186c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public int f9187d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9188e;

    /* renamed from: f, reason: collision with root package name */
    public final f[] f9189f;

    /* renamed from: g, reason: collision with root package name */
    public final sc.h f9190g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.datastore.preferences.protobuf.j f9191h;

    public i(int i, xb.a aVar) {
        this.f9184a = i;
        this.f9185b = aVar;
        this.f9189f = new f[i];
        int i3 = sc.i.f12185a;
        this.f9190g = new sc.h(i);
        androidx.datastore.preferences.protobuf.j jVar = new androidx.datastore.preferences.protobuf.j();
        if (i < 1) {
            g5.f.s("capacity must be >= 1");
            throw null;
        }
        if (i > 1073741824) {
            g5.f.s("capacity must be <= 2^30");
            throw null;
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        jVar.f1136c = i - 1;
        jVar.f1137d = new Object[i];
        this.f9191h = jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(pb.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof o4.h
            if (r0 == 0) goto L13
            r0 = r7
            o4.h r0 = (o4.h) r0
            int r1 = r0.f9183h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9183h = r1
            goto L18
        L13:
            o4.h r0 = new o4.h
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f9181f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f9183h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            o4.i r6 = r0.f9180c
            id.c.I(r7)
            goto L40
        L29:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L30:
            id.c.I(r7)
            r0.f9180c = r6
            r0.f9183h = r3
            sc.h r7 = r6.f9190g
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L40
            return r1
        L40:
            java.util.concurrent.locks.ReentrantLock r7 = r6.f9186c     // Catch: java.lang.Throwable -> L72
            androidx.datastore.preferences.protobuf.j r0 = r6.f9191h     // Catch: java.lang.Throwable -> L72
            r7.lock()     // Catch: java.lang.Throwable -> L72
            boolean r1 = r6.f9188e     // Catch: java.lang.Throwable -> L56
            r2 = 0
            if (r1 != 0) goto L7a
            int r1 = r0.f1134a     // Catch: java.lang.Throwable -> L56
            int r4 = r0.f1135b     // Catch: java.lang.Throwable -> L56
            if (r1 != r4) goto L58
            r6.e()     // Catch: java.lang.Throwable -> L56
            goto L58
        L56:
            r0 = move-exception
            goto L82
        L58:
            int r1 = r0.f1134a     // Catch: java.lang.Throwable -> L56
            int r4 = r0.f1135b     // Catch: java.lang.Throwable -> L56
            if (r1 == r4) goto L74
            java.lang.Object r4 = r0.f1137d     // Catch: java.lang.Throwable -> L56
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch: java.lang.Throwable -> L56
            r5 = r4[r1]     // Catch: java.lang.Throwable -> L56
            r4[r1] = r2     // Catch: java.lang.Throwable -> L56
            int r1 = r1 + r3
            int r2 = r0.f1136c     // Catch: java.lang.Throwable -> L56
            r1 = r1 & r2
            r0.f1134a = r1     // Catch: java.lang.Throwable -> L56
            o4.f r5 = (o4.f) r5     // Catch: java.lang.Throwable -> L56
            r7.unlock()     // Catch: java.lang.Throwable -> L72
            return r5
        L72:
            r7 = move-exception
            goto L86
        L74:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException     // Catch: java.lang.Throwable -> L56
            r0.<init>()     // Catch: java.lang.Throwable -> L56
            throw r0     // Catch: java.lang.Throwable -> L56
        L7a:
            java.lang.String r0 = "Connection pool is closed"
            r1 = 21
            t0.a.l(r1, r0)     // Catch: java.lang.Throwable -> L56
            throw r2     // Catch: java.lang.Throwable -> L56
        L82:
            r7.unlock()     // Catch: java.lang.Throwable -> L72
            throw r0     // Catch: java.lang.Throwable -> L72
        L86:
            sc.h r6 = r6.f9190g
            r6.c()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.i.a(pb.c):java.lang.Object");
    }

    public final void b() {
        ReentrantLock reentrantLock = this.f9186c;
        reentrantLock.lock();
        try {
            this.f9188e = true;
            for (f fVar : this.f9189f) {
                if (fVar != null) {
                    fVar.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(StringBuilder sb2) {
        androidx.datastore.preferences.protobuf.j jVar = this.f9191h;
        ReentrantLock reentrantLock = this.f9186c;
        reentrantLock.lock();
        try {
            lb.c cVarO = ac.a.o();
            int i = (jVar.f1135b - jVar.f1134a) & jVar.f1136c;
            for (int i3 = 0; i3 < i; i3++) {
                if (i3 >= 0) {
                    int i10 = jVar.f1135b;
                    int i11 = jVar.f1134a;
                    int i12 = jVar.f1136c;
                    if (i3 < ((i10 - i11) & i12)) {
                        Object obj = ((Object[]) jVar.f1137d)[(i11 + i3) & i12];
                        obj.getClass();
                        cVarO.add(obj);
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            lb.c cVarK = ac.a.k(cVarO);
            sb2.append('\t' + toString() + " (");
            sb2.append("capacity=" + this.f9184a + ", ");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("permits=");
            sc.h hVar = this.f9190g;
            hVar.getClass();
            sb3.append(Math.max(sc.g.f12182k.get(hVar), 0));
            sb3.append(", ");
            sb2.append(sb3.toString());
            sb2.append("queue=(size=" + cVarK.a() + ")[" + kb.l.B0(cVarK, null, null, null, null, 63) + "], ");
            sb2.append(")");
            sb2.append('\n');
            f[] fVarArr = this.f9189f;
            int length = fVarArr.length;
            int i13 = 0;
            for (int i14 = 0; i14 < length; i14++) {
                f fVar = fVarArr[i14];
                i13++;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("\t\t[");
                sb4.append(i13);
                sb4.append("] - ");
                sb4.append(fVar != null ? fVar.f9172c.toString() : null);
                sb2.append(sb4.toString());
                sb2.append('\n');
                if (fVar != null) {
                    fVar.g(sb2);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(f fVar) {
        fVar.getClass();
        ReentrantLock reentrantLock = this.f9186c;
        reentrantLock.lock();
        try {
            this.f9191h.a(fVar);
            reentrantLock.unlock();
            this.f9190g.c();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void e() {
        if (this.f9187d >= this.f9184a) {
            return;
        }
        x4.a aVar = (x4.a) this.f9185b.invoke();
        sc.c cVar = new sc.c();
        aVar.getClass();
        f fVar = new f();
        fVar.f9172c = aVar;
        fVar.f9173f = cVar;
        VarHandle.storeStoreFence();
        int i = this.f9187d;
        this.f9187d = i + 1;
        this.f9189f[i] = fVar;
        this.f9191h.a(fVar);
    }
}
