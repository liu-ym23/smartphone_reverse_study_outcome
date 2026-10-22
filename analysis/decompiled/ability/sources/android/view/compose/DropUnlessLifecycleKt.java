package android.view.compose;

import C7.r;
import S7.a;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.annotation.CheckResult;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.changelist.b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a5\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Landroidx/lifecycle/Lifecycle$State;", "state", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function0;", "LC7/r;", "block", "dropUnlessStateIsAtLeast", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/LifecycleOwner;LS7/a;Landroidx/compose/runtime/Composer;II)LS7/a;", "dropUnlessStarted", "(Landroidx/lifecycle/LifecycleOwner;LS7/a;Landroidx/compose/runtime/Composer;II)LS7/a;", "dropUnlessResumed", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DropUnlessLifecycleKt {
    @CheckResult
    @Composable
    public static final a dropUnlessResumed(LifecycleOwner lifecycleOwner, a aVar, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1331131589, i, -1, "androidx.lifecycle.compose.dropUnlessResumed (DropUnlessLifecycle.kt:99)");
        }
        int i10 = i << 3;
        a aVarDropUnlessStateIsAtLeast = dropUnlessStateIsAtLeast(Lifecycle.State.RESUMED, lifecycleOwner2, aVar, composer, (i10 & 112) | 6 | (i10 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return aVarDropUnlessStateIsAtLeast;
    }

    @CheckResult
    @Composable
    public static final a dropUnlessStarted(LifecycleOwner lifecycleOwner, a aVar, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1207869935, i, -1, "androidx.lifecycle.compose.dropUnlessStarted (DropUnlessLifecycle.kt:77)");
        }
        int i10 = i << 3;
        a aVarDropUnlessStateIsAtLeast = dropUnlessStateIsAtLeast(Lifecycle.State.STARTED, lifecycleOwner2, aVar, composer, (i10 & 112) | 6 | (i10 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return aVarDropUnlessStateIsAtLeast;
    }

    @CheckResult
    @Composable
    private static final a dropUnlessStateIsAtLeast(Lifecycle.State state, LifecycleOwner lifecycleOwner, a aVar, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2057956404, i, -1, "androidx.lifecycle.compose.dropUnlessStateIsAtLeast (DropUnlessLifecycle.kt:47)");
        }
        if (state == Lifecycle.State.DESTROYED) {
            throw new IllegalArgumentException("Target state is not allowed to be `Lifecycle.State.DESTROYED` because Compose disposes of the composition before `Lifecycle.Event.ON_DESTROY` observers are invoked.");
        }
        boolean zChangedInstance = composer.changedInstance(lifecycleOwner) | ((((i & 14) ^ 6) > 4 && composer.changed(state.ordinal())) || (i & 6) == 4) | ((((i & 896) ^ 384) > 256 && composer.changed(aVar)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new b(lifecycleOwner, state, aVar, 1);
            composer.updateRememberedValue(objRememberedValue);
        }
        a aVar2 = (a) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r dropUnlessStateIsAtLeast$lambda$2$lambda$1(LifecycleOwner lifecycleOwner, Lifecycle.State state, a aVar) {
        if (lifecycleOwner.getLifecycle().getState().isAtLeast(state)) {
            aVar.invoke();
        }
        return r.f317a;
    }
}
