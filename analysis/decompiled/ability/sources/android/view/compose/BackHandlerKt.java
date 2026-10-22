package android.view.compose;

import C7.r;
import S7.a;
import S7.k;
import android.view.LifecycleOwner;
import android.view.OnBackPressedCallback;
import android.view.OnBackPressedDispatcher;
import android.view.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b²\u0006\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\nX\u008a\u0084\u0002"}, d2 = {"", "enabled", "Lkotlin/Function0;", "LC7/r;", "onBack", "BackHandler", "(ZLS7/a;Landroidx/compose/runtime/Composer;II)V", "currentOnBack", "activity-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BackHandlerKt {
    @Composable
    public static final void BackHandler(final boolean z10, a aVar, Composer composer, int i, int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-361453782);
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
            i10 |= composerStartRestartGroup.changedInstance(aVar) ? 32 : 16;
        }
        if ((i10 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                z10 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-361453782, i10, -1, "androidx.activity.compose.BackHandler (BackHandler.kt:81)");
            }
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(aVar, composerStartRestartGroup, (i10 >> 3) & 14);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new OnBackPressedCallback(z10) { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$backCallback$1$1
                    @Override // android.view.OnBackPressedCallback
                    public void handleOnBackPressed() {
                        BackHandlerKt.BackHandler$lambda$0(stateRememberUpdatedState).invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1 = (BackHandlerKt$BackHandler$backCallback$1$1) objRememberedValue;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(backHandlerKt$BackHandler$backCallback$1$1) | ((i10 & 14) == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new c(backHandlerKt$BackHandler$backCallback$1$1, z10, 0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.SideEffect((a) objRememberedValue2, composerStartRestartGroup, 0);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner");
            }
            OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
            LifecycleOwner lifecycleOwner = (LifecycleOwner) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(onBackPressedDispatcher) | composerStartRestartGroup.changedInstance(lifecycleOwner) | composerStartRestartGroup.changedInstance(backHandlerKt$BackHandler$backCallback$1$1);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new e(onBackPressedDispatcher, lifecycleOwner, backHandlerKt$BackHandler$backCallback$1$1, 1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.DisposableEffect(lifecycleOwner, onBackPressedDispatcher, (k) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        boolean z11 = z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new d(z11, aVar, i, i6, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a BackHandler$lambda$0(State<? extends a> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r BackHandler$lambda$3$lambda$2(BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1, boolean z10) {
        backHandlerKt$BackHandler$backCallback$1$1.setEnabled(z10);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BackHandler$lambda$7$lambda$6(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, final BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1, DisposableEffectScope disposableEffectScope) {
        onBackPressedDispatcher.addCallback(lifecycleOwner, backHandlerKt$BackHandler$backCallback$1$1);
        return new DisposableEffectResult() { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                remove();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r BackHandler$lambda$8(boolean z10, a aVar, int i, int i6, Composer composer, int i10) {
        BackHandler(z10, aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
        return r.f317a;
    }
}
