package androidx.compose.runtime;

import S7.n;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Set;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH ¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH ¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH ¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0010H ¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0010H ¢\u0006\u0004\b\u001f\u0010\u001aJ\u001d\u0010&\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0010¢\u0006\u0004\b$\u0010%J\u0017\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0010¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0010¢\u0006\u0004\b,\u0010*J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b.\u0010\u001dJ\u0017\u00101\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b0\u0010\u001dJ\u000f\u00105\u001a\u000202H\u0010¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\u0007H\u0010¢\u0006\u0004\b6\u0010\u0003J\u000f\u00109\u001a\u00020\u0007H\u0010¢\u0006\u0004\b8\u0010\u0003J\u0017\u0010>\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H ¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H ¢\u0006\u0004\b?\u0010=J+\u0010G\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:2\u0006\u0010B\u001a\u00020A2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030CH ¢\u0006\u0004\bE\u0010FJ\u0019\u0010J\u001a\u0004\u0018\u00010A2\u0006\u0010;\u001a\u00020:H\u0010¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\bK\u0010\u001dR\u0018\u0010Q\u001a\u00060Mj\u0002`N8 X \u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8 X \u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020R8 X \u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010Y\u001a\u00020R8 X \u0004¢\u0006\u0006\u001a\u0004\bX\u0010TR\u0016\u0010]\u001a\u0004\u0018\u00010Z8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8&X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020^8 X \u0004¢\u0006\u0006\u001a\u0004\bb\u0010`R\u0016\u0010\u0005\u001a\u0004\u0018\u00010d8 X \u0004¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006g"}, d2 = {"Landroidx/compose/runtime/CompositionContext;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/ControlledComposition;", "composition", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;LS7/n;)V", "composeInitial", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;LS7/n;)Landroidx/collection/ScatterSet;", "composeInitialPaused", "invalidScopes", "recomposePaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Landroidx/collection/ScatterSet;)Landroidx/collection/ScatterSet;", "recomposePaused", "scope", "reportPausedScope$runtime", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "reportPausedScope", "invalidate$runtime", "(Landroidx/compose/runtime/ControlledComposition;)V", "invalidate", "invalidateScope$runtime", "invalidateScope", "", "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime", "(Ljava/util/Set;)V", "recordInspectionTable", "Landroidx/compose/runtime/Composer;", "composer", "registerComposer$runtime", "(Landroidx/compose/runtime/Composer;)V", "registerComposer", "unregisterComposer$runtime", "unregisterComposer", "registerComposition$runtime", "registerComposition", "unregisterComposition$runtime", "unregisterComposition", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope$runtime", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getCompositionLocalScope", "startComposing$runtime", "startComposing", "doneComposing$runtime", "doneComposing", "Landroidx/compose/runtime/MovableContentStateReference;", TypedValues.Custom.S_REFERENCE, "insertMovableContent$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "deletedMovableContent$runtime", "deletedMovableContent", "Landroidx/compose/runtime/MovableContentState;", SettingsConfig.KEY_DATA, "Landroidx/compose/runtime/Applier;", "applier", "movableContentStateReleased$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentState;Landroidx/compose/runtime/Applier;)V", "movableContentStateReleased", "movableContentStateResolve$runtime", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", "reportRemovedComposition$runtime", "reportRemovedComposition", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCompositeKeyHashCode$runtime", "()J", "compositeKeyHashCode", "", "getCollectingParameterInformation$runtime", "()Z", "collectingParameterInformation", "getCollectingSourceInformation$runtime", "collectingSourceInformation", "getCollectingCallByInformation$runtime", "collectingCallByInformation", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "LH7/h;", "getEffectCoroutineContext", "()LH7/h;", "effectCoroutineContext", "getRecomposeCoroutineContext$runtime", "recomposeCoroutineContext", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CompositionContext {
    public static final int $stable = 0;

    public abstract void composeInitial$runtime(ControlledComposition composition, n content);

    public abstract ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, n content);

    public abstract void deletedMovableContent$runtime(MovableContentStateReference reference);

    public void doneComposing$runtime() {
    }

    public abstract boolean getCollectingCallByInformation$runtime();

    /* renamed from: getCollectingParameterInformation$runtime */
    public abstract boolean getCollectingParameterInformation();

    /* renamed from: getCollectingSourceInformation$runtime */
    public abstract boolean getCollectingSourceInformation();

    /* renamed from: getCompositeKeyHashCode$runtime */
    public abstract long getCompositeKeyHashCode();

    public abstract Composition getComposition$runtime();

    public PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
        return CompositionContextKt.EmptyPersistentCompositionLocalMap;
    }

    public abstract H7.h getEffectCoroutineContext();

    /* renamed from: getObserverHolder$runtime */
    public CompositionObserverHolder getObserverHolder() {
        return null;
    }

    public abstract H7.h getRecomposeCoroutineContext$runtime();

    public abstract void insertMovableContent$runtime(MovableContentStateReference reference);

    public abstract void invalidate$runtime(ControlledComposition composition);

    public abstract void invalidateScope$runtime(RecomposeScopeImpl scope);

    public abstract void movableContentStateReleased$runtime(MovableContentStateReference reference, MovableContentState data, Applier<?> applier);

    public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference reference) {
        return null;
    }

    public abstract ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes);

    public void recordInspectionTable$runtime(Set<CompositionData> table) {
    }

    public void registerComposer$runtime(Composer composer) {
    }

    public abstract void registerComposition$runtime(ControlledComposition composition);

    public abstract void reportPausedScope$runtime(RecomposeScopeImpl scope);

    public abstract void reportRemovedComposition$runtime(ControlledComposition composition);

    public void startComposing$runtime() {
    }

    public void unregisterComposer$runtime(Composer composer) {
    }

    public abstract void unregisterComposition$runtime(ControlledComposition composition);
}
