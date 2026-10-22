package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c implements i, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f8597a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f8598b;

    /* renamed from: c, reason: collision with root package name */
    public e f8599c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f8600d;

    /* renamed from: e, reason: collision with root package name */
    public int f8601e;

    /* renamed from: f, reason: collision with root package name */
    public int f8602f;

    /* renamed from: g, reason: collision with root package name */
    public int f8603g;

    /* renamed from: h, reason: collision with root package name */
    public i.a f8604h;

    /* renamed from: i, reason: collision with root package name */
    public a f8605i;

    /* renamed from: j, reason: collision with root package name */
    public int f8606j;

    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f8607a = -1;

        public a() {
            a();
        }

        public void a() {
            g gVarX = c.this.f8599c.x();
            if (gVarX != null) {
                ArrayList<g> arrayListB = c.this.f8599c.B();
                int size = arrayListB.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayListB.get(i10) == gVarX) {
                        this.f8607a = i10;
                        return;
                    }
                }
            }
            this.f8607a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i10) {
            ArrayList<g> arrayListB = c.this.f8599c.B();
            int i11 = i10 + c.this.f8601e;
            int i12 = this.f8607a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return arrayListB.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f8599c.B().size() - c.this.f8601e;
            return this.f8607a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f8598b.inflate(cVar.f8603g, viewGroup, false);
            }
            ((j.a) view).e(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i10) {
        this(i10, 0);
        this.f8597a = context;
        this.f8598b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(e eVar, boolean z10) {
        i.a aVar = this.f8604h;
        if (aVar != null) {
            aVar.a(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z10) {
        a aVar = this.f8605i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean d(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void e(i.a aVar) {
        this.f8604h = aVar;
    }

    @Override // androidx.appcompat.view.menu.i
    public void f(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean g(l lVar) {
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        new f(lVar).d(null);
        i.a aVar = this.f8604h;
        if (aVar == null) {
            return true;
        }
        aVar.b(lVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return this.f8606j;
    }

    @Override // androidx.appcompat.view.menu.i
    public Parcelable h() {
        if (this.f8600d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean i(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(Context context, e eVar) {
        if (this.f8602f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f8602f);
            this.f8597a = contextThemeWrapper;
            this.f8598b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f8597a != null) {
            this.f8597a = context;
            if (this.f8598b == null) {
                this.f8598b = LayoutInflater.from(context);
            }
        }
        this.f8599c = eVar;
        a aVar = this.f8605i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public ListAdapter k() {
        if (this.f8605i == null) {
            this.f8605i = new a();
        }
        return this.f8605i;
    }

    public j l(ViewGroup viewGroup) {
        if (this.f8600d == null) {
            this.f8600d = (ExpandedMenuView) this.f8598b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f8605i == null) {
                this.f8605i = new a();
            }
            this.f8600d.setAdapter((ListAdapter) this.f8605i);
            this.f8600d.setOnItemClickListener(this);
        }
        return this.f8600d;
    }

    public void m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f8600d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f8600d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f8599c.P(this.f8605i.getItem(i10), this, 0);
    }

    public c(int i10, int i11) {
        this.f8603g = i10;
        this.f8602f = i11;
    }
}
