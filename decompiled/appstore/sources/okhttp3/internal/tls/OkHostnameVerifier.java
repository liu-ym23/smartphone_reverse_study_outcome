package okhttp3.internal.tls;

import com.bytedance.librarian.LibrarianImpl;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = null;

    static {
        INSTANCE = new OkHostnameVerifier();
    }

    private OkHostnameVerifier() {
    }

    public static List<String> allSubjectAltNames(X509Certificate r10) {
        List<String> r11 = getSubjectAltNames(r10, 7);
        List<String> r12 = getSubjectAltNames(r10, 2);
        ArrayList r13 = new ArrayList(r11.size() + r12.size());
        r13.addAll(r11);
        r13.addAll(r12);
        return r13;
    }

    private static List<String> getSubjectAltNames(X509Certificate r10, int r11) {
        ArrayList r12 = new ArrayList();
        Collection<List<?>> r13 = r10.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L25
        if (r13 == null) goto L6;
        Iterator<List<?>> r14 = r13.iterator();     // Catch: CertificateParsingException -> L25
    L9:
        if (r14.hasNext() == false) goto L24;
        List<?> r15 = r14.next();     // Catch: CertificateParsingException -> L25
        if (r15 == null) goto L9;
        if (r15.size() < 2) goto L9;
        Integer r16 = (Integer) r15.get(0);     // Catch: CertificateParsingException -> L25
        if (r16 == null) goto L9;
        if (r16.intValue() != r11) goto L9;
        String r17 = (String) r15.get(1);     // Catch: CertificateParsingException -> L25
        if (r17 == null) goto L9;
        r12.add(r17);     // Catch: CertificateParsingException -> L25
        goto L9
    L24:
        return r12;
    L6:
        return Collections.emptyList();
    L26:
        return Collections.emptyList();
    }

    private boolean verifyHostname(String r10, X509Certificate r11) {
        String r12 = r10.toLowerCase(Locale.US);
        Iterator<String> r13 = getSubjectAltNames(r11, 2).iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        if (verifyHostname(r12, r13.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean verifyIpAddress(String r10, X509Certificate r11) {
        List<String> r12 = getSubjectAltNames(r11, 7);
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        if (r10.equalsIgnoreCase(r12.get(r14)) == true) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r10, SSLSession r11) {
        return verify(r10, (X509Certificate) r11.getPeerCertificates()[0]);
    L5:
        return false;
    }

    public boolean verify(String r10, X509Certificate r11) {
        if (Util.verifyAsIpAddress(r10) == false) goto L6;
        return verifyIpAddress(r10, r11);
    L6:
        return verifyHostname(r10, r11);
    }

    public boolean verifyHostname(String r10, String r11) {
        if (r10 != null) goto L5;
    L49:
        return false;
    L5:
        if (r10.length() == 0) goto L49;
        if (r10.startsWith(LibrarianImpl.Constants.DOT) == true) goto L49;
        if (r10.endsWith("..") == true) goto L49;
        if (r11 == null) goto L49;
        if (r11.length() == 0) goto L49;
        if (r11.startsWith(LibrarianImpl.Constants.DOT) == true) goto L49;
        if (r11.endsWith("..") == true) goto L49;
        if (r10.endsWith(LibrarianImpl.Constants.DOT) == true) goto L23;
        r10 = r10 + '.';
    L23:
        if (r11.endsWith(LibrarianImpl.Constants.DOT) == true) goto L25;
        r11 = r11 + '.';
    L25:
        String r12 = r11.toLowerCase(Locale.US);
        if (r12.contains("*") == true) goto L30;
        return r10.equals(r12);
    L30:
        if (r12.startsWith("*.") == false) goto L49;
        if (r12.indexOf(42, 1) != (-1)) goto L49;
        if (r10.length() >= r12.length()) goto L38;
        return false;
    L38:
        if ("*.".equals(r12) == false) goto L40;
        return false;
    L40:
        String r13 = r12.substring(1);
        if (r10.endsWith(r13) == true) goto L43;
        return false;
    L43:
        int r14 = r10.length() - r13.length();
        if (r14 > 0) goto L46;
    L48:
        return true;
    L46:
        if (r10.lastIndexOf(46, r14 - 1) == (-1)) goto L48;
        return false;
    }
}
