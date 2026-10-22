package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.w;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaCronetEngine extends CronetEngineBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f18710c;

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTNetDiagnosisRequest N(TTNetDiagnosisRequest.Callback r10, Executor r11, int r12, List r13, int r14, int r15) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase O(String r13, a0.b r14, Executor r15, int r16, Collection r17, boolean r18, boolean r19, boolean r20, boolean r21, int r22, boolean r23, int r24, com.ttnet.org.chromium.net.t.a r25) {
        return new j(r14, this.f18710c, r15, r13, this.f18709b, r20, r21, r22, r23, r24);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public w P(w.b r10, Executor r11, List r12, int r13, String r14, long r15, int r16, long r17, String r18, int r19, String r110, Map r111, Map r112, boolean r113) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public w Q(w.b r10, Executor r11, List r12, Map r13, Map r14, boolean r15) {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.c
    public /* bridge */ /* synthetic */ a0.a c(String r10, a0.b r11, Executor r12) {
        return super.R(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.c
    public URLConnection e(URL r10) {
        return r10.openConnection();
    }

    @Override // com.ttnet.org.chromium.net.f
    public void g(com.ttnet.org.chromium.net.t.a r10) {
    }

    @Override // com.ttnet.org.chromium.net.f
    public int m() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int n() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.f
    public void registerEventListener(com.ttnet.org.chromium.net.u r10) {
    }

    @Override // com.ttnet.org.chromium.net.f
    public int s() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.f
    public int v() {
        return -1;
    }
}
