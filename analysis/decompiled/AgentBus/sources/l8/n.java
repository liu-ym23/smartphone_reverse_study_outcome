package l8;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final /* synthetic */ class n extends q7.h implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public static final n f5877n = new n(1);

    @Override // q7.c
    public final String A() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @Override // q7.c, w7.c
    public final String getName() {
        return "<init>";
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        Method method = (Method) obj;
        q7.k.e(method, "p0");
        return new x(method);
    }

    @Override // q7.c
    public final w7.f y() {
        return q7.w.f8821a.b(x.class);
    }
}
