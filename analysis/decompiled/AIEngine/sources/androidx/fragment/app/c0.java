package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f2090a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, b0> f2091b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, FragmentState> f2092c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public z f2093d;

    public final void a(Fragment fragment) {
        if (this.f2090a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f2090a) {
            this.f2090a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final Fragment b(String str) {
        b0 b0Var = this.f2091b.get(str);
        if (b0Var != null) {
            return b0Var.f2081c;
        }
        return null;
    }

    public final Fragment c(String str) {
        Fragment fragmentFindFragmentByWho;
        for (b0 b0Var : this.f2091b.values()) {
            if (b0Var != null && (fragmentFindFragmentByWho = b0Var.f2081c.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : this.f2091b.values()) {
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : this.f2091b.values()) {
            if (b0Var != null) {
                arrayList.add(b0Var.f2081c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List<Fragment> f() {
        ArrayList arrayList;
        if (this.f2090a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f2090a) {
            arrayList = new ArrayList(this.f2090a);
        }
        return arrayList;
    }

    public final void g(b0 b0Var) {
        Fragment fragment = b0Var.f2081c;
        String str = fragment.mWho;
        HashMap<String, b0> map = this.f2091b;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, b0Var);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.f2093d.c(fragment);
            } else {
                this.f2093d.f(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public final void h(b0 b0Var) {
        Fragment fragment = b0Var.f2081c;
        if (fragment.mRetainInstance) {
            this.f2093d.f(fragment);
        }
        if (this.f2091b.put(fragment.mWho, null) != null && FragmentManager.G(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public final FragmentState i(String str, FragmentState fragmentState) {
        HashMap<String, FragmentState> map = this.f2092c;
        return fragmentState != null ? map.put(str, fragmentState) : map.remove(str);
    }
}
