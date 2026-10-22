package com.obric.agent.complextask;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.provider.Settings;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.agent.IAppIntentFeedback;
import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.agent.trace.q;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.ax;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.executionengine.utils.pkms.PackageInfoCache;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.manager.api.aq;
import com.obric.aiagent.skill.manager.api.u;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.api.IAutoActionAppListApi;
import com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.ITaskStateChangeCallback;
import com.obric.capabilitykit.common.TaskState;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.BasePhoneOpenPageIntent;
import com.obric.capabilitykit.common.intent.PhoneOpenPageParams;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.funcall_api.IIntentActionService;
import com.obric.funcall_api.bean.IntentAppAction;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.RecommendComplexQuery;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.ae;
import d.k;
import d.n;
import d.o;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import org.json.JSONArray;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComplexTaskServiceImpl implements IComplexTaskService {
    public static final a Companion = null;
    private static final String KEY_O_LARK_CLI_AUTH_STATE = "o_lark_cli_auth_state";
    private static final String KEY_O_OMNI_ENABLE_SKILL = "o_omni_enable_skill";
    private static final String KEY_O_SKILL_LIST = "o_skill_list";
    private static final String OEM_INSTALLED_APPS_RUNTIME_PERMISSION_ENABLE = "oem_installed_apps_runtime_permission_enable";
    private static final String TAG = "ComplexTaskServiceImpl";
    private static final String TAKE_OVER_OCCUPY_SCENE_PREFIX = "occupy_";
    private static final String TAKE_OVER_SCENE_KEY = "take_over_scene";
    private static final String USER_MEMORY_QUERY_PARAMS = null;
    private com.obric.agent.complextask.e contentProviderClient;
    private Context context;
    private com.obric.agent.complextask.f taskQueueManager;

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14304a = null;

        static {
            int[] r0 = new int[TaskState.values().length];
            r0[TaskState.UserOperationBegin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[TaskState.UserOperationEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[TaskState.CallUser.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[TaskState.Clarify.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[TaskState.Stop.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f14304a = r0;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    @d.c.b.a.f(b = "ComplexTaskServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskServiceImpl$addComplexTaskExt$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14306b;

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14306b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14306b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f14305a != 0) goto L10;
            o.a(r5);
            IFlowMessageIDL r6 = ak.a(aa.b(IFlowMessageIDL.class));
            if (r6 == null) goto L8;
            r6.updateMessageExt(this.f14306b, ao.a(new d.m[]{s.a("o_not_interrupt", "1"), s.a("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK)}));
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    @d.c.b.a.f(b = "ComplexTaskServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskServiceImpl$addEventTaskExecutionRecords$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IMMessage f14308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.assistant.dm.api.statemachine.core.TaskState f14309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.eventkit.task.model.a f14310d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ComplexTaskServiceImpl f14311e;
        final /* synthetic */ int f;
        final /* synthetic */ long g;

        /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14312a = null;

            static {
                int[] r0 = new int[TaskType.values().length];
                r0[TaskType.COMPLEX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TaskType.OAUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f14312a = r0;
            }
        }

        d(IMMessage r3, com.obric.assistant.dm.api.statemachine.core.TaskState r4, com.obric.eventkit.task.model.a r5, ComplexTaskServiceImpl r6, int r7, long r8, d.c.d<? super d> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14308b = r3;
            this.f14309c = r4;
            this.f14310d = r5;
            this.f14311e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14308b, this.f14309c, this.f14310d, this.f14311e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r24) {
            d.c.a.b.a();
            if (this.f14307a != 0) goto L130;
            o.a(r24);
            IMMessage r1 = this.f14308b;
            if (r1 == null) goto L9;
            Map<String, String> r2 = r1.getExt();
            if (r2 == null) goto L9;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("o_task_result_text"), String.class, "com.obric.aiagent.plugin");
        L10:
            IMMessage r4 = this.f14308b;
            if (r4 == null) goto L17;
            Map<String, String> r5 = r4.getExt();
            if (r5 == null) goto L17;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(IOmniModelService.MESSAGE_EXT_KEY), String.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L17;
            String r20 = IOmniModelService.Companion.a().parseEntryFromJson(r6).a();
        L18:
            TaskInfo r7 = this.f14309c.getTaskInfo();
            if (r7 == null) goto L21;
            TaskType r8 = r7.getTaskType();
        L22:
            if (r8 != null) goto L24;
            int r9 = -1;
        L26:
            if (r9 == 1) goto L30;
            if (r9 != 2) goto L30;
            int r10 = 0;
        L31:
            String r11 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_try_run_prefix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_try_run_prefix"));
            d.h.b.o.c(r11, "getString(...)");
            TaskInfo r12 = this.f14309c.getTaskInfo();
            if (r12 == null) goto L36;
            IMMessage r13 = r12.getMessage();
            if (r13 == null) goto L36;
            String r14 = com.obric.agent.im.b.a(r13);
        L37:
            com.obric.eventkit.task.model.a r15 = this.f14310d;
            if (r15 == null) goto L40;
            boolean r16 = d.h.b.o.a(r15.h(), d.c.b.a.b.a(true));
        L41:
            if (r16 == false) goto L49;
            if (r14 != null) goto L44;
        L46:
            boolean r17 = false;
        L47:
            if (r17 == false) goto L49;
            String r18 = r14.substring(r11.length());
            d.h.b.o.c(r18, "substring(...)");
            r14 = r18;
            goto L49
        L44:
            if (d.o.o.b(r14, r11, false, 2, null) != true) goto L46;
            r17 = true;
        L49:
            TaskInfo r19 = this.f14309c.getTaskInfo();
            if (r19 == null) goto L52;
            String r110 = r19.getQueryId();
        L53:
            com.obric.eventkit.task.model.a r21 = this.f14310d;
            if (r21 == null) goto L56;
            boolean r22 = d.h.b.o.a(r21.h(), d.c.b.a.b.a(true));
        L57:
            String r111 = "";
            if (r22 == false) goto L65;
            if (r10 != 1) goto L65;
            d.m[] r23 = new d.m[2];
            if (r110 != null) goto L63;
            String r25 = "";
        L64:
            r23[0] = s.a("queryId", r25);
            r23[1] = s.a("taskFlag", String.valueOf(262144));
            Map r26 = ao.b(r23);
        L70:
            IMMessage r27 = this.f14308b;
            if (r27 == null) goto L76;
            Map<String, String> r28 = r27.getExt();
            if (r28 == null) goto L76;
            String r29 = (String) ZeusTransformUtils.preCheckCast(r28.get("o_omni_reply_unique_id"), String.class, "com.obric.aiagent.plugin");
            if (r29 == null) goto L76;
        L77:
            r26.put("o_omni_reply_unique_id", r29);
            IMMessage r30 = this.f14308b;
            if (r30 == null) goto L83;
            Map<String, String> r31 = r30.getExt();
            if (r31 == null) goto L83;
            String r32 = (String) ZeusTransformUtils.preCheckCast(r31.get("o_omni_resource_id"), String.class, "com.obric.aiagent.plugin");
            if (r32 == null) goto L83;
        L84:
            r26.put("o_omni_resource_id", r32);
            IMMessage r33 = this.f14308b;
            if (r33 == null) goto L92;
            Map<String, String> r34 = r33.getExt();
            if (r34 == null) goto L92;
            String r35 = (String) ZeusTransformUtils.preCheckCast(r34.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
            if (r35 == null) goto L92;
            r111 = r35;
        L92:
            r26.put("o_omni_task_id", r111);
            String r36 = ComplexTaskServiceImpl.access$getFriendlyStopReason(this.f14311e, (String) ZeusTransformUtils.preCheckCast(this.f14309c.getExtra().get("stop_reason"), String.class, "com.obric.aiagent.plugin"));
            ILogDepend.Companion r112 = ILogDepend.Companion;
            StringBuilder r113 = new StringBuilder().append("addEventTaskExecutionRecords taskResult:").append(r3).append(" resultCode:").append(this.f).append(" taskModel:");
            IMMessage r114 = this.f14308b;
            if (r114 == null) goto L97;
            Map<String, String> r115 = r114.getExt();
            if (r115 == null) goto L97;
            String r37 = (String) ZeusTransformUtils.preCheckCast(r115.get(IOmniModelService.MESSAGE_EXT_KEY), String.class, "com.obric.aiagent.plugin");
        L98:
            r112.i(ComplexTaskServiceImpl.TAG, r113.append(r37).toString());
            if (r3 != null) goto L107;
            int r38 = this.f;
            if (r38 == 1) goto L105;
            if (r38 == 2) goto L104;
            r3 = r36;
        L106:
            d.h.b.o.a(r3);
            goto L107
        L104:
            r3 = "用户手动停止";
            goto L106
        L105:
            r3 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oauto_notif_exec_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_exec_success"));
        L107:
            com.obric.eventkit.task.model.a r39 = this.f14310d;
            if (r39 == null) goto L110;
            int r40 = r39.a();
        L111:
            com.obric.eventkit.task.model.a r41 = this.f14310d;
            if (r41 == null) goto L114;
            String r116 = r41.b();
        L115:
            com.obric.eventkit.task.model.a r42 = this.f14310d;
            if (r42 == null) goto L120;
            Integer r43 = r42.d();
            if (r43 == null) goto L120;
            r10 = r43.intValue();
        L120:
            int r117 = r10;
            TaskInfo r44 = this.f14309c.getTaskInfo();
            if (r44 == null) goto L123;
            long r45 = r44.getCreatedTime();
        L124:
            String r46 = r110;
            EventTaskExecutionRecord r118 = new EventTaskExecutionRecord(0, r40, r117, r116, r14, r45, this.g, this.f, r3, r26, r20, 1, null);
            ITaskManagerApi r47 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r47 == null) goto L128;
            r47.onOmniTaskEnd(r118, r46, this.f, r3);
        L128:
            return x.f38692a;
        L123:
            r45 = 0;
            goto L124
        L114:
            r116 = null;
            goto L115
        L110:
            r40 = 0;
        L97:
            r37 = null;
        L83:
            r32 = "";
        L76:
            r29 = "";
            goto L77
        L63:
            r25 = r110;
        L65:
            d.m[] r48 = new d.m[1];
            if (r110 != null) goto L68;
            String r49 = "";
        L69:
            r48[0] = s.a("queryId", r49);
            r26 = ao.b(r48);
            goto L70
        L68:
            r49 = r110;
            goto L69
        L56:
            r22 = false;
            goto L57
        L52:
            r110 = null;
            goto L53
        L40:
            r16 = false;
        L36:
            r14 = null;
        L30:
            r10 = 1;
            goto L31
        L24:
            r9 = a.f14312a[r8.ordinal()];
            goto L26
        L21:
            r8 = null;
        L17:
            r20 = null;
        L9:
            r3 = null;
            goto L10
        L130:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    @d.c.b.a.f(b = "ComplexTaskServiceImpl.kt", c = {465}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskServiceImpl$appendLarkCliAuthStateExtras$authState$1$1")
    static final class e extends l implements m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14313a;

        e(d.c.d<? super e> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14313a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.agent.office.c r6 = com.obric.agent.office.c.f15302a;
            d.c.d<? super String> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14313a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    @d.c.b.a.f(b = "ComplexTaskServiceImpl.kt", c = {692}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskServiceImpl$getAppNameInstalledListExt$3$visibleAppList$1")
    static final class f extends l implements m<am, d.c.d<? super List<? extends String>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f14315b;

        f(Context r3, d.c.d<? super f> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14315b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<String>> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f14315b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends String>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14314a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L16:
            return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            IAutoActionAppListApi r7 = (IAutoActionAppListApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionAppListApi.class), IAutoActionAppListApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            Context r2 = this.f14315b;
            d.c.d<? super List<String>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14314a = 1;
            r6 = r7.getAppListForModel(r2, r4);
            if (r6 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    public static final class g implements com.obric.assistant.dm.api.statemachine.core.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f14316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComplexTaskServiceImpl f14317b;

        /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14318a = null;

            static {
                int[] r0 = new int[TaskType.values().length];
                r0[TaskType.COMPLEX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f14318a = r0;
            }
        }

        /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
        @d.c.b.a.f(b = "ComplexTaskServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskServiceImpl$init$1$onTaskEnd$3$1$1$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14319a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f14320b;

            b(String r3, d.c.d<? super b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14320b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f14320b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f14319a != 0) goto L7;
                o.a(r4);
                com.obric.memorydata.sdk.a r5 = com.obric.memorydata.sdk.a.f33793a;
                JSONObject r0 = new JSONObject();
                r0.put(ObricMemoryConstants.KEY_SESSION_ID, this.f14320b);
                String r3 = r0.toString();
                d.h.b.o.c(r3, "toString(...)");
                r5.a(r3, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1, State r2, DMEvent r3, Exception r4) {
            d.h.b.o.e(r1, "taskInfo");
            d.h.b.o.e(r2, "currentState");
            d.h.b.o.e(r4, "exception");
        }

        g(Context r3, ComplexTaskServiceImpl r4) {
            this.f14316a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f14317b = r4;
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(DMState r3) {
            d.h.b.o.e(r3, "status");
            ISecureLogDepend.Companion.i("DialogStateManager", "onDMStateChanged " + r3);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r9) {
            d.h.b.o.e(r9, "taskInfo");
            ISecureLogDepend.Companion.i("DialogStateManager", "onTaskAdded " + r9);
            com.obric.agent.complextask.c.f14330a.a(r9, null, (State) ZeusTransformUtils.preCheckCast(new ComplexTaskState.Idle(r9.getTaskId(), r9, 0, null, 12, null), State.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void b(TaskInfo r23) {
            d.h.b.o.e(r23, "taskInfo");
            ISecureLogDepend.Companion.i("DialogStateManager", "onTaskRemoved " + r23);
            IMMessage r2 = r23.getMessage();
            int r3 = 1;
            if (r2 == null) goto L7;
            String r4 = com.obric.agent.im.b.a(r2);
            if (r4 == null) goto L7;
            com.obric.memorydata.sdk.a.f33793a.a(this.f14316a, r4, true);
        L7:
            long r12 = System.currentTimeMillis() - r23.getCreatedTime();
            IDialogStateManager r5 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
            DMState r6 = r5.getCurrentDMState();
        L11:
            if (r6 == null) goto L24;
            List<State> r7 = r6.getActiveTasks();
            if (r7 == null) goto L24;
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L16:
            if (r8.hasNext() == false) goto L23;
            Object r9 = r8.next();
            if (d.h.b.o.a(((State) ZeusTransformUtils.preCheckCast(r9, State.class, "com.obric.aiagent.plugin")).getTaskId(), r23.getTaskId()) == false) goto L16;
            State r10 = (State) ZeusTransformUtils.preCheckCast(r9, State.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L24;
            com.obric.assistant.dm.api.statemachine.core.TaskState r11 = (com.obric.assistant.dm.api.statemachine.core.TaskState) ZeusTransformUtils.preCheckCast(r10, com.obric.assistant.dm.api.statemachine.core.TaskState.class, "com.obric.aiagent.plugin");
        L25:
            q r13 = q.f15713a;
            IMMessage r14 = r23.getMessage();
            if (r14 == null) goto L28;
            String r15 = r14.getMessageId();
        L29:
            r13.a(String.valueOf(r15), false);
            if (r11 == null) goto L36;
            Map<String, String> r16 = r11.getExtra();
            if (r16 == null) goto L36;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r16.get("message_reply"), String.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L36;
            IMMessage r18 = (IMMessage) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson(r17, IMMessage.class), IMMessage.class, "com.obric.aiagent.plugin");
        L37:
            if (r18 == null) goto L41;
            Map<String, String> r19 = r18.getExt();
            if (r19 == null) goto L41;
            String r20 = (String) ZeusTransformUtils.preCheckCast(r19.get("o_event_task_conflict_flag"), String.class, "com.obric.aiagent.plugin");
        L42:
            IMMessage r21 = r23.getMessage();
            if (r21 == null) goto L52;
            Map<String, String> r22 = r21.getExt();
            if (r22 == null) goto L52;
            String r24 = (String) ZeusTransformUtils.preCheckCast(r22.get("o_event_task"), String.class, "com.obric.aiagent.plugin");
            if (r24 == null) goto L52;
            com.obric.eventkit.task.model.a r25 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson(r24, com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
            if (r25 == null) goto L52;
        L51:
            com.obric.eventkit.task.model.a r110 = r25;
        L59:
            if (r110 == null) goto L63;
            String r26 = r110.b();
            if (r26 == null) goto L63;
            q.f15713a.a(r26, false);
        L63:
            if (r11 == null) goto L131;
            ComplexTaskServiceImpl r27 = this.f14317b;
            if (r23.getTaskType() != TaskType.COMPLEX) goto L122;
            int r111 = ComplexTaskServiceImpl.access$resolveTaskResultCode(r27, r18, r11, r20);
            Map<String, String> r112 = r23.getExt();
            if (r112 == null) goto L94;
            String r28 = (String) ZeusTransformUtils.preCheckCast(r112.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
            if (r28 == null) goto L94;
            n.a r113 = n.f38560a;     // Catch: Throwable -> L72
            g r0 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L72
            n.f(kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(r28, null), m.class, "com.obric.aiagent.plugin"), 2, null));     // Catch: Throwable -> L72
        L75:
            if (r111 == 1) goto L79;
            if (r111 != 2) goto L80;
            r3 = 2;
        L80:
            ISecureLogDepend.Companion.i(ComplexTaskServiceImpl.TAG, "onTaskEnd id:" + r28 + ' ' + ComplexTaskServiceImpl.access$getContentProviderClient$p(r27) + " resultCode:" + r111 + " reason:" + r3);
            com.obric.agent.complextask.e r1 = ComplexTaskServiceImpl.access$getContentProviderClient$p(r27);
            if (r1 == null) goto L88;
            String r29 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_complex_task_stopped, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_complex_task_stopped"));
            d.h.b.o.c(r29, "getString(...)");
            if (r18 == null) goto L86;
            Map<String, String> r30 = r18.getExt();
            if (r30 == null) goto L86;
        L87:
            com.obric.agent.complextask.e.b r31 = r1.a(r28, r29, r3, r30);
        L89:
            ISecureLogDepend.Companion r32 = ISecureLogDepend.Companion;
            StringBuilder r33 = new StringBuilder().append("stop task ");
            if (r31 == null) goto L92;
            String r34 = r31.a();
        L93:
            r32.i(ComplexTaskServiceImpl.TAG, r33.append(r34).toString());
            com.obric.agent.intents.skill.b.a.f14896a.a(r23);
        L95:
            ComplexTaskState r35 = (ComplexTaskState) ZeusTransformUtils.preCheckCast(r11, ComplexTaskState.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L102;
            Map<String, String> r36 = r18.getExt();
            if (r36 == null) goto L102;
            String r37 = (String) ZeusTransformUtils.preCheckCast(r36.get("o_complex_task_thinking_start_timestamp"), String.class, "com.obric.aiagent.plugin");
            if (r37 == null) goto L102;
            Long r38 = d.o.o.e(r37);
        L104:
            if (r18 == null) goto L112;
            Map<String, String> r39 = r18.getExt();
            if (r39 == null) goto L112;
            String r40 = (String) ZeusTransformUtils.preCheckCast(r39.get("o_complex_task_thinking_end_timestamp"), String.class, "com.obric.aiagent.plugin");
            if (r40 == null) goto L112;
            Long r41 = d.o.o.e(r40);
            if (r41 == null) goto L112;
            long r42 = r41.longValue();
        L113:
            if (r38 == null) goto L115;
            long r43 = ((Number) ZeusTransformUtils.preCheckCast(d.l.n.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r42 - r38.longValue()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(0L, Comparable.class, "com.obric.aiagent.plugin"), null), Number.class, "com.obric.aiagent.plugin")).longValue() * ((long) 1000);
        L117:
            if (r12 < WsConstants.EXIT_DELAY_TIME) goto L119;
        L121:
            ComplexTaskServiceImpl.access$addEventTaskExecutionRecords(r27, r18, r11, r110, r43, r111);
            return;
        L119:
            if (d.h.b.o.a(r20, "1") == true) goto L121;
            return;
        L115:
            r43 = r12;
        L112:
            r42 = System.currentTimeMillis() / ((long) 1000);
        L102:
            r38 = null;
            goto L104
        L92:
            r34 = null;
        L86:
            r30 = ao.b();
            goto L87
        L88:
            r31 = null;
            goto L89
        L79:
            r3 = 0;
        L72:
            th = move-exception;
            n.a r114 = n.f38560a;
            n.f(o.a(th));
        L94:
            r27 = r27;
            r111 = r111;
            r110 = r110;
            goto L95
        L122:
            com.obric.eventkit.task.model.a r115 = r110;
            if (d.h.b.o.a(r20, "1") == false) goto L133;
            ComplexTaskServiceImpl.access$addEventTaskExecutionRecords(r27, r18, r11, r115, r12, 3);
            return;
        L133:
            return;
        L131:
            return;
        L52:
            if (r18 == null) goto L58;
            Map<String, String> r44 = r18.getExt();
            if (r44 == null) goto L58;
            String r45 = (String) ZeusTransformUtils.preCheckCast(r44.get("o_event_task"), String.class, "com.obric.aiagent.plugin");
            if (r45 == null) goto L58;
            r25 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson(r45, com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, "com.obric.aiagent.plugin");
        L58:
            r110 = null;
        L41:
            r20 = null;
        L36:
            r18 = null;
            goto L37
        L28:
            r15 = null;
            goto L29
        L23:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L24:
            r11 = null;
            goto L25
        L10:
            r6 = null;
            goto L11
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r3, State r4, State r5, DMEvent r6) {
            d.h.b.o.e(r3, "taskInfo");
            d.h.b.o.e(r5, "newState");
            ILogDepend.Companion r7 = ILogDepend.Companion;
            StringBuilder r0 = new StringBuilder().append("onTaskStateChanged taskInfo:").append(r3.getTaskId()).append(" previousState:");
            if (r4 == null) goto L5;
            String r1 = r4.getStateName();
        L6:
            r7.i("DialogStateManager", r0.append(r1).append(" newState:").append(r5.getStateName()).toString());
            TaskType r8 = r3.getTaskType();
            if (a.f14318a[r8.ordinal()] != 1) goto L10;
            ComplexTaskServiceImpl.access$handleComplexTaskChangedInternal(this.f14317b, r3, r4, r5);
            com.obric.agent.complextask.c.f14330a.a(r3, r4, r5);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    @d.c.b.a.f(b = "ComplexTaskServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.complextask.ComplexTaskServiceImpl$reportAppInstalledListInfo$1")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f14322b;

        h(List<String> r3, d.c.d<? super h> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14322b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f14322b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f14321a != 0) goto L10;
            o.a(r3);
            JSONObject r4 = new JSONObject();
            r4.put("app_intent_app_installed_list_size", this.f14322b.size());
            IAppLog r2 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L8;
            r2.reportToFlow("o_app_intent_app_installed_list", r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ComplexTaskServiceImpl.kt */
    public static final class i implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f14323a;

        i(long r1) {
            this.f14323a = r1;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getQuestionId() != this.f14323a) goto L22;
            ILogDepend.Companion.i(ComplexTaskServiceImpl.TAG, "showProxyCallHistory local action finished");
            boolean r11 = true;
            if (r8 == null) goto L11;
            List<IntentExecutionRecord> r2 = r8.getExecRecords();
            if (r2 == null) goto L11;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L11;
        L12:
            if (r11 == false) goto L18;
            int r12 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getRet();
            ILogDepend.Companion.i(ComplexTaskServiceImpl.TAG, "showProxyCallHistory errorCode " + r12);
            if (r12 != 1100) goto L18;
            IFlowUiIDL r13 = aw.a(aa.b(IFlowUiIDL.class));
            if (r13 == null) goto L18;
            r13.showToast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_call_no_page_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_call_no_page_error")));
        L18:
            IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L22;
            r14.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        L11:
            r11 = false;
        L22:
            return x.f38692a;
        }
    }

    public static /* synthetic */ x lambda$EzPrHAqQ08w26Z55ak0RAQjhfTg(long r0, boolean r2, String r3) {
        return operateQueue$lambda$39(r0, r2, r3);
    }

    public ComplexTaskServiceImpl() {
        this.taskQueueManager = new com.obric.agent.complextask.f();
    }

    public static final /* synthetic */ void access$addEventTaskExecutionRecords(ComplexTaskServiceImpl r0, IMMessage r1, com.obric.assistant.dm.api.statemachine.core.TaskState r2, com.obric.eventkit.task.model.a r3, long r4, int r6) {
        r0.addEventTaskExecutionRecords(r1, r2, r3, r4, r6);
    }

    public static final /* synthetic */ com.obric.agent.complextask.e access$getContentProviderClient$p(ComplexTaskServiceImpl r0) {
        return r0.contentProviderClient;
    }

    public static final /* synthetic */ String access$getFriendlyStopReason(ComplexTaskServiceImpl r0, String r1) {
        return r0.getFriendlyStopReason(r1);
    }

    public static final /* synthetic */ void access$handleComplexTaskChangedInternal(ComplexTaskServiceImpl r0, TaskInfo r1, State r2, State r3) {
        r0.handleComplexTaskChangedInternal(r1, r2, r3);
    }

    public static final /* synthetic */ int access$resolveTaskResultCode(ComplexTaskServiceImpl r0, IMMessage r1, com.obric.assistant.dm.api.statemachine.core.TaskState r2, String r3) {
        return r0.resolveTaskResultCode(r1, r2, r3);
    }

    static {
        Companion = new a(null);
        JSONObject r0 = new JSONObject();
        r0.put("needInsight", true);
        r0.put("needPreference", true);
        r0.put("needPreferenceSummary", true);
        r0.put("preferenceLimit", 50);
        String r1 = r0.toString();
        d.h.b.o.c(r1, "toString(...)");
        USER_MEMORY_QUERY_PARAMS = r1;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void init(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        this.taskQueueManager.a();
        this.taskQueueManager = new com.obric.agent.complextask.f();
        this.context = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.contentProviderClient = new com.obric.agent.complextask.e(r5);
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.registerDMStateListener((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(new g(r5, this), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void notifyStopComplexTask(String r5, String r6) {
        d.h.b.o.e(r6, "reason");
        ILogDepend.Companion.i(TAG, "notifyStopComplexTask messageId: " + r5 + ", reason: " + r6);
        if (d.h.b.o.a(r6, "user_stop_complex_task") == false) goto L8;
        IOmniLabelingUserStopRecorder r4 = (IOmniLabelingUserStopRecorder) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniLabelingUserStopRecorder.class), IOmniLabelingUserStopRecorder.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        ILogDepend.Companion.w(TAG, "omni labeling user stop recorder missing, messageId=" + r5);
        goto L8
    L7:
        r4.onUserStopped(r5, r6);
    L8:
        com.obric.agent.complextask.c.f14330a.c(r5, r6);
        if (r5 == null) goto L14;
        IJobManagerApi r7 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        r7.stopRunningJobs(r5, r6);
        return;
    L15:
        return;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void replyAskUser(String r6, String r7, String r8, Map<Object, Object> r9) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        IDialogStateManager r10 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L16;
        DMState r11 = r10.getCurrentDMState();
        if (r11 == null) goto L16;
        List<State> r12 = r11.getActiveTasks();
        if (r12 == null) goto L16;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Object r2 = r13.next();
        if (ZeusTransformUtils.instanceOf((State) ZeusTransformUtils.preCheckCast(r2, State.class, "com.obric.aiagent.plugin"), ComplexTaskState.Clarify.class) == false) goto L10;
    L15:
        State r14 = (State) ZeusTransformUtils.preCheckCast(r2, State.class, "com.obric.aiagent.plugin");
    L17:
        if (r14 != null) goto L20;
        ILogDepend.Companion.e(TAG, "replyAskUser error!, state is null");
        return;
    L20:
        if (r5 != null) goto L25;
        Map<String, String> r3 = r14.getExtra();
        if (ae.i(r3) == true) goto L26;
        r3 = null;
    L26:
        if (r7 == null) goto L28;
    L38:
        com.obric.agent.network.a.f15206a.a(r6, r7, r8, r3);
        IDialogStateManager r15 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L45;
        r15.replyComplexAskUser(r6, r7, r8, r5);
        return;
    L45:
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r14, ComplexTaskState.Clarify.class) == false) goto L30;
        ComplexTaskState.Clarify r16 = (ComplexTaskState.Clarify) ZeusTransformUtils.preCheckCast(r14, ComplexTaskState.Clarify.class, "com.obric.aiagent.plugin");
    L31:
        if (r16 == null) goto L37;
        TaskInfo r17 = r16.getTaskInfo();
        if (r17 == null) goto L37;
        IMMessage r18 = r17.getMessage();
        if (r18 == null) goto L37;
        r7 = com.obric.agent.im.b.a(r18);
    L37:
        r7 = null;
        goto L38
    L30:
        r16 = null;
        goto L31
    L25:
        r3 = r5;
        goto L26
    L14:
        r2 = null;
    L16:
        r14 = null;
        goto L17
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void reportExecutionStep(IntentAppAction r1) {
        d.h.b.o.e(r1, "result");
        com.obric.agent.network.a.f15206a.a(r1);
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public List<String> getComplexTaskPanelInfoFromPC(int r4) {
        Context r3 = this.context;
        if (r3 == null) goto L14;
        List r5 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.a.f33793a.a(r3, r4).getData(), List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L16;
        RecommendComplexQuery r1 = (RecommendComplexQuery) ZeusTransformUtils.preCheckCast(r8.next(), RecommendComplexQuery.class, "com.obric.aiagent.plugin");
        r7.add(com.obric.eventkit.eventstaskmanager.b.a().toJson(r1));
        goto L8
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L12:
        return p.b();
    L14:
        return p.b();
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public Map<String, String> getExtraForAgentSendMessage() {
        Map<String, String> r8 = getComplexTaskExtras$default(this, false, false, false, false, null, 16, null);
        r8.put("disable_deepthink", "1");
        r8.put("o_force_agent_mode", "2");
        return r8;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public Map<String, String> getContext(DispatchContext r7) {
        return getComplexTaskExtras(true, true, true, true, r7);
    }

    static /* synthetic */ Map getComplexTaskExtras$default(ComplexTaskServiceImpl r6, boolean r7, boolean r8, boolean r9, boolean r10, DispatchContext r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r6.getComplexTaskExtras(r7, r8, r9, r10, r11);
    }

    private final Map<String, String> getComplexTaskExtras(boolean r21, boolean r22, boolean r23, boolean r24, DispatchContext r25) {
        long r5 = SystemClock.elapsedRealtime();
        Map<String, String> r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r21 == false) goto L5;
        long r12 = appendAppListExtras(r7);
    L6:
        if (r22 == false) goto L8;
        d.m<Long, Long> r8 = appendUserMemoryExtras(r7);
    L9:
        long r14 = ((Number) ZeusTransformUtils.preCheckCast(r8.c(), Number.class, "com.obric.aiagent.plugin")).longValue();
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(r8.d(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r23 == false) goto L12;
        long r10 = appendSkillListExtrasIfNeeded(r7, r25);
    L13:
        if (r24 == false) goto L15;
        long r18 = appendLarkCliAuthStateExtras(r7);
    L16:
        ILogDepend.Companion.i(TAG, "getComplexTaskExtras total=" + (SystemClock.elapsedRealtime() - r5) + "ms includeAppList=" + r21 + " includeMemory=" + r22 + " includeSkillList=" + r23 + " includeLarkCliAuthState=" + r24 + " appList=" + r12 + "ms memoryQuery=" + r14 + "ms memoryParse=" + r9 + "ms skillList=" + r10 + "ms larkCliAuthState=" + r18 + "ms extrasSize=" + r7.size());
        ISecureLogDepend.Companion.i(TAG, "getExtraForComplexTaskSendMessage extras " + r7);
        return r7;
    L15:
        r18 = 0;
        goto L16
    L12:
        r10 = 0;
        goto L13
    L8:
        r8 = s.a(0L, 0L);
        goto L9
    L5:
        r12 = 0;
        goto L6
    }

    private final long appendSkillListExtrasIfNeeded(Map<String, String> r17, DispatchContext r18) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        IMAppAction r4 = parseSkillRequest(r18);
        if (r4 != null) goto L5;
        return 0;
    L5:
        IMAppActionExt r7 = r4.getExt();
        if (r7 == null) goto L8;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get(KEY_O_OMNI_ENABLE_SKILL), String.class, "com.obric.aiagent.plugin");
    L10:
        if (d.h.b.o.a(r8, "1") == true) goto L12;
        return 0;
    L12:
        long r5 = SystemClock.elapsedRealtime();
        boolean r9 = true;
        n.a r10 = n.f38560a;     // Catch: Throwable -> L65
        ComplexTaskServiceImpl r0 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        ISkillManagerService r11 = ISkillManagerService.Companion.a();     // Catch: Throwable -> L65
        if (r11 == null) goto L23;
        u<List<com.obric.aiagent.skill.manager.api.e>> r12 = r11.getInstalledSkills();     // Catch: Throwable -> L65
        if (ZeusTransformUtils.instanceOf(r12, u.b.class) == false) goto L19;
        List r13 = (List) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r12, u.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
    L24:
        if (r13 != null) goto L26;
        r13 = p.b();     // Catch: Throwable -> L65
    L26:
        boolean r14 = al.f19195a.a().w();     // Catch: Throwable -> L65
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        Iterator r19 = r15.iterator();     // Catch: Throwable -> L65
    L28:
        if (r19.hasNext() == false) goto L39;
        com.obric.aiagent.skill.manager.api.e r110 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        com.obric.aiagent.skill.manager.api.f r111 = com.obric.aiagent.skill.manager.api.g.f19256a.a(r110, r14);     // Catch: Throwable -> L65
        if (d.h.b.o.a(r111, com.obric.aiagent.skill.manager.api.f.a.f19254a) == false) goto L33;
    L35:
        if (r110 == null) goto L28;
        r16.add(r110);     // Catch: Throwable -> L65
        goto L28
    L33:
        if (ZeusTransformUtils.instanceOf(r111, com.obric.aiagent.skill.manager.api.f.b.class) == false) goto L38;
        ILogDepend.Companion.i(TAG, "Skill list upload skipped reason=" + ((com.obric.aiagent.skill.manager.api.f.b) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.skill.manager.api.f.b.class, "com.obric.aiagent.plugin")).a().a());     // Catch: Throwable -> L65
        r110 = null;
        goto L35
    L38:
        throw new k();     // Catch: Throwable -> L65
    L39:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        JSONArray r112 = new JSONArray();     // Catch: Throwable -> L65
        Map r113 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        Iterator r114 = ((Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L65
    L41:
        if (r114.hasNext() == false) goto L63;
        com.obric.aiagent.skill.manager.api.e r115 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r114.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L65
        r116.put("skill_id", r115.a());     // Catch: Throwable -> L65
        r116.put("display_name", r115.b());     // Catch: Throwable -> L65
        r116.put("description", r115.c());     // Catch: Throwable -> L65
        String r117 = r115.i().a();     // Catch: Throwable -> L65
        if (r117 != null) goto L45;
        r117 = "";
    L45:
        r116.put("security_scan_task_id", r117);     // Catch: Throwable -> L65
        r116.put("version", r115.j());     // Catch: Throwable -> L65
        if (d.h.b.o.a(r115.g(), aq.a.f19212a) == false) goto L62;
        com.obric.aiagent.skill.manager.api.a r21 = r115.h();     // Catch: Throwable -> L65
        if (r21 == null) goto L54;
        String r22 = r21.a();     // Catch: Throwable -> L65
        if (r22 == null) goto L54;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L54;
    L55:
        if (r22 == null) goto L62;
        Object r118 = r113.get(r22);     // Catch: Throwable -> L65
        if (r118 != null) goto L59;
        r118 = r0.resolveAppLabel(r22);     // Catch: Throwable -> L65
        r113.put(r22, r118);     // Catch: Throwable -> L65
    L59:
        String r23 = (String) ZeusTransformUtils.preCheckCast(r118, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L65
        if (r23 == null) goto L62;
        r116.put(IBdInstall.PARAM_APP_NAME, r23);     // Catch: Throwable -> L65
    L54:
        r22 = null;
    L62:
        r112.put(r116);     // Catch: Throwable -> L65
        goto L41
    L63:
        Object r1 = n.f(s.a(r20, r112.toString()));     // Catch: Throwable -> L65
    L67:
        Throwable r24 = n.c(r1);
        if (r24 == null) goto L71;
        ILogDepend.Companion.e(TAG, "append skill list failed", r24);
    L71:
        if (n.b(r1) == false) goto L73;
        r1 = null;
    L73:
        d.m r3 = (d.m) ZeusTransformUtils.preCheckCast(r1, d.m.class, "com.obric.aiagent.plugin");
        long r25 = SystemClock.elapsedRealtime() - r5;
        if (r3 == null) goto L76;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r3.c(), List.class, "com.obric.aiagent.plugin");
        Object r26 = r3.d();
        d.h.b.o.c(r26, "component2(...)");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.aiagent.plugin");
        r2.put(KEY_O_SKILL_LIST, r27);
        ILogDepend.Companion.i(TAG, "append skill list size=" + r6.size() + ", jsonLength=" + r27.length() + ", costMs=" + r25);
    L76:
        com.obric.agent.intents.skill.e.a r119 = com.obric.agent.intents.skill.e.a.f15181a;
        IMAppActionExt r28 = r4.getExt();
        if (r28 == null) goto L79;
        String r120 = (String) ZeusTransformUtils.preCheckCast(r28.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L80:
        if (r3 != null) goto L83;
        r9 = false;
    L83:
        boolean r121 = r9;
        if (r3 == null) goto L86;
        List<com.obric.aiagent.skill.manager.api.e> r29 = (List) ZeusTransformUtils.preCheckCast(r3.a(), List.class, "com.obric.aiagent.plugin");
    L87:
        if (r29 != null) goto L89;
        r29 = p.b();
    L89:
        r119.a(r120, r25, r121, r29);
        return r25;
    L86:
        r29 = null;
        goto L87
    L79:
        r120 = null;
        goto L80
    L19:
        if (ZeusTransformUtils.instanceOf(r12, u.a.class) == false) goto L22;
        r13 = p.b();     // Catch: Throwable -> L65
        goto L24
    L22:
        throw new k();     // Catch: Throwable -> L65
    L23:
        r13 = null;
    L65:
        th = move-exception;
        n.a r30 = n.f38560a;
        r1 = n.f(o.a(th));
        goto L67
    L8:
        r8 = null;
        goto L10
    }

    private final String resolveAppLabel(String r7) {
        Context r0 = this.context;
        if (r0 != null) goto L5;
        r0 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L5:
        PackageManager r1 = r0.getPackageManager();
        Object r2 = null;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L12
        ComplexTaskServiceImpl r6 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        ApplicationInfo r8 = r1.getApplicationInfo(r7, 0);     // Catch: Throwable -> L12
        d.h.b.o.c(r8, "getApplicationInfo(...)");     // Catch: Throwable -> L12
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1.getApplicationLabel(r8).toString(), CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L12
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r9 = null;
    L10:
        Object r10 = n.f(r9);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = n.c(r10);
        if (r4 == null) goto L18;
        ILogDepend.Companion.w(TAG, "resolve app name failed, package=" + r7 + ": " + r4.getMessage());
    L18:
        if (n.b(r10) == true) goto L22;
        r2 = r10;
    L22:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L12:
        th = move-exception;
        n.a r5 = n.f38560a;
        r10 = n.f(o.a(th));
        goto L14
    }

    private final long appendLarkCliAuthStateExtras(Map<String, String> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        long r2 = SystemClock.elapsedRealtime();
        boolean r0 = true;
        Object r4 = null;
        n.a r5 = n.f38560a;     // Catch: Throwable -> L5
        ComplexTaskServiceImpl r9 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r12 = n.f((String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new e(null), m.class, "com.obric.aiagent.plugin"), 1, null), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = n.c(r12);
        if (r6 == null) goto L11;
        ILogDepend.Companion.e(TAG, "append lark cli auth state failed", r6);
    L11:
        if (n.b(r12) == true) goto L14;
        r4 = r12;
    L14:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L17;
    L20:
        if (r0 == true) goto L23;
        r11.put(KEY_O_LARK_CLI_AUTH_STATE, r13);
        ILogDepend.Companion.i(TAG, "append lark cli auth state jsonLength=" + r13.length() + ", costMs=" + (SystemClock.elapsedRealtime() - r2));
    L23:
        return SystemClock.elapsedRealtime() - r2;
    L17:
        if (d.o.o.d(r1) == true) goto L20;
        r0 = false;
    L5:
        th = move-exception;
        n.a r7 = n.f38560a;
        r12 = n.f(o.a(th));
        goto L7
    }

    private final IMAppAction parseSkillRequest(DispatchContext r6) {
        Object r0 = null;
        if (r6 == null) goto L22;
        Map<String, String> r7 = r6.getExt();
        if (r7 == null) goto L22;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get(Ext.KEY_REQUEST), String.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L22;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L11
        ComplexTaskServiceImpl r5 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r9 = n.f((IMAppAction) ZeusTransformUtils.preCheckCast(com.obric.eventkit.eventstaskmanager.b.a().fromJson(r8, IMAppAction.class), IMAppAction.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L13:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L17;
        ILogDepend.Companion.e(TAG, "parse skill request failed", r10);
    L17:
        if (n.b(r9) == true) goto L21;
        r0 = r9;
    L21:
        return (IMAppAction) ZeusTransformUtils.preCheckCast(r0, IMAppAction.class, "com.obric.aiagent.plugin");
    L11:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(o.a(th));
    L22:
        return null;
    }

    private final long appendAppListExtras(Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        long r0 = SystemClock.elapsedRealtime();
        getAppNameInstalledListExt(r5);
        long r3 = SystemClock.elapsedRealtime() - r0;
        ILogDepend.Companion.i(TAG, "getComplexTaskExtras appList cost=" + r3 + "ms");
        return r3;
    }

    private final d.m<Long, Long> appendUserMemoryExtras(Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Context r0 = this.context;
        long r3 = 0;
        if (r0 != null) goto L6;
        ComplexTaskServiceImpl r11 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "getComplexTaskExtras skip memory query because context is null");
        return s.a(0L, 0L);
    L6:
        long r5 = SystemClock.elapsedRealtime();
        MemoryResponse<String> r1 = com.obric.memorydata.sdk.a.f33793a.b(r0, USER_MEMORY_QUERY_PARAMS);
        long r7 = SystemClock.elapsedRealtime() - r5;
        ILogDepend.Companion r6 = ILogDepend.Companion;
        StringBuilder r8 = new StringBuilder().append("getComplexTaskExtras queryUserInsightAndPreference cost=").append(r7).append("ms hasData=");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r1.getData(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L9;
    L12:
        boolean r10 = true;
    L13:
        r6.i(TAG, r8.append(!r10).toString());
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getData(), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L17;
        r3 = appendUserMemoryData(r13, r2);
    L17:
        return s.a(Long.valueOf(r7), Long.valueOf(r3));
    L9:
        if (r9.length() == 0) goto L12;
        r10 = false;
        goto L13
    }

    private final long appendUserMemoryData(Map<String, String> r8, String r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        long r3 = SystemClock.elapsedRealtime();
        JSONObject r1 = new JSONObject(r9);     // Catch: Exception -> L16
        String r11 = r1.optString("insight", "");     // Catch: Exception -> L16
        String r7 = r1.optString("preference", "");     // Catch: Exception -> L16
        d.h.b.o.a(r11);     // Catch: Exception -> L16
        boolean r5 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        r10.put("o_user_insight", r11);     // Catch: Exception -> L16
    L9:
        d.h.b.o.a(r7);     // Catch: Exception -> L16
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L13;
        r5 = false;
    L13:
        if (r5 == false) goto L18;
        r10.put("o_user_preference", r7);     // Catch: Exception -> L16
    L18:
        long r12 = SystemClock.elapsedRealtime() - r3;
        ILogDepend.Companion.i(TAG, "getComplexTaskExtras parseUserInsightAndPreference cost=" + r12 + "ms");
        return r12;
    L6:
        r2 = false;
    L16:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parse queryUserInsightAndPreference data failed: " + e.getMessage());
        goto L18
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void addComplexTaskExt(String r9) {
        d.h.b.o.e(r9, "questionId");
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new c(r9, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void reportChangeTransitionFailed(String r1, String r2) {
        d.h.b.o.e(r1, "fromState");
        d.h.b.o.e(r2, "toState");
        com.obric.agent.complextask.c.f14330a.a(r1, r2);
    }

    private final void handleComplexTaskChangedInternal(TaskInfo r7, State r8, State r9) {
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("handleComplexTaskInternal, previousState: ");
        String r2 = null;
        if (r8 == null) goto L5;
        String r3 = r8.getStateName();
    L6:
        r0.i(TAG, r1.append(r3).append(", newState: ").append(r9.getStateName()).append(", taskInfo: ").append(r7.getTaskId()).toString());
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.Terminated.class) == false) goto L10;
        handleComplexTaskTerminatedInternal(r7);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.Clarify.class) == false) goto L13;
        refreshComplexTaskAppIntentState(r7);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.Queueing.class) == false) goto L41;
        if (ZeusTransformUtils.instanceOf(r8, ComplexTaskState.Idle.class) == false) goto L61;
        IDialogStateManager r6 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        DMState r10 = r6.getCurrentDMState();
        if (r10 == null) goto L29;
        List<State> r11 = r10.getActiveTasks();
        if (r11 == null) goto L29;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L24:
        if (r14.hasNext() == false) goto L28;
        Object r4 = r14.next();
        if (d.o.o.b(((State) ZeusTransformUtils.preCheckCast(r4, State.class, "com.obric.aiagent.plugin")).getStateName(), "ComplexTask", false, 2, null) == false) goto L24;
        r13.add(r4);
        goto L24
    L28:
        Integer r15 = Integer.valueOf(((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin")).size());
    L30:
        if (r15 != null) goto L33;
        return;
    L33:
        if (r15.intValue() != 0) goto L62;
        Map<String, String> r16 = r7.getExt();
        if (r16 == null) goto L37;
        r2 = (String) ZeusTransformUtils.preCheckCast(r16.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L37:
        JSONObject r17 = new JSONObject();
        r17.put("o_omni_task_id", r2);
        IAppLog r18 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L63;
        r18.reportToFlow("o_omni_task_queue_error", r17);
        return;
    L63:
        return;
    L62:
        return;
    L29:
        r15 = null;
        goto L30
    L61:
        return;
    L41:
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.ClarifyAck.class) == false) goto L43;
        return;
    L43:
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.Idle.class) == false) goto L51;
        if (ZeusTransformUtils.instanceOf(r8, ComplexTaskState.Idle.class) == true) goto L66;
        IMMessage r19 = r7.getMessage();
        if (r19 == null) goto L49;
        r2 = r19.getMessageId();
    L49:
        notifyStopComplexTask(r2, "complex_task_completed");
        return;
    L66:
        return;
    L51:
        if (ZeusTransformUtils.instanceOf(r9, ComplexTaskState.Thinking.class) == false) goto L68;
        ZeusTransformUtils.instanceOf(r8, ComplexTaskState.Clarify.class);
        return;
    L68:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void handleComplexTaskTerminatedInternal(TaskInfo r4) {
        ILogDepend.Companion.i(TAG, "handleComplexTaskTerminatedInternal, taskInfo: " + r4.getTaskId());
        IMMessage r5 = r4.getMessage();
        if (r5 == null) goto L5;
        String r6 = r5.getMessageId();
    L6:
        notifyStopComplexTask(r6, "system_terminate");
        return;
    L5:
        r6 = null;
        goto L6
    }

    private final void refreshComplexTaskAppIntentState(TaskInfo r6) {
        IMMessage r0 = r6.getMessage();
        boolean r1 = false;
        if (r0 == null) goto L14;
        String r2 = r0.getMessageId();
        if (r2 == null) goto L14;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L14;
    L15:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L18;
    L19:
        r1 = true;
    L20:
        if (r1 == false) goto L23;
        ILogDepend.Companion.w(TAG, "refreshComplexTaskAppIntentState ignored, messageId is empty, taskInfo: " + r6.getTaskId());
        return;
    L23:
        q.f15713a.a(r2, true);
        return;
    L18:
        if (r5.length() != 0) goto L20;
    L9:
        r4 = false;
    L14:
        r2 = parseMessageIdFromTaskId(r6.getTaskId().getValue());
        goto L15
    }

    private final String parseMessageIdFromTaskId(String r3) {
        d.o.i r2 = new d.o.k("task_(.+?)_.*").c((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L9;
        d.o.g r4 = r2.c();
        if (r4 == null) goto L9;
        d.o.f r5 = r4.a(1);
        if (r5 == null) goto L9;
        return r5.a();
    L9:
        return null;
    }

    private final void handleComplexTaskTTSInternal(TaskInfo r3, State r4) {
        ILogDepend.Companion.i(TAG, "handleComplexTaskTTSInternal, taskInfo: " + r3.getTaskId());
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.getExtra().get("message_id_for_tts"), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        IFlowVoiceInteractionIDL r5 = ax.a(aa.b(IFlowVoiceInteractionIDL.class));
        if (r5 == null) goto L9;
        r5.replayMessageTts(r2);
        return;
    L9:
        return;
    }

    private final void handleComplexTaskClarifyInternal(TaskInfo r29, State r30) {
        ILogDepend.Companion.i(TAG, "handleComplexTaskClarifyInternal, taskInfo: " + r29.getTaskId());
        String r11 = (String) ZeusTransformUtils.preCheckCast(r30.getExtra().get("clarify_message_content"), String.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L35;
        IFlowVoiceInteractionIDL r0 = ax.a(aa.b(IFlowVoiceInteractionIDL.class));
        String r1 = null;
        if (r0 == null) goto L7;
        Boolean r2 = Boolean.valueOf(r0.isInRealtimeCalling());
    L8:
        ILogDepend.Companion r3 = ILogDepend.Companion;
        StringBuilder r4 = new StringBuilder().append("handleComplexTaskClarifyInternal, replay tts, and realtime calling status:").append(r2).append(", msgId: ");
        IMMessage r5 = r29.getMessage();
        if (r5 == null) goto L11;
        String r6 = r5.getMessageId();
    L12:
        StringBuilder r7 = r4.append(r6).append(", cvsId: ");
        IMMessage r8 = r29.getMessage();
        if (r8 == null) goto L15;
        r1 = r8.getConversationId();
    L15:
        r3.i(TAG, r7.append(r1).toString());
        if (d.h.b.o.a(r2, false) == false) goto L36;
        IFlowVoiceInteractionIDL r9 = ax.a(aa.b(IFlowVoiceInteractionIDL.class));
        if (r9 == null) goto L37;
        IMMessage r10 = r29.getMessage();
        if (r10 == null) goto L25;
        String r12 = r10.getConversationId();
        if (r12 == null) goto L25;
        String r13 = r12;
    L26:
        IMMessage r14 = r29.getMessage();
        if (r14 == null) goto L32;
        String r15 = r14.getMessageId();
        if (r15 == null) goto L32;
        String r22 = r15;
    L33:
        r9.readContentByMessage(new IMMessage(r13, null, 0, 0, 0, 0, false, r11, null, ao.a(new d.m[]{s.a("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK), s.a("o_task_state", "clarify_complex_task")}), "complex_task_ask_user_tts", "complex_task_ask_user_tts", 0, 0, null, null, r22, null, 0, 455038, null));
        return;
    L32:
        r22 = "";
    L25:
        r13 = "";
        goto L26
    L37:
        return;
    L36:
        return;
    L11:
        r6 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    private final void getAppNameInstalledListExt(Map<String, String> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Context r0 = this.context;
        if (r0 != null) goto L5;
        ComplexTaskServiceImpl r1 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "context is null, refreshAppInfoCache error!");
    L8:
        boolean r2 = isOEMSupportAppListPermission();
        if (checkPermission(this.context, "com.android.permission.GET_INSTALLED_APPS", "com.larus.nova") == true) goto L13;
        if (r2 == false) goto L13;
        boolean r3 = false;
    L14:
        IIntentTraceService r4 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L17;
        r4.reportPermissionGranted("com.android.permission.GET_INSTALLED_APPS", "get_app_installed_list", r3, null);
    L17:
        if (r3 == false) goto L24;
        Context r5 = this.context;
        if (r5 == null) goto L25;
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new f(r5, null), m.class, "com.obric.aiagent.plugin"), 1, null), List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L26;
        reportAppInstalledListInfo(r6);
        r13.put("o_app_list", p.a((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L13:
        r3 = true;
        goto L14
    L5:
        if (PackageInfoCache.f18569a.a(r0) == true) goto L8;
        ILogDepend.Companion.e(TAG, "PackageInfoCache is not available, do refresh");
        PackageInfoCache.f18569a.b(r0);
        goto L8
    }

    private final boolean checkPermission(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return false;
    L5:
        int r7 = r3.getPackageManager().checkPermission(r5, r6);
        ILogDepend.Companion.i(TAG, "checkPermission, permission: " + r5 + ", packageName: " + r6 + ", ret: " + r7);
        if (r7 != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean isOEMSupportAppListPermission() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L13
        Context r6 = this.context;     // Catch: Throwable -> L13
        if (r6 == null) goto L6;
        ContentResolver r7 = r6.getContentResolver();     // Catch: Throwable -> L13
    L7:
        boolean r3 = true;
        if (Settings.Secure.getInt(r7, OEM_INSTALLED_APPS_RUNTIME_PERMISSION_ENABLE, 0) == 1) goto L11;
        r3 = false;
    L11:
        ILogDepend.Companion.i(TAG, "isOEMSupportAppListPermission ret: " + r3);     // Catch: Throwable -> L13
        Object r8 = n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L13
    L15:
        Throwable r4 = n.c(r8);
        if (r4 == null) goto L19;
        ILogDepend.Companion.w(TAG, "isOEMSupportAppListPermission failed: " + r4.getMessage(), r4);
    L19:
        if (n.b(r8) == false) goto L22;
        r8 = false;
    L22:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        r7 = null;
    L13:
        th = move-exception;
        n.a r5 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L15
    }

    private final void reportAppInstalledListInfo(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new h(r7, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final List<String> getAppNameInstalledList(boolean r5) {
        List<PackageInfoCache.a> r0 = PackageInfoCache.f18569a.b();
        if (r5 == true) goto L5;
    L21:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r4, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r4.iterator();
    L23:
        if (r7.hasNext() == false) goto L26;
        r6.add(String.valueOf(((PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r7.next(), PackageInfoCache.a.class, "com.obric.aiagent.plugin")).b()));
        goto L23
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
    L5:
        if (this.context == null) goto L21;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L15;
        Object r1 = r10.next();
        if (((PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r1, PackageInfoCache.a.class, "com.obric.aiagent.plugin")).c() == null) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        r9.add(r1);
        goto L8
    L12:
        r3 = false;
        goto L13
    L15:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L17:
        if (r13.hasNext() == false) goto L20;
        r12.add(String.valueOf(((PackageInfoCache.a) ZeusTransformUtils.preCheckCast(r13.next(), PackageInfoCache.a.class, "com.obric.aiagent.plugin")).b()));
        goto L17
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void showProxyCallHistory(String r9) {
        long r6 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        com.obric.agent.utils.b.f15994a.a(new BasePhoneOpenPageIntent().getName(), com.obric.agent.utils.b.f15994a.a(new PhoneOpenPageParams(r9)), null, r6);
        i r8 = new i(r6);
        IAppIntentFeedback r10 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L6;
        r10.addLocalActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(r8, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void addEventTaskExecutionRecords(IMMessage r14, com.obric.assistant.dm.api.statemachine.core.TaskState r15, com.obric.eventkit.task.model.a r16, long r17, int r19) {
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new d(r14, r15, r16, this, r19, r17, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final String getFriendlyStopReason(String r4) {
        if (r4 != null) goto L5;
    L30:
        String r5 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.task_execution_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "task_execution_failed"));
        d.h.b.o.c(r5, "getString(...)");
        return r5;
    L5:
        switch(r4.hashCode()) {
            case -1792184895: goto L27;
            case -1226589444: goto L23;
            case 503000675: goto L19;
            case 770760647: goto L15;
            case 1538716985: goto L12;
            case 1941444800: goto L8;
            default: goto L30;
        };
    L8:
        if (r4.equals("Message DELETED") == false) goto L30;
        String r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stop_reason_query_deleted, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stop_reason_query_deleted"));
        d.h.b.o.c(r6, "getString(...)");
        return r6;
    L12:
        if (r4.equals("RECEIVE_FAILED") == false) goto L30;
    L17:
        String r7 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stop_reason_receive_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stop_reason_receive_failed"));
        d.h.b.o.c(r7, "getString(...)");
        return r7;
    L15:
        if (r4.equals("RECEIVE_INTERRUPT") == true) goto L17;
    L19:
        if (r4.equals("interrupt") == false) goto L30;
        String r8 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.term_type_user_termination, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_user_termination"));
        d.h.b.o.c(r8, "getString(...)");
        return r8;
    L23:
        if (r4.equals("addition") == false) goto L30;
        String r9 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_stop_reason_user_addition, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_stop_reason_user_addition"));
        d.h.b.o.c(r9, "getString(...)");
        return r9;
    L27:
        if (r4.equals("omni_task_client_timeout") == false) goto L30;
        String r10 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_exe_timeout, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_exe_timeout"));
        d.h.b.o.c(r10, "getString(...)");
        return r10;
    }

    private final int resolveTaskResultCode(IMMessage r8, com.obric.assistant.dm.api.statemachine.core.TaskState r9, String r10) {
        String r0 = null;
        if (r8 == null) goto L7;
        Map<String, String> r1 = r8.getExt();
        if (r1 == null) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_complete_result"), String.class, "com.obric.aiagent.plugin");
    L9:
        if (r2 == null) goto L28;
        int r5 = r2.hashCode();
        if (r5 == (-1867169789)) goto L26;
        if (r5 == (-1367724422)) goto L22;
        if (r5 != 3135262) goto L28;
        if (r2.equals("fail") == false) goto L28;
        return 3;
    L22:
        if (r2.equals("cancel") == false) goto L28;
        return 2;
    L26:
        if (r2.equals("success") == false) goto L28;
        return 1;
    L28:
        if (r8 == null) goto L33;
        Map<String, String> r11 = r8.getExt();
        if (r11 == null) goto L33;
        r0 = (String) ZeusTransformUtils.preCheckCast(r11.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
    L33:
        if (d.h.b.o.a(r0, "cancel_complex_task") == false) goto L36;
        return 2;
    L36:
        if (d.h.b.o.a(r10, "1") == false) goto L39;
    L40:
        return 3;
    L39:
        if (r9.isIdle() == false) goto L40;
        return 1;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void onReceiveMessage(String r2, IMMessage r3) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, "message");
        com.obric.agent.complextask.c.f14330a.a(TaskId.Companion.a(r2), r3);
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void playTts(String r28, String r29, String r30, String r31) {
        d.h.b.o.e(r28, "questionId");
        d.h.b.o.e(r30, "content");
        d.h.b.o.e(r31, DBHelper.BATTERY_COL_SCENE);
        IFlowVoiceInteractionIDL r1 = ax.a(aa.b(IFlowVoiceInteractionIDL.class));
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isInRealtimeCalling());
    L6:
        ILogDepend.Companion.i(TAG, r31 + " playTts tts, and realtime calling status:" + r2 + ", msgId: " + r28 + ", cvsId: " + r29);
        if (d.h.b.o.a(r2, false) == false) goto L22;
        IFlowVoiceInteractionIDL r3 = ax.a(aa.b(IFlowVoiceInteractionIDL.class));
        if (r3 == null) goto L23;
        String r4 = "";
        if (r29 != null) goto L13;
        String r19 = "";
    L14:
        d.m[] r0 = new d.m[2];
        r0[0] = s.a("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI);
        if (d.h.b.o.a(r31, "complex_task_oauto_clarify_tts") == false) goto L18;
        r4 = "clarify_auto_gui";
    L20:
        r0[1] = s.a("o_task_state", r4);
        r3.readContentByMessage(new IMMessage(r19, null, 0, 0, 0, 0, false, r30, null, ao.a(r0), r31, r31, 0, 0, null, null, r28, null, 0, 455038, null));
        return;
    L18:
        if (d.h.b.o.a(r31, "complex_task_oauto_call_user_tts") == false) goto L20;
        r4 = "calluser_auto_gui";
        goto L20
    L13:
        r19 = r29;
        goto L14
    L23:
        return;
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void requestStateChanged(String r11, TaskStateInfo r12, ITaskStateChangeCallback r13, long r14) {
        ITaskStateChangeCallback r9 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r13, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "requestStateChanged state:" + r12 + ", " + r11);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        String r4 = r12.getContent();
        Map<String, String> r7 = r12.getExt();
        int r15 = b.f14304a[r12.getState().ordinal()];
        if (r15 != 1) goto L10;
        userTakeOver(r11, r4, r14, r7, sceneOr(r7, "begin"), r9);
        return;
    L10:
        if (r15 != 2) goto L12;
        userTakeOver(r11, r4, r14, r7, sceneOr(r7, "end"), r9);
        return;
    L12:
        if (r15 != 3) goto L14;
        userTakeOver(r11, r4, r14, r7, "call_user", r9);
        return;
    L14:
        if (r15 != 4) goto L16;
        userTakeOver(r11, r4, r14, r7, "clarify", r9);
        return;
    L16:
        if (r15 != 5) goto L36;
        if (r7 == null) goto L29;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L30;
        IFlowNetworkIDL r16 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
        if (r16 == null) goto L31;
        r16.notifyStopComplexTaskByHttp(Long.parseLong(r10));
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void operateQueue(String r6) {
        d.h.b.o.e(r6, "data");
        final long r2 = SystemClock.elapsedRealtime();
        n.a r4 = n.f38560a;     // Catch: Throwable -> L5
        ComplexTaskServiceImpl r5 = (ComplexTaskServiceImpl) ZeusTransformUtils.preCheckCast(this, ComplexTaskServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r7 = n.f(new JSONObject(r6).optString("data"));     // Catch: Throwable -> L5
    L8:
        if (n.b(r7) == false) goto L10;
        r7 = null;
    L10:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L20;
        ISecureLogDepend.Companion.e(TAG, "operateQueue data error: " + r6);
        return;
    L20:
        IIntentActionService r9 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L26;
        r9.notifyUserOperateQueue(r8, new $$Lambda$ComplexTaskServiceImpl$EzPrHAqQ08w26Z55ak0RAQjhfTg(r2));
        return;
    L26:
        return;
    L13:
        if (r1.length() == 0) goto L16;
        r3 = false;
    L5:
        th = move-exception;
        n.a r10 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L8
    }

    private static final x operateQueue$lambda$39(long r3, boolean r5, String r6) {
        d.h.b.o.e(r6, "msg");
        ILogDepend.Companion.i(TAG, "operateQueue: result is : " + r5 + ", " + r6 + ", duration: " + (SystemClock.elapsedRealtime() - r3));
        return x.f38692a;
    }

    private final String sceneOr(Map<String, String> r2, String r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.get(TAKE_OVER_SCENE_KEY), String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return r3;
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L13;
        return r3;
    L13:
        return r4;
    L14:
        return r3;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public com.obric.agent.complextask.d getOmniRunningState(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        com.obric.agent.complextask.e r1 = this.contentProviderClient;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r2);
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public void clearAllOmniTask(Map<String, String> r4) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "extra");
        ILogDepend.Companion.i(TAG, "clearAllOmniTask");
        IDialogStateManager r5 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.clearAllOmniTask(r3);
        return;
    }

    @Override // com.obric.agent.complextask.IComplexTaskService
    public boolean sendQuery(String r10, boolean r11, String r12, String r13, String r14, Map<String, String> r15) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "sendQuery query=" + r10 + ", forceOmni=" + r11 + ", instructionType=" + r12 + ", instructionEntry=" + r13 + ", expandState=" + r14);
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L5;
    L8:
        boolean r17 = true;
    L9:
        if (r17 == true) goto L41;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L13;
    L16:
        boolean r19 = true;
    L17:
        if (r19 == true) goto L41;
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L21;
    L24:
        boolean r111 = true;
    L25:
        if (r111 == true) goto L41;
        Map r8 = ao.b(new d.m[]{s.a("o_omni_instruction_type", r12), s.a("o_instruction_entry", r13)});
        if (r11 == false) goto L30;
        r8.put("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
    L30:
        if (r9 == null) goto L37;
        Iterator r20 = r9.entrySet().iterator();
    L33:
        if (r20.hasNext() == false) goto L37;
        Map.Entry r112 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.getKey(), String.class, "com.obric.aiagent.plugin");
        String r114 = (String) ZeusTransformUtils.preCheckCast(r112.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r8.containsKey(r113) == true) goto L33;
        r8.put(r113, r114);
    L37:
        IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r3 == null) goto L40;
        r3.sendMessageWithExtra(null, r10, "obric_active_agent_query_task", "obric_active_agent_query_task", r8);
    L40:
        return true;
    L21:
        if (r110.length() == 0) goto L24;
        r111 = false;
        goto L25
    L13:
        if (r18.length() == 0) goto L16;
        r19 = false;
    L41:
        ILogDepend.Companion.e(TAG, "sendQuery missing required arg, abort");
        return false;
    L5:
        if (r16.length() == 0) goto L8;
        r17 = false;
        goto L9
    }

    private final void userTakeOver(String r10, String r11, long r12, Map<String, String> r14, String r15, ITaskStateChangeCallback r16) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        ITaskStateChangeCallback r7 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r16, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ((!d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.aiagent.plugin"), TAKE_OVER_SCENE_KEY)) == false) goto L6;
        r3.put(r4.getKey(), r4.getValue());
        goto L6
    L10:
        Map<String, String> r5 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin");
    L13:
        if (d.o.o.b(r15, TAKE_OVER_OCCUPY_SCENE_PREFIX, false, 2, null) == false) goto L16;
        ILogDepend.Companion.i(TAG, "OccupyTakeOverTrace userTakeOver request, messageId=" + r10 + ", scene=" + r15 + ", ext=" + r5);
    L16:
        this.taskQueueManager.a(r10, r11, r12, r5, r15, r7);
        return;
    L11:
        r5 = null;
        goto L13
    }
}
