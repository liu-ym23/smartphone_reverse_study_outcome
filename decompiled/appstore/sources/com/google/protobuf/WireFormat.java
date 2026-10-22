package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;

    /* JADX INFO: renamed from: com.google.protobuf.WireFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r10 = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r10;
            r10[FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static enum FieldType extends java.lang.Enum<FieldType> {
        private static final /* synthetic */ FieldType[] $VALUES = null;
        public static final FieldType BOOL = null;
        public static final FieldType BYTES = null;
        public static final FieldType DOUBLE = null;
        public static final FieldType ENUM = null;
        public static final FieldType FIXED32 = null;
        public static final FieldType FIXED64 = null;
        public static final FieldType FLOAT = null;
        public static final FieldType GROUP = null;
        public static final FieldType INT32 = null;
        public static final FieldType INT64 = null;
        public static final FieldType MESSAGE = null;
        public static final FieldType SFIXED32 = null;
        public static final FieldType SFIXED64 = null;
        public static final FieldType SINT32 = null;
        public static final FieldType SINT64 = null;
        public static final FieldType STRING = null;
        public static final FieldType UINT32 = null;
        public static final FieldType UINT64 = null;
        private final JavaType javaType;
        private final int wireType;

        static {
            FieldType r10 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r10;
            FieldType r11 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r11;
            JavaType r12 = JavaType.LONG;
            final int r13 = 2;
            FieldType r14 = new FieldType("INT64", 2, r12, 0);
            INT64 = r14;
            final int r15 = 3;
            FieldType r16 = new FieldType("UINT64", 3, r12, 0);
            UINT64 = r16;
            JavaType r17 = JavaType.INT;
            FieldType r18 = new FieldType("INT32", 4, r17, 0);
            INT32 = r18;
            FieldType r19 = new FieldType("FIXED64", 5, r12, 1);
            FIXED64 = r19;
            FieldType r110 = new FieldType("FIXED32", 6, r17, 5);
            FIXED32 = r110;
            FieldType r111 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r111;
            final int r20 = 8;
            final JavaType r112 = JavaType.STRING;
            final String r21 = "STRING";
            FieldType r22 = new AnonymousClass1(r21, r20, r112, r13);
            STRING = r22;
            final JavaType r113 = JavaType.MESSAGE;
            final String r23 = "GROUP";
            final int r24 = 9;
            FieldType r25 = new AnonymousClass2(r23, r24, r113, r15);
            GROUP = r25;
            final String r26 = "MESSAGE";
            final int r114 = 10;
            final int r27 = 2;
            FieldType r28 = new AnonymousClass3(r26, r114, r113, r27);
            MESSAGE = r28;
            final int r115 = 11;
            final JavaType r116 = JavaType.BYTE_STRING;
            final String r29 = "BYTES";
            FieldType r30 = new AnonymousClass4(r29, r115, r116, r27);
            BYTES = r30;
            FieldType r31 = new FieldType("UINT32", 12, r17, 0);
            UINT32 = r31;
            FieldType r32 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r32;
            FieldType r33 = new FieldType("SFIXED32", 14, r17, 5);
            SFIXED32 = r33;
            FieldType r34 = new FieldType("SFIXED64", 15, r12, 1);
            SFIXED64 = r34;
            FieldType r35 = new FieldType("SINT32", 16, r17, 0);
            SINT32 = r35;
            FieldType r117 = new FieldType("SINT64", 17, r12, 0);
            SINT64 = r117;
            $VALUES = new FieldType[]{r10, r11, r14, r16, r18, r19, r110, r111, r22, r25, r28, r30, r31, r32, r33, r34, r35, r117};
        }

        public /* synthetic */ FieldType(String r10, int r11, JavaType r12, int r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        public static FieldType valueOf(String r10) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, r10);
        }

        public static FieldType[] values() {
            return (FieldType[]) $VALUES.clone();
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(String r10, int r11, JavaType r12, int r13) {
            super(r10, r11);
            this.javaType = r12;
            this.wireType = r13;
        }
    }

    public static final enum JavaType extends java.lang.Enum<JavaType> {
        private static final /* synthetic */ JavaType[] $VALUES = null;
        public static final JavaType BOOLEAN = null;
        public static final JavaType BYTE_STRING = null;
        public static final JavaType DOUBLE = null;
        public static final JavaType ENUM = null;
        public static final JavaType FLOAT = null;
        public static final JavaType INT = null;
        public static final JavaType LONG = null;
        public static final JavaType MESSAGE = null;
        public static final JavaType STRING = null;
        private final Object defaultDefault;

        static {
            JavaType r10 = new JavaType("INT", 0, 0);
            INT = r10;
            JavaType r11 = new JavaType("LONG", 1, 0L);
            LONG = r11;
            JavaType r12 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r12;
            JavaType r13 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            DOUBLE = r13;
            JavaType r14 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            BOOLEAN = r14;
            JavaType r15 = new JavaType("STRING", 5, "");
            STRING = r15;
            JavaType r16 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r16;
            JavaType r17 = new JavaType("ENUM", 7, null);
            ENUM = r17;
            JavaType r18 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r18;
            $VALUES = new JavaType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private JavaType(String r10, int r11, Object r12) {
            super(r10, r11);
            this.defaultDefault = r12;
        }

        public static JavaType valueOf(String r10) {
            return (JavaType) java.lang.Enum.valueOf(JavaType.class, r10);
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public static abstract enum Utf8Validation extends java.lang.Enum<Utf8Validation> {
        private static final /* synthetic */ Utf8Validation[] $VALUES = null;
        public static final Utf8Validation LAZY = null;
        public static final Utf8Validation LOOSE = null;
        public static final Utf8Validation STRICT = null;

        static {
            final String r10 = "LOOSE";
            final int r11 = 0;
            Utf8Validation r12 = new AnonymousClass1(r10, r11);
            LOOSE = r12;
            final String r13 = "STRICT";
            final int r14 = 1;
            Utf8Validation r15 = new AnonymousClass2(r13, r14);
            STRICT = r15;
            final String r16 = "LAZY";
            final int r17 = 2;
            Utf8Validation r18 = new AnonymousClass3(r16, r17);
            LAZY = r18;
            $VALUES = new Utf8Validation[]{r12, r15, r18};
        }

        private Utf8Validation(String r10, int r11) {
            super(r10, r11);
        }

        public static Utf8Validation valueOf(String r10) {
            return (Utf8Validation) java.lang.Enum.valueOf(Utf8Validation.class, r10);
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) $VALUES.clone();
        }

        public abstract Object readString(CodedInputStream r10) throws IOException;

        public /* synthetic */ Utf8Validation(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int r10) {
        return r10 >>> 3;
    }

    public static int getTagWireType(int r10) {
        return r10 & 7;
    }

    public static int makeTag(int r10, int r11) {
        return (r10 << 3) | r11;
    }

    public static Object readPrimitiveField(CodedInputStream r10, FieldType r11, Utf8Validation r12) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r11.ordinal()]) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return r12.readString(r10);
    L15:
        return Long.valueOf(r10.readSInt64());
    L17:
        return Integer.valueOf(r10.readSInt32());
    L19:
        return Long.valueOf(r10.readSFixed64());
    L21:
        return Integer.valueOf(r10.readSFixed32());
    L23:
        return Integer.valueOf(r10.readUInt32());
    L25:
        return r10.readBytes();
    L27:
        return Boolean.valueOf(r10.readBool());
    L29:
        return Integer.valueOf(r10.readFixed32());
    L31:
        return Long.valueOf(r10.readFixed64());
    L33:
        return Integer.valueOf(r10.readInt32());
    L35:
        return Long.valueOf(r10.readUInt64());
    L37:
        return Long.valueOf(r10.readInt64());
    L39:
        return Float.valueOf(r10.readFloat());
    L41:
        return Double.valueOf(r10.readDouble());
    }
}
