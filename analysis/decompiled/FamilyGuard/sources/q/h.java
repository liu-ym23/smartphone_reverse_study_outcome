package q;

import V3.v;
import r.C0991b;
import r.C0992c;

/* loaded from: classes.dex */
public class h<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private int f19634a;

    /* renamed from: b, reason: collision with root package name */
    private final C0992c<K, V> f19635b;

    /* renamed from: c, reason: collision with root package name */
    private final C0991b f19636c;

    /* renamed from: d, reason: collision with root package name */
    private int f19637d;

    /* renamed from: e, reason: collision with root package name */
    private int f19638e;

    /* renamed from: f, reason: collision with root package name */
    private int f19639f;

    /* renamed from: g, reason: collision with root package name */
    private int f19640g;

    /* renamed from: h, reason: collision with root package name */
    private int f19641h;

    /* renamed from: i, reason: collision with root package name */
    private int f19642i;

    public h(int i5) {
        this.f19634a = i5;
        if (i5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f19635b = new C0992c<>(0, 0.75f);
        this.f19636c = new C0991b();
    }

    private final int e(K k5, V v5) {
        int iF = f(k5, v5);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException(("Negative size: " + k5 + '=' + v5).toString());
    }

    protected V a(K k5) {
        j4.k.g(k5, "key");
        return null;
    }

    protected void b(boolean z5, K k5, V v5, V v6) {
        j4.k.g(k5, "key");
        j4.k.g(v5, "oldValue");
    }

    public final V c(K k5) {
        V v5;
        j4.k.g(k5, "key");
        synchronized (this.f19636c) {
            V vA = this.f19635b.a(k5);
            if (vA != null) {
                this.f19641h++;
                return vA;
            }
            this.f19642i++;
            V vA2 = a(k5);
            if (vA2 == null) {
                return null;
            }
            synchronized (this.f19636c) {
                try {
                    this.f19639f++;
                    v5 = (V) this.f19635b.d(k5, vA2);
                    if (v5 != null) {
                        this.f19635b.d(k5, v5);
                    } else {
                        this.f19637d += e(k5, vA2);
                        v vVar = v.f5542a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v5 != null) {
                b(false, k5, vA2, v5);
                return v5;
            }
            g(this.f19634a);
            return vA2;
        }
    }

    public final V d(K k5, V v5) {
        V vD;
        j4.k.g(k5, "key");
        j4.k.g(v5, "value");
        synchronized (this.f19636c) {
            try {
                this.f19638e++;
                this.f19637d += e(k5, v5);
                vD = this.f19635b.d(k5, v5);
                if (vD != null) {
                    this.f19637d -= e(k5, vD);
                }
                v vVar = v.f5542a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vD != null) {
            b(false, k5, vD, v5);
        }
        g(this.f19634a);
        return vD;
    }

    protected int f(K k5, V v5) {
        j4.k.g(k5, "key");
        j4.k.g(v5, "value");
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r6) {
        /*
            r5 = this;
        L0:
            r.b r0 = r5.f19636c
            monitor-enter(r0)
            int r1 = r5.f19637d     // Catch: java.lang.Throwable -> L14
            if (r1 < 0) goto L57
            r.c<K, V> r1 = r5.f19635b     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            int r1 = r5.f19637d     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L57
            goto L16
        L14:
            r5 = move-exception
            goto L5f
        L16:
            int r1 = r5.f19637d     // Catch: java.lang.Throwable -> L14
            if (r1 <= r6) goto L55
            r.c<K, V> r1 = r5.f19635b     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L23
            goto L55
        L23:
            r.c<K, V> r1 = r5.f19635b     // Catch: java.lang.Throwable -> L14
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = W3.C0403n.C(r1)     // Catch: java.lang.Throwable -> L14
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L33
            monitor-exit(r0)
            return
        L33:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L14
            r.c<K, V> r3 = r5.f19635b     // Catch: java.lang.Throwable -> L14
            r3.e(r2)     // Catch: java.lang.Throwable -> L14
            int r3 = r5.f19637d     // Catch: java.lang.Throwable -> L14
            int r4 = r5.e(r2, r1)     // Catch: java.lang.Throwable -> L14
            int r3 = r3 - r4
            r5.f19637d = r3     // Catch: java.lang.Throwable -> L14
            int r3 = r5.f19640g     // Catch: java.lang.Throwable -> L14
            r4 = 1
            int r3 = r3 + r4
            r5.f19640g = r3     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)
            r0 = 0
            r5.b(r4, r2, r1, r0)
            goto L0
        L55:
            monitor-exit(r0)
            return
        L57:
            java.lang.String r5 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L14
            throw r6     // Catch: java.lang.Throwable -> L14
        L5f:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q.h.g(int):void");
    }

    public String toString() {
        String str;
        synchronized (this.f19636c) {
            try {
                int i5 = this.f19641h;
                int i6 = this.f19642i + i5;
                str = "LruCache[maxSize=" + this.f19634a + ",hits=" + this.f19641h + ",misses=" + this.f19642i + ",hitRate=" + (i6 != 0 ? (i5 * 100) / i6 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
