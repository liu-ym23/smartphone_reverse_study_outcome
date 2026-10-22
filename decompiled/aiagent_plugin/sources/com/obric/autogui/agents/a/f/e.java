package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectResultModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f26412a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f26413b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f26414c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f26415d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ e[] f26416e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f26412a, f26413b, f26414c, f26415d};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26412a = new e("INEFFECTIVE", 0);
        f26413b = new e("UNKNOWN", 1);
        f26414c = new e("TIMEOUT", 2);
        f26415d = new e("DETECTOR_ERROR", 3);
        e[] r0 = a();
        f26416e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(f26416e.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
