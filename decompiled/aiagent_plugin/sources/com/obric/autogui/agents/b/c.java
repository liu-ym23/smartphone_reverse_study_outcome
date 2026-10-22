package com.obric.autogui.agents.b;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitorKt;
import com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.capabilitykit.entity.ResultCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.h.b.o;
import d.h.b.z;
import d.l.n;
import d.s;
import d.x;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: LoadingJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.obric.autogui.agents.c {
    private static final String TAG = "LoadingJudge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26803a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f26804e;
    private static final Set<String> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.a.g f26805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f26806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Long> f26807d;

    /* JADX INFO: compiled from: LoadingJudge.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final long a() {
            return c.b();
        }
    }

    /* JADX INFO: compiled from: LoadingJudge.kt */
    @d.c.b.a.f(b = "LoadingJudge.kt", c = {449, 471, 493}, d = "checkByLoading", e = "com.obric.autogui.agents.predjudge.LoadingJudge")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26812e;
        long f;
        long g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ c j;
        int k;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.i = r3;
            this.k |= Integer.MIN_VALUE;
            return c.a(this.j, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LoadingJudge.kt */
    @d.c.b.a.f(b = "LoadingJudge.kt", c = {186}, d = "judgePredCondition", e = "com.obric.autogui.agents.predjudge.LoadingJudge")
    static final class C0674c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f26814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f26815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f26816d;

        C0674c(c r3, d.c.d<? super C0674c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26815c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26814b = r3;
            this.f26816d |= Integer.MIN_VALUE;
            return this.f26815c.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LoadingJudge.kt */
    @d.c.b.a.f(b = "LoadingJudge.kt", c = {234, 236, 247, 263, 289, ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED}, d = "judgePredConditionInternal", e = "com.obric.autogui.agents.predjudge.LoadingJudge")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26820d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26821e;
        Object f;
        int g;
        long h;
        long i;
        long j;
        long k;
        boolean l;
        /* synthetic */ Object m;
        final /* synthetic */ c n;
        int o;

        d(c r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.n = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.m = r3;
            this.o |= Integer.MIN_VALUE;
            return c.a(this.n, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LoadingJudge.kt */
    @d.c.b.a.f(b = "LoadingJudge.kt", c = {352, 354, 383}, d = "openAppWait", e = "com.obric.autogui.agents.predjudge.LoadingJudge")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26826e;
        long f;
        long g;
        /* synthetic */ Object h;
        final /* synthetic */ c i;
        int j;

        e(c r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            this.h = r10;
            this.j |= Integer.MIN_VALUE;
            return c.a(this.i, null, null, 0, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public c(com.obric.autogui.session.a r4) {
        o.e(r4, SensitiveType.SESSION);
        this.f26805b = new com.obric.autogui.agents.vlm.models.a.g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0.3f);
        this.f26806c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f26807d = ao.a(s.a("ctrip.android.view/ctrip.base.ui.ctcalendar.CalendarSelectActivity", 1000L));
    }

    public static final /* synthetic */ Object a(c r2, com.obric.autogui.session.a r3, com.obric.autogui.agents.a.d r4, int r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, com.obric.autogui.session.a r3, k r4, com.obric.autogui.agents.a.d r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r10, com.obric.autogui.session.a r11, String r12, long r13, com.obric.autogui.agents.a.d r15, long r16, d.c.d r18) {
        return r10.a(r11, r12, r13, r15, r16, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ long b() {
        return f26804e;
    }

    static {
        f26803a = new a(null);
        f26804e = 10000;
        f = ax.a(new String[]{"type", "clarify", "call_user", "take_notes", "set_time_task", "set_scroll_value"});
    }

    private final String c(com.obric.autogui.session.a r2) {
        com.obric.autogui.operator.e r1 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(p.n(r2.p()), com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L13;
        IAutoActionAgentEventListener.AgentStepInfo r3 = r1.T();
        if (r3 == null) goto L13;
        String r4 = r3.getActionProtocolType();
        if (r4 == null) goto L13;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L13;
        String r6 = r5.toLowerCase(Locale.ROOT);
        o.c(r6, "toLowerCase(...)");
        if (r6 == null) goto L13;
        return r6;
    L13:
        return "";
    }

    private final boolean a(String r3) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return true;
    L8:
        if (f.contains(r3) == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.autogui.agents.c
    public Object a(com.obric.autogui.session.a r7, k r8, com.obric.autogui.agents.a.d r9, d.c.d<? super com.obric.autogui.agents.a.b> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C0674c.class) == false) goto L7;
        C0674c r0 = (C0674c) ZeusTransformUtils.preCheckCast(r11, C0674c.class, "com.obric.aiagent.plugin");
        if ((r0.f26816d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26816d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f26814b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f26816d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r0.f26813a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L23
    L20:
        com.obric.autogui.agents.a.b r6 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r7.b(), com.obric.autogui.agents.vlm.models.omni.b.c.i);
        return r6;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r12);
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.a(r7.b(), com.obric.autogui.agents.vlm.models.omni.b.c.i);
        r0.f26813a = r7;     // Catch: Throwable -> L23
        r0.f26816d = 1;     // Catch: Throwable -> L23
        r12 = b(r7, r8, r9, r0);     // Catch: Throwable -> L23
        if (r12 != r2) goto L20;
        return r2;
    L23:
        th = move-exception;
        com.obric.autogui.agents.vlm.models.omni.b.e.f28225a.b(r7.b(), com.obric.autogui.agents.vlm.models.omni.b.c.i);
        throw th;
    L7:
        r0 = new C0674c(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x063e -> B:120:0x0645). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x064c -> B:122:0x065d). Please report as a decompilation issue!!! */
    private final Object b(com.obric.autogui.session.a r42, k r43, com.obric.autogui.agents.a.d r44, d.c.d<? super com.obric.autogui.agents.a.b> r45) {
        k r11 = r43;
        com.obric.autogui.agents.a.d r12 = r44;
        String r13 = "com.obric.aiagent.plugin";
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r45, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r2.o & Integer.MIN_VALUE) == 0) goto L7;
        r2.o -= Integer.MIN_VALUE;
    L8:
        d r14 = r2;
        Object r3 = r14.m;
        Object r15 = d.c.a.b.a();
        int r4 = r14.o;
        boolean r16 = false;
        String r5 = " - [loading] (step=";
        String r7 = TAG;
        switch(r4) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r9 = r14.i;
        boolean r6 = r14.l;
        int r8 = r14.g;
        long r17 = r14.h;
        com.obric.autogui.agents.a.b r10 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r14.f26820d, com.obric.autogui.agents.a.b.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r18 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r14.f26819c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r19 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r14.f26818b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c r0 = (c) ZeusTransformUtils.preCheckCast(r14.f26817a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        com.obric.autogui.agents.a.d r20 = r18;
        String r30 = " - [JudgeV2][LoadingJudge] (step=";
        String r110 = "com.obric.aiagent.plugin";
        boolean r111 = true;
        boolean r112 = r6;
        String r113 = " - [loading] (step=";
        long r21 = r17;
    L120:
        com.obric.autogui.agents.a.b r22 = r10;
        int r36 = r8;
        long r23 = r9;
        boolean r114 = r112;
    L122:
        String r115 = r113;
        String r116 = r110;
        long r117 = AOSystemTools.INSTANCE.nowTimeMillis();
    L102:
        long r24 = r117 - r21;
        if (r24 >= r23) goto L136;
        int r25 = r36 + 1;
        long r26 = AOSystemTools.INSTANCE.nowTimeMillis();
        r14.f26817a = r0;
        r14.f26818b = r19;
        r14.f26819c = r20;
        String r27 = r115;
        r14.f26820d = null;
        r14.f26821e = null;
        r14.f = null;
        r14.h = r21;
        r14.i = r117;
        r14.g = r25;
        r112 = r114;
        r14.l = r112;
        r14.j = r23;
        r14.k = r26;
        r14.o = 5;
        Object r28 = r0.a(r19, r20, r25, r14);
        if (r28 != r15) goto L107;
        return r15;
    L107:
        long r39 = r21;
        int r29 = r25;
        r3 = r28;
        long r31 = r23;
        com.obric.autogui.session.a r32 = r19;
        long r33 = r26;
        long r41 = r117;
        long r118 = r39;
    L108:
        Object r119 = r15;
        r110 = r116;
        r22 = (com.obric.autogui.agents.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.a.b.class, r110);
        long r34 = AOSystemTools.INSTANCE.nowTimeMillis() - r33;
        com.obric.autogui.session.a r120 = r32;
        c r210 = r0;
        if (ZeusTransformUtils.instanceOf(r22, com.obric.autogui.agents.a.f.class) == false) goto L123;
        String r35 = r7;
        long r37 = AOSystemTools.INSTANCE.nowTimeMillis() - r118;
        long r46 = r118;
        long r211 = r31;
        long r38 = n.b(((com.obric.autogui.agents.a.f) ZeusTransformUtils.preCheckCast(r22, com.obric.autogui.agents.a.f.class, r110)).e(), n.a(r31 - r37, 0));
        if (r112 == false) goto L113;
        r7 = r35;
        Loog.INSTANCE.i(r7, r30 + r20.b() + ") The" + r29 + " termination was wait，" + r38 + "ms after retry（elapsed=" + r37 + "ms, checkCost=" + r34 + "ms）");
        r113 = r27;
    L115:
        if (r38 <= 0) goto L121;
        AOThreadingTools r40 = AOThreadingTools.INSTANCE;
        r14.f26817a = r210;
        r14.f26818b = r120;
        r14.f26819c = r20;
        r14.f26820d = r22;
        r14.h = r46;
        r14.g = r29;
        r14.l = r112;
        r14.i = r211;
        r14.o = 6;
        r15 = r119;
        if (r40.delayForMillis(r38, r14) != r15) goto L119;
        return r15;
    L119:
        r9 = r211;
        r8 = r29;
        r0 = r210;
        r19 = r120;
        r21 = r46;
        r10 = r22;
        goto L120
    L121:
        r15 = r119;
        r23 = r211;
        r36 = r29;
        r0 = r210;
        r19 = r120;
        r114 = r112;
        r21 = r46;
        goto L122
    L113:
        r7 = r35;
        r113 = r27;
        Loog.INSTANCE.i(r7, r113 + r20.b() + ") retry after " + r38 + " ms.");
        goto L115
    L123:
        long r47 = r118;
        String r121 = r27;
        long r122 = AOSystemTools.INSTANCE.nowTimeMillis() - r47;
        if (r112 == false) goto L126;
        Loog.INSTANCE.i(r7, r30 + r20.b() + ") The" + r29 + " determination was unwait/release（elapsed=" + r122 + "ms, checkCost=" + r34 + "ms, reason=" + r22.b() + 65289);
    L127:
        CharSequence r48 = (CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, r110);
        if (r48 != null) goto L130;
    L131:
        r16 = r111;
    L132:
        if (r16 == false) goto L135;
        r210.a(r120.b(), 1, r29, System.currentTimeMillis() - r47);
    L135:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L130:
        if (r48.length() != 0) goto L132;
    L126:
        Loog.INSTANCE.i(r7, r121 + r20.b() + ") no-need to retry; judged time = " + (r41 - r47) + '.');
        goto L127
    L136:
        String r123 = r115;
        boolean r124 = r114;
        String r49 = r30;
        c r310 = r0;
        r310.a(r19.b(), 2, r36, System.currentTimeMillis() - r21);
        if (r124 == false) goto L143;
        Loog r50 = Loog.INSTANCE;
        StringBuilder r51 = new StringBuilder().append(r49).append(r20.b()).append(") timeout release（already=").append(r24).append("ms, max=").append(r23).append("ms, last=");
        if (r22 == null) goto L141;
        String r52 = r22.b();
    L142:
        r50.i(r7, r51.append(r52).append(65289).toString());
    L145:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L141:
        r52 = null;
        goto L142
    L143:
        Loog.INSTANCE.i(r7, r123 + r20.b() + ") retrial exceeds time limits (already=" + r24 + "), max=" + r23);
        goto L145
    L13:
        long r53 = r14.k;
        long r54 = r14.j;
        boolean r55 = r14.l;
        int r125 = r14.g;
        long r126 = r14.i;
        long r56 = r14.h;
        com.obric.autogui.agents.a.d r57 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r14.f26819c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r58 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r14.f26818b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r14.f26817a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r27 = " - [loading] (step=";
        r30 = " - [JudgeV2][LoadingJudge] (step=";
        r29 = r125;
        r116 = "com.obric.aiagent.plugin";
        r111 = true;
        r112 = r55;
        r31 = r54;
        r20 = r57;
        r32 = r58;
        r33 = r53;
        r41 = r126;
        r118 = r56;
        goto L108
    L14:
        d.o.a(r3);
    L94:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L15:
        d.o.a(r3);
    L78:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L16:
        long r59 = r14.h;
        int r60 = r14.g;
        com.obric.autogui.agents.vlm.models.impl.g r61 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r14.f, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        String r62 = (String) ZeusTransformUtils.preCheckCast(r14.f26821e, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r127 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r14.f26820d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        r11 = (k) ZeusTransformUtils.preCheckCast(r14.f26819c, k.class, "com.obric.aiagent.plugin");
        r19 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r14.f26818b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r14.f26817a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r30 = " - [JudgeV2][LoadingJudge] (step=";
        r12 = r127;
        Object r63 = r15;
        r111 = true;
        long r64 = r59;
        int r65 = r60;
    L66:
        com.obric.autogui.agents.vlm.models.impl.g r66 = r61;
        String r67 = r62;
        ?? r68 = r65;
    L68:
        String r128 = r13;
        ComponentName r69 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, r128);
        if (r69 == null) goto L71;
        String r70 = r69.flattenToString();
    L72:
        Long r71 = (Long) ZeusTransformUtils.preCheckCast(r0.f26807d.get(r70), Long.class, r128);
        if (r71 == null) goto L79;
        Loog.INSTANCE.w(r7, r5 + r12.b() + ") current topComponent (" + r70 + ") is in fixed-loading-time list (fixed-time: " + r71 + "ms)");
        AOThreadingTools r72 = AOThreadingTools.INSTANCE;
        long r73 = r71.longValue();
        r14.f26817a = null;
        r14.f26818b = null;
        r14.f26819c = null;
        r14.f26820d = null;
        r14.f26821e = null;
        r14.f = null;
        r14.o = 3;
        if (r72.delayForMillis(r73, r14) != r63) goto L78;
        return r63;
    L79:
        r115 = r5;
        r7 = r7;
        List<String> r129 = com.obric.autogui.common.a.d.f28974a.U();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r67, CharSequence.class, r128)).length() <= 0) goto L82;
        boolean r74 = r111;
    L83:
        if (r74 == false) goto L89;
        if (r129.contains(r67) == false) goto L89;
        Loog.INSTANCE.i(r7, r115 + r12.b() + ") lastActionType (" + r67 + ") is in skip-client-check list; waived client loading judge");
        return com.obric.autogui.agents.a.b.f26124a.a();
    L89:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11.c().d(), Boolean.class, r128)).booleanValue() == true) goto L95;
        long r75 = ((Number) ZeusTransformUtils.preCheckCast(r11.b().d(), Number.class, r128)).intValue();
        Loog.INSTANCE.w(r7, r115 + r12.b() + ") loading judge is disabled; waited for another " + r75 + " milliseconds and proceed directly.");
        AOThreadingTools r76 = AOThreadingTools.INSTANCE;
        r14.f26817a = null;
        r14.f26818b = null;
        r14.f26819c = null;
        r14.f26820d = null;
        r14.f26821e = null;
        r14.f = null;
        r14.o = 4;
        if (r76.delayForMillis(r75, r14) != r63) goto L94;
        return r63;
    L95:
        long r130 = AOSystemTools.INSTANCE.nowTimeMillis();
        long r212 = AOSystemTools.INSTANCE.nowTimeMillis();
        boolean r77 = com.obric.autogui.common.a.d.f28974a.x();
        if (r77 == false) goto L100;
        if (r68 == 0) goto L99;
        r64 = g.f26833a.a(r67, r66);
    L99:
        r23 = n.a(com.obric.autogui.common.a.d.f28974a.w() - r64, 0);
    L101:
        r15 = r63;
        r116 = r128;
        r20 = r12;
        r36 = 0;
        r21 = r130;
        r117 = r212;
        r22 = null;
        r114 = r77;
        goto L102
    L100:
        r23 = ((Number) ZeusTransformUtils.preCheckCast(r11.b().d(), Number.class, r128)).intValue();
        goto L101
    L82:
        r74 = false;
        goto L83
    L71:
        r70 = null;
        goto L72
    L17:
        long r78 = r14.h;
        int r79 = r14.g;
        com.obric.autogui.agents.vlm.models.impl.g r80 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r14.f, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        String r81 = (String) ZeusTransformUtils.preCheckCast(r14.f26821e, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r131 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r14.f26820d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        r11 = (k) ZeusTransformUtils.preCheckCast(r14.f26819c, k.class, "com.obric.aiagent.plugin");
        r19 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r14.f26818b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r14.f26817a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        long r213 = r78;
        r5 = " - [loading] (step=";
        r30 = " - [JudgeV2][LoadingJudge] (step=";
        r12 = r131;
        r63 = r15;
        r111 = true;
        int r82 = r79;
    L61:
        r66 = r80;
        r67 = r81;
        r64 = r213;
        r68 = r82;
        goto L68
    L18:
        d.o.a(r3);
        this.f26806c.clear();
        if (AutoActionVirtualDisplay.INSTANCE.getVdOperatingApp().a() != null) goto L22;
        Loog.INSTANCE.d(TAG, " - [loading] (step=" + r44.b() + ") no apps inside the VD; waived on-device stability");
        return com.obric.autogui.agents.a.b.f26124a.a();
    L22:
        long r214 = System.currentTimeMillis();
        r67 = c(r42);
        boolean r83 = com.obric.autogui.common.a.d.f28974a.m();
        boolean r84 = com.obric.autogui.common.a.d.f28974a.n();
        Object r85 = p.n(r42.p());
        if (ZeusTransformUtils.instanceOf(r85, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L25;
        r66 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r85, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L26:
        boolean r86 = com.obric.autogui.agents.b.e.a(r66);
        if (com.obric.autogui.common.a.d.f28974a.o() == false) goto L33;
        if (r66 == null) goto L30;
        ActionSystemAnimationMonitor r87 = r66.q();
    L31:
        if (r87 == null) goto L33;
        ?? r88 = 1;
    L34:
        Loog.INSTANCE.i(ActionSystemAnimationMonitorKt.RULE_STABILITY_LOG_TAG, " - [LoadingJudge] lastActionType=" + r67 + ", enablePredJudgeV2=" + r83 + ", handledByRuleStability=" + r88);
        List<String> r89 = com.obric.autogui.common.a.d.f28974a.T();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r67, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L37;
        boolean r90 = true;
    L38:
        if (r90 == true) goto L40;
    L42:
        boolean r91 = false;
    L43:
        if (r86 == true) goto L51;
        if (r88 != 0) goto L51;
        if (r91 == true) goto L51;
        if (r83 == true) goto L49;
    L50:
        r64 = 500;
    L52:
        this.f26806c.put("already_opened", String.valueOf(r86));
        if (r64 <= 0) goto L67;
        Loog.INSTANCE.i(TAG, " - [JudgeV2][LoadingJudge] waiting " + r64 + " ms before model, thread=" + Thread.currentThread().getName() + ", lastActionType=" + r67);
        if (o.a(r67, "open_app") == false) goto L62;
        if (r84 == false) goto L62;
        r14.f26817a = this;
        r14.f26818b = r42;
        r14.f26819c = r11;
        r14.f26820d = r12;
        r14.f26821e = r67;
        r14.f = r66;
        r14.g = r88;
        r14.h = r64;
        r14.o = 1;
        com.obric.autogui.agents.vlm.models.impl.g r132 = r66;
        ?? r133 = r88;
        r213 = r64;
        r5 = " - [loading] (step=";
        r30 = " - [JudgeV2][LoadingJudge] (step=";
        r111 = true;
        r63 = r15;
        if (a(r42, r67, r64, r44, r214, r14) != r63) goto L60;
        return r63;
    L60:
        r0 = this;
        r19 = r42;
        r81 = r67;
        r80 = r132;
        r82 = r133 == true ? 1 : 0;
    L62:
        com.obric.autogui.agents.vlm.models.impl.g r134 = r66;
        ?? r135 = r88;
        r30 = " - [JudgeV2][LoadingJudge] (step=";
        r63 = r15;
        r111 = true;
        AOThreadingTools r92 = AOThreadingTools.INSTANCE;
        r14.f26817a = this;
        r14.f26818b = r42;
        r14.f26819c = r11;
        r14.f26820d = r12;
        r14.f26821e = r67;
        r14.f = r134;
        r14.g = r135 == true ? 1 : 0;
        r64 = r64;
        r14.h = r64;
        r14.o = 2;
        if (r92.delayForMillis(r64, r14) != r63) goto L65;
        return r63;
    L65:
        r65 = r135 == true ? 1 : 0;
        r0 = this;
        r19 = r42;
        r62 = r67;
        r61 = r134;
        goto L66
    L67:
        r7 = TAG;
        r13 = "com.obric.aiagent.plugin";
        r5 = r5;
        r30 = " - [JudgeV2][LoadingJudge] (step=";
        r63 = r15;
        r111 = true;
        r0 = this;
        r19 = r42;
        r68 = r88;
        goto L68
    L49:
        if (a(r67) == true) goto L50;
    L51:
        r64 = 0;
        goto L52
    L40:
        if (r89.contains(r67) == false) goto L42;
        r91 = true;
        goto L43
    L37:
        r90 = false;
        goto L38
    L30:
        r87 = null;
    L33:
        r88 = 0;
        goto L34
    L25:
        r66 = null;
        goto L26
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r2 = new d(this, r1);
        goto L8
    }

    private final Object a(com.obric.autogui.session.a r30, String r31, long r32, com.obric.autogui.agents.a.d r34, long r35, d.c.d<? super x> r37) {
        long r2 = r32;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin");
        if ((r6.j & Integer.MIN_VALUE) == 0) goto L7;
        r6.j -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.h;
        Object r7 = d.c.a.b.a();
        int r8 = r6.j;
        String r14 = TAG;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        long r0 = r6.f;
        IAutoActionSpecialApi.ScreenShotTickResult r3 = (IAutoActionSpecialApi.ScreenShotTickResult) ZeusTransformUtils.preCheckCast(r6.f26824c, IAutoActionSpecialApi.ScreenShotTickResult.class, "com.obric.aiagent.plugin");
        IAutoActionSpecialApi.ScreenShotTickToken r9 = (IAutoActionSpecialApi.ScreenShotTickToken) ZeusTransformUtils.preCheckCast(r6.f26823b, IAutoActionSpecialApi.ScreenShotTickToken.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r10 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r6.f26822a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r14 = TAG;
    L52:
        IAutoActionSpecialApi.ScreenShotTickResult r11 = r3;
        IAutoActionSpecialApi.ScreenShotTickToken r12 = r9;
        com.obric.autogui.session.a r13 = r10;
        long r15 = r0;
    L53:
        Loog.INSTANCE.i(r14, "ScreenShotTick - [JudgeV2][LoadingJudge] await tick end and not ready, result=" + r11 + ", token=" + r12 + ", session_id=" + r13.b() + ", waitTimeLeft=" + r15);
    L55:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r1 = r6.g;
        r2 = r6.f;
        r12 = (IAutoActionSpecialApi.ScreenShotTickToken) ZeusTransformUtils.preCheckCast(r6.f26826e, IAutoActionSpecialApi.ScreenShotTickToken.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r16 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r6.f26825d, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r6.f26824c, String.class, "com.obric.aiagent.plugin");
        r13 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r6.f26823b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        c r18 = (c) ZeusTransformUtils.preCheckCast(r6.f26822a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        c r19 = r18;
        String r26 = r17;
        com.obric.autogui.agents.a.d r20 = r16;
        long r21 = r1;
    L34:
        r11 = (IAutoActionSpecialApi.ScreenShotTickResult) ZeusTransformUtils.preCheckCast(r5, IAutoActionSpecialApi.ScreenShotTickResult.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "ScreenShotTick [LoadingJudge] await tick end, result=" + r11 + ", token=" + r12 + ", session_id=" + r13.b());
        String r110 = r11.getPackageName();
        if (r110 == null) goto L43;
        AppInfoEntry r22 = AOPackagesTools.INSTANCE.getAppInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r110);
        if (r22 == null) goto L41;
        CharSequence r23 = r22.getAppLabel();
        if (r23 == null) goto L41;
        String r111 = r23.toString();
    L42:
        String r27 = r111;
    L44:
        r19.a(r13.b(), r11.getDurationMillis(), r20, r11.getRegisterToAwaitDurationMillis(), System.currentTimeMillis() - r21, r11, r26, r27);
        if (r11.getStatus() == IAutoActionSpecialApi.ScreenShotTickStatus.Ready) goto L55;
        r15 = n.a(r2 - (System.currentTimeMillis() - r21), 0);
        if (r15 <= 0) goto L53;
        AOThreadingTools r24 = AOThreadingTools.INSTANCE;
        r6.f26822a = r13;
        r6.f26823b = r12;
        r6.f26824c = r11;
        r6.f26825d = null;
        r6.f26826e = null;
        r6.f = r15;
        r6.j = 3;
        if (r24.delayForMillis(r15, r6) != r7) goto L51;
        return r7;
    L51:
        r0 = r15;
        r3 = r11;
        r9 = r12;
        r10 = r13;
    L41:
        r111 = null;
        goto L42
    L43:
        r27 = null;
        goto L44
    L17:
        d.o.a(r5);
    L29:
        return x.f38692a;
    L18:
        d.o.a(r5);
        com.obric.autogui.agents.vlm.b.C0677b r25 = r30.B();
        if (r25 == null) goto L21;
        r12 = r25.l();
    L22:
        if (r25 == null) goto L24;
        r25.a(null);
    L24:
        if (r12 != null) goto L30;
        Loog.INSTANCE.w(TAG, "ScreenShotTick [LoadingJudge] await tick skipped (no token), lastActionType=" + r31 + ", session_id=" + r30.b());
        AOThreadingTools r28 = AOThreadingTools.INSTANCE;
        r6.j = 1;
        if (r28.delayForMillis(r2, r6) != r7) goto L29;
        return r7;
    L30:
        IAutoActionSpecialApi r29 = AOPlatformTools.INSTANCE.special();
        long r112 = com.obric.autogui.common.a.d.f28974a.a(r31, f26804e);
        r6.f26822a = this;
        r13 = r30;
        r6.f26823b = r13;
        r6.f26824c = r31;
        r6.f26825d = r34;
        r6.f26826e = r12;
        r6.f = r2;
        r6.g = r35;
        r6.j = 2;
        r5 = r29.awaitScreenShotTick(r12, r112, r6);
        if (r5 != r7) goto L33;
        return r7;
    L33:
        r19 = this;
        r26 = r31;
        r21 = r35;
        r20 = r34;
        goto L34
    L21:
        r12 = null;
    L7:
        r6 = new e(this, r4);
        goto L8
    }

    private final void a(String r9, int r10, int r11, long r12) {
        Map<String, String> r0 = this.f26806c;
        r0.put("judge_type", String.valueOf(r10));
        r0.put("judge_count", String.valueOf(r11));
        r0.put("judge_loading_time", String.valueOf(r12));
        IAutoActionTrackingApi r1 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("session_id", r9);
        com.obric.autogui.session.d.a(r2, this.f26806c);
        x r8 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r1, "oauto_judge_loading", r2, false, false, null, 28, null);
    }

    private final void a(String r3, long r4, com.obric.autogui.agents.a.d r6, long r7, long r9, IAutoActionSpecialApi.ScreenShotTickResult r11, String r12, String r13) {
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();
        r0.put("session_id", r3);
        r0.put("request_id", String.valueOf(r11.getRequestId()));
        r0.put("step_id", r6.b());
        r0.put("fw_check_status", r11.getStatus());
        r0.put("package_name", r11.getPackageName());
        r0.put("param_int", r11.getParamInt());
        r0.put("param_string", r11.getParamString());
        r0.put(IBdInstall.PARAM_APP_NAME, r13);
        r0.put("duration", r4);
        r0.put("execute_after_to_start_wait", r7);
        r0.put("start_wait_to_wait_callback", r9);
        r0.put("lastActionType", r12);
        x r5 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "oauto_screenshot_tick", r0, false, false, null, 28, null);
    }

    public final void b(com.obric.autogui.session.a r8) {
        o.e(r8, SensitiveType.SESSION);
        a(r8.b(), 3, -1, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(com.obric.autogui.session.a r25, com.obric.autogui.agents.a.d r26, int r27, d.c.d<? super com.obric.autogui.agents.a.b> r28) {
        c r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r4.k & Integer.MIN_VALUE) == 0) goto L7;
        r4.k -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.i;
        Object r13 = d.c.a.b.a();
        int r5 = r4.k;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        long r6 = r4.h;
        long r7 = r4.g;
        long r9 = r4.f;
        int r1 = r4.f26812e;
        z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r4.f26811d, z.f.class, "com.obric.aiagent.plugin");
        z.f r12 = (z.f) ZeusTransformUtils.preCheckCast(r4.f26810c, z.f.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r14 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r4.f26809b, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r4.f26808a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        String r24 = TAG;
        T r10 = r3;
    L50:
        r11.f38504a = r10;
        long r15 = System.currentTimeMillis() - r6;
        long r16 = AOSystemTools.INSTANCE.nowTimeMillis() - r9;
        long r17 = r7 - r9;
        String r18 = r24;
        Loog.INSTANCE.d(r18, " - [LoadingDet] (step=" + r14.b() + ") all=" + r16 + "ms; screenshot=" + r17 + "ms; inference=" + r15 + "ms");
        IAutoActionTrackingApi r19 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r20 = new JSONObject();
        r20.put("case_type", "lj_res");
        r20.put("int_value", ((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).g() ? 1 : 0);
        r20.put("string_value", "e=" + ((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).h() + ";lA=" + r16 + ";lS=" + r17 + ";lI=" + r15);
        x r21 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r19, "technical_recorded_case", r20, false, false, null, 28, null);
        if (((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).g() == true) goto L54;
        Loog.INSTANCE.w(r18, " - inference failed/cancelled: " + ((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).h());
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26135a, "inference failed/cancelled: " + ((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).h(), 0, 4, null);
    L54:
        String r22 = (String) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r12.f38504a, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r22, "wait") == false) goto L63;
        Loog.INSTANCE.i(r18, " - classified as `wait` (latency=" + r15 + "ms)");
        if (com.obric.autogui.common.a.d.f28974a.x() == false) goto L59;
        long r23 = r8.a(r1);
    L61:
        return new com.obric.autogui.agents.a.f("classified as `wait`", r23);
    L59:
        r23 = 200;
        goto L61
    L63:
        if (o.a(r22, "unwait") == false) goto L65;
        Loog.INSTANCE.i(r18, " - classified as `unwait` (latency=" + r15 + "ms)");
    L66:
        Loog.INSTANCE.i(r18, " - exiting on-device stability judge.");
        return com.obric.autogui.agents.a.b.f26124a.a();
    L65:
        Loog.INSTANCE.w(r18, " - classified as `" + r22 + "` (latency=" + r15 + "ms), treat as unwait");
        goto L66
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r29 = r4.f;
        r1 = r4.f26812e;
        com.obric.autogui.common.d r30 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r4.f26810c, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r31 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r4.f26809b, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        r8 = (c) ZeusTransformUtils.preCheckCast(r4.f26808a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r9 = r29;
        Object r32 = r3;
    L38:
        ScreenshotResult r33 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r32, ScreenshotResult.class, "com.obric.aiagent.plugin");
        long r34 = AOSystemTools.INSTANCE.nowTimeMillis();
        IScreenshot r110 = r33.getPic();
        if (r33.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L43;
        Loog.INSTANCE.w(TAG, " - screenshot contains secure data; ignored");
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26135a, "screenshot is secure", 0, 4, null);
    L43:
        if (r33.getStatus() != ScreenshotResult.Status.Ok) goto L68;
        if (r110 == null) goto L68;
        z.f r35 = new z.f();
        long r111 = System.currentTimeMillis();
        Object r36 = r30.a();
        o.a(r36);
        r24 = TAG;
        IAutoActionLocalModelProvider.ImageClassifyModel r37 = (IAutoActionLocalModelProvider.ImageClassifyModel) ZeusTransformUtils.preCheckCast(r36, IAutoActionLocalModelProvider.ImageClassifyModel.class, "com.obric.aiagent.plugin");
        Bitmap r112 = r110.getBitmap();
        r4.f26808a = r8;
        r4.f26809b = r31;
        r4.f26810c = r35;
        r4.f26811d = r35;
        r4.f26812e = r1;
        r4.f = r9;
        r4.g = r34;
        r4.h = r111;
        r4.k = 3;
        Object r38 = r37.inference(r112, r4);
        if (r38 != r13) goto L49;
        return r13;
    L49:
        r11 = r35;
        r12 = r11;
        r10 = r38;
        r14 = r31;
        r7 = r34;
        r6 = r111;
    L68:
        Loog.INSTANCE.e(TAG, " - screenshot status is not Ok: " + r33.getStatus() + "; ignored");
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26135a, "screenshot is null", 0, 4, null);
    L17:
        int r39 = r4.f26812e;
        com.obric.autogui.agents.a.d r40 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r4.f26809b, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        c r41 = (c) ZeusTransformUtils.preCheckCast(r4.f26808a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        int r42 = r39;
        r0 = r41;
        Object r43 = r3;
    L23:
        com.obric.autogui.common.d r44 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r43, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
    L25:
        com.obric.autogui.common.d r113 = r44;
        com.obric.autogui.agents.a.d r45 = r40;
        int r46 = r42;
        if (r113 != null) goto L28;
    L70:
        Loog.INSTANCE.e(TAG, " - failed to acquire model `loading-detection` (" + r113 + "); ignored");
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26135a, "model is null", 0, 4, null);
    L28:
        if (r113.g() == false) goto L70;
        if (r113.a() != null) goto L34;
        Loog.INSTANCE.e(TAG, " - failed to acquire model payload `loading-detection`; ignored");
        return new com.obric.autogui.agents.a.b(com.obric.autogui.agents.a.e.f26135a, "model payload is null", 0, 4, null);
    L34:
        Loog.INSTANCE.i(TAG, " - entering on-device stability judge.");
        long r114 = AOSystemTools.INSTANCE.nowTimeMillis();
        com.obric.autogui.agents.vlm.models.a.a r47 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(r0.f26805b, com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        String r48 = "loading-detect-" + r45.b();
        r4.f26808a = r0;
        r4.f26809b = r45;
        r4.f26810c = r113;
        r4.f26812e = r46;
        r4.f = r114;
        r4.k = 2;
        Object r49 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r47, r48, null, false, false, r4, 14, null);
        if (r49 != r13) goto L37;
        return r13;
    L37:
        r31 = r45;
        r9 = r114;
        r30 = r113;
        r8 = r0;
        r1 = r46;
        r32 = r49;
        goto L38
    L18:
        d.o.a(r3);
        IAutoActionLocalModelProvider r50 = (IAutoActionLocalModelProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLocalModelProvider.class), IAutoActionLocalModelProvider.class, "com.obric.aiagent.plugin");
        if (r50 == null) goto L24;
        Context r51 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r25.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r4.f26808a = r0;
        r40 = r26;
        r4.f26809b = r40;
        r42 = r27;
        r4.f26812e = r42;
        r4.k = 1;
        Object r52 = r50.acquireImageClassifyModel(r51, "loading-detection-aik", r4);
        r43 = r52;
        if (r52 != r13) goto L23;
        return r13;
    L24:
        r40 = r26;
        r42 = r27;
        r44 = null;
    L7:
        r4 = new b(r0, r2);
        goto L8
    }

    private final long a(int r7) {
        if (r7 > 0) goto L6;
        return 200;
    L6:
        if (r7 > 5) goto L8;
        return 200;
    L8:
        int r8 = n.c(r7 - 5, 1);
        long r2 = b(r8);
        Loog.INSTANCE.d(TAG, " -judgev2-  fibonacci(" + r8 + ") = " + r2);
        return n.b(r2 * 200, 2147483647L);
    }

    private final long b(int r7) {
        if (r7 < 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L21;
        long r1 = 1;
        if (r7 > 1) goto L11;
        return 1;
    L11:
        if (r7 > 2) goto L13;
        return 1;
    L13:
        int r6 = 3;
        if (3 > r7) goto L19;
        long r2 = 1;
    L16:
        r1 = r1 + r2;
        if (r6 == r7) goto L19;
        r6 = r6 + 1;
        r1 = r2;
        r2 = r1;
    L19:
        return r1;
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final Map<String, String> a() {
        return ao.d(this.f26806c);
    }

    @Override // com.obric.autogui.agents.c
    public void a(com.obric.autogui.session.a r2) {
        o.e(r2, SensitiveType.SESSION);
        this.f26806c.clear();
    }
}
