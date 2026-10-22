package android.view.compose;

import H7.h;
import S7.n;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import p9.c;
import p9.t;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aA\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\r\u001aK\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0010\u001aI\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0011¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lp9/t;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Lifecycle$State;", "minActiveState", "LH7/h;", "context", "Landroidx/compose/runtime/State;", "collectAsStateWithLifecycle", "(Lp9/t;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;LH7/h;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "(Lp9/t;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;LH7/h;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lp9/c;", "initialValue", "(Lp9/c;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;LH7/h;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Lp9/c;Ljava/lang/Object;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;LH7/h;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowExtKt {
    @Composable
    public static final <T> State<T> collectAsStateWithLifecycle(t tVar, LifecycleOwner lifecycleOwner, Lifecycle.State state, h hVar, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        }
        if ((i6 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i6 & 4) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        h hVar2 = hVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(743249048, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:62)");
        }
        int i10 = i << 3;
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(tVar, tVar.getValue(), lifecycleOwner.getLifecycle(), state2, hVar2, composer, (i & 14) | (i10 & 7168) | (i10 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    public static final <T> State<T> collectAsStateWithLifecycle(t tVar, Lifecycle lifecycle, Lifecycle.State state, h hVar, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i6 & 4) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        h hVar2 = hVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1858162195, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:99)");
        }
        int i10 = i << 3;
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(tVar, tVar.getValue(), lifecycle, state2, hVar2, composer, (i & 14) | (i10 & 896) | (i10 & 7168) | (i10 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    public static final <T> State<T> collectAsStateWithLifecycle(c cVar, T t9, LifecycleOwner lifecycleOwner, Lifecycle.State state, h hVar, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        }
        if ((i6 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i6 & 8) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        h hVar2 = hVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485997211, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:138)");
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(cVar, t9, lifecycleOwner.getLifecycle(), state2, hVar2, composer, (i & 14) | (((i >> 3) & 8) << 3) | (i & 112) | (i & 7168) | (57344 & i), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    public static final <T> State<T> collectAsStateWithLifecycle(c cVar, T t9, Lifecycle lifecycle, Lifecycle.State state, h hVar, Composer composer, int i, int i6) {
        if ((i6 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i6 & 8) != 0) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        h hVar2 = hVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1977777920, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:174)");
        }
        Object[] objArr = {cVar, lifecycle, state2, hVar2};
        boolean zChangedInstance = composer.changedInstance(lifecycle) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(state2.ordinal())) || (i & 3072) == 2048) | composer.changedInstance(hVar2) | composer.changedInstance(cVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowExtKt$collectAsStateWithLifecycle$1$1 flowExtKt$collectAsStateWithLifecycle$1$1 = new FlowExtKt$collectAsStateWithLifecycle$1$1(lifecycle, state2, hVar2, cVar, null);
            composer.updateRememberedValue(flowExtKt$collectAsStateWithLifecycle$1$1);
            objRememberedValue = flowExtKt$collectAsStateWithLifecycle$1$1;
        }
        State<T> stateProduceState = SnapshotStateKt.produceState((Object) t9, objArr, (n) objRememberedValue, composer, (i >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateProduceState;
    }
}
