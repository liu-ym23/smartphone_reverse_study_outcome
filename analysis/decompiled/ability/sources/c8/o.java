package c8;

import g1.AbstractC1451a;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public abstract class o extends v {
    public final boolean e;

    /* JADX WARN: Illegal instructions before constructor call */
    public o(Field field, boolean z10, boolean z11) {
        Class TYPE = Void.TYPE;
        kotlin.jvm.internal.k.e(TYPE, "TYPE");
        super(field, TYPE, z11 ? field.getDeclaringClass() : null, new Type[]{field.getGenericType()});
        this.e = z10;
    }

    @Override // c8.v
    public void b(Object[] args) {
        kotlin.jvm.internal.k.f(args, "args");
        AbstractC1451a.r(this, args);
        if (this.e && D7.q.y0(args) == null) {
            throw new IllegalArgumentException("null is not allowed as a value for this property.");
        }
    }

    @Override // c8.e
    public Object call(Object[] args) throws IllegalAccessException, IllegalArgumentException {
        kotlin.jvm.internal.k.f(args, "args");
        b(args);
        ((Field) this.f2100a).set(this.c != null ? D7.q.k0(args) : null, D7.q.y0(args));
        return C7.r.f317a;
    }
}
