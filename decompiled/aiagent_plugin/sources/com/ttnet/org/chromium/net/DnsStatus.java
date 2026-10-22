package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DnsStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<InetAddress> f37789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f37791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f37792d;

    public DnsStatus(List<InetAddress> r3, boolean r4, String r5, String r6) {
        this.f37789a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f37790b = r4;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        this.f37791c = r5;
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        this.f37792d = r6;
    }

    public byte[][] getDnsServers() {
        byte[][] r0 = new byte[this.f37789a.size()][];
        int r1 = 0;
    L4:
        if (r1 >= this.f37789a.size()) goto L6;
        r0[r1] = ((InetAddress) ZeusTransformUtils.preCheckCast(this.f37789a.get(r1), InetAddress.class, "com.obric.aiagent.plugin")).getAddress();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public boolean getPrivateDnsActive() {
        return this.f37790b;
    }

    public String getPrivateDnsServerName() {
        return this.f37791c;
    }

    public String getSearchDomains() {
        return this.f37792d;
    }
}
