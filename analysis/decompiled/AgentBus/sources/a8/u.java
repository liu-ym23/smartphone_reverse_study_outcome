package a8;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u extends r implements f {

    /* renamed from: g, reason: collision with root package name */
    public final Object f457g;

    /* JADX WARN: Illegal instructions before constructor call */
    public u(Object obj, Method method) {
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        q7.k.d(genericParameterTypes, "method.genericParameterTypes");
        super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : d7.n.c0(genericParameterTypes, 1, genericParameterTypes.length)));
        this.f457g = obj;
    }

    @Override // a8.r, a8.h
    public final Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        g.checkArguments(this, objArr);
        ab.m mVar = new ab.m(2);
        mVar.a(this.f457g);
        mVar.c(objArr);
        ArrayList arrayList = mVar.f577f;
        return c(arrayList.toArray(new Object[arrayList.size()]), null);
    }
}
