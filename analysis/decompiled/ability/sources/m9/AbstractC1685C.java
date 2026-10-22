package m9;

import n9.C1748d;

/* renamed from: m9.C, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1685C {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC1688F f5313a;

    static {
        String property;
        InterfaceC1688F interfaceC1688F;
        int i = s9.r.f6007a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            u9.d dVar = AbstractC1691I.f5315a;
            C1748d c1748d = s9.k.f6003a;
            C1748d c1748d2 = c1748d.d;
            interfaceC1688F = c1748d;
            if (c1748d == null) {
                interfaceC1688F = RunnableC1684B.h;
            }
        } else {
            interfaceC1688F = RunnableC1684B.h;
        }
        f5313a = interfaceC1688F;
    }
}
