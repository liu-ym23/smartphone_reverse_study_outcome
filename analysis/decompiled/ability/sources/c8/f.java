package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class f extends v implements d {
    public final /* synthetic */ int e;
    public final Object f;

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Constructor constructor, Object obj, int i) {
        this.e = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.k.f(constructor, "constructor");
                Class declaringClass = constructor.getDeclaringClass();
                kotlin.jvm.internal.k.e(declaringClass, "getDeclaringClass(...)");
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                kotlin.jvm.internal.k.e(genericParameterTypes, "getGenericParameterTypes(...)");
                super(constructor, declaringClass, null, genericParameterTypes);
                this.f = obj;
                break;
            default:
                kotlin.jvm.internal.k.f(constructor, "constructor");
                Class declaringClass2 = constructor.getDeclaringClass();
                kotlin.jvm.internal.k.e(declaringClass2, "getDeclaringClass(...)");
                Type[] genericParameterTypes2 = constructor.getGenericParameterTypes();
                kotlin.jvm.internal.k.e(genericParameterTypes2, "getGenericParameterTypes(...)");
                super(constructor, declaringClass2, null, (Type[]) (genericParameterTypes2.length <= 2 ? new Type[0] : D7.q.d0(genericParameterTypes2, 1, genericParameterTypes2.length - 1)));
                this.f = obj;
                break;
        }
    }

    @Override // c8.e
    public final Object call(Object[] args) {
        switch (this.e) {
            case 0:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                Constructor constructor = (Constructor) this.f2100a;
                Z0.a aVar = new Z0.a(3);
                aVar.D(this.f);
                aVar.E(args);
                aVar.D(null);
                ArrayList arrayList = (ArrayList) aVar.f1582a;
                return constructor.newInstance(arrayList.toArray(new Object[arrayList.size()]));
            default:
                kotlin.jvm.internal.k.f(args, "args");
                AbstractC1451a.r(this, args);
                Constructor constructor2 = (Constructor) this.f2100a;
                Z0.a aVar2 = new Z0.a(2);
                aVar2.D(this.f);
                aVar2.E(args);
                ArrayList arrayList2 = (ArrayList) aVar2.f1582a;
                return constructor2.newInstance(arrayList2.toArray(new Object[arrayList2.size()]));
        }
    }
}
