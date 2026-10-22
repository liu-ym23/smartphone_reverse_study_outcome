package ab;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f587j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f588a;

    /* renamed from: b, reason: collision with root package name */
    public final String f589b;

    /* renamed from: c, reason: collision with root package name */
    public final String f590c;

    /* renamed from: d, reason: collision with root package name */
    public final String f591d;

    /* renamed from: e, reason: collision with root package name */
    public final int f592e;

    /* renamed from: f, reason: collision with root package name */
    public final List f593f;

    /* renamed from: g, reason: collision with root package name */
    public final String f594g;

    /* renamed from: h, reason: collision with root package name */
    public final String f595h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f596i;

    public p(String str, String str2, String str3, String str4, int i2, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        q7.k.e(str, "scheme");
        q7.k.e(str4, "host");
        this.f588a = str;
        this.f589b = str2;
        this.f590c = str3;
        this.f591d = str4;
        this.f592e = i2;
        this.f593f = arrayList2;
        this.f594g = str5;
        this.f595h = str6;
        this.f596i = str.equals("https");
    }

    public final String a() {
        if (this.f590c.length() == 0) {
            return "";
        }
        int length = this.f588a.length() + 3;
        String str = this.f595h;
        String strSubstring = str.substring(ga.k.q0(str, ':', length, 4) + 1, ga.k.q0(str, '@', 0, 6));
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f588a.length() + 3;
        String str = this.f595h;
        int iQ0 = ga.k.q0(str, '/', length, 4);
        String strSubstring = str.substring(iQ0, bb.b.g(str, iQ0, str.length(), "?#"));
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f588a.length() + 3;
        String str = this.f595h;
        int iQ0 = ga.k.q0(str, '/', length, 4);
        int iG = bb.b.g(str, iQ0, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iQ0 < iG) {
            int i2 = iQ0 + 1;
            int iF = bb.b.f(str, '/', i2, iG);
            String strSubstring = str.substring(i2, iF);
            q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iQ0 = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f593f == null) {
            return null;
        }
        String str = this.f595h;
        int iQ0 = ga.k.q0(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iQ0, bb.b.f(str, '#', iQ0, str.length()));
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.f589b.length() == 0) {
            return "";
        }
        int length = this.f588a.length() + 3;
        String str = this.f595h;
        String strSubstring = str.substring(length, bb.b.g(str, length, str.length(), ":@"));
        q7.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && q7.k.a(((p) obj).f595h, this.f595h);
    }

    public final String f() {
        o oVar;
        try {
            oVar = new o();
            oVar.c(this, "/...");
        } catch (IllegalArgumentException unused) {
            oVar = null;
        }
        q7.k.b(oVar);
        oVar.f580b = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        oVar.f581c = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        return oVar.a().f595h;
    }

    public final URI g() {
        String strSubstring;
        String strReplaceAll;
        o oVar = new o();
        String str = this.f588a;
        oVar.f579a = str;
        oVar.f580b = e();
        oVar.f581c = a();
        oVar.f582d = this.f591d;
        q7.k.e(str, "scheme");
        int i2 = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i10 = this.f592e;
        oVar.f583e = i10 != i2 ? i10 : -1;
        ArrayList arrayList = oVar.f584f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        oVar.f585g = strD != null ? b.f(b.b(strD, 0, 0, " \"'<>#", 211)) : null;
        if (this.f594g == null) {
            strSubstring = null;
        } else {
            String str2 = this.f595h;
            strSubstring = str2.substring(ga.k.q0(str2, '#', 0, 6) + 1);
            q7.k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        oVar.f586h = strSubstring;
        String str3 = oVar.f582d;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            q7.k.d(patternCompile, "compile(...)");
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            q7.k.d(strReplaceAll, "replaceAll(...)");
        } else {
            strReplaceAll = null;
        }
        oVar.f582d = strReplaceAll;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.set(i11, b.b((String) arrayList.get(i11), 0, 0, "[]", 227));
        }
        ArrayList arrayList2 = oVar.f585g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                String str4 = (String) arrayList2.get(i12);
                arrayList2.set(i12, str4 != null ? b.b(str4, 0, 0, "\\^`{|}", 195) : null);
            }
        }
        String str5 = oVar.f586h;
        oVar.f586h = str5 != null ? b.b(str5, 0, 0, " \"#<>\\^`{|}", 163) : null;
        String string = oVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                q7.k.d(patternCompile2, "compile(...)");
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                q7.k.d(strReplaceAll2, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll2);
                q7.k.d(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final int hashCode() {
        return this.f595h.hashCode();
    }

    public final String toString() {
        return this.f595h;
    }
}
