package com.bytedance.android.sdk.bdticketguard;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes12.dex */
public final class x implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f164096a;

    public x(CountDownLatch r100) {
        this.f164096a = r100;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.m
    public final void a(String r100, String r101) {
        int r102 = r0.f163979a;
        r0.c("MainTicketGuardManager", "doAttestation requestCert callback, resClientCert=" + r100 + ", resServerCert=" + r101);
        this.f164096a.countDown();
    }
}
