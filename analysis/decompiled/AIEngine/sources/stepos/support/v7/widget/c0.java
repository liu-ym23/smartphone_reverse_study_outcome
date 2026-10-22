package stepos.support.v7.widget;

import android.view.View;
import stepos.support.v7.widget.Toolbar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Toolbar f12710a;

    public c0(Toolbar toolbar) {
        this.f12710a = toolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Toolbar.d dVar = this.f12710a.P;
        stepos.support.v7.view.menu.e eVar = dVar == null ? null : dVar.f12672b;
        if (eVar != null) {
            eVar.collapseActionView();
        }
    }
}
