package S0;

import java.util.ArrayList;
import java.util.List;
import z0.InterfaceC1338d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<C0079a<?>> f5208a = new ArrayList();

    /* renamed from: S0.a$a, reason: collision with other inner class name */
    private static final class C0079a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5209a;

        /* renamed from: b, reason: collision with root package name */
        final InterfaceC1338d<T> f5210b;

        C0079a(Class<T> cls, InterfaceC1338d<T> interfaceC1338d) {
            this.f5209a = cls;
            this.f5210b = interfaceC1338d;
        }

        boolean a(Class<?> cls) {
            return this.f5209a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, InterfaceC1338d<T> interfaceC1338d) {
        this.f5208a.add(new C0079a<>(cls, interfaceC1338d));
    }

    public synchronized <T> InterfaceC1338d<T> b(Class<T> cls) {
        for (C0079a<?> c0079a : this.f5208a) {
            if (c0079a.a(cls)) {
                return (InterfaceC1338d<T>) c0079a.f5210b;
            }
        }
        return null;
    }
}
