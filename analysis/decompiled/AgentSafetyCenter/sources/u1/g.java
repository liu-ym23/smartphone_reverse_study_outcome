package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements b1.j {

    /* renamed from: a, reason: collision with root package name */
    public static final g f13787a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f13788b;

    @Override // b1.j
    public final boolean a() {
        Boolean bool = f13788b;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw w2.c.a("canFocus is read before it is written");
    }

    @Override // b1.j
    public final void c(boolean z10) {
        f13788b = Boolean.valueOf(z10);
    }
}
