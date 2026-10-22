package com.obric.autogui.agents.vlm.models.impl.e.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ScriptFailureReason.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f27815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f27816b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f27817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f27818d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f27819e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    private static final /* synthetic */ c[] n = null;
    private static final /* synthetic */ d.d.a o = null;
    private final int k;
    private final String l;
    private final String m;

    private static final /* synthetic */ c[] c() {
        return new c[]{f27815a, f27816b, f27817c, f27818d, f27819e, f, g, h, i, j};
    }

    private c(String r1, int r2, int r3, String r4, String r5) {
        super(r1, r2);
        this.k = r3;
        this.l = r4;
        this.m = r5;
    }

    public final String a() {
        return this.l;
    }

    public final String b() {
        return this.m;
    }

    static {
        f27815a = new c("INFINITE_LOOP", 0, 1001, "剧本陷入了死循环", "Infinite script loop detected");
        f27816b = new c("ABILITY_NULL", 1, 1002, "没有可以执行的剧本", "Ability is null or empty");
        f27817c = new c("ENV_INIT_FAILED", 2, 1003, "剧本环境初始化失败", "Runtime create and init failed");
        f27818d = new c("SCRIPT_NOT_FOUND", 3, 1004, "剧本读取失败", "Script code not found");
        f27819e = new c("SCRIPT_START_FAILED", 4, 1005, "剧本启动失败", "Runtime startScript failed");
        f = new c("PARSE_OP_FAILED", 5, 1006, "剧本指令解析出现异常", "Operation plan failed");
        g = new c("SECURITY_INTERCEPTED", 6, 1007, "剧本执行遇到风控拦截", "Security policy check failed");
        h = new c("EXEC_OP_FAILED", 7, 1008, "Script execution failed, Operation failed", "Operation execute failed");
        i = new c("NEXT_STEP_FAILED", 8, 1009, "Script execution failed, nextStep failed", "Runtime nextStep failed");
        j = new c("UNEXPECTED_EXCEPTION", 9, 1099, "剧本执行出现异常", "Unexpected exception");
        c[] r0 = c();
        n = r0;
        o = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(n.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
