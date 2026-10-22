package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.E;
import java.util.Map;

/* loaded from: classes.dex */
public class G implements F {
    public static <K, V> int a(int i10, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        E e10 = (E) obj2;
        int iA = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : mapFieldLite.entrySet()) {
            iA += e10.a(i10, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static <K, V> MapFieldLite<K, V> b(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLiteV = (MapFieldLite) obj;
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteV.s()) {
                mapFieldLiteV = mapFieldLiteV.v();
            }
            mapFieldLiteV.u(mapFieldLite);
        }
        return mapFieldLiteV;
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Map<?, ?> forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public E.a<?, ?> forMapMetadata(Object obj) {
        return ((E) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Map<?, ?> forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public int getSerializedSize(int i10, Object obj, Object obj2) {
        return a(i10, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).s();
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Object mergeFrom(Object obj, Object obj2) {
        return b(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Object newMapField(Object obj) {
        return MapFieldLite.i().v();
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Object toImmutable(Object obj) {
        ((MapFieldLite) obj).t();
        return obj;
    }
}
