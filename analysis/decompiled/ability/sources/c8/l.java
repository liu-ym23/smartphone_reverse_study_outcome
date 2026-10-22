package c8;

import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public final class l extends o implements d {
    public final Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Field field, boolean z10, Object obj) {
        super(field, z10, false);
        kotlin.jvm.internal.k.f(field, "field");
        this.f = obj;
    }

    @Override // c8.o, c8.e
    public final Object call(Object[] args) throws IllegalAccessException, IllegalArgumentException {
        kotlin.jvm.internal.k.f(args, "args");
        b(args);
        ((Field) this.f2100a).set(this.f, D7.q.k0(args));
        return C7.r.f317a;
    }
}
