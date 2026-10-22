package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android")
public class AndroidCertVerifyResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f18361c;

    public AndroidCertVerifyResult(int r10, boolean r11, List r12) {
        this.f18359a = r10;
        this.f18360b = r11;
        this.f18361c = new ArrayList(r12);
    }

    @CalledByNative
    public byte[][] getCertificateChainEncoded() {
        byte[][] r10 = new byte[this.f18361c.size()][];
        int r11 = 0;
    L10:
        if (r11 >= this.f18361c.size()) goto L7;
        r10[r11] = ((X509Certificate) this.f18361c.get(r11)).getEncoded();     // Catch: CertificateEncodingException -> L8
        r11 = r11 + 1;
        goto L10
    L7:
        return r10;
    L9:
        return new byte[0][];
    }

    @CalledByNative
    public int getStatus() {
        return this.f18359a;
    }

    @CalledByNative
    public boolean isIssuedByKnownRoot() {
        return this.f18360b;
    }

    public AndroidCertVerifyResult(int r10) {
        this.f18359a = r10;
        this.f18360b = false;
        this.f18361c = Collections.emptyList();
    }
}
