package kotlin.coroutines.jvm.internal;

import com.stepos.minor.Minor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f17940a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final a f17941b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static a f17942c;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f17943a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f17944b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f17945c;

        public a(Method method, Method method2, Method method3) {
            this.f17943a = method;
            this.f17944b = method2;
            this.f17945c = method3;
        }
    }

    private i() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", null), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(Minor.COLUMN_NAME, null));
            f17942c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f17941b;
            f17942c = aVar3;
            return aVar3;
        }
    }

    public final String b(kotlin.coroutines.jvm.internal.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        j4.k.g(aVar, "continuation");
        a aVarA = f17942c;
        if (aVarA == null) {
            aVarA = a(aVar);
        }
        if (aVarA != f17941b && (method = aVarA.f17943a) != null && (objInvoke = method.invoke(aVar.getClass(), null)) != null && (method2 = aVarA.f17944b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = aVarA.f17945c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }
}
