package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.VirtualDisplayCgroupHelper;
import f6.AbstractC1436a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.t;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 n2\u00020\u0001:\u0003nopB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0004\b\u0010\u0010\u000eJ#\u0010\u0012\u001a\u00020\f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u0015J'\u0010\"\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b#\u0010\u0015J\u0017\u0010$\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010\u0015J+\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b)\u0010*J+\u0010+\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b+\u0010,J+\u0010-\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b-\u0010,J+\u0010.\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b.\u0010,J3\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b0\u00101J+\u00102\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b2\u0010,JL\u00105\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b2\u001c\u00104\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f03\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0086@¢\u0006\u0004\b5\u00106J3\u00108\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u00107\u001a\u00020\u000f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\b¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b:\u0010\u0015J\u001b\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\bE\u0010\u0015J\r\u0010F\u001a\u00020\u000f¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020\u000f¢\u0006\u0004\bH\u0010GJ\u0015\u0010I\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\bK\u0010JJ\u0015\u0010L\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\bL\u0010JJ/\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020O\u0018\u00010N2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010M\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\bR\u0010JJ\u0017\u0010S\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\bS\u0010JJ'\u0010V\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000fH\u0002¢\u0006\u0004\bV\u0010WJ=\u0010Y\u001a\u00020\f2\u0006\u0010X\u001a\u00020O2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u00107\u001a\u00020\u000f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00170\bH\u0002¢\u0006\u0004\bY\u0010ZJ\u001f\u0010[\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b[\u0010\\J\u001f\u0010]\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b]\u0010^R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010_R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010`R \u0010b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020O0a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR \u0010d\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\t0a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR \u0010g\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010cR$\u0010h\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010iR$\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR&\u0010m\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0l0a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010c¨\u0006q"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper;", "", "Landroid/content/Context;", "context", "Landroid/os/Handler;", "mainHandler", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/os/Handler;)V", "Lkotlin/Function1;", "", "Lstepai/aios/guiagent/model/SessionState;", "provider", "LC7/r;", "setSessionStateProvider", "(LS7/k;)V", "", "setLlmTakeoverPendingProvider", "listener", "setOnFullscreenTouchInjectionEnabled", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "clearInteractionPolicy", "(Ljava/lang/String;)V", "enableInteraction", "Lcom/mdisdk/Task;", "taskProvider", "showActivity", "(Ljava/lang/String;Ljava/lang/Boolean;LS7/k;)V", "hideActivity", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "newTask", "migrateEntry$stepfun_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;)V", "migrateEntry", "dismissFullScreenOverlay", "resumeFullScreenOverlay", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;", "activity", "onActivityCreated", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;LS7/k;)V", "ensureActivityRegistered", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;)V", "onActivityForeground", "(Ljava/lang/String;LS7/k;)V", "maybeRefreshTouchForFollowMode", "onActivityBackground", "destroyed", "onActivityDestroyed", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;Ljava/lang/String;LS7/k;)V", "onLlmRequestTakeover", "LH7/c;", "switchToMain", "onTaskCompleted", "(Ljava/lang/String;LS7/k;LS7/k;LH7/c;)Ljava/lang/Object;", "enabled", "updateInteraction", "(Ljava/lang/String;ZLS7/k;)V", "clearDesiredInteractionAfterRecover", "Lp9/t;", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$FullScreenTaskUiState;", "observeTaskUiState", "(Ljava/lang/String;)Lp9/t;", "state", "updateTaskState", "(Ljava/lang/String;Lstepai/aios/guiagent/model/SessionState;)V", "explain", "updateTaskExplain", "(Ljava/lang/String;Ljava/lang/String;)V", "clearTaskUiState", "isAnyInForeground", "()Z", "isAnyInteractionEnabled", "getInteractionEnabled", "(Ljava/lang/String;)Z", "isTaskBoundAndInForeground", "isTaskTakenOverByExternal", "caller", "Lkotlin/Pair;", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$ActivityEntry;", "resolveOverlayTarget", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "moveExistingDocumentToFront", "resolveTouchEnabled", "resolved", "wasInteractionEnabled", "shouldPostTakeoverPanelNotify", "(Ljava/lang/String;ZZ)Z", "entry", "updateInteractionInternal", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$ActivityEntry;Ljava/lang/String;ZLS7/k;)V", "attachMirrorView", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;Ljava/lang/String;)Z", "detachMirrorView", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/os/Handler;", "Ljava/util/concurrent/ConcurrentHashMap;", "entries", "Ljava/util/concurrent/ConcurrentHashMap;", "activityToTaskId", "pendingInteractionTaskId", "Ljava/lang/String;", "interactionExplicitOverride", "sessionStateProvider", "LS7/k;", "llmTakeoverPendingProvider", "onFullscreenTouchInjectionEnabled", "Lp9/j;", "uiStateMap", "Companion", "ActivityEntry", "FullScreenTaskUiState", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FullScreenHelper {
    private static final String DOC_URI_HOST = "task";
    private static final String DOC_URI_SCHEME = "fullscreen";
    private static final String TAG = "FullScreenHelper";
    private final ConcurrentHashMap<FullScreenActivity, String> activityToTaskId;
    private final Context context;
    private final ConcurrentHashMap<String, ActivityEntry> entries;
    private final ConcurrentHashMap<String, Boolean> interactionExplicitOverride;
    private S7.k llmTakeoverPendingProvider;
    private final Handler mainHandler;
    private S7.k onFullscreenTouchInjectionEnabled;
    private volatile String pendingInteractionTaskId;
    private S7.k sessionStateProvider;
    private final ConcurrentHashMap<String, p9.j> uiStateMap;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$FullScreenTaskUiState;", "", "taskState", "Lstepai/aios/guiagent/model/SessionState;", "explain", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/model/SessionState;Ljava/lang/String;)V", "getTaskState", "()Lstepai/aios/guiagent/model/SessionState;", "getExplain", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FullScreenTaskUiState {
        private final String explain;
        private final SessionState taskState;

        /* JADX WARN: Multi-variable type inference failed */
        public FullScreenTaskUiState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FullScreenTaskUiState copy$default(FullScreenTaskUiState fullScreenTaskUiState, SessionState sessionState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                sessionState = fullScreenTaskUiState.taskState;
            }
            if ((i & 2) != 0) {
                str = fullScreenTaskUiState.explain;
            }
            return fullScreenTaskUiState.copy(sessionState, str);
        }

        /* renamed from: component1, reason: from getter */
        public final SessionState getTaskState() {
            return this.taskState;
        }

        /* renamed from: component2, reason: from getter */
        public final String getExplain() {
            return this.explain;
        }

        public final FullScreenTaskUiState copy(SessionState taskState, String explain) {
            kotlin.jvm.internal.k.f(explain, "explain");
            return new FullScreenTaskUiState(taskState, explain);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FullScreenTaskUiState)) {
                return false;
            }
            FullScreenTaskUiState fullScreenTaskUiState = (FullScreenTaskUiState) other;
            return this.taskState == fullScreenTaskUiState.taskState && kotlin.jvm.internal.k.b(this.explain, fullScreenTaskUiState.explain);
        }

        public final String getExplain() {
            return this.explain;
        }

        public final SessionState getTaskState() {
            return this.taskState;
        }

        public int hashCode() {
            SessionState sessionState = this.taskState;
            return this.explain.hashCode() + ((sessionState == null ? 0 : sessionState.hashCode()) * 31);
        }

        public String toString() {
            return "FullScreenTaskUiState(taskState=" + this.taskState + ", explain=" + this.explain + ")";
        }

        public FullScreenTaskUiState(SessionState sessionState, String explain) {
            kotlin.jvm.internal.k.f(explain, "explain");
            this.taskState = sessionState;
            this.explain = explain;
        }

        public /* synthetic */ FullScreenTaskUiState(SessionState sessionState, String str, int i, kotlin.jvm.internal.e eVar) {
            this((i & 1) != 0 ? null : sessionState, (i & 2) != 0 ? "" : str);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper", f = "FullScreenHelper.kt", l = {554}, m = "onTaskCompleted", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$onTaskCompleted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FullScreenHelper.this.onTaskCompleted(null, null, null, this);
        }
    }

    public FullScreenHelper(Context context, Handler mainHandler) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(mainHandler, "mainHandler");
        this.context = context;
        this.mainHandler = mainHandler;
        this.entries = new ConcurrentHashMap<>();
        this.activityToTaskId = new ConcurrentHashMap<>();
        this.interactionExplicitOverride = new ConcurrentHashMap<>();
        this.sessionStateProvider = new S7.k() { // from class: com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$sessionStateProvider$1
            @Override // S7.k
            public final Void invoke(String it) {
                kotlin.jvm.internal.k.f(it, "it");
                return null;
            }
        };
        this.llmTakeoverPendingProvider = new n(4);
        this.uiStateMap = new ConcurrentHashMap<>();
    }

    private final boolean attachMirrorView(FullScreenActivity activity, String taskId) {
        Object objA;
        ZyqlGuiAgentTask task = SystemSdkBridge.INSTANCE.getTask(taskId);
        if (task == null) {
            B7.a.z("[", taskId, "] attachMirrorView: gui task not found", TAG, true);
            return false;
        }
        try {
            activity.getMirrorView$stepfun_release().bind(task);
            objA = Boolean.TRUE;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] attachMirrorView failed: ", thA.getMessage()), true);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final void detachMirrorView(FullScreenActivity activity, String taskId) {
        Object objA;
        try {
            activity.getMirrorView$stepfun_release().unbind();
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] detachMirrorView failed: ", thA.getMessage()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissFullScreenOverlay$lambda$0(FullScreenHelper fullScreenHelper, String str) {
        Pair<String, ActivityEntry> pairResolveOverlayTarget = fullScreenHelper.resolveOverlayTarget(str, "dismissFullScreenOverlay");
        if (pairResolveOverlayTarget == null) {
            return;
        }
        ((ActivityEntry) pairResolveOverlayTarget.b).getActivity().onDismissRequested();
        AbstractC1436a.d(TAG, "[" + pairResolveOverlayTarget.f4886a + "] dismissFullScreenOverlay: dispatched (requested=" + str + ")", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideActivity$lambda$0(FullScreenHelper fullScreenHelper, String str) {
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null) {
            AbstractC1436a.a(TAG, "[" + str + "] hideActivity: no entry, skip", true);
            return;
        }
        FullScreenActivity activity = activityEntry.getActivity();
        if (activity.isFinishing()) {
            B7.a.z("[", str, "] hideActivity: activity already finishing, skip", TAG, true);
            return;
        }
        activity.finishAndRemoveTask();
        activity.overridePendingTransition(0, 0);
        StringBuilder sb = new StringBuilder("[");
        sb.append(str);
        com.stepos.statsrpk.service.c.r(sb, "] hideActivity: finishAndRemoveTask", TAG, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean llmTakeoverPendingProvider$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void migrateEntry$lambda$0(FullScreenHelper fullScreenHelper, String str, String str2) throws Resources.NotFoundException {
        ActivityEntry activityEntryRemove = fullScreenHelper.entries.remove(str);
        if (activityEntryRemove == null) {
            B7.a.z("[", str, "] migrateEntry: no entry, skip", TAG, true);
            return;
        }
        fullScreenHelper.entries.put(str2, activityEntryRemove);
        fullScreenHelper.activityToTaskId.put(activityEntryRemove.getActivity(), str2);
        fullScreenHelper.uiStateMap.remove(str);
        fullScreenHelper.interactionExplicitOverride.remove(str);
        if (kotlin.jvm.internal.k.b(fullScreenHelper.pendingInteractionTaskId, str)) {
            fullScreenHelper.pendingInteractionTaskId = null;
        }
        activityEntryRemove.setInteractionEnabled(false);
        activityEntryRemove.setPendingLlmPassivePrompt(false);
        StringBuilder sb = new StringBuilder("[");
        sb.append(str);
        AbstractC1436a.d(TAG, androidx.constraintlayout.core.dsl.a.j(sb, " → ", str2, "] migrateEntry: entry key migrated"), true);
        activityEntryRemove.getActivity().migrateToNewTask$stepfun_release(str2);
    }

    private final boolean moveExistingDocumentToFront(String taskId) {
        Object objA;
        Object objA2;
        Object next;
        Object objA3;
        Uri docUriForTask$stepfun_release = SystemSdkBridge.INSTANCE.getDocUriForTask$stepfun_release(taskId);
        if (docUriForTask$stepfun_release == null) {
            docUriForTask$stepfun_release = Uri.parse("fullscreen://task/" + Uri.encode(taskId));
        }
        Object systemService = this.context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return false;
        }
        try {
            List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
            kotlin.jvm.internal.k.e(appTasks, "getAppTasks(...)");
            Iterator<T> it = appTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                    objA3 = Boolean.valueOf(kotlin.jvm.internal.k.b(((ActivityManager.AppTask) next).getTaskInfo().baseIntent.getData(), docUriForTask$stepfun_release));
                } catch (Throwable th) {
                    objA3 = kotlin.b.a(th);
                }
                Object obj = Boolean.FALSE;
                if (objA3 instanceof Result.Failure) {
                    objA3 = obj;
                }
                if (((Boolean) objA3).booleanValue()) {
                    break;
                }
            }
            objA = (ActivityManager.AppTask) next;
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        ActivityManager.AppTask appTask = (ActivityManager.AppTask) (objA instanceof Result.Failure ? null : objA);
        if (appTask == null) {
            return false;
        }
        try {
            appTask.moveToFront();
            objA2 = Boolean.TRUE;
        } catch (Throwable th3) {
            objA2 = kotlin.b.a(th3);
        }
        Throwable thA = Result.a(objA2);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", taskId, "] moveExistingDocumentToFront failed: ", thA.getMessage()), true);
            objA2 = Boolean.FALSE;
        }
        return ((Boolean) objA2).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityCreated$lambda$0(String str, FullScreenHelper fullScreenHelper) {
        FullScreenActivity activity;
        com.stepos.statsrpk.service.c.p("[", str, "] onActivityCreated: notifyTakeoverAcknowledged (new activity path)", TAG, true);
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || (activity = activityEntry.getActivity()) == null) {
            return;
        }
        activity.notifyTakeoverAcknowledged$stepfun_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityForeground$lambda$0(FullScreenHelper fullScreenHelper, String str, boolean z10) {
        FullScreenActivity activity;
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || (activity = activityEntry.getActivity()) == null) {
            return;
        }
        if (z10) {
            com.stepos.statsrpk.service.c.p("[", str, "] onActivityForeground: notifyTakeoverFromLlm (resume passive prompt)", TAG, true);
            activity.notifyTakeoverFromLlm$stepfun_release();
        } else {
            com.stepos.statsrpk.service.c.p("[", str, "] onActivityForeground: notifyTakeoverAcknowledged (resume path)", TAG, true);
            activity.notifyTakeoverAcknowledged$stepfun_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityForeground$lambda$1(FullScreenHelper fullScreenHelper, String str) {
        FullScreenActivity activity;
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || (activity = activityEntry.getActivity()) == null) {
            return;
        }
        com.stepos.statsrpk.service.c.p("[", str, "] onActivityForeground: notifyTakeoverFromLlm (llm pending, touch kept off)", TAG, true);
        activity.notifyTakeoverFromLlm$stepfun_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLlmRequestTakeover$lambda$0(FullScreenHelper fullScreenHelper, String str) {
        FullScreenActivity activity;
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || (activity = activityEntry.getActivity()) == null) {
            return;
        }
        activity.notifyTakeoverFromLlm$stepfun_release();
    }

    private final Pair<String, ActivityEntry> resolveOverlayTarget(String taskId, String caller) {
        Object next;
        if (taskId != null) {
            ActivityEntry activityEntry = this.entries.get(taskId);
            if (activityEntry != null) {
                return new Pair<>(taskId, activityEntry);
            }
            AbstractC1436a.a(TAG, androidx.appfunctions.metadata.a.m("[", taskId, "] ", caller, ": no entry, skip"), true);
            return null;
        }
        Set<Map.Entry<String, ActivityEntry>> setEntrySet = this.entries.entrySet();
        kotlin.jvm.internal.k.e(setEntrySet, "<get-entries>(...)");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ActivityEntry) ((Map.Entry) next).getValue()).getIsInForeground()) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            Object key = entry.getKey();
            kotlin.jvm.internal.k.e(key, "<get-key>(...)");
            return new Pair<>(key, entry.getValue());
        }
        AbstractC1436a.a(TAG, caller + ": taskId=null and no foreground entry, skip", true);
        return null;
    }

    private final boolean resolveTouchEnabled(String taskId) {
        return this.interactionExplicitOverride.containsKey(taskId) ? kotlin.jvm.internal.k.b(this.interactionExplicitOverride.get(taskId), Boolean.TRUE) : !((Boolean) this.llmTakeoverPendingProvider.invoke(taskId)).booleanValue() && this.sessionStateProvider.invoke(taskId) == SessionState.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resumeFullScreenOverlay$lambda$0(FullScreenHelper fullScreenHelper, String str) {
        Pair<String, ActivityEntry> pairResolveOverlayTarget = fullScreenHelper.resolveOverlayTarget(str, "resumeFullScreenOverlay");
        if (pairResolveOverlayTarget == null) {
            return;
        }
        ((ActivityEntry) pairResolveOverlayTarget.b).getActivity().onResumeRequested();
        AbstractC1436a.d(TAG, "[" + pairResolveOverlayTarget.f4886a + "] resumeFullScreenOverlay: dispatched (requested=" + str + ")", true);
    }

    private final boolean shouldPostTakeoverPanelNotify(String taskId, boolean resolved, boolean wasInteractionEnabled) {
        if (!resolved || wasInteractionEnabled) {
            return false;
        }
        return (this.sessionStateProvider.invoke(taskId) == SessionState.f) || (this.interactionExplicitOverride.containsKey(taskId) && kotlin.jvm.internal.k.b(this.interactionExplicitOverride.get(taskId), Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivity$lambda$0(FullScreenHelper fullScreenHelper, String str, S7.k kVar, boolean z10, boolean z11, String str2) {
        Object objA;
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || activityEntry.getActivity().isFinishing()) {
            if (activityEntry != null && activityEntry.getActivity().isFinishing()) {
                B7.a.z("[", str, "] showActivity: stale finishing entry, removing before relaunch", TAG, true);
                fullScreenHelper.entries.remove(str);
                fullScreenHelper.activityToTaskId.remove(activityEntry.getActivity());
            }
        } else {
            if (activityEntry.getIsInForeground()) {
                boolean zResolveTouchEnabled = fullScreenHelper.resolveTouchEnabled(str);
                boolean zShouldPostTakeoverPanelNotify = fullScreenHelper.shouldPostTakeoverPanelNotify(str, zResolveTouchEnabled, activityEntry.getIsInteractionEnabled());
                boolean z12 = !zResolveTouchEnabled && ((Boolean) fullScreenHelper.llmTakeoverPendingProvider.invoke(str)).booleanValue();
                fullScreenHelper.updateInteractionInternal(activityEntry, str, zResolveTouchEnabled, kVar);
                if (zShouldPostTakeoverPanelNotify) {
                    fullScreenHelper.mainHandler.post(new e(str, fullScreenHelper, 3));
                } else if (z12) {
                    fullScreenHelper.mainHandler.post(new e(str, fullScreenHelper, 4));
                }
                AbstractC1436a.d(TAG, "[" + str + "] showActivity: entry in foreground, updated directly (resolved=" + zResolveTouchEnabled + ")", true);
                return;
            }
            if (fullScreenHelper.moveExistingDocumentToFront(str)) {
                com.stepos.statsrpk.service.c.p("[", str, "] showActivity: moveTaskToFront via AppTask", TAG, true);
                return;
            }
            B7.a.z("[", str, "] showActivity: entry exists but moveToFront miss, will startActivity", TAG, true);
        }
        if (fullScreenHelper.moveExistingDocumentToFront(str)) {
            com.stepos.statsrpk.service.c.p("[", str, "] showActivity: moveTaskToFront via AppTask (no live entry)", TAG, true);
            return;
        }
        Uri uri = Uri.parse("fullscreen://task/" + Uri.encode(str));
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        kotlin.jvm.internal.k.c(uri);
        systemSdkBridge.registerDocUri$stepfun_release(str, uri);
        ZyqlGuiAgentTask task = systemSdkBridge.getTask(str);
        String targetPackageName = task != null ? task.getTargetPackageName() : null;
        Intent intent = new Intent(fullScreenHelper.context, (Class<?>) FullScreenActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("extra_task_id", str);
        if (targetPackageName != null && !j9.m.s0(targetPackageName)) {
            intent.putExtra(FullScreenActivity.EXTRA_TARGET_PACKAGE, targetPackageName);
        }
        intent.addFlags(524288);
        intent.addFlags(268435456);
        try {
            fullScreenHelper.context.startActivity(intent);
            AbstractC1436a.d(TAG, "[" + str + "] showActivity: startActivity sent (pendingInteraction=" + fullScreenHelper.pendingInteractionTaskId + ", targetPkg=" + targetPackageName + ")", true);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", str, "] showActivity: startActivity failed: ", thA.getMessage()), true);
            if (z10) {
                fullScreenHelper.interactionExplicitOverride.put(str, Boolean.valueOf(z11));
            } else {
                fullScreenHelper.interactionExplicitOverride.remove(str);
            }
            fullScreenHelper.pendingInteractionTaskId = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivity$lambda$0$0(String str, FullScreenHelper fullScreenHelper) {
        FullScreenActivity activity;
        com.stepos.statsrpk.service.c.p("[", str, "] showActivity: notifyTakeoverAcknowledged (foreground path)", TAG, true);
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || (activity = activityEntry.getActivity()) == null) {
            return;
        }
        activity.notifyTakeoverAcknowledged$stepfun_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivity$lambda$0$1(String str, FullScreenHelper fullScreenHelper) {
        FullScreenActivity activity;
        com.stepos.statsrpk.service.c.p("[", str, "] showActivity: notifyTakeoverFromLlm (foreground path, llm pending)", TAG, true);
        ActivityEntry activityEntry = fullScreenHelper.entries.get(str);
        if (activityEntry == null || (activity = activityEntry.getActivity()) == null) {
            return;
        }
        activity.notifyTakeoverFromLlm$stepfun_release();
    }

    private final void updateInteractionInternal(final ActivityEntry entry, final String taskId, final boolean enabled, final S7.k taskProvider) {
        if (!enabled && kotlin.jvm.internal.k.b(this.pendingInteractionTaskId, taskId)) {
            this.pendingInteractionTaskId = null;
        }
        this.mainHandler.post(new Runnable() { // from class: com.stepos.taskrobot.llmapi.stepfun.f
            @Override // java.lang.Runnable
            public final void run() {
                FullScreenHelper.updateInteractionInternal$lambda$0(entry, taskId, enabled, this, taskProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateInteractionInternal$lambda$0(ActivityEntry activityEntry, String str, boolean z10, FullScreenHelper fullScreenHelper, S7.k kVar) {
        Object objA;
        S7.k kVar2;
        Object objA2;
        FullScreenActivity activity = activityEntry.getActivity();
        if (activity.isFinishing() || activity.isDestroyed()) {
            activityEntry.setInteractionEnabled(false);
            AbstractC1436a.e(TAG, "[" + str + "] updateInteraction: activity finishing/destroyed, mark false", true);
            return;
        }
        activity.getViewModel$stepfun_release().setTouchEnabled(z10);
        try {
            activity.getMirrorView$stepfun_release().setForwardTouchEventEnable(z10);
            AbstractC1436a.a(TAG, "[" + str + "] setForwardTouchEventEnable(" + z10 + ")", true);
            Task task = (Task) kVar.invoke(str);
            objA = r.f317a;
            if (task != null) {
                try {
                    if (!z10) {
                        task.setOmniDisplayImeEnabled(false);
                        task.setOmniDisplayTakeover(false);
                    } else if (task.getDisplayId() != 0) {
                        task.setOmniDisplayImeEnabled(true);
                        task.setOmniDisplayTakeover(true);
                    }
                    objA2 = objA;
                } catch (Throwable th) {
                    objA2 = kotlin.b.a(th);
                }
                Throwable thA = Result.a(objA2);
                if (thA != null) {
                    AbstractC1436a.b(TAG, "[" + str + "] setOmniDisplayImeEnabled(" + z10 + ") failed: " + thA.getMessage(), true);
                }
            }
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        Throwable thA2 = Result.a(objA);
        if (thA2 != null) {
            String message = thA2.getMessage();
            StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[", str, "] setForwardTouchEventEnable(", ") failed: ", z10);
            sbL.append(message);
            AbstractC1436a.b(TAG, sbL.toString(), true);
        }
        activityEntry.setInteractionEnabled(z10);
        AbstractC1436a.d(TAG, "[" + str + "] updateInteraction: enabled=" + z10, true);
        if (!z10 || (kVar2 = fullScreenHelper.onFullscreenTouchInjectionEnabled) == null) {
            return;
        }
        kVar2.invoke(str);
    }

    public final void clearDesiredInteractionAfterRecover(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        if (this.entries.get(taskId) == null) {
            AbstractC1436a.a(TAG, "[" + taskId + "] clearDesiredInteractionAfterRecover: no entry, skip", true);
            return;
        }
        this.interactionExplicitOverride.remove(taskId);
        if (kotlin.jvm.internal.k.b(this.pendingInteractionTaskId, taskId)) {
            this.pendingInteractionTaskId = null;
        }
        com.stepos.statsrpk.service.c.p("[", taskId, "] clearDesiredInteractionAfterRecover: cleared override", TAG, true);
    }

    public final void clearInteractionPolicy(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        this.interactionExplicitOverride.remove(taskId);
    }

    public final void clearTaskUiState(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        this.uiStateMap.remove(taskId);
    }

    public final void dismissFullScreenOverlay(String taskId) {
        this.mainHandler.post(new e(this, taskId, 1));
    }

    public final void ensureActivityRegistered(FullScreenActivity activity) {
        String stringExtra;
        kotlin.jvm.internal.k.f(activity, "activity");
        Intent intent = activity.getIntent();
        if ((intent == null || (stringExtra = intent.getStringExtra("extra_task_id")) == null) && (stringExtra = this.activityToTaskId.get(activity)) == null) {
            AbstractC1436a.e(TAG, "ensureActivityRegistered: cannot resolve taskId, skip", true);
            return;
        }
        ActivityEntry activityEntry = this.entries.get(stringExtra);
        if ((activityEntry != null ? activityEntry.getActivity() : null) != activity) {
            AbstractC1436a.e(TAG, "[" + stringExtra + "] ensureActivityRegistered: healing helper ref (hadOther=" + (activityEntry != null) + ")", true);
            this.entries.put(stringExtra, new ActivityEntry(activity, false, false, false, 14, null));
            this.activityToTaskId.put(activity, stringExtra);
        }
    }

    public final boolean getInteractionEnabled(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ActivityEntry activityEntry = this.entries.get(taskId);
        return activityEntry != null && activityEntry.getIsInteractionEnabled();
    }

    public final void hideActivity(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        this.mainHandler.post(new e(this, taskId, 5));
    }

    public final boolean isAnyInForeground() {
        Collection<ActivityEntry> collectionValues = this.entries.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        Collection<ActivityEntry> collection = collectionValues;
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (((ActivityEntry) it.next()).getIsInForeground()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAnyInteractionEnabled() {
        Collection<ActivityEntry> collectionValues = this.entries.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        Collection<ActivityEntry> collection = collectionValues;
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (((ActivityEntry) it.next()).getIsInteractionEnabled()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isTaskBoundAndInForeground(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ActivityEntry activityEntry = this.entries.get(taskId);
        return activityEntry != null && activityEntry.getIsInForeground();
    }

    public final boolean isTaskTakenOverByExternal(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ActivityEntry activityEntry = this.entries.get(taskId);
        return activityEntry != null && activityEntry.getIsInForeground() && activityEntry.getIsInteractionEnabled();
    }

    public final void maybeRefreshTouchForFollowMode(String taskId, S7.k taskProvider) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        ActivityEntry activityEntry = this.entries.get(taskId);
        if (activityEntry == null || !activityEntry.getIsInForeground() || this.interactionExplicitOverride.containsKey(taskId)) {
            return;
        }
        updateInteractionInternal(activityEntry, taskId, resolveTouchEnabled(taskId), taskProvider);
    }

    public final void migrateEntry$stepfun_release(String from, String to, ZyqlGuiAgentTask newTask) {
        kotlin.jvm.internal.k.f(from, "from");
        kotlin.jvm.internal.k.f(to, "to");
        kotlin.jvm.internal.k.f(newTask, "newTask");
        this.mainHandler.post(new A4.e(6, from, this, to));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t observeTaskUiState(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ConcurrentHashMap<String, p9.j> concurrentHashMap = this.uiStateMap;
        p9.j jVarC = concurrentHashMap.get(taskId);
        if (jVarC == null) {
            jVarC = p9.e.c(new FullScreenTaskUiState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
            p9.j jVarPutIfAbsent = concurrentHashMap.putIfAbsent(taskId, jVarC);
            if (jVarPutIfAbsent != null) {
                jVarC = jVarPutIfAbsent;
            }
        }
        return jVarC;
    }

    public final void onActivityBackground(String taskId, S7.k taskProvider) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        ActivityEntry activityEntry = this.entries.get(taskId);
        if (activityEntry == null) {
            B7.a.z("[", taskId, "] onActivityBackground: no entry, skip", TAG, true);
            return;
        }
        activityEntry.setInForeground(false);
        updateInteractionInternal(activityEntry, taskId, false, taskProvider);
        detachMirrorView(activityEntry.getActivity(), taskId);
        com.stepos.statsrpk.service.c.p("[", taskId, "] onActivityBackground", TAG, true);
    }

    public final void onActivityCreated(FullScreenActivity activity, S7.k taskProvider) {
        kotlin.jvm.internal.k.f(activity, "activity");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        Intent intent = activity.getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("extra_task_id") : null;
        if (stringExtra == null || stringExtra.length() == 0) {
            AbstractC1436a.e(TAG, "onActivityCreated: missing taskId, skip register", true);
            return;
        }
        ActivityEntry activityEntry = new ActivityEntry(activity, false, false, false, 14, null);
        ActivityEntry activityEntryPut = this.entries.put(stringExtra, activityEntry);
        if (activityEntryPut != null && activityEntryPut.getActivity() != activity) {
            AbstractC1436a.e(TAG, "[" + stringExtra + "] onActivityCreated: replaced previous entry (oldFinishing=" + activityEntryPut.getActivity().isFinishing() + ")", true);
            this.activityToTaskId.remove(activityEntryPut.getActivity());
        }
        this.activityToTaskId.put(activity, stringExtra);
        com.stepos.statsrpk.service.c.r(androidx.appfunctions.metadata.a.t(this.entries.size(), "[", stringExtra, "] onActivityCreated: entries=", ", pendingInteractionTaskId="), this.pendingInteractionTaskId, TAG, true);
        String str = this.pendingInteractionTaskId;
        if (str == null || !str.equals(stringExtra)) {
            return;
        }
        this.pendingInteractionTaskId = null;
        updateInteractionInternal(activityEntry, str, true, taskProvider);
        this.mainHandler.post(new e(str, this, 0));
        StringBuilder sb = new StringBuilder("[");
        sb.append(str);
        com.stepos.statsrpk.service.c.r(sb, "] onActivityCreated: auto-enabled interaction, notifyTakeoverAcknowledged queued", TAG, true);
    }

    public final void onActivityDestroyed(FullScreenActivity destroyed, String taskId, S7.k taskProvider) {
        Object objA;
        kotlin.jvm.internal.k.f(destroyed, "destroyed");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        Task task = (Task) taskProvider.invoke(taskId);
        if (task != null) {
            try {
                if (task.getImeEnabled()) {
                    task.setOmniDisplayImeEnabled(false);
                    task.setOmniDisplayTakeover(false);
                }
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] onActivityDestroyed: revoke OmniDisplay IME failed: ", thA.getMessage()), true);
            }
        }
        ActivityEntry activityEntry = this.entries.get(taskId);
        if (activityEntry != null && activityEntry.getActivity() != destroyed) {
            B7.a.z("[", taskId, "] onActivityDestroyed: stale destroy ignored (tracked != destroyed)", TAG, true);
            this.activityToTaskId.remove(destroyed);
            return;
        }
        int displayId = SystemSdkBridge.INSTANCE.getDisplayId(taskId);
        VirtualDisplayCgroupHelper.INSTANCE.applyTier(displayId, 2);
        AbstractC1436a.d(TAG, "[" + taskId + "] vdcgroup downgrade IMPORTANT display=" + displayId, true);
        this.entries.remove(taskId);
        this.activityToTaskId.remove(destroyed);
        if (kotlin.jvm.internal.k.b(this.pendingInteractionTaskId, taskId)) {
            this.pendingInteractionTaskId = null;
        }
        AbstractC1436a.d(TAG, androidx.constraintlayout.core.dsl.a.d(this.entries.size(), "[", taskId, "] onActivityDestroyed: entry removed (entriesLeft=", ")"), true);
    }

    public final void onActivityForeground(String taskId, S7.k taskProvider) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        ActivityEntry activityEntry = this.entries.get(taskId);
        if (activityEntry == null) {
            B7.a.z("[", taskId, "] onActivityForeground: no entry, skip", TAG, true);
            return;
        }
        activityEntry.setInForeground(true);
        boolean zAttachMirrorView = attachMirrorView(activityEntry.getActivity(), taskId);
        boolean zResolveTouchEnabled = resolveTouchEnabled(taskId);
        boolean zShouldPostTakeoverPanelNotify = shouldPostTakeoverPanelNotify(taskId, zResolveTouchEnabled, activityEntry.getIsInteractionEnabled());
        updateInteractionInternal(activityEntry, taskId, zResolveTouchEnabled, taskProvider);
        if (zShouldPostTakeoverPanelNotify) {
            boolean pendingLlmPassivePrompt = activityEntry.getPendingLlmPassivePrompt();
            activityEntry.setPendingLlmPassivePrompt(false);
            this.mainHandler.post(new com.mdisdk.capability.input.impl.gesture.a(this, taskId, pendingLlmPassivePrompt));
        } else if (!zResolveTouchEnabled && ((Boolean) this.llmTakeoverPendingProvider.invoke(taskId)).booleanValue()) {
            activityEntry.setPendingLlmPassivePrompt(false);
            this.mainHandler.post(new e(this, taskId, 6));
        }
        if (zAttachMirrorView) {
            StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[", taskId, "] onActivityForeground: mirror attached, resolved=", ", shouldNotify=", zResolveTouchEnabled);
            sbL.append(zShouldPostTakeoverPanelNotify);
            AbstractC1436a.d(TAG, sbL.toString(), true);
        } else {
            AbstractC1436a.e(TAG, "[" + taskId + "] onActivityForeground: mirror not attached, resolved=" + zResolveTouchEnabled, true);
        }
        int displayId = SystemSdkBridge.INSTANCE.getDisplayId(taskId);
        VirtualDisplayCgroupHelper.INSTANCE.applyTier(displayId, 1);
        AbstractC1436a.d(TAG, "[" + taskId + "] vdcgroup upgrade REALTIME display=" + displayId, true);
    }

    public final void onLlmRequestTakeover(String taskId, S7.k taskProvider) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        ActivityEntry activityEntry = this.entries.get(taskId);
        if (activityEntry == null) {
            AbstractC1436a.a(TAG, "[" + taskId + "] onLlmRequestTakeover: not bound to activity", true);
            return;
        }
        if (activityEntry.getIsInForeground()) {
            this.mainHandler.post(new e(this, taskId, 7));
            StringBuilder sb = new StringBuilder("[");
            sb.append(taskId);
            com.stepos.statsrpk.service.c.r(sb, "] onLlmRequestTakeover: prompt shown, awaiting user choice", TAG, true);
            return;
        }
        activityEntry.setPendingLlmPassivePrompt(true);
        AbstractC1436a.a(TAG, "[" + taskId + "] onLlmRequestTakeover: activity not in foreground, marked pendingLlmPassivePrompt", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onTaskCompleted(java.lang.String r6, S7.k r7, S7.k r8, H7.c<? super C7.r> r9) {
        /*
            r5 = this;
            boolean r7 = r9 instanceof com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper.AnonymousClass1
            if (r7 == 0) goto L13
            r7 = r9
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$onTaskCompleted$1 r7 = (com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper.AnonymousClass1) r7
            int r0 = r7.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r7.label = r0
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$onTaskCompleted$1 r7 = new com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$onTaskCompleted$1
            r7.<init>(r9)
        L18:
            java.lang.Object r9 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r7.label
            C7.r r2 = C7.r.f317a
            r3 = 1
            if (r1 == 0) goto L41
            if (r1 != r3) goto L39
            java.lang.Object r6 = r7.L$3
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$ActivityEntry r6 = (com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper.ActivityEntry) r6
            java.lang.Object r6 = r7.L$2
            S7.k r6 = (S7.k) r6
            java.lang.Object r6 = r7.L$1
            S7.k r6 = (S7.k) r6
            java.lang.Object r6 = r7.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r9)
            goto L89
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            kotlin.b.b(r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$ActivityEntry> r9 = r5.entries
            java.lang.Object r9 = r9.get(r6)
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper$ActivityEntry r9 = (com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper.ActivityEntry) r9
            java.lang.String r1 = "["
            java.lang.String r4 = "FullScreenHelper"
            if (r9 != 0) goto L67
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            r5.append(r6)
            java.lang.String r6 = "] onTaskCompleted: not bound to activity"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            f6.AbstractC1436a.a(r4, r5, r3)
            return r2
        L67:
            boolean r9 = r9.getIsInForeground()
            if (r9 == 0) goto L84
            java.lang.String r9 = "] onTaskCompleted: switching to main display"
            com.stepos.statsrpk.service.c.p(r1, r6, r9, r4, r3)
            r7.L$0 = r6
            r9 = 0
            r7.L$1 = r9
            r7.L$2 = r9
            r7.L$3 = r9
            r7.label = r3
            java.lang.Object r7 = r8.invoke(r7)
            if (r7 != r0) goto L89
            return r0
        L84:
            java.lang.String r7 = "] onTaskCompleted: not in foreground, skip switchToMain, still closing fullscreen"
            com.stepos.statsrpk.service.c.p(r1, r6, r7, r4, r3)
        L89:
            r5.hideActivity(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper.onTaskCompleted(java.lang.String, S7.k, S7.k, H7.c):java.lang.Object");
    }

    public final void resumeFullScreenOverlay(String taskId) {
        this.mainHandler.post(new e(this, taskId, 2));
    }

    public final void setLlmTakeoverPendingProvider(S7.k provider) {
        kotlin.jvm.internal.k.f(provider, "provider");
        this.llmTakeoverPendingProvider = provider;
    }

    public final void setOnFullscreenTouchInjectionEnabled(S7.k listener) {
        this.onFullscreenTouchInjectionEnabled = listener;
    }

    public final void setSessionStateProvider(S7.k provider) {
        kotlin.jvm.internal.k.f(provider, "provider");
        this.sessionStateProvider = provider;
    }

    public final void showActivity(final String taskId, Boolean enableInteraction, final S7.k taskProvider) {
        final boolean zBooleanValue;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        final boolean zContainsKey = this.interactionExplicitOverride.containsKey(taskId);
        boolean z10 = false;
        if (zContainsKey) {
            Boolean bool = this.interactionExplicitOverride.get(taskId);
            kotlin.jvm.internal.k.c(bool);
            zBooleanValue = bool.booleanValue();
        } else {
            zBooleanValue = false;
        }
        final String str = this.pendingInteractionTaskId;
        if (enableInteraction == null) {
            this.interactionExplicitOverride.remove(taskId);
        } else {
            Boolean bool2 = Boolean.TRUE;
            if (enableInteraction.equals(bool2)) {
                this.interactionExplicitOverride.put(taskId, bool2);
            } else {
                Boolean bool3 = Boolean.FALSE;
                if (!enableInteraction.equals(bool3)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.interactionExplicitOverride.put(taskId, bool3);
            }
        }
        this.pendingInteractionTaskId = kotlin.jvm.internal.k.b(enableInteraction, Boolean.TRUE) ? taskId : null;
        ActivityEntry activityEntry = this.entries.get(taskId);
        boolean z11 = activityEntry != null;
        if (activityEntry != null && activityEntry.getIsInForeground()) {
            z10 = true;
        }
        AbstractC1436a.d(TAG, "[" + taskId + "] showActivity called: enableInteraction=" + enableInteraction + ", hasEntry=" + z11 + ", foreground=" + z10, true);
        this.mainHandler.post(new Runnable() { // from class: com.stepos.taskrobot.llmapi.stepfun.d
            @Override // java.lang.Runnable
            public final void run() {
                FullScreenHelper.showActivity$lambda$0(this.f4032a, taskId, taskProvider, zContainsKey, zBooleanValue, str);
            }
        });
    }

    public final void updateInteraction(String taskId, boolean enabled, S7.k taskProvider) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        ActivityEntry activityEntry = this.entries.get(taskId);
        if (activityEntry == null) {
            B7.a.z("[", taskId, "] updateInteraction: no entry, skip", TAG, true);
        } else {
            updateInteractionInternal(activityEntry, taskId, enabled, taskProvider);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateTaskExplain(String taskId, String explain) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ConcurrentHashMap<String, p9.j> concurrentHashMap = this.uiStateMap;
        p9.j jVarC = concurrentHashMap.get(taskId);
        SessionState sessionState = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (jVarC == null) {
            jVarC = p9.e.c(new FullScreenTaskUiState(sessionState, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0));
            p9.j jVarPutIfAbsent = concurrentHashMap.putIfAbsent(taskId, jVarC);
            if (jVarPutIfAbsent != null) {
                jVarC = jVarPutIfAbsent;
            }
        }
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) jVarC;
        FullScreenTaskUiState fullScreenTaskUiState = (FullScreenTaskUiState) iVar.getValue();
        if (explain == null) {
            explain = "";
        }
        iVar.i(FullScreenTaskUiState.copy$default(fullScreenTaskUiState, null, explain, 1, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateTaskState(String taskId, SessionState state) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ConcurrentHashMap<String, p9.j> concurrentHashMap = this.uiStateMap;
        p9.j jVarC = concurrentHashMap.get(taskId);
        SessionState sessionState = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (jVarC == null) {
            jVarC = p9.e.c(new FullScreenTaskUiState(sessionState, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0));
            p9.j jVarPutIfAbsent = concurrentHashMap.putIfAbsent(taskId, jVarC);
            if (jVarPutIfAbsent != null) {
                jVarC = jVarPutIfAbsent;
            }
        }
        kotlinx.coroutines.flow.i iVar = (kotlinx.coroutines.flow.i) jVarC;
        iVar.i(FullScreenTaskUiState.copy$default((FullScreenTaskUiState) iVar.getValue(), state, null, 2, null));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$ActivityEntry;", "", "activity", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;", "isInForeground", "", "isInteractionEnabled", "pendingLlmPassivePrompt", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;ZZZ)V", "getActivity", "()Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;", "()Z", "setInForeground", "(Z)V", "setInteractionEnabled", "getPendingLlmPassivePrompt", "setPendingLlmPassivePrompt", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ActivityEntry {
        private final FullScreenActivity activity;
        private volatile boolean isInForeground;
        private volatile boolean isInteractionEnabled;
        private volatile boolean pendingLlmPassivePrompt;

        public ActivityEntry(FullScreenActivity activity, boolean z10, boolean z11, boolean z12) {
            kotlin.jvm.internal.k.f(activity, "activity");
            this.activity = activity;
            this.isInForeground = z10;
            this.isInteractionEnabled = z11;
            this.pendingLlmPassivePrompt = z12;
        }

        public final FullScreenActivity getActivity() {
            return this.activity;
        }

        public final boolean getPendingLlmPassivePrompt() {
            return this.pendingLlmPassivePrompt;
        }

        /* renamed from: isInForeground, reason: from getter */
        public final boolean getIsInForeground() {
            return this.isInForeground;
        }

        /* renamed from: isInteractionEnabled, reason: from getter */
        public final boolean getIsInteractionEnabled() {
            return this.isInteractionEnabled;
        }

        public final void setInForeground(boolean z10) {
            this.isInForeground = z10;
        }

        public final void setInteractionEnabled(boolean z10) {
            this.isInteractionEnabled = z10;
        }

        public final void setPendingLlmPassivePrompt(boolean z10) {
            this.pendingLlmPassivePrompt = z10;
        }

        public /* synthetic */ ActivityEntry(FullScreenActivity fullScreenActivity, boolean z10, boolean z11, boolean z12, int i, kotlin.jvm.internal.e eVar) {
            this(fullScreenActivity, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? false : z11, (i & 8) != 0 ? false : z12);
        }
    }
}
