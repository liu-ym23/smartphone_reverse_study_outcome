package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = null;
    private final SmallSortedMap<FieldDescriptorType, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: com.google.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r10 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L97:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L105:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L109:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L91:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r11 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r11;
            r11[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L103:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L107:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L117:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L93:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L113:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r10, MessageLite r11);

        boolean isPacked();

        boolean isRepeated();
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    private FieldSet() {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private void cloneFieldEntry(Map<FieldDescriptorType, Object> r10, Map.Entry<FieldDescriptorType, Object> r11) {
        FieldDescriptorType r12 = r11.getKey();
        Object r13 = r11.getValue();
        if ((r13 instanceof LazyField) == false) goto L5;
        r10.put(r12, ((LazyField) r13).getValue());
        return;
    L5:
        r10.put(r12, r13);
    }

    private Object cloneIfMutable(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L6;
        byte[] r11 = (byte[]) r10;
        byte[] r12 = new byte[r11.length];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        return r12;
    L6:
        return r10;
    }

    public static int computeElementSize(WireFormat.FieldType r10, int r11, Object r12) {
        int r13 = CodedOutputStream.computeTagSize(r11);
        if (r10 != WireFormat.FieldType.GROUP) goto L6;
        r13 = r13 * 2;
    L6:
        return r13 + computeElementSizeNoTag(r10, r12);
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType r10, Object r11) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r10.ordinal()]) {
            case 1: goto L57;
            case 2: goto L55;
            case 3: goto L53;
            case 4: goto L51;
            case 5: goto L49;
            case 6: goto L47;
            case 7: goto L45;
            case 8: goto L43;
            case 9: goto L41;
            case 10: goto L35;
            case 11: goto L29;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if ((r11 instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) r11).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) r11).intValue());
    L13:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) r11).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) r11).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) r11).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) r11).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) r11).intValue());
    L23:
        if ((r11 instanceof ByteString) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r11);
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) r11);
    L29:
        if ((r11 instanceof ByteString) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) r11);
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) r11);
    L35:
        if ((r11 instanceof LazyField) == false) goto L39;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) r11);
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) r11);
    L41:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) r11);
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) r11).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) r11).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) r11).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) r11).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) r11).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) r11).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) r11).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) r11).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> r10, Object r11) {
        WireFormat.FieldType r12 = r10.getLiteType();
        int r13 = r10.getNumber();
        if (r10.isRepeated() == false) goto L18;
        int r14 = 0;
        if (r10.isPacked() == false) goto L12;
        Iterator r15 = ((List) r11).iterator();
    L8:
        if (r15.hasNext() == false) goto L11;
        r14 = r14 + computeElementSizeNoTag(r12, r15.next());
        goto L8
    L11:
        return (CodedOutputStream.computeTagSize(r13) + r14) + CodedOutputStream.computeRawVarint32Size(r14);
    L12:
        Iterator r16 = ((List) r11).iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r14 = r14 + computeElementSize(r12, r13, r16.next());
        goto L14
    L16:
        return r14;
    L18:
        return computeElementSize(r12, r13, r11);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType r10, boolean r11) {
        if (r11 == false) goto L6;
        return 2;
    L6:
        return r10.getWireType();
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> r10) {
        FieldDescriptorType r11 = r10.getKey();
        Object r12 = r10.getValue();
        if ((r12 instanceof LazyField) == false) goto L6;
        r12 = ((LazyField) r12).getValue();
    L6:
        if (r11.isRepeated() == false) goto L16;
        Object r13 = getField(r11);
        if (r13 != null) goto L10;
        r13 = new ArrayList();
    L10:
        Iterator r14 = ((List) r12).iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        ((List) r13).add(cloneIfMutable(r14.next()));
        goto L12
    L14:
        this.fields.put(r11, r13);
        return;
    L16:
        if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r15 = getField(r11);
        if (r15 != null) goto L20;
        this.fields.put(r11, cloneIfMutable(r12));
        return;
    L20:
        MessageLite r16 = r11.internalMergeFrom(((MessageLite) r15).toBuilder(), (MessageLite) r12).build();
        this.fields.put(r11, r16);
        return;
    L21:
        this.fields.put(r11, cloneIfMutable(r12));
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream r10, WireFormat.FieldType r11, boolean r12) throws IOException {
        if (r12 == false) goto L6;
        return WireFormat.readPrimitiveField(r10, r11, WireFormat.Utf8Validation.STRICT);
    L6:
        return WireFormat.readPrimitiveField(r10, r11, WireFormat.Utf8Validation.LOOSE);
    }

    private static void verifyType(WireFormat.FieldType r10, Object r11) {
        if (r11 == null) goto L34;
        boolean r12 = true;
        boolean r13 = false;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[r10.getJavaType().ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L14;
            case 9: goto L7;
            default: goto L29;
        };
    L23:
        r13 = r11 instanceof String;
        goto L29
    L24:
        r13 = r11 instanceof Boolean;
        goto L29
    L25:
        r13 = r11 instanceof Double;
        goto L29
    L26:
        r13 = r11 instanceof Float;
        goto L29
    L27:
        r13 = r11 instanceof Long;
        goto L29
    L28:
        r13 = r11 instanceof Integer;
    L29:
        if (r13 == false) goto L32;
        return;
    L32:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L7:
        if ((r11 instanceof MessageLite) == false) goto L9;
    L12:
        r13 = r12;
        goto L29
    L9:
        if ((r11 instanceof LazyField) == true) goto L12;
    L11:
        r12 = false;
        goto L12
    L14:
        if ((r11 instanceof Integer) == true) goto L12;
        if ((r11 instanceof Internal.EnumLite) == false) goto L11;
    L19:
        if ((r11 instanceof ByteString) == true) goto L12;
        if ((r11 instanceof byte[]) == false) goto L11;
    L34:
        throw null;
    }

    public static void writeElement(CodedOutputStream r10, WireFormat.FieldType r11, int r12, Object r13) throws IOException {
        if (r11 != WireFormat.FieldType.GROUP) goto L5;
        r10.writeGroup(r12, (MessageLite) r13);
        return;
    L5:
        r10.writeTag(r12, getWireFormatForFieldType(r11, false));
        writeElementNoTag(r10, r11, r13);
    }

    public static void writeElementNoTag(CodedOutputStream r10, WireFormat.FieldType r11, Object r12) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L19;
            case 12: goto L15;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L6;
            default: goto L53;
        };
    L9:
        r10.writeSInt64NoTag(((Long) r12).longValue());
        return;
    L10:
        r10.writeSInt32NoTag(((Integer) r12).intValue());
        return;
    L11:
        r10.writeSFixed64NoTag(((Long) r12).longValue());
        return;
    L12:
        r10.writeSFixed32NoTag(((Integer) r12).intValue());
        return;
    L13:
        r10.writeUInt32NoTag(((Integer) r12).intValue());
        return;
    L22:
        r10.writeMessageNoTag((MessageLite) r12);
        return;
    L23:
        r10.writeGroupNoTag((MessageLite) r12);
        return;
    L24:
        r10.writeBoolNoTag(((Boolean) r12).booleanValue());
        return;
    L25:
        r10.writeFixed32NoTag(((Integer) r12).intValue());
        return;
    L26:
        r10.writeFixed64NoTag(((Long) r12).longValue());
        return;
    L27:
        r10.writeInt32NoTag(((Integer) r12).intValue());
        return;
    L28:
        r10.writeUInt64NoTag(((Long) r12).longValue());
        return;
    L29:
        r10.writeInt64NoTag(((Long) r12).longValue());
        return;
    L30:
        r10.writeFloatNoTag(((Float) r12).floatValue());
        return;
    L31:
        r10.writeDoubleNoTag(((Double) r12).doubleValue());
        return;
    L53:
        return;
    L6:
        if ((r12 instanceof Internal.EnumLite) == false) goto L8;
        r10.writeEnumNoTag(((Internal.EnumLite) r12).getNumber());
        return;
    L8:
        r10.writeEnumNoTag(((Integer) r12).intValue());
        return;
    L15:
        if ((r12 instanceof ByteString) == false) goto L17;
        r10.writeBytesNoTag((ByteString) r12);
        return;
    L17:
        r10.writeByteArrayNoTag((byte[]) r12);
        return;
    L19:
        if ((r12 instanceof ByteString) == false) goto L21;
        r10.writeBytesNoTag((ByteString) r12);
        return;
    L21:
        r10.writeStringNoTag((String) r12);
    }

    public static void writeField(FieldDescriptorLite<?> r10, Object r11, CodedOutputStream r12) throws IOException {
        WireFormat.FieldType r13 = r10.getLiteType();
        int r14 = r10.getNumber();
        if (r10.isRepeated() == false) goto L19;
        List r15 = (List) r11;
        if (r10.isPacked() == false) goto L14;
        r12.writeTag(r14, 2);
        Iterator r16 = r15.iterator();
        int r17 = 0;
    L8:
        if (r16.hasNext() == false) goto L10;
        r17 = r17 + computeElementSizeNoTag(r13, r16.next());
        goto L8
    L10:
        r12.writeRawVarint32(r17);
        Iterator r18 = r15.iterator();
    L12:
        if (r18.hasNext() == false) goto L27;
        writeElementNoTag(r12, r13, r18.next());
        goto L12
    L27:
        return;
    L14:
        Iterator r19 = r15.iterator();
    L16:
        if (r19.hasNext() == false) goto L28;
        writeElement(r12, r13, r14, r19.next());
        goto L16
    L28:
        return;
    L19:
        if ((r11 instanceof LazyField) == false) goto L21;
        writeElement(r12, r13, r14, ((LazyField) r11).getValue());
        return;
    L21:
        writeElement(r12, r13, r14, r11);
    }

    public void addRepeatedField(FieldDescriptorType r10, Object r11) {
        if (r10.isRepeated() == false) goto L11;
        verifyType(r10.getLiteType(), r11);
        Object r12 = getField(r10);
        if (r12 != null) goto L7;
        List r13 = new ArrayList();
        this.fields.put(r10, r13);
    L8:
        r13.add(r11);
        return;
    L7:
        r13 = (List) r12;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(FieldDescriptorType r10) {
        this.fields.remove(r10);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m12clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FieldSet) == true) goto L10;
        return false;
    L10:
        return this.fields.equals(((FieldSet) r10).fields);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<FieldDescriptorType, Object> getAllFields() {
        if (this.hasLazyField == false) goto L16;
        SmallSortedMap r10 = SmallSortedMap.newFieldMap(16);
        int r11 = 0;
    L6:
        if (r11 >= this.fields.getNumArrayEntries()) goto L8;
        cloneFieldEntry(r10, this.fields.getArrayEntryAt(r11));
        r11 = r11 + 1;
        goto L6
    L8:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L10:
        if (r12.hasNext() == false) goto L13;
        cloneFieldEntry(r10, (Map.Entry) r12.next());
        goto L10
    L13:
        if (this.fields.isImmutable() == false) goto L15;
        r10.makeImmutable();
    L15:
        return r10;
    L16:
        boolean r13 = this.fields.isImmutable();
        SmallSortedMap<FieldDescriptorType, Object> r14 = this.fields;
        if (r13 == false) goto L20;
        return r14;
    L20:
        return Collections.unmodifiableMap(r14);
    }

    public Object getField(FieldDescriptorType r10) {
        Object r11 = this.fields.get(r10);
        if ((r11 instanceof LazyField) == true) goto L5;
        return r11;
    L5:
        return ((LazyField) r11).getValue();
    }

    public int getMessageSetSerializedSize() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= this.fields.getNumArrayEntries()) goto L6;
        r11 = r11 + getMessageSetSerializedSize(this.fields.getArrayEntryAt(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11 = r11 + getMessageSetSerializedSize((Map.Entry) r12.next());
        goto L8
    L10:
        return r11;
    }

    public Object getRepeatedField(FieldDescriptorType r10, int r11) {
        if (r10.isRepeated() == false) goto L11;
        Object r12 = getField(r10);
        if (r12 == null) goto L9;
        return ((List) r12).get(r11);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getRepeatedFieldCount(FieldDescriptorType r10) {
        if (r10.isRepeated() == false) goto L11;
        Object r11 = getField(r10);
        if (r11 != null) goto L9;
        return 0;
    L9:
        return ((List) r11).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int getSerializedSize() {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r10);
        r11 = r11 + computeFieldSize((FieldDescriptorLite) r12.getKey(), r12.getValue());
        r10 = r10 + 1;
        goto L4
    L6:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        r11 = r11 + computeFieldSize((FieldDescriptorLite) r14.getKey(), r14.getValue());
        goto L8
    L10:
        return r11;
    }

    public boolean hasField(FieldDescriptorType r10) {
        if (r10.isRepeated() == true) goto L10;
        if (this.fields.get(r10) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        int r10 = 0;
    L4:
        if (r10 >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(r10)) == false) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r11 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        if (isInitialized((Map.Entry) r11.next()) == true) goto L11;
        return false;
    L15:
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    L7:
        return this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.fields.getNumArrayEntries()) goto L6;
        mergeFromField(r10.fields.getArrayEntryAt(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator r12 = r10.fields.getOverflowEntries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        mergeFromField((Map.Entry) r12.next());
        goto L8
    }

    public void setField(FieldDescriptorType r10, Object r11) {
        if (r10.isRepeated() == true) goto L5;
        verifyType(r10.getLiteType(), r11);
    L15:
        if ((r11 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r10, r11);
        return;
    L5:
        if ((r11 instanceof List) == false) goto L12;
        ArrayList r12 = new ArrayList();
        r12.addAll((List) r11);
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        verifyType(r10.getLiteType(), r14);
        goto L8
    L10:
        r11 = r12;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void setRepeatedField(FieldDescriptorType r10, int r11, Object r12) {
        if (r10.isRepeated() == false) goto L11;
        Object r13 = getField(r10);
        if (r13 == null) goto L9;
        verifyType(r10.getLiteType(), r12);
        ((List) r13).set(r11, r12);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void writeMessageSetTo(CodedOutputStream r10) throws IOException {
        int r11 = 0;
    L4:
        if (r11 >= this.fields.getNumArrayEntries()) goto L6;
        writeMessageSetTo(this.fields.getArrayEntryAt(r11), r10);
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator r12 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        writeMessageSetTo((Map.Entry) r12.next(), r10);
        goto L8
    }

    public void writeTo(CodedOutputStream r10) throws IOException {
        int r11 = 0;
    L4:
        if (r11 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r11);
        writeField((FieldDescriptorLite) r12.getKey(), r12.getValue(), r10);
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        writeField((FieldDescriptorLite) r14.getKey(), r14.getValue(), r10);
        goto L8
    }

    public FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> r10 = newFieldSet();
        int r11 = 0;
    L4:
        if (r11 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r12 = this.fields.getArrayEntryAt(r11);
        r10.setField((FieldDescriptorLite) r12.getKey(), r12.getValue());
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator r13 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        r10.setField((FieldDescriptorLite) r14.getKey(), r14.getValue());
        goto L8
    L10:
        r10.hasLazyField = this.hasLazyField;
        return r10;
    }

    private FieldSet(boolean r10) {
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> r10) {
        FieldDescriptorType r11 = r10.getKey();
        Object r12 = r10.getValue();
        if (r11.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r11.isRepeated() == true) goto L15;
        if (r11.isPacked() == true) goto L15;
        if ((r12 instanceof LazyField) == false) goto L13;
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(r10.getKey().getNumber(), (LazyField) r12);
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(r10.getKey().getNumber(), (MessageLite) r12);
    L15:
        return computeFieldSize(r11, r12);
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> r10) {
        FieldDescriptorType r11 = r10.getKey();
        if (r11.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L22:
        return true;
    L5:
        if (r11.isRepeated() == false) goto L12;
        Iterator r12 = ((List) r10.getValue()).iterator();
    L8:
        if (r12.hasNext() == false) goto L22;
        if (((MessageLite) r12.next()).isInitialized() == true) goto L8;
        return false;
    L12:
        Object r13 = r10.getValue();
        if ((r13 instanceof MessageLite) == false) goto L18;
        if (((MessageLite) r13).isInitialized() == true) goto L22;
        return false;
    L18:
        if ((r13 instanceof LazyField) == false) goto L21;
        return true;
    L21:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> r10, CodedOutputStream r11) throws IOException {
        FieldDescriptorType r12 = r10.getKey();
        if (r12.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(r12, r10.getValue(), r11);
        return;
    L5:
        if (r12.isRepeated() == true) goto L12;
        if (r12.isPacked() == true) goto L12;
        Object r13 = r10.getValue();
        if ((r13 instanceof LazyField) == false) goto L11;
        r13 = ((LazyField) r13).getValue();
    L11:
        r11.writeMessageSetExtension(r10.getKey().getNumber(), (MessageLite) r13);
    }
}
