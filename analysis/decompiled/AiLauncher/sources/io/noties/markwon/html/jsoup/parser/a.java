package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.UncheckedIOException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final char[] f34238a;

    /* renamed from: b, reason: collision with root package name */
    public final Reader f34239b;

    /* renamed from: c, reason: collision with root package name */
    public int f34240c;

    /* renamed from: d, reason: collision with root package name */
    public int f34241d;

    /* renamed from: e, reason: collision with root package name */
    public int f34242e;

    /* renamed from: f, reason: collision with root package name */
    public int f34243f;

    /* renamed from: g, reason: collision with root package name */
    public int f34244g;

    /* renamed from: h, reason: collision with root package name */
    public final String[] f34245h;

    public a(Reader reader, int i10) throws IOException {
        this.f34245h = new String[128];
        D8.b.f(reader);
        D8.b.d(reader.markSupported());
        this.f34239b = reader;
        this.f34238a = new char[4096];
        b();
    }

    public static boolean G(char[] cArr, int i10, int i11, String str) {
        if (i11 != str.length()) {
            return false;
        }
        int i12 = 0;
        while (true) {
            int i13 = i11 - 1;
            if (i11 == 0) {
                return true;
            }
            int i14 = i10 + 1;
            int i15 = i12 + 1;
            if (cArr[i10] != str.charAt(i12)) {
                return false;
            }
            i10 = i14;
            i11 = i13;
            i12 = i15;
        }
    }

    public static String c(char[] cArr, String[] strArr, int i10, int i11) {
        if (i11 > 12) {
            return new String(cArr, i10, i11);
        }
        if (i11 < 1) {
            return "";
        }
        int i12 = 0;
        int i13 = i10;
        int i14 = 0;
        while (i12 < i11) {
            i14 = (i14 * 31) + cArr[i13];
            i12++;
            i13++;
        }
        int length = i14 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i10, i11);
            strArr[length] = str2;
            return str2;
        }
        if (G(cArr, i10, i11, str)) {
            return str;
        }
        String str3 = new String(cArr, i10, i11);
        strArr[length] = str3;
        return str3;
    }

    public boolean A() {
        char c10;
        return !r() && (c10 = this.f34238a[this.f34242e]) >= '0' && c10 <= '9';
    }

    public boolean B(String str) throws IOException {
        b();
        int length = str.length();
        if (length > this.f34240c - this.f34242e) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (Character.toUpperCase(str.charAt(i10)) != Character.toUpperCase(this.f34238a[this.f34242e + i10])) {
                return false;
            }
        }
        return true;
    }

    public boolean C() {
        if (r()) {
            return false;
        }
        char c10 = this.f34238a[this.f34242e];
        if (c10 < 'A' || c10 > 'Z') {
            return (c10 >= 'a' && c10 <= 'z') || Character.isLetter(c10);
        }
        return true;
    }

    public int D(char c10) throws IOException {
        b();
        for (int i10 = this.f34242e; i10 < this.f34240c; i10++) {
            if (c10 == this.f34238a[i10]) {
                return i10 - this.f34242e;
            }
        }
        return -1;
    }

    public int E(CharSequence charSequence) throws IOException {
        b();
        char cCharAt = charSequence.charAt(0);
        int i10 = this.f34242e;
        while (i10 < this.f34240c) {
            if (cCharAt != this.f34238a[i10]) {
                do {
                    i10++;
                    if (i10 >= this.f34240c) {
                        break;
                    }
                } while (cCharAt != this.f34238a[i10]);
            }
            int i11 = i10 + 1;
            int length = (charSequence.length() + i11) - 1;
            int i12 = this.f34240c;
            if (i10 < i12 && length <= i12) {
                int i13 = i11;
                for (int i14 = 1; i13 < length && charSequence.charAt(i14) == this.f34238a[i13]; i14++) {
                    i13++;
                }
                if (i13 == length) {
                    return i10 - this.f34242e;
                }
            }
            i10 = i11;
        }
        return -1;
    }

    public int F() {
        return this.f34243f + this.f34242e;
    }

    public void H() {
        this.f34242e = this.f34244g;
    }

    public void I() {
        this.f34242e--;
    }

    public void a() {
        this.f34242e++;
    }

    public final void b() throws IOException {
        int i10 = this.f34242e;
        if (i10 < this.f34241d) {
            return;
        }
        try {
            this.f34239b.skip(i10);
            this.f34239b.mark(4096);
            int i11 = this.f34239b.read(this.f34238a);
            this.f34239b.reset();
            if (i11 != -1) {
                this.f34240c = i11;
                this.f34243f += this.f34242e;
                this.f34242e = 0;
                this.f34244g = 0;
                if (i11 > 3072) {
                    i11 = 3072;
                }
                this.f34241d = i11;
            }
        } catch (IOException e10) {
            throw new UncheckedIOException(e10);
        }
    }

    public char d() throws IOException {
        b();
        char c10 = s() ? (char) 65535 : this.f34238a[this.f34242e];
        this.f34242e++;
        return c10;
    }

    public String e() throws IOException {
        int i10;
        char c10;
        b();
        int i11 = this.f34242e;
        int i12 = this.f34240c;
        char[] cArr = this.f34238a;
        while (true) {
            i10 = this.f34242e;
            if (i10 >= i12 || (c10 = cArr[i10]) == '&' || c10 == '<' || c10 == 0) {
                break;
            }
            this.f34242e = i10 + 1;
        }
        return i10 > i11 ? c(this.f34238a, this.f34245h, i11, i10 - i11) : "";
    }

    public String f() throws IOException {
        int i10;
        char c10;
        b();
        int i11 = this.f34242e;
        while (true) {
            i10 = this.f34242e;
            if (i10 >= this.f34240c || (c10 = this.f34238a[i10]) < '0' || c10 > '9') {
                break;
            }
            this.f34242e = i10 + 1;
        }
        return c(this.f34238a, this.f34245h, i11, i10 - i11);
    }

    public String g() throws IOException {
        int i10;
        char c10;
        b();
        int i11 = this.f34242e;
        while (true) {
            i10 = this.f34242e;
            if (i10 >= this.f34240c || (((c10 = this.f34238a[i10]) < '0' || c10 > '9') && ((c10 < 'A' || c10 > 'F') && (c10 < 'a' || c10 > 'f')))) {
                break;
            }
            this.f34242e = i10 + 1;
        }
        return c(this.f34238a, this.f34245h, i11, i10 - i11);
    }

    public String h() throws IOException {
        char c10;
        b();
        int i10 = this.f34242e;
        while (true) {
            int i11 = this.f34242e;
            if (i11 >= this.f34240c || (((c10 = this.f34238a[i11]) < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !Character.isLetter(c10)))) {
                break;
            }
            this.f34242e++;
        }
        return c(this.f34238a, this.f34245h, i10, this.f34242e - i10);
    }

    public String i() throws IOException {
        char c10;
        b();
        int i10 = this.f34242e;
        while (true) {
            int i11 = this.f34242e;
            if (i11 >= this.f34240c || (((c10 = this.f34238a[i11]) < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !Character.isLetter(c10)))) {
                break;
            }
            this.f34242e++;
        }
        while (!s()) {
            char[] cArr = this.f34238a;
            int i12 = this.f34242e;
            char c11 = cArr[i12];
            if (c11 < '0' || c11 > '9') {
                break;
            }
            this.f34242e = i12 + 1;
        }
        return c(this.f34238a, this.f34245h, i10, this.f34242e - i10);
    }

    public String j() throws IOException {
        int i10;
        char c10;
        b();
        int i11 = this.f34242e;
        int i12 = this.f34240c;
        char[] cArr = this.f34238a;
        while (true) {
            i10 = this.f34242e;
            if (i10 >= i12 || (c10 = cArr[i10]) == '\t' || c10 == '\n' || c10 == '\r' || c10 == '\f' || c10 == ' ' || c10 == '/' || c10 == '>' || c10 == 0) {
                break;
            }
            this.f34242e = i10 + 1;
        }
        return i10 > i11 ? c(this.f34238a, this.f34245h, i11, i10 - i11) : "";
    }

    public String k(char c10) throws IOException {
        int iD = D(c10);
        if (iD == -1) {
            return o();
        }
        String strC = c(this.f34238a, this.f34245h, this.f34242e, iD);
        this.f34242e += iD;
        return strC;
    }

    public String l(String str) throws IOException {
        int iE = E(str);
        if (iE == -1) {
            return o();
        }
        String strC = c(this.f34238a, this.f34245h, this.f34242e, iE);
        this.f34242e += iE;
        return strC;
    }

    public String m(char... cArr) throws IOException {
        b();
        int i10 = this.f34242e;
        int i11 = this.f34240c;
        char[] cArr2 = this.f34238a;
        loop0: while (this.f34242e < i11) {
            for (char c10 : cArr) {
                if (cArr2[this.f34242e] == c10) {
                    break loop0;
                }
            }
            this.f34242e++;
        }
        int i12 = this.f34242e;
        return i12 > i10 ? c(this.f34238a, this.f34245h, i10, i12 - i10) : "";
    }

    public String n(char... cArr) throws IOException {
        b();
        int i10 = this.f34242e;
        int i11 = this.f34240c;
        char[] cArr2 = this.f34238a;
        while (true) {
            int i12 = this.f34242e;
            if (i12 >= i11 || Arrays.binarySearch(cArr, cArr2[i12]) >= 0) {
                break;
            }
            this.f34242e++;
        }
        int i13 = this.f34242e;
        return i13 > i10 ? c(this.f34238a, this.f34245h, i10, i13 - i10) : "";
    }

    public String o() throws IOException {
        b();
        char[] cArr = this.f34238a;
        String[] strArr = this.f34245h;
        int i10 = this.f34242e;
        String strC = c(cArr, strArr, i10, this.f34240c - i10);
        this.f34242e = this.f34240c;
        return strC;
    }

    public boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return E(str.toLowerCase(locale)) > -1 || E(str.toUpperCase(locale)) > -1;
    }

    public char q() throws IOException {
        b();
        if (s()) {
            return (char) 65535;
        }
        return this.f34238a[this.f34242e];
    }

    public boolean r() throws IOException {
        b();
        return this.f34242e >= this.f34240c;
    }

    public final boolean s() {
        return this.f34242e >= this.f34240c;
    }

    public void t() {
        this.f34244g = this.f34242e;
    }

    public String toString() {
        char[] cArr = this.f34238a;
        int i10 = this.f34242e;
        return new String(cArr, i10, this.f34240c - i10);
    }

    public boolean u(String str) throws IOException {
        b();
        if (!x(str)) {
            return false;
        }
        this.f34242e += str.length();
        return true;
    }

    public boolean v(String str) {
        if (!B(str)) {
            return false;
        }
        this.f34242e += str.length();
        return true;
    }

    public boolean w(char c10) {
        return !r() && this.f34238a[this.f34242e] == c10;
    }

    public boolean x(String str) throws IOException {
        b();
        int length = str.length();
        if (length > this.f34240c - this.f34242e) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) != this.f34238a[this.f34242e + i10]) {
                return false;
            }
        }
        return true;
    }

    public boolean y(char... cArr) throws IOException {
        if (r()) {
            return false;
        }
        b();
        char c10 = this.f34238a[this.f34242e];
        for (char c11 : cArr) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }

    public boolean z(char[] cArr) throws IOException {
        b();
        return !r() && Arrays.binarySearch(cArr, this.f34238a[this.f34242e]) >= 0;
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }
}
