package j4;

import org.libpag.BuildConfig;
import p4.InterfaceC0929b;
import p4.InterfaceC0930c;
import p4.InterfaceC0931d;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static final x f17837a;

    /* renamed from: b, reason: collision with root package name */
    private static final InterfaceC0929b[] f17838b;

    static {
        x xVar = null;
        try {
            xVar = (x) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (xVar == null) {
            xVar = new x();
        }
        f17837a = xVar;
        f17838b = new InterfaceC0929b[0];
    }

    public static InterfaceC0931d a(i iVar) {
        return f17837a.a(iVar);
    }

    public static InterfaceC0929b b(Class cls) {
        return f17837a.b(cls);
    }

    public static InterfaceC0930c c(Class cls) {
        return f17837a.c(cls, BuildConfig.FLAVOR);
    }

    public static p4.f d(n nVar) {
        return f17837a.d(nVar);
    }

    public static p4.g e(p pVar) {
        return f17837a.e(pVar);
    }

    public static String f(h hVar) {
        return f17837a.f(hVar);
    }

    public static String g(l lVar) {
        return f17837a.g(lVar);
    }
}
