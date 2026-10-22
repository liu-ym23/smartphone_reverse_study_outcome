package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@CheckReturnValue
/* loaded from: classes.dex */
interface Writer {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    FieldOrder fieldOrder();

    void writeBool(int i, boolean z10);

    void writeBoolList(int i, List<Boolean> list, boolean z10);

    void writeBytes(int i, ByteString byteString);

    void writeBytesList(int i, List<ByteString> list);

    void writeDouble(int i, double d7);

    void writeDoubleList(int i, List<Double> list, boolean z10);

    @Deprecated
    void writeEndGroup(int i);

    void writeEnum(int i, int i3);

    void writeEnumList(int i, List<Integer> list, boolean z10);

    void writeFixed32(int i, int i3);

    void writeFixed32List(int i, List<Integer> list, boolean z10);

    void writeFixed64(int i, long j10);

    void writeFixed64List(int i, List<Long> list, boolean z10);

    void writeFloat(int i, float f5);

    void writeFloatList(int i, List<Float> list, boolean z10);

    @Deprecated
    void writeGroup(int i, Object obj);

    @Deprecated
    void writeGroup(int i, Object obj, Schema schema);

    @Deprecated
    void writeGroupList(int i, List<?> list);

    @Deprecated
    void writeGroupList(int i, List<?> list, Schema schema);

    void writeInt32(int i, int i3);

    void writeInt32List(int i, List<Integer> list, boolean z10);

    void writeInt64(int i, long j10);

    void writeInt64List(int i, List<Long> list, boolean z10);

    <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map);

    void writeMessage(int i, Object obj);

    void writeMessage(int i, Object obj, Schema schema);

    void writeMessageList(int i, List<?> list);

    void writeMessageList(int i, List<?> list, Schema schema);

    void writeMessageSetItem(int i, Object obj);

    void writeSFixed32(int i, int i3);

    void writeSFixed32List(int i, List<Integer> list, boolean z10);

    void writeSFixed64(int i, long j10);

    void writeSFixed64List(int i, List<Long> list, boolean z10);

    void writeSInt32(int i, int i3);

    void writeSInt32List(int i, List<Integer> list, boolean z10);

    void writeSInt64(int i, long j10);

    void writeSInt64List(int i, List<Long> list, boolean z10);

    @Deprecated
    void writeStartGroup(int i);

    void writeString(int i, String str);

    void writeStringList(int i, List<String> list);

    void writeUInt32(int i, int i3);

    void writeUInt32List(int i, List<Integer> list, boolean z10);

    void writeUInt64(int i, long j10);

    void writeUInt64List(int i, List<Long> list, boolean z10);
}
