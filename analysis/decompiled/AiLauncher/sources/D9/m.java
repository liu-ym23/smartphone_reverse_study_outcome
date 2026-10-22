package D9;

import E9.InterfaceC0797b;
import W9.C1105n;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class m implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C1105n f2305a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0797b f2306b;

    public m(C1105n c1105n, InterfaceC0797b interfaceC0797b) {
        this.f2305a = c1105n;
        this.f2306b = interfaceC0797b;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return JvmBuiltInsCustomizer.u(this.f2305a, this.f2306b);
    }
}
