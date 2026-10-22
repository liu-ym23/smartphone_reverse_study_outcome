package b8;

import h8.InterfaceC1501I;
import h8.InterfaceC1536s;
import java.lang.reflect.Method;
import kotlin.text.Regex;
import n8.AbstractC1744c;

/* renamed from: b8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0841b implements S7.k {
    public static final C0841b b = new C0841b(0);
    public static final C0841b c = new C0841b(1);
    public static final C0841b d = new C0841b(2);
    public static final C0841b e = new C0841b(3);
    public static final C0841b f = new C0841b(4);
    public static final C0841b g = new C0841b(5);
    public static final C0841b h = new C0841b(6);
    public static final C0841b i = new C0841b(7);

    /* renamed from: j, reason: collision with root package name */
    public static final C0841b f2036j = new C0841b(8);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2037a;

    public /* synthetic */ C0841b(int i6) {
        this.f2037a = i6;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f2037a) {
            case 0:
                Class it = (Class) obj;
                O2.a aVar = AbstractC0842c.f2038a;
                kotlin.jvm.internal.k.f(it, "it");
                return new kotlin.reflect.jvm.internal.a(it);
            case 1:
                Class it2 = (Class) obj;
                O2.a aVar2 = AbstractC0842c.f2038a;
                kotlin.jvm.internal.k.f(it2, "it");
                return new kotlin.reflect.jvm.internal.b(it2);
            case 2:
                Class<?> returnType = ((Method) obj).getReturnType();
                kotlin.jvm.internal.k.e(returnType, "getReturnType(...)");
                return AbstractC1744c.b(returnType);
            case 3:
                Class cls = (Class) obj;
                kotlin.jvm.internal.k.c(cls);
                return AbstractC1744c.b(cls);
            case 4:
                InterfaceC1501I descriptor = (InterfaceC1501I) obj;
                Regex regex = AbstractC0830C.f2017a;
                kotlin.jvm.internal.k.f(descriptor, "descriptor");
                return I8.g.e.u(descriptor) + " | " + t0.b(descriptor).l();
            case 5:
                InterfaceC1536s descriptor2 = (InterfaceC1536s) obj;
                Regex regex2 = AbstractC0830C.f2017a;
                kotlin.jvm.internal.k.f(descriptor2, "descriptor");
                return I8.g.e.u(descriptor2) + " | " + t0.c(descriptor2).z();
            case 6:
                I8.g gVar = s0.f2054a;
                X8.w type = ((k8.Q) obj).getType();
                kotlin.jvm.internal.k.e(type, "getType(...)");
                return s0.d(type);
            case 7:
                I8.g gVar2 = s0.f2054a;
                X8.w type2 = ((k8.Q) obj).getType();
                kotlin.jvm.internal.k.e(type2, "getType(...)");
                return s0.d(type2);
            default:
                Class cls2 = (Class) obj;
                kotlin.jvm.internal.k.c(cls2);
                return AbstractC1744c.b(cls2);
        }
    }
}
