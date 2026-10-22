package l8;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class h extends f implements v8.a {

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f5869b;

    public h(e9.f fVar, Object[] objArr) {
        super(fVar);
        this.f5869b = objArr;
    }

    public final ArrayList a() {
        Object[] objArr = this.f5869b;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            q7.k.b(obj);
            Class<?> cls = obj.getClass();
            List list = d.f5857a;
            arrayList.add(Enum.class.isAssignableFrom(cls) ? new t(null, (Enum) obj) : obj instanceof Annotation ? new g(null, (Annotation) obj) : obj instanceof Object[] ? new h(null, (Object[]) obj) : obj instanceof Class ? new p(null, (Class) obj) : new v(null, obj));
        }
        return arrayList;
    }
}
