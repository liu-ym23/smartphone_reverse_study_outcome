package com.google.gson;

/* JADX INFO: loaded from: classes3.dex */
public abstract enum FieldNamingPolicy extends Enum<FieldNamingPolicy> implements FieldNamingStrategy {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES = null;
    public static final FieldNamingPolicy IDENTITY = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS = null;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE = null;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES = null;

    static {
        final String r10 = "IDENTITY";
        final int r11 = 0;
        FieldNamingPolicy r12 = new AnonymousClass1(r10, r11);
        IDENTITY = r12;
        final String r13 = "UPPER_CAMEL_CASE";
        final int r14 = 1;
        FieldNamingPolicy r15 = new AnonymousClass2(r13, r14);
        UPPER_CAMEL_CASE = r15;
        final String r16 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int r17 = 2;
        FieldNamingPolicy r18 = new AnonymousClass3(r16, r17);
        UPPER_CAMEL_CASE_WITH_SPACES = r18;
        final String r19 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r20 = 3;
        FieldNamingPolicy r21 = new AnonymousClass4(r19, r20);
        LOWER_CASE_WITH_UNDERSCORES = r21;
        final String r22 = "LOWER_CASE_WITH_DASHES";
        final int r110 = 4;
        FieldNamingPolicy r23 = new AnonymousClass5(r22, r110);
        LOWER_CASE_WITH_DASHES = r23;
        final String r111 = "LOWER_CASE_WITH_DOTS";
        final int r112 = 5;
        FieldNamingPolicy r24 = new AnonymousClass6(r111, r112);
        LOWER_CASE_WITH_DOTS = r24;
        $VALUES = new FieldNamingPolicy[]{r12, r15, r18, r21, r23, r24};
    }

    private FieldNamingPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static String separateCamelCase(String r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        int r13 = r10.length();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        char r15 = r10.charAt(r14);
        if (Character.isUpperCase(r15) == false) goto L9;
        if (r12.length() == 0) goto L9;
        r12.append(r11);
    L9:
        r12.append(r15);
        r14 = r14 + 1;
        goto L3
    L11:
        return r12.toString();
    }

    public static String upperCaseFirstLetter(String r10) {
        int r11 = r10.length() - 1;
        int r12 = 0;
    L4:
        if (Character.isLetter(r10.charAt(r12)) == true) goto L7;
        if (r12 >= r11) goto L7;
        r12 = r12 + 1;
    L7:
        char r13 = r10.charAt(r12);
        if (Character.isUpperCase(r13) == false) goto L10;
        return r10;
    L10:
        char r14 = Character.toUpperCase(r13);
        if (r12 != 0) goto L15;
        return r14 + r10.substring(1);
    L15:
        return r10.substring(0, r12) + r14 + r10.substring(r12 + 1);
    }

    public static FieldNamingPolicy valueOf(String r10) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, r10);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ FieldNamingPolicy(String r10, int r11, AnonymousClass1 r12) {
        this(r10, r11);
    }
}
