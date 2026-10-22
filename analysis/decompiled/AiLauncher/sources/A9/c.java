package A9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1289a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1290b;

    /* renamed from: c, reason: collision with root package name */
    public final Y8.h f1291c;

    /* renamed from: d, reason: collision with root package name */
    public final Y8.h f1292d;

    /* renamed from: e, reason: collision with root package name */
    public final List f1293e;

    public c(Class cls, Map map, Y8.h hVar, Y8.h hVar2, List list) {
        this.f1289a = cls;
        this.f1290b = map;
        this.f1291c = hVar;
        this.f1292d = hVar2;
        this.f1293e = list;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return e.o(this.f1289a, this.f1290b, this.f1291c, this.f1292d, this.f1293e, obj, method, objArr);
    }
}
