package D9;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import p9.InterfaceC5063a;
import xa.InterfaceC5869l;

/* loaded from: classes5.dex */
public class e implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final JvmBuiltIns f2294a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5869l f2295b;

    public e(JvmBuiltIns jvmBuiltIns, InterfaceC5869l interfaceC5869l) {
        this.f2294a = jvmBuiltIns;
        this.f2295b = interfaceC5869l;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return JvmBuiltIns.J0(this.f2294a, this.f2295b);
    }
}
