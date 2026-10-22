package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class MapFieldSchemaFull implements MapFieldSchema {
    MapFieldSchemaFull() {
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object r2) {
        return ((MapField) ZeusTransformUtils.preCheckCast(r2, MapField.class, "com.obric.aiagent.plugin")).getMutableMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object r2) {
        return ((MapField) ZeusTransformUtils.preCheckCast(r2, MapField.class, "com.obric.aiagent.plugin")).getMap();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public boolean isImmutable(Object r2) {
        return !((MapField) ZeusTransformUtils.preCheckCast(r2, MapField.class, "com.obric.aiagent.plugin")).isMutable();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object toImmutable(Object r2) {
        ((MapField) ZeusTransformUtils.preCheckCast(r2, MapField.class, "com.obric.aiagent.plugin")).makeImmutable();
        return r2;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object newMapField(Object r2) {
        return MapField.newMapField((MapEntry) ZeusTransformUtils.preCheckCast(r2, MapEntry.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.google.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object r2) {
        return ((MapEntry) ZeusTransformUtils.preCheckCast(r2, MapEntry.class, "com.obric.aiagent.plugin")).getMetadata();
    }

    @Override // com.google.protobuf.MapFieldSchema
    public Object mergeFrom(Object r1, Object r2) {
        return mergeFromFull(r1, r2);
    }

    private static <K, V> Object mergeFromFull(Object r2, Object r3) {
        MapField r4 = (MapField) ZeusTransformUtils.preCheckCast(r2, MapField.class, "com.obric.aiagent.plugin");
        MapField<K, V> r5 = (MapField) ZeusTransformUtils.preCheckCast(r3, MapField.class, "com.obric.aiagent.plugin");
        if (r4.isMutable() == true) goto L5;
        r4.copy();
    L5:
        r4.mergeFrom(r5);
        return r4;
    }

    @Override // com.google.protobuf.MapFieldSchema
    public int getSerializedSize(int r1, Object r2, Object r3) {
        return getSerializedSizeFull(r1, r2, r3);
    }

    private static <K, V> int getSerializedSizeFull(int r6, Object r7, Object r8) {
        int r0 = 0;
        if (r7 != null) goto L5;
        return 0;
    L5:
        Map<K, V> r9 = ((MapField) ZeusTransformUtils.preCheckCast(r7, MapField.class, "com.obric.aiagent.plugin")).getMap();
        MapEntry r10 = (MapEntry) ZeusTransformUtils.preCheckCast(r8, MapEntry.class, "com.obric.aiagent.plugin");
        if (r9.isEmpty() == false) goto L8;
        return 0;
    L8:
        Iterator<Map.Entry<K, V>> r11 = r9.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0 = r0 + (CodedOutputStream.computeTagSize(r6) + CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(r10.getMetadata(), r1.getKey(), r1.getValue())));
        goto L10
    L12:
        return r0;
    }
}
