package com.obric.agent.autoaction;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.agent.utils.t;
import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.assistant.dm.api.statemachine.core.ComplexTaskState;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.OAutoTaskState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.funcall_api.bean.IntentAppAction;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.b.aa;
import d.h.b.h;
import d.m;
import d.m.c;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AutoActionServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoActionServiceImpl implements IAutoActionService {
    public static final a Companion = null;
    private static final String O_AUTO_OLD_PACKAGE_NAME = "com.obric.autoaction";
    private static final String O_AUTO_PACKAGE_NAME = "com.larus.nova";
    private static final String O_AUTO_SERVICE_NAME = "com.obric.autoaction.presentation.FloatingWindowService";
    private static final String TAG = "AutoActionServiceImpl";
    private final Application context;
    private Map<String, m<Boolean, StateInfo>> mAssistantState;
    private final am mainScope;
    private IAssistantInteractionListenerIDL oAutoListener;

    /* JADX INFO: compiled from: AutoActionServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionServiceImpl.kt */
    @f(b = "AutoActionServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.autoaction.AutoActionServiceImpl$init$1")
    static final class b extends l implements d.h.a.m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoActionServiceImpl f14241b;

        b(AutoActionServiceImpl r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f14241b = r3;
            super(2, r5);
        }

        public static /* synthetic */ void lambda$QbcUInymhf9wAj9JucjbQK42xQw(AutoActionServiceImpl r0, IFlowUiIDL r1) {
            a(r0, r1);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f14241b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            d.c.a.b.a();
            if (this.f14240a != 0) goto L7;
            o.a(r7);
            c r0 = aa.b(IFlowUiIDL.class);
            final AutoActionServiceImpl r6 = this.f14241b;
            aw.a(r0, false, false, new $$Lambda$AutoActionServiceImpl$b$QbcUInymhf9wAj9JucjbQK42xQw(r6), 3, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final void a(AutoActionServiceImpl r4, IFlowUiIDL r5) {
            IFlowUiIDL r6 = (IFlowUiIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowUiIDL.class, "com.obric.aiagent.plugin");
            r6.setAssistantInteractionListener("com.obric.autoaction", AutoActionServiceImpl.access$getOAutoListener$p(r4));
            m r7 = (m) ZeusTransformUtils.preCheckCast(AutoActionServiceImpl.access$getMAssistantState$p(r4).get("com.obric.autoaction"), m.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L5;
            r6.notifyAssistantState("com.obric.autoaction", ((Boolean) ZeusTransformUtils.preCheckCast(r7.a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (StateInfo) ZeusTransformUtils.preCheckCast(r7.b(), StateInfo.class, "com.obric.aiagent.plugin"));
        L5:
            ILogDepend.Companion.i(AutoActionServiceImpl.TAG, "Assistant onIPCRegister!");
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoActionServiceImpl() {
        this.context = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        this.mAssistantState = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.mainScope = an.a();
    }

    public static final /* synthetic */ Map access$getMAssistantState$p(AutoActionServiceImpl r0) {
        return r0.mAssistantState;
    }

    public static final /* synthetic */ IAssistantInteractionListenerIDL access$getOAutoListener$p(AutoActionServiceImpl r0) {
        return r0.oAutoListener;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void init() {
        i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void onFlowUnbind() {
        ILogDepend.Companion.i(TAG, "Assistant death!");
        IAssistantInteractionListenerIDL r3 = this.oAutoListener;
        if (r3 == null) goto L6;
        r3.onAssistantDied();
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void onFlowBind() {
        ILogDepend.Companion.i(TAG, "Assistant binder!");
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public boolean isAutoActionInstalled() {
        return t.f16075a.a((Context) ZeusTransformUtils.preCheckCast(this.context, Context.class, "com.obric.aiagent.plugin"), "com.larus.nova", O_AUTO_SERVICE_NAME);
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public boolean scheduleTimerTask(int r12, String r13, String r14, String r15) {
        d.h.b.o.e(r13, "packageName");
        if (d.h.b.o.a(r13, "com.larus.nova") == false) goto L9;
        if (r14 == null) goto L9;
        if (isAutoActionInstalled() == false) goto L9;
        com.obric.agent.utils.b.f15994a.a(new BaseSystemAutoActionIntent().getName(), com.obric.agent.utils.b.f15994a.a(new SystemAutoActionParams(r14, String.valueOf(r12), null, null, null, null, null, false, BDImageUploader.MessageIsPreHeatResultUsed, null)), null, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
        ILogDepend.Companion.i(TAG, "scheduleTimerTask");
        return true;
    L9:
        return false;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void openAssistantInputPanel(StateInfo r3, boolean r4) {
        d.h.b.o.e(r3, "stateInfo");
        ILogDepend.Companion.d(TAG, "openAssistantInputPanel");
        IFlowUiIDL r2 = aw.a(aa.b(IFlowUiIDL.class));
        if (r2 == null) goto L6;
        r2.openAssistantInputPanel("com.obric.autoaction", r3, r4);
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void closeAssistantInputPanel() {
        ILogDepend.Companion.i(TAG, "closeAssistantInputPanel");
        IFlowUiIDL r2 = aw.a(aa.b(IFlowUiIDL.class));
        if (r2 == null) goto L6;
        r2.closeAssistantInputPanel("com.obric.autoaction");
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void notifyAssistantState(boolean r4, StateInfo r5) {
        d.h.b.o.e(r5, "stateInfo");
        ILogDepend.Companion.i(TAG, "notifyAssistantState");
        this.mAssistantState.put("com.obric.autoaction", new m(Boolean.valueOf(r4), r5));
        IFlowUiIDL r3 = aw.a(aa.b(IFlowUiIDL.class));
        if (r3 == null) goto L6;
        r3.notifyAssistantState("com.obric.autoaction", r4, r5);
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void setAssistantInteractionListener(IAssistantInteractionListenerIDL r4) {
        IAssistantInteractionListenerIDL r5 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r4, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(TAG, "setAssistantInteractionListener");
        this.oAutoListener = r5;
        IFlowUiIDL r3 = aw.a(aa.b(IFlowUiIDL.class));
        if (r3 == null) goto L6;
        r3.setAssistantInteractionListener("com.obric.autoaction", r5);
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void onAssistantInteractionListenerDied() {
        ILogDepend.Companion.d(TAG, "onAssistantInteractionListenerDied");
        StateInfo r0 = new StateInfo(0, null, null, null, 0, false, false, null, ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION, null);
        this.mAssistantState.put("com.obric.autoaction", new m(false, r0));
        notifyAssistantState(false, r0);
        closeAssistantInputPanel();
        this.oAutoListener = null;
        IFlowUiIDL r1 = aw.a(aa.b(IFlowUiIDL.class));
        if (r1 == null) goto L5;
        r1.setAssistantInteractionListener("com.obric.autoaction", this.oAutoListener);
    L5:
        IDialogStateManager r15 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L8;
        r15.notifyOAutoDied();
    L8:
        IFlowUiIDL r16 = aw.a(aa.b(IFlowUiIDL.class));
        if (r16 == null) goto L12;
        r16.notifyOAutoDied();
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void replyToAutoAction(String r4) {
        d.h.b.o.e(r4, "content");
        ILogDepend.Companion.d(TAG, "replyToAutoAction " + this.oAutoListener + ", content: " + r4.length());
        IAssistantInteractionListenerIDL r3 = this.oAutoListener;
        if (r3 == null) goto L6;
        r3.onReply(r4);
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void addExtForOAuto(IntentAppAction r4, IntentResult<?> r5, IntentAppAction r6) {
        d.h.b.o.e(r4, Ext.KEY_REQUEST);
        d.h.b.o.e(r5, "intentResult");
        d.h.b.o.e(r6, "result");
        ConcurrentHashMap<String, String> r3 = r5.getExt();
        if (r3 == null) goto L18;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.get("obric_session_info"), String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        return;
    L7:
        if (r6.getExt() != null) goto L9;
        r6.setExt(new ConcurrentHashMap());
    L9:
        ConcurrentHashMap<String, String> r8 = r6.getExt();
        if (r8 == null) goto L20;
        r8.put("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI);
        r8.put("o_reference_msg_id", String.valueOf(r4.getQuestionId()));
        com.obric.agent.autoaction.a r9 = (com.obric.agent.autoaction.a) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r7, com.obric.agent.autoaction.a.class), com.obric.agent.autoaction.a.class, "com.obric.aiagent.plugin");
        if (r9.a() != 7) goto L15;
        r8.put("o_task_state", "calluser_auto_gui");
        return;
    L15:
        if (r9.a() != 8) goto L22;
        r8.put("o_task_state", "clarify_auto_gui");
        return;
    L22:
        return;
    L20:
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void requestSendMessage(String r3, String r4, Map<String, String> r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "content");
        d.h.b.o.e(r4, DBHelper.BATTERY_COL_SCENE);
        ISecureLogDepend.Companion.i(TAG, "requestSendMessage " + r3.length() + ", scene: " + r4 + ", ext: " + r2);
        IFlowMessageIDL r6 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r6 == null) goto L6;
        r6.sendMessage(null, r3, r4, "card");
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void notifyStopAutoAction(String r3, String r4) {
        d.h.b.o.e(r4, "reason");
        ILogDepend.Companion.d(TAG, "notifyStopAutoAction messageId: " + r3 + ", reason: " + r4);
        if (r3 == null) goto L11;
        IJobManagerApi r2 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        r2.stopRunningJobs(r3, r4);
    L7:
        IDialogStateManager r5 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        r5.notifyStopOAuto(r3);
        return;
    L12:
        return;
    }

    @Override // com.obric.agent.autoaction.IAutoActionService
    public void notifyCloseAutoGUISwitch() {
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        DMState r1 = r0.getCurrentDMState();
    L6:
        ILogDepend.Companion.d(TAG, "notifyCloseAutoGUISwitch");
        if (r1 == null) goto L38;
        List<State> r2 = r1.getActiveTasks();
        if (r2 == null) goto L47;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r3.hasNext() == false) goto L48;
        State r4 = (State) ZeusTransformUtils.preCheckCast(r3.next(), State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ComplexTaskState.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r4, OAutoTaskState.class) == false) goto L12;
        TaskInfo r5 = ((OAutoTaskState) ZeusTransformUtils.preCheckCast(r4, OAutoTaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r5 == null) goto L36;
        IMMessage r6 = r5.getMessage();
        if (r6 == null) goto L36;
        String r7 = r6.getMessageId();
    L37:
        notifyStopAutoAction(r7, "close switch");
        ILogDepend.Companion.d(TAG, "notifyCloseAutoGUISwitch stop oAutoTaskId: " + r7);
    L36:
        r7 = null;
        goto L37
    L15:
        TaskInfo r8 = ((ComplexTaskState) ZeusTransformUtils.preCheckCast(r4, ComplexTaskState.class, "com.obric.aiagent.plugin")).getTaskInfo();
        if (r8 == null) goto L20;
        IMMessage r9 = r8.getMessage();
        if (r9 == null) goto L20;
        String r10 = r9.getMessageId();
    L21:
        if (r10 == null) goto L25;
        IFlowNetworkIDL r11 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
        if (r11 == null) goto L25;
        r11.notifyStopComplexTaskByHttp(Long.parseLong(r10));
    L25:
        IComplexTaskService r12 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L28;
        r12.notifyStopComplexTask(r10, "close switch");
    L28:
        ILogDepend.Companion.d(TAG, "notifyCloseAutoGUISwitch stop complexTaskId: " + r10);
    L20:
        r10 = null;
        goto L21
    L48:
        return;
    L47:
        return;
    L38:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
