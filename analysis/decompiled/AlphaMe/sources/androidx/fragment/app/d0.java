package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3727a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3728b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3729c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public a0 f3730d;

    public final void a(D d4) {
        if (this.f3727a.contains(d4)) {
            throw new IllegalStateException("Fragment already added: " + d4);
        }
        synchronized (this.f3727a) {
            this.f3727a.add(d4);
        }
        d4.mAdded = true;
    }

    public final D b(String str) {
        c0 c0Var = (c0) this.f3728b.get(str);
        if (c0Var != null) {
            return c0Var.f3722c;
        }
        return null;
    }

    public final D c(String str) {
        D dFindFragmentByWho;
        for (c0 c0Var : this.f3728b.values()) {
            if (c0Var != null && (dFindFragmentByWho = c0Var.f3722c.findFragmentByWho(str)) != null) {
                return dFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (c0 c0Var : this.f3728b.values()) {
            if (c0Var != null) {
                arrayList.add(c0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (c0 c0Var : this.f3728b.values()) {
            if (c0Var != null) {
                arrayList.add(c0Var.f3722c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f3727a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3727a) {
            arrayList = new ArrayList(this.f3727a);
        }
        return arrayList;
    }

    public final void g(c0 c0Var) {
        D d4 = c0Var.f3722c;
        String str = d4.mWho;
        HashMap map = this.f3728b;
        if (map.get(str) != null) {
            return;
        }
        map.put(d4.mWho, c0Var);
        if (d4.mRetainInstanceChangedWhileDetached) {
            if (d4.mRetainInstance) {
                this.f3730d.c(d4);
            } else {
                this.f3730d.f(d4);
            }
            d4.mRetainInstanceChangedWhileDetached = false;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + d4);
        }
    }

    public final void h(c0 c0Var) {
        D d4 = c0Var.f3722c;
        if (d4.mRetainInstance) {
            this.f3730d.f(d4);
        }
        if (((c0) this.f3728b.put(d4.mWho, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + d4);
        }
    }
}
