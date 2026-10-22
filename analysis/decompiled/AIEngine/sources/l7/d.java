package l7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.g;
import lb.n;
import mb.y;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<byte[]> f10346a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<byte[]> f10347b;

    static {
        ThreadLocal<byte[]> threadLocalWithInitial = ThreadLocal.withInitial(new b());
        g.e(threadLocalWithInitial, "withInitial(...)");
        f10346a = threadLocalWithInitial;
        ThreadLocal<byte[]> threadLocalWithInitial2 = ThreadLocal.withInitial(new c(0));
        g.e(threadLocalWithInitial2, "withInitial(...)");
        f10347b = threadLocalWithInitial2;
    }

    public static byte[] a(String str) {
        Charset US_ASCII = StandardCharsets.US_ASCII;
        g.e(US_ASCII, "US_ASCII");
        byte[] bytes = str.getBytes(US_ASCII);
        g.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static long b(byte[] b10, int i10, int i11) {
        g.f(b10, "b");
        while (i10 < i11 && b10[i10] != 58) {
            i10++;
        }
        if (i10 >= i11) {
            return -1L;
        }
        do {
            i10++;
            if (i10 >= i11) {
                break;
            }
        } while (b10[i10] <= 32);
        return h(b10, i10, d(b10, i10, i11));
    }

    public static long c(byte[] b10, int i10, int i11, int i12, long j10) {
        g.f(b10, "b");
        int iE = e(b10, i10, i11, i12);
        if (iE >= 0) {
            long jH = h(b10, iE, d(b10, iE, i11));
            if (jH >= 0) {
                return jH;
            }
        }
        return j10;
    }

    public static int d(byte[] b10, int i10, int i11) {
        g.f(b10, "b");
        while (i10 < i11 && b10[i10] > 32) {
            i10++;
        }
        return i10;
    }

    public static int e(byte[] b10, int i10, int i11, int i12) {
        g.f(b10, "b");
        int i13 = 0;
        while (i10 < i11) {
            while (i10 < i11 && b10[i10] <= 32) {
                i10++;
            }
            if (i10 >= i11) {
                return -1;
            }
            if (i13 == i12) {
                return i10;
            }
            while (i10 < i11 && b10[i10] > 32) {
                i10++;
            }
            i13++;
        }
        return -1;
    }

    public static void f(File file, q qVar) throws IOException {
        byte[] bArr;
        byte[] bArr2 = f10346a.get();
        if (bArr2 == null || (bArr = f10347b.get()) == null) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        int i10 = 0;
        while (true) {
            try {
                int i11 = fileInputStream.read(bArr2);
                if (i11 <= 0) {
                    break;
                }
                int i12 = 0;
                while (i12 < i11) {
                    int i13 = i12;
                    while (i13 < i11 && bArr2[i13] != 10) {
                        i13++;
                    }
                    if (i13 < i11) {
                        if (i10 == 0) {
                            qVar.invoke(bArr2, Integer.valueOf(i12), Integer.valueOf(Math.min(i13, i12 + 1024)));
                        } else {
                            int iMin = Math.min(i13 - i12, 1024 - i10);
                            if (iMin > 0) {
                                System.arraycopy(bArr2, i12, bArr, i10, iMin);
                            }
                            qVar.invoke(bArr, 0, Integer.valueOf(i10 + iMin));
                            i10 = 0;
                        }
                        i12 = i13 + 1;
                    } else {
                        int iMin2 = Math.min(i13 - i12, 1024 - i10);
                        if (iMin2 > 0) {
                            System.arraycopy(bArr2, i12, bArr, i10, iMin2);
                        }
                        i10 += iMin2;
                        i12 = i11;
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    y.q(fileInputStream, th);
                    throw th2;
                }
            }
        }
        if (i10 > 0) {
            qVar.invoke(bArr, 0, Integer.valueOf(i10));
        }
        n nVar = n.f10413a;
        fileInputStream.close();
    }

    public static boolean g(byte[] b10, int i10, int i11, byte[] prefix) {
        g.f(b10, "b");
        g.f(prefix, "prefix");
        if (i11 - i10 >= prefix.length) {
            int length = prefix.length;
            for (int i12 = 0; i12 < length; i12++) {
                if (b10[i10 + i12] == prefix[i12]) {
                }
            }
            return true;
        }
        return false;
    }

    public static long h(byte[] b10, int i10, int i11) {
        g.f(b10, "b");
        if (i10 >= i11) {
            return -1L;
        }
        long j10 = 0;
        while (i10 < i11) {
            int i12 = b10[i10] - 48;
            if (i12 < 0 || i12 > 9) {
                return -1L;
            }
            j10 = (j10 * 10) + i12;
            i10++;
        }
        return j10;
    }

    public static long i(byte[] b10, int i10, int i11) {
        int i12;
        g.f(b10, "b");
        if (i10 >= i11) {
            return -1L;
        }
        long j10 = 0;
        while (i10 < i11) {
            byte b11 = b10[i10];
            if (48 <= b11 && b11 < 58) {
                i12 = b11 - 48;
            } else if (97 <= b11 && b11 < 103) {
                i12 = b11 - 87;
            } else {
                if (65 > b11 || b11 >= 71) {
                    return -1L;
                }
                i12 = b11 - 55;
            }
            j10 = (j10 << 4) | i12;
            i10++;
        }
        return j10;
    }
}
