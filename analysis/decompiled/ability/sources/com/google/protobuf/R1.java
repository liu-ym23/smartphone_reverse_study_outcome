package com.google.protobuf;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class R1 implements Q1 {
    @Override // com.google.protobuf.Q1
    public final Map forMapData(Object obj) {
        return ((O1) obj).M();
    }

    @Override // com.google.protobuf.Q1
    public final u1.d forMapMetadata(Object obj) {
        return ((J1) obj).d;
    }

    @Override // com.google.protobuf.Q1
    public final Map forMutableMapData(Object obj) {
        return ((O1) obj).N();
    }

    @Override // com.google.protobuf.Q1
    public final int getSerializedSize(int i, Object obj, Object obj2) {
        int iS = 0;
        if (obj != null) {
            Map mapM = ((O1) obj).M();
            J1 j12 = (J1) obj2;
            if (!mapM.isEmpty()) {
                for (Map.Entry entry : mapM.entrySet()) {
                    int iR = C0980q.R(i);
                    int iA = K1.a(j12.d, entry.getKey(), entry.getValue());
                    iS += C0980q.S(iA) + iA + iR;
                }
                return iS;
            }
        }
        return 0;
    }

    @Override // com.google.protobuf.Q1
    public final boolean isImmutable(Object obj) {
        return !((O1) obj).c;
    }

    @Override // com.google.protobuf.Q1
    public final Object mergeFrom(Object obj, Object obj2) {
        O1 o12 = (O1) obj;
        O1 o13 = (O1) obj2;
        if (!o12.c) {
            new O1(o12.g, MapFieldLite.d(o12.M()));
        }
        o12.N().putAll(MapFieldLite.d(o13.M()));
        return o12;
    }

    @Override // com.google.protobuf.Q1
    public final Object newMapField(Object obj) {
        return new O1((J1) obj, new LinkedHashMap());
    }

    @Override // com.google.protobuf.Q1
    public final Object toImmutable(Object obj) {
        ((O1) obj).c = false;
        return obj;
    }
}
