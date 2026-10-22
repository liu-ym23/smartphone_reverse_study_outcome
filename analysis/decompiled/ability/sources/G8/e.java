package G8;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class e {
    public static final f e = f.g("<root>");
    public static final Pattern f = Pattern.compile("\\.");
    public static final d g = new d();

    /* renamed from: a, reason: collision with root package name */
    public final String f689a;
    public transient c b;
    public transient e c;
    public transient f d;

    public e(c cVar, String str) {
        if (str == null) {
            a(0);
            throw null;
        }
        this.f689a = str;
        this.b = cVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i6;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 18:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            case 17:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 18:
                i6 = 2;
                break;
            case 9:
            case 15:
            case 16:
            case 17:
            default:
                i6 = 3;
                break;
        }
        Object[] objArr = new Object[i6];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "other";
                    break;
                case 17:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
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
            case 15:
            case 16:
            case 17:
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
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 18:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 18:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
            case 16:
                objArr[2] = "startsWith";
                break;
            case 17:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = AppAgent.CONSTRUCT;
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 18:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            case 17:
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
        String str = this.f689a;
        if (str.isEmpty()) {
            strB = fVar.b();
        } else {
            strB = str + "." + fVar.b();
        }
        return new e(strB, this, fVar);
    }

    public final void c() {
        String str = this.f689a;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.d = f.d(str.substring(iLastIndexOf + 1));
            this.c = new e(str.substring(0, iLastIndexOf));
        } else {
            this.d = f.d(str);
            this.c = c.c.i();
        }
    }

    public final boolean d() {
        if (this.b != null) {
            return true;
        }
        String str = this.f689a;
        if (str != null) {
            return str.indexOf(60) < 0;
        }
        a(4);
        throw null;
    }

    public final List e() {
        List list;
        String str = this.f689a;
        if (str.isEmpty()) {
            list = Collections.EMPTY_LIST;
        } else {
            String[] strArrSplit = f.split(str);
            k.f(strArrSplit, "<this>");
            d transform = g;
            k.f(transform, "transform");
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
        return (obj instanceof e) && this.f689a.equals(((e) obj).f689a);
    }

    public final f f() {
        f fVar = this.d;
        if (fVar != null) {
            if (fVar != null) {
                return fVar;
            }
            a(10);
            throw null;
        }
        if (this.f689a.isEmpty()) {
            throw new IllegalStateException("root");
        }
        c();
        f fVar2 = this.d;
        if (fVar2 != null) {
            return fVar2;
        }
        a(11);
        throw null;
    }

    public final c g() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.b = cVar2;
        return cVar2;
    }

    public final int hashCode() {
        return this.f689a.hashCode();
    }

    public final String toString() {
        String strB = this.f689a;
        if (strB.isEmpty()) {
            strB = e.b();
        }
        if (strB != null) {
            return strB;
        }
        a(18);
        throw null;
    }

    public e(String str) {
        if (str != null) {
            this.f689a = str;
        } else {
            a(2);
            throw null;
        }
    }

    public e(String str, e eVar, f fVar) {
        if (str != null) {
            this.f689a = str;
            this.c = eVar;
            this.d = fVar;
            return;
        }
        a(3);
        throw null;
    }
}
