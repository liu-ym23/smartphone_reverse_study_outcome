package com.bytedance.safetyguard.lxc.internal.b;

import com.bytedance.safetyguard.lxc.api.OutboundIngressProxy;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTargetType;
import com.obric.capabilitykit.common.Ext;

/* JADX INFO: compiled from: PolicyDecisionMapper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f9784a = null;

    /* JADX INFO: compiled from: PolicyDecisionMapper.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9785a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f9786b = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.c.m.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9853b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9854c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9855d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f9785a = r0;
            int[] r1 = new int[com.bytedance.safetyguard.lxc.internal.c.c.values().length];
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9814b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9815c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9816d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[com.bytedance.safetyguard.lxc.internal.c.c.f9817e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f9786b = r1;
        }
    }

    static {
        f9784a = new p();
    }

    private p() {
    }

    public final OutboundTarget a(com.bytedance.safetyguard.lxc.internal.c.d r8) {
        d.h.b.o.e(r8, Ext.KEY_REQUEST);
        String r0 = r8.a();
        int r1 = r8.b();
        com.bytedance.safetyguard.lxc.internal.c.m r2 = r8.c();
        int r3 = a.f9785a[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 == 2) goto L9;
        if (r3 != 3) goto L8;
        OutboundTargetType r4 = OutboundTargetType.IPV6;
    L11:
        com.bytedance.safetyguard.lxc.internal.c.c r9 = r8.d();
        int r10 = a.f9786b[r9.ordinal()];
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L21;
        if (r10 != 3) goto L16;
        OutboundIngressProxy r11 = OutboundIngressProxy.SOCKS5_CONNECT;
    L24:
        return new OutboundTarget(r0, r1, r4, r11);
    L16:
        if (r10 != 4) goto L19;
        r11 = OutboundIngressProxy.SIDECAR_AUTH;
        goto L24
    L19:
        throw new d.k();
    L21:
        r11 = OutboundIngressProxy.HTTP_CONNECT;
        goto L24
    L22:
        r11 = OutboundIngressProxy.HTTP_FORWARD;
        goto L24
    L8:
        throw new d.k();
    L9:
        r4 = OutboundTargetType.IPV4;
        goto L11
    L10:
        r4 = OutboundTargetType.DOMAIN;
        goto L11
    }
}
