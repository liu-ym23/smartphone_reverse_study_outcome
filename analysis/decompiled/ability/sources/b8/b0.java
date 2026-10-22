package b8;

import h8.InterfaceC1501I;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes4.dex */
public class b0 extends i0 implements S7.n {
    public final Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(AbstractC0830C abstractC0830C, InterfaceC1501I descriptor) {
        super(abstractC0830C, descriptor);
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.n = kotlin.a.b(lazyThreadSafetyMode, new Z(this, 0));
        kotlin.a.b(lazyThreadSafetyMode, new Z(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.t
    public final Z7.o getGetter() {
        return (a0) this.n.getF4884a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((a0) this.n.getF4884a()).call(obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // b8.i0
    public final f0 r() {
        return (a0) this.n.getF4884a();
    }
}
