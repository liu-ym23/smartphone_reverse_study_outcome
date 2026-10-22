package e2;

import java.util.concurrent.Executor;

/* renamed from: e2.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3983j implements g2.b<Executor> {

    /* renamed from: e2.j$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C3983j f32271a = new C3983j();
    }

    public static C3983j a() {
        return a.f32271a;
    }

    public static Executor b() {
        return (Executor) g2.d.c(AbstractC3982i.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // X8.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
