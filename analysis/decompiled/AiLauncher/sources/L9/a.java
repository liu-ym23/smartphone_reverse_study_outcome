package L9;

import E9.E;
import E9.InterfaceC0797b;
import M9.b;
import M9.c;
import ga.e;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class a {
    public static final void a(c cVar, b from, InterfaceC0797b scopeOwner, e name) {
        p.i(cVar, "<this>");
        p.i(from, "from");
        p.i(scopeOwner, "scopeOwner");
        p.i(name, "name");
        if (cVar == c.a.f4661a) {
            return;
        }
        from.getLocation();
    }

    public static final void b(c cVar, b from, E scopeOwner, e name) {
        p.i(cVar, "<this>");
        p.i(from, "from");
        p.i(scopeOwner, "scopeOwner");
        p.i(name, "name");
        String strA = scopeOwner.f().a();
        String strB = name.b();
        p.h(strB, "asString(...)");
        c(cVar, from, strA, strB);
    }

    public static final void c(c cVar, b from, String packageFqName, String name) {
        p.i(cVar, "<this>");
        p.i(from, "from");
        p.i(packageFqName, "packageFqName");
        p.i(name, "name");
        if (cVar == c.a.f4661a) {
            return;
        }
        from.getLocation();
    }
}
