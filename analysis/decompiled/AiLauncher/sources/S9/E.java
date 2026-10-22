package S9;

import ga.b;

/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public static final E f5678a = new E();

    /* renamed from: b, reason: collision with root package name */
    public static final ga.c f5679b;

    /* renamed from: c, reason: collision with root package name */
    public static final ga.b f5680c;

    /* renamed from: d, reason: collision with root package name */
    public static final ga.b f5681d;

    /* renamed from: e, reason: collision with root package name */
    public static final ga.b f5682e;

    static {
        ga.c cVar = new ga.c("kotlin.jvm.JvmField");
        f5679b = cVar;
        b.a aVar = ga.b.f32721d;
        f5680c = aVar.c(cVar);
        f5681d = aVar.c(new ga.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        f5682e = b.a.b(aVar, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);
    }

    public static final String b(String propertyName) {
        kotlin.jvm.internal.p.i(propertyName, "propertyName");
        if (f(propertyName)) {
            return propertyName;
        }
        return "get" + Ga.a.a(propertyName);
    }

    public static final boolean c(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return La.D.X(name, "get", false, 2, null) || La.D.X(name, "is", false, 2, null);
    }

    public static final boolean d(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return La.D.X(name, "set", false, 2, null);
    }

    public static final String e(String propertyName) {
        String strA;
        kotlin.jvm.internal.p.i(propertyName, "propertyName");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set");
        if (f(propertyName)) {
            strA = propertyName.substring(2);
            kotlin.jvm.internal.p.h(strA, "substring(...)");
        } else {
            strA = Ga.a.a(propertyName);
        }
        sb2.append(strA);
        return sb2.toString();
    }

    public static final boolean f(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        if (!La.D.X(name, "is", false, 2, null) || name.length() == 2) {
            return false;
        }
        char cCharAt = name.charAt(2);
        return kotlin.jvm.internal.p.k(97, cCharAt) > 0 || kotlin.jvm.internal.p.k(cCharAt, 122) > 0;
    }

    public final ga.b a() {
        return f5682e;
    }
}
