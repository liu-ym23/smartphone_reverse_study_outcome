package okhttp3;

import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Response implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f22794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Protocol f22795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handshake f22798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Headers f22799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ResponseBody f22800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Response f22801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Response f22802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Response f22803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f22804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f22805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile a f22806m;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Request f22807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Protocol f22808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f22810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handshake f22811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Headers.Builder f22812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ResponseBody f22813g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Response f22814h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Response f22815i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Response f22816j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f22817k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f22818l;

        public Builder() {
            this.f22809c = -1;
            this.f22812f = new Headers.Builder();
        }

        public Builder a(String r10, String r11) {
            this.f22812f.a(r10, r11);
            return this;
        }

        public Builder b(ResponseBody r10) {
            this.f22813g = r10;
            return this;
        }

        public Response c() {
            if (this.f22807a == null) goto L19;
            if (this.f22808b == null) goto L17;
            if (this.f22809c < 0) goto L15;
            if (this.f22810d == null) goto L13;
            return new Response(this);
        L13:
            throw new IllegalStateException("message == null");
        L15:
            throw new IllegalStateException("code < 0: " + this.f22809c);
        L17:
            throw new IllegalStateException("protocol == null");
        L19:
            throw new IllegalStateException("request == null");
        }

        public Builder d(Response r10) {
            if (r10 == null) goto L4;
            f("cacheResponse", r10);
        L4:
            this.f22815i = r10;
            return this;
        }

        public final void e(Response r10) {
            if (r10.f22800g != null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        public final void f(String r10, Response r11) {
            if (r11.f22800g != null) goto L18;
            if (r11.f22801h != null) goto L16;
            if (r11.f22802i != null) goto L14;
            if (r11.f22803j != null) goto L12;
            return;
        L12:
            throw new IllegalArgumentException(r10 + ".priorResponse != null");
        L14:
            throw new IllegalArgumentException(r10 + ".cacheResponse != null");
        L16:
            throw new IllegalArgumentException(r10 + ".networkResponse != null");
        L18:
            throw new IllegalArgumentException(r10 + ".body != null");
        }

        public Builder g(int r10) {
            this.f22809c = r10;
            return this;
        }

        public Builder h(Handshake r10) {
            this.f22811e = r10;
            return this;
        }

        public Builder i(Headers r10) {
            this.f22812f = r10.f();
            return this;
        }

        public Builder j(String r10) {
            this.f22810d = r10;
            return this;
        }

        public Builder k(Response r10) {
            if (r10 == null) goto L4;
            f("networkResponse", r10);
        L4:
            this.f22814h = r10;
            return this;
        }

        public Builder l(Response r10) {
            if (r10 == null) goto L4;
            e(r10);
        L4:
            this.f22816j = r10;
            return this;
        }

        public Builder m(Protocol r10) {
            this.f22808b = r10;
            return this;
        }

        public Builder n(long r10) {
            this.f22818l = r10;
            return this;
        }

        public Builder o(String r10) {
            this.f22812f.g(r10);
            return this;
        }

        public Builder p(Request r10) {
            this.f22807a = r10;
            return this;
        }

        public Builder q(long r10) {
            this.f22817k = r10;
            return this;
        }

        public Builder(Response r10) {
            this.f22809c = -1;
            this.f22807a = r10.f22794a;
            this.f22808b = r10.f22795b;
            this.f22809c = r10.f22796c;
            this.f22810d = r10.f22797d;
            this.f22811e = r10.f22798e;
            this.f22812f = r10.f22799f.f();
            this.f22813g = r10.f22800g;
            this.f22814h = r10.f22801h;
            this.f22815i = r10.f22802i;
            this.f22816j = r10.f22803j;
            this.f22817k = r10.f22804k;
            this.f22818l = r10.f22805l;
        }
    }

    public Response(Builder r10) {
        this.f22794a = r10.f22807a;
        this.f22795b = r10.f22808b;
        this.f22796c = r10.f22809c;
        this.f22797d = r10.f22810d;
        this.f22798e = r10.f22811e;
        this.f22799f = r10.f22812f.d();
        this.f22800g = r10.f22813g;
        this.f22801h = r10.f22814h;
        this.f22802i = r10.f22815i;
        this.f22803j = r10.f22816j;
        this.f22804k = r10.f22817k;
        this.f22805l = r10.f22818l;
    }

    public ResponseBody a() {
        return this.f22800g;
    }

    public a b() {
        a r10 = this.f22806m;
        if (r10 != null) goto L7;
        a r11 = a.l(this.f22799f);
        this.f22806m = r11;
        return r11;
    L7:
        return r10;
    }

    public Response c() {
        return this.f22802i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody r10 = this.f22800g;
        if (r10 == null) goto L7;
        r10.close();
        return;
    L7:
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public int d() {
        return this.f22796c;
    }

    public Handshake e() {
        return this.f22798e;
    }

    public String f(String r10) {
        return g(r10, null);
    }

    public String g(String r10, String r11) {
        String r12 = this.f22799f.b(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r12;
    }

    public List h(String r10) {
        return this.f22799f.k(r10);
    }

    public Headers i() {
        return this.f22799f;
    }

    public boolean j() {
        int r10 = this.f22796c;
        if (r10 != 307) goto L5;
        return true;
    L5:
        if (r10 == 308) goto L11;
        switch(r10) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    public boolean k() {
        int r10 = this.f22796c;
        if (r10 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= 300) goto L7;
        return true;
    }

    public String l() {
        return this.f22797d;
    }

    public Response m() {
        return this.f22801h;
    }

    public Builder n() {
        return new Builder(this);
    }

    public Response o() {
        return this.f22803j;
    }

    public Protocol p() {
        return this.f22795b;
    }

    public long q() {
        return this.f22805l;
    }

    public Request r() {
        return this.f22794a;
    }

    public long s() {
        return this.f22804k;
    }

    public String toString() {
        return "Response{protocol=" + this.f22795b + ", code=" + this.f22796c + ", message=" + this.f22797d + ", url=" + this.f22794a.k() + '}';
    }
}
