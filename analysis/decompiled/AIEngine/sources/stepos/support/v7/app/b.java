package stepos.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import stepos.support.v7.app.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f12074a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a f12075b;

    public b(c.a aVar, c cVar) {
        this.f12075b = aVar;
        this.f12074a = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        stepos.support.v7.view.menu.d dVar = this.f12075b.f12093n;
        p pVar = this.f12074a.f12078a;
        dVar.onClick(pVar, i10);
        pVar.dismiss();
    }
}
