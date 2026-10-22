package com.obric.autoaction.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autoaction.app.launcherpage.module.datasource.g;
import com.obric.autoaction.presentation.FloatingWindowServiceImpl;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.cocreation.OmniLabelingTaskTriggerExtraKeys;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.c.i;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.k;
import d.n;
import d.o;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoActionIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionIntent extends BaseSystemAutoActionIntent {
    public static final String CLARIFY_TIMEOUT = "clarify_timeout";
    public static final a Companion = null;
    public static final String DIRECT_SEND_INTERRUPT = "direct_send_interrupt";
    private static final int EVENT_TASK_SOURCE_AUTO = 2;
    public static final String SYSTEM_TERMINATE = "system_terminate";
    public static final String TAG = "AutoActionIntent";
    public static final String USER_STOP_COMPLEX_TASK = "user_stop_complex_task";

    /* JADX INFO: compiled from: AutoActionIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionIntent.kt */
    @d.c.b.a.f(b = "AutoActionIntent.kt", c = {357}, d = "invokeSuspend", e = "com.obric.autoaction.intent.AutoActionIntent$addTaskConflictRecord$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f24686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f24687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f24688d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f24689e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        b(boolean r3, Integer r4, Context r5, int r6, String r7, String r8, d.c.d<? super b> r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24686b = r3;
            this.f24687c = r4;
            this.f24688d = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
            this.f24689e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f24686b, this.f24687c, this.f24688d, this.f24689e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f24685a;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            o.a(r25);     // Catch: Exception -> L7
            Object r0 = r25;
        L24:
            List r3 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        L28:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            o.a(r25);
            int r5 = 0;
            if (this.f24686b == false) goto L15;
            int r4 = com.obric.autogui.common.b.a.f29000a.a(0, 2, true);     // Catch: Exception -> L7
        L16:
            IEventTaskRecordApi r6 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            if (r6 == null) goto L28;
            Integer r7 = this.f24687c;     // Catch: Exception -> L7
            if (r7 == null) goto L21;
            r5 = r7.intValue();     // Catch: Exception -> L7
        L21:
            List<EventTaskExecutionRecord> r8 = p.a(new EventTaskExecutionRecord(0, r5, this.f24689e, this.f, this.g, System.currentTimeMillis(), 1, 3, this.f24688d.getString(ZeusTransformUtils.mapRes(R.string.appintent_has_running_task_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_has_running_task_tips")), ao.a(s.a("taskFlag", String.valueOf(r4))), null, DownloadErrorCode.ERROR_ANOTHER_TASK_EXIST, null));     // Catch: Exception -> L7
            d.c.d<? super List<EventTaskExecutionRecord>> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
            this.f24685a = 1;     // Catch: Exception -> L7
            r0 = r6.addExecutionRecords(r8, r9);     // Catch: Exception -> L7
            if (r0 != r1) goto L24;
            return r1;
        L15:
            r4 = 0;
        L7:
            e = move-exception;
            Loog.INSTANCE.e(AutoActionIntent.TAG, "addTaskRecord error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L28
        }
    }

    /* JADX INFO: compiled from: AutoActionIntent.kt */
    @d.c.b.a.f(b = "AutoActionIntent.kt", c = {548}, d = "invokeSuspend", e = "com.obric.autoaction.intent.AutoActionIntent$cancelTask$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f24691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f24692c;

        c(int r3, String r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24691b = r3;
            this.f24692c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f24691b, this.f24692c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24690a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            if (this.f24691b != 2) goto L15;
            IAutoActionAgentApi r10 = (IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24690a = 1;
            if (IAutoActionAgentApi.DefaultImpls.userTerminateQuery$default(r10, null, r2, 1, null) != r0) goto L14;
            return r0;
        L15:
            IAutoActionAgentApi.DefaultImpls.systemTerminateQuery$default((IAutoActionAgentApi) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE, IAutoActionAgentApi.class, "com.obric.aiagent.plugin"), null, this.f24692c, this.f24691b, null, null, 24, null);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: AutoActionIntent.kt */
    @d.c.b.a.f(b = "AutoActionIntent.kt", c = {112, IdlErrors.E_RejectInferDeviceOverheat, 198}, d = "doAction", e = "com.obric.autoaction.intent.AutoActionIntent")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f24694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f24695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f24696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f24697e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Object p;
        Object q;
        long r;
        long s;
        int t;
        int u;
        /* synthetic */ Object v;
        final /* synthetic */ AutoActionIntent w;
        int x;

        d(AutoActionIntent r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.w = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.v = r3;
            this.x |= Integer.MIN_VALUE;
            return this.w.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionIntent.kt */
    public static final class e implements com.obric.autoaction.intent.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.f<String> f24698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<d.m<String, Boolean>> f24699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<Integer> f24700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.d f24701d;

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class a implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f24702a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f24703b;

            a(String r1, String r2) {
                this.f24702a = r1;
                this.f24703b = r2;
            }

            public final String a() {
                return "onError " + this.f24702a + ' ' + this.f24703b;
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class b implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f24704a = null;

            static {
                f24704a = new b();
            }

            b() {
            }

            public final String a() {
                return "onError";
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class c implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f24705a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f24706b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f24707c;

            c(String r1, String r2, boolean r3) {
                this.f24705a = r1;
                this.f24706b = r2;
                this.f24707c = r3;
            }

            public final String a() {
                return "onResult " + this.f24705a + ' ' + this.f24706b + ' ' + this.f24707c;
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class d implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f24708a;

            d(boolean r1) {
                this.f24708a = r1;
            }

            public final String a() {
                return "onResult " + this.f24708a;
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        e(z.f<String> r3, d.c.d<? super d.m<String, Boolean>> r4, z.f<Integer> r5, z.d r6) {
            d.c.d<d.m<String, Boolean>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24698a = r3;
            this.f24699b = r7;
            this.f24700c = r5;
            this.f24701d = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.autoaction.intent.b
        public void a(String r5, String r6, String r7, boolean r8) {
            d.h.b.o.e(r5, "result");
            d.h.b.o.e(r6, "reason");
            d.h.b.o.e(r7, DbHelper.COL_ID);
            Loog.INSTANCE.ip(AutoActionIntent.TAG, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r5, r6, r8), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
            this.f24698a.f38504a = r7;
            d.c.d<d.m<String, Boolean>> r4 = this.f24699b;
            n.a r9 = n.f38560a;
            r4.resumeWith(n.f(new d.m(r5, Boolean.valueOf(r8))));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Integer] */
        @Override // com.obric.autoaction.intent.b
        public void a(String r5, String r6, String r7, int r8, int r9) {
            d.h.b.o.e(r5, "result");
            d.h.b.o.e(r6, "reason");
            d.h.b.o.e(r7, DbHelper.COL_ID);
            Loog.INSTANCE.ip(AutoActionIntent.TAG, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r5, r6), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(b.f24704a, d.h.a.a.class, "com.obric.aiagent.plugin"));
            this.f24698a.f38504a = r7;
            z.f<Integer> r10 = this.f24700c;
            r10.f38504a = Integer.valueOf(r9);
            this.f24701d.f38502a = r8;
            d.c.d<d.m<String, Boolean>> r4 = this.f24699b;
            n.a r11 = n.f38560a;
            r4.resumeWith(n.f(new d.m(r5, true)));
        }
    }

    /* JADX INFO: compiled from: AutoActionIntent.kt */
    @d.c.b.a.f(b = "AutoActionIntent.kt", c = {227}, d = "invokeSuspend", e = "com.obric.autoaction.intent.AutoActionIntent$doAction$2$2$1")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f24710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f24711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.d f24712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f24713e;
        final /* synthetic */ d.c.d<d.m<String, Boolean>> f;
        final /* synthetic */ long g;
        final /* synthetic */ String h;
        final /* synthetic */ Bundle i;
        final /* synthetic */ SystemAutoActionParams j;
        final /* synthetic */ Long k;
        final /* synthetic */ AutoActionIntent l;
        final /* synthetic */ DispatchContext m;
        final /* synthetic */ String n;
        final /* synthetic */ Integer o;
        final /* synthetic */ z.f<String> p;
        final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.f q;
        final /* synthetic */ long r;
        final /* synthetic */ int s;

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class a implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.f f24716a;

            a(com.obric.autoaction.app.launcherpage.module.datasource.f r1) {
                this.f24716a = r1;
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }

            public final String a() {
                StringBuilder r0 = new StringBuilder().append("knowledge: ");
                com.obric.autoaction.app.launcherpage.module.datasource.f r2 = this.f24716a;
                if (r2 == null) goto L7;
                EventTask r3 = r2.a();
                if (r3 == null) goto L7;
                TaskKnowledge r4 = r3.getTaskKnowledge();
            L9:
                return r0.append(r4).toString();
            L7:
                r4 = null;
                goto L9
            }
        }

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class b implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f24717a = null;

            static {
                f24717a = new b();
            }

            b() {
            }

            public final String a() {
                return "knowledge fetched";
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class c implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z.f<String> f24718a;

            c(z.f<String> r1) {
                this.f24718a = r1;
            }

            public final String a() {
                return "assistant_meta: " + ((String) ZeusTransformUtils.preCheckCast(this.f24718a.f38504a, String.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        /* JADX INFO: compiled from: AutoActionIntent.kt */
        static final class d implements d.h.a.a<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f24719a = null;

            static {
                f24719a = new d();
            }

            d() {
            }

            public final String a() {
                return "assistant_meta";
            }

            @Override // d.h.a.a
            public /* synthetic */ String invoke() {
                return a();
            }
        }

        f(String r7, int r8, z.d r9, Context r10, d.c.d<? super d.m<String, Boolean>> r11, long r12, String r14, Bundle r15, SystemAutoActionParams r16, Long r17, AutoActionIntent r18, DispatchContext r19, String r20, Integer r21, z.f<String> r22, com.obric.autoaction.app.launcherpage.module.datasource.f r23, long r24, int r26, d.c.d<? super f> r27) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
            d.c.d<d.m<String, Boolean>> r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24710b = r7;
            this.f24711c = r8;
            this.f24712d = r9;
            this.f24713e = ZeusTransformUtils.wrapperContext(r1, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = r12;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r17;
            this.l = r18;
            this.m = r19;
            this.n = r20;
            this.o = r21;
            this.p = r22;
            this.q = r23;
            this.r = r24;
            this.s = r26;
            super(2, r4);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r27, d.c.d<?> r28) {
            d.c.d r24 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f24710b, this.f24711c, this.f24712d, this.f24713e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, r24), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r0v39, types: [T, java.lang.String] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r2 = d.c.a.b.a();
            int r3 = this.f24709a;
            if (r3 == 0) goto L8;
            if (r3 != 1) goto L7;
            o.a(r25);
            Object r0 = r25;
            String r4 = AutoActionIntent.TAG;
            String r5 = "com.obric.aiagent.plugin";
        L98:
            final com.obric.autogui.common.e r1 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.common.e.class, r5);
            if (r1.g() == true) goto L104;
            Loog.INSTANCE.ep(r4, (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1), d.h.a.a.class, r5), (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass2.f24715a, d.h.a.a.class, r5));
            this.f24712d.f38502a = -2002;
            CharSequence r6 = r1.a(this.f24713e);
            Context r7 = this.f24713e;
            if (d.o.o.d(r6) == false) goto L103;
            String r8 = r7.getString(ZeusTransformUtils.mapRes(R.string.appintent_start_task_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_start_task_failed"));
            d.h.b.o.c(r8, "getString(...)");
            r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, r5);
        L103:
            String r9 = r6.toString();
            d.c.d<d.m<String, Boolean>> r10 = this.f;
            n.a r11 = n.f38560a;
            r10.resumeWith(n.f(new d.m(r9, d.c.b.a.b.a(true))));
        L104:
            Loog.INSTANCE.i(r4, "start:" + r1);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r25);
            AutoActionAgent r12 = AutoActionAgent.INSTANCE;
            String r13 = this.f24710b;
            Bundle r14 = new Bundle();
            long r15 = this.g;
            String r16 = this.h;
            Bundle r17 = this.i;
            SystemAutoActionParams r18 = this.j;
            Long r19 = this.k;
            AutoActionIntent r110 = this.l;
            DispatchContext r20 = this.m;
            String r21 = this.n;
            Integer r22 = this.o;
            z.f<String> r23 = this.p;
            com.obric.autoaction.app.launcherpage.module.datasource.f r24 = this.q;
            long r26 = this.r;
            int r27 = this.s;
            r14.putLong("triggered_boot_time", r15);
            r14.putBoolean("eos_exit_directly", d.h.b.o.a(r16, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK));
            r14.putBundle("custom_hp", r17);
            r14.putString("execution_mode", r18.getExecutionMode());
            if (r19 == null) goto L11;
            r14.putLong("doubao_message_id", r19.longValue());
        L11:
            r14.putBundle("doubao_dispatch_context", AutoActionIntent.access$toBundle(r110, r20));
            if (r21 == null) goto L14;
            r14.putString("assistant_history", r21);
        L14:
            if (r22 == null) goto L16;
            r5 = "com.obric.aiagent.plugin";
            r14.putInt(KnowledgeActivity.KEY_TASK_TYPE, ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, r5)).intValue());
        L106:
            z.f<String> r111 = r23;
            String r112 = (String) ZeusTransformUtils.preCheckCast(r111.f38504a, String.class, r5);     // Catch: Exception -> L81
            if (r112 != null) goto L22;
            r112 = "{}";
        L22:
            JSONObject r28 = new JSONObject(r112);     // Catch: Exception -> L81
            com.obric.eventkit.task.model.a r29 = (com.obric.eventkit.task.model.a) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r28.optString("o_event_task"), com.obric.eventkit.task.model.a.class), com.obric.eventkit.task.model.a.class, r5);     // Catch: Exception -> L81
            if (r29 == null) goto L26;
            Integer r113 = r29.g();     // Catch: Exception -> L81
        L27:
            if (r29 != null) goto L110;
        L40:
            String r114 = null;
        L114:
            r28.remove("o_event_task");     // Catch: Exception -> L78
            if (r114 == null) goto L46;
            Integer r210 = r113;
            r28.put("task_info", new JSONObject().put("user_knowledge", r114));     // Catch: Exception -> L76
        L47:
            CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, r5);     // Catch: Exception -> L76
            if (r30 == null) goto L53;
            if (r30.length() == 0) goto L53;
            boolean r31 = false;
        L54:
            boolean r115 = !r31;
            if (r22 != null) goto L108;
        L69:
            boolean r211 = false;
        L116:
            r111.f38504a = r28.toString();     // Catch: Exception -> L72
            String r116 = AutoActionIntent.TAG;
            boolean r32 = r211;
            Integer r33 = r210;
            boolean r212 = r115;
        L88:
            Loog.INSTANCE.ip(r116, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r24), d.h.a.a.class, r5), (d.h.a.a) ZeusTransformUtils.preCheckCast(b.f24717a, d.h.a.a.class, r5));
            if (r18.getTaskId() == null) goto L91;
            if (r32 == true) goto L91;
        L92:
            String r34 = r116;
            z.f<String> r35 = r111;
            AutoActionIntent.access$putExtraForEventTask(r110, r14, r24, r212, r26, r33);
            if (r35.f38504a == null) goto L95;
            r14.putString("assistant_meta", (String) ZeusTransformUtils.preCheckCast(r35.f38504a, String.class, r5));
        L95:
            Loog.INSTANCE.ip(r34, (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r35), d.h.a.a.class, r5), (d.h.a.a) ZeusTransformUtils.preCheckCast(d.f24719a, d.h.a.a.class, r5));
            r14.putString("execution_mode", r18.getExecutionMode());
            r14.putInt("task_mode", r27);
            x r36 = x.f38692a;
            int r117 = this.f24711c;
            d.c.d<? super com.obric.autogui.common.e> r118 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, r5);
            this.f24709a = 1;
            r4 = r34;
            r0 = r12.postUserQuery(r13, false, r14, r117, r118);
            if (r0 != r2) goto L98;
            return r2;
        L91:
            r14.putBoolean("start_in_place", true);
        L72:
            e = e;
            r32 = r211;
            r33 = r210;
            r212 = r115;
        L87:
            Loog r37 = Loog.INSTANCE;
            Throwable r38 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r5);
            r116 = AutoActionIntent.TAG;
            r37.e(r116, "assistantMeta error", r38);
            goto L88
        L108:
        L74:
            e = e;
            r212 = r115;
            r33 = r210;
            r32 = false;
            goto L87
        L58:
            if (r22.intValue() != 3) goto L69;
            if (r29 == null) goto L66;
            Integer r39 = r29.g();     // Catch: Exception -> L74
            if (r39 == null) goto L66;
            if (r39.intValue() != 0) goto L66;
            boolean r40 = true;
        L67:
            if (r40 == false) goto L69;
            r211 = true;
        L66:
            r40 = false;
        L53:
            r31 = true;
        L76:
            e = e;
        L80:
            r33 = r210;
        L86:
            r32 = false;
            r212 = false;
            goto L87
        L46:
            r210 = r113;
        L78:
            e = e;
            r210 = r113;
            goto L80
        L110:
            TaskKnowledge r119 = r29.f();     // Catch: Exception -> L38
            if (r119 == null) goto L40;
            r114 = r119.getContent();     // Catch: Exception -> L38
            if (r114 == null) goto L40;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, r5)).length() <= 0) goto L35;
            boolean r41 = true;
        L36:
            if (r41 == false) goto L40;
        L35:
            r41 = false;
        L38:
            e = e;
            r33 = r113;
            goto L86
        L26:
            r113 = null;
        L81:
            e = e;
        L85:
            r33 = null;
        L83:
            e = e;
            r111 = r23;
            goto L85
        L16:
            r5 = "com.obric.aiagent.plugin";
            goto L106
        }
    }

    static {
        Companion = new a(null);
    }

    private static final String doAction$lambda$7() {
        return "do Action finish";
    }

    /* JADX INFO: renamed from: lambda$SeX1BCD-qlyB63dALaBQQCfNFrA, reason: not valid java name */
    public static /* synthetic */ String m580lambda$SeX1BCDqlyB63dALaBQQCfNFrA() {
        return doAction$lambda$7();
    }

    /* JADX INFO: renamed from: lambda$p0P_BFJB69-grCaaGZSATKcVQRE, reason: not valid java name */
    public static /* synthetic */ String m581lambda$p0P_BFJB69grCaaGZSATKcVQRE(z.f r0) {
        return doAction$lambda$6(r0);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public AutoActionIntent() {
    }

    public static final /* synthetic */ void access$putExtraForEventTask(AutoActionIntent r0, Bundle r1, com.obric.autoaction.app.launcherpage.module.datasource.f r2, boolean r3, long r4, Integer r6) {
        r0.putExtraForEventTask(r1, r2, r3, r4, r6);
    }

    public static final /* synthetic */ Bundle access$toBundle(AutoActionIntent r0, DispatchContext r1) {
        return r0.toBundle(r1);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, com.obric.autoaction.intent.AutoActionIntent$e] */
    /* JADX WARN: Type inference failed for: r6v28, types: [T, d.m] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v10 */
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
    @Override // com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent
    public Object doAction(SystemAutoActionParams r52, DispatchContext r53, d.c.d<? super IntentResult<Empty>> r54) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r54, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.x & Integer.MIN_VALUE) == 0) goto L7;
        r4.x -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.v;
        Object r5 = d.c.a.b.a();
        int r6 = r4.x;
        z.f r8 = 3;
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L23;
        if (r6 == 2) goto L22;
        if (r6 != 3) goto L21;
        int r0 = r4.u;
        int r1 = r4.t;
        long r7 = r4.s;
        long r9 = r4.r;
        z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r4.q, z.f.class, "com.obric.aiagent.plugin");
        z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r4.p, z.f.class, "com.obric.aiagent.plugin");
        Long r12 = (Long) ZeusTransformUtils.preCheckCast(r4.o, Long.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.n, String.class, "com.obric.aiagent.plugin");
        Bundle r14 = (Bundle) ZeusTransformUtils.preCheckCast(r4.m, Bundle.class, "com.obric.aiagent.plugin");
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(r4.l, Context.class, "com.obric.aiagent.plugin");
        z.d r16 = (z.d) ZeusTransformUtils.preCheckCast(r4.k, z.d.class, "com.obric.aiagent.plugin");
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r4.j, Integer.class, "com.obric.aiagent.plugin");
        com.obric.autoaction.app.launcherpage.module.datasource.f r18 = (com.obric.autoaction.app.launcherpage.module.datasource.f) ZeusTransformUtils.preCheckCast(r4.i, com.obric.autoaction.app.launcherpage.module.datasource.f.class, "com.obric.aiagent.plugin");
        z.f r19 = (z.f) ZeusTransformUtils.preCheckCast(r4.h, z.f.class, "com.obric.aiagent.plugin");
        z.f r20 = (z.f) ZeusTransformUtils.preCheckCast(r4.g, z.f.class, "com.obric.aiagent.plugin");
        z.f r21 = (z.f) ZeusTransformUtils.preCheckCast(r4.f, z.f.class, "com.obric.aiagent.plugin");
        final z.f r22 = (z.f) ZeusTransformUtils.preCheckCast(r4.f24697e, z.f.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r4.f24696d, String.class, "com.obric.aiagent.plugin");
        DispatchContext r111 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f24695c, DispatchContext.class, "com.obric.aiagent.plugin");
        SystemAutoActionParams r112 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r4.f24694b, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
        AutoActionIntent r23 = (AutoActionIntent) ZeusTransformUtils.preCheckCast(r4.f24693a, AutoActionIntent.class, "com.obric.aiagent.plugin");
        o.a(r3);     // Catch: Throwable -> L16 Exception -> L18
        String r113 = TAG;
        T r24 = r3;
    L205:
        r10.f38504a = r24;     // Catch: Throwable -> L16 Exception -> L139
        com.obric.autoaction.intent.b r25 = (com.obric.autoaction.intent.b) ZeusTransformUtils.preCheckCast(r21.f38504a, com.obric.autoaction.intent.b.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L138;
        com.obric.autoaction.intent.c.f24728a.b(r25);
        x r26 = x.f38692a;
    L138:
        String r27 = r113;
    L174:
        Loog.INSTANCE.ip(r27, new $$Lambda$AutoActionIntent$p0P_BFJB69grCaaGZSATKcVQRE(r22), $$Lambda$AutoActionIntent$SeX1BCDqlyB63dALaBQQCfNFrA.INSTANCE);
        IntentResult r28 = new IntentResult(r16.f38502a, null, null, (String) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r22.f38504a, d.m.class, "com.obric.aiagent.plugin")).a(), String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r28.setFinal(((Boolean) ZeusTransformUtils.preCheckCast(((d.m) ZeusTransformUtils.preCheckCast(r22.f38504a, d.m.class, "com.obric.aiagent.plugin")).b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        String r29 = (String) ZeusTransformUtils.preCheckCast(r20.f38504a, String.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L183;
        ConcurrentHashMap<String, String> r30 = r28.getExt();
        if (r30 != null) goto L179;
        r30 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(new IMAppActionExt(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    L179:
        r30.put("session_id", r29);
        Integer r31 = (Integer) ZeusTransformUtils.preCheckCast(r19.f38504a, Integer.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L182;
        r30.put("o_app_error_code", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r31, Number.class, "com.obric.aiagent.plugin")).intValue()));
        x r32 = x.f38692a;
    L182:
        r28.setExt(r30);
        x r33 = x.f38692a;
    L183:
        return r28;
    L139:
        e = e;
    L170:
        r27 = r113;
        Loog.INSTANCE.e(r27, "doAction error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        com.obric.autoaction.intent.b r34 = (com.obric.autoaction.intent.b) ZeusTransformUtils.preCheckCast(r21.f38504a, com.obric.autoaction.intent.b.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L174;
        com.obric.autoaction.intent.c.f24728a.b(r34);
        x r35 = x.f38692a;
    L18:
        e = e;
        r113 = TAG;
        goto L170
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        long r114 = r4.s;
        long r36 = r4.r;
        z.f r37 = (z.f) ZeusTransformUtils.preCheckCast(r4.h, z.f.class, "com.obric.aiagent.plugin");
        z.f r38 = (z.f) ZeusTransformUtils.preCheckCast(r4.g, z.f.class, "com.obric.aiagent.plugin");
        z.f r115 = (z.f) ZeusTransformUtils.preCheckCast(r4.f, z.f.class, "com.obric.aiagent.plugin");
        z.f r116 = (z.f) ZeusTransformUtils.preCheckCast(r4.f24697e, z.f.class, "com.obric.aiagent.plugin");
        String r39 = (String) ZeusTransformUtils.preCheckCast(r4.f24696d, String.class, "com.obric.aiagent.plugin");
        DispatchContext r40 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f24695c, DispatchContext.class, "com.obric.aiagent.plugin");
        SystemAutoActionParams r41 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r4.f24694b, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
        AutoActionIntent r117 = (AutoActionIntent) ZeusTransformUtils.preCheckCast(r4.f24693a, AutoActionIntent.class, "com.obric.aiagent.plugin");
        o.a(r3);
        Class r118 = AutoActionIntent.class;
        String r210 = "";
        String r211 = TAG;
        z.f r42 = r37;
        String r43 = r39;
        SystemAutoActionParams r51 = r41;
        z.f r119 = r38;
        Object r44 = r5;
        AutoActionIntent r45 = r117;
        DispatchContext r120 = r40;
        Object r46 = r3;
    L44:
        EventTask r47 = (EventTask) ZeusTransformUtils.preCheckCast(r46, EventTask.class, "com.obric.aiagent.plugin");
        z.f r48 = r116;
        AutoActionIntent r121 = r45;
        SystemAutoActionParams r49 = r51;
    L46:
        if (r47 == null) goto L48;
        com.obric.autoaction.app.launcherpage.module.datasource.f r50 = g.a(r47);
        Object r55 = r44;
        long r410 = r114;
        SystemAutoActionParams r122 = r49;
        AutoActionIntent r123 = r121;
        long r56 = r410;
        long r411 = r36;
        z.f r57 = r115;
        long r58 = r411;
    L52:
        if (ZeusTransformUtils.instanceOf(r50, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L54;
    L57:
        boolean r124 = true;
    L59:
        if (ZeusTransformUtils.instanceOf(r50, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L62;
        Integer r59 = d.c.b.a.b.a(1);
    L68:
        z.d r60 = new z.d();
        long r212 = r58;
        Context r61 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r120.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        boolean r125 = AutoActionAgent.INSTANCE.hasOngoingTask();
        z.d r510 = r60;
        Bundle r62 = new Bundle();
        z.f r126 = r42;
        z.f r511 = r119;
        r62.putString("task_scenario", r122.getTaskScenario());
        r62.putString("execution_mode", r122.getExecutionMode());
        String r63 = r122.getSourceFrom();
        if (d.h.b.o.a(r63, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L71;
        int r127 = 33;
    L74:
        boolean r128 = d.h.b.o.a(r63, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
        int r310 = r127;
        z.f r412 = r57;
        String r64 = r211;
        Loog.INSTANCE.i(r64, "taskSource: " + r63 + ", taskMode: " + (r128 ? 1 : 0));
        if (r125 == false) goto L89;
        Loog.INSTANCE.i(r64, "skip because running some task: " + r125);
        if (r128 == true) goto L88;
        String r65 = r122.getInstruction();
        if (r65 != null) goto L81;
        String r213 = r210;
    L82:
        String r66 = r122.getTaskId();
        if (r66 != null) goto L85;
        String r214 = r210;
    L86:
        r123.addTaskConflictRecord(r61, r213, r214, r59, r128 ? 1 : 0, d.h.b.o.a(r122.getExecutionMode(), "TEST_RUN"));
        goto L88
    L85:
        r214 = r66;
        goto L86
    L81:
        r213 = r65;
    L88:
        return r123.hasRunningTaskResult(r61);
    L89:
        com.obric.autoaction.e.c r215 = com.obric.autoaction.e.c.f24681a;
        if (r50 == null) goto L94;
        EventTask r67 = r50.a();
        if (r67 == null) goto L94;
        String r216 = r67.getId();
    L95:
        if (r59 == null) goto L97;
        int r68 = r59.intValue();
    L98:
        Integer r217 = d.c.b.a.b.a(r68);
        String r69 = r122.getExecutionMode();
        if (r69 != null) goto L101;
        r69 = SensitiveType.UNKNOWN;
    L101:
        r215.a(r216, r128 ? 1 : 0, r217, r63, r69);
        Long r70 = r120.getQuestionId();
        z.f r129 = new z.f();
        r129.f38504a = r122.getMeta();
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L209;
        Loog.INSTANCE.i(r64, " - [WithAssistantMeta] meta=" + ((String) ZeusTransformUtils.preCheckCast(r129.f38504a, String.class, "com.obric.aiagent.plugin")));
    L209:
        r123.startFloatingWindowService(r61);     // Catch: Throwable -> L163 Exception -> L166
        r4.f24693a = r123;     // Catch: Throwable -> L163 Exception -> L166
        r4.f24694b = r122;     // Catch: Throwable -> L163 Exception -> L166
        r4.f24695c = r120;     // Catch: Throwable -> L163 Exception -> L166
        r4.f24696d = r43;     // Catch: Throwable -> L163 Exception -> L166
        r4.f24697e = r48;     // Catch: Throwable -> L163 Exception -> L166
    L191:
        r4.f = r412;     // Catch: Throwable -> L158 Exception -> L160
        z.f r130 = r511;
        r4.g = r130;     // Catch: Exception -> L156 Throwable -> L158
        r4.h = r126;     // Catch: Exception -> L152 Throwable -> L158
        r4.i = r50;     // Catch: Exception -> L152 Throwable -> L158
        r4.j = r59;     // Catch: Exception -> L152 Throwable -> L158
        r510 = r510;
        r4.k = r510;     // Catch: Exception -> L150 Throwable -> L158
        r4.l = r61;     // Catch: Exception -> L150 Throwable -> L158
        r113 = r64;
        r4.m = r62;     // Catch: Exception -> L147 Throwable -> L158
        r4.n = r63;     // Catch: Exception -> L147 Throwable -> L158
        com.obric.autoaction.app.launcherpage.module.datasource.f r311 = r50;
        r4.o = r70;     // Catch: Exception -> L147 Throwable -> L158
        Integer r512 = r59;
        r4.p = r129;     // Catch: Exception -> L147 Throwable -> L158
        r4.q = r48;     // Catch: Exception -> L147 Throwable -> L158
        String r218 = r43;
        r48 = r48;
        r4.r = r212;     // Catch: Exception -> L145 Throwable -> L158
        long r71 = r56;
        r4.s = r71;     // Catch: Exception -> L145 Throwable -> L158
        r4.t = r310;     // Catch: Exception -> L145 Throwable -> L158
        r4.u = r128 ? 1 : 0;     // Catch: Exception -> L145 Throwable -> L158
        r4.x = 3;     // Catch: Exception -> L145 Throwable -> L158
        d r413 = r4;
        i r72 = new i(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L145 Throwable -> L158
        d.c.d r73 = (d.c.d) ZeusTransformUtils.preCheckCast(r72, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L145 Throwable -> L158
        r412.f38504a = new e(r130, r73, r126, r510);     // Catch: Exception -> L145 Throwable -> L158
        String r219 = r122.getInstruction();     // Catch: Exception -> L145 Throwable -> L158
        if (r219 == null) goto L126;
        com.obric.autoaction.intent.c.f24728a.a(r120);     // Catch: Exception -> L145 Throwable -> L158
        com.obric.autoaction.intent.c r74 = com.obric.autoaction.intent.c.f24728a;     // Catch: Exception -> L145 Throwable -> L158
        r126 = r126;
        T r75 = r412.f38504a;     // Catch: Exception -> L124 Throwable -> L158
        d.h.b.o.a(r75);     // Catch: Exception -> L124 Throwable -> L158
    L123:
        r74.a((com.obric.autoaction.intent.b) ZeusTransformUtils.preCheckCast(r75, com.obric.autoaction.intent.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L141 Exception -> L143
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new f(r219, r310, r510, r61, r73, r212, r63, r62, r122, r70, r123, r120, r218, r512, r129, r311, r71, r128 ? 1 : 0, null), m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L141 Exception -> L143
        x r76 = x.f38692a;     // Catch: Throwable -> L141 Exception -> L143
    L127:
        Object r77 = r72.a();     // Catch: Throwable -> L141 Exception -> L143
        if (r77 != d.c.a.b.a()) goto L130;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r413, d.c.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L141 Exception -> L143
    L130:
        Object r78 = r55;
        if (r77 != r78) goto L133;
        return r78;
    L133:
        r16 = r510;
        r20 = r130;
        r10 = r48;
        r22 = r10;
        r19 = r126;
        r21 = r10;
        r24 = r77;
    L124:
        e = e;
    L155:
        z.f r414 = r412;
    L169:
        r16 = r510;
        r20 = r130;
        r22 = r48;
        r19 = r126;
        r21 = r414;
        goto L170
    L126:
        r126 = r126;
        AutoActionIntent r79 = (AutoActionIntent) ZeusTransformUtils.preCheckCast(r123, r118, "com.obric.aiagent.plugin");     // Catch: Throwable -> L141 Exception -> L143
        n.a r80 = n.f38560a;     // Catch: Throwable -> L141 Exception -> L143
        r73.resumeWith(n.f(new d.m(r61.getString(ZeusTransformUtils.mapRes(R.string.term_type_normal, WsChannelMultiProcessSharedProvider.STRING_TYPE, "term_type_normal")), d.c.b.a.b.a(true))));     // Catch: Throwable -> L141 Exception -> L143
        x r81 = x.f38692a;     // Catch: Throwable -> L141 Exception -> L143
    L143:
        e = e;
    L141:
        th = th;
    L165:
        r8 = r46;
    L184:
        com.obric.autoaction.intent.b r82 = (com.obric.autoaction.intent.b) ZeusTransformUtils.preCheckCast(r8.f38504a, com.obric.autoaction.intent.b.class, "com.obric.aiagent.plugin");
        if (r82 == null) goto L187;
        com.obric.autoaction.intent.c.f24728a.b(r82);
        x r83 = x.f38692a;
    L187:
        throw th;
    L145:
        e = e;
    L149:
        r126 = r126;
    L147:
        e = e;
        r48 = r48;
    L150:
        e = e;
    L154:
        r48 = r48;
        r126 = r126;
        r113 = r64;
    L152:
        e = e;
        r510 = r510;
    L156:
        e = e;
    L162:
        r414 = r412;
    L168:
        r113 = r64;
    L158:
        th = th;
        z.f r415 = r412;
    L160:
        e = e;
        r130 = r511;
    L166:
        e = e;
        r510 = r510;
        r130 = r511;
        r414 = r412;
    L163:
        th = th;
        r415 = r412;
        goto L165
    L97:
        r68 = -1;
    L94:
        r216 = null;
        goto L95
    L71:
        if (r124 == false) goto L73;
        r127 = 34;
        goto L74
    L73:
        r127 = 35;
        goto L74
    L62:
        if (ZeusTransformUtils.instanceOf(r50, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L65;
        r59 = d.c.b.a.b.a(2);
        goto L68
    L65:
        if (ZeusTransformUtils.instanceOf(r50, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L67;
        r59 = d.c.b.a.b.a(3);
        goto L68
    L67:
        r59 = null;
        goto L68
    L54:
        if (ZeusTransformUtils.instanceOf(r50, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == true) goto L57;
        r124 = false;
        goto L59
    L48:
        String r84 = r43;
        z.f r85 = r115;
        long r416 = r114;
        r122 = r49;
        r123 = r121;
        long r131 = r416;
    L50:
        r55 = r44;
        r56 = r131;
        r58 = r36;
        r57 = r85;
        r43 = r84;
        r50 = null;
        goto L52
    L23:
        long r86 = r4.s;
        long r132 = r4.r;
        r84 = (String) ZeusTransformUtils.preCheckCast(r4.f24696d, String.class, "com.obric.aiagent.plugin");
        DispatchContext r87 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f24695c, DispatchContext.class, "com.obric.aiagent.plugin");
        r122 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r4.f24694b, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
        r123 = (AutoActionIntent) ZeusTransformUtils.preCheckCast(r4.f24693a, AutoActionIntent.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r120 = r87;
        r36 = r132;
        r131 = r86;
    L36:
        r48 = new z.f();
        r118 = AutoActionIntent.class;
        r48.f38504a = new d.m("", d.c.b.a.b.a(true));
        r85 = new z.f();
        z.f r88 = new z.f();
        r210 = "";
        r42 = new z.f();
        r211 = TAG;
        String r133 = r122.getTaskId();
        if (r133 == null) goto L49;
        IEventTaskApi r89 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r89 == null) goto L45;
        r4.f24693a = r123;
        r4.f24694b = r122;
        r4.f24695c = r120;
        r4.f24696d = r84;
        r4.f24697e = r48;
        r4.f = r85;
        r4.g = r88;
        r4.h = r42;
        r4.r = r36;
        r4.s = r131;
        r4.x = 2;
        r119 = r88;
        Object r90 = r89.getEventTask(r133, r4);
        r44 = r5;
        if (r90 != r44) goto L43;
        return r44;
    L43:
        r51 = r122;
        r43 = r84;
        long r417 = r131;
        r115 = r85;
        r116 = r48;
        r46 = r90;
        r45 = r123;
        r114 = r417;
        goto L44
    L45:
        r119 = r88;
        r44 = r5;
        r49 = r122;
        r43 = r84;
        r47 = null;
        long r418 = r131;
        r115 = r85;
        r121 = r123;
        r114 = r418;
        goto L46
    L49:
        r119 = r88;
        r44 = r5;
        goto L50
    L24:
        o.a(r3);
        r36 = AOSystemTools.INSTANCE.bootTimeMillis();
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L27;
        Loog.INSTANCE.d(TAG, "doAction begin \n at(bootTime): " + r36 + " \n taskId: " + r52.getTaskId() + " \n questionId: " + r53.getQuestionId() + " \n instruction: " + r52.getInstruction() + " \n assistantHistory: " + r52.getAssistantHistory() + " \n meta: " + r52.getMeta() + " \n executionMode: " + r52.getExecutionMode());
    L29:
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.AutoAction) == true) goto L32;
        Loog.INSTANCE.e(TAG, "The Platform " + AOPlatform.INSTANCE.getPlatform().getInformation() + " does not support AutoAction.");
        return notSupportedResult((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r53.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L32:
        r131 = AOSystemTools.INSTANCE.nowTimeMillis();
        String r91 = r52.getAssistantHistory();
        com.obric.autoaction.presentation.input.a.f24956a.a();
        com.obric.autogui.util.g r92 = com.obric.autogui.util.g.f31551a;
        r4.f24693a = this;
        r4.f24694b = r52;
        r120 = r53;
        r4.f24695c = r120;
        r4.f24696d = r91;
        r4.r = r36;
        r4.s = r131;
        r4.x = 1;
        if (r92.a("autoaction_intent", 15, r4) != r5) goto L35;
        return r5;
    L35:
        r84 = r91;
        r122 = r52;
        r123 = this;
        goto L36
    L27:
        Loog.INSTANCE.d(TAG, "doAction begin at(bootTime): " + r36 + ", taskId: " + r52.getTaskId() + "  questionId: " + r53.getQuestionId() + ' ');
    L16:
        th = th;
    L7:
        r4 = new d(this, r2);
        goto L8
    }

    private static final String doAction$lambda$6(z.f r2) {
        return "do Action finish with result:" + r2.f38504a;
    }

    private final void addTaskConflictRecord(Context r10, String r11, String r12, Integer r13, int r14, boolean r15) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r15, r13, r4, r14, r12, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void putExtraForEventTask(Bundle r5, com.obric.autoaction.app.launcherpage.module.datasource.f r6, boolean r7, long r8, Integer r10) {
        String r4 = null;
        if (r10 != null) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L7;
    L16:
        r10 = 2;
        goto L18
    L7:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == true) goto L15;
        if (r6 == null) goto L15;
        throw new k();
    L15:
        r10 = null;
    L18:
        if (r10 == null) goto L20;
        r5.putInt(OmniLabelingTaskTriggerExtraKeys.EVENT_TASK_SOURCE, ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
    L20:
        if (r6 == null) goto L51;
        r5.putString("timerTaskId", r6.a().getId());
        r5.putLong("trigger_time", r8);
        JSONObject r9 = new JSONObject();
        r9.put("use_knowledge", r7);
        TaskKnowledge r11 = r6.a().getTaskKnowledge();
        if (r11 == null) goto L24;
        r4 = r11.getContent();
    L24:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r13 = false;
        if (r12 != null) goto L27;
    L30:
        boolean r14 = true;
    L31:
        r9.put("has_knowledge", !r14);
        r9.put("task_mode", r6.a().getTaskMode());
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class) == false) goto L35;
        r5.putBoolean("isRepeatTimerTask", true);
        r9.put(KnowledgeActivity.KEY_TASK_TYPE, "condition");
        r9.put("location_condition", com.obric.event.task.base.report.d.f32758a.b(((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b()));
        r9.put("time_condition", com.obric.event.task.base.report.d.f32758a.a(((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b()));
        r9.put("condition_count", ((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b().getConditions().getConditions().size());
        r9.put("periodic", com.obric.event.task.base.report.d.f32758a.c(((com.obric.autoaction.app.launcherpage.module.datasource.f.a) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.a.class, "com.obric.aiagent.plugin")).b()));
        x r15 = x.f38692a;
        r5.putString("task_log_extras", r9.toString());
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class) == false) goto L38;
        r5.putBoolean("isRepeatTimerTask", ((com.obric.autoaction.app.launcherpage.module.datasource.f.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.c.class, "com.obric.aiagent.plugin")).b().isRepeat());
        r9.put(KnowledgeActivity.KEY_TASK_TYPE, "condition");
        r9.put("is_timer", true);
        x r16 = x.f38692a;
        r5.putString("task_log_extras", r9.toString());
        return;
    L38:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class) == false) goto L50;
        r9.put(KnowledgeActivity.KEY_TASK_TYPE, "shortcut");
        if (((com.obric.autoaction.app.launcherpage.module.datasource.f.b) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class, "com.obric.aiagent.plugin")).b().isShortInstructEnable() != true) goto L42;
        boolean r17 = true;
    L43:
        r9.put("enable_shortcut", r17);
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.autoaction.app.launcherpage.module.datasource.f.b) ZeusTransformUtils.preCheckCast(r6, com.obric.autoaction.app.launcherpage.module.datasource.f.b.class, "com.obric.aiagent.plugin")).b().getShortInstruct(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L46;
    L47:
        r13 = true;
    L48:
        r9.put("has_shortcut", !r13);
        x r19 = x.f38692a;
        r5.putString("task_log_extras", r9.toString());
        return;
    L46:
        if (r18.length() != 0) goto L48;
    L42:
        r17 = false;
        goto L43
    L50:
        throw new k();
    L27:
        if (r12.length() == 0) goto L30;
        r14 = false;
        goto L31
    }

    private final void startFloatingWindowService(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.startService(r2, new Intent(r2, FloatingWindowServiceImpl.class), "com.obric.aiagent.plugin");
    }

    private final IntentResult<Empty> notSupportedResult(Context r15) {
        String r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_autoaction_not_supported, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_autoaction_not_supported"));
        IMAppActionExt r14 = new IMAppActionExt();
        r14.put("o_app_error_code", "107001");
        x r16 = x.f38692a;
        return new IntentResult(ErrorCode.AutoGui.AUTO_GUI_SYSTEM_ACCOUNT_NOT_LOGIN, null, null, r5, false, false, 0, null, null, (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r14, ConcurrentHashMap.class, "com.obric.aiagent.plugin"), EntityType.AUDITORY_RECORDING, null);
    }

    private final IntentResult<Empty> hasRunningTaskResult(Context r15) {
        String r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.appintent_has_running_task_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_has_running_task_tips"));
        IMAppActionExt r14 = new IMAppActionExt();
        r14.put("o_app_error_code", "103004");
        x r16 = x.f38692a;
        return new IntentResult(ErrorCode.AutoGui.AUTO_GUI_QUEUE_HAS_RUNNING_TASK_ERROR, null, null, r5, false, false, 0, null, null, (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r14, ConcurrentHashMap.class, "com.obric.aiagent.plugin"), EntityType.AUDITORY_RECORDING, null);
    }

    private final Bundle toBundle(DispatchContext r6) {
        Bundle r5 = new Bundle();
        Long r0 = r6.getQuestionId();
        if (r0 == null) goto L5;
        r5.putLong("questionId", ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue());
    L5:
        Map<String, String> r7 = r6.getExt();
        if (r7 == null) goto L12;
        Bundle r1 = new Bundle();
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r1.putString((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L9
    L11:
        r5.putBundle("ext", r1);
    L12:
        return r5;
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r8) {
        d.h.b.o.e(r8, "reason");
        boolean r7 = AutoActionAgent.INSTANCE.hasOngoingTask();
        Loog.INSTANCE.d(TAG, " - cancelTask() called. hasOngoingTask=" + r7 + ", reason=" + r8);
        if (r7 == true) goto L6;
        return false;
    L6:
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int r1 = r8.hashCode();
        if (r1 == (-1881927548)) goto L21;
        if (r1 == (-1644260990)) goto L18;
        if (r1 == (-1191213731)) goto L14;
    L22:
        Loog.INSTANCE.e(TAG, "[AutoActionIntent] Unknown cancel reason: " + r8);
        String r10 = r9.getString(ZeusTransformUtils.mapRes(R.string.appintent_agent_task_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_agent_task_cancelled"));
        d.h.b.o.c(r10, "getString(...)");
        int r2 = 105001;
    L24:
        Loog.INSTANCE.w(TAG, "[AutoActionIntent] the Task is being cancelled. reasonString=" + r8 + ", mappedStopReason=" + r2);
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new c(r2, r10, null), m.class, "com.obric.aiagent.plugin"));
        return true;
    L14:
        if (r8.equals("user_stop_complex_task") == false) goto L22;
        r10 = r9.getString(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_user_request, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_user_request"));
        d.h.b.o.c(r10, "getString(...)");
        r2 = 2;
        goto L24
    L18:
        if (r8.equals("direct_send_interrupt") == false) goto L22;
        r10 = r9.getString(ZeusTransformUtils.mapRes(R.string.appintent_cancelled_direct_answer, WsChannelMultiProcessSharedProvider.STRING_TYPE, "appintent_cancelled_direct_answer"));
        d.h.b.o.c(r10, "getString(...)");
        r2 = 112003;
        goto L24
    L21:
        if (r8.equals("clarify_timeout") == false) goto L22;
        r10 = r9.getString(ZeusTransformUtils.mapRes(R.string.agent_task_terminated_unconfirmed_for_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminated_unconfirmed_for_too_long"));
        d.h.b.o.c(r10, "getString(...)");
        r2 = 112004;
        goto L24
    }
}
