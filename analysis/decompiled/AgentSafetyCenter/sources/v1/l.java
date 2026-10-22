package v1;

import android.view.ViewTreeObserver;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements ViewTreeObserver.OnTouchModeChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ t f14487c;

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public final void onTouchModeChanged(boolean z10) {
        l1.c cVar = this.f14487c.f14562r0;
        int i = z10 ? 1 : 2;
        k0.k1 k1Var = cVar.f7714a;
        l1.a aVar = new l1.a();
        aVar.f7713a = i;
        VarHandle.storeStoreFence();
        k1Var.setValue(aVar);
    }
}
