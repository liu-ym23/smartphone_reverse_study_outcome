package K0;

import android.graphics.Matrix;
import com.airbnb.lottie.v;

/* loaded from: classes.dex */
public final class c implements L0.b {

    /* renamed from: a, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f1025a;

    /* renamed from: b, reason: collision with root package name */
    public final d f1026b;

    /* renamed from: c, reason: collision with root package name */
    public final a f1027c;

    /* renamed from: d, reason: collision with root package name */
    public final b f1028d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1029e;

    /* renamed from: f, reason: collision with root package name */
    public final b f1030f;

    /* renamed from: g, reason: collision with root package name */
    public final b f1031g;

    public c(stepos.support.v7.app.palette.b bVar, d dVar, a aVar, b bVar2, a aVar2, b bVar3, b bVar4) {
        this.f1025a = bVar;
        this.f1026b = dVar;
        this.f1027c = aVar;
        this.f1028d = bVar2;
        this.f1029e = aVar2;
        this.f1030f = bVar3;
        this.f1031g = bVar4;
    }

    @Override // L0.b
    public final G0.c a(v vVar, M0.b bVar) {
        return null;
    }

    public final o2.d b() {
        o2.d dVar = new o2.d();
        dVar.f13796a = new Matrix();
        dVar.f13797b = this.f1025a.c();
        dVar.f13798c = this.f1026b.c();
        dVar.f13799d = this.f1027c.c();
        dVar.f13800e = this.f1028d.c();
        dVar.f13801f = this.f1029e.c();
        b bVar = this.f1030f;
        if (bVar != null) {
            dVar.f13802g = bVar.c();
        } else {
            dVar.f13802g = null;
        }
        b bVar2 = this.f1031g;
        if (bVar2 != null) {
            dVar.f13803h = bVar2.c();
        } else {
            dVar.f13803h = null;
        }
        return dVar;
    }
}
