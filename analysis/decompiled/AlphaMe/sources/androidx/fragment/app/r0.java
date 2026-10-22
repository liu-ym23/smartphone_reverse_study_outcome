package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f3825a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3826b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3827c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f3828d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3829e = false;

    public r0(ViewGroup viewGroup) {
        this.f3825a = viewGroup;
    }

    public static r0 f(ViewGroup viewGroup, P p4) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof r0) {
            return (r0) tag;
        }
        p4.getClass();
        C0291m c0291m = new C0291m(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0291m);
        return c0291m;
    }

    public static r0 g(ViewGroup viewGroup, Y y4) {
        return f(viewGroup, y4.E());
    }

    public final void a(int i4, int i5, c0 c0Var) {
        synchronized (this.f3826b) {
            try {
                G.c cVar = new G.c();
                q0 q0VarD = d(c0Var.f3722c);
                if (q0VarD != null) {
                    q0VarD.c(i4, i5);
                    return;
                }
                q0 q0Var = new q0(i4, i5, c0Var, cVar);
                this.f3826b.add(q0Var);
                q0Var.f3804d.add(new p0(this, q0Var, 0));
                q0Var.f3804d.add(new p0(this, q0Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(ArrayList arrayList, boolean z4);

    public final void c() {
        if (this.f3829e) {
            return;
        }
        ViewGroup viewGroup = this.f3825a;
        WeakHashMap weakHashMap = K.S.f939a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.f3828d = false;
            return;
        }
        synchronized (this.f3826b) {
            try {
                if (!this.f3826b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f3827c);
                    this.f3827c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        q0 q0Var = (q0) it.next();
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + q0Var);
                        }
                        q0Var.a();
                        if (!q0Var.f3807g) {
                            this.f3827c.add(q0Var);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.f3826b);
                    this.f3826b.clear();
                    this.f3827c.addAll(arrayList2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((q0) it2.next()).d();
                    }
                    b(arrayList2, this.f3828d);
                    this.f3828d = false;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final q0 d(D d4) {
        Iterator it = this.f3826b.iterator();
        while (it.hasNext()) {
            q0 q0Var = (q0) it.next();
            if (q0Var.f3803c.equals(d4) && !q0Var.f3806f) {
                return q0Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.f3825a;
        WeakHashMap weakHashMap = K.S.f939a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f3826b) {
            try {
                i();
                Iterator it = this.f3826b.iterator();
                while (it.hasNext()) {
                    ((q0) it.next()).d();
                }
                Iterator it2 = new ArrayList(this.f3827c).iterator();
                while (it2.hasNext()) {
                    q0 q0Var = (q0) it2.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f3825a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(q0Var);
                        Log.v("FragmentManager", sb.toString());
                    }
                    q0Var.a();
                }
                Iterator it3 = new ArrayList(this.f3826b).iterator();
                while (it3.hasNext()) {
                    q0 q0Var2 = (q0) it3.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f3825a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(q0Var2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    q0Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.f3826b) {
            try {
                i();
                this.f3829e = false;
                int size = this.f3826b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    q0 q0Var = (q0) this.f3826b.get(size);
                    int iC = B0.g.c(q0Var.f3803c.mView);
                    if (q0Var.f3801a == 2 && iC != 2) {
                        this.f3829e = q0Var.f3803c.isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        Iterator it = this.f3826b.iterator();
        while (it.hasNext()) {
            q0 q0Var = (q0) it.next();
            if (q0Var.f3802b == 2) {
                q0Var.c(B0.g.b(q0Var.f3803c.requireView().getVisibility()), 1);
            }
        }
    }
}
