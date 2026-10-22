package com.google.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF3' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class Descriptors$FieldDescriptor$Type {
    public static final Descriptors$FieldDescriptor$Type b;
    public static final Descriptors$FieldDescriptor$Type c;
    public static final Descriptors$FieldDescriptor$Type d;
    public static final Descriptors$FieldDescriptor$Type e;
    public static final Descriptors$FieldDescriptor$Type f;
    public static final Descriptors$FieldDescriptor$Type[] g;
    public static final /* synthetic */ Descriptors$FieldDescriptor$Type[] h;

    /* renamed from: a, reason: collision with root package name */
    public final Descriptors$FieldDescriptor$JavaType f2824a;

    /* JADX INFO: Fake field, exist only in values array */
    Descriptors$FieldDescriptor$Type EF1;

    /* JADX INFO: Fake field, exist only in values array */
    Descriptors$FieldDescriptor$Type EF2;

    /* JADX INFO: Fake field, exist only in values array */
    Descriptors$FieldDescriptor$Type EF3;

    static {
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type = new Descriptors$FieldDescriptor$Type("DOUBLE", 0, Descriptors$FieldDescriptor$JavaType.DOUBLE);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2 = new Descriptors$FieldDescriptor$Type("FLOAT", 1, Descriptors$FieldDescriptor$JavaType.FLOAT);
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.LONG;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type3 = new Descriptors$FieldDescriptor$Type("INT64", 2, descriptors$FieldDescriptor$JavaType);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type4 = new Descriptors$FieldDescriptor$Type("UINT64", 3, descriptors$FieldDescriptor$JavaType);
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2 = Descriptors$FieldDescriptor$JavaType.INT;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type5 = new Descriptors$FieldDescriptor$Type("INT32", 4, descriptors$FieldDescriptor$JavaType2);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type6 = new Descriptors$FieldDescriptor$Type("FIXED64", 5, descriptors$FieldDescriptor$JavaType);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type7 = new Descriptors$FieldDescriptor$Type("FIXED32", 6, descriptors$FieldDescriptor$JavaType2);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type8 = new Descriptors$FieldDescriptor$Type("BOOL", 7, Descriptors$FieldDescriptor$JavaType.BOOLEAN);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type9 = new Descriptors$FieldDescriptor$Type("STRING", 8, Descriptors$FieldDescriptor$JavaType.STRING);
        b = descriptors$FieldDescriptor$Type9;
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType3 = Descriptors$FieldDescriptor$JavaType.MESSAGE;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type10 = new Descriptors$FieldDescriptor$Type("GROUP", 9, descriptors$FieldDescriptor$JavaType3);
        c = descriptors$FieldDescriptor$Type10;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type11 = new Descriptors$FieldDescriptor$Type("MESSAGE", 10, descriptors$FieldDescriptor$JavaType3);
        d = descriptors$FieldDescriptor$Type11;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type12 = new Descriptors$FieldDescriptor$Type("BYTES", 11, Descriptors$FieldDescriptor$JavaType.BYTE_STRING);
        e = descriptors$FieldDescriptor$Type12;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type13 = new Descriptors$FieldDescriptor$Type("UINT32", 12, descriptors$FieldDescriptor$JavaType2);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type14 = new Descriptors$FieldDescriptor$Type("ENUM", 13, Descriptors$FieldDescriptor$JavaType.ENUM);
        f = descriptors$FieldDescriptor$Type14;
        h = new Descriptors$FieldDescriptor$Type[]{descriptors$FieldDescriptor$Type, descriptors$FieldDescriptor$Type2, descriptors$FieldDescriptor$Type3, descriptors$FieldDescriptor$Type4, descriptors$FieldDescriptor$Type5, descriptors$FieldDescriptor$Type6, descriptors$FieldDescriptor$Type7, descriptors$FieldDescriptor$Type8, descriptors$FieldDescriptor$Type9, descriptors$FieldDescriptor$Type10, descriptors$FieldDescriptor$Type11, descriptors$FieldDescriptor$Type12, descriptors$FieldDescriptor$Type13, descriptors$FieldDescriptor$Type14, new Descriptors$FieldDescriptor$Type("SFIXED32", 14, descriptors$FieldDescriptor$JavaType2), new Descriptors$FieldDescriptor$Type("SFIXED64", 15, descriptors$FieldDescriptor$JavaType), new Descriptors$FieldDescriptor$Type("SINT32", 16, descriptors$FieldDescriptor$JavaType2), new Descriptors$FieldDescriptor$Type("SINT64", 17, descriptors$FieldDescriptor$JavaType)};
        g = values();
    }

    public Descriptors$FieldDescriptor$Type(String str, int i, Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType) {
        this.f2824a = descriptors$FieldDescriptor$JavaType;
    }

    public static Descriptors$FieldDescriptor$Type valueOf(String str) {
        return (Descriptors$FieldDescriptor$Type) Enum.valueOf(Descriptors$FieldDescriptor$Type.class, str);
    }

    public static Descriptors$FieldDescriptor$Type[] values() {
        return (Descriptors$FieldDescriptor$Type[]) h.clone();
    }
}
