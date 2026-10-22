package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f9848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f9849c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f9850d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f9851e = null;
    public static final l f = null;
    public static final l g = null;
    public static final l h = null;
    public static final l i = null;
    public static final l j = null;
    private static final /* synthetic */ l[] l = null;
    private static final /* synthetic */ d.d.a m = null;
    private final int k;

    /* JADX INFO: compiled from: ProxyResult.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ l[] b() {
        return new l[]{f9848b, f9849c, f9850d, f9851e, f, g, h, i, j};
    }

    public static l valueOf(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(Enum.valueOf(l.class, r2), l.class, "com.obric.aiagent.plugin");
    }

    public static l[] values() {
        return (l[]) ZeusTransformUtils.preCheckCast(l.clone(), l[].class, "com.obric.aiagent.plugin");
    }

    private l(String r1, int r2, int r3) {
        super(r1, r2);
        this.k = r3;
    }

    public final int a() {
        return this.k;
    }

    static {
        f9848b = new l("OK", 0, 0);
        f9849c = new l("POLICY_DENIED", 1, 1);
        f9850d = new l("DNS_FAILED", 2, 2);
        f9851e = new l("CONNECT_REFUSED", 3, 3);
        f = new l("CONNECT_TIMEOUT", 4, 4);
        g = new l("NETWORK_UNREACHABLE", 5, 5);
        h = new l("PROTOCOL_ERROR", 6, 6);
        i = new l("INTERNAL_ERROR", 7, 7);
        j = new l("RESOURCE_EXHAUSTED", 8, 8);
        l[] r0 = b();
        l = r0;
        m = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f9847a = new a(null);
    }
}
