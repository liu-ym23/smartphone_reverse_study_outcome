package kotlin.text;

import com.stepos.core.common.util.TraceIdKeys;
import gc.c;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RegexOption implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final RegexOption f10095b;

    /* renamed from: c, reason: collision with root package name */
    public static final RegexOption f10096c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ RegexOption[] f10097d;

    /* renamed from: a, reason: collision with root package name */
    public final int f10098a;

    static {
        RegexOption regexOption = new RegexOption("IGNORE_CASE", 0, 2);
        f10095b = regexOption;
        RegexOption regexOption2 = new RegexOption("MULTILINE", 1, 8);
        RegexOption regexOption3 = new RegexOption("LITERAL", 2, 16);
        RegexOption regexOption4 = new RegexOption("UNIX_LINES", 3, 1);
        RegexOption regexOption5 = new RegexOption("COMMENTS", 4, 4);
        RegexOption regexOption6 = new RegexOption("DOT_MATCHES_ALL", 5, 32);
        f10096c = regexOption6;
        RegexOption[] regexOptionArr = {regexOption, regexOption2, regexOption3, regexOption4, regexOption5, regexOption6, new RegexOption("CANON_EQ", 6, TraceIdKeys.MAX_LENGTH)};
        f10097d = regexOptionArr;
        a.a(regexOptionArr);
    }

    public RegexOption() {
        throw null;
    }

    public RegexOption(String str, int i10, int i11) {
        this.f10098a = i11;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) f10097d.clone();
    }

    @Override // gc.c
    public final int getValue() {
        return this.f10098a;
    }
}
