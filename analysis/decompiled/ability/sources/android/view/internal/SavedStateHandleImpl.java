package android.view.internal;

import D7.N;
import android.os.Bundle;
import android.view.SavedStateRegistry;
import android.view.SavedStateWriter;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.i;
import p9.e;
import p9.j;
import p9.l;
import p9.t;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\n\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001d\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001f\u0010\u001aJ\u001f\u0010!\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0007H\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b#\u0010$R%\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'R(\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'R+\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130%8\u0006¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b/\u0010\t¨\u00060"}, d2 = {"Landroidx/lifecycle/internal/SavedStateHandleImpl;", "", "", "", "initialState", AppAgent.CONSTRUCT, "(Ljava/util/Map;)V", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProvider", "()Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "key", "", "contains", "(Ljava/lang/String;)Z", ExifInterface.GPS_DIRECTION_TRUE, "initialValue", "Lp9/t;", "getStateFlow", "(Ljava/lang/String;Ljava/lang/Object;)Lp9/t;", "Lp9/j;", "getMutableStateFlow", "(Ljava/lang/String;Ljava/lang/Object;)Lp9/j;", "", "keys", "()Ljava/util/Set;", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "LC7/r;", "set", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "provider", "setSavedStateProvider", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "clearSavedStateProvider", "(Ljava/lang/String;)V", "", "regular", "Ljava/util/Map;", "getRegular", "()Ljava/util/Map;", "providers", "flows", "mutableFlows", "getMutableFlows", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "getSavedStateProvider", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateHandleImpl {
    private final Map<String, j> flows;
    private final Map<String, j> mutableFlows;
    private final Map<String, SavedStateRegistry.SavedStateProvider> providers;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateHandleImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandleImpl savedStateHandleImpl) {
        Pair[] pairArr;
        for (Map.Entry entry : a.Y(savedStateHandleImpl.mutableFlows).entrySet()) {
            savedStateHandleImpl.set((String) entry.getKey(), ((i) ((j) entry.getValue())).getValue());
        }
        for (Map.Entry entry2 : a.Y(savedStateHandleImpl.providers).entrySet()) {
            savedStateHandleImpl.set((String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState());
        }
        Map<String, Object> map = savedStateHandleImpl.regular;
        if (map.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, Object> entry3 : map.entrySet()) {
                arrayList.add(new Pair(entry3.getKey(), entry3.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m7263constructorimpl(bundleBundleOf);
        return bundleBundleOf;
    }

    @MainThread
    public final void clearSavedStateProvider(String key) {
        k.f(key, "key");
        this.providers.remove(key);
    }

    @MainThread
    public final boolean contains(String key) {
        k.f(key, "key");
        return this.regular.containsKey(key);
    }

    @MainThread
    public final <T> T get(String key) {
        T t9;
        k.f(key, "key");
        try {
            j jVar = this.mutableFlows.get(key);
            if (jVar != null && (t9 = (T) ((i) jVar).getValue()) != null) {
                return t9;
            }
            return (T) this.regular.get(key);
        } catch (ClassCastException unused) {
            this.remove(key);
            return null;
        }
    }

    public final Map<String, j> getMutableFlows() {
        return this.mutableFlows;
    }

    @MainThread
    public final <T> j getMutableStateFlow(String key, T initialValue) {
        k.f(key, "key");
        Map<String, j> map = this.mutableFlows;
        j jVarC = map.get(key);
        if (jVarC == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, initialValue);
            }
            jVarC = e.c(this.regular.get(key));
            map.put(key, jVarC);
        }
        return jVarC;
    }

    public final Map<String, Object> getRegular() {
        return this.regular;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> t getStateFlow(String key, T initialValue) {
        k.f(key, "key");
        Map<String, j> map = this.flows;
        j jVarC = map.get(key);
        if (jVarC == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, initialValue);
            }
            jVarC = e.c(this.regular.get(key));
            map.put(key, jVarC);
        }
        return new l(jVarC);
    }

    @MainThread
    public final Set<String> keys() {
        return N.L(this.regular.keySet(), this.providers.keySet());
    }

    @MainThread
    public final <T> T remove(String key) {
        k.f(key, "key");
        T t9 = (T) this.regular.remove(key);
        this.flows.remove(key);
        this.mutableFlows.remove(key);
        return t9;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String key, T value) {
        k.f(key, "key");
        this.regular.put(key, value);
        j jVar = this.flows.get(key);
        if (jVar != null) {
            ((i) jVar).i(value);
        }
        j jVar2 = this.mutableFlows.get(key);
        if (jVar2 != null) {
            ((i) jVar2).i(value);
        }
    }

    @MainThread
    public final void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        k.f(key, "key");
        k.f(provider, "provider");
        this.providers.put(key, provider);
    }

    public SavedStateHandleImpl(Map<String, ? extends Object> initialState) {
        k.f(initialState, "initialState");
        this.regular = a.a0(initialState);
        this.providers = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.mutableFlows = new LinkedHashMap();
        this.savedStateProvider = new androidx.fragment.app.e(this, 2);
    }

    public /* synthetic */ SavedStateHandleImpl(Map map, int i, kotlin.jvm.internal.e eVar) {
        this((i & 1) != 0 ? a.M() : map);
    }
}
