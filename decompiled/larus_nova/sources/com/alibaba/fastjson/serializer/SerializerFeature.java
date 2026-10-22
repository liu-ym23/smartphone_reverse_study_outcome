package com.alibaba.fastjson.serializer;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum SerializerFeature extends Enum<SerializerFeature> {
    private static final /* synthetic */ SerializerFeature[] $VALUES = null;
    public static final SerializerFeature BeanToArray = null;
    public static final SerializerFeature BrowserCompatible = null;
    public static final SerializerFeature BrowserSecure = null;
    public static final SerializerFeature DisableCheckSpecialChar = null;
    public static final SerializerFeature DisableCircularReferenceDetect = null;
    public static final SerializerFeature[] EMPTY = null;
    public static final SerializerFeature IgnoreErrorGetter = null;
    public static final SerializerFeature IgnoreNonFieldGetter = null;
    public static final SerializerFeature MapSortField = null;
    public static final SerializerFeature NotWriteDefaultValue = null;
    public static final SerializerFeature NotWriteRootClassName = null;
    public static final SerializerFeature PrettyFormat = null;
    public static final SerializerFeature QuoteFieldNames = null;
    public static final SerializerFeature SkipTransientField = null;
    public static final SerializerFeature SortField = null;
    public static final SerializerFeature UseISO8601DateFormat = null;
    public static final SerializerFeature UseSingleQuotes = null;
    public static final int WRITE_MAP_NULL_FEATURES = 0;
    public static final SerializerFeature WriteBigDecimalAsPlain = null;
    public static final SerializerFeature WriteClassName = null;
    public static final SerializerFeature WriteDateUseDateFormat = null;
    public static final SerializerFeature WriteEnumUsingName = null;
    public static final SerializerFeature WriteEnumUsingToString = null;
    public static final SerializerFeature WriteMapNullValue = null;
    public static final SerializerFeature WriteNonStringKeyAsString = null;
    public static final SerializerFeature WriteNonStringValueAsString = null;
    public static final SerializerFeature WriteNullBooleanAsFalse = null;
    public static final SerializerFeature WriteNullListAsEmpty = null;
    public static final SerializerFeature WriteNullNumberAsZero = null;
    public static final SerializerFeature WriteNullStringAsEmpty = null;
    public static final SerializerFeature WriteSlashAsSpecial = null;
    public static final SerializerFeature WriteTabAsSpecial = null;
    public final int mask;

    static {
        SerializerFeature r100 = new SerializerFeature("QuoteFieldNames", 0);
        QuoteFieldNames = r100;
        SerializerFeature r101 = new SerializerFeature("UseSingleQuotes", 1);
        UseSingleQuotes = r101;
        SerializerFeature r102 = new SerializerFeature("WriteMapNullValue", 2);
        WriteMapNullValue = r102;
        SerializerFeature r103 = new SerializerFeature("WriteEnumUsingToString", 3);
        WriteEnumUsingToString = r103;
        SerializerFeature r104 = new SerializerFeature("WriteEnumUsingName", 4);
        WriteEnumUsingName = r104;
        SerializerFeature r105 = new SerializerFeature("UseISO8601DateFormat", 5);
        UseISO8601DateFormat = r105;
        SerializerFeature r110 = new SerializerFeature("WriteNullListAsEmpty", 6);
        WriteNullListAsEmpty = r110;
        SerializerFeature r111 = new SerializerFeature("WriteNullStringAsEmpty", 7);
        WriteNullStringAsEmpty = r111;
        SerializerFeature r112 = new SerializerFeature("WriteNullNumberAsZero", 8);
        WriteNullNumberAsZero = r112;
        SerializerFeature r113 = new SerializerFeature("WriteNullBooleanAsFalse", 9);
        WriteNullBooleanAsFalse = r113;
        SerializerFeature r114 = new SerializerFeature("SkipTransientField", 10);
        SkipTransientField = r114;
        SerializerFeature r115 = new SerializerFeature("SortField", 11);
        SortField = r115;
        SerializerFeature r106 = new SerializerFeature("WriteTabAsSpecial", 12);
        WriteTabAsSpecial = r106;
        SerializerFeature r107 = new SerializerFeature("PrettyFormat", 13);
        PrettyFormat = r107;
        SerializerFeature r108 = new SerializerFeature("WriteClassName", 14);
        WriteClassName = r108;
        SerializerFeature r109 = new SerializerFeature("DisableCircularReferenceDetect", 15);
        DisableCircularReferenceDetect = r109;
        SerializerFeature r116 = new SerializerFeature("WriteSlashAsSpecial", 16);
        WriteSlashAsSpecial = r116;
        SerializerFeature r117 = new SerializerFeature("BrowserCompatible", 17);
        BrowserCompatible = r117;
        SerializerFeature r118 = new SerializerFeature("WriteDateUseDateFormat", 18);
        WriteDateUseDateFormat = r118;
        SerializerFeature r119 = new SerializerFeature("NotWriteRootClassName", 19);
        NotWriteRootClassName = r119;
        SerializerFeature r120 = new SerializerFeature("DisableCheckSpecialChar", 20);
        DisableCheckSpecialChar = r120;
        SerializerFeature r121 = new SerializerFeature("BeanToArray", 21);
        BeanToArray = r121;
        SerializerFeature r122 = new SerializerFeature("WriteNonStringKeyAsString", 22);
        WriteNonStringKeyAsString = r122;
        SerializerFeature r123 = new SerializerFeature("NotWriteDefaultValue", 23);
        NotWriteDefaultValue = r123;
        SerializerFeature r124 = new SerializerFeature("BrowserSecure", 24);
        BrowserSecure = r124;
        SerializerFeature r125 = new SerializerFeature("IgnoreNonFieldGetter", 25);
        IgnoreNonFieldGetter = r125;
        SerializerFeature r126 = new SerializerFeature("WriteNonStringValueAsString", 26);
        WriteNonStringValueAsString = r126;
        SerializerFeature r127 = new SerializerFeature("IgnoreErrorGetter", 27);
        IgnoreErrorGetter = r127;
        SerializerFeature r128 = new SerializerFeature("WriteBigDecimalAsPlain", 28);
        WriteBigDecimalAsPlain = r128;
        SerializerFeature r129 = new SerializerFeature("MapSortField", 29);
        MapSortField = r129;
        $VALUES = new SerializerFeature[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129};
        EMPTY = new SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = (((r102.getMask() | r113.getMask()) | r110.getMask()) | r112.getMask()) | r111.getMask();
    }

    public static SerializerFeature[] values() {
        return (SerializerFeature[]) $VALUES.clone();
    }

    public final int getMask() {
        return this.mask;
    }

    public static int of(SerializerFeature[] r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r101 >= r102) goto L8;
        r103 = r103 | r100[r101].mask;
        r101 = r101 + 1;
        goto L6
    L8:
        return r103;
    }

    public static SerializerFeature valueOf(String r100) {
        return (SerializerFeature) a.a(SerializerFeature.class, r100);
    }

    private SerializerFeature(String r100, int r101) {
        super(r100, r101);
        this.mask = 1 << ordinal();
    }

    public static boolean isEnabled(int r100, SerializerFeature r101) {
        if ((r100 & r101.mask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int config(int r100, SerializerFeature r101, boolean r102) {
        if (r102 == false) goto L5;
        return r100 | r101.mask;
    L5:
        return r100 & (~r101.mask);
    }

    public static boolean isEnabled(int r100, int r101, SerializerFeature r102) {
        int r103 = r102.mask;
        if ((r100 & r103) == 0) goto L5;
    L8:
        return true;
    L5:
        if ((r101 & r103) != 0) goto L8;
        return false;
    }
}
