package l8;

import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final /* synthetic */ class k extends q7.h implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public static final k f5874n = new k(1);

    @Override // q7.c
    public final String A() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @Override // q7.c, w7.c
    public final String getName() {
        return "<init>";
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Constructor constructor = (Constructor) obj;
        q7.k.e(constructor, "p0");
        return new r(constructor);
    }

    @Override // q7.c
    public final w7.f y() {
        return q7.w.f8821a.b(r.class);
    }
}
