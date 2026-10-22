package F9;

import okhttp3.Protocol;

/* loaded from: classes4.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public G f629a;
    public Protocol b;
    public String d;
    public okhttp3.c e;
    public P g;
    public M h;
    public M i;

    /* renamed from: j, reason: collision with root package name */
    public M f630j;
    public long k;
    public long l;
    public G6.c m;
    public int c = -1;
    public v f = new v(0);

    public static void b(M m, String str) {
        if (m != null) {
            if (m.g != null) {
                throw new IllegalArgumentException(str.concat(".body != null").toString());
            }
            if (m.h != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (m.i != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (m.f632j != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final M a() {
        int i = this.c;
        if (i < 0) {
            throw new IllegalStateException(("code < 0: " + this.c).toString());
        }
        G g = this.f629a;
        if (g == null) {
            throw new IllegalStateException("request == null");
        }
        Protocol protocol = this.b;
        if (protocol == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.d;
        if (str != null) {
            return new M(g, protocol, str, i, this.e, this.f.g(), this.g, this.h, this.i, this.f630j, this.k, this.l, this.m);
        }
        throw new IllegalStateException("message == null");
    }
}
