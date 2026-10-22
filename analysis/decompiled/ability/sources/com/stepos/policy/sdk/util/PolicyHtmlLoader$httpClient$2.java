package com.stepos.policy.sdk.util;

import F9.E;
import F9.F;
import F9.M;
import F9.z;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LF9/F;", "kotlin.jvm.PlatformType", "invoke", "()LF9/F;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class PolicyHtmlLoader$httpClient$2 extends Lambda implements S7.a {
    public static final PolicyHtmlLoader$httpClient$2 INSTANCE = new PolicyHtmlLoader$httpClient$2();

    public PolicyHtmlLoader$httpClient$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M invoke$lambda$0(z zVar) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        return ((K9.g) zVar).b(((K9.g) zVar).e);
    }

    @Override // S7.a
    public final F invoke() {
        E e = new E();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.b(10L, timeUnit);
        e.c(30L, timeUnit);
        e.a(new c());
        return new F(e);
    }
}
