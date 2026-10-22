package eb;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f3243a;

    /* renamed from: b, reason: collision with root package name */
    public int f3244b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3245c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3246d;

    public b(List list) {
        q7.k.e(list, "connectionSpecs");
        this.f3243a = list;
    }

    public final ab.i a(SSLSocket sSLSocket) throws UnknownServiceException {
        ab.i iVar;
        int i2;
        boolean z4;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        int i10 = this.f3244b;
        List list = this.f3243a;
        int size = list.size();
        while (true) {
            if (i10 >= size) {
                iVar = null;
                break;
            }
            iVar = (ab.i) list.get(i10);
            if (iVar.b(sSLSocket)) {
                this.f3244b = i10 + 1;
                break;
            }
            i10++;
        }
        if (iVar == null) {
            StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb2.append(this.f3246d);
            sb2.append(", modes=");
            sb2.append(list);
            sb2.append(", supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            q7.k.b(enabledProtocols2);
            String string = Arrays.toString(enabledProtocols2);
            q7.k.d(string, "toString(this)");
            sb2.append(string);
            throw new UnknownServiceException(sb2.toString());
        }
        int i11 = this.f3244b;
        int size2 = list.size();
        while (true) {
            i2 = 0;
            if (i11 >= size2) {
                z4 = false;
                break;
            }
            if (((ab.i) list.get(i11)).b(sSLSocket)) {
                z4 = true;
                break;
            }
            i11++;
        }
        this.f3245c = z4;
        boolean z10 = this.f3246d;
        String[] strArr = iVar.f557d;
        String[] strArr2 = iVar.f556c;
        if (strArr2 != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            q7.k.d(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = bb.b.p(enabledCipherSuites2, strArr2, ab.g.f529c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (strArr != null) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            q7.k.d(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = bb.b.p(enabledProtocols3, strArr, f7.b.f3457b);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        q7.k.d(supportedCipherSuites, "supportedCipherSuites");
        ab.f fVar = ab.g.f529c;
        byte[] bArr = bb.b.f1659a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (fVar.compare(supportedCipherSuites[i2], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i2++;
        }
        if (z10 && i2 != -1) {
            q7.k.d(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i2];
            q7.k.d(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            q7.k.d(objArrCopyOf, "copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        ab.h hVar = new ab.h();
        hVar.f548a = iVar.f554a;
        hVar.f549b = strArr2;
        hVar.f550c = strArr;
        hVar.f551d = iVar.f555b;
        q7.k.d(enabledCipherSuites, "cipherSuitesIntersection");
        hVar.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        q7.k.d(enabledProtocols, "tlsVersionsIntersection");
        hVar.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        ab.i iVarA = hVar.a();
        if (iVarA.c() != null) {
            sSLSocket.setEnabledProtocols(iVarA.f557d);
        }
        if (iVarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(iVarA.f556c);
        }
        return iVar;
    }
}
