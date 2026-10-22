package kotlin.reflect.jvm.internal.impl.builtins.functions;

import C9.o;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final ga.c f34963a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34964b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f34965c;

    /* renamed from: d, reason: collision with root package name */
    public final ga.b f34966d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f34967e;

    public static final class a extends e {

        /* renamed from: f, reason: collision with root package name */
        public static final a f34968f = new a();

        public a() {
            super(o.f1810B, "Function", false, null, true);
        }
    }

    public static final class b extends e {

        /* renamed from: f, reason: collision with root package name */
        public static final b f34969f = new b();

        public b() {
            super(o.f1844y, "KFunction", true, null, false);
        }
    }

    public static final class c extends e {

        /* renamed from: f, reason: collision with root package name */
        public static final c f34970f = new c();

        public c() {
            super(o.f1844y, "KSuspendFunction", true, null, false);
        }
    }

    public static final class d extends e {

        /* renamed from: f, reason: collision with root package name */
        public static final d f34971f = new d();

        public d() {
            super(o.f1838s, "SuspendFunction", false, null, true);
        }
    }

    public e(ga.c packageFqName, String classNamePrefix, boolean z10, ga.b bVar, boolean z11) {
        p.i(packageFqName, "packageFqName");
        p.i(classNamePrefix, "classNamePrefix");
        this.f34963a = packageFqName;
        this.f34964b = classNamePrefix;
        this.f34965c = z10;
        this.f34966d = bVar;
        this.f34967e = z11;
    }

    public final String a() {
        return this.f34964b;
    }

    public final ga.c b() {
        return this.f34963a;
    }

    public final ga.e c(int i10) {
        ga.e eVarJ = ga.e.j(this.f34964b + i10);
        p.h(eVarJ, "identifier(...)");
        return eVarJ;
    }

    public String toString() {
        return this.f34963a + '.' + this.f34964b + 'N';
    }
}
