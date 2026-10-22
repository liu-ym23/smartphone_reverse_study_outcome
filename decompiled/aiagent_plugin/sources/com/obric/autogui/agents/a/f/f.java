package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectResultModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f26417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f26418b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f26419c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f26420d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ f[] f26421e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ f[] a() {
        return new f[]{f26417a, f26418b, f26419c, f26420d};
    }

    private f(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f26417a = new f("SYNC_VERIFY", 0);
        f26418b = new f("ASYNC_OBSERVE", 1);
        f26419c = new f("MODEL_SCREENSHOT", 2);
        f26420d = new f("EXECUTION_RESULT", 3);
        f[] r0 = a();
        f26421e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f26421e.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
