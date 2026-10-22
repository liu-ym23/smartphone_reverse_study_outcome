package Ib;

import La.D;
import La.H;
import Mb.K;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.util.date.GMTDateParser;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import ub.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u0013\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b*\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"LIb/d;", "Ljavax/net/ssl/HostnameVerifier;", "<init>", "()V", "", "host", "Ljavax/net/ssl/SSLSession;", "session", "", "verify", "(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "Ljava/security/cert/X509Certificate;", "certificate", "e", "(Ljava/lang/String;Ljava/security/cert/X509Certificate;)Z", "", Const.INTENT_KEY_APIKEY, "(Ljava/security/cert/X509Certificate;)Ljava/util/List;", "ipAddress", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "hostname", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "pattern", "f", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "type", "c", "(Ljava/security/cert/X509Certificate;I)Ljava/util/List;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3429a = new d();

    public final List<String> a(X509Certificate certificate) throws CertificateParsingException {
        p.i(certificate, "certificate");
        return F.S0(c(certificate, 7), c(certificate, 2));
    }

    public final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale US = Locale.US;
        p.h(US, "US");
        String lowerCase = str.toLowerCase(US);
        p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final List<String> c(X509Certificate certificate, int type) throws CertificateParsingException {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return C1173v.m();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && p.d(list.get(0), Integer.valueOf(type)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return C1173v.m();
        }
    }

    public final boolean d(String str) {
        return str.length() == ((int) K.b(str, 0, 0, 3, null));
    }

    public final boolean e(String host, X509Certificate certificate) {
        p.i(host, "host");
        p.i(certificate, "certificate");
        return l.a(host) ? h(host, certificate) : g(host, certificate);
    }

    public final boolean f(String hostname, String pattern) {
        if (hostname != null && hostname.length() != 0 && !D.X(hostname, ".", false, 2, null) && !D.K(hostname, "..", false, 2, null) && pattern != null && pattern.length() != 0 && !D.X(pattern, ".", false, 2, null) && !D.K(pattern, "..", false, 2, null)) {
            if (!D.K(hostname, ".", false, 2, null)) {
                hostname = hostname + '.';
            }
            String str = hostname;
            if (!D.K(pattern, ".", false, 2, null)) {
                pattern = pattern + '.';
            }
            String strB = b(pattern);
            if (!H.g0(strB, "*", false, 2, null)) {
                return p.d(str, strB);
            }
            if (!D.X(strB, "*.", false, 2, null) || H.t0(strB, GMTDateParser.ANY, 1, false, 4, null) != -1 || str.length() < strB.length() || p.d("*.", strB)) {
                return false;
            }
            String strSubstring = strB.substring(1);
            p.h(strSubstring, "substring(...)");
            if (!D.K(str, strSubstring, false, 2, null)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || H.A0(str, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }

    public final boolean g(String hostname, X509Certificate certificate) throws CertificateParsingException {
        String strB = b(hostname);
        List<String> listC = c(certificate, 2);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            if (f3429a.f(strB, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(String ipAddress, X509Certificate certificate) throws CertificateParsingException {
        String strK = l.k(ipAddress);
        List<String> listC = c(certificate, 7);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            if (p.d(strK, l.k((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        p.i(host, "host");
        p.i(session, "session");
        if (!d(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            p.g(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return e(host, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }
}
