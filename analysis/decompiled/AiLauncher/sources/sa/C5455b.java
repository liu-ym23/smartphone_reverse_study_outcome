package sa;

import E9.InterfaceC0797b;
import kotlin.jvm.internal.p;
import ya.S;

/* renamed from: sa.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5455b extends AbstractC5454a implements InterfaceC5459f {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0797b f40173c;

    /* renamed from: d, reason: collision with root package name */
    public final ga.e f40174d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5455b(InterfaceC0797b classDescriptor, S receiverType, ga.e eVar, InterfaceC5460g interfaceC5460g) {
        super(receiverType, interfaceC5460g);
        p.i(classDescriptor, "classDescriptor");
        p.i(receiverType, "receiverType");
        this.f40173c = classDescriptor;
        this.f40174d = eVar;
    }

    @Override // sa.InterfaceC5459f
    public ga.e a() {
        return this.f40174d;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.f40173c + " }";
    }
}
