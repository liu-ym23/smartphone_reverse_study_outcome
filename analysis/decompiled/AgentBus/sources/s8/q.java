package s8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class q extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9596g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r f9597h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(r rVar, int i2) {
        super(0);
        this.f9596g = i2;
        this.f9597h = rVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9596g) {
            case 0:
                r rVar = this.f9597h;
                x8.e eVar = ((r8.a) rVar.f9600m.f162f).f9013l;
                rVar.f4758j.b();
                eVar.getClass();
                return d7.e0.Z(new ArrayList());
            case 1:
                HashMap map = new HashMap();
                for (Map.Entry entry : ((Map) n7.b.q(this.f9597h.f9601n, r.f9598r[0])).entrySet()) {
                    String str = (String) entry.getKey();
                    k8.c cVar = (k8.c) entry.getValue();
                    m9.b bVarD = m9.b.d(str);
                    gb.h hVar = cVar.f5653b;
                    y8.a aVar = (y8.a) hVar.f4053c;
                    int iOrdinal = aVar.ordinal();
                    if (iOrdinal == 2) {
                        map.put(bVarD, bVarD);
                    } else if (iOrdinal == 5) {
                        String str2 = (String) hVar.f4058h;
                        if (aVar != y8.a.MULTIFILE_CLASS_PART) {
                            str2 = null;
                        }
                        if (str2 != null) {
                            map.put(bVarD, m9.b.d(str2));
                        }
                    }
                }
                return map;
            default:
                this.f9597h.f9599l.getClass();
                return new ArrayList(d7.t.A0(d7.z.f2978f, 10));
        }
    }
}
