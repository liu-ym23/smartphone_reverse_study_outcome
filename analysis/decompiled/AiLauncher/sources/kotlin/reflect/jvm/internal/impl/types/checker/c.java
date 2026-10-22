package kotlin.reflect.jvm.internal.impl.types.checker;

import Ca.g;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import java.util.Collection;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import ra.InterfaceC5238k;
import ya.AbstractC6011q;
import ya.S;
import ya.v0;

/* loaded from: classes5.dex */
public abstract class c extends AbstractC6011q {

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f36099a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
        public InterfaceC0797b b(ga.b classId) {
            p.i(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
        public <S extends InterfaceC5238k> S c(InterfaceC0797b classDescriptor, InterfaceC5063a<? extends S> compute) {
            p.i(classDescriptor, "classDescriptor");
            p.i(compute, "compute");
            return compute.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
        public boolean d(InterfaceC0819y moduleDescriptor) {
            p.i(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
        public boolean e(v0 typeConstructor) {
            p.i(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
        public Collection<S> g(InterfaceC0797b classDescriptor) {
            p.i(classDescriptor, "classDescriptor");
            Collection<S> collectionE = classDescriptor.j().e();
            p.h(collectionE, "getSupertypes(...)");
            return collectionE;
        }

        @Override // ya.AbstractC6011q
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public S a(g type) {
            p.i(type, "type");
            return (S) type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public InterfaceC0797b f(InterfaceC0803h descriptor) {
            p.i(descriptor, "descriptor");
            return null;
        }
    }

    public abstract InterfaceC0797b b(ga.b bVar);

    public abstract <S extends InterfaceC5238k> S c(InterfaceC0797b interfaceC0797b, InterfaceC5063a<? extends S> interfaceC5063a);

    public abstract boolean d(InterfaceC0819y interfaceC0819y);

    public abstract boolean e(v0 v0Var);

    public abstract InterfaceC0799d f(InterfaceC0803h interfaceC0803h);

    public abstract Collection<S> g(InterfaceC0797b interfaceC0797b);

    /* renamed from: h */
    public abstract S a(g gVar);
}
