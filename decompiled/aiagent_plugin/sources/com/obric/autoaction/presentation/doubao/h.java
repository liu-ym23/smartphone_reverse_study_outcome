package com.obric.autoaction.presentation.doubao;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f24887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f24888b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f24889c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f24890d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f24891e = null;
    public static final h f = null;
    public static final h g = null;
    public static final h h = null;
    private static final /* synthetic */ h[] i = null;
    private static final /* synthetic */ d.d.a j = null;

    private static final /* synthetic */ h[] a() {
        return new h[]{f24887a, f24888b, f24889c, f24890d, f24891e, f, g, h};
    }

    private h(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f24887a = new h("AI_B_6", 0);
        f24888b = new h("ASSISTANT_CARD_NEUTRAL_100", 1);
        f24889c = new h("OUI_AI_A_COLOR3_6", 2);
        f24890d = new h("CONDITIONAL_SUCCESS_50", 3);
        f24891e = new h("OUI_BASIC_TEXT_3", 4);
        f = new h("OUI_BASIC_TEXT_1", 5);
        g = new h("ASSISTANT_CARD_DANGER_50", 6);
        h = new h("AI_GRADIENT_MIDDLE_COLOR", 7);
        h[] r0 = a();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(i.clone(), h[].class, "com.obric.aiagent.plugin");
    }
}
