package okhttp3.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.l;

/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l> f39856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f39857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39859d;

    public b(List<l> r3) {
        List<l> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "connectionSpecs");
        this.f39856a = r4;
    }

    public final l a(SSLSocket r6) {
        o.e(r6, "sslSocket");
        int r0 = this.f39857b;
        int r1 = this.f39856a.size();
    L3:
        if (r0 >= r1) goto L8;
        l r2 = (l) ZeusTransformUtils.preCheckCast(this.f39856a.get(r0), l.class, "com.obric.aiagent.plugin");
        if (r2.a(r6) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        this.f39857b = r0 + 1;
    L9:
        if (r2 == null) goto L12;
        this.f39858c = b(r6);
        r2.a(r6, this.f39859d);
        return r2;
    L12:
        StringBuilder r5 = new StringBuilder().append("Unable to find acceptable protocols. isFallback=").append(this.f39859d).append(", modes=").append(this.f39856a).append(", supported protocols=");
        String[] r7 = r6.getEnabledProtocols();
        o.a(r7);
        String r8 = Arrays.toString(r7);
        o.c(r8, "toString(this)");
        throw new UnknownServiceException(r5.append(r8).toString());
    L8:
        r2 = null;
        goto L9
    }

    public final boolean a(IOException r4) {
        o.e(r4, "e");
        this.f39859d = true;
        if (this.f39858c == true) goto L6;
    L21:
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ProtocolException.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, InterruptedIOException.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, SSLHandshakeException.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r4.getCause(), CertificateException.class) == true) goto L21;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, SSLPeerUnverifiedException.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, SSLException.class) == false) goto L21;
        return true;
    }

    private final boolean b(SSLSocket r6) {
        int r0 = this.f39857b;
        int r1 = this.f39856a.size();
    L3:
        if (r0 >= r1) goto L9;
        if (((l) ZeusTransformUtils.preCheckCast(this.f39856a.get(r0), l.class, "com.obric.aiagent.plugin")).a(r6) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
