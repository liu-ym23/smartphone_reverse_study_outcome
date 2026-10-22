package L3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.stepos.alphame.R;
import java.util.ArrayList;
import stepos.support.v7.view.menu.ListMenuItemView;

/* loaded from: classes2.dex */
public final class t extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final k f1338a;

    /* renamed from: b, reason: collision with root package name */
    public int f1339b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f1340c;

    public t(u uVar, k kVar) {
        this.f1340c = uVar;
        this.f1338a = kVar;
        a();
    }

    public final void a() {
        k kVar = this.f1340c.f1343c;
        l lVar = kVar.f1300t;
        if (lVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f1289i;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((l) arrayList.get(i4)) == lVar) {
                    this.f1339b = i4;
                    return;
                }
            }
        }
        this.f1339b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final l getItem(int i4) {
        ArrayList arrayListL;
        boolean z4 = this.f1340c.f1345e;
        k kVar = this.f1338a;
        if (z4) {
            kVar.i();
            arrayListL = kVar.f1289i;
        } else {
            arrayListL = kVar.l();
        }
        int i5 = this.f1339b;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (l) arrayListL.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z4 = this.f1340c.f1345e;
        k kVar = this.f1338a;
        if (z4) {
            kVar.i();
            arrayListL = kVar.f1289i;
        } else {
            arrayListL = kVar.l();
        }
        return this.f1339b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        u uVar = this.f1340c;
        if (view == null) {
            view = uVar.f1342b.inflate(R.layout.stepos_popup_menu_item_layout, viewGroup, false);
        }
        view.setTag(Integer.valueOf(i4));
        x xVar = (x) view.findViewById(R.id.lmiv_container);
        int i5 = uVar.f1358r;
        if (i5 > 0) {
            xVar.setTitleMaxLines(i5);
        }
        if (uVar.f1353m) {
            ((ListMenuItemView) xVar).setForceShowIcon(true);
        }
        xVar.d(getItem(i4));
        int count = getCount();
        int dimensionPixelSize = uVar.f1341a.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_item_padding_ext);
        if (count == 1) {
            view.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        } else if (i4 == 0) {
            view.setPadding(0, dimensionPixelSize, 0, 0);
        } else if (i4 == count - 1) {
            view.setPadding(0, 0, 0, dimensionPixelSize);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i4) {
        l item = getItem(i4);
        return item == null ? super.isEnabled(i4) : item.isEnabled();
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
