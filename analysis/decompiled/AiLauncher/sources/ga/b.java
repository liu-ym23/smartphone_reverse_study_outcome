package ga;

import La.D;
import La.H;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f32721d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final c f32722a;

    /* renamed from: b, reason: collision with root package name */
    public final c f32723b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f32724c;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ b b(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.a(str, z10);
        }

        public final b a(String string, boolean z10) {
            String strT;
            String str;
            p.i(string, "string");
            int iT0 = H.t0(string, '`', 0, false, 6, null);
            if (iT0 == -1) {
                iT0 = string.length();
            }
            int iB0 = H.B0(string, "/", iT0, false, 4, null);
            if (iB0 == -1) {
                strT = D.T(string, "`", "", false, 4, null);
                str = "";
            } else {
                String strSubstring = string.substring(0, iB0);
                p.h(strSubstring, "substring(...)");
                String strS = D.S(strSubstring, JsonPointer.SEPARATOR, '.', false, 4, null);
                String strSubstring2 = string.substring(iB0 + 1);
                p.h(strSubstring2, "substring(...)");
                strT = D.T(strSubstring2, "`", "", false, 4, null);
                str = strS;
            }
            return new b(new c(str), new c(strT), z10);
        }

        public final b c(c topLevelFqName) {
            p.i(topLevelFqName, "topLevelFqName");
            return new b(topLevelFqName.d(), topLevelFqName.f());
        }

        public a() {
        }
    }

    public b(c packageFqName, c relativeClassName, boolean z10) {
        p.i(packageFqName, "packageFqName");
        p.i(relativeClassName, "relativeClassName");
        this.f32722a = packageFqName;
        this.f32723b = relativeClassName;
        this.f32724c = z10;
        relativeClassName.c();
    }

    public static final String c(c cVar) {
        String strA = cVar.a();
        if (!H.f0(strA, JsonPointer.SEPARATOR, false, 2, null)) {
            return strA;
        }
        return '`' + strA + '`';
    }

    public static final b k(c cVar) {
        return f32721d.c(cVar);
    }

    public final c a() {
        if (this.f32722a.c()) {
            return this.f32723b;
        }
        return new c(this.f32722a.a() + '.' + this.f32723b.a());
    }

    public final String b() {
        if (this.f32722a.c()) {
            return c(this.f32723b);
        }
        return D.S(this.f32722a.a(), '.', JsonPointer.SEPARATOR, false, 4, null) + "/" + c(this.f32723b);
    }

    public final b d(e name) {
        p.i(name, "name");
        return new b(this.f32722a, this.f32723b.b(name), this.f32724c);
    }

    public final b e() {
        c cVarD = this.f32723b.d();
        if (cVarD.c()) {
            return null;
        }
        return new b(this.f32722a, cVarD, this.f32724c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return p.d(this.f32722a, bVar.f32722a) && p.d(this.f32723b, bVar.f32723b) && this.f32724c == bVar.f32724c;
    }

    public final c f() {
        return this.f32722a;
    }

    public final c g() {
        return this.f32723b;
    }

    public final e h() {
        return this.f32723b.f();
    }

    public int hashCode() {
        return (((this.f32722a.hashCode() * 31) + this.f32723b.hashCode()) * 31) + Boolean.hashCode(this.f32724c);
    }

    public final boolean i() {
        return this.f32724c;
    }

    public final boolean j() {
        return !this.f32723b.d().c();
    }

    public String toString() {
        if (!this.f32722a.c()) {
            return b();
        }
        return JsonPointer.SEPARATOR + b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c packageFqName, e topLevelName) {
        this(packageFqName, c.f32725c.a(topLevelName), false);
        p.i(packageFqName, "packageFqName");
        p.i(topLevelName, "topLevelName");
    }
}
