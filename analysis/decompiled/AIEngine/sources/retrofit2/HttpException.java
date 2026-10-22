package retrofit2;

import okhttp3.Response;
import xd.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class HttpException extends RuntimeException {
    public HttpException(r<?> rVar) {
        StringBuilder sb2 = new StringBuilder("HTTP ");
        Response response = rVar.f13907a;
        sb2.append(response.f10891d);
        sb2.append(" ");
        sb2.append(response.f10890c);
        super(sb2.toString());
    }
}
