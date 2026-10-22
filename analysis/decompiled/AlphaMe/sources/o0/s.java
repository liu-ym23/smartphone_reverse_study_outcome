package o0;

import K.C0073e;
import K.S;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.appcompat.widget.C0195d;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.LongCompanionObject;
import r.AbstractC0827a;

/* loaded from: classes.dex */
public abstract class s implements Cloneable {

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f13753k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f13754l;

    /* renamed from: m, reason: collision with root package name */
    public q[] f13755m;

    /* renamed from: v, reason: collision with root package name */
    public AbstractC0557a f13764v;

    /* renamed from: x, reason: collision with root package name */
    public static final Animator[] f13740x = new Animator[0];

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f13741y = {2, 1, 3, 4};

    /* renamed from: z, reason: collision with root package name */
    public static final E3.b f13742z = new E3.b();

    /* renamed from: A, reason: collision with root package name */
    public static final ThreadLocal f13739A = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final String f13743a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f13744b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f13745c = -1;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f13746d = null;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f13747e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f13748f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public t.d f13749g = new t.d(5);

    /* renamed from: h, reason: collision with root package name */
    public t.d f13750h = new t.d(5);

    /* renamed from: i, reason: collision with root package name */
    public y f13751i = null;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f13752j = f13741y;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f13756n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public Animator[] f13757o = f13740x;

    /* renamed from: p, reason: collision with root package name */
    public int f13758p = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13759q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13760r = false;

    /* renamed from: s, reason: collision with root package name */
    public s f13761s = null;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f13762t = null;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f13763u = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public E3.b f13765w = f13742z;

    public static void c(t.d dVar, View view, C0785A c0785a) {
        ((q.f) dVar.f15273a).put(view, c0785a);
        int id = view.getId();
        if (id >= 0) {
            if (((SparseArray) dVar.f15274b).indexOfKey(id) >= 0) {
                ((SparseArray) dVar.f15274b).put(id, null);
            } else {
                ((SparseArray) dVar.f15274b).put(id, view);
            }
        }
        WeakHashMap weakHashMap = S.f939a;
        String strK = K.J.k(view);
        if (strK != null) {
            if (((q.f) dVar.f15276d).containsKey(strK)) {
                ((q.f) dVar.f15276d).put(strK, null);
            } else {
                ((q.f) dVar.f15276d).put(strK, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                q.i iVar = (q.i) dVar.f15275c;
                if (iVar.f13957a) {
                    int i4 = iVar.f13960d;
                    long[] jArr = iVar.f13958b;
                    Object[] objArr = iVar.f13959c;
                    int i5 = 0;
                    for (int i6 = 0; i6 < i4; i6++) {
                        Object obj = objArr[i6];
                        if (obj != q.j.f13961a) {
                            if (i6 != i5) {
                                jArr[i5] = jArr[i6];
                                objArr[i5] = obj;
                                objArr[i6] = null;
                            }
                            i5++;
                        }
                    }
                    iVar.f13957a = false;
                    iVar.f13960d = i5;
                }
                if (AbstractC0827a.b(iVar.f13958b, iVar.f13960d, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    ((q.i) dVar.f15275c).f(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) ((q.i) dVar.f15275c).d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    ((q.i) dVar.f15275c).f(itemIdAtPosition, null);
                }
            }
        }
    }

    public static q.f p() {
        ThreadLocal threadLocal = f13739A;
        q.f fVar = (q.f) threadLocal.get();
        if (fVar != null) {
            return fVar;
        }
        q.f fVar2 = new q.f();
        threadLocal.set(fVar2);
        return fVar2;
    }

    public static boolean v(C0785A c0785a, C0785A c0785a2, String str) {
        Object obj = c0785a.f13673a.get(str);
        Object obj2 = c0785a2.f13673a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(ViewGroup viewGroup) {
        if (this.f13759q) {
            if (!this.f13760r) {
                ArrayList arrayList = this.f13756n;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f13757o);
                this.f13757o = f13740x;
                for (int i4 = size - 1; i4 >= 0; i4--) {
                    Animator animator = animatorArr[i4];
                    animatorArr[i4] = null;
                    animator.resume();
                }
                this.f13757o = animatorArr;
                w(this, r.f13738j0);
            }
            this.f13759q = false;
        }
    }

    public void B() {
        I();
        q.f fVarP = p();
        Iterator it = this.f13763u.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (fVarP.containsKey(animator)) {
                I();
                if (animator != null) {
                    animator.addListener(new o(this, fVarP));
                    long j4 = this.f13745c;
                    if (j4 >= 0) {
                        animator.setDuration(j4);
                    }
                    long j5 = this.f13744b;
                    if (j5 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j5);
                    }
                    TimeInterpolator timeInterpolator = this.f13746d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new C0195d(1, this));
                    animator.start();
                }
            }
        }
        this.f13763u.clear();
        m();
    }

    public void C(long j4) {
        this.f13745c = j4;
    }

    public void D(AbstractC0557a abstractC0557a) {
        this.f13764v = abstractC0557a;
    }

    public void E(TimeInterpolator timeInterpolator) {
        this.f13746d = timeInterpolator;
    }

    public void F(E3.b bVar) {
        if (bVar == null) {
            this.f13765w = f13742z;
        } else {
            this.f13765w = bVar;
        }
    }

    public void G() {
    }

    public void H(long j4) {
        this.f13744b = j4;
    }

    public final void I() {
        if (this.f13758p == 0) {
            w(this, r.f13734f0);
            this.f13760r = false;
        }
        this.f13758p++;
    }

    public String J(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f13745c != -1) {
            sb.append("dur(");
            sb.append(this.f13745c);
            sb.append(") ");
        }
        if (this.f13744b != -1) {
            sb.append("dly(");
            sb.append(this.f13744b);
            sb.append(") ");
        }
        if (this.f13746d != null) {
            sb.append("interp(");
            sb.append(this.f13746d);
            sb.append(") ");
        }
        ArrayList arrayList = this.f13747e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f13748f;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (i4 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i4));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i5));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(q qVar) {
        if (this.f13762t == null) {
            this.f13762t = new ArrayList();
        }
        this.f13762t.add(qVar);
    }

    public void b(View view) {
        this.f13748f.add(view);
    }

    public void cancel() {
        ArrayList arrayList = this.f13756n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f13757o);
        this.f13757o = f13740x;
        for (int i4 = size - 1; i4 >= 0; i4--) {
            Animator animator = animatorArr[i4];
            animatorArr[i4] = null;
            animator.cancel();
        }
        this.f13757o = animatorArr;
        w(this, r.f13736h0);
    }

    public abstract void d(C0785A c0785a);

    public final void e(View view, boolean z4) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            C0785A c0785a = new C0785A(view);
            if (z4) {
                g(c0785a);
            } else {
                d(c0785a);
            }
            c0785a.f13675c.add(this);
            f(c0785a);
            if (z4) {
                c(this.f13749g, view, c0785a);
            } else {
                c(this.f13750h, view, c0785a);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                e(viewGroup.getChildAt(i4), z4);
            }
        }
    }

    public void f(C0785A c0785a) {
    }

    public abstract void g(C0785A c0785a);

    public final void h(ViewGroup viewGroup, boolean z4) {
        i(z4);
        ArrayList arrayList = this.f13747e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f13748f;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z4);
            return;
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i4)).intValue());
            if (viewFindViewById != null) {
                C0785A c0785a = new C0785A(viewFindViewById);
                if (z4) {
                    g(c0785a);
                } else {
                    d(c0785a);
                }
                c0785a.f13675c.add(this);
                f(c0785a);
                if (z4) {
                    c(this.f13749g, viewFindViewById, c0785a);
                } else {
                    c(this.f13750h, viewFindViewById, c0785a);
                }
            }
        }
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            View view = (View) arrayList2.get(i5);
            C0785A c0785a2 = new C0785A(view);
            if (z4) {
                g(c0785a2);
            } else {
                d(c0785a2);
            }
            c0785a2.f13675c.add(this);
            f(c0785a2);
            if (z4) {
                c(this.f13749g, view, c0785a2);
            } else {
                c(this.f13750h, view, c0785a2);
            }
        }
    }

    public final void i(boolean z4) {
        if (z4) {
            ((q.f) this.f13749g.f15273a).clear();
            ((SparseArray) this.f13749g.f15274b).clear();
            ((q.i) this.f13749g.f15275c).a();
        } else {
            ((q.f) this.f13750h.f15273a).clear();
            ((SparseArray) this.f13750h.f15274b).clear();
            ((q.i) this.f13750h.f15275c).a();
        }
    }

    @Override // 
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public s clone() {
        try {
            s sVar = (s) super.clone();
            sVar.f13763u = new ArrayList();
            sVar.f13749g = new t.d(5);
            sVar.f13750h = new t.d(5);
            sVar.f13753k = null;
            sVar.f13754l = null;
            sVar.f13761s = this;
            sVar.f13762t = null;
            return sVar;
        } catch (CloneNotSupportedException e4) {
            throw new RuntimeException(e4);
        }
    }

    public Animator k(ViewGroup viewGroup, C0785A c0785a, C0785A c0785a2) {
        return null;
    }

    public void l(ViewGroup viewGroup, t.d dVar, t.d dVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i4;
        View view;
        C0785A c0785a;
        Animator animator;
        C0785A c0785a2;
        q.f fVarP = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        o().getClass();
        int i5 = 0;
        while (i5 < size) {
            C0785A c0785a3 = (C0785A) arrayList.get(i5);
            C0785A c0785a4 = (C0785A) arrayList2.get(i5);
            if (c0785a3 != null && !c0785a3.f13675c.contains(this)) {
                c0785a3 = null;
            }
            if (c0785a4 != null && !c0785a4.f13675c.contains(this)) {
                c0785a4 = null;
            }
            if ((c0785a3 != null || c0785a4 != null) && (c0785a3 == null || c0785a4 == null || t(c0785a3, c0785a4))) {
                Animator animatorK = k(viewGroup, c0785a3, c0785a4);
                if (animatorK != null) {
                    String str = this.f13743a;
                    if (c0785a4 != null) {
                        String[] strArrQ = q();
                        view = c0785a4.f13674b;
                        if (strArrQ != null && strArrQ.length > 0) {
                            c0785a2 = new C0785A(view);
                            C0785A c0785a5 = (C0785A) ((q.f) dVar2.f15273a).get(view);
                            i4 = size;
                            if (c0785a5 != null) {
                                int i6 = 0;
                                while (i6 < strArrQ.length) {
                                    HashMap map = c0785a2.f13673a;
                                    String str2 = strArrQ[i6];
                                    map.put(str2, c0785a5.f13673a.get(str2));
                                    i6++;
                                    strArrQ = strArrQ;
                                }
                            }
                            int i7 = fVarP.f13970c;
                            int i8 = 0;
                            while (true) {
                                if (i8 >= i7) {
                                    animator = animatorK;
                                    break;
                                }
                                p pVar = (p) fVarP.get((Animator) fVarP.f(i8));
                                if (pVar.f13730c != null && pVar.f13728a == view && pVar.f13729b.equals(str) && pVar.f13730c.equals(c0785a2)) {
                                    animator = null;
                                    break;
                                }
                                i8++;
                            }
                        } else {
                            i4 = size;
                            animator = animatorK;
                            c0785a2 = null;
                        }
                        animatorK = animator;
                        c0785a = c0785a2;
                    } else {
                        i4 = size;
                        view = c0785a3.f13674b;
                        c0785a = null;
                    }
                    if (animatorK != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        p pVar2 = new p();
                        pVar2.f13728a = view;
                        pVar2.f13729b = str;
                        pVar2.f13730c = c0785a;
                        pVar2.f13731d = windowId;
                        pVar2.f13732e = this;
                        pVar2.f13733f = animatorK;
                        fVarP.put(animatorK, pVar2);
                        this.f13763u.add(animatorK);
                    }
                }
                i5++;
                size = i4;
            }
            i4 = size;
            i5++;
            size = i4;
        }
        if (sparseIntArray.size() != 0) {
            for (int i9 = 0; i9 < sparseIntArray.size(); i9++) {
                p pVar3 = (p) fVarP.get((Animator) this.f13763u.get(sparseIntArray.keyAt(i9)));
                pVar3.f13733f.setStartDelay(pVar3.f13733f.getStartDelay() + (sparseIntArray.valueAt(i9) - LongCompanionObject.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i4 = this.f13758p - 1;
        this.f13758p = i4;
        if (i4 == 0) {
            w(this, r.f13735g0);
            for (int i5 = 0; i5 < ((q.i) this.f13749g.f15275c).g(); i5++) {
                View view = (View) ((q.i) this.f13749g.f15275c).h(i5);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i6 = 0; i6 < ((q.i) this.f13750h.f15275c).g(); i6++) {
                View view2 = (View) ((q.i) this.f13750h.f15275c).h(i6);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f13760r = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r5 = r5.f13754l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5.f13753k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (o0.C0785A) r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final o0.C0785A n(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            o0.y r0 = r5.f13751i
            if (r0 == 0) goto L9
            o0.A r5 = r0.n(r6, r7)
            return r5
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f13753k
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f13754l
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
            o0.A r4 = (o0.C0785A) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f13674b
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
            java.util.ArrayList r5 = r5.f13754l
            goto L36
        L34:
            java.util.ArrayList r5 = r5.f13753k
        L36:
            java.lang.Object r5 = r5.get(r3)
            r1 = r5
            o0.A r1 = (o0.C0785A) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.s.n(android.view.View, boolean):o0.A");
    }

    public final s o() {
        y yVar = this.f13751i;
        return yVar != null ? yVar.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final C0785A r(View view, boolean z4) {
        y yVar = this.f13751i;
        if (yVar != null) {
            return yVar.r(view, z4);
        }
        return (C0785A) ((q.f) (z4 ? this.f13749g : this.f13750h).f15273a).get(view);
    }

    public boolean s() {
        return !this.f13756n.isEmpty();
    }

    public boolean t(C0785A c0785a, C0785A c0785a2) {
        if (c0785a == null || c0785a2 == null) {
            return false;
        }
        String[] strArrQ = q();
        if (strArrQ == null) {
            Iterator it = c0785a.f13673a.keySet().iterator();
            while (it.hasNext()) {
                if (v(c0785a, c0785a2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrQ) {
            if (!v(c0785a, c0785a2, str)) {
            }
        }
        return false;
        return true;
    }

    public final String toString() {
        return J("");
    }

    public final boolean u(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f13747e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f13748f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final void w(s sVar, C0073e c0073e) {
        s sVar2 = this.f13761s;
        if (sVar2 != null) {
            sVar2.w(sVar, c0073e);
        }
        ArrayList arrayList = this.f13762t;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f13762t.size();
        q[] qVarArr = this.f13755m;
        if (qVarArr == null) {
            qVarArr = new q[size];
        }
        this.f13755m = null;
        q[] qVarArr2 = (q[]) this.f13762t.toArray(qVarArr);
        for (int i4 = 0; i4 < size; i4++) {
            q qVar = qVarArr2[i4];
            switch (c0073e.f958a) {
                case 2:
                    qVar.c(sVar);
                    break;
                case 3:
                    qVar.f(sVar);
                    break;
                case 4:
                    qVar.d(sVar);
                    break;
                case 5:
                    qVar.a();
                    break;
                default:
                    qVar.b();
                    break;
            }
            qVarArr2[i4] = null;
        }
        this.f13755m = qVarArr2;
    }

    public void x(View view) {
        if (this.f13760r) {
            return;
        }
        ArrayList arrayList = this.f13756n;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f13757o);
        this.f13757o = f13740x;
        for (int i4 = size - 1; i4 >= 0; i4--) {
            Animator animator = animatorArr[i4];
            animatorArr[i4] = null;
            animator.pause();
        }
        this.f13757o = animatorArr;
        w(this, r.f13737i0);
        this.f13759q = true;
    }

    public s y(q qVar) {
        s sVar;
        ArrayList arrayList = this.f13762t;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(qVar) && (sVar = this.f13761s) != null) {
            sVar.y(qVar);
        }
        if (this.f13762t.size() == 0) {
            this.f13762t = null;
        }
        return this;
    }

    public void z(View view) {
        this.f13748f.remove(view);
    }
}
