package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface Writer {

    public static final enum FieldOrder extends Enum<FieldOrder> {
        private static final /* synthetic */ FieldOrder[] $VALUES = null;
        public static final FieldOrder ASCENDING = null;
        public static final FieldOrder DESCENDING = null;

        private static /* synthetic */ FieldOrder[] $values() {
            return new FieldOrder[]{ASCENDING, DESCENDING};
        }

        private FieldOrder(String r1, int r2) {
            super(r1, r2);
        }

        public static FieldOrder valueOf(String name) {
            return (FieldOrder) Enum.valueOf(FieldOrder.class, name);
        }

        public static FieldOrder[] values() {
            return (FieldOrder[]) $VALUES.clone();
        }

        static {
            ASCENDING = new FieldOrder("ASCENDING", 0);
            DESCENDING = new FieldOrder("DESCENDING", 1);
            $VALUES = $values();
        }
    }

    FieldOrder fieldOrder();

    void writeBool(int r1, boolean r2) throws IOException;

    void writeBoolList(int r1, List<Boolean> r2, boolean r3) throws IOException;

    void writeBytes(int r1, ByteString r2) throws IOException;

    void writeBytesList(int r1, List<ByteString> r2) throws IOException;

    void writeDouble(int r1, double r2) throws IOException;

    void writeDoubleList(int r1, List<Double> r2, boolean r3) throws IOException;

    @Deprecated
    void writeEndGroup(int r1) throws IOException;

    void writeEnum(int r1, int r2) throws IOException;

    void writeEnumList(int r1, List<Integer> r2, boolean r3) throws IOException;

    void writeFixed32(int r1, int r2) throws IOException;

    void writeFixed32List(int r1, List<Integer> r2, boolean r3) throws IOException;

    void writeFixed64(int r1, long r2) throws IOException;

    void writeFixed64List(int r1, List<Long> r2, boolean r3) throws IOException;

    void writeFloat(int r1, float r2) throws IOException;

    void writeFloatList(int r1, List<Float> r2, boolean r3) throws IOException;

    @Deprecated
    void writeGroup(int r1, Object r2) throws IOException;

    @Deprecated
    void writeGroup(int r1, Object r2, Schema r3) throws IOException;

    @Deprecated
    void writeGroupList(int r1, List<?> r2) throws IOException;

    @Deprecated
    void writeGroupList(int r1, List<?> r2, Schema r3) throws IOException;

    void writeInt32(int r1, int r2) throws IOException;

    void writeInt32List(int r1, List<Integer> r2, boolean r3) throws IOException;

    void writeInt64(int r1, long r2) throws IOException;

    void writeInt64List(int r1, List<Long> r2, boolean r3) throws IOException;

    <K, V> void writeMap(int r1, MapEntryLite.Metadata<K, V> r2, Map<K, V> r3) throws IOException;

    void writeMessage(int r1, Object r2) throws IOException;

    void writeMessage(int r1, Object r2, Schema r3) throws IOException;

    void writeMessageList(int r1, List<?> r2) throws IOException;

    void writeMessageList(int r1, List<?> r2, Schema r3) throws IOException;

    void writeMessageSetItem(int r1, Object r2) throws IOException;

    void writeSFixed32(int r1, int r2) throws IOException;

    void writeSFixed32List(int r1, List<Integer> r2, boolean r3) throws IOException;

    void writeSFixed64(int r1, long r2) throws IOException;

    void writeSFixed64List(int r1, List<Long> r2, boolean r3) throws IOException;

    void writeSInt32(int r1, int r2) throws IOException;

    void writeSInt32List(int r1, List<Integer> r2, boolean r3) throws IOException;

    void writeSInt64(int r1, long r2) throws IOException;

    void writeSInt64List(int r1, List<Long> r2, boolean r3) throws IOException;

    @Deprecated
    void writeStartGroup(int r1) throws IOException;

    void writeString(int r1, String r2) throws IOException;

    void writeStringList(int r1, List<String> r2) throws IOException;

    void writeUInt32(int r1, int r2) throws IOException;

    void writeUInt32List(int r1, List<Integer> r2, boolean r3) throws IOException;

    void writeUInt64(int r1, long r2) throws IOException;

    void writeUInt64List(int r1, List<Long> r2, boolean r3) throws IOException;
}
