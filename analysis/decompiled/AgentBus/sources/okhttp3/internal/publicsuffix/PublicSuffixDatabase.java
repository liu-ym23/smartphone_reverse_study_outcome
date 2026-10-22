package okhttp3.internal.publicsuffix;

import a.a;
import d7.r;
import d7.z;
import fa.j;
import fa.l;
import ga.k;
import h4.n;
import ib.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import kotlin.Metadata;
import ob.b;
import ob.e;
import ob.e0;
import ob.m0;
import ob.s;
import ob.x;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "<init>", "()V", "h4/n", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f8044e = {42};

    /* renamed from: f, reason: collision with root package name */
    public static final List f8045f = a.S("*");

    /* renamed from: g, reason: collision with root package name */
    public static final PublicSuffixDatabase f8046g = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f8047a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f8048b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public byte[] f8049c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f8050d;

    public static List c(String str) {
        List listE0 = k.E0(str, new char[]{'.'});
        return q7.k.a(r.W0(listE0), "") ? r.L0(listE0) : listE0;
    }

    public final String a(String str) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        List listE0;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        q7.k.d(unicode, "unicodeDomain");
        List listC = c(unicode);
        List listE02 = z.f2978f;
        int i2 = 0;
        if (this.f8047a.get() || !this.f8047a.compareAndSet(false, true)) {
            try {
                this.f8048b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z4 = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z4 = true;
                    } catch (IOException e10) {
                        m mVar = m.f5049a;
                        m.f5049a.getClass();
                        m.g(5, "Failed to read public suffix list", e10);
                        if (z4) {
                        }
                    }
                } finally {
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (this.f8049c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i10 = 0; i10 < size3; i10++) {
            String str2 = (String) listC.get(i10);
            Charset charset = StandardCharsets.UTF_8;
            q7.k.d(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            q7.k.d(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i10] = bytes;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= size3) {
                strA = null;
                break;
            }
            byte[] bArr2 = this.f8049c;
            if (bArr2 == null) {
                q7.k.j("publicSuffixListBytes");
                throw null;
            }
            strA = n.a(bArr2, bArr, i11);
            if (strA != null) {
                break;
            }
            i11++;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i12 = 0; i12 < length; i12++) {
                bArr3[i12] = f8044e;
                byte[] bArr4 = this.f8049c;
                if (bArr4 == null) {
                    q7.k.j("publicSuffixListBytes");
                    throw null;
                }
                strA2 = n.a(bArr4, bArr3, i12);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            int i13 = size3 - 1;
            for (int i14 = 0; i14 < i13; i14++) {
                byte[] bArr5 = this.f8050d;
                if (bArr5 == null) {
                    q7.k.j("publicSuffixExceptionListBytes");
                    throw null;
                }
                strA3 = n.a(bArr5, bArr, i14);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            listE0 = k.E0("!".concat(strA3), new char[]{'.'});
        } else if (strA == null && strA2 == null) {
            listE0 = f8045f;
        } else {
            List listE03 = strA != null ? k.E0(strA, new char[]{'.'}) : listE02;
            if (strA2 != null) {
                listE02 = k.E0(strA2, new char[]{'.'});
            }
            listE0 = listE03.size() > listE02.size() ? listE03 : listE02;
        }
        if (listC.size() == listE0.size() && ((String) listE0.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listE0.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listE0.size();
        } else {
            size = listC.size();
            size2 = listE0.size() + 1;
        }
        j jVarQ0 = l.q0(r.H0(c(str)), size - size2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        for (Object obj : jVarQ0) {
            i2++;
            if (i2 > 1) {
                sb2.append((CharSequence) ".");
            }
            ib.k.f(sb2, obj, null);
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public final void b() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                Logger logger = x.f8039a;
                e0 e0VarC = b.c(new s(new e(1, resourceAsStream, new m0())));
                try {
                    long j2 = e0VarC.readInt();
                    e0VarC.L(j2);
                    byte[] bArrR = e0VarC.f7965g.r(j2);
                    long j4 = e0VarC.readInt();
                    e0VarC.L(j4);
                    byte[] bArrR2 = e0VarC.f7965g.r(j4);
                    e0VarC.close();
                    synchronized (this) {
                        this.f8049c = bArrR;
                        this.f8050d = bArrR2;
                    }
                } finally {
                }
            }
        } finally {
            this.f8048b.countDown();
        }
    }
}
