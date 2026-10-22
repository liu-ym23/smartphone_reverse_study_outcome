package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import com.bytedance.safetyguard.lxc.api.OutboundPolicyEvaluator;
import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxyServiceConfigParcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.a<SidecarAuthHandler> f11002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.d.s f11003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final aa f11004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.b.a f11005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.safetyguard.lxc.internal.d.n f11006e;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.service.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
    static final class AnonymousClass1 extends d.h.b.p implements d.h.a.a<SidecarAuthHandler> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f11007a = null;

        static {
            f11007a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ SidecarAuthHandler invoke() {
            return a();
        }

        public final SidecarAuthHandler a() {
            return SidecarAuthHandler.Companion.notImplemented();
        }
    }

    public c() {
        this(null, null, null, null, null, 31, null);
    }

    public c(d.h.a.a<? extends SidecarAuthHandler> r3, com.bytedance.safetyguard.lxc.internal.d.s r4, aa r5, com.bytedance.safetyguard.lxc.internal.b.a r6, com.bytedance.safetyguard.lxc.internal.d.n r7) {
        d.h.a.a<SidecarAuthHandler> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.s r9 = (com.bytedance.safetyguard.lxc.internal.d.s) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.safetyguard.lxc.internal.d.s.class, "com.obric.aiagent.plugin");
        aa r10 = (aa) ZeusTransformUtils.wrapperContextForParams(r5, aa.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.b.a r11 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "sidecarAuthHandlerProvider");
        d.h.b.o.e(r9, "logger");
        d.h.b.o.e(r10, "ioFactory");
        d.h.b.o.e(r11, "dnsResolver");
        d.h.b.o.e(r7, "addressConnector");
        this.f11002a = r8;
        this.f11003b = r9;
        this.f11004c = r10;
        this.f11005d = r11;
        this.f11006e = r7;
    }

    public /* synthetic */ c(d.h.a.a r8, com.bytedance.safetyguard.lxc.internal.d.s r9, aa r10, com.bytedance.safetyguard.lxc.internal.b.a r11, com.bytedance.safetyguard.lxc.internal.d.n r12, int r13, d.h.b.h r14) {
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.d.s r16 = (com.bytedance.safetyguard.lxc.internal.d.s) ZeusTransformUtils.wrapperContextForParams(r9, com.bytedance.safetyguard.lxc.internal.d.s.class, "com.obric.aiagent.plugin");
        aa r17 = (aa) ZeusTransformUtils.wrapperContextForParams(r10, aa.class, "com.obric.aiagent.plugin");
        com.bytedance.safetyguard.lxc.internal.b.a r18 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        r15 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f11007a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        d.h.a.a r2 = r15;
        if ((r13 & 2) == 0) goto L8;
        r16 = (com.bytedance.safetyguard.lxc.internal.d.s) ZeusTransformUtils.preCheckCast(com.bytedance.safetyguard.lxc.internal.d.c.f10185a, com.bytedance.safetyguard.lxc.internal.d.s.class, "com.obric.aiagent.plugin");
    L8:
        com.bytedance.safetyguard.lxc.internal.d.s r3 = r16;
        if ((r13 & 4) == 0) goto L11;
        r17 = (aa) ZeusTransformUtils.preCheckCast(k.f11035a, aa.class, "com.obric.aiagent.plugin");
    L11:
        aa r4 = r17;
        if ((r13 & 8) == 0) goto L14;
        r18 = (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.preCheckCast(v.f11058a, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin");
    L14:
        com.bytedance.safetyguard.lxc.internal.b.a r5 = r18;
        if ((r13 & 16) == 0) goto L17;
        r12 = new com.bytedance.safetyguard.lxc.internal.d.n(null, null, 3, null);
    L17:
        this(r2, r3, r4, r5, r12);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.service.ad
    public ac create(ParcelFileDescriptor r23, ProxyServiceConfigParcel r24, OutboundPolicyEvaluator r25, com.bytedance.safetyguard.lxc.internal.d.a r26, af r27) {
        OutboundPolicyEvaluator r2 = (OutboundPolicyEvaluator) ZeusTransformUtils.wrapperContextForParams(r25, OutboundPolicyEvaluator.class, "com.obric.aiagent.plugin");
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r27, af.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r23, "sessionFd");
        d.h.b.o.e(r24, "config");
        d.h.b.o.e(r2, "businessPolicy");
        d.h.b.o.e(r26, "actionController");
        d.h.b.o.e(r4, "listener");
        z r1 = this.f11004c.a(r23);
        com.bytedance.safetyguard.lxc.internal.d.e r5 = new com.bytedance.safetyguard.lxc.internal.d.e(r1.a(), r1.b(), new com.bytedance.safetyguard.lxc.internal.d.r(r24.getConnectTimeoutMillis(), r24.getHelloTimeoutMillis(), 0, 0, r24.getMaxPendingBytes(), r24.getMaxStreams(), 12, null), (com.bytedance.safetyguard.lxc.internal.b.n) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.b.r(w.a(r24), this.f11005d, r2), com.bytedance.safetyguard.lxc.internal.b.n.class, "com.obric.aiagent.plugin"), (SidecarAuthHandler) ZeusTransformUtils.preCheckCast(this.f11002a.invoke(), SidecarAuthHandler.class, "com.obric.aiagent.plugin"), r26, this.f11003b, null, this.f11006e, 128, null);     // Catch: Exception -> L6
        return (ac) ZeusTransformUtils.preCheckCast(new b(r5, r4, this.f11003b), ac.class, "com.obric.aiagent.plugin");
    L6:
        e = move-exception;
        r1.close();
        throw e;
    }
}
