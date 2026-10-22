package androidx.compose.runtime.saveable;

import android.os.Bundle;
import android.view.LifecycleRegistry;
import android.view.SavedStateReader;
import android.view.SavedStateRegistry;
import android.view.SavedStateRegistryController;
import android.view.SavedStateRegistryOwner;
import android.view.SavedStateWriter;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.core.os.BundleKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00150\u0014H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001a\u0010%\u001a\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryWrapper;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/savedstate/SavedStateRegistryOwner;", "base", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "", "key", "", "consumeRestored", "(Ljava/lang/String;)Ljava/lang/Object;", "Lkotlin/Function0;", "valueProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "registerProvider", "(Ljava/lang/String;LS7/a;)Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "value", "", "canBeSaved", "(Ljava/lang/Object;)Z", "", "", "performSave", "()Ljava/util/Map;", "Landroidx/savedstate/SavedStateRegistryController;", "controller", "Landroidx/savedstate/SavedStateRegistryController;", "getController", "()Landroidx/savedstate/SavedStateRegistryController;", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle$annotations", "()V", "Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "runtime-saveable"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SaveableStateRegistryWrapper implements SaveableStateRegistry, SavedStateRegistryOwner {
    public static final int $stable = 8;
    private final /* synthetic */ SaveableStateRegistry $$delegate_0;
    private final SavedStateRegistryController controller;
    private final LifecycleRegistry lifecycle;
    private final SavedStateRegistry savedStateRegistry;

    public SaveableStateRegistryWrapper(SaveableStateRegistry saveableStateRegistry) {
        this.$$delegate_0 = saveableStateRegistry;
        SavedStateRegistryController savedStateRegistryControllerCreate = SavedStateRegistryController.INSTANCE.create(this);
        this.controller = savedStateRegistryControllerCreate;
        this.lifecycle = LifecycleRegistry.INSTANCE.createUnsafe(this);
        this.savedStateRegistry = savedStateRegistryControllerCreate.getSavedStateRegistry();
        Object objConsumeRestored = consumeRestored("androidx.savedstate.SavedStateRegistry");
        savedStateRegistryControllerCreate.performRestore(objConsumeRestored instanceof Bundle ? (Bundle) objConsumeRestored : null);
        registerProvider("androidx.savedstate.SavedStateRegistry", new c(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$1(SaveableStateRegistryWrapper saveableStateRegistryWrapper) {
        kotlin.collections.a.M();
        Pair[] pairArr = new Pair[0];
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7263constructorimpl(bundleBundleOf);
        saveableStateRegistryWrapper.controller.performSave(bundleBundleOf);
        if (SavedStateReader.m7255isEmptyimpl(SavedStateReader.m7177constructorimpl(bundleBundleOf))) {
            return null;
        }
        return bundleBundleOf;
    }

    public static /* synthetic */ void getLifecycle$annotations() {
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object value) {
        return this.$$delegate_0.canBeSaved(value);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String key) {
        return this.$$delegate_0.consumeRestored(key);
    }

    public final SavedStateRegistryController getController() {
        return this.controller;
    }

    @Override // android.view.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(String key, S7.a valueProvider) {
        return this.$$delegate_0.registerProvider(key, valueProvider);
    }

    @Override // android.view.LifecycleOwner
    public LifecycleRegistry getLifecycle() {
        return this.lifecycle;
    }
}
