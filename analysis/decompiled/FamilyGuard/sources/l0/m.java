package l0;

/* loaded from: classes.dex */
public enum m {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase,
    NoChange,
    NeverUseThisValueExceptDefaultValue;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18146a;

        static {
            int[] iArr = new int[m.values().length];
            f18146a = iArr;
            try {
                iArr[m.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18146a[m.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18146a[m.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18146a[m.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18146a[m.NoChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18146a[m.NeverUseThisValueExceptDefaultValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String b(String str) {
        char cCharAt;
        int i5 = a.f18146a[ordinal()];
        int i6 = 0;
        if (i5 == 1) {
            StringBuilder sb = new StringBuilder();
            while (i6 < str.length()) {
                char cCharAt2 = str.charAt(i6);
                if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                    sb.append(cCharAt2);
                } else {
                    char c6 = (char) (cCharAt2 + ' ');
                    if (i6 > 0) {
                        sb.append('_');
                    }
                    sb.append(c6);
                }
                i6++;
            }
            return sb.toString();
        }
        if (i5 == 2) {
            StringBuilder sb2 = new StringBuilder();
            while (i6 < str.length()) {
                char cCharAt3 = str.charAt(i6);
                if (cCharAt3 < 'A' || cCharAt3 > 'Z') {
                    sb2.append(cCharAt3);
                } else {
                    char c7 = (char) (cCharAt3 + ' ');
                    if (i6 > 0) {
                        sb2.append('-');
                    }
                    sb2.append(c7);
                }
                i6++;
            }
            return sb2.toString();
        }
        if (i5 != 3) {
            if (i5 != 4 || (cCharAt = str.charAt(0)) < 'A' || cCharAt > 'Z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] + ' ');
            return new String(charArray);
        }
        char cCharAt4 = str.charAt(0);
        if (cCharAt4 < 'a' || cCharAt4 > 'z') {
            return str;
        }
        char[] charArray2 = str.toCharArray();
        charArray2[0] = (char) (charArray2[0] - ' ');
        return new String(charArray2);
    }
}
