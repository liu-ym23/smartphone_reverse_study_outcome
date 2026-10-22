package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f9759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.c.l f9760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ProxySessionErrorCode f9761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9762e;

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final j a(String r4) {
            k r0 = k.f9763a;
            com.bytedance.safetyguard.lxc.internal.c.l r1 = com.bytedance.safetyguard.lxc.internal.c.l.h;
            ProxySessionErrorCode r2 = ProxySessionErrorCode.MALFORMED_FRAME;
            if (r4 != null) goto L6;
            r4 = "Malformed outbound target";
        L6:
            return new j(r0, r1, r2, r4);
        }

        public final j b(String r4) {
            d.h.b.o.e(r4, "reason");
            return new j(k.f9764b, com.bytedance.safetyguard.lxc.internal.c.l.f9849c, ProxySessionErrorCode.SSRF_BLOCKED, r4);
        }

        public static /* synthetic */ j a(a r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = "DNS returned no addresses";
        L6:
            return r0.c(r1);
        }

        public final j c(String r4) {
            d.h.b.o.e(r4, "reason");
            return new j(k.f9765c, com.bytedance.safetyguard.lxc.internal.c.l.f9850d, ProxySessionErrorCode.DNS_FAILED, r4);
        }

        public final j d(String r4) {
            d.h.b.o.e(r4, "reason");
            return new j(k.f9766d, com.bytedance.safetyguard.lxc.internal.c.l.f9849c, ProxySessionErrorCode.BUSINESS_POLICY_DENIED, r4);
        }
    }

    static {
        f9758a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (this.f9759b == r6.f9759b) goto L12;
        return false;
    L12:
        if (this.f9760c == r6.f9760c) goto L15;
        return false;
    L15:
        if (this.f9761d == r6.f9761d) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f9762e, r6.f9762e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f9759b.hashCode() * 31) + this.f9760c.hashCode()) * 31) + this.f9761d.hashCode()) * 31) + this.f9762e.hashCode();
    }

    public String toString() {
        return "OutboundSecurityFailure(stage=" + this.f9759b + ", wireResultCode=" + this.f9760c + ", errorCode=" + this.f9761d + ", reason=" + this.f9762e + ')';
    }

    public j(k r2, com.bytedance.safetyguard.lxc.internal.c.l r3, ProxySessionErrorCode r4, String r5) {
        d.h.b.o.e(r2, "stage");
        d.h.b.o.e(r3, "wireResultCode");
        d.h.b.o.e(r4, "errorCode");
        d.h.b.o.e(r5, "reason");
        this.f9759b = r2;
        this.f9760c = r3;
        this.f9761d = r4;
        this.f9762e = r5;
    }

    public final k a() {
        return this.f9759b;
    }

    public final com.bytedance.safetyguard.lxc.internal.c.l b() {
        return this.f9760c;
    }

    public final ProxySessionErrorCode c() {
        return this.f9761d;
    }

    public final String d() {
        return this.f9762e;
    }
}
