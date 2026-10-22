package v1;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 implements ComponentCallbacks2 {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ y1.d f14485c;

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        y1.d dVar = this.f14485c;
        synchronized (dVar) {
            dVar.f15880a.c();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        y1.d dVar = this.f14485c;
        synchronized (dVar) {
            dVar.f15880a.c();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        y1.d dVar = this.f14485c;
        synchronized (dVar) {
            dVar.f15880a.c();
        }
    }
}
