package com.bytedance.location.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = null;
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = null;
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = null;
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = null;

    static {
        GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
        PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
        PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
        UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();
    }

    private SchemaUtil() {
    }

    public static void requireGeneratedMessage(Class<?> messageType) {
        if (GeneratedMessageLite.class.isAssignableFrom(messageType) == false) goto L5;
        return;
    L5:
        if (GENERATED_MESSAGE_CLASS != null) goto L7;
        return;
    L7:
        if (GENERATED_MESSAGE_CLASS.isAssignableFrom(messageType) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
    }

    public static void writeDouble(int fieldNumber, double value, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(value) == 0) goto L6;
        writer.writeDouble(fieldNumber, value);
        return;
    }

    public static void writeFloat(int fieldNumber, float value, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(value) == 0) goto L6;
        writer.writeFloat(fieldNumber, value);
        return;
    }

    public static void writeInt64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeInt64(fieldNumber, value);
        return;
    }

    public static void writeUInt64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeUInt64(fieldNumber, value);
        return;
    }

    public static void writeSInt64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeSInt64(fieldNumber, value);
        return;
    }

    public static void writeFixed64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeFixed64(fieldNumber, value);
        return;
    }

    public static void writeSFixed64(int fieldNumber, long value, Writer writer) throws IOException {
        if (value == 0) goto L6;
        writer.writeSFixed64(fieldNumber, value);
        return;
    }

    public static void writeInt32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeInt32(fieldNumber, value);
        return;
    }

    public static void writeUInt32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeUInt32(fieldNumber, value);
        return;
    }

    public static void writeSInt32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeSInt32(fieldNumber, value);
        return;
    }

    public static void writeFixed32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeFixed32(fieldNumber, value);
        return;
    }

    public static void writeSFixed32(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeSFixed32(fieldNumber, value);
        return;
    }

    public static void writeEnum(int fieldNumber, int value, Writer writer) throws IOException {
        if (value == 0) goto L5;
        writer.writeEnum(fieldNumber, value);
        return;
    }

    public static void writeBool(int fieldNumber, boolean value, Writer writer) throws IOException {
        if (value == false) goto L5;
        writer.writeBool(fieldNumber, true);
        return;
    }

    public static void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if ((value instanceof String) == false) goto L5;
        writeStringInternal(fieldNumber, (String) value, writer);
        return;
    L5:
        writeBytes(fieldNumber, (ByteString) value, writer);
    }

    private static void writeStringInternal(int fieldNumber, String value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeString(fieldNumber, value);
        return;
    }

    public static void writeBytes(int fieldNumber, ByteString value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeBytes(fieldNumber, value);
        return;
    }

    public static void writeMessage(int fieldNumber, Object value, Writer writer) throws IOException {
        if (value == null) goto L5;
        writer.writeMessage(fieldNumber, value);
        return;
    }

    public static void writeDoubleList(int fieldNumber, List<Double> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeDoubleList(fieldNumber, value, packed);
        return;
    }

    public static void writeFloatList(int fieldNumber, List<Float> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeFloatList(fieldNumber, value, packed);
        return;
    }

    public static void writeInt64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeInt64List(fieldNumber, value, packed);
        return;
    }

    public static void writeUInt64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeUInt64List(fieldNumber, value, packed);
        return;
    }

    public static void writeSInt64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSInt64List(fieldNumber, value, packed);
        return;
    }

    public static void writeFixed64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeFixed64List(fieldNumber, value, packed);
        return;
    }

    public static void writeSFixed64List(int fieldNumber, List<Long> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSFixed64List(fieldNumber, value, packed);
        return;
    }

    public static void writeInt32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeInt32List(fieldNumber, value, packed);
        return;
    }

    public static void writeUInt32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeUInt32List(fieldNumber, value, packed);
        return;
    }

    public static void writeSInt32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSInt32List(fieldNumber, value, packed);
        return;
    }

    public static void writeFixed32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeFixed32List(fieldNumber, value, packed);
        return;
    }

    public static void writeSFixed32List(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeSFixed32List(fieldNumber, value, packed);
        return;
    }

    public static void writeEnumList(int fieldNumber, List<Integer> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeEnumList(fieldNumber, value, packed);
        return;
    }

    public static void writeBoolList(int fieldNumber, List<Boolean> value, Writer writer, boolean packed) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeBoolList(fieldNumber, value, packed);
        return;
    }

    public static void writeStringList(int fieldNumber, List<String> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeStringList(fieldNumber, value);
        return;
    }

    public static void writeBytesList(int fieldNumber, List<ByteString> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeBytesList(fieldNumber, value);
        return;
    }

    public static void writeMessageList(int fieldNumber, List<?> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeMessageList(fieldNumber, value);
        return;
    }

    public static void writeMessageList(int fieldNumber, List<?> value, Writer writer, Schema schema) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeMessageList(fieldNumber, value, schema);
        return;
    }

    public static void writeLazyFieldList(int fieldNumber, List<?> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L11;
        Iterator<?> r0 = value.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        Object item = r0.next();
        ((LazyFieldLite) item).writeTo(writer, fieldNumber);
        goto L7
    L12:
        return;
    }

    public static void writeGroupList(int fieldNumber, List<?> value, Writer writer) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeGroupList(fieldNumber, value);
        return;
    }

    public static void writeGroupList(int fieldNumber, List<?> value, Writer writer, Schema schema) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isEmpty() == true) goto L8;
        writer.writeGroupList(fieldNumber, value, schema);
        return;
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof LongArrayList) == false) goto L12;
        LongArrayList primitiveList = (LongArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeInt64SizeNoTag(primitiveList.getLong(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeInt64SizeNoTag(list.get(i2).longValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeInt64List(int fieldNumber, List<Long> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeInt64ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (list.size() * CodedOutputStream.computeTagSize(fieldNumber)) + size;
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof LongArrayList) == false) goto L12;
        LongArrayList primitiveList = (LongArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeUInt64SizeNoTag(primitiveList.getLong(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeUInt64SizeNoTag(list.get(i2).longValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeUInt64List(int fieldNumber, List<Long> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeUInt64ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (CodedOutputStream.computeTagSize(fieldNumber) * length) + size;
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof LongArrayList) == false) goto L12;
        LongArrayList primitiveList = (LongArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeSInt64SizeNoTag(primitiveList.getLong(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeSInt64SizeNoTag(list.get(i2).longValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeSInt64List(int fieldNumber, List<Long> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeSInt64ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (CodedOutputStream.computeTagSize(fieldNumber) * length) + size;
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof IntArrayList) == false) goto L12;
        IntArrayList primitiveList = (IntArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeEnumSizeNoTag(primitiveList.getInt(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeEnumSizeNoTag(list.get(i2).intValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeEnumList(int fieldNumber, List<Integer> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeEnumListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (CodedOutputStream.computeTagSize(fieldNumber) * length) + size;
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof IntArrayList) == false) goto L12;
        IntArrayList primitiveList = (IntArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeInt32SizeNoTag(primitiveList.getInt(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeInt32SizeNoTag(list.get(i2).intValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeInt32List(int fieldNumber, List<Integer> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeInt32ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (CodedOutputStream.computeTagSize(fieldNumber) * length) + size;
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof IntArrayList) == false) goto L12;
        IntArrayList primitiveList = (IntArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeUInt32SizeNoTag(primitiveList.getInt(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeUInt32SizeNoTag(list.get(i2).intValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeUInt32List(int fieldNumber, List<Integer> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeUInt32ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (CodedOutputStream.computeTagSize(fieldNumber) * length) + size;
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        if ((list instanceof IntArrayList) == false) goto L12;
        IntArrayList primitiveList = (IntArrayList) list;
        int i = 0;
    L9:
        if (i >= length) goto L15;
        size = size + CodedOutputStream.computeSInt32SizeNoTag(primitiveList.getInt(i));
        i = i + 1;
    L15:
        return size;
    L12:
        int i2 = 0;
    L13:
        if (i2 >= length) goto L15;
        size = size + CodedOutputStream.computeSInt32SizeNoTag(list.get(i2).intValue());
        i2 = i2 + 1;
        goto L13
    }

    static int computeSizeSInt32List(int fieldNumber, List<Integer> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = computeSizeSInt32ListNoTag(list);
        if (packed == false) goto L11;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
    L11:
        return (CodedOutputStream.computeTagSize(fieldNumber) * length) + size;
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed32List(int fieldNumber, List<?> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L5;
        return 0;
    L5:
        if (packed == false) goto L8;
        int dataSize = length * 4;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(dataSize);
    L8:
        int dataSize2 = CodedOutputStream.computeFixed32Size(fieldNumber, 0);
        return dataSize2 * length;
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeFixed64List(int fieldNumber, List<?> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        if (packed == false) goto L10;
        int dataSize = length * 8;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(dataSize);
    L10:
        return CodedOutputStream.computeFixed64Size(fieldNumber, 0) * length;
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeBoolList(int fieldNumber, List<?> list, boolean packed) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        if (packed == false) goto L10;
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(length);
    L10:
        return CodedOutputStream.computeBoolSize(fieldNumber, true) * length;
    }

    static int computeSizeStringList(int fieldNumber, List<?> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = CodedOutputStream.computeTagSize(fieldNumber) * length;
        if ((list instanceof LazyStringList) == false) goto L16;
        LazyStringList lazyList = (LazyStringList) list;
        int i = 0;
    L9:
        if (i >= length) goto L23;
        Object value = lazyList.getRaw(i);
        if ((value instanceof ByteString) == false) goto L13;
        int r5 = CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    L14:
        size = size + r5;
        i = i + 1;
        goto L9
    L13:
        r5 = CodedOutputStream.computeStringSizeNoTag((String) value);
    L23:
        return size;
    L16:
        int i2 = 0;
    L17:
        if (i2 >= length) goto L23;
        Object value2 = list.get(i2);
        if ((value2 instanceof ByteString) == false) goto L21;
        int r4 = CodedOutputStream.computeBytesSizeNoTag((ByteString) value2);
    L22:
        size = size + r4;
        i2 = i2 + 1;
        goto L17
    L21:
        r4 = CodedOutputStream.computeStringSizeNoTag((String) value2);
        goto L22
    }

    static int computeSizeMessage(int fieldNumber, Object value, Schema schema) {
        if ((value instanceof LazyFieldLite) == false) goto L7;
        return CodedOutputStream.computeLazyFieldSize(fieldNumber, (LazyFieldLite) value);
    L7:
        return CodedOutputStream.computeMessageSize(fieldNumber, (MessageLite) value, schema);
    }

    static int computeSizeMessageList(int fieldNumber, List<?> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = CodedOutputStream.computeTagSize(fieldNumber) * length;
        int i = 0;
    L7:
        if (i >= length) goto L14;
        Object value = list.get(i);
        if ((value instanceof LazyFieldLite) == false) goto L11;
        int r4 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) value);
    L12:
        size = size + r4;
        i = i + 1;
        goto L7
    L11:
        r4 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
        goto L12
    L14:
        return size;
    }

    static int computeSizeMessageList(int fieldNumber, List<?> list, Schema schema) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = CodedOutputStream.computeTagSize(fieldNumber) * length;
        int i = 0;
    L7:
        if (i >= length) goto L14;
        Object value = list.get(i);
        if ((value instanceof LazyFieldLite) == false) goto L11;
        int r4 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) value);
    L12:
        size = size + r4;
        i = i + 1;
        goto L7
    L11:
        r4 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) value, schema);
        goto L12
    L14:
        return size;
    }

    static int computeSizeByteStringList(int fieldNumber, List<ByteString> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = CodedOutputStream.computeTagSize(fieldNumber) * length;
        int i = 0;
    L8:
        if (i >= list.size()) goto L11;
        size = size + CodedOutputStream.computeBytesSizeNoTag(list.get(i));
        i = i + 1;
        goto L8
    L11:
        return size;
    }

    static int computeSizeGroupList(int fieldNumber, List<MessageLite> list) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        int i = 0;
    L7:
        if (i >= length) goto L10;
        size = size + CodedOutputStream.computeGroupSize(fieldNumber, list.get(i));
        i = i + 1;
        goto L7
    L10:
        return size;
    }

    static int computeSizeGroupList(int fieldNumber, List<MessageLite> list, Schema schema) {
        int length = list.size();
        if (length != 0) goto L6;
        return 0;
    L6:
        int size = 0;
        int i = 0;
    L7:
        if (i >= length) goto L10;
        size = size + CodedOutputStream.computeGroupSize(fieldNumber, list.get(i), schema);
        i = i + 1;
        goto L7
    L10:
        return size;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fields) {
        if (fields.length != 0) goto L5;
        return false;
    L5:
        int lo = fields[0].getFieldNumber();
        int hi = fields[fields.length - 1].getFieldNumber();
        return shouldUseTableSwitch(lo, hi, fields.length);
    }

    public static boolean shouldUseTableSwitch(int lo, int hi, int numFields) {
        if (hi >= 40) goto L5;
        return true;
    L5:
        long tableSpaceCost = (((long) hi) - ((long) lo)) + 1;
        long lookupSpaceCost = (((long) numFields) * 2) + 3;
        long lookupTimeCost = ((long) numFields) + 3;
        if (((3 * 3) + tableSpaceCost) <= ((3 * lookupTimeCost) + lookupSpaceCost)) goto L10;
        return false;
    L10:
        return true;
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean proto3) {
        Class<?> clz = getUnknownFieldSetSchemaClass();     // Catch: Throwable -> L8
        if (clz != null) goto L6;
        return null;
    L6:
        return (UnknownFieldSchema) clz.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(proto3)});
    L9:
        return null;
    }

    private static Class<?> getGeneratedMessageClass() {
        return Class.forName("com.bytedance.location.protobuf.GeneratedMessageV3");
    L5:
        return null;
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        return Class.forName("com.bytedance.location.protobuf.UnknownFieldSetSchema");
    L5:
        return null;
    }

    static Object getMapDefaultEntry(Class<?> clazz, String name) {
        Class<?> holder = Class.forName(clazz.getName() + "$" + toCamelCase(name, true) + "DefaultEntryHolder");     // Catch: Throwable -> L6
        Field[] fields = holder.getDeclaredFields();     // Catch: Throwable -> L6
        if (fields.length != 1) goto L9;
        return UnsafeUtil.getStaticObject(fields[0]);
    L9:
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + name + " in " + clazz.getName());     // Catch: Throwable -> L6
    L6:
        t = move-exception;
        throw new RuntimeException(t);
    }

    static String toCamelCase(String name, boolean capNext) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L4:
        if (i >= name.length()) goto L30;
        char c = name.charAt(i);
        if ('a' > c) goto L14;
        if (c > 'z') goto L14;
        if (capNext == false) goto L11;
        sb.append((char) (c - ' '));
    L12:
        capNext = false;
    L28:
        i = i + 1;
        goto L4
    L11:
        sb.append(c);
    L14:
        if ('A' > c) goto L23;
        if (c > 'Z') goto L23;
        if (i != 0) goto L20;
        if (capNext == true) goto L20;
        sb.append((char) (c + ' '));
    L21:
        capNext = false;
    L20:
        sb.append(c);
    L23:
        if ('0' <= c) goto L25;
    L27:
        capNext = true;
        goto L28
    L25:
        if (c > '9') goto L27;
        sb.append(c);
        capNext = true;
        goto L28
    L30:
        return sb.toString();
    }

    static boolean safeEquals(Object a, Object b) {
        if (a == b) goto L8;
        if (a != null) goto L5;
    L7:
        return false;
    L5:
        if (a.equals(b) == false) goto L7;
    L8:
        return true;
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T message, T o, long offset) {
        Object merged = mapFieldSchema.mergeFrom(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(o, offset));
        UnsafeUtil.putObject(message, offset, merged);
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> schema, T message, T other) {
        FieldSet<T> r0 = schema.getExtensions(other);
        if (r0.isEmpty() == true) goto L6;
        schema.getMutableExtensions(message).mergeFrom(r0);
        return;
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> schema, T message, T other) {
        UT messageUnknowns = schema.getFromMessage(message);
        UT otherUnknowns = schema.getFromMessage(other);
        UT merged = schema.merge(messageUnknowns, otherUnknowns);
        schema.setToMessage(message, merged);
    }

    static <UT, UB> UB filterUnknownEnumList(Object r5, int r6, List<Integer> r7, Internal.EnumLiteMap<?> r8, UB r9, UnknownFieldSchema<UT, UB> r10) {
        if (r8 != null) goto L5;
        return r9;
    L5:
        if ((r7 instanceof RandomAccess) == false) goto L19;
        int r0 = 0;
        int r1 = r7.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L16;
        int r3 = r7.get(r2).intValue();
        if (r8.findValueByNumber(r3) == null) goto L13;
        if (r2 == r0) goto L12;
        r7.set(r0, Integer.valueOf(r3));
    L12:
        r0 = r0 + 1;
    L14:
        r2 = r2 + 1;
        goto L7
    L13:
        r9 = (UB) storeUnknownEnum(r5, r6, r3, r9, r10);
        goto L14
    L16:
        if (r0 == r1) goto L26;
        r7.subList(r0, r1).clear();
    L26:
        return r9;
    L19:
        Iterator<Integer> r4 = r7.iterator();
    L21:
        if (r4.hasNext() == false) goto L26;
        int r11 = r4.next().intValue();
        if (r8.findValueByNumber(r11) != null) goto L21;
        r9 = (UB) storeUnknownEnum(r5, r6, r11, r9, r10);
        r4.remove();
        goto L21
    }

    static <UT, UB> UB filterUnknownEnumList(Object r5, int r6, List<Integer> r7, Internal.EnumVerifier r8, UB r9, UnknownFieldSchema<UT, UB> r10) {
        if (r8 != null) goto L5;
        return r9;
    L5:
        if ((r7 instanceof RandomAccess) == false) goto L19;
        int r0 = 0;
        int r1 = r7.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L16;
        int r3 = r7.get(r2).intValue();
        if (r8.isInRange(r3) == false) goto L13;
        if (r2 == r0) goto L12;
        r7.set(r0, Integer.valueOf(r3));
    L12:
        r0 = r0 + 1;
    L14:
        r2 = r2 + 1;
        goto L7
    L13:
        r9 = (UB) storeUnknownEnum(r5, r6, r3, r9, r10);
        goto L14
    L16:
        if (r0 == r1) goto L26;
        r7.subList(r0, r1).clear();
    L26:
        return r9;
    L19:
        Iterator<Integer> r4 = r7.iterator();
    L21:
        if (r4.hasNext() == false) goto L26;
        int r11 = r4.next().intValue();
        if (r8.isInRange(r11) == true) goto L21;
        r9 = (UB) storeUnknownEnum(r5, r6, r11, r9, r10);
        r4.remove();
        goto L21
    }

    static <UT, UB> UB storeUnknownEnum(Object r2, int r3, int r4, UB r5, UnknownFieldSchema<UT, UB> r6) {
        if (r5 != null) goto L4;
        r5 = r6.getBuilderFromMessage(r2);
    L4:
        r6.addVarint(r5, r3, r4);
        return r5;
    }
}
