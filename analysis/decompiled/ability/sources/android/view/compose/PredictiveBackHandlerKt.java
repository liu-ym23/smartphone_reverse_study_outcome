package android.view.compose;

import B7.a;
import C7.r;
import S7.k;
import S7.n;
import android.annotation.SuppressLint;
import android.view.LifecycleOwner;
import android.view.OnBackPressedDispatcher;
import android.view.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001aC\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002(\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f²\u0006.\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00028\nX\u008a\u0084\u0002"}, d2 = {"", "enabled", "Lkotlin/Function2;", "Lp9/c;", "Landroidx/activity/BackEventCompat;", "LH7/c;", "LC7/r;", "", "onBack", "PredictiveBackHandler", "(ZLS7/n;Landroidx/compose/runtime/Composer;II)V", "currentOnBack", "activity-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PredictiveBackHandlerKt {
    @Composable
    @SuppressLint({"RememberReturnType"})
    public static final void PredictiveBackHandler(boolean z10, n nVar, Composer composer, int i, int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-642000585);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i6 & 2) != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i10 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                z10 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-642000585, i10, -1, "androidx.activity.compose.PredictiveBackHandler (PredictiveBackHandler.kt:76)");
            }
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(nVar, composerStartRestartGroup, (i10 >> 3) & 14);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composerStartRestartGroup), composerStartRestartGroup);
            }
            InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new PredictiveBackHandlerCallback(z10, coroutineScope, PredictiveBackHandler$lambda$0(stateRememberUpdatedState));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            PredictiveBackHandlerCallback predictiveBackHandlerCallback = (PredictiveBackHandlerCallback) objRememberedValue2;
            boolean zChanged = composerStartRestartGroup.changed(PredictiveBackHandler$lambda$0(stateRememberUpdatedState)) | composerStartRestartGroup.changed(coroutineScope);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                predictiveBackHandlerCallback.setCurrentOnBack(PredictiveBackHandler$lambda$0(stateRememberUpdatedState));
                predictiveBackHandlerCallback.setOnBackScope(coroutineScope);
                composerStartRestartGroup.updateRememberedValue(r.f317a);
            }
            Boolean boolValueOf = Boolean.valueOf(z10);
            int i12 = i10 & 14;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(predictiveBackHandlerCallback) | (i12 == 4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new PredictiveBackHandlerKt$PredictiveBackHandler$2$1(predictiveBackHandlerCallback, z10, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (n) objRememberedValue4, composerStartRestartGroup, i12);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner");
            }
            OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
            LifecycleOwner lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(onBackPressedDispatcher) | composerStartRestartGroup.changedInstance(lifecycleOwner) | composerStartRestartGroup.changedInstance(predictiveBackHandlerCallback);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new e(onBackPressedDispatcher, lifecycleOwner, predictiveBackHandlerCallback, 0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, (k) objRememberedValue5, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        boolean z11 = z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new d(z11, nVar, i, i6, 1));
        }
    }

    private static final n PredictiveBackHandler$lambda$0(State<? extends n> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PredictiveBackHandler$lambda$7$lambda$6(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, final PredictiveBackHandlerCallback predictiveBackHandlerCallback, DisposableEffectScope disposableEffectScope) {
        onBackPressedDispatcher.addCallback(lifecycleOwner, predictiveBackHandlerCallback);
        return new DisposableEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                predictiveBackHandlerCallback.remove();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r PredictiveBackHandler$lambda$8(boolean z10, n nVar, int i, int i6, Composer composer, int i10) {
        PredictiveBackHandler(z10, nVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }
}
