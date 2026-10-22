package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum r extends Enum<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f26705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f26706b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f26707c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f26708d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r f26709e = null;
    private static final /* synthetic */ r[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ r[] a() {
        return new r[]{f26705a, f26706b, f26707c, f26708d, f26709e};
    }

    private r(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26705a = new r("NEXT_STEP", 0);
        f26706b = new r("REPLACED", 1);
        f26707c = new r("SESSION_CLEANSE", 2);
        f26708d = new r("UPSTREAM_CANCELLED", 3);
        f26709e = new r("CANCELLED_BEFORE_START", 4);
        r[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static r valueOf(String r2) {
        return (r) ZeusTransformUtils.preCheckCast(Enum.valueOf(r.class, r2), r.class, "com.obric.aiagent.plugin");
    }

    public static r[] values() {
        return (r[]) ZeusTransformUtils.preCheckCast(f.clone(), r[].class, "com.obric.aiagent.plugin");
    }
}
