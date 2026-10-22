package com.obric.autogui.session.state.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f31347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f31348b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ n[] f31349d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f31350e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f31351c;

    private static final /* synthetic */ n[] b() {
        return new n[]{f31347a, f31348b};
    }

    private n(String r1, int r2, String r3) {
        super(r1, r2);
        this.f31351c = r3;
    }

    public final String a() {
        return this.f31351c;
    }

    static {
        f31347a = new n("PRELOADED", 0, "preloaded");
        f31348b = new n("SYNCHRONOUS", 1, "synchronous");
        n[] r0 = b();
        f31349d = r0;
        f31350e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f31349d.clone(), n[].class, "com.obric.aiagent.plugin");
    }
}
