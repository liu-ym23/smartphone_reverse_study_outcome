package okhttp3.internal.k;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import e.ac;
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

/* JADX INFO: compiled from: OkHostnameVerifier.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f40154a = null;

    static {
        f40154a = new d();
    }

    private d() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r4, SSLSession r5) {
        SSLSession r6 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r5, SSLSession.class, "com.obric.aiagent.plugin");
        o.e(r4, "host");
        o.e(r6, SensitiveType.SESSION);
        if (b(r4) == false) goto L11;
        Certificate r7 = r6.getPeerCertificates()[0];     // Catch: SSLException -> L8
        o.a(r7, "null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: SSLException -> L8
        return a(r4, (X509Certificate) ZeusTransformUtils.preCheckCast(r7, X509Certificate.class, "com.obric.aiagent.plugin"));
    L12:
        return false;
    L11:
        return false;
    }

    public final boolean a(String r2, X509Certificate r3) {
        o.e(r2, "host");
        o.e(r3, "certificate");
        if (okhttp3.internal.c.b(r2) == false) goto L6;
        return b(r2, r3);
    L6:
        return c(r2, r3);
    }

    private final boolean b(String r4, X509Certificate r5) {
        String r6 = okhttp3.internal.a.a(r4);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(a(r5, 7), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r3.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        if (o.a(r6, okhttp3.internal.a.a((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final boolean c(String r4, X509Certificate r5) {
        String r6 = a(r4);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(a(r5, 2), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r3.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (f40154a.a(r6, r8) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final String a(String r2) {
        if (b(r2) == false) goto L6;
        Locale r1 = Locale.US;
        o.c(r1, "US");
        String r3 = r2.toLowerCase(r1);
        o.c(r3, "this as java.lang.String).toLowerCase(locale)");
        return r3;
    L6:
        return r2;
    }

    private final boolean b(String r4) {
        if (r4.length() != ((int) ac.a(r4, 0, 0, 3, null))) goto L6;
        return true;
    L6:
        return false;
    }

    private final boolean a(String r14, String r15) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
    L58:
        return false;
    L11:
        if (d.o.o.b(r14, ".", false, 2, null) == true) goto L58;
        if (d.o.o.c(r14, DownloadConstants.VULNERABILITY_PATH, false, 2, null) == true) goto L58;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == true) goto L58;
        if (d.o.o.b(r15, ".", false, 2, null) == true) goto L58;
        if (d.o.o.c(r15, DownloadConstants.VULNERABILITY_PATH, false, 2, null) == true) goto L58;
        if (d.o.o.c(r14, ".", false, 2, null) == true) goto L32;
        r14 = r14 + '.';
    L32:
        if (d.o.o.c(r15, ".", false, 2, null) == true) goto L34;
        r15 = r15 + '.';
    L34:
        String r13 = a(r15);
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L39;
        return o.a(r14, r13);
    L39:
        if (d.o.o.b(r13, "*.", false, 2, null) == false) goto L58;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), '*', 1, false, 4, null) != (-1)) goto L58;
        if (r14.length() >= r13.length()) goto L47;
        return false;
    L47:
        if (o.a("*.", r13) == false) goto L49;
        return false;
    L49:
        String r16 = r13.substring(1);
        o.c(r16, "this as java.lang.String).substring(startIndex)");
        if (d.o.o.c(r14, r16, false, 2, null) == true) goto L52;
        return false;
    L52:
        int r17 = r14.length() - r16.length();
        if (r17 > 0) goto L55;
    L57:
        return true;
    L55:
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), '.', r17 - 1, false, 4, null) == (-1)) goto L57;
        return false;
    L18:
        if (r7.length() == 0) goto L21;
        r8 = false;
        goto L22
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final List<String> a(X509Certificate r3) {
        o.e(r3, "certificate");
        List<String> r0 = a(r3, 7);
        List<String> r2 = a(r3, 2);
        return p.c((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final List<String> a(X509Certificate r5, int r6) {
        Collection<List<?>> r7 = r5.getSubjectAlternativeNames();     // Catch: CertificateParsingException -> L23
        if (r7 == null) goto L6;
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: CertificateParsingException -> L23
        Iterator<List<?>> r8 = r7.iterator();     // Catch: CertificateParsingException -> L23
    L9:
        if (r8.hasNext() == false) goto L22;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r8.next(), List.class, "com.obric.aiagent.plugin");     // Catch: CertificateParsingException -> L23
        if (r1 == null) goto L9;
        if (r1.size() < 2) goto L9;
        if (o.a(r1.get(0), Integer.valueOf(r6)) == false) goto L9;
        Object r2 = r1.get(1);     // Catch: CertificateParsingException -> L23
        if (r2 == null) goto L9;
        r0.add((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));     // Catch: CertificateParsingException -> L23
        goto L9
    L22:
        return r0;
    L6:
        return p.b();
    L24:
        return p.b();
    }
}
