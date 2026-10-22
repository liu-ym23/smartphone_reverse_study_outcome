package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class A extends T {

    /* renamed from: i, reason: collision with root package name */
    private static final U.c f10385i = new a();

    /* renamed from: e, reason: collision with root package name */
    private final boolean f10389e;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, ComponentCallbacksC0511f> f10386b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, A> f10387c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, W> f10388d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f10390f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10391g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10392h = false;

    class a implements U.c {
        a() {
        }

        @Override // androidx.lifecycle.U.c
        public <T extends T> T a(Class<T> cls) {
            return new A(true);
        }
    }

    A(boolean z5) {
        this.f10389e = z5;
    }

    private void N(String str) {
        A a6 = this.f10387c.get(str);
        if (a6 != null) {
            a6.J();
            this.f10387c.remove(str);
        }
        W w5 = this.f10388d.get(str);
        if (w5 != null) {
            w5.a();
            this.f10388d.remove(str);
        }
    }

    static A Q(W w5) {
        return (A) new U(w5, f10385i).a(A.class);
    }

    @Override // androidx.lifecycle.T
    protected void J() {
        if (x.F0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f10390f = true;
    }

    void K(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (this.f10392h) {
            if (x.F0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f10386b.containsKey(componentCallbacksC0511f.f10637f)) {
                return;
            }
            this.f10386b.put(componentCallbacksC0511f.f10637f, componentCallbacksC0511f);
            if (x.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + componentCallbacksC0511f);
            }
        }
    }

    void L(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (x.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + componentCallbacksC0511f);
        }
        N(componentCallbacksC0511f.f10637f);
    }

    void M(String str) {
        if (x.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        N(str);
    }

    ComponentCallbacksC0511f O(String str) {
        return this.f10386b.get(str);
    }

    A P(ComponentCallbacksC0511f componentCallbacksC0511f) {
        A a6 = this.f10387c.get(componentCallbacksC0511f.f10637f);
        if (a6 != null) {
            return a6;
        }
        A a7 = new A(this.f10389e);
        this.f10387c.put(componentCallbacksC0511f.f10637f, a7);
        return a7;
    }

    Collection<ComponentCallbacksC0511f> R() {
        return new ArrayList(this.f10386b.values());
    }

    W S(ComponentCallbacksC0511f componentCallbacksC0511f) {
        W w5 = this.f10388d.get(componentCallbacksC0511f.f10637f);
        if (w5 != null) {
            return w5;
        }
        W w6 = new W();
        this.f10388d.put(componentCallbacksC0511f.f10637f, w6);
        return w6;
    }

    boolean T() {
        return this.f10390f;
    }

    void U(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (this.f10392h) {
            if (x.F0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f10386b.remove(componentCallbacksC0511f.f10637f) == null || !x.F0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + componentCallbacksC0511f);
        }
    }

    void V(boolean z5) {
        this.f10392h = z5;
    }

    boolean W(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (this.f10386b.containsKey(componentCallbacksC0511f.f10637f)) {
            return this.f10389e ? this.f10390f : !this.f10391g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && A.class == obj.getClass()) {
            A a6 = (A) obj;
            if (this.f10386b.equals(a6.f10386b) && this.f10387c.equals(a6.f10387c) && this.f10388d.equals(a6.f10388d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f10386b.hashCode() * 31) + this.f10387c.hashCode()) * 31) + this.f10388d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<ComponentCallbacksC0511f> it = this.f10386b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f10387c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f10388d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
