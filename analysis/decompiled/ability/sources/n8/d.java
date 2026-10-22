package n8;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class d extends l {

    /* renamed from: a, reason: collision with root package name */
    public final Annotation f5356a;

    public d(Annotation annotation) {
        kotlin.jvm.internal.k.f(annotation, "annotation");
        this.f5356a = annotation;
    }

    public final ArrayList b() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Annotation annotation = this.f5356a;
        Method[] declaredMethods = M.a.Z(M.a.V(annotation)).getDeclaredMethods();
        kotlin.jvm.internal.k.e(declaredMethods, "getDeclaredMethods(...)");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            Object objInvoke = method.invoke(annotation, null);
            kotlin.jvm.internal.k.e(objInvoke, "invoke(...)");
            G8.f fVarE = G8.f.e(method.getName());
            Class<?> cls = objInvoke.getClass();
            List list = AbstractC1744c.f5355a;
            arrayList.add(Enum.class.isAssignableFrom(cls) ? new m(fVarE, (Enum) objInvoke) : objInvoke instanceof Annotation ? new f(fVarE, (Annotation) objInvoke) : objInvoke instanceof Object[] ? new g(fVarE, (Object[]) objInvoke) : objInvoke instanceof Class ? new i(fVarE, (Class) objInvoke) : new o(fVarE, objInvoke));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f5356a == ((d) obj).f5356a;
        }
        return false;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5356a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.z(sb, d.class, ": ");
        sb.append(this.f5356a);
        return sb.toString();
    }
}
