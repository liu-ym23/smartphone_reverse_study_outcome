package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public final enum Feature extends Enum<Feature> {
    private static final /* synthetic */ Feature[] $VALUES = null;
    public static final Feature AllowArbitraryCommas = null;
    public static final Feature AllowComment = null;
    public static final Feature AllowISO8601DateFormat = null;
    public static final Feature AllowSingleQuotes = null;
    public static final Feature AllowUnQuotedFieldNames = null;
    public static final Feature AutoCloseSource = null;
    public static final Feature DisableASM = null;
    public static final Feature DisableCircularReferenceDetect = null;
    public static final Feature DisableSpecialKeyDetect = null;
    public static final Feature IgnoreNotMatch = null;
    public static final Feature InitStringFieldAsEmpty = null;
    public static final Feature InternFieldNames = null;
    public static final Feature OrderedField = null;
    public static final Feature SortFeidFastMatch = null;
    public static final Feature SupportArrayToBean = null;
    public static final Feature SupportNonPublicField = null;
    public static final Feature UseBigDecimal = null;
    public final int mask;

    static {
        Feature r10 = new Feature("AutoCloseSource", 0);
        AutoCloseSource = r10;
        Feature r11 = new Feature("AllowComment", 1);
        AllowComment = r11;
        Feature r12 = new Feature("AllowUnQuotedFieldNames", 2);
        AllowUnQuotedFieldNames = r12;
        Feature r13 = new Feature("AllowSingleQuotes", 3);
        AllowSingleQuotes = r13;
        Feature r14 = new Feature("InternFieldNames", 4);
        InternFieldNames = r14;
        Feature r15 = new Feature("AllowISO8601DateFormat", 5);
        AllowISO8601DateFormat = r15;
        Feature r16 = new Feature("AllowArbitraryCommas", 6);
        AllowArbitraryCommas = r16;
        Feature r17 = new Feature("UseBigDecimal", 7);
        UseBigDecimal = r17;
        Feature r18 = new Feature("IgnoreNotMatch", 8);
        IgnoreNotMatch = r18;
        Feature r19 = new Feature("SortFeidFastMatch", 9);
        SortFeidFastMatch = r19;
        Feature r110 = new Feature("DisableASM", 10);
        DisableASM = r110;
        Feature r111 = new Feature("DisableCircularReferenceDetect", 11);
        DisableCircularReferenceDetect = r111;
        Feature r112 = new Feature("InitStringFieldAsEmpty", 12);
        InitStringFieldAsEmpty = r112;
        Feature r113 = new Feature("SupportArrayToBean", 13);
        SupportArrayToBean = r113;
        Feature r20 = new Feature("OrderedField", 14);
        OrderedField = r20;
        Feature r21 = new Feature("DisableSpecialKeyDetect", 15);
        DisableSpecialKeyDetect = r21;
        Feature r22 = new Feature("SupportNonPublicField", 16);
        SupportNonPublicField = r22;
        $VALUES = new Feature[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22};
    }

    private Feature(String r10, int r11) {
        super(r10, r11);
        this.mask = 1 << ordinal();
    }

    public static Feature valueOf(String r10) {
        return (Feature) Enum.valueOf(Feature.class, r10);
    }

    public static Feature[] values() {
        return (Feature[]) $VALUES.clone();
    }
}
