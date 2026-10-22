package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: androidx.datastore.preferences.protobuf.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0274v {

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0274v f3543b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0274v f3544c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0274v[] f3545d;

    /* renamed from: e, reason: collision with root package name */
    public static final Type[] f3546e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC0274v[] f3547f;

    /* renamed from: a, reason: collision with root package name */
    public final int f3548a;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0274v EF0;

    static {
        G g4 = G.DOUBLE;
        EnumC0274v enumC0274v = new EnumC0274v("DOUBLE", 0, 0, 1, g4);
        G g5 = G.FLOAT;
        EnumC0274v enumC0274v2 = new EnumC0274v("FLOAT", 1, 1, 1, g5);
        G g6 = G.LONG;
        EnumC0274v enumC0274v3 = new EnumC0274v("INT64", 2, 2, 1, g6);
        EnumC0274v enumC0274v4 = new EnumC0274v("UINT64", 3, 3, 1, g6);
        G g7 = G.INT;
        EnumC0274v enumC0274v5 = new EnumC0274v("INT32", 4, 4, 1, g7);
        EnumC0274v enumC0274v6 = new EnumC0274v("FIXED64", 5, 5, 1, g6);
        EnumC0274v enumC0274v7 = new EnumC0274v("FIXED32", 6, 6, 1, g7);
        G g8 = G.BOOLEAN;
        EnumC0274v enumC0274v8 = new EnumC0274v("BOOL", 7, 7, 1, g8);
        G g9 = G.STRING;
        EnumC0274v enumC0274v9 = new EnumC0274v("STRING", 8, 8, 1, g9);
        G g10 = G.MESSAGE;
        EnumC0274v enumC0274v10 = new EnumC0274v("MESSAGE", 9, 9, 1, g10);
        G g11 = G.BYTE_STRING;
        EnumC0274v enumC0274v11 = new EnumC0274v("BYTES", 10, 10, 1, g11);
        EnumC0274v enumC0274v12 = new EnumC0274v("UINT32", 11, 11, 1, g7);
        G g12 = G.ENUM;
        EnumC0274v enumC0274v13 = new EnumC0274v("ENUM", 12, 12, 1, g12);
        EnumC0274v enumC0274v14 = new EnumC0274v("SFIXED32", 13, 13, 1, g7);
        EnumC0274v enumC0274v15 = new EnumC0274v("SFIXED64", 14, 14, 1, g6);
        EnumC0274v enumC0274v16 = new EnumC0274v("SINT32", 15, 15, 1, g7);
        EnumC0274v enumC0274v17 = new EnumC0274v("SINT64", 16, 16, 1, g6);
        EnumC0274v enumC0274v18 = new EnumC0274v("GROUP", 17, 17, 1, g10);
        EnumC0274v enumC0274v19 = new EnumC0274v("DOUBLE_LIST", 18, 18, 2, g4);
        EnumC0274v enumC0274v20 = new EnumC0274v("FLOAT_LIST", 19, 19, 2, g5);
        EnumC0274v enumC0274v21 = new EnumC0274v("INT64_LIST", 20, 20, 2, g6);
        EnumC0274v enumC0274v22 = new EnumC0274v("UINT64_LIST", 21, 21, 2, g6);
        EnumC0274v enumC0274v23 = new EnumC0274v("INT32_LIST", 22, 22, 2, g7);
        EnumC0274v enumC0274v24 = new EnumC0274v("FIXED64_LIST", 23, 23, 2, g6);
        EnumC0274v enumC0274v25 = new EnumC0274v("FIXED32_LIST", 24, 24, 2, g7);
        EnumC0274v enumC0274v26 = new EnumC0274v("BOOL_LIST", 25, 25, 2, g8);
        EnumC0274v enumC0274v27 = new EnumC0274v("STRING_LIST", 26, 26, 2, g9);
        EnumC0274v enumC0274v28 = new EnumC0274v("MESSAGE_LIST", 27, 27, 2, g10);
        EnumC0274v enumC0274v29 = new EnumC0274v("BYTES_LIST", 28, 28, 2, g11);
        EnumC0274v enumC0274v30 = new EnumC0274v("UINT32_LIST", 29, 29, 2, g7);
        EnumC0274v enumC0274v31 = new EnumC0274v("ENUM_LIST", 30, 30, 2, g12);
        EnumC0274v enumC0274v32 = new EnumC0274v("SFIXED32_LIST", 31, 31, 2, g7);
        EnumC0274v enumC0274v33 = new EnumC0274v("SFIXED64_LIST", 32, 32, 2, g6);
        EnumC0274v enumC0274v34 = new EnumC0274v("SINT32_LIST", 33, 33, 2, g7);
        EnumC0274v enumC0274v35 = new EnumC0274v("SINT64_LIST", 34, 34, 2, g6);
        EnumC0274v enumC0274v36 = new EnumC0274v("DOUBLE_LIST_PACKED", 35, 35, 3, g4);
        f3543b = enumC0274v36;
        EnumC0274v enumC0274v37 = new EnumC0274v("FLOAT_LIST_PACKED", 36, 36, 3, g5);
        EnumC0274v enumC0274v38 = new EnumC0274v("INT64_LIST_PACKED", 37, 37, 3, g6);
        EnumC0274v enumC0274v39 = new EnumC0274v("UINT64_LIST_PACKED", 38, 38, 3, g6);
        EnumC0274v enumC0274v40 = new EnumC0274v("INT32_LIST_PACKED", 39, 39, 3, g7);
        EnumC0274v enumC0274v41 = new EnumC0274v("FIXED64_LIST_PACKED", 40, 40, 3, g6);
        EnumC0274v enumC0274v42 = new EnumC0274v("FIXED32_LIST_PACKED", 41, 41, 3, g7);
        EnumC0274v enumC0274v43 = new EnumC0274v("BOOL_LIST_PACKED", 42, 42, 3, g8);
        EnumC0274v enumC0274v44 = new EnumC0274v("UINT32_LIST_PACKED", 43, 43, 3, g7);
        EnumC0274v enumC0274v45 = new EnumC0274v("ENUM_LIST_PACKED", 44, 44, 3, g12);
        EnumC0274v enumC0274v46 = new EnumC0274v("SFIXED32_LIST_PACKED", 45, 45, 3, g7);
        EnumC0274v enumC0274v47 = new EnumC0274v("SFIXED64_LIST_PACKED", 46, 46, 3, g6);
        EnumC0274v enumC0274v48 = new EnumC0274v("SINT32_LIST_PACKED", 47, 47, 3, g7);
        EnumC0274v enumC0274v49 = new EnumC0274v("SINT64_LIST_PACKED", 48, 48, 3, g6);
        f3544c = enumC0274v49;
        f3547f = new EnumC0274v[]{enumC0274v, enumC0274v2, enumC0274v3, enumC0274v4, enumC0274v5, enumC0274v6, enumC0274v7, enumC0274v8, enumC0274v9, enumC0274v10, enumC0274v11, enumC0274v12, enumC0274v13, enumC0274v14, enumC0274v15, enumC0274v16, enumC0274v17, enumC0274v18, enumC0274v19, enumC0274v20, enumC0274v21, enumC0274v22, enumC0274v23, enumC0274v24, enumC0274v25, enumC0274v26, enumC0274v27, enumC0274v28, enumC0274v29, enumC0274v30, enumC0274v31, enumC0274v32, enumC0274v33, enumC0274v34, enumC0274v35, enumC0274v36, enumC0274v37, enumC0274v38, enumC0274v39, enumC0274v40, enumC0274v41, enumC0274v42, enumC0274v43, enumC0274v44, enumC0274v45, enumC0274v46, enumC0274v47, enumC0274v48, enumC0274v49, new EnumC0274v("GROUP_LIST", 49, 49, 2, g10), new EnumC0274v("MAP", 50, 50, 4, G.VOID)};
        f3546e = new Type[0];
        EnumC0274v[] enumC0274vArrValues = values();
        f3545d = new EnumC0274v[enumC0274vArrValues.length];
        for (EnumC0274v enumC0274v50 : enumC0274vArrValues) {
            f3545d[enumC0274v50.f3548a] = enumC0274v50;
        }
    }

    public EnumC0274v(String str, int i4, int i5, int i6, G g4) {
        this.f3548a = i5;
        int iA = t.h.a(i6);
        if (iA == 1 || iA == 3) {
            g4.getClass();
        }
        if (i6 == 1) {
            g4.ordinal();
        }
    }

    public static EnumC0274v valueOf(String str) {
        return (EnumC0274v) Enum.valueOf(EnumC0274v.class, str);
    }

    public static EnumC0274v[] values() {
        return (EnumC0274v[]) f3547f.clone();
    }

    public final int a() {
        return this.f3548a;
    }
}
