package J9;

import F9.C0231i;
import F9.C0232j;
import F9.C0234l;
import F9.C0235m;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f891a;
    public int b;
    public boolean c;
    public boolean d;

    public b(List connectionSpecs) {
        kotlin.jvm.internal.k.f(connectionSpecs, "connectionSpecs");
        this.f891a = connectionSpecs;
    }

    public final C0235m a(SSLSocket sSLSocket) throws UnknownServiceException {
        C0235m c0235m;
        int i;
        boolean z10;
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        int i6 = this.b;
        List list = this.f891a;
        int size = list.size();
        while (true) {
            if (i6 >= size) {
                c0235m = null;
                break;
            }
            c0235m = (C0235m) list.get(i6);
            if (c0235m.b(sSLSocket)) {
                this.b = i6 + 1;
                break;
            }
            i6++;
        }
        if (c0235m == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.d);
            sb.append(", modes=");
            sb.append(list);
            sb.append(", supported protocols=");
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.k.c(enabledProtocols);
            String string = Arrays.toString(enabledProtocols);
            kotlin.jvm.internal.k.e(string, "toString(this)");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i10 = this.b;
        int size2 = list.size();
        while (true) {
            i = 0;
            if (i10 >= size2) {
                z10 = false;
                break;
            }
            if (((C0235m) list.get(i10)).b(sSLSocket)) {
                z10 = true;
                break;
            }
            i10++;
        }
        this.c = z10;
        boolean z11 = this.d;
        String[] strArr = c0235m.d;
        String[] strArr2 = c0235m.c;
        if (strArr2 != null) {
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            kotlin.jvm.internal.k.e(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = G9.b.n(enabledCipherSuites, strArr2, C0232j.c);
        } else {
            cipherSuitesIntersection = sSLSocket.getEnabledCipherSuites();
        }
        if (strArr != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            kotlin.jvm.internal.k.e(enabledProtocols2, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = G9.b.n(enabledProtocols2, strArr, F7.b.b);
        } else {
            tlsVersionsIntersection = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        kotlin.jvm.internal.k.e(supportedCipherSuites, "supportedCipherSuites");
        C0231i c0231i = C0232j.c;
        byte[] bArr = G9.b.f704a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (c0231i.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i++;
        }
        if (z11 && i != -1) {
            kotlin.jvm.internal.k.e(cipherSuitesIntersection, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i];
            kotlin.jvm.internal.k.e(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length + 1);
            kotlin.jvm.internal.k.e(objArrCopyOf, "copyOf(this, newSize)");
            cipherSuitesIntersection = (String[]) objArrCopyOf;
            cipherSuitesIntersection[cipherSuitesIntersection.length - 1] = str;
        }
        C0234l c0234l = new C0234l();
        c0234l.f649a = c0235m.f650a;
        c0234l.c = strArr2;
        c0234l.d = strArr;
        c0234l.b = c0235m.b;
        kotlin.jvm.internal.k.e(cipherSuitesIntersection, "cipherSuitesIntersection");
        c0234l.e((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        kotlin.jvm.internal.k.e(tlsVersionsIntersection, "tlsVersionsIntersection");
        c0234l.x((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length));
        C0235m c0235mC = c0234l.c();
        if (c0235mC.c() != null) {
            sSLSocket.setEnabledProtocols(c0235mC.d);
        }
        if (c0235mC.a() != null) {
            sSLSocket.setEnabledCipherSuites(c0235mC.c);
        }
        return c0235m;
    }
}
