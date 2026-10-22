package androidx.work;

import androidx.work.Data;
import h2.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends g {
    @Override // h2.g
    public final Data a(ArrayList arrayList) {
        Data.a aVar = new Data.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((Data) obj).f2769a);
            kotlin.jvm.internal.g.e(mapUnmodifiableMap, "unmodifiableMap(values)");
            linkedHashMap.putAll(mapUnmodifiableMap);
        }
        aVar.c(linkedHashMap);
        return aVar.a();
    }
}
