package nd;

import androidx.datastore.preferences.protobuf.b1;
import bd.i;
import com.stepos.core.ota.domain.OtaAction;
import fc.c;
import fc.d;
import fc.p;
import gc.q;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kd.h;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.n;
import sd.l;
import sd.x;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final x f10703g;
    public static final byte[] h;

    /* renamed from: i, reason: collision with root package name */
    public static final List<String> f10704i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f10705j;

    /* renamed from: a, reason: collision with root package name */
    public final x f10706a;

    /* renamed from: b, reason: collision with root package name */
    public final l f10707b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f10708c;

    /* renamed from: d, reason: collision with root package name */
    public final CountDownLatch f10709d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f10710e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f10711f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: nd.a$a, reason: collision with other inner class name */
    public static final class C0114a {
        public static final String a(byte[] bArr, byte[][] bArr2, int i10) {
            int i11;
            boolean z;
            int i12;
            int i13;
            x xVar = a.f10703g;
            int length = bArr.length;
            int i14 = 0;
            while (i14 < length) {
                int i15 = (i14 + length) / 2;
                while (i15 > -1 && bArr[i15] != 10) {
                    i15--;
                }
                int i16 = i15 + 1;
                int i17 = 1;
                while (true) {
                    i11 = i16 + i17;
                    if (bArr[i11] == 10) {
                        break;
                    }
                    i17++;
                }
                int i18 = i11 - i16;
                int i19 = i10;
                boolean z3 = false;
                int i20 = 0;
                int i21 = 0;
                while (true) {
                    if (z3) {
                        i12 = 46;
                        z = false;
                    } else {
                        byte b10 = bArr2[i19][i20];
                        byte[] bArr3 = i.f3230a;
                        int i22 = b10 & 255;
                        z = z3;
                        i12 = i22;
                    }
                    byte b11 = bArr[i16 + i21];
                    byte[] bArr4 = i.f3230a;
                    i13 = i12 - (b11 & 255);
                    if (i13 != 0) {
                        break;
                    }
                    i21++;
                    i20++;
                    if (i21 == i18) {
                        break;
                    }
                    if (bArr2[i19].length != i20) {
                        z3 = z;
                    } else {
                        if (i19 == bArr2.length - 1) {
                            break;
                        }
                        i19++;
                        i20 = -1;
                        z3 = true;
                    }
                }
                if (i13 >= 0) {
                    if (i13 <= 0) {
                        int i23 = i18 - i21;
                        int length2 = bArr2[i19].length - i20;
                        int length3 = bArr2.length;
                        for (int i24 = i19 + 1; i24 < length3; i24++) {
                            length2 += bArr2[i24].length;
                        }
                        if (length2 >= i23) {
                            if (length2 <= i23) {
                                return new String(bArr, i16, i18, gc.a.f9106b);
                            }
                        }
                    }
                    i14 = i11 + 1;
                }
                length = i15;
            }
            return null;
        }
    }

    static {
        String str = x.f11981b;
        f10703g = x.a.a("/okhttp3/internal/publicsuffix/" + a.class.getSimpleName() + ".gz");
        h = new byte[]{42};
        f10704i = b1.P(OtaAction.GLOBAL);
        f10705j = new a(0);
    }

    public a() {
        this(0);
    }

    public static List c(String str) {
        List listE0 = q.E0(str, new char[]{'.'});
        return g.b(kotlin.collections.a.A0(listE0), "") ? kotlin.collections.a.q0(1, listE0) : listE0;
    }

    public final String a(String str) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        List<String> listE0;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        g.c(unicode);
        List listC = c(unicode);
        AtomicBoolean atomicBoolean = this.f10708c;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                this.f10709d.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e10) {
                        h.Companion.getClass();
                        h.platform.log("Failed to read public suffix list", 5, e10);
                        if (z) {
                        }
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (this.f10710e == null) {
            throw new IllegalStateException(("Unable to load " + f10703g + " resource from the classpath.").toString());
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i10 = 0; i10 < size3; i10++) {
            byte[] bytes = ((String) listC.get(i10)).getBytes(gc.a.f9106b);
            g.e(bytes, "getBytes(...)");
            bArr[i10] = bytes;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= size3) {
                strA = null;
                break;
            }
            byte[] bArr2 = this.f10710e;
            if (bArr2 == null) {
                g.l("publicSuffixListBytes");
                throw null;
            }
            strA = C0114a.a(bArr2, bArr, i11);
            if (strA != null) {
                break;
            }
            i11++;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i12 = 0; i12 < length; i12++) {
                bArr3[i12] = h;
                byte[] bArr4 = this.f10710e;
                if (bArr4 == null) {
                    g.l("publicSuffixListBytes");
                    throw null;
                }
                strA2 = C0114a.a(bArr4, bArr3, i12);
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
                byte[] bArr5 = this.f10711f;
                if (bArr5 == null) {
                    g.l("publicSuffixExceptionListBytes");
                    throw null;
                }
                strA3 = C0114a.a(bArr5, bArr, i14);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            listE0 = q.E0("!".concat(strA3), new char[]{'.'});
        } else if (strA == null && strA2 == null) {
            listE0 = f10704i;
        } else {
            List<String> listE02 = strA != null ? q.E0(strA, new char[]{'.'}) : EmptyList.f10001a;
            listE0 = strA2 != null ? q.E0(strA2, new char[]{'.'}) : EmptyList.f10001a;
            if (listE02.size() > listE0.size()) {
                listE0 = listE02;
            }
        }
        if (listC.size() == listE0.size() && listE0.get(0).charAt(0) != '!') {
            return null;
        }
        if (listE0.get(0).charAt(0) == '!') {
            size = listC.size();
            size2 = listE0.size();
        } else {
            size = listC.size();
            size2 = listE0.size() + 1;
        }
        int i15 = size - size2;
        fc.i iVarL0 = kotlin.collections.a.l0(c(str));
        if (i15 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i15, "Requested element count ", " is less than zero.").toString());
        }
        if (i15 != 0) {
            iVarL0 = iVarL0 instanceof d ? ((d) iVarL0).a(i15) : new c(iVarL0, i15);
        }
        return p.y(iVarL0, ".", null, 62);
    }

    public final void b() {
        try {
            z zVar = new z(new sd.q(this.f10707b.c(this.f10706a)));
            try {
                long j10 = zVar.readInt();
                zVar.T(j10);
                byte[] bArrG0 = zVar.f11987b.G0(j10);
                long j11 = zVar.readInt();
                zVar.T(j11);
                byte[] bArrG02 = zVar.f11987b.G0(j11);
                n nVar = n.f10413a;
                zVar.close();
                synchronized (this) {
                    this.f10710e = bArrG0;
                    this.f10711f = bArrG02;
                }
            } finally {
            }
        } finally {
            this.f10709d.countDown();
        }
    }

    public a(int i10) {
        okio.internal.a fileSystem = l.f11960b;
        x path = f10703g;
        g.f(path, "path");
        g.f(fileSystem, "fileSystem");
        this.f10706a = path;
        this.f10707b = fileSystem;
        this.f10708c = new AtomicBoolean(false);
        this.f10709d = new CountDownLatch(1);
    }
}
