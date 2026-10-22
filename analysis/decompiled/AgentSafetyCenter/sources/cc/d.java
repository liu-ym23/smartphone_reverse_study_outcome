package cc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: c, reason: collision with root package name */
    public static final a f2262c;

    static {
        Integer num = tb.a.f13292a;
        f2262c = (num == null || num.intValue() >= 34) ? new dc.a() : new b();
    }

    public abstract long a();

    public long b() {
        long jA;
        long j10;
        do {
            jA = a() >>> 1;
            j10 = jA % 136000;
        } while ((jA - j10) + 135999 < 0);
        return 45000 + j10;
    }
}
