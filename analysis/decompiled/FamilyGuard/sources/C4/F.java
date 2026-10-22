package C4;

import C4.v;
import java.io.Closeable;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class F implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    final D f696a;

    /* renamed from: b, reason: collision with root package name */
    final B f697b;

    /* renamed from: c, reason: collision with root package name */
    final int f698c;

    /* renamed from: d, reason: collision with root package name */
    final String f699d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    final u f700e;

    /* renamed from: f, reason: collision with root package name */
    final v f701f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    final G f702g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    final F f703h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    final F f704i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    final F f705j;

    /* renamed from: k, reason: collision with root package name */
    final long f706k;

    /* renamed from: l, reason: collision with root package name */
    final long f707l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    final F4.c f708m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private volatile C0274d f709n;

    F(a aVar) {
        this.f696a = aVar.f710a;
        this.f697b = aVar.f711b;
        this.f698c = aVar.f712c;
        this.f699d = aVar.f713d;
        this.f700e = aVar.f714e;
        this.f701f = aVar.f715f.e();
        this.f702g = aVar.f716g;
        this.f703h = aVar.f717h;
        this.f704i = aVar.f718i;
        this.f705j = aVar.f719j;
        this.f706k = aVar.f720k;
        this.f707l = aVar.f721l;
        this.f708m = aVar.f722m;
    }

    @Nullable
    public F A() {
        return this.f703h;
    }

    public a C() {
        return new a(this);
    }

    @Nullable
    public F D() {
        return this.f705j;
    }

    public B E() {
        return this.f697b;
    }

    public long G() {
        return this.f707l;
    }

    public D I() {
        return this.f696a;
    }

    public long L() {
        return this.f706k;
    }

    @Nullable
    public G a() {
        return this.f702g;
    }

    public C0274d c() {
        C0274d c0274d = this.f709n;
        if (c0274d != null) {
            return c0274d;
        }
        C0274d c0274dK = C0274d.k(this.f701f);
        this.f709n = c0274dK;
        return c0274dK;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        G g5 = this.f702g;
        if (g5 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        g5.close();
    }

    @Nullable
    public F f() {
        return this.f704i;
    }

    public int m() {
        return this.f698c;
    }

    @Nullable
    public u o() {
        return this.f700e;
    }

    @Nullable
    public String r(String str) {
        return u(str, null);
    }

    public String toString() {
        return "Response{protocol=" + this.f697b + ", code=" + this.f698c + ", message=" + this.f699d + ", url=" + this.f696a.i() + '}';
    }

    @Nullable
    public String u(String str, @Nullable String str2) {
        String strC = this.f701f.c(str);
        return strC != null ? strC : str2;
    }

    public v v() {
        return this.f701f;
    }

    public boolean w() {
        int i5 = this.f698c;
        return i5 >= 200 && i5 < 300;
    }

    public String x() {
        return this.f699d;
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        D f710a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        B f711b;

        /* renamed from: c, reason: collision with root package name */
        int f712c;

        /* renamed from: d, reason: collision with root package name */
        String f713d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        u f714e;

        /* renamed from: f, reason: collision with root package name */
        v.a f715f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        G f716g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        F f717h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        F f718i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        F f719j;

        /* renamed from: k, reason: collision with root package name */
        long f720k;

        /* renamed from: l, reason: collision with root package name */
        long f721l;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        F4.c f722m;

        public a() {
            this.f712c = -1;
            this.f715f = new v.a();
        }

        private void e(F f5) {
            if (f5.f702g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, F f5) {
            if (f5.f702g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (f5.f703h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (f5.f704i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (f5.f705j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a a(String str, String str2) {
            this.f715f.a(str, str2);
            return this;
        }

        public a b(@Nullable G g5) {
            this.f716g = g5;
            return this;
        }

        public F c() {
            if (this.f710a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f711b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f712c >= 0) {
                if (this.f713d != null) {
                    return new F(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f712c);
        }

        public a d(@Nullable F f5) {
            if (f5 != null) {
                f("cacheResponse", f5);
            }
            this.f718i = f5;
            return this;
        }

        public a g(int i5) {
            this.f712c = i5;
            return this;
        }

        public a h(@Nullable u uVar) {
            this.f714e = uVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f715f.g(str, str2);
            return this;
        }

        public a j(v vVar) {
            this.f715f = vVar.f();
            return this;
        }

        void k(F4.c cVar) {
            this.f722m = cVar;
        }

        public a l(String str) {
            this.f713d = str;
            return this;
        }

        public a m(@Nullable F f5) {
            if (f5 != null) {
                f("networkResponse", f5);
            }
            this.f717h = f5;
            return this;
        }

        public a n(@Nullable F f5) {
            if (f5 != null) {
                e(f5);
            }
            this.f719j = f5;
            return this;
        }

        public a o(B b6) {
            this.f711b = b6;
            return this;
        }

        public a p(long j5) {
            this.f721l = j5;
            return this;
        }

        public a q(D d6) {
            this.f710a = d6;
            return this;
        }

        public a r(long j5) {
            this.f720k = j5;
            return this;
        }

        a(F f5) {
            this.f712c = -1;
            this.f710a = f5.f696a;
            this.f711b = f5.f697b;
            this.f712c = f5.f698c;
            this.f713d = f5.f699d;
            this.f714e = f5.f700e;
            this.f715f = f5.f701f.f();
            this.f716g = f5.f702g;
            this.f717h = f5.f703h;
            this.f718i = f5.f704i;
            this.f719j = f5.f705j;
            this.f720k = f5.f706k;
            this.f721l = f5.f707l;
            this.f722m = f5.f708m;
        }
    }
}
