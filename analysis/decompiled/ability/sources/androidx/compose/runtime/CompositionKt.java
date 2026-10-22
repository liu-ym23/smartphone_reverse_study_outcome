package androidx.compose.runtime;

import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u001a)\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a0\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0080\b¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u0012\u001a\u00020\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a!\u0010\u0015\u001a\u00020\u00142\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a+\u0010\u0012\u001a\u00020\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u0012\u0010\u001b\u001a+\u0010\u0017\u001a\u00020\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u0017\u0010\u001c\"\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"&\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00028\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$\"\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010)\"\u0014\u0010+\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010)\"\u0014\u0010,\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010)\"\u001e\u0010\u001a\u001a\u00020\u0019*\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u00100\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Composition;", "Landroidx/compose/runtime/CompositionServiceKey;", "key", "getCompositionService", "(Landroidx/compose/runtime/Composition;Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "R", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ShouldPauseCallback;", "shouldPause", "Lkotlin/Function0;", "block", "pausable", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;LS7/a;)Ljava/lang/Object;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/CompositionContext;", "parent", "Composition", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;)Landroidx/compose/runtime/Composition;", "Landroidx/compose/runtime/ReusableComposition;", "ReusableComposition", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;)Landroidx/compose/runtime/ReusableComposition;", "ControlledComposition", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;)Landroidx/compose/runtime/ControlledComposition;", "LH7/h;", "recomposeCoroutineContext", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;LH7/h;)Landroidx/compose/runtime/Composition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;LH7/h;)Landroidx/compose/runtime/ControlledComposition;", "", "PendingApplyNoModifications", "Ljava/lang/Object;", "Landroidx/compose/runtime/tooling/ObservableComposition;", "ObservableCompositionServiceKey", "Landroidx/compose/runtime/CompositionServiceKey;", "getObservableCompositionServiceKey", "()Landroidx/compose/runtime/CompositionServiceKey;", "getObservableCompositionServiceKey$annotations", "()V", "", "RUNNING", "I", "DEACTIVATED", "INCONSISTENT", "DISPOSED", "getRecomposeCoroutineContext", "(Landroidx/compose/runtime/ControlledComposition;)LH7/h;", "getRecomposeCoroutineContext$annotations", "(Landroidx/compose/runtime/ControlledComposition;)V", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionKt {
    private static final int DEACTIVATED = 1;
    private static final int DISPOSED = 3;
    private static final int INCONSISTENT = 2;
    private static final int RUNNING = 0;
    private static final Object PendingApplyNoModifications = new Object();
    private static final CompositionServiceKey<ObservableComposition> ObservableCompositionServiceKey = new CompositionServiceKey<ObservableComposition>() { // from class: androidx.compose.runtime.CompositionKt$ObservableCompositionServiceKey$1
    };

    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    public static final ReusableComposition ReusableComposition(Applier<?> applier, CompositionContext compositionContext) {
        return new CompositionImpl(compositionContext, applier, null, 4, null);
    }

    public static final <T> T getCompositionService(Composition composition, CompositionServiceKey<T> compositionServiceKey) {
        CompositionServices compositionServices = composition instanceof CompositionServices ? (CompositionServices) composition : null;
        if (compositionServices != null) {
            return (T) compositionServices.getCompositionService(compositionServiceKey);
        }
        return null;
    }

    public static final CompositionServiceKey<ObservableComposition> getObservableCompositionServiceKey() {
        return ObservableCompositionServiceKey;
    }

    public static /* synthetic */ void getObservableCompositionServiceKey$annotations() {
    }

    public static final H7.h getRecomposeCoroutineContext(ControlledComposition controlledComposition) {
        H7.h recomposeContext;
        CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
        return (compositionImpl == null || (recomposeContext = compositionImpl.getRecomposeContext()) == null) ? EmptyCoroutineContext.f4908a : recomposeContext;
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getRecomposeCoroutineContext$annotations(ControlledComposition controlledComposition) {
    }

    public static final <R> R pausable(ControlledComposition controlledComposition, ShouldPauseCallback shouldPauseCallback, S7.a aVar) {
        ShouldPauseCallback andSetShouldPauseCallback = controlledComposition.getAndSetShouldPauseCallback(shouldPauseCallback);
        try {
            return (R) aVar.invoke();
        } finally {
            controlledComposition.getAndSetShouldPauseCallback(andSetShouldPauseCallback);
        }
    }

    @ExperimentalComposeApi
    public static final Composition Composition(Applier<?> applier, CompositionContext compositionContext, H7.h hVar) {
        return new CompositionImpl(compositionContext, applier, hVar);
    }

    @ExperimentalComposeApi
    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext compositionContext, H7.h hVar) {
        return new CompositionImpl(compositionContext, applier, hVar);
    }
}
