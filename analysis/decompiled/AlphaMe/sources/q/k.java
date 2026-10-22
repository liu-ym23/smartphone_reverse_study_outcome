package q;

import d.C0527a;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f13962a;

    /* renamed from: b, reason: collision with root package name */
    public final C0527a f13963b;

    /* renamed from: c, reason: collision with root package name */
    public final y1.f f13964c;

    /* renamed from: d, reason: collision with root package name */
    public int f13965d;

    /* renamed from: e, reason: collision with root package name */
    public int f13966e;

    /* renamed from: f, reason: collision with root package name */
    public int f13967f;

    public k(int i4) {
        this.f13962a = i4;
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        this.f13963b = new C0527a();
        this.f13964c = new y1.f();
    }

    public final Object a(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f13964c) {
            C0527a c0527a = this.f13963b;
            c0527a.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            Object obj = ((LinkedHashMap) c0527a.f12410b).get(key);
            if (obj != null) {
                this.f13966e++;
                return obj;
            }
            this.f13967f++;
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.k.b(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final String toString() {
        String str;
        synchronized (this.f13964c) {
            try {
                int i4 = this.f13966e;
                int i5 = this.f13967f + i4;
                str = "LruCache[maxSize=" + this.f13962a + ",hits=" + this.f13966e + ",misses=" + this.f13967f + ",hitRate=" + (i5 != 0 ? (i4 * 100) / i5 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
