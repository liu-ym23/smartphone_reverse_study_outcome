package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

@CheckReturnValue
/* loaded from: classes2.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i10, int i11, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z10, int[] iArr2, int i12, int i13, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i10;
        this.maxFieldNumber = i11;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z10;
        this.intArray = iArr2;
        this.checkInitializedCount = i12;
        this.repeatedFieldOffsetStart = i13;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t10, T t11, int i10) {
        return isFieldPresent(t10, i10) == isFieldPresent(t11, i10);
    }

    private static <T> boolean booleanAt(T t10, long j10) {
        return UnsafeUtil.getBoolean(t10, j10);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i10, int i11, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
        int i12 = registers.int1;
        if (i12 < 0 || i12 > i11 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i13 = iDecodeVarint32 + i12;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i13) {
            int iDecodeVarint322 = iDecodeVarint32 + 1;
            int i14 = bArr[iDecodeVarint32];
            if (i14 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i14, bArr, iDecodeVarint322, registers);
                i14 = registers.int1;
            }
            int i15 = iDecodeVarint322;
            int i16 = i14 >>> 3;
            int i17 = i14 & 7;
            if (i16 != 1) {
                if (i16 == 2 && i17 == metadata.valueType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i15, i11, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i14, bArr, i15, i11, registers);
                }
            } else if (i17 == metadata.keyType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i15, i11, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i14, bArr, i15, i11, registers);
            }
        }
        if (iDecodeVarint32 != i13) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i13;
    }

    private int decodeMapEntryValue(byte[] bArr, int i10, int i11, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i10, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i10));
                return i10 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i10));
                return i10 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i10));
                return i10 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i10));
                return i10 + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i10, i11, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i10, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t10, long j10) {
        return UnsafeUtil.getDouble(t10, j10);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i10, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i10);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i10)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i10)) == null) ? ub2 : (UB) filterUnknownEnumMap(i10, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub2, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i10, int i11, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub2, i11, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private static <T> float floatAt(T t10, long j10) {
        return UnsafeUtil.getFloat(t10, j10);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i10) {
        return (Internal.EnumVerifier) this.objects[((i10 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i10) {
        return this.objects[(i10 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i10) {
        int i11 = (i10 / 3) * 2;
        Schema schema = (Schema) this.objects[i11];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i11 + 1]);
        this.objects[i11] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t10) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t10));
    }

    private static <T> int intAt(T t10, long j10) {
        return UnsafeUtil.getInt(t10, j10);
    }

    private static boolean isEnforceUtf8(int i10) {
        return (i10 & 536870912) != 0;
    }

    private boolean isFieldPresent(T t10, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? isFieldPresent(t10, i10) : (i12 & i13) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i10) {
        return (i10 & Integer.MIN_VALUE) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i10, int i11) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i10));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!messageFieldSchema.isInitialized(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T t10, int i10, int i11) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t10, offset(i10)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t10, T t11, int i10) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i10) & 1048575;
        return UnsafeUtil.getInt(t10, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t11, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t10, int i10, int i11) {
        return UnsafeUtil.getInt(t10, (long) (presenceMaskAndOffsetAt(i11) & 1048575)) == i10;
    }

    private static boolean isRequired(int i10) {
        return (i10 & 268435456) != 0;
    }

    private static <T> long longAt(T t10, long j10) {
        return UnsafeUtil.getLong(t10, j10);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r18, com.google.protobuf.ExtensionSchema<ET> r19, T r20, com.google.protobuf.Reader r21, com.google.protobuf.ExtensionRegistryLite r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2036
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i10, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i10));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t10, T t11, int i10) {
        if (isFieldPresent(t11, i10)) {
            long jOffset = offset(typeAndOffsetAt(i10));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t11, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i10) + " is present but null: " + t11);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i10);
            if (!isFieldPresent(t10, i10)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t10, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t10, jOffset, object);
                }
                setFieldPresent(t10, i10);
                return;
            }
            Object object2 = unsafe.getObject(t10, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t10, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t10, T t11, int i10) {
        int iNumberAt = numberAt(i10);
        if (isOneofPresent(t11, iNumberAt, i10)) {
            long jOffset = offset(typeAndOffsetAt(i10));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t11, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i10) + " is present but null: " + t11);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i10);
            if (!isOneofPresent(t10, iNumberAt, i10)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t10, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t10, jOffset, object);
                }
                setOneofPresent(t10, iNumberAt, i10);
                return;
            }
            Object object2 = unsafe.getObject(t10, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t10, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t10, T t11, int i10) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i10);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i10);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putDouble(t10, jOffset, UnsafeUtil.getDouble(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putFloat(t10, jOffset, UnsafeUtil.getFloat(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putBoolean(t10, jOffset, UnsafeUtil.getBoolean(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 9:
                mergeMessage(t10, t11, i10);
                break;
            case 10:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putInt(t10, jOffset, UnsafeUtil.getInt(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t11, i10)) {
                    UnsafeUtil.putLong(t10, jOffset, UnsafeUtil.getLong(t11, jOffset));
                    setFieldPresent(t10, i10);
                    break;
                }
                break;
            case 17:
                mergeMessage(t10, t11, i10);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t10, t11, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t10, t11, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t11, iNumberAt, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setOneofPresent(t10, iNumberAt, i10);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t10, t11, i10);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t11, iNumberAt, i10)) {
                    UnsafeUtil.putObject(t10, jOffset, UnsafeUtil.getObject(t11, jOffset));
                    setOneofPresent(t10, iNumberAt, i10);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t10, t11, i10);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t10, int i10) {
        Schema messageFieldSchema = getMessageFieldSchema(i10);
        long jOffset = offset(typeAndOffsetAt(i10));
        if (!isFieldPresent(t10, i10)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t10, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t10, int i10, int i11) {
        Schema messageFieldSchema = getMessageFieldSchema(i11);
        if (!isOneofPresent(t10, i10, i11)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t10, offset(typeAndOffsetAt(i11)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i10;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i11 = 0;
        int i12 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i11++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i12++;
            }
        }
        int[] iArr2 = i11 > 0 ? new int[i11] : null;
        int[] iArr3 = i12 > 0 ? new int[i12] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i13 < fields.length) {
            FieldInfo fieldInfo2 = fields[i13];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i14, objArr);
            if (i15 < checkInitialized.length && checkInitialized[i15] == fieldNumber3) {
                checkInitialized[i15] = i14;
                i15++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i16] = i14;
                i16++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    i10 = i14;
                    iArr3[i17] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i17++;
                }
                i13++;
                i14 = i10 + 3;
            }
            i10 = i14;
            i13++;
            i14 = i10 + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0375  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> com.google.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo r33, com.google.protobuf.NewInstanceSchema r34, com.google.protobuf.ListFieldSchema r35, com.google.protobuf.UnknownFieldSchema<?, ?> r36, com.google.protobuf.ExtensionSchema<?> r37, com.google.protobuf.MapFieldSchema r38) {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.protobuf.RawMessageInfo, com.google.protobuf.NewInstanceSchema, com.google.protobuf.ListFieldSchema, com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, com.google.protobuf.MapFieldSchema):com.google.protobuf.MessageSchema");
    }

    private int numberAt(int i10) {
        return this.buffer[i10];
    }

    private static long offset(int i10) {
        return i10 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t10, long j10) {
        return ((Boolean) UnsafeUtil.getObject(t10, j10)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t10, long j10) {
        return ((Double) UnsafeUtil.getObject(t10, j10)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t10, long j10) {
        return ((Float) UnsafeUtil.getObject(t10, j10)).floatValue();
    }

    private static <T> int oneofIntAt(T t10, long j10) {
        return ((Integer) UnsafeUtil.getObject(t10, j10)).intValue();
    }

    private static <T> long oneofLongAt(T t10, long j10) {
        return ((Long) UnsafeUtil.getObject(t10, j10)).longValue();
    }

    private <K, V> int parseMapField(T t10, byte[] bArr, int i10, int i11, int i12, long j10, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i12);
        Object object = unsafe.getObject(t10, j10);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t10, j10, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i10, i11, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j11 = this.buffer[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 != 1) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i10)));
                int i18 = i10 + 8;
                unsafe.putInt(t10, j11, i13);
                return i18;
            case 52:
                if (i14 != 5) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i10)));
                int i19 = i10 + 4;
                unsafe.putInt(t10, j11, i13);
                return i19;
            case 53:
            case 54:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                unsafe.putObject(t10, j10, Long.valueOf(registers.long1));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                unsafe.putObject(t10, j10, Integer.valueOf(registers.int1));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i14 != 1) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i10)));
                int i20 = i10 + 8;
                unsafe.putInt(t10, j11, i13);
                return i20;
            case 57:
            case 64:
                if (i14 != 5) {
                    return i10;
                }
                unsafe.putObject(t10, j10, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i10)));
                int i21 = i10 + 4;
                unsafe.putInt(t10, j11, i13);
                return i21;
            case 58:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                unsafe.putObject(t10, j10, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint642;
            case 59:
                if (i14 != 2) {
                    return i10;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                int i22 = registers.int1;
                if (i22 == 0) {
                    unsafe.putObject(t10, j10, "");
                } else {
                    if ((i15 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i22)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t10, j10, new String(bArr, iDecodeVarint322, i22, Internal.UTF_8));
                    iDecodeVarint322 += i22;
                }
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint322;
            case 60:
                if (i14 != 2) {
                    return i10;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t10, i13, i17);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i17), bArr, i10, i11, registers);
                storeOneofMessageField(t10, i13, i17, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case 61:
                if (i14 != 2) {
                    return i10;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i10, registers);
                unsafe.putObject(t10, j10, registers.object1);
                unsafe.putInt(t10, j11, i13);
                return iDecodeBytes;
            case 63:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                int i23 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i17);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i23)) {
                    getMutableUnknownFields(t10).storeField(i12, Long.valueOf(i23));
                    return iDecodeVarint323;
                }
                unsafe.putObject(t10, j10, Integer.valueOf(i23));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint323;
            case 66:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i10, registers);
                unsafe.putObject(t10, j10, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint324;
            case 67:
                if (i14 != 0) {
                    return i10;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i10, registers);
                unsafe.putObject(t10, j10, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t10, j11, i13);
                return iDecodeVarint643;
            case 68:
                if (i14 == 3) {
                    Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t10, i13, i17);
                    int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i17), bArr, i10, i11, (i12 & (-8)) | 4, registers);
                    storeOneofMessageField(t10, i13, i17, objMutableOneofMessageFieldForMerge2);
                    return iMergeGroupField;
                }
                break;
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int parseRepeatedField(T t10, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t10, j11);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t10, j11, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i16) {
            case 18:
            case 35:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i10, protobufList, registers);
                }
                if (i14 == 1) {
                    return ArrayDecoders.decodeDoubleList(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 19:
            case 36:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i10, protobufList, registers);
                }
                if (i14 == 5) {
                    return ArrayDecoders.decodeFloatList(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i10, protobufList, registers);
                }
                if (i14 == 0) {
                    return ArrayDecoders.decodeVarint64List(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i10, protobufList, registers);
                }
                if (i14 == 0) {
                    return ArrayDecoders.decodeVarint32List(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i10, protobufList, registers);
                }
                if (i14 == 1) {
                    return ArrayDecoders.decodeFixed64List(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i10, protobufList, registers);
                }
                if (i14 == 5) {
                    return ArrayDecoders.decodeFixed32List(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 25:
            case 42:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i10, protobufList, registers);
                }
                if (i14 == 0) {
                    return ArrayDecoders.decodeBoolList(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 26:
                if (i14 == 2) {
                    return (j10 & 536870912) == 0 ? ArrayDecoders.decodeStringList(i12, bArr, i10, i11, protobufList, registers) : ArrayDecoders.decodeStringListRequireUtf8(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 27:
                if (i14 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i15), i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 28:
                if (i14 == 2) {
                    return ArrayDecoders.decodeBytesList(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 30:
            case 44:
                if (i14 != 2) {
                    if (i14 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i12, bArr, i10, i11, protobufList, registers);
                    }
                    return i10;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i10, protobufList, registers);
                SchemaUtil.filterUnknownEnumList((Object) t10, i13, (List<Integer>) protobufList, getEnumFieldVerifier(i15), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i10, protobufList, registers);
                }
                if (i14 == 0) {
                    return ArrayDecoders.decodeSInt32List(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 34:
            case 48:
                if (i14 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i10, protobufList, registers);
                }
                if (i14 == 0) {
                    return ArrayDecoders.decodeSInt64List(i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            case 49:
                if (i14 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i15), i12, bArr, i10, i11, protobufList, registers);
                }
                return i10;
            default:
                return i10;
        }
    }

    private int positionForFieldNumber(int i10) {
        if (i10 < this.minFieldNumber || i10 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i10, 0);
    }

    private int presenceMaskAndOffsetAt(int i10) {
        return this.buffer[i10 + 2];
    }

    private <E> void readGroupList(Object obj, long j10, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j10), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i10, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i10)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i10, Reader reader) throws IOException {
        if (isEnforceUtf8(i10)) {
            UnsafeUtil.putObject(obj, offset(i10), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i10), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i10), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i10, Reader reader) throws IOException {
        if (isEnforceUtf8(i10)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i10)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i10)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t10, int i10) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i10);
        long j10 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j10 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t10, j10, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t10, j10));
    }

    private void setOneofPresent(T t10, int i10, int i11) {
        UnsafeUtil.putInt(t10, presenceMaskAndOffsetAt(i11) & 1048575, i10);
    }

    private int slowPositionForFieldNumber(int i10, int i11) {
        int length = (this.buffer.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int iNumberAt = numberAt(i13);
            if (i10 == iNumberAt) {
                return i13;
            }
            if (i10 < iNumberAt) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L25
            com.google.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L22:
            int r0 = (int) r4
            r4 = r1
            goto L6c
        L25:
            com.google.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L5a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L5a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L4c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L51
        L4c:
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r4
        L51:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L6c
        L5a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L63
            r0 = r1
            r4 = r0
            goto L6c
        L63:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L22
        L6c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L7d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7e
        L7d:
            r6 = r1
        L7e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L86
            r1 = 268435456(0x10000000, float:2.524355E-29)
        L86:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto Lbe
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto Laf
            int r10 = r10 + 1
            r11[r10] = r9
            return
        Laf:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ldb
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            return
        Lbe:
            if (r9 == 0) goto Lc9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            return
        Lc9:
            com.google.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ldb
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t10, int i10, Object obj) {
        UNSAFE.putObject(t10, offset(typeAndOffsetAt(i10)), obj);
        setFieldPresent(t10, i10);
    }

    private void storeOneofMessageField(T t10, int i10, int i11, Object obj) {
        UNSAFE.putObject(t10, offset(typeAndOffsetAt(i11)), obj);
        setOneofPresent(t10, i10, i11);
    }

    private static int type(int i10) {
        return (i10 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i10) {
        return this.buffer[i10 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrder(T r19, com.google.protobuf.Writer r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            writer.writeMap(i10, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i10, (String) obj);
        } else {
            writer.writeBytes(i10, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t10, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t10), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t10, T t11) {
        int length = this.buffer.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!equals(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t10).equals(this.unknownFieldSchema.getFromMessage(t11))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t10).equals(this.extensionSchema.getExtensions(t11));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t10) {
        int i10;
        int iComputeDoubleSize;
        int iComputeFloatSize;
        int iComputeInt64Size;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        MessageSchema<T> messageSchema = this;
        T t11 = t10;
        Unsafe unsafe = UNSAFE;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i12 < messageSchema.buffer.length) {
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i12);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = messageSchema.numberAt(i12);
            int i16 = messageSchema.buffer[i12 + 2];
            int i17 = i16 & i11;
            if (iType <= 17) {
                if (i17 != i15) {
                    i13 = i17 == i11 ? 0 : unsafe.getInt(t11, i17);
                    i15 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i10 = 0;
            }
            int i18 = i14;
            long jOffset = offset(iTypeAndOffsetAt);
            if (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) {
                i17 = 0;
            }
            switch (iType) {
                case 0:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeFloatSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i14 = i18 + iComputeFloatSize;
                        messageSchema = this;
                        t11 = t10;
                        break;
                    }
                    messageSchema = this;
                    t11 = t10;
                    i14 = i18;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeFloatSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i14 = i18 + iComputeFloatSize;
                        messageSchema = this;
                        t11 = t10;
                        break;
                    }
                    messageSchema = this;
                    t11 = t10;
                    i14 = i18;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeFloatSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i14 = i18 + iComputeFloatSize;
                        messageSchema = this;
                        t11 = t10;
                        break;
                    }
                    messageSchema = this;
                    t11 = t10;
                    i14 = i18;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeFloatSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i14 = i18 + iComputeFloatSize;
                        messageSchema = this;
                        t11 = t10;
                        break;
                    }
                    messageSchema = this;
                    t11 = t10;
                    i14 = i18;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        Object object = unsafe.getObject(t11, jOffset);
                        iComputeInt64Size = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t11, jOffset), messageSchema.getMessageFieldSchema(i12));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 12:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeFloatSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i14 = i18 + iComputeFloatSize;
                        messageSchema = this;
                        t11 = t10;
                        break;
                    }
                    messageSchema = this;
                    t11 = t10;
                    i14 = i18;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeFloatSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i14 = i18 + iComputeFloatSize;
                        messageSchema = this;
                        t11 = t10;
                        break;
                    }
                    messageSchema = this;
                    t11 = t10;
                    i14 = i18;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeInt64Size = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t11, jOffset));
                        i14 = i18 + iComputeInt64Size;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i14 = i18;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(t11, i12, i15, i13, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t11, jOffset), messageSchema.getMessageFieldSchema(i12));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t11, jOffset));
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t11, jOffset), messageSchema.getMessageFieldSchema(i12));
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t11, jOffset));
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t11, jOffset), false);
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t11, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t11, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i14 = i18 + iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                    i14 = i18;
                    break;
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t11, jOffset), messageSchema.getMessageFieldSchema(i12));
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = messageSchema.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t11, jOffset), messageSchema.getMapFieldDefaultEntry(i12));
                    i14 = i18 + iComputeDoubleSize;
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 52:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 53:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 54:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 55:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        Object object2 = unsafe.getObject(t11, jOffset);
                        iComputeDoubleSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t11, jOffset), messageSchema.getMessageFieldSchema(i12));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 63:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 65:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 66:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 67:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t11, jOffset));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(t11, iNumberAt, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t11, jOffset), messageSchema.getMessageFieldSchema(i12));
                        i14 = i18 + iComputeDoubleSize;
                        break;
                    }
                    i14 = i18;
                    break;
                default:
                    i14 = i18;
                    break;
            }
            i12 += 3;
            i11 = 1048575;
        }
        int unknownFieldsSerializedSize = i14 + messageSchema.getUnknownFieldsSerializedSize(messageSchema.unknownFieldSchema, t11);
        return messageSchema.hasExtensions ? unknownFieldsSerializedSize + messageSchema.extensionSchema.getExtensions(t11).getSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t10) {
        int i10;
        int iHashLong;
        int length = this.buffer.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i12);
            int iNumberAt = numberAt(i12);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t10, jOffset)));
                    i11 = i10 + iHashLong;
                    break;
                case 1:
                    i10 = i11 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 2:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 3:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 4:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 5:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 6:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 7:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 8:
                    i10 = i11 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t10, jOffset)).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t10, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 11:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 12:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 13:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 14:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 15:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getInt(t10, jOffset);
                    i11 = i10 + iHashLong;
                    break;
                case 16:
                    i10 = i11 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t10, jOffset));
                    i11 = i10 + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t10, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 50:
                    i10 = i11 * 53;
                    iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                    i11 = i10 + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t10, jOffset)));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t10, jOffset)).hashCode();
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = oneofIntAt(t10, jOffset);
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t10, jOffset));
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t10, iNumberAt, i12)) {
                        i10 = i11 * 53;
                        iHashLong = UnsafeUtil.getObject(t10, jOffset).hashCode();
                        i11 = i10 + iHashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i11 * 53) + this.unknownFieldSchema.getFromMessage(t10).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t10).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T r15) {
        /*
            r14 = this;
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 0
            r3 = r0
            r2 = r1
            r4 = r2
        L7:
            int r5 = r14.checkInitializedCount
            r6 = 1
            if (r2 >= r5) goto L9c
            int[] r5 = r14.intArray
            r9 = r5[r2]
            int r5 = r14.numberAt(r9)
            int r13 = r14.typeAndOffsetAt(r9)
            int[] r7 = r14.buffer
            int r8 = r9 + 2
            r7 = r7[r8]
            r8 = r7 & r0
            int r7 = r7 >>> 20
            int r12 = r6 << r7
            if (r8 == r3) goto L32
            if (r8 == r0) goto L2f
            sun.misc.Unsafe r3 = com.google.protobuf.MessageSchema.UNSAFE
            long r6 = (long) r8
            int r4 = r3.getInt(r15, r6)
        L2f:
            r11 = r4
            r10 = r8
            goto L34
        L32:
            r10 = r3
            r11 = r4
        L34:
            boolean r3 = isRequired(r13)
            r7 = r14
            r8 = r15
            if (r3 == 0) goto L43
            boolean r14 = r7.isFieldPresent(r8, r9, r10, r11, r12)
            if (r14 != 0) goto L43
            return r1
        L43:
            int r14 = type(r13)
            r15 = 9
            if (r14 == r15) goto L83
            r15 = 17
            if (r14 == r15) goto L83
            r15 = 27
            if (r14 == r15) goto L7c
            r15 = 60
            if (r14 == r15) goto L6b
            r15 = 68
            if (r14 == r15) goto L6b
            r15 = 49
            if (r14 == r15) goto L7c
            r15 = 50
            if (r14 == r15) goto L64
            goto L94
        L64:
            boolean r14 = r7.isMapInitialized(r8, r13, r9)
            if (r14 != 0) goto L94
            return r1
        L6b:
            boolean r14 = r7.isOneofPresent(r8, r5, r9)
            if (r14 == 0) goto L94
            com.google.protobuf.Schema r14 = r7.getMessageFieldSchema(r9)
            boolean r14 = isInitialized(r8, r13, r14)
            if (r14 != 0) goto L94
            return r1
        L7c:
            boolean r14 = r7.isListInitialized(r8, r13, r9)
            if (r14 != 0) goto L94
            return r1
        L83:
            boolean r14 = r7.isFieldPresent(r8, r9, r10, r11, r12)
            if (r14 == 0) goto L94
            com.google.protobuf.Schema r14 = r7.getMessageFieldSchema(r9)
            boolean r14 = isInitialized(r8, r13, r14)
            if (r14 != 0) goto L94
            return r1
        L94:
            int r2 = r2 + 1
            r14 = r7
            r15 = r8
            r3 = r10
            r4 = r11
            goto L7
        L9c:
            r7 = r14
            r8 = r15
            boolean r14 = r7.hasExtensions
            if (r14 == 0) goto Laf
            com.google.protobuf.ExtensionSchema<?> r14 = r7.extensionSchema
            com.google.protobuf.FieldSet r14 = r14.getExtensions(r8)
            boolean r14 = r14.isInitialized()
            if (r14 != 0) goto Laf
            return r1
        Laf:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.isInitialized(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void makeImmutable(T r8) {
        /*
            r7 = this;
            boolean r0 = isMutable(r8)
            if (r0 != 0) goto L8
            goto L8e
        L8:
            boolean r0 = r8 instanceof com.google.protobuf.GeneratedMessageLite
            if (r0 == 0) goto L18
            r0 = r8
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            r0.clearMemoizedSerializedSize()
            r0.clearMemoizedHashCode()
            r0.markImmutable()
        L18:
            int[] r0 = r7.buffer
            int r0 = r0.length
            r1 = 0
        L1c:
            if (r1 >= r0) goto L80
            int r2 = r7.typeAndOffsetAt(r1)
            long r3 = offset(r2)
            int r2 = type(r2)
            r5 = 9
            if (r2 == r5) goto L6a
            r5 = 60
            if (r2 == r5) goto L52
            r5 = 68
            if (r2 == r5) goto L52
            switch(r2) {
                case 17: goto L6a;
                case 18: goto L4c;
                case 19: goto L4c;
                case 20: goto L4c;
                case 21: goto L4c;
                case 22: goto L4c;
                case 23: goto L4c;
                case 24: goto L4c;
                case 25: goto L4c;
                case 26: goto L4c;
                case 27: goto L4c;
                case 28: goto L4c;
                case 29: goto L4c;
                case 30: goto L4c;
                case 31: goto L4c;
                case 32: goto L4c;
                case 33: goto L4c;
                case 34: goto L4c;
                case 35: goto L4c;
                case 36: goto L4c;
                case 37: goto L4c;
                case 38: goto L4c;
                case 39: goto L4c;
                case 40: goto L4c;
                case 41: goto L4c;
                case 42: goto L4c;
                case 43: goto L4c;
                case 44: goto L4c;
                case 45: goto L4c;
                case 46: goto L4c;
                case 47: goto L4c;
                case 48: goto L4c;
                case 49: goto L4c;
                case 50: goto L3a;
                default: goto L39;
            }
        L39:
            goto L7d
        L3a:
            sun.misc.Unsafe r2 = com.google.protobuf.MessageSchema.UNSAFE
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L7d
            com.google.protobuf.MapFieldSchema r6 = r7.mapFieldSchema
            java.lang.Object r5 = r6.toImmutable(r5)
            r2.putObject(r8, r3, r5)
            goto L7d
        L4c:
            com.google.protobuf.ListFieldSchema r2 = r7.listFieldSchema
            r2.makeImmutableListAt(r8, r3)
            goto L7d
        L52:
            int r2 = r7.numberAt(r1)
            boolean r2 = r7.isOneofPresent(r8, r2, r1)
            if (r2 == 0) goto L7d
            com.google.protobuf.Schema r2 = r7.getMessageFieldSchema(r1)
            sun.misc.Unsafe r5 = com.google.protobuf.MessageSchema.UNSAFE
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.makeImmutable(r3)
            goto L7d
        L6a:
            boolean r2 = r7.isFieldPresent(r8, r1)
            if (r2 == 0) goto L7d
            com.google.protobuf.Schema r2 = r7.getMessageFieldSchema(r1)
            sun.misc.Unsafe r5 = com.google.protobuf.MessageSchema.UNSAFE
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.makeImmutable(r3)
        L7d:
            int r1 = r1 + 3
            goto L1c
        L80:
            com.google.protobuf.UnknownFieldSchema<?, ?> r0 = r7.unknownFieldSchema
            r0.makeImmutable(r8)
            boolean r0 = r7.hasExtensions
            if (r0 == 0) goto L8e
            com.google.protobuf.ExtensionSchema<?> r7 = r7.extensionSchema
            r7.makeImmutable(r8)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.makeImmutable(java.lang.Object):void");
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t10, T t11) {
        checkMutable(t10);
        t11.getClass();
        for (int i10 = 0; i10 < this.buffer.length; i10 += 3) {
            mergeSingleField(t10, t11, i10);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t10, t11);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t10, t11);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0410 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x043e  */
    @com.google.protobuf.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int parseMessage(T r27, byte[] r28, int r29, int r30, int r31, com.google.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseMessage(java.lang.Object, byte[], int, int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t10, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t10, writer);
        } else {
            writeFieldsInAscendingOrder(t10, writer);
        }
    }

    private boolean isFieldPresent(T t10, int i10) {
        boolean zEquals;
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i10);
        long j10 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j10 != 1048575) {
            return ((1 << (iPresenceMaskAndOffsetAt >>> 20)) & UnsafeUtil.getInt(t10, j10)) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i10);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t10, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t10, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t10, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t10, jOffset);
                if (object instanceof String) {
                    zEquals = ((String) object).isEmpty();
                    break;
                } else {
                    if (!(object instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.EMPTY.equals(object);
                    break;
                }
            case 9:
                return UnsafeUtil.getObject(t10, jOffset) != null;
            case 10:
                zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t10, jOffset));
                break;
            case 11:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t10, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t10, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t10, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private int positionForFieldNumber(int i10, int i11) {
        if (i10 < this.minFieldNumber || i10 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i10, i11);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t10, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        checkMutable(t10);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t10, reader, extensionRegistryLite);
    }

    private boolean equals(T t10, T t11, int i10) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i10);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t10, t11, i10) || Double.doubleToLongBits(UnsafeUtil.getDouble(t10, jOffset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t11, jOffset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t10, t11, i10) || Float.floatToIntBits(UnsafeUtil.getFloat(t10, jOffset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t11, jOffset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getLong(t10, jOffset) != UnsafeUtil.getLong(t11, jOffset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getLong(t10, jOffset) != UnsafeUtil.getLong(t11, jOffset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getInt(t10, jOffset) != UnsafeUtil.getInt(t11, jOffset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getLong(t10, jOffset) != UnsafeUtil.getLong(t11, jOffset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getInt(t10, jOffset) != UnsafeUtil.getInt(t11, jOffset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getBoolean(t10, jOffset) != UnsafeUtil.getBoolean(t11, jOffset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t10, t11, i10) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t10, t11, i10) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t10, t11, i10) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getInt(t10, jOffset) != UnsafeUtil.getInt(t11, jOffset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getInt(t10, jOffset) != UnsafeUtil.getInt(t11, jOffset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getInt(t10, jOffset) != UnsafeUtil.getInt(t11, jOffset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getLong(t10, jOffset) != UnsafeUtil.getLong(t11, jOffset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getInt(t10, jOffset) != UnsafeUtil.getInt(t11, jOffset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t10, t11, i10) || UnsafeUtil.getLong(t10, jOffset) != UnsafeUtil.getLong(t11, jOffset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t10, t11, i10) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t10, t11, i10) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t10, jOffset), UnsafeUtil.getObject(t11, jOffset))) {
                }
                break;
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t10, byte[] bArr, int i10, int i11, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(t10, bArr, i10, i11, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i10, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i10)));
    }
}
