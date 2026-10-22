package v1;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 implements ComponentCallbacks2 {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Configuration f14481c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ y1.c f14482f;

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = this.f14481c;
        int iUpdateFrom = configuration2.updateFrom(configuration);
        Iterator it = this.f14482f.f15879a.entrySet().iterator();
        while (it.hasNext()) {
            y1.a aVar = (y1.a) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
            if (aVar == null || Configuration.needNewResources(iUpdateFrom, aVar.f15876b)) {
                it.remove();
            }
        }
        configuration2.setTo(configuration);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f14482f.f15879a.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        this.f14482f.f15879a.clear();
    }
}
