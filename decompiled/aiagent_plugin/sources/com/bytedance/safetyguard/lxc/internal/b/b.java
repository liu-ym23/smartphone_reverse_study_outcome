package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IpAddressClassifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f9729b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9730c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f9731d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f9732e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    public static final b k = null;
    public static final b l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    private static final /* synthetic */ b[] p = null;
    private static final /* synthetic */ d.d.a q = null;

    private static final /* synthetic */ b[] a() {
        return new b[]{f9728a, f9729b, f9730c, f9731d, f9732e, f, g, h, i, j, k, l, m, n, o};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(p.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f9728a = new b("PUBLIC", 0);
        f9729b = new b("UNSPECIFIED", 1);
        f9730c = new b("LOOPBACK", 2);
        f9731d = new b("LINK_LOCAL", 3);
        f9732e = new b("RFC1918", 4);
        f = new b("CGNAT", 5);
        g = new b("ULA", 6);
        h = new b("SITE_LOCAL", 7);
        i = new b("MULTICAST", 8);
        j = new b("RESERVED", 9);
        k = new b("DOCUMENTATION", 10);
        l = new b("BENCHMARK", 11);
        m = new b("TRANSITION", 12);
        n = new b("IPV4_MAPPED", 13);
        o = new b("METADATA", 14);
        b[] r0 = a();
        p = r0;
        q = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
