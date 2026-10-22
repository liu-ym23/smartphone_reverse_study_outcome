package androidx.webkit;

/* JADX INFO: compiled from: WebMessageCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g[] f2977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f2979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2980d;

    private String a(int r1) {
        if (r1 != 0) goto L4;
        return "String";
    L4:
        if (r1 == 1) goto L7;
        return "Unknown";
    L7:
        return "ArrayBuffer";
    }

    public f(String r1, g[] r2) {
        this.f2978b = r1;
        this.f2979c = null;
        this.f2977a = r2;
        this.f2980d = 0;
    }

    public int getType() {
        return this.f2980d;
    }

    public String a() {
        b(0);
        return this.f2978b;
    }

    public g[] b() {
        return this.f2977a;
    }

    private void b(int r4) {
        if (r4 != this.f2980d) goto L6;
        return;
    L6:
        throw new IllegalStateException("Wrong data accessor type detected. " + a(this.f2980d) + " expected, but got " + a(r4));
    }
}
