package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0013\u001a\u00060\u000bj\u0002`\fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "restored", "", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "viewModel", "Landroidx/lifecycle/SavedStateHandlesVM;", "getViewModel", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel$delegate", "Lkotlin/Lazy;", "saveState", "performRestore", "", "consumeRestoredStateForKey", "key", "", "lifecycle-viewmodel-savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    public static /* synthetic */ SavedStateHandlesVM a(ViewModelStoreOwner r100) {
        return viewModel_delegate$lambda$0(r100);
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final void performRestore() {
        if (this.restored == true) goto L20;
        Bundle r100 = this.savedStateRegistry.consumeRestoredStateForKey(SavedStateHandleSupport.SAVED_STATE_KEY);
        Map r101 = MapsKt.emptyMap();
        if (r101.isEmpty() == false) goto L7;
        Pair[] r102 = new Pair[0];
    L12:
        Bundle r103 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r102, r102.length));
        Bundle r104 = SavedStateWriter.m7917constructorimpl(r103);
        Bundle r105 = this.restoredState;
        if (r105 == null) goto L15;
        SavedStateWriter.m7921putAllimpl(r104, r105);
    L15:
        if (r100 == null) goto L17;
        SavedStateWriter.m7921putAllimpl(r104, r100);
    L17:
        this.restoredState = r103;
        this.restored = true;
        getViewModel();
        return;
    L7:
        ArrayList r106 = new ArrayList(r101.size());
        Iterator r107 = r101.entrySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.add(TuplesKt.to((String) r108.getKey(), r108.getValue()));
        goto L9
    L11:
        r102 = (Pair[]) r106.toArray(new Pair[0]);
        goto L12
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle saveState() {
        Map r100 = MapsKt.emptyMap();
        if (r100.isEmpty() == false) goto L5;
        Pair[] r101 = new Pair[0];
    L10:
        Bundle r102 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r101, r101.length));
        Bundle r103 = SavedStateWriter.m7917constructorimpl(r102);
        Bundle r104 = this.restoredState;
        if (r104 == null) goto L13;
        SavedStateWriter.m7921putAllimpl(r103, r104);
    L13:
        Iterator<Map.Entry<String, SavedStateHandle>> r105 = getViewModel().getHandles().entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        Map.Entry<String, SavedStateHandle> r106 = r105.next();
        String r107 = r106.getKey();
        Bundle r108 = r106.getValue().savedStateProvider().saveState();
        if ((!SavedStateReader.m7909isEmptyimpl(SavedStateReader.m7831constructorimpl(r108))) == false) goto L15;
        SavedStateWriter.m7944putSavedStateimpl(r103, r107, r108);
        goto L15
    L19:
        this.restored = false;
        return r102;
    L5:
        ArrayList r109 = new ArrayList(r100.size());
        Iterator r110 = r100.entrySet().iterator();
    L7:
        if (r110.hasNext() == false) goto L9;
        Map.Entry r111 = (Map.Entry) r110.next();
        r109.add(TuplesKt.to((String) r111.getKey(), r111.getValue()));
        goto L7
    L9:
        r101 = (Pair[]) r109.toArray(new Pair[0]);
        goto L10
    }

    private static final SavedStateHandlesVM viewModel_delegate$lambda$0(ViewModelStoreOwner r100) {
        return SavedStateHandleSupport.getSavedStateHandlesVM(r100);
    }

    public final Bundle consumeRestoredStateForKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        performRestore();
        Bundle r101 = this.restoredState;
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((!SavedStateReader.m7832containsimpl(SavedStateReader.m7831constructorimpl(r101), r100)) == false) goto L8;
        return null;
    L8:
        Bundle r102 = SavedStateReader.m7893getSavedStateOrNullimpl(SavedStateReader.m7831constructorimpl(r101), r100);
        if (r102 != null) goto L19;
        Map r103 = MapsKt.emptyMap();
        if (r103.isEmpty() == false) goto L13;
        Pair[] r104 = new Pair[0];
    L18:
        r102 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(r104, r104.length));
        SavedStateWriter.m7917constructorimpl(r102);
        goto L19
    L13:
        ArrayList r105 = new ArrayList(r103.size());
        Iterator r106 = r103.entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.add(TuplesKt.to((String) r107.getKey(), r107.getValue()));
        goto L15
    L17:
        r104 = (Pair[]) r105.toArray(new Pair[0]);
    L19:
        SavedStateWriter.m7953removeimpl(SavedStateWriter.m7917constructorimpl(r101), r100);
        if (SavedStateReader.m7909isEmptyimpl(SavedStateReader.m7831constructorimpl(r101)) == false) goto L22;
        this.restoredState = null;
    L22:
        return r102;
    }

    public SavedStateHandlesProvider(SavedStateRegistry r100, final ViewModelStoreOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(r101, "viewModelStoreOwner");
        this.savedStateRegistry = r100;
        this.viewModel$delegate = LazyKt.lazy(new l(r101));
    }
}
