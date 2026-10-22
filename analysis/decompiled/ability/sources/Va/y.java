package Va;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.stepos.ability.R;
import java.util.ArrayList;
import stepos.support.v7.view.menu.ListMenuItemView;

/* loaded from: classes4.dex */
public final class y extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final n f1465a;
    public int b = -1;
    public final /* synthetic */ z c;

    public y(z zVar, n nVar) {
        this.c = zVar;
        this.f1465a = nVar;
        a();
    }

    public final void a() {
        n nVar = this.c.c;
        q qVar = nVar.f1447t;
        if (qVar != null) {
            nVar.i();
            ArrayList arrayList = nVar.i;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((q) arrayList.get(i)) == qVar) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final q getItem(int i) {
        ArrayList arrayListL;
        boolean z10 = this.c.e;
        n nVar = this.f1465a;
        if (z10) {
            nVar.i();
            arrayListL = nVar.i;
        } else {
            arrayListL = nVar.l();
        }
        int i6 = this.b;
        if (i6 >= 0 && i >= i6) {
            i++;
        }
        return (q) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z10 = this.c.e;
        n nVar = this.f1465a;
        if (z10) {
            nVar.i();
            arrayListL = nVar.i;
        } else {
            arrayListL = nVar.l();
        }
        return this.b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        z zVar = this.c;
        if (view == null) {
            view = zVar.b.inflate(R.layout.stepos_popup_menu_item_layout, viewGroup, false);
        }
        view.setTag(Integer.valueOf(i));
        C c = (C) view.findViewById(R.id.lmiv_container);
        int i6 = zVar.f1468q;
        if (i6 > 0) {
            c.setTitleMaxLines(i6);
        }
        if (zVar.l) {
            ((ListMenuItemView) c).setForceShowIcon(true);
        }
        c.a(getItem(i));
        int count = getCount();
        int dimensionPixelSize = zVar.f1466a.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_item_padding_ext);
        if (count == 1) {
            view.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            return view;
        }
        if (i == 0) {
            view.setPadding(0, dimensionPixelSize, 0, 0);
            return view;
        }
        if (i == count - 1) {
            view.setPadding(0, 0, 0, dimensionPixelSize);
            return view;
        }
        view.setPadding(0, 0, 0, 0);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        q item = getItem(i);
        return item == null ? super.isEnabled(i) : item.isEnabled();
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
