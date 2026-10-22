package com.bytedance.location.protobuf;

import com.bytedance.location.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private static final FieldSet DEFAULT_INSTANCE = null;
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.FieldSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L118:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L124:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L138:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L98:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L102:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L120:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L134:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L142:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L94:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L112:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L43
        L126:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L46
        L132:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L49
        L144:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L52
        L106:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L55
        L116:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L58
        L122:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L61
        L140:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L64
        L65:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L68
        L108:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L71
        L128:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L74
        L130:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L77
        L146:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L80
        L96:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L83
        L110:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L86
        L114:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L89
        L136:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L92
            return;
        }
    }

    static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        /* synthetic */ Builder(AnonymousClass1 x0) {
            this();
        }

        private Builder() {
            this(SmallSortedMap.newFieldMap(16));
        }

        private Builder(SmallSortedMap<T, Object> fields) {
            this.fields = fields;
            this.isMutable = true;
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        private FieldSet<T> buildImpl(boolean partial) {
            if (this.fields.isEmpty() == true) goto L5;
            this.isMutable = false;
            SmallSortedMap<T, Object> fieldsForBuild = this.fields;
            if (this.hasNestedBuilders == false) goto L9;
            fieldsForBuild = FieldSet.access$100(this.fields, false);
            replaceBuilders(fieldsForBuild, partial);
        L9:
            FieldSet<T> fieldSet = new FieldSet(fieldsForBuild, null);
            FieldSet.access$302(fieldSet, this.hasLazyField);
            return fieldSet;
        L5:
            return FieldSet.emptySet();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> fieldMap, boolean partial) {
            int i = 0;
        L4:
            if (i >= fieldMap.getNumArrayEntries()) goto L6;
            replaceBuilders(fieldMap.getArrayEntryAt(i), partial);
            i = i + 1;
            goto L4
        L6:
            Iterator r0 = fieldMap.getOverflowEntries().iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            Map.Entry<T, Object> entry = (Map.Entry) r0.next();
            replaceBuilders(entry, partial);
            goto L8
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean partial) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue(), partial));
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T descriptor, Object value, boolean partial) {
            if (value != null) goto L5;
            return value;
        L5:
            if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L7;
            return value;
        L7:
            if (descriptor.isRepeated() == false) goto L24;
            if ((value instanceof List) == false) goto L22;
            List<Object> list = (List) value;
            int i = 0;
        L12:
            if (i >= list.size()) goto L20;
            Object oldElement = list.get(i);
            Object newElement = replaceBuilder(oldElement, partial);
            if (newElement == oldElement) goto L18;
            if (list != value) goto L17;
            list = new ArrayList(list);
        L17:
            list.set(i, newElement);
        L18:
            i = i + 1;
            goto L12
        L20:
            return list;
        L22:
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + value.getClass());
        L24:
            return replaceBuilder(value, partial);
        }

        private static Object replaceBuilder(Object value, boolean partial) {
            if ((value instanceof MessageLite.Builder) == true) goto L5;
            return value;
        L5:
            MessageLite.Builder builder = (MessageLite.Builder) value;
            if (partial == false) goto L10;
            return builder.buildPartial();
        L10:
            return builder.build();
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder(FieldSet.access$100(FieldSet.access$400(fieldSet), true));
            ((Builder) builder).hasLazyField = FieldSet.access$300(fieldSet);
            return builder;
        }

        public Map<T, Object> getAllFields() {
            if (this.hasLazyField == false) goto L10;
            SmallSortedMap<T, Object> result = FieldSet.access$100(this.fields, false);
            if (this.fields.isImmutable() == false) goto L7;
            result.makeImmutable();
        L8:
            return result;
        L7:
            replaceBuilders(result, true);
            goto L8
        L10:
            if (this.fields.isImmutable() == false) goto L13;
            return this.fields;
        L13:
            return Collections.unmodifiableMap(this.fields);
        }

        public boolean hasField(T descriptor) {
            if (descriptor.isRepeated() == true) goto L10;
            if (this.fields.get(descriptor) == null) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public Object getField(T descriptor) {
            Object value = getFieldAllowBuilders(descriptor);
            return replaceBuilders(descriptor, value, true);
        }

        Object getFieldAllowBuilders(T descriptor) {
            Object o = this.fields.get(descriptor);
            if ((o instanceof LazyField) == true) goto L5;
            return o;
        L5:
            return ((LazyField) o).getValue();
        }

        private void ensureIsMutable() {
            if (this.isMutable == true) goto L6;
            this.fields = FieldSet.access$100(this.fields, true);
            this.isMutable = true;
            return;
        }

        public void setField(T r7, Object r8) {
            ensureIsMutable();
            boolean r1 = false;
            if (r7.isRepeated() == true) goto L5;
            verifyType(r7, r8);
        L22:
            if ((r8 instanceof LazyField) == false) goto L25;
            this.hasLazyField = true;
        L25:
            if (this.hasNestedBuilders == false) goto L27;
        L28:
            r1 = true;
        L29:
            this.hasNestedBuilders = r1;
            this.fields.put(r7, r8);
            return;
        L27:
            if ((r8 instanceof MessageLite.Builder) == false) goto L29;
        L5:
            if ((r8 instanceof List) == false) goto L19;
            ArrayList r0 = new ArrayList((List) r8);
            Iterator r3 = r0.iterator();
        L8:
            if (r3.hasNext() == false) goto L17;
            Object r4 = r3.next();
            verifyType(r7, r4);
            if (this.hasNestedBuilders == false) goto L12;
        L15:
            boolean r5 = true;
        L16:
            this.hasNestedBuilders = r5;
            goto L8
        L12:
            if ((r4 instanceof MessageLite.Builder) == true) goto L15;
            r5 = false;
            goto L16
        L17:
            r8 = r0;
            goto L22
        L19:
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }

        public void clearField(T descriptor) {
            ensureIsMutable();
            this.fields.remove(descriptor);
            if (this.fields.isEmpty() == false) goto L6;
            this.hasLazyField = false;
            return;
        }

        public int getRepeatedFieldCount(T descriptor) {
            if (descriptor.isRepeated() == false) goto L11;
            Object value = getFieldAllowBuilders(descriptor);
            if (value != null) goto L9;
            return 0;
        L9:
            return ((List) value).size();
        L11:
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public Object getRepeatedField(T descriptor, int index) {
            if (this.hasNestedBuilders == false) goto L5;
            ensureIsMutable();
        L5:
            Object value = getRepeatedFieldAllowBuilders(descriptor, index);
            return replaceBuilder(value, true);
        }

        Object getRepeatedFieldAllowBuilders(T descriptor, int index) {
            if (descriptor.isRepeated() == false) goto L11;
            Object value = getFieldAllowBuilders(descriptor);
            if (value == null) goto L9;
            return ((List) value).get(index);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public void setRepeatedField(T descriptor, int index, Object value) {
            ensureIsMutable();
            if (descriptor.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            this.hasNestedBuilders = r0;
            Object list = getFieldAllowBuilders(descriptor);
            if (list == null) goto L16;
            verifyType(descriptor, value);
            ((List) list).set(index, value);
            return;
        L16:
            throw new IndexOutOfBoundsException();
        L7:
            if ((value instanceof MessageLite.Builder) == true) goto L10;
            r0 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public void addRepeatedField(T descriptor, Object value) {
            ensureIsMutable();
            if (descriptor.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            this.hasNestedBuilders = r0;
            verifyType(descriptor, value);
            Object existingValue = getFieldAllowBuilders(descriptor);
            if (existingValue != null) goto L14;
            List<Object> list = new ArrayList();
            this.fields.put(descriptor, list);
        L15:
            list.add(value);
            return;
        L14:
            list = (List) existingValue;
            goto L15
        L7:
            if ((value instanceof MessageLite.Builder) == true) goto L10;
            r0 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        private void verifyType(T descriptor, Object value) {
            if (FieldSet.access$500(descriptor.getLiteType(), value) == false) goto L5;
            return;
        L5:
            if (descriptor.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE) goto L10;
            if ((value instanceof MessageLite.Builder) == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(descriptor.getNumber()), descriptor.getLiteType().getJavaType(), value.getClass().getName()}));
        }

        public boolean isInitialized() {
            int i = 0;
        L4:
            if (i >= this.fields.getNumArrayEntries()) goto L9;
            if (FieldSet.access$600(this.fields.getArrayEntryAt(i)) == false) goto L7;
            i = i + 1;
            goto L4
        L7:
            return false;
        L9:
            Iterator r0 = this.fields.getOverflowEntries().iterator();
        L11:
            if (r0.hasNext() == false) goto L16;
            Map.Entry<T, Object> entry = (Map.Entry) r0.next();
            if (FieldSet.access$600(entry) == true) goto L11;
            return false;
        L16:
            return true;
        }

        public void mergeFrom(FieldSet<T> other) {
            ensureIsMutable();
            int i = 0;
        L4:
            if (i >= FieldSet.access$400(other).getNumArrayEntries()) goto L6;
            mergeFromField(FieldSet.access$400(other).getArrayEntryAt(i));
            i = i + 1;
            goto L4
        L6:
            Iterator r0 = FieldSet.access$400(other).getOverflowEntries().iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            Map.Entry<T, Object> entry = (Map.Entry) r0.next();
            mergeFromField(entry);
            goto L8
        }

        private void mergeFromField(Map.Entry<T, Object> entry) {
            T descriptor = entry.getKey();
            Object otherValue = entry.getValue();
            if ((otherValue instanceof LazyField) == false) goto L6;
            otherValue = ((LazyField) otherValue).getValue();
        L6:
            if (descriptor.isRepeated() == false) goto L16;
            List<Object> value = (List) getFieldAllowBuilders(descriptor);
            if (value != null) goto L10;
            value = new ArrayList();
            this.fields.put(descriptor, value);
        L10:
            Iterator r3 = ((List) otherValue).iterator();
        L12:
            if (r3.hasNext() == false) goto L31;
            Object element = r3.next();
            value.add(FieldSet.access$700(element));
            goto L12
        L31:
            return;
        L16:
            if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L25;
            Object value2 = getFieldAllowBuilders(descriptor);
            if (value2 != null) goto L21;
            this.fields.put(descriptor, FieldSet.access$700(otherValue));
            return;
        L21:
            if ((value2 instanceof MessageLite.Builder) == false) goto L23;
            descriptor.internalMergeFrom((MessageLite.Builder) value2, (MessageLite) otherValue);
            return;
        L23:
            Object value3 = descriptor.internalMergeFrom(((MessageLite) value2).toBuilder(), (MessageLite) otherValue).build();
            this.fields.put(descriptor, value3);
            return;
        L25:
            this.fields.put(descriptor, FieldSet.access$700(otherValue));
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder r1, MessageLite r2);

        boolean isPacked();

        boolean isRepeated();
    }

    /* synthetic */ FieldSet(SmallSortedMap x0, AnonymousClass1 x1) {
        this(x0);
    }

    static /* synthetic */ SmallSortedMap access$100(SmallSortedMap x0, boolean x1) {
        return cloneAllFieldsMap(x0, x1);
    }

    static /* synthetic */ boolean access$300(FieldSet x0) {
        return x0.hasLazyField;
    }

    static /* synthetic */ boolean access$302(FieldSet x0, boolean x1) {
        x0.hasLazyField = x1;
        return x1;
    }

    static /* synthetic */ SmallSortedMap access$400(FieldSet x0) {
        return x0.fields;
    }

    static /* synthetic */ boolean access$500(WireFormat.FieldType x0, Object x1) {
        return isValidType(x0, x1);
    }

    static /* synthetic */ boolean access$600(Map.Entry x0) {
        return isInitialized(x0);
    }

    static /* synthetic */ Object access$700(Object x0) {
        return cloneIfMutable(x0);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10505clone() throws CloneNotSupportedException {
        return clone();
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(boolean dummy) {
        this(SmallSortedMap.newFieldMap(0));
        makeImmutable();
    }

    private FieldSet(SmallSortedMap<T, Object> fields) {
        this.fields = fields;
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder(null);
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.fields.getNumArrayEntries()) goto L12;
        Map.Entry<K, Object> r1 = this.fields.getArrayEntryAt(i);
        if ((r1.getValue() instanceof GeneratedMessageLite) == false) goto L11;
        ((GeneratedMessageLite) r1.getValue()).makeImmutable();
    L11:
        i = i + 1;
        goto L7
    L12:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof FieldSet) == true) goto L9;
        return false;
    L9:
        FieldSet<?> other = (FieldSet) o;
        return this.fields.equals(other.fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public FieldSet<T> clone() {
        FieldSet<T> clone = newFieldSet();
        int i = 0;
    L4:
        if (i >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r2 = this.fields.getArrayEntryAt(i);
        clone.setField((FieldDescriptorLite) r2.getKey(), r2.getValue());
        i = i + 1;
        goto L4
    L6:
        Iterator r1 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r1.next();
        clone.setField(entry.getKey(), entry.getValue());
        goto L8
    L10:
        clone.hasLazyField = this.hasLazyField;
        return clone;
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public Map<T, Object> getAllFields() {
        if (this.hasLazyField == false) goto L9;
        SmallSortedMap<T, Object> result = cloneAllFieldsMap(this.fields, false);
        if (this.fields.isImmutable() == false) goto L7;
        result.makeImmutable();
    L7:
        return result;
    L9:
        if (this.fields.isImmutable() == false) goto L12;
        return this.fields;
    L12:
        return Collections.unmodifiableMap(this.fields);
    }

    private static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> fields, boolean copyList) {
        SmallSortedMap<T, Object> result = SmallSortedMap.newFieldMap(16);
        int i = 0;
    L4:
        if (i >= fields.getNumArrayEntries()) goto L6;
        cloneFieldEntry(result, fields.getArrayEntryAt(i), copyList);
        i = i + 1;
        goto L4
    L6:
        Iterator r1 = fields.getOverflowEntries().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r1.next();
        cloneFieldEntry(result, entry, copyList);
        goto L8
    L10:
        return result;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean copyList) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if ((value instanceof LazyField) == false) goto L5;
        map.put(key, ((LazyField) value).getValue());
        return;
    L5:
        if (copyList == true) goto L7;
    L9:
        map.put(key, value);
        return;
    L7:
        if ((value instanceof List) == false) goto L9;
        map.put(key, new ArrayList((List) value));
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    L7:
        return this.fields.entrySet().iterator();
    }

    Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator());
    L7:
        return this.fields.descendingEntrySet().iterator();
    }

    public boolean hasField(T descriptor) {
        if (descriptor.isRepeated() == true) goto L10;
        if (this.fields.get(descriptor) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public Object getField(T descriptor) {
        Object o = this.fields.get(descriptor);
        if ((o instanceof LazyField) == true) goto L5;
        return o;
    L5:
        return ((LazyField) o).getValue();
    }

    public void setField(T r4, Object r5) {
        if (r4.isRepeated() == true) goto L5;
        verifyType(r4, r5);
    L15:
        if ((r5 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r4, r5);
        return;
    L5:
        if ((r5 instanceof List) == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.addAll((List) r5);
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        verifyType(r4, r1.next());
        goto L8
    L10:
        r5 = r0;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void clearField(T descriptor) {
        this.fields.remove(descriptor);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    public int getRepeatedFieldCount(T descriptor) {
        if (descriptor.isRepeated() == false) goto L11;
        Object value = getField(descriptor);
        if (value != null) goto L9;
        return 0;
    L9:
        return ((List) value).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(T descriptor, int index) {
        if (descriptor.isRepeated() == false) goto L11;
        Object value = getField(descriptor);
        if (value == null) goto L9;
        return ((List) value).get(index);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setRepeatedField(T descriptor, int index, Object value) {
        if (descriptor.isRepeated() == false) goto L11;
        Object list = getField(descriptor);
        if (list == null) goto L9;
        verifyType(descriptor, value);
        ((List) list).set(index, value);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void addRepeatedField(T descriptor, Object value) {
        if (descriptor.isRepeated() == false) goto L11;
        verifyType(descriptor, value);
        Object existingValue = getField(descriptor);
        if (existingValue != null) goto L7;
        List<Object> list = new ArrayList();
        this.fields.put(descriptor, list);
    L8:
        list.add(value);
        return;
    L7:
        list = (List) existingValue;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private void verifyType(T descriptor, Object value) {
        if (isValidType(descriptor.getLiteType(), value) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(descriptor.getNumber()), descriptor.getLiteType().getJavaType(), value.getClass().getName()}));
    }

    private static boolean isValidType(WireFormat.FieldType type, Object value) {
        Internal.checkNotNull(value);
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[type.getJavaType().ordinal()]) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L20;
            case 8: goto L13;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if ((value instanceof MessageLite) == false) goto L8;
        return true;
    L8:
        if ((value instanceof LazyField) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if ((value instanceof Integer) == false) goto L15;
        return true;
    L15:
        if ((value instanceof Internal.EnumLite) == false) goto L18;
        return true;
    L18:
        return false;
    L20:
        if ((value instanceof ByteString) == false) goto L22;
        return true;
    L22:
        if ((value instanceof byte[]) == false) goto L25;
        return true;
    L25:
        return false;
    L27:
        return value instanceof String;
    L29:
        return value instanceof Boolean;
    L31:
        return value instanceof Double;
    L33:
        return value instanceof Float;
    L35:
        return value instanceof Long;
    L37:
        return value instanceof Integer;
    }

    public boolean isInitialized() {
        int i = 0;
    L4:
        if (i >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(i)) == false) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r0 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<T, Object> entry = (Map.Entry) r0.next();
        if (isInitialized(entry) == true) goto L11;
        return false;
    L16:
        return true;
    }

    private static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T descriptor = entry.getKey();
        if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
        return true;
    L5:
        if (descriptor.isRepeated() == false) goto L16;
        Iterator r1 = ((List) entry.getValue()).iterator();
    L8:
        if (r1.hasNext() == false) goto L22;
        Object element = r1.next();
        if (isMessageFieldValueInitialized(element) == true) goto L8;
        return false;
    L22:
        return true;
    L16:
        return isMessageFieldValueInitialized(entry.getValue());
    }

    private static boolean isMessageFieldValueInitialized(Object value) {
        if ((value instanceof MessageLiteOrBuilder) == false) goto L7;
        return ((MessageLiteOrBuilder) value).isInitialized();
    L7:
        if ((value instanceof LazyField) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    static int getWireFormatForFieldType(WireFormat.FieldType type, boolean isPacked) {
        if (isPacked == false) goto L6;
        return 2;
    L6:
        return type.getWireType();
    }

    public void mergeFrom(FieldSet<T> other) {
        int i = 0;
    L4:
        if (i >= other.fields.getNumArrayEntries()) goto L6;
        mergeFromField(other.fields.getArrayEntryAt(i));
        i = i + 1;
        goto L4
    L6:
        Iterator r0 = other.fields.getOverflowEntries().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r0.next();
        mergeFromField(entry);
        goto L8
    }

    private static Object cloneIfMutable(Object value) {
        if ((value instanceof byte[]) == false) goto L6;
        byte[] bytes = (byte[]) value;
        byte[] copy = new byte[bytes.length];
        System.arraycopy(bytes, 0, copy, 0, bytes.length);
        return copy;
    L6:
        return value;
    }

    private void mergeFromField(Map.Entry<T, Object> entry) {
        T descriptor = entry.getKey();
        Object otherValue = entry.getValue();
        if ((otherValue instanceof LazyField) == false) goto L6;
        otherValue = ((LazyField) otherValue).getValue();
    L6:
        if (descriptor.isRepeated() == false) goto L16;
        Object value = getField(descriptor);
        if (value != null) goto L10;
        value = new ArrayList();
    L10:
        Iterator r3 = ((List) otherValue).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        Object element = r3.next();
        ((List) value).add(cloneIfMutable(element));
        goto L12
    L14:
        this.fields.put(descriptor, value);
        return;
    L16:
        if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L22;
        Object value2 = getField(descriptor);
        if (value2 != null) goto L20;
        this.fields.put(descriptor, cloneIfMutable(otherValue));
        return;
    L20:
        Object value3 = descriptor.internalMergeFrom(((MessageLite) value2).toBuilder(), (MessageLite) otherValue).build();
        this.fields.put(descriptor, value3);
        return;
    L22:
        this.fields.put(descriptor, cloneIfMutable(otherValue));
    }

    public static Object readPrimitiveField(CodedInputStream input, WireFormat.FieldType type, boolean checkUtf8) throws IOException {
        if (checkUtf8 == false) goto L6;
        return WireFormat.readPrimitiveField(input, type, WireFormat.Utf8Validation.STRICT);
    L6:
        return WireFormat.readPrimitiveField(input, type, WireFormat.Utf8Validation.LOOSE);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        int i = 0;
    L4:
        if (i >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r1 = this.fields.getArrayEntryAt(i);
        writeField((FieldDescriptorLite) r1.getKey(), r1.getValue(), output);
        i = i + 1;
        goto L4
    L6:
        Iterator r0 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r0.next();
        writeField(entry.getKey(), entry.getValue(), output);
        goto L8
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        int i = 0;
    L4:
        if (i >= this.fields.getNumArrayEntries()) goto L6;
        writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
        i = i + 1;
        goto L4
    L6:
        Iterator r0 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r0.next();
        writeMessageSetTo(entry, output);
        goto L8
    }

    private void writeMessageSetTo(Map.Entry<T, Object> entry, CodedOutputStream output) throws IOException {
        T descriptor = entry.getKey();
        if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(descriptor, entry.getValue(), output);
        return;
    L5:
        if (descriptor.isRepeated() == true) goto L12;
        if (descriptor.isPacked() == true) goto L12;
        Object value = entry.getValue();
        if ((value instanceof LazyField) == false) goto L11;
        value = ((LazyField) value).getValue();
    L11:
        output.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
    }

    static void writeElement(CodedOutputStream output, WireFormat.FieldType type, int number, Object value) throws IOException {
        if (type != WireFormat.FieldType.GROUP) goto L5;
        output.writeGroup(number, (MessageLite) value);
        return;
    L5:
        output.writeTag(number, getWireFormatForFieldType(type, false));
        writeElementNoTag(output, type, value);
    }

    static void writeElementNoTag(CodedOutputStream output, WireFormat.FieldType type, Object value) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
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
        output.writeSInt64NoTag(((Long) value).longValue());
        return;
    L10:
        output.writeSInt32NoTag(((Integer) value).intValue());
        return;
    L11:
        output.writeSFixed64NoTag(((Long) value).longValue());
        return;
    L12:
        output.writeSFixed32NoTag(((Integer) value).intValue());
        return;
    L13:
        output.writeUInt32NoTag(((Integer) value).intValue());
        return;
    L22:
        output.writeMessageNoTag((MessageLite) value);
        return;
    L23:
        output.writeGroupNoTag((MessageLite) value);
        return;
    L24:
        output.writeBoolNoTag(((Boolean) value).booleanValue());
        return;
    L25:
        output.writeFixed32NoTag(((Integer) value).intValue());
        return;
    L26:
        output.writeFixed64NoTag(((Long) value).longValue());
        return;
    L27:
        output.writeInt32NoTag(((Integer) value).intValue());
        return;
    L28:
        output.writeUInt64NoTag(((Long) value).longValue());
        return;
    L29:
        output.writeInt64NoTag(((Long) value).longValue());
        return;
    L30:
        output.writeFloatNoTag(((Float) value).floatValue());
        return;
    L31:
        output.writeDoubleNoTag(((Double) value).doubleValue());
        return;
    L53:
        return;
    L6:
        if ((value instanceof Internal.EnumLite) == false) goto L8;
        output.writeEnumNoTag(((Internal.EnumLite) value).getNumber());
        return;
    L8:
        output.writeEnumNoTag(((Integer) value).intValue());
        return;
    L15:
        if ((value instanceof ByteString) == false) goto L17;
        output.writeBytesNoTag((ByteString) value);
        return;
    L17:
        output.writeByteArrayNoTag((byte[]) value);
        return;
    L19:
        if ((value instanceof ByteString) == false) goto L21;
        output.writeBytesNoTag((ByteString) value);
        return;
    L21:
        output.writeStringNoTag((String) value);
    }

    public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
        WireFormat.FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated() == false) goto L21;
        List<?> valueList = (List) value;
        if (descriptor.isPacked() == false) goto L15;
        output.writeTag(number, 2);
        int dataSize = 0;
        Iterator<?> r4 = valueList.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Object element = r4.next();
        dataSize = dataSize + computeElementSizeNoTag(type, element);
        goto L8
    L10:
        output.writeUInt32NoTag(dataSize);
        Iterator<?> r5 = valueList.iterator();
    L12:
        if (r5.hasNext() == false) goto L29;
        Object element2 = r5.next();
        writeElementNoTag(output, type, element2);
        goto L12
    L29:
        return;
    L15:
        Iterator<?> r3 = valueList.iterator();
    L17:
        if (r3.hasNext() == false) goto L30;
        Object element3 = r3.next();
        writeElement(output, type, number, element3);
        goto L17
    L30:
        return;
    L21:
        if ((value instanceof LazyField) == false) goto L23;
        writeElement(output, type, number, ((LazyField) value).getValue());
        return;
    L23:
        writeElement(output, type, number, value);
    }

    public int getSerializedSize() {
        int size = 0;
        int i = 0;
    L4:
        if (i >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r2 = this.fields.getArrayEntryAt(i);
        size = size + computeFieldSize((FieldDescriptorLite) r2.getKey(), r2.getValue());
        i = i + 1;
        goto L4
    L6:
        Iterator r1 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r1.next();
        size = size + computeFieldSize(entry.getKey(), entry.getValue());
        goto L8
    L10:
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        int i = 0;
    L4:
        if (i >= this.fields.getNumArrayEntries()) goto L6;
        size = size + getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
        i = i + 1;
        goto L4
    L6:
        Iterator r1 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<T, Object> entry = (Map.Entry) r1.next();
        size = size + getMessageSetSerializedSize(entry);
        goto L8
    L10:
        return size;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> entry) {
        T descriptor = entry.getKey();
        Object value = entry.getValue();
        if (descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (descriptor.isRepeated() == true) goto L15;
        if (descriptor.isPacked() == true) goto L15;
        if ((value instanceof LazyField) == false) goto L13;
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value);
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
    L15:
        return computeFieldSize(descriptor, value);
    }

    static int computeElementSize(WireFormat.FieldType type, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type != WireFormat.FieldType.GROUP) goto L6;
        tagSize = tagSize * 2;
    L6:
        return computeElementSizeNoTag(type, value) + tagSize;
    }

    static int computeElementSizeNoTag(WireFormat.FieldType type, Object value) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
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
        if ((value instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) value).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) value).intValue());
    L13:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
    L23:
        if ((value instanceof ByteString) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) value);
    L29:
        if ((value instanceof ByteString) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) value);
    L35:
        if ((value instanceof LazyField) == false) goto L39;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value);
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
    L41:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
        WireFormat.FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated() == true) goto L5;
        int size = computeElementSize(type, number, value);
        return size;
    L5:
        if (descriptor.isPacked() == false) goto L12;
        int dataSize = 0;
        Iterator r3 = ((List) value).iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        Object element = r3.next();
        dataSize = dataSize + computeElementSizeNoTag(type, element);
        goto L8
    L11:
        return (CodedOutputStream.computeTagSize(number) + dataSize) + CodedOutputStream.computeUInt32SizeNoTag(dataSize);
    L12:
        int size2 = 0;
        Iterator r4 = ((List) value).iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        Object element2 = r4.next();
        size2 = size2 + computeElementSize(type, number, element2);
        goto L14
    L16:
        return size2;
    }
}
