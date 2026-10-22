package ya;

import p9.InterfaceC5063a;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public final class Y extends L0 {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5869l f44062b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5063a<S> f44063c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h<S> f44064d;

    /* JADX WARN: Multi-variable type inference failed */
    public Y(InterfaceC5869l storageManager, InterfaceC5063a<? extends S> computation) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(computation, "computation");
        this.f44062b = storageManager;
        this.f44063c = computation;
        this.f44064d = storageManager.i(computation);
    }

    public static final S P0(kotlin.reflect.jvm.internal.impl.types.checker.c cVar, Y y10) {
        return cVar.a(y10.f44063c.invoke());
    }

    @Override // ya.L0
    public S L0() {
        return this.f44064d.invoke();
    }

    @Override // ya.L0
    public boolean M0() {
        return this.f44064d.s();
    }

    @Override // ya.S
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public Y R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new Y(this.f44062b, new X(kotlinTypeRefiner, this));
    }
}
