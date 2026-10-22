package a8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i extends w implements f {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f447e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f448f;

    /* JADX WARN: Illegal instructions before constructor call */
    public i(Constructor constructor, Object obj, int i2) {
        this.f447e = i2;
        switch (i2) {
            case 1:
                Class declaringClass = constructor.getDeclaringClass();
                q7.k.d(declaringClass, "constructor.declaringClass");
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                q7.k.d(genericParameterTypes, "constructor.genericParameterTypes");
                super(constructor, declaringClass, null, genericParameterTypes);
                this.f448f = obj;
                break;
            default:
                Class declaringClass2 = constructor.getDeclaringClass();
                q7.k.d(declaringClass2, "constructor.declaringClass");
                Type[] genericParameterTypes2 = constructor.getGenericParameterTypes();
                q7.k.d(genericParameterTypes2, "constructor.genericParameterTypes");
                super(constructor, declaringClass2, null, (Type[]) (genericParameterTypes2.length <= 2 ? new Type[0] : d7.n.c0(genericParameterTypes2, 1, genericParameterTypes2.length - 1)));
                this.f448f = obj;
                break;
        }
    }

    @Override // a8.h
    public final Object h(Object[] objArr) {
        switch (this.f447e) {
            case 0:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                Constructor constructor = (Constructor) this.f459a;
                ab.m mVar = new ab.m(3);
                mVar.a(this.f448f);
                mVar.c(objArr);
                mVar.a(null);
                ArrayList arrayList = mVar.f577f;
                return constructor.newInstance(arrayList.toArray(new Object[arrayList.size()]));
            default:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                Constructor constructor2 = (Constructor) this.f459a;
                ab.m mVar2 = new ab.m(2);
                mVar2.a(this.f448f);
                mVar2.c(objArr);
                ArrayList arrayList2 = mVar2.f577f;
                return constructor2.newInstance(arrayList2.toArray(new Object[arrayList2.size()]));
        }
    }
}
