package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringBuilderJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a%\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a-\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a-\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u0012H\u0007\u001a\u001d\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0087\b\u001a\u0014\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001f\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0087\b\u001a%\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u0014\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001d\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a5\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a5\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0087\b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\n\u001a-\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\b\u001a7\u0010\u001f\u001a\u00020\u001d*\u00060\u0001j\u0002`\u00022\u0006\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0087\b¨\u0006\""}, d2 = {"appendLine", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "appendRange", "", "startIndex", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public StringsKt__StringBuilderJVMKt() {
    }

    public static final StringBuilder clear(StringBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setLength(0);
        return r1;
    }

    private static final void set(StringBuilder r1, int r2, char r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setCharAt(r2, r3);
    }

    private static final StringBuilder setRange(StringBuilder r1, int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "value");
        StringBuilder r5 = r1.replace(r2, r3, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "replace(...)");
        return r5;
    }

    private static final StringBuilder deleteAt(StringBuilder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.deleteCharAt(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "deleteCharAt(...)");
        return r3;
    }

    private static final StringBuilder deleteRange(StringBuilder r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r4 = r1.delete(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "delete(...)");
        return r4;
    }

    static /* synthetic */ void toCharArray$default(StringBuilder r1, char[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = r1.length();
    L11:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        r1.getChars(r4, r5, r2, r3);
    }

    private static final void toCharArray(StringBuilder r1, char[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        r1.getChars(r4, r5, r2, r3);
    }

    private static final StringBuilder appendRange(StringBuilder r1, char[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        StringBuilder r5 = r1.append(r2, r3, r4 - r3);
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return r5;
    }

    private static final StringBuilder appendRange(StringBuilder r1, CharSequence r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        StringBuilder r5 = r1.append(r2, r3, r4);
        Intrinsics.checkNotNullExpressionValue(r5, "append(...)");
        return r5;
    }

    private static final StringBuilder insertRange(StringBuilder r1, int r2, char[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "value");
        StringBuilder r6 = r1.insert(r2, r3, r4, r5 - r4);
        Intrinsics.checkNotNullExpressionValue(r6, "insert(...)");
        return r6;
    }

    private static final StringBuilder insertRange(StringBuilder r1, int r2, CharSequence r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "value");
        StringBuilder r6 = r1.insert(r2, r3, r4, r5);
        Intrinsics.checkNotNullExpressionValue(r6, "insert(...)");
        return r6;
    }

    private static final StringBuilder appendLine(StringBuilder r1, StringBuffer r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, StringBuilder r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, short r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, byte r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    private static final StringBuilder appendLine(StringBuilder r1, double r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        StringBuilder r4 = r3.append('\n');
        Intrinsics.checkNotNullExpressionValue(r4, "append(...)");
        return r4;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Appendable r2 = r1.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
        return r2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Appendable r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable r1, char r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Appendable r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder appendln(StringBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r2 = r1.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(r2, "append(...)");
        return r2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, StringBuffer r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, StringBuilder r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, char[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, char r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, short r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, byte r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r1, double r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r3 = r1.append(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "append(...)");
        return StringsKt.appendln(r3);
    }
}
