package android.view.viewmodel.internal;

import H7.h;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "createViewModelScope", "()Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "Lm9/z;", "asCloseable", "(Lm9/z;)Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "", "VIEW_MODEL_SCOPE_KEY", "Ljava/lang/String;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(InterfaceC1733z interfaceC1733z) {
        k.f(interfaceC1733z, "<this>");
        return new CloseableCoroutineScope(interfaceC1733z);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        h hVar;
        try {
            d dVar = AbstractC1691I.f5315a;
            hVar = s9.k.f6003a.d;
        } catch (IllegalStateException unused) {
            hVar = EmptyCoroutineContext.f4908a;
        } catch (NotImplementedError unused2) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        return new CloseableCoroutineScope(hVar.plus(AbstractC1683A.c()));
    }
}
