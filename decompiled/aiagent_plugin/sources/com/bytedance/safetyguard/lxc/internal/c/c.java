package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: ProxyTlv.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f9814b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f9815c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f9816d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f9817e = null;
    private static final /* synthetic */ c[] g = null;
    private static final /* synthetic */ d.d.a h = null;
    private final int f;

    /* JADX INFO: compiled from: ProxyTlv.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final c a(int r5) {
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(c.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L11;
            Object r0 = r4.next();
            if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).a() != r5) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L4;
        L12:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            return r6;
        L16:
            throw new k("Unsupported ingress proxy: " + r5, null, 2, null);
        L8:
            r3 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }
    }

    public static d.d.a<c> b() {
        return h;
    }

    private static final /* synthetic */ c[] c() {
        return new c[]{f9814b, f9815c, f9816d, f9817e};
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(g.clone(), c[].class, "com.obric.aiagent.plugin");
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f = r3;
    }

    public final int a() {
        return this.f;
    }

    static {
        f9814b = new c("HTTP_FORWARD", 0, 1);
        f9815c = new c("HTTP_CONNECT", 1, 2);
        f9816d = new c("SOCKS5_CONNECT", 2, 3);
        f9817e = new c("SIDECAR_AUTH", 3, 4);
        c[] r0 = c();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f9813a = new a(null);
    }
}
