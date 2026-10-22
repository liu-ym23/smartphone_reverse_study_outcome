package K9;

import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public class p implements InterfaceC5074l {

    /* renamed from: a, reason: collision with root package name */
    public final ReflectJavaClass f4186a;

    public p(ReflectJavaClass reflectJavaClass) {
        this.f4186a = reflectJavaClass;
    }

    @Override // p9.InterfaceC5074l
    public Object invoke(Object obj) {
        return Boolean.valueOf(ReflectJavaClass.O(this.f4186a, (Method) obj));
    }
}
