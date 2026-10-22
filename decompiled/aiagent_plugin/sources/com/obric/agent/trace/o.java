package com.obric.agent.trace;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntentState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum o extends Enum<o> {
    public static final o A = null;
    private static final /* synthetic */ o[] D = null;
    private static final /* synthetic */ d.d.a E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f15587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f15588b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f15589c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o f15590d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o f15591e = null;
    public static final o f = null;
    public static final o g = null;
    public static final o h = null;
    public static final o i = null;
    public static final o j = null;
    public static final o k = null;
    public static final o l = null;
    public static final o m = null;
    public static final o n = null;
    public static final o o = null;
    public static final o p = null;
    public static final o q = null;
    public static final o r = null;
    public static final o s = null;
    public static final o t = null;
    public static final o u = null;
    public static final o v = null;
    public static final o w = null;
    public static final o x = null;
    public static final o y = null;
    public static final o z = null;
    private final String B;
    private final long C;

    private static final /* synthetic */ o[] c() {
        return new o[]{f15587a, f15588b, f15589c, f15590d, f15591e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A};
    }

    private o(String r1, int r2, String r3, long r4) {
        super(r1, r2);
        this.B = r3;
        this.C = r4;
    }

    /* synthetic */ o(String r7, int r8, String r9, long r10, int r12, d.h.b.h r13) {
        if ((r12 & 2) == 0) goto L5;
        r10 = 5000;
    L5:
        this(r7, r8, r9, r10);
    }

    public final String a() {
        return this.B;
    }

    public final long b() {
        return this.C;
    }

    static {
        f15587a = new o("INIT", 0, "初始化", 0, 2, null);
        long r13 = 0;
        int r15 = 2;
        d.h.b.h r16 = null;
        f15588b = new o("ASR", 1, "ASR", r13, r15, r16);
        f15589c = new o("USER_INPUT_QUERY", 2, "用户输入", 0, 2, null);
        f15590d = new o("START_AGENT", 3, "开始agent", r13, r15, r16);
        f15591e = new o("QUERY_REWRITE", 4, "Query改写", 2000);
        f = new o("GET_REALTIME_CTX", 5, "指代消解", 5000);
        g = new o("GET_HISTORY", 6, "获取历史对话", 0, 2, null);
        h = new o("DETECT_INTENT", 7, "任务分类", WsConstants.EXIT_DELAY_TIME);
        i = new o("GET_PERSONAL_CTX", 8, "获取PersonalContext", 10000);
        j = new o("GLOBAL_SEARCH", 9, "全搜搜索", 10000);
        long r11 = 0;
        int r14 = 2;
        d.h.b.h r17 = null;
        k = new o("QA_WITH_SEARCH", 10, "端模型基于搜索问答", r11, r14, r17);
        long r19 = 0;
        int r21 = 2;
        d.h.b.h r22 = null;
        l = new o("DISPATCH_TO_SLM", 11, "端模型-功能编排", r19, r21, r22);
        m = new o("DISPATCH_TO_LLM", 12, "云模型-功能编排", 60000);
        n = new o("SWITCH_TO_LLM", 13, "切换到云模型", r11, r14, r17);
        o = new o("DM_SHOWING_DIALOG", 14, "展示选择对话框", r19, r21, r22);
        p = new o("DM_VOICE_ANSWER", 15, "通过语音或打字回答选择内容", 0, 2, null);
        q = new o("DM_TOUCH_ANSWER", 16, "通过点击选择内容", 0, 2, null);
        r = new o("DISPATCH_INTENT", 17, "意图解析与分发", 5000);
        s = new o("AUTHENTICATION", 18, "锁屏鉴权", Long.MAX_VALUE);
        t = new o("APP_DO_ACTION", 19, "应用执行", WsConstants.EXIT_DELAY_TIME);
        u = new o("SUMMARIZE", 20, "模型总结", WsConstants.EXIT_DELAY_TIME);
        v = new o("SLM_NOT_SUPPORT", 21, "端模型不支持", 0, 2, null);
        long r5 = 0;
        int r7 = 2;
        d.h.b.h r8 = null;
        w = new o("RECV_RESULT", 22, "处理执行结果", r5, r7, r8);
        long r18 = 0;
        int r110 = 2;
        d.h.b.h r111 = null;
        x = new o("SERVER_PROCESS", 23, "服务端处理", r18, r110, r111);
        y = new o("SHOWING_RESULT", 24, "展示执行结果", r5, r7, r8);
        z = new o("PROCESS_DEAD", 25, "进程崩溃", r18, r110, r111);
        A = new o("END", 26, "结束", r5, r7, r8);
        o[] r0 = c();
        D = r0;
        E = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static o valueOf(String r2) {
        return (o) ZeusTransformUtils.preCheckCast(Enum.valueOf(o.class, r2), o.class, "com.obric.aiagent.plugin");
    }

    public static o[] values() {
        return (o[]) ZeusTransformUtils.preCheckCast(D.clone(), o[].class, "com.obric.aiagent.plugin");
    }
}
