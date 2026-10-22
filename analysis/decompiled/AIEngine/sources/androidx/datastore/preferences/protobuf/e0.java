package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e0 implements d0 {
    @Override // androidx.datastore.preferences.protobuf.d0
    public final MapFieldLite a(Object obj, Object obj2) {
        MapFieldLite mapFieldLiteE = (MapFieldLite) obj;
        MapFieldLite mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteE.f1761a) {
                mapFieldLiteE = mapFieldLiteE.e();
            }
            mapFieldLiteE.c();
            if (!mapFieldLite.isEmpty()) {
                mapFieldLiteE.putAll(mapFieldLite);
            }
        }
        return mapFieldLiteE;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final c0.a<?, ?> b(Object obj) {
        return ((c0) obj).f1794a;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final MapFieldLite c(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final MapFieldLite d(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final Object e(Object obj) {
        ((MapFieldLite) obj).f1761a = false;
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final MapFieldLite f() {
        return MapFieldLite.f1760b.e();
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final int g(int i10, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        c0 c0Var = (c0) obj2;
        int iE = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            c0Var.getClass();
            int iS = CodedOutputStream.s(i10);
            int iA = c0.a(c0Var.f1794a, key, value);
            iE = ai.onnxruntime.a.e(iA, iA, iS, iE);
        }
        return iE;
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public final boolean h(Object obj) {
        return !((MapFieldLite) obj).f1761a;
    }
}
