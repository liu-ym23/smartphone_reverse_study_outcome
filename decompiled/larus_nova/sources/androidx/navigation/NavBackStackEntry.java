package androidx.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003HIJB\u001b\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bBQ\b\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\u0013\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0096\u0002J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0007J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0007H\u0007J\b\u0010G\u001a\u00020@H\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\f@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "entry", "arguments", "Landroid/os/Bundle;", "(Landroidx/navigation/NavBackStackEntry;Landroid/os/Bundle;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/navigation/NavDestination;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavViewModelStoreProvider;Ljava/lang/String;Landroid/os/Bundle;)V", "getArguments", "()Landroid/os/Bundle;", "defaultFactory", "Landroidx/lifecycle/SavedStateViewModelFactory;", "getDefaultFactory", "()Landroidx/lifecycle/SavedStateViewModelFactory;", "defaultFactory$delegate", "Lkotlin/Lazy;", "getDestination", "()Landroidx/navigation/NavDestination;", "setDestination", "(Landroidx/navigation/NavDestination;)V", "getId", "()Ljava/lang/String;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/LifecycleRegistry;", "maxState", "maxLifecycle", "getMaxLifecycle", "()Landroidx/lifecycle/Lifecycle$State;", "setMaxLifecycle", "(Landroidx/lifecycle/Lifecycle$State;)V", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "getSavedStateHandle", "()Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle$delegate", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "savedStateRegistryRestored", "", "equals", "other", "", "getDefaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getSavedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "handleLifecycleEvent", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "hashCode", "", "saveState", "outBundle", "updateState", "Companion", "NavResultSavedStateFactory", "SavedStateViewModel", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public static final Companion Companion = null;
    private final Bundle arguments;
    private final Context context;
    private final Lazy defaultFactory$delegate;
    private NavDestination destination;
    private Lifecycle.State hostLifecycleState;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f15582id;
    private LifecycleRegistry lifecycle;
    private Lifecycle.State maxLifecycle;
    private final Bundle savedState;
    private final Lazy savedStateHandle$delegate;
    private final SavedStateRegistryController savedStateRegistryController;
    private boolean savedStateRegistryRestored;
    private final NavViewModelStoreProvider viewModelStoreProvider;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavBackStackEntry$Companion;", "", "()V", "create", "Landroidx/navigation/NavBackStackEntry;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "viewModelStoreProvider", "Landroidx/navigation/NavViewModelStoreProvider;", "id", "", "savedState", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final NavBackStackEntry create(Context r110, NavDestination r111, Bundle r112, Lifecycle.State r113, NavViewModelStoreProvider r114, String r115, Bundle r116) {
            Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
            Intrinsics.checkNotNullParameter(r113, "hostLifecycleState");
            Intrinsics.checkNotNullParameter(r115, "id");
            return new NavBackStackEntry(r110, r111, r112, r113, r114, r115, r116, null);
        }

        public static /* synthetic */ NavBackStackEntry create$default(Companion r110, Context r111, NavDestination r112, Bundle r113, Lifecycle.State r114, NavViewModelStoreProvider r115, String r116, Bundle r117, int r118, Object r119) {
            if ((r118 & 4) == 0) goto L5;
            Bundle r100 = null;
        L7:
            if ((r118 & 8) == 0) goto L9;
            Lifecycle.State r101 = Lifecycle.State.CREATED;
        L11:
            if ((r118 & 16) == 0) goto L13;
            NavViewModelStoreProvider r102 = null;
        L15:
            if ((r118 & 32) == 0) goto L17;
            String r103 = UUID.randomUUID().toString();
        L19:
            if ((r118 & 64) == 0) goto L21;
            Bundle r104 = null;
        L23:
            return r110.create(r111, r112, r100, r101, r102, r103, r104);
        L21:
            r104 = r117;
            goto L23
        L17:
            r103 = r116;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J5\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavBackStackEntry$NavResultSavedStateFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        public NavResultSavedStateFactory(SavedStateRegistryOwner r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            super(r100, r101);
        }

        @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
        public <T extends ViewModel> T create(String r100, Class<T> r101, SavedStateHandle r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "modelClass");
            Intrinsics.checkNotNullParameter(r102, "handle");
            return new SavedStateViewModel(r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavBackStackEntry$SavedStateViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "getHandle", "()Landroidx/lifecycle/SavedStateHandle;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SavedStateViewModel extends ViewModel {
        private final SavedStateHandle handle;

        public final SavedStateHandle getHandle() {
            return this.handle;
        }

        public SavedStateViewModel(SavedStateHandle r100) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            this.handle = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ NavBackStackEntry(Context r100, NavDestination r101, Bundle r102, Lifecycle.State r103, NavViewModelStoreProvider r104, String r105, Bundle r106, DefaultConstructorMarker r107) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return HasDefaultViewModelProviderFactory.CC.$default$getDefaultViewModelCreationExtras(this);
    }

    private final SavedStateViewModelFactory getDefaultFactory() {
        return (SavedStateViewModelFactory) this.defaultFactory$delegate.getValue();
    }

    public final SavedStateHandle getSavedStateHandle() {
        return (SavedStateHandle) this.savedStateHandle$delegate.getValue();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.savedStateRegistryRestored == false) goto L18;
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L16;
        NavViewModelStoreProvider r101 = this.viewModelStoreProvider;
        if (r101 == null) goto L14;
        return r101.getViewModelStore(this.f15582id);
    L14:
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
    L16:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
    L7:
        r100 = false;
        goto L8
    L18:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }

    public int hashCode() {
        int r100 = (this.f15582id.hashCode() * 31) + this.destination.hashCode();
        Bundle r101 = this.arguments;
        if (r101 == null) goto L17;
        Set<String> r102 = r101.keySet();
        if (r102 == null) goto L17;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        String r104 = (String) r103.next();
        int r105 = r100 * 31;
        Object r106 = getArguments().get(r104);
        if (r106 != null) goto L14;
        int r107 = 0;
    L15:
        r100 = r105 + r107;
        goto L10
    L14:
        r107 = r106.hashCode();
    L17:
        return (((r100 * 31) + this.lifecycle.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final void updateState() {
        if (this.savedStateRegistryRestored == true) goto L6;
        this.savedStateRegistryController.performRestore(this.savedState);
        this.savedStateRegistryRestored = true;
    L6:
        if (this.hostLifecycleState.ordinal() >= this.maxLifecycle.ordinal()) goto L8;
        this.lifecycle.setCurrentState(this.hostLifecycleState);
        return;
    L8:
        this.lifecycle.setCurrentState(this.maxLifecycle);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return getDefaultFactory();
    }

    public final Bundle getArguments() {
        return this.arguments;
    }

    public final NavDestination getDestination() {
        return this.destination;
    }

    public final String getId() {
        return this.f15582id;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final Lifecycle.State getMaxLifecycle() {
        return this.maxLifecycle;
    }

    public static final /* synthetic */ Context access$getContext$p(NavBackStackEntry r100) {
        return r100.context;
    }

    public static final /* synthetic */ LifecycleRegistry access$getLifecycle$p(NavBackStackEntry r100) {
        return r100.lifecycle;
    }

    public static final /* synthetic */ boolean access$getSavedStateRegistryRestored$p(NavBackStackEntry r100) {
        return r100.savedStateRegistryRestored;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof NavBackStackEntry) == false) goto L52;
        NavBackStackEntry r101 = (NavBackStackEntry) r100;
        if (Intrinsics.areEqual(this.f15582id, r101.f15582id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.destination, r101.destination) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lifecycle, r101.lifecycle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getSavedStateRegistry(), r101.getSavedStateRegistry()) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.arguments, r101.arguments) == true) goto L41;
        Bundle r102 = this.arguments;
        if (r102 != null) goto L20;
    L19:
        boolean r103 = false;
    L40:
        if (r103 == true) goto L41;
        return false;
    L20:
        Set<String> r104 = r102.keySet();
        if (r104 == null) goto L19;
        Set<String> r105 = r104;
        if ((r105 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r106 = r105.iterator();
    L30:
        if (r106.hasNext() == false) goto L27;
        String r107 = (String) r106.next();
        Object r108 = getArguments().get(r107);
        Bundle r109 = r101.getArguments();
        if (r109 != null) goto L34;
        Object r110 = null;
    L36:
        if (Intrinsics.areEqual(r108, r110) == true) goto L30;
        boolean r111 = false;
    L38:
        if (r111 != true) goto L19;
        r103 = true;
        goto L40
    L34:
        r110 = r109.get(r107);
    L27:
        r111 = true;
        goto L38
    L26:
        if (r105.isEmpty() == false) goto L28;
    L41:
        return true;
    L52:
        return false;
    }

    public final void handleLifecycleEvent(Lifecycle.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.hostLifecycleState = r100.getTargetState();
        updateState();
    }

    public final void saveState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outBundle");
        this.savedStateRegistryController.performSave(r100);
    }

    public final void setDestination(NavDestination r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.destination = r100;
    }

    public final void setMaxLifecycle(Lifecycle.State r100) {
        Intrinsics.checkNotNullParameter(r100, "maxState");
        this.maxLifecycle = r100;
        updateState();
    }

    public NavBackStackEntry(NavBackStackEntry r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "entry");
        this(r110.context, r110.destination, r111, r110.hostLifecycleState, r110.viewModelStoreProvider, r110.f15582id, r110.savedState);
        this.hostLifecycleState = r110.hostLifecycleState;
        setMaxLifecycle(r110.maxLifecycle);
    }

    public /* synthetic */ NavBackStackEntry(NavBackStackEntry r100, Bundle r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = r100.arguments;
    L5:
        this(r100, r101);
    }

    private NavBackStackEntry(Context r100, NavDestination r101, Bundle r102, Lifecycle.State r103, NavViewModelStoreProvider r104, String r105, Bundle r106) {
        this.context = r100;
        this.destination = r101;
        this.arguments = r102;
        this.hostLifecycleState = r103;
        this.viewModelStoreProvider = r104;
        this.f15582id = r105;
        this.savedState = r106;
        this.lifecycle = new LifecycleRegistry(this);
        this.savedStateRegistryController = SavedStateRegistryController.create(this);
        this.defaultFactory$delegate = LazyKt.lazy(new NavBackStackEntry$defaultFactory$2(this));
        this.savedStateHandle$delegate = LazyKt.lazy(new NavBackStackEntry$savedStateHandle$2(this));
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
    }

    public /* synthetic */ NavBackStackEntry(Context r110, NavDestination r111, Bundle r112, Lifecycle.State r113, NavViewModelStoreProvider r114, String r115, Bundle r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 4) == 0) goto L5;
        Bundle r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        Lifecycle.State r101 = Lifecycle.State.CREATED;
    L11:
        if ((r117 & 16) == 0) goto L13;
        NavViewModelStoreProvider r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        String r103 = UUID.randomUUID().toString();
    L19:
        if ((r117 & 64) == 0) goto L21;
        Bundle r104 = null;
    L22:
        this(r110, r111, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
