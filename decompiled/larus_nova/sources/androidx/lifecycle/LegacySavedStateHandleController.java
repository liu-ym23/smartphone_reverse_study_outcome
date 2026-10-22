package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "<init>", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "create", "Landroidx/lifecycle/SavedStateHandleController;", "registry", "Landroidx/savedstate/SavedStateRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "key", "defaultArgs", "Landroid/os/Bundle;", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacySavedStateHandleController {
    public static final LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "<init>", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public void onRecreated(SavedStateRegistryOwner r100) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            if ((r100 instanceof ViewModelStoreOwner) == false) goto L16;
            ViewModelStore r101 = ((ViewModelStoreOwner) r100).getViewModelStore();
            SavedStateRegistry r102 = r100.getSavedStateRegistry();
            Iterator<String> r103 = r101.keys().iterator();
        L6:
            if (r103.hasNext() == false) goto L12;
            ViewModel r104 = r101.get(r103.next());
            if (r104 == null) goto L6;
            LegacySavedStateHandleController.attachHandleIfNeeded(r104, r102, r100.getLifecycle());
            goto L6
        L12:
            if ((!r101.keys().isEmpty()) == false) goto L22;
            r102.runOnNextRecreation(OnRecreation.class);
            return;
        L22:
            return;
        L16:
            throw new IllegalStateException(("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: " + r100).toString());
        }
    }

    static {
        INSTANCE = new LegacySavedStateHandleController();
    }

    private LegacySavedStateHandleController() {
    }

    private final void tryToAddRecreator(final SavedStateRegistry r100, final Lifecycle r101) {
        Lifecycle.State r102 = r101.getCurrentState();
        if (r102 != Lifecycle.State.INITIALIZED) goto L5;
    L8:
        r100.runOnNextRecreation(OnRecreation.class);
        return;
    L5:
        if (r102.isAtLeast(Lifecycle.State.STARTED) == true) goto L8;
        r101.addObserver(new AnonymousClass1(r101, r100));
    }

    @JvmStatic
    public static final void attachHandleIfNeeded(ViewModel r100, SavedStateRegistry r101, Lifecycle r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "registry");
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        SavedStateHandleController r103 = (SavedStateHandleController) r100.getCloseable(TAG_SAVED_STATE_HANDLE_CONTROLLER);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isAttached() == true) goto L9;
        r103.attachToLifecycle(r101, r102);
        INSTANCE.tryToAddRecreator(r101, r102);
        return;
    }

    @JvmStatic
    public static final SavedStateHandleController create(SavedStateRegistry r100, Lifecycle r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNull(r102);
        Bundle r104 = r100.consumeRestoredStateForKey(r102);
        SavedStateHandleController r105 = new SavedStateHandleController(r102, SavedStateHandle.Companion.createHandle(r104, r103));
        r105.attachToLifecycle(r100, r101);
        INSTANCE.tryToAddRecreator(r100, r101);
        return r105;
    }
}
