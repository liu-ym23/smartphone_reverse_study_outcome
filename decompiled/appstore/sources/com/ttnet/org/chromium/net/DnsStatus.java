package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android")
public class DnsStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f18368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18369c;

    public DnsStatus(List r10, boolean r11, String r12) {
        this.f18367a = r10;
        this.f18368b = r11;
        if (r12 != null) goto L6;
        r12 = "";
    L6:
        this.f18369c = r12;
    }

    @CalledByNative
    public byte[][] getDnsServers() {
        byte[][] r10 = new byte[this.f18367a.size()][];
        int r11 = 0;
    L4:
        if (r11 >= this.f18367a.size()) goto L6;
        r10[r11] = ((InetAddress) this.f18367a.get(r11)).getAddress();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    @CalledByNative
    public boolean getPrivateDnsActive() {
        return this.f18368b;
    }

    @CalledByNative
    public String getPrivateDnsServerName() {
        return this.f18369c;
    }
}
