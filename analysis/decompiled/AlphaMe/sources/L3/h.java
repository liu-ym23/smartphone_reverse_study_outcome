package L3;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.stepos.alphame.R;
import k.C0656j;
import k.DialogInterfaceOnKeyListenerC0662p;
import stepos.support.v7.view.menu.ExpandedMenuView;

/* loaded from: classes2.dex */
public final class h implements w, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f1274a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f1275b;

    /* renamed from: c, reason: collision with root package name */
    public k f1276c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f1277d;

    /* renamed from: e, reason: collision with root package name */
    public v f1278e;

    /* renamed from: f, reason: collision with root package name */
    public C0656j f1279f;

    public h(Context context) {
        this.f1274a = context;
        this.f1275b = LayoutInflater.from(context);
    }

    @Override // L3.w
    public final void a() {
        C0656j c0656j = this.f1279f;
        if (c0656j != null) {
            c0656j.notifyDataSetChanged();
        }
    }

    public final C0656j b() {
        if (this.f1279f == null) {
            this.f1279f = new C0656j(this);
        }
        return this.f1279f;
    }

    @Override // L3.w
    public final boolean c() {
        return false;
    }

    @Override // L3.w
    public final void d(k kVar, boolean z4) {
        v vVar = this.f1278e;
        if (vVar != null) {
            vVar.d(kVar, z4);
        }
    }

    @Override // L3.w
    public final boolean e(A a4) throws Resources.NotFoundException {
        if (!a4.hasVisibleItems()) {
            return false;
        }
        new DialogInterfaceOnKeyListenerC0662p(a4, 1).a();
        v vVar = this.f1278e;
        if (vVar != null) {
            vVar.g(a4);
        }
        return true;
    }

    @Override // L3.w
    public final boolean f(l lVar) {
        return false;
    }

    @Override // L3.w
    public final void g(Context context, k kVar) {
        if (this.f1274a != null) {
            this.f1274a = context;
            if (this.f1275b == null) {
                this.f1275b = LayoutInflater.from(context);
            }
        }
        this.f1276c = kVar;
        C0656j c0656j = this.f1279f;
        if (c0656j != null) {
            c0656j.notifyDataSetChanged();
        }
    }

    @Override // L3.w
    public final boolean h(l lVar) {
        return false;
    }

    public final y i(ViewGroup viewGroup) {
        if (this.f1277d == null) {
            this.f1277d = (ExpandedMenuView) this.f1275b.inflate(R.layout.stepos_expanded_menu_layout, viewGroup, false);
            if (this.f1279f == null) {
                this.f1279f = new C0656j(this);
            }
            this.f1277d.setAdapter((ListAdapter) this.f1279f);
            this.f1277d.setOnItemClickListener(this);
        }
        return this.f1277d;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        this.f1276c.p(this.f1279f.b(i4), this, 0);
    }
}
