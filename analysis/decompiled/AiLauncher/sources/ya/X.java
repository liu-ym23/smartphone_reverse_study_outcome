package ya;

import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class X implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.types.checker.c f44060a;

    /* renamed from: b, reason: collision with root package name */
    public final Y f44061b;

    public X(kotlin.reflect.jvm.internal.impl.types.checker.c cVar, Y y10) {
        this.f44060a = cVar;
        this.f44061b = y10;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return Y.P0(this.f44060a, this.f44061b);
    }
}
