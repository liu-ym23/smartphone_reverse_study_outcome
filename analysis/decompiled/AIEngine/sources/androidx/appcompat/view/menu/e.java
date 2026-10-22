package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final f f473a;

    /* renamed from: b, reason: collision with root package name */
    public int f474b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f475c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f476d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f477e;
    public final int h;

    public e(f fVar, LayoutInflater layoutInflater, boolean z, int i10) {
        this.f476d = z;
        this.f477e = layoutInflater;
        this.f473a = fVar;
        this.h = i10;
        b();
    }

    public final void b() {
        f fVar = this.f473a;
        h hVar = fVar.z;
        if (hVar != null) {
            fVar.i();
            ArrayList<h> arrayList = fVar.f486m;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayList.get(i10) == hVar) {
                    this.f474b = i10;
                    return;
                }
            }
        }
        this.f474b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final h getItem(int i10) {
        ArrayList<h> arrayListL;
        boolean z = this.f476d;
        f fVar = this.f473a;
        if (z) {
            fVar.i();
            arrayListL = fVar.f486m;
        } else {
            arrayListL = fVar.l();
        }
        int i11 = this.f474b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return arrayListL.get(i10);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<h> arrayListL;
        boolean z = this.f476d;
        f fVar = this.f473a;
        if (z) {
            fVar.i();
            arrayListL = fVar.f486m;
        } else {
            arrayListL = fVar.l();
        }
        return this.f474b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.f477e.inflate(this.h, viewGroup, false);
        }
        int i11 = getItem(i10).f502b;
        int i12 = i10 - 1;
        int i13 = i12 >= 0 ? getItem(i12).f502b : i11;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f473a.m() && i11 != i13) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        k.a aVar = (k.a) view;
        if (this.f475c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i10));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
