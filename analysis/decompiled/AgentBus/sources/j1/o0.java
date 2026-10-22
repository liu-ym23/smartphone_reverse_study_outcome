package j1;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class o0 implements ComponentCallbacks2 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Configuration f5289f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n1.a f5290g;

    public o0(Configuration configuration, n1.a aVar) {
        this.f5289f = configuration;
        this.f5290g = aVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = this.f5289f;
        configuration2.updateFrom(configuration);
        Iterator it = this.f5290g.f6811a.entrySet().iterator();
        while (it.hasNext()) {
            if (((WeakReference) ((Map.Entry) it.next()).getValue()).get() != null) {
                throw new ClassCastException();
            }
            it.remove();
        }
        configuration2.setTo(configuration);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f5290g.f6811a.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        this.f5290g.f6811a.clear();
    }
}
