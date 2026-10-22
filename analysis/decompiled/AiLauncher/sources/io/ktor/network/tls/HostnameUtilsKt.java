package io.ktor.network.tls;

import La.D;
import La.H;
import Z8.B;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import io.ktor.http.IpParserKt;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r*\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\r*\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000f\"\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"", "serverName", "Ljava/security/cert/X509Certificate;", "certificate", "LY8/t;", "verifyHostnameInCertificate", "(Ljava/lang/String;Ljava/security/cert/X509Certificate;)V", "ipString", "verifyIpInCertificate", "certificateHost", "", "matchHostnameWithCertificate", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "hosts", "(Ljava/security/cert/X509Certificate;)Ljava/util/List;", "ips", "", "DNS_NAME_TYPE", "I", "IP_ADDRESS_TYPE", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostnameUtilsKt {
    private static final int DNS_NAME_TYPE = 2;
    private static final int IP_ADDRESS_TYPE = 7;

    private static final List<String> hosts(X509Certificate x509Certificate) throws CertificateParsingException {
        Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : subjectAlternativeNames) {
            Object obj2 = ((List) obj).get(0);
            p.g(obj2, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) obj2).intValue() == 2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj3 = ((List) it.next()).get(1);
            p.g(obj3, "null cannot be cast to non-null type kotlin.String");
            arrayList2.add((String) obj3);
        }
        return arrayList2;
    }

    private static final List<String> ips(X509Certificate x509Certificate) throws CertificateParsingException {
        Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : subjectAlternativeNames) {
            Object obj2 = ((List) obj).get(0);
            p.g(obj2, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) obj2).intValue() == 7) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj3 = ((List) it.next()).get(1);
            p.g(obj3, "null cannot be cast to non-null type kotlin.String");
            arrayList2.add((String) obj3);
        }
        return arrayList2;
    }

    public static final boolean matchHostnameWithCertificate(String serverName, String certificateHost) {
        p.i(serverName, "serverName");
        p.i(certificateHost, "certificateHost");
        if (D.L(serverName, certificateHost, true)) {
            return true;
        }
        List listU = B.U(H.a1(serverName, new char[]{'.'}, false, 0, 6, null));
        List listU2 = B.U(H.a1(certificateHost, new char[]{'.'}, false, 0, 6, null));
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        while (i10 < listU.size() && i11 < listU2.size()) {
            String str = (String) listU.get(i10);
            if (i10 == 0 && str.length() == 0) {
                i10++;
            } else {
                String str2 = (String) listU2.get(i11);
                if (i11 != 0 || str2.length() != 0) {
                    if (!z10 && D.L(str, str2, true)) {
                        i12++;
                        i10++;
                    } else {
                        if (!p.d(str2, "*")) {
                            return false;
                        }
                        i10++;
                        i11++;
                        z10 = true;
                    }
                }
                i11++;
            }
        }
        return i10 == listU.size() && i11 == listU2.size() && (!z10 || i12 >= 2);
    }

    public static final void verifyHostnameInCertificate(String serverName, X509Certificate certificate) throws CertificateParsingException, TLSException {
        p.i(serverName, "serverName");
        p.i(certificate, "certificate");
        if (IpParserKt.hostIsIp(serverName)) {
            verifyIpInCertificate(serverName, certificate);
            return;
        }
        List<String> listHosts = hosts(certificate);
        if (listHosts.isEmpty()) {
            return;
        }
        List<String> list = listHosts;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (matchHostnameWithCertificate(serverName, (String) it.next())) {
                    return;
                }
            }
        }
        throw new TLSException("No server host: " + serverName + " in the server certificate. Provided in certificate: " + F.A0(list, null, null, null, 0, null, null, 63, null), null, 2, null);
    }

    public static final void verifyIpInCertificate(String ipString, X509Certificate certificate) throws CertificateParsingException, TLSException {
        p.i(ipString, "ipString");
        p.i(certificate, "certificate");
        Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : subjectAlternativeNames) {
                Object obj2 = ((List) obj).get(0);
                p.g(obj2, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) obj2).intValue() == 7) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object obj3 = ((List) it.next()).get(1);
                p.g(obj3, "null cannot be cast to non-null type kotlin.String");
                arrayList2.add((String) obj3);
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            if (!arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    if (p.d((String) it2.next(), ipString)) {
                        return;
                    }
                }
            }
            throw new TLSException("No server host: " + ipString + " in the server certificate. The certificate was issued for: " + F.A0(arrayList2, null, null, null, 0, null, null, 63, null) + '.', null, 2, null);
        }
    }
}
