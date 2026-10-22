package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdisdk.Task;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.WindowStateInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.llmapi.stepfun.speculation.ActionNormalizer;
import com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import f6.AbstractC1436a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.c0;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.SystemNavigationAction;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 t2\u00020\u0001:\u0001tB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ@\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\t2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b\u001f\u0010 JR\u0010%\u001a\u00020\u00182\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001d2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b%\u0010&J*\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020'2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\b)\u0010*J(\u0010,\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b,\u0010-J(\u0010.\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0018H\u0086@¢\u0006\u0004\b.\u0010-J\u0019\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\tH\u0002¢\u0006\u0004\b0\u00101J\u0011\u00102\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b2\u00103J\u001f\u00108\u001a\u0002072\u0006\u00104\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\tH\u0002¢\u0006\u0004\b:\u00103J\u0017\u0010<\u001a\u00020\u0018*\u0006\u0012\u0002\b\u00030;H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u000207H\u0002¢\u0006\u0004\bA\u0010BJ6\u0010F\u001a\u0002072\u0006\u0010C\u001a\u00020\t2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u0001050D2\u0006\u0010\u000e\u001a\u00020\u0007H\u0082@¢\u0006\u0004\bF\u0010GJ \u0010J\u001a\u00020\u00182\u0006\u0010I\u001a\u00020H2\u0006\u0010\u000e\u001a\u00020\u0007H\u0082@¢\u0006\u0004\bJ\u0010KJ\u0012\u0010M\u001a\u0004\u0018\u00010LH\u0082@¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u0002072\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\bO\u0010PR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010QR\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010RR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010RR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010S\u001a\u0004\b\\\u00103\"\u0004\b]\u0010PR\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020H0^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020a0^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010iR\u001c\u0010m\u001a\n l*\u0004\u0018\u00010k0k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u00103¨\u0006u"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiActionExecutor;", "Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lcom/mdisdk/Task;", "taskProvider", "", "getActionDisplayId", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, AppAgent.CONSTRUCT, "(Landroid/content/Context;LS7/a;LS7/a;Ljava/lang/String;)V", "packageName", WindowStateInfo.KEY_DISPLAY_ID, "Lstepai/aios/guiagent/config/Action;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lkotlin/Result;", "openApp-yxL6bBk", "(Landroid/content/Context;Ljava/lang/String;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "openApp", "", "x", "y", "", RequestInfo.FUNCTION_LONG_CLICK, RequestInfo.FUNCTION_CLICK, "(FFZILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "text", "Lkotlin/Pair;", "coordinates", "input", "(Ljava/lang/String;Lkotlin/Pair;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "startPoint", "endPoint", "", TypedValues.TransitionType.S_DURATION, RequestInfo.FUNCTION_SWIPE, "(Lkotlin/Pair;Lkotlin/Pair;JILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/SystemNavigationAction;", "systemNavigationAction", "systemNavigation", "(Lstepai/aios/guiexecutor/api/SystemNavigationAction;ILstepai/aios/guiagent/config/Action;LH7/c;)Ljava/lang/Object;", "isTop", "moveAppToVirtual", "(Ljava/lang/String;IZLH7/c;)Ljava/lang/Object;", "moveAppToMain", "op", "taskOrLogNull", "(Ljava/lang/String;)Lcom/mdisdk/Task;", "consumeExplain", "()Ljava/lang/String;", "fileName", "", "content", "LC7/r;", "writeSpecEvidence", "(Ljava/lang/String;Ljava/lang/Object;)V", "getActionSource", "Lcom/mdisdk/action/ActionResult;", "isSuccess", "(Lcom/mdisdk/action/ActionResult;)Z", "Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "getScreenSize", "()Lcom/stepos/taskrobot/llmapi/stepfun/speculation/ActionNormalizer$ScreenSize;", "launchPoolRetrieve", "()V", "actionType", "", "actionParams", "trySpeculateAfterAction", "(Ljava/lang/String;Ljava/util/Map;ILH7/c;)Ljava/lang/Object;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;", "pair", "executeSpeculatedNextStep", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;ILH7/c;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "captureUiSnapshotJson", "(LH7/c;)Ljava/lang/Object;", "notifyProgress", "(Ljava/lang/String;)V", "Landroid/content/Context;", "LS7/a;", "Ljava/lang/String;", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "taskEntity", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "getTaskEntity", "()Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "setTaskEntity", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)V", "currentExplain", "getCurrentExplain", "setCurrentExplain", "", "cachedCandidatePool", "Ljava/util/List;", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskCandidate;", "cachedTaskCandidates", "retrieveDone", "Z", "Lm9/c0;", "retrieveJob", "Lm9/c0;", "speculationConsecutiveFailures", "I", "speculationStepCounter", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "evidenceGson", "Lcom/google/gson/Gson;", "getTask", "()Lcom/mdisdk/Task;", "task", "getLogPrefix", "logPrefix", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlSystemGuiActionExecutor implements GuiActionExecutor {
    private static final String ACTION_SOURCE_EXPERIENCE = "experience";
    private static final String ACTION_SOURCE_UNKNOWN = "unknown";
    private static final long CLICK_DURATION_MS = 80;
    private static final Companion Companion = new Companion(null);
    private static final long LONG_CLICK_DURATION_MS = 1200;
    private static final long RETRIEVE_TIMEOUT_MS = 5000;
    private static final int SPECULATION_FAILURE_THRESHOLD = 5;
    private static final String TAG = "ZyqlGuiActionExecutor";
    private List<Step2RetrieveResult.StepCandidatePair> cachedCandidatePool;
    private List<Step2RetrieveResult.TaskCandidate> cachedTaskCandidates;
    private final Context context;
    private volatile String currentExplain;
    private final Gson evidenceGson;
    private final S7.a getActionDisplayId;
    private boolean retrieveDone;
    private c0 retrieveJob;
    private int speculationConsecutiveFailures;
    private int speculationStepCounter;
    private TaskEntity taskEntity;
    private final String taskId;
    private final S7.a taskProvider;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiActionExecutor$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "ACTION_SOURCE_EXPERIENCE", "ACTION_SOURCE_UNKNOWN", "SPECULATION_FAILURE_THRESHOLD", "", "RETRIEVE_TIMEOUT_MS", "", "CLICK_DURATION_MS", "LONG_CLICK_DURATION_MS", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SystemNavigationAction.values().length];
            try {
                iArr[SystemNavigationAction.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SystemNavigationAction.HOME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SystemNavigationAction.ENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SystemNavigationAction.RECENT_APPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {921}, m = "captureUiSnapshotJson", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$captureUiSnapshotJson$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.captureUiSnapshotJson(this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {208, 234, 261}, m = RequestInfo.FUNCTION_CLICK, v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$click$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11821 extends ContinuationImpl {
        float F$0;
        float F$1;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public C11821(H7.c<? super C11821> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.click(0.0f, 0.0f, false, 0, null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {889}, m = "executeSpeculatedNextStep", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$executeSpeculatedNextStep$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11831 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11831(H7.c<? super C11831> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.executeSpeculatedNextStep(null, 0, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {303, 327}, m = "input", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$input$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11841 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11841(H7.c<? super C11841> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.input(null, null, 0, null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1", f = "ZyqlSystemGuiActionExecutor.kt", l = {596}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$launchPoolRetrieve$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11851 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $appName;
        final /* synthetic */ String $taskName;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11851(String str, String str2, H7.c<? super C11851> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$taskName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C11851 c11851 = ZyqlSystemGuiActionExecutor.this.new C11851(this.$appName, this.$taskName, cVar);
            c11851.L$0 = obj;
            return c11851;
        }

        /* JADX WARN: Removed duplicated region for block: B:79:0x038d  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x03ae  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 949
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.C11851.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11851) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {516}, m = "moveAppToMain", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$moveAppToMain$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11861 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11861(H7.c<? super C11861> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.moveAppToMain(null, 0, false, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {478}, m = "moveAppToVirtual", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$moveAppToVirtual$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11871 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11871(H7.c<? super C11871> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.moveAppToVirtual(null, 0, false, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {358, 387}, m = RequestInfo.FUNCTION_SWIPE, v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$swipe$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11881 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11881(H7.c<? super C11881> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.swipe(null, null, 0L, 0, null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {432, 463}, m = "systemNavigation", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$systemNavigation$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11891 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C11891(H7.c<? super C11891> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.systemNavigation(null, 0, null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor", f = "ZyqlSystemGuiActionExecutor.kt", l = {695, 734, 736, 805}, m = "trySpeculateAfterAction", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$trySpeculateAfterAction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11901 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C11901(H7.c<? super C11901> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiActionExecutor.this.trySpeculateAfterAction(null, null, 0, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$trySpeculateAfterAction$2", f = "ZyqlSystemGuiActionExecutor.kt", l = {695}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor$trySpeculateAfterAction$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements S7.n {
        int label;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ZyqlSystemGuiActionExecutor.this.new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                c0 c0Var = ZyqlSystemGuiActionExecutor.this.retrieveJob;
                if (c0Var == null) {
                    return null;
                }
                this.label = 1;
                if (c0Var.g(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public ZyqlSystemGuiActionExecutor(Context context, S7.a taskProvider, S7.a getActionDisplayId, String str) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        kotlin.jvm.internal.k.f(getActionDisplayId, "getActionDisplayId");
        this.context = context;
        this.taskProvider = taskProvider;
        this.getActionDisplayId = getActionDisplayId;
        this.taskId = str;
        EmptyList emptyList = EmptyList.f4893a;
        this.cachedCandidatePool = emptyList;
        this.cachedTaskCandidates = emptyList;
        this.evidenceGson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object captureUiSnapshotJson(H7.c<? super org.json.JSONObject> r14) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.captureUiSnapshotJson(H7.c):java.lang.Object");
    }

    private final String consumeExplain() {
        String str = this.currentExplain;
        this.currentExplain = null;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeSpeculatedNextStep(com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult.StepCandidatePair r30, int r31, H7.c<? super java.lang.Boolean> r32) {
        /*
            Method dump skipped, instructions count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.executeSpeculatedNextStep(com.stepos.taskrobot.taskmanager.experiencelib.model.Step2RetrieveResult$StepCandidatePair, int, H7.c):java.lang.Object");
    }

    private final String getActionSource() {
        return "unknown";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogPrefix() {
        String str = this.taskId;
        return str != null ? B7.a.m("[", str, "]") : "";
    }

    private final ActionNormalizer.ScreenSize getScreenSize() {
        Context context = this.context;
        kotlin.jvm.internal.k.f(context, "context");
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        Context context2 = this.context;
        kotlin.jvm.internal.k.f(context2, "context");
        Object systemService2 = context2.getSystemService("window");
        kotlin.jvm.internal.k.d(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) systemService2).getDefaultDisplay().getRealMetrics(displayMetrics2);
        return new ActionNormalizer.ScreenSize(i, displayMetrics2.heightPixels);
    }

    private final Task getTask() {
        return (Task) this.taskProvider.invoke();
    }

    private final boolean isSuccess(ActionResult<?> actionResult) {
        if (actionResult instanceof ActionResult.Success) {
            return true;
        }
        if (actionResult instanceof ActionResult.Failure) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void launchPoolRetrieve() {
        if (!ExperienceManager.INSTANCE.getExperienceEnable()) {
            AbstractC1436a.a(TAG, getLogPrefix() + " launchPoolRetrieve: experienceEnable=false, skip", true);
            this.retrieveDone = true;
            return;
        }
        String str = this.taskId;
        ZyqlGuiAgentTask task = str != null ? SystemSdkBridge.INSTANCE.getTask(str) : null;
        String taskName = task != null ? task.getTaskName() : null;
        if (taskName == null || j9.m.s0(taskName)) {
            AbstractC1436a.a(TAG, getLogPrefix() + " launchPoolRetrieve: taskName is empty, skip", true);
            this.retrieveDone = true;
            return;
        }
        String appName = task.getGuiTaskRecord().getAppName();
        if (appName == null) {
            appName = "";
        }
        if (j9.m.s0(appName)) {
            AbstractC1436a.e(TAG, getLogPrefix() + " launchPoolRetrieve: appName is empty, search may return no results", true);
        }
        AbstractC1436a.a(TAG, getLogPrefix() + " launchPoolRetrieve: starting async search for task='" + j9.m.N0(40, taskName) + "' app='" + appName + "'", true);
        u9.d dVar = AbstractC1691I.f5315a;
        this.retrieveJob = AbstractC1683A.n(AbstractC1683A.b(u9.c.f6743a), null, new C11851(appName, taskName, null), 3);
    }

    private final void notifyProgress(String action) {
        String str = this.taskId;
        if (str != null) {
            SystemSdkBridge.notifyProgressChanged$default(SystemSdkBridge.INSTANCE, str, action, null, null, null, 28, null);
        }
    }

    private final Task taskOrLogNull(String op) {
        Task task = getTask();
        if (task == null) {
            AbstractC1436a.e(TAG, getLogPrefix() + " " + op + ": MDI task is null (handed over)", true);
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(24:194|(1:196)(1:199)|(4:201|(6:204|(1:206)(1:207)|(1:209)(1:210)|(3:273|212|277)(1:276)|275|202)|274|213)(1:214)|215|(1:217)(1:218)|219|220|269|221|222|261|223|224|263|225|226|267|227|228|271|229|230|259|231) */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x094f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0951, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0953, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0954, code lost:
    
        r25 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0956, code lost:
    
        r26 = r15;
        r15 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x095b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x095c, code lost:
    
        r36 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x095f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0960, code lost:
    
        r58 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0963, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0964, code lost:
    
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x098f, code lost:
    
        f6.AbstractC1436a.b(r4, getLogPrefix() + " speculation history inject failed: " + r0.getMessage(), true);
        r5 = androidx.appfunctions.metadata.a.i(r7, r13, r3);
        r7 = new kotlin.Pair(r2, new java.lang.Integer(r7));
        r8 = new kotlin.Pair(r10, new java.lang.Integer(r11));
        r9 = new kotlin.Pair(r15, java.lang.Boolean.FALSE);
        r6 = r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x09d2, code lost:
    
        if (r6 == null) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x09d4, code lost:
    
        r6 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x09d8, code lost:
    
        writeSpecEvidence(r5, kotlin.collections.a.R(r7, r8, r9, new kotlin.Pair("error", r6)));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x081d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x09d4  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x09f0  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x083f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x039a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:185:0x07cc -> B:186:0x07d1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object trySpeculateAfterAction(java.lang.String r56, java.util.Map<java.lang.String, ? extends java.lang.Object> r57, int r58, H7.c<? super C7.r> r59) {
        /*
            Method dump skipped, instructions count: 2669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.trySpeculateAfterAction(java.lang.String, java.util.Map, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeSpecEvidence(String fileName, Object content) {
        Object objA;
        String str = this.taskId;
        if (str == null) {
            return;
        }
        String json = content instanceof String ? (String) content : this.evidenceGson.toJson(content);
        try {
            TaskEvidenceStore taskEvidenceStore = TaskEvidenceStore.INSTANCE;
            Context context = this.context;
            kotlin.jvm.internal.k.c(json);
            taskEvidenceStore.writeText(context, str, fileName, json);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("writeSpecEvidence failed: ", fileName, " ", thA.getMessage()), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object click(float r41, float r42, boolean r43, int r44, stepai.aios.guiagent.config.Action r45, H7.c<? super java.lang.Boolean> r46) {
        /*
            Method dump skipped, instructions count: 961
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.click(float, float, boolean, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    public final String getCurrentExplain() {
        return this.currentExplain;
    }

    public final TaskEntity getTaskEntity() {
        return this.taskEntity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Type inference failed for: r14v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object input(java.lang.String r43, kotlin.Pair<java.lang.Integer, java.lang.Integer> r44, int r45, stepai.aios.guiagent.config.Action r46, H7.c<? super java.lang.Boolean> r47) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.input(java.lang.String, kotlin.Pair, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object moveAppToMain(java.lang.String r30, int r31, boolean r32, H7.c<? super java.lang.Boolean> r33) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.moveAppToMain(java.lang.String, int, boolean, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object moveAppToVirtual(java.lang.String r30, int r31, boolean r32, H7.c<? super java.lang.Boolean> r33) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.moveAppToVirtual(java.lang.String, int, boolean, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /* renamed from: openApp-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo7351openAppyxL6bBk(android.content.Context r32, java.lang.String r33, int r34, stepai.aios.guiagent.config.Action r35, H7.c<? super kotlin.Result<java.lang.String>> r36) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.mo7351openAppyxL6bBk(android.content.Context, java.lang.String, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    public final void setCurrentExplain(String str) {
        this.currentExplain = str;
    }

    public final void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object swipe(kotlin.Pair<java.lang.Integer, java.lang.Integer> r35, kotlin.Pair<java.lang.Integer, java.lang.Integer> r36, long r37, int r39, stepai.aios.guiagent.config.Action r40, H7.c<? super java.lang.Boolean> r41) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.swipe(kotlin.Pair, kotlin.Pair, long, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // stepai.aios.guiexecutor.api.GuiActionExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object systemNavigation(stepai.aios.guiexecutor.api.SystemNavigationAction r32, int r33, stepai.aios.guiagent.config.Action r34, H7.c<? super java.lang.Boolean> r35) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor.systemNavigation(stepai.aios.guiexecutor.api.SystemNavigationAction, int, stepai.aios.guiagent.config.Action, H7.c):java.lang.Object");
    }

    public /* synthetic */ ZyqlSystemGuiActionExecutor(Context context, S7.a aVar, S7.a aVar2, String str, int i, kotlin.jvm.internal.e eVar) {
        this(context, aVar, aVar2, (i & 8) != 0 ? null : str);
    }
}
