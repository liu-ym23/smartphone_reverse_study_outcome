package l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final l f7576a;

    /* renamed from: b, reason: collision with root package name */
    public int f7577b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7578c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7579d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f7580e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7581f;

    public i(l lVar, LayoutInflater layoutInflater, boolean z10, int i) {
        this.f7579d = z10;
        this.f7580e = layoutInflater;
        this.f7576a = lVar;
        this.f7581f = i;
        a();
    }

    public final void a() {
        l lVar = this.f7576a;
        n nVar = lVar.f7603v;
        if (nVar != null) {
            lVar.i();
            ArrayList arrayList = lVar.f7591j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((n) arrayList.get(i)) == nVar) {
                    this.f7577b = i;
                    return;
                }
            }
        }
        this.f7577b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final n getItem(int i) {
        ArrayList arrayListL;
        boolean z10 = this.f7579d;
        l lVar = this.f7576a;
        if (z10) {
            lVar.i();
            arrayListL = lVar.f7591j;
        } else {
            arrayListL = lVar.l();
        }
        int i3 = this.f7577b;
        if (i3 >= 0 && i >= i3) {
            i++;
        }
        return (n) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z10 = this.f7579d;
        l lVar = this.f7576a;
        if (z10) {
            lVar.i();
            arrayListL = lVar.f7591j;
        } else {
            arrayListL = lVar.l();
        }
        return this.f7577b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z10 = false;
        if (view == null) {
            view = this.f7580e.inflate(this.f7581f, viewGroup, false);
        }
        int i3 = getItem(i).f7611b;
        int i10 = i - 1;
        int i11 = i10 >= 0 ? getItem(i10).f7611b : i3;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f7576a.m() && i3 != i11) {
            z10 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        y yVar = (y) view;
        if (this.f7578c) {
            listMenuItemView.setForceShowIcon(true);
        }
        yVar.c(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
