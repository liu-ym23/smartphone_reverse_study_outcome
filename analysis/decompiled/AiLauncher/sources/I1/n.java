package I1;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final a[] f3342a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3343b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3344a;

        /* renamed from: b, reason: collision with root package name */
        public final char[] f3345b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3346c;

        public a(String str, int i10) {
            this.f3344a = str;
            this.f3345b = str.toCharArray();
            this.f3346c = i10;
        }
    }

    public n(int i10) {
        this.f3343b = i10 - 1;
        this.f3342a = new a[i10];
        a("$ref", 0, 4, 1185263);
        a("@type", 0, 5, 62680954);
    }

    public static String c(String str, int i10, int i11) {
        char[] cArr = new char[i11];
        str.getChars(i10, i11 + i10, cArr, 0);
        return new String(cArr);
    }

    public String a(String str, int i10, int i11, int i12) {
        int i13 = this.f3343b & i12;
        a aVar = this.f3342a[i13];
        if (aVar != null) {
            return (i12 == aVar.f3346c && i11 == aVar.f3345b.length && str.regionMatches(i10, aVar.f3344a, 0, i11)) ? aVar.f3344a : c(str, i10, i11);
        }
        if (i11 != str.length()) {
            str = c(str, i10, i11);
        }
        String strIntern = str.intern();
        this.f3342a[i13] = new a(strIntern, i12);
        return strIntern;
    }

    public String b(char[] cArr, int i10, int i11, int i12) {
        int i13 = this.f3343b & i12;
        a aVar = this.f3342a[i13];
        if (aVar == null) {
            String strIntern = new String(cArr, i10, i11).intern();
            this.f3342a[i13] = new a(strIntern, i12);
            return strIntern;
        }
        if (i12 == aVar.f3346c && i11 == aVar.f3345b.length) {
            for (int i14 = 0; i14 < i11; i14++) {
                if (cArr[i10 + i14] == aVar.f3345b[i14]) {
                }
            }
            return aVar.f3344a;
        }
        return new String(cArr, i10, i11);
    }
}
