package b8;

import X8.AbstractC0272c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1520c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.KParameter$Kind;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* renamed from: b8.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0857s implements Z7.c, n0 {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f2053a = N9.j.E(null, new C0855p(this, 0));
    public final p0 b = N9.j.E(null, new C0855p(this, 1));
    public final p0 c = N9.j.E(null, new C0855p(this, 2));
    public final p0 d = N9.j.E(null, new C0855p(this, 3));
    public final p0 e = N9.j.E(null, new C0855p(this, 4));
    public final Object f = kotlin.a.b(LazyThreadSafetyMode.b, new C0855p(this, 5));

    public static Object b(l0 l0Var) throws NegativeArraySizeException {
        Class clsZ = M.a.Z(com.stepos.statsrpk.d.B(l0Var));
        if (clsZ.isArray()) {
            Object objNewInstance = Array.newInstance(clsZ.getComponentType(), 0);
            kotlin.jvm.internal.k.e(objNewInstance, "run(...)");
            return objNewInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + clsZ.getSimpleName() + ", because it is not an array type");
    }

    @Override // Z7.c
    public final Object call(Object... args) throws IllegalCallableAccessException {
        kotlin.jvm.internal.k.f(args, "args");
        try {
            return d().call(args);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.c
    public final Object callBy(Map args) throws IllegalCallableAccessException, NegativeArraySizeException {
        boolean z10;
        Object objB;
        kotlin.jvm.internal.k.f(args, "args");
        boolean z11 = false;
        if (i()) {
            List<Z7.n> parameters = getParameters();
            ArrayList arrayList = new ArrayList(D7.w.c0(parameters, 10));
            for (Z7.n nVar : parameters) {
                if (args.containsKey(nVar)) {
                    objB = args.get(nVar);
                    if (objB == null) {
                        throw new IllegalArgumentException("Annotation argument value cannot be null (" + nVar + ')');
                    }
                } else {
                    S s5 = (S) nVar;
                    if (s5.e()) {
                        objB = null;
                    } else {
                        if (!s5.f()) {
                            throw new IllegalArgumentException("No argument provided for a required parameter: " + s5);
                        }
                        objB = b(s5.d());
                    }
                }
                arrayList.add(objB);
            }
            c8.e eVarF = f();
            if (eVarF != null) {
                try {
                    return eVarF.call(arrayList.toArray(new Object[0]));
                } catch (IllegalAccessException e) {
                    throw new IllegalCallableAccessException(e);
                }
            }
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + g());
        }
        List<Z7.n> parameters2 = getParameters();
        if (parameters2.isEmpty()) {
            try {
                return d().call(isSuspend() ? new H7.c[]{null} : new H7.c[0]);
            } catch (IllegalAccessException e6) {
                throw new IllegalCallableAccessException(e6);
            }
        }
        int size = (isSuspend() ? 1 : 0) + parameters2.size();
        Object[] objArr = (Object[]) ((Object[]) this.e.invoke()).clone();
        if (isSuspend()) {
            objArr[parameters2.size()] = null;
        }
        boolean zBooleanValue = ((Boolean) this.f.getF4884a()).booleanValue();
        int i = 0;
        for (Z7.n nVar2 : parameters2) {
            int iH = zBooleanValue ? h(nVar2) : 1;
            if (args.containsKey(nVar2)) {
                objArr[((S) nVar2).b] = args.get(nVar2);
            } else {
                S s10 = (S) nVar2;
                if (s10.e()) {
                    if (zBooleanValue) {
                        int i6 = i + iH;
                        for (int i10 = i; i10 < i6; i10++) {
                            int i11 = (i10 / 32) + size;
                            Object obj = objArr[i11];
                            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.Int");
                            objArr[i11] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i10 % 32)));
                        }
                        z10 = true;
                    } else {
                        z10 = true;
                        int i12 = (i / 32) + size;
                        Object obj2 = objArr[i12];
                        kotlin.jvm.internal.k.d(obj2, "null cannot be cast to non-null type kotlin.Int");
                        objArr[i12] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i % 32)));
                    }
                    z11 = z10;
                } else if (!s10.f()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + s10);
                }
            }
            if (((S) nVar2).c == KParameter$Kind.c) {
                i += iH;
            }
        }
        if (!z11) {
            try {
                c8.e eVarD = d();
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size);
                kotlin.jvm.internal.k.e(objArrCopyOf, "copyOf(...)");
                return eVarD.call(objArrCopyOf);
            } catch (IllegalAccessException e9) {
                throw new IllegalCallableAccessException(e9);
            }
        }
        c8.e eVarF2 = f();
        if (eVarF2 != null) {
            try {
                return eVarF2.call(objArr);
            } catch (IllegalAccessException e10) {
                throw new IllegalCallableAccessException(e10);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + g());
    }

    public abstract c8.e d();

    public abstract AbstractC0830C e();

    public abstract c8.e f();

    public abstract InterfaceC1520c g();

    @Override // Z7.b
    public final List getAnnotations() {
        Object objInvoke = this.f2053a.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // Z7.c
    public final List getParameters() {
        Object objInvoke = this.b.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // Z7.c
    public final Z7.u getReturnType() {
        Object objInvoke = this.c.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "invoke(...)");
        return (Z7.u) objInvoke;
    }

    @Override // Z7.c
    public final List getTypeParameters() {
        Object objInvoke = this.d.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "invoke(...)");
        return (List) objInvoke;
    }

    @Override // Z7.c
    public final KVisibility getVisibility() {
        C1531n visibility = g().getVisibility();
        kotlin.jvm.internal.k.e(visibility, "getVisibility(...)");
        G8.c cVar = v0.f2060a;
        if (visibility.equals(AbstractC1532o.e)) {
            return KVisibility.f4932a;
        }
        if (visibility.equals(AbstractC1532o.c)) {
            return KVisibility.b;
        }
        if (visibility.equals(AbstractC1532o.d)) {
            return KVisibility.c;
        }
        if (visibility.equals(AbstractC1532o.f4583a) || visibility.equals(AbstractC1532o.b)) {
            return KVisibility.d;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    public final int h(Z7.n nVar) {
        if (!((Boolean) this.f.getF4884a()).booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before");
        }
        S s5 = (S) nVar;
        if (!v0.h(s5.d())) {
            return 1;
        }
        ArrayList arrayListI = H4.o.I(AbstractC0272c.b(s5.d().f2046a));
        kotlin.jvm.internal.k.c(arrayListI);
        return arrayListI.size();
    }

    public final boolean i() {
        return kotlin.jvm.internal.k.b(getName(), AppAgent.CONSTRUCT) && e().b().isAnnotation();
    }

    @Override // Z7.c
    public final boolean isAbstract() {
        return g().i() == Modality.e;
    }

    @Override // Z7.c
    public final boolean isFinal() {
        return g().i() == Modality.b;
    }

    @Override // Z7.c
    public final boolean isOpen() {
        return g().i() == Modality.d;
    }

    public abstract boolean n();
}
