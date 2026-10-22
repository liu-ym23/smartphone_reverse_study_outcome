package com.stepos.policy.sdk.util;

import C4.A;
import C4.F;
import C4.x;
import i4.InterfaceC0761a;
import j4.l;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class PolicyHtmlLoader$httpClient$2 extends l implements InterfaceC0761a<A> {
    public static final PolicyHtmlLoader$httpClient$2 INSTANCE = new PolicyHtmlLoader$httpClient$2();

    PolicyHtmlLoader$httpClient$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final F invoke$lambda$0(x.a aVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return aVar.b(aVar.a());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // i4.InterfaceC0761a
    public final A invoke() {
        A.b bVar = new A.b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return bVar.c(10L, timeUnit).e(30L, timeUnit).a(new x() { // from class: com.stepos.policy.sdk.util.d
            @Override // C4.x
            public final F a(x.a aVar) {
                return PolicyHtmlLoader$httpClient$2.invoke$lambda$0(aVar);
            }
        }).b();
    }
}
