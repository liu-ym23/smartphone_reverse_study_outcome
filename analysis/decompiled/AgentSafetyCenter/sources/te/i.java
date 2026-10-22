package te;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import stepos.support.v7.view.menu.ExpandedMenuView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class i implements v, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public Context f13337c;

    /* renamed from: f, reason: collision with root package name */
    public LayoutInflater f13338f;

    /* renamed from: g, reason: collision with root package name */
    public l f13339g;

    /* renamed from: h, reason: collision with root package name */
    public ExpandedMenuView f13340h;
    public u i;

    /* renamed from: j, reason: collision with root package name */
    public l.g f13341j;

    public i(ContextWrapper contextWrapper) {
        this.f13337c = contextWrapper;
        this.f13338f = LayoutInflater.from(contextWrapper);
    }

    @Override // te.v
    public final boolean a() {
        return false;
    }

    @Override // te.v
    public final void b(l lVar, boolean z10) {
        u uVar = this.i;
        if (uVar != null) {
            uVar.b(lVar, z10);
        }
    }

    @Override // te.v
    public final void c() {
        l.g gVar = this.f13341j;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // te.v
    public final boolean d(m mVar) {
        return false;
    }

    @Override // te.v
    public final boolean e(m mVar) {
        return false;
    }

    @Override // te.v
    public final void f(Context context, l lVar) {
        if (this.f13337c != null) {
            this.f13337c = context;
            if (this.f13338f == null) {
                this.f13338f = LayoutInflater.from(context);
            }
        }
        this.f13339g = lVar;
        l.g gVar = this.f13341j;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // te.v
    public final boolean g(z zVar) {
        boolean zHasVisibleItems = zVar.hasVisibleItems();
        Context context = zVar.f13343a;
        int i = 0;
        if (!zHasVisibleItems) {
            return false;
        }
        l.m mVar = new l.m(1);
        mVar.f7607f = zVar;
        stepos.support.v7.app.h hVar = new stepos.support.v7.app.h(context, stepos.support.v7.app.i.resolveDialogTheme(context, 0));
        stepos.support.v7.app.d dVar = hVar.f12317a;
        i iVar = new i(dVar.f12293a);
        mVar.f7609h = iVar;
        iVar.i = mVar;
        zVar.b(iVar, context);
        dVar.f12304m = (l.g) ((i) mVar.f7609h).h();
        dVar.f12305n = mVar;
        View view = zVar.f13355n;
        if (view != null) {
            dVar.f12297e = view;
        } else {
            dVar.f12295c = zVar.f13354m;
            dVar.f12296d = zVar.f13353l;
        }
        dVar.f12303l = mVar;
        stepos.support.v7.app.f fVar = new stepos.support.v7.app.f(i);
        fVar.f12315f = hVar;
        VarHandle.storeStoreFence();
        stepos.support.v7.app.i iVarA = hVar.a(fVar);
        mVar.f7608g = iVarA;
        iVarA.setOnDismissListener(mVar);
        WindowManager.LayoutParams attributes = ((stepos.support.v7.app.i) mVar.f7608g).getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        ((stepos.support.v7.app.i) mVar.f7608g).show();
        u uVar = this.i;
        if (uVar != null) {
            uVar.e(zVar);
        }
        return true;
    }

    public final ListAdapter h() {
        if (this.f13341j == null) {
            this.f13341j = new l.g(this);
        }
        return this.f13341j;
    }

    public final x i(ViewGroup viewGroup) {
        if (this.f13340h == null) {
            this.f13340h = (ExpandedMenuView) this.f13338f.inflate(R.layout.stepos_expanded_menu_layout, viewGroup, false);
            if (this.f13341j == null) {
                this.f13341j = new l.g(this);
            }
            this.f13340h.setAdapter((ListAdapter) this.f13341j);
            this.f13340h.setOnItemClickListener(this);
        }
        return this.f13340h;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j10) {
        this.f13339g.p(this.f13341j.c(i), this, 0);
    }
}
