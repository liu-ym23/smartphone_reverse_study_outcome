package z7;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class l extends s1 {

    /* renamed from: g, reason: collision with root package name */
    public final Field f11900g;

    public l(Field field) {
        q7.k.e(field, "field");
        this.f11900g = field;
    }

    @Override // z7.s1
    public final String f() {
        StringBuilder sb2 = new StringBuilder();
        Field field = this.f11900g;
        String name = field.getName();
        q7.k.d(name, "field.name");
        sb2.append(o8.w.a(name));
        sb2.append("()");
        Class<?> type = field.getType();
        q7.k.d(type, "field.type");
        sb2.append(l8.d.b(type));
        return sb2.toString();
    }
}
