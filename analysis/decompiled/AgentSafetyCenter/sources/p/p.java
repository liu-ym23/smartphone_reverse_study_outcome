package p;

import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f9602a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.room.t f9603b;

    /* renamed from: c, reason: collision with root package name */
    public final f8.b f9604c;

    /* renamed from: d, reason: collision with root package name */
    public int f9605d;

    /* renamed from: e, reason: collision with root package name */
    public int f9606e;

    /* renamed from: f, reason: collision with root package name */
    public int f9607f;

    public p(int i) {
        this.f9602a = i;
        if (!(i > 0)) {
            g5.f.s("maxSize <= 0");
            throw null;
        }
        androidx.room.t tVar = new androidx.room.t(2);
        tVar.f1627b = new LinkedHashMap(0, 0.75f, true);
        VarHandle.storeStoreFence();
        this.f9603b = tVar;
        this.f9604c = new f8.b(29);
    }

    public void a(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj2.getClass();
    }

    public final Object b(Object obj) {
        obj.getClass();
        synchronized (this.f9604c) {
            androidx.room.t tVar = this.f9603b;
            tVar.getClass();
            Object obj2 = tVar.f1627b.get(obj);
            if (obj2 != null) {
                this.f9606e++;
                return obj2;
            }
            this.f9607f++;
            return null;
        }
    }

    public final Object c(Object obj, Object obj2) {
        Object objPut;
        obj.getClass();
        synchronized (this.f9604c) {
            this.f9605d += e(obj, obj2);
            androidx.room.t tVar = this.f9603b;
            tVar.getClass();
            objPut = tVar.f1627b.put(obj, obj2);
            if (objPut != null) {
                this.f9605d -= e(obj, objPut);
            }
        }
        if (objPut != null) {
            a(obj, objPut, obj2);
        }
        g(this.f9602a);
        return objPut;
    }

    public final Object d(Object obj) {
        Object objRemove;
        obj.getClass();
        synchronized (this.f9604c) {
            androidx.room.t tVar = this.f9603b;
            tVar.getClass();
            objRemove = tVar.f1627b.remove(obj);
            if (objRemove != null) {
                this.f9605d -= e(obj, objRemove);
            }
        }
        if (objRemove != null) {
            a(obj, objRemove, null);
        }
        return objRemove;
    }

    public final int e(Object obj, Object obj2) {
        int iF = f(obj, obj2);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + obj + '=' + obj2);
    }

    public int f(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r7) {
        /*
            r6 = this;
        L0:
            f8.b r0 = r6.f9604c
            monitor-enter(r0)
            int r1 = r6.f9605d     // Catch: java.lang.Throwable -> L16
            if (r1 < 0) goto L85
            androidx.room.t r1 = r6.f9603b     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f1627b     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L19
            int r1 = r6.f9605d     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L85
            goto L19
        L16:
            r6 = move-exception
            goto L8d
        L19:
            int r1 = r6.f9605d     // Catch: java.lang.Throwable -> L16
            if (r1 <= r7) goto L83
            androidx.room.t r1 = r6.f9603b     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f1627b     // Catch: java.lang.Throwable -> L16
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L28
            goto L83
        L28:
            androidx.room.t r1 = r6.f9603b     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r1 = r1.f1627b     // Catch: java.lang.Throwable -> L16
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L16
            r1.getClass()     // Catch: java.lang.Throwable -> L16
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L16
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L16
            r3 = 0
            if (r2 == 0) goto L4a
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L16
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L44
        L42:
            r1 = r3
            goto L59
        L44:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L16
            goto L59
        L4a:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L16
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L16
            if (r2 != 0) goto L55
            goto L42
        L55:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L16
        L59:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L5f
            monitor-exit(r0)
            return
        L5f:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L16
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L16
            androidx.room.t r4 = r6.f9603b     // Catch: java.lang.Throwable -> L16
            r4.getClass()     // Catch: java.lang.Throwable -> L16
            r2.getClass()     // Catch: java.lang.Throwable -> L16
            java.util.LinkedHashMap r4 = r4.f1627b     // Catch: java.lang.Throwable -> L16
            r4.remove(r2)     // Catch: java.lang.Throwable -> L16
            int r4 = r6.f9605d     // Catch: java.lang.Throwable -> L16
            int r5 = r6.e(r2, r1)     // Catch: java.lang.Throwable -> L16
            int r4 = r4 - r5
            r6.f9605d = r4     // Catch: java.lang.Throwable -> L16
            monitor-exit(r0)
            r6.a(r2, r1, r3)
            goto L0
        L83:
            monitor-exit(r0)
            return
        L85:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L16
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L16
            throw r7     // Catch: java.lang.Throwable -> L16
        L8d:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p.p.g(int):void");
    }

    public final String toString() {
        String str;
        synchronized (this.f9604c) {
            try {
                int i = this.f9606e;
                int i3 = this.f9607f + i;
                str = "LruCache[maxSize=" + this.f9602a + ",hits=" + this.f9606e + ",misses=" + this.f9607f + ",hitRate=" + (i3 != 0 ? (i * 100) / i3 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
