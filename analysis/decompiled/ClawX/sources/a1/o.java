package a1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Iterator;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class o implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f50l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f51m;

    /* renamed from: n, reason: collision with root package name */
    public m[] f52n;

    /* renamed from: x, reason: collision with root package name */
    public static final Animator[] f40x = new Animator[0];
    public static final int[] y = {2, 1, 3, 4};
    public static final t1.f z = new t1.f(1);
    public static final ThreadLocal A = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final String f41a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f42b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f43c = -1;
    public TimeInterpolator d = null;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f44e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f45f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public w f46g = new w(0);

    /* renamed from: h, reason: collision with root package name */
    public w f47h = new w(0);

    /* renamed from: j, reason: collision with root package name */
    public a f48j = null;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f49k = y;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f53o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public Animator[] f54p = f40x;

    /* renamed from: q, reason: collision with root package name */
    public int f55q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f56r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f57s = false;

    /* renamed from: t, reason: collision with root package name */
    public o f58t = null;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f59u = null;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f60v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public t1.f f61w = z;

    public static void b(w wVar, View view, v vVar) {
        j.e eVar = (j.e) wVar.f75b;
        j.e eVar2 = (j.e) wVar.f76c;
        SparseArray sparseArray = (SparseArray) wVar.d;
        j.g gVar = (j.g) wVar.f77e;
        eVar.put(view, vVar);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        int[] iArr = e0.a0.f2285a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            if (eVar2.containsKey(transitionName)) {
                eVar2.put(transitionName, null);
            } else {
                eVar2.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (gVar.f3293a) {
                    int i8 = gVar.d;
                    long[] jArr = gVar.f3294b;
                    Object[] objArr = gVar.f3295c;
                    int i9 = 0;
                    for (int i10 = 0; i10 < i8; i10++) {
                        Object obj = objArr[i10];
                        if (obj != j.h.f3296a) {
                            if (i10 != i9) {
                                jArr[i9] = jArr[i10];
                                objArr[i9] = obj;
                                objArr[i10] = null;
                            }
                            i9++;
                        }
                    }
                    gVar.f3293a = false;
                    gVar.d = i9;
                }
                if (k.a.b(gVar.d, itemIdAtPosition, gVar.f3294b) < 0) {
                    view.setHasTransientState(true);
                    gVar.d(view, itemIdAtPosition);
                    return;
                }
                View view2 = (View) gVar.b(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    gVar.d(null, itemIdAtPosition);
                }
            }
        }
    }

    public static j.e p() {
        ThreadLocal threadLocal = A;
        j.e eVar = (j.e) threadLocal.get();
        if (eVar != null) {
            return eVar;
        }
        j.e eVar2 = new j.e(0);
        threadLocal.set(eVar2);
        return eVar2;
    }

    public static boolean u(v vVar, v vVar2, String str) {
        Object obj = vVar.f71a.get(str);
        Object obj2 = vVar2.f71a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(long j4) {
        this.f43c = j4;
    }

    public void C(TimeInterpolator timeInterpolator) {
        this.d = timeInterpolator;
    }

    public void D(t1.f fVar) {
        if (fVar == null) {
            this.f61w = z;
        } else {
            this.f61w = fVar;
        }
    }

    public void F(long j4) {
        this.f42b = j4;
    }

    public final void G() {
        if (this.f55q == 0) {
            v(this, n.f35b);
            this.f57s = false;
        }
        this.f55q++;
    }

    public String H(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f43c != -1) {
            sb.append("dur(");
            sb.append(this.f43c);
            sb.append(") ");
        }
        if (this.f42b != -1) {
            sb.append("dly(");
            sb.append(this.f42b);
            sb.append(") ");
        }
        if (this.d != null) {
            sb.append("interp(");
            sb.append(this.d);
            sb.append(") ");
        }
        ArrayList arrayList = this.f44e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f45f;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    if (i8 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i8));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i9 = 0; i9 < arrayList2.size(); i9++) {
                    if (i9 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i9));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(m mVar) {
        if (this.f59u == null) {
            this.f59u = new ArrayList();
        }
        this.f59u.add(mVar);
    }

    public void c() {
        ArrayList arrayList = this.f53o;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f54p);
        this.f54p = f40x;
        for (int i8 = size - 1; i8 >= 0; i8--) {
            Animator animator = animatorArr[i8];
            animatorArr[i8] = null;
            animator.cancel();
        }
        this.f54p = animatorArr;
        v(this, n.d);
    }

    public abstract void d(v vVar);

    public final void e(View view, boolean z2) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            v vVar = new v(view);
            if (z2) {
                g(vVar);
            } else {
                d(vVar);
            }
            vVar.f73c.add(this);
            f(vVar);
            if (z2) {
                b(this.f46g, view, vVar);
            } else {
                b(this.f47h, view, vVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                e(viewGroup.getChildAt(i8), z2);
            }
        }
    }

    public abstract void g(v vVar);

    public final void h(ViewGroup viewGroup, boolean z2) {
        i(z2);
        ArrayList arrayList = this.f44e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f45f;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z2);
            return;
        }
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i8)).intValue());
            if (viewFindViewById != null) {
                v vVar = new v(viewFindViewById);
                if (z2) {
                    g(vVar);
                } else {
                    d(vVar);
                }
                vVar.f73c.add(this);
                f(vVar);
                if (z2) {
                    b(this.f46g, viewFindViewById, vVar);
                } else {
                    b(this.f47h, viewFindViewById, vVar);
                }
            }
        }
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            View view = (View) arrayList2.get(i9);
            v vVar2 = new v(view);
            if (z2) {
                g(vVar2);
            } else {
                d(vVar2);
            }
            vVar2.f73c.add(this);
            f(vVar2);
            if (z2) {
                b(this.f46g, view, vVar2);
            } else {
                b(this.f47h, view, vVar2);
            }
        }
    }

    public final void i(boolean z2) {
        if (z2) {
            ((j.e) this.f46g.f75b).clear();
            ((SparseArray) this.f46g.d).clear();
            ((j.g) this.f46g.f77e).a();
        } else {
            ((j.e) this.f47h.f75b).clear();
            ((SparseArray) this.f47h.d).clear();
            ((j.g) this.f47h.f77e).a();
        }
    }

    @Override // 
    /* renamed from: j */
    public o clone() {
        try {
            o oVar = (o) super.clone();
            oVar.f60v = new ArrayList();
            oVar.f46g = new w(0);
            oVar.f47h = new w(0);
            oVar.f50l = null;
            oVar.f51m = null;
            oVar.f58t = this;
            oVar.f59u = null;
            return oVar;
        } catch (CloneNotSupportedException e9) {
            throw new RuntimeException(e9);
        }
    }

    public Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, w wVar, w wVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i8;
        int i9;
        View view;
        v vVar;
        Animator animator;
        v vVar2;
        j.e eVarP = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        o().getClass();
        int i10 = 0;
        while (i10 < size) {
            v vVar3 = (v) arrayList.get(i10);
            v vVar4 = (v) arrayList2.get(i10);
            if (vVar3 != null && !vVar3.f73c.contains(this)) {
                vVar3 = null;
            }
            if (vVar4 != null && !vVar4.f73c.contains(this)) {
                vVar4 = null;
            }
            if ((vVar3 != null || vVar4 != null) && (vVar3 == null || vVar4 == null || s(vVar3, vVar4))) {
                Animator animatorK = k(viewGroup, vVar3, vVar4);
                if (animatorK != null) {
                    String str = this.f41a;
                    if (vVar4 != null) {
                        view = vVar4.f72b;
                        String[] strArrQ = q();
                        if (strArrQ != null && strArrQ.length > 0) {
                            vVar2 = new v(view);
                            v vVar5 = (v) ((j.e) wVar2.f75b).get(view);
                            i8 = size;
                            if (vVar5 != null) {
                                int i11 = 0;
                                while (i11 < strArrQ.length) {
                                    String str2 = strArrQ[i11];
                                    vVar2.f71a.put(str2, vVar5.f71a.get(str2));
                                    i11++;
                                    i10 = i10;
                                    vVar5 = vVar5;
                                }
                            }
                            i9 = i10;
                            int i12 = eVarP.f3306c;
                            int i13 = 0;
                            while (true) {
                                if (i13 >= i12) {
                                    animator = animatorK;
                                    break;
                                }
                                l lVar = (l) eVarP.get((Animator) eVarP.f(i13));
                                if (lVar.f32c != null && lVar.f30a == view && lVar.f31b.equals(str) && lVar.f32c.equals(vVar2)) {
                                    animator = null;
                                    break;
                                }
                                i13++;
                            }
                        } else {
                            i8 = size;
                            i9 = i10;
                            animator = animatorK;
                            vVar2 = null;
                        }
                        animatorK = animator;
                        vVar = vVar2;
                    } else {
                        i8 = size;
                        i9 = i10;
                        view = vVar3.f72b;
                        vVar = null;
                    }
                    if (animatorK != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        l lVar2 = new l();
                        lVar2.f30a = view;
                        lVar2.f31b = str;
                        lVar2.f32c = vVar;
                        lVar2.d = windowId;
                        lVar2.f33e = this;
                        lVar2.f34f = animatorK;
                        eVarP.put(animatorK, lVar2);
                        this.f60v.add(animatorK);
                    }
                }
                i10 = i9 + 1;
                size = i8;
            }
            i8 = size;
            i9 = i10;
            i10 = i9 + 1;
            size = i8;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                l lVar3 = (l) eVarP.get((Animator) this.f60v.get(sparseIntArray.keyAt(i14)));
                lVar3.f34f.setStartDelay(lVar3.f34f.getStartDelay() + (sparseIntArray.valueAt(i14) - Util.VLI_MAX));
            }
        }
    }

    public final void m() {
        int i8 = this.f55q - 1;
        this.f55q = i8;
        if (i8 == 0) {
            v(this, n.f36c);
            for (int i9 = 0; i9 < ((j.g) this.f46g.f77e).e(); i9++) {
                View view = (View) ((j.g) this.f46g.f77e).f(i9);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i10 = 0; i10 < ((j.g) this.f47h.f77e).e(); i10++) {
                View view2 = (View) ((j.g) this.f47h.f77e).f(i10);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f57s = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r4 = r4.f51m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r4 = r4.f50l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (a1.v) r4.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a1.v n(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            a1.a r0 = r4.f48j
            if (r0 == 0) goto L9
            a1.v r4 = r0.n(r5, r6)
            return r4
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.f50l
            goto L10
        Le:
            java.util.ArrayList r0 = r4.f51m
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            a1.v r3 = (a1.v) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.f72b
            if (r3 != r5) goto L28
            goto L2c
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            r2 = -1
        L2c:
            if (r2 < 0) goto L3c
            if (r6 == 0) goto L33
            java.util.ArrayList r4 = r4.f51m
            goto L35
        L33:
            java.util.ArrayList r4 = r4.f50l
        L35:
            java.lang.Object r4 = r4.get(r2)
            a1.v r4 = (a1.v) r4
            return r4
        L3c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.o.n(android.view.View, boolean):a1.v");
    }

    public final o o() {
        a aVar = this.f48j;
        return aVar != null ? aVar.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final v r(View view, boolean z2) {
        a aVar = this.f48j;
        if (aVar != null) {
            return aVar.r(view, z2);
        }
        return (v) ((j.e) (z2 ? this.f46g : this.f47h).f75b).get(view);
    }

    public boolean s(v vVar, v vVar2) {
        if (vVar != null && vVar2 != null) {
            String[] strArrQ = q();
            if (strArrQ != null) {
                for (String str : strArrQ) {
                    if (u(vVar, vVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = vVar.f71a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(vVar, vVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f44e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f45f;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return H(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
    }

    public final void v(o oVar, n nVar) {
        o oVar2 = this.f58t;
        if (oVar2 != null) {
            oVar2.v(oVar, nVar);
        }
        ArrayList arrayList = this.f59u;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f59u.size();
        m[] mVarArr = this.f52n;
        if (mVarArr == null) {
            mVarArr = new m[size];
        }
        this.f52n = null;
        m[] mVarArr2 = (m[]) this.f59u.toArray(mVarArr);
        for (int i8 = 0; i8 < size; i8++) {
            m mVar = mVarArr2[i8];
            switch (nVar.f39a) {
                case 0:
                    mVar.a(oVar);
                    break;
                case 1:
                    mVar.f(oVar);
                    break;
                case 2:
                    mVar.c(oVar);
                    break;
                case 3:
                    mVar.b();
                    break;
                default:
                    mVar.d();
                    break;
            }
            mVarArr2[i8] = null;
        }
        this.f52n = mVarArr2;
    }

    public void w(View view) {
        if (this.f57s) {
            return;
        }
        ArrayList arrayList = this.f53o;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f54p);
        this.f54p = f40x;
        for (int i8 = size - 1; i8 >= 0; i8--) {
            Animator animator = animatorArr[i8];
            animatorArr[i8] = null;
            animator.pause();
        }
        this.f54p = animatorArr;
        v(this, n.f37e);
        this.f56r = true;
    }

    public o x(m mVar) {
        o oVar;
        ArrayList arrayList = this.f59u;
        if (arrayList != null) {
            if (!arrayList.remove(mVar) && (oVar = this.f58t) != null) {
                oVar.x(mVar);
            }
            if (this.f59u.size() == 0) {
                this.f59u = null;
            }
        }
        return this;
    }

    public void y(View view) {
        if (this.f56r) {
            if (!this.f57s) {
                ArrayList arrayList = this.f53o;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f54p);
                this.f54p = f40x;
                for (int i8 = size - 1; i8 >= 0; i8--) {
                    Animator animator = animatorArr[i8];
                    animatorArr[i8] = null;
                    animator.resume();
                }
                this.f54p = animatorArr;
                v(this, n.f38f);
            }
            this.f56r = false;
        }
    }

    public void z() {
        G();
        j.e eVarP = p();
        ArrayList arrayList = this.f60v;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            Animator animator = (Animator) obj;
            if (eVarP.containsKey(animator)) {
                G();
                if (animator != null) {
                    animator.addListener(new j(this, eVarP));
                    long j4 = this.f43c;
                    if (j4 >= 0) {
                        animator.setDuration(j4);
                    }
                    long j8 = this.f42b;
                    if (j8 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j8);
                    }
                    TimeInterpolator timeInterpolator = this.d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new k(0, this));
                    animator.start();
                }
            }
        }
        this.f60v.clear();
        m();
    }

    public void E() {
    }

    public void B(a.a aVar) {
    }

    public void f(v vVar) {
    }
}
