package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"androidx/lifecycle/viewmodel/compose/ViewModelKt__ViewModelKt", "androidx/lifecycle/viewmodel/compose/ViewModelKt__ViewModel_androidKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class ViewModelKt {
    public static final <VM extends ViewModel> VM get(ViewModelStoreOwner r100, KClass<VM> r101, String r102, ViewModelProvider.Factory r103, CreationExtras r104) {
        return (VM) ViewModelKt__ViewModelKt.get(r100, r101, r102, r103, r104);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModel that takes CreationExtras")
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner r100, String r101, ViewModelProvider.Factory r102, Composer r103, int r104, int r105) {
        return (VM) ViewModelKt__ViewModel_androidKt.viewModel(r100, r101, r102, r103, r104, r105);
    }

    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner r100, String r101, Function1<? super CreationExtras, ? extends VM> r102, Composer r103, int r104, int r105) {
        return (VM) ViewModelKt__ViewModelKt.viewModel(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ ViewModel get$default(ViewModelStoreOwner r100, KClass r101, String r102, ViewModelProvider.Factory r103, CreationExtras r104, int r105, Object r106) {
        return ViewModelKt__ViewModelKt.get$default(r100, r101, r102, r103, r104, r105, r106);
    }

    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner r100, String r101, ViewModelProvider.Factory r102, CreationExtras r103, Composer r104, int r105, int r106) {
        return (VM) ViewModelKt__ViewModelKt.viewModel(r100, r101, r102, r103, r104, r105, r106);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModel that takes CreationExtras")
    public static final /* synthetic */ ViewModel viewModel(Class r100, ViewModelStoreOwner r101, String r102, ViewModelProvider.Factory r103, Composer r104, int r105, int r106) {
        return ViewModelKt__ViewModel_androidKt.viewModel(r100, r101, r102, r103, r104, r105, r106);
    }

    public static final <VM extends ViewModel> VM viewModel(Class<VM> r100, ViewModelStoreOwner r101, String r102, ViewModelProvider.Factory r103, CreationExtras r104, Composer r105, int r106, int r107) {
        return (VM) ViewModelKt__ViewModel_androidKt.viewModel(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static final <VM extends ViewModel> VM viewModel(KClass<VM> r100, ViewModelStoreOwner r101, String r102, ViewModelProvider.Factory r103, CreationExtras r104, Composer r105, int r106, int r107) {
        return (VM) ViewModelKt__ViewModelKt.viewModel(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
