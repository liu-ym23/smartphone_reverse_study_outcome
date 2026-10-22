package b8;

import h8.InterfaceC1501I;
import kotlin.LazyThreadSafetyMode;

/* renamed from: b8.K, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0838K extends b0 implements Z7.m {
    public final Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0838K(AbstractC0830C abstractC0830C, InterfaceC1501I descriptor) {
        super(abstractC0830C, descriptor);
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        this.o = kotlin.a.b(LazyThreadSafetyMode.b, new I8.e(this, 16));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.m
    public final Z7.h getSetter() {
        return (C0837J) this.o.getF4884a();
    }
}
