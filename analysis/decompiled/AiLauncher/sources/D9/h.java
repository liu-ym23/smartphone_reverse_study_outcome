package D9;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import p9.InterfaceC5063a;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public class h implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final JvmBuiltInsCustomizer f2299a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5869l f2300b;

    public h(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, InterfaceC5869l interfaceC5869l) {
        this.f2299a = jvmBuiltInsCustomizer;
        this.f2300b = interfaceC5869l;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return JvmBuiltInsCustomizer.o(this.f2299a, this.f2300b);
    }
}
