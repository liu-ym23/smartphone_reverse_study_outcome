package com.bytedance.safetyguard.lxc.internal.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: ProxyServiceDnsResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v implements com.bytedance.safetyguard.lxc.internal.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f11058a = null;

    static {
        f11058a = new v();
    }

    private v() {
    }

    @Override // com.bytedance.safetyguard.lxc.internal.b.a
    public List<InetAddress> resolve(String r2) {
        d.h.b.o.e(r2, "host");
        InetAddress[] r1 = InetAddress.getAllByName(r2);
        d.h.b.o.c(r1, "getAllByName(...)");
        return d.a.i.g((Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.aiagent.plugin"));
    }
}
