package ad;

import com.fasterxml.jackson.core.JsonPointer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: k, reason: collision with root package name */
    public static final char[] f558k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public String f559a;

    /* renamed from: b, reason: collision with root package name */
    public String f560b;

    /* renamed from: c, reason: collision with root package name */
    public String f561c;

    /* renamed from: d, reason: collision with root package name */
    public String f562d;

    /* renamed from: e, reason: collision with root package name */
    public int f563e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f564f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f565g;

    /* renamed from: h, reason: collision with root package name */
    public String f566h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f567j;

    public final String a() {
        String str = this.i;
        return this.f561c.length() == 0 ? "" : str.substring(hc.h.d0(str, ':', this.f559a.length() + 3, 4) + 1, hc.h.d0(str, '@', 0, 6));
    }

    public final String b() {
        String str = this.i;
        int iD0 = hc.h.d0(str, JsonPointer.SEPARATOR, this.f559a.length() + 3, 4);
        return str.substring(iD0, bd.b.g(str, iD0, "?#", str.length()));
    }

    public final ArrayList c() {
        String str = this.i;
        int iD0 = hc.h.d0(str, JsonPointer.SEPARATOR, this.f559a.length() + 3, 4);
        int iG = bd.b.g(str, iD0, "?#", str.length());
        ArrayList arrayList = new ArrayList();
        while (iD0 < iG) {
            int i = iD0 + 1;
            int iF = bd.b.f(JsonPointer.SEPARATOR, i, iG, str);
            arrayList.add(str.substring(i, iF));
            iD0 = iF;
        }
        return arrayList;
    }

    public final String d() {
        String str = this.i;
        if (this.f565g == null) {
            return null;
        }
        int iD0 = hc.h.d0(str, '?', 0, 6) + 1;
        return str.substring(iD0, bd.b.f('#', iD0, str.length(), str));
    }

    public final String e() {
        String str = this.i;
        if (this.f560b.length() == 0) {
            return "";
        }
        int length = this.f559a.length() + 3;
        return str.substring(length, bd.b.g(str, length, ":@", str.length()));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q) && ((q) obj).i.equals(this.i);
    }

    public final String f() {
        p pVar;
        try {
            pVar = new p();
            pVar.c(this, "/...");
        } catch (IllegalArgumentException unused) {
            pVar = null;
        }
        pVar.getClass();
        pVar.f551b = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        pVar.f552c = b.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        return pVar.a().i;
    }

    public final URI g() {
        String strReplaceAll;
        String str = this.i;
        p pVar = new p();
        String str2 = this.f559a;
        pVar.f550a = str2;
        pVar.f551b = e();
        pVar.f552c = a();
        pVar.f553d = this.f562d;
        int i = this.f563e;
        str2.getClass();
        if (i == (str2.equals("http") ? 80 : str2.equals("https") ? 443 : -1)) {
            i = -1;
        }
        pVar.f554e = i;
        ArrayList arrayList = pVar.f555f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        pVar.f556g = strD != null ? b.f(b.b(strD, 0, 0, " \"'<>#", 211)) : null;
        pVar.f557h = this.f566h == null ? null : str.substring(hc.h.d0(str, '#', 0, 6) + 1);
        String str3 = pVar.f553d;
        if (str3 != null) {
            Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
            patternCompile.getClass();
            strReplaceAll = patternCompile.matcher(str3).replaceAll("");
            strReplaceAll.getClass();
        } else {
            strReplaceAll = null;
        }
        pVar.f553d = strReplaceAll;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.set(i3, b.b((String) arrayList.get(i3), 0, 0, "[]", 227));
        }
        ArrayList arrayList2 = pVar.f556g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                String str4 = (String) arrayList2.get(i10);
                arrayList2.set(i10, str4 != null ? b.b(str4, 0, 0, "\\^`{|}", 195) : null);
            }
        }
        String str5 = pVar.f557h;
        pVar.f557h = str5 != null ? b.b(str5, 0, 0, " \"#<>\\^`{|}", 163) : null;
        String string = pVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                Pattern patternCompile2 = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                patternCompile2.getClass();
                String strReplaceAll2 = patternCompile2.matcher(string).replaceAll("");
                strReplaceAll2.getClass();
                URI uriCreate = URI.create(strReplaceAll2);
                uriCreate.getClass();
                return uriCreate;
            } catch (Exception unused) {
                o.h(e10);
                return null;
            }
        }
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    public final String toString() {
        return this.i;
    }
}
