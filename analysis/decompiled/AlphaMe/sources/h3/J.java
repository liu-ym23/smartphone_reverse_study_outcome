package h3;

import ch.qos.logback.core.CoreConstants;
import com.alibaba.fastjson.asm.Opcodes;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import net.sourceforge.jeval.EvaluationConstants;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class J {

    /* renamed from: k, reason: collision with root package name */
    public static final char[] f12721k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f12722a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12723b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12724c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12725d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12726e;

    /* renamed from: f, reason: collision with root package name */
    public final List f12727f;

    /* renamed from: g, reason: collision with root package name */
    public final List f12728g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12729h;

    /* renamed from: i, reason: collision with root package name */
    public final String f12730i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f12731j;

    public J(String scheme, String username, String password, String host, int i4, ArrayList pathSegments, ArrayList arrayList, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f12722a = scheme;
        this.f12723b = username;
        this.f12724c = password;
        this.f12725d = host;
        this.f12726e = i4;
        this.f12727f = pathSegments;
        this.f12728g = arrayList;
        this.f12729h = str;
        this.f12730i = url;
        this.f12731j = Intrinsics.areEqual(scheme, "https");
    }

    public final String a() {
        if (this.f12724c.length() == 0) {
            return "";
        }
        int length = this.f12722a.length() + 3;
        String str = this.f12730i;
        String strSubstring = str.substring(StringsKt__StringsKt.indexOf$default(str, CoreConstants.COLON_CHAR, length, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f12722a.length() + 3;
        String str = this.f12730i;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4, (Object) null);
        String strSubstring = str.substring(iIndexOf$default, Util.delimiterOffset(str, "?#", iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f12722a.length() + 3;
        String str = this.f12730i;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4, (Object) null);
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iDelimiterOffset) {
            int i4 = iIndexOf$default + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(str, '/', i4, iDelimiterOffset);
            String strSubstring = str.substring(i4, iDelimiterOffset2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f12728g == null) {
            return null;
        }
        String str = this.f12730i;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '?', 0, false, 6, (Object) null) + 1;
        String strSubstring = str.substring(iIndexOf$default, Util.delimiterOffset(str, EvaluationConstants.POUND_SIGN, iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.f12723b.length() == 0) {
            return "";
        }
        int length = this.f12722a.length() + 3;
        String str = this.f12730i;
        String strSubstring = str.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof J) && Intrinsics.areEqual(((J) obj).f12730i, this.f12730i);
    }

    public final I f() {
        String strSubstring;
        I i4 = new I();
        String str = this.f12722a;
        i4.f12713a = str;
        String strE = e();
        Intrinsics.checkNotNullParameter(strE, "<set-?>");
        i4.f12714b = strE;
        String strA = a();
        Intrinsics.checkNotNullParameter(strA, "<set-?>");
        i4.f12715c = strA;
        i4.f12716d = this.f12725d;
        int iJ = C0611u.j(str);
        int i5 = this.f12726e;
        if (i5 == iJ) {
            i5 = -1;
        }
        i4.f12717e = i5;
        ArrayList arrayList = i4.f12718f;
        arrayList.clear();
        arrayList.addAll(c());
        i4.d(d());
        if (this.f12729h == null) {
            strSubstring = null;
        } else {
            String str2 = this.f12730i;
            strSubstring = str2.substring(StringsKt__StringsKt.indexOf$default(str2, EvaluationConstants.POUND_SIGN, 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        i4.f12720h = strSubstring;
        return i4;
    }

    public final I g(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            I i4 = new I();
            i4.e(this, link);
            return i4;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String h() {
        I iG = g("/...");
        Intrinsics.checkNotNull(iG);
        iG.getClass();
        Intrinsics.checkNotNullParameter("", "username");
        String strC = C0611u.c("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        Intrinsics.checkNotNullParameter(strC, "<set-?>");
        iG.f12714b = strC;
        Intrinsics.checkNotNullParameter("", "password");
        String strC2 = C0611u.c("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        Intrinsics.checkNotNullParameter(strC2, "<set-?>");
        iG.f12715c = strC2;
        return iG.c().f12730i;
    }

    public final int hashCode() {
        return this.f12730i.hashCode();
    }

    public final URI i() {
        I iF = f();
        String str = iF.f12716d;
        iF.f12716d = str == null ? null : new Regex("[\"<>^`{|}]").replace(str, "");
        ArrayList arrayList = iF.f12718f;
        int size = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.set(i5, C0611u.c((String) arrayList.get(i5), 0, 0, "[]", true, true, false, false, null, 227));
        }
        List list = iF.f12719g;
        if (list != null) {
            int size2 = list.size();
            while (i4 < size2) {
                int i6 = i4 + 1;
                String str2 = (String) list.get(i4);
                list.set(i4, str2 == null ? null : C0611u.c(str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195));
                i4 = i6;
            }
        }
        String str3 = iF.f12720h;
        iF.f12720h = str3 != null ? C0611u.c(str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, Opcodes.IF_ICMPGT) : null;
        String string = iF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e4) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.checkNotNullExpressionValue(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e4);
            }
        }
    }

    public final String toString() {
        return this.f12730i;
    }
}
