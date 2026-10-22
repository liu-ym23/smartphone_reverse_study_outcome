package o0;

/* renamed from: o0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC0889b {
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
    DisableFieldSmartMatch,
    SupportAutoType,
    NonStringKeyAsString,
    CustomMapDeserializer,
    ErrorOnEnumNotMatch,
    SafeMode,
    TrimStringFieldValue,
    UseNativeJavaObject;


    /* renamed from: a, reason: collision with root package name */
    public final int f18991a = 1 << ordinal();

    EnumC0889b() {
    }

    public static boolean d(int i5, EnumC0889b enumC0889b) {
        return (i5 & enumC0889b.f18991a) != 0;
    }

    public static int e(EnumC0889b[] enumC0889bArr) {
        if (enumC0889bArr == null) {
            return 0;
        }
        int i5 = 0;
        for (EnumC0889b enumC0889b : enumC0889bArr) {
            i5 |= enumC0889b.f18991a;
        }
        return i5;
    }

    public final int b() {
        return this.f18991a;
    }
}
