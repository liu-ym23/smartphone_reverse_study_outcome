package com.bytedance.location.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L56:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream output) {
        if (output.wrapper == null) goto L7;
        return output.wrapper;
    L7:
        return new CodedOutputStreamWriter(output);
    }

    private CodedOutputStreamWriter(CodedOutputStream output) {
        this.output = (CodedOutputStream) Internal.checkNotNull(output, "output");
        this.output.wrapper = this;
    }

    @Override // com.bytedance.location.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSFixed32(int fieldNumber, int value) throws IOException {
        this.output.writeSFixed32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeInt64(int fieldNumber, long value) throws IOException {
        this.output.writeInt64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSFixed64(int fieldNumber, long value) throws IOException {
        this.output.writeSFixed64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeFloat(int fieldNumber, float value) throws IOException {
        this.output.writeFloat(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeDouble(int fieldNumber, double value) throws IOException {
        this.output.writeDouble(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeEnum(int fieldNumber, int value) throws IOException {
        this.output.writeEnum(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeUInt64(int fieldNumber, long value) throws IOException {
        this.output.writeUInt64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeInt32(int fieldNumber, int value) throws IOException {
        this.output.writeInt32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeFixed64(int fieldNumber, long value) throws IOException {
        this.output.writeFixed64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeFixed32(int fieldNumber, int value) throws IOException {
        this.output.writeFixed32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeBool(int fieldNumber, boolean value) throws IOException {
        this.output.writeBool(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeString(int fieldNumber, String value) throws IOException {
        this.output.writeString(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeBytes(int fieldNumber, ByteString value) throws IOException {
        this.output.writeBytes(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeUInt32(int fieldNumber, int value) throws IOException {
        this.output.writeUInt32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSInt32(int fieldNumber, int value) throws IOException {
        this.output.writeSInt32(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSInt64(int fieldNumber, long value) throws IOException {
        this.output.writeSInt64(fieldNumber, value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeMessage(int fieldNumber, Object value) throws IOException {
        this.output.writeMessage(fieldNumber, (MessageLite) value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
        this.output.writeMessage(fieldNumber, (MessageLite) value, schema);
    }

    @Override // com.bytedance.location.protobuf.Writer
    @Deprecated
    public void writeGroup(int fieldNumber, Object value) throws IOException {
        this.output.writeGroup(fieldNumber, (MessageLite) value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
        this.output.writeGroup(fieldNumber, (MessageLite) value, schema);
    }

    @Override // com.bytedance.location.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int fieldNumber) throws IOException {
        this.output.writeTag(fieldNumber, 3);
    }

    @Override // com.bytedance.location.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int fieldNumber) throws IOException {
        this.output.writeTag(fieldNumber, 4);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public final void writeMessageSetItem(int fieldNumber, Object value) throws IOException {
        if ((value instanceof ByteString) == false) goto L5;
        this.output.writeRawMessageSetExtension(fieldNumber, (ByteString) value);
        return;
    L5:
        this.output.writeMessageSetExtension(fieldNumber, (MessageLite) value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeInt32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeInt32SizeNoTag(value.get(i).intValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeInt32NoTag(value.get(i2).intValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeInt32(fieldNumber, value.get(i3).intValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeFixed32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeFixed32SizeNoTag(value.get(i).intValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeFixed32NoTag(value.get(i2).intValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeFixed32(fieldNumber, value.get(i3).intValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeInt64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeInt64SizeNoTag(value.get(i).longValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeInt64NoTag(value.get(i2).longValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeInt64(fieldNumber, value.get(i3).longValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeUInt64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeUInt64SizeNoTag(value.get(i).longValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeUInt64NoTag(value.get(i2).longValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeUInt64(fieldNumber, value.get(i3).longValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeFixed64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeFixed64SizeNoTag(value.get(i).longValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeFixed64NoTag(value.get(i2).longValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeFixed64(fieldNumber, value.get(i3).longValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeFloatList(int fieldNumber, List<Float> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeFloatSizeNoTag(value.get(i).floatValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeFloatNoTag(value.get(i2).floatValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeFloat(fieldNumber, value.get(i3).floatValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeDoubleList(int fieldNumber, List<Double> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeDoubleSizeNoTag(value.get(i).doubleValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeDoubleNoTag(value.get(i2).doubleValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeDouble(fieldNumber, value.get(i3).doubleValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeEnumList(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeEnumSizeNoTag(value.get(i).intValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeEnumNoTag(value.get(i2).intValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeEnum(fieldNumber, value.get(i3).intValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeBoolList(int fieldNumber, List<Boolean> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeBoolSizeNoTag(value.get(i).booleanValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeBoolNoTag(value.get(i2).booleanValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeBool(fieldNumber, value.get(i3).booleanValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeStringList(int fieldNumber, List<String> value) throws IOException {
        if ((value instanceof LazyStringList) == false) goto L9;
        LazyStringList lazyList = (LazyStringList) value;
        int i = 0;
    L6:
        if (i >= value.size()) goto L13;
        writeLazyString(fieldNumber, lazyList.getRaw(i));
        i = i + 1;
        goto L6
    L13:
        return;
    L9:
        int i2 = 0;
    L11:
        if (i2 >= value.size()) goto L16;
        this.output.writeString(fieldNumber, value.get(i2));
        i2 = i2 + 1;
        goto L11
    }

    private void writeLazyString(int fieldNumber, Object value) throws IOException {
        if ((value instanceof String) == false) goto L5;
        this.output.writeString(fieldNumber, (String) value);
        return;
    L5:
        this.output.writeBytes(fieldNumber, (ByteString) value);
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeBytesList(int fieldNumber, List<ByteString> value) throws IOException {
        int i = 0;
    L4:
        if (i >= value.size()) goto L7;
        this.output.writeBytes(fieldNumber, value.get(i));
        i = i + 1;
        goto L4
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeUInt32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeUInt32SizeNoTag(value.get(i).intValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeUInt32NoTag(value.get(i2).intValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeUInt32(fieldNumber, value.get(i3).intValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSFixed32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeSFixed32SizeNoTag(value.get(i).intValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeSFixed32NoTag(value.get(i2).intValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeSFixed32(fieldNumber, value.get(i3).intValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSFixed64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeSFixed64SizeNoTag(value.get(i).longValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeSFixed64NoTag(value.get(i2).longValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeSFixed64(fieldNumber, value.get(i3).longValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSInt32List(int fieldNumber, List<Integer> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeSInt32SizeNoTag(value.get(i).intValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeSInt32NoTag(value.get(i2).intValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeSInt32(fieldNumber, value.get(i3).intValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeSInt64List(int fieldNumber, List<Long> value, boolean packed) throws IOException {
        if (packed == false) goto L12;
        this.output.writeTag(fieldNumber, 2);
        int dataSize = 0;
        int i = 0;
    L5:
        if (i >= value.size()) goto L7;
        dataSize = dataSize + CodedOutputStream.computeSInt64SizeNoTag(value.get(i).longValue());
        i = i + 1;
        goto L5
    L7:
        this.output.writeUInt32NoTag(dataSize);
        int i2 = 0;
    L9:
        if (i2 >= value.size()) goto L16;
        this.output.writeSInt64NoTag(value.get(i2).longValue());
        i2 = i2 + 1;
        goto L9
    L16:
        return;
    L12:
        int i3 = 0;
    L14:
        if (i3 >= value.size()) goto L20;
        this.output.writeSInt64(fieldNumber, value.get(i3).longValue());
        i3 = i3 + 1;
        goto L14
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeMessageList(int fieldNumber, List<?> value) throws IOException {
        int i = 0;
    L4:
        if (i >= value.size()) goto L7;
        writeMessage(fieldNumber, value.get(i));
        i = i + 1;
        goto L4
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeMessageList(int fieldNumber, List<?> value, Schema schema) throws IOException {
        int i = 0;
    L4:
        if (i >= value.size()) goto L7;
        writeMessage(fieldNumber, value.get(i), schema);
        i = i + 1;
        goto L4
    }

    @Override // com.bytedance.location.protobuf.Writer
    @Deprecated
    public void writeGroupList(int fieldNumber, List<?> value) throws IOException {
        int i = 0;
    L4:
        if (i >= value.size()) goto L7;
        writeGroup(fieldNumber, value.get(i));
        i = i + 1;
        goto L4
    }

    @Override // com.bytedance.location.protobuf.Writer
    public void writeGroupList(int fieldNumber, List<?> value, Schema schema) throws IOException {
        int i = 0;
    L4:
        if (i >= value.size()) goto L7;
        writeGroup(fieldNumber, value.get(i), schema);
        i = i + 1;
        goto L4
    }

    @Override // com.bytedance.location.protobuf.Writer
    public <K, V> void writeMap(int fieldNumber, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic() == false) goto L6;
        writeDeterministicMap(fieldNumber, metadata, map);
        return;
    L6:
        Iterator<Map.Entry<K, V>> r0 = map.entrySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<K, V> entry = r0.next();
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
        MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        goto L8
    }

    private <K, V> void writeDeterministicMap(int fieldNumber, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        writeDeterministicStringMap(fieldNumber, metadata, map);
        return;
    L7:
        writeDeterministicLongMap(fieldNumber, metadata, map);
        return;
    L8:
        writeDeterministicIntegerMap(fieldNumber, metadata, map);
        return;
    L9:
        V value = map.get(Boolean.FALSE);
        if (value == null) goto L12;
        writeDeterministicBooleanMapEntry(fieldNumber, false, value, metadata);
    L12:
        V value2 = map.get(Boolean.TRUE);
        if (value2 == null) goto L19;
        writeDeterministicBooleanMapEntry(fieldNumber, true, value2, metadata);
        return;
    L19:
        return;
    L5:
        throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
    }

    private <V> void writeDeterministicBooleanMapEntry(int fieldNumber, boolean key, V value, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(key), value));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(key), value);
    }

    private <V> void writeDeterministicIntegerMap(int fieldNumber, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int[] keys = new int[map.size()];
        int index = 0;
        Iterator<Integer> r2 = map.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        int k = r2.next().intValue();
        keys[index] = k;
        index = index + 1;
        goto L4
    L6:
        Arrays.sort(keys);
        int r3 = keys.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L9;
        int key = keys[r4];
        V value = map.get(Integer.valueOf(key));
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(key), value));
        MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(key), value);
        r4 = r4 + 1;
        goto L7
    }

    private <V> void writeDeterministicLongMap(int fieldNumber, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        long[] keys = new long[map.size()];
        int index = 0;
        Iterator<Long> r2 = map.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        long k = r2.next().longValue();
        keys[index] = k;
        index = index + 1;
        goto L4
    L6:
        Arrays.sort(keys);
        int r3 = keys.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L9;
        long key = keys[r4];
        V value = map.get(Long.valueOf(key));
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(key), value));
        MapEntryLite.writeTo(this.output, metadata, Long.valueOf(key), value);
        r4 = r4 + 1;
        goto L7
    }

    private <V> void writeDeterministicStringMap(int fieldNumber, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        String[] keys = new String[map.size()];
        int index = 0;
        Iterator<String> r2 = map.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String k = r2.next();
        keys[index] = k;
        index = index + 1;
        goto L4
    L6:
        Arrays.sort(keys);
        int r3 = keys.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L9;
        String key = keys[r4];
        V value = map.get(key);
        this.output.writeTag(fieldNumber, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, key, value));
        MapEntryLite.writeTo(this.output, metadata, key, value);
        r4 = r4 + 1;
        goto L7
    }
}
