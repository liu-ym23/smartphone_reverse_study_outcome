package com.ttnet.org.chromium.net.impl;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TTWebsocketConnectionBuilderImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class ae extends com.ttnet.org.chromium.net.ae.a {
    private static final String TAG = "ae";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f38099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.ae.b f38100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f38101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f38102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38103e;
    private String f;
    private long g;
    private int h;
    private long i;
    private String j;
    private int k;
    private String l;
    private Map<String, String> m;
    private Map<String, String> n;
    private boolean o;
    private boolean p;

    static {
    }

    ae(com.ttnet.org.chromium.net.ae.b r3, Executor r4, d r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.o = true;
        this.p = true;
        a(TAG, "TTWebsocketConnectionBuilderImpl");
        this.f38099a = r5;
        this.f38100b = r3;
        this.f38101c = r6;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a a(List<String> r3) {
        this.f38102d = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a a(int r1) {
        this.f38103e = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a a(String r1) {
        this.f = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a a(long r1) {
        this.g = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a b(int r1) {
        this.h = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a b(long r1) {
        this.i = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a b(String r1) {
        this.j = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a c(int r1) {
        this.k = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a a(Map<String, String> r3) {
        this.m = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a b(Map<String, String> r3) {
        this.n = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a a(boolean r1) {
        this.o = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae.a b(boolean r1) {
        this.p = r1;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ae.a
    public com.ttnet.org.chromium.net.ae a() {
        if (this.p == false) goto L7;
        return this.f38099a.a(this.f38100b, this.f38101c, this.f38102d, this.f38103e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    L7:
        return this.f38099a.a(this.f38100b, this.f38101c, this.f38102d, this.m, this.n, this.o);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
