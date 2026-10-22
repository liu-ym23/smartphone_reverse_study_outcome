package p1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.view.N;
import androidx.dynamicanimation.animation.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p1.j;

/* loaded from: classes.dex */
public abstract class j implements Cloneable {

    /* renamed from: L, reason: collision with root package name */
    public static final Animator[] f38138L = new Animator[0];

    /* renamed from: M, reason: collision with root package name */
    public static final int[] f38139M = {2, 1, 3, 4};

    /* renamed from: N, reason: collision with root package name */
    public static final AbstractC5046g f38140N = new a();

    /* renamed from: O, reason: collision with root package name */
    public static ThreadLocal<androidx.collection.a<Animator, d>> f38141O = new ThreadLocal<>();

    /* renamed from: F, reason: collision with root package name */
    public e f38147F;

    /* renamed from: G, reason: collision with root package name */
    public androidx.collection.a<String, String> f38148G;

    /* renamed from: I, reason: collision with root package name */
    public long f38150I;

    /* renamed from: J, reason: collision with root package name */
    public g f38151J;

    /* renamed from: K, reason: collision with root package name */
    public long f38152K;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList<w> f38172t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList<w> f38173u;

    /* renamed from: v, reason: collision with root package name */
    public h[] f38174v;

    /* renamed from: a, reason: collision with root package name */
    public String f38153a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f38154b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f38155c = -1;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f38156d = null;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Integer> f38157e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<View> f38158f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<String> f38159g = null;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<Class<?>> f38160h = null;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<Integer> f38161i = null;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<View> f38162j = null;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<Class<?>> f38163k = null;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<String> f38164l = null;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<Integer> f38165m = null;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<View> f38166n = null;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<Class<?>> f38167o = null;

    /* renamed from: p, reason: collision with root package name */
    public x f38168p = new x();

    /* renamed from: q, reason: collision with root package name */
    public x f38169q = new x();

    /* renamed from: r, reason: collision with root package name */
    public u f38170r = null;

    /* renamed from: s, reason: collision with root package name */
    public int[] f38171s = f38139M;

    /* renamed from: w, reason: collision with root package name */
    public boolean f38175w = false;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<Animator> f38176x = new ArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    public Animator[] f38177y = f38138L;

    /* renamed from: z, reason: collision with root package name */
    public int f38178z = 0;

    /* renamed from: A, reason: collision with root package name */
    public boolean f38142A = false;

    /* renamed from: B, reason: collision with root package name */
    public boolean f38143B = false;

    /* renamed from: C, reason: collision with root package name */
    public j f38144C = null;

    /* renamed from: D, reason: collision with root package name */
    public ArrayList<h> f38145D = null;

    /* renamed from: E, reason: collision with root package name */
    public ArrayList<Animator> f38146E = new ArrayList<>();

    /* renamed from: H, reason: collision with root package name */
    public AbstractC5046g f38149H = f38140N;

    public class a extends AbstractC5046g {
        @Override // p1.AbstractC5046g
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f38179a;

        public b(androidx.collection.a aVar) {
            this.f38179a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f38179a.remove(animator);
            j.this.f38176x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j.this.f38176x.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j.this.w();
            animator.removeListener(this);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public View f38182a;

        /* renamed from: b, reason: collision with root package name */
        public String f38183b;

        /* renamed from: c, reason: collision with root package name */
        public w f38184c;

        /* renamed from: d, reason: collision with root package name */
        public WindowId f38185d;

        /* renamed from: e, reason: collision with root package name */
        public j f38186e;

        /* renamed from: f, reason: collision with root package name */
        public Animator f38187f;

        public d(View view, String str, j jVar, WindowId windowId, w wVar, Animator animator) {
            this.f38182a = view;
            this.f38183b = str;
            this.f38184c = wVar;
            this.f38185d = windowId;
            this.f38186e = jVar;
            this.f38187f = animator;
        }
    }

    public static abstract class e {
    }

    public static class f {
        public static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        public static void b(Animator animator, long j10) {
            ((AnimatorSet) animator).setCurrentPlayTime(j10);
        }
    }

    public class g extends q implements t, e.r {

        /* renamed from: d, reason: collision with root package name */
        public boolean f38191d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f38192e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.dynamicanimation.animation.i f38193f;

        /* renamed from: i, reason: collision with root package name */
        public Runnable f38196i;

        /* renamed from: a, reason: collision with root package name */
        public long f38188a = -1;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<B0.a<t>> f38189b = null;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<B0.a<t>> f38190c = null;

        /* renamed from: g, reason: collision with root package name */
        public B0.a<t>[] f38194g = null;

        /* renamed from: h, reason: collision with root package name */
        public final y f38195h = new y();

        public g() {
        }

        public static /* synthetic */ void m(g gVar, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
            if (z10) {
                gVar.getClass();
                return;
            }
            if (f10 >= 1.0f) {
                j.this.c0(i.f38199b, false);
                return;
            }
            long jD = gVar.d();
            j jVarY0 = ((u) j.this).y0(0);
            j jVar = jVarY0.f38144C;
            jVarY0.f38144C = null;
            j.this.l0(-1L, gVar.f38188a);
            j.this.l0(jD, -1L);
            gVar.f38188a = jD;
            Runnable runnable = gVar.f38196i;
            if (runnable != null) {
                runnable.run();
            }
            j.this.f38146E.clear();
            if (jVar != null) {
                jVar.c0(i.f38199b, true);
            }
        }

        @Override // p1.t
        public void a() {
            o();
            this.f38193f.w(d() + 1);
        }

        @Override // androidx.dynamicanimation.animation.e.r
        public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
            long jMax = Math.max(-1L, Math.min(d() + 1, Math.round(f10)));
            j.this.l0(jMax, this.f38188a);
            this.f38188a = jMax;
            n();
        }

        @Override // p1.q, p1.j.h
        public void c(j jVar) {
            this.f38192e = true;
        }

        @Override // p1.t
        public long d() {
            return j.this.O();
        }

        @Override // p1.t
        public void h(long j10) {
            if (this.f38193f != null) {
                throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
            }
            if (j10 == this.f38188a || !isReady()) {
                return;
            }
            if (!this.f38192e) {
                if (j10 != 0 || this.f38188a <= 0) {
                    long jD = d();
                    if (j10 == jD && this.f38188a < jD) {
                        j10 = 1 + jD;
                    }
                } else {
                    j10 = -1;
                }
                long j11 = this.f38188a;
                if (j10 != j11) {
                    j.this.l0(j10, j11);
                    this.f38188a = j10;
                }
            }
            n();
            this.f38195h.a(AnimationUtils.currentAnimationTimeMillis(), j10);
        }

        @Override // p1.t
        public boolean isReady() {
            return this.f38191d;
        }

        @Override // p1.t
        public void j(Runnable runnable) {
            this.f38196i = runnable;
            o();
            this.f38193f.w(0.0f);
        }

        public final void n() {
            ArrayList<B0.a<t>> arrayList = this.f38190c;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            int size = this.f38190c.size();
            if (this.f38194g == null) {
                this.f38194g = new B0.a[size];
            }
            B0.a<t>[] aVarArr = (B0.a[]) this.f38190c.toArray(this.f38194g);
            this.f38194g = null;
            for (int i10 = 0; i10 < size; i10++) {
                aVarArr[i10].accept(this);
                aVarArr[i10] = null;
            }
            this.f38194g = aVarArr;
        }

        public final void o() {
            if (this.f38193f != null) {
                return;
            }
            this.f38195h.a(AnimationUtils.currentAnimationTimeMillis(), this.f38188a);
            this.f38193f = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g());
            androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j();
            jVar.f(1.0f);
            jVar.h(200.0f);
            this.f38193f.B(jVar);
            this.f38193f.q(this.f38188a);
            this.f38193f.c(this);
            this.f38193f.r(this.f38195h.b());
            this.f38193f.m(d() + 1);
            this.f38193f.n(-1.0f);
            this.f38193f.o(4.0f);
            this.f38193f.b(new e.q() { // from class: p1.k
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    j.g.m(this.f38203a, eVar, z10, f10, f11);
                }
            });
        }

        public void p() {
            long j10 = d() == 0 ? 1L : 0L;
            j.this.l0(j10, this.f38188a);
            this.f38188a = j10;
        }

        public void q() {
            this.f38191d = true;
            ArrayList<B0.a<t>> arrayList = this.f38189b;
            if (arrayList != null) {
                this.f38189b = null;
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    arrayList.get(i10).accept(this);
                }
            }
            n();
        }
    }

    public interface h {
        void c(j jVar);

        void e(j jVar);

        void f(j jVar);

        default void g(j jVar, boolean z10) {
            f(jVar);
        }

        void i(j jVar);

        void k(j jVar);

        default void l(j jVar, boolean z10) {
            e(jVar);
        }
    }

    public interface i {

        /* renamed from: a, reason: collision with root package name */
        public static final i f38198a = new i() { // from class: p1.l
            @Override // p1.j.i
            public final void d(j.h hVar, j jVar, boolean z10) {
                hVar.l(jVar, z10);
            }
        };

        /* renamed from: b, reason: collision with root package name */
        public static final i f38199b = new i() { // from class: p1.m
            @Override // p1.j.i
            public final void d(j.h hVar, j jVar, boolean z10) {
                hVar.g(jVar, z10);
            }
        };

        /* renamed from: c, reason: collision with root package name */
        public static final i f38200c = new i() { // from class: p1.n
            @Override // p1.j.i
            public final void d(j.h hVar, j jVar, boolean z10) {
                hVar.c(jVar);
            }
        };

        /* renamed from: d, reason: collision with root package name */
        public static final i f38201d = new i() { // from class: p1.o
            @Override // p1.j.i
            public final void d(j.h hVar, j jVar, boolean z10) {
                hVar.i(jVar);
            }
        };

        /* renamed from: e, reason: collision with root package name */
        public static final i f38202e = new i() { // from class: p1.p
            @Override // p1.j.i
            public final void d(j.h hVar, j jVar, boolean z10) {
                hVar.k(jVar);
            }
        };

        void d(h hVar, j jVar, boolean z10);
    }

    public static androidx.collection.a<Animator, d> H() {
        androidx.collection.a<Animator, d> aVar = f38141O.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a<Animator, d> aVar2 = new androidx.collection.a<>();
        f38141O.set(aVar2);
        return aVar2;
    }

    public static boolean V(w wVar, w wVar2, String str) {
        Object obj = wVar.f38221a.get(str);
        Object obj2 = wVar2.f38221a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public static void i(x xVar, View view, w wVar) {
        xVar.f38224a.put(view, wVar);
        int id = view.getId();
        if (id >= 0) {
            if (xVar.f38225b.indexOfKey(id) >= 0) {
                xVar.f38225b.put(id, null);
            } else {
                xVar.f38225b.put(id, view);
            }
        }
        String strD = N.D(view);
        if (strD != null) {
            if (xVar.f38227d.containsKey(strD)) {
                xVar.f38227d.put(strD, null);
            } else {
                xVar.f38227d.put(strD, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (xVar.f38226c.i(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    xVar.f38226c.n(itemIdAtPosition, view);
                    return;
                }
                View viewH = xVar.f38226c.h(itemIdAtPosition);
                if (viewH != null) {
                    viewH.setHasTransientState(false);
                    xVar.f38226c.n(itemIdAtPosition, null);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r5 = r5.f38173u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5.f38172t;
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
    public p1.w B(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            p1.u r0 = r5.f38170r
            if (r0 == 0) goto L9
            p1.w r5 = r0.B(r6, r7)
            return r5
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList<p1.w> r0 = r5.f38172t
            goto L10
        Le:
            java.util.ArrayList<p1.w> r0 = r5.f38173u
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
            p1.w r4 = (p1.w) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f38222b
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
            java.util.ArrayList<p1.w> r5 = r5.f38173u
            goto L36
        L34:
            java.util.ArrayList<p1.w> r5 = r5.f38172t
        L36:
            java.lang.Object r5 = r5.get(r3)
            p1.w r5 = (p1.w) r5
            return r5
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.j.B(android.view.View, boolean):p1.w");
    }

    public String C() {
        return this.f38153a;
    }

    public AbstractC5046g D() {
        return this.f38149H;
    }

    public s E() {
        return null;
    }

    public final j F() {
        u uVar = this.f38170r;
        return uVar != null ? uVar.F() : this;
    }

    public long I() {
        return this.f38154b;
    }

    public List<Integer> K() {
        return this.f38157e;
    }

    public List<String> L() {
        return this.f38159g;
    }

    public List<Class<?>> M() {
        return this.f38160h;
    }

    public List<View> N() {
        return this.f38158f;
    }

    public final long O() {
        return this.f38150I;
    }

    public String[] P() {
        return null;
    }

    public w Q(View view, boolean z10) {
        u uVar = this.f38170r;
        if (uVar != null) {
            return uVar.Q(view, z10);
        }
        return (z10 ? this.f38168p : this.f38169q).f38224a.get(view);
    }

    public boolean R() {
        return !this.f38176x.isEmpty();
    }

    public boolean S() {
        return false;
    }

    public boolean T(w wVar, w wVar2) {
        if (wVar != null && wVar2 != null) {
            String[] strArrP = P();
            if (strArrP != null) {
                for (String str : strArrP) {
                    if (V(wVar, wVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator<String> it = wVar.f38221a.keySet().iterator();
                while (it.hasNext()) {
                    if (V(wVar, wVar2, it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean U(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f38161i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f38162j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f38163k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f38163k.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f38164l != null && N.D(view) != null && this.f38164l.contains(N.D(view))) {
            return false;
        }
        if ((this.f38157e.size() == 0 && this.f38158f.size() == 0 && (((arrayList = this.f38160h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f38159g) == null || arrayList2.isEmpty()))) || this.f38157e.contains(Integer.valueOf(id)) || this.f38158f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f38159g;
        if (arrayList6 != null && arrayList6.contains(N.D(view))) {
            return true;
        }
        if (this.f38160h != null) {
            for (int i11 = 0; i11 < this.f38160h.size(); i11++) {
                if (this.f38160h.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void W(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewValueAt = sparseArray.valueAt(i10);
            if (viewValueAt != null && U(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && U(view)) {
                w wVar = aVar.get(viewValueAt);
                w wVar2 = aVar2.get(view);
                if (wVar != null && wVar2 != null) {
                    this.f38172t.add(wVar);
                    this.f38173u.add(wVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void X(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2) {
        w wVarRemove;
        for (int size = aVar.getSize() - 1; size >= 0; size--) {
            View viewKeyAt = aVar.keyAt(size);
            if (viewKeyAt != null && U(viewKeyAt) && (wVarRemove = aVar2.remove(viewKeyAt)) != null && U(wVarRemove.f38222b)) {
                this.f38172t.add(aVar.removeAt(size));
                this.f38173u.add(wVarRemove);
            }
        }
    }

    public final void Y(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2, androidx.collection.j<View> jVar, androidx.collection.j<View> jVar2) {
        View viewH;
        int iR = jVar.r();
        for (int i10 = 0; i10 < iR; i10++) {
            View viewS = jVar.s(i10);
            if (viewS != null && U(viewS) && (viewH = jVar2.h(jVar.k(i10))) != null && U(viewH)) {
                w wVar = aVar.get(viewS);
                w wVar2 = aVar2.get(viewH);
                if (wVar != null && wVar2 != null) {
                    this.f38172t.add(wVar);
                    this.f38173u.add(wVar2);
                    aVar.remove(viewS);
                    aVar2.remove(viewH);
                }
            }
        }
    }

    public final void Z(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2, androidx.collection.a<String, View> aVar3, androidx.collection.a<String, View> aVar4) {
        View view;
        int size = aVar3.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            View viewValueAt = aVar3.valueAt(i10);
            if (viewValueAt != null && U(viewValueAt) && (view = aVar4.get(aVar3.keyAt(i10))) != null && U(view)) {
                w wVar = aVar.get(viewValueAt);
                w wVar2 = aVar2.get(view);
                if (wVar != null && wVar2 != null) {
                    this.f38172t.add(wVar);
                    this.f38173u.add(wVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void a0(x xVar, x xVar2) {
        androidx.collection.a<View, w> aVar = new androidx.collection.a<>(xVar.f38224a);
        androidx.collection.a<View, w> aVar2 = new androidx.collection.a<>(xVar2.f38224a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f38171s;
            if (i10 >= iArr.length) {
                h(aVar, aVar2);
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 1) {
                X(aVar, aVar2);
            } else if (i11 == 2) {
                Z(aVar, aVar2, xVar.f38227d, xVar2.f38227d);
            } else if (i11 == 3) {
                W(aVar, aVar2, xVar.f38225b, xVar2.f38225b);
            } else if (i11 == 4) {
                Y(aVar, aVar2, xVar.f38226c, xVar2.f38226c);
            }
            i10++;
        }
    }

    public final void b0(j jVar, i iVar, boolean z10) {
        j jVar2 = this.f38144C;
        if (jVar2 != null) {
            jVar2.b0(jVar, iVar, z10);
        }
        ArrayList<h> arrayList = this.f38145D;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f38145D.size();
        h[] hVarArr = this.f38174v;
        if (hVarArr == null) {
            hVarArr = new h[size];
        }
        this.f38174v = null;
        h[] hVarArr2 = (h[]) this.f38145D.toArray(hVarArr);
        for (int i10 = 0; i10 < size; i10++) {
            iVar.d(hVarArr2[i10], jVar, z10);
            hVarArr2[i10] = null;
        }
        this.f38174v = hVarArr2;
    }

    public void c0(i iVar, boolean z10) {
        b0(this, iVar, z10);
    }

    public void cancel() {
        int size = this.f38176x.size();
        Animator[] animatorArr = (Animator[]) this.f38176x.toArray(this.f38177y);
        this.f38177y = f38138L;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.cancel();
        }
        this.f38177y = animatorArr;
        c0(i.f38200c, false);
    }

    public void d0(View view) {
        if (this.f38143B) {
            return;
        }
        int size = this.f38176x.size();
        Animator[] animatorArr = (Animator[]) this.f38176x.toArray(this.f38177y);
        this.f38177y = f38138L;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.pause();
        }
        this.f38177y = animatorArr;
        c0(i.f38201d, false);
        this.f38142A = true;
    }

    public void e0(ViewGroup viewGroup) {
        d dVar;
        this.f38172t = new ArrayList<>();
        this.f38173u = new ArrayList<>();
        a0(this.f38168p, this.f38169q);
        androidx.collection.a<Animator, d> aVarH = H();
        int size = aVarH.getSize();
        WindowId windowId = viewGroup.getWindowId();
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animatorKeyAt = aVarH.keyAt(i10);
            if (animatorKeyAt != null && (dVar = aVarH.get(animatorKeyAt)) != null && dVar.f38182a != null && windowId.equals(dVar.f38185d)) {
                w wVar = dVar.f38184c;
                View view = dVar.f38182a;
                w wVarQ = Q(view, true);
                w wVarB = B(view, true);
                if (wVarQ == null && wVarB == null) {
                    wVarB = this.f38169q.f38224a.get(view);
                }
                if ((wVarQ != null || wVarB != null) && dVar.f38186e.T(wVar, wVarB)) {
                    j jVar = dVar.f38186e;
                    if (jVar.F().f38151J != null) {
                        animatorKeyAt.cancel();
                        jVar.f38176x.remove(animatorKeyAt);
                        aVarH.remove(animatorKeyAt);
                        if (jVar.f38176x.size() == 0) {
                            jVar.c0(i.f38200c, false);
                            if (!jVar.f38143B) {
                                jVar.f38143B = true;
                                jVar.c0(i.f38199b, false);
                            }
                        }
                    } else if (animatorKeyAt.isRunning() || animatorKeyAt.isStarted()) {
                        animatorKeyAt.cancel();
                    } else {
                        aVarH.remove(animatorKeyAt);
                    }
                }
            }
        }
        u(viewGroup, this.f38168p, this.f38169q, this.f38172t, this.f38173u);
        if (this.f38151J == null) {
            k0();
            return;
        }
        f0();
        this.f38151J.p();
        this.f38151J.q();
    }

    public j f(h hVar) {
        if (this.f38145D == null) {
            this.f38145D = new ArrayList<>();
        }
        this.f38145D.add(hVar);
        return this;
    }

    public void f0() {
        androidx.collection.a<Animator, d> aVarH = H();
        this.f38150I = 0L;
        for (int i10 = 0; i10 < this.f38146E.size(); i10++) {
            Animator animator = this.f38146E.get(i10);
            d dVar = aVarH.get(animator);
            if (animator != null && dVar != null) {
                if (x() >= 0) {
                    dVar.f38187f.setDuration(x());
                }
                if (I() >= 0) {
                    dVar.f38187f.setStartDelay(I() + dVar.f38187f.getStartDelay());
                }
                if (z() != null) {
                    dVar.f38187f.setInterpolator(z());
                }
                this.f38176x.add(animator);
                this.f38150I = Math.max(this.f38150I, f.a(animator));
            }
        }
        this.f38146E.clear();
    }

    public j g(View view) {
        this.f38158f.add(view);
        return this;
    }

    public j g0(h hVar) {
        j jVar;
        ArrayList<h> arrayList = this.f38145D;
        if (arrayList != null) {
            if (!arrayList.remove(hVar) && (jVar = this.f38144C) != null) {
                jVar.g0(hVar);
            }
            if (this.f38145D.size() == 0) {
                this.f38145D = null;
            }
        }
        return this;
    }

    public final void h(androidx.collection.a<View, w> aVar, androidx.collection.a<View, w> aVar2) {
        for (int i10 = 0; i10 < aVar.getSize(); i10++) {
            w wVarValueAt = aVar.valueAt(i10);
            if (U(wVarValueAt.f38222b)) {
                this.f38172t.add(wVarValueAt);
                this.f38173u.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.getSize(); i11++) {
            w wVarValueAt2 = aVar2.valueAt(i11);
            if (U(wVarValueAt2.f38222b)) {
                this.f38173u.add(wVarValueAt2);
                this.f38172t.add(null);
            }
        }
    }

    public j h0(View view) {
        this.f38158f.remove(view);
        return this;
    }

    public void i0(View view) {
        if (this.f38142A) {
            if (!this.f38143B) {
                int size = this.f38176x.size();
                Animator[] animatorArr = (Animator[]) this.f38176x.toArray(this.f38177y);
                this.f38177y = f38138L;
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    Animator animator = animatorArr[i10];
                    animatorArr[i10] = null;
                    animator.resume();
                }
                this.f38177y = animatorArr;
                c0(i.f38202e, false);
            }
            this.f38142A = false;
        }
    }

    public void j(Animator animator) {
        if (animator == null) {
            w();
            return;
        }
        if (x() >= 0) {
            animator.setDuration(x());
        }
        if (I() >= 0) {
            animator.setStartDelay(I() + animator.getStartDelay());
        }
        if (z() != null) {
            animator.setInterpolator(z());
        }
        animator.addListener(new c());
        animator.start();
    }

    public final void j0(Animator animator, androidx.collection.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            j(animator);
        }
    }

    public abstract void k(w wVar);

    public void k0() {
        s0();
        androidx.collection.a<Animator, d> aVarH = H();
        Iterator<Animator> it = this.f38146E.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (aVarH.containsKey(next)) {
                s0();
                j0(next, aVarH);
            }
        }
        this.f38146E.clear();
        w();
    }

    public void l0(long j10, long j11) {
        long jO = O();
        int i10 = 0;
        boolean z10 = j10 < j11;
        if ((j11 < 0 && j10 >= 0) || (j11 > jO && j10 <= jO)) {
            this.f38143B = false;
            c0(i.f38198a, z10);
        }
        int size = this.f38176x.size();
        Animator[] animatorArr = (Animator[]) this.f38176x.toArray(this.f38177y);
        this.f38177y = f38138L;
        while (i10 < size) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            f.b(animator, Math.min(Math.max(0L, j10), f.a(animator)));
            i10++;
            jO = jO;
        }
        long j12 = jO;
        this.f38177y = animatorArr;
        if ((j10 <= j12 || j11 > j12) && (j10 >= 0 || j11 < 0)) {
            return;
        }
        if (j10 > j12) {
            this.f38143B = true;
        }
        c0(i.f38199b, z10);
    }

    public j m0(long j10) {
        this.f38155c = j10;
        return this;
    }

    public final void n(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f38161i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f38162j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f38163k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f38163k.get(i10).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    w wVar = new w(view);
                    if (z10) {
                        p(wVar);
                    } else {
                        k(wVar);
                    }
                    wVar.f38223c.add(this);
                    o(wVar);
                    if (z10) {
                        i(this.f38168p, view, wVar);
                    } else {
                        i(this.f38169q, view, wVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f38165m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f38166n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f38167o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    if (this.f38167o.get(i11).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                n(viewGroup.getChildAt(i12), z10);
                            }
                        }
                    }
                }
            }
        }
    }

    public void n0(e eVar) {
        this.f38147F = eVar;
    }

    public void o(w wVar) {
    }

    public j o0(TimeInterpolator timeInterpolator) {
        this.f38156d = timeInterpolator;
        return this;
    }

    public abstract void p(w wVar);

    public void p0(AbstractC5046g abstractC5046g) {
        if (abstractC5046g == null) {
            this.f38149H = f38140N;
        } else {
            this.f38149H = abstractC5046g;
        }
    }

    public void q(ViewGroup viewGroup, boolean z10) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        androidx.collection.a<String, String> aVar;
        r(z10);
        if ((this.f38157e.size() > 0 || this.f38158f.size() > 0) && (((arrayList = this.f38159g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f38160h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f38157e.size(); i10++) {
                View viewFindViewById = viewGroup.findViewById(this.f38157e.get(i10).intValue());
                if (viewFindViewById != null) {
                    w wVar = new w(viewFindViewById);
                    if (z10) {
                        p(wVar);
                    } else {
                        k(wVar);
                    }
                    wVar.f38223c.add(this);
                    o(wVar);
                    if (z10) {
                        i(this.f38168p, viewFindViewById, wVar);
                    } else {
                        i(this.f38169q, viewFindViewById, wVar);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f38158f.size(); i11++) {
                View view = this.f38158f.get(i11);
                w wVar2 = new w(view);
                if (z10) {
                    p(wVar2);
                } else {
                    k(wVar2);
                }
                wVar2.f38223c.add(this);
                o(wVar2);
                if (z10) {
                    i(this.f38168p, view, wVar2);
                } else {
                    i(this.f38169q, view, wVar2);
                }
            }
        } else {
            n(viewGroup, z10);
        }
        if (z10 || (aVar = this.f38148G) == null) {
            return;
        }
        int size = aVar.getSize();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList3.add(this.f38168p.f38227d.remove(this.f38148G.keyAt(i12)));
        }
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = (View) arrayList3.get(i13);
            if (view2 != null) {
                this.f38168p.f38227d.put(this.f38148G.valueAt(i13), view2);
            }
        }
    }

    public void q0(s sVar) {
    }

    public void r(boolean z10) {
        if (z10) {
            this.f38168p.f38224a.clear();
            this.f38168p.f38225b.clear();
            this.f38168p.f38226c.a();
        } else {
            this.f38169q.f38224a.clear();
            this.f38169q.f38225b.clear();
            this.f38169q.f38226c.a();
        }
    }

    public j r0(long j10) {
        this.f38154b = j10;
        return this;
    }

    @Override // 
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public j clone() {
        try {
            j jVar = (j) super.clone();
            jVar.f38146E = new ArrayList<>();
            jVar.f38168p = new x();
            jVar.f38169q = new x();
            jVar.f38172t = null;
            jVar.f38173u = null;
            jVar.f38151J = null;
            jVar.f38144C = this;
            jVar.f38145D = null;
            return jVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void s0() {
        if (this.f38178z == 0) {
            c0(i.f38198a, false);
            this.f38143B = false;
        }
        this.f38178z++;
    }

    public Animator t(ViewGroup viewGroup, w wVar, w wVar2) {
        return null;
    }

    public String t0(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(": ");
        if (this.f38155c != -1) {
            sb2.append("dur(");
            sb2.append(this.f38155c);
            sb2.append(") ");
        }
        if (this.f38154b != -1) {
            sb2.append("dly(");
            sb2.append(this.f38154b);
            sb2.append(") ");
        }
        if (this.f38156d != null) {
            sb2.append("interp(");
            sb2.append(this.f38156d);
            sb2.append(") ");
        }
        if (this.f38157e.size() > 0 || this.f38158f.size() > 0) {
            sb2.append("tgts(");
            if (this.f38157e.size() > 0) {
                for (int i10 = 0; i10 < this.f38157e.size(); i10++) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(this.f38157e.get(i10));
                }
            }
            if (this.f38158f.size() > 0) {
                for (int i11 = 0; i11 < this.f38158f.size(); i11++) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(this.f38158f.get(i11));
                }
            }
            sb2.append(")");
        }
        return sb2.toString();
    }

    public String toString() {
        return t0("");
    }

    public void u(ViewGroup viewGroup, x xVar, x xVar2, ArrayList<w> arrayList, ArrayList<w> arrayList2) {
        View view;
        w wVar;
        Animator animator;
        Animator animator2;
        j jVar = this;
        androidx.collection.a<Animator, d> aVarH = H();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        boolean z10 = jVar.F().f38151J != null;
        for (int i10 = 0; i10 < size; i10++) {
            w wVar2 = arrayList.get(i10);
            w wVar3 = arrayList2.get(i10);
            if (wVar2 != null && !wVar2.f38223c.contains(jVar)) {
                wVar2 = null;
            }
            if (wVar3 != null && !wVar3.f38223c.contains(jVar)) {
                wVar3 = null;
            }
            if ((wVar2 != null || wVar3 != null) && (wVar2 == null || wVar3 == null || jVar.T(wVar2, wVar3))) {
                Animator animatorT = jVar.t(viewGroup, wVar2, wVar3);
                if (animatorT != null) {
                    if (wVar3 != null) {
                        view = wVar3.f38222b;
                        String[] strArrP = jVar.P();
                        if (strArrP != null && strArrP.length > 0) {
                            wVar = new w(view);
                            w wVar4 = xVar2.f38224a.get(view);
                            if (wVar4 != null) {
                                int i11 = 0;
                                while (i11 < strArrP.length) {
                                    Map<String, Object> map = wVar.f38221a;
                                    String[] strArr = strArrP;
                                    String str = strArr[i11];
                                    map.put(str, wVar4.f38221a.get(str));
                                    i11++;
                                    strArrP = strArr;
                                    animatorT = animatorT;
                                }
                            }
                            Animator animator3 = animatorT;
                            int size2 = aVarH.getSize();
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                d dVar = aVarH.get(aVarH.keyAt(i12));
                                if (dVar.f38184c != null && dVar.f38182a == view && dVar.f38183b.equals(C()) && dVar.f38184c.equals(wVar)) {
                                    animator2 = null;
                                    break;
                                }
                                i12++;
                            }
                        } else {
                            animator2 = animatorT;
                            wVar = null;
                        }
                        animatorT = animator2;
                    } else {
                        view = wVar2.f38222b;
                        wVar = null;
                    }
                    View view2 = view;
                    if (animatorT != null) {
                        Animator animator4 = animatorT;
                        jVar = this;
                        d dVar2 = new d(view2, C(), jVar, viewGroup.getWindowId(), wVar, animator4);
                        if (z10) {
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(animator4);
                            animator = animatorSet;
                        } else {
                            animator = animator4;
                        }
                        aVarH.put(animator, dVar2);
                        jVar.f38146E.add(animator);
                    } else {
                        jVar = this;
                    }
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int i13 = 0; i13 < sparseIntArray.size(); i13++) {
                d dVar3 = aVarH.get(jVar.f38146E.get(sparseIntArray.keyAt(i13)));
                dVar3.f38187f.setStartDelay((sparseIntArray.valueAt(i13) - Long.MAX_VALUE) + dVar3.f38187f.getStartDelay());
            }
        }
    }

    public t v() {
        g gVar = new g();
        this.f38151J = gVar;
        f(gVar);
        return this.f38151J;
    }

    public void w() {
        int i10 = this.f38178z - 1;
        this.f38178z = i10;
        if (i10 == 0) {
            c0(i.f38199b, false);
            for (int i11 = 0; i11 < this.f38168p.f38226c.r(); i11++) {
                View viewS = this.f38168p.f38226c.s(i11);
                if (viewS != null) {
                    viewS.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < this.f38169q.f38226c.r(); i12++) {
                View viewS2 = this.f38169q.f38226c.s(i12);
                if (viewS2 != null) {
                    viewS2.setHasTransientState(false);
                }
            }
            this.f38143B = true;
        }
    }

    public long x() {
        return this.f38155c;
    }

    public e y() {
        return this.f38147F;
    }

    public TimeInterpolator z() {
        return this.f38156d;
    }
}
