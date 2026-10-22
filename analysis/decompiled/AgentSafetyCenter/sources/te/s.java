package te;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import stepos.support.v7.view.menu.ListMenuItemView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class s extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final l f13394a;

    /* renamed from: b, reason: collision with root package name */
    public int f13395b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f13396c;

    public s(t tVar, l lVar) {
        this.f13396c = tVar;
        this.f13394a = lVar;
        a();
    }

    public final void a() {
        l lVar = this.f13396c.f13399g;
        m mVar = lVar.f13361t;
        if (mVar != null) {
            lVar.i();
            ArrayList arrayList = lVar.i;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((m) arrayList.get(i)) == mVar) {
                    this.f13395b = i;
                    return;
                }
            }
        }
        this.f13395b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i) {
        ArrayList arrayListL;
        boolean z10 = this.f13396c.i;
        l lVar = this.f13394a;
        if (z10) {
            lVar.i();
            arrayListL = lVar.i;
        } else {
            arrayListL = lVar.l();
        }
        int i3 = this.f13395b;
        if (i3 >= 0 && i >= i3) {
            i++;
        }
        return (m) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z10 = this.f13396c.i;
        l lVar = this.f13394a;
        if (z10) {
            lVar.i();
            arrayListL = lVar.i;
        } else {
            arrayListL = lVar.l();
        }
        return this.f13395b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        t tVar = this.f13396c;
        if (view == null) {
            view = tVar.f13398f.inflate(R.layout.stepos_popup_menu_item_layout, viewGroup, false);
        }
        view.setTag(Integer.valueOf(i));
        w wVar = (w) view.findViewById(R.id.lmiv_container);
        int i3 = tVar.f13412u;
        if (i3 > 0) {
            wVar.setTitleMaxLines(i3);
        }
        if (tVar.f13407p) {
            ((ListMenuItemView) wVar).setForceShowIcon(true);
        }
        wVar.d(getItem(i));
        int count = getCount();
        int dimensionPixelSize = tVar.f13397c.getResources().getDimensionPixelSize(R.dimen.stepos_popup_menu_item_padding_ext);
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
        m item = getItem(i);
        return item == null ? super.isEnabled(i) : item.isEnabled();
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
