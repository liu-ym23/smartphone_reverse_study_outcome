package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.b0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public class RequestFinishedInfoImpl extends com.ttnet.org.chromium.net.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection f18729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ttnet.org.chromium.net.t.b f18730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0 f18732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CronetException f18733f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    public RequestFinishedInfoImpl(String r10, Collection r11, com.ttnet.org.chromium.net.t.b r12, int r13, b0 r14, CronetException r15) {
        this.f18728a = r10;
        this.f18729b = r11;
        this.f18730c = r12;
        this.f18731d = r13;
        this.f18732e = r14;
        this.f18733f = r15;
    }

    @Override // com.ttnet.org.chromium.net.t
    public CronetException a() {
        return this.f18733f;
    }

    @Override // com.ttnet.org.chromium.net.t
    public int b() {
        return this.f18731d;
    }

    @Override // com.ttnet.org.chromium.net.t
    public com.ttnet.org.chromium.net.t.b c() {
        return this.f18730c;
    }

    @Override // com.ttnet.org.chromium.net.t
    public b0 d() {
        return this.f18732e;
    }

    @Override // com.ttnet.org.chromium.net.t
    public String e() {
        return this.f18728a;
    }
}
