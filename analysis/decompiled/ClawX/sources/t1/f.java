package t1;

import android.graphics.Path;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class f implements z7.a, e0.n, f.o {

    /* renamed from: b, reason: collision with root package name */
    public static f f5454b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5455a;

    public /* synthetic */ f(int i8) {
        this.f5455a = i8;
    }

    public static final void c(c7.d dVar) {
        b0.j jVar = c7.d.f1148h;
        if (c7.d.f1149i == null) {
            c7.d.f1149i = new c7.d();
            c7.c cVar = new c7.c("Okio Watchdog");
            cVar.setDaemon(true);
            cVar.start();
        }
        long jNanoTime = System.nanoTime();
        long j4 = dVar.f1200c;
        boolean z = dVar.f1198a;
        if (j4 != 0 && z) {
            dVar.f1156g = Math.min(j4, dVar.c() - jNanoTime) + jNanoTime;
        } else if (j4 != 0) {
            dVar.f1156g = jNanoTime + j4;
        } else {
            if (!z) {
                throw new AssertionError();
            }
            dVar.f1156g = dVar.c();
        }
        b0.j jVar2 = c7.d.f1148h;
        int i8 = jVar2.f832a + 1;
        jVar2.f832a = i8;
        c7.d[] dVarArr = (c7.d[]) jVar2.f833b;
        if (i8 == dVarArr.length) {
            c7.d[] dVarArr2 = new c7.d[i8 * 2];
            c5.l.Y(dVarArr, dVarArr2, 0, 0, 14);
            jVar2.f833b = dVarArr2;
        }
        jVar2.b(i8, dVar);
        if (dVar.f1155f == 1) {
            c7.d.f1151k.signal();
        }
    }

    public static c7.d d() throws InterruptedException {
        b0.j jVar = c7.d.f1148h;
        c7.d dVar = ((c7.d[]) jVar.f833b)[1];
        if (dVar == null) {
            long jNanoTime = System.nanoTime();
            c7.d.f1151k.await(c7.d.f1152l, TimeUnit.MILLISECONDS);
            if (((c7.d[]) jVar.f833b)[1] != null || System.nanoTime() - jNanoTime < c7.d.f1153m) {
                return null;
            }
            return c7.d.f1149i;
        }
        long jNanoTime2 = dVar.f1156g - System.nanoTime();
        if (jNanoTime2 > 0) {
            c7.d.f1151k.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        jVar.e(dVar);
        dVar.f1154e = 2;
        return dVar;
    }

    public static c7.i e(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 * 2;
            bArr[i8] = (byte) (d7.b.a(str.charAt(i9 + 1)) + (d7.b.a(str.charAt(i9)) << 4));
        }
        return new c7.i(bArr);
    }

    public static c7.i f(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        byte[] bytes = str.getBytes(x5.a.f6276a);
        kotlin.jvm.internal.p.d(bytes, "getBytes(...)");
        c7.i iVar = new c7.i(bytes);
        iVar.f1167c = str;
        return iVar;
    }

    public static Path i(float f3, float f7, float f9, float f10) {
        Path path = new Path();
        path.moveTo(f3, f7);
        path.lineTo(f9, f10);
        return path;
    }

    public static c7.i j(byte[] bArr) {
        c7.i iVar = c7.i.d;
        int length = bArr.length;
        c7.b.d(bArr.length, 0, length);
        return new c7.i(c5.l.Z(bArr, 0, length));
    }

    @Override // z7.a
    public z7.b a(String str) {
        return b8.b.f998a;
    }

    @Override // f.o
    public boolean g(f.j jVar) {
        return false;
    }

    public Object h(String str, Provider provider) {
        switch (this.f5455a) {
            case 20:
                return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
            case BERTags.VIDEOTEX_STRING /* 21 */:
                return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
            case BERTags.IA5_STRING /* 22 */:
                return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
            case BERTags.UTC_TIME /* 23 */:
                return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
            case 24:
                return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
            case BERTags.GRAPHIC_STRING /* 25 */:
                return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
            default:
                return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    public f(androidx.fragment.app.k kVar, int i8) {
        this.f5455a = i8;
        switch (i8) {
            case 6:
                this.f5455a = 6;
                new CopyOnWriteArrayList();
                break;
            default:
                new CopyOnWriteArrayList();
                break;
        }
    }

    public f(androidx.fragment.app.e eVar) {
        this.f5455a = 4;
    }

    @Override // f.o
    public void b(f.j jVar, boolean z) {
    }

    @Override // e0.n
    public void onScrollLimit(int i8, int i9, int i10, boolean z) {
    }

    @Override // e0.n
    public void onScrollProgress(int i8, int i9, int i10, int i11) {
    }
}
