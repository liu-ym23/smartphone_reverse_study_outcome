package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum l extends Enum<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f28188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f28189b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f28190c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f28191d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f28192e = null;
    private static final /* synthetic */ l[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    private static final /* synthetic */ l[] a() {
        return new l[]{f28188a, f28189b, f28190c, f28191d, f28192e};
    }

    private l(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f28188a = new l("APP_FOREGROUND_INTERNAL", 0);
        f28189b = new l("OMNI_FINISHED_INTERNAL", 1);
        f28190c = new l("INFERENCE_IMAGE_IDLE_INTERNAL", 2);
        f28191d = new l("USER_FEEDBACK", 3);
        f28192e = new l("DATA_FEEDBACK", 4);
        l[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static l valueOf(String r2) {
        return (l) ZeusTransformUtils.preCheckCast(Enum.valueOf(l.class, r2), l.class, "com.obric.aiagent.plugin");
    }

    public static l[] values() {
        return (l[]) ZeusTransformUtils.preCheckCast(f.clone(), l[].class, "com.obric.aiagent.plugin");
    }
}
