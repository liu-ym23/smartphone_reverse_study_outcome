package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class y extends k0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ViewModelProvider.Factory f3396k = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f3397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f3398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f3399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3403j;

    public class a implements ViewModelProvider.Factory {
        public a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            return new y(true);
        }
    }

    static {
        f3396k = new a();
    }

    public y(boolean r10) {
        this.f3397d = new HashMap();
        this.f3398e = new HashMap();
        this.f3399f = new HashMap();
        this.f3401h = false;
        this.f3402i = false;
        this.f3403j = false;
        this.f3400g = r10;
    }

    public static y l(ViewModelStore r10) {
        return (y) new ViewModelProvider(r10, f3396k).a(y.class);
    }

    @Override // androidx.lifecycle.k0
    public void d() {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "onCleared called for " + this);
    L5:
        this.f3401h = true;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L19:
        return false;
    L8:
        if (y.class != r10.getClass()) goto L19;
        y r11 = (y) r10;
        if (this.f3397d.equals(r11.f3397d) == false) goto L18;
        if (this.f3398e.equals(r11.f3398e) == false) goto L18;
        if (this.f3399f.equals(r11.f3399f) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public void f(Fragment r10) {
        if (this.f3403j == false) goto L9;
        if (FragmentManager.L0(2) == false) goto L15;
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
        return;
    L15:
        return;
    L9:
        if (this.f3397d.containsKey(r10.mWho) == false) goto L11;
        return;
    L11:
        this.f3397d.put(r10.mWho, r10);
        if (FragmentManager.L0(2) == false) goto L16;
        Log.v("FragmentManager", "Updating retained Fragments: Added " + r10);
        return;
    }

    public void g(Fragment r10, boolean r11) {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "Clearing non-config state for " + r10);
    L5:
        i(r10.mWho, r11);
    }

    public void h(String r10, boolean r11) {
        if (FragmentManager.L0(3) == false) goto L5;
        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + r10);
    L5:
        i(r10, r11);
    }

    public int hashCode() {
        return (((this.f3397d.hashCode() * 31) + this.f3398e.hashCode()) * 31) + this.f3399f.hashCode();
    }

    public final void i(String r10, boolean r11) {
        y r12 = (y) this.f3398e.get(r10);
        if (r12 == null) goto L10;
        if (r11 == false) goto L9;
        ArrayList r13 = new ArrayList();
        r13.addAll(r12.f3398e.keySet());
        Iterator r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r12.h((String) r14.next(), true);
    L9:
        r12.d();
        this.f3398e.remove(r10);
    L10:
        ViewModelStore r15 = (ViewModelStore) this.f3399f.get(r10);
        if (r15 == null) goto L15;
        r15.a();
        this.f3399f.remove(r10);
        return;
    }

    public Fragment j(String r10) {
        return (Fragment) this.f3397d.get(r10);
    }

    public y k(Fragment r10) {
        y r11 = (y) this.f3398e.get(r10.mWho);
        if (r11 != null) goto L6;
        y r12 = new y(this.f3400g);
        this.f3398e.put(r10.mWho, r12);
        return r12;
    L6:
        return r11;
    }

    public Collection m() {
        return new ArrayList(this.f3397d.values());
    }

    public ViewModelStore n(Fragment r10) {
        ViewModelStore r11 = (ViewModelStore) this.f3399f.get(r10.mWho);
        if (r11 != null) goto L6;
        ViewModelStore r12 = new ViewModelStore();
        this.f3399f.put(r10.mWho, r12);
        return r12;
    L6:
        return r11;
    }

    public boolean o() {
        return this.f3401h;
    }

    public void p(Fragment r10) {
        if (this.f3403j == false) goto L9;
        if (FragmentManager.L0(2) == false) goto L14;
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        return;
    L14:
        return;
    L9:
        if (this.f3397d.remove(r10.mWho) != null) goto L11;
        return;
    L11:
        if (FragmentManager.L0(2) == false) goto L16;
        Log.v("FragmentManager", "Updating retained Fragments: Removed " + r10);
        return;
    }

    public void q(boolean r10) {
        this.f3403j = r10;
    }

    public boolean r(Fragment r10) {
        if (this.f3397d.containsKey(r10.mWho) == true) goto L6;
        return true;
    L6:
        if (this.f3400g == false) goto L10;
        return this.f3401h;
    L10:
        return !this.f3402i;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("FragmentManagerViewModel{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("} Fragments (");
        Iterator r11 = this.f3397d.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        r10.append(r11.next());
        if (r11.hasNext() == false) goto L4;
        r10.append(", ");
        goto L4
    L8:
        r10.append(") Child Non Config (");
        Iterator r12 = this.f3398e.keySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        r10.append((String) r12.next());
        if (r12.hasNext() == false) goto L10;
        r10.append(", ");
        goto L10
    L14:
        r10.append(") ViewModelStores (");
        Iterator r13 = this.f3399f.keySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        r10.append((String) r13.next());
        if (r13.hasNext() == false) goto L16;
        r10.append(", ");
        goto L16
    L20:
        r10.append(')');
        return r10.toString();
    }
}
