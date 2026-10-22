package com.stepos.policy.sdk.util;

import ad.v;
import ad.w;
import java.util.concurrent.TimeUnit;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlLoader$httpClient$2 extends l implements xb.a {
    public static final PolicyHtmlLoader$httpClient$2 INSTANCE = new PolicyHtmlLoader$httpClient$2();

    public PolicyHtmlLoader$httpClient$2() {
        super(0);
    }

    @Override // xb.a
    public final w invoke() {
        v vVar = new v();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        vVar.a(10L, timeUnit);
        vVar.f601t = bd.b.b(30L, timeUnit);
        return new w(vVar);
    }
}
