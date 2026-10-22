package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ArrayDecoders {

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.ArrayDecoders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L90:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L78:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L92:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L82:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L84:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L86:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L76:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L88:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
        L80:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L56
            return;
        }
    }

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite extensionRegistry) {
            if (extensionRegistry == null) goto L7;
            this.extensionRegistry = extensionRegistry;
            return;
        L7:
            throw new NullPointerException();
        }
    }

    private ArrayDecoders() {
    }

    static int decodeVarint32(byte[] data, int position, Registers registers) {
        int position2 = position + 1;
        int value = data[position];
        if (value < 0) goto L7;
        registers.int1 = value;
        return position2;
    L7:
        return decodeVarint32(value, data, position2, registers);
    }

    static int decodeVarint32(int firstByte, byte[] data, int position, Registers registers) {
        int value = firstByte & 127;
        int position2 = position + 1;
        byte b2 = data[position];
        if (b2 < 0) goto L6;
        registers.int1 = (b2 << 7) | value;
        return position2;
    L6:
        int value2 = value | ((b2 & 127) << 7);
        int position3 = position2 + 1;
        byte b3 = data[position2];
        if (b3 < 0) goto L10;
        registers.int1 = (b3 << 14) | value2;
        return position3;
    L10:
        int value3 = value2 | ((b3 & 127) << 14);
        int position4 = position3 + 1;
        byte b4 = data[position3];
        if (b4 < 0) goto L14;
        registers.int1 = (b4 << ParameterName.BLUE_STRETCH) | value3;
        return position4;
    L14:
        int value4 = value3 | ((b4 & 127) << 21);
        int position5 = position4 + 1;
        byte b5 = data[position4];
        if (b5 < 0) goto L18;
        registers.int1 = (b5 << ParameterName.GAMUT_MAPPING) | value4;
        return position5;
    L18:
        int value5 = value4 | ((b5 & 127) << 28);
    L19:
        int position6 = position5 + 1;
        if (data[position5] >= 0) goto L22;
        position5 = position6;
        goto L19
    L22:
        registers.int1 = value5;
        return position6;
    }

    static int decodeVarint64(byte[] data, int position, Registers registers) {
        int position2 = position + 1;
        long value = data[position];
        if (value < 0) goto L7;
        registers.long1 = value;
        return position2;
    L7:
        return decodeVarint64(value, data, position2, registers);
    }

    static int decodeVarint64(long firstByte, byte[] data, int position, Registers registers) {
        long value = 127 & firstByte;
        int position2 = position + 1;
        byte next = data[position];
        int shift = 7;
        long value2 = value | (((long) (next & 127)) << 7);
    L3:
        if (next >= 0) goto L5;
        int position3 = position2 + 1;
        next = data[position2];
        shift = shift + 7;
        value2 = value2 | (((long) (next & 127)) << shift);
        position2 = position3;
        goto L3
    L5:
        registers.long1 = value2;
        return position2;
    }

    static int decodeFixed32(byte[] data, int position) {
        return (((data[position] & CecDeviceType.INACTIVE) | ((data[position + 1] & CecDeviceType.INACTIVE) << 8)) | ((data[position + 2] & CecDeviceType.INACTIVE) << 16)) | ((data[position + 3] & CecDeviceType.INACTIVE) << 24);
    }

    static long decodeFixed64(byte[] data, int position) {
        return (((((((((long) data[position]) & 255) | ((((long) data[position + 1]) & 255) << 8)) | ((((long) data[position + 2]) & 255) << 16)) | ((((long) data[position + 3]) & 255) << 24)) | ((((long) data[position + 4]) & 255) << 32)) | ((((long) data[position + 5]) & 255) << 40)) | ((((long) data[position + 6]) & 255) << 48)) | ((255 & ((long) data[position + 7])) << 56);
    }

    static double decodeDouble(byte[] data, int position) {
        return Double.longBitsToDouble(decodeFixed64(data, position));
    }

    static float decodeFloat(byte[] data, int position) {
        return Float.intBitsToFloat(decodeFixed32(data, position));
    }

    static int decodeString(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) goto L10;
        if (length != 0) goto L7;
        registers.object1 = "";
        return position2;
    L7:
        registers.object1 = new String(data, position2, length, Internal.UTF_8);
        return position2 + length;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringRequireUtf8(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) goto L10;
        if (length != 0) goto L7;
        registers.object1 = "";
        return position2;
    L7:
        registers.object1 = Utf8.decodeUtf8(data, position2, length);
        return position2 + length;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeBytes(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) goto L14;
        if (length > (data.length - position2)) goto L12;
        if (length != 0) goto L9;
        registers.object1 = ByteString.EMPTY;
        return position2;
    L9:
        registers.object1 = ByteString.copyFrom(data, position2, length);
        return position2 + length;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeMessageField(Schema schema, byte[] data, int position, int limit, Registers registers) throws IOException {
        Object msg = schema.newInstance();
        int offset = mergeMessageField(msg, schema, data, position, limit, registers);
        schema.makeImmutable(msg);
        registers.object1 = msg;
        return offset;
    }

    static int decodeGroupField(Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        Object msg = schema.newInstance();
        int offset = mergeGroupField(msg, schema, data, position, limit, endGroup, registers);
        schema.makeImmutable(msg);
        registers.object1 = msg;
        return offset;
    }

    static int mergeMessageField(Object msg, Schema schema, byte[] r8, int position, int limit, Registers registers) throws IOException {
        int position2 = position + 1;
        int r9 = r8[position];
        if (r9 >= 0) goto L5;
        int position3 = decodeVarint32(r9, r8, position2, registers);
        r9 = registers.int1;
        int position4 = position3;
    L6:
        if (r9 < 0) goto L12;
        if (r9 > (limit - position4)) goto L12;
        schema.mergeFrom(msg, r8, position4, position4 + r9, registers);
        registers.object1 = msg;
        return position4 + r9;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L5:
        position4 = position2;
        goto L6
    }

    static int mergeGroupField(Object msg, Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        int endPosition = messageSchema.parseProto2Message(msg, data, position, limit, endGroup, registers);
        registers.object1 = msg;
        return endPosition;
    }

    static int decodeVarint32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        output.addInt(registers.int1);
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        position2 = decodeVarint32(data, nextPosition, registers);
        output.addInt(registers.int1);
    L8:
        return position2;
    }

    static int decodeVarint64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint64(data, position, registers);
        output.addLong(registers.long1);
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        position2 = decodeVarint64(data, nextPosition, registers);
        output.addLong(registers.long1);
    L8:
        return position2;
    }

    static int decodeFixed32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList output = (IntArrayList) list;
        output.addInt(decodeFixed32(data, position));
        int position2 = position + 4;
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        output.addInt(decodeFixed32(data, nextPosition));
        position2 = nextPosition + 4;
    L8:
        return position2;
    }

    static int decodeFixed64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList output = (LongArrayList) list;
        output.addLong(decodeFixed64(data, position));
        int position2 = position + 8;
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        output.addLong(decodeFixed64(data, nextPosition));
        position2 = nextPosition + 8;
    L8:
        return position2;
    }

    static int decodeFloatList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        FloatArrayList output = (FloatArrayList) list;
        output.addFloat(decodeFloat(data, position));
        int position2 = position + 4;
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        output.addFloat(decodeFloat(data, nextPosition));
        position2 = nextPosition + 4;
    L8:
        return position2;
    }

    static int decodeDoubleList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        DoubleArrayList output = (DoubleArrayList) list;
        output.addDouble(decodeDouble(data, position));
        int position2 = position + 8;
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        output.addDouble(decodeDouble(data, nextPosition));
        position2 = nextPosition + 8;
    L8:
        return position2;
    }

    static int decodeBoolList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        BooleanArrayList output = (BooleanArrayList) list;
        int position2 = decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L5;
        boolean r1 = true;
    L6:
        output.addBoolean(r1);
    L7:
        if (position2 >= limit) goto L16;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L16;
        position2 = decodeVarint64(data, nextPosition, registers);
        if (registers.long1 == 0) goto L14;
        boolean r6 = true;
    L15:
        output.addBoolean(r6);
        goto L7
    L14:
        r6 = false;
    L16:
        return position2;
    L5:
        r1 = false;
        goto L6
    }

    static int decodeSInt32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        output.addInt(CodedInputStream.decodeZigZag32(registers.int1));
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        position2 = decodeVarint32(data, nextPosition, registers);
        output.addInt(CodedInputStream.decodeZigZag32(registers.int1));
    L8:
        return position2;
    }

    static int decodeSInt64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint64(data, position, registers);
        output.addLong(CodedInputStream.decodeZigZag64(registers.long1));
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        position2 = decodeVarint64(data, nextPosition, registers);
        output.addLong(CodedInputStream.decodeZigZag64(registers.long1));
    L8:
        return position2;
    }

    static int decodePackedVarint32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        position2 = decodeVarint32(data, position2, registers);
        output.addInt(registers.int1);
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        position2 = decodeVarint64(data, position2, registers);
        output.addLong(registers.long1);
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        output.addInt(decodeFixed32(data, position2));
        position2 = position2 + 4;
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        output.addLong(decodeFixed64(data, position2));
        position2 = position2 + 8;
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        FloatArrayList output = (FloatArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        output.addFloat(decodeFloat(data, position2));
        position2 = position2 + 4;
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        DoubleArrayList output = (DoubleArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        output.addDouble(decodeDouble(data, position2));
        position2 = position2 + 8;
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedBoolList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        BooleanArrayList output = (BooleanArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L9;
        position2 = decodeVarint64(data, position2, registers);
        if (registers.long1 == 0) goto L7;
        boolean r2 = true;
    L8:
        output.addBoolean(r2);
        goto L3
    L7:
        r2 = false;
        goto L8
    L9:
        if (position2 != fieldLimit) goto L12;
        return position2;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList output = (IntArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        position2 = decodeVarint32(data, position2, registers);
        output.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList output = (LongArrayList) list;
        int position2 = decodeVarint32(data, position, registers);
        int fieldLimit = registers.int1 + position2;
    L3:
        if (position2 >= fieldLimit) goto L5;
        position2 = decodeVarint64(data, position2, registers);
        output.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        goto L3
    L5:
        if (position2 != fieldLimit) goto L8;
        return position2;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodeStringList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) goto L22;
        if (length != 0) goto L7;
        list.add("");
    L8:
        if (position2 >= limit) goto L20;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L20;
        position2 = decodeVarint32(data, nextPosition, registers);
        int nextLength = registers.int1;
        if (nextLength < 0) goto L19;
        if (nextLength == 0) goto L15;
        String value = new String(data, position2, nextLength, Internal.UTF_8);
        list.add(value);
        position2 = position2 + nextLength;
        goto L8
    L15:
        list.add("");
        goto L8
    L19:
        throw InvalidProtocolBufferException.negativeSize();
    L20:
        return position2;
    L7:
        String value2 = new String(data, position2, length, Internal.UTF_8);
        list.add(value2);
        position2 = position2 + length;
        goto L8
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringListRequireUtf8(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) goto L30;
        if (length != 0) goto L8;
        list.add("");
    L10:
        if (position2 >= limit) goto L26;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L26;
        position2 = decodeVarint32(data, nextPosition, registers);
        int nextLength = registers.int1;
        if (nextLength < 0) goto L25;
        if (nextLength == 0) goto L17;
        if (Utf8.isValidUtf8(data, position2, position2 + nextLength) == false) goto L23;
        String value = new String(data, position2, nextLength, Internal.UTF_8);
        list.add(value);
        position2 = position2 + nextLength;
        goto L10
    L23:
        throw InvalidProtocolBufferException.invalidUtf8();
    L17:
        list.add("");
        goto L10
    L25:
        throw InvalidProtocolBufferException.negativeSize();
    L26:
        return position2;
    L8:
        if (Utf8.isValidUtf8(data, position2, position2 + length) == false) goto L28;
        String value2 = new String(data, position2, length, Internal.UTF_8);
        list.add(value2);
        position2 = position2 + length;
        goto L10
    L28:
        throw InvalidProtocolBufferException.invalidUtf8();
    L30:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeBytesList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int position2 = decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length < 0) goto L29;
        if (length > (data.length - position2)) goto L27;
        if (length != 0) goto L8;
        list.add(ByteString.EMPTY);
    L9:
        if (position2 >= limit) goto L25;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L25;
        position2 = decodeVarint32(data, nextPosition, registers);
        int nextLength = registers.int1;
        if (nextLength < 0) goto L24;
        if (nextLength > (data.length - position2)) goto L22;
        if (nextLength == 0) goto L18;
        list.add(ByteString.copyFrom(data, position2, nextLength));
        position2 = position2 + nextLength;
        goto L9
    L18:
        list.add(ByteString.EMPTY);
        goto L9
    L22:
        throw InvalidProtocolBufferException.truncatedMessage();
    L24:
        throw InvalidProtocolBufferException.negativeSize();
    L25:
        return position2;
    L8:
        list.add(ByteString.copyFrom(data, position2, length));
        position2 = position2 + length;
        goto L9
    L27:
        throw InvalidProtocolBufferException.truncatedMessage();
    L29:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeMessageList(Schema<?> schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int position2 = decodeMessageField(schema, data, position, limit, registers);
        list.add(registers.object1);
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        position2 = decodeMessageField(schema, data, nextPosition, limit, registers);
        list.add(registers.object1);
    L8:
        return position2;
    }

    static int decodeGroupList(Schema schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int endgroup = (tag & (-8)) | 4;
        int position2 = decodeGroupField(schema, data, position, limit, endgroup, registers);
        list.add(registers.object1);
    L3:
        if (position2 >= limit) goto L8;
        int nextPosition = decodeVarint32(data, position2, registers);
        if (tag != registers.int1) goto L8;
        position2 = decodeGroupField(schema, data, nextPosition, limit, endgroup, registers);
        list.add(registers.object1);
    L8:
        return position2;
    }

    static int decodeExtensionOrUnknownField(int tag, byte[] data, int position, int limit, Object message, MessageLite defaultInstance, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        int number = tag >>> 3;
        GeneratedMessageLite.GeneratedExtension extension = registers.extensionRegistry.findLiteExtensionByNumber(defaultInstance, number);
        if (extension == null) goto L5;
        ((GeneratedMessageLite.ExtendableMessage) message).ensureExtensionsAreMutable();
        return decodeExtension(tag, data, position, limit, (GeneratedMessageLite.ExtendableMessage) message, extension, unknownFieldSchema, registers);
    L5:
        return decodeUnknownField(tag, data, position, limit, MessageSchema.getMutableUnknownFields(message), registers);
    }

    static int decodeExtension(int tag, byte[] data, int position, int limit, GeneratedMessageLite.ExtendableMessage<?, ?> message, GeneratedMessageLite.GeneratedExtension<?, ?> extension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions = message.extensions;
        int fieldNumber = tag >>> 3;
        if (extension.descriptor.isRepeated() == true) goto L5;
    L20:
        Object value = null;
        if (extension.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
        int position2 = decodeVarint32(data, position, registers);
        Object enumValue = extension.descriptor.getEnumType().findValueByNumber(registers.int1);
        if (enumValue != null) goto L26;
        SchemaUtil.storeUnknownEnum(message, fieldNumber, registers.int1, null, unknownFieldSchema);
        return position2;
    L26:
        value = Integer.valueOf(registers.int1);
    L64:
        if (extension.isRepeated() == false) goto L66;
        extensions.addRepeatedField(extension.descriptor, value);
    L68:
        return position2;
    L66:
        extensions.setField(extension.descriptor, value);
        goto L68
    L28:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extension.getLiteType().ordinal()]) {
            case 1: goto L62;
            case 2: goto L61;
            case 3: goto L60;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L57;
            case 11: goto L52;
            case 12: goto L51;
            case 13: goto L50;
            case 14: goto L49;
            case 15: goto L47;
            case 16: goto L46;
            case 17: goto L38;
            case 18: goto L30;
            default: goto L29;
        };
    L29:
        position2 = position;
        goto L64
    L30:
        Schema fieldSchema = Protobuf.getInstance().schemaFor(extension.getMessageDefaultInstance().getClass());
        if (extension.isRepeated() == false) goto L33;
        int position3 = decodeMessageField(fieldSchema, data, position, limit, registers);
        extensions.addRepeatedField(extension.descriptor, registers.object1);
        return position3;
    L33:
        Object oldValue = extensions.getField(extension.descriptor);
        if (oldValue != null) goto L37;
        oldValue = fieldSchema.newInstance();
        extensions.setField(extension.descriptor, oldValue);
    L37:
        return mergeMessageField(oldValue, fieldSchema, data, position, limit, registers);
    L38:
        int endTag = (fieldNumber << 3) | 4;
        Schema fieldSchema2 = Protobuf.getInstance().schemaFor(extension.getMessageDefaultInstance().getClass());
        if (extension.isRepeated() == false) goto L41;
        int position4 = decodeGroupField(fieldSchema2, data, position, limit, endTag, registers);
        extensions.addRepeatedField(extension.descriptor, registers.object1);
        return position4;
    L41:
        Object oldValue2 = extensions.getField(extension.descriptor);
        if (oldValue2 != null) goto L45;
        oldValue2 = fieldSchema2.newInstance();
        extensions.setField(extension.descriptor, oldValue2);
    L45:
        return mergeGroupField(oldValue2, fieldSchema2, data, position, limit, endTag, registers);
    L46:
        position2 = decodeString(data, position, registers);
        value = registers.object1;
        goto L64
    L47:
        position2 = decodeBytes(data, position, registers);
        value = registers.object1;
        goto L64
    L50:
        position2 = decodeVarint64(data, position, registers);
        value = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
        goto L64
    L51:
        position2 = decodeVarint32(data, position, registers);
        value = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
        goto L64
    L52:
        position2 = decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L55;
        boolean r1 = true;
    L56:
        value = Boolean.valueOf(r1);
        goto L64
    L55:
        r1 = false;
        goto L56
    L57:
        value = Integer.valueOf(decodeFixed32(data, position));
        position2 = position + 4;
        goto L64
    L58:
        value = Long.valueOf(decodeFixed64(data, position));
        position2 = position + 8;
        goto L64
    L59:
        position2 = decodeVarint32(data, position, registers);
        value = Integer.valueOf(registers.int1);
        goto L64
    L60:
        position2 = decodeVarint64(data, position, registers);
        value = Long.valueOf(registers.long1);
        goto L64
    L61:
        value = Float.valueOf(decodeFloat(data, position));
        position2 = position + 4;
        goto L64
    L62:
        value = Double.valueOf(decodeDouble(data, position));
        position2 = position + 8;
        goto L64
    L49:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (extension.descriptor.isPacked() == false) goto L20;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extension.getLiteType().ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        IntArrayList list = new IntArrayList();
        int position5 = decodePackedVarint32List(data, position, list, registers);
        SchemaUtil.filterUnknownEnumList(message, fieldNumber, list, extension.descriptor.getEnumType(), null, unknownFieldSchema);
        extensions.setField(extension.descriptor, list);
        return position5;
    L11:
        LongArrayList list2 = new LongArrayList();
        int position6 = decodePackedSInt64List(data, position, list2, registers);
        extensions.setField(extension.descriptor, list2);
        return position6;
    L12:
        IntArrayList list3 = new IntArrayList();
        int position7 = decodePackedSInt32List(data, position, list3, registers);
        extensions.setField(extension.descriptor, list3);
        return position7;
    L13:
        BooleanArrayList list4 = new BooleanArrayList();
        int position8 = decodePackedBoolList(data, position, list4, registers);
        extensions.setField(extension.descriptor, list4);
        return position8;
    L14:
        IntArrayList list5 = new IntArrayList();
        int position9 = decodePackedFixed32List(data, position, list5, registers);
        extensions.setField(extension.descriptor, list5);
        return position9;
    L15:
        LongArrayList list6 = new LongArrayList();
        int position10 = decodePackedFixed64List(data, position, list6, registers);
        extensions.setField(extension.descriptor, list6);
        return position10;
    L16:
        IntArrayList list7 = new IntArrayList();
        int position11 = decodePackedVarint32List(data, position, list7, registers);
        extensions.setField(extension.descriptor, list7);
        return position11;
    L17:
        LongArrayList list8 = new LongArrayList();
        int position12 = decodePackedVarint64List(data, position, list8, registers);
        extensions.setField(extension.descriptor, list8);
        return position12;
    L18:
        FloatArrayList list9 = new FloatArrayList();
        int position13 = decodePackedFloatList(data, position, list9, registers);
        extensions.setField(extension.descriptor, list9);
        return position13;
    L19:
        DoubleArrayList list10 = new DoubleArrayList();
        int position14 = decodePackedDoubleList(data, position, list10, registers);
        extensions.setField(extension.descriptor, list10);
        return position14;
    L9:
        throw new IllegalStateException("Type cannot be packed: " + extension.descriptor.getLiteType());
    }

    static int decodeUnknownField(int tag, byte[] data, int position, int limit, UnknownFieldSetLite unknownFields, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) goto L41;
        switch(WireFormat.getTagWireType(tag)) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L23;
            case 3: goto L10;
            case 4: goto L7;
            case 5: goto L8;
            default: goto L7;
        };
    L8:
        unknownFields.storeField(tag, Integer.valueOf(decodeFixed32(data, position)));
        return position + 4;
    L10:
        UnknownFieldSetLite child = UnknownFieldSetLite.newInstance();
        int endGroup = (tag & (-8)) | 4;
        int lastTag = 0;
    L11:
        if (position >= limit) goto L17;
        int position2 = decodeVarint32(data, position, registers);
        lastTag = registers.int1;
        if (lastTag == endGroup) goto L14;
        position = decodeUnknownField(lastTag, data, position2, limit, child, registers);
        goto L11
    L14:
        position = position2;
    L17:
        if (position > limit) goto L22;
        if (lastTag != endGroup) goto L22;
        unknownFields.storeField(tag, child);
        return position;
    L22:
        throw InvalidProtocolBufferException.parseFailure();
    L23:
        int position3 = decodeVarint32(data, position, registers);
        int position4 = registers.int1;
        if (position4 < 0) goto L35;
        if (position4 > (data.length - position3)) goto L33;
        if (position4 != 0) goto L29;
        unknownFields.storeField(tag, ByteString.EMPTY);
    L31:
        return position3 + position4;
    L29:
        unknownFields.storeField(tag, ByteString.copyFrom(data, position3, position4));
        goto L31
    L33:
        throw InvalidProtocolBufferException.truncatedMessage();
    L35:
        throw InvalidProtocolBufferException.negativeSize();
    L36:
        unknownFields.storeField(tag, Long.valueOf(decodeFixed64(data, position)));
        return position + 8;
    L38:
        int position5 = decodeVarint64(data, position, registers);
        unknownFields.storeField(tag, Long.valueOf(registers.long1));
        return position5;
    L7:
        throw InvalidProtocolBufferException.invalidTag();
    L41:
        throw InvalidProtocolBufferException.invalidTag();
    }

    static int skipField(int tag, byte[] data, int position, int limit, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) goto L28;
        switch(WireFormat.getTagWireType(tag)) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L21;
            case 3: goto L10;
            case 4: goto L7;
            case 5: goto L9;
            default: goto L7;
        };
    L10:
        int endGroup = (tag & (-8)) | 4;
        int lastTag = 0;
    L11:
        if (position >= limit) goto L16;
        position = decodeVarint32(data, position, registers);
        lastTag = registers.int1;
        if (lastTag == endGroup) goto L16;
        position = skipField(lastTag, data, position, limit, registers);
    L16:
        if (position > limit) goto L20;
        if (lastTag != endGroup) goto L20;
        return position;
    L20:
        throw InvalidProtocolBufferException.parseFailure();
    L21:
        int position2 = decodeVarint32(data, position, registers);
        return registers.int1 + position2;
    L7:
        throw InvalidProtocolBufferException.invalidTag();
    L9:
        return position + 4;
    L24:
        return position + 8;
    L26:
        return decodeVarint64(data, position, registers);
    L28:
        throw InvalidProtocolBufferException.invalidTag();
    }
}
