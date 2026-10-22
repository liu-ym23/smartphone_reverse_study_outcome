package com.bytedance.frameworks.baselib.network.connectionclass;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConnectionQuality.java */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8053b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8054c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f8055d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8056e = null;
    private static final /* synthetic */ b[] f = null;

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        b r0 = new b("POOR", 0);
        f8052a = r0;
        b r1 = new b("MODERATE", 1);
        f8053b = r1;
        b r3 = new b("GOOD", 2);
        f8054c = r3;
        b r5 = new b("EXCELLENT", 3);
        f8055d = r5;
        b r7 = new b("UNKNOWN", 4);
        f8056e = r7;
        f = new b[]{r0, r1, r3, r5, r7};
    }
}
