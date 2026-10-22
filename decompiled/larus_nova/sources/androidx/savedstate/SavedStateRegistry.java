package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0016\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/savedstate/SavedStateRegistry;", "", "impl", "Landroidx/savedstate/internal/SavedStateRegistryImpl;", "<init>", "(Landroidx/savedstate/internal/SavedStateRegistryImpl;)V", "isRestored", "", "()Z", "consumeRestoredStateForKey", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "key", "", "registerSavedStateProvider", "", ShortVideoSegments.KEY_PROP_PROVIDER, "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "getSavedStateProvider", "unregisterSavedStateProvider", "recreatorProvider", "Landroidx/savedstate/Recreator$SavedStateProvider;", "runOnNextRecreation", "clazz", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "SavedStateProvider", "AutoRecreated", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateRegistry {
    private final SavedStateRegistryImpl impl;
    private Recreator.SavedStateProvider recreatorProvider;

    /* JADX INFO: loaded from: classes17.dex */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner r100);
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "saveState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public final boolean isRestored() {
        return this.impl.isRestored();
    }

    public SavedStateRegistry(SavedStateRegistryImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "impl");
        this.impl = r100;
    }

    public final Bundle consumeRestoredStateForKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.impl.consumeRestoredStateForKey(r100);
    }

    public final SavedStateProvider getSavedStateProvider(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.impl.getSavedStateProvider(r100);
    }

    public final void runOnNextRecreation(Class<? extends AutoRecreated> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.impl.isAllowingSavingState$savedstate() == false) goto L17;
        Recreator.SavedStateProvider r101 = this.recreatorProvider;
        if (r101 != null) goto L7;
        r101 = new Recreator.SavedStateProvider(this);
    L7:
        this.recreatorProvider = r101;
        r100.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L13
        Recreator.SavedStateProvider r102 = this.recreatorProvider;
        if (r102 == null) goto L20;
        r102.add(r100.getName());
        return;
    L20:
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Class " + r100.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
    L17:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
    }

    public final void unregisterSavedStateProvider(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.impl.unregisterSavedStateProvider(r100);
    }

    public final void registerSavedStateProvider(String r100, SavedStateProvider r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.impl.registerSavedStateProvider(r100, r101);
    }
}
