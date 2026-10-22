package F9;

import java.io.Closeable;
import okhttp3.Protocol;

/* loaded from: classes4.dex */
public final class M implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final G f631a;
    public final Protocol b;
    public final String c;
    public final int d;
    public final okhttp3.c e;
    public final w f;
    public final P g;
    public final M h;
    public final M i;

    /* renamed from: j, reason: collision with root package name */
    public final M f632j;
    public final long k;
    public final long l;
    public final G6.c m;

    public M(G request, Protocol protocol, String message, int i, okhttp3.c cVar, w wVar, P p, M m, M m2, M m10, long j5, long j6, G6.c cVar2) {
        kotlin.jvm.internal.k.f(request, "request");
        kotlin.jvm.internal.k.f(protocol, "protocol");
        kotlin.jvm.internal.k.f(message, "message");
        this.f631a = request;
        this.b = protocol;
        this.c = message;
        this.d = i;
        this.e = cVar;
        this.f = wVar;
        this.g = p;
        this.h = m;
        this.i = m2;
        this.f632j = m10;
        this.k = j5;
        this.l = j6;
        this.m = cVar2;
    }

    public static String b(M m, String name) {
        m.getClass();
        kotlin.jvm.internal.k.f(name, "name");
        String strB = m.f.b(name);
        if (strB == null) {
            return null;
        }
        return strB;
    }

    public final boolean c() {
        int i = this.d;
        return 200 <= i && i < 300;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        P p = this.g;
        if (p == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        p.close();
    }

    public final L f() {
        L l = new L();
        l.f629a = this.f631a;
        l.b = this.b;
        l.c = this.d;
        l.d = this.c;
        l.e = this.e;
        l.f = this.f.g();
        l.g = this.g;
        l.h = this.h;
        l.i = this.i;
        l.f630j = this.f632j;
        l.k = this.k;
        l.l = this.l;
        l.m = this.m;
        return l;
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.d + ", message=" + this.c + ", url=" + this.f631a.f626a + '}';
    }
}
