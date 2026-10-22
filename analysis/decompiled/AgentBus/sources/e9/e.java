package e9;

import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import q7.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static final f f3190e = f.g("<root>");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f3191f = Pattern.compile("\\.");

    /* renamed from: g, reason: collision with root package name */
    public static final d f3192g = new d();

    /* renamed from: a, reason: collision with root package name */
    public final String f3193a;

    /* renamed from: b, reason: collision with root package name */
    public transient c f3194b;

    /* renamed from: c, reason: collision with root package name */
    public transient e f3195c;

    /* renamed from: d, reason: collision with root package name */
    public transient f f3196d;

    public e(String str, c cVar) {
        if (str == null) {
            a(0);
            throw null;
        }
        this.f3193a = str;
        this.f3194b = cVar;
    }

    public static /* synthetic */ void a(int i2) {
        String str;
        int i10;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
                i10 = 2;
                break;
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            default:
                i10 = 3;
                break;
        }
        Object[] objArr = new Object[i10];
        if (i2 != 1) {
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case y0.EDITION_FIELD_NUMBER /* 14 */:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public final e b(f fVar) {
        String strB;
        if (fVar == null) {
            a(9);
            throw null;
        }
        String str = this.f3193a;
        if (str.isEmpty()) {
            strB = fVar.b();
        } else {
            strB = str + "." + fVar.b();
        }
        return new e(strB, this, fVar);
    }

    public final void c() {
        String str = this.f3193a;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.f3196d = f.d(str.substring(iLastIndexOf + 1));
            this.f3195c = new e(str.substring(0, iLastIndexOf));
        } else {
            this.f3196d = f.d(str);
            this.f3195c = c.f3187c.i();
        }
    }

    public final boolean d() {
        if (this.f3194b != null) {
            return true;
        }
        String str = this.f3193a;
        if (str != null) {
            return str.indexOf(60) < 0;
        }
        a(4);
        throw null;
    }

    public final List e() {
        List list;
        String str = this.f3193a;
        if (str.isEmpty()) {
            list = Collections.EMPTY_LIST;
        } else {
            String[] strArrSplit = f3191f.split(str);
            k.e(strArrSplit, "<this>");
            k.e(f3192g, "transform");
            ArrayList arrayList = new ArrayList(strArrSplit.length);
            for (String str2 : strArrSplit) {
                arrayList.add(f.d(str2));
            }
            list = arrayList;
        }
        if (list != null) {
            return list;
        }
        a(14);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f3193a.equals(((e) obj).f3193a);
    }

    public final f f() {
        f fVar = this.f3196d;
        if (fVar != null) {
            if (fVar != null) {
                return fVar;
            }
            a(10);
            throw null;
        }
        if (this.f3193a.isEmpty()) {
            throw new IllegalStateException("root");
        }
        c();
        f fVar2 = this.f3196d;
        if (fVar2 != null) {
            return fVar2;
        }
        a(11);
        throw null;
    }

    public final c g() {
        c cVar = this.f3194b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.f3194b = cVar2;
        return cVar2;
    }

    public final int hashCode() {
        return this.f3193a.hashCode();
    }

    public final String toString() {
        String strB = this.f3193a;
        if (strB.isEmpty()) {
            strB = f3190e.b();
        }
        if (strB != null) {
            return strB;
        }
        a(17);
        throw null;
    }

    public e(String str) {
        if (str != null) {
            this.f3193a = str;
        } else {
            a(2);
            throw null;
        }
    }

    public e(String str, e eVar, f fVar) {
        if (str != null) {
            this.f3193a = str;
            this.f3195c = eVar;
            this.f3196d = fVar;
            return;
        }
        a(3);
        throw null;
    }
}
