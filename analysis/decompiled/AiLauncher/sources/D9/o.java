package D9;

import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class o implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final JvmBuiltInsCustomizer f2308a;

    public o(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.f2308a = jvmBuiltInsCustomizer;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return JvmBuiltInsCustomizer.G(this.f2308a, (CallableMemberDescriptor) obj);
    }
}
