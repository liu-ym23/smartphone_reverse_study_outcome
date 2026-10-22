package com.obric.agent;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.DescriptorProtos;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowFindMessagesCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.assistant.dm.api.IDialogManagement;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.ContactsDeleteParams;
import com.obric.capabilitykit.common.intent.GUIReplyParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MemoryProduceParams;
import com.obric.capabilitykit.common.intent.PhoneDeleteParams;
import com.obric.capabilitykit.common.intent.SemanticSupplementParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.capabilitykit.common.intent.SystemDownloadAppParams;
import com.obric.capabilitykit.common.intent.SystemScreenRecordParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.lark.LarkContactSearchResult;
import com.obric.capabilitykit.entity.lark.LarkContacts;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.logger.ILogger;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.ConditionTaskSpec;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.funcall_api.IIntentActionService;
import com.obric.funcall_api.OnAppActionListener;
import com.obric.funcall_api.bean.AppAction;
import com.obric.funcall_api.bean.ECAAction;
import com.obric.funcall_api.bean.ECAData;
import com.obric.funcall_api.bean.ECAJob;
import com.obric.funcall_api.bean.IntentAppAction;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantIntentSearchResponse;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchEntityResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchMemoryResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.obric.memorydata.sdk.entity.global.ProactiveRecommendationSearchResult;
import com.obric.memorydata.sdk.entity.search.AssistantQuResult;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.obric.memorydata.sdk.entity.search.SearchResult;
import com.obric.memorydata.sdk.memory.MemoryServiceProxy;
import com.obric.memorydata.sdk.service.PermissionCheckResult;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import d.h.b.ad;
import java.io.File;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.dg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ObricService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricService {
    private static final String CALENDAR_APP_NAME = "日历";
    private static final String CALENDAR_MINI_APP_PACKAGE_NAME = "com.obric.appletapp";
    private static final String CALENDAR_MINI_APP_SHORTCUT_ID = "miniapp.com.flow.calendar";
    private static final String DOU_BAO_APP_NAME = "豆包";
    private static final String DOU_BAO_PACKAGE_NAME = "com.larus.nova";
    private static final int FETCH_LATEST_MESSAGE_COUNT = 5;
    private static final long FETCH_LATEST_MESSAGE_TIMEOUT = 3000;
    public static final ObricService INSTANCE = null;
    private static final String KEY_SEMANTIC_TRACE_FAILURE_CODE = "semantic_trace_failure_code";
    private static final String KEY_SEMANTIC_TRACE_FAILURE_MSG = "semantic_trace_failure_msg";
    private static final long LOCAL_QUERY_CHECK_TIMEOUT = 1000;
    private static final String QUERY_CHECK_SOURCE_CACHE = "cache";
    private static final String QUERY_CHECK_SOURCE_FETCH = "fetch";
    private static final String QUERY_CHECK_SOURCE_LOCAL = "local";
    private static final String QUERY_CHECK_SOURCE_MISS = "miss";
    private static final String QUERY_CHECK_SOURCE_SKIP = "skip";
    private static final long SEMANTIC_EDIT_RESULT_TIMEOUT = 5000;
    private static final String TAG = null;
    private static final d.f gson$delegate = null;
    private static final ObricService$intentQueryMap$1 intentQueryMap = null;
    private static final d.f keyguardManager$delegate = null;
    private static final ObricService$knowledgeConfirmCache$1 knowledgeConfirmCache = null;
    private static final ObricService$nlgForPCSearch$1 nlgForPCSearch = null;

    /* JADX INFO: renamed from: com.obric.agent.ObricService$awaitSemanticEditResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {808}, d = "awaitSemanticEditResult", e = "com.obric.agent.ObricService")
    static final class AnonymousClass1 extends d.c.b.a.d {
        long J$0;
        long J$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricService this$0;

        AnonymousClass1(ObricService r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return ObricService.access$awaitSemanticEditResult(this.this$0, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.agent.ObricService$collect$2, reason: invalid class name */
    /* JADX INFO: compiled from: ObricService.kt */
    public static final class AnonymousClass2<T> implements kotlinx.coroutines.b.i<T> {
        final /* synthetic */ d.h.a.m<T, d.c.d<? super d.x>, Object> $action;

        public AnonymousClass2(d.h.a.m<? super T, ? super d.c.d<? super d.x>, ? extends Object> r3) {
            this.$action = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        }

        @Override // kotlinx.coroutines.b.i
        public Object emit(T r3, d.c.d<? super d.x> r4) {
            d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            Object r2 = this.$action.invoke(r3, r5);
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return d.x.f38692a;
        }

        public Object emit$$forInline(T r3, d.c.d<? super d.x> r4) {
            final d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d.h.b.m.a(4);
            new ObricService$collect$2$emit$1(this, r5);
            d.h.b.m.a(5);
            this.$action.invoke(r3, r5);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$dispatchAction$7, reason: invalid class name */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.ObricService$dispatchAction$7")
    static final class AnonymousClass7 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {
        final /* synthetic */ IntentAppAction $action;
        int label;

        AnonymousClass7(IntentAppAction r3, d.c.d<? super AnonymousClass7> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.$action = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass7(this.$action, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super d.x> r4) {
            return ((AnonymousClass7) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass7.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            d.o.a(r2);
            com.obric.capability.schedulekit.a r3 = com.obric.capability.schedulekit.a.f31846a;
            String r1 = ObricService.INSTANCE.getGson().toJson(this.$action);
            d.h.b.o.c(r1, "toJson(...)");
            r3.a(r1, true);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$dispatchIMAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {302, 354, 402, 454, 498, 526}, d = "invokeSuspend", e = "com.obric.agent.ObricService$dispatchIMAction$1")
    static final class C11051 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {
        final /* synthetic */ IntentAppAction $action;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        int label;

        C11051(IntentAppAction r3, d.c.d<? super C11051> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.$action = r3;
            super(2, r5);
        }

        public static /* synthetic */ d.x lambda$ZIjuPw984T7IULucAwqlRklhLjw(IntentAppAction r0, String r1, String r2) {
            return invokeSuspend$lambda$14(r0, r1, r2);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            C11051 r0 = new C11051(this.$action, r5);
            r0.L$0 = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super d.x> r4) {
            return ((C11051) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11051.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:218:0x076f -> B:220:0x0772). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r48) {
            Object r2 = d.c.a.b.a();
            String r11 = "System_AutoAction";
            switch(this.label) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L455;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            d.h.b.z.f r0 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.L$0, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r48);
            d.h.b.z.f r3 = r0;
            String r4 = "System_AutoAction";
            String r12 = "com.obric.aiagent.plugin";
            Object r1 = r48;
        L305:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, r12)).booleanValue() == true) goto L307;
        L308:
            DMState r13 = null;
        L409:
            IDialogStateManager r5 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, r12);
            if (r5 == null) goto L412;
            DMState r6 = r5.getCurrentDMState();
        L413:
            if (r6 != null) goto L415;
        L417:
            boolean r15 = false;
        L418:
            if (r15 == true) goto L420;
        L431:
            ConcurrentHashMap<String, String> r7 = this.$action.getExt();
            if (r7 == null) goto L434;
            String r14 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_reference_msg_id"), String.class, r12);
        L435:
            if (r14 != 0) goto L437;
        L439:
            ObricService.INSTANCE.dispatchAction(this.$action);
            ILogDepend.Companion.i(ObricService.access$getTAG$p(), "OnAppActionListener onChange " + this.$action.getQuestionId());
        L441:
            return d.x.f38692a;
        L437:
            if (d.h.b.o.a(r3.f38504a, r4) == false) goto L439;
            IntentAppAction r8 = IntentAppAction.copy$default(this.$action, 0, Long.parseLong(r14), 0, null, null, 0, 0, null, 253, null);
            ObricService.INSTANCE.dispatchAction(r8);
            ILogDepend.Companion.i(ObricService.access$getTAG$p(), "OnAppActionListener onChange change msg id:" + r8.getQuestionId());
            goto L441
        L434:
            r14 = r13;
            goto L435
        L420:
            if (r6.isQuerying() == true) goto L431;
            ConcurrentHashMap<String, String> r9 = this.$action.getExt();
            if (r9 == null) goto L424;
            Object r10 = (String) ZeusTransformUtils.preCheckCast(r9.get("o_task_type"), String.class, r12);
        L425:
            boolean r16 = d.h.b.o.a(r10, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "DM no task, not do action " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) + ", return! isComplexTask:" + r16);
            com.obric.agent.trace.g.f15449a.a(String.valueOf(this.$action.getQuestionId()), String.valueOf(this.$action.getMessageId()), (String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12), r16);
            if (r16 == false) goto L431;
            if (d.h.b.o.a(r3.f38504a, r4) == false) goto L431;
            return d.x.f38692a;
        L424:
            r10 = r13;
            goto L425
        L415:
            if (r6.isIdle() != true) goto L417;
            r15 = true;
            goto L418
        L412:
            r6 = r13;
            goto L413
        L307:
            return d.x.f38692a;
        L11:
            int r17 = this.I$2;
            int r18 = this.I$1;
            int r19 = this.I$0;
            String r20 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.aiagent.plugin");
            d.o.a(r48);
            r12 = "com.obric.aiagent.plugin";
        L220:
            IAgentService r21 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, r12);
            if (r21 == null) goto L224;
            r21.getScreenPicInfo(false, false);
        L224:
            r17 = r17 + 1;
        L216:
            if (r17 >= r18) goto L225;
            this.L$0 = r20;
            this.I$0 = r19;
            this.I$1 = r18;
            this.I$2 = r17;
            this.label = 4;
            if (ax.a(200, this) != r2) goto L220;
            return r2;
        L225:
            int r110 = r19;
            String r22 = r20;
        L227:
            IAgentService r23 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, r12);
            if (r23 == null) goto L230;
            PicInfo r111 = r23.getScreenPicInfo(false, false);
        L231:
            if (r111 == null) goto L233;
            String r24 = String.valueOf(r111.getTosKey());
            int r25 = 0;
        L235:
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(this.$action, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(r25, r24, null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), true, false, false, 12, null);
            return d.x.f38692a;
        L233:
            r24 = r22;
            r25 = r110;
            goto L235
        L230:
            r111 = null;
            goto L231
        L12:
            d.o.a(r48);
        L159:
            return d.x.f38692a;
        L13:
            am r26 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            d.o.a(r48);
            Object r27 = r48;
            String r28 = "type";
            String r112 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
            String r29 = "Parse content JSON failed: ";
            r11 = "System_AutoAction";
            r12 = "com.obric.aiagent.plugin";
            String r113 = "enable";
        L91:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r27, Boolean.class, r12)).booleanValue() != true) goto L93;
            boolean r30 = true;
        L94:
            if (r30 == false) goto L100;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), this.$action.getQuestionId() + " query interrupted, abort dispatch actions");
            IIntentTraceService r31 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, r12);
            if (r31 == null) goto L99;
            r31.onMessageInterrupt(String.valueOf(this.$action.getQuestionId()));
            d.x r32 = d.x.f38692a;
        L99:
            return d.x.f38692a;
        L100:
            r3 = new d.h.b.z.f();
            ECAData r33 = this.$action.getECAData();
            if (r33 == null) goto L111;
            List<ECAJob> r34 = r33.getJobs();
            if (r34 == null) goto L111;
            ECAJob r35 = (ECAJob) ZeusTransformUtils.preCheckCast(d.a.p.d(r34, 0), ECAJob.class, r12);
            if (r35 == null) goto L111;
            List<ECAAction> r36 = r35.getActions();
            if (r36 == null) goto L111;
            ECAAction r37 = (ECAAction) ZeusTransformUtils.preCheckCast(d.a.p.d(r36, 0), ECAAction.class, r12);
            if (r37 == null) goto L111;
            T r38 = r37.getActionName();
        L112:
            r3.f38504a = r38;
            String r210 = r29;
            ILogDepend.Companion.i(ObricService.access$getTAG$p(), "intentName = " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)));
            r4 = r11;
            if (d.h.b.o.a(r3.f38504a, r4) == false) goto L154;
            IFlowUiIDL r39 = aw.a(aa.b(IFlowUiIDL.class));
            if (r39 == null) goto L117;
            r39.notifyMessageInAutoGui(String.valueOf(this.$action.getQuestionId()));
            d.x r40 = d.x.f38692a;
        L117:
            ConcurrentHashMap<String, String> r41 = this.$action.getExt();
            if (r41 == null) goto L122;
            String r42 = (String) ZeusTransformUtils.preCheckCast(r41.get("o_event_task"), String.class, r12);
            if (r42 == null) goto L122;
            com.obric.agent.utils.u r43 = com.obric.agent.utils.u.f16076a;
            Gson r44 = ObricService.INSTANCE.getGson();
            d.h.b.o.c(r44, "<get-gson>(...)");
            com.obric.eventkit.task.model.a r45 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(r43.a(r44, r42, com.obric.eventkit.task.model.a.class, "dispatchIMAction_EventTaskInfo"), com.obric.eventkit.task.model.a.class, r12);
        L123:
            if (r45 == null) goto L308;
            IntentAppAction r46 = this.$action;
            TaskKnowledge r47 = r45.f();
            if (r47 == null) goto L127;
            int r49 = r47.getClarifyCount();
        L129:
            if (d.h.b.o.a(ObricService.access$getKnowledgeConfirmCache$p().get(String.valueOf(r46.getQuestionId())), d.c.b.a.b.a(false)) == false) goto L131;
        L132:
            r45.a(null);
        L133:
            String r211 = ObricService.access$destructInputParams(ObricService.INSTANCE, r46);
            if (r211 == null) goto L308;
            com.obric.agent.utils.u r212 = com.obric.agent.utils.u.f16076a;
            Gson r50 = ObricService.INSTANCE.getGson();
            d.h.b.o.c(r50, "<get-gson>(...)");
            SystemAutoActionParams r51 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r212.a(r50, r211, SystemAutoActionParams.class, new SystemAutoActionParams(null, null, null, null, null, null, null, null, 255, null), "dispatchIMAction_SystemAutoActionParams"), SystemAutoActionParams.class, r12);
            String r52 = r51.getMeta();
            if (r52 == null) goto L138;
            JSONObject r53 = new JSONObject(r52);
        L139:
            if (r53 != null) goto L141;
            r53 = new JSONObject();
        L141:
            r53.put("o_event_task", ObricService.INSTANCE.getGson().toJson(r45));
            r51.setMeta(r53.toString());
            r51.setTaskId(r45.b());
            Integer r54 = r45.g();
            if (r54 != null) goto L145;
        L146:
            boolean r55 = true;
        L148:
            r51.setRequestAuth(d.c.b.a.b.a(r55));
            if (d.h.b.o.a(r45.h(), d.c.b.a.b.a(true)) == false) goto L151;
            String r56 = "TEST_RUN";
        L152:
            r51.setExecutionMode(r56);
            r46.setContent(com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(r51), null));
            d.x r57 = d.x.f38692a;
            goto L308
        L151:
            r56 = "DEFAULT";
            goto L152
        L145:
            if (r54.intValue() != 2) goto L146;
            r55 = false;
            goto L148
        L138:
            r53 = null;
            goto L139
        L131:
            if (r49 > d.f14409a.g()) goto L133;
        L127:
            r49 = 0;
        L122:
            r45 = null;
            goto L123
        L154:
            if (d.h.b.o.a(r3.f38504a, "Semantic_Supplement") == false) goto L161;
            ObricService r58 = ObricService.INSTANCE;
            IntentAppAction r59 = this.$action;
            d.c.d r60 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r12);
            this.L$0 = null;
            this.label = 3;
            if (ObricService.access$handleSemanticSupplement(r58, r59, r60) != r2) goto L159;
            return r2;
        L161:
            if (d.h.b.o.a(r3.f38504a, "Assistant_ScreenSenselightControl") == true) goto L457;
            String r114 = r210;
            if (d.h.b.o.a(r3.f38504a, "GUI_Reply") == false) goto L195;
            String r61 = ObricService.access$destructInputParams(ObricService.INSTANCE, this.$action);
            if (r61 == null) goto L308;
            IntentAppAction r62 = this.$action;
            com.obric.agent.utils.u r63 = com.obric.agent.utils.u.f16076a;
            Gson r64 = ObricService.INSTANCE.getGson();
            d.h.b.o.c(r64, "<get-gson>(...)");
            GUIReplyParams r65 = (GUIReplyParams) ZeusTransformUtils.preCheckCast(r63.a(r64, r61, GUIReplyParams.class, "dispatchIMAction_GUI_Reply"), GUIReplyParams.class, r12);
            if (r65 != null) goto L190;
        L192:
            IntentAppAction r66 = IntentAppAction.copy$default(r62, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, null, null, 0, null, null, 62, null)), null, 0, 0, null, 247, null);
            com.obric.agent.utils.b.f15994a.a(r66);
            com.obric.agent.network.a.f15206a.a(r66, false, false, false);
            return d.x.f38692a;
        L190:
            if (r65.getContent() == null) goto L192;
            d.x r67 = d.x.f38692a;
            goto L192
        L195:
            if (d.h.b.o.a(r3.f38504a, "Assistant_GetQueryScreenshot") == false) goto L238;
            r22 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), r12), Application.class, r12)).getString(ZeusTransformUtils.mapRes(R.string.obric_no_screenshot, r112, "obric_no_screenshot"));
            d.h.b.o.c(r22, "getString(...)");
            IAgentService r68 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, r12);
            if (r68 != null) goto L199;
        L201:
            boolean r69 = false;
        L202:
            if (r69 == false) goto L234;
            IAgentService r70 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, r12);
            if (r70 == null) goto L206;
            PicInfo r71 = r70.getScreenPicInfo(false, false);
        L207:
            if (r71 != null) goto L226;
            IAgentService r72 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, r12);
            if (r72 != null) goto L211;
        L213:
            boolean r73 = false;
        L214:
            if (r73 == false) goto L226;
            r18 = 25;
            r20 = r22;
            r17 = 0;
            r19 = 1;
            goto L216
        L211:
            if (r72.hasSemantic() != true) goto L213;
            r73 = true;
        L226:
            r110 = 1;
            goto L227
        L206:
            r71 = null;
            goto L207
        L234:
            r24 = r22;
            r25 = 1;
            goto L235
        L199:
            if (r68.isScreenshotSecure() == true) goto L201;
            r69 = true;
            goto L202
        L238:
            if (d.h.b.o.a(r3.f38504a, "Assistant_EventTaskKnowLedgeConfirm") == false) goto L290;
            ConcurrentHashMap<String, String> r74 = this.$action.getExt();     // Catch: JSONException -> L282
            if (r74 == null) goto L244;
            String r75 = (String) ZeusTransformUtils.preCheckCast(r74.get("o_event_task"), String.class, r12);     // Catch: JSONException -> L282
            if (r75 == null) goto L244;
            com.obric.agent.utils.u r76 = com.obric.agent.utils.u.f16076a;     // Catch: JSONException -> L282
            Gson r77 = ObricService.INSTANCE.getGson();     // Catch: JSONException -> L282
            d.h.b.o.c(r77, "<get-gson>(...)");     // Catch: JSONException -> L282
            com.obric.eventkit.task.model.a r78 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(r76.a(r77, r75, com.obric.eventkit.task.model.a.class, "dispatchIMAction_EventTaskKnowLedgeConfirm"), com.obric.eventkit.task.model.a.class, r12);     // Catch: JSONException -> L282
        L245:
            String r79 = this.$action.getContent();     // Catch: JSONException -> L282
            d.h.b.o.a(r79);     // Catch: JSONException -> L282
            JSONArray r80 = new JSONObject(new JSONObject(r79).optString("Content")).optJSONArray("jobs");     // Catch: JSONException -> L282
            if (r80 == null) goto L254;
            JSONObject r81 = r80.optJSONObject(0);     // Catch: JSONException -> L282
            if (r81 == null) goto L254;
            JSONArray r82 = r81.optJSONArray("actions");     // Catch: JSONException -> L282
            if (r82 == null) goto L254;
            JSONObject r83 = r82.optJSONObject(0);     // Catch: JSONException -> L282
            if (r83 == null) goto L254;
            JSONObject r84 = r83.optJSONObject("inputParams");     // Catch: JSONException -> L282
        L256:
            if (r84 == null) goto L258;
            String r85 = r84.optString("action");     // Catch: JSONException -> L282
        L259:
            boolean r86 = new JSONObject(r85).optString("value").equals(d.f14409a.f());     // Catch: JSONException -> L282
            if (r78 == null) goto L287;
            IntentAppAction r87 = this.$action;     // Catch: JSONException -> L282
            TaskKnowledge r213 = r78.f();     // Catch: JSONException -> L282
            if (r213 == null) goto L287;
            if (r86 == false) goto L265;
            boolean r115 = true;
        L266:
            ((Map) ZeusTransformUtils.preCheckCast(ObricService.access$getKnowledgeConfirmCache$p(), Map.class, r12)).put(String.valueOf(r87.getQuestionId()), d.c.b.a.b.a(r115));     // Catch: JSONException -> L282
            int r88 = r213.getClarifyCount();     // Catch: JSONException -> L282
            if (r86 == false) goto L269;
            int r89 = r88 + 1;     // Catch: JSONException -> L282
        L270:
            int r214 = r89;
            if (r78.a() != 2) goto L273;
            EventTaskSpec r90 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ConditionTaskSpec(null, null, TaskKnowledge.copy$default(r213, false, null, null, r214, false, null, 55, null), null, null, null, null, null, null, null, null, null, 4090, null), EventTaskSpec.class, r12);     // Catch: JSONException -> L282
        L274:
            String r91 = r78.b();     // Catch: JSONException -> L282
            if (r91 == null) goto L287;
            IEventTaskApi r92 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, r12);     // Catch: JSONException -> L282
            if (r92 == null) goto L284;
            this.L$0 = null;     // Catch: JSONException -> L282
            this.label = 5;     // Catch: JSONException -> L282
            Object r93 = r92.updateEventTask(r91, r90, this);     // Catch: JSONException -> L282
            if (r93 != r2) goto L281;
            return r2;
        L281:
            EventTaskResult r94 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r93, EventTaskResult.class, r12);     // Catch: JSONException -> L282
        L284:
            kotlinx.coroutines.i.a(e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ObricService$dispatchIMAction$1$5$1$1$1(null), d.h.a.m.class, r12), 3, null);     // Catch: JSONException -> L282
            goto L287
        L273:
            r90 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(new ShortcutTaskSpec(null, null, TaskKnowledge.copy$default(r213, false, null, null, r214, false, null, 55, null), null, null, null, null, null, null, null, null, 2042, null), EventTaskSpec.class, r12);     // Catch: JSONException -> L282
            goto L274
        L269:
            r89 = r88 - 1;     // Catch: JSONException -> L282
            goto L270
        L265:
            r115 = false;
        L287:
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(this.$action, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, null, null, 0, null, null, 62, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
            return d.x.f38692a;
        L258:
            r85 = null;
        L254:
            r84 = null;
        L244:
            r78 = null;
        L282:
            e = e;
        L286:
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), r114 + e.getMessage());
            d.x r95 = d.x.f38692a;
            goto L287
        L290:
            if (com.obric.agent.office.a.f15240a.a((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12), this.$action) == false) goto L296;
            if (com.obric.agent.office.a.f15240a.a(this.$action) == false) goto L308;
            return d.x.f38692a;
        L296:
            if (com.obric.agent.office.b.f15285a.a((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) == false) goto L310;
            String r96 = (String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12);
            if (r96 != null) goto L301;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "dispatchIMAction: intentName is null in office branch");
            return d.x.f38692a;
        L301:
            com.obric.agent.office.b r97 = com.obric.agent.office.b.f15285a;
            IntentAppAction r98 = this.$action;
            $$Lambda$ObricService$dispatchIMAction$1$ZIjuPw984T7IULucAwqlRklhLjw r99 = $$Lambda$ObricService$dispatchIMAction$1$ZIjuPw984T7IULucAwqlRklhLjw.INSTANCE;
            d.c.d<? super Boolean> r100 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r12);
            this.L$0 = r3;
            this.label = 6;
            r1 = r97.a(r98, r96, r99, r100);
            if (r1 != r2) goto L305;
            return r2;
        L310:
            if (d.h.b.o.a(r3.f38504a, "Memory_Produce") == false) goto L312;
        L380:
            IntentAppAction r101 = this.$action;
            IEntityManager r102 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, r12);
            if (r102 == null) goto L385;
            String r103 = r102.replaceECAIdToEntity(this.$action.getContent(), this.$action.getQuestionId());
            if (r103 == null) goto L385;
        L386:
            r101.setContent(r103);
            String r104 = ObricService.access$destructInputParams(ObricService.INSTANCE, this.$action);
            ILogDepend.Companion.w(ObricService.access$getTAG$p(), "onReceived intent " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) + ", params = " + r104);
            if (r104 == null) goto L308;
            IntentAppAction r105 = this.$action;
            JSONObject r106 = new JSONObject(r104);
            JSONArray r116 = r106.optJSONArray("targets");
            ILogDepend.Companion.w(ObricService.access$getTAG$p(), "onReceived intent " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) + ", targets = " + r116);
            if (r116 == null) goto L406;
            JSONArray r107 = new JSONArray();
            int r117 = r116.length();
            int r118 = 0;
        L391:
            if (r118 >= r117) goto L405;
            JSONObject r119 = r116.optJSONObject(r118);
            JSONObject r120 = new JSONObject();
            JSONArray r410 = r116;
            if (r119 == null) goto L395;
            String r121 = r119.optString(DbHelper.COL_ID);
        L396:
            r120.put(DbHelper.COL_ID, r121);
            if (r119 == null) goto L399;
            String r122 = r119.optString("_packageName");
        L400:
            r120.put("_packageName", r122);
            String r123 = r28;
            if (r119 == null) goto L403;
            Integer r124 = d.c.b.a.b.a(r119.optInt(r123));
        L404:
            r120.put(r123, r124);
            r107.put(r120);
            r118 = r118 + 1;
            r28 = r123;
            r117 = r117;
            r116 = r410;
            goto L391
        L403:
            r124 = null;
            goto L404
        L399:
            r122 = null;
            goto L400
        L395:
            r121 = null;
            goto L396
        L405:
            ILogDepend.Companion.w(ObricService.access$getTAG$p(), "onReceived intent " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) + ", new targets = " + r107);
            r106.put("targets", r107.toString());
        L406:
            ILogDepend.Companion.w(ObricService.access$getTAG$p(), "onReceived intent " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) + ", new params = " + r104);
            com.obric.agent.utils.u r108 = com.obric.agent.utils.u.f16076a;
            Gson r109 = ObricService.INSTANCE.getGson();
            d.h.b.o.c(r109, "<get-gson>(...)");
            MemoryProduceParams r125 = (MemoryProduceParams) ZeusTransformUtils.preCheckCast(r108.a(r109, r106.toString(), MemoryProduceParams.class, "dispatchIMAction_MemoryProduceParams"), MemoryProduceParams.class, r12);
            ILogDepend.Companion.w(ObricService.access$getTAG$p(), "onReceived intent " + ((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12)) + ", memoryProduceParams = " + r125);
            if (r125 == null) goto L308;
            r13 = null;
            r105.setContent(com.obric.agent.utils.b.f15994a.a((String) ZeusTransformUtils.preCheckCast(r3.f38504a, String.class, r12), com.obric.agent.utils.b.f15994a.a(r125), null));
            d.x r126 = d.x.f38692a;
        L385:
            r103 = this.$action.getContent();
            goto L386
        L312:
            if (d.h.b.o.a(r3.f38504a, "Memory_Delete") == true) goto L380;
            if (d.h.b.o.a(r3.f38504a, "Omni_SendKnowledge") == false) goto L370;
            String r127 = this.$action.getContent();     // Catch: JSONException -> L365
            if (r127 != null) goto L319;
            r127 = "{}";
        L319:
            String r128 = new JSONObject(r127).optString("Content");     // Catch: JSONException -> L365
            d.h.b.o.a(r128);     // Catch: JSONException -> L365
            String r129 = "";
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r128, CharSequence.class, r12)) == false) goto L323;
            ILogDepend.Companion.w(ObricService.access$getTAG$p(), "Omni_SendKnowledge: Content string is blank.");     // Catch: JSONException -> L365
            r129 = "Content string is blank";
            d.x r130 = d.x.f38692a;     // Catch: JSONException -> L365
            int r131 = 1;
        L364:
            String r132 = r129;
            int r133 = r131;
        L367:
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(this.$action, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(r133, r132, null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
            return d.x.f38692a;
        L323:
            JSONArray r134 = new JSONObject(r128).optJSONArray("jobs");     // Catch: JSONException -> L365
            if (r134 == null) goto L332;
            JSONObject r135 = r134.optJSONObject(0);     // Catch: JSONException -> L365
            if (r135 == null) goto L332;
            JSONArray r136 = r135.optJSONArray("actions");     // Catch: JSONException -> L365
            if (r136 == null) goto L332;
            JSONObject r137 = r136.optJSONObject(0);     // Catch: JSONException -> L365
            if (r137 == null) goto L332;
            JSONObject r138 = r137.optJSONObject("inputParams");     // Catch: JSONException -> L365
        L333:
            if (r138 == null) goto L339;
            JSONObject r139 = r138.optJSONObject("knowledges");     // Catch: JSONException -> L365
            if (r139 == null) goto L339;
            JSONArray r140 = r139.optJSONArray("value");     // Catch: JSONException -> L365
            if (r140 == null) goto L339;
            int r141 = 0;
            Object r142 = r140.opt(0);     // Catch: JSONException -> L365
        L340:
            if (r138 == null) goto L344;
            JSONObject r143 = r138.optJSONObject("evolutionInfo");     // Catch: JSONException -> L365
            if (r143 == null) goto L344;
            String r144 = r143.optString("value");     // Catch: JSONException -> L365
        L345:
            if (r138 == null) goto L349;
            JSONObject r145 = r138.optJSONObject(KnowledgeActivity.KEY_TASK_ID);     // Catch: JSONException -> L365
            if (r145 == null) goto L349;
            String r146 = r145.optString("value");     // Catch: JSONException -> L365
        L350:
            if (r138 == null) goto L354;
            JSONObject r147 = r138.optJSONObject(KnowledgeActivity.KEY_TASK_TYPE);     // Catch: JSONException -> L365
            if (r147 == null) goto L354;
            Integer r148 = d.c.b.a.b.a(r147.optInt("value"));     // Catch: JSONException -> L365
        L355:
            IAutoActionTasksApi r149 = (IAutoActionTasksApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionTasksApi.class), IAutoActionTasksApi.class, r12);     // Catch: JSONException -> L365
            if (r149 == null) goto L363;
            if (r146 != null) goto L359;
            r146 = "";
        L359:
            if (r148 == null) goto L361;
            int r150 = r148.intValue();     // Catch: JSONException -> L365
        L362:
            r149.onReceiveKnowledge(r146, r150, String.valueOf(r142), r144);     // Catch: JSONException -> L365
            d.x r151 = d.x.f38692a;     // Catch: JSONException -> L365
            goto L363
        L361:
            r150 = 3;
        L363:
            r131 = r141;
        L354:
            r148 = null;
        L349:
            r146 = null;
        L344:
            r144 = null;
        L339:
            r141 = 0;
            r142 = null;
        L332:
            r138 = null;
        L365:
            e = move-exception;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "Omni_SendKnowledge: Parse JSON failed: " + e.getMessage());
            String r152 = "Parse JSON failed: " + e.getMessage();
            d.x r153 = d.x.f38692a;
            r132 = r152;
            r133 = 1;
            goto L367
        L370:
            if (d.h.b.o.a(r3.f38504a, "RC_AwarenessData") == false) goto L308;
            Application r154 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), r12), Application.class, r12);
            IntentAppAction r155 = this.$action;
            String r156 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.a.f33793a.c((Context) ZeusTransformUtils.preCheckCast(r154, Context.class, r12), "{\"awarenessData\": true}").getData(), String.class, r12);
            if (r156 == null) goto L379;
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r155, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, r156, null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);     // Catch: Exception -> L375
        L377:
            d.x r157 = d.x.f38692a;
        L375:
            e = move-exception;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "parse queryRealtimeAwarenessData data failed: " + e.getMessage());
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r155, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(1, "parse queryRealtimeAwarenessData data failed", null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        L379:
            return d.x.f38692a;
        L457:
            String r158 = this.$action.getContent();     // Catch: JSONException -> L181
            d.h.b.o.a(r158);     // Catch: JSONException -> L181
            JSONArray r159 = new JSONObject(new JSONObject(r158).optString("Content")).optJSONArray("jobs");     // Catch: JSONException -> L181
            if (r159 == null) goto L171;
            JSONObject r160 = r159.optJSONObject(0);     // Catch: JSONException -> L181
            if (r160 == null) goto L171;
            JSONArray r161 = r160.optJSONArray("actions");     // Catch: JSONException -> L181
            if (r161 == null) goto L171;
            JSONObject r162 = r161.optJSONObject(0);     // Catch: JSONException -> L181
            if (r162 == null) goto L171;
            JSONObject r163 = r162.optJSONObject("inputParams");     // Catch: JSONException -> L181
        L173:
            if (r163 == null) goto L175;
            String r164 = r163.optString(r113);     // Catch: JSONException -> L181
        L177:
            if (d.h.b.o.a(new JSONObject(r164).optString("value"), "true") == false) goto L179;
            IWindowEffects.DefaultImpls.showScreenShotEffect$default(ObricProductSdk.INSTANCE.platformService().windowEffects(), true, null, 2, null);     // Catch: JSONException -> L181
        L179:
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(this.$action, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), r12), Application.class, r12)).getString(ZeusTransformUtils.mapRes(R.string.obric_action_defer_exe_success, r112, "obric_action_defer_exe_success")), null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);     // Catch: JSONException -> L181
            return d.x.f38692a;
        L175:
            r164 = null;
        L171:
            r163 = null;
        L181:
            e = move-exception;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), r210 + e.getMessage());
        L111:
            r38 = 0;
        L93:
            r30 = false;
            goto L94
        L14:
            am r165 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            d.o.a(r48);
        L15:
            am r166 = r165;
            ConcurrentHashMap<String, String> r167 = this.$action.getExt();
            if (r167 == null) goto L84;
            IntentAppAction r168 = this.$action;
            if (d.h.b.o.a(r167.get("action_type"), "1") == true) goto L445;
            r12 = r13;
            if (d.h.b.o.a(r167.get("o_autogui_mode"), "2") == false) goto L58;
            IFlowSettingsIDL r169 = at.a(aa.b(IFlowSettingsIDL.class));
            if (r169 == null) goto L56;
            r169.setAutoGuiEnabledScene(2);
            d.x r170 = d.x.f38692a;
        L56:
            r112 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
            r113 = "enable";
            r28 = "type";
            r29 = r6;
        L83:
            d.x r171 = d.x.f38692a;
        L85:
            IAgentService r172 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, r12);
            if (r172 == null) goto L93;
            String r173 = String.valueOf(this.$action.getQuestionId());
            d.c.d<? super Boolean> r174 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r12);
            this.L$0 = r166;
            this.label = 2;
            r27 = r172.isQueryInterrupt(r173, r174);
            if (r27 != r2) goto L91;
            return r2;
        L58:
            if (d.h.b.o.a(r167.get("o_split_screen"), "1") == true) goto L459;
            r112 = r5;
            r113 = r3;
            r28 = "type";
            r29 = r6;
            if (d.h.b.o.a(r167.get("o_screen_sense_light"), "1") == false) goto L83;
            IWindowEffects.DefaultImpls.showScreenShotEffect$default(ObricProductSdk.INSTANCE.platformService().windowEffects(), true, null, 2, null);
            goto L83
        L459:
            String r175 = r168.getContent();     // Catch: JSONException -> L77
            d.h.b.o.a(r175);     // Catch: JSONException -> L77
            r113 = r3;
            Boolean r176 = d.c.b.a.b.a(new JSONObject(new JSONObject(r175).optString("Params")).optBoolean(r113));     // Catch: JSONException -> L74
            IFlowUiIDL r177 = aw.a(aa.b(IFlowUiIDL.class));     // Catch: JSONException -> L74
            if (r177 == null) goto L64;
            r177.setAutoIncreaseWindow(r176.booleanValue());     // Catch: JSONException -> L74
            d.x r178 = d.x.f38692a;     // Catch: JSONException -> L74
        L64:
            r28 = "type";
            ILogDepend.Companion.i(ObricService.access$getTAG$p(), "setAutoIncreaseWindow enable " + r176);     // Catch: JSONException -> L72
            r112 = r5;
            com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r168, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), r12), Application.class, r12)).getString(ZeusTransformUtils.mapRes(R.string.obric_action_defer_exe_success, r112, "obric_action_defer_exe_success")), null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);     // Catch: JSONException -> L70
            return d.x.f38692a;
        L70:
            e = e;
        L79:
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "Parse content JSON failed: " + e.getMessage());
            r29 = "Parse content JSON failed: ";
        L72:
            e = e;
        L76:
            r112 = r5;
        L74:
            e = e;
            r28 = "type";
        L77:
            e = e;
            r112 = r5;
            r113 = r3;
            r28 = "type";
            goto L79
        L445:
            String r179 = r168.getContent();     // Catch: Exception -> L47
            d.h.b.o.a(r179);     // Catch: Exception -> L47
            JSONArray r180 = new JSONObject(new JSONObject(r179).optString("Content")).optJSONArray("jobs");     // Catch: Exception -> L47
            if (r180 == null) goto L36;
            JSONObject r181 = r180.optJSONObject(0);     // Catch: Exception -> L47
            if (r181 == null) goto L36;
            JSONArray r182 = r181.optJSONArray("actions");     // Catch: Exception -> L47
            if (r182 == null) goto L36;
            JSONObject r183 = r182.optJSONObject(0);     // Catch: Exception -> L47
            if (r183 == null) goto L36;
            JSONObject r184 = r183.optJSONObject("inputParams");     // Catch: Exception -> L47
        L38:
            if (r184 == null) goto L40;
            String r185 = r184.optString(DBDefinition.SEGMENT_INFO);     // Catch: Exception -> L47
        L41:
            String r186 = new JSONObject(r185).optString("value");     // Catch: Exception -> L47
            if (r184 == null) goto L44;
            String r187 = r184.optString("type");     // Catch: Exception -> L47
        L45:
            String r188 = new JSONObject(r187).optString("value");     // Catch: Exception -> L47
            MemoryServiceProxy r189 = MemoryServiceProxy.f33843a;     // Catch: Exception -> L47
            d.h.b.o.a(r188);     // Catch: Exception -> L47
            d.h.b.o.a(r186);     // Catch: Exception -> L47
            Bundle r190 = new Bundle();     // Catch: Exception -> L47
            r190.putString("memoryLogId", (String) ZeusTransformUtils.preCheckCast(r167.get("memoryLogId"), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L47
            d.x r191 = d.x.f38692a;     // Catch: Exception -> L47
            r189.a(r188, r186, r190);     // Catch: Exception -> L47
        L50:
            return d.x.f38692a;
        L44:
            r187 = null;
            goto L45
        L40:
            r185 = null;
        L36:
            r184 = null;
        L47:
            e = move-exception;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "Memory_Produce error: " + e);
            goto L50
        L84:
            r112 = r5;
            r113 = r3;
            r12 = r13;
            r28 = "type";
            r29 = r6;
            goto L85
        L16:
            d.o.a(r48);
            r165 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            ConcurrentHashMap<String, String> r192 = this.$action.getExt();
            if (r192 == null) goto L19;
            String r193 = (String) ZeusTransformUtils.preCheckCast(r192.get("is_obric_continuous_talk"), String.class, "com.obric.aiagent.plugin");
        L20:
            boolean r194 = d.h.b.o.a(r193, "1");
            ObricService r195 = ObricService.INSTANCE;
            long r196 = this.$action.getQuestionId();
            d.c.d r197 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.L$0 = r165;
            this.label = 1;
            if (ObricService.access$ensureQueryExistLocally(r195, r196, r194, r197) != r2) goto L15;
            return r2;
        L19:
            r193 = null;
            goto L20
        L455:
            d.o.a(r48);     // Catch: JSONException -> L9
            r93 = r48;
            r114 = "Parse content JSON failed: ";
            r12 = "com.obric.aiagent.plugin";
        L9:
            e = e;
            r114 = "Parse content JSON failed: ";
            goto L286
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final d.x invokeSuspend$lambda$14(IntentAppAction r1, String r2, String r3) {
            ObricService.access$handleComplexEntityIfNeeded(ObricService.INSTANCE, r1, r2, r3);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$ensureQueryExistLocally$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {886, DescriptorProtos.Edition.EDITION_LEGACY_VALUE}, d = "ensureQueryExistLocally", e = "com.obric.agent.ObricService")
    static final class C11061 extends d.c.b.a.d {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricService this$0;

        C11061(ObricService r3, d.c.d<? super C11061> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return ObricService.access$ensureQueryExistLocally(this.this$0, 0, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$fetchLatestMessages$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {2232}, d = "invokeSuspend", e = "com.obric.agent.ObricService$fetchLatestMessages$2")
    static final class C11072 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends IMMessage>>, Object> {
        final /* synthetic */ int $limit;
        int I$0;
        int label;

        C11072(int r3, d.c.d<? super C11072> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.$limit = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11072(this.$limit, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends IMMessage>> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super List<IMMessage>> r4) {
            return ((C11072) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11072.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L17:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            int r8 = this.$limit;
            this.I$0 = r8;
            this.label = 1;
            kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r4.e();
            final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
            if (r3 != null) goto L11;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "fetchLatestMessages: IPC not available");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r9.resumeWith(d.n.f(null));
        L12:
            r7 = r4.h();
            if (r7 != d.c.a.b.a()) goto L15;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L15:
            if (r7 != r0) goto L17;
            return r0;
        L11:
            r3.fetchLatestMessages(r8, (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.preCheckCast(new ObricService$fetchLatestMessages$2$1$1(r2), IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin"));
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$finishIMAction$4, reason: invalid class name */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {1751}, d = "invokeSuspend", e = "com.obric.agent.ObricService$finishIMAction$4")
    static final class AnonymousClass4 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {
        final /* synthetic */ IntentAppAction $result;
        int label;

        AnonymousClass4(IntentAppAction r3, d.c.d<? super AnonymousClass4> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.$result = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.$result, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super d.x> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass4.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            IDialogStateManager r9 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L15;
            r9.notifyStopOAuto(String.valueOf(this.$result.getQuestionId()));
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            ILogDepend.Companion.i(ObricService.access$getTAG$p(), "System_AutoAction is final for " + this.$result.getQuestionId() + ", add cancel timeout");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (ax.a(5000, r10) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$handleSemanticSupplement$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {726, 745, 772}, d = "handleSemanticSupplement", e = "com.obric.agent.ObricService")
    static final class C11081 extends d.c.b.a.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricService this$0;

        C11081(ObricService r3, d.c.d<? super C11081> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ObricService.access$handleSemanticSupplement(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$isQueryExistLocally$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {919}, d = "isQueryExistLocally", e = "com.obric.agent.ObricService")
    static final class C11101 extends d.c.b.a.d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricService this$0;

        C11101(ObricService r3, d.c.d<? super C11101> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ObricService.access$isQueryExistLocally(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$isQueryExistLocally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {2232}, d = "invokeSuspend", e = "com.obric.agent.ObricService$isQueryExistLocally$2")
    static final class C11112 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {
        final /* synthetic */ String $queryId;
        Object L$0;
        int label;

        C11112(String r3, d.c.d<? super C11112> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.$queryId = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11112(this.$queryId, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super Boolean> r4) {
            return ((C11112) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11112.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.aiagent.plugin");
            d.o.a(r7);
        L17:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            String r8 = this.$queryId;
            this.L$0 = r8;
            this.label = 1;
            kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r4.e();
            final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
            if (r3 != null) goto L11;
            ILogDepend.Companion.e(ObricService.access$getTAG$p(), "isQueryExistLocally: IPC not available");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r5 = d.n.f38560a;
            r9.resumeWith(d.n.f(d.c.b.a.b.a(false)));
        L12:
            r7 = r4.h();
            if (r7 != d.c.a.b.a()) goto L15;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L15:
            if (r7 != r0) goto L17;
            return r0;
        L11:
            r3.findMessagebyId(r8, (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new ObricService$isQueryExistLocally$2$1$1(r2), IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin"));
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.ObricService$redispatchAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricService.kt */
    @d.c.b.a.f(b = "ObricService.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.ObricService$redispatchAction$1")
    static final class C11131 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {
        final /* synthetic */ IntentAppAction $action;
        int label;

        C11131(IntentAppAction r3, d.c.d<? super C11131> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.$action = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C11131(this.$action, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d.c.d<? super d.x> r4) {
            return ((C11131) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C11131.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            d.o.a(r2);
            com.obric.capability.schedulekit.a r3 = com.obric.capability.schedulekit.a.f31846a;
            String r1 = ObricService.INSTANCE.getGson().toJson(this.$action);
            d.h.b.o.c(r1, "toJson(...)");
            r3.a(r1, true);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final boolean getDeviceAgentChain() {
        return false;
    }

    public static /* synthetic */ KeyguardManager lambda$DRFRrfeth_KWH_yS5KPaWMIXtjI() {
        return keyguardManager_delegate$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$GEb9AkO-IwneOp23ZMMEdsTBaWc, reason: not valid java name */
    public static /* synthetic */ d.x m61lambda$GEb9AkOIwneOp23ZMMEdsTBaWc(IFlowMessageIDL r0, String r1, String r2, Map r3, IFlowSemanticEditCallbackIDL r4) {
        return handleSemanticSupplement$lambda$8(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$HKwml-HKbNQ9O0EzjgdMiQroHqg, reason: not valid java name */
    public static /* synthetic */ Gson m62lambda$HKwmlHKbNQ9O0EzjgdMiQroHqg() {
        return gson_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$X7R28YpzgDLCsu2H9Bg-pcfGBJ8, reason: not valid java name */
    public static /* synthetic */ d.x m63lambda$X7R28YpzgDLCsu2H9BgpcfGBJ8(IFlowMessageIDL r0, String r1, String r2, Map r3, IFlowSemanticEditCallbackIDL r4) {
        return handleSemanticSupplement$lambda$9(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ d.x lambda$zwBvux0__M0XdV1PiXm8vwUglIc(IFlowMessageIDL r0, String r1, Map r2, IFlowSemanticEditCallbackIDL r3) {
        return handleSemanticSupplement$lambda$7(r0, r1, r2, r3);
    }

    private ObricService() {
    }

    public static final /* synthetic */ Object access$awaitSemanticEditResult(ObricService r2, long r3, d.h.a.b r5, d.c.d r6) {
        return r2.awaitSemanticEditResult(r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String access$destructInputParams(ObricService r0, IntentAppAction r1) {
        return r0.destructInputParams(r1);
    }

    public static final /* synthetic */ Object access$ensureQueryExistLocally(ObricService r2, long r3, boolean r5, d.c.d r6) {
        return r2.ensureQueryExistLocally(r3, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$fetchLatestMessages(ObricService r2, int r3, d.c.d r4) {
        return r2.fetchLatestMessages(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ObricService$knowledgeConfirmCache$1 access$getKnowledgeConfirmCache$p() {
        return knowledgeConfirmCache;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ void access$handleComplexEntityIfNeeded(ObricService r0, IntentAppAction r1, String r2, String r3) {
        r0.handleComplexEntityIfNeeded(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$handleSemanticSupplement(ObricService r2, IntentAppAction r3, d.c.d r4) {
        return r2.handleSemanticSupplement(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$isQueryExistLocally(ObricService r2, String r3, d.c.d r4) {
        return r2.isQueryExistLocally(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.agent.ObricService$intentQueryMap$1] */
    static {
        INSTANCE = new ObricService();
        TAG = "ObricService";
        intentQueryMap = new ObricService$intentQueryMap$1();
        gson$delegate = d.g.a($$Lambda$ObricService$HKwmlHKbNQ9O0EzjgdMiQroHqg.INSTANCE);
        nlgForPCSearch = new ObricService$nlgForPCSearch$1();
        knowledgeConfirmCache = new ObricService$knowledgeConfirmCache$1();
        keyguardManager$delegate = d.g.a($$Lambda$ObricService$DRFRrfeth_KWH_yS5KPaWMIXtjI.INSTANCE);
    }

    public final Gson getGson() {
        return (Gson) ZeusTransformUtils.preCheckCast(gson$delegate.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).create();
    }

    private final <T> Object collect$$forInline(kotlinx.coroutines.b.h<? extends T> r2, d.h.a.m<? super T, ? super d.c.d<? super d.x>, ? extends Object> r3, d.c.d<? super d.x> r4) {
        kotlinx.coroutines.b.h r1 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b.i<? super T> r7 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.h.b.m.a(0);
        r1.collect(r7, r6);
        d.h.b.m.a(1);
        return d.x.f38692a;
    }

    public final <T> Object collect(kotlinx.coroutines.b.h<? extends T> r2, d.h.a.m<? super T, ? super d.c.d<? super d.x>, ? extends Object> r3, d.c.d<? super d.x> r4) {
        kotlinx.coroutines.b.h r1 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = r1.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(keyguardManager$delegate.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$1() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    public final void init() {
        IIntentActionService r10 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L5;
        ILogDepend.Companion.i(TAG, "registerAppActionListener");
        r10.registerAppActionListener((OnAppActionListener) ZeusTransformUtils.preCheckCast(new ObricService$init$1$1(), OnAppActionListener.class, "com.obric.aiagent.plugin"));
    L5:
        AtomicCapabilitySdk.init(new AtomicCapabilitySdk.InitConfig((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), null, null, null, 0, 30, null));
        AtomicCapabilitySdk.setLogger((ILogger) ZeusTransformUtils.preCheckCast(new C11092(), ILogger.class, "com.obric.aiagent.plugin"));
        com.obric.capability.schedulekit.a.a(new com.obric.capability.schedulekit.a.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), (ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(new CapabilityActionResultBinder(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin"), 0, 4, null));
        com.obric.capability.schedulekit.a.a((com.obric.capability.schedulekit.c.b) ZeusTransformUtils.preCheckCast(new AnonymousClass3(), com.obric.capability.schedulekit.c.b.class, "com.obric.aiagent.plugin"));
    }

    public final void dispatchIMAction(IntentAppAction r10) {
        d.h.b.o.e(r10, "action");
        n.a(n.f15202a, r10.getQuestionId(), (Map) ZeusTransformUtils.preCheckCast(r10.getExt(), Map.class, "com.obric.aiagent.plugin"), 0, 4, null);
        com.obric.agent.trace.toolmetrics.e.f15877a.a(r10);
        ILogDepend.Companion.i(TAG, "onReceived action:questionId:" + r10.getQuestionId() + " actionId:" + r10.getId());
        kotlinx.coroutines.i.a(a.f14212a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C11051(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object handleSemanticSupplement(IntentAppAction r31, d.c.d<? super d.x> r32) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r32, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C11081.class) == false) goto L7;
        C11081 r4 = (C11081) ZeusTransformUtils.preCheckCast(r0, C11081.class, "com.obric.aiagent.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r4.result;
        Object r5 = d.c.a.b.a();
        int r6 = r4.label;
        int r9 = 1;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        IntentAppAction r2 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r4.L$0, IntentAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L152:
        r9 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
    L106:
        IntentAppAction r15 = r2;
    L155:
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r15, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(r9, null, null, 0, null, null, 62, null)), null, 0, 0, null, 247, null), true, false, false, 12, null);
        return d.x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r2 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r4.L$0, IntentAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L128:
        r9 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L106
    L17:
        r2 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r4.L$0, IntentAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L105:
        r9 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
        goto L106
    L18:
        d.o.a(r1);
        String r3 = destructInputParams(r31);
        if (r3 == null) goto L21;
        com.obric.agent.utils.u r10 = com.obric.agent.utils.u.f16076a;
        Gson r11 = INSTANCE.getGson();
        d.h.b.o.c(r11, "<get-gson>(...)");
        SemanticSupplementParams r12 = (SemanticSupplementParams) ZeusTransformUtils.preCheckCast(r10.a(r11, r3, SemanticSupplementParams.class, "dispatchIMAction_SemanticSupplement"), SemanticSupplementParams.class, "com.obric.aiagent.plugin");
    L23:
        if (r12 == null) goto L32;
        final String r13 = r12.getQueryId();
        if (r13 == null) goto L32;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L30;
        r13 = null;
    L30:
        if (r13 == null) goto L32;
    L42:
        final Map<String, Object> r14 = buildSemanticSupplementExt(r31);
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L45;
    L48:
        boolean r8 = true;
    L49:
        if (r8 == false) goto L51;
        handleSemanticSupplement$notifyFailure(r13, r14, "semantic_params_empty", "semantic supplement params empty");
    L154:
        r15 = r31;
        goto L155
    L51:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L54;
    L57:
        boolean r17 = true;
    L58:
        if (r17 == false) goto L60;
        handleSemanticSupplement$notifyFailure(r13, r14, "query_id_empty", "semantic query id empty");
        goto L154
    L60:
        aa.b(IAgentService.class);
        IAgentService r18 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L63;
    L65:
        boolean r19 = false;
    L66:
        if (r19 == false) goto L157;
        IFlowUiIDL r20 = aw.a(aa.b(IFlowUiIDL.class));
        if (r20 == null) goto L70;
        r20.showToast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_screenshot_not_suport, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_screenshot_not_suport")));
    L70:
        handleSemanticSupplement$notifyFailure(r13, r14, "screenshot_secure", "semantic screenshot is secure");
        goto L154
    L157:
        d.n.a r21 = d.n.f38560a;     // Catch: Throwable -> L82
        IFlowSettingsIDL r22 = at.a(aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L82
        if (r22 != null) goto L74;
    L76:
        boolean r23 = false;
    L77:
        if (r23 == true) goto L79;
        boolean r24 = true;
    L80:
        Object r25 = d.n.f(d.c.b.a.b.a(r24));     // Catch: Throwable -> L82
    L84:
        Boolean r110 = d.c.b.a.b.a(true);
        if (d.n.b(r25) == false) goto L87;
        r25 = r110;
    L87:
        boolean r26 = ((Boolean) ZeusTransformUtils.preCheckCast(r25, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        IAgentService r27 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L90;
        PicInfo r28 = r27.getScreenPicInfo(false, false);
    L92:
        if (r28 == null) goto L108;
        Long r29 = r28.getTime();
        if (r29 == null) goto L108;
        if (r29.longValue() != 0) goto L108;
        final IFlowMessageIDL r30 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r30 != null) goto L101;
        handleSemanticSupplement$notifyFailure(r13, r14, "flow_message_ipc_unavailable", "flow message ipc unavailable");
        goto L154
    L101:
        long r33 = r31.getQuestionId();
        d.h.a.b<? super IFlowSemanticEditCallbackIDL, d.x> r34 = new $$Lambda$ObricService$zwBvux0__M0XdV1PiXm8vwUglIc(r30, r13, r14);
        r4.L$0 = r31;
        r4.label = 1;
        r1 = awaitSemanticEditResult(r33, r34, r4);
        if (r1 != r5) goto L104;
        return r5;
    L104:
        r2 = r31;
    L108:
        if (r26 == true) goto L130;
        IAgentService r35 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L112;
        final String r36 = r35.getCachedAutoUploadImageUri();
    L113:
        CharSequence r37 = (CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.aiagent.plugin");
        if (r37 != null) goto L116;
    L119:
        boolean r111 = true;
    L120:
        if (r111 == true) goto L129;
        final IFlowMessageIDL r38 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r38 != null) goto L124;
        handleSemanticSupplement$notifyFailure(r13, r14, "flow_message_ipc_unavailable", "flow message ipc unavailable");
        goto L154
    L124:
        long r112 = r31.getQuestionId();
        d.h.a.b<? super IFlowSemanticEditCallbackIDL, d.x> r39 = new $$Lambda$ObricService$GEb9AkOIwneOp23ZMMEdsTBaWc(r38, r36, r13, r14);
        r4.L$0 = r31;
        r4.label = 2;
        r1 = awaitSemanticEditResult(r112, r39, r4);
        if (r1 != r5) goto L127;
        return r5;
    L127:
        r2 = r31;
        goto L128
    L129:
        handleSemanticSupplement$notifyFailure(r13, r14, "semantic_cached_uri_missing", "semantic cached image uri missing");
        goto L154
    L116:
        if (r37.length() == 0) goto L119;
        r111 = false;
        goto L120
    L112:
        r36 = null;
        goto L113
    L130:
        IAgentService r40 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L133;
        z r41 = r40.getUploadingImgInfo(true);
    L134:
        if (r41 == null) goto L136;
        final String r42 = r41.getIdentifier();
    L137:
        CharSequence r43 = (CharSequence) ZeusTransformUtils.preCheckCast(r42, CharSequence.class, "com.obric.aiagent.plugin");
        if (r43 != null) goto L140;
    L143:
        boolean r113 = true;
    L144:
        if (r113 == true) goto L153;
        final IFlowMessageIDL r44 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r44 != null) goto L148;
        handleSemanticSupplement$notifyFailure(r13, r14, "flow_message_ipc_unavailable", "flow message ipc unavailable");
        goto L154
    L148:
        long r45 = r31.getQuestionId();
        d.h.a.b<? super IFlowSemanticEditCallbackIDL, d.x> r114 = new $$Lambda$ObricService$X7R28YpzgDLCsu2H9BgpcfGBJ8(r44, r42, r13, r14);
        r4.L$0 = r31;
        r4.label = 3;
        r1 = awaitSemanticEditResult(r45, r114, r4);
        if (r1 != r5) goto L151;
        return r5;
    L151:
        r2 = r31;
        goto L152
    L153:
        handleSemanticSupplement$notifyFailure(r13, r14, "uploading_image_missing", "semantic uploading image missing");
        goto L154
    L140:
        if (d.o.o.d(r43) == true) goto L143;
        r113 = false;
        goto L144
    L136:
        r42 = null;
        goto L137
    L133:
        r41 = null;
        goto L134
    L90:
        r28 = null;
        goto L92
    L79:
        r24 = false;
        goto L80
    L74:
        if (r22.getAutoImageUploadEnabled() == true) goto L76;
        r23 = true;
    L82:
        th = move-exception;
        d.n.a r115 = d.n.f38560a;
        r25 = d.n.f(d.o.a(th));
        goto L84
    L63:
        if (r18.isScreenshotSecure() != true) goto L65;
        r19 = true;
        goto L66
    L54:
        if (d.o.o.d(r16) == true) goto L57;
        r17 = false;
        goto L58
    L45:
        if (d.o.o.d(r7) == true) goto L48;
        r8 = false;
    L32:
        Long r116 = d.c.b.a.b.a(r31.getQuestionId());
        if (((Number) ZeusTransformUtils.preCheckCast(r116, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L35;
        boolean r117 = true;
    L36:
        if (r117 == true) goto L39;
        r116 = null;
    L39:
        if (r116 == null) goto L41;
        r13 = r116.toString();
        goto L42
    L41:
        r13 = null;
        goto L42
    L35:
        r117 = false;
        goto L36
    L21:
        r12 = null;
    L7:
        r4 = new C11081(this, r0);
        goto L8
    }

    private static final void handleSemanticSupplement$notifyFailure(String r6, Map<String, Object> r7, String r8, String r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        INSTANCE.notifySemanticTraceFailure("Semantic_Supplement", r6, r8, r9, ao.e(r10));
    }

    private static final d.x handleSemanticSupplement$lambda$7(IFlowMessageIDL r2, String r3, Map r4, IFlowSemanticEditCallbackIDL r5) {
        IFlowMessageIDL r6 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r8 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "cb");
        r6.notifySemanticUserEditEvent("Semantic_Supplement", r3, ao.e(r7), r8);
        return d.x.f38692a;
    }

    private static final d.x handleSemanticSupplement$lambda$8(IFlowMessageIDL r8, String r9, String r10, Map r11, IFlowSemanticEditCallbackIDL r12) {
        IFlowMessageIDL r2 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r7 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r12, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "cb");
        r2.notifySemanticUserEditEventWithUri("Semantic_Supplement", r9, r10, ao.e(r13), r7);
        return d.x.f38692a;
    }

    private static final d.x handleSemanticSupplement$lambda$9(IFlowMessageIDL r8, String r9, String r10, Map r11, IFlowSemanticEditCallbackIDL r12) {
        IFlowMessageIDL r2 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        IFlowSemanticEditCallbackIDL r7 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r12, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "cb");
        r2.notifySemanticUserEditEventWithIdentifier("Semantic_Supplement", r9, r10, ao.e(r13), r7);
        return d.x.f38692a;
    }

    private final Object awaitSemanticEditResult(long r9, d.h.a.b<? super IFlowSemanticEditCallbackIDL, d.x> r11, d.c.d<? super Integer> r12) {
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r14, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r15 = d.c.a.b.a();
        int r2 = r0.label;
        int r3 = 1;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        long r10 = r0.J$1;
        long r16 = r0.J$0;
        d.o.a(r8);
    L18:
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        long r1 = SystemClock.elapsedRealtime() - r10;
        if (r17 != null) goto L21;
        ILogDepend.Companion.e(TAG, "awaitSemanticEditResult timeout, questionId=" + r16 + ", costMs=" + r1);
    L23:
        return d.c.b.a.b.a(r3);
    L21:
        ILogDepend.Companion.i(TAG, "awaitSemanticEditResult done, questionId=" + r16 + ", resultCode=" + r17 + ", costMs=" + r1);
        r3 = r17.intValue();
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        long r4 = SystemClock.elapsedRealtime();
        d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new ObricService$awaitSemanticEditResult$result$1(r13, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.J$0 = r9;
        r0.J$1 = r4;
        r0.label = 1;
        r8 = dg.b(5000, r18, r0);
        if (r8 != r15) goto L17;
        return r15;
    L17:
        r16 = r9;
        r10 = r4;
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }

    private final Object ensureQueryExistLocally(long r24, boolean r26, d.c.d<? super d.x> r27) {
        ObricService r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C11061.class) == false) goto L7;
        C11061 r3 = (C11061) ZeusTransformUtils.preCheckCast(r1, C11061.class, "com.obric.aiagent.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = d.c.a.b.a();
        int r5 = r3.label;
        Integer r6 = null;
        boolean r8 = true;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r7 = r3.J$0;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        String r14 = r9;
    L40:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L55;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L45;
    L47:
        Iterator r12 = r11.iterator();
    L49:
        if (r12.hasNext() == false) goto L46;
        if (d.h.b.o.a(((IMMessage) ZeusTransformUtils.preCheckCast(r12.next(), IMMessage.class, "com.obric.aiagent.plugin")).getMessageId(), r14) == false) goto L49;
        boolean r13 = true;
    L53:
        if (r13 != true) goto L55;
    L56:
        ILogDepend.Companion r15 = ILogDepend.Companion;
        String r16 = TAG;
        StringBuilder r17 = new StringBuilder().append("ensureQueryExistLocally: after fetch queryId=").append(r14).append(", fetchedSize=");
        if (r10 == null) goto L59;
        r6 = d.c.b.a.b.a(r10.size());
    L59:
        r15.i(r16, r17.append(r6).append(", exist=").append(r8).toString());
        com.obric.agent.trace.g r18 = com.obric.agent.trace.g.f15449a;
        if (r8 == false) goto L62;
        String r19 = QUERY_CHECK_SOURCE_FETCH;
    L63:
        String r110 = r19;
        if (r10 == null) goto L66;
        int r111 = r10.size();
    L67:
        r18.a(r14, true, true, r110, true, r111, r8, SystemClock.elapsedRealtime() - r7);
        return d.x.f38692a;
    L66:
        r111 = 0;
        goto L67
    L62:
        r19 = QUERY_CHECK_SOURCE_MISS;
    L46:
        r13 = false;
        goto L53
    L45:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L47;
    L55:
        r8 = false;
        goto L56
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r20 = r3.J$0;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r3.L$1, String.class, "com.obric.aiagent.plugin");
        ObricService r22 = (ObricService) ZeusTransformUtils.preCheckCast(r3.L$0, ObricService.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        long r112 = r20;
        String r113 = r21;
        r0 = r22;
    L33:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L36;
        com.obric.agent.trace.g.f15449a.a(r113, true, true, QUERY_CHECK_SOURCE_LOCAL, false, -1, true, SystemClock.elapsedRealtime() - r112);
        return d.x.f38692a;
    L36:
        ILogDepend.Companion.i(TAG, "ensureQueryExistLocally: query " + r113 + " not found locally, fetch latest messages");
        r3.L$0 = r113;
        r3.L$1 = null;
        r3.J$0 = r112;
        r3.label = 2;
        r2 = r0.fetchLatestMessages(5, r3);
        if (r2 != r4) goto L39;
        return r4;
    L39:
        r14 = r113;
        r7 = r112;
        goto L40
    L16:
        d.o.a(r2);
        if (r24 <= 0) goto L19;
        String r23 = String.valueOf(r24);
        long r25 = SystemClock.elapsedRealtime();
        if (r26 == true) goto L25;
        ILogDepend.Companion.i(TAG, "skip ensureQueryExistLocally, not continuous talk, questionId=" + r23);
        com.obric.agent.trace.g.f15449a.a(r23, false, false, QUERY_CHECK_SOURCE_SKIP, false, -1, false, SystemClock.elapsedRealtime() - r25);
        return d.x.f38692a;
    L25:
        if (j.f15187a.a(r23) == null) goto L28;
        com.obric.agent.trace.g.f15449a.a(r23, true, true, QUERY_CHECK_SOURCE_CACHE, false, -1, true, SystemClock.elapsedRealtime() - r25);
        return d.x.f38692a;
    L28:
        r3.L$0 = r0;
        r3.L$1 = r23;
        r3.J$0 = r25;
        r3.label = 1;
        r2 = r0.isQueryExistLocally(r23, r3);
        if (r2 != r4) goto L31;
        return r4;
    L31:
        r112 = r25;
        r113 = r23;
        goto L33
    L19:
        return d.x.f38692a;
    L7:
        r3 = new C11061(r0, r1);
        goto L8
    }

    private final Object isQueryExistLocally(String r7, d.c.d<? super Boolean> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C11101.class) == false) goto L7;
        C11101 r0 = (C11101) ZeusTransformUtils.preCheckCast(r9, C11101.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r10 = d.c.a.b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r6);
    L17:
        Boolean r11 = (Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        boolean r12 = r11.booleanValue();
    L22:
        return d.c.b.a.b.a(r12);
    L20:
        r12 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        d.h.a.m r13 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new C11112(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.label = 1;
        r6 = dg.b(1000, r13, r0);
        if (r6 != r10) goto L17;
        return r10;
    L7:
        r0 = new C11101(this, r9);
        goto L8
    }

    private final Object fetchLatestMessages(int r3, d.c.d<? super List<IMMessage>> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(3000, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C11072(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    public final void redispatchAction(IntentAppAction r10) {
        d.h.b.o.e(r10, "action");
        n.a(n.f15202a, r10.getQuestionId(), (Map) ZeusTransformUtils.preCheckCast(r10.getExt(), Map.class, "com.obric.aiagent.plugin"), 0, 4, null);
        IIntentTraceService r0 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.onIntentDispatched(String.valueOf(r10.getQuestionId()));
    L5:
        if (r0 == null) goto L7;
        IIntentTraceService.a.a(r0, String.valueOf(r10.getQuestionId()), "action", r10.getContent(), 0, 8, null);
    L7:
        kotlinx.coroutines.i.a(a.f14212a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C11131(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void dispatchAction(IntentAppAction r34) {
        d.h.b.o.e(r34, "action");
        ECAData r0 = r34.getECAData();
        if (r0 == null) goto L13;
        List<ECAJob> r1 = r0.getJobs();
        if (r1 == null) goto L13;
        ECAJob r2 = (ECAJob) ZeusTransformUtils.preCheckCast(d.a.p.d(r1, 0), ECAJob.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L13;
        List<ECAAction> r3 = r2.getActions();
        if (r3 == null) goto L13;
        ECAAction r4 = (ECAAction) ZeusTransformUtils.preCheckCast(d.a.p.d(r3, 0), ECAAction.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        String r5 = r4.getActionName();
    L15:
        if (com.obric.agent.office.b.f15285a.a(r5) == false) goto L17;
    L25:
        IIntentTraceService r6 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L28;
        r6.onIntentDispatched(String.valueOf(r34.getQuestionId()));
    L28:
        if (r6 == null) goto L30;
        IIntentTraceService.a.a(r6, String.valueOf(r34.getQuestionId()), "action", r34.getContent(), 0, 8, null);
    L30:
        IEntityManager r7 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L33;
        List<AppEntity> r8 = r7.checkDeletedEntitie(r34.getContent(), r34.getQuestionId());
    L34:
        if (r8 == null) goto L37;
        ILogDepend.Companion.i(TAG, "get deleteEntity " + r8.size());
    L37:
        if (r8 != null) goto L39;
    L175:
        JsonObject r9 = JsonParser.parseString(r34.getContent()).getAsJsonObject();     // Catch: Exception -> L159
        if (r9 == null) goto L49;
        JsonElement r10 = r9.get("Content");     // Catch: Exception -> L159
        if (r10 == null) goto L49;
        String r11 = r10.getAsString();     // Catch: Exception -> L159
    L50:
        com.obric.agent.dm.e r12 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(getGson().fromJson(r11, com.obric.agent.dm.e.class), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L159
        if (r12 == null) goto L59;
        List<com.obric.agent.dm.f> r13 = r12.a();     // Catch: Exception -> L159
        if (r13 == null) goto L59;
        com.obric.agent.dm.f r14 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(d.a.p.l(r13), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L159
        if (r14 == null) goto L59;
        List<com.obric.agent.dm.b> r15 = r14.a();     // Catch: Exception -> L159
        if (r15 == null) goto L59;
        com.obric.agent.dm.b r16 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(d.a.p.n(r15), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L159
    L60:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(d.f14409a.a(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L159
        if (r16 == null) goto L63;
        String r18 = r16.a();     // Catch: Exception -> L159
    L177:
        if (d.a.p.a(r17, r18) == false) goto L123;
        if (r16 == null) goto L123;
        String r19 = r16.a();     // Catch: Exception -> L121
        if (r19 == null) goto L123;
        String r20 = "";
        if (d.f14409a.b().contains(r19) == false) goto L81;
        JsonObject r21 = JsonParser.parseString(INSTANCE.destructInputParams(r34)).getAsJsonObject();     // Catch: Exception -> L159
        if (r21 == null) goto L88;
        JsonElement r22 = r21.get("quResult");     // Catch: Exception -> L159
        if (r22 == null) goto L88;
        String r23 = r22.getAsString();     // Catch: Exception -> L159
        if (r23 == null) goto L88;
    L79:
        r20 = r23;
    L88:
        MemoryResponse<PermissionCheckResult> r24 = com.obric.memorydata.sdk.a.f33793a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r19, r20);     // Catch: Exception -> L121
        ILogDepend.Companion r25 = ILogDepend.Companion;     // Catch: Exception -> L121
        String r26 = TAG;     // Catch: Exception -> L121
        StringBuilder r27 = new StringBuilder().append("checkDependencyPermissionForSearchIntent for intent:").append(r19).append(" and getResult: ");     // Catch: Exception -> L121
        PermissionCheckResult r28 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r24.getData(), PermissionCheckResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L121
        if (r28 == null) goto L92;
        List<String> r29 = r28.getMissedPermissions();     // Catch: Exception -> L159
    L93:
        r25.i(r26, r27.append(r29).toString());     // Catch: Exception -> L121
        if (r24.getCode() != 0) goto L123;
        PermissionCheckResult r30 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r24.getData(), PermissionCheckResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L121
        if (r30 == null) goto L103;
        List<String> r31 = r30.getMissedPermissions();     // Catch: Exception -> L159
        if (r31 == null) goto L103;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r31, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L103;
        boolean r32 = true;
    L104:
        if (r32 == false) goto L123;
        PermissionCheckResult r33 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r24.getData(), PermissionCheckResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L121
        if (r33 == null) goto L111;
        String r110 = r33.getFeedbackText();     // Catch: Exception -> L159
        if (r110 == null) goto L111;
        com.obric.agent.b.a r35 = new com.obric.agent.b.a(113, r110, null, 0, null, null, 60, null);     // Catch: Exception -> L159
    L112:
        JSONObject r36 = new JSONObject();     // Catch: Exception -> L121
        PermissionCheckResult r37 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r24.getData(), PermissionCheckResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L121
        if (r37 == null) goto L116;
        List<String> r38 = r37.getMissedPermissions();     // Catch: Exception -> L159
    L117:
        r36.put("need_permissions", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L121
        String r39 = new Gson().toJson(r35);     // Catch: Exception -> L121
        ConcurrentHashMap r40 = new ConcurrentHashMap();     // Catch: Exception -> L121
        r40.put("client_meta", r36.toString());     // Catch: Exception -> L121
        d.x r41 = d.x.f38692a;     // Catch: Exception -> L121
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r34, 0, 0, 0, r39, null, 0, 0, r40, IdlErrors.E_RejectInferDeviceOverheat, null), false, false, false, 12, null);     // Catch: Exception -> L135
        return;
    L116:
        r38 = null;
    L111:
        r35 = null;
    L103:
        r32 = false;
        goto L104
    L92:
        r29 = null;
        goto L93
    L81:
        if (d.f14409a.c().contains(r19) == false) goto L88;
        JsonObject r42 = JsonParser.parseString(INSTANCE.destructInputParams(r34)).getAsJsonObject();     // Catch: Exception -> L159
        if (r42 == null) goto L88;
        JsonElement r43 = r42.get(DownloadConstants.QUERY_KEY);     // Catch: Exception -> L159
        if (r43 == null) goto L88;
        r23 = r43.getAsString();     // Catch: Exception -> L159
        if (r23 != null) goto L79;
    L121:
        e = e;
        String r210 = "com.obric.aiagent.plugin";
        IntentAppAction r44 = r34;
        boolean r45 = true;
    L161:
        ILogDepend.Companion.e(TAG, "exception when parse for check " + e);
    L163:
        if (getDeviceAgentChain() == true) goto L172;
        String r46 = r210;
        String r47 = (String) ZeusTransformUtils.preCheckCast(nlgForPCSearch.get(String.valueOf(r34.getQuestionId())), String.class, r46);
        if (r47 != null) goto L167;
    L173:
        kotlinx.coroutines.i.a(a.f14212a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass7(r44, null), d.h.a.m.class, r46), 3, null);
        ((Map) ZeusTransformUtils.preCheckCast(intentQueryMap, Map.class, r46)).put(Long.valueOf(r34.getQuestionId()), Boolean.valueOf(r45));
        return;
    L167:
        if (r34.getExt() != null) goto L169;
        r44.setExt(new ConcurrentHashMap());
    L169:
        ConcurrentHashMap<String, String> r48 = r34.getExt();
        if (r48 == null) goto L173;
        String r49 = (String) ZeusTransformUtils.preCheckCast(r48.put("nlgForPCSearch", r47), String.class, r46);
        goto L173
    L172:
        r46 = r210;
    L123:
        r210 = "com.obric.aiagent.plugin";
        if (r16 == null) goto L138;
        String r50 = r16.a();     // Catch: Exception -> L135
        if (r50 == null) goto L138;
        r44 = r34;
        r45 = true;
        if (INSTANCE.handleIntentInternal(r44, r50) != true) goto L139;
        boolean r111 = true;
    L140:
        if (r111 == false) goto L142;
        return;
    L142:
        if (r16 != null) goto L180;
    L150:
        boolean r112 = false;
    L151:
        if (r112 == false) goto L153;
        return;
    L153:
        if (r16 == null) goto L163;
        String r51 = r16.a();     // Catch: Exception -> L148
        if (r51 == null) goto L163;
        if (INSTANCE.handleScreenRecordIntent(r44, r51) != r45) goto L163;
    L148:
        e = e;
        goto L161
    L180:
        String r52 = r16.a();     // Catch: Exception -> L148
        if (r52 == null) goto L150;
        if (INSTANCE.handleInstallAppIntent(r44, r52) != r45) goto L150;
        r112 = r45;
    L139:
        r111 = false;
    L133:
        e = e;
    L137:
        r45 = true;
    L138:
        r44 = r34;
        r45 = true;
    L135:
        e = e;
        r44 = r34;
        goto L137
    L63:
        r18 = null;
    L59:
        r16 = null;
    L49:
        r11 = null;
    L159:
        e = e;
        r45 = true;
        r210 = "com.obric.aiagent.plugin";
        r44 = r34;
        goto L161
    L39:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L175;
        String r113 = INSTANCE.getNlgForEntiesDeleted((AppEntity) ZeusTransformUtils.preCheckCast(r8.get(0), AppEntity.class, "com.obric.aiagent.plugin"));
        if (r113 == null) goto L175;
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r34, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(1, r113, null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return;
    L33:
        r8 = null;
        goto L34
    L17:
        if (d.h.b.o.a(r5, "System_ShowEntities") == true) goto L25;
        IEntityManager r53 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r53 == null) goto L23;
        String r54 = r53.replaceECAIdToEntity(r34.getContent(), r34.getQuestionId());
        if (r54 == null) goto L23;
    L24:
        r34.setContent(r54);
    L23:
        r54 = r34.getContent();
    L13:
        r5 = null;
        goto L15
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final boolean handleInstallAppIntent(IntentAppAction r38, String r39) {
        boolean r7 = false;
        if (d.h.b.o.a("System_DownloadApp", r39) == true) goto L5;
    L53:
        return false;
    L5:
        if (handleDouBaoDownloadAppIntent(r38, r39) == false) goto L7;
        return true;
    L7:
        String r3 = null;
        SystemDownloadAppParams r4 = null;
        if (((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ObricService$handleInstallAppIntent$isV2$1(r39, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L20;
        String r0 = destructInputParams(r38);
        if (r0 == null) goto L12;
        com.obric.agent.utils.u r2 = com.obric.agent.utils.u.f16076a;
        Gson r5 = INSTANCE.getGson();
        d.h.b.o.c(r5, "<get-gson>(...)");
        r4 = (SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r2.a(r5, r0, SystemDownloadAppParams.class, "handleInstallAppIntentV2"), SystemDownloadAppParams.class, "com.obric.aiagent.plugin");
    L12:
        if (r4 == null) goto L19;
        String r1 = r4.getAppName();
        if (r1 == null) goto L19;
        if (INSTANCE.tryRedirectRestoreDeletedSysApp(r38, r4, r1, true) == false) goto L19;
        return true;
    L19:
        return handleTrafficDownloadAuth(r38);
    L20:
        String r6 = destructInputParams(r38);
        if (r6 == null) goto L53;
        com.obric.agent.utils.u r8 = com.obric.agent.utils.u.f16076a;
        ObricService r9 = INSTANCE;
        Gson r10 = r9.getGson();
        d.h.b.o.c(r10, "<get-gson>(...)");
        SystemDownloadAppParams r11 = (SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r8.a(r10, r6, SystemDownloadAppParams.class, "handleInstallAppIntent"), SystemDownloadAppParams.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L53;
        String r12 = r11.getAppName();
        if (r12 == null) goto L53;
        if (r9.isAppInstalledByName((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12) == false) goto L51;
        if (n.f15202a.a((Map) ZeusTransformUtils.preCheckCast(r38.getExt(), Map.class, "com.obric.aiagent.plugin")) == false) goto L45;
        String r13 = r9.resolveInstalledPackageName((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r12);
        if (r13 != null) goto L38;
        AppAction r14 = r38.getAction();
        if (r14 == null) goto L35;
        r3 = r14.getPackageName();
    L35:
        if (r3 != null) goto L37;
        r13 = "";
        goto L38
    L37:
        r13 = r3;
    L38:
        long r20 = System.currentTimeMillis();
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r15.length() != 0) goto L41;
        r7 = true;
    L41:
        if (r7 == false) goto L43;
        r15 = r12;
    L43:
        r9.sendDownloadDecodeCard(r38, d.a.p.a(new AppInfoEntity((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin"), r20, r20, r12, r13, 2, true, "", null, r9.resolveInstalledPackageSize((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r13), 256, null)), ao.a(d.s.a("is_downloaded", "1")));
        return true;
    L45:
        Gson r16 = EntityExtKt.a();
        DataSource r17 = new DataSource("System", r39, null, 4, null);
        List r25 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap r18 = new ConcurrentHashMap();
        r18.put("KEY_APP_NAME", r12);
        d.x r19 = d.x.f38692a;
        String r30 = r16.toJson(new AppIntentMessage(r17, true, false, null, null, false, false, null, r25, (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.aiagent.plugin"), 248, null));
        IAgentService r29 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L48;
        d.h.b.o.a(r30);
        IAgentService.a.a(r29, r30, OAppIntentBizContentType.DOWNLOAD_APP_CARD, String.valueOf(r38.getQuestionId()), 0, null, 24, null);
    L48:
        String r21 = new Gson().toJson(new com.obric.agent.b.a(0, null, null, 0, null, null, 62, null));
        ConcurrentHashMap r22 = new ConcurrentHashMap();
        r22.put("is_downloaded", "1");
        d.x r110 = d.x.f38692a;
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r38, 0, 0, 0, r21, null, 0, 0, r22, IdlErrors.E_RejectInferDeviceOverheat, null), false, false, false, 12, null);
        return true;
    L51:
        if (tryRedirectRestoreDeletedSysApp$default(r9, r38, r11, r12, false, 8, null) == false) goto L53;
        return true;
    }

    private final boolean handleDouBaoDownloadAppIntent(IntentAppAction r31, String r32) {
        String r1 = destructInputParams(r31);
        String r2 = null;
        if (r1 == null) goto L5;
        com.obric.agent.utils.u r4 = com.obric.agent.utils.u.f16076a;
        Gson r5 = INSTANCE.getGson();
        d.h.b.o.c(r5, "<get-gson>(...)");
        SystemDownloadAppParams r3 = (SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r4.a(r5, r1, SystemDownloadAppParams.class, "handleDouBaoDownloadAppIntent"), SystemDownloadAppParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 == null) goto L11;
        String r6 = r3.getAppName();
        if (r6 == null) goto L11;
        r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L11:
        if (d.h.b.o.a(r2, DOU_BAO_APP_NAME) == true) goto L14;
        return false;
    L14:
        long r8 = System.currentTimeMillis();
        AppInfoEntity r7 = new AppInfoEntity("com.larus.nova", r8, r8, DOU_BAO_APP_NAME, "com.larus.nova", 2, true, "", null, resolveInstalledPackageSize((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.larus.nova"), 256, null);
        if (n.f15202a.a((Map) ZeusTransformUtils.preCheckCast(r31.getExt(), Map.class, "com.obric.aiagent.plugin")) == false) goto L18;
        sendDownloadDecodeCard(r31, d.a.p.a(r7), ao.a(d.s.a("is_downloaded", "1")));
        return true;
    L18:
        String r23 = EntityExtKt.a().toJson(new AppIntentMessage(new DataSource("System", r32, null, 4, null), true, false, null, null, false, false, null, d.a.p.a(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast(r7, AppEntity.class, "com.obric.aiagent.plugin"))), null, 760, null));
        IAgentService r22 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L21;
        d.h.b.o.a(r23);
        IAgentService.a.a(r22, r23, OAppIntentBizContentType.DOWNLOAD_APP_CARD, String.valueOf(r31.getQuestionId()), 0, null, 24, null);
    L21:
        String r12 = getGson().toJson(new com.obric.agent.b.a(0, null, null, 0, null, null, 62, null));
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        ConcurrentHashMap<String, String> r9 = r31.getExt();
        if (r9 == null) goto L24;
        r0.putAll((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin"));
    L24:
        r0.put("is_downloaded", "1");
        d.x r10 = d.x.f38692a;
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r31, 0, 0, 0, r12, null, 0, 0, r0, IdlErrors.E_RejectInferDeviceOverheat, null), false, false, false, 12, null);
        return true;
    L5:
        r3 = null;
        goto L6
    }

    static /* synthetic */ void sendDownloadDecodeCard$default(ObricService r1, IntentAppAction r2, List r3, Map r4, int r5, Object r6) {
        List<AppInfoEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = ao.b();
    L5:
        r1.sendDownloadDecodeCard(r2, r7, r8);
    }

    private final void sendDownloadDecodeCard(IntentAppAction r29, List<AppInfoEntity> r30, Map<String, String> r31) {
        List<? extends AppEntity> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "sendDownloadDecodeCard, decode card enabled, entities=" + r0.size());
        IEntityManager r3 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.addEntities(r0);
    L5:
        String r20 = getGson().toJson(new com.obric.agent.b.a(0, null, null, 0, EntityExtKt.a().toJson(r0), null, 46, null));
        ConcurrentHashMap r1 = new ConcurrentHashMap();
        ConcurrentHashMap<String, String> r4 = r29.getExt();
        if (r4 == null) goto L8;
        r1.putAll((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
    L8:
        r1.putAll(r2);
        d.x r5 = d.x.f38692a;
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r29, 0, 0, 0, r20, null, 0, 0, r1, IdlErrors.E_RejectInferDeviceOverheat, null), false, false, false, 12, null);
    }

    private final String resolveInstalledPackageName(Context r5, String r6) {
        PackageManager r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getPackageManager();
        Iterator<ApplicationInfo> r7 = r4.getInstalledApplications(0).iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        ApplicationInfo r1 = (ApplicationInfo) ZeusTransformUtils.preCheckCast(r7.next(), ApplicationInfo.class, "com.obric.aiagent.plugin");
        if (d.o.o.a(r4.getApplicationLabel(r1).toString(), r6, true) == false) goto L4;
        if (r4.getLaunchIntentForPackage(r1.packageName) == null) goto L4;
        return r1.packageName;
    L11:
        return null;
    }

    private final String resolveInstalledPackageSize(Context r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        Object r2 = null;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L50;
        return null;
    L50:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L39
        ObricService r11 = (ObricService) ZeusTransformUtils.preCheckCast(this, ObricService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        ApplicationInfo r15 = r14.getPackageManager().getApplicationInfo(r13, 0);     // Catch: Throwable -> L39
        d.h.b.o.c(r15, "getApplicationInfo(...)");     // Catch: Throwable -> L39
        List r1 = d.a.p.a();     // Catch: Throwable -> L39
        String r3 = r15.sourceDir;     // Catch: Throwable -> L39
        if (r3 != null) goto L8;
    L13:
        String[] r16 = r15.splitSourceDirs;     // Catch: Throwable -> L39
        if (r16 == null) goto L22;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        int r5 = r16.length;     // Catch: Throwable -> L39
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L21;
        String r7 = r16[r6];     // Catch: Throwable -> L39
        d.h.b.o.a(r7);     // Catch: Throwable -> L39
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L20;
        r4.add(r7);     // Catch: Throwable -> L39
    L20:
        r6 = r6 + 1;     // Catch: Throwable -> L39
        goto L16
    L21:
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39
    L22:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(r1), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L39
        long r8 = 0;
    L24:
        if (r17.hasNext() == false) goto L34;
        File r9 = new File((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L39
        if (r9.isFile() == true) goto L29;
        r9 = null;
    L29:
        if (r9 == null) goto L31;
        long r10 = r9.length();     // Catch: Throwable -> L39
    L32:
        r8 = r8 + r10;     // Catch: Throwable -> L39
        goto L24
    L31:
        r10 = 0;
        goto L32
    L34:
        if (r8 > 0) goto L36;
        String r18 = null;
    L37:
        Object r19 = d.n.f(r18);     // Catch: Throwable -> L39
    L41:
        Throwable r110 = d.n.c(r19);
        if (r110 == null) goto L45;
        ILogDepend.Companion.e(TAG, "resolveInstalledPackageSize failed, packageName=" + r13, r110);
    L45:
        if (d.n.b(r19) == true) goto L49;
        r2 = r19;
    L49:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L36:
        ad r111 = ad.f38485a;     // Catch: Throwable -> L39
        r18 = String.format(Locale.US, "%.1fM", Arrays.copyOf(new Object[]{Double.valueOf(r8 / ((double) 1048576))}, 1));     // Catch: Throwable -> L39
        d.h.b.o.c(r18, "format(...)");     // Catch: Throwable -> L39
        goto L37
    L8:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        r1.add(r3);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        d.n.a r112 = d.n.f38560a;
        r19 = d.n.f(d.o.a(th));
        goto L41
    }

    private final boolean handleTrafficDownloadAuth(IntentAppAction r29) {
        String r1 = destructInputParams(r29);
        if (r1 == null) goto L5;
        com.obric.agent.utils.u r4 = com.obric.agent.utils.u.f16076a;
        Gson r5 = INSTANCE.getGson();
        d.h.b.o.c(r5, "<get-gson>(...)");
        SystemDownloadAppParams r2 = (SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r4.a(r5, r1, SystemDownloadAppParams.class, "handleTrafficDownloadAuth"), SystemDownloadAppParams.class, "com.obric.aiagent.plugin");
    L6:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        String r7 = r2.getAppName();
        if (r7 == null) goto L10;
    L12:
        if (isAppInstalledByName(r6, r7) == false) goto L15;
        return false;
    L15:
        if (isTrafficSituation((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L18;
        return false;
    L18:
        if (com.obric.agent.g.a.f14560a.b() == false) goto L23;
        if (r2 == null) goto L21;
        r2.setProceed(true);
        r29.setContent(com.obric.agent.utils.b.f15994a.a("System_DownloadApp", com.obric.agent.utils.b.f15994a.a(r2), null));
    L21:
        return false;
    L23:
        if (r2 == null) goto L25;
        boolean r0 = d.h.b.o.a(r2.getProceed(), true);
    L26:
        if (r0 == false) goto L29;
        com.obric.agent.g.a.f14560a.a(true);
        return false;
    L29:
        ILogDepend.Companion.i(TAG, "handleTrafficDownloadAuth: on mobile data and not authorized, return 4011");
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r29, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(ErrorCode.System.DOUBLE_CONFIRMATION_BEFORE_DOWNLOADING_ERROR, null, null, 0, null, null, 62, null)), null, 0, 0, null, 247, null), true, false, false, 12, null);
        return true;
    L25:
        r0 = false;
    L10:
        r7 = "";
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    static /* synthetic */ boolean tryRedirectRestoreDeletedSysApp$default(ObricService r0, IntentAppAction r1, SystemDownloadAppParams r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        return r0.tryRedirectRestoreDeletedSysApp(r1, r2, r3, r4);
    }

    private final boolean tryRedirectRestoreDeletedSysApp(IntentAppAction r29, SystemDownloadAppParams r30, String r31, boolean r32) {
        String r2 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        if (d.h.b.o.a(r2, IFeatureServiceKt.PRODUCT_NERIDA) == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        boolean r6 = d.h.b.o.a(r2, IFeatureServiceKt.PRODUCT_PIKE);
        if (d.h.b.o.a(r2, "pacific") == true) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r3 == true) goto L19;
        if (r6 == true) goto L19;
        if (r4 == true) goto L19;
    L29:
        return false;
    L19:
        if (d.h.b.o.a(r30.isSystemApp(), true) == false) goto L29;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AppAction r7 = r29.getAction();
        if (r7 == null) goto L23;
        String r8 = r7.getPackageName();
    L24:
        startActivityRestoreDeletedSysApp(r5, r8);
        com.obric.agent.b.a r9 = new com.obric.agent.b.a(0, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_download_system_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_download_system_app")), null, 0, null, null, 60, null);
        if (r32 == false) goto L27;
        r9.c(buildAppEntityData(r31));
    L27:
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r29, 0, 0, 0, new Gson().toJson(r9), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return true;
    L23:
        r8 = null;
        goto L24
    L12:
        if (d.h.b.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CALENDAR_APP_NAME) == false) goto L14;
        r4 = true;
        goto L15
    L5:
        if (d.h.b.o.a(r2, IFeatureServiceKt.PRODUCT_NERIDA_LITE) == true) goto L8;
        r3 = false;
        goto L9
    }

    private final String buildAppEntityData(String r17) {
        long r4 = System.currentTimeMillis();
        if (d.h.b.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CALENDAR_APP_NAME) == false) goto L5;
        boolean r0 = isCalendarMiniAppPinned();
    L7:
        if (r0 == false) goto L9;
        int r1 = 2;
    L10:
        AppInfoEntity r15 = new AppInfoEntity(r17, r4, r4, r17, r17, r1, true, null, null, null, 768, null);
        String r2 = EntityExtKt.a().toJson(d.a.p.a(r15));
        d.h.b.o.c(r2, "toJson(...)");
        return r2;
    L9:
        r1 = 0;
        goto L10
    L5:
        r0 = isAppInstalledLocallyByName((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r17);
        goto L7
    }

    private final boolean isCalendarMiniAppPinned() {
        if (Build.VERSION.SDK_INT >= 25) goto L32;
        return false;
    L32:
        LauncherApps r2 = (LauncherApps) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService(LauncherApps.class), LauncherApps.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        if (r2 != null) goto L8;
        return false;
    L8:
        LauncherApps.ShortcutQuery r4 = new LauncherApps.ShortcutQuery();     // Catch: Exception -> L29
        r4.setPackage(CALENDAR_MINI_APP_PACKAGE_NAME);     // Catch: Exception -> L29
        r4.setShortcutIds(d.a.p.a(CALENDAR_MINI_APP_SHORTCUT_ID));     // Catch: Exception -> L29
        r4.setQueryFlags(1024);     // Catch: Exception -> L29
        List<ShortcutInfo> r3 = r2.getShortcuts(r4, Process.myUserHandle());     // Catch: Exception -> L29
        if (r3 == null) goto L39;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L13;
    L15:
        Iterator r6 = r5.iterator();     // Catch: Exception -> L29
    L16:
        if (r6.hasNext() == false) goto L26;
        ShortcutInfo r7 = (ShortcutInfo) ZeusTransformUtils.preCheckCast(r6.next(), ShortcutInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L29
        if (d.h.b.o.a(r7.getPackage(), CALENDAR_MINI_APP_PACKAGE_NAME) == true) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L16;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L41;
        return false;
    L41:
        return true;
    L21:
        if (d.h.b.o.a(r7.getId(), CALENDAR_MINI_APP_SHORTCUT_ID) == false) goto L23;
        r8 = true;
    L26:
        r9 = false;
        goto L27
    L13:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L15;
    L39:
        return false;
    L29:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to query calendar pinned shortcut", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    private final boolean isAppInstalledLocallyByName(Context r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L27;
        return false;
    L27:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L19
        ObricService r5 = (ObricService) ZeusTransformUtils.preCheckCast(this, ObricService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        PackageManager r9 = r8.getPackageManager();     // Catch: Throwable -> L19
        List<ApplicationInfo> r10 = r9.getInstalledApplications(0);     // Catch: Throwable -> L19
        d.h.b.o.c(r10, "getInstalledApplications(...)");     // Catch: Throwable -> L19
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L8;
    L10:
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L19
    L12:
        if (r12.hasNext() == false) goto L16;
        if (d.o.o.a(r9.getApplicationLabel((ApplicationInfo) ZeusTransformUtils.preCheckCast(r12.next(), ApplicationInfo.class, "com.obric.aiagent.plugin")).toString(), d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString(), true) == false) goto L12;
    L17:
        Object r13 = d.n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L19
    L21:
        Throwable r14 = d.n.c(r13);
        if (r14 == null) goto L26;
        ILogDepend.Companion.e(TAG, "Failed to query installed app by name: " + r7 + ", error=" + r14);
        r13 = false;
    L26:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L16:
        r3 = false;
        goto L17
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
    L19:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;
        r13 = d.n.f(d.o.a(th));
        goto L21
    }

    private final boolean isTrafficSituation(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L19
        ObricService r3 = (ObricService) ZeusTransformUtils.preCheckCast(this, ObricService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (com.bytedance.common.utility.i.a(r5) == false) goto L6;
    L5:
        boolean r6 = false;
    L17:
        Object r7 = d.n.f(Boolean.valueOf(r6));     // Catch: Throwable -> L19
    L22:
        if (d.n.b(r7) == false) goto L25;
        r7 = false;
    L25:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        com.bytedance.common.utility.i.b r8 = com.bytedance.common.utility.i.c(r5);     // Catch: Throwable -> L19
        if (r8 != com.bytedance.common.utility.i.b.f6737c) goto L9;
    L16:
        r6 = true;
        goto L17
    L9:
        if (r8 == com.bytedance.common.utility.i.b.f6738d) goto L16;
        if (r8 == com.bytedance.common.utility.i.b.f6739e) goto L16;
        if (r8 == com.bytedance.common.utility.i.b.g) goto L16;
        if (r8 != com.bytedance.common.utility.i.b.h) goto L5;
    L19:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L22
    }

    private final boolean isAppInstalledByName(Context r6, String r7) {
        PackageManager r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin")).getPackageManager();
        List<ApplicationInfo> r1 = r5.getInstalledApplications(0);
        d.h.b.o.c(r1, "getInstalledApplications(...)");
        Iterator<ApplicationInfo> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        ApplicationInfo r3 = (ApplicationInfo) ZeusTransformUtils.preCheckCast(r2.next(), ApplicationInfo.class, "com.obric.aiagent.plugin");
        if (d.o.o.a(r5.getApplicationLabel(r3).toString(), r7, true) == false) goto L4;
        if (r5.getLaunchIntentForPackage(r3.packageName) == null) goto L4;
        return true;
    L10:
        return false;
    }

    private final boolean handleScreenRecordIntent(IntentAppAction r5, String r6) {
        if (d.h.b.o.a("System_ScreenRecord", r6) == false) goto L15;
        String r4 = destructInputParams(r5);
        if (r4 == null) goto L16;
        com.obric.agent.utils.u r7 = com.obric.agent.utils.u.f16076a;
        ObricService r8 = INSTANCE;
        Gson r1 = r8.getGson();
        d.h.b.o.c(r1, "<get-gson>(...)");
        SystemScreenRecordParams r9 = (SystemScreenRecordParams) ZeusTransformUtils.preCheckCast(r7.a(r1, r4, SystemScreenRecordParams.class, "handleScreenRecordIntent"), SystemScreenRecordParams.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L9;
        boolean r10 = d.h.b.o.a(r9.getEnable(), true);
    L10:
        if (r10 == true) goto L12;
        return false;
    L12:
        if (r8.getKeyguardManager().isKeyguardLocked() == false) goto L14;
        return false;
    L14:
        return true;
    L9:
        r10 = false;
        goto L10
    L16:
        return false;
    L15:
        return false;
    }

    private final boolean handleIntentInternal(IntentAppAction r1, String r2) {
        return com.obric.agent.f.b.f14547a.a(r1, r2);
    }

    private final String getNlgForEntiesDeleted(AppEntity r3) {
        int r2 = r3.getType();
        if (r2 == 201) goto L12;
        if (r2 == 202) goto L15;
        if (r2 == 702) goto L14;
        return null;
    L14:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_timer_deleted_error_msg, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_timer_deleted_error_msg"));
    L15:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_callhistory_deleted_error_msg, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_callhistory_deleted_error_msg"));
    L12:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_contact_deleted_error_msg, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_contact_deleted_error_msg"));
    }

    private final void changeActionForIntent(IntentAppAction r7, IntentAppAction r8, JobResult r9, String r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.getExecRecords(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        Object r0 = null;
        List r2 = null;
    L5:
        boolean r4 = true;
        if (r6.hasNext() == false) goto L15;
        List<AppEntity> r3 = c.f14250a.a(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r6.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getEntity());
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L5;
        IEntityManager r5 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        r5.addEntities(r3);
    L12:
        if (r2 != null) goto L14;
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L14:
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"));
        goto L5
    L15:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L18;
    L21:
        if (r4 == true) goto L23;
    L51:
        if (r2 != null) goto L53;
        return;
    L53:
        if (d.h.b.o.a(r10, "Office_BookMeeting") == false) goto L65;
        SimpleDateFormat r12 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L56:
        if (r13.hasNext() == false) goto L65;
        AppEntity r14 = (AppEntity) ZeusTransformUtils.preCheckCast(r13.next(), AppEntity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ScheduleEntity.class) == false) goto L56;
        Long r15 = d.o.o.e(((ScheduleEntity) ZeusTransformUtils.preCheckCast(r14, ScheduleEntity.class, "com.obric.aiagent.plugin")).getStartTime());
        if (r15 == null) goto L62;
        long r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).longValue();
        ScheduleEntity r17 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r14, ScheduleEntity.class, "com.obric.aiagent.plugin");
        String r18 = r12.format(new Date(r16));
        d.h.b.o.c(r18, "format(...)");
        r17.setStartTime(r18);
    L62:
        Long r19 = d.o.o.e(((ScheduleEntity) ZeusTransformUtils.preCheckCast(r14, ScheduleEntity.class, "com.obric.aiagent.plugin")).getEndTime());
        if (r19 == null) goto L56;
        long r20 = ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.aiagent.plugin")).longValue();
        ScheduleEntity r21 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r14, ScheduleEntity.class, "com.obric.aiagent.plugin");
        String r110 = r12.format(new Date(r20));
        d.h.b.o.c(r110, "format(...)");
        r21.setEndTime(r110);
    L65:
        com.obric.agent.b.a r22 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r8.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");
        r22.c(EntityExtKt.a().toJson(r2));
        r8.setContent(INSTANCE.getGson().toJson(r22));
        return;
    L23:
        if (d.h.b.o.a(r10, "Messages_Send") == false) goto L51;
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.getExecRecords(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r23.hasNext() == false) goto L30;
        Object r24 = r23.next();
        if (d.h.b.o.a(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r24, IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getIntentName(), r10) == false) goto L26;
    L31:
        IntentExecutionRecord r25 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r24, IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L38;
        IntentResult<?> r26 = r25.getResult();
        if (r26 == null) goto L38;
        Object r27 = r26.getEntity();
        if (r27 == null) goto L38;
        r0 = r27;
    L43:
        MessageEntity r28 = com.obric.agent.office.a.f15240a.a(r7, r10, r0);
        if (r28 == null) goto L51;
        IEntityManager r29 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L48;
        r29.addEntities(d.a.p.a(r28));
    L48:
        if (r2 != null) goto L50;
        r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L50:
        r2.add(r28);
    L38:
        IntentExecutionRecord r30 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.l(r9.getExecRecords()), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L43;
        IntentResult<?> r31 = r30.getResult();
        if (r31 == null) goto L43;
        r0 = r31.getEntity();
        goto L43
    L30:
        r24 = null;
        goto L31
    L18:
        if (r11.isEmpty() == true) goto L21;
        r4 = false;
        goto L21
    }

    public static /* synthetic */ void finishIMAction$default(ObricService r12, IntentAppAction r13, IntentAppAction r14, boolean r15, JobResult r16, boolean r17, boolean r18, boolean r19, boolean r20, int r21, Object r22) {
        if ((r21 & 16) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r21 & 32) == 0) goto L9;
        boolean r9 = false;
    L11:
        if ((r21 & 64) == 0) goto L13;
        boolean r10 = false;
    L15:
        if ((r21 & 128) == 0) goto L17;
        boolean r11 = true;
    L18:
        r12.finishIMAction(r13, r14, r15, r16, r8, r9, r10, r11);
        return;
    L17:
        r11 = r20;
        goto L18
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    public final void finishIMAction(IntentAppAction r26, IntentAppAction r27, boolean r28, JobResult r29, boolean r30, boolean r31, boolean r32, boolean r33) {
        d.h.b.o.e(r26, Ext.KEY_REQUEST);
        d.h.b.o.e(r27, "result");
        if (r29 == null) goto L7;
        List<IntentExecutionRecord> r8 = r29.getExecRecords();
        if (r8 == null) goto L7;
        IntentExecutionRecord r9 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.n(r8), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
    L8:
        if (r29 == null) goto L14;
        List<IntentExecutionRecord> r10 = r29.getExecRecords();
        if (r10 == null) goto L14;
        IntentExecutionRecord r11 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.n(r10), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L14;
        IntentResult<?> r12 = r11.getResult();
    L15:
        if (r12 == null) goto L17;
        Boolean r13 = Boolean.valueOf(r12.getNeedToSummarize());
    L18:
        if (r12 == null) goto L20;
        Boolean r14 = Boolean.valueOf(r12.getInquireFurther());
    L21:
        ConcurrentHashMap<String, String> r15 = r26.getExt();
        if (r15 == null) goto L24;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L25:
        boolean r17 = d.h.b.o.a(r16, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
        if (r9 == null) goto L28;
        String r18 = r9.getIntentName();
    L30:
        if (r27.getExt() != null) goto L32;
        r27.setExt(new ConcurrentHashMap());
    L32:
        fillClientToolDuration(r26, r27);
        if (r28 == false) goto L35;
        changeActionForIntent(r26, r27, r29, r18);
    L35:
        IAppIntentFeedback r19 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L38;
        r19.notifyActionFinished(r26, r29);
    L38:
        IIntentTraceService r110 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, String> r0 = r26.getExt();
        if (r0 == null) goto L41;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("to_server"), String.class, "com.obric.aiagent.plugin");
    L43:
        if (d.h.b.o.a(r1, "false") == false) goto L45;
        boolean r22 = false;
    L46:
        if (r22 == false) goto L49;
        if (r17 == false) goto L49;
        com.obric.agent.utils.b.f15994a.b(r27);
    L49:
        ConcurrentHashMap<String, String> r2 = r27.getExt();
        String r111 = "client_meta";
        if (r2 == null) goto L61;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("client_meta"), String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L61;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L55
        Object r4 = d.n.f(new JSONObject(r3));     // Catch: Throwable -> L55
    L58:
        if (d.n.b(r4) == false) goto L60;
        r4 = null;
    L60:
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin");
    L62:
        if (r5 != null) goto L64;
        r5 = new JSONObject();
    L64:
        JSONObject r7 = r5;
        if (r9 == null) goto L67;
        String r20 = r9.getIntentName();
    L68:
        r7.put("intent_type", r20);
        com.obric.agent.b.a r21 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r27.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");
        if ((r21.d() & UiType.FLAG_NO_FEEDBACK) != 0) goto L71;
        if (r31 == true) goto L71;
    L72:
        ConcurrentHashMap<String, String> r23 = r26.getExt();
        if (r23 == null) goto L86;
        String r24 = (String) ZeusTransformUtils.preCheckCast(r23.get("client_meta"), String.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L86;
        d.n.a r112 = d.n.f38560a;     // Catch: Throwable -> L78
        Object r25 = d.n.f(new JSONObject(r24));     // Catch: Throwable -> L78
    L81:
        if (d.n.b(r25) == false) goto L83;
        r25 = null;
    L83:
        JSONObject r34 = (JSONObject) ZeusTransformUtils.preCheckCast(r25, JSONObject.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L86;
        r7 = INSTANCE.mergeJsonObjects(r7, r34);
    L78:
        th = move-exception;
        d.n.a r113 = d.n.f38560a;
        r25 = d.n.f(d.o.a(th));
    L86:
        if (r22 == false) goto L154;
        List<AppEntity> r35 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r18, "Office_SearchMeeting") == true) goto L90;
    L93:
        boolean r114 = false;
    L94:
        if (r114 == true) goto L107;
        if (r12 == null) goto L97;
        Object r36 = r12.getEntity();
    L98:
        com.obric.agent.entity.b r37 = useEntityForContent(r18, r36, r35, r17);
        if (r37.b() == null) goto L107;
        com.obric.agent.b.a r38 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r27.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");
        String r115 = r37.b();
        d.h.b.o.a(r115);
        r38.a(r115);
        r27.setContent(INSTANCE.getGson().toJson(r38));
        if (r110 == null) goto L105;
        IIntentTraceService.a.a(r110, String.valueOf(r27.getQuestionId()), "entity_nlg", r38.b(), 0, 8, null);
    L105:
        if (r37.a() == true) goto L108;
        Boolean r116 = false;
    L109:
        if (r110 == null) goto L112;
        IIntentTraceService.a.a(r110, String.valueOf(r27.getQuestionId()), "need_to_summarize", r116, 0, 8, null);
    L112:
        if (d.h.b.o.a(r116, true) == false) goto L117;
        ConcurrentHashMap<String, String> r39 = r27.getExt();
        if (r39 == null) goto L117;
        String r40 = (String) ZeusTransformUtils.preCheckCast(r39.put("summary_advice", "need"), String.class, "com.obric.aiagent.plugin");
    L117:
        if (r21.a() != 999) goto L122;
        ConcurrentHashMap<String, String> r41 = r27.getExt();
        if (r41 == null) goto L122;
        String r42 = (String) ZeusTransformUtils.preCheckCast(r41.put("provider_state", "Unsupported.OutOfIntent"), String.class, "com.obric.aiagent.plugin");
    L122:
        if (d.h.b.o.a(r14, true) == false) goto L126;
        ConcurrentHashMap<String, String> r43 = r27.getExt();
        if (r43 == null) goto L126;
        String r44 = (String) ZeusTransformUtils.preCheckCast(r43.put("miss_parameter", "1"), String.class, "com.obric.aiagent.plugin");
    L126:
        ConcurrentHashMap<String, String> r45 = r26.getExt();
        if (r45 == null) goto L129;
        String r46 = (String) ZeusTransformUtils.preCheckCast(r45.get("o_source_intent"), String.class, "com.obric.aiagent.plugin");
    L130:
        ILogDepend.Companion.i(TAG, "handleComplexEntityIfNeeded sourceIntent " + r46);
        if (r9 == null) goto L133;
        String r47 = r9.getIntentName();
    L134:
        handleComplexEntityIfNeeded(r27, r47, r46);
        if (r9 == null) goto L137;
        String r48 = r9.getIntentName();
    L138:
        handleEntitiesDeleteIfNeeded(r26, r27, r48);
        ConcurrentHashMap<String, String> r49 = r27.getExt();
        if (r49 == null) goto L141;
        String r50 = (String) ZeusTransformUtils.preCheckCast(r49.put(r111, String.valueOf(r7)), String.class, "com.obric.aiagent.plugin");
    L141:
        if (r110 == null) goto L143;
        r110.onResponseToServer(String.valueOf(r26.getQuestionId()));
    L143:
        if (r110 == null) goto L149;
        Long r51 = r110.getEngineCost(String.valueOf(r26.getQuestionId()));
        if (r51 == null) goto L149;
        long r52 = ((Number) ZeusTransformUtils.preCheckCast(r51, Number.class, "com.obric.aiagent.plugin")).longValue();
        ConcurrentHashMap<String, String> r53 = r27.getExt();
        if (r53 == null) goto L149;
        String r54 = (String) ZeusTransformUtils.preCheckCast(r53.put("engine_cost", String.valueOf(r52)), String.class, "com.obric.aiagent.plugin");
    L149:
        boolean r55 = r33;
        com.obric.agent.network.a.f15206a.a(r27, r31, r32, r55);
        if (r55 == true) goto L152;
    L186:
        boolean r56 = true;
    L205:
        d.n.a r57 = d.n.f38560a;     // Catch: Throwable -> L193
        ObricService r58 = (ObricService) ZeusTransformUtils.preCheckCast(this, ObricService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L193
        IAppIntentFeedback r59 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L193
        if (r59 == null) goto L190;
        r59.notifyActionProcessedResult(r26, r27, r55);     // Catch: Throwable -> L193
        d.x r210 = d.x.f38692a;     // Catch: Throwable -> L193
    L191:
        Object r60 = d.n.f(r210);     // Catch: Throwable -> L193
    L195:
        Throwable r61 = d.n.c(r60);
        if (r61 == null) goto L198;
        ILogDepend.Companion.e(TAG, "notifyActionProcessedResult failed", r61);
    L198:
        com.obric.agent.trace.toolmetrics.c r62 = com.obric.agent.trace.toolmetrics.c.f15872a;
        long r63 = r27.getMessageId();
        if (r22 == true) goto L202;
        if (r55 == false) goto L202;
    L203:
        r62.a(r63, r56, d.n.c(r60));
        return;
    L202:
        r56 = false;
        goto L203
    L190:
        r210 = null;
    L193:
        th = move-exception;
        d.n.a r64 = d.n.f38560a;
        r60 = d.n.f(d.o.a(th));
        goto L195
    L152:
        if (d.h.b.o.a(r18, "System_AutoAction") == false) goto L186;
        kotlinx.coroutines.i.a(e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r27, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L186
    L137:
        r48 = null;
        goto L138
    L133:
        r47 = null;
        goto L134
    L129:
        r46 = null;
    L108:
        r116 = r13;
        goto L109
    L97:
        r36 = null;
    L107:
        r111 = "client_meta";
        r110 = r110;
        goto L108
    L90:
        if (r9.getResult().getIntent() == null) goto L93;
        if (r17 == true) goto L93;
        r114 = true;
        goto L94
    L154:
        r55 = r33;
        if (r110 == null) goto L164;
        String r65 = String.valueOf(r26.getQuestionId());
        if ((r21.d() & UiType.FLAG_NO_FEEDBACK) != 0) goto L161;
        if (r31 == true) goto L161;
        boolean r66 = false;
    L162:
        IIntentTraceService.a.a(r110, r65, "no_feedback", Boolean.valueOf(r66), 0, 8, null);
    L161:
        r66 = true;
    L164:
        String r67 = r21.b();
        List<AppEntity> r68 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L167;
        Object r117 = r12.getEntity();
    L168:
        com.obric.agent.entity.b r69 = useEntityForContent(r18, r117, r68, r17);
        if (r69.b() == null) goto L175;
        r67 = r69.b();
        d.h.b.o.a(r67);
        if (r69.a() == true) goto L175;
        Boolean r118 = false;
        if (r110 == null) goto L176;
        r110.onResultReceived(String.valueOf(r26.getQuestionId()), new com.obric.agent.trace.f(com.obric.agent.trace.n.f15582a, r67, 0, 4, null));
    L176:
        if (r110 == null) goto L178;
        IIntentTraceService.a.a(r110, String.valueOf(r27.getQuestionId()), "need_to_summarize", r118, 0, 8, null);
    L178:
        if (r67 == null) goto L186;
        if (d.h.b.o.a(r118, true) == false) goto L183;
        if (r30 == true) goto L183;
        r67 = INSTANCE.handleSummarize(r26, r67);
    L183:
        boolean r70 = ((Collection) ZeusTransformUtils.preCheckCast(r68, Collection.class, "com.obric.aiagent.plugin")).isEmpty();
        r56 = true;
        if ((!r70) == false) goto L205;
        ObricService r71 = INSTANCE;
        d.h.b.o.a(r67);
        r71.handleFormat(r67);
    L175:
        r118 = r13;
        goto L176
    L167:
        r117 = null;
    L71:
        r7.put("isSilent", 1);
        goto L72
    L67:
        r20 = null;
    L55:
        th = move-exception;
        d.n.a r72 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
    L61:
        r5 = null;
        goto L62
    L45:
        r22 = r28;
        goto L46
    L41:
        r1 = null;
        goto L43
    L28:
        r18 = null;
        goto L30
    L24:
        r16 = null;
        goto L25
    L20:
        r14 = null;
        goto L21
    L17:
        r13 = null;
    L14:
        r12 = null;
    L7:
        r9 = null;
        goto L8
    }

    private final void fillClientToolDuration(IntentAppAction r4, IntentAppAction r5) {
        com.obric.agent.utils.i.a r3 = com.obric.agent.utils.i.f16033a.a(r4.getContent(), String.valueOf(r4.getQuestionId()));
        if (r3 == null) goto L8;
        Map<? extends String, ? extends String> r6 = ao.a(new d.m[]{d.s.a("client_tool_duration", String.valueOf(r3.b())), d.s.a("client_tool_info", r3.a())});
        ConcurrentHashMap<String, String> r7 = r5.getExt();
        if (r7 == null) goto L9;
        r7.putAll(r6);
        return;
    L9:
        return;
    }

    private final String handleSummarize(IntentAppAction r12, String r13) {
        String r0 = String.valueOf(r12.getQuestionId());
        IIntentTraceService r1 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        r1.onSummarize(r0);
    L5:
        if (r1 == null) goto L7;
        IIntentTraceService.a.a(r1, r0, "input", r13, 0, 8, null);
    L7:
        int r14 = 0;
        JsonObject r15 = JsonParser.parseString(r12.getContent()).getAsJsonObject();     // Catch: Exception -> L54
        if (r15 == null) goto L13;
        JsonElement r16 = r15.get("Content");     // Catch: Exception -> L54
        if (r16 == null) goto L13;
        String r17 = r16.getAsString();     // Catch: Exception -> L54
    L14:
        com.obric.agent.dm.e r11 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(getGson().fromJson(r17, com.obric.agent.dm.e.class), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L54
        if (r11 == null) goto L23;
        List<com.obric.agent.dm.f> r18 = r11.a();     // Catch: Exception -> L54
        if (r18 == null) goto L23;
        com.obric.agent.dm.f r19 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(d.a.p.l(r18), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L54
        if (r19 == null) goto L23;
        List<com.obric.agent.dm.b> r110 = r19.a();     // Catch: Exception -> L54
        if (r110 == null) goto L23;
        com.obric.agent.dm.b r111 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(d.a.p.n(r110), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L54
    L24:
        JsonObject r5 = new JsonObject();     // Catch: Exception -> L54
        if (r111 == null) goto L30;
        JsonObject r112 = r111.c();     // Catch: Exception -> L54
        if (r112 == null) goto L30;
        JsonObject r113 = r112.getAsJsonObject();     // Catch: Exception -> L54
        if (r113 == null) goto L30;
    L31:
        Iterator<String> r2 = r113.keySet().iterator();     // Catch: Exception -> L54
    L33:
        if (r2.hasNext() == false) goto L43;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L54
        JsonElement r4 = r113.get(r3);     // Catch: Exception -> L54
        if (r4 == null) goto L41;
        JsonObject r6 = r4.getAsJsonObject();     // Catch: Exception -> L54
        if (r6 == null) goto L41;
        JsonElement r7 = r6.get("values");     // Catch: Exception -> L54
        if (r7 == null) goto L41;
        String r8 = r7.getAsString();     // Catch: Exception -> L54
    L42:
        r5.addProperty(r3, r8);     // Catch: Exception -> L54
    L41:
        r8 = null;
        goto L42
    L43:
        if (r111 != null) goto L45;
    L53:
        return null;
    L45:
        if (r111.a() == null) goto L53;
        if (r1 == null) goto L49;
        IIntentTraceService.a.a(r1, r0, "summarize_keywords", r5, 0, 8, null);     // Catch: Exception -> L54
    L49:
        long r9 = SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime();     // Catch: Exception -> L54
        if (r1 == null) goto L55;
        IIntentTraceService.a.a(r1, r0, "model_cost", Long.valueOf(r9), 0, 8, null);     // Catch: Exception -> L54
    L55:
        if (r1 == null) goto L57;
        r1.addStateParams(r0, "summarize_result", null, r14);
    L57:
        return null;
    L30:
        r113 = new JsonObject();     // Catch: Exception -> L54
    L23:
        r111 = null;
    L13:
        r17 = null;
    L54:
        ILogDepend.Companion.e(TAG, "fail to summarize: " + r0);
        r14 = 1;
        goto L55
    }

    static /* synthetic */ com.obric.agent.entity.b useEntityForContent$default(ObricService r1, String r2, Object r3, List r4, boolean r5, int r6, Object r7) {
        List<AppEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = false;
    L9:
        return r1.useEntityForContent(r2, r3, r8, r5);
    }

    private final com.obric.agent.entity.b useEntityForContent(String r8, Object r9, List<AppEntity> r10, boolean r11) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        String r12 = null;
        boolean r1 = false;
        if (r9 == null) goto L54;
        if ((r9 instanceof Object[]) == false) goto L41;
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r3 = r13.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L15;
        Object r5 = r13[r4];
        if (ZeusTransformUtils.instanceOf(r5, ScheduleEntity.class) == false) goto L11;
        ScheduleEntity r6 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r5, ScheduleEntity.class, "com.obric.aiagent.plugin");
    L12:
        if (r6 == null) goto L14;
        r2.add(r6);
    L14:
        r4 = r4 + 1;
        goto L7
    L11:
        r6 = null;
        goto L12
    L15:
        List<? extends AppEntity> r14 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L34;
        if (r8 != null) goto L19;
    L21:
        boolean r15 = false;
    L22:
        if (r15 == false) goto L34;
        IEntityManager r16 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L54;
        com.obric.agent.entity.b r17 = r16.entityNlg(r14, r11);
        if (r17 == null) goto L54;
        if (r17.b() == null) goto L30;
        r12 = r17.b();
    L30:
        if (r7 == null) goto L32;
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin"));
    L32:
        boolean r18 = r17.a();
    L52:
        r1 = r18;
        goto L54
    L19:
        if (r8.equals("Office_SearchMeeting") != true) goto L21;
        r15 = true;
    L34:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L54;
        if (r8 == null) goto L54;
        if (r8.equals("Office_SendMessage") != true) goto L54;
        goto L54
    L41:
        if (ZeusTransformUtils.instanceOf(r9, ScheduleEntity.class) == false) goto L54;
        IEntityManager r19 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L54;
        com.obric.agent.entity.b r20 = r19.entityNlg((AppEntity) ZeusTransformUtils.preCheckCast(r9, AppEntity.class, "com.obric.aiagent.plugin"), r11);
        if (r20 == null) goto L54;
        if (r20.b() == null) goto L49;
        r12 = r20.b();
    L49:
        if (r7 == null) goto L51;
        r7.add(r9);
    L51:
        r18 = r20.a();
    L54:
        return new com.obric.agent.entity.b(r1, r12);
    }

    private final String handleFormat(String r8) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(removeToolCall(r8), CharSequence.class, "com.obric.aiagent.plugin");
        int r9 = 0;
        String r1 = "";
        Boolean r2 = null;
    L4:
        if (r9 >= r7.length()) goto L16;
        char r3 = r7.charAt(r9);
        if (INSTANCE.isChineseCharacter(r3) == false) goto L12;
        if (d.h.b.o.a(r2, false) == false) goto L10;
        r1 = r1 + ' ';
    L10:
        r1 = r1 + r3;
        r2 = true;
    L15:
        r9 = r9 + 1;
        goto L4
    L12:
        if (d.h.b.o.a(r2, true) == false) goto L14;
        r1 = r1 + ' ';
    L14:
        r1 = r1 + r3;
        r2 = false;
        goto L15
    L16:
        return r1;
    }

    private final String removeToolCall(String r7) {
        int r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), "\n\n---\n\n<tool_call>", 0, false, 6, null);
        if (r6 == (-1)) goto L6;
        String r8 = r7.substring(0, r6);
        d.h.b.o.c(r8, "substring(...)");
        return r8;
    L6:
        return r7;
    }

    private final boolean isChineseCharacter(char r3) {
        return new d.o.k("[\\u4e00-\\u9fa5\\u3000-\\u303F\\uFF00-\\uFFEF]").a((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r3), CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private final void handleComplexEntityIfNeeded(IntentAppAction r9, String r10, String r11) {
        ISecureLogDepend.Companion r8 = ISecureLogDepend.Companion;
        String r0 = TAG;
        r8.i(r0, "handleComplexEntityIfNeeded before " + r10 + " sourceIntent " + r11);
        com.obric.agent.b.a r12 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r9.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L93;
    L91:
        ISecureLogDepend.Companion.i(TAG, "handleComplexEntityIfNeeded after " + r10);
        return;
    L93:
    L89:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "handleComplexEntityIfNeeded failed " + e.getMessage());
        goto L91
    L5:
        switch(r10.hashCode()) {
            case -1780906473: goto L83;
            case -1286878101: goto L80;
            case -713435600: goto L39;
            case -710771821: goto L33;
            case -683154979: goto L30;
            case -405562718: goto L27;
            case 1139484115: goto L24;
            case 1639397908: goto L8;
            default: goto L91;
        };     // Catch: Exception -> L89
    L8:
        if (r10.equals("Office_SearchLarkContactInfoByAsr") == false) goto L91;
        LarkContactSearchResult r13 = (LarkContactSearchResult) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r12.b(), LarkContactSearchResult.class), LarkContactSearchResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        ISecureLogDepend.Companion.i(r0, "Office_SearchLarkContactInfoByAsr " + r13);     // Catch: Exception -> L89
        if (r13 == null) goto L91;
        List<LarkContacts> r1 = r13.getLarkContactsResults();     // Catch: Exception -> L89
        if (r1 == null) goto L22;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L89
    L16:
        if (r2.hasNext() == false) goto L22;
        List<ContactEntity> r3 = ((LarkContacts) ZeusTransformUtils.preCheckCast(r2.next(), LarkContacts.class, "com.obric.aiagent.plugin")).getContacts();     // Catch: Exception -> L89
        if (r3 == null) goto L16;
        IEntityManager r4 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        if (r4 == null) goto L16;
        r4.addEntities(r3);     // Catch: Exception -> L89
    L22:
        r12.a(EntityExtKt.a().toJson(r13));     // Catch: Exception -> L89
        r9.setContent(new Gson().toJson(r12));     // Catch: Exception -> L89
        ISecureLogDepend.Companion.i(TAG, "handleComplexEntityIfNeeded Office_SearchLarkContactInfoByAsr result.content " + r9.getContent());     // Catch: Exception -> L89
        goto L91
    L24:
        if (r10.equals("PC_IntentGlobalSearch") == false) goto L91;
    L85:
        GlobalAssistantSearchResponse r14 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r12.b(), GlobalAssistantSearchResponse.class), GlobalAssistantSearchResponse.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        if (r14 == null) goto L91;
        INSTANCE.addEcaIdForGlobalSearchResponse(r14);     // Catch: Exception -> L89
        r12.a(EntityExtKt.a().toJson(r14));     // Catch: Exception -> L89
        r9.setContent(new Gson().toJson(r12));     // Catch: Exception -> L89
        ISecureLogDepend.Companion.i(r0, "handleComplexEntityIfNeeded PC_GlobalSearch result.content " + r9.getContent());     // Catch: Exception -> L89
        goto L91
    L27:
        if (r10.equals("PC_CommonGlobalSearch") == true) goto L85;
    L30:
        if (r10.equals("PC_AppFcEntitySearch") == false) goto L91;
    L41:
        SearchResponse r5 = (SearchResponse) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r12.b(), SearchResponse.class), SearchResponse.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        boolean r6 = true;
        com.obric.assistant.dm.api.b r7 = null;
        if (r5 == null) goto L69;
        SearchResult r15 = r5.getData();     // Catch: Exception -> L89
        if (r15 == null) goto L50;
        List<AppEntity> r16 = r15.getEntityList();     // Catch: Exception -> L89
        if (r16 == null) goto L50;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L50;
        boolean r17 = true;
    L51:
        if (r17 == false) goto L68;
        IEntityManager r18 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        if (r18 == null) goto L59;
        SearchResult r19 = r5.getData();     // Catch: Exception -> L89
        if (r19 == null) goto L57;
        List<AppEntity> r20 = r19.getEntityList();     // Catch: Exception -> L89
    L58:
        d.h.b.o.a(r20);     // Catch: Exception -> L89
        List<AppEntity> r110 = r18.addVirtualEntities(r20, r11);     // Catch: Exception -> L89
    L60:
        if (r110 == null) goto L66;
        SearchResult r21 = r5.getData();     // Catch: Exception -> L89
        if (r21 == null) goto L64;
        AssistantQuResult r22 = r21.getQuResult();     // Catch: Exception -> L89
    L65:
        SearchResult r23 = new SearchResult(r110, r22);     // Catch: Exception -> L89
    L67:
        r5.setData(r23);     // Catch: Exception -> L89
        goto L68
    L64:
        r22 = null;
        goto L65
    L66:
        r23 = null;
        goto L67
    L57:
        r20 = null;
        goto L58
    L59:
        r110 = null;
    L68:
        r12.a(EntityExtKt.a().toJson(r5));     // Catch: Exception -> L89
        r9.setContent(new Gson().toJson(r12));     // Catch: Exception -> L89
        ISecureLogDepend.Companion.i(r0, "handleComplexEntityIfNeeded PC_SearchAppEntity result.content " + r9.getContent());     // Catch: Exception -> L89
    L50:
        r17 = false;
    L69:
        IDialogManagement r24 = (IDialogManagement) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogManagement.class), IDialogManagement.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        if (r24 == null) goto L72;
        r7 = r24.handlePersonalContext(r5);     // Catch: Exception -> L89
    L72:
        if (r7 != null) goto L74;
    L76:
        r6 = false;
    L77:
        if (r6 == false) goto L91;
        ((Map) ZeusTransformUtils.preCheckCast(nlgForPCSearch, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r9.getQuestionId()), r7.b());     // Catch: Exception -> L89
        goto L91
    L74:
        if (r7.a() != 0) goto L76;
    L33:
        if (r10.equals("PC_GlobalSearchIntent") == false) goto L91;
        GlobalAssistantIntentSearchResponse r111 = (GlobalAssistantIntentSearchResponse) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r12.b(), GlobalAssistantIntentSearchResponse.class), GlobalAssistantIntentSearchResponse.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L89
        if (r111 == null) goto L91;
        INSTANCE.addEcaIdForGlobalSearchResponse(r111.getGlobalSearchResponse());     // Catch: Exception -> L89
        r12.a(EntityExtKt.a().toJson(r111));     // Catch: Exception -> L89
        r9.setContent(new Gson().toJson(r12));     // Catch: Exception -> L89
        ISecureLogDepend.Companion.i(r0, "handleComplexEntityIfNeeded PC_GlobalSearchIntent result.content " + r9.getContent());     // Catch: Exception -> L89
        goto L91
    L39:
        if (r10.equals("PC_SearchAppEntity") == true) goto L41;
    L80:
        if (r10.equals("PC_PersonalContextSearch") == true) goto L85;
    L83:
        if (r10.equals("PC_GlobalSearch") == true) goto L85;
        goto L85
    }

    private final void addEcaIdForGlobalSearchResponse(GlobalAssistantSearchResponse r6) {
        if (r6 == null) goto L51;
        i.f14571a.a(r6);
        GlobalAssistantSearchEntityResult r5 = r6.getEntityResult();
        boolean r1 = false;
        if (r5 == null) goto L10;
        List<AppEntity> r7 = r5.getEntityList();
        if (r7 == null) goto L10;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L10;
        boolean r8 = true;
    L11:
        List<ProactiveMemoryEntity> r3 = null;
        if (r8 == false) goto L20;
        IEntityManager r9 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L20;
        GlobalAssistantSearchEntityResult r4 = r6.getEntityResult();
        if (r4 == null) goto L18;
        List<AppEntity> r10 = r4.getEntityList();
    L19:
        d.h.b.o.a(r10);
        r9.addEntities(r10);
        goto L20
    L18:
        r10 = null;
    L20:
        GlobalAssistantSearchMemoryResult r11 = r6.getMemoryResult();
        if (r11 == null) goto L27;
        List<MemoryEntity> r12 = r11.getEntityList();
        if (r12 == null) goto L27;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L36;
        IEntityManager r14 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L36;
        GlobalAssistantSearchMemoryResult r15 = r6.getMemoryResult();
        if (r15 == null) goto L34;
        List<MemoryEntity> r16 = r15.getEntityList();
    L35:
        d.h.b.o.a(r16);
        r14.addEntities(r16);
        goto L36
    L34:
        r16 = null;
    L36:
        ProactiveRecommendationSearchResult r17 = r6.getProactiveRecommendationResult();
        if (r17 == null) goto L43;
        List<ProactiveMemoryEntity> r18 = r17.getEntityList();
        if (r18 == null) goto L43;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L43;
        r1 = true;
    L43:
        if (r1 == false) goto L52;
        IEntityManager r19 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L53;
        ProactiveRecommendationSearchResult r20 = r6.getProactiveRecommendationResult();
        if (r20 == null) goto L49;
        r3 = r20.getEntityList();
    L49:
        d.h.b.o.a(r3);
        r19.addEntities(r3);
        return;
    L53:
        return;
    L52:
        return;
    L27:
        r13 = false;
    L10:
        r8 = false;
        goto L11
    }

    private final String destructInputParams(IntentAppAction r6) {
        JsonObject r7 = JsonParser.parseString(r6.getContent()).getAsJsonObject();
        if (r7 == null) goto L7;
        JsonElement r8 = r7.get("Content");
        if (r8 == null) goto L7;
        String r9 = r8.getAsString();
    L8:
        com.obric.agent.utils.u r1 = com.obric.agent.utils.u.f16076a;
        Gson r5 = getGson();
        d.h.b.o.c(r5, "<get-gson>(...)");
        com.obric.agent.dm.e r10 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(r1.a(r5, r9, com.obric.agent.dm.e.class, "destructInputParams"), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L17;
        List<com.obric.agent.dm.f> r11 = r10.a();
        if (r11 == null) goto L17;
        com.obric.agent.dm.f r12 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(d.a.p.l(r11), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L17;
        List<com.obric.agent.dm.b> r13 = r12.a();
        if (r13 == null) goto L17;
        com.obric.agent.dm.b r14 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(d.a.p.n(r13), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
    L18:
        if (r14 == null) goto L22;
        JsonObject r15 = r14.c();
        if (r15 == null) goto L22;
        JsonObject r16 = r15.getAsJsonObject();
    L23:
        if (r16 == null) goto L41;
        JsonObject r17 = r16.deepCopy();
        Iterator<String> r0 = r16.keySet().iterator();
    L26:
        if (r0.hasNext() == false) goto L33;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r3 = r16.get(r2);
        if (r3.isJsonObject() == false) goto L26;
        JsonElement r4 = r3.getAsJsonObject().get("value");
        if (r4 == null) goto L26;
        r17.add(r2, r4);
        goto L26
    L33:
        return r17.toString();
    L41:
        return null;
    L22:
        r16 = null;
    L17:
        r14 = null;
    L7:
        r9 = null;
        goto L8
    }

    private final Map<String, Object> buildSemanticSupplementExt(IntentAppAction r4) {
        Map<String, Object> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<String, String> r5 = r4.getExt();
        if (r5 == null) goto L7;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("is_obric_continuous_talk"), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L7;
        r3.put("is_obric_continuous_talk", r6);
    L7:
        return r3;
    }

    private final void notifySemanticTraceFailure(String r5, final String r6, String r7, String r8, Map<String, Object> r9) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "notifySemanticTraceFailure, intentName=" + r5 + ", queryId=" + r6 + ", errCode=" + r7 + ", errMsg=" + r8);
        r4.put(KEY_SEMANTIC_TRACE_FAILURE_CODE, r7);
        r4.put(KEY_SEMANTIC_TRACE_FAILURE_MSG, r8);
        IFlowMessageIDL r10 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r10 == null) goto L6;
        r10.notifySemanticUserEditEvent(r5, r6, r4, (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.preCheckCast(new BinderC11121(r6), IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void handleEntitiesDeleteIfNeeded(IntentAppAction r5, IntentAppAction r6, String r7) {
        ILogDepend.Companion.i(TAG, "handleEntitiesDeleteIfNeeded " + r7);
        com.obric.agent.b.a r8 = (com.obric.agent.b.a) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r6.getContent(), com.obric.agent.b.a.class), com.obric.agent.b.a.class, "com.obric.aiagent.plugin");
        if (r8.a() != 0) goto L68;
        if (r7 == null) goto L69;
        int r0 = r7.hashCode();     // Catch: Exception -> L55
        if (r0 == (-1665258020)) goto L40;
        if (r0 == (-444170667)) goto L29;
        if (r0 == 1138119447) goto L14;
    L60:
        return;
    L14:
        if (r7.equals("Contacts_Delete") == false) goto L60;
        String r4 = destructInputParams(r5);     // Catch: Exception -> L26
        if (r4 == null) goto L60;
        ContactsDeleteParams r9 = (ContactsDeleteParams) ZeusTransformUtils.preCheckCast(INSTANCE.parseEntityJsonCompat(r4, (Type) ZeusTransformUtils.preCheckCast(ContactsDeleteParams.class, Type.class, "com.obric.aiagent.plugin")), ContactsDeleteParams.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        if (r9 == null) goto L60;
        ContactEntity[] r10 = r9.getTargets();     // Catch: Exception -> L26
        if (r10 == null) goto L60;
        IEntityManager r11 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L26
        if (r11 == null) goto L60;
        r11.removeEntities(d.a.i.a(r10));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Exception " + e);     // Catch: Exception -> L55
        goto L60
    L29:
        if (r7.equals("Clock_DeleteCountdown") == false) goto L60;
        String r12 = r8.e();     // Catch: Exception -> L37
        if (r12 == null) goto L60;
        ObricService r13 = INSTANCE;     // Catch: Exception -> L37
        Type r14 = new ObricService$handleEntitiesDeleteIfNeeded$3$entityList$1().getType();     // Catch: Exception -> L37
        d.h.b.o.c(r14, "getType(...)");     // Catch: Exception -> L37
        List<? extends AppEntity> r15 = (List) ZeusTransformUtils.preCheckCast(r13.parseEntityJsonCompat(r12, r14), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        IEntityManager r16 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        if (r16 == null) goto L60;
        r16.removeEntities(r15);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Exception " + e);     // Catch: Exception -> L55
        goto L60
    L40:
        if (r7.equals("Phone_Delete") == false) goto L60;
        String r17 = destructInputParams(r5);     // Catch: Exception -> L52
        if (r17 == null) goto L60;
        PhoneDeleteParams r18 = (PhoneDeleteParams) ZeusTransformUtils.preCheckCast(INSTANCE.parseEntityJsonCompat(r17, (Type) ZeusTransformUtils.preCheckCast(PhoneDeleteParams.class, Type.class, "com.obric.aiagent.plugin")), PhoneDeleteParams.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L52
        if (r18 == null) goto L60;
        CallHistoryEntity[] r19 = r18.getTargets();     // Catch: Exception -> L52
        if (r19 == null) goto L60;
        IEntityManager r20 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L52
        if (r20 == null) goto L60;
        r20.removeEntities(d.a.i.a(r19));     // Catch: Exception -> L52
    L52:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "Exception " + e);     // Catch: Exception -> L55
    L55:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "handleEntitiesDeleteIfNeeded failed " + e.getMessage());
        return;
    L69:
        return;
    }

    private final <T> T parseEntityJsonCompat(String r3, Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        ObricService r2 = (ObricService) ZeusTransformUtils.preCheckCast(this, ObricService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = (T) d.n.f(EntityExtKt.a().fromJson(r3, r5));
    L8:
        if (d.n.c(r6) == null) goto L15;
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L12
        r6 = (T) d.n.f(EntityExtKt.c().fromJson(r3, r5));
    L12:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r6 = (T) d.n.f(d.o.a(th));
    L15:
        if (d.n.c(r6) != null) goto L18;
        return (T) r6;
    L18:
        return (T) INSTANCE.getGson().fromJson(r3, r5);
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L8
    }

    private final JSONObject mergeJsonObjects(JSONObject r4, JSONObject r5) {
        JSONObject r3 = new JSONObject(r4.toString());
        Iterator<String> r6 = r5.keys();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        r3.put(r0, r5.opt(r0));
        goto L4
    L6:
        return r3;
    }

    public final void startActivityRestoreDeletedSysApp(Context r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        Intent r7 = new Intent("com.obric.action.settings.RESTORE_SYSAPP");     // Catch: Exception -> L15
        if (r6 == null) goto L8;
        r7.putExtra("package_name", r6);     // Catch: Exception -> L15
    L8:
        if (r7.resolveActivity(r4.getPackageManager()) == null) goto L10;
        r7.addFlags(268435456);     // Catch: Exception -> L15
        ZeusTransformUtils.startActivity(r4, r7, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        return;
    L10:
        Intent r8 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L15
        r8.setData(Uri.parse("market://search?s=1"));     // Catch: Exception -> L15
        r8.setPackage("com.obric.appstore");     // Catch: Exception -> L15
        if (r6 == null) goto L13;
        r8.putExtra("package_name", r6);     // Catch: Exception -> L15
    L13:
        r8.addFlags(268435456);     // Catch: Exception -> L15
        ZeusTransformUtils.startActivity(r4, r8, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }
}
