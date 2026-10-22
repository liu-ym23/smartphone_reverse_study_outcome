package com.obric.autogui.agents.vlm.models.omni.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniGuiToolTraceSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f28220b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f28221c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f28222d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f28223e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    public static final c k = null;
    public static final c l = null;
    public static final c m = null;
    public static final c n = null;
    public static final c o = null;
    public static final c p = null;
    public static final c q = null;
    public static final c r = null;
    public static final c s = null;
    private static final /* synthetic */ c[] u = null;
    private static final /* synthetic */ d.d.a v = null;
    private final String t;

    private static final /* synthetic */ c[] b() {
        return new c[]{f28219a, f28220b, f28221c, f28222d, f28223e, f, g, h, i, j, k, l, m, n, o, p, q, r, s};
    }

    private c(String r1, int r2, String r3) {
        super(r1, r2);
        this.t = r3;
    }

    public final String a() {
        return this.t;
    }

    static {
        f28219a = new c("WAIT_OPERATING_SPACE", 0, "detail_wait_operating_space_duration_ms");
        f28220b = new c("WAIT_BLACKLIST_SYNC", 1, "detail_wait_blacklist_sync_duration_ms");
        f28221c = new c("BEFORE_EXECUTION", 2, "detail_before_execution_duration_ms");
        f28222d = new c("EXECUTE_STEP", 3, "detail_execute_step_duration_ms");
        f28223e = new c("AFTER_EXECUTION", 4, "detail_after_execution_duration_ms");
        f = new c("ON_STEP_EXECUTED", 5, "detail_on_step_executed_duration_ms");
        g = new c("SAVE_STEP_JOURNAL", 6, "detail_save_step_journal_duration_ms");
        h = new c("JUDGE_PRED_CONDITION", 7, "detail_judge_pred_condition_duration_ms");
        i = new c("LOADING_JUDGE", 8, "detail_loading_judge_duration_ms");
        j = new c("SCREENSHOT_PREPARE", 9, "detail_screenshot_prepare_duration_ms");
        k = new c("VIEWTREE_PREPARE", 10, "detail_viewtree_prepare_duration_ms");
        l = new c("MAKE_REQUEST_BODY", 11, "detail_make_request_body_duration_ms");
        m = new c("MAKE_HYPER_PARAMS", 12, "detail_make_hyper_params_duration_ms");
        n = new c("HYPER_PARAMS_APP_LIST", 13, "detail_hyper_params_app_list_duration_ms");
        o = new c("HYPER_PARAMS_COMMON_PARAMS", 14, "detail_hyper_params_common_params_duration_ms");
        p = new c("HYPER_PARAMS_SCRIPT_ABILITY", 15, "detail_hyper_params_script_ability_duration_ms");
        q = new c("HYPER_PARAMS_ROBOTS_POLICY", 16, "detail_hyper_params_robots_policy_duration_ms");
        r = new c("HYPER_PARAMS_SAEP_PACKAGES", 17, "detail_hyper_params_saep_packages_duration_ms");
        s = new c("HYPER_PARAMS_VIEWTREE_APPEND", 18, "detail_hyper_params_viewtree_append_duration_ms");
        c[] r0 = b();
        u = r0;
        v = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(u.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
