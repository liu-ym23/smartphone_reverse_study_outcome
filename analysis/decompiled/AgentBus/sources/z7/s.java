package z7;

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s implements w7.c, o1 {

    /* renamed from: f, reason: collision with root package name */
    public final q1 f11948f = s1.l(null, new p(this, 1));

    /* renamed from: g, reason: collision with root package name */
    public final q1 f11949g = s1.l(null, new p(this, 2));

    /* renamed from: h, reason: collision with root package name */
    public final q1 f11950h = s1.l(null, new p(this, 4));

    /* renamed from: i, reason: collision with root package name */
    public final q1 f11951i;

    public s() {
        s1.l(null, new p(this, 5));
        this.f11951i = s1.l(null, new p(this, 0));
    }

    public static Object x(m1 m1Var) throws NegativeArraySizeException {
        Class clsT = nb.i.t(n7.b.n(m1Var));
        if (clsT.isArray()) {
            Object objNewInstance = Array.newInstance(clsT.getComponentType(), 0);
            q7.k.d(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        throw new c7.i("Cannot instantiate the default empty array of type " + clsT.getSimpleName() + ", because it is not an array type", 3);
    }

    public abstract a8.h A();

    public abstract f8.c B();

    public final boolean C() {
        return q7.k.a(getName(), "<init>") && z().c().isAnnotation();
    }

    public abstract boolean D();

    @Override // w7.c
    public final w7.u f() {
        Object objC = this.f11950h.c();
        q7.k.d(objC, "_returnType()");
        return (w7.u) objC;
    }

    @Override // w7.c
    public final List getParameters() {
        Object objC = this.f11949g.c();
        q7.k.d(objC, "_parameters()");
        return (List) objC;
    }

    @Override // w7.c
    public final Object h(Object... objArr) {
        q7.k.e(objArr, "args");
        try {
            return y().h(objArr);
        } catch (IllegalAccessException e10) {
            throw new x7.a(e10);
        }
    }

    @Override // w7.c
    public final Object n(KotlinJsonAdapter.IndexedParameterMap indexedParameterMap) throws x7.a, NegativeArraySizeException {
        Object objX;
        boolean z4 = false;
        if (C()) {
            List<w7.m> parameters = getParameters();
            ArrayList arrayList = new ArrayList(d7.t.A0(parameters, 10));
            for (w7.m mVar : parameters) {
                if (indexedParameterMap.containsKey((Object) mVar)) {
                    objX = indexedParameterMap.get((Object) mVar);
                    if (objX == null) {
                        throw new IllegalArgumentException("Annotation argument value cannot be null (" + mVar + ')');
                    }
                } else {
                    u0 u0Var = (u0) mVar;
                    if (u0Var.j()) {
                        objX = null;
                    } else {
                        if (!u0Var.u()) {
                            throw new IllegalArgumentException("No argument provided for a required parameter: " + u0Var);
                        }
                        objX = x(u0Var.c());
                    }
                }
                arrayList.add(objX);
            }
            a8.h hVarA = A();
            if (hVarA != null) {
                try {
                    return hVarA.h(arrayList.toArray(new Object[0]));
                } catch (IllegalAccessException e10) {
                    throw new x7.a(e10);
                }
            }
            throw new c7.i("This callable does not support a default call: " + B(), 3);
        }
        List<w7.m> parameters2 = getParameters();
        if (parameters2.isEmpty()) {
            try {
                return y().h(o() ? new g7.d[]{null} : new g7.d[0]);
            } catch (IllegalAccessException e11) {
                throw new x7.a(e11);
            }
        }
        int size = (o() ? 1 : 0) + parameters2.size();
        Object[] objArr = (Object[]) ((Object[]) this.f11951i.c()).clone();
        if (o()) {
            objArr[parameters2.size()] = null;
        }
        int i2 = 0;
        for (w7.m mVar2 : parameters2) {
            if (indexedParameterMap.containsKey((Object) mVar2)) {
                objArr[((u0) mVar2).f11963g] = indexedParameterMap.get((Object) mVar2);
            } else {
                u0 u0Var2 = (u0) mVar2;
                if (u0Var2.j()) {
                    int i10 = (i2 / 32) + size;
                    Object obj = objArr[i10];
                    q7.k.c(obj, "null cannot be cast to non-null type kotlin.Int");
                    objArr[i10] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i2 % 32)));
                    z4 = true;
                } else if (!u0Var2.u()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + u0Var2);
                }
            }
            if (((u0) mVar2).f11964h == w7.l.f10872h) {
                i2++;
            }
        }
        if (!z4) {
            try {
                a8.h hVarY = y();
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size);
                q7.k.d(objArrCopyOf, "copyOf(this, newSize)");
                return hVarY.h(objArrCopyOf);
            } catch (IllegalAccessException e12) {
                throw new x7.a(e12);
            }
        }
        a8.h hVarA2 = A();
        if (hVarA2 != null) {
            try {
                return hVarA2.h(objArr);
            } catch (IllegalAccessException e13) {
                throw new x7.a(e13);
            }
        }
        throw new c7.i("This callable does not support a default call: " + B(), 3);
    }

    @Override // w7.b
    public final List w() {
        Object objC = this.f11948f.c();
        q7.k.d(objC, "_annotations()");
        return (List) objC;
    }

    public abstract a8.h y();

    public abstract e0 z();
}
