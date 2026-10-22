package b8;

import h8.InterfaceC1501I;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes4.dex */
public class V extends i0 implements Z7.q {
    public final Object n;
    public final Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(AbstractC0830C abstractC0830C, InterfaceC1501I descriptor) {
        super(abstractC0830C, descriptor);
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.n = kotlin.a.b(lazyThreadSafetyMode, new T(this, 0));
        this.o = kotlin.a.b(lazyThreadSafetyMode, new T(this, 1));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.q
    public final Object get() {
        return ((U) this.n.getF4884a()).call(new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.q
    public final Object getDelegate() {
        return this.o.getF4884a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.t
    public final Z7.o getGetter() {
        return (U) this.n.getF4884a();
    }

    @Override // S7.a
    public final Object invoke() {
        return get();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // b8.i0
    public final f0 r() {
        return (U) this.n.getF4884a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.t
    public final Z7.p getGetter() {
        return (U) this.n.getF4884a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(AbstractC0830C container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(signature, "signature");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.n = kotlin.a.b(lazyThreadSafetyMode, new T(this, 0));
        this.o = kotlin.a.b(lazyThreadSafetyMode, new T(this, 1));
    }
}
