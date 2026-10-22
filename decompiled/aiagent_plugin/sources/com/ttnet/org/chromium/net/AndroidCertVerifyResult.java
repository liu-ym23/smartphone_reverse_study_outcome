package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidCertVerifyResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<X509Certificate> f37783c;

    public AndroidCertVerifyResult(int r3, boolean r4, List<X509Certificate> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f37781a = r3;
        this.f37782b = r4;
        this.f37783c = new ArrayList(r6);
    }

    public AndroidCertVerifyResult(int r1) {
        this.f37781a = r1;
        this.f37782b = false;
        this.f37783c = Collections.emptyList();
    }

    public int getStatus() {
        return this.f37781a;
    }

    public boolean isIssuedByKnownRoot() {
        return this.f37782b;
    }

    public byte[][] getCertificateChainEncoded() {
        byte[][] r0 = new byte[this.f37783c.size()][];
        int r2 = 0;
    L10:
        if (r2 >= this.f37783c.size()) goto L7;
        r0[r2] = ((X509Certificate) ZeusTransformUtils.preCheckCast(this.f37783c.get(r2), X509Certificate.class, "com.obric.aiagent.plugin")).getEncoded();     // Catch: CertificateEncodingException -> L8
        r2 = r2 + 1;
        goto L10
    L7:
        return r0;
    L9:
        return new byte[0][];
    }
}
