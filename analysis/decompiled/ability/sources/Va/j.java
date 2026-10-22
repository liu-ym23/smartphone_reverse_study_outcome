package Va;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.stepos.ability.R;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class j extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public int f1439a = -1;
    public final /* synthetic */ k b;

    public j(k kVar) {
        this.b = kVar;
        a();
    }

    public final void a() {
        n nVar = this.b.c;
        q qVar = nVar.f1447t;
        if (qVar != null) {
            nVar.i();
            ArrayList arrayList = nVar.i;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((q) arrayList.get(i)) == qVar) {
                    this.f1439a = i;
                    return;
                }
            }
        }
        this.f1439a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final q getItem(int i) {
        k kVar = this.b;
        n nVar = kVar.c;
        nVar.i();
        ArrayList arrayList = nVar.i;
        kVar.getClass();
        int i6 = this.f1439a;
        if (i6 >= 0 && i >= i6) {
            i++;
        }
        return (q) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        k kVar = this.b;
        n nVar = kVar.c;
        nVar.i();
        int size = nVar.i.size();
        kVar.getClass();
        return this.f1439a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.b.inflate(R.layout.stepos_list_menu_item_layout, viewGroup, false);
        }
        ((C) view).a(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
