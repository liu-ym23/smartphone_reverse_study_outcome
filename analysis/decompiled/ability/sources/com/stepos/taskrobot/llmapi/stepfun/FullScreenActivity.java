package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.TypedValue;
import android.view.Lifecycle;
import android.view.LifecycleOwnerKt;
import android.view.MotionEvent;
import android.view.OnBackPressedCallback;
import android.view.RepeatOnLifecycleKt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewModelProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.mdisdk.observer.ForegroundAppFilter;
import com.mdisdk.observer.ForegroundAppInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper;
import com.stepos.taskrobot.llmapi.stepfun.OverlayPhaseResolver;
import com.stepos.taskrobot.llmapi.stepfun.mirror.UnifiedMirrorView;
import com.stepos.taskrobot.llmapi.stepfun.view.AntiMistouchBubbleView;
import com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView;
import com.stepos.taskrobot.llmapi.stepfun.view.blur.BlurCardView;
import com.stepos.taskrobot.llmapi.stepfun.view.carousel.StatusBarCarouselController;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup;
import f6.AbstractC1436a;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import org.json.JSONException;
import org.json.JSONObject;
import p9.t;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0002\u0088\u0001\b\u0000\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\u008d\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0003J\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0003J\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\u0003J\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0003J\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b#\u0010\u0018J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0003¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0015H\u0002¢\u0006\u0004\b0\u0010\u0018J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0003J\u001f\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020%H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0003J\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0015H\u0002¢\u0006\u0004\b=\u0010\u0018J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0003J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\u0003J\u000f\u0010@\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0003J\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\u0003J\u001f\u0010G\u001a\u00020\u00062\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020DH\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020\u00062\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020DH\u0002¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\u0003J\u0017\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020DH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010\u0003J\u000f\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u0010\u0003J\u000f\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0004\bR\u0010\u0003J\u0017\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0015H\u0002¢\u0006\u0004\bX\u0010\u0018J\u000f\u0010Y\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010\u0003J\u000f\u0010Z\u001a\u00020\u0006H\u0002¢\u0006\u0004\bZ\u0010\u0003J\u000f\u0010[\u001a\u00020\u0006H\u0002¢\u0006\u0004\b[\u0010\u0003J\u0017\u0010\\\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\\\u0010\fJ\u0017\u0010]\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0015H\u0002¢\u0006\u0004\b]\u0010\u0018R\"\u0010_\u001a\u00020^8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010h\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010q\u001a\u00020p8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bs\u0010rR\u0016\u0010u\u001a\u00020t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010{R\u0017\u0010\u007f\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0081\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010yR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00020e8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010gR\u0019\u0010\u0087\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0080\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008b\u0001\u001a\u00020%8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;", "Landroidx/appcompat/app/AppCompatActivity;", AppAgent.CONSTRUCT, "()V", "Landroid/os/Bundle;", "savedInstanceState", "LC7/r;", AppAgent.ON_CREATE, "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "onPause", "onDestroy", "onAckCardClicked", "Lcom/stepos/taskrobot/llmapi/stepfun/mirror/UnifiedMirrorView;", "getMirrorView$stepfun_release", "()Lcom/stepos/taskrobot/llmapi/stepfun/mirror/UnifiedMirrorView;", "getMirrorView", "", "newTaskId", "updateTaskId$stepfun_release", "(Ljava/lang/String;)V", "updateTaskId", "notifyTakeoverFromLlm$stepfun_release", "notifyTakeoverFromLlm", "notifyTakeoverAcknowledged$stepfun_release", "notifyTakeoverAcknowledged", "onStopBtnClicked", "onOverlayPulledUp", "onMiniBarClicked", "onDismissRequested", "onResumeRequested", "migrateToNewTask$stepfun_release", "migrateToNewTask", "", "hideSystemBars", "applySystemBarsMode", "(Z)V", "enableImmersiveSticky", "initViews", "setupOverlayListeners", "setupOverlayCards", "performRecoverFromTakeover", "emitRequestChatInput", "reason", "stopTaskFromOverlay", "observeOverlayState", "Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;", TypedValues.CycleType.S_WAVE_PHASE, "dismissed", "applyOverlayPhase", "(Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;Z)V", "startCarousel", "stopCarousel", "setupSurfaceCallback", "installFreshMirrorView", "clearMirrorView", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "bindTaskUiState", "resetIdleTimer", "startIdleTimer", "cancelIdleTimer", "cancelAllTimers", "cancelAutoRecover", "autoRecoverFromTakeover", "", "touchX", "touchY", "onIdleTapInRunning", "(FF)V", "showAntiMistouchPrompt", "dismissAntiMistouchPrompt", "cancelAntiMistouchPromptJob", "value", "", "dp", "(F)I", "onMirrorViewTouched", "startLauncherWatcher", "stopLauncherWatcher", "Lcom/mdisdk/observer/ForegroundAppInfo;", "info", "onVirtualLauncherForegrounded", "(Lcom/mdisdk/observer/ForegroundAppInfo;)V", "prevPackage", "triggerExitWithMask", "requestTakeoverFromPassivePrompt", "onPassiveHandlePulledUp", "emitRequestChatInputFromHandle", "handleIntent", "applyTaskDescription", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivityViewModel;", "viewModel", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivityViewModel;", "getViewModel$stepfun_release", "()Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivityViewModel;", "setViewModel$stepfun_release", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivityViewModel;)V", "Landroid/widget/FrameLayout;", "mirrorContainer", "Landroid/widget/FrameLayout;", "mirrorView", "Lcom/stepos/taskrobot/llmapi/stepfun/mirror/UnifiedMirrorView;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView;", "statusBar", "Lcom/stepos/taskrobot/llmapi/stepfun/view/StatusBarCarouselView;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup;", "passiveTakeoverPromptPopup", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/PassiveTakeoverPromptPopup;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/blur/BlurCardView;", "ackCard", "Lcom/stepos/taskrobot/llmapi/stepfun/view/blur/BlurCardView;", "miniBar", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController;", "carouselController", "Lcom/stepos/taskrobot/llmapi/stepfun/view/carousel/StatusBarCarouselController;", "Lm9/c0;", "taskUiJob", "Lm9/c0;", "lastAppliedTaskDescPkg", "Ljava/lang/String;", "idleTimerJob", "autoRecoverJob", "launcherWatcherId", "pendingRecoverOnTakeover", "Z", "ackCardVisible", "antiMistouchPromptJob", "Lcom/stepos/taskrobot/llmapi/stepfun/view/AntiMistouchBubbleView;", "antiMistouchBubble", "Lcom/stepos/taskrobot/llmapi/stepfun/view/AntiMistouchBubbleView;", "rootContainer", "takeoverRequestInFlight", "com/stepos/taskrobot/llmapi/stepfun/FullScreenActivity$backCallback$1", "backCallback", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity$backCallback$1;", "isAutoRecovering", "()Z", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FullScreenActivity extends AppCompatActivity {
    public static final String EXTRA_TARGET_PACKAGE = "extra_target_package";
    public static final String EXTRA_TASK_ID = "extra_task_id";
    private static final boolean HIDE_SYSTEM_BARS = true;
    private static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    private static final long MIRROR_SNAPSHOT_INTERVAL_MS = 5000;
    private static final String TAG = "FullScreenActivity";
    private BlurCardView ackCard;
    private boolean ackCardVisible;
    private AntiMistouchBubbleView antiMistouchBubble;
    private c0 antiMistouchPromptJob;
    private c0 autoRecoverJob;
    private final FullScreenActivity$backCallback$1 backCallback = new OnBackPressedCallback() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$backCallback$1
        {
            super(false);
        }

        @Override // android.view.OnBackPressedCallback
        public void handleOnBackPressed() {
            com.stepos.statsrpk.service.c.p("[", this.this$0.getViewModel$stepfun_release().getTaskId(), "] onBack: blocked in takeover mode (touchEnabled=true)", "FullScreenActivity", true);
        }
    };
    private StatusBarCarouselController carouselController;
    private c0 idleTimerJob;
    private String lastAppliedTaskDescPkg;
    private String launcherWatcherId;
    private BlurCardView miniBar;
    private FrameLayout mirrorContainer;
    private UnifiedMirrorView mirrorView;
    private PassiveTakeoverPromptPopup passiveTakeoverPromptPopup;
    private boolean pendingRecoverOnTakeover;
    private FrameLayout rootContainer;
    private StatusBarCarouselView statusBar;
    private volatile boolean takeoverRequestInFlight;
    private c0 taskUiJob;
    public FullScreenActivityViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OverlayPhase.values().length];
            try {
                iArr[OverlayPhase.TAKEOVER_ACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OverlayPhase.MINI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OverlayPhase.PASSIVE_PROMPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OverlayPhase.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$autoRecoverFromTakeover$1", f = "FullScreenActivity.kt", l = {718}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$autoRecoverFromTakeover$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $taskId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$taskId, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    String str = this.$taskId;
                    SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = systemSdkBridge.recoverFromTakeover(str, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                objA = (za.d) obj;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            String str2 = this.$taskId;
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.b(FullScreenActivity.TAG, B7.a.n("[", str2, "] autoRecoverFromTakeover failed: ", thA.getMessage()), true);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$bindTaskUiState$1", f = "FullScreenActivity.kt", l = {626}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$bindTaskUiState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11501 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $taskId;
        int label;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$bindTaskUiState$1$1", f = "FullScreenActivity.kt", l = {627}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$bindTaskUiState$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01581 extends SuspendLambda implements S7.n {
            final /* synthetic */ String $taskId;
            int label;
            final /* synthetic */ FullScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01581(String str, FullScreenActivity fullScreenActivity, H7.c<? super C01581> cVar) {
                super(2, cVar);
                this.$taskId = str;
                this.this$0 = fullScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01581(this.$taskId, this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    t tVarObserveFullScreenTaskUiState$stepfun_release = SystemSdkBridge.INSTANCE.observeFullScreenTaskUiState$stepfun_release(this.$taskId);
                    final FullScreenActivity fullScreenActivity = this.this$0;
                    final String str = this.$taskId;
                    p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.bindTaskUiState.1.1.1

                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$bindTaskUiState$1$1$1$WhenMappings */
                        public static final /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[OverlayPhase.values().length];
                                try {
                                    iArr[OverlayPhase.RUNNING.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[OverlayPhase.MINI.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                try {
                                    iArr[OverlayPhase.PASSIVE_PROMPT.ordinal()] = 3;
                                } catch (NoSuchFieldError unused3) {
                                }
                                try {
                                    iArr[OverlayPhase.TAKEOVER_ACK.ordinal()] = 4;
                                } catch (NoSuchFieldError unused4) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        @Override // p9.d
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                            return emit((FullScreenHelper.FullScreenTaskUiState) obj2, (H7.c<? super r>) cVar);
                        }

                        public final Object emit(FullScreenHelper.FullScreenTaskUiState fullScreenTaskUiState, H7.c<? super r> cVar) throws Resources.NotFoundException {
                            fullScreenActivity.getViewModel$stepfun_release().setTaskState(fullScreenTaskUiState.getTaskState());
                            fullScreenActivity.getViewModel$stepfun_release().setStepExplain(fullScreenTaskUiState.getExplain());
                            ZyqlGuiAgentTask task = SystemSdkBridge.INSTANCE.getTask(str);
                            if (!kotlin.jvm.internal.k.b(task != null ? task.getTargetPackageName() : null, fullScreenActivity.lastAppliedTaskDescPkg)) {
                                fullScreenActivity.applyTaskDescription(str);
                            }
                            boolean z10 = fullScreenTaskUiState.getTaskState() == SessionState.f;
                            boolean zBooleanValue = ((Boolean) fullScreenActivity.getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue();
                            AbstractC1436a.a(FullScreenActivity.TAG, "[" + fullScreenActivity.getViewModel$stepfun_release().getTaskId() + "] bindTaskUiState: taskState=" + fullScreenTaskUiState.getTaskState() + ", isTakeover=" + z10 + ", touchEnabled=" + zBooleanValue + ", overlayPhase=" + fullScreenActivity.getViewModel$stepfun_release().getOverlayPhase().getValue(), true);
                            if (z10 && zBooleanValue) {
                                int i6 = WhenMappings.$EnumSwitchMapping$0[((OverlayPhase) fullScreenActivity.getViewModel$stepfun_release().getOverlayPhase().getValue()).ordinal()];
                                if (i6 == 1 || i6 == 2 || i6 == 3) {
                                    fullScreenActivity.getViewModel$stepfun_release().setOverlayPhase(OverlayPhase.TAKEOVER_ACK);
                                } else if (i6 != 4) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                if (fullScreenActivity.pendingRecoverOnTakeover) {
                                    com.stepos.statsrpk.service.c.p("[", fullScreenActivity.getViewModel$stepfun_release().getTaskId(), "] bindTaskUiState: consuming pending recover (session reached MANUAL_TAKEOVER)", FullScreenActivity.TAG, true);
                                    fullScreenActivity.performRecoverFromTakeover();
                                }
                            } else if (!z10) {
                                Object value = fullScreenActivity.getViewModel$stepfun_release().getOverlayPhase().getValue();
                                OverlayPhase overlayPhase = OverlayPhase.RUNNING;
                                if (value != overlayPhase) {
                                    com.stepos.statsrpk.service.c.p("[", fullScreenActivity.getViewModel$stepfun_release().getTaskId(), "] bindTaskUiState: resetting overlay to RUNNING (session left MANUAL_TAKEOVER)", FullScreenActivity.TAG, true);
                                    fullScreenActivity.cancelAllTimers();
                                    fullScreenActivity.stopLauncherWatcher();
                                    fullScreenActivity.pendingRecoverOnTakeover = false;
                                    fullScreenActivity.getViewModel$stepfun_release().setPassivePromptExplainSnapshot(null);
                                    fullScreenActivity.getViewModel$stepfun_release().setOverlayPhase(overlayPhase);
                                    StatusBarCarouselController statusBarCarouselController = fullScreenActivity.carouselController;
                                    if (statusBarCarouselController == null) {
                                        kotlin.jvm.internal.k.n("carouselController");
                                        throw null;
                                    }
                                    statusBarCarouselController.onTaskRecoveredFromTakeover();
                                }
                            }
                            return r.f317a;
                        }
                    };
                    this.label = 1;
                    if (tVarObserveFullScreenTaskUiState$stepfun_release.collect(dVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01581) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11501(String str, H7.c<? super C11501> cVar) {
            super(2, cVar);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivity.this.new C11501(this.$taskId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                FullScreenActivity fullScreenActivity = FullScreenActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                C01581 c01581 = new C01581(this.$taskId, fullScreenActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(fullScreenActivity, state, c01581, this) == coroutineSingletons) {
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
            return ((C11501) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$observeOverlayState$1", f = "FullScreenActivity.kt", l = {450}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$observeOverlayState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11511 extends SuspendLambda implements S7.n {
        int label;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$observeOverlayState$1$1", f = "FullScreenActivity.kt", l = {455}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$observeOverlayState$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01601 extends SuspendLambda implements S7.n {
            int label;
            final /* synthetic */ FullScreenActivity this$0;

            @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$observeOverlayState$1$1$1", f = "FullScreenActivity.kt", l = {}, m = "invokeSuspend", v = 1)
            @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/stepos/taskrobot/llmapi/stepfun/OverlayPhase;", "", TypedValues.CycleType.S_WAVE_PHASE, "dismissed"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$observeOverlayState$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01611 extends SuspendLambda implements S7.o {
                /* synthetic */ Object L$0;
                /* synthetic */ boolean Z$0;
                int label;

                public C01611(H7.c<? super C01611> cVar) {
                    super(3, cVar);
                }

                public final Object invoke(OverlayPhase overlayPhase, boolean z10, H7.c<? super Pair<? extends OverlayPhase, Boolean>> cVar) {
                    C01611 c01611 = new C01611(cVar);
                    c01611.L$0 = overlayPhase;
                    c01611.Z$0 = z10;
                    return c01611.invokeSuspend(r.f317a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    OverlayPhase overlayPhase = (OverlayPhase) this.L$0;
                    boolean z10 = this.Z$0;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                    return new Pair(overlayPhase, Boolean.valueOf(z10));
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((OverlayPhase) obj, ((Boolean) obj2).booleanValue(), (H7.c<? super Pair<? extends OverlayPhase, Boolean>>) obj3);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01601(FullScreenActivity fullScreenActivity, H7.c<? super C01601> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01601(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    kotlinx.coroutines.flow.g gVar = new kotlinx.coroutines.flow.g(this.this$0.getViewModel$stepfun_release().getOverlayPhase(), this.this$0.getViewModel$stepfun_release().getIsOverlayDismissed(), new C01611(null));
                    final FullScreenActivity fullScreenActivity = this.this$0;
                    p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.observeOverlayState.1.1.2
                        public final Object emit(Pair<? extends OverlayPhase, Boolean> pair, H7.c<? super r> cVar) {
                            fullScreenActivity.applyOverlayPhase((OverlayPhase) pair.f4886a, ((Boolean) pair.b).booleanValue());
                            return r.f317a;
                        }

                        @Override // p9.d
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                            return emit((Pair<? extends OverlayPhase, Boolean>) obj2, (H7.c<? super r>) cVar);
                        }
                    };
                    this.label = 1;
                    if (gVar.collect(dVar, this) == coroutineSingletons) {
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
                return ((C01601) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public C11511(H7.c<? super C11511> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivity.this.new C11511(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                FullScreenActivity fullScreenActivity = FullScreenActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                C01601 c01601 = new C01601(fullScreenActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(fullScreenActivity, state, c01601, this) == coroutineSingletons) {
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
            return ((C11511) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$2", f = "FullScreenActivity.kt", l = {190}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements S7.n {
        int label;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$2$1", f = "FullScreenActivity.kt", l = {191}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
            int label;
            final /* synthetic */ FullScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FullScreenActivity fullScreenActivity, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    t touchEnabled = this.this$0.getViewModel$stepfun_release().getTouchEnabled();
                    final FullScreenActivity fullScreenActivity = this.this$0;
                    p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.onCreate.2.1.1
                        @Override // p9.d
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                            return emit(((Boolean) obj2).booleanValue(), (H7.c<? super r>) cVar);
                        }

                        public final Object emit(boolean z10, H7.c<? super r> cVar) {
                            setEnabled(z10);
                            return r.f317a;
                        }
                    };
                    this.label = 1;
                    if (touchEnabled.collect(dVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivity.this.new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                FullScreenActivity fullScreenActivity = FullScreenActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(fullScreenActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(fullScreenActivity, state, anonymousClass1, this) == coroutineSingletons) {
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

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$3", f = "FullScreenActivity.kt", l = {198}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements S7.n {
        int label;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$3$1", f = "FullScreenActivity.kt", l = {199}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
            int label;
            final /* synthetic */ FullScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FullScreenActivity fullScreenActivity, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    t overlayPhase = this.this$0.getViewModel$stepfun_release().getOverlayPhase();
                    final FullScreenActivity fullScreenActivity = this.this$0;
                    p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.onCreate.3.1.1
                        @Override // p9.d
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                            return emit((OverlayPhase) obj2, (H7.c<? super r>) cVar);
                        }

                        public final Object emit(OverlayPhase overlayPhase2, H7.c<? super r> cVar) {
                            c0 c0Var;
                            if (overlayPhase2 != OverlayPhase.RUNNING && (c0Var = fullScreenActivity.antiMistouchPromptJob) != null && c0Var.isActive()) {
                                AbstractC1436a.a(FullScreenActivity.TAG, "[" + fullScreenActivity.getViewModel$stepfun_release().getTaskId() + "] antiMistouch: cancelled (overlay left RUNNING)", true);
                                fullScreenActivity.cancelAntiMistouchPromptJob();
                                fullScreenActivity.dismissAntiMistouchPrompt();
                            }
                            return r.f317a;
                        }
                    };
                    this.label = 1;
                    if (overlayPhase.collect(dVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass3(H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivity.this.new AnonymousClass3(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                FullScreenActivity fullScreenActivity = FullScreenActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(fullScreenActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(fullScreenActivity, state, anonymousClass1, this) == coroutineSingletons) {
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
            return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$4", f = "FullScreenActivity.kt", l = {209}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements S7.n {
        int label;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$4$1", f = "FullScreenActivity.kt", l = {210}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
            int label;
            final /* synthetic */ FullScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FullScreenActivity fullScreenActivity, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    t stepExplain = this.this$0.getViewModel$stepfun_release().getStepExplain();
                    final FullScreenActivity fullScreenActivity = this.this$0;
                    p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.onCreate.4.1.1
                        @Override // p9.d
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                            return emit((String) obj2, (H7.c<? super r>) cVar);
                        }

                        public final Object emit(String str, H7.c<? super r> cVar) {
                            if (fullScreenActivity.getViewModel$stepfun_release().getOverlayPhase().getValue() == OverlayPhase.RUNNING && str.length() > 0) {
                                StatusBarCarouselController statusBarCarouselController = fullScreenActivity.carouselController;
                                if (statusBarCarouselController == null) {
                                    kotlin.jvm.internal.k.n("carouselController");
                                    throw null;
                                }
                                statusBarCarouselController.onExplainUpdated(str);
                            }
                            return r.f317a;
                        }
                    };
                    this.label = 1;
                    if (stepExplain.collect(dVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass4(H7.c<? super AnonymousClass4> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivity.this.new AnonymousClass4(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                FullScreenActivity fullScreenActivity = FullScreenActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(fullScreenActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(fullScreenActivity, state, anonymousClass1, this) == coroutineSingletons) {
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
            return ((AnonymousClass4) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$5", f = "FullScreenActivity.kt", l = {220}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements S7.n {
        int label;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$5$1", f = "FullScreenActivity.kt", l = {222}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ FullScreenActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FullScreenActivity fullScreenActivity, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = fullScreenActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, cVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            /* JADX WARN: Path cross not found for [B:19:0x0054, B:21:0x005a], limit reached: 25 */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002c -> B:14:0x002f). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = r9.L$0
                    m9.z r0 = (m9.InterfaceC1733z) r0
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r2 = r9.label
                    r3 = 1
                    if (r2 == 0) goto L19
                    if (r2 != r3) goto L11
                    kotlin.b.b(r10)
                    goto L2f
                L11:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L19:
                    kotlin.b.b(r10)
                L1c:
                    boolean r10 = m9.AbstractC1683A.l(r0)
                    if (r10 == 0) goto L96
                    r9.L$0 = r0
                    r9.label = r3
                    r4 = 5000(0x1388, double:2.4703E-320)
                    java.lang.Object r10 = kotlinx.coroutines.a.f(r4, r9)
                    if (r10 != r1) goto L2f
                    return r1
                L2f:
                    com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity r10 = r9.this$0
                    com.stepos.taskrobot.llmapi.stepfun.mirror.UnifiedMirrorView r10 = com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.access$getMirrorView$p(r10)
                    com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity r2 = r9.this$0
                    com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r2 = r2.getViewModel$stepfun_release()
                    java.lang.String r2 = r2.getTaskId()
                    com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity r4 = r9.this$0
                    com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r4 = r4.getViewModel$stepfun_release()
                    p9.t r4 = r4.getOverlayPhase()
                    java.lang.Object r4 = r4.getValue()
                    if (r10 == 0) goto L51
                    r5 = r3
                    goto L52
                L51:
                    r5 = 0
                L52:
                    if (r10 == 0) goto L5a
                    java.lang.String r10 = r10.surfaceState()
                    if (r10 != 0) goto L5c
                L5a:
                    java.lang.String r10 = "mirrorView null"
                L5c:
                    com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge r6 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.INSTANCE
                    boolean r6 = r6.isFullScreenActivityInForeground$stepfun_release()
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    java.lang.String r8 = "["
                    r7.<init>(r8)
                    r7.append(r2)
                    java.lang.String r2 = "] mirror snapshot: phase="
                    r7.append(r2)
                    r7.append(r4)
                    java.lang.String r2 = ", mirrorViewAttached="
                    r7.append(r2)
                    r7.append(r5)
                    java.lang.String r2 = ", "
                    r7.append(r2)
                    r7.append(r10)
                    java.lang.String r10 = ", fsForeground="
                    r7.append(r10)
                    r7.append(r6)
                    java.lang.String r10 = r7.toString()
                    java.lang.String r2 = "FullScreenActivity"
                    f6.AbstractC1436a.a(r2, r10, r3)
                    goto L1c
                L96:
                    C7.r r9 = C7.r.f317a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass5(H7.c<? super AnonymousClass5> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FullScreenActivity.this.new AnonymousClass5(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                FullScreenActivity fullScreenActivity = FullScreenActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(fullScreenActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(fullScreenActivity, state, anonymousClass1, this) == coroutineSingletons) {
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
            return ((AnonymousClass5) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onIdleTapInRunning$1", f = "FullScreenActivity.kt", l = {750}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onIdleTapInRunning$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11521 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $taskId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11521(String str, H7.c<? super C11521> cVar) {
            super(2, cVar);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C11521 c11521 = new C11521(this.$taskId, cVar);
            c11521.L$0 = obj;
            return c11521;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    String str = this.$taskId;
                    SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = systemSdkBridge.takeoverTask(str, "全屏页防误触提醒内二次点击", this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                objA = (Boolean) obj;
                objA.getClass();
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            String str2 = this.$taskId;
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.b(FullScreenActivity.TAG, B7.a.n("[", str2, "] anti-mistouch takeover failed: ", thA.getMessage()), true);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11521) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onIdleTapInRunning$2", f = "FullScreenActivity.kt", l = {759}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onIdleTapInRunning$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11532 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $taskId;
        int label;
        final /* synthetic */ FullScreenActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11532(String str, FullScreenActivity fullScreenActivity, H7.c<? super C11532> cVar) {
            super(2, cVar);
            this.$taskId = str;
            this.this$0 = fullScreenActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11532(this.$taskId, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                this.label = 1;
                if (kotlinx.coroutines.a.f(3000L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            AbstractC1436a.a(FullScreenActivity.TAG, "[" + this.$taskId + "] antiMistouch: window expired", true);
            this.this$0.dismissAntiMistouchPrompt();
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11532) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$performRecoverFromTakeover$1", f = "FullScreenActivity.kt", l = {McpErrorCode.TOOL_NOT_FOUND}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$performRecoverFromTakeover$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11541 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $taskId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11541(String str, H7.c<? super C11541> cVar) {
            super(2, cVar);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C11541 c11541 = new C11541(this.$taskId, cVar);
            c11541.L$0 = obj;
            return c11541;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    String str = this.$taskId;
                    SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = systemSdkBridge.recoverFromTakeover(str, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                objA = (za.d) obj;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            String str2 = this.$taskId;
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.b(FullScreenActivity.TAG, B7.a.n("[", str2, "] recoverFromTakeover (ack-click) failed: ", thA.getMessage()), true);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11541) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$requestTakeoverFromPassivePrompt$1", f = "FullScreenActivity.kt", l = {914}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$requestTakeoverFromPassivePrompt$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11551 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $taskId;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11551(String str, H7.c<? super C11551> cVar) {
            super(2, cVar);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C11551 c11551 = FullScreenActivity.this.new C11551(this.$taskId, cVar);
            c11551.L$0 = obj;
            return c11551;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        kotlin.b.b(obj);
                        String str = this.$taskId;
                        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.I$0 = 0;
                        this.label = 1;
                        obj = systemSdkBridge.takeoverTask(str, "全屏页被动接管弹窗确认接管", this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.b.b(obj);
                    }
                    objA = (Boolean) obj;
                    objA.getClass();
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                String str2 = this.$taskId;
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    AbstractC1436a.b(FullScreenActivity.TAG, "[" + str2 + "] requestTakeoverFromPassivePrompt failed: " + thA.getMessage(), true);
                }
                FullScreenActivity.this.takeoverRequestInFlight = false;
                return r.f317a;
            } catch (Throwable th2) {
                FullScreenActivity.this.takeoverRequestInFlight = false;
                throw th2;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11551) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$startIdleTimer$1", f = "FullScreenActivity.kt", l = {686}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$startIdleTimer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11571 extends SuspendLambda implements S7.n {
        final /* synthetic */ long $totalMs;
        int label;
        final /* synthetic */ FullScreenActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11571(long j5, FullScreenActivity fullScreenActivity, H7.c<? super C11571> cVar) {
            super(2, cVar);
            this.$totalMs = j5;
            this.this$0 = fullScreenActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11571(this.$totalMs, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                long j5 = this.$totalMs;
                this.label = 1;
                if (kotlinx.coroutines.a.f(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            this.this$0.autoRecoverFromTakeover();
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11571) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyOverlayPhase(OverlayPhase phase, boolean dismissed) {
        String strSurfaceState;
        OverlayPhaseResolver.Visibility visibilityResolveVisibility = OverlayPhaseResolver.INSTANCE.resolveVisibility(phase, dismissed);
        AbstractC1436a.a(TAG, "[" + getViewModel$stepfun_release().getTaskId() + "] applyOverlayPhase: phase=" + phase + ", dismissed=" + dismissed + ", statusBarVisible=" + visibilityResolveVisibility.getStatusBarVisible() + ", passiveDialogVisible=" + visibilityResolveVisibility.getPassiveDialogVisible() + ", ackDialogVisible=" + visibilityResolveVisibility.getAckDialogVisible() + ", miniBarVisible=" + visibilityResolveVisibility.getMiniBarVisible(), true);
        if (phase == OverlayPhase.MINI) {
            String taskId = getViewModel$stepfun_release().getTaskId();
            UnifiedMirrorView unifiedMirrorView = this.mirrorView;
            boolean z10 = unifiedMirrorView != null;
            if (unifiedMirrorView == null || (strSurfaceState = unifiedMirrorView.surfaceState()) == null) {
                strSurfaceState = "mirrorView null";
            }
            boolean zIsFullScreenActivityInForeground$stepfun_release = SystemSdkBridge.INSTANCE.isFullScreenActivityInForeground$stepfun_release();
            StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[", taskId, "] MINI snapshot: mirrorViewAttached=", ", ", z10);
            sbL.append(strSurfaceState);
            sbL.append(", fsForeground=");
            sbL.append(zIsFullScreenActivityInForeground$stepfun_release);
            AbstractC1436a.d(TAG, sbL.toString(), true);
        }
        StatusBarCarouselView statusBarCarouselView = this.statusBar;
        if (statusBarCarouselView == null) {
            kotlin.jvm.internal.k.n("statusBar");
            throw null;
        }
        statusBarCarouselView.setVisibility(visibilityResolveVisibility.getStatusBarVisible() ? 0 : 8);
        if (visibilityResolveVisibility.getStatusBarVisible()) {
            startCarousel();
        } else {
            stopCarousel();
        }
        if (visibilityResolveVisibility.getPassiveDialogVisible()) {
            String str = (String) getViewModel$stepfun_release().getPassivePromptExplainSnapshot().getValue();
            if (str == null) {
                str = (String) getViewModel$stepfun_release().getStepExplain().getValue();
            }
            PassiveTakeoverPromptPopup passiveTakeoverPromptPopup = this.passiveTakeoverPromptPopup;
            if (passiveTakeoverPromptPopup == null) {
                kotlin.jvm.internal.k.n("passiveTakeoverPromptPopup");
                throw null;
            }
            if (passiveTakeoverPromptPopup.isShowing()) {
                PassiveTakeoverPromptPopup passiveTakeoverPromptPopup2 = this.passiveTakeoverPromptPopup;
                if (passiveTakeoverPromptPopup2 == null) {
                    kotlin.jvm.internal.k.n("passiveTakeoverPromptPopup");
                    throw null;
                }
                passiveTakeoverPromptPopup2.setExplain(str);
            } else {
                PassiveTakeoverPromptPopup passiveTakeoverPromptPopup3 = this.passiveTakeoverPromptPopup;
                if (passiveTakeoverPromptPopup3 == null) {
                    kotlin.jvm.internal.k.n("passiveTakeoverPromptPopup");
                    throw null;
                }
                FrameLayout frameLayout = this.rootContainer;
                if (frameLayout == null) {
                    kotlin.jvm.internal.k.n("rootContainer");
                    throw null;
                }
                passiveTakeoverPromptPopup3.show(frameLayout, str);
            }
        } else {
            PassiveTakeoverPromptPopup passiveTakeoverPromptPopup4 = this.passiveTakeoverPromptPopup;
            if (passiveTakeoverPromptPopup4 == null) {
                kotlin.jvm.internal.k.n("passiveTakeoverPromptPopup");
                throw null;
            }
            passiveTakeoverPromptPopup4.dismiss();
        }
        if (visibilityResolveVisibility.getAckDialogVisible() && !this.ackCardVisible) {
            getViewModel$stepfun_release().startAckCountdown();
        }
        BlurCardView blurCardView = this.ackCard;
        if (blurCardView == null) {
            kotlin.jvm.internal.k.n("ackCard");
            throw null;
        }
        blurCardView.setVisibility(visibilityResolveVisibility.getAckDialogVisible() ? 0 : 8);
        this.ackCardVisible = visibilityResolveVisibility.getAckDialogVisible();
        BlurCardView blurCardView2 = this.miniBar;
        if (blurCardView2 != null) {
            blurCardView2.setVisibility(visibilityResolveVisibility.getMiniBarVisible() ? 0 : 8);
        } else {
            kotlin.jvm.internal.k.n("miniBar");
            throw null;
        }
    }

    private final void applySystemBarsMode(boolean hideSystemBars) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        if (hideSystemBars) {
            enableImmersiveSticky();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void applyTaskDescription(java.lang.String r10) throws android.content.res.Resources.NotFoundException {
        /*
            r9 = this;
            java.lang.String r0 = "FullScreenActivity"
            java.lang.String r1 = "["
            int r2 = r10.length()
            r3 = 0
            if (r2 != 0) goto Le
            r9.lastAppliedTaskDescPkg = r3
            return
        Le:
            android.content.Intent r2 = r9.getIntent()
            if (r2 == 0) goto L26
            java.lang.String r4 = "extra_target_package"
            java.lang.String r2 = r2.getStringExtra(r4)
            if (r2 == 0) goto L26
            boolean r4 = j9.m.s0(r2)
            if (r4 != 0) goto L23
            goto L24
        L23:
            r2 = r3
        L24:
            if (r2 != 0) goto L34
        L26:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge r2 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.INSTANCE
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r2 = r2.getTask(r10)
            if (r2 == 0) goto L33
            java.lang.String r2 = r2.getTargetPackageName()
            goto L34
        L33:
            r2 = r3
        L34:
            android.content.res.Resources r4 = r9.getResources()
            r5 = 17104896(0x1050000, float:2.4428242E-38)
            int r4 = r4.getDimensionPixelSize(r5)
            if (r2 == 0) goto L64
            int r5 = r2.length()
            if (r5 != 0) goto L47
            goto L64
        L47:
            com.stepos.taskrobot.llmapi.stepfun.PackageUtil r5 = com.stepos.taskrobot.llmapi.stepfun.PackageUtil.INSTANCE
            kotlin.Pair r6 = r5.getAppInfoByPackageName(r9, r2)
            if (r6 == 0) goto L5e
            java.lang.Object r6 = r6.f4886a
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L5e
            boolean r7 = j9.m.s0(r6)
            if (r7 != 0) goto L5c
            r3 = r6
        L5c:
            if (r3 != 0) goto L5f
        L5e:
            r3 = r2
        L5f:
            android.graphics.Bitmap r4 = r5.loadAppIconBitmap(r9, r2, r4)
            goto L72
        L64:
            r4 = 6
            java.lang.String r4 = j9.m.O0(r4, r10)
            java.lang.String r5 = "任务 "
            java.lang.String r4 = r5.concat(r4)
            r8 = r4
            r4 = r3
            r3 = r8
        L72:
            r5 = 1
            android.app.ActivityManager$TaskDescription r6 = new android.app.ActivityManager$TaskDescription     // Catch: java.lang.Throwable -> Lac
            r6.<init>(r3, r4)     // Catch: java.lang.Throwable -> Lac
            r9.setTaskDescription(r6)     // Catch: java.lang.Throwable -> Lac
            r9.lastAppliedTaskDescPkg = r2     // Catch: java.lang.Throwable -> Lac
            if (r4 == 0) goto L81
            r9 = r5
            goto L82
        L81:
            r9 = 0
        L82:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r4.<init>(r1)     // Catch: java.lang.Throwable -> Lac
            r4.append(r10)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "] applyTaskDescription: label="
            r4.append(r6)     // Catch: java.lang.Throwable -> Lac
            r4.append(r3)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = ", hasIcon="
            r4.append(r3)     // Catch: java.lang.Throwable -> Lac
            r4.append(r9)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = ", pkg="
            r4.append(r9)     // Catch: java.lang.Throwable -> Lac
            r4.append(r2)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Throwable -> Lac
            f6.AbstractC1436a.d(r0, r9, r5)     // Catch: java.lang.Throwable -> Lac
            C7.r r9 = C7.r.f317a     // Catch: java.lang.Throwable -> Lac
            goto Lb1
        Lac:
            r9 = move-exception
            kotlin.Result$Failure r9 = kotlin.b.a(r9)
        Lb1:
            java.lang.Throwable r9 = kotlin.Result.a(r9)
            if (r9 == 0) goto Lc4
            java.lang.String r9 = r9.getMessage()
            java.lang.String r2 = "] applyTaskDescription failed: "
            java.lang.String r9 = B7.a.n(r1, r10, r2, r9)
            f6.AbstractC1436a.b(r0, r9, r5)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.applyTaskDescription(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoRecoverFromTakeover() {
        String taskId = getViewModel$stepfun_release().getTaskId();
        if (taskId.length() == 0) {
            return;
        }
        com.stepos.statsrpk.service.c.p("[", taskId, "] autoRecoverFromTakeover: idle timeout reached", TAG, true);
        cancelAllTimers();
        this.autoRecoverJob = AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new AnonymousClass1(taskId, null), 3);
    }

    private final void bindTaskUiState(String taskId) {
        if (taskId.length() == 0) {
            return;
        }
        this.taskUiJob = AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11501(taskId, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelAllTimers() {
        getViewModel$stepfun_release().cancelAckCountdown();
        getViewModel$stepfun_release().cancelResumeFallback();
        cancelIdleTimer();
        cancelAutoRecover();
        cancelAntiMistouchPromptJob();
        dismissAntiMistouchPrompt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelAntiMistouchPromptJob() {
        c0 c0Var = this.antiMistouchPromptJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.antiMistouchPromptJob = null;
    }

    private final void cancelAutoRecover() {
        c0 c0Var = this.autoRecoverJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.autoRecoverJob = null;
    }

    private final void cancelIdleTimer() {
        c0 c0Var = this.idleTimerJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.idleTimerJob = null;
    }

    private final void clearMirrorView() {
        UnifiedMirrorView unifiedMirrorView = this.mirrorView;
        if (unifiedMirrorView == null) {
            return;
        }
        getLifecycle().removeObserver(unifiedMirrorView);
        ViewParent parent = unifiedMirrorView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(unifiedMirrorView);
        }
        this.mirrorView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissAntiMistouchPrompt() {
        AntiMistouchBubbleView antiMistouchBubbleView = this.antiMistouchBubble;
        if (antiMistouchBubbleView != null) {
            antiMistouchBubbleView.dismiss();
        }
    }

    private final int dp(float value) {
        return (int) TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitRequestChatInput() throws JSONException {
        Object objA;
        String taskId = getViewModel$stepfun_release().getTaskId();
        ZyqlGuiAgentTask task = SystemSdkBridge.INSTANCE.getTask(taskId);
        if (task != null) {
            task.getChatSessionId();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, taskId);
        String string = jSONObject.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        r rVar = null;
        if (task != null) {
            try {
                task.notifyProgressChanged(Actions.REQUEST_CHAT_INPUT, null, null, string);
                rVar = r.f317a;
                objA = rVar;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = rVar;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] emitRequestChatInput failed: ", thA.getMessage()), true);
        }
    }

    private final void emitRequestChatInputFromHandle() throws JSONException {
        Object objA;
        String taskId = getViewModel$stepfun_release().getTaskId();
        ZyqlGuiAgentTask task = SystemSdkBridge.INSTANCE.getTask(taskId);
        r rVar = null;
        String chatSessionId = task != null ? task.getChatSessionId() : null;
        if (chatSessionId == null) {
            chatSessionId = "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, taskId);
        jSONObject.put("chatSessionId", chatSessionId);
        String string = jSONObject.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        if (task != null) {
            try {
                task.notifyProgressChanged(Actions.REQUEST_CHAT_INPUT_FROM_HANDLE, null, null, string);
                rVar = r.f317a;
                objA = rVar;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = rVar;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] emitRequestChatInputFromHandle failed: ", thA.getMessage()), true);
        }
    }

    private final void enableImmersiveSticky() {
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        kotlin.jvm.internal.k.e(insetsController, "getInsetsController(...)");
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
    }

    private final void handleIntent(Intent intent) {
        String strResolveCurrentTaskId$stepfun_release;
        String stringExtra = intent.getStringExtra("extra_task_id");
        if (stringExtra == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null || (strResolveCurrentTaskId$stepfun_release = SystemSdkBridge.INSTANCE.resolveCurrentTaskId$stepfun_release(data)) == null) {
            strResolveCurrentTaskId$stepfun_release = stringExtra;
        }
        if (!strResolveCurrentTaskId$stepfun_release.equals(stringExtra)) {
            AbstractC1436a.d(TAG, B7.a.n("handleIntent: intent taskId=", stringExtra, ", resolved via docUri to ", strResolveCurrentTaskId$stepfun_release), true);
        }
        updateTaskId$stepfun_release(strResolveCurrentTaskId$stepfun_release);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initViews() {
        View viewFindViewById = findViewById(R.id.full_screen_root);
        kotlin.jvm.internal.k.e(viewFindViewById, "findViewById(...)");
        this.rootContainer = (FrameLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.mirror_container);
        kotlin.jvm.internal.k.e(viewFindViewById2, "findViewById(...)");
        this.mirrorContainer = (FrameLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.glow_overlay);
        View viewFindViewById4 = findViewById(R.id.status_bar);
        kotlin.jvm.internal.k.e(viewFindViewById4, "findViewById(...)");
        this.statusBar = (StatusBarCarouselView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.ack_card);
        kotlin.jvm.internal.k.e(viewFindViewById5, "findViewById(...)");
        this.ackCard = (BlurCardView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.mini_bar);
        kotlin.jvm.internal.k.e(viewFindViewById6, "findViewById(...)");
        this.miniBar = (BlurCardView) viewFindViewById6;
        setupOverlayCards();
        setupOverlayListeners();
        StatusBarCarouselController statusBarCarouselController = new StatusBarCarouselController(LifecycleOwnerKt.getLifecycleScope(this), 0L, 2, null);
        this.carouselController = statusBarCarouselController;
        StatusBarCarouselView statusBarCarouselView = this.statusBar;
        if (statusBarCarouselView == null) {
            kotlin.jvm.internal.k.n("statusBar");
            throw null;
        }
        statusBarCarouselView.bindController(statusBarCarouselController);
        viewFindViewById3.setOnTouchListener(new com.google.android.material.textfield.g(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$0(FullScreenActivity fullScreenActivity, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[((OverlayPhase) fullScreenActivity.getViewModel$stepfun_release().getOverlayPhase().getValue()).ordinal()];
        if (i == 1 || i == 2) {
            if (((Boolean) fullScreenActivity.getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue()) {
                fullScreenActivity.onMirrorViewTouched();
            }
            return false;
        }
        if (i == 3) {
            if (((Boolean) fullScreenActivity.getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue()) {
                fullScreenActivity.onMirrorViewTouched();
                fullScreenActivity.getViewModel$stepfun_release().setOverlayPhase(OverlayPhase.TAKEOVER_ACK);
            }
            return false;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (((Boolean) fullScreenActivity.getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue()) {
            fullScreenActivity.onMirrorViewTouched();
            return false;
        }
        fullScreenActivity.onIdleTapInRunning(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    private final void installFreshMirrorView() {
        clearMirrorView();
        UnifiedMirrorView unifiedMirrorView = new UnifiedMirrorView(this, null, 0, 6, null);
        this.mirrorView = unifiedMirrorView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = this.mirrorContainer;
        if (frameLayout == null) {
            kotlin.jvm.internal.k.n("mirrorContainer");
            throw null;
        }
        frameLayout.addView(unifiedMirrorView, 0, layoutParams);
        unifiedMirrorView.setForwardTouchEventEnable(false);
        AbstractC1436a.a(TAG, "[" + getViewModel$stepfun_release().getTaskId() + "] installFreshMirrorView: setForwardTouchEventEnable(false)", true);
        getLifecycle().addObserver(unifiedMirrorView);
    }

    private final boolean isAutoRecovering() {
        c0 c0Var = this.autoRecoverJob;
        return c0Var != null && c0Var.isActive();
    }

    private final void observeOverlayState() {
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11511(null), 3);
    }

    private final void onIdleTapInRunning(float touchX, float touchY) {
        String taskId = getViewModel$stepfun_release().getTaskId();
        c0 c0Var = this.antiMistouchPromptJob;
        if (c0Var != null && c0Var.isActive()) {
            cancelAntiMistouchPromptJob();
            dismissAntiMistouchPrompt();
            if (taskId.length() == 0) {
                return;
            }
            com.stepos.statsrpk.service.c.p("[", taskId, "] antiMistouch: second tap → takeoverTask", TAG, true);
            AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11521(taskId, null), 3);
            return;
        }
        AbstractC1436a.d(TAG, "[" + taskId + "] antiMistouch: prompt shown at (" + touchX + ", " + touchY + ")", true);
        showAntiMistouchPrompt(touchX, touchY);
        this.antiMistouchPromptJob = AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11532(taskId, this, null), 3);
    }

    private final void onMirrorViewTouched() {
        if (((Boolean) getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue() && !isAutoRecovering()) {
            resetIdleTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPassiveHandlePulledUp() throws JSONException {
        emitRequestChatInputFromHandle();
    }

    private final void onVirtualLauncherForegrounded(ForegroundAppInfo info) {
        String previousPackageName;
        if (((Boolean) getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue() && (previousPackageName = info.getPreviousPackageName()) != null && !previousPackageName.equals(LAUNCHER_PACKAGE) && getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            runOnUiThread(new I4.l(14, this, previousPackageName));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performRecoverFromTakeover() {
        String taskId = getViewModel$stepfun_release().getTaskId();
        if (taskId.length() == 0) {
            return;
        }
        this.pendingRecoverOnTakeover = false;
        cancelAllTimers();
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11541(taskId, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestTakeoverFromPassivePrompt() {
        String taskId = getViewModel$stepfun_release().getTaskId();
        if (taskId.length() == 0) {
            return;
        }
        if (!this.takeoverRequestInFlight) {
            this.takeoverRequestInFlight = true;
            cancelAllTimers();
            AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11551(taskId, null), 3);
        } else {
            AbstractC1436a.a(TAG, "[" + taskId + "] requestTakeoverFromPassivePrompt: already in-flight, skip", true);
        }
    }

    private final void resetIdleTimer() {
        startIdleTimer();
    }

    private final void setupOverlayCards() {
        BlurCardView blurCardView = this.ackCard;
        if (blurCardView == null) {
            kotlin.jvm.internal.k.n("ackCard");
            throw null;
        }
        blurCardView.setUp(R.layout.view_takeover_ack_card, R.id.ack_card_body, getResources().getDimensionPixelSize(R.dimen.takeover_ack_blur_radius), getResources().getDimension(R.dimen.takeover_ack_corner_radius));
        BlurCardView blurCardView2 = this.miniBar;
        if (blurCardView2 == null) {
            kotlin.jvm.internal.k.n("miniBar");
            throw null;
        }
        blurCardView2.setUp(R.layout.view_mini_bar, R.id.mini_bar_body, getResources().getDimensionPixelSize(R.dimen.mini_bar_blur_radius), getResources().getDimension(R.dimen.mini_bar_corner_radius));
        BlurCardView blurCardView3 = this.ackCard;
        if (blurCardView3 == null) {
            kotlin.jvm.internal.k.n("ackCard");
            throw null;
        }
        final int i = 0;
        blurCardView3.getContentView().findViewById(R.id.ack_card_body).setOnClickListener(new View.OnClickListener(this) { // from class: com.stepos.taskrobot.llmapi.stepfun.b
            public final /* synthetic */ FullScreenActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                FullScreenActivity fullScreenActivity = this.b;
                switch (i6) {
                    case 0:
                        fullScreenActivity.onAckCardClicked();
                        break;
                    default:
                        fullScreenActivity.onMiniBarClicked();
                        break;
                }
            }
        });
        BlurCardView blurCardView4 = this.miniBar;
        if (blurCardView4 == null) {
            kotlin.jvm.internal.k.n("miniBar");
            throw null;
        }
        final int i6 = 1;
        blurCardView4.getContentView().findViewById(R.id.mini_bar_body).setOnClickListener(new View.OnClickListener(this) { // from class: com.stepos.taskrobot.llmapi.stepfun.b
            public final /* synthetic */ FullScreenActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                FullScreenActivity fullScreenActivity = this.b;
                switch (i62) {
                    case 0:
                        fullScreenActivity.onAckCardClicked();
                        break;
                    default:
                        fullScreenActivity.onMiniBarClicked();
                        break;
                }
            }
        });
    }

    private final void setupOverlayListeners() {
        StatusBarCarouselView statusBarCarouselView = this.statusBar;
        if (statusBarCarouselView == null) {
            kotlin.jvm.internal.k.n("statusBar");
            throw null;
        }
        statusBarCarouselView.setListener(new StatusBarCarouselView.Listener() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.setupOverlayListeners.1
            @Override // com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView.Listener
            public void onLeftZoneClick() throws JSONException {
                FullScreenActivity.this.emitRequestChatInput();
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.view.StatusBarCarouselView.Listener
            public void onStopClick() throws RemoteException {
                FullScreenActivity.this.stopTaskFromOverlay("用户主动取消任务，点击全屏页底部状态条停止任务");
            }
        });
        StatusBarCarouselView statusBarCarouselView2 = this.statusBar;
        if (statusBarCarouselView2 != null) {
            statusBarCarouselView2.setOnPulledUp(new D6.i(this, 23));
        } else {
            kotlin.jvm.internal.k.n("statusBar");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setupOverlayListeners$lambda$0(FullScreenActivity fullScreenActivity) throws JSONException {
        fullScreenActivity.onOverlayPulledUp();
        return r.f317a;
    }

    private final void setupSurfaceCallback() {
    }

    private final void showAntiMistouchPrompt(float touchX, float touchY) {
        FullScreenActivity fullScreenActivity;
        AntiMistouchBubbleView antiMistouchBubbleView = this.antiMistouchBubble;
        if (antiMistouchBubbleView == null) {
            fullScreenActivity = this;
            AntiMistouchBubbleView antiMistouchBubbleView2 = new AntiMistouchBubbleView(fullScreenActivity, null, 0, 6, null);
            antiMistouchBubbleView2.setText(R.string.fullscreen_anti_mistouch_prompt);
            fullScreenActivity.antiMistouchBubble = antiMistouchBubbleView2;
            antiMistouchBubbleView = antiMistouchBubbleView2;
        } else {
            fullScreenActivity = this;
        }
        FrameLayout frameLayout = fullScreenActivity.rootContainer;
        if (frameLayout != null) {
            antiMistouchBubbleView.show(touchX, touchY, frameLayout);
        } else {
            kotlin.jvm.internal.k.n("rootContainer");
            throw null;
        }
    }

    private final void startCarousel() {
        StatusBarCarouselController statusBarCarouselController = this.carouselController;
        if (statusBarCarouselController != null) {
            statusBarCarouselController.start();
        } else {
            kotlin.jvm.internal.k.n("carouselController");
            throw null;
        }
    }

    private final void startIdleTimer() {
        c0 c0Var = this.idleTimerJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        long takeoverIdleTimeoutMs = getViewModel$stepfun_release().getTakeoverIdleTimeoutMs();
        if (takeoverIdleTimeoutMs <= 0) {
            return;
        }
        this.idleTimerJob = AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11571(takeoverIdleTimeoutMs, this, null), 3);
    }

    private final void startLauncherWatcher() {
        Object objA;
        if (this.launcherWatcherId != null) {
            return;
        }
        String taskId = getViewModel$stepfun_release().getTaskId();
        if (taskId.length() == 0) {
            return;
        }
        Task mdiTask = SystemSdkBridge.INSTANCE.getMdiTask(taskId);
        if (mdiTask == null) {
            B7.a.z("[", taskId, "] startLauncherWatcher: mdiTask is null, skip", TAG, true);
            return;
        }
        try {
            int displayId = mdiTask.getDisplayId();
            String strRegisterForegroundAppObserver = mdiTask.registerForegroundAppObserver(new D6.d(displayId, 10), new c(this, 0));
            this.launcherWatcherId = strRegisterForegroundAppObserver;
            AbstractC1436a.d(TAG, "[" + taskId + "] launcher watcher registered, displayId=" + displayId + ", regId=" + strRegisterForegroundAppObserver, true);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] startLauncherWatcher failed: ", thA.getMessage()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r startLauncherWatcher$lambda$0$0(int i, ForegroundAppFilter.Builder registerForegroundAppObserver) {
        kotlin.jvm.internal.k.f(registerForegroundAppObserver, "$this$registerForegroundAppObserver");
        registerForegroundAppObserver.forDisplay(i);
        registerForegroundAppObserver.forPackage(LAUNCHER_PACKAGE);
        registerForegroundAppObserver.onAppChange(true);
        registerForegroundAppObserver.onActivityChange(false);
        registerForegroundAppObserver.onLeave(false);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLauncherWatcher$lambda$0$1(FullScreenActivity fullScreenActivity, ForegroundAppInfo info) {
        kotlin.jvm.internal.k.f(info, "info");
        fullScreenActivity.onVirtualLauncherForegrounded(info);
    }

    private final void stopCarousel() {
        StatusBarCarouselController statusBarCarouselController = this.carouselController;
        if (statusBarCarouselController != null) {
            statusBarCarouselController.stop();
        } else {
            kotlin.jvm.internal.k.n("carouselController");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopLauncherWatcher() {
        String str = this.launcherWatcherId;
        if (str == null) {
            return;
        }
        this.launcherWatcherId = null;
        String taskId = getViewModel$stepfun_release().getTaskId();
        try {
            Task mdiTask = SystemSdkBridge.INSTANCE.getMdiTask(taskId);
            if (mdiTask != null) {
                mdiTask.unregisterForegroundAppObserver(str);
            }
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
        AbstractC1436a.a(TAG, androidx.appfunctions.metadata.a.m("[", taskId, "] launcher watcher stopped (regId=", str, ")"), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopTaskFromOverlay(String reason) throws RemoteException {
        String taskId = getViewModel$stepfun_release().getTaskId();
        if (taskId.length() == 0) {
            return;
        }
        cancelAllTimers();
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        ZyqlGuiAgentTask task = systemSdkBridge.getTask(taskId);
        String chatSessionId = task != null ? task.getChatSessionId() : null;
        if (chatSessionId == null) {
            chatSessionId = "";
        }
        String str = chatSessionId;
        boolean z10 = false;
        if (task != null && task.hasActiveProgressCallback$stepfun_release()) {
            z10 = true;
        }
        StringBuilder sbW = B7.a.w("[", taskId, "] stopTaskFromOverlay: reason=", reason, ", hasCallback=");
        sbW.append(z10);
        sbW.append(", chatSessionId=");
        sbW.append(str);
        AbstractC1436a.d(TAG, sbW.toString(), true);
        if (z10) {
            SystemSdkBridge.notifyProgressChanged$default(systemSdkBridge, taskId, Actions.USER_CANCEL, null, null, str, 12, null);
        } else {
            SystemSdkBridge.clearTask$default(systemSdkBridge, taskId, false, reason, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerExitWithMask(String prevPackage) {
        AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", getViewModel$stepfun_release().getTaskId(), "] virtual launcher detected (prev=", prevPackage, "), exiting fullscreen"), true);
        stopLauncherWatcher();
        cancelAllTimers();
        findViewById(R.id.exit_mask).setVisibility(0);
        finish();
    }

    public final UnifiedMirrorView getMirrorView$stepfun_release() {
        UnifiedMirrorView unifiedMirrorView = this.mirrorView;
        if (unifiedMirrorView != null) {
            return unifiedMirrorView;
        }
        throw new IllegalStateException("mirrorView not installed; onResume must run before bind");
    }

    public final FullScreenActivityViewModel getViewModel$stepfun_release() {
        FullScreenActivityViewModel fullScreenActivityViewModel = this.viewModel;
        if (fullScreenActivityViewModel != null) {
            return fullScreenActivityViewModel;
        }
        kotlin.jvm.internal.k.n("viewModel");
        throw null;
    }

    public final void migrateToNewTask$stepfun_release(String newTaskId) throws Resources.NotFoundException {
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        Intent intent = new Intent(getIntent());
        intent.putExtra("extra_task_id", newTaskId);
        setIntent(intent);
        updateTaskId$stepfun_release(newTaskId);
        applyTaskDescription(newTaskId);
        AbstractC1436a.d(TAG, "migrateToNewTask: rebound to ".concat(newTaskId), true);
    }

    public final void notifyTakeoverAcknowledged$stepfun_release() {
        AbstractC1436a.d(TAG, "[" + getViewModel$stepfun_release().getTaskId() + "] notifyTakeoverAcknowledged: touchEnabled=" + getViewModel$stepfun_release().getTouchEnabled().getValue() + ", overlayPhase=" + getViewModel$stepfun_release().getOverlayPhase().getValue(), true);
        getViewModel$stepfun_release().cancelResumeFallback();
        getViewModel$stepfun_release().setOverlayDismissed(false);
        int i = WhenMappings.$EnumSwitchMapping$0[((OverlayPhase) getViewModel$stepfun_release().getOverlayPhase().getValue()).ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            getViewModel$stepfun_release().setOverlayPhase(OverlayPhase.TAKEOVER_ACK);
        }
        resetIdleTimer();
        startLauncherWatcher();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void notifyTakeoverFromLlm$stepfun_release() {
        /*
            r5 = this;
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r0 = r5.getViewModel$stepfun_release()
            java.lang.String r0 = r0.getTaskId()
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r1 = r5.getViewModel$stepfun_release()
            p9.t r1 = r1.getTouchEnabled()
            java.lang.Object r1 = r1.getValue()
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r2 = r5.getViewModel$stepfun_release()
            p9.t r2 = r2.getOverlayPhase()
            java.lang.Object r2 = r2.getValue()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "["
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = "] notifyTakeoverFromLlm: touchEnabled="
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = ", overlayPhase="
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r1 = 1
            java.lang.String r2 = "FullScreenActivity"
            f6.AbstractC1436a.d(r2, r0, r1)
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r0 = r5.getViewModel$stepfun_release()
            r0.cancelResumeFallback()
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r0 = r5.getViewModel$stepfun_release()
            r1 = 0
            r0.setOverlayDismissed(r1)
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge r0 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.INSTANCE
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r1 = r5.getViewModel$stepfun_release()
            java.lang.String r1 = r1.getTaskId()
            java.lang.String r0 = r0.getLastLlmTakeoverMessage$stepfun_release(r1)
            if (r0 == 0) goto L6e
            boolean r1 = j9.m.s0(r0)
            if (r1 != 0) goto L6a
            goto L6b
        L6a:
            r0 = 0
        L6b:
            if (r0 == 0) goto L6e
            goto L7c
        L6e:
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r0 = r5.getViewModel$stepfun_release()
            p9.t r0 = r0.getStepExplain()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
        L7c:
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r1 = r5.getViewModel$stepfun_release()
            r1.setPassivePromptExplainSnapshot(r0)
            com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel r0 = r5.getViewModel$stepfun_release()
            com.stepos.taskrobot.llmapi.stepfun.OverlayPhase r1 = com.stepos.taskrobot.llmapi.stepfun.OverlayPhase.PASSIVE_PROMPT
            r0.setOverlayPhase(r1)
            r5.startLauncherWatcher()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity.notifyTakeoverFromLlm$stepfun_release():void");
    }

    public final void onAckCardClicked() {
        getViewModel$stepfun_release().cancelAckCountdown();
        String taskId = getViewModel$stepfun_release().getTaskId();
        if (taskId.length() == 0) {
            return;
        }
        if (getViewModel$stepfun_release().getTaskState().getValue() == SessionState.f) {
            performRecoverFromTakeover();
        } else {
            com.stepos.statsrpk.service.c.p("[", taskId, "] ackCard: session not yet MANUAL_TAKEOVER, pending recover", TAG, true);
            this.pendingRecoverOnTakeover = true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("extra_task_id") : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        applyTaskDescription(stringExtra);
        setContentView(R.layout.activity_full_screen);
        applySystemBarsMode(true);
        setViewModel$stepfun_release((FullScreenActivityViewModel) new ViewModelProvider(this).get(FullScreenActivityViewModel.class));
        initViews();
        PassiveTakeoverPromptPopup passiveTakeoverPromptPopup = new PassiveTakeoverPromptPopup(this);
        passiveTakeoverPromptPopup.setListener(new PassiveTakeoverPromptPopup.Listener() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity$onCreate$1$1
            @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup.Listener
            public void onHandlePulledUp() throws JSONException {
                this.this$0.onPassiveHandlePulledUp();
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup.Listener
            public void onStopClicked() throws RemoteException {
                this.this$0.onStopBtnClicked();
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.PassiveTakeoverPromptPopup.Listener
            public void onTakeoverClicked() {
                this.this$0.requestTakeoverFromPassivePrompt();
            }
        });
        this.passiveTakeoverPromptPopup = passiveTakeoverPromptPopup;
        setupSurfaceCallback();
        Intent intent2 = getIntent();
        kotlin.jvm.internal.k.e(intent2, "getIntent(...)");
        handleIntent(intent2);
        SystemSdkBridge.INSTANCE.onFullScreenActivityCreated$stepfun_release(this);
        getOnBackPressedDispatcher().addCallback(this, this.backCallback);
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new AnonymousClass2(null), 3);
        observeOverlayState();
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new AnonymousClass3(null), 3);
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new AnonymousClass4(null), 3);
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new AnonymousClass5(null), 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PassiveTakeoverPromptPopup passiveTakeoverPromptPopup = this.passiveTakeoverPromptPopup;
        if (passiveTakeoverPromptPopup != null) {
            passiveTakeoverPromptPopup.dismiss();
        }
        clearMirrorView();
        c0 c0Var = this.taskUiJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        cancelAllTimers();
        stopLauncherWatcher();
        StatusBarCarouselView statusBarCarouselView = this.statusBar;
        if (statusBarCarouselView == null) {
            kotlin.jvm.internal.k.n("statusBar");
            throw null;
        }
        statusBarCarouselView.unbindController();
        SystemSdkBridge.INSTANCE.onFullScreenActivityDestroyed$stepfun_release(this, getViewModel$stepfun_release().getTaskId());
        super.onDestroy();
    }

    public final void onDismissRequested() {
        getViewModel$stepfun_release().setOverlayDismissed(true);
        getViewModel$stepfun_release().startResumeFallback();
    }

    public final void onMiniBarClicked() {
        onAckCardClicked();
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws Resources.NotFoundException {
        kotlin.jvm.internal.k.f(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
        applyTaskDescription(getViewModel$stepfun_release().getTaskId());
    }

    public final void onOverlayPulledUp() throws JSONException {
        getViewModel$stepfun_release().setOverlayDismissed(true);
        getViewModel$stepfun_release().startResumeFallback();
        emitRequestChatInputFromHandle();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        SystemSdkBridge.INSTANCE.onFullScreenActivityBackground$stepfun_release(getViewModel$stepfun_release().getTaskId());
        cancelIdleTimer();
        cancelAntiMistouchPromptJob();
        dismissAntiMistouchPrompt();
        StatusBarCarouselController statusBarCarouselController = this.carouselController;
        if (statusBarCarouselController == null) {
            kotlin.jvm.internal.k.n("carouselController");
            throw null;
        }
        statusBarCarouselController.stop();
        stopLauncherWatcher();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        installFreshMirrorView();
        enableImmersiveSticky();
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        systemSdkBridge.ensureFullScreenActivityRegistered$stepfun_release(this);
        systemSdkBridge.onFullScreenActivityForeground$stepfun_release(getViewModel$stepfun_release().getTaskId());
        int i = WhenMappings.$EnumSwitchMapping$0[((OverlayPhase) getViewModel$stepfun_release().getOverlayPhase().getValue()).ordinal()];
        if (i == 1) {
            resetIdleTimer();
        } else if (i != 2) {
            if (i != 3 && i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (((Boolean) getViewModel$stepfun_release().getTouchEnabled().getValue()).booleanValue()) {
            resetIdleTimer();
        }
        startLauncherWatcher();
    }

    public final void onResumeRequested() {
        getViewModel$stepfun_release().cancelResumeFallback();
        getViewModel$stepfun_release().resume();
        if (getViewModel$stepfun_release().getOverlayPhase().getValue() == OverlayPhase.PASSIVE_PROMPT) {
            PassiveTakeoverPromptPopup passiveTakeoverPromptPopup = this.passiveTakeoverPromptPopup;
            if (passiveTakeoverPromptPopup != null) {
                passiveTakeoverPromptPopup.restoreHandle();
            } else {
                kotlin.jvm.internal.k.n("passiveTakeoverPromptPopup");
                throw null;
            }
        }
    }

    public final void onStopBtnClicked() throws RemoteException {
        stopTaskFromOverlay("用户主动取消任务，全屏页被动接管弹窗停止任务");
    }

    public final void setViewModel$stepfun_release(FullScreenActivityViewModel fullScreenActivityViewModel) {
        kotlin.jvm.internal.k.f(fullScreenActivityViewModel, "<set-?>");
        this.viewModel = fullScreenActivityViewModel;
    }

    public final void updateTaskId$stepfun_release(String newTaskId) {
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        boolean zEquals = newTaskId.equals(getViewModel$stepfun_release().getTaskId());
        c0 c0Var = this.taskUiJob;
        boolean z10 = c0Var != null && c0Var.isActive();
        if (zEquals && z10) {
            com.stepos.statsrpk.service.c.p("updateTaskId: taskId unchanged (", newTaskId, "), skip", TAG, true);
            return;
        }
        if (zEquals) {
            com.stepos.statsrpk.service.c.p("updateTaskId: rebinding ui state collector for ", newTaskId, " (activity rebuilt)", TAG, true);
        } else {
            String taskId = getViewModel$stepfun_release().getTaskId();
            stopLauncherWatcher();
            getViewModel$stepfun_release().setTaskId(newTaskId);
            getViewModel$stepfun_release().setTouchEnabled(false);
            getViewModel$stepfun_release().setTaskState(null);
            getViewModel$stepfun_release().setStepExplain("");
            this.pendingRecoverOnTakeover = false;
            getViewModel$stepfun_release().setPassivePromptExplainSnapshot(null);
            getViewModel$stepfun_release().setOverlayPhase(OverlayPhase.RUNNING);
            cancelAllTimers();
            AbstractC1436a.e(TAG, B7.a.n("updateTaskId: cross-task update unexpected in multi-instance mode: ", taskId, " → ", newTaskId), true);
        }
        c0 c0Var2 = this.taskUiJob;
        if (c0Var2 != null) {
            c0Var2.cancel(null);
        }
        bindTaskUiState(newTaskId);
        if (zEquals) {
            return;
        }
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        if (systemSdkBridge.isFullScreenActivityInForeground$stepfun_release()) {
            systemSdkBridge.onFullScreenActivityForeground$stepfun_release(newTaskId);
            startLauncherWatcher();
        }
    }
}
