package androidx.fragment.app;

import K.InterfaceC0078j;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.EnumC0327y;
import androidx.lifecycle.u0;
import androidx.room.AbstractC0351g;
import b0.AbstractC0357c;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import d.C0529c;
import d.C0530d;
import j0.C0631f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class Y {

    /* renamed from: A, reason: collision with root package name */
    public androidx.activity.result.d f3648A;

    /* renamed from: B, reason: collision with root package name */
    public androidx.activity.result.d f3649B;

    /* renamed from: C, reason: collision with root package name */
    public androidx.activity.result.d f3650C;

    /* renamed from: E, reason: collision with root package name */
    public boolean f3652E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f3653F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f3654G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f3655H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f3656I;

    /* renamed from: J, reason: collision with root package name */
    public ArrayList f3657J;

    /* renamed from: K, reason: collision with root package name */
    public ArrayList f3658K;

    /* renamed from: L, reason: collision with root package name */
    public ArrayList f3659L;

    /* renamed from: M, reason: collision with root package name */
    public a0 f3660M;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3663b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f3665d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3666e;

    /* renamed from: g, reason: collision with root package name */
    public androidx.activity.A f3668g;

    /* renamed from: o, reason: collision with root package name */
    public final O f3676o;

    /* renamed from: p, reason: collision with root package name */
    public final O f3677p;

    /* renamed from: q, reason: collision with root package name */
    public final O f3678q;

    /* renamed from: r, reason: collision with root package name */
    public final O f3679r;

    /* renamed from: u, reason: collision with root package name */
    public L f3682u;

    /* renamed from: v, reason: collision with root package name */
    public J f3683v;

    /* renamed from: w, reason: collision with root package name */
    public D f3684w;

    /* renamed from: x, reason: collision with root package name */
    public D f3685x;

    /* renamed from: z, reason: collision with root package name */
    public final P f3687z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3662a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final d0 f3664c = new d0();

    /* renamed from: f, reason: collision with root package name */
    public final N f3667f = new N(this);

    /* renamed from: h, reason: collision with root package name */
    public final Q f3669h = new Q(this);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f3670i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f3671j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map f3672k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    public final Map f3673l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public final C0301x f3674m = new C0301x(this);

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList f3675n = new CopyOnWriteArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final S f3680s = new S(this);

    /* renamed from: t, reason: collision with root package name */
    public int f3681t = -1;

    /* renamed from: y, reason: collision with root package name */
    public final T f3686y = new T(this);

    /* renamed from: D, reason: collision with root package name */
    public ArrayDeque f3651D = new ArrayDeque();

    /* renamed from: N, reason: collision with root package name */
    public final RunnableC0282d f3661N = new RunnableC0282d(2, this);

    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.O] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.O] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.O] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.O] */
    public Y() {
        final int i4 = 0;
        this.f3676o = new J.a(this) { // from class: androidx.fragment.app.O

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Y f3634b;

            {
                this.f3634b = this;
            }

            @Override // J.a
            public final void accept(Object obj) {
                int i5 = i4;
                Y y4 = this.f3634b;
                switch (i5) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (y4.H()) {
                            y4.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y4.H() && num.intValue() == 80) {
                            y4.l(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.l lVar = (androidx.core.app.l) obj;
                        if (y4.H()) {
                            y4.m(lVar.f3285a, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.B b4 = (androidx.core.app.B) obj;
                        if (y4.H()) {
                            y4.r(b4.f3272a, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i5 = 1;
        this.f3677p = new J.a(this) { // from class: androidx.fragment.app.O

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Y f3634b;

            {
                this.f3634b = this;
            }

            @Override // J.a
            public final void accept(Object obj) {
                int i52 = i5;
                Y y4 = this.f3634b;
                switch (i52) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (y4.H()) {
                            y4.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y4.H() && num.intValue() == 80) {
                            y4.l(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.l lVar = (androidx.core.app.l) obj;
                        if (y4.H()) {
                            y4.m(lVar.f3285a, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.B b4 = (androidx.core.app.B) obj;
                        if (y4.H()) {
                            y4.r(b4.f3272a, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i6 = 2;
        this.f3678q = new J.a(this) { // from class: androidx.fragment.app.O

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Y f3634b;

            {
                this.f3634b = this;
            }

            @Override // J.a
            public final void accept(Object obj) {
                int i52 = i6;
                Y y4 = this.f3634b;
                switch (i52) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (y4.H()) {
                            y4.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y4.H() && num.intValue() == 80) {
                            y4.l(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.l lVar = (androidx.core.app.l) obj;
                        if (y4.H()) {
                            y4.m(lVar.f3285a, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.B b4 = (androidx.core.app.B) obj;
                        if (y4.H()) {
                            y4.r(b4.f3272a, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i7 = 3;
        this.f3679r = new J.a(this) { // from class: androidx.fragment.app.O

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Y f3634b;

            {
                this.f3634b = this;
            }

            @Override // J.a
            public final void accept(Object obj) {
                int i52 = i7;
                Y y4 = this.f3634b;
                switch (i52) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        if (y4.H()) {
                            y4.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        if (y4.H() && num.intValue() == 80) {
                            y4.l(false);
                            break;
                        }
                        break;
                    case 2:
                        androidx.core.app.l lVar = (androidx.core.app.l) obj;
                        if (y4.H()) {
                            y4.m(lVar.f3285a, false);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.B b4 = (androidx.core.app.B) obj;
                        if (y4.H()) {
                            y4.r(b4.f3272a, false);
                            break;
                        }
                        break;
                }
            }
        };
        this.f3687z = new P(this, i7);
    }

    public static boolean G(D d4) {
        if (!d4.mHasMenu || !d4.mMenuVisible) {
            Iterator it = d4.mChildFragmentManager.f3664c.e().iterator();
            boolean zG = false;
            while (it.hasNext()) {
                D d5 = (D) it.next();
                if (d5 != null) {
                    zG = G(d5);
                }
                if (zG) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean I(D d4) {
        if (d4 == null) {
            return true;
        }
        Y y4 = d4.mFragmentManager;
        return d4.equals(y4.f3685x) && I(y4.f3684w);
    }

    public static void X(D d4) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + d4);
        }
        if (d4.mHidden) {
            d4.mHidden = false;
            d4.mHiddenChanged = !d4.mHiddenChanged;
        }
    }

    public final D A(int i4) {
        d0 d0Var = this.f3664c;
        ArrayList arrayList = d0Var.f3727a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            D d4 = (D) arrayList.get(size);
            if (d4 != null && d4.mFragmentId == i4) {
                return d4;
            }
        }
        for (c0 c0Var : d0Var.f3728b.values()) {
            if (c0Var != null) {
                D d5 = c0Var.f3722c;
                if (d5.mFragmentId == i4) {
                    return d5;
                }
            }
        }
        return null;
    }

    public final D B(String str) {
        d0 d0Var = this.f3664c;
        ArrayList arrayList = d0Var.f3727a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            D d4 = (D) arrayList.get(size);
            if (d4 != null && str.equals(d4.mTag)) {
                return d4;
            }
        }
        for (c0 c0Var : d0Var.f3728b.values()) {
            if (c0Var != null) {
                D d5 = c0Var.f3722c;
                if (str.equals(d5.mTag)) {
                    return d5;
                }
            }
        }
        return null;
    }

    public final ViewGroup C(D d4) {
        ViewGroup viewGroup = d4.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (d4.mContainerId > 0 && this.f3683v.c()) {
            View viewB = this.f3683v.b(d4.mContainerId);
            if (viewB instanceof ViewGroup) {
                return (ViewGroup) viewB;
            }
        }
        return null;
    }

    public final T D() {
        D d4 = this.f3684w;
        return d4 != null ? d4.mFragmentManager.D() : this.f3686y;
    }

    public final P E() {
        D d4 = this.f3684w;
        return d4 != null ? d4.mFragmentManager.E() : this.f3687z;
    }

    public final void F(D d4) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + d4);
        }
        if (d4.mHidden) {
            return;
        }
        d4.mHidden = true;
        d4.mHiddenChanged = true ^ d4.mHiddenChanged;
        W(d4);
    }

    public final boolean H() {
        D d4 = this.f3684w;
        if (d4 == null) {
            return true;
        }
        return d4.isAdded() && this.f3684w.getParentFragmentManager().H();
    }

    public final void J(int i4, boolean z4) {
        HashMap map;
        L l4;
        if (this.f3682u == null && i4 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i4 != this.f3681t) {
            this.f3681t = i4;
            d0 d0Var = this.f3664c;
            Iterator it = d0Var.f3727a.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = d0Var.f3728b;
                if (!zHasNext) {
                    break;
                }
                c0 c0Var = (c0) map.get(((D) it.next()).mWho);
                if (c0Var != null) {
                    c0Var.j();
                }
            }
            for (c0 c0Var2 : map.values()) {
                if (c0Var2 != null) {
                    c0Var2.j();
                    D d4 = c0Var2.f3722c;
                    if (d4.mRemoving && !d4.isInBackStack()) {
                        if (d4.mBeingSaved && !d0Var.f3729c.containsKey(d4.mWho)) {
                            c0Var2.m();
                        }
                        d0Var.h(c0Var2);
                    }
                }
            }
            Iterator it2 = d0Var.d().iterator();
            while (it2.hasNext()) {
                c0 c0Var3 = (c0) it2.next();
                D d5 = c0Var3.f3722c;
                if (d5.mDeferStart) {
                    if (this.f3663b) {
                        this.f3656I = true;
                    } else {
                        d5.mDeferStart = false;
                        c0Var3.j();
                    }
                }
            }
            if (this.f3652E && (l4 = this.f3682u) != null && this.f3681t == 7) {
                ((F) l4).f3587e.invalidateOptionsMenu();
                this.f3652E = false;
            }
        }
    }

    public final void K() {
        if (this.f3682u == null) {
            return;
        }
        this.f3653F = false;
        this.f3654G = false;
        this.f3660M.f3713f = false;
        for (D d4 : this.f3664c.f()) {
            if (d4 != null) {
                d4.noteStateNotSaved();
            }
        }
    }

    public final boolean L() {
        return M(-1, 0);
    }

    public final boolean M(int i4, int i5) {
        x(false);
        w(true);
        D d4 = this.f3685x;
        if (d4 != null && i4 < 0 && d4.getChildFragmentManager().L()) {
            return true;
        }
        boolean zN = N(this.f3657J, this.f3658K, i4, i5);
        if (zN) {
            this.f3663b = true;
            try {
                P(this.f3657J, this.f3658K);
            } finally {
                d();
            }
        }
        Z();
        boolean z4 = this.f3656I;
        d0 d0Var = this.f3664c;
        if (z4) {
            this.f3656I = false;
            Iterator it = d0Var.d().iterator();
            while (it.hasNext()) {
                c0 c0Var = (c0) it.next();
                D d5 = c0Var.f3722c;
                if (d5.mDeferStart) {
                    if (this.f3663b) {
                        this.f3656I = true;
                    } else {
                        d5.mDeferStart = false;
                        c0Var.j();
                    }
                }
            }
        }
        d0Var.f3728b.values().removeAll(Collections.singleton(null));
        return zN;
    }

    public final boolean N(ArrayList arrayList, ArrayList arrayList2, int i4, int i5) {
        boolean z4 = (i5 & 1) != 0;
        ArrayList arrayList3 = this.f3665d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i4 < 0) {
                size = z4 ? 0 : this.f3665d.size() - 1;
            } else {
                int size2 = this.f3665d.size() - 1;
                while (size2 >= 0) {
                    C0279a c0279a = (C0279a) this.f3665d.get(size2);
                    if (i4 >= 0 && i4 == c0279a.f3706s) {
                        break;
                    }
                    size2--;
                }
                if (size2 >= 0) {
                    if (z4) {
                        while (size2 > 0) {
                            C0279a c0279a2 = (C0279a) this.f3665d.get(size2 - 1);
                            if (i4 < 0 || i4 != c0279a2.f3706s) {
                                break;
                            }
                            size2--;
                        }
                    } else if (size2 != this.f3665d.size() - 1) {
                        size2++;
                    }
                    size = size2;
                } else {
                    size = size2;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.f3665d.size() - 1; size3 >= size; size3--) {
            arrayList.add((C0279a) this.f3665d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void O(D d4) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + d4 + " nesting=" + d4.mBackStackNesting);
        }
        boolean z4 = !d4.isInBackStack();
        if (!d4.mDetached || z4) {
            d0 d0Var = this.f3664c;
            synchronized (d0Var.f3727a) {
                d0Var.f3727a.remove(d4);
            }
            d4.mAdded = false;
            if (G(d4)) {
                this.f3652E = true;
            }
            d4.mRemoving = true;
            W(d4);
        }
    }

    public final void P(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            if (!((C0279a) arrayList.get(i4)).f3703p) {
                if (i5 != i4) {
                    z(arrayList, arrayList2, i5, i4);
                }
                i5 = i4 + 1;
                if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                    while (i5 < size && ((Boolean) arrayList2.get(i5)).booleanValue() && !((C0279a) arrayList.get(i5)).f3703p) {
                        i5++;
                    }
                }
                z(arrayList, arrayList2, i4, i5);
                i4 = i5 - 1;
            }
            i4++;
        }
        if (i5 != size) {
            z(arrayList, arrayList2, i5, size);
        }
    }

    public final void Q(Parcelable parcelable) {
        int i4;
        C0301x c0301x;
        int i5;
        c0 c0Var;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f3682u.f3626b.getClassLoader());
                this.f3672k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f3682u.f3626b.getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        d0 d0Var = this.f3664c;
        HashMap map = d0Var.f3729c;
        map.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState fragmentState = (FragmentState) it.next();
            map.put(fragmentState.f3604b, fragmentState);
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        HashMap map2 = d0Var.f3728b;
        map2.clear();
        Iterator it2 = fragmentManagerState.f3595a.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            i4 = 2;
            c0301x = this.f3674m;
            if (!zHasNext) {
                break;
            }
            FragmentState fragmentState2 = (FragmentState) d0Var.f3729c.remove((String) it2.next());
            if (fragmentState2 != null) {
                D d4 = (D) this.f3660M.f3708a.get(fragmentState2.f3604b);
                if (d4 != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + d4);
                    }
                    c0Var = new c0(c0301x, d0Var, d4, fragmentState2);
                } else {
                    c0Var = new c0(this.f3674m, this.f3664c, this.f3682u.f3626b.getClassLoader(), D(), fragmentState2);
                }
                D d5 = c0Var.f3722c;
                d5.mFragmentManager = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + d5.mWho + "): " + d5);
                }
                c0Var.k(this.f3682u.f3626b.getClassLoader());
                d0Var.g(c0Var);
                c0Var.f3724e = this.f3681t;
            }
        }
        a0 a0Var = this.f3660M;
        a0Var.getClass();
        Iterator it3 = new ArrayList(a0Var.f3708a.values()).iterator();
        while (it3.hasNext()) {
            D d6 = (D) it3.next();
            if (map2.get(d6.mWho) == null) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + d6 + " that was not found in the set of active Fragments " + fragmentManagerState.f3595a);
                }
                this.f3660M.f(d6);
                d6.mFragmentManager = this;
                c0 c0Var2 = new c0(c0301x, d0Var, d6);
                c0Var2.f3724e = 1;
                c0Var2.j();
                d6.mRemoving = true;
                c0Var2.j();
            }
        }
        ArrayList<String> arrayList2 = fragmentManagerState.f3596b;
        d0Var.f3727a.clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                D dB = d0Var.b(str3);
                if (dB == null) {
                    throw new IllegalStateException(B0.g.n("No instantiated fragment for (", str3, ")"));
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + dB);
                }
                d0Var.a(dB);
            }
        }
        if (fragmentManagerState.f3597c != null) {
            this.f3665d = new ArrayList(fragmentManagerState.f3597c.length);
            int i6 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f3597c;
                if (i6 >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecordState backStackRecordState = backStackRecordStateArr[i6];
                backStackRecordState.getClass();
                C0279a c0279a = new C0279a(this);
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    int[] iArr = backStackRecordState.f3569a;
                    if (i7 >= iArr.length) {
                        break;
                    }
                    e0 e0Var = new e0();
                    int i9 = i7 + 1;
                    e0Var.f3735a = iArr[i7];
                    if (Log.isLoggable("FragmentManager", i4)) {
                        Log.v("FragmentManager", "Instantiate " + c0279a + " op #" + i8 + " base fragment #" + iArr[i9]);
                    }
                    e0Var.f3742h = EnumC0327y.values()[backStackRecordState.f3571c[i8]];
                    e0Var.f3743i = EnumC0327y.values()[backStackRecordState.f3572d[i8]];
                    int i10 = i7 + 2;
                    e0Var.f3737c = iArr[i9] != 0;
                    int i11 = iArr[i10];
                    e0Var.f3738d = i11;
                    int i12 = iArr[i7 + 3];
                    e0Var.f3739e = i12;
                    int i13 = i7 + 5;
                    int i14 = iArr[i7 + 4];
                    e0Var.f3740f = i14;
                    i7 += 6;
                    int i15 = iArr[i13];
                    e0Var.f3741g = i15;
                    c0279a.f3689b = i11;
                    c0279a.f3690c = i12;
                    c0279a.f3691d = i14;
                    c0279a.f3692e = i15;
                    c0279a.b(e0Var);
                    i8++;
                    i4 = 2;
                }
                c0279a.f3693f = backStackRecordState.f3573e;
                c0279a.f3696i = backStackRecordState.f3574f;
                c0279a.f3694g = true;
                c0279a.f3697j = backStackRecordState.f3576h;
                c0279a.f3698k = backStackRecordState.f3577i;
                c0279a.f3699l = backStackRecordState.f3578j;
                c0279a.f3700m = backStackRecordState.f3579k;
                c0279a.f3701n = backStackRecordState.f3580l;
                c0279a.f3702o = backStackRecordState.f3581m;
                c0279a.f3703p = backStackRecordState.f3582n;
                c0279a.f3706s = backStackRecordState.f3575g;
                int i16 = 0;
                while (true) {
                    ArrayList arrayList3 = backStackRecordState.f3570b;
                    if (i16 >= arrayList3.size()) {
                        break;
                    }
                    String str4 = (String) arrayList3.get(i16);
                    if (str4 != null) {
                        ((e0) c0279a.f3688a.get(i16)).f3736b = d0Var.b(str4);
                    }
                    i16++;
                }
                c0279a.c(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sbT = B0.g.t("restoreAllState: back stack #", i6, " (index ");
                    sbT.append(c0279a.f3706s);
                    sbT.append("): ");
                    sbT.append(c0279a);
                    Log.v("FragmentManager", sbT.toString());
                    PrintWriter printWriter = new PrintWriter(new o0());
                    c0279a.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3665d.add(c0279a);
                i6++;
                i4 = 2;
            }
            i5 = 0;
        } else {
            i5 = 0;
            this.f3665d = null;
        }
        this.f3670i.set(fragmentManagerState.f3598d);
        String str5 = fragmentManagerState.f3599e;
        if (str5 != null) {
            D dB2 = d0Var.b(str5);
            this.f3685x = dB2;
            q(dB2);
        }
        ArrayList arrayList4 = fragmentManagerState.f3600f;
        if (arrayList4 != null) {
            for (int i17 = i5; i17 < arrayList4.size(); i17++) {
                this.f3671j.put((String) arrayList4.get(i17), (BackStackState) fragmentManagerState.f3601g.get(i17));
            }
        }
        this.f3651D = new ArrayDeque(fragmentManagerState.f3602h);
    }

    public final Bundle R() {
        int i4;
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            r0 r0Var = (r0) it.next();
            if (r0Var.f3829e) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                r0Var.f3829e = false;
                r0Var.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((r0) it2.next()).e();
        }
        x(true);
        this.f3653F = true;
        this.f3660M.f3713f = true;
        d0 d0Var = this.f3664c;
        d0Var.getClass();
        HashMap map = d0Var.f3728b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (c0 c0Var : map.values()) {
            if (c0Var != null) {
                c0Var.m();
                D d4 = c0Var.f3722c;
                arrayList2.add(d4.mWho);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + d4 + ": " + d4.mSavedFragmentState);
                }
            }
        }
        d0 d0Var2 = this.f3664c;
        d0Var2.getClass();
        ArrayList arrayList3 = new ArrayList(d0Var2.f3729c.values());
        if (!arrayList3.isEmpty()) {
            d0 d0Var3 = this.f3664c;
            synchronized (d0Var3.f3727a) {
                try {
                    if (d0Var3.f3727a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(d0Var3.f3727a.size());
                        Iterator it3 = d0Var3.f3727a.iterator();
                        while (it3.hasNext()) {
                            D d5 = (D) it3.next();
                            arrayList.add(d5.mWho);
                            if (Log.isLoggable("FragmentManager", 2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + d5.mWho + "): " + d5);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList arrayList4 = this.f3665d;
            if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (i4 = 0; i4 < size; i4++) {
                    backStackRecordStateArr[i4] = new BackStackRecordState((C0279a) this.f3665d.get(i4));
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sbT = B0.g.t("saveAllState: adding back stack #", i4, ": ");
                        sbT.append(this.f3665d.get(i4));
                        Log.v("FragmentManager", sbT.toString());
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f3599e = null;
            ArrayList arrayList5 = new ArrayList();
            fragmentManagerState.f3600f = arrayList5;
            ArrayList arrayList6 = new ArrayList();
            fragmentManagerState.f3601g = arrayList6;
            fragmentManagerState.f3595a = arrayList2;
            fragmentManagerState.f3596b = arrayList;
            fragmentManagerState.f3597c = backStackRecordStateArr;
            fragmentManagerState.f3598d = this.f3670i.get();
            D d6 = this.f3685x;
            if (d6 != null) {
                fragmentManagerState.f3599e = d6.mWho;
            }
            arrayList5.addAll(this.f3671j.keySet());
            arrayList6.addAll(this.f3671j.values());
            fragmentManagerState.f3602h = new ArrayList(this.f3651D);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f3672k.keySet()) {
                bundle.putBundle(B0.g.m("result_", str), (Bundle) this.f3672k.get(str));
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                FragmentState fragmentState = (FragmentState) it4.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle("fragment_" + fragmentState.f3604b, bundle2);
            }
        } else if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public final void S() {
        synchronized (this.f3662a) {
            try {
                if (this.f3662a.size() == 1) {
                    this.f3682u.f3627c.removeCallbacks(this.f3661N);
                    this.f3682u.f3627c.post(this.f3661N);
                    Z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void T(D d4, boolean z4) {
        ViewGroup viewGroupC = C(d4);
        if (viewGroupC == null || !(viewGroupC instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupC).setDrawDisappearingViewsLast(!z4);
    }

    public final void U(D d4, EnumC0327y enumC0327y) {
        if (d4.equals(this.f3664c.b(d4.mWho)) && (d4.mHost == null || d4.mFragmentManager == this)) {
            d4.mMaxState = enumC0327y;
            return;
        }
        throw new IllegalArgumentException("Fragment " + d4 + " is not an active fragment of FragmentManager " + this);
    }

    public final void V(D d4) {
        if (d4 != null) {
            if (!d4.equals(this.f3664c.b(d4.mWho)) || (d4.mHost != null && d4.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + d4 + " is not an active fragment of FragmentManager " + this);
            }
        }
        D d5 = this.f3685x;
        this.f3685x = d4;
        q(d5);
        q(this.f3685x);
    }

    public final void W(D d4) {
        ViewGroup viewGroupC = C(d4);
        if (viewGroupC != null) {
            if (d4.getPopExitAnim() + d4.getPopEnterAnim() + d4.getExitAnim() + d4.getEnterAnim() > 0) {
                if (viewGroupC.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupC.setTag(R.id.visible_removing_fragment_view_tag, d4);
                }
                ((D) viewGroupC.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(d4.getPopDirection());
            }
        }
    }

    public final void Y(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new o0());
        L l4 = this.f3682u;
        if (l4 == null) {
            try {
                u("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e4) {
                Log.e("FragmentManager", "Failed dumping state", e4);
                throw illegalStateException;
            }
        }
        try {
            ((F) l4).f3587e.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e5) {
            Log.e("FragmentManager", "Failed dumping state", e5);
            throw illegalStateException;
        }
    }

    public final void Z() {
        synchronized (this.f3662a) {
            try {
                if (!this.f3662a.isEmpty()) {
                    Q q4 = this.f3669h;
                    q4.f3637a = true;
                    Function0 function0 = q4.f3639c;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return;
                }
                Q q5 = this.f3669h;
                ArrayList arrayList = this.f3665d;
                q5.f3637a = arrayList != null && arrayList.size() > 0 && I(this.f3684w);
                Function0 function02 = q5.f3639c;
                if (function02 != null) {
                    function02.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final c0 a(D d4) {
        String str = d4.mPreviousWho;
        if (str != null) {
            AbstractC0357c.d(d4, str);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + d4);
        }
        c0 c0VarF = f(d4);
        d4.mFragmentManager = this;
        d0 d0Var = this.f3664c;
        d0Var.g(c0VarF);
        if (!d4.mDetached) {
            d0Var.a(d4);
            d4.mRemoving = false;
            if (d4.mView == null) {
                d4.mHiddenChanged = false;
            }
            if (G(d4)) {
                this.f3652E = true;
            }
        }
        return c0VarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(L l4, J j4, D d4) {
        if (this.f3682u != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3682u = l4;
        this.f3683v = j4;
        this.f3684w = d4;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f3675n;
        if (d4 != null) {
            copyOnWriteArrayList.add(new U(d4));
        } else if (l4 instanceof b0) {
            copyOnWriteArrayList.add((b0) l4);
        }
        if (this.f3684w != null) {
            Z();
        }
        int i4 = 0;
        if (l4 instanceof androidx.activity.B) {
            androidx.activity.B b4 = (androidx.activity.B) l4;
            androidx.activity.A onBackPressedDispatcher = b4.getOnBackPressedDispatcher();
            this.f3668g = onBackPressedDispatcher;
            D owner = b4;
            if (d4 != null) {
                owner = d4;
            }
            onBackPressedDispatcher.getClass();
            Intrinsics.checkNotNullParameter(owner, "owner");
            Q onBackPressedCallback = this.f3669h;
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            AbstractC0328z lifecycle = owner.getLifecycle();
            if (((androidx.lifecycle.I) lifecycle).f3871d != EnumC0327y.f3983a) {
                androidx.activity.x cancellable = new androidx.activity.x(onBackPressedDispatcher, lifecycle, onBackPressedCallback);
                onBackPressedCallback.getClass();
                Intrinsics.checkNotNullParameter(cancellable, "cancellable");
                onBackPressedCallback.f3638b.add(cancellable);
                onBackPressedDispatcher.c();
                onBackPressedCallback.f3639c = new androidx.activity.z(0, onBackPressedDispatcher);
            }
        }
        if (d4 != null) {
            a0 a0Var = d4.mFragmentManager.f3660M;
            HashMap map = a0Var.f3709b;
            a0 a0Var2 = (a0) map.get(d4.mWho);
            if (a0Var2 == null) {
                a0Var2 = new a0(a0Var.f3711d);
                map.put(d4.mWho, a0Var2);
            }
            this.f3660M = a0Var2;
        } else if (l4 instanceof u0) {
            this.f3660M = (a0) new android.support.v4.media.session.c(((u0) l4).getViewModelStore(), a0.f3707g).e(a0.class);
        } else {
            this.f3660M = new a0(false);
        }
        a0 a0Var3 = this.f3660M;
        int i5 = 1;
        a0Var3.f3713f = this.f3653F || this.f3654G;
        this.f3664c.f3730d = a0Var3;
        Object obj = this.f3682u;
        int i6 = 2;
        if ((obj instanceof j0.h) && d4 == null) {
            C0631f savedStateRegistry = ((j0.h) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new androidx.activity.f(2, this));
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                Q(bundleA);
            }
        }
        Object obj2 = this.f3682u;
        if (obj2 instanceof androidx.activity.result.h) {
            androidx.activity.result.g activityResultRegistry = ((androidx.activity.result.h) obj2).getActivityResultRegistry();
            String strM = B0.g.m("FragmentManager:", d4 != null ? B0.g.r(new StringBuilder(), d4.mWho, AwarenessDataItem.USERID_SPLITTER) : "");
            this.f3648A = activityResultRegistry.d(AbstractC0351g.p(strM, "StartActivityForResult"), new C0530d(), new P(this, i5));
            this.f3649B = activityResultRegistry.d(AbstractC0351g.p(strM, "StartIntentSenderForResult"), new V(), new P(this, i6));
            this.f3650C = activityResultRegistry.d(AbstractC0351g.p(strM, "RequestPermissions"), new C0529c(), new P(this, i4));
        }
        Object obj3 = this.f3682u;
        if (obj3 instanceof androidx.core.content.h) {
            ((androidx.core.content.h) obj3).addOnConfigurationChangedListener(this.f3676o);
        }
        Object obj4 = this.f3682u;
        if (obj4 instanceof androidx.core.content.i) {
            ((androidx.core.content.i) obj4).addOnTrimMemoryListener(this.f3677p);
        }
        Object obj5 = this.f3682u;
        if (obj5 instanceof androidx.core.app.z) {
            ((androidx.core.app.z) obj5).addOnMultiWindowModeChangedListener(this.f3678q);
        }
        Object obj6 = this.f3682u;
        if (obj6 instanceof androidx.core.app.A) {
            ((androidx.core.app.A) obj6).addOnPictureInPictureModeChangedListener(this.f3679r);
        }
        Object obj7 = this.f3682u;
        if ((obj7 instanceof InterfaceC0078j) && d4 == null) {
            ((InterfaceC0078j) obj7).addMenuProvider(this.f3680s);
        }
    }

    public final void c(D d4) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + d4);
        }
        if (d4.mDetached) {
            d4.mDetached = false;
            if (d4.mAdded) {
                return;
            }
            this.f3664c.a(d4);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "add from attach: " + d4);
            }
            if (G(d4)) {
                this.f3652E = true;
            }
        }
    }

    public final void d() {
        this.f3663b = false;
        this.f3658K.clear();
        this.f3657J.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f3664c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((c0) it.next()).f3722c.mContainer;
            if (viewGroup != null) {
                hashSet.add(r0.f(viewGroup, E()));
            }
        }
        return hashSet;
    }

    public final c0 f(D d4) {
        String str = d4.mWho;
        d0 d0Var = this.f3664c;
        c0 c0Var = (c0) d0Var.f3728b.get(str);
        if (c0Var != null) {
            return c0Var;
        }
        c0 c0Var2 = new c0(this.f3674m, d0Var, d4);
        c0Var2.k(this.f3682u.f3626b.getClassLoader());
        c0Var2.f3724e = this.f3681t;
        return c0Var2;
    }

    public final void g(D d4) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "detach: " + d4);
        }
        if (d4.mDetached) {
            return;
        }
        d4.mDetached = true;
        if (d4.mAdded) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "remove from detach: " + d4);
            }
            d0 d0Var = this.f3664c;
            synchronized (d0Var.f3727a) {
                d0Var.f3727a.remove(d4);
            }
            d4.mAdded = false;
            if (G(d4)) {
                this.f3652E = true;
            }
            W(d4);
        }
    }

    public final void h(boolean z4, Configuration configuration) {
        if (z4 && (this.f3682u instanceof androidx.core.content.h)) {
            Y(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null) {
                d4.performConfigurationChanged(configuration);
                if (z4) {
                    d4.mChildFragmentManager.h(true, configuration);
                }
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.f3681t < 1) {
            return false;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null && d4.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.f3681t < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z4 = false;
        for (D d4 : this.f3664c.f()) {
            if (d4 != null && d4.isMenuVisible() && d4.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(d4);
                z4 = true;
            }
        }
        if (this.f3666e != null) {
            for (int i4 = 0; i4 < this.f3666e.size(); i4++) {
                D d5 = (D) this.f3666e.get(i4);
                if (arrayList == null || !arrayList.contains(d5)) {
                    d5.onDestroyOptionsMenu();
                }
            }
        }
        this.f3666e = arrayList;
        return z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Y.k():void");
    }

    public final void l(boolean z4) {
        if (z4 && (this.f3682u instanceof androidx.core.content.i)) {
            Y(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null) {
                d4.performLowMemory();
                if (z4) {
                    d4.mChildFragmentManager.l(true);
                }
            }
        }
    }

    public final void m(boolean z4, boolean z5) {
        if (z5 && (this.f3682u instanceof androidx.core.app.z)) {
            Y(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null) {
                d4.performMultiWindowModeChanged(z4);
                if (z5) {
                    d4.mChildFragmentManager.m(z4, true);
                }
            }
        }
    }

    public final void n() {
        Iterator it = this.f3664c.e().iterator();
        while (it.hasNext()) {
            D d4 = (D) it.next();
            if (d4 != null) {
                d4.onHiddenChanged(d4.isHidden());
                d4.mChildFragmentManager.n();
            }
        }
    }

    public final boolean o(MenuItem menuItem) {
        if (this.f3681t < 1) {
            return false;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null && d4.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void p(Menu menu) {
        if (this.f3681t < 1) {
            return;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null) {
                d4.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void q(D d4) {
        if (d4 != null) {
            if (d4.equals(this.f3664c.b(d4.mWho))) {
                d4.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void r(boolean z4, boolean z5) {
        if (z5 && (this.f3682u instanceof androidx.core.app.A)) {
            Y(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null) {
                d4.performPictureInPictureModeChanged(z4);
                if (z5) {
                    d4.mChildFragmentManager.r(z4, true);
                }
            }
        }
    }

    public final boolean s(Menu menu) {
        boolean z4 = false;
        if (this.f3681t < 1) {
            return false;
        }
        for (D d4 : this.f3664c.f()) {
            if (d4 != null && d4.isMenuVisible() && d4.performPrepareOptionsMenu(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    public final void t(int i4) {
        try {
            this.f3663b = true;
            for (c0 c0Var : this.f3664c.f3728b.values()) {
                if (c0Var != null) {
                    c0Var.f3724e = i4;
                }
            }
            J(i4, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((r0) it.next()).e();
            }
            this.f3663b = false;
            x(true);
        } catch (Throwable th) {
            this.f3663b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        D d4 = this.f3684w;
        if (d4 != null) {
            sb.append(d4.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3684w)));
            sb.append("}");
        } else {
            L l4 = this.f3682u;
            if (l4 != null) {
                sb.append(l4.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3682u)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strP = AbstractC0351g.p(str, "    ");
        d0 d0Var = this.f3664c;
        d0Var.getClass();
        String str2 = str + "    ";
        HashMap map = d0Var.f3728b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (c0 c0Var : map.values()) {
                printWriter.print(str);
                if (c0Var != null) {
                    D d4 = c0Var.f3722c;
                    printWriter.println(d4);
                    d4.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = d0Var.f3727a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i4 = 0; i4 < size3; i4++) {
                D d5 = (D) arrayList.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(d5.toString());
            }
        }
        ArrayList arrayList2 = this.f3666e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size2; i5++) {
                D d6 = (D) this.f3666e.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(d6.toString());
            }
        }
        ArrayList arrayList3 = this.f3665d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size; i6++) {
                C0279a c0279a = (C0279a) this.f3665d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(c0279a.toString());
                c0279a.f(strP, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3670i.get());
        synchronized (this.f3662a) {
            try {
                int size4 = this.f3662a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i7 = 0; i7 < size4; i7++) {
                        Object obj = (W) this.f3662a.get(i7);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i7);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3682u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3683v);
        if (this.f3684w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3684w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3681t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3653F);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3654G);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3655H);
        if (this.f3652E) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3652E);
        }
    }

    public final void v(W w4, boolean z4) {
        if (!z4) {
            if (this.f3682u == null) {
                if (!this.f3655H) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.f3653F || this.f3654G) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f3662a) {
            try {
                if (this.f3682u == null) {
                    if (!z4) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f3662a.add(w4);
                    S();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z4) {
        if (this.f3663b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3682u == null) {
            if (!this.f3655H) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3682u.f3627c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z4 && (this.f3653F || this.f3654G)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3657J == null) {
            this.f3657J = new ArrayList();
            this.f3658K = new ArrayList();
        }
    }

    public final boolean x(boolean z4) {
        w(z4);
        boolean z5 = false;
        while (true) {
            ArrayList arrayList = this.f3657J;
            ArrayList arrayList2 = this.f3658K;
            synchronized (this.f3662a) {
                if (this.f3662a.isEmpty()) {
                    break;
                }
                try {
                    int size = this.f3662a.size();
                    boolean zA = false;
                    for (int i4 = 0; i4 < size; i4++) {
                        zA |= ((W) this.f3662a.get(i4)).a(arrayList, arrayList2);
                    }
                    if (!zA) {
                        break;
                    }
                    this.f3663b = true;
                    try {
                        P(this.f3657J, this.f3658K);
                        d();
                        z5 = true;
                    } catch (Throwable th) {
                        d();
                        throw th;
                    }
                } finally {
                    this.f3662a.clear();
                    this.f3682u.f3627c.removeCallbacks(this.f3661N);
                }
            }
        }
        Z();
        if (this.f3656I) {
            this.f3656I = false;
            Iterator it = this.f3664c.d().iterator();
            while (it.hasNext()) {
                c0 c0Var = (c0) it.next();
                D d4 = c0Var.f3722c;
                if (d4.mDeferStart) {
                    if (this.f3663b) {
                        this.f3656I = true;
                    } else {
                        d4.mDeferStart = false;
                        c0Var.j();
                    }
                }
            }
        }
        this.f3664c.f3728b.values().removeAll(Collections.singleton(null));
        return z5;
    }

    public final void y(W w4, boolean z4) {
        if (z4 && (this.f3682u == null || this.f3655H)) {
            return;
        }
        w(z4);
        if (w4.a(this.f3657J, this.f3658K)) {
            this.f3663b = true;
            try {
                P(this.f3657J, this.f3658K);
            } finally {
                d();
            }
        }
        Z();
        boolean z5 = this.f3656I;
        d0 d0Var = this.f3664c;
        if (z5) {
            this.f3656I = false;
            Iterator it = d0Var.d().iterator();
            while (it.hasNext()) {
                c0 c0Var = (c0) it.next();
                D d4 = c0Var.f3722c;
                if (d4.mDeferStart) {
                    if (this.f3663b) {
                        this.f3656I = true;
                    } else {
                        d4.mDeferStart = false;
                        c0Var.j();
                    }
                }
            }
        }
        d0Var.f3728b.values().removeAll(Collections.singleton(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0223 A[PHI: r12
      0x0223: PHI (r12v9 int) = (r12v8 int), (r12v10 int) binds: [B:104:0x0213, B:109:0x021f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(java.util.ArrayList r21, java.util.ArrayList r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 1196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.Y.z(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }
}
