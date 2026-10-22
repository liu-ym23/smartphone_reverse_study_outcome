package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public class WireFormat$FieldType {
    public static final WireFormat$FieldType c;
    public static final WireFormat$FieldType d;
    public static final WireFormat$FieldType e;
    public static final WireFormat$FieldType f;
    public static final WireFormat$FieldType g;
    public static final /* synthetic */ WireFormat$FieldType[] h;

    /* renamed from: a, reason: collision with root package name */
    public final WireFormat$JavaType f5101a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    WireFormat$FieldType EF0;

    /* JADX INFO: Fake field, exist only in values array */
    WireFormat$FieldType EF1;

    /* JADX INFO: Fake field, exist only in values array */
    WireFormat$FieldType EF2;

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType$1, reason: invalid class name */
    public enum AnonymousClass1 extends WireFormat$FieldType {
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType$2, reason: invalid class name */
    public enum AnonymousClass2 extends WireFormat$FieldType {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType
        public final boolean a() {
            return false;
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType$3, reason: invalid class name */
    public enum AnonymousClass3 extends WireFormat$FieldType {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType
        public final boolean a() {
            return false;
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType$4, reason: invalid class name */
    public enum AnonymousClass4 extends WireFormat$FieldType {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType
        public final boolean a() {
            return false;
        }
    }

    static {
        WireFormat$FieldType wireFormat$FieldType = new WireFormat$FieldType("DOUBLE", 0, WireFormat$JavaType.DOUBLE, 1);
        WireFormat$FieldType wireFormat$FieldType2 = new WireFormat$FieldType("FLOAT", 1, WireFormat$JavaType.FLOAT, 5);
        WireFormat$JavaType wireFormat$JavaType = WireFormat$JavaType.LONG;
        WireFormat$FieldType wireFormat$FieldType3 = new WireFormat$FieldType("INT64", 2, wireFormat$JavaType, 0);
        WireFormat$FieldType wireFormat$FieldType4 = new WireFormat$FieldType("UINT64", 3, wireFormat$JavaType, 0);
        WireFormat$JavaType wireFormat$JavaType2 = WireFormat$JavaType.INT;
        WireFormat$FieldType wireFormat$FieldType5 = new WireFormat$FieldType("INT32", 4, wireFormat$JavaType2, 0);
        c = wireFormat$FieldType5;
        WireFormat$FieldType wireFormat$FieldType6 = new WireFormat$FieldType("FIXED64", 5, wireFormat$JavaType, 1);
        WireFormat$FieldType wireFormat$FieldType7 = new WireFormat$FieldType("FIXED32", 6, wireFormat$JavaType2, 5);
        WireFormat$FieldType wireFormat$FieldType8 = new WireFormat$FieldType("BOOL", 7, WireFormat$JavaType.BOOLEAN, 0);
        d = wireFormat$FieldType8;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("STRING", 8, WireFormat$JavaType.STRING, 2);
        WireFormat$JavaType wireFormat$JavaType3 = WireFormat$JavaType.MESSAGE;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("GROUP", 9, wireFormat$JavaType3, 3);
        e = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3("MESSAGE", 10, wireFormat$JavaType3, 2);
        f = anonymousClass3;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4("BYTES", 11, WireFormat$JavaType.BYTE_STRING, 2);
        WireFormat$FieldType wireFormat$FieldType9 = new WireFormat$FieldType("UINT32", 12, wireFormat$JavaType2, 0);
        WireFormat$FieldType wireFormat$FieldType10 = new WireFormat$FieldType("ENUM", 13, WireFormat$JavaType.ENUM, 0);
        g = wireFormat$FieldType10;
        h = new WireFormat$FieldType[]{wireFormat$FieldType, wireFormat$FieldType2, wireFormat$FieldType3, wireFormat$FieldType4, wireFormat$FieldType5, wireFormat$FieldType6, wireFormat$FieldType7, wireFormat$FieldType8, anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, wireFormat$FieldType9, wireFormat$FieldType10, new WireFormat$FieldType("SFIXED32", 14, wireFormat$JavaType2, 5), new WireFormat$FieldType("SFIXED64", 15, wireFormat$JavaType, 1), new WireFormat$FieldType("SINT32", 16, wireFormat$JavaType2, 0), new WireFormat$FieldType("SINT64", 17, wireFormat$JavaType, 0)};
    }

    public WireFormat$FieldType(String str, int i, WireFormat$JavaType wireFormat$JavaType, int i6) {
        this.f5101a = wireFormat$JavaType;
        this.b = i6;
    }

    public static WireFormat$FieldType valueOf(String str) {
        return (WireFormat$FieldType) Enum.valueOf(WireFormat$FieldType.class, str);
    }

    public static WireFormat$FieldType[] values() {
        return (WireFormat$FieldType[]) h.clone();
    }

    public boolean a() {
        return !(this instanceof AnonymousClass1);
    }
}
