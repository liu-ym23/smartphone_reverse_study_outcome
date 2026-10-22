package com.alibaba.fastjson.parser;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum Feature extends Enum<Feature> {
    private static final /* synthetic */ Feature[] $VALUES = null;
    public static final Feature AllowArbitraryCommas = null;
    public static final Feature AllowComment = null;
    public static final Feature AllowISO8601DateFormat = null;
    public static final Feature AllowSingleQuotes = null;
    public static final Feature AllowUnQuotedFieldNames = null;
    public static final Feature AutoCloseSource = null;
    public static final Feature CustomMapDeserializer = null;
    public static final Feature DisableASM = null;
    public static final Feature DisableCircularReferenceDetect = null;
    public static final Feature DisableFieldSmartMatch = null;
    public static final Feature DisableSpecialKeyDetect = null;
    public static final Feature ErrorOnEnumNotMatch = null;
    public static final Feature IgnoreAutoType = null;
    public static final Feature IgnoreNotMatch = null;
    public static final Feature InitStringFieldAsEmpty = null;
    public static final Feature InternFieldNames = null;
    public static final Feature NonStringKeyAsString = null;
    public static final Feature OrderedField = null;
    public static final Feature SafeMode = null;
    public static final Feature SortFeidFastMatch = null;
    public static final Feature SupportArrayToBean = null;
    public static final Feature SupportAutoType = null;
    public static final Feature SupportNonPublicField = null;
    public static final Feature TrimStringFieldValue = null;
    public static final Feature UseBigDecimal = null;
    public static final Feature UseNativeJavaObject = null;
    public static final Feature UseObjectArray = null;
    public final int mask;

    static {
        Feature r100 = new Feature("AutoCloseSource", 0);
        AutoCloseSource = r100;
        Feature r101 = new Feature("AllowComment", 1);
        AllowComment = r101;
        Feature r102 = new Feature("AllowUnQuotedFieldNames", 2);
        AllowUnQuotedFieldNames = r102;
        Feature r103 = new Feature("AllowSingleQuotes", 3);
        AllowSingleQuotes = r103;
        Feature r104 = new Feature("InternFieldNames", 4);
        InternFieldNames = r104;
        Feature r105 = new Feature("AllowISO8601DateFormat", 5);
        AllowISO8601DateFormat = r105;
        Feature r110 = new Feature("AllowArbitraryCommas", 6);
        AllowArbitraryCommas = r110;
        Feature r111 = new Feature("UseBigDecimal", 7);
        UseBigDecimal = r111;
        Feature r112 = new Feature("IgnoreNotMatch", 8);
        IgnoreNotMatch = r112;
        Feature r113 = new Feature("SortFeidFastMatch", 9);
        SortFeidFastMatch = r113;
        Feature r114 = new Feature("DisableASM", 10);
        DisableASM = r114;
        Feature r115 = new Feature("DisableCircularReferenceDetect", 11);
        DisableCircularReferenceDetect = r115;
        Feature r106 = new Feature("InitStringFieldAsEmpty", 12);
        InitStringFieldAsEmpty = r106;
        Feature r107 = new Feature("SupportArrayToBean", 13);
        SupportArrayToBean = r107;
        Feature r108 = new Feature("OrderedField", 14);
        OrderedField = r108;
        Feature r109 = new Feature("DisableSpecialKeyDetect", 15);
        DisableSpecialKeyDetect = r109;
        Feature r116 = new Feature("UseObjectArray", 16);
        UseObjectArray = r116;
        Feature r117 = new Feature("SupportNonPublicField", 17);
        SupportNonPublicField = r117;
        Feature r118 = new Feature("IgnoreAutoType", 18);
        IgnoreAutoType = r118;
        Feature r119 = new Feature("DisableFieldSmartMatch", 19);
        DisableFieldSmartMatch = r119;
        Feature r120 = new Feature("SupportAutoType", 20);
        SupportAutoType = r120;
        Feature r121 = new Feature("NonStringKeyAsString", 21);
        NonStringKeyAsString = r121;
        Feature r122 = new Feature("CustomMapDeserializer", 22);
        CustomMapDeserializer = r122;
        Feature r123 = new Feature("ErrorOnEnumNotMatch", 23);
        ErrorOnEnumNotMatch = r123;
        Feature r124 = new Feature("SafeMode", 24);
        SafeMode = r124;
        Feature r125 = new Feature("TrimStringFieldValue", 25);
        TrimStringFieldValue = r125;
        Feature r126 = new Feature("UseNativeJavaObject", 26);
        UseNativeJavaObject = r126;
        $VALUES = new Feature[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
    }

    public static Feature[] values() {
        return (Feature[]) $VALUES.clone();
    }

    public final int getMask() {
        return this.mask;
    }

    public static int of(Feature[] r100) {
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

    public static Feature valueOf(String r100) {
        return (Feature) a.a(Feature.class, r100);
    }

    private Feature(String r100, int r101) {
        super(r100, r101);
        this.mask = 1 << ordinal();
    }

    public static boolean isEnabled(int r100, Feature r101) {
        if ((r100 & r101.mask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int config(int r100, Feature r101, boolean r102) {
        if (r102 == false) goto L5;
        return r100 | r101.mask;
    L5:
        return r100 & (~r101.mask);
    }
}
