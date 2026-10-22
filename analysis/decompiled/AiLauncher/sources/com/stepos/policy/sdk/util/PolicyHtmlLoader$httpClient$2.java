package com.stepos.policy.sdk.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import p9.InterfaceC5063a;
import tb.C5530C;
import tb.w;
import tb.z;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ltb/z;", "kotlin.jvm.PlatformType", "invoke", "()Ltb/z;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class PolicyHtmlLoader$httpClient$2 extends Lambda implements InterfaceC5063a<z> {
    public static final PolicyHtmlLoader$httpClient$2 INSTANCE = new PolicyHtmlLoader$httpClient$2();

    public PolicyHtmlLoader$httpClient$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C5530C invoke$lambda$0(w.a aVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return aVar.i(aVar.getRequest());
    }

    @Override // p9.InterfaceC5063a
    public final z invoke() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(10L, timeUnit).T(30L, timeUnit).a(new w() { // from class: com.stepos.policy.sdk.util.d
            @Override // tb.w
            public final C5530C intercept(w.a aVar2) {
                return PolicyHtmlLoader$httpClient$2.invoke$lambda$0(aVar2);
            }
        }).d();
    }
}
