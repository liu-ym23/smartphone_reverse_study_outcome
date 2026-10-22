package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.core.view.H;
import androidx.transition.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.libpag.BuildConfig;
import q.C0933a;

/* loaded from: classes.dex */
public abstract class k implements Cloneable {

    /* renamed from: I, reason: collision with root package name */
    private static final Animator[] f11424I = new Animator[0];

    /* renamed from: J, reason: collision with root package name */
    private static final int[] f11425J = {2, 1, 3, 4};

    /* renamed from: K, reason: collision with root package name */
    private static final androidx.transition.g f11426K = new a();

    /* renamed from: L, reason: collision with root package name */
    private static ThreadLocal<C0933a<Animator, d>> f11427L = new ThreadLocal<>();

    /* renamed from: F, reason: collision with root package name */
    private e f11433F;

    /* renamed from: G, reason: collision with root package name */
    private C0933a<String, String> f11434G;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<v> f11455t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<v> f11456u;

    /* renamed from: v, reason: collision with root package name */
    private f[] f11457v;

    /* renamed from: a, reason: collision with root package name */
    private String f11436a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    private long f11437b = -1;

    /* renamed from: c, reason: collision with root package name */
    long f11438c = -1;

    /* renamed from: d, reason: collision with root package name */
    private TimeInterpolator f11439d = null;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<Integer> f11440e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    ArrayList<View> f11441f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<String> f11442g = null;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Class<?>> f11443h = null;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Integer> f11444i = null;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<View> f11445j = null;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<Class<?>> f11446k = null;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<String> f11447l = null;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<Integer> f11448m = null;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<View> f11449n = null;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<Class<?>> f11450o = null;

    /* renamed from: p, reason: collision with root package name */
    private w f11451p = new w();

    /* renamed from: q, reason: collision with root package name */
    private w f11452q = new w();

    /* renamed from: r, reason: collision with root package name */
    t f11453r = null;

    /* renamed from: s, reason: collision with root package name */
    private int[] f11454s = f11425J;

    /* renamed from: w, reason: collision with root package name */
    boolean f11458w = false;

    /* renamed from: x, reason: collision with root package name */
    ArrayList<Animator> f11459x = new ArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    private Animator[] f11460y = f11424I;

    /* renamed from: z, reason: collision with root package name */
    int f11461z = 0;

    /* renamed from: A, reason: collision with root package name */
    private boolean f11428A = false;

    /* renamed from: B, reason: collision with root package name */
    boolean f11429B = false;

    /* renamed from: C, reason: collision with root package name */
    private k f11430C = null;

    /* renamed from: D, reason: collision with root package name */
    private ArrayList<f> f11431D = null;

    /* renamed from: E, reason: collision with root package name */
    ArrayList<Animator> f11432E = new ArrayList<>();

    /* renamed from: H, reason: collision with root package name */
    private androidx.transition.g f11435H = f11426K;

    class a extends androidx.transition.g {
        a() {
        }

        @Override // androidx.transition.g
        public Path a(float f5, float f6, float f7, float f8) {
            Path path = new Path();
            path.moveTo(f5, f6);
            path.lineTo(f7, f8);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0933a f11462a;

        b(C0933a c0933a) {
            this.f11462a = c0933a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11462a.remove(animator);
            k.this.f11459x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            k.this.f11459x.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.this.u();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        View f11465a;

        /* renamed from: b, reason: collision with root package name */
        String f11466b;

        /* renamed from: c, reason: collision with root package name */
        v f11467c;

        /* renamed from: d, reason: collision with root package name */
        WindowId f11468d;

        /* renamed from: e, reason: collision with root package name */
        k f11469e;

        /* renamed from: f, reason: collision with root package name */
        Animator f11470f;

        d(View view, String str, k kVar, WindowId windowId, v vVar, Animator animator) {
            this.f11465a = view;
            this.f11466b = str;
            this.f11467c = vVar;
            this.f11468d = windowId;
            this.f11469e = kVar;
            this.f11470f = animator;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(k kVar);

        void b(k kVar);

        default void c(k kVar, boolean z5) {
            d(kVar);
        }

        void d(k kVar);

        void e(k kVar);

        default void f(k kVar, boolean z5) {
            a(kVar);
        }

        void g(k kVar);
    }

    interface g {

        /* renamed from: a, reason: collision with root package name */
        public static final g f11471a = new g() { // from class: androidx.transition.l
            @Override // androidx.transition.k.g
            public final void a(k.f fVar, k kVar, boolean z5) {
                fVar.f(kVar, z5);
            }
        };

        /* renamed from: b, reason: collision with root package name */
        public static final g f11472b = new g() { // from class: androidx.transition.m
            @Override // androidx.transition.k.g
            public final void a(k.f fVar, k kVar, boolean z5) {
                fVar.c(kVar, z5);
            }
        };

        /* renamed from: c, reason: collision with root package name */
        public static final g f11473c = new g() { // from class: androidx.transition.n
            @Override // androidx.transition.k.g
            public final void a(k.f fVar, k kVar, boolean z5) {
                fVar.e(kVar);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        public static final g f11474d = new g() { // from class: androidx.transition.o
            @Override // androidx.transition.k.g
            public final void a(k.f fVar, k kVar, boolean z5) {
                fVar.b(kVar);
            }
        };

        /* renamed from: e, reason: collision with root package name */
        public static final g f11475e = new g() { // from class: androidx.transition.p
            @Override // androidx.transition.k.g
            public final void a(k.f fVar, k kVar, boolean z5) {
                fVar.g(kVar);
            }
        };

        void a(f fVar, k kVar, boolean z5);
    }

    private static C0933a<Animator, d> D() {
        C0933a<Animator, d> c0933a = f11427L.get();
        if (c0933a != null) {
            return c0933a;
        }
        C0933a<Animator, d> c0933a2 = new C0933a<>();
        f11427L.set(c0933a2);
        return c0933a2;
    }

    private static boolean N(v vVar, v vVar2, String str) {
        Object obj = vVar.f11492a.get(str);
        Object obj2 = vVar2.f11492a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void O(C0933a<View, v> c0933a, C0933a<View, v> c0933a2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            View viewValueAt = sparseArray.valueAt(i5);
            if (viewValueAt != null && M(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i5))) != null && M(view)) {
                v vVar = c0933a.get(viewValueAt);
                v vVar2 = c0933a2.get(view);
                if (vVar != null && vVar2 != null) {
                    this.f11455t.add(vVar);
                    this.f11456u.add(vVar2);
                    c0933a.remove(viewValueAt);
                    c0933a2.remove(view);
                }
            }
        }
    }

    private void P(C0933a<View, v> c0933a, C0933a<View, v> c0933a2) {
        v vVarRemove;
        for (int size = c0933a.size() - 1; size >= 0; size--) {
            View viewF = c0933a.f(size);
            if (viewF != null && M(viewF) && (vVarRemove = c0933a2.remove(viewF)) != null && M(vVarRemove.f11493b)) {
                this.f11455t.add(c0933a.h(size));
                this.f11456u.add(vVarRemove);
            }
        }
    }

    private void Q(C0933a<View, v> c0933a, C0933a<View, v> c0933a2, q.f<View> fVar, q.f<View> fVar2) {
        View viewG;
        int iP = fVar.p();
        for (int i5 = 0; i5 < iP; i5++) {
            View viewQ = fVar.q(i5);
            if (viewQ != null && M(viewQ) && (viewG = fVar2.g(fVar.i(i5))) != null && M(viewG)) {
                v vVar = c0933a.get(viewQ);
                v vVar2 = c0933a2.get(viewG);
                if (vVar != null && vVar2 != null) {
                    this.f11455t.add(vVar);
                    this.f11456u.add(vVar2);
                    c0933a.remove(viewQ);
                    c0933a2.remove(viewG);
                }
            }
        }
    }

    private void R(C0933a<View, v> c0933a, C0933a<View, v> c0933a2, C0933a<String, View> c0933a3, C0933a<String, View> c0933a4) {
        View view;
        int size = c0933a3.size();
        for (int i5 = 0; i5 < size; i5++) {
            View viewJ = c0933a3.j(i5);
            if (viewJ != null && M(viewJ) && (view = c0933a4.get(c0933a3.f(i5))) != null && M(view)) {
                v vVar = c0933a.get(viewJ);
                v vVar2 = c0933a2.get(view);
                if (vVar != null && vVar2 != null) {
                    this.f11455t.add(vVar);
                    this.f11456u.add(vVar2);
                    c0933a.remove(viewJ);
                    c0933a2.remove(view);
                }
            }
        }
    }

    private void S(w wVar, w wVar2) {
        C0933a<View, v> c0933a = new C0933a<>(wVar.f11495a);
        C0933a<View, v> c0933a2 = new C0933a<>(wVar2.f11495a);
        int i5 = 0;
        while (true) {
            int[] iArr = this.f11454s;
            if (i5 >= iArr.length) {
                e(c0933a, c0933a2);
                return;
            }
            int i6 = iArr[i5];
            if (i6 == 1) {
                P(c0933a, c0933a2);
            } else if (i6 == 2) {
                R(c0933a, c0933a2, wVar.f11498d, wVar2.f11498d);
            } else if (i6 == 3) {
                O(c0933a, c0933a2, wVar.f11496b, wVar2.f11496b);
            } else if (i6 == 4) {
                Q(c0933a, c0933a2, wVar.f11497c, wVar2.f11497c);
            }
            i5++;
        }
    }

    private void T(k kVar, g gVar, boolean z5) {
        k kVar2 = this.f11430C;
        if (kVar2 != null) {
            kVar2.T(kVar, gVar, z5);
        }
        ArrayList<f> arrayList = this.f11431D;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f11431D.size();
        f[] fVarArr = this.f11457v;
        if (fVarArr == null) {
            fVarArr = new f[size];
        }
        this.f11457v = null;
        f[] fVarArr2 = (f[]) this.f11431D.toArray(fVarArr);
        for (int i5 = 0; i5 < size; i5++) {
            gVar.a(fVarArr2[i5], kVar, z5);
            fVarArr2[i5] = null;
        }
        this.f11457v = fVarArr2;
    }

    private void a0(Animator animator, C0933a<Animator, d> c0933a) {
        if (animator != null) {
            animator.addListener(new b(c0933a));
            h(animator);
        }
    }

    private void e(C0933a<View, v> c0933a, C0933a<View, v> c0933a2) {
        for (int i5 = 0; i5 < c0933a.size(); i5++) {
            v vVarJ = c0933a.j(i5);
            if (M(vVarJ.f11493b)) {
                this.f11455t.add(vVarJ);
                this.f11456u.add(null);
            }
        }
        for (int i6 = 0; i6 < c0933a2.size(); i6++) {
            v vVarJ2 = c0933a2.j(i6);
            if (M(vVarJ2.f11493b)) {
                this.f11456u.add(vVarJ2);
                this.f11455t.add(null);
            }
        }
    }

    private static void g(w wVar, View view, v vVar) {
        wVar.f11495a.put(view, vVar);
        int id = view.getId();
        if (id >= 0) {
            if (wVar.f11496b.indexOfKey(id) >= 0) {
                wVar.f11496b.put(id, null);
            } else {
                wVar.f11496b.put(id, view);
            }
        }
        String strF = H.F(view);
        if (strF != null) {
            if (wVar.f11498d.containsKey(strF)) {
                wVar.f11498d.put(strF, null);
            } else {
                wVar.f11498d.put(strF, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (wVar.f11497c.h(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    wVar.f11497c.j(itemIdAtPosition, view);
                    return;
                }
                View viewG = wVar.f11497c.g(itemIdAtPosition);
                if (viewG != null) {
                    viewG.setHasTransientState(false);
                    wVar.f11497c.j(itemIdAtPosition, null);
                }
            }
        }
    }

    private void j(View view, boolean z5) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f11444i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f11445j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f11446k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        if (this.f11446k.get(i5).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    v vVar = new v(view);
                    if (z5) {
                        l(vVar);
                    } else {
                        i(vVar);
                    }
                    vVar.f11494c.add(this);
                    k(vVar);
                    if (z5) {
                        g(this.f11451p, view, vVar);
                    } else {
                        g(this.f11452q, view, vVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f11448m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f11449n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f11450o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    if (this.f11450o.get(i6).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                                j(viewGroup.getChildAt(i7), z5);
                            }
                        }
                    }
                }
            }
        }
    }

    public androidx.transition.g A() {
        return this.f11435H;
    }

    public s B() {
        return null;
    }

    public final k C() {
        t tVar = this.f11453r;
        return tVar != null ? tVar.C() : this;
    }

    public long E() {
        return this.f11437b;
    }

    public List<Integer> F() {
        return this.f11440e;
    }

    public List<String> G() {
        return this.f11442g;
    }

    public List<Class<?>> H() {
        return this.f11443h;
    }

    public List<View> I() {
        return this.f11441f;
    }

    public String[] J() {
        return null;
    }

    public v K(View view, boolean z5) {
        t tVar = this.f11453r;
        if (tVar != null) {
            return tVar.K(view, z5);
        }
        return (z5 ? this.f11451p : this.f11452q).f11495a.get(view);
    }

    public boolean L(v vVar, v vVar2) {
        if (vVar != null && vVar2 != null) {
            String[] strArrJ = J();
            if (strArrJ != null) {
                for (String str : strArrJ) {
                    if (N(vVar, vVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator<String> it = vVar.f11492a.keySet().iterator();
                while (it.hasNext()) {
                    if (N(vVar, vVar2, it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean M(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f11444i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f11445j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f11446k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.f11446k.get(i5).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f11447l != null && H.F(view) != null && this.f11447l.contains(H.F(view))) {
            return false;
        }
        if ((this.f11440e.size() == 0 && this.f11441f.size() == 0 && (((arrayList = this.f11443h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f11442g) == null || arrayList2.isEmpty()))) || this.f11440e.contains(Integer.valueOf(id)) || this.f11441f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f11442g;
        if (arrayList6 != null && arrayList6.contains(H.F(view))) {
            return true;
        }
        if (this.f11443h != null) {
            for (int i6 = 0; i6 < this.f11443h.size(); i6++) {
                if (this.f11443h.get(i6).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    void U(g gVar, boolean z5) {
        T(this, gVar, z5);
    }

    public void V(View view) {
        if (this.f11429B) {
            return;
        }
        int size = this.f11459x.size();
        Animator[] animatorArr = (Animator[]) this.f11459x.toArray(this.f11460y);
        this.f11460y = f11424I;
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator animator = animatorArr[i5];
            animatorArr[i5] = null;
            animator.pause();
        }
        this.f11460y = animatorArr;
        U(g.f11474d, false);
        this.f11428A = true;
    }

    void W(ViewGroup viewGroup) {
        d dVar;
        this.f11455t = new ArrayList<>();
        this.f11456u = new ArrayList<>();
        S(this.f11451p, this.f11452q);
        C0933a<Animator, d> c0933aD = D();
        int size = c0933aD.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator animatorF = c0933aD.f(i5);
            if (animatorF != null && (dVar = c0933aD.get(animatorF)) != null && dVar.f11465a != null && windowId.equals(dVar.f11468d)) {
                v vVar = dVar.f11467c;
                View view = dVar.f11465a;
                v vVarK = K(view, true);
                v vVarY = y(view, true);
                if (vVarK == null && vVarY == null) {
                    vVarY = this.f11452q.f11495a.get(view);
                }
                if ((vVarK != null || vVarY != null) && dVar.f11469e.L(vVar, vVarY)) {
                    dVar.f11469e.C().getClass();
                    if (animatorF.isRunning() || animatorF.isStarted()) {
                        animatorF.cancel();
                    } else {
                        c0933aD.remove(animatorF);
                    }
                }
            }
        }
        t(viewGroup, this.f11451p, this.f11452q, this.f11455t, this.f11456u);
        b0();
    }

    public k X(f fVar) {
        k kVar;
        ArrayList<f> arrayList = this.f11431D;
        if (arrayList != null) {
            if (!arrayList.remove(fVar) && (kVar = this.f11430C) != null) {
                kVar.X(fVar);
            }
            if (this.f11431D.size() == 0) {
                this.f11431D = null;
            }
        }
        return this;
    }

    public k Y(View view) {
        this.f11441f.remove(view);
        return this;
    }

    public void Z(View view) {
        if (this.f11428A) {
            if (!this.f11429B) {
                int size = this.f11459x.size();
                Animator[] animatorArr = (Animator[]) this.f11459x.toArray(this.f11460y);
                this.f11460y = f11424I;
                for (int i5 = size - 1; i5 >= 0; i5--) {
                    Animator animator = animatorArr[i5];
                    animatorArr[i5] = null;
                    animator.resume();
                }
                this.f11460y = animatorArr;
                U(g.f11475e, false);
            }
            this.f11428A = false;
        }
    }

    public k b(f fVar) {
        if (this.f11431D == null) {
            this.f11431D = new ArrayList<>();
        }
        this.f11431D.add(fVar);
        return this;
    }

    protected void b0() {
        i0();
        C0933a<Animator, d> c0933aD = D();
        ArrayList<Animator> arrayList = this.f11432E;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Animator animator = arrayList.get(i5);
            i5++;
            Animator animator2 = animator;
            if (c0933aD.containsKey(animator2)) {
                i0();
                a0(animator2, c0933aD);
            }
        }
        this.f11432E.clear();
        u();
    }

    public k c0(long j5) {
        this.f11438c = j5;
        return this;
    }

    protected void cancel() {
        int size = this.f11459x.size();
        Animator[] animatorArr = (Animator[]) this.f11459x.toArray(this.f11460y);
        this.f11460y = f11424I;
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator animator = animatorArr[i5];
            animatorArr[i5] = null;
            animator.cancel();
        }
        this.f11460y = animatorArr;
        U(g.f11473c, false);
    }

    public k d(View view) {
        this.f11441f.add(view);
        return this;
    }

    public void d0(e eVar) {
        this.f11433F = eVar;
    }

    public k e0(TimeInterpolator timeInterpolator) {
        this.f11439d = timeInterpolator;
        return this;
    }

    public void f0(androidx.transition.g gVar) {
        if (gVar == null) {
            this.f11435H = f11426K;
        } else {
            this.f11435H = gVar;
        }
    }

    public void g0(s sVar) {
    }

    protected void h(Animator animator) {
        if (animator == null) {
            u();
            return;
        }
        if (v() >= 0) {
            animator.setDuration(v());
        }
        if (E() >= 0) {
            animator.setStartDelay(E() + animator.getStartDelay());
        }
        if (x() != null) {
            animator.setInterpolator(x());
        }
        animator.addListener(new c());
        animator.start();
    }

    public k h0(long j5) {
        this.f11437b = j5;
        return this;
    }

    public abstract void i(v vVar);

    protected void i0() {
        if (this.f11461z == 0) {
            U(g.f11471a, false);
            this.f11429B = false;
        }
        this.f11461z++;
    }

    String j0(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f11438c != -1) {
            sb.append("dur(");
            sb.append(this.f11438c);
            sb.append(") ");
        }
        if (this.f11437b != -1) {
            sb.append("dly(");
            sb.append(this.f11437b);
            sb.append(") ");
        }
        if (this.f11439d != null) {
            sb.append("interp(");
            sb.append(this.f11439d);
            sb.append(") ");
        }
        if (this.f11440e.size() > 0 || this.f11441f.size() > 0) {
            sb.append("tgts(");
            if (this.f11440e.size() > 0) {
                for (int i5 = 0; i5 < this.f11440e.size(); i5++) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f11440e.get(i5));
                }
            }
            if (this.f11441f.size() > 0) {
                for (int i6 = 0; i6 < this.f11441f.size(); i6++) {
                    if (i6 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f11441f.get(i6));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    void k(v vVar) {
    }

    public abstract void l(v vVar);

    void n(ViewGroup viewGroup, boolean z5) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        C0933a<String, String> c0933a;
        p(z5);
        if ((this.f11440e.size() > 0 || this.f11441f.size() > 0) && (((arrayList = this.f11442g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f11443h) == null || arrayList2.isEmpty()))) {
            for (int i5 = 0; i5 < this.f11440e.size(); i5++) {
                View viewFindViewById = viewGroup.findViewById(this.f11440e.get(i5).intValue());
                if (viewFindViewById != null) {
                    v vVar = new v(viewFindViewById);
                    if (z5) {
                        l(vVar);
                    } else {
                        i(vVar);
                    }
                    vVar.f11494c.add(this);
                    k(vVar);
                    if (z5) {
                        g(this.f11451p, viewFindViewById, vVar);
                    } else {
                        g(this.f11452q, viewFindViewById, vVar);
                    }
                }
            }
            for (int i6 = 0; i6 < this.f11441f.size(); i6++) {
                View view = this.f11441f.get(i6);
                v vVar2 = new v(view);
                if (z5) {
                    l(vVar2);
                } else {
                    i(vVar2);
                }
                vVar2.f11494c.add(this);
                k(vVar2);
                if (z5) {
                    g(this.f11451p, view, vVar2);
                } else {
                    g(this.f11452q, view, vVar2);
                }
            }
        } else {
            j(viewGroup, z5);
        }
        if (z5 || (c0933a = this.f11434G) == null) {
            return;
        }
        int size = c0933a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            arrayList3.add(this.f11451p.f11498d.remove(this.f11434G.f(i7)));
        }
        for (int i8 = 0; i8 < size; i8++) {
            View view2 = (View) arrayList3.get(i8);
            if (view2 != null) {
                this.f11451p.f11498d.put(this.f11434G.j(i8), view2);
            }
        }
    }

    void p(boolean z5) {
        if (z5) {
            this.f11451p.f11495a.clear();
            this.f11451p.f11496b.clear();
            this.f11451p.f11497c.b();
        } else {
            this.f11452q.f11495a.clear();
            this.f11452q.f11496b.clear();
            this.f11452q.f11497c.b();
        }
    }

    @Override // 
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public k clone() {
        try {
            k kVar = (k) super.clone();
            kVar.f11432E = new ArrayList<>();
            kVar.f11451p = new w();
            kVar.f11452q = new w();
            kVar.f11455t = null;
            kVar.f11456u = null;
            kVar.f11430C = this;
            kVar.f11431D = null;
            return kVar;
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    public Animator s(ViewGroup viewGroup, v vVar, v vVar2) {
        return null;
    }

    void t(ViewGroup viewGroup, w wVar, w wVar2, ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        View view;
        Animator animator;
        v vVar;
        View view2;
        Animator animator2;
        C0933a<Animator, d> c0933aD = D();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        C().getClass();
        for (int i5 = 0; i5 < size; i5++) {
            v vVar2 = arrayList.get(i5);
            v vVar3 = arrayList2.get(i5);
            if (vVar2 != null && !vVar2.f11494c.contains(this)) {
                vVar2 = null;
            }
            if (vVar3 != null && !vVar3.f11494c.contains(this)) {
                vVar3 = null;
            }
            if ((vVar2 != null || vVar3 != null) && (vVar2 == null || vVar3 == null || L(vVar2, vVar3))) {
                Animator animatorS = s(viewGroup, vVar2, vVar3);
                if (animatorS != null) {
                    if (vVar3 != null) {
                        View view3 = vVar3.f11493b;
                        String[] strArrJ = J();
                        if (strArrJ != null && strArrJ.length > 0) {
                            vVar = new v(view3);
                            v vVar4 = wVar2.f11495a.get(view3);
                            if (vVar4 != null) {
                                int i6 = 0;
                                while (i6 < strArrJ.length) {
                                    Map<String, Object> map = vVar.f11492a;
                                    String[] strArr = strArrJ;
                                    String str = strArr[i6];
                                    map.put(str, vVar4.f11492a.get(str));
                                    i6++;
                                    strArrJ = strArr;
                                }
                            }
                            int size2 = c0933aD.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size2) {
                                    view2 = view3;
                                    animator2 = animatorS;
                                    break;
                                }
                                d dVar = c0933aD.get(c0933aD.f(i7));
                                if (dVar.f11467c != null && dVar.f11465a == view3) {
                                    view2 = view3;
                                    if (dVar.f11466b.equals(z()) && dVar.f11467c.equals(vVar)) {
                                        animator2 = null;
                                        break;
                                    }
                                } else {
                                    view2 = view3;
                                }
                                i7++;
                                view3 = view2;
                            }
                        } else {
                            view2 = view3;
                            animator2 = animatorS;
                            vVar = null;
                        }
                        animator = animator2;
                        view = view2;
                    } else {
                        view = vVar2.f11493b;
                        animator = animatorS;
                        vVar = null;
                    }
                    if (animator != null) {
                        c0933aD.put(animator, new d(view, z(), this, viewGroup.getWindowId(), vVar, animator));
                        this.f11432E.add(animator);
                    }
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                d dVar2 = c0933aD.get(this.f11432E.get(sparseIntArray.keyAt(i8)));
                dVar2.f11470f.setStartDelay((sparseIntArray.valueAt(i8) - Long.MAX_VALUE) + dVar2.f11470f.getStartDelay());
            }
        }
    }

    public String toString() {
        return j0(BuildConfig.FLAVOR);
    }

    protected void u() {
        int i5 = this.f11461z - 1;
        this.f11461z = i5;
        if (i5 == 0) {
            U(g.f11472b, false);
            for (int i6 = 0; i6 < this.f11451p.f11497c.p(); i6++) {
                View viewQ = this.f11451p.f11497c.q(i6);
                if (viewQ != null) {
                    viewQ.setHasTransientState(false);
                }
            }
            for (int i7 = 0; i7 < this.f11452q.f11497c.p(); i7++) {
                View viewQ2 = this.f11452q.f11497c.q(i7);
                if (viewQ2 != null) {
                    viewQ2.setHasTransientState(false);
                }
            }
            this.f11429B = true;
        }
    }

    public long v() {
        return this.f11438c;
    }

    public e w() {
        return this.f11433F;
    }

    public TimeInterpolator x() {
        return this.f11439d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r5 = r5.f11456u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5.f11455t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.transition.v y(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            androidx.transition.t r0 = r5.f11453r
            if (r0 == 0) goto L9
            androidx.transition.v r5 = r0.y(r6, r7)
            return r5
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList<androidx.transition.v> r0 = r5.f11455t
            goto L10
        Le:
            java.util.ArrayList<androidx.transition.v> r0 = r5.f11456u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            androidx.transition.v r4 = (androidx.transition.v) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f11493b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList<androidx.transition.v> r5 = r5.f11456u
            goto L36
        L34:
            java.util.ArrayList<androidx.transition.v> r5 = r5.f11455t
        L36:
            java.lang.Object r5 = r5.get(r3)
            androidx.transition.v r5 = (androidx.transition.v) r5
            return r5
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.k.y(android.view.View, boolean):androidx.transition.v");
    }

    public String z() {
        return this.f11436a;
    }
}
