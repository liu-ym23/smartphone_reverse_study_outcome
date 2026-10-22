package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class s extends u implements d {
    public final Object[] f;

    /* JADX WARN: Illegal instructions before constructor call */
    public s(Method method, Object[] boundReceiverComponents) {
        kotlin.jvm.internal.k.f(method, "method");
        kotlin.jvm.internal.k.f(boundReceiverComponents, "boundReceiverComponents");
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        kotlin.jvm.internal.k.e(genericParameterTypes, "getGenericParameterTypes(...)");
        super(method, false, (Type[]) D7.q.e0(boundReceiverComponents.length, genericParameterTypes).toArray(new Type[0]));
        this.f = boundReceiverComponents;
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        Z0.a aVar = new Z0.a(2);
        aVar.E(this.f);
        aVar.E(args);
        ArrayList arrayList = (ArrayList) aVar.f1582a;
        return d(null, arrayList.toArray(new Object[arrayList.size()]));
    }
}
