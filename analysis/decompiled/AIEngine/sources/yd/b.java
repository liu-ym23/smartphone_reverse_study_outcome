package yd;

import ad.l;
import ad.s;
import bd.d;
import d5.i;
import d5.u;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import sd.e;
import xd.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<T> implements f<T, s> {

    /* renamed from: i, reason: collision with root package name */
    public static final l f14210i = d.a("application/json; charset=UTF-8");

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f14211j = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public final i f14212g;
    public final u<T> h;

    public b(i iVar, u<T> uVar) {
        this.f14212g = iVar;
        this.h = uVar;
    }

    @Override // xd.f
    public final s a(Object obj) throws IOException {
        e eVar = new e();
        k5.b bVarG = this.f14212g.g(new OutputStreamWriter(new sd.f(eVar), f14211j));
        this.h.b(bVarG, obj);
        bVarG.close();
        return s.create(f14210i, eVar.X(eVar.f11926b));
    }
}
