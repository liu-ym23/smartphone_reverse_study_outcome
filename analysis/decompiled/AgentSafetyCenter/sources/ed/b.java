package ed;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public List f3770a;

    /* renamed from: b, reason: collision with root package name */
    public int f3771b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3772c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3773d;

    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Serializable, java.lang.String[]] */
    public final ad.i a(SSLSocket sSLSocket) throws UnknownServiceException {
        ad.i iVar;
        int i;
        boolean z10;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        int i3 = this.f3771b;
        List list = this.f3770a;
        int size = list.size();
        while (true) {
            if (i3 >= size) {
                iVar = null;
                break;
            }
            iVar = (ad.i) list.get(i3);
            if (iVar.b(sSLSocket)) {
                this.f3771b = i3 + 1;
                break;
            }
            i3++;
        }
        if (iVar == null) {
            StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb2.append(this.f3773d);
            sb2.append(", modes=");
            sb2.append(list);
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            enabledProtocols2.getClass();
            String string = Arrays.toString(enabledProtocols2);
            string.getClass();
            sb2.append(", supported protocols=");
            sb2.append(string);
            throw new UnknownServiceException(sb2.toString());
        }
        int i10 = this.f3771b;
        int size2 = list.size();
        while (true) {
            i = 0;
            if (i10 >= size2) {
                z10 = false;
                break;
            }
            if (((ad.i) list.get(i10)).b(sSLSocket)) {
                z10 = true;
                break;
            }
            i10++;
        }
        this.f3772c = z10;
        boolean z11 = this.f3773d;
        ?? r02 = iVar.f517d;
        String[] strArr = iVar.f516c;
        if (strArr != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            enabledCipherSuites2.getClass();
            enabledCipherSuites = bd.b.o(enabledCipherSuites2, strArr, ad.g.f486c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (r02 != 0) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            enabledProtocols3.getClass();
            enabledProtocols = bd.b.o(enabledProtocols3, r02, mb.a.f8547f);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        supportedCipherSuites.getClass();
        ad.f fVar = ad.g.f486c;
        byte[] bArr = bd.b.f2074a;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (fVar.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i++;
        }
        if (z11 && i != -1) {
            enabledCipherSuites.getClass();
            String str = supportedCipherSuites[i];
            str.getClass();
            enabledCipherSuites = (String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            enabledCipherSuites[enabledCipherSuites.length - 1] = str;
        }
        ad.h hVar = new ad.h();
        hVar.f507a = iVar.f514a;
        hVar.f509c = strArr;
        hVar.f510d = r02;
        hVar.f508b = iVar.f515b;
        enabledCipherSuites.getClass();
        hVar.c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        enabledProtocols.getClass();
        hVar.e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        ad.i iVarA = hVar.a();
        if (iVarA.c() != null) {
            sSLSocket.setEnabledProtocols(iVarA.f517d);
        }
        if (iVarA.a() != null) {
            sSLSocket.setEnabledCipherSuites(iVarA.f516c);
        }
        return iVar;
    }
}
