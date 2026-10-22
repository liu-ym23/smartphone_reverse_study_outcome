package androidx.datastore.preferences.protobuf;

import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o7.s;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
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
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1, reason: invalid class name */
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

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i6, MessageLite messageLite, boolean z10, boolean z11, int[] iArr2, int i10, int i11, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i6;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z10;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z11;
        this.intArray = iArr2;
        this.checkInitializedCount = i10;
        this.repeatedFieldOffsetStart = i11;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t9, T t10, int i) {
        return isFieldPresent(t9, i) == isFieldPresent(t10, i);
    }

    private static <T> boolean booleanAt(T t9, long j5) {
        return UnsafeUtil.getBoolean(t9, j5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i6, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i10 = registers.int1;
        if (i10 < 0 || i10 > i6 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = iDecodeVarint32 + i10;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i11) {
            int iDecodeVarint322 = iDecodeVarint32 + 1;
            int i12 = bArr[iDecodeVarint32];
            if (i12 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i12, bArr, iDecodeVarint322, registers);
                i12 = registers.int1;
            }
            int i13 = iDecodeVarint322;
            int i14 = i12 >>> 3;
            int i15 = i12 & 7;
            if (i14 != 1) {
                if (i14 == 2 && i15 == metadata.valueType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i13, i6, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i12, bArr, i13, i6, registers);
                }
            } else if (i15 == metadata.keyType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i13, i6, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i12, bArr, i13, i6, registers);
            }
        }
        if (iDecodeVarint32 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i11;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i6, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i6, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t9, long j5) {
        return UnsafeUtil.getDouble(t9, j5);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i6, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i6, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t9, long j5) {
        return UnsafeUtil.getFloat(t9, j5);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i6 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i6];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i6 + 1]);
        this.objects[i6] = schemaSchemaFor;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t9) {
        int i;
        int i6;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        boolean z10;
        int iComputeSizeFixed32List;
        Unsafe unsafe = UNSAFE;
        int i10 = -1;
        int i11 = 0;
        int iC = 0;
        int i12 = 0;
        while (i11 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i11);
            int iNumberAt = numberAt(i11);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i11 + 2];
                int i13 = OFFSET_MASK & i;
                int i14 = 1 << (i >>> 20);
                if (i13 != i10) {
                    i12 = unsafe.getInt(t9, i13);
                    i10 = i13;
                }
                i6 = i14;
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i11 + 2] & OFFSET_MASK;
                i6 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            int i15 = i10;
            switch (iType) {
                case 0:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iC += iComputeDoubleSize;
                        break;
                    }
                case 1:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iC += iComputeDoubleSize;
                        break;
                    }
                case 2:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    }
                case 3:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    }
                case 4:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    }
                case 5:
                    if ((i12 & i6) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iC += iComputeDoubleSize;
                        break;
                    }
                case 6:
                    if ((i12 & i6) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iC += iComputeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i12 & i6) != 0) {
                        Object object = unsafe.getObject(t9, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iC = iComputeBytesSize + iC;
                    }
                    break;
                case 9:
                    if ((i12 & i6) != 0) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t9, jOffset), getMessageFieldSchema(i11));
                        iC += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 14:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i12 & i6) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t9, jOffset), getMessageFieldSchema(i11));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 19:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 20:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 21:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 22:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 23:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 24:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 25:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t9, jOffset));
                    iC += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t9, jOffset), getMessageFieldSchema(i11));
                    iC += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t9, jOffset));
                    iC += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 30:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 31:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 32:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 33:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 34:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t9, jOffset), false);
                    iC += iComputeSizeFixed32List;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeFixed64ListNoTag);
                        }
                        iC = a.C(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iC);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeFixed32ListNoTag);
                        }
                        iC = a.C(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iC);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeInt64ListNoTag);
                        }
                        iC = a.C(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iC);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeUInt64ListNoTag);
                        }
                        iC = a.C(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iC);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeInt32ListNoTag);
                        }
                        iC = a.C(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iC);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeFixed64ListNoTag2);
                        }
                        iC = a.C(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iC);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeFixed32ListNoTag2);
                        }
                        iC = a.C(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iC);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeBoolListNoTag);
                        }
                        iC = a.C(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iC);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeUInt32ListNoTag);
                        }
                        iC = a.C(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iC);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeEnumListNoTag);
                        }
                        iC = a.C(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iC);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeFixed32ListNoTag3);
                        }
                        iC = a.C(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iC);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeFixed64ListNoTag3);
                        }
                        iC = a.C(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iC);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeSInt32ListNoTag);
                        }
                        iC = a.C(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iC);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i, iComputeSizeSInt64ListNoTag);
                        }
                        iC = a.C(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iC);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t9, jOffset), getMessageFieldSchema(i11));
                    iC += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t9, jOffset), getMapFieldDefaultEntry(i11));
                    iC += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iC += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        Object object2 = unsafe.getObject(t9, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iC = iComputeBytesSize + iC;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t9, jOffset), getMessageFieldSchema(i11));
                        iC += iComputeSizeMessage;
                    }
                    break;
                case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iC += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iC += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t9, jOffset));
                        iC += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t9, jOffset), getMessageFieldSchema(i11));
                        iC += iComputeBoolSize;
                    }
                    break;
            }
            i11 += 3;
            i10 = i15;
        }
        int unknownFieldsSerializedSize = iC + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t9);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t9).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t9) {
        int iComputeDoubleSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        Unsafe unsafe = UNSAFE;
        int iC = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            int i6 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t9, i)) {
                        Object object = UnsafeUtil.getObject(t9, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iC = iComputeBytesSize + iC;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t9, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t9, jOffset), getMessageFieldSchema(i));
                        iC += iComputeSizeMessage;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t9, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t9, jOffset), getMessageFieldSchema(i));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 19:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 20:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 21:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 22:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 23:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 24:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 25:
                    iComputeSizeMessage = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t9, jOffset));
                    iC += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t9, jOffset), getMessageFieldSchema(i));
                    iC += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t9, jOffset));
                    iC += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 30:
                    iComputeSizeMessage = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 31:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 32:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 33:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 34:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t9, jOffset), false);
                    iC += iComputeSizeMessage;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeFixed64ListNoTag);
                        }
                        iC = a.C(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iC);
                        break;
                    }
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed32ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeFixed32ListNoTag);
                        }
                        iC = a.C(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iC);
                        break;
                    }
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeInt64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeInt64ListNoTag);
                        }
                        iC = a.C(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iC);
                        break;
                    }
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeUInt64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeUInt64ListNoTag);
                        }
                        iC = a.C(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iC);
                        break;
                    }
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeInt32ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeInt32ListNoTag);
                        }
                        iC = a.C(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iC);
                        break;
                    }
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeFixed64ListNoTag2);
                        }
                        iC = a.C(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iC);
                        break;
                    }
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeFixed32ListNoTag2);
                        }
                        iC = a.C(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iC);
                        break;
                    }
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeBoolListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeBoolListNoTag);
                        }
                        iC = a.C(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iC);
                        break;
                    }
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeUInt32ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeUInt32ListNoTag);
                        }
                        iC = a.C(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iC);
                        break;
                    }
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeEnumListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeEnumListNoTag);
                        }
                        iC = a.C(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iC);
                        break;
                    }
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeFixed32ListNoTag3);
                        }
                        iC = a.C(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iC);
                        break;
                    }
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeFixed64ListNoTag3);
                        }
                        iC = a.C(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iC);
                        break;
                    }
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeSInt32ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeSInt32ListNoTag);
                        }
                        iC = a.C(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iC);
                        break;
                    }
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t9, jOffset));
                    if (iComputeSizeSInt64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t9, i6, iComputeSizeSInt64ListNoTag);
                        }
                        iC = a.C(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iC);
                        break;
                    }
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t9, jOffset), getMessageFieldSchema(i));
                    iC += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t9, jOffset), getMapFieldDefaultEntry(i));
                    iC += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        Object object2 = UnsafeUtil.getObject(t9, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iC = iComputeBytesSize + iC;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t9, jOffset), getMessageFieldSchema(i));
                        iC += iComputeSizeMessage;
                        break;
                    } else {
                        break;
                    }
                case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t9, jOffset));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t9, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t9, jOffset), getMessageFieldSchema(i));
                        iC += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return iC + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t9);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t9) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t9));
    }

    private static <T> int intAt(T t9, long j5) {
        return UnsafeUtil.getInt(t9, j5);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t9, int i, int i6, int i10) {
        return this.proto3 ? isFieldPresent(t9, i) : (i6 & i10) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i6) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!messageFieldSchema.isInitialized(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.datastore.preferences.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T t9, int i, int i6) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t9, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
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

    private boolean isOneofCaseEqual(T t9, T t10, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & OFFSET_MASK;
        return UnsafeUtil.getInt(t9, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t10, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t9, int i, int i6) {
        return UnsafeUtil.getInt(t9, (long) (presenceMaskAndOffsetAt(i6) & OFFSET_MASK)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static List<?> listAt(Object obj, long j5) {
        return (List) UnsafeUtil.getObject(obj, j5);
    }

    private static <T> long longAt(T t9, long j5) {
        return UnsafeUtil.getLong(t9, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:334:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = r14.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 >= r14.repeatedFieldOffsetStart) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        r7 = filterMapUnknownEnumValues(r9, r14.intArray[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r7 == null) goto L334;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0638 A[LOOP:3: B:197:0x0634->B:199:0x0638, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x060f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r15, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r16, T r17, androidx.datastore.preferences.protobuf.Reader r18, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i));
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

    private void mergeMessage(T t9, T t10, int i) {
        long jOffset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t10, i)) {
            Object object = UnsafeUtil.getObject(t9, jOffset);
            Object object2 = UnsafeUtil.getObject(t10, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t9, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t9, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t9, jOffset, object2);
                setFieldPresent(t9, i);
            }
        }
    }

    private void mergeOneofMessage(T t9, T t10, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        int iNumberAt = numberAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t10, iNumberAt, i)) {
            Object object = UnsafeUtil.getObject(t9, jOffset);
            Object object2 = UnsafeUtil.getObject(t10, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t9, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t9, iNumberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t9, jOffset, object2);
                setOneofPresent(t9, iNumberAt, i);
            }
        }
    }

    private void mergeSingleField(T t9, T t10, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putDouble(t9, jOffset, UnsafeUtil.getDouble(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putFloat(t9, jOffset, UnsafeUtil.getFloat(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, jOffset, UnsafeUtil.getLong(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, jOffset, UnsafeUtil.getLong(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, jOffset, UnsafeUtil.getInt(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, jOffset, UnsafeUtil.getLong(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, jOffset, UnsafeUtil.getInt(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putBoolean(t9, jOffset, UnsafeUtil.getBoolean(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putObject(t9, jOffset, UnsafeUtil.getObject(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 9:
                mergeMessage(t9, t10, i);
                break;
            case 10:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putObject(t9, jOffset, UnsafeUtil.getObject(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, jOffset, UnsafeUtil.getInt(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, jOffset, UnsafeUtil.getInt(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, jOffset, UnsafeUtil.getInt(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, jOffset, UnsafeUtil.getLong(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, jOffset, UnsafeUtil.getInt(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, jOffset, UnsafeUtil.getLong(t10, jOffset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 17:
                mergeMessage(t9, t10, i);
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
                this.listFieldSchema.mergeListsAt(t9, t10, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t9, t10, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t10, iNumberAt, i)) {
                    UnsafeUtil.putObject(t9, jOffset, UnsafeUtil.getObject(t10, jOffset));
                    setOneofPresent(t9, iNumberAt, i);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t9, t10, i);
                break;
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (isOneofPresent(t10, iNumberAt, i)) {
                    UnsafeUtil.putObject(t9, jOffset, UnsafeUtil.getObject(t10, jOffset));
                    setOneofPresent(t9, iNumberAt, i);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t9, t10, i);
                break;
        }
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z10 = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
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
        int i6 = 0;
        int i10 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i6++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i10++;
            }
        }
        int[] iArr2 = i6 > 0 ? new int[i6] : null;
        int[] iArr3 = i10 > 0 ? new int[i10] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i11 < fields.length) {
            FieldInfo fieldInfo2 = fields[i11];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i12, z10, objArr);
            if (i13 < checkInitialized.length && checkInitialized[i13] == fieldNumber3) {
                checkInitialized[i13] = i12;
                i13++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i14] = i12;
                i14++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    i = i12;
                    iArr3[i15] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i15++;
                }
                i11++;
                i12 = i + 3;
            }
            i = i12;
            i11++;
            i12 = i + 3;
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
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z10, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo r34, androidx.datastore.preferences.protobuf.NewInstanceSchema r35, androidx.datastore.preferences.protobuf.ListFieldSchema r36, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r37, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r38, androidx.datastore.preferences.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instructions count: 1033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & OFFSET_MASK;
    }

    private static <T> boolean oneofBooleanAt(T t9, long j5) {
        return ((Boolean) UnsafeUtil.getObject(t9, j5)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t9, long j5) {
        return ((Double) UnsafeUtil.getObject(t9, j5)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t9, long j5) {
        return ((Float) UnsafeUtil.getObject(t9, j5)).floatValue();
    }

    private static <T> int oneofIntAt(T t9, long j5) {
        return ((Integer) UnsafeUtil.getObject(t9, j5)).intValue();
    }

    private static <T> long oneofLongAt(T t9, long j5) {
        return ((Long) UnsafeUtil.getObject(t9, j5)).longValue();
    }

    private <K, V> int parseMapField(T t9, byte[] bArr, int i, int i6, int i10, long j5, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i10);
        Object object = unsafe.getObject(t9, j5);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t9, j5, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i6, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t9, byte[] bArr, int i, int i6, int i10, int i11, int i12, int i13, int i14, long j5, int i15, ArrayDecoders.Registers registers) throws IOException {
        Object object;
        Unsafe unsafe = UNSAFE;
        long j6 = this.buffer[i15 + 2] & OFFSET_MASK;
        switch (i14) {
            case 51:
                if (i12 != 1) {
                    return i;
                }
                unsafe.putObject(t9, j5, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i16 = i + 8;
                unsafe.putInt(t9, j6, i11);
                return i16;
            case 52:
                if (i12 != 5) {
                    return i;
                }
                unsafe.putObject(t9, j5, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i17 = i + 4;
                unsafe.putInt(t9, j6, i11);
                return i17;
            case 53:
            case 54:
                if (i12 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t9, j5, Long.valueOf(registers.long1));
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint64;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (i12 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t9, j5, Integer.valueOf(registers.int1));
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint32;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (i12 != 1) {
                    return i;
                }
                unsafe.putObject(t9, j5, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i18 = i + 8;
                unsafe.putInt(t9, j6, i11);
                return i18;
            case 57:
            case 64:
                if (i12 != 5) {
                    return i;
                }
                unsafe.putObject(t9, j5, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i19 = i + 4;
                unsafe.putInt(t9, j6, i11);
                return i19;
            case 58:
                if (i12 != 0) {
                    return i;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t9, j5, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint642;
            case 59:
                if (i12 != 2) {
                    return i;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i20 = registers.int1;
                if (i20 == 0) {
                    unsafe.putObject(t9, j5, "");
                } else {
                    if ((i13 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i20)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t9, j5, new String(bArr, iDecodeVarint322, i20, Internal.UTF_8));
                    iDecodeVarint322 += i20;
                }
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint322;
            case 60:
                if (i12 != 2) {
                    return i;
                }
                int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i15), bArr, i, i6, registers);
                object = unsafe.getInt(t9, j6) == i11 ? unsafe.getObject(t9, j5) : null;
                if (object == null) {
                    unsafe.putObject(t9, j5, registers.object1);
                } else {
                    unsafe.putObject(t9, j5, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t9, j6, i11);
                return iDecodeMessageField;
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                if (i12 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t9, j5, registers.object1);
                unsafe.putInt(t9, j6, i11);
                return iDecodeBytes;
            case 63:
                if (i12 != 0) {
                    return i;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i21 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i15);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i21)) {
                    getMutableUnknownFields(t9).storeField(i10, Long.valueOf(i21));
                    return iDecodeVarint323;
                }
                unsafe.putObject(t9, j5, Integer.valueOf(i21));
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint323;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i12 != 0) {
                    return i;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t9, j5, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint324;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (i12 != 0) {
                    return i;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t9, j5, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t9, j6, i11);
                return iDecodeVarint643;
            case 68:
                if (i12 == 3) {
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i15), bArr, i, i6, (i10 & (-8)) | 4, registers);
                    object = unsafe.getInt(t9, j6) == i11 ? unsafe.getObject(t9, j5) : null;
                    if (object == null) {
                        unsafe.putObject(t9, j5, registers.object1);
                    } else {
                        unsafe.putObject(t9, j5, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t9, j6, i11);
                    return iDecodeGroupField;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0053. Please report as an issue. */
    private int parseProto3Message(T t9, byte[] bArr, int i, int i6, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i10;
        int i11;
        int i12;
        Unsafe unsafe2;
        int iDecodeVarint64;
        int i13;
        int i14;
        int i15;
        MessageSchema<T> messageSchema = this;
        byte[] bArr2 = bArr;
        int i16 = i6;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe3 = UNSAFE;
        int i17 = -1;
        int iDecodeUnknownField = i;
        int i18 = -1;
        int i19 = 0;
        while (iDecodeUnknownField < i16) {
            int iDecodeVarint32 = iDecodeUnknownField + 1;
            int i20 = bArr2[iDecodeUnknownField];
            if (i20 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i20, bArr2, iDecodeVarint32, registers2);
                i20 = registers2.int1;
            }
            int i21 = iDecodeVarint32;
            int i22 = i20;
            int i23 = i22 >>> 3;
            int i24 = i22 & 7;
            int iPositionForFieldNumber = i23 > i18 ? messageSchema.positionForFieldNumber(i23, i19 / 3) : messageSchema.positionForFieldNumber(i23);
            if (iPositionForFieldNumber == i17) {
                unsafe = unsafe3;
                i10 = i21;
                i11 = i23;
                iPositionForFieldNumber = 0;
            } else {
                int i25 = messageSchema.buffer[iPositionForFieldNumber + 1];
                int iType = type(i25);
                long jOffset = offset(i25);
                if (iType <= 17) {
                    switch (iType) {
                        case 0:
                            i12 = i22;
                            if (i24 == 1) {
                                UnsafeUtil.putDouble(t9, jOffset, ArrayDecoders.decodeDouble(bArr2, i21));
                                iDecodeUnknownField = i21 + 8;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe3;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 1:
                            i12 = i22;
                            if (i24 == 5) {
                                UnsafeUtil.putFloat(t9, jOffset, ArrayDecoders.decodeFloat(bArr2, i21));
                                iDecodeUnknownField = i21 + 4;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe3;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 2:
                        case 3:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 != 0) {
                                unsafe = unsafe2;
                                i13 = i21;
                                i14 = i23;
                                i15 = i12;
                                i10 = i13;
                                i11 = i14;
                                i22 = i15;
                                break;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i21, registers2);
                                unsafe3 = unsafe2;
                                unsafe3.putLong(t9, jOffset, registers2.long1);
                                iDecodeUnknownField = iDecodeVarint64;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                        case 4:
                        case 11:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i21, registers2);
                                unsafe2.putInt(t9, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 5:
                        case 14:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 1) {
                                unsafe2.putLong(t9, jOffset, ArrayDecoders.decodeFixed64(bArr2, i21));
                                unsafe2 = unsafe2;
                                iDecodeUnknownField = i21 + 8;
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 6:
                        case 13:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 5) {
                                unsafe2.putInt(t9, jOffset, ArrayDecoders.decodeFixed32(bArr2, i21));
                                iDecodeUnknownField = i21 + 4;
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 7:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i21, registers2);
                                UnsafeUtil.putBoolean(t9, jOffset, registers2.long1 != 0);
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 8:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 2) {
                                iDecodeUnknownField = (ENFORCE_UTF8_MASK & i25) == 0 ? ArrayDecoders.decodeString(bArr2, i21, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i21, registers2);
                                unsafe2.putObject(t9, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 9:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), bArr2, i21, i16, registers2);
                                Object object = unsafe2.getObject(t9, jOffset);
                                if (object == null) {
                                    unsafe2.putObject(t9, jOffset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t9, jOffset, Internal.mergeMessage(object, registers2.object1));
                                }
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 10:
                            i12 = i22;
                            unsafe2 = unsafe3;
                            if (i24 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i21, registers2);
                                unsafe2.putObject(t9, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i12;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 12:
                            unsafe2 = unsafe3;
                            if (i24 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i21, registers2);
                                unsafe2.putInt(t9, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i22;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 15:
                            unsafe2 = unsafe3;
                            if (i24 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i21, registers2);
                                unsafe2.putInt(t9, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                unsafe3 = unsafe2;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                            unsafe = unsafe2;
                            i13 = i21;
                            i14 = i23;
                            i15 = i22;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                        case 16:
                            if (i24 != 0) {
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i13 = i21;
                                i14 = i23;
                                i15 = i22;
                                i10 = i13;
                                i11 = i14;
                                i22 = i15;
                                break;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i21, registers2);
                                unsafe3.putLong(t9, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                unsafe3 = unsafe3;
                                iDecodeUnknownField = iDecodeVarint64;
                                i18 = i23;
                                i19 = iPositionForFieldNumber;
                                break;
                            }
                        default:
                            unsafe = unsafe3;
                            i13 = i21;
                            i14 = i23;
                            i15 = i22;
                            i10 = i13;
                            i11 = i14;
                            i22 = i15;
                            break;
                    }
                } else {
                    i12 = i22;
                    if (iType == 27) {
                        if (i24 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe3.getObject(t9, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe3.putObject(t9, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            unsafe = unsafe3;
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), i12, bArr2, i21, i16, protobufListMutableCopyWithCapacity2, registers2);
                            bArr2 = bArr;
                            i16 = i6;
                            registers2 = registers;
                            i18 = i23;
                        }
                        unsafe = unsafe3;
                        i13 = i21;
                        i14 = i23;
                        i15 = i12;
                        i10 = i13;
                        i11 = i14;
                        i22 = i15;
                    } else {
                        unsafe = unsafe3;
                        if (iType <= 49) {
                            int repeatedField = messageSchema.parseRepeatedField(t9, bArr, i21, i6, i12, i23, i24, iPositionForFieldNumber, i25, iType, jOffset, registers);
                            i15 = i12;
                            i14 = i23;
                            iPositionForFieldNumber = iPositionForFieldNumber;
                            if (repeatedField != i21) {
                                messageSchema = this;
                                i16 = i6;
                                registers2 = registers;
                                iDecodeUnknownField = repeatedField;
                                i18 = i14;
                                i19 = iPositionForFieldNumber;
                                unsafe3 = unsafe;
                                i17 = -1;
                                bArr2 = bArr;
                            } else {
                                i10 = repeatedField;
                                i11 = i14;
                                i22 = i15;
                            }
                        } else {
                            i14 = i23;
                            i15 = i12;
                            i13 = i21;
                            if (iType == 50) {
                                if (i24 == 2) {
                                    int mapField = parseMapField(t9, bArr, i13, i6, iPositionForFieldNumber, jOffset, registers);
                                    if (mapField != i13) {
                                        messageSchema = this;
                                        bArr2 = bArr;
                                        i16 = i6;
                                        registers2 = registers;
                                        iDecodeUnknownField = mapField;
                                        i18 = i14;
                                    } else {
                                        i10 = mapField;
                                    }
                                } else {
                                    i10 = i13;
                                }
                                i11 = i14;
                                i22 = i15;
                            } else {
                                i11 = i14;
                                i22 = i15;
                                int oneofField = parseOneofField(t9, bArr, i13, i6, i22, i11, i24, i25, iType, jOffset, iPositionForFieldNumber, registers);
                                if (oneofField != i13) {
                                    messageSchema = this;
                                    i16 = i6;
                                    registers2 = registers;
                                    i18 = i11;
                                    iDecodeUnknownField = oneofField;
                                    i19 = iPositionForFieldNumber;
                                    unsafe3 = unsafe;
                                    i17 = -1;
                                    bArr2 = bArr;
                                } else {
                                    i10 = oneofField;
                                }
                            }
                        }
                    }
                    i19 = iPositionForFieldNumber;
                    unsafe3 = unsafe;
                }
                i17 = -1;
            }
            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i22, bArr, i10, i6, getMutableUnknownFields(t9), registers);
            messageSchema = this;
            bArr2 = bArr;
            registers2 = registers;
            i16 = i6;
            i18 = i11;
            i19 = iPositionForFieldNumber;
            unsafe3 = unsafe;
            i17 = -1;
        }
        if (iDecodeUnknownField == i16) {
            return iDecodeUnknownField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t9, byte[] bArr, int i, int i6, int i10, int i11, int i12, int i13, long j5, int i14, long j6, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t9, j6);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t9, j6, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i14) {
            case 18:
            case 35:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i12 == 1) {
                    return ArrayDecoders.decodeDoubleList(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 19:
            case 36:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i12 == 5) {
                    return ArrayDecoders.decodeFloatList(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeVarint64List(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeVarint32List(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i12 == 1) {
                    return ArrayDecoders.decodeFixed64List(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i12 == 5) {
                    return ArrayDecoders.decodeFixed32List(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 25:
            case 42:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeBoolList(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 26:
                if (i12 == 2) {
                    return (j5 & 536870912) == 0 ? ArrayDecoders.decodeStringList(i10, bArr, i, i6, protobufList, registers) : ArrayDecoders.decodeStringListRequireUtf8(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 27:
                if (i12 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i13), i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 28:
                if (i12 == 2) {
                    return ArrayDecoders.decodeBytesList(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 30:
            case 44:
                if (i12 != 2) {
                    if (i12 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i10, bArr, i, i6, protobufList, registers);
                    }
                    return i;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t9;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i11, (List<Integer>) protobufList, getEnumFieldVerifier(i13), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeSInt32List(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 34:
            case 48:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeSInt64List(i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            case 49:
                if (i12 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i13), i10, bArr, i, i6, protobufList, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j5, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j5), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
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
            StringBuilder sbV = B7.a.v("Field ", str, " for ");
            a.z(sbV, cls, " not found. Known fields are ");
            sbV.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbV.toString());
        }
    }

    private void setFieldPresent(T t9, int i) {
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j5 = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        UnsafeUtil.putInt(t9, j5, UnsafeUtil.getInt(t9, j5) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private void setOneofPresent(T t9, int i, int i6) {
        UnsafeUtil.putInt(t9, presenceMaskAndOffsetAt(i6) & OFFSET_MASK, i);
    }

    private int slowPositionForFieldNumber(int i, int i6) {
        int length = (this.buffer.length / 3) - 1;
        while (i6 <= length) {
            int i10 = (length + i6) >>> 1;
            int i11 = i10 * 3;
            int iNumberAt = numberAt(i11);
            if (i == iNumberAt) {
                return i11;
            }
            if (i < iNumberAt) {
                length = i10 - 1;
            } else {
                i6 = i10 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, boolean r11, java.lang.Object[] r12) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L27
            androidx.datastore.preferences.protobuf.FieldType r11 = r8.getType()
            int r11 = r11.id()
            int r11 = r11 + 51
            java.lang.reflect.Field r2 = r0.getValueField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r2 = (int) r2
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r3
        L23:
            r3 = r2
            r2 = r0
            r0 = r1
            goto L73
        L27:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r2 = (int) r2
            int r3 = r0.id()
            if (r11 != 0) goto L5d
            boolean r11 = r0.isList()
            if (r11 != 0) goto L5d
            boolean r11 = r0.isMap()
            if (r11 != 0) goto L5d
            java.lang.reflect.Field r11 = r8.getPresenceField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r11)
            int r0 = (int) r4
            int r11 = r8.getPresenceMask()
            int r11 = java.lang.Integer.numberOfTrailingZeros(r11)
            r7 = r0
            r0 = r11
            r11 = r3
            r3 = r2
            r2 = r7
            goto L73
        L5d:
            java.lang.reflect.Field r11 = r8.getCachedSizeField()
            if (r11 != 0) goto L68
            r0 = r1
            r11 = r3
            r3 = r2
            r2 = r0
            goto L73
        L68:
            java.lang.reflect.Field r11 = r8.getCachedSizeField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r11)
            int r0 = (int) r4
            r11 = r3
            goto L23
        L73:
            int r4 = r8.getFieldNumber()
            r9[r10] = r4
            int r4 = r10 + 1
            boolean r5 = r8.isEnforceUtf8()
            if (r5 == 0) goto L84
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L85
        L84:
            r5 = r1
        L85:
            boolean r6 = r8.isRequired()
            if (r6 == 0) goto L8d
            r1 = 268435456(0x10000000, float:2.524355E-29)
        L8d:
            r1 = r1 | r5
            int r11 = r11 << 20
            r11 = r11 | r1
            r11 = r11 | r3
            r9[r4] = r11
            int r11 = r10 + 2
            int r0 = r0 << 20
            r0 = r0 | r2
            r9[r11] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r11 = r8.getMapDefaultEntry()
            if (r11 == 0) goto Lc5
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r11 = r8.getMapDefaultEntry()
            r12[r10] = r11
            if (r9 == 0) goto Lb6
            int r10 = r10 + 1
            r12[r10] = r9
            return
        Lb6:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Le2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r12[r10] = r8
            return
        Lc5:
            if (r9 == 0) goto Ld0
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r12[r10] = r9
            return
        Ld0:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Le2
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r12[r10] = r8
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto2(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto3(T r13, androidx.datastore.preferences.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i6) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t9, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t9), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean equals(T t9, T t10) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t9, t10, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t9).equals(this.unknownFieldSchema.getFromMessage(t10))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t9).equals(this.extensionSchema.getExtensions(t10));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T t9) {
        return this.proto3 ? getSerializedSizeProto3(t9) : getSerializedSizeProto2(t9);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int hashCode(T t9) {
        int i;
        int iHashLong;
        int i6;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i11);
            int iNumberAt = numberAt(i11);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i10 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t9, jOffset)));
                    i10 = iHashLong + i;
                    break;
                case 1:
                    i = i10 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 2:
                    i = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 3:
                    i = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 4:
                    i6 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t9, jOffset);
                    i10 = i6 + iOneofIntAt;
                    break;
                case 5:
                    i = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 6:
                    i6 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t9, jOffset);
                    i10 = i6 + iOneofIntAt;
                    break;
                case 7:
                    i = i10 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 8:
                    i = i10 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t9, jOffset)).hashCode();
                    i10 = iHashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t9, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i10 = (i10 * 53) + iHashCode;
                    break;
                case 10:
                    i = i10 * 53;
                    iHashLong = UnsafeUtil.getObject(t9, jOffset).hashCode();
                    i10 = iHashLong + i;
                    break;
                case 11:
                    i6 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t9, jOffset);
                    i10 = i6 + iOneofIntAt;
                    break;
                case 12:
                    i6 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t9, jOffset);
                    i10 = i6 + iOneofIntAt;
                    break;
                case 13:
                    i6 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t9, jOffset);
                    i10 = i6 + iOneofIntAt;
                    break;
                case 14:
                    i = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 15:
                    i6 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t9, jOffset);
                    i10 = i6 + iOneofIntAt;
                    break;
                case 16:
                    i = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t9, jOffset));
                    i10 = iHashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t9, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i10 = (i10 * 53) + iHashCode;
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
                    i = i10 * 53;
                    iHashLong = UnsafeUtil.getObject(t9, jOffset).hashCode();
                    i10 = iHashLong + i;
                    break;
                case 50:
                    i = i10 * 53;
                    iHashLong = UnsafeUtil.getObject(t9, jOffset).hashCode();
                    i10 = iHashLong + i;
                    break;
                case 51:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t9, jOffset)));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i6 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t9, jOffset);
                        i10 = i6 + iOneofIntAt;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i6 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t9, jOffset);
                        i10 = i6 + iOneofIntAt;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t9, jOffset)).hashCode();
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = UnsafeUtil.getObject(t9, jOffset).hashCode();
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = UnsafeUtil.getObject(t9, jOffset).hashCode();
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i6 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t9, jOffset);
                        i10 = i6 + iOneofIntAt;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i6 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t9, jOffset);
                        i10 = i6 + iOneofIntAt;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i6 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t9, jOffset);
                        i10 = i6 + iOneofIntAt;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i6 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t9, jOffset);
                        i10 = i6 + iOneofIntAt;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t9, jOffset));
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t9, iNumberAt, i11)) {
                        i = i10 * 53;
                        iHashLong = UnsafeUtil.getObject(t9, jOffset).hashCode();
                        i10 = iHashLong + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t9).hashCode() + (i10 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t9).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T r13) {
        /*
            r12 = this;
            r0 = -1
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r12.checkInitializedCount
            r5 = 1
            if (r2 >= r4) goto L94
            int[] r4 = r12.intArray
            r4 = r4[r2]
            int r6 = r12.numberAt(r4)
            int r7 = r12.typeAndOffsetAt(r4)
            boolean r8 = r12.proto3
            if (r8 != 0) goto L31
            int[] r8 = r12.buffer
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r0) goto L32
            sun.misc.Unsafe r0 = androidx.datastore.preferences.protobuf.MessageSchema.UNSAFE
            long r10 = (long) r9
            int r3 = r0.getInt(r13, r10)
            r0 = r9
            goto L32
        L31:
            r5 = r1
        L32:
            boolean r8 = isRequired(r7)
            if (r8 == 0) goto L3f
            boolean r8 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r8 != 0) goto L3f
            return r1
        L3f:
            int r8 = type(r7)
            r9 = 9
            if (r8 == r9) goto L7f
            r9 = 17
            if (r8 == r9) goto L7f
            r5 = 27
            if (r8 == r5) goto L78
            r5 = 60
            if (r8 == r5) goto L67
            r5 = 68
            if (r8 == r5) goto L67
            r5 = 49
            if (r8 == r5) goto L78
            r5 = 50
            if (r8 == r5) goto L60
            goto L90
        L60:
            boolean r4 = r12.isMapInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L67:
            boolean r5 = r12.isOneofPresent(r13, r6, r4)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L78:
            boolean r4 = r12.isListInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L7f:
            boolean r5 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L90:
            int r2 = r2 + 1
            goto L4
        L94:
            boolean r0 = r12.hasExtensions
            if (r0 == 0) goto La5
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r12 = r12.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r12 = r12.getExtensions(r13)
            boolean r12 = r12.isInitialized()
            if (r12 != 0) goto La5
            return r1
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.isInitialized(java.lang.Object):boolean");
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T t9) {
        int i;
        int i6 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i6 >= i) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i6]));
            Object object = UnsafeUtil.getObject(t9, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t9, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i6++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t9, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t9);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t9);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t9, T t10) {
        t10.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t9, t10, i);
        }
        if (this.proto3) {
            return;
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t9, t10);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t9, t10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0090. Please report as an issue. */
    public int parseProto2Message(T t9, byte[] bArr, int i, int i6, int i10, ArrayDecoders.Registers registers) throws IOException {
        T t10;
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int i11;
        int i12;
        int i13;
        ArrayDecoders.Registers registers2;
        int i14;
        int i15;
        T t11;
        int iDecodeUnknownField;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        T t12;
        Unsafe unsafe2;
        byte[] bArr2;
        int i24;
        Unsafe unsafe3;
        byte[] bArr3;
        int iDecodeVarint32;
        int i25;
        int i26;
        byte[] bArr4;
        int iDecodeMessageField;
        MessageSchema<T> messageSchema2 = this;
        T t13 = t9;
        byte[] bArr5 = bArr;
        int i27 = i6;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe4 = UNSAFE;
        int i28 = -1;
        int i29 = i;
        int i30 = -1;
        int i31 = -1;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        while (true) {
            if (i29 < i27) {
                int iDecodeVarint322 = i29 + 1;
                int i35 = bArr5[i29];
                if (i35 < 0) {
                    iDecodeVarint322 = ArrayDecoders.decodeVarint32(i35, bArr5, iDecodeVarint322, registers3);
                    i35 = registers3.int1;
                }
                int i36 = iDecodeVarint322;
                i34 = i35;
                int i37 = i34 >>> 3;
                int i38 = i34 & 7;
                int iPositionForFieldNumber = i37 > i30 ? messageSchema2.positionForFieldNumber(i37, i32 / 3) : messageSchema2.positionForFieldNumber(i37);
                if (iPositionForFieldNumber == i28) {
                    i11 = i36;
                    unsafe = unsafe4;
                    i12 = i31;
                    i13 = i37;
                    registers2 = registers;
                    messageSchema = messageSchema2;
                    i14 = i34;
                    i15 = 0;
                } else {
                    int i39 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i39);
                    int i40 = i31;
                    long jOffset = offset(i39);
                    if (iType <= 17) {
                        int i41 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i42 = 1 << (i41 >>> 20);
                        int i43 = i41 & OFFSET_MASK;
                        i13 = i37;
                        if (i43 != i40) {
                            i19 = iType;
                            if (i40 != -1) {
                                unsafe4.putInt(t13, i40, i33);
                            }
                            i21 = i43;
                            i20 = unsafe4.getInt(t13, i43);
                        } else {
                            i19 = iType;
                            i20 = i33;
                            i21 = i40;
                        }
                        switch (i19) {
                            case 0:
                                i22 = iPositionForFieldNumber;
                                i23 = i36;
                                registers2 = registers;
                                t12 = t13;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i38 == 1) {
                                    UnsafeUtil.putDouble(t12, jOffset, ArrayDecoders.decodeDouble(bArr2, i23));
                                    i29 = i23 + 8;
                                    i24 = i20 | i42;
                                    i27 = i6;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i33 = i24;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t13 = t12;
                                    i28 = -1;
                                    break;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 1:
                                i22 = iPositionForFieldNumber;
                                i23 = i36;
                                registers2 = registers;
                                t12 = t13;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i38 == 5) {
                                    UnsafeUtil.putFloat(t12, jOffset, ArrayDecoders.decodeFloat(bArr2, i23));
                                    i29 = i23 + 4;
                                    i24 = i20 | i42;
                                    i27 = i6;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i33 = i24;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t13 = t12;
                                    i28 = -1;
                                    break;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 2:
                            case 3:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i23 = i36;
                                bArr2 = bArr;
                                registers2 = registers;
                                if (i38 == 0) {
                                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i23, registers2);
                                    T t14 = t13;
                                    unsafe2 = unsafe3;
                                    unsafe2.putLong(t14, jOffset, registers2.long1);
                                    t12 = t14;
                                    i24 = i20 | i42;
                                    i27 = i6;
                                    i29 = iDecodeVarint64;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i33 = i24;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t13 = t12;
                                    i28 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 4:
                            case 11:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i23 = i36;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i38 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr3, i23, registers2);
                                    unsafe3.putInt(t13, jOffset, registers2.int1);
                                    Unsafe unsafe5 = unsafe3;
                                    i29 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i28 = -1;
                                    i33 = i20 | i42;
                                    i27 = i6;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 5:
                            case 14:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i38 == 1) {
                                    T t15 = t13;
                                    unsafe3.putLong(t15, jOffset, ArrayDecoders.decodeFixed64(bArr3, i36));
                                    unsafe3 = unsafe3;
                                    t13 = t15;
                                    iDecodeVarint32 = i36 + 8;
                                    Unsafe unsafe52 = unsafe3;
                                    i29 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i28 = -1;
                                    i33 = i20 | i42;
                                    i27 = i6;
                                    break;
                                } else {
                                    i23 = i36;
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 6:
                            case 13:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i38 == 5) {
                                    unsafe3.putInt(t13, jOffset, ArrayDecoders.decodeFixed32(bArr3, i25));
                                    iDecodeVarint32 = i25 + 4;
                                    Unsafe unsafe522 = unsafe3;
                                    i29 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe522;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i28 = -1;
                                    i33 = i20 | i42;
                                    i27 = i6;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 7:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i38 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint64(bArr3, i25, registers2);
                                    UnsafeUtil.putBoolean(t13, jOffset, registers2.long1 != 0);
                                    Unsafe unsafe5222 = unsafe3;
                                    i29 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5222;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i28 = -1;
                                    i33 = i20 | i42;
                                    i27 = i6;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 8:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i38 == 2) {
                                    iDecodeVarint32 = (i39 & ENFORCE_UTF8_MASK) == 0 ? ArrayDecoders.decodeString(bArr3, i25, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr3, i25, registers2);
                                    unsafe3.putObject(t13, jOffset, registers2.object1);
                                    Unsafe unsafe52222 = unsafe3;
                                    i29 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52222;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i28 = -1;
                                    i33 = i20 | i42;
                                    i27 = i6;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 9:
                                i26 = i27;
                                registers2 = registers;
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr4 = bArr;
                                if (i38 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i22), bArr4, i25, i26, registers2);
                                    if ((i20 & i42) == 0) {
                                        unsafe3.putObject(t13, jOffset, registers2.object1);
                                    } else {
                                        unsafe3.putObject(t13, jOffset, Internal.mergeMessage(unsafe3.getObject(t13, jOffset), registers2.object1));
                                    }
                                    Unsafe unsafe6 = unsafe3;
                                    i29 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i33 = i20 | i42;
                                    i27 = i26;
                                    i28 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 10:
                                i26 = i27;
                                registers2 = registers;
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr4 = bArr;
                                if (i38 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeBytes(bArr4, i25, registers2);
                                    unsafe3.putObject(t13, jOffset, registers2.object1);
                                    Unsafe unsafe62 = unsafe3;
                                    i29 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe62;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i33 = i20 | i42;
                                    i27 = i26;
                                    i28 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 12:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr4 = bArr;
                                registers2 = registers;
                                i26 = i27;
                                if (i38 != 0) {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                } else {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i25, registers2);
                                    int i44 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i22);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i44)) {
                                        unsafe3.putInt(t13, jOffset, i44);
                                        Unsafe unsafe622 = unsafe3;
                                        i29 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe622;
                                        registers3 = registers2;
                                        i31 = i21;
                                        i32 = i22;
                                        i30 = i13;
                                        i33 = i20 | i42;
                                        i27 = i26;
                                        i28 = -1;
                                        break;
                                    } else {
                                        getMutableUnknownFields(t13).storeField(i34, Long.valueOf(i44));
                                        i29 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe3;
                                        i27 = i26;
                                        registers3 = registers2;
                                        i31 = i21;
                                        i33 = i20;
                                        i32 = i22;
                                        i30 = i13;
                                        i28 = -1;
                                    }
                                }
                                break;
                            case 15:
                                i22 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i25 = i36;
                                bArr4 = bArr;
                                registers2 = registers;
                                i26 = i27;
                                if (i38 == 0) {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i25, registers2);
                                    unsafe3.putInt(t13, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    Unsafe unsafe6222 = unsafe3;
                                    i29 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6222;
                                    registers3 = registers2;
                                    i31 = i21;
                                    i32 = i22;
                                    i30 = i13;
                                    i33 = i20 | i42;
                                    i27 = i26;
                                    i28 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 16:
                                i22 = iPositionForFieldNumber;
                                i25 = i36;
                                if (i38 == 0) {
                                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i25, registers);
                                    T t16 = t13;
                                    Unsafe unsafe7 = unsafe4;
                                    unsafe7.putLong(t16, jOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                    t13 = t16;
                                    int i45 = i21;
                                    i33 = i20 | i42;
                                    bArr5 = bArr;
                                    unsafe4 = unsafe7;
                                    i29 = iDecodeVarint642;
                                    registers3 = registers;
                                    i31 = i45;
                                    i27 = i6;
                                    i32 = i22;
                                    i30 = i13;
                                    i28 = -1;
                                    break;
                                } else {
                                    unsafe3 = unsafe4;
                                    registers2 = registers;
                                    unsafe2 = unsafe3;
                                    i23 = i25;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            case 17:
                                if (i38 == 3) {
                                    int i46 = iPositionForFieldNumber;
                                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i36, i27, (i13 << 3) | 4, registers);
                                    if ((i20 & i42) == 0) {
                                        unsafe4.putObject(t13, jOffset, registers.object1);
                                    } else {
                                        unsafe4.putObject(t13, jOffset, Internal.mergeMessage(unsafe4.getObject(t13, jOffset), registers.object1));
                                    }
                                    i29 = iDecodeGroupField;
                                    bArr5 = bArr;
                                    registers3 = registers;
                                    i31 = i21;
                                    i32 = i46;
                                    i28 = -1;
                                    i27 = i6;
                                    i33 = i20 | i42;
                                    i30 = i13;
                                    break;
                                } else {
                                    i22 = iPositionForFieldNumber;
                                    registers2 = registers;
                                    unsafe2 = unsafe4;
                                    i23 = i36;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i11 = i23;
                                    i12 = i21;
                                    i14 = i34;
                                    i33 = i20;
                                    i15 = i22;
                                    break;
                                }
                            default:
                                registers2 = registers;
                                i22 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i23 = i36;
                                messageSchema = messageSchema2;
                                unsafe = unsafe2;
                                i11 = i23;
                                i12 = i21;
                                i14 = i34;
                                i33 = i20;
                                i15 = i22;
                                break;
                        }
                    } else {
                        int i47 = iPositionForFieldNumber;
                        i13 = i37;
                        T t17 = t13;
                        Unsafe unsafe8 = unsafe4;
                        i12 = i40;
                        if (iType == 27) {
                            if (i38 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe8.getObject(t17, jOffset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe8.putObject(t17, jOffset, protobufListMutableCopyWithCapacity2);
                                }
                                unsafe4 = unsafe8;
                                int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i47), i34, bArr, i36, i6, protobufListMutableCopyWithCapacity2, registers);
                                bArr5 = bArr;
                                i27 = i6;
                                registers3 = registers;
                                i29 = iDecodeMessageList;
                                t13 = t17;
                                i32 = i47;
                                i30 = i13;
                                i31 = i12;
                                i28 = -1;
                            } else {
                                unsafe = unsafe8;
                                i18 = i36;
                                i16 = i33;
                                i17 = i34;
                                i15 = i47;
                                messageSchema = this;
                                registers2 = registers;
                                i11 = i18;
                                i14 = i17;
                            }
                        } else if (iType <= 49) {
                            unsafe = unsafe8;
                            i16 = i33;
                            int repeatedField = messageSchema2.parseRepeatedField(t9, bArr, i36, i6, i34, i13, i38, i47, i39, iType, jOffset, registers);
                            i17 = i34;
                            i15 = i47;
                            if (repeatedField != i36) {
                                messageSchema2 = this;
                                t13 = t9;
                                bArr5 = bArr;
                                i27 = i6;
                                i29 = repeatedField;
                                i32 = i15;
                                i33 = i16;
                                i30 = i13;
                                i31 = i12;
                                unsafe4 = unsafe;
                                registers3 = registers;
                                i34 = i17;
                                i28 = -1;
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i11 = repeatedField;
                                i14 = i17;
                            }
                        } else {
                            unsafe = unsafe8;
                            i16 = i33;
                            i17 = i34;
                            i15 = i47;
                            i18 = i36;
                            if (iType != 50) {
                                int oneofField = parseOneofField(t9, bArr, i18, i6, i17, i13, i38, i39, iType, jOffset, i15, registers);
                                messageSchema = this;
                                i14 = i17;
                                registers2 = registers;
                                if (oneofField != i18) {
                                    t13 = t9;
                                    bArr5 = bArr;
                                    i27 = i6;
                                    i29 = oneofField;
                                    registers3 = registers2;
                                    i32 = i15;
                                    i33 = i16;
                                    i30 = i13;
                                    i31 = i12;
                                    i28 = -1;
                                    i34 = i14;
                                    messageSchema2 = messageSchema;
                                    unsafe4 = unsafe;
                                } else {
                                    i11 = oneofField;
                                }
                            } else if (i38 == 2) {
                                int mapField = parseMapField(t9, bArr, i18, i6, i15, jOffset, registers);
                                if (mapField != i18) {
                                    messageSchema2 = this;
                                    t13 = t9;
                                    bArr5 = bArr;
                                    i27 = i6;
                                    registers3 = registers;
                                    i29 = mapField;
                                    i32 = i15;
                                    i33 = i16;
                                    i30 = i13;
                                    i31 = i12;
                                    unsafe4 = unsafe;
                                    i34 = i17;
                                    i28 = -1;
                                } else {
                                    messageSchema = this;
                                    registers2 = registers;
                                    i11 = mapField;
                                    i14 = i17;
                                }
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i11 = i18;
                                i14 = i17;
                            }
                        }
                        i33 = i16;
                    }
                }
                if (i14 != i10 || i10 == 0) {
                    if (!messageSchema.hasExtensions || registers2.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                        t11 = t9;
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i14, bArr, i11, i6, getMutableUnknownFields(t11), registers);
                        i27 = i6;
                    } else {
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i14, bArr, i11, i6, t9, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers2);
                        t11 = t9;
                        i27 = i6;
                    }
                    i29 = iDecodeUnknownField;
                    bArr5 = bArr;
                    registers3 = registers;
                    t13 = t11;
                    i32 = i15;
                    i30 = i13;
                    i31 = i12;
                    i28 = -1;
                    i34 = i14;
                    messageSchema2 = messageSchema;
                    unsafe4 = unsafe;
                } else {
                    t10 = t9;
                    i27 = i6;
                    i34 = i14;
                    i29 = i11;
                    i31 = i12;
                }
            } else {
                t10 = t13;
                unsafe = unsafe4;
                messageSchema = messageSchema2;
            }
        }
        if (i31 != -1) {
            unsafe.putInt(t10, i31, i33);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i48 = messageSchema.checkInitializedCount; i48 < messageSchema.repeatedFieldOffsetStart; i48++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t10, messageSchema.intArray[i48], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t10, unknownFieldSetLite);
        }
        if (i10 == 0) {
            if (i29 != i27) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i29 > i27 || i34 != i10) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i29;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void writeTo(T t9, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t9, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t9, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t9, writer);
        }
    }

    private boolean isFieldPresent(T t9, int i) {
        boolean zEquals;
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t9, jOffset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t9, jOffset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t9, jOffset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t9, jOffset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t9, jOffset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t9, jOffset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t9, jOffset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t9, jOffset);
                case 8:
                    Object object = UnsafeUtil.getObject(t9, jOffset);
                    if (object instanceof String) {
                        zEquals = ((String) object).isEmpty();
                        break;
                    } else if (object instanceof ByteString) {
                        zEquals = ByteString.EMPTY.equals(object);
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    return UnsafeUtil.getObject(t9, jOffset) != null;
                case 10:
                    zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t9, jOffset));
                    break;
                case 11:
                    return UnsafeUtil.getInt(t9, jOffset) != 0;
                case 12:
                    return UnsafeUtil.getInt(t9, jOffset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t9, jOffset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t9, jOffset) != 0;
                case 15:
                    return UnsafeUtil.getInt(t9, jOffset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t9, jOffset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t9, jOffset) != null;
                default:
                    throw new IllegalArgumentException();
            }
            return !zEquals;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        return (UnsafeUtil.getInt(t9, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private int positionForFieldNumber(int i, int i6) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t9, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t9, reader, extensionRegistryLite);
    }

    private boolean equals(T t9, T t10, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t9, t10, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t9, jOffset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t10, jOffset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t9, t10, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t9, jOffset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t10, jOffset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, jOffset) != UnsafeUtil.getLong(t10, jOffset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, jOffset) != UnsafeUtil.getLong(t10, jOffset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, jOffset) != UnsafeUtil.getInt(t10, jOffset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, jOffset) != UnsafeUtil.getLong(t10, jOffset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, jOffset) != UnsafeUtil.getInt(t10, jOffset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getBoolean(t9, jOffset) != UnsafeUtil.getBoolean(t10, jOffset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, jOffset), UnsafeUtil.getObject(t10, jOffset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, jOffset), UnsafeUtil.getObject(t10, jOffset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, jOffset), UnsafeUtil.getObject(t10, jOffset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, jOffset) != UnsafeUtil.getInt(t10, jOffset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, jOffset) != UnsafeUtil.getInt(t10, jOffset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, jOffset) != UnsafeUtil.getInt(t10, jOffset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, jOffset) != UnsafeUtil.getLong(t10, jOffset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, jOffset) != UnsafeUtil.getInt(t10, jOffset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, jOffset) != UnsafeUtil.getLong(t10, jOffset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, jOffset), UnsafeUtil.getObject(t10, jOffset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 68:
                if (!isOneofCaseEqual(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, jOffset), UnsafeUtil.getObject(t10, jOffset))) {
                }
                break;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t9, byte[] bArr, int i, int i6, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t9, bArr, i, i6, registers);
        } else {
            parseProto2Message(t9, bArr, i, i6, 0, registers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }
}
