package z1;

import android.graphics.Typeface;
import p7.p;
import v1.r;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements p {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f11757f;

    public /* synthetic */ c(d dVar) {
        this.f11757f = dVar;
    }

    @Override // p7.p
    public final Object u(Object obj, Object obj2, Object obj3, Object obj4) {
        d dVar = this.f11757f;
        r rVarB = ((v1.e) dVar.f11762j).b((v1.p) obj, (v1.k) obj2, ((v1.i) obj3).f10355a, ((v1.j) obj4).f10356a);
        if (rVarB instanceof r) {
            Object obj5 = rVarB.f10376f;
            q7.k.c(obj5, "null cannot be cast to non-null type android.graphics.Typeface");
            return (Typeface) obj5;
        }
        u5.h hVar = new u5.h(rVarB, dVar.f11767o);
        dVar.f11767o = hVar;
        Object obj6 = hVar.f10131c;
        q7.k.c(obj6, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj6;
    }
}
