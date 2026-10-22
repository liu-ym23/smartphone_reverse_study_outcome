package com.bytedance.location.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
class MapFieldSchemaLite implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object mapField) {
        return (MapFieldLite) mapField;
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object mapDefaultEntry) {
        return ((MapEntryLite) mapDefaultEntry).getMetadata();
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object mapField) {
        return (MapFieldLite) mapField;
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public boolean isImmutable(Object mapField) {
        return !((MapFieldLite) mapField).isMutable();
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public Object toImmutable(Object mapField) {
        ((MapFieldLite) mapField).makeImmutable();
        return mapField;
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public Object newMapField(Object unused) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public Object mergeFrom(Object destMapField, Object srcMapField) {
        return mergeFromLite(destMapField, srcMapField);
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object destMapField, Object srcMapField) {
        MapFieldLite<K, V> mine = (MapFieldLite) destMapField;
        MapFieldLite<K, V> other = (MapFieldLite) srcMapField;
        if (other.isEmpty() == false) goto L5;
    L8:
        return mine;
    L5:
        if (mine.isMutable() == true) goto L7;
        mine = mine.mutableCopy();
    L7:
        mine.mergeFrom(other);
        goto L8
    }

    @Override // com.bytedance.location.protobuf.MapFieldSchema
    public int getSerializedSize(int fieldNumber, Object mapField, Object mapDefaultEntry) {
        return getSerializedSizeLite(fieldNumber, mapField, mapDefaultEntry);
    }

    private static <K, V> int getSerializedSizeLite(int fieldNumber, Object mapField, Object defaultEntry) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) mapField;
        MapEntryLite<K, V> defaultEntryLite = (MapEntryLite) defaultEntry;
        if (mapFieldLite.isEmpty() == false) goto L6;
        return 0;
    L6:
        int size = 0;
        Iterator<Map.Entry<K, V>> r3 = mapFieldLite.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<K, V> entry = r3.next();
        size = size + defaultEntryLite.computeMessageSize(fieldNumber, entry.getKey(), entry.getValue());
        goto L8
    L10:
        return size;
    }
}
