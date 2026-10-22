package w7;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final /* synthetic */ class z extends q7.i implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public static final z f10881n = new z(1, e0.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);

    @Override // p7.k
    public final Object invoke(Object obj) {
        Type type = (Type) obj;
        q7.k.e(type, "p0");
        return e0.d(type);
    }
}
