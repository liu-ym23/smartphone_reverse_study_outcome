package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectOriginalResultModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f26427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f26428b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f26429c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f26430d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f26431e = null;
    public static final h f = null;
    public static final h g = null;
    public static final h h = null;
    public static final h i = null;
    private static final /* synthetic */ h[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final String j;

    private static final /* synthetic */ h[] b() {
        return new h[]{f26427a, f26428b, f26429c, f26430d, f26431e, f, g, h, i};
    }

    private h(String r1, int r2, String r3) {
        super(r1, r2);
        this.j = r3;
    }

    public final String a() {
        return this.j;
    }

    static {
        f26427a = new h("CLARIFY", 0, "clarify");
        f26428b = new h("TAKE_NOTES", 1, "take_notes");
        f26429c = new h("CALL_USER", 2, "call_user");
        f26430d = new h("WAIT", 3, "wait");
        f26431e = new h("RUN_SCRIPT_BY_ABILITY", 4, "run_script_by_ability");
        f = new h("SET_SCROLL_VALUE", 5, "set_scroll_value");
        g = new h("PRESS_HOME", 6, "press_home");
        h = new h("PRESS_SCREENSHOT", 7, "press_screenshot");
        i = new h("STOP", 8, "stop");
        h[] r0 = b();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(k.clone(), h[].class, "com.obric.aiagent.plugin");
    }
}
