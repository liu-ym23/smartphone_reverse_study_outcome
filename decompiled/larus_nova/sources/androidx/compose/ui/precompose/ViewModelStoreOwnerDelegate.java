package androidx.compose.ui.precompose;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/precompose/ViewModelStoreOwnerDelegate;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "()V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "bindRealViewModelStore", "", "realViewModelStore", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelStoreOwnerDelegate implements ViewModelStoreOwner {
    public static final int $stable = 8;
    private ViewModelStore _viewModelStore;

    public ViewModelStoreOwnerDelegate() {
        this._viewModelStore = new ViewModelStore();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this._viewModelStore;
    }

    public final void bindRealViewModelStore(ViewModelStore r100) {
        Set<String> r101 = this._viewModelStore.keys();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        String r104 = (String) r103.next();
        ViewModel r105 = this._viewModelStore.get(r104);
        if (r105 == null) goto L8;
        Pair r106 = TuplesKt.to(r104, r105);
    L9:
        if (r106 == null) goto L4;
        r102.add(r106);
        goto L4
    L8:
        r106 = null;
        goto L9
    L11:
        Iterator r107 = r102.iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        Pair r108 = (Pair) r107.next();
        r100.put((String) r108.getFirst(), (ViewModel) r108.getSecond());
        goto L13
    L15:
        this._viewModelStore.clear();
        this._viewModelStore = r100;
    }
}
