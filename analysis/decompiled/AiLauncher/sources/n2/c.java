package n2;

/* loaded from: classes2.dex */
public final class c implements g2.b<InterfaceC4936a> {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f37245a = new c();
    }

    public static c a() {
        return a.f37245a;
    }

    public static InterfaceC4936a b() {
        return (InterfaceC4936a) g2.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // X8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC4936a get() {
        return b();
    }
}
