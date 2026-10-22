package p7;

import java.lang.reflect.Field;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends x {

    /* renamed from: b, reason: collision with root package name */
    public o7.o f9916b;

    @Override // p7.x
    public final Object a() {
        return this.f9916b.b();
    }

    @Override // p7.x
    public final void c(Object obj, u7.a aVar, w wVar) throws IllegalAccessException, IllegalArgumentException {
        Field field = wVar.f9905b;
        Object obj2 = wVar.f9909f.read(aVar);
        if (obj2 == null && wVar.f9910g) {
            return;
        }
        if (wVar.f9911h) {
            throw new m7.h("Cannot set value of 'static final' ".concat(r7.c.d(field, false)));
        }
        field.set(obj, obj2);
    }

    @Override // p7.x
    public final Object b(Object obj) {
        return obj;
    }
}
