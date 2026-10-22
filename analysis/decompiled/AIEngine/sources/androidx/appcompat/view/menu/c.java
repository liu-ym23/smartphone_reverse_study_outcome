package androidx.appcompat.view.menu;

import androidx.appcompat.view.menu.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.d f462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f463b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f464c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b.c f465d;

    public c(b.c cVar, b.d dVar, h hVar, f fVar) {
        this.f465d = cVar;
        this.f462a = dVar;
        this.f463b = hVar;
        this.f464c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = b.this;
        b.d dVar = this.f462a;
        if (dVar != null) {
            bVar.C = true;
            dVar.f460b.c(false);
            bVar.C = false;
        }
        h hVar = this.f463b;
        if (hVar.isEnabled() && hVar.hasSubMenu()) {
            this.f464c.q(hVar, null, 4);
        }
    }
}
