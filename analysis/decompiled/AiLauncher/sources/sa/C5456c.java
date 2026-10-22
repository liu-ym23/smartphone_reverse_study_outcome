package sa;

import kotlin.jvm.internal.p;
import ya.S;

/* renamed from: sa.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5456c extends AbstractC5454a implements InterfaceC5459f {

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.a f40175c;

    /* renamed from: d, reason: collision with root package name */
    public final ga.e f40176d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5456c(kotlin.reflect.jvm.internal.impl.descriptors.a declarationDescriptor, S receiverType, ga.e eVar, InterfaceC5460g interfaceC5460g) {
        super(receiverType, interfaceC5460g);
        p.i(declarationDescriptor, "declarationDescriptor");
        p.i(receiverType, "receiverType");
        this.f40175c = declarationDescriptor;
        this.f40176d = eVar;
    }

    @Override // sa.InterfaceC5459f
    public ga.e a() {
        return this.f40176d;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.a d() {
        return this.f40175c;
    }

    public String toString() {
        return "Cxt { " + d() + " }";
    }
}
