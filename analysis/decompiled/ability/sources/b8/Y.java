package b8;

import h8.InterfaceC1501I;
import java.lang.reflect.Member;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes4.dex */
public class Y extends i0 implements Z7.s {
    public final Object n;
    public final Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(AbstractC0830C container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(signature, "signature");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.n = kotlin.a.b(lazyThreadSafetyMode, new W(this, 0));
        this.o = kotlin.a.b(lazyThreadSafetyMode, new W(this, 1));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.s
    public final Object get(Object obj) {
        return ((X) this.n.getF4884a()).call(obj);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [C7.f, java.lang.Object] */
    @Override // Z7.s
    public final Object getDelegate(Object obj) {
        return p((Member) this.o.getF4884a(), obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.t
    public final Z7.o getGetter() {
        return (X) this.n.getF4884a();
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return get(obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // b8.i0
    public final f0 r() {
        return (X) this.n.getF4884a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // Z7.t
    public final Z7.r getGetter() {
        return (X) this.n.getF4884a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(AbstractC0830C abstractC0830C, InterfaceC1501I descriptor) {
        super(abstractC0830C, descriptor);
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.n = kotlin.a.b(lazyThreadSafetyMode, new W(this, 0));
        this.o = kotlin.a.b(lazyThreadSafetyMode, new W(this, 1));
    }
}
