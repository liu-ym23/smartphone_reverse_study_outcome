package com.obric.capabilitykit;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f32167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f32168b = null;

    @d.c.b.a.f(b = "IntentDispatcherClient.kt", c = {36}, d = "onIntentReceived", e = "com.obric.capabilitykit.execution.IntentDispatcherClient")
    public static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f32169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f32170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f32171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f32172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o f32173e;
        public int f;

        public a(o r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32173e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f32172d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.f32173e.a(null, null, this);
        }
    }

    static {
        f32167a = new o();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$o$ixvJL_sEzUKZAinj0hjYT4dWWOY.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor …intent-dispatcher\")\n    }");
        f32168b = an.a(br.a(r0));
    }

    private o() {
    }

    private final BaseResultExt a(ConcurrentHashMap<String, String> r1) {
        BaseResultExt r0 = new BaseResultExt();
        r0.putAll(r1);
        return r0;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "intent-dispatcher");
    }

    public static /* synthetic */ Thread lambda$ixvJL_sEzUKZAinj0hjYT4dWWOY(Runnable r0) {
        return a(r0);
    }

    public final Object a(IntentCalling r38, String r39, d.c.d<? super d.m<? extends IntentResult<?>, IMAppAction>> r40) {
        IntentCalling r0 = r38;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r40, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        int r4 = r3.f;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.f = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f32172d;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r7 = r3.f32171c;
        Application r8 = (Application) ZeusTransformUtils.preCheckCast(r3.f32170b, Application.class, "com.obric.aiagent.plugin");
        IntentCalling r9 = (IntentCalling) ZeusTransformUtils.preCheckCast(r3.f32169a, IntentCalling.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        Application r10 = r8;
        r0 = r9;
        Object r11 = r2;
    L18:
        IntentResult r12 = (IntentResult) ZeusTransformUtils.preCheckCast(r11, IntentResult.class, "com.obric.aiagent.plugin");
        long r13 = System.currentTimeMillis() - r7;
        String r14 = r10.getString(ZeusTransformUtils.mapRes(R.string.obric_action_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_success"));
        d.h.b.o.c(r14, "context.getString(R.string.obric_action_success)");
        String r15 = r10.getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        d.h.b.o.c(r15, "context.getString(R.string.obric_action_failed)");
        if (r12.getRet() != 0) goto L25;
        String r16 = r12.getDetails();
        if (r16 == null) goto L24;
        r14 = r16;
    L24:
        r12.setDetails(r14);
    L25:
        Gson r17 = com.obric.capabilitykit.common.a.a();
        int r18 = r12.getRet();
        String r19 = r12.getDetails();
        if (r19 != null) goto L28;
        String r110 = r15;
    L29:
        String r26 = r17.toJson(new FeedbackResult(r18, r110, null, r12.getUiType(), String.valueOf(r0.getReplyFor()), false, 36, null));
        if ((r12.getUiType() & 32) == 0) goto L32;
    L69:
        String r21 = UUID.randomUUID().toString();
        long r22 = r0.getMessageId();
        long r20 = r0.getQuestionId();
        long r23 = r0.getMessageId();
        long r28 = r0.getActionId();
        long r30 = r0.getJobId();
        IMAppActionExt r24 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r25 = r12.getExt();
        if (r25 == null) goto L74;
        BaseResultExt r27 = f32167a.a(r25);
        if (r27 == null) goto L74;
        String r29 = r27.getResultDetailExtras();
    L75:
        r24.setActionDetailExtras(r29);
        r24.put("app_cost", String.valueOf(r13));
        ConcurrentHashMap<String, String> r31 = r12.getExt();
        if (r31 == null) goto L79;
        r24.putAll(r31);
    L79:
        return new d.m(r12, new IMAppAction(0, d.c.b.a.b.a(r23), r21, r22, d.c.b.a.b.a(r20), null, r26, null, r28, r30, 0, r24, 1185, null));
    L74:
        r29 = null;
        goto L75
    L32:
        if ((r12.getUiType() & 64) != 0) goto L69;
        if ((r12.getUiType() & 128) != 0) goto L69;
        if ((r12.getUiType() & 512) != 0) goto L69;
        if ((r12.getUiType() & 1024) != 0) goto L69;
        if ((r12.getUiType() & 2048) != 0) goto L69;
        if ((r12.getUiType() & 4096) != 0) goto L69;
        if ((r12.getUiType() & 8192) != 0) goto L69;
        if ((r12.getUiType() & 16384) != 0) goto L69;
        if ((r12.getUiType() & 32768) != 0) goto L69;
        if ((r12.getUiType() & UiType.FLAG_WIFI_QRCODE_CARD) != 0) goto L69;
        if ((r12.getUiType() & 65536) != 0) goto L69;
        if ((r12.getUiType() & UiType.FLAG_PHONE_CARD) != 0) goto L69;
        if ((r12.getUiType() & 1048576) != 0) goto L69;
        if ((r12.getUiType() & 262144) != 0) goto L69;
        if ((r12.getUiType() & UiType.FLAG_REMOTE_CARD) != 0) goto L69;
        if ((r12.getUiType() & UiType.FLAG_APPLET_CARD) != 0) goto L69;
        String r210 = UUID.randomUUID().toString();
        long r211 = r0.getMessageId();
        long r32 = r0.getQuestionId();
        long r33 = r0.getMessageId();
        long r212 = r0.getActionId();
        long r34 = r0.getJobId();
        IMAppActionExt r35 = new IMAppActionExt();
        r35.put("app_cost", String.valueOf(r13));
        ConcurrentHashMap<String, String> r36 = r12.getExt();
        if (r36 == null) goto L68;
        r35.putAll(r36);
    L68:
        return new d.m(r12, new IMAppAction(0, d.c.b.a.b.a(r33), r210, r211, d.c.b.a.b.a(r32), null, r26, null, r212, r34, 0, r35, 1185, null));
    L28:
        r110 = r19;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        r10 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        long r37 = System.currentTimeMillis();
        p r41 = p.f32174a;
        r3.f32169a = r0;
        r3.f32170b = r10;
        r3.f32171c = r37;
        r3.f = 1;
        r11 = r41.a(r10, r0, r39, r3);
        if (r11 != r5) goto L17;
        return r5;
    L17:
        r7 = r37;
    L7:
        r3 = new a(this, r1);
        goto L8
    }
}
