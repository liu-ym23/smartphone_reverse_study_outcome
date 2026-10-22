package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.stepos.aiengine.R;
import com.stepos.core.download.ModelFlowMeta;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.WeakHashMap;
import r0.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f2049a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Operation> f2050b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Operation> f2051c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2052d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2053e = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f2071a;

        public a(c cVar) {
            this.f2071a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList<Operation> arrayList = SpecialEffectsController.this.f2050b;
            c cVar = this.f2071a;
            if (arrayList.contains(cVar)) {
                cVar.f2054a.a(cVar.f2056c.mView);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f2073a;

        public b(c cVar) {
            this.f2073a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SpecialEffectsController specialEffectsController = SpecialEffectsController.this;
            ArrayList<Operation> arrayList = specialEffectsController.f2050b;
            c cVar = this.f2073a;
            arrayList.remove(cVar);
            specialEffectsController.f2051c.remove(cVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends Operation {
        public final b0 h;

        public c(Operation.State state, Operation.LifecycleImpact lifecycleImpact, b0 b0Var, r0.c cVar) {
            super(state, lifecycleImpact, b0Var.f2081c, cVar);
            this.h = b0Var;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public final void b() {
            super.b();
            this.h.j();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public final void d() {
            Operation.LifecycleImpact lifecycleImpact = this.f2055b;
            Operation.LifecycleImpact lifecycleImpact2 = Operation.LifecycleImpact.f2062b;
            b0 b0Var = this.h;
            if (lifecycleImpact != lifecycleImpact2) {
                if (lifecycleImpact == Operation.LifecycleImpact.f2063c) {
                    Fragment fragment = b0Var.f2081c;
                    View viewRequireView = fragment.requireView();
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragment);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = b0Var.f2081c;
            View viewFindFocus = fragment2.mView.findFocus();
            if (viewFindFocus != null) {
                fragment2.setFocusedView(viewFindFocus);
                if (FragmentManager.G(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment2);
                }
            }
            View viewRequireView2 = this.f2056c.requireView();
            if (viewRequireView2.getParent() == null) {
                b0Var.a();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
        }
    }

    public SpecialEffectsController(ViewGroup viewGroup) {
        this.f2049a = viewGroup;
    }

    public static SpecialEffectsController f(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return g(viewGroup, fragmentManager.E());
    }

    public static SpecialEffectsController g(ViewGroup viewGroup, m0 m0Var) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        ((FragmentManager.e) m0Var).getClass();
        k kVar = new k(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, kVar);
        return kVar;
    }

    public final void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, b0 b0Var) {
        synchronized (this.f2050b) {
            try {
                r0.c cVar = new r0.c();
                Operation operationD = d(b0Var.f2081c);
                if (operationD != null) {
                    operationD.c(state, lifecycleImpact);
                    return;
                }
                c cVar2 = new c(state, lifecycleImpact, b0Var, cVar);
                this.f2050b.add(cVar2);
                cVar2.f2057d.add(new a(cVar2));
                cVar2.f2057d.add(new b(cVar2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(ArrayList arrayList, boolean z);

    public final void c() {
        if (this.f2053e) {
            return;
        }
        ViewGroup viewGroup = this.f2049a;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.f2052d = false;
            return;
        }
        synchronized (this.f2050b) {
            try {
                if (!this.f2050b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2051c);
                    this.f2051c.clear();
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        Operation operation = (Operation) obj;
                        if (FragmentManager.G(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.a();
                        if (!operation.f2060g) {
                            this.f2051c.add(operation);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.f2050b);
                    this.f2050b.clear();
                    this.f2051c.addAll(arrayList2);
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = arrayList2.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj2 = arrayList2.get(i11);
                        i11++;
                        ((Operation) obj2).d();
                    }
                    b(arrayList2, this.f2052d);
                    this.f2052d = false;
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Operation d(Fragment fragment) {
        ArrayList<Operation> arrayList = this.f2050b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Operation operation = arrayList.get(i10);
            i10++;
            Operation operation2 = operation;
            if (operation2.f2056c.equals(fragment) && !operation2.f2059f) {
                return operation2;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        if (FragmentManager.G(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.f2049a;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f2050b) {
            try {
                i();
                ArrayList<Operation> arrayList = this.f2050b;
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i11 < size) {
                    Operation operation = arrayList.get(i11);
                    i11++;
                    operation.d();
                }
                ArrayList arrayList2 = new ArrayList(this.f2051c);
                int size2 = arrayList2.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj = arrayList2.get(i12);
                    i12++;
                    Operation operation2 = (Operation) obj;
                    if (FragmentManager.G(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f2049a + " is not attached to window. ";
                        }
                        sb2.append(str2);
                        sb2.append("Cancelling running operation ");
                        sb2.append(operation2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    operation2.a();
                }
                ArrayList arrayList3 = new ArrayList(this.f2050b);
                int size3 = arrayList3.size();
                while (i10 < size3) {
                    Object obj2 = arrayList3.get(i10);
                    i10++;
                    Operation operation3 = (Operation) obj2;
                    if (FragmentManager.G(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f2049a + " is not attached to window. ";
                        }
                        sb3.append(str);
                        sb3.append("Cancelling pending operation ");
                        sb3.append(operation3);
                        Log.v("FragmentManager", sb3.toString());
                    }
                    operation3.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.f2050b) {
            try {
                i();
                this.f2053e = false;
                int size = this.f2050b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Operation operation = this.f2050b.get(size);
                    Operation.State stateC = Operation.State.c(operation.f2056c.mView);
                    Operation.State state = operation.f2054a;
                    Operation.State state2 = Operation.State.f2066b;
                    if (state == state2 && stateC != state2) {
                        this.f2053e = operation.f2056c.isPostponed();
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
        ArrayList<Operation> arrayList = this.f2050b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Operation operation = arrayList.get(i10);
            i10++;
            Operation operation2 = operation;
            if (operation2.f2055b == Operation.LifecycleImpact.f2062b) {
                operation2.c(Operation.State.b(operation2.f2056c.requireView().getVisibility()), Operation.LifecycleImpact.f2061a);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        public State f2054a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleImpact f2055b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f2056c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f2057d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final HashSet<r0.c> f2058e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        public boolean f2059f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2060g = false;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class LifecycleImpact {

            /* renamed from: a, reason: collision with root package name */
            public static final LifecycleImpact f2061a;

            /* renamed from: b, reason: collision with root package name */
            public static final LifecycleImpact f2062b;

            /* renamed from: c, reason: collision with root package name */
            public static final LifecycleImpact f2063c;

            /* renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ LifecycleImpact[] f2064d;

            static {
                LifecycleImpact lifecycleImpact = new LifecycleImpact(ModelFlowMeta.PLAN_NONE, 0);
                f2061a = lifecycleImpact;
                LifecycleImpact lifecycleImpact2 = new LifecycleImpact("ADDING", 1);
                f2062b = lifecycleImpact2;
                LifecycleImpact lifecycleImpact3 = new LifecycleImpact("REMOVING", 2);
                f2063c = lifecycleImpact3;
                f2064d = new LifecycleImpact[]{lifecycleImpact, lifecycleImpact2, lifecycleImpact3};
            }

            public LifecycleImpact() {
                throw null;
            }

            public static LifecycleImpact valueOf(String str) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, str);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) f2064d.clone();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class State {

            /* renamed from: a, reason: collision with root package name */
            public static final State f2065a;

            /* renamed from: b, reason: collision with root package name */
            public static final State f2066b;

            /* renamed from: c, reason: collision with root package name */
            public static final State f2067c;

            /* renamed from: d, reason: collision with root package name */
            public static final State f2068d;

            /* renamed from: e, reason: collision with root package name */
            public static final /* synthetic */ State[] f2069e;

            static {
                State state = new State("REMOVED", 0);
                f2065a = state;
                State state2 = new State("VISIBLE", 1);
                f2066b = state2;
                State state3 = new State("GONE", 2);
                f2067c = state3;
                State state4 = new State("INVISIBLE", 3);
                f2068d = state4;
                f2069e = new State[]{state, state2, state3, state4};
            }

            public State() {
                throw null;
            }

            public static State b(int i10) {
                if (i10 == 0) {
                    return f2066b;
                }
                if (i10 == 4) {
                    return f2068d;
                }
                if (i10 == 8) {
                    return f2067c;
                }
                throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Unknown visibility "));
            }

            public static State c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? f2068d : b(view.getVisibility());
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) f2069e.clone();
            }

            public final void a(View view) {
                int iOrdinal = ordinal();
                if (iOrdinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.G(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (iOrdinal == 1) {
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (iOrdinal == 2) {
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (iOrdinal != 3) {
                    return;
                }
                if (FragmentManager.G(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements c.a {
            public a() {
            }

            @Override // r0.c.a
            public final void onCancel() {
                Operation.this.a();
            }
        }

        public Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, r0.c cVar) {
            this.f2054a = state;
            this.f2055b = lifecycleImpact;
            this.f2056c = fragment;
            cVar.a(new a());
        }

        public final void a() {
            HashSet<r0.c> hashSet = this.f2058e;
            if (this.f2059f) {
                return;
            }
            this.f2059f = true;
            if (hashSet.isEmpty()) {
                b();
                return;
            }
            ArrayList arrayList = new ArrayList(hashSet);
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                r0.c cVar = (r0.c) obj;
                synchronized (cVar) {
                    try {
                        if (!cVar.f11673a) {
                            cVar.f11673a = true;
                            cVar.f11675c = true;
                            c.a aVar = cVar.f11674b;
                            if (aVar != null) {
                                try {
                                    aVar.onCancel();
                                } catch (Throwable th) {
                                    synchronized (cVar) {
                                        cVar.f11675c = false;
                                        cVar.notifyAll();
                                        throw th;
                                    }
                                }
                            }
                            synchronized (cVar) {
                                cVar.f11675c = false;
                                cVar.notifyAll();
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        public void b() {
            if (this.f2060g) {
                return;
            }
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f2060g = true;
            ArrayList arrayList = this.f2057d;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((Runnable) obj).run();
            }
        }

        public final void c(State state, LifecycleImpact lifecycleImpact) {
            int iOrdinal = lifecycleImpact.ordinal();
            Fragment fragment = this.f2056c;
            State state2 = State.f2065a;
            if (iOrdinal == 0) {
                if (this.f2054a != state2) {
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f2054a + " -> " + state + ". ");
                    }
                    this.f2054a = state;
                    return;
                }
                return;
            }
            if (iOrdinal == 1) {
                if (this.f2054a == state2) {
                    if (FragmentManager.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2055b + " to ADDING.");
                    }
                    this.f2054a = State.f2066b;
                    this.f2055b = LifecycleImpact.f2062b;
                    return;
                }
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f2054a + " -> REMOVED. mLifecycleImpact  = " + this.f2055b + " to REMOVING.");
            }
            this.f2054a = state2;
            this.f2055b = LifecycleImpact.f2063c;
        }

        public final String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2054a + "} {mLifecycleImpact = " + this.f2055b + "} {mFragment = " + this.f2056c + "}";
        }

        public void d() {
        }
    }
}
