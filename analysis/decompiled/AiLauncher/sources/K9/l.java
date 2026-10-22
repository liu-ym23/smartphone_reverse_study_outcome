package K9;

import K9.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class l extends h implements Z9.e {

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f4179c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ga.e eVar, Object[] values) {
        super(eVar, null);
        kotlin.jvm.internal.p.i(values, "values");
        this.f4179c = values;
    }

    @Override // Z9.e
    public List<h> c() {
        Object[] objArr = this.f4179c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            h.a aVar = h.f4176b;
            kotlin.jvm.internal.p.f(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
