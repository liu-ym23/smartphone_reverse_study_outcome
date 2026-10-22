package okhttp3.internal.publicsuffix;

import ac.a;
import f8.b;
import gc.d;
import gc.e;
import gc.m;
import hc.h;
import id.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.invoke.VarHandle;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kb.l;
import kb.s;
import od.c0;
import od.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f9505e = {42};

    /* renamed from: f, reason: collision with root package name */
    public static final List f9506f = a.E("*");

    /* renamed from: g, reason: collision with root package name */
    public static final PublicSuffixDatabase f9507g;

    /* renamed from: a, reason: collision with root package name */
    public AtomicBoolean f9508a;

    /* renamed from: b, reason: collision with root package name */
    public CountDownLatch f9509b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f9510c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f9511d;

    static {
        PublicSuffixDatabase publicSuffixDatabase = new PublicSuffixDatabase();
        publicSuffixDatabase.f9508a = new AtomicBoolean(false);
        publicSuffixDatabase.f9509b = new CountDownLatch(1);
        VarHandle.storeStoreFence();
        f9507g = publicSuffixDatabase;
    }

    public static List c(String str) {
        List listP0 = h.p0(str, new char[]{'.'});
        if (!k.a(l.C0(listP0), "")) {
            return listP0;
        }
        int size = listP0.size() - 1;
        return l.J0(listP0, size >= 0 ? size : 0);
    }

    public final String a(String str) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        List listP0;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        unicode.getClass();
        List listC = c(unicode);
        AtomicBoolean atomicBoolean = this.f9508a;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                this.f9509b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z10 = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z10 = true;
                    } catch (IOException e10) {
                        n.Companion.getClass();
                        n.platform.log("Failed to read public suffix list", 5, e10);
                        if (z10) {
                        }
                    }
                } finally {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (this.f9510c == null) {
            f.e("Unable to load publicsuffixes.gz resource from the classpath.");
            return null;
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i = 0; i < size3; i++) {
            String str2 = (String) listC.get(i);
            Charset charset = StandardCharsets.UTF_8;
            charset.getClass();
            byte[] bytes = str2.getBytes(charset);
            bytes.getClass();
            bArr[i] = bytes;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                strA = null;
                break;
            }
            byte[] bArr2 = this.f9510c;
            if (bArr2 == null) {
                k.f("publicSuffixListBytes");
                throw null;
            }
            strA = b.a(bArr2, bArr, i3);
            if (strA != null) {
                break;
            }
            i3++;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i10 = 0; i10 < length; i10++) {
                bArr3[i10] = f9505e;
                byte[] bArr4 = this.f9510c;
                if (bArr4 == null) {
                    k.f("publicSuffixListBytes");
                    throw null;
                }
                strA2 = b.a(bArr4, bArr3, i10);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            int i11 = size3 - 1;
            for (int i12 = 0; i12 < i11; i12++) {
                byte[] bArr5 = this.f9511d;
                if (bArr5 == null) {
                    k.f("publicSuffixExceptionListBytes");
                    throw null;
                }
                strA3 = b.a(bArr5, bArr, i12);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            listP0 = h.p0("!".concat(strA3), new char[]{'.'});
        } else if (strA == null && strA2 == null) {
            listP0 = f9506f;
        } else {
            List listP02 = s.f7404c;
            List listP03 = strA != null ? h.p0(strA, new char[]{'.'}) : listP02;
            if (strA2 != null) {
                listP02 = h.p0(strA2, new char[]{'.'});
            }
            listP0 = listP03.size() > listP02.size() ? listP03 : listP02;
        }
        if (listC.size() == listP0.size() && ((String) listP0.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listP0.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listP0.size();
        } else {
            size = listC.size();
            size2 = listP0.size() + 1;
        }
        int i13 = size - size2;
        gc.k kVarR0 = l.r0(c(str));
        if (i13 < 0) {
            f.c(k0.a.k(i13, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i13 != 0) {
            kVarR0 = kVarR0 instanceof e ? ((e) kVarR0).a(i13) : new d(kVarR0, i13);
        }
        return m.T(kVarR0, ".");
    }

    public final void b() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                c0 c0Var = new c0(new od.s(a.W(resourceAsStream)));
                try {
                    long jN = c0Var.n();
                    c0Var.H(jN);
                    byte[] bArrO = c0Var.f9428f.O(jN);
                    long jN2 = c0Var.n();
                    c0Var.H(jN2);
                    byte[] bArrO2 = c0Var.f9428f.O(jN2);
                    c0Var.close();
                    synchronized (this) {
                        this.f9510c = bArrO;
                        this.f9511d = bArrO2;
                    }
                } finally {
                }
            }
        } finally {
            this.f9509b.countDown();
        }
    }
}
