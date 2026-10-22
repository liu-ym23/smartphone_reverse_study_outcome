package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyTlv.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f9862a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ q[] f9863c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f9864d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9865b;

    private static final /* synthetic */ q[] b() {
        return new q[]{f9862a};
    }

    public static q valueOf(String r2) {
        return (q) ZeusTransformUtils.preCheckCast(Enum.valueOf(q.class, r2), q.class, "com.obric.aiagent.plugin");
    }

    public static q[] values() {
        return (q[]) ZeusTransformUtils.preCheckCast(f9863c.clone(), q[].class, "com.obric.aiagent.plugin");
    }

    private q(String r1, int r2, int r3) {
        super(r1, r2);
        this.f9865b = r3;
    }

    public final int a() {
        return this.f9865b;
    }

    static {
        f9862a = new q("TCP", 0, 1);
        q[] r0 = b();
        f9863c = r0;
        f9864d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
