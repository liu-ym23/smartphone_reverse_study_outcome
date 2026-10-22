package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import q.C0933a;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static k f11476a = new C0546a();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<C0933a<ViewGroup, ArrayList<k>>>> f11477b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f11478c = new ArrayList<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        k f11479a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f11480b;

        /* renamed from: androidx.transition.r$a$a, reason: collision with other inner class name */
        class C0149a extends q {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0933a f11481a;

            C0149a(C0933a c0933a) {
                this.f11481a = c0933a;
            }

            @Override // androidx.transition.k.f
            public void d(k kVar) {
                ((ArrayList) this.f11481a.get(a.this.f11480b)).remove(kVar);
                kVar.X(this);
            }
        }

        a(k kVar, ViewGroup viewGroup) {
            this.f11479a = kVar;
            this.f11480b = viewGroup;
        }

        private void a() {
            this.f11480b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f11480b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!r.f11478c.remove(this.f11480b)) {
                return true;
            }
            C0933a<ViewGroup, ArrayList<k>> c0933aB = r.b();
            ArrayList<k> arrayList = c0933aB.get(this.f11480b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                c0933aB.put(this.f11480b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f11479a);
            this.f11479a.b(new C0149a(c0933aB));
            int i5 = 0;
            this.f11479a.n(this.f11480b, false);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                while (i5 < size) {
                    Object obj = arrayList2.get(i5);
                    i5++;
                    ((k) obj).Z(this.f11480b);
                }
            }
            this.f11479a.W(this.f11480b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            r.f11478c.remove(this.f11480b);
            ArrayList<k> arrayList = r.b().get(this.f11480b);
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    k kVar = arrayList.get(i5);
                    i5++;
                    kVar.Z(this.f11480b);
                }
            }
            this.f11479a.p(true);
        }
    }

    public static void a(ViewGroup viewGroup, k kVar) {
        if (f11478c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        f11478c.add(viewGroup);
        if (kVar == null) {
            kVar = f11476a;
        }
        k kVarClone = kVar.clone();
        d(viewGroup, kVarClone);
        j.c(viewGroup, null);
        c(viewGroup, kVarClone);
    }

    static C0933a<ViewGroup, ArrayList<k>> b() {
        C0933a<ViewGroup, ArrayList<k>> c0933a;
        WeakReference<C0933a<ViewGroup, ArrayList<k>>> weakReference = f11477b.get();
        if (weakReference != null && (c0933a = weakReference.get()) != null) {
            return c0933a;
        }
        C0933a<ViewGroup, ArrayList<k>> c0933a2 = new C0933a<>();
        f11477b.set(new WeakReference<>(c0933a2));
        return c0933a2;
    }

    private static void c(ViewGroup viewGroup, k kVar) {
        if (kVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(kVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, k kVar) {
        ArrayList<k> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                k kVar2 = arrayList.get(i5);
                i5++;
                kVar2.V(viewGroup);
            }
        }
        if (kVar != null) {
            kVar.n(viewGroup, true);
        }
        j jVarB = j.b(viewGroup);
        if (jVarB != null) {
            jVarB.a();
        }
    }
}
