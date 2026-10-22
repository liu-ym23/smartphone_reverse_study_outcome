package com.bytedance.location.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final enum FieldType extends Enum<FieldType> {
    private static final /* synthetic */ FieldType[] $VALUES = null;
    public static final FieldType BOOL = null;
    public static final FieldType BOOL_LIST = null;
    public static final FieldType BOOL_LIST_PACKED = null;
    public static final FieldType BYTES = null;
    public static final FieldType BYTES_LIST = null;
    public static final FieldType DOUBLE = null;
    public static final FieldType DOUBLE_LIST = null;
    public static final FieldType DOUBLE_LIST_PACKED = null;
    private static final Type[] EMPTY_TYPES = null;
    public static final FieldType ENUM = null;
    public static final FieldType ENUM_LIST = null;
    public static final FieldType ENUM_LIST_PACKED = null;
    public static final FieldType FIXED32 = null;
    public static final FieldType FIXED32_LIST = null;
    public static final FieldType FIXED32_LIST_PACKED = null;
    public static final FieldType FIXED64 = null;
    public static final FieldType FIXED64_LIST = null;
    public static final FieldType FIXED64_LIST_PACKED = null;
    public static final FieldType FLOAT = null;
    public static final FieldType FLOAT_LIST = null;
    public static final FieldType FLOAT_LIST_PACKED = null;
    public static final FieldType GROUP = null;
    public static final FieldType GROUP_LIST = null;
    public static final FieldType INT32 = null;
    public static final FieldType INT32_LIST = null;
    public static final FieldType INT32_LIST_PACKED = null;
    public static final FieldType INT64 = null;
    public static final FieldType INT64_LIST = null;
    public static final FieldType INT64_LIST_PACKED = null;
    public static final FieldType MAP = null;
    public static final FieldType MESSAGE = null;
    public static final FieldType MESSAGE_LIST = null;
    public static final FieldType SFIXED32 = null;
    public static final FieldType SFIXED32_LIST = null;
    public static final FieldType SFIXED32_LIST_PACKED = null;
    public static final FieldType SFIXED64 = null;
    public static final FieldType SFIXED64_LIST = null;
    public static final FieldType SFIXED64_LIST_PACKED = null;
    public static final FieldType SINT32 = null;
    public static final FieldType SINT32_LIST = null;
    public static final FieldType SINT32_LIST_PACKED = null;
    public static final FieldType SINT64 = null;
    public static final FieldType SINT64_LIST = null;
    public static final FieldType SINT64_LIST_PACKED = null;
    public static final FieldType STRING = null;
    public static final FieldType STRING_LIST = null;
    public static final FieldType UINT32 = null;
    public static final FieldType UINT32_LIST = null;
    public static final FieldType UINT32_LIST_PACKED = null;
    public static final FieldType UINT64 = null;
    public static final FieldType UINT64_LIST = null;
    public static final FieldType UINT64_LIST_PACKED = null;
    private static final FieldType[] VALUES = null;
    private final Collection collection;
    private final Class<?> elementType;
    private final int id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    /* JADX INFO: renamed from: com.bytedance.location.protobuf.FieldType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        static {
            $SwitchMap$com$google$protobuf$JavaType = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType[JavaType.BYTE_STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum Collection extends Enum<Collection> {
        private static final /* synthetic */ Collection[] $VALUES = null;
        public static final Collection MAP = null;
        public static final Collection PACKED_VECTOR = null;
        public static final Collection SCALAR = null;
        public static final Collection VECTOR = null;
        private final boolean isList;

        private static /* synthetic */ Collection[] $values() {
            return new Collection[]{SCALAR, VECTOR, PACKED_VECTOR, MAP};
        }

        public static Collection valueOf(String name) {
            return (Collection) Enum.valueOf(Collection.class, name);
        }

        public static Collection[] values() {
            return (Collection[]) $VALUES.clone();
        }

        static {
            SCALAR = new Collection("SCALAR", 0, false);
            VECTOR = new Collection("VECTOR", 1, true);
            PACKED_VECTOR = new Collection("PACKED_VECTOR", 2, true);
            MAP = new Collection("MAP", 3, false);
            $VALUES = $values();
        }

        private Collection(String r1, int r2, boolean isList) {
            super(r1, r2);
            this.isList = isList;
        }

        public boolean isList() {
            return this.isList;
        }
    }

    private static /* synthetic */ FieldType[] $values() {
        return new FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64, GROUP, DOUBLE_LIST, FLOAT_LIST, INT64_LIST, UINT64_LIST, INT32_LIST, FIXED64_LIST, FIXED32_LIST, BOOL_LIST, STRING_LIST, MESSAGE_LIST, BYTES_LIST, UINT32_LIST, ENUM_LIST, SFIXED32_LIST, SFIXED64_LIST, SINT32_LIST, SINT64_LIST, DOUBLE_LIST_PACKED, FLOAT_LIST_PACKED, INT64_LIST_PACKED, UINT64_LIST_PACKED, INT32_LIST_PACKED, FIXED64_LIST_PACKED, FIXED32_LIST_PACKED, BOOL_LIST_PACKED, UINT32_LIST_PACKED, ENUM_LIST_PACKED, SFIXED32_LIST_PACKED, SFIXED64_LIST_PACKED, SINT32_LIST_PACKED, SINT64_LIST_PACKED, GROUP_LIST, MAP};
    }

    public static FieldType valueOf(String name) {
        return (FieldType) Enum.valueOf(FieldType.class, name);
    }

    public static FieldType[] values() {
        return (FieldType[]) $VALUES.clone();
    }

    static {
        DOUBLE = new FieldType("DOUBLE", 0, 0, Collection.SCALAR, JavaType.DOUBLE);
        FLOAT = new FieldType("FLOAT", 1, 1, Collection.SCALAR, JavaType.FLOAT);
        INT64 = new FieldType("INT64", 2, 2, Collection.SCALAR, JavaType.LONG);
        UINT64 = new FieldType("UINT64", 3, 3, Collection.SCALAR, JavaType.LONG);
        INT32 = new FieldType("INT32", 4, 4, Collection.SCALAR, JavaType.INT);
        FIXED64 = new FieldType("FIXED64", 5, 5, Collection.SCALAR, JavaType.LONG);
        FIXED32 = new FieldType("FIXED32", 6, 6, Collection.SCALAR, JavaType.INT);
        BOOL = new FieldType("BOOL", 7, 7, Collection.SCALAR, JavaType.BOOLEAN);
        STRING = new FieldType("STRING", 8, 8, Collection.SCALAR, JavaType.STRING);
        MESSAGE = new FieldType("MESSAGE", 9, 9, Collection.SCALAR, JavaType.MESSAGE);
        BYTES = new FieldType("BYTES", 10, 10, Collection.SCALAR, JavaType.BYTE_STRING);
        UINT32 = new FieldType("UINT32", 11, 11, Collection.SCALAR, JavaType.INT);
        ENUM = new FieldType("ENUM", 12, 12, Collection.SCALAR, JavaType.ENUM);
        SFIXED32 = new FieldType("SFIXED32", 13, 13, Collection.SCALAR, JavaType.INT);
        SFIXED64 = new FieldType("SFIXED64", 14, 14, Collection.SCALAR, JavaType.LONG);
        SINT32 = new FieldType("SINT32", 15, 15, Collection.SCALAR, JavaType.INT);
        SINT64 = new FieldType("SINT64", 16, 16, Collection.SCALAR, JavaType.LONG);
        GROUP = new FieldType("GROUP", 17, 17, Collection.SCALAR, JavaType.MESSAGE);
        DOUBLE_LIST = new FieldType("DOUBLE_LIST", 18, 18, Collection.VECTOR, JavaType.DOUBLE);
        FLOAT_LIST = new FieldType("FLOAT_LIST", 19, 19, Collection.VECTOR, JavaType.FLOAT);
        INT64_LIST = new FieldType("INT64_LIST", 20, 20, Collection.VECTOR, JavaType.LONG);
        UINT64_LIST = new FieldType("UINT64_LIST", 21, 21, Collection.VECTOR, JavaType.LONG);
        INT32_LIST = new FieldType("INT32_LIST", 22, 22, Collection.VECTOR, JavaType.INT);
        FIXED64_LIST = new FieldType("FIXED64_LIST", 23, 23, Collection.VECTOR, JavaType.LONG);
        FIXED32_LIST = new FieldType("FIXED32_LIST", 24, 24, Collection.VECTOR, JavaType.INT);
        BOOL_LIST = new FieldType("BOOL_LIST", 25, 25, Collection.VECTOR, JavaType.BOOLEAN);
        STRING_LIST = new FieldType("STRING_LIST", 26, 26, Collection.VECTOR, JavaType.STRING);
        MESSAGE_LIST = new FieldType("MESSAGE_LIST", 27, 27, Collection.VECTOR, JavaType.MESSAGE);
        BYTES_LIST = new FieldType("BYTES_LIST", 28, 28, Collection.VECTOR, JavaType.BYTE_STRING);
        UINT32_LIST = new FieldType("UINT32_LIST", 29, 29, Collection.VECTOR, JavaType.INT);
        ENUM_LIST = new FieldType("ENUM_LIST", 30, 30, Collection.VECTOR, JavaType.ENUM);
        SFIXED32_LIST = new FieldType("SFIXED32_LIST", 31, 31, Collection.VECTOR, JavaType.INT);
        SFIXED64_LIST = new FieldType("SFIXED64_LIST", 32, 32, Collection.VECTOR, JavaType.LONG);
        SINT32_LIST = new FieldType("SINT32_LIST", 33, 33, Collection.VECTOR, JavaType.INT);
        SINT64_LIST = new FieldType("SINT64_LIST", 34, 34, Collection.VECTOR, JavaType.LONG);
        DOUBLE_LIST_PACKED = new FieldType("DOUBLE_LIST_PACKED", 35, 35, Collection.PACKED_VECTOR, JavaType.DOUBLE);
        FLOAT_LIST_PACKED = new FieldType("FLOAT_LIST_PACKED", 36, 36, Collection.PACKED_VECTOR, JavaType.FLOAT);
        INT64_LIST_PACKED = new FieldType("INT64_LIST_PACKED", 37, 37, Collection.PACKED_VECTOR, JavaType.LONG);
        UINT64_LIST_PACKED = new FieldType("UINT64_LIST_PACKED", 38, 38, Collection.PACKED_VECTOR, JavaType.LONG);
        INT32_LIST_PACKED = new FieldType("INT32_LIST_PACKED", 39, 39, Collection.PACKED_VECTOR, JavaType.INT);
        FIXED64_LIST_PACKED = new FieldType("FIXED64_LIST_PACKED", 40, 40, Collection.PACKED_VECTOR, JavaType.LONG);
        FIXED32_LIST_PACKED = new FieldType("FIXED32_LIST_PACKED", 41, 41, Collection.PACKED_VECTOR, JavaType.INT);
        BOOL_LIST_PACKED = new FieldType("BOOL_LIST_PACKED", 42, 42, Collection.PACKED_VECTOR, JavaType.BOOLEAN);
        UINT32_LIST_PACKED = new FieldType("UINT32_LIST_PACKED", 43, 43, Collection.PACKED_VECTOR, JavaType.INT);
        ENUM_LIST_PACKED = new FieldType("ENUM_LIST_PACKED", 44, 44, Collection.PACKED_VECTOR, JavaType.ENUM);
        SFIXED32_LIST_PACKED = new FieldType("SFIXED32_LIST_PACKED", 45, 45, Collection.PACKED_VECTOR, JavaType.INT);
        SFIXED64_LIST_PACKED = new FieldType("SFIXED64_LIST_PACKED", 46, 46, Collection.PACKED_VECTOR, JavaType.LONG);
        SINT32_LIST_PACKED = new FieldType("SINT32_LIST_PACKED", 47, 47, Collection.PACKED_VECTOR, JavaType.INT);
        SINT64_LIST_PACKED = new FieldType("SINT64_LIST_PACKED", 48, 48, Collection.PACKED_VECTOR, JavaType.LONG);
        GROUP_LIST = new FieldType("GROUP_LIST", 49, 49, Collection.VECTOR, JavaType.MESSAGE);
        MAP = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
        $VALUES = $values();
        int r0 = 0;
        EMPTY_TYPES = new Type[0];
        FieldType[] values = values();
        VALUES = new FieldType[values.length];
        int r2 = values.length;
    L4:
        if (r0 >= r2) goto L6;
        FieldType type = values[r0];
        VALUES[type.id] = type;
        r0 = r0 + 1;
        goto L4
    }

    private FieldType(String r2, int r3, int id, Collection collection, JavaType javaType) {
        super(r2, r3);
        this.id = id;
        this.collection = collection;
        this.javaType = javaType;
        switch(collection.ordinal()) {
            case 1: goto L6;
            case 2: goto L4;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        this.elementType = null;
    L7:
        boolean primitiveScalar = false;
        if (collection == Collection.SCALAR) goto L10;
    L13:
        this.primitiveScalar = primitiveScalar;
        return;
    L10:
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType[javaType.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            default: goto L11;
        };
    L11:
        primitiveScalar = true;
        goto L13
    L5:
        this.elementType = javaType.getBoxedType();
        goto L7
    L6:
        this.elementType = javaType.getBoxedType();
        goto L7
    }

    public int id() {
        return this.id;
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        if (this.collection != Collection.SCALAR) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        if (this.collection != Collection.MAP) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidForField(Field field) {
        if (Collection.VECTOR.equals(this.collection) == false) goto L7;
        return isValidForList(field);
    L7:
        return this.javaType.getType().isAssignableFrom(field.getType());
    }

    private boolean isValidForList(Field field) {
        Class<?> clazz = field.getType();
        if (this.javaType.getType().isAssignableFrom(clazz) == true) goto L6;
        return false;
    L6:
        Type[] types = EMPTY_TYPES;
        Type genericType = field.getGenericType();
        if ((genericType instanceof ParameterizedType) == false) goto L9;
        types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
    L9:
        Type listParameter = getListParameter(clazz, types);
        if ((listParameter instanceof Class) == true) goto L14;
        return true;
    L14:
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public static FieldType forId(int id) {
        if (id >= 0) goto L4;
        return null;
    L4:
        if (id < VALUES.length) goto L7;
        return null;
    L7:
        return VALUES[id];
    }

    private static Type getGenericSuperList(Class<?> clazz) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        int r1 = genericInterfaces.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Type genericInterface = genericInterfaces[r2];
        if ((genericInterface instanceof ParameterizedType) == false) goto L9;
        ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
        Class<?> rawType = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(rawType) == false) goto L9;
        return genericInterface;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        Type type = clazz.getGenericSuperclass();
        if ((type instanceof ParameterizedType) == false) goto L15;
        ParameterizedType parameterizedType2 = (ParameterizedType) type;
        Class<?> rawType2 = (Class) parameterizedType2.getRawType();
        if (List.class.isAssignableFrom(rawType2) == false) goto L21;
        return type;
    L21:
        return null;
    L15:
        return null;
    }

    private static Type getListParameter(Class<?> clazz, Type[] realTypes) {
    L2:
        int r1 = 0;
        if (clazz == List.class) goto L36;
        Type genericType = getGenericSuperList(clazz);
        if ((genericType instanceof ParameterizedType) == true) goto L6;
        realTypes = EMPTY_TYPES;
        Class<?>[] r2 = clazz.getInterfaces();
        int r3 = r2.length;
    L29:
        if (r1 >= r3) goto L34;
        Class<?> iface = r2[r1];
        if (List.class.isAssignableFrom(iface) == true) goto L32;
        r1 = r1 + 1;
        goto L29
    L32:
        clazz = iface;
        goto L2
    L34:
        clazz = clazz.getSuperclass();
        goto L2
    L6:
        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] superArgs = parameterizedType.getActualTypeArguments();
        int i = 0;
    L8:
        if (i >= superArgs.length) goto L27;
        Type superArg = superArgs[i];
        if ((superArg instanceof TypeVariable) == false) goto L26;
        TypeVariable<?>[] clazzParams = clazz.getTypeParameters();
        if (realTypes.length != clazzParams.length) goto L25;
        boolean foundReplacement = false;
        int j = 0;
    L15:
        if (j >= clazzParams.length) goto L20;
        if (superArg == clazzParams[j]) goto L18;
        j = j + 1;
        goto L15
    L18:
        Type realType = realTypes[j];
        superArgs[i] = realType;
        foundReplacement = true;
    L20:
        if (foundReplacement == true) goto L26;
        throw new RuntimeException("Unable to find replacement for " + superArg);
    L25:
        throw new RuntimeException("Type array mismatch");
    L26:
        i = i + 1;
        goto L8
    L27:
        Class<?> parent = (Class) parameterizedType.getRawType();
        realTypes = superArgs;
        clazz = parent;
        goto L2
    L36:
        if (realTypes.length != 1) goto L40;
        return realTypes[0];
    L40:
        throw new RuntimeException("Unable to identify parameter type for List<T>");
    }
}
