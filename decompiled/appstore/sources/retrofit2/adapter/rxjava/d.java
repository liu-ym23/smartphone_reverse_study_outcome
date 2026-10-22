package retrofit2.adapter.rxjava;

import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Response f23993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f23994b;

    public d(Response r10, Throwable r11) {
        this.f23993a = r10;
        this.f23994b = r11;
    }

    public static d a(Throwable r10) {
        if (r10 == null) goto L6;
        return new d(null, r10);
    L6:
        throw new NullPointerException("error == null");
    }

    public static d b(Response r10) {
        if (r10 == null) goto L6;
        return new d(r10, null);
    L6:
        throw new NullPointerException("response == null");
    }

    public String toString() {
        if (this.f23994b == null) goto L7;
        return "Result{isError=true, error=\"" + this.f23994b + "\"}";
    L7:
        return "Result{isError=false, response=" + this.f23993a + '}';
    }
}
