package l8;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends s {

    /* renamed from: a, reason: collision with root package name */
    public final Annotation f5865a;

    public e(Annotation annotation) {
        q7.k.e(annotation, "annotation");
        this.f5865a = annotation;
    }

    public final ArrayList b() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Annotation annotation = this.f5865a;
        Method[] declaredMethods = nb.i.t(nb.i.p(annotation)).getDeclaredMethods();
        q7.k.d(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            Object objInvoke = method.invoke(annotation, null);
            q7.k.d(objInvoke, "method.invoke(annotation)");
            e9.f fVarE = e9.f.e(method.getName());
            Class<?> cls = objInvoke.getClass();
            List list = d.f5857a;
            arrayList.add(Enum.class.isAssignableFrom(cls) ? new t(fVarE, (Enum) objInvoke) : objInvoke instanceof Annotation ? new g(fVarE, (Annotation) objInvoke) : objInvoke instanceof Object[] ? new h(fVarE, (Object[]) objInvoke) : objInvoke instanceof Class ? new p(fVarE, (Class) objInvoke) : new v(fVarE, objInvoke));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f5865a == ((e) obj).f5865a;
        }
        return false;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5865a);
    }

    public final String toString() {
        return e.class.getName() + ": " + this.f5865a;
    }
}
