package com.stepos.core.ota.downloader;

import ad.k;
import ad.t;
import kotlin.jvm.internal.g;
import okhttp3.Response;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThrottleInterceptor implements k {
    @Override // ad.k
    public Response intercept(k.a chain) {
        g.f(chain, "chain");
        Response responseB = chain.b(chain.a());
        t tVar = responseB.f10893j;
        if (tVar == null) {
            return responseB;
        }
        bd.g gVar = new bd.g(tVar.o(), tVar.a(), new z(new ThrottledSource(tVar.w())));
        Response.Builder builder = new Response.Builder(responseB);
        builder.f10907g = gVar;
        return builder.a();
    }
}
