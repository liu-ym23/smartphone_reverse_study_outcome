package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppPrewarmTelemetry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f28263a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f28264b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f28265c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ i[] f28266e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28267d;

    private static final /* synthetic */ i[] b() {
        return new i[]{f28263a, f28264b, f28265c};
    }

    private i(String r1, int r2, String r3) {
        super(r1, r2);
        this.f28267d = r3;
    }

    public final String a() {
        return this.f28267d;
    }

    static {
        f28263a = new i("SUCCESS", 0, "success");
        f28264b = new i("FAILURE", 1, "failure");
        f28265c = new i("MISS", 2, "miss");
        i[] r0 = b();
        f28266e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static i valueOf(String r2) {
        return (i) ZeusTransformUtils.preCheckCast(Enum.valueOf(i.class, r2), i.class, "com.obric.aiagent.plugin");
    }

    public static i[] values() {
        return (i[]) ZeusTransformUtils.preCheckCast(f28266e.clone(), i[].class, "com.obric.aiagent.plugin");
    }
}
