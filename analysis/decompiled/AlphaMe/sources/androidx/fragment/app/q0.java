package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public int f3801a;

    /* renamed from: b, reason: collision with root package name */
    public int f3802b;

    /* renamed from: c, reason: collision with root package name */
    public final D f3803c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3804d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f3805e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3806f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3807g;

    /* renamed from: h, reason: collision with root package name */
    public final c0 f3808h;

    public q0(int i4, int i5, c0 c0Var, G.c cVar) {
        D d4 = c0Var.f3722c;
        this.f3804d = new ArrayList();
        this.f3805e = new HashSet();
        this.f3806f = false;
        this.f3807g = false;
        this.f3801a = i4;
        this.f3802b = i5;
        this.f3803c = d4;
        cVar.b(new C0300w(this));
        this.f3808h = c0Var;
    }

    public final void a() {
        if (this.f3806f) {
            return;
        }
        this.f3806f = true;
        HashSet hashSet = this.f3805e;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        Iterator it = new ArrayList(hashSet).iterator();
        while (it.hasNext()) {
            ((G.c) it.next()).a();
        }
    }

    public final void b() {
        if (!this.f3807g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f3807g = true;
            Iterator it = this.f3804d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f3808h.j();
    }

    public final void c(int i4, int i5) {
        int iA = t.h.a(i5);
        D d4 = this.f3803c;
        if (iA == 0) {
            if (this.f3801a != 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + d4 + " mFinalState = " + B0.g.F(this.f3801a) + " -> " + B0.g.F(i4) + ". ");
                }
                this.f3801a = i4;
                return;
            }
            return;
        }
        if (iA == 1) {
            if (this.f3801a == 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + d4 + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + B0.g.E(this.f3802b) + " to ADDING.");
                }
                this.f3801a = 2;
                this.f3802b = 2;
                return;
            }
            return;
        }
        if (iA != 2) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + d4 + " mFinalState = " + B0.g.F(this.f3801a) + " -> REMOVED. mLifecycleImpact  = " + B0.g.E(this.f3802b) + " to REMOVING.");
        }
        this.f3801a = 1;
        this.f3802b = 3;
    }

    public final void d() {
        int i4 = this.f3802b;
        c0 c0Var = this.f3808h;
        if (i4 != 2) {
            if (i4 == 3) {
                D d4 = c0Var.f3722c;
                View viewRequireView = d4.requireView();
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + d4);
                }
                viewRequireView.clearFocus();
                return;
            }
            return;
        }
        D d5 = c0Var.f3722c;
        View viewFindFocus = d5.mView.findFocus();
        if (viewFindFocus != null) {
            d5.setFocusedView(viewFindFocus);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + d5);
            }
        }
        View viewRequireView2 = this.f3803c.requireView();
        if (viewRequireView2.getParent() == null) {
            c0Var.a();
            viewRequireView2.setAlpha(Property.DEFAULT_FLOAT_VALUE);
        }
        if (viewRequireView2.getAlpha() == Property.DEFAULT_FLOAT_VALUE && viewRequireView2.getVisibility() == 0) {
            viewRequireView2.setVisibility(4);
        }
        viewRequireView2.setAlpha(d5.getPostOnViewCreatedAlpha());
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + B0.g.F(this.f3801a) + "} {mLifecycleImpact = " + B0.g.E(this.f3802b) + "} {mFragment = " + this.f3803c + "}";
    }
}
