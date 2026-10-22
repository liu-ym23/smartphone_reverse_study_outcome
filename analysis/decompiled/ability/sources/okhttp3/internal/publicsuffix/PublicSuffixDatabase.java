package okhttp3.internal.publicsuffix;

import D7.v;
import H4.o;
import V9.c;
import V9.r;
import V9.y;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
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
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;
import kotlin.sequences.a;
import w0.C2085f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", AppAgent.CONSTRUCT, "()V", "w0/f", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    public static final byte[] e = {42};
    public static final List f = o.M("*");
    public static final PublicSuffixDatabase g = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f5475a = new AtomicBoolean(false);
    public final CountDownLatch b = new CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    public static List c(String str) {
        List listE0 = m.E0(str, new char[]{'.'});
        return k.b(v.K0(listE0), "") ? v.x0(1, listE0) : listE0;
    }

    public final String a(String str) throws InterruptedException {
        String strE;
        String strE2;
        String strE3;
        List listE0;
        int size;
        int size2;
        String unicodeDomain = IDN.toUnicode(str);
        k.e(unicodeDomain, "unicodeDomain");
        List listC = c(unicodeDomain);
        AtomicBoolean atomicBoolean = this.f5475a;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                this.b.await();
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
                    } catch (IOException e6) {
                        N9.m.Companion.getClass();
                        N9.m.platform.log("Failed to read public suffix list", 5, e6);
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
        if (this.c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i = 0; i < size3; i++) {
            String str2 = (String) listC.get(i);
            Charset UTF_8 = StandardCharsets.UTF_8;
            k.e(UTF_8, "UTF_8");
            byte[] bytes = str2.getBytes(UTF_8);
            k.e(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                strE = null;
                break;
            }
            byte[] bArr2 = this.c;
            if (bArr2 == null) {
                k.n("publicSuffixListBytes");
                throw null;
            }
            strE = C2085f.e(bArr2, bArr, i6);
            if (strE != null) {
                break;
            }
            i6++;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i10 = 0; i10 < length; i10++) {
                bArr3[i10] = e;
                byte[] bArr4 = this.c;
                if (bArr4 == null) {
                    k.n("publicSuffixListBytes");
                    throw null;
                }
                strE2 = C2085f.e(bArr4, bArr3, i10);
                if (strE2 != null) {
                    break;
                }
            }
            strE2 = null;
        } else {
            strE2 = null;
        }
        if (strE2 != null) {
            int i11 = size3 - 1;
            for (int i12 = 0; i12 < i11; i12++) {
                byte[] bArr5 = this.d;
                if (bArr5 == null) {
                    k.n("publicSuffixExceptionListBytes");
                    throw null;
                }
                strE3 = C2085f.e(bArr5, bArr, i12);
                if (strE3 != null) {
                    break;
                }
            }
            strE3 = null;
        } else {
            strE3 = null;
        }
        if (strE3 != null) {
            listE0 = m.E0("!".concat(strE3), new char[]{'.'});
        } else if (strE == null && strE2 == null) {
            listE0 = f;
        } else {
            List listE02 = strE != null ? m.E0(strE, new char[]{'.'}) : EmptyList.f4893a;
            listE0 = strE2 != null ? m.E0(strE2, new char[]{'.'}) : EmptyList.f4893a;
            if (listE02.size() > listE0.size()) {
                listE0 = listE02;
            }
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
        return a.l0(a.e0(v.s0(c(str)), size - size2), ".");
    }

    public final void b() {
        try {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                Logger logger = V9.o.f1422a;
                r rVar = new r(new V9.m(new c(1, resourceAsStream, new y())));
                try {
                    long j5 = rVar.readInt();
                    rVar.t(j5);
                    ref$ObjectRef.f4920a = rVar.b.E(j5);
                    long j6 = rVar.readInt();
                    rVar.t(j6);
                    ref$ObjectRef2.f4920a = rVar.b.E(j6);
                    rVar.close();
                    synchronized (this) {
                        Object obj = ref$ObjectRef.f4920a;
                        k.c(obj);
                        this.c = (byte[]) obj;
                        Object obj2 = ref$ObjectRef2.f4920a;
                        k.c(obj2);
                        this.d = (byte[]) obj2;
                    }
                } finally {
                }
            }
        } finally {
            this.b.countDown();
        }
    }
}
