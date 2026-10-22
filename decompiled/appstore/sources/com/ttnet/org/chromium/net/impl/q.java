package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class q extends TTNetDiagnosisRequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetEngineBase f18886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TTNetDiagnosisRequest.Callback f18888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f18890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18892g;

    static {
    }

    public q(TTNetDiagnosisRequest.Callback r10, Executor r11, CronetEngineBase r12) {
        this.f18886a = r12;
        this.f18888c = r10;
        this.f18887b = r11;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.a
    public TTNetDiagnosisRequest a() {
        return this.f18886a.N(this.f18888c, this.f18887b, this.f18889d, this.f18890e, this.f18891f, this.f18892g);
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.a
    public TTNetDiagnosisRequest.a b(int r10) {
        this.f18891f = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.a
    public TTNetDiagnosisRequest.a c(int r10) {
        this.f18889d = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.a
    public TTNetDiagnosisRequest.a d(List r10) {
        this.f18890e = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.a
    public TTNetDiagnosisRequest.a e(int r10) {
        this.f18892g = r10;
        return this;
    }
}
