package D9;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class i implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final JvmBuiltInsCustomizer f2301a;

    public i(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.f2301a = jvmBuiltInsCustomizer;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return JvmBuiltInsCustomizer.I(this.f2301a);
    }
}
