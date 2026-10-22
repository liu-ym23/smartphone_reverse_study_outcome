package k;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* renamed from: k.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0657k implements InterfaceC0640A, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f13225a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f13226b;

    /* renamed from: c, reason: collision with root package name */
    public C0661o f13227c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f13228d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0672z f13229e;

    /* renamed from: f, reason: collision with root package name */
    public C0656j f13230f;

    public C0657k(Context context) {
        this.f13225a = context;
        this.f13226b = LayoutInflater.from(context);
    }

    @Override // k.InterfaceC0640A
    public final void a() {
        C0656j c0656j = this.f13230f;
        if (c0656j != null) {
            c0656j.notifyDataSetChanged();
        }
    }

    @Override // k.InterfaceC0640A
    public final void b(C0661o c0661o, boolean z4) {
        InterfaceC0672z interfaceC0672z = this.f13229e;
        if (interfaceC0672z != null) {
            interfaceC0672z.b(c0661o, z4);
        }
    }

    @Override // k.InterfaceC0640A
    public final boolean c() {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final boolean d(C0663q c0663q) {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final boolean f(SubMenuC0646G subMenuC0646G) throws Resources.NotFoundException {
        int i4 = 0;
        if (!subMenuC0646G.hasVisibleItems()) {
            return false;
        }
        new DialogInterfaceOnKeyListenerC0662p(subMenuC0646G, i4).a();
        InterfaceC0672z interfaceC0672z = this.f13229e;
        if (interfaceC0672z == null) {
            return true;
        }
        interfaceC0672z.f(subMenuC0646G);
        return true;
    }

    @Override // k.InterfaceC0640A
    public final boolean h(C0663q c0663q) {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final void j(InterfaceC0672z interfaceC0672z) {
        this.f13229e = interfaceC0672z;
    }

    @Override // k.InterfaceC0640A
    public final void k(Context context, C0661o c0661o) {
        if (this.f13225a != null) {
            this.f13225a = context;
            if (this.f13226b == null) {
                this.f13226b = LayoutInflater.from(context);
            }
        }
        this.f13227c = c0661o;
        C0656j c0656j = this.f13230f;
        if (c0656j != null) {
            c0656j.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        this.f13227c.q(this.f13230f.c(i4), this, 0);
    }
}
