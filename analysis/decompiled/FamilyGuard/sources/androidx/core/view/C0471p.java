package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0537q;
import androidx.lifecycle.InterfaceC0539t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.core.view.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0471p {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f9820a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<r> f9821b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<r, a> f9822c = new HashMap();

    /* renamed from: androidx.core.view.p$a */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final AbstractC0533m f9823a;

        /* renamed from: b, reason: collision with root package name */
        private InterfaceC0537q f9824b;

        a(AbstractC0533m abstractC0533m, InterfaceC0537q interfaceC0537q) {
            this.f9823a = abstractC0533m;
            this.f9824b = interfaceC0537q;
            abstractC0533m.a(interfaceC0537q);
        }

        void a() {
            this.f9823a.d(this.f9824b);
            this.f9824b = null;
        }
    }

    public C0471p(Runnable runnable) {
        this.f9820a = runnable;
    }

    public static /* synthetic */ void a(C0471p c0471p, AbstractC0533m.b bVar, r rVar, InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        c0471p.getClass();
        if (aVar == AbstractC0533m.a.g(bVar)) {
            c0471p.c(rVar);
            return;
        }
        if (aVar == AbstractC0533m.a.ON_DESTROY) {
            c0471p.j(rVar);
        } else if (aVar == AbstractC0533m.a.d(bVar)) {
            c0471p.f9821b.remove(rVar);
            c0471p.f9820a.run();
        }
    }

    public static /* synthetic */ void b(C0471p c0471p, r rVar, InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        c0471p.getClass();
        if (aVar == AbstractC0533m.a.ON_DESTROY) {
            c0471p.j(rVar);
        }
    }

    public void c(r rVar) {
        this.f9821b.add(rVar);
        this.f9820a.run();
    }

    public void d(final r rVar, InterfaceC0539t interfaceC0539t) {
        c(rVar);
        AbstractC0533m lifecycle = interfaceC0539t.getLifecycle();
        a aVarRemove = this.f9822c.remove(rVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f9822c.put(rVar, new a(lifecycle, new InterfaceC0537q() { // from class: androidx.core.view.o
            @Override // androidx.lifecycle.InterfaceC0537q
            public final void f(InterfaceC0539t interfaceC0539t2, AbstractC0533m.a aVar) {
                C0471p.b(this.f9818a, rVar, interfaceC0539t2, aVar);
            }
        }));
    }

    public void e(final r rVar, InterfaceC0539t interfaceC0539t, final AbstractC0533m.b bVar) {
        AbstractC0533m lifecycle = interfaceC0539t.getLifecycle();
        a aVarRemove = this.f9822c.remove(rVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f9822c.put(rVar, new a(lifecycle, new InterfaceC0537q() { // from class: androidx.core.view.n
            @Override // androidx.lifecycle.InterfaceC0537q
            public final void f(InterfaceC0539t interfaceC0539t2, AbstractC0533m.a aVar) {
                C0471p.a(this.f9815a, bVar, rVar, interfaceC0539t2, aVar);
            }
        }));
    }

    public void f(Menu menu, MenuInflater menuInflater) {
        Iterator<r> it = this.f9821b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void g(Menu menu) {
        Iterator<r> it = this.f9821b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean h(MenuItem menuItem) {
        Iterator<r> it = this.f9821b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void i(Menu menu) {
        Iterator<r> it = this.f9821b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void j(r rVar) {
        this.f9821b.remove(rVar);
        a aVarRemove = this.f9822c.remove(rVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f9820a.run();
    }
}
