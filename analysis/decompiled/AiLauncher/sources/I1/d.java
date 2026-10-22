package I1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: A, reason: collision with root package name */
    public static final boolean[] f3273A;

    /* renamed from: B, reason: collision with root package name */
    public static final boolean[] f3274B;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f3275v;

    /* renamed from: w, reason: collision with root package name */
    public static final ThreadLocal<char[]> f3276w;

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f3277x;

    /* renamed from: y, reason: collision with root package name */
    public static final char[] f3278y;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f3279z;

    /* renamed from: a, reason: collision with root package name */
    public int f3280a;

    /* renamed from: b, reason: collision with root package name */
    public int f3281b;

    /* renamed from: c, reason: collision with root package name */
    public int f3282c;

    /* renamed from: d, reason: collision with root package name */
    public char f3283d;

    /* renamed from: e, reason: collision with root package name */
    public int f3284e;

    /* renamed from: f, reason: collision with root package name */
    public int f3285f;

    /* renamed from: g, reason: collision with root package name */
    public char[] f3286g;

    /* renamed from: h, reason: collision with root package name */
    public int f3287h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3288i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3289j;

    /* renamed from: k, reason: collision with root package name */
    public int f3290k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3291l;

    /* renamed from: m, reason: collision with root package name */
    public TimeZone f3292m;

    /* renamed from: n, reason: collision with root package name */
    public Locale f3293n;

    /* renamed from: o, reason: collision with root package name */
    public Calendar f3294o;

    /* renamed from: p, reason: collision with root package name */
    public int f3295p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3296q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3297r;

    /* renamed from: s, reason: collision with root package name */
    public String f3298s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3299t;

    /* renamed from: u, reason: collision with root package name */
    public long f3300u;

    static {
        int i10;
        try {
            i10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i10 = -1;
        }
        char c10 = 0;
        f3275v = i10 >= 23;
        f3276w = new ThreadLocal<>();
        f3277x = new int[103];
        for (int i11 = 48; i11 <= 57; i11++) {
            f3277x[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            f3277x[i12] = i12 - 87;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            f3277x[i13] = i13 - 55;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f3278y = charArray;
        int[] iArr = new int[256];
        f3279z = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            f3279z[f3278y[i14]] = i14;
        }
        f3279z[61] = 0;
        f3273A = new boolean[256];
        char c11 = 0;
        while (true) {
            boolean[] zArr = f3273A;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        f3274B = new boolean[256];
        while (true) {
            boolean[] zArr2 = f3274B;
            if (c10 >= zArr2.length) {
                return;
            }
            if (c10 >= 'A' && c10 <= 'Z') {
                zArr2[c10] = true;
            } else if (c10 >= 'a' && c10 <= 'z') {
                zArr2[c10] = true;
            } else if (c10 == '_') {
                zArr2[c10] = true;
            } else if (c10 >= '0' && c10 <= '9') {
                zArr2[c10] = true;
            }
            c10 = (char) (c10 + 1);
        }
    }

    public d(String str) {
        this(str, G1.a.f2774c);
    }

    public static boolean c(char c10, char c11, char c12, char c13, char c14, char c15, int i10, int i11) {
        if ((c10 == '1' || c10 == '2') && c11 >= '0' && c11 <= '9' && c12 >= '0' && c12 <= '9' && c13 >= '0' && c13 <= '9') {
            if (c14 == '0') {
                if (c15 < '1' || c15 > '9') {
                    return false;
                }
            } else if (c14 != '1' || (c15 != '0' && c15 != '1' && c15 != '2')) {
                return false;
            }
            if (i10 == 48) {
                return i11 >= 49 && i11 <= 57;
            }
            if (i10 != 49 && i10 != 50) {
                return i10 == 51 && (i11 == 48 || i11 == 49);
            }
            if (i11 >= 48 && i11 <= 57) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(char c10, char c11, char c12, char c13, char c14, char c15) {
        if (c10 == '0') {
            if (c11 < '0' || c11 > '9') {
                return false;
            }
        } else {
            if (c10 != '1') {
                if (c10 == '2' && c11 >= '0' && c11 <= '4') {
                }
                return false;
            }
            if (c11 < '0' || c11 > '9') {
                return false;
            }
        }
        if (c12 < '0' || c12 > '5') {
            if (c12 != '6' || c13 != '0') {
                return false;
            }
        } else if (c13 < '0' || c13 > '9') {
            return false;
        }
        return (c14 < '0' || c14 > '5') ? c14 == '6' && c15 == '0' : c15 >= '0' && c15 <= '9';
    }

    public static final byte[] h(String str, int i10, int i11) {
        int i12;
        if (i11 == 0) {
            return new byte[0];
        }
        int i13 = (i10 + i11) - 1;
        int i14 = i10;
        while (i14 < i13 && f3279z[str.charAt(i14)] < 0) {
            i14++;
        }
        while (i13 > 0 && f3279z[str.charAt(i13)] < 0) {
            i13--;
        }
        int i15 = str.charAt(i13) == '=' ? str.charAt(i13 + (-1)) == '=' ? 2 : 1 : 0;
        int i16 = (i13 - i14) + 1;
        if (i11 > 76) {
            i12 = (str.charAt(76) == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = f3279z;
            int i21 = i14 + 4;
            int i22 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
            bArr[i19] = (byte) (i22 >> 16);
            int i23 = i19 + 2;
            bArr[i19 + 1] = (byte) (i22 >> 8);
            i19 += 3;
            bArr[i23] = (byte) i22;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i14 = i21;
            } else {
                i14 += 6;
                i20 = 0;
            }
        }
        if (i19 < i17) {
            int i24 = 0;
            int i25 = 0;
            while (i14 <= i13 - i15) {
                i24 |= f3279z[str.charAt(i14)] << (18 - (i25 * 6));
                i25++;
                i14++;
            }
            int i26 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i24 >> i26);
                i26 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String w(char[] r16, int r17) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.w(char[], int):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0226, code lost:
    
        r20 = r3;
        r19.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x022b, code lost:
    
        return r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00df, code lost:
    
        r19.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e1, code lost:
    
        return r20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final double[] A(long r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.A(long):double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0294, code lost:
    
        r21.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0297, code lost:
    
        return r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f0, code lost:
    
        r21.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f2, code lost:
    
        return r22;
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0137 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0146  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0134 -> B:88:0x0135). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final double[][] B(long r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.B(long):double[][]");
    }

    public final float C(long j10) throws NumberFormatException {
        int i10;
        char cB;
        int i11;
        float f10;
        float f11;
        int i12;
        char cB2;
        this.f3295p = 0;
        int iP = p(j10);
        if (iP == 0) {
            return 0.0f;
        }
        int i13 = iP + 1;
        char cB3 = b(this.f3284e + iP);
        int i14 = this.f3284e;
        int i15 = (i14 + i13) - 1;
        boolean z10 = cB3 == '-';
        if (z10) {
            cB3 = b(i14 + i13);
            i13 = iP + 2;
        }
        if (cB3 < '0' || cB3 > '9') {
            this.f3295p = -1;
            return 0.0f;
        }
        int i16 = cB3 - '0';
        while (true) {
            i10 = i13 + 1;
            cB = b(this.f3284e + i13);
            if (cB < '0' || cB > '9') {
                break;
            }
            i16 = (i16 * 10) + (cB - '0');
            i13 = i10;
        }
        if (cB == '.') {
            int i17 = i13 + 2;
            char cB4 = b(this.f3284e + i10);
            if (cB4 < '0' || cB4 > '9') {
                this.f3295p = -1;
                return 0.0f;
            }
            i16 = (i16 * 10) + (cB4 - '0');
            int i18 = 10;
            while (true) {
                i12 = i17 + 1;
                cB2 = b(this.f3284e + i17);
                if (cB2 < '0' || cB2 > '9') {
                    break;
                }
                i16 = (i16 * 10) + (cB2 - '0');
                i18 *= 10;
                i17 = i12;
            }
            int i19 = i18;
            cB = cB2;
            i11 = i19;
            i10 = i12;
        } else {
            i11 = 1;
        }
        boolean z11 = cB == 'e' || cB == 'E';
        if (z11) {
            int i20 = i10 + 1;
            cB = b(this.f3284e + i10);
            f10 = 0.0f;
            if (cB == '+' || cB == '-') {
                i10 += 2;
                cB = b(this.f3284e + i20);
            } else {
                i10 = i20;
            }
            while (cB >= '0' && cB <= '9') {
                cB = b(this.f3284e + i10);
                i10++;
            }
        } else {
            f10 = 0.0f;
        }
        int i21 = ((this.f3284e + i10) - i15) - 1;
        if (z11 || i21 >= 10) {
            f11 = Float.parseFloat(Y(i15, i21));
        } else {
            f11 = i16 / i11;
            if (z10) {
                f11 = -f11;
            }
        }
        if (cB == ',') {
            this.f3284e += i10 - 1;
            q();
            this.f3295p = 3;
            this.f3280a = 16;
            return f11;
        }
        if (cB != '}') {
            this.f3295p = -1;
            return f10;
        }
        char cB5 = b(this.f3284e + i10);
        if (cB5 == ',') {
            this.f3280a = 16;
            this.f3284e += i10;
            q();
        } else if (cB5 == ']') {
            this.f3280a = 15;
            this.f3284e += i10;
            q();
        } else if (cB5 == '}') {
            this.f3280a = 13;
            this.f3284e += i10;
            q();
        } else {
            if (cB5 != 26) {
                this.f3295p = -1;
                return f10;
            }
            this.f3284e += i10;
            this.f3280a = 20;
            this.f3283d = (char) 26;
        }
        this.f3295p = 4;
        return f11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0226, code lost:
    
        r20 = r3;
        r19.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x022b, code lost:
    
        return r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00df, code lost:
    
        r19.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e1, code lost:
    
        return r20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] D(long r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.D(long):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x0293, code lost:
    
        r21.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0296, code lost:
    
        return r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f1, code lost:
    
        r21.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f3, code lost:
    
        return r22;
     */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0138 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0147  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0135 -> B:89:0x0136). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[][] E(long r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.E(long):float[][]");
    }

    public int F(long j10) {
        boolean z10;
        int i10;
        char cCharAt;
        this.f3295p = 0;
        int iP = p(j10);
        if (iP == 0) {
            return 0;
        }
        int i11 = iP + 1;
        int i12 = this.f3284e + iP;
        char cCharAt2 = i12 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i12);
        if (cCharAt2 == '\"') {
            int i13 = iP + 2;
            int i14 = this.f3284e + i11;
            cCharAt2 = i14 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i14);
            i11 = i13;
            z10 = true;
        } else {
            z10 = false;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.f3295p = -1;
            return 0;
        }
        int i15 = cCharAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i16 = this.f3284e + i11;
            cCharAt = i16 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i16);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i15 = (i15 * 10) + (cCharAt - '0');
            i11 = i10;
        }
        if (cCharAt == '.') {
            this.f3295p = -1;
            return 0;
        }
        if (cCharAt == '\"') {
            if (!z10) {
                this.f3295p = -1;
                return 0;
            }
            int i17 = i11 + 2;
            int i18 = this.f3284e + i10;
            cCharAt = i18 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i18);
            i10 = i17;
        }
        if (i15 < 0) {
            this.f3295p = -1;
            return 0;
        }
        if (cCharAt == ',') {
            int i19 = this.f3284e + (i10 - 1) + 1;
            this.f3284e = i19;
            this.f3283d = i19 < this.f3297r ? this.f3296q.charAt(i19) : (char) 26;
            this.f3295p = 3;
            this.f3280a = 16;
            return i15;
        }
        if (cCharAt != '}') {
            this.f3295p = -1;
            return 0;
        }
        char cB = b(this.f3284e + i10);
        if (cB == ',') {
            this.f3280a = 16;
            int i20 = this.f3284e + i10 + 1;
            this.f3284e = i20;
            this.f3283d = i20 < this.f3297r ? this.f3296q.charAt(i20) : (char) 26;
        } else if (cB == ']') {
            this.f3280a = 15;
            int i21 = this.f3284e + i10 + 1;
            this.f3284e = i21;
            this.f3283d = i21 < this.f3297r ? this.f3296q.charAt(i21) : (char) 26;
        } else if (cB == '}') {
            this.f3280a = 13;
            int i22 = this.f3284e + i10 + 1;
            this.f3284e = i22;
            this.f3283d = i22 < this.f3297r ? this.f3296q.charAt(i22) : (char) 26;
        } else {
            if (cB != 26) {
                this.f3295p = -1;
                return 0;
            }
            this.f3280a = 20;
            this.f3284e += i10;
            this.f3283d = (char) 26;
        }
        this.f3295p = 4;
        return i15;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x015a, code lost:
    
        r18.f3295p = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x015d, code lost:
    
        return r19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] G(long r19) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.G(long):int[]");
    }

    public long H(long j10) {
        int i10;
        char cCharAt;
        boolean z10 = false;
        this.f3295p = 0;
        int iP = p(j10);
        if (iP == 0) {
            return 0L;
        }
        int i11 = iP + 1;
        int i12 = this.f3284e + iP;
        char cCharAt2 = i12 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i12);
        if (cCharAt2 == '\"') {
            int i13 = iP + 2;
            int i14 = this.f3284e + i11;
            cCharAt2 = i14 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i14);
            i11 = i13;
            z10 = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.f3295p = -1;
            return 0L;
        }
        long j11 = cCharAt2 - '0';
        while (true) {
            i10 = i11 + 1;
            int i15 = this.f3284e + i11;
            cCharAt = i15 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i15);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j11 = (j11 * 10) + (cCharAt - '0');
            i11 = i10;
        }
        if (cCharAt == '.') {
            this.f3295p = -1;
            return 0L;
        }
        if (cCharAt == '\"') {
            if (!z10) {
                this.f3295p = -1;
                return 0L;
            }
            int i16 = i11 + 2;
            int i17 = this.f3284e + i10;
            cCharAt = i17 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i17);
            i10 = i16;
        }
        if (j11 < 0) {
            this.f3295p = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i18 = this.f3284e + (i10 - 1) + 1;
            this.f3284e = i18;
            this.f3283d = i18 < this.f3297r ? this.f3296q.charAt(i18) : (char) 26;
            this.f3295p = 3;
            this.f3280a = 16;
            return j11;
        }
        if (cCharAt != '}') {
            this.f3295p = -1;
            return 0L;
        }
        char cB = b(this.f3284e + i10);
        if (cB == ',') {
            this.f3280a = 16;
            int i19 = this.f3284e + i10 + 1;
            this.f3284e = i19;
            this.f3283d = i19 < this.f3297r ? this.f3296q.charAt(i19) : (char) 26;
        } else if (cB == ']') {
            this.f3280a = 15;
            int i20 = this.f3284e + i10 + 1;
            this.f3284e = i20;
            this.f3283d = i20 < this.f3297r ? this.f3296q.charAt(i20) : (char) 26;
        } else if (cB == '}') {
            this.f3280a = 13;
            int i21 = this.f3284e + i10 + 1;
            this.f3284e = i21;
            this.f3283d = i21 < this.f3297r ? this.f3296q.charAt(i21) : (char) 26;
        } else {
            if (cB != 26) {
                this.f3295p = -1;
                return 0L;
            }
            this.f3280a = 20;
            this.f3284e += i10;
            this.f3283d = (char) 26;
        }
        this.f3295p = 4;
        return j11;
    }

    public String I(long j10) {
        String str;
        this.f3295p = 0;
        int iP = p(j10);
        if (iP == 0) {
            return null;
        }
        int i10 = iP + 1;
        int i11 = this.f3284e + iP;
        if (i11 >= this.f3297r) {
            throw new JSONException("unclosed str, " + i());
        }
        if (this.f3296q.charAt(i11) != '\"') {
            this.f3295p = -1;
            return this.f3298s;
        }
        int i12 = this.f3284e + i10;
        int iIndexOf = this.f3296q.indexOf(34, i12);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + i());
        }
        if (f3275v) {
            str = this.f3296q.substring(i12, iIndexOf);
        } else {
            int i13 = iIndexOf - i12;
            str = new String(Z(this.f3284e + i10, i13), 0, i13);
        }
        if (str.indexOf(92) != -1) {
            boolean z10 = false;
            while (true) {
                int i14 = iIndexOf - 1;
                int i15 = 0;
                while (i14 >= 0 && this.f3296q.charAt(i14) == '\\') {
                    i15++;
                    i14--;
                    z10 = true;
                }
                if (i15 % 2 == 0) {
                    break;
                }
                iIndexOf = this.f3296q.indexOf(34, iIndexOf + 1);
            }
            int i16 = iIndexOf - i12;
            char[] cArrZ = Z(this.f3284e + i10, i16);
            if (z10) {
                str = w(cArrZ, i16);
            } else {
                str = new String(cArrZ, 0, i16);
                if (str.indexOf(92) != -1) {
                    str = w(cArrZ, i16);
                }
            }
        }
        int i17 = iIndexOf + 1;
        char cCharAt = i17 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i17);
        if (cCharAt == ',') {
            int i18 = iIndexOf + 2;
            this.f3284e = i18;
            this.f3283d = i18 < this.f3297r ? this.f3296q.charAt(i18) : (char) 26;
            this.f3295p = 3;
            this.f3280a = 16;
            return str;
        }
        if (cCharAt != '}') {
            this.f3295p = -1;
            return this.f3298s;
        }
        int i19 = iIndexOf + 2;
        char cCharAt2 = i19 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i19);
        if (cCharAt2 == ',') {
            this.f3280a = 16;
            this.f3284e = i19;
            q();
        } else if (cCharAt2 == ']') {
            this.f3280a = 15;
            this.f3284e = i19;
            q();
        } else if (cCharAt2 == '}') {
            this.f3280a = 13;
            this.f3284e = i19;
            q();
        } else {
            if (cCharAt2 != 26) {
                this.f3295p = -1;
                return this.f3298s;
            }
            this.f3280a = 20;
            this.f3284e = i19;
            this.f3283d = (char) 26;
        }
        this.f3295p = 4;
        return str;
    }

    public long J(long j10) {
        this.f3295p = 0;
        int iP = p(j10);
        if (iP == 0) {
            return 0L;
        }
        int i10 = iP + 1;
        int i11 = this.f3284e + iP;
        if ((i11 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i11)) != '\"') {
            this.f3295p = -1;
            return 0L;
        }
        long j11 = -2128831035;
        while (true) {
            int i12 = i10 + 1;
            int i13 = this.f3284e + i10;
            char cCharAt = i13 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i13);
            if (cCharAt == '\"') {
                int i14 = i10 + 2;
                int i15 = this.f3284e + i12;
                char cCharAt2 = i15 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i15);
                if (cCharAt2 == ',') {
                    int i16 = this.f3284e + i10 + 1 + 1;
                    this.f3284e = i16;
                    this.f3283d = i16 < this.f3297r ? this.f3296q.charAt(i16) : (char) 26;
                    this.f3295p = 3;
                    return j11;
                }
                if (cCharAt2 != '}') {
                    this.f3295p = -1;
                    return 0L;
                }
                int i17 = this.f3284e + i14;
                char cCharAt3 = i17 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i17);
                if (cCharAt3 == ',') {
                    this.f3280a = 16;
                    this.f3284e += i10 + 2;
                    q();
                } else if (cCharAt3 == ']') {
                    this.f3280a = 15;
                    this.f3284e += i10 + 2;
                    q();
                } else if (cCharAt3 == '}') {
                    this.f3280a = 13;
                    this.f3284e += i10 + 2;
                    q();
                } else {
                    if (cCharAt3 != 26) {
                        this.f3295p = -1;
                        return 0L;
                    }
                    this.f3280a = 20;
                    this.f3284e += i10 + 2;
                    this.f3283d = (char) 26;
                }
                this.f3295p = 4;
                return j11;
            }
            j11 = (j11 ^ cCharAt) * 16777619;
            if (cCharAt == '\\') {
                this.f3295p = -1;
                return 0L;
            }
            i10 = i12;
        }
    }

    public boolean K(boolean z10) throws NumberFormatException {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        char cB;
        int i15;
        char cB2;
        int i16;
        int i17;
        char cB3;
        char cB4;
        int i18 = this.f3297r;
        int i19 = this.f3284e;
        int i20 = i18 - i19;
        if (!z10 && i20 > 13 && this.f3296q.startsWith("/Date(", i19) && b((this.f3284e + i20) - 1) == '/' && b((this.f3284e + i20) - 2) == ')') {
            int i21 = -1;
            for (int i22 = 6; i22 < i20; i22++) {
                char cB5 = b(this.f3284e + i22);
                if (cB5 != '+') {
                    if (cB5 < '0' || cB5 > '9') {
                        break;
                    }
                } else {
                    i21 = i22;
                }
            }
            if (i21 == -1) {
                return false;
            }
            int i23 = this.f3284e + 6;
            long j10 = Long.parseLong(Y(i23, i21 - i23), 10);
            Calendar calendar = Calendar.getInstance(this.f3292m, this.f3293n);
            this.f3294o = calendar;
            calendar.setTimeInMillis(j10);
            this.f3280a = 5;
            return true;
        }
        if (i20 == 8 || i20 == 14 || i20 == 17) {
            if (z10) {
                return false;
            }
            char cB6 = b(this.f3284e);
            char cB7 = b(this.f3284e + 1);
            char cB8 = b(this.f3284e + 2);
            char cB9 = b(this.f3284e + 3);
            char cB10 = b(this.f3284e + 4);
            char cB11 = b(this.f3284e + 5);
            char cB12 = b(this.f3284e + 6);
            char cB13 = b(this.f3284e + 7);
            if (!c(cB6, cB7, cB8, cB9, cB10, cB11, cB12, cB13)) {
                return false;
            }
            U(cB6, cB7, cB8, cB9, cB10, cB11, cB12, cB13);
            if (i20 != 8) {
                char cB14 = b(this.f3284e + 8);
                char cB15 = b(this.f3284e + 9);
                char cB16 = b(this.f3284e + 10);
                char cB17 = b(this.f3284e + 11);
                char cB18 = b(this.f3284e + 12);
                char cB19 = b(this.f3284e + 13);
                if (!d(cB14, cB15, cB16, cB17, cB18, cB19)) {
                    return false;
                }
                if (i20 == 17) {
                    char cB20 = b(this.f3284e + 14);
                    char cB21 = b(this.f3284e + 15);
                    char cB22 = b(this.f3284e + 16);
                    if (cB20 < '0' || cB20 > '9' || cB21 < '0' || cB21 > '9' || cB22 < '0' || cB22 > '9') {
                        return false;
                    }
                    i14 = ((cB20 - '0') * 100) + ((cB21 - '0') * 10) + (cB22 - '0');
                } else {
                    i14 = 0;
                }
                int i24 = ((cB14 - '0') * 10) + (cB15 - '0');
                i12 = ((cB18 - '0') * 10) + (cB19 - '0');
                i11 = i14;
                i10 = ((cB16 - '0') * 10) + (cB17 - '0');
                i13 = i24;
            } else {
                i10 = 0;
                i11 = 0;
                i12 = 0;
                i13 = 0;
            }
            this.f3294o.set(11, i13);
            this.f3294o.set(12, i10);
            this.f3294o.set(13, i12);
            this.f3294o.set(14, i11);
            this.f3280a = 5;
            return true;
        }
        if (i20 < 10 || b(this.f3284e + 4) != '-' || b(this.f3284e + 7) != '-') {
            return false;
        }
        char cB23 = b(this.f3284e);
        char cB24 = b(this.f3284e + 1);
        char cB25 = b(this.f3284e + 2);
        char cB26 = b(this.f3284e + 3);
        char cB27 = b(this.f3284e + 5);
        char cB28 = b(this.f3284e + 6);
        char cB29 = b(this.f3284e + 8);
        char cB30 = b(this.f3284e + 9);
        if (!c(cB23, cB24, cB25, cB26, cB27, cB28, cB29, cB30)) {
            return false;
        }
        U(cB23, cB24, cB25, cB26, cB27, cB28, cB29, cB30);
        char cB31 = b(this.f3284e + 10);
        if (cB31 != 'T' && (cB31 != ' ' || z10)) {
            if (cB31 != '\"' && cB31 != 26) {
                return false;
            }
            this.f3294o.set(11, 0);
            this.f3294o.set(12, 0);
            this.f3294o.set(13, 0);
            this.f3294o.set(14, 0);
            int i25 = this.f3284e + 10;
            this.f3284e = i25;
            this.f3283d = b(i25);
            this.f3280a = 5;
            return true;
        }
        if (i20 < 19 || b(this.f3284e + 13) != ':' || b(this.f3284e + 16) != ':') {
            return false;
        }
        char cB32 = b(this.f3284e + 11);
        char cB33 = b(this.f3284e + 12);
        char cB34 = b(this.f3284e + 14);
        char cB35 = b(this.f3284e + 15);
        char cB36 = b(this.f3284e + 17);
        char cB37 = b(this.f3284e + 18);
        if (!d(cB32, cB33, cB34, cB35, cB36, cB37)) {
            return false;
        }
        this.f3294o.set(11, ((cB32 - '0') * 10) + (cB33 - '0'));
        this.f3294o.set(12, ((cB34 - '0') * 10) + (cB35 - '0'));
        this.f3294o.set(13, ((cB36 - '0') * 10) + (cB37 - '0'));
        char cB38 = b(this.f3284e + 19);
        if (cB38 != '.') {
            this.f3294o.set(14, 0);
            int i26 = this.f3284e + 19;
            this.f3284e = i26;
            this.f3283d = b(i26);
            this.f3280a = 5;
            if (cB38 == 'Z' && this.f3294o.getTimeZone().getRawOffset() != 0) {
                String[] availableIDs = TimeZone.getAvailableIDs(0);
                if (availableIDs.length > 0) {
                    this.f3294o.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                }
            }
            return true;
        }
        if (i20 >= 21 && (cB = b(this.f3284e + 20)) >= '0' && cB <= '9') {
            int[] iArr = f3277x;
            int i27 = iArr[cB];
            if (i20 <= 21 || (cB4 = b(this.f3284e + 21)) < '0' || cB4 > '9') {
                i15 = 1;
            } else {
                i27 = (i27 * 10) + iArr[cB4];
                i15 = 2;
            }
            if (i15 == 2 && (cB3 = b(this.f3284e + 22)) >= '0' && cB3 <= '9') {
                i27 = (i27 * 10) + iArr[cB3];
                i15 = 3;
            }
            this.f3294o.set(14, i27);
            char cB39 = b(this.f3284e + 20 + i15);
            if (cB39 == '+' || cB39 == '-') {
                char cB40 = b(this.f3284e + 20 + i15 + 1);
                if (cB40 >= '0' && cB40 <= '1' && (cB2 = b(this.f3284e + 20 + i15 + 2)) >= '0' && cB2 <= '9') {
                    char cB41 = b(this.f3284e + 20 + i15 + 3);
                    if (cB41 == ':') {
                        if (b(this.f3284e + 20 + i15 + 4) != '0' || b(this.f3284e + 20 + i15 + 5) != '0') {
                            return false;
                        }
                        i16 = 6;
                    } else if (cB41 != '0') {
                        i16 = 3;
                    } else {
                        if (b(this.f3284e + 20 + i15 + 4) != '0') {
                            return false;
                        }
                        i16 = 5;
                    }
                    int i28 = ((iArr[cB40] * 10) + iArr[cB2]) * 3600000;
                    if (cB39 == '-') {
                        i28 = -i28;
                    }
                    if (this.f3294o.getTimeZone().getRawOffset() != i28) {
                        String[] availableIDs2 = TimeZone.getAvailableIDs(i28);
                        if (availableIDs2.length > 0) {
                            this.f3294o.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                        }
                    }
                    i17 = i16;
                }
            } else if (cB39 == 'Z') {
                if (this.f3294o.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs3 = TimeZone.getAvailableIDs(0);
                    if (availableIDs3.length > 0) {
                        this.f3294o.setTimeZone(TimeZone.getTimeZone(availableIDs3[0]));
                    }
                }
                i17 = 1;
            } else {
                i17 = 0;
            }
            int i29 = i15 + 20 + i17;
            char cB42 = b(this.f3284e + i29);
            if (cB42 != 26 && cB42 != '\"') {
                return false;
            }
            int i30 = this.f3284e + i29;
            this.f3284e = i30;
            this.f3283d = b(i30);
            this.f3280a = 5;
            return true;
        }
        return false;
    }

    public final void L() {
        this.f3290k = this.f3284e - 1;
        this.f3291l = false;
        do {
            this.f3287h++;
            q();
        } while (Character.isLetterOrDigit(this.f3283d));
        String strX = X();
        if (strX.equals("null")) {
            this.f3280a = 8;
            return;
        }
        if (strX.equals("true")) {
            this.f3280a = 6;
            return;
        }
        if (strX.equals("false")) {
            this.f3280a = 7;
            return;
        }
        if (strX.equals(Const.STR_NEW)) {
            this.f3280a = 9;
            return;
        }
        if (strX.equals("undefined")) {
            this.f3280a = 23;
            return;
        }
        if (strX.equals("Set")) {
            this.f3280a = 21;
        } else if (strX.equals("TreeSet")) {
            this.f3280a = 22;
        } else {
            this.f3280a = 18;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        if (r0 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c3, code lost:
    
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c4, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long M() {
        /*
            r12 = this;
            r0 = 0
            r12.f3290k = r0
            char r1 = r12.f3283d
            r2 = 45
            r3 = 1
            if (r1 != r2) goto L3d
            r12.f3290k = r3
            int r0 = r12.f3284e
            int r0 = r0 + r3
            r12.f3284e = r0
            int r1 = r12.f3297r
            if (r0 >= r1) goto L22
            java.lang.String r1 = r12.f3296q
            char r0 = r1.charAt(r0)
            r12.f3283d = r0
            r0 = -9223372036854775808
            r1 = r0
            r0 = r3
            goto L42
        L22:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, "
            r1.append(r2)
            java.lang.String r12 = r12.i()
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        L3d:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L42:
            r4 = 0
        L44:
            char r6 = r12.f3283d
            r7 = 48
            if (r6 < r7) goto Lc0
            r7 = 57
            if (r6 > r7) goto Lc0
            int r6 = r6 + (-48)
            r7 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            java.lang.String r8 = ", "
            java.lang.String r9 = "error long value, "
            if (r7 < 0) goto La1
            r10 = 10
            long r4 = r4 * r10
            long r6 = (long) r6
            long r10 = r1 + r6
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 < 0) goto L82
            long r4 = r4 - r6
            int r6 = r12.f3290k
            int r6 = r6 + r3
            r12.f3290k = r6
            int r6 = r12.f3284e
            int r6 = r6 + r3
            r12.f3284e = r6
            int r7 = r12.f3297r
            if (r6 < r7) goto L79
            r6 = 26
            goto L7f
        L79:
            java.lang.String r7 = r12.f3296q
            char r6 = r7.charAt(r6)
        L7f:
            r12.f3283d = r6
            goto L44
        L82:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r4)
            r1.append(r8)
            java.lang.String r12 = r12.i()
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        La1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r4)
            r1.append(r8)
            java.lang.String r12 = r12.i()
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        Lc0:
            if (r0 != 0) goto Lc4
            long r0 = -r4
            return r0
        Lc4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.M():long");
    }

    public final void N() {
        char c10;
        char c11;
        int i10 = this.f3284e;
        this.f3290k = i10;
        this.f3288i = false;
        if (this.f3283d == '-') {
            this.f3287h++;
            int i11 = i10 + 1;
            this.f3284e = i11;
            this.f3283d = i11 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i11);
        }
        while (true) {
            c10 = this.f3283d;
            if (c10 < '0' || c10 > '9') {
                break;
            }
            this.f3287h++;
            int i12 = this.f3284e + 1;
            this.f3284e = i12;
            this.f3283d = i12 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i12);
        }
        this.f3289j = false;
        if (c10 == '.') {
            this.f3287h++;
            int i13 = this.f3284e + 1;
            this.f3284e = i13;
            this.f3283d = i13 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i13);
            this.f3289j = true;
            while (true) {
                char c12 = this.f3283d;
                if (c12 < '0' || c12 > '9') {
                    break;
                }
                this.f3287h++;
                int i14 = this.f3284e + 1;
                this.f3284e = i14;
                this.f3283d = i14 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i14);
            }
        }
        char c13 = this.f3283d;
        if (c13 == 'L' || c13 == 'S' || c13 == 'B') {
            this.f3287h++;
            q();
        } else if (c13 == 'F' || c13 == 'D') {
            this.f3287h++;
            q();
            this.f3289j = true;
        } else if (c13 == 'e' || c13 == 'E') {
            this.f3287h++;
            int i15 = this.f3284e + 1;
            this.f3284e = i15;
            char cCharAt = i15 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i15);
            this.f3283d = cCharAt;
            if (cCharAt == '+' || cCharAt == '-') {
                this.f3287h++;
                int i16 = this.f3284e + 1;
                this.f3284e = i16;
                this.f3283d = i16 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i16);
            }
            while (true) {
                c11 = this.f3283d;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                this.f3287h++;
                int i17 = this.f3284e + 1;
                this.f3284e = i17;
                this.f3283d = i17 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i17);
            }
            if (c11 == 'D' || c11 == 'F') {
                this.f3287h++;
                q();
            }
            this.f3288i = true;
            this.f3289j = true;
        }
        if (this.f3289j) {
            this.f3280a = 3;
        } else {
            this.f3280a = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0251 A[Catch: NumberFormatException -> 0x022f, TryCatch #0 {NumberFormatException -> 0x022f, blocks: (B:120:0x0208, B:126:0x0215, B:128:0x021a, B:134:0x022c, B:131:0x0223, B:133:0x022a, B:138:0x0233, B:141:0x0239, B:143:0x023e, B:146:0x0244, B:125:0x0212, B:148:0x0249, B:150:0x0251, B:152:0x0256), top: B:156:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0256 A[Catch: NumberFormatException -> 0x022f, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x022f, blocks: (B:120:0x0208, B:126:0x0215, B:128:0x021a, B:134:0x022c, B:131:0x0223, B:133:0x022a, B:138:0x0233, B:141:0x0239, B:143:0x023e, B:146:0x0244, B:125:0x0212, B:148:0x0249, B:150:0x0251, B:152:0x0256), top: B:156:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Number O() {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.O():java.lang.Number");
    }

    public final void P() {
        char c10 = this.f3283d;
        int i10 = this.f3284e + 1;
        int iIndexOf = this.f3296q.indexOf(c10, i10);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + i());
        }
        int i11 = iIndexOf - i10;
        char[] cArrZ = Z(this.f3284e + 1, i11);
        boolean z10 = false;
        while (i11 > 0 && cArrZ[i11 - 1] == '\\') {
            int i12 = 1;
            for (int i13 = i11 - 2; i13 >= 0 && cArrZ[i13] == '\\'; i13--) {
                i12++;
            }
            if (i12 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.f3296q.indexOf(c10, iIndexOf + 1);
            int i14 = (iIndexOf2 - iIndexOf) + i11;
            if (i14 >= cArrZ.length) {
                int length = (cArrZ.length * 3) / 2;
                if (length < i14) {
                    length = i14;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrZ, 0, cArr, 0, cArrZ.length);
                cArrZ = cArr;
            }
            this.f3296q.getChars(iIndexOf, iIndexOf2, cArrZ, i11);
            iIndexOf = iIndexOf2;
            i11 = i14;
            z10 = true;
        }
        if (!z10) {
            for (int i15 = 0; i15 < i11; i15++) {
                if (cArrZ[i15] == '\\') {
                    z10 = true;
                }
            }
        }
        this.f3286g = cArrZ;
        this.f3287h = i11;
        this.f3290k = this.f3284e;
        this.f3291l = z10;
        int i16 = iIndexOf + 1;
        this.f3284e = i16;
        this.f3283d = i16 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i16);
        this.f3280a = 4;
    }

    public String Q(char c10) {
        String str;
        int i10 = this.f3284e + 1;
        int iIndexOf = this.f3296q.indexOf(c10, i10);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + i());
        }
        if (f3275v) {
            str = this.f3296q.substring(i10, iIndexOf);
        } else {
            int i11 = iIndexOf - i10;
            str = new String(Z(this.f3284e + 1, i11), 0, i11);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i12 = 0;
                for (int i13 = iIndexOf - 1; i13 >= 0 && this.f3296q.charAt(i13) == '\\'; i13--) {
                    i12++;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                iIndexOf = this.f3296q.indexOf(c10, iIndexOf + 1);
            }
            int i14 = iIndexOf - i10;
            str = w(Z(this.f3284e + 1, i14), i14);
        }
        int i15 = iIndexOf + 1;
        this.f3284e = i15;
        this.f3283d = i15 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i15);
        return str;
    }

    public final String R(n nVar) {
        char c10;
        while (true) {
            c10 = this.f3283d;
            if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f' && c10 != '\b') {
                break;
            }
            q();
        }
        if (c10 == '\"') {
            return S(nVar, JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        if (c10 == '\'') {
            return S(nVar, '\'');
        }
        if (c10 == '}') {
            q();
            this.f3280a = 13;
            return null;
        }
        if (c10 == ',') {
            q();
            this.f3280a = 16;
            return null;
        }
        if (c10 != 26) {
            return T(nVar);
        }
        this.f3280a = 20;
        return null;
    }

    public String S(n nVar, char c10) {
        String strW;
        int i10 = this.f3284e + 1;
        int iIndexOf = this.f3296q.indexOf(c10, i10);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + i());
        }
        int i11 = iIndexOf - i10;
        char[] cArrZ = Z(this.f3284e + 1, i11);
        boolean z10 = false;
        while (i11 > 0 && cArrZ[i11 - 1] == '\\') {
            int i12 = 1;
            for (int i13 = i11 - 2; i13 >= 0 && cArrZ[i13] == '\\'; i13--) {
                i12++;
            }
            if (i12 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.f3296q.indexOf(c10, iIndexOf + 1);
            int i14 = (iIndexOf2 - iIndexOf) + i11;
            if (i14 >= cArrZ.length) {
                int length = (cArrZ.length * 3) / 2;
                if (length < i14) {
                    length = i14;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrZ, 0, cArr, 0, cArrZ.length);
                cArrZ = cArr;
            }
            this.f3296q.getChars(iIndexOf, iIndexOf2, cArrZ, i11);
            iIndexOf = iIndexOf2;
            i11 = i14;
            z10 = true;
        }
        if (z10) {
            strW = w(cArrZ, i11);
        } else {
            int i15 = 0;
            for (int i16 = 0; i16 < i11; i16++) {
                char c11 = cArrZ[i16];
                i15 = (i15 * 31) + c11;
                if (c11 == '\\') {
                    z10 = true;
                }
            }
            strW = z10 ? w(cArrZ, i11) : i11 < 20 ? nVar.b(cArrZ, 0, i11, i15) : new String(cArrZ, 0, i11);
        }
        int i17 = iIndexOf + 1;
        this.f3284e = i17;
        this.f3283d = i17 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i17);
        return strW;
    }

    public final String T(n nVar) {
        int i10 = this.f3283d;
        boolean[] zArr = f3273A;
        if (i10 < zArr.length && !zArr[i10]) {
            throw new JSONException("illegal identifier : " + this.f3283d + ", " + i());
        }
        this.f3290k = this.f3284e;
        this.f3287h = 1;
        while (true) {
            char cQ = q();
            boolean[] zArr2 = f3274B;
            if (cQ < zArr2.length && !zArr2[cQ]) {
                break;
            }
            i10 = (i10 * 31) + cQ;
            this.f3287h++;
        }
        this.f3283d = b(this.f3284e);
        this.f3280a = 18;
        if (this.f3287h == 4 && this.f3296q.startsWith("null", this.f3290k)) {
            return null;
        }
        return nVar.a(this.f3296q, this.f3290k, this.f3287h, i10);
    }

    public final void U(char c10, char c11, char c12, char c13, char c14, char c15, char c16, char c17) {
        Calendar calendar = Calendar.getInstance(this.f3292m, this.f3293n);
        this.f3294o = calendar;
        calendar.set(1, ((c10 - '0') * 1000) + ((c11 - '0') * 100) + ((c12 - '0') * 10) + (c13 - '0'));
        this.f3294o.set(2, (((c14 - '0') * 10) + (c15 - '0')) - 1);
        this.f3294o.set(5, ((c16 - '0') * 10) + (c17 - '0'));
    }

    public void V() {
        q();
        char c10 = this.f3283d;
        if (c10 == '/') {
            do {
                q();
            } while (this.f3283d != '\n');
            q();
        } else {
            if (c10 != '*') {
                throw new JSONException("invalid comment");
            }
            q();
            while (true) {
                char c11 = this.f3283d;
                if (c11 == 26) {
                    return;
                }
                if (c11 == '*') {
                    q();
                    if (this.f3283d == '/') {
                        q();
                        return;
                    }
                } else {
                    q();
                }
            }
        }
    }

    public final void W() {
        while (true) {
            char c10 = this.f3283d;
            if (c10 > '/') {
                return;
            }
            if (c10 == ' ' || c10 == '\r' || c10 == '\n' || c10 == '\t' || c10 == '\f' || c10 == '\b') {
                q();
            } else if (c10 != '/') {
                return;
            } else {
                V();
            }
        }
    }

    public final String X() {
        return this.f3291l ? w(this.f3286g, this.f3287h) : Y(this.f3290k + 1, this.f3287h);
    }

    public final String Y(int i10, int i11) {
        char[] cArr = this.f3286g;
        if (i11 < cArr.length) {
            this.f3296q.getChars(i10, i10 + i11, cArr, 0);
            return new String(this.f3286g, 0, i11);
        }
        char[] cArr2 = new char[i11];
        this.f3296q.getChars(i10, i11 + i10, cArr2, 0);
        return new String(cArr2);
    }

    public final char[] Z(int i10, int i11) {
        char[] cArr = this.f3286g;
        if (i11 < cArr.length) {
            this.f3296q.getChars(i10, i11 + i10, cArr, 0);
            return this.f3286g;
        }
        char[] cArr2 = new char[i11];
        this.f3286g = cArr2;
        this.f3296q.getChars(i10, i11 + i10, cArr2, 0);
        return cArr2;
    }

    public byte[] a() {
        return h(this.f3296q, this.f3290k + 1, this.f3287h);
    }

    public final int a0() {
        return this.f3280a;
    }

    public char b(int i10) {
        if (i10 >= this.f3297r) {
            return (char) 26;
        }
        return this.f3296q.charAt(i10);
    }

    public void e() {
        char[] cArr = this.f3286g;
        if (cArr.length <= 8196) {
            f3276w.set(cArr);
        }
        this.f3286g = null;
    }

    public final Number f(boolean z10) {
        char[] cArr;
        boolean z11;
        int i10 = (this.f3290k + this.f3287h) - 1;
        char cCharAt = i10 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i10);
        try {
            if (cCharAt == 'F') {
                return Float.valueOf(Float.parseFloat(v()));
            }
            if (cCharAt == 'D') {
                return Double.valueOf(Double.parseDouble(v()));
            }
            if (z10) {
                return g();
            }
            char cCharAt2 = this.f3296q.charAt((this.f3290k + this.f3287h) - 1);
            int i11 = this.f3287h;
            if (cCharAt2 == 'L' || cCharAt2 == 'S' || cCharAt2 == 'B' || cCharAt2 == 'F' || cCharAt2 == 'D') {
                i11--;
            }
            int i12 = this.f3290k;
            char[] cArr2 = this.f3286g;
            int i13 = 0;
            if (i11 < cArr2.length) {
                this.f3296q.getChars(i12, i12 + i11, cArr2, 0);
                cArr = this.f3286g;
            } else {
                char[] cArr3 = new char[i11];
                this.f3296q.getChars(i12, i12 + i11, cArr3, 0);
                cArr = cArr3;
            }
            if (i11 > 9 || this.f3288i) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i11)));
            }
            char c10 = cArr[0];
            int i14 = 2;
            if (c10 == '-') {
                c10 = cArr[1];
                z11 = true;
            } else {
                if (c10 == '+') {
                    c10 = cArr[1];
                } else {
                    i14 = 1;
                }
                z11 = false;
            }
            int i15 = c10 - '0';
            while (i14 < i11) {
                char c11 = cArr[i14];
                if (c11 == '.') {
                    i13 = 1;
                } else {
                    i15 = (i15 * 10) + (c11 - '0');
                    if (i13 != 0) {
                        i13 *= 10;
                    }
                }
                i14++;
            }
            double d10 = i15 / i13;
            if (z11) {
                d10 = -d10;
            }
            return Double.valueOf(d10);
        } catch (NumberFormatException e10) {
            throw new JSONException(e10.getMessage() + ", " + i());
        }
    }

    public final BigDecimal g() {
        char cCharAt = this.f3296q.charAt((this.f3290k + this.f3287h) - 1);
        int i10 = this.f3287h;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i10--;
        }
        int i11 = this.f3290k;
        char[] cArr = this.f3286g;
        if (i10 < cArr.length) {
            this.f3296q.getChars(i11, i11 + i10, cArr, 0);
            return new BigDecimal(this.f3286g, 0, i10);
        }
        char[] cArr2 = new char[i10];
        this.f3296q.getChars(i11, i10 + i11, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    public String i() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pos ");
        sb2.append(this.f3284e);
        sb2.append(", json : ");
        int i10 = this.f3297r;
        String strSubstring = this.f3296q;
        if (i10 >= 65536) {
            strSubstring = strSubstring.substring(0, 65536);
        }
        sb2.append(strSubstring);
        return sb2.toString();
    }

    public final int j() {
        int i10;
        boolean z10;
        int i11 = this.f3290k;
        int i12 = this.f3287h + i11;
        int i13 = 0;
        if ((i11 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i11)) == '-') {
            i11++;
            i10 = Integer.MIN_VALUE;
            z10 = true;
        } else {
            i10 = -2147483647;
            z10 = false;
        }
        if (i11 < i12) {
            i13 = -((i11 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i11)) - '0');
            i11++;
        }
        while (i11 < i12) {
            int i14 = i11 + 1;
            char cCharAt = i11 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i11);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i11 = i14;
                break;
            }
            int i15 = cCharAt - '0';
            if (i13 < -214748364) {
                throw new NumberFormatException(v());
            }
            int i16 = i13 * 10;
            if (i16 < i10 + i15) {
                throw new NumberFormatException(v());
            }
            i13 = i16 - i15;
            i11 = i14;
        }
        if (!z10) {
            return -i13;
        }
        if (i11 > this.f3290k + 1) {
            return i13;
        }
        throw new NumberFormatException(v());
    }

    public final Number k() throws NumberFormatException {
        char c10;
        boolean z10;
        long j10;
        long j11;
        int i10 = this.f3290k;
        int i11 = this.f3287h + i10;
        int i12 = i11 - 1;
        char cCharAt = i12 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i12);
        if (cCharAt == 'B') {
            i11--;
            c10 = 'B';
        } else if (cCharAt == 'L') {
            i11--;
            c10 = 'L';
        } else if (cCharAt != 'S') {
            c10 = ' ';
        } else {
            i11--;
            c10 = 'S';
        }
        int i13 = this.f3290k;
        if ((i13 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i13)) == '-') {
            i10++;
            j10 = Long.MIN_VALUE;
            z10 = true;
        } else {
            z10 = false;
            j10 = -9223372036854775807L;
        }
        if (i10 < i11) {
            j11 = -((i10 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i10)) - '0');
            i10++;
        } else {
            j11 = 0;
        }
        while (i10 < i11) {
            int i14 = i10 + 1;
            int iCharAt = (i10 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i10)) - '0';
            if (j11 < -922337203685477580L) {
                return new BigInteger(v());
            }
            long j12 = j11 * 10;
            long j13 = j10;
            long j14 = iCharAt;
            if (j12 < j13 + j14) {
                return new BigInteger(v());
            }
            j11 = j12 - j14;
            i10 = i14;
            j10 = j13;
        }
        if (!z10) {
            long j15 = -j11;
            return (j15 > 2147483647L || c10 == 'L') ? Long.valueOf(j15) : c10 == 'S' ? Short.valueOf((short) j15) : c10 == 'B' ? Byte.valueOf((byte) j15) : Integer.valueOf((int) j15);
        }
        if (i10 > this.f3290k + 1) {
            return (j11 < -2147483648L || c10 == 'L') ? Long.valueOf(j11) : c10 == 'S' ? Short.valueOf((short) j11) : c10 == 'B' ? Byte.valueOf((byte) j11) : Integer.valueOf((int) j11);
        }
        throw new NumberFormatException(v());
    }

    public final boolean l() {
        int i10 = 0;
        while (true) {
            char cB = b(i10);
            if (cB == 26) {
                return true;
            }
            if (cB > ' ' || !(cB == ' ' || cB == '\n' || cB == '\r' || cB == '\t' || cB == '\f' || cB == '\b')) {
                break;
            }
            i10++;
        }
        return false;
    }

    public final boolean m(Feature feature) {
        return (this.f3282c & feature.mask) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:8:0x0027). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long n() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.f3290k
            int r1 = r13.f3287h
            int r1 = r1 + r0
            char r2 = r13.b(r0)
            r3 = 45
            r4 = 1
            if (r2 != r3) goto L15
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r5 = r2
            r2 = r4
            goto L1b
        L15:
            r2 = 0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L1b:
            if (r0 >= r1) goto L29
            int r3 = r0 + 1
            char r0 = r13.b(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L27:
            r0 = r3
            goto L2b
        L29:
            r7 = 0
        L2b:
            if (r0 >= r1) goto L75
            int r3 = r0 + 1
            int r9 = r13.f3297r
            if (r0 < r9) goto L36
            r0 = 26
            goto L3c
        L36:
            java.lang.String r9 = r13.f3296q
            char r0 = r9.charAt(r0)
        L3c:
            r9 = 76
            if (r0 == r9) goto L74
            r9 = 83
            if (r0 == r9) goto L74
            r9 = 66
            if (r0 != r9) goto L49
            goto L74
        L49:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L6a
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r5 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L60
            long r7 = r7 - r9
            goto L27
        L60:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.v()
            r0.<init>(r13)
            throw r0
        L6a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.v()
            r0.<init>(r13)
            throw r0
        L74:
            r0 = r3
        L75:
            if (r2 == 0) goto L87
            int r1 = r13.f3290k
            int r1 = r1 + r4
            if (r0 <= r1) goto L7d
            return r7
        L7d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.v()
            r0.<init>(r13)
            throw r0
        L87:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.n():long");
    }

    public boolean o(long j10) {
        int i10;
        char cCharAt = this.f3283d;
        boolean z10 = true;
        int i11 = this.f3284e + 1;
        int i12 = 1;
        while (cCharAt != '\"' && cCharAt != '\'') {
            boolean z11 = z10;
            int i13 = i12;
            if (cCharAt > ' ' || !(cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\f' || cCharAt == '\b')) {
                this.f3300u = 0L;
                this.f3295p = -2;
                return false;
            }
            i12 = i13 + 1;
            int i14 = this.f3284e + i13;
            cCharAt = i14 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i14);
            z10 = z11;
        }
        int i15 = i12;
        int i16 = i11;
        boolean z12 = z10;
        long j11 = -2128831035;
        while (true) {
            if (i16 >= this.f3297r) {
                i10 = i15;
                break;
            }
            char cCharAt2 = this.f3296q.charAt(i16);
            if (cCharAt2 == cCharAt) {
                i10 = i15 + (i16 - i11) + 1;
                break;
            }
            j11 = (j11 ^ cCharAt2) * 16777619;
            i16++;
        }
        if (j11 != j10) {
            this.f3295p = -2;
            this.f3300u = j11;
            return false;
        }
        int i17 = i10 + 1;
        int i18 = this.f3284e + i10;
        char cCharAt3 = i18 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i18);
        while (cCharAt3 != ':') {
            if (cCharAt3 > ' ' || !(cCharAt3 == ' ' || cCharAt3 == '\n' || cCharAt3 == '\r' || cCharAt3 == '\t' || cCharAt3 == '\f' || cCharAt3 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i19 = i17 + 1;
            int i20 = this.f3284e + i17;
            cCharAt3 = i20 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i20);
            i17 = i19;
        }
        int i21 = this.f3284e + i17;
        char cCharAt4 = i21 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i21);
        if (cCharAt4 == '{') {
            int i22 = i21 + 1;
            this.f3284e = i22;
            this.f3283d = i22 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i22);
            this.f3280a = 12;
        } else if (cCharAt4 == '[') {
            int i23 = i21 + 1;
            this.f3284e = i23;
            this.f3283d = i23 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i23);
            this.f3280a = 14;
        } else {
            this.f3284e = i21;
            this.f3283d = i21 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i21);
            s();
        }
        return z12;
    }

    public final int p(long j10) {
        int i10;
        char cCharAt = this.f3283d;
        boolean z10 = true;
        int i11 = this.f3284e + 1;
        int i12 = 1;
        while (cCharAt != '\"' && cCharAt != '\'') {
            boolean z11 = z10;
            int i13 = i12;
            if (cCharAt > ' ' || !(cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\f' || cCharAt == '\b')) {
                this.f3300u = 0L;
                this.f3295p = -2;
                return 0;
            }
            i12 = i13 + 1;
            int i14 = this.f3284e + i13;
            cCharAt = i14 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i14);
            z10 = z11;
        }
        int i15 = i12;
        int i16 = i11;
        long j11 = -2128831035;
        while (true) {
            if (i16 >= this.f3297r) {
                i10 = i15;
                break;
            }
            char cCharAt2 = this.f3296q.charAt(i16);
            if (cCharAt2 == cCharAt) {
                i10 = i15 + (i16 - i11);
                break;
            }
            j11 = (j11 ^ cCharAt2) * 16777619;
            i16++;
        }
        if (j11 != j10) {
            this.f3300u = j11;
            this.f3295p = -2;
            return 0;
        }
        int i17 = i10 + 1;
        int i18 = this.f3284e + i17;
        char cCharAt3 = i18 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i18);
        while (cCharAt3 != ':') {
            if (cCharAt3 > ' ' || !(cCharAt3 == ' ' || cCharAt3 == '\n' || cCharAt3 == '\r' || cCharAt3 == '\t' || cCharAt3 == '\f' || cCharAt3 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i19 = i17 + 1;
            int i20 = this.f3284e + i17;
            cCharAt3 = i20 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i20);
            i17 = i19;
        }
        return i17 + 1;
    }

    public char q() {
        int i10 = this.f3284e + 1;
        this.f3284e = i10;
        char cCharAt = i10 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i10);
        this.f3283d = cCharAt;
        return cCharAt;
    }

    public final void r() {
        char c10;
        while (true) {
            c10 = this.f3283d;
            if (c10 > ' ' || !(c10 == ' ' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\f' || c10 == '\b')) {
                break;
            } else {
                q();
            }
        }
        if (c10 == '_' || Character.isLetter(c10)) {
            L();
        } else {
            s();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a1, code lost:
    
        if (r16.f3280a == 20) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a3, code lost:
    
        r16.f3280a = 20;
        r1 = r16.f3285f;
        r16.f3284e = r1;
        r16.f3281b = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ab, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b3, code lost:
    
        throw new com.alibaba.fastjson.JSONException("EOF error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00fe, code lost:
    
        L();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0101, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.s():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(int r11) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.t(int):void");
    }

    public final void u(char c10) {
        this.f3287h = 0;
        while (true) {
            char c11 = this.f3283d;
            if (c11 == c10) {
                int i10 = this.f3284e + 1;
                this.f3284e = i10;
                this.f3283d = i10 >= this.f3297r ? (char) 26 : this.f3296q.charAt(i10);
                s();
                return;
            }
            if (c11 != ' ' && c11 != '\n' && c11 != '\r' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                throw new JSONException("not match " + c10 + " - " + this.f3283d);
            }
            q();
        }
    }

    public final String v() {
        char cCharAt = this.f3296q.charAt((this.f3290k + this.f3287h) - 1);
        int i10 = this.f3287h;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i10--;
        }
        return Y(this.f3290k, i10);
    }

    public boolean x() {
        int i10;
        boolean z10 = false;
        if (this.f3296q.startsWith("false", this.f3284e)) {
            i10 = 5;
        } else if (this.f3296q.startsWith("true", this.f3284e)) {
            i10 = 4;
            z10 = true;
        } else {
            char c10 = this.f3283d;
            if (c10 == '1') {
                i10 = 1;
                z10 = true;
            } else {
                if (c10 != '0') {
                    this.f3295p = -1;
                    return false;
                }
                i10 = 1;
            }
        }
        int i11 = this.f3284e + i10;
        this.f3284e = i11;
        this.f3283d = b(i11);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean y(long r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.d.y(long):boolean");
    }

    public final double z(long j10) throws NumberFormatException {
        int i10;
        char cB;
        int i11;
        double d10;
        double d11;
        int i12;
        char cB2;
        this.f3295p = 0;
        int iP = p(j10);
        if (iP == 0) {
            return 0.0d;
        }
        int i13 = iP + 1;
        char cB3 = b(this.f3284e + iP);
        int i14 = this.f3284e;
        int i15 = (i14 + i13) - 1;
        boolean z10 = cB3 == '-';
        if (z10) {
            cB3 = b(i14 + i13);
            i13 = iP + 2;
        }
        if (cB3 < '0' || cB3 > '9') {
            this.f3295p = -1;
            return 0.0d;
        }
        int i16 = cB3 - '0';
        while (true) {
            i10 = i13 + 1;
            cB = b(this.f3284e + i13);
            if (cB < '0' || cB > '9') {
                break;
            }
            i16 = (i16 * 10) + (cB - '0');
            i13 = i10;
        }
        if (cB == '.') {
            int i17 = i13 + 2;
            char cB4 = b(this.f3284e + i10);
            if (cB4 < '0' || cB4 > '9') {
                this.f3295p = -1;
                return 0.0d;
            }
            i16 = (i16 * 10) + (cB4 - '0');
            int i18 = 10;
            while (true) {
                i12 = i17 + 1;
                cB2 = b(this.f3284e + i17);
                if (cB2 < '0' || cB2 > '9') {
                    break;
                }
                i16 = (i16 * 10) + (cB2 - '0');
                i18 *= 10;
                i17 = i12;
            }
            int i19 = i18;
            cB = cB2;
            i11 = i19;
            i10 = i12;
        } else {
            i11 = 1;
        }
        boolean z11 = cB == 'e' || cB == 'E';
        if (z11) {
            int i20 = i10 + 1;
            cB = b(this.f3284e + i10);
            d10 = 0.0d;
            if (cB == '+' || cB == '-') {
                i10 += 2;
                cB = b(this.f3284e + i20);
            } else {
                i10 = i20;
            }
            while (cB >= '0' && cB <= '9') {
                cB = b(this.f3284e + i10);
                i10++;
            }
        } else {
            d10 = 0.0d;
        }
        int i21 = ((this.f3284e + i10) - i15) - 1;
        if (z11 || i21 >= 10) {
            d11 = Double.parseDouble(Y(i15, i21));
        } else {
            d11 = i16 / i11;
            if (z10) {
                d11 = -d11;
            }
        }
        if (cB == ',') {
            this.f3284e += i10 - 1;
            q();
            this.f3295p = 3;
            this.f3280a = 16;
            return d11;
        }
        if (cB != '}') {
            this.f3295p = -1;
            return d10;
        }
        char cB5 = b(this.f3284e + i10);
        if (cB5 == ',') {
            this.f3280a = 16;
            this.f3284e += i10;
            q();
        } else if (cB5 == ']') {
            this.f3280a = 15;
            this.f3284e += i10;
            q();
        } else if (cB5 == '}') {
            this.f3280a = 13;
            this.f3284e += i10;
            q();
        } else {
            if (cB5 != 26) {
                this.f3295p = -1;
                return d10;
            }
            this.f3284e += i10;
            this.f3280a = 20;
            this.f3283d = (char) 26;
        }
        this.f3295p = 4;
        return d11;
    }

    public d(String str, int i10) {
        this.f3282c = G1.a.f2774c;
        this.f3288i = false;
        this.f3289j = false;
        this.f3292m = G1.a.f2772a;
        this.f3293n = G1.a.f2773b;
        this.f3294o = null;
        this.f3295p = 0;
        char[] cArr = f3276w.get();
        this.f3286g = cArr;
        if (cArr == null) {
            this.f3286g = new char[512];
        }
        this.f3282c = i10;
        this.f3296q = str;
        int length = str.length();
        this.f3297r = length;
        int i11 = (-1) + 1;
        this.f3284e = i11;
        char cCharAt = i11 >= length ? (char) 26 : str.charAt(i11);
        this.f3283d = cCharAt;
        if (cCharAt == 65279) {
            q();
        }
        this.f3298s = (Feature.InitStringFieldAsEmpty.mask & i10) != 0 ? "" : null;
        this.f3299t = (Feature.DisableCircularReferenceDetect.mask & i10) != 0;
    }
}
