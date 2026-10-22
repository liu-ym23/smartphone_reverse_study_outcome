package k;

import androidx.lifecycle.s0;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f5513a;

    /* renamed from: b, reason: collision with root package name */
    public final s0 f5514b;

    /* renamed from: c, reason: collision with root package name */
    public final h4.n f5515c;

    /* renamed from: d, reason: collision with root package name */
    public int f5516d;

    /* renamed from: e, reason: collision with root package name */
    public int f5517e;

    /* renamed from: f, reason: collision with root package name */
    public int f5518f;

    public p(int i2) {
        this.f5513a = i2;
        if (i2 <= 0) {
            l.a.c("maxSize <= 0");
            throw null;
        }
        this.f5514b = new s0(2);
        this.f5515c = new h4.n(7, false);
    }

    public final Object a(Object obj) {
        q7.k.e(obj, "key");
        synchronized (this.f5515c) {
            s0 s0Var = this.f5514b;
            s0Var.getClass();
            Object obj2 = s0Var.f1030a.get(obj);
            if (obj2 != null) {
                this.f5517e++;
                return obj2;
            }
            this.f5518f++;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0095, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.String r0 = "key"
            q7.k.e(r6, r0)
            h4.n r0 = r5.f5515c
            monitor-enter(r0)
            int r1 = r5.f5516d     // Catch: java.lang.Throwable -> L22
            int r1 = r1 + 1
            r5.f5516d = r1     // Catch: java.lang.Throwable -> L22
            androidx.lifecycle.s0 r1 = r5.f5514b     // Catch: java.lang.Throwable -> L22
            r1.getClass()     // Catch: java.lang.Throwable -> L22
            java.util.LinkedHashMap r1 = r1.f1030a     // Catch: java.lang.Throwable -> L22
            java.lang.Object r6 = r1.put(r6, r7)     // Catch: java.lang.Throwable -> L22
            if (r6 == 0) goto L25
            int r7 = r5.f5516d     // Catch: java.lang.Throwable -> L22
            int r7 = r7 + (-1)
            r5.f5516d = r7     // Catch: java.lang.Throwable -> L22
            goto L25
        L22:
            r5 = move-exception
            goto L98
        L25:
            monitor-exit(r0)
            int r7 = r5.f5513a
        L28:
            h4.n r0 = r5.f5515c
            monitor-enter(r0)
            int r1 = r5.f5516d     // Catch: java.lang.Throwable -> L3e
            if (r1 < 0) goto L8e
            androidx.lifecycle.s0 r1 = r5.f5514b     // Catch: java.lang.Throwable -> L3e
            java.util.LinkedHashMap r1 = r1.f1030a     // Catch: java.lang.Throwable -> L3e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L40
            int r1 = r5.f5516d     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L8e
            goto L40
        L3e:
            r5 = move-exception
            goto L96
        L40:
            int r1 = r5.f5516d     // Catch: java.lang.Throwable -> L3e
            if (r1 <= r7) goto L8c
            androidx.lifecycle.s0 r1 = r5.f5514b     // Catch: java.lang.Throwable -> L3e
            java.util.LinkedHashMap r1 = r1.f1030a     // Catch: java.lang.Throwable -> L3e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L4f
            goto L8c
        L4f:
            androidx.lifecycle.s0 r1 = r5.f5514b     // Catch: java.lang.Throwable -> L3e
            java.util.LinkedHashMap r1 = r1.f1030a     // Catch: java.lang.Throwable -> L3e
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = "<get-entries>(...)"
            q7.k.d(r1, r2)     // Catch: java.lang.Throwable -> L3e
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = d7.r.O0(r1)     // Catch: java.lang.Throwable -> L3e
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L68
            monitor-exit(r0)
            return r6
        L68:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L3e
            androidx.lifecycle.s0 r3 = r5.f5514b     // Catch: java.lang.Throwable -> L3e
            r3.getClass()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "key"
            q7.k.e(r2, r4)     // Catch: java.lang.Throwable -> L3e
            java.util.LinkedHashMap r3 = r3.f1030a     // Catch: java.lang.Throwable -> L3e
            r3.remove(r2)     // Catch: java.lang.Throwable -> L3e
            int r2 = r5.f5516d     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = "value"
            q7.k.e(r1, r3)     // Catch: java.lang.Throwable -> L3e
            int r2 = r2 + (-1)
            r5.f5516d = r2     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r0)
            goto L28
        L8c:
            monitor-exit(r0)
            return r6
        L8e:
            java.lang.String r5 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L3e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L3e
            throw r6     // Catch: java.lang.Throwable -> L3e
        L96:
            monitor-exit(r0)
            throw r5
        L98:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k.p.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final String toString() {
        String str;
        synchronized (this.f5515c) {
            try {
                int i2 = this.f5517e;
                int i10 = this.f5518f + i2;
                str = "LruCache[maxSize=" + this.f5513a + ",hits=" + this.f5517e + ",misses=" + this.f5518f + ",hitRate=" + (i10 != 0 ? (i2 * 100) / i10 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
