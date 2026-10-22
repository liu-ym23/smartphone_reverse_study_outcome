package com.mdisdk.core;

import C7.f;
import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.content.Context;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.mdisdk.action.Action;
import com.mdisdk.action.ActionResult;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.model.IntentEntity;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.utils.IntentUtils;
import com.mdisdk.display.OmniDisplay;
import com.mdisdk.mirror.ScaleMode;
import com.mdisdk.mirror.TaskMirrorView;
import com.mdisdk.mirror.TouchForwarder;
import com.mdisdk.observer.AppDiedFilter;
import com.mdisdk.observer.DisplayObserver;
import com.mdisdk.observer.DisplayObserverManager;
import com.mdisdk.observer.ForegroundAppFilter;
import com.mdisdk.observer.ForegroundAppInfo;
import com.mdisdk.observer.VisibleWindowFilter;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.a;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.c0;
import p9.d;
import p9.m;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190 2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\bH\u0096@¢\u0006\u0004\b\u001a\u0010!J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010'J/\u0010/\u001a\u00020.2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020.H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\t2\u0006\u00101\u001a\u00020.H\u0010¢\u0006\u0004\b4\u00103J\u000f\u00106\u001a\u00020.H\u0016¢\u0006\u0004\b6\u00107J\u0011\u00108\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b8\u00109J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b;\u0010<J\u001b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010D\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010K\u001a\u00020\u00042\u0006\u0010A\u001a\u00020I2\u0006\u0010C\u001a\u00020JH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0004H\u0016¢\u0006\u0004\bM\u0010HJ\u001f\u0010P\u001a\u00020\u00042\u0006\u0010A\u001a\u00020N2\u0006\u0010C\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0004H\u0016¢\u0006\u0004\bR\u0010HJ\u001b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u0004H\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020.2\u0006\u0010V\u001a\u00020\u0004H\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020.H\u0016¢\u0006\u0004\b[\u00107J\u0017\u0010]\u001a\u00020\t2\u0006\u0010\\\u001a\u00020.H\u0016¢\u0006\u0004\b]\u00103J\u000f\u0010^\u001a\u00020.H\u0016¢\u0006\u0004\b^\u00107J\u0017\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020.H\u0016¢\u0006\u0004\b`\u00103R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u001b\u0010l\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010nR\u0016\u0010p\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR \u0010w\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020.0u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\t0y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\t0y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010{R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0080\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R\u0019\u0010\u0083\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001¨\u0006\u0085\u0001"}, d2 = {"Lcom/mdisdk/core/DefaultTaskImpl;", "Lcom/mdisdk/Task;", "Landroid/content/Context;", "applicationContext", "", HintConstants.AUTOFILL_HINT_NAME, "Lcom/mdisdk/display/OmniDisplay;", "display", "Lkotlin/Function1;", "LC7/r;", "onFinished", AppAgent.CONSTRUCT, "(Landroid/content/Context;Ljava/lang/String;Lcom/mdisdk/display/OmniDisplay;LS7/k;)V", "", "getDisplayId", "()I", "Landroid/view/Display;", "getDisplay", "()Landroid/view/Display;", "Landroid/view/Surface;", "surface", "setOutputSurface", "(Landroid/view/Surface;)V", "Lcom/mdisdk/action/Action;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lcom/mdisdk/action/ActionResult;", "execute", "(Lcom/mdisdk/action/Action;LH7/c;)Ljava/lang/Object;", "getOutputSurface", "()Landroid/view/Surface;", "Lcom/mdisdk/TaskActionBuilder;", "block", "Lp9/c;", "(LS7/k;LH7/c;)Ljava/lang/Object;", "Lcom/mdisdk/mirror/TaskMirrorView;", "view", "attachMirrorView", "(Lcom/mdisdk/mirror/TaskMirrorView;)V", "detachMirrorView", "()V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "viewWidth", "viewHeight", "Lcom/mdisdk/mirror/ScaleMode;", "scaleMode", "", "forwardTouchEvent", "(Landroid/view/MotionEvent;IILcom/mdisdk/mirror/ScaleMode;)Z", "ignoreActions", "finish", "(Z)V", "finishWithoutCallback$mdisdk_release", "finishWithoutCallback", "isFinished", "()Z", "getLastOpenApp", "()Ljava/lang/String;", WindowStateInfo.KEY_DISPLAY_ID, "getTopApp", "(Ljava/lang/Integer;)Ljava/lang/String;", "Lcom/mdisdk/observer/ForegroundAppInfo;", "getForegroundApp", "(Ljava/lang/Integer;)Lcom/mdisdk/observer/ForegroundAppInfo;", "Lcom/mdisdk/observer/ForegroundAppFilter;", "filter", "Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;", "listener", "registerForegroundAppObserver", "(Lcom/mdisdk/observer/ForegroundAppFilter;Lcom/mdisdk/observer/DisplayObserver$OnForegroundAppChangedListener;)Ljava/lang/String;", "registrationId", "unregisterForegroundAppObserver", "(Ljava/lang/String;)V", "Lcom/mdisdk/observer/VisibleWindowFilter;", "Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;", "registerVisibleWindowObserver", "(Lcom/mdisdk/observer/VisibleWindowFilter;Lcom/mdisdk/observer/DisplayObserver$OnVisibleWindowChangedListener;)Ljava/lang/String;", "unregisterVisibleWindowObserver", "Lcom/mdisdk/observer/AppDiedFilter;", "Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;", "registerAppDiedObserver", "(Lcom/mdisdk/observer/AppDiedFilter;Lcom/mdisdk/observer/DisplayObserver$OnAppDiedListener;)Ljava/lang/String;", "unregisterAppDiedObserver", "Lcom/mdisdk/capability/model/IntentEntity;", "getTopActivityIntent", "(Ljava/lang/Integer;)Lcom/mdisdk/capability/model/IntentEntity;", "packageName", "getShowingDisplayId", "(Ljava/lang/String;)I", "isOmniDisplayId", "(Ljava/lang/String;)Z", "isOmniDisplayImeEnabled", "enabled", "setOmniDisplayImeEnabled", "isOmniDisplayTakeover", "takeover", "setOmniDisplayTakeover", "LS7/k;", "Lcom/mdisdk/core/TaskContext;", "taskContext", "Lcom/mdisdk/core/TaskContext;", "currentMirrorView", "Lcom/mdisdk/mirror/TaskMirrorView;", "Lcom/mdisdk/mirror/TouchForwarder;", "directForwarder$delegate", "LC7/f;", "getDirectForwarder", "()Lcom/mdisdk/mirror/TouchForwarder;", "directForwarder", "lastForwardViewWidth", "I", "lastForwardViewHeight", "lastForwardScaleMode", "Lcom/mdisdk/mirror/ScaleMode;", "Ljava/util/concurrent/atomic/AtomicInteger;", "activeExecutions", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lm9/c0;", "executionJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lm9/p;", "finishSignal", "Lm9/p;", "allDoneSignal", "Lw9/a;", "finishMutex", "Lw9/a;", "isFinishing", "Z", "imeEnabled", "takeoverEnabled", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultTaskImpl extends Task {
    private static final String TAG = "DefaultTask";
    private final AtomicInteger activeExecutions;
    private final InterfaceC1723p allDoneSignal;
    private volatile TaskMirrorView currentMirrorView;

    /* renamed from: directForwarder$delegate, reason: from kotlin metadata */
    private final f directForwarder;
    private final ConcurrentHashMap<c0, Boolean> executionJobs;
    private final InterfaceC2108a finishMutex;
    private final InterfaceC1723p finishSignal;
    private volatile boolean imeEnabled;
    private boolean isFinishing;
    private ScaleMode lastForwardScaleMode;
    private int lastForwardViewHeight;
    private int lastForwardViewWidth;
    private final k onFinished;
    private volatile boolean takeoverEnabled;
    private final TaskContext taskContext;

    @c(c = "com.mdisdk.core.DefaultTaskImpl$execute$3", f = "DefaultTaskImpl.kt", l = {99, 115, 124, 125}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp9/d;", "Lcom/mdisdk/action/ActionResult;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.mdisdk.core.DefaultTaskImpl$execute$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements n {
        final /* synthetic */ k $block;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(k kVar, H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$block = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = DefaultTaskImpl.this.new AnonymousClass3(this.$block, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0170, code lost:
        
            if (r22.this$0.isFinishing != false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0172, code lost:
        
            ((m9.C1724q) r22.this$0.allDoneSignal).U(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x017d, code lost:
        
            return r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x019c, code lost:
        
            if (r22.this$0.isFinishing != false) goto L55;
         */
        /* JADX WARN: Not initialized variable reg: 8, insn: 0x01b0: INVOKE (r3v2 ?? I:java.util.concurrent.ConcurrentHashMap), (r8 I:java.lang.Object) VIRTUAL call: java.util.concurrent.ConcurrentHashMap.remove(java.lang.Object):java.lang.Object A[MD:(java.lang.Object):V (c)], block:B:64:0x01a0 */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:9:0x0026, B:47:0x0149, B:49:0x014d, B:33:0x00ba, B:35:0x00c0, B:37:0x00f7, B:40:0x011a, B:43:0x0131, B:16:0x0043, B:19:0x0052, B:32:0x00a8), top: B:70:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0144 -> B:47:0x0149). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 457
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.core.DefaultTaskImpl.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(d dVar, H7.c<? super r> cVar) {
            return ((AnonymousClass3) create(dVar, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTaskImpl(Context applicationContext, String name, OmniDisplay display, k onFinished) {
        super(name);
        kotlin.jvm.internal.k.f(applicationContext, "applicationContext");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(display, "display");
        kotlin.jvm.internal.k.f(onFinished, "onFinished");
        this.onFinished = onFinished;
        this.taskContext = new TaskContext(applicationContext, display);
        this.directForwarder = a.a(new P3.d(25));
        this.lastForwardScaleMode = ScaleMode.FIT;
        this.activeExecutions = new AtomicInteger(0);
        this.executionJobs = new ConcurrentHashMap<>();
        this.finishSignal = new C1724q();
        this.allDoneSignal = new C1724q();
        this.finishMutex = new kotlinx.coroutines.sync.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TouchForwarder directForwarder_delegate$lambda$0() {
        return new TouchForwarder();
    }

    private final TouchForwarder getDirectForwarder() {
        return (TouchForwarder) this.directForwarder.getF4884a();
    }

    @Override // com.mdisdk.Task
    public void attachMirrorView(TaskMirrorView view) {
        kotlin.jvm.internal.k.f(view, "view");
        if (this.isFinishing) {
            ALog.w$default(TAG, "Task " + getName() + ": cannot attachMirrorView, task is finishing", null, 4, null);
            return;
        }
        TaskMirrorView taskMirrorView = this.currentMirrorView;
        if (taskMirrorView != null && taskMirrorView != view) {
            ALog.w$default(TAG, "Task " + getName() + ": replacing existing mirror view, detaching old", null, 4, null);
            this.currentMirrorView = null;
            taskMirrorView.onTaskDetached$mdisdk_release();
            this.taskContext.getDisplay().setOutputSurface(null);
        }
        this.currentMirrorView = view;
        view.onTaskAttached$mdisdk_release(this);
        Surface surface$mdisdk_release = view.getSurface$mdisdk_release();
        if (surface$mdisdk_release != null) {
            Surface surface = surface$mdisdk_release.isValid() ? surface$mdisdk_release : null;
            if (surface != null) {
                this.taskContext.getDisplay().setOutputSurface(surface);
            }
        }
    }

    @Override // com.mdisdk.Task
    public void detachMirrorView() {
        TaskMirrorView taskMirrorView = this.currentMirrorView;
        if (taskMirrorView == null) {
            return;
        }
        this.currentMirrorView = null;
        taskMirrorView.onTaskDetached$mdisdk_release();
        if (this.isFinishing) {
            return;
        }
        this.taskContext.getDisplay().setOutputSurface(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mdisdk.Task
    public Object execute(Action<?> action, H7.c<? super ActionResult<?>> cVar) {
        return this.isFinishing ? new ActionResult.Failure("Task has finished", null, false, null, null, 30, null) : action.perform$mdisdk_release(this.taskContext, cVar);
    }

    @Override // com.mdisdk.Task
    public void finish(boolean ignoreActions) {
        finishWithoutCallback$mdisdk_release(ignoreActions);
        this.onFinished.invoke(this);
    }

    @Override // com.mdisdk.Task
    public void finishWithoutCallback$mdisdk_release(boolean ignoreActions) {
        if (this.isFinishing || !this.finishMutex.tryLock(null)) {
            return;
        }
        try {
            this.isFinishing = true;
            if (this.imeEnabled) {
                int displayId = getDisplayId();
                setOmniDisplayImeEnabled(false);
                this.imeEnabled = false;
                ALog.d$default(TAG, "Task " + getName() + ": disabled IME for displayId=" + displayId + " before finish", null, 4, null);
            }
            if (this.takeoverEnabled) {
                int displayId2 = getDisplayId();
                FrameworkBridgeFactory.get().setOmniDisplayTakeover(displayId2, false);
                this.takeoverEnabled = false;
                ALog.d$default(TAG, "Task " + getName() + ": disabled OmniDisplay takeover for displayId=" + displayId2 + " before finish", null, 4, null);
            }
            ((C1724q) this.finishSignal).U(r.f317a);
            if (ignoreActions) {
                Set<c0> setKeySet = this.executionJobs.keySet();
                kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
                Iterator<T> it = setKeySet.iterator();
                while (it.hasNext()) {
                    ((c0) it.next()).cancel(null);
                }
                this.taskContext.getDisplay().release();
            } else {
                AbstractC1683A.r(EmptyCoroutineContext.f4908a, new DefaultTaskImpl$finishWithoutCallback$2(this, null));
            }
            DisplayObserverManager.cleanupForTask(getName());
            detachMirrorView();
            ALog.d$default(TAG, "Task " + getName() + " finished, observers cleaned up", null, 4, null);
            this.finishMutex.unlock(null);
        } catch (Throwable th) {
            this.finishMutex.unlock(null);
            throw th;
        }
    }

    @Override // com.mdisdk.Task
    public boolean forwardTouchEvent(MotionEvent event, int viewWidth, int viewHeight, ScaleMode scaleMode) {
        kotlin.jvm.internal.k.f(event, "event");
        kotlin.jvm.internal.k.f(scaleMode, "scaleMode");
        if (this.isFinishing) {
            return false;
        }
        if (viewWidth != this.lastForwardViewWidth || viewHeight != this.lastForwardViewHeight || scaleMode != this.lastForwardScaleMode) {
            Display.Mode mode = this.taskContext.getDisplay().getTargetDisplay().getMode();
            getDirectForwarder().setScaleMode(scaleMode);
            getDirectForwarder().updateViewSize(viewWidth, viewHeight, mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.lastForwardViewWidth = viewWidth;
            this.lastForwardViewHeight = viewHeight;
            this.lastForwardScaleMode = scaleMode;
        }
        return getDirectForwarder().forward(event, getDisplayId());
    }

    @Override // com.mdisdk.Task
    public Display getDisplay() {
        return this.taskContext.getDisplay().getTargetDisplay();
    }

    @Override // com.mdisdk.Task
    public int getDisplayId() {
        return this.taskContext.getDisplay().getDisplayId();
    }

    @Override // com.mdisdk.Task
    public ForegroundAppInfo getForegroundApp(Integer displayId) {
        ForegroundAppInfo topApp = DisplayObserverManager.getTopApp(displayId != null ? displayId.intValue() : getDisplayId());
        if (topApp != null) {
            return topApp;
        }
        return null;
    }

    @Override // com.mdisdk.Task
    public String getLastOpenApp() {
        return this.taskContext.getTargetPackageName();
    }

    @Override // com.mdisdk.Task
    public Surface getOutputSurface() {
        return this.taskContext.getDisplay().getCurrentOutputSurface();
    }

    @Override // com.mdisdk.Task
    public int getShowingDisplayId(String packageName) {
        kotlin.jvm.internal.k.f(packageName, "packageName");
        return FrameworkBridgeFactory.get().getShowingDisplayId(packageName);
    }

    @Override // com.mdisdk.Task
    public IntentEntity getTopActivityIntent(Integer displayId) {
        return IntentUtils.getTopActivityIntent(displayId != null ? displayId.intValue() : getDisplayId());
    }

    @Override // com.mdisdk.Task
    public String getTopApp(Integer displayId) {
        ForegroundAppInfo topApp = DisplayObserverManager.getTopApp(displayId != null ? displayId.intValue() : getDisplayId());
        if (topApp != null) {
            return topApp.getPackageName();
        }
        return null;
    }

    @Override // com.mdisdk.Task
    /* renamed from: isFinished, reason: from getter */
    public boolean getIsFinishing() {
        return this.isFinishing;
    }

    @Override // com.mdisdk.Task
    public boolean isOmniDisplayId(String packageName) {
        kotlin.jvm.internal.k.f(packageName, "packageName");
        return FrameworkBridgeFactory.get().isOmniDisplayId(packageName);
    }

    @Override // com.mdisdk.Task
    /* renamed from: isOmniDisplayImeEnabled, reason: from getter */
    public boolean getImeEnabled() {
        return this.imeEnabled;
    }

    @Override // com.mdisdk.Task
    /* renamed from: isOmniDisplayTakeover, reason: from getter */
    public boolean getTakeoverEnabled() {
        return this.takeoverEnabled;
    }

    @Override // com.mdisdk.Task
    public String registerAppDiedObserver(AppDiedFilter filter, DisplayObserver.OnAppDiedListener listener) {
        kotlin.jvm.internal.k.f(filter, "filter");
        kotlin.jvm.internal.k.f(listener, "listener");
        if (!this.isFinishing) {
            return DisplayObserverManager.registerAppDiedObserver(getName(), filter, listener, Integer.valueOf(getDisplayId()));
        }
        ALog.w$default(TAG, "Cannot register observer, task is finishing", null, 4, null);
        return "";
    }

    @Override // com.mdisdk.Task
    public String registerForegroundAppObserver(ForegroundAppFilter filter, DisplayObserver.OnForegroundAppChangedListener listener) {
        kotlin.jvm.internal.k.f(filter, "filter");
        kotlin.jvm.internal.k.f(listener, "listener");
        if (!this.isFinishing) {
            return DisplayObserverManager.registerForegroundAppObserver(getName(), filter, listener);
        }
        ALog.w$default(TAG, "Cannot register observer, task is finishing", null, 4, null);
        return "";
    }

    @Override // com.mdisdk.Task
    public String registerVisibleWindowObserver(VisibleWindowFilter filter, DisplayObserver.OnVisibleWindowChangedListener listener) {
        kotlin.jvm.internal.k.f(filter, "filter");
        kotlin.jvm.internal.k.f(listener, "listener");
        if (!this.isFinishing) {
            return DisplayObserverManager.registerVisibleWindowObserver(getName(), filter, listener);
        }
        ALog.w$default(TAG, "Cannot register observer, task is finishing", null, 4, null);
        return "";
    }

    @Override // com.mdisdk.Task
    public void setOmniDisplayImeEnabled(boolean enabled) {
        if (this.isFinishing) {
            ALog.w$default(TAG, "Cannot set IME enabled, task is finishing", null, 4, null);
            return;
        }
        int displayId = getDisplayId();
        FrameworkBridgeFactory.get().setOmniDisplayImeEnabled(displayId, enabled);
        this.imeEnabled = enabled;
        ALog.d$default(TAG, "Task " + getName() + ": IME enabled=" + enabled + " for displayId=" + displayId, null, 4, null);
    }

    @Override // com.mdisdk.Task
    public void setOmniDisplayTakeover(boolean takeover) {
        if (this.isFinishing) {
            ALog.w$default(TAG, "Cannot set OmniDisplay takeover, task is finishing", null, 4, null);
            return;
        }
        int displayId = getDisplayId();
        FrameworkBridgeFactory.get().setOmniDisplayTakeover(displayId, takeover);
        this.takeoverEnabled = takeover;
        ALog.d$default(TAG, "Task " + getName() + ": OmniDisplay takeover=" + takeover + " for displayId=" + displayId, null, 4, null);
    }

    @Override // com.mdisdk.Task
    public void setOutputSurface(Surface surface) {
        if (this.isFinishing) {
            return;
        }
        this.taskContext.getDisplay().setOutputSurface(surface);
    }

    @Override // com.mdisdk.Task
    public void unregisterAppDiedObserver(String registrationId) {
        kotlin.jvm.internal.k.f(registrationId, "registrationId");
        DisplayObserverManager.unregisterAppDiedObserver(registrationId);
    }

    @Override // com.mdisdk.Task
    public void unregisterForegroundAppObserver(String registrationId) {
        kotlin.jvm.internal.k.f(registrationId, "registrationId");
        DisplayObserverManager.unregisterForegroundAppObserver(registrationId);
    }

    @Override // com.mdisdk.Task
    public void unregisterVisibleWindowObserver(String registrationId) {
        kotlin.jvm.internal.k.f(registrationId, "registrationId");
        DisplayObserverManager.unregisterVisibleWindowObserver(registrationId);
    }

    @Override // com.mdisdk.Task
    public Object execute(k kVar, H7.c<? super p9.c> cVar) {
        return new m(new AnonymousClass3(kVar, null));
    }
}
