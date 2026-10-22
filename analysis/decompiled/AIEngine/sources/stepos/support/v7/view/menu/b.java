package stepos.support.v7.view.menu;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import stepos.support.v7.app.c;
import stepos.support.v7.app.e;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements g, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f12367a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f12368b;

    /* renamed from: c, reason: collision with root package name */
    public c f12369c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f12370d;

    /* renamed from: e, reason: collision with root package name */
    public g.a f12371e;
    public a h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f12372a = -1;

        public a() {
            b();
        }

        public final void b() {
            c cVar = b.this.f12369c;
            e eVar = cVar.f12392x;
            if (eVar != null) {
                cVar.i();
                ArrayList<e> arrayList = cVar.f12381l;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayList.get(i10) == eVar) {
                        this.f12372a = i10;
                        return;
                    }
                }
            }
            this.f12372a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final e getItem(int i10) {
            b bVar = b.this;
            c cVar = bVar.f12369c;
            cVar.i();
            ArrayList<e> arrayList = cVar.f12381l;
            bVar.getClass();
            int i11 = this.f12372a;
            if (i11 >= 0 && i10 >= i11) {
                i10++;
            }
            return arrayList.get(i10);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            b bVar = b.this;
            c cVar = bVar.f12369c;
            cVar.i();
            int size = cVar.f12381l.size();
            bVar.getClass();
            return this.f12372a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public final View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = b.this.f12368b.inflate(R.layout.stepos_list_menu_item_layout, viewGroup, false);
            }
            ((h.a) view).c(getItem(i10));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public b(ContextWrapper contextWrapper) {
        this.f12367a = contextWrapper;
        this.f12368b = LayoutInflater.from(contextWrapper);
    }

    @Override // stepos.support.v7.view.menu.g
    public final void a(c cVar, boolean z) {
        g.a aVar = this.f12371e;
        if (aVar != null) {
            aVar.a(cVar, z);
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public final void b() {
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean d(e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean e(i iVar) {
        boolean zHasVisibleItems = iVar.hasVisibleItems();
        Context context = iVar.f12374a;
        if (!zHasVisibleItems) {
            return false;
        }
        d dVar = new d();
        dVar.f12394a = iVar;
        e.a aVar = new e.a(context, stepos.support.v7.app.e.resolveDialogTheme(context, 0));
        c.a aVar2 = aVar.f12101a;
        b bVar = new b(aVar2.f12081a);
        dVar.f12396c = bVar;
        bVar.f12371e = dVar;
        iVar.b(bVar, context);
        aVar2.f12092m = (a) dVar.f12396c.h();
        aVar2.f12093n = dVar;
        View view = iVar.f12386q;
        if (view != null) {
            aVar2.f12085e = view;
        } else {
            aVar2.f12083c = iVar.f12385p;
            aVar2.f12084d = iVar.f12384o;
        }
        aVar2.f12091l = dVar;
        stepos.support.v7.app.e eVarA = aVar.a(new stepos.support.v7.app.d(aVar));
        dVar.f12395b = eVarA;
        eVarA.setOnDismissListener(dVar);
        WindowManager.LayoutParams attributes = dVar.f12395b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        dVar.f12395b.show();
        g.a aVar3 = this.f12371e;
        if (aVar3 == null) {
            return true;
        }
        aVar3.b(iVar);
        return true;
    }

    @Override // stepos.support.v7.view.menu.g
    public final boolean f(e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public final void g(Context context, c cVar) {
        if (this.f12367a != null) {
            this.f12367a = context;
            if (this.f12368b == null) {
                this.f12368b = LayoutInflater.from(context);
            }
        }
        this.f12369c = cVar;
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final ListAdapter h() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    public final h i(ViewGroup viewGroup) {
        if (this.f12370d == null) {
            this.f12370d = (ExpandedMenuView) this.f12368b.inflate(R.layout.stepos_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.f12370d.setAdapter((ListAdapter) this.h);
            this.f12370d.setOnItemClickListener(this);
        }
        return this.f12370d;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f12369c.p(this.h.getItem(i10), this, 0);
    }
}
