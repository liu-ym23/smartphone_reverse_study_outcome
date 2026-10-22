package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public e f8609a;

    /* renamed from: b, reason: collision with root package name */
    public int f8610b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8611c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8612d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f8613e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8614f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f8612d = z10;
        this.f8613e = layoutInflater;
        this.f8609a = eVar;
        this.f8614f = i10;
        a();
    }

    public void a() {
        g gVarX = this.f8609a.x();
        if (gVarX != null) {
            ArrayList<g> arrayListB = this.f8609a.B();
            int size = arrayListB.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayListB.get(i10) == gVarX) {
                    this.f8610b = i10;
                    return;
                }
            }
        }
        this.f8610b = -1;
    }

    public e b() {
        return this.f8609a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i10) {
        ArrayList<g> arrayListB = this.f8612d ? this.f8609a.B() : this.f8609a.G();
        int i11 = this.f8610b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return arrayListB.get(i10);
    }

    public void d(boolean z10) {
        this.f8611c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8610b < 0 ? (this.f8612d ? this.f8609a.B() : this.f8609a.G()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f8613e.inflate(this.f8614f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f8609a.I() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        j.a aVar = (j.a) view;
        if (this.f8611c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
