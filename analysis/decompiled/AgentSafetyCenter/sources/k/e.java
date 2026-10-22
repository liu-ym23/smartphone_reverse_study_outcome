package k;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import l.a0;
import l.s;
import p.p0;
import te.r;
import te.y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements se.a {

    /* renamed from: c, reason: collision with root package name */
    public ActionMode.Callback f6810c;

    /* renamed from: f, reason: collision with root package name */
    public Context f6811f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f6812g;

    /* renamed from: h, reason: collision with root package name */
    public p0 f6813h;

    public f a(a aVar) {
        ArrayList arrayList = this.f6812g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            f fVar = (f) arrayList.get(i);
            if (fVar != null && fVar.f6815b == aVar) {
                return fVar;
            }
        }
        Context context = this.f6811f;
        f fVar2 = new f();
        fVar2.f6814a = context;
        fVar2.f6815b = aVar;
        VarHandle.storeStoreFence();
        arrayList.add(fVar2);
        return fVar2;
    }

    @Override // se.a
    public boolean b(se.b bVar, Menu menu) {
        ActionMode.Callback callback = this.f6810c;
        se.g gVarF = f(bVar);
        p0 p0Var = this.f6813h;
        Menu menu2 = (Menu) p0Var.get(menu);
        if (menu2 == null) {
            y yVar = new y(this.f6811f, (h3.a) menu);
            p0Var.put(menu, yVar);
            menu2 = yVar;
        }
        return callback.onPrepareActionMode(gVarF, menu2);
    }

    @Override // se.a
    public boolean c(se.b bVar, Menu menu) {
        ActionMode.Callback callback = this.f6810c;
        se.g gVarF = f(bVar);
        p0 p0Var = this.f6813h;
        Menu menu2 = (Menu) p0Var.get(menu);
        if (menu2 == null) {
            y yVar = new y(this.f6811f, (h3.a) menu);
            p0Var.put(menu, yVar);
            menu2 = yVar;
        }
        return callback.onCreateActionMode(gVarF, menu2);
    }

    @Override // se.a
    public boolean d(se.b bVar, MenuItem menuItem) {
        return this.f6810c.onActionItemClicked(f(bVar), new r(this.f6811f, (h3.b) menuItem));
    }

    @Override // se.a
    public void e(se.b bVar) {
        this.f6810c.onDestroyActionMode(f(bVar));
    }

    public se.g f(se.b bVar) {
        ArrayList arrayList = this.f6812g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            se.g gVar = (se.g) arrayList.get(i);
            if (gVar != null && gVar.f12228b == bVar) {
                return gVar;
            }
        }
        Context context = this.f6811f;
        se.g gVar2 = new se.g();
        gVar2.f12227a = context;
        gVar2.f12228b = bVar;
        VarHandle.storeStoreFence();
        arrayList.add(gVar2);
        return gVar2;
    }

    public boolean g(a aVar, MenuItem menuItem) {
        return this.f6810c.onActionItemClicked(a(aVar), new s(this.f6811f, (h3.b) menuItem));
    }

    public boolean h(a aVar, l.l lVar) {
        ActionMode.Callback callback = this.f6810c;
        f fVarA = a(aVar);
        p0 p0Var = this.f6813h;
        Menu a0Var = (Menu) p0Var.get(lVar);
        if (a0Var == null) {
            a0Var = new a0(this.f6811f, lVar);
            p0Var.put(lVar, a0Var);
        }
        return callback.onCreateActionMode(fVarA, a0Var);
    }
}
