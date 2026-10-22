package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public final enum SerializerFeature extends Enum<SerializerFeature> {
    private static final /* synthetic */ SerializerFeature[] $VALUES = null;
    public static final SerializerFeature BeanToArray = null;
    public static final SerializerFeature BrowserCompatible = null;
    public static final SerializerFeature DisableCheckSpecialChar = null;
    public static final SerializerFeature DisableCircularReferenceDetect = null;
    public static final SerializerFeature[] EMPTY = null;
    public static final SerializerFeature NotWriteDefaultValue = null;
    public static final SerializerFeature NotWriteRootClassName = null;
    public static final SerializerFeature PrettyFormat = null;
    public static final SerializerFeature QuoteFieldNames = null;
    public static final SerializerFeature SkipTransientField = null;
    public static final SerializerFeature SortField = null;
    public static final SerializerFeature UseISO8601DateFormat = null;
    public static final SerializerFeature UseSingleQuotes = null;
    public static final SerializerFeature WriteClassName = null;
    public static final SerializerFeature WriteDateUseDateFormat = null;
    public static final SerializerFeature WriteEnumUsingToString = null;
    public static final SerializerFeature WriteMapNullValue = null;
    public static final SerializerFeature WriteNonStringKeyAsString = null;
    public static final SerializerFeature WriteNullBooleanAsFalse = null;
    public static final SerializerFeature WriteNullListAsEmpty = null;
    public static final SerializerFeature WriteNullNumberAsZero = null;
    public static final SerializerFeature WriteNullStringAsEmpty = null;
    public static final SerializerFeature WriteSlashAsSpecial = null;

    @Deprecated
    public static final SerializerFeature WriteTabAsSpecial = null;
    public final int mask;

    static {
        SerializerFeature r10 = new SerializerFeature("QuoteFieldNames", 0);
        QuoteFieldNames = r10;
        SerializerFeature r11 = new SerializerFeature("UseSingleQuotes", 1);
        UseSingleQuotes = r11;
        SerializerFeature r12 = new SerializerFeature("WriteMapNullValue", 2);
        WriteMapNullValue = r12;
        SerializerFeature r13 = new SerializerFeature("WriteEnumUsingToString", 3);
        WriteEnumUsingToString = r13;
        SerializerFeature r14 = new SerializerFeature("UseISO8601DateFormat", 4);
        UseISO8601DateFormat = r14;
        SerializerFeature r15 = new SerializerFeature("WriteNullListAsEmpty", 5);
        WriteNullListAsEmpty = r15;
        SerializerFeature r16 = new SerializerFeature("WriteNullStringAsEmpty", 6);
        WriteNullStringAsEmpty = r16;
        SerializerFeature r17 = new SerializerFeature("WriteNullNumberAsZero", 7);
        WriteNullNumberAsZero = r17;
        SerializerFeature r18 = new SerializerFeature("WriteNullBooleanAsFalse", 8);
        WriteNullBooleanAsFalse = r18;
        SerializerFeature r19 = new SerializerFeature("SkipTransientField", 9);
        SkipTransientField = r19;
        SerializerFeature r110 = new SerializerFeature("SortField", 10);
        SortField = r110;
        SerializerFeature r111 = new SerializerFeature("WriteTabAsSpecial", 11);
        WriteTabAsSpecial = r111;
        SerializerFeature r112 = new SerializerFeature("PrettyFormat", 12);
        PrettyFormat = r112;
        SerializerFeature r113 = new SerializerFeature("WriteClassName", 13);
        WriteClassName = r113;
        SerializerFeature r20 = new SerializerFeature("DisableCircularReferenceDetect", 14);
        DisableCircularReferenceDetect = r20;
        SerializerFeature r21 = new SerializerFeature("WriteSlashAsSpecial", 15);
        WriteSlashAsSpecial = r21;
        SerializerFeature r22 = new SerializerFeature("BrowserCompatible", 16);
        BrowserCompatible = r22;
        SerializerFeature r23 = new SerializerFeature("WriteDateUseDateFormat", 17);
        WriteDateUseDateFormat = r23;
        SerializerFeature r24 = new SerializerFeature("NotWriteRootClassName", 18);
        NotWriteRootClassName = r24;
        SerializerFeature r25 = new SerializerFeature("DisableCheckSpecialChar", 19);
        DisableCheckSpecialChar = r25;
        SerializerFeature r26 = new SerializerFeature("BeanToArray", 20);
        BeanToArray = r26;
        SerializerFeature r27 = new SerializerFeature("WriteNonStringKeyAsString", 21);
        WriteNonStringKeyAsString = r27;
        SerializerFeature r28 = new SerializerFeature("NotWriteDefaultValue", 22);
        NotWriteDefaultValue = r28;
        $VALUES = new SerializerFeature[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23, r24, r25, r26, r27, r28};
        EMPTY = new SerializerFeature[0];
    }

    private SerializerFeature(String r10, int r11) {
        super(r10, r11);
        this.mask = 1 << ordinal();
    }

    public static int of(SerializerFeature[] r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r11 >= r12) goto L8;
        r13 = r13 | r10[r11].mask;
        r11 = r11 + 1;
        goto L6
    L8:
        return r13;
    }

    public static SerializerFeature valueOf(String r10) {
        return (SerializerFeature) Enum.valueOf(SerializerFeature.class, r10);
    }

    public static SerializerFeature[] values() {
        return (SerializerFeature[]) $VALUES.clone();
    }
}
