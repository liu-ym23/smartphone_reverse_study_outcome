package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ArrayDecoders {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* JADX INFO: renamed from: com.google.protobuf.ArrayDecoders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite r1) {
            Objects.requireNonNull(r1);
            this.extensionRegistry = r1;
        }
    }

    static {
    }

    private ArrayDecoders() {
    }

    static int decodeVarint32(byte[] r1, int r2, Registers r3) {
        int r0 = r2 + 1;
        byte r4 = r1[r2];
        if (r4 < 0) goto L7;
        r3.int1 = r4;
        return r0;
    L7:
        return decodeVarint32(r4, r1, r0, r3);
    }

    static int decodeVarint32(int r1, byte[] r2, int r3, Registers r4) {
        int r5 = r1 & 127;
        int r0 = r3 + 1;
        byte r6 = r2[r3];
        if (r6 < 0) goto L6;
        r4.int1 = r5 | (r6 << 7);
        return r0;
    L6:
        int r7 = r5 | ((r6 & 127) << 7);
        int r8 = r0 + 1;
        byte r9 = r2[r0];
        if (r9 < 0) goto L10;
        r4.int1 = r7 | (r9 << 14);
        return r8;
    L10:
        int r10 = r7 | ((r9 & 127) << 14);
        int r11 = r8 + 1;
        byte r12 = r2[r8];
        if (r12 < 0) goto L14;
        r4.int1 = r10 | (r12 << 21);
        return r11;
    L14:
        int r13 = r10 | ((r12 & 127) << 21);
        int r14 = r11 + 1;
        byte r15 = r2[r11];
        if (r15 < 0) goto L18;
        r4.int1 = r13 | (r15 << 28);
        return r14;
    L18:
        int r16 = r13 | ((r15 & 127) << 28);
    L19:
        int r17 = r14 + 1;
        if (r2[r14] >= 0) goto L22;
        r14 = r17;
        goto L19
    L22:
        r4.int1 = r16;
        return r17;
    }

    static int decodeVarint64(byte[] r5, int r6, Registers r7) {
        int r0 = r6 + 1;
        long r1 = r5[r6];
        if (r1 < 0) goto L7;
        r7.long1 = r1;
        return r0;
    L7:
        return decodeVarint64(r1, r5, r0, r7);
    }

    static int decodeVarint64(long r7, byte[] r9, int r10, Registers r11) {
        int r0 = r10 + 1;
        byte r12 = r9[r10];
        long r8 = (r7 & 127) | (((long) (r12 & 127)) << 7);
        int r1 = 7;
    L3:
        if (r12 >= 0) goto L5;
        int r13 = r0 + 1;
        byte r2 = r9[r0];
        r1 = r1 + 7;
        r8 = r8 | (((long) (r2 & 127)) << r1);
        r0 = r13;
        r12 = r2;
        goto L3
    L5:
        r11.long1 = r8;
        return r0;
    }

    static int decodeFixed32(byte[] r2, int r3) {
        int r0 = ((r2[r3] & 255) | ((r2[r3 + 1] & 255) << 8)) | ((r2[r3 + 2] & 255) << 16);
        return ((r2[r3 + 3] & 255) << 24) | r0;
    }

    static long decodeFixed64(byte[] r7, int r8) {
        long r0 = ((((((((long) r7[r8]) & 255) | ((((long) r7[r8 + 1]) & 255) << 8)) | ((((long) r7[r8 + 2]) & 255) << 16)) | ((((long) r7[r8 + 3]) & 255) << 24)) | ((((long) r7[r8 + 4]) & 255) << 32)) | ((((long) r7[r8 + 5]) & 255) << 40)) | ((((long) r7[r8 + 6]) & 255) << 48);
        return ((((long) r7[r8 + 7]) & 255) << 56) | r0;
    }

    static double decodeDouble(byte[] r0, int r1) {
        return Double.longBitsToDouble(decodeFixed64(r0, r1));
    }

    static float decodeFloat(byte[] r0, int r1) {
        return Float.intBitsToFloat(decodeFixed32(r0, r1));
    }

    static int decodeString(byte[] r3, int r4, Registers r5) {
        int r6 = decodeVarint32(r3, r4, r5);
        int r0 = r5.int1;
        if (r0 < 0) goto L10;
        if (r0 != 0) goto L7;
        r5.object1 = "";
        return r6;
    L7:
        r5.object1 = new String(r3, r6, r0, Internal.UTF_8);
        return r6 + r0;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringRequireUtf8(byte[] r1, int r2, Registers r3) {
        int r4 = decodeVarint32(r1, r2, r3);
        int r0 = r3.int1;
        if (r0 < 0) goto L10;
        if (r0 != 0) goto L7;
        r3.object1 = "";
        return r4;
    L7:
        r3.object1 = Utf8.decodeUtf8(r1, r4, r0);
        return r4 + r0;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeBytes(byte[] r2, int r3, Registers r4) {
        int r5 = decodeVarint32(r2, r3, r4);
        int r0 = r4.int1;
        if (r0 < 0) goto L14;
        if (r0 > (r2.length - r5)) goto L12;
        if (r0 != 0) goto L9;
        r4.object1 = ByteString.EMPTY;
        return r5;
    L9:
        r4.object1 = ByteString.copyFrom(r2, r5, r0);
        return r5 + r0;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> int decodeMessageField(Schema<T> r7, byte[] r8, int r9, int r10, Registers r11) {
        Schema r12 = (Schema) ZeusTransformUtils.wrapperContextForParams(r7, Schema.class, "com.obric.aiagent.plugin");
        Object r6 = r12.newInstance();
        int r13 = mergeMessageField(r6, r12, r8, r9, r10, r11);
        r12.makeImmutable(r6);
        r11.object1 = r6;
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> int decodeGroupField(Schema<T> r8, byte[] r9, int r10, int r11, int r12, Registers r13) {
        Schema r14 = (Schema) ZeusTransformUtils.wrapperContextForParams(r8, Schema.class, "com.obric.aiagent.plugin");
        Object r7 = r14.newInstance();
        int r15 = mergeGroupField(r7, r14, r9, r10, r11, r12, r13);
        r14.makeImmutable(r7);
        r13.object1 = r7;
        return r15;
    }

    static <T> int mergeMessageField(Object r6, Schema<T> r7, byte[] r8, int r9, int r10, Registers r11) {
        Schema r0 = (Schema) ZeusTransformUtils.wrapperContextForParams(r7, Schema.class, "com.obric.aiagent.plugin");
        int r12 = r9 + 1;
        int r13 = r8[r9];
        if (r13 >= 0) goto L5;
        r12 = decodeVarint32(r13, r8, r12, r11);
        r13 = r11.int1;
    L5:
        int r3 = r12;
        if (r13 < 0) goto L12;
        if (r13 > (r10 - r3)) goto L12;
        r11.recursionDepth++;
        checkRecursionLimit(r11.recursionDepth);
        int r14 = r13 + r3;
        r0.mergeFrom(r6, r8, r3, r14, r11);
        r11.recursionDepth--;
        r11.object1 = r6;
        return r14;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static <T> int mergeGroupField(Object r7, Schema<T> r8, byte[] r9, int r10, int r11, int r12, Registers r13) {
        MessageSchema r0 = (MessageSchema) ZeusTransformUtils.preCheckCast((Schema) ZeusTransformUtils.wrapperContextForParams(r8, Schema.class, "com.obric.aiagent.plugin"), MessageSchema.class, "com.obric.aiagent.plugin");
        r13.recursionDepth++;
        checkRecursionLimit(r13.recursionDepth);
        int r14 = r0.parseMessage(r7, r9, r10, r11, r12, r13);
        r13.recursionDepth--;
        r13.object1 = r7;
        return r14;
    }

    static int decodeVarint32List(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), IntArrayList.class, "com.obric.aiagent.plugin");
        int r9 = decodeVarint32(r3, r4, r7);
        r8.addInt(r7.int1);
    L3:
        if (r9 >= r5) goto L8;
        int r0 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L8;
        r9 = decodeVarint32(r3, r0, r7);
        r8.addInt(r7.int1);
    L8:
        return r9;
    }

    static int decodeVarint64List(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        LongArrayList r8 = (LongArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), LongArrayList.class, "com.obric.aiagent.plugin");
        int r9 = decodeVarint64(r3, r4, r7);
        r8.addLong(r7.long1);
    L3:
        if (r9 >= r5) goto L8;
        int r0 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L8;
        r9 = decodeVarint64(r3, r0, r7);
        r8.addLong(r7.long1);
    L8:
        return r9;
    }

    static int decodeFixed32List(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), IntArrayList.class, "com.obric.aiagent.plugin");
        r8.addInt(decodeFixed32(r3, r4));
        int r9 = r4 + 4;
    L3:
        if (r9 >= r5) goto L8;
        int r0 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L8;
        r8.addInt(decodeFixed32(r3, r0));
        r9 = r0 + 4;
    L8:
        return r9;
    }

    static int decodeFixed64List(int r3, byte[] r4, int r5, int r6, Internal.ProtobufList<?> r7, Registers r8) {
        LongArrayList r9 = (LongArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r7, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), LongArrayList.class, "com.obric.aiagent.plugin");
        r9.addLong(decodeFixed64(r4, r5));
        int r10 = r5 + 8;
    L3:
        if (r10 >= r6) goto L8;
        int r0 = decodeVarint32(r4, r10, r8);
        if (r3 != r8.int1) goto L8;
        r9.addLong(decodeFixed64(r4, r0));
        r10 = r0 + 8;
    L8:
        return r10;
    }

    static int decodeFloatList(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        FloatArrayList r8 = (FloatArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), FloatArrayList.class, "com.obric.aiagent.plugin");
        r8.addFloat(decodeFloat(r3, r4));
        int r9 = r4 + 4;
    L3:
        if (r9 >= r5) goto L8;
        int r0 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L8;
        r8.addFloat(decodeFloat(r3, r0));
        r9 = r0 + 4;
    L8:
        return r9;
    }

    static int decodeDoubleList(int r3, byte[] r4, int r5, int r6, Internal.ProtobufList<?> r7, Registers r8) {
        DoubleArrayList r9 = (DoubleArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r7, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), DoubleArrayList.class, "com.obric.aiagent.plugin");
        r9.addDouble(decodeDouble(r4, r5));
        int r10 = r5 + 8;
    L3:
        if (r10 >= r6) goto L8;
        int r0 = decodeVarint32(r4, r10, r8);
        if (r3 != r8.int1) goto L8;
        r9.addDouble(decodeDouble(r4, r0));
        r10 = r0 + 8;
    L8:
        return r10;
    }

    static int decodeBoolList(int r7, byte[] r8, int r9, int r10, Internal.ProtobufList<?> r11, Registers r12) {
        BooleanArrayList r13 = (BooleanArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r11, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), BooleanArrayList.class, "com.obric.aiagent.plugin");
        int r14 = decodeVarint64(r8, r9, r12);
        if (r12.long1 == 0) goto L5;
        boolean r0 = true;
    L6:
        r13.addBoolean(r0);
    L7:
        if (r14 >= r10) goto L16;
        int r1 = decodeVarint32(r8, r14, r12);
        if (r7 != r12.int1) goto L16;
        r14 = decodeVarint64(r8, r1, r12);
        if (r12.long1 == 0) goto L14;
        boolean r2 = true;
    L15:
        r13.addBoolean(r2);
        goto L7
    L14:
        r2 = false;
    L16:
        return r14;
    L5:
        r0 = false;
        goto L6
    }

    static int decodeSInt32List(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), IntArrayList.class, "com.obric.aiagent.plugin");
        int r9 = decodeVarint32(r3, r4, r7);
        r8.addInt(CodedInputStream.decodeZigZag32(r7.int1));
    L3:
        if (r9 >= r5) goto L8;
        int r0 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L8;
        r9 = decodeVarint32(r3, r0, r7);
        r8.addInt(CodedInputStream.decodeZigZag32(r7.int1));
    L8:
        return r9;
    }

    static int decodeSInt64List(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        LongArrayList r8 = (LongArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), LongArrayList.class, "com.obric.aiagent.plugin");
        int r9 = decodeVarint64(r3, r4, r7);
        r8.addLong(CodedInputStream.decodeZigZag64(r7.long1));
    L3:
        if (r9 >= r5) goto L8;
        int r0 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L8;
        r9 = decodeVarint64(r3, r0, r7);
        r8.addLong(CodedInputStream.decodeZigZag64(r7.long1));
    L8:
        return r9;
    }

    static int decodePackedVarint32List(byte[] r2, int r3, Internal.ProtobufList<?> r4, Registers r5) {
        IntArrayList r6 = (IntArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r4, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), IntArrayList.class, "com.obric.aiagent.plugin");
        int r7 = decodeVarint32(r2, r3, r5);
        int r0 = r5.int1 + r7;
    L3:
        if (r7 >= r0) goto L5;
        r7 = decodeVarint32(r2, r7, r5);
        r6.addInt(r5.int1);
        goto L3
    L5:
        if (r7 != r0) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] r3, int r4, Internal.ProtobufList<?> r5, Registers r6) {
        LongArrayList r7 = (LongArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r5, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), LongArrayList.class, "com.obric.aiagent.plugin");
        int r8 = decodeVarint32(r3, r4, r6);
        int r0 = r6.int1 + r8;
    L3:
        if (r8 >= r0) goto L5;
        r8 = decodeVarint64(r3, r8, r6);
        r7.addLong(r6.long1);
        goto L3
    L5:
        if (r8 != r0) goto L8;
        return r8;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] r2, int r3, Internal.ProtobufList<?> r4, Registers r5) {
        IntArrayList r6 = (IntArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r4, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), IntArrayList.class, "com.obric.aiagent.plugin");
        int r7 = decodeVarint32(r2, r3, r5);
        int r8 = r5.int1;
        int r0 = r7 + r8;
        if (r0 > r2.length) goto L12;
        r6.ensureCapacity(r6.size() + (r8 / 4));
    L5:
        if (r7 >= r0) goto L7;
        r6.addInt(decodeFixed32(r2, r7));
        r7 = r7 + 4;
        goto L5
    L7:
        if (r7 != r0) goto L10;
        return r7;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] r3, int r4, Internal.ProtobufList<?> r5, Registers r6) {
        LongArrayList r7 = (LongArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r5, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), LongArrayList.class, "com.obric.aiagent.plugin");
        int r8 = decodeVarint32(r3, r4, r6);
        int r9 = r6.int1;
        int r0 = r8 + r9;
        if (r0 > r3.length) goto L12;
        r7.ensureCapacity(r7.size() + (r9 / 8));
    L5:
        if (r8 >= r0) goto L7;
        r7.addLong(decodeFixed64(r3, r8));
        r8 = r8 + 8;
        goto L5
    L7:
        if (r8 != r0) goto L10;
        return r8;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] r2, int r3, Internal.ProtobufList<?> r4, Registers r5) {
        FloatArrayList r6 = (FloatArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r4, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), FloatArrayList.class, "com.obric.aiagent.plugin");
        int r7 = decodeVarint32(r2, r3, r5);
        int r8 = r5.int1;
        int r0 = r7 + r8;
        if (r0 > r2.length) goto L12;
        r6.ensureCapacity(r6.size() + (r8 / 4));
    L5:
        if (r7 >= r0) goto L7;
        r6.addFloat(decodeFloat(r2, r7));
        r7 = r7 + 4;
        goto L5
    L7:
        if (r7 != r0) goto L10;
        return r7;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] r3, int r4, Internal.ProtobufList<?> r5, Registers r6) {
        DoubleArrayList r7 = (DoubleArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r5, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), DoubleArrayList.class, "com.obric.aiagent.plugin");
        int r8 = decodeVarint32(r3, r4, r6);
        int r9 = r6.int1;
        int r0 = r8 + r9;
        if (r0 > r3.length) goto L12;
        r7.ensureCapacity(r7.size() + (r9 / 8));
    L5:
        if (r8 >= r0) goto L7;
        r7.addDouble(decodeDouble(r3, r8));
        r8 = r8 + 8;
        goto L5
    L7:
        if (r8 != r0) goto L10;
        return r8;
    L10:
        throw InvalidProtocolBufferException.truncatedMessage();
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedBoolList(byte[] r5, int r6, Internal.ProtobufList<?> r7, Registers r8) {
        BooleanArrayList r9 = (BooleanArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r7, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), BooleanArrayList.class, "com.obric.aiagent.plugin");
        int r10 = decodeVarint32(r5, r6, r8);
        int r0 = r8.int1 + r10;
    L3:
        if (r10 >= r0) goto L9;
        r10 = decodeVarint64(r5, r10, r8);
        if (r8.long1 == 0) goto L7;
        boolean r1 = true;
    L8:
        r9.addBoolean(r1);
        goto L3
    L7:
        r1 = false;
        goto L8
    L9:
        if (r10 != r0) goto L12;
        return r10;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] r2, int r3, Internal.ProtobufList<?> r4, Registers r5) {
        IntArrayList r6 = (IntArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r4, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), IntArrayList.class, "com.obric.aiagent.plugin");
        int r7 = decodeVarint32(r2, r3, r5);
        int r0 = r5.int1 + r7;
    L3:
        if (r7 >= r0) goto L5;
        r7 = decodeVarint32(r2, r7, r5);
        r6.addInt(CodedInputStream.decodeZigZag32(r5.int1));
        goto L3
    L5:
        if (r7 != r0) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] r3, int r4, Internal.ProtobufList<?> r5, Registers r6) {
        LongArrayList r7 = (LongArrayList) ZeusTransformUtils.preCheckCast((Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r5, Internal.ProtobufList.class, "com.obric.aiagent.plugin"), LongArrayList.class, "com.obric.aiagent.plugin");
        int r8 = decodeVarint32(r3, r4, r6);
        int r0 = r6.int1 + r8;
    L3:
        if (r8 >= r0) goto L5;
        r8 = decodeVarint64(r3, r8, r6);
        r7.addLong(CodedInputStream.decodeZigZag64(r6.long1));
        goto L3
    L5:
        if (r8 != r0) goto L8;
        return r8;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodeStringList(int r4, byte[] r5, int r6, int r7, Internal.ProtobufList<?> r8, Registers r9) {
        Internal.ProtobufList r10 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r8, Internal.ProtobufList.class, "com.obric.aiagent.plugin");
        int r11 = decodeVarint32(r5, r6, r9);
        int r0 = r9.int1;
        if (r0 < 0) goto L22;
        if (r0 != 0) goto L7;
        r10.add("");
    L9:
        if (r11 >= r7) goto L20;
        int r1 = decodeVarint32(r5, r11, r9);
        if (r4 != r9.int1) goto L20;
        r11 = decodeVarint32(r5, r1, r9);
        int r2 = r9.int1;
        if (r2 < 0) goto L19;
        if (r2 == 0) goto L16;
        r10.add(new String(r5, r11, r2, Internal.UTF_8));
        r11 = r11 + r2;
        goto L9
    L16:
        r10.add("");
        goto L9
    L19:
        throw InvalidProtocolBufferException.negativeSize();
    L20:
        return r11;
    L7:
        r10.add(new String(r5, r11, r0, Internal.UTF_8));
        r11 = r11 + r0;
        goto L9
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeStringListRequireUtf8(int r5, byte[] r6, int r7, int r8, Internal.ProtobufList<?> r9, Registers r10) {
        Internal.ProtobufList r11 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r9, Internal.ProtobufList.class, "com.obric.aiagent.plugin");
        int r12 = decodeVarint32(r6, r7, r10);
        int r0 = r10.int1;
        if (r0 < 0) goto L30;
        if (r0 != 0) goto L7;
        r11.add("");
    L11:
        if (r12 >= r8) goto L26;
        int r1 = decodeVarint32(r6, r12, r10);
        if (r5 != r10.int1) goto L26;
        r12 = decodeVarint32(r6, r1, r10);
        int r2 = r10.int1;
        if (r2 < 0) goto L25;
        if (r2 == 0) goto L18;
        int r3 = r12 + r2;
        if (Utf8.isValidUtf8(r6, r12, r3) == false) goto L23;
        r11.add(new String(r6, r12, r2, Internal.UTF_8));
        r12 = r3;
        goto L11
    L23:
        throw InvalidProtocolBufferException.invalidUtf8();
    L18:
        r11.add("");
        goto L11
    L25:
        throw InvalidProtocolBufferException.negativeSize();
    L26:
        return r12;
    L7:
        int r4 = r12 + r0;
        if (Utf8.isValidUtf8(r6, r12, r4) == false) goto L28;
        r11.add(new String(r6, r12, r0, Internal.UTF_8));
        r12 = r4;
        goto L11
    L28:
        throw InvalidProtocolBufferException.invalidUtf8();
    L30:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeBytesList(int r2, byte[] r3, int r4, int r5, Internal.ProtobufList<?> r6, Registers r7) {
        Internal.ProtobufList r8 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r6, Internal.ProtobufList.class, "com.obric.aiagent.plugin");
        int r9 = decodeVarint32(r3, r4, r7);
        int r0 = r7.int1;
        if (r0 < 0) goto L29;
        if (r0 > (r3.length - r9)) goto L27;
        if (r0 != 0) goto L8;
        r8.add(ByteString.EMPTY);
    L10:
        if (r9 >= r5) goto L25;
        int r1 = decodeVarint32(r3, r9, r7);
        if (r2 != r7.int1) goto L25;
        r9 = decodeVarint32(r3, r1, r7);
        int r10 = r7.int1;
        if (r10 < 0) goto L24;
        if (r10 > (r3.length - r9)) goto L22;
        if (r10 == 0) goto L19;
        r8.add(ByteString.copyFrom(r3, r9, r10));
        r9 = r9 + r10;
        goto L10
    L19:
        r8.add(ByteString.EMPTY);
        goto L10
    L22:
        throw InvalidProtocolBufferException.truncatedMessage();
    L24:
        throw InvalidProtocolBufferException.negativeSize();
    L25:
        return r9;
    L8:
        r8.add(ByteString.copyFrom(r3, r9, r0));
        r9 = r9 + r0;
        goto L10
    L27:
        throw InvalidProtocolBufferException.truncatedMessage();
    L29:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int decodeMessageList(Schema<?> r2, int r3, byte[] r4, int r5, int r6, Internal.ProtobufList<?> r7, Registers r8) {
        Schema r9 = (Schema) ZeusTransformUtils.wrapperContextForParams(r2, Schema.class, "com.obric.aiagent.plugin");
        Internal.ProtobufList r10 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r7, Internal.ProtobufList.class, "com.obric.aiagent.plugin");
        int r11 = decodeMessageField(r9, r4, r5, r6, r8);
        r10.add(r8.object1);
    L3:
        if (r11 >= r6) goto L8;
        int r0 = decodeVarint32(r4, r11, r8);
        if (r3 != r8.int1) goto L8;
        r11 = decodeMessageField(r9, r4, r0, r6, r8);
        r10.add(r8.object1);
    L8:
        return r11;
    }

    static int decodeGroupList(Schema<?> r8, int r9, byte[] r10, int r11, int r12, Internal.ProtobufList<Object> r13, Registers r14) {
        Schema r15 = (Schema) ZeusTransformUtils.wrapperContextForParams(r8, Schema.class, "com.obric.aiagent.plugin");
        Internal.ProtobufList r16 = (Internal.ProtobufList) ZeusTransformUtils.wrapperContextForParams(r13, Internal.ProtobufList.class, "com.obric.aiagent.plugin");
        int r0 = (r9 & (-8)) | 4;
        int r17 = decodeGroupField(r15, r10, r11, r12, r0, r14);
        r16.add(r14.object1);
    L3:
        if (r17 >= r12) goto L8;
        int r4 = decodeVarint32(r10, r17, r14);
        if (r9 != r14.int1) goto L8;
        r17 = decodeGroupField(r15, r10, r4, r12, r0, r14);
        r16.add(r14.object1);
    L8:
        return r17;
    }

    static int decodeExtensionOrUnknownField(int r11, byte[] r12, int r13, int r14, Object r15, MessageLite r16, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> r17, Registers r18) {
        ExtensionRegistryLite r4 = r18.extensionRegistry;
        GeneratedMessageLite.GeneratedExtension r8 = r4.findLiteExtensionByNumber((MessageLite) ZeusTransformUtils.wrapperContextForParams(r16, MessageLite.class, "com.obric.aiagent.plugin"), r11 >>> 3);
        if (r8 == null) goto L5;
        ((GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r15, GeneratedMessageLite.ExtendableMessage.class, "com.obric.aiagent.plugin")).ensureExtensionsAreMutable();
        return decodeExtension(r11, r12, r13, r14, (GeneratedMessageLite.ExtendableMessage) ZeusTransformUtils.preCheckCast(r15, GeneratedMessageLite.ExtendableMessage.class, "com.obric.aiagent.plugin"), r8, r17, r18);
    L5:
        return decodeUnknownField(r11, r12, r13, r14, MessageSchema.getMutableUnknownFields(r15), r18);
    }

    static int decodeExtension(int r8, byte[] r9, int r10, int r11, GeneratedMessageLite.ExtendableMessage<?, ?> r12, GeneratedMessageLite.GeneratedExtension<?, ?> r13, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> r14, Registers r15) {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> r0 = r12.extensions;
        int r2 = r8 >>> 3;
        if (r13.descriptor.isRepeated() == true) goto L5;
    L20:
        Object r3 = null;
        if (r13.getLiteType() != WireFormat.FieldType.ENUM) goto L28;
        r10 = decodeVarint32(r9, r10, r15);
        if (r13.descriptor.getEnumType().findValueByNumber(r15.int1) != null) goto L26;
        SchemaUtil.storeUnknownEnum(r12, r2, r15.int1, null, r14);
        return r10;
    L26:
        r3 = Integer.valueOf(r15.int1);
    L66:
        if (r13.isRepeated() == false) goto L68;
        r0.addRepeatedField(r13.descriptor, r3);
    L70:
        return r10;
    L68:
        r0.setField(r13.descriptor, r3);
        goto L70
    L28:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r13.getLiteType().ordinal()]) {
            case 1: goto L63;
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
            default: goto L66;
        };
    L30:
        Schema r4 = Protobuf.getInstance().schemaFor(r13.getMessageDefaultInstance().getClass());
        if (r13.isRepeated() == false) goto L33;
        int r16 = decodeMessageField(r4, r9, r10, r11, r15);
        r0.addRepeatedField(r13.descriptor, r15.object1);
        return r16;
    L33:
        Object r17 = r0.getField(r13.descriptor);
        if (r17 != null) goto L37;
        r17 = r4.newInstance();
        r0.setField(r13.descriptor, r17);
    L37:
        return mergeMessageField(r17, r4, r9, r10, r11, r15);
    L38:
        int r6 = (r2 << 3) | 4;
        Schema r5 = Protobuf.getInstance().schemaFor(r13.getMessageDefaultInstance().getClass());
        if (r13.isRepeated() == false) goto L41;
        int r18 = decodeGroupField(r5, r9, r10, r11, r6, r15);
        r0.addRepeatedField(r13.descriptor, r15.object1);
        return r18;
    L41:
        Object r19 = r0.getField(r13.descriptor);
        if (r19 != null) goto L45;
        r19 = r5.newInstance();
        r0.setField(r13.descriptor, r19);
    L45:
        return mergeGroupField(r19, r5, r9, r10, r11, r6, r15);
    L46:
        r10 = decodeString(r9, r10, r15);
        r3 = r15.object1;
        goto L66
    L47:
        r10 = decodeBytes(r9, r10, r15);
        r3 = r15.object1;
        goto L66
    L50:
        r10 = decodeVarint64(r9, r10, r15);
        r3 = Long.valueOf(CodedInputStream.decodeZigZag64(r15.long1));
        goto L66
    L51:
        r10 = decodeVarint32(r9, r10, r15);
        r3 = Integer.valueOf(CodedInputStream.decodeZigZag32(r15.int1));
        goto L66
    L52:
        r10 = decodeVarint64(r9, r10, r15);
        if (r15.long1 == 0) goto L55;
        boolean r20 = true;
    L56:
        r3 = Boolean.valueOf(r20);
        goto L66
    L55:
        r20 = false;
        goto L56
    L57:
        r3 = Integer.valueOf(decodeFixed32(r9, r10));
    L62:
        r10 = r10 + 4;
        goto L66
    L58:
        r3 = Long.valueOf(decodeFixed64(r9, r10));
    L64:
        r10 = r10 + 8;
        goto L66
    L59:
        r10 = decodeVarint32(r9, r10, r15);
        r3 = Integer.valueOf(r15.int1);
        goto L66
    L60:
        r10 = decodeVarint64(r9, r10, r15);
        r3 = Long.valueOf(r15.long1);
        goto L66
    L61:
        r3 = Float.valueOf(decodeFloat(r9, r10));
        goto L62
    L63:
        r3 = Double.valueOf(decodeDouble(r9, r10));
        goto L64
    L49:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r13.descriptor.isPacked() == false) goto L20;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r13.getLiteType().ordinal()]) {
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
        IntArrayList r21 = new IntArrayList();
        int r22 = decodePackedVarint32List(r9, r10, r21, r15);
        SchemaUtil.filterUnknownEnumList(r12, r2, r21, r13.descriptor.getEnumType(), null, r14);
        r0.setField(r13.descriptor, r21);
        return r22;
    L11:
        LongArrayList r23 = new LongArrayList();
        int r24 = decodePackedSInt64List(r9, r10, r23, r15);
        r0.setField(r13.descriptor, r23);
        return r24;
    L12:
        IntArrayList r25 = new IntArrayList();
        int r26 = decodePackedSInt32List(r9, r10, r25, r15);
        r0.setField(r13.descriptor, r25);
        return r26;
    L13:
        BooleanArrayList r27 = new BooleanArrayList();
        int r28 = decodePackedBoolList(r9, r10, r27, r15);
        r0.setField(r13.descriptor, r27);
        return r28;
    L14:
        IntArrayList r29 = new IntArrayList();
        int r30 = decodePackedFixed32List(r9, r10, r29, r15);
        r0.setField(r13.descriptor, r29);
        return r30;
    L15:
        LongArrayList r31 = new LongArrayList();
        int r32 = decodePackedFixed64List(r9, r10, r31, r15);
        r0.setField(r13.descriptor, r31);
        return r32;
    L16:
        IntArrayList r33 = new IntArrayList();
        int r34 = decodePackedVarint32List(r9, r10, r33, r15);
        r0.setField(r13.descriptor, r33);
        return r34;
    L17:
        LongArrayList r35 = new LongArrayList();
        int r36 = decodePackedVarint64List(r9, r10, r35, r15);
        r0.setField(r13.descriptor, r35);
        return r36;
    L18:
        FloatArrayList r37 = new FloatArrayList();
        int r38 = decodePackedFloatList(r9, r10, r37, r15);
        r0.setField(r13.descriptor, r37);
        return r38;
    L19:
        DoubleArrayList r39 = new DoubleArrayList();
        int r40 = decodePackedDoubleList(r9, r10, r39, r15);
        r0.setField(r13.descriptor, r39);
        return r40;
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r13.descriptor.getLiteType());
    }

    static int decodeUnknownField(int r10, byte[] r11, int r12, int r13, UnknownFieldSetLite r14, Registers r15) {
        if (WireFormat.getTagFieldNumber(r10) == 0) goto L49;
        int r0 = WireFormat.getTagWireType(r10);
        if (r0 != 0) goto L7;
        int r16 = decodeVarint64(r11, r12, r15);
        r14.storeField(r10, Long.valueOf(r15.long1));
        return r16;
    L7:
        if (r0 != 1) goto L9;
        r14.storeField(r10, Long.valueOf(decodeFixed64(r11, r12)));
        return r12 + 8;
    L9:
        if (r0 != 2) goto L11;
        int r17 = decodeVarint32(r11, r12, r15);
        int r18 = r15.int1;
        if (r18 < 0) goto L43;
        if (r18 > (r11.length - r17)) goto L41;
        if (r18 != 0) goto L37;
        r14.storeField(r10, ByteString.EMPTY);
    L39:
        return r17 + r18;
    L37:
        r14.storeField(r10, ByteString.copyFrom(r11, r17, r18));
        goto L39
    L41:
        throw InvalidProtocolBufferException.truncatedMessage();
    L43:
        throw InvalidProtocolBufferException.negativeSize();
    L11:
        if (r0 != 3) goto L13;
        UnknownFieldSetLite r1 = UnknownFieldSetLite.newInstance();
        int r8 = (r10 & (-8)) | 4;
        int r2 = 0;
        r15.recursionDepth++;
        checkRecursionLimit(r15.recursionDepth);
    L19:
        if (r12 >= r13) goto L24;
        int r4 = decodeVarint32(r11, r12, r15);
        int r19 = r15.int1;
        if (r19 == r8) goto L22;
        r2 = r19;
        r12 = decodeUnknownField(r19, r11, r4, r13, r1, r15);
        goto L19
    L22:
        r2 = r19;
        r12 = r4;
    L24:
        r15.recursionDepth--;
        if (r12 > r13) goto L30;
        if (r2 != r8) goto L30;
        r14.storeField(r10, r1);
        return r12;
    L30:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r0 != 5) goto L17;
        r14.storeField(r10, Integer.valueOf(decodeFixed32(r11, r12)));
        return r12 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L49:
        throw InvalidProtocolBufferException.invalidTag();
    }

    static int skipField(int r2, byte[] r3, int r4, int r5, Registers r6) {
        if (WireFormat.getTagFieldNumber(r2) == 0) goto L36;
        int r0 = WireFormat.getTagWireType(r2);
        if (r0 == 0) goto L34;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L30;
        if (r0 != 3) goto L13;
        int r7 = (r2 & (-8)) | 4;
        int r1 = 0;
    L19:
        if (r4 >= r5) goto L24;
        r4 = decodeVarint32(r3, r4, r6);
        r1 = r6.int1;
        if (r1 == r7) goto L24;
        r4 = skipField(r1, r3, r4, r5, r6);
    L24:
        if (r4 > r5) goto L28;
        if (r1 != r7) goto L28;
        return r4;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r0 != 5) goto L17;
        return r4 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L30:
        return decodeVarint32(r3, r4, r6) + r6.int1;
    L32:
        return r4 + 8;
    L34:
        return decodeVarint64(r3, r4, r6);
    L36:
        throw InvalidProtocolBufferException.invalidTag();
    }

    public static void setRecursionLimit(int r0) {
        recursionLimit = r0;
    }

    private static void checkRecursionLimit(int r1) {
        if (r1 >= recursionLimit) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
}
