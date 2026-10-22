package C0;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import z0.C1342h;

/* loaded from: classes.dex */
public class i<DataType, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<DataType> f389a;

    /* renamed from: b, reason: collision with root package name */
    private final List<? extends z0.i<DataType, ResourceType>> f390b;

    /* renamed from: c, reason: collision with root package name */
    private final P0.e<ResourceType, Transcode> f391c;

    /* renamed from: d, reason: collision with root package name */
    private final D.e<List<Throwable>> f392d;

    /* renamed from: e, reason: collision with root package name */
    private final String f393e;

    interface a<ResourceType> {
        v<ResourceType> a(v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends z0.i<DataType, ResourceType>> list, P0.e<ResourceType, Transcode> eVar, D.e<List<Throwable>> eVar2) {
        this.f389a = cls;
        this.f390b = list;
        this.f391c = eVar;
        this.f392d = eVar2;
        this.f393e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private v<ResourceType> b(A0.e<DataType> eVar, int i5, int i6, C1342h c1342h) {
        List<Throwable> list = (List) X0.j.d(this.f392d.b());
        try {
            return c(eVar, i5, i6, c1342h, list);
        } finally {
            this.f392d.a(list);
        }
    }

    private v<ResourceType> c(A0.e<DataType> eVar, int i5, int i6, C1342h c1342h, List<Throwable> list) throws q {
        int size = this.f390b.size();
        v<ResourceType> vVarA = null;
        for (int i7 = 0; i7 < size; i7++) {
            z0.i<DataType, ResourceType> iVar = this.f390b.get(i7);
            try {
                if (iVar.b(eVar.a(), c1342h)) {
                    vVarA = iVar.a(eVar.a(), i5, i6, c1342h);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e6) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + iVar, e6);
                }
                list.add(e6);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.f393e, new ArrayList(list));
    }

    public v<Transcode> a(A0.e<DataType> eVar, int i5, int i6, C1342h c1342h, a<ResourceType> aVar) {
        return this.f391c.a(aVar.a(b(eVar, i5, i6, c1342h)), c1342h);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f389a + ", decoders=" + this.f390b + ", transcoder=" + this.f391c + '}';
    }
}
