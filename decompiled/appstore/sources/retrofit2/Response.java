package retrofit2;

import okhttp3.Headers;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
public final class Response<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.Response f23961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f23962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResponseBody f23963c;

    public Response(okhttp3.Response r10, Object r11, ResponseBody r12) {
        this.f23961a = r10;
        this.f23962b = r11;
        this.f23963c = r12;
    }

    public static Response c(ResponseBody r10, okhttp3.Response r11) {
        i.b(r10, "body == null");
        i.b(r11, "rawResponse == null");
        if (r11.k() == true) goto L7;
        return new Response(r11, null, r10);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static Response i(Object r10, okhttp3.Response r11) {
        i.b(r11, "rawResponse == null");
        if (r11.k() == false) goto L7;
        return new Response(r11, r10, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public Object a() {
        return this.f23962b;
    }

    public int b() {
        return this.f23961a.d();
    }

    public ResponseBody d() {
        return this.f23963c;
    }

    public Headers e() {
        return this.f23961a.i();
    }

    public boolean f() {
        return this.f23961a.k();
    }

    public String g() {
        return this.f23961a.l();
    }

    public okhttp3.Response h() {
        return this.f23961a;
    }

    public String toString() {
        return this.f23961a.toString();
    }
}
