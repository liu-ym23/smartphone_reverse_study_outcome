package okhttp3.internal.publicsuffix;

import L4.g;
import L4.l;
import L4.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.platform.f;

/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f19105e = {42};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f19106f = new String[0];

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f19107g = {"*"};

    /* renamed from: h, reason: collision with root package name */
    private static final PublicSuffixDatabase f19108h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f19109a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f19110b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    private byte[] f19111c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f19112d;

    private static String a(byte[] bArr, byte[][] bArr2, int i5) {
        int i6;
        boolean z5;
        int i7;
        int i8;
        int length = bArr.length;
        int i9 = 0;
        while (i9 < length) {
            int i10 = (i9 + length) / 2;
            while (i10 > -1 && bArr[i10] != 10) {
                i10--;
            }
            int i11 = i10 + 1;
            int i12 = 1;
            while (true) {
                i6 = i11 + i12;
                if (bArr[i6] == 10) {
                    break;
                }
                i12++;
            }
            int i13 = i6 - i11;
            int i14 = i5;
            boolean z6 = false;
            int i15 = 0;
            int i16 = 0;
            while (true) {
                if (z6) {
                    i7 = 46;
                    z5 = false;
                } else {
                    z5 = z6;
                    i7 = bArr2[i14][i15] & 255;
                }
                i8 = i7 - (bArr[i11 + i16] & 255);
                if (i8 == 0) {
                    i16++;
                    i15++;
                    if (i16 == i13) {
                        break;
                    }
                    if (bArr2[i14].length != i15) {
                        z6 = z5;
                    } else {
                        if (i14 == bArr2.length - 1) {
                            break;
                        }
                        i14++;
                        i15 = -1;
                        z6 = true;
                    }
                } else {
                    break;
                }
            }
            if (i8 >= 0) {
                if (i8 <= 0) {
                    int i17 = i13 - i16;
                    int length2 = bArr2[i14].length - i15;
                    while (true) {
                        i14++;
                        if (i14 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i14].length;
                    }
                    if (length2 >= i17) {
                        if (length2 <= i17) {
                            return new String(bArr, i11, i13, StandardCharsets.UTF_8);
                        }
                    }
                }
                i9 = i6 + 1;
            }
            length = i10;
        }
        return null;
    }

    private String[] b(String[] strArr) throws InterruptedException {
        String str;
        String strA;
        String strA2;
        int i5 = 0;
        if (this.f19109a.get() || !this.f19109a.compareAndSet(false, true)) {
            try {
                this.f19110b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            f();
        }
        synchronized (this) {
            if (this.f19111c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            bArr[i6] = strArr[i6].getBytes(StandardCharsets.UTF_8);
        }
        int i7 = 0;
        while (true) {
            str = null;
            if (i7 >= length) {
                strA = null;
                break;
            }
            strA = a(this.f19111c, bArr, i7);
            if (strA != null) {
                break;
            }
            i7++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i8 = 0; i8 < bArr2.length - 1; i8++) {
                bArr2[i8] = f19105e;
                strA2 = a(this.f19111c, bArr2, i8);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            while (true) {
                if (i5 >= length - 1) {
                    break;
                }
                String strA3 = a(this.f19112d, bArr, i5);
                if (strA3 != null) {
                    str = strA3;
                    break;
                }
                i5++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return f19107g;
        }
        String[] strArrSplit = strA != null ? strA.split("\\.") : f19106f;
        String[] strArrSplit2 = strA2 != null ? strA2.split("\\.") : f19106f;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    public static PublicSuffixDatabase c() {
        return f19108h;
    }

    private void e() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        g gVarB = o.b(new l(o.e(resourceAsStream)));
        try {
            byte[] bArr = new byte[gVarB.readInt()];
            gVarB.readFully(bArr);
            byte[] bArr2 = new byte[gVarB.readInt()];
            gVarB.readFully(bArr2);
            gVarB.close();
            synchronized (this) {
                this.f19111c = bArr;
                this.f19112d = bArr2;
            }
            this.f19110b.countDown();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (gVarB != null) {
                    try {
                        gVarB.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private void f() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    e();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z5 = true;
                } catch (IOException e6) {
                    f.get().log(5, "Failed to read public suffix list", e6);
                    if (!z5) {
                        return;
                    }
                }
            } finally {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public String d(String str) throws InterruptedException {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrB = b(strArrSplit);
        if (strArrSplit.length == strArrB.length && strArrB[0].charAt(0) != '!') {
            return null;
        }
        if (strArrB[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrB.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrB.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i5 = length - length2; i5 < strArrSplit2.length; i5++) {
            sb.append(strArrSplit2[i5]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
