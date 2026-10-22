package l8;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final /* synthetic */ class m extends q7.h implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public static final m f5876n = new m(1);

    @Override // q7.c
    public final String A() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @Override // q7.c, w7.c
    public final String getName() {
        return "<init>";
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Field field = (Field) obj;
        q7.k.e(field, "p0");
        return new u(field);
    }

    @Override // q7.c
    public final w7.f y() {
        return q7.w.f8821a.b(u.class);
    }
}
