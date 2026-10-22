package G8;

import com.fasterxml.jackson.core.JsonPointer;
import j9.m;
import j9.t;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f687a;
    public final c b;
    public final boolean c;

    public b(c packageFqName, c cVar, boolean z10) {
        k.f(packageFqName, "packageFqName");
        this.f687a = packageFqName;
        this.b = cVar;
        this.c = z10;
        cVar.d();
    }

    public static final String c(c cVar) {
        String strB = cVar.b();
        return m.i0(strB, JsonPointer.SEPARATOR) ? androidx.compose.foundation.b.m('`', "`", strB) : strB;
    }

    public final c a() {
        c cVar = this.f687a;
        boolean zD = cVar.d();
        c cVar2 = this.b;
        if (zD) {
            return cVar2;
        }
        return new c(cVar.b() + '.' + cVar2.b());
    }

    public final String b() {
        c cVar = this.f687a;
        boolean zD = cVar.d();
        c cVar2 = this.b;
        if (zD) {
            return c(cVar2);
        }
        String str = t.b0(cVar.b(), '.', JsonPointer.SEPARATOR) + "/" + c(cVar2);
        k.e(str, "toString(...)");
        return str;
    }

    public final b d(f name) {
        k.f(name, "name");
        return new b(this.f687a, this.b.c(name), this.c);
    }

    public final b e() {
        c cVarE = this.b.e();
        if (cVarE.d()) {
            return null;
        }
        return new b(this.f687a, cVarE, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.b(this.f687a, bVar.f687a) && k.b(this.b, bVar.b) && this.c == bVar.c;
    }

    public final f f() {
        f fVarF = this.b.f();
        k.e(fVarF, "shortName(...)");
        return fVarF;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.f687a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        if (!this.f687a.d()) {
            return b();
        }
        return "/" + b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c packageFqName, f topLevelName) {
        this(packageFqName, c.j(topLevelName), false);
        k.f(packageFqName, "packageFqName");
        k.f(topLevelName, "topLevelName");
    }
}
