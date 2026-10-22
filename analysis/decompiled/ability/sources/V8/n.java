package V8;

import H8.AbstractC0242c;
import X8.w;
import b8.C0862x;
import b8.v0;
import h8.C1504L;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import k8.AbstractC1639h;
import k8.C1638g;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

/* loaded from: classes4.dex */
public final class n implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1399a;
    public final Object b;
    public final Object c;
    public final Object d;

    public /* synthetic */ n(Object obj, Object obj2, Object obj3, int i) {
        this.f1399a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1399a) {
            case 0:
                return ((AbstractC0242c) ((H8.t) this.b)).b((ByteArrayInputStream) this.c, ((p) this.d).b.f1228a.p);
            case 1:
                w wVar = (w) this.b;
                C0862x c0862x = (C0862x) this.c;
                kotlin.reflect.jvm.internal.a aVar = (kotlin.reflect.jvm.internal.a) this.d;
                InterfaceC1524g interfaceC1524gD = wVar.Q().d();
                if (!(interfaceC1524gD instanceof InterfaceC1522e)) {
                    throw new KotlinReflectionInternalError("Supertype not a class: " + interfaceC1524gD);
                }
                Class clsK = v0.k((InterfaceC1522e) interfaceC1524gD);
                if (clsK == null) {
                    throw new KotlinReflectionInternalError("Unsupported superclass of " + c0862x + ": " + interfaceC1524gD);
                }
                Class cls = aVar.b;
                if (kotlin.jvm.internal.k.b(cls.getSuperclass(), clsK)) {
                    Type genericSuperclass = cls.getGenericSuperclass();
                    kotlin.jvm.internal.k.c(genericSuperclass);
                    return genericSuperclass;
                }
                Class<?>[] interfaces = cls.getInterfaces();
                kotlin.jvm.internal.k.e(interfaces, "getInterfaces(...)");
                int iU0 = D7.q.u0(interfaces, clsK);
                if (iU0 >= 0) {
                    Type type = cls.getGenericInterfaces()[iU0];
                    kotlin.jvm.internal.k.c(type);
                    return type;
                }
                throw new KotlinReflectionInternalError("No superclass of " + c0862x + " in Java reflection for " + interfaceC1524gD);
            default:
                return new C1638g((AbstractC1639h) this.d, (W8.l) this.b, (C1504L) this.c);
        }
    }

    public n(AbstractC1639h abstractC1639h, W8.l lVar, C1504L c1504l) {
        this.f1399a = 2;
        this.d = abstractC1639h;
        this.b = lVar;
        this.c = c1504l;
    }
}
