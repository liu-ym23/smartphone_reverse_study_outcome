package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/text/RegexOption;", "", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RegexOption {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RegexOption[] f5170a;

    static {
        RegexOption[] regexOptionArr = {new RegexOption("IGNORE_CASE", 0), new RegexOption("MULTILINE", 1), new RegexOption("LITERAL", 2), new RegexOption("UNIX_LINES", 3), new RegexOption("COMMENTS", 4), new RegexOption("DOT_MATCHES_ALL", 5), new RegexOption("CANON_EQ", 6)};
        f5170a = regexOptionArr;
        a.a(regexOptionArr);
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) f5170a.clone();
    }
}
