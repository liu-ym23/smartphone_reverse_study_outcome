package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class z extends q0 {
    public static final a h = new a();

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2209e;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Fragment> f2206b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, z> f2207c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, s0> f2208d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f2210f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2211g = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements r0.b {
        @Override // androidx.lifecycle.r0.b
        public final <T extends q0> T a(Class<T> cls) {
            return new z(true);
        }
    }

    public z(boolean z) {
        this.f2209e = z;
    }

    @Override // androidx.lifecycle.q0
    public final void b() {
        if (FragmentManager.G(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2210f = true;
    }

    public final void c(Fragment fragment) {
        if (this.f2211g) {
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = fragment.mWho;
        HashMap<String, Fragment> map = this.f2206b;
        if (map.containsKey(str)) {
            return;
        }
        map.put(fragment.mWho, fragment);
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void d(Fragment fragment) {
        if (FragmentManager.G(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        e(fragment.mWho);
    }

    public final void e(String str) {
        HashMap<String, z> map = this.f2207c;
        z zVar = map.get(str);
        if (zVar != null) {
            zVar.b();
            map.remove(str);
        }
        HashMap<String, s0> map2 = this.f2208d;
        s0 s0Var = map2.get(str);
        if (s0Var != null) {
            s0Var.a();
            map2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z.class == obj.getClass()) {
            z zVar = (z) obj;
            if (this.f2206b.equals(zVar.f2206b) && this.f2207c.equals(zVar.f2207c) && this.f2208d.equals(zVar.f2208d)) {
                return true;
            }
        }
        return false;
    }

    public final void f(Fragment fragment) {
        if (this.f2211g) {
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f2206b.remove(fragment.mWho) == null || !FragmentManager.G(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final int hashCode() {
        return this.f2208d.hashCode() + ((this.f2207c.hashCode() + (this.f2206b.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f2206b.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f2207c.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2208d.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
