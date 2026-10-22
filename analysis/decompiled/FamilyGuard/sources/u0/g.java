package u0;

import com.stepos.digitalwellbeing.server.net.category.CategoryEntity;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Properties f22753a = new Properties();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f22754b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f22755c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d, reason: collision with root package name */
    public static final boolean[] f22756d = new boolean[256];

    /* renamed from: e, reason: collision with root package name */
    public static final boolean[] f22757e = new boolean[256];

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f22758f;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f22759g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean[] f22760h;

    /* renamed from: i, reason: collision with root package name */
    public static final boolean[] f22761i;

    /* renamed from: j, reason: collision with root package name */
    public static final char[] f22762j;

    /* renamed from: k, reason: collision with root package name */
    public static final char[] f22763k;

    /* renamed from: l, reason: collision with root package name */
    static final char[] f22764l;

    /* renamed from: m, reason: collision with root package name */
    static final char[] f22765m;

    /* renamed from: n, reason: collision with root package name */
    static final char[] f22766n;

    /* renamed from: o, reason: collision with root package name */
    static final int[] f22767o;

    /* renamed from: p, reason: collision with root package name */
    public static final char[] f22768p;

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f22769q;

    static class a implements PrivilegedAction<InputStream> {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream("fastjson.properties") : ClassLoader.getSystemResourceAsStream("fastjson.properties");
        }
    }

    static {
        char c6 = 0;
        while (true) {
            boolean[] zArr = f22756d;
            if (c6 >= zArr.length) {
                break;
            }
            if (c6 >= 'A' && c6 <= 'Z') {
                zArr[c6] = true;
            } else if (c6 >= 'a' && c6 <= 'z') {
                zArr[c6] = true;
            } else if (c6 == '_' || c6 == '$') {
                zArr[c6] = true;
            }
            c6 = (char) (c6 + 1);
        }
        char c7 = 0;
        while (true) {
            boolean[] zArr2 = f22757e;
            if (c7 < zArr2.length) {
                if (c7 >= 'A' && c7 <= 'Z') {
                    zArr2[c7] = true;
                } else if (c7 >= 'a' && c7 <= 'z') {
                    zArr2[c7] = true;
                } else if (c7 == '_') {
                    zArr2[c7] = true;
                } else if (c7 >= '0' && c7 <= '9') {
                    zArr2[c7] = true;
                }
                c7 = (char) (c7 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        j();
        byte[] bArr = new byte[161];
        f22758f = bArr;
        byte[] bArr2 = new byte[161];
        f22759g = bArr2;
        f22760h = new boolean[161];
        f22761i = new boolean[161];
        f22762j = new char[93];
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
        for (int i5 = 14; i5 <= 31; i5++) {
            f22758f[i5] = 4;
            f22759g[i5] = 4;
        }
        for (int i6 = 127; i6 < 160; i6++) {
            f22758f[i6] = 4;
            f22759g[i6] = 4;
        }
        for (int i7 = 0; i7 < 161; i7++) {
            f22760h[i7] = f22758f[i7] != 0;
            f22761i[i7] = f22759g[i7] != 0;
        }
        char[] cArr = f22762j;
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
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        f22763k = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        f22764l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f22765m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        f22766n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        f22767o = new int[]{9, 99, 999, CategoryEntity.SYSTEM_APP, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f22768p = charArray;
        int[] iArr = new int[256];
        f22769q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i8 = 0; i8 < length; i8++) {
            f22769q[f22768p[i8]] = i8;
        }
        f22769q[61] = 0;
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] b(String str) {
        int i5;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i6 = length - 1;
        int i7 = 0;
        while (i7 < i6 && f22769q[str.charAt(i7) & 255] < 0) {
            i7++;
        }
        while (i6 > 0 && f22769q[str.charAt(i6) & 255] < 0) {
            i6--;
        }
        int i8 = str.charAt(i6) == '=' ? str.charAt(i6 + (-1)) == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i7) + 1;
        if (length > 76) {
            i5 = (str.charAt(76) == '\r' ? i9 / 78 : 0) << 1;
        } else {
            i5 = 0;
        }
        int i10 = (((i9 - i5) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int[] iArr = f22769q;
            int i14 = i7 + 4;
            int i15 = iArr[str.charAt(i7 + 3)] | (iArr[str.charAt(i7 + 1)] << 12) | (iArr[str.charAt(i7)] << 18) | (iArr[str.charAt(i7 + 2)] << 6);
            bArr[i12] = (byte) (i15 >> 16);
            int i16 = i12 + 2;
            bArr[i12 + 1] = (byte) (i15 >> 8);
            i12 += 3;
            bArr[i16] = (byte) i15;
            if (i5 <= 0 || (i13 = i13 + 1) != 19) {
                i7 = i14;
            } else {
                i7 += 6;
                i13 = 0;
            }
        }
        if (i12 < i10) {
            int i17 = 0;
            int i18 = 0;
            while (i7 <= i6 - i8) {
                i17 |= f22769q[str.charAt(i7)] << (18 - (i18 * 6));
                i18++;
                i7++;
            }
            int i19 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i17 >> i19);
                i19 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    public static byte[] c(String str, int i5, int i6) {
        int i7;
        if (i6 == 0) {
            return new byte[0];
        }
        int i8 = (i5 + i6) - 1;
        int i9 = i5;
        while (i9 < i8 && f22769q[str.charAt(i9)] < 0) {
            i9++;
        }
        while (i8 > 0 && f22769q[str.charAt(i8)] < 0) {
            i8--;
        }
        int i10 = str.charAt(i8) == '=' ? str.charAt(i8 + (-1)) == '=' ? 2 : 1 : 0;
        int i11 = (i8 - i9) + 1;
        if (i6 > 76) {
            i7 = (str.charAt(76) == '\r' ? i11 / 78 : 0) << 1;
        } else {
            i7 = 0;
        }
        int i12 = (((i11 - i7) * 6) >> 3) - i10;
        byte[] bArr = new byte[i12];
        int i13 = (i12 / 3) * 3;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i13) {
            int[] iArr = f22769q;
            int i16 = i9 + 4;
            int i17 = iArr[str.charAt(i9 + 3)] | (iArr[str.charAt(i9 + 1)] << 12) | (iArr[str.charAt(i9)] << 18) | (iArr[str.charAt(i9 + 2)] << 6);
            bArr[i14] = (byte) (i17 >> 16);
            int i18 = i14 + 2;
            bArr[i14 + 1] = (byte) (i17 >> 8);
            i14 += 3;
            bArr[i18] = (byte) i17;
            if (i7 <= 0 || (i15 = i15 + 1) != 19) {
                i9 = i16;
            } else {
                i9 += 6;
                i15 = 0;
            }
        }
        if (i14 < i12) {
            int i19 = 0;
            int i20 = 0;
            while (i9 <= i8 - i10) {
                i19 |= f22769q[str.charAt(i9)] << (18 - (i20 * 6));
                i20++;
                i9++;
            }
            int i21 = 16;
            while (i14 < i12) {
                bArr[i14] = (byte) (i19 >> i21);
                i21 -= 8;
                i14++;
            }
        }
        return bArr;
    }

    public static byte[] d(char[] cArr, int i5, int i6) {
        int i7;
        int i8 = 0;
        if (i6 == 0) {
            return new byte[0];
        }
        int i9 = (i5 + i6) - 1;
        int i10 = i5;
        while (i10 < i9 && f22769q[cArr[i10]] < 0) {
            i10++;
        }
        while (i9 > 0 && f22769q[cArr[i9]] < 0) {
            i9--;
        }
        int i11 = cArr[i9] == '=' ? cArr[i9 + (-1)] == '=' ? 2 : 1 : 0;
        int i12 = (i9 - i10) + 1;
        if (i6 > 76) {
            i7 = (cArr[76] == '\r' ? i12 / 78 : 0) << 1;
        } else {
            i7 = 0;
        }
        int i13 = (((i12 - i7) * 6) >> 3) - i11;
        byte[] bArr = new byte[i13];
        int i14 = (i13 / 3) * 3;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int[] iArr = f22769q;
            int i17 = i10 + 4;
            int i18 = iArr[cArr[i10 + 3]] | (iArr[cArr[i10 + 1]] << 12) | (iArr[cArr[i10]] << 18) | (iArr[cArr[i10 + 2]] << 6);
            bArr[i15] = (byte) (i18 >> 16);
            int i19 = i15 + 2;
            bArr[i15 + 1] = (byte) (i18 >> 8);
            i15 += 3;
            bArr[i19] = (byte) i18;
            if (i7 <= 0 || (i16 = i16 + 1) != 19) {
                i10 = i17;
            } else {
                i10 += 6;
                i16 = 0;
            }
        }
        if (i15 < i13) {
            int i20 = 0;
            while (i10 <= i9 - i11) {
                i8 |= f22769q[cArr[i10]] << (18 - (i20 * 6));
                i20++;
                i10++;
            }
            int i21 = 16;
            while (i15 < i13) {
                bArr[i15] = (byte) (i8 >> i21);
                i21 -= 8;
                i15++;
            }
        }
        return bArr;
    }

    public static boolean e(char c6) {
        boolean[] zArr = f22756d;
        return c6 < zArr.length && zArr[c6];
    }

    public static void f(int i5, int i6, char[] cArr) {
        char c6;
        if (i5 < 0) {
            i5 = -i5;
            c6 = '-';
        } else {
            c6 = 0;
        }
        while (i5 >= 65536) {
            int i7 = i5 / 100;
            int i8 = i5 - (((i7 << 6) + (i7 << 5)) + (i7 << 2));
            cArr[i6 - 1] = f22766n[i8];
            i6 -= 2;
            cArr[i6] = f22765m[i8];
            i5 = i7;
        }
        while (true) {
            int i9 = (52429 * i5) >>> 19;
            int i10 = i6 - 1;
            cArr[i10] = f22764l[i5 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i5 = i9;
            i6 = i10;
        }
        if (c6 != 0) {
            cArr[i6 - 2] = c6;
        }
    }

    public static void g(long j5, int i5, char[] cArr) {
        char c6;
        if (j5 < 0) {
            j5 = -j5;
            c6 = '-';
        } else {
            c6 = 0;
        }
        while (j5 > 2147483647L) {
            long j6 = j5 / 100;
            int i6 = (int) (j5 - (((j6 << 6) + (j6 << 5)) + (j6 << 2)));
            cArr[i5 - 1] = f22766n[i6];
            i5 -= 2;
            cArr[i5] = f22765m[i6];
            j5 = j6;
        }
        int i7 = (int) j5;
        while (i7 >= 65536) {
            int i8 = i7 / 100;
            int i9 = i7 - (((i8 << 6) + (i8 << 5)) + (i8 << 2));
            cArr[i5 - 1] = f22766n[i9];
            i5 -= 2;
            cArr[i5] = f22765m[i9];
            i7 = i8;
        }
        while (true) {
            int i10 = (52429 * i7) >>> 19;
            int i11 = i5 - 1;
            cArr[i11] = f22764l[i7 - ((i10 << 3) + (i10 << 1))];
            if (i10 == 0) {
                break;
            }
            i7 = i10;
            i5 = i11;
        }
        if (c6 != 0) {
            cArr[i5 - 2] = c6;
        }
    }

    public static String h(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? f22753a.getProperty(str) : property;
    }

    public static boolean i(char c6) {
        boolean[] zArr = f22757e;
        return c6 < zArr.length && zArr[c6];
    }

    public static void j() throws IOException {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                f22753a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int k(int i5) {
        int i6 = 0;
        while (i5 > f22767o[i6]) {
            i6++;
        }
        return i6 + 1;
    }

    public static int l(long j5) {
        long j6 = 10;
        for (int i5 = 1; i5 < 19; i5++) {
            if (j5 < j6) {
                return i5;
            }
            j6 *= 10;
        }
        return 19;
    }
}
