package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch;

    public final int mask = 1 << ordinal();

    Feature() {
    }

    public static int config(int i4, Feature feature, boolean z4) {
        return z4 ? i4 | feature.mask : i4 & (~feature.mask);
    }

    public static boolean isEnabled(int i4, Feature feature) {
        return (i4 & feature.mask) != 0;
    }

    public static int of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i4 = 0;
        for (Feature feature : featureArr) {
            i4 |= feature.mask;
        }
        return i4;
    }

    public final int getMask() {
        return this.mask;
    }
}
