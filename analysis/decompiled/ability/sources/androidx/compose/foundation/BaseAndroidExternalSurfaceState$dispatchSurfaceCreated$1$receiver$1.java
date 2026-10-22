package androidx.compose.foundation;

import H7.h;
import S7.k;
import S7.o;
import android.view.Surface;
import kotlin.Metadata;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J4\u0010\b\u001a\u00020\u0007*\u00020\u00042\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000b\u001a\u00020\u0007*\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\nH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1", "Landroidx/compose/foundation/SurfaceCoroutineScope;", "Landroidx/compose/foundation/SurfaceScope;", "Lm9/z;", "Landroid/view/Surface;", "Lkotlin/Function3;", "", "LC7/r;", "onChanged", "(Landroid/view/Surface;LS7/o;)V", "Lkotlin/Function1;", "onDestroyed", "(Landroid/view/Surface;LS7/k;)V", "LH7/h;", "getCoroutineContext", "()LH7/h;", "coroutineContext", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 implements SurfaceCoroutineScope, SurfaceScope, InterfaceC1733z {
    private final /* synthetic */ BaseAndroidExternalSurfaceState $$delegate_0;
    private final /* synthetic */ InterfaceC1733z $$delegate_1;

    public BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1(BaseAndroidExternalSurfaceState baseAndroidExternalSurfaceState, InterfaceC1733z interfaceC1733z) {
        this.$$delegate_0 = baseAndroidExternalSurfaceState;
        this.$$delegate_1 = interfaceC1733z;
    }

    @Override // androidx.compose.foundation.SurfaceCoroutineScope, m9.InterfaceC1733z
    public h getCoroutineContext() {
        return this.$$delegate_1.getCoroutineContext();
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onChanged(Surface surface, o oVar) {
        this.$$delegate_0.onChanged(surface, oVar);
    }

    @Override // androidx.compose.foundation.SurfaceScope
    public void onDestroyed(Surface surface, k kVar) {
        this.$$delegate_0.onDestroyed(surface, kVar);
    }
}
