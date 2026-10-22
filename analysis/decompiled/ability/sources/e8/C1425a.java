package e8;

import D7.v;
import java.util.ServiceLoader;

/* renamed from: e8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1425a implements S7.a {
    public static final C1425a b = new C1425a(0);
    public static final C1425a c = new C1425a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4377a;

    public /* synthetic */ C1425a(int i) {
        this.f4377a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4377a) {
            case 0:
                C1426b c1426b = C1426b.f4378a;
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(InterfaceC1427c.class, InterfaceC1427c.class.getClassLoader());
                kotlin.jvm.internal.k.c(serviceLoaderLoad);
                InterfaceC1427c interfaceC1427c = (InterfaceC1427c) v.B0(serviceLoaderLoad);
                if (interfaceC1427c != null) {
                    return interfaceC1427c;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            default:
                e eVar = new e(new W8.i("DefaultBuiltIns"));
                eVar.c(false);
                return eVar;
        }
    }
}
