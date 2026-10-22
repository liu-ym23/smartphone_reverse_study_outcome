package android.view.compose;

import S7.a;
import S7.k;
import android.view.result.ActivityResultRegistry;
import android.view.result.ActivityResultRegistryOwner;
import android.view.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"I", "O", "Landroidx/activity/result/contract/ActivityResultContract;", "contract", "Lkotlin/Function1;", "LC7/r;", "onResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "rememberLauncherForActivityResult", "(Landroidx/activity/result/contract/ActivityResultContract;LS7/k;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultRegistryKt {
    @Composable
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(final ActivityResultContract<I, O> activityResultContract, k kVar, Composer composer, int i) {
        final ActivityResultRegistry activityResultRegistry;
        String str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1408504823, i, -1, "androidx.activity.compose.rememberLauncherForActivityResult (ActivityResultRegistry.kt:82)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(activityResultContract, composer, i & 14);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(kVar, composer, (i >> 3) & 14);
        Object[] objArr = new Object[0];
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new a(0);
            composer.updateRememberedValue(objRememberedValue);
        }
        final String str2 = (String) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) null, (String) null, (a) objRememberedValue, composer, 3072, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
        }
        ActivityResultRegistry activityResultRegistry2 = current.getActivityResultRegistry();
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new ActivityResultLauncherHolder();
            composer.updateRememberedValue(objRememberedValue2);
        }
        final ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objRememberedValue2;
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ManagedActivityResultLauncher(activityResultLauncherHolder, stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue3);
        }
        ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) objRememberedValue3;
        boolean zChangedInstance = composer.changedInstance(activityResultLauncherHolder) | composer.changedInstance(activityResultRegistry2) | composer.changed(str2) | composer.changedInstance(activityResultContract) | composer.changed(stateRememberUpdatedState2);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == companion.getEmpty()) {
            activityResultRegistry = activityResultRegistry2;
            Object obj = new k() { // from class: androidx.activity.compose.b
                @Override // S7.k
                public final Object invoke(Object obj2) {
                    return ActivityResultRegistryKt.rememberLauncherForActivityResult$lambda$8$lambda$7(activityResultLauncherHolder, activityResultRegistry, str2, activityResultContract, stateRememberUpdatedState2, (DisposableEffectScope) obj2);
                }
            };
            str = str2;
            composer.updateRememberedValue(obj);
            objRememberedValue4 = obj;
        } else {
            str = str2;
            activityResultRegistry = activityResultRegistry2;
        }
        ActivityResultRegistry activityResultRegistry3 = activityResultRegistry;
        EffectsKt.DisposableEffect(activityResultRegistry3, str, activityResultContract, (k) objRememberedValue4, composer, (i << 6) & 896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return managedActivityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String rememberLauncherForActivityResult$lambda$1$lambda$0() {
        return UUID.randomUUID().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberLauncherForActivityResult$lambda$8$lambda$7(final ActivityResultLauncherHolder activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, State state, DisposableEffectScope disposableEffectScope) {
        activityResultLauncherHolder.setLauncher(activityResultRegistry.register(str, activityResultContract, new B5.a(state, 8)));
        return new DisposableEffectResult() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$lambda$8$lambda$7$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                activityResultLauncherHolder.unregister();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rememberLauncherForActivityResult$lambda$8$lambda$7$lambda$5(State state, Object obj) {
        ((k) state.getValue()).invoke(obj);
    }
}
