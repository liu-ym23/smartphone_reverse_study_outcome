package stepos.support.v7.app;

import android.content.Context;
import stepos.support.v7.app.e;
import stepos.support.v7.app.g0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c0 implements e.a.InterfaceC0143a<g0.b> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f12098a;

    public c0(g0 g0Var) {
        this.f12098a = g0Var;
    }

    @Override // stepos.support.v7.app.e.a.InterfaceC0143a
    public final e newDialog(Context context, int i10) {
        g0.a aVar = this.f12098a.f12115j;
        g0.b bVar = new g0.b(context, i10);
        bVar.f12122a = aVar;
        return bVar;
    }
}
