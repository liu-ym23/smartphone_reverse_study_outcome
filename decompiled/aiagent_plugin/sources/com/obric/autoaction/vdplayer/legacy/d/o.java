package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f25926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f25927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f25928c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ o[] f25929d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25930e = null;

    private static final /* synthetic */ o[] a() {
        return new o[]{f25926a, f25927b, f25928c};
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25926a = new o("NONE", 0);
        f25927b = new o("CALL_USER", 1);
        f25928c = new o("MANUAL_OP", 2);
        o[] r0 = a();
        f25929d = r0;
        f25930e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(f25929d.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
