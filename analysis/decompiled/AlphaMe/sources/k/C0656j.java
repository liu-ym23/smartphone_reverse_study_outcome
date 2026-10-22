package k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.stepos.alphame.R;
import java.util.ArrayList;

/* renamed from: k.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0656j extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13222a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f13223b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdapterView.OnItemClickListener f13224c;

    public C0656j(L3.h hVar) {
        this.f13224c = hVar;
        a();
    }

    public final void a() {
        int i4 = this.f13222a;
        int i5 = 0;
        AdapterView.OnItemClickListener onItemClickListener = this.f13224c;
        switch (i4) {
            case 0:
                C0661o c0661o = ((C0657k) onItemClickListener).f13227c;
                C0663q c0663q = c0661o.f13259v;
                if (c0663q != null) {
                    c0661o.i();
                    ArrayList arrayList = c0661o.f13247j;
                    int size = arrayList.size();
                    while (i5 < size) {
                        if (((C0663q) arrayList.get(i5)) == c0663q) {
                            this.f13223b = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                this.f13223b = -1;
                break;
            default:
                L3.k kVar = ((L3.h) onItemClickListener).f1276c;
                L3.l lVar = kVar.f1300t;
                if (lVar != null) {
                    kVar.i();
                    ArrayList arrayList2 = kVar.f1289i;
                    int size2 = arrayList2.size();
                    while (i5 < size2) {
                        if (((L3.l) arrayList2.get(i5)) == lVar) {
                            this.f13223b = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
                this.f13223b = -1;
                break;
        }
    }

    public final L3.l b(int i4) {
        AdapterView.OnItemClickListener onItemClickListener = this.f13224c;
        L3.k kVar = ((L3.h) onItemClickListener).f1276c;
        kVar.i();
        ArrayList arrayList = kVar.f1289i;
        ((L3.h) onItemClickListener).getClass();
        int i5 = this.f13223b;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (L3.l) arrayList.get(i4);
    }

    public final C0663q c(int i4) {
        AdapterView.OnItemClickListener onItemClickListener = this.f13224c;
        C0661o c0661o = ((C0657k) onItemClickListener).f13227c;
        c0661o.i();
        ArrayList arrayList = c0661o.f13247j;
        ((C0657k) onItemClickListener).getClass();
        int i5 = this.f13223b;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (C0663q) arrayList.get(i4);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        int i4 = this.f13222a;
        AdapterView.OnItemClickListener onItemClickListener = this.f13224c;
        switch (i4) {
            case 0:
                C0661o c0661o = ((C0657k) onItemClickListener).f13227c;
                c0661o.i();
                int size = c0661o.f13247j.size();
                return this.f13223b < 0 ? size : size - 1;
            default:
                L3.k kVar = ((L3.h) onItemClickListener).f1276c;
                kVar.i();
                int size2 = kVar.f1289i.size();
                return this.f13223b < 0 ? size2 : size2 - 1;
        }
    }

    @Override // android.widget.Adapter
    public final /* bridge */ /* synthetic */ Object getItem(int i4) {
        switch (this.f13222a) {
            case 0:
                return c(i4);
            default:
                return b(i4);
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        switch (this.f13222a) {
        }
        return i4;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        int i5 = this.f13222a;
        AdapterView.OnItemClickListener onItemClickListener = this.f13224c;
        switch (i5) {
            case 0:
                if (view == null) {
                    view = ((C0657k) onItemClickListener).f13226b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
                }
                ((InterfaceC0641B) view).c(c(i4));
                break;
            default:
                if (view == null) {
                    view = ((L3.h) onItemClickListener).f1275b.inflate(R.layout.stepos_list_menu_item_layout, viewGroup, false);
                }
                ((L3.x) view).d(b(i4));
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        switch (this.f13222a) {
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

    public C0656j(C0657k c0657k) {
        this.f13224c = c0657k;
        a();
    }
}
