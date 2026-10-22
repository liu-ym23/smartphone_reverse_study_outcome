package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class r extends u implements d {
    public final Object f;

    /* JADX WARN: Illegal instructions before constructor call */
    public r(Method method, Object obj) {
        kotlin.jvm.internal.k.f(method, "method");
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        kotlin.jvm.internal.k.e(genericParameterTypes, "getGenericParameterTypes(...)");
        super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : D7.q.d0(genericParameterTypes, 1, genericParameterTypes.length)));
        this.f = obj;
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        Z0.a aVar = new Z0.a(2);
        aVar.D(this.f);
        aVar.E(args);
        ArrayList arrayList = (ArrayList) aVar.f1582a;
        return d(null, arrayList.toArray(new Object[arrayList.size()]));
    }
}
