package android.view;

import android.view.viewmodel.internal.CloseableCoroutineScope;
import android.view.viewmodel.internal.CloseableCoroutineScopeKt;
import android.view.viewmodel.internal.SynchronizedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "VIEW_MODEL_SCOPE_LOCK", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "Landroidx/lifecycle/ViewModel;", "Lm9/z;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lm9/z;", "viewModelScope", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewModelKt {
    private static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();

    public static final InterfaceC1733z getViewModelScope(ViewModel viewModel) {
        CloseableCoroutineScope closeableCoroutineScopeCreateViewModelScope;
        k.f(viewModel, "<this>");
        synchronized (VIEW_MODEL_SCOPE_LOCK) {
            closeableCoroutineScopeCreateViewModelScope = (CloseableCoroutineScope) viewModel.getCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY);
            if (closeableCoroutineScopeCreateViewModelScope == null) {
                closeableCoroutineScopeCreateViewModelScope = CloseableCoroutineScopeKt.createViewModelScope();
                viewModel.addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, closeableCoroutineScopeCreateViewModelScope);
            }
        }
        return closeableCoroutineScopeCreateViewModelScope;
    }
}
