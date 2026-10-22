package stepos.support.v7.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;

/* loaded from: classes5.dex */
public class b implements g, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f40917a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f40918b;

    /* renamed from: c, reason: collision with root package name */
    public c f40919c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f40920d;

    /* renamed from: e, reason: collision with root package name */
    public int f40921e;

    /* renamed from: f, reason: collision with root package name */
    public int f40922f;

    /* renamed from: g, reason: collision with root package name */
    public int f40923g;

    /* renamed from: h, reason: collision with root package name */
    public g.a f40924h;

    /* renamed from: i, reason: collision with root package name */
    public a f40925i;

    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f40926a = -1;

        public a() {
            a();
        }

        public void a() {
            e eVarV = b.this.f40919c.v();
            if (eVarV != null) {
                ArrayList<e> arrayListZ = b.this.f40919c.z();
                int size = arrayListZ.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayListZ.get(i10) == eVarV) {
                        this.f40926a = i10;
                        return;
                    }
                }
            }
            this.f40926a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e getItem(int i10) {
            ArrayList<e> arrayListZ = b.this.f40919c.z();
            int i11 = i10 + b.this.f40921e;
            int i12 = this.f40926a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return arrayListZ.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = b.this.f40919c.z().size() - b.this.f40921e;
            return this.f40926a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                b bVar = b.this;
                view = bVar.f40918b.inflate(bVar.f40923g, viewGroup, false);
            }
            ((h.a) view).d(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public b(Context context, int i10) {
        this(i10, 0);
        this.f40917a = context;
        this.f40918b = LayoutInflater.from(context);
    }

    @Override // stepos.support.v7.view.menu.g
    public void a(c cVar, boolean z10) {
        g.a aVar = this.f40924h;
        if (aVar != null) {
            aVar.a(cVar, z10);
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public void b(boolean z10) {
        a aVar = this.f40925i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean d(c cVar, e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean e(i iVar) {
        if (!iVar.hasVisibleItems()) {
            return false;
        }
        new d(iVar).d(null);
        g.a aVar = this.f40924h;
        if (aVar == null) {
            return true;
        }
        aVar.b(iVar);
        return true;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean f(c cVar, e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public void g(Context context, c cVar) {
        if (this.f40922f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f40922f);
            this.f40917a = contextThemeWrapper;
            this.f40918b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f40917a != null) {
            this.f40917a = context;
            if (this.f40918b == null) {
                this.f40918b = LayoutInflater.from(context);
            }
        }
        this.f40919c = cVar;
        a aVar = this.f40925i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public ListAdapter i() {
        if (this.f40925i == null) {
            this.f40925i = new a();
        }
        return this.f40925i;
    }

    public h j(ViewGroup viewGroup) {
        if (this.f40920d == null) {
            this.f40920d = (ExpandedMenuView) this.f40918b.inflate(R$layout.stepos_expanded_menu_layout, viewGroup, false);
            if (this.f40925i == null) {
                this.f40925i = new a();
            }
            this.f40920d.setAdapter((ListAdapter) this.f40925i);
            this.f40920d.setOnItemClickListener(this);
        }
        return this.f40920d;
    }

    public void k(g.a aVar) {
        this.f40924h = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f40919c.L(this.f40925i.getItem(i10), this, 0);
    }

    public b(int i10, int i11) {
        this.f40923g = i10;
        this.f40922f = i11;
    }
}
