package com.obric.structure.omvvm.core.util;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewModelStoreOwnerDelegate.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/obric/structure/omvvm/core/util/ViewModelStoreOwnerDelegate;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "get_viewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "_viewModelStore$delegate", "Lkotlin/Lazy;", "getViewModelStore", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewModelStoreOwnerDelegate implements ViewModelStoreOwner {
    private final Lazy _viewModelStore$delegate;

    public ViewModelStoreOwnerDelegate() {
        this._viewModelStore$delegate = LazyKt.lazy(ViewModelStoreOwnerDelegate$_viewModelStore$2.INSTANCE);
    }

    private final ViewModelStore get_viewModelStore() {
        return (ViewModelStore) this._viewModelStore$delegate.getValue();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return get_viewModelStore();
    }
}
