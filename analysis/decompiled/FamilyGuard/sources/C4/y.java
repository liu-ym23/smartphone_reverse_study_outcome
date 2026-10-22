package C4;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f975e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f976f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    private final String f977a;

    /* renamed from: b, reason: collision with root package name */
    private final String f978b;

    /* renamed from: c, reason: collision with root package name */
    private final String f979c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f980d;

    private y(String str, String str2, String str3, @Nullable String str4) {
        this.f977a = str;
        this.f978b = str2;
        this.f979c = str3;
        this.f980d = str4;
    }

    public static y b(String str) {
        Matcher matcher = f975e.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f976f.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup3;
            }
        }
        return new y(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    public static y c(String str) {
        try {
            return b(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public Charset a(@Nullable Charset charset) {
        try {
            String str = this.f980d;
            if (str != null) {
                return Charset.forName(str);
            }
        } catch (IllegalArgumentException unused) {
        }
        return charset;
    }

    public String d() {
        return this.f978b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof y) && ((y) obj).f977a.equals(this.f977a);
    }

    public int hashCode() {
        return this.f977a.hashCode();
    }

    public String toString() {
        return this.f977a;
    }
}
