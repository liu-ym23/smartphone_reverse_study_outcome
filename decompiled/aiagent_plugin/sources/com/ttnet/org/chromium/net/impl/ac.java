package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: TTNetDiagnosisRequestBuilderImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class ac extends com.ttnet.org.chromium.net.ac.a {
    private static final String TAG = "ac";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f38084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f38085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.ac.b f38086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f38088e;
    private int f;
    private int g;
    private int h;

    static {
    }

    ac(com.ttnet.org.chromium.net.ac.b r3, Executor r4, d r5) {
        com.ttnet.org.chromium.net.ac.b r6 = (com.ttnet.org.chromium.net.ac.b) ZeusTransformUtils.wrapperContextForParams(r3, com.ttnet.org.chromium.net.ac.b.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.f38084a = r5;
        this.f38086c = r6;
        this.f38085b = r7;
    }

    @Override // com.ttnet.org.chromium.net.ac.a
    public com.ttnet.org.chromium.net.ac.a a(int r1) {
        this.f38087d = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ac.a
    public com.ttnet.org.chromium.net.ac.a a(List<String> r3) {
        this.f38088e = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ac.a
    public com.ttnet.org.chromium.net.ac.a b(int r1) {
        this.f = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ac.a
    public com.ttnet.org.chromium.net.ac.a c(int r1) {
        this.g = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ac.a
    public com.ttnet.org.chromium.net.ac.a d(int r1) {
        this.h = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ac.a
    public com.ttnet.org.chromium.net.ac a() {
        return this.f38084a.a(this.f38086c, this.f38085b, this.f38087d, this.f38088e, this.f, this.g, this.h);
    }
}
