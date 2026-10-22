package o8;

import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.n f7835a;

    /* renamed from: b, reason: collision with root package name */
    public static final f8.n f7836b;

    /* renamed from: c, reason: collision with root package name */
    public static final f8.n f7837c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f7838d;

    static {
        j8.a aVar = j8.a.f5401c;
        f8.n nVar = new f8.n(aVar, 9);
        f7835a = nVar;
        j8.c cVar = j8.c.f5403c;
        f8.n nVar2 = new f8.n(cVar, 10);
        f7836b = nVar2;
        j8.b bVar = j8.b.f5402c;
        f8.n nVar3 = new f8.n(bVar, 11);
        f7837c = nVar3;
        HashMap map = new HashMap();
        f7838d = map;
        map.put(aVar, nVar);
        map.put(cVar, nVar2);
        map.put(bVar, nVar3);
    }

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i2 == 5 || i2 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i2 == 2 || i2 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i2 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i2 != 5 && i2 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(p9.d dVar, f8.m mVar, f8.j jVar) {
        f8.m mVarT;
        if (jVar == null) {
            a(1);
            throw null;
        }
        if (mVar instanceof f8.c) {
            mVarT = h9.f.t((f8.c) mVar);
        } else {
            int i2 = h9.f.f4236a;
            mVarT = mVar;
        }
        if (c(mVarT, jVar)) {
            return true;
        }
        return f8.o.f3490c.a(dVar, mVar, jVar);
    }

    public static boolean c(f8.m mVar, f8.j jVar) {
        if (mVar == null) {
            a(2);
            throw null;
        }
        if (jVar == null) {
            a(3);
            throw null;
        }
        f8.e0 e0Var = (f8.e0) h9.f.i(mVar, f8.e0.class, false);
        f8.e0 e0Var2 = (f8.e0) h9.f.i(jVar, f8.e0.class, false);
        return (e0Var2 == null || e0Var == null || !((i8.c0) e0Var).f4758j.equals(((i8.c0) e0Var2).f4758j)) ? false : true;
    }
}
