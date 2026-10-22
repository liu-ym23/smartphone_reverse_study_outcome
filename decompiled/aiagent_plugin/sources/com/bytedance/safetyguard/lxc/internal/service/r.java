package com.bytedance.safetyguard.lxc.internal.service;

import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ProxySessionRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f11052e;
    private final List<String> f;
    private final List<Integer> g;

    /* JADX INFO: compiled from: ProxySessionRegistry.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final r a(ProxyServiceConfigParcel r8) {
            d.h.b.o.e(r8, "config");
            return new r(r8.getConnectTimeoutMillis(), r8.getHelloTimeoutMillis(), r8.getMaxStreams(), r8.getMaxPendingBytes(), d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r8.getAllowedDomainRules(), Iterable.class, "com.obric.aiagent.plugin")), d.a.i.f(r8.getAllowedPorts()));
        }
    }

    static {
        f11048a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (this.f11049b == r6.f11049b) goto L12;
        return false;
    L12:
        if (this.f11050c == r6.f11050c) goto L15;
        return false;
    L15:
        if (this.f11051d == r6.f11051d) goto L18;
        return false;
    L18:
        if (this.f11052e == r6.f11052e) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f11049b) * 31) + Integer.hashCode(this.f11050c)) * 31) + Integer.hashCode(this.f11051d)) * 31) + Integer.hashCode(this.f11052e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "ProxyConfigFingerprint(connectTimeoutMillis=" + this.f11049b + ", helloTimeoutMillis=" + this.f11050c + ", maxStreams=" + this.f11051d + ", maxPendingBytes=" + this.f11052e + ", allowedDomainRules=" + this.f + ", allowedPorts=" + this.g + ')';
    }

    public r(int r3, int r4, int r5, int r6, List<String> r7, List<Integer> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "allowedDomainRules");
        d.h.b.o.e(r10, "allowedPorts");
        this.f11049b = r3;
        this.f11050c = r4;
        this.f11051d = r5;
        this.f11052e = r6;
        this.f = r9;
        this.g = r10;
    }
}
