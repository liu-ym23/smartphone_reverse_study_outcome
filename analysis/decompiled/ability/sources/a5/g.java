package a5;

import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1643a;

    static {
        d dVar = new d(0);
        dVar.b = new HashMap();
        f1643a = dVar;
    }

    public static e a(Object obj) {
        d dVar = f1643a;
        dVar.getClass();
        Class<?> cls = obj.getClass();
        return dVar.h(cls.getClassLoader(), cls.getName());
    }

    public static e b(String str) {
        d dVar = f1643a;
        dVar.getClass();
        return dVar.h(d.class.getClassLoader(), str);
    }
}
