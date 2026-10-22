package com.stepos.policy.sdk.util;

import ad.k;
import ad.n;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Lambda;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyHtmlLoader$httpClient$2 extends Lambda implements zb.a<n> {
    public static final PolicyHtmlLoader$httpClient$2 INSTANCE = new PolicyHtmlLoader$httpClient$2();

    public PolicyHtmlLoader$httpClient$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response invoke$lambda$0(k.a aVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return aVar.b(aVar.a());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // zb.a
    public final n invoke() {
        n.a aVar = new n.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.b(10L, timeUnit);
        aVar.c(30L, timeUnit);
        aVar.a(new c());
        return new n(aVar);
    }
}
