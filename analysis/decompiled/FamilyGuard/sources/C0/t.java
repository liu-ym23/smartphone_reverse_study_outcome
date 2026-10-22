package C0;

import C0.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import z0.C1342h;

/* loaded from: classes.dex */
public class t<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<Data> f482a;

    /* renamed from: b, reason: collision with root package name */
    private final D.e<List<Throwable>> f483b;

    /* renamed from: c, reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f484c;

    /* renamed from: d, reason: collision with root package name */
    private final String f485d;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, D.e<List<Throwable>> eVar) {
        this.f482a = cls;
        this.f483b = eVar;
        this.f484c = (List) X0.j.c(list);
        this.f485d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private v<Transcode> b(A0.e<Data> eVar, C1342h c1342h, int i5, int i6, i.a<ResourceType> aVar, List<Throwable> list) throws q {
        int size = this.f484c.size();
        v<Transcode> vVarA = null;
        for (int i7 = 0; i7 < size; i7++) {
            try {
                vVarA = this.f484c.get(i7).a(eVar, i5, i6, c1342h, aVar);
            } catch (q e6) {
                list.add(e6);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f485d, new ArrayList(list));
    }

    public v<Transcode> a(A0.e<Data> eVar, C1342h c1342h, int i5, int i6, i.a<ResourceType> aVar) {
        List<Throwable> list = (List) X0.j.d(this.f483b.b());
        try {
            return b(eVar, c1342h, i5, i6, aVar, list);
        } finally {
            this.f483b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f484c.toArray()) + '}';
    }
}
