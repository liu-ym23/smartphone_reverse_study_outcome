package la;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import na.C1751a;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.ReaderException;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f5290a;
    public int[] b;
    public int c;
    public boolean e;

    /* renamed from: j, reason: collision with root package name */
    public final char[] f5291j;
    public int d = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;

    public a(Reader reader) {
        if (reader == null) {
            throw new NullPointerException("Reader must be provided.");
        }
        this.b = new int[0];
        this.c = 0;
        this.f5290a = reader;
        this.e = false;
        this.f5291j = new char[1024];
    }

    public static boolean d(int i) {
        if ((i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133) {
            return true;
        }
        if (i >= 160 && i <= 55295) {
            return true;
        }
        if (i < 57344 || i > 65533) {
            return i >= 65536 && i <= 1114111;
        }
        return true;
    }

    public final boolean a(int i) throws IOException {
        if (!this.e && this.d + i >= this.c) {
            Reader reader = this.f5290a;
            char[] cArr = this.f5291j;
            try {
                int i6 = reader.read(cArr, 0, cArr.length - 1);
                if (i6 > 0) {
                    int i10 = this.c;
                    int i11 = this.d;
                    int i12 = i10 - i11;
                    this.b = Arrays.copyOfRange(this.b, i11, i10 + i6);
                    int i13 = i6 - 1;
                    if (Character.isHighSurrogate(cArr[i13])) {
                        if (reader.read(cArr, i6, 1) == -1) {
                            throw new ReaderException(this.f + i6, cArr[i13], "The last char is HighSurrogate (no LowSurrogate detected).");
                        }
                        i6++;
                    }
                    int i14 = 32;
                    int iCharCount = 0;
                    while (iCharCount < i6) {
                        int iCodePointAt = Character.codePointAt(cArr, iCharCount);
                        this.b[i12] = iCodePointAt;
                        if (d(iCodePointAt)) {
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            iCharCount = i6;
                            i14 = iCodePointAt;
                        }
                        i12++;
                    }
                    this.c = i12;
                    this.d = 0;
                    if (i14 != 32) {
                        throw new ReaderException((this.f + i12) - 1, i14, "special characters are not allowed");
                    }
                } else {
                    this.e = true;
                }
            } catch (IOException e) {
                throw new YAMLException(e);
            }
        }
        return this.d + i < this.c;
    }

    public final void b(int i) {
        for (int i6 = 0; i6 < i && a(0); i6++) {
            int[] iArr = this.b;
            int i10 = this.d;
            this.d = i10 + 1;
            int i11 = iArr[i10];
            this.f++;
            this.g++;
            if (C1751a.d.a(i11) || (i11 == 13 && a(0) && this.b[this.d] != 10)) {
                this.h++;
                this.i = 0;
            } else if (i11 != 65279) {
                this.i++;
            }
        }
    }

    public final Mark c() {
        return new Mark(this.f, this.h, this.i, this.d, this.b);
    }

    public final int e() {
        if (a(0)) {
            return this.b[this.d];
        }
        return 0;
    }

    public final int f(int i) {
        if (a(i)) {
            return this.b[this.d + i];
        }
        return 0;
    }

    public final String g(int i) {
        if (i == 0) {
            return "";
        }
        if (a(i)) {
            return new String(this.b, this.d, i);
        }
        int[] iArr = this.b;
        int i6 = this.d;
        return new String(iArr, i6, Math.min(i, this.c - i6));
    }

    public final String h(int i) {
        String strG = g(i);
        this.d += i;
        this.f += i;
        this.g += i;
        this.i += i;
        return strG;
    }
}
