package e9;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f3187c = new c("");

    /* renamed from: a, reason: collision with root package name */
    public final e f3188a;

    /* renamed from: b, reason: collision with root package name */
    public transient c f3189b;

    public c(String str) {
        if (str != null) {
            this.f3188a = new e(str, this);
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i10 = 2;
                break;
            case 8:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            case 8:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static c j(f fVar) {
        if (fVar != null) {
            return new c(new e(fVar.b(), f3187c.i(), fVar));
        }
        a(13);
        throw null;
    }

    public final String b() {
        String str = this.f3188a.f3193a;
        if (str != null) {
            return str;
        }
        e.a(4);
        throw null;
    }

    public final c c(f fVar) {
        if (fVar != null) {
            return new c(this.f3188a.b(fVar), this);
        }
        a(8);
        throw null;
    }

    public final boolean d() {
        return this.f3188a.f3193a.isEmpty();
    }

    public final c e() {
        c cVar = this.f3189b;
        if (cVar != null) {
            return cVar;
        }
        if (d()) {
            throw new IllegalStateException("root");
        }
        e eVar = this.f3188a;
        e eVar2 = eVar.f3195c;
        if (eVar2 == null) {
            if (eVar.f3193a.isEmpty()) {
                throw new IllegalStateException("root");
            }
            eVar.c();
            eVar2 = eVar.f3195c;
            if (eVar2 == null) {
                e.a(8);
                throw null;
            }
        }
        c cVar2 = new c(eVar2);
        this.f3189b = cVar2;
        return cVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f3188a.equals(((c) obj).f3188a);
    }

    public final f f() {
        f fVarF = this.f3188a.f();
        if (fVarF != null) {
            return fVarF;
        }
        a(9);
        throw null;
    }

    public final f g() {
        e eVar = this.f3188a;
        if (eVar.f3193a.isEmpty()) {
            f fVar = e.f3190e;
            if (fVar != null) {
                return fVar;
            }
            e.a(12);
            throw null;
        }
        f fVarF = eVar.f();
        if (fVarF != null) {
            return fVarF;
        }
        e.a(13);
        throw null;
    }

    public final boolean h(f fVar) {
        if (fVar == null) {
            a(12);
            throw null;
        }
        String str = this.f3188a.f3193a;
        if (str.isEmpty()) {
            return false;
        }
        int iIndexOf = str.indexOf(46);
        String strB = fVar.b();
        if (iIndexOf == -1) {
            iIndexOf = Math.max(str.length(), strB.length());
        }
        return str.regionMatches(0, strB, 0, iIndexOf);
    }

    public final int hashCode() {
        return this.f3188a.f3193a.hashCode();
    }

    public final e i() {
        e eVar = this.f3188a;
        if (eVar != null) {
            return eVar;
        }
        a(5);
        throw null;
    }

    public final String toString() {
        return this.f3188a.toString();
    }

    public c(e eVar) {
        this.f3188a = eVar;
    }

    public c(e eVar, c cVar) {
        this.f3188a = eVar;
        this.f3189b = cVar;
    }
}
