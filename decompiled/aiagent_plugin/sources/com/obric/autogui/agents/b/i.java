package com.obric.autogui.agents.b;

import com.obric.autogui.agents.vlm.models.impl.p;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VLMBlackListJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.obric.autogui.agents.c {
    private static final String TAG = "Vlm-BLJudge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.b.C0677b f26843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.applist.a f26844c;

    /* JADX INFO: compiled from: VLMBlackListJudge.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: VLMBlackListJudge.kt */
    @d.c.b.a.f(b = "VLMBlackListJudge.kt", c = {39}, d = "judgePredCondition", e = "com.obric.autogui.agents.predjudge.VLMBlackListJudge")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f26847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26848d;

        b(i r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26847c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26846b = r3;
            this.f26848d |= Integer.MIN_VALUE;
            return this.f26847c.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26842a = new a(null);
    }

    @Override // com.obric.autogui.agents.c
    public void a(com.obric.autogui.session.a r1) {
        com.obric.autogui.agents.c.a.a(this, r1);
    }

    public i(com.obric.autogui.agents.vlm.b.C0677b r2) {
        o.e(r2, "vlmSession");
        this.f26843b = r2;
        this.f26844c = new com.obric.autogui.agents.vlm.models.impl.applist.a();
    }

    @Override // com.obric.autogui.agents.c
    public Object a(com.obric.autogui.session.a r7, k r8, com.obric.autogui.agents.a.d r9, d.c.d<? super com.obric.autogui.agents.a.b> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r12 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r12.f26848d & Integer.MIN_VALUE) == 0) goto L7;
        r12.f26848d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r12.f26846b;
        Object r0 = d.c.a.b.a();
        int r1 = r12.f26848d;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        r9 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r12.f26845a, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L17:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r13, p.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L22;
        Loog.INSTANCE.w(TAG, "[Step=" + r9.b() + "] - intercepting this step by a black-list event.");
        r9.a((com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin"));
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26138d, "BlackListEvent", 0, 4, null);
    L22:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        com.obric.autogui.agents.vlm.models.impl.applist.a r14 = this.f26844c;
        com.obric.autogui.agents.vlm.b.C0677b r15 = this.f26843b;
        r12.f26845a = r9;
        r12.f26848d = 1;
        r13 = r14.a(r15, r9, r12);
        if (r13 != r0) goto L17;
        return r0;
    L7:
        r12 = new b(this, r11);
        goto L8
    }
}
