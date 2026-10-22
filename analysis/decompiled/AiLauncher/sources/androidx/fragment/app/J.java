package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class J {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f13989a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, I> f13990b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, Bundle> f13991c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public G f13992d;

    public void A(G g10) {
        this.f13992d = g10;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? this.f13991c.put(str, bundle) : this.f13991c.remove(str);
    }

    public void a(Fragment fragment) {
        if (this.f13989a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f13989a) {
            this.f13989a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public void b() {
        this.f13990b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f13990b.get(str) != null;
    }

    public void d(int i10) {
        for (I i11 : this.f13990b.values()) {
            if (i11 != null) {
                i11.t(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f13990b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (I i10 : this.f13990b.values()) {
                printWriter.print(str);
                if (i10 != null) {
                    Fragment fragmentK = i10.k();
                    printWriter.println(fragmentK);
                    fragmentK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f13989a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i11 = 0; i11 < size; i11++) {
                Fragment fragment = this.f13989a.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    public Fragment f(String str) {
        I i10 = this.f13990b.get(str);
        if (i10 != null) {
            return i10.k();
        }
        return null;
    }

    public Fragment g(int i10) {
        for (int size = this.f13989a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f13989a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (I i11 : this.f13990b.values()) {
            if (i11 != null) {
                Fragment fragmentK = i11.k();
                if (fragmentK.mFragmentId == i10) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f13989a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f13989a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (I i10 : this.f13990b.values()) {
            if (i10 != null) {
                Fragment fragmentK = i10.k();
                if (str.equals(fragmentK.mTag)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment fragmentFindFragmentByWho;
        for (I i10 : this.f13990b.values()) {
            if (i10 != null && (fragmentFindFragmentByWho = i10.k().findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f13989a.indexOf(fragment);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f13989a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f13989a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f13989a.get(iIndexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List<I> k() {
        ArrayList arrayList = new ArrayList();
        for (I i10 : this.f13990b.values()) {
            if (i10 != null) {
                arrayList.add(i10);
            }
        }
        return arrayList;
    }

    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (I i10 : this.f13990b.values()) {
            if (i10 != null) {
                arrayList.add(i10.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public HashMap<String, Bundle> m() {
        return this.f13991c;
    }

    public I n(String str) {
        return this.f13990b.get(str);
    }

    public List<Fragment> o() {
        ArrayList arrayList;
        if (this.f13989a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f13989a) {
            arrayList = new ArrayList(this.f13989a);
        }
        return arrayList;
    }

    public G p() {
        return this.f13992d;
    }

    public Bundle q(String str) {
        return this.f13991c.get(str);
    }

    public void r(I i10) {
        Fragment fragmentK = i10.k();
        if (c(fragmentK.mWho)) {
            return;
        }
        this.f13990b.put(fragmentK.mWho, i10);
        if (fragmentK.mRetainInstanceChangedWhileDetached) {
            if (fragmentK.mRetainInstance) {
                this.f13992d.e(fragmentK);
            } else {
                this.f13992d.o(fragmentK);
            }
            fragmentK.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.N0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    public void s(I i10) {
        Fragment fragmentK = i10.k();
        if (fragmentK.mRetainInstance) {
            this.f13992d.o(fragmentK);
        }
        if (this.f13990b.get(fragmentK.mWho) == i10 && this.f13990b.put(fragmentK.mWho, null) != null && FragmentManager.N0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    public void t() {
        Iterator<Fragment> it = this.f13989a.iterator();
        while (it.hasNext()) {
            I i10 = this.f13990b.get(it.next().mWho);
            if (i10 != null) {
                i10.m();
            }
        }
        for (I i11 : this.f13990b.values()) {
            if (i11 != null) {
                i11.m();
                Fragment fragmentK = i11.k();
                if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                    if (fragmentK.mBeingSaved && !this.f13991c.containsKey(fragmentK.mWho)) {
                        B(fragmentK.mWho, i11.r());
                    }
                    s(i11);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        synchronized (this.f13989a) {
            this.f13989a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void v() {
        this.f13990b.clear();
    }

    public void w(List<String> list) {
        this.f13989a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    public void x(HashMap<String, Bundle> map) {
        this.f13991c.clear();
        this.f13991c.putAll(map);
    }

    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f13990b.size());
        for (I i10 : this.f13990b.values()) {
            if (i10 != null) {
                Fragment fragmentK = i10.k();
                B(fragmentK.mWho, i10.r());
                arrayList.add(fragmentK.mWho);
                if (FragmentManager.N0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentK.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> z() {
        synchronized (this.f13989a) {
            try {
                if (this.f13989a.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f13989a.size());
                Iterator<Fragment> it = this.f13989a.iterator();
                while (it.hasNext()) {
                    Fragment next = it.next();
                    arrayList.add(next.mWho);
                    if (FragmentManager.N0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
