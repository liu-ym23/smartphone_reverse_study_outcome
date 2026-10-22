package com.obric.agent.trace;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntentResultStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f15582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f15583b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f15584c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f15585d = null;
    private static final /* synthetic */ n[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15586e;

    private static final /* synthetic */ n[] a() {
        return new n[]{f15582a, f15583b, f15584c, f15585d};
    }

    private n(String r1, int r2, int r3) {
        super(r1, r2);
        this.f15586e = r3;
    }

    static {
        f15582a = new n("COMPLETED", 0, 0);
        f15583b = new n("CANCELED", 1, 2);
        f15584c = new n("ABORTED", 2, 3);
        f15585d = new n("FAILED", 3, 999);
        n[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f.clone(), n[].class, "com.obric.aiagent.plugin");
    }
}
