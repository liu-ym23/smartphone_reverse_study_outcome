package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    e f7869a;

    /* renamed from: b, reason: collision with root package name */
    private int f7870b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7871c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f7872d;

    /* renamed from: e, reason: collision with root package name */
    private final LayoutInflater f7873e;

    /* renamed from: f, reason: collision with root package name */
    private final int f7874f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z5, int i5) {
        this.f7872d = z5;
        this.f7873e = layoutInflater;
        this.f7869a = eVar;
        this.f7874f = i5;
        a();
    }

    void a() {
        g gVarV = this.f7869a.v();
        if (gVarV != null) {
            ArrayList<g> arrayListZ = this.f7869a.z();
            int size = arrayListZ.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (arrayListZ.get(i5) == gVarV) {
                    this.f7870b = i5;
                    return;
                }
            }
        }
        this.f7870b = -1;
    }

    public e b() {
        return this.f7869a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i5) {
        ArrayList<g> arrayListZ = this.f7872d ? this.f7869a.z() : this.f7869a.E();
        int i6 = this.f7870b;
        if (i6 >= 0 && i5 >= i6) {
            i5++;
        }
        return arrayListZ.get(i5);
    }

    public void d(boolean z5) {
        this.f7871c = z5;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7870b < 0 ? (this.f7872d ? this.f7869a.z() : this.f7869a.E()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7873e.inflate(this.f7874f, viewGroup, false);
        }
        int groupId = getItem(i5).getGroupId();
        int i6 = i5 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f7869a.G() && groupId != (i6 >= 0 ? getItem(i6).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f7871c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.f(getItem(i5), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
