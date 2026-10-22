package l2;

/* renamed from: l2.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4866f implements g2.b<String> {

    /* renamed from: l2.f$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C4866f f36917a = new C4866f();
    }

    public static C4866f a() {
        return a.f36917a;
    }

    public static String b() {
        return (String) g2.d.c(AbstractC4865e.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // X8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
