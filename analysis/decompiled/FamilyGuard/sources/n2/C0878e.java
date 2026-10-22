package n2;

import C4.A;
import C4.x;
import java.util.concurrent.TimeUnit;
import m2.C0861d;
import o2.InterfaceC0901b;

/* renamed from: n2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0878e {

    /* renamed from: a, reason: collision with root package name */
    private static A f18920a;

    public static A a(InterfaceC0901b interfaceC0901b) {
        return b(interfaceC0901b, null);
    }

    public static A b(InterfaceC0901b interfaceC0901b, x xVar) {
        return c(interfaceC0901b, xVar, 30L, 30L, 30L);
    }

    public static A c(InterfaceC0901b interfaceC0901b, x xVar, long j5, long j6, long j7) {
        A.b bVar = new A.b();
        if (interfaceC0901b != null) {
            bVar.f(interfaceC0901b.getContext().getSocketFactory(), interfaceC0901b.a());
        }
        if (xVar != null) {
            bVar.a(xVar);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        bVar.c(j5, timeUnit).e(j6, timeUnit).g(j7, timeUnit).b();
        return bVar.b();
    }

    public static A d() {
        InterfaceC0901b interfaceC0901bA;
        if (f18920a == null) {
            synchronized (C0861d.class) {
                if (f18920a == null) {
                    try {
                        interfaceC0901bA = o2.c.a();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        interfaceC0901bA = null;
                    }
                    f18920a = a(interfaceC0901bA);
                }
            }
        }
        return f18920a;
    }
}
