package stepos.support.v7.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import g.C0728a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
public class r implements d.a, h.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f22095a;

    /* renamed from: b, reason: collision with root package name */
    private stepos.support.v7.view.menu.d f22096b;

    /* renamed from: c, reason: collision with root package name */
    private View f22097c;

    /* renamed from: d, reason: collision with root package name */
    private stepos.support.v7.view.menu.g f22098d;

    /* renamed from: e, reason: collision with root package name */
    private b f22099e;

    /* renamed from: f, reason: collision with root package name */
    private a f22100f;

    public interface a {
        void a(r rVar);
    }

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public r(Context context, View view, int i5) {
        this(context, view, i5, C0728a.f16814K, 0);
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void a(stepos.support.v7.view.menu.d dVar, boolean z5) {
        a aVar = this.f22100f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // stepos.support.v7.view.menu.h.a
    public boolean b(stepos.support.v7.view.menu.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (!dVar.hasVisibleItems()) {
            return true;
        }
        new stepos.support.v7.view.menu.g(this.f22095a, dVar, this.f22097c).x();
        return true;
    }

    @Override // stepos.support.v7.view.menu.d.a
    public boolean c(stepos.support.v7.view.menu.d dVar, MenuItem menuItem) {
        b bVar = this.f22099e;
        if (bVar != null) {
            return bVar.onMenuItemClick(menuItem);
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.d.a
    public void d(stepos.support.v7.view.menu.d dVar) {
    }

    public void e() {
        this.f22098d.o();
    }

    public Menu f() {
        return this.f22096b;
    }

    public MenuInflater g() {
        return new b5.k(this.f22095a);
    }

    public void h(int i5) {
        g().inflate(i5, this.f22096b);
    }

    public void i(a aVar) {
        this.f22100f = aVar;
    }

    public void j(b bVar) {
        this.f22099e = bVar;
    }

    public void k() {
        this.f22098d.x();
    }

    public r(Context context, View view, int i5, int i6, int i7) {
        this.f22095a = context;
        stepos.support.v7.view.menu.d dVar = new stepos.support.v7.view.menu.d(context);
        this.f22096b = dVar;
        dVar.Q(this);
        this.f22097c = view;
        stepos.support.v7.view.menu.g gVar = new stepos.support.v7.view.menu.g(context, this.f22096b, view, false, i6, i7);
        this.f22098d = gVar;
        gVar.w(i5);
        this.f22098d.u(this);
    }
}
