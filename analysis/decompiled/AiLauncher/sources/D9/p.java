package D9;

import E9.InterfaceC0797b;
import Ia.b;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;

/* loaded from: classes5.dex */
public class p implements b.c {

    /* renamed from: a, reason: collision with root package name */
    public final JvmBuiltInsCustomizer f2309a;

    public p(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.f2309a = jvmBuiltInsCustomizer;
    }

    @Override // Ia.b.c
    public Iterable a(Object obj) {
        return JvmBuiltInsCustomizer.B(this.f2309a, (InterfaceC0797b) obj);
    }
}
