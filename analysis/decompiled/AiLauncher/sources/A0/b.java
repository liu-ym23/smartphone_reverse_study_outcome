package A0;

import A0.b;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f101a = new String[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Comparator<C0000b> f102b = new Comparator() { // from class: A0.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return b.a((b.C0000b) obj, (b.C0000b) obj2);
        }
    };

    public static class a {
        public static boolean a(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    /* renamed from: A0.b$b, reason: collision with other inner class name */
    public static class C0000b {

        /* renamed from: a, reason: collision with root package name */
        public int f103a;

        /* renamed from: b, reason: collision with root package name */
        public int f104b;
    }

    public static /* synthetic */ int a(C0000b c0000b, C0000b c0000b2) {
        int i10 = c0000b.f103a;
        int i11 = c0000b2.f103a;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return Integer.compare(c0000b2.f104b, c0000b.f104b);
    }

    public static boolean b(Spannable spannable, Pattern pattern, String str) {
        return f() ? Linkify.addLinks(spannable, pattern, str) : c(spannable, pattern, str, null, null, null);
    }

    public static boolean c(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (f()) {
            return a.a(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f101a;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i10 = 0;
        while (i10 < strArr.length) {
            String str2 = strArr[i10];
            i10++;
            strArr2[i10] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z10 = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            String strGroup = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) && strGroup != null) {
                d(e(strGroup, strArr2, matcher, transformFilter), iStart, iEnd, spannable);
                z10 = true;
            }
        }
        return z10;
    }

    public static void d(String str, int i10, int i11, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i10, i11, 33);
    }

    public static String e(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z10;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        String str2 = str;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            String str3 = strArr[i10];
            if (str2.regionMatches(true, 0, str3, 0, str3.length())) {
                z10 = true;
                if (!str2.regionMatches(false, 0, str3, 0, str3.length())) {
                    str2 = str3 + str2.substring(str3.length());
                }
            } else {
                i10++;
            }
        }
        if (z10 || strArr.length <= 0) {
            return str2;
        }
        return strArr[0] + str2;
    }

    public static boolean f() {
        return true;
    }
}
