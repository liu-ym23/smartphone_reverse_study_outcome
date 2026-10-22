package okhttp3.internal.e;

import d.h.b.o;

/* JADX INFO: compiled from: HttpMethod.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f39923a = null;

    static {
        f39923a = new f();
    }

    private f() {
    }

    public final boolean a(String r1) {
        o.e(r1, "method");
        if (o.a(r1, "POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (o.a(r1, "PATCH") == true) goto L14;
        if (o.a(r1, "PUT") == true) goto L14;
        if (o.a(r1, "DELETE") == true) goto L14;
        if (o.a(r1, "MOVE") == true) goto L14;
        return false;
    }

    public static final boolean b(String r1) {
        o.e(r1, "method");
        if (o.a(r1, "POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (o.a(r1, "PUT") == true) goto L14;
        if (o.a(r1, "PATCH") == true) goto L14;
        if (o.a(r1, "PROPPATCH") == true) goto L14;
        if (o.a(r1, "REPORT") == true) goto L14;
        return false;
    }

    public static final boolean c(String r1) {
        o.e(r1, "method");
        if (o.a(r1, "GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r1, "HEAD") == true) goto L7;
        return true;
    }

    public final boolean d(String r1) {
        o.e(r1, "method");
        return o.a(r1, "PROPFIND");
    }

    public final boolean e(String r1) {
        o.e(r1, "method");
        return !o.a(r1, "PROPFIND");
    }
}
