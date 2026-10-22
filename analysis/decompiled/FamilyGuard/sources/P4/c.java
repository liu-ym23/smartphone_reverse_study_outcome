package P4;

import android.app.Fragment;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class c extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final Set<d> f4855a = Collections.newSetFromMap(new WeakHashMap());

    public void a(d dVar) {
        this.f4855a.add(dVar);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        for (d dVar : this.f4855a) {
            if (dVar != null) {
                dVar.onResume();
            }
        }
    }
}
