package n6;

import com.stepos.stepclaw.SecurePrefs;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f4063a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4064b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4065c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4066e;

    /* renamed from: f, reason: collision with root package name */
    public final List f4067f;

    /* renamed from: g, reason: collision with root package name */
    public final String f4068g;

    /* renamed from: h, reason: collision with root package name */
    public final String f4069h;

    public m(String str, String str2, String str3, String str4, int i8, ArrayList arrayList, String str5, String str6) {
        this.f4063a = str;
        this.f4064b = str2;
        this.f4065c = str3;
        this.d = str4;
        this.f4066e = i8;
        this.f4067f = arrayList;
        this.f4068g = str5;
        this.f4069h = str6;
    }

    public final String a() {
        if (this.f4065c.length() == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        int length = this.f4063a.length() + 3;
        String str = this.f4069h;
        String strSubstring = str.substring(x5.n.q1(str, AbstractJsonLexerKt.COLON, length, 4) + 1, x5.n.q1(str, '@', 0, 6));
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f4063a.length() + 3;
        String str = this.f4069h;
        int iQ1 = x5.n.q1(str, '/', length, 4);
        String strSubstring = str.substring(iQ1, o6.d.b(iQ1, str.length(), str, "?#"));
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f4063a.length() + 3;
        String str = this.f4069h;
        int iQ1 = x5.n.q1(str, '/', length, 4);
        int iB = o6.d.b(iQ1, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iQ1 < iB) {
            int i8 = iQ1 + 1;
            int iC = o6.d.c(str, '/', i8, iB);
            String strSubstring = str.substring(i8, iC);
            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            iQ1 = iC;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f4067f == null) {
            return null;
        }
        String str = this.f4069h;
        int iQ1 = x5.n.q1(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iQ1, o6.d.c(str, '#', iQ1, str.length()));
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String e() {
        if (this.f4064b.length() == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        int length = this.f4063a.length() + 3;
        String str = this.f4069h;
        String strSubstring = str.substring(length, o6.d.b(length, str.length(), str, ":@"));
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && kotlin.jvm.internal.p.a(((m) obj).f4069h, this.f4069h);
    }

    public final String f() {
        l lVar;
        try {
            lVar = new l(0);
            lVar.e(this, "/...");
        } catch (IllegalArgumentException unused) {
            lVar = null;
        }
        kotlin.jvm.internal.p.b(lVar);
        lVar.d = a7.a.a(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, 0, 0, " \"':;<=>@[]^`{}|/\\?#", 123);
        lVar.f4058e = a7.a.a(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, 0, 0, " \"':;<=>@[]^`{}|/\\?#", 123);
        return lVar.b().f4069h;
    }

    public final URI g() {
        String strSubstring;
        String strReplaceAll;
        l lVar = new l(0);
        ArrayList arrayList = (ArrayList) lVar.f4061h;
        String scheme = this.f4063a;
        lVar.f4057c = scheme;
        lVar.d = e();
        lVar.f4058e = a();
        lVar.f4059f = this.d;
        kotlin.jvm.internal.p.e(scheme, "scheme");
        int i8 = scheme.equals("http") ? 80 : scheme.equals("https") ? 443 : -1;
        int i9 = this.f4066e;
        lVar.f4056b = i9 != i8 ? i9 : -1;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        lVar.f4062i = strD != null ? l.f(a7.a.a(strD, 0, 0, " \"'<>#", 83)) : null;
        if (this.f4068g == null) {
            strSubstring = null;
        } else {
            String str = this.f4069h;
            strSubstring = str.substring(x5.n.q1(str, '#', 0, 6) + 1);
            kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        }
        lVar.f4060g = strSubstring;
        String str2 = (String) lVar.f4059f;
        if (str2 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
            strReplaceAll = patternCompile.matcher(str2).replaceAll(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            kotlin.jvm.internal.p.d(strReplaceAll, "replaceAll(...)");
        } else {
            strReplaceAll = null;
        }
        lVar.f4059f = strReplaceAll;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.set(i10, a7.a.a((String) arrayList.get(i10), 0, 0, "[]", 99));
        }
        ArrayList arrayList2 = (ArrayList) lVar.f4062i;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String str3 = (String) arrayList2.get(i11);
                arrayList2.set(i11, str3 != null ? a7.a.a(str3, 0, 0, "\\^`{|}", 67) : null);
            }
        }
        String str4 = (String) lVar.f4060g;
        lVar.f4060g = str4 != null ? a7.a.a(str4, 0, 0, " \"#<>\\^`{|}", 35) : null;
        String input = lVar.toString();
        try {
            return new URI(input);
        } catch (URISyntaxException e9) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                kotlin.jvm.internal.p.d(patternCompile2, "compile(...)");
                kotlin.jvm.internal.p.e(input, "input");
                String strReplaceAll2 = patternCompile2.matcher(input).replaceAll(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                kotlin.jvm.internal.p.d(strReplaceAll2, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll2);
                kotlin.jvm.internal.p.b(uriCreate);
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e9);
            }
        }
    }

    public final int hashCode() {
        return this.f4069h.hashCode();
    }

    public final String toString() {
        return this.f4069h;
    }
}
