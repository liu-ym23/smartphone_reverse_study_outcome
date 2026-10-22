package G9;

import E9.InterfaceC0797b;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.g;

/* loaded from: classes5.dex */
public interface c {

    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2868a = new a();

        @Override // G9.c
        public boolean b(InterfaceC0797b classDescriptor, g functionDescriptor) {
            p.i(classDescriptor, "classDescriptor");
            p.i(functionDescriptor, "functionDescriptor");
            return true;
        }
    }

    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f2869a = new b();

        @Override // G9.c
        public boolean b(InterfaceC0797b classDescriptor, g functionDescriptor) {
            p.i(classDescriptor, "classDescriptor");
            p.i(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().E(d.a());
        }
    }

    boolean b(InterfaceC0797b interfaceC0797b, g gVar);
}
