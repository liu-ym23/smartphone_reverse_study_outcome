package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.obric.contactsdk.loader.ContractKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", ContractKt.OBRIC_ACTION_CREATE, "Landroidx/lifecycle/SavedStateHandleController;", "key", "defaultArgs", "Landroid/os/Bundle;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    /* JADX INFO: compiled from: LegacySavedStateHandleController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r5) {
            Intrinsics.checkNotNullParameter(r5, "owner");
            if ((r5 instanceof ViewModelStoreOwner) == false) goto L13;
            ViewModelStore r4 = ((ViewModelStoreOwner) r5).getViewModelStore();
            SavedStateRegistry r0 = r5.getSavedStateRegistry();
            Iterator<String> r1 = r4.keys().iterator();
        L6:
            if (r1.hasNext() == false) goto L9;
            ViewModel r2 = r4.get(r1.next());
            Intrinsics.checkNotNull(r2);
            LegacySavedStateHandleController.attachHandleIfNeeded(r2, r0, r5.getLifecycle());
            goto L6
        L9:
            if ((!r4.keys().isEmpty()) == false) goto L15;
            r0.runOnNextRecreation(OnRecreation.class);
            return;
        L15:
            return;
        L13:
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    static {
        INSTANCE = new LegacySavedStateHandleController();
    }

    private LegacySavedStateHandleController() {
    }

    @JvmStatic
    public static final SavedStateHandleController create(SavedStateRegistry r2, Lifecycle r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        Intrinsics.checkNotNull(r4);
        Bundle r0 = r2.consumeRestoredStateForKey(r4);
        SavedStateHandleController r1 = new SavedStateHandleController(r4, SavedStateHandle.Companion.createHandle(r0, r5));
        r1.attachToLifecycle(r2, r3);
        INSTANCE.tryToAddRecreator(r2, r3);
        return r1;
    }

    @JvmStatic
    public static final void attachHandleIfNeeded(ViewModel r1, SavedStateRegistry r2, Lifecycle r3) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        SavedStateHandleController r4 = (SavedStateHandleController) r1.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isAttached() == true) goto L9;
        r4.attachToLifecycle(r2, r3);
        INSTANCE.tryToAddRecreator(r2, r3);
        return;
    }

    private final void tryToAddRecreator(final SavedStateRegistry r2, final Lifecycle r3) {
        Lifecycle.State r1 = r3.getCurrentState();
        if (r1 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r2.runOnNextRecreation(OnRecreation.class);
        return;
    L5:
        if (r1.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r3.addObserver(new AnonymousClass1(r3, r2));
    }
}
