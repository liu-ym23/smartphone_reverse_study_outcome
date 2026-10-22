package Xb;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f6911a = Pattern.compile("[\\\\&]");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f6912b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f6913c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f6914d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f6915e = Pattern.compile("[ \t\r\n]+");

    /* renamed from: f, reason: collision with root package name */
    public static final c f6916f = new C0120a();

    /* renamed from: g, reason: collision with root package name */
    public static final c f6917g = new b();

    /* renamed from: Xb.a$a, reason: collision with other inner class name */
    public static class C0120a implements c {
        @Override // Xb.a.c
        public void a(String str, StringBuilder sb2) {
            if (str.charAt(0) == '\\') {
                sb2.append((CharSequence) str, 1, str.length());
            } else {
                sb2.append(Xb.b.a(str));
            }
        }
    }

    public static class b implements c {
        @Override // Xb.a.c
        public void a(String str, StringBuilder sb2) {
            if (str.startsWith("%")) {
                if (str.length() == 3) {
                    sb2.append(str);
                    return;
                } else {
                    sb2.append("%25");
                    sb2.append((CharSequence) str, 1, str.length());
                    return;
                }
            }
            for (byte b10 : str.getBytes(Charset.forName("UTF-8"))) {
                sb2.append('%');
                sb2.append(a.f6914d[(b10 >> 4) & 15]);
                sb2.append(a.f6914d[b10 & 15]);
            }
        }
    }

    public interface c {
        void a(String str, StringBuilder sb2);
    }

    public static String b(String str) {
        return f6915e.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }

    public static String c(String str) {
        return b(str.substring(1, str.length() - 1));
    }

    public static String d(Pattern pattern, String str, c cVar) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 16);
        int iEnd = 0;
        do {
            sb2.append((CharSequence) str, iEnd, matcher.start());
            cVar.a(matcher.group(), sb2);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd != str.length()) {
            sb2.append((CharSequence) str, iEnd, str.length());
        }
        return sb2.toString();
    }

    public static String e(String str) {
        return f6911a.matcher(str).find() ? d(f6912b, str, f6916f) : str;
    }
}
