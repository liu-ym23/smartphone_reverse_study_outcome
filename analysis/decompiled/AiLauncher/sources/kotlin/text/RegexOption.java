package kotlin.text;

import La.InterfaceC0955e;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u000b\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/text/RegexOption;", "LLa/e;", "", "", UxipConstants.f30680s, "mask", "<init>", "(Ljava/lang/String;III)V", "I", "getValue", "()I", "getMask", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegexOption implements InterfaceC0955e {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ RegexOption[] $VALUES;
    private final int mask;
    private final int value;
    public static final RegexOption IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
    public static final RegexOption MULTILINE = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
    public static final RegexOption LITERAL = new RegexOption("LITERAL", 2, 16, 0, 2, null);
    public static final RegexOption UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
    public static final RegexOption COMMENTS = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
    public static final RegexOption DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    public static final RegexOption CANON_EQ = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        RegexOption[] regexOptionArr$values = $values();
        $VALUES = regexOptionArr$values;
        $ENTRIES = a.a(regexOptionArr$values);
    }

    private RegexOption(String str, int i10, int i11, int i12) {
        this.value = i11;
        this.mask = i12;
    }

    public static InterfaceC4149a<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    public int getMask() {
        return this.mask;
    }

    @Override // La.InterfaceC0955e
    public int getValue() {
        return this.value;
    }

    public /* synthetic */ RegexOption(String str, int i10, int i11, int i12, int i13, i iVar) {
        this(str, i10, i11, (i13 & 2) != 0 ? i11 : i12);
    }
}
