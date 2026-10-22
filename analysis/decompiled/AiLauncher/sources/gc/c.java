package gc;

import android.app.Fragment;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public class c extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final Set f32877a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Object f32878b = new Object();

    public void a(d dVar) {
        synchronized (this.f32878b) {
            this.f32877a.add(dVar);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        synchronized (this.f32878b) {
            try {
                for (d dVar : this.f32877a) {
                    if (dVar != null) {
                        dVar.onResume();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
