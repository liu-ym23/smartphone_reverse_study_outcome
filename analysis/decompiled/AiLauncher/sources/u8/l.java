package u8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u8.k;

/* loaded from: classes4.dex */
public class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends Yb.u>, u> f42490a;

    public static class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<Class<? extends Yb.u>, u> f42491a = new HashMap(3);

        @Override // u8.k.a
        public <N extends Yb.u> k.a a(Class<N> cls, u uVar) {
            if (uVar == null) {
                this.f42491a.remove(cls);
                return this;
            }
            this.f42491a.put(cls, uVar);
            return this;
        }

        @Override // u8.k.a
        public <N extends Yb.u> k.a b(Class<N> cls, u uVar) {
            u uVar2 = this.f42491a.get(cls);
            if (uVar2 == null) {
                this.f42491a.put(cls, uVar);
                return this;
            }
            if (uVar2 instanceof b) {
                ((b) uVar2).f42492a.add(0, uVar);
                return this;
            }
            this.f42491a.put(cls, new b(uVar, uVar2));
            return this;
        }

        @Override // u8.k.a
        public k build() {
            return new l(Collections.unmodifiableMap(this.f42491a));
        }
    }

    public static class b implements u {

        /* renamed from: a, reason: collision with root package name */
        public final List<u> f42492a;

        public b(u uVar, u uVar2) {
            ArrayList arrayList = new ArrayList(3);
            this.f42492a = arrayList;
            arrayList.add(uVar);
            arrayList.add(uVar2);
        }

        @Override // u8.u
        public Object a(g gVar, r rVar) {
            int size = this.f42492a.size();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = this.f42492a.get(i10).a(gVar, rVar);
            }
            return objArr;
        }
    }

    public l(Map<Class<? extends Yb.u>, u> map) {
        this.f42490a = map;
    }

    @Override // u8.k
    public <N extends Yb.u> u a(Class<N> cls) {
        u uVar = get(cls);
        if (uVar != null) {
            return uVar;
        }
        throw new NullPointerException(cls.getName());
    }

    @Override // u8.k
    public <N extends Yb.u> u get(Class<N> cls) {
        return this.f42490a.get(cls);
    }
}
