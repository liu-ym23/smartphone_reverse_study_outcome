package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
abstract class M {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f10487a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<e> f10488b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<e> f10489c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f10490d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f10491e = false;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f10492a;

        a(d dVar) {
            this.f10492a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (M.this.f10488b.contains(this.f10492a)) {
                this.f10492a.e().b(this.f10492a.f().f10613I);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f10494a;

        b(d dVar) {
            this.f10494a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            M.this.f10488b.remove(this.f10494a);
            M.this.f10489c.remove(this.f10494a);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10496a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f10497b;

        static {
            int[] iArr = new int[e.b.values().length];
            f10497b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10497b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10497b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f10496a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10496a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10496a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10496a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        private final E f10498h;

        d(e.c cVar, e.b bVar, E e6, androidx.core.os.c cVar2) {
            super(cVar, bVar, e6.k(), cVar2);
            this.f10498h = e6;
        }

        @Override // androidx.fragment.app.M.e
        public void c() {
            super.c();
            this.f10498h.m();
        }

        @Override // androidx.fragment.app.M.e
        void l() {
            if (g() != e.b.ADDING) {
                if (g() == e.b.REMOVING) {
                    ComponentCallbacksC0511f componentCallbacksC0511fK = this.f10498h.k();
                    View viewB1 = componentCallbacksC0511fK.B1();
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewB1.findFocus() + " on view " + viewB1 + " for Fragment " + componentCallbacksC0511fK);
                    }
                    viewB1.clearFocus();
                    return;
                }
                return;
            }
            ComponentCallbacksC0511f componentCallbacksC0511fK2 = this.f10498h.k();
            View viewFindFocus = componentCallbacksC0511fK2.f10613I.findFocus();
            if (viewFindFocus != null) {
                componentCallbacksC0511fK2.H1(viewFindFocus);
                if (x.F0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + componentCallbacksC0511fK2);
                }
            }
            View viewB12 = f().B1();
            if (viewB12.getParent() == null) {
                this.f10498h.b();
                viewB12.setAlpha(0.0f);
            }
            if (viewB12.getAlpha() == 0.0f && viewB12.getVisibility() == 0) {
                viewB12.setVisibility(4);
            }
            viewB12.setAlpha(componentCallbacksC0511fK2.O());
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private c f10499a;

        /* renamed from: b, reason: collision with root package name */
        private b f10500b;

        /* renamed from: c, reason: collision with root package name */
        private final ComponentCallbacksC0511f f10501c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Runnable> f10502d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet<androidx.core.os.c> f10503e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f10504f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f10505g = false;

        class a implements c.a {
            a() {
            }

            @Override // androidx.core.os.c.a
            public void onCancel() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c d(int i5) {
                if (i5 == 0) {
                    return VISIBLE;
                }
                if (i5 == 4) {
                    return INVISIBLE;
                }
                if (i5 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i5);
            }

            static c e(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : d(view.getVisibility());
            }

            void b(View view) {
                int i5 = c.f10496a[ordinal()];
                if (i5 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (x.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i5 == 2) {
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i5 == 3) {
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i5 != 4) {
                    return;
                }
                if (x.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(c cVar, b bVar, ComponentCallbacksC0511f componentCallbacksC0511f, androidx.core.os.c cVar2) {
            this.f10499a = cVar;
            this.f10500b = bVar;
            this.f10501c = componentCallbacksC0511f;
            cVar2.b(new a());
        }

        final void a(Runnable runnable) {
            this.f10502d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f10504f = true;
            if (this.f10503e.isEmpty()) {
                c();
                return;
            }
            ArrayList arrayList = new ArrayList(this.f10503e);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ((androidx.core.os.c) obj).a();
            }
        }

        public void c() {
            if (this.f10505g) {
                return;
            }
            if (x.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f10505g = true;
            Iterator<Runnable> it = this.f10502d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(androidx.core.os.c cVar) {
            if (this.f10503e.remove(cVar) && this.f10503e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f10499a;
        }

        public final ComponentCallbacksC0511f f() {
            return this.f10501c;
        }

        b g() {
            return this.f10500b;
        }

        final boolean h() {
            return this.f10504f;
        }

        final boolean i() {
            return this.f10505g;
        }

        public final void j(androidx.core.os.c cVar) {
            l();
            this.f10503e.add(cVar);
        }

        final void k(c cVar, b bVar) {
            int i5 = c.f10497b[bVar.ordinal()];
            if (i5 == 1) {
                if (this.f10499a == c.REMOVED) {
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10501c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f10500b + " to ADDING.");
                    }
                    this.f10499a = c.VISIBLE;
                    this.f10500b = b.ADDING;
                    return;
                }
                return;
            }
            if (i5 == 2) {
                if (x.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10501c + " mFinalState = " + this.f10499a + " -> REMOVED. mLifecycleImpact  = " + this.f10500b + " to REMOVING.");
                }
                this.f10499a = c.REMOVED;
                this.f10500b = b.REMOVING;
                return;
            }
            if (i5 == 3 && this.f10499a != c.REMOVED) {
                if (x.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10501c + " mFinalState = " + this.f10499a + " -> " + cVar + ". ");
                }
                this.f10499a = cVar;
            }
        }

        void l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f10499a + "} {mLifecycleImpact = " + this.f10500b + "} {mFragment = " + this.f10501c + "}";
        }
    }

    M(ViewGroup viewGroup) {
        this.f10487a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, E e6) {
        synchronized (this.f10488b) {
            try {
                androidx.core.os.c cVar2 = new androidx.core.os.c();
                e eVarH = h(e6.k());
                if (eVarH != null) {
                    eVarH.k(cVar, bVar);
                    return;
                }
                d dVar = new d(cVar, bVar, e6, cVar2);
                this.f10488b.add(dVar);
                dVar.a(new a(dVar));
                dVar.a(new b(dVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private e h(ComponentCallbacksC0511f componentCallbacksC0511f) {
        ArrayList<e> arrayList = this.f10488b;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            e eVar = arrayList.get(i5);
            i5++;
            e eVar2 = eVar;
            if (eVar2.f().equals(componentCallbacksC0511f) && !eVar2.h()) {
                return eVar2;
            }
        }
        return null;
    }

    private e i(ComponentCallbacksC0511f componentCallbacksC0511f) {
        ArrayList<e> arrayList = this.f10489c;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            e eVar = arrayList.get(i5);
            i5++;
            e eVar2 = eVar;
            if (eVar2.f().equals(componentCallbacksC0511f) && !eVar2.h()) {
                return eVar2;
            }
        }
        return null;
    }

    static M n(ViewGroup viewGroup, x xVar) {
        return o(viewGroup, xVar.x0());
    }

    static M o(ViewGroup viewGroup, N n5) {
        int i5 = S.b.f5199b;
        Object tag = viewGroup.getTag(i5);
        if (tag instanceof M) {
            return (M) tag;
        }
        M mA = n5.a(viewGroup);
        viewGroup.setTag(i5, mA);
        return mA;
    }

    private void q() {
        ArrayList<e> arrayList = this.f10488b;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            e eVar = arrayList.get(i5);
            i5++;
            e eVar2 = eVar;
            if (eVar2.g() == e.b.ADDING) {
                eVar2.k(e.c.d(eVar2.f().B1().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, E e6) {
        if (x.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + e6.k());
        }
        a(cVar, e.b.ADDING, e6);
    }

    void c(E e6) {
        if (x.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + e6.k());
        }
        a(e.c.GONE, e.b.NONE, e6);
    }

    void d(E e6) {
        if (x.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + e6.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, e6);
    }

    void e(E e6) {
        if (x.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + e6.k());
        }
        a(e.c.VISIBLE, e.b.NONE, e6);
    }

    abstract void f(List<e> list, boolean z5);

    void g() {
        if (this.f10491e) {
            return;
        }
        if (!androidx.core.view.H.P(this.f10487a)) {
            j();
            this.f10490d = false;
            return;
        }
        synchronized (this.f10488b) {
            try {
                if (!this.f10488b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f10489c);
                    this.f10489c.clear();
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        e eVar = (e) obj;
                        if (x.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f10489c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f10488b);
                    this.f10488b.clear();
                    this.f10489c.addAll(arrayList2);
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = arrayList2.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        Object obj2 = arrayList2.get(i6);
                        i6++;
                        ((e) obj2).l();
                    }
                    f(arrayList2, this.f10490d);
                    this.f10490d = false;
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        String str;
        String str2;
        if (x.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zP = androidx.core.view.H.P(this.f10487a);
        synchronized (this.f10488b) {
            try {
                q();
                ArrayList<e> arrayList = this.f10488b;
                int size = arrayList.size();
                int i5 = 0;
                int i6 = 0;
                while (i6 < size) {
                    e eVar = arrayList.get(i6);
                    i6++;
                    eVar.l();
                }
                ArrayList arrayList2 = new ArrayList(this.f10489c);
                int size2 = arrayList2.size();
                int i7 = 0;
                while (i7 < size2) {
                    Object obj = arrayList2.get(i7);
                    i7++;
                    e eVar2 = (e) obj;
                    if (x.F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zP) {
                            str2 = BuildConfig.FLAVOR;
                        } else {
                            str2 = "Container " + this.f10487a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(eVar2);
                        Log.v("FragmentManager", sb.toString());
                    }
                    eVar2.b();
                }
                ArrayList arrayList3 = new ArrayList(this.f10488b);
                int size3 = arrayList3.size();
                while (i5 < size3) {
                    Object obj2 = arrayList3.get(i5);
                    i5++;
                    e eVar3 = (e) obj2;
                    if (x.F0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zP) {
                            str = BuildConfig.FLAVOR;
                        } else {
                            str = "Container " + this.f10487a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(eVar3);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    eVar3.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.f10491e) {
            if (x.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f10491e = false;
            g();
        }
    }

    e.b l(E e6) {
        e eVarH = h(e6.k());
        e.b bVarG = eVarH != null ? eVarH.g() : null;
        e eVarI = i(e6.k());
        return (eVarI == null || !(bVarG == null || bVarG == e.b.NONE)) ? bVarG : eVarI.g();
    }

    public ViewGroup m() {
        return this.f10487a;
    }

    void p() {
        synchronized (this.f10488b) {
            try {
                q();
                this.f10491e = false;
                int size = this.f10488b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    e eVar = this.f10488b.get(size);
                    e.c cVarE = e.c.e(eVar.f().f10613I);
                    e.c cVarE2 = eVar.e();
                    e.c cVar = e.c.VISIBLE;
                    if (cVarE2 == cVar && cVarE != cVar) {
                        this.f10491e = eVar.f().l0();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z5) {
        this.f10490d = z5;
    }
}
