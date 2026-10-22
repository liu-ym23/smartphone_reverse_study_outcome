package J9;

import E9.InterfaceC0819y;
import Y8.t;
import ba.f;
import kotlin.jvm.internal.p;
import ua.C5627m;

/* loaded from: classes5.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3800c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final C5627m f3801a;

    /* renamed from: b, reason: collision with root package name */
    public final J9.a f3802b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final k a(ClassLoader classLoader) {
            p.i(classLoader, "classLoader");
            g gVar = new g(classLoader);
            f.a aVar = ba.f.f15328b;
            ClassLoader classLoader2 = t.class.getClassLoader();
            p.h(classLoader2, "getClassLoader(...)");
            f.a.C0190a c0190aA = aVar.a(gVar, new g(classLoader2), new d(classLoader), "runtime module for " + classLoader, j.f3799b, l.f3803a);
            return new k(c0190aA.a().a(), new J9.a(c0190aA.b(), gVar), null);
        }

        public a() {
        }
    }

    public /* synthetic */ k(C5627m c5627m, J9.a aVar, kotlin.jvm.internal.i iVar) {
        this(c5627m, aVar);
    }

    public final C5627m a() {
        return this.f3801a;
    }

    public final InterfaceC0819y b() {
        return this.f3801a.q();
    }

    public final J9.a c() {
        return this.f3802b;
    }

    public k(C5627m c5627m, J9.a aVar) {
        this.f3801a = c5627m;
        this.f3802b = aVar;
    }
}
