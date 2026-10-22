package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScopeKt;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "VIEW_MODEL_SCOPE_LOCK", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "lifecycle-viewmodel"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewModelKt {
    private static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK = null;

    static {
        VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();
    }

    public static final CoroutineScope getViewModelScope(ViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SynchronizedObject r101 = VIEW_MODEL_SCOPE_LOCK;
        monitor-enter(r101);
        CloseableCoroutineScope r102 = (CloseableCoroutineScope) r100.getCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = CloseableCoroutineScopeKt.createViewModelScope();     // Catch: Throwable -> L9
        r100.addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }
}
