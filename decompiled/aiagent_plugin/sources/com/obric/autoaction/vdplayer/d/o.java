package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f25519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f25520b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f25521c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ o[] f25522d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f25523e = null;

    private static final /* synthetic */ o[] a() {
        return new o[]{f25519a, f25520b, f25521c};
    }

    private o(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f25519a = new o("NONE", 0);
        f25520b = new o("CALL_USER", 1);
        f25521c = new o("MANUAL_OP", 2);
        o[] r0 = a();
        f25522d = r0;
        f25523e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(f25522d.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
