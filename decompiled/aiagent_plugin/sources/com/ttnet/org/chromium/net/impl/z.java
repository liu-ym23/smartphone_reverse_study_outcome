package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: compiled from: RequestFinishedInfoImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class z extends com.ttnet.org.chromium.net.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f38243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<Object> f38244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.w.b f38245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f38246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final aj f38247e;
    private final com.ttnet.org.chromium.net.e f;

    public z(String r3, Collection<Object> r4, com.ttnet.org.chromium.net.w.b r5, int r6, aj r7, com.ttnet.org.chromium.net.e r8) {
        Collection<Object> r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        this.f38243a = r3;
        this.f38244b = r9;
        this.f38245c = r5;
        this.f38246d = r6;
        this.f38247e = r7;
        this.f = r8;
    }

    @Override // com.ttnet.org.chromium.net.w
    public com.ttnet.org.chromium.net.w.b a() {
        return this.f38245c;
    }
}
