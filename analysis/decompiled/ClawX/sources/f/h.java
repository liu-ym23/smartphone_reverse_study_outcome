package f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final j f2448a;

    /* renamed from: b, reason: collision with root package name */
    public int f2449b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2450c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f2451e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2452f;

    public h(j jVar, LayoutInflater layoutInflater, boolean z, int i8) {
        this.d = z;
        this.f2451e = layoutInflater;
        this.f2448a = jVar;
        this.f2452f = i8;
        a();
    }

    public final void a() {
        j jVar = this.f2448a;
        k kVar = jVar.f2471s;
        if (kVar != null) {
            jVar.i();
            ArrayList arrayList = jVar.f2462j;
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                if (((k) arrayList.get(i8)) == kVar) {
                    this.f2449b = i8;
                    return;
                }
            }
        }
        this.f2449b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final k getItem(int i8) {
        ArrayList arrayListK;
        boolean z = this.d;
        j jVar = this.f2448a;
        if (z) {
            jVar.i();
            arrayListK = jVar.f2462j;
        } else {
            arrayListK = jVar.k();
        }
        int i9 = this.f2449b;
        if (i9 >= 0 && i8 >= i9) {
            i8++;
        }
        return (k) arrayListK.get(i8);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListK;
        boolean z = this.d;
        j jVar = this.f2448a;
        if (z) {
            jVar.i();
            arrayListK = jVar.f2462j;
        } else {
            arrayListK = jVar.k();
        }
        return this.f2449b < 0 ? arrayListK.size() : arrayListK.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i8) {
        return i8;
    }

    @Override // android.widget.Adapter
    public final View getView(int i8, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.f2451e.inflate(this.f2452f, viewGroup, false);
        }
        int i9 = getItem(i8).f2474b;
        int i10 = i8 - 1;
        int i11 = i10 >= 0 ? getItem(i10).f2474b : i9;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f2448a.l() && i9 != i11) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        q qVar = (q) view;
        if (this.f2450c) {
            listMenuItemView.setForceShowIcon(true);
        }
        qVar.b(getItem(i8));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
