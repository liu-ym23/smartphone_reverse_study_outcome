package o0;

import l0.AbstractC0822a;

/* renamed from: o0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0897j {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f19055a;

    /* renamed from: b, reason: collision with root package name */
    private final int f19056b;

    public C0897j(int i5) {
        this.f19056b = i5 - 1;
        this.f19055a = new String[i5];
        a("$ref", 0, 4, 1185263);
        String str = AbstractC0822a.f18018c;
        a(str, 0, str.length(), AbstractC0822a.f18018c.hashCode());
    }

    private static String d(String str, int i5, int i6) {
        char[] cArr = new char[i6];
        str.getChars(i5, i6 + i5, cArr, 0);
        return new String(cArr);
    }

    public String a(String str, int i5, int i6, int i7) {
        return b(str, i5, i6, i7, false);
    }

    public String b(String str, int i5, int i6, int i7, boolean z5) {
        int i8 = this.f19056b & i7;
        String str2 = this.f19055a[i8];
        if (str2 == null) {
            if (i6 != str.length()) {
                str = d(str, i5, i6);
            }
            String strIntern = str.intern();
            this.f19055a[i8] = strIntern;
            return strIntern;
        }
        if (i7 == str2.hashCode() && i6 == str2.length() && str.startsWith(str2, i5)) {
            return str2;
        }
        String strD = d(str, i5, i6);
        if (z5) {
            this.f19055a[i8] = strD;
        }
        return strD;
    }

    public String c(char[] cArr, int i5, int i6, int i7) {
        int i8 = this.f19056b & i7;
        String str = this.f19055a[i8];
        if (str == null) {
            String strIntern = new String(cArr, i5, i6).intern();
            this.f19055a[i8] = strIntern;
            return strIntern;
        }
        if (i7 == str.hashCode() && i6 == str.length()) {
            for (int i9 = 0; i9 < i6; i9++) {
                if (cArr[i5 + i9] == str.charAt(i9)) {
                }
            }
            return str;
        }
        return new String(cArr, i5, i6);
    }
}
