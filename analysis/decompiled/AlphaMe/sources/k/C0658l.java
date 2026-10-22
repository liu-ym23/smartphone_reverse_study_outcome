package k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* renamed from: k.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0658l extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final C0661o f13231a;

    /* renamed from: b, reason: collision with root package name */
    public int f13232b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13233c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13234d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f13235e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13236f;

    public C0658l(C0661o c0661o, LayoutInflater layoutInflater, boolean z4, int i4) {
        this.f13234d = z4;
        this.f13235e = layoutInflater;
        this.f13231a = c0661o;
        this.f13236f = i4;
        a();
    }

    public final void a() {
        C0661o c0661o = this.f13231a;
        C0663q c0663q = c0661o.f13259v;
        if (c0663q != null) {
            c0661o.i();
            ArrayList arrayList = c0661o.f13247j;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((C0663q) arrayList.get(i4)) == c0663q) {
                    this.f13232b = i4;
                    return;
                }
            }
        }
        this.f13232b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C0663q getItem(int i4) {
        ArrayList arrayListL;
        boolean z4 = this.f13234d;
        C0661o c0661o = this.f13231a;
        if (z4) {
            c0661o.i();
            arrayListL = c0661o.f13247j;
        } else {
            arrayListL = c0661o.l();
        }
        int i5 = this.f13232b;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (C0663q) arrayListL.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z4 = this.f13234d;
        C0661o c0661o = this.f13231a;
        if (z4) {
            c0661o.i();
            arrayListL = c0661o.f13247j;
        } else {
            arrayListL = c0661o.l();
        }
        return this.f13232b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        boolean z4 = false;
        if (view == null) {
            view = this.f13235e.inflate(this.f13236f, viewGroup, false);
        }
        int i5 = getItem(i4).f13270b;
        int i6 = i4 - 1;
        int i7 = i6 >= 0 ? getItem(i6).f13270b : i5;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f13231a.m() && i5 != i7) {
            z4 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z4);
        InterfaceC0641B interfaceC0641B = (InterfaceC0641B) view;
        if (this.f13233c) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC0641B.c(getItem(i4));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
