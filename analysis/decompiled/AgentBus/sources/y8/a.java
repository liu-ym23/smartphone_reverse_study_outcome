package y8;

import d7.e0;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public enum a {
    UNKNOWN(0),
    CLASS(1),
    FILE_FACADE(2),
    SYNTHETIC_CLASS(3),
    MULTIFILE_CLASS(4),
    MULTIFILE_CLASS_PART(5);


    /* renamed from: g, reason: collision with root package name */
    public static final LinkedHashMap f11698g;

    /* renamed from: f, reason: collision with root package name */
    public final int f11706f;

    static {
        a[] aVarArrValues = values();
        int iS = e0.S(aVarArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS < 16 ? 16 : iS);
        for (a aVar : aVarArrValues) {
            linkedHashMap.put(Integer.valueOf(aVar.f11706f), aVar);
        }
        f11698g = linkedHashMap;
    }

    a(int i2) {
        this.f11706f = i2;
    }
}
