package n8;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import x8.InterfaceC2118a;

/* loaded from: classes4.dex */
public final class g extends e implements InterfaceC2118a {
    public final Object[] b;

    public g(G8.f fVar, Object[] objArr) {
        super(fVar);
        this.b = objArr;
    }

    public final ArrayList a() {
        Object[] objArr = this.b;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            kotlin.jvm.internal.k.c(obj);
            Class<?> cls = obj.getClass();
            List list = AbstractC1744c.f5355a;
            arrayList.add(Enum.class.isAssignableFrom(cls) ? new m(null, (Enum) obj) : obj instanceof Annotation ? new f(null, (Annotation) obj) : obj instanceof Object[] ? new g(null, (Object[]) obj) : obj instanceof Class ? new i(null, (Class) obj) : new o(null, obj));
        }
        return arrayList;
    }
}
