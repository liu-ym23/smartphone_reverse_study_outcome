package p1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static j f38204a = new C5040a();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<j>>>> f38205b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<ViewGroup> f38206c = new ArrayList<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public j f38207a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f38208b;

        /* renamed from: p1.r$a$a, reason: collision with other inner class name */
        public class C0495a extends q {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.collection.a f38209a;

            public C0495a(androidx.collection.a aVar) {
                this.f38209a = aVar;
            }

            @Override // p1.q, p1.j.h
            public void f(j jVar) {
                ((ArrayList) this.f38209a.get(a.this.f38208b)).remove(jVar);
                jVar.g0(this);
            }
        }

        public a(j jVar, ViewGroup viewGroup) {
            this.f38207a = jVar;
            this.f38208b = viewGroup;
        }

        public final void a() {
            this.f38208b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f38208b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!r.f38206c.remove(this.f38208b)) {
                return true;
            }
            androidx.collection.a<ViewGroup, ArrayList<j>> aVarC = r.c();
            ArrayList<j> arrayList = aVarC.get(this.f38208b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarC.put(this.f38208b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f38207a);
            this.f38207a.f(new C0495a(aVarC));
            this.f38207a.q(this.f38208b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).i0(this.f38208b);
                }
            }
            this.f38207a.e0(this.f38208b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            r.f38206c.remove(this.f38208b);
            ArrayList<j> arrayList = r.c().get(this.f38208b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<j> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().i0(this.f38208b);
                }
            }
            this.f38207a.r(true);
        }
    }

    public static void a(ViewGroup viewGroup, j jVar) {
        if (f38206c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        f38206c.add(viewGroup);
        if (jVar == null) {
            jVar = f38204a;
        }
        j jVarClone = jVar.clone();
        e(viewGroup, jVarClone);
        i.c(viewGroup, null);
        d(viewGroup, jVarClone);
    }

    public static t b(ViewGroup viewGroup, j jVar) {
        if (f38206c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return null;
        }
        if (!jVar.S()) {
            throw new IllegalArgumentException("The Transition must support seeking.");
        }
        f38206c.add(viewGroup);
        j jVarClone = jVar.clone();
        u uVar = new u();
        uVar.w0(jVarClone);
        e(viewGroup, uVar);
        i.c(viewGroup, null);
        d(viewGroup, uVar);
        viewGroup.invalidate();
        return uVar.v();
    }

    public static androidx.collection.a<ViewGroup, ArrayList<j>> c() {
        androidx.collection.a<ViewGroup, ArrayList<j>> aVar;
        WeakReference<androidx.collection.a<ViewGroup, ArrayList<j>>> weakReference = f38205b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a<ViewGroup, ArrayList<j>> aVar2 = new androidx.collection.a<>();
        f38205b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void d(ViewGroup viewGroup, j jVar) {
        if (jVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(jVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void e(ViewGroup viewGroup, j jVar) {
        ArrayList<j> arrayList = c().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().d0(viewGroup);
            }
        }
        if (jVar != null) {
            jVar.q(viewGroup, true);
        }
        i iVarB = i.b(viewGroup);
        if (iVarB != null) {
            iVarB.a();
        }
    }
}
