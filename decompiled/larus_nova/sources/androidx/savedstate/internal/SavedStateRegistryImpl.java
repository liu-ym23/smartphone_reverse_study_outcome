package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u001e\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00152\u0006\u0010\u001f\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0010H\u0007J\u0010\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020\u000fJ\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000fH\u0007J\b\u0010%\u001a\u00020\u0006H\u0007J\u001f\u0010&\u001a\u00020\u00062\u000e\u0010'\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0001¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00062\n\u0010+\u001a\u00060\u0014j\u0002`\u0015H\u0001¢\u0006\u0004\b,\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00128G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Landroidx/savedstate/internal/SavedStateRegistryImpl;", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "onAttach", "Lkotlin/Function0;", "", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;Lkotlin/jvm/functions/Function0;)V", "getOnAttach$savedstate", "()Lkotlin/jvm/functions/Function0;", "lock", "Landroidx/savedstate/internal/SynchronizedObject;", "keyToProviders", "", "", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "attached", "", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "Landroid/os/Bundle;", "value", "isRestored", "()Z", "isAllowingSavingState", "isAllowingSavingState$savedstate", "setAllowingSavingState$savedstate", "(Z)V", "consumeRestoredStateForKey", "key", "(Ljava/lang/String;)Landroid/os/Bundle;", "registerSavedStateProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "getSavedStateProvider", "unregisterSavedStateProvider", "performAttach", "performRestore", "savedState", "performRestore$savedstate", "(Landroid/os/Bundle;)V", "performSave", "outBundle", "performSave$savedstate", "Companion", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateRegistryImpl {
    private static final Companion Companion = null;
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private final Map<String, SavedStateRegistry.SavedStateProvider> keyToProviders;
    private final SynchronizedObject lock;
    private final Function0<Unit> onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/savedstate/internal/SavedStateRegistryImpl$Companion;", "", "<init>", "()V", "SAVED_COMPONENTS_KEY", "", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ void b(SavedStateRegistryImpl r100, LifecycleOwner r101, Lifecycle.Event r102) {
        performAttach$lambda$12(r100, r101, r102);
    }

    public final void performAttach() {
        if (this.owner.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L14;
        if ((!this.attached) == false) goto L12;
        this.onAttach.invoke();
        this.owner.getLifecycle().addObserver(new b(this));
        this.attached = true;
        return;
    L12:
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    L14:
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    L5:
        r100 = false;
        goto L6
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public final Function0<Unit> getOnAttach$savedstate() {
        return this.onAttach;
    }

    public final boolean isAllowingSavingState$savedstate() {
        return this.isAllowingSavingState;
    }

    public final boolean isRestored() {
        return this.isRestored;
    }

    public static final /* synthetic */ Map access$getKeyToProviders$p(SavedStateRegistryImpl r100) {
        return r100.keyToProviders;
    }

    public final Bundle consumeRestoredStateForKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.isRestored == false) goto L16;
        Bundle r101 = this.restoredState;
        if (r101 != null) goto L7;
        return null;
    L7:
        Bundle r102 = SavedStateReader.m7831constructorimpl(r101);
        if (SavedStateReader.m7832containsimpl(r102, r100) == false) goto L10;
        Bundle r103 = SavedStateReader.m7888getSavedStateimpl(r102, r100);
    L11:
        SavedStateWriter.m7953removeimpl(SavedStateWriter.m7917constructorimpl(r101), r100);
        if (SavedStateReader.m7909isEmptyimpl(SavedStateReader.m7831constructorimpl(r101)) == false) goto L14;
        this.restoredState = null;
    L14:
        return r103;
    L10:
        r103 = null;
        goto L11
    L16:
        throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state".toString());
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SynchronizedObject r101 = this.lock;
        monitor-enter(r101);
        Iterator r102 = access$getKeyToProviders$p(this).entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        SavedStateRegistry.SavedStateProvider r103 = null;
        if (r102.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r102.next();     // Catch: Throwable -> L13
        String r105 = (String) r104.getKey();     // Catch: Throwable -> L13
        SavedStateRegistry.SavedStateProvider r106 = (SavedStateRegistry.SavedStateProvider) r104.getValue();     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r105, r100) == false) goto L10;
        r103 = r106;
    L10:
        if (r103 == null) goto L5;
    L11:
        monitor-exit(r101);
        return r103;
    L13:
        th = move-exception;
        throw th;
    }

    public final void performRestore$savedstate(Bundle r100) {
        if (this.attached == true) goto L6;
        performAttach();
    L6:
        if ((!this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) == false) goto L19;
        if ((!this.isRestored) == false) goto L17;
        Bundle r101 = null;
        if (r100 == null) goto L14;
        Bundle r102 = SavedStateReader.m7831constructorimpl(r100);
        if (SavedStateReader.m7832containsimpl(r102, SAVED_COMPONENTS_KEY) == false) goto L14;
        r101 = SavedStateReader.m7888getSavedStateimpl(r102, SAVED_COMPONENTS_KEY);
    L14:
        this.restoredState = r101;
        this.isRestored = true;
        return;
    L17:
        throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
    L19:
        throw new IllegalStateException(("performRestore cannot be called when owner is " + this.owner.getLifecycle().getCurrentState()).toString());
    }

    public final void performSave$savedstate(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outBundle");
        Map r101 = MapsKt.emptyMap();
        if (r101.isEmpty() == false) goto L5;
        Pair[] r102 = new Pair[0];
    L10:
        Bundle r103 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r102, r102.length));
        Bundle r104 = SavedStateWriter.m7917constructorimpl(r103);
        Bundle r105 = this.restoredState;
        if (r105 == null) goto L13;
        SavedStateWriter.m7921putAllimpl(r104, r105);
    L13:
        SynchronizedObject r106 = this.lock;
        monitor-enter(r106);
        Iterator r107 = access$getKeyToProviders$p(this).entrySet().iterator();     // Catch: Throwable -> L25
    L17:
        if (r107.hasNext() == false) goto L19;
        Map.Entry r108 = (Map.Entry) r107.next();     // Catch: Throwable -> L25
        SavedStateWriter.m7944putSavedStateimpl(r104, (String) r108.getKey(), ((SavedStateRegistry.SavedStateProvider) r108.getValue()).saveState());     // Catch: Throwable -> L25
        goto L17
    L19:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r106);
        if ((!SavedStateReader.m7909isEmptyimpl(SavedStateReader.m7831constructorimpl(r103))) == false) goto L32;
        SavedStateWriter.m7944putSavedStateimpl(SavedStateWriter.m7917constructorimpl(r100), SAVED_COMPONENTS_KEY, r103);
        return;
    L32:
        return;
    L25:
        th = move-exception;
        throw th;
    L5:
        ArrayList r110 = new ArrayList(r101.size());
        Iterator r111 = r101.entrySet().iterator();
    L7:
        if (r111.hasNext() == false) goto L9;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.add(TuplesKt.to((String) r112.getKey(), r112.getValue()));
        goto L7
    L9:
        r102 = (Pair[]) r110.toArray(new Pair[0]);
        goto L10
    }

    public final void setAllowingSavingState$savedstate(boolean r100) {
        this.isAllowingSavingState = r100;
    }

    public final void unregisterSavedStateProvider(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SynchronizedObject r101 = this.lock;
        monitor-enter(r101);
        SavedStateRegistry.SavedStateProvider r102 = (SavedStateRegistry.SavedStateProvider) access$getKeyToProviders$p(this).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "onAttach");
        this.owner = r100;
        this.onAttach = r101;
        this.lock = new SynchronizedObject();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    public final void registerSavedStateProvider(String r100, SavedStateRegistry.SavedStateProvider r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        SynchronizedObject r102 = this.lock;
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((!access$getKeyToProviders$p(this).containsKey(r100)) == false) goto L10;
        access$getKeyToProviders$p(this).put(r100, r101);     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L10:
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());     // Catch: Throwable -> L11
    }

    private static final void performAttach$lambda$12(SavedStateRegistryImpl r100, LifecycleOwner r101, Lifecycle.Event r102) {
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r102 != Lifecycle.Event.ON_START) goto L6;
        r100.isAllowingSavingState = true;
        return;
    L6:
        if (r102 != Lifecycle.Event.ON_STOP) goto L10;
        r100.isAllowingSavingState = false;
        return;
    }

    public /* synthetic */ SavedStateRegistryImpl(SavedStateRegistryOwner r100, Function0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = new a();
    L5:
        this(r100, r101);
    }
}
