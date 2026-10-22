package bd;

import ad.t;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {
    public static final void a(String str, Response response) {
        if (response != null) {
            if (response.f10894k != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (response.f10895l != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (response.f10896m != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public static final Response b(Response response) {
        kotlin.jvm.internal.g.f(response, "<this>");
        Response.Builder builder = new Response.Builder(response);
        t tVar = response.f10893j;
        builder.f10907g = new a(tVar.o(), tVar.a());
        return builder.a();
    }
}
