package androidx.compose.runtime;

import S7.n;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011\u0012\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J \u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0082\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u0019J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010\u0019J\u000f\u0010'\u001a\u00020\fH\u0000¢\u0006\u0004\b&\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u00100R\"\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00104\u001a\u0004\b5\u00106R\u001b\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b8\u00109R\u001b\u0010\u0015\u001a\u00060\u0013j\u0002`\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010:\u001a\u0004\b;\u0010<R&\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u001b0=j\b\u0012\u0004\u0012\u00020\u001b`>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020B0A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010F\u001a\u00020E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130J8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u00106R\u0014\u0010Q\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u00106R\u0014\u0010R\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u00106R\u0014\u0010S\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u00106¨\u0006T"}, d2 = {"Landroidx/compose/runtime/PausedCompositionImpl;", "Landroidx/compose/runtime/PausedComposition;", "Landroidx/compose/runtime/CompositionImpl;", "composition", "Landroidx/compose/runtime/CompositionContext;", "context", "Landroidx/compose/runtime/ComposerImpl;", "composer", "", "Landroidx/compose/runtime/RememberObserver;", "abandonSet", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "", "reusable", "Landroidx/compose/runtime/Applier;", "applier", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/CompositionImpl;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/ComposerImpl;Ljava/util/Set;LS7/n;ZLandroidx/compose/runtime/Applier;Ljava/lang/Object;)V", "markComplete", "()V", "applyChanges", "Landroidx/compose/runtime/PausedCompositionState;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "updateState", "(Landroidx/compose/runtime/PausedCompositionState;Landroidx/compose/runtime/PausedCompositionState;)V", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "resume", "(Landroidx/compose/runtime/ShouldPauseCallback;)Z", "apply", "cancel", "markIncomplete$runtime", "markIncomplete", "Landroidx/compose/runtime/CompositionImpl;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/CompositionContext;", "getContext", "()Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/ComposerImpl;", "getComposer", "()Landroidx/compose/runtime/ComposerImpl;", "LS7/n;", "getContent", "()LS7/n;", "Z", "getReusable", "()Z", "Landroidx/compose/runtime/Applier;", "getApplier", "()Landroidx/compose/runtime/Applier;", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/AtomicReference;", "state", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidScopes", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "getRememberManager$runtime", "()Landroidx/compose/runtime/internal/RememberEventDispatcher;", "Landroidx/compose/runtime/RecordingApplier;", "pausableApplier", "Landroidx/compose/runtime/RecordingApplier;", "getPausableApplier$runtime", "()Landroidx/compose/runtime/RecordingApplier;", "isRecomposing$runtime", "isRecomposing", "isComplete", "isApplied", "isCancelled", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PausedCompositionImpl implements PausedComposition {
    public static final int $stable = 8;
    private final Applier<?> applier;
    private final ComposerImpl composer;
    private final CompositionImpl composition;
    private final n content;
    private final CompositionContext context;
    private final Object lock;
    private final RecordingApplier<Object> pausableApplier;
    private final RememberEventDispatcher rememberManager;
    private final boolean reusable;
    private AtomicReference<PausedCompositionState> state = new AtomicReference<>(PausedCompositionState.InitialPending);
    private ScatterSet<RecomposeScopeImpl> invalidScopes = ScatterSetKt.emptyScatterSet();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PausedCompositionState.values().length];
            try {
                iArr[PausedCompositionState.InitialPending.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PausedCompositionState.RecomposePending.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PausedCompositionState.Recomposing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PausedCompositionState.ApplyPending.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PausedCompositionState.Applied.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PausedCompositionState.Cancelled.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PausedCompositionState.Invalid.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PausedCompositionImpl(CompositionImpl compositionImpl, CompositionContext compositionContext, ComposerImpl composerImpl, Set<RememberObserver> set, n nVar, boolean z10, Applier<?> applier, Object obj) {
        this.composition = compositionImpl;
        this.context = compositionContext;
        this.composer = composerImpl;
        this.content = nVar;
        this.reusable = z10;
        this.applier = applier;
        this.lock = obj;
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher();
        rememberEventDispatcher.prepare(set, composerImpl.getErrorContext$runtime());
        this.rememberManager = rememberEventDispatcher;
        this.pausableApplier = new RecordingApplier<>(applier.getCurrent());
    }

    private final void applyChanges() {
        synchronized (this.lock) {
            try {
                RecordingApplier<Object> recordingApplier = this.pausableApplier;
                Applier<?> applier = this.applier;
                kotlin.jvm.internal.k.d(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                recordingApplier.playTo(applier, this.rememberManager);
                this.rememberManager.dispatchRememberObservers();
                this.rememberManager.dispatchSideEffects();
            } finally {
                this.rememberManager.dispatchAbandons();
                this.composition.pausedCompositionFinished$runtime(null);
            }
        }
    }

    private final void markComplete() {
        PausedCompositionState pausedCompositionState = PausedCompositionState.RecomposePending;
        PausedCompositionState pausedCompositionState2 = PausedCompositionState.ApplyPending;
        if (this.state.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
    }

    private final void updateState(PausedCompositionState from, PausedCompositionState to) {
        if (this.state.compareAndSet(from, to)) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + from + " to: " + to + '.');
    }

    @Override // androidx.compose.runtime.PausedComposition
    public void apply() throws Exception {
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[this.state.get().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    throw new IllegalStateException("The paused composition has not completed yet");
                case 4:
                    applyChanges();
                    PausedCompositionState pausedCompositionState = PausedCompositionState.ApplyPending;
                    PausedCompositionState pausedCompositionState2 = PausedCompositionState.Applied;
                    if (this.state.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                        return;
                    }
                    PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
                    return;
                case 5:
                    throw new IllegalStateException("The paused composition has already been applied");
                case 6:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 7:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            this.state.set(PausedCompositionState.Invalid);
            throw e;
        }
    }

    @Override // androidx.compose.runtime.PausedComposition
    public void cancel() {
        this.state.set(PausedCompositionState.Cancelled);
        ScatterSet<RememberObserverHolder> scatterSetExtractRememberSet = this.rememberManager.extractRememberSet();
        this.rememberManager.dispatchAbandons();
        this.composition.pausedCompositionFinished$runtime(scatterSetExtractRememberSet);
    }

    public final Applier<?> getApplier() {
        return this.applier;
    }

    public final ComposerImpl getComposer() {
        return this.composer;
    }

    public final CompositionImpl getComposition() {
        return this.composition;
    }

    public final n getContent() {
        return this.content;
    }

    public final CompositionContext getContext() {
        return this.context;
    }

    public final Object getLock() {
        return this.lock;
    }

    public final RecordingApplier<Object> getPausableApplier$runtime() {
        return this.pausableApplier;
    }

    /* renamed from: getRememberManager$runtime, reason: from getter */
    public final RememberEventDispatcher getRememberManager() {
        return this.rememberManager;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    @Override // androidx.compose.runtime.PausedComposition
    public boolean isApplied() {
        return this.state.get() == PausedCompositionState.Applied;
    }

    @Override // androidx.compose.runtime.PausedComposition
    public boolean isCancelled() {
        return this.state.get() == PausedCompositionState.Cancelled;
    }

    @Override // androidx.compose.runtime.PausedComposition
    public boolean isComplete() {
        return this.state.get().compareTo(PausedCompositionState.ApplyPending) >= 0;
    }

    public final boolean isRecomposing$runtime() {
        return this.state.get() == PausedCompositionState.Recomposing;
    }

    public final void markIncomplete$runtime() {
        PausedCompositionState pausedCompositionState = this.state.get();
        PausedCompositionState pausedCompositionState2 = PausedCompositionState.RecomposePending;
        if (pausedCompositionState == pausedCompositionState2) {
            return;
        }
        PausedCompositionState pausedCompositionState3 = PausedCompositionState.ApplyPending;
        if (this.state.compareAndSet(pausedCompositionState3, pausedCompositionState2)) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState3 + " to: " + pausedCompositionState2 + '.');
    }

    @Override // androidx.compose.runtime.PausedComposition
    public boolean resume(ShouldPauseCallback shouldPause) throws Exception {
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[this.state.get().ordinal()]) {
                case 1:
                    if (this.reusable) {
                        this.composer.startReuseFromRoot();
                    }
                    try {
                        this.invalidScopes = this.context.composeInitialPaused$runtime(this.composition, shouldPause, this.content);
                        PausedCompositionState pausedCompositionState = PausedCompositionState.InitialPending;
                        PausedCompositionState pausedCompositionState2 = PausedCompositionState.RecomposePending;
                        if (!this.state.compareAndSet(pausedCompositionState, pausedCompositionState2)) {
                            PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState + " to: " + pausedCompositionState2 + '.');
                        }
                        if (this.invalidScopes.isEmpty()) {
                            markComplete();
                        }
                        return isComplete();
                    } finally {
                        if (this.reusable) {
                            this.composer.endReuseFromRoot();
                        }
                    }
                case 2:
                    PausedCompositionState pausedCompositionState3 = PausedCompositionState.RecomposePending;
                    PausedCompositionState pausedCompositionState4 = PausedCompositionState.Recomposing;
                    if (!this.state.compareAndSet(pausedCompositionState3, pausedCompositionState4)) {
                        PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState3 + " to: " + pausedCompositionState4 + '.');
                    }
                    try {
                        this.invalidScopes = this.context.recomposePaused$runtime(this.composition, shouldPause, this.invalidScopes);
                        if (!this.state.compareAndSet(pausedCompositionState4, pausedCompositionState3)) {
                            PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState4 + " to: " + pausedCompositionState3 + '.');
                        }
                        if (this.invalidScopes.isEmpty()) {
                            markComplete();
                        }
                        return isComplete();
                    } catch (Throwable th) {
                        PausedCompositionState pausedCompositionState5 = PausedCompositionState.Recomposing;
                        PausedCompositionState pausedCompositionState6 = PausedCompositionState.RecomposePending;
                        if (!this.state.compareAndSet(pausedCompositionState5, pausedCompositionState6)) {
                            PreconditionsKt.throwIllegalStateException("Unexpected state change from: " + pausedCompositionState5 + " to: " + pausedCompositionState6 + '.');
                        }
                        throw th;
                    }
                case 3:
                    ComposerKt.composeRuntimeError("Recursive call to resume()");
                    throw new KotlinNothingValueException();
                case 4:
                    throw new IllegalStateException("Pausable composition is complete and apply() should be applied");
                case 5:
                    throw new IllegalStateException("The paused composition has been applied");
                case 6:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 7:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            this.state.set(PausedCompositionState.Invalid);
            throw e;
        }
    }
}
