package com.stepos.core.common.net;

import ad.k;
import com.stepos.core.cta.CTAPermissionManager;
import h0.e;
import kotlin.jvm.internal.g;
import okhttp3.Response;
import okhttp3.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaNetworkInterceptor implements k {
    @Override // ad.k
    public Response intercept(k.a chain) throws CtaNotGrantedException {
        g.f(chain, "chain");
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            return chain.b(chain.a());
        }
        h hVarA = chain.a();
        String str = hVarA.f10993b;
        okhttp3.g gVar = hVarA.f10992a;
        throw new CtaNotGrantedException(e.c("blocked by CTA gate (not granted): ", str, " ", gVar.f10980d, gVar.b()));
    }
}
