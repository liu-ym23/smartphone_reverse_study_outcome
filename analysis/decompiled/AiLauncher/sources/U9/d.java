package U9;

import E9.InterfaceC0797b;
import E9.O;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes5.dex */
public final class d extends e {

    /* renamed from: F, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.g f6319F;

    /* renamed from: G, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.g f6320G;

    /* renamed from: H, reason: collision with root package name */
    public final O f6321H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InterfaceC0797b ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.g getterMethod, kotlin.reflect.jvm.internal.impl.descriptors.g gVar, O overriddenProperty) {
        super(ownerDescriptor, F9.g.f2609m0.b(), getterMethod.p(), getterMethod.getVisibility(), gVar != null, overriddenProperty.getName(), getterMethod.e(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        p.i(ownerDescriptor, "ownerDescriptor");
        p.i(getterMethod, "getterMethod");
        p.i(overriddenProperty, "overriddenProperty");
        this.f6319F = getterMethod;
        this.f6320G = gVar;
        this.f6321H = overriddenProperty;
    }
}
