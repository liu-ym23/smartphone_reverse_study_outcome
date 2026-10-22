package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f28178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f28179b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f28180d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f28181e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28182c;

    private static final /* synthetic */ j[] b() {
        return new j[]{f28178a, f28179b};
    }

    private j(String r1, int r2, String r3) {
        super(r1, r2);
        this.f28182c = r3;
    }

    public final String a() {
        return this.f28182c;
    }

    static {
        f28178a = new j("USER_FEEDBACK", 0, "user_feedback");
        f28179b = new j("DATA_FEEDBACK", 1, "data_feedback");
        j[] r0 = b();
        f28180d = r0;
        f28181e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f28180d.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
