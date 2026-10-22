package com.obric.autoaction.presentation.doubao;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.assistant.AssistCardBgResType;
import com.obric.autogui.common.api.assistant.AssistCardIconResType;
import com.obric.autogui.common.api.assistant.AssistCardIdResType;
import com.obric.autogui.common.api.assistant.AssistantAbilityHelper;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.IAutoAgentWidgetStateListener;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import java.util.HashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: AssistRemoteCardProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.obric.aiagent.assistant_card.provider_core.a {
    private static final String TAG = "AssistRemoteCardProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24875a = null;

    /* JADX INFO: compiled from: AssistRemoteCardProvider.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AssistRemoteCardProvider.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24876a = null;

        static {
            int[] r0 = new int[com.obric.autoaction.presentation.doubao.d.values().length];
            r0[com.obric.autoaction.presentation.doubao.d.f24881a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[com.obric.autoaction.presentation.doubao.d.f24882b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[com.obric.autoaction.presentation.doubao.d.f24883c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.autoaction.presentation.doubao.d.j.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[com.obric.autoaction.presentation.doubao.d.f24884d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[com.obric.autoaction.presentation.doubao.d.f24885e.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[com.obric.autoaction.presentation.doubao.d.f.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[com.obric.autoaction.presentation.doubao.d.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.obric.autoaction.presentation.doubao.d.h.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[com.obric.autoaction.presentation.doubao.d.i.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[com.obric.autoaction.presentation.doubao.d.k.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f24876a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.doubao.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistRemoteCardProvider.kt */
    @d.c.b.a.f(b = "AssistRemoteCardProvider.kt", c = {793}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.doubao.AssistRemoteCardProvider$onActionTriggered$6")
    static final class C0579c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.autogui.common.e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f24878b;

        C0579c(JSONObject r3, d.c.d<? super C0579c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24878b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return ((C0579c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0579c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0579c(this.f24878b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.common.e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24877a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L16:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            JSONObject r7 = this.f24878b;
            if (r7 == null) goto L12;
            String r8 = r7.optString("answer", "");
            if (r8 == null) goto L12;
        L13:
            Loog.INSTANCE.d(c.TAG, "user blacklist action: " + r8);
            AutoActionAgent r2 = AutoActionAgent.INSTANCE;
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24877a = 1;
            r6 = r2.exitUserClarify(r8, "assistant_allow_blacklist", r3);
            if (r6 != r0) goto L16;
            return r0;
        L12:
            r8 = "允许";
            goto L13
        }
    }

    /* JADX INFO: compiled from: AssistRemoteCardProvider.kt */
    @d.c.b.a.f(b = "AssistRemoteCardProvider.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.doubao.AssistRemoteCardProvider$onActionTriggered$8")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f24880b;

        d(JSONObject r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24880b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f24880b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f24879a != 0) goto L16;
            o.a(r3);
            JSONObject r2 = this.f24880b;
            if (r2 == null) goto L7;
            String r4 = r2.optString("timer_task_id");
        L8:
            if (r4 != null) goto L10;
            Loog.INSTANCE.e(c.TAG, "[AssistRemoteCard] timer task id error " + r4);
        L14:
            return x.f38692a;
        L10:
            IAutoActionPresentationApi r5 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L14;
            r5.postTestRunTask(r4);
            goto L14
        L7:
            r4 = null;
            goto L8
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f24875a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$-eNS5JcbaeJLgHRNK_-vHTZUAYE, reason: not valid java name */
    public static /* synthetic */ x m618lambda$eNS5JcbaeJLgHRNK_vHTZUAYE(AssistRemoteCardUIParams r0, c r1, Context r2, long r3, com.obric.autoaction.presentation.doubao.a r5) {
        return a(r0, r1, r2, r3, r5);
    }

    public static /* synthetic */ x lambda$ht92nzaaVOed7N_vDIJUup2Izn8(Intent r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$sFu7e-lfAzUvoUu4WjOA8qS6iy4, reason: not valid java name */
    public static /* synthetic */ x m619lambda$sFu7elfAzUvoUu4WjOA8qS6iy4(WidgetState r0, Context r1, IAssistCardResourceProvider r2, boolean r3, c r4, long r5, com.obric.aiagent.assistant_card.provider_core.bean.c.a r7, com.obric.autoaction.presentation.doubao.a r8) {
        return a(r0, r1, r2, r3, r4, r5, r7, r8);
    }

    public c() {
        super("oauto_task_status_card");
    }

    public static final /* synthetic */ WidgetState a(c r0, JSONObject r1) {
        return r0.a(r1);
    }

    private final WidgetState a(JSONObject r4) {
        Gson r0 = j.f24894a.a();     // Catch: Exception -> L9
        if (r4 == null) goto L6;
        String r5 = r4.optString("widget_state");     // Catch: Exception -> L9
    L7:
        return (WidgetState) ZeusTransformUtils.preCheckCast(r0.fromJson(r5, WidgetState.class), WidgetState.class, "com.obric.aiagent.plugin");
    L6:
        r5 = null;
    L9:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "json parse error " + e.getMessage());
        return null;
    }

    private final AssistRemoteCardUIParams b(JSONObject r4) {
        if (r4 != null) goto L12;
    L11:
        return null;
    L12:
        String r5 = r4.optString("extra_ui_model");     // Catch: Exception -> L9
        if (r5 == null) goto L11;
        return (AssistRemoteCardUIParams) ZeusTransformUtils.preCheckCast(j.f24894a.a().fromJson(r5, AssistRemoteCardUIParams.class), AssistRemoteCardUIParams.class, "com.obric.aiagent.plugin");
    L9:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "json parse error " + e.getMessage());
        goto L11
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public com.obric.aiagent.assistant_card.provider_core.bean.c a(Context r12, Uri r13, JSONObject r14, final boolean r15) {
        final Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "context");
        d.h.b.o.e(r13, "cardUri");
        long r2 = -1;
        if (r14 == null) goto L5;
        r2 = r14.optLong("doubao_message_id", -1);
    L5:
        final long r8 = r2;
        Loog.INSTANCE.d(TAG, "get card " + r13 + ", doubaoMsgId=" + r8);
        final IAssistCardResourceProvider r17 = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAssistCardResourceProvider.class), IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L9;
        Loog.INSTANCE.e(TAG, "fail to get Assist Card, since resProvider is null");
        return null;
    L9:
        final com.obric.aiagent.assistant_card.provider_core.bean.c.a r1 = com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r16, r17.getLayoutRes()).a();
        final AssistRemoteCardUIParams r3 = b(r14);
        if (r3 != null) goto L12;
        final WidgetState r4 = a(r14);
        if (r4 != null) goto L16;
        return null;
    L16:
        e.a(r1, r16, r17, r15, new $$Lambda$c$sFu7elfAzUvoUu4WjOA8qS6iy4(r4, r16, r17, r15, this, r8, r1));
        return r1.b();
    L12:
        return e.a(r1, r16, r17, r15, new $$Lambda$c$eNS5JcbaeJLgHRNK_vHTZUAYE(r3, this, r16, r8)).b();
    }

    private static final x a(AssistRemoteCardUIParams r15, c r16, Context r17, long r18, com.obric.autoaction.presentation.doubao.a r20) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r20, "$this$buildCard");
        int r0 = r15.getType();
        if (r0 == 1) goto L30;
        Object r5 = null;
        if (r0 != 2) goto L7;
        String r1 = r15.getSessionKey();
        String r6 = r15.getSessionId();
        String r7 = r15.getQuery();
        Long r8 = Long.valueOf(r18);
        HashMap<String, Object> r2 = r15.getExtras();
        if (r2 == null) goto L29;
        r5 = r2.get("taskMigrate");
    L29:
        r16.a(r20, r4, r1, r6, r7, r8, d.h.b.o.a(r5, "1"));
    L32:
        return x.f38692a;
    L7:
        if (r0 != 3) goto L32;
        Long r3 = Long.valueOf(r18);
        String r9 = r15.getQuery();
        String r10 = r15.getSessionId();
        String r11 = r15.getSessionKey();
        HashMap<String, Object> r12 = r15.getExtras();
        if (r12 == null) goto L12;
        Object r13 = r12.get("app_package_name");
    L14:
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L16;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");
    L17:
        HashMap<String, Object> r19 = r15.getExtras();
        if (r19 == null) goto L20;
        Object r21 = r19.get("app_task_id");
    L22:
        if (ZeusTransformUtils.instanceOf(r21, Integer.class) == false) goto L24;
        Integer r110 = (Integer) ZeusTransformUtils.preCheckCast(r21, Integer.class, "com.obric.aiagent.plugin");
    L25:
        a(r16, r20, r4, r3, r9, r10, r11, r14, r110, true, null, 256, null);
        goto L32
    L24:
        r110 = null;
        goto L25
    L20:
        r21 = null;
        goto L22
    L16:
        r14 = null;
        goto L17
    L12:
        r13 = null;
        goto L14
    L30:
        r16.a(r20, r4, r15.getQuery(), r15.getSessionKey(), r15.getSessionId(), 100001);
        goto L32
    }

    private static final x a(WidgetState r29, Context r30, IAssistCardResourceProvider r31, boolean r32, c r33, long r34, com.obric.aiagent.assistant_card.provider_core.bean.c.a r36, com.obric.autoaction.presentation.doubao.a r37) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.aiagent.plugin");
        IAssistCardResourceProvider r12 = (IAssistCardResourceProvider) ZeusTransformUtils.wrapperContextForParams(r31, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r37, "$this$buildCard");
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.CallUser.class) == false) goto L17;
        String r0 = ((WidgetState.CallUser) ZeusTransformUtils.preCheckCast(r29, WidgetState.CallUser.class, "com.obric.aiagent.plugin")).getActionForUser();
        if (r0 != null) goto L7;
    L14:
        r0 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_action_operate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_action_operate"));
        d.h.b.o.c(r0, "getString(...)");
    L15:
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.CLARIFY, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.CLARIFY, true))));
        String r3 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_paused"));
        d.h.b.o.c(r3, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r37.b(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getIconRes(AssistCardIconResType.LEFT_HAND_AI_FILL, false), Integer.valueOf(r12.getIconRes(AssistCardIconResType.LEFT_HAND_AI_FILL, true))));
        String r4 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_wait_for_manual_operation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_wait_for_manual_operation"));
        d.h.b.o.c(r4, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r13, h.f24887a, r32), 0, 0, 12, null);
        r33.a(r37);
        com.obric.autoaction.presentation.doubao.a.C0577a r5 = new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.GRADIENT_ROUND, false), null, 2, null);
        String r6 = com.obric.autoaction.presentation.doubao.d.f24885e.a();
        com.obric.autoaction.presentation.doubao.a.a(r37, null, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r13, h.f24887a, r32), r5, r6, null, false, 96, null);
    L112:
        return x.f38692a;
    L7:
        if (r0.length() > 4) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
    L9:
        r7 = false;
        goto L10
    L17:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.Clarify.class) == false) goto L23;
        if (((WidgetState.Clarify) ZeusTransformUtils.preCheckCast(r29, WidgetState.Clarify.class, "com.obric.aiagent.plugin")).getType() != IAutoAgentWidgetStateListener.ClarifyType.NORMAL) goto L21;
        r33.a(r37, r13);
        goto L112
    L21:
        r33.a(r37, r13, ((WidgetState.Clarify) ZeusTransformUtils.preCheckCast(r29, WidgetState.Clarify.class, "com.obric.aiagent.plugin")).getClarifyBlackListParams());
        goto L112
    L23:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.LastStep.class) == false) goto L62;
        int r8 = ((WidgetState.LastStep) ZeusTransformUtils.preCheckCast(r29, WidgetState.LastStep.class, "com.obric.aiagent.plugin")).getEndType();
        String r9 = "";
        if (r8 != 1) goto L27;
        Long r10 = Long.valueOf(r34);
        String r1 = r29.getSessionInfo().getTask().getUserTask();
        if (r1 == null) goto L52;
        r9 = r1;
    L52:
        String r11 = r29.getSessionInfo().getSessionId();
        String r14 = r29.getSessionInfo().getSessionKey();
        IAutoActionAgentEventListener.OperatingAppInfo r2 = ((WidgetState.LastStep) ZeusTransformUtils.preCheckCast(r29, WidgetState.LastStep.class, "com.obric.aiagent.plugin")).getOperatingApp();
        if (r2 == null) goto L55;
        String r15 = r2.getPackageName();
    L56:
        IAutoActionAgentEventListener.OperatingAppInfo r16 = ((WidgetState.LastStep) ZeusTransformUtils.preCheckCast(r29, WidgetState.LastStep.class, "com.obric.aiagent.plugin")).getOperatingApp();
        if (r16 == null) goto L59;
        Integer r17 = Integer.valueOf(r16.getTaskId());
    L60:
        a(r33, r37, r13, r10, r9, r11, r14, r15, r17, false, r29.getSessionInfo().getTask().m799getTaskType(), 128, null);
        goto L112
    L59:
        r17 = null;
        goto L60
    L55:
        r15 = null;
        goto L56
    L27:
        if (r8 != 2) goto L29;
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.CANCEL, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.CANCEL, true))));
        String r18 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_finished, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_finished"));
        d.h.b.o.c(r18, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        String r19 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_user_cancelled_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_user_cancelled_task"));
        d.h.b.o.c(r19, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r13, h.f24888b, r32), 16, 0, 8, null);
        com.obric.autoaction.presentation.doubao.a.C0577a r20 = new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getIconRes(AssistCardIconResType.TEXT, false), Integer.valueOf(r12.getIconRes(AssistCardIconResType.TEXT, true)));
        String r21 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_feedback, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_feedback"));
        d.h.b.o.c(r21, "getString(...)");
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin");
        String r23 = com.obric.autoaction.presentation.doubao.d.f24884d.a();
        JSONObject r24 = new JSONObject();
        r24.put("session_id", r29.getSessionInfo().getSessionId());
        r24.put("session_key", r29.getSessionInfo().getSessionKey());
        r24.put("task_query", r29.getSessionInfo().getTask().getUserTask());
        Bundle r25 = ((WidgetState.LastStep) ZeusTransformUtils.preCheckCast(r29, WidgetState.LastStep.class, "com.obric.aiagent.plugin")).getStepInfo().getExtras();
        if (r25 == null) goto L46;
        int r26 = r25.getInt("term_reason_type");
    L47:
        r24.put("term_reason", r26);
        x r27 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r37, r20, r22, 0, null, r23, r24, false, 76, null);
        com.obric.autoaction.presentation.doubao.a.C0577a r28 = new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getIconRes(AssistCardIconResType.REFRESH, false), Integer.valueOf(r12.getIconRes(AssistCardIconResType.REFRESH, true)));
        String r35 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_rerun, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_rerun"));
        d.h.b.o.c(r35, "getString(...)");
        CharSequence r38 = (CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.aiagent.plugin");
        String r39 = com.obric.autoaction.presentation.doubao.d.f.a();
        JSONObject r40 = new JSONObject();
        r40.put("session_id", r29.getSessionInfo().getSessionId());
        r40.put("task_query", r29.getSessionInfo().getTask().getUserTask());
        r40.put("doubao_message_id", r34);
        x r41 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r37, r28, r38, 0, null, r39, r40, false, 76, null);
        goto L112
    L46:
        r26 = 1;
        goto L47
    L29:
        if (r8 == 3) goto L32;
        if (r8 != 4) goto L112;
    L32:
        String r42 = r29.getSessionInfo().getTask().getUserTask();
        if (r42 != null) goto L35;
        r42 = "";
    L35:
        String r43 = r29.getSessionInfo().getSessionKey();
        String r44 = r29.getSessionInfo().getSessionId();
        if (r44 != null) goto L38;
        r44 = "";
    L38:
        Bundle r45 = ((WidgetState.LastStep) ZeusTransformUtils.preCheckCast(r29, WidgetState.LastStep.class, "com.obric.aiagent.plugin")).getStepInfo().getExtras();
        if (r45 == null) goto L41;
        int r110 = r45.getInt("term_reason_type");
    L42:
        r33.a(r37, r13, r42, r43, r44, r110);
        goto L112
    L41:
        r110 = 1;
        goto L42
    L62:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.Operating.class) == false) goto L75;
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, true))));
        String r46 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_executing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_executing"));
        d.h.b.o.c(r46, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r46, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        IAutoActionAgentEventListener.AgentStepInfo r47 = ((WidgetState.Operating) ZeusTransformUtils.preCheckCast(r29, WidgetState.Operating.class, "com.obric.aiagent.plugin")).getStepInfo();
        if (r47 == null) goto L67;
        String r48 = r47.getThought();
        if (r48 == null) goto L67;
    L68:
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r48, (CharSequence) ZeusTransformUtils.preCheckCast("# ", CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r33.a(r37);
        IAutoActionAgentEventListener.OperatingAppInfo r49 = ((WidgetState.Operating) ZeusTransformUtils.preCheckCast(r29, WidgetState.Operating.class, "com.obric.aiagent.plugin")).getOperatingApp();
        if (r49 == null) goto L73;
        String r50 = r49.getPackageName();
        if (r50 == null) goto L73;
        r37.a(r50);
    L73:
        int r51 = r12.getIdRes(AssistCardIdResType.ROOT);
        String r52 = com.obric.autoaction.presentation.doubao.d.f24885e.a();
        JSONObject r53 = new JSONObject();
        r53.put("session_id", r29.getSessionInfo().getSessionId());
        x r54 = x.f38692a;
        r36.a(r51, r52, r53);
    L67:
        r48 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_waiting, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_waiting"));
        d.h.b.o.c(r48, "getString(...)");
        goto L68
    L75:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.Queue.class) == false) goto L78;
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, true))));
        String r55 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_waiting, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_waiting"));
        d.h.b.o.c(r55, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r55, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        String r56 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_server_busy_thinking, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_server_busy_thinking"));
        d.h.b.o.c(r56, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r56, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r33.a(r37);
        goto L112
    L78:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.SetTimerTask.class) == false) goto L88;
        IAutoAgentWidgetStateListener.TimerTask r57 = ((WidgetState.SetTimerTask) ZeusTransformUtils.preCheckCast(r29, WidgetState.SetTimerTask.class, "com.obric.aiagent.plugin")).getTimerTask();
        if (r57 != null) goto L82;
        r33.a(r37, r13, r29.getSessionInfo().getSessionKey(), r29.getSessionInfo().getSessionId(), r29.getSessionInfo().getTask().getUserTask(), Long.valueOf(r34), false);
        goto L112
    L82:
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, true))));
        String r58 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_timer_set, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_timer_set"));
        d.h.b.o.c(r58, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r58, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r37.b(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getIconRes(AssistCardIconResType.TIME_LAPSE, false), Integer.valueOf(r12.getIconRes(AssistCardIconResType.TIME_LAPSE, true))));
        String r59 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_timer_execute_at, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_timer_execute_at"), new Object[]{r57.getTimeCondition()});
        d.h.b.o.c(r59, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r59, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        String r60 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_try_run, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_try_run"));
        d.h.b.o.c(r60, "getString(...)");
        CharSequence r61 = (CharSequence) ZeusTransformUtils.preCheckCast(r60, CharSequence.class, "com.obric.aiagent.plugin");
        String r62 = com.obric.autoaction.presentation.doubao.d.i.a();
        JSONObject r111 = new JSONObject();
        IAutoAgentWidgetStateListener.TimerTask r63 = ((WidgetState.SetTimerTask) ZeusTransformUtils.preCheckCast(r29, WidgetState.SetTimerTask.class, "com.obric.aiagent.plugin")).getTimerTask();
        if (r63 == null) goto L85;
        String r64 = r63.getId();
    L86:
        r111.put("timer_task_id", r64);
        x r65 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r37, null, r61, 0, null, r62, r111, false, 76, null);
        String r66 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_check_detail, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_check_detail"));
        d.h.b.o.c(r66, "getString(...)");
        CharSequence r67 = (CharSequence) ZeusTransformUtils.preCheckCast(r66, CharSequence.class, "com.obric.aiagent.plugin");
        String r68 = com.obric.autoaction.presentation.doubao.d.h.a();
        JSONObject r112 = new JSONObject();
        r112.put("session_id", r29.getSessionInfo().getSessionId());
        r112.put("timer_task_id", r57.getId());
        x r69 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r37, null, r67, 0, null, r68, r112, false, 76, null);
        int r70 = r12.getIdRes(AssistCardIdResType.ROOT);
        String r71 = com.obric.autoaction.presentation.doubao.d.h.a();
        JSONObject r72 = new JSONObject();
        r72.put("session_id", r29.getSessionInfo().getSessionId());
        r72.put("timer_task_id", r57.getId());
        x r73 = x.f38692a;
        r36.a(r70, r71, r72);
        goto L112
    L85:
        r64 = null;
        goto L86
    L88:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.UserInterrupt.class) == false) goto L95;
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.PAUSE, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.PAUSE, true))));
        String r74 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_paused"));
        d.h.b.o.c(r74, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r74, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        String r75 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_waiting_app_in_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_waiting_app_in_use"));
        d.h.b.o.c(r75, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r75, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r13, h.f24889c, r32), 0, 0, 12, null);
        r33.a(r37);
        IAutoActionAgentEventListener.OperatingAppInfo r76 = ((WidgetState.UserInterrupt) ZeusTransformUtils.preCheckCast(r29, WidgetState.UserInterrupt.class, "com.obric.aiagent.plugin")).getOperatingApp();
        if (r76 == null) goto L112;
        String r77 = r76.getPackageName();
        if (r77 == null) goto L112;
        r37.a(r77);
        goto L112
    L95:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.Preparing.class) == false) goto L104;
        r37.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, false), Integer.valueOf(r12.getBackgroundRes(AssistCardBgResType.DEFAULT, true))));
        String r78 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_waiting, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_waiting"));
        d.h.b.o.c(r78, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r78, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        AssistantAbilityHelper.MemorySettingConfig r79 = AssistantAbilityHelper.INSTANCE.queryMemorySettingConfig(r13);
        if (r79.getOUseMemory() == true) goto L99;
    L101:
        String r80 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_task_creating_ellipsis, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_task_creating_ellipsis"));
    L102:
        d.h.b.o.a(r80);
        com.obric.autoaction.presentation.doubao.a.b(r37, (CharSequence) ZeusTransformUtils.preCheckCast(r80, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r33.a(r37);
        goto L112
    L99:
        if (r79.getPersonalInfoMemory() == false) goto L101;
        r80 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_review_preferences, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_review_preferences"));
        goto L102
    L104:
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.Prepared.class) == true) goto L112;
        if (ZeusTransformUtils.instanceOf(r29, WidgetState.Terminated.class) == true) goto L112;
        if (r29 == null) goto L112;
        throw new d.k();
    }

    private final void a(com.obric.autoaction.presentation.doubao.a r15, Context r16) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        r15.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r15.a().getBackgroundRes(AssistCardBgResType.CLARIFY, false), Integer.valueOf(r15.a().getBackgroundRes(AssistCardBgResType.CLARIFY, true))));
        String r0 = r9.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_paused, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_paused"));
        d.h.b.o.c(r0, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r15, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r15.b(new com.obric.autoaction.presentation.doubao.a.C0577a(r15.a().getIconRes(AssistCardIconResType.LEFT_HAND_AI_FILL, false), Integer.valueOf(r15.a().getIconRes(AssistCardIconResType.LEFT_HAND_AI_FILL, true))));
        String r1 = r9.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_waiting_reply_question, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_waiting_reply_question"));
        d.h.b.o.c(r1, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.b(r15, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r9, h.f24887a, r15.b()), 0, 0, 12, null);
        a(r15);
        String r2 = r9.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_go_reply, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_go_reply"));
        d.h.b.o.c(r2, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.C0577a r4 = new com.obric.autoaction.presentation.doubao.a.C0577a(r15.a().getBackgroundRes(AssistCardBgResType.GRADIENT_ROUND, false), null, 2, null);
        String r5 = com.obric.autoaction.presentation.doubao.d.f24885e.a();
        int r3 = i.f24892a.a(r9, h.f24887a, r15.b());
        com.obric.autoaction.presentation.doubao.a.a(r15, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), r3, r4, r5, null, false, 96, null);
    }

    private final void a(com.obric.autoaction.presentation.doubao.a r16, Context r17, IAutoAgentWidgetStateListener.ClarifyBlackListParams r18) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L5;
        return;
    L5:
        r16.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r16.a().getBackgroundRes(AssistCardBgResType.CLARIFY, false), Integer.valueOf(r16.a().getBackgroundRes(AssistCardBgResType.CLARIFY, true))));
        String r0 = r12.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_title"));
        d.h.b.o.c(r0, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r16, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        r16.b(new com.obric.autoaction.presentation.doubao.a.C0577a(r16.a().getIconRes(AssistCardIconResType.LEFT_HAND_AI_FILL, false), Integer.valueOf(r16.a().getIconRes(AssistCardIconResType.LEFT_HAND_AI_FILL, true))));
        com.obric.autoaction.presentation.doubao.a.b(r16, (CharSequence) ZeusTransformUtils.preCheckCast(r18.getContentTitle(), CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r12, h.f24887a, r16.b()), 0, 0, 12, null);
        String r1 = r18.getNegativeString();
        com.obric.autoaction.presentation.doubao.a.C0577a r4 = new com.obric.autoaction.presentation.doubao.a.C0577a(r16.a().getBackgroundRes(AssistCardBgResType.GREY, false), Integer.valueOf(r16.a().getBackgroundRes(AssistCardBgResType.GREY, true)));
        JSONObject r6 = new JSONObject();
        r6.put("answer", r18.getNegativeString());
        String r5 = com.obric.autoaction.presentation.doubao.d.j.a();
        com.obric.autoaction.presentation.doubao.a.a(r16, null, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), 0, r4, r5, r6, false, 68, null);
        String r2 = r18.getPositiveString();
        com.obric.autoaction.presentation.doubao.a.C0577a r7 = new com.obric.autoaction.presentation.doubao.a.C0577a(r16.a().getBackgroundRes(AssistCardBgResType.GRADIENT_ROUND, false), null, 2, null);
        JSONObject r8 = new JSONObject();
        r8.put("answer", r18.getPositiveString());
        String r9 = com.obric.autoaction.presentation.doubao.d.j.a();
        int r3 = i.f24892a.a(r12, h.f24887a, r16.b());
        com.obric.autoaction.presentation.doubao.a.a(r16, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), r3, r7, r9, r8, false, 64, null);
    }

    static /* synthetic */ void a(c r13, com.obric.autoaction.presentation.doubao.a r14, Context r15, Long r16, String r17, String r18, String r19, String r20, Integer r21, boolean r22, Integer r23, int r24, Object r25) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
        if ((r24 & 128) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r24 & 256) == 0) goto L9;
        Integer r12 = null;
    L10:
        r13.a(r14, r4, r16, r17, r18, r19, r20, r21, r11, r12);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r11 = r22;
        goto L7
    }

    private final void a(com.obric.autoaction.presentation.doubao.a r24, Context r25, Long r26, String r27, String r28, String r29, String r30, Integer r31, boolean r32, Integer r33) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.aiagent.plugin");
        r24.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r24.a().getBackgroundRes(AssistCardBgResType.SUCCESS, false), Integer.valueOf(r24.a().getBackgroundRes(AssistCardBgResType.SUCCESS, true))));
        String r0 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_completed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_completed"));
        d.h.b.o.c(r0, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r24, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r14, h.f24890d, r24.b()), 0, 1, 4, null);
        r24.b(new com.obric.autoaction.presentation.doubao.a.C0577a(r24.a().getIconRes(AssistCardIconResType.CHECKMARK, false), Integer.valueOf(r24.a().getIconRes(AssistCardIconResType.CHECKMARK, true))));
        if (r27 != null) goto L5;
        String r1 = "";
    L6:
        r24.b((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r14, h.f24891e, r24.b()), 14, 0);
        int r16 = -1;
        if (r33 != null) goto L16;
        if (r32 == true) goto L10;
        String r2 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_save_command, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_save_command"));
    L11:
        d.h.b.o.a(r2);
        boolean r9 = !r32;
        String r5 = com.obric.autoaction.presentation.doubao.d.k.a();
        JSONObject r4 = new JSONObject();
        r4.put("doubao_message_id", r26);
        r4.put(DownloadConstants.QUERY_KEY, r27);
        r4.put("session_id", r28);
        r4.put("session_key", r29);
        r4.put("app_package_name", r30);
        if (r31 == null) goto L14;
        int r3 = r31.intValue();
    L15:
        r4.put("app_task_id", r3);
        String r21 = "session_id";
        String r10 = "app_task_id";
        com.obric.autoaction.presentation.doubao.a.a(r24, null, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), 0, null, r5, r4, r9, 12, null);
    L18:
        if (k.f24896a.a() == false) goto L20;
        String r6 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_share, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_share"));
        d.h.b.o.c(r6, "getString(...)");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        String r8 = com.obric.autoaction.presentation.doubao.d.f24883c.a();
        JSONObject r11 = new JSONObject();
        r11.put(r21, r28);
        x r12 = x.f38692a;
        String r13 = "getString(...)";
        com.obric.autoaction.presentation.doubao.a.a(r24, null, r7, 0, null, r8, r11, false, 76, null);
    L21:
        if (r30 == null) goto L27;
        String r15 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_jump_to_view, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_jump_to_view"));
        d.h.b.o.c(r15, r13);
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        String r18 = com.obric.autoaction.presentation.doubao.d.g.a();
        JSONObject r19 = new JSONObject();
        r19.put("app_package", r30);
        if (r31 == null) goto L25;
        r16 = r31.intValue();
    L25:
        r19.put(r10, r16);
        x r20 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r24, null, r17, 0, null, r18, r19, false, 76, null);
        return;
    L27:
        return;
    L20:
        r13 = "getString(...)";
        goto L21
    L14:
        r3 = -1;
        goto L15
    L10:
        r2 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_saved, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_saved"));
        goto L11
    L16:
        r21 = "session_id";
        r10 = "app_task_id";
        goto L18
    L5:
        r1 = r27;
        goto L6
    }

    private final void a(com.obric.autoaction.presentation.doubao.a r23, Context r24, String r25, String r26, String r27, Long r28, boolean r29) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin");
        r23.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r23.a().getBackgroundRes(AssistCardBgResType.CANCEL, false), Integer.valueOf(r23.a().getBackgroundRes(AssistCardBgResType.CANCEL, true))));
        String r5 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_status_finished, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_status_finished"));
        d.h.b.o.c(r5, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r23, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), 0, 0, 0, 14, null);
        if (r29 == false) goto L5;
        String r6 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_task_upgraded, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_task_upgraded"));
    L6:
        d.h.b.o.a(r6);
        com.obric.autoaction.presentation.doubao.a.b(r23, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), i.f24892a.a(r3, h.f24888b, r23.b()), 16, 0, 8, null);
        com.obric.autoaction.presentation.doubao.a.C0577a r12 = new com.obric.autoaction.presentation.doubao.a.C0577a(r23.a().getIconRes(AssistCardIconResType.TEXT, false), Integer.valueOf(r23.a().getIconRes(AssistCardIconResType.TEXT, true)));
        String r7 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_feedback, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_feedback"));
        d.h.b.o.c(r7, "getString(...)");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        String r16 = com.obric.autoaction.presentation.doubao.d.f24884d.a();
        JSONObject r8 = new JSONObject();
        r8.put("session_id", r26);
        r8.put("session_key", r25);
        r8.put("task_query", r27);
        r8.put("term_reason", 1);
        x r15 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r23, r12, r13, 0, null, r16, r8, false, 76, null);
        com.obric.autoaction.presentation.doubao.a.C0577a r14 = new com.obric.autoaction.presentation.doubao.a.C0577a(r23.a().getIconRes(AssistCardIconResType.REFRESH, false), Integer.valueOf(r23.a().getIconRes(AssistCardIconResType.REFRESH, true)));
        String r4 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_recreate, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_recreate"));
        d.h.b.o.c(r4, "getString(...)");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        String r18 = com.obric.autoaction.presentation.doubao.d.f.a();
        JSONObject r9 = new JSONObject();
        r9.put("session_id", r26);
        r9.put("task_query", r27);
        if (r28 == null) goto L9;
        ((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.aiagent.plugin")).longValue();
        r9.put("doubao_message_id", r28.longValue());
    L9:
        x r0 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r23, r14, r17, 0, null, r18, r9, false, 76, null);
        return;
    L5:
        r6 = r3.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_deleted_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_deleted_task"));
        goto L6
    }

    private final void a(com.obric.autoaction.presentation.doubao.a r18, Context r19, String r20, String r21, String r22, int r23) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        r18.a(new com.obric.autoaction.presentation.doubao.a.C0577a(r18.a().getBackgroundRes(AssistCardBgResType.FAILURE, false), Integer.valueOf(r18.a().getBackgroundRes(AssistCardBgResType.FAILURE, true))));
        String r0 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_failed"));
        d.h.b.o.c(r0, "getString(...)");
        int r2 = i.f24892a.a(r13, h.g, r18.b());
        com.obric.autoaction.presentation.doubao.a.a(r18, (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), r2, 0, 1, 4, null);
        r18.b(new com.obric.autoaction.presentation.doubao.a.C0577a(r18.a().getIconRes(AssistCardIconResType.EXCLAMATION_MARK, false), Integer.valueOf(r18.a().getIconRes(AssistCardIconResType.EXCLAMATION_MARK, true))));
        int r1 = i.f24892a.a(r13, h.f24891e, r18.b());
        r18.b((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin"), r1, 14, 0);
        com.obric.autoaction.presentation.doubao.a.C0577a r3 = new com.obric.autoaction.presentation.doubao.a.C0577a(r18.a().getIconRes(AssistCardIconResType.TEXT, false), Integer.valueOf(r18.a().getIconRes(AssistCardIconResType.TEXT, true)));
        String r4 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_feedback, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_feedback"));
        d.h.b.o.c(r4, "getString(...)");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        String r6 = com.obric.autoaction.presentation.doubao.d.f24884d.a();
        JSONObject r7 = new JSONObject();
        r7.put("session_id", r22);
        r7.put("session_key", r21);
        r7.put("task_query", r20);
        r7.put("term_reason", r23);
        x r8 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r18, r3, r5, 0, null, r6, r7, false, 76, null);
        if (k.f24896a.a() == false) goto L6;
        String r9 = r13.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_check_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_check_all"));
        d.h.b.o.c(r9, "getString(...)");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        String r11 = com.obric.autoaction.presentation.doubao.d.f24883c.a();
        JSONObject r12 = new JSONObject();
        r12.put("session_id", r22);
        x r14 = x.f38692a;
        com.obric.autoaction.presentation.doubao.a.a(r18, null, r10, 0, null, r11, r12, false, 76, null);
        return;
    }

    private final void a(com.obric.autoaction.presentation.doubao.a r11) {
        com.obric.autoaction.presentation.doubao.a.C0577a r1 = new com.obric.autoaction.presentation.doubao.a.C0577a(r11.a().getIconRes(AssistCardIconResType.STOP, false), Integer.valueOf(r11.a().getIconRes(AssistCardIconResType.STOP, true)));
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_stop, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_stop"));
        d.h.b.o.c(r10, "getString(...)");
        com.obric.autoaction.presentation.doubao.a.a(r11, r1, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"), 0, null, com.obric.autoaction.presentation.doubao.d.f24881a.a(), null, false, 108, null);
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public Object a(Context r23, Uri r24, String r25, final JSONObject r26, d.c.d<? super x> r27) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.presentation.doubao.d[] r2 = com.obric.autoaction.presentation.doubao.d.values();
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        com.obric.autoaction.presentation.doubao.d r7 = r2[r5];
        if (d.h.b.o.a(r7.a(), r25) == true) goto L10;
        r5 = r5 + 1;
    L10:
        if (r26 == null) goto L14;
        String r6 = r26.optString("session_id", "");
        if (r6 == null) goto L14;
    L15:
        if (r7 != null) goto L17;
        int r8 = -1;
    L19:
        switch(r8) {
            case 1: goto L95;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L87;
            case 5: goto L75;
            case 6: goto L72;
            case 7: goto L60;
            case 8: goto L51;
            case 9: goto L44;
            case 10: goto L43;
            case 11: goto L21;
            default: goto L97;
        };
    L21:
        if (r26 == null) goto L23;
        String r13 = r26.optString("session_id");
    L24:
        if (r26 == null) goto L26;
        String r14 = r26.optString("session_key");
    L27:
        if (r26 == null) goto L29;
        String r9 = r26.optString(DownloadConstants.QUERY_KEY);
    L30:
        if (r26 == null) goto L32;
        Long r10 = d.c.b.a.b.a(r26.optLong("doubao_message_id"));
    L33:
        if (r13 == null) goto L41;
        if (r14 == null) goto L41;
        if (r9 == null) goto L41;
        if (r10 == null) goto L41;
        IAutoActionPresentationApi r11 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L97;
        long r16 = r10.longValue();
        HashMap r12 = new HashMap();
        r12.put("app_package_name", r26.optString("app_package_name"));
        r12.put("app_task_id", d.c.b.a.b.a(r26.optInt("app_task_id")));
        x r0 = x.f38692a;
        IAutoActionPresentationApi.DefaultImpls.openShortCutDetailsPage$default(r11, r4, "enter_from_doubao_msg_card", null, r9, new AssistRemoteCardUIParams(3, r13, r14, r9, r16, r12), 4, null);
    L41:
        Loog.INSTANCE.e(TAG, "[AssistRemoteCard] save as shortcut error " + r26);
        return x.f38692a;
    L32:
        r10 = null;
        goto L33
    L29:
        r9 = null;
        goto L30
    L26:
        r14 = null;
        goto L27
    L23:
        r13 = null;
        goto L24
    L43:
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r26, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L97
    L44:
        if (r26 == null) goto L46;
        String r15 = r26.optString("timer_task_id");
    L47:
        IAutoActionPresentationApi r17 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L97;
        r17.openTaskListPage((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r15, "click_assistant_card");
        goto L97
    L46:
        r15 = null;
        goto L47
    L60:
        if (r26 == null) goto L62;
        long r18 = r26.optLong("doubao_message_id", -1);
    L63:
        if (r26 == null) goto L67;
        String r19 = r26.optString("task_query", r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_doubao_launched_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_doubao_launched_task")));
        if (r19 == null) goto L67;
    L69:
        if (r18 != (-1)) goto L71;
        com.obric.autoaction.presentation.doubao.b.a(com.obric.autoaction.presentation.doubao.b.f24860a, r19, 0, 2, null);
        goto L97
    L71:
        com.obric.autoaction.presentation.doubao.b.f24860a.a(r19, r18);
    L67:
        r19 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_doubao_launched_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_doubao_launched_task"));
        d.h.b.o.c(r19, "getString(...)");
        goto L69
    L62:
        r18 = -1;
        goto L63
    L72:
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionPresentationApi r21 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L97;
        r21.openPlayer(r20, "click_assistant_card", $$Lambda$c$ht92nzaaVOed7N_vDIJUup2Izn8.INSTANCE);
        goto L97
    L75:
        if (r26 == null) goto L77;
        int r22 = r26.optInt("term_reason", 1);
    L78:
        if (r26 == null) goto L82;
        String r28 = r26.optString("task_query", r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_doubao_launched_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_doubao_launched_task")));
        if (r28 == null) goto L82;
    L83:
        if (r26 == null) goto L85;
        String r29 = r26.optString("session_key", "");
    L86:
        com.obric.autoaction.presentation.doubao.b.f24860a.a(r29, r6, r28, r22);
        goto L97
    L85:
        r29 = null;
    L82:
        r28 = r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_doubao_launched_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_doubao_launched_task"));
        d.h.b.o.c(r28, "getString(...)");
        goto L83
    L77:
        r22 = 1;
        goto L78
    L87:
        AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new C0579c(r26, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        goto L97
    L91:
        if (r26 == null) goto L93;
        final long r30 = r26.optLong("doubao_message_id", -1);
    L94:
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(new com.obric.aiagent.assistant_card.provider_core.bean.b(r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_confirm_delete_timer_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_confirm_delete_timer_task")), "", r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_dialog_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_dialog_cancel")), r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_delete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_delete")), (IHostApiCallback) ZeusTransformUtils.preCheckCast(new AssistRemoteCardProvider$onActionTriggered$4(), IHostApiCallback.class, "com.obric.aiagent.plugin"), (IHostApiCallback) ZeusTransformUtils.preCheckCast(new AssistRemoteCardProvider$onActionTriggered$5(this, r26, r30), IHostApiCallback.class, "com.obric.aiagent.plugin")));
        goto L97
    L93:
        r30 = -1;
        goto L94
    L95:
        com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(new com.obric.aiagent.assistant_card.provider_core.bean.b(r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_confirm_stop_task, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_confirm_stop_task")), "", r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_dialog_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_dialog_cancel")), r4.getString(ZeusTransformUtils.mapRes(R.string.obric_widget_stop, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_stop")), (IHostApiCallback) ZeusTransformUtils.preCheckCast(new AssistRemoteCardProvider$onActionTriggered$2(), IHostApiCallback.class, "com.obric.aiagent.plugin"), (IHostApiCallback) ZeusTransformUtils.preCheckCast(new AssistRemoteCardProvider$onActionTriggered$3(), IHostApiCallback.class, "com.obric.aiagent.plugin")));
        goto L97
    L51:
        if (r26 == null) goto L53;
        int r31 = r26.optInt("app_task_id", -1);
    L54:
        if (r26 == null) goto L56;
        String r32 = r26.optString("app_package");
    L57:
        if (r32 != null) goto L59;
        Loog.INSTANCE.e(TAG, "[AssistRemoteCard] cannot open target app: " + r26 + " (taskId=" + r31 + ')');
        goto L97
    L59:
        com.obric.autoaction.presentation.doubao.b.f24860a.b(r32);
        goto L97
    L56:
        r32 = null;
        goto L57
    L53:
        r31 = -1;
        goto L54
    L89:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L97;
        com.obric.autoaction.presentation.doubao.b.f24860a.a(r6);
    L97:
        return x.f38692a;
    L17:
        r8 = b.f24876a[r7.ordinal()];
    L14:
        r6 = "";
        goto L15
    L8:
        r7 = null;
        goto L10
    }

    private static final x a(Intent r2) {
        d.h.b.o.e(r2, "$this$openPlayer");
        r2.putExtra("start_clarify_input", true);
        return x.f38692a;
    }
}
