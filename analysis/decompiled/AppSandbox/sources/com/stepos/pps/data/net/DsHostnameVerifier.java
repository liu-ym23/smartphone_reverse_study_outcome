package com.stepos.pps.data.net;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class DsHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    public static final DsHostnameVerifier INSTANCE = new DsHostnameVerifier();

    private DsHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return verifyHostname(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLPeerUnverifiedException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean verifyHostname(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        int size = subjectAltNames.size();
        for (int i = 0; i < size; i++) {
            if (verifyHostname(lowerCase, subjectAltNames.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static List<String> getSubjectAltNames(X509Certificate x509Certificate, int i) throws CertificateParsingException {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.EMPTY_LIST;
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    public static boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (lowerCase.contains("*")) {
                return lowerCase.startsWith("*.") && lowerCase.indexOf(42, 1) == -1 && str.length() >= lowerCase.length() && !"*.".equals(lowerCase) && str.endsWith(lowerCase.substring(1));
            }
            return str.equals(lowerCase);
        }
        return false;
    }
}
