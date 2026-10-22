package u0;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import b0.x0;

/* loaded from: classes.dex */
public final class c implements ComponentCallbacks2 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x0 f9893f;

    public c(x0 x0Var) {
        this.f9893f = x0Var;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 >= 40) {
            this.f9893f.getClass();
        }
    }
}
