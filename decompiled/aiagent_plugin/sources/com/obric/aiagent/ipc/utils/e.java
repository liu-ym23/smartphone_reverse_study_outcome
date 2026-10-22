package com.obric.aiagent.ipc.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IPCAnomalyDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f18666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f18667c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ e[] f18668e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18669d;

    private static final /* synthetic */ e[] b() {
        return new e[]{f18665a, f18666b, f18667c};
    }

    private e(String r1, int r2, String r3) {
        super(r1, r2);
        this.f18669d = r3;
    }

    public final String a() {
        return this.f18669d;
    }

    static {
        f18665a = new e("FAILURE", 0, "failure");
        f18666b = new e("SLOW", 1, "slow");
        f18667c = new e("FREQUENT", 2, "frequent");
        e[] r0 = b();
        f18668e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f18668e.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
