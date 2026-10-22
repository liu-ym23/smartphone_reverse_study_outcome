package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    Context f7858a;

    /* renamed from: b, reason: collision with root package name */
    LayoutInflater f7859b;

    /* renamed from: c, reason: collision with root package name */
    e f7860c;

    /* renamed from: d, reason: collision with root package name */
    ExpandedMenuView f7861d;

    /* renamed from: e, reason: collision with root package name */
    int f7862e;

    /* renamed from: f, reason: collision with root package name */
    int f7863f;

    /* renamed from: g, reason: collision with root package name */
    int f7864g;

    /* renamed from: h, reason: collision with root package name */
    private j.a f7865h;

    /* renamed from: i, reason: collision with root package name */
    a f7866i;

    private class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f7867a = -1;

        public a() {
            a();
        }

        void a() {
            g gVarV = c.this.f7860c.v();
            if (gVarV != null) {
                ArrayList<g> arrayListZ = c.this.f7860c.z();
                int size = arrayListZ.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (arrayListZ.get(i5) == gVarV) {
                        this.f7867a = i5;
                        return;
                    }
                }
            }
            this.f7867a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i5) {
            ArrayList<g> arrayListZ = c.this.f7860c.z();
            int i6 = i5 + c.this.f7862e;
            int i7 = this.f7867a;
            if (i7 >= 0 && i6 >= i7) {
                i6++;
            }
            return arrayListZ.get(i6);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f7860c.z().size() - c.this.f7862e;
            return this.f7867a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f7859b.inflate(cVar.f7864g, viewGroup, false);
            }
            ((k.a) view).f(getItem(i5), 0);
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
        this.f7858a = context;
        this.f7859b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f7866i == null) {
            this.f7866i = new a();
        }
        return this.f7866i;
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(boolean z5) {
        a aVar = this.f7866i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(e eVar, boolean z5) {
        j.a aVar = this.f7865h;
        if (aVar != null) {
            aVar.d(eVar, z5);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f7865h = aVar;
    }

    public k h(ViewGroup viewGroup) {
        if (this.f7861d == null) {
            this.f7861d = (ExpandedMenuView) this.f7859b.inflate(g.g.f16951g, viewGroup, false);
            if (this.f7866i == null) {
                this.f7866i = new a();
            }
            this.f7861d.setAdapter((ListAdapter) this.f7866i);
            this.f7861d.setOnItemClickListener(this);
        }
        return this.f7861d;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        if (this.f7863f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f7863f);
            this.f7858a = contextThemeWrapper;
            this.f7859b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f7858a != null) {
            this.f7858a = context;
            if (this.f7859b == null) {
                this.f7859b = LayoutInflater.from(context);
            }
        }
        this.f7860c = eVar;
        a aVar = this.f7866i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean j(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).b(null);
        j.a aVar = this.f7865h;
        if (aVar == null) {
            return true;
        }
        aVar.e(mVar);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
        this.f7860c.N(this.f7866i.getItem(i5), this, 0);
    }

    public c(int i5, int i6) {
        this.f7864g = i5;
        this.f7863f = i6;
    }
}
