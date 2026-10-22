package K9;

import K9.h;
import Z9.InterfaceC1178a;
import Z9.InterfaceC1179b;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import o9.C5013a;

/* renamed from: K9.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0926g extends t implements InterfaceC1178a {

    /* renamed from: a, reason: collision with root package name */
    public final Annotation f4175a;

    public C0926g(Annotation annotation) {
        kotlin.jvm.internal.p.i(annotation, "annotation");
        this.f4175a = annotation;
    }

    @Override // Z9.InterfaceC1178a
    public boolean C() {
        return false;
    }

    public final Annotation M() {
        return this.f4175a;
    }

    @Override // Z9.InterfaceC1178a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public ReflectJavaClass b() {
        return new ReflectJavaClass(C5013a.b(C5013a.a(this.f4175a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0926g) && this.f4175a == ((C0926g) obj).f4175a;
    }

    @Override // Z9.InterfaceC1178a
    public Collection<InterfaceC1179b> g() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] declaredMethods = C5013a.b(C5013a.a(this.f4175a)).getDeclaredMethods();
        kotlin.jvm.internal.p.h(declaredMethods, "getDeclaredMethods(...)");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            h.a aVar = h.f4176b;
            Object objInvoke = method.invoke(this.f4175a, null);
            kotlin.jvm.internal.p.h(objInvoke, "invoke(...)");
            arrayList.add(aVar.a(objInvoke, ga.e.j(method.getName())));
        }
        return arrayList;
    }

    public int hashCode() {
        return System.identityHashCode(this.f4175a);
    }

    @Override // Z9.InterfaceC1178a
    public ga.b j() {
        return C0925f.e(C5013a.b(C5013a.a(this.f4175a)));
    }

    @Override // Z9.InterfaceC1178a
    public boolean k() {
        return false;
    }

    public String toString() {
        return C0926g.class.getName() + ": " + this.f4175a;
    }
}
