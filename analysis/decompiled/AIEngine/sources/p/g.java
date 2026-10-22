package p;

import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class g<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final int f11366a;

    /* renamed from: b, reason: collision with root package name */
    public final q.b<K, V> f11367b;

    /* renamed from: c, reason: collision with root package name */
    public final y f11368c;

    /* renamed from: d, reason: collision with root package name */
    public int f11369d;

    /* renamed from: e, reason: collision with root package name */
    public int f11370e;

    /* renamed from: f, reason: collision with root package name */
    public int f11371f;

    public g(int i10) {
        this.f11366a = i10;
        if (i10 <= 0) {
            q.a.c("maxSize <= 0");
            throw null;
        }
        this.f11367b = new q.b<>();
        this.f11368c = new y();
    }

    public final V a(K key) {
        kotlin.jvm.internal.g.f(key, "key");
        synchronized (this.f11368c) {
            q.b<K, V> bVar = this.f11367b;
            bVar.getClass();
            V v3 = bVar.f11485a.get(key);
            if (v3 != null) {
                this.f11370e++;
                return v3;
            }
            this.f11371f++;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V b(K r6, V r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.g.f(r6, r0)
            mb.y r0 = r5.f11368c
            monitor-enter(r0)
            int r1 = r5.f11369d     // Catch: java.lang.Throwable -> L22
            int r1 = r1 + 1
            r5.f11369d = r1     // Catch: java.lang.Throwable -> L22
            q.b<K, V> r1 = r5.f11367b     // Catch: java.lang.Throwable -> L22
            r1.getClass()     // Catch: java.lang.Throwable -> L22
            java.util.LinkedHashMap<K, V> r1 = r1.f11485a     // Catch: java.lang.Throwable -> L22
            java.lang.Object r6 = r1.put(r6, r7)     // Catch: java.lang.Throwable -> L22
            if (r6 == 0) goto L25
            int r7 = r5.f11369d     // Catch: java.lang.Throwable -> L22
            int r7 = r7 + (-1)
            r5.f11369d = r7     // Catch: java.lang.Throwable -> L22
            goto L25
        L22:
            r5 = move-exception
            goto L9a
        L25:
            lb.n r7 = lb.n.f10413a     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            int r7 = r5.f11366a
        L2a:
            mb.y r0 = r5.f11368c
            monitor-enter(r0)
            int r1 = r5.f11369d     // Catch: java.lang.Throwable -> L40
            if (r1 < 0) goto L90
            q.b<K, V> r1 = r5.f11367b     // Catch: java.lang.Throwable -> L40
            java.util.LinkedHashMap<K, V> r1 = r1.f11485a     // Catch: java.lang.Throwable -> L40
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L42
            int r1 = r5.f11369d     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L90
            goto L42
        L40:
            r5 = move-exception
            goto L98
        L42:
            int r1 = r5.f11369d     // Catch: java.lang.Throwable -> L40
            if (r1 <= r7) goto L8e
            q.b<K, V> r1 = r5.f11367b     // Catch: java.lang.Throwable -> L40
            java.util.LinkedHashMap<K, V> r1 = r1.f11485a     // Catch: java.lang.Throwable -> L40
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L51
            goto L8e
        L51:
            q.b<K, V> r1 = r5.f11367b     // Catch: java.lang.Throwable -> L40
            java.util.LinkedHashMap<K, V> r1 = r1.f11485a     // Catch: java.lang.Throwable -> L40
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "<get-entries>(...)"
            kotlin.jvm.internal.g.e(r1, r2)     // Catch: java.lang.Throwable -> L40
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L40
            java.lang.Object r1 = kotlin.collections.a.u0(r1)     // Catch: java.lang.Throwable -> L40
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L6a
            monitor-exit(r0)
            return r6
        L6a:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L40
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L40
            q.b<K, V> r3 = r5.f11367b     // Catch: java.lang.Throwable -> L40
            r3.getClass()     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = "key"
            kotlin.jvm.internal.g.f(r2, r4)     // Catch: java.lang.Throwable -> L40
            java.util.LinkedHashMap<K, V> r3 = r3.f11485a     // Catch: java.lang.Throwable -> L40
            r3.remove(r2)     // Catch: java.lang.Throwable -> L40
            int r2 = r5.f11369d     // Catch: java.lang.Throwable -> L40
            java.lang.String r3 = "value"
            kotlin.jvm.internal.g.f(r1, r3)     // Catch: java.lang.Throwable -> L40
            int r2 = r2 + (-1)
            r5.f11369d = r2     // Catch: java.lang.Throwable -> L40
            monitor-exit(r0)
            goto L2a
        L8e:
            monitor-exit(r0)
            return r6
        L90:
            java.lang.String r5 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L40
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L40
            throw r6     // Catch: java.lang.Throwable -> L40
        L98:
            monitor-exit(r0)
            throw r5
        L9a:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.g.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final String toString() {
        String str;
        synchronized (this.f11368c) {
            try {
                int i10 = this.f11370e;
                int i11 = this.f11371f + i10;
                str = "LruCache[maxSize=" + this.f11366a + ",hits=" + this.f11370e + ",misses=" + this.f11371f + ",hitRate=" + (i11 != 0 ? (i10 * 100) / i11 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
