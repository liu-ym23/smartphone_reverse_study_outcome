package androidx.fragment.app;

import android.util.Log;
import android.view.U;
import android.view.V;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class G extends android.view.Q {

    /* renamed from: h, reason: collision with root package name */
    public static final U.c f13973h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13977d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, Fragment> f13974a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, G> f13975b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, V> f13976c = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13978e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13979f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13980g = false;

    public class a implements U.c {
        @Override // androidx.lifecycle.U.c
        public <T extends android.view.Q> T c(Class<T> cls) {
            return new G(true);
        }
    }

    public G(boolean z10) {
        this.f13977d = z10;
    }

    public static G k(V v10) {
        return (G) new U(v10, f13973h).a(G.class);
    }

    @Override // android.view.Q
    public void d() {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f13978e = true;
    }

    public void e(Fragment fragment) {
        if (this.f13980g) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f13974a.containsKey(fragment.mWho)) {
                return;
            }
            this.f13974a.put(fragment.mWho, fragment);
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && G.class == obj.getClass()) {
            G g10 = (G) obj;
            if (this.f13974a.equals(g10.f13974a) && this.f13975b.equals(g10.f13975b) && this.f13976c.equals(g10.f13976c)) {
                return true;
            }
        }
        return false;
    }

    public void f(Fragment fragment, boolean z10) {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        h(fragment.mWho, z10);
    }

    public void g(String str, boolean z10) {
        if (FragmentManager.N0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        h(str, z10);
    }

    public final void h(String str, boolean z10) {
        G g10 = this.f13975b.get(str);
        if (g10 != null) {
            if (z10) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(g10.f13975b.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g10.g((String) it.next(), true);
                }
            }
            g10.d();
            this.f13975b.remove(str);
        }
        V v10 = this.f13976c.get(str);
        if (v10 != null) {
            v10.a();
            this.f13976c.remove(str);
        }
    }

    public int hashCode() {
        return (((this.f13974a.hashCode() * 31) + this.f13975b.hashCode()) * 31) + this.f13976c.hashCode();
    }

    public Fragment i(String str) {
        return this.f13974a.get(str);
    }

    public G j(Fragment fragment) {
        G g10 = this.f13975b.get(fragment.mWho);
        if (g10 != null) {
            return g10;
        }
        G g11 = new G(this.f13977d);
        this.f13975b.put(fragment.mWho, g11);
        return g11;
    }

    public Collection<Fragment> l() {
        return new ArrayList(this.f13974a.values());
    }

    public V m(Fragment fragment) {
        V v10 = this.f13976c.get(fragment.mWho);
        if (v10 != null) {
            return v10;
        }
        V v11 = new V();
        this.f13976c.put(fragment.mWho, v11);
        return v11;
    }

    public boolean n() {
        return this.f13978e;
    }

    public void o(Fragment fragment) {
        if (this.f13980g) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f13974a.remove(fragment.mWho) == null || !FragmentManager.N0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public void p(boolean z10) {
        this.f13980g = z10;
    }

    public boolean q(Fragment fragment) {
        if (this.f13974a.containsKey(fragment.mWho)) {
            return this.f13977d ? this.f13978e : !this.f13979f;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f13974a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f13975b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f13976c.keySet().iterator();
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
