package fb;

import ab.q;
import ab.w;
import ab.z;
import c1.o;
import eb.i;
import java.util.ArrayList;
import q7.k;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final i f3649a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3650b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3651c;

    /* renamed from: d, reason: collision with root package name */
    public final o f3652d;

    /* renamed from: e, reason: collision with root package name */
    public final w f3653e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3654f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3655g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3656h;

    /* renamed from: i, reason: collision with root package name */
    public int f3657i;

    public g(i iVar, ArrayList arrayList, int i2, o oVar, w wVar, int i10, int i11, int i12) {
        k.e(wVar, "request");
        this.f3649a = iVar;
        this.f3650b = arrayList;
        this.f3651c = i2;
        this.f3652d = oVar;
        this.f3653e = wVar;
        this.f3654f = i10;
        this.f3655g = i11;
        this.f3656h = i12;
    }

    public static g a(g gVar, int i2, o oVar, w wVar, int i10) {
        if ((i10 & 1) != 0) {
            i2 = gVar.f3651c;
        }
        int i11 = i2;
        if ((i10 & 2) != 0) {
            oVar = gVar.f3652d;
        }
        o oVar2 = oVar;
        if ((i10 & 4) != 0) {
            wVar = gVar.f3653e;
        }
        w wVar2 = wVar;
        int i12 = gVar.f3654f;
        int i13 = gVar.f3655g;
        int i14 = gVar.f3656h;
        k.e(wVar2, "request");
        return new g(gVar.f3649a, gVar.f3650b, i11, oVar2, wVar2, i12, i13, i14);
    }

    public final z b(w wVar) {
        k.e(wVar, "request");
        ArrayList arrayList = this.f3650b;
        int size = arrayList.size();
        int i2 = this.f3651c;
        if (i2 >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.f3657i++;
        o oVar = this.f3652d;
        if (oVar != null) {
            if (!((eb.e) oVar.f1835c).b(wVar.f661a)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i2 - 1) + " must retain the same host and port").toString());
            }
            if (this.f3657i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i2 - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i10 = i2 + 1;
        g gVarA = a(this, i10, null, wVar, 58);
        q qVar = (q) arrayList.get(i2);
        z zVarA = qVar.a(gVarA);
        if (zVarA == null) {
            throw new NullPointerException("interceptor " + qVar + " returned null");
        }
        if (oVar != null && i10 < arrayList.size() && gVarA.f3657i != 1) {
            throw new IllegalStateException(("network interceptor " + qVar + " must call proceed() exactly once").toString());
        }
        if (zVarA.f690l != null) {
            return zVarA;
        }
        throw new IllegalStateException(("interceptor " + qVar + " returned a response with no body").toString());
    }
}
