package l8;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* loaded from: classes.dex */
public final class u extends w {

    /* renamed from: a, reason: collision with root package name */
    public final Field f5884a;

    public u(Field field) {
        q7.k.e(field, "member");
        this.f5884a = field;
    }

    @Override // l8.w
    public final Member b() {
        return this.f5884a;
    }
}
