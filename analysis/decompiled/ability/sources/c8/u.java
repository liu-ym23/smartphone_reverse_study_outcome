package c8;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class u extends v {
    public final boolean e;

    public /* synthetic */ u(Method method, boolean z10, int i) {
        this(method, (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z10, method.getGenericParameterTypes());
    }

    public final Object d(Object obj, Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        return this.e ? C7.r.f317a : ((Method) this.f2100a).invoke(obj, Arrays.copyOf(args, args.length));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public u(Method method, boolean z10, Type[] typeArr) {
        Type genericReturnType = method.getGenericReturnType();
        kotlin.jvm.internal.k.e(genericReturnType, "getGenericReturnType(...)");
        super(method, genericReturnType, z10 ? method.getDeclaringClass() : null, typeArr);
        this.e = genericReturnType.equals(Void.TYPE);
    }
}
