package kotlin.text;

import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lkotlin/text/CharCategory;", "", "", CommonKey.KEY_VALUE, "", ServerElements.CODE, "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "", "char", "", "contains", "(C)Z", "I", "getValue", "()I", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "Companion", "a", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CharCategory extends Enum<CharCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CharCategory[] $VALUES = null;
    public static final CharCategory COMBINING_SPACING_MARK = null;
    public static final CharCategory CONNECTOR_PUNCTUATION = null;
    public static final CharCategory CONTROL = null;
    public static final CharCategory CURRENCY_SYMBOL = null;

    @NotNull
    public static final a Companion = null;
    public static final CharCategory DASH_PUNCTUATION = null;
    public static final CharCategory DECIMAL_DIGIT_NUMBER = null;
    public static final CharCategory ENCLOSING_MARK = null;
    public static final CharCategory END_PUNCTUATION = null;
    public static final CharCategory FINAL_QUOTE_PUNCTUATION = null;
    public static final CharCategory FORMAT = null;
    public static final CharCategory INITIAL_QUOTE_PUNCTUATION = null;
    public static final CharCategory LETTER_NUMBER = null;
    public static final CharCategory LINE_SEPARATOR = null;
    public static final CharCategory LOWERCASE_LETTER = null;
    public static final CharCategory MATH_SYMBOL = null;
    public static final CharCategory MODIFIER_LETTER = null;
    public static final CharCategory MODIFIER_SYMBOL = null;
    public static final CharCategory NON_SPACING_MARK = null;
    public static final CharCategory OTHER_LETTER = null;
    public static final CharCategory OTHER_NUMBER = null;
    public static final CharCategory OTHER_PUNCTUATION = null;
    public static final CharCategory OTHER_SYMBOL = null;
    public static final CharCategory PARAGRAPH_SEPARATOR = null;
    public static final CharCategory PRIVATE_USE = null;
    public static final CharCategory SPACE_SEPARATOR = null;
    public static final CharCategory START_PUNCTUATION = null;
    public static final CharCategory SURROGATE = null;
    public static final CharCategory TITLECASE_LETTER = null;
    public static final CharCategory UNASSIGNED = null;
    public static final CharCategory UPPERCASE_LETTER = null;

    @NotNull
    private final String code;
    private final int value;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    private static final /* synthetic */ CharCategory[] $values() {
        return new CharCategory[]{UNASSIGNED, UPPERCASE_LETTER, LOWERCASE_LETTER, TITLECASE_LETTER, MODIFIER_LETTER, OTHER_LETTER, NON_SPACING_MARK, ENCLOSING_MARK, COMBINING_SPACING_MARK, DECIMAL_DIGIT_NUMBER, LETTER_NUMBER, OTHER_NUMBER, SPACE_SEPARATOR, LINE_SEPARATOR, PARAGRAPH_SEPARATOR, CONTROL, FORMAT, PRIVATE_USE, SURROGATE, DASH_PUNCTUATION, START_PUNCTUATION, END_PUNCTUATION, CONNECTOR_PUNCTUATION, OTHER_PUNCTUATION, MATH_SYMBOL, CURRENCY_SYMBOL, MODIFIER_SYMBOL, OTHER_SYMBOL, INITIAL_QUOTE_PUNCTUATION, FINAL_QUOTE_PUNCTUATION};
    }

    static {
        UNASSIGNED = new CharCategory("UNASSIGNED", 0, 0, "Cn");
        UPPERCASE_LETTER = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
        LOWERCASE_LETTER = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
        TITLECASE_LETTER = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
        MODIFIER_LETTER = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
        OTHER_LETTER = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
        NON_SPACING_MARK = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
        ENCLOSING_MARK = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
        COMBINING_SPACING_MARK = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
        DECIMAL_DIGIT_NUMBER = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
        LETTER_NUMBER = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
        OTHER_NUMBER = new CharCategory("OTHER_NUMBER", 11, 11, "No");
        SPACE_SEPARATOR = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
        LINE_SEPARATOR = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
        PARAGRAPH_SEPARATOR = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
        CONTROL = new CharCategory("CONTROL", 15, 15, "Cc");
        FORMAT = new CharCategory("FORMAT", 16, 16, "Cf");
        PRIVATE_USE = new CharCategory("PRIVATE_USE", 17, 18, "Co");
        SURROGATE = new CharCategory("SURROGATE", 18, 19, "Cs");
        DASH_PUNCTUATION = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
        START_PUNCTUATION = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
        END_PUNCTUATION = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
        CONNECTOR_PUNCTUATION = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
        OTHER_PUNCTUATION = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
        MATH_SYMBOL = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
        CURRENCY_SYMBOL = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
        MODIFIER_SYMBOL = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
        OTHER_SYMBOL = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
        INITIAL_QUOTE_PUNCTUATION = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
        FINAL_QUOTE_PUNCTUATION = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
        CharCategory[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
        Companion = new a(null);
    }

    private CharCategory(String r10, int r11, int r12, String r13) {
        super(r10, r11);
        this.value = r12;
        this.code = r13;
    }

    @NotNull
    public static EnumEntries<CharCategory> getEntries() {
        return $ENTRIES;
    }

    public static CharCategory valueOf(String r10) {
        return (CharCategory) Enum.valueOf(CharCategory.class, r10);
    }

    public static CharCategory[] values() {
        return (CharCategory[]) $VALUES.clone();
    }

    public final boolean contains(char r10) {
        if (Character.getType(r10) != this.value) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
