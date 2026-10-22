package q0;

/* loaded from: classes.dex */
public enum f0 {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;


    /* renamed from: F, reason: collision with root package name */
    public static final f0[] f19821F;

    /* renamed from: G, reason: collision with root package name */
    public static final int f19822G;

    /* renamed from: a, reason: collision with root package name */
    public final int f19849a = 1 << ordinal();

    static {
        f0 f0Var = WriteMapNullValue;
        f0 f0Var2 = WriteNullListAsEmpty;
        f0 f0Var3 = WriteNullStringAsEmpty;
        f0 f0Var4 = WriteNullNumberAsZero;
        f0 f0Var5 = WriteNullBooleanAsFalse;
        f19821F = new f0[0];
        f19822G = f0Var.b() | f0Var5.b() | f0Var2.b() | f0Var4.b() | f0Var3.b();
    }

    f0() {
    }

    public static boolean d(int i5, int i6, f0 f0Var) {
        int i7 = f0Var.f19849a;
        return ((i5 & i7) == 0 && (i6 & i7) == 0) ? false : true;
    }

    public static boolean e(int i5, f0 f0Var) {
        return (i5 & f0Var.f19849a) != 0;
    }

    public static int g(f0[] f0VarArr) {
        if (f0VarArr == null) {
            return 0;
        }
        int i5 = 0;
        for (f0 f0Var : f0VarArr) {
            i5 |= f0Var.f19849a;
        }
        return i5;
    }

    public final int b() {
        return this.f19849a;
    }
}
