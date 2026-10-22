package D9;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class j implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final JvmBuiltInsCustomizer f2302a;

    public j(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.f2302a = jvmBuiltInsCustomizer;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return JvmBuiltInsCustomizer.s(this.f2302a, (Pair) obj);
    }
}
