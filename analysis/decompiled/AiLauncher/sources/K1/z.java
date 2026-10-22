package K1;

import androidx.room.RoomDatabase;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public final class z extends Writer {

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f4086k;

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f4087l;

    /* renamed from: n, reason: collision with root package name */
    public static final char[] f4089n;

    /* renamed from: a, reason: collision with root package name */
    public char[] f4090a;

    /* renamed from: b, reason: collision with root package name */
    public int f4091b;

    /* renamed from: c, reason: collision with root package name */
    public int f4092c;

    /* renamed from: d, reason: collision with root package name */
    public final Writer f4093d;

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<char[]> f4080e = new ThreadLocal<>();

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f4081f = {9, 99, RoomDatabase.MAX_BIND_PARAMETER_CNT, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    /* renamed from: g, reason: collision with root package name */
    public static final char[] f4082g = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', 'u', 'v', 'w', 'x', 'y', GMTDateParser.ZONE};

    /* renamed from: h, reason: collision with root package name */
    public static final char[] f4083h = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};

    /* renamed from: i, reason: collision with root package name */
    public static final char[] f4084i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f4085j = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final char[] f4088m = new char[93];

    static {
        byte[] bArr = new byte[161];
        f4086k = bArr;
        byte[] bArr2 = new byte[161];
        f4087l = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i10 = 14; i10 <= 31; i10++) {
            f4086k[i10] = 4;
            f4087l[i10] = 4;
        }
        for (int i11 = 127; i11 < 160; i11++) {
            f4086k[i11] = 4;
            f4087l[i11] = 4;
        }
        char[] cArr = f4088m;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = JsonFactory.DEFAULT_QUOTE_CHAR;
        cArr[39] = '\'';
        cArr[47] = JsonPointer.SEPARATOR;
        cArr[92] = '\\';
        f4089n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public z(Writer writer, int i10, SerializerFeature[] serializerFeatureArr) {
        this.f4093d = writer;
        ThreadLocal<char[]> threadLocal = f4080e;
        char[] cArr = threadLocal.get();
        this.f4090a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.f4090a == null) {
            this.f4090a = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i10 |= serializerFeature.mask;
        }
        this.f4092c = i10;
    }

    public static void m(long j10, int i10, char[] cArr) {
        char c10;
        if (j10 < 0) {
            j10 = -j10;
            c10 = '-';
        } else {
            c10 = 0;
        }
        while (j10 > 2147483647L) {
            long j11 = j10 / 100;
            int i11 = (int) (j10 - (((j11 << 6) + (j11 << 5)) + (j11 << 2)));
            cArr[i10 - 1] = f4084i[i11];
            i10 -= 2;
            cArr[i10] = f4083h[i11];
            j10 = j11;
        }
        int i12 = (int) j10;
        while (i12 >= 65536) {
            int i13 = i12 / 100;
            int i14 = i12 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            cArr[i10 - 1] = f4084i[i14];
            i10 -= 2;
            cArr[i10] = f4083h[i14];
            i12 = i13;
        }
        while (true) {
            int i15 = (52429 * i12) >>> 19;
            int i16 = i10 - 1;
            cArr[i16] = f4082g[i12 - ((i15 << 3) + (i15 << 1))];
            if (i15 == 0) {
                break;
            }
            i12 = i15;
            i10 = i16;
        }
        if (c10 != 0) {
            cArr[i10 - 2] = c10;
        }
    }

    public void A(boolean z10) throws IOException {
        write(z10 ? "true" : "false");
    }

    public void G(byte[] bArr) throws IOException {
        int length = bArr.length;
        boolean z10 = (this.f4092c & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c10 = z10 ? '\'' : JsonFactory.DEFAULT_QUOTE_CHAR;
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = I1.d.f3278y;
        int i10 = (length / 3) * 3;
        int i11 = length - 1;
        int i12 = this.f4091b;
        int i13 = (((i11 / 3) + 1) << 2) + i12;
        int i14 = i13 + 2;
        if (i14 > this.f4090a.length) {
            if (this.f4093d != null) {
                write(c10);
                int i15 = 0;
                while (i15 < i10) {
                    int i16 = i15 + 2;
                    int i17 = ((bArr[i15 + 1] & 255) << 8) | ((bArr[i15] & 255) << 16);
                    i15 += 3;
                    int i18 = i17 | (bArr[i16] & 255);
                    write(cArr[(i18 >>> 18) & 63]);
                    write(cArr[(i18 >>> 12) & 63]);
                    write(cArr[(i18 >>> 6) & 63]);
                    write(cArr[i18 & 63]);
                }
                int i19 = length - i10;
                if (i19 > 0) {
                    int i20 = ((bArr[i10] & 255) << 10) | (i19 == 2 ? (bArr[i11] & 255) << 2 : 0);
                    write(cArr[i20 >> 12]);
                    write(cArr[(i20 >>> 6) & 63]);
                    write(i19 == 2 ? cArr[i20 & 63] : '=');
                    write(61);
                }
                write(c10);
                return;
            }
            l(i14);
        }
        this.f4091b = i14;
        int i21 = i12 + 1;
        this.f4090a[i12] = c10;
        int i22 = 0;
        while (i22 < i10) {
            int i23 = i22 + 2;
            int i24 = ((bArr[i22 + 1] & 255) << 8) | ((bArr[i22] & 255) << 16);
            i22 += 3;
            int i25 = i24 | (bArr[i23] & 255);
            char[] cArr2 = this.f4090a;
            cArr2[i21] = cArr[(i25 >>> 18) & 63];
            cArr2[i21 + 1] = cArr[(i25 >>> 12) & 63];
            int i26 = i21 + 3;
            cArr2[i21 + 2] = cArr[(i25 >>> 6) & 63];
            i21 += 4;
            cArr2[i26] = cArr[i25 & 63];
        }
        int i27 = length - i10;
        if (i27 > 0) {
            int i28 = ((bArr[i10] & 255) << 10) | (i27 == 2 ? (bArr[i11] & 255) << 2 : 0);
            char[] cArr3 = this.f4090a;
            cArr3[i13 - 3] = cArr[i28 >> 12];
            cArr3[i13 - 2] = cArr[(i28 >>> 6) & 63];
            cArr3[i13 - 1] = i27 == 2 ? cArr[i28 & 63] : '=';
            cArr3[i13] = '=';
        }
        this.f4090a[i13 + 1] = c10;
    }

    public void J(String str, boolean z10) throws IOException {
        int i10 = this.f4092c;
        if ((SerializerFeature.UseSingleQuotes.mask & i10) == 0) {
            if ((i10 & SerializerFeature.QuoteFieldNames.mask) != 0) {
                g0(str, ':', z10);
                return;
            } else {
                U(str);
                return;
            }
        }
        if ((SerializerFeature.QuoteFieldNames.mask & i10) == 0) {
            V(str);
        } else {
            k0(str);
            write(58);
        }
    }

    public final void U(String str) throws IOException {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.f4091b + length + 1;
        if (i10 > this.f4090a.length) {
            if (this.f4093d != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char cCharAt = str.charAt(i11);
                    byte[] bArr = f4086k;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z10) {
                    write(34);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char cCharAt2 = str.charAt(i12);
                    byte[] bArr2 = f4086k;
                    if (cCharAt2 >= bArr2.length || bArr2[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(f4088m[cCharAt2]);
                    }
                }
                if (z10) {
                    write(34);
                }
                write(58);
                return;
            }
            l(i10);
        }
        if (length == 0) {
            int i13 = this.f4091b;
            if (i13 + 3 > this.f4090a.length) {
                l(i13 + 3);
            }
            char[] cArr = this.f4090a;
            int i14 = this.f4091b;
            int i15 = i14 + 1;
            this.f4091b = i15;
            cArr[i14] = JsonFactory.DEFAULT_QUOTE_CHAR;
            int i16 = i14 + 2;
            this.f4091b = i16;
            cArr[i15] = JsonFactory.DEFAULT_QUOTE_CHAR;
            this.f4091b = i14 + 3;
            cArr[i16] = ':';
            return;
        }
        int i17 = this.f4091b;
        int i18 = i17 + length;
        str.getChars(0, length, this.f4090a, i17);
        this.f4091b = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.f4090a;
            char c10 = cArr2[i19];
            byte[] bArr3 = f4086k;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (z11) {
                    i10++;
                    if (i10 > cArr2.length) {
                        l(i10);
                    }
                    this.f4091b = i10;
                    char[] cArr3 = this.f4090a;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr3, i20, cArr3, i19 + 2, i18 - i19);
                    char[] cArr4 = this.f4090a;
                    cArr4[i19] = '\\';
                    cArr4[i20] = f4088m[c10];
                    i18++;
                    i19 = i20;
                } else {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        l(i10);
                    }
                    this.f4091b = i10;
                    char[] cArr5 = this.f4090a;
                    int i21 = i19 + 1;
                    System.arraycopy(cArr5, i21, cArr5, i19 + 3, (i18 - i19) - 1);
                    char[] cArr6 = this.f4090a;
                    System.arraycopy(cArr6, 0, cArr6, 1, i19);
                    char[] cArr7 = this.f4090a;
                    cArr7[i17] = JsonFactory.DEFAULT_QUOTE_CHAR;
                    cArr7[i21] = '\\';
                    i19 += 2;
                    cArr7[i19] = f4088m[c10];
                    i18 += 2;
                    cArr7[this.f4091b - 2] = JsonFactory.DEFAULT_QUOTE_CHAR;
                    z11 = true;
                }
            }
            i19++;
        }
        this.f4090a[this.f4091b - 1] = ':';
    }

    public final void V(String str) throws IOException {
        int length = str.length();
        boolean z10 = true;
        int i10 = this.f4091b + length + 1;
        if (i10 > this.f4090a.length) {
            if (this.f4093d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    char cCharAt = str.charAt(i11);
                    byte[] bArr = f4087l;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z10) {
                    write(39);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    char cCharAt2 = str.charAt(i12);
                    byte[] bArr2 = f4087l;
                    if (cCharAt2 >= bArr2.length || bArr2[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(f4088m[cCharAt2]);
                    }
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
            l(i10);
        }
        if (length == 0) {
            int i13 = this.f4091b;
            if (i13 + 3 > this.f4090a.length) {
                l(i13 + 3);
            }
            char[] cArr = this.f4090a;
            int i14 = this.f4091b;
            int i15 = i14 + 1;
            this.f4091b = i15;
            cArr[i14] = '\'';
            int i16 = i14 + 2;
            this.f4091b = i16;
            cArr[i15] = '\'';
            this.f4091b = i14 + 3;
            cArr[i16] = ':';
            return;
        }
        int i17 = this.f4091b;
        int i18 = i17 + length;
        str.getChars(0, length, this.f4090a, i17);
        this.f4091b = i10;
        int i19 = i17;
        boolean z11 = false;
        while (i19 < i18) {
            char[] cArr2 = this.f4090a;
            char c10 = cArr2[i19];
            byte[] bArr3 = f4087l;
            if (c10 < bArr3.length && bArr3[c10] != 0) {
                if (z11) {
                    i10++;
                    if (i10 > cArr2.length) {
                        l(i10);
                    }
                    this.f4091b = i10;
                    char[] cArr3 = this.f4090a;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr3, i20, cArr3, i19 + 2, i18 - i19);
                    char[] cArr4 = this.f4090a;
                    cArr4[i19] = '\\';
                    cArr4[i20] = f4088m[c10];
                    i18++;
                    i19 = i20;
                } else {
                    i10 += 3;
                    if (i10 > cArr2.length) {
                        l(i10);
                    }
                    this.f4091b = i10;
                    char[] cArr5 = this.f4090a;
                    int i21 = i19 + 1;
                    System.arraycopy(cArr5, i21, cArr5, i19 + 3, (i18 - i19) - 1);
                    char[] cArr6 = this.f4090a;
                    System.arraycopy(cArr6, 0, cArr6, 1, i19);
                    char[] cArr7 = this.f4090a;
                    cArr7[i17] = '\'';
                    cArr7[i21] = '\\';
                    i19 += 2;
                    cArr7[i19] = f4088m[c10];
                    i18 += 2;
                    cArr7[this.f4091b - 2] = '\'';
                    z11 = true;
                }
            }
            i19++;
        }
        this.f4090a[i10 - 1] = ':';
    }

    public void Y() {
        write("null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z append(char c10) throws IOException {
        write(c10);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4093d != null && this.f4091b > 0) {
            flush();
        }
        char[] cArr = this.f4090a;
        if (cArr.length <= 8192) {
            f4080e.set(cArr);
        }
        this.f4090a = null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public z append(CharSequence charSequence) throws IOException {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    public void e0(String str) throws IOException {
        if ((this.f4092c & SerializerFeature.UseSingleQuotes.mask) != 0) {
            k0(str);
        } else {
            g0(str, (char) 0, true);
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        Writer writer = this.f4093d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f4090a, 0, this.f4091b);
            this.f4093d.flush();
            this.f4091b = 0;
        } catch (IOException e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public z append(CharSequence charSequence, int i10, int i11) throws IOException {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i10, i11).toString();
        write(string, 0, string.length());
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x023a A[PHI: r5 r11
      0x023a: PHI (r5v23 int) = (r5v17 int), (r5v24 int) binds: [B:150:0x0284, B:116:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r11v10 int) = (r11v5 int), (r11v11 int) binds: [B:150:0x0284, B:116:0x0238] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023e A[PHI: r5 r7 r11
      0x023e: PHI (r5v20 int) = (r5v17 int), (r5v19 int), (r5v24 int) binds: [B:150:0x0284, B:128:0x024f, B:116:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x023e: PHI (r7v18 int) = (r7v2 int), (r7v16 int), (r7v2 int) binds: [B:150:0x0284, B:128:0x024f, B:116:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x023e: PHI (r11v7 int) = (r11v5 int), (r11v6 int), (r11v11 int) binds: [B:150:0x0284, B:128:0x024f, B:116:0x0238] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g0(java.lang.String r23, char r24, boolean r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.z.g0(java.lang.String, char, boolean):void");
    }

    public void i(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            this.f4092c = serializerFeature.mask | this.f4092c;
        } else {
            this.f4092c = (~serializerFeature.mask) & this.f4092c;
        }
    }

    public void k0(String str) throws IOException {
        int i10 = 0;
        if (str == null) {
            int i11 = this.f4091b + 4;
            if (i11 > this.f4090a.length) {
                l(i11);
            }
            "null".getChars(0, 4, this.f4090a, this.f4091b);
            this.f4091b = i11;
            return;
        }
        int length = str.length();
        int i12 = this.f4091b + length + 2;
        if (i12 > this.f4090a.length) {
            if (this.f4093d != null) {
                write(39);
                while (i10 < str.length()) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && (this.f4092c & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        write(f4088m[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i10++;
                }
                write(39);
                return;
            }
            l(i12);
        }
        int i13 = this.f4091b;
        int i14 = i13 + 1;
        int i15 = i14 + length;
        char[] cArr = this.f4090a;
        cArr[i13] = '\'';
        str.getChars(0, length, cArr, i14);
        this.f4091b = i12;
        int i16 = -1;
        char c10 = 0;
        for (int i17 = i14; i17 < i15; i17++) {
            char c11 = this.f4090a[i17];
            if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && (this.f4092c & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i10++;
                i16 = i17;
                c10 = c11;
            }
        }
        int i18 = i12 + i10;
        if (i18 > this.f4090a.length) {
            l(i18);
        }
        this.f4091b = i18;
        if (i10 == 1) {
            char[] cArr2 = this.f4090a;
            int i19 = i16 + 1;
            System.arraycopy(cArr2, i19, cArr2, i16 + 2, (i15 - i16) - 1);
            char[] cArr3 = this.f4090a;
            cArr3[i16] = '\\';
            cArr3[i19] = f4088m[c10];
        } else if (i10 > 1) {
            char[] cArr4 = this.f4090a;
            int i20 = i16 + 1;
            System.arraycopy(cArr4, i20, cArr4, i16 + 2, (i15 - i16) - 1);
            char[] cArr5 = this.f4090a;
            cArr5[i16] = '\\';
            cArr5[i20] = f4088m[c10];
            int i21 = i15 + 1;
            for (int i22 = i16 - 1; i22 >= i14; i22--) {
                char[] cArr6 = this.f4090a;
                char c12 = cArr6[i22];
                if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && (this.f4092c & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i23 = i22 + 1;
                    System.arraycopy(cArr6, i23, cArr6, i22 + 2, (i21 - i22) - 1);
                    char[] cArr7 = this.f4090a;
                    cArr7[i22] = '\\';
                    cArr7[i23] = f4088m[c12];
                    i21++;
                }
            }
        }
        this.f4090a[this.f4091b - 1] = '\'';
    }

    public void l(int i10) {
        char[] cArr = this.f4090a;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i10) {
            i10 = length;
        }
        char[] cArr2 = new char[i10];
        System.arraycopy(cArr, 0, cArr2, 0, this.f4091b);
        this.f4090a = cArr2;
    }

    public boolean n(SerializerFeature serializerFeature) {
        return (this.f4092c & serializerFeature.mask) != 0;
    }

    public String toString() {
        return new String(this.f4090a, 0, this.f4091b);
    }

    @Override // java.io.Writer
    public void write(int i10) throws IOException {
        int i11 = 1;
        int i12 = this.f4091b + 1;
        if (i12 <= this.f4090a.length) {
            i11 = i12;
        } else if (this.f4093d == null) {
            l(i12);
            i11 = i12;
        } else {
            flush();
        }
        this.f4090a[this.f4091b] = (char) i10;
        this.f4091b = i11;
    }

    public void writeInt(int i10) throws IOException {
        if (i10 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i11 = 0;
        while ((i10 < 0 ? -i10 : i10) > f4081f[i11]) {
            i11++;
        }
        int i12 = i11 + 1;
        if (i10 < 0) {
            i12 = i11 + 2;
        }
        int i13 = this.f4091b + i12;
        if (i13 > this.f4090a.length) {
            if (this.f4093d != null) {
                char[] cArr = new char[i12];
                m(i10, i12, cArr);
                write(cArr, 0, i12);
                return;
            }
            l(i13);
        }
        m(i10, i13, this.f4090a);
        this.f4091b = i13;
    }

    public void writeLong(long j10) throws IOException {
        if (j10 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j11 = j10 < 0 ? -j10 : j10;
        int i10 = 1;
        long j12 = 10;
        while (true) {
            if (i10 >= 19) {
                i10 = 0;
                break;
            } else {
                if (j11 < j12) {
                    break;
                }
                j12 *= 10;
                i10++;
            }
        }
        int i11 = i10 != 0 ? i10 : 19;
        if (j10 < 0) {
            i11++;
        }
        int i12 = this.f4091b + i11;
        if (i12 > this.f4090a.length) {
            if (this.f4093d != null) {
                char[] cArr = new char[i11];
                m(j10, i11, cArr);
                write(cArr, 0, i11);
                return;
            }
            l(i12);
        }
        m(j10, i12, this.f4090a);
        this.f4091b = i12;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) throws IOException {
        int i12;
        if (i10 < 0 || i10 > cArr.length || i11 < 0 || (i12 = i10 + i11) > cArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.f4091b + i11;
        if (i13 > this.f4090a.length) {
            if (this.f4093d == null) {
                l(i13);
            } else {
                do {
                    char[] cArr2 = this.f4090a;
                    int length = cArr2.length;
                    int i14 = this.f4091b;
                    int i15 = length - i14;
                    System.arraycopy(cArr, i10, cArr2, i14, i15);
                    this.f4091b = this.f4090a.length;
                    flush();
                    i11 -= i15;
                    i10 += i15;
                } while (i11 > this.f4090a.length);
                i13 = i11;
            }
        }
        System.arraycopy(cArr, i10, this.f4090a, this.f4091b, i11);
        this.f4091b = i13;
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f4091b + i11;
        if (i13 > this.f4090a.length) {
            if (this.f4093d == null) {
                l(i13);
            } else {
                while (true) {
                    char[] cArr = this.f4090a;
                    int length = cArr.length;
                    int i14 = this.f4091b;
                    int i15 = length - i14;
                    i12 = i10 + i15;
                    str.getChars(i10, i12, cArr, i14);
                    this.f4091b = this.f4090a.length;
                    flush();
                    i11 -= i15;
                    if (i11 <= this.f4090a.length) {
                        break;
                    } else {
                        i10 = i12;
                    }
                }
                i13 = i11;
                i10 = i12;
            }
        }
        str.getChars(i10, i11 + i10, this.f4090a, this.f4091b);
        this.f4091b = i13;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        if (str == null) {
            Y();
        } else {
            write(str, 0, str.length());
        }
    }
}
