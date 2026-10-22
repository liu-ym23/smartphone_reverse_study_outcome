package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/navigation/NavViewModelStoreProvider;", "()V", "viewModelStores", "", "", "Landroidx/lifecycle/ViewModelStore;", "clear", "", "backStackEntryId", "getViewModelStore", "onCleared", "toString", "Companion", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {
    public static final Companion Companion = null;
    private static final ViewModelProvider.Factory FACTORY = null;
    private final Map<String, ViewModelStore> viewModelStores;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/navigation/NavControllerViewModel$Companion;", "", "()V", "FACTORY", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getInstance", "Landroidx/navigation/NavControllerViewModel;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final NavControllerViewModel getInstance(ViewModelStore r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModelStore");
            return (NavControllerViewModel) new ViewModelProvider(r100, NavControllerViewModel.access$getFACTORY$cp()).get(NavControllerViewModel.class);
        }
    }

    @JvmStatic
    public static final NavControllerViewModel getInstance(ViewModelStore r100) {
        return Companion.getInstance(r100);
    }

    static {
        Companion = new Companion(null);
        FACTORY = new NavControllerViewModel$Companion$FACTORY$1();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Iterator<ViewModelStore> r100 = this.viewModelStores.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().clear();
        goto L4
    L6:
        this.viewModelStores.clear();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("NavControllerViewModel{");
        r100.append(Integer.toHexString(System.identityHashCode(this)));
        r100.append("} ViewModelStores (");
        Iterator<String> r101 = this.viewModelStores.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        r100.append(r101.next());
        if (r101.hasNext() == false) goto L4;
        r100.append(", ");
        goto L4
    L8:
        r100.append(')');
        return r100.toString();
    }

    public NavControllerViewModel() {
        this.viewModelStores = new LinkedHashMap();
    }

    public static final /* synthetic */ ViewModelProvider.Factory access$getFACTORY$cp() {
        return FACTORY;
    }

    public final void clear(String r100) {
        Intrinsics.checkNotNullParameter(r100, "backStackEntryId");
        ViewModelStore r101 = this.viewModelStores.remove(r100);
        if (r101 == null) goto L7;
        r101.clear();
        return;
    }

    @Override // androidx.navigation.NavViewModelStoreProvider
    public ViewModelStore getViewModelStore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "backStackEntryId");
        ViewModelStore r101 = this.viewModelStores.get(r100);
        if (r101 != null) goto L6;
        ViewModelStore r102 = new ViewModelStore();
        this.viewModelStores.put(r100, r102);
        return r102;
    L6:
        return r101;
    }
}
