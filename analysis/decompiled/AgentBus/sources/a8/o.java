package a8;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class o extends r implements f {

    /* renamed from: g, reason: collision with root package name */
    public final Object f452g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Field field, boolean z4, Object obj) {
        super(field, z4, false);
        q7.k.e(field, "field");
        this.f452g = obj;
    }

    @Override // a8.r, a8.h
    public final Object h(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
        q7.k.e(objArr, "args");
        a(objArr);
        ((Field) this.f459a).set(this.f452g, d7.n.g0(objArr));
        return c7.r.f1986a;
    }
}
