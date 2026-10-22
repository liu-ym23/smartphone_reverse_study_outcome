package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectDetectionModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f26442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f26443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f26444c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f26445d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f26446e = null;
    public static final k f = null;
    private static final /* synthetic */ k[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    private static final /* synthetic */ k[] a() {
        return new k[]{f26442a, f26443b, f26444c, f26445d, f26446e, f};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26442a = new k("EFFECTIVE", 0);
        f26443b = new k("SECURE", 1);
        f26444c = new k("PENDING", 2);
        f26445d = new k("INEFFECTIVE", 3);
        f26446e = new k("ERROR", 4);
        f = new k("UNKNOWN", 5);
        k[] r0 = a();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static k valueOf(String r2) {
        return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.aiagent.plugin");
    }

    public static k[] values() {
        return (k[]) ZeusTransformUtils.preCheckCast(g.clone(), k[].class, "com.obric.aiagent.plugin");
    }
}
