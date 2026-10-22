package android.view.internal;

import P3.d;
import S7.a;
import android.os.Bundle;
import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import android.view.SavedStateReader;
import android.view.SavedStateRegistry;
import android.view.SavedStateRegistryOwner;
import android.view.SavedStateWriter;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\u00020\u00052\n\u0010\u001d\u001a\u00060\u000bj\u0002`\fH\u0001¢\u0006\u0004\b\u001e\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010-\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u00020*2\u0006\u0010/\u001a\u00020*8G@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b0\u00101R\"\u00102\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u00101\"\u0004\b4\u00105¨\u00067"}, d2 = {"Landroidx/savedstate/internal/SavedStateRegistryImpl;", "", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "Lkotlin/Function0;", "LC7/r;", "onAttach", AppAgent.CONSTRUCT, "(Landroidx/savedstate/SavedStateRegistryOwner;LS7/a;)V", "", "key", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "consumeRestoredStateForKey", "(Ljava/lang/String;)Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "provider", "registerSavedStateProvider", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "getSavedStateProvider", "(Ljava/lang/String;)Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "unregisterSavedStateProvider", "(Ljava/lang/String;)V", "performAttach", "()V", "savedState", "performRestore$savedstate_release", "(Landroid/os/Bundle;)V", "performRestore", "outBundle", "performSave$savedstate_release", "performSave", "Landroidx/savedstate/SavedStateRegistryOwner;", "LS7/a;", "getOnAttach$savedstate_release", "()LS7/a;", "Landroidx/savedstate/internal/SynchronizedObject;", "lock", "Landroidx/savedstate/internal/SynchronizedObject;", "", "keyToProviders", "Ljava/util/Map;", "", "attached", "Z", "restoredState", "Landroid/os/Bundle;", "value", "isRestored", "()Z", "isAllowingSavingState", "isAllowingSavingState$savedstate_release", "setAllowingSavingState$savedstate_release", "(Z)V", "Companion", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateRegistryImpl {
    private static final Companion Companion = new Companion(null);
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private final Map<String, SavedStateRegistry.SavedStateProvider> keyToProviders;
    private final SynchronizedObject lock;
    private final a onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/savedstate/internal/SavedStateRegistryImpl$Companion;", "", AppAgent.CONSTRUCT, "()V", "SAVED_COMPONENTS_KEY", "", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner owner, a onAttach) {
        k.f(owner, "owner");
        k.f(onAttach, "onAttach");
        this.owner = owner;
        this.onAttach = onAttach;
        this.lock = new SynchronizedObject();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAttach$lambda$12(SavedStateRegistryImpl savedStateRegistryImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        k.f(lifecycleOwner, "<unused var>");
        k.f(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistryImpl.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistryImpl.isAllowingSavingState = false;
        }
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String key) {
        k.f(key, "key");
        if (!this.isRestored) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundleM7177constructorimpl = SavedStateReader.m7177constructorimpl(bundle);
        Bundle bundleM7234getSavedStateimpl = SavedStateReader.m7178containsimpl(bundleM7177constructorimpl, key) ? SavedStateReader.m7234getSavedStateimpl(bundleM7177constructorimpl, key) : null;
        SavedStateWriter.m7299removeimpl(SavedStateWriter.m7263constructorimpl(bundle), key);
        if (SavedStateReader.m7255isEmptyimpl(SavedStateReader.m7177constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return bundleM7234getSavedStateimpl;
    }

    /* renamed from: getOnAttach$savedstate_release, reason: from getter */
    public final a getOnAttach() {
        return this.onAttach;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider(String key) {
        SavedStateRegistry.SavedStateProvider savedStateProvider;
        k.f(key, "key");
        synchronized (this.lock) {
            Iterator it = this.keyToProviders.entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                SavedStateRegistry.SavedStateProvider savedStateProvider2 = (SavedStateRegistry.SavedStateProvider) entry.getValue();
                if (k.b(str, key)) {
                    savedStateProvider = savedStateProvider2;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    /* renamed from: isAllowingSavingState$savedstate_release, reason: from getter */
    public final boolean getIsAllowingSavingState() {
        return this.isAllowingSavingState;
    }

    @MainThread
    /* renamed from: isRestored, reason: from getter */
    public final boolean getIsRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach() {
        if (this.owner.getLifecycle().getState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.onAttach.invoke();
        this.owner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.internal.a
            @Override // android.view.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                SavedStateRegistryImpl.performAttach$lambda$12(this.f2002a, lifecycleOwner, event);
            }
        });
        this.attached = true;
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle savedState) {
        if (!this.attached) {
            performAttach();
        }
        if (this.owner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + this.owner.getLifecycle().getState()).toString());
        }
        if (this.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleM7234getSavedStateimpl = null;
        if (savedState != null) {
            Bundle bundleM7177constructorimpl = SavedStateReader.m7177constructorimpl(savedState);
            if (SavedStateReader.m7178containsimpl(bundleM7177constructorimpl, SAVED_COMPONENTS_KEY)) {
                bundleM7234getSavedStateimpl = SavedStateReader.m7234getSavedStateimpl(bundleM7177constructorimpl, SAVED_COMPONENTS_KEY);
            }
        }
        this.restoredState = bundleM7234getSavedStateimpl;
        this.isRestored = true;
    }

    @MainThread
    public final void performSave$savedstate_release(Bundle outBundle) {
        k.f(outBundle, "outBundle");
        kotlin.collections.a.M();
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundleM7263constructorimpl = SavedStateWriter.m7263constructorimpl(bundleBundleOf);
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m7267putAllimpl(bundleM7263constructorimpl, bundle);
        }
        synchronized (this.lock) {
            for (Map.Entry entry : this.keyToProviders.entrySet()) {
                SavedStateWriter.m7290putSavedStateimpl(bundleM7263constructorimpl, (String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
        }
        if (SavedStateReader.m7255isEmptyimpl(SavedStateReader.m7177constructorimpl(bundleBundleOf))) {
            return;
        }
        SavedStateWriter.m7290putSavedStateimpl(SavedStateWriter.m7263constructorimpl(outBundle), SAVED_COMPONENTS_KEY, bundleBundleOf);
    }

    @MainThread
    public final void registerSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        k.f(key, "key");
        k.f(provider, "provider");
        synchronized (this.lock) {
            if (this.keyToProviders.containsKey(key)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            this.keyToProviders.put(key, provider);
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z10) {
        this.isAllowingSavingState = z10;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String key) {
        k.f(key, "key");
        synchronized (this.lock) {
        }
    }

    public /* synthetic */ SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, a aVar, int i, e eVar) {
        this(savedStateRegistryOwner, (i & 2) != 0 ? new d(22) : aVar);
    }
}
