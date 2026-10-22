package c8;

import java.util.ServiceLoader;

/* loaded from: classes.dex */
public final class a extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f1989g = new a(0);

    @Override // p7.a
    public final Object c() {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(c.class, c.class.getClassLoader());
        q7.k.d(serviceLoaderLoad, "implementations");
        c cVar = (c) d7.r.O0(serviceLoaderLoad);
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
    }
}
