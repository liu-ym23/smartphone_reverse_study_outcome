package F9;

import com.fasterxml.jackson.core.JsonPointer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Regex;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes4.dex */
public final class y {
    public static final char[] k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f659a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final ArrayList f;
    public final List g;
    public final String h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f660j;

    public y(String scheme, String str, String str2, String host, int i, ArrayList arrayList, ArrayList arrayList2, String str3, String str4) {
        kotlin.jvm.internal.k.f(scheme, "scheme");
        kotlin.jvm.internal.k.f(host, "host");
        this.f659a = scheme;
        this.b = str;
        this.c = str2;
        this.d = host;
        this.e = i;
        this.f = arrayList;
        this.g = arrayList2;
        this.h = str3;
        this.i = str4;
        this.f660j = scheme.equals("https");
    }

    public final String a() {
        if (this.c.length() == 0) {
            return "";
        }
        int length = this.f659a.length() + 3;
        String str = this.i;
        String strSubstring = str.substring(j9.m.p0(str, ':', length, 4) + 1, j9.m.p0(str, '@', 0, 6));
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f659a.length() + 3;
        String str = this.i;
        int iP0 = j9.m.p0(str, JsonPointer.SEPARATOR, length, 4);
        String strSubstring = str.substring(iP0, G9.b.e(iP0, str.length(), str, "?#"));
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f659a.length() + 3;
        String str = this.i;
        int iP0 = j9.m.p0(str, JsonPointer.SEPARATOR, length, 4);
        int iE = G9.b.e(iP0, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iP0 < iE) {
            int i = iP0 + 1;
            int iF = G9.b.f(str, JsonPointer.SEPARATOR, i, iE);
            String strSubstring = str.substring(i, iF);
            kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iP0 = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.g == null) {
            return null;
        }
        String str = this.i;
        int iP0 = j9.m.p0(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iP0, G9.b.f(str, '#', iP0, str.length()));
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.b.length() == 0) {
            return "";
        }
        int length = this.f659a.length() + 3;
        String str = this.i;
        String strSubstring = str.substring(length, G9.b.e(length, str.length(), str, ":@"));
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof y) && kotlin.jvm.internal.k.b(((y) obj).i, this.i);
    }

    public final x f() {
        String strSubstring;
        x xVar = new x(0);
        ArrayList arrayList = (ArrayList) xVar.c;
        String scheme = this.f659a;
        xVar.d = scheme;
        xVar.e = e();
        xVar.f = a();
        xVar.g = this.d;
        kotlin.jvm.internal.k.f(scheme, "scheme");
        int i = scheme.equals("http") ? 80 : scheme.equals("https") ? WebSocketImpl.DEFAULT_WSS_PORT : -1;
        int i6 = this.e;
        xVar.b = i6 != i ? i6 : -1;
        arrayList.clear();
        arrayList.addAll(c());
        xVar.f(d());
        if (this.h == null) {
            strSubstring = null;
        } else {
            String str = this.i;
            strSubstring = str.substring(j9.m.p0(str, '#', 0, 6) + 1);
            kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        xVar.h = strSubstring;
        return xVar;
    }

    public final x g(String link) {
        kotlin.jvm.internal.k.f(link, "link");
        try {
            x xVar = new x(0);
            xVar.j(this, link);
            return xVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String h() {
        x xVarG = g("/...");
        kotlin.jvm.internal.k.c(xVarG);
        xVarG.e = C0237o.c("", 0, false, " \"':;<=>@[]^`{}|/\\?#", 0, 251);
        xVarG.f = C0237o.c("", 0, false, " \"':;<=>@[]^`{}|/\\?#", 0, 251);
        return xVarG.d().i;
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    public final URI i() {
        x xVarF = f();
        ArrayList arrayList = (ArrayList) xVarF.c;
        String str = (String) xVarF.g;
        xVarF.g = str != null ? new Regex("[\"<>^`{|}]").f(str, "") : null;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, C0237o.c((String) arrayList.get(i), 0, true, "[]", 0, 227));
        }
        ArrayList arrayList2 = (ArrayList) xVarF.i;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                String str2 = (String) arrayList2.get(i6);
                arrayList2.set(i6, str2 != null ? C0237o.c(str2, 0, true, "\\^`{|}", 0, 195) : null);
            }
        }
        String str3 = (String) xVarF.h;
        xVarF.h = str3 != null ? C0237o.c(str3, 0, true, " \"#<>\\^`{|}", 0, 163) : null;
        String string = xVarF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").f(string, ""));
                kotlin.jvm.internal.k.e(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String toString() {
        return this.i;
    }
}
