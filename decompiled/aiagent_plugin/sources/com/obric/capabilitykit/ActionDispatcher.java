package com.obric.capabilitykit;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: loaded from: classes3.dex */
public final class ActionDispatcher {
    public static final ActionDispatcher INSTANCE = null;
    private static final String TAG = "ActionDispatcher";
    private static Long dispatchStartedQuestion;
    private static final am parallelScope = null;
    private static final am scope = null;

    @d.c.b.a.f(b = "ActionDispatcher.kt", c = {51}, d = "invokeSuspend", e = "com.obric.capabilitykit.ActionDispatcher$launchWithTrace$1")
    public static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f31921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d.h.a.m<am, d.c.d<? super x>, Object> f31922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f31923d;

        public a(long r3, d.h.a.m<? super am, ? super d.c.d<? super x>, ? extends Object> r5, d.c.d<? super a> r6) {
            d.h.a.m<am, d.c.d<? super x>, Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31921b = r3;
            this.f31922c = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f31921b, this.f31922c, r6);
            r0.f31923d = r4;
            return r0;
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31920a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            ActionDispatcher.access$markDispatchEnded(ActionDispatcher.INSTANCE, this.f31921b);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            am r7 = (am) ZeusTransformUtils.preCheckCast(this.f31923d, am.class, "com.obric.aiagent.plugin");
            ActionDispatcher.access$markDispatchStarted(ActionDispatcher.INSTANCE, this.f31921b);
            d.h.a.m<am, d.c.d<? super x>, Object> r2 = this.f31922c;
            this.f31920a = 1;
            if (r2.invoke(r7, this) != r0) goto L11;
            return r0;
        }
    }

    @d.c.b.a.f(b = "ActionDispatcher.kt", c = {58}, d = "onActionReceived", e = "com.obric.capabilitykit.ActionDispatcher")
    public static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f31924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f31925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f31926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ActionDispatcher f31927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31928e;

        public b(ActionDispatcher r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31927d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f31926c = r2;
            this.f31928e |= Integer.MIN_VALUE;
            return this.f31927d.onActionReceived(null, this);
        }
    }

    static {
        INSTANCE = new ActionDispatcher();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$ActionDispatcher$aywdmJbp20ZmM29BzRWOXx9Uxvo.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor …action-dispatcher\")\n    }");
        scope = an.a(br.a(r0));
        ExecutorService r1 = Executors.newCachedThreadPool($$Lambda$ActionDispatcher$FQPYtXqtKDxYM7JfWjJo1lWPFzo.INSTANCE);
        d.h.b.o.c(r1, "newCachedThreadPool {\n  …spatcher-parallel\")\n    }");
        parallelScope = an.a(br.a(r1));
    }

    private ActionDispatcher() {
    }

    public static final /* synthetic */ void access$markDispatchEnded(ActionDispatcher r0, long r1) {
        r0.markDispatchEnded(r1);
    }

    public static final /* synthetic */ void access$markDispatchStarted(ActionDispatcher r0, long r1) {
        r0.markDispatchStarted(r1);
    }

    public static /* synthetic */ IMAppAction getAppActionFailResult$default(ActionDispatcher r0, IMAppAction r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.getAppActionFailResult(r1, r2, r3);
    }

    public static /* synthetic */ IMAppAction getIntentFailResult$default(ActionDispatcher r1, IntentCalling r2, int r3, String r4, Long r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.getIntentFailResult(r2, r3, r4, r5);
    }

    public static /* synthetic */ Thread lambda$FQPYtXqtKDxYM7JfWjJo1lWPFzo(Runnable r0) {
        return parallelScope$lambda$1(r0);
    }

    public static /* synthetic */ Thread lambda$aywdmJbp20ZmM29BzRWOXx9Uxvo(Runnable r0) {
        return scope$lambda$0(r0);
    }

    private final void markDispatchEnded(long r3) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [ended qId=" + r3 + ']');
        dispatchStartedQuestion = null;
    }

    private final void markDispatchStarted(long r3) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [started qId=" + r3 + ']');
        dispatchStartedQuestion = Long.valueOf(r3);
    }

    private static final Thread parallelScope$lambda$1(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "action-dispatcher-parallel");
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "action-dispatcher");
    }

    public final IMAppAction getAppActionFailResult(IMAppAction r32, int r33, String r34) {
        d.h.b.o.e(r32, Ext.KEY_REQUEST);
        Gson r0 = com.obric.capabilitykit.common.a.a();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = r0.toJson(new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyId()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyId();
        Long r19 = r32.getQuestionId();
        return new IMAppAction(0, r32.getMessageId(), r16, r17, r19, null, r21, null, r32.getActionId(), r32.getJobId(), 0, null, 3233, null);
    L5:
        r4 = r34;
        goto L6
    }

    public final Long getDispatchStartedQuestion() {
        return dispatchStartedQuestion;
    }

    public final IMAppAction getIntentFailResult(IntentCalling r32, int r33, String r34, Long r35) {
        d.h.b.o.e(r32, "intentCalling");
        Gson r0 = com.obric.capabilitykit.common.a.a();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = r0.toJson(new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyFor()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyFor();
        long r2 = r32.getQuestionId();
        long r5 = r32.getMessageId();
        long r23 = r32.getActionId();
        long r25 = r32.getJobId();
        if (r35 == null) goto L9;
        long r1 = r35.longValue();
        IMAppActionExt r6 = new IMAppActionExt();
        r6.put("app_cost", String.valueOf(r1));
        IMAppActionExt r28 = r6;
    L11:
        return new IMAppAction(0, Long.valueOf(r5), r16, r17, Long.valueOf(r2), null, r21, null, r23, r25, 0, r28, 1185, null);
    L9:
        r28 = null;
        goto L11
    L5:
        r4 = r34;
        goto L6
    }

    public final am getParallelScope() {
        return parallelScope;
    }

    public final am getScope() {
        return scope;
    }

    public final void launchWithTrace(long r7, d.h.a.m<? super am, ? super d.c.d<? super x>, ? extends Object> r9) {
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "block");
        kotlinx.coroutines.i.a(scope, null, null, new a(r7, r6, null), 3, null);
    }

    public final Object onActionReceived(IMAppAction r37, d.c.d<? super IMAppAction> r38) {
        IMAppAction r0 = r37;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r38, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        int r4 = r3.f31928e;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.f31928e = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f31926c;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f31928e;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r7 = r3.f31925b;
        r0 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f31924a, IMAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L18:
        BaseResult r8 = (BaseResult) ZeusTransformUtils.preCheckCast(r2, BaseResult.class, "com.obric.aiagent.plugin");
        long r9 = System.currentTimeMillis() - r7;
        Gson r10 = new Gson();
        AppHost.Companion r11 = AppHost.Companion;
        String r12 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_success"));
        d.h.b.o.c(r12, "AppHost.application.getS…ing.obric_action_success)");
        String r13 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        d.h.b.o.c(r13, "AppHost.application.getS…ring.obric_action_failed)");
        if (r8.getRet() != 0) goto L25;
        String r14 = r8.getDetails();
        if (r14 == null) goto L24;
        r12 = r14;
    L24:
        r8.setDetails(r12);
    L25:
        int r15 = r8.getRet();
        String r16 = r8.getDetails();
        if (r16 != null) goto L28;
        String r17 = r13;
    L29:
        String r26 = r10.toJson(new FeedbackResult(r15, r17, null, r8.getUiType(), r8.getReplyFor(), false, 36, null));
        long r18 = 0;
        if ((r8.getUiType() & 32) == 0) goto L32;
    L76:
        String r21 = UUID.randomUUID().toString();
        Long r19 = r8.getReplyId();
        if (r19 == null) goto L79;
        r18 = r19.longValue();
    L79:
        long r22 = r18;
        Long r24 = r8.getQuestionId();
        Long r20 = r0.getMessageId();
        long r28 = r0.getActionId();
        long r30 = r0.getJobId();
        IMAppActionExt r23 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r25 = r8.getExt();
        String r27 = null;
        if (ZeusTransformUtils.instanceOf(r25, BaseResultExt.class) == false) goto L82;
        BaseResultExt r29 = (BaseResultExt) ZeusTransformUtils.preCheckCast(r25, BaseResultExt.class, "com.obric.aiagent.plugin");
    L83:
        if (r29 == null) goto L85;
        r27 = r29.getResultDetailExtras();
    L85:
        r23.setActionDetailExtras(r27);
        r23.put("app_cost", String.valueOf(r9));
        ConcurrentHashMap<String, String> r31 = r8.getExt();
        if (r31 == null) goto L89;
        r23.putAll(r31);
    L89:
        return new IMAppAction(0, r20, r21, r22, r24, null, r26, null, r28, r30, 0, r23, 1185, null);
    L82:
        r29 = null;
        goto L83
    L32:
        if ((r8.getUiType() & 64) != 0) goto L76;
        if ((r8.getUiType() & 128) != 0) goto L76;
        if ((r8.getUiType() & 512) != 0) goto L76;
        if ((r8.getUiType() & 1024) != 0) goto L76;
        if ((r8.getUiType() & 2048) != 0) goto L76;
        if ((r8.getUiType() & 4096) != 0) goto L76;
        if ((r8.getUiType() & 8192) != 0) goto L76;
        if ((r8.getUiType() & 16384) != 0) goto L76;
        if ((r8.getUiType() & 32768) != 0) goto L76;
        if ((r8.getUiType() & UiType.FLAG_WIFI_QRCODE_CARD) != 0) goto L76;
        if ((r8.getUiType() & 65536) != 0) goto L76;
        if ((r8.getUiType() & UiType.FLAG_PHONE_CARD) != 0) goto L76;
        if ((r8.getUiType() & 1048576) != 0) goto L76;
        if ((r8.getUiType() & 262144) != 0) goto L76;
        if ((r8.getUiType() & UiType.FLAG_REMOTE_CARD) != 0) goto L76;
        if ((r8.getUiType() & UiType.FLAG_APPLET_CARD) != 0) goto L76;
        String r210 = UUID.randomUUID().toString();
        Long r32 = r8.getReplyId();
        if (r32 == null) goto L67;
        long r211 = r32.longValue();
    L68:
        Long r212 = r8.getQuestionId();
        Long r213 = r0.getMessageId();
        long r214 = r0.getActionId();
        long r33 = r0.getJobId();
        IMAppActionExt r34 = r0.getExt();
        if (r34 != null) goto L71;
        r34 = new IMAppActionExt();
    L71:
        r34.put("app_cost", String.valueOf(r9));
        ConcurrentHashMap<String, String> r35 = r8.getExt();
        if (r35 == null) goto L75;
        r34.putAll(r35);
    L75:
        return new IMAppAction(0, r213, r210, r211, r212, null, r26, null, r214, r33, 0, r34, 1185, null);
    L67:
        r211 = 0;
        goto L68
    L28:
        r17 = r16;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        long r36 = System.currentTimeMillis();
        com.obric.capabilitykit.b r39 = com.obric.capabilitykit.b.f32001a;
        r3.f31924a = r0;
        r3.f31925b = r36;
        r3.f31928e = 1;
        r2 = r39.a(r0, r3);
        if (r2 != r5) goto L17;
        return r5;
    L17:
        r7 = r36;
    L7:
        r3 = new b(this, r1);
        goto L8
    }
}
