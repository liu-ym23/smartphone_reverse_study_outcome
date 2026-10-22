package r1;

import android.graphics.Typeface;
import k4.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends w.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ z f5067e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f5068f;

    public b(d dVar, z zVar) {
        this.f5068f = dVar;
        this.f5067e = zVar;
    }

    @Override // w.b
    public final void d(int i8) {
        this.f5068f.f5084n = true;
        this.f5067e.z(i8);
    }

    @Override // w.b
    public final void e(Typeface typeface) {
        d dVar = this.f5068f;
        dVar.f5086p = Typeface.create(typeface, dVar.d);
        dVar.f5084n = true;
        this.f5067e.A(dVar.f5086p, false);
    }
}
