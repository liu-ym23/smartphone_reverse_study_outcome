package Aa;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.S;
import E9.W;
import E9.b0;
import E9.i0;
import H9.AbstractC0839s;
import H9.O;
import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.E0;

/* loaded from: classes5.dex */
public final class b extends O {

    public static final class a implements e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> {
        public a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> a() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> b(List<? extends i0> parameters) {
            p.i(parameters, "parameters");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> c() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> d(E0 substitution) {
            p.i(substitution, "substitution");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public <V> e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> e(a.InterfaceC0437a<V> userDataKey, V v10) {
            p.i(userDataKey, "userDataKey");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> f(S s10) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> g() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> h(F9.g additionalAnnotations) {
            p.i(additionalAnnotations, "additionalAnnotations");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> i(Modality modality) {
            p.i(modality, "modality");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> j() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> k(S s10) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> l(CallableMemberDescriptor callableMemberDescriptor) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> m(boolean z10) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> n(ga.e name) {
            p.i(name, "name");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> o(ya.S type) {
            p.i(type, "type");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> p(List<? extends b0> parameters) {
            p.i(parameters, "parameters");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> q(CallableMemberDescriptor.Kind kind) {
            p.i(kind, "kind");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> r(AbstractC0811p visibility) {
            p.i(visibility, "visibility");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> s(InterfaceC0803h owner) {
            p.i(owner, "owner");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> t() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e.a
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.g build() {
            return b.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InterfaceC0797b containingDeclaration) {
        super(containingDeclaration, null, F9.g.f2609m0.b(), ga.e.m(ErrorEntity.ERROR_FUNCTION.getDebugText()), CallableMemberDescriptor.Kind.DECLARATION, W.f2444a);
        p.i(containingDeclaration, "containingDeclaration");
        L0(null, null, C1173v.m(), C1173v.m(), C1173v.m(), i.d(ErrorTypeKind.RETURN_TYPE_FOR_FUNCTION, new String[0]), Modality.OPEN, C0810o.f2473e);
    }

    @Override // H9.O, H9.AbstractC0839s
    public AbstractC0839s F0(InterfaceC0803h newOwner, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, CallableMemberDescriptor.Kind kind, ga.e eVar2, F9.g annotations, W source) {
        p.i(newOwner, "newOwner");
        p.i(kind, "kind");
        p.i(annotations, "annotations");
        p.i(source, "source");
        return this;
    }

    @Override // H9.O, H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.g y(InterfaceC0803h newOwner, Modality modality, AbstractC0811p visibility, CallableMemberDescriptor.Kind kind, boolean z10) {
        p.i(newOwner, "newOwner");
        p.i(modality, "modality");
        p.i(visibility, "visibility");
        p.i(kind, "kind");
        return this;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isSuspend() {
        return false;
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V o0(a.InterfaceC0437a<V> key) {
        p.i(key, "key");
        return null;
    }

    @Override // H9.O, H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.g
    public e.a<kotlin.reflect.jvm.internal.impl.descriptors.g> s() {
        return new a();
    }

    @Override // H9.AbstractC0839s, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void x0(Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        p.i(overriddenDescriptors, "overriddenDescriptors");
    }
}
