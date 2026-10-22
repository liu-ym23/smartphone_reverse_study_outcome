package com.obric.aiagent.skill.credentials.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f18949a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ f[] f18950e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f18953d;

    private static final /* synthetic */ f[] b() {
        return new f[]{f18949a};
    }

    private f(String r1, int r2, String r3, String r4, boolean r5) {
        super(r1, r2);
        this.f18951b = r3;
        this.f18952c = r4;
        this.f18953d = r5;
    }

    public final String a() {
        return this.f18951b;
    }

    static {
        f18949a = new f("LARK", 0, "lark", "Feishu", true);
        f[] r0 = b();
        f18950e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f18950e.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
