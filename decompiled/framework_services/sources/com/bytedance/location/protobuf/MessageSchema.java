package com.bytedance.location.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = null;
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

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L59:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L63:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L77:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L55:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L61:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L44
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;     // Catch: NoSuchFieldError -> L47
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L57:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;     // Catch: NoSuchFieldError -> L53
            return;
        }
    }

    static {
        EMPTY_INT_ARRAY = new int[0];
        UNSAFE = UnsafeUtil.getUnsafe();
    }

    private MessageSchema(int[] buffer, Object[] objects, int minFieldNumber, int maxFieldNumber, MessageLite defaultInstance, boolean proto3, boolean useCachedSizeField, int[] intArray, int checkInitialized, int mapFieldPositions, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = buffer;
        this.objects = objects;
        this.minFieldNumber = minFieldNumber;
        this.maxFieldNumber = maxFieldNumber;
        this.lite = defaultInstance instanceof GeneratedMessageLite;
        this.proto3 = proto3;
        if (extensionSchema != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        this.hasExtensions = r8;
        this.useCachedSizeField = useCachedSizeField;
        this.intArray = intArray;
        this.checkInitializedCount = checkInitialized;
        this.repeatedFieldOffsetStart = mapFieldPositions;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
        this.mapFieldSchema = mapFieldSchema;
        return;
    L5:
        if (extensionSchema.hasExtensions(defaultInstance) == false) goto L7;
        r8 = true;
        goto L8
    }

    static <T> MessageSchema<T> newSchema(Class<T> messageClass, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if ((messageInfo instanceof RawMessageInfo) == false) goto L7;
        return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    L7:
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo.getSyntax() != ProtoSyntax.PROTO3) goto L5;
        boolean r0 = true;
    L6:
        boolean isProto3 = r0;
        String info = messageInfo.getStringInfo();
        int length = info.length();
        int i = 0 + 1;
        int next = info.charAt(0);
        int r6 = 55296;
        if (next < 55296) goto L13;
        int result = next & 8191;
        int shift = 13;
    L9:
        int i2 = i + 1;
        int next2 = info.charAt(i);
        if (next2 < 55296) goto L12;
        result = result | ((next2 & 8191) << shift);
        shift = shift + 13;
        i = i2;
        goto L9
    L12:
        next = result | (next2 << shift);
        i = i2;
    L13:
        int i3 = i + 1;
        int next3 = info.charAt(i);
        if (next3 < 55296) goto L20;
        int result2 = next3 & 8191;
        int shift2 = 13;
    L16:
        int i4 = i3 + 1;
        int next4 = info.charAt(i3);
        if (next4 < 55296) goto L19;
        result2 = result2 | ((next4 & 8191) << shift2);
        shift2 = shift2 + 13;
        i3 = i4;
        goto L16
    L19:
        next3 = result2 | (next4 << shift2);
        i3 = i4;
    L20:
        int fieldCount = next3;
        if (fieldCount != 0) goto L23;
        int maxFieldNumber = 0;
        int[] intArray = EMPTY_INT_ARRAY;
        int oneofCount = 0;
        int hasBitsCount = 0;
        int numEntries = 0;
        int mapFieldCount = 0;
        int mapFieldCount2 = 0;
        int[] intArray2 = intArray;
        int objectsPosition = 0;
    L80:
        Unsafe unsafe = UNSAFE;
        Object[] messageInfoObjects = messageInfo.getObjects();
        Class<?> messageClass = messageInfo.getDefaultInstance().getClass();
        int[] buffer = new int[numEntries * 3];
        Object[] objects = new Object[numEntries * 2];
        int mapFieldIndex = mapFieldCount2;
        int repeatedFieldIndex = mapFieldCount2 + mapFieldCount;
        int objectsPosition2 = objectsPosition;
        int mapFieldIndex2 = mapFieldIndex;
        int repeatedFieldIndex2 = repeatedFieldIndex;
        int bufferIndex = 0;
        int next5 = i3;
        int checkInitializedPosition = 0;
    L81:
        if (next5 >= length) goto L193;
        int i5 = next5 + 1;
        int next6 = info.charAt(next5);
        if (next6 < r6) goto L89;
        int result3 = next6 & 8191;
        int shift3 = 13;
    L85:
        int i6 = i5 + 1;
        int next7 = info.charAt(i5);
        if (next7 < r6) goto L88;
        result3 = result3 | ((next7 & 8191) << shift3);
        shift3 = shift3 + 13;
        i5 = i6;
        goto L85
    L88:
        next6 = result3 | (next7 << shift3);
        i5 = i6;
    L89:
        int result4 = next6;
        int i7 = i5 + 1;
        int next8 = info.charAt(i5);
        if (next8 < r6) goto L96;
        int result5 = next8 & 8191;
        int i8 = i7;
        int i9 = 13;
    L92:
        int i10 = i8 + 1;
        int next9 = info.charAt(i8);
        int length2 = length;
        if (next9 < 55296) goto L95;
        result5 = result5 | ((next9 & 8191) << i9);
        i9 = i9 + 13;
        i8 = i10;
        length = length2;
        goto L92
    L95:
        next8 = result5 | (next9 << i9);
        int i11 = i10;
    L97:
        int fieldTypeWithExtraBits = next8;
        int fieldType = fieldTypeWithExtraBits & 255;
        int oneofCount2 = oneofCount;
        int oneofCount3 = fieldTypeWithExtraBits & 1024;
        if (oneofCount3 == 0) goto L100;
        intArray2[checkInitializedPosition] = bufferIndex;
        checkInitializedPosition = checkInitializedPosition + 1;
    L100:
        Object[] objects2 = objects;
        if (fieldType < 51) goto L128;
        int i12 = i11 + 1;
        int next10 = info.charAt(i11);
        if (next10 < 55296) goto L109;
        int result6 = next10 & 8191;
        int shift4 = 13;
    L105:
        int i13 = i12 + 1;
        int next11 = info.charAt(i12);
        if (next11 < 55296) goto L108;
        result6 = result6 | ((next11 & 8191) << shift4);
        shift4 = shift4 + 13;
        i12 = i13;
        goto L105
    L108:
        next10 = result6 | (next11 << shift4);
        i12 = i13;
    L109:
        int oneofIndex = next10;
        int oneofFieldType = fieldType - 51;
        if (oneofFieldType != 9) goto L112;
    L118:
        objects2[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition2];
        objectsPosition2 = objectsPosition2 + 1;
    L119:
        int index = oneofIndex * 2;
        Object o = messageInfoObjects[index];
        int i14 = i12;
        if ((o instanceof Field) == false) goto L122;
        Field oneofField = (Field) o;
    L123:
        int fieldOffset = (int) unsafe.objectFieldOffset(oneofField);
        int index2 = index + 1;
        Object o2 = messageInfoObjects[index2];
        if ((o2 instanceof Field) == false) goto L126;
        Field oneofCaseField = (Field) o2;
    L127:
        int presenceFieldOffset = (int) unsafe.objectFieldOffset(oneofCaseField);
        int presenceMaskShift = 0;
        String info2 = info;
        int presenceFieldOffset2 = presenceFieldOffset;
        int presenceFieldOffset3 = fieldOffset;
        int minFieldNumber = maxFieldNumber;
        next5 = i14;
        int next12 = hasBitsCount;
    L183:
        int bufferIndex2 = bufferIndex + 1;
        buffer[bufferIndex] = result4;
        int bufferIndex3 = bufferIndex2 + 1;
        if ((fieldTypeWithExtraBits & 512) == 0) goto L186;
        int r9 = 536870912;
    L187:
        int presenceFieldOffset4 = presenceFieldOffset2;
        int presenceFieldOffset5 = fieldTypeWithExtraBits & 256;
        if (presenceFieldOffset5 == 0) goto L190;
        int r1 = 268435456;
    L191:
        buffer[bufferIndex2] = ((r1 | r9) | (fieldType << 20)) | presenceFieldOffset3;
        bufferIndex = bufferIndex3 + 1;
        buffer[bufferIndex3] = (presenceMaskShift << 20) | presenceFieldOffset4;
        maxFieldNumber = minFieldNumber;
        length = length2;
        oneofCount = oneofCount2;
        objects = objects2;
        hasBitsCount = next12;
        info = info2;
        r6 = 55296;
        goto L81
    L190:
        r1 = 0;
        goto L191
    L186:
        r9 = 0;
        goto L187
    L126:
        oneofCaseField = reflectField(messageClass, (String) o2);
        messageInfoObjects[index2] = oneofCaseField;
        goto L127
    L122:
        oneofField = reflectField(messageClass, (String) o);
        messageInfoObjects[index] = oneofField;
        goto L123
    L112:
        if (oneofFieldType == 17) goto L118;
        if (oneofFieldType != 12) goto L119;
        if (isProto3 == true) goto L119;
        objects2[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition2];
        objectsPosition2 = objectsPosition2 + 1;
        goto L119
    L128:
        int objectsPosition3 = objectsPosition2 + 1;
        Field field = reflectField(messageClass, (String) messageInfoObjects[objectsPosition2]);
        if (fieldType != 9) goto L131;
    L154:
        objects2[((bufferIndex / 3) * 2) + 1] = field.getType();
    L155:
        int objectsPosition4 = objectsPosition3;
    L156:
        next12 = hasBitsCount;
        minFieldNumber = maxFieldNumber;
        int fieldOffset2 = (int) unsafe.objectFieldOffset(field);
        int objectsPosition5 = objectsPosition4;
        if ((fieldTypeWithExtraBits & 4096) != 4096) goto L159;
        boolean hasHasBit = true;
    L160:
        if (hasHasBit == true) goto L162;
    L176:
        info2 = info;
        int presenceFieldOffset6 = 1048575;
        int i15 = i11;
        presenceMaskShift = 0;
    L178:
        if (fieldType >= 18) goto L180;
    L182:
        presenceFieldOffset2 = presenceFieldOffset6;
        presenceFieldOffset3 = fieldOffset2;
        objectsPosition2 = objectsPosition5;
        next5 = i15;
        goto L183
    L180:
        if (fieldType > 49) goto L182;
        intArray2[repeatedFieldIndex2] = fieldOffset2;
        repeatedFieldIndex2 = repeatedFieldIndex2 + 1;
        presenceFieldOffset2 = presenceFieldOffset6;
        presenceFieldOffset3 = fieldOffset2;
        objectsPosition2 = objectsPosition5;
        next5 = i15;
        goto L183
    L162:
        if (fieldType > 17) goto L176;
        int i16 = i11 + 1;
        int next13 = info.charAt(i11);
        if (next13 < 55296) goto L170;
        int result7 = next13 & 8191;
        int shift5 = 13;
    L166:
        int i17 = i16 + 1;
        int next14 = info.charAt(i16);
        info2 = info;
        if (next14 < 55296) goto L169;
        result7 = result7 | ((next14 & 8191) << shift5);
        shift5 = shift5 + 13;
        i16 = i17;
        info = info2;
        goto L166
    L169:
        next8 = result7 | (next14 << shift5);
        int next15 = i17;
    L171:
        int i18 = next8;
        int index3 = (oneofCount2 * 2) + (i18 / 32);
        Object o3 = messageInfoObjects[index3];
        i15 = next15;
        if ((o3 instanceof Field) == false) goto L174;
        Field hasBitsField = (Field) o3;
    L175:
        int presenceFieldOffset7 = (int) unsafe.objectFieldOffset(hasBitsField);
        int presenceMaskShift2 = i18 % 32;
        presenceFieldOffset6 = presenceFieldOffset7;
        presenceMaskShift = presenceMaskShift2;
        goto L178
    L174:
        hasBitsField = reflectField(messageClass, (String) o3);
        messageInfoObjects[index3] = hasBitsField;
        goto L175
    L170:
        info2 = info;
        next8 = next13;
        next15 = i16;
        goto L171
    L159:
        hasHasBit = false;
        goto L160
    L131:
        if (fieldType == 17) goto L154;
        if (fieldType != 27) goto L136;
    L153:
        objects2[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition3];
        objectsPosition4 = objectsPosition3 + 1;
        goto L156
    L136:
        if (fieldType == 49) goto L153;
        if (fieldType != 12) goto L141;
    L151:
        if (isProto3 == true) goto L155;
        objects2[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition3];
        objectsPosition4 = objectsPosition3 + 1;
        goto L156
    L141:
        if (fieldType == 30) goto L151;
        if (fieldType == 44) goto L151;
        if (fieldType != 50) goto L155;
        int mapFieldIndex3 = mapFieldIndex2 + 1;
        intArray2[mapFieldIndex2] = bufferIndex;
        int objectsPosition6 = objectsPosition3 + 1;
        objects2[(bufferIndex / 3) * 2] = messageInfoObjects[objectsPosition3];
        int mapFieldIndex4 = fieldTypeWithExtraBits & 2048;
        if (mapFieldIndex4 == 0) goto L150;
        objects2[((bufferIndex / 3) * 2) + 1] = messageInfoObjects[objectsPosition6];
        objectsPosition4 = objectsPosition6 + 1;
        mapFieldIndex2 = mapFieldIndex3;
        goto L156
    L150:
        mapFieldIndex2 = mapFieldIndex3;
        objectsPosition4 = objectsPosition6;
        goto L156
    L96:
        length2 = length;
        i11 = i7;
        goto L97
    L193:
        return new MessageSchema(buffer, objects, maxFieldNumber, hasBitsCount, messageInfo.getDefaultInstance(), isProto3, false, intArray2, mapFieldCount2, mapFieldCount2 + mapFieldCount, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    L23:
        int i19 = i3 + 1;
        int next16 = info.charAt(i3);
        if (next16 < 55296) goto L30;
        int result8 = next16 & 8191;
        int shift6 = 13;
    L26:
        int i20 = i19 + 1;
        int next17 = info.charAt(i19);
        if (next17 < 55296) goto L29;
        result8 = result8 | ((next17 & 8191) << shift6);
        shift6 = shift6 + 13;
        i19 = i20;
        goto L26
    L29:
        next16 = result8 | (next17 << shift6);
        i19 = i20;
    L30:
        int result9 = next16;
        int i21 = i19 + 1;
        int next18 = info.charAt(i19);
        if (next18 < 55296) goto L37;
        int result10 = next18 & 8191;
        int shift7 = 13;
    L33:
        int i22 = i21 + 1;
        int next19 = info.charAt(i21);
        if (next19 < 55296) goto L36;
        result10 = result10 | ((next19 & 8191) << shift7);
        shift7 = shift7 + 13;
        i21 = i22;
        goto L33
    L36:
        next18 = result10 | (next19 << shift7);
        i21 = i22;
    L37:
        int result11 = next18;
        int i23 = i21 + 1;
        int next20 = info.charAt(i21);
        if (next20 < 55296) goto L44;
        int result12 = next20 & 8191;
        int shift8 = 13;
    L40:
        int i24 = i23 + 1;
        int next21 = info.charAt(i23);
        if (next21 < 55296) goto L43;
        result12 = result12 | ((next21 & 8191) << shift8);
        shift8 = shift8 + 13;
        i23 = i24;
        goto L40
    L43:
        next20 = result12 | (next21 << shift8);
        i23 = i24;
    L44:
        int result13 = next20;
        int i25 = i23 + 1;
        int next22 = info.charAt(i23);
        if (next22 < 55296) goto L51;
        int result14 = next22 & 8191;
        int shift9 = 13;
    L47:
        int i26 = i25 + 1;
        int next23 = info.charAt(i25);
        if (next23 < 55296) goto L50;
        result14 = result14 | ((next23 & 8191) << shift9);
        shift9 = shift9 + 13;
        i25 = i26;
        goto L47
    L50:
        next22 = result14 | (next23 << shift9);
        i25 = i26;
    L51:
        int result15 = next22;
        int i27 = i25 + 1;
        int next24 = info.charAt(i25);
        if (next24 < 55296) goto L58;
        int result16 = next24 & 8191;
        int shift10 = 13;
    L54:
        int i28 = i27 + 1;
        int next25 = info.charAt(i27);
        if (next25 < 55296) goto L57;
        result16 = result16 | ((next25 & 8191) << shift10);
        shift10 = shift10 + 13;
        i27 = i28;
        goto L54
    L57:
        next24 = result16 | (next25 << shift10);
        i27 = i28;
    L58:
        int result17 = next24;
        int i29 = i27 + 1;
        int next26 = info.charAt(i27);
        if (next26 < 55296) goto L65;
        int result18 = next26 & 8191;
        int shift11 = 13;
    L61:
        int i30 = i29 + 1;
        int next27 = info.charAt(i29);
        if (next27 < 55296) goto L64;
        result18 = result18 | ((next27 & 8191) << shift11);
        shift11 = shift11 + 13;
        i29 = i30;
        goto L61
    L64:
        next26 = result18 | (next27 << shift11);
        i29 = i30;
    L65:
        int result19 = next26;
        int i31 = i29 + 1;
        int next28 = info.charAt(i29);
        if (next28 < 55296) goto L72;
        int result20 = next28 & 8191;
        int shift12 = 13;
    L68:
        int i32 = i31 + 1;
        int next29 = info.charAt(i31);
        if (next29 < 55296) goto L71;
        result20 = result20 | ((next29 & 8191) << shift12);
        shift12 = shift12 + 13;
        i31 = i32;
        goto L68
    L71:
        next28 = result20 | (next29 << shift12);
        i31 = i32;
    L72:
        int result21 = next28;
        int i33 = i31 + 1;
        next3 = info.charAt(i31);
        if (next3 < 55296) goto L79;
        int result22 = next3 & 8191;
        int shift13 = 13;
    L75:
        int i34 = i33 + 1;
        int next30 = info.charAt(i33);
        if (next30 < 55296) goto L78;
        result22 = result22 | ((next30 & 8191) << shift13);
        shift13 = shift13 + 13;
        i33 = i34;
        goto L75
    L78:
        next3 = result22 | (next30 << shift13);
        i33 = i34;
    L79:
        int result23 = next3;
        int[] intArray3 = new int[(result23 + result19) + result21];
        objectsPosition = (result9 * 2) + result11;
        maxFieldNumber = result13;
        hasBitsCount = result15;
        numEntries = result17;
        mapFieldCount = result19;
        mapFieldCount2 = result23;
        intArray2 = intArray3;
        oneofCount = result9;
        i3 = i33;
        goto L80
    L5:
        r0 = false;
        goto L6
    }

    private static Field reflectField(Class<?> messageClass, String fieldName) {
        return messageClass.getDeclaredField(fieldName);
    L5:
        Field[] fields = messageClass.getDeclaredFields();
        int r2 = fields.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        Field field = fields[r3];
        if (fieldName.equals(field.getName()) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return field;
    L12:
        throw new RuntimeException("Field " + fieldName + " for " + messageClass.getName() + " not found. Known fields are " + Arrays.toString(fields));
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo.getSyntax() != ProtoSyntax.PROTO3) goto L5;
        boolean r0 = true;
    L6:
        boolean isProto3 = r0;
        FieldInfo[] fis = messageInfo.getFields();
        if (fis.length != 0) goto L9;
        int minFieldNumber = 0;
        int maxFieldNumber = 0;
    L10:
        int numEntries = fis.length;
        int[] buffer = new int[numEntries * 3];
        Object[] objects = new Object[numEntries * 2];
        int mapFieldCount = 0;
        int repeatedFieldCount = 0;
        int r9 = fis.length;
        int r11 = 0;
    L12:
        if (r11 >= r9) goto L22;
        FieldInfo fi = fis[r11];
        if (fi.getType() != FieldType.MAP) goto L17;
        mapFieldCount = mapFieldCount + 1;
    L21:
        r11 = r11 + 1;
        goto L12
    L17:
        if (fi.getType().id() < 18) goto L21;
        if (fi.getType().id() > 49) goto L21;
        repeatedFieldCount = repeatedFieldCount + 1;
        goto L21
    L22:
        int[] repeatedFieldOffsets = null;
        if (mapFieldCount <= 0) goto L25;
        int[] mapFieldPositions = new int[mapFieldCount];
    L26:
        if (repeatedFieldCount <= 0) goto L28;
        repeatedFieldOffsets = new int[repeatedFieldCount];
    L28:
        int mapFieldCount2 = 0;
        int[] checkInitialized = messageInfo.getCheckInitialized();
        if (checkInitialized != null) goto L31;
        checkInitialized = EMPTY_INT_ARRAY;
    L31:
        int repeatedFieldCount2 = 0;
        int checkInitializedIndex = 0;
        int checkInitializedIndex2 = 0;
        int fieldIndex = 0;
    L33:
        if (checkInitializedIndex2 >= fis.length) goto L49;
        FieldInfo fi2 = fis[checkInitializedIndex2];
        int fieldNumber = fi2.getFieldNumber();
        storeFieldData(fi2, buffer, fieldIndex, objects);
        FieldInfo[] fis2 = fis;
        if (checkInitializedIndex < checkInitialized.length) goto L37;
    L39:
        int numEntries2 = numEntries;
        if (fi2.getType() != FieldType.MAP) goto L43;
        mapFieldPositions[mapFieldCount2] = fieldIndex;
        mapFieldCount2 = mapFieldCount2 + 1;
        int[] repeatedFieldOffsets2 = repeatedFieldOffsets;
    L48:
        checkInitializedIndex2 = checkInitializedIndex2 + 1;
        fieldIndex = fieldIndex + 3;
        repeatedFieldOffsets = repeatedFieldOffsets2;
        fis = fis2;
        numEntries = numEntries2;
        goto L33
    L43:
        if (fi2.getType().id() >= 18) goto L45;
    L47:
        repeatedFieldOffsets2 = repeatedFieldOffsets;
        goto L48
    L45:
        if (fi2.getType().id() > 49) goto L47;
        repeatedFieldOffsets2 = repeatedFieldOffsets;
        repeatedFieldOffsets2[repeatedFieldCount2] = (int) UnsafeUtil.objectFieldOffset(fi2.getField());
        repeatedFieldCount2 = repeatedFieldCount2 + 1;
        goto L48
    L37:
        if (checkInitialized[checkInitializedIndex] != fieldNumber) goto L39;
        checkInitialized[checkInitializedIndex] = fieldIndex;
        checkInitializedIndex = checkInitializedIndex + 1;
        goto L39
    L49:
        int[] repeatedFieldOffsets3 = repeatedFieldOffsets;
        if (mapFieldPositions != null) goto L52;
        int[] mapFieldPositions2 = EMPTY_INT_ARRAY;
        int[] mapFieldPositions3 = mapFieldPositions2;
    L53:
        if (repeatedFieldOffsets3 != null) goto L55;
        int[] repeatedFieldOffsets4 = EMPTY_INT_ARRAY;
    L56:
        int[] combined = new int[(checkInitialized.length + mapFieldPositions3.length) + repeatedFieldOffsets4.length];
        System.arraycopy(checkInitialized, 0, combined, 0, checkInitialized.length);
        System.arraycopy(mapFieldPositions3, 0, combined, checkInitialized.length, mapFieldPositions3.length);
        System.arraycopy(repeatedFieldOffsets4, 0, combined, checkInitialized.length + mapFieldPositions3.length, repeatedFieldOffsets4.length);
        MessageLite r10 = messageInfo.getDefaultInstance();
        int r13 = checkInitialized.length;
        int r15 = checkInitialized.length;
        int checkInitializedIndex3 = mapFieldPositions3.length;
        int fieldIndex2 = r15 + checkInitializedIndex3;
        return new MessageSchema(buffer, objects, minFieldNumber, maxFieldNumber, r10, isProto3, true, combined, r13, fieldIndex2, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    L55:
        repeatedFieldOffsets4 = repeatedFieldOffsets3;
        goto L56
    L52:
        mapFieldPositions3 = mapFieldPositions;
        goto L53
    L25:
        mapFieldPositions = null;
        goto L26
    L9:
        int minFieldNumber2 = fis[0].getFieldNumber();
        minFieldNumber = minFieldNumber2;
        maxFieldNumber = fis[fis.length - 1].getFieldNumber();
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static void storeFieldData(FieldInfo fi, int[] buffer, int bufferIndex, Object[] objects) {
        OneofInfo oneof = fi.getOneof();
        if (oneof == null) goto L5;
        int typeId = fi.getType().id() + 51;
        int fieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        int typeId2 = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        int presenceFieldOffset = 0;
    L18:
        buffer[bufferIndex] = fi.getFieldNumber();
        int r5 = bufferIndex + 1;
        int r7 = 0;
        if (fi.isEnforceUtf8() == false) goto L21;
        int r6 = 536870912;
    L23:
        if (fi.isRequired() == false) goto L25;
        r7 = 268435456;
    L25:
        buffer[r5] = ((r6 | r7) | (typeId << 20)) | fieldOffset;
        buffer[bufferIndex + 2] = (presenceFieldOffset << 20) | typeId2;
        Object messageFieldClass = fi.getMessageFieldClass();
        if (fi.getMapDefaultEntry() == null) goto L33;
        objects[(bufferIndex / 3) * 2] = fi.getMapDefaultEntry();
        if (messageFieldClass == null) goto L31;
        objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
        return;
    L31:
        if (fi.getEnumVerifier() == null) goto L40;
        objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
        return;
    L40:
        return;
    L33:
        if (messageFieldClass == null) goto L36;
        objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
        return;
    L36:
        if (fi.getEnumVerifier() == null) goto L43;
        objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
        return;
    L43:
        return;
    L21:
        r6 = 0;
        goto L23
    L5:
        FieldType type = fi.getType();
        fieldOffset = (int) UnsafeUtil.objectFieldOffset(fi.getField());
        int typeId3 = type.id();
        if (type.isList() == true) goto L15;
        if (type.isMap() == true) goto L15;
        Field presenceField = fi.getPresenceField();
        if (presenceField != null) goto L12;
        int presenceFieldOffset2 = 1048575;
    L13:
        presenceFieldOffset = Integer.numberOfTrailingZeros(fi.getPresenceMask());
        typeId = typeId3;
        typeId2 = presenceFieldOffset2;
        goto L18
    L12:
        presenceFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(presenceField);
    L15:
        if (fi.getCachedSizeField() != null) goto L17;
        typeId = typeId3;
        typeId2 = 0;
        presenceFieldOffset = 0;
        goto L18
    L17:
        int presenceFieldOffset3 = (int) UnsafeUtil.objectFieldOffset(fi.getCachedSizeField());
        typeId = typeId3;
        typeId2 = presenceFieldOffset3;
        presenceFieldOffset = 0;
        goto L18
    }

    @Override // com.bytedance.location.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.bytedance.location.protobuf.Schema
    public boolean equals(T message, T other) {
        int bufferLength = this.buffer.length;
        int pos = 0;
    L4:
        if (pos >= bufferLength) goto L9;
        if (equals(message, other, pos) == false) goto L7;
        pos = pos + 3;
        goto L4
    L7:
        return false;
    L9:
        Object messageUnknown = this.unknownFieldSchema.getFromMessage(message);
        Object otherUnknown = this.unknownFieldSchema.getFromMessage(other);
        if (messageUnknown.equals(otherUnknown) == true) goto L13;
        return false;
    L13:
        if (this.hasExtensions == true) goto L15;
        return true;
    L15:
        return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
    }

    private boolean equals(T message, T other, int pos) {
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        switch(type(typeAndOffset)) {
            case 0: goto L136;
            case 1: goto L129;
            case 2: goto L122;
            case 3: goto L115;
            case 4: goto L108;
            case 5: goto L101;
            case 6: goto L94;
            case 7: goto L87;
            case 8: goto L80;
            case 9: goto L73;
            case 10: goto L66;
            case 11: goto L59;
            case 12: goto L52;
            case 13: goto L45;
            case 14: goto L38;
            case 15: goto L31;
            case 16: goto L24;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L15;
            case 23: goto L15;
            case 24: goto L15;
            case 25: goto L15;
            case 26: goto L15;
            case 27: goto L15;
            case 28: goto L15;
            case 29: goto L15;
            case 30: goto L15;
            case 31: goto L15;
            case 32: goto L15;
            case 33: goto L15;
            case 34: goto L15;
            case 35: goto L15;
            case 36: goto L15;
            case 37: goto L15;
            case 38: goto L15;
            case 39: goto L15;
            case 40: goto L15;
            case 41: goto L15;
            case 42: goto L15;
            case 43: goto L15;
            case 44: goto L15;
            case 45: goto L15;
            case 46: goto L15;
            case 47: goto L15;
            case 48: goto L15;
            case 49: goto L15;
            case 50: goto L13;
            case 51: goto L6;
            case 52: goto L6;
            case 53: goto L6;
            case 54: goto L6;
            case 55: goto L6;
            case 56: goto L6;
            case 57: goto L6;
            case 58: goto L6;
            case 59: goto L6;
            case 60: goto L6;
            case 61: goto L6;
            case 62: goto L6;
            case 63: goto L6;
            case 64: goto L6;
            case 65: goto L6;
            case 66: goto L6;
            case 67: goto L6;
            case 68: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        if (isOneofCaseEqual(message, other, pos) == true) goto L8;
        return false;
    L8:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset)) == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
    L15:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset));
    L17:
        if (arePresentForEquals(message, other, pos) == true) goto L19;
        return false;
    L19:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset)) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        if (arePresentForEquals(message, other, pos) == true) goto L26;
        return false;
    L26:
        if (UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset)) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (arePresentForEquals(message, other, pos) == true) goto L33;
        return false;
    L33:
        if (UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset)) goto L36;
        return false;
    L36:
        return true;
    L38:
        if (arePresentForEquals(message, other, pos) == true) goto L40;
        return false;
    L40:
        if (UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset)) goto L43;
        return false;
    L43:
        return true;
    L45:
        if (arePresentForEquals(message, other, pos) == true) goto L47;
        return false;
    L47:
        if (UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset)) goto L50;
        return false;
    L50:
        return true;
    L52:
        if (arePresentForEquals(message, other, pos) == true) goto L54;
        return false;
    L54:
        if (UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset)) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (arePresentForEquals(message, other, pos) == true) goto L61;
        return false;
    L61:
        if (UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset)) goto L64;
        return false;
    L64:
        return true;
    L66:
        if (arePresentForEquals(message, other, pos) == true) goto L68;
        return false;
    L68:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset)) == true) goto L71;
        return false;
    L71:
        return true;
    L73:
        if (arePresentForEquals(message, other, pos) == true) goto L75;
        return false;
    L75:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset)) == true) goto L78;
        return false;
    L78:
        return true;
    L80:
        if (arePresentForEquals(message, other, pos) == true) goto L82;
        return false;
    L82:
        if (SchemaUtil.safeEquals(UnsafeUtil.getObject(message, offset), UnsafeUtil.getObject(other, offset)) == true) goto L85;
        return false;
    L85:
        return true;
    L87:
        if (arePresentForEquals(message, other, pos) == true) goto L89;
        return false;
    L89:
        if (UnsafeUtil.getBoolean(message, offset) == UnsafeUtil.getBoolean(other, offset)) goto L92;
        return false;
    L92:
        return true;
    L94:
        if (arePresentForEquals(message, other, pos) == true) goto L96;
        return false;
    L96:
        if (UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset)) goto L99;
        return false;
    L99:
        return true;
    L101:
        if (arePresentForEquals(message, other, pos) == true) goto L103;
        return false;
    L103:
        if (UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset)) goto L106;
        return false;
    L106:
        return true;
    L108:
        if (arePresentForEquals(message, other, pos) == true) goto L110;
        return false;
    L110:
        if (UnsafeUtil.getInt(message, offset) == UnsafeUtil.getInt(other, offset)) goto L113;
        return false;
    L113:
        return true;
    L115:
        if (arePresentForEquals(message, other, pos) == true) goto L117;
        return false;
    L117:
        if (UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset)) goto L120;
        return false;
    L120:
        return true;
    L122:
        if (arePresentForEquals(message, other, pos) == true) goto L124;
        return false;
    L124:
        if (UnsafeUtil.getLong(message, offset) == UnsafeUtil.getLong(other, offset)) goto L127;
        return false;
    L127:
        return true;
    L129:
        if (arePresentForEquals(message, other, pos) == true) goto L131;
        return false;
    L131:
        if (Float.floatToIntBits(UnsafeUtil.getFloat(message, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(other, offset))) goto L134;
        return false;
    L134:
        return true;
    L136:
        if (arePresentForEquals(message, other, pos) == true) goto L138;
        return false;
    L138:
        if (Double.doubleToLongBits(UnsafeUtil.getDouble(message, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(other, offset))) goto L141;
        return false;
    L141:
        return true;
    }

    @Override // com.bytedance.location.protobuf.Schema
    public int hashCode(T message) {
        int hashCode = 0;
        int bufferLength = this.buffer.length;
        int pos = 0;
    L3:
        if (pos >= bufferLength) goto L88;
        int typeAndOffset = typeAndOffsetAt(pos);
        int entryNumber = numberAt(pos);
        long offset = offset(typeAndOffset);
        switch(type(typeAndOffset)) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L74;
            case 10: goto L73;
            case 11: goto L72;
            case 12: goto L71;
            case 13: goto L70;
            case 14: goto L69;
            case 15: goto L68;
            case 16: goto L67;
            case 17: goto L63;
            case 18: goto L62;
            case 19: goto L62;
            case 20: goto L62;
            case 21: goto L62;
            case 22: goto L62;
            case 23: goto L62;
            case 24: goto L62;
            case 25: goto L62;
            case 26: goto L62;
            case 27: goto L62;
            case 28: goto L62;
            case 29: goto L62;
            case 30: goto L62;
            case 31: goto L62;
            case 32: goto L62;
            case 33: goto L62;
            case 34: goto L62;
            case 35: goto L62;
            case 36: goto L62;
            case 37: goto L62;
            case 38: goto L62;
            case 39: goto L62;
            case 40: goto L62;
            case 41: goto L62;
            case 42: goto L62;
            case 43: goto L62;
            case 44: goto L62;
            case 45: goto L62;
            case 46: goto L62;
            case 47: goto L62;
            case 48: goto L62;
            case 49: goto L62;
            case 50: goto L61;
            case 51: goto L59;
            case 52: goto L56;
            case 53: goto L53;
            case 54: goto L50;
            case 55: goto L47;
            case 56: goto L44;
            case 57: goto L41;
            case 58: goto L38;
            case 59: goto L35;
            case 60: goto L32;
            case 61: goto L29;
            case 62: goto L26;
            case 63: goto L23;
            case 64: goto L20;
            case 65: goto L17;
            case 66: goto L14;
            case 67: goto L11;
            case 68: goto L8;
            default: goto L87;
        };
    L61:
        hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
        goto L87
    L62:
        hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
        goto L87
    L63:
        int protoHash = 37;
        Object submessage = UnsafeUtil.getObject(message, offset);
        if (submessage == null) goto L66;
        protoHash = submessage.hashCode();
    L66:
        int hashCode2 = (hashCode * 53) + protoHash;
        hashCode = hashCode2;
        goto L87
    L67:
        int protoHash2 = hashCode * 53;
        int hashCode3 = protoHash2 + Internal.hashLong(UnsafeUtil.getLong(message, offset));
        hashCode = hashCode3;
        goto L87
    L68:
        hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
        goto L87
    L69:
        hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
        goto L87
    L70:
        hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
        goto L87
    L71:
        hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
        goto L87
    L72:
        hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
        goto L87
    L73:
        hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
        goto L87
    L74:
        int protoHash3 = 37;
        Object submessage2 = UnsafeUtil.getObject(message, offset);
        if (submessage2 == null) goto L77;
        protoHash3 = submessage2.hashCode();
    L77:
        int hashCode4 = (hashCode * 53) + protoHash3;
        hashCode = hashCode4;
        goto L87
    L78:
        int protoHash4 = hashCode * 53;
        int hashCode5 = protoHash4 + ((String) UnsafeUtil.getObject(message, offset)).hashCode();
        hashCode = hashCode5;
        goto L87
    L79:
        hashCode = (hashCode * 53) + Internal.hashBoolean(UnsafeUtil.getBoolean(message, offset));
        goto L87
    L80:
        hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
        goto L87
    L81:
        hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
        goto L87
    L82:
        hashCode = (hashCode * 53) + UnsafeUtil.getInt(message, offset);
        goto L87
    L83:
        hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
        goto L87
    L84:
        hashCode = (hashCode * 53) + Internal.hashLong(UnsafeUtil.getLong(message, offset));
        goto L87
    L85:
        hashCode = (hashCode * 53) + Float.floatToIntBits(UnsafeUtil.getFloat(message, offset));
        goto L87
    L86:
        hashCode = (hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(message, offset)));
        goto L87
    L8:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        int hashCode6 = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
        hashCode = hashCode6;
        goto L87
    L11:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
        goto L87
    L14:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
        goto L87
    L17:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
        goto L87
    L20:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
        goto L87
    L23:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
        goto L87
    L26:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
        goto L87
    L29:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
        goto L87
    L32:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        int hashCode7 = (hashCode * 53) + UnsafeUtil.getObject(message, offset).hashCode();
        hashCode = hashCode7;
        goto L87
    L35:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + ((String) UnsafeUtil.getObject(message, offset)).hashCode();
        goto L87
    L38:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashBoolean(oneofBooleanAt(message, offset));
        goto L87
    L41:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
        goto L87
    L44:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
        goto L87
    L47:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + oneofIntAt(message, offset);
        goto L87
    L50:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
        goto L87
    L53:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashLong(oneofLongAt(message, offset));
        goto L87
    L56:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Float.floatToIntBits(oneofFloatAt(message, offset));
        goto L87
    L59:
        if (isOneofPresent(message, entryNumber, pos) == false) goto L87;
        hashCode = (hashCode * 53) + Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(message, offset)));
    L87:
        pos = pos + 3;
        goto L3
    L88:
        int pos2 = hashCode * 53;
        int hashCode8 = pos2 + this.unknownFieldSchema.getFromMessage(message).hashCode();
        if (this.hasExtensions == true) goto L91;
        return hashCode8;
    L91:
        return (hashCode8 * 53) + this.extensionSchema.getExtensions(message).hashCode();
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void mergeFrom(T message, T other) {
        checkMutable(message);
        if (other == null) goto L13;
        int i = 0;
    L6:
        if (i >= this.buffer.length) goto L8;
        mergeSingleField(message, other, i);
        i = i + 3;
        goto L6
    L8:
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions == false) goto L15;
        SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        return;
    L15:
        return;
    L13:
        throw new NullPointerException();
    }

    private void mergeSingleField(T message, T other, int pos) {
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        int number = numberAt(pos);
        switch(type(typeAndOffset)) {
            case 0: goto L63;
            case 1: goto L60;
            case 2: goto L57;
            case 3: goto L54;
            case 4: goto L51;
            case 5: goto L48;
            case 6: goto L45;
            case 7: goto L42;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L35;
            case 11: goto L32;
            case 12: goto L29;
            case 13: goto L26;
            case 14: goto L23;
            case 15: goto L20;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L14;
            case 20: goto L14;
            case 21: goto L14;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            case 26: goto L14;
            case 27: goto L14;
            case 28: goto L14;
            case 29: goto L14;
            case 30: goto L14;
            case 31: goto L14;
            case 32: goto L14;
            case 33: goto L14;
            case 34: goto L14;
            case 35: goto L14;
            case 36: goto L14;
            case 37: goto L14;
            case 38: goto L14;
            case 39: goto L14;
            case 40: goto L14;
            case 41: goto L14;
            case 42: goto L14;
            case 43: goto L14;
            case 44: goto L14;
            case 45: goto L14;
            case 46: goto L14;
            case 47: goto L14;
            case 48: goto L14;
            case 49: goto L14;
            case 50: goto L13;
            case 51: goto L11;
            case 52: goto L11;
            case 53: goto L11;
            case 54: goto L11;
            case 55: goto L11;
            case 56: goto L11;
            case 57: goto L11;
            case 58: goto L11;
            case 59: goto L11;
            case 60: goto L9;
            case 61: goto L7;
            case 62: goto L7;
            case 63: goto L7;
            case 64: goto L7;
            case 65: goto L7;
            case 66: goto L7;
            case 67: goto L7;
            case 68: goto L5;
            default: goto L107;
        };
    L5:
        mergeOneofMessage(message, other, pos);
        return;
    L9:
        mergeOneofMessage(message, other, pos);
        return;
    L13:
        SchemaUtil.mergeMap(this.mapFieldSchema, message, other, offset);
        return;
    L14:
        this.listFieldSchema.mergeListsAt(message, other, offset);
        return;
    L15:
        mergeMessage(message, other, pos);
        return;
    L37:
        mergeMessage(message, other, pos);
        return;
    L107:
        return;
    L7:
        if (isOneofPresent(other, number, pos) == false) goto L67;
        UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
        setOneofPresent(message, number, pos);
        return;
    L67:
        return;
    L11:
        if (isOneofPresent(other, number, pos) == false) goto L70;
        UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
        setOneofPresent(message, number, pos);
        return;
    L70:
        return;
    L17:
        if (isFieldPresent(other, pos) == false) goto L75;
        UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
        setFieldPresent(message, pos);
        return;
    L75:
        return;
    L20:
        if (isFieldPresent(other, pos) == false) goto L77;
        UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
        setFieldPresent(message, pos);
        return;
    L77:
        return;
    L23:
        if (isFieldPresent(other, pos) == false) goto L79;
        UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
        setFieldPresent(message, pos);
        return;
    L79:
        return;
    L26:
        if (isFieldPresent(other, pos) == false) goto L81;
        UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
        setFieldPresent(message, pos);
        return;
    L81:
        return;
    L29:
        if (isFieldPresent(other, pos) == false) goto L83;
        UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
        setFieldPresent(message, pos);
        return;
    L83:
        return;
    L32:
        if (isFieldPresent(other, pos) == false) goto L85;
        UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
        setFieldPresent(message, pos);
        return;
    L85:
        return;
    L35:
        if (isFieldPresent(other, pos) == false) goto L87;
        UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
        setFieldPresent(message, pos);
        return;
    L87:
        return;
    L39:
        if (isFieldPresent(other, pos) == false) goto L90;
        UnsafeUtil.putObject(message, offset, UnsafeUtil.getObject(other, offset));
        setFieldPresent(message, pos);
        return;
    L90:
        return;
    L42:
        if (isFieldPresent(other, pos) == false) goto L92;
        UnsafeUtil.putBoolean(message, offset, UnsafeUtil.getBoolean(other, offset));
        setFieldPresent(message, pos);
        return;
    L92:
        return;
    L45:
        if (isFieldPresent(other, pos) == false) goto L94;
        UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
        setFieldPresent(message, pos);
        return;
    L94:
        return;
    L48:
        if (isFieldPresent(other, pos) == false) goto L96;
        UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
        setFieldPresent(message, pos);
        return;
    L96:
        return;
    L51:
        if (isFieldPresent(other, pos) == false) goto L98;
        UnsafeUtil.putInt(message, offset, UnsafeUtil.getInt(other, offset));
        setFieldPresent(message, pos);
        return;
    L98:
        return;
    L54:
        if (isFieldPresent(other, pos) == false) goto L100;
        UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
        setFieldPresent(message, pos);
        return;
    L100:
        return;
    L57:
        if (isFieldPresent(other, pos) == false) goto L102;
        UnsafeUtil.putLong(message, offset, UnsafeUtil.getLong(other, offset));
        setFieldPresent(message, pos);
        return;
    L102:
        return;
    L60:
        if (isFieldPresent(other, pos) == false) goto L104;
        UnsafeUtil.putFloat(message, offset, UnsafeUtil.getFloat(other, offset));
        setFieldPresent(message, pos);
        return;
    L104:
        return;
    L63:
        if (isFieldPresent(other, pos) == false) goto L106;
        UnsafeUtil.putDouble(message, offset, UnsafeUtil.getDouble(other, offset));
        setFieldPresent(message, pos);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T targetParent, T sourceParent, int pos) {
        if (isFieldPresent(sourceParent, pos) == true) goto L5;
        return;
    L5:
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        Object source = UNSAFE.getObject(sourceParent, offset);
        if (source == null) goto L21;
        Schema r4 = getMessageFieldSchema(pos);
        if (isFieldPresent(targetParent, pos) == false) goto L10;
        Object target = UNSAFE.getObject(targetParent, offset);
        if (isMutable(target) == true) goto L18;
        Object newInstance = r4.newInstance();
        r4.mergeFrom(newInstance, target);
        UNSAFE.putObject(targetParent, offset, newInstance);
        target = newInstance;
    L18:
        r4.mergeFrom(target, source);
        return;
    L10:
        if (isMutable(source) == true) goto L12;
        UNSAFE.putObject(targetParent, offset, source);
    L13:
        setFieldPresent(targetParent, pos);
        return;
    L12:
        Object copyOfSource = r4.newInstance();
        r4.mergeFrom(copyOfSource, source);
        UNSAFE.putObject(targetParent, offset, copyOfSource);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T targetParent, T sourceParent, int pos) {
        int number = numberAt(pos);
        if (isOneofPresent(sourceParent, number, pos) == true) goto L5;
        return;
    L5:
        long offset = offset(typeAndOffsetAt(pos));
        Object source = UNSAFE.getObject(sourceParent, offset);
        if (source == null) goto L21;
        Schema r4 = getMessageFieldSchema(pos);
        if (isOneofPresent(targetParent, number, pos) == false) goto L10;
        Object target = UNSAFE.getObject(targetParent, offset);
        if (isMutable(target) == true) goto L18;
        Object newInstance = r4.newInstance();
        r4.mergeFrom(newInstance, target);
        UNSAFE.putObject(targetParent, offset, newInstance);
        target = newInstance;
    L18:
        r4.mergeFrom(target, source);
        return;
    L10:
        if (isMutable(source) == true) goto L12;
        UNSAFE.putObject(targetParent, offset, source);
    L13:
        setOneofPresent(targetParent, number, pos);
        return;
    L12:
        Object copyOfSource = r4.newInstance();
        r4.mergeFrom(copyOfSource, source);
        UNSAFE.putObject(targetParent, offset, copyOfSource);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
    }

    @Override // com.bytedance.location.protobuf.Schema
    public int getSerializedSize(T message) {
        if (this.proto3 == false) goto L6;
        return getSerializedSizeProto3(message);
    L6:
        return getSerializedSizeProto2(message);
    }

    private int getSerializedSizeProto2(T message) {
        int size = 0;
        Unsafe unsafe = UNSAFE;
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceField = 0;
        int i = 0;
    L4:
        if (i >= this.buffer.length) goto L260;
        int typeAndOffset = typeAndOffsetAt(i);
        int number = numberAt(i);
        int fieldType = type(typeAndOffset);
        int presenceMaskAndOffset = 0;
        int presenceMask = 0;
        if (fieldType > 17) goto L12;
        presenceMaskAndOffset = this.buffer[i + 2];
        int presenceFieldOffset = presenceMaskAndOffset & 1048575;
        presenceMask = 1 << (presenceMaskAndOffset >>> 20);
        if (presenceFieldOffset == currentPresenceFieldOffset) goto L18;
        currentPresenceFieldOffset = presenceFieldOffset;
        currentPresenceField = unsafe.getInt(message, presenceFieldOffset);
    L18:
        long offset = offset(typeAndOffset);
        switch(fieldType) {
            case 0: goto L255;
            case 1: goto L252;
            case 2: goto L249;
            case 3: goto L246;
            case 4: goto L243;
            case 5: goto L240;
            case 6: goto L237;
            case 7: goto L234;
            case 8: goto L227;
            case 9: goto L224;
            case 10: goto L221;
            case 11: goto L218;
            case 12: goto L215;
            case 13: goto L212;
            case 14: goto L209;
            case 15: goto L206;
            case 16: goto L203;
            case 17: goto L200;
            case 18: goto L199;
            case 19: goto L198;
            case 20: goto L197;
            case 21: goto L196;
            case 22: goto L195;
            case 23: goto L194;
            case 24: goto L193;
            case 25: goto L192;
            case 26: goto L191;
            case 27: goto L190;
            case 28: goto L189;
            case 29: goto L188;
            case 30: goto L187;
            case 31: goto L186;
            case 32: goto L185;
            case 33: goto L184;
            case 34: goto L183;
            case 35: goto L177;
            case 36: goto L171;
            case 37: goto L165;
            case 38: goto L159;
            case 39: goto L153;
            case 40: goto L147;
            case 41: goto L141;
            case 42: goto L135;
            case 43: goto L129;
            case 44: goto L123;
            case 45: goto L117;
            case 46: goto L111;
            case 47: goto L105;
            case 48: goto L99;
            case 49: goto L98;
            case 50: goto L97;
            case 51: goto L94;
            case 52: goto L90;
            case 53: goto L86;
            case 54: goto L82;
            case 55: goto L78;
            case 56: goto L74;
            case 57: goto L70;
            case 58: goto L66;
            case 59: goto L58;
            case 60: goto L54;
            case 61: goto L50;
            case 62: goto L46;
            case 63: goto L42;
            case 64: goto L38;
            case 65: goto L34;
            case 66: goto L30;
            case 67: goto L26;
            case 68: goto L22;
            default: goto L20;
        };
    L20:
        int size2 = size;
    L258:
        size = size2;
    L259:
        i = i + 3;
        goto L4
    L97:
        size = size + this.mapFieldSchema.getSerializedSize(number, unsafe.getObject(message, offset), getMapFieldDefaultEntry(i));
        goto L259
    L98:
        size = size + SchemaUtil.computeSizeGroupList(number, (List) unsafe.getObject(message, offset), getMessageFieldSchema(i));
        goto L259
    L99:
        size2 = size;
        int fieldSize = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L104;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize);
    L104:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize)) + fieldSize);
        goto L259
    L105:
        size2 = size;
        int fieldSize2 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize2 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L110;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize2);
    L110:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize2)) + fieldSize2);
        goto L259
    L111:
        size2 = size;
        int fieldSize3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize3 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L116;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize3);
    L116:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize3)) + fieldSize3);
        goto L259
    L117:
        size2 = size;
        int fieldSize4 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize4 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L122;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize4);
    L122:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize4)) + fieldSize4);
        goto L259
    L123:
        size2 = size;
        int fieldSize5 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize5 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L128;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize5);
    L128:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize5)) + fieldSize5);
        goto L259
    L129:
        size2 = size;
        int fieldSize6 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize6 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L134;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize6);
    L134:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize6)) + fieldSize6);
        goto L259
    L135:
        size2 = size;
        int fieldSize7 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize7 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L140;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize7);
    L140:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize7)) + fieldSize7);
        goto L259
    L141:
        size2 = size;
        int fieldSize8 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize8 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L146;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize8);
    L146:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize8)) + fieldSize8);
        goto L259
    L147:
        size2 = size;
        int fieldSize9 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize9 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L152;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize9);
    L152:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize9)) + fieldSize9);
        goto L259
    L153:
        size2 = size;
        int fieldSize10 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize10 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L158;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize10);
    L158:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize10)) + fieldSize10);
        goto L259
    L159:
        size2 = size;
        int fieldSize11 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize11 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L164;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize11);
    L164:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize11)) + fieldSize11);
        goto L259
    L165:
        size2 = size;
        int fieldSize12 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize12 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L170;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize12);
    L170:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize12)) + fieldSize12);
        goto L259
    L171:
        size2 = size;
        int fieldSize13 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize13 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L176;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize13);
    L176:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize13)) + fieldSize13);
        goto L259
    L177:
        size2 = size;
        int fieldSize14 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize14 <= 0) goto L258;
        if (this.useCachedSizeField == false) goto L182;
        unsafe.putInt(message, presenceMaskAndOffset, fieldSize14);
    L182:
        size = size2 + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize14)) + fieldSize14);
        goto L259
    L183:
        size = size + SchemaUtil.computeSizeSInt64List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L184:
        size = size + SchemaUtil.computeSizeSInt32List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L185:
        size = size + SchemaUtil.computeSizeFixed64List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L186:
        size = size + SchemaUtil.computeSizeFixed32List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L187:
        size = size + SchemaUtil.computeSizeEnumList(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L188:
        size = size + SchemaUtil.computeSizeUInt32List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L189:
        size = size + SchemaUtil.computeSizeByteStringList(number, (List) unsafe.getObject(message, offset));
        goto L259
    L190:
        size = size + SchemaUtil.computeSizeMessageList(number, (List) unsafe.getObject(message, offset), getMessageFieldSchema(i));
        goto L259
    L191:
        size = size + SchemaUtil.computeSizeStringList(number, (List) unsafe.getObject(message, offset));
        goto L259
    L192:
        size = size + SchemaUtil.computeSizeBoolList(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L193:
        size = size + SchemaUtil.computeSizeFixed32List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L194:
        size = size + SchemaUtil.computeSizeFixed64List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L195:
        size = size + SchemaUtil.computeSizeInt32List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L196:
        size = size + SchemaUtil.computeSizeUInt64List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L197:
        size = size + SchemaUtil.computeSizeInt64List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L198:
        size = size + SchemaUtil.computeSizeFixed32List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L199:
        size = size + SchemaUtil.computeSizeFixed64List(number, (List) unsafe.getObject(message, offset), false);
        goto L259
    L200:
        size2 = size;
        int size3 = currentPresenceField & presenceMask;
        if (size3 == 0) goto L258;
        size = size2 + CodedOutputStream.computeGroupSize(number, (MessageLite) unsafe.getObject(message, offset), getMessageFieldSchema(i));
        goto L259
    L203:
        size2 = size;
        int size4 = currentPresenceField & presenceMask;
        if (size4 == 0) goto L258;
        size = size2 + CodedOutputStream.computeSInt64Size(number, unsafe.getLong(message, offset));
        goto L259
    L206:
        size2 = size;
        int size5 = currentPresenceField & presenceMask;
        if (size5 == 0) goto L258;
        size = size2 + CodedOutputStream.computeSInt32Size(number, unsafe.getInt(message, offset));
        goto L259
    L209:
        size2 = size;
        int size6 = currentPresenceField & presenceMask;
        if (size6 == 0) goto L258;
        size = size2 + CodedOutputStream.computeSFixed64Size(number, 0);
        goto L259
    L212:
        size2 = size;
        int size7 = currentPresenceField & presenceMask;
        if (size7 == 0) goto L258;
        size = size2 + CodedOutputStream.computeSFixed32Size(number, 0);
        goto L259
    L215:
        size2 = size;
        int size8 = currentPresenceField & presenceMask;
        if (size8 == 0) goto L258;
        size = size2 + CodedOutputStream.computeEnumSize(number, unsafe.getInt(message, offset));
        goto L259
    L218:
        size2 = size;
        int size9 = currentPresenceField & presenceMask;
        if (size9 == 0) goto L258;
        size = size2 + CodedOutputStream.computeUInt32Size(number, unsafe.getInt(message, offset));
        goto L259
    L221:
        size2 = size;
        int size10 = currentPresenceField & presenceMask;
        if (size10 == 0) goto L258;
        size = size2 + CodedOutputStream.computeBytesSize(number, (ByteString) unsafe.getObject(message, offset));
        goto L259
    L224:
        size2 = size;
        int size11 = currentPresenceField & presenceMask;
        if (size11 == 0) goto L258;
        size = size2 + SchemaUtil.computeSizeMessage(number, unsafe.getObject(message, offset), getMessageFieldSchema(i));
        goto L259
    L227:
        size2 = size;
        int size12 = currentPresenceField & presenceMask;
        if (size12 == 0) goto L258;
        Object value = unsafe.getObject(message, offset);
        if ((value instanceof ByteString) == false) goto L232;
        int size13 = size2 + CodedOutputStream.computeBytesSize(number, (ByteString) value);
    L233:
        size = size13;
        goto L259
    L232:
        size13 = size2 + CodedOutputStream.computeStringSize(number, (String) value);
        goto L233
    L234:
        size2 = size;
        int size14 = currentPresenceField & presenceMask;
        if (size14 == 0) goto L258;
        size = size2 + CodedOutputStream.computeBoolSize(number, true);
        goto L259
    L237:
        size2 = size;
        int size15 = currentPresenceField & presenceMask;
        if (size15 == 0) goto L258;
        size = size2 + CodedOutputStream.computeFixed32Size(number, 0);
        goto L259
    L240:
        size2 = size;
        int size16 = currentPresenceField & presenceMask;
        if (size16 == 0) goto L258;
        size = size2 + CodedOutputStream.computeFixed64Size(number, 0);
        goto L259
    L243:
        size2 = size;
        int size17 = currentPresenceField & presenceMask;
        if (size17 == 0) goto L258;
        size = size2 + CodedOutputStream.computeInt32Size(number, unsafe.getInt(message, offset));
        goto L259
    L246:
        size2 = size;
        int size18 = currentPresenceField & presenceMask;
        if (size18 == 0) goto L258;
        size = size2 + CodedOutputStream.computeUInt64Size(number, unsafe.getLong(message, offset));
        goto L259
    L249:
        size2 = size;
        int size19 = currentPresenceField & presenceMask;
        if (size19 == 0) goto L258;
        size = size2 + CodedOutputStream.computeInt64Size(number, unsafe.getLong(message, offset));
        goto L259
    L252:
        size2 = size;
        int size20 = currentPresenceField & presenceMask;
        if (size20 == 0) goto L258;
        size = size2 + CodedOutputStream.computeFloatSize(number, 0.0f);
        goto L259
    L255:
        size2 = size;
        int size21 = currentPresenceField & presenceMask;
        if (size21 == 0) goto L258;
        size = size2 + CodedOutputStream.computeDoubleSize(number, 0.0d);
        goto L259
    L22:
        if (isOneofPresent(message, number, i) == false) goto L24;
        size = size + CodedOutputStream.computeGroupSize(number, (MessageLite) unsafe.getObject(message, offset), getMessageFieldSchema(i));
        goto L259
    L24:
        size2 = size;
        goto L258
    L26:
        if (isOneofPresent(message, number, i) == false) goto L28;
        size = size + CodedOutputStream.computeSInt64Size(number, oneofLongAt(message, offset));
        goto L259
    L28:
        size2 = size;
        goto L258
    L30:
        if (isOneofPresent(message, number, i) == false) goto L32;
        size = size + CodedOutputStream.computeSInt32Size(number, oneofIntAt(message, offset));
        goto L259
    L32:
        size2 = size;
        goto L258
    L34:
        if (isOneofPresent(message, number, i) == false) goto L36;
        size = size + CodedOutputStream.computeSFixed64Size(number, 0);
        goto L259
    L36:
        size2 = size;
        goto L258
    L38:
        if (isOneofPresent(message, number, i) == false) goto L40;
        size = size + CodedOutputStream.computeSFixed32Size(number, 0);
        goto L259
    L40:
        size2 = size;
        goto L258
    L42:
        if (isOneofPresent(message, number, i) == false) goto L44;
        size = size + CodedOutputStream.computeEnumSize(number, oneofIntAt(message, offset));
        goto L259
    L44:
        size2 = size;
        goto L258
    L46:
        if (isOneofPresent(message, number, i) == false) goto L48;
        size = size + CodedOutputStream.computeUInt32Size(number, oneofIntAt(message, offset));
        goto L259
    L48:
        size2 = size;
        goto L258
    L50:
        if (isOneofPresent(message, number, i) == false) goto L52;
        size = size + CodedOutputStream.computeBytesSize(number, (ByteString) unsafe.getObject(message, offset));
        goto L259
    L52:
        size2 = size;
        goto L258
    L54:
        if (isOneofPresent(message, number, i) == false) goto L56;
        size = size + SchemaUtil.computeSizeMessage(number, unsafe.getObject(message, offset), getMessageFieldSchema(i));
        goto L259
    L56:
        size2 = size;
        goto L258
    L58:
        if (isOneofPresent(message, number, i) == false) goto L64;
        Object value2 = unsafe.getObject(message, offset);
        if ((value2 instanceof ByteString) == false) goto L62;
        size = size + CodedOutputStream.computeBytesSize(number, (ByteString) value2);
        goto L259
    L62:
        size = size + CodedOutputStream.computeStringSize(number, (String) value2);
        goto L259
    L64:
        size2 = size;
        goto L258
    L66:
        if (isOneofPresent(message, number, i) == false) goto L68;
        size = size + CodedOutputStream.computeBoolSize(number, true);
        goto L259
    L68:
        size2 = size;
        goto L258
    L70:
        if (isOneofPresent(message, number, i) == false) goto L72;
        size = size + CodedOutputStream.computeFixed32Size(number, 0);
        goto L259
    L72:
        size2 = size;
        goto L258
    L74:
        if (isOneofPresent(message, number, i) == false) goto L76;
        size = size + CodedOutputStream.computeFixed64Size(number, 0);
        goto L259
    L76:
        size2 = size;
        goto L258
    L78:
        if (isOneofPresent(message, number, i) == false) goto L80;
        size = size + CodedOutputStream.computeInt32Size(number, oneofIntAt(message, offset));
        goto L259
    L80:
        size2 = size;
        goto L258
    L82:
        if (isOneofPresent(message, number, i) == false) goto L84;
        size = size + CodedOutputStream.computeUInt64Size(number, oneofLongAt(message, offset));
        goto L259
    L84:
        size2 = size;
        goto L258
    L86:
        if (isOneofPresent(message, number, i) == false) goto L88;
        size = size + CodedOutputStream.computeInt64Size(number, oneofLongAt(message, offset));
        goto L259
    L88:
        size2 = size;
        goto L258
    L90:
        if (isOneofPresent(message, number, i) == false) goto L92;
        size = size + CodedOutputStream.computeFloatSize(number, 0.0f);
        goto L259
    L92:
        size2 = size;
        goto L258
    L94:
        if (isOneofPresent(message, number, i) == false) goto L96;
        size = size + CodedOutputStream.computeDoubleSize(number, 0.0d);
        goto L259
    L96:
        size2 = size;
        goto L258
    L12:
        if (this.useCachedSizeField == false) goto L18;
        if (fieldType < FieldType.DOUBLE_LIST_PACKED.id()) goto L18;
        if (fieldType > FieldType.SINT64_LIST_PACKED.id()) goto L18;
        presenceMaskAndOffset = this.buffer[i + 2] & 1048575;
        goto L18
    L260:
        int size22 = size + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        if (this.hasExtensions == true) goto L263;
        return size22;
    L263:
        return size22 + this.extensionSchema.getExtensions(message).getSerializedSize();
    }

    private int getSerializedSizeProto3(T message) {
        Unsafe unsafe = UNSAFE;
        int size = 0;
        int i = 0;
    L4:
        if (i >= this.buffer.length) goto L235;
        int typeAndOffset = typeAndOffsetAt(i);
        int fieldType = type(typeAndOffset);
        int number = numberAt(i);
        long offset = offset(typeAndOffset);
        if (fieldType >= FieldType.DOUBLE_LIST_PACKED.id()) goto L8;
    L10:
        int cachedSizeOffset = 0;
    L12:
        switch(fieldType) {
            case 0: goto L231;
            case 1: goto L228;
            case 2: goto L225;
            case 3: goto L222;
            case 4: goto L219;
            case 5: goto L216;
            case 6: goto L213;
            case 7: goto L210;
            case 8: goto L203;
            case 9: goto L200;
            case 10: goto L197;
            case 11: goto L194;
            case 12: goto L191;
            case 13: goto L188;
            case 14: goto L185;
            case 15: goto L182;
            case 16: goto L179;
            case 17: goto L176;
            case 18: goto L174;
            case 19: goto L173;
            case 20: goto L172;
            case 21: goto L171;
            case 22: goto L170;
            case 23: goto L169;
            case 24: goto L168;
            case 25: goto L167;
            case 26: goto L166;
            case 27: goto L165;
            case 28: goto L164;
            case 29: goto L163;
            case 30: goto L162;
            case 31: goto L161;
            case 32: goto L160;
            case 33: goto L159;
            case 34: goto L158;
            case 35: goto L152;
            case 36: goto L146;
            case 37: goto L140;
            case 38: goto L134;
            case 39: goto L128;
            case 40: goto L122;
            case 41: goto L116;
            case 42: goto L110;
            case 43: goto L104;
            case 44: goto L98;
            case 45: goto L92;
            case 46: goto L86;
            case 47: goto L80;
            case 48: goto L74;
            case 49: goto L73;
            case 50: goto L72;
            case 51: goto L70;
            case 52: goto L67;
            case 53: goto L64;
            case 54: goto L61;
            case 55: goto L58;
            case 56: goto L55;
            case 57: goto L52;
            case 58: goto L49;
            case 59: goto L42;
            case 60: goto L39;
            case 61: goto L36;
            case 62: goto L33;
            case 63: goto L30;
            case 64: goto L27;
            case 65: goto L24;
            case 66: goto L21;
            case 67: goto L18;
            case 68: goto L15;
            default: goto L233;
        };
    L72:
        size = size + this.mapFieldSchema.getSerializedSize(number, UnsafeUtil.getObject(message, offset), getMapFieldDefaultEntry(i));
        goto L233
    L73:
        size = size + SchemaUtil.computeSizeGroupList(number, listAt(message, offset), getMessageFieldSchema(i));
        goto L233
    L74:
        int fieldSize = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L79;
        unsafe.putInt(message, cachedSizeOffset, fieldSize);
    L79:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize)) + fieldSize);
        goto L233
    L80:
        int fieldSize2 = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize2 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L85;
        unsafe.putInt(message, cachedSizeOffset, fieldSize2);
    L85:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize2)) + fieldSize2);
        goto L233
    L86:
        int fieldSize3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize3 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L91;
        unsafe.putInt(message, cachedSizeOffset, fieldSize3);
    L91:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize3)) + fieldSize3);
        goto L233
    L92:
        int fieldSize4 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize4 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L97;
        unsafe.putInt(message, cachedSizeOffset, fieldSize4);
    L97:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize4)) + fieldSize4);
        goto L233
    L98:
        int fieldSize5 = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize5 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L103;
        unsafe.putInt(message, cachedSizeOffset, fieldSize5);
    L103:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize5)) + fieldSize5);
        goto L233
    L104:
        int fieldSize6 = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize6 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L109;
        unsafe.putInt(message, cachedSizeOffset, fieldSize6);
    L109:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize6)) + fieldSize6);
        goto L233
    L110:
        int fieldSize7 = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize7 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L115;
        unsafe.putInt(message, cachedSizeOffset, fieldSize7);
    L115:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize7)) + fieldSize7);
        goto L233
    L116:
        int fieldSize8 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize8 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L121;
        unsafe.putInt(message, cachedSizeOffset, fieldSize8);
    L121:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize8)) + fieldSize8);
        goto L233
    L122:
        int fieldSize9 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize9 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L127;
        unsafe.putInt(message, cachedSizeOffset, fieldSize9);
    L127:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize9)) + fieldSize9);
        goto L233
    L128:
        int fieldSize10 = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize10 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L133;
        unsafe.putInt(message, cachedSizeOffset, fieldSize10);
    L133:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize10)) + fieldSize10);
        goto L233
    L134:
        int fieldSize11 = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize11 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L139;
        unsafe.putInt(message, cachedSizeOffset, fieldSize11);
    L139:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize11)) + fieldSize11);
        goto L233
    L140:
        int fieldSize12 = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize12 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L145;
        unsafe.putInt(message, cachedSizeOffset, fieldSize12);
    L145:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize12)) + fieldSize12);
        goto L233
    L146:
        int fieldSize13 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize13 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L151;
        unsafe.putInt(message, cachedSizeOffset, fieldSize13);
    L151:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize13)) + fieldSize13);
        goto L233
    L152:
        int fieldSize14 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, offset));
        if (fieldSize14 <= 0) goto L233;
        if (this.useCachedSizeField == false) goto L157;
        unsafe.putInt(message, cachedSizeOffset, fieldSize14);
    L157:
        size = size + ((CodedOutputStream.computeTagSize(number) + CodedOutputStream.computeUInt32SizeNoTag(fieldSize14)) + fieldSize14);
        goto L233
    L158:
        size = size + SchemaUtil.computeSizeSInt64List(number, listAt(message, offset), false);
        goto L233
    L159:
        size = size + SchemaUtil.computeSizeSInt32List(number, listAt(message, offset), false);
        goto L233
    L160:
        size = size + SchemaUtil.computeSizeFixed64List(number, listAt(message, offset), false);
        goto L233
    L161:
        size = size + SchemaUtil.computeSizeFixed32List(number, listAt(message, offset), false);
        goto L233
    L162:
        size = size + SchemaUtil.computeSizeEnumList(number, listAt(message, offset), false);
        goto L233
    L163:
        size = size + SchemaUtil.computeSizeUInt32List(number, listAt(message, offset), false);
        goto L233
    L164:
        size = size + SchemaUtil.computeSizeByteStringList(number, listAt(message, offset));
        goto L233
    L165:
        size = size + SchemaUtil.computeSizeMessageList(number, listAt(message, offset), getMessageFieldSchema(i));
        goto L233
    L166:
        size = size + SchemaUtil.computeSizeStringList(number, listAt(message, offset));
        goto L233
    L167:
        size = size + SchemaUtil.computeSizeBoolList(number, listAt(message, offset), false);
        goto L233
    L168:
        size = size + SchemaUtil.computeSizeFixed32List(number, listAt(message, offset), false);
        goto L233
    L169:
        size = size + SchemaUtil.computeSizeFixed64List(number, listAt(message, offset), false);
        goto L233
    L170:
        size = size + SchemaUtil.computeSizeInt32List(number, listAt(message, offset), false);
        goto L233
    L171:
        size = size + SchemaUtil.computeSizeUInt64List(number, listAt(message, offset), false);
        goto L233
    L172:
        size = size + SchemaUtil.computeSizeInt64List(number, listAt(message, offset), false);
        goto L233
    L173:
        size = size + SchemaUtil.computeSizeFixed32List(number, listAt(message, offset), false);
        goto L233
    L174:
        size = size + SchemaUtil.computeSizeFixed64List(number, listAt(message, offset), false);
        goto L233
    L15:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeGroupSize(number, (MessageLite) UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
        goto L233
    L18:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeSInt64Size(number, oneofLongAt(message, offset));
        goto L233
    L21:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeSInt32Size(number, oneofIntAt(message, offset));
        goto L233
    L24:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeSFixed64Size(number, 0);
        goto L233
    L27:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeSFixed32Size(number, 0);
        goto L233
    L30:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeEnumSize(number, oneofIntAt(message, offset));
        goto L233
    L33:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeUInt32Size(number, oneofIntAt(message, offset));
        goto L233
    L36:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeBytesSize(number, (ByteString) UnsafeUtil.getObject(message, offset));
        goto L233
    L39:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + SchemaUtil.computeSizeMessage(number, UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
        goto L233
    L42:
        if (isOneofPresent(message, number, i) == false) goto L233;
        Object value = UnsafeUtil.getObject(message, offset);
        if ((value instanceof ByteString) == false) goto L46;
        size = size + CodedOutputStream.computeBytesSize(number, (ByteString) value);
        goto L233
    L46:
        size = size + CodedOutputStream.computeStringSize(number, (String) value);
        goto L233
    L49:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeBoolSize(number, true);
        goto L233
    L52:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeFixed32Size(number, 0);
        goto L233
    L55:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeFixed64Size(number, 0);
        goto L233
    L58:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeInt32Size(number, oneofIntAt(message, offset));
        goto L233
    L61:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeUInt64Size(number, oneofLongAt(message, offset));
        goto L233
    L64:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeInt64Size(number, oneofLongAt(message, offset));
        goto L233
    L67:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeFloatSize(number, 0.0f);
        goto L233
    L70:
        if (isOneofPresent(message, number, i) == false) goto L233;
        size = size + CodedOutputStream.computeDoubleSize(number, 0.0d);
        goto L233
    L176:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeGroupSize(number, (MessageLite) UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
        goto L233
    L179:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeSInt64Size(number, UnsafeUtil.getLong(message, offset));
        goto L233
    L182:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeSInt32Size(number, UnsafeUtil.getInt(message, offset));
        goto L233
    L185:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeSFixed64Size(number, 0);
        goto L233
    L188:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeSFixed32Size(number, 0);
        goto L233
    L191:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeEnumSize(number, UnsafeUtil.getInt(message, offset));
        goto L233
    L194:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeUInt32Size(number, UnsafeUtil.getInt(message, offset));
        goto L233
    L197:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeBytesSize(number, (ByteString) UnsafeUtil.getObject(message, offset));
        goto L233
    L200:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + SchemaUtil.computeSizeMessage(number, UnsafeUtil.getObject(message, offset), getMessageFieldSchema(i));
        goto L233
    L203:
        if (isFieldPresent(message, i) == false) goto L233;
        Object value2 = UnsafeUtil.getObject(message, offset);
        if ((value2 instanceof ByteString) == false) goto L207;
        size = size + CodedOutputStream.computeBytesSize(number, (ByteString) value2);
        goto L233
    L207:
        size = size + CodedOutputStream.computeStringSize(number, (String) value2);
        goto L233
    L210:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeBoolSize(number, true);
        goto L233
    L213:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeFixed32Size(number, 0);
        goto L233
    L216:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeFixed64Size(number, 0);
        goto L233
    L219:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeInt32Size(number, UnsafeUtil.getInt(message, offset));
        goto L233
    L222:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeUInt64Size(number, UnsafeUtil.getLong(message, offset));
        goto L233
    L225:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeInt64Size(number, UnsafeUtil.getLong(message, offset));
        goto L233
    L228:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeFloatSize(number, 0.0f);
        goto L233
    L231:
        if (isFieldPresent(message, i) == false) goto L233;
        size = size + CodedOutputStream.computeDoubleSize(number, 0.0d);
    L233:
        i = i + 3;
        goto L4
    L8:
        if (fieldType > FieldType.SINT64_LIST_PACKED.id()) goto L10;
        cachedSizeOffset = this.buffer[i + 2] & 1048575;
        goto L12
    L235:
        return size + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        UT unknowns = schema.getFromMessage(message);
        return schema.getSerializedSize(unknowns);
    }

    private static List<?> listAt(Object message, long offset) {
        return (List) UnsafeUtil.getObject(message, offset);
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        if (writer.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L6;
        writeFieldsInDescendingOrder(message, writer);
        return;
    L6:
        if (this.proto3 == false) goto L8;
        writeFieldsInAscendingOrderProto3(message, writer);
        return;
    L8:
        writeFieldsInAscendingOrderProto2(message, writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeFieldsInAscendingOrderProto2(T message, Writer writer) throws IOException {
        Iterator<? extends Map.Entry<?, ?>> extensionIterator = null;
        Map.Entry r4 = null;
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r5 = this.extensionSchema.getExtensions(message);
        if (r5.isEmpty() == true) goto L7;
        extensionIterator = r5.iterator();
        Map.Entry nextExtension = extensionIterator.next();
        r4 = nextExtension;
    L7:
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceField = 0;
        int bufferLength = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int pos = 0;
    L8:
        if (pos >= bufferLength) goto L188;
        int typeAndOffset = typeAndOffsetAt(pos);
        int number = numberAt(pos);
        int fieldType = type(typeAndOffset);
        int presenceMask = 0;
        Iterator<? extends Map.Entry<?, ?>> extensionIterator2 = extensionIterator;
        if (fieldType > 17) goto L16;
        int presenceMaskAndOffset = this.buffer[pos + 2];
        int presenceFieldOffset = 1048575 & presenceMaskAndOffset;
        if (presenceFieldOffset == currentPresenceFieldOffset) goto L14;
        currentPresenceFieldOffset = presenceFieldOffset;
        int r18 = 1;
        currentPresenceField = unsafe.getInt(message, presenceFieldOffset);
    L15:
        presenceMask = r18 << (presenceMaskAndOffset >>> 20);
        r4 = r4;
    L17:
        if (r4 == null) goto L25;
        if (this.extensionSchema.extensionNumber(r4) > number) goto L25;
        this.extensionSchema.serializeExtension(writer, r4);
        if (extensionIterator2.hasNext() == false) goto L23;
        Map.Entry<?, ?> r3 = (Map.Entry) extensionIterator2.next();
    L24:
        r4 = r3;
        goto L17
    L23:
        r3 = null;
    L25:
        Map.Entry<?, ?> r10 = r4;
        long offset = offset(typeAndOffset);
        int currentPresenceFieldOffset2 = currentPresenceFieldOffset;
        switch(fieldType) {
            case 0: goto L184;
            case 1: goto L181;
            case 2: goto L178;
            case 3: goto L175;
            case 4: goto L172;
            case 5: goto L169;
            case 6: goto L166;
            case 7: goto L163;
            case 8: goto L160;
            case 9: goto L157;
            case 10: goto L154;
            case 11: goto L151;
            case 12: goto L148;
            case 13: goto L145;
            case 14: goto L142;
            case 15: goto L139;
            case 16: goto L136;
            case 17: goto L133;
            case 18: goto L132;
            case 19: goto L131;
            case 20: goto L130;
            case 21: goto L129;
            case 22: goto L128;
            case 23: goto L127;
            case 24: goto L126;
            case 25: goto L125;
            case 26: goto L124;
            case 27: goto L123;
            case 28: goto L122;
            case 29: goto L121;
            case 30: goto L120;
            case 31: goto L119;
            case 32: goto L118;
            case 33: goto L117;
            case 34: goto L116;
            case 35: goto L115;
            case 36: goto L114;
            case 37: goto L113;
            case 38: goto L112;
            case 39: goto L111;
            case 40: goto L110;
            case 41: goto L109;
            case 42: goto L108;
            case 43: goto L107;
            case 44: goto L106;
            case 45: goto L105;
            case 46: goto L104;
            case 47: goto L103;
            case 48: goto L102;
            case 49: goto L101;
            case 50: goto L100;
            case 51: goto L96;
            case 52: goto L92;
            case 53: goto L88;
            case 54: goto L84;
            case 55: goto L80;
            case 56: goto L76;
            case 57: goto L72;
            case 58: goto L68;
            case 59: goto L64;
            case 60: goto L60;
            case 61: goto L56;
            case 62: goto L52;
            case 63: goto L48;
            case 64: goto L44;
            case 65: goto L40;
            case 66: goto L36;
            case 67: goto L32;
            case 68: goto L29;
            default: goto L27;
        };
    L27:
        int currentPresenceField2 = currentPresenceField;
        int bufferLength2 = bufferLength;
    L187:
        pos = pos + 3;
        r4 = r10;
        extensionIterator = extensionIterator2;
        currentPresenceFieldOffset = currentPresenceFieldOffset2;
        currentPresenceField = currentPresenceField2;
        bufferLength = bufferLength2;
        goto L8
    L32:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L35;
        writer.writeSInt64(number, oneofLongAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L35:
        bufferLength2 = bufferLength;
        goto L187
    L36:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L39;
        writer.writeSInt32(number, oneofIntAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L39:
        bufferLength2 = bufferLength;
        goto L187
    L40:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L43;
        writer.writeSFixed64(number, oneofLongAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L43:
        bufferLength2 = bufferLength;
        goto L187
    L44:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L47;
        writer.writeSFixed32(number, oneofIntAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L47:
        bufferLength2 = bufferLength;
        goto L187
    L48:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L51;
        writer.writeEnum(number, oneofIntAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L51:
        bufferLength2 = bufferLength;
        goto L187
    L52:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L55;
        writer.writeUInt32(number, oneofIntAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L55:
        bufferLength2 = bufferLength;
        goto L187
    L56:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L59;
        writer.writeBytes(number, (ByteString) unsafe.getObject(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L59:
        bufferLength2 = bufferLength;
        goto L187
    L60:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L63;
        Object value = unsafe.getObject(message, offset);
        writer.writeMessage(number, value, getMessageFieldSchema(pos));
        bufferLength2 = bufferLength;
        goto L187
    L63:
        bufferLength2 = bufferLength;
        goto L187
    L64:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L67;
        writeString(number, unsafe.getObject(message, offset), writer);
        bufferLength2 = bufferLength;
        goto L187
    L67:
        bufferLength2 = bufferLength;
        goto L187
    L68:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L71;
        writer.writeBool(number, oneofBooleanAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L71:
        bufferLength2 = bufferLength;
        goto L187
    L72:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L75;
        writer.writeFixed32(number, oneofIntAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L75:
        bufferLength2 = bufferLength;
        goto L187
    L76:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L79;
        writer.writeFixed64(number, oneofLongAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L79:
        bufferLength2 = bufferLength;
        goto L187
    L80:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L83;
        writer.writeInt32(number, oneofIntAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L83:
        bufferLength2 = bufferLength;
        goto L187
    L84:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L87;
        writer.writeUInt64(number, oneofLongAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L87:
        bufferLength2 = bufferLength;
        goto L187
    L88:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L91;
        writer.writeInt64(number, oneofLongAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L91:
        bufferLength2 = bufferLength;
        goto L187
    L92:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L95;
        writer.writeFloat(number, oneofFloatAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L95:
        bufferLength2 = bufferLength;
        goto L187
    L96:
        currentPresenceField2 = currentPresenceField;
        if (isOneofPresent(message, number, pos) == false) goto L99;
        writer.writeDouble(number, oneofDoubleAt(message, offset));
        bufferLength2 = bufferLength;
        goto L187
    L99:
        bufferLength2 = bufferLength;
        goto L187
    L100:
        currentPresenceField2 = currentPresenceField;
        writeMapHelper(writer, number, unsafe.getObject(message, offset), pos);
        bufferLength2 = bufferLength;
        goto L187
    L101:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeGroupList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, getMessageFieldSchema(pos));
        goto L187
    L102:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeSInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L103:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeSInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L104:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeSFixed64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L105:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeSFixed32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L106:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeEnumList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L107:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeUInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L108:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeBoolList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L109:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeFixed32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L110:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeFixed64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L111:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeInt32List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L112:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeUInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L113:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeInt64List(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L114:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeFloatList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L115:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeDoubleList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, r18);
        goto L187
    L116:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField3 = numberAt(pos);
        SchemaUtil.writeSInt64List(currentPresenceField3, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L117:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField4 = numberAt(pos);
        SchemaUtil.writeSInt32List(currentPresenceField4, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L118:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField5 = numberAt(pos);
        SchemaUtil.writeSFixed64List(currentPresenceField5, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L119:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField6 = numberAt(pos);
        SchemaUtil.writeSFixed32List(currentPresenceField6, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L120:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField7 = numberAt(pos);
        SchemaUtil.writeEnumList(currentPresenceField7, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L121:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField8 = numberAt(pos);
        SchemaUtil.writeUInt32List(currentPresenceField8, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L122:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeBytesList(numberAt(pos), (List) unsafe.getObject(message, offset), writer);
        goto L187
    L123:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeMessageList(numberAt(pos), (List) unsafe.getObject(message, offset), writer, getMessageFieldSchema(pos));
        goto L187
    L124:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        SchemaUtil.writeStringList(numberAt(pos), (List) unsafe.getObject(message, offset), writer);
        goto L187
    L125:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField9 = numberAt(pos);
        SchemaUtil.writeBoolList(currentPresenceField9, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L126:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField10 = numberAt(pos);
        SchemaUtil.writeFixed32List(currentPresenceField10, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L127:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField11 = numberAt(pos);
        SchemaUtil.writeFixed64List(currentPresenceField11, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L128:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField12 = numberAt(pos);
        SchemaUtil.writeInt32List(currentPresenceField12, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L129:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField13 = numberAt(pos);
        SchemaUtil.writeUInt64List(currentPresenceField13, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L130:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField14 = numberAt(pos);
        SchemaUtil.writeInt64List(currentPresenceField14, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L131:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField15 = numberAt(pos);
        SchemaUtil.writeFloatList(currentPresenceField15, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L132:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        int currentPresenceField16 = numberAt(pos);
        SchemaUtil.writeDoubleList(currentPresenceField16, (List) unsafe.getObject(message, offset), writer, false);
        goto L187
    L133:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeGroup(number, unsafe.getObject(message, offset), getMessageFieldSchema(pos));
        goto L187
    L136:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeSInt64(number, unsafe.getLong(message, offset));
        goto L187
    L139:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeSInt32(number, unsafe.getInt(message, offset));
        goto L187
    L142:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeSFixed64(number, unsafe.getLong(message, offset));
        goto L187
    L145:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeSFixed32(number, unsafe.getInt(message, offset));
        goto L187
    L148:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeEnum(number, unsafe.getInt(message, offset));
        goto L187
    L151:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeUInt32(number, unsafe.getInt(message, offset));
        goto L187
    L154:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeBytes(number, (ByteString) unsafe.getObject(message, offset));
        goto L187
    L157:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        Object value2 = unsafe.getObject(message, offset);
        writer.writeMessage(number, value2, getMessageFieldSchema(pos));
        goto L187
    L160:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writeString(number, unsafe.getObject(message, offset), writer);
        goto L187
    L163:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeBool(number, booleanAt(message, offset));
        goto L187
    L166:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeFixed32(number, unsafe.getInt(message, offset));
        goto L187
    L169:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeFixed64(number, unsafe.getLong(message, offset));
        goto L187
    L172:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeInt32(number, unsafe.getInt(message, offset));
        goto L187
    L175:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeUInt64(number, unsafe.getLong(message, offset));
        goto L187
    L178:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeInt64(number, unsafe.getLong(message, offset));
        goto L187
    L181:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeFloat(number, floatAt(message, offset));
        goto L187
    L184:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        if ((currentPresenceField2 & presenceMask) == 0) goto L187;
        writer.writeDouble(number, doubleAt(message, offset));
        goto L187
    L29:
        if (isOneofPresent(message, number, pos) == false) goto L31;
        currentPresenceField2 = currentPresenceField;
        writer.writeGroup(number, unsafe.getObject(message, offset), getMessageFieldSchema(pos));
        bufferLength2 = bufferLength;
        goto L187
    L31:
        currentPresenceField2 = currentPresenceField;
        bufferLength2 = bufferLength;
        goto L187
    L14:
        r18 = 1;
        goto L15
    L16:
        r18 = 1;
        goto L17
    L188:
        Iterator<? extends Map.Entry<?, ?>> extensionIterator3 = extensionIterator;
    L189:
        if (r4 == null) goto L195;
        this.extensionSchema.serializeExtension(writer, r4);
        if (extensionIterator3.hasNext() == false) goto L193;
        Map.Entry<?, ?> r6 = (Map.Entry) extensionIterator3.next();
    L194:
        r4 = r6;
        goto L189
    L193:
        r6 = null;
        goto L194
    L195:
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    private void writeFieldsInAscendingOrderProto3(T message, Writer writer) throws IOException {
        Iterator<? extends Map.Entry<?, ?>> extensionIterator = null;
        Map.Entry r1 = null;
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r2 = this.extensionSchema.getExtensions(message);
        if (r2.isEmpty() == true) goto L7;
        extensionIterator = r2.iterator();
        Map.Entry nextExtension = extensionIterator.next();
        r1 = nextExtension;
    L7:
        int bufferLength = this.buffer.length;
        int pos = 0;
    L9:
        if (pos >= bufferLength) goto L164;
        int typeAndOffset = typeAndOffsetAt(pos);
        int number = numberAt(pos);
    L11:
        if (r1 == null) goto L20;
        if (this.extensionSchema.extensionNumber(r1) > number) goto L20;
        this.extensionSchema.serializeExtension(writer, r1);
        if (extensionIterator.hasNext() == false) goto L17;
        Map.Entry<?, ?> r7 = (Map.Entry) extensionIterator.next();
    L18:
        r1 = r7;
        goto L11
    L17:
        r7 = null;
    L20:
        switch(type(typeAndOffset)) {
            case 0: goto L161;
            case 1: goto L158;
            case 2: goto L155;
            case 3: goto L152;
            case 4: goto L149;
            case 5: goto L146;
            case 6: goto L143;
            case 7: goto L140;
            case 8: goto L137;
            case 9: goto L134;
            case 10: goto L131;
            case 11: goto L128;
            case 12: goto L125;
            case 13: goto L122;
            case 14: goto L119;
            case 15: goto L116;
            case 16: goto L113;
            case 17: goto L110;
            case 18: goto L108;
            case 19: goto L107;
            case 20: goto L106;
            case 21: goto L105;
            case 22: goto L104;
            case 23: goto L103;
            case 24: goto L102;
            case 25: goto L101;
            case 26: goto L100;
            case 27: goto L99;
            case 28: goto L98;
            case 29: goto L97;
            case 30: goto L96;
            case 31: goto L95;
            case 32: goto L94;
            case 33: goto L93;
            case 34: goto L92;
            case 35: goto L91;
            case 36: goto L90;
            case 37: goto L89;
            case 38: goto L88;
            case 39: goto L87;
            case 40: goto L86;
            case 41: goto L85;
            case 42: goto L84;
            case 43: goto L83;
            case 44: goto L82;
            case 45: goto L81;
            case 46: goto L80;
            case 47: goto L79;
            case 48: goto L78;
            case 49: goto L77;
            case 50: goto L76;
            case 51: goto L74;
            case 52: goto L71;
            case 53: goto L68;
            case 54: goto L65;
            case 55: goto L62;
            case 56: goto L59;
            case 57: goto L56;
            case 58: goto L53;
            case 59: goto L50;
            case 60: goto L47;
            case 61: goto L44;
            case 62: goto L41;
            case 63: goto L38;
            case 64: goto L35;
            case 65: goto L32;
            case 66: goto L29;
            case 67: goto L26;
            case 68: goto L23;
            default: goto L163;
        };
    L76:
        writeMapHelper(writer, number, UnsafeUtil.getObject(message, offset(typeAndOffset)), pos);
        goto L163
    L77:
        SchemaUtil.writeGroupList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
        goto L163
    L78:
        SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L79:
        SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L80:
        SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L81:
        SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L82:
        SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L83:
        SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L84:
        SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L85:
        SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L86:
        SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L87:
        SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L88:
        SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L89:
        SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L90:
        SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L91:
        SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L163
    L92:
        SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L93:
        SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L94:
        SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L95:
        SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L96:
        SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L97:
        SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L98:
        SchemaUtil.writeBytesList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L163
    L99:
        SchemaUtil.writeMessageList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
        goto L163
    L100:
        SchemaUtil.writeStringList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L163
    L101:
        SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L102:
        SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L103:
        SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L104:
        SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L105:
        SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L106:
        SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L107:
        SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L108:
        SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L163
    L23:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
        goto L163
    L26:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeSInt64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L163
    L29:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeSInt32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L163
    L32:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeSFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L163
    L35:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeSFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L163
    L38:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeEnum(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L163
    L41:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeUInt32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L163
    L44:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
        goto L163
    L47:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        Object value = UnsafeUtil.getObject(message, offset(typeAndOffset));
        writer.writeMessage(number, value, getMessageFieldSchema(pos));
        goto L163
    L50:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L163
    L53:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeBool(number, oneofBooleanAt(message, offset(typeAndOffset)));
        goto L163
    L56:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L163
    L59:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L163
    L62:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeInt32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L163
    L65:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeUInt64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L163
    L68:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeInt64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L163
    L71:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeFloat(number, oneofFloatAt(message, offset(typeAndOffset)));
        goto L163
    L74:
        if (isOneofPresent(message, number, pos) == false) goto L163;
        writer.writeDouble(number, oneofDoubleAt(message, offset(typeAndOffset)));
        goto L163
    L110:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
        goto L163
    L113:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeSInt64(number, longAt(message, offset(typeAndOffset)));
        goto L163
    L116:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeSInt32(number, intAt(message, offset(typeAndOffset)));
        goto L163
    L119:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeSFixed64(number, longAt(message, offset(typeAndOffset)));
        goto L163
    L122:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeSFixed32(number, intAt(message, offset(typeAndOffset)));
        goto L163
    L125:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeEnum(number, intAt(message, offset(typeAndOffset)));
        goto L163
    L128:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeUInt32(number, intAt(message, offset(typeAndOffset)));
        goto L163
    L131:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
        goto L163
    L134:
        if (isFieldPresent(message, pos) == false) goto L163;
        Object value2 = UnsafeUtil.getObject(message, offset(typeAndOffset));
        writer.writeMessage(number, value2, getMessageFieldSchema(pos));
        goto L163
    L137:
        if (isFieldPresent(message, pos) == false) goto L163;
        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L163
    L140:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeBool(number, booleanAt(message, offset(typeAndOffset)));
        goto L163
    L143:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeFixed32(number, intAt(message, offset(typeAndOffset)));
        goto L163
    L146:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeFixed64(number, longAt(message, offset(typeAndOffset)));
        goto L163
    L149:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeInt32(number, intAt(message, offset(typeAndOffset)));
        goto L163
    L152:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeUInt64(number, longAt(message, offset(typeAndOffset)));
        goto L163
    L155:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeInt64(number, longAt(message, offset(typeAndOffset)));
        goto L163
    L158:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeFloat(number, floatAt(message, offset(typeAndOffset)));
        goto L163
    L161:
        if (isFieldPresent(message, pos) == false) goto L163;
        writer.writeDouble(number, doubleAt(message, offset(typeAndOffset)));
    L163:
        pos = pos + 3;
    L164:
        if (r1 == null) goto L170;
        this.extensionSchema.serializeExtension(writer, r1);
        if (extensionIterator.hasNext() == false) goto L168;
        Map.Entry<?, ?> r3 = (Map.Entry) extensionIterator.next();
    L169:
        r1 = r3;
        goto L164
    L168:
        r3 = null;
        goto L169
    L170:
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    private void writeFieldsInDescendingOrder(T message, Writer writer) throws IOException {
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        Iterator<? extends Map.Entry<?, ?>> extensionIterator = null;
        Map.Entry r1 = null;
        if (this.hasExtensions == false) goto L7;
        FieldSet<T> r2 = this.extensionSchema.getExtensions(message);
        if (r2.isEmpty() == true) goto L7;
        extensionIterator = r2.descendingIterator();
        Map.Entry nextExtension = extensionIterator.next();
        r1 = nextExtension;
    L7:
        int pos = this.buffer.length;
    L8:
        pos = pos - 3;
        if (pos < 0) goto L164;
        int typeAndOffset = typeAndOffsetAt(pos);
        int number = numberAt(pos);
    L11:
        if (r1 == null) goto L20;
        if (this.extensionSchema.extensionNumber(r1) <= number) goto L20;
        this.extensionSchema.serializeExtension(writer, r1);
        if (extensionIterator.hasNext() == false) goto L17;
        Map.Entry<?, ?> r6 = (Map.Entry) extensionIterator.next();
    L18:
        r1 = r6;
        goto L11
    L17:
        r6 = null;
    L20:
        switch(type(typeAndOffset)) {
            case 0: goto L161;
            case 1: goto L158;
            case 2: goto L155;
            case 3: goto L152;
            case 4: goto L149;
            case 5: goto L146;
            case 6: goto L143;
            case 7: goto L140;
            case 8: goto L137;
            case 9: goto L134;
            case 10: goto L131;
            case 11: goto L128;
            case 12: goto L125;
            case 13: goto L122;
            case 14: goto L119;
            case 15: goto L116;
            case 16: goto L113;
            case 17: goto L110;
            case 18: goto L108;
            case 19: goto L107;
            case 20: goto L106;
            case 21: goto L105;
            case 22: goto L104;
            case 23: goto L103;
            case 24: goto L102;
            case 25: goto L101;
            case 26: goto L100;
            case 27: goto L99;
            case 28: goto L98;
            case 29: goto L97;
            case 30: goto L96;
            case 31: goto L95;
            case 32: goto L94;
            case 33: goto L93;
            case 34: goto L92;
            case 35: goto L91;
            case 36: goto L90;
            case 37: goto L89;
            case 38: goto L88;
            case 39: goto L87;
            case 40: goto L86;
            case 41: goto L85;
            case 42: goto L84;
            case 43: goto L83;
            case 44: goto L82;
            case 45: goto L81;
            case 46: goto L80;
            case 47: goto L79;
            case 48: goto L78;
            case 49: goto L77;
            case 50: goto L76;
            case 51: goto L74;
            case 52: goto L71;
            case 53: goto L68;
            case 54: goto L65;
            case 55: goto L62;
            case 56: goto L59;
            case 57: goto L56;
            case 58: goto L53;
            case 59: goto L50;
            case 60: goto L47;
            case 61: goto L44;
            case 62: goto L41;
            case 63: goto L38;
            case 64: goto L35;
            case 65: goto L32;
            case 66: goto L29;
            case 67: goto L26;
            case 68: goto L23;
            default: goto L8;
        };
    L76:
        writeMapHelper(writer, number, UnsafeUtil.getObject(message, offset(typeAndOffset)), pos);
        goto L8
    L77:
        SchemaUtil.writeGroupList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
        goto L8
    L78:
        SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L79:
        SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L80:
        SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L81:
        SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L82:
        SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L83:
        SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L84:
        SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L85:
        SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L86:
        SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L87:
        SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L88:
        SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L89:
        SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L90:
        SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L91:
        SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, true);
        goto L8
    L92:
        SchemaUtil.writeSInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L93:
        SchemaUtil.writeSInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L94:
        SchemaUtil.writeSFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L95:
        SchemaUtil.writeSFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L96:
        SchemaUtil.writeEnumList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L97:
        SchemaUtil.writeUInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L98:
        SchemaUtil.writeBytesList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L8
    L99:
        SchemaUtil.writeMessageList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, getMessageFieldSchema(pos));
        goto L8
    L100:
        SchemaUtil.writeStringList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L8
    L101:
        SchemaUtil.writeBoolList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L102:
        SchemaUtil.writeFixed32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L103:
        SchemaUtil.writeFixed64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L104:
        SchemaUtil.writeInt32List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L105:
        SchemaUtil.writeUInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L106:
        SchemaUtil.writeInt64List(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L107:
        SchemaUtil.writeFloatList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L108:
        SchemaUtil.writeDoubleList(numberAt(pos), (List) UnsafeUtil.getObject(message, offset(typeAndOffset)), writer, false);
        goto L8
    L23:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
        goto L8
    L26:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeSInt64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L8
    L29:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeSInt32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L8
    L32:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeSFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L8
    L35:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeSFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L8
    L38:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeEnum(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L8
    L41:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeUInt32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L8
    L44:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
        goto L8
    L47:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        Object value = UnsafeUtil.getObject(message, offset(typeAndOffset));
        writer.writeMessage(number, value, getMessageFieldSchema(pos));
        goto L8
    L50:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L8
    L53:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeBool(number, oneofBooleanAt(message, offset(typeAndOffset)));
        goto L8
    L56:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeFixed32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L8
    L59:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeFixed64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L8
    L62:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeInt32(number, oneofIntAt(message, offset(typeAndOffset)));
        goto L8
    L65:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeUInt64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L8
    L68:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeInt64(number, oneofLongAt(message, offset(typeAndOffset)));
        goto L8
    L71:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeFloat(number, oneofFloatAt(message, offset(typeAndOffset)));
        goto L8
    L74:
        if (isOneofPresent(message, number, pos) == false) goto L8;
        writer.writeDouble(number, oneofDoubleAt(message, offset(typeAndOffset)));
        goto L8
    L110:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeGroup(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), getMessageFieldSchema(pos));
        goto L8
    L113:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeSInt64(number, longAt(message, offset(typeAndOffset)));
        goto L8
    L116:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeSInt32(number, intAt(message, offset(typeAndOffset)));
        goto L8
    L119:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeSFixed64(number, longAt(message, offset(typeAndOffset)));
        goto L8
    L122:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeSFixed32(number, intAt(message, offset(typeAndOffset)));
        goto L8
    L125:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeEnum(number, intAt(message, offset(typeAndOffset)));
        goto L8
    L128:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeUInt32(number, intAt(message, offset(typeAndOffset)));
        goto L8
    L131:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeBytes(number, (ByteString) UnsafeUtil.getObject(message, offset(typeAndOffset)));
        goto L8
    L134:
        if (isFieldPresent(message, pos) == false) goto L8;
        Object value2 = UnsafeUtil.getObject(message, offset(typeAndOffset));
        writer.writeMessage(number, value2, getMessageFieldSchema(pos));
        goto L8
    L137:
        if (isFieldPresent(message, pos) == false) goto L8;
        writeString(number, UnsafeUtil.getObject(message, offset(typeAndOffset)), writer);
        goto L8
    L140:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeBool(number, booleanAt(message, offset(typeAndOffset)));
        goto L8
    L143:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeFixed32(number, intAt(message, offset(typeAndOffset)));
        goto L8
    L146:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeFixed64(number, longAt(message, offset(typeAndOffset)));
        goto L8
    L149:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeInt32(number, intAt(message, offset(typeAndOffset)));
        goto L8
    L152:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeUInt64(number, longAt(message, offset(typeAndOffset)));
        goto L8
    L155:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeInt64(number, longAt(message, offset(typeAndOffset)));
        goto L8
    L158:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeFloat(number, floatAt(message, offset(typeAndOffset)));
        goto L8
    L161:
        if (isFieldPresent(message, pos) == false) goto L8;
        writer.writeDouble(number, doubleAt(message, offset(typeAndOffset)));
    L164:
        if (r1 == null) goto L170;
        this.extensionSchema.serializeExtension(writer, r1);
        if (extensionIterator.hasNext() == false) goto L168;
        Map.Entry<?, ?> r3 = (Map.Entry) extensionIterator.next();
    L169:
        r1 = r3;
        goto L164
    L168:
        r3 = null;
        goto L169
    }

    private <K, V> void writeMapHelper(Writer writer, int number, Object mapField, int pos) throws IOException {
        if (mapField == null) goto L5;
        writer.writeMap(number, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)), this.mapFieldSchema.forMapData(mapField));
        return;
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> schema, T message, Writer writer) throws IOException {
        schema.writeTo(schema.getFromMessage(message), writer);
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (extensionRegistry == null) goto L6;
        checkMutable(message);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
        return;
    L6:
        throw new NullPointerException();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 24341. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <UT, UB, ET extends com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.bytedance.location.protobuf.UnknownFieldSchema<UT, UB> r17, com.bytedance.location.protobuf.ExtensionSchema<ET> r18, T r19, com.bytedance.location.protobuf.Reader r20, com.bytedance.location.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = 
              (r16v0 'this' ?? I:??[OBJECT, ARRAY] A[D('this' com.bytedance.location.protobuf.MessageSchema<T>), IMMUTABLE_TYPE, THIS])
             A[DECLARE_VAR] (LINE:3909) in method: com.bytedance.location.protobuf.MessageSchema.mergeFromHelper(com.bytedance.location.protobuf.UnknownFieldSchema<UT, UB>, com.bytedance.location.protobuf.ExtensionSchema<ET extends com.bytedance.location.protobuf.FieldSet$FieldDescriptorLite<ET>>, T, com.bytedance.location.protobuf.Reader, com.bytedance.location.protobuf.ExtensionRegistryLite):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.location.protobuf.MessageSchema.mergeFromHelper(com.bytedance.location.protobuf.UnknownFieldSchema, com.bytedance.location.protobuf.ExtensionSchema, java.lang.Object, com.bytedance.location.protobuf.Reader, com.bytedance.location.protobuf.ExtensionRegistryLite):void");
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object message) {
        UnknownFieldSetLite unknownFields = ((GeneratedMessageLite) message).unknownFields;
        if (unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite unknownFields2 = UnknownFieldSetLite.newInstance();
        ((GeneratedMessageLite) message).unknownFields = unknownFields2;
        return unknownFields2;
    L6:
        return unknownFields;
    }

    private int decodeMapEntryValue(byte[] data, int position, int limit, WireFormat.FieldType fieldType, Class<?> messageType, ArrayDecoders.Registers registers) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1: goto L17;
            case 2: goto L33;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L11;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L10;
            case 14: goto L26;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L23;
            default: goto L5;
        };
    L7:
        int position2 = ArrayDecoders.decodeVarint64(data, position, registers);
        registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
        return position2;
    L8:
        int position3 = ArrayDecoders.decodeVarint32(data, position, registers);
        registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
        return position3;
    L10:
        int position4 = ArrayDecoders.decodeVarint64(data, position, registers);
        registers.object1 = Long.valueOf(registers.long1);
        return position4;
    L11:
        int position5 = ArrayDecoders.decodeVarint32(data, position, registers);
        registers.object1 = Integer.valueOf(registers.int1);
        return position5;
    L12:
        registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(data, position));
        return position + 4;
    L13:
        registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(data, position));
        return position + 8;
    L14:
        registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(data, position));
        return position + 4;
    L15:
        registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(data, position));
        return position + 8;
    L17:
        int position6 = ArrayDecoders.decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L20;
        boolean r0 = true;
    L21:
        registers.object1 = Boolean.valueOf(r0);
        return position6;
    L20:
        r0 = false;
        goto L21
    L5:
        throw new RuntimeException("unsupported field type.");
    L23:
        return ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
    L26:
        return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(messageType), data, position, limit, registers);
    L33:
        return ArrayDecoders.decodeBytes(data, position, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] data, int position, int limit, MapEntryLite.Metadata<K, V> metadata, Map<K, V> r20, ArrayDecoders.Registers registers) throws IOException {
        byte[] r1 = data;
        int position2 = ArrayDecoders.decodeVarint32(r1, position, registers);
        int length = registers.int1;
        if (length < 0) goto L31;
        if (length > (limit - position2)) goto L31;
        int end = position2 + length;
        K key = metadata.defaultKey;
        Object r10 = key;
        Object r11 = metadata.defaultValue;
    L7:
        if (position2 >= end) goto L25;
        int position3 = position2 + 1;
        int tag = r1[position2];
        if (tag >= 0) goto L11;
        position3 = ArrayDecoders.decodeVarint32(tag, r1, position3, registers);
        int tag2 = registers.int1;
    L12:
        int fieldNumber = tag2 >>> 3;
        int wireType = tag2 & 7;
        switch(fieldNumber) {
            case 1: goto L20;
            case 2: goto L16;
            default: goto L23;
        };
    L20:
        if (wireType != metadata.keyType.getWireType()) goto L22;
        r1 = data;
        int position4 = decodeMapEntryValue(r1, position3, limit, metadata.keyType, null, registers);
        r10 = registers.object1;
        position2 = position4;
        goto L7
    L22:
        r1 = data;
    L23:
        position2 = ArrayDecoders.skipField(tag2, r1, position3, limit, registers);
        goto L7
    L16:
        if (wireType == metadata.valueType.getWireType()) goto L17;
        r1 = data;
        goto L23
    L17:
        int position5 = decodeMapEntryValue(r1, position3, limit, metadata.valueType, metadata.defaultValue.getClass(), registers);
        r11 = registers.object1;
        r1 = data;
        position2 = position5;
        goto L7
    L11:
        tag2 = tag;
        goto L12
    L25:
        if (position2 != end) goto L29;
        r20.put(r10, r11);
        return end;
    L29:
        throw InvalidProtocolBufferException.parseFailure();
    L31:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    private int parseRepeatedField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int bufferPosition, long typeAndOffset, int fieldType, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Internal.ProtobufList<?> list = (Internal.ProtobufList) UNSAFE.getObject(message, fieldOffset);
        if (list.isModifiable() == true) goto L9;
        int size = list.size();
        if (size != 0) goto L7;
        int r3 = 10;
    L8:
        Internal.ProtobufList<?> list2 = list.mutableCopyWithCapacity(r3);
        UNSAFE.putObject(message, fieldOffset, list2);
        Internal.ProtobufList<?> list3 = list2;
    L11:
        switch(fieldType) {
            case 18: goto L80;
            case 19: goto L74;
            case 20: goto L68;
            case 21: goto L68;
            case 22: goto L63;
            case 23: goto L57;
            case 24: goto L51;
            case 25: goto L45;
            case 26: goto L38;
            case 27: goto L36;
            case 28: goto L34;
            case 29: goto L63;
            case 30: goto L29;
            case 31: goto L51;
            case 32: goto L57;
            case 33: goto L24;
            case 34: goto L18;
            case 35: goto L80;
            case 36: goto L74;
            case 37: goto L68;
            case 38: goto L68;
            case 39: goto L63;
            case 40: goto L57;
            case 41: goto L51;
            case 42: goto L45;
            case 43: goto L63;
            case 44: goto L29;
            case 45: goto L51;
            case 46: goto L57;
            case 47: goto L24;
            case 48: goto L18;
            case 49: goto L14;
            default: goto L85;
        };
    L34:
        if (wireType != 2) goto L85;
        return ArrayDecoders.decodeBytesList(tag, data, position, limit, list3, registers);
    L36:
        if (wireType != 2) goto L85;
        return ArrayDecoders.decodeMessageList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, list3, registers);
    L38:
        if (wireType != 2) goto L85;
        if ((typeAndOffset & 536870912) != 0) goto L95;
        return ArrayDecoders.decodeStringList(tag, data, position, limit, list3, registers);
    L95:
        return ArrayDecoders.decodeStringListRequireUtf8(tag, data, position, limit, list3, registers);
    L14:
        if (wireType != 3) goto L85;
        return ArrayDecoders.decodeGroupList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, list3, registers);
    L18:
        if (wireType == 2) goto L87;
        if (wireType != 0) goto L85;
        return ArrayDecoders.decodeSInt64List(tag, data, position, limit, list3, registers);
    L87:
        return ArrayDecoders.decodePackedSInt64List(data, position, list3, registers);
    L24:
        if (wireType == 2) goto L89;
        if (wireType != 0) goto L85;
        return ArrayDecoders.decodeSInt32List(tag, data, position, limit, list3, registers);
    L89:
        return ArrayDecoders.decodePackedSInt32List(data, position, list3, registers);
    L29:
        if (wireType != 2) goto L31;
        int position2 = ArrayDecoders.decodePackedVarint32List(data, position, list3, registers);
    L33:
        Internal.ProtobufList<?> list4 = list3;
        SchemaUtil.filterUnknownEnumList(message, number, list4, getEnumFieldVerifier(bufferPosition), null, this.unknownFieldSchema);
        return position2;
    L31:
        if (wireType != 0) goto L85;
        Internal.ProtobufList<?> list5 = list3;
        list3 = list5;
        position2 = ArrayDecoders.decodeVarint32List(tag, data, position, limit, list5, registers);
        goto L33
    L45:
        if (wireType == 2) goto L96;
        if (wireType != 0) goto L85;
        return ArrayDecoders.decodeBoolList(tag, data, position, limit, list3, registers);
    L96:
        return ArrayDecoders.decodePackedBoolList(data, position, list3, registers);
    L51:
        if (wireType == 2) goto L98;
        if (wireType != 5) goto L85;
        return ArrayDecoders.decodeFixed32List(tag, data, position, limit, list3, registers);
    L98:
        return ArrayDecoders.decodePackedFixed32List(data, position, list3, registers);
    L57:
        if (wireType == 2) goto L100;
        if (wireType != 1) goto L85;
        return ArrayDecoders.decodeFixed64List(tag, data, position, limit, list3, registers);
    L100:
        return ArrayDecoders.decodePackedFixed64List(data, position, list3, registers);
    L63:
        if (wireType == 2) goto L102;
        if (wireType != 0) goto L85;
        return ArrayDecoders.decodeVarint32List(tag, data, position, limit, list3, registers);
    L102:
        return ArrayDecoders.decodePackedVarint32List(data, position, list3, registers);
    L68:
        if (wireType == 2) goto L104;
        if (wireType != 0) goto L85;
        return ArrayDecoders.decodeVarint64List(tag, data, position, limit, list3, registers);
    L104:
        return ArrayDecoders.decodePackedVarint64List(data, position, list3, registers);
    L74:
        if (wireType == 2) goto L106;
        if (wireType != 5) goto L85;
        return ArrayDecoders.decodeFloatList(tag, data, position, limit, list3, registers);
    L106:
        return ArrayDecoders.decodePackedFloatList(data, position, list3, registers);
    L80:
        if (wireType == 2) goto L108;
        if (wireType != 1) goto L85;
        return ArrayDecoders.decodeDoubleList(tag, data, position, limit, list3, registers);
    L108:
        return ArrayDecoders.decodePackedDoubleList(data, position, list3, registers);
    L85:
        return position;
    L7:
        r3 = size * 2;
        goto L8
    L9:
        list3 = list;
        goto L11
    }

    private <K, V> int parseMapField(T message, byte[] data, int position, int limit, int bufferPosition, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapDefaultEntry = getMapFieldDefaultEntry(bufferPosition);
        Object mapField = unsafe.getObject(message, fieldOffset);
        if (this.mapFieldSchema.isImmutable(mapField) == false) goto L5;
        Object mapField2 = this.mapFieldSchema.newMapField(mapDefaultEntry);
        this.mapFieldSchema.mergeFrom(mapField2, mapField);
        unsafe.putObject(message, fieldOffset, mapField2);
        Object mapField3 = mapField2;
    L7:
        return decodeMapEntry(data, position, limit, this.mapFieldSchema.forMapMetadata(mapDefaultEntry), this.mapFieldSchema.forMutableMapData(mapField3), registers);
    L5:
        mapField3 = mapField;
        goto L7
    }

    private int parseOneofField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int typeAndOffset, int fieldType, long fieldOffset, int bufferPosition, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long oneofCaseOffset = this.buffer[bufferPosition + 2] & 1048575;
        switch(fieldType) {
            case 51: goto L74;
            case 52: goto L71;
            case 53: goto L68;
            case 54: goto L68;
            case 55: goto L65;
            case 56: goto L62;
            case 57: goto L59;
            case 58: goto L52;
            case 59: goto L38;
            case 60: goto L34;
            case 61: goto L30;
            case 62: goto L65;
            case 63: goto L18;
            case 64: goto L59;
            case 65: goto L62;
            case 66: goto L14;
            case 67: goto L10;
            case 68: goto L6;
            default: goto L77;
        };
    L77:
        return position;
    L6:
        if (wireType != 3) goto L79;
        Object current = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
        int endTag = (tag & (-8)) | 4;
        int position2 = ArrayDecoders.mergeGroupField(current, getMessageFieldSchema(bufferPosition), data, position, limit, endTag, registers);
        storeOneofMessageField(message, number, bufferPosition, current);
        return position2;
    L79:
        return position;
    L10:
        if (wireType != 0) goto L81;
        int position3 = ArrayDecoders.decodeVarint64(data, position, registers);
        unsafe.putObject(message, fieldOffset, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
        unsafe.putInt(message, oneofCaseOffset, number);
        return position3;
    L81:
        return position;
    L14:
        if (wireType != 0) goto L83;
        int position4 = ArrayDecoders.decodeVarint32(data, position, registers);
        unsafe.putObject(message, fieldOffset, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
        unsafe.putInt(message, oneofCaseOffset, number);
        return position4;
    L83:
        return position;
    L18:
        if (wireType != 0) goto L85;
        int position5 = ArrayDecoders.decodeVarint32(data, position, registers);
        int enumValue = registers.int1;
        Internal.EnumVerifier enumVerifier = getEnumFieldVerifier(bufferPosition);
        if (enumVerifier == null) goto L26;
        if (enumVerifier.isInRange(enumValue) == true) goto L26;
        position5 = position5;
        getMutableUnknownFields(message).storeField(tag, Long.valueOf(enumValue));
    L84:
        return position5;
    L26:
        unsafe.putObject(message, fieldOffset, Integer.valueOf(enumValue));
        unsafe.putInt(message, oneofCaseOffset, number);
        goto L84
    L85:
        return position;
    L30:
        if (wireType != 2) goto L87;
        int position6 = ArrayDecoders.decodeBytes(data, position, registers);
        unsafe.putObject(message, fieldOffset, registers.object1);
        unsafe.putInt(message, oneofCaseOffset, number);
        return position6;
    L87:
        return position;
    L34:
        if (wireType != 2) goto L89;
        Object current2 = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
        int position7 = ArrayDecoders.mergeMessageField(current2, getMessageFieldSchema(bufferPosition), data, position, limit, registers);
        storeOneofMessageField(message, number, bufferPosition, current2);
        return position7;
    L89:
        return position;
    L38:
        if (wireType != 2) goto L90;
        int position8 = ArrayDecoders.decodeVarint32(data, position, registers);
        int length = registers.int1;
        if (length != 0) goto L43;
        unsafe.putObject(message, fieldOffset, "");
    L50:
        unsafe.putInt(message, oneofCaseOffset, number);
        return position8;
    L43:
        if ((typeAndOffset & 536870912) != 0) goto L45;
    L49:
        String value = new String(data, position8, length, Internal.UTF_8);
        unsafe.putObject(message, fieldOffset, value);
        position8 = position8 + length;
        goto L50
    L45:
        if (Utf8.isValidUtf8(data, position8, position8 + length) == true) goto L49;
        throw InvalidProtocolBufferException.invalidUtf8();
    L90:
        return position;
    L52:
        if (wireType != 0) goto L92;
        int position9 = ArrayDecoders.decodeVarint64(data, position, registers);
        if (registers.long1 == 0) goto L56;
        boolean r5 = true;
    L57:
        unsafe.putObject(message, fieldOffset, Boolean.valueOf(r5));
        unsafe.putInt(message, oneofCaseOffset, number);
        return position9;
    L56:
        r5 = false;
        goto L57
    L92:
        return position;
    L59:
        if (wireType != 5) goto L94;
        unsafe.putObject(message, fieldOffset, Integer.valueOf(ArrayDecoders.decodeFixed32(data, position)));
        int position10 = position + 4;
        unsafe.putInt(message, oneofCaseOffset, number);
        return position10;
    L94:
        return position;
    L62:
        if (wireType != 1) goto L96;
        unsafe.putObject(message, fieldOffset, Long.valueOf(ArrayDecoders.decodeFixed64(data, position)));
        int position11 = position + 8;
        unsafe.putInt(message, oneofCaseOffset, number);
        return position11;
    L96:
        return position;
    L65:
        if (wireType != 0) goto L98;
        int position12 = ArrayDecoders.decodeVarint32(data, position, registers);
        unsafe.putObject(message, fieldOffset, Integer.valueOf(registers.int1));
        unsafe.putInt(message, oneofCaseOffset, number);
        return position12;
    L98:
        return position;
    L68:
        if (wireType != 0) goto L100;
        int position13 = ArrayDecoders.decodeVarint64(data, position, registers);
        unsafe.putObject(message, fieldOffset, Long.valueOf(registers.long1));
        unsafe.putInt(message, oneofCaseOffset, number);
        return position13;
    L100:
        return position;
    L71:
        if (wireType != 5) goto L102;
        unsafe.putObject(message, fieldOffset, Float.valueOf(ArrayDecoders.decodeFloat(data, position)));
        int position14 = position + 4;
        unsafe.putInt(message, oneofCaseOffset, number);
        return position14;
    L102:
        return position;
    L74:
        if (wireType != 1) goto L104;
        unsafe.putObject(message, fieldOffset, Double.valueOf(ArrayDecoders.decodeDouble(data, position)));
        int position15 = position + 8;
        unsafe.putInt(message, oneofCaseOffset, number);
        return position15;
    L104:
        return position;
    }

    private Schema getMessageFieldSchema(int pos) {
        int index = (pos / 3) * 2;
        Schema schema = (Schema) this.objects[index];
        if (schema == null) goto L5;
        return schema;
    L5:
        Schema<T> r1 = Protobuf.getInstance().schemaFor((Class) this.objects[index + 1]);
        this.objects[index] = r1;
        return r1;
    }

    private Object getMapFieldDefaultEntry(int pos) {
        return this.objects[(pos / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int pos) {
        return (Internal.EnumVerifier) this.objects[((pos / 3) * 2) + 1];
    }

    int parseProto2Message(T message, byte[] data, int position, int limit, int endGroup, ArrayDecoders.Registers registers) throws IOException {
        MessageSchema<T> r0 = this;
        T r1 = message;
        byte[] r2 = data;
        int endTag = limit;
        ArrayDecoders.Registers r7 = registers;
        checkMutable(r1);
        Unsafe unsafe = UNSAFE;
        int tag = 0;
        int fieldType = 0;
        int wireType = 0;
        int oldNumber = -1;
        int pos = 1048575;
        int position2 = position;
    L3:
        if (position2 >= endTag) goto L144;
        int position3 = position2 + 1;
        int tag2 = r2[position2];
        if (tag2 >= 0) goto L7;
        int position4 = ArrayDecoders.decodeVarint32(tag2, r2, position3, r7);
        int tag3 = r7.int1;
        int position5 = tag3;
        int tag4 = position4;
    L8:
        int number = position5 >>> 3;
        int wireType2 = position5 & 7;
        if (number <= oldNumber) goto L11;
        int r34 = 1048575;
        int pos2 = r0.positionForFieldNumber(number, fieldType / 3);
        int pos3 = pos2;
    L12:
        oldNumber = number;
        if (pos3 == (-1)) goto L14;
        int typeAndOffset = r0.buffer[pos3 + 1];
        int fieldType2 = type(typeAndOffset);
        long fieldOffset = offset(typeAndOffset);
        int position6 = tag4;
        if (fieldType2 <= 17) goto L17;
        Unsafe unsafe2 = unsafe;
        int currentPresenceField = wireType;
        int tag5 = position5;
        if (fieldType2 == 27) goto L102;
        int currentPresenceFieldOffset = pos;
        int currentPresenceFieldOffset2 = pos3;
        int tag6 = position6;
        if (fieldType2 <= 49) goto L114;
        Unsafe unsafe3 = unsafe2;
        int wireType3 = tag5;
        if (fieldType2 == 50) goto L121;
        int tag7 = wireType3;
        position2 = parseOneofField(message, data, tag6, limit, tag7, number, wireType2, typeAndOffset, fieldType2, fieldOffset, currentPresenceFieldOffset2, registers);
        MessageSchema<T> r9 = this;
        r7 = registers;
        if (position2 == tag6) goto L130;
        r1 = message;
        r2 = data;
        endTag = limit;
        tag = tag7;
        fieldType = currentPresenceFieldOffset2;
        r0 = r9;
        pos = currentPresenceFieldOffset;
        wireType = currentPresenceField;
        unsafe = unsafe3;
        goto L3
    L130:
        int position7 = position2;
        fieldType = currentPresenceFieldOffset2;
        pos = currentPresenceFieldOffset;
    L131:
        int r15 = endGroup;
        if (tag7 != r15) goto L136;
        if (r15 == 0) goto L136;
        T r8 = message;
        int r12 = limit;
        int tag8 = position7;
        int wireType4 = pos;
        int currentPresenceFieldOffset3 = tag7;
        int pos4 = currentPresenceField;
    L146:
        if (wireType4 == 1048575) goto L149;
        unsafe3.putInt(r8, wireType4, pos4);
    L149:
        UnknownFieldSetLite unknownFields = null;
        int i = r9.checkInitializedCount;
    L151:
        if (i >= r9.repeatedFieldOffsetStart) goto L153;
        T r3 = r8;
        int i2 = i;
        unknownFields = (UnknownFieldSetLite) r9.filterMapUnknownEnumValues(r3, r9.intArray[i], unknownFields, r9.unknownFieldSchema, message);
        int r4 = i2 + 1;
        r8 = r3;
        i = r4;
        goto L151
    L153:
        T r5 = r8;
        MessageSchema<T> r6 = r9;
        if (unknownFields == null) goto L156;
        r6.unknownFieldSchema.setBuilderToMessage(r5, unknownFields);
    L156:
        if (r15 != 0) goto L161;
        if (tag8 != r12) goto L160;
    L163:
        return tag8;
    L160:
        throw InvalidProtocolBufferException.parseFailure();
    L161:
        if (tag8 > r12) goto L165;
        if (currentPresenceFieldOffset3 == r15) goto L163;
    L165:
        throw InvalidProtocolBufferException.parseFailure();
    L136:
        if (r9.hasExtensions == false) goto L142;
        if (r7.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) goto L142;
        int tag9 = tag7;
        int position8 = ArrayDecoders.decodeExtensionOrUnknownField(tag9, data, position7, limit, message, r9.defaultInstance, r9.unknownFieldSchema, r7);
        message = message;
        int r13 = limit;
    L143:
        position2 = position8;
        r2 = data;
        tag = tag9;
        r1 = message;
        r0 = r9;
        endTag = r13;
        wireType = currentPresenceField;
        unsafe = unsafe3;
        r7 = registers;
    L142:
        tag9 = tag7;
        position8 = ArrayDecoders.decodeUnknownField(tag9, data, position7, limit, getMutableUnknownFields(message), registers);
        r13 = limit;
        goto L143
    L121:
        if (wireType2 != 2) goto L126;
        position2 = parseMapField(message, data, tag6, limit, currentPresenceFieldOffset2, fieldOffset, registers);
        if (position2 == tag6) goto L125;
        r0 = this;
        r1 = message;
        r2 = data;
        endTag = limit;
        r7 = registers;
        fieldType = currentPresenceFieldOffset2;
        tag = wireType3;
        pos = currentPresenceFieldOffset;
        wireType = currentPresenceField;
        unsafe = unsafe3;
        goto L3
    L125:
        r7 = registers;
        position7 = position2;
        fieldType = currentPresenceFieldOffset2;
        tag7 = wireType3;
        pos = currentPresenceFieldOffset;
        r9 = this;
    L126:
        r7 = registers;
        position7 = tag6;
        fieldType = currentPresenceFieldOffset2;
        tag7 = wireType3;
        pos = currentPresenceFieldOffset;
        r9 = this;
        goto L131
    L114:
        unsafe3 = unsafe2;
        position2 = r0.parseRepeatedField(message, data, tag6, limit, tag5, number, wireType2, currentPresenceFieldOffset2, typeAndOffset, fieldType2, fieldOffset, registers);
        if (position2 == tag6) goto L117;
        r0 = this;
        r1 = message;
        r2 = data;
        endTag = limit;
        r7 = registers;
        fieldType = currentPresenceFieldOffset2;
        tag = tag5;
        pos = currentPresenceFieldOffset;
        wireType = currentPresenceField;
        unsafe = unsafe3;
        goto L3
    L117:
        r7 = registers;
        position7 = position2;
        fieldType = currentPresenceFieldOffset2;
        tag7 = tag5;
        pos = currentPresenceFieldOffset;
        r9 = this;
        goto L131
    L102:
        if (wireType2 != 2) goto L111;
        Internal.ProtobufList<?> list = (Internal.ProtobufList) unsafe2.getObject(r1, fieldOffset);
        if (list.isModifiable() == true) goto L110;
        int size = list.size();
        if (size != 0) goto L108;
        int r14 = 10;
    L109:
        list = list.mutableCopyWithCapacity(r14);
        unsafe2.putObject(r1, fieldOffset, list);
        goto L110
    L108:
        r14 = size * 2;
    L110:
        int currentPresenceFieldOffset4 = pos;
        int currentPresenceFieldOffset5 = pos3;
        r7 = registers;
        r2 = data;
        endTag = limit;
        position2 = ArrayDecoders.decodeMessageList(r0.getMessageFieldSchema(pos3), tag5, data, position6, limit, list, r7);
        tag = tag5;
        fieldType = currentPresenceFieldOffset5;
        unsafe = unsafe2;
        pos = currentPresenceFieldOffset4;
        wireType = currentPresenceField;
        r1 = message;
        goto L3
    L111:
        currentPresenceFieldOffset = pos;
        currentPresenceFieldOffset2 = pos3;
        tag6 = position6;
        unsafe3 = unsafe2;
        wireType3 = tag5;
        goto L126
    L17:
        int presenceMaskAndOffset = r0.buffer[pos3 + 2];
        int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
        int presenceFieldOffset = presenceMaskAndOffset & r34;
        if (presenceFieldOffset != pos) goto L20;
        currentPresenceField = wireType;
        int currentPresenceField2 = pos;
    L25:
        switch(fieldType2) {
            case 0: goto L94;
            case 1: goto L90;
            case 2: goto L86;
            case 3: goto L86;
            case 4: goto L82;
            case 5: goto L78;
            case 6: goto L74;
            case 7: goto L66;
            case 8: goto L58;
            case 9: goto L54;
            case 10: goto L50;
            case 11: goto L82;
            case 12: goto L39;
            case 13: goto L74;
            case 14: goto L78;
            case 15: goto L35;
            case 16: goto L31;
            case 17: goto L28;
            default: goto L26;
        };
    L26:
        Unsafe unsafe4 = unsafe;
        int position9 = position6;
        int wireType5 = wireType2;
        int position10 = currentPresenceField2;
    L98:
        r7 = registers;
        unsafe3 = unsafe4;
        tag7 = position5;
        fieldType = pos3;
        position7 = position9;
        pos = position10;
        r9 = r0;
        goto L131
    L31:
        ArrayDecoders.Registers r10 = r7;
        Unsafe unsafe5 = unsafe;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 0) goto L34;
        int position11 = ArrayDecoders.decodeVarint64(data, position6, r10);
        T r11 = r1;
        unsafe5.putLong(r11, fieldOffset, CodedInputStream.decodeZigZag64(r10.long1));
        r1 = r11;
        endTag = limit;
        unsafe = unsafe5;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        r7 = r10;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        position2 = position11;
        goto L3
    L34:
        unsafe4 = unsafe5;
        position9 = position6;
        goto L98
    L35:
        ArrayDecoders.Registers r16 = r7;
        unsafe4 = unsafe;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 0) goto L38;
        position2 = ArrayDecoders.decodeVarint32(data, position6, r16);
        unsafe4.putInt(r1, fieldOffset, CodedInputStream.decodeZigZag32(r16.int1));
        endTag = limit;
        unsafe = unsafe4;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        r7 = r16;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        goto L3
    L38:
        position9 = position6;
        goto L98
    L39:
        ArrayDecoders.Registers r17 = r7;
        unsafe4 = unsafe;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 0) goto L49;
        int position12 = ArrayDecoders.decodeVarint32(data, position6, r17);
        int enumValue = r17.int1;
        Internal.EnumVerifier enumVerifier = r0.getEnumFieldVerifier(pos3);
        if (enumVerifier == null) goto L48;
        if (enumVerifier.isInRange(enumValue) == true) goto L48;
        getMutableUnknownFields(r1).storeField(position5, Long.valueOf(enumValue));
        position2 = position12;
        endTag = limit;
        unsafe = unsafe4;
        r2 = data;
        r7 = r17;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        wireType = currentPresenceField;
    L48:
        unsafe4.putInt(r1, fieldOffset, enumValue);
        endTag = limit;
        unsafe = unsafe4;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        r7 = r17;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        position2 = position12;
        goto L3
    L49:
        position9 = position6;
        goto L98
    L50:
        ArrayDecoders.Registers r18 = r7;
        unsafe4 = unsafe;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 2) goto L53;
        position2 = ArrayDecoders.decodeBytes(data, position6, r18);
        unsafe4.putObject(r1, fieldOffset, r18.object1);
        endTag = limit;
        unsafe = unsafe4;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        r7 = r18;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        goto L3
    L53:
        position9 = position6;
        goto L98
    L54:
        ArrayDecoders.Registers r19 = r7;
        Unsafe unsafe6 = unsafe;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 2) goto L57;
        T r20 = r1;
        Object current = r0.mutableMessageFieldForMerge(r20, pos3);
        int position13 = ArrayDecoders.mergeMessageField(current, r0.getMessageFieldSchema(pos3), data, position6, limit, r19);
        r0.storeMessageField(r20, pos3, current);
        position2 = position13;
        wireType = currentPresenceField | presenceMask;
        unsafe = unsafe6;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        r2 = data;
        r1 = r20;
        r7 = r19;
        endTag = limit;
        goto L3
    L57:
        position9 = position6;
        unsafe4 = unsafe6;
        goto L98
    L58:
        ArrayDecoders.Registers r21 = r7;
        Unsafe unsafe7 = unsafe;
        T r22 = r1;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 2) goto L65;
        if ((536870912 & typeAndOffset) != 0) goto L63;
        int position14 = ArrayDecoders.decodeString(data, position6, r21);
    L64:
        position2 = position14;
        unsafe7.putObject(r22, fieldOffset, r21.object1);
        wireType = currentPresenceField | presenceMask;
        unsafe = unsafe7;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        r2 = data;
        r1 = r22;
        r7 = r21;
        endTag = limit;
        goto L3
    L63:
        position14 = ArrayDecoders.decodeStringRequireUtf8(data, position6, r21);
        goto L64
    L65:
        position9 = position6;
        unsafe4 = unsafe7;
        goto L98
    L66:
        ArrayDecoders.Registers r23 = r7;
        Unsafe unsafe8 = unsafe;
        T r24 = r1;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 0) goto L73;
        position2 = ArrayDecoders.decodeVarint64(data, position6, r23);
        if (r23.long1 == 0) goto L71;
        boolean r25 = true;
    L72:
        UnsafeUtil.putBoolean(r24, fieldOffset, r25);
        wireType = currentPresenceField | presenceMask;
        unsafe = unsafe8;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        r2 = data;
        r1 = r24;
        r7 = r23;
        endTag = limit;
        goto L3
    L71:
        r25 = false;
        goto L72
    L73:
        position9 = position6;
        unsafe4 = unsafe8;
        goto L98
    L74:
        ArrayDecoders.Registers r26 = r7;
        Unsafe unsafe9 = unsafe;
        T r27 = r1;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 5) goto L77;
        unsafe9.putInt(r27, fieldOffset, ArrayDecoders.decodeFixed32(data, position6));
        position2 = position6 + 4;
        int position15 = currentPresenceField | presenceMask;
        wireType = position15;
        unsafe = unsafe9;
        fieldType = pos3;
        tag = position5;
        pos = position10;
        r2 = data;
        r1 = r27;
        r7 = r26;
        endTag = limit;
        goto L3
    L77:
        position9 = position6;
        unsafe4 = unsafe9;
        goto L98
    L78:
        ArrayDecoders.Registers r28 = r7;
        Unsafe unsafe10 = unsafe;
        T r29 = r1;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 1) goto L81;
        unsafe10.putLong(r29, fieldOffset, ArrayDecoders.decodeFixed64(data, position6));
        r1 = r29;
        endTag = limit;
        unsafe = unsafe10;
        position2 = position6 + 8;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        fieldType = pos3;
        tag = position5;
        r7 = r28;
        pos = position10;
        goto L3
    L81:
        position9 = position6;
        unsafe4 = unsafe10;
        goto L98
    L82:
        unsafe4 = unsafe;
        position9 = position6;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        ArrayDecoders.Registers r110 = r7;
        if (wireType5 != 0) goto L98;
        int position16 = ArrayDecoders.decodeVarint32(data, position9, r110);
        unsafe4.putInt(r1, fieldOffset, r110.int1);
        endTag = limit;
        unsafe = unsafe4;
        position2 = position16;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        fieldType = pos3;
        tag = position5;
        r7 = r110;
        pos = position10;
        goto L3
    L86:
        unsafe4 = unsafe;
        position9 = position6;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        ArrayDecoders.Registers r111 = r7;
        if (wireType5 != 0) goto L98;
        int position17 = ArrayDecoders.decodeVarint64(data, position9, r111);
        T r30 = r1;
        unsafe4.putLong(r30, fieldOffset, r111.long1);
        r1 = r30;
        endTag = limit;
        unsafe = unsafe4;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        position2 = position17;
        fieldType = pos3;
        tag = position5;
        r7 = r111;
        pos = position10;
        goto L3
    L90:
        unsafe4 = unsafe;
        position9 = position6;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        ArrayDecoders.Registers r112 = r7;
        if (wireType5 != 5) goto L98;
        UnsafeUtil.putFloat(r1, fieldOffset, ArrayDecoders.decodeFloat(data, position9));
        position2 = position9 + 4;
        endTag = limit;
        unsafe = unsafe4;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        fieldType = pos3;
        tag = position5;
        r7 = r112;
        pos = position10;
        goto L3
    L94:
        unsafe4 = unsafe;
        position9 = position6;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        if (wireType5 != 1) goto L98;
        int tag10 = position5;
        UnsafeUtil.putDouble(r1, fieldOffset, ArrayDecoders.decodeDouble(data, position9));
        tag = tag10;
        position2 = position9 + 8;
        endTag = limit;
        unsafe = unsafe4;
        r2 = data;
        wireType = currentPresenceField | presenceMask;
        fieldType = pos3;
        pos = position10;
        r7 = registers;
        goto L3
    L28:
        if (wireType2 != 3) goto L30;
        Object current2 = r0.mutableMessageFieldForMerge(r1, pos3);
        int endTag2 = (number << 3) | 4;
        int currentPresenceFieldOffset6 = currentPresenceField2;
        position2 = ArrayDecoders.mergeGroupField(current2, r0.getMessageFieldSchema(pos3), data, position6, limit, endTag2, registers);
        r0.storeMessageField(r1, pos3, current2);
        endTag = limit;
        wireType = currentPresenceField | presenceMask;
        r2 = data;
        r7 = registers;
        fieldType = pos3;
        tag = position5;
        pos = currentPresenceFieldOffset6;
        unsafe = unsafe;
        goto L3
    L30:
        Unsafe unsafe11 = unsafe;
        wireType5 = wireType2;
        position10 = currentPresenceField2;
        position9 = position6;
        unsafe4 = unsafe11;
        goto L98
    L20:
        if (pos == r34) goto L22;
        unsafe.putInt(r1, pos, wireType);
    L22:
        currentPresenceField = unsafe.getInt(r1, presenceFieldOffset);
        currentPresenceField2 = presenceFieldOffset;
        goto L25
    L14:
        position7 = tag4;
        fieldType = 0;
        unsafe3 = unsafe;
        currentPresenceField = wireType;
        tag7 = position5;
        r9 = r0;
        goto L131
    L11:
        r34 = 1048575;
        int pos5 = r0.positionForFieldNumber(number);
        pos3 = pos5;
        goto L12
    L7:
        position5 = tag2;
        tag4 = position3;
        goto L8
    L144:
        r15 = endGroup;
        r8 = r1;
        r12 = endTag;
        int currentPresenceFieldOffset7 = pos;
        unsafe3 = unsafe;
        int currentPresenceField3 = wireType;
        r9 = r0;
        currentPresenceFieldOffset3 = tag;
        wireType4 = currentPresenceFieldOffset7;
        tag8 = position2;
        pos4 = currentPresenceField3;
        goto L146
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T message, int pos) {
        Schema r0 = getMessageFieldSchema(pos);
        long offset = offset(typeAndOffsetAt(pos));
        if (isFieldPresent(message, pos) == false) goto L5;
        Object current = UNSAFE.getObject(message, offset);
        if (isMutable(current) == false) goto L9;
        return current;
    L9:
        Object newMessage = r0.newInstance();
        if (current == null) goto L12;
        r0.mergeFrom(newMessage, current);
    L12:
        return newMessage;
    L5:
        return r0.newInstance();
    }

    private void storeMessageField(T message, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setFieldPresent(message, pos);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T message, int fieldNumber, int pos) {
        Schema r0 = getMessageFieldSchema(pos);
        if (isOneofPresent(message, fieldNumber, pos) == false) goto L5;
        Object current = UNSAFE.getObject(message, offset(typeAndOffsetAt(pos)));
        if (isMutable(current) == false) goto L9;
        return current;
    L9:
        Object newMessage = r0.newInstance();
        if (current == null) goto L12;
        r0.mergeFrom(newMessage, current);
    L12:
        return newMessage;
    L5:
        return r0.newInstance();
    }

    private void storeOneofMessageField(T message, int fieldNumber, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setOneofPresent(message, fieldNumber, pos);
    }

    private int parseProto3Message(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        MessageSchema<T> r0 = this;
        T r1 = message;
        byte[] r7 = data;
        int position2 = limit;
        ArrayDecoders.Registers r13 = registers;
        checkMutable(r1);
        Unsafe unsafe = UNSAFE;
        int oldNumber = -1;
        int currentPresenceField = 0;
        int currentPresenceField2 = 0;
        int currentPresenceFieldOffset = 1048575;
        int position3 = position;
    L3:
        if (position3 >= position2) goto L124;
        int position4 = position3 + 1;
        int tag = r7[position3];
        if (tag >= 0) goto L7;
        int position5 = ArrayDecoders.decodeVarint32(tag, r7, position4, r13);
        int position6 = r13.int1;
        int tag2 = position5;
    L8:
        int number = position6 >>> 3;
        int wireType = position6 & 7;
        if (number <= oldNumber) goto L11;
        int pos = r0.positionForFieldNumber(number, currentPresenceField2 / 3);
    L12:
        oldNumber = number;
        if (pos == (-1)) goto L14;
        int typeAndOffset = r0.buffer[pos + 1];
        int tag3 = position6;
        int fieldType = type(typeAndOffset);
        long fieldOffset = offset(typeAndOffset);
        if (fieldType <= 17) goto L17;
        int position7 = tag2;
        int fieldType2 = pos;
        T r12 = r1;
        Unsafe unsafe2 = unsafe;
        if (fieldType == 27) goto L92;
        int position8 = position7;
        if (fieldType <= 49) goto L106;
        int pos2 = fieldType2;
        Unsafe unsafe3 = unsafe2;
        int currentPresenceField3 = currentPresenceField;
        int wireType2 = wireType;
        int typeAndOffset2 = number;
        int currentPresenceField4 = tag3;
        int number2 = currentPresenceFieldOffset;
        if (fieldType == 50) goto L113;
        int tag4 = currentPresenceField4;
        position3 = parseOneofField(message, data, position8, limit, tag4, typeAndOffset2, wireType2, typeAndOffset, fieldType, fieldOffset, pos2, registers);
        pos2 = pos2;
        T r14 = message;
        if (position3 == position8) goto L122;
        r0 = this;
        r7 = data;
        position2 = limit;
        r13 = registers;
        currentPresenceField2 = pos2;
        r1 = r14;
        currentPresenceFieldOffset = number2;
        currentPresenceField = currentPresenceField3;
        unsafe = unsafe3;
        goto L3
    L122:
        int position9 = position3;
        currentPresenceFieldOffset = number2;
        currentPresenceField = currentPresenceField3;
    L123:
        int position10 = ArrayDecoders.decodeUnknownField(tag4, data, position9, limit, getMutableUnknownFields(r14), registers);
        position2 = limit;
        r0 = this;
        r7 = data;
        r13 = registers;
        position3 = position10;
        currentPresenceField2 = pos2;
        r1 = r14;
        unsafe = unsafe3;
        goto L3
    L113:
        if (wireType2 != 2) goto L118;
        position3 = parseMapField(message, data, position8, limit, pos2, fieldOffset, registers);
        if (position3 == position8) goto L117;
        r0 = this;
        r1 = message;
        r7 = data;
        position2 = limit;
        r13 = registers;
        currentPresenceField2 = pos2;
        currentPresenceFieldOffset = number2;
        currentPresenceField = currentPresenceField3;
        unsafe = unsafe3;
        goto L3
    L117:
        position9 = position3;
        tag4 = currentPresenceField4;
        currentPresenceFieldOffset = number2;
        currentPresenceField = currentPresenceField3;
        r14 = message;
    L118:
        position9 = position8;
        tag4 = currentPresenceField4;
        currentPresenceFieldOffset = number2;
        currentPresenceField = currentPresenceField3;
        r14 = message;
        goto L123
    L106:
        int currentPresenceField5 = currentPresenceField;
        unsafe3 = unsafe2;
        int number3 = currentPresenceFieldOffset;
        position3 = r0.parseRepeatedField(r12, data, position8, limit, tag3, number, wireType, fieldType2, typeAndOffset, fieldType, fieldOffset, registers);
        pos2 = fieldType2;
        if (position3 == position8) goto L109;
        r0 = this;
        r1 = message;
        r7 = data;
        position2 = limit;
        r13 = registers;
        currentPresenceField2 = pos2;
        currentPresenceFieldOffset = number3;
        currentPresenceField = currentPresenceField5;
        unsafe = unsafe3;
        goto L3
    L109:
        position9 = position3;
        tag4 = tag3;
        currentPresenceFieldOffset = number3;
        currentPresenceField = currentPresenceField5;
        r14 = message;
        goto L123
    L92:
        if (wireType != 2) goto L103;
        Internal.ProtobufList<?> list = (Internal.ProtobufList) unsafe2.getObject(r12, fieldOffset);
        if (list.isModifiable() == true) goto L102;
        int size = list.size();
        if (size != 0) goto L99;
        int fieldType3 = 10;
    L100:
        list = list.mutableCopyWithCapacity(fieldType3);
        unsafe2.putObject(r12, fieldOffset, list);
        goto L102
    L99:
        fieldType3 = size * 2;
    L102:
        int position11 = ArrayDecoders.decodeMessageList(r0.getMessageFieldSchema(fieldType2), tag3, r7, position7, limit, list, r13);
        r7 = data;
        position3 = position11;
        unsafe = unsafe2;
        r1 = r12;
        currentPresenceField2 = fieldType2;
        position2 = limit;
        r13 = registers;
        goto L3
    L103:
        position8 = position7;
        unsafe3 = unsafe2;
        currentPresenceField3 = currentPresenceField;
        pos2 = fieldType2;
        wireType2 = wireType;
        typeAndOffset2 = number;
        currentPresenceField4 = tag3;
        number2 = currentPresenceFieldOffset;
        goto L118
    L17:
        int presenceMaskAndOffset = r0.buffer[pos + 2];
        int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
        int presenceFieldOffset = presenceMaskAndOffset & 1048575;
        if (presenceFieldOffset != currentPresenceFieldOffset) goto L20;
        fieldType = fieldType;
    L29:
        switch(fieldType) {
            case 0: goto L85;
            case 1: goto L82;
            case 2: goto L78;
            case 3: goto L78;
            case 4: goto L74;
            case 5: goto L70;
            case 6: goto L66;
            case 7: goto L58;
            case 8: goto L50;
            case 9: goto L46;
            case 10: goto L42;
            case 11: goto L74;
            case 12: goto L38;
            case 13: goto L66;
            case 14: goto L70;
            case 15: goto L34;
            case 16: goto L31;
            default: goto L30;
        };
    L30:
        int position12 = tag2;
        pos2 = pos;
        r14 = r1;
        Unsafe unsafe4 = unsafe;
        int number4 = number;
    L88:
        unsafe3 = unsafe4;
        position9 = position12;
        tag4 = tag3;
        goto L123
    L34:
        pos2 = pos;
        if (wireType != 0) goto L37;
        position3 = ArrayDecoders.decodeVarint32(r7, tag2, r13);
        unsafe.putInt(r1, fieldOffset, CodedInputStream.decodeZigZag32(r13.int1));
        currentPresenceField = currentPresenceField | presenceMask;
        currentPresenceField2 = pos2;
        goto L3
    L37:
        position12 = tag2;
        number4 = number;
        r14 = r1;
        unsafe4 = unsafe;
        goto L88
    L38:
        pos2 = pos;
        if (wireType != 0) goto L41;
        position3 = ArrayDecoders.decodeVarint32(r7, tag2, r13);
        unsafe.putInt(r1, fieldOffset, r13.int1);
        currentPresenceField = currentPresenceField | presenceMask;
        currentPresenceField2 = pos2;
        goto L3
    L41:
        position12 = tag2;
        number4 = number;
        r14 = r1;
        unsafe4 = unsafe;
        goto L88
    L42:
        pos2 = pos;
        if (wireType != 2) goto L45;
        position3 = ArrayDecoders.decodeBytes(r7, tag2, r13);
        unsafe.putObject(r1, fieldOffset, r13.object1);
        currentPresenceField = currentPresenceField | presenceMask;
        currentPresenceField2 = pos2;
        goto L3
    L45:
        position12 = tag2;
        number4 = number;
        r14 = r1;
        unsafe4 = unsafe;
        goto L88
    L46:
        pos2 = pos;
        if (wireType != 2) goto L49;
        T r6 = r1;
        Object current = r0.mutableMessageFieldForMerge(r6, pos2);
        Unsafe unsafe5 = unsafe;
        int position13 = tag2;
        byte[] r3 = r7;
        ArrayDecoders.Registers r8 = r13;
        int position14 = ArrayDecoders.mergeMessageField(current, r0.getMessageFieldSchema(pos2), r3, position13, position2, r8);
        r0.storeMessageField(r6, pos2, current);
        currentPresenceField = currentPresenceField | presenceMask;
        r7 = r3;
        r1 = r6;
        r13 = r8;
        currentPresenceField2 = pos2;
        position3 = position14;
        unsafe = unsafe5;
        position2 = limit;
        goto L3
    L49:
        T r9 = r1;
        Unsafe unsafe6 = unsafe;
        int position15 = tag2;
        number4 = number;
        unsafe4 = unsafe6;
        position12 = position15;
        r14 = r9;
        goto L88
    L50:
        byte[] r10 = r7;
        T r11 = r1;
        Unsafe unsafe7 = unsafe;
        int position16 = tag2;
        pos2 = pos;
        ArrayDecoders.Registers r4 = r13;
        number4 = number;
        if (wireType != 2) goto L57;
        if ((536870912 & typeAndOffset) != 0) goto L55;
        int position17 = ArrayDecoders.decodeString(r10, position16, r4);
    L56:
        unsafe7.putObject(r11, fieldOffset, r4.object1);
        currentPresenceField = currentPresenceField | presenceMask;
        r7 = r10;
        r1 = r11;
        r13 = r4;
        currentPresenceField2 = pos2;
        position3 = position17;
        unsafe = unsafe7;
        position2 = limit;
        goto L3
    L55:
        position17 = ArrayDecoders.decodeStringRequireUtf8(r10, position16, r4);
        goto L56
    L57:
        unsafe4 = unsafe7;
        position12 = position16;
        r14 = r11;
        goto L88
    L58:
        byte[] r15 = r7;
        T r16 = r1;
        Unsafe unsafe8 = unsafe;
        int position18 = tag2;
        pos2 = pos;
        ArrayDecoders.Registers r5 = r13;
        number4 = number;
        if (wireType != 0) goto L65;
        int position19 = ArrayDecoders.decodeVarint64(r15, position18, r5);
        if (r5.long1 == 0) goto L63;
        boolean r17 = true;
    L64:
        UnsafeUtil.putBoolean(r16, fieldOffset, r17);
        currentPresenceField = currentPresenceField | presenceMask;
        r7 = r15;
        r1 = r16;
        r13 = r5;
        currentPresenceField2 = pos2;
        position3 = position19;
        unsafe = unsafe8;
        position2 = limit;
        goto L3
    L63:
        r17 = false;
        goto L64
    L65:
        unsafe4 = unsafe8;
        position12 = position18;
        r14 = r16;
        goto L88
    L66:
        byte[] r18 = r7;
        T r19 = r1;
        Unsafe unsafe9 = unsafe;
        int position20 = tag2;
        pos2 = pos;
        ArrayDecoders.Registers r20 = r13;
        number4 = number;
        if (wireType != 5) goto L69;
        unsafe9.putInt(r19, fieldOffset, ArrayDecoders.decodeFixed32(r18, position20));
        currentPresenceField = currentPresenceField | presenceMask;
        r7 = r18;
        r1 = r19;
        r13 = r20;
        currentPresenceField2 = pos2;
        position3 = position20 + 4;
        unsafe = unsafe9;
        position2 = limit;
        goto L3
    L69:
        unsafe4 = unsafe9;
        position12 = position20;
        r14 = r19;
        goto L88
    L70:
        byte[] r21 = r7;
        T r22 = r1;
        Unsafe unsafe10 = unsafe;
        int position21 = tag2;
        pos2 = pos;
        ArrayDecoders.Registers r23 = r13;
        number4 = number;
        if (wireType != 1) goto L73;
        r7 = r21;
        r13 = r23;
        unsafe10.putLong(r22, fieldOffset, ArrayDecoders.decodeFixed64(r21, position21));
        unsafe = unsafe10;
        r1 = r22;
        currentPresenceField = currentPresenceField | presenceMask;
        position2 = limit;
        position3 = position21 + 8;
        currentPresenceField2 = pos2;
        goto L3
    L73:
        position12 = position21;
        r14 = r22;
        unsafe4 = unsafe10;
        goto L88
    L74:
        position12 = tag2;
        pos2 = pos;
        number4 = number;
        if (wireType != 0) goto L77;
        int position22 = ArrayDecoders.decodeVarint32(r7, position12, r13);
        unsafe.putInt(r1, fieldOffset, r13.int1);
        currentPresenceField = currentPresenceField | presenceMask;
        position2 = limit;
        position3 = position22;
        currentPresenceField2 = pos2;
        goto L3
    L77:
        r14 = r1;
        unsafe4 = unsafe;
        goto L88
    L78:
        position12 = tag2;
        pos2 = pos;
        number4 = number;
        if (wireType != 0) goto L81;
        int position23 = ArrayDecoders.decodeVarint64(r7, position12, r13);
        Unsafe unsafe11 = unsafe;
        T r2 = r1;
        unsafe11.putLong(r2, fieldOffset, r13.long1);
        currentPresenceField = currentPresenceField | presenceMask;
        unsafe = unsafe11;
        position3 = position23;
        currentPresenceField2 = pos2;
        r1 = r2;
        position2 = limit;
        goto L3
    L81:
        r14 = r1;
        unsafe4 = unsafe;
        goto L88
    L82:
        position12 = tag2;
        pos2 = pos;
        r14 = r1;
        unsafe4 = unsafe;
        number4 = number;
        if (wireType != 5) goto L88;
        UnsafeUtil.putFloat(r14, fieldOffset, ArrayDecoders.decodeFloat(r7, position12));
        int position24 = position12 + 4;
        currentPresenceField = currentPresenceField | presenceMask;
        position2 = limit;
        unsafe = unsafe4;
        position3 = position24;
        currentPresenceField2 = pos2;
        r1 = r14;
        goto L3
    L85:
        position12 = tag2;
        pos2 = pos;
        r14 = r1;
        unsafe4 = unsafe;
        number4 = number;
        if (wireType != 1) goto L88;
        UnsafeUtil.putDouble(r14, fieldOffset, ArrayDecoders.decodeDouble(r7, position12));
        int position25 = position12 + 8;
        currentPresenceField = currentPresenceField | presenceMask;
        position2 = limit;
        unsafe = unsafe4;
        position3 = position25;
        currentPresenceField2 = pos2;
        r1 = r14;
        goto L3
    L31:
        if (wireType != 0) goto L33;
        int position26 = ArrayDecoders.decodeVarint64(r7, tag2, r13);
        Unsafe unsafe12 = unsafe;
        unsafe12.putLong(message, fieldOffset, CodedInputStream.decodeZigZag64(r13.long1));
        unsafe = unsafe12;
        r1 = message;
        currentPresenceField = currentPresenceField | presenceMask;
        currentPresenceField2 = pos;
        position3 = position26;
        goto L3
    L33:
        pos2 = pos;
        position12 = tag2;
        number4 = number;
        r14 = r1;
        unsafe4 = unsafe;
        goto L88
    L20:
        if (currentPresenceFieldOffset == 1048575) goto L24;
        unsafe.putInt(r1, currentPresenceFieldOffset, currentPresenceField);
    L24:
        if (presenceFieldOffset == 1048575) goto L26;
        currentPresenceField = unsafe.getInt(r1, presenceFieldOffset);
    L26:
        currentPresenceFieldOffset = presenceFieldOffset;
        goto L29
    L14:
        unsafe3 = unsafe;
        position9 = tag2;
        tag4 = position6;
        r14 = r1;
        pos2 = 0;
        goto L123
    L11:
        pos = r0.positionForFieldNumber(number);
        goto L12
    L7:
        position6 = tag;
        tag2 = position4;
        goto L8
    L124:
        T r110 = r1;
        Unsafe unsafe13 = unsafe;
        int currentPresenceField6 = currentPresenceField;
        if (currentPresenceFieldOffset == 1048575) goto L128;
        unsafe13.putInt(r110, currentPresenceFieldOffset, currentPresenceField6);
    L128:
        if (position3 != position2) goto L131;
        return position3;
    L131:
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.bytedance.location.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3 == false) goto L5;
        parseProto3Message(message, data, position, limit, registers);
        return;
    L5:
        parseProto2Message(message, data, position, limit, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.location.protobuf.Schema
    public void makeImmutable(T r9) {
        if (isMutable(r9) == true) goto L6;
        return;
    L6:
        if ((r9 instanceof GeneratedMessageLite) == false) goto L8;
        GeneratedMessageLite<?, ?> generatedMessage = (GeneratedMessageLite) r9;
        generatedMessage.clearMemoizedSerializedSize();
        generatedMessage.clearMemoizedHashCode();
        generatedMessage.markImmutable();
    L8:
        int bufferLength = this.buffer.length;
        int pos = 0;
    L9:
        if (pos >= bufferLength) goto L21;
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        switch(type(typeAndOffset)) {
            case 9: goto L18;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            case 13: goto L20;
            case 14: goto L20;
            case 15: goto L20;
            case 16: goto L20;
            case 17: goto L18;
            case 18: goto L16;
            case 19: goto L16;
            case 20: goto L16;
            case 21: goto L16;
            case 22: goto L16;
            case 23: goto L16;
            case 24: goto L16;
            case 25: goto L16;
            case 26: goto L16;
            case 27: goto L16;
            case 28: goto L16;
            case 29: goto L16;
            case 30: goto L16;
            case 31: goto L16;
            case 32: goto L16;
            case 33: goto L16;
            case 34: goto L16;
            case 35: goto L16;
            case 36: goto L16;
            case 37: goto L16;
            case 38: goto L16;
            case 39: goto L16;
            case 40: goto L16;
            case 41: goto L16;
            case 42: goto L16;
            case 43: goto L16;
            case 44: goto L16;
            case 45: goto L16;
            case 46: goto L16;
            case 47: goto L16;
            case 48: goto L16;
            case 49: goto L16;
            case 50: goto L13;
            default: goto L20;
        };
    L13:
        Object mapField = UNSAFE.getObject(r9, offset);
        if (mapField == null) goto L20;
        UNSAFE.putObject(r9, offset, this.mapFieldSchema.toImmutable(mapField));
        goto L20
    L16:
        this.listFieldSchema.makeImmutableListAt(r9, offset);
        goto L20
    L18:
        if (isFieldPresent(r9, pos) == false) goto L20;
        getMessageFieldSchema(pos).makeImmutable(UNSAFE.getObject(r9, offset));
    L20:
        pos = pos + 3;
        goto L9
    L21:
        this.unknownFieldSchema.makeImmutable(r9);
        if (this.hasExtensions == false) goto L32;
        this.extensionSchema.makeImmutable(r9);
        return;
    }

    private final <K, V> void mergeMap(Object message, int pos, Object mapDefaultEntry, ExtensionRegistryLite extensionRegistry, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(pos));
        Object mapField = UnsafeUtil.getObject(message, offset);
        if (mapField != null) goto L6;
        mapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
        UnsafeUtil.putObject(message, offset, mapField);
    L8:
        reader.readMap(this.mapFieldSchema.forMutableMapData(mapField), this.mapFieldSchema.forMapMetadata(mapDefaultEntry), extensionRegistry);
        return;
    L6:
        if (this.mapFieldSchema.isImmutable(mapField) == false) goto L8;
        mapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
        this.mapFieldSchema.mergeFrom(mapField, mapField);
        UnsafeUtil.putObject(message, offset, mapField);
        goto L8
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object r12, int r13, UB r14, UnknownFieldSchema<UT, UB> r15, Object r16) {
        int r2 = numberAt(r13);
        Object r10 = UnsafeUtil.getObject(r12, offset(typeAndOffsetAt(r13)));
        if (r10 != null) goto L5;
        return r14;
    L5:
        Internal.EnumVerifier r4 = getEnumFieldVerifier(r13);
        if (r4 != null) goto L9;
        return r14;
    L9:
        return (UB) filterUnknownEnumMap(r13, r2, this.mapFieldSchema.forMutableMapData(r10), r4, r14, r15, r16);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int r9, int r10, Map<K, V> r11, Internal.EnumVerifier r12, UB r13, UnknownFieldSchema<UT, UB> r14, Object r15) {
        MapEntryLite.Metadata<?, ?> r0 = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r9));
        Iterator<Map.Entry<K, V>> r1 = r11.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<K, V> r2 = r1.next();
        if (r12.isInRange(((Integer) r2.getValue()).intValue()) == true) goto L4;
        if (r13 != null) goto L9;
        r13 = r14.getBuilderFromMessage(r15);
    L9:
        ByteString.CodedBuilder r4 = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(r0, r2.getKey(), r2.getValue()));
        CodedOutputStream r5 = r4.getCodedOutput();
        MapEntryLite.writeTo(r5, r0, r2.getKey(), r2.getValue());     // Catch: IOException -> L12
        UB r16 = r13;
        r14.addLengthDelimited(r16, r10, r4.build());
        r1.remove();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        return r13;
    }

    @Override // com.bytedance.location.protobuf.Schema
    public final boolean isInitialized(T message) {
        int currentPresenceFieldOffset = 1048575;
        int currentPresenceFieldOffset2 = 0;
        int i = 0;
    L4:
        if (i >= this.checkInitializedCount) goto L38;
        int pos = this.intArray[i];
        int number = numberAt(pos);
        int typeAndOffset = typeAndOffsetAt(pos);
        int presenceMaskAndOffset = this.buffer[pos + 2];
        int presenceFieldOffset = presenceMaskAndOffset & 1048575;
        int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
        if (presenceFieldOffset != currentPresenceFieldOffset) goto L8;
        int r15 = currentPresenceFieldOffset2;
        int currentPresenceField = currentPresenceFieldOffset;
        int pos2 = r15;
    L13:
        if (isRequired(typeAndOffset) == false) goto L18;
        if (isFieldPresent(message, pos, currentPresenceField, pos2, presenceMask) == true) goto L18;
        return false;
    L18:
        switch(type(typeAndOffset)) {
            case 9: goto L32;
            case 17: goto L32;
            case 27: goto L29;
            case 49: goto L29;
            case 50: goto L26;
            case 60: goto L21;
            case 68: goto L21;
            default: goto L36;
        };
    L21:
        if (isOneofPresent(message, number, pos) == false) goto L36;
        if (isInitialized(message, typeAndOffset, getMessageFieldSchema(pos)) == true) goto L36;
        return false;
    L26:
        if (isMapInitialized(message, typeAndOffset, pos) == true) goto L36;
        return false;
    L29:
        if (isListInitialized(message, typeAndOffset, pos) == true) goto L36;
        return false;
    L32:
        if (isFieldPresent(message, pos, currentPresenceField, pos2, presenceMask) == false) goto L36;
        if (isInitialized(message, typeAndOffset, getMessageFieldSchema(pos)) == true) goto L36;
        return false;
    L36:
        i = i + 1;
        currentPresenceFieldOffset = currentPresenceField;
        currentPresenceFieldOffset2 = pos2;
        goto L4
    L8:
        if (presenceFieldOffset == 1048575) goto L10;
        int currentPresenceField2 = UNSAFE.getInt(message, presenceFieldOffset);
        currentPresenceField = presenceFieldOffset;
        pos2 = currentPresenceField2;
        goto L13
    L10:
        int r16 = currentPresenceFieldOffset2;
        currentPresenceField = presenceFieldOffset;
        pos2 = r16;
        goto L13
    L38:
        if (this.hasExtensions == true) goto L40;
    L42:
        return true;
    L40:
        if (this.extensionSchema.getExtensions(message).isInitialized() == true) goto L42;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object message, int typeAndOffset, Schema r4) {
        Object nested = UnsafeUtil.getObject(message, offset(typeAndOffset));
        return r4.isInitialized(nested);
    }

    private <N> boolean isListInitialized(Object message, int typeAndOffset, int pos) {
        List<N> list = (List) UnsafeUtil.getObject(message, offset(typeAndOffset));
        if (list.isEmpty() == false) goto L5;
        return true;
    L5:
        Schema schema = getMessageFieldSchema(pos);
        int i = 0;
    L7:
        if (i >= list.size()) goto L14;
        N nested = list.get(i);
        if (schema.isInitialized(nested) == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.location.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    private boolean isMapInitialized(T r10, int r11, int r12) {
        Map<?, ?> r0 = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(r10, offset(r11)));
        if (r0.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r1 = getMapFieldDefaultEntry(r12);
        if (this.mapFieldSchema.forMapMetadata(r1).valueType.getJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
        return true;
    L8:
        ?? r4 = 0;
        Iterator<?> r5 = r0.values().iterator();
    L10:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        r4 = r4;
        if (r4 != 0) goto L15;
        r4 = Protobuf.getInstance().schemaFor(r6.getClass());
    L15:
        if (r4.isInitialized(r6) == true) goto L10;
        return false;
    L19:
        return true;
    }

    private void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if ((value instanceof String) == false) goto L5;
        writer.writeString(fieldNumber, (String) value);
        return;
    L5:
        writer.writeBytes(fieldNumber, (ByteString) value);
    }

    private void readString(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset) == false) goto L6;
        UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readStringRequireUtf8());
        return;
    L6:
        if (this.lite == false) goto L8;
        UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readString());
        return;
    L8:
        UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readBytes());
    }

    private void readStringList(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset) == false) goto L5;
        reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        return;
    L5:
        reader.readStringList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
    }

    private <E> void readMessageList(Object message, int typeAndOffset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        long offset = offset(typeAndOffset);
        reader.readMessageList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private <E> void readGroupList(Object message, long offset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private int numberAt(int pos) {
        return this.buffer[pos];
    }

    private int typeAndOffsetAt(int pos) {
        return this.buffer[pos + 1];
    }

    private int presenceMaskAndOffsetAt(int pos) {
        return this.buffer[pos + 2];
    }

    private static int type(int value) {
        return (FIELD_TYPE_MASK & value) >>> 20;
    }

    private static boolean isRequired(int value) {
        if ((268435456 & value) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isEnforceUtf8(int value) {
        if ((536870912 & value) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static long offset(int value) {
        return 1048575 & value;
    }

    private static boolean isMutable(Object message) {
        if (message != null) goto L6;
        return false;
    L6:
        if ((message instanceof GeneratedMessageLite) == true) goto L8;
        return true;
    L8:
        return ((GeneratedMessageLite) message).isMutable();
    }

    private static void checkMutable(Object message) {
        if (isMutable(message) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Mutating immutable message: " + message);
    }

    private static <T> double doubleAt(T message, long offset) {
        return UnsafeUtil.getDouble(message, offset);
    }

    private static <T> float floatAt(T message, long offset) {
        return UnsafeUtil.getFloat(message, offset);
    }

    private static <T> int intAt(T message, long offset) {
        return UnsafeUtil.getInt(message, offset);
    }

    private static <T> long longAt(T message, long offset) {
        return UnsafeUtil.getLong(message, offset);
    }

    private static <T> boolean booleanAt(T message, long offset) {
        return UnsafeUtil.getBoolean(message, offset);
    }

    private static <T> double oneofDoubleAt(T message, long offset) {
        return ((Double) UnsafeUtil.getObject(message, offset)).doubleValue();
    }

    private static <T> float oneofFloatAt(T message, long offset) {
        return ((Float) UnsafeUtil.getObject(message, offset)).floatValue();
    }

    private static <T> int oneofIntAt(T message, long offset) {
        return ((Integer) UnsafeUtil.getObject(message, offset)).intValue();
    }

    private static <T> long oneofLongAt(T message, long offset) {
        return ((Long) UnsafeUtil.getObject(message, offset)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T message, long offset) {
        return ((Boolean) UnsafeUtil.getObject(message, offset)).booleanValue();
    }

    private boolean arePresentForEquals(T message, T other, int pos) {
        if (isFieldPresent(message, pos) != isFieldPresent(other, pos)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isFieldPresent(T message, int pos, int presenceFieldOffset, int presenceField, int presenceMask) {
        if (presenceFieldOffset != 1048575) goto L7;
        return isFieldPresent(message, pos);
    L7:
        if ((presenceField & presenceMask) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isFieldPresent(T message, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        long presenceFieldOffset = presenceMaskAndOffset & 1048575;
        if (presenceFieldOffset != 1048575) goto L82;
        int typeAndOffset = typeAndOffsetAt(pos);
        long offset = offset(typeAndOffset);
        switch(type(typeAndOffset)) {
            case 0: goto L79;
            case 1: goto L75;
            case 2: goto L71;
            case 3: goto L67;
            case 4: goto L63;
            case 5: goto L59;
            case 6: goto L55;
            case 7: goto L53;
            case 8: goto L42;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L33;
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L21;
            case 15: goto L17;
            case 16: goto L13;
            case 17: goto L9;
            default: goto L7;
        };
    L42:
        Object value = UnsafeUtil.getObject(message, offset);
        if ((value instanceof String) == false) goto L47;
        return !((String) value).isEmpty();
    L47:
        if ((value instanceof ByteString) == false) goto L51;
        return !ByteString.EMPTY.equals(value);
    L51:
        throw new IllegalArgumentException();
    L7:
        throw new IllegalArgumentException();
    L9:
        if (UnsafeUtil.getObject(message, offset) != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (UnsafeUtil.getLong(message, offset) != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (UnsafeUtil.getInt(message, offset) != 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (UnsafeUtil.getLong(message, offset) != 0) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (UnsafeUtil.getInt(message, offset) != 0) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (UnsafeUtil.getInt(message, offset) != 0) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (UnsafeUtil.getInt(message, offset) != 0) goto L35;
        return false;
    L35:
        return true;
    L37:
        return !ByteString.EMPTY.equals(UnsafeUtil.getObject(message, offset));
    L39:
        if (UnsafeUtil.getObject(message, offset) != null) goto L41;
        return false;
    L41:
        return true;
    L53:
        return UnsafeUtil.getBoolean(message, offset);
    L55:
        if (UnsafeUtil.getInt(message, offset) != 0) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (UnsafeUtil.getLong(message, offset) != 0) goto L61;
        return false;
    L61:
        return true;
    L63:
        if (UnsafeUtil.getInt(message, offset) != 0) goto L65;
        return false;
    L65:
        return true;
    L67:
        if (UnsafeUtil.getLong(message, offset) != 0) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (UnsafeUtil.getLong(message, offset) != 0) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (Float.floatToRawIntBits(UnsafeUtil.getFloat(message, offset)) != 0) goto L77;
        return false;
    L77:
        return true;
    L79:
        if (Double.doubleToRawLongBits(UnsafeUtil.getDouble(message, offset)) != 0) goto L81;
        return false;
    L81:
        return true;
    L82:
        int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
        if ((UnsafeUtil.getInt(message, 1048575 & presenceMaskAndOffset) & presenceMask) != 0) goto L85;
        return false;
    L85:
        return true;
    }

    private void setFieldPresent(T message, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        long presenceFieldOffset = 1048575 & presenceMaskAndOffset;
        if (presenceFieldOffset != 1048575) goto L5;
        return;
    L5:
        int presenceMask = 1 << (presenceMaskAndOffset >>> 20);
        UnsafeUtil.putInt(message, presenceFieldOffset, UnsafeUtil.getInt(message, presenceFieldOffset) | presenceMask);
    }

    private boolean isOneofPresent(T message, int fieldNumber, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        if (UnsafeUtil.getInt(message, 1048575 & presenceMaskAndOffset) != fieldNumber) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isOneofCaseEqual(T message, T other, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        if (UnsafeUtil.getInt(message, presenceMaskAndOffset & 1048575) != UnsafeUtil.getInt(other, 1048575 & presenceMaskAndOffset)) goto L5;
        return true;
    L5:
        return false;
    }

    private void setOneofPresent(T message, int fieldNumber, int pos) {
        int presenceMaskAndOffset = presenceMaskAndOffsetAt(pos);
        UnsafeUtil.putInt(message, 1048575 & presenceMaskAndOffset, fieldNumber);
    }

    private int positionForFieldNumber(int number) {
        if (number >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (number <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(number, 0);
    }

    private int positionForFieldNumber(int number, int min) {
        if (number >= this.minFieldNumber) goto L5;
        return -1;
    L5:
        if (number <= this.maxFieldNumber) goto L7;
        return -1;
    L7:
        return slowPositionForFieldNumber(number, min);
    }

    private int slowPositionForFieldNumber(int number, int min) {
        int max = (this.buffer.length / 3) - 1;
    L3:
        if (min > max) goto L11;
        int mid = (max + min) >>> 1;
        int pos = mid * 3;
        int midFieldNumber = numberAt(pos);
        if (number == midFieldNumber) goto L6;
        if (number < midFieldNumber) goto L8;
        min = mid + 1;
        goto L3
    L8:
        max = mid - 1;
        goto L3
    L6:
        return pos;
    L11:
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
