package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.t;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final MotionLayout f12552a;

    /* renamed from: c, reason: collision with root package name */
    public HashSet<View> f12554c;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<t.b> f12556e;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<t> f12553b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public String f12555d = "ViewTransitionController";

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<t.b> f12557f = new ArrayList<>();

    public class a implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f12558a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12559b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f12560c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f12561d;

        public a(t tVar, int i10, boolean z10, int i11) {
            this.f12558a = tVar;
            this.f12559b = i10;
            this.f12560c = z10;
            this.f12561d = i11;
        }
    }

    public u(MotionLayout motionLayout) {
        this.f12552a = motionLayout;
    }

    public void a(t tVar) {
        this.f12553b.add(tVar);
        this.f12554c = null;
        if (tVar.i() == 4) {
            e(tVar, true);
        } else if (tVar.i() == 5) {
            e(tVar, false);
        }
    }

    public void b(t.b bVar) {
        if (this.f12556e == null) {
            this.f12556e = new ArrayList<>();
        }
        this.f12556e.add(bVar);
    }

    public void c() {
        ArrayList<t.b> arrayList = this.f12556e;
        if (arrayList == null) {
            return;
        }
        Iterator<t.b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f12556e.removeAll(this.f12557f);
        this.f12557f.clear();
        if (this.f12556e.isEmpty()) {
            this.f12556e = null;
        }
    }

    public void d() {
        this.f12552a.invalidate();
    }

    public final void e(t tVar, boolean z10) {
        ConstraintLayout.getSharedValues().a(tVar.h(), new a(tVar, tVar.h(), z10, tVar.g()));
    }

    public void f(t.b bVar) {
        this.f12557f.add(bVar);
    }

    public void g(MotionEvent motionEvent) {
        u uVar;
        int currentState = this.f12552a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f12554c == null) {
            this.f12554c = new HashSet<>();
            Iterator<t> it = this.f12553b.iterator();
            while (it.hasNext()) {
                t next = it.next();
                int childCount = this.f12552a.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = this.f12552a.getChildAt(i10);
                    if (next.j(childAt)) {
                        childAt.getId();
                        this.f12554c.add(childAt);
                    }
                }
            }
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<t.b> arrayList = this.f12556e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<t.b> it2 = this.f12556e.iterator();
            while (it2.hasNext()) {
                it2.next().d(action, x10, y10);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.c cVarN = this.f12552a.N(currentState);
            Iterator<t> it3 = this.f12553b.iterator();
            while (it3.hasNext()) {
                t next2 = it3.next();
                if (next2.l(action)) {
                    Iterator<View> it4 = this.f12554c.iterator();
                    while (it4.hasNext()) {
                        View next3 = it4.next();
                        if (next2.j(next3)) {
                            next3.getHitRect(rect);
                            if (rect.contains((int) x10, (int) y10)) {
                                View[] viewArr = {next3};
                                uVar = this;
                                next2.c(uVar, this.f12552a, currentState, cVarN, viewArr);
                            } else {
                                uVar = this;
                            }
                            this = uVar;
                        }
                    }
                }
                this = this;
            }
        }
    }

    public void h(int i10, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<t> it = this.f12553b.iterator();
        t tVar = null;
        while (it.hasNext()) {
            t next = it.next();
            if (next.e() == i10) {
                for (View view : viewArr) {
                    if (next.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    i(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                tVar = next;
            }
        }
        if (tVar == null) {
            Log.e(this.f12555d, " Could not find ViewTransition");
        }
    }

    public final void i(t tVar, View... viewArr) {
        int currentState = this.f12552a.getCurrentState();
        if (tVar.f12517e == 2) {
            tVar.c(this, this.f12552a, currentState, null, viewArr);
            return;
        }
        if (currentState != -1) {
            androidx.constraintlayout.widget.c cVarN = this.f12552a.N(currentState);
            if (cVarN == null) {
                return;
            }
            tVar.c(this, this.f12552a, currentState, cVarN, viewArr);
            return;
        }
        Log.w(this.f12555d, "No support for ViewTransition within transition yet. Currently: " + this.f12552a.toString());
    }
}
