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
import stepos.support.v7.view.menu.h;
import stepos.support.v7.view.menu.i;

/* loaded from: classes.dex */
public class c implements h, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    Context f21259a;

    /* renamed from: b, reason: collision with root package name */
    LayoutInflater f21260b;

    /* renamed from: c, reason: collision with root package name */
    d f21261c;

    /* renamed from: d, reason: collision with root package name */
    ExpandedMenuView f21262d;

    /* renamed from: e, reason: collision with root package name */
    private int f21263e;

    /* renamed from: f, reason: collision with root package name */
    int f21264f;

    /* renamed from: g, reason: collision with root package name */
    int f21265g;

    /* renamed from: h, reason: collision with root package name */
    private h.a f21266h;

    /* renamed from: i, reason: collision with root package name */
    a f21267i;

    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f21268a = -1;

        public a() {
            a();
        }

        void a() {
            f fVarV = c.this.f21261c.v();
            if (fVarV != null) {
                ArrayList<f> arrayListZ = c.this.f21261c.z();
                int size = arrayListZ.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (arrayListZ.get(i5) == fVarV) {
                        this.f21268a = i5;
                        return;
                    }
                }
            }
            this.f21268a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f getItem(int i5) {
            ArrayList<f> arrayListZ = c.this.f21261c.z();
            int i6 = i5 + c.this.f21263e;
            int i7 = this.f21268a;
            if (i7 >= 0 && i6 >= i7) {
                i6++;
            }
            return arrayListZ.get(i6);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f21261c.z().size() - c.this.f21263e;
            return this.f21268a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f21260b.inflate(cVar.f21265g, viewGroup, false);
            }
            ((i.a) view).d(getItem(i5), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i5) {
        this(i5, 0);
        this.f21259a = context;
        this.f21260b = LayoutInflater.from(context);
    }

    @Override // stepos.support.v7.view.menu.h
    public void a(d dVar, boolean z5) {
        h.a aVar = this.f21266h;
        if (aVar != null) {
            aVar.a(dVar, z5);
        }
    }

    @Override // stepos.support.v7.view.menu.h
    public void b(boolean z5) {
        a aVar = this.f21267i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean d(d dVar, f fVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean e(j jVar) {
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        new e(jVar).d(null);
        h.a aVar = this.f21266h;
        if (aVar == null) {
            return true;
        }
        aVar.b(jVar);
        return true;
    }

    @Override // stepos.support.v7.view.menu.h
    public void f(Context context, d dVar) {
        if (this.f21264f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f21264f);
            this.f21259a = contextThemeWrapper;
            this.f21260b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f21259a != null) {
            this.f21259a = context;
            if (this.f21260b == null) {
                this.f21260b = LayoutInflater.from(context);
            }
        }
        this.f21261c = dVar;
        a aVar = this.f21267i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean g(d dVar, f fVar) {
        return false;
    }

    public ListAdapter i() {
        if (this.f21267i == null) {
            this.f21267i = new a();
        }
        return this.f21267i;
    }

    public i j(ViewGroup viewGroup) {
        if (this.f21262d == null) {
            this.f21262d = (ExpandedMenuView) this.f21260b.inflate(X4.h.f6042n, viewGroup, false);
            if (this.f21267i == null) {
                this.f21267i = new a();
            }
            this.f21262d.setAdapter((ListAdapter) this.f21267i);
            this.f21262d.setOnItemClickListener(this);
        }
        return this.f21262d;
    }

    public void k(h.a aVar) {
        this.f21266h = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
        this.f21261c.L(this.f21267i.getItem(i5), this, 0);
    }

    public c(int i5, int i6) {
        this.f21265g = i5;
        this.f21264f = i6;
    }
}
