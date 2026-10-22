package l2;

/* renamed from: l2.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4868h implements g2.b<AbstractC4864d> {

    /* renamed from: l2.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C4868h f36919a = new C4868h();
    }

    public static C4868h a() {
        return a.f36919a;
    }

    public static AbstractC4864d c() {
        return (AbstractC4864d) g2.d.c(AbstractC4865e.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC4864d get() {
        return c();
    }
}
