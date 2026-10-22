package L8;

import h8.InterfaceC1540w;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class j extends g {
    public final String b;

    public j(String str) {
        super(C7.r.f317a);
        this.b = str;
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        kotlin.jvm.internal.k.f(module, "module");
        return Z8.i.c(ErrorTypeKind.f5158t, this.b);
    }

    @Override // L8.g
    public final Object b() {
        throw new UnsupportedOperationException();
    }

    @Override // L8.g
    public final String toString() {
        return this.b;
    }
}
