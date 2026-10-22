package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.safetyguard.lxc.api.OutboundIngressProxy;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTargetType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.c.m f9790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<InetAddress> f9791e;

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final q a(g r3, List<? extends InetAddress> r4) {
            g r2 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r2, "target");
            d.h.b.o.e(r5, "addresses");
            return new q(r2.a(), r2.b(), r2.getType(), r5);
        }
    }

    /* JADX INFO: compiled from: OutboundSecurityPipeline.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9792a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f9793b = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.c.m.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9853b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9854c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9855d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f9792a = r0;
            int[] r1 = new int[com.bytedance.safetyguard.lxc.internal.c.c.values().length];
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9814b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9815c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9816d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9817e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f9793b = r1;
        }
    }

    static {
        f9787a = new a(null);
    }

    public q(String r3, int r4, com.bytedance.safetyguard.lxc.internal.c.m r5, List<? extends InetAddress> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "host");
        d.h.b.o.e(r5, "type");
        d.h.b.o.e(r7, "addresses");
        this.f9788b = r3;
        this.f9789c = r4;
        this.f9790d = r5;
        List<InetAddress> r8 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"));
        this.f9791e = r8;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Resolved target requires at least one address".toString());
    }

    public final int a() {
        return this.f9789c;
    }

    public final com.bytedance.safetyguard.lxc.internal.c.m getType() {
        return this.f9790d;
    }

    public final List<InetAddress> b() {
        return this.f9791e;
    }

    public final OutboundTarget a(com.bytedance.safetyguard.lxc.internal.c.c r8) {
        d.h.b.o.e(r8, "ingressProxy");
        String r1 = this.f9788b;
        int r2 = this.f9789c;
        com.bytedance.safetyguard.lxc.internal.c.m r7 = this.f9790d;
        int r9 = b.f9792a[r7.ordinal()];
        if (r9 == 1) goto L10;
        if (r9 == 2) goto L9;
        if (r9 != 3) goto L8;
        OutboundTargetType r10 = OutboundTargetType.IPV6;
    L11:
        int r11 = b.f9793b[r8.ordinal()];
        if (r11 == 1) goto L22;
        if (r11 == 2) goto L21;
        if (r11 != 3) goto L16;
        OutboundIngressProxy r12 = OutboundIngressProxy.SOCKS5_CONNECT;
    L24:
        return new OutboundTarget(r1, r2, r10, r12);
    L16:
        if (r11 != 4) goto L19;
        r12 = OutboundIngressProxy.SIDECAR_AUTH;
        goto L24
    L19:
        throw new d.k();
    L21:
        r12 = OutboundIngressProxy.HTTP_CONNECT;
        goto L24
    L22:
        r12 = OutboundIngressProxy.HTTP_FORWARD;
        goto L24
    L8:
        throw new d.k();
    L9:
        r10 = OutboundTargetType.IPV4;
        goto L11
    L10:
        r10 = OutboundTargetType.DOMAIN;
        goto L11
    }
}
