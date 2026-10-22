package fd;

import ad.k;
import java.util.ArrayList;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements k.a {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.internal.connection.d f8835a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8836b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8837c;

    /* renamed from: d, reason: collision with root package name */
    public final ed.d f8838d;

    /* renamed from: e, reason: collision with root package name */
    public final okhttp3.h f8839e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8840f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8841g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8842i;

    public f(okhttp3.internal.connection.d dVar, ArrayList arrayList, int i10, ed.d dVar2, okhttp3.h request, int i11, int i12, int i13) {
        kotlin.jvm.internal.g.f(request, "request");
        this.f8835a = dVar;
        this.f8836b = arrayList;
        this.f8837c = i10;
        this.f8838d = dVar2;
        this.f8839e = request;
        this.f8840f = i11;
        this.f8841g = i12;
        this.h = i13;
    }

    public static f d(f fVar, int i10, ed.d dVar, okhttp3.h hVar, int i11) {
        if ((i11 & 1) != 0) {
            i10 = fVar.f8837c;
        }
        int i12 = i10;
        if ((i11 & 2) != 0) {
            dVar = fVar.f8838d;
        }
        ed.d dVar2 = dVar;
        if ((i11 & 4) != 0) {
            hVar = fVar.f8839e;
        }
        okhttp3.h request = hVar;
        int i13 = fVar.f8840f;
        int i14 = fVar.f8841g;
        int i15 = fVar.h;
        kotlin.jvm.internal.g.f(request, "request");
        return new f(fVar.f8835a, fVar.f8836b, i12, dVar2, request, i13, i14, i15);
    }

    @Override // ad.k.a
    public final okhttp3.h a() {
        return this.f8839e;
    }

    @Override // ad.k.a
    public final Response b(okhttp3.h request) {
        kotlin.jvm.internal.g.f(request, "request");
        ArrayList arrayList = this.f8836b;
        int size = arrayList.size();
        int i10 = this.f8837c;
        if (i10 >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.f8842i++;
        ed.d dVar = this.f8838d;
        if (dVar != null) {
            if (!dVar.f8635c.b().d(request.f10992a)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i10 - 1) + " must retain the same host and port").toString());
            }
            if (this.f8842i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i10 - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i11 = i10 + 1;
        f fVarD = d(this, i11, null, request, 58);
        k kVar = (k) arrayList.get(i10);
        Response responseIntercept = kVar.intercept(fVarD);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + kVar + " returned null");
        }
        if (dVar == null || i11 >= arrayList.size() || fVarD.f8842i == 1) {
            return responseIntercept;
        }
        throw new IllegalStateException(("network interceptor " + kVar + " must call proceed() exactly once").toString());
    }

    @Override // ad.k.a
    public final ed.g c() {
        ed.d dVar = this.f8838d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }
}
