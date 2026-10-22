package okhttp3;

import bd.i;
import gc.q;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Regex;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f10977a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10978b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10979c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10980d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10981e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f10982f;

    /* renamed from: g, reason: collision with root package name */
    public final List<String> f10983g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10984i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10985a;

        /* renamed from: d, reason: collision with root package name */
        public String f10988d;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList f10991g;
        public String h;

        /* renamed from: b, reason: collision with root package name */
        public String f10986b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f10987c = "";

        /* renamed from: e, reason: collision with root package name */
        public int f10989e = -1;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f10990f = m.c0("");

        public static ArrayList e(String str) {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int iQ0 = q.q0(str, '&', i10, 4);
                if (iQ0 == -1) {
                    iQ0 = str.length();
                }
                int iQ02 = q.q0(str, '=', i10, 4);
                if (iQ02 == -1 || iQ02 > iQ0) {
                    String strSubstring = str.substring(i10, iQ0);
                    kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i10, iQ02);
                    kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iQ02 + 1, iQ0);
                    kotlin.jvm.internal.g.e(strSubstring3, "substring(...)");
                    arrayList.add(strSubstring3);
                }
                i10 = iQ0 + 1;
            }
            return arrayList;
        }

        public final void a(String name, String str) {
            kotlin.jvm.internal.g.f(name, "name");
            if (this.f10991g == null) {
                this.f10991g = new ArrayList();
            }
            ArrayList arrayList = this.f10991g;
            kotlin.jvm.internal.g.c(arrayList);
            arrayList.add(pd.a.a(name, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", 0, 0, 91));
            ArrayList arrayList2 = this.f10991g;
            kotlin.jvm.internal.g.c(arrayList2);
            arrayList2.add(str != null ? pd.a.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", 0, 0, 91) : null);
        }

        public final g b() {
            ArrayList arrayList;
            String str = this.f10985a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strD = pd.a.d(0, this.f10986b, 0, 7);
            String strD2 = pd.a.d(0, this.f10987c, 0, 7);
            String str2 = this.f10988d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iC = c();
            ArrayList arrayList2 = this.f10990f;
            ArrayList arrayList3 = new ArrayList(m.Z(arrayList2, 10));
            int size = arrayList2.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList2.get(i10);
                i10++;
                arrayList3.add(pd.a.d(0, (String) obj, 0, 7));
            }
            ArrayList arrayList4 = this.f10991g;
            if (arrayList4 != null) {
                arrayList = new ArrayList(m.Z(arrayList4, 10));
                int size2 = arrayList4.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList4.get(i11);
                    i11++;
                    String str3 = (String) obj2;
                    arrayList.add(str3 != null ? pd.a.d(0, str3, 0, 3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.h;
            return new g(str, strD, strD2, str2, iC, arrayList3, arrayList, str4 != null ? pd.a.d(0, str4, 0, 7) : null, toString());
        }

        public final int c() {
            int i10 = this.f10989e;
            if (i10 != -1) {
                return i10;
            }
            String str = this.f10985a;
            kotlin.jvm.internal.g.c(str);
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(okhttp3.g r18, java.lang.String r19) {
            /*
                Method dump skipped, instructions count: 921
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.g.a.d(okhttp3.g, java.lang.String):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String toString() {
            /*
                Method dump skipped, instructions count: 275
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.g.a.toString():java.lang.String");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public g() {
        throw null;
    }

    public g(String str, String str2, String str3, String str4, int i10, ArrayList arrayList, ArrayList arrayList2, String str5, String str6) {
        this.f10977a = str;
        this.f10978b = str2;
        this.f10979c = str3;
        this.f10980d = str4;
        this.f10981e = i10;
        this.f10982f = arrayList;
        this.f10983g = arrayList2;
        this.h = str5;
        this.f10984i = str6;
    }

    public final String a() {
        if (this.f10979c.length() == 0) {
            return "";
        }
        int length = this.f10977a.length() + 3;
        String str = this.f10984i;
        String strSubstring = str.substring(q.q0(str, ':', length, 4) + 1, q.q0(str, '@', 0, 6));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f10977a.length() + 3;
        String str = this.f10984i;
        int iQ0 = q.q0(str, '/', length, 4);
        String strSubstring = str.substring(iQ0, i.d(str, iQ0, str.length(), "?#"));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f10977a.length() + 3;
        String str = this.f10984i;
        int iQ0 = q.q0(str, '/', length, 4);
        int iD = i.d(str, iQ0, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iQ0 < iD) {
            int i10 = iQ0 + 1;
            int iC = i.c(str, '/', i10, iD);
            String strSubstring = str.substring(i10, iC);
            kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            iQ0 = iC;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f10983g == null) {
            return null;
        }
        String str = this.f10984i;
        int iQ0 = q.q0(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iQ0, i.c(str, '#', iQ0, str.length()));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String e() {
        if (this.f10978b.length() == 0) {
            return "";
        }
        int length = this.f10977a.length() + 3;
        String str = this.f10984i;
        String strSubstring = str.substring(length, i.d(str, length, str.length(), ":@"));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof g) && kotlin.jvm.internal.g.b(((g) obj).f10984i, this.f10984i);
    }

    public final a f() {
        a aVar = new a();
        String scheme = this.f10977a;
        aVar.f10985a = scheme;
        aVar.f10986b = e();
        aVar.f10987c = a();
        aVar.f10988d = this.f10980d;
        kotlin.jvm.internal.g.f(scheme, "scheme");
        int i10 = scheme.equals("http") ? 80 : scheme.equals("https") ? 443 : -1;
        int i11 = this.f10981e;
        aVar.f10989e = i11 != i10 ? i11 : -1;
        ArrayList arrayList = aVar.f10990f;
        arrayList.clear();
        arrayList.addAll(c());
        String strD = d();
        String strSubstring = null;
        aVar.f10991g = strD != null ? a.e(pd.a.a(strD, " \"'<>#", 0, 0, 83)) : null;
        if (this.h != null) {
            String str = this.f10984i;
            strSubstring = str.substring(q.q0(str, '#', 0, 6) + 1);
            kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        }
        aVar.h = strSubstring;
        return aVar;
    }

    public final a g(String link) {
        kotlin.jvm.internal.g.f(link, "link");
        try {
            a aVar = new a();
            aVar.d(this, link);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String h() {
        a aVarG = g("/...");
        kotlin.jvm.internal.g.c(aVarG);
        aVarG.f10986b = pd.a.a("", " \"':;<=>@[]^`{}|/\\?#", 0, 0, 123);
        aVarG.f10987c = pd.a.a("", " \"':;<=>@[]^`{}|/\\?#", 0, 0, 123);
        return aVarG.b().f10984i;
    }

    public final int hashCode() {
        return this.f10984i.hashCode();
    }

    public final g i(String link) {
        kotlin.jvm.internal.g.f(link, "link");
        a aVarG = g(link);
        if (aVarG != null) {
            return aVarG.b();
        }
        return null;
    }

    public final URI j() {
        a aVarF = f();
        ArrayList arrayList = aVarF.f10990f;
        String str = aVarF.f10988d;
        aVarF.f10988d = str != null ? new Regex("[\"<>^`{|}]").d(str, "") : null;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.set(i10, pd.a.a((String) arrayList.get(i10), "[]", 0, 0, 99));
        }
        ArrayList arrayList2 = aVarF.f10991g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String str2 = (String) arrayList2.get(i11);
                arrayList2.set(i11, str2 != null ? pd.a.a(str2, "\\^`{|}", 0, 0, 67) : null);
            }
        }
        String str3 = aVarF.h;
        aVarF.h = str3 != null ? pd.a.a(str3, " \"#<>\\^`{|}", 0, 0, 35) : null;
        String string = aVarF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").d(string, ""));
                kotlin.jvm.internal.g.c(uriCreate);
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final String toString() {
        return this.f10984i;
    }
}
