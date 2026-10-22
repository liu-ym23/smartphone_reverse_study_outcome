package I1;

import com.alibaba.fastjson.JSONArray;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class i extends J1.d {

    /* renamed from: e, reason: collision with root package name */
    public final Type f3322e;

    /* renamed from: f, reason: collision with root package name */
    public J1.f f3323f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3324g;

    public i(l lVar, Class<?> cls, L1.a aVar) {
        super(cls, aVar, 14);
        Type type = aVar.f4268h;
        Class<?> cls2 = aVar.f4267g;
        if (cls2.isArray()) {
            this.f3322e = cls2.getComponentType();
            this.f3324g = true;
        } else {
            this.f3322e = L1.d.y(type);
            this.f3324g = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // J1.d
    public void b(b bVar, Object obj, Type type, Map<String, Object> map) {
        ArrayList arrayList;
        JSONArray jSONArray;
        d dVar = bVar.f3258e;
        int iA0 = dVar.a0();
        if (iA0 == 8 || (iA0 == 4 && dVar.X().length() == 0)) {
            g(obj, null);
            bVar.f3258e.s();
            return;
        }
        if (this.f3324g) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.S(this.f3322e);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new ArrayList();
            jSONArray = null;
        }
        k kVar = bVar.f3259f;
        bVar.a1(kVar, obj, this.f3694a.f4261a);
        h(bVar, type, arrayList);
        bVar.b1(kVar);
        Object obj2 = arrayList;
        if (this.f3324g) {
            Object array = arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f3322e, arrayList.size()));
            jSONArray.T(array);
            obj2 = array;
        }
        if (obj == null) {
            map.put(this.f3694a.f4261a, obj2);
        } else {
            g(obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(I1.b r19, java.lang.reflect.Type r20, java.util.Collection r21) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.i.h(I1.b, java.lang.reflect.Type, java.util.Collection):void");
    }
}
