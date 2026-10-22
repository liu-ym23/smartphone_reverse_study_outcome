package com.bytedance.safetyguard.lxc.internal.service;

import com.bytedance.safetyguard.lxc.api.OutboundIngressProxy;
import com.bytedance.safetyguard.lxc.api.OutboundTarget;
import com.bytedance.safetyguard.lxc.api.OutboundTargetType;
import com.bytedance.safetyguard.lxc.internal.ipc.OutboundTargetParcel;

/* JADX INFO: compiled from: ServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ae {

    /* JADX INFO: compiled from: ServiceProxySession.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10934a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10935b = null;

        static {
            int[] r0 = new int[OutboundTargetType.values().length];
            r0[OutboundTargetType.DOMAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[OutboundTargetType.IPV4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r0[OutboundTargetType.IPV6.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f10934a = r0;
            int[] r1 = new int[OutboundIngressProxy.values().length];
            r1[OutboundIngressProxy.HTTP_FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[OutboundIngressProxy.HTTP_CONNECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r1[OutboundIngressProxy.SOCKS5_CONNECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[OutboundIngressProxy.SIDECAR_AUTH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f10935b = r1;
        }
    }

    public static final /* synthetic */ OutboundTargetParcel a(OutboundTarget r0) {
        return b(r0);
    }

    private static final OutboundTargetParcel b(OutboundTarget r9) {
        String r2 = r9.getHost();
        int r3 = r9.getPort();
        int r0 = a.f10934a[r9.getType().ordinal()];
        int r5 = 2;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L8;
        int r7 = 2;
    L11:
        int r10 = a.f10935b[r9.getIngressProxy().ordinal()];
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L20;
        if (r10 == 3) goto L23;
        if (r10 != 4) goto L19;
        r5 = 3;
        goto L23
    L19:
        throw new d.k();
    L23:
        return new OutboundTargetParcel(0, r2, r3, r7, r5, 1, null);
    L20:
        r5 = 1;
        goto L23
    L21:
        r5 = 0;
        goto L23
    L8:
        throw new d.k();
    L9:
        r7 = 1;
        goto L11
    L10:
        r7 = 0;
        goto L11
    }
}
