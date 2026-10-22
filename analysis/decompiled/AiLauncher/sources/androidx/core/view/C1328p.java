package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.core.view.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1328p {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f13206a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<r> f13207b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final Map<r, a> f13208c = new HashMap();

    /* renamed from: androidx.core.view.p$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f13209a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC1395m f13210b;

        public a(Lifecycle lifecycle, InterfaceC1395m interfaceC1395m) {
            this.f13209a = lifecycle;
            this.f13210b = interfaceC1395m;
            lifecycle.a(interfaceC1395m);
        }

        public void a() {
            this.f13209a.d(this.f13210b);
            this.f13210b = null;
        }
    }

    public C1328p(Runnable runnable) {
        this.f13206a = runnable;
    }

    public static /* synthetic */ void a(C1328p c1328p, Lifecycle.State state, r rVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        c1328p.getClass();
        if (event == Lifecycle.Event.upTo(state)) {
            c1328p.c(rVar);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            c1328p.j(rVar);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            c1328p.f13207b.remove(rVar);
            c1328p.f13206a.run();
        }
    }

    public static /* synthetic */ void b(C1328p c1328p, r rVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        c1328p.getClass();
        if (event == Lifecycle.Event.ON_DESTROY) {
            c1328p.j(rVar);
        }
    }

    public void c(r rVar) {
        this.f13207b.add(rVar);
        this.f13206a.run();
    }

    public void d(final r rVar, LifecycleOwner lifecycleOwner) {
        c(rVar);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a aVarRemove = this.f13208c.remove(rVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f13208c.put(rVar, new a(lifecycle, new InterfaceC1395m() { // from class: androidx.core.view.o
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                C1328p.b(this.f13204a, rVar, lifecycleOwner2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void e(final r rVar, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a aVarRemove = this.f13208c.remove(rVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f13208c.put(rVar, new a(lifecycle, new InterfaceC1395m() { // from class: androidx.core.view.n
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                C1328p.a(this.f13201a, state, rVar, lifecycleOwner2, event);
            }
        }));
    }

    public void f(Menu menu, MenuInflater menuInflater) {
        Iterator<r> it = this.f13207b.iterator();
        while (it.hasNext()) {
            it.next().d(menu, menuInflater);
        }
    }

    public void g(Menu menu) {
        Iterator<r> it = this.f13207b.iterator();
        while (it.hasNext()) {
            it.next().a(menu);
        }
    }

    public boolean h(MenuItem menuItem) {
        Iterator<r> it = this.f13207b.iterator();
        while (it.hasNext()) {
            if (it.next().c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void i(Menu menu) {
        Iterator<r> it = this.f13207b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public void j(r rVar) {
        this.f13207b.remove(rVar);
        a aVarRemove = this.f13208c.remove(rVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f13206a.run();
    }
}
