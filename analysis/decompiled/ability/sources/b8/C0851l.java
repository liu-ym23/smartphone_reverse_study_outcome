package b8;

import java.lang.reflect.Field;
import n8.AbstractC1744c;
import q8.AbstractC1847t;

/* renamed from: b8.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0851l extends M0.i {
    public final Field k;

    public C0851l(Field field) {
        kotlin.jvm.internal.k.f(field, "field");
        this.k = field;
    }

    @Override // M0.i
    public final String l() {
        StringBuilder sb = new StringBuilder();
        Field field = this.k;
        String name = field.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        sb.append(AbstractC1847t.a(name));
        sb.append("()");
        Class<?> type = field.getType();
        kotlin.jvm.internal.k.e(type, "getType(...)");
        sb.append(AbstractC1744c.b(type));
        return sb.toString();
    }
}
