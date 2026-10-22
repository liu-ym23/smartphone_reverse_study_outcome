package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: InetSocketAddressSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends ai<InetSocketAddress> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((InetSocketAddress) ZeusTransformUtils.preCheckCast(r3, InetSocketAddress.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((InetSocketAddress) ZeusTransformUtils.preCheckCast(r3, InetSocketAddress.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    public q() {
        super(InetSocketAddress.class);
    }

    public void a(InetSocketAddress r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        InetAddress r2 = r3.getAddress();
        if (r2 != null) goto L5;
        String r6 = r3.getHostName();
    L6:
        int r0 = r6.indexOf(47);
        if (r0 < 0) goto L15;
        if (r0 == 0) goto L10;
        r6 = r6.substring(0, r0);
        goto L15
    L10:
        if (ZeusTransformUtils.instanceOf(r2, Inet6Address.class) == false) goto L12;
        String r7 = "[" + r6.substring(1) + "]";
    L13:
        r6 = r7;
        goto L15
    L12:
        r7 = r6.substring(1);
    L15:
        r4.b(r6 + ":" + r3.getPort());
        return;
    L5:
        r6 = r2.toString().trim();
        goto L6
    }

    public void a(InetSocketAddress r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r3, InetSocketAddress.class, com.fasterxml.jackson.a.n.h));
        a(r3, r4, r5);
        r6.b(r4, r0);
    }
}
