package G9;

import E9.InterfaceC0797b;
import Z8.C1173v;
import ga.e;
import java.util.Collection;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import ya.S;

/* loaded from: classes5.dex */
public interface a {

    /* renamed from: G9.a$a, reason: collision with other inner class name */
    public static final class C0039a implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0039a f2867a = new C0039a();

        @Override // G9.a
        public Collection<S> a(InterfaceC0797b classDescriptor) {
            p.i(classDescriptor, "classDescriptor");
            return C1173v.m();
        }

        @Override // G9.a
        public Collection<g> c(e name, InterfaceC0797b classDescriptor) {
            p.i(name, "name");
            p.i(classDescriptor, "classDescriptor");
            return C1173v.m();
        }

        @Override // G9.a
        public Collection<e> d(InterfaceC0797b classDescriptor) {
            p.i(classDescriptor, "classDescriptor");
            return C1173v.m();
        }

        @Override // G9.a
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> e(InterfaceC0797b classDescriptor) {
            p.i(classDescriptor, "classDescriptor");
            return C1173v.m();
        }
    }

    Collection<S> a(InterfaceC0797b interfaceC0797b);

    Collection<g> c(e eVar, InterfaceC0797b interfaceC0797b);

    Collection<e> d(InterfaceC0797b interfaceC0797b);

    Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> e(InterfaceC0797b interfaceC0797b);
}
