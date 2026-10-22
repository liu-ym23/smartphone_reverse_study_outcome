package a8;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class k extends n implements f {

    /* renamed from: e, reason: collision with root package name */
    public final Object f450e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Field field, Object obj) {
        super(field, false);
        q7.k.e(field, "field");
        this.f450e = obj;
    }

    @Override // a8.n, a8.h
    public final Object h(Object[] objArr) {
        q7.k.e(objArr, "args");
        g.checkArguments(this, objArr);
        return ((Field) this.f459a).get(this.f450e);
    }
}
