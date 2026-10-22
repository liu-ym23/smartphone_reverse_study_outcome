package n2;

/* loaded from: classes2.dex */
public final class d implements g2.b<InterfaceC4936a> {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f37246a = new d();
    }

    public static d a() {
        return a.f37246a;
    }

    public static InterfaceC4936a c() {
        return (InterfaceC4936a) g2.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC4936a get() {
        return c();
    }
}
