package C9;

import E9.InterfaceC0819y;
import Z8.F;
import java.util.ServiceLoader;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1770a = a.f1771a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f1771a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Y8.h<b> f1772b = C4848b.a(LazyThreadSafetyMode.PUBLICATION, C9.a.f1769a);

        public static final b a() {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(b.class, b.class.getClassLoader());
            kotlin.jvm.internal.p.f(serviceLoaderLoad);
            b bVar = (b) F.r0(serviceLoaderLoad);
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }

        public final b c() {
            return f1772b.getValue();
        }
    }

    E9.F a(InterfaceC5869l interfaceC5869l, InterfaceC0819y interfaceC0819y, Iterable<? extends G9.b> iterable, G9.c cVar, G9.a aVar, boolean z10);
}
