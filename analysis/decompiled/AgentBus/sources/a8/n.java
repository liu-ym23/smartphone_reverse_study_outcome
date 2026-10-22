package a8;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class n extends w {
    /* JADX WARN: Illegal instructions before constructor call */
    public n(Field field, boolean z4) {
        Type genericType = field.getGenericType();
        q7.k.d(genericType, "field.genericType");
        super(field, genericType, z4 ? field.getDeclaringClass() : null, new Type[0]);
    }

    @Override // a8.h
    public Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        a(objArr);
        return ((Field) this.f459a).get(this.f461c != null ? d7.n.g0(objArr) : null);
    }
}
