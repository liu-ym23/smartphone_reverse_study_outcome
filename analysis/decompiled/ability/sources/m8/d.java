package m8;

import T8.o;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import java.util.ArrayList;
import kotlin.jvm.internal.k;
import n8.l;
import x8.InterfaceC2120c;

/* loaded from: classes4.dex */
public final class d implements o {
    public static final d b = new d();
    public static final d c = new d();

    @Override // T8.o
    public void a(InterfaceC1520c descriptor) {
        k.f(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }

    public f b(InterfaceC2120c javaElement) {
        k.f(javaElement, "javaElement");
        return new f((l) javaElement);
    }

    @Override // T8.o
    public void c(InterfaceC1522e interfaceC1522e, ArrayList arrayList) {
        throw new IllegalStateException("Incomplete hierarchy for class " + interfaceC1522e.getName() + ", unresolved classes " + arrayList);
    }
}
