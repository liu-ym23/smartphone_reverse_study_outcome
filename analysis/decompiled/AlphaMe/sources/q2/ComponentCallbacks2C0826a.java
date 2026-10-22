package q2;

import C2.f;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.room.z;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.functor.Functor;
import com.stepos.renderfilter.functor.FunctorImpl;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* renamed from: q2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ComponentCallbacks2C0826a implements ComponentCallbacks2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RenderFilter f13996a;

    public ComponentCallbacks2C0826a(RenderFilter renderFilter) {
        this.f13996a = renderFilter;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i4) {
        if (i4 < 80) {
            boolean zBooleanValue = false;
            try {
                z zVar = f.f346c;
                zVar.getClass();
                zBooleanValue = ((Boolean) zVar.b(ActivityManager.class.getClassLoader(), ActivityManager.class.getName()).a("isHighEndGfx", new Class[0]).f343a.invoke(null, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
            if (i4 < 60 || zBooleanValue) {
                return;
            }
        }
        Iterator it = this.f13996a.f12299b.values().iterator();
        while (it.hasNext()) {
            Functor functor = (Functor) ((WeakReference) it.next()).get();
            if (functor instanceof FunctorImpl) {
                ((FunctorImpl) functor).e();
            }
        }
    }
}
