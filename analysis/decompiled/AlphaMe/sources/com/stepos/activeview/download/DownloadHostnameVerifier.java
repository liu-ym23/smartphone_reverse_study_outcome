package com.stepos.activeview.download;

import com.stepos.activeview.utils.ReflectHelper;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class DownloadHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final DownloadHostnameVerifier INSTANCE = new DownloadHostnameVerifier();

    private DownloadHostnameVerifier() {
    }

    private List<String> getSubjectAltNames(X509Certificate x509Certificate, int i4) throws CertificateParsingException {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i4 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean isNumeric(String str) {
        try {
            return ((Boolean) ReflectHelper.invokeStatic("java.net.InetAddress", "isNumeric", new String[]{str})).booleanValue();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private boolean verifyHostName(String str, X509Certificate x509Certificate) {
        String strFindMostSpecific;
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = getSubjectAltNames(x509Certificate, 2).iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            if (verifyHostName(lowerCase, it.next())) {
                return true;
            }
            z4 = true;
        }
        if (z4 || (strFindMostSpecific = new DownloadDistinguishedNameParser(x509Certificate.getSubjectX500Principal()).findMostSpecific("cn")) == null) {
            return false;
        }
        return verifyHostName(lowerCase, strFindMostSpecific);
    }

    private boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        Iterator<String> it = getSubjectAltNames(x509Certificate, 7).iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public boolean verify(String str, X509Certificate x509Certificate) {
        if (isNumeric(str)) {
            return verifyIpAddress(str, x509Certificate);
        }
        return verifyHostName(str, x509Certificate);
    }

    public boolean verifyHostName(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return false;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (lowerCase.startsWith("*.") && str.equals(lowerCase.substring(2))) {
            return true;
        }
        int iIndexOf = lowerCase.indexOf(42);
        if (iIndexOf > lowerCase.indexOf(46) || !str.regionMatches(0, lowerCase, 0, iIndexOf)) {
            return false;
        }
        int i4 = iIndexOf + 1;
        int length = lowerCase.length() - i4;
        int length2 = str.length() - length;
        if (str.indexOf(46, iIndexOf) >= length2 || str.endsWith(".clients.google.com")) {
            return str.regionMatches(length2, lowerCase, i4, length);
        }
        return false;
    }
}
