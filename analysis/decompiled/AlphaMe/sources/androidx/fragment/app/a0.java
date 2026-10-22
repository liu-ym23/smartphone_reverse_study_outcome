package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.t0;
import ch.qos.logback.core.CoreConstants;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a0 extends androidx.lifecycle.n0 {

    /* renamed from: g, reason: collision with root package name */
    public static final y1.f f3707g = new y1.f();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3711d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3708a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3709b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3710c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f3712e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3713f = false;

    public a0(boolean z4) {
        this.f3711d = z4;
    }

    public final void c(D d4) {
        if (this.f3713f) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap map = this.f3708a;
        if (map.containsKey(d4.mWho)) {
            return;
        }
        map.put(d4.mWho, d4);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + d4);
        }
    }

    public final void d(D d4) {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + d4);
        }
        e(d4.mWho);
    }

    public final void e(String str) {
        HashMap map = this.f3709b;
        a0 a0Var = (a0) map.get(str);
        if (a0Var != null) {
            a0Var.onCleared();
            map.remove(str);
        }
        HashMap map2 = this.f3710c;
        t0 t0Var = (t0) map2.get(str);
        if (t0Var != null) {
            t0Var.a();
            map2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f3708a.equals(a0Var.f3708a) && this.f3709b.equals(a0Var.f3709b) && this.f3710c.equals(a0Var.f3710c);
    }

    public final void f(D d4) {
        if (this.f3713f) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f3708a.remove(d4.mWho) == null || !Log.isLoggable("FragmentManager", 2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + d4);
        }
    }

    public final int hashCode() {
        return this.f3710c.hashCode() + ((this.f3709b.hashCode() + (this.f3708a.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.n0
    public final void onCleared() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3712e = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f3708a.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f3709b.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f3710c.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }
}
