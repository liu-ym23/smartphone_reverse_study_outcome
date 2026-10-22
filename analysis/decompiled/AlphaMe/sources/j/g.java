package j;

import L3.s;
import L3.z;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import k.C0661o;
import k.MenuC0643D;
import k.MenuItemC0668v;

/* loaded from: classes.dex */
public final class g implements InterfaceC0623b, K3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13059a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionMode.Callback f13060b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f13061c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f13062d;

    /* renamed from: e, reason: collision with root package name */
    public final q.l f13063e;

    public g(Context context, ActionMode.Callback callback, int i4) {
        this.f13059a = i4;
        if (i4 != 1) {
            this.f13061c = context;
            this.f13060b = callback;
            this.f13062d = new ArrayList();
            this.f13063e = new q.l(0);
            return;
        }
        this.f13061c = context;
        this.f13060b = callback;
        this.f13062d = new ArrayList();
        this.f13063e = new q.l(0);
    }

    @Override // j.InterfaceC0623b
    public final boolean a(AbstractC0624c abstractC0624c, MenuItem menuItem) {
        return this.f13060b.onActionItemClicked(j(abstractC0624c), new MenuItemC0668v(this.f13061c, (F.b) menuItem));
    }

    @Override // K3.b
    public final boolean b(K3.c cVar, L3.k kVar) {
        return this.f13060b.onCreateActionMode(i(cVar), k(kVar));
    }

    @Override // j.InterfaceC0623b
    public final boolean c(AbstractC0624c abstractC0624c, C0661o c0661o) {
        return this.f13060b.onCreateActionMode(j(abstractC0624c), k(c0661o));
    }

    @Override // K3.b
    public final boolean d(K3.c cVar, MenuItem menuItem) {
        return this.f13060b.onActionItemClicked(i(cVar), new s(this.f13061c, (F.b) menuItem));
    }

    @Override // K3.b
    public final void e(K3.c cVar) {
        this.f13060b.onDestroyActionMode(i(cVar));
    }

    @Override // j.InterfaceC0623b
    public final void f(AbstractC0624c abstractC0624c) {
        this.f13060b.onDestroyActionMode(j(abstractC0624c));
    }

    @Override // j.InterfaceC0623b
    public final boolean g(AbstractC0624c abstractC0624c, C0661o c0661o) {
        return this.f13060b.onPrepareActionMode(j(abstractC0624c), k(c0661o));
    }

    @Override // K3.b
    public final boolean h(K3.c cVar, L3.k kVar) {
        return this.f13060b.onPrepareActionMode(i(cVar), k(kVar));
    }

    public final K3.h i(K3.c cVar) {
        ArrayList arrayList = this.f13062d;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            K3.h hVar = (K3.h) arrayList.get(i4);
            if (hVar != null && hVar.f1091b == cVar) {
                return hVar;
            }
        }
        K3.h hVar2 = new K3.h(this.f13061c, cVar);
        arrayList.add(hVar2);
        return hVar2;
    }

    public final h j(AbstractC0624c abstractC0624c) {
        ArrayList arrayList = this.f13062d;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = (h) arrayList.get(i4);
            if (hVar != null && hVar.f13065b == abstractC0624c) {
                return hVar;
            }
        }
        h hVar2 = new h(this.f13061c, abstractC0624c);
        arrayList.add(hVar2);
        return hVar2;
    }

    public final Menu k(F.a aVar) {
        q.l lVar = this.f13063e;
        int i4 = this.f13059a;
        Context context = this.f13061c;
        switch (i4) {
            case 0:
                Menu menu = (Menu) lVar.get(aVar);
                if (menu != null) {
                    return menu;
                }
                MenuC0643D menuC0643D = new MenuC0643D(context, aVar);
                lVar.put(aVar, menuC0643D);
                return menuC0643D;
            default:
                Menu menu2 = (Menu) lVar.get(aVar);
                if (menu2 != null) {
                    return menu2;
                }
                z zVar = new z(context, aVar);
                lVar.put(aVar, zVar);
                return zVar;
        }
    }
}
