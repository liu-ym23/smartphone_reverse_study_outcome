package P9;

import N9.o;
import N9.q;
import N9.r;
import N9.s;
import N9.u;
import Z8.F;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.C4848b;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;

/* loaded from: classes5.dex */
public interface n {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5383a = a.f5384a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5384a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Y8.h<List<n>> f5385b = C4848b.b(m.f5382a);

        public static final List a() {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(n.class, n.class.getClassLoader());
            p.h(serviceLoaderLoad, "load(...)");
            List listM1 = F.m1(serviceLoaderLoad);
            if (listM1.isEmpty()) {
                throw new IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
            return listM1;
        }

        public final List<n> c() {
            return f5385b.getValue();
        }
    }

    i a();

    d b();

    void c(N9.g gVar, ProtoBuf$Constructor protoBuf$Constructor, O9.d dVar);

    void d(u uVar, ProtoBuf$ValueParameter protoBuf$ValueParameter, O9.d dVar);

    void e(N9.d dVar, ProtoBuf$Class protoBuf$Class, O9.d dVar2);

    void f(N9.l lVar, ProtoBuf$EnumEntry protoBuf$EnumEntry, O9.d dVar);

    b g();

    void h(o oVar, ProtoBuf$Property protoBuf$Property, O9.d dVar);

    c i();

    h j();

    void k(q qVar, ProtoBuf$Type protoBuf$Type, O9.d dVar);

    j l();

    void m(N9.n nVar, ProtoBuf$Function protoBuf$Function, O9.d dVar);

    void n(s sVar, ProtoBuf$TypeParameter protoBuf$TypeParameter, O9.d dVar);

    void o(r rVar, ProtoBuf$TypeAlias protoBuf$TypeAlias, O9.d dVar);

    g p();

    k q();

    l r();
}
