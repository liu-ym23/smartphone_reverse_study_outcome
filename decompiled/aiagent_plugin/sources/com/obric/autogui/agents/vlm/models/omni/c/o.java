package com.obric.autogui.agents.vlm.models.omni.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrewarmAdmissionController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum o extends Enum<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f28311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f28312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f28313c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o f28314d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o f28315e = null;
    public static final o f = null;
    public static final o g = null;
    public static final o h = null;
    public static final o i = null;
    private static final /* synthetic */ o[] k = null;
    private static final /* synthetic */ d.d.a l = null;
    private final String j;

    private static final /* synthetic */ o[] b() {
        return new o[]{f28311a, f28312b, f28313c, f28314d, f28315e, f, g, h, i};
    }

    private o(String r1, int r2, String r3) {
        super(r1, r2);
        this.j = r3;
    }

    public final String a() {
        return this.j;
    }

    static {
        f28311a = new o("MAIN_DISPLAY_VISIBLE", 0, "main_display_visible");
        f28312b = new o("HARD_BLACKLIST", 1, "hard_blacklist");
        f28313c = new o("SOFT_BLACKLIST", 2, "soft_blacklist");
        f28314d = new o("SAEP_BLACKLIST", 3, "saep_blacklist");
        f28315e = new o("VIRUS", 4, "virus");
        f = new o("BLACKLIST_STATE_UNAVAILABLE", 5, "blacklist_state_unavailable");
        g = new o("USER_PERMISSION_NOT_ENABLED", 6, "user_permission_not_enabled");
        h = new o("USER_PERMISSION_UNAVAILABLE", 7, "user_permission_unavailable");
        i = new o("RECORD_SET_ADD_FAILED", 8, "record_set_add_failed");
        o[] r0 = b();
        k = r0;
        l = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(k.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
