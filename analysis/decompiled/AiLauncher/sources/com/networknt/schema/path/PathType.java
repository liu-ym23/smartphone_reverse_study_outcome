package com.networknt.schema.path;

import com.fasterxml.jackson.core.JsonPointer;
import com.networknt.schema.path.PathType;
import java.util.function.BiConsumer;
import java.util.function.IntPredicate;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.networknt.schema.path.PathType, still in use, count: 1, list:
  (r0v0 com.networknt.schema.path.PathType) from 0x005e: SPUT (r0v0 com.networknt.schema.path.PathType) com.networknt.schema.path.PathType.DEFAULT com.networknt.schema.path.PathType
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class PathType {
    LEGACY("$", new BiConsumer() { // from class: com.networknt.schema.path.a
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.k((StringBuilder) obj, (String) obj2);
        }
    }, new BiConsumer() { // from class: com.networknt.schema.path.b
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.b((StringBuilder) obj, (Integer) obj2);
        }
    }),
    JSON_PATH("$", new BiConsumer() { // from class: com.networknt.schema.path.c
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.l((StringBuilder) obj, (String) obj2);
        }
    }, new BiConsumer() { // from class: com.networknt.schema.path.d
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.j((StringBuilder) obj, (Integer) obj2);
        }
    }),
    JSON_POINTER("", new BiConsumer() { // from class: com.networknt.schema.path.e
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.c((StringBuilder) obj, (String) obj2);
        }
    }, new BiConsumer() { // from class: com.networknt.schema.path.f
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.i((StringBuilder) obj, (Integer) obj2);
        }
    }),
    URI_REFERENCE("", new BiConsumer() { // from class: com.networknt.schema.path.g
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.a((StringBuilder) obj, (String) obj2);
        }
    }, new BiConsumer() { // from class: com.networknt.schema.path.h
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.e((StringBuilder) obj, (Integer) obj2);
        }
    });

    public static final PathType DEFAULT = new PathType("$", new BiConsumer() { // from class: com.networknt.schema.path.a
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.k((StringBuilder) obj, (String) obj2);
        }
    }, new BiConsumer() { // from class: com.networknt.schema.path.b
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            PathType.b((StringBuilder) obj, (Integer) obj2);
        }
    });
    private final BiConsumer<StringBuilder, Integer> appendIndexFn;
    private final BiConsumer<StringBuilder, String> appendTokenFn;
    private final String rootToken;

    public static class JSONPath {
        public static final IntPredicate ALPHA;
        public static final IntPredicate DIGIT;
        public static final IntPredicate NAME_CHAR;
        public static final IntPredicate NAME_FIRST;
        public static final IntPredicate NON_ASCII;
        public static final IntPredicate UNDERSCORE;

        static {
            IntPredicate intPredicate = new IntPredicate() { // from class: com.networknt.schema.path.i
                @Override // java.util.function.IntPredicate
                public final boolean test(int i10) {
                    return PathType.JSONPath.c(i10);
                }
            };
            ALPHA = intPredicate;
            IntPredicate intPredicate2 = new IntPredicate() { // from class: com.networknt.schema.path.j
                @Override // java.util.function.IntPredicate
                public final boolean test(int i10) {
                    return PathType.JSONPath.b(i10);
                }
            };
            DIGIT = intPredicate2;
            IntPredicate intPredicate3 = new IntPredicate() { // from class: com.networknt.schema.path.k
                @Override // java.util.function.IntPredicate
                public final boolean test(int i10) {
                    return PathType.JSONPath.d(i10);
                }
            };
            NON_ASCII = intPredicate3;
            IntPredicate intPredicate4 = new IntPredicate() { // from class: com.networknt.schema.path.l
                @Override // java.util.function.IntPredicate
                public final boolean test(int i10) {
                    return PathType.JSONPath.a(i10);
                }
            };
            UNDERSCORE = intPredicate4;
            IntPredicate intPredicateOr = intPredicate.or(intPredicate4).or(intPredicate3);
            NAME_FIRST = intPredicateOr;
            NAME_CHAR = intPredicateOr.or(intPredicate2);
        }

        public static /* synthetic */ boolean a(int i10) {
            return 95 == i10;
        }

        public static /* synthetic */ boolean b(int i10) {
            return i10 >= 48 && i10 <= 57;
        }

        public static /* synthetic */ boolean c(int i10) {
            if (i10 < 97 || i10 > 122) {
                return i10 >= 65 && i10 <= 90;
            }
            return true;
        }

        public static /* synthetic */ boolean d(int i10) {
            return i10 >= 128 && i10 <= 1114111;
        }

        public static boolean isShorthand(String str) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("A JSONPath selector cannot be empty");
            }
            return NAME_FIRST.test(str.codePointAt(0)) && str.codePoints().skip(1L).allMatch(NAME_CHAR);
        }
    }

    static {
    }

    private PathType(String str, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.rootToken = str;
        this.appendTokenFn = biConsumer;
        this.appendIndexFn = biConsumer2;
    }

    public static /* synthetic */ void a(StringBuilder sb2, String str) {
        if (sb2.length() == 0) {
            sb2.append(str);
        } else {
            sb2.append("/");
            sb2.append(str);
        }
    }

    public static /* synthetic */ void b(StringBuilder sb2, Integer num) {
        sb2.append("[");
        sb2.append(num);
        sb2.append("]");
    }

    public static /* synthetic */ void c(StringBuilder sb2, String str) {
        if (str.indexOf(126) != -1) {
            str = str.replace("~", JsonPointer.ESC_TILDE);
        }
        if (str.indexOf(47) != -1) {
            str = str.replace("/", JsonPointer.ESC_SLASH);
        }
        String strReplaceCommonSpecialCharactersIfPresent = replaceCommonSpecialCharactersIfPresent(str);
        sb2.append("/");
        sb2.append(strReplaceCommonSpecialCharactersIfPresent);
    }

    public static /* synthetic */ void e(StringBuilder sb2, Integer num) {
        sb2.append("/");
        sb2.append(num);
    }

    public static String fromJsonPath(String str) {
        if (str != null && !str.isEmpty()) {
            int selector = 0;
            if ('$' == str.charAt(0)) {
                String strSubstring = str.substring(1);
                if (strSubstring.isEmpty()) {
                    return "";
                }
                int length = strSubstring.length();
                StringBuilder sb2 = new StringBuilder(length);
                while (selector < length) {
                    char cCharAt = strSubstring.charAt(selector);
                    if (cCharAt == '.') {
                        sb2.append(JsonPointer.SEPARATOR);
                        selector = parseShorthand(sb2, strSubstring, selector + 1);
                    } else {
                        if (cCharAt != '[') {
                            throw new IllegalArgumentException("JSONPath must reference a property or array index");
                        }
                        sb2.append(JsonPointer.SEPARATOR);
                        selector = parseSelector(sb2, strSubstring, selector + 1);
                    }
                }
                return sb2.toString();
            }
        }
        throw new IllegalArgumentException("JSON Path must start with '$'");
    }

    public static String fromLegacy(String str) {
        return str.replace("\"", "").replace("]", "").replace('[', JsonPointer.SEPARATOR).replace('.', JsonPointer.SEPARATOR).replace("$", "");
    }

    public static /* synthetic */ void i(StringBuilder sb2, Integer num) {
        sb2.append("/");
        sb2.append(num);
    }

    public static /* synthetic */ void j(StringBuilder sb2, Integer num) {
        sb2.append("[");
        sb2.append(num);
        sb2.append("]");
    }

    public static /* synthetic */ void k(StringBuilder sb2, String str) {
        sb2.append(".");
        sb2.append(replaceCommonSpecialCharactersIfPresent(str));
    }

    public static /* synthetic */ void l(StringBuilder sb2, String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("A JSONPath selector cannot be empty");
        }
        if (JSONPath.isShorthand(str)) {
            sb2.append(".");
            sb2.append(str);
            return;
        }
        if (str.indexOf(39) != -1) {
            str = str.replace("'", "\\'");
        }
        String strReplaceCommonSpecialCharactersIfPresent = replaceCommonSpecialCharactersIfPresent(str);
        sb2.append("['");
        sb2.append(strReplaceCommonSpecialCharactersIfPresent);
        sb2.append("']");
    }

    public static int parseQuote(StringBuilder sb2, String str, int i10) {
        int iIndexOf = i10;
        do {
            iIndexOf = str.indexOf(39, iIndexOf);
            if (-1 == iIndexOf) {
                throw new IllegalArgumentException("JSONPath contains an unterminated quoted string");
            }
        } while ('\\' == str.charAt(iIndexOf - 1));
        sb2.append((CharSequence) str, i10, iIndexOf);
        return iIndexOf + 1;
    }

    public static int parseSelector(StringBuilder sb2, String str, int i10) {
        int iIndexOf = str.indexOf(93, i10);
        if (-1 == iIndexOf) {
            throw new IllegalArgumentException("JSONPath contains an unterminated selector");
        }
        if ('\'' == str.charAt(i10)) {
            parseQuote(sb2, str, i10 + 1);
        } else {
            sb2.append((CharSequence) str, i10, iIndexOf);
        }
        return iIndexOf + 1;
    }

    public static int parseShorthand(StringBuilder sb2, String str, int i10) {
        int length = str.length();
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '.' && cCharAt != '[') {
                sb2.append(cCharAt);
            }
            i10++;
        }
        return i10;
    }

    private static String replaceCommonSpecialCharactersIfPresent(String str) {
        if (str.indexOf(10) != -1) {
            str = str.replace("\n", "\\n");
        }
        if (str.indexOf(9) != -1) {
            str = str.replace("\t", "\\t");
        }
        if (str.indexOf(13) != -1) {
            str = str.replace("\r", "\\r");
        }
        if (str.indexOf(8) != -1) {
            str = str.replace("\b", "\\b");
        }
        return str.indexOf(12) != -1 ? str.replace("\f", "\\f") : str;
    }

    public static PathType valueOf(String str) {
        return (PathType) Enum.valueOf(PathType.class, str);
    }

    public static PathType[] values() {
        return (PathType[]) $VALUES.clone();
    }

    public void append(StringBuilder sb2, String str) {
        this.appendTokenFn.accept(sb2, str);
    }

    public String convertToJsonPointer(String str) {
        int iOrdinal = ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 ? fromLegacy(str) : str : fromJsonPath(str);
    }

    public String getRoot() {
        return this.rootToken;
    }

    public void append(StringBuilder sb2, int i10) {
        this.appendIndexFn.accept(sb2, Integer.valueOf(i10));
    }
}
