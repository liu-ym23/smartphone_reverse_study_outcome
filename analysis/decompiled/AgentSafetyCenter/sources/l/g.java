package l;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7568a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f7569b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdapterView.OnItemClickListener f7570c;

    public g(te.i iVar) {
        this.f7570c = iVar;
        a();
    }

    public final void a() {
        switch (this.f7568a) {
            case 0:
                l lVar = ((h) this.f7570c).f7573g;
                n nVar = lVar.f7603v;
                if (nVar != null) {
                    lVar.i();
                    ArrayList arrayList = lVar.f7591j;
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        if (((n) arrayList.get(i)) == nVar) {
                            this.f7569b = i;
                            break;
                        }
                    }
                }
                this.f7569b = -1;
                break;
            default:
                te.l lVar2 = ((te.i) this.f7570c).f13339g;
                te.m mVar = lVar2.f13361t;
                if (mVar != null) {
                    lVar2.i();
                    ArrayList arrayList2 = lVar2.i;
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        if (((te.m) arrayList2.get(i3)) == mVar) {
                            this.f7569b = i3;
                            break;
                        }
                    }
                }
                this.f7569b = -1;
                break;
        }
    }

    public n b(int i) {
        h hVar = (h) this.f7570c;
        l lVar = hVar.f7573g;
        lVar.i();
        ArrayList arrayList = lVar.f7591j;
        hVar.getClass();
        int i3 = this.f7569b;
        if (i3 >= 0 && i >= i3) {
            i++;
        }
        return (n) arrayList.get(i);
    }

    public te.m c(int i) {
        te.l lVar = ((te.i) this.f7570c).f13339g;
        lVar.i();
        ArrayList arrayList = lVar.i;
        int i3 = this.f7569b;
        if (i3 >= 0 && i >= i3) {
            i++;
        }
        return (te.m) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        switch (this.f7568a) {
            case 0:
                h hVar = (h) this.f7570c;
                l lVar = hVar.f7573g;
                lVar.i();
                int size = lVar.f7591j.size();
                hVar.getClass();
                return this.f7569b < 0 ? size : size - 1;
            default:
                te.l lVar2 = ((te.i) this.f7570c).f13339g;
                lVar2.i();
                int size2 = lVar2.i.size();
                return this.f7569b < 0 ? size2 : size2 - 1;
        }
    }

    @Override // android.widget.Adapter
    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        switch (this.f7568a) {
            case 0:
                return b(i);
            default:
                return c(i);
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        switch (this.f7568a) {
        }
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i3 = this.f7568a;
        AdapterView.OnItemClickListener onItemClickListener = this.f7570c;
        switch (i3) {
            case 0:
                if (view == null) {
                    view = ((h) onItemClickListener).f7572f.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
                }
                ((y) view).c(b(i));
                break;
            default:
                if (view == null) {
                    view = ((te.i) onItemClickListener).f13338f.inflate(R.layout.stepos_list_menu_item_layout, viewGroup, false);
                }
                ((te.w) view).d(c(i));
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        switch (this.f7568a) {
            case 0:
                a();
                super.notifyDataSetChanged();
                break;
            default:
                a();
                super.notifyDataSetChanged();
                break;
        }
    }

    public g(h hVar) {
        this.f7570c = hVar;
        a();
    }
}
