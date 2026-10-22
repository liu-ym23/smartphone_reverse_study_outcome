package com.google.protobuf;

import java.util.Map;

/* loaded from: classes3.dex */
public final class S1 implements Q1 {
    @Override // com.google.protobuf.Q1
    public final Map forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.protobuf.Q1
    public final u1.d forMapMetadata(Object obj) {
        return ((K1) obj).f2848a;
    }

    @Override // com.google.protobuf.Q1
    public final Map forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.google.protobuf.Q1
    public final int getSerializedSize(int i, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        K1 k12 = (K1) obj2;
        int iS = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            k12.getClass();
            int iR = C0980q.R(i);
            int iA = K1.a(k12.f2848a, key, value);
            iS += C0980q.S(iA) + iA + iR;
        }
        return iS;
    }

    @Override // com.google.protobuf.Q1
    public final boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).f2856a;
    }

    @Override // com.google.protobuf.Q1
    public final Object mergeFrom(Object obj, Object obj2) {
        MapFieldLite mapFieldLiteH = (MapFieldLite) obj;
        MapFieldLite mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteH.f2856a) {
                mapFieldLiteH = mapFieldLiteH.h();
            }
            mapFieldLiteH.e();
            if (!mapFieldLite.isEmpty()) {
                mapFieldLiteH.putAll(mapFieldLite);
            }
        }
        return mapFieldLiteH;
    }

    @Override // com.google.protobuf.Q1
    public final Object newMapField(Object obj) {
        return MapFieldLite.b.h();
    }

    @Override // com.google.protobuf.Q1
    public final Object toImmutable(Object obj) {
        ((MapFieldLite) obj).f2856a = false;
        return obj;
    }
}
