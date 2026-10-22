package okhttp3;

import java.util.List;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: loaded from: classes4.dex */
public final class Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpUrl f22776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Headers f22778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RequestBody f22779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f22780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile okhttp3.a f22782g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpUrl f22783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Headers.Builder f22785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RequestBody f22786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f22787e;

        public a() {
            this.f22784b = "GET";
            this.f22785c = new Headers.Builder();
        }

        public a a(String r10, String r11) {
            this.f22785c.a(r10, r11);
            return this;
        }

        public Request b() {
            if (this.f22783a == null) goto L7;
            return new Request(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public a c(okhttp3.a r10) {
            String r11 = r10.toString();
            if (r11.isEmpty() == false) goto L7;
            return h("Cache-Control");
        L7:
            return d("Cache-Control", r11);
        }

        public a d(String r10, String r11) {
            this.f22785c.h(r10, r11);
            return this;
        }

        public a e(Headers r10) {
            this.f22785c = r10.f();
            return this;
        }

        public a f(String r10, RequestBody r11) {
            if (r10 == null) goto L23;
            if (r10.length() == 0) goto L21;
            if (r11 != null) goto L8;
        L12:
            if (r11 == null) goto L14;
        L18:
            this.f22784b = r10;
            this.f22786d = r11;
            return this;
        L14:
            if (HttpMethod.requiresRequestBody(r10) == false) goto L18;
            throw new IllegalArgumentException("method " + r10 + " must have a request body.");
        L8:
            if (HttpMethod.permitsRequestBody(r10) == true) goto L12;
            throw new IllegalArgumentException("method " + r10 + " must not have a request body.");
        L21:
            throw new IllegalArgumentException("method.length() == 0");
        L23:
            throw new NullPointerException("method == null");
        }

        public a g(RequestBody r10) {
            return f("POST", r10);
        }

        public a h(String r10) {
            this.f22785c.g(r10);
            return this;
        }

        public a i(Object r10) {
            this.f22787e = r10;
            return this;
        }

        public a j(String r10) {
            if (r10 == null) goto L16;
            if (r10.regionMatches(true, 0, "ws:", 0, 3) == false) goto L7;
            r10 = "http:" + r10.substring(3);
        L9:
            HttpUrl r11 = HttpUrl.r(r10);
            if (r11 == null) goto L14;
            return k(r11);
        L14:
            throw new IllegalArgumentException("unexpected url: " + r10);
        L7:
            if (r10.regionMatches(true, 0, "wss:", 0, 4) == false) goto L9;
            r10 = "https:" + r10.substring(4);
            goto L9
        L16:
            throw new NullPointerException("url == null");
        }

        public a k(HttpUrl r10) {
            if (r10 == null) goto L6;
            this.f22783a = r10;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        public a(Request r10) {
            this.f22783a = r10.f22776a;
            this.f22784b = r10.f22777b;
            this.f22786d = r10.f22779d;
            this.f22787e = r10.f22780e;
            this.f22785c = r10.f22778c.f();
        }
    }

    public Request(a r10) {
        this.f22776a = r10.f22783a;
        this.f22777b = r10.f22784b;
        this.f22778c = r10.f22785c.d();
        this.f22779d = r10.f22786d;
        Object r11 = r10.f22787e;
        if (r11 != null) goto L6;
        r11 = this;
    L6:
        this.f22780e = r11;
    }

    public RequestBody a() {
        return this.f22779d;
    }

    public okhttp3.a b() {
        okhttp3.a r10 = this.f22782g;
        if (r10 != null) goto L7;
        okhttp3.a r11 = okhttp3.a.l(this.f22778c);
        this.f22782g = r11;
        return r11;
    L7:
        return r10;
    }

    public String c(String r10) {
        return this.f22778c.b(r10);
    }

    public List d(String r10) {
        return this.f22778c.k(r10);
    }

    public Headers e() {
        return this.f22778c;
    }

    public boolean f() {
        return this.f22776a.n();
    }

    public String g() {
        return this.f22777b;
    }

    public a h() {
        return new a(this);
    }

    public void i(String r10) {
        this.f22781f = r10;
    }

    public Object j() {
        return this.f22780e;
    }

    public HttpUrl k() {
        return this.f22776a;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Request{method=");
        r10.append(this.f22777b);
        r10.append(", url=");
        r10.append(this.f22776a);
        r10.append(", tag=");
        Object r11 = this.f22780e;
        if (r11 != this) goto L6;
        r11 = null;
    L6:
        r10.append(r11);
        r10.append('}');
        return r10.toString();
    }
}
