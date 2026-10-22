package D9;

import E9.InterfaceC0819y;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class f implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0819y f2296a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2297b;

    public f(InterfaceC0819y interfaceC0819y, boolean z10) {
        this.f2296a = interfaceC0819y;
        this.f2297b = z10;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return JvmBuiltIns.O0(this.f2296a, this.f2297b);
    }
}
