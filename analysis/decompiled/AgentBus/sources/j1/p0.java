package j1;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class p0 implements ComponentCallbacks2 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n1.b f5295f;

    public p0(n1.b bVar) {
        this.f5295f = bVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        n1.b bVar = this.f5295f;
        synchronized (bVar) {
            bVar.f6812a.c();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        n1.b bVar = this.f5295f;
        synchronized (bVar) {
            bVar.f6812a.c();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        n1.b bVar = this.f5295f;
        synchronized (bVar) {
            bVar.f6812a.c();
        }
    }
}
