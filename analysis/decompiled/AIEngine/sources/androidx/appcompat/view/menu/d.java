package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements j, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f466a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f467b;

    /* renamed from: c, reason: collision with root package name */
    public f f468c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f469d;

    /* renamed from: e, reason: collision with root package name */
    public j.a f470e;
    public a h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f471a = -1;

        public a() {
            b();
        }

        public final void b() {
            f fVar = d.this.f468c;
            h hVar = fVar.z;
            if (hVar != null) {
                fVar.i();
                ArrayList<h> arrayList = fVar.f486m;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayList.get(i10) == hVar) {
                        this.f471a = i10;
                        return;
                    }
                }
            }
            this.f471a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final h getItem(int i10) {
            d dVar = d.this;
            f fVar = dVar.f468c;
            fVar.i();
            ArrayList<h> arrayList = fVar.f486m;
            dVar.getClass();
            int i11 = this.f471a;
            if (i11 >= 0 && i10 >= i11) {
                i10++;
            }
            return arrayList.get(i10);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            d dVar = d.this;
            f fVar = dVar.f468c;
            fVar.i();
            int size = fVar.f486m.size();
            dVar.getClass();
            return this.f471a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public final View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = d.this.f467b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
            }
            ((k.a) view).d(getItem(i10));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public d(ContextWrapper contextWrapper) {
        this.f466a = contextWrapper;
        this.f467b = LayoutInflater.from(contextWrapper);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z) {
        j.a aVar = this.f470e;
        if (aVar != null) {
            aVar.a(fVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b() {
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void d(j.a aVar) {
        throw null;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean e(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean f(m mVar) {
        boolean zHasVisibleItems = mVar.hasVisibleItems();
        Context context = mVar.f478a;
        if (!zHasVisibleItems) {
            return false;
        }
        g gVar = new g();
        gVar.f498a = mVar;
        f.a aVar = new f.a(context);
        AlertController.b bVar = aVar.f323a;
        d dVar = new d(bVar.f239a);
        gVar.f500c = dVar;
        dVar.f470e = gVar;
        mVar.b(dVar, context);
        d dVar2 = gVar.f500c;
        if (dVar2.h == null) {
            dVar2.h = dVar2.new a();
        }
        bVar.f250m = dVar2.h;
        bVar.f251n = gVar;
        View view = mVar.r;
        if (view != null) {
            bVar.f243e = view;
        } else {
            bVar.f241c = mVar.f490q;
            bVar.f242d = mVar.f489p;
        }
        bVar.f248k = gVar;
        androidx.appcompat.app.f fVarA = aVar.a();
        gVar.f499b = fVarA;
        fVarA.setOnDismissListener(gVar);
        WindowManager.LayoutParams attributes = gVar.f499b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        gVar.f499b.show();
        j.a aVar2 = this.f470e;
        if (aVar2 == null) {
            return true;
        }
        aVar2.b(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean g(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void h(Context context, f fVar) {
        if (this.f466a != null) {
            this.f466a = context;
            if (this.f467b == null) {
                this.f467b = LayoutInflater.from(context);
            }
        }
        this.f468c = fVar;
        a aVar = this.h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f468c.q(this.h.getItem(i10), this, 0);
    }
}
