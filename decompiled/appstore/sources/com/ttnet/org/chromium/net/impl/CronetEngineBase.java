package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.w;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CronetEngineBase extends com.ttnet.org.chromium.net.f {

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    public CronetEngineBase() {
    }

    public abstract TTNetDiagnosisRequest N(TTNetDiagnosisRequest.Callback r10, Executor r11, int r12, List r13, int r14, int r15);

    public abstract UrlRequestBase O(String r10, a0.b r11, Executor r12, int r13, Collection r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r110, int r111, com.ttnet.org.chromium.net.t.a r112);

    public abstract w P(w.b r10, Executor r11, List r12, int r13, String r14, long r15, int r16, long r17, String r18, int r19, String r110, Map r111, Map r112, boolean r113);

    public abstract w Q(w.b r10, Executor r11, List r12, Map r13, Map r14, boolean r15);

    public com.ttnet.org.chromium.net.g.a R(String r10, a0.b r11, Executor r12) {
        return new s(r10, r11, r12, this);
    }

    @Override // com.ttnet.org.chromium.net.c
    public TTNetDiagnosisRequest.a b(TTNetDiagnosisRequest.Callback r10, Executor r11) {
        return new q(r10, r11, this);
    }

    @Override // com.ttnet.org.chromium.net.c
    public w.a d(w.b r10, Executor r11) {
        return new r(r10, r11, this);
    }
}
