package c8;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public abstract class k extends v {
    /* JADX WARN: Illegal instructions before constructor call */
    public k(Field field, boolean z10) {
        Type genericType = field.getGenericType();
        kotlin.jvm.internal.k.e(genericType, "getGenericType(...)");
        super(field, genericType, z10 ? field.getDeclaringClass() : null, new Type[0]);
    }

    @Override // c8.e
    public Object call(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        b(args);
        return ((Field) this.f2100a).get(this.c != null ? D7.q.k0(args) : null);
    }
}
