package com.obric.assistant.dm.impl.statemachine.manager;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.IFlowSendMessageExtCallbackIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.DMConstData;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.platform.depend.ISysLogDepend;
import com.obric.aiagent.ttnet.ITTNet;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskState;
import com.obric.assistant.dm.api.statemachine.core.SimpleTaskEvent;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.core.TaskType;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.funcall_api.IIntentActionService;
import com.obric.funcall_api.OnAppActionListener;
import com.obric.funcall_api.bean.IntentAppAction;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.impl.OnTopCardChangedListener;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.k;
import d.o;
import d.s;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.br;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: DialogStateManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DialogStateManagerImpl implements IDialogStateManager {
    public static final a Companion = null;
    private static final String TAG = "DialogStateManagerImpl";
    private final DialogStateManagerImpl$ipcMessageExtCallback$1 ipcMessageExtCallback;
    private boolean isLogin;
    private final ConcurrentHashMap<String, Long> latestServerIndexByConversation;
    private final f messageObserver;
    private final ConcurrentHashMap<String, ca> pendingCancelTasks;
    private final ConcurrentHashMap<String, ca> pendingClarifyRefreshJobs;
    private final am scope;
    private final i topCardChangedListener;

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22564a = null;

        static {
            int[] r0 = new int[TaskType.values().length];
            r0[TaskType.SIMPLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[TaskType.OAUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[TaskType.COMPLEX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f22564a = r0;
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$init$1$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFlowAppIntentIDL f22566b;

        c(IFlowAppIntentIDL r3, d.c.d<? super c> r4) {
            IFlowAppIntentIDL r5 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22566b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f22566b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f22565a != 0) goto L10;
            o.a(r4);
            OTaskTimeoutConfig r3 = this.f22566b.getObricTaskTimeoutConfig();
            if (r3 == null) goto L8;
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "get timeout config: c:" + r3.getComplexTaskTimeout() + " o:" + r3.getOAutoTaskTimeout() + " s:" + r3.getSimpleTaskTimeout());
            com.obric.assistant.dm.api.statemachine.core.a.f22459a.a(r3.getComplexTaskTimeout());
            com.obric.assistant.dm.api.statemachine.core.a.f22459a.b(r3.getOAutoTaskTimeout());
            com.obric.assistant.dm.api.statemachine.core.a.f22459a.c(r3.getSimpleTaskTimeout());
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    public static final class d implements OnAppActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogStateManagerImpl f22567a;

        /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f22568a = null;

            static {
                int[] r0 = new int[TaskType.values().length];
                r0[TaskType.OAUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TaskType.COMPLEX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f22568a = r0;
            }
        }

        /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
        @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {577}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$init$4$1$onReceived$1$1$1$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22569a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DialogStateManagerImpl f22570b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22571c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ IMMessage f22572d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ TaskType f22573e;

            b(DialogStateManagerImpl r3, String r4, IMMessage r5, TaskType r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22570b = r3;
                this.f22571c = r4;
                this.f22572d = r5;
                this.f22573e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22570b, this.f22571c, this.f22572d, this.f22573e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22569a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L11:
                IMMessage r7 = (IMMessage) ZeusTransformUtils.preCheckCast(r6, IMMessage.class, "com.obric.aiagent.plugin");
                if (r7 == null) goto L15;
                DialogStateManagerImpl r2 = this.f22570b;
                IMMessage r3 = this.f22572d;
                TaskType r5 = this.f22573e;
                r2.createDMTaskAndStart(r3.getMessageId(), r7, r5);
            L15:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                DialogStateManagerImpl r8 = this.f22570b;
                String r4 = this.f22571c;
                d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22569a = 1;
                r6 = DialogStateManagerImpl.access$findMessageByMsgId(r8, r4, r9);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        d(DialogStateManagerImpl r1) {
            this.f22567a = r1;
        }

        @Override // com.obric.funcall_api.OnAppActionListener
        public void onReceived(IntentAppAction r20) {
            d.h.b.o.e(r20, "action");
            ConcurrentHashMap<String, String> r1 = r20.getExt();
            if (r1 == null) goto L48;
            DialogStateManagerImpl r9 = this.f22567a;
            if (d.h.b.o.a(r1.get("o_skip_state"), "1") == false) goto L7;
            return;
        L7:
            String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L21;
            int r3 = r2.hashCode();
            if (r3 == (-300091468)) goto L18;
            if (r3 != 1439051435) goto L21;
            if (r2.equals(IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L21;
            TaskType r4 = TaskType.OAUTO;
        L22:
            IMMessage r6 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(String.valueOf(r20.getQuestionId()));
            if (r6 == null) goto L37;
            ConcurrentHashMap<String, String> r5 = r20.getExt();
            if (r5 == null) goto L27;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        L28:
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "OnAppAction questionId=" + r20.getQuestionId() + " referenceMsgId=" + r7);
            if (r7 != null) goto L31;
        L35:
            r9.createDMTaskAndStart(r6.getMessageId(), r6, r4);
            Object r8 = x.f38692a;
        L36:
            if (r8 == null) goto L37;
            return;
        L31:
            if (d.h.b.o.a(r7, String.valueOf(r20.getQuestionId())) == true) goto L35;
            if (r4 == TaskType.SIMPLE) goto L35;
            r8 = kotlinx.coroutines.i.a(DialogStateManagerImpl.access$getScope$p(r9), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r9, r7, r6, r4, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            goto L36
        L27:
            r7 = null;
        L37:
            d r0 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            int r10 = a.f22568a[r4.ordinal()];
            if (r10 != 1) goto L40;
        L42:
            ConcurrentHashMap<String, String> r11 = r20.getExt();
            if (r11 == null) goto L45;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        L46:
            DialogStateManagerImpl.access$transferFromSimpleTaskIfNeeded(r9, String.valueOf(r20.getQuestionId()), r12, r4);
            return;
        L45:
            r12 = null;
            goto L46
        L40:
            if (r10 == 2) goto L42;
            return;
        L18:
            if (r2.equals(IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L21;
            r4 = TaskType.COMPLEX;
        L21:
            r4 = TaskType.SIMPLE;
            goto L22
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {327}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$maybeRetryFetchClarifyMessageIfNeed$job$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f22574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f22575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f22576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f22577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ DialogStateManagerImpl f22578e;
        final /* synthetic */ String f;
        final /* synthetic */ long g;
        final /* synthetic */ String h;

        e(DialogStateManagerImpl r3, String r4, long r5, String r7, d.c.d<? super e> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22578e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f22578e, this.f, this.g, this.h, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f22577d;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            long r4 = this.f22576c;
            long r6 = this.f22575b;
            long r8 = this.f22574a;
            o.a(r19);
        L10:
            if ((System.currentTimeMillis() - r8) > r6) goto L39;
            Long r3 = (Long) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getLatestServerIndexByConversation$p(this.f22578e).get(this.f), Long.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L14;
            long r12 = r3.longValue();
        L16:
            if (r12 > this.g) goto L17;
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin");
            String r13 = this.h;
            Iterator r7 = r5.iterator();
        L20:
            if (r7.hasNext() == false) goto L25;
            Object r14 = r7.next();
            if (d.h.b.o.a(((State) ZeusTransformUtils.preCheckCast(r14, State.class, "com.obric.aiagent.plugin")).getExtra().get("o_last_reply_message_id"), r13) == false) goto L20;
        L26:
            State r9 = (State) ZeusTransformUtils.preCheckCast(r14, State.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L28;
            if (r9.getState() == DMConstData.a.f16247e.ordinal()) goto L31;
            IFlowMessageIDL r10 = ak.a(aa.b(IFlowMessageIDL.class));
            if (r10 == null) goto L35;
            r10.refreshLatestMessages(this.f, 20);
        L35:
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22574a = r8;
            this.f22575b = r6;
            this.f22576c = r4;
            this.f22577d = 1;
            if (ax.a(r4, r11) != r1) goto L10;
            return r1;
        L31:
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "stop refresh loop because task entered Clarify. cid=" + this.f + ", msgId=" + this.h);
            goto L39
        L28:
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "stop refresh loop because task not found. cid=" + this.f + ", msgId=" + this.h);
            goto L39
        L25:
            r14 = null;
            goto L26
        L17:
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "stop refresh loop because newer message arrived. cid=" + this.f + ", msgId=" + this.h + ", curMax=" + r12 + ", target=" + this.g);
            goto L39
        L14:
            r12 = Long.MIN_VALUE;
        L39:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r19);
            r6 = 5000;
            r4 = 500;
            r8 = System.currentTimeMillis();
            goto L10
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    public static final class f implements com.obric.agent.im.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogStateManagerImpl f22579a;

        /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
        @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {164}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$messageObserver$1$onReceiveMessage$3$timeoutJob$1")
        static final class a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22580a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IMMessage f22581b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f22582c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DialogStateManagerImpl f22583d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f22584e;
            final /* synthetic */ String f;

            a(IMMessage r3, String r4, DialogStateManagerImpl r5, String r6, String r7, d.c.d<? super a> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22581b = r3;
                this.f22582c = r4;
                this.f22583d = r5;
                this.f22584e = r6;
                this.f = r7;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22581b, this.f22582c, this.f22583d, this.f22584e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22580a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L14:
                com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(this.f22582c);
                DialogStateManagerImpl.access$forceStopDMTaskIfNeeded(this.f22583d, this.f22582c, this.f22584e, this.f, "RECEIVE_FAILED");
                DialogStateManagerImpl.access$getPendingCancelTasks$p(this.f22583d).remove(this.f22582c);
                IFlowAppIntentIDL r7 = r.a(aa.b(IFlowAppIntentIDL.class));
                if (r7 == null) goto L21;
                String r2 = this.f22584e;
                if (r2 != null) goto L19;
                r2 = this.f22582c;
            L19:
                r7.stopComplexTask(r2);
            L21:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                IFlowMessageIDL r8 = ak.a(aa.b(IFlowMessageIDL.class));
                if (r8 == null) goto L11;
                r8.retryFetchMessage(this.f22581b);
            L11:
                d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22580a = 1;
                if (ax.a(20000, r9) != r0) goto L14;
                return r0;
            }
        }

        /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
        @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {211}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$messageObserver$1$onUpdateMessage$2$timeoutJob$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22585a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IMMessage f22586b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DialogStateManagerImpl f22587c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f22588d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f22589e;
            final /* synthetic */ String f;

            b(IMMessage r3, DialogStateManagerImpl r4, String r5, String r6, String r7, d.c.d<? super b> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22586b = r3;
                this.f22587c = r4;
                this.f22588d = r5;
                this.f22589e = r6;
                this.f = r7;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f22586b, this.f22587c, this.f22588d, this.f22589e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22585a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L14:
                DialogStateManagerImpl.access$forceStopDMTaskIfNeeded(this.f22587c, this.f22588d, this.f22589e, this.f, "RECEIVE_FAILED");
                DialogStateManagerImpl.access$getPendingCancelTasks$p(this.f22587c).remove(this.f22588d);
                IFlowAppIntentIDL r7 = r.a(aa.b(IFlowAppIntentIDL.class));
                if (r7 == null) goto L20;
                String r2 = this.f22589e;
                if (r2 != null) goto L19;
                r2 = this.f22588d;
            L19:
                r7.stopComplexTask(r2);
            L20:
                DialogStateManagerImpl.access$notifyNetworkErrorState(this.f22587c, this.f22589e, this.f);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                IFlowMessageIDL r8 = ak.a(aa.b(IFlowMessageIDL.class));
                if (r8 == null) goto L11;
                r8.retryFetchMessage(this.f22586b);
            L11:
                d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22585a = 1;
                if (ax.a(20000, r9) != r0) goto L14;
                return r0;
            }
        }

        @Override // com.obric.agent.im.d
        public void onRegenMessage(IMMessage r1) {
            d.h.b.o.e(r1, "message");
        }

        f(DialogStateManagerImpl r1) {
            this.f22579a = r1;
        }

        @Override // com.obric.agent.im.d
        public void onInsertMessageList(List<IMMessage> r3) {
            com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.agent.im.d
        public void onSendMessage(IMMessage r4) {
            d.h.b.o.e(r4, "message");
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "onSendMessage " + r4.getLocalMessageId() + ", " + r4.getMessageStatusLocal());
            if (r4.getMessageStatusLocal() == 11) goto L5;
            return;
        L5:
            if (com.obric.assistant.dm.impl.i.a(r4.getMessageId()) == false) goto L9;
            this.f22579a.handleMessageSendSuccess(r4);
            return;
        }

        @Override // com.obric.agent.im.d
        public void onReceiveMessage(IMMessage r17) {
            d.h.b.o.e(r17, "message");
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "onReceiveMessage " + r17.getLocalMessageId() + ", " + r17.getReplyId() + ", " + r17.getMessageStatusLocal() + ", " + r17.getMessageStatus());
            if (r17.getMessageStatus() != com.obric.agent.im.c.f14587d.f14589b) goto L7;
            ILogDepend.Companion.w(DialogStateManagerImpl.TAG, "message is invisible, filter");
            return;
        L7:
            if (r17.getReplyId() == null) goto L55;
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r17.getMessageId(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L11;
        L14:
            boolean r3 = true;
        L15:
            if (r3 == true) goto L64;
            Map<String, String> r4 = r17.getExt();
            if (r4 == null) goto L20;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        L21:
            Map<String, String> r5 = r17.getExt();
            if (r5 == null) goto L24;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
        L25:
            Map<String, String> r9 = r17.getExt();
            if (r9 == null) goto L28;
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        L29:
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "onReceiveMessage " + r17.getMessageId() + " oTaskType:" + r8 + " oTaskState:" + r6 + " reference:" + r10 + " message:" + r17);
            DialogStateManagerImpl.access$startDMTaskForReplyIfNeeded(this.f22579a, r17.getReplyId(), r10, r8);
            String r7 = r17.getReplyId();
            if (r7 == null) goto L36;
            DialogStateManagerImpl r11 = this.f22579a;
            ca r12 = (ca) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r11).get(r7), ca.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L34;
            ca.a.a(r12, null, 1, null);
        L34:
            ca r13 = (ca) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r11).remove(r7), ca.class, "com.obric.aiagent.plugin");
        L36:
            switch(r17.getMessageStatusLocal()) {
                case 20: goto L46;
                case 21: goto L44;
                case 22: goto L41;
                case 23: goto L38;
                default: goto L65;
            };
        L38:
            String r1 = r17.getReplyId();
            if (r1 == null) goto L56;
            DialogStateManagerImpl r0 = this.f22579a;
            com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(r1);
            DialogStateManagerImpl.access$forceStopDMTaskIfNeeded(r0, r1, r10, r8, "RECEIVE_INTERRUPT");
            return;
        L56:
            return;
        L41:
            String r14 = r17.getReplyId();
            if (r14 == null) goto L58;
            DialogStateManagerImpl r15 = this.f22579a;
            ((Map) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r15), Map.class, "com.obric.aiagent.plugin")).put(r14, kotlinx.coroutines.i.a(DialogStateManagerImpl.access$getScope$p(r15), null, null, (m) ZeusTransformUtils.preCheckCast(new a(r17, r14, r15, r10, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null));
            return;
        L58:
            return;
        L44:
            DialogStateManagerImpl.access$handleMessageReceived(this.f22579a, r17);
            return;
        L65:
            return;
        L46:
            if (d.h.b.o.a(r8, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L48;
            return;
        L48:
            if (d.h.b.o.a(r8, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L62;
            if (r10 != null) goto L51;
            r10 = r17.getReplyId();
        L51:
            String r16 = TaskId.Companion.a(String.valueOf(r10), TaskType.COMPLEX).getValue();
            DialogStateManagerImpl.access$handleMessageReceiving(this.f22579a, r17);
            IComplexTaskService r18 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
            if (r18 == null) goto L63;
            r18.onReceiveMessage(r16, r17);
            return;
        L63:
            return;
        L62:
            return;
        L28:
            r10 = null;
            goto L29
        L24:
            r6 = null;
            goto L25
        L20:
            r8 = null;
            goto L21
        L64:
            return;
        L11:
            if (r2.length() == 0) goto L14;
            r3 = false;
            goto L15
        }

        @Override // com.obric.agent.im.d
        public void onUpdateMessage(IMMessage r19) {
            d.h.b.o.e(r19, "message");
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "onUpdateMessage " + r19.getLocalMessageId() + ", " + r19.getReplyId() + ", " + r19.getMessageStatusLocal() + ", " + r19.getMessageStatus());
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.getMessageId(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            return;
        L11:
            DialogStateManagerImpl.access$maybeRetryFetchClarifyMessageIfNeed(this.f22579a, r19);
            Map<String, String> r4 = r19.getExt();
            if (r4 == null) goto L14;
            String r8 = (String) ZeusTransformUtils.preCheckCast(r4.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        L15:
            Map<String, String> r5 = r19.getExt();
            if (r5 == null) goto L18;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
        L19:
            Map<String, String> r9 = r19.getExt();
            if (r9 == null) goto L22;
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
        L23:
            ILogDepend.Companion.i(DialogStateManagerImpl.TAG, "onUpdateMessage " + r19.getMessageId() + " oTaskType:" + r8 + " oTaskState:" + r6 + " message:" + r19);
            String r7 = r19.getReplyId();
            if (r7 == null) goto L30;
            DialogStateManagerImpl r11 = this.f22579a;
            ca r12 = (ca) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r11).get(r7), ca.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L28;
            ca.a.a(r12, null, 1, null);
        L28:
            ca r13 = (ca) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r11).remove(r7), ca.class, "com.obric.aiagent.plugin");
        L30:
            if (r19.getMessageStatusLocal() != 21) goto L33;
            DialogStateManagerImpl.access$handleMessageReceived(this.f22579a, r19);
            return;
        L33:
            if (r19.getMessageStatusLocal() != 20) goto L36;
            DialogStateManagerImpl.access$handleMessageReceiving(this.f22579a, r19);
            return;
        L36:
            if (r19.getMessageStatusLocal() != 22) goto L44;
            String r14 = r19.getReplyId();
            if (r14 == null) goto L59;
            DialogStateManagerImpl r15 = this.f22579a;
            ca r0 = (ca) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r15).get(r14), ca.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L42;
            ca.a.a(r0, null, 1, null);
        L42:
            ((Map) ZeusTransformUtils.preCheckCast(DialogStateManagerImpl.access$getPendingCancelTasks$p(r15), Map.class, "com.obric.aiagent.plugin")).put(r14, kotlinx.coroutines.i.a(DialogStateManagerImpl.access$getScope$p(r15), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r19, r15, r14, r10, r8, null), m.class, "com.obric.aiagent.plugin"), 3, null));
            return;
        L59:
            return;
        L44:
            if (r19.getMessageStatusLocal() != 23) goto L47;
            DialogStateManagerImpl.access$forceStopDMTaskIfNeeded(this.f22579a, r19.getReplyId(), r10, r8, "RECEIVE_INTERRUPT");
            return;
        L47:
            if (r19.getMessageStatusLocal() != 13) goto L50;
            DialogStateManagerImpl.access$forceStopDMTaskIfNeeded(this.f22579a, r19.getMessageId(), r10, r8, "SEND_INTERRUPT");
            return;
        L50:
            if (r19.getMessageStatusLocal() == 11) goto L52;
            return;
        L52:
            if (r19.getMessageStatus() == com.obric.agent.im.c.f14586c.f14589b) goto L54;
            return;
        L54:
            if (com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(r19) == false) goto L65;
            com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r19);
            return;
        L65:
            return;
        L22:
            r10 = null;
            goto L23
        L18:
            r6 = null;
            goto L19
        L14:
            r8 = null;
            goto L15
        L5:
            if (r2.length() == 0) goto L8;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$notifyOAutoDied$1$1")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ State f22591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DialogStateManagerImpl f22592c;

        g(State r3, DialogStateManagerImpl r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f22591b = r3;
            this.f22592c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f22591b, this.f22592c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f22590a != 0) goto L11;
            o.a(r4);
            State r5 = this.f22591b;
            d.h.b.o.a(r5, "null cannot be cast to non-null type com.obric.assistant.dm.api.statemachine.core.OAutoTaskState");
            OAutoTaskState r6 = (OAutoTaskState) ZeusTransformUtils.preCheckCast(r5, OAutoTaskState.class, "com.obric.aiagent.plugin");
            DialogStateManagerImpl r3 = this.f22592c;
            TaskInfo r7 = r6.getTaskInfo();
            if (r7 == null) goto L7;
            String r8 = r7.getQueryId();
        L8:
            DialogStateManagerImpl.access$forceStopDMTaskIfNeeded(r3, r8, null, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI, "OAutoDied");
            return x.f38692a;
        L7:
            r8 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {492}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$startDMTaskForReplyIfNeeded$1")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f22593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f22594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f22595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f22596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f22597e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ DialogStateManagerImpl h;
        final /* synthetic */ String i;
        private /* synthetic */ Object j;

        /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f22598a = null;

            static {
                int[] r0 = new int[TaskType.values().length];
                r0[TaskType.SIMPLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TaskType.OAUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TaskType.COMPLEX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f22598a = r0;
            }
        }

        h(String r3, String r4, DialogStateManagerImpl r5, String r6, d.c.d<? super h> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            h r11 = new h(this.f, this.g, this.h, this.i, r7);
            r11.j = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f22597e;
            x r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            DialogStateManagerImpl r2 = (DialogStateManagerImpl) ZeusTransformUtils.preCheckCast(this.f22596d, DialogStateManagerImpl.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.f22595c, String.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f22594b, String.class, "com.obric.aiagent.plugin");
            TaskType r6 = (TaskType) ZeusTransformUtils.preCheckCast(this.f22593a, TaskType.class, "com.obric.aiagent.plugin");
            am r10 = (am) ZeusTransformUtils.preCheckCast(this.j, am.class, "com.obric.aiagent.plugin");
            o.a(r11);
        L36:
            IMMessage r12 = (IMMessage) ZeusTransformUtils.preCheckCast(r11, IMMessage.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L39;
            r2.createDMTaskAndStart(r4, r12, r6);
            r3 = x.f38692a;
        L39:
            DialogStateManagerImpl r7 = r2;
            String r8 = r5;
        L41:
            if (r3 != null) goto L51;
        L42:
            DialogStateManagerImpl.access$transferFromSimpleTaskIfNeeded(r7, r4, r8, r6);
        L51:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            am r13 = (am) ZeusTransformUtils.preCheckCast(this.j, am.class, "com.obric.aiagent.plugin");
            String r9 = this.f;
            if (d.h.b.o.a(r9, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L13;
            TaskType r14 = TaskType.OAUTO;
        L11:
            r6 = r14;
            int r15 = a.f22598a[r6.ordinal()];
            if (r15 != 1) goto L19;
            String r16 = this.g;
            if (r16 == null) goto L52;
            DialogStateManagerImpl r17 = this.h;
            IMMessage r18 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(r16);
            if (r18 == null) goto L53;
            r17.createDMTaskAndStart(r18.getMessageId(), r18, TaskType.SIMPLE);
            return x.f38692a;
        L53:
            return null;
        L52:
            return null;
        L19:
            if (r15 != 2) goto L21;
        L25:
            r4 = this.g;
            if (r4 == null) goto L50;
            r8 = this.i;
            r7 = this.h;
            IMMessage r19 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(r4);
            if (r19 == null) goto L42;
            if (r8 != null) goto L31;
        L40:
            r7.createDMTaskAndStart(r4, r19, r6);
            r3 = x.f38692a;
            goto L41
        L31:
            if (d.h.b.o.a(r8, r4) == true) goto L40;
            this.j = r13;
            this.f22593a = r6;
            this.f22594b = r8;
            this.f22595c = r4;
            this.f22596d = r7;
            this.f22597e = 1;
            r11 = DialogStateManagerImpl.access$findMessageByMsgId(r7, r8, this);
            if (r11 != r0) goto L35;
            return r0;
        L35:
            r5 = r8;
            r2 = r7;
            goto L36
        L50:
            return null;
        L21:
            if (r15 == 3) goto L25;
            throw new k();
        L13:
            if (d.h.b.o.a(r9, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L15;
            r14 = TaskType.COMPLEX;
            goto L11
        L15:
            r14 = TaskType.SIMPLE;
            goto L11
        }
    }

    /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
    public static final class i implements OnTopCardChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogStateManagerImpl f22599a;

        /* JADX INFO: compiled from: DialogStateManagerImpl.kt */
        @d.c.b.a.f(b = "DialogStateManagerImpl.kt", c = {340}, d = "invokeSuspend", e = "com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$topCardChangedListener$1$onServiceDied$1")
        static final class a extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f22600a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ DialogStateManagerImpl f22601b;

            a(DialogStateManagerImpl r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22601b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f22601b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f22600a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r6);
            L11:
                DialogStateManagerImpl.access$initLiveCard(this.f22601b);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r6);
                d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f22600a = 1;
                if (ax.a(100, r7) != r0) goto L11;
                return r0;
            }
        }

        i(DialogStateManagerImpl r1) {
            this.f22599a = r1;
        }

        @Override // com.obric.livecard.api.impl.OnLiveCardServiceDiedListener
        public void onServiceDied() {
            kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new a(this.f22599a, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        }

        @Override // com.obric.livecard.api.impl.OnTopCardChangedListener
        public void onTopSessionChanged(IslandSession r3) {
            ISecureLogDepend.Companion.i("OnTopCardChangedListener", "onTopSessionChanged " + r3);
            com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r3);
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$1XeMgJ4feuYN5xU_Gq7zhFy3_o8(DialogStateManagerImpl r0, IFlowAppIntentIDL r1) {
        init$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$9Oy3vbP14-BQJA4kLOnNNTz0emI, reason: not valid java name */
    public static /* synthetic */ Thread m429lambda$9Oy3vbP14BQJA4kLOnNNTz0emI(Runnable r0) {
        return scope$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$CXQ_hH1YxoCq8v-RYat7J7egY_0, reason: not valid java name */
    public static /* synthetic */ x m430lambda$CXQ_hH1YxoCq8vRYat7J7egY_0(DialogStateManagerImpl r0, String r1, Throwable r2) {
        return maybeRetryFetchClarifyMessageIfNeed$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$D8J8XWZWvMRvyMbxVELi9jg5HYE(DialogStateManagerImpl r0, IFlowMessageIDL r1) {
        init$lambda$13(r0, r1);
    }

    public static /* synthetic */ void lambda$b0RWCOInoohiFBz9ICb0zjY2RYE(IFlowNetworkIDL r0) {
        init$lambda$14(r0);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.assistant.dm.impl.statemachine.manager.DialogStateManagerImpl$ipcMessageExtCallback$1] */
    public DialogStateManagerImpl() {
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$DialogStateManagerImpl$9Oy3vbP14BQJA4kLOnNNTz0emI.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        this.scope = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
        this.pendingCancelTasks = new ConcurrentHashMap();
        this.latestServerIndexByConversation = new ConcurrentHashMap();
        this.pendingClarifyRefreshJobs = new ConcurrentHashMap();
        this.messageObserver = new f(this);
        this.topCardChangedListener = new i(this);
        this.ipcMessageExtCallback = new DialogStateManagerImpl$ipcMessageExtCallback$1();
    }

    public static final /* synthetic */ Object access$findMessageByMsgId(DialogStateManagerImpl r2, String r3, d.c.d r4) {
        return r2.findMessageByMsgId(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$forceStopDMTaskIfNeeded(DialogStateManagerImpl r0, String r1, String r2, String r3, String r4) {
        r0.forceStopDMTaskIfNeeded(r1, r2, r3, r4);
    }

    public static final /* synthetic */ ConcurrentHashMap access$getLatestServerIndexByConversation$p(DialogStateManagerImpl r0) {
        return r0.latestServerIndexByConversation;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPendingCancelTasks$p(DialogStateManagerImpl r0) {
        return r0.pendingCancelTasks;
    }

    public static final /* synthetic */ am access$getScope$p(DialogStateManagerImpl r0) {
        return r0.scope;
    }

    public static final /* synthetic */ void access$handleMessageReceived(DialogStateManagerImpl r0, IMMessage r1) {
        r0.handleMessageReceived(r1);
    }

    public static final /* synthetic */ void access$handleMessageReceiving(DialogStateManagerImpl r0, IMMessage r1) {
        r0.handleMessageReceiving(r1);
    }

    public static final /* synthetic */ void access$initLiveCard(DialogStateManagerImpl r0) {
        r0.initLiveCard();
    }

    public static final /* synthetic */ void access$maybeRetryFetchClarifyMessageIfNeed(DialogStateManagerImpl r0, IMMessage r1) {
        r0.maybeRetryFetchClarifyMessageIfNeed(r1);
    }

    public static final /* synthetic */ void access$notifyNetworkErrorState(DialogStateManagerImpl r0, String r1, String r2) {
        r0.notifyNetworkErrorState(r1, r2);
    }

    public static final /* synthetic */ void access$startDMTaskForReplyIfNeeded(DialogStateManagerImpl r0, String r1, String r2, String r3) {
        r0.startDMTaskForReplyIfNeeded(r1, r2, r3);
    }

    public static final /* synthetic */ void access$transferFromSimpleTaskIfNeeded(DialogStateManagerImpl r0, String r1, String r2, TaskType r3) {
        r0.transferFromSimpleTaskIfNeeded(r1, r2, r3);
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "dm-dispatcher");
    }

    private final void maybeRetryFetchClarifyMessageIfNeed(IMMessage r15) {
        long r3 = r15.getServerIndex();
        if (r3 > 0) goto L5;
        return;
    L5:
        String r2 = r15.getConversationId();
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(this.latestServerIndexByConversation.get(r2), Long.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L14;
        long r8 = r4.longValue();
    L16:
        if (r3 >= r8) goto L18;
        return;
    L18:
        ((Map) ZeusTransformUtils.preCheckCast(this.latestServerIndexByConversation, Map.class, "com.obric.aiagent.plugin")).put(r2, Long.valueOf(r3));
        Map<String, String> r5 = r15.getExt();
        Object r6 = null;
        if (r5 == null) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_complex_task_message_type"), String.class, "com.obric.aiagent.plugin");
    L23:
        if (d.h.b.o.a(r7, "clarify") == true) goto L25;
        return;
    L25:
        final String r16 = r15.getMessageId();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L29;
        r1 = false;
    L29:
        if (r1 == false) goto L31;
        return;
    L31:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L33:
        if (r9.hasNext() == false) goto L37;
        Object r10 = r9.next();
        if (d.h.b.o.a(((State) ZeusTransformUtils.preCheckCast(r10, State.class, "com.obric.aiagent.plugin")).getExtra().get("o_last_reply_message_id"), r16) == false) goto L33;
        r6 = r10;
    L37:
        State r11 = (State) ZeusTransformUtils.preCheckCast(r6, State.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L41;
        return;
    L41:
        if (r11.getState() != DMConstData.a.f16247e.ordinal()) goto L44;
        return;
    L44:
        if (this.pendingClarifyRefreshJobs.containsKey(r16) == false) goto L46;
        return;
    L46:
        ILogDepend.Companion.w(TAG, "clarify message detected but task state is not Clarify, start refresh loop. cid=" + r2 + ", msgId=" + r16 + ", serverIndex=" + r3 + ", taskState=" + r11.getState());
        ca r12 = kotlinx.coroutines.i.a(this.scope, null, null, (m) ZeusTransformUtils.preCheckCast(new e(this, r2, r3, r16, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.pendingClarifyRefreshJobs, Map.class, "com.obric.aiagent.plugin")).put(r16, r12);
        r12.a_(new $$Lambda$DialogStateManagerImpl$CXQ_hH1YxoCq8vRYat7J7egY_0(this, r16));
        return;
    L21:
        r7 = null;
        goto L23
    L14:
        r8 = Long.MIN_VALUE;
        goto L16
    L8:
        r0 = false;
        goto L9
    }

    private static final x maybeRetryFetchClarifyMessageIfNeed$lambda$2(DialogStateManagerImpl r0, String r1, Throwable r2) {
        r0.pendingClarifyRefreshJobs.remove(r1);
        return x.f38692a;
    }

    private final void forceStopDMTaskIfNeeded(String r3, String r4, String r5, String r6) {
        if (r5 != null) goto L4;
        r5 = getRunningTaskTypeForReferenceId(r4);
    L4:
        if (r3 != null) goto L6;
        r3 = getRunningMessageIdForReferenceId(r4);
    L6:
        if (r3 == null) goto L20;
        TaskType r2 = (TaskType) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.api.statemachine.core.a.f22459a.d().get(r5), TaskType.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L21;
        TaskId r7 = TaskId.Companion.a(r3, r2);
        int r8 = b.f22564a[r2.ordinal()];
        if (r8 == 1) goto L18;
        if (r8 != 2) goto L13;
        OAutoTaskEvent.TaskForceCompleted r9 = new OAutoTaskEvent.TaskForceCompleted(r7, null, 2, null);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r9, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        if (r8 != 3) goto L16;
        ComplexTaskEvent.InterruptTask r10 = new ComplexTaskEvent.InterruptTask(r7, ao.a(s.a("stop_reason", r6)));
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r10, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        throw new k();
    L18:
        SimpleTaskEvent.TaskCompleted r11 = new SimpleTaskEvent.TaskCompleted(r7, null, 2, null);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r11, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L21:
        return;
    }

    private final void notifyNetworkErrorState(String r3, String r4) {
        if (r4 != null) goto L4;
        r4 = getRunningTaskTypeForReferenceId(r3);
    L4:
        TaskType r2 = (TaskType) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.api.statemachine.core.a.f22459a.d().get(r4), TaskType.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L17;
        int r5 = b.f22564a[r2.ordinal()];
        if (r5 != 1) goto L9;
        com.obric.aiagent.ttnet.c r6 = com.obric.aiagent.ttnet.c.f22211c;
    L16:
        if (r6 == null) goto L17;
    L18:
        ISysLogDepend.Companion.i(TAG, "O_TASK_RECEIVE_FAILED, TASK_TYPE=" + r6.a());
        ITTNet r7 = (ITTNet) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNet.class), ITTNet.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L22;
        r7.onNetworkError(r6);
        return;
    L22:
        return;
    L9:
        if (r5 != 2) goto L11;
        r6 = com.obric.aiagent.ttnet.c.f22210b;
        goto L16
    L11:
        if (r5 == 3) goto L13;
        r6 = com.obric.aiagent.ttnet.c.f22209a;
        goto L16
    L13:
        r6 = com.obric.aiagent.ttnet.c.f22212d;
    L17:
        r6 = com.obric.aiagent.ttnet.c.f22209a;
        goto L18
    }

    private final String getRunningTaskTypeForReferenceId(String r7) {
        if (r7 == null) goto L48;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(getCurrentDMState().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L5:
        String r1 = "simple_task";
    L7:
        if (r6.hasNext() == false) goto L34;
        State r3 = (State) ZeusTransformUtils.preCheckCast(r6.next(), State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, TaskState.class) == false) goto L7;
        TaskInfo r4 = ((TaskState) ZeusTransformUtils.preCheckCast(r3, TaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        TaskType r5 = null;
        if (r4 == null) goto L15;
        IMMessage r8 = r4.getMessage();
        if (r8 == null) goto L15;
        String r9 = r8.getMessageId();
    L17:
        if (d.h.b.o.a(r9, r7) == false) goto L7;
        TaskInfo r2 = ((TaskState) ZeusTransformUtils.preCheckCast(r3, TaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r2 == null) goto L21;
        r5 = r2.getTaskType();
    L21:
        if (r5 != null) goto L23;
        int r10 = -1;
    L25:
        if (r10 == 1) goto L5;
        if (r10 != 2) goto L29;
        r1 = IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI;
        goto L7
    L29:
        if (r10 != 3) goto L5;
        r1 = IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK;
        goto L7
    L23:
        r10 = b.f22564a[r5.ordinal()];
    L15:
        r9 = null;
        goto L17
    L34:
        return r1;
    L48:
        return "simple_task";
    }

    private final void finishDMTaskIfNeeded(String r3, String r4, String r5, Map<String, String> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        r5 = "simple_task";
    L5:
        if (r3 != null) goto L7;
        String r2 = getRunningMessageIdForReferenceId(r4);
    L8:
        if (r2 == null) goto L26;
        TaskType r8 = (TaskType) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.api.statemachine.core.a.f22459a.d().get(r5), TaskType.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L27;
        int r9 = b.f22564a[r8.ordinal()];
        if (r9 != 1) goto L14;
        TaskId.a r10 = TaskId.Companion;
        if (r3 != null) goto L24;
        r3 = r2;
    L24:
        SimpleTaskEvent.TaskCompleted r11 = new SimpleTaskEvent.TaskCompleted(r10.a(r3, r8), r7);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r11, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        if (r9 != 2) goto L16;
        OAutoTaskEvent.TaskCompleted r12 = new OAutoTaskEvent.TaskCompleted(TaskId.Companion.a(r2, r8), r7);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r12, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        if (r9 != 3) goto L19;
        ComplexTaskEvent.TaskCompleted r13 = new ComplexTaskEvent.TaskCompleted(TaskId.Companion.a(r2, r8), r7);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r13, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L19:
        throw new k();
    L27:
        return;
    L26:
        return;
    L7:
        r2 = r3;
        goto L8
    }

    private final String getRunningMessageIdForReferenceId(String r6) {
        if (r6 == null) goto L31;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(getCurrentDMState().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L5:
        String r1 = null;
    L7:
        if (r5.hasNext() == false) goto L22;
        State r3 = (State) ZeusTransformUtils.preCheckCast(r5.next(), State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, TaskState.class) == false) goto L7;
        TaskInfo r4 = ((TaskState) ZeusTransformUtils.preCheckCast(r3, TaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r4 == null) goto L15;
        IMMessage r7 = r4.getMessage();
        if (r7 == null) goto L15;
        String r8 = r7.getMessageId();
    L17:
        if (d.h.b.o.a(r8, r6) == false) goto L7;
        TaskInfo r2 = ((TaskState) ZeusTransformUtils.preCheckCast(r3, TaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r2 == null) goto L5;
        r1 = r2.getQueryId();
    L15:
        r8 = null;
        goto L17
    L22:
        return r1;
    L31:
        return null;
    }

    private final void startDMTaskForReplyIfNeeded(String r8, String r9, String r10) {
        kotlinx.coroutines.i.a(null, (m) ZeusTransformUtils.preCheckCast(new h(r10, r8, this, r9, null), m.class, "com.obric.aiagent.plugin"), 1, null);
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void init(Context r9) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), "context");
        r.a(aa.b(IFlowAppIntentIDL.class), false, false, new $$Lambda$DialogStateManagerImpl$1XeMgJ4feuYN5xU_Gq7zhFy3_o8(this), 3, null);
        com.obric.agent.im.a.f14573a.a((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(this.messageObserver, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
        ak.a(aa.b(IFlowMessageIDL.class), false, false, new $$Lambda$DialogStateManagerImpl$D8J8XWZWvMRvyMbxVELi9jg5HYE(this), 3, null);
        com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class), false, false, $$Lambda$DialogStateManagerImpl$b0RWCOInoohiFBz9ICb0zjY2RYE.INSTANCE, 3, null);
        initLiveCard();
        IIntentActionService r10 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L6;
        r10.registerAppActionListener((OnAppActionListener) ZeusTransformUtils.preCheckCast(new d(this), OnAppActionListener.class, "com.obric.aiagent.plugin"));
        return;
    }

    private static final void init$lambda$12(DialogStateManagerImpl r8, IFlowAppIntentIDL r9) {
        IFlowAppIntentIDL r10 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r9, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "it");
        boolean r2 = true;
        if (r10.isLogin() == true) goto L6;
        r2 = false;
    L6:
        r8.isLogin = r2;
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new c(r10, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private static final void init$lambda$13(DialogStateManagerImpl r2, IFlowMessageIDL r3) {
        IFlowMessageIDL r4 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "it");
        r4.registerSendMessageExtCallback((IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(r2.ipcMessageExtCallback, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin"));
    }

    private static final void init$lambda$14(IFlowNetworkIDL r3) {
        IFlowNetworkIDL r4 = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "it");
        ILogDepend.Companion.i(TAG, "clearOmniTasks for app_restart");
        r4.clearOmniTasks(ao.a(s.a("stop_scene", "app_restart")), null);
    }

    private final void transferFromSimpleTaskIfNeeded(String r5, String r6, TaskType r7) {
        TaskId.a r0 = TaskId.Companion;
        if (r6 != null) goto L5;
        r6 = r5;
    L5:
        TaskId r8 = r0.a(r6, TaskType.SIMPLE);
        TaskInfo r1 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r8);
        if (r1 == null) goto L11;
        SimpleTaskEvent.TaskCompleted r2 = new SimpleTaskEvent.TaskCompleted(r8, null, 2, null);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r2, DMEvent.class, "com.obric.aiagent.plugin"));
        IMMessage r9 = r1.getMessage();
        if (r9 == null) goto L12;
        createDMTaskAndStart(r5, r9, r7);
        return;
    L12:
        return;
    }

    private final void initLiveCard() {
        ILiveCard.Companion.getInst().init((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.addOnTopCardChangedListener((OnTopCardChangedListener) ZeusTransformUtils.preCheckCast(this.topCardChangedListener, OnTopCardChangedListener.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, e.toString());
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void registerDMStateListener(com.obric.assistant.dm.api.statemachine.core.b r2) {
        com.obric.assistant.dm.api.statemachine.core.b r1 = (com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "listener");
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r1);
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public DMState getCurrentDMState() {
        return com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a();
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void notifyDMEvent(DMEvent r1) {
        d.h.b.o.e(r1, "event");
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r1);
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void replyComplexAskUser(String r2, String r3, String r4, Map<Object, Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r1 = getRunningMessageIdForReferenceId(r2);
        ComplexTaskEvent.RecieveComplexClarify r7 = null;
        if (r1 == null) goto L5;
        TaskId r8 = TaskId.Companion.a(r1, TaskType.COMPLEX);
    L6:
        if (r8 == null) goto L8;
        r7 = new ComplexTaskEvent.RecieveComplexClarify(r8, ao.a(s.a("clarify_message_reply", r4)));
    L8:
        if (r7 == null) goto L11;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r7, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void notifyOAutoDied() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(getCurrentDMState().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        State r1 = (State) ZeusTransformUtils.preCheckCast(r0.next(), State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, OAutoTaskState.class) == false) goto L4;
        kotlinx.coroutines.i.a(this.scope, null, null, (m) ZeusTransformUtils.preCheckCast(new g(r1, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L4
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void cancelTask(TaskState r3) {
        d.h.b.o.e(r3, "task");
        TaskInfo r0 = r3.getTaskInfo();
        if (r0 == null) goto L5;
        cancelTask(r0);
        return;
    L5:
        DialogStateManagerImpl r2 = (DialogStateManagerImpl) ZeusTransformUtils.preCheckCast(this, DialogStateManagerImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "cancelTask taskInfo is null " + r3.getTaskId());
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void cancelTask(TaskInfo r5) {
        d.h.b.o.e(r5, "task");
        TaskId r4 = r5.getTaskId();
        TaskType r6 = r5.getTaskType();
        int r7 = b.f22564a[r6.ordinal()];
        if (r7 == 1) goto L10;
        if (r7 != 2) goto L6;
        OAutoTaskEvent.TaskForceCompleted r8 = new OAutoTaskEvent.TaskForceCompleted(r4, null, 2, null);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r8, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (r7 != 3) goto L14;
        ComplexTaskEvent.InterruptTask r9 = new ComplexTaskEvent.InterruptTask(r4, null, 2, null);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r9, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        return;
    L10:
        SimpleTaskEvent.TaskCompleted r10 = new SimpleTaskEvent.TaskCompleted(r4, null, 2, null);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r10, DMEvent.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void replyOmniAskUser(String r5, String r6, Map<Object, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(TAG, "replyOmniAskUser id:" + r5 + " replyContent:" + r6);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(getCurrentDMState().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        ComplexTaskEvent.RecieveComplexClarify r0 = null;
        if (r4.hasNext() == false) goto L19;
        Object r9 = r4.next();
        State r2 = (State) ZeusTransformUtils.preCheckCast(r9, State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, TaskState.class) == false) goto L16;
        TaskInfo r3 = ((TaskState) ZeusTransformUtils.preCheckCast(r2, TaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r3 == null) goto L12;
        Map<String, String> r10 = r3.getExt();
        if (r10 == null) goto L12;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L14:
        if (d.h.b.o.a(r11, r5) == false) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L3;
    L20:
        State r13 = (State) ZeusTransformUtils.preCheckCast(r9, State.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L25;
        TaskId r14 = r13.getTaskId();
        if (r14 == null) goto L25;
        r0 = new ComplexTaskEvent.RecieveComplexClarify(r14, ao.a(s.a("clarify_message_reply", r6)));
    L25:
        if (r0 == null) goto L33;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(r0, DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L33:
        return;
    L12:
        r11 = null;
    L16:
        r12 = false;
        goto L17
    L19:
        r9 = null;
        goto L20
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public boolean isLogin() {
        return this.isLogin;
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void setLogin(boolean r1) {
        this.isLogin = r1;
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public TaskInfo getStateMachinesFromQuestionId(String r1) {
        d.h.b.o.e(r1, "questionId");
        return com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r1);
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void notifyStopOAuto(String r4) {
        forceStopDMTaskIfNeeded(null, r4, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI, "notifyStopOAuto");
    }

    public final void handleMessageSendSuccess(IMMessage r12) {
        d.h.b.o.e(r12, "message");
        Map<String, String> r0 = r12.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        Map<String, String> r3 = r12.getExt();
        if (r3 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
    L10:
        Map<String, String> r5 = r12.getExt();
        if (r5 == null) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
    L14:
        Map<String, String> r7 = r12.getExt();
        if (r7 == null) goto L17;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L18:
        ILogDepend.Companion.i(TAG, "handleMessageSendSuccess " + r1 + ' ' + r4 + " [" + r6 + "] omnitaskId: " + r8);
        if (d.h.b.o.a(r1, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L39;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r9 = false;
        if (r2 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == true) goto L31;
        if (d.h.b.o.a(r4, "start_auto_gui") == true) goto L31;
        return;
    L31:
        if (d.h.b.o.a(r6, r12.getMessageId()) == true) goto L38;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L35;
    L36:
        r9 = true;
    L37:
        if (r9 == true) goto L38;
        return;
    L35:
        if (r11.length() != 0) goto L37;
    L38:
        ILogDepend.Companion.i(TAG, "handleMessageSendSuccess " + r1 + ' ' + r4 + ' ' + r6);
        createDMTaskAndStart(r12.getMessageId(), r12, TaskType.OAUTO);
        return;
    L23:
        if (r2.length() == 0) goto L26;
        r10 = false;
        goto L27
    L39:
        if (r8 == null) goto L56;
        Map<String, String> r13 = r12.getExt();
        if (r13 == null) goto L43;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get("o_omni_intention"), String.class, "com.obric.aiagent.plugin");
    L44:
        ILogDepend.Companion.i(TAG, "handle send omni " + r14);
        if (d.h.b.o.a(r14, "task_reply") == false) goto L55;
        Map<String, String> r15 = r12.getExt();
        if (r15 == null) goto L49;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.get("o_is_client_authenticated"), String.class, "com.obric.aiagent.plugin");
    L51:
        if (d.h.b.o.a(r16, "1") == true) goto L54;
        ILogDepend.Companion.i(TAG, "o_is_client_authenticated is not 1, return");
        return;
    L54:
        replyOmniAskUser(r8, new Gson().toJson(r12), null);
        return;
    L49:
        r16 = null;
        goto L51
    L55:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r12);
        return;
    L43:
        r14 = null;
        goto L44
    L56:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r12);
        return;
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void handleMessageReceiving(IMMessage r12) {
        Map<String, String> r0 = r12.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        Map<String, String> r3 = r12.getExt();
        if (r3 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
    L10:
        Map<String, String> r5 = r12.getExt();
        if (r5 == null) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
    L14:
        Map<String, String> r7 = r12.getExt();
        if (r7 == null) goto L17;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L18:
        String r9 = r12.getReplyId();
        if (r1 != null) goto L21;
        String r10 = "simple_task";
    L22:
        Map<String, String> r11 = r12.getExt();
        if (r11 == null) goto L27;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11.get("client_meta"), String.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L27;
        JSONObject r14 = new JSONObject(r13);
    L28:
        if (r14 != null) goto L30;
        new JSONObject();
    L30:
        TaskType r15 = (TaskType) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.api.statemachine.core.a.f22459a.d().get(r10), TaskType.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "handleMessageReceiving " + r1 + ' ' + r4 + " [" + r6 + "] taskId:" + r8 + " from message: " + r12.getMessageId());
        if (r15 == null) goto L64;
        if (r9 == null) goto L34;
        TaskId r2 = TaskId.Companion.a(r9, r15);
    L35:
        if (r2 == null) goto L65;
        int r16 = b.f22564a[r15.ordinal()];
        if (r16 != 1) goto L39;
        return;
    L39:
        if (r16 != 2) goto L41;
        if (r4 != null) goto L48;
        return;
    L48:
        switch(r4.hashCode()) {
            case -828741144: goto L62;
            case -480768389: goto L59;
            case 887183105: goto L55;
            case 1010421736: goto L51;
            default: goto L73;
        };
    L62:
        r4.equals("start_auto_gui");
        return;
    L73:
        return;
    L51:
        if (r4.equals("clarify_auto_gui") == false) goto L74;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.TriggerOAutoClarify(r2, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L74:
        return;
    L55:
        if (r4.equals("calluser_auto_gui") == false) goto L75;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.TriggerOAutoClarify(r2, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L75:
        return;
    L59:
        if (r4.equals("process_auto_gui") == false) goto L76;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.ReceiveOAutoClarify(r2, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L76:
        return;
    L41:
        if (r16 != 3) goto L45;
        if (r4 == null) goto L67;
        handleOmniTaskWhenReceiveMessage(r4, r12, r2);
        return;
    L67:
        return;
    L45:
        throw new k();
    L65:
        return;
    L34:
        r2 = null;
        goto L35
    L64:
        return;
    L27:
        r14 = null;
        goto L28
    L21:
        r10 = r1;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void handleOmniTaskWhenReceiveMessage(String r18, IMMessage r19, TaskId r20) {
        if (r18 != null) goto L5;
        return;
    L5:
        if (d.h.b.o.a(r18, "null") == true) goto L222;
        Map<String, String> r3 = r19.getExt();
        if (r3 == null) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L11:
        Map<String, String> r7 = r19.getExt();
        if (r7 == null) goto L14;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_pro_packet_idx"), String.class, "com.obric.aiagent.plugin");
    L16:
        if (d.h.b.o.a(r18, "cancel_complex_task") == false) goto L18;
    L21:
        boolean r9 = true;
    L22:
        ISecureLogDepend.Companion r13 = ISecureLogDepend.Companion;
        StringBuilder r14 = new StringBuilder().append("progress: ");
        Map<String, String> r15 = r19.getExt();
        if (r15 == null) goto L25;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r15.get("o_complex_task_progress"), String.class, "com.obric.aiagent.plugin");
    L26:
        StringBuilder r12 = r14.append(r11).append(" description: ");
        Map<String, String> r16 = r19.getExt();
        if (r16 == null) goto L29;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.get("o_task_current_step_description"), String.class, "com.obric.aiagent.plugin");
    L30:
        r13.i(TAG, r12.append(r17).append(" index:").append(r8).append(" taskState:").append(r18).toString());
        if (r8 == null) goto L38;
        Integer r10 = d.o.o.d(r8);
        if (r10 == null) goto L38;
        if (com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(r20, ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue()) == true) goto L38;
        if (r9 == true) goto L38;
        return;
    L38:
        Map<String, String> r21 = r19.getExt();
        if (r21 == null) goto L45;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r21.get("o_complex_task_progress"), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L45;
        Double r6 = d.o.o.c(r5);
        if (r6 == null) goto L45;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, (int) ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).doubleValue());
    L45:
        Map<String, String> r22 = r19.getExt();
        if (r22 == null) goto L50;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.get("o_last_reply_message_id"), String.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L50;
        ILogDepend.Companion.i(TAG, "omni last reply id: " + r23);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, "o_last_reply_message_id", r23);
    L50:
        Map<String, String> r24 = r19.getExt();
        if (r24 == null) goto L55;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.get("o_task_current_step_description"), String.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L55;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, "o_task_current_step_description", r25);
    L55:
        Map<String, String> r26 = r19.getExt();
        if (r26 == null) goto L60;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.get("o_task_current_step_detail"), String.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L60;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, "o_task_current_step_detail", r27);
    L60:
        Map<String, String> r28 = r19.getExt();
        if (r28 == null) goto L65;
        String r29 = (String) ZeusTransformUtils.preCheckCast(r28.get("o_omni_task_finish_summary"), String.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L65;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, "o_omni_task_finish_summary", r29);
    L65:
        if (r4 == null) goto L67;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, "o_omni_task_id", r4);
    L67:
        String r110 = "";
        switch(r18.hashCode()) {
            case -794298911: goto L202;
            case -599445191: goto L184;
            case 2098442: goto L169;
            case 138500749: goto L165;
            case 298351218: goto L161;
            case 376375641: goto L153;
            case 840950759: goto L149;
            case 1058556962: goto L139;
            case 1127461489: goto L88;
            case 1767581592: goto L71;
            default: goto L223;
        };
    L223:
        return;
    L71:
        if (r18.equals("takeover_complex_task") == false) goto L224;
        Map<String, String> r0 = r19.getExt();
        if (r0 != null) goto L76;
        r0 = ao.b();
    L76:
        String r30 = (String) ZeusTransformUtils.preCheckCast(r0.get("take_over_reason"), String.class, "com.obric.aiagent.plugin");
        if (r30 != null) goto L79;
    L81:
        String r31 = null;
    L82:
        if (r31 == null) goto L85;
        Map r32 = ao.a(s.a("take_over_reason", r31));
        if (r32 == null) goto L85;
    L86:
        ILogDepend.Companion.i(TAG, "OccupyTakeOverTrace trigger taking over, taskId:" + r20 + ", messageId:" + r19.getMessageId() + ", takeOverReason:" + r31 + ", ext:" + r0);
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.TriggerComplexTakingOver(r20, r32), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L85:
        r32 = ao.b();
        goto L86
    L79:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L81;
        r31 = r30;
        goto L82
    L224:
        return;
    L88:
        if (r18.equals("clarify_complex_task") == false) goto L225;
        Map<String, String> r1 = r19.getExt();
        if (r1 == null) goto L94;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_complex_clarify_content"), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L94;
    L95:
        Map<String, String> r33 = r19.getExt();
        if (r33 == null) goto L99;
        String r34 = (String) ZeusTransformUtils.preCheckCast(r33.get("is_call_for_me_ask_user"), String.class, "com.obric.aiagent.plugin");
        if (r34 == null) goto L99;
    L100:
        Map<String, String> r35 = r19.getExt();
        if (r35 == null) goto L104;
        String r36 = (String) ZeusTransformUtils.preCheckCast(r35.get("o_complex_task_ask_user_scene"), String.class, "com.obric.aiagent.plugin");
        if (r36 == null) goto L104;
    L105:
        Map<String, String> r37 = r19.getExt();
        if (r37 == null) goto L109;
        String r38 = (String) ZeusTransformUtils.preCheckCast(r37.get("is_knowledge_ai_ask_user"), String.class, "com.obric.aiagent.plugin");
        if (r38 == null) goto L109;
    L110:
        Map<String, String> r111 = r19.getExt();
        if (r111 == null) goto L114;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111.get("o_complex_clarify_candidate"), String.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L114;
    L115:
        Map<String, String> r113 = r19.getExt();
        if (r113 == null) goto L119;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.get("o_complex_source_type"), String.class, "com.obric.aiagent.plugin");
        if (r114 == null) goto L119;
    L120:
        Map<String, String> r115 = r19.getExt();
        if (r115 == null) goto L126;
        String r116 = (String) ZeusTransformUtils.preCheckCast(r115.get("o_block_decision_source"), String.class, "com.obric.aiagent.plugin");
        if (r116 == null) goto L126;
        r110 = r116;
    L126:
        Map<String, String> r117 = r19.getExt();
        if (r117 == null) goto L130;
        String r118 = (String) ZeusTransformUtils.preCheckCast(r117.get("message_id_for_clarify"), String.class, "com.obric.aiagent.plugin");
        if (r118 == null) goto L130;
    L137:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.TriggerComplexClarify(r20, ao.a(new d.m[]{s.a("clarify_message_content", r2), s.a("is_call_for_me_ask_user", r34), s.a("o_complex_task_ask_user_scene", r36), s.a("is_knowledge_ai_ask_user", r38), s.a("o_complex_clarify_candidate", r112), s.a("o_complex_source_type", r114), s.a("message_id_for_clarify", r118), s.a("o_block_decision_source", r110)})), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L130:
        Map<String, String> r119 = r19.getExt();
        if (r119 == null) goto L133;
        String r120 = (String) ZeusTransformUtils.preCheckCast(r119.get("o_last_reply_message_id"), String.class, "com.obric.aiagent.plugin");
    L134:
        if (r120 != null) goto L136;
        r118 = r19.getMessageId();
        goto L137
    L136:
        r118 = r120;
        goto L137
    L133:
        r120 = null;
    L119:
        r114 = "";
    L114:
        r112 = "";
    L109:
        r38 = "";
    L104:
        r36 = "";
    L99:
        r34 = "";
    L94:
        r2 = "";
        goto L95
    L225:
        return;
    L139:
        if (r18.equals("queue_complex_task") == false) goto L226;
        Map<String, String> r39 = r19.getExt();
        if (r39 == null) goto L147;
        String r40 = (String) ZeusTransformUtils.preCheckCast(r39.get("o_task_queue_timestamp"), String.class, "com.obric.aiagent.plugin");
        if (r40 == null) goto L147;
        r110 = r40;
    L147:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.TriggerComplexQueueing(r20, ao.a(s.a("o_task_queue_timestamp", r110))), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L226:
        return;
    L149:
        if (r18.equals("clarify_ack_complex_task") == false) goto L227;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.RecieveComplexClarify(r20, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L227:
        return;
    L153:
        if (r18.equals("cancel_complex_task") == false) goto L228;
        Map<String, String> r41 = r19.getExt();
        if (r41 == null) goto L158;
        String r42 = (String) ZeusTransformUtils.preCheckCast(r41.get("stop_reason"), String.class, "com.obric.aiagent.plugin");
    L159:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.InterruptTask(r20, ao.a(new d.m[]{s.a("stop_reason", r42), s.a("message_reply", com.obric.capabilitykit.common.a.a().toJson(r19))})), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L158:
        r42 = null;
        goto L159
    L228:
        return;
    L161:
        if (r18.equals("broadcast_complex_task") == false) goto L229;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.PlayTTS(r20, ao.a(s.a("message_id_for_tts", r19.getMessageId()))), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L229:
        return;
    L165:
        if (r18.equals("thinkover_complex_task") == false) goto L230;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.ThinkingCompleted(r20, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L230:
        return;
    L169:
        if (r18.equals("calluser_complex_task") == false) goto L231;
        Map<String, String> r43 = r19.getExt();
        if (r43 == null) goto L175;
        String r44 = (String) ZeusTransformUtils.preCheckCast(r43.get("o_complex_call_user_content"), String.class, "com.obric.aiagent.plugin");
        if (r44 == null) goto L175;
    L176:
        Map<String, String> r45 = r19.getExt();
        if (r45 == null) goto L182;
        String r46 = (String) ZeusTransformUtils.preCheckCast(r45.get("o_block_decision_source"), String.class, "com.obric.aiagent.plugin");
        if (r46 == null) goto L182;
        r110 = r46;
    L182:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.TriggerComplexCalluser(r20, ao.a(new d.m[]{s.a("o_complex_call_user_content", r44), s.a("o_block_decision_source", r110)})), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L175:
        r44 = "";
        goto L176
    L231:
        return;
    L184:
        if (r18.equals("complete") == false) goto L232;
        Map<String, String> r47 = r19.getExt();
        if (r47 == null) goto L189;
        String r48 = (String) ZeusTransformUtils.preCheckCast(r47.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L190:
        Map<String, String> r49 = r19.getExt();
        if (r49 == null) goto L193;
        String r50 = (String) ZeusTransformUtils.preCheckCast(r49.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
    L194:
        d.m[] r51 = new d.m[2];
        r51[0] = s.a("message_reply", com.obric.capabilitykit.common.a.a().toJson(r19));
        Map<String, String> r52 = r19.getExt();
        if (r52 == null) goto L200;
        String r53 = (String) ZeusTransformUtils.preCheckCast(r52.get("o_complete_result"), String.class, "com.obric.aiagent.plugin");
        if (r53 == null) goto L200;
        r110 = r53;
    L200:
        r51[1] = s.a("o_complete_result", r110);
        finishDMTaskIfNeeded(r19.getReplyId(), r50, r48, ao.a(r51));
        return;
    L193:
        r50 = null;
        goto L194
    L189:
        r48 = null;
        goto L190
    L232:
        return;
    L202:
        if (r18.equals("think_complex_task") == false) goto L233;
        Map<String, String> r54 = r19.getExt();
        if (r54 == null) goto L210;
        String r55 = (String) ZeusTransformUtils.preCheckCast(r54.get("o_gui_package_name"), String.class, "com.obric.aiagent.plugin");
        if (r55 == null) goto L210;
        r110 = r55;
    L210:
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r20, ao.a(s.a("o_gui_package_name", r110)));
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new ComplexTaskEvent.ContinueThinking(r20, ao.a(s.a("o_gui_package_name", r110))), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L233:
        return;
    L29:
        r17 = null;
        goto L30
    L25:
        r11 = null;
        goto L26
    L18:
        if (d.h.b.o.a(r18, "complete") == true) goto L21;
        r9 = false;
        goto L22
    L14:
        r8 = null;
        goto L16
    L10:
        r4 = null;
        goto L11
    }

    private final void handleMessageReceived(IMMessage r11) {
        Map<String, String> r0 = r11.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L6:
        Map<String, String> r3 = r11.getExt();
        if (r3 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.get("o_task_state"), String.class, "com.obric.aiagent.plugin");
    L10:
        Map<String, String> r5 = r11.getExt();
        if (r5 == null) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get("o_reference_msg_id"), String.class, "com.obric.aiagent.plugin");
    L14:
        Map<String, String> r7 = r11.getExt();
        if (r7 == null) goto L17;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L17:
        Map<String, String> r9 = r11.getExt();
        if (r9 == null) goto L20;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.get("o_pro_packet_idx"), String.class, "com.obric.aiagent.plugin");
    L20:
        String r12 = r11.getReplyId();
        if (r1 != null) goto L23;
        String r13 = "simple_task";
    L24:
        ILogDepend.Companion.i(TAG, "handleMessageReceived oTaskType:" + r1 + " oTaskState:" + r4);
        Map<String, String> r14 = r11.getExt();
        if (r14 == null) goto L29;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.get("client_meta"), String.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L29;
        JSONObject r16 = new JSONObject(r15);
    L30:
        if (r16 != null) goto L32;
        new JSONObject();
    L32:
        TaskType r17 = (TaskType) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.api.statemachine.core.a.f22459a.d().get(r13), TaskType.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L70;
        if (r12 == null) goto L36;
        TaskId r18 = TaskId.Companion.a(r12, r17);
    L37:
        if (r18 == null) goto L71;
        int r19 = b.f22564a[r17.ordinal()];
        if (r19 != 1) goto L41;
        finishDMTaskIfNeeded(r11.getReplyId(), r6, r1, ao.a(s.a("message_reply", com.obric.capabilitykit.common.a.a().toJson(r11))));
        return;
    L41:
        if (r19 != 2) goto L43;
        if (r4 != null) goto L50;
        return;
    L50:
        switch(r4.hashCode()) {
            case -599445191: goto L65;
            case -480768389: goto L61;
            case 887183105: goto L57;
            case 1010421736: goto L53;
            default: goto L79;
        };
    L79:
        return;
    L53:
        if (r4.equals("clarify_auto_gui") == false) goto L80;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.TriggerOAutoClarify(r18, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L80:
        return;
    L57:
        if (r4.equals("calluser_auto_gui") == false) goto L81;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.TriggerOAutoClarify(r18, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L81:
        return;
    L61:
        if (r4.equals("process_auto_gui") == false) goto L82;
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a((DMEvent) ZeusTransformUtils.preCheckCast(new OAutoTaskEvent.ReceiveOAutoClarify(r18, null, 2, null), DMEvent.class, "com.obric.aiagent.plugin"));
        return;
    L82:
        return;
    L65:
        if (r4.equals("complete") == false) goto L83;
        finishDMTaskIfNeeded(r11.getReplyId(), r6, r1, ao.a(s.a("message_reply", com.obric.capabilitykit.common.a.a().toJson(r11))));
        return;
    L83:
        return;
    L43:
        if (r19 != 3) goto L47;
        if (r4 == null) goto L72;
        handleOmniTaskWhenReceiveMessage(r4, r11, r18);
        return;
    L72:
        return;
    L47:
        throw new k();
    L71:
        return;
    L36:
        r18 = null;
        goto L37
    L70:
        return;
    L29:
        r16 = null;
        goto L30
    L23:
        r13 = r1;
        goto L24
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void createDMTaskAndStart(String r22, IMMessage r23, TaskType r24) {
        d.h.b.o.e(r22, "messageId");
        d.h.b.o.e(r23, DownloadConstants.QUERY_KEY);
        d.h.b.o.e(r24, "taskType");
        TaskId r15 = TaskId.Companion.a(r22, r24);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a().getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        if (d.h.b.o.a(((State) ZeusTransformUtils.preCheckCast(r1.next(), State.class, "com.obric.aiagent.plugin")).getTaskId(), r15) == false) goto L9;
        r3 = true;
    L14:
        if (r3 == false) goto L17;
        ILogDepend.Companion.i(TAG, "no need createDMTask " + r15 + " exist");
        return;
    L17:
        TaskInfo r9 = new TaskInfo(r15, r24, r23, 0, r22, null, null, 0, 232, null);
        ILogDepend.Companion.i(TAG, "createDMTaskAndStart " + r15 + ' ' + r24);
        int r2 = b.f22564a[r24.ordinal()];
        if (r2 != 1) goto L20;
        com.obric.assistant.dm.impl.statemachine.a.e r4 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r22, r15, r23);
        if (r4 == null) goto L41;
        r4.a(r15, r9);
        return;
    L41:
        return;
    L20:
        if (r2 != 2) goto L22;
        com.obric.assistant.dm.impl.statemachine.a.d r5 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.b(r22, r15, r23);
        if (r5 == null) goto L39;
        r5.a(r15, r9);
        return;
    L39:
        return;
    L22:
        if (r2 != 3) goto L42;
        com.obric.assistant.dm.impl.statemachine.a.a r6 = com.obric.assistant.dm.impl.statemachine.a.c.f22509a.c(r22, r15, r23);
        if (r6 == null) goto L37;
        r6.a(r15, r9);
        return;
    L37:
        return;
    L42:
        return;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager
    public void clearAllOmniTask(Map<String, String> r2) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "extra");
        com.obric.assistant.dm.impl.statemachine.a.c.f22509a.a(r1);
    }

    private final Object findMessageByMsgId(final String r5, d.c.d<? super IMMessage> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r7), 1);
        r0.e();
        final n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r3 == null) goto L5;
        r3.findMessagebyId(r5, (IFlowFindMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new DialogStateManagerImpl$findMessageByMsgId$2$1(r2, r5), IFlowFindMessageCallbackIDL.class, "com.obric.aiagent.plugin"));
    L6:
        Object r4 = r0.h();
        if (r4 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r7);
    L9:
        return r4;
    L5:
        DialogStateManagerImpl r8 = (DialogStateManagerImpl) ZeusTransformUtils.preCheckCast(this, DialogStateManagerImpl.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "findMessageByMsgId IPC not available");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r9.resumeWith(d.n.f(null));
        goto L6
    }
}
