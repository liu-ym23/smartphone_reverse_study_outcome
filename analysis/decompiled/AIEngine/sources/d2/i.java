package d2;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class i implements Cloneable {
    public static final Animator[] A = new Animator[0];
    public static final int[] B = {2, 1, 3, 4};
    public static final a C = new a();
    public static final ThreadLocal<p.a<Animator, b>> D = new ThreadLocal<>();

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<p> f8291n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<p> f8292o;

    /* renamed from: p, reason: collision with root package name */
    public d[] f8293p;

    /* renamed from: y, reason: collision with root package name */
    public c f8301y;

    /* renamed from: a, reason: collision with root package name */
    public final String f8282a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f8283b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f8284c = -1;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f8285d = null;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<Integer> f8286e = new ArrayList<>();
    public final ArrayList<View> h = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public com.stepos.statsrpk.g f8287j = new com.stepos.statsrpk.g();

    /* renamed from: k, reason: collision with root package name */
    public com.stepos.statsrpk.g f8288k = new com.stepos.statsrpk.g();

    /* renamed from: l, reason: collision with root package name */
    public n f8289l = null;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f8290m = B;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<Animator> f8294q = new ArrayList<>();
    public Animator[] r = A;

    /* renamed from: s, reason: collision with root package name */
    public int f8295s = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8296t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8297u = false;

    /* renamed from: v, reason: collision with root package name */
    public i f8298v = null;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList<d> f8299w = null;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<Animator> f8300x = new ArrayList<>();
    public androidx.datastore.preferences.protobuf.f z = C;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends androidx.datastore.preferences.protobuf.f {
        @Override // androidx.datastore.preferences.protobuf.f
        public final Path d(float f8, float f9, float f10, float f11) {
            Path path = new Path();
            path.moveTo(f8, f9);
            path.lineTo(f10, f11);
            return path;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public View f8302a;

        /* renamed from: b, reason: collision with root package name */
        public String f8303b;

        /* renamed from: c, reason: collision with root package name */
        public p f8304c;

        /* renamed from: d, reason: collision with root package name */
        public WindowId f8305d;

        /* renamed from: e, reason: collision with root package name */
        public i f8306e;

        /* renamed from: f, reason: collision with root package name */
        public Animator f8307f;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d {
        void a(i iVar);

        void b();

        void c(i iVar);

        void d();

        void e(i iVar);

        default void f(i iVar) {
            c(iVar);
        }

        default void g(i iVar) {
            a(iVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {

        /* renamed from: a, reason: collision with root package name */
        public static final com.stepos.core.ota.d f8308a = new com.stepos.core.ota.d(8);

        /* renamed from: b, reason: collision with root package name */
        public static final ai.onnxruntime.a f8309b = new ai.onnxruntime.a(27);

        /* renamed from: c, reason: collision with root package name */
        public static final com.stepos.core.ota.d f8310c = new com.stepos.core.ota.d(9);

        /* renamed from: d, reason: collision with root package name */
        public static final ai.onnxruntime.a f8311d = new ai.onnxruntime.a(28);

        /* renamed from: e, reason: collision with root package name */
        public static final com.stepos.core.ota.d f8312e = new com.stepos.core.ota.d(10);

        void a(d dVar, i iVar);
    }

    public static void d(com.stepos.statsrpk.g gVar, View view, p pVar) {
        p.a aVar = (p.a) gVar.f8087a;
        p.a aVar2 = (p.a) gVar.f8090d;
        SparseArray sparseArray = (SparseArray) gVar.f8088b;
        p.e eVar = (p.e) gVar.f8089c;
        aVar.put(view, pVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (sparseArray.indexOfKey(id2) >= 0) {
                sparseArray.put(id2, null);
            } else {
                sparseArray.put(id2, view);
            }
        }
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        String strE = e0.d.e(view);
        if (strE != null) {
            if (aVar2.containsKey(strE)) {
                aVar2.put(strE, null);
            } else {
                aVar2.put(strE, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (eVar.f11360a) {
                    int i10 = eVar.f11363d;
                    long[] jArr = eVar.f11361b;
                    Object[] objArr = eVar.f11362c;
                    int i11 = 0;
                    for (int i12 = 0; i12 < i10; i12++) {
                        Object obj = objArr[i12];
                        if (obj != p.f.f11364a) {
                            if (i12 != i11) {
                                jArr[i11] = jArr[i12];
                                objArr[i11] = obj;
                                objArr[i12] = null;
                            }
                            i11++;
                        }
                    }
                    eVar.f11360a = false;
                    eVar.f11363d = i11;
                }
                if (q.a.b(eVar.f11361b, eVar.f11363d, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    eVar.f(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) eVar.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    eVar.f(itemIdAtPosition, null);
                }
            }
        }
    }

    public static p.a<Animator, b> q() {
        ThreadLocal<p.a<Animator, b>> threadLocal = D;
        p.a<Animator, b> aVar = threadLocal.get();
        if (aVar != null) {
            return aVar;
        }
        p.a<Animator, b> aVar2 = new p.a<>();
        threadLocal.set(aVar2);
        return aVar2;
    }

    public void A() {
        H();
        p.a<Animator, b> aVarQ = q();
        ArrayList<Animator> arrayList = this.f8300x;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Animator animator = arrayList.get(i10);
            i10++;
            Animator animator2 = animator;
            if (aVarQ.containsKey(animator2)) {
                H();
                if (animator2 != null) {
                    animator2.addListener(new j(this, aVarQ));
                    long j10 = this.f8284c;
                    if (j10 >= 0) {
                        animator2.setDuration(j10);
                    }
                    long j11 = this.f8283b;
                    if (j11 >= 0) {
                        animator2.setStartDelay(animator2.getStartDelay() + j11);
                    }
                    TimeInterpolator timeInterpolator = this.f8285d;
                    if (timeInterpolator != null) {
                        animator2.setInterpolator(timeInterpolator);
                    }
                    animator2.addListener(new k(this));
                    animator2.start();
                }
            }
        }
        this.f8300x.clear();
        n();
    }

    public void B(long j10) {
        this.f8284c = j10;
    }

    public void C(c cVar) {
        this.f8301y = cVar;
    }

    public void D(TimeInterpolator timeInterpolator) {
        this.f8285d = timeInterpolator;
    }

    public void E(androidx.datastore.preferences.protobuf.f fVar) {
        if (fVar == null) {
            this.z = C;
        } else {
            this.z = fVar;
        }
    }

    public void G(long j10) {
        this.f8283b = j10;
    }

    public final void H() {
        if (this.f8295s == 0) {
            v(this, e.f8308a);
            this.f8297u = false;
        }
        this.f8295s++;
    }

    public String I(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(": ");
        if (this.f8284c != -1) {
            sb2.append("dur(");
            sb2.append(this.f8284c);
            sb2.append(") ");
        }
        if (this.f8283b != -1) {
            sb2.append("dly(");
            sb2.append(this.f8283b);
            sb2.append(") ");
        }
        if (this.f8285d != null) {
            sb2.append("interp(");
            sb2.append(this.f8285d);
            sb2.append(") ");
        }
        ArrayList<Integer> arrayList = this.f8286e;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.h;
        if (size > 0 || arrayList2.size() > 0) {
            sb2.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList.get(i10));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList2.get(i11));
                }
            }
            sb2.append(")");
        }
        return sb2.toString();
    }

    public void b(d dVar) {
        if (this.f8299w == null) {
            this.f8299w = new ArrayList<>();
        }
        this.f8299w.add(dVar);
    }

    public void c(View view) {
        this.h.add(view);
    }

    public void cancel() {
        ArrayList<Animator> arrayList = this.f8294q;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.r);
        this.r = A;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.cancel();
        }
        this.r = animatorArr;
        v(this, e.f8310c);
    }

    public abstract void e(p pVar);

    public final void f(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            p pVar = new p(view);
            if (z) {
                h(pVar);
            } else {
                e(pVar);
            }
            pVar.f8327c.add(this);
            g(pVar);
            if (z) {
                d(this.f8287j, view, pVar);
            } else {
                d(this.f8288k, view, pVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                f(viewGroup.getChildAt(i10), z);
            }
        }
    }

    public abstract void h(p pVar);

    public final void i(ViewGroup viewGroup, boolean z) {
        j(z);
        ArrayList<Integer> arrayList = this.f8286e;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.h;
        if (size <= 0 && arrayList2.size() <= 0) {
            f(viewGroup, z);
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            View viewFindViewById = viewGroup.findViewById(arrayList.get(i10).intValue());
            if (viewFindViewById != null) {
                p pVar = new p(viewFindViewById);
                if (z) {
                    h(pVar);
                } else {
                    e(pVar);
                }
                pVar.f8327c.add(this);
                g(pVar);
                if (z) {
                    d(this.f8287j, viewFindViewById, pVar);
                } else {
                    d(this.f8288k, viewFindViewById, pVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            View view = arrayList2.get(i11);
            p pVar2 = new p(view);
            if (z) {
                h(pVar2);
            } else {
                e(pVar2);
            }
            pVar2.f8327c.add(this);
            g(pVar2);
            if (z) {
                d(this.f8287j, view, pVar2);
            } else {
                d(this.f8288k, view, pVar2);
            }
        }
    }

    public final void j(boolean z) {
        if (z) {
            ((p.a) this.f8287j.f8087a).clear();
            ((SparseArray) this.f8287j.f8088b).clear();
            ((p.e) this.f8287j.f8089c).b();
        } else {
            ((p.a) this.f8288k.f8087a).clear();
            ((SparseArray) this.f8288k.f8088b).clear();
            ((p.e) this.f8288k.f8089c).b();
        }
    }

    @Override // 
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.f8300x = new ArrayList<>();
            iVar.f8287j = new com.stepos.statsrpk.g();
            iVar.f8288k = new com.stepos.statsrpk.g();
            iVar.f8291n = null;
            iVar.f8292o = null;
            iVar.f8298v = this;
            iVar.f8299w = null;
            return iVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Animator l(ViewGroup viewGroup, p pVar, p pVar2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m(ViewGroup viewGroup, com.stepos.statsrpk.g gVar, com.stepos.statsrpk.g gVar2, ArrayList<p> arrayList, ArrayList<p> arrayList2) {
        int i10;
        int i11;
        View view;
        p pVar;
        Animator animator;
        p pVar2;
        p.a<Animator, b> aVarQ = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        p().getClass();
        int i12 = 0;
        while (i12 < size) {
            p pVar3 = arrayList.get(i12);
            p pVar4 = arrayList2.get(i12);
            if (pVar3 != null && !pVar3.f8327c.contains(this)) {
                pVar3 = null;
            }
            if (pVar4 != null && !pVar4.f8327c.contains(this)) {
                pVar4 = null;
            }
            if ((pVar3 != null || pVar4 != null) && (pVar3 == null || pVar4 == null || t(pVar3, pVar4))) {
                Animator animatorL = l(viewGroup, pVar3, pVar4);
                if (animatorL != null) {
                    String str = this.f8282a;
                    if (pVar4 != null) {
                        view = pVar4.f8326b;
                        String[] strArrR = r();
                        if (strArrR != null && strArrR.length > 0) {
                            pVar2 = new p(view);
                            p pVar5 = (p) ((p.a) gVar2.f8087a).get(view);
                            i10 = size;
                            if (pVar5 != null) {
                                int i13 = 0;
                                while (i13 < strArrR.length) {
                                    String str2 = strArrR[i13];
                                    pVar2.f8325a.put(str2, pVar5.f8325a.get(str2));
                                    i13++;
                                    i12 = i12;
                                    pVar5 = pVar5;
                                }
                            }
                            i11 = i12;
                            int i14 = aVarQ.f11385c;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= i14) {
                                    animator = animatorL;
                                    break;
                                }
                                b bVar = aVarQ.get(aVarQ.g(i15));
                                if (bVar.f8304c != null && bVar.f8302a == view && bVar.f8303b.equals(str) && bVar.f8304c.equals(pVar2)) {
                                    animator = null;
                                    break;
                                }
                                i15++;
                            }
                        } else {
                            i10 = size;
                            i11 = i12;
                            animator = animatorL;
                            pVar2 = null;
                        }
                        animatorL = animator;
                        pVar = pVar2;
                    } else {
                        i10 = size;
                        i11 = i12;
                        view = pVar3.f8326b;
                        pVar = null;
                    }
                    if (animatorL != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        b bVar2 = new b();
                        bVar2.f8302a = view;
                        bVar2.f8303b = str;
                        bVar2.f8304c = pVar;
                        bVar2.f8305d = windowId;
                        bVar2.f8306e = this;
                        bVar2.f8307f = animatorL;
                        aVarQ.put(animatorL, bVar2);
                        this.f8300x.add(animatorL);
                    }
                }
                i12 = i11 + 1;
                size = i10;
            }
            i10 = size;
            i11 = i12;
            i12 = i11 + 1;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                b bVar3 = aVarQ.get(this.f8300x.get(sparseIntArray.keyAt(i16)));
                bVar3.f8307f.setStartDelay(bVar3.f8307f.getStartDelay() + (sparseIntArray.valueAt(i16) - Long.MAX_VALUE));
            }
        }
    }

    public final void n() {
        int i10 = this.f8295s - 1;
        this.f8295s = i10;
        if (i10 == 0) {
            v(this, e.f8309b);
            for (int i11 = 0; i11 < ((p.e) this.f8287j.f8089c).g(); i11++) {
                View view = (View) ((p.e) this.f8287j.f8089c).h(i11);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < ((p.e) this.f8288k.f8089c).g(); i12++) {
                View view2 = (View) ((p.e) this.f8288k.f8089c).h(i12);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f8297u = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r4 = r4.f8292o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r4 = r4.f8291n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return r4.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d2.p o(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            d2.n r0 = r4.f8289l
            if (r0 == 0) goto L9
            d2.p r4 = r0.o(r5, r6)
            return r4
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList<d2.p> r0 = r4.f8291n
            goto L10
        Le:
            java.util.ArrayList<d2.p> r0 = r4.f8292o
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            d2.p r3 = (d2.p) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.f8326b
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
            java.util.ArrayList<d2.p> r4 = r4.f8292o
            goto L35
        L33:
            java.util.ArrayList<d2.p> r4 = r4.f8291n
        L35:
            java.lang.Object r4 = r4.get(r2)
            d2.p r4 = (d2.p) r4
            return r4
        L3c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.i.o(android.view.View, boolean):d2.p");
    }

    public final i p() {
        n nVar = this.f8289l;
        return nVar != null ? nVar.p() : this;
    }

    public String[] r() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p s(View view, boolean z) {
        n nVar = this.f8289l;
        if (nVar != null) {
            return nVar.s(view, z);
        }
        return (p) ((p.a) (z ? this.f8287j : this.f8288k).f8087a).get(view);
    }

    public boolean t(p pVar, p pVar2) {
        if (pVar != null) {
            HashMap map = pVar.f8325a;
            if (pVar2 != null) {
                HashMap map2 = pVar2.f8325a;
                String[] strArrR = r();
                if (strArrR != null) {
                    for (String str : strArrR) {
                        Object obj = map.get(str);
                        Object obj2 = map2.get(str);
                        if ((obj == null && obj2 == null) ? false : (obj == null || obj2 == null) ? true : !obj.equals(obj2)) {
                            return true;
                        }
                    }
                } else {
                    for (String str2 : map.keySet()) {
                        Object obj3 = map.get(str2);
                        Object obj4 = map2.get(str2);
                        if ((obj3 == null && obj4 == null) ? false : (obj3 == null || obj4 == null) ? true : !obj3.equals(obj4)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        return I("");
    }

    public final boolean u(View view) {
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.f8286e;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.h;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id2)) || arrayList2.contains(view);
    }

    public final void v(i iVar, e eVar) {
        i iVar2 = this.f8298v;
        if (iVar2 != null) {
            iVar2.v(iVar, eVar);
        }
        ArrayList<d> arrayList = this.f8299w;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f8299w.size();
        d[] dVarArr = this.f8293p;
        if (dVarArr == null) {
            dVarArr = new d[size];
        }
        this.f8293p = null;
        d[] dVarArr2 = (d[]) this.f8299w.toArray(dVarArr);
        for (int i10 = 0; i10 < size; i10++) {
            eVar.a(dVarArr2[i10], iVar);
            dVarArr2[i10] = null;
        }
        this.f8293p = dVarArr2;
    }

    public void w(View view) {
        if (this.f8297u) {
            return;
        }
        ArrayList<Animator> arrayList = this.f8294q;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.r);
        this.r = A;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.pause();
        }
        this.r = animatorArr;
        v(this, e.f8311d);
        this.f8296t = true;
    }

    public i x(d dVar) {
        i iVar;
        ArrayList<d> arrayList = this.f8299w;
        if (arrayList != null) {
            if (!arrayList.remove(dVar) && (iVar = this.f8298v) != null) {
                iVar.x(dVar);
            }
            if (this.f8299w.size() == 0) {
                this.f8299w = null;
            }
        }
        return this;
    }

    public void y(View view) {
        this.h.remove(view);
    }

    public void z(View view) {
        if (this.f8296t) {
            if (!this.f8297u) {
                ArrayList<Animator> arrayList = this.f8294q;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.r);
                this.r = A;
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    Animator animator = animatorArr[i10];
                    animatorArr[i10] = null;
                    animator.resume();
                }
                this.r = animatorArr;
                v(this, e.f8312e);
            }
            this.f8296t = false;
        }
    }

    public void F() {
    }

    public void g(p pVar) {
    }
}
