package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.obric.contactsdk.loader.ContractKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SavedStateRegistryController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/savedstate/SavedStateRegistryController;", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "attached", "", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "performAttach", "", "performRestore", "savedState", "Landroid/os/Bundle;", "performSave", "outBundle", "Companion", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SavedStateRegistryController {
    public static final Companion Companion = null;
    private boolean attached;
    private final SavedStateRegistryOwner owner;
    private final SavedStateRegistry savedStateRegistry;

    /* JADX INFO: compiled from: SavedStateRegistryController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/savedstate/SavedStateRegistryController$Companion;", "", "()V", ContractKt.OBRIC_ACTION_CREATE, "Landroidx/savedstate/SavedStateRegistryController;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SavedStateRegistryController create(SavedStateRegistryOwner r2) {
            Intrinsics.checkNotNullParameter(r2, "owner");
            return new SavedStateRegistryController(r2, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final SavedStateRegistryController create(SavedStateRegistryOwner r1) {
        return Companion.create(r1);
    }

    private SavedStateRegistryController(SavedStateRegistryOwner r1) {
        this.owner = r1;
        this.savedStateRegistry = new SavedStateRegistry();
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    public final void performAttach() {
        Lifecycle r0 = this.owner.getLifecycle();
        if (r0.getCurrentState() != Lifecycle.State.INITIALIZED) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        r0.addObserver(new Recreator(this.owner));
        this.savedStateRegistry.performAttach$savedstate_release(r0);
        this.attached = true;
        return;
    L10:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final void performRestore(Bundle r4) {
        if (this.attached == true) goto L5;
        performAttach();
    L5:
        Lifecycle r0 = this.owner.getLifecycle();
        if ((!r0.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) == false) goto L10;
        this.savedStateRegistry.performRestore$savedstate_release(r4);
        return;
    L10:
        throw new IllegalStateException(("performRestore cannot be called when owner is " + r0.getCurrentState()).toString());
    }

    public final void performSave(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outBundle");
        this.savedStateRegistry.performSave(r2);
    }
}
