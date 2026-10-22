package Z8;

import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1518a;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import h8.InterfaceC1535r;
import h8.InterfaceC1536s;
import i8.InterfaceC1561g;
import java.util.Collection;
import k8.K;
import k8.t;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes4.dex */
public final class b extends K {
    @Override // k8.t
    /* renamed from: S0 */
    public final K U(InterfaceC1527j newOwner, Modality modality, C1531n visibility) {
        k.f(newOwner, "newOwner");
        k.f(visibility, "visibility");
        return this;
    }

    @Override // k8.K, k8.t
    public final t T0(G8.f fVar, InterfaceC1527j newOwner, InterfaceC1536s interfaceC1536s, InterfaceC1503K interfaceC1503K, InterfaceC1561g annotations, CallableMemberDescriptor$Kind kind) {
        k.f(newOwner, "newOwner");
        k.f(kind, "kind");
        k.f(annotations, "annotations");
        return this;
    }

    @Override // k8.t, h8.InterfaceC1520c
    public final /* bridge */ /* synthetic */ InterfaceC1520c U(InterfaceC1522e interfaceC1522e, Modality modality, C1531n c1531n) {
        U(interfaceC1522e, modality, c1531n);
        return this;
    }

    @Override // k8.t, h8.InterfaceC1536s
    public final boolean isSuspend() {
        return false;
    }

    @Override // k8.t, h8.InterfaceC1520c
    public final void u0(Collection overriddenDescriptors) {
        k.f(overriddenDescriptors, "overriddenDescriptors");
    }

    @Override // k8.t, h8.InterfaceC1519b
    public final Object v0(InterfaceC1518a interfaceC1518a) {
        return null;
    }

    @Override // k8.K, k8.t, h8.InterfaceC1536s
    public final InterfaceC1535r x0() {
        return new Z0.a(this);
    }
}
