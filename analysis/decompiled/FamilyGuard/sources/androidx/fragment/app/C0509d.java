package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.c;
import androidx.fragment.app.C0517l;
import androidx.fragment.app.M;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q.C0933a;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0509d extends M {

    /* renamed from: androidx.fragment.app.d$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10536a;

        static {
            int[] iArr = new int[M.e.c.values().length];
            f10536a = iArr;
            try {
                iArr[M.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10536a[M.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10536a[M.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10536a[M.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f10537a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f10538b;

        b(List list, M.e eVar) {
            this.f10537a = list;
            this.f10538b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10537a.contains(this.f10538b)) {
                this.f10537a.remove(this.f10538b);
                C0509d.this.s(this.f10538b);
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$c */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10540a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f10541b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f10542c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ M.e f10543d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f10544e;

        c(ViewGroup viewGroup, View view, boolean z5, M.e eVar, k kVar) {
            this.f10540a = viewGroup;
            this.f10541b = view;
            this.f10542c = z5;
            this.f10543d = eVar;
            this.f10544e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10540a.endViewTransition(this.f10541b);
            if (this.f10542c) {
                this.f10543d.e().b(this.f10541b);
            }
            this.f10544e.a();
            if (x.F0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f10543d + " has ended.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    class C0132d implements c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f10546a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f10547b;

        C0132d(Animator animator, M.e eVar) {
            this.f10546a = animator;
            this.f10547b = eVar;
        }

        @Override // androidx.core.os.c.a
        public void onCancel() {
            this.f10546a.end();
            if (x.F0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f10547b + " has been canceled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$e */
    class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ M.e f10549a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10550b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f10551c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f10552d;

        /* renamed from: androidx.fragment.app.d$e$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f10550b.endViewTransition(eVar.f10551c);
                e.this.f10552d.a();
            }
        }

        e(M.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f10549a = eVar;
            this.f10550b = viewGroup;
            this.f10551c = view;
            this.f10552d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f10550b.post(new a());
            if (x.F0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f10549a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (x.F0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f10549a + " has reached onAnimationStart.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$f */
    class f implements c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f10555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10556b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f10557c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ M.e f10558d;

        f(View view, ViewGroup viewGroup, k kVar, M.e eVar) {
            this.f10555a = view;
            this.f10556b = viewGroup;
            this.f10557c = kVar;
            this.f10558d = eVar;
        }

        @Override // androidx.core.os.c.a
        public void onCancel() {
            this.f10555a.clearAnimation();
            this.f10556b.endViewTransition(this.f10555a);
            this.f10557c.a();
            if (x.F0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f10558d + " has been cancelled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$g */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ M.e f10560a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f10561b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f10562c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C0933a f10563d;

        g(M.e eVar, M.e eVar2, boolean z5, C0933a c0933a) {
            this.f10560a = eVar;
            this.f10561b = eVar2;
            this.f10562c = z5;
            this.f10563d = c0933a;
        }

        @Override // java.lang.Runnable
        public void run() {
            H.a(this.f10560a.f(), this.f10561b.f(), this.f10562c, this.f10563d, false);
        }
    }

    /* renamed from: androidx.fragment.app.d$h */
    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ J f10565a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f10566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f10567c;

        h(J j5, View view, Rect rect) {
            this.f10565a = j5;
            this.f10566b = view;
            this.f10567c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10565a.h(this.f10566b, this.f10567c);
        }
    }

    /* renamed from: androidx.fragment.app.d$i */
    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f10569a;

        i(ArrayList arrayList) {
            this.f10569a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            H.d(this.f10569a, 4);
        }
    }

    /* renamed from: androidx.fragment.app.d$j */
    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f10571a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ M.e f10572b;

        j(m mVar, M.e eVar) {
            this.f10571a = mVar;
            this.f10572b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10571a.a();
            if (x.F0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.f10572b + "has completed");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$k */
    private static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f10574c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f10575d;

        /* renamed from: e, reason: collision with root package name */
        private C0517l.a f10576e;

        k(M.e eVar, androidx.core.os.c cVar, boolean z5) {
            super(eVar, cVar);
            this.f10575d = false;
            this.f10574c = z5;
        }

        C0517l.a e(Context context) throws Resources.NotFoundException {
            if (this.f10575d) {
                return this.f10576e;
            }
            C0517l.a aVarB = C0517l.b(context, b().f(), b().e() == M.e.c.VISIBLE, this.f10574c);
            this.f10576e = aVarB;
            this.f10575d = true;
            return aVarB;
        }
    }

    /* renamed from: androidx.fragment.app.d$l */
    private static class l {

        /* renamed from: a, reason: collision with root package name */
        private final M.e f10577a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.c f10578b;

        l(M.e eVar, androidx.core.os.c cVar) {
            this.f10577a = eVar;
            this.f10578b = cVar;
        }

        void a() {
            this.f10577a.d(this.f10578b);
        }

        M.e b() {
            return this.f10577a;
        }

        androidx.core.os.c c() {
            return this.f10578b;
        }

        boolean d() {
            M.e.c cVarE = M.e.c.e(this.f10577a.f().f10613I);
            M.e.c cVarE2 = this.f10577a.e();
            if (cVarE == cVarE2) {
                return true;
            }
            M.e.c cVar = M.e.c.VISIBLE;
            return (cVarE == cVar || cVarE2 == cVar) ? false : true;
        }
    }

    /* renamed from: androidx.fragment.app.d$m */
    private static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final Object f10579c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f10580d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f10581e;

        m(M.e eVar, androidx.core.os.c cVar, boolean z5, boolean z6) {
            super(eVar, cVar);
            if (eVar.e() == M.e.c.VISIBLE) {
                this.f10579c = z5 ? eVar.f().P() : eVar.f().y();
                this.f10580d = z5 ? eVar.f().s() : eVar.f().r();
            } else {
                this.f10579c = z5 ? eVar.f().R() : eVar.f().B();
                this.f10580d = true;
            }
            if (!z6) {
                this.f10581e = null;
            } else if (z5) {
                this.f10581e = eVar.f().T();
            } else {
                this.f10581e = eVar.f().S();
            }
        }

        private J f(Object obj) {
            if (obj == null) {
                return null;
            }
            J j5 = H.f10456a;
            if (j5 != null && j5.e(obj)) {
                return j5;
            }
            J j6 = H.f10457b;
            if (j6 != null && j6.e(obj)) {
                return j6;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        J e() {
            J jF = f(this.f10579c);
            J jF2 = f(this.f10581e);
            if (jF == null || jF2 == null || jF == jF2) {
                return jF != null ? jF : jF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f10579c + " which uses a different Transition  type than its shared element transition " + this.f10581e);
        }

        public Object g() {
            return this.f10581e;
        }

        Object h() {
            return this.f10579c;
        }

        public boolean i() {
            return this.f10581e != null;
        }

        boolean j() {
            return this.f10580d;
        }
    }

    C0509d(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<M.e> list2, boolean z5, Map<M.e, Boolean> map) throws Resources.NotFoundException {
        M.e eVar;
        k kVar;
        View view;
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z6 = false;
        for (k kVar2 : list) {
            if (kVar2.d()) {
                kVar2.a();
            } else {
                C0517l.a aVarE = kVar2.e(context);
                if (aVarE == null) {
                    kVar2.a();
                } else {
                    Animator animator = aVarE.f10700b;
                    if (animator == null) {
                        arrayList.add(kVar2);
                    } else {
                        M.e eVarB = kVar2.b();
                        ComponentCallbacksC0511f componentCallbacksC0511fF = eVarB.f();
                        if (Boolean.TRUE.equals(map.get(eVarB))) {
                            if (x.F0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + componentCallbacksC0511fF + " as this Fragment was involved in a Transition.");
                            }
                            kVar2.a();
                        } else {
                            boolean z7 = eVarB.e() == M.e.c.GONE;
                            if (z7) {
                                list2.remove(eVarB);
                            }
                            View view2 = componentCallbacksC0511fF.f10613I;
                            viewGroupM.startViewTransition(view2);
                            ViewGroup viewGroup = viewGroupM;
                            viewGroupM = viewGroup;
                            animator.addListener(new c(viewGroup, view2, z7, eVarB, kVar2));
                            animator.setTarget(view2);
                            animator.start();
                            if (x.F0(2)) {
                                Log.v("FragmentManager", "Animator from operation " + eVarB + " has started.");
                            }
                            kVar2.c().b(new C0132d(animator, eVarB));
                            z6 = true;
                        }
                    }
                }
            }
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            k kVar3 = (k) obj;
            M.e eVarB2 = kVar3.b();
            ComponentCallbacksC0511f componentCallbacksC0511fF2 = eVarB2.f();
            if (z5) {
                if (x.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + componentCallbacksC0511fF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar3.a();
            } else if (z6) {
                if (x.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + componentCallbacksC0511fF2 + " as Animations cannot run alongside Animators.");
                }
                kVar3.a();
            } else {
                View view3 = componentCallbacksC0511fF2.f10613I;
                Animation animation = (Animation) D.h.e(((C0517l.a) D.h.e(kVar3.e(context))).f10699a);
                if (eVarB2.e() != M.e.c.REMOVED) {
                    view3.startAnimation(animation);
                    kVar3.a();
                    eVar = eVarB2;
                    kVar = kVar3;
                    view = view3;
                } else {
                    viewGroupM.startViewTransition(view3);
                    C0517l.b bVar = new C0517l.b(animation, viewGroupM, view3);
                    eVar = eVarB2;
                    kVar = kVar3;
                    view = view3;
                    bVar.setAnimationListener(new e(eVar, viewGroupM, view, kVar));
                    view.startAnimation(bVar);
                    if (x.F0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + eVar + " has started.");
                    }
                }
                kVar.c().b(new f(view, viewGroupM, kVar, eVar));
            }
        }
    }

    private Map<M.e, Boolean> x(List<m> list, List<M.e> list2, boolean z5, M.e eVar, M.e eVar2) {
        String str;
        ArrayList<View> arrayList;
        String str2;
        ArrayList<View> arrayList2;
        View view;
        View view2;
        Object objK;
        Object objK2;
        String str3;
        ArrayList arrayList3;
        ArrayList<View> arrayList4;
        Object obj;
        Rect rect;
        M.e eVar3;
        View view3;
        Rect rect2;
        ArrayList<View> arrayList5;
        C0933a c0933a;
        View view4;
        ArrayList<View> arrayList6;
        int i5;
        View view5;
        boolean z6 = z5;
        HashMap map = new HashMap();
        J j5 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                J jE = mVar.e();
                if (j5 == null) {
                    j5 = jE;
                } else if (jE != null && j5 != jE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (j5 == null) {
            for (m mVar2 : list) {
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
        } else {
            View view6 = new View(m().getContext());
            Rect rect3 = new Rect();
            ArrayList<View> arrayList7 = new ArrayList<>();
            ArrayList<View> arrayList8 = new ArrayList<>();
            C0933a c0933a2 = new C0933a();
            Iterator<m> it = list.iterator();
            Object obj2 = null;
            View view7 = null;
            boolean z7 = false;
            while (true) {
                str = "FragmentManager";
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (!next.i() || eVar == null || eVar2 == null) {
                    view3 = view6;
                    rect2 = rect3;
                    arrayList5 = arrayList7;
                    c0933a = c0933a2;
                    view4 = view7;
                    arrayList6 = arrayList8;
                } else {
                    Object objU = j5.u(j5.f(next.g()));
                    ArrayList<String> arrayListU = eVar2.f().U();
                    ArrayList<String> arrayListU2 = eVar.f().U();
                    ArrayList<String> arrayListV = eVar.f().V();
                    int i6 = 0;
                    while (i6 < arrayListV.size()) {
                        int iIndexOf = arrayListU.indexOf(arrayListV.get(i6));
                        ArrayList<String> arrayList9 = arrayListV;
                        if (iIndexOf != -1) {
                            arrayListU.set(iIndexOf, arrayListU2.get(i6));
                        }
                        i6++;
                        arrayListV = arrayList9;
                    }
                    ArrayList<String> arrayListV2 = eVar2.f().V();
                    if (z6) {
                        eVar.f().z();
                        eVar2.f().C();
                    } else {
                        eVar.f().C();
                        eVar2.f().z();
                    }
                    int i7 = 0;
                    for (int size = arrayListU.size(); i7 < size; size = size) {
                        c0933a2.put(arrayListU.get(i7), arrayListV2.get(i7));
                        i7++;
                    }
                    if (x.F0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        int i8 = 0;
                        for (int size2 = arrayListV2.size(); i8 < size2; size2 = size2) {
                            String str4 = arrayListV2.get(i8);
                            Log.v("FragmentManager", "Name: " + str4);
                            i8++;
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        int i9 = 0;
                        for (int size3 = arrayListU.size(); i9 < size3; size3 = size3) {
                            String str5 = arrayListU.get(i9);
                            Log.v("FragmentManager", "Name: " + str5);
                            i9++;
                        }
                    }
                    C0933a<String, View> c0933a3 = new C0933a<>();
                    u(c0933a3, eVar.f().f10613I);
                    c0933a3.n(arrayListU);
                    c0933a2.n(c0933a3.keySet());
                    C0933a<String, View> c0933a4 = new C0933a<>();
                    u(c0933a4, eVar2.f().f10613I);
                    c0933a4.n(arrayListV2);
                    c0933a4.n(c0933a2.values());
                    H.c(c0933a2, c0933a4);
                    v(c0933a3, c0933a2.keySet());
                    v(c0933a4, c0933a2.values());
                    if (c0933a2.isEmpty()) {
                        arrayList7.clear();
                        arrayList8.clear();
                        view3 = view6;
                        rect2 = rect3;
                        arrayList5 = arrayList7;
                        c0933a = c0933a2;
                        arrayList6 = arrayList8;
                        obj2 = null;
                        z6 = z5;
                        arrayList7 = arrayList5;
                        arrayList8 = arrayList6;
                        c0933a2 = c0933a;
                        rect3 = rect2;
                        view6 = view3;
                    } else {
                        c0933a = c0933a2;
                        H.a(eVar2.f(), eVar.f(), z6, c0933a3, true);
                        view4 = view7;
                        androidx.core.view.A.a(m(), new g(eVar2, eVar, z6, c0933a4));
                        arrayList7.addAll(c0933a3.values());
                        if (arrayListU.isEmpty()) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            View view8 = c0933a3.get(arrayListU.get(0));
                            j5.p(objU, view8);
                            view4 = view8;
                        }
                        arrayList8.addAll(c0933a4.values());
                        if (!arrayListV2.isEmpty() && (view5 = c0933a4.get(arrayListV2.get(i5))) != null) {
                            androidx.core.view.A.a(m(), new h(j5, view5, rect3));
                            z7 = true;
                        }
                        j5.s(objU, view6, arrayList7);
                        rect2 = rect3;
                        ArrayList<View> arrayList10 = arrayList7;
                        view3 = view6;
                        j5.n(objU, null, null, null, null, objU, arrayList8);
                        arrayList6 = arrayList8;
                        Boolean bool = Boolean.TRUE;
                        map.put(eVar, bool);
                        map.put(eVar2, bool);
                        arrayList5 = arrayList10;
                        obj2 = objU;
                    }
                }
                view7 = view4;
                z6 = z5;
                arrayList7 = arrayList5;
                arrayList8 = arrayList6;
                c0933a2 = c0933a;
                rect3 = rect2;
                view6 = view3;
            }
            M.e eVar4 = eVar;
            M.e eVar5 = eVar2;
            View view9 = view6;
            ArrayList<View> arrayList11 = arrayList7;
            C0933a c0933a5 = c0933a2;
            View view10 = view7;
            Rect rect4 = rect3;
            ArrayList<View> arrayList12 = arrayList8;
            ArrayList arrayList13 = new ArrayList();
            Object obj3 = null;
            Object obj4 = null;
            for (m mVar3 : list) {
                if (mVar3.d()) {
                    map.put(mVar3.b(), Boolean.FALSE);
                    mVar3.a();
                } else {
                    Object objF = j5.f(mVar3.h());
                    M.e eVarB = mVar3.b();
                    boolean z8 = obj2 != null && (eVarB == eVar4 || eVarB == eVar5);
                    if (objF == null) {
                        if (!z8) {
                            map.put(eVarB, Boolean.FALSE);
                            mVar3.a();
                        }
                        view = view9;
                        arrayList4 = arrayList11;
                        arrayList2 = arrayList12;
                        rect = rect4;
                        view2 = view10;
                        str3 = str;
                        arrayList3 = arrayList13;
                    } else {
                        Rect rect5 = rect4;
                        ArrayList<View> arrayList14 = new ArrayList<>();
                        ArrayList arrayList15 = arrayList13;
                        t(arrayList14, eVarB.f().f10613I);
                        if (z8) {
                            if (eVarB == eVar4) {
                                arrayList14.removeAll(arrayList11);
                            } else {
                                arrayList14.removeAll(arrayList12);
                            }
                        }
                        if (arrayList14.isEmpty()) {
                            j5.a(objF, view9);
                            view = view9;
                            arrayList2 = arrayList12;
                            objK2 = obj3;
                            objK = obj4;
                            eVar3 = eVarB;
                            view2 = view10;
                            str3 = str;
                            arrayList3 = arrayList15;
                            arrayList4 = arrayList11;
                            obj = objF;
                            rect = rect5;
                        } else {
                            j5.b(objF, arrayList14);
                            arrayList2 = arrayList12;
                            view = view9;
                            view2 = view10;
                            objK = obj4;
                            objK2 = obj3;
                            str3 = str;
                            arrayList3 = arrayList15;
                            arrayList4 = arrayList11;
                            obj = objF;
                            rect = rect5;
                            j5.n(obj, objF, arrayList14, null, null, null, null);
                            if (eVarB.e() == M.e.c.GONE) {
                                eVar3 = eVarB;
                                list2.remove(eVar3);
                                ArrayList<View> arrayList16 = new ArrayList<>(arrayList14);
                                arrayList16.remove(eVar3.f().f10613I);
                                j5.m(obj, eVar3.f().f10613I, arrayList16);
                                androidx.core.view.A.a(m(), new i(arrayList14));
                            } else {
                                eVar3 = eVarB;
                            }
                        }
                        if (eVar3.e() == M.e.c.VISIBLE) {
                            arrayList3.addAll(arrayList14);
                            if (z7) {
                                j5.o(obj, rect);
                            }
                        } else {
                            j5.p(obj, view2);
                        }
                        map.put(eVar3, Boolean.TRUE);
                        if (mVar3.j()) {
                            objK2 = j5.k(objK2, obj, null);
                        } else {
                            objK = j5.k(objK, obj, null);
                        }
                        obj3 = objK2;
                        obj4 = objK;
                    }
                    arrayList11 = arrayList4;
                    eVar4 = eVar;
                    eVar5 = eVar2;
                    rect4 = rect;
                    arrayList13 = arrayList3;
                    str = str3;
                    arrayList12 = arrayList2;
                    view10 = view2;
                    view9 = view;
                }
            }
            String str6 = str;
            ArrayList<View> arrayList17 = arrayList11;
            ArrayList<View> arrayList18 = arrayList12;
            ArrayList arrayList19 = arrayList13;
            Object objJ = j5.j(obj3, obj4, obj2);
            if (objJ != null) {
                for (m mVar4 : list) {
                    if (!mVar4.d()) {
                        Object objH = mVar4.h();
                        M.e eVarB2 = mVar4.b();
                        boolean z9 = obj2 != null && (eVarB2 == eVar || eVarB2 == eVar2);
                        if (objH == null && !z9) {
                            str2 = str6;
                        } else if (androidx.core.view.H.Q(m())) {
                            str2 = str6;
                            j5.q(mVar4.b().f(), objJ, mVar4.c(), new j(mVar4, eVarB2));
                        } else {
                            if (x.F0(2)) {
                                str2 = str6;
                                Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + eVarB2);
                            } else {
                                str2 = str6;
                            }
                            mVar4.a();
                        }
                        str6 = str2;
                    }
                }
                String str7 = str6;
                if (androidx.core.view.H.Q(m())) {
                    H.d(arrayList19, 4);
                    ArrayList<String> arrayListL = j5.l(arrayList18);
                    if (x.F0(2)) {
                        Log.v(str7, ">>>>> Beginning transition <<<<<");
                        Log.v(str7, ">>>>> SharedElementFirstOutViews <<<<<");
                        int size4 = arrayList17.size();
                        int i10 = 0;
                        while (i10 < size4) {
                            View view11 = arrayList17.get(i10);
                            i10++;
                            View view12 = view11;
                            Log.v(str7, "View: " + view12 + " Name: " + androidx.core.view.H.F(view12));
                        }
                        arrayList = arrayList17;
                        Log.v(str7, ">>>>> SharedElementLastInViews <<<<<");
                        int size5 = arrayList18.size();
                        int i11 = 0;
                        while (i11 < size5) {
                            View view13 = arrayList18.get(i11);
                            i11++;
                            View view14 = view13;
                            Log.v(str7, "View: " + view14 + " Name: " + androidx.core.view.H.F(view14));
                        }
                    } else {
                        arrayList = arrayList17;
                    }
                    j5.c(m(), objJ);
                    j5.r(m(), arrayList, arrayList18, arrayListL, c0933a5);
                    H.d(arrayList19, 0);
                    j5.t(obj2, arrayList, arrayList18);
                    return map;
                }
            }
        }
        return map;
    }

    private void y(List<M.e> list) {
        ComponentCallbacksC0511f componentCallbacksC0511fF = list.get(list.size() - 1).f();
        for (M.e eVar : list) {
            eVar.f().f10616L.f10676c = componentCallbacksC0511fF.f10616L.f10676c;
            eVar.f().f10616L.f10677d = componentCallbacksC0511fF.f10616L.f10677d;
            eVar.f().f10616L.f10678e = componentCallbacksC0511fF.f10616L.f10678e;
            eVar.f().f10616L.f10679f = componentCallbacksC0511fF.f10616L.f10679f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    @Override // androidx.fragment.app.M
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void f(java.util.List<androidx.fragment.app.M.e> r14, boolean r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0509d.f(java.util.List, boolean):void");
    }

    void s(M.e eVar) {
        eVar.e().b(eVar.f().f10613I);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (androidx.core.view.M.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, View view) {
        String strF = androidx.core.view.H.F(view);
        if (strF != null) {
            map.put(strF, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(C0933a<String, View> c0933a, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = c0933a.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.H.F(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
