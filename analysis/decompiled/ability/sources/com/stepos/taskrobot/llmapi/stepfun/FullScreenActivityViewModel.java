package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.view.ViewModel;
import android.view.ViewModelKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.t;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 K2\u00020\u0001:\u0001KB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0018\u0010\u0012J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001cJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\u001cJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\u001cR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\"\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\u0012R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010)R\u001f\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0*8\u0006¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010)R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0*8\u0006¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010)R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130*8\u0006¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010)R\u001f\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0*8\u0006¢\u0006\f\n\u0004\b9\u0010,\u001a\u0004\b:\u0010.R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010)R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0006¢\u0006\f\n\u0004\b<\u0010,\u001a\u0004\b<\u0010.R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010J\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "Lm9/z;", "timerScope", AppAgent.CONSTRUCT, "(Lm9/z;)V", "", "enabled", "LC7/r;", "setTouchEnabled", "(Z)V", "Lstepai/aios/guiagent/model/SessionState;", "state", "setTaskState", "(Lstepai/aios/guiagent/model/SessionState;)V", "", "explain", "setStepExplain", "(Ljava/lang/String;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;", TypedValues.CycleType.S_WAVE_PHASE, "setOverlayPhase", "(Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;)V", "text", "setPassivePromptExplainSnapshot", "dismissed", "setOverlayDismissed", "resume", "()V", "startAckCountdown", "cancelAckCountdown", "startResumeFallback", "cancelResumeFallback", "Lm9/z;", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "setTaskId", "Lp9/j;", "_touchEnabled", "Lp9/j;", "Lp9/t;", "touchEnabled", "Lp9/t;", "getTouchEnabled", "()Lp9/t;", "_taskState", "taskState", "getTaskState", "_stepExplain", "stepExplain", "getStepExplain", "_overlayPhase", "overlayPhase", "getOverlayPhase", "_passivePromptExplainSnapshot", "passivePromptExplainSnapshot", "getPassivePromptExplainSnapshot", "_isOverlayDismissed", "isOverlayDismissed", "", "takeoverIdleTimeoutMs", "J", "getTakeoverIdleTimeoutMs", "()J", "setTakeoverIdleTimeoutMs", "(J)V", "Lm9/c0;", "ackCountdownJob", "Lm9/c0;", "resumeFallbackJob", "getScope", "()Lm9/z;", "scope", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FullScreenActivityViewModel extends ViewModel {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long OVERLAY_RESUME_FALLBACK_MS = 8000;
    private final p9.j _isOverlayDismissed;
    private final p9.j _overlayPhase;
    private final p9.j _passivePromptExplainSnapshot;
    private final p9.j _stepExplain;
    private final p9.j _taskState;
    private final p9.j _touchEnabled;
    private c0 ackCountdownJob;
    private final t isOverlayDismissed;
    private final t overlayPhase;
    private final t passivePromptExplainSnapshot;
    private c0 resumeFallbackJob;
    private final t stepExplain;
    private long takeoverIdleTimeoutMs;
    private String taskId;
    private final t taskState;
    private final InterfaceC1733z timerScope;
    private final t touchEnabled;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivityViewModel$Companion;", "", AppAgent.CONSTRUCT, "()V", "OVERLAY_RESUME_FALLBACK_MS", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel$startAckCountdown$1", f = "FullScreenActivityViewModel.kt", l = {100}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel$startAckCountdown$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivityViewModel.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                this.label = 1;
                if (kotlinx.coroutines.a.f(5000L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            if (((kotlinx.coroutines.flow.i) FullScreenActivityViewModel.this._overlayPhase).getValue() == OverlayPhase.TAKEOVER_ACK) {
                ((kotlinx.coroutines.flow.i) FullScreenActivityViewModel.this._overlayPhase).i(OverlayPhase.MINI);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel$startResumeFallback$1", f = "FullScreenActivityViewModel.kt", l = {116}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel$startResumeFallback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11581 extends SuspendLambda implements S7.n {
        int label;

        public C11581(H7.c<? super C11581> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivityViewModel.this.new C11581(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                this.label = 1;
                if (kotlinx.coroutines.a.f(FullScreenActivityViewModel.OVERLAY_RESUME_FALLBACK_MS, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            FullScreenActivityViewModel.this.resume();
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11581) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FullScreenActivityViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final InterfaceC1733z getScope() {
        InterfaceC1733z interfaceC1733z = this.timerScope;
        return interfaceC1733z == null ? ViewModelKt.getViewModelScope(this) : interfaceC1733z;
    }

    public final void cancelAckCountdown() {
        c0 c0Var = this.ackCountdownJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.ackCountdownJob = null;
    }

    public final void cancelResumeFallback() {
        c0 c0Var = this.resumeFallbackJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.resumeFallbackJob = null;
    }

    public final t getOverlayPhase() {
        return this.overlayPhase;
    }

    public final t getPassivePromptExplainSnapshot() {
        return this.passivePromptExplainSnapshot;
    }

    public final t getStepExplain() {
        return this.stepExplain;
    }

    public final long getTakeoverIdleTimeoutMs() {
        return this.takeoverIdleTimeoutMs;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final t getTaskState() {
        return this.taskState;
    }

    public final t getTouchEnabled() {
        return this.touchEnabled;
    }

    /* renamed from: isOverlayDismissed, reason: from getter */
    public final t getIsOverlayDismissed() {
        return this.isOverlayDismissed;
    }

    public final void resume() {
        OverlayPhase overlayPhaseResolveResumePhase = OverlayPhaseResolver.INSTANCE.resolveResumePhase((OverlayPhase) ((kotlinx.coroutines.flow.i) this._overlayPhase).getValue(), ((kotlinx.coroutines.flow.i) this._taskState).getValue() == SessionState.f, ((Boolean) ((kotlinx.coroutines.flow.i) this._touchEnabled).getValue()).booleanValue(), (String) ((kotlinx.coroutines.flow.i) this._passivePromptExplainSnapshot).getValue());
        if (((kotlinx.coroutines.flow.i) this._overlayPhase).getValue() != overlayPhaseResolveResumePhase) {
            ((kotlinx.coroutines.flow.i) this._overlayPhase).i(overlayPhaseResolveResumePhase);
        }
        p9.j jVar = this._isOverlayDismissed;
        Boolean bool = Boolean.FALSE;
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) jVar;
        iVar.getClass();
        iVar.j(null, bool);
    }

    public final void setOverlayDismissed(boolean dismissed) {
        p9.j jVar = this._isOverlayDismissed;
        Boolean boolValueOf = Boolean.valueOf(dismissed);
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) jVar;
        iVar.getClass();
        iVar.j(null, boolValueOf);
    }

    public final void setOverlayPhase(OverlayPhase phase) {
        kotlin.jvm.internal.k.f(phase, "phase");
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) this._overlayPhase;
        iVar.getClass();
        iVar.j(null, phase);
    }

    public final void setPassivePromptExplainSnapshot(String text) {
        ((kotlinx.coroutines.flow.i) this._passivePromptExplainSnapshot).i(text);
    }

    public final void setStepExplain(String explain) {
        kotlin.jvm.internal.k.f(explain, "explain");
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) this._stepExplain;
        iVar.getClass();
        iVar.j(null, explain);
    }

    public final void setTakeoverIdleTimeoutMs(long j5) {
        this.takeoverIdleTimeoutMs = j5;
    }

    public final void setTaskId(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.taskId = str;
    }

    public final void setTaskState(SessionState state) {
        ((kotlinx.coroutines.flow.i) this._taskState).i(state);
    }

    public final void setTouchEnabled(boolean enabled) {
        p9.j jVar = this._touchEnabled;
        Boolean boolValueOf = Boolean.valueOf(enabled);
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) jVar;
        iVar.getClass();
        iVar.j(null, boolValueOf);
    }

    public final void startAckCountdown() {
        c0 c0Var = this.ackCountdownJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.ackCountdownJob = AbstractC1683A.n(getScope(), null, new AnonymousClass1(null), 3);
    }

    public final void startResumeFallback() {
        c0 c0Var = this.resumeFallbackJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.resumeFallbackJob = AbstractC1683A.n(getScope(), null, new C11581(null), 3);
    }

    public FullScreenActivityViewModel(InterfaceC1733z interfaceC1733z) {
        this.timerScope = interfaceC1733z;
        this.taskId = "";
        Boolean bool = Boolean.FALSE;
        kotlinx.coroutines.flow.i iVarC = p9.e.c(bool);
        this._touchEnabled = iVarC;
        this.touchEnabled = iVarC;
        kotlinx.coroutines.flow.i iVarC2 = p9.e.c(null);
        this._taskState = iVarC2;
        this.taskState = iVarC2;
        kotlinx.coroutines.flow.i iVarC3 = p9.e.c("");
        this._stepExplain = iVarC3;
        this.stepExplain = iVarC3;
        kotlinx.coroutines.flow.i iVarC4 = p9.e.c(OverlayPhase.RUNNING);
        this._overlayPhase = iVarC4;
        this.overlayPhase = iVarC4;
        kotlinx.coroutines.flow.i iVarC5 = p9.e.c(null);
        this._passivePromptExplainSnapshot = iVarC5;
        this.passivePromptExplainSnapshot = iVarC5;
        kotlinx.coroutines.flow.i iVarC6 = p9.e.c(bool);
        this._isOverlayDismissed = iVarC6;
        this.isOverlayDismissed = iVarC6;
        this.takeoverIdleTimeoutMs = TaskTimeouts.TAKEOVER_IDLE_MS;
    }

    public /* synthetic */ FullScreenActivityViewModel(InterfaceC1733z interfaceC1733z, int i, kotlin.jvm.internal.e eVar) {
        this((i & 1) != 0 ? null : interfaceC1733z);
    }
}
