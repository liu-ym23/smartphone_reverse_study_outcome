package b8;

import h8.InterfaceC1501I;
import kotlin.LazyThreadSafetyMode;

/* renamed from: b8.G, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0834G extends V implements Z7.j {
    public final Object p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0834G(AbstractC0830C abstractC0830C, InterfaceC1501I descriptor) {
        super(abstractC0830C, descriptor);
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        this.p = kotlin.a.b(LazyThreadSafetyMode.b, new I8.e(this, 14));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.m
    public final Z7.h getSetter() {
        return (C0833F) this.p.getF4884a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.j, Z7.m
    public final Z7.i getSetter() {
        return (C0833F) this.p.getF4884a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0834G(AbstractC0830C container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(signature, "signature");
        this.p = kotlin.a.b(LazyThreadSafetyMode.b, new I8.e(this, 14));
    }
}
