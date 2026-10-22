package com.obric.aiagent.executionengine.eventstaskmanager;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.ipc.IAgentIpcManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.eventkit.eventstaskmanager.IAssistantSessionStateListener;
import com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.o;
import d.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.i;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TaskManagerServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskManagerServiceImpl extends PluginService {
    public static final a Companion = null;
    private static final long IPC_READY_TIMEOUT_MS = 10000;
    private static final String TAG = "TaskManagerServiceImpl";
    private final c dmStateListener;
    private final TaskManagerServiceImpl$flowTTSListener$1 flowTTSListener;
    private final ReentrantReadWriteLock lock;
    private final TaskManagerServiceImpl$mBinder$1 mBinder;
    private final am mainScope;
    private int sessionState;
    private final RemoteCallbackList<IAssistantSessionStateListener> stateListeners;
    private final RemoteCallbackList<IAssistantTtsStateListener> ttsListeners;
    private int ttsState;

    /* JADX INFO: compiled from: TaskManagerServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskManagerServiceImpl.kt */
    @f(b = "TaskManagerServiceImpl.kt", c = {869}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerServiceImpl$bringAssistantToFrontIfBackground$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16605b;

        b(String r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f16605b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f16605b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16604a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            IFlowUiIDL r7 = aw.a(aa.b(IFlowUiIDL.class));
            if (r7 == null) goto L19;
            if (d.h.b.o.a(this.f16605b, "half") == false) goto L16;
            int r5 = com.obric.agent.h.f14566c.ordinal();
        L17:
            r7.openChatActivity(r5);
            goto L19
        L16:
            r5 = com.obric.agent.h.f14567d.ordinal();
        L19:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f16604a = 1;
            if (ax.a(100, r8) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskManagerServiceImpl.kt */
    public static final class c implements com.obric.assistant.dm.api.statemachine.core.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskManagerServiceImpl f16606a;

        public static /* synthetic */ x lambda$AdLpZRaNv1CFVGwNm4BF9a_dQ48(TaskManagerServiceImpl r0, IAssistantSessionStateListener r1) {
            return a(r0, r1);
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1) {
            d.h.b.o.e(r1, "taskInfo");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1, State r2, DMEvent r3, Exception r4) {
            d.h.b.o.e(r1, "taskInfo");
            d.h.b.o.e(r2, "currentState");
            d.h.b.o.e(r4, "exception");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1, State r2, State r3, DMEvent r4) {
            d.h.b.o.e(r1, "taskInfo");
            d.h.b.o.e(r3, "newState");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void b(TaskInfo r1) {
            d.h.b.o.e(r1, "taskInfo");
        }

        c(TaskManagerServiceImpl r3) {
            this.f16606a = (TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r3, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(DMState r4) {
            d.h.b.o.e(r4, "status");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TaskManagerServiceImpl.TAG, "onDMStateChanged: " + r4.isIdle());
            int r5 = TaskManagerServiceImpl.access$computeAssistantSessionState(this.f16606a, r4);
            if (TaskManagerServiceImpl.access$getSessionState$p(this.f16606a) == r5) goto L10;
            ReentrantReadWriteLock r0 = TaskManagerServiceImpl.access$getLock$p(this.f16606a);
            final TaskManagerServiceImpl r3 = this.f16606a;
            ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
            r1.lock();
            TaskManagerServiceImpl.access$setSessionState$p(r3, r5);     // Catch: Throwable -> L7
            com.obric.aiagent.ipc.utils.f.a(TaskManagerServiceImpl.access$getStateListeners$p(r3), new $$Lambda$TaskManagerServiceImpl$c$AdLpZRaNv1CFVGwNm4BF9a_dQ48(r3));     // Catch: Throwable -> L7
            x r6 = x.f38692a;     // Catch: Throwable -> L7
            r1.unlock();
            return;
        L7:
            th = move-exception;
            r1.unlock();
            throw th;
        }

        private static final x a(TaskManagerServiceImpl r2, IAssistantSessionStateListener r3) {
            TaskManagerServiceImpl r4 = (TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin");
            IAssistantSessionStateListener r5 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "it");
            r5.onAssistantSessionStateChanged(TaskManagerServiceImpl.access$getSessionState$p(r4));
            return x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ void lambda$P6LednVNKqHvpoJDunB9GufT3ws(TaskManagerServiceImpl r0, IFlowAssistantStateIDL r1) {
        onCreate$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$kjLZoQjzh5jN66ma2i-_2PcP_LM, reason: not valid java name */
    public static /* synthetic */ x m162lambda$kjLZoQjzh5jN66ma2i_2PcP_LM(AtomicBoolean r0, CountDownLatch r1, boolean r2) {
        return ensureIpcReadyBlocking$lambda$0(r0, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.aiagent.executionengine.eventstaskmanager.TaskManagerServiceImpl$mBinder$1] */
    public TaskManagerServiceImpl() {
        this.mainScope = an.a();
        this.ttsListeners = new RemoteCallbackList();
        this.stateListeners = new RemoteCallbackList();
        this.lock = new ReentrantReadWriteLock();
        this.flowTTSListener = new TaskManagerServiceImpl$flowTTSListener$1(this);
        this.dmStateListener = new c(this);
        this.mBinder = new TaskManagerServiceImpl$mBinder$1(this);
    }

    public static final /* synthetic */ void access$assertTaskBinderAccessDisabled(TaskManagerServiceImpl r2, String r3) {
        ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).assertTaskBinderAccessDisabled(r3);
    }

    public static final /* synthetic */ void access$bringAssistantToFrontIfBackground(TaskManagerServiceImpl r2, String r3) {
        ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).bringAssistantToFrontIfBackground(r3);
    }

    public static final /* synthetic */ int access$computeAssistantSessionState(TaskManagerServiceImpl r2, DMState r3) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).computeAssistantSessionState(r3);
    }

    public static final /* synthetic */ boolean access$ensureIpcReadyBlocking(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).ensureIpcReadyBlocking();
    }

    public static final /* synthetic */ ReentrantReadWriteLock access$getLock$p(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).lock;
    }

    public static final /* synthetic */ int access$getSessionState$p(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).sessionState;
    }

    public static final /* synthetic */ RemoteCallbackList access$getStateListeners$p(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).stateListeners;
    }

    public static final /* synthetic */ RemoteCallbackList access$getTtsListeners$p(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).ttsListeners;
    }

    public static final /* synthetic */ int access$getTtsState$p(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).ttsState;
    }

    public static final /* synthetic */ boolean access$isEnterpriseAccount(TaskManagerServiceImpl r2) {
        return ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).isEnterpriseAccount();
    }

    public static final /* synthetic */ void access$setSessionState$p(TaskManagerServiceImpl r2, int r3) {
        ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).sessionState = r3;
    }

    public static final /* synthetic */ void access$setTtsState$p(TaskManagerServiceImpl r2, int r3) {
        ((TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin")).ttsState = r3;
    }

    private final void assertTaskBinderAccessDisabled(String r3) {
        if (IAppContext.Companion.isTestChannel() == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Task Binder method " + r3 + " is disabled; use manager-api SPI instead.");
    }

    private final boolean ensureIpcReadyBlocking() {
        IAgentIpcManager r7 = IAgentIpcManager.Companion.a();
        if (r7 != null) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "ensureIpcReadyBlocking: IAgentIpcManager unavailable");
        return false;
    L6:
        final CountDownLatch r2 = new CountDownLatch(1);
        final AtomicBoolean r4 = new AtomicBoolean(false);
        r7.checkIpcReady(new $$Lambda$TaskManagerServiceImpl$kjLZoQjzh5jN66ma2i_2PcP_LM(r4, r2));     // Catch: Throwable -> L14
        boolean r8 = r2.await(IPC_READY_TIMEOUT_MS, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L14
        if (r8 == true) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "ensureIpcReadyBlocking: timeout after 10000ms");     // Catch: Throwable -> L14
    L10:
        if (r8 == false) goto L19;
        if (r4.get() == true) goto L21;
        return false;
    L21:
        return true;
    L19:
        return false;
    L14:
        th = move-exception;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "ensureIpcReadyBlocking error: " + th.getMessage());
        return false;
    }

    private static final x ensureIpcReadyBlocking$lambda$0(AtomicBoolean r0, CountDownLatch r1, boolean r2) {
        r0.set(true);
        r1.countDown();
        return x.f38692a;
    }

    private final boolean isEnterpriseAccount() {
        IFlowAppIntentIDL r2 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r2 == null) goto L8;
        if (r2.isEnterpriseAccount() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final int computeAssistantSessionState(DMState r4) {
        IFlowVoiceInteractionIDL r3 = com.obric.aiagent.assistant.idl.ax.a(aa.b(IFlowVoiceInteractionIDL.class));
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r3 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r2 == false) goto L15;
        return 2;
    L15:
        if (r5 == false) goto L17;
        return 3;
    L17:
        if (r4 != null) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == true) goto L24;
        return 1;
    L24:
        return 0;
    L19:
        if (r4.isIdle() != true) goto L21;
        r6 = true;
        goto L22
    L10:
        if (r3.isInteractionSessionStateListening() != true) goto L12;
        r5 = true;
        goto L13
    L5:
        if (r3.isInRealtimeCalling() != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void bringAssistantToFrontIfBackground(String r9) {
        IFlowAppStateIDL r0 = s.a(aa.b(IFlowAppStateIDL.class));
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L11;
        i.a(this.mainScope, null, null, (m) ZeusTransformUtils.preCheckCast(new b(r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L11:
        return;
    L5:
        if (r0.isAppBackground() != true) goto L7;
        goto L7
    }

    public void onCreate() {
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.registerDMStateListener((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(this.dmStateListener, com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin"));
    L5:
        u.a(aa.b(IFlowAssistantStateIDL.class), false, false, new $$Lambda$TaskManagerServiceImpl$P6LednVNKqHvpoJDunB9GufT3ws(this), 3, null);
    }

    private static final void onCreate$lambda$1(TaskManagerServiceImpl r2, IFlowAssistantStateIDL r3) {
        TaskManagerServiceImpl r4 = (TaskManagerServiceImpl) ZeusTransformUtils.wrapperContextForParams(r2, TaskManagerServiceImpl.class, "com.obric.aiagent.plugin");
        IFlowAssistantStateIDL r5 = (IFlowAssistantStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantStateIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "it");
        r5.registerTTSStateListener((IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.preCheckCast(r4.flowTTSListener, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin"));
    }

    public IBinder onBind(Intent r2) {
        d.h.b.o.e(r2, MemorySourceLinkType.INTENT);
        return (IBinder) ZeusTransformUtils.preCheckCast(this.mBinder, IBinder.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        an.a(this.mainScope, null, 1, null);
        super/*android.app.Service*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r1, int r2, int r3) {
        INVOKESTATIC_com_obric_aiagent_executionengine_eventstaskmanager_TaskManagerServiceImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "onStartCommand result: " + super/*android.app.Service*/.onStartCommand(r1, r2, r3));
        return 2;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_executionengine_eventstaskmanager_TaskManagerServiceImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
