package a28;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import cvc.c;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1428h;

    /* JADX INFO: renamed from: a28.a$a, reason: collision with other inner class name */
    public static final class C0006a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f1430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1432d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f1433e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1434f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f1435g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f1436h;

        public C0006a() {
            this.f1431c = 253402300799999L;
            this.f1433e = HTTP.URL_DEFAULT;
        }

        public final void a(String r100) {
            if (r100 == null) goto L10;
            String r101 = c.c(r100);
            if (r101 == null) goto L8;
            this.f1432d = r101;
            this.f1436h = false;
            return;
        L8:
            throw new IllegalArgumentException("unexpected domain: ".concat(r100));
        L10:
            throw new NullPointerException("domain == null");
        }

        public final void b(long r100) {
            if (r100 > 0) goto L6;
            r100 = Long.MIN_VALUE;
        L6:
            if (r100 <= 253402300799999L) goto L8;
            r100 = 253402300799999L;
        L8:
            this.f1431c = r100;
        }

        public final void c(String r100) {
            if (r100 == null) goto L10;
            if (r100.trim().equals(r100) == false) goto L8;
            this.f1429a = r100;
            return;
        L8:
            throw new IllegalArgumentException("name is not trimmed");
        L10:
            throw new NullPointerException("name == null");
        }

        public final void d(String r100) {
            if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
            this.f1433e = r100;
            return;
        L7:
            throw new IllegalArgumentException("path must start with '/'");
        }

        public final void e(String r100) {
            if (r100 == null) goto L10;
            if (r100.trim().equals(r100) == false) goto L8;
            this.f1430b = r100;
            return;
        L8:
            throw new IllegalArgumentException("value is not trimmed");
        L10:
            throw new NullPointerException("value == null");
        }
    }

    public a(C0006a r100) {
        String r101 = r100.f1429a;
        if (r101 == null) goto L15;
        String r102 = r100.f1430b;
        if (r102 == null) goto L13;
        String r103 = r100.f1432d;
        if (r103 == null) goto L11;
        this.f1421a = r101;
        this.f1422b = r102;
        this.f1423c = r100.f1431c;
        this.f1424d = r103;
        this.f1425e = r100.f1433e;
        this.f1426f = r100.f1434f;
        this.f1427g = r100.f1435g;
        this.f1428h = r100.f1436h;
        return;
    L11:
        throw new NullPointerException("builder.domain == null");
    L13:
        throw new NullPointerException("builder.value == null");
    L15:
        throw new NullPointerException("builder.name == null");
    }
}
