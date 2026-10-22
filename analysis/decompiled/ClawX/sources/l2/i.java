package l2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f3785b = new i(new t1.f(20));

    /* renamed from: c, reason: collision with root package name */
    public static final i f3786c = new i(new t1.f(24));

    /* renamed from: a, reason: collision with root package name */
    public final h f3787a;

    static {
        new i(new t1.f(26));
        new i(new t1.f(25));
        new i(new t1.f(21));
        new i(new t1.f(23));
        new i(new t1.f(22));
    }

    public i(t1.f fVar) {
        if (c2.a.a()) {
            this.f3787a = new h(fVar, 2);
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            this.f3787a = new h(fVar, 0);
        } else {
            this.f3787a = new h(fVar, 1);
        }
    }
}
